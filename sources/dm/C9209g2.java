package dm;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.huawei.android.hicloud.cloudbackup.bean.RestoreModuleReportInfo;
import com.huawei.android.hicloud.cloudbackup.broadcast.ICBBroadcastManager;
import com.huawei.android.hicloud.cloudbackup.model.RestoreCache;
import com.huawei.android.hicloud.cloudbackup.process.CloneService;
import com.huawei.android.hicloud.cloudbackup.process.RestoreUtil;
import com.huawei.android.hicloud.cloudbackup.report.CloudBackupReport;
import com.huawei.android.hicloud.cloudbackup.util.ICBUtil;
import com.huawei.android.remotecontrol.tag.p092ui.view.RippleView;
import com.huawei.hicloud.cloudbackup.p104v3.core.C4880b;
import com.huawei.hicloud.cloudbackup.p104v3.core.module.nextrestore.nextmodule.NextModuleRestore;
import com.huawei.hicloud.cloudbackup.p104v3.omconfig.model.SyncSwitchStatus;
import com.huawei.hicloud.cloudbackup.store.database.status.CloudRestoreStatusV3;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hms.support.api.entity.pay.HwPayConstant;
import fk.C9721b;
import fm.C9727b;
import gm.C9992e0;
import hk.C10278a;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0209d;
import p015ak.C0210d0;
import p015ak.C0213f;
import p015ak.C0241z;
import p292fn.C9733f;
import p399jk.AbstractC10896a;
import p514o9.C11839m;
import p618rm.C12571m;
import p618rm.C12583q;
import p618rm.C12590s0;
import p618rm.C12593t0;
import p744wl.C13617a;
import p848zl.C14333b;
import pl.C12164f;
import sl.C12816g;

/* renamed from: dm.g2 */
/* loaded from: classes6.dex */
public class C9209g2 {

    /* renamed from: a */
    public CloudRestoreStatusV3 f46212a;

    /* renamed from: b */
    public boolean f46213b;

    /* renamed from: c */
    public List<String> f46214c;

    /* renamed from: f */
    public String f46217f;

    /* renamed from: g */
    public String f46218g;

    /* renamed from: i */
    public C9992e0 f46220i;

    /* renamed from: j */
    public C4880b f46221j;

    /* renamed from: k */
    public String f46222k;

    /* renamed from: l */
    public int f46223l;

    /* renamed from: d */
    public C12816g f46215d = new C12816g();

    /* renamed from: h */
    public CloneService f46219h = CloneService.getInstance();

    /* renamed from: n */
    public boolean f46225n = false;

    /* renamed from: m */
    public String f46224m = RestoreCache.getInstance().getEntranceOfRestore();

    /* renamed from: e */
    public Context f46216e = C0213f.m1377a();

    /* renamed from: dm.g2$a */
    public class a implements CloneService.CloneCallback {

        /* renamed from: a */
        public final /* synthetic */ CloudRestoreStatusV3 f46226a;

        public a(CloudRestoreStatusV3 cloudRestoreStatusV3) {
            this.f46226a = cloudRestoreStatusV3;
        }

        @Override // com.huawei.android.hicloud.cloudbackup.process.CloneService.CloneCallback
        public void onCallback(Message message, int i10) {
            C9209g2.this.m57827g(message, this.f46226a, i10);
        }

        @Override // com.huawei.android.hicloud.cloudbackup.process.CloneService.CloneCallback
        public void onError(int i10) {
            C9209g2.this.m57826f(i10, this.f46226a);
        }
    }

    /* renamed from: dm.g2$b */
    public class b extends TypeToken<List<SyncSwitchStatus>> {
        public b() {
        }
    }

    public C9209g2(CloudRestoreStatusV3 cloudRestoreStatusV3, boolean z10, List<String> list, String str, String str2, C9992e0 c9992e0, C4880b c4880b) {
        this.f46212a = cloudRestoreStatusV3;
        this.f46213b = z10;
        this.f46214c = list;
        this.f46217f = str;
        this.f46218g = str2;
        this.f46220i = c9992e0;
        this.f46221j = c4880b;
        this.f46222k = c4880b.m29783R();
        this.f46223l = c4880b.getEntryType();
    }

