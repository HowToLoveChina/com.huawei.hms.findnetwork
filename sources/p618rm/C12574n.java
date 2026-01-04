package p618rm;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.process.util.BackupCacheRecord;
import com.huawei.android.hicloud.cloudbackup.process.util.BackupRestoreConstans;
import com.huawei.android.hicloud.cloudbackup.report.CloudBackupReport;
import com.huawei.android.hicloud.cloudbackup.util.ICBUtil;
import com.huawei.hicloud.cloudbackup.p104v3.core.C4880b;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import fk.C9721b;
import hk.C10278a;
import hk.C10279b;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import mk.C11476b;
import p514o9.C11835i;
import p514o9.C11839m;
import p682ul.C13216j;
import p744wl.C13617a;

/* renamed from: rm.n */
/* loaded from: classes6.dex */
public class C12574n {

    /* renamed from: a */
    public static final String f57931a = "n";

    /* renamed from: b */
    public static String f57932b;

    /* renamed from: a */
    public static boolean m75548a(File file, File file2) {
        try {
            return TextUtils.equals(C11476b.m68622d(file2).getHash(), C11476b.m68622d(file).getHash());
        } catch (C9721b e10) {
            C11839m.m70687e(f57931a, "compareFileHash file hash error: " + e10.getMessage());
            return false;
        }
    }

    /* renamed from: b */
    public static void m75549b(File file, File file2, C4880b c4880b) throws C9721b, IOException {
        ArrayList arrayList;
        File[] fileArrListFiles;
        C11835i.m70638b(file, file2);
        if (!file.isDirectory()) {
            throw new IOException("Source '" + file + "' exists but is not a directory");
        }
        if (C10279b.m63452a(file).equals(C10279b.m63452a(file2))) {
            throw new IOException("Source '" + file + "' and destination '" + file2 + "' are the same");
        }
        if (!C10279b.m63452a(file2).startsWith(C10279b.m63452a(file)) || (fileArrListFiles = file.listFiles()) == null || fileArrListFiles.length <= 0) {
            arrayList = null;
        } else {
            arrayList = new ArrayList(fileArrListFiles.length);
            for (File file3 : fileArrListFiles) {
                arrayList.add(C10279b.m63452a(C10278a.m63441g(file2, file3.getName())));
            }
        }
        f57932b = null;
        m75559l(file, file2, arrayList, c4880b);
        if (TextUtils.isEmpty(f57932b)) {
            return;
        }
        CloudBackupReport.reportRestoreCopyErrorInfo(f57932b);
    }

    /* renamed from: c */
    public static void m75550c(String str, String str2, C4880b c4880b) throws C9721b, IOException {
        File fileM63442h = C10278a.m63442h(str);
        File fileM63442h2 = C10278a.m63442h(str2);
        if (!fileM63442h.exists()) {
            C11839m.m70689w(f57931a, "copyFile, srcFile not exist");
            return;
        }
        if (fileM63442h2.exists()) {
            if (!fileM63442h2.isDirectory()) {
                throw new IOException("copyFile occurs error destination '" + fileM63442h2 + "' exists but is not a directory");
            }
        } else if (!fileM63442h2.mkdirs()) {
            throw new IOException("copyFile occurs error destination '" + fileM63442h2 + "' directory cannot be created");
        }
        m75551d(fileM63442h, C10278a.m63441g(fileM63442h2, fileM63442h.getName()), c4880b);
    }

    /* renamed from: d */
    public static boolean m75551d(File file, File file2, C4880b c4880b) throws C9721b {
        if (file2.exists()) {
            if (m75548a(file, file2)) {
                C11839m.m70686d(f57931a, "copyFileCover file alread exist destFile: " + C10279b.m63452a(file2));
                return true;
            }
            C11839m.m70688i(f57931a, "copyFileCover dest file already exist, delete first, result = " + file2.delete());
        }
        c4880b.isRelease();
        return C11835i.m70657u(file, file2, 0L);
    }

    /* renamed from: e */
    public static void m75552e(Context context) {
        File fileM63441g = C10278a.m63441g(context.getExternalCacheDir(), "cloudbackup");
        if (fileM63441g.exists()) {
            C12571m.m75547i(C10279b.m63452a(fileM63441g));
        }
    }

    /* renamed from: f */
    public static void m75553f(Context context, boolean z10) {
        if (z10) {
            File fileM63441g = C10278a.m63441g(context.getFilesDir(), "cloudbackup");
            if (fileM63441g.exists()) {
                C13216j.m79421f();
                C12571m.m75542d(C10279b.m63452a(fileM63441g));
            }
            C12571m.m75542d(C12586r.m75713d());
        }
    }

    /* renamed from: g */
    public static void m75554g(Context context, boolean z10) {
        if (z10) {
            File fileM63441g = C10278a.m63441g(context.getFilesDir(), "cloudbackup");
            if (fileM63441g.exists()) {
                C13216j.m79421f();
                C12571m.m75547i(C10279b.m63452a(fileM63441g));
            }
            C12571m.m75547i(C12586r.m75713d());
        }
    }

    /* renamed from: h */
    public static void m75555h(Context context, String str, String str2, int i10) {
        String strM75674j = C12583q.m75674j(0);
        C13216j.m79422g(C13617a.m81914C(str, i10));
        C12571m.m75542d(strM75674j + "/" + str);
        if (i10 != 0) {
            C12571m.m75542d(C12583q.m75686v(strM75674j, i10, str2));
            C12571m.m75542d(C12583q.m75653G(str2));
            C12571m.m75542d(C12586r.m75714e(str2, i10));
        }
        C12571m.m75542d(C12583q.m75680p(0) + File.separator + str);
        C12571m.m75542d(C12583q.m75656J(str, i10));
        C12571m.m75542d(C12586r.m75714e(str, i10));
        C12571m.m75542d(C12583q.m75662P(str, i10));
        BackupCacheRecord.delete(context, str);
    }

