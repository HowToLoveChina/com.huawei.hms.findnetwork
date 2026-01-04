package com.huawei.feedback.mail.util;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.huawei.feedback.log.BaseLogger;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PushbackInputStream;
import p664u0.C13108a;

/* loaded from: classes5.dex */
public class IoUtils {
    private static final String TAG = "IoUtils";

    public static void closeDataOutputStream(DataOutputStream dataOutputStream, String str) throws IOException {
        if (dataOutputStream != null) {
            try {
                dataOutputStream.close();
            } catch (IOException unused) {
                BaseLogger.m28731e(TAG, "closeDataOutputStream IOException");
            }
        }
    }

    public static void closeFileInputStream(FileInputStream fileInputStream, String str) throws IOException {
        if (fileInputStream != null) {
            try {
                fileInputStream.close();
            } catch (IOException unused) {
                BaseLogger.m28731e(TAG, "closeFileInputStream IOException");
            }
        }
    }

    public static void closeFileOutputStream(FileOutputStream fileOutputStream, String str) throws IOException {
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (IOException unused) {
                BaseLogger.m28731e(TAG, "closeFileOutputStream IOException");
            }
        }
    }

    public static void closeInputStream(InputStream inputStream, String str) throws IOException {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
                BaseLogger.m28731e(TAG, "closeInputStream IOException");
            }
        }
    }

    public static void closeOutputStream(OutputStream outputStream, String str) throws IOException {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException unused) {
                BaseLogger.m28731e(TAG, "closeOutputStream IOException");
            }
        }
    }

    public static void closeOutputStreamWriter(OutputStreamWriter outputStreamWriter, String str) throws IOException {
        if (outputStreamWriter != null) {
            try {
                outputStreamWriter.close();
            } catch (IOException unused) {
                BaseLogger.m28731e(TAG, "closeOutputStreamWriter IOException");
            }
        }
    }

    public static boolean deleteFile(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        if (file.exists()) {
            return file.delete();
        }
        return false;
    }

    public static InputStream getInputStream(InputStream inputStream) throws IOException {
        PushbackInputStream pushbackInputStream = new PushbackInputStream(inputStream);
        int i10 = pushbackInputStream.read();
        if (i10 != 239) {
            pushbackInputStream.unread(i10);
            return pushbackInputStream;
        }
        int i11 = pushbackInputStream.read();
        if (i11 != 187) {
            pushbackInputStream.unread(i11);
            pushbackInputStream.unread(239);
            return pushbackInputStream;
        }
        if (pushbackInputStream.read() == 191) {
            return pushbackInputStream;
        }
        throw new IOException("error file");
    }

    public static String readStream(InputStream inputStream) throws IOException {
        String string = null;
        if (inputStream == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            try {
                try {
                    int i10 = inputStream.read(bArr);
                    if (i10 == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, i10);
                } catch (IOException unused) {
                    BaseLogger.m28731e(TAG, "readStream io error");
                }
            } catch (Throwable th2) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException unused2) {
                    BaseLogger.m28731e(TAG, "close io error");
                }
                throw th2;
            }
        }
        string = byteArrayOutputStream.toString(Constants.UTF_8);
        try {
            byteArrayOutputStream.close();
        } catch (IOException unused3) {
            BaseLogger.m28731e(TAG, "close io error");
        }
        return string;
    }

    public static void sendBrocast(Context context, Intent intent) {
        C13108a.m78878b(context).m78881d(intent);
    }
}
