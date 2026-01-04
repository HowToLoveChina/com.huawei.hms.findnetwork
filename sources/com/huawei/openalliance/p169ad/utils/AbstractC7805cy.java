package com.huawei.openalliance.p169ad.utils;

import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

/* renamed from: com.huawei.openalliance.ad.utils.cy */
/* loaded from: classes2.dex */
public abstract class AbstractC7805cy {
    /* renamed from: a */
    public static String m48140a() {
        return "818f41d42d2b7048a92678b7309e0f04a60a6dd9562b567d3de93f849e5a4c31";
    }

    /* renamed from: b */
    public static byte[] m48144b(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                byte[] bArr = new byte[2048];
                while (true) {
                    int i10 = inputStream.read(bArr);
                    if (-1 == i10) {
                        return byteArrayOutputStream.toByteArray();
                    }
                    byteArrayOutputStream.write(bArr, 0, i10);
                }
            } catch (Throwable th2) {
                th = th2;
                try {
                    AbstractC7185ho.m43824c("StreamUtil", "read stream ex: %s", th.getClass().getSimpleName());
                    return null;
                } finally {
                    m48142a(byteArrayOutputStream);
                }
            }
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream = null;
        }
    }

    /* renamed from: a */
    public static String m48141a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[2048];
        while (true) {
            int i10 = inputStream.read(bArr);
            if (-1 == i10) {
                return byteArrayOutputStream.toString(Constants.UTF_8);
            }
            byteArrayOutputStream.write(bArr, 0, i10);
        }
    }

    /* renamed from: a */
    public static void m48142a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th2) {
                AbstractC7185ho.m43823c("StreamUtil", "close " + th2.getClass().getSimpleName());
            }
        }
    }

    /* renamed from: a */
    public static void m48143a(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Throwable th2) {
                AbstractC7185ho.m43823c("StreamUtil", "close HttpURLConnection Exception:" + th2.getClass().getSimpleName());
            }
        }
    }
}
