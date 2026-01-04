package dm;

import android.database.SQLException;
import android.text.TextUtils;
import cm.C1457c;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.cloudbackup.process.util.BackupCacheRecord;
import com.huawei.android.hicloud.cloudbackup.report.CloudBackupReport;
import com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.SnapshotDBManager;
import com.huawei.cloud.base.http.C4609l;
import com.huawei.cloud.base.util.C4633d0;
import com.huawei.hicloud.base.bean.Md5AndHash;
import com.huawei.hicloud.base.drive.model.ErrorResp;
import com.huawei.hicloud.cloudbackup.p104v3.core.C4879a;
import com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request;
import com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Server;
import com.huawei.hicloud.cloudbackup.p104v3.server.batch.CloudBackupV3BatchCallback;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.App;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.AppRefresh;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.Attachment;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.Bak;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.FileDelete;
import com.huawei.hicloud.cloudbackup.p104v3.server.request.File;
import com.huawei.hicloud.cloudbackup.store.database.status.CloudBackupStatus;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.phoneservice.feedbackcommon.network.FeedbackWebConstants;
import fk.C9721b;
import gm.C9989d;
import hk.C10278a;
import hk.C10279b;
import hm.C10321z;
import im.C10546a;
import im.C10560j;
import im.InterfaceC10551c0;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import mk.C11476b;
import mm.AbstractC11494p;
import mm.C11481c;
import mm.InterfaceC11496r;
import om.C11963c;
import p015ak.C0213f;
import p015ak.C0241z;
import p455ll.C11308a;
import p455ll.C11309b;
import p455ll.C11311d;
import p495nm.C11732m;
import p514o9.C11835i;
import p514o9.C11839m;
import p523oi.C11903a;
import p618rm.C12574n;
import p618rm.C12590s0;
import p618rm.C12594t1;
import p682ul.C13216j;
import p744wl.C13617a;
import pl.C12162d;
import pl.C12164f;
import sl.C12812c;
import sl.C12815f;

/* renamed from: dm.d0 */
/* loaded from: classes6.dex */
public class C9195d0 {

    /* renamed from: a */
    public C4879a f46128a;

    /* renamed from: b */
    public String f46129b;

    /* renamed from: c */
    public String f46130c;

    /* renamed from: d */
    public String f46131d;

    /* renamed from: e */
    public String f46132e;

    /* renamed from: f */
    public C1457c f46133f;

    /* renamed from: g */
    public CloudBackupStatus f46134g;

    /* renamed from: h */
    public String f46135h;

    /* renamed from: i */
    public C10321z f46136i;

    /* renamed from: dm.d0$a */
    public static class a extends CloudBackupV3BatchCallback<Void> {

        /* renamed from: a */
        public final String[] f46137a;

        /* renamed from: b */
        public final AtomicBoolean f46138b;

        public a(String[] strArr, AtomicBoolean atomicBoolean) {
            this.f46137a = strArr;
            this.f46138b = atomicBoolean;
        }

        @Override // com.huawei.hicloud.cloudbackup.p104v3.server.batch.CloudBackupV3BatchCallback, p369ii.InterfaceC10510a
        /* renamed from: a */
        public void onSuccess(Void r12, C4609l c4609l) {
            C11839m.m70686d("CloudBackupV3ModuleDelete", "delete dm file success.");
        }

        @Override // com.huawei.hicloud.cloudbackup.p104v3.server.batch.CloudBackupV3BatchCallback
        public void onFailure(ErrorResp.Error error, C4609l c4609l) {
            List<ErrorResp.ErrorMsg> errorDetail = error.getErrorDetail();
            if (errorDetail == null || errorDetail.isEmpty()) {
                return;
            }
            ErrorResp.ErrorMsg errorMsg = errorDetail.get(0);
            String errorCode = errorMsg.getErrorCode();
            String description = errorMsg.getDescription();
            if (String.valueOf(51004921).equals(errorCode)) {
                C11839m.m70686d("CloudBackupV3ModuleDelete", "server delete reference file error: " + description + " ,errorCode: " + errorCode);
                return;
            }
            if (errorCode.endsWith(String.valueOf(4011)) || errorCode.endsWith(String.valueOf(4041))) {
                return;
            }
            errorMsg.setFactory(C11903a.m71435l());
            this.f46137a[0] = errorMsg.toString();
            C11839m.m70689w("CloudBackupV3ModuleDelete", "delete dm file error: " + errorMsg.toString());
            this.f46138b.set(true);
        }
    }

