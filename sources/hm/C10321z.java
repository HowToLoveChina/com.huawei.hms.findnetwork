package hm;

import android.text.TextUtils;
import android.util.Pair;
import cm.C1457c;
import com.huawei.android.hicloud.cloudbackup.bean.BackupLockParams;
import com.huawei.cloud.base.http.C4609l;
import com.huawei.cloud.base.util.C4627a0;
import com.huawei.cloud.base.util.C4644l;
import com.huawei.hicloud.base.drive.model.ErrorResp;
import com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request;
import com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Server;
import com.huawei.hicloud.cloudbackup.p104v3.server.batch.CloudBackupV3BatchCallback;
import com.huawei.hicloud.cloudbackup.p104v3.server.batch.CloudBackupV3BatchRequest;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.App;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.AppCreate;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.AppFinish;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.AppRefresh;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.Asset;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.Bak;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.BakFinish;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.BakRefresh;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.DeviceConditionReport;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.File;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.FileAttachment;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.FileCreate;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.FileReuse;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.Lock;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.LockCreate;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.LockKeepResult;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.RevisionCreate;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.RevisionFinish;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.RevisionRefresh;
import com.huawei.hicloud.cloudbackup.p104v3.server.request.Backup;
import com.huawei.hicloud.cloudbackup.p104v3.server.request.Bak;
import com.huawei.hicloud.cloudbackup.p104v3.server.request.File;
import com.huawei.hicloud.cloudbackup.p104v3.server.request.Revisions;
import com.huawei.hicloud.cloudbackup.store.database.status.CloudBackupStatus;
import com.huawei.hicloud.request.cbs.bean.CBSBaseReq;
import com.huawei.openalliance.p169ad.constant.VastAttribute;
import com.huawei.uikit.hwdatepicker.utils.HwConstants;
import fk.C9721b;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import p015ak.C0209d;
import p015ak.C0241z;
import p292fn.C9733f;
import p429kk.C11058a;
import p495nm.C11722c;
import p495nm.C11732m;
import p514o9.C11839m;
import p618rm.C12535a;
import p618rm.C12590s0;
import p814yl.C14000c0;
import p815ym.AbstractC14026a;
import tl.C13029h;
import tl.C13030i;

/* renamed from: hm.z */
/* loaded from: classes6.dex */
public class C10321z {

    /* renamed from: a */
    public String f49986a;

    /* renamed from: b */
    public Integer f49987b;

    /* renamed from: c */
    public String f49988c;

    /* renamed from: d */
    public Integer f49989d;

    /* renamed from: e */
    public String f49990e;

    /* renamed from: f */
    public String f49991f;

    /* renamed from: hm.z$a */
    public static class a extends CloudBackupV3BatchCallback<App> {

        /* renamed from: a */
        public final Consumer<App> f49992a;

        /* renamed from: b */
        public final String f49993b;

        /* renamed from: c */
        public final List<C9721b> f49994c;

        public a(String str, Consumer<App> consumer, List<C9721b> list) {
            this.f49993b = str;
            this.f49992a = consumer;
            this.f49994c = list;
        }

        @Override // com.huawei.hicloud.cloudbackup.p104v3.server.batch.CloudBackupV3BatchCallback, p369ii.InterfaceC10510a
        /* renamed from: a */
        public void onSuccess(App app, C4609l c4609l) throws IOException {
            this.f49992a.accept(app);
        }

        @Override // com.huawei.hicloud.cloudbackup.p104v3.server.batch.CloudBackupV3BatchCallback
        public void onFailure(ErrorResp.Error error, C4609l c4609l) throws IOException {
            List<ErrorResp.ErrorMsg> errorDetail = error.getErrorDetail();
            if (errorDetail == null || errorDetail.isEmpty()) {
                this.f49994c.add(new C9721b(3911, VastAttribute.ERROR, this.f49993b));
            }
            this.f49994c.add(new C9721b(3911, errorDetail.get(0).toString(), this.f49993b));
        }
    }

    public C10321z(String str, Integer num, String str2, String str3, String str4) {
        this.f49986a = str;
        this.f49987b = num;
        this.f49988c = str2;
        this.f49990e = str3;
        this.f49991f = str4;
    }

    /* renamed from: C0 */
    public static void m63502C0(Asset asset, C14000c0<Asset> c14000c0) {
        if (c14000c0.m84142e() == null) {
            C11839m.m70689w("CloudBackupV3Service", "request.getLastResponseHeaders() == null");
            return;
        }
        String strM28237v = c14000c0.m84142e().m28237v("x-hw-quicswitch");
        if (TextUtils.isEmpty(strM28237v)) {
            C11839m.m70689w("CloudBackupV3Service", "isUseQuic isEmpty");
            return;
        }
        C11839m.m70686d("CloudBackupV3Service", "saveQuicSwitchHeader : " + strM28237v);
        asset.setQuicSwitch(strM28237v);
    }

    /* renamed from: E0 */
    public static C9721b m63503E0(ErrorResp.Error error, C9721b c9721b) {
        List<ErrorResp.ErrorMsg> errorDetail;
        if (error == null || (errorDetail = error.getErrorDetail()) == null || errorDetail.isEmpty()) {
            return c9721b;
        }
        String errorCode = errorDetail.get(0).getErrorCode();
        int iIntValue = error.getCode().intValue();
        String description = error.getDescription();
        return (iIntValue == 400 && errorCode.endsWith(String.valueOf(4004)) && description.contains("lock not found")) ? new C9721b(3923, 4004, "lock not found") : (iIntValue == 403 && errorCode.endsWith(String.valueOf(4959))) ? new C9721b(3920, 4959, "server is deleting.") : (iIntValue == 404 && errorCode.endsWith(String.valueOf(4041))) ? new C9721b(3922, 4041, "server source not exist.") : (iIntValue == 400 && errorCode.endsWith(String.valueOf(4002))) ? (description.contains("fileSize exceeds the maximum") || description.contains("fileSize less than the minimum")) ? new C9721b(3927, 4935, "file size exceeds threshold.") : new C9721b(3942, 4002, "server source forbidden.") : (iIntValue == 400 && errorCode.endsWith(String.valueOf(4004))) ? new C9721b(3922, 4004, "server source expired.") : (iIntValue == 400 && errorCode.endsWith(String.valueOf(51004919))) ? new C9721b(3933, 51004919, "server create divide not support") : iIntValue == 400 ? (errorCode.endsWith(String.valueOf(51004920)) || errorCode.endsWith(String.valueOf(51004916))) ? new C9721b(3933, C0241z.m1685c(errorCode), "server create divide error") : c9721b : c9721b;
    }

    /* renamed from: Y */
    public static /* synthetic */ void m63504Y(Consumer consumer, Pair pair, App app) {
        consumer.accept(new Pair(app, (CloudBackupStatus) ((Pair) pair.second).first));
    }

    /* renamed from: Z */
    public static /* synthetic */ void m63505Z(Consumer consumer, Pair pair, App app) {
        consumer.accept(new Pair(app, (CloudBackupStatus) pair.first));
    }

    /* renamed from: a0 */
    public static /* synthetic */ void m63507a0(Consumer consumer, Pair pair, App app) {
        consumer.accept(new Pair(app, (CloudBackupStatus) pair.first));
    }

    /* renamed from: b0 */
    public static /* synthetic */ void m63509b0(Consumer consumer, Pair pair, App app) {
        consumer.accept(new Pair(app, (CloudBackupStatus) pair.first));
    }

    /* renamed from: c0 */
    public static /* synthetic */ CloudBackupV3Request m63511c0(DeviceConditionReport deviceConditionReport, String str, CloudBackupV3Server cloudBackupV3Server) throws IOException {
        Backup.Device.ConditionReport conditionReport = cloudBackupV3Server.backup().device().conditionReport(deviceConditionReport);
        conditionReport.setBackupDeviceId(str);
        return conditionReport;
    }

