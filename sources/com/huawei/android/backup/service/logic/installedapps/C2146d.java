package com.huawei.android.backup.service.logic.installedapps;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.util.Base64;
import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.android.backup.service.logic.AbstractC2124a;
import com.huawei.android.backup.service.logic.BackupObject;
import com.huawei.android.backup.service.logic.C2152k;
import com.huawei.android.backup.service.utils.C2157a;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
import p006a5.AbstractC0048c;
import p386j6.C10713c;
import p699v4.C13334c;
import p699v4.C13348q;
import p762x4.C13694a;
import p762x4.C13698e;

/* renamed from: com.huawei.android.backup.service.logic.installedapps.d */
/* loaded from: classes.dex */
public class C2146d extends BackupInstallApp {

    /* renamed from: p */
    public static final String f9636p = C2157a.m13216x() + "/HwCloud/.CloudApkInstall";

    @Override // com.huawei.android.backup.service.logic.installedapps.BackupInstallApp
    /* renamed from: j0 */
    public int mo12876j0(Context context, AbstractC0048c abstractC0048c, Handler.Callback callback, Object obj) {
        Set<String> setM13200h = C2157a.m13200h();
        sendMsg(16, 0, 0, callback, obj);
        String name = this.backupFileModuleInfo.getName();
        m12909p0(setM13200h, name);
        if (C2157a.m13180O(name, setM13200h)) {
            C2111d.m12654j("BackupInstallAppCloudImp", "restoreApk isPackageInBlockList packageName = ", name);
            sendMsg(7, 0, 0, callback, obj);
            return 5;
        }
        String path = Environment.getExternalStorageDirectory().getPath();
        StringBuilder sb2 = new StringBuilder(path);
        String str = File.separator;
        sb2.append(str);
        sb2.append(".CloudApkInstall");
        String string = sb2.toString();
        String str2 = path + str + f9636p;
        File file = new File(string, this.backupFileModuleInfo.getName() + ".apk");
        File file2 = new File(str2, this.backupFileModuleInfo.getName() + ".apk");
        if (new File(str2 + str + this.backupFileModuleInfo.getName() + str + "apk").exists()) {
            return m12910q0(context, callback, obj, str2);
        }
        String str3 = abstractC0048c.m198p() + str + "hap";
        if (new File(str3).exists()) {
            if (C2157a.m13176K()) {
                return m12911r0(context, callback, obj, str3);
            }
            C2111d.m12654j("BackupInstallAppCloudImp", "restoreHap is not HarmonyOS packageName = ", name);
            sendMsg(7, 0, 0, callback, obj);
            return 5;
        }
        if (C13334c.m79970c(file2)) {
            return m12855O(context, file2.getPath(), callback, obj);
        }
        if (C13334c.m79970c(file)) {
            return m12855O(context, file.getPath(), callback, obj);
        }
        C2111d.m12653i("BackupInstallAppCloudImp", "no apk file, so return done");
        return 4;
    }

