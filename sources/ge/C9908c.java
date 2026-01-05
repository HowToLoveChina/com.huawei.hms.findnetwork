package ge;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.p017pm.IPackageInstallObserver;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.StatFs;
import android.text.TextUtils;
import android.webkit.URLUtil;
import ck.C1443a;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hicloud.bean.HonorAppUpgradeInfo;
import com.huawei.hicloud.bean.HonorVersionInfo;
import com.huawei.hicloud.notification.manager.HiCloudForceUpgradeConfigManager;
import com.huawei.hicloud.notification.util.ForcedUpgradeUtil;
import com.huawei.hms.network.embedded.C5914f2;
import com.huawei.openalliance.p169ad.p171db.bean.ContentResource;
import com.huawei.secure.android.common.intent.SafeIntent;
import com.huawei.updatesdk.UpdateSdkAPI;
import com.huawei.updatesdk.service.appmgr.bean.ApkUpgradeInfo;
import com.huawei.updatesdk.service.otaupdate.CheckUpdateCallBack;
import com.huawei.updatesdk.service.otaupdate.UpdateKey;
import com.tencent.p204mm.opensdk.modelmsg.WXMediaMessage;
import gp.C10028c;
import hk.C10278a;
import hk.C10279b;
import hk.C10280c;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.regex.Pattern;
import okhttp3.C11912b0;
import okhttp3.HttpRequestBuilder;
import okhttp3.HttpResponseBuilder;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0224k0;
import p015ak.C0241z;
import p020ap.C1007b;
import p052cb.C1415l;
import p292fn.C9733f;
import p336he.C10158i;
import p399jk.AbstractC10896a;
import p514o9.C11829c;
import p514o9.C11839m;
import p664u0.C13108a;
import p684un.C13227f;
import p709vj.C13452e;
import p783xp.C13843a;
import p846zj.C14306d;
import so.C12819a;

/* renamed from: ge.c */
/* loaded from: classes3.dex */
public final class C9908c {

    /* renamed from: a */
    public ApkUpgradeInfo f48604a;

    /* renamed from: b */
    public Context f48605b;

    /* renamed from: c */
    public String f48606c;

    /* renamed from: d */
    public CountDownLatch f48607d;

    /* renamed from: e */
    public IntentFilter f48608e;

    /* renamed from: f */
    public h f48609f;

    /* renamed from: g */
    public C11912b0 f48610g;

    /* renamed from: h */
    public HttpResponseBuilder f48611h;

    /* renamed from: i */
    public HttpRequestBuilder f48612i;

    /* renamed from: j */
    public C13108a f48613j;

    /* renamed from: k */
    public Handler f48614k;

    /* renamed from: l */
    public boolean f48615l;

    /* renamed from: m */
    public int f48616m;

    /* renamed from: n */
    public CheckUpdateCallBack f48617n;

    /* renamed from: o */
    public g f48618o;

    /* renamed from: p */
    public g f48619p;

    /* renamed from: q */
    public g f48620q;

    /* renamed from: r */
    public g f48621r;

    /* renamed from: s */
    public IPackageInstallObserver f48622s;

    /* renamed from: ge.c$a */
    public class a implements CheckUpdateCallBack {

        /* renamed from: a */
        public final /* synthetic */ boolean f48623a;

        /* renamed from: b */
        public final /* synthetic */ boolean f48624b;

        public a(boolean z10, boolean z11) {
            this.f48623a = z10;
            this.f48624b = z11;
        }

        @Override // com.huawei.updatesdk.service.otaupdate.CheckUpdateCallBack
        public void onMarketInstallInfo(Intent intent) {
            C11839m.m70688i("UpdateManager", "onMarketInstallInfo ");
            C9908c.this.m61536V(3);
        }

        @Override // com.huawei.updatesdk.service.otaupdate.CheckUpdateCallBack
        public void onMarketStoreError(int i10) {
            C11839m.m70688i("UpdateManager", "onMarketStoreError ");
            C9908c.this.m61536V(3);
        }

        @Override // com.huawei.updatesdk.service.otaupdate.CheckUpdateCallBack
        public void onUpdateInfo(Intent intent) {
            Serializable serializableExtra;
            SafeIntent safeIntent = new SafeIntent(intent);
            int intExtra = safeIntent.getIntExtra("status", -99);
            try {
                serializableExtra = safeIntent.getSerializableExtra(UpdateKey.INFO);
            } catch (Exception e10) {
                C11839m.m70688i("UpdateManager", "updateCheck info error " + e10.getMessage());
                serializableExtra = null;
            }
            C11839m.m70688i("UpdateManager", "updateCheck status: " + intExtra);
            if (intExtra == 7 && serializableExtra != null && (serializableExtra instanceof ApkUpgradeInfo)) {
                C11839m.m70688i("UpdateManager", "has new version");
                C9908c.this.f48604a = (ApkUpgradeInfo) serializableExtra;
                C9908c.this.m61553t(this.f48623a, this.f48624b);
            } else {
                C11839m.m70688i("UpdateManager", "no new version");
                C9908c.this.m61554u(safeIntent, intExtra);
            }
            C9908c.this.m61538X();
            C9908c.this.m61534T(safeIntent, this.f48624b);
        }

        @Override // com.huawei.updatesdk.service.otaupdate.CheckUpdateCallBack
        public void onUpdateStoreError(int i10) {
            C11839m.m70688i("UpdateManager", "onUpdateStoreError ");
            C9908c.this.m61536V(3);
        }
    }

