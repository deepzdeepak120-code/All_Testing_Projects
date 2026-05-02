package testCases;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Downloads PDF reports from the MPR Report API using Selenium.
 *
 * Usage:
 *   1. Paste your JWT token in the TOKEN constant.
 *   2. Add request ID → file name mappings in buildDownloadList().
 *   3. Run as a TestNG test. Token is valid for 8 hours on production.
 */
public class PDFReportDownloader {

	private WebDriver driver;

	// ── Configuration ──────────────────────────────────────────────────────────
	private static final String BASE_URL =
			"https://legal.maatrum.com/mpr-report-ui/api/generate-pdf?id=%s&token=%s";

	// Directory where PDFs will be saved
	private static final String DOWNLOAD_DIR =
			System.getProperty("user.dir") + File.separator + "downloaded-reports";

	// Max seconds to wait for a single PDF download to finish
	private static final int DOWNLOAD_TIMEOUT_SECONDS = 60;

	// Pause between consecutive downloads (milliseconds)
	private static final int DELAY_BETWEEN_DOWNLOADS_MS = 2000;

	// ── Single JWT token (valid for 8 hours on production) ───────────────────
	private static final String TOKEN = "eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJ0Yndsekh2RTBYSjJOaXpCUmRlODdSazFKRURwM1ZnYi1mSFljRDFtd2R3In0.eyJleHAiOjE3NzYxMzU1MDcsImlhdCI6MTc3NjA5MjMwNywiYXV0aF90aW1lIjoxNzc2MDkyMzA3LCJqdGkiOiIyN2ViZTFkYi1jZWQ5LTQyN2UtYTk1Yy04Y2Q3ODY3YmEzZTciLCJpc3MiOiJodHRwczovL2FkbWluLm1hYXRydW0uY29tL2F1dGgvcmVhbG1zL21hc3RlciIsImF1ZCI6ImFjY291bnQiLCJzdWIiOiI5ZjNmNTY2YS0yODY0LTQ3NTYtODYxNC0yMGQ3YmE1YTZlZjIiLCJ0eXAiOiJCZWFyZXIiLCJhenAiOiJtYWF0cnVtLXB1YmxpYyIsInNpZCI6IjdlODEzZDljLTQ1NzgtNDkzMS05ZjI2LTVhMTVmMzU4NjFhZiIsImFjciI6IjEiLCJhbGxvd2VkLW9yaWdpbnMiOlsiKiJdLCJyZWFsbV9hY2Nlc3MiOnsicm9sZXMiOlsiZGVmYXVsdC1yb2xlcy1tYXN0ZXIiLCJvZmZsaW5lX2FjY2VzcyIsInVtYV9hdXRob3JpemF0aW9uIl19LCJyZXNvdXJjZV9hY2Nlc3MiOnsiYWNjb3VudCI6eyJyb2xlcyI6WyJtYW5hZ2UtYWNjb3VudCIsIm1hbmFnZS1hY2NvdW50LWxpbmtzIiwidmlldy1wcm9maWxlIl19fSwic2NvcGUiOiJvcGVuaWQgcHJvZmlsZSBlbWFpbCIsImVtYWlsX3ZlcmlmaWVkIjpmYWxzZSwibmFtZSI6IlNyZWVuYXRoIFAiLCJwcmVmZXJyZWRfdXNlcm5hbWUiOiJzcmVlbmF0aC5wQG1hYXRydW0uY29tIiwiZ2l2ZW5fbmFtZSI6IlNyZWVuYXRoIiwiZmFtaWx5X25hbWUiOiJQIiwiZW1haWwiOiJzcmVlbmF0aC5wQG1hYXRydW0uY29tIn0.AyLKS6kZexBGRUGJssDw9Cw8da5BhQPxPKGIn1TW-GYzaPRbwAWipiMMztXd1Gy0-2OPLB5t4THmeiIqrjq75mEn6PpFv_s2T_x8eQSXiLIX9Fg1ZbCL02XgIhzwYtF9IFTuWuI6I2POMb1L2D_xzqn48ZKEJb3ucABRJoxZNTW2Lo-OEiOhHUCNNXiEj8mXRChkoL1eYDRkdQg193-wIywFQDk47_CtkyKAEXSLlANEuz201noNnB6wKYTZ-bMncHcKLNFAMOUkNxUZF0VVYiOsgCm_UOXjZq1i2CxY5YEDxfNBmktqLM4yzYvXM2OR4gLTl_fsDPpsH2Mxh0tE1g";

	// ── Build the download list ────────────────────────────────────────────────
	/**
	 * Add your request IDs and desired file names here.
	 * One shared token is used for all requests (8-hour expiry on production).
	 */
	private Map<String, String> buildDownloadList() {
		// Key = Request ID, Value = Desired file name (without .pdf)
		Map<String, String> entries = new java.util.LinkedHashMap<>();

		entries.put("8512809", "MPR 3 - Positive Report");
		entries.put("8569799", "MPR 3 - Negative Report");
		entries.put("8512806", "MPR 2 - Completed Report");
		entries.put("8567999", "MAR - Positive Report ");    
		entries.put("8565862 ", " MAR - Negative Report ");    
		entries.put("8560309", "MPR 3 - No Doc Case");  
		entries.put("8513206", "MPR 2 - No Doc Case");
		entries.put("8448055", "MPR 3 - Multiple Schedules");
		entries.put("8559562", "MPR 2 - Multiple Schedules");  
		entries.put("8540783", "MAR - Multiple Schedules");   
		entries.put("8562296","MPR3 Interim Report"); 
		
		
		// Add more entries as needed:
		// entries.put("REQUEST_ID", "File Name");

		return entries;
	}

