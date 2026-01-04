package com.huawei.android.hicloud.cloudbackup.process.util;

import com.huawei.android.backup.filelogic.utils.PmsCheckUtil;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.cloudbackup.process.util.BackupRestoreUtil;
import com.huawei.android.hicloud.cloudbackup.util.ICBUtil;
import com.huawei.secure.android.common.util.SafeString;
import hk.C10278a;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import mk.C11476b;
import p015ak.C0209d;
import p015ak.C0213f;
import p514o9.C11835i;
import p514o9.C11839m;
import p618rm.C12583q;

/* loaded from: classes2.dex */
public final class PmsUtils {
    private static final int FAST_COPY_FEATURE_PMS_VER = 5;
    private static final int NEW_FEATURE_PMS_VER = 5;
    private static final String TAG = "PmsUtils";
    private static int pmsVer = -1;

    private static String convertDataPathPrefix(String str, int i10) {
        return BackupRestoreConstans.getUserPath(i10) + File.separator + SafeString.substring(str, 11);
    }

    public static boolean copyAndroidDataFileByBrief(BackupRestoreUtil backupRestoreUtil, String str, String str2, int i10, String str3) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(SplitAppUtil.splitAppDestAndroidDataPathToWritePath(str, i10));
        BackupRestoreUtil.BriefSupplier brief = backupRestoreUtil.getBrief(CloudBackupConstant.Command.PMS_OPTION_FILE, arrayList, null, i10, str3);
        String resultFilePath = brief.getResultFilePath();
        boolean zM70654r = false;
        if (!brief.isValid()) {
            C11839m.m70687e(TAG, "copyAndroidDataFileByBrief copy data error:" + resultFilePath + " is not exist");
            brief.close();
            return false;
        }
        File fileM63442h = null;
        try {
            String strM75673i = C12583q.m75673i(str3);
            File fileM63442h2 = C10278a.m63442h(strM75673i);
            boolean z10 = (fileM63442h2.exists() || fileM63442h2.mkdirs()) ? false : true;
            String strM68626h = C11476b.m68626h(str);
            String str4 = strM75673i + strM68626h;
            fileM63442h = C10278a.m63442h(str4);
            C11835i.m70642f(fileM63442h);
            int iBackup = backupRestoreUtil.backup(CloudBackupConstant.Command.PMS_OPTION_FILE, resultFilePath, str4);
            if (iBackup == 0 && fileM63442h.exists()) {
                File fileM63442h3 = C10278a.m63442h(str2);
                if (!fileM63442h3.exists()) {
                    fileM63442h3.mkdirs();
                }
                String name = C10278a.m63442h(str).getName();
                File fileM63441g = C10278a.m63441g(fileM63442h, name);
                if (!fileM63441g.exists()) {
                    fileM63441g = C10278a.m63443i(str4 + File.separator + strM68626h, name);
                }
                zM70654r = C11835i.m70654r(fileM63441g, C10278a.m63441g(fileM63442h3, name));
            }
            C11839m.m70688i(TAG, "copyAndroidDataFileByBrief copy data end, left space: " + ICBUtil.getLocalLeftSpace() + ", pmsResult: " + iBackup + " ,srcPath: " + str + " ,rootDirMkResult: " + z10 + " ,result: " + zM70654r);
            brief.close();
            if (fileM63442h != null) {
                C11835i.m70642f(fileM63442h);
            }
            return zM70654r;
        } catch (Throwable th2) {
            brief.close();
            if (fileM63442h != null) {
                C11835i.m70642f(fileM63442h);
            }
            throw th2;
        }
    }

    public static void generatePmsFilterFileContent(List<String> list, List<String> list2, FileOutputStream fileOutputStream, int i10) throws IOException {
        for (String strConvertDataPathPrefix : list) {
            if (strConvertDataPathPrefix.startsWith(BackupRestoreConstans.DATA_PATH)) {
                strConvertDataPathPrefix = convertDataPathPrefix(strConvertDataPathPrefix, i10);
            }
            C11839m.m70686d(TAG, "v3 generatePmsByFile includePath: " + strConvertDataPathPrefix);
            fileOutputStream.write(("[include]" + strConvertDataPathPrefix + "\n").getBytes(StandardCharsets.UTF_8));
        }
        if (list2 != null) {
            for (String strConvertDataPathPrefix2 : list2) {
                if (strConvertDataPathPrefix2.startsWith(BackupRestoreConstans.DATA_PATH)) {
                    strConvertDataPathPrefix2 = convertDataPathPrefix(strConvertDataPathPrefix2, i10);
                }
                C11839m.m70686d(TAG, "v3 generatePmsByFile excludePath: " + strConvertDataPathPrefix2);
                fileOutputStream.write(("[exclude]" + strConvertDataPathPrefix2 + "\n").getBytes(StandardCharsets.UTF_8));
            }
        }
    }

    public static boolean isSupportNewRYFeature() {
        if (!C0209d.m1281m1()) {
            return false;
        }
        int i10 = pmsVer;
        if (i10 > 0) {
            return i10 >= 5;
        }
        if (C0213f.m1377a() == null) {
            return false;
        }
        try {
            pmsVer = PmsCheckUtil.m12607a();
            C11839m.m70688i(TAG, "isSupportNewRYFeature pmsVer: " + pmsVer);
            return pmsVer >= 5;
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "isSupportNewRYFeature getPmsVer Exception " + e10.getMessage());
            return false;
        }
    }

    public static boolean isSupportPMSFastCopy() {
        if (!C0209d.m1285n1() || C0213f.m1377a() == null) {
            return false;
        }
        try {
            if (pmsVer < 0) {
                pmsVer = PmsCheckUtil.m12607a();
                C11839m.m70688i(TAG, "isSupportPMSFastCopy pmsVer: " + pmsVer);
            }
            return pmsVer >= 5;
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "isSupportPMSFastCopy getPmsVer Exception " + e10.getMessage());
            return false;
        }
    }
}
