package com.example.backend_final_project.Utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class ImageUtil {
    public static boolean save(File file) {
        File dir = new File(System.getProperty("user.dir")+"/hinhanh/");
        if (!dir.exists()) {
            dir.mkdirs();
        }
        File newFile = new File(dir, file.getName());
        try {
            Path source = Paths.get(file.getAbsolutePath(), new String[0]);
            Path destination = Paths.get(newFile.getAbsolutePath(), new String[0]);
            Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
            return true;
        }
        catch (Exception ex) {
            return false;
        }
    }
    public static byte[] open(String fileName) {
        try {
            File file = new File(System.getProperty("user.dir")+"/hinhanh/", fileName);
            return Files.readAllBytes(file.toPath());
        }catch (Exception e){
            throw new RuntimeException(e);

        }
    }
}