    /* renamed from: c */
    public final boolean m57823c(CloudRestoreStatusV3 cloudRestoreStatusV3, RestoreModuleReportInfo restoreModuleReportInfo) throws PackageManager.NameNotFoundException {
        if (cloudRestoreStatusV3.m29498s() == 1) {
            if (!C9733f.m60705z().m60720O("checkAppSignatureOnRestore")) {
                C11839m.m70686d("CloudRestoreV3ModuleRestore", "checkAppSignature feature gray isClose");
                return true;
            }
            int iM57831k = m57831k();
            if (iM57831k == 0) {
                C11839m.m70686d("CloudRestoreV3ModuleRestore", "checkAppSignature checkPolicy is not check");
                return true;
            }
            String str = C12590s0.m75858h2(cloudRestoreStatusV3.m29472N()).get("signatures");
            if (TextUtils.isEmpty(str)) {
                C11839m.m70686d("CloudRestoreV3ModuleRestore", "checkAppSignature signatures is null");
                return true;
            }
            boolean zM57825e = m57825e(this.f46216e, cloudRestoreStatusV3.m29470M(), m57832l(str));
            restoreModuleReportInfo.setSignCheckResult(zM57825e ? "success" : "fail");
            if (zM57825e) {
                return true;
            }
            C11839m.m70687e("CloudRestoreV3ModuleRestore", "checkAppSignature not right:  " + cloudRestoreStatusV3.getAppId());
            restoreModuleReportInfo.setBackupSignatures(str);
            C0210d0.m1338f();
            restoreModuleReportInfo.setLocalSignatures(C0210d0.m1337e(this.f46216e, cloudRestoreStatusV3.m29470M()));
            if (iM57831k == 2) {
                cloudRestoreStatusV3.setStatus(-1);
                this.f46215d.m76957u(cloudRestoreStatusV3);
                return false;
            }
        }
        return true;
    }

    /* renamed from: d */
    public final void m57824d(CloudRestoreStatusV3 cloudRestoreStatusV3) {
        C11839m.m70686d("CloudRestoreV3ModuleRestore", "checkPathMapping, appId = " + cloudRestoreStatusV3.getAppId() + ", uid = " + cloudRestoreStatusV3.getUid());
        Map<String, String> mapM75974g = C12593t0.m75974g(cloudRestoreStatusV3);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("checkPathMapping pathMapping size = ");
        sb2.append(mapM75974g.size());
        C11839m.m70688i("CloudRestoreV3ModuleRestore", sb2.toString());
        if (mapM75974g.isEmpty()) {
            return;
        }
        for (Map.Entry<String, String> entry : mapM75974g.entrySet()) {
            if (!C12593t0.m75968a(C12593t0.m75973f(entry.getKey(), cloudRestoreStatusV3.getUid()), cloudRestoreStatusV3.getUid())) {
                try {
                    C12593t0.m75983p(entry.getKey(), entry.getValue(), cloudRestoreStatusV3, this.f46221j);
                } catch (C9721b e10) {
                    C11839m.m70687e("CloudRestoreV3ModuleRestore", "checkPathMapping, moveDirectory error = " + e10);
                } catch (Exception e11) {
                    C11839m.m70687e("CloudRestoreV3ModuleRestore", "checkPathMapping error = " + e11.getMessage());
                }
            }
        }
    }

