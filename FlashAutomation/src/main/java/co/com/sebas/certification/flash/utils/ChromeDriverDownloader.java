package co.com.sebas.certification.flash.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.*;


public class ChromeDriverDownloader {
    public static void download() {
        String downloadUrl = "https://chromedriver.storage.googleapis.com/LATEST_RELEASE";
        try {
            String version = getVersion(downloadUrl);
            if (version != null) {
                String downloadUrlForVersion = "https://chromedriver.storage.googleapis.com/" + version + "/chromedriver_win32.zip";
                downloadChromeDriver(downloadUrlForVersion);
                System.out.println("Descarga del Chrome Driver exitosa.");
            } else {
                System.out.println("Error al obtener la versión del Chrome Driver.");
            }
        } catch (IOException e) {
            System.out.println("Error al descargar el Chrome Driver: " + e.getMessage());
        }
        //waitForFile("chromedriver.exe");
    }

    private static String getVersion(String url) throws IOException {
        URL versionUrl = new URL(url);
        try (InputStream in = versionUrl.openStream()) {
            byte[] bytes = in.readAllBytes();
            return new String(bytes);
        }
    }

    private static void downloadChromeDriver(String url) throws IOException {
        URL downloadUrl = new URL(url);
        ReadableByteChannel channel = Channels.newChannel(downloadUrl.openStream());
        Path outputPath = Path.of("chromedriver.zip");
        try (FileOutputStream fileOutputStream = new FileOutputStream(outputPath.toFile())) {
            fileOutputStream.getChannel().transferFrom(channel, 0, Long.MAX_VALUE);
        }
        Path targetPath = Path.of("chromedriver.exe");
        Files.move(outputPath, targetPath, StandardCopyOption.REPLACE_EXISTING);
    }
    public static void waitForFile(String fileName) {
        Path dir = Paths.get("C:\\Users\\User\\Desktop\\FlashMobile_Automation\\FlashAutomation"); // Directorio donde esperas que aparezca el archivo
        try {
            WatchService watchService = FileSystems.getDefault().newWatchService();
            dir.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);

            System.out.println("Esperando a que aparezca el archivo '" + fileName + "'...");

            while (true) {
                WatchKey key = watchService.take();
                for (WatchEvent<?> event : key.pollEvents()) {
                    Path createdFile = (Path) event.context();
                    if (createdFile.toString().equals(fileName)) {
                        System.out.println("El archivo '" + fileName + "' ha aparecido.");
                        return;
                    }
                }
                key.reset();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
