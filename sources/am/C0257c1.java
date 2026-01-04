package am;

import android.os.SystemClock;
import android.text.TextUtils;
import cm.C1457c;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.cloudbackup.p076db.operator.SettingOperator;
import com.huawei.android.hicloud.cloudbackup.process.CBLockTimer;
import com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.SnapshotDBManager;
import com.huawei.android.hicloud.cloudbackup.util.ICBUtil;
import com.huawei.cloud.base.http.C4609l;
import com.huawei.cloud.base.util.C4644l;
import com.huawei.hicloud.base.drive.model.ErrorResp;
import com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request;
import com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Server;
import com.huawei.hicloud.cloudbackup.p104v3.server.batch.CloudBackupV3BatchCallback;
import com.huawei.hicloud.cloudbackup.p104v3.server.batch.CloudBackupV3BatchRequest;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.App;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.AppList;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.Attachment;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.Bak;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.BakList;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.BakRefresh;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.FileDelete;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.FileDeleteLogs;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.Lock;
import com.huawei.hicloud.cloudbackup.p104v3.server.request.Bak;
import com.huawei.hicloud.cloudbackup.p104v3.server.request.File;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.phoneservice.feedbackcommon.network.FeedbackWebConstants;
import fk.C9721b;
import hk.C10278a;
import hm.C10321z;
import im.C10546a;
import im.C10560j;
import im.InterfaceC10551c0;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mm.AbstractC11494p;
import mm.C11489k;
import mm.InterfaceC11495q;
import p015ak.C0241z;
import p429kk.C11058a;
import p458lo.C11322a;
import p495nm.C11732m;
import p514o9.C11835i;
import p514o9.C11839m;
import p618rm.C12590s0;
import p682ul.C13216j;
import p709vj.C13452e;
import p711vl.C13466f;
import p744wl.C13617a;
import p814yl.C14000c0;
import pl.C12161c;
import pl.C12164f;

/* renamed from: am.c1 */
/* loaded from: classes6.dex */
public class C0257c1 extends AbstractC0249a {

    /* renamed from: b */
    public String f899b;

    /* renamed from: c */
    public String f900c;

    /* renamed from: d */
    public CBLockTimer f901d;

    /* renamed from: j */
    public C9721b f907j;

    /* renamed from: q */
    public boolean f914q;

    /* renamed from: r */
    public boolean f915r;

    /* renamed from: s */
    public boolean f916s;

    /* renamed from: e */
    public String f902e = "";

    /* renamed from: f */
    public Map<String, List<App>> f903f = new HashMap();

    /* renamed from: g */
    public List<Bak> f904g = new ArrayList();

    /* renamed from: h */
    public List<Bak> f905h = new ArrayList();

    /* renamed from: i */
    public List<Bak> f906i = new ArrayList();

    /* renamed from: k */
    public String f908k = "Refurbishment";

    /* renamed from: o */
    public String f912o = C13452e.m80781L().m80950o();

    /* renamed from: p */
    public int f913p = C13452e.m80781L().m80978v();

    /* renamed from: l */
    public String f909l = C11058a.m66627b("02007");

    /* renamed from: m */
    public C11322a f910m = new C11322a(this.f909l);

    /* renamed from: n */
    public C10321z f911n = new C10321z(this.f908k, null, null, "delete", this.f909l);

    /* renamed from: am.c1$b */
    public class b extends CloudBackupV3BatchCallback<Void> {
        public b() {
        }

        @Override // com.huawei.hicloud.cloudbackup.p104v3.server.batch.CloudBackupV3BatchCallback, p369ii.InterfaceC10510a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(Void r12, C4609l c4609l) throws IOException {
            C11839m.m70686d("DeleteRefurbishV3Task", "batch delete sussess");
        }

