package com.huawei.android.backup.service.logic.installedapps;

import android.app.AppGlobals;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.p017pm.IPackageDataObserver;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import com.huawei.android.backup.filelogic.utils.C2108a;
import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.android.backup.filelogic.utils.C2114g;
import com.huawei.android.backup.filelogic.utils.PmsCheckUtil;
import com.huawei.android.backup.service.logic.AbstractC2124a;
import com.huawei.android.backup.service.logic.BackupObject;
import com.huawei.android.backup.service.logic.C2132e;
import com.huawei.android.backup.service.logic.PMSbackupRestoreUtil;
import com.huawei.android.backup.service.model.BackupFileModuleInfo;
import com.huawei.android.backup.service.utils.BackupConstant;
import com.huawei.android.backup.service.utils.C2157a;
import com.huawei.android.hicloud.cloudbackup.process.CloneService;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import p006a5.AbstractC0048c;
import p229di.C9153r;
import p248e5.C9409b;
import p328h6.C10105e;
import p386j6.C10713c;
import p386j6.C10715e;
import p664u0.C13108a;
import p699v4.C13332a;
import p699v4.C13334c;
import p699v4.C13338g;
import p699v4.C13345n;
import p762x4.C13694a;
import p762x4.C13697d;
import p762x4.C13700g;

/* renamed from: com.huawei.android.backup.service.logic.installedapps.f */
/* loaded from: classes.dex */
public class C2148f extends BackupInstallApp {

    /* renamed from: t */
    public static final IntentFilter f9638t;

    /* renamed from: u */
    public static Handler.Callback f9639u;

    /* renamed from: v */
    public static int f9640v;

    /* renamed from: w */
    public static long f9641w;

    /* renamed from: x */
    public static final BroadcastReceiver f9642x;

    /* renamed from: p */
    public boolean f9643p = false;

    /* renamed from: q */
    public boolean f9644q = false;

    /* renamed from: r */
    public C13697d f9645r;

    /* renamed from: s */
    public C13700g f9646s;

