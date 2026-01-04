package com.huawei.hms.network.embedded;

import com.huawei.openalliance.p169ad.constant.Constants;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;
import java.nio.charset.Charset;

/* renamed from: com.huawei.hms.network.embedded.c */
/* loaded from: classes8.dex */
public final class C5870c {

    /* renamed from: a */
    public static final Charset f26534a = Charset.forName("US-ASCII");

    /* renamed from: b */
    public static final Charset f26535b = Charset.forName(Constants.UTF_8);

    /* renamed from: a */
    public static String m33997a(Reader reader) throws IOException {
        try {
            StringWriter stringWriter = new StringWriter();
            char[] cArr = new char[1024];
            while (true) {
                int i10 = reader.read(cArr);
                if (i10 == -1) {
                    String string = stringWriter.toString();
                    reader.close();
                    return string;
                }
                stringWriter.write(cArr, 0, i10);
            }
        } catch (Throwable th2) {
            reader.close();
            throw th2;
        }
    }

    /* renamed from: a */
    public static void m33998a(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e10) {
                throw e10;
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: a */
    public static void m33999a(File file) throws IOException {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            throw new IOException("not a readable directory: " + file);
        }
        for (File file2 : fileArrListFiles) {
            if (file2.isDirectory()) {
                m33999a(file2);
            }
            if (!file2.delete()) {
                throw new IOException("failed to delete file: " + file2);
            }
        }
    }
}
