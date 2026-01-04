package p618rm;

import android.os.Build;
import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.bean.AndroidLevel;
import com.huawei.android.hicloud.cloudbackup.bean.AppInfoList;
import com.huawei.android.hicloud.cloudbackup.bean.AppVer;
import com.huawei.android.hicloud.cloudbackup.bean.BackupAndroidLevel;
import com.huawei.android.hicloud.cloudbackup.bean.CloudBackup;
import com.huawei.android.hicloud.cloudbackup.bean.Path;
import com.huawei.android.hicloud.cloudbackup.bean.PathMapping;
import com.huawei.android.hicloud.cloudbackup.bean.RestoreAndroidLevel;
import com.huawei.android.hicloud.cloudbackup.process.util.BackupRestoreConstans;
import com.huawei.android.hicloud.cloudbackup.process.util.SplitAppUtil;
import com.huawei.android.hicloud.cloudbackup.util.ICBUtil;
import com.huawei.cloud.base.util.C4633d0;
import com.huawei.hicloud.cloudbackup.p104v3.core.C4880b;
import com.huawei.hicloud.cloudbackup.store.database.status.CloudRestoreStatusV3;
import fk.C9721b;
import hk.C10278a;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import p015ak.C0221j;
import p015ak.C0241z;
import p292fn.C9733f;
import p514o9.C11839m;
import p617rl.C12519c;

/* renamed from: rm.t0 */
/* loaded from: classes6.dex */
public class C12593t0 {

    /* renamed from: a */
    public static int f57988a;

    /* renamed from: b */
    public static final Map<String, Integer> f57989b;

    static {
        HashMap map = new HashMap();
        f57989b = map;
        map.put("EmotionUI_8.0.1", 26);
        map.put("EmotionUI_8.2.0", 27);
        map.put("EmotionUI_9.0.0", 28);
        map.put("EmotionUI_9.0.1", 28);
        map.put("EmotionUI_9.1.0", 28);
        map.put("EmotionUI_9.1.1", 28);
        map.put("EmotionUI_10.0.0", 29);
        map.put("EmotionUI_10.0.1", 29);
        map.put("EmotionUI_10.1.0", 29);
        map.put("EmotionUI_10.1.1", 29);
        map.put("EmotionUI_11.0.0", 29);
        map.put("EmotionUI_11.0.1", 29);
        map.put("EmotionUI_11.1.0", 29);
        map.put("EmotionUI_12.0.0", 29);
        map.put("EmotionUI_12.0.1", 30);
        map.put("EmotionUI_13.0.0", 31);
    }

    /* renamed from: a */
    public static boolean m75968a(String str, int i10) {
        if (str.startsWith(SplitAppUtil.STORAGE_EMULATED + i10)) {
            if (!str.startsWith(SplitAppUtil.STORAGE_EMULATED + i10 + "/Android/")) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    public static void m75969b(String str, String str2, C4880b c4880b) throws C9721b {
        C12574n.m75561n(C10278a.m63442h(str), C10278a.m63442h(str2), c4880b);
    }

    /* renamed from: c */
    public static void m75970c(String str, CloudRestoreStatusV3 cloudRestoreStatusV3, C4880b c4880b, Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        int uid = cloudRestoreStatusV3.getUid();
        if (m75968a(str, uid)) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String strM75973f = m75973f(entry.getKey(), uid);
                if (str.startsWith(strM75973f)) {
                    String strM75978k = m75978k(entry.getValue(), cloudRestoreStatusV3);
                    C11839m.m70686d("CloudRestorePathMappingUtil", "doSdcardPathMapping, downloadFilePath = " + str + ", backupFullPath = " + strM75973f + ", finalRestorePath = " + strM75978k);
                    try {
                        String strReplaceFirst = str.replaceFirst(strM75973f, strM75978k);
                        C12574n.m75550c(str, strReplaceFirst.substring(0, strReplaceFirst.lastIndexOf(File.separator)), c4880b);
                    } catch (C9721b e10) {
                        C11839m.m70687e("CloudRestorePathMappingUtil", "handleSdcardDataPath, moveDirectory error = " + e10);
                    } catch (Exception e11) {
                        C11839m.m70687e("CloudRestorePathMappingUtil", "handleSdcardDataPath error = " + e11.getMessage());
                    }
                }
            }
        }
    }

    /* renamed from: d */
    public static int m75971d() {
        return f57988a;
    }

    /* renamed from: e */
    public static int m75972e(String str) {
        return ((Integer) Optional.ofNullable(f57989b.get(str)).orElse(0)).intValue();
    }

