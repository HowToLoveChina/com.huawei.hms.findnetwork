package com.huawei.hms.utils;

import android.content.Context;
import com.huawei.hms.support.log.HMSLog;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes8.dex */
public abstract class FileUtil {
    public static final String LOCAL_REPORT_FILE = "hms/HwMobileServiceReport.txt";
    public static final String LOCAL_REPORT_FILE_CONFIG = "hms/config.txt";
    public static final long LOCAL_REPORT_FILE_MAX_SIZE = 10240;

    /* renamed from: a */
    private static boolean f30156a = false;

    /* renamed from: b */
    private static ScheduledExecutorService f30157b = Executors.newSingleThreadScheduledExecutor();

    /* renamed from: com.huawei.hms.utils.FileUtil$a */
    public class RunnableC6519a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ File f30158a;

        /* renamed from: b */
        final /* synthetic */ long f30159b;

        /* renamed from: c */
        final /* synthetic */ String f30160c;

        public RunnableC6519a(File file, long j10, String str) {
            this.f30158a = file;
            this.f30159b = j10;
            this.f30160c = str;
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            RandomAccessFile randomAccessFile;
            File file = this.f30158a;
            if (file == null) {
                HMSLog.m36986e("FileUtil", "In writeFile Failed to get local file.");
                return;
            }
            File parentFile = file.getParentFile();
            if (parentFile == null || !(parentFile.mkdirs() || parentFile.isDirectory())) {
                HMSLog.m36986e("FileUtil", "In writeFile, Failed to create directory.");
                return;
            }
            RandomAccessFile randomAccessFile2 = null;
            try {
                try {
                    long length = this.f30158a.length();
                    if (length > this.f30159b) {
                        String canonicalPath = this.f30158a.getCanonicalPath();
                        if (!this.f30158a.delete()) {
                            HMSLog.m36986e("FileUtil", "last file delete failed.");
                        }
                        randomAccessFile2 = new RandomAccessFile(new File(canonicalPath), "rw");
                    } else {
                        randomAccessFile = new RandomAccessFile(this.f30158a, "rw");
                        try {
                            randomAccessFile.seek(length);
                            randomAccessFile2 = randomAccessFile;
                        } catch (IOException e10) {
                            e = e10;
                            randomAccessFile2 = randomAccessFile;
                            HMSLog.m36987e("FileUtil", "writeFile exception:", e);
                            IOUtils.closeQuietly(randomAccessFile2);
                        } catch (Throwable th2) {
                            th = th2;
                            IOUtils.closeQuietly(randomAccessFile);
                            throw th;
                        }
                    }
                    randomAccessFile2.writeBytes(this.f30160c + System.getProperty("line.separator"));
                } catch (IOException e11) {
                    e = e11;
                }
                IOUtils.closeQuietly(randomAccessFile2);
            } catch (Throwable th3) {
                th = th3;
                randomAccessFile = null;
            }
        }
    }

    public static boolean verifyHash(String str, File file) throws Throwable {
        byte[] bArrDigest = SHA256.digest(file);
        return bArrDigest != null && HEX.encodeHexString(bArrDigest, true).equalsIgnoreCase(str);
    }

    public static void writeFile(File file, String str, long j10) {
        f30157b.execute(new RunnableC6519a(file, j10, str));
    }

    public static void writeFileReport(Context context, File file, File file2, String str, long j10, int i10) {
        if (file != null && file.isFile() && file.exists()) {
            if (!f30156a) {
                if (file2 != null && file2.exists() && !file2.delete()) {
                    HMSLog.m36986e("FileUtil", "file delete failed.");
                }
                f30156a = true;
            }
            writeFile(file2, str + "|" + j10 + "|" + i10, LOCAL_REPORT_FILE_MAX_SIZE);
        }
    }
}
