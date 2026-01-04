package p262em;

import am.InterfaceC0278j1;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.content.p019pm.PackageInfoCompat;
import com.google.gson.reflect.TypeToken;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.cloudbackup.process.CloneService;
import com.huawei.android.hicloud.cloudbackup.process.util.CloudBackupAppDataUtil;
import com.huawei.android.hicloud.cloudbackup.process.util.SplitAppUtil;
import com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.SnapshotDBManager;
import com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.bean.SnapshotBackupMeta;
import com.huawei.android.hicloud.cloudbackup.util.CloudBackupLanguageUtil;
import com.huawei.hicloud.cloudbackup.p104v3.core.C4879a;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.App;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.Attachment;
import com.huawei.hicloud.cloudbackup.store.database.status.CloudBackupStatus;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import dm.C9195d0;
import dm.C9203f0;
import fk.C9721b;
import gm.C9989d;
import hm.C10321z;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0240y;
import p015ak.C0241z;
import p514o9.C11839m;
import p617rl.C12519c;
import p618rm.C12583q;
import p618rm.C12590s0;
import p709vj.C13452e;
import pl.C12164f;
import pm.C12182i;
import sl.C12810a;
import sl.C12812c;
import sl.C12815f;
import tl.C13029h;

/* renamed from: em.z */
/* loaded from: classes6.dex */
public abstract class AbstractC9526z {

    /* renamed from: a */
    public C4879a f47342a;

    /* renamed from: b */
    public C9989d f47343b;

    /* renamed from: c */
    public C13029h f47344c;

    /* renamed from: d */
    public final String f47345d;

    /* renamed from: e */
    public final String f47346e;

    /* renamed from: f */
    public final String f47347f;

    /* renamed from: g */
    public final C12815f f47348g;

    /* renamed from: h */
    public boolean f47349h;

    /* renamed from: i */
    public long f47350i;

    /* renamed from: j */
    public C9721b f47351j;

    /* renamed from: k */
    public boolean f47352k = false;

    /* renamed from: l */
    public String f47353l;

    /* renamed from: m */
    public C10321z f47354m;

    /* renamed from: em.z$b */
    public static class b extends TypeToken<Map<String, String>> {
        public b() {
        }
    }

    public AbstractC9526z(C4879a c4879a, C9989d c9989d) {
        this.f47342a = c4879a;
        this.f47343b = c9989d;
        this.f47344c = c9989d.m61882A();
        this.f47353l = c4879a.m29654O0();
        this.f47345d = c4879a.m29734p0();
        this.f47346e = c4879a.m29719k0();
        String strM29713i0 = c4879a.m29713i0();
        this.f47347f = strM29713i0;
        this.f47348g = new C12815f(strM29713i0);
        this.f47349h = c9989d.m61911c0();
        this.f47350i = c9989d.m61884B();
        this.f47354m = new C10321z(strM29713i0, c4879a.m29636F0(), c4879a.m29587j(), CloudBackupConstant.Command.PMS_CMD_BACKUP, this.f47353l);
    }