    public C9195d0(C4879a c4879a, CloudBackupStatus cloudBackupStatus) {
        this.f46128a = c4879a;
        this.f46129b = c4879a.m29713i0();
        this.f46130c = c4879a.m29719k0();
        this.f46131d = c4879a.m29734p0();
        this.f46132e = c4879a.m29654O0();
        this.f46133f = c4879a.m29728n0();
        this.f46134g = cloudBackupStatus;
        this.f46135h = cloudBackupStatus.m29870d();
        this.f46136i = new C10321z(this.f46129b, c4879a.m29636F0(), c4879a.m29587j(), CloudBackupConstant.Command.PMS_CMD_BACKUP, this.f46132e);
    }

    /* renamed from: e */
    public static void m57742e(String str) throws C9721b {
        if (C4633d0.m28404a(str)) {
            return;
        }
        C13216j.c cVar = C13216j.c.STATUS;
        C11309b c11309b = new C11309b(C13216j.m79427l(cVar, null));
        List<C11308a> listM67913e = c11309b.m67913e(str);
        C11311d c11311d = new C11311d(C13216j.m79427l(cVar, null));
        for (C11308a c11308a : listM67913e) {
            c11311d.m67939b(c11308a.m67883a());
            c11309b.m67909a(c11308a.m67892j());
        }
    }

    /* renamed from: d */
    public final void m57743d() {
        try {
            HashMap map = new HashMap();
            map.put("modulestatus", String.valueOf(7));
            AppRefresh appRefresh = new AppRefresh();
            appRefresh.setBloomFilter("V1:default");
            appRefresh.setProperties((Map<String, String>) map);
            this.f46136i.m63582x0(this.f46128a.m29728n0(), this.f46130c, this.f46131d, this.f46134g.m29398d1(), this.f46134g.m29870d(), this.f46134g.m29861N(), appRefresh, 0);
        } catch (Exception e10) {
            C11839m.m70689w("CloudBackupV3ModuleDelete", "appRefreshBloomFilterDefault error: " + e10.getMessage());
            CloudBackupReport.reportAppRefreshBloomFilterErr(this.f46135h, e10.getMessage(), this.f46132e);
        }
    }

    /* renamed from: f */
    public final void m57744f() throws C9721b {
        if (C4633d0.m28404a(this.f46134g.m29398d1())) {
            C11839m.m70688i("CloudBackupV3ModuleDelete", "copy snapshot data to temp table recordId is null.");
            return;
        }
        if (new C12164f(this.f46131d, this.f46135h, 0, this.f46134g.m29861N()).m73065X(1) <= 0) {
            C11839m.m70688i("CloudBackupV3ModuleDelete", "no need copy snapshot data to temp table. appId = " + this.f46135h);
            return;
        }
        C12162d c12162d = new C12162d(this.f46131d, this.f46135h, 0, this.f46134g.m29861N());
        C11839m.m70688i("CloudBackupV3ModuleDelete", "copy snapshot table to temp table, appId = " + this.f46135h);
        c12162d.m73013b();
        C11839m.m70688i("CloudBackupV3ModuleDelete", "copy snapshot table to temp table end, appId = " + this.f46135h);
    }

