package com.huawei.android.hicloud.cloudbackup.util;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import androidx.core.content.p019pm.PackageInfoCompat;
import ck.C1444b;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.huawei.android.backup.filelogic.utils.PmsCheckUtil;
import com.huawei.android.hicloud.cloudbackup.callable.CBCallBack;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.cloudbackup.p076db.bean.Albums;
import com.huawei.android.hicloud.cloudbackup.p076db.operator.AlbumOperator;
import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.operator.PmsFullBriefFilesInfoOperator;
import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.operator.PmsFullBriefFilesInfoOperatorV3;
import com.huawei.android.hicloud.cloudbackup.process.util.ScanAppDataUtil;
import com.huawei.android.hicloud.cloudbackup.process.util.SplitAppUtil;
import com.huawei.android.hicloud.cloudbackup.service.ReportAppMarketManager;
import com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.bean.SnapshotBackupMeta;
import com.huawei.fastengine.fastview.NavigationUtils;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.Bak;
import com.huawei.hicloud.cloudbackup.store.database.status.CloudBackupStatus;
import com.huawei.hicloud.cloudbackup.store.database.tags.BackupOptionItem;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.router.data.AppInfo;
import com.huawei.hidisk.common.util.javautil.StringUtil;
import com.tencent.p204mm.opensdk.constants.ConstantsAPI;
import fk.C9721b;
import hk.C10278a;
import hk.C10279b;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import ni.C11707b;
import p015ak.C0208c0;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0221j;
import p015ak.C0224k0;
import p020ap.C1006a;
import p037bp.C1270a;
import p223db.C9062b;
import p232dp.InterfaceC9282a;
import p514o9.C11835i;
import p514o9.C11839m;
import p523oi.C11903a;
import p617rl.C12526j;
import p618rm.C12540b1;
import p618rm.C12568l;
import p618rm.C12583q;
import p618rm.C12590s0;
import p618rm.C12591s1;
import p744wl.C13617a;
import p848zl.C14333b;
import tl.C13026e;

/* loaded from: classes2.dex */
public class ICBUtil {
    public static final String ANDROID = "/Android";
    public static final String ANDROID_DATA = "/data/";
    private static final String ANDROID_DATA_CLOUDBACKUP = "/cloudbackup/";
    public static final String ANDROID_MEDIA = "/media/";
    public static final String ANDROID_OBB = "/obb/";
    public static final String ANDROID_OBJ = "/obj/";
    public static final String ANDROID_SANDBOX = "/sandbox/";
    private static final String DEFAULT_CANONICAL_PATH = "/storage/emulated/0/Android/data/com.huawei.hidisk/cache";
    private static final String HM_NEXT = "HM_NEXT";
    private static final String IP_PATTERN_STRING = "[<>#%&!;|:\"*?]";
    public static final long LOCAL_ENCRYPT_SPACE = 314572800;
    public static final long LOCAL_LIMIT_SPACE = 314572800;
    private static final int PROCESS_UID_MAX_VALUE = 99999;
    private static final String RELATIVE_CLOUDBACKUP_PATH = "/data/data/com.huawei.hidisk/files/cloudbackup";
    private static final String RELATIVE_EXTERNAL_PATH = "/external";
    public static final String RELATIVE_SDATA_PATH = "/sdata";
    public static final String RELATIVE_SDCARD_PATH = "/sdcard";
    public static final String RELATIVE_USB_PATH = "/usb";
    private static final String SPECIALTEMP = "specialtemp";
    private static final String TAG = "ICBUtil";
    public static final String TAR_LOCAL_DIR = "/tar/";
    private static Pattern ipPattern;
    private static final Map<String, String> SPACE_DEFAULT_MODULES = new HashMap<String, String>() { // from class: com.huawei.android.hicloud.cloudbackup.util.ICBUtil.1
        public C27111() {
            put("/NoteSync", "sync");
            put("/RecordBackup", "record");
            put("/NoteSync", "notepad");
            put("/BlockedBackup", "phonemanager");
        }
    };
    private static final List<String> SUPPORT_DELETE_MODULES = new ArrayList<String>() { // from class: com.huawei.android.hicloud.cloudbackup.util.ICBUtil.2
        public C27122() {
            add("record");
            add("gallerydelete");
            add("phonemanager");
        }
    };
    private static final List<String> AUTO_BACKUP_ERROR_CODE = new ArrayList<String>() { // from class: com.huawei.android.hicloud.cloudbackup.util.ICBUtil.3
        public C27133() {
            add(String.valueOf(1002));
            add(String.valueOf(3900));
            add(String.valueOf(1005));
            add(String.valueOf(1006));
        }
    };

    /* renamed from: com.huawei.android.hicloud.cloudbackup.util.ICBUtil$1 */
    public class C27111 extends HashMap<String, String> {
        public C27111() {
            put("/NoteSync", "sync");
            put("/RecordBackup", "record");
            put("/NoteSync", "notepad");
            put("/BlockedBackup", "phonemanager");
        }
    }

    /* renamed from: com.huawei.android.hicloud.cloudbackup.util.ICBUtil$2 */
    public class C27122 extends ArrayList<String> {
        public C27122() {
            add("record");
            add("gallerydelete");
            add("phonemanager");
        }
    }

    /* renamed from: com.huawei.android.hicloud.cloudbackup.util.ICBUtil$3 */
    public class C27133 extends ArrayList<String> {
        public C27133() {
            add(String.valueOf(1002));
            add(String.valueOf(3900));
            add(String.valueOf(1005));
            add(String.valueOf(1006));
        }
    }

    /* renamed from: com.huawei.android.hicloud.cloudbackup.util.ICBUtil$4 */
    public class C27144 implements PrivilegedAction {
        final /* synthetic */ Method val$method;

        public C27144(Method method) {
            method = method;
        }

        @Override // java.security.PrivilegedAction
        public Object run() throws SecurityException {
            method.setAccessible(true);
            return null;
        }
    }

    public static class MapTokenType extends TypeToken<Map<String, String>> {
        private MapTokenType() {
        }

        public /* synthetic */ MapTokenType(C27111 c27111) {
            this();
        }
    }

    public static class MapType extends TypeToken<Map<String, String>> {
    }

    public static void checkDataLocalLimitSpace(String str) throws C9721b {
        Long localLeftSpace = getLocalLeftSpace();
        if (localLeftSpace == null || localLeftSpace.longValue() >= 314572800) {
            return;
        }
        C12590s0.m75777N2(314572800 - localLeftSpace.longValue());
        throw new C9721b(1007, str + localLeftSpace);
    }

    public static boolean checkFileName(String str) {
        if (ipPattern == null) {
            ipPattern = Pattern.compile(IP_PATTERN_STRING);
        }
        return ipPattern.matcher(str).find();
    }