    /* renamed from: e */
    public boolean m57825e(Context context, String str, HashSet<String> hashSet) throws PackageManager.NameNotFoundException {
        PackageManager packageManager;
        if (hashSet.isEmpty()) {
            AbstractC10896a.m65887i("CloudRestoreV3ModuleRestore", "checkRestoreAppSignature cloudSignatures is null.");
            return true;
        }
        try {
            packageManager = context.getPackageManager();
        } catch (PackageManager.NameNotFoundException e10) {
            AbstractC10896a.m65886e("CloudRestoreV3ModuleRestore", "checkRestoreAppSignature NameNotFoundException error: " + e10.toString());
            return true;
        } catch (Exception e11) {
            AbstractC10896a.m65886e("CloudRestoreV3ModuleRestore", "checkRestoreAppSignature error: " + e11.toString());
        }
        if (packageManager == null) {
            AbstractC10896a.m65886e("CloudRestoreV3ModuleRestore", "checkRestoreAppSignature: packageManager is null");
            return false;
        }
        PackageInfo packageInfo = packageManager.getPackageInfo(str, 64);
        if (packageInfo == null) {
            AbstractC10896a.m65886e("CloudRestoreV3ModuleRestore", "checkRestoreAppSignature: packageInfo is null");
            return false;
        }
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr != null && signatureArr.length != 0) {
            for (Signature signature : signatureArr) {
                if (hashSet.contains(C0210d0.m1340h(signature))) {
                    return true;
                }
            }
            return false;
        }
        AbstractC10896a.m65886e("CloudRestoreV3ModuleRestore", "checkRestoreAppSignature: signs is null or signs.length < 1");
        return false;
    }

    /* renamed from: f */
    public final void m57826f(int i10, CloudRestoreStatusV3 cloudRestoreStatusV3) {
        if (i10 == 7) {
            cloudRestoreStatusV3.setStatus(-3);
            this.f46215d.m76957u(cloudRestoreStatusV3);
            return;
        }
        if (i10 != 9 && i10 != 11 && i10 != 13 && i10 != 15) {
            if (i10 == 27) {
                cloudRestoreStatusV3.setStatus(-6);
                this.f46215d.m76957u(cloudRestoreStatusV3);
                return;
            } else if (i10 != 36 && i10 != 1067) {
                return;
            }
        }
        if (cloudRestoreStatusV3.isUnSupport()) {
            return;
        }
        cloudRestoreStatusV3.setStatus(7).setType(2);
        this.f46215d.m76957u(cloudRestoreStatusV3);
    }

    /* renamed from: g */
    public final void m57827g(Message message, CloudRestoreStatusV3 cloudRestoreStatusV3, int i10) {
        int i11 = message.what;
        if (i11 == 1) {
            m57828h(message, cloudRestoreStatusV3, i10);
            return;
        }
        if (i11 != 25) {
            return;
        }
        cloudRestoreStatusV3.setStatus(6).setType(1);
        this.f46215d.m76957u(cloudRestoreStatusV3);
        ICBUtil.reportInstallEvent(cloudRestoreStatusV3.getAppId(), cloudRestoreStatusV3.getVersionCode(), cloudRestoreStatusV3.m29497r());
        this.f46225n = true;
        this.f46220i.m61975I(cloudRestoreStatusV3);
    }

    /* renamed from: h */
    public final void m57828h(Message message, CloudRestoreStatusV3 cloudRestoreStatusV3, int i10) {
        int i11 = message.arg1;
        int i12 = message.arg2;
        if (C14333b.m85490y().contains(cloudRestoreStatusV3.getAppId())) {
            i11++;
        }
        if (cloudRestoreStatusV3.is3rdAppType()) {
            return;
        }
        int iMin = Math.min(i12, cloudRestoreStatusV3.getCount());
        if (i10 > 0 && i10 <= i11) {
            i11 -= i10;
        }
        boolean z10 = i11 <= iMin && i11 >= cloudRestoreStatusV3.getCurrent();
        int i13 = iMin > 100 ? 50 : 10;
        if (z10) {
            if (i11 - cloudRestoreStatusV3.getCurrent() >= i13 || iMin < 10 || i11 == iMin) {
                if (cloudRestoreStatusV3.getType() != 2) {
                    cloudRestoreStatusV3.setType(1);
                }
                cloudRestoreStatusV3.setStatus(7).setCurrent(i11);
                this.f46215d.m76954r(cloudRestoreStatusV3);
                this.f46220i.m61975I(cloudRestoreStatusV3);
            }
        }
    }

    /* renamed from: i */
    public final void m57829i(String str, int i10) {
        C12571m.m75542d(this.f46217f + "/" + str);
        C12571m.m75542d(this.f46217f + ICBUtil.ANDROID_DATA + str);
        C12571m.m75542d(ICBUtil.getLocalTarPath(this.f46217f, str, i10));
        C12571m.m75542d(this.f46218g + "/" + str + ".apk");
        C12571m.m75542d(C12583q.m75685u(str, i10));
        C12571m.m75542d(C12583q.m75678n(str, i10));
        C12571m.m75542d(C12583q.m75679o(str, i10));
        C12571m.m75542d(ICBUtil.getSpecialPath(str));
        if (C13617a.m81938t(this.f46221j.getBackupId(), str, 1, i10)) {
            new C12164f(this.f46221j.getBackupId(), str, 1, i10).close();
            C12571m.m75542d(C13617a.m81942x(this.f46221j.getBackupId(), str, 1, i10));
        }
    }

    /* renamed from: j */
    public void m57830j() throws C9721b {
        this.f46221j.isRelease();
        m57824d(this.f46212a);
        C11839m.m70686d("CloudRestoreV3ModuleRestore", "restoreOneModule execute restoreStatus: " + this.f46212a);
        m57837q(this.f46212a);
    }

    /* renamed from: k */
    public final int m57831k() {
        try {
            String strM60762u = C9733f.m60705z().m60762u("checkAppSignatureOnRestore");
            if (!TextUtils.isEmpty(strM60762u)) {
                return ((Integer) new JSONObject(strM60762u).get("checkPolicy")).intValue();
            }
            C11839m.m70686d("CloudRestoreV3ModuleRestore", "getCheckPolicy checkPolicy is null");
            return 0;
        } catch (Exception e10) {
            C11839m.m70687e("CloudRestoreV3ModuleRestore", "getCheckPolicy error: " + e10.toString());
            return 0;
        }
    }

    /* renamed from: l */
    public final HashSet<String> m57832l(String str) throws JSONException {
        HashSet<String> hashSet = new HashSet<>();
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                String string = ((JSONObject) jSONArray.get(i10)).getString(HwPayConstant.KEY_SIGN);
                if (!TextUtils.isEmpty(string)) {
                    hashSet.add(string);
                }
            }
        } catch (Exception e10) {
            C11839m.m70687e("CloudRestoreV3ModuleRestore", "getCloudSignatures error: " + e10.toString());
        }
        return hashSet;
    }

    /* renamed from: m */
    public final boolean m57833m(CloudRestoreStatusV3 cloudRestoreStatusV3) {
        int status = cloudRestoreStatusV3.getStatus();
        return (status == 4 || status == 5 || status == 6) && cloudRestoreStatusV3.getType() == 1;
    }

    /* renamed from: n */
    public final void m57834n(CloudRestoreStatusV3 cloudRestoreStatusV3) {
        String appId = cloudRestoreStatusV3.getAppId();
        int status = cloudRestoreStatusV3.getStatus();
        int type = cloudRestoreStatusV3.getType();
        if ("HWlanucher".equals(appId)) {
            if (status != 4 && status != 7) {
                if (status == 8) {
                    C11839m.m70688i("CloudRestoreV3ModuleRestore", "sendDoneMsgOrJumpToHwlauncherIfNeed launcher is restore done already, do not restore again");
                    this.f46221j.setLauncherLayoutOk(true);
                    return;
                } else {
                    C11839m.m70688i("CloudRestoreV3ModuleRestore", "sendDoneMsgOrJumpToHwlauncherIfNeed restore launcher failed, set isLauncherLayoutOk true.");
                    this.f46221j.setLauncherLayoutOk(true);
                    this.f46213b = false;
                    this.f46221j.m29808q0(false);
                    return;
                }
            }
            if (type != 1) {
                C11839m.m70688i("CloudRestoreV3ModuleRestore", "sendDoneMsgOrJumpToHwlauncherIfNeed restore launcher failed, set isLauncherLayoutOk true.");
                this.f46221j.setLauncherLayoutOk(true);
                this.f46213b = false;
                this.f46221j.m29808q0(false);
                return;
            }
            C11839m.m70688i("CloudRestoreV3ModuleRestore", "wait jump");
            SystemClock.sleep(RippleView.ONE_PERIOD_TIME);
            if (this.f46221j.isFromOOBE()) {
                return;
            }
            C11839m.m70688i("CloudRestoreV3ModuleRestore", "jump to launcher");
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.HOME");
            intent.setFlags(270532608);
            if (C0209d.m1269j1()) {
                C0209d.m1302r2(intent, "com.hihonor.android.launcher");
            } else {
                C0209d.m1302r2(intent, "com.huawei.android.launcher");
            }
            this.f46216e.startActivity(intent);
        }
    }

    /* renamed from: o */
    public final boolean m57835o(CloudRestoreStatusV3 cloudRestoreStatusV3, RestoreModuleReportInfo restoreModuleReportInfo, String str) throws Throwable {
        this.f46221j.isRelease();
        if (!m57823c(cloudRestoreStatusV3, restoreModuleReportInfo)) {
            return false;
        }
        String appId = cloudRestoreStatusV3.getAppId();
        if (HNConstants.DataType.MEDIA.equals(appId) || "music".equals(appId) || RestoreUtil.isSounderNotNeedCloneRestore(appId)) {
            return false;
        }
        if ("virtual.sync.switch.status".equals(appId) && !C12590s0.m75728B1(str)) {
            m57838r(cloudRestoreStatusV3);
            return false;
        }
        C11839m.m70686d("CloudRestoreV3ModuleRestore", "restoreBegin restoreStatus: " + cloudRestoreStatusV3);
        if (!m57833m(cloudRestoreStatusV3)) {
            return false;
        }
        this.f46221j.isRelease();
        if (cloudRestoreStatusV3.is3rdAppType() && cloudRestoreStatusV3.m29484T() && C0241z.m1685c(cloudRestoreStatusV3.m29494p()) != 1) {
            cloudRestoreStatusV3.setStatus(6).setType(0);
            if (this.f46213b && this.f46214c.contains(cloudRestoreStatusV3.m29470M())) {
                m57840t(cloudRestoreStatusV3, 1);
            }
        }
        this.f46220i.m61975I(cloudRestoreStatusV3);
        return true;
    }

    /* renamed from: p */
    public final void m57836p(CloudRestoreStatusV3 cloudRestoreStatusV3) throws C9721b {
        this.f46221j.isLocalSpaceEnough();
        this.f46221j.isRelease();
        m57839s(this.f46213b, cloudRestoreStatusV3);
        this.f46221j.isRelease();
        String appId = cloudRestoreStatusV3.getAppId();
        int status = cloudRestoreStatusV3.getStatus();
        int type = cloudRestoreStatusV3.getType();
        switch (status) {
            case -8:
            case -7:
            case -6:
            case -5:
            case -4:
            case -3:
            case -1:
            case 1:
                m57829i(appId, cloudRestoreStatusV3.getUid());
                break;
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                if (type == 1) {
                    m57829i(appId, cloudRestoreStatusV3.getUid());
                }
                cloudRestoreStatusV3.setStatus(8);
                break;
        }
        this.f46215d.m76957u(cloudRestoreStatusV3);
        C11839m.m70688i("CloudRestoreV3ModuleRestore", "restore appId = " + cloudRestoreStatusV3.m29468L() + " | restore status = " + cloudRestoreStatusV3.getStatus() + " | restore type = " + cloudRestoreStatusV3.getType() + ", uid = " + cloudRestoreStatusV3.getUid());
        if (status != 3) {
            C11839m.m70686d("CloudRestoreV3ModuleRestore", "restoreEnd");
            this.f46220i.m61975I(cloudRestoreStatusV3);
            return;
        }
        C11839m.m70688i("CloudRestoreV3ModuleRestore", "restore appId = " + appId + " | restore is paused., uid = " + cloudRestoreStatusV3.getUid());
    }

    /* renamed from: q */
    public final void m57837q(CloudRestoreStatusV3 cloudRestoreStatusV3) throws C9721b {
        C11839m.m70688i("CloudRestoreV3ModuleRestore", "start to restore module: " + cloudRestoreStatusV3.getAppId() + " ,uid: " + cloudRestoreStatusV3.getUid());
        RestoreModuleReportInfo restoreModuleReportInfo = new RestoreModuleReportInfo();
        restoreModuleReportInfo.setAppId(cloudRestoreStatusV3.getAppId());
        try {
            try {
                if (m57835o(cloudRestoreStatusV3, restoreModuleReportInfo, this.f46221j.f22517K)) {
                    C12164f c12164f = new C12164f(this.f46221j.getBackupId(), cloudRestoreStatusV3.getAppId(), 1, cloudRestoreStatusV3.getUid());
                    c12164f.m73037G0(0L);
                    if ("V4".equals(this.f46221j.f22517K)) {
                        C9727b c9727b = new C9727b();
                        NextModuleRestore nextModuleRestoreM60678b = c9727b.m60678b(this.f46216e, this.f46221j, cloudRestoreStatusV3);
                        if (nextModuleRestoreM60678b != null) {
                            this.f46221j.isRelease();
                            this.f46215d.m76958v(cloudRestoreStatusV3, 7, 0);
                            this.f46220i.m61975I(cloudRestoreStatusV3);
                            int iOnRestore = nextModuleRestoreM60678b.onRestore(c12164f);
                            this.f46221j.isRelease();
                            c9727b.m60680d(iOnRestore, cloudRestoreStatusV3, this.f46215d);
                        } else {
                            C11839m.m70688i("CloudRestoreV3ModuleRestore", "can not find next module: " + cloudRestoreStatusV3.getAppId());
                        }
                    } else {
                        new C9220j1(this.f46221j, this.f46219h, this.f46215d, this.f46217f, this.f46218g).m57969g(cloudRestoreStatusV3, new a(cloudRestoreStatusV3));
                        new C9260t1(this.f46221j, this.f46220i, this.f46215d).m58255m(cloudRestoreStatusV3, RestoreUtil.prepare(cloudRestoreStatusV3, this.f46221j));
                    }
                }
                m57836p(cloudRestoreStatusV3);
                restoreModuleReportInfo.update(cloudRestoreStatusV3);
                CloudBackupReport.reportSingleModuleRestore(restoreModuleReportInfo, this.f46222k, false, this.f46223l, this.f46224m, this.f46225n, this.f46221j.m29587j());
            } catch (Exception e10) {
                C11839m.m70687e("CloudRestoreV3ModuleRestore", "restore one module error: " + e10.getMessage());
                restoreModuleReportInfo.setErrorReason(e10.getMessage());
                throw e10;
            }
        } catch (Throwable th2) {
            restoreModuleReportInfo.update(cloudRestoreStatusV3);
            CloudBackupReport.reportSingleModuleRestore(restoreModuleReportInfo, this.f46222k, false, this.f46223l, this.f46224m, this.f46225n, this.f46221j.m29587j());
            throw th2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v18, types: [java.io.InputStreamReader, java.io.Reader] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v11, types: [java.io.FileInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* renamed from: r */
    public final void m57838r(CloudRestoreStatusV3 cloudRestoreStatusV3) throws Throwable {
        Closeable closeable;
        Closeable closeable2;
        Closeable closeable3;
        Closeable closeable4;
        C11839m.m70689w("CloudRestoreV3ModuleRestore", "restoreSyncSwitchStatus start");
        ?? sb2 = new StringBuilder();
        sb2.append(this.f46217f);
        String str = File.separator;
        sb2.append(str);
        ?? appId = cloudRestoreStatusV3.getAppId();
        sb2.append(appId);
        sb2.append(str);
        sb2.append("syncswitchstatus.json");
        ?? M63442h = C10278a.m63442h(sb2.toString());
        BufferedReader bufferedReader = null;
        try {
            try {
                appId = new FileInputStream((File) M63442h);
                try {
                    M63442h = new InputStreamReader((InputStream) appId, StandardCharsets.UTF_8);
                    try {
                        BufferedReader bufferedReader2 = new BufferedReader(M63442h);
                        try {
                            String line = bufferedReader2.readLine();
                            C11839m.m70688i("CloudRestoreV3ModuleRestore", "get sync switch status: " + line);
                            RestoreUtil.restoreSyncSwitchData(cloudRestoreStatusV3, (List) new Gson().fromJson(line, new b().getType()));
                            C0209d.m1263i(bufferedReader2);
                            closeable4 = M63442h;
                            closeable3 = appId;
                        } catch (FileNotFoundException e10) {
                            e = e10;
                            bufferedReader = bufferedReader2;
                            C11839m.m70687e("CloudRestoreV3ModuleRestore", "get sync switch status FileNotFoundException: " + e.toString());
                            closeable2 = M63442h;
                            closeable = appId;
                            C0209d.m1263i(bufferedReader);
                            closeable4 = closeable2;
                            closeable3 = closeable;
                            C0209d.m1263i(closeable4);
                            C0209d.m1263i(closeable3);
                            C11839m.m70689w("CloudRestoreV3ModuleRestore", "restoreSyncSwitchStatus end");
                        } catch (IOException e11) {
                            e = e11;
                            bufferedReader = bufferedReader2;
                            C11839m.m70687e("CloudRestoreV3ModuleRestore", "get sync switch status IOException: " + e.toString());
                            closeable2 = M63442h;
                            closeable = appId;
                            C0209d.m1263i(bufferedReader);
                            closeable4 = closeable2;
                            closeable3 = closeable;
                            C0209d.m1263i(closeable4);
                            C0209d.m1263i(closeable3);
                            C11839m.m70689w("CloudRestoreV3ModuleRestore", "restoreSyncSwitchStatus end");
                        } catch (Exception e12) {
                            e = e12;
                            bufferedReader = bufferedReader2;
                            C11839m.m70687e("CloudRestoreV3ModuleRestore", "get sync switch status Exception: " + e.getMessage());
                            closeable2 = M63442h;
                            closeable = appId;
                            C0209d.m1263i(bufferedReader);
                            closeable4 = closeable2;
                            closeable3 = closeable;
                            C0209d.m1263i(closeable4);
                            C0209d.m1263i(closeable3);
                            C11839m.m70689w("CloudRestoreV3ModuleRestore", "restoreSyncSwitchStatus end");
                        } catch (Throwable th2) {
                            th = th2;
                            bufferedReader = bufferedReader2;
                            C0209d.m1263i(bufferedReader);
                            C0209d.m1263i(M63442h);
                            C0209d.m1263i(appId);
                            throw th;
                        }
                    } catch (FileNotFoundException e13) {
                        e = e13;
                    } catch (IOException e14) {
                        e = e14;
                    } catch (Exception e15) {
                        e = e15;
                    }
                } catch (FileNotFoundException e16) {
                    e = e16;
                    M63442h = 0;
                } catch (IOException e17) {
                    e = e17;
                    M63442h = 0;
                } catch (Exception e18) {
                    e = e18;
                    M63442h = 0;
                } catch (Throwable th3) {
                    th = th3;
                    M63442h = 0;
                }
            } catch (FileNotFoundException e19) {
                e = e19;
                M63442h = 0;
                appId = 0;
            } catch (IOException e20) {
                e = e20;
                M63442h = 0;
                appId = 0;
            } catch (Exception e21) {
                e = e21;
                M63442h = 0;
                appId = 0;
            } catch (Throwable th4) {
                th = th4;
                M63442h = 0;
                appId = 0;
            }
            C0209d.m1263i(closeable4);
            C0209d.m1263i(closeable3);
            C11839m.m70689w("CloudRestoreV3ModuleRestore", "restoreSyncSwitchStatus end");
        } catch (Throwable th5) {
            th = th5;
        }
    }

    /* renamed from: s */
    public final void m57839s(boolean z10, CloudRestoreStatusV3 cloudRestoreStatusV3) throws C9721b {
        if (z10) {
            this.f46221j.isRelease();
            m57834n(cloudRestoreStatusV3);
            String appId = cloudRestoreStatusV3.getAppId();
            int status = cloudRestoreStatusV3.getStatus();
            int type = cloudRestoreStatusV3.getType();
            if (this.f46215d.m76944h().contains(cloudRestoreStatusV3)) {
                C11839m.m70688i("CloudRestoreV3ModuleRestore", "sendDoneMsgOrJumpToHwlauncherIfNeed " + appId + " uid: " + cloudRestoreStatusV3.getUid() + " status = " + status + "; type = " + type);
                if (status == 0 || status == 2 || status == 3) {
                    return;
                }
                if (status != 6 && status != 7 && status != 8) {
                    m57840t(cloudRestoreStatusV3, -1);
                } else if (type == 1) {
                    m57840t(cloudRestoreStatusV3, 2);
                } else {
                    m57840t(cloudRestoreStatusV3, -1);
                }
            }
        }
    }

    /* renamed from: t */
    public final void m57840t(CloudRestoreStatusV3 cloudRestoreStatusV3, int i10) {
        if (this.f46212a.isTwinApp()) {
            return;
        }
        ICBBroadcastManager.sendInstallEventBroadcast(this.f46216e, cloudRestoreStatusV3.m29470M(), i10);
    }
}
