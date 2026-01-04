package com.huawei.feedback.mail.util;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.text.TextUtils;
import android.text.format.Time;
import com.huawei.feedback.log.BaseLogger;
import com.huawei.feedback.mail.zip.p099sp.SharedPreferencesStorage;
import com.huawei.phoneservice.feedbackcommon.network.FeedbackWebConstants;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* loaded from: classes5.dex */
public class FeedbackUtils {
    private static final String TAG = "AppLogApi/FeedbackUtils";

    public static void deleteZipfile(File file) {
        if (file == null || !file.exists()) {
            return;
        }
        for (int i10 = 0; i10 < 2; i10++) {
            if (file.delete()) {
                BaseLogger.m28729d(TAG, "deleteZipfile sccess!" + file.toString());
                return;
            }
            BaseLogger.m28729d(TAG, " deleteZipfile fail!" + file.toString());
        }
    }

    public static void deleteZipfiles(String str) {
        String[] list = new File(str).list();
        if (list != null) {
            int length = list.length;
            for (int i10 = 0; i10 < length; i10++) {
                if (list[i10].endsWith(FeedbackWebConstants.SUFFIX)) {
                    File file = new File(str + "/" + list[i10]);
                    if (file.exists()) {
                        int i11 = 0;
                        while (true) {
                            if (i11 >= 2) {
                                break;
                            }
                            if (file.delete()) {
                                BaseLogger.m28729d(TAG, "resultZipFile delete sccess!");
                                break;
                            } else {
                                BaseLogger.m28729d(TAG, " resultZipFile delete fail!");
                                i11++;
                            }
                        }
                    }
                }
            }
        }
    }

    public static void deletezips(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        File file = new File(str);
        if (file.exists()) {
            for (int i10 = 0; i10 < 2; i10++) {
                if (file.delete()) {
                    BaseLogger.m28729d(TAG, "waitUploadZipfile delete sccess!");
                    return;
                }
                BaseLogger.m28729d(TAG, " waitUploadZipfile delete fail!");
            }
        }
    }

    public static String formatTime(String str) {
        return MessageFormat.format("{0}-{1}-{2} {3}:{4}", str.substring(0, 4), str.substring(4, 6), str.substring(6, 8), str.substring(8, 10), str.substring(10, 12));
    }

    public static String getApplicationName(Context context) {
        if (context == null) {
            return "";
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            return (String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(context.getPackageName(), 0));
        } catch (PackageManager.NameNotFoundException unused) {
            BaseLogger.m28731e(TAG, "applicationInfo = null");
            return "";
        }
    }

    public static String getExternalStoragePath() {
        if (Environment.getExternalStorageState().equals("mounted") && Environment.getExternalStorageDirectory().canWrite()) {
            return Environment.getExternalStorageDirectory().getPath();
        }
        return null;
    }

