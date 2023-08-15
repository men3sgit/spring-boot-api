package com.menes.utilities;

public class FileUtils {
    public static String getExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf('.') + 1);
    }
}
