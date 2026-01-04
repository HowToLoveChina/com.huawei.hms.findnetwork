package com.huawei.openalliance.p169ad.utils;

import android.content.Context;
import android.os.StatFs;
import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C6849R;
import com.huawei.openalliance.p169ad.C7019dh;
import com.huawei.openalliance.p169ad.C7022dk;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.p171db.bean.ContentResource;
import com.tencent.p204mm.opensdk.constants.ConstantsAPI;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.List;
import java.util.Locale;

/* renamed from: com.huawei.openalliance.ad.utils.ae */
/* loaded from: classes2.dex */
public abstract class AbstractC7731ae {
    /* renamed from: a */
    public static String m47437a(long j10) {
        float f10 = (j10 * 1.0f) / 1048576.0f;
        if (f10 < 0.1f) {
            f10 = 0.1f;
        }
        return String.format(Locale.getDefault(), "%.1f", Float.valueOf(f10));
    }

    /* renamed from: b */
    public static File m47453b(Context context, String str, String str2) {
        if (C7022dk.m41954i(str)) {
            if (AbstractC7806cz.m48165b(str2)) {
                str2 = Constants.NORMAL_CACHE;
            }
            str = C7019dh.m41937a(context, str2).m41968c(str);
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new File(str);
    }

    /* renamed from: c */
    public static Long m47459c(String str) {
        StringBuilder sb2;
        try {
            StatFs statFs = new StatFs(str);
            return Long.valueOf(statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong());
        } catch (IllegalArgumentException e10) {
            e = e10;
            sb2 = new StringBuilder();
            sb2.append("getDiskFreeSpace ");
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43823c("FileUtil", sb2.toString());
            return null;
        } catch (Throwable th2) {
            e = th2;
            sb2 = new StringBuilder();
            sb2.append("getDiskFreeSpace ");
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43823c("FileUtil", sb2.toString());
            return null;
        }
    }

    /* renamed from: d */
    public static Long m47463d(String str) {
        StringBuilder sb2;
        try {
            return Long.valueOf(new StatFs(str).getTotalBytes());
        } catch (IllegalArgumentException e10) {
            e = e10;
            sb2 = new StringBuilder();
            sb2.append("getDiskTotalSpace ");
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43823c("FileUtil", sb2.toString());
            return null;
        } catch (Throwable th2) {
            e = th2;
            sb2 = new StringBuilder();
            sb2.append("getDiskTotalSpace ");
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43823c("FileUtil", sb2.toString());
            return null;
        }
    }

    /* renamed from: e */
    public static String m47465e(String str) {
        return str.substring(str.lastIndexOf(".")).trim();
    }

    /* renamed from: f */
    public static boolean m47467f(File file) {
        String str;
        if (file == null) {
            return false;
        }
        try {
        } catch (IOException unused) {
            str = "reCreateFile IOException";
            AbstractC7185ho.m43823c("FileUtil", str);
            return false;
        } catch (Exception unused2) {
            str = "reCreateFile Exception";
            AbstractC7185ho.m43823c("FileUtil", str);
            return false;
        }
        if (!file.exists() && file.createNewFile()) {
            return true;
        }
        if (file.delete()) {
            if (file.createNewFile()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: g */
    public static boolean m47468g(File file) {
        if (file == null || file.mkdirs()) {
            return true;
        }
        m47470i(file);
        return file.mkdirs();
    }

    /* renamed from: h */
    public static String m47469h(File file) {
        if (file == null) {
            return null;
        }
        try {
            return file.getCanonicalPath();
        } catch (IOException e10) {
            AbstractC7185ho.m43826d("FileUtil", "get path error, " + e10.getClass().getSimpleName());
            return null;
        }
    }

    /* renamed from: i */
    private static void m47470i(File file) {
        if (file == null) {
            return;
        }
        int i10 = 0;
        while (i10 < 10 && file != null && !AbstractC7804cx.m48139a(m47469h(file))) {
            i10++;
            if (file.exists()) {
                AbstractC7185ho.m43817a("FileUtil", "current file exists");
                if (file.isFile()) {
                    m47449a(file);
                    return;
                }
                return;
            }
            File parentFile = file.getParentFile();
            if (parentFile != null && TextUtils.equals(m47469h(parentFile), m47469h(file))) {
                AbstractC7185ho.m43823c("FileUtil", "parent file is the same as current");
                return;
            }
            file = parentFile;
        }
    }

    /* renamed from: a */
    public static String m47438a(Context context, long j10) {
        if (context == null) {
            return "";
        }
        return context.getString(C6849R.string.hiad_data_size_prompt, m47437a(j10));
    }

    /* renamed from: b */
    public static String m47454b(long j10) {
        try {
            if (j10 < ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS) {
                return j10 + CloudBackupConstant.UserPackageInfo.ONE_T_MEMBER;
            }
            long jCeil = (long) Math.ceil((j10 * 1.0d) / 1024.0d);
            if (jCeil < ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS) {
                return jCeil + "K";
            }
            long jCeil2 = (long) Math.ceil((jCeil * 1.0d) / 1024.0d);
            if (jCeil2 < ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS) {
                return jCeil2 + "M";
            }
            long jCeil3 = (long) Math.ceil((jCeil2 * 1.0d) / 1024.0d);
            if (jCeil3 < ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS) {
                return jCeil3 + CloudBackupConstant.UserPackageInfo.GOLD_MEMBER;
            }
            return ((long) Math.ceil((jCeil3 * 1.0d) / 1024.0d)) + CloudBackupConstant.UserPackageInfo.TRIAL_MEMBER;
        } catch (Throwable th2) {
            AbstractC7185ho.m43823c("FileUtil", "getFileSize " + th2.getClass().getSimpleName());
            return "";
        }
    }

    /* renamed from: c */
    public static String m47460c(long j10) {
        String strM47454b = m47454b(j10);
        if (strM47454b.endsWith(CloudBackupConstant.UserPackageInfo.TRIAL_MEMBER)) {
            return strM47454b;
        }
        if (!AbstractC7806cz.m48165b(strM47454b) && strM47454b.endsWith(CloudBackupConstant.UserPackageInfo.GOLD_MEMBER)) {
            try {
                long j11 = Long.parseLong(strM47454b.substring(0, strM47454b.length() - 1));
                long jPow = (long) Math.pow(2.0d, (int) (Math.log(j11) / Math.log(2.0d)));
                if (j11 > jPow) {
                    jPow = (long) Math.pow(2.0d, r9 + 1);
                }
                return jPow + CloudBackupConstant.UserPackageInfo.GOLD_MEMBER;
            } catch (Throwable th2) {
                AbstractC7185ho.m43823c("FileUtil", "getStorageSize " + th2.getClass().getSimpleName());
            }
        }
        return "";
    }

    /* renamed from: d */
    public static boolean m47464d(File file) {
        return file.exists() && file.length() > 0;
    }

    /* renamed from: e */
    public static void m47466e(File file) {
        if (file == null || !file.exists()) {
            AbstractC7185ho.m43817a("FileUtil", "file is null or file in not exists");
            return;
        }
        if (!file.isFile()) {
            if (file.delete()) {
                return;
            }
            AbstractC7185ho.m43823c("FileUtil", "cannot delete file");
            return;
        }
        File file2 = new File(m47469h(file) + "_delete");
        if (file.renameTo(file2)) {
            if (file2.delete()) {
                return;
            }
        } else if (file.delete()) {
            return;
        }
        AbstractC7185ho.m43823c("FileUtil", "fail to delete file");
    }

    /* renamed from: a */
    public static String m47439a(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        try {
            byte[] bArr = new byte[4];
            if (inputStream.read(bArr, 0, 4) > 0) {
                return AbstractC7740an.m47531a(bArr);
            }
            return null;
        } catch (IOException unused) {
            AbstractC7185ho.m43826d("FileUtil", "fail to read file header");
            return null;
        }
    }

    /* renamed from: b */
    public static void m47455b(File file) {
        if (file.isDirectory()) {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles != null && fileArrListFiles.length > 0) {
                for (File file2 : fileArrListFiles) {
                    if (file2.isDirectory()) {
                        m47455b(file2);
                    } else {
                        m47449a(file2);
                    }
                }
            }
            m47449a(file);
        }
    }

    /* renamed from: c */
    public static void m47461c(File file) throws Throwable {
        String str;
        RandomAccessFile randomAccessFile = null;
        try {
            try {
                RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, "rw");
                try {
                    long length = randomAccessFile2.length();
                    randomAccessFile2.setLength(1 + length);
                    randomAccessFile2.setLength(length);
                    AbstractC7805cy.m48142a(randomAccessFile2);
                } catch (FileNotFoundException unused) {
                    randomAccessFile = randomAccessFile2;
                    str = "fail to update modify time, file not exist";
                    AbstractC7185ho.m43826d("FileUtil", str);
                    AbstractC7805cy.m48142a(randomAccessFile);
                } catch (IOException unused2) {
                    randomAccessFile = randomAccessFile2;
                    str = "fail to update modify time, read file exception";
                    AbstractC7185ho.m43826d("FileUtil", str);
                    AbstractC7805cy.m48142a(randomAccessFile);
                } catch (Throwable th2) {
                    th = th2;
                    randomAccessFile = randomAccessFile2;
                    AbstractC7805cy.m48142a(randomAccessFile);
                    throw th;
                }
            } catch (FileNotFoundException unused3) {
            } catch (IOException unused4) {
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* renamed from: a */
    public static void m47440a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        m47441a(context, str, Constants.NORMAL_CACHE);
    }

    /* renamed from: b */
    public static boolean m47456b(Context context, String str) {
        return C7022dk.m41954i(str) ? C7019dh.m41937a(context, Constants.NORMAL_CACHE).m41973f(str) : m47458b(str);
    }

    /* renamed from: c */
    public static boolean m47462c(Context context, String str, String str2) {
        if (!C7022dk.m41954i(str)) {
            return m47464d(new File(str));
        }
        if (AbstractC7806cz.m48165b(str2)) {
            str2 = Constants.NORMAL_CACHE;
        }
        return C7019dh.m41937a(context, str2).m41974g(str);
    }

    /* renamed from: a */
    public static void m47441a(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!C7022dk.m41954i(str)) {
            m47466e(new File(str));
            return;
        }
        if (AbstractC7806cz.m48165b(str2)) {
            str2 = Constants.NORMAL_CACHE;
        }
        C7019dh.m41937a(context, str2).m41976j(str);
    }

    /* renamed from: b */
    public static boolean m47457b(File file, long j10) {
        return file.exists() && file.length() > 0 && file.length() <= j10;
    }

    /* renamed from: a */
    public static void m47442a(File file, long j10) {
        m47443a(file, j10, (List<File>) null);
    }

    /* renamed from: b */
    public static boolean m47458b(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return new File(str).exists();
        } catch (Exception unused) {
            AbstractC7185ho.m43826d("FileUtil", "check file exists error");
            return false;
        }
    }

    /* renamed from: a */
    public static void m47443a(File file, long j10, List<File> list) {
        new C7847z().m48624a(file, j10, list);
    }

    /* renamed from: a */
    public static void m47444a(String str) {
        if (AbstractC7806cz.m48165b(str)) {
            return;
        }
        m47455b(new File(str));
    }

    /* renamed from: a */
    public static void m47445a(String str, long j10) {
        File[] fileArrListFiles;
        if (AbstractC7806cz.m48165b(str)) {
            return;
        }
        File file = new File(str);
        if (!file.isDirectory() || (fileArrListFiles = file.listFiles()) == null) {
            return;
        }
        for (File file2 : fileArrListFiles) {
            if (file2.lastModified() + j10 < AbstractC7741ao.m47566c()) {
                m47449a(file2);
            }
        }
    }

    /* renamed from: a */
    public static boolean m47446a(long j10, String str) {
        Long lM47459c = m47459c(str);
        return lM47459c == null || j10 <= lM47459c.longValue();
    }

    /* renamed from: a */
    public static boolean m47447a(Context context, File file, String str, ContentResource contentResource, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!C7022dk.m41954i(str)) {
            return m47451a(file, str);
        }
        if (AbstractC7806cz.m48165b(str2)) {
            str2 = Constants.NORMAL_CACHE;
        }
        return C7019dh.m41937a(context, str2).m41962a(file, str, contentResource);
    }

    /* renamed from: a */
    public static boolean m47448a(Context context, File file, String str, String str2) {
        return m47447a(context, file, str, null, str2);
    }

    /* renamed from: a */
    public static boolean m47449a(File file) {
        try {
            File file2 = new File(file.getCanonicalPath() + System.currentTimeMillis());
            if (file.renameTo(file2)) {
                return file2.delete();
            }
            return false;
        } catch (IOException unused) {
            AbstractC7185ho.m43823c("FileUtil", "deleteSingleFile IOException");
            return false;
        }
    }

    /* renamed from: a */
    public static boolean m47450a(File file, File file2) {
        m47466e(file2);
        return file.renameTo(file2);
    }

    /* renamed from: a */
    public static boolean m47451a(File file, String str) {
        return m47450a(file, new File(str));
    }

    /* renamed from: a */
    public static boolean m47452a(String str, File file) {
        if (AbstractC7806cz.m48165b(str)) {
            return false;
        }
        return str.equalsIgnoreCase(AbstractC7801cu.m48124a(file));
    }
}