	// ── Setup & Teardown ───────────────────────────────────────────────────────

	@BeforeClass
	public void setup() {
		// Create download directory if it doesn't exist
		File downloadDir = new File(DOWNLOAD_DIR);
		if (!downloadDir.exists()) {
			downloadDir.mkdirs();
			log("Created download directory: " + DOWNLOAD_DIR);
		}

		// Configure Chrome to auto-download PDFs (no preview)
		Map<String, Object> prefs = new HashMap<>();
		prefs.put("download.default_directory", DOWNLOAD_DIR);
		prefs.put("download.prompt_for_download", false);
		prefs.put("download.directory_upgrade", true);
		prefs.put("plugins.always_open_pdf_externally", true);           // skip PDF viewer
		prefs.put("profile.default_content_settings.popups", 0);
		prefs.put("safebrowsing.enabled", true);

		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
		options.addArguments("--disable-gpu");
		options.addArguments("--no-sandbox");

		driver = new ChromeDriver(options);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(DOWNLOAD_TIMEOUT_SECONDS));
		log("Browser launched with PDF auto-download enabled");
	}

	@AfterClass
	public void teardown() {
		if (driver != null) {
			driver.quit();
			log("Browser closed");
		}
	}

	// ── Main download test ─────────────────────────────────────────────────────

	@Test
	public void downloadAllReports() throws InterruptedException {
		Map<String, String> entries = buildDownloadList();

		int success = 0;
		int failed = 0;

		log("Starting download of " + entries.size() + " report(s)");
		log("Download directory: " + DOWNLOAD_DIR);
		log("─".repeat(60));

		for (Map.Entry<String, String> entry : entries.entrySet()) {
			String requestId = entry.getKey();
			String fileName = entry.getValue();
			String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH-mm"));
			String targetFileName = fileName + " (" + timestamp + ").pdf";

			// Skip if file already exists
			File targetFile = new File(DOWNLOAD_DIR, targetFileName);
			if (targetFile.exists()) {
				log("[SKIP]  \"" + targetFileName + "\" already exists");
				success++;
				continue;
			}

			String url = String.format(BASE_URL, requestId, TOKEN);
			log("[START] Downloading: " + targetFileName + "  (ID: " + requestId + ")");

			try {
				driver.get(url);

				boolean downloaded = waitForDownloadAndRename(targetFileName);

				if (downloaded) {
					log("[OK]    Saved: " + targetFileName);
					success++;
				} else {
					log("[FAIL]  Download timed out or file not found for ID: " + requestId);
					failed++;
				}
			} catch (Exception e) {
				log("[FAIL]  Error downloading ID " + requestId + ": " + e.getMessage());
				failed++;
			}

			Thread.sleep(DELAY_BETWEEN_DOWNLOADS_MS);
		}

		log("─".repeat(60));
		log("Done. Success: " + success + "  |  Failed: " + failed + "  |  Total: " + entries.size());
	}

	// ── Helper methods ─────────────────────────────────────────────────────────

	/**
	 * Waits for a new file to appear in the download directory (Chrome creates .crdownload
	 * partials), then renames it to the desired file name.
	 */
	private boolean waitForDownloadAndRename(String desiredFileName) throws InterruptedException {
		Path downloadPath = Paths.get(DOWNLOAD_DIR);
		long startTime = System.currentTimeMillis();
		long timeoutMs = DOWNLOAD_TIMEOUT_SECONDS * 1000L;

		// Snapshot existing files before download
		Set<String> existingFiles = new HashSet<>();
		File[] before = downloadPath.toFile().listFiles();
		if (before != null) {
			for (File f : before) {
				existingFiles.add(f.getName());
			}
		}

		// Poll until a new completed file appears (not a .crdownload partial)
		while (System.currentTimeMillis() - startTime < timeoutMs) {
			Thread.sleep(1000);

			File[] currentFiles = downloadPath.toFile().listFiles();
			if (currentFiles == null) continue;

			// Check if any .crdownload files still in progress
			boolean stillDownloading = false;
			File newFile = null;

			for (File f : currentFiles) {
				if (f.getName().endsWith(".crdownload") || f.getName().endsWith(".tmp")) {
					stillDownloading = true;
				}
				// Find the newly appeared file (not a partial)
				if (!existingFiles.contains(f.getName())
						&& !f.getName().endsWith(".crdownload")
						&& !f.getName().endsWith(".tmp")) {
					newFile = f;
				}
			}

			if (newFile != null && !stillDownloading) {
				// Rename to desired file name
				File destination = new File(DOWNLOAD_DIR, desiredFileName);
				if (newFile.getName().equals(desiredFileName)) {
					return true; // already has the right name
				}
				boolean renamed = newFile.renameTo(destination);
				if (!renamed) {
					// Fallback: copy and delete
					try {
						Files.copy(newFile.toPath(), destination.toPath());
						newFile.delete();
						return true;
					} catch (Exception e) {
						log("[WARN]  Could not rename file: " + e.getMessage());
						return false;
					}
				}
				return true;
			}
		}
		return false;
	}

	/**
	 * Simple timestamped logger.
	 */
	private void log(String message) {
		System.out.println("[PDFDownloader] " + message);
	}
}