        @Override // com.huawei.hicloud.cloudbackup.p104v3.server.batch.CloudBackupV3BatchCallback
        public void onFailure(ErrorResp.Error error, C4609l c4609l) throws IOException {
            List<ErrorResp.ErrorMsg> errorDetail = error.getErrorDetail();
            if (errorDetail == null || errorDetail.isEmpty()) {
                C0257c1.this.f907j = new C9721b(3911, "delete failed no errorDetail");
                return;
            }
            ErrorResp.ErrorMsg errorMsg = errorDetail.get(0);
            String errorCode = errorMsg.getErrorCode();
            String description = errorMsg.getDescription();
            if (String.valueOf(51004921).equals(errorCode)) {
                C11839m.m70686d("DeleteRefurbishV3Task", "server delete reference file error: " + description + " ,errorCode: " + errorCode);
                return;
            }
            if (!errorCode.endsWith(String.valueOf(4011)) && !errorCode.endsWith(String.valueOf(4041))) {
                C0257c1.this.f907j = new C9721b(3911, "delete error: " + description + " code: " + errorCode);
            }
            C11839m.m70686d("DeleteRefurbishV3Task", "delete error: " + description + " ,errorCode: " + errorCode);
        }
    }

    public C0257c1(String str, String str2, boolean z10, boolean z11, boolean z12) {
        this.f899b = str;
        this.f900c = str2;
        this.f916s = z11;
        this.f914q = z10;
        this.f915r = z12;
    }

    /* renamed from: A */
    private boolean m1698A(C9721b c9721b) {
        if (String.valueOf(c9721b.m60663g()).endsWith(String.valueOf(4041))) {
            return true;
        }
        if (c9721b.m60659c() == 3911 && c9721b.m60663g() == 404) {
            return true;
        }
        C11839m.m70688i("DeleteRefurbishV3Task", "code : " + c9721b.m60659c() + "errorCode: " + c9721b.m60663g() + ", message: " + c9721b.getMessage());
        return false;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Bak$List] */
    /* renamed from: F */
    public static /* synthetic */ CloudBackupV3Request m1699F(String str, String str2, String str3, CloudBackupV3Server cloudBackupV3Server) throws IOException {
        Bak.List list = cloudBackupV3Server.backup().device().bak().list();
        list.setFields(str).setBackupAction(str2).setBackupDeviceId(str3).setHeader("x-hw-contain-refurbishment", Boolean.TRUE);
        return list;
    }

    /* renamed from: I */
    private List<App> m1700I(String str) throws C9721b {
        AppList appListM1718G = m1718G(str, null);
        ArrayList arrayList = new ArrayList(appListM1718G.getApps());
        String nextCursor = appListM1718G.getNextCursor();
        while (nextCursor != null && !nextCursor.isEmpty()) {
            AppList appListM1718G2 = m1718G(str, nextCursor);
            arrayList.addAll(appListM1718G2.getApps());
            nextCursor = appListM1718G2.getNextCursor();
        }
        return arrayList;
    }

    /* renamed from: K */
    private void m1701K() {
        if (this.f877a != null) {
            C11839m.m70688i("DeleteRefurbishV3Task", "end delete lock.");
            this.f877a.m8336i();
        }
        if (this.f901d != null) {
            try {
                try {
                    this.f910m.m68013T(this.f912o, "", this.f913p, 1);
                } catch (C9721b unused) {
                    C11839m.m70687e("DeleteRefurbishV3Task", "unlock delete lock requeset exception");
                }
            } finally {
                deleteUnLock();
            }
        }
    }

    /* renamed from: k */
    private int m1708k(int i10, String str, List<FileDelete> list, int i11, int i12, int i13) throws C9721b {
        if (!list.isEmpty() && (list.size() >= i10 || i13 >= i11)) {
            m1721j(list, str);
            i12 += list.size();
            list.clear();
            C9721b c9721b = this.f907j;
            if (c9721b != null) {
                throw c9721b;
            }
        }
        return i12;
    }

    private void lock() throws C9721b {
        C11839m.m70688i("DeleteRefurbishV3Task", "start delete lock.");
        C1457c c1457c = new C1457c(this.f911n, this.f899b, "", C13466f.m81073d().m81079g("gradeCode", "N"), 1, 1L, false, false, "", "");
        this.f877a = c1457c;
        c1457c.m8337j(null);
        List<String> cloudControlAction = this.f877a.mo8329d().getCloudControlAction();
        if (cloudControlAction != null && !cloudControlAction.isEmpty() && cloudControlAction.contains("2")) {
            this.f902e = "2";
        }
        this.f877a.m8328c();
        C11839m.m70688i("DeleteRefurbishV3Task", "deleteRecordAction: " + this.f902e);
    }

    /* renamed from: n */
    private void m1709n(List<App> list, String str) throws C9721b {
        for (App app : list) {
            String id2 = app.getId();
            C11839m.m70686d("DeleteRefurbishV3Task", "deleteV3AppBySnapshotFlag backupId: " + str + " appId: " + app.getBackupAppName());
            this.f911n.m63549L(this.f877a, this.f899b, str, id2, app.getBackupAppName(), app.getSplitApkType(), 0, null, new C11732m("10", "from client,DeleteRefurbishV3Task_delete_app"));
        }
    }

    /* renamed from: o */
    private void m1710o(List<App> list, final String str) throws C9721b {
        final int iQueryMaxBatchNumber = new SettingOperator().queryMaxBatchNumber();
        for (App app : list) {
            if (m1713z(app) == null) {
                C11839m.m70688i("DeleteRefurbishV3Task", "invalid app do not has snapshot, return.");
            } else {
                final String backupAppName = app.getBackupAppName();
                final int iM1685c = C0241z.m1685c(app.getProperties().get("splitappuid"));
                C12164f c12164f = new C12164f(str, backupAppName, 0, iM1685c);
                c12164f.m73041I0();
                C11489k c11489k = new C11489k(backupAppName, c12164f);
                final ArrayList arrayList = new ArrayList();
                c11489k.execute(new InterfaceC11495q() { // from class: am.x0
                    @Override // mm.InterfaceC11495q
                    /* renamed from: a */
                    public final void mo1695a(AbstractC11494p abstractC11494p, int i10) throws C9721b {
                        this.f1047a.m1715C(backupAppName, iM1685c, arrayList, iQueryMaxBatchNumber, str, abstractC11494p, i10);
                    }
                });
            }
        }
    }

    /* renamed from: q */
    private void m1711q(Map<String, List<FileDelete>> map) throws C9721b {
        for (Map.Entry<String, List<FileDelete>> entry : map.entrySet()) {
            m1721j(entry.getValue(), entry.getKey());
            C9721b c9721b = this.f907j;
            if (c9721b != null) {
                throw c9721b;
            }
        }
    }

    /* renamed from: s */
    private void m1712s(final String str, App app) throws C9721b {
        C11839m.m70686d("DeleteRefurbishV3Task", "downloadV3Snapshot backupId:" + str + " ,app: " + app.getBackupAppName());
        Attachment attachmentM1713z = m1713z(app);
        if (attachmentM1713z == null) {
            C11839m.m70688i("DeleteRefurbishV3Task", "app snapshot is null");
            return;
        }
        String backupAppName = app.getBackupAppName();
        if (C13617a.m81938t(str, backupAppName, 0, C0241z.m1685c(app.getProperties().get("splitappuid")))) {
            return;
        }
        C11839m.m70688i("DeleteRefurbishV3Task", "download v3 snapshot db, backupId = " + str + ", appId = " + backupAppName);
        String strM81939u = C13617a.m81939u(str);
        final String str2 = strM81939u + "/" + backupAppName + FeedbackWebConstants.SUFFIX;
        File fileM63442h = C10278a.m63442h(str2);
        final String assetId = attachmentM1713z.getAssetId();
        final String id2 = app.getId();
        final String versionId = attachmentM1713z.getVersionId();
        C10546a.m64704a(new C10546a.a() { // from class: am.a1
            @Override // im.C10546a.a
            /* renamed from: a */
            public final InterfaceC10551c0 mo1696a() {
                return this.f884a.m1716D(str, str2, assetId, id2, versionId);
            }
        }).m64705b();
        if (!C12590s0.m75805U2(str2, strM81939u)) {
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "unzip file: " + fileM63442h.getName());
        }
        if (!fileM63442h.delete()) {
            C11839m.m70689w("DeleteRefurbishV3Task", "download snapshot tar file: " + fileM63442h.getName() + ", delete error.");
        }
        C11839m.m70688i("DeleteRefurbishV3Task", "download v3 snapshot db success");
    }

    /* renamed from: z */
    private Attachment m1713z(App app) {
        for (Attachment attachment : app.getAttachments()) {
            if (TextUtils.equals(attachment.getUsage(), SnapshotDBManager.PREFIX_DATABASE_NAME)) {
                return attachment;
            }
        }
        return null;
    }

    /* renamed from: B */
    public final /* synthetic */ CloudBackupV3Request m1714B(FileDelete fileDelete, String str, Lock lock, CloudBackupV3Server cloudBackupV3Server) throws IOException {
        File.Delete delete = cloudBackupV3Server.backup().device().file().delete(fileDelete);
        delete.setBackupAction(this.f908k).setBackupDeviceId(this.f899b).setXHwBackupPackageName(str).setXHwBackupid(this.f900c).setLockId(lock.getLockId()).setOpSceneParam(new C11732m("10", "from client,DeleteRefurbishV3Task_delete_file"));
        return delete;
    }

    /* renamed from: C */
    public final /* synthetic */ void m1715C(String str, int i10, List list, int i11, String str2, AbstractC11494p abstractC11494p, int i12) throws C9721b {
        int iM1708k = 0;
        for (int i13 = 1; i13 <= i12; i13++) {
            C12161c c12161c = (C12161c) abstractC11494p.query(i13);
            if (c12161c == null) {
                C11839m.m70689w("DeleteRefurbishV3Task", "deleteV3FileBySnapshotFlag backupMeta is empty appId: " + str + ", uid: " + i10);
            } else {
                if (!TextUtils.isEmpty(c12161c.m72984h())) {
                    FileDelete fileDelete = new FileDelete();
                    fileDelete.setCloudPath(c12161c.m72984h());
                    fileDelete.setLogs(FileDeleteLogs.getFileDeleteLogs(c12161c.m72951G(), (int) c12161c.m72953I(), c12161c.m72999p(), true, c12161c.m72948D()).toString());
                    list.add(fileDelete);
                }
                int iM1708k2 = m1708k(i11, str, list, i12, iM1708k, i13);
                if (!TextUtils.isEmpty(c12161c.m73009x())) {
                    FileDelete fileDelete2 = new FileDelete();
                    FileDeleteLogs fileDeleteLogs = FileDeleteLogs.getFileDeleteLogs(c12161c.m72951G(), (int) c12161c.m72953I(), c12161c.m72999p(), true, c12161c.m72948D());
                    fileDelete2.setId(c12161c.m73009x());
                    fileDelete2.setLogs(fileDeleteLogs.toString());
                    list.add(fileDelete2);
                }
                iM1708k = m1708k(i11, str, list, i12, iM1708k2, i13);
                C11839m.m70688i("DeleteRefurbishV3Task", "deleteV3FileBySnapshotFlag fileId: " + c12161c.m73009x() + " cloudpath: " + c12161c.m72984h() + ", path:" + c12161c.m72991l());
            }
        }
        C11839m.m70688i("DeleteRefurbishV3Task", "delete v3 files backupId: " + str2 + ", appId: " + str + ", uid: " + i10 + ", summary:" + i12 + " ,sum: " + iM1708k);
    }

    /* renamed from: D */
    public final /* synthetic */ InterfaceC10551c0 m1716D(String str, String str2, String str3, String str4, String str5) throws C9721b {
        return new C10560j(str, this.f909l, this.f877a, str2, this.f908k, str3, str4, str5);
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Bak$App$List] */
    /* renamed from: E */
    public final /* synthetic */ CloudBackupV3Request m1717E(String str, String str2, String str3, CloudBackupV3Server cloudBackupV3Server) throws IOException {
        Bak.App.List list = cloudBackupV3Server.backup().device().bak().app().list();
        list.setFields(str).setHeader("x-hw-masking-apps-version", (Object) "V1").setHeader("x-hw-appduplicator", (Object) "1").setBackupAction(this.f908k).setBackupDeviceId(this.f899b).setBakId(str2).setLockId(this.f877a.mo8329d().getLockId()).setCursor(str3).setIncludeDeleted(1).setPageSize(100).setXHwBackupid(str2).setUsage(SnapshotDBManager.PREFIX_DATABASE_NAME);
        return list;
    }

    /* renamed from: G */
    public final AppList m1718G(final String str, final String str2) throws C9721b {
        final String str3 = "nextCursor,apps(id,backupAppName,apkType,runtimeType,backupAppStatus,appTotalSize,fileCount,packageVersion,createTime,updateTime,endTime,properties,attachments(assetId,versionId,usage,state,type,hash,objects,downloadUrl),splitApkType)";
        return (AppList) new C14000c0(new C14000c0.a() { // from class: am.z0
            @Override // p814yl.C14000c0.a
            /* renamed from: a */
            public final CloudBackupV3Request mo1697a(CloudBackupV3Server cloudBackupV3Server) {
                return this.f1060a.m1717E(str3, str, str2, cloudBackupV3Server);
            }
        }).m84139b("Backup.device.bak.apps.list", this.f909l);
    }

    /* renamed from: H */
    public BakList m1719H(String str, final String str2, final String str3) throws C9721b {
        final String str4 = "baks(id,backupVersion,backupStatus,startTime,updateTime,endTime,device,isRefurbishment,gradeCode)";
        return (BakList) new C14000c0(new C14000c0.a() { // from class: am.b1
            @Override // p814yl.C14000c0.a
            /* renamed from: a */
            public final CloudBackupV3Request mo1697a(CloudBackupV3Server cloudBackupV3Server) {
                return C0257c1.m1699F(str4, str2, str3, cloudBackupV3Server);
            }
        }).m84139b("Backup.device.baks.list", str);
    }

    /* renamed from: J */
    public com.huawei.hicloud.cloudbackup.p104v3.server.model.Bak m1720J(int i10, String str) throws C9721b {
        C11839m.m70688i("DeleteRefurbishV3Task", "refurbish backup record: " + str);
        BakRefresh bakRefresh = new BakRefresh();
        bakRefresh.setUpdateTime(new C4644l(System.currentTimeMillis())).setBackupStatus(Integer.valueOf(i10));
        return this.f911n.m63535A0(this.f877a, this.f899b, str, bakRefresh, 0, null);
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws C9721b {
        C11839m.m70688i("DeleteRefurbishV3Task", "delete refurbish v3 task begin.");
        try {
            try {
            } catch (C9721b e10) {
                C11839m.m70687e("DeleteRefurbishV3Task", "delete refurbish v3 task error: " + e10.getMessage());
            }
            if (TextUtils.isEmpty(this.f899b)) {
                C11839m.m70688i("DeleteRefurbishV3Task", "v3 backup deviceId is null.");
            } else {
                if (this.f914q) {
                    SystemClock.sleep(1500L);
                }
                if (!TextUtils.isEmpty(this.f900c) && this.f916s) {
                    lock();
                    C11839m.m70688i("DeleteRefurbishV3Task", "start refresh invalid refurbish record: " + this.f900c);
                    m1720J(7, this.f900c);
                }
                m1728v();
                if (this.f904g.size() == 0 && this.f905h.size() == 0 && this.f906i.size() == 0) {
                    C11839m.m70688i("DeleteRefurbishV3Task", "refurbish backup records is empty.");
                } else {
                    m1723m();
                    m1722l();
                    if (this.f904g.size() != 0) {
                        if (this.f877a == null) {
                            lock();
                        }
                        m1725r(this.f904g);
                        for (com.huawei.hicloud.cloudbackup.p104v3.server.model.Bak bak : this.f904g) {
                            if (bak == null) {
                                C11839m.m70688i("DeleteRefurbishV3Task", "invalid record is null.");
                            } else {
                                try {
                                    String id2 = bak.getId();
                                    C11839m.m70688i("DeleteRefurbishV3Task", "delete v3 backup record, id = " + id2 + ", version = " + bak.getBackupVersion());
                                    List<App> list = this.f903f.get(id2);
                                    if (list == null) {
                                        C11839m.m70688i("DeleteRefurbishV3Task", "invalid app list is null.");
                                    } else {
                                        m1710o(list, id2);
                                        m1711q(m1727u(list));
                                        m1709n(list, id2);
                                        this.f911n.m63548K(this.f877a, this.f899b, id2, 0, null, new C11732m("10", "from client,DeleteRefurbishV3Task_delete_bak"));
                                        m1724p(id2);
                                        C11839m.m70688i("DeleteRefurbishV3Task", "delete record finish: " + id2);
                                    }
                                } catch (C9721b e11) {
                                    C11839m.m70687e("DeleteRefurbishV3Task", "delete refurbish record error: " + e11.getMessage());
                                }
                            }
                        }
                        return;
                    }
                    C11839m.m70688i("DeleteRefurbishV3Task", "refurbish invalid record is empty.");
                }
            }
        } finally {
            m1701K();
            C13216j.m79423h();
        }
    }

    public void deleteUnLock() {
        CBLockTimer cBLockTimer = this.f901d;
        if (cBLockTimer != null) {
            cBLockTimer.cancel();
            this.f901d = null;
        }
    }

    @Override // p616rk.AbstractRunnableC12516b
    public String getTag() {
        return "DeleteRefurbishV3Task";
    }

    /* renamed from: j */
    public final void m1721j(List<FileDelete> list, final String str) throws C9721b {
        if (list == null || list.isEmpty()) {
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "deleteV3File batch query result empty");
        }
        final Lock lockMo8329d = this.f877a.mo8329d();
        CloudBackupV3BatchRequest cloudBackupV3BatchRequest = new CloudBackupV3BatchRequest();
        for (final FileDelete fileDelete : list) {
            new C14000c0(new C14000c0.a() { // from class: am.y0
                @Override // p814yl.C14000c0.a
                /* renamed from: a */
                public final CloudBackupV3Request mo1697a(CloudBackupV3Server cloudBackupV3Server) {
                    return this.f1054a.m1714B(fileDelete, str, lockMo8329d, cloudBackupV3Server);
                }
            }).m84143f(cloudBackupV3BatchRequest, new b());
        }
        cloudBackupV3BatchRequest.execute("Backup.device.file.delete", this.f909l);
    }

    /* renamed from: l */
    public final void m1722l() throws C9721b {
        if (this.f906i.size() > 0) {
            C11839m.m70688i("DeleteRefurbishV3Task", "check refresh record.");
            com.huawei.hicloud.cloudbackup.p104v3.server.model.Bak bak = this.f906i.get(0);
            if (bak != null) {
                if (this.f877a == null) {
                    lock();
                }
                m1720J(7, bak.getId());
                this.f904g.add(bak);
            }
        }
    }

    /* renamed from: m */
    public final void m1723m() throws C9721b {
        if (this.f905h.size() > CloudBackupConstant.UserPackageInfo.NORMAL_BACKUP_RECORDS.intValue()) {
            C11839m.m70688i("DeleteRefurbishV3Task", "check success record, size is more than limit.");
            com.huawei.hicloud.cloudbackup.p104v3.server.model.Bak bakM1729y = m1729y(this.f905h);
            if (bakM1729y != null) {
                if (this.f877a == null) {
                    lock();
                }
                m1720J(7, bakM1729y.getId());
                this.f904g.add(bakM1729y);
            }
        }
    }

    /* renamed from: p */
    public final void m1724p(String str) {
        C11839m.m70686d("DeleteRefurbishV3Task", "deleteV3LocalSnapshot: " + str + " ,result: " + C11835i.m70643g(C13617a.m81939u(str)));
    }

    /* renamed from: r */
    public final void m1725r(List<com.huawei.hicloud.cloudbackup.p104v3.server.model.Bak> list) throws C9721b {
        C11839m.m70688i("DeleteRefurbishV3Task", "download invalid records.");
        Iterator<com.huawei.hicloud.cloudbackup.p104v3.server.model.Bak> it = list.iterator();
        while (it.hasNext()) {
            String id2 = it.next().getId();
            List<App> listM1700I = m1700I(id2);
            ArrayList arrayList = new ArrayList();
            for (App app : listM1700I) {
                try {
                    m1712s(id2, app);
                } catch (C9721b e10) {
                    C11839m.m70687e("DeleteRefurbishV3Task", "download v3 snapshot error: " + e10.getMessage());
                    if (!m1698A(e10) || !"2".equals(this.f902e)) {
                        throw e10;
                    }
                    arrayList.add(app);
                }
            }
            this.f903f.put(id2, listM1700I);
            if (!arrayList.isEmpty()) {
                C11839m.m70688i("DeleteRefurbishV3Task", "snapshot not exist list is not empty, need process record");
            }
        }
    }

    /* renamed from: t */
    public final List<FileDelete> m1726t(App app) {
        Map<String, String> properties = app.getProperties();
        if (properties.isEmpty()) {
            C11839m.m70686d("DeleteRefurbishV3Task", "invalid app not contains notStand app");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        String str = properties.get("apkServerPath");
        if (!TextUtils.isEmpty(str)) {
            C11839m.m70688i("DeleteRefurbishV3Task", "need delete not stand apk: " + str);
            FileDelete fileDelete = new FileDelete();
            fileDelete.setCloudPath(str.substring(str.lastIndexOf("/") + 1));
            fileDelete.setLogs(FileDeleteLogs.getFileDeleteLogs(C0241z.m1688f(properties.get("apksize")), 0, null, true, ".apk").toString());
            arrayList.add(fileDelete);
        }
        String str2 = properties.get("iconServerPath");
        if (!TextUtils.isEmpty(str2)) {
            C11839m.m70688i("DeleteRefurbishV3Task", "need delete not stand icon: " + str2);
            FileDelete fileDelete2 = new FileDelete();
            fileDelete2.setCloudPath(str2.substring(str2.lastIndexOf("/") + 1));
            fileDelete2.setLogs(FileDeleteLogs.getFileDeleteLogs(C0241z.m1688f(properties.get("iconsize")), 0, null, true, ".icon").toString());
            arrayList.add(fileDelete2);
        }
        return arrayList;
    }

    /* renamed from: u */
    public final Map<String, List<FileDelete>> m1727u(List<App> list) {
        HashMap map = new HashMap();
        for (App app : list) {
            String backupAppName = app.getBackupAppName();
            List<FileDelete> listM1726t = m1726t(app);
            if (listM1726t != null && !listM1726t.isEmpty()) {
                map.put(backupAppName, listM1726t);
            }
        }
        return map;
    }

    /* renamed from: v */
    public final void m1728v() throws C9721b {
        List<com.huawei.hicloud.cloudbackup.p104v3.server.model.Bak> baks = m1719H(this.f909l, this.f908k, this.f899b).getBaks();
        if (baks.size() == 0) {
            return;
        }
        for (com.huawei.hicloud.cloudbackup.p104v3.server.model.Bak bak : baks) {
            if (!bak.isRefurbishment()) {
                C11839m.m70686d("DeleteRefurbishV3Task", "skip not refurbishment record id: " + bak.getId());
            } else if (!this.f915r && bak.getBackupStatus().intValue() == 1) {
                C11839m.m70688i("DeleteRefurbishV3Task", "bak status is default: " + bak.getId());
                this.f906i.add(bak);
            } else if (bak.getBackupStatus().intValue() == 7) {
                C11839m.m70688i("DeleteRefurbishV3Task", "bak status is invalid: " + bak.getId());
                this.f904g.add(bak);
            } else if (bak.getBackupStatus().intValue() == 0) {
                C11839m.m70688i("DeleteRefurbishV3Task", "bak status is success: " + bak.getId());
                this.f905h.add(bak);
            }
        }
    }

    /* renamed from: y */
    public final com.huawei.hicloud.cloudbackup.p104v3.server.model.Bak m1729y(List<com.huawei.hicloud.cloudbackup.p104v3.server.model.Bak> list) {
        String deviceId;
        com.huawei.hicloud.cloudbackup.p104v3.server.model.Bak bak = null;
        for (com.huawei.hicloud.cloudbackup.p104v3.server.model.Bak bak2 : list) {
            if (bak2.getBackupStatus().intValue() == 0 && (deviceId = ICBUtil.parseDeviceId(bak2)) != null && !deviceId.isEmpty() && this.f912o.equals(deviceId)) {
                if (bak == null) {
                    C11839m.m70688i("DeleteRefurbishV3Task", "get oldest bak is: " + bak2.getId());
                } else if (bak.getEndTime().m28458c() > bak2.getEndTime().m28458c()) {
                    C11839m.m70688i("DeleteRefurbishV3Task", "get oldest bak update is: " + bak2.getId());
                }
                bak = bak2;
            }
        }
        return bak;
    }
}
