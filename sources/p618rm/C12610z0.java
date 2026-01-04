package p618rm;

import android.content.Context;
import android.database.SQLException;
import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.process.util.ProgressCallback;
import com.huawei.android.hicloud.cloudbackup.snapshottree.SnapshotTreeManagementService;
import com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.SnapshotDBManager;
import com.huawei.hicloud.cloudbackup.p104v3.core.C4879a;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.App;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.Attachment;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.Bak;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.Lock;
import com.huawei.hicloud.cloudbackup.store.database.status.CloudBackupStatus;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.request.cbs.bean.CBSBackupRecord;
import com.huawei.phoneservice.feedbackcommon.network.FeedbackWebConstants;
import fk.C9721b;
import gp.C10028c;
import hk.C10278a;
import hk.C10279b;
import im.C10546a;
import im.C10560j;
import im.InterfaceC10551c0;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mk.C11476b;
import p015ak.C0213f;
import p015ak.C0241z;
import p514o9.C11835i;
import p514o9.C11839m;
import p606r9.C12478a;
import p652t9.EnumC12999a;
import p709vj.C13452e;
import p744wl.C13617a;

/* renamed from: rm.z0 */
/* loaded from: classes6.dex */
public class C12610z0 {

    /* renamed from: a */
    public C4879a f58017a;

    /* renamed from: b */
    public String f58018b;

    /* renamed from: c */
    public String f58019c;

    /* renamed from: d */
    public String f58020d;

    /* renamed from: e */
    public String f58021e;

    /* renamed from: f */
    public String f58022f = C10279b.m63452a(C10278a.m63442h(m76093j().getFilesDir() + "/cloudbackup"));

    /* renamed from: g */
    public Map<String, String> f58023g;

    public C12610z0(C4879a c4879a, String str, String str2, String str3, String str4, Map<String, String> map) {
        this.f58023g = new HashMap();
        this.f58017a = c4879a;
        this.f58018b = str2;
        this.f58019c = str;
        this.f58020d = str3;
        this.f58021e = str4;
        this.f58023g = map;
    }

    /* renamed from: o */
    public static /* synthetic */ InterfaceC10551c0 m76084o(C10560j c10560j) throws C9721b {
        return c10560j;
    }

