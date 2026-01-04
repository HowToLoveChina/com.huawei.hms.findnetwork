package com.huawei.location;

import android.content.Context;
import android.util.Log;
import com.huawei.location.activity.C6738e;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* renamed from: com.huawei.location.f */
/* loaded from: classes8.dex */
public final class C6759f {
    /* renamed from: a */
    public static boolean m38367a(Context context, String str) {
        File file = new File(str);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(context.getDir("libs", 0).getAbsolutePath());
        String strM38291a = C6738e.m38291a(sb2, File.separator, "libSdm.so");
        try {
            Log.d("SdmLocationLite", "ret=" + m38368b(file.getCanonicalPath(), new File(strM38291a).getCanonicalPath()));
            System.load(strM38291a);
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    /* renamed from: b */
    public static boolean m38368b(String str, String str2) throws IOException {
        String str3;
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(str2);
                try {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int i10 = fileInputStream.read(bArr);
                            if (i10 == -1) {
                                fileOutputStream.write(byteArrayOutputStream.toByteArray());
                                byteArrayOutputStream.close();
                                fileOutputStream.close();
                                fileInputStream.close();
                                return true;
                            }
                            byteArrayOutputStream.write(bArr, 0, i10);
                        }
                    } finally {
                    }
                } finally {
                }
            } catch (Throwable th2) {
                try {
                    throw th2;
                } catch (Throwable th3) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable th4) {
                        th2.addSuppressed(th4);
                    }
                    throw th3;
                }
            }
        } catch (FileNotFoundException unused) {
            str3 = "FileNotFoundException";
            Log.e("SdmLocationLite", str3);
            return false;
        } catch (IOException unused2) {
            str3 = "IOException";
            Log.e("SdmLocationLite", str3);
            return false;
        }
    }
}
