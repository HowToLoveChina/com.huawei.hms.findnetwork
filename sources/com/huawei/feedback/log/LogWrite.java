package com.huawei.feedback.log;

import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Locale;

/* loaded from: classes5.dex */
public final class LogWrite {
    private static final int MAX_FILE_NUM = 3;
    private static final String MSG_FORMAT = "%s: %s/%s: %s";
    private static final String TAG = "LogWrite";
    private static boolean fileLoggerEnable = false;
    private static String logDirPath = null;
    private static String logFileName = null;
    private static int pid = Process.myPid();
    private static boolean sensitiveLoggerEnable = false;
    private static BufferedWriter writer;

    public static class FileComparator implements Comparator<File>, Serializable {
        private static final long serialVersionUID = 1;

        private FileComparator() {
        }

        @Override // java.util.Comparator
        public int compare(File file, File file2) {
            return (int) (file.lastModified() - file2.lastModified());
        }
    }

    private static void createNewLogFile(String str, String str2) throws IOException {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            BaseLogger.m28731e(TAG, "createNewLogFile Exception");
            return;
        }
        File[] fileArrListFiles = new File(str).listFiles();
        if (fileArrListFiles != null && fileArrListFiles.length >= 3) {
            try {
                Arrays.sort(fileArrListFiles, new FileComparator());
            } catch (IllegalArgumentException unused) {
                BaseLogger.m28731e(TAG, "Arrays sort IllegalArgumentException");
            }
            deleteFiles(fileArrListFiles);
        }
        FileOutputStream fileOutputStream = new FileOutputStream(new File(str, str2));
        synchronized (LogWrite.class) {
            BufferedWriter bufferedWriter = writer;
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException unused2) {
                    BaseLogger.m28731e(TAG, "createNewLogFile IOException");
                }
                try {
                    try {
                        writer = new BufferedWriter(new OutputStreamWriter(fileOutputStream, Constants.UTF_8));
                        logFileName = str2;
                    } catch (IOException unused3) {
                        fileOutputStream.close();
                    }
                } catch (IOException unused4) {
                    BaseLogger.m28731e(TAG, "createNewLogFile out.close Exception");
                }
            } else {
                writer = new BufferedWriter(new OutputStreamWriter(fileOutputStream, Constants.UTF_8));
                logFileName = str2;
            }
        }
    }

    private static boolean deleteFiles(File[] fileArr) {
        if (fileArr == null || fileArr.length <= 0) {
            return false;
        }
        return fileArr[0].delete();
    }

    private static String getNow() {
        return new SimpleDateFormat("yy-MM-dd HH:mm:ss.SSS  " + pid + " ", Locale.getDefault()).format(Calendar.getInstance().getTime());
    }

    public static void init(String str, boolean z10) throws IOException {
        sensitiveLoggerEnable = z10;
        if (str != null) {
            logDirPath = str;
            fileLoggerEnable = true;
        } else {
            Log.i(TAG, "init dirPath is null");
            fileLoggerEnable = false;
        }
        if (fileLoggerEnable) {
            File file = new File(logDirPath);
            if (!file.exists() && !file.mkdirs()) {
                Log.e(TAG, "init mkdirs fail");
            } else {
                createNewLogFile(logDirPath, makeLogFileName());
            }
        }
    }

    private static String makeLogFileName() {
        return "error_" + System.currentTimeMillis() + ".log";
    }

    private static void openLogFile(String str, String str2) throws IOException {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            BaseLogger.m28731e(TAG, "openLogFile Exception");
            return;
        }
        FileOutputStream fileOutputStream = new FileOutputStream(new File(str, str2), true);
        synchronized (LogWrite.class) {
            try {
                try {
                    writer = new BufferedWriter(new OutputStreamWriter(fileOutputStream, Constants.UTF_8));
                    logFileName = str2;
                } catch (IOException unused) {
                    fileOutputStream.close();
                }
            } catch (IOException unused2) {
                BaseLogger.m28731e(TAG, "openLogFile out.close Exception");
            }
        }
    }

    /* renamed from: s */
    public static void m28737s(String str, String str2, Throwable th2) {
        if (fileLoggerEnable && sensitiveLoggerEnable) {
            wtf(CloudBackupConstant.UserPackageInfo.SILVER_MEMBER, str, str2, th2);
        }
    }

    public static void shutdown() {
        synchronized (LogWrite.class) {
            BufferedWriter bufferedWriter = writer;
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException unused) {
                    BaseLogger.m28731e(TAG, "shutdown IOException");
                }
                writer = null;
            } else {
                writer = null;
            }
        }
    }

    public static void wtf(String str, String str2, String str3, Throwable th2) {
        synchronized (LogWrite.class) {
            try {
                try {
                } catch (IOException unused) {
                    Log.e(TAG, "append msg to log file catch IOException");
                }
                if (!TextUtils.isEmpty(logDirPath) && !TextUtils.isEmpty(logFileName)) {
                    if (new File(logDirPath, logFileName).length() > 3145728) {
                        createNewLogFile(logDirPath, makeLogFileName());
                    } else if (writer == null) {
                        openLogFile(logDirPath, logFileName);
                    }
                    Locale locale = Locale.ENGLISH;
                    Object[] objArr = new Object[4];
                    objArr[0] = getNow();
                    objArr[1] = str;
                    objArr[2] = str2;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str3);
                    sb2.append('\n');
                    sb2.append(th2 == null ? "" : th2.getMessage());
                    objArr[3] = sb2.toString();
                    writer.append((CharSequence) String.format(locale, MSG_FORMAT, objArr));
                    writer.flush();
                    return;
                }
                if (TextUtils.isEmpty(logDirPath)) {
                    Log.e(TAG, "logDirPath is empty");
                }
                if (TextUtils.isEmpty(logFileName)) {
                    Log.e(TAG, "logFileName is empty");
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }
}