    /* renamed from: com.huawei.android.backup.service.logic.installedapps.f$a */
    public class a extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                C2111d.m12648d("BackupInstallAppImp", "onReceive : intent is null");
                return;
            }
            long jM80012c = C13338g.m80012c(intent, "KeyDecryptedSize", 0L);
            int i10 = (int) jM80012c;
            if (TextUtils.isEmpty(C13338g.m80013d(intent, "KeyFilePath")) || C2148f.f9639u == null) {
                return;
            }
            Message messageObtain = Message.obtain();
            messageObtain.what = 71;
            messageObtain.arg1 = i10;
            messageObtain.arg2 = C2148f.f9640v;
            messageObtain.setData(C2150h.m12967a(jM80012c, C2148f.f9641w));
            C2148f.f9639u.handleMessage(messageObtain);
        }
    }

    /* renamed from: com.huawei.android.backup.service.logic.installedapps.f$b */
    public class b extends IPackageDataObserver.Stub {
        public b() {
        }

        @Override // android.content.p017pm.IPackageDataObserver
        public void onRemoveCompleted(String str, boolean z10) throws RemoteException {
            C2148f.this.f9643p = true;
            C2148f.this.f9644q = z10;
        }
    }

    static {
        IntentFilter intentFilter = new IntentFilter();
        f9638t = intentFilter;
        f9639u = null;
        f9642x = new a();
        intentFilter.addAction("DecryptProgressBroadcast");
    }

    /* renamed from: O0 */
    public static /* synthetic */ Object m12914O0(Method method) throws SecurityException {
        method.setAccessible(true);
        return null;
    }

    /* renamed from: z0 */
    private void m12921z0(Context context, AbstractC0048c abstractC0048c, Handler.Callback callback, Object obj) {
        C2111d.m12653i("BackupInstallAppImp", "backupExternalData");
        new C2145c().onBackup(context, abstractC0048c, callback, obj, this.f9621d);
    }

    /* renamed from: A0 */
    public final void m12922A0(Context context, String str) {
        if (BackupObject.isOtherPhoneSupportAppObb()) {
            List<String> listM79983p = C13334c.m79983p(C13345n.m80062a(context, str), str);
            C2111d.m12653i("BackupInstallAppImp", "backupObbFiles " + str + ", obb file num is " + listM79983p.size());
            this.backupFliedList.addAll(listM79983p);
        }
    }

    /* renamed from: B0 */
    public final int m12923B0(int i10) {
        if (i10 == 1 || !C2157a.m13174I(this.f9621d)) {
            return i10;
        }
        C2111d.m12653i("BackupInstallAppImp", "app [" + this.f9621d + "] is in the DefaultPackage and is only need to restore apk.");
        return 1;
    }

    /* renamed from: C0 */
    public final boolean m12924C0(Context context, String str) {
        return m12925D0(context, str, C9153r.m57494b());
    }

    /* renamed from: D0 */
    public boolean m12925D0(Context context, String str, int i10) throws IllegalAccessException, InterruptedException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        C2111d.m12653i("BackupInstallAppImp", "clean Data begin:" + str);
        if (context == null || str == null) {
            C2111d.m12648d("BackupInstallAppImp", "releaseResource,clean this app data fail");
            return false;
        }
        this.f9644q = false;
        this.f9643p = false;
        if (i10 == C9153r.m57494b()) {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                C2111d.m12653i("BackupInstallAppImp", "packageManager is null");
                return false;
            }
            try {
                final Method method = Class.forName("android.content.pm.IPackageManager").getMethod("clearApplicationUserData", String.class, IPackageDataObserver.class);
                AccessController.doPrivileged(new PrivilegedAction() { // from class: com.huawei.android.backup.service.logic.installedapps.e
                    @Override // java.security.PrivilegedAction
                    public final Object run() {
                        return C2148f.m12914O0(method);
                    }
                });
                method.invoke(packageManager, str, new b());
            } catch (Exception e10) {
                C2111d.m12653i("BackupInstallAppImp", "clearApplicationUserDataMethod.invoke error" + e10.getMessage());
                return false;
            }
        } else {
            try {
                AppGlobals.getPackageManager().clearApplicationUserData(str, new b(), i10);
            } catch (RemoteException e11) {
                C2111d.m12653i("BackupInstallAppImp", "remote exception happen: " + e11.getMessage());
                return false;
            } catch (Exception unused) {
                C2111d.m12653i("BackupInstallAppImp", "exception happen");
                return false;
            }
        }
        m12950m0();
        C2111d.m12647c("BackupInstallAppImp", "clean Data end:", str);
        return this.f9644q;
    }

    /* renamed from: E0 */
    public final void m12926E0(Context context, int i10, String str) throws IllegalAccessException, InterruptedException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        File file = new File(str + File.separator + this.f9621d + ".tar");
        if (file.exists() && !file.delete()) {
            C2111d.m12649e("BackupInstallAppImp", " file delete fail : ", file.getPath());
        }
        m12937Q0(i10, context, this.backupFileModuleInfo.getName(), C9153r.m57494b());
    }

    /* renamed from: F0 */
    public final void m12927F0(Context context, AbstractC0048c abstractC0048c, Handler.Callback callback, String str) {
        if (!C9409b.a.m59028a(C9409b.m59023d())) {
            abstractC0048c.mo172d(str);
            return;
        }
        f9640v = (int) new File(abstractC0048c.m196n()).length();
        f9641w = new File(abstractC0048c.m196n()).length();
        C13108a c13108aM78878b = C13108a.m78878b(context);
        if (c13108aM78878b != null) {
            BroadcastReceiver broadcastReceiver = f9642x;
            c13108aM78878b.m78880c(broadcastReceiver, f9638t);
            f9639u = callback;
            abstractC0048c.mo172d(str);
            c13108aM78878b.m78883f(broadcastReceiver);
            f9639u = null;
        }
    }

    /* renamed from: G0 */
    public final void m12928G0(Context context, AbstractC0048c abstractC0048c, Handler.Callback callback, String str) {
        if (m12867a0()) {
            m12927F0(context, abstractC0048c, callback, str);
        }
    }

    /* renamed from: H0 */
    public final String m12929H0(AbstractC0048c abstractC0048c) {
        String strM197o;
        return (!m12867a0() || (strM197o = abstractC0048c.m197o()) == null) ? abstractC0048c.m196n() : strM197o;
    }

    /* renamed from: I0 */
    public final String m12930I0(AbstractC0048c abstractC0048c) {
        try {
            return new File(abstractC0048c.m193k() + "/obb").getCanonicalPath();
        } catch (IOException unused) {
            C2111d.m12648d("BackupInstallAppImp", "getObbRootPath exception");
            return "";
        }
    }

    /* renamed from: J0 */
    public final ArrayList<String> m12931J0(String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (BackupObject.isSupportBundleApp()) {
            m12878l(str + File.separator + "apk", arrayList);
            return arrayList;
        }
        String str2 = str + C13334c.m79984q();
        if (C13334c.m79970c(new File(str2))) {
            arrayList.add(str2);
        }
        return arrayList;
    }

    /* renamed from: K0 */
    public final void m12932K0(Context context, String str, Handler.Callback callback, Object obj) {
        C2111d.m12654j("BackupInstallAppImp", "restoreApk isPackageInBlockList packageName = ", str);
        if (m12864X(context)) {
            return;
        }
        sendMsg(12, 0, 0, callback, obj);
    }

    /* renamed from: L0 */
    public final int m12933L0(Context context, Handler.Callback callback, Object obj, ArrayList<String> arrayList) {
        return arrayList.size() == 1 ? m12861U(arrayList) ? m12856P(context, arrayList.get(0), callback, obj) : m12855O(context, arrayList.get(0), callback, obj) : m12861U(arrayList) ? m12858R(context, arrayList, callback, obj) : m12857Q(context, arrayList, callback, obj);
    }

    /* renamed from: M0 */
    public final boolean m12934M0(String str) {
        if (!m12871e0()) {
            return true;
        }
        if (BackupObject.isSplitTarModule(this.f9621d)) {
            File[] fileArrListFiles = new File(str + "/split/").listFiles();
            return (fileArrListFiles == null || fileArrListFiles.length == 0) ? false : true;
        }
        File file = new File(str + File.separator + this.f9621d + ".tar");
        return file.exists() && file.length() > 0;
    }

    /* renamed from: N0 */
    public final boolean m12935N0(String str, Handler.Callback callback, Object obj) {
        int iM65395e = C10713c.m65395e(BackupObject.getExecuteParameter(), "isCpuArchTypeSame", 0);
        Set<String> setM13207o = C2157a.m13207o(iM65395e);
        if (iM65395e == 0 || !setM13207o.contains(str)) {
            return false;
        }
        C2111d.m12654j("BackupInstallAppImp", "restoreApk cpu version is not same, packageName = ", str);
        sendMsg(7, 0, 0, callback, obj);
        return true;
    }

    /* renamed from: P0 */
    public final void m12936P0(Context context, int i10, String str) {
        if (BackupConstant.m13130d().containsKey(str)) {
            String str2 = BackupConstant.m13130d().get(str);
            if (C2157a.m13194b(context, str2)) {
                C2111d.m12653i("BackupInstallAppImp", "Notify app [" + str + "] restored complete.");
                Bundle bundle = new Bundle();
                if (i10 == 3 || i10 == 2) {
                    bundle.putInt("restore_data_type", 1);
                } else {
                    bundle.putInt("restore_data_type", 0);
                }
                C2108a.m12616b(context, str2, "backup_recover_complete", null, reassembleExtra(bundle));
            }
        }
    }

    /* renamed from: Q0 */
    public void m12937Q0(int i10, Context context, String str, int i11) throws IllegalAccessException, InterruptedException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (context == null || str == null) {
            C2111d.m12653i("BackupInstallAppImp", "releaseResource,clean this app data fail");
        } else if (i10 == -1) {
            C2111d.m12653i("BackupInstallAppImp", "releaseResource,restore apk data fail,clean this app data");
            m12925D0(context, str, i11);
        }
    }

    /* renamed from: R0 */
    public final void m12938R0(Context context, String str) {
        if ("com.tencent.mm".equals(str)) {
            C2111d.m12653i("BackupInstallAppImp", "resetWechatRecordNoMediaState");
            context.getSharedPreferences("config_info", 4).edit().putBoolean("isNoMediaFilesRestoreDone", false).apply();
        }
    }

    /* renamed from: S0 */
    public final int m12939S0(Context context, AbstractC0048c abstractC0048c, Handler.Callback callback, Object obj, String str) throws IllegalAccessException, InterruptedException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        boolean z10;
        C2111d.m12654j("BackupInstallAppImp", "restoreApkAndData ", str);
        String strM196n = abstractC0048c.m196n();
        if (m12870d0() && m12859S(strM196n)) {
            z10 = true;
        } else {
            m12928G0(context, abstractC0048c, callback, strM196n);
            z10 = false;
        }
        if (mo12876j0(context, abstractC0048c, callback, obj) == 5) {
            return 5;
        }
        if (z10) {
            sendMsg(3, 0, 0, callback, obj);
        } else {
            mo12877k0(context, abstractC0048c, callback, obj);
        }
        boolean zM12947a1 = m12947a1(context, abstractC0048c, str);
        C2111d.m12654j("BackupInstallAppImp", "restoreObbFiles result ", Boolean.valueOf(zM12947a1));
        if (zM12947a1) {
            return 4;
        }
        sendMsg(5, 0, 0, callback, obj);
        return 5;
    }

    /* renamed from: T0 */
    public final int m12940T0(Context context, AbstractC0048c abstractC0048c, Handler.Callback callback, Object obj, String str) {
        C2111d.m12654j("BackupInstallAppImp", "restoreApkOnly ", str);
        if (mo12876j0(context, abstractC0048c, callback, obj) == 5) {
            return 5;
        }
        boolean zM12947a1 = m12947a1(context, abstractC0048c, str);
        C2111d.m12654j("BackupInstallAppImp", "restoreObbFiles result ", Boolean.valueOf(zM12947a1));
        if (zM12947a1) {
            return 4;
        }
        sendMsg(5, 0, 0, callback, obj);
        return 5;
    }

    /* renamed from: U0 */
    public boolean m12941U0(Context context, Handler.Callback callback, Object obj, String str, int i10) throws Throwable {
        C2111d.m12653i("BackupInstallAppImp", "restoreByCloneTarPro start");
        if (!C13694a.m82336n(context, C10713c.m65395e(BackupObject.APP_EXTRA_PARAMETER, "VersionCode", 0), this.f9621d)) {
            sendMsg(9, 0, 0, callback, obj);
            C2111d.m12648d("BackupInstallAppImp", "restoreData MSG_APK_DATA_VERSION_MISMATH fail");
            return false;
        }
        String str2 = str + C10105e.m62942d(this.f9621d, i10);
        C10105e.m62940b(context, str2, this.f9621d);
        File file = new File(str2);
        if (!file.exists() || file.delete()) {
            return true;
        }
        C2111d.m12648d("BackupInstallAppImp", "delete tarfile fail");
        return true;
    }

    /* renamed from: V0 */
    public final boolean m12942V0(Context context, AbstractC0048c abstractC0048c, Handler.Callback callback, Object obj) {
        C2111d.m12653i("BackupInstallAppImp", "restoreByDbPro start");
        C13700g c13700g = new C13700g(context, abstractC0048c, callback, this.backupFileModuleInfo.getName(), obj);
        this.f9646s = c13700g;
        if (c13700g.m82428p() != 2) {
            m12948b1(abstractC0048c);
            return true;
        }
        C2111d.m12653i("BackupInstallAppImp", "phoneClone restoreByDbPro fail");
        sendMsg(2, 0, 0, callback, obj);
        abstractC0048c.m190h();
        return false;
    }

    /* renamed from: W0 */
    public final int m12943W0(Context context, Handler.Callback callback, Object obj, String str) {
        if (!m12934M0(str) && m12871e0()) {
            C2111d.m12657m("BackupInstallAppImp", "restoreData tar file is not exists: " + this.backupFileModuleInfo.getName());
            return 1;
        }
        if (this.f9622e && m12924C0(context, this.backupFileModuleInfo.getName())) {
            C2111d.m12646b("BackupInstallAppImp", "clean Data Success:" + this.backupFileModuleInfo.getName());
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        C2114g.m12666e(this.backupFileModuleInfo.getName(), jCurrentTimeMillis);
        PMSbackupRestoreUtil pMSbackupRestoreUtil = new PMSbackupRestoreUtil(context);
        pMSbackupRestoreUtil.m12735z(m12871e0());
        pMSbackupRestoreUtil.m12734y(BackupObject.isSplitTarModule(this.f9621d));
        int iM12731v = pMSbackupRestoreUtil.m12731v(this.backupFileModuleInfo.getName(), 0, str, null);
        if (iM12731v == -1) {
            C2111d.m12653i("BackupInstallAppImp", "PMS restore file fail");
            sendMsg(5, 0, 0, callback, obj);
        }
        C2114g.m12664c(this.backupFileModuleInfo.getName(), jCurrentTimeMillis, System.currentTimeMillis());
        return iM12731v;
    }

    /* renamed from: X0 */
    public boolean m12944X0(Context context, Handler.Callback callback, Object obj) {
        C2111d.m12653i("BackupInstallAppImp", "restoreByPmsTarPro start");
        if (C13694a.m82336n(context, C10713c.m65395e(BackupObject.APP_EXTRA_PARAMETER, "VersionCode", 0), this.f9621d)) {
            return true;
        }
        sendMsg(9, 0, 0, callback, obj);
        C2111d.m12648d("BackupInstallAppImp", "restoreData MSG_APK_DATA_VERSION_MISMATH fail");
        return false;
    }

    /* renamed from: Y0 */
    public final void m12945Y0(Context context, AbstractC0048c abstractC0048c, Handler.Callback callback, Object obj) throws IllegalAccessException, InterruptedException, NoSuchMethodException, IOException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (AbstractC2124a.m12750b() != 1) {
            sendMsg(5, 0, 0, callback, obj);
            return;
        }
        C13697d c13697d = new C13697d(context, abstractC0048c, callback, this.backupFileModuleInfo.getName(), obj);
        this.f9645r = c13697d;
        c13697d.m82379M();
    }

    /* renamed from: Z0 */
    public void m12946Z0(Context context, AbstractC0048c abstractC0048c, Handler.Callback callback, Object obj) {
        C2111d.m12653i("BackupInstallAppImp", "restoreExternalData");
        new C2145c().onRestore(context, abstractC0048c, callback, obj, this.f9621d);
    }

    /* renamed from: a1 */
    public final boolean m12947a1(Context context, AbstractC0048c abstractC0048c, String str) {
        C2111d.m12653i("BackupInstallAppImp", "restoreObbFiles " + str);
        String strM12930I0 = m12930I0(abstractC0048c);
        ArrayList<String> arrayListM79985r = C13334c.m79985r(strM12930I0);
        if (arrayListM79985r.size() == 0) {
            C2111d.m12653i("BackupInstallAppImp", "no obb files");
            return true;
        }
        List<String> listM79983p = C13334c.m79983p(C13345n.m80062a(context, str), str);
        String strM80072k = C13345n.m80072k(context, 2);
        int size = arrayListM79985r.size();
        for (int i10 = 0; i10 < size; i10++) {
            String str2 = arrayListM79985r.get(i10);
            String str3 = strM80072k + str2.substring(strM12930I0.length());
            listM79983p.remove(str3);
            File file = new File(str2);
            File file2 = new File(str3);
            if ((!file2.exists() || file2.length() != file.length()) && !C13332a.m79948b(file, file2)) {
                return false;
            }
        }
        for (String str4 : listM79983p) {
            C2111d.m12653i("BackupInstallAppImp", "delete old version obb file " + str4 + ", isSuccess " + C13334c.m79980m(str4));
        }
        return true;
    }

    /* renamed from: b1 */
    public void m12948b1(AbstractC0048c abstractC0048c) {
        if (abstractC0048c == null || abstractC0048c.m196n() == null) {
            C2111d.m12648d("BackupInstallAppImp", "setRecordTotal : storeHandler or getFullFileName is null");
            return;
        }
        File file = new File(abstractC0048c.m196n());
        if (!file.exists() || file.length() <= 0) {
            return;
        }
        this.backupFileModuleInfo.setRecordTotal(2);
    }

    /* renamed from: c1 */
    public void m12949c1(String str) throws InterruptedException {
        if ("com.tencent.mm".equals(str)) {
            try {
                Thread.sleep(20000L);
            } catch (InterruptedException e10) {
                C2111d.m12648d("BackupInstallAppImp", "waitWechatStarService error = " + e10.getMessage());
            }
        }
    }

    @Override // com.huawei.android.backup.service.logic.BackupObject
    public String createCloneSecurityInfo(String str) {
        return C2144b.m12901a(str, this.f9620c);
    }

    @Override // com.huawei.android.backup.service.logic.installedapps.BackupInstallApp
    /* renamed from: j0 */
    public int mo12876j0(Context context, AbstractC0048c abstractC0048c, Handler.Callback callback, Object obj) {
        Set<String> setM13200h = C2157a.m13200h();
        sendMsg(16, 0, 0, callback, obj);
        String name = this.backupFileModuleInfo.getName();
        if (C2157a.m13180O(name, setM13200h)) {
            m12932K0(context, name, callback, obj);
            return 5;
        }
        if (m12935N0(name, callback, obj)) {
            return 5;
        }
        if (abstractC0048c == null) {
            C2111d.m12648d("BackupInstallAppImp", "restoreApk : storeHandler is null");
            return 5;
        }
        String strM12929H0 = m12929H0(abstractC0048c);
        if (strM12929H0.length() < 3) {
            C2111d.m12648d("BackupInstallAppImp", "dbFullName.length is unenough");
            return 5;
        }
        ArrayList<String> arrayListM12931J0 = m12931J0(strM12929H0.substring(0, strM12929H0.length() - 3));
        if (arrayListM12931J0.size() == 0) {
            String strM12650f = C2111d.m12650f("BackupInstallAppImp", "restoreApk", "apk isn't exist", this.backupFileModuleInfo.getName(), m12845E(context, this.backupFileModuleInfo.getName()));
            sendMsg(100, strM12650f, callback, obj);
            C2111d.m12653i("BackupInstallAppImp", strM12650f);
            return 4;
        }
        if (!C2144b.m12904d(abstractC0048c, arrayListM12931J0)) {
            C2111d.m12648d("BackupInstallAppImp", "valid apk fail, apk file is broken");
            return 5;
        }
        C2111d.m12654j("BackupInstallAppImp", "apk valid pass, install app [", name, "] start.");
        if (m12933L0(context, callback, obj, arrayListM12931J0) == 4) {
            return 4;
        }
        C2111d.m12654j("BackupInstallAppImp", "install app [", name, "] faild.");
        return 5;
    }

    @Override // com.huawei.android.backup.service.logic.installedapps.BackupInstallApp
    /* renamed from: k0 */
    public void mo12877k0(Context context, AbstractC0048c abstractC0048c, Handler.Callback callback, Object obj) throws IllegalAccessException, InterruptedException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (abstractC0048c == null || abstractC0048c.m196n() == null) {
            C2111d.m12648d("BackupInstallAppImp", "restoreData : storeHandler or getFullFileName is null");
            return;
        }
        File file = new File(abstractC0048c.m196n());
        if (!m12864X(context) || (m12870d0() && !C13334c.m79970c(file))) {
            sendMsg(5, 0, 0, callback, obj);
            return;
        }
        m12949c1(this.backupFileModuleInfo.getName());
        m12841A(context, this.backupFileModuleInfo.getName());
        String strM80070i = C13345n.m80070i(context);
        int iM12943W0 = 1;
        try {
            try {
            } catch (IllegalArgumentException unused) {
                C2111d.m12653i("BackupInstallAppImp", "PMS IllegalArgumentException");
            } catch (Exception unused2) {
                C2111d.m12653i("BackupInstallAppImp", "PMS Exception");
            }
            if (!PmsCheckUtil.m12611e()) {
                m12945Y0(context, abstractC0048c, callback, obj);
                return;
            }
            C2111d.m12653i("BackupInstallAppImp", "restore PMS begin:" + this.backupFileModuleInfo.getName());
            PMSbackupRestoreUtil.m12715i(this.backupFileModuleInfo.getName(), context);
            if (m12871e0()) {
                strM80070i = file.getParent() + File.separator + this.f9621d;
                if (!m12944X0(context, callback, obj)) {
                    return;
                }
            } else if (m12869c0()) {
                if (!m12941U0(context, callback, obj, file.getParent(), 0)) {
                    return;
                }
            } else if (!m12942V0(context, abstractC0048c, callback, obj)) {
                return;
            }
            iM12943W0 = m12943W0(context, callback, obj, strM80070i);
            if (iM12943W0 == -1) {
                C2111d.m12653i("BackupInstallAppImp", "PMS restore file fail");
            } else {
                m12946Z0(context, abstractC0048c, callback, obj);
            }
        } finally {
            m12926E0(context, 1, strM80070i);
        }
    }

    @Override // com.huawei.android.backup.service.logic.installedapps.BackupInstallApp
    /* renamed from: m */
    public int mo12880m(Context context, AbstractC0048c abstractC0048c, Handler.Callback callback, Object obj) {
        C2111d.m12653i("BackupInstallAppImp", "Backup apk.");
        int i10 = 0;
        int iM65395e = C10713c.m65395e(BackupObject.getExecuteParameter(), CloneService.KEY_ACTION_FLAG, 0);
        sendMsg(15, 0, 0, callback, obj);
        if (iM65395e == 3 || iM65395e == 6) {
            File fileM12844D = m12844D(context);
            if (fileM12844D == null) {
                C2111d.m12657m("BackupInstallAppImp", "backupApk getApkSourceFile fail");
                sendMsg(2, 0, 0, callback, obj);
                return 2;
            }
            String path = fileM12844D.getPath();
            this.f9620c = path;
            this.backupFliedList.add(path);
            m12883o(context, true);
            m12922A0(context, this.f9621d);
            i10 = 14;
        }
        int i11 = i10;
        C2144b.m12903c(this.f9621d, this.backupFliedList, abstractC0048c);
        sendMsg(i11, 0, 0, callback, obj);
        m12948b1(abstractC0048c);
        return 1;
    }

    /* renamed from: m0 */
    public void m12950m0() throws InterruptedException {
        while (!this.f9643p && !BackupObject.isAbort()) {
            try {
                Thread.sleep(100L);
            } catch (InterruptedException unused) {
                C2111d.m12648d("BackupInstallAppImp", "clear data Sleep Failed");
                return;
            }
        }
    }

    @Override // com.huawei.android.backup.service.logic.BackupObject
    public int openAndRestore(Context context, AbstractC0048c abstractC0048c, Handler.Callback callback, Object obj, String str) throws IllegalAccessException, InterruptedException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        int iM12843C = m12843C(abstractC0048c);
        this.f9621d = str;
        C2111d.m12653i("BackupInstallAppImp", "restore!moduleName:" + str + ", actionType:" + iM12843C);
        int iM12923B0 = m12923B0(iM12843C);
        m12841A(context, this.backupFileModuleInfo.getName());
        m12938R0(context, str);
        if (m12864X(context)) {
            this.f9622e = true;
        }
        String strM196n = abstractC0048c.m196n();
        if (iM12923B0 == 1) {
            m12940T0(context, abstractC0048c, callback, obj, str);
        } else if (iM12923B0 != 2) {
            if (iM12923B0 == 3) {
                m12939S0(context, abstractC0048c, callback, obj, str);
            }
        } else if (!m12864X(context)) {
            sendMsg(5, 0, 0, callback, obj);
        } else if (m12870d0() && m12859S(strM196n)) {
            sendMsg(3, 0, 0, callback, obj);
        } else {
            m12928G0(context, abstractC0048c, callback, strM196n);
            mo12877k0(context, abstractC0048c, callback, obj);
        }
        m12936P0(context, iM12923B0, str);
        return 4;
    }

    @Override // com.huawei.android.backup.service.logic.installedapps.BackupInstallApp
    /* renamed from: p */
    public void mo12884p(Context context, AbstractC0048c abstractC0048c, Handler.Callback callback, Object obj) throws InterruptedException {
        int iM12750b = AbstractC2124a.m12750b();
        try {
            if (!PmsCheckUtil.m12611e()) {
                m12955y0(context, abstractC0048c, callback, obj, iM12750b);
                return;
            }
            String name = this.backupFileModuleInfo.getName();
            m12841A(context, name);
            if (BackupObject.isSplitTarModule(name)) {
                C2111d.m12654j("BackupInstallAppImp", "[SplitTar], backupData use split tar mode, get tar later ", name);
                return;
            }
            C2111d.m12654j("BackupInstallAppImp", "backup PMS begin:", this.backupFileModuleInfo.getName());
            long jCurrentTimeMillis = System.currentTimeMillis();
            C2114g.m12666e(this.backupFileModuleInfo.getName(), jCurrentTimeMillis);
            PMSbackupRestoreUtil pMSbackupRestoreUtil = new PMSbackupRestoreUtil(context);
            pMSbackupRestoreUtil.m12735z(m12871e0());
            C10715e.m65405b(C2132e.m12804K());
            C2111d.m12653i("BackupInstallAppImp", "setPMSAppDataWeight finish , weight: " + C2132e.m12804K());
            if (pMSbackupRestoreUtil.m12729t(this.backupFileModuleInfo.getName(), 0, callback, obj) == -1) {
                C2111d.m12653i("BackupInstallAppImp", "PMS backup file fail");
                sendMsg(2, 0, 0, callback, obj);
                return;
            }
            if (m12871e0()) {
                File file = new File(C13345n.m80070i(context) + this.f9621d + File.separator + this.f9621d + ".tar");
                if (file.exists()) {
                    C2114g.m12665d(this.f9621d, jCurrentTimeMillis, System.currentTimeMillis(), file.length());
                }
                mo12954x0(context);
            } else if (m12869c0()) {
                m12952v0(context, callback, obj);
            } else {
                m12953w0(context, abstractC0048c, callback, obj);
            }
            m12921z0(context, abstractC0048c, callback, obj);
        } catch (IllegalArgumentException unused) {
            C2111d.m12653i("BackupInstallAppImp", "PMS IllegalArgumentException");
        } catch (Exception unused2) {
            C2111d.m12653i("BackupInstallAppImp", "PMS Exception");
        }
    }

    @Override // com.huawei.android.backup.service.logic.installedapps.BackupInstallApp
    /* renamed from: q */
    public int mo12885q(Context context, AbstractC0048c abstractC0048c, Handler.Callback callback, Object obj) {
        C2111d.m12653i("BackupInstallAppImp", "Backup hap.");
        int i10 = 0;
        int iM65395e = C10713c.m65395e(BackupObject.getExecuteParameter(), CloneService.KEY_ACTION_FLAG, 0);
        sendMsg(15, 0, 0, callback, obj);
        if (iM65395e == 3 || iM65395e == 6) {
            File fileM12848H = m12848H(context);
            if (fileM12848H == null) {
                C2111d.m12657m("BackupInstallAppImp", "backupApk getApkSourceFile fail");
                sendMsg(2, 0, 0, callback, obj);
                return 2;
            }
            this.f9620c = fileM12848H.getPath();
            m12886r(context, true);
            m12922A0(context, this.f9621d);
            i10 = 14;
        }
        int i11 = i10;
        C2144b.m12903c(this.f9621d, this.backupFliedList, abstractC0048c);
        sendMsg(i11, 0, 0, callback, obj);
        m12948b1(abstractC0048c);
        return 1;
    }

    /* renamed from: u0 */
    public void m12951u0(Context context, int i10, Handler.Callback callback, Object obj) throws PackageManager.NameNotFoundException {
        C2111d.m12653i("BackupInstallAppImp", "backupByCloneTar start");
        if (!C10105e.m62939a(context, C13345n.m80070i(context), this.f9621d, i10)) {
            C2111d.m12648d("BackupInstallAppImp", "app data file archive fail");
            sendMsg(2, 0, 0, callback, obj);
        }
        String strM62943e = C10105e.m62943e(context, this.f9621d, i10);
        if (TextUtils.isEmpty(strM62943e)) {
            C2111d.m12648d("BackupInstallAppImp", "tarFilePath is null");
        } else {
            this.backupFliedList.add(strM62943e);
        }
        PMSbackupRestoreUtil.m12715i(this.f9621d, context);
        int iM82329g = C13694a.m82329g(context, this.f9621d);
        Bundle bundle = this.backupFilesBundle;
        if (bundle != null) {
            bundle.putInt("VersionCode", iM82329g);
        }
    }

    /* renamed from: v0 */
    public final void m12952v0(Context context, Handler.Callback callback, Object obj) throws PackageManager.NameNotFoundException {
        m12951u0(context, 0, callback, obj);
    }

    @Override // com.huawei.android.backup.service.logic.BackupObject
    public boolean validateCloneSecurityInfo(String str, String str2) {
        return C2144b.m12905e(str, str2, this.backupFileModuleInfo.getName());
    }

    @Override // com.huawei.android.backup.service.logic.BackupObject
    public boolean validateSecurityV3Info(Context context, String str) {
        BackupFileModuleInfo backupFileModuleInfo;
        return (str == null || (backupFileModuleInfo = this.backupFileModuleInfo) == null || backupFileModuleInfo.getCheckMsgV3() == null || context == null) ? false : true;
    }

    /* renamed from: w0 */
    public final void m12953w0(Context context, AbstractC0048c abstractC0048c, Handler.Callback callback, Object obj) {
        C2111d.m12653i("BackupInstallAppImp", "backupByDbType start");
        C13700g c13700g = new C13700g(context, abstractC0048c, callback, this.backupFileModuleInfo.getName(), obj);
        this.f9646s = c13700g;
        int iM82416d = c13700g.m82416d();
        PMSbackupRestoreUtil.m12715i(this.f9621d, context);
        if (iM82416d != 2) {
            m12948b1(abstractC0048c);
            return;
        }
        C2111d.m12653i("BackupInstallAppImp", "phoneClone backupByDbType backup fail");
        sendMsg(2, 0, 0, callback, obj);
        abstractC0048c.m190h();
    }

    /* renamed from: x0 */
    public void mo12954x0(Context context) throws PackageManager.NameNotFoundException {
        C2111d.m12653i("BackupInstallAppImp", "backupByPmsTar start");
        this.backupFliedList.addAll(C13334c.m79985r(C13345n.m80070i(context) + this.f9621d));
        int iM82329g = C13694a.m82329g(context, this.f9621d);
        Bundle bundle = this.backupFilesBundle;
        if (bundle != null) {
            bundle.putInt("VersionCode", iM82329g);
        }
    }

    /* renamed from: y0 */
    public final void m12955y0(Context context, AbstractC0048c abstractC0048c, Handler.Callback callback, Object obj, int i10) {
        if (i10 != 1) {
            this.backupFileModuleInfo.resetRecordTotal();
            abstractC0048c.m190h();
            sendMsg(2, 0, 0, callback, obj);
            return;
        }
        m12841A(context, this.backupFileModuleInfo.getName());
        C13697d c13697d = new C13697d(context, abstractC0048c, callback, this.backupFileModuleInfo.getName(), obj);
        this.f9645r = c13697d;
        if (c13697d.m82347d(null) != 2) {
            m12948b1(abstractC0048c);
        } else {
            this.backupFileModuleInfo.resetRecordTotal();
            abstractC0048c.m190h();
        }
    }
}