    private static void checkIsOutSizeAlbum(Albums albums) {
        boolean zExists;
        boolean zExists2;
        String relativePath = albums.getRelativePath();
        String strM1512v = C0221j.m1512v();
        String strM1514x = C0221j.m1514x();
        if (TextUtils.isEmpty(strM1512v)) {
            zExists = false;
        } else {
            zExists = C10278a.m63442h(strM1512v + relativePath + File.separator + Albums.OUTSIDE_FILE_NAME).exists();
            C11839m.m70686d(TAG, "external isOutside = " + zExists + " path =" + strM1512v + relativePath + File.pathSeparator + Albums.OUTSIDE_FILE_NAME);
        }
        if (TextUtils.isEmpty(strM1514x)) {
            zExists2 = false;
        } else {
            zExists2 = C10278a.m63442h(strM1514x + relativePath + File.separator + Albums.OUTSIDE_FILE_NAME).exists();
            C11839m.m70686d(TAG, "sdcard isOutside = " + zExists2 + " path =" + strM1514x + relativePath + File.pathSeparator + Albums.OUTSIDE_FILE_NAME);
        }
        if (zExists && zExists2) {
            albums.setOutside(1);
            return;
        }
        if (!zExists && !zExists2) {
            albums.setOutside(0);
            return;
        }
        if (!zExists && zExists2) {
            albums.setOutside(2);
        } else {
            if (!zExists || zExists2) {
                return;
            }
            albums.setOutside(3);
        }
    }

    public static void checkModuleNeedLocalSize(String str, String str2, boolean z10) throws C9721b {
        Long localLeftSpace = getLocalLeftSpace();
        if (localLeftSpace == null) {
            C11839m.m70689w(TAG, "checkModuleNeedLocalSize getLocalLeftSpace is null.");
            return;
        }
        long appDataNeedLocalSize = getAppDataNeedLocalSize(str, str2, z10) + getLocalTarNeedSize(C1444b.m8308n()) + C12590s0.m75856h0();
        C11839m.m70688i(TAG, "checkModuleNeedLocalSize " + str + " , needlocalspace: " + appDataNeedLocalSize);
        if (appDataNeedLocalSize <= 0) {
            return;
        }
        long jLongValue = appDataNeedLocalSize - localLeftSpace.longValue();
        if (jLongValue <= 0) {
            return;
        }
        C12590s0.m75777N2(jLongValue);
        throw new C9721b(1007, "checkModuleNeedLocalSize appId: " + str + " needMoreLocalSize: " + jLongValue);
    }

    private static String checkPath(String str, String str2) {
        String relativePath = getRelativePath(str, str2);
        if (relativePath.startsWith(RELATIVE_SDATA_PATH) || relativePath.startsWith(RELATIVE_SDCARD_PATH) || relativePath.startsWith(RELATIVE_EXTERNAL_PATH) || relativePath.startsWith(RELATIVE_USB_PATH)) {
            return relativePath;
        }
        if (relativePath.startsWith("/data") && relativePath.contains("/cloudbackup")) {
            return relativePath;
        }
        C11839m.m70689w(TAG, "checkPath relative path not right path = " + relativePath);
        return RELATIVE_EXTERNAL_PATH + relativePath;
    }

    public static boolean checkPrivacyUser(Context context) {
        if (context == null || !C0209d.m1173G1(context)) {
            return false;
        }
        C11839m.m70688i(TAG, "CloudBackup check isPrivacyUser, now exit Cloud!");
        C9062b.m57146k().m57155h(false, false);
        return true;
    }