    /* renamed from: i */
    public static void m75556i(Context context) {
        File fileM63441g = C10278a.m63441g(context.getExternalCacheDir(), "cloudbackup");
        if (fileM63441g.exists()) {
            C12571m.m75542d(C10279b.m63452a(fileM63441g));
        }
        File fileM63441g2 = C10278a.m63441g(context.getFilesDir(), "HiCloudAppFiles.json");
        if (fileM63441g2.exists() && fileM63441g2.delete()) {
            C12571m.m75542d(C10279b.m63452a(fileM63441g2));
        }
    }

    /* renamed from: j */
    public static void m75557j(File file) throws C9721b {
        if (file == null || !file.exists()) {
            C11839m.m70689w(f57931a, "deleteFileFromTempDir file is null or empty!");
            return;
        }
        String strM63452a = C10279b.m63452a(file);
        boolean zIsDirectory = file.isDirectory();
        if (zIsDirectory) {
            for (File file2 : C10278a.m63440f(file)) {
                m75557j(file2);
            }
        }
        C12571m.m75547i(strM63452a);
        C11839m.m70688i(f57931a, "deleteFileFromTempDir path=" + strM63452a);
        if (file.exists()) {
            throw new C9721b(1017, "deleteFileFromTempDir error = " + strM63452a + " ,directory " + zIsDirectory);
        }
    }

    /* renamed from: k */
    public static void m75558k(Context context) {
        File fileM63441g = C10278a.m63441g(context.getFilesDir(), "cloudrestore");
        if (fileM63441g.exists()) {
            C12571m.m75542d(C10279b.m63452a(fileM63441g));
        }
        File fileM63442h = C10278a.m63442h(ICBUtil.getHwCloudApkInstallCachePath());
        if (fileM63442h.exists()) {
            C12571m.m75542d(C10279b.m63452a(fileM63442h));
        }
        String androidDataCacheRootPath = ICBUtil.getAndroidDataCacheRootPath();
        if (C10278a.m63442h(androidDataCacheRootPath).exists()) {
            C12571m.m75542d(androidDataCacheRootPath);
        }
    }

    /* renamed from: l */
    public static void m75559l(File file, File file2, List<String> list, C4880b c4880b) throws C9721b, IOException {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            throw new IOException("doCopyDirectoryCover occurs error list contents of " + file);
        }
        if (file2.exists()) {
            if (!file2.isDirectory()) {
                throw new IOException("doCopyDirectoryCover occurs error destination '" + file2 + "' exists but is not a directory");
            }
        } else if (!file2.mkdirs() && !file2.isDirectory()) {
            throw new IOException("doCopyDirectoryCover occurs error destination '" + file2 + "' directory cannot be created");
        }
        if (!file2.canWrite()) {
            throw new IOException("doCopyDirectoryCover occurs error destination '" + file2 + "' cannot be written to");
        }
        for (File file3 : fileArrListFiles) {
            File fileM63441g = C10278a.m63441g(file2, file3.getName());
            if (list == null || !list.contains(C10279b.m63452a(file3))) {
                if (file3.isDirectory()) {
                    m75559l(file3, fileM63441g, list, c4880b);
                } else {
                    if (!m75551d(file3, fileM63441g, c4880b)) {
                        C11839m.m70688i(f57931a, "doCopyDirectory copy file error");
                        f57932b = fileM63441g.getPath();
                    }
                    if (!file3.delete()) {
                        C11839m.m70688i(f57931a, "doCopyDirectory delete src error");
                    }
                }
            }
        }
    }

    /* renamed from: m */
    public static void m75560m(String str, String str2, int i10, String str3, File file) throws C9721b {
        String strReplaceFirst = str3.replaceFirst(BackupRestoreConstans.getUserPath(i10), "").replaceFirst("(;\\d+){4}$", "");
        String str4 = f57931a;
        C11839m.m70686d(str4, "matchFilePathAndDelete abnormalFilePath=" + strReplaceFirst);
        if (TextUtils.isEmpty(strReplaceFirst)) {
            C11839m.m70689w(str4, "matchFilePathAndDelete abnormalFilePath is empty!");
            return;
        }
        if (!TextUtils.equals(str, str2)) {
            strReplaceFirst = strReplaceFirst.replaceFirst(str2, str);
        }
        m75557j(C10278a.m63441g(file, strReplaceFirst));
    }

    /* renamed from: n */
    public static void m75561n(File file, File file2, C4880b c4880b) throws C9721b {
        String strM63452a = C10279b.m63452a(file2);
        String strM63452a2 = C10279b.m63452a(file);
        C11839m.m70686d(f57931a, "moveDirectoryCover src: " + strM63452a2 + " destPath: " + strM63452a);
        if (!file.isDirectory()) {
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "Source '" + file + "' is not a directory");
        }
        if (strM63452a.startsWith(strM63452a2 + File.separator)) {
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "Cannot move directory: " + file + " to a subdirectory of itself: " + file2);
        }
        try {
            m75549b(file, file2, c4880b);
            C12571m.m75547i(strM63452a2);
            if (file.exists()) {
                throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "Failed to delete original directory '" + file + "' after copy to '" + file2 + "'");
            }
        } catch (IOException e10) {
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "copyDirectoryCover error: " + file + " to a subdirectory of itself: " + file2 + " error: " + e10.getMessage());
        }
    }
}
