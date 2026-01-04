package com.huawei.android.backup.service.logic.installedapps;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.p017pm.IPackageInstallObserver;
import android.content.pm.IPackageDeleteObserver;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.text.TextUtils;
import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.android.backup.filelogic.utils.PmsCheckUtil;
import com.huawei.android.backup.service.logic.AbstractC2124a;
import com.huawei.android.backup.service.logic.BackupObject;
import com.huawei.android.backup.service.logic.C2152k;
import com.huawei.android.backup.service.model.BackupFileModuleInfo;
import com.huawei.android.backup.service.utils.C2157a;
import com.huawei.android.hicloud.cloudbackup.process.CloneService;
import com.huawei.hiar.ARImageMetadata;
import com.huawei.ohos.localability.base.IInstallerCallback;
import com.huawei.ohos.localability.base.InstallParam;
import gt.C10046b;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import p006a5.AbstractC0048c;
import p229di.C9142g;
import p229di.C9146k;
import p229di.C9150o;
import p229di.C9153r;
import p386j6.C10713c;
import p632s4.C12701e;
import p699v4.C13334c;
import p699v4.C13338g;
import p699v4.C13339h;
import p699v4.C13345n;
import p699v4.C13349r;
import p762x4.C13694a;

/* loaded from: classes.dex */
public abstract class BackupInstallApp extends AbstractC2124a {

    /* renamed from: n */
    public static final String f9618n;

    /* renamed from: o */
    public static final String f9619o;

    /* renamed from: d */
    public String f9621d;

    /* renamed from: e */
    public volatile boolean f9622e;

    /* renamed from: g */
    public volatile int f9624g;

    /* renamed from: h */
    public volatile int f9625h;

    /* renamed from: c */
    public String f9620c = null;

    /* renamed from: f */
    public String f9623f = "";

    /* renamed from: i */
    public volatile boolean f9626i = false;

    /* renamed from: j */
    public boolean f9627j = true;

    /* renamed from: k */
    public boolean f9628k = false;

