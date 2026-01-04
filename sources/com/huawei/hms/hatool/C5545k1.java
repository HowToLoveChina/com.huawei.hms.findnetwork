package com.huawei.hms.hatool;

import com.huawei.openalliance.p169ad.constant.Constants;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.zip.Deflater;

/* renamed from: com.huawei.hms.hatool.k1 */
/* loaded from: classes8.dex */
public final class C5545k1 {
    /* renamed from: a */
    public static String m32607a(File file) throws Throwable {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    C5534h c5534h = new C5534h(1024);
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int i10 = fileInputStream.read(bArr);
                        if (i10 == -1) {
                            break;
                        }
                        c5534h.m32557a(bArr, i10);
                    }
                    if (c5534h.m32559b() == 0) {
                        m32609a((Closeable) fileInputStream);
                        return "";
                    }
                    String str = new String(c5534h.m32558a(), Constants.UTF_8);
                    m32609a((Closeable) fileInputStream);
                    return str;
                } catch (FileNotFoundException unused) {
                    fileInputStream2 = fileInputStream;
                    C5571v.m32797f("hmsSdk", "getInfoFromFile(): No files need to be read");
                    m32609a((Closeable) fileInputStream2);
                    return "";
                } catch (IOException unused2) {
                    fileInputStream2 = fileInputStream;
                    C5571v.m32797f("hmsSdk", "getInfoFromFile(): stream.read or new string exception");
                    m32609a((Closeable) fileInputStream2);
                    return "";
                } catch (Throwable th2) {
                    th = th2;
                    m32609a((Closeable) fileInputStream);
                    throw th;
                }
            } catch (FileNotFoundException unused3) {
            } catch (IOException unused4) {
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
        }
    }

    /* renamed from: a */
    public static String m32608a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int i10 = inputStream.read(bArr);
                if (i10 == -1) {
                    String string = byteArrayOutputStream.toString(Constants.UTF_8);
                    m32609a((Closeable) byteArrayOutputStream);
                    return string;
                }
                byteArrayOutputStream.write(bArr, 0, i10);
            }
        } catch (Throwable th2) {
            m32609a((Closeable) byteArrayOutputStream);
            throw th2;
        }
    }

    /* renamed from: a */
    public static void m32609a(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
                C5571v.m32797f("hmsSdk", "closeQuietly(): Exception when closing the closeable!");
            }
        }
    }

    /* renamed from: a */
    public static void m32610a(File file, String str) throws Throwable {
        String str2;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(file);
            } catch (FileNotFoundException unused) {
            } catch (IOException unused2) {
            } catch (Throwable th2) {
                th = th2;
                m32609a((Closeable) fileOutputStream2);
                throw th;
            }
            try {
                fileOutputStream.write(str.getBytes(Constants.UTF_8));
                fileOutputStream.flush();
            } catch (FileNotFoundException unused3) {
                fileOutputStream2 = fileOutputStream;
                str2 = "saveInfoToFile(): No files need to be read";
                fileOutputStream = fileOutputStream2;
                C5571v.m32797f("hmsSdk", str2);
                m32609a((Closeable) fileOutputStream);
            } catch (IOException unused4) {
                fileOutputStream2 = fileOutputStream;
                str2 = "saveInfoToFile(): io exc from write info to file!";
                fileOutputStream = fileOutputStream2;
                C5571v.m32797f("hmsSdk", str2);
                m32609a((Closeable) fileOutputStream);
            }
            m32609a((Closeable) fileOutputStream);
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream2 = fileOutputStream;
            m32609a((Closeable) fileOutputStream2);
            throw th;
        }
    }

    /* renamed from: a */
    private static void m32611a(OutputStream outputStream) throws IOException {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException unused) {
                C5571v.m32797f("hmsSdk", "closeStream(): Exception: close OutputStream error!");
            }
        }
    }

    /* renamed from: a */
    public static void m32612a(HttpURLConnection httpURLConnection) throws IOException {
        try {
            httpURLConnection.getInputStream().close();
        } catch (Exception unused) {
            C5571v.m32797f("hmsSdk", "closeQuietly(): Exception when connHttp.getInputStream()!,There may be no network, or no INTERNET permission");
        }
        httpURLConnection.disconnect();
        C5571v.m32786a("hmsSdk", " connHttp disconnect");
    }

    /* renamed from: a */
    public static byte[] m32613a(byte[] bArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Deflater deflater = new Deflater();
        deflater.setInput(bArr);
        deflater.finish();
        byte[] bArr2 = new byte[1024];
        while (!deflater.finished()) {
            byteArrayOutputStream.write(bArr2, 0, deflater.deflate(bArr2));
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        deflater.end();
        m32611a((OutputStream) byteArrayOutputStream);
        return byteArray;
    }
}