    public static String[] getFileName(String str) {
        String[] list = new File(str).list();
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            int length = list.length;
            for (int i10 = 0; i10 < length; i10++) {
                if (list[i10].endsWith(".log") || list[i10].endsWith(".txt")) {
                    File file = new File(str + "/" + list[i10]);
                    if (file.exists()) {
                        arrayList.add(file.getPath());
                    }
                }
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static String[] getFileNameList(ArrayList<String> arrayList) {
        if (arrayList == null) {
            return new String[0];
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            BaseLogger.m28729d(TAG, "pathlist " + next);
            String[] fileName = getFileName(next);
            if (fileName != null) {
                for (String str : fileName) {
                    arrayList2.add(str);
                }
            }
        }
        return (String[]) arrayList2.toArray(new String[arrayList2.size()]);
    }

    public static int getFileSize(String str) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(str);
        try {
            try {
                return fileInputStream.available();
            } catch (IOException unused) {
                BaseLogger.m28731e(TAG, "getFileSize IOException");
                IoUtils.closeFileInputStream(fileInputStream, TAG);
                return 0;
            }
        } finally {
            IoUtils.closeFileInputStream(fileInputStream, TAG);
        }
    }

    public static String getTime() {
        Time time = new Time();
        time.setToNow();
        return String.format(Locale.ENGLISH, "%04d%02d%02d%02d%02d%02d", Integer.valueOf(time.year), Integer.valueOf(time.month + 1), Integer.valueOf(time.monthDay), Integer.valueOf(time.hour), Integer.valueOf(time.minute), Integer.valueOf(time.second));
    }

    public static void recursionDeleteFile(File file) {
        File[] fileArrListFiles;
        if (file.isFile()) {
            if (file.delete()) {
                BaseLogger.m28729d(TAG, "delete sdcard/phoneservice/image suc!");
                return;
            }
            BaseLogger.m28729d(TAG, "delete sdcard/phoneservice/image failure!");
        }
        if (!file.isDirectory() || (fileArrListFiles = file.listFiles()) == null || fileArrListFiles.length == 0) {
            return;
        }
        for (File file2 : fileArrListFiles) {
            recursionDeleteFile(file2);
        }
    }

    public static boolean zipFiles(File[] fileArr, File file, Context context) throws Throwable {
        if (fileArr != null && fileArr.length <= 50) {
            byte[] bArr = new byte[1024];
            ZipOutputStream zipOutputStream = null;
            FileInputStream fileInputStream = null;
            FileInputStream fileInputStream2 = null;
            FileInputStream fileInputStream3 = null;
            ZipOutputStream zipOutputStream2 = null;
            try {
                ZipOutputStream zipOutputStream3 = new ZipOutputStream(new FileOutputStream(file));
                for (int i10 = 0; i10 < fileArr.length; i10++) {
                    try {
                        try {
                            boolean unlimitSizeUpload = SharedPreferencesStorage.getInstance().getUnlimitSizeUpload(context);
                            BaseLogger.m28733i(TAG, "zipFiles isUnLimitSize===" + unlimitSizeUpload);
                            File file2 = fileArr[i10];
                            if (file2 != null && (file2.length() <= 5242880 || unlimitSizeUpload)) {
                                try {
                                    try {
                                        FileInputStream fileInputStream4 = new FileInputStream(fileArr[i10]);
                                        try {
                                            zipOutputStream3.putNextEntry(new ZipEntry(fileArr[i10].getName()));
                                            while (true) {
                                                int i11 = fileInputStream4.read(bArr);
                                                if (i11 <= 0) {
                                                    break;
                                                }
                                                zipOutputStream3.write(bArr, 0, i11);
                                            }
                                            zipOutputStream3.closeEntry();
                                            try {
                                                fileInputStream4.close();
                                            } catch (IOException unused) {
                                                BaseLogger.m28731e(TAG, "IOException two...");
                                            }
                                        } catch (FileNotFoundException unused2) {
                                            fileInputStream2 = fileInputStream4;
                                            BaseLogger.m28731e(TAG, "FileNotFoundException ...");
                                            if (fileInputStream2 != null) {
                                                try {
                                                    fileInputStream2.close();
                                                } catch (IOException unused3) {
                                                    BaseLogger.m28731e(TAG, "IOException two...");
                                                }
                                            }
                                            try {
                                                zipOutputStream3.close();
                                            } catch (IOException unused4) {
                                                BaseLogger.m28731e(TAG, "IOException three...");
                                            }
                                            return false;
                                        } catch (IOException unused5) {
                                            fileInputStream3 = fileInputStream4;
                                            BaseLogger.m28731e(TAG, "IOException one...");
                                            if (fileInputStream3 != null) {
                                                try {
                                                    fileInputStream3.close();
                                                } catch (IOException unused6) {
                                                    BaseLogger.m28731e(TAG, "IOException two...");
                                                }
                                            }
                                            try {
                                                zipOutputStream3.close();
                                            } catch (IOException unused7) {
                                                BaseLogger.m28731e(TAG, "IOException three...");
                                            }
                                            return false;
                                        } catch (Throwable th2) {
                                            th = th2;
                                            fileInputStream = fileInputStream4;
                                            if (fileInputStream != null) {
                                                try {
                                                    fileInputStream.close();
                                                } catch (IOException unused8) {
                                                    BaseLogger.m28731e(TAG, "IOException two...");
                                                }
                                            }
                                            throw th;
                                        }
                                    } catch (FileNotFoundException unused9) {
                                    } catch (IOException unused10) {
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                }
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            zipOutputStream = zipOutputStream3;
                            if (zipOutputStream != null) {
                                try {
                                    zipOutputStream.close();
                                } catch (IOException unused11) {
                                    BaseLogger.m28731e(TAG, "IOException three...");
                                }
                            }
                            throw th;
                        }
                    } catch (FileNotFoundException unused12) {
                        zipOutputStream2 = zipOutputStream3;
                        if (zipOutputStream2 != null) {
                            try {
                                zipOutputStream2.close();
                            } catch (IOException unused13) {
                                BaseLogger.m28731e(TAG, "IOException three...");
                            }
                        }
                        return false;
                    }
                }
                try {
                    zipOutputStream3.close();
                    return true;
                } catch (IOException unused14) {
                    BaseLogger.m28731e(TAG, "IOException three...");
                    return true;
                }
            } catch (FileNotFoundException unused15) {
            } catch (Throwable th5) {
                th = th5;
            }
        }
        return false;
    }
}
