package com.huawei.riemann.location.gwivdr.utils;

import as.C1016d;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/* loaded from: classes5.dex */
public class LibraryUtils {
    private static final String TAG = "LibraryUtils";

    public static boolean loadSo(String str) {
        StringBuilder sb2;
        String str2;
        if (str == null) {
            str2 = "null so file dir!";
        } else {
            File file = new File(str);
            if (file.exists()) {
                try {
                    System.load(file.getCanonicalPath());
                    C1016d.m6186f(TAG, "so file load succeed!");
                    return true;
                } catch (FileNotFoundException unused) {
                    str2 = "load file error!";
                } catch (IOException e10) {
                    e = e10;
                    sb2 = new StringBuilder("load file dir error: ");
                    sb2.append(e.getMessage());
                    C1016d.m6183c(TAG, sb2.toString());
                    return false;
                } catch (UnsatisfiedLinkError e11) {
                    e = e11;
                    sb2 = new StringBuilder("invalid file: ");
                    sb2.append(e.getMessage());
                    C1016d.m6183c(TAG, sb2.toString());
                    return false;
                }
            } else {
                str2 = "so file not exist!";
            }
        }
        C1016d.m6183c(TAG, str2);
        return false;
    }
}
