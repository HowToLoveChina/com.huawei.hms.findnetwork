package com.huawei.android.hicloud.cloudbackup.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Message;
import com.huawei.android.hicloud.cloudbackup.bean.AppIcon;
import com.huawei.android.hicloud.cloudbackup.callable.CBCallBack;
import com.huawei.android.hicloud.cloudbackup.process.util.SplitAppUtil;
import com.huawei.android.hicloud.cloudbackup.restore.CloudRestoreClient;
import com.huawei.android.hicloud.cloudbackup.util.CloudBackup3rdIconUtil;
import com.huawei.android.hicloud.cloudbackup.util.image.BitmapLruCache;
import com.huawei.android.hicloud.connect.progress.ICallback;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.hicloud.base.bean.Md5AndHash;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.Attachment;
import com.huawei.hicloud.cloudbackup.store.database.tags.CloudRestoreStatus;
import com.huawei.hicloud.request.cbs.bean.CBSAppInfo;
import com.huawei.hicloud.request.cbs.bean.CBSBackupRecord;
import fk.C9721b;
import gp.C10028c;
import hk.C10278a;
import hk.C10279b;
import im.C10546a;
import im.C10574x;
import im.InterfaceC10551c0;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mk.C11476b;
import p015ak.C0213f;
import p035bk.C1248a;
import p429kk.C11058a;
import p458lo.C11322a;
import p495nm.C11720a;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p606r9.C12478a;
import p616rk.C12515a;
import p617rl.C12519c;
import p652t9.EnumC12999a;
import p848zl.C14333b;

/* loaded from: classes2.dex */
public class CloudBackup3rdIconUtil {
    private static final String ICON_CACHE = "icons";
    private static final String TAG = "CloudBackup3rdIconUtil";