    /* renamed from: a */
    public Map<String, String> m59504a(CloudBackupStatus cloudBackupStatus, boolean z10) throws C9721b, PackageManager.NameNotFoundException {
        String strM29870d = cloudBackupStatus.m29870d();
        String strMo29421n = cloudBackupStatus.mo29421n();
        HashMap map = new HashMap();
        map.put(SnapshotBackupMeta.KEY_STRING_APP_EXTEND, String.valueOf(C12590s0.m75778O(cloudBackupStatus)));
        map.put("isvirtualapp", String.valueOf(cloudBackupStatus.m29867U()));
        map.put("appwithdata", String.valueOf(cloudBackupStatus.m29351H0()));
        map.put(SnapshotBackupMeta.KEY_STRING_APP_VERSION, String.valueOf(cloudBackupStatus.m29349G0()));
        map.put(SnapshotBackupMeta.KEY_STRING_APP_NAME, String.valueOf(cloudBackupStatus.m29871e()));
        map.put("splitappuid", String.valueOf(cloudBackupStatus.m29861N()));
        map.put(FaqConstants.FAQ_EMUIVERSION, C0209d.m1186L());
        map.put("androidLevel", String.valueOf(Build.VERSION.SDK_INT));
        map.put("backupApkVersion", cloudBackupStatus.m29863P() ? C0240y.m1680b(m59509h(), strMo29421n) : C12590s0.m75790R(strMo29421n));
        map.put("emuiVersionFull", C0209d.m1149A0());
        map.put("osBrand", C0209d.m1244d0());
        map.put("modulestatus", String.valueOf(!z10 ? 1 : 0));
        if (cloudBackupStatus.m29863P()) {
            map.put("lastBackupDataEnable", cloudBackupStatus.m29362M0());
        }
        map.put("isFileDiff", String.valueOf(cloudBackupStatus.m29393b1().contains("isDiff")));
        if (cloudBackupStatus.m29393b1().contains("isCitOpt")) {
            map.put("isCitOpt", Boolean.TRUE.toString());
        }
        m59515n(map, cloudBackupStatus);
        C12812c c12812c = new C12812c();
        int iM29861N = cloudBackupStatus.m29861N();
        C12810a c12810aM76886e = c12812c.m76886e(strM29870d, SnapshotDBManager.PREFIX_DATABASE_NAME, iM29861N);
        if (c12810aM76886e != null && c12810aM76886e.m76862m() == 2 && c12810aM76886e.m76858i() == 1) {
            map.put("hashSha256", c12810aM76886e.m76853d());
        }
        if ("safebox".equalsIgnoreCase(cloudBackupStatus.m29870d()) || "safebox1".equalsIgnoreCase(cloudBackupStatus.m29870d())) {
            String strM29375S0 = cloudBackupStatus.m29375S0();
            if (!TextUtils.isEmpty(strM29375S0)) {
                map.put("safeboxdataintegrity", strM29375S0);
            }
        }
        if ("Memo".equalsIgnoreCase(cloudBackupStatus.m29870d())) {
            String strM29375S02 = cloudBackupStatus.m29375S0();
            if (!TextUtils.isEmpty(strM29375S02)) {
                map.put("memoCloneFlag", strM29375S02);
            }
        }
        if (cloudBackupStatus.m29867U()) {
            String strM75305p = new C12519c().m75305p(cloudBackupStatus.m29870d());
            C11839m.m70688i("CloudBackupV3ModuleAbstractOperate", "showType:   " + strM75305p + " appID   " + cloudBackupStatus.m29870d());
            if (C0241z.m1686d(strM75305p, -1) >= 0) {
                map.put(SnapshotBackupMeta.KEY_SHOW_TYPE, strM75305p);
            }
        }
        String strM59510i = m59510i(cloudBackupStatus);
        if (!TextUtils.isEmpty(strM59510i)) {
            map.put("signatures", strM59510i);
        }
        if (cloudBackupStatus.m29863P()) {
            C12810a c12810aM76886e2 = c12812c.m76886e(strM29870d, "apk", iM29861N);
            C12810a c12810aM76886e3 = c12812c.m76886e(strM29870d, "icon", iM29861N);
            if (c12810aM76886e2 == null) {
                new C9195d0(this.f47342a, cloudBackupStatus).m57757s("module_reset_from_module_apkattachment_is_null");
                throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "apkAttachment is null, appId: " + strM29870d, "create apk records");
            }
            map.put("apksize", String.valueOf(c12810aM76886e2.m76861l()));
            if (1 == cloudBackupStatus.m29351H0()) {
                map.put("appdatasize", String.valueOf(m59508g(strM29870d, cloudBackupStatus.m29861N())));
            }
            if (c12810aM76886e2.m76862m() == 2 && c12810aM76886e2.m76858i() == 0) {
                String strM29347F0 = cloudBackupStatus.m29347F0();
                if (TextUtils.isEmpty(strM29347F0)) {
                    c12810aM76886e2.m76846C(0);
                    c12810aM76886e2.m76874y(1);
                    c12812c.m76888g(c12810aM76886e2);
                } else {
                    map.put("apkServerPath", strM29347F0);
                    C11839m.m70688i("CloudBackupV3ModuleAbstractOperate", "appId  = " + strM29870d + ", apk ServerPath = " + strM29347F0);
                }
            }
            if (c12810aM76886e3 != null) {
                map.put("iconsize", String.valueOf(c12810aM76886e3.m76861l()));
                if (c12810aM76886e3.m76862m() == 2 && c12810aM76886e3.m76858i() == 0) {
                    String strM29387Y0 = cloudBackupStatus.m29387Y0();
                    if (TextUtils.isEmpty(strM29387Y0)) {
                        c12810aM76886e3.m76846C(0);
                        c12810aM76886e3.m76874y(1);
                        c12812c.m76888g(c12810aM76886e3);
                    } else {
                        map.put("iconServerPath", strM29387Y0);
                        C11839m.m70688i("CloudBackupV3ModuleAbstractOperate", "appId  = " + strM29870d + ", icon ServerPath = " + strM29387Y0);
                    }
                }
            }
            if (this.f47342a.m29705f1() && c12810aM76886e2.m76858i() != 0) {
                map.put("apkServerPath", "");
            }
            m59517q(cloudBackupStatus, map);
        }
        int i10 = cloudBackupStatus.mo29370Q() ? 256 : 0;
        if (m59512k(strM29870d, cloudBackupStatus.m29861N(), "sparse")) {
            i10 |= 128;
        }
        if (i10 != 0) {
            map.put("backupFeatures", String.valueOf(i10));
        }
        return map;
    }

    /* renamed from: b */
    public CloudBackupAppDataUtil m59505b(CloudBackupStatus cloudBackupStatus) throws C9721b, PackageManager.NameNotFoundException {
        String strM29870d = cloudBackupStatus.m29870d();
        String strMo29421n = cloudBackupStatus.mo29421n();
        cloudBackupStatus.mo29316a0(strM29870d);
        if (cloudBackupStatus.m29863P()) {
            PackageManager packageManager = m59509h().getPackageManager();
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(strMo29421n, 16384);
                if (packageInfo.applicationInfo != null) {
                    long longVersionCode = PackageInfoCompat.getLongVersionCode(packageInfo);
                    C11839m.m70688i("CloudBackupV3ModuleAbstractOperate", "versionCode: " + longVersionCode + " appId: " + strM29870d);
                    String str = packageInfo.versionName;
                    ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                    cloudBackupStatus.m29439t2(String.valueOf(longVersionCode));
                    cloudBackupStatus.m29447w1(str);
                    cloudBackupStatus.mo29316a0(SplitAppUtil.getSplitAppName(packageManager.getApplicationLabel(applicationInfo).toString(), cloudBackupStatus.mo29357K()));
                    CloudBackupAppDataUtil cloudBackupAppDataUtil = new CloudBackupAppDataUtil(strMo29421n, this.f47342a.getLocation(), longVersionCode, this.f47342a.isRefurbishment(), this.f47342a.mo29591n());
                    if (cloudBackupStatus.mo29370Q()) {
                        cloudBackupAppDataUtil.changeToSeparaSetting(cloudBackupStatus.m29861N());
                    }
                    int i10 = (this.f47342a.isSupportPMS() && cloudBackupAppDataUtil.isAppDataAble()) ? 1 : 0;
                    if (cloudBackupStatus.m29859L() < 3) {
                        cloudBackupStatus.m29453y1(i10);
                    }
                    return cloudBackupAppDataUtil;
                }
            } catch (PackageManager.NameNotFoundException | RuntimeException e10) {
                C11839m.m70689w("CloudBackupV3ModuleAbstractOperate", "buildDataUtil package error: " + e10);
                throw new C9721b(1998, "buildDataUtil package name not found, appId =" + strM29870d);
            }
        } else {
            cloudBackupStatus.m29439t2(String.valueOf(C12590s0.m75790R(strM29870d)));
        }
        if (!cloudBackupStatus.m29867U()) {
            return null;
        }
        cloudBackupStatus.mo29316a0(CloudBackupLanguageUtil.getVirtualName(strM29870d));
        CloudBackupAppDataUtil cloudBackupAppDataUtil2 = new CloudBackupAppDataUtil(strM29870d, this.f47342a.getLocation(), 0L, this.f47342a.isRefurbishment(), this.f47342a.mo29591n());
        cloudBackupStatus.m29453y1(cloudBackupAppDataUtil2.isAppDataAble() ? 1 : 0);
        return cloudBackupAppDataUtil2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [em.z] */
    /* JADX WARN: Type inference failed for: r11v1, types: [em.z] */
    /* JADX WARN: Type inference failed for: r11v7, types: [java.io.File] */
    /* renamed from: c */
    public File m59506c(CloudBackupStatus cloudBackupStatus, Bundle bundle) throws InterruptedException, C9721b {
        String strMo29421n = cloudBackupStatus.mo29421n();
        String strM29870d = cloudBackupStatus.m29870d();
        int iM29861N = cloudBackupStatus.m29861N();
        String location = this.f47342a.getLocation();
        String strM75651E = !TextUtils.equals(strMo29421n, strM29870d) ? C12583q.m75651E(location, iM29861N) : location;
        try {
            m59507d(strMo29421n, strM75651E, bundle, 0, null);
            try {
                this = C12590s0.m75766L(cloudBackupStatus, location);
                return this;
            } catch (C9721b e10) {
                if (e10.m60659c() != 2005) {
                    throw e10;
                }
                C11839m.m70688i("CloudBackupV3ModuleAbstractOperate", "cloneApk error: " + e10.getMessage() + ", retry onece more: " + strM29870d);
                this.m59507d(strMo29421n, strM75651E, bundle, 0, null);
                return C12590s0.m75766L(cloudBackupStatus, location);
            }
        } catch (C9721b e11) {
            if (e11.m60659c() != 2013 || C0209d.m1184K0(this.m59509h(), strMo29421n)) {
                throw e11;
            }
            throw new C9721b(1998, "clone backup data error, package name not found, appId = " + strM29870d);
        }
    }

    /* renamed from: d */
    public void m59507d(String str, String str2, Bundle bundle, int i10, InterfaceC0278j1 interfaceC0278j1) throws InterruptedException, C9721b {
        try {
            this.f47342a.isCancel();
            CloneService.getInstance().doBackupOneModule(str, str2, bundle, interfaceC0278j1);
        } catch (C9721b e10) {
            String message = e10.getMessage();
            C11839m.m70687e("CloudBackupV3ModuleAbstractOperate", "clone module " + str + " error, errorReason: " + message + ", retryTime: " + i10);
            CloneService.getInstance().reportBackupOneModuleError(str, message, this.f47353l, i10);
            if (i10 >= 1) {
                throw new C9721b(e10.m60659c(), message, "doBackupOneModule");
            }
            int i11 = 0;
            while (i11 < 30000) {
                try {
                    this.f47342a.isCancel();
                    Thread.sleep(400L);
                    i11 += 400;
                } catch (InterruptedException e11) {
                    C11839m.m70687e("CloudBackupV3ModuleAbstractOperate", "InterruptedException : " + e11.toString());
                }
            }
            m59507d(str, str2, bundle, i10 + 1, interfaceC0278j1);
        }
    }

    /* renamed from: e */
    public abstract void mo57881e(CloudBackupStatus cloudBackupStatus);

    /* renamed from: f */
    public abstract void mo57883f();

    /* renamed from: g */
    public final long m59508g(String str, int i10) {
        long jM73044K;
        try {
            jM73044K = new C12164f(this.f47345d, str, 0, i10).m73044K();
        } catch (C9721b e10) {
            C11839m.m70687e("CloudBackupV3ModuleAbstractOperate", "getAppDataSize appId: " + str + ", error: " + e10.getMessage());
            jM73044K = 0;
        }
        C11839m.m70688i("CloudBackupV3ModuleAbstractOperate", "getAppDataSize appId: " + str + " ,size: " + jM73044K);
        return jM73044K;
    }

    /* renamed from: h */
    public Context m59509h() {
        return C0213f.m1377a();
    }

    /* renamed from: i */
    public final String m59510i(CloudBackupStatus cloudBackupStatus) {
        if (cloudBackupStatus == null) {
            return "";
        }
        String strM29393b1 = cloudBackupStatus.m29393b1();
        return TextUtils.isEmpty(strM29393b1) ? "" : C12590s0.m75858h2(strM29393b1).getOrDefault("signatures", "");
    }

    /* renamed from: j */
    public void m59511j() throws InterruptedException, C9721b {
        try {
            this.f47342a.isCancel();
            if (this.f47352k) {
                throw new C9721b(1999, "module backup task interrupted.");
            }
            C9721b c9721b = this.f47351j;
            if (c9721b != null) {
                throw c9721b;
            }
        } catch (C9721b e10) {
            this.f47352k = true;
            throw e10;
        }
    }

    /* renamed from: k */
    public final boolean m59512k(String str, int i10, String str2) {
        boolean z10 = false;
        try {
            int iM73042J = new C12164f(this.f47345d, str, 0, i10).m73042J(str2);
            C11839m.m70688i("CloudBackupV3ModuleAbstractOperate", "compressedFileCount:" + iM73042J);
            if (iM73042J > 0) {
                z10 = true;
            }
        } catch (C9721b e10) {
            C11839m.m70687e("CloudBackupV3ModuleAbstractOperate", "isCompressedFileUpload appId: " + str + ", error: " + e10.getMessage());
        }
        C11839m.m70688i("CloudBackupV3ModuleAbstractOperate", "isCompressedFileUpload appId: " + str + " ,result: " + z10);
        return z10;
    }

    /* renamed from: l */
    public boolean m59513l(long j10, long j11) {
        long jCurrentTimeMillis = System.currentTimeMillis() - j10;
        return j10 > 0 && jCurrentTimeMillis > 0 && jCurrentTimeMillis >= j11;
    }

    /* renamed from: m */
    public boolean m59514m(CloudBackupStatus cloudBackupStatus) {
        if (!this.f47349h || cloudBackupStatus.m29414k1()) {
            return false;
        }
        C11839m.m70688i("CloudBackupV3ModuleAbstractOperate", "need full backup data, appId = " + cloudBackupStatus.m29870d() + ", uid = " + cloudBackupStatus.m29861N());
        this.f47343b.m61927l(cloudBackupStatus.m29870d(), cloudBackupStatus.mo29421n(), cloudBackupStatus.m29861N());
        return true;
    }

    /* renamed from: n */
    public void m59515n(Map<String, String> map, CloudBackupStatus cloudBackupStatus) {
        if (!C13452e.m80781L().m80887a1() || this.f47342a.isRefurbishment()) {
            return;
        }
        Set<String> setM29737q0 = this.f47342a.m29737q0();
        String str = (setM29737q0.contains(cloudBackupStatus.m29870d()) || (cloudBackupStatus.m29863P() && cloudBackupStatus.m29351H0() == 0 && setM29737q0.contains("applistStrategy"))) ? "1" : "2";
        C11839m.m70688i("CloudBackupV3ModuleAbstractOperate", "putModuleBmType appId: " + cloudBackupStatus.m29870d() + " ,bmType: " + str);
        cloudBackupStatus.m29367O1(str);
        if (map != null) {
            map.put("bmAppDataType", str);
        }
    }

    /* renamed from: o */
    public void m59516o(App app, CloudBackupStatus cloudBackupStatus) {
        List<Attachment> attachments;
        if (!cloudBackupStatus.m29863P() || (attachments = app.getAttachments()) == null || attachments.isEmpty()) {
            return;
        }
        for (int i10 = 0; i10 < attachments.size(); i10++) {
            Attachment attachment = attachments.get(i10);
            String usage = attachment.getUsage();
            Integer quotaType = attachment.getQuotaType();
            if ("apk".equals(usage)) {
                C11839m.m70686d("CloudBackupV3ModuleAbstractOperate", "setApkAndIconSize app = " + cloudBackupStatus.m29870d() + " quotaType = " + quotaType);
                cloudBackupStatus.m29356J1(String.valueOf(quotaType));
            }
        }
    }

    /* renamed from: p */
    public abstract void mo57894p(Throwable th2);

    /* JADX WARN: Removed duplicated region for block: B:25:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0139  */
    /* renamed from: q */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m59517q(com.huawei.hicloud.cloudbackup.store.database.status.CloudBackupStatus r17, java.util.Map<java.lang.String, java.lang.String> r18) throws android.content.pm.PackageManager.NameNotFoundException {
        /*
            Method dump skipped, instructions count: 326
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p262em.AbstractC9526z.m59517q(com.huawei.hicloud.cloudbackup.store.database.status.CloudBackupStatus, java.util.Map):void");
    }

    /* renamed from: r */
    public long m59518r(CloudBackupStatus cloudBackupStatus, Long l10, Long l11) throws C9721b, PackageManager.NameNotFoundException {
        String str;
        String strM29870d = cloudBackupStatus.m29870d();
        int iM29861N = cloudBackupStatus.m29861N();
        if (iM29861N == 0) {
            str = strM29870d;
        } else {
            str = strM29870d + iM29861N;
        }
        C12164f c12164f = new C12164f(this.f47342a.m29734p0(), strM29870d, 0, iM29861N);
        long jSum = this.f47342a.mo29591n() ? new C12812c().m76887f(strM29870d).stream().mapToLong(new C9203f0()).sum() : 0L;
        if (l10 == null) {
            l10 = Long.valueOf(c12164f.m73107u0() + jSum);
        }
        this.f47343b.m61895M().put(str, l10);
        this.f47343b.m61938r0(str, l10.longValue(), c12164f);
        if (l11 == null) {
            l11 = Long.valueOf(c12164f.m73070b0() + jSum);
        }
        this.f47343b.m61897O().put(str, l11);
        this.f47343b.m61942t0(cloudBackupStatus);
        C11839m.m70686d("CloudBackupV3ModuleAbstractOperate", "updateModuleIncrementSize appId:" + strM29870d + " attachmentSize: " + jSum + " ,backupSize: " + l10 + " ,totalSize: " + l11);
        return l10.longValue();
    }

    /* renamed from: s */
    public void m59519s() throws InterruptedException, C9721b {
        while (C12182i.m73283j().m73296p()) {
            m59511j();
            SystemClock.sleep(500L);
        }
    }
}
