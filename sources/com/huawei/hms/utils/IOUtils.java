package com.huawei.hms.utils;

import android.content.res.AssetManager;
import com.huawei.hms.support.log.HMSLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.util.Locale;

/* loaded from: classes8.dex */
public final class IOUtils {
    private IOUtils() {
    }

    public static void closeQuietly(Reader reader) throws IOException {
        closeQuietly((Closeable) reader);
    }

    public static long copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        return copy(inputStream, outputStream, new byte[4096]);
    }

    public static byte[] readAssetsFile(AssetManager assetManager, String str) throws IOException {
        if (assetManager == null || str == null) {
            HMSLog.m36986e("IOUtils", "readAssetFile args error");
            return new byte[0];
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        InputStream inputStreamOpen = null;
        try {
            try {
                inputStreamOpen = assetManager.open(str);
                byte[] bArr = new byte[1024];
                while (true) {
                    int i10 = inputStreamOpen.read(bArr);
                    if (i10 == -1) {
                        byteArrayOutputStream.flush();
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        closeQuietly(inputStreamOpen);
                        closeQuietly((OutputStream) byteArrayOutputStream);
                        return byteArray;
                    }
                    byteArrayOutputStream.write(bArr, 0, i10);
                }
            } catch (IOException e10) {
                HMSLog.m36987e("IOUtils", String.format(Locale.ROOT, "Failed to open %s", str), e10);
                closeQuietly(inputStreamOpen);
                closeQuietly((OutputStream) byteArrayOutputStream);
                return new byte[0];
            }
        } catch (Throwable th2) {
            closeQuietly(inputStreamOpen);
            closeQuietly((OutputStream) byteArrayOutputStream);
            throw th2;
        }
    }

    public static byte[] toByteArray(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        copy(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static InputStream toInputStream(byte[] bArr) throws IOException {
        return new ByteArrayInputStream(bArr);
    }

    public static void closeQuietly(Writer writer) throws IOException {
        closeQuietly((Closeable) writer);
    }

    public static long copy(InputStream inputStream, OutputStream outputStream, byte[] bArr) throws IOException {
        long j10 = 0;
        if (inputStream != null && outputStream != null) {
            if (bArr == null) {
                bArr = new byte[4096];
            }
            while (true) {
                int i10 = inputStream.read(bArr);
                if (-1 == i10) {
                    break;
                }
                outputStream.write(bArr, 0, i10);
                j10 += i10;
            }
        }
        return j10;
    }

    public static void closeQuietly(InputStream inputStream) throws IOException {
        closeQuietly((Closeable) inputStream);
    }

    public static void closeQuietly(OutputStream outputStream) throws IOException {
        closeQuietly((Closeable) outputStream);
    }

    public static void closeQuietly(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
                HMSLog.m36986e("IOUtils", "An exception occurred while closing the 'Closeable' object.");
            }
        }
    }
}