    /* renamed from: g */
    public void m57745g(String str) {
        String str2 = "delete one module start, appId = " + this.f46135h + " uid: " + this.f46134g.m29861N();
        try {
            try {
                C11839m.m70688i("CloudBackupV3ModuleDelete", str2);
                this.f46134g.mo29338z0(0).mo29289A0(-1).mo29310W(0).mo29308V(0L).m29436s2(0L).m29374R1(0L).m29342C1(0L).m29401e2("").m29365N1("").m29423n2(0L);
                C12815f c12815f = new C12815f(this.f46129b);
                c12815f.m76934m(this.f46134g);
                this.f46128a.isCancel();
                String strM29398d1 = this.f46134g.m29398d1();
                if (!C4633d0.m28404a(strM29398d1)) {
                    m57743d();
                }
                this.f46128a.isCancel();
                m57746h(str);
                this.f46128a.isCancel();
                if (!C4633d0.m28404a(strM29398d1)) {
                    String strValueOf = this.f46134g.m29861N() != 0 ? String.valueOf(this.f46134g.m29861N()) : "";
                    this.f46136i.m63549L(this.f46128a.m29728n0(), this.f46130c, this.f46131d, strM29398d1, this.f46134g.m29870d(), strValueOf, 0, null, new C11732m("12", "from client," + str));
                }
                C12574n.m75555h(C0213f.m1377a(), this.f46135h, this.f46134g.mo29421n(), this.f46134g.m29861N());
                m57749k();
                m57748j();
                c12815f.m76924c(this.f46135h, this.f46134g.m29861N());
                C9989d c9989dM29731o0 = this.f46128a.m29731o0();
                if (c9989dM29731o0 != null) {
                    c9989dM29731o0.m61944u0(this.f46134g);
                }
                str2 = "delete one module end, appId = " + this.f46135h + " uid: " + this.f46134g.m29861N();
                C11839m.m70688i("CloudBackupV3ModuleDelete", str2);
            } catch (C9721b e10) {
                str2 = "delete one module error: " + e10.toString();
                C11839m.m70687e("CloudBackupV3ModuleDelete", str2);
                this.f46128a.setException(e10);
            }
            CloudBackupReport.reportAppModuleReset(false, this.f46135h, this.f46132e, this.f46131d, this.f46129b, str2, str);
        } catch (Throwable th2) {
            CloudBackupReport.reportAppModuleReset(false, this.f46135h, this.f46132e, this.f46131d, this.f46129b, str2, str);
            throw th2;
        }
    }

