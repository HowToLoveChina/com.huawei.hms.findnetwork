package com.huawei.fastengine.fastview.download.utils;

import com.huawei.fastengine.fastview.download.utils.log.FastViewLogUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;

/* loaded from: classes5.dex */
public class IoUtils {
    private static final int BUFF_SIZE = 4096;
    private static final String TAG = "IOUtils";

    public static void closeQuietly(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
                FastViewLogUtils.m28724e(TAG, "An exception occurred while closing the 'Closeable' object.");
            }
        }
    }

    public static void closeStream(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
                FastViewLogUtils.m28724e(TAG, "closeStream IOException");
            }
        }
    }

    public static long copy(InputStream inputStream, File file) throws Throwable {
        FileOutputStream fileOutputStream;
        if (inputStream == null || file == null) {
            return 0L;
        }
        try {
            fileOutputStream = new FileOutputStream(file);
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
        }
        try {
            long jCopy = copy(inputStream, fileOutputStream);
            closeStream(fileOutputStream);
            return jCopy;
        } catch (Throwable th3) {
            th = th3;
            closeStream(fileOutputStream);
            throw th;
        }
    }

    public static FileInputStream openInputStream(File file) throws IOException {
        if (!file.exists()) {
            throw new FileNotFoundException("File '" + file + "' does not exist");
        }
        if (file.isDirectory()) {
            throw new IOException("File '" + file + "' exists but is a directory");
        }
        if (file.canRead()) {
            return new FileInputStream(file);
        }
        throw new IOException("File '" + file + "' cannot be read");
    }

    public static FileOutputStream openOutputStream(File file, boolean z10) throws IOException {
        if (!file.exists()) {
            File parentFile = file.getParentFile();
            if (parentFile != null && !parentFile.mkdirs() && !parentFile.isDirectory()) {
                throw new IOException("Directory '" + parentFile + "' could not be created");
            }
        } else {
            if (file.isDirectory()) {
                throw new IOException("File '" + file + "' exists but is a directory");
            }
            if (!file.canWrite()) {
                throw new IOException("File '" + file + "' cannot be written to");
            }
        }
        return new FileOutputStream(file, z10);
    }

    public static byte[] readFileToByteArray(File file) throws Throwable {
        FileInputStream fileInputStreamOpenInputStream;
        try {
            fileInputStreamOpenInputStream = openInputStream(file);
        } catch (Throwable th2) {
            th = th2;
            fileInputStreamOpenInputStream = null;
        }
        try {
            byte[] byteArray = toByteArray(fileInputStreamOpenInputStream, (int) file.length());
            closeQuietly(fileInputStreamOpenInputStream);
            return byteArray;
        } catch (Throwable th3) {
            th = th3;
            closeQuietly(fileInputStreamOpenInputStream);
            throw th;
        }
    }

    public static byte[] toByteArray(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        copy(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static String toString(InputStream inputStream, String str) throws IOException {
        StringWriter stringWriter = new StringWriter();
        copy(new InputStreamReader(inputStream, str), stringWriter);
        return stringWriter.toString();
    }

    public static void writeByteArrayToFile(File file, byte[] bArr) throws Throwable {
        writeByteArrayToFile(file, bArr, false);
    }

    public static long copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        return copy(inputStream, outputStream, new byte[4096]);
    }

    public static byte[] toByteArray(InputStream inputStream, int i10) throws IOException {
        if (i10 < 0) {
            throw new IllegalArgumentException("size must not be less than zero.");
        }
        int i11 = 0;
        if (i10 == 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[i10];
        while (i11 < i10) {
            int i12 = inputStream.read(bArr, i11, i10 - i11);
            if (i12 == -1) {
                break;
            }
            i11 += i12;
        }
        if (i11 == i10) {
            return bArr;
        }
        throw new IOException("Unexpected readed size, excepted: " + i10 + ", current: " + i11);
    }

    public static void writeByteArrayToFile(File file, byte[] bArr, boolean z10) throws Throwable {
        FileOutputStream fileOutputStreamOpenOutputStream;
        try {
            fileOutputStreamOpenOutputStream = openOutputStream(file, z10);
            try {
                fileOutputStreamOpenOutputStream.write(bArr);
                fileOutputStreamOpenOutputStream.close();
                closeQuietly(fileOutputStreamOpenOutputStream);
            } catch (Throwable th2) {
                th = th2;
                closeQuietly(fileOutputStreamOpenOutputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStreamOpenOutputStream = null;
        }
    }

    public static long copy(InputStream inputStream, OutputStream outputStream, byte[] bArr) throws IOException {
        long j10 = 0;
        while (true) {
            int i10 = inputStream.read(bArr);
            if (-1 == i10) {
                return j10;
            }
            outputStream.write(bArr, 0, i10);
            j10 += i10;
        }
    }

    public static long copy(Reader reader, Writer writer) throws IOException {
        return copy(reader, writer, new char[4096]);
    }

    public static long copy(Reader reader, Writer writer, char[] cArr) throws IOException {
        long j10 = 0;
        while (true) {
            int i10 = reader.read(cArr);
            if (-1 == i10) {
                return j10;
            }
            writer.write(cArr, 0, i10);
            j10 += i10;
        }
    }

    public static void copy(File file, File file2) throws Throwable {
        Throwable th2;
        BufferedInputStream bufferedInputStream;
        BufferedOutputStream bufferedOutputStream;
        if (file == null || file2 == null) {
            return;
        }
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
            } catch (Throwable th3) {
                th2 = th3;
            }
        } catch (Throwable th4) {
            th2 = th4;
            bufferedInputStream = null;
        }
        try {
            copy(bufferedInputStream, bufferedOutputStream);
            closeStream(bufferedInputStream);
            closeStream(bufferedOutputStream);
        } catch (Throwable th5) {
            th2 = th5;
            bufferedOutputStream2 = bufferedOutputStream;
            closeStream(bufferedInputStream);
            closeStream(bufferedOutputStream2);
            throw th2;
        }
    }
}
