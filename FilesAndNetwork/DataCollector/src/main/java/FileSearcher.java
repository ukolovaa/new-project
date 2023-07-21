import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

public class FileSearcher {
    public List<File> searchFiles(String folderPath) {
        File folder = new File(folderPath);
        List<File> foundFiles = new ArrayList<>();

        if (folder.isDirectory()) {
            File[] files = folder.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        foundFiles.addAll(searchFiles(file.getAbsolutePath()));
                    } else {
                        String fileName = file.getName().toLowerCase();
                        if (fileName.endsWith(".json") || fileName.endsWith(".csv")) {
                            foundFiles.add(file);
                        }
                    }
                }
            }
        }
        return foundFiles;
    }

    public void copyFilesToFolder(List<File> files, String destinationFolderPath) throws IOException {
        File destinationFolder = new File(destinationFolderPath);
        if (!destinationFolder.exists()) {
            destinationFolder.mkdir();
        }
        for (File file : files) {
            String fileName = file.getName();
            File destinationFile = new File(destinationFolderPath + File.separator + fileName);
            Files.copy(file.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
        }
    }
}