    /* renamed from: f */
    public static String m75973f(String str, int i10) {
        if (str.startsWith("${external}")) {
            return str.replace("${external}", C0221j.m1504n(i10));
        }
        if (!str.startsWith("${sdata}")) {
            return str;
        }
        return str.replace("${sdata}", BackupRestoreConstans.DATA_USER_PATH + i10);
    }

    /* renamed from: g */
    public static Map<String, String> m75974g(CloudRestoreStatusV3 cloudRestoreStatusV3) {
        C11839m.m70686d("CloudRestorePathMappingUtil", "checkPathMapping, appId = " + cloudRestoreStatusV3.getAppId() + ", uid = " + cloudRestoreStatusV3.getUid());
        HashMap map = new HashMap();
        if (!cloudRestoreStatusV3.is3rdAppType()) {
            return map;
        }
        if (C9733f.m60705z().m60720O("cloudBackupPathMapping")) {
            return m75977j(cloudRestoreStatusV3.getVersionCode(), cloudRestoreStatusV3.getAppId());
        }
        C11839m.m70686d("CloudRestorePathMappingUtil", "checkPathMapping switch = false");
        return map;
    }

    /* renamed from: h */
    public static String m75975h(String str) {
        if (C4633d0.m28404a(str)) {
            return "";
        }
        String str2 = ICBUtil.ANDROID_DATA;
        if (!str.startsWith(ICBUtil.ANDROID_DATA)) {
            str2 = ICBUtil.ANDROID_MEDIA;
            if (!str.startsWith(ICBUtil.ANDROID_MEDIA)) {
                str2 = ICBUtil.ANDROID_OBB;
                if (!str.startsWith(ICBUtil.ANDROID_OBB)) {
                    str2 = ICBUtil.ANDROID_OBJ;
                    if (!str.startsWith(ICBUtil.ANDROID_OBJ)) {
                        str2 = ICBUtil.ANDROID_SANDBOX;
                        if (!str.startsWith(ICBUtil.ANDROID_SANDBOX)) {
                            return "";
                        }
                    }
                }
            }
        }
        return str2;
    }

    /* renamed from: i */
    public static void m75976i(Map<String, String> map, List<Path> list) {
        if (list == null) {
            C11839m.m70689w("CloudRestorePathMappingUtil", "getPathMap, pathList is null");
            return;
        }
        for (Path path : list) {
            if (path == null) {
                C11839m.m70689w("CloudRestorePathMappingUtil", "getPathMap, path is null");
            } else {
                String backup = path.getBackup();
                String restore = path.getRestore();
                if (!TextUtils.isEmpty(backup) && !TextUtils.isEmpty(restore)) {
                    map.put(backup, restore);
                }
            }
        }
    }

    /* renamed from: j */
    public static Map<String, String> m75977j(int i10, String str) {
        HashMap map = new HashMap();
        List<AppInfoList> listM75300k = new C12519c().m75300k(str);
        C11839m.m70689w("CloudRestorePathMappingUtil", "getPathMappingMap, appInfoLists is null");
        Iterator<AppInfoList> it = listM75300k.iterator();
        while (it.hasNext()) {
            CloudBackup cloudBackup = it.next().getCloudBackup();
            if (cloudBackup == null) {
                C11839m.m70689w("CloudRestorePathMappingUtil", "getPathMappingMap, cloudBackup is null");
            } else {
                List<PathMapping> pathMapping = cloudBackup.getPathMapping();
                C11839m.m70688i("CloudRestorePathMappingUtil", "getPathMappingMap, appId = " + str + "pathMappingList size = " + pathMapping.size());
                for (PathMapping pathMapping2 : pathMapping) {
                    if (!m75982o(i10, pathMapping2.getAppVer())) {
                        C11839m.m70689w("CloudRestorePathMappingUtil", "getPathMappingMap, not match version");
                    } else if (m75985r(pathMapping2.getBackup(), pathMapping2.getRestore())) {
                        m75976i(map, pathMapping2.getPaths());
                    } else {
                        C11839m.m70689w("CloudRestorePathMappingUtil", "getPathMappingMap, not support ApiLevel");
                    }
                }
            }
        }
        return map;
    }