    /* renamed from: ge.c$b */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C9908c c9908c = C9908c.this;
            c9908c.m61555v(c9908c.f48604a);
        }
    }

    /* renamed from: ge.c$c */
    public class c implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ ApkUpgradeInfo f48627a;

        public c(ApkUpgradeInfo apkUpgradeInfo) {
            this.f48627a = apkUpgradeInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            C9908c.this.m61558y(this.f48627a);
        }
    }

    /* renamed from: ge.c$d */
    public class d extends IPackageInstallObserver.Stub {
        public d() {
        }

        @Override // android.content.p017pm.IPackageInstallObserver
        public void packageInstalled(String str, int i10) {
            C11839m.m70688i("UpdateManager", "Auth install result: " + i10);
            if (i10 == -4) {
                C11839m.m70688i("UpdateManager", "install fail, storage full");
            } else if (i10 != 1) {
                C11839m.m70688i("UpdateManager", "install fail : " + i10);
            } else {
                C11839m.m70688i("UpdateManager", "slient install succ");
            }
            if (C9908c.this.f48607d != null) {
                C9908c.this.f48607d.countDown();
            }
            if (C9908c.this.f48604a != null) {
                C13227f.m79492i1().m79572T0(C9908c.this.f48604a.getVersion_(), "4", "install fail  ");
            }
            C9908c.this.m61537W(8, i10, 0, null);
            if (C9908c.this.f48604a != null) {
                C9908c c9908c = C9908c.this;
                c9908c.m61532R(c9908c.f48604a.getName_());
            }
        }
    }

    /* renamed from: ge.c$e */
    public class e implements CheckUpdateCallBack {

        /* renamed from: a */
        public final /* synthetic */ boolean f48630a;

        /* renamed from: b */
        public final /* synthetic */ ForcedUpgradeUtil.QueryUpdate f48631b;

        public e(boolean z10, ForcedUpgradeUtil.QueryUpdate queryUpdate) {
            this.f48630a = z10;
            this.f48631b = queryUpdate;
        }

        @Override // com.huawei.updatesdk.service.otaupdate.CheckUpdateCallBack
        public void onMarketInstallInfo(Intent intent) {
            ForcedUpgradeUtil.QueryUpdate queryUpdate = this.f48631b;
            if (queryUpdate != null) {
                queryUpdate.onUpgrade(0);
            }
        }

        @Override // com.huawei.updatesdk.service.otaupdate.CheckUpdateCallBack
        public void onMarketStoreError(int i10) {
            ForcedUpgradeUtil.QueryUpdate queryUpdate = this.f48631b;
            if (queryUpdate != null) {
                queryUpdate.onUpgrade(0);
            }
        }

        @Override // com.huawei.updatesdk.service.otaupdate.CheckUpdateCallBack
        public void onUpdateInfo(Intent intent) {
            Serializable serializableExtra;
            SafeIntent safeIntent = new SafeIntent(intent);
            int intExtra = safeIntent.getIntExtra("status", -99);
            try {
                serializableExtra = safeIntent.getSerializableExtra(UpdateKey.INFO);
            } catch (Exception e10) {
                C11839m.m70688i("UpdateManager", "updateCheck info error " + e10.getMessage());
                serializableExtra = null;
            }
            C11839m.m70688i("UpdateManager", "saveForcedUpgradeConfig, updateCheck status: " + intExtra);
            C10028c c10028cM62182c0 = C10028c.m62182c0();
            if (intExtra == 7 && serializableExtra != null && (serializableExtra instanceof ApkUpgradeInfo)) {
                C11839m.m70688i("UpdateManager", "saveForcedUpgradeConfig, has new version");
                C9908c.this.f48604a = (ApkUpgradeInfo) serializableExtra;
                C11839m.m70688i("UpdateManager", "saveForcedUpgradeConfig, apkUpgradeInfo version is:" + C9908c.this.f48604a.getVersionCode_());
                if (HiCloudForceUpgradeConfigManager.getInstance().isValidityAppMarketVersion(C9908c.this.f48604a.getVersionCode_())) {
                    c10028cM62182c0.m62235K2("upgrade_version_code", C9908c.this.f48604a.getVersionCode_());
                    c10028cM62182c0.m62284V1(true, this.f48630a);
                } else {
                    c10028cM62182c0.m62284V1(false, false);
                }
            } else {
                C11839m.m70688i("UpdateManager", "saveForcedUpgradeConfig, no new version");
            }
            if (this.f48631b == null || C9908c.this.f48604a == null) {
                return;
            }
            this.f48631b.onUpgrade(C9908c.this.f48604a.getVersionCode_());
        }

        @Override // com.huawei.updatesdk.service.otaupdate.CheckUpdateCallBack
        public void onUpdateStoreError(int i10) {
            ForcedUpgradeUtil.QueryUpdate queryUpdate = this.f48631b;
            if (queryUpdate != null) {
                queryUpdate.onUpgrade(0);
            }
        }
    }

    /* renamed from: ge.c$f */
    public static class f {

        /* renamed from: a */
        public static C9908c f48633a = new C9908c(null);
    }

    /* renamed from: ge.c$g */
    public class g extends Handler {

        /* renamed from: a */
        public Context f48634a;

        /* renamed from: b */
        public boolean f48635b;

        /* renamed from: c */
        public boolean f48636c;

        public g(Looper looper, Context context, boolean z10, boolean z11) {
            super(looper);
            this.f48634a = context;
            this.f48635b = z10;
            this.f48636c = z11;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message == null) {
                C11839m.m70687e("UpdateManager", "msg is null");
                return;
            }
            C11839m.m70688i("UpdateManager", "getServiceCountryCode finish: " + message.what);
            int i10 = message.what;
            if (i10 == 20000) {
                C9908c.m61499D().m61536V(13);
                C9908c.this.m61538X();
            } else {
                if (i10 == 20001) {
                    C9908c.this.m61546g0(this.f48634a, this.f48635b, this.f48636c);
                    return;
                }
                C11839m.m70687e("UpdateManager", "default switch: " + message.what);
            }
        }
    }

    /* renamed from: ge.c$h */
    public class h extends BroadcastReceiver {
        public h() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int intExtra = new HiCloudSafeIntent(intent).getIntExtra("android.content.pm.extra.STATUS", 1);
            if (C9908c.this.f48604a == null) {
                return;
            }
            if (C9908c.this.f48607d != null) {
                C9908c.this.f48607d.countDown();
            }
            if (intExtra == 0) {
                C13227f.m79492i1().m79572T0(C9908c.this.f48604a.getVersion_(), "4", "install success ");
                C9908c.this.m61537W(8, 1, 0, null);
            } else {
                C13227f.m79492i1().m79572T0(C9908c.this.f48604a.getVersion_(), "4", "install fail");
                C9908c.this.m61537W(8, 0, 0, null);
            }
        }

        public /* synthetic */ h(C9908c c9908c, a aVar) {
            this();
        }
    }

    public /* synthetic */ C9908c(a aVar) {
        this();
    }

    /* renamed from: D */
    public static C9908c m61499D() {
        return f.f48633a;
    }

    /* renamed from: f0 */
    public static boolean m61506f0() throws NoSuchMethodException, SecurityException {
        try {
            Class.forName("android.content.pm.PackageManager").getMethod("installPackage", Uri.class, IPackageInstallObserver.class, Integer.TYPE, String.class);
            return true;
        } catch (ClassNotFoundException e10) {
            C11839m.m70689w("UpdateManager", "class not found: " + e10.getMessage());
            return false;
        } catch (NoSuchMethodException e11) {
            C11839m.m70689w("UpdateManager", "no such method: " + e11.getMessage());
            return false;
        } catch (SecurityException e12) {
            C11839m.m70689w("UpdateManager", "security: " + e12.getMessage());
            return false;
        }
    }

    /* renamed from: A */
    public final C11912b0.c m61516A() {
        C11912b0.c cVar = new C11912b0.c();
        try {
            cVar.m71521r(C12819a.m76967d(), C12819a.m76968e());
        } catch (IOException | IllegalAccessException | GeneralSecurityException unused) {
            C11839m.m70687e("UpdateManager", "Use default Dispatcher OkhttpClient");
        }
        return cVar;
    }

    /* renamed from: B */
    public HonorAppUpgradeInfo m61517B() {
        String strM60762u = C9733f.m60705z().m60762u("honorAppUpgrade");
        if (TextUtils.isEmpty(strM60762u)) {
            C11839m.m70688i("UpdateManager", "honor app upgrade feature parameters is empty.");
            return null;
        }
        try {
            return (HonorAppUpgradeInfo) new Gson().fromJson(strM60762u, HonorAppUpgradeInfo.class);
        } catch (JsonSyntaxException e10) {
            C11839m.m70688i("UpdateManager", "getHonorUpgradeInfo, json error is " + e10.getMessage());
            return null;
        }
    }

    /* renamed from: C */
    public HonorVersionInfo m61518C(HonorAppUpgradeInfo honorAppUpgradeInfo) {
        if (honorAppUpgradeInfo == null) {
            C11839m.m70688i("UpdateManager", "honorAppUpgradeInfo or upgrade info version is empty.");
            return null;
        }
        List<HonorVersionInfo> versions = honorAppUpgradeInfo.getVersions();
        if (versions == null || versions.size() == 0) {
            C11839m.m70688i("UpdateManager", "getHonorUpgradeInfoVersion versions list is null");
            return null;
        }
        for (int i10 = 0; i10 < versions.size(); i10++) {
            if (m61527M(versions.get(i10))) {
                return versions.get(i10);
            }
        }
        return null;
    }

    /* renamed from: E */
    public final String m61519E(String str, boolean z10) {
        if (z10) {
            File file = new File(Environment.getExternalStorageDirectory().getPath() + "/HiDisk/");
            if (file.exists() || file.mkdirs()) {
                return Environment.getExternalStorageDirectory().getPath() + "/HiDisk/" + str;
            }
        }
        return null;
    }

    /* renamed from: F */
    public final void m61520F(Context context, boolean z10, boolean z11) {
        if (context == null) {
            C11839m.m70687e("UpdateManager", "getServiceCountryCode context is null");
            return;
        }
        if (!C13452e.m80781L().m80842P0()) {
            C11839m.m70688i("UpdateManager", "not login, check new version");
            m61546g0(context, z10, z11);
        } else {
            if (z10) {
                if (z11) {
                    C14306d.m85217r(context, this.f48618o, false);
                    return;
                } else {
                    C14306d.m85217r(context, this.f48619p, false);
                    return;
                }
            }
            if (z11) {
                C14306d.m85217r(context, this.f48620q, false);
            } else {
                C14306d.m85217r(context, this.f48621r, false);
            }
        }
    }

    /* renamed from: G */
    public final void m61521G(boolean z10) {
        if (this.f48604a != null && C0209d.m1185K1(this.f48605b)) {
            if (z10 && C10028c.m62182c0().m62380q1() && HiCloudForceUpgradeConfigManager.getInstance().isValidityAppMarketVersion(this.f48604a.getVersionCode_())) {
                m61537W(17, 0, 0, this.f48604a);
            } else {
                if (!C0209d.m1184K0(this.f48605b, C13843a.m83090l())) {
                    m61537W(1, 0, 0, this.f48604a);
                    return;
                }
                C11839m.m70688i("UpdateManager", "hasNewVersion show sdk dialog");
                UpdateSdkAPI.showUpdateDialog(this.f48605b, this.f48604a, false);
                m61536V(1);
            }
        }
    }

    /* renamed from: H */
    public void m61522H(boolean z10) {
        C11839m.m70688i("UpdateManager", "honorUpdateQuery start");
        if (!C13452e.m80781L().m80842P0()) {
            C11839m.m70688i("UpdateManager", "Account is not login.");
            return;
        }
        if (!C0209d.m1269j1() || !C0209d.m1202Q0()) {
            C11839m.m70688i("UpdateManager", "honorUpdateQuery the device not honor or not china region.");
        } else if (C9733f.m60705z().m60721P()) {
            m61550q(z10);
        } else {
            C11839m.m70688i("UpdateManager", "Honor feature switch is close.");
        }
    }

    /* renamed from: I */
    public void m61523I(Context context, Handler handler) {
        this.f48605b = context;
        this.f48614k = handler;
        if (this.f48608e == null) {
            IntentFilter intentFilter = new IntentFilter();
            this.f48608e = intentFilter;
            intentFilter.addAction(this.f48605b.getPackageName() + ".install.ACTION_INSTALL_COMMIT");
        }
        if (this.f48609f == null) {
            this.f48609f = new h(this, null);
        }
        this.f48605b.registerReceiver(this.f48609f, this.f48608e);
        this.f48606c = this.f48605b.getPackageName();
    }

    /* renamed from: J */
    public void m61524J(Context context, Handler handler, ApkUpgradeInfo apkUpgradeInfo, String str) {
        this.f48605b = context;
        this.f48614k = handler;
        this.f48604a = apkUpgradeInfo;
        this.f48606c = str;
        if (this.f48608e == null) {
            IntentFilter intentFilter = new IntentFilter();
            this.f48608e = intentFilter;
            intentFilter.addAction(str + ".install.ACTION_INSTALL_COMMIT");
        }
        if (this.f48609f == null) {
            this.f48609f = new h(this, null);
        }
        this.f48605b.registerReceiver(this.f48609f, this.f48608e);
        this.f48607d = new CountDownLatch(1);
    }

    /* renamed from: K */
    public final boolean m61525K(Context context, String str, IPackageInstallObserver iPackageInstallObserver, String str2) throws IllegalAccessException, InvocationTargetException {
        try {
            C0224k0.m1563r(context, Uri.fromFile(new File(str)), iPackageInstallObserver, 2, this.f48606c);
            C11839m.m70686d("UpdateManager", "inner install end !");
            return true;
        } catch (IllegalArgumentException e10) {
            C13227f.m79492i1().m79572T0(str2, "4", "install fail : " + e10.getMessage());
            m61537W(8, 0, 0, null);
            C11839m.m70686d("UpdateManager", "installPackage IllegalArgumentException : " + e10.getMessage());
            return false;
        }
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:77)
        */
    /* renamed from: L */
    public final boolean m61526L(android.content.Context r21, java.lang.String r22, java.lang.String r23) {
        /*
            Method dump skipped, instructions count: 405
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ge.C9908c.m61526L(android.content.Context, java.lang.String, java.lang.String):boolean");
    }

    /* renamed from: M */
    public final boolean m61527M(HonorVersionInfo honorVersionInfo) {
        if (honorVersionInfo != null) {
            return Pattern.matches(honorVersionInfo.getRomVersRegex(), C0209d.m1149A0());
        }
        C11839m.m70688i("UpdateManager", "isEligibleCurrentRom version is null ");
        return false;
    }

    /* renamed from: N */
    public final boolean m61528N(String str, String str2, boolean z10) {
        C11839m.m70686d("UpdateManager", "check update apk whether exist.");
        if (z10) {
            String str3 = Environment.getExternalStorageDirectory().getPath() + "/HiDisk/" + str;
            if (new File(str3).exists() && m61552s(str2, str3)) {
                return true;
            }
            m61532R(str);
            return false;
        }
        if (this.f48605b == null) {
            return false;
        }
        String str4 = this.f48605b.getFilesDir() + File.separator + str;
        if (new File(str4).exists() && m61552s(str2, str4)) {
            return true;
        }
        m61532R(str);
        return false;
    }

    /* renamed from: O */
    public final /* synthetic */ void m61529O(HonorVersionInfo honorVersionInfo) {
        ApkUpgradeInfo apkUpgradeInfo = new ApkUpgradeInfo();
        this.f48604a = apkUpgradeInfo;
        apkUpgradeInfo.setName_(honorVersionInfo.getInfo().getName());
        this.f48604a.setVersion_(honorVersionInfo.getInfo().getVer());
        this.f48604a.setDownurl_(honorVersionInfo.getUrl());
        this.f48604a.setSha256_(honorVersionInfo.getSha256());
        m61555v(this.f48604a);
    }

    /* renamed from: P */
    public final /* synthetic */ void m61530P(HonorVersionInfo honorVersionInfo) {
        ApkUpgradeInfo apkUpgradeInfo = new ApkUpgradeInfo();
        this.f48604a = apkUpgradeInfo;
        apkUpgradeInfo.setName_(honorVersionInfo.getInfo().getName());
        this.f48604a.setVersion_(honorVersionInfo.getInfo().getVer());
        this.f48604a.setDownurl_(honorVersionInfo.getUrl());
        this.f48604a.setSha256_(honorVersionInfo.getSha256());
        m61558y(this.f48604a);
    }

    /* renamed from: Q */
    public void m61531Q() {
        h hVar;
        C11839m.m70688i("UpdateManager", "release");
        UpdateSdkAPI.releaseCallBack();
        if (this.f48604a != null) {
            this.f48604a = null;
        }
        if (this.f48614k != null) {
            this.f48614k = null;
            Context context = this.f48605b;
            if (context != null && (hVar = this.f48609f) != null) {
                try {
                    context.unregisterReceiver(hVar);
                    this.f48609f = null;
                } catch (IllegalArgumentException unused) {
                    C11839m.m70687e("UpdateManager", "Receiver not registered");
                }
            }
        }
        if (this.f48617n != null) {
            this.f48617n = null;
        }
    }

    /* renamed from: R */
    public final void m61532R(String str) {
        if (str == null) {
            C11839m.m70687e("UpdateManager", "apkName is null");
            return;
        }
        if (this.f48605b == null) {
            C11839m.m70687e("UpdateManager", "mContext is null");
            return;
        }
        File fileM63442h = C10278a.m63442h(this.f48605b.getFilesDir() + File.separator + str);
        if (fileM63442h.exists()) {
            C11839m.m70688i("UpdateManager", "removeErrorFile fileMem delete:" + fileM63442h.delete());
        }
        File fileM63442h2 = C10278a.m63442h(Environment.getExternalStorageDirectory().getPath() + "/HiDisk/" + str);
        if (fileM63442h2.exists()) {
            C11839m.m70688i("UpdateManager", "removeErrorFile fileSD delete:" + fileM63442h2.delete());
        }
    }

    /* renamed from: S */
    public void m61533S(Context context, boolean z10, ForcedUpgradeUtil.QueryUpdate queryUpdate) {
        if (!C0209d.m1246d2(context)) {
            C11839m.m70688i("UpdateManager", "updateCheck user not unlock");
            return;
        }
        if (C13452e.m80781L().m80842P0()) {
            C11839m.m70686d("UpdateManager", "getServiceCountryCode: " + C13452e.m80781L().m80921h0());
            UpdateSdkAPI.setServiceZone(C13452e.m80781L().m80921h0());
        }
        UpdateSdkAPI.checkTargetAppUpdate(context, "com.huawei.hidisk", new e(z10, queryUpdate));
    }

    /* renamed from: T */
    public final void m61534T(Intent intent, boolean z10) {
        if (intent == null) {
            C11839m.m70689w("UpdateManager", "intent is null!");
            return;
        }
        int intExtra = new HiCloudSafeIntent(intent).getIntExtra(UpdateKey.BUTTON_STATUS, -99);
        C11839m.m70688i("UpdateManager", "dialogClick buttonStatus" + intExtra);
        if (intExtra != 100) {
            if (intExtra == 101) {
                C11839m.m70688i("UpdateManager", "dialogClick update");
                C9913h.m61574q().m61577D();
                return;
            }
            return;
        }
        if (C10028c.m62182c0().m62380q1() && z10) {
            C11839m.m70688i("UpdateManager", "dialogClick finishActivity");
            C9913h.m61574q().m61592o();
        }
        C9913h.m61574q().m61577D();
    }

    /* renamed from: U */
    public final void m61535U(ApkUpgradeInfo apkUpgradeInfo, boolean z10, int i10) {
        Intent intent = new Intent("com.huawei.android.hicloud.intent.DOWNLOAD_COMPLETE");
        intent.putExtra(ContentResource.FILE_NAME, m61519E(apkUpgradeInfo.getName_(), z10));
        intent.putExtra("version", apkUpgradeInfo.getVersion_());
        intent.putExtra("mprogress", i10);
        this.f48605b.sendBroadcast(new SafeIntent(intent), "com.huawei.hidisk.permission.launcher.START_OOBE_QUERY");
        C11839m.m70688i("UpdateManager", "Sending a Broadcast Message Indicating Download Success to Small Packets.");
    }

    /* renamed from: V */
    public final void m61536V(int i10) {
        Handler handler = this.f48614k;
        if (handler != null) {
            handler.sendMessage(handler.obtainMessage(i10));
        }
    }

    /* renamed from: W */
    public final void m61537W(int i10, int i11, int i12, Object obj) {
        Handler handler = this.f48614k;
        if (handler != null) {
            handler.sendMessage(handler.obtainMessage(i10, i11, i12, obj));
        }
    }

    /* renamed from: X */
    public final void m61538X() {
        Context context = this.f48605b;
        if (context != null) {
            this.f48613j = C13108a.m78878b(context);
            Intent intent = new Intent("checkFinish");
            intent.putExtra("visibility", false);
            this.f48613j.m78881d(intent);
        }
    }

    /* renamed from: Y */
    public final void m61539Y(boolean z10) {
        if (z10) {
            m61536V(2);
        }
    }

    /* renamed from: Z */
    public void m61540Z(String str, String str2) {
        C13227f.m79492i1().m79572T0(str2, "3", "install start");
        if (m61506f0()) {
            if (m61525K(this.f48605b, str, this.f48622s, str2)) {
                m61536V(7);
            }
        } else if (m61526L(this.f48605b, str, str2)) {
            m61536V(7);
        } else {
            C13227f.m79492i1().m79572T0(str2, "4", "system not support slient install");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /* renamed from: a0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m61541a0(java.lang.String r5, java.lang.String r6) throws java.lang.InterruptedException {
        /*
            r4 = this;
            java.lang.String r0 = "UpdateManager"
            r4.m61540Z(r5, r6)
            r5 = 0
            java.util.concurrent.CountDownLatch r6 = r4.f48607d     // Catch: java.lang.InterruptedException -> L19
            if (r6 == 0) goto L13
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.SECONDS     // Catch: java.lang.InterruptedException -> L19
            r2 = 30
            boolean r6 = r6.await(r2, r1)     // Catch: java.lang.InterruptedException -> L19
            goto L1f
        L13:
            java.lang.String r6 = "downLatch is null"
            p399jk.AbstractC10896a.m65886e(r0, r6)     // Catch: java.lang.InterruptedException -> L19
            goto L1e
        L19:
            java.lang.String r6 = "syncLock wait catch InterruptedException."
            p399jk.AbstractC10896a.m65886e(r0, r6)
        L1e:
            r6 = r5
        L1f:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "downLatch awaitResult: "
            r1.append(r2)
            r1.append(r6)
            java.lang.String r1 = r1.toString()
            p399jk.AbstractC10896a.m65887i(r0, r1)
            if (r6 != 0) goto L3c
            r6 = 1
            r0 = 0
            r1 = 8
            r4.m61537W(r1, r6, r5, r0)
        L3c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ge.C9908c.m61541a0(java.lang.String, java.lang.String):void");
    }

    /* renamed from: b0 */
    public void m61542b0() {
        if (this.f48604a == null) {
            C11839m.m70688i("UpdateManager", "update info is null.");
            return;
        }
        C11839m.m70688i("UpdateManager", "update new apk.");
        b bVar = new b();
        C10158i.m63322f("download_channel_from_market");
        this.f48615l = false;
        Thread thread = new Thread(bVar, "DownApkThread");
        thread.setUncaughtExceptionHandler(new C1415l());
        thread.start();
    }

    /* renamed from: c0 */
    public void m61543c0(String str, String str2, String str3, String str4, Context context) {
        if (!URLUtil.isHttpsUrl(str2)) {
            AbstractC10896a.m65886e("UpdateManager", "url is not https");
            m61536V(6);
            return;
        }
        ApkUpgradeInfo apkUpgradeInfo = new ApkUpgradeInfo();
        apkUpgradeInfo.setName_(str);
        apkUpgradeInfo.setDownurl_(str2);
        apkUpgradeInfo.setSha256_(str3);
        apkUpgradeInfo.setVersion_(str4);
        this.f48604a = apkUpgradeInfo;
        this.f48605b = context;
        AbstractC10896a.m65887i("UpdateManager", "update new apk.");
        c cVar = new c(apkUpgradeInfo);
        C10158i.m63322f("download_channel_from_market");
        this.f48615l = false;
        Thread thread = new Thread(cVar, "DownApkThread");
        thread.setUncaughtExceptionHandler(new C1415l());
        thread.start();
    }

    /* renamed from: d0 */
    public void m61544d0(final HonorVersionInfo honorVersionInfo) {
        if (honorVersionInfo == null) {
            C11839m.m70688i("UpdateManager", "honor update info is null.");
            return;
        }
        Runnable runnable = new Runnable() { // from class: ge.b
            @Override // java.lang.Runnable
            public final void run() {
                this.f48602a.m61529O(honorVersionInfo);
            }
        };
        C11839m.m70688i("UpdateManager", "honor update new apk.");
        C10158i.m63322f("download_channel_from_om");
        this.f48615l = false;
        Thread thread = new Thread(runnable, "DownApkThread");
        thread.setUncaughtExceptionHandler(new C1415l());
        thread.start();
    }

    /* renamed from: e0 */
    public void m61545e0(final HonorVersionInfo honorVersionInfo) {
        if (honorVersionInfo == null) {
            C11839m.m70688i("UpdateManager", "honor update info is null.");
            return;
        }
        Runnable runnable = new Runnable() { // from class: ge.a
            @Override // java.lang.Runnable
            public final void run() {
                this.f48600a.m61530P(honorVersionInfo);
            }
        };
        C11839m.m70688i("UpdateManager", "honor update new apk.");
        C10158i.m63322f("download_channel_from_om");
        this.f48615l = false;
        Thread thread = new Thread(runnable, "DownApkThread");
        thread.setUncaughtExceptionHandler(new C1415l());
        thread.start();
    }

    /* renamed from: g0 */
    public final void m61546g0(Context context, boolean z10, boolean z11) {
        this.f48617n = new a(z10, z11);
        if (!C0209d.m1246d2(context)) {
            C11839m.m70688i("UpdateManager", "updateCheck user not unlock");
            return;
        }
        if (C13452e.m80781L().m80842P0()) {
            C11839m.m70686d("UpdateManager", "getServiceCountryCode: " + C13452e.m80781L().m80921h0());
            UpdateSdkAPI.setServiceZone(C13452e.m80781L().m80921h0());
        }
        UpdateSdkAPI.checkTargetAppUpdate(context, "com.huawei.hidisk", this.f48617n);
    }

    /* renamed from: h0 */
    public void m61547h0(boolean z10) {
        C11839m.m70688i("UpdateManager", "updateQuery start");
        m61520F(this.f48605b, true, z10);
    }

    /* renamed from: i0 */
    public void m61548i0(Context context) {
        if (C0209d.m1269j1() && C9733f.m60705z().m60721P()) {
            C11839m.m70688i("UpdateManager", "the device is honor product");
        } else {
            C11839m.m70688i("UpdateManager", "updateQueryAppInfo start");
            m61520F(context, false, false);
        }
    }

    /* renamed from: p */
    public void m61549p() {
        this.f48615l = true;
    }

    /* renamed from: q */
    public final void m61550q(boolean z10) {
        HonorAppUpgradeInfo honorAppUpgradeInfoM61517B = m61517B();
        HonorVersionInfo honorVersionInfoM61518C = m61518C(honorAppUpgradeInfoM61517B);
        if (honorAppUpgradeInfoM61517B == null || honorVersionInfoM61518C == null) {
            C11839m.m70688i("UpdateManager", "No matching honor upgrade info.");
            m61539Y(z10);
            return;
        }
        long jM62334h0 = C10028c.m62183d0(this.f48605b).m62334h0();
        int iM1685c = C0241z.m1685c(honorAppUpgradeInfoM61517B.getCheckInterval()) == 0 ? 1 : C0241z.m1685c(honorAppUpgradeInfoM61517B.getCheckInterval());
        if (!z10 && System.currentTimeMillis() - jM62334h0 < iM1685c * 86400000) {
            C11839m.m70688i("UpdateManager", "The detection frequency is less than the configured value.");
            return;
        }
        if (!m61551r(this.f48605b, honorVersionInfoM61518C)) {
            C11839m.m70688i("UpdateManager", "The configuration does not meet the trigger conditions.");
            m61539Y(z10);
            return;
        }
        HonorVersionInfo.Info info = honorVersionInfoM61518C.getInfo();
        if (info == null) {
            C11839m.m70688i("UpdateManager", "The configuration version info is null");
            m61539Y(z10);
            return;
        }
        int iM62275T0 = C10028c.m62182c0().m62275T0();
        if (z10 || honorAppUpgradeInfoM61517B.getMaxRemindingTimes() == -1 || iM62275T0 < honorAppUpgradeInfoM61517B.getMaxRemindingTimes()) {
            C10028c.m62182c0().m62269R2(true);
            if (!z10) {
                C11829c.m70558Z0(this.f48605b, honorVersionInfoM61518C);
            }
            boolean zM1241c1 = C0209d.m1241c1();
            C11839m.m70687e("UpdateManager", "isOnForeground is :" + zM1241c1);
            if (!z10 && !zM1241c1) {
                C11839m.m70687e("UpdateManager", "sendHonorGuideNotification");
                C1007b.m5980s().m5999S(info.getTitle(), info.getDetail());
                return;
            }
            m61536V(16);
        }
        if (z10) {
            return;
        }
        C10028c.m62182c0().m62246M3(iM62275T0 + 1);
        C10028c.m62183d0(this.f48605b).m62289W2();
    }

    /* renamed from: r */
    public final boolean m61551r(Context context, HonorVersionInfo honorVersionInfo) {
        if (honorVersionInfo == null) {
            C11839m.m70688i("UpdateManager", "No matching honor versionInfo info.");
            return false;
        }
        if (C0241z.m1685c(C1443a.f6213a) >= C0241z.m1685c(honorVersionInfo.getVersionCode())) {
            C11839m.m70688i("UpdateManager", "current version >= om configure");
            return false;
        }
        String strM62263Q0 = C10028c.m62183d0(context).m62263Q0("last_upgraded_version_number", "");
        if (C0241z.m1685c(honorVersionInfo.getVersionCode()) < C0241z.m1685c(strM62263Q0)) {
            C11839m.m70688i("UpdateManager", "lastUpgradedVer > om configure");
            return false;
        }
        if (C0241z.m1685c(honorVersionInfo.getVersionCode()) > C0241z.m1685c(strM62263Q0)) {
            C10028c.m62182c0().m62246M3(0);
        }
        C10028c.m62183d0(context).m62232J3("last_upgraded_version_number", honorVersionInfo.getVersionCode());
        return true;
    }

    /* renamed from: s */
    public final boolean m61552s(String str, String str2) throws Throwable {
        String strM63457e = C10280c.m63457e(str2, "SHA-256");
        return strM63457e != null && strM63457e.equalsIgnoreCase(str);
    }

    /* renamed from: t */
    public final void m61553t(boolean z10, boolean z11) {
        C11839m.m70688i("UpdateManager", "dealWithHasNewVersion isNeedDialog: " + z10);
        if (this.f48604a == null) {
            return;
        }
        C10028c c10028cM62182c0 = C10028c.m62182c0();
        if (c10028cM62182c0.m62226I1() && z11) {
            c10028cM62182c0.m62235K2("upgrade_version_code", this.f48604a.getVersionCode_());
        }
        C11839m.m70688i("UpdateManager", "updateCheck upgradeVersion: " + this.f48604a.getVersion_());
        if (z10) {
            m61521G(z11);
        } else if (C10028c.m62182c0().m62380q1() && HiCloudForceUpgradeConfigManager.getInstance().isValidityAppMarketVersion(this.f48604a.getVersionCode_())) {
            C13452e.m80781L().m80976u1();
        }
    }

    /* renamed from: u */
    public final void m61554u(SafeIntent safeIntent, int i10) {
        C11839m.m70688i("UpdateManager", "onUpdateInfo status: " + i10 + ",failcode: " + safeIntent.getIntExtra(UpdateKey.FAIL_CODE, -99) + ",failReason: " + safeIntent.getStringExtra(UpdateKey.FAIL_REASON));
        if (i10 == 3 || i10 == 1 || i10 == 6 || i10 == 8) {
            m61536V(2);
            return;
        }
        if (i10 == 2) {
            m61536V(13);
            return;
        }
        if (i10 == 9) {
            m61536V(11);
        } else if (i10 == 5) {
            m61536V(12);
        } else if (i10 == 4) {
            m61536V(3);
        }
    }

    /* renamed from: v */
    public final synchronized void m61555v(ApkUpgradeInfo apkUpgradeInfo) {
        BufferedInputStream bufferedInputStream;
        BufferedOutputStream bufferedOutputStream;
        String strM61519E;
        boolean zEquals = Environment.getExternalStorageState().equals("mounted");
        InputStream inputStream = null;
        try {
            strM61519E = m61519E(apkUpgradeInfo.getName_(), zEquals);
        } catch (IOException unused) {
            bufferedInputStream = null;
            bufferedOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            bufferedInputStream = null;
            bufferedOutputStream = null;
        }
        if (strM61519E == null) {
            C13227f.m79492i1().m79572T0(apkUpgradeInfo.getVersion_(), "2", "local path not exist");
            m61536V(6);
            C0209d.m1263i(null);
            C0209d.m1263i(this.f48611h);
            C0209d.m1263i(null);
            C0209d.m1263i(null);
            return;
        }
        m61532R(apkUpgradeInfo.getName_());
        File file = new File(strM61519E);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("bytes");
        stringBuffer.append("=");
        stringBuffer.append(0);
        stringBuffer.append("-");
        URL url = new URL(apkUpgradeInfo.getDownurl_());
        this.f48610g = m61516A().m71505b();
        HttpRequestBuilder HttpRequestBuilderM71575b = new HttpRequestBuilder.a().m71587n(url).addHeader("Range", stringBuffer.toString()).m71575b();
        this.f48612i = HttpRequestBuilderM71575b;
        HttpResponseBuilder HttpResponseBuilderExecute = this.f48610g.m71495z(HttpRequestBuilderM71575b).execute();
        this.f48611h = HttpResponseBuilderExecute;
        int iM71597u = HttpResponseBuilderExecute.m71597u();
        if (200 != iM71597u && 206 != iM71597u) {
            C13227f.m79492i1().m79572T0(apkUpgradeInfo.getVersion_(), "2", "down load by https fail : " + iM71597u);
            m61536V(6);
            C0209d.m1263i(null);
            C0209d.m1263i(this.f48611h);
            C0209d.m1263i(null);
            C0209d.m1263i(null);
            return;
        }
        int iM1685c = C0241z.m1685c(this.f48611h.m71599w("Content-Length"));
        this.f48616m = iM1685c;
        if (iM1685c == 0) {
            C13227f.m79492i1().m79572T0(apkUpgradeInfo.getVersion_(), "2", "file length invalid");
            m61536V(6);
            C0209d.m1263i(null);
            C0209d.m1263i(this.f48611h);
            C0209d.m1263i(null);
            C0209d.m1263i(null);
            return;
        }
        if (zEquals && m61559z() < this.f48616m) {
            C13227f.m79492i1().m79572T0(apkUpgradeInfo.getVersion_(), "2", "sdcard unavailable");
            m61536V(10);
            C0209d.m1263i(null);
            C0209d.m1263i(this.f48611h);
            C0209d.m1263i(null);
            C0209d.m1263i(null);
            return;
        }
        C13227f.m79492i1().m79572T0(apkUpgradeInfo.getVersion_(), "1", "download start");
        InputStream inputStreamM71632s = this.f48611h.m71595s().m71632s();
        try {
            bufferedInputStream = new BufferedInputStream(inputStreamM71632s);
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file, true), WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
                try {
                    m61556w(apkUpgradeInfo, bufferedOutputStream, bufferedInputStream, strM61519E, zEquals);
                    C0209d.m1263i(inputStreamM71632s);
                    C0209d.m1263i(this.f48611h);
                    C0209d.m1263i(bufferedInputStream);
                } catch (IOException unused2) {
                    inputStream = inputStreamM71632s;
                    try {
                        C13227f.m79492i1().m79572T0(apkUpgradeInfo.getVersion_(), "2", "down fail ioexception");
                        m61536V(6);
                        C0209d.m1263i(inputStream);
                        C0209d.m1263i(this.f48611h);
                        C0209d.m1263i(bufferedInputStream);
                        C0209d.m1263i(bufferedOutputStream);
                    } catch (Throwable th3) {
                        th = th3;
                        C0209d.m1263i(inputStream);
                        C0209d.m1263i(this.f48611h);
                        C0209d.m1263i(bufferedInputStream);
                        C0209d.m1263i(bufferedOutputStream);
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    inputStream = inputStreamM71632s;
                    C0209d.m1263i(inputStream);
                    C0209d.m1263i(this.f48611h);
                    C0209d.m1263i(bufferedInputStream);
                    C0209d.m1263i(bufferedOutputStream);
                    throw th;
                }
            } catch (IOException unused3) {
                bufferedOutputStream = null;
            } catch (Throwable th5) {
                th = th5;
                bufferedOutputStream = null;
            }
        } catch (IOException unused4) {
            bufferedInputStream = null;
            bufferedOutputStream = null;
        } catch (Throwable th6) {
            th = th6;
            bufferedInputStream = null;
            bufferedOutputStream = null;
        }
        C0209d.m1263i(bufferedOutputStream);
    }

    /* renamed from: w */
    public final synchronized void m61556w(ApkUpgradeInfo apkUpgradeInfo, BufferedOutputStream bufferedOutputStream, BufferedInputStream bufferedInputStream, String str, boolean z10) throws IOException {
        BufferedOutputStream bufferedOutputStream2;
        try {
            byte[] bArr = new byte[C5914f2.f26733f];
            long jCurrentTimeMillis = System.currentTimeMillis();
            int i10 = 0;
            while (true) {
                if (this.f48615l) {
                    break;
                }
                int i11 = bufferedInputStream.read(bArr);
                i10 += i11;
                int i12 = this.f48616m;
                int i13 = (int) ((i10 / i12) * 100.0f);
                if (i11 >= 0) {
                    HashMap map = new HashMap();
                    map.put("DOWNLOADED_SIZE", String.valueOf(i10));
                    map.put("TOTAL_SIZE", String.valueOf(this.f48616m));
                    long jCurrentTimeMillis2 = System.currentTimeMillis();
                    if (jCurrentTimeMillis2 - jCurrentTimeMillis > 500) {
                        m61537W(4, i13, 0, map);
                        bufferedOutputStream2 = bufferedOutputStream;
                        jCurrentTimeMillis = jCurrentTimeMillis2;
                    } else {
                        bufferedOutputStream2 = bufferedOutputStream;
                    }
                    bufferedOutputStream2.write(bArr, 0, i11);
                    if (this.f48615l) {
                        C13227f.m79492i1().m79572T0(apkUpgradeInfo.getVersion_(), "2", "Download cancel");
                        m61532R(apkUpgradeInfo.getName_());
                    }
                } else if (i12 == i10 + 1) {
                    bufferedOutputStream.flush();
                    if (m61528N(apkUpgradeInfo.getName_(), apkUpgradeInfo.getSha256_(), z10)) {
                        C13227f.m79492i1().m79572T0(apkUpgradeInfo.getVersion_(), "2", "download success");
                        m61537W(5, 0, 0, str);
                        if (TextUtils.equals(this.f48606c, C13843a.m83090l())) {
                            m61541a0(str, apkUpgradeInfo.getVersion_());
                        } else {
                            m61540Z(str, apkUpgradeInfo.getVersion_());
                        }
                    } else {
                        C13227f.m79492i1().m79572T0(apkUpgradeInfo.getVersion_(), "2", "object status err");
                        m61536V(6);
                    }
                } else {
                    C13227f.m79492i1().m79572T0(apkUpgradeInfo.getVersion_(), "2", "file invalid");
                    m61536V(6);
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: x */
    public final synchronized void m61557x(ApkUpgradeInfo apkUpgradeInfo, BufferedOutputStream bufferedOutputStream, BufferedInputStream bufferedInputStream, String str, boolean z10) throws IOException {
        BufferedOutputStream bufferedOutputStream2;
        try {
            byte[] bArr = new byte[C5914f2.f26733f];
            long jCurrentTimeMillis = System.currentTimeMillis();
            int i10 = 0;
            Object obj = str;
            while (true) {
                if (this.f48615l) {
                    break;
                }
                int i11 = bufferedInputStream.read(bArr);
                i10 += i11;
                int i12 = this.f48616m;
                int i13 = (int) ((i10 / i12) * 100.0f);
                if (i11 >= 0) {
                    HashMap map = new HashMap();
                    map.put("DOWNLOADED_SIZE", String.valueOf(i10));
                    map.put("TOTAL_SIZE", String.valueOf(this.f48616m));
                    Intent intent = new Intent("com.huawei.android.hicloud.intent.DOWNLOAD_NOT_COMPLETE");
                    String strM61519E = m61519E(apkUpgradeInfo.getName_(), z10);
                    intent.putExtra(ContentResource.FILE_NAME, strM61519E);
                    intent.putExtra("version", apkUpgradeInfo.getVersion_());
                    intent.putExtra("mprogress", i13);
                    intent.setAction("com.huawei.android.hicloud.intent.DOWNLOAD_NOT_COMPLETE");
                    SafeIntent safeIntent = new SafeIntent(intent);
                    long jCurrentTimeMillis2 = System.currentTimeMillis();
                    if (jCurrentTimeMillis2 - jCurrentTimeMillis > 500) {
                        m61537W(4, i13, 0, map);
                        this.f48605b.sendBroadcast(safeIntent, "com.huawei.hidisk.permission.launcher.START_OOBE_QUERY");
                        bufferedOutputStream2 = bufferedOutputStream;
                        jCurrentTimeMillis = jCurrentTimeMillis2;
                    } else {
                        bufferedOutputStream2 = bufferedOutputStream;
                    }
                    bufferedOutputStream2.write(bArr, 0, i11);
                    if (this.f48615l) {
                        C13227f.m79492i1().m79572T0(apkUpgradeInfo.getVersion_(), "2", "Download cancel");
                        m61532R(apkUpgradeInfo.getName_());
                    }
                    obj = strM61519E;
                } else if (i12 == i10 + 1) {
                    bufferedOutputStream.flush();
                    if (m61528N(apkUpgradeInfo.getName_(), apkUpgradeInfo.getSha256_(), z10)) {
                        C13227f.m79492i1().m79572T0(apkUpgradeInfo.getVersion_(), "2", "download success");
                        m61537W(5, 0, 0, obj);
                        m61535U(apkUpgradeInfo, z10, i13);
                    } else {
                        C13227f.m79492i1().m79572T0(apkUpgradeInfo.getVersion_(), "2", "object status err");
                        m61536V(6);
                    }
                } else {
                    C13227f.m79492i1().m79572T0(apkUpgradeInfo.getVersion_(), "2", "file invalid");
                    m61536V(6);
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: y */
    public final synchronized void m61558y(ApkUpgradeInfo apkUpgradeInfo) {
        BufferedInputStream bufferedInputStream;
        BufferedOutputStream bufferedOutputStream;
        String strM61519E;
        boolean zEquals = Environment.getExternalStorageState().equals("mounted");
        InputStream inputStream = null;
        try {
            strM61519E = m61519E(apkUpgradeInfo.getName_(), zEquals);
        } catch (IOException unused) {
            bufferedInputStream = null;
            bufferedOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            bufferedInputStream = null;
            bufferedOutputStream = null;
        }
        if (strM61519E == null) {
            C13227f.m79492i1().m79572T0(apkUpgradeInfo.getVersion_(), "2", "local path not exist");
            m61536V(6);
            C0209d.m1263i(null);
            C0209d.m1263i(this.f48611h);
            C0209d.m1263i(null);
            C0209d.m1263i(null);
            return;
        }
        m61532R(apkUpgradeInfo.getName_());
        File fileM63442h = C10278a.m63442h(strM61519E);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("bytes");
        stringBuffer.append("=");
        stringBuffer.append(0);
        stringBuffer.append("-");
        URL url = new URL(apkUpgradeInfo.getDownurl_());
        this.f48610g = m61516A().m71505b();
        HttpRequestBuilder HttpRequestBuilderM71575b = new HttpRequestBuilder.a().m71587n(url).addHeader("Range", stringBuffer.toString()).m71575b();
        this.f48612i = HttpRequestBuilderM71575b;
        HttpResponseBuilder HttpResponseBuilderExecute = this.f48610g.m71495z(HttpRequestBuilderM71575b).execute();
        this.f48611h = HttpResponseBuilderExecute;
        int iM71597u = HttpResponseBuilderExecute.m71597u();
        if (200 != iM71597u && 206 != iM71597u) {
            C13227f.m79492i1().m79572T0(apkUpgradeInfo.getVersion_(), "2", "down load by https fail : " + iM71597u);
            m61536V(6);
            C0209d.m1263i(null);
            C0209d.m1263i(this.f48611h);
            C0209d.m1263i(null);
            C0209d.m1263i(null);
            return;
        }
        int iM1685c = C0241z.m1685c(this.f48611h.m71599w("Content-Length"));
        this.f48616m = iM1685c;
        if (iM1685c == 0) {
            C13227f.m79492i1().m79572T0(apkUpgradeInfo.getVersion_(), "2", "file length invalid");
            m61536V(6);
            C0209d.m1263i(null);
            C0209d.m1263i(this.f48611h);
            C0209d.m1263i(null);
            C0209d.m1263i(null);
            return;
        }
        if (zEquals && m61559z() < this.f48616m) {
            C13227f.m79492i1().m79572T0(apkUpgradeInfo.getVersion_(), "2", "sdcard unavailable");
            m61536V(10);
            C0209d.m1263i(null);
            C0209d.m1263i(this.f48611h);
            C0209d.m1263i(null);
            C0209d.m1263i(null);
            return;
        }
        C13227f.m79492i1().m79572T0(apkUpgradeInfo.getVersion_(), "1", "download start");
        InputStream inputStreamM71632s = this.f48611h.m71595s().m71632s();
        try {
            bufferedInputStream = new BufferedInputStream(inputStreamM71632s);
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(fileM63442h, true), WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
                try {
                    m61557x(apkUpgradeInfo, bufferedOutputStream, bufferedInputStream, strM61519E, zEquals);
                    C0209d.m1263i(inputStreamM71632s);
                    C0209d.m1263i(this.f48611h);
                    C0209d.m1263i(bufferedInputStream);
                } catch (IOException unused2) {
                    inputStream = inputStreamM71632s;
                    try {
                        C13227f.m79492i1().m79572T0(apkUpgradeInfo.getVersion_(), "2", "down fail ioexception");
                        m61536V(6);
                        C0209d.m1263i(inputStream);
                        C0209d.m1263i(this.f48611h);
                        C0209d.m1263i(bufferedInputStream);
                        C0209d.m1263i(bufferedOutputStream);
                    } catch (Throwable th3) {
                        th = th3;
                        C0209d.m1263i(inputStream);
                        C0209d.m1263i(this.f48611h);
                        C0209d.m1263i(bufferedInputStream);
                        C0209d.m1263i(bufferedOutputStream);
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    inputStream = inputStreamM71632s;
                    C0209d.m1263i(inputStream);
                    C0209d.m1263i(this.f48611h);
                    C0209d.m1263i(bufferedInputStream);
                    C0209d.m1263i(bufferedOutputStream);
                    throw th;
                }
            } catch (IOException unused3) {
                bufferedOutputStream = null;
            } catch (Throwable th5) {
                th = th5;
                bufferedOutputStream = null;
            }
        } catch (IOException unused4) {
            bufferedInputStream = null;
            bufferedOutputStream = null;
        } catch (Throwable th6) {
            th = th6;
            bufferedInputStream = null;
            bufferedOutputStream = null;
        }
        C0209d.m1263i(bufferedOutputStream);
    }

    /* renamed from: z */
    public final long m61559z() {
        new StatFs(C10279b.m63452a(Environment.getExternalStorageDirectory())).restat(C10279b.m63452a(Environment.getExternalStorageDirectory()));
        return r4.getAvailableBlocks() * r4.getBlockSize();
    }

    public C9908c() {
        this.f48618o = new g(Looper.getMainLooper(), C0213f.m1377a(), true, true);
        this.f48619p = new g(Looper.getMainLooper(), C0213f.m1377a(), true, false);
        this.f48620q = new g(Looper.getMainLooper(), C0213f.m1377a(), false, true);
        this.f48621r = new g(Looper.getMainLooper(), C0213f.m1377a(), false, false);
        this.f48622s = new d();
    }
}