    /* renamed from: A */
    public void m63534A(C1457c c1457c, String str, String str2, List<Pair<CloudBackupStatus, AppCreate>> list, final Consumer<Pair<App, CloudBackupStatus>> consumer) throws C9721b {
        Lock lockMo8329d = c1457c.mo8329d();
        if (lockMo8329d == null) {
            throw new C9721b(HwConstants.LUNAR_YEAR_MIN, "lock is invalid", "Backup.device.bak.app.create");
        }
        CloudBackupV3BatchRequest cloudBackupV3BatchRequest = new CloudBackupV3BatchRequest();
        String lockId = lockMo8329d.getLockId();
        ArrayList arrayList = new ArrayList();
        for (final Pair<CloudBackupStatus, AppCreate> pair : list) {
            m63556S(this.f49986a, str, str2, (AppCreate) pair.second, "id", lockId).m84143f(cloudBackupV3BatchRequest, new a("Backup.device.bak.app.create", new Consumer() { // from class: hm.p
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    C10321z.m63505Z(consumer, pair, (App) obj);
                }
            }, arrayList));
        }
        cloudBackupV3BatchRequest.execute("Backup.device.bak.app.create", this.f49991f);
        if (arrayList.size() <= 0) {
            return;
        }
        C11839m.m70687e("CloudBackupV3Service", "batchCreate exception: " + ((C9721b) arrayList.get(0)).getMessage());
        throw ((C9721b) arrayList.get(0));
    }

    /* renamed from: A0 */
    public Bak m63535A0(C1457c c1457c, final String str, final String str2, final BakRefresh bakRefresh, int i10, Lock lock) throws C9721b {
        Lock lockMo8329d = c1457c != null ? c1457c.mo8329d() : lock;
        if (lockMo8329d == null) {
            throw new C9721b(HwConstants.LUNAR_YEAR_MIN, "lock is invalid", "Backup.device.bak.app.delete");
        }
        final String lockId = lockMo8329d.getLockId();
        C11839m.m70688i("CloudBackupV3Service", "content is: " + bakRefresh.getAppsUnbacked());
        final String str3 = "id,backupStatus";
        C14000c0 c14000c0 = new C14000c0(new C14000c0.a() { // from class: hm.u
            @Override // p814yl.C14000c0.a
            /* renamed from: a */
            public final CloudBackupV3Request mo1697a(CloudBackupV3Server cloudBackupV3Server) {
                return this.f49961a.m63579u0(bakRefresh, str3, str, str2, lockId, cloudBackupV3Server);
            }
        });
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("traceId: ");
            sb2.append(this.f49991f);
            sb2.append(", bakId: ");
            try {
                sb2.append(str2);
                sb2.append(", deviceId= ");
                sb2.append(C12590s0.m75916w0(str));
                sb2.append(", request is :");
                sb2.append(c14000c0);
                C11839m.m70688i("CloudBackupV3Service", sb2.toString());
                return (Bak) c14000c0.m84139b("Backup.device.bak.refresh", this.f49991f);
            } catch (C9721b e10) {
                e = e10;
                C9721b c9721bM63503E0 = m63503E0(c14000c0.m84140c(), e);
                if (c9721bM63503E0.m60659c() != 3923 || i10 >= 1 || c1457c == null || !c1457c.mo8332g(e, lockId)) {
                    throw c9721bM63503E0;
                }
                return m63535A0(c1457c, str, str2, bakRefresh, i10 + 1, lock);
            }
        } catch (C9721b e11) {
            e = e11;
        }
    }

    /* renamed from: B */
    public void m63536B(C1457c c1457c, String str, String str2, List<Pair<CloudBackupStatus, AppFinish>> list, final Consumer<Pair<App, CloudBackupStatus>> consumer) throws C9721b {
        Lock lockMo8329d = c1457c.mo8329d();
        if (lockMo8329d == null) {
            throw new C9721b(HwConstants.LUNAR_YEAR_MIN, "lock is invalid", "Backup.device.bak.app.create");
        }
        CloudBackupV3BatchRequest cloudBackupV3BatchRequest = new CloudBackupV3BatchRequest();
        String lockId = lockMo8329d.getLockId();
        ArrayList arrayList = new ArrayList();
        for (final Pair<CloudBackupStatus, AppFinish> pair : list) {
            CloudBackupStatus cloudBackupStatus = (CloudBackupStatus) pair.first;
            m63557T(str, str2, cloudBackupStatus.m29398d1(), cloudBackupStatus.m29870d(), cloudBackupStatus.m29861N(), (AppFinish) pair.second, "id,createTime,updateTime,backupAppStatus,attachments(quotaType,usage)", lockId).m84143f(cloudBackupV3BatchRequest, new a("Backup.device.bak.app.finish", new Consumer() { // from class: hm.o
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    C10321z.m63507a0(consumer, pair, (App) obj);
                }
            }, arrayList));
        }
        cloudBackupV3BatchRequest.execute("Backup.device.bak.app.finish", this.f49991f);
        if (arrayList.size() <= 0) {
            return;
        }
        C11839m.m70687e("CloudBackupV3Service", "batchFinish exception: " + ((C9721b) arrayList.get(0)).getMessage());
        throw ((C9721b) arrayList.get(0));
    }

    /* renamed from: B0 */
    public void m63537B0(C1457c c1457c, final String str, final String str2, final FileReuse fileReuse, final String str3, int i10, int i11) throws C9721b {
        Lock lockMo8329d = c1457c.mo8329d();
        if (lockMo8329d == null) {
            throw new C9721b(HwConstants.LUNAR_YEAR_MIN, "lock is invalid", "Backup.device.file.reuse");
        }
        final String lockId = lockMo8329d.getLockId();
        C14000c0 c14000c0 = new C14000c0(new C14000c0.a() { // from class: hm.h
            @Override // p814yl.C14000c0.a
            /* renamed from: a */
            public final CloudBackupV3Request mo1697a(CloudBackupV3Server cloudBackupV3Server) {
                return this.f49859a.m63580v0(fileReuse, str, lockId, str3, str2, cloudBackupV3Server);
            }
        });
        try {
            c14000c0.m84139b("Backup.device.file.reuse", this.f49991f);
        } catch (C9721b e10) {
            C9721b c9721bM63503E0 = m63503E0(c14000c0.m84140c(), e10);
            if (c9721bM63503E0.m60659c() != 3923 || i11 >= 1 || !c1457c.mo8332g(e10, lockId)) {
                throw c9721bM63503E0;
            }
            m63537B0(c1457c, str, str2, fileReuse, str3, i10, i11 + 1);
        }
    }

    /* renamed from: C */
    public void m63538C(C1457c c1457c, String str, String str2, List<Pair<CloudBackupStatus, AppRefresh>> list, final Consumer<Pair<App, CloudBackupStatus>> consumer) throws C9721b {
        Lock lockMo8329d = c1457c.mo8329d();
        if (lockMo8329d == null) {
            throw new C9721b(HwConstants.LUNAR_YEAR_MIN, "lock is invalid", "Backup.device.bak.app.refresh");
        }
        String lockId = lockMo8329d.getLockId();
        CloudBackupV3BatchRequest cloudBackupV3BatchRequest = new CloudBackupV3BatchRequest();
        ArrayList arrayList = new ArrayList();
        for (final Pair<CloudBackupStatus, AppRefresh> pair : list) {
            CloudBackupStatus cloudBackupStatus = (CloudBackupStatus) pair.first;
            m63558U(str, str2, cloudBackupStatus.m29398d1(), cloudBackupStatus.m29870d(), cloudBackupStatus.m29861N(), (AppRefresh) pair.second, lockMo8329d, "id,createTime,updateTime,backupAppStatus", lockId).m84143f(cloudBackupV3BatchRequest, new a("Backup.device.bak.app.refresh", new Consumer() { // from class: hm.q
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    C10321z.m63509b0(consumer, pair, (App) obj);
                }
            }, arrayList));
            lockMo8329d = lockMo8329d;
        }
        cloudBackupV3BatchRequest.execute("Backup.device.bak.app.refresh", this.f49991f);
        if (arrayList.size() <= 0) {
            return;
        }
        C11839m.m70687e("CloudBackupV3Service", "batchCreate exception: " + ((C9721b) arrayList.get(0)).getMessage());
        throw ((C9721b) arrayList.get(0));
    }

    /* renamed from: D */
    public void m63539D(String str, List<Map<String, String>> list) throws C9721b {
        if (TextUtils.isEmpty(str) && (list == null || list.isEmpty())) {
            throw new C9721b(HwConstants.LUNAR_YEAR_MIN, "conditionReport timeWindow and transBandwidths all empty", "Backup.device.conditionReport");
        }
        String strM75747G0 = C12590s0.m75747G0();
        if (TextUtils.isEmpty(strM75747G0)) {
            throw new C9721b(HwConstants.LUNAR_YEAR_MIN, "conditionReport gradeCode is empty", "Backup.device.conditionReport");
        }
        C13030i c13030i = new C13030i();
        C13029h c13029hM78495f = c13030i.m78495f(2);
        if (c13029hM78495f == null) {
            c13029hM78495f = c13030i.m78495f(1);
        }
        final String strM75786Q = C12590s0.m75786Q(c13029hM78495f);
        if (TextUtils.isEmpty(strM75786Q)) {
            strM75786Q = "backupDeviceIdV1V2";
        }
        final DeviceConditionReport deviceConditionReport = new DeviceConditionReport();
        deviceConditionReport.setGradeCode(strM75747G0).setTimeWindow(str).setTransBandwidths(list);
        new C14000c0(new C14000c0.a() { // from class: hm.s
            @Override // p814yl.C14000c0.a
            /* renamed from: a */
            public final CloudBackupV3Request mo1697a(CloudBackupV3Server cloudBackupV3Server) {
                return C10321z.m63511c0(deviceConditionReport, strM75786Q, cloudBackupV3Server);
            }
        }).m84139b("Backup.device.conditionReport", C11058a.m66627b("02309"));
    }

    /* renamed from: D0 */
    public void m63540D0(Integer num) {
        this.f49989d = num;
    }

    /* renamed from: E */
    public App m63541E(C1457c c1457c, String str, String str2, String str3, String str4, AppCreate appCreate, String str5, int i10) throws C9721b {
        Lock lockMo8329d = c1457c.mo8329d();
        if (lockMo8329d == null) {
            throw new C9721b(HwConstants.LUNAR_YEAR_MIN, "lock is invalid", "Backup.device.bak.app.copy");
        }
        String str6 = "1".equals(this.f49988c) ? "id,attachments,properties,reuseFileCheck" : "id,attachments,properties";
        String lockId = lockMo8329d.getLockId();
        C14000c0<App> c14000c0M63555R = m63555R(str, str2, str3, str4, appCreate, str6, lockId, str5);
        try {
            return c14000c0M63555R.m84139b("Backup.device.bak.app.copy", this.f49991f);
        } catch (C9721b e10) {
            C9721b c9721bM63503E0 = m63503E0(c14000c0M63555R.m84140c(), e10);
            if (c9721bM63503E0.m60659c() == 3923 && i10 < 1 && c1457c.mo8332g(e10, lockId)) {
                return m63541E(c1457c, str, str2, str3, str4, appCreate, str5, i10 + 1);
            }
            throw c9721bM63503E0;
        }
    }

    /* renamed from: F */
    public App m63542F(C1457c c1457c, String str, String str2, AppCreate appCreate, int i10) throws C9721b {
        Lock lockMo8329d = c1457c.mo8329d();
        if (lockMo8329d == null) {
            throw new C9721b(HwConstants.LUNAR_YEAR_MIN, "lock is invalid", "Backup.device.bak.app.create");
        }
        String str3 = "1".equals(this.f49988c) ? "id,reuseFileCheck" : "id";
        String lockId = lockMo8329d.getLockId();
        C14000c0<App> c14000c0M63556S = m63556S(this.f49986a, str, str2, appCreate, str3, lockId);
        try {
            return c14000c0M63556S.m84139b("Backup.device.bak.app.create", this.f49991f);
        } catch (C9721b e10) {
            C9721b c9721bM63503E0 = m63503E0(c14000c0M63556S.m84140c(), e10);
            if (c9721bM63503E0.m60659c() == 3923 && i10 < 1 && c1457c.mo8332g(e10, lockId)) {
                return m63542F(c1457c, str, str2, appCreate, i10 + 1);
            }
            throw c9721bM63503E0;
        }
    }

    /* renamed from: F0 */
    public void m63543F0(final C11722c c11722c) throws C9721b {
        if (c11722c == null || TextUtils.isEmpty(c11722c.m69930g())) {
            throw new C9721b(3911, "request Backup.Lock.get, grade code isEmpty", "Backup.Lock.get");
        }
        try {
            new C14000c0(new C14000c0.a() { // from class: hm.b
                @Override // p814yl.C14000c0.a
                /* renamed from: a */
                public final CloudBackupV3Request mo1697a(CloudBackupV3Server cloudBackupV3Server) {
                    return this.f49772a.m63581w0(c11722c, cloudBackupV3Server);
                }
            }).m84139b("Backup.Lock.vbackup.get", this.f49991f);
        } catch (C9721b e10) {
            if (e10.m60659c() != 3925) {
                throw e10;
            }
        }
    }

    /* renamed from: G */
    public Asset m63544G(C1457c c1457c, final String str, final String str2, final String str3, final RevisionCreate revisionCreate, final FileAttachment fileAttachment, final String str4, int i10, final String str5, int i11) throws C9721b {
        Lock lockMo8329d = c1457c.mo8329d();
        if (lockMo8329d == null) {
            throw new C9721b(HwConstants.LUNAR_YEAR_MIN, "lock is invalid", "Backup.asset.create");
        }
        final String lockId = lockMo8329d.getLockId();
        final String str6 = "id,versionId,state,resource(id,state,sliceSize,objects(id,number,start,length))";
        C14000c0 c14000c0 = new C14000c0(new C14000c0.a() { // from class: hm.i
            @Override // p814yl.C14000c0.a
            /* renamed from: a */
            public final CloudBackupV3Request mo1697a(CloudBackupV3Server cloudBackupV3Server) {
                return this.f49867a.m63563e0(revisionCreate, str6, str, str2, str3, lockId, str4, str5, fileAttachment, cloudBackupV3Server);
            }
        });
        try {
            return (Asset) c14000c0.m84139b("Backup.asset.create", this.f49991f);
        } catch (C9721b e10) {
            C9721b c9721bM63503E0 = m63503E0(c14000c0.m84140c(), e10);
            if (c9721bM63503E0.m60659c() == 3923 && i11 < 1 && c1457c.mo8332g(e10, lockId)) {
                return m63544G(c1457c, str, str2, str3, revisionCreate, fileAttachment, str4, i10, str5, i11 + 1);
            }
            throw c9721bM63503E0;
        }
    }

    /* renamed from: H */
    public Asset m63545H(C1457c c1457c, final String str, final String str2, final String str3, final String str4, final RevisionCreate revisionCreate, final FileAttachment fileAttachment, final String str5, int i10, final String str6, int i11) throws C9721b {
        Lock lockMo8329d = c1457c.mo8329d();
        if (lockMo8329d == null) {
            throw new C9721b(HwConstants.LUNAR_YEAR_MIN, "lock is invalid", "Backup.asset.revisions.create");
        }
        final String lockId = lockMo8329d.getLockId();
        final String str7 = "id,versionId,state,resource(id,state,sliceSize,objects(id,number,start,length))";
        C14000c0 c14000c0 = new C14000c0(new C14000c0.a() { // from class: hm.g
            @Override // p814yl.C14000c0.a
            /* renamed from: a */
            public final CloudBackupV3Request mo1697a(CloudBackupV3Server cloudBackupV3Server) {
                return this.f49840a.m63564f0(revisionCreate, str7, str2, str3, str4, lockId, str5, str6, str, fileAttachment, cloudBackupV3Server);
            }
        });
        try {
            return (Asset) c14000c0.m84139b("Backup.asset.revisions.create", this.f49991f);
        } catch (C9721b e10) {
            C9721b c9721bM63503E0 = m63503E0(c14000c0.m84140c(), e10);
            if (c9721bM63503E0.m60659c() == 3923 && i11 < 1 && c1457c.mo8332g(e10, lockId)) {
                return m63545H(c1457c, str, str2, str3, str4, revisionCreate, fileAttachment, str5, i10, str6, i11 + 1);
            }
            throw c9721bM63503E0;
        }
    }

    /* renamed from: I */
    public File m63546I(C1457c c1457c, final String str, final String str2, final FileCreate fileCreate, final boolean z10, int i10) throws C9721b {
        Lock lockMo8329d = c1457c.mo8329d();
        if (lockMo8329d == null) {
            throw new C9721b(HwConstants.LUNAR_YEAR_MIN, "lock is invalid", "Backup.device.file.create");
        }
        final String lockId = lockMo8329d.getLockId();
        final String str3 = "id,sha256,fileSize,isMdr,attachments(assetId,versionId,sliceSize,state,createdTime,modifiedTime,objects(id,number,start,length))";
        C14000c0 c14000c0 = new C14000c0(new C14000c0.a() { // from class: hm.e
            @Override // p814yl.C14000c0.a
            /* renamed from: a */
            public final CloudBackupV3Request mo1697a(CloudBackupV3Server cloudBackupV3Server) {
                return this.f49820a.m63562d0(fileCreate, str3, z10, str, str2, lockId, cloudBackupV3Server);
            }
        });
        try {
            return (File) c14000c0.m84139b("Backup.device.file.create", this.f49991f);
        } catch (C9721b e10) {
            C9721b c9721bM63503E0 = m63503E0(c14000c0.m84140c(), e10);
            if (c9721bM63503E0.m60659c() == 3923 && i10 < 1 && c1457c.mo8332g(e10, lockId)) {
                return m63546I(c1457c, str, str2, fileCreate, z10, i10 + 1);
            }
            throw c9721bM63503E0;
        }
    }

    /* renamed from: J */
    public void m63547J(C1457c c1457c, final String str) throws C9721b {
        final Lock lockMo8329d = c1457c.mo8329d();
        if (lockMo8329d == null) {
            throw new C9721b(HwConstants.LUNAR_YEAR_MIN, "lock is invalid", "Backup.Lock.delete");
        }
        new C14000c0(new C14000c0.a() { // from class: hm.v
            @Override // p814yl.C14000c0.a
            /* renamed from: a */
            public final CloudBackupV3Request mo1697a(CloudBackupV3Server cloudBackupV3Server) {
                return this.f49967a.m63565g0(lockMo8329d, str, cloudBackupV3Server);
            }
        }).m84139b("Backup.Lock.delete", this.f49991f);
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    /* renamed from: K */
    public void m63548K(C1457c c1457c, final String str, final String str2, int i10, Lock lock, final C11732m c11732m) throws C9721b {
        Lock lockMo8329d = c1457c != null ? c1457c.mo8329d() : lock;
        if (lockMo8329d == null) {
            throw new C9721b(HwConstants.LUNAR_YEAR_MIN, "lock is invalid", "Backup.device.bak.app.delete");
        }
        final String lockId = lockMo8329d.getLockId();
        C14000c0 c14000c0 = new C14000c0(new C14000c0.a() { // from class: hm.t
            @Override // p814yl.C14000c0.a
            /* renamed from: a */
            public final CloudBackupV3Request mo1697a(CloudBackupV3Server cloudBackupV3Server) {
                return this.f49956a.m63566h0(str, str2, lockId, c11732m, cloudBackupV3Server);
            }
        });
        try {
            c14000c0.m84139b("Backup.device.bak.delete", this.f49991f);
        } catch (C9721b e10) {
            C9721b c9721bM63503E0 = m63503E0(c14000c0.m84140c(), e10);
            if (c9721bM63503E0.m60659c() != 3923 || i10 >= 1) {
                if (c9721bM63503E0.m60659c() != 3922 || c9721bM63503E0.m60663g() != 4041) {
                    throw c9721bM63503E0;
                }
            } else {
                if (c1457c == null || !c1457c.mo8332g(e10, lockId)) {
                    return;
                }
                m63548K(c1457c, str, str2, 1 + i10, lock, c11732m);
            }
        }
    }

    /* renamed from: L */
    public void m63549L(C1457c c1457c, final String str, final String str2, final String str3, final String str4, String str5, int i10, Lock lock, final C11732m c11732m) throws C9721b {
        Lock lockMo8329d = c1457c != null ? c1457c.mo8329d() : lock;
        if (lockMo8329d == null) {
            throw new C9721b(HwConstants.LUNAR_YEAR_MIN, "lock is invalid", "Backup.device.bak.app.delete");
        }
        final String lockId = lockMo8329d.getLockId();
        C14000c0 c14000c0 = new C14000c0(new C14000c0.a() { // from class: hm.a
            @Override // p814yl.C14000c0.a
            /* renamed from: a */
            public final CloudBackupV3Request mo1697a(CloudBackupV3Server cloudBackupV3Server) {
                return this.f49759a.m63567i0(str, str2, str3, lockId, str4, c11732m, cloudBackupV3Server);
            }
        });
        try {
            c14000c0.m84139b("Backup.device.bak.app.delete", this.f49991f);
        } catch (C9721b e10) {
            C9721b c9721bM63503E0 = m63503E0(c14000c0.m84140c(), e10);
            if (c9721bM63503E0.m60659c() != 3923 || i10 >= 1) {
                if (c9721bM63503E0.m60659c() != 3922 || c9721bM63503E0.m60663g() != 4041) {
                    throw c9721bM63503E0;
                }
            } else {
                if (c1457c == null || !c1457c.mo8332g(e10, lockId)) {
                    return;
                }
                m63549L(c1457c, str, str2, str3, str4, str5, i10 + 1, lock, c11732m);
            }
        }
    }

    /* renamed from: M */
    public App m63550M(C1457c c1457c, String str, String str2, String str3, String str4, int i10, AppFinish appFinish, int i11) throws C9721b {
        Lock lockMo8329d = c1457c.mo8329d();
        if (lockMo8329d == null) {
            throw new C9721b(HwConstants.LUNAR_YEAR_MIN, "lock is invalid", "Backup.device.bak.app.finish");
        }
        String lockId = lockMo8329d.getLockId();
        C14000c0<App> c14000c0M63557T = m63557T(str, str2, str3, str4, i10, appFinish, "id,createTime,updateTime,backupAppStatus,attachments(quotaType,usage)", lockId);
        try {
            return c14000c0M63557T.m84139b("Backup.device.bak.app.finish", this.f49991f);
        } catch (C9721b e10) {
            C9721b c9721bM63503E0 = m63503E0(c14000c0M63557T.m84140c(), e10);
            if (c9721bM63503E0.m60659c() == 3923 && i11 < 1 && c1457c.mo8332g(e10, lockId)) {
                return m63550M(c1457c, str, str2, str3, str4, i10, appFinish, i11 + 1);
            }
            throw c9721bM63503E0;
        }
    }

    /* renamed from: N */
    public Asset m63551N(C1457c c1457c, final String str, final String str2, final String str3, final String str4, final String str5, final RevisionFinish revisionFinish, final String str6, int i10, final String str7, int i11) throws C9721b {
        Lock lockMo8329d = c1457c.mo8329d();
        if (lockMo8329d == null) {
            throw new C9721b(HwConstants.LUNAR_YEAR_MIN, "lock is invalid", "Backup.asset.revisions.finish");
        }
        final String lockId = lockMo8329d.getLockId();
        C14000c0 c14000c0 = new C14000c0(new C14000c0.a() { // from class: hm.j
            @Override // p814yl.C14000c0.a
            /* renamed from: a */
            public final CloudBackupV3Request mo1697a(CloudBackupV3Server cloudBackupV3Server) {
                return this.f49893a.m63568j0(revisionFinish, str2, str, str3, str4, str5, lockId, str6, str7, cloudBackupV3Server);
            }
        });
        try {
            return (Asset) c14000c0.m84139b("Backup.asset.revisions.finish", this.f49991f);
        } catch (C9721b e10) {
            C9721b c9721bM63503E0 = m63503E0(c14000c0.m84140c(), e10);
            if (c9721bM63503E0.m60659c() == 3923 && i11 < 1 && c1457c.mo8332g(e10, lockId)) {
                return m63551N(c1457c, str, str2, str3, str4, str5, revisionFinish, str6, i10, str7, i11 + 1);
            }
            throw c9721bM63503E0;
        }
    }

    /* renamed from: O */
    public Bak m63552O(C1457c c1457c, final String str, final String str2, final String str3, final BakFinish bakFinish, int i10) throws C9721b {
        Lock lockMo8329d = c1457c.mo8329d();
        if (lockMo8329d == null) {
            throw new C9721b(HwConstants.LUNAR_YEAR_MIN, "lock is invalid", "Backup.device.bak.finish");
        }
        final String lockId = lockMo8329d.getLockId();
        final String str4 = "id,device,backupStatus,backupVersion,startTime,updateTime,endTime";
        C14000c0 c14000c0 = new C14000c0(new C14000c0.a() { // from class: hm.w
            @Override // p814yl.C14000c0.a
            /* renamed from: a */
            public final CloudBackupV3Request mo1697a(CloudBackupV3Server cloudBackupV3Server) {
                return this.f49970a.m63569k0(bakFinish, str4, str, str2, str3, lockId, cloudBackupV3Server);
            }
        });
        try {
            return (Bak) c14000c0.m84139b("Backup.device.bak.finish", this.f49991f);
        } catch (C9721b e10) {
            C9721b c9721bM63503E0 = m63503E0(c14000c0.m84140c(), e10);
            if (c9721bM63503E0.m60659c() == 3923 && i10 < 1 && c1457c.mo8332g(e10, lockId)) {
                return m63552O(c1457c, str, str2, str3, bakFinish, i10 + 1);
            }
            throw c9721bM63503E0;
        }
    }

    /* renamed from: P */
    public File m63553P(C1457c c1457c, final String str, final String str2, final String str3, final int i10, int i11) throws C9721b {
        Lock lockMo8329d = c1457c.mo8329d();
        if (lockMo8329d == null) {
            throw new C9721b(HwConstants.LUNAR_YEAR_MIN, "lock is invalid", "Backup.device.file.get");
        }
        final String lockId = lockMo8329d.getLockId();
        C14000c0 c14000c0 = new C14000c0(new C14000c0.a() { // from class: hm.f
            @Override // p814yl.C14000c0.a
            /* renamed from: a */
            public final CloudBackupV3Request mo1697a(CloudBackupV3Server cloudBackupV3Server) {
                return this.f49829a.m63571m0(str, str2, str3, lockId, i10, cloudBackupV3Server);
            }
        });
        try {
            return (File) c14000c0.m84139b("Backup.device.file.get", this.f49991f);
        } catch (C9721b e10) {
            C9721b c9721bM63503E0 = m63503E0(c14000c0.m84140c(), e10);
            if (c9721bM63503E0.m60659c() == 3923 && i11 < 1 && c1457c.mo8332g(e10, lockId)) {
                return m63553P(c1457c, str, str2, str3, i10, i11 + 1);
            }
            throw c9721bM63503E0;
        }
    }

    /* renamed from: Q */
    public Lock m63554Q(final BackupLockParams backupLockParams) throws C9721b {
        if (backupLockParams == null || backupLockParams.getGradeCode() == null || backupLockParams.getGradeCode().isEmpty()) {
            throw new C9721b(3911, "request Backup.Lock.get, grade code isEmpty", "Backup.Lock.get");
        }
        return (Lock) new C14000c0(new C14000c0.a() { // from class: hm.x
            @Override // p814yl.C14000c0.a
            /* renamed from: a */
            public final CloudBackupV3Request mo1697a(CloudBackupV3Server cloudBackupV3Server) {
                return this.f49977a.m63570l0(backupLockParams, cloudBackupV3Server);
            }
        }).m84139b("Backup.Lock.get", this.f49991f);
    }

    /* renamed from: R */
    public final C14000c0<App> m63555R(final String str, final String str2, final String str3, final String str4, final AppCreate appCreate, final String str5, final String str6, final String str7) {
        return new C14000c0<>(new C14000c0.a() { // from class: hm.k
            @Override // p814yl.C14000c0.a
            /* renamed from: a */
            public final CloudBackupV3Request mo1697a(CloudBackupV3Server cloudBackupV3Server) {
                return this.f49905a.m63572n0(appCreate, str5, str, str2, str3, str4, str7, str6, cloudBackupV3Server);
            }
        });
    }

    /* renamed from: S */
    public final C14000c0<App> m63556S(final String str, final String str2, final String str3, final AppCreate appCreate, final String str4, final String str5) {
        return new C14000c0<>(new C14000c0.a() { // from class: hm.y
            @Override // p814yl.C14000c0.a
            /* renamed from: a */
            public final CloudBackupV3Request mo1697a(CloudBackupV3Server cloudBackupV3Server) {
                return this.f49979a.m63573o0(appCreate, str4, str, str2, str3, str5, cloudBackupV3Server);
            }
        });
    }

    /* renamed from: T */
    public final C14000c0<App> m63557T(final String str, final String str2, final String str3, final String str4, int i10, final AppFinish appFinish, final String str5, final String str6) {
        return new C14000c0<>(new C14000c0.a() { // from class: hm.m
            @Override // p814yl.C14000c0.a
            /* renamed from: a */
            public final CloudBackupV3Request mo1697a(CloudBackupV3Server cloudBackupV3Server) {
                return this.f49931a.m63574p0(appFinish, str5, str, str2, str3, str6, str4, cloudBackupV3Server);
            }
        });
    }

    /* renamed from: U */
    public final C14000c0<App> m63558U(final String str, final String str2, final String str3, final String str4, int i10, final AppRefresh appRefresh, Lock lock, final String str5, final String str6) {
        return new C14000c0<>(new C14000c0.a() { // from class: hm.l
            @Override // p814yl.C14000c0.a
            /* renamed from: a */
            public final CloudBackupV3Request mo1697a(CloudBackupV3Server cloudBackupV3Server) {
                return this.f49920a.m63575q0(appRefresh, str5, str2, str, str3, str6, str4, cloudBackupV3Server);
            }
        });
    }

    /* renamed from: V */
    public String m63559V() {
        return this.f49988c;
    }

    /* renamed from: W */
    public Integer m63560W() {
        return this.f49987b;
    }

    /* renamed from: X */
    public LockKeepResult m63561X(C1457c c1457c, final String str, boolean z10) throws C9721b {
        Lock lockMo8329d = c1457c.mo8329d();
        if (lockMo8329d == null) {
            throw new C9721b(HwConstants.LUNAR_YEAR_MIN, "lock is invalid", "Backup.Lock.keepLock");
        }
        final LockCreate lockCreate = new LockCreate();
        lockCreate.setKeepLockTime(new C4644l(System.currentTimeMillis()).toString());
        final String lockId = lockMo8329d.getLockId();
        C14000c0 c14000c0 = new C14000c0(new C14000c0.a() { // from class: hm.r
            @Override // p814yl.C14000c0.a
            /* renamed from: a */
            public final CloudBackupV3Request mo1697a(CloudBackupV3Server cloudBackupV3Server) {
                return this.f49950a.m63576r0(lockCreate, str, lockId, cloudBackupV3Server);
            }
        });
        try {
            return (LockKeepResult) c14000c0.m84139b("Backup.Lock.keepLock", this.f49991f);
        } catch (C9721b e10) {
            C9721b c9721bM63503E0 = m63503E0(c14000c0.m84140c(), e10);
            if (c9721bM63503E0.m60659c() != 3923 || !z10) {
                throw c9721bM63503E0;
            }
            c1457c.mo8332g(e10, lockId);
            return null;
        }
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.File$Create] */
    /* renamed from: d0 */
    public final /* synthetic */ CloudBackupV3Request m63562d0(FileCreate fileCreate, String str, boolean z10, String str2, String str3, String str4, CloudBackupV3Server cloudBackupV3Server) throws IOException {
        File.Create create = cloudBackupV3Server.backup().device().file().create(fileCreate);
        create.setFields(str).setAntiMdr(z10).setBackupAction(this.f49986a).setBackupDeviceId(str2).setBackId(str3).setLockId(str4).setInterimChannel(this.f49989d).setXHwBackupPackageName(fileCreate.getAppPackageName()).setXHwBackupid(str3).setBackupVersion(CBSBaseReq.CURRENT_API_VERSION).setGradeCode(C12590s0.m75747G0()).setBakCategory(this.f49988c).setOccupySpaceType(this.f49987b);
        return create;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Backup$Asset$Create] */
    /* renamed from: e0 */
    public final /* synthetic */ CloudBackupV3Request m63563e0(RevisionCreate revisionCreate, String str, String str2, String str3, String str4, String str5, String str6, String str7, FileAttachment fileAttachment, CloudBackupV3Server cloudBackupV3Server) throws IOException {
        Backup.Asset.Create create = cloudBackupV3Server.backup().asset().create(revisionCreate);
        create.setFields(str).setUsage(str2).setBackupAction(this.f49986a).setKindId(str3).setRecordId(str4).setEmuiVer(C0209d.m1186L()).setAndroidVer(C0209d.m1307t()).setLockId(str5).setXHwBackupPackageName(str6).setXHwBackupid(str7).setBakCategory(this.f49988c).setInterimChannel(this.f49989d).setOccupySpaceType(this.f49987b);
        if ("apk".equals(str2) || "icon".equals(str2)) {
            create.setPackageName((String) C4627a0.m28391d(fileAttachment.getPackageName())).setPackageVersion((String) C4627a0.m28391d(fileAttachment.getPackageVersion())).setPackageOriginHashType((String) C4627a0.m28391d(fileAttachment.getPackageOriginHashType())).setPackageOriginLength((String) C4627a0.m28391d(fileAttachment.getPackageOriginLength())).setPackageSsha2(fileAttachment.getPackageSsha2()).setPackageOriginHash((String) C4627a0.m28391d(fileAttachment.getPackageOriginHash()));
        }
        return create;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Revisions$Create] */
    /* renamed from: f0 */
    public final /* synthetic */ CloudBackupV3Request m63564f0(RevisionCreate revisionCreate, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, FileAttachment fileAttachment, CloudBackupV3Server cloudBackupV3Server) throws IOException {
        Revisions.Create create = cloudBackupV3Server.backup().asset().revisions().create(revisionCreate);
        create.setFields(str).setBackupAction(this.f49986a).setKindId(str2).setRecordId(str3).setAssetId(str4).setEmuiVer(C0209d.m1186L()).setAndroidVer(C0209d.m1307t()).setLockId(str5).setXHwBackupPackageName(str6).setXHwBackupid(str7).setBakCategory(this.f49988c).setInterimChannel(this.f49989d).setOccupySpaceType(this.f49987b);
        if ("apk".equals(str8) || "icon".equals(str8)) {
            create.setPackageName((String) C4627a0.m28391d(fileAttachment.getPackageName())).setPackageVersion((String) C4627a0.m28391d(fileAttachment.getPackageVersion())).setPackageOriginHashType((String) C4627a0.m28391d(fileAttachment.getPackageOriginHashType())).setPackageOriginLength((String) C4627a0.m28391d(fileAttachment.getPackageOriginLength())).setPackageSsha2(fileAttachment.getPackageSsha2()).setPackageOriginHash((String) C4627a0.m28391d(fileAttachment.getPackageOriginHash()));
        }
        return create;
    }

    /* renamed from: g0 */
    public final /* synthetic */ CloudBackupV3Request m63565g0(Lock lock, String str, CloudBackupV3Server cloudBackupV3Server) throws IOException {
        Backup.Lock.Delete delete = cloudBackupV3Server.backup().lock().delete(lock.getLockId());
        delete.setBackupAction(this.f49986a).setBackupDeviceId(str).setBakCategory(this.f49988c).setOccupySpaceType(this.f49987b);
        return delete;
    }

    /* renamed from: h0 */
    public final /* synthetic */ CloudBackupV3Request m63566h0(String str, String str2, String str3, C11732m c11732m, CloudBackupV3Server cloudBackupV3Server) throws IOException {
        Bak.Delete delete = cloudBackupV3Server.backup().device().bak().delete();
        delete.setBackupAction(this.f49986a).setBackupDeviceId(str).setBakId(str2).setLockId(str3).setOpSceneParam(c11732m);
        return delete;
    }

    /* renamed from: i0 */
    public final /* synthetic */ CloudBackupV3Request m63567i0(String str, String str2, String str3, String str4, String str5, C11732m c11732m, CloudBackupV3Server cloudBackupV3Server) throws IOException {
        Bak.App.Delete delete = cloudBackupV3Server.backup().device().bak().app().delete();
        delete.setBackupAction(this.f49986a).setBackupDeviceId(str).setBakId(str2).setBackupAppId(str3).setLockId(str4).setXHwBackupPackageName(str5).setXHwBackupid(str2).setBakCategory(this.f49988c).setOccupySpaceType(this.f49987b).setOpSceneParam(c11732m);
        return delete;
    }

    /* JADX WARN: Type inference failed for: r10v5, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Revisions$Finish] */
    /* renamed from: j0 */
    public final /* synthetic */ CloudBackupV3Request m63568j0(RevisionFinish revisionFinish, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, CloudBackupV3Server cloudBackupV3Server) throws IOException {
        Revisions.Finish finish = cloudBackupV3Server.backup().asset().revisions().finish(revisionFinish);
        finish.setFields("id,state").setUsage(str).setBackupAction(this.f49986a).setKindId(str2).setRecordId(str3).setAssetId(str4).setVersionId(str5).setLockId(str6).setXHwBackupPackageName(str7).setXHwBackupid(str8).setBakCategory(this.f49988c).setOccupySpaceType(this.f49987b);
        return finish;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Bak$Finish] */
    /* renamed from: k0 */
    public final /* synthetic */ CloudBackupV3Request m63569k0(BakFinish bakFinish, String str, String str2, String str3, String str4, String str5, CloudBackupV3Server cloudBackupV3Server) throws IOException {
        Bak.Finish finish = cloudBackupV3Server.backup().device().bak().finish(bakFinish);
        finish.setFields(str).setBackupAction(this.f49986a).setBackupDeviceId(str2).setBakId(str3).setGrayFlowStrategy(str4).setLockId(str5).setBakCategory(this.f49988c).setOccupySpaceType(this.f49987b);
        return finish;
    }

    /* renamed from: l0 */
    public final /* synthetic */ CloudBackupV3Request m63570l0(BackupLockParams backupLockParams, CloudBackupV3Server cloudBackupV3Server) throws IOException {
        Backup.Lock.Get get = cloudBackupV3Server.backup().lock().get(backupLockParams.getGradeCode(), backupLockParams.getBackupTimes(), backupLockParams.getBkStartDays(), backupLockParams.getBakId(), backupLockParams.getLastBkCompleteDays(), backupLockParams.getFlowControlCnt());
        get.setLockAction(this.f49990e).setBackupAction(this.f49986a).setDirtyClear(Boolean.valueOf(backupLockParams.isClean())).setBackupDeviceId(backupLockParams.getBackupDeviceId()).setFullBK(Boolean.valueOf(backupLockParams.isFullBK())).setLockByDelDevice(backupLockParams.getLockByDelDevice()).setLockByDelDeviceFlag(backupLockParams.getLockByDelDeviceFlag()).setBakCategory(this.f49988c).setOccupySpaceType(this.f49987b);
        if (backupLockParams.getLockParamVFSRef() != null) {
            get.setBackupSize(backupLockParams.getLockParamVFSRef().getBackupSize()).setAvailableSpaceSize(backupLockParams.getLockParamVFSRef().getAvailableSpaceSize()).setNoRefVfsFile(backupLockParams.getLockParamVFSRef().isNoRefVfsFile());
            long vfsRefSize = backupLockParams.getLockParamVFSRef().getVfsRefSize();
            long jM60763v = C9733f.m60705z().m60763v("backupVfsRefBypass");
            C11839m.m70688i("CloudBackupV3Service", "vfsRefSize:" + vfsRefSize + ",backupVfsRefByPass:" + jM60763v);
            if (vfsRefSize >= 0 && jM60763v == 1) {
                get.setVfsRefSize(vfsRefSize);
            }
        }
        return get;
    }

    /* renamed from: m0 */
    public final /* synthetic */ CloudBackupV3Request m63571m0(String str, String str2, String str3, String str4, int i10, CloudBackupV3Server cloudBackupV3Server) throws IOException {
        File.Get get = cloudBackupV3Server.backup().device().file().get();
        get.setBackupAction(this.f49986a).setBackupDeviceId(str).setFileId(str2).setFields(str3).setHeader("lockId", (Object) str4).setHeader("x-hw-file-get-type", (Object) Integer.valueOf(i10));
        return get;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Bak$App$Copy] */
    /* renamed from: n0 */
    public final /* synthetic */ CloudBackupV3Request m63572n0(AppCreate appCreate, String str, String str2, String str3, String str4, String str5, String str6, String str7, CloudBackupV3Server cloudBackupV3Server) throws IOException {
        Bak.App.Copy copy = cloudBackupV3Server.backup().device().bak().app().copy(appCreate);
        copy.setFields(str).setBackupAction(this.f49986a).setBackupDeviceId(str2).setBakId(str3).setSourceBakId(str4).setSourceAppId(str5).setXHwBackupPackageName(appCreate.getBackupAppName()).setPackageSsha2(str6).setXHwBackupId(str3).setLockId(str7);
        return copy;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Bak$App$Create] */
    /* renamed from: o0 */
    public final /* synthetic */ CloudBackupV3Request m63573o0(AppCreate appCreate, String str, String str2, String str3, String str4, String str5, CloudBackupV3Server cloudBackupV3Server) throws IOException {
        Bak.App.Create create = cloudBackupV3Server.backup().device().bak().app().create(appCreate);
        create.setFields(str).setBackupAction(str2).setBackupDeviceId(str3).setBakId(str4).setLockId(str5).setXHwBackupPackageName(appCreate.getBackupAppName()).setXHwBackupid(str4).setBakCategory(this.f49988c).setOccupySpaceType(this.f49987b);
        return create;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Bak$App$Finish] */
    /* renamed from: p0 */
    public final /* synthetic */ CloudBackupV3Request m63574p0(AppFinish appFinish, String str, String str2, String str3, String str4, String str5, String str6, CloudBackupV3Server cloudBackupV3Server) throws IOException {
        Bak.App.Finish finish = cloudBackupV3Server.backup().device().bak().app().finish(appFinish);
        finish.setFields(str).setBackupAction(this.f49986a).setBackupDeviceId(str2).setBakId(str3).setXHwBackupid(str3).setBackupAppId(str4).setLockId(str5).setXHwBackupPackageName(str6).setBakCategory(this.f49988c).setOccupySpaceType(this.f49987b);
        return finish;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Bak$App$Refresh] */
    /* renamed from: q0 */
    public final /* synthetic */ CloudBackupV3Request m63575q0(AppRefresh appRefresh, String str, String str2, String str3, String str4, String str5, String str6, CloudBackupV3Server cloudBackupV3Server) throws IOException {
        Bak.App.Refresh refresh = cloudBackupV3Server.backup().device().bak().app().refresh(appRefresh);
        refresh.setFields(str).setBakId(str2).setBackupAction(this.f49986a).setBackupDeviceId(str3).setBackupAppId(str4).setLockId(str5).setXHwBackupPackageName(str6).setXHwBackupid(str2).setBakCategory(this.f49988c).setOccupySpaceType(this.f49987b);
        return refresh;
    }

    /* renamed from: r0 */
    public final /* synthetic */ CloudBackupV3Request m63576r0(LockCreate lockCreate, String str, String str2, CloudBackupV3Server cloudBackupV3Server) throws IOException {
        Backup.Lock.KeepLock keepLock = cloudBackupV3Server.backup().lock().keepLock(lockCreate);
        keepLock.setBackupAction(this.f49986a).setBackupDeviceId(str).setLockId(str2).setBakCategory(this.f49988c).setOccupySpaceType(this.f49987b);
        return keepLock;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Revisions$Refresh] */
    /* renamed from: s0 */
    public final /* synthetic */ CloudBackupV3Request m63577s0(RevisionRefresh revisionRefresh, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, List list, CloudBackupV3Server cloudBackupV3Server) throws IOException {
        Revisions.Refresh refresh = cloudBackupV3Server.backup().asset().revisions().refresh(revisionRefresh);
        refresh.setFields(str).setUsage(str2).setBackupAction(this.f49986a).setKindId(str3).setRecordId(str4).setAssetId(str5).setVersionId(str6).setLockId(str7).setXHwBackupPackageName(str8).setXHwBackupid(str9).setBakCategory(this.f49988c).setOccupySpaceType(this.f49987b);
        if (!AbstractC14026a.m84159a(list)) {
            refresh.setObjectIds(list);
        }
        return refresh;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Revisions$Refresh] */
    /* renamed from: t0 */
    public final /* synthetic */ CloudBackupV3Request m63578t0(RevisionRefresh revisionRefresh, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i10, boolean z10, CloudBackupV3Server cloudBackupV3Server) throws IOException {
        Revisions.Refresh refresh = cloudBackupV3Server.backup().asset().revisions().refresh(revisionRefresh);
        refresh.setFields(str).setUsage(str2).setBackupAction(this.f49986a).setKindId(str3).setRecordId(str4).setAssetId(str5).setVersionId(str6).setLockId(str7).setXHwBackupPackageName(str8).setXHwBackupid(str9).setBakCategory(this.f49988c).setOccupySpaceType(this.f49987b);
        if (i10 == 1) {
            refresh.setHeader("x-hw-divide", (Object) 1);
        }
        if (z10) {
            refresh.setHeader("x-hw-divide-check", (Object) 1);
        }
        return refresh;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Bak$Refresh] */
    /* renamed from: u0 */
    public final /* synthetic */ CloudBackupV3Request m63579u0(BakRefresh bakRefresh, String str, String str2, String str3, String str4, CloudBackupV3Server cloudBackupV3Server) throws IOException {
        Bak.Refresh refresh = cloudBackupV3Server.backup().device().bak().refresh(bakRefresh);
        refresh.setFields(str).setBackupAction(this.f49986a).setBackupDeviceId(str2).setBakId(str3).setLockId(str4).setBakCategory(this.f49988c).setOccupySpaceType(this.f49987b);
        return refresh;
    }

    /* renamed from: v0 */
    public final /* synthetic */ CloudBackupV3Request m63580v0(FileReuse fileReuse, String str, String str2, String str3, String str4, CloudBackupV3Server cloudBackupV3Server) throws IOException {
        File.Reuse reuse = cloudBackupV3Server.backup().device().file().reuse(fileReuse);
        reuse.setBackupAction(this.f49986a).setBackupDeviceId(str).setLockId(str2).setXHwBackupPackageName(str3).setXHwBackupid(str4).setBakCategory(this.f49988c).setOccupySpaceType(this.f49987b);
        return reuse;
    }

    /* renamed from: w0 */
    public final /* synthetic */ CloudBackupV3Request m63581w0(C11722c c11722c, CloudBackupV3Server cloudBackupV3Server) throws IOException {
        Backup.Lock.VBackup.Get get = cloudBackupV3Server.backup().lock().vBackup().get(c11722c);
        get.setLockAction(this.f49990e).setBackupAction(this.f49986a).setBackupDeviceId(c11722c.m69924a()).setOccupySpaceType(this.f49987b).setBakCategory(this.f49988c);
        return get;
    }

    /* renamed from: x0 */
    public App m63582x0(C1457c c1457c, String str, String str2, String str3, String str4, int i10, AppRefresh appRefresh, int i11) throws C9721b {
        Lock lockMo8329d = c1457c.mo8329d();
        if (lockMo8329d == null) {
            throw new C9721b(HwConstants.LUNAR_YEAR_MIN, "lock is invalid", "Backup.device.bak.app.refresh");
        }
        String lockId = lockMo8329d.getLockId();
        C14000c0<App> c14000c0M63558U = m63558U(str, str2, str3, str4, i10, appRefresh, lockMo8329d, "id,createTime,updateTime,backupAppStatus", lockId);
        try {
            return c14000c0M63558U.m84139b("Backup.device.bak.app.refresh", this.f49991f);
        } catch (C9721b e10) {
            C9721b c9721bM63503E0 = m63503E0(c14000c0M63558U.m84140c(), e10);
            if (c9721bM63503E0.m60659c() == 3923 && i11 < 1 && c1457c.mo8332g(e10, lockId)) {
                return m63582x0(c1457c, str, str2, str3, str4, i10, appRefresh, i11 + 1);
            }
            throw c9721bM63503E0;
        }
    }

    /* renamed from: y0 */
    public Asset m63583y0(C1457c c1457c, final String str, final String str2, final String str3, final String str4, final String str5, final String str6, final RevisionRefresh revisionRefresh, final int i10, final String str7, int i11, final String str8, final boolean z10, int i12) throws C9721b {
        Lock lockMo8329d = c1457c.mo8329d();
        if (lockMo8329d == null) {
            throw new C9721b(HwConstants.LUNAR_YEAR_MIN, "lock is invalid", "Backup.asset.revisions.refresh");
        }
        final String lockId = lockMo8329d.getLockId();
        C14000c0 c14000c0 = new C14000c0(new C14000c0.a() { // from class: hm.d
            @Override // p814yl.C14000c0.a
            /* renamed from: a */
            public final CloudBackupV3Request mo1697a(CloudBackupV3Server cloudBackupV3Server) {
                return this.f49802a.m63578t0(revisionRefresh, str, str2, str3, str4, str5, str6, lockId, str7, str8, i10, z10, cloudBackupV3Server);
            }
        });
        try {
            Asset asset = (Asset) c14000c0.m84139b("Backup.asset.revisions.refresh", this.f49991f);
            m63502C0(asset, c14000c0);
            return asset;
        } catch (C9721b e10) {
            C9721b c9721bM63503E0 = m63503E0(c14000c0.m84140c(), e10);
            if (c9721bM63503E0.m60659c() == 3923 && i12 < 1 && c1457c.mo8332g(e10, lockId)) {
                return m63583y0(c1457c, str, str2, str3, str4, str5, str6, revisionRefresh, i10, str7, i11, str8, z10, i12 + 1);
            }
            throw c9721bM63503E0;
        }
    }

    /* renamed from: z */
    public void m63584z(C1457c c1457c, String str, String str2, String str3, List<Pair<AppCreate, Pair<CloudBackupStatus, App>>> list, final Consumer<Pair<App, CloudBackupStatus>> consumer) throws C9721b {
        Lock lockMo8329d = c1457c.mo8329d();
        if (lockMo8329d == null) {
            throw new C9721b(HwConstants.LUNAR_YEAR_MIN, "lock is invalid", "Backup.device.bak.app.copy");
        }
        String lockId = lockMo8329d.getLockId();
        CloudBackupV3BatchRequest cloudBackupV3BatchRequest = new CloudBackupV3BatchRequest();
        ArrayList arrayList = new ArrayList();
        for (final Pair<AppCreate, Pair<CloudBackupStatus, App>> pair : list) {
            AppCreate appCreate = (AppCreate) pair.first;
            String id2 = ((App) ((Pair) pair.second).second).getId();
            String backupAppName = appCreate.getBackupAppName();
            Object obj = pair.second;
            if (((Pair) obj).first != null) {
                backupAppName = ((CloudBackupStatus) ((Pair) obj).first).mo29421n();
            }
            m63555R(str, str2, str3, id2, appCreate, "id,attachments,properties", lockId, C12535a.m75458d(backupAppName)).m84143f(cloudBackupV3BatchRequest, new a("Backup.device.bak.app.copy", new Consumer() { // from class: hm.n
                @Override // java.util.function.Consumer
                public final void accept(Object obj2) {
                    C10321z.m63504Y(consumer, pair, (App) obj2);
                }
            }, arrayList));
        }
        cloudBackupV3BatchRequest.execute("Backup.device.bak.app.copy", this.f49991f);
        if (arrayList.size() <= 0) {
            return;
        }
        C11839m.m70687e("CloudBackupV3Service", "batchCreate exception: " + ((C9721b) arrayList.get(0)).getMessage());
        throw ((C9721b) arrayList.get(0));
    }

    /* renamed from: z0 */
    public Asset m63585z0(C1457c c1457c, final String str, final String str2, final String str3, final String str4, final String str5, final String str6, final RevisionRefresh revisionRefresh, final String str7, int i10, final String str8, final List<String> list, int i11) throws C9721b {
        Lock lockMo8329d = c1457c.mo8329d();
        if (lockMo8329d == null) {
            throw new C9721b(HwConstants.LUNAR_YEAR_MIN, "lock is invalid", "Backup.asset.revisions.refresh");
        }
        final String lockId = lockMo8329d.getLockId();
        C14000c0 c14000c0 = new C14000c0(new C14000c0.a() { // from class: hm.c
            @Override // p814yl.C14000c0.a
            /* renamed from: a */
            public final CloudBackupV3Request mo1697a(CloudBackupV3Server cloudBackupV3Server) {
                return this.f49786a.m63577s0(revisionRefresh, str, str2, str3, str4, str5, str6, lockId, str7, str8, list, cloudBackupV3Server);
            }
        });
        try {
            Asset asset = (Asset) c14000c0.m84139b("Backup.asset.revisions.refresh", this.f49991f);
            m63502C0(asset, c14000c0);
            return asset;
        } catch (C9721b e10) {
            C9721b c9721bM63503E0 = m63503E0(c14000c0.m84140c(), e10);
            if (c9721bM63503E0.m60659c() == 3923 && i11 < 1 && c1457c.mo8332g(e10, lockId)) {
                return m63585z0(c1457c, str, str2, str3, str4, str5, str6, revisionRefresh, str7, i10, str8, list, i11 + 1);
            }
            throw c9721bM63503E0;
        }
    }

    public C10321z() {
    }
}