    private static String checkRelativePathIsRoot(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return str + File.separator;
        }
        return str + str2;
    }

    public static String checkTarPrePathMoveRoot(String str) {
        return (str.startsWith(RELATIVE_SDCARD_PATH) && TextUtils.isEmpty(C0221j.m1514x())) ? str.substring(7) : (str.startsWith(RELATIVE_USB_PATH) && TextUtils.isEmpty(C0221j.m1474B())) ? str.substring(4) : str;
    }

    public static void closeBackGroundProcess(String str, Context context, int i10) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        try {
            C11839m.m70688i(TAG, "closeBackGroundProcess appId = " + str);
            Method method = activityManager.getClass().getMethod("forceStopPackageAsUser", String.class, Integer.TYPE);
            AccessController.doPrivileged(new PrivilegedAction() { // from class: com.huawei.android.hicloud.cloudbackup.util.ICBUtil.4
                final /* synthetic */ Method val$method;

                public C27144(Method method2) {
                    method = method2;
                }

                @Override // java.security.PrivilegedAction
                public Object run() throws SecurityException {
                    method.setAccessible(true);
                    return null;
                }
            });
            method2.invoke(activityManager, str, Integer.valueOf(i10));
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "closeBackGroundProcess error " + e10.toString());
        }
    }

    public static void closeStream(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e10) {
                C11839m.m70687e(TAG, "getWrite error: " + e10.toString());
            }
        }
    }

    public static String convertToAbsolutePath(String str, String str2, String str3) {
        String strCheckPath = checkPath(str, str2);
        return (str3 == null || str3.isEmpty()) ? convertToAbsolutePath(strCheckPath, str2) : C14333b.m85491z().contains(str3) ? getMediaTempPath(strCheckPath, str2, str3) : convertToAbsolutePath(strCheckPath, str2);
    }

    public static void dealDefaultMoudles(List<String> list) {
        list.addAll(C14333b.m85487v());
        list.addAll(C14333b.m85488w());
        list.addAll(C14333b.m85489x());
    }

    public static void dealSystemModules(List<String> list, List<String> list2, boolean z10) {
        list.addAll(C14333b.m85487v());
        list.addAll(C14333b.m85485t());
        list.remove("calendar");
        list.remove("harassment");
        list.remove("smartcare");
        list.remove("weather");
        list2.add("calendar");
        list2.add("harassment");
        list2.add("smartcare");
        list2.add("weather");
        if (!z10) {
            list.remove("baiduInput");
            list.remove("alarm");
            list.remove("clock");
            list.remove("camera");
            list2.add("baiduInput");
            list2.add("alarm");
            list2.add("clock");
            list2.add("camera");
        }
        list2.addAll(C14333b.m85488w());
    }

    public static Bitmap drawable2Bitmap(Drawable drawable) {
        try {
            if (drawable instanceof BitmapDrawable) {
                return ((BitmapDrawable) drawable).getBitmap();
            }
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth > 0 && intrinsicHeight > 0) {
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
                Canvas canvas = new Canvas(bitmapCreateBitmap);
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                drawable.draw(canvas);
                return bitmapCreateBitmap;
            }
            C11839m.m70687e(TAG, "drawable2Bitmap error intrinsicWidth or intrinsicHeight <= 0");
            return null;
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "drawable2Bitmap error: " + e10.toString());
            return null;
        }
    }

    public static void drawable2File(Drawable drawable, String str) throws IOException {
        FileOutputStream fileOutputStreamM63446l;
        C11839m.m70688i(TAG, "get icon bitmap");
        Bitmap bitmapDrawable2Bitmap = drawable2Bitmap(drawable);
        if (bitmapDrawable2Bitmap == null) {
            return;
        }
        File fileM63442h = C10278a.m63442h(str);
        if (fileM63442h.exists() && fileM63442h.delete()) {
            C11839m.m70686d(TAG, "clear temp file.");
        }
        FileOutputStream fileOutputStream = null;
        try {
            try {
                try {
                    C11839m.m70688i(TAG, "write bitmap to file");
                    fileOutputStreamM63446l = C10278a.m63446l(str);
                    if (bitmapDrawable2Bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStreamM63446l)) {
                        fileOutputStreamM63446l.flush();
                        C11839m.m70688i(TAG, "get icon success");
                    } else {
                        C11839m.m70689w(TAG, "write Bitmap to OutputStream failed");
                    }
                } catch (IOException e10) {
                    C11839m.m70687e(TAG, e10.getMessage());
                    if (0 == 0) {
                        return;
                    } else {
                        fileOutputStream.close();
                    }
                }
                if (fileOutputStreamM63446l != null) {
                    fileOutputStreamM63446l.close();
                }
            } catch (Throwable th2) {
                if (0 != 0) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e11) {
                        C11839m.m70687e(TAG, e11.getMessage());
                    }
                }
                throw th2;
            }
        } catch (IOException e12) {
            C11839m.m70687e(TAG, e12.getMessage());
        }
    }

    public static String[] getAllSplitApksPath(PackageInfo packageInfo) {
        String[] strArr = new String[0];
        if (packageInfo == null) {
            C11839m.m70687e(TAG, "getAllSplitApksPath: packageInfo is null.");
            return strArr;
        }
        String[] strArr2 = packageInfo.applicationInfo.splitSourceDirs;
        if (strArr2 != null && strArr2.length != 0) {
            return strArr2;
        }
        C11839m.m70687e(TAG, "splitSourceDirs is empty.");
        return strArr;
    }

    public static String getAndroidDataCacheRootPath() {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            return "";
        }
        String strM63452a = C10279b.m63452a(contextM1377a.getExternalCacheDir());
        if (strM63452a == null) {
            C11839m.m70689w(TAG, "getAndroidDataCacheRootPath, canonicalPath is null");
            strM63452a = DEFAULT_CANONICAL_PATH;
        }
        String strM1512v = C0221j.m1512v();
        String strM1513w = C0221j.m1513w();
        if (TextUtils.isEmpty(strM1513w) || !strM63452a.startsWith(strM1513w)) {
            return strM63452a + ANDROID_DATA_CLOUDBACKUP;
        }
        return strM63452a.replace(strM1513w, strM1512v) + ANDROID_DATA_CLOUDBACKUP;
    }

    public static String getApkTempPath(String str) {
        return "/sdata/" + str + "/" + str + ".apk";
    }

    private static long getAppDataNeedLocalSize(String str, String str2, boolean z10) {
        String strM81914C = C13617a.m81914C(str, 0);
        long jQuerySumToCopySize = (z10 ? new PmsFullBriefFilesInfoOperatorV3(strM81914C) : new PmsFullBriefFilesInfoOperator(strM81914C)).querySumToCopySize();
        if (jQuerySumToCopySize <= 0) {
            return ScanAppDataUtil.get3rdAppDataDirSize(str2, 0);
        }
        C11839m.m70686d(TAG, "getAppDataNeedLocalSize appId: " + str + " pms default size: " + jQuerySumToCopySize);
        return jQuerySumToCopySize;
    }

    public static String getAppName(PackageManager packageManager, String str) {
        return getAppName(packageManager, str, "");
    }

    public static List<String> getAutoBackupErrCode() {
        return AUTO_BACKUP_ERROR_CODE;
    }

    public static String getBundleBackupDirPath(String str, String str2) {
        return str + File.separator + getBundleDir(str2);
    }

    public static String getBundleDir(String str) {
        return str + File.separator + "apk";
    }

    public static String getCurrentAndroidDataCachePath(String str) {
        String androidDataCacheRootPath = getAndroidDataCacheRootPath();
        if (TextUtils.isEmpty(androidDataCacheRootPath)) {
            return "";
        }
        return androidDataCacheRootPath + str + "/" + str;
    }

    public static String getDecodedPath(String str) {
        return C0208c0.m1139a(str);
    }

    public static String getEncodedPath(String str) {
        return C0208c0.m1143e(str);
    }

    private static Pair<Integer, Boolean> getForegroundProcessInfo(ActivityManager.RunningAppProcessInfo runningAppProcessInfo, String str, boolean z10, int... iArr) {
        String[] strArr;
        if (runningAppProcessInfo != null && (strArr = runningAppProcessInfo.pkgList) != null) {
            for (String str2 : strArr) {
                if (str.equals(str2) && isUseIdMatch(runningAppProcessInfo, z10, iArr)) {
                    return Pair.create(Integer.valueOf(runningAppProcessInfo.importance), Boolean.TRUE);
                }
            }
        }
        return null;
    }

    public static String getHarmonyBackupDirPath(String str, String str2) {
        return str + File.separator + getHarmonyDir(str2);
    }

    public static String getHarmonyDir(String str) {
        return str + File.separator + "hap";
    }

    public static String getHwCloudApkInstallCachePath() {
        String strM1573b = C0224k0.a.m1573b("hw.system.folderPrefix", "Huawei");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(C12583q.m75684t());
        String str = File.separator;
        sb2.append(str);
        sb2.append(strM1573b);
        sb2.append(str);
        sb2.append("HwCloud");
        sb2.append(str);
        sb2.append(".CloudApkInstall");
        return sb2.toString();
    }

    public static String getIconTempPath(String str) {
        return "/sdata/" + str + "/" + str + ".icon";
    }

    public static String getInfoXmlFilePath(String str, String str2) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        String str3 = File.separator;
        sb2.append(str3);
        sb2.append(str2);
        sb2.append(str3);
        sb2.append("info.xml");
        return sb2.toString();
    }

    public static Long getLocalLeftSpace() {
        InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
        if (interfaceC9282a != null) {
            return Long.valueOf(interfaceC9282a.mo58445o(C10279b.m63452a(C0213f.m1377a().getFilesDir())));
        }
        return null;
    }

    public static long getLocalTarNeedSize(int i10) {
        return new C12526j().m75359R0() * ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS * i10;
    }

    public static String getLocalTarPath(String str, String str2) {
        return str + TAR_LOCAL_DIR + str2;
    }

    public static String getLocationAPKFilePath(String str, String str2, int i10) {
        if (i10 == 1) {
            return getBundleBackupDirPath(str, str2) + File.separator + str2 + ".apk";
        }
        if (i10 == 2) {
            return getHarmonyBackupDirPath(str, str2) + File.separator + str2 + ".apk";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        String str3 = File.separator;
        sb2.append(str3);
        sb2.append(str2);
        sb2.append(str3);
        sb2.append(str2);
        sb2.append(".apk");
        return sb2.toString();
    }

    public static String getLocationIconFilePath(String str, String str2) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        String str3 = File.separator;
        sb2.append(str3);
        sb2.append(str2);
        sb2.append(str3);
        sb2.append(str2);
        sb2.append(".icon");
        return sb2.toString();
    }

    public static String getMediaTempPath(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if (str.startsWith(RELATIVE_SDATA_PATH)) {
            return str2 + str.substring(6);
        }
        if (str.startsWith(RELATIVE_EXTERNAL_PATH)) {
            C11839m.m70686d(TAG, "external path");
            String str4 = (str2 + "/" + str3 + "/" + str3) + str.substring(9);
            C11839m.m70686d(TAG, "media temp path: " + str4);
            return str4;
        }
        if (str.startsWith(RELATIVE_SDCARD_PATH)) {
            C11839m.m70686d(TAG, "sdcard path");
            String str5 = (str2 + "/" + str3 + "/" + str3 + "/SDCardClone") + str.substring(7);
            C11839m.m70686d(TAG, "sd media path: " + str5);
            return str5;
        }
        if (!str.startsWith(RELATIVE_USB_PATH)) {
            if (!str.startsWith("/data") || !str.contains("/cloudbackup")) {
                return str;
            }
            return str2 + str.substring(str.indexOf("/cloudbackup") + 12);
        }
        C11839m.m70686d(TAG, "usb path");
        String str6 = (str2 + "/" + str3 + "/" + str3) + str.substring(4);
        C11839m.m70686d(TAG, "sd media path: " + str6);
        return str6;
    }

    public static String getRelativePath(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if (str.startsWith(str2)) {
            return RELATIVE_SDATA_PATH + str.substring(str2.length());
        }
        String strM1512v = C0221j.m1512v();
        String strM1514x = C0221j.m1514x();
        String strM1474B = C0221j.m1474B();
        return (TextUtils.isEmpty(strM1512v) && TextUtils.isEmpty(strM1514x) && TextUtils.isEmpty(strM1474B)) ? str : (strM1512v == null || !str.startsWith(strM1512v)) ? (strM1514x == null || !str.startsWith(strM1514x)) ? (strM1474B == null || !str.startsWith(strM1474B)) ? str : checkRelativePathIsRoot(RELATIVE_USB_PATH, str.substring(strM1474B.length())) : checkRelativePathIsRoot(RELATIVE_SDCARD_PATH, str.substring(strM1514x.length())) : checkRelativePathIsRoot(RELATIVE_EXTERNAL_PATH, str.substring(strM1512v.length()));
    }

    public static String getRootPath(String str) {
        return TextUtils.isEmpty(str) ? str : str.startsWith(RELATIVE_SDATA_PATH) ? "/sdata/" : str.startsWith(RELATIVE_EXTERNAL_PATH) ? "/external/" : str.startsWith(RELATIVE_SDCARD_PATH) ? "/sdcard/" : str.startsWith(RELATIVE_USB_PATH) ? "/usb/" : str.startsWith(RELATIVE_CLOUDBACKUP_PATH) ? "/data/data/com.huawei.hidisk/files/cloudbackup/" : "";
    }

    public static Map<String, String> getSpaceDefaultModules() {
        return SPACE_DEFAULT_MODULES;
    }

    public static String getSpecialPath(String str) {
        return getAndroidDataCacheRootPath() + SPECIALTEMP + File.separator + str;
    }

    public static Map<String, String> getSubSourceInfo(String str) {
        if (!TextUtils.isEmpty(str)) {
            return (Map) C12540b1.m75484b(str, new MapTokenType().getType());
        }
        C11839m.m70689w(TAG, "install info is null.");
        return null;
    }

    public static List<String> getSupportDeleteModules() {
        return SUPPORT_DELETE_MODULES;
    }

    public static boolean getSwitchFromOptionSp(String str, boolean z10) {
        ArrayList arrayList = new ArrayList(C14333b.m85477l());
        arrayList.add(HNConstants.DataType.MEDIA);
        arrayList.add("music");
        BackupOptionItem backupOptionItemQueryItem = TransferedUtil.queryItem(str, z10);
        if (backupOptionItemQueryItem != null) {
            return backupOptionItemQueryItem.getBackupSwitch();
        }
        if (!arrayList.contains(str)) {
            C11839m.m70688i(TAG, "app is not in backup option sp");
            return new C12526j().m75369W0();
        }
        C11839m.m70688i(TAG, "system module is not in backup option sp" + str);
        BackupOptionItem backupOptionItemQueryItem2 = "chatSms".equals(str) ? TransferedUtil.queryItem(NavigationUtils.SMS_SCHEMA_PREF, z10) : "callRecorder".equals(str) ? TransferedUtil.queryItem("soundrecorder", z10) : null;
        if (backupOptionItemQueryItem2 != null) {
            return backupOptionItemQueryItem2.getBackupSwitch();
        }
        return true;
    }

    public static boolean getSwitchFromOptionSpV3(String str, C13026e c13026e) {
        ArrayList arrayList = new ArrayList(C14333b.m85477l());
        arrayList.add(HNConstants.DataType.MEDIA);
        arrayList.add("music");
        BackupOptionItem backupOptionItemQueryItemByAppId = TransferedUtil.queryItemByAppId(str, c13026e);
        if (backupOptionItemQueryItemByAppId != null) {
            return backupOptionItemQueryItemByAppId.getBackupSwitch();
        }
        if (!arrayList.contains(str)) {
            C11839m.m70688i(TAG, "app is not in backup option sp");
            return new C12526j().m75369W0();
        }
        C11839m.m70688i(TAG, "system module is not in backup option sp" + str);
        BackupOptionItem backupOptionItemQueryItemByAppId2 = "chatSms".equals(str) ? TransferedUtil.queryItemByAppId(NavigationUtils.SMS_SCHEMA_PREF, c13026e) : "callRecorder".equals(str) ? TransferedUtil.queryItemByAppId("soundrecorder", c13026e) : null;
        if (backupOptionItemQueryItemByAppId2 != null) {
            return backupOptionItemQueryItemByAppId2.getBackupSwitch();
        }
        return true;
    }

    public static String getTarHashByCloudPath(String str) throws C9721b {
        String tarNameByCloudPath = getTarNameByCloudPath(str);
        if (!TextUtils.isEmpty(tarNameByCloudPath)) {
            return tarNameByCloudPath.replace(".tar", "");
        }
        throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "getTarHashByCloudPath tarName is empty cloudPath = " + str);
    }

    public static String getTarNameByCloudPath(String str) {
        try {
            return str.substring(str.lastIndexOf("/") + 1, str.length());
        } catch (StringIndexOutOfBoundsException unused) {
            C11839m.m70687e(TAG, "getTarNameByCloudPath error cloudPath " + str);
            return null;
        }
    }

    public static String getTarPathByCloudPath(String str, String str2, String str3) {
        return str + str3 + "/" + str2;
    }

    public static String getTheAndroidCachePath() {
        String strM1512v = C0221j.m1512v();
        if (TextUtils.isEmpty(strM1512v)) {
            return "";
        }
        return strM1512v + ANDROID;
    }

    public static String getTheAndroidDataCachePath(String str) {
        return getTheAndroidDataCachePath(str, 0);
    }

    public static String getTheAndroidMediaCachePath(String str) {
        String strM1512v = C0221j.m1512v();
        if (TextUtils.isEmpty(strM1512v)) {
            return "";
        }
        return strM1512v + ANDROID + ANDROID_MEDIA + str;
    }

    public static String getTheAndroidObbCachePath(String str) {
        String strM1512v = C0221j.m1512v();
        if (TextUtils.isEmpty(strM1512v)) {
            return "";
        }
        return strM1512v + ANDROID + ANDROID_OBB + str;
    }

    public static String getTheAndroidObjCachePath(String str) {
        String strM1512v = C0221j.m1512v();
        if (TextUtils.isEmpty(strM1512v)) {
            return "";
        }
        return strM1512v + ANDROID + ANDROID_OBJ + str;
    }

    public static String getTheAndroidSandboxCachePath(String str) {
        String strM1512v = C0221j.m1512v();
        if (TextUtils.isEmpty(strM1512v)) {
            return "";
        }
        return strM1512v + ANDROID + ANDROID_SANDBOX + str;
    }

    public static String getTheString(String str, String str2) {
        return TextUtils.isEmpty(str2) ? str : str2;
    }

    public static long getVersionCode(PackageManager packageManager, String str) {
        C11839m.m70686d(TAG, "get package code");
        if (packageManager != null && str != null) {
            try {
                return PackageInfoCompat.getLongVersionCode(packageManager.getPackageInfo(str, 16384));
            } catch (PackageManager.NameNotFoundException | RuntimeException unused) {
                C11839m.m70687e(TAG, "get packageInfo error, because no such package");
            }
        }
        return -1;
    }

    public static boolean hasEmojiCharacter(String str) {
        if (str == null) {
            return false;
        }
        try {
            int iCodePointCount = str.codePointCount(0, str.length());
            int iOffsetByCodePoints = str.offsetByCodePoints(0, 0);
            int iOffsetByCodePoints2 = str.offsetByCodePoints(0, iCodePointCount - 1);
            while (iOffsetByCodePoints <= iOffsetByCodePoints2) {
                int iCodePointAt = str.codePointAt(iOffsetByCodePoints);
                if (isEmojiCharacter(iCodePointAt)) {
                    return true;
                }
                iOffsetByCodePoints += Character.isSupplementaryCodePoint(iCodePointAt) ? 2 : 1;
            }
            return false;
        } catch (IndexOutOfBoundsException e10) {
            C11839m.m70688i(TAG, "get emoji character error, character = " + str + ", message = " + e10.getMessage());
            return true;
        }
    }

    public static boolean isAndroidCachePath(String str, String str2) {
        String lowerCase = str.toLowerCase(Locale.getDefault());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getTheAndroidDataCachePath(str2));
        String str3 = File.separator;
        sb2.append(str3);
        String string = sb2.toString();
        String str4 = getTheAndroidMediaCachePath(str2) + str3;
        String str5 = getTheAndroidObbCachePath(str2) + str3;
        String str6 = getTheAndroidObjCachePath(str2) + str3;
        StringBuilder sb3 = new StringBuilder();
        sb3.append(getTheAndroidSandboxCachePath(str2));
        sb3.append(str3);
        return lowerCase.startsWith(string.toLowerCase(Locale.getDefault())) || lowerCase.startsWith(str4.toLowerCase(Locale.getDefault())) || lowerCase.startsWith(str5.toLowerCase(Locale.getDefault())) || lowerCase.startsWith(str6.toLowerCase(Locale.getDefault())) || lowerCase.startsWith(sb3.toString().toLowerCase(Locale.getDefault()));
    }

    public static boolean isApkFile(String str, String str2, String str3) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str2);
        String str4 = File.separator;
        sb2.append(str4);
        sb2.append(str3);
        sb2.append(str4);
        sb2.append(str3);
        sb2.append(".apk");
        String string = sb2.toString();
        String str5 = getBundleBackupDirPath(str2, str3) + str4 + str3 + ".apk";
        String str6 = getHarmonyBackupDirPath(str2, str3) + str4 + str3 + ".apk";
        if (!TextUtils.equals(str, string) && !TextUtils.equals(str, str5) && !TextUtils.equals(str, str6)) {
            String str7 = RELATIVE_SDATA_PATH + str4 + str3 + str4 + str3 + ".apk";
            String str8 = getBundleBackupDirPath(RELATIVE_SDATA_PATH, str3) + str4 + str3 + ".apk";
            String str9 = getHarmonyBackupDirPath(RELATIVE_SDATA_PATH, str3) + str4 + str3 + ".apk";
            if (!TextUtils.equals(str, str7) && !TextUtils.equals(str, str8) && !TextUtils.equals(str, str9)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isEmojiCharacter(int i10) {
        return (i10 >= 9728 && i10 <= 10175) || i10 == 12349 || i10 == 8265 || i10 == 8252 || (i10 >= 8192 && i10 <= 8207) || ((i10 >= 8232 && i10 <= 8239) || i10 == 8287 || ((i10 >= 8293 && i10 <= 8303) || ((i10 >= 8448 && i10 <= 8527) || ((i10 >= 8960 && i10 <= 9215) || ((i10 >= 11008 && i10 <= 11263) || ((i10 >= 10496 && i10 <= 10623) || ((i10 >= 12800 && i10 <= 13055) || ((i10 >= 55296 && i10 <= 57343) || ((i10 >= 57344 && i10 <= 63743) || ((i10 >= 65024 && i10 <= 65039) || i10 >= 65536))))))))));
    }

    public static boolean isForGroundProcess(String str, Context context, int i10, AtomicInteger atomicInteger) {
        return isForGroundProcess(str, context, atomicInteger, true, i10);
    }

    public static boolean isIconFile(String str, String str2, String str3) {
        return TextUtils.equals(str, getLocationIconFilePath(str2, str3)) || TextUtils.equals(str, getLocationIconFilePath(RELATIVE_SDATA_PATH, str3));
    }

    public static boolean isInfoFile(String str, String str2, String str3) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str2);
        String str4 = File.separator;
        sb2.append(str4);
        sb2.append(str3);
        sb2.append(str4);
        sb2.append("info.xml");
        String string = sb2.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(RELATIVE_SDATA_PATH);
        sb3.append(str4);
        sb3.append(str3);
        sb3.append(str4);
        sb3.append("info.xml");
        return TextUtils.equals(str, string) || TextUtils.equals(str, sb3.toString());
    }

    public static boolean isNeedUpload(SnapshotBackupMeta snapshotBackupMeta, long j10) {
        int status = snapshotBackupMeta.getStatus();
        if (status == 4) {
            long jCurrentTimeMillis = System.currentTimeMillis() - snapshotBackupMeta.getDateCreate();
            if (jCurrentTimeMillis > 0 && jCurrentTimeMillis < j10) {
                return false;
            }
        } else if (status == 5 || status == 6) {
            return false;
        }
        return true;
    }

    public static boolean isNeedUploadV3(CloudBackupStatus cloudBackupStatus, long j10) {
        int iM29859L = cloudBackupStatus.m29859L();
        if (iM29859L == 4 || iM29859L == 5 || iM29859L == 6) {
            long jCurrentTimeMillis = System.currentTimeMillis() - cloudBackupStatus.m29404g1();
            if (jCurrentTimeMillis > 0 && jCurrentTimeMillis < j10) {
                return false;
            }
        }
        return true;
    }

    public static boolean isProcessAlive(Context context, String str) {
        boolean z10;
        Iterator<ActivityManager.RunningAppProcessInfo> it = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses().iterator();
        while (true) {
            if (!it.hasNext()) {
                z10 = false;
                break;
            }
            if (it.next().processName.equals(str)) {
                z10 = true;
                break;
            }
        }
        C11839m.m70688i(TAG, str + " : " + z10);
        return z10;
    }

    public static boolean isRestoreRetryTimeExpires(long j10) {
        if (C12591s1.m75931a().m75938h()) {
            C11839m.m70686d(TAG, "refurbish restore no time expires.");
            return false;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - j10;
        long jM75329C0 = new C12526j().m75329C0();
        C11839m.m70688i(TAG, "restore retry time expires start, moduleTimeDuration: " + jCurrentTimeMillis + ", restoreRetryPeriod: " + jM75329C0);
        return j10 > 0 && jCurrentTimeMillis > 0 && jCurrentTimeMillis > jM75329C0;
    }

    public static boolean isSnapshotNotExist(C9721b c9721b) {
        if (c9721b.m60659c() == 3207 && c9721b.m60663g() == 103) {
            return true;
        }
        if (c9721b.m60659c() == 3306 && c9721b.m60663g() == 404) {
            return true;
        }
        return c9721b.m60659c() == 4306 && c9721b.m60663g() == 404;
    }

    public static boolean isSupportGallery(Context context) {
        if (context == null) {
            C11839m.m70688i(TAG, "isSupportGallery context is null");
            return true;
        }
        boolean zM5975v = C1006a.m5936k().m5975v(context);
        boolean z10 = C1006a.m5936k().m5969p(context) == 1;
        C11839m.m70688i(TAG, "albumSwitch " + zM5975v + "   albumShelveStatus " + z10);
        return !zM5975v || z10;
    }

    public static boolean isTxtFile(String str, String str2, String str3) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str2);
        sb2.append(ANDROID_DATA);
        sb2.append(str3);
        String str4 = File.separator;
        sb2.append(str4);
        sb2.append(str3);
        sb2.append(".txt");
        String string = sb2.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append("/sdata/data/");
        sb3.append(str3);
        sb3.append(str4);
        sb3.append(str3);
        sb3.append(".txt");
        return TextUtils.equals(str, string) || TextUtils.equals(str, sb3.toString());
    }

    private static boolean isUseIdMatch(ActivityManager.RunningAppProcessInfo runningAppProcessInfo, boolean z10, int... iArr) {
        if (!z10) {
            return true;
        }
        int i10 = runningAppProcessInfo.uid;
        if (iArr == null || iArr.length <= 0) {
            return true;
        }
        int i11 = iArr[0];
        return i10 > PROCESS_UID_MAX_VALUE ? String.valueOf(i10).startsWith(String.valueOf(i11)) : i11 == 0;
    }

    public static Map<String, String> jsonToMap(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return (Map) C12540b1.m75484b(str, new MapType().getType());
    }

    public static String mapToJson(Map<String, String> map) {
        return new Gson().toJson(map);
    }

    private static void moveAndDeleteHmBox(File file, File file2) {
        String name = file.getName();
        C11839m.m70688i(TAG, "moveAndDeleteHmBox enter: " + name);
        try {
            C11835i.m70652p(file, new File(file2, name));
            C11835i.m70643g(file.getPath());
        } catch (IOException e10) {
            C11839m.m70687e(TAG, "moveAndDeleteHmBox error: " + e10.getMessage());
        }
        C11839m.m70688i(TAG, "moveAndDeleteHmBox exit");
    }

    public static void moveSpecialFile(String str, LinkedHashMap<String, String> linkedHashMap) throws IOException {
        String specialPath = getSpecialPath(str);
        if (!C10278a.m63442h(specialPath).exists()) {
            C11839m.m70686d(TAG, "moveSpecialFile dir not exist appId: " + str);
            return;
        }
        C11839m.m70686d(TAG, "moveSpecialFile specialPath: " + specialPath);
        AtomicLong atomicLong = new AtomicLong();
        String strMoveSpecialTempToDestPath = moveSpecialTempToDestPath(specialPath, C0221j.m1512v(), atomicLong);
        if (!TextUtils.isEmpty(strMoveSpecialTempToDestPath)) {
            linkedHashMap.put("locationPcardMoveErrorPath", strMoveSpecialTempToDestPath);
        }
        String strMoveSpecialTempToDestPath2 = moveSpecialTempToDestPath(specialPath, C0221j.m1513w(), atomicLong);
        if (!TextUtils.isEmpty(strMoveSpecialTempToDestPath2)) {
            linkedHashMap.put("locationSdcardMoveErrorPath", strMoveSpecialTempToDestPath2);
        }
        String strMoveSpecialTempToDestPath3 = moveSpecialTempToDestPath(specialPath, C0221j.m1473A(), atomicLong);
        if (!TextUtils.isEmpty(strMoveSpecialTempToDestPath3)) {
            linkedHashMap.put("udiskStoragePathMoveErrorPath", strMoveSpecialTempToDestPath3);
        }
        C11839m.m70688i(TAG, "appId" + str + ", restoreSpecialFileNum: " + atomicLong);
        if (linkedHashMap.isEmpty()) {
            linkedHashMap.put("errorReason", "success");
        } else {
            linkedHashMap.put("errorReason", NotifyConstants.CommonReportConstants.FAILED);
        }
        linkedHashMap.put("restoreSpecialFileNum", atomicLong.toString());
        C11835i.m70643g(specialPath);
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x00bd A[PHI: r5
  0x00bd: PHI (r5v3 java.lang.String) = (r5v2 java.lang.String), (r5v4 java.lang.String) binds: [B:117:0x00d1, B:108:0x00ba] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String moveSpecialTempToDestPath(java.lang.String r11, java.lang.String r12, java.util.concurrent.atomic.AtomicLong r13) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 259
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.cloudbackup.util.ICBUtil.moveSpecialTempToDestPath(java.lang.String, java.lang.String, java.util.concurrent.atomic.AtomicLong):java.lang.String");
    }

    private static String moveThirdFiles(String str, File[] fileArr) throws IOException {
        String strM63452a = "";
        for (File file : fileArr) {
            File fileM63442h = C10278a.m63442h(C10279b.m63452a(file).substring(str.length()));
            if (file.isDirectory()) {
                if (file.getName().equals(HM_NEXT)) {
                    C11839m.m70688i(TAG, "doHmNextStrongBox enter");
                    if (fileM63442h.exists()) {
                        File[] fileArrListFiles = fileM63442h.listFiles();
                        File[] fileArrListFiles2 = file.listFiles();
                        List list = (List) Arrays.stream(fileArrListFiles).map(new C2735t()).collect(Collectors.toList());
                        for (File file2 : fileArrListFiles2) {
                            String name = file2.getName();
                            C11839m.m70688i(TAG, "file: " + name);
                            if (list.contains(name)) {
                                File file3 = new File(file2.getParent(), StringUtil.randomString() + System.currentTimeMillis());
                                if (file2.renameTo(file3)) {
                                    moveAndDeleteHmBox(file3, fileM63442h);
                                } else {
                                    strM63452a = file2.getParent();
                                    C11839m.m70689w(TAG, name + " rename failed");
                                }
                            } else {
                                moveAndDeleteHmBox(file2, fileM63442h);
                            }
                        }
                    } else {
                        moveAndDeleteHmBox(file, fileM63442h.getParentFile());
                    }
                } else {
                    if (fileM63442h.exists()) {
                        fileM63442h = C10278a.m63441g(C10278a.m63437c(fileM63442h), StringUtil.randomString());
                    }
                    String strM70652p = C11835i.m70652p(file, fileM63442h);
                    if (!TextUtils.isEmpty(strM70652p)) {
                        strM63452a = strM70652p;
                    }
                }
            } else if (!fileM63442h.exists() && !C11835i.m70654r(file, fileM63442h)) {
                strM63452a = C10279b.m63452a(file);
            }
        }
        return strM63452a;
    }

    public static String parseDeviceId(Bak bak) {
        String str = "";
        if (bak.getDevice() != null) {
            try {
                Iterator<Object> it = ((C11707b) C11903a.m71435l().mo69832e(bak.getDevice()).m69886u(C11707b.class)).values().iterator();
                while (it.hasNext()) {
                    str = (String) it.next();
                }
            } catch (IOException e10) {
                C11839m.m70687e(TAG, "get deviceId error: " + e10.getMessage());
            }
        }
        return str;
    }

    public static BackupOptionItem queryAppDataItem(boolean z10) {
        List<BackupOptionItem> listM78399w = new C13026e(z10).m78399w("thirdAppData");
        BackupOptionItem backupOptionItem = new BackupOptionItem();
        backupOptionItem.setAppId("thirdAppData");
        backupOptionItem.setItemTotal(listM78399w.size());
        long dataBytes = 0;
        int i10 = 0;
        for (BackupOptionItem backupOptionItem2 : listM78399w) {
            if (backupOptionItem2.getBackupSwitch()) {
                dataBytes += backupOptionItem2.getDataBytes();
                i10++;
            }
        }
        backupOptionItem.setDataBytes(dataBytes);
        backupOptionItem.setSwitchCount(i10);
        backupOptionItem.setBackupSwitch(true);
        backupOptionItem.setIsDataEnable(2);
        return backupOptionItem;
    }

    public static BackupOptionItem queryParentItem(String str, boolean z10) {
        long totalIncrease;
        int isDataEnable;
        int i10;
        C11839m.m70688i(TAG, "query parent item appId: " + str);
        List<BackupOptionItem> listM78399w = new C13026e(z10).m78399w(str);
        long j10 = 0;
        int itemTotal = 0;
        if (listM78399w == null || listM78399w.isEmpty()) {
            totalIncrease = 0;
            isDataEnable = 0;
            i10 = 0;
        } else {
            Iterator<BackupOptionItem> it = listM78399w.iterator();
            long dataBytes = 0;
            totalIncrease = 0;
            isDataEnable = 0;
            i10 = 0;
            while (it.hasNext()) {
                BackupOptionItem next = it.next();
                dataBytes += next.getDataBytes();
                itemTotal += next.getItemTotal();
                if (next.getBackupSwitch()) {
                    i10++;
                }
                if (next.getIsDataEnable() != -1 || isDataEnable == 0) {
                    isDataEnable = next.getIsDataEnable();
                }
                if (next.getTotalIncrease() > 0) {
                    totalIncrease += next.getTotalIncrease();
                }
            }
            j10 = dataBytes;
        }
        BackupOptionItem backupOptionItemQueryItem = TransferedUtil.queryItem(str, z10);
        boolean backupSwitch = backupOptionItemQueryItem != null ? backupOptionItemQueryItem.getBackupSwitch() : true;
        BackupOptionItem backupOptionItem = new BackupOptionItem();
        backupOptionItem.setAppId(str);
        backupOptionItem.setDataBytes(j10);
        backupOptionItem.setTotalIncrease(totalIncrease);
        backupOptionItem.setItemTotal(itemTotal);
        backupOptionItem.setBackupSwitch(backupSwitch);
        backupOptionItem.setIsDataEnable(isDataEnable);
        backupOptionItem.setSwitchCount(i10);
        backupOptionItem.setAppName("");
        return backupOptionItem;
    }

    public static void refreshLocalAlbumSettings(Context context, boolean z10) throws C9721b {
        Albums albums;
        ArrayList<AppInfo> arrayListM5962h = C1006a.m5936k().m5962h(context);
        if (arrayListM5962h == null || arrayListM5962h.isEmpty()) {
            C11839m.m70686d(TAG, "gallery album is null");
            if (z10) {
                CBCallBack.getInstance().sendMessage(Message.obtain((Handler) null, 32329));
                return;
            }
            return;
        }
        AlbumOperator albumOperator = new AlbumOperator();
        Map<Integer, Albums> mapQueryAllAlbumsWithId = albumOperator.queryAllAlbumsWithId();
        for (Map.Entry<Integer, Albums> entry : mapQueryAllAlbumsWithId.entrySet()) {
            C11839m.m70686d(TAG, "dump local key = " + entry + ", " + entry.getKey());
        }
        Iterator<AppInfo> it = arrayListM5962h.iterator();
        while (it.hasNext()) {
            AppInfo next = it.next();
            C11839m.m70686d(TAG, " appinfo = " + next.toString());
            if ("default-album-2".equals(next.getAlbumId())) {
                albums = albumOperator.getScreenshotAlbum();
                if (albums != null) {
                    C11839m.m70686d(TAG, "screenshot " + albums.toString());
                    albums.updateAlbumsInfo(next);
                } else {
                    albums = new Albums(next);
                    albums.setSwitchStatus(1);
                }
                mapQueryAllAlbumsWithId.remove(Integer.valueOf(next.getTempId()));
            } else if (mapQueryAllAlbumsWithId.containsKey(Integer.valueOf(next.getTempId()))) {
                albums = mapQueryAllAlbumsWithId.get(Integer.valueOf(next.getTempId()));
                albums.updateAlbumsInfo(next);
                mapQueryAllAlbumsWithId.remove(Integer.valueOf(next.getTempId()));
                C11839m.m70686d(TAG, "contain this album " + albums.toString());
            } else {
                albums = new Albums(next);
                C11839m.m70686d(TAG, "new album " + albums.toString());
                if ("default-album-2".equals(albums.getAlbumId())) {
                    albums.setSwitchStatus(1);
                }
            }
            checkIsOutSizeAlbum(albums);
            albumOperator.replace(new Albums[]{albums});
        }
        if (!mapQueryAllAlbumsWithId.isEmpty()) {
            C11839m.m70686d(TAG, "delete album " + mapQueryAllAlbumsWithId.size());
            albumOperator.delete((Albums[]) mapQueryAllAlbumsWithId.values().toArray(new Albums[mapQueryAllAlbumsWithId.size()]));
        }
        if (z10) {
            CBCallBack.getInstance().sendMessage(Message.obtain((Handler) null, 32329));
        }
    }

    public static void reportInstallEvent(String str, int i10, String str2) {
        if (TextUtils.isEmpty(str2)) {
            C11839m.m70689w(TAG, "install event error");
            return;
        }
        Map map = (Map) C12540b1.m75484b(str2, new MapTokenType().getType());
        String str3 = (String) map.get(CloudBackupConstant.ReportAppMarket.KEY_SUB_SOURCE);
        String str4 = (String) map.get(CloudBackupConstant.ReportAppMarket.KEY_PKG_CHANNEL_ID);
        Bundle bundle = new Bundle();
        if (str3 == null) {
            str3 = "";
        }
        bundle.putString(CloudBackupConstant.ReportAppMarket.KEY_SUB_SOURCE, str3);
        bundle.putString("package", str);
        bundle.putInt("version", i10);
        bundle.putString(CloudBackupConstant.ReportAppMarket.KEY_PKG_CHANNEL_ID, str4);
        ReportAppMarketManager.getInstance().installEvent(bundle);
    }

    public static String tranAndroidPath(String str, String str2) {
        String str3;
        if (!PmsCheckUtil.m12611e() || TextUtils.isEmpty(str)) {
            return str;
        }
        String theAndroidCachePath = getTheAndroidCachePath();
        if (!isAndroidCachePath(str, str2)) {
            return str;
        }
        String currentAndroidDataCachePath = getCurrentAndroidDataCachePath(str2);
        if (TextUtils.isEmpty(currentAndroidDataCachePath)) {
            str3 = str;
        } else {
            str3 = currentAndroidDataCachePath + str.substring(theAndroidCachePath.length());
        }
        C11839m.m70686d(TAG, "originPath = " + str + " ,path = " + str3);
        return str3;
    }

    public static String tranSpecialPath(String str, String str2) {
        return getSpecialPath(str2) + str;
    }

    public static String getAppName(PackageManager packageManager, String str, String str2) throws PackageManager.NameNotFoundException {
        ApplicationInfo applicationInfo;
        C11839m.m70686d(TAG, "get app name");
        String string = "";
        if (packageManager != null && str != null) {
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(str, 16384);
                if (packageInfo != null && (applicationInfo = packageInfo.applicationInfo) != null) {
                    string = packageManager.getApplicationLabel(applicationInfo).toString();
                }
            } catch (PackageManager.NameNotFoundException e10) {
                C11839m.m70687e(TAG, "getAppName error：" + e10.getMessage());
            }
        }
        if (!SplitAppUtil.isSplitApp(str2)) {
            return string;
        }
        return string + str2;
    }

    public static String getLocalTarPath(String str, String str2, int i10) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(TAR_LOCAL_DIR);
        String str3 = File.separator;
        sb2.append(str3);
        sb2.append(i10);
        sb2.append(str3);
        sb2.append(str2);
        return sb2.toString();
    }

    public static String getTheAndroidDataCachePath(String str, int i10) {
        String strM1512v = C0221j.m1512v();
        if (TextUtils.isEmpty(strM1512v)) {
            return "";
        }
        if (i10 == 0) {
            return strM1512v + ANDROID + ANDROID_DATA + str;
        }
        return C12568l.m75533b(i10) + ANDROID + ANDROID_DATA + str;
    }

    public static boolean isForGroundProcess(String str, Context context, AtomicInteger atomicInteger) {
        return isForGroundProcess(str, context, atomicInteger, false, new int[0]);
    }

    private static boolean isForGroundProcess(String str, Context context, AtomicInteger atomicInteger, boolean z10, int... iArr) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        int i10;
        if (context == null || TextUtils.isEmpty(str) || (runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) == null) {
            return false;
        }
        String packageName = context.getApplicationContext().getPackageName();
        int iIntValue = -1;
        boolean z11 = false;
        boolean zBooleanValue = false;
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (packageName.equals(runningAppProcessInfo.processName)) {
                z11 = runningAppProcessInfo.importance == 100;
            }
            if (!zBooleanValue && ((i10 = runningAppProcessInfo.importance) == 100 || i10 == 125)) {
                Pair<Integer, Boolean> foregroundProcessInfo = getForegroundProcessInfo(runningAppProcessInfo, str, z10, iArr);
                if (foregroundProcessInfo != null) {
                    iIntValue = ((Integer) foregroundProcessInfo.first).intValue();
                    zBooleanValue = ((Boolean) foregroundProcessInfo.second).booleanValue();
                }
            }
        }
        if (z11 && zBooleanValue) {
            boolean z12 = iIntValue == 125;
            C11839m.m70688i(TAG, "hidisk is foreground, set foreground = " + z12);
            zBooleanValue = z12;
        }
        if (atomicInteger != null) {
            atomicInteger.set(iIntValue);
        }
        C11839m.m70688i(TAG, "appId = " + str + ", foreground = " + zBooleanValue + " ,importance: " + iIntValue);
        return zBooleanValue;
    }

    public static String convertToAbsolutePath(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if (str.startsWith(RELATIVE_SDATA_PATH)) {
            return str2 + str.substring(6);
        }
        if (str.startsWith(RELATIVE_EXTERNAL_PATH)) {
            return C0221j.m1512v() + str.substring(9);
        }
        if (str.startsWith(RELATIVE_SDCARD_PATH)) {
            String strM1514x = C0221j.m1514x();
            if (TextUtils.isEmpty(strM1514x)) {
                return C0221j.m1512v() + str;
            }
            return strM1514x + str.substring(7);
        }
        if (str.startsWith(RELATIVE_USB_PATH)) {
            String strM1474B = C0221j.m1474B();
            if (TextUtils.isEmpty(strM1474B)) {
                return C0221j.m1512v() + str;
            }
            return strM1474B + str.substring(4);
        }
        if (!str.startsWith("/data") || !str.contains("/cloudbackup")) {
            return str;
        }
        return str2 + str.substring(str.indexOf("/cloudbackup") + 12);
    }

    public static BackupOptionItem queryParentItem(String str, C13026e c13026e) {
        long totalIncrease;
        int isDataEnable;
        int i10;
        C11839m.m70688i(TAG, "query parent item appId: " + str);
        List<BackupOptionItem> listM78399w = c13026e.m78399w(str);
        long j10 = 0;
        int itemTotal = 0;
        if (listM78399w == null || listM78399w.isEmpty()) {
            totalIncrease = 0;
            isDataEnable = 0;
            i10 = 0;
        } else {
            Iterator<BackupOptionItem> it = listM78399w.iterator();
            long dataBytes = 0;
            totalIncrease = 0;
            isDataEnable = 0;
            i10 = 0;
            while (it.hasNext()) {
                BackupOptionItem next = it.next();
                dataBytes += next.getDataBytes();
                itemTotal += next.getItemTotal();
                if (next.getBackupSwitch()) {
                    i10++;
                }
                if (next.getIsDataEnable() != -1 || isDataEnable == 0) {
                    isDataEnable = next.getIsDataEnable();
                }
                if (next.getTotalIncrease() > 0) {
                    totalIncrease += next.getTotalIncrease();
                }
            }
            j10 = dataBytes;
        }
        BackupOptionItem backupOptionItemQueryItem = TransferedUtil.queryItem(str, c13026e);
        boolean backupSwitch = backupOptionItemQueryItem != null ? backupOptionItemQueryItem.getBackupSwitch() : true;
        BackupOptionItem backupOptionItem = new BackupOptionItem();
        backupOptionItem.setAppId(str);
        backupOptionItem.setDataBytes(j10);
        backupOptionItem.setTotalIncrease(totalIncrease);
        backupOptionItem.setItemTotal(itemTotal);
        backupOptionItem.setBackupSwitch(backupSwitch);
        backupOptionItem.setIsDataEnable(isDataEnable);
        backupOptionItem.setSwitchCount(i10);
        backupOptionItem.setAppName("");
        return backupOptionItem;
    }
}