    /* renamed from: com.huawei.android.hicloud.cloudbackup.util.CloudBackup3rdIconUtil$1 */
    public class C27071 extends AbstractC12367d {
        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            File fileM63441g = C10278a.m63441g(CloudBackup3rdIconUtil.getContext().getFilesDir(), CloudBackup3rdIconUtil.ICON_CACHE);
            if (!fileM63441g.exists() && !fileM63441g.mkdir()) {
                C11839m.m70686d(CloudBackup3rdIconUtil.TAG, "virtual icon mkdirs failed.");
            }
            C12519c c12519c = new C12519c();
            List<String> listM75306q = c12519c.m75306q();
            boolean zContains = listM75306q.contains("music");
            listM75306q.removeAll(C14333b.m85476k());
            if (zContains) {
                listM75306q.add("music");
            }
            for (String str : listM75306q) {
                try {
                    AppIcon appIconM75296g = c12519c.m75296g(str);
                    if (appIconM75296g != null && appIconM75296g.getUrl() != null && !appIconM75296g.getUrl().isEmpty()) {
                        File fileM63441g2 = C10278a.m63441g(fileM63441g, str + ".icon");
                        if (fileM63441g2.exists()) {
                            String hash = appIconM75296g.getHash();
                            if (hash == null || hash.isEmpty()) {
                                C11839m.m70686d(CloudBackup3rdIconUtil.TAG, "hash is null ：appId " + str);
                            } else {
                                Md5AndHash md5AndHashM68622d = C11476b.m68622d(fileM63441g2);
                                if (!hash.equals(md5AndHashM68622d.getHash()) && !hash.equals(md5AndHashM68622d.getMD5())) {
                                }
                            }
                        }
                        CloudBackup3rdIconUtil.startDownloadVirtualIcon(str, appIconM75296g, fileM63441g2);
                    }
                } catch (C9721b e10) {
                    C11839m.m70689w(CloudBackup3rdIconUtil.TAG, "download virtual app icons err, appId = " + str + " " + e10.getMessage());
                }
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.cloudbackup.util.CloudBackup3rdIconUtil$2 */
    public class C27082 extends AbstractC12367d {
        final /* synthetic */ String val$backupId;
        final /* synthetic */ String val$deviceId;
        final /* synthetic */ int val$deviceType;

        public C27082(String str, int i10, String str2) {
            str = str;
            i = i10;
            str = str2;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            File fileFilterDownIcon;
            try {
                CBSBackupRecord cBSBackupRecordM68001H = new C11322a().m68001H(str, i, str, false, true);
                if (cBSBackupRecordM68001H == null) {
                    C11839m.m70686d(CloudBackup3rdIconUtil.TAG, "cbsBackupRecord is null");
                    return;
                }
                ArrayList arrayList = new ArrayList();
                Iterator<PackageInfo> it = CloudBackup3rdIconUtil.getContext().getPackageManager().getInstalledPackages(0).iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().packageName);
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append(CloudBackup3rdIconUtil.isEncrypt() ? "" : "/Backup");
                sb2.append("/CloudBackup/");
                sb2.append(C11476b.m68626h(str));
                sb2.append("/");
                String string = sb2.toString();
                for (CBSAppInfo cBSAppInfo : cBSBackupRecordM68001H.getAppIdInfos()) {
                    String appId = cBSAppInfo.getAppId();
                    if (!C14333b.m85483r().containsKey(appId) && (fileFilterDownIcon = CloudBackup3rdIconUtil.filterDownIcon(arrayList, appId)) != null) {
                        CloudBackup3rdIconUtil.startDownload3rdIcons(string, cBSAppInfo, appId, fileFilterDownIcon);
                    }
                }
            } catch (C9721b e10) {
                C11839m.m70687e(CloudBackup3rdIconUtil.TAG, "query backup detail error." + e10.getMessage());
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.cloudbackup.util.CloudBackup3rdIconUtil$3 */
    public class C27093 extends AbstractC12367d {
        final /* synthetic */ HashMap val$appIds;
        final /* synthetic */ HashMap val$attachmentHashMap;
        final /* synthetic */ String val$traceId;

        public C27093(HashMap map, HashMap map2, String str) {
            this.val$attachmentHashMap = map;
            this.val$appIds = map2;
            this.val$traceId = str;
        }

        public static /* synthetic */ InterfaceC10551c0 lambda$call$0(String str, String str2, String str3, String str4, String str5) throws C9721b {
            return new C10574x(null, str, str2, "icon", str3, str4, str5);
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            ArrayList arrayList = new ArrayList();
            Iterator<PackageInfo> it = CloudBackup3rdIconUtil.getContext().getPackageManager().getInstalledPackages(0).iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().packageName);
            }
            HashMap map = new HashMap();
            for (Map.Entry entry : this.val$attachmentHashMap.entrySet()) {
                String str = (String) entry.getKey();
                Attachment attachment = (Attachment) entry.getValue();
                if (CloudBackup3rdIconUtil.filterDownIcon(arrayList, str) != null && attachment != null) {
                    map.put(str, attachment);
                }
            }
            if (map.size() > 0) {
                for (Map.Entry entry2 : map.entrySet()) {
                    String str2 = (String) entry2.getKey();
                    Attachment attachment2 = (Attachment) entry2.getValue();
                    final String str3 = (String) this.val$appIds.get(str2);
                    File fileM63441g = C10278a.m63441g(CloudBackup3rdIconUtil.getContext().getFilesDir(), CloudBackup3rdIconUtil.ICON_CACHE);
                    if (!fileM63441g.exists() && !fileM63441g.mkdir()) {
                        C11839m.m70686d(CloudBackup3rdIconUtil.TAG, "3rd icon mkdirs failed.");
                    }
                    File fileM63441g2 = C10278a.m63441g(fileM63441g, str2 + ".icon");
                    final String assetId = attachment2.getAssetId();
                    final String versionId = attachment2.getVersionId();
                    final String strM63452a = C10279b.m63452a(fileM63441g2);
                    try {
                        final String str4 = this.val$traceId;
                        C10546a.m64704a(new C10546a.a() { // from class: com.huawei.android.hicloud.cloudbackup.util.k
                            @Override // im.C10546a.a
                            /* renamed from: a */
                            public final InterfaceC10551c0 mo1696a() {
                                return CloudBackup3rdIconUtil.C27093.lambda$call$0(str4, strM63452a, str3, assetId, versionId);
                            }
                        }).m64705b();
                        CBCallBack.getInstance().sendMessage(Message.obtain(null, 33001, str2));
                    } catch (C9721b e10) {
                        C11839m.m70689w(CloudBackup3rdIconUtil.TAG, "download3rdIconsV3 appId =" + str2 + e10.getMessage());
                    }
                }
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.cloudbackup.util.CloudBackup3rdIconUtil$4 */
    public class C27104 implements ICallback {
        public boolean onPause() {
            return false;
        }

        @Override // com.huawei.android.hicloud.connect.progress.ICallback
        public void onProgress(long j10, long j11) {
        }

        @Override // com.huawei.android.hicloud.connect.progress.ICallback
        public boolean onStop() {
            return false;
        }
    }

    public static void cache3rdDrawable(String str) {
        File fileM63441g = C10278a.m63441g(getContext().getFilesDir(), ICON_CACHE);
        if (!fileM63441g.exists() && !fileM63441g.mkdir()) {
            C11839m.m70686d(TAG, "3rd icon mkdirs failed.");
            return;
        }
        get3rdDrawableByPackageName(str, C10278a.m63441g(fileM63441g, str + ".icon"));
    }

    public static void download3rdIcons(String str, String str2, int i10) {
        C12515a.m75110o().m75172d(new AbstractC12367d() { // from class: com.huawei.android.hicloud.cloudbackup.util.CloudBackup3rdIconUtil.2
            final /* synthetic */ String val$backupId;
            final /* synthetic */ String val$deviceId;
            final /* synthetic */ int val$deviceType;

            public C27082(String str3, int i102, String str22) {
                str = str3;
                i = i102;
                str = str22;
            }

            @Override // p616rk.AbstractRunnableC12516b
            public void call() {
                File fileFilterDownIcon;
                try {
                    CBSBackupRecord cBSBackupRecordM68001H = new C11322a().m68001H(str, i, str, false, true);
                    if (cBSBackupRecordM68001H == null) {
                        C11839m.m70686d(CloudBackup3rdIconUtil.TAG, "cbsBackupRecord is null");
                        return;
                    }
                    ArrayList arrayList = new ArrayList();
                    Iterator<PackageInfo> it = CloudBackup3rdIconUtil.getContext().getPackageManager().getInstalledPackages(0).iterator();
                    while (it.hasNext()) {
                        arrayList.add(it.next().packageName);
                    }
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(CloudBackup3rdIconUtil.isEncrypt() ? "" : "/Backup");
                    sb2.append("/CloudBackup/");
                    sb2.append(C11476b.m68626h(str));
                    sb2.append("/");
                    String string = sb2.toString();
                    for (CBSAppInfo cBSAppInfo : cBSBackupRecordM68001H.getAppIdInfos()) {
                        String appId = cBSAppInfo.getAppId();
                        if (!C14333b.m85483r().containsKey(appId) && (fileFilterDownIcon = CloudBackup3rdIconUtil.filterDownIcon(arrayList, appId)) != null) {
                            CloudBackup3rdIconUtil.startDownload3rdIcons(string, cBSAppInfo, appId, fileFilterDownIcon);
                        }
                    }
                } catch (C9721b e10) {
                    C11839m.m70687e(CloudBackup3rdIconUtil.TAG, "query backup detail error." + e10.getMessage());
                }
            }
        });
    }

    public static void download3rdIconsV3(String str, HashMap<String, Attachment> map, HashMap<String, String> map2) {
        C12515a.m75110o().m75172d(new C27093(map, map2, str));
    }

    public static void downloadVirtualIcon() {
        C12515a.m75110o().m75172d(new AbstractC12367d() { // from class: com.huawei.android.hicloud.cloudbackup.util.CloudBackup3rdIconUtil.1
            @Override // p616rk.AbstractRunnableC12516b
            public void call() throws C9721b {
                File fileM63441g = C10278a.m63441g(CloudBackup3rdIconUtil.getContext().getFilesDir(), CloudBackup3rdIconUtil.ICON_CACHE);
                if (!fileM63441g.exists() && !fileM63441g.mkdir()) {
                    C11839m.m70686d(CloudBackup3rdIconUtil.TAG, "virtual icon mkdirs failed.");
                }
                C12519c c12519c = new C12519c();
                List<String> listM75306q = c12519c.m75306q();
                boolean zContains = listM75306q.contains("music");
                listM75306q.removeAll(C14333b.m85476k());
                if (zContains) {
                    listM75306q.add("music");
                }
                for (String str : listM75306q) {
                    try {
                        AppIcon appIconM75296g = c12519c.m75296g(str);
                        if (appIconM75296g != null && appIconM75296g.getUrl() != null && !appIconM75296g.getUrl().isEmpty()) {
                            File fileM63441g2 = C10278a.m63441g(fileM63441g, str + ".icon");
                            if (fileM63441g2.exists()) {
                                String hash = appIconM75296g.getHash();
                                if (hash == null || hash.isEmpty()) {
                                    C11839m.m70686d(CloudBackup3rdIconUtil.TAG, "hash is null ：appId " + str);
                                } else {
                                    Md5AndHash md5AndHashM68622d = C11476b.m68622d(fileM63441g2);
                                    if (!hash.equals(md5AndHashM68622d.getHash()) && !hash.equals(md5AndHashM68622d.getMD5())) {
                                    }
                                }
                            }
                            CloudBackup3rdIconUtil.startDownloadVirtualIcon(str, appIconM75296g, fileM63441g2);
                        }
                    } catch (C9721b e10) {
                        C11839m.m70689w(CloudBackup3rdIconUtil.TAG, "download virtual app icons err, appId = " + str + " " + e10.getMessage());
                    }
                }
            }
        });
    }

    private static Bitmap drawable2Bitmap(String str, Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            C11839m.m70686d(TAG, "BitmapDrawable appId = " + str);
            return ((BitmapDrawable) drawable).getBitmap();
        }
        if (!(drawable instanceof NinePatchDrawable)) {
            C11839m.m70687e(TAG, "drawable2Bitmap null appId = " + str);
            return null;
        }
        C11839m.m70686d(TAG, "NinePatchDrawable appId = " + str);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        drawable.draw(canvas);
        return bitmapCreateBitmap;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:68:0x003f -> B:87:0x0056). Please report as a decompilation issue!!! */
    public static void drawable2File(Bitmap bitmap, String str) throws Throwable {
        if (bitmap == null) {
            return;
        }
        File file = new File(str);
        if (file.exists() && file.delete()) {
            C11839m.m70686d(TAG, "clear temp file.");
        }
        FileOutputStream fileOutputStream = null;
        try {
            try {
                try {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(str);
                    try {
                        if (bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream2)) {
                            fileOutputStream2.flush();
                        } else {
                            C11839m.m70689w(TAG, "write Bitmap to OutputStream failed");
                        }
                        fileOutputStream2.close();
                    } catch (IOException e10) {
                        e = e10;
                        fileOutputStream = fileOutputStream2;
                        C11839m.m70687e(TAG, e.getMessage());
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        fileOutputStream = fileOutputStream2;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e11) {
                                C11839m.m70687e(TAG, e11.getMessage());
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (IOException e12) {
                e = e12;
            }
        } catch (IOException e13) {
            C11839m.m70687e(TAG, e13.getMessage());
        }
    }

    private static Drawable drawableDefault() {
        return getContext().getResources().getDrawable(R$drawable.ic_app_data);
    }

    public static Drawable file2Drawable(String str, String str2) {
        try {
            Bitmap bitmapM7472c = C1248a.m7472c(str2);
            icon2Memory(str, bitmapM7472c);
            return new BitmapDrawable(bitmapM7472c);
        } catch (Exception unused) {
            return drawableDefault();
        }
    }

    public static File filterDownIcon(List<String> list, String str) {
        if (list.contains(SplitAppUtil.getSplitOriAppId(str))) {
            return null;
        }
        File fileM63441g = C10278a.m63441g(getContext().getFilesDir(), ICON_CACHE);
        if (!fileM63441g.exists() && !fileM63441g.mkdir()) {
            C11839m.m70686d(TAG, "3rd icon mkdirs failed.");
        }
        File fileM63441g2 = C10278a.m63441g(fileM63441g, str + ".icon");
        if (fileM63441g2.exists()) {
            return null;
        }
        return fileM63441g2;
    }

    public static Drawable get3rdDrawable(String str) {
        if ("thirdApp".equals(str)) {
            return getContext().getResources().getDrawable(R$drawable.icon_cloudbackup_applist);
        }
        if ("thirdAppData".equals(str)) {
            return getContext().getResources().getDrawable(R$drawable.ic_app_data);
        }
        if (C14333b.f63653e.containsKey(str)) {
            return getMultiPkgDrawable(str);
        }
        Bitmap iconFromMemory = getIconFromMemory(str);
        if (iconFromMemory != null && !iconFromMemory.isRecycled()) {
            return new BitmapDrawable(iconFromMemory);
        }
        File fileM63441g = C10278a.m63441g(getContext().getFilesDir(), ICON_CACHE);
        if (!fileM63441g.exists() && !fileM63441g.mkdir()) {
            C11839m.m70686d(TAG, "3rd icon mkdirs failed.");
            return drawableDefault();
        }
        File fileM63441g2 = C10278a.m63441g(fileM63441g, str + ".icon");
        if (fileM63441g2.exists()) {
            return file2Drawable(str, C10279b.m63452a(fileM63441g2));
        }
        Drawable drawable = get3rdDrawableByPackageName(str, fileM63441g2);
        return drawable != null ? drawable : drawableDefault();
    }

    public static Drawable get3rdDrawable2(String str) {
        Bitmap iconFromMemory = getIconFromMemory(str);
        if (iconFromMemory != null && !iconFromMemory.isRecycled()) {
            return new BitmapDrawable(iconFromMemory);
        }
        File fileM63441g = C10278a.m63441g(getContext().getFilesDir(), ICON_CACHE);
        File fileM63441g2 = C10278a.m63441g(fileM63441g, str + ".icon");
        return ((fileM63441g.exists() || fileM63441g.mkdir()) && fileM63441g2.exists()) ? file2Drawable(str, C10279b.m63452a(fileM63441g2)) : get3rdDrawableByPackageName(str, fileM63441g2);
    }

    private static Drawable get3rdDrawableByPackageName(String str, File file) {
        try {
            String splitOriAppId = SplitAppUtil.getSplitOriAppId(str);
            PackageManager packageManager = getContext().getPackageManager();
            Drawable drawableLoadIcon = packageManager.getPackageInfo(splitOriAppId, 0).applicationInfo.loadIcon(packageManager);
            Bitmap bitmapDrawable2Bitmap = drawable2Bitmap(str, drawableLoadIcon);
            icon2Memory(str, bitmapDrawable2Bitmap);
            drawable2File(bitmapDrawable2Bitmap, C10279b.m63452a(file));
            return drawableLoadIcon;
        } catch (PackageManager.NameNotFoundException | RuntimeException unused) {
            C11839m.m70688i(TAG, "current package name not found: " + str);
            return null;
        }
    }

    public static Context getContext() {
        return C0213f.m1377a();
    }

    public static Drawable getDrawable(String str) {
        return ("music".equals(str) && C11720a.m69921a().m69922b()) ? getDrawable("music", null) : getDrawable(str, C14333b.m85483r().get(str));
    }

    private static Bitmap getIconFromMemory(String str) {
        return BitmapLruCache.getInstance().get(str);
    }

    public static Drawable getMultiPkgDrawable(String str) {
        ArrayList arrayList = new ArrayList(10);
        ConcurrentHashMap<String, Object> concurrentHashMap = C14333b.f63650b;
        Object obj = concurrentHashMap.size() > 0 ? concurrentHashMap.get(str) : C14333b.f63653e.get(str);
        if (!(obj instanceof List)) {
            return drawableDefault();
        }
        Iterator it = ((List) obj).iterator();
        while (it.hasNext()) {
            arrayList.add((String) it.next());
        }
        File fileM63441g = C10278a.m63441g(getContext().getFilesDir(), ICON_CACHE);
        if (!fileM63441g.exists() && !fileM63441g.mkdir()) {
            C11839m.m70686d(TAG, "icons mkdirs failed.");
            return drawableDefault();
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            String str2 = (String) it2.next();
            if (str2 != null) {
                Bitmap iconFromMemory = getIconFromMemory(str2);
                if (iconFromMemory != null && !iconFromMemory.isRecycled()) {
                    return new BitmapDrawable(iconFromMemory);
                }
                File fileM63441g2 = C10278a.m63441g(fileM63441g, str2 + ".icon");
                if (fileM63441g2.exists()) {
                    return file2Drawable(str2, C10279b.m63452a(fileM63441g2));
                }
            }
        }
        Iterator it3 = arrayList.iterator();
        while (it3.hasNext()) {
            String str3 = (String) it3.next();
            if (str3 != null) {
                Drawable drawable = get3rdDrawableByPackageName(str3, C10278a.m63441g(fileM63441g, str3 + ".icon"));
                if (drawable != null) {
                    return drawable;
                }
            }
        }
        return drawableDefault();
    }

    private static void icon2Memory(String str, Bitmap bitmap) {
        if (bitmap == null) {
            return;
        }
        BitmapLruCache.getInstance().put(str, bitmap);
    }

    public static boolean isEncrypt() {
        return !C10028c.m62182c0().m62420y1();
    }

    private static void restore3rdIcon(File file, String str, CloudRestoreStatus cloudRestoreStatus) {
        String str2;
        String str3 = "";
        try {
            String strM66627b = C11058a.m66627b("00000");
            String appId = cloudRestoreStatus.getAppId();
            C11839m.m70686d(TAG, "download 3rd app icons start, appId = " + cloudRestoreStatus.getAppId());
            String strM63452a = C10279b.m63452a(file);
            if (isEncrypt() || cloudRestoreStatus.getAppType() != 1) {
                if (cloudRestoreStatus.m29524M().isEmpty()) {
                    C11839m.m70689w(TAG, "download 3rd app icons url is empty, appId = " + appId);
                    return;
                }
                String strM29524M = cloudRestoreStatus.m29524M();
                String strM29509A = cloudRestoreStatus.m29509A();
                if (strM29509A.endsWith(".icon")) {
                    String strReplace = strM29509A.replace(".icon", "");
                    if (!strReplace.equals(cloudRestoreStatus.m29538f())) {
                        str3 = strReplace;
                    }
                    str2 = str3;
                } else {
                    str2 = strM29509A;
                }
                C11839m.m70686d(TAG, "download standard apk icon, url = " + strM29524M + ",aid = " + cloudRestoreStatus.m29509A() + ",local path = " + strM63452a);
                new C12478a(EnumC12999a.CLOUD_BACKUP, strM66627b).m74915k(strM29524M, str2, strM63452a, 0L, restoreCallback());
            } else {
                if (cloudRestoreStatus.m29522L().isEmpty()) {
                    C11839m.m70689w(TAG, "download 3rd app icons url is empty, appId = " + appId);
                    return;
                }
                String strM29522L = cloudRestoreStatus.m29522L();
                new C12478a(EnumC12999a.CLOUD_BACKUP, strM66627b).m74913i(str + appId + "/" + strM29522L.substring(strM29522L.lastIndexOf("/") + 1), strM63452a, restoreCallback());
            }
            C11839m.m70686d(TAG, "download 3rd app icons end, appId = " + cloudRestoreStatus.getAppId());
        } catch (C9721b e10) {
            C11839m.m70689w(TAG, "download 3rd app icons err, appId = " + cloudRestoreStatus.getAppId() + " " + e10.getMessage());
        }
    }

    private static ICallback restoreCallback() {
        return new ICallback() { // from class: com.huawei.android.hicloud.cloudbackup.util.CloudBackup3rdIconUtil.4
            public boolean onPause() {
                return false;
            }

            @Override // com.huawei.android.hicloud.connect.progress.ICallback
            public void onProgress(long j10, long j11) {
            }

            @Override // com.huawei.android.hicloud.connect.progress.ICallback
            public boolean onStop() {
                return false;
            }
        };
    }

    public static void startDownload3rdIcons(String str, CBSAppInfo cBSAppInfo, String str2, File file) throws C9721b {
        restore3rdIcon(file, str, new CloudRestoreClient().buildRestoreStatus(cBSAppInfo, null));
        CBCallBack.getInstance().sendMessage(Message.obtain(null, 33001, str2));
    }

    public static void startDownloadVirtualIcon(String str, AppIcon appIcon, File file) throws C9721b {
        new C12478a(EnumC12999a.CLOUD_BACKUP, C11058a.m66627b("00000")).m74915k(appIcon.getUrl(), appIcon.getHash(), C10279b.m63452a(file), 0L, restoreCallback());
        CBCallBack.getInstance().sendMessage(Message.obtain(null, 33001, str));
    }

    public static Drawable getDrawable(String str, Integer num) {
        if (num != null && num.intValue() > 0) {
            return getContext().getResources().getDrawable(num.intValue());
        }
        Bitmap iconFromMemory = getIconFromMemory(str);
        if (iconFromMemory != null && !iconFromMemory.isRecycled()) {
            return new BitmapDrawable(iconFromMemory);
        }
        File fileM63441g = C10278a.m63441g(getContext().getFilesDir(), ICON_CACHE);
        if (!fileM63441g.exists() && !fileM63441g.mkdir()) {
            C11839m.m70686d(TAG, "virtual icon mkdirs failed.");
            return drawableDefault();
        }
        File fileM63441g2 = C10278a.m63441g(fileM63441g, str + ".icon");
        if (fileM63441g2.exists()) {
            return file2Drawable(str, C10279b.m63452a(fileM63441g2));
        }
        return getContext().getResources().getDrawable(R$drawable.icon_app_data);
    }
}