    /* renamed from: b */
    public final void m76085b(String str, String str2, int i10, String str3, String str4, String str5) throws C9721b {
        C11839m.m70688i("DownloadSnapshotUtil", "download attachment begin, appid:" + str2 + ", uid:" + i10 + ", assetId:" + str3 + ", , recordId:" + str4 + ", versionId:" + str5);
        String strM63452a = C10279b.m63452a(C10278a.m63437c(C10278a.m63442h(C13617a.m81942x(str, str2, 0, i10))));
        if (TextUtils.isEmpty(strM63452a)) {
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "get parent path error, appId = " + str2, "downloadAttachment");
        }
        String str6 = strM63452a + File.separator + str2 + FeedbackWebConstants.SUFFIX;
        final C10560j c10560j = new C10560j(str, this.f58018b, this.f58017a.m29728n0(), str6, this.f58019c, str3, str4, str5);
        C10546a.m64704a(new C10546a.a() { // from class: rm.y0
            @Override // im.C10546a.a
            /* renamed from: a */
            public final InterfaceC10551c0 mo1696a() {
                return C12610z0.m76084o(c10560j);
            }
        }).m64705b();
        boolean zM75805U2 = C12590s0.m75805U2(str6, strM63452a);
        if (!C11835i.m70643g(str6)) {
            C11839m.m70688i("DownloadSnapshotUtil", "delete zip file error: " + str6 + ", appid: " + str2);
        }
        if (!zM75805U2) {
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "unzip file: " + str6 + ", appid: " + str2 + ", uid: " + i10 + ", errordownloadAttachment");
        }
        C11839m.m70688i("DownloadSnapshotUtil", "download attachment end, appid:" + str2 + ", uid:" + i10 + ", assetId:" + str3 + ", , recordId:" + str4 + ", versionId:" + str5);
    }

    /* renamed from: c */
    public void m76086c(Bak bak, String str, String str2, CloudBackupStatus cloudBackupStatus) throws InterruptedException, C9721b, SQLException {
        if (!C12590s0.m75921x1(str2)) {
            if (C12590s0.m75925y1(str2)) {
                m76089f(bak);
                return;
            }
            bak.getId();
            if (C12590s0.m75767L0(cloudBackupStatus)) {
                m76091h(str, cloudBackupStatus.m29861N());
                return;
            }
            return;
        }
        if (SnapshotTreeManagementService.getInstance().checkSuccessfulBackupRecordStatus(bak.getId()) || bak.get("CBSBackupRecord") == null) {
            return;
        }
        CBSBackupRecord cBSBackupRecord = (CBSBackupRecord) bak.get("CBSBackupRecord");
        String strM80950o = C13452e.m80781L().m80950o();
        int iM80978v = C13452e.m80781L().m80978v();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(m76094k() ? "" : "/Backup");
        sb2.append("/CloudBackup/");
        sb2.append(C11476b.m68626h(strM80950o));
        sb2.append("/");
        String string = sb2.toString();
        ArrayList arrayList = new ArrayList();
        arrayList.add(cBSBackupRecord);
        new C12607y(this.f58017a, arrayList, strM80950o, iM80978v, this.f58018b, string, m76093j()).m76076b();
    }

    /* renamed from: d */
    public void m76087d() {
        if (m76095l(this.f58020d, this.f58021e)) {
            m76090g();
        } else if (m76097n(this.f58020d, this.f58021e)) {
            m76092i();
        }
    }

    /* renamed from: e */
    public void m76088e() throws C9721b {
        Map<String, String> map;
        if (SnapshotTreeManagementService.getInstance().checkSuccessfulBackupRecordStatus(this.f58020d) || (map = this.f58023g) == null || !map.containsKey(SnapshotDBManager.PREFIX_DATABASE_NAME)) {
            return;
        }
        String str = map.get(SnapshotDBManager.PREFIX_DATABASE_NAME);
        C11839m.m70688i("DownloadSnapshotUtil", "downloadV2Snapshot backupId: " + this.f58020d);
        String strM81913B = C13617a.m81913B(this.f58020d);
        C12478a c12478a = new C12478a(EnumC12999a.CLOUD_BACKUP, this.f58018b);
        String parent = C10278a.m63442h(C13617a.m81912A(this.f58020d)).getParent();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f58022f);
        String str2 = File.separator;
        sb2.append(str2);
        sb2.append(strM81913B);
        String string = sb2.toString();
        File fileM63442h = C10278a.m63442h(string);
        if (fileM63442h.exists() && !fileM63442h.delete()) {
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "download V2 Snapshot tempFile delete file error");
        }
        c12478a.m74913i(str, string, new ProgressCallback());
        SnapshotTreeManagementService.getInstance().deleteSnapshotDB(this.f58020d);
        File fileM63442h2 = C10278a.m63442h(parent + str2 + strM81913B);
        if (fileM63442h2.exists() && !fileM63442h2.delete()) {
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "download V2 Snapshot delete file error");
        }
        if (!C11835i.m70654r(fileM63442h, fileM63442h2)) {
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "download V2 Snapshot snapFile rename error");
        }
    }

    /* renamed from: f */
    public final void m76089f(Bak bak) throws C9721b {
        Map<String, String> properties;
        String id2 = bak.getId();
        if (SnapshotTreeManagementService.getInstance().checkSuccessfulBackupRecordStatus(id2) || (properties = bak.getProperties()) == null || !properties.containsKey(SnapshotDBManager.PREFIX_DATABASE_NAME)) {
            return;
        }
        String str = bak.getProperties().get(SnapshotDBManager.PREFIX_DATABASE_NAME);
        C11839m.m70688i("DownloadSnapshotUtil", "downloadV2Snapshot backupId: " + id2);
        String strM81913B = C13617a.m81913B(id2);
        C12478a c12478a = new C12478a(EnumC12999a.CLOUD_BACKUP, this.f58018b);
        String parent = C10278a.m63442h(C13617a.m81912A(id2)).getParent();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f58022f);
        String str2 = File.separator;
        sb2.append(str2);
        sb2.append(strM81913B);
        String string = sb2.toString();
        File fileM63442h = C10278a.m63442h(string);
        if (fileM63442h.exists() && !fileM63442h.delete()) {
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "downloadV2Snapshot tempFile delete file error");
        }
        c12478a.m74913i(str, string, new ProgressCallback());
        File fileM63442h2 = C10278a.m63442h(parent + str2 + strM81913B);
        if (fileM63442h2.exists() && !fileM63442h2.delete()) {
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "downloadV2Snapshot delete file error");
        }
        if (!C11835i.m70654r(fileM63442h, fileM63442h2)) {
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "downloadV2Snapshot snapFile rename error");
        }
    }

    /* renamed from: g */
    public final void m76090g() {
        if (m76095l(this.f58020d, this.f58021e)) {
            if (!C12590s0.m75925y1(this.f58021e)) {
                C11839m.m70688i("DownloadSnapshotUtil", "downloadV2Snapshots not V3 backup record, backupId: " + this.f58020d + ", version: " + this.f58021e);
                return;
            }
            try {
                m76088e();
            } catch (Exception e10) {
                C11839m.m70688i("DownloadSnapshotUtil", "downloadV2Snapshots error backupId: " + this.f58020d + e10.getMessage());
            }
        }
    }

    /* renamed from: h */
    public void m76091h(String str, int i10) throws C9721b {
        if (m76097n(this.f58020d, this.f58021e)) {
            if (C10278a.m63442h(C13617a.m81942x(this.f58020d, str, 0, i10)).exists()) {
                C11839m.m70688i("DownloadSnapshotUtil", "no need download snapshot, appId: " + str + ", uid: " + i10);
                return;
            }
            Lock lockMo8329d = this.f58017a.m29728n0().mo8329d();
            List<App> listM29649L1 = this.f58017a.m29704f0().get(this.f58020d);
            if (listM29649L1 == null || listM29649L1.isEmpty()) {
                C11839m.m70688i("DownloadSnapshotUtil", "list apps of backupId: " + this.f58020d);
                listM29649L1 = this.f58017a.m29649L1(this.f58020d, lockMo8329d.getLockId());
                this.f58017a.m29704f0().put(this.f58020d, listM29649L1);
            }
            if (listM29649L1.isEmpty()) {
                return;
            }
            for (App app : listM29649L1) {
                if (app.getBackupAppStatus().intValue() == 0) {
                    String backupAppName = app.getBackupAppName();
                    if (TextUtils.equals(str, backupAppName)) {
                        if (C12590s0.m75787Q0(app.getProperties())) {
                            C11839m.m70688i("DownloadSnapshotUtil", "skip 3rd app no data, backupId: " + this.f58020d + ", appId: " + backupAppName + ", uid: " + i10);
                        } else {
                            List<Attachment> attachments = app.getAttachments();
                            if (attachments != null && !attachments.isEmpty()) {
                                for (Attachment attachment : attachments) {
                                    if (attachment.getState().intValue() == 0 && SnapshotDBManager.PREFIX_DATABASE_NAME.equalsIgnoreCase(attachment.getUsage())) {
                                        m76085b(this.f58020d, backupAppName, i10, attachment.getAssetId(), app.getId(), attachment.getVersionId());
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /* renamed from: i */
    public final void m76092i() {
        if (m76097n(this.f58020d, this.f58021e)) {
            try {
                Lock lockMo8329d = this.f58017a.m29728n0().mo8329d();
                List<App> listM29649L1 = this.f58017a.m29704f0().get(this.f58020d);
                if (listM29649L1 == null || listM29649L1.isEmpty()) {
                    C11839m.m70688i("DownloadSnapshotUtil", "downloadV3Snapshots list apps of backupId: " + this.f58020d);
                    listM29649L1 = this.f58017a.m29649L1(this.f58020d, lockMo8329d.getLockId());
                    this.f58017a.m29704f0().put(this.f58020d, listM29649L1);
                }
                if (listM29649L1.isEmpty()) {
                    return;
                }
                for (App app : listM29649L1) {
                    if (app.getBackupAppStatus().intValue() == 0) {
                        String backupAppName = app.getBackupAppName();
                        int iM1685c = C0241z.m1685c(app.getProperties().get("splitappuid"));
                        if (C10278a.m63442h(C13617a.m81942x(this.f58020d, backupAppName, 0, iM1685c)).exists()) {
                            C11839m.m70688i("DownloadSnapshotUtil", "downloadV3Snapshots no need download snapshot, appId: " + backupAppName + ", uid: " + iM1685c);
                        } else if (C12590s0.m75787Q0(app.getProperties())) {
                            C11839m.m70688i("DownloadSnapshotUtil", "downloadV3Snapshots skip 3rd app no data, backupId: " + this.f58020d + ", appId: " + backupAppName + ", uid: " + iM1685c);
                        } else {
                            List<Attachment> attachments = app.getAttachments();
                            if (attachments != null && !attachments.isEmpty()) {
                                for (Attachment attachment : attachments) {
                                    if (attachment.getState().intValue() == 0 && SnapshotDBManager.PREFIX_DATABASE_NAME.equalsIgnoreCase(attachment.getUsage())) {
                                        m76085b(this.f58020d, backupAppName, iM1685c, attachment.getAssetId(), app.getId(), attachment.getVersionId());
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (Exception e10) {
                C11839m.m70688i("DownloadSnapshotUtil", "downloadV3Snapshots error backupId: " + this.f58020d + e10.getMessage());
            }
        }
    }

    /* renamed from: j */
    public final Context m76093j() {
        return C0213f.m1377a();
    }

    /* renamed from: k */
    public final boolean m76094k() {
        return !C10028c.m62182c0().m62420y1();
    }

    /* renamed from: l */
    public final boolean m76095l(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            C11839m.m70688i("DownloadSnapshotUtil", "V2 backup record is null");
            return false;
        }
        if (!C12590s0.m75873l1(str2)) {
            return true;
        }
        C11839m.m70688i("DownloadSnapshotUtil", "not V2 backup record, backupId: " + str + ", version: " + str2);
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0085, code lost:
    
        if (p618rm.C12590s0.m75787Q0(r5.getProperties()) == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0087, code lost:
    
        p514o9.C11839m.m70688i("DownloadSnapshotUtil", "backupId: " + r9 + ", appId: " + r10 + ", uid: " + r11 + ", snapshot is not valid");
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00aa, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00ab, code lost:
    
        r4 = true;
     */
    /* renamed from: m */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean m76096m(java.lang.String r9, java.lang.String r10, int r11) throws java.lang.InterruptedException {
        /*
            r8 = this;
            java.lang.String r0 = ", uid: "
            java.lang.String r1 = ", appId: "
            java.lang.String r2 = "backupId: "
            java.lang.String r3 = "DownloadSnapshotUtil"
            r4 = 0
            com.huawei.hicloud.cloudbackup.v3.core.a r5 = r8.f58017a     // Catch: fk.C9721b -> L28
            cm.c r5 = r5.m29728n0()     // Catch: fk.C9721b -> L28
            com.huawei.hicloud.cloudbackup.v3.server.model.Lock r5 = r5.mo8329d()     // Catch: fk.C9721b -> L28
            com.huawei.hicloud.cloudbackup.v3.core.a r6 = r8.f58017a     // Catch: fk.C9721b -> L28
            java.util.Map r6 = r6.m29704f0()     // Catch: fk.C9721b -> L28
            java.lang.Object r6 = r6.get(r9)     // Catch: fk.C9721b -> L28
            java.util.List r6 = (java.util.List) r6     // Catch: fk.C9721b -> L28
            if (r6 == 0) goto L2b
            boolean r7 = r6.isEmpty()     // Catch: fk.C9721b -> L28
            if (r7 == 0) goto L52
            goto L2b
        L28:
            r8 = move-exception
            goto Lad
        L2b:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: fk.C9721b -> L28
            r6.<init>()     // Catch: fk.C9721b -> L28
            java.lang.String r7 = "list apps of backupId: "
            r6.append(r7)     // Catch: fk.C9721b -> L28
            r6.append(r9)     // Catch: fk.C9721b -> L28
            java.lang.String r6 = r6.toString()     // Catch: fk.C9721b -> L28
            p514o9.C11839m.m70688i(r3, r6)     // Catch: fk.C9721b -> L28
            com.huawei.hicloud.cloudbackup.v3.core.a r6 = r8.f58017a     // Catch: fk.C9721b -> L28
            java.lang.String r5 = r5.getLockId()     // Catch: fk.C9721b -> L28
            java.util.List r6 = r6.m29649L1(r9, r5)     // Catch: fk.C9721b -> L28
            com.huawei.hicloud.cloudbackup.v3.core.a r8 = r8.f58017a     // Catch: fk.C9721b -> L28
            java.util.Map r8 = r8.m29704f0()     // Catch: fk.C9721b -> L28
            r8.put(r9, r6)     // Catch: fk.C9721b -> L28
        L52:
            boolean r8 = r6.isEmpty()     // Catch: fk.C9721b -> L28
            if (r8 != 0) goto Ld7
            java.util.Iterator r8 = r6.iterator()     // Catch: fk.C9721b -> L28
        L5c:
            boolean r5 = r8.hasNext()     // Catch: fk.C9721b -> L28
            if (r5 == 0) goto Ld7
            java.lang.Object r5 = r8.next()     // Catch: fk.C9721b -> L28
            com.huawei.hicloud.cloudbackup.v3.server.model.App r5 = (com.huawei.hicloud.cloudbackup.p104v3.server.model.App) r5     // Catch: fk.C9721b -> L28
            java.lang.Integer r6 = r5.getBackupAppStatus()     // Catch: fk.C9721b -> L28
            int r6 = r6.intValue()     // Catch: fk.C9721b -> L28
            if (r6 != 0) goto L5c
            java.lang.String r6 = r5.getBackupAppName()     // Catch: fk.C9721b -> L28
            boolean r6 = android.text.TextUtils.equals(r10, r6)     // Catch: fk.C9721b -> L28
            if (r6 != 0) goto L7d
            goto L5c
        L7d:
            java.util.Map r8 = r5.getProperties()     // Catch: fk.C9721b -> L28
            boolean r8 = p618rm.C12590s0.m75787Q0(r8)     // Catch: fk.C9721b -> L28
            if (r8 == 0) goto Lab
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: fk.C9721b -> L28
            r8.<init>()     // Catch: fk.C9721b -> L28
            r8.append(r2)     // Catch: fk.C9721b -> L28
            r8.append(r9)     // Catch: fk.C9721b -> L28
            r8.append(r1)     // Catch: fk.C9721b -> L28
            r8.append(r10)     // Catch: fk.C9721b -> L28
            r8.append(r0)     // Catch: fk.C9721b -> L28
            r8.append(r11)     // Catch: fk.C9721b -> L28
            java.lang.String r5 = ", snapshot is not valid"
            r8.append(r5)     // Catch: fk.C9721b -> L28
            java.lang.String r8 = r8.toString()     // Catch: fk.C9721b -> L28
            p514o9.C11839m.m70688i(r3, r8)     // Catch: fk.C9721b -> L28
            return r4
        Lab:
            r4 = 1
            goto Ld7
        Lad:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r2)
            r5.append(r9)
            r5.append(r1)
            r5.append(r10)
            r5.append(r0)
            r5.append(r11)
            java.lang.String r6 = ", excption: "
            r5.append(r6)
            java.lang.String r8 = r8.toString()
            r5.append(r8)
            java.lang.String r8 = r5.toString()
            p514o9.C11839m.m70688i(r3, r8)
        Ld7:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r2)
            r8.append(r9)
            r8.append(r1)
            r8.append(r10)
            r8.append(r0)
            r8.append(r11)
            java.lang.String r9 = ", snapshot valid: "
            r8.append(r9)
            r8.append(r4)
            java.lang.String r8 = r8.toString()
            p514o9.C11839m.m70688i(r3, r8)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: p618rm.C12610z0.m76096m(java.lang.String, java.lang.String, int):boolean");
    }

    /* renamed from: n */
    public final boolean m76097n(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            C11839m.m70688i("DownloadSnapshotUtil", "backup record is null");
            return false;
        }
        if (C12590s0.m75873l1(str2)) {
            return true;
        }
        C11839m.m70688i("DownloadSnapshotUtil", "not V3 backup record, backupId: " + str + ", version: " + str2);
        return false;
    }
}