    @Override // com.huawei.android.backup.service.logic.installedapps.BackupInstallApp
    /* renamed from: k0 */
    public void mo12877k0(Context context, AbstractC0048c abstractC0048c, Handler.Callback callback, Object obj) throws IllegalAccessException, InterruptedException, NoSuchMethodException, IOException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (abstractC0048c == null || abstractC0048c.m196n() == null) {
            C2111d.m12648d("BackupInstallAppCloudImp", "restoreData : storeHandler or getFullFileName is null");
            sendMsg(5, 0, 0, callback, obj);
            return;
        }
        File file = new File(new File(abstractC0048c.m196n()).getParent(), this.backupFileModuleInfo.getName() + ".tar");
        if (m12864X(context) && C13334c.m79970c(file)) {
            if (AbstractC2124a.m12750b() == 1) {
                new C13698e(context, abstractC0048c, callback, this.backupFileModuleInfo.getName(), obj).m82407S();
                return;
            } else {
                sendMsg(5, 0, 0, callback, obj);
                return;
            }
        }
        C2111d.m12648d("BackupInstallAppCloudImp", "isPackageInstalled(context):" + m12864X(context) + "FileHelper.checkFile(tarFile):" + C13334c.m79970c(file));
        sendMsg(5, 0, 0, callback, obj);
    }

    @Override // com.huawei.android.backup.service.logic.installedapps.BackupInstallApp
    /* renamed from: m */
    public int mo12880m(Context context, AbstractC0048c abstractC0048c, Handler.Callback callback, Object obj) throws JSONException, UnsupportedEncodingException {
        sendMsg(15, 0, 0, callback, obj);
        if (abstractC0048c == null) {
            C2111d.m12648d("BackupInstallAppCloudImp", "backupApk : storeHandler is null");
            return 2;
        }
        C2111d.m12653i("BackupInstallAppCloudImp", "backupFileModuleInfo.getName():" + this.backupFileModuleInfo.getName() + ",storeHandler.getFullFileName():" + abstractC0048c.m196n() + ",storeHandler.getParent():" + abstractC0048c.m198p());
        String name = this.backupFileModuleInfo.getName();
        File fileM12844D = m12844D(context);
        if (fileM12844D != null) {
            if (!C13694a.m82330h(context, this.backupFileModuleInfo.getName())) {
                int iMo12889u = super.mo12889u(null, context, abstractC0048c.m198p(), callback, obj);
                if (iMo12889u == 17) {
                    return 17;
                }
                sendMsg(iMo12889u, 0, 0, callback, obj);
                return 1;
            }
            String path = fileM12844D.getPath();
            this.f9620c = path;
            this.backupFliedList.add(path);
            m12883o(context, false);
        }
        m12912s0(context, name);
        int iMo12889u2 = mo12889u(abstractC0048c.m198p(), context, abstractC0048c.m198p() + File.separator + "apk", callback, obj);
        if (iMo12889u2 == 17) {
            return 17;
        }
        sendMsg(iMo12889u2, 0, 0, callback, obj);
        return 1;
    }

    /* renamed from: o0 */
    public final long m12908o0(String str) {
        Iterator<String> it = this.backupFliedList.iterator();
        long length = 0;
        while (it.hasNext()) {
            String next = it.next();
            length += new File(str, next.substring(next.lastIndexOf(File.separator) + 1)).length();
        }
        return length;
    }

    @Override // com.huawei.android.backup.service.logic.installedapps.BackupInstallApp, com.huawei.android.backup.service.logic.BackupObject
    public Bundle onBackupModulesDataItemTotal(Context context, Long l10, int i10, String str) {
        C2111d.m12653i("BackupInstallAppCloudImp", "onBacupModulesDataItemTotal.");
        Bundle bundle = new Bundle();
        if (context == null) {
            C2111d.m12648d("BackupInstallAppCloudImp", "onBacupModulesDataItemTotal : context is null");
            return bundle;
        }
        Set<String> setM13206n = C2157a.m13206n();
        if (C2152k.m12988n().m12992p()) {
            bundle = C2152k.m12988n().m12989l(setM13206n, 0);
        } else {
            List<PackageInfo> installedPackages = context.getPackageManager().getInstalledPackages(64);
            if (installedPackages == null) {
                C2111d.m12653i("BackupInstallAppCloudImp", "installedAppList is null");
                return null;
            }
            ArrayList<String> arrayList = new ArrayList<>(installedPackages.size());
            Set<String> setM13200h = C2157a.m13200h();
            int i11 = 0;
            for (PackageInfo packageInfo : installedPackages) {
                if (C2150h.m12968b(packageInfo, setM13200h, setM13206n, 0, true)) {
                    arrayList.add(packageInfo.packageName);
                    i11++;
                } else {
                    C2111d.m12653i("BackupInstallAppCloudImp", "app [" + packageInfo.packageName + "] doesn't support clone.");
                }
            }
            bundle.putInt("ModuleCount", i11);
            bundle.putLong("ModuleSize", 1L);
            bundle.putStringArrayList("AppPackageList", arrayList);
        }
        bundle.putInt("APPDataFlag", AbstractC2124a.m12751c());
        return bundle;
    }

    @Override // com.huawei.android.backup.service.logic.installedapps.BackupInstallApp
    /* renamed from: p */
    public void mo12884p(Context context, AbstractC0048c abstractC0048c, Handler.Callback callback, Object obj) throws InterruptedException {
        int iM12750b = AbstractC2124a.m12750b();
        Bundle bundleM65393c = C10713c.m65393c(BackupObject.getExecuteParameter(), "app");
        ArrayList<String> arrayListM65401k = bundleM65393c != null ? C10713c.m65401k(bundleM65393c, "bakFilePath") : null;
        if (!C13348q.m80082b(arrayListM65401k) && iM12750b == 1) {
            m12841A(context, this.backupFileModuleInfo.getName());
            if (new C13698e(context, abstractC0048c, callback, this.backupFileModuleInfo.getName(), obj).m82347d(arrayListM65401k) != 2) {
                m12913t0(abstractC0048c);
                return;
            }
            this.backupFileModuleInfo.resetRecordTotal();
            if (abstractC0048c != null) {
                abstractC0048c.m190h();
            }
        }
    }

    /* renamed from: p0 */
    public final void m12909p0(Set<String> set, String str) {
        String str2;
        String tables = this.backupFileModuleInfo.getTables();
        if (tables == null) {
            return;
        }
        try {
            str2 = new String(Base64.decode(tables, 0), Constants.UTF_8);
        } catch (UnsupportedEncodingException unused) {
            C2111d.m12648d("BackupInstallAppCloudImp", "judgeCpuType UnsupportedEncodingException");
            str2 = "";
        }
        try {
            JSONObject jSONObject = new JSONObject(str2);
            if (!jSONObject.has("CPU") || jSONObject.getString("CPU").equals(C2157a.m13204l())) {
                return;
            }
            set.add(str);
        } catch (JSONException unused2) {
            C2111d.m12648d("BackupInstallAppCloudImp", "parseFromJson error");
        }
    }

    @Override // com.huawei.android.backup.service.logic.installedapps.BackupInstallApp
    /* renamed from: q */
    public int mo12885q(Context context, AbstractC0048c abstractC0048c, Handler.Callback callback, Object obj) throws JSONException, UnsupportedEncodingException {
        C2111d.m12653i("BackupInstallAppCloudImp", "Backup hap.");
        sendMsg(15, 0, 0, callback, obj);
        if (abstractC0048c == null) {
            C2111d.m12648d("BackupInstallAppCloudImp", "backupHap : storeHandler is null");
            return 2;
        }
        C2111d.m12654j("BackupInstallAppCloudImp", "backupFileModuleInfo.getName():", this.backupFileModuleInfo.getName(), ",storeHandler.getFullFileName():", abstractC0048c.m196n(), ",storeHandler.getParent():", abstractC0048c.m198p());
        File fileM12848H = m12848H(context);
        if (fileM12848H == null) {
            C2111d.m12657m("BackupInstallAppCloudImp", "backupHap getApkSourceFile fail");
            sendMsg(2, 0, 0, callback, obj);
            return 2;
        }
        this.f9620c = fileM12848H.getPath();
        m12886r(context, false);
        if (this.backupFliedList.size() > 0) {
            this.f9620c = this.backupFliedList.get(0);
        }
        m12912s0(context, this.backupFileModuleInfo.getName());
        int iMo12889u = mo12889u(abstractC0048c.m198p(), context, abstractC0048c.m198p() + File.separator + "hap", callback, obj);
        if (iMo12889u == 17) {
            return 17;
        }
        sendMsg(iMo12889u, 0, 0, callback, obj);
        return 1;
    }

    /* renamed from: q0 */
    public final int m12910q0(Context context, Handler.Callback callback, Object obj, String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        String str2 = File.separator;
        sb2.append(str2);
        sb2.append(this.backupFileModuleInfo.getName());
        sb2.append(str2);
        sb2.append("apk");
        m12878l(sb2.toString(), arrayList);
        if (arrayList.size() == 0) {
            String strM12650f = C2111d.m12650f("BackupInstallAppCloudImp", "restoreApk", "apk isn't exist", this.backupFileModuleInfo.getName(), m12845E(context, this.backupFileModuleInfo.getName()));
            sendMsg(100, strM12650f, callback, obj);
            C2111d.m12653i("BackupInstallAppCloudImp", strM12650f);
            return 4;
        }
        C2111d.m12654j("BackupInstallAppCloudImp", "install app [", this.backupFileModuleInfo.getName(), "] start.");
        if ((arrayList.size() == 1 ? m12855O(context, arrayList.get(0), callback, obj) : m12857Q(context, arrayList, callback, obj)) == 4) {
            return 4;
        }
        C2111d.m12654j("BackupInstallAppCloudImp", "install app [", this.backupFileModuleInfo.getName(), "] faild.");
        return 5;
    }

    /* renamed from: r0 */
    public final int m12911r0(Context context, Handler.Callback callback, Object obj, String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        m12878l(str, arrayList);
        if (arrayList.size() == 0) {
            String strM12650f = C2111d.m12650f("BackupInstallAppCloudImp", "restoreHapApp", "hap isn't exist", this.backupFileModuleInfo.getName(), m12845E(context, this.backupFileModuleInfo.getName()));
            sendMsg(100, strM12650f, callback, obj);
            C2111d.m12653i("BackupInstallAppCloudImp", strM12650f);
            return 4;
        }
        C2111d.m12654j("BackupInstallAppCloudImp", "install hap app [", this.backupFileModuleInfo.getName(), "] start.");
        if ((arrayList.size() == 1 ? m12856P(context, arrayList.get(0), callback, obj) : m12858R(context, arrayList, callback, obj)) == 4) {
            return 4;
        }
        C2111d.m12654j("BackupInstallAppCloudImp", "install app [", this.backupFileModuleInfo.getName(), "] faild.");
        return 5;
    }

    /* renamed from: s0 */
    public final void m12912s0(Context context, String str) throws JSONException, UnsupportedEncodingException {
        String string;
        byte[] bytes;
        if (C13694a.m82330h(context, str)) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("CPU", C2157a.m13204l());
                jSONObject.put("LANGUAGE", C2157a.m13205m());
                jSONObject.put("DISPLAY_METRICS", C2157a.m13210r(context));
                string = jSONObject.toString();
            } catch (JSONException unused) {
                C2111d.m12648d("BackupInstallAppCloudImp", "set bundle app json info fail!");
                string = "";
            }
            if ("".equals(string)) {
                C2111d.m12648d("BackupInstallAppCloudImp", "json string is empty!");
                return;
            }
            try {
                bytes = string.getBytes(Constants.UTF_8);
            } catch (UnsupportedEncodingException unused2) {
                C2111d.m12648d("BackupInstallAppCloudImp", "encryptFile UnsupportedEncodingException");
                bytes = null;
            }
            if (bytes == null) {
                C2111d.m12648d("BackupInstallAppCloudImp", "json string getBytes has exception!");
            } else {
                this.backupFileModuleInfo.setTables(Base64.encodeToString(bytes, 0));
            }
        }
    }

    /* renamed from: t0 */
    public void m12913t0(AbstractC0048c abstractC0048c) {
    }

    @Override // com.huawei.android.backup.service.logic.installedapps.BackupInstallApp
    /* renamed from: u */
    public int mo12889u(String str, Context context, String str2, Handler.Callback callback, Object obj) {
        if (str2 == null) {
            sendMsg(100, C2111d.m12650f("BackupInstallAppCloudImp", "copyFile", "destDir is null ", this.backupFileModuleInfo.getName(), m12845E(context, this.backupFileModuleInfo.getName())), callback, obj);
            return 11;
        }
        if (this.backupFliedList.size() == 0) {
            sendMsg(100, C2111d.m12650f("BackupInstallAppCloudImp", "copyFile", "apkFile is null " + this.f9623f, this.backupFileModuleInfo.getName(), m12845E(context, this.backupFileModuleInfo.getName())), callback, obj);
            return 2;
        }
        if (!C13334c.m79968a(str, m12908o0(str2))) {
            sendMsg(17, C13334c.m79993z(str), 0, callback, obj);
            sendMsg(100, C2111d.m12650f("BackupInstallAppCloudImp", "copyFile", "not enough storage errorCode = 17", this.backupFileModuleInfo.getName(), m12845E(context, this.backupFileModuleInfo.getName())), callback, obj);
            BackupObject.setAbort();
            return 17;
        }
        Iterator<String> it = this.backupFliedList.iterator();
        int iM12890v = 14;
        while (it.hasNext()) {
            String next = it.next();
            iM12890v = m12890v(new File(str2, next.substring(next.lastIndexOf(File.separator) + 1)), new File(next), callback, obj, context);
            if (iM12890v == 11) {
                break;
            }
        }
        return iM12890v;
    }

    @Override // com.huawei.android.backup.service.logic.BackupObject
    public boolean validateSecurityV3Info(Context context, String str) {
        return true;
    }
}
