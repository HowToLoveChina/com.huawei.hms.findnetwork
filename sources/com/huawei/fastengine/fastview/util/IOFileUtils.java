package com.huawei.fastengine.fastview.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/* loaded from: classes5.dex */
public class IOFileUtils {
    public static void cleanDirectory(File file) throws IOException {
        IOException e10 = null;
        for (File file2 : verifiedListFiles(file)) {
            try {
                forceDelete(file2);
            } catch (IOException e11) {
                e10 = e11;
            }
        }
        if (e10 != null) {
            throw e10;
        }
    }

    public static void deleteDirectory(File file) throws IOException {
        if (file.exists()) {
            cleanDirectory(file);
            if (file.delete()) {
                return;
            }
            throw new IOException("Unable to delete directory " + file + ".");
        }
    }

    public static void forceDelete(File file) throws IOException {
        if (file.isDirectory()) {
            deleteDirectory(file);
            return;
        }
        boolean zExists = file.exists();
        if (file.delete()) {
            return;
        }
        if (zExists) {
            throw new IOException("Unable to delete file: " + file);
        }
        throw new FileNotFoundException("File does not exist: " + file);
    }

    public static boolean isExist(String str) {
        return new File(str).exists();
    }

    private static File[] verifiedListFiles(File file) throws IOException {
        if (!file.exists()) {
            throw new IllegalArgumentException(file + " does not exist");
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(file + " is not a directory");
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            return fileArrListFiles;
        }
        throw new IOException("Failed to list contents of " + file);
    }
}
