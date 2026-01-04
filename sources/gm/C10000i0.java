package gm;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import cl.InterfaceC1452g;
import cm.C1460f;
import com.google.gson.Gson;
import com.huawei.android.backup.filelogic.utils.PmsCheckUtil;
import com.huawei.android.backup.service.utils.C2157a;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.cloudbackup.model.RestoreCache;
import com.huawei.android.hicloud.cloudbackup.process.CloneService;
import com.huawei.android.hicloud.cloudbackup.process.RestoreUtil;
import com.huawei.android.hicloud.cloudbackup.process.util.BackupRestoreOmConfigUtil;
import com.huawei.android.hicloud.cloudbackup.report.CloudBackupReport;
import com.huawei.android.hicloud.cloudbackup.util.ICBUtil;
import com.huawei.cloud.base.util.C4633d0;
import com.huawei.hicloud.cloudbackup.model.CloudRestoreItem;
import com.huawei.hicloud.cloudbackup.p104v3.core.C4880b;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.App;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.AppList;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.Attachment;
import com.huawei.hicloud.cloudbackup.store.database.status.CloudRestoreStatusV3;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import fk.C9721b;
import hm.C10309n0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import p015ak.C0209d;
import p015ak.C0240y;
import p015ak.C0241z;
import p292fn.C9733f;
import p514o9.C11829c;
import p514o9.C11839m;
import p618rm.C12565k;
import p618rm.C12590s0;
import p618rm.C12593t0;
import p814yl.C13998b0;
import p814yl.C14004e0;
import p848zl.C14333b;
import pl.C12164f;
import sl.C12810a;
import sl.C12811b;
import sl.C12816g;
import tl.C13029h;
import tl.C13030i;

/* renamed from: gm.i0 */
/* loaded from: classes6.dex */
public class C10000i0 {

    /* renamed from: a */
    public C4880b f48909a;

    /* renamed from: b */
    public Context f48910b;

    /* renamed from: c */
    public String f48911c;

    /* renamed from: d */
    public String f48912d;

    /* renamed from: e */
    public String f48913e;

    /* renamed from: f */
    public String f48914f;

    /* renamed from: g */
    public boolean f48915g;

    /* renamed from: h */
    public boolean f48916h;

    /* renamed from: i */
    public C1460f f48917i;

    /* renamed from: j */
    public C13029h f48918j;

    /* renamed from: k */
    public boolean f48919k;

    /* renamed from: l */
    public CloneService f48920l = CloneService.getInstance();

    /* renamed from: m */
    public C12816g f48921m = new C12816g();

    /* renamed from: n */
    public C12811b f48922n = new C12811b();

    /* renamed from: o */
    public List<String> f48923o = new ArrayList();

    /* renamed from: p */
    public C14004e0 f48924p = new C14004e0();

    public C10000i0(C4880b c4880b, Context context, String str, String str2, String str3, String str4, boolean z10, boolean z11, C1460f c1460f) {
        this.f48916h = false;
        this.f48919k = true;
        this.f48909a = c4880b;
        this.f48910b = context;
        this.f48911c = str;
        this.f48912d = str2;
        this.f48913e = str3;
        this.f48914f = str4;
        this.f48915g = z10;
        this.f48916h = z11;
        this.f48917i = c1460f;
        this.f48919k = c4880b.m29788W();
        ICBUtil.dealDefaultMoudles(this.f48923o);
    }

    /* renamed from: v */
    public static /* synthetic */ boolean m61994v(CloudRestoreStatusV3 cloudRestoreStatusV3, App app) {
        return TextUtils.equals(app.getAppIdByAppInfo(), cloudRestoreStatusV3.getAppId());
    }