    /* renamed from: l */
    public BroadcastReceiver f9629l = new BroadcastReceiver() { // from class: com.huawei.android.backup.service.logic.installedapps.BackupInstallApp.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            C2111d.m12653i("BackupInstallApp", "onReceive installFinishBroadCast start");
            if (intent != null) {
                BackupInstallApp.this.f9624g = C13338g.m80011b(intent, "android.content.pm.extra.LEGACY_STATUS", 0);
            } else {
                BackupInstallApp.this.f9624g = 0;
            }
            BackupInstallApp.this.f9626i = true;
            C2111d.m12653i("BackupInstallApp", "onReceive installFinishBroadCast installResultCode = " + BackupInstallApp.this.f9624g);
        }
    };

    /* renamed from: m */
    public BroadcastReceiver f9630m = new BroadcastReceiver() { // from class: com.huawei.android.backup.service.logic.installedapps.BackupInstallApp.2
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            C2111d.m12653i("BackupInstallApp", "onReceive uninstallFinishBroadCast start");
            if (intent != null) {
                BackupInstallApp.this.f9625h = C13338g.m80011b(intent, "android.content.pm.extra.LEGACY_STATUS", 0);
            } else {
                BackupInstallApp.this.f9625h = 0;
            }
            BackupInstallApp.this.f9626i = true;
            C2111d.m12653i("BackupInstallApp", "onReceive uninstallFinishBroadCast installResultCode = " + BackupInstallApp.this.f9625h);
        }
    };

    /* renamed from: com.huawei.android.backup.service.logic.installedapps.BackupInstallApp$3 */
    public class C21393 extends IPackageDeleteObserver.Stub {
        public C21393() {
        }

        public void packageDeleted(String str, int i10) throws RemoteException {
            BackupInstallApp.this.f9625h = i10;
            BackupInstallApp.this.f9626i = true;
        }
    }

    /* renamed from: com.huawei.android.backup.service.logic.installedapps.BackupInstallApp$4 */
    public class BinderC21404 extends IPackageInstallObserver.Stub {
        public BinderC21404() {
        }

        @Override // android.content.p017pm.IPackageInstallObserver
        public void packageInstalled(String str, int i10) throws RemoteException {
            BackupInstallApp.this.f9624g = i10;
            BackupInstallApp.this.f9626i = true;
        }
    }

    public static class HapFileNameFilter implements FilenameFilter {
        private HapFileNameFilter() {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return str.endsWith(".hap");
        }
    }

    static {
        f9618n = C9142g.m57463b() ? "com.hihonor.appmarket" : "com.huawei.appmarket";
        f9619o = C9142g.m57463b() ? "com.hihonor.smarthome" : "com.huawei.smarthome";
    }

    /* renamed from: m0 */
    private void m12840m0() throws InterruptedException {
        while (!this.f9626i && !BackupObject.isAbort()) {
            try {
                Thread.sleep(100L);
            } catch (InterruptedException unused) {
                C2111d.m12648d("BackupInstallApp", "Sleep Failed");
                return;
            }
        }
    }

    /* renamed from: A */
    public void m12841A(Context context, String str) {
        m12842B(context, str, C9153r.m57494b());
    }

    /* renamed from: B */
    public void m12842B(Context context, String str, int i10) {
        ActivityManager activityManager;
        if (str == null || context == null) {
            C2111d.m12648d("BackupInstallApp", "forceStopAppPackageAsUser : packageName or context is null");
            return;
        }
        if (C10713c.m65395e(BackupObject.getExecuteParameter(), "ForceStopBackgroundFlag", 0) == 1 && (activityManager = (ActivityManager) context.getSystemService("activity")) != null) {
            if (C2157a.m13177L(context) && C13349r.m80087c()) {
                C9146k.m57481b(activityManager, str, i10);
            } else {
                C9146k.m57480a(activityManager, str);
            }
        }
    }

    /* renamed from: C */
    public int m12843C(AbstractC0048c abstractC0048c) {
        Bundle bundleM65393c = C10713c.m65393c(BackupObject.getExecuteParameter(), "app");
        return bundleM65393c == null ? m12846F(abstractC0048c) : C10713c.m65395e(bundleM65393c, this.backupFileModuleInfo.getName(), 0);
    }

    /* renamed from: D */
    public File m12844D(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return new File(context.getPackageManager().getPackageInfo(this.backupFileModuleInfo.getName(), 0).applicationInfo.sourceDir);
        } catch (PackageManager.NameNotFoundException | RuntimeException unused) {
            C2111d.m12648d("BackupInstallApp", "getApkSourceFile NameNotFoundException");
            return null;
        }
    }

    /* renamed from: E */
    public String m12845E(Context context, String str) throws PackageManager.NameNotFoundException {
        if (context == null) {
            return null;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            if (packageInfo != null) {
                return String.valueOf(packageInfo.versionCode);
            }
            return null;
        } catch (PackageManager.NameNotFoundException | RuntimeException unused) {
            C2111d.m12648d("BackupInstallApp", "getAppVersionCode NameNotFoundException");
            return null;
        }
    }

    /* renamed from: F */
    public final int m12846F(AbstractC0048c abstractC0048c) {
        String strM196n = abstractC0048c.m196n();
        String str = strM196n + C13334c.m79984q();
        if (strM196n.length() >= 3) {
            str = strM196n.substring(0, strM196n.length() - 3) + C13334c.m79984q();
        }
        boolean zExists = new File(str).exists();
        return new File(strM196n).exists() ? (zExists ? 1 : 0) + 2 : zExists ? 1 : 0;
    }

    /* renamed from: G */
    public final int m12847G(String str, Bundle bundle) {
        int iM65395e = C10713c.m65395e(bundle, this.backupFileModuleInfo.getName(), 3);
        if (!C2157a.m13174I(str)) {
            return iM65395e;
        }
        C2111d.m12654j("BackupInstallApp", "this app is in the DefaultPackage, moduleName :", str, ";backupType :", 1);
        return 1;
    }

    /* renamed from: H */
    public File m12848H(Context context) {
        PackageManager packageManager;
        if (context == null || (packageManager = context.getPackageManager()) == null) {
            return null;
        }
        try {
            String str = packageManager.getApplicationInfo(this.backupFileModuleInfo.getName(), 0).sourceDir;
            return new File(str.substring(0, str.lastIndexOf(File.separator)));
        } catch (PackageManager.NameNotFoundException | RuntimeException unused) {
            C2111d.m12648d("BackupInstallApp", "NameNotFoundException");
            return null;
        }
    }

    /* renamed from: I */
    public final int m12849I(PackageManager packageManager, PackageInfo packageInfo) {
        this.f9628k = true;
        if (!m12863W(packageManager, packageInfo)) {
            return 10;
        }
        this.f9627j = false;
        return 18;
    }

    /* renamed from: J */
    public final int m12850J() {
        return this.f9624g;
    }

    /* renamed from: K */
    public final int m12851K(Context context, PackageManager packageManager, PackageInfo packageInfo, Uri uri) throws InterruptedException {
        if (this.f9624g == 1) {
            return 13;
        }
        if (!m12862V()) {
            C2111d.m12648d("BackupInstallApp", "Install package Error : " + this.f9624g);
            return 12;
        }
        if (!this.f9628k) {
            C2111d.m12653i("BackupInstallApp", "getInstallFlags MSG_ONE_APK_RESTORE_FAIL");
            return 12;
        }
        int iM12852L = m12852L();
        if (iM12852L == 2) {
            C2111d.m12653i("BackupInstallApp", "Install package installFlags getOppositeInstallFlags: " + iM12852L + "second install is fail");
            return 12;
        }
        m12891w(context, packageManager, packageInfo, iM12852L, uri);
        C2111d.m12653i("BackupInstallApp", "Install package installFlags getOppositeInstallFlags: " + iM12852L + "Install package Error : " + this.f9624g);
        return m12851K(context, packageManager, packageInfo, uri);
    }

    /* renamed from: L */
    public final int m12852L() {
        this.f9628k = false;
        if (this.f9627j) {
            return 18;
        }
        C2111d.m12653i("BackupInstallApp", "getInstallFlags FileHelper isSDCardInserted():" + C13334c.m79961E());
        return C13334c.m79961E() ? 10 : 2;
    }

    /* renamed from: M */
    public final PackageInfo m12853M(File file, PackageManager packageManager) {
        try {
            return packageManager.getPackageArchiveInfo(file.getCanonicalPath(), 0);
        } catch (IOException unused) {
            C2111d.m12648d("BackupInstallApp", "installApk : get packageInfo IO err");
            return null;
        }
    }

    /* renamed from: N */
    public final File m12854N(Context context, File file, Handler.Callback callback, Object obj) {
        if (!TextUtils.isEmpty(C13345n.m80063b(context)) && isUseDataTrans()) {
            C2111d.m12653i("BackupInstallApp", "install from data");
        }
        return file;
    }

    /* renamed from: O */
    public final int m12855O(Context context, String str, Handler.Callback callback, Object obj) throws InterruptedException {
        C2111d.m12654j("BackupInstallApp", "install apk begin, ", str);
        if (context == null || str == null) {
            C2111d.m12657m("BackupInstallApp", "installApk apkFullName or context is null");
            return 12;
        }
        File file = new File(str);
        if (!file.exists()) {
            C2111d.m12648d("BackupInstallApp", "file isn't exist apkFile path = " + str);
            sendMsg(22, 0, 0, callback, obj);
            return 12;
        }
        File fileM12854N = m12854N(context, file, callback, obj);
        if (fileM12854N == null) {
            C2111d.m12648d("BackupInstallApp", "installApk : tempFile is null");
            return 12;
        }
        Uri uriFromFile = Uri.fromFile(fileM12854N);
        PackageManager packageManager = context.getPackageManager();
        PackageInfo packageInfoM12853M = m12853M(fileM12854N, packageManager);
        if (packageInfoM12853M == null) {
            C2111d.m12648d("BackupInstallApp", "get packageInfo null");
            sendMsg(12, 12, 0, callback, obj);
            return 12;
        }
        if (m12866Z(packageManager, packageInfoM12853M)) {
            if (!f9619o.equals(packageInfoM12853M.packageName)) {
                sendMsg(13, 0, 0, callback, obj);
                return 4;
            }
            m12879l0(context, packageManager, packageInfoM12853M, uriFromFile);
            if (this.f9625h != 1) {
                sendMsg(12, 12, 0, callback, obj);
                return 12;
            }
        }
        m12891w(context, packageManager, packageInfoM12853M, m12849I(packageManager, packageInfoM12853M), uriFromFile);
        int iM12851K = m12851K(context, packageManager, packageInfoM12853M, uriFromFile);
        m12887s(file);
        m12887s(fileM12854N);
        if (iM12851K != 13) {
            m12875i0(context, callback, obj, iM12851K);
        } else {
            sendMsg(13, 0, 0, callback, obj);
        }
        C2111d.m12654j("BackupInstallApp", "time test --- ", "install apk filePath ", str, " end");
        return 4;
    }

    /* renamed from: P */
    public final int m12856P(Context context, String str, Handler.Callback callback, Object obj) throws InterruptedException {
        if (context == null) {
            return 12;
        }
        File file = new File(str);
        if (!file.exists()) {
            C2111d.m12648d("BackupInstallApp", "file isn't exist");
            sendMsg(22, 0, 0, callback, obj);
            return 12;
        }
        int iM12892x = m12892x(context, file);
        m12887s(file);
        if (iM12892x != 13) {
            m12874h0(context, callback, obj, iM12892x);
            return 4;
        }
        sendMsg(13, 0, 0, callback, obj);
        return 4;
    }

    /* renamed from: Q */
    public final int m12857Q(Context context, ArrayList<String> arrayList, Handler.Callback callback, Object obj) throws InterruptedException {
        m12893y(context, arrayList);
        C2111d.m12654j("BackupInstallApp", "app[", this.backupFileModuleInfo.getName(), "]install result = ", Integer.valueOf(this.f9624g));
        if (this.f9624g == 1) {
            sendMsg(13, 0, 0, callback, obj);
        } else {
            m12875i0(context, callback, obj, this.f9624g);
        }
        m12888t(arrayList);
        return 4;
    }

    /* renamed from: R */
    public final int m12858R(Context context, ArrayList<String> arrayList, Handler.Callback callback, Object obj) throws InterruptedException {
        this.f9624g = -1;
        m12894z(context, arrayList);
        C2111d.m12654j("BackupInstallApp", "hap app[", this.backupFileModuleInfo.getName(), "]install result = ", Integer.valueOf(this.f9624g));
        if (this.f9624g == 0) {
            sendMsg(13, 0, 0, callback, obj);
        } else {
            m12874h0(context, callback, obj, this.f9624g);
        }
        m12888t(arrayList);
        return 4;
    }

    /* renamed from: S */
    public boolean m12859S(String str) {
        if (str == null) {
            C2111d.m12648d("BackupInstallApp", "filePath is null");
            return true;
        }
        File file = new File(str);
        if (file.exists()) {
            return file.exists() && file.length() == 0;
        }
        return true;
    }

    /* renamed from: T */
    public boolean m12860T(String str, Context context) {
        boolean zM65391a;
        Bundle bundleM65393c = C10713c.m65393c(BackupObject.getExecuteParameter(), "app");
        if (bundleM65393c != null) {
            zM65391a = C10713c.m65391a(bundleM65393c, "app_name_" + str);
        } else {
            zM65391a = false;
        }
        return (context == null || !"com.huawei.hidisk".equals(context.getPackageName())) ? zM65391a : C10046b.m62458f(str);
    }

    /* renamed from: U */
    public boolean m12861U(ArrayList<String> arrayList) {
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            if (!it.next().endsWith(".hap")) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: V */
    public final boolean m12862V() {
        return this.f9624g == -4 || this.f9624g == -18 || this.f9624g == -3;
    }

    /* renamed from: W */
    public final boolean m12863W(PackageManager packageManager, PackageInfo packageInfo) {
        return (packageInfo.installLocation == 2 && C13334c.m79961E() && !m12868b0(packageManager, packageInfo.applicationInfo.packageName)) ? false : true;
    }

    /* renamed from: X */
    public final boolean m12864X(Context context) {
        return m12865Y(context, C9153r.m57494b());
    }

    /* renamed from: Y */
    public final boolean m12865Y(Context context, int i10) {
        if (context == null) {
            C2111d.m12648d("BackupInstallApp", "isPackageInstalled : context is null");
            return false;
        }
        try {
            C9150o.m57488b(context.getPackageManager(), this.backupFileModuleInfo.getName(), 64, i10);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            C2111d.m12648d("BackupInstallApp", this.backupFileModuleInfo.getName() + " is not installed!");
            return false;
        } catch (Exception unused2) {
            C2111d.m12649e("BackupInstallApp", this.backupFileModuleInfo.getName(), "is Exception");
            return false;
        }
    }

    /* renamed from: Z */
    public final boolean m12866Z(PackageManager packageManager, PackageInfo packageInfo) throws PackageManager.NameNotFoundException {
        String str = packageInfo.applicationInfo.packageName;
        try {
            PackageInfo packageInfo2 = packageManager.getPackageInfo(str, 64);
            if (packageInfo2 == null || packageInfo2.versionCode < packageInfo.versionCode) {
                return false;
            }
            C2111d.m12653i("BackupInstallApp", str + " has installed new version, don't need to install again.");
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            C2111d.m12657m("BackupInstallApp", packageInfo.applicationInfo.packageName + " is not installed!");
            return false;
        }
    }

    /* renamed from: a0 */
    public boolean m12867a0() {
        if (!isUseDataTrans() || !isOtherPhoneSupportTar() || !PmsCheckUtil.m12614h()) {
            return true;
        }
        C2111d.m12646b("BackupInstallApp", "isSupportEncryption false");
        return false;
    }

    /* renamed from: b0 */
    public final boolean m12868b0(PackageManager packageManager, String str) {
        try {
            if ((packageManager.getPackageInfo(str, 1).applicationInfo.flags & 1) != 0) {
                return true;
            }
            C2111d.m12653i("BackupInstallApp", "package is not a system APP!");
            return false;
        } catch (PackageManager.NameNotFoundException | RuntimeException unused) {
            C2111d.m12653i("BackupInstallApp", "package is not installed!");
            return false;
        }
    }

    /* renamed from: c0 */
    public boolean m12869c0() {
        if (m12871e0() || !isUseDataTrans() || !isOtherPhoneSupportPms() || !PmsCheckUtil.m12611e()) {
            return false;
        }
        C2111d.m12646b("BackupInstallApp", "isUseCloneTarType true");
        return true;
    }

    @Override // com.huawei.android.backup.service.logic.BackupObject
    public int createSecurityV3Info(Context context, String str) {
        BackupFileModuleInfo backupFileModuleInfo;
        if (str == null || (backupFileModuleInfo = this.backupFileModuleInfo) == null || context == null) {
            return 10001;
        }
        backupFileModuleInfo.setCheckMsgV3("checkMsg");
        return 10000;
    }

    /* renamed from: d0 */
    public boolean m12870d0() {
        if (m12871e0() || m12869c0()) {
            return false;
        }
        C2111d.m12646b("BackupInstallApp", "isUseDBType false");
        return true;
    }

    /* renamed from: e0 */
    public boolean m12871e0() {
        if (!isUseDataTrans() || !isOtherPhoneSupportTar() || !PmsCheckUtil.m12614h()) {
            return false;
        }
        if (BackupObject.isBothSupportSplitTar()) {
            return true;
        }
        if ("com.tencent.mm".equals(this.f9621d) && isWechatUsePmsFile()) {
            return false;
        }
        C2111d.m12646b("BackupInstallApp", "isUseTarType true");
        return true;
    }

    /* renamed from: f0 */
    public final void m12872f0(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.hicloud.android.clone.installapp.finish.action");
        context.registerReceiver(this.f9629l, intentFilter, "com.hicloud.android.cloudbackup.permission.ACCESS", null);
    }

    /* renamed from: g0 */
    public final void m12873g0(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.hicloud.android.clone.uninstallapp.finish.action");
        context.registerReceiver(this.f9630m, intentFilter, "com.hicloud.android.cloudbackup.permission.ACCESS", null);
    }

    /* renamed from: h0 */
    public final void m12874h0(Context context, Handler.Callback callback, Object obj, int i10) {
        String strM12650f = C2111d.m12650f("BackupInstallApp", "copyFile", "install Failed, install error code = " + i10, this.backupFileModuleInfo.getName(), m12845E(context, this.backupFileModuleInfo.getName()));
        sendMsg(101, strM12650f, callback, obj);
        C2111d.m12648d("BackupInstallApp", strM12650f);
        sendMsg(12, m12850J(), 0, callback, obj);
    }

    /* renamed from: i0 */
    public final void m12875i0(Context context, Handler.Callback callback, Object obj, int i10) {
        String strM12650f = C2111d.m12650f("BackupInstallApp", "copyFile", "install Failed, install error code = " + i10, this.backupFileModuleInfo.getName(), m12845E(context, this.backupFileModuleInfo.getName()));
        sendMsg(101, strM12650f, callback, obj);
        C2111d.m12648d("BackupInstallApp", strM12650f);
        sendMsg(i10, m12850J(), 0, callback, obj);
    }

    @Override // com.huawei.android.backup.service.logic.BackupObject
    public boolean isSupported(Context context, String str) {
        return false;
    }

    /* renamed from: j0 */
    public abstract int mo12876j0(Context context, AbstractC0048c abstractC0048c, Handler.Callback callback, Object obj);

    /* renamed from: k0 */
    public abstract void mo12877k0(Context context, AbstractC0048c abstractC0048c, Handler.Callback callback, Object obj);

    /* renamed from: l */
    public boolean m12878l(String str, ArrayList<String> arrayList) {
        File file = new File(str);
        if (!file.exists()) {
            C2111d.m12648d("BackupInstallApp", "apk dir isn't exist.");
            return true;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null || fileArrListFiles.length == 0) {
            C2111d.m12648d("BackupInstallApp", "There is no apk file.");
            return true;
        }
        try {
            for (File file2 : fileArrListFiles) {
                if (file2.getCanonicalPath().endsWith(C13334c.m79984q()) || file2.getCanonicalPath().endsWith(".hap")) {
                    arrayList.add(file2.getCanonicalPath());
                }
            }
        } catch (IOException unused) {
            C2111d.m12648d("BackupInstallApp", "getRestoreApksList: IOException");
        }
        return false;
    }

    /* renamed from: l0 */
    public final void m12879l0(Context context, PackageManager packageManager, PackageInfo packageInfo, Uri uri) throws InterruptedException {
        this.f9626i = false;
        String str = packageInfo.packageName;
        m12873g0(context);
        if (new C2143a(context, packageManager, uri).m12898d(str)) {
            m12840m0();
        } else {
            this.f9626i = true;
            this.f9625h = 0;
        }
        context.unregisterReceiver(this.f9630m);
    }

    /* renamed from: m */
    public abstract int mo12880m(Context context, AbstractC0048c abstractC0048c, Handler.Callback callback, Object obj);

    /* renamed from: n */
    public final int m12881n(Context context, AbstractC0048c abstractC0048c, Handler.Callback callback, Object obj) {
        return m12860T(this.f9621d, context) ? mo12885q(context, abstractC0048c, callback, obj) : mo12880m(context, abstractC0048c, callback, obj);
    }

    /* renamed from: n0 */
    public final void m12882n0() throws InterruptedException {
        for (int i10 = 0; !this.f9626i && i10 < 36000 && !BackupObject.isAbort(); i10++) {
            try {
                Thread.sleep(100L);
            } catch (InterruptedException unused) {
                C2111d.m12648d("BackupInstallApp", "Sleep Failed");
                return;
            }
        }
    }

    /* renamed from: o */
    public void m12883o(Context context, boolean z10) {
        if (context == null) {
            C2111d.m12653i("BackupInstallApp", "context is null.");
            return;
        }
        if (z10 && !BackupObject.isSupportBundleApp()) {
            C2111d.m12653i("BackupInstallApp", "Don't support transfer bundle app.");
            return;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(this.backupFileModuleInfo.getName(), 0);
            if (C13694a.m82330h(context, this.backupFileModuleInfo.getName())) {
                String[] strArrM82326d = C13349r.m80086b(context) ? C13694a.m82326d(context, packageInfo) : C13694a.m82324b(packageInfo);
                if (strArrM82326d != null && strArrM82326d.length != 0) {
                    this.backupFliedList.addAll(Arrays.asList(strArrM82326d));
                    return;
                }
                C2111d.m12648d("BackupInstallApp", "No split apk to backup.");
            }
        } catch (PackageManager.NameNotFoundException | RuntimeException unused) {
            C2111d.m12648d("BackupInstallApp", "backupBundleSplitApks: NameNotFoundException.");
        }
    }

    @Override // com.huawei.android.backup.service.logic.BackupObject
    public final int onBackup(Context context, AbstractC0048c abstractC0048c, Handler.Callback callback, Object obj, String str) {
        C2111d.m12653i("BackupInstallApp", "Backup install app.");
        if (abstractC0048c == null) {
            C2111d.m12653i("BackupInstallApp", "onBackup : storeHandler is null");
            return 2;
        }
        this.f9621d = str;
        Bundle bundleM65393c = C10713c.m65393c(BackupObject.getExecuteParameter(), "app");
        this.backupFileModuleInfo.setSdkSupport(8);
        this.backupFileModuleInfo.resetRecordTotal();
        if (bundleM65393c == null) {
            C2111d.m12657m("BackupInstallApp", "onbackup bundle is null moduleName = " + str);
            sendMsg(2, 0, 0, callback, obj);
            return 1;
        }
        int iM12847G = m12847G(str, bundleM65393c);
        new C12701e(context, str, true).m76428e();
        if (iM12847G == 1) {
            int iM12881n = m12881n(context, abstractC0048c, callback, obj);
            if ("com.huawei.hidisk".equals(context.getPackageName()) || iM12881n != 1) {
                abstractC0048c.m190h();
            }
            return iM12881n;
        }
        if (iM12847G == 2) {
            mo12884p(context, abstractC0048c, callback, obj);
        } else if (iM12847G == 3) {
            int iM12881n2 = m12881n(context, abstractC0048c, callback, obj);
            if (iM12881n2 != 1) {
                abstractC0048c.m190h();
                return iM12881n2;
            }
            mo12884p(context, abstractC0048c, callback, obj);
        }
        return 1;
    }

    @Override // com.huawei.android.backup.service.logic.BackupObject
    public Bundle onBackupModulesDataItemTotal(Context context, Long l10, int i10, String str) {
        C2111d.m12653i("BackupInstallApp", "onBacupModulesDataItemTotal.");
        Bundle bundle = new Bundle();
        if (context == null) {
            C2111d.m12648d("BackupInstallApp", "onBackupModulesDataItemTotal : context is null");
            return bundle;
        }
        int i11 = 0;
        int iM65395e = C10713c.m65395e(BackupObject.getExecuteParameter(), "isCpuArchTypeSame", 0);
        Set<String> setM13207o = C2157a.m13207o(iM65395e);
        if (C2152k.m12988n().m12992p()) {
            bundle = C2152k.m12988n().m12989l(setM13207o, iM65395e);
        } else {
            List<PackageInfo> installedPackages = context.getPackageManager().getInstalledPackages(64);
            if (installedPackages == null) {
                C2111d.m12653i("BackupInstallApp", "installedAppList is null");
                return null;
            }
            ArrayList<String> arrayList = new ArrayList<>(installedPackages.size());
            Set<String> setM13200h = C2157a.m13200h();
            boolean zM13177L = C2157a.m13177L(context);
            for (PackageInfo packageInfo : installedPackages) {
                if (C2150h.m12968b(packageInfo, setM13200h, setM13207o, iM65395e, zM13177L)) {
                    arrayList.add(packageInfo.packageName);
                    i11++;
                } else {
                    C2111d.m12653i("BackupInstallApp", "app [" + packageInfo.packageName + "] doesn't support clone.");
                }
            }
            bundle.putInt("ModuleCount", i11);
            bundle.putLong("ModuleSize", 1L);
            bundle.putStringArrayList("AppPackageList", arrayList);
        }
        bundle.putInt("APPDataFlag", AbstractC2124a.m12751c());
        return bundle;
    }

    @Override // com.huawei.android.backup.service.logic.BackupObject
    public final int onRestore(Context context, AbstractC0048c abstractC0048c, Handler.Callback callback, Object obj, String str) {
        C2111d.m12653i("BackupInstallApp", "Restore install app.");
        if (abstractC0048c == null) {
            return 5;
        }
        this.f9621d = str;
        int iM12843C = m12843C(abstractC0048c);
        C2111d.m12653i("BackupInstallApp", "openAndRestore!moduleName:" + str + ",actionType:" + iM12843C);
        if (C2157a.m13174I(str)) {
            C2111d.m12653i("BackupInstallApp", "this app is in the DefaultPackage and is only need to restore apk, moduleName :" + str + ";actionType :1");
            iM12843C = 1;
        }
        if (iM12843C == 1) {
            mo12876j0(context, abstractC0048c, callback, obj);
        } else if (iM12843C != 2) {
            if (iM12843C == 3) {
                boolean z10 = m12870d0() && m12859S(abstractC0048c.m196n());
                int iMo12876j0 = mo12876j0(context, abstractC0048c, callback, obj);
                if (iMo12876j0 == 4 && z10) {
                    sendMsg(3, 0, 0, callback, obj);
                } else if (iMo12876j0 == 4) {
                    mo12877k0(context, abstractC0048c, callback, obj);
                } else {
                    C2111d.m12646b("BackupInstallApp", "not need check");
                }
            }
        } else if (!m12864X(context)) {
            sendMsg(5, 0, 0, callback, obj);
        } else if (m12870d0() && m12859S(abstractC0048c.m196n())) {
            sendMsg(3, 0, 0, callback, obj);
        } else {
            mo12877k0(context, abstractC0048c, callback, obj);
        }
        return 4;
    }

    /* renamed from: p */
    public abstract void mo12884p(Context context, AbstractC0048c abstractC0048c, Handler.Callback callback, Object obj);

    /* renamed from: q */
    public abstract int mo12885q(Context context, AbstractC0048c abstractC0048c, Handler.Callback callback, Object obj);

    /* renamed from: r */
    public void m12886r(Context context, boolean z10) {
        if (context == null) {
            this.f9623f = "context is null.";
            C2111d.m12653i("BackupInstallApp", "context is null.");
            return;
        }
        File fileM12848H = m12848H(context);
        if (fileM12848H == null) {
            this.f9623f = "hapDir is null path: " + C13334c.m79991x(fileM12848H);
            return;
        }
        File[] fileArrListFiles = fileM12848H.listFiles(new HapFileNameFilter());
        if (fileArrListFiles != null && fileArrListFiles.length != 0) {
            int length = fileArrListFiles.length;
            while (i < length) {
                this.backupFliedList.add(fileArrListFiles[i].getPath());
                i++;
            }
            return;
        }
        File[] fileArrListFiles2 = fileM12848H.listFiles();
        String str = "There is no .hap files, check file length: " + (fileArrListFiles2 != null ? fileArrListFiles2.length : 0) + ",path: " + C13334c.m79991x(fileM12848H);
        this.f9623f = str;
        C2111d.m12648d("BackupInstallApp", str);
    }

    /* renamed from: s */
    public final void m12887s(File file) {
        if (C10713c.m65395e(BackupObject.getExecuteParameter(), CloneService.KEY_ACTION_FLAG, 1) == 2) {
            C13334c.m79979l(file);
        }
    }

    /* renamed from: t */
    public final void m12888t(List<String> list) {
        if (C10713c.m65395e(BackupObject.getExecuteParameter(), CloneService.KEY_ACTION_FLAG, 1) != 2) {
            C2111d.m12653i("BackupInstallApp", "old phone isn't android phone, No need to clean apks.");
            return;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            C13334c.m79980m(it.next());
        }
    }

    /* renamed from: u */
    public int mo12889u(String str, Context context, String str2, Handler.Callback callback, Object obj) {
        C2111d.m12647c("BackupInstallApp", "originDir is :", str);
        if (str2 == null) {
            sendMsg(100, C2111d.m12650f("BackupInstallApp", "copyFile", "destDir is null ", this.backupFileModuleInfo.getName(), m12845E(context, this.backupFileModuleInfo.getName())), callback, obj);
            return 11;
        }
        File fileM12844D = m12844D(context);
        if (fileM12844D == null) {
            sendMsg(100, C2111d.m12650f("BackupInstallApp", "copyFile", "apkFile is null ", this.backupFileModuleInfo.getName(), m12845E(context, this.backupFileModuleInfo.getName())), callback, obj);
            return 2;
        }
        if (!C13334c.m79968a(str2, fileM12844D.length())) {
            sendMsg(17, C13334c.m79993z(str2), 0, callback, obj);
            sendMsg(100, C2111d.m12650f("BackupInstallApp", "copyFile", "not enough storage errorCode = 17", this.backupFileModuleInfo.getName(), m12845E(context, this.backupFileModuleInfo.getName())), callback, obj);
            BackupObject.setAbort();
            return 17;
        }
        this.f9620c = fileM12844D.getPath();
        return m12890v(new File(str2, this.backupFileModuleInfo.getName() + C13334c.m79984q()), fileM12844D, callback, obj, context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9, types: [java.io.Closeable, java.io.FileOutputStream, java.io.OutputStream] */
    /* renamed from: v */
    public int m12890v(File file, File file2, Handler.Callback callback, Object obj, Context context) {
        FileInputStream fileInputStream;
        ?? fileOutputStream;
        if (file2 == null || file == null || !C13334c.m79978k(file)) {
            C2111d.m12648d("BackupInstallApp", "copyFile Err, parameter is null or create file err");
            sendMsg(100, C2111d.m12650f("BackupInstallApp", "copyFile", "copyFile Err, parameter is null", this.backupFileModuleInfo.getName(), m12845E(context, this.backupFileModuleInfo.getName())), callback, obj);
            return 11;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(file2);
            try {
                fileOutputStream = new FileOutputStream(file);
                try {
                    byte[] bArr = new byte[ARImageMetadata.SHADING_MODE];
                    while (!BackupObject.isAbort()) {
                        int i10 = fileInputStream.read(bArr);
                        if (i10 <= 0) {
                            fileOutputStream.flush();
                            C13339h.m80014a(fileOutputStream);
                            C13339h.m80014a(fileInputStream);
                            C2111d.m12654j("BackupInstallApp", "copy apk end , cost ", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
                            return 14;
                        }
                        fileOutputStream.write(bArr, 0, i10);
                    }
                    throw new IOException("Abort when copying apk file!");
                } catch (IOException unused) {
                    fileInputStream2 = fileInputStream;
                    fileOutputStream = fileOutputStream;
                    try {
                        if (!file.delete()) {
                            C2111d.m12648d("BackupInstallApp", "delete backup file fail!");
                        }
                        sendMsg(100, C2111d.m12650f("BackupInstallApp", "copyFile", "IOException", this.backupFileModuleInfo.getName(), m12845E(context, this.backupFileModuleInfo.getName())), callback, obj);
                        C13339h.m80014a(fileOutputStream);
                        C13339h.m80014a(fileInputStream2);
                        C2111d.m12654j("BackupInstallApp", "copy apk end , cost ", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
                        return 11;
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream = fileInputStream2;
                        fileInputStream2 = fileOutputStream;
                        C13339h.m80014a(fileInputStream2);
                        C13339h.m80014a(fileInputStream);
                        C2111d.m12654j("BackupInstallApp", "copy apk end , cost ", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileInputStream2 = fileOutputStream;
                    C13339h.m80014a(fileInputStream2);
                    C13339h.m80014a(fileInputStream);
                    C2111d.m12654j("BackupInstallApp", "copy apk end , cost ", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
                    throw th;
                }
            } catch (IOException unused2) {
                fileOutputStream = 0;
            } catch (Throwable th4) {
                th = th4;
                C13339h.m80014a(fileInputStream2);
                C13339h.m80014a(fileInputStream);
                C2111d.m12654j("BackupInstallApp", "copy apk end , cost ", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
                throw th;
            }
        } catch (IOException unused3) {
            fileOutputStream = 0;
        } catch (Throwable th5) {
            th = th5;
            fileInputStream = null;
        }
    }

    /* renamed from: w */
    public final void m12891w(Context context, PackageManager packageManager, PackageInfo packageInfo, int i10, Uri uri) throws InterruptedException {
        this.f9626i = false;
        m12872f0(context);
        if (new C2143a(context, packageManager, uri).m12895a()) {
            m12840m0();
        } else {
            this.f9626i = true;
            this.f9624g = -44;
        }
        context.unregisterReceiver(this.f9629l);
        C2111d.m12654j("BackupInstallApp", "installFlags: ", Integer.valueOf(i10), ";resultCode: ", Integer.valueOf(this.f9624g));
    }

    /* renamed from: x */
    public final int m12892x(Context context, File file) throws InterruptedException {
        this.f9626i = false;
        this.f9624g = -1;
        IInstallerCallback.AbstractBinderC6841a abstractBinderC6841a = new IInstallerCallback.AbstractBinderC6841a() { // from class: com.huawei.android.backup.service.logic.installedapps.BackupInstallApp.5
            @Override // com.huawei.ohos.localability.base.IInstallerCallback
            public void onFinished(int i10, String str) {
                BackupInstallApp.this.f9624g = i10;
                C2111d.m12654j("BackupInstallApp", "doInstallHap status: ", Integer.valueOf(BackupInstallApp.this.f9624g));
                BackupInstallApp.this.f9626i = true;
            }
        };
        ArrayList arrayList = new ArrayList();
        arrayList.add(file.getPath());
        InstallParam installParam = new InstallParam();
        installParam.f31517b = 0;
        if (C10046b.m62457e(context, arrayList, installParam, abstractBinderC6841a)) {
            m12882n0();
            return this.f9624g == 0 ? 13 : 12;
        }
        this.f9626i = true;
        C2111d.m12648d("BackupInstallApp", "doInstallHap fail");
        return 12;
    }

    /* renamed from: y */
    public final void m12893y(Context context, ArrayList<String> arrayList) throws InterruptedException {
        PackageManager packageManager = context.getPackageManager();
        m12872f0(context);
        if (new C2143a(context, packageManager, arrayList).m12896b()) {
            m12840m0();
        } else {
            C2111d.m12648d("BackupInstallApp", "doInstallMultiApk: install faild.");
            this.f9626i = true;
            this.f9624g = 0;
        }
        context.unregisterReceiver(this.f9629l);
    }

    /* renamed from: z */
    public final void m12894z(Context context, ArrayList<String> arrayList) throws InterruptedException {
        IInstallerCallback.AbstractBinderC6841a abstractBinderC6841a = new IInstallerCallback.AbstractBinderC6841a() { // from class: com.huawei.android.backup.service.logic.installedapps.BackupInstallApp.6
            @Override // com.huawei.ohos.localability.base.IInstallerCallback
            public void onFinished(int i10, String str) {
                C2111d.m12654j("BackupInstallApp", "status: ", Integer.valueOf(i10));
                BackupInstallApp.this.f9624g = i10;
                BackupInstallApp.this.f9626i = true;
            }
        };
        InstallParam installParam = new InstallParam();
        installParam.f31517b = 0;
        if (!C10046b.m62457e(context, arrayList, installParam, abstractBinderC6841a)) {
            C2111d.m12648d("BackupInstallApp", "doInstallMultiHap: install faild.");
            this.f9624g = -1;
            this.f9626i = true;
        }
        m12882n0();
    }
}
