package com.huawei.location;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.IOException;

/* renamed from: com.huawei.location.j */
/* loaded from: classes8.dex */
public final class C6770j {
    /* renamed from: a */
    public static boolean m38374a(Context context, String str) throws Throwable {
        StringBuilder sb2;
        File file = new File(str);
        try {
            String str2 = context.getDir("libs", 0).getCanonicalPath() + File.separator + "libVdr.so";
            File file2 = new File(str2);
            Log.d("LibraryUtils", "src: " + file.getCanonicalPath() + "," + str2);
            boolean zM38375b = m38375b(file.getCanonicalPath(), file2.getCanonicalPath());
            StringBuilder sb3 = new StringBuilder("ret=");
            sb3.append(zM38375b);
            Log.d("LibraryUtils", sb3.toString());
            if (!zM38375b) {
                return false;
            }
            System.load(str2);
            return true;
        } catch (IOException e10) {
            e = e10;
            sb2 = new StringBuilder("load file dir error: ");
            sb2.append(e.getMessage());
            Log.e("LibraryUtils", sb2.toString());
            return false;
        } catch (UnsatisfiedLinkError e11) {
            e = e11;
            sb2 = new StringBuilder("invalid file: ");
            sb2.append(e.getMessage());
            Log.e("LibraryUtils", sb2.toString());
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x00bf A[Catch: IOException -> 0x00bb, TryCatch #11 {IOException -> 0x00bb, blocks: (B:55:0x00b7, B:59:0x00bf, B:61:0x00c4), top: B:71:0x00b7 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00c4 A[Catch: IOException -> 0x00bb, TRY_LEAVE, TryCatch #11 {IOException -> 0x00bb, blocks: (B:55:0x00b7, B:59:0x00bf, B:61:0x00c4), top: B:71:0x00b7 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00b7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:82:? A[SYNTHETIC] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m38375b(java.lang.String r8, java.lang.String r9) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 220
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.C6770j.m38375b(java.lang.String, java.lang.String):boolean");
    }
}