    /* renamed from: w */
    public static /* synthetic */ boolean m61995w(List list, final CloudRestoreStatusV3 cloudRestoreStatusV3) {
        return !list.stream().anyMatch(new Predicate() { // from class: gm.h0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return C10000i0.m61994v(cloudRestoreStatusV3, (App) obj);
            }
        });
    }

    /* renamed from: A */
    public final void m61996A(final List<App> list) throws C9721b {
        List<CloudRestoreStatusV3> listM76945i = this.f48921m.m76945i();
        for (CloudRestoreStatusV3 cloudRestoreStatusV3 : (List) listM76945i.stream().filter(new Predicate() { // from class: gm.g0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return C10000i0.m61995w(list, (CloudRestoreStatusV3) obj);
            }
        }).collect(Collectors.toList())) {
            if (!RestoreUtil.isModuleSuccess(cloudRestoreStatusV3)) {
                cloudRestoreStatusV3.setStatus(-8).setType(2).setCurrent(0).setSubStatus("done");
                C11839m.m70688i("CloudRestoreV3Prepare", "updateDeleteModuleStatus delete module, the appId is:" + cloudRestoreStatusV3.getAppId());
                this.f48921m.m76957u(cloudRestoreStatusV3);
            }
        }
        for (CloudRestoreStatusV3 cloudRestoreStatusV32 : listM76945i) {
            Iterator<App> it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    App next = it.next();
                    if (cloudRestoreStatusV32.is3rdAppType() && TextUtils.equals(next.getAppIdByAppInfo(), cloudRestoreStatusV32.getAppId()) && next.getAppTotalSize().longValue() == 0 && cloudRestoreStatusV32.getSize() != 0 && !RestoreUtil.isModuleSuccess(cloudRestoreStatusV32)) {
                        C11839m.m70688i("CloudRestoreV3Prepare", "updateDeleteModuleStatus delete appSize, the appId is:" + cloudRestoreStatusV32.getAppId());
                        cloudRestoreStatusV32.setStatus(-8).setType(2).setCurrent(0).setSubStatus("done");
                        this.f48921m.m76957u(cloudRestoreStatusV32);
                        break;
                    }
                }
            }
        }
    }

    /* renamed from: B */
    public final void m61997B() throws C9721b {
        List<CloudRestoreStatusV3> listM76945i = this.f48921m.m76945i();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        CloudRestoreStatusV3 cloudRestoreStatusV3 = null;
        int i10 = 0;
        int iM62004j = 0;
        for (CloudRestoreStatusV3 cloudRestoreStatusV32 : listM76945i) {
            if (cloudRestoreStatusV32.is3rdAppType() && !TextUtils.isEmpty(cloudRestoreStatusV32.getData1())) {
                arrayList2.add(cloudRestoreStatusV32.getAppId());
            }
            if (!"HWlanucher".equals(cloudRestoreStatusV32.getAppId())) {
                int status = cloudRestoreStatusV32.getStatus();
                int type = cloudRestoreStatusV32.getType();
                C11839m.m70686d("CloudRestoreV3Prepare", "appId = " + cloudRestoreStatusV32.getAppId() + " status = " + status + " type = " + type);
                switch (status) {
                    case 2:
                        if (cloudRestoreStatusV32.is3rdAppType()) {
                            i10++;
                            break;
                        } else {
                            break;
                        }
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                        iM62004j = m62004j(arrayList, iM62004j, cloudRestoreStatusV32);
                        break;
                    case 8:
                        if (type != 1) {
                            iM62004j = m62004j(arrayList, iM62004j, cloudRestoreStatusV32);
                            break;
                        } else {
                            break;
                        }
                }
            } else {
                cloudRestoreStatusV3 = cloudRestoreStatusV32;
            }
        }
        this.f48909a.m29805n0(arrayList2);
        m62003i(arrayList, cloudRestoreStatusV3, i10, iM62004j);
        this.f48921m.batchReplace(arrayList);
    }

    /* renamed from: d */
    public void m61998d() {
        new C13998b0().m84119P0(this.f48911c, this.f48909a.m29772G(), "resourceScan");
    }

    /* renamed from: e */
    public final List<App> m61999e(String str, String str2, C1460f c1460f, String str3) throws InterruptedException, C9721b {
        C10309n0 c10309n0 = new C10309n0(str3);
        this.f48909a.isCancel();
        AppList appListM63495n = c10309n0.m63495n("nextCursor,apps(backupAppStatus,backupAppName,oriBackupAppName,id,properties,apkType,fileCount,attachments(usage,assetId,versionId,hash,sha256,length,quotaType),packageVersion,appTotalSize,runtimeType,splitApkType)", null, str, str2, c1460f, str3);
        ArrayList arrayList = new ArrayList(appListM63495n.getApps());
        String nextCursor = appListM63495n.getNextCursor();
        while (!TextUtils.isEmpty(nextCursor)) {
            this.f48909a.isCancel();
            AppList appListM63495n2 = c10309n0.m63495n("nextCursor,apps(backupAppStatus,backupAppName,oriBackupAppName,id,properties,apkType,fileCount,attachments(usage,assetId,versionId,hash,sha256,length,quotaType),packageVersion,appTotalSize,runtimeType,splitApkType)", nextCursor, str, str2, c1460f, str3);
            arrayList.addAll(appListM63495n2.getApps());
            nextCursor = appListM63495n2.getNextCursor();
        }
        return arrayList;
    }

    /* renamed from: f */
    public final void m62000f(Bundle bundle) throws C9721b {
        ArrayList<String> stringArrayList;
        if (bundle == null || (stringArrayList = bundle.getStringArrayList("RiskAppPackageNameList")) == null) {
            return;
        }
        Iterator<String> it = stringArrayList.iterator();
        while (it.hasNext()) {
            this.f48921m.m76959w(it.next(), -1, 0, 0, "");
        }
    }

    /* renamed from: g */
    public final void m62001g(CloudRestoreStatusV3 cloudRestoreStatusV3) {
        if (cloudRestoreStatusV3.is3rdAppType() && cloudRestoreStatusV3.m29480R()) {
            cloudRestoreStatusV3.m29484T();
        }
    }

    /* renamed from: h */
    public final void m62002h(CloudRestoreStatusV3 cloudRestoreStatusV3) {
        if (cloudRestoreStatusV3.is3rdAppType() && cloudRestoreStatusV3.m29482S() && cloudRestoreStatusV3.m29484T()) {
            boolean zM13176K = C2157a.m13176K();
            C11839m.m70688i("CloudRestoreV3Prepare", "check harmony support: " + zM13176K + ", appId: " + cloudRestoreStatusV3.getAppId());
            if (zM13176K) {
                return;
            }
            cloudRestoreStatusV3.setStatus(-4);
        }
    }

    /* renamed from: i */
    public final void m62003i(List<CloudRestoreStatusV3> list, CloudRestoreStatusV3 cloudRestoreStatusV3, int i10, int i11) throws C9721b {
        if (cloudRestoreStatusV3 == null) {
            return;
        }
        int type = cloudRestoreStatusV3.getType();
        if (cloudRestoreStatusV3.getStatus() != 8 || type != 1) {
            cloudRestoreStatusV3.setStatus(0).setType(0).setCurrent(0);
            list.add(cloudRestoreStatusV3);
            new C12164f(this.f48909a.getBackupId(), cloudRestoreStatusV3.getAppId(), 1, cloudRestoreStatusV3.getUid()).m73037G0(0L);
        } else {
            if (i11 <= 0 || i10 != 0) {
                return;
            }
            cloudRestoreStatusV3.setStatus(0).setType(0).setCurrent(0);
            list.add(cloudRestoreStatusV3);
            new C12164f(this.f48909a.getBackupId(), cloudRestoreStatusV3.getAppId(), 1, cloudRestoreStatusV3.getUid()).m73037G0(0L);
        }
    }

    /* renamed from: j */
    public final int m62004j(List<CloudRestoreStatusV3> list, int i10, CloudRestoreStatusV3 cloudRestoreStatusV3) {
        cloudRestoreStatusV3.setStatus(0).setType(0).setCurrent(0);
        list.add(cloudRestoreStatusV3);
        return cloudRestoreStatusV3.is3rdAppType() ? i10 + 1 : i10;
    }

    /* renamed from: k */
    public final void m62005k(CloudRestoreStatusV3 cloudRestoreStatusV3, App app) throws C9721b {
        if (C11829c.m70599n0(app.getAttachments())) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<Attachment> it = app.getAttachments().iterator();
        C12810a c12810a = null;
        C12810a c12810a2 = null;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Attachment next = it.next();
            C12810a c12810a3 = new C12810a();
            c12810a3.m76866q(cloudRestoreStatusV3.getAppId()).m76848E(next.getUsage()).m76867r(next.getAssetId()).m76849F(next.getVersionId()).m76847D(cloudRestoreStatusV3.getUid()).m76875z(next.getHash()).m76844A(next.getSha256()).m76845B(next.getLength().longValue()).m76868s(1).m76874y(1);
            if (cloudRestoreStatusV3.is3rdAppType()) {
                boolean z10 = TextUtils.isEmpty(next.getAssetId()) || TextUtils.isEmpty(next.getVersionId());
                if ("apk".equals(next.getUsage())) {
                    c12810a3.m76870u(String.valueOf(next.getQuotaType()));
                    if (!z10) {
                        c12810a = c12810a3;
                    }
                } else if ("icon".equals(next.getUsage()) && !z10) {
                    c12810a2 = c12810a3;
                }
            }
            arrayList.add(c12810a3);
            C11839m.m70688i("CloudRestoreV3Prepare", "attachmentStatus appId: " + c12810a3.m76850a() + ", usage: " + c12810a3.m76864o());
        }
        String str = app.getProperties().get("apkServerPath");
        if (!TextUtils.isEmpty(str) && c12810a == null) {
            C12810a c12810a4 = new C12810a();
            c12810a4.m76866q(cloudRestoreStatusV3.getAppId()).m76848E("apk").m76867r(str).m76874y(0);
            arrayList.add(c12810a4);
            C11839m.m70688i("CloudRestoreV3Prepare", "attachmentStatus appId: " + c12810a4.m76850a() + "contains apkServerPath");
        }
        String str2 = app.getProperties().get("iconServerPath");
        if (!TextUtils.isEmpty(str2) && c12810a2 == null) {
            C12810a c12810a5 = new C12810a();
            c12810a5.m76866q(cloudRestoreStatusV3.getAppId()).m76848E("icon").m76867r(str2).m76874y(0);
            arrayList.add(c12810a5);
            C11839m.m70688i("CloudRestoreV3Prepare", "attachmentStatus appId: " + c12810a5.m76850a() + "contains iconServerPath");
        }
        this.f48922n.batchReplace(arrayList);
    }

    /* renamed from: l */
    public final void m62006l(CloudRestoreStatusV3 cloudRestoreStatusV3, App app, int i10) {
        this.f48924p.m84152d(cloudRestoreStatusV3, app, false, null, "V4".equals(this.f48909a.f22517K));
        m62013s(cloudRestoreStatusV3, app.getRuntimeType().intValue(), app.getProperties());
        cloudRestoreStatusV3.m29465J0(i10);
        if (cloudRestoreStatusV3.is3rdAppType()) {
            Map<String, String> properties = app.getProperties();
            String str = properties.get(FaqConstants.FAQ_EMUIVERSION);
            int iM1685c = C0241z.m1685c(properties.get("backupApkVersion"));
            C11839m.m70688i("CloudRestoreV3Prepare", "createRestoreStatus backupVersionCode " + iM1685c);
            if (cloudRestoreStatusV3.isTwinApp()) {
                boolean zM60720O = C9733f.m60705z().m60720O("backupSupportSplitApp");
                if (!zM60720O) {
                    cloudRestoreStatusV3.setAction(1);
                    cloudRestoreStatusV3.m29460E0(0);
                }
                C11839m.m70688i("CloudRestoreV3Prepare", " appID" + cloudRestoreStatusV3.getAppId() + " backupTwinApp = " + zM60720O);
            }
            if (m62011q(cloudRestoreStatusV3, str, iM1685c)) {
                if (cloudRestoreStatusV3.getAction() == 0) {
                    cloudRestoreStatusV3.m29458C0(String.valueOf(-1));
                }
                cloudRestoreStatusV3.setAction(1);
                cloudRestoreStatusV3.m29460E0(0);
            }
        }
    }

    /* renamed from: m */
    public void m62007m() throws C9721b {
        this.f48909a.isCancel();
        try {
            List<App> listM61999e = m61999e(this.f48912d, this.f48914f, this.f48917i, this.f48911c);
            if (listM61999e.isEmpty()) {
                throw new C9721b(3109, "query record app list return null or empty, record is not exist.", "initRestoreDetails");
            }
            this.f48909a.isCancel();
            C13029h c13029hM78495f = new C13030i().m78495f(3);
            this.f48918j = c13029hM78495f;
            int iM78441G = c13029hM78495f.m78441G();
            if (iM78441G == 0) {
                m62010p(listM61999e);
                m61996A(listM61999e);
            } else {
                if (iM78441G != 1 && iM78441G != 2 && iM78441G != 3) {
                    throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "restore status illegal.", "CloudRestoreV3Prepare");
                }
                if (!this.f48915g) {
                    C11839m.m70689w("CloudRestoreV3Prepare", "not  retry, status error");
                    throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "restore status illegal.", "CloudRestoreV3Prepare");
                }
                C11839m.m70688i("CloudRestoreV3Prepare", "prepare retry");
                m62016x();
                m61996A(listM61999e);
            }
            C11839m.m70688i("CloudRestoreV3Prepare", "IRestorePrepare prepare start:" + this.f48911c);
            InterfaceC1452g.get().forEach(new Consumer() { // from class: gm.f0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.f48903a.m62015u((InterfaceC1452g) obj);
                }
            });
        } catch (C9721b e10) {
            if (e10.m60659c() == 3911 && String.valueOf(e10.m60663g()).endsWith(String.valueOf(4041))) {
                m61998d();
            }
            if (e10.m60659c() != 3922 || !String.valueOf(e10.m60663g()).endsWith(String.valueOf(4041))) {
                throw e10;
            }
            throw new C9721b(3109, "query record app list return source not exist, record is not exist.", "initRestoreDetails");
        }
    }

    /* renamed from: n */
    public final Map<String, CloudRestoreStatusV3> m62008n() {
        HashMap map = new HashMap();
        for (CloudRestoreStatusV3 cloudRestoreStatusV3 : this.f48921m.m76946j()) {
            map.put(cloudRestoreStatusV3.getAppId(), cloudRestoreStatusV3);
        }
        C11839m.m70688i("CloudRestoreV3Prepare", "getActions end, the size is " + map.size());
        return map;
    }

    /* renamed from: o */
    public final void m62009o() throws C9721b {
        this.f48921m.clear();
        this.f48922n.clear();
        C12590s0.m75749G2();
        ArrayList<CloudRestoreItem> restoreItems = RestoreCache.getInstance().getRestoreItems();
        boolean zM60720O = C9733f.m60705z().m60720O("backupSupportSplitApp");
        Iterator<Map.Entry<String, CloudRestoreStatusV3>> it = this.f48924p.m84154f(restoreItems).entrySet().iterator();
        boolean z10 = true;
        while (it.hasNext()) {
            CloudRestoreStatusV3 value = it.next().getValue();
            if (value.getAction() != 2) {
                if (!value.isTwinApp() || zM60720O) {
                    this.f48921m.m76952p(value);
                } else {
                    C11839m.m70688i("CloudRestoreV3Prepare", "initActions , twinAppSwtich close, backupTwinAppSwicth =  " + zM60720O + " , appid = " + value.getAppId());
                }
            }
            z10 = false;
        }
        RestoreCache.getInstance().clearRestoreItems();
        CloudBackupReport.reportRestoreLocalRecord(this.f48918j, z10, this.f48909a.getEntryType(), this.f48909a.m29774I(), this.f48912d);
    }

    /* renamed from: p */
    public final void m62010p(List<App> list) throws InterruptedException, C9721b {
        Bundle bundle;
        Map<String, CloudRestoreStatusV3> map;
        int iM1685c;
        Bundle bundle2;
        this.f48909a.deleteFile();
        this.f48909a.initTempDirs();
        this.f48909a.isCancel();
        m62009o();
        Bundle newDeviceInfo = this.f48920l.getNewDeviceInfo();
        int i10 = newDeviceInfo.getInt("APPRiskFlag");
        ArrayList<String> stringArrayList = newDeviceInfo.getStringArrayList("SupprotedModule");
        if (stringArrayList == null) {
            stringArrayList = new ArrayList<>();
        }
        Bundle bundle3 = newDeviceInfo.getBundle("InstalledAPP");
        stringArrayList.add("virtual.sync.switch.status");
        stringArrayList.add("virtual.hmos.sync.switch.status");
        Map<String, CloudRestoreStatusV3> mapM62008n = m62008n();
        Bundle bundle4 = new Bundle();
        ArrayList arrayList = new ArrayList();
        boolean zM1273k1 = C0209d.m1273k1();
        ArrayList arrayList2 = new ArrayList();
        boolean z10 = true;
        for (App app : list) {
            this.f48909a.isCancel();
            if (app.getBackupAppStatus().intValue() != 0) {
                C11839m.m70688i("CloudRestoreV3Prepare", "app status is not success, not support restore.");
                bundle = bundle3;
                map = mapM62008n;
            } else {
                C12593t0.m75984q(app.getProperties().get("androidLevel"), app.getProperties().get("emuiVersionFull"));
                String backupAppName = app.getBackupAppName();
                CloudRestoreStatusV3 cloudRestoreStatusV3 = mapM62008n.get(backupAppName);
                if (cloudRestoreStatusV3 == null || m62014t(backupAppName, mapM62008n)) {
                    bundle = bundle3;
                    map = mapM62008n;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(cloudRestoreStatusV3 == null ? "the restoreStatus is null." : "the app not select restore");
                    sb2.append(",the appId is:");
                    sb2.append(backupAppName);
                    C11839m.m70688i("CloudRestoreV3Prepare", sb2.toString());
                } else {
                    if (bundle3 == null || (bundle2 = bundle3.getBundle(backupAppName)) == null) {
                        bundle = bundle3;
                        iM1685c = 0;
                    } else {
                        bundle = bundle3;
                        iM1685c = bundle2.getInt("VersionCode");
                    }
                    if (iM1685c == 0 && C14333b.m85476k().contains(backupAppName)) {
                        iM1685c = C0241z.m1685c(C12590s0.m75790R(app.getBackupAppName()));
                    }
                    StringBuilder sb3 = new StringBuilder();
                    map = mapM62008n;
                    sb3.append("initRestoreDetails appId = ");
                    sb3.append(backupAppName);
                    sb3.append(", appType = ");
                    sb3.append(cloudRestoreStatusV3.getAppType());
                    sb3.append(", localVersionCode = ");
                    sb3.append(iM1685c);
                    C11839m.m70686d("CloudRestoreV3Prepare", sb3.toString());
                    m62006l(cloudRestoreStatusV3, app, iM1685c);
                    m62005k(cloudRestoreStatusV3, app);
                    if ("Memo".equalsIgnoreCase(backupAppName)) {
                        cloudRestoreStatusV3.m29508z0(app.getProperties().get("memoCloneFlag"));
                    }
                    if ("safebox".equalsIgnoreCase(backupAppName) || "safebox1".equalsIgnoreCase(backupAppName)) {
                        cloudRestoreStatusV3.m29508z0(app.getProperties().get("safeboxdataintegrity"));
                    }
                    m62017y(cloudRestoreStatusV3, app.getProperties());
                    if (cloudRestoreStatusV3.getBmAppDataType() == 0) {
                        z10 = false;
                    }
                    if (cloudRestoreStatusV3.is3rdAppType()) {
                        String str = app.getProperties().get("isFileDiff");
                        if (Boolean.valueOf(str).booleanValue()) {
                            cloudRestoreStatusV3.m29508z0(str);
                            arrayList2.add(backupAppName);
                        }
                    }
                    if (m62012r(backupAppName, stringArrayList)) {
                        cloudRestoreStatusV3.setStatus(-1);
                        if ("Memo".equalsIgnoreCase(backupAppName) && !C0240y.m1682d(this.f48910b, "com.example.android.notepad")) {
                            cloudRestoreStatusV3.setStatus(-5);
                        }
                        C11839m.m70688i("CloudRestoreV3Prepare", "The app is unSupport restore module , appId is:" + backupAppName + ", status:" + cloudRestoreStatusV3.getStatus());
                    }
                    if (zM1273k1 && C14333b.f63656h.contains(app.getBackupAppName())) {
                        cloudRestoreStatusV3.setStatus(-1);
                    }
                    m62001g(cloudRestoreStatusV3);
                    m62002h(cloudRestoreStatusV3);
                    if (cloudRestoreStatusV3.is3rdAppType()) {
                        bundle4.putInt(backupAppName, cloudRestoreStatusV3.getVersionCode());
                    }
                    m62018z(cloudRestoreStatusV3, app);
                    arrayList.add(cloudRestoreStatusV3);
                }
            }
            bundle3 = bundle;
            mapM62008n = map;
        }
        this.f48921m.batchReplace(arrayList);
        this.f48918j.m78458X(z10 ? "1" : "");
        if (i10 == 1 && !bundle4.isEmpty()) {
            m62000f(this.f48920l.checkAppRiskInfo(bundle4));
        }
        this.f48909a.m29805n0(arrayList2);
        this.f48909a.isCancel();
        this.f48909a.updateTagsStatus(1);
        C11839m.m70688i("CloudRestoreV3Prepare", "initRestoreDetails end:" + this.f48911c);
    }

    /* renamed from: q */
    public final boolean m62011q(CloudRestoreStatusV3 cloudRestoreStatusV3, String str, int i10) {
        boolean zM12611e = PmsCheckUtil.m12611e();
        BackupRestoreOmConfigUtil backupRestoreOmConfigUtil = new BackupRestoreOmConfigUtil(this.f48914f, str);
        String strM29470M = cloudRestoreStatusV3.m29470M();
        boolean zIsMatchDevCompatible = backupRestoreOmConfigUtil.isMatchDevCompatible(this.f48913e, strM29470M);
        boolean zIsMatchRestoreConfig = backupRestoreOmConfigUtil.isMatchRestoreConfig(strM29470M, i10);
        boolean z10 = cloudRestoreStatusV3.getAction() == 1;
        C11839m.m70688i("CloudRestoreV3Prepare", "isSupportPMS = " + zM12611e + ", isMatchDevCompatible = " + zIsMatchDevCompatible + ", isMatchRestoreConfig = " + zIsMatchRestoreConfig + ", isPartSupport = " + z10);
        return !zM12611e || zIsMatchDevCompatible || zIsMatchRestoreConfig || z10;
    }

    /* renamed from: r */
    public final boolean m62012r(String str, List<String> list) {
        return this.f48923o.contains(str) && !list.contains(str);
    }

    /* renamed from: s */
    public final void m62013s(CloudRestoreStatusV3 cloudRestoreStatusV3, int i10, Map<String, String> map) {
        String appId = cloudRestoreStatusV3.getAppId();
        cloudRestoreStatusV3.setStatus(0);
        if (C2157a.m13200h().contains(appId)) {
            C11839m.m70688i("CloudRestoreV3Prepare", "app blackName " + appId + " not support to restore");
            cloudRestoreStatusV3.setStatus(-1);
        }
        if (i10 == 3 && !C12565k.m75525k()) {
            C11839m.m70688i("CloudRestoreV3Prepare", "maple app " + appId + " not support to restore");
            cloudRestoreStatusV3.setStatus(-1);
        }
        if (!this.f48919k && C14333b.m85484s().contains(appId)) {
            C11839m.m70688i("CloudRestoreV3Prepare", "Google Gms not Installed, " + appId + " not support to restore");
            cloudRestoreStatusV3.setStatus(-1);
        }
        if (C14333b.m85454J().contains(appId)) {
            C11839m.m70688i("CloudRestoreV3Prepare", "system app, " + appId + " not support to restore");
            cloudRestoreStatusV3.setStatus(-1);
        }
        if (cloudRestoreStatusV3.is3rdAppType()) {
            String str = map.get("ohosArk");
            if (C4633d0.m28404a(str) || !str.equals(String.valueOf(1))) {
                return;
            }
            if (!C12565k.m75526l()) {
                C11839m.m70688i("CloudRestoreV3Prepare", "ohos ark app " + appId + " not support to restore");
                cloudRestoreStatusV3.setStatus(-1);
                return;
            }
            if (C12565k.m75527m(map.get("ohosArkVersion"))) {
                return;
            }
            C11839m.m70688i("CloudRestoreV3Prepare", "ohos ark app " + appId + " not support to restore");
            cloudRestoreStatusV3.setStatus(-1);
        }
    }

    /* renamed from: t */
    public final boolean m62014t(String str, Map<String, CloudRestoreStatusV3> map) {
        CloudRestoreStatusV3 cloudRestoreStatusV3 = map.get(str);
        if (!"wifiConfig".equals(str)) {
            return cloudRestoreStatusV3 != null && cloudRestoreStatusV3.getAction() == 2;
        }
        C11839m.m70688i("CloudRestoreV3Prepare", "user do not choose restore appId = " + str);
        return true;
    }

    /* renamed from: u */
    public final /* synthetic */ void m62015u(InterfaceC1452g interfaceC1452g) {
        interfaceC1452g.mo7504l(this.f48909a.m29783R(), this.f48909a.m29775J(), this.f48909a.mo29591n(), 1);
    }

    /* renamed from: x */
    public final void m62016x() throws C9721b {
        boolean z10 = !C0209d.m1206R1(this.f48910b);
        C11839m.m70688i("CloudRestoreV3Prepare", "prepareRetry check isOOBE = " + z10);
        if (z10) {
            this.f48909a.m29806o0(1);
        } else if (this.f48909a.getEntryType() == 0 || this.f48909a.getEntryType() == 1) {
            this.f48909a.m29806o0(2);
        }
        C12590s0.m75749G2();
        if (this.f48916h) {
            C11839m.m70688i("CloudRestoreV3Prepare", "prepareRetry isResumeRetry = true, return.");
        } else {
            m61997B();
        }
    }

    /* renamed from: y */
    public final void m62017y(CloudRestoreStatusV3 cloudRestoreStatusV3, Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return;
        }
        HashMap map2 = new HashMap();
        String orDefault = map.getOrDefault("signatures", "");
        if (!TextUtils.isEmpty(orDefault)) {
            map2.put("signatures", orDefault);
        }
        String orDefault2 = map.getOrDefault("isCitOpt", "");
        if (!TextUtils.isEmpty(orDefault2)) {
            map2.put("isCitOpt", orDefault2);
        }
        if (map2.size() == 0) {
            return;
        }
        cloudRestoreStatusV3.m29471M0(C12590s0.m75846e2(map2));
    }

    /* renamed from: z */
    public final void m62018z(CloudRestoreStatusV3 cloudRestoreStatusV3, App app) {
        C12810a c12810aM76879d;
        if (cloudRestoreStatusV3.is3rdAppType()) {
            HashMap map = new HashMap();
            Map<String, String> properties = app.getProperties();
            String str = properties.get(CloudBackupConstant.ReportAppMarket.KEY_SUB_SOURCE);
            if ((TextUtils.isEmpty(str) || "null".equals(str) || "com.huawei.hidisk".equals(str)) && (c12810aM76879d = this.f48922n.m76879d(cloudRestoreStatusV3.getAppId(), "apk")) != null && c12810aM76879d.m76854e().equals(String.valueOf(3))) {
                C11839m.m70688i("CloudRestoreV3Prepare", "subSource is hidisk or null and app is standed");
                str = "com.huawei.appmarket";
            }
            String str2 = properties.get(CloudBackupConstant.ReportAppMarket.KEY_PKG_CHANNEL_ID);
            map.put(CloudBackupConstant.ReportAppMarket.KEY_SUB_SOURCE, str);
            map.put(CloudBackupConstant.ReportAppMarket.KEY_PKG_CHANNEL_ID, str2);
            cloudRestoreStatusV3.m29459D0(new Gson().toJson(map));
        }
    }
}
