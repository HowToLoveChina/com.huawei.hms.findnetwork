package com.huawei.hms.drive;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.huawei.hms.drive.ab */
/* loaded from: classes8.dex */
public abstract class AbstractC5169ab {
    /* renamed from: a */
    public static void m30792a(InputStream inputStream) throws IOException {
        m30791a((Closeable) inputStream);
    }

    /* renamed from: a */
    public static void m30791a(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
                C5170ac.m30796c("IOUtil", "closeSecure IOException");
            }
        }
    }
}