    /* renamed from: h */
    public final void m57746h(String str) throws InterruptedException, C9721b, SQLException {
        if (C4633d0.m28404a(this.f46134g.m29398d1())) {
            C11839m.m70688i("CloudBackupV3ModuleDelete", "delete dm files recordId is null.");
            return;
        }
        C12164f c12164f = new C12164f(this.f46131d, this.f46135h, 0, this.f46134g.m29861N());
        long jM73065X = c12164f.m73065X(1);
        long jM73098p0 = c12164f.m73098p0();
        if (jM73065X > 0 || jM73098p0 > 0) {
            m57744f();
            m57752n(false, str);
        } else {
            C11839m.m70688i("CloudBackupV3ModuleDelete", "no need delete files. appId = " + this.f46135h);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:83:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x016e A[EDGE_INSN: B:96:0x016e->B:88:0x016e BREAK  A[LOOP:0: B:58:0x0043->B:84:0x0144], SYNTHETIC] */
    /* renamed from: i */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m57747i(mm.AbstractC11494p r24, int r25, java.util.concurrent.atomic.AtomicBoolean r26, java.util.concurrent.atomic.AtomicBoolean r27, final java.lang.String r28) {
        /*
            Method dump skipped, instructions count: 372
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: dm.C9195d0.m57747i(mm.p, int, java.util.concurrent.atomic.AtomicBoolean, java.util.concurrent.atomic.AtomicBoolean, java.lang.String):void");
    }

    /* renamed from: j */
    public final void m57748j() {
        new C12164f(this.f46131d, this.f46135h, 0, this.f46134g.m29861N()).close();
        String strM81942x = C13617a.m81942x(this.f46131d, this.f46135h, 0, this.f46134g.m29861N());
        File fileM63442h = C10278a.m63442h(strM81942x);
        if (fileM63442h.exists()) {
            C11839m.m70688i("CloudBackupV3ModuleDelete", "deleteAppBackupMetaDbFile, delete snapshot: " + fileM63442h.getName());
            if (!fileM63442h.delete()) {
                C11839m.m70689w("CloudBackupV3ModuleDelete", "deleteAppBackupMetaDbFile: " + this.f46135h + " error");
            }
        }
        File fileM63442h2 = C10278a.m63442h(strM81942x + "-journal");
        if (!fileM63442h2.exists() || fileM63442h2.delete()) {
            return;
        }
        C11839m.m70689w("CloudBackupV3ModuleDelete", "deleteAppBackupMetaDbFile cache file: " + this.f46135h + " error");
    }

    /* renamed from: k */
    public final void m57749k() throws C9721b {
        String strM81914C = C13617a.m81914C(this.f46135h, this.f46134g.m29861N());
        File fileM63442h = C10278a.m63442h(strM81914C);
        if (fileM63442h.exists()) {
            C13216j.m79422g(strM81914C);
            C11839m.m70686d("CloudBackupV3ModuleDelete", "delete pms db path result = " + fileM63442h.delete() + ", appId = " + this.f46135h + " uid: " + this.f46134g.m29861N());
        }
        m57742e(this.f46134g.m29398d1());
        new C12812c().m76882a(Collections.singletonList(new String[]{this.f46135h, String.valueOf(this.f46134g.m29861N())}));
        new C12164f(this.f46131d, this.f46135h, 0, this.f46134g.m29861N()).clear();
        String strM81942x = C13617a.m81942x(this.f46131d, this.f46135h, 0, this.f46134g.m29861N());
        C13216j.c cVar = C13216j.c.SNAPSHOT;
        C11309b c11309b = new C11309b(C13216j.m79427l(cVar, strM81942x));
        C11311d c11311d = new C11311d(C13216j.m79427l(cVar, strM81942x));
        c11309b.clear();
        c11311d.clear();
        BackupCacheRecord.delete(C0213f.m1377a(), this.f46135h);
    }

    /* renamed from: l */
    public final void m57750l(List<String> list, AtomicBoolean atomicBoolean) {
        if (atomicBoolean.get()) {
            for (String str : list) {
                try {
                    String strM81942x = C13617a.m81942x(this.f46131d, this.f46135h, 0, this.f46134g.m29861N());
                    C13216j.c cVar = C13216j.c.SNAPSHOT;
                    C11309b c11309b = new C11309b(C13216j.m79427l(cVar, strM81942x));
                    List<C11308a> listM67913e = c11309b.m67913e(str);
                    C11311d c11311d = new C11311d(C13216j.m79427l(cVar, strM81942x));
                    for (C11308a c11308a : listM67913e) {
                        c11311d.m67939b(c11308a.m67883a());
                        c11309b.m67909a(c11308a.m67892j());
                    }
                } catch (Exception e10) {
                    C11839m.m70687e("CloudBackupV3ModuleDelete", "delete " + str + " from slice db error: " + e10.getMessage());
                }
            }
            list.clear();
        }
    }

    /* renamed from: m */
    public void m57751m(String str) throws InterruptedException, SQLException {
        m57752n(true, str);
    }

    /* renamed from: n */
    public void m57752n(boolean z10, String str) throws InterruptedException, SQLException {
        try {
            C11839m.m70688i("CloudBackupV3ModuleDelete", "delete invalid dm files start, appId = " + this.f46135h + ", uid = " + this.f46134g.m29861N());
            C12162d c12162d = new C12162d(this.f46131d, this.f46135h, 0, this.f46134g.m29861N());
            if (!c12162d.m73019h()) {
                C11839m.m70688i("CloudBackupV3ModuleDelete", "del table not exist. appId = " + this.f46135h + ", uid = " + this.f46134g.m29861N());
                return;
            }
            if (c12162d.m73020i() <= 0) {
                C11839m.m70688i("CloudBackupV3ModuleDelete", "no need delete files. appId = " + this.f46135h + ", uid = " + this.f46134g.m29861N());
                return;
            }
            for (Bak bak : this.f46128a.m29645J0()) {
                String id2 = bak.getId();
                String backupVersion = bak.getBackupVersion();
                if (C12590s0.m75921x1(backupVersion) || C12590s0.m75925y1(backupVersion)) {
                    C11839m.m70688i("CloudBackupV3ModuleDelete", "skip successBakId =" + id2 + ",version = " + backupVersion);
                } else {
                    this.f46128a.isCancel();
                    if (m57754p(bak, this.f46135h)) {
                        C11839m.m70688i("CloudBackupV3ModuleDelete", "update temp fileId flag, backup id = " + this.f46131d + ",last backupid = " + id2 + ", appId = " + this.f46135h);
                        C12594t1.m75990o().m76012l(id2, this.f46131d, this.f46135h, this.f46134g.m29861N());
                        C11839m.m70688i("CloudBackupV3ModuleDelete", "update temp fileId flag end.");
                    }
                }
            }
            c12162d.m73016e();
            C11481c c11481c = new C11481c(this.f46135h, c12162d);
            long jM73021j = c12162d.m73021j();
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            c11481c.execute(new InterfaceC11496r() { // from class: dm.a0
                @Override // mm.InterfaceC11496r
                /* renamed from: a */
                public final void mo57663a(AbstractC11494p abstractC11494p, int i10, AtomicBoolean atomicBoolean2, AtomicBoolean atomicBoolean3, String str2) {
                    this.f46036a.m57747i(abstractC11494p, i10, atomicBoolean2, atomicBoolean3, str2);
                }
            }, atomicBoolean, new AtomicBoolean(z10), str);
            if (!atomicBoolean.get()) {
                this.f46128a.m29642H2(this.f46135h, jM73021j);
                c12162d.m73014c();
            }
            C11839m.m70688i("CloudBackupV3ModuleDelete", "delete invalid dm files end, appId = " + this.f46135h + ", uid = " + this.f46134g.m29861N());
        } catch (C9721b e10) {
            C11839m.m70687e("CloudBackupV3ModuleDelete", "delete invalid dm files error: " + e10.toString());
            CloudBackupReport.reportDeleteInvalidDmFilesErr(this.f46135h, e10.getMessage(), this.f46132e);
        }
    }

    /* renamed from: o */
    public final void m57753o(final String str, String str2, int i10, final String str3, final String str4, final String str5) throws C9721b {
        C11839m.m70688i("CloudBackupV3ModuleDelete", "download attachment start, appId:" + str2 + ", assetId:" + str3 + ", , recordId:" + str4 + ", versionId:" + str5);
        String strM63452a = C10279b.m63452a(C10278a.m63437c(C10278a.m63442h(C13617a.m81942x(str, str2, 0, i10))));
        StringBuilder sb2 = new StringBuilder();
        sb2.append(strM63452a);
        sb2.append(File.separator);
        sb2.append(str2);
        sb2.append(FeedbackWebConstants.SUFFIX);
        final String string = sb2.toString();
        C10546a.m64704a(new C10546a.a() { // from class: dm.b0
            @Override // im.C10546a.a
            /* renamed from: a */
            public final InterfaceC10551c0 mo1696a() {
                return this.f46069a.m57756r(str, string, str3, str4, str5);
            }
        }).m64705b();
        boolean zM75805U2 = C12590s0.m75805U2(string, strM63452a);
        if (!C11835i.m70643g(string)) {
            C11839m.m70688i("CloudBackupV3ModuleDelete", "delete file error: " + string + ", appId: " + str2);
        }
        if (!zM75805U2) {
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "get snapshot: " + string + ", appId: " + str2 + ", errordownloadAttachment");
        }
        C11839m.m70688i("CloudBackupV3ModuleDelete", "download attachment end, appId:" + str2 + ", assetId:" + str3 + ", , recordId:" + str4 + ", versionId:" + str5);
    }

    /* renamed from: p */
    public final boolean m57754p(Bak bak, String str) throws InterruptedException, C9721b {
        String str2;
        int i10;
        String str3;
        C9195d0 c9195d0 = this;
        String id2 = bak.getId();
        int i11 = 0;
        if (C10278a.m63442h(C13617a.m81942x(id2, str, 0, c9195d0.f46134g.m29861N())).exists()) {
            C11839m.m70686d("CloudBackupV3ModuleDelete", "downloadSnapshot , file.exists");
        }
        List<App> listM29649L1 = c9195d0.f46128a.m29704f0().get(id2);
        if (listM29649L1 == null || listM29649L1.isEmpty()) {
            C11839m.m70688i("CloudBackupV3ModuleDelete", "downloadSnapshot call list apps of backupId: " + id2);
            listM29649L1 = c9195d0.f46128a.m29649L1(id2, c9195d0.f46128a.m29728n0().mo8329d().getLockId());
            c9195d0.f46128a.m29704f0().put(id2, listM29649L1);
        }
        if (listM29649L1.isEmpty()) {
            throw new C9721b(3912, "list app failed, delete appId: " + str + ", successBakId: " + id2);
        }
        boolean z10 = false;
        for (App app : listM29649L1) {
            c9195d0.f46128a.isCancel();
            if (app.getBackupAppStatus().intValue() == 0) {
                String backupAppName = app.getBackupAppName();
                int iM1685c = C0241z.m1685c(app.getProperties().get("splitappuid"));
                String str4 = ", appId: ";
                if (C12590s0.m75787Q0(app.getProperties())) {
                    C11839m.m70688i("CloudBackupV3ModuleDelete", "skip 3rd app no data, backupId: " + id2 + ", appId: " + backupAppName);
                } else {
                    List<Attachment> attachments = app.getAttachments();
                    if (attachments == null || attachments.isEmpty()) {
                        C11839m.m70689w("CloudBackupV3ModuleDelete", "app attachment empty, delete appId: " + str + ", successBakId: " + id2 + ", moduleAppId: " + backupAppName);
                        if (TextUtils.equals(str, backupAppName)) {
                            throw new C9721b(3912, "app attachment empty, delete appId: " + str + ", successBakId: " + id2 + ", moduleAppId: " + backupAppName);
                        }
                    }
                    if (attachments == null) {
                        return z10;
                    }
                    boolean z11 = z10;
                    for (Attachment attachment : attachments) {
                        c9195d0.f46128a.isCancel();
                        if (attachment.getState().intValue() == 0 && SnapshotDBManager.PREFIX_DATABASE_NAME.equalsIgnoreCase(attachment.getUsage())) {
                            File fileM63442h = C10278a.m63442h(C13617a.m81942x(id2, backupAppName, i11, iM1685c));
                            if (fileM63442h.exists()) {
                                str2 = str4;
                                i10 = iM1685c;
                                str3 = backupAppName;
                                String orDefault = app.getProperties().getOrDefault("hashSha256", "");
                                Md5AndHash md5AndHashM68622d = C11476b.m68622d(fileM63442h);
                                if (TextUtils.isEmpty(orDefault) || orDefault.equals(md5AndHashM68622d.getHash())) {
                                    C11839m.m70688i("CloudBackupV3ModuleDelete", "not need download v3 snapshot, backupId: " + id2 + str2 + str3);
                                } else {
                                    C11839m.m70689w("CloudBackupV3ModuleDelete", id2 + " snapshot is invalid hash: " + str3);
                                    if (!C11835i.m70642f(fileM63442h)) {
                                        throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "delete snapshot fail !!");
                                    }
                                    m57753o(id2, str3, i10, attachment.getAssetId(), app.getId(), attachment.getVersionId());
                                }
                            } else {
                                str2 = str4;
                                i10 = iM1685c;
                                str3 = backupAppName;
                                m57753o(id2, backupAppName, iM1685c, attachment.getAssetId(), app.getId(), attachment.getVersionId());
                            }
                            if (TextUtils.equals(str, str3)) {
                                z11 = true;
                            }
                        } else {
                            str2 = str4;
                            i10 = iM1685c;
                            str3 = backupAppName;
                        }
                        backupAppName = str3;
                        str4 = str2;
                        iM1685c = i10;
                        i11 = 0;
                        c9195d0 = this;
                    }
                    c9195d0 = this;
                    z10 = z11;
                }
            }
        }
        return z10;
    }

    /* renamed from: q */
    public final /* synthetic */ CloudBackupV3Request m57755q(FileDelete fileDelete, AtomicReference atomicReference, String str, CloudBackupV3Server cloudBackupV3Server) throws IOException {
        File.Delete delete = cloudBackupV3Server.backup().device().file().delete(fileDelete);
        delete.setBackupAction(this.f46129b).setBackupDeviceId(this.f46130c).setXHwBackupPackageName(this.f46135h).setXHwBackupid(this.f46131d).setLockId((String) atomicReference.get()).setBakCategory(this.f46128a.m29587j()).setOccupySpaceType(this.f46128a.m29636F0()).setOpSceneParam(new C11732m("12", "from client," + str));
        return delete;
    }

    /* renamed from: r */
    public final /* synthetic */ InterfaceC10551c0 m57756r(String str, String str2, String str3, String str4, String str5) throws C9721b {
        return new C10560j(str, this.f46132e, this.f46133f, str2, this.f46129b, str3, str4, str5);
    }

    /* JADX WARN: Not initialized variable reg: 10, insn: 0x0069: MOVE (r6 I:??[OBJECT, ARRAY]) = (r10 I:??[OBJECT, ARRAY]), block:B:35:0x0069 */
    /* renamed from: s */
    public void m57757s(String str) throws C9721b {
        String str2;
        C9721b e10;
        String str3;
        String str4;
        String str5 = "reset one module start, appId = " + this.f46135h + ", uid = " + this.f46134g.m29861N();
        C11839m.m70688i("CloudBackupV3ModuleDelete", str5);
        try {
            try {
                C12815f c12815f = new C12815f(this.f46129b);
                m57758t(c12815f, str);
                m57744f();
                m57759u(c12815f, str);
                str4 = "reset one module end, appId = " + this.f46135h + " uid = " + this.f46134g.m29861N();
            } catch (C9721b e11) {
                e10 = e11;
            } catch (Throwable th2) {
                th = th2;
                str2 = str5;
                CloudBackupReport.reportAppModuleReset(true, this.f46135h, this.f46132e, this.f46131d, this.f46129b, str2, str);
                throw th;
            }
            try {
                C11839m.m70688i("CloudBackupV3ModuleDelete", str4);
                CloudBackupReport.reportAppModuleReset(true, this.f46135h, this.f46132e, this.f46131d, this.f46129b, str4, str);
            } catch (C9721b e12) {
                e10 = e12;
                String str6 = "reset one module error, appId = " + this.f46135h + " uid = " + this.f46134g.m29861N() + " ,error: " + e10.getMessage();
                try {
                    throw e10;
                } catch (Throwable th3) {
                    str2 = str6;
                    th = th3;
                    CloudBackupReport.reportAppModuleReset(true, this.f46135h, this.f46132e, this.f46131d, this.f46129b, str2, str);
                    throw th;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            str2 = str3;
            CloudBackupReport.reportAppModuleReset(true, this.f46135h, this.f46132e, this.f46131d, this.f46129b, str2, str);
            throw th;
        }
    }

    /* renamed from: t */
    public final void m57758t(C12815f c12815f, String str) throws C9721b {
        this.f46134g.mo29338z0(0).mo29289A0(-1).mo29310W(0).mo29308V(0L).m29436s2(0L).m29374R1(0L).m29365N1("").m29348F1("").m29350G1("").m29342C1(0L).m29401e2("").m29423n2(0L);
        c12815f.m76934m(this.f46134g);
    }

    /* renamed from: u */
    public final void m57759u(C12815f c12815f, String str) throws C9721b {
        String strM29398d1 = this.f46134g.m29398d1();
        if (!C4633d0.m28404a(strM29398d1)) {
            String strValueOf = this.f46134g.m29861N() != 0 ? String.valueOf(this.f46134g.m29861N()) : "";
            this.f46136i.m63549L(this.f46128a.m29728n0(), this.f46130c, this.f46131d, strM29398d1, this.f46134g.m29870d(), strValueOf, 0, null, new C11732m("12", "from client," + str));
        }
        C12574n.m75555h(C0213f.m1377a(), this.f46135h, this.f46134g.mo29421n(), this.f46134g.m29861N());
        m57749k();
        this.f46134g.m29405g2("");
        this.f46134g.mo29289A0(0);
        c12815f.m76934m(this.f46134g);
        C11963c.m71970y(this.f46134g, this.f46129b);
    }

    /* renamed from: v */
    public void m57760v(String str) throws C9721b {
        C11839m.m70688i("CloudBackupV3ModuleDelete", "safeReset one module start, appId = " + this.f46135h + ", uid = " + this.f46134g.m29861N());
        C12815f c12815f = new C12815f(this.f46129b);
        m57758t(c12815f, str);
        try {
            m57744f();
        } catch (Exception e10) {
            C11839m.m70687e("CloudBackupV3ModuleDelete", e10.getMessage());
        }
        m57759u(c12815f, str);
        C11839m.m70688i("CloudBackupV3ModuleDelete", "reset one module end, appId = " + this.f46135h + " uid = " + this.f46134g.m29861N());
    }
}