    /* renamed from: k */
    public static String m75978k(String str, CloudRestoreStatusV3 cloudRestoreStatusV3) {
        String appId = cloudRestoreStatusV3.getAppId();
        int uid = cloudRestoreStatusV3.getUid();
        boolean zIsTwinApp = cloudRestoreStatusV3.isTwinApp();
        if (str.startsWith("${external}")) {
            String strSubstring = str.substring(11);
            if (!m75981n(strSubstring)) {
                String strSubstring2 = strSubstring.substring(8);
                if (TextUtils.isEmpty(m75975h(strSubstring2))) {
                    return "";
                }
                return C12583q.m75678n(appId, uid) + strSubstring2;
            }
            if (zIsTwinApp) {
                return C12583q.m75679o(appId, uid) + strSubstring;
            }
            return C12568l.m75533b(0) + strSubstring;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("${sdata}");
        String str2 = File.separator;
        sb2.append(str2);
        sb2.append(appId);
        if (!str.startsWith(sb2.toString())) {
            C11839m.m70687e("CloudRestorePathMappingUtil", "pathMapping invalid path = " + str);
            return "";
        }
        String strSubstring3 = str.substring(("${sdata}" + str2 + appId).length());
        return (C12583q.m75680p(1) + str2 + appId + str2 + appId) + strSubstring3;
    }

    /* renamed from: l */
    public static boolean m75979l(AndroidLevel androidLevel, int i10) {
        int min = androidLevel.getMin();
        int max = androidLevel.getMax();
        if (i10 <= max && i10 >= min) {
            return true;
        }
        C11839m.m70688i("CloudRestorePathMappingUtil", "checkAndroidLevel, max = " + max + ", min = " + min + ", apiLevel = " + i10);
        return false;
    }

    /* renamed from: m */
    public static boolean m75980m(String str) {
        return str.contains("/UpdateBackup/AppTwinData/");
    }

    /* renamed from: n */
    public static boolean m75981n(String str) {
        return !str.startsWith(ICBUtil.ANDROID + File.separator);
    }

    /* renamed from: o */
    public static boolean m75982o(long j10, List<AppVer> list) {
        if (list.isEmpty()) {
            C11839m.m70688i("CloudRestorePathMappingUtil", "appVersList is null");
            return true;
        }
        for (AppVer appVer : list) {
            if (appVer == null) {
                C11839m.m70689w("CloudRestorePathMappingUtil", "appVer is null");
            } else {
                String min = appVer.getMin();
                String max = appVer.getMax();
                boolean zM75699i = C12585q1.m75699i(j10, min, max, null);
                C11839m.m70688i("CloudRestorePathMappingUtil", "matchVersionCode, matchVersionResult = " + zM75699i + "; min = " + min + "max = " + max + ", versionCode = " + j10);
                if (zM75699i) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: p */
    public static void m75983p(String str, String str2, CloudRestoreStatusV3 cloudRestoreStatusV3, C4880b c4880b) throws C9721b {
        C11839m.m70688i("CloudRestorePathMappingUtil", "pathMapping, prepare to pathMapping,  original backupPath = " + str + ", restorePath = " + str2);
        String strM75978k = m75978k(str, cloudRestoreStatusV3);
        String strM75978k2 = m75978k(str2, cloudRestoreStatusV3);
        C11839m.m70688i("CloudRestorePathMappingUtil", "pathMapping, prepare to copy, " + strM75978k + "  to  " + strM75978k2);
        if (TextUtils.isEmpty(strM75978k) || TextUtils.isEmpty(strM75978k2)) {
            C11839m.m70687e("CloudRestorePathMappingUtil", "pathMapping invalid path");
        }
        m75969b(strM75978k, strM75978k2, c4880b);
    }

    /* renamed from: q */
    public static void m75984q(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            f57988a = C0241z.m1685c(str);
        } else if (TextUtils.isEmpty(str2)) {
            f57988a = 0;
        } else {
            f57988a = m75972e(str2);
        }
    }

    /* renamed from: r */
    public static boolean m75985r(BackupAndroidLevel backupAndroidLevel, RestoreAndroidLevel restoreAndroidLevel) {
        int iM75971d = m75971d();
        int i10 = Build.VERSION.SDK_INT;
        C11839m.m70688i("CloudRestorePathMappingUtil", "supportAndroidApiLevel, backupAndroidLevel = " + backupAndroidLevel + ", curDeviceApiLevel = " + i10);
        if (backupAndroidLevel != null && restoreAndroidLevel != null) {
            return m75979l(backupAndroidLevel.getAndroidLevel(), iM75971d) && m75979l(restoreAndroidLevel.getAndroidLevel(), i10);
        }
        C11839m.m70687e("CloudRestorePathMappingUtil", "supportAndroidApiLevel, backupAndroidLevel or restoreAndroidLevel is null");
        return false;
    }

    /* renamed from: s */
    public static String m75986s(String str, CloudRestoreStatusV3 cloudRestoreStatusV3) {
        if (!TextUtils.isEmpty(str) && cloudRestoreStatusV3 != null) {
            return m75980m(str) ? str.startsWith("storage/Users/currentUser/UpdateBackup/AppTwinData/DCIM") ? str.replace("storage/Users/currentUser/UpdateBackup/AppTwinData/DCIM", String.format("/storage/emulated/%d/Documents/Clone/UpdateBackup/AppTwinData/DCIM", Integer.valueOf(cloudRestoreStatusV3.getUid()))) : str.startsWith("storage/Users/currentUser/UpdateBackup/AppTwinData/Pictures") ? str.replace("storage/Users/currentUser/UpdateBackup/AppTwinData/Pictures", String.format("/storage/emulated/%d/Documents/Clone/UpdateBackup/AppTwinData/Pictures", Integer.valueOf(cloudRestoreStatusV3.getUid()))) : str.startsWith("storage/Users/currentUser/UpdateBackup/AppTwinData/Huawei Share") ? str.replace("storage/Users/currentUser/UpdateBackup/AppTwinData/Huawei Share", String.format("/storage/emulated/%d/Documents/Clone/UpdateBackup/AppTwinData/Huawei Share", Integer.valueOf(cloudRestoreStatusV3.getUid()))) : str.startsWith("storage/Users/currentUser/UpdateBackup/AppTwinData/Sounds") ? str.replace("storage/Users/currentUser/UpdateBackup/AppTwinData/Sounds", String.format("/storage/emulated/%d/Documents/Clone/UpdateBackup/AppTwinData/Sounds", Integer.valueOf(cloudRestoreStatusV3.getUid()))) : str.startsWith("storage/Users/currentUser/UpdateBackup/AppTwinData/Download") ? str.replace("storage/Users/currentUser/UpdateBackup/AppTwinData/Download", String.format("/storage/emulated/%d/Documents/Clone/UpdateBackup/AppTwinData/Download", Integer.valueOf(cloudRestoreStatusV3.getUid()))) : str.startsWith("storage/Users/currentUser/UpdateBackup/AppTwinData/A/media") ? str.replace("storage/Users/currentUser/UpdateBackup/AppTwinData/A/media", String.format("/storage/emulated/%d/Documents/Clone/UpdateBackup/AppTwinData/A/media", Integer.valueOf(cloudRestoreStatusV3.getUid()))) : str.startsWith("storage/Users/currentUser/UpdateBackup/AppTwinData") ? str.replace("storage/Users/currentUser/UpdateBackup/AppTwinData", String.format("/storage/emulated/%d/Documents/Clone/UpdateBackup/AppTwinData", Integer.valueOf(cloudRestoreStatusV3.getUid()))) : str : str.startsWith("storage/Users/currentUser/DCIM") ? str.replace("storage/Users/currentUser/DCIM", String.format("/storage/emulated/%d/DCIM", Integer.valueOf(cloudRestoreStatusV3.getUid()))) : str.startsWith("storage/Users/currentUser/Pictures") ? str.replace("storage/Users/currentUser/Pictures", String.format("/storage/emulated/%d/Pictures", Integer.valueOf(cloudRestoreStatusV3.getUid()))) : str.startsWith("storage/Users/currentUser/Huawei Share") ? str.replace("storage/Users/currentUser/Huawei Share", String.format("/storage/emulated/%d/Huawei Share", Integer.valueOf(cloudRestoreStatusV3.getUid()))) : str.startsWith("storage/Users/currentUser/Sounds") ? str.replace("storage/Users/currentUser/Sounds", String.format("/storage/emulated/%d/Sounds", Integer.valueOf(cloudRestoreStatusV3.getUid()))) : str.startsWith("storage/Users/currentUser/Download") ? str.replace("storage/Users/currentUser/Download", String.format("/storage/emulated/%d/Download", Integer.valueOf(cloudRestoreStatusV3.getUid()))) : str.startsWith("storage/Users/currentUser/UpdateBackup/A/media") ? str.replace("storage/Users/currentUser/UpdateBackup/A/media", String.format("/storage/emulated/%d/Android/media", Integer.valueOf(cloudRestoreStatusV3.getUid()))) : str.startsWith("storage/Users/currentUser/UpdateBackup") ? str.replace("storage/Users/currentUser/UpdateBackup", String.format("/storage/emulated/%d", Integer.valueOf(cloudRestoreStatusV3.getUid()))) : str.startsWith("storage/Users/currentUser") ? str.replace("storage/Users/currentUser", String.format("/storage/emulated/%d/Documents/Clone", Integer.valueOf(cloudRestoreStatusV3.getUid()))) : str;
        }
        C11839m.m70689w("CloudRestorePathMappingUtil", "destination or restoreStatus is empty");
        return "";
    }
}
