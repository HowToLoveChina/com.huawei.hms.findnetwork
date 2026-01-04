package am;

import am.C0306w0;
import android.database.SQLException;
import android.text.TextUtils;
import cm.C1457c;
import com.huawei.android.hicloud.cloudbackup.p076db.operator.SettingOperator;
import com.huawei.android.hicloud.cloudbackup.process.BackupPowerKitKeepTimer;
import com.huawei.android.hicloud.cloudbackup.process.CBLockTimer;
import com.huawei.android.hicloud.cloudbackup.process.util.ProgressCallback;
import com.huawei.android.hicloud.cloudbackup.report.CloudBackupReport;
import com.huawei.android.hicloud.cloudbackup.snapshottree.SnapshotTreeManagementService;
import com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.SnapshotDBManager;
import com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.bean.SnapshotBackupMeta;
import com.huawei.android.hicloud.cloudbackup.util.ICBUtil;
import com.huawei.cloud.base.http.C4609l;
import com.huawei.cloud.base.util.C4633d0;
import com.huawei.cloud.base.util.C4644l;
import com.huawei.hicloud.base.bean.Md5AndHash;
import com.huawei.hicloud.base.drive.model.ErrorResp;
import com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request;
import com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Server;
import com.huawei.hicloud.cloudbackup.p104v3.server.batch.CloudBackupV3BatchCallback;
import com.huawei.hicloud.cloudbackup.p104v3.server.batch.CloudBackupV3BatchRequest;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.App;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.AppList;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.Attachment;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.BakList;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.BakRefresh;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.FileDelete;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.FileDeleteLogs;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.Lock;
import com.huawei.hicloud.cloudbackup.p104v3.server.request.Bak;
import com.huawei.hicloud.cloudbackup.p104v3.server.request.File;
import com.huawei.hicloud.cloudbackup.store.database.status.CloudBackupStatus;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.request.cbs.bean.CBSBackupRecord;
import com.huawei.hicloud.request.cbs.bean.CBSBaseReq;
import com.huawei.hicloud.request.cbs.bean.CBSDevice;
import com.huawei.hicloud.request.opengw.bean.Result;
import com.huawei.hms.identity.AddressConstants;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import com.huawei.openalliance.p169ad.constant.ParamConstants;
import com.huawei.phoneservice.faq.base.constants.TrackConstants$Events;
import com.huawei.phoneservice.feedbackcommon.network.FeedbackWebConstants;
import fk.C9721b;
import gp.C10028c;
import hk.C10278a;
import hk.C10279b;
import hm.C10321z;
import im.C10546a;
import im.C10560j;
import im.InterfaceC10551c0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import mk.C11476b;
import mm.AbstractC11494p;
import mm.C11489k;
import mm.InterfaceC11495q;
import ne.C11667a;
import p015ak.C0213f;
import p015ak.C0241z;
import p292fn.C9733f;
import p336he.C10153d;
import p429kk.C11058a;
import p429kk.C11060c;
import p458lo.C11322a;
import p495nm.C11732m;
import p514o9.C11835i;
import p514o9.C11839m;
import p606r9.C12478a;
import p616rk.C12515a;
import p617rl.C12526j;
import p618rm.C12590s0;
import p618rm.C12605x0;
import p618rm.C12607y;
import p652t9.EnumC12999a;
import p682ul.C13216j;
import p684un.C13225d;
import p709vj.C13452e;
import p711vl.C13466f;
import p744wl.C13617a;
import p746wn.C13622a;
import p814yl.C13998b0;
import p814yl.C14000c0;
import p815ym.AbstractC14026a;
import pl.C12161c;
import pl.C12164f;
import sl.C12815f;
import tl.C13029h;
import to.C13049a;

/* renamed from: am.w0 */
/* loaded from: classes6.dex */
public class C0306w0 extends AbstractC0249a {

    /* renamed from: M */
    public static List<String> f996M = new ArrayList();

    /* renamed from: N */
    public static final Map<String, b> f997N;

    /* renamed from: C */
    public c f1000C;

    /* renamed from: D */
    public final boolean f1001D;

    /* renamed from: E */
    public final String f1002E;

    /* renamed from: G */
    public final String f1004G;

    /* renamed from: H */
    public final String f1005H;

    /* renamed from: I */
    public final Map<String, Boolean> f1006I;

    /* renamed from: b */
    public final String f1010b;

    /* renamed from: c */
    public final String f1011c;

    /* renamed from: d */
    public final C11322a f1012d;

    /* renamed from: e */
    public final C10321z f1013e;

    /* renamed from: f */
    public final String f1014f;

    /* renamed from: g */
    public final int f1015g;

    /* renamed from: h */
    public final String f1016h;

    /* renamed from: i */
    public final int f1017i;

    /* renamed from: j */
    public final String f1018j;

    /* renamed from: l */
    public C1457c f1020l;

    /* renamed from: m */
    public C9721b f1021m;

    /* renamed from: n */
    public final SnapshotTreeManagementService f1022n;

    /* renamed from: o */
    public final String f1023o;

    /* renamed from: p */
    public final String f1024p;

    /* renamed from: q */
    public String f1025q;

    /* renamed from: r */
    public final long f1026r;

    /* renamed from: s */
    public final int f1027s;

    /* renamed from: t */
    public String f1028t;

    /* renamed from: u */
    public CBLockTimer f1029u;

    /* renamed from: v */
    public String f1030v = "";

    /* renamed from: w */
    public Map<String, CBSBackupRecord> f1031w = new HashMap();

    /* renamed from: x */
    public final Map<String, List<App>> f1032x = new HashMap();

    /* renamed from: y */
    public final List<String> f1033y = new ArrayList();

    /* renamed from: z */
    public final List<String> f1034z = new ArrayList();

    /* renamed from: A */
    public final List<String> f998A = new ArrayList();

    /* renamed from: B */
    public final List<CBSBackupRecord> f999B = new ArrayList();

    /* renamed from: F */
    public int f1003F = 0;

    /* renamed from: J */
    public final Set<String> f1007J = new HashSet();

    /* renamed from: K */
    public final Map<String, Set<App>> f1008K = new HashMap();

    /* renamed from: L */
    public boolean f1009L = false;

    /* renamed from: k */
    public final ProgressCallback f1019k = new ProgressCallback();

    /* renamed from: am.w0$a */
    public class a extends CloudBackupV3BatchCallback<Void> {

        /* renamed from: a */
        public final AtomicBoolean f1035a;

        /* renamed from: b */
        public final StringBuilder f1036b;

        public a(AtomicBoolean atomicBoolean, StringBuilder sb2) {
            this.f1035a = atomicBoolean;
            this.f1036b = sb2;
        }

        @Override // com.huawei.hicloud.cloudbackup.p104v3.server.batch.CloudBackupV3BatchCallback, p369ii.InterfaceC10510a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(Void r12, C4609l c4609l) throws IOException {
            C11839m.m70686d("DeleteRecordsV3Task", "batch delete sussess");
        }

        @Override // com.huawei.hicloud.cloudbackup.p104v3.server.batch.CloudBackupV3BatchCallback
        public void onFailure(ErrorResp.Error error, C4609l c4609l) throws IOException {
            List<ErrorResp.ErrorMsg> errorDetail = error.getErrorDetail();
            if (errorDetail == null || errorDetail.isEmpty()) {
                this.f1036b.append("delete failed no errorDetail|");
                this.f1035a.set(true);
                return;
            }
            ErrorResp.ErrorMsg errorMsg = errorDetail.get(0);
            String errorCode = errorMsg.getErrorCode();
            String description = errorMsg.getDescription();
            if (String.valueOf(51004921).equals(errorCode)) {
                C11839m.m70686d("DeleteRecordsV3Task", "server delete reference file error: " + description + " ,errorCode: " + errorCode);
                C0306w0.m1779G(C0306w0.this);
                return;
            }
            if (!errorCode.endsWith(String.valueOf(4011)) && !errorCode.endsWith(String.valueOf(4041))) {
                StringBuilder sb2 = this.f1036b;
                sb2.append("delete error: ");
                sb2.append(description);
                sb2.append(" code: ");
                sb2.append(errorCode);
                sb2.append("|");
                this.f1035a.set(true);
            }
            C11839m.m70686d("DeleteRecordsV3Task", "delete error: " + description + " ,errorCode: " + errorCode);
        }
    }

    @FunctionalInterface
    /* renamed from: am.w0$b */
    public interface b {
        /* renamed from: a */
        boolean mo1769a(String str, App app);
    }

    /* renamed from: am.w0$c */
    public static class c {

        /* renamed from: b */
        public long f1039b;

        /* renamed from: c */
        public long f1040c;

        /* renamed from: d */
        public long f1041d;

        /* renamed from: e */
        public boolean f1042e;

        /* renamed from: f */
        public List<String> f1043f;

        /* renamed from: g */
        public final Map<String, Long> f1044g = new HashMap();

        /* renamed from: a */
        public long f1038a = System.currentTimeMillis();

        /* renamed from: a */
        public long m1887a() {
            return this.f1040c;
        }

        /* renamed from: b */
        public long m1888b() {
            return this.f1039b;
        }

        /* renamed from: c */
        public List<String> m1889c() {
            return this.f1043f;
        }

        /* renamed from: d */
        public Map<String, Long> m1890d() {
            return this.f1044g;
        }

        /* renamed from: e */
        public long m1891e() {
            return this.f1038a;
        }

        /* renamed from: f */
        public long m1892f() {
            return this.f1041d;
        }

        /* renamed from: g */
        public void m1893g(boolean z10) {
            this.f1042e = z10;
        }

        /* renamed from: h */
        public void m1894h(long j10) {
            this.f1040c = j10;
        }

        /* renamed from: i */
        public void m1895i(long j10) {
            this.f1039b = j10;
        }

        /* renamed from: j */
        public void m1896j(String str, long j10) {
            this.f1044g.put(str, Long.valueOf(j10));
        }

        /* renamed from: k */
        public void m1897k(long j10) {
            this.f1041d = j10;
        }
    }

    static {
        HashMap map = new HashMap();
        f997N = map;
        map.put("cloudBackupInvalidRecordCorruption", new b() { // from class: am.v0
            @Override // am.C0306w0.b
            /* renamed from: a */
            public final boolean mo1769a(String str, App app) {
                return C0306w0.m1807v0(str, app);
            }
        });
        map.put("cloudBackupSuccessRecordCorruption", new b() { // from class: am.v0
            @Override // am.C0306w0.b
            /* renamed from: a */
            public final boolean mo1769a(String str, App app) {
                return C0306w0.m1807v0(str, app);
            }
        });
        map.put("cloudBackupInvalidRecordSnapEmpty", new b() { // from class: am.u
            @Override // am.C0306w0.b
            /* renamed from: a */
            public final boolean mo1769a(String str, App app) {
                return C0306w0.m1808w0(str, app);
            }
        });
        map.put("cloudBackupSuccessRecordSnapEmpty", new b() { // from class: am.u
            @Override // am.C0306w0.b
            /* renamed from: a */
            public final boolean mo1769a(String str, App app) {
                return C0306w0.m1808w0(str, app);
            }
        });
        map.put("cloudBackupInvalidRecordNoAttach", new b() { // from class: am.v
            @Override // am.C0306w0.b
            /* renamed from: a */
            public final boolean mo1769a(String str, App app) {
                return C0306w0.m1809x0(str, app);
            }
        });
        map.put("cloudBackupSuccessRecordNoAttach", new b() { // from class: am.v
            @Override // am.C0306w0.b
            /* renamed from: a */
            public final boolean mo1769a(String str, App app) {
                return C0306w0.m1809x0(str, app);
            }
        });
    }

    public C0306w0(String str, String str2, String str3, int i10, long j10, String str4, int i11, int i12, String str5, boolean z10, String str6, String str7, String str8) {
        this.f1010b = str3;
        this.f1024p = str2;
        this.f1027s = i10;
        this.f1026r = j10;
        this.f1011c = str;
        this.f1016h = str4;
        this.f1015g = i11;
        this.f1017i = i12;
        this.f1018j = str5;
        String strM66627b = C11058a.m66627b("02007");
        this.f1014f = strM66627b;
        this.f1001D = z10;
        this.f1002E = str6;
        this.f1012d = new C11322a(strM66627b);
        SnapshotTreeManagementService snapshotTreeManagementService = SnapshotTreeManagementService.getInstance();
        this.f1022n = snapshotTreeManagementService;
        snapshotTreeManagementService.clear();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(isEncrypt() ? "" : "/Backup");
        sb2.append("/CloudBackup/");
        sb2.append(C11476b.m68626h(str));
        sb2.append("/");
        this.f1023o = sb2.toString();
        this.f1028t = "2";
        this.f1013e = new C10321z(str4, null, null, "delete", strM66627b);
        this.f1004G = str7;
        this.f1005H = str8;
        this.f1006I = new C12526j().m75345K0();
        f996M.clear();
    }

    /* renamed from: D0 */
    public static /* synthetic */ void m1774D0(StringBuilder sb2, App app) {
        if (app != null) {
            sb2.append(app.getBackupAppName());
            sb2.append("|");
        }
    }

    /* renamed from: E0 */
    public static /* synthetic */ void m1776E0(final StringBuilder sb2, String str, Set set) {
        sb2.append("[");
        sb2.append(str);
        sb2.append("|");
        if (set != null) {
            set.forEach(new Consumer() { // from class: am.c0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    C0306w0.m1774D0(sb2, (App) obj);
                }
            });
        }
        sb2.append("]");
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Bak$List] */
    /* renamed from: F0 */
    public static /* synthetic */ CloudBackupV3Request m1778F0(String str, String str2, String str3, CloudBackupV3Server cloudBackupV3Server) throws IOException {
        Bak.List list = cloudBackupV3Server.backup().device().bak().list();
        list.setFields(str).setBackupAction(str2).setBackupDeviceId(str3).setBackupDeviceId(str3).setHeader("x-hw-contain-refurbishment", Boolean.TRUE);
        return list;
    }

    /* renamed from: G */
    public static /* synthetic */ int m1779G(C0306w0 c0306w0) {
        int i10 = c0306w0.f1003F;
        c0306w0.f1003F = i10 + 1;
        return i10;
    }

    /* renamed from: H0 */
    public static /* synthetic */ Set m1780H0(String str) {
        return new HashSet(8);
    }

    /* renamed from: I0 */
    public static /* synthetic */ int m1781I0(CBSBackupRecord cBSBackupRecord, CBSBackupRecord cBSBackupRecord2) {
        String version = cBSBackupRecord.getVersion();
        Locale locale = Locale.US;
        String lowerCase = version.toLowerCase(locale);
        String lowerCase2 = cBSBackupRecord2.getVersion().toLowerCase(locale);
        if (lowerCase.compareTo(lowerCase2) < 0) {
            return 1;
        }
        if (lowerCase.compareTo(lowerCase2) > 0) {
            return -1;
        }
        return cBSBackupRecord2.getStatus() - cBSBackupRecord.getStatus();
    }

    /* renamed from: J */
    public static boolean m1782J(C12161c c12161c) {
        String strM73009x = c12161c.m73009x();
        if (!((TextUtils.isEmpty(c12161c.m72984h()) || c12161c.m73010y() != 0 || TextUtils.isEmpty(strM73009x)) ? false : true)) {
            return false;
        }
        boolean z10 = C10153d.m63242f(strM73009x) && !C10153d.m63245i(strM73009x);
        C11839m.m70688i("DeleteRecordsV3Task", "cannotDeleteByFileId fileId: " + strM73009x + " result: " + z10);
        return z10;
    }

    /* renamed from: J0 */
    public static /* synthetic */ Set m1783J0(String str) {
        return new HashSet(8);
    }

    /* renamed from: K */
    public static void m1784K(C12815f c12815f, String str, String str2, String str3) {
        if (c12815f == null) {
            return;
        }
        try {
            CloudBackupStatus cloudBackupStatusM76928g = c12815f.m76928g(str);
            if (cloudBackupStatusM76928g == null || cloudBackupStatusM76928g.m29859L() == 0 || cloudBackupStatusM76928g.m29859L() == -1 || cloudBackupStatusM76928g.m29859L() == 6) {
                return;
            }
            cloudBackupStatusM76928g.mo29338z0(0).mo29289A0(-1);
            c12815f.m76934m(cloudBackupStatusM76928g);
            CloudBackupReport.reportDeleteTaskResetModule(str2, str, str3, cloudBackupStatusM76928g.m29859L());
        } catch (Exception e10) {
            C11839m.m70689w("DeleteRecordsV3Task", "checkBackingModuleStatus error: " + e10.getMessage());
        }
    }

    public static boolean isEncrypt() {
        return !C10028c.m62182c0().m62420y1();
    }

    private void lock() throws C9721b {
        C11839m.m70688i("DeleteRecordsV3Task", "start delete lock.");
        if ("2".equals(this.f1028t)) {
            m1847Z0();
        } else {
            keepDeleteLock();
        }
        C11839m.m70688i("DeleteRecordsV3Task", "deleteRecordAction: " + this.f1030v);
    }

    /* renamed from: p1 */
    private void m1799p1() {
        if (this.f1020l != null) {
            C11839m.m70688i("DeleteRecordsV3Task", "end delete lock.");
            this.f1020l.m8336i();
        }
        if (this.f1029u != null) {
            try {
                try {
                    this.f1012d.m68013T(this.f1011c, this.f1024p, this.f1015g, 1);
                } catch (C9721b unused) {
                    C11839m.m70687e("DeleteRecordsV3Task", "unlock delete lock requeset exception");
                }
            } finally {
                deleteUnLock();
            }
        }
    }

    /* renamed from: q0 */
    public static Attachment m1801q0(App app) {
        for (Attachment attachment : app.getAttachments()) {
            if (TextUtils.equals(attachment.getUsage(), SnapshotDBManager.PREFIX_DATABASE_NAME)) {
                return attachment;
            }
        }
        return null;
    }

    /* renamed from: v0 */
    public static boolean m1807v0(String str, App app) {
        String str2;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("isSnapshotCorruption : ");
        sb2.append(str);
        sb2.append(" app: ");
        if (app == null) {
            str2 = "null";
        } else {
            str2 = app.getBackupAppName() + " ,status: " + app.getBackupAppStatus();
        }
        sb2.append(str2);
        C11839m.m70688i("DeleteRecordsV3Task", sb2.toString());
        if (app == null) {
            if (SnapshotTreeManagementService.getInstance().existSnapshotDataBase(str)) {
                return !SnapshotTreeManagementService.getInstance().isSnapshotDataBaseIntegrityOk(str);
            }
            C11839m.m70686d("DeleteRecordsV3Task", "not existSnapshotDataBase");
            return true;
        }
        if (app.getBackupAppStatus().intValue() != 6) {
            return false;
        }
        if (m1801q0(app) == null || TextUtils.isEmpty(app.getBackupAppName())) {
            C11839m.m70686d("DeleteRecordsV3Task", "attachment is empty");
            return false;
        }
        return !new C12164f(str, app.getBackupAppName(), 0, C0241z.m1685c(app.getProperties().getOrDefault("splitappuid", "0"))).integrityCheck();
    }

    /* renamed from: w0 */
    public static boolean m1808w0(String str, App app) {
        String str2;
        int iM73026B;
        int iM73112x;
        int iM73114y;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("isSnapshotEmpty : ");
        sb2.append(str);
        sb2.append(" app: ");
        if (app == null) {
            str2 = "null";
        } else {
            str2 = app.getBackupAppName() + " ,status: " + app.getBackupAppStatus();
        }
        sb2.append(str2);
        C11839m.m70688i("DeleteRecordsV3Task", sb2.toString());
        if (app == null) {
            if (!SnapshotTreeManagementService.getInstance().existSnapshotDataBase(str)) {
                C11839m.m70686d("DeleteRecordsV3Task", "not existSnapshotDataBase");
                return true;
            }
            try {
                return SnapshotTreeManagementService.getInstance().getAllFilesCount(str) <= 0;
            } catch (C9721b e10) {
                C11839m.m70687e("DeleteRecordsV3Task", "isSnapshotSnapshotEmpty:" + e10.getMessage());
                return true;
            }
        }
        if (app.getBackupAppStatus().intValue() != 6) {
            return false;
        }
        if (m1801q0(app) == null || TextUtils.isEmpty(app.getBackupAppName())) {
            C11839m.m70686d("DeleteRecordsV3Task", "attachment is empty");
            return false;
        }
        C12164f c12164f = new C12164f(str, app.getBackupAppName(), 0, C0241z.m1685c(app.getProperties().getOrDefault("splitappuid", "0")));
        try {
            iM73026B = c12164f.m73026B();
        } catch (C9721b e11) {
            C11839m.m70687e("DeleteRecordsV3Task", "isSnapshotEmpty:" + e11.getMessage());
            iM73026B = 0;
        }
        if (iM73026B <= 0) {
            StringBuilder sb3 = new StringBuilder(str);
            sb3.append('|');
            sb3.append(app.getBackupAppName());
            sb3.append('|');
            try {
                iM73112x = c12164f.m73112x();
            } catch (C9721b e12) {
                C11839m.m70687e("DeleteRecordsV3Task", "isSnapshotEmpty queryAllDirNum:" + e12.getMessage());
                iM73112x = 0;
            }
            try {
                iM73114y = c12164f.m73114y();
            } catch (C9721b e13) {
                C11839m.m70687e("DeleteRecordsV3Task", "isSnapshotEmpty queryAllDirNum:" + e13.getMessage());
                iM73114y = 0;
            }
            sb3.append(iM73112x);
            sb3.append('|');
            sb3.append(iM73114y);
            f996M.add(sb3.toString());
        }
        return iM73026B <= 0;
    }

    /* renamed from: x0 */
    public static boolean m1809x0(String str, App app) {
        String str2;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("isSnapshotNoAttachment : ");
        sb2.append(str);
        sb2.append(" app: ");
        if (app == null) {
            str2 = "null";
        } else {
            str2 = app.getBackupAppName() + " ,status: " + app.getBackupAppStatus();
        }
        sb2.append(str2);
        C11839m.m70688i("DeleteRecordsV3Task", sb2.toString());
        if (app == null || app.getBackupAppStatus().intValue() != 6) {
            return false;
        }
        Attachment attachmentM1801q0 = m1801q0(app);
        StringBuilder sb3 = new StringBuilder();
        sb3.append("isSnapshotNoAttachment attachment:");
        sb3.append(attachmentM1801q0 == null);
        C11839m.m70686d("DeleteRecordsV3Task", sb3.toString());
        if (attachmentM1801q0 != null) {
            return false;
        }
        String str3 = app.getProperties().get("appwithdata");
        C11839m.m70686d("DeleteRecordsV3Task", "isSnapshotNoAttachment dataFlag:" + str3);
        return str3 != null && String.valueOf(1).equals(str3);
    }

    /* renamed from: A0 */
    public final /* synthetic */ CloudBackupV3Request m1812A0(FileDelete fileDelete, String str, CloudBackupV3Server cloudBackupV3Server) throws IOException {
        File.Delete delete = cloudBackupV3Server.backup().device().file().delete(fileDelete);
        delete.setBackupAction(this.f1016h).setBackupDeviceId(this.f1010b).setXHwBackupPackageName(str).setXHwBackupid(this.f1024p).setLockId(this.f1025q).setOpSceneParam(new C11732m("10", "from client,DeleteRecordsV3Task_delete_file"));
        return delete;
    }

    /* renamed from: B0 */
    public final /* synthetic */ void m1813B0(String str, int i10, List list, int i11, String str2, AbstractC11494p abstractC11494p, int i12) throws C9721b {
        int iM1817I = 0;
        for (int i13 = 1; i13 <= i12; i13++) {
            C12161c c12161c = (C12161c) abstractC11494p.query(i13);
            if (c12161c == null) {
                C11839m.m70689w("DeleteRecordsV3Task", "deleteV3FileBySnapshotFlag backupMeta is empty appId: " + str + ", uid: " + i10);
            } else {
                C11839m.m70688i("DeleteRecordsV3Task", "deleteV3FileBySnapshotFlag fileId: " + c12161c.m73009x() + " cloudpath: " + c12161c.m72984h() + ", path:" + c12161c.m72991l());
                if (!TextUtils.isEmpty(c12161c.m72984h())) {
                    FileDelete fileDelete = new FileDelete();
                    fileDelete.setCloudPath(c12161c.m72984h());
                    fileDelete.setLogs(FileDeleteLogs.getFileDeleteLogs(c12161c.m72951G(), (int) c12161c.m72953I(), c12161c.m72999p(), false, c12161c.m72948D()).toString());
                    list.add(fileDelete);
                }
                int iM1817I2 = m1817I(i11, str, list, i12, iM1817I, i13);
                if (!TextUtils.isEmpty(c12161c.m73009x()) && !m1782J(c12161c)) {
                    FileDelete fileDelete2 = new FileDelete();
                    FileDeleteLogs fileDeleteLogs = FileDeleteLogs.getFileDeleteLogs(c12161c.m72951G(), (int) c12161c.m72953I(), c12161c.m72999p(), false, c12161c.m72948D());
                    fileDelete2.setId(c12161c.m73009x());
                    fileDelete2.setLogs(fileDeleteLogs.toString());
                    list.add(fileDelete2);
                }
                iM1817I = m1817I(i11, str, list, i12, iM1817I2, i13);
            }
        }
        C11839m.m70688i("DeleteRecordsV3Task", "delete v3 files backupId: " + str2 + ", appId: " + str + ", uid: " + i10 + ", summary:" + i12 + " ,sum: " + iM1817I);
    }

    /* renamed from: C0 */
    public final /* synthetic */ InterfaceC10551c0 m1814C0(String str, String str2, String str3, String str4, String str5) throws C9721b {
        return new C10560j(str, this.f1014f, this.f1020l, str2, this.f1016h, str3, str4, str5);
    }

    /* renamed from: G0 */
    public final /* synthetic */ void m1815G0(String str) {
        CBSBackupRecord cBSBackupRecord = this.f1031w.get(str);
        if (cBSBackupRecord == null) {
            C11839m.m70687e("DeleteRecordsV3Task", "processDirectlyDelRecordsIds invalidRecord is null");
        } else if (!m1883u0(cBSBackupRecord)) {
            C11839m.m70687e("DeleteRecordsV3Task", "processDirectlyDelRecordsIds find V3 ");
        } else {
            m1842X(str, cBSBackupRecord);
            this.f1034z.remove(str);
        }
    }

    /* renamed from: H */
    public final boolean m1816H(List<FileDelete> list, final String str, StringBuilder sb2) throws C9721b {
        if (list == null || list.isEmpty()) {
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "deleteV3File batch query result empty");
        }
        CloudBackupV3BatchRequest cloudBackupV3BatchRequest = new CloudBackupV3BatchRequest();
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        for (final FileDelete fileDelete : list) {
            if (TextUtils.isEmpty(fileDelete.getId()) && !TextUtils.isEmpty(fileDelete.getCloudPath())) {
                fileDelete.setCloudPath(this.f1023o + str + "/" + fileDelete.getCloudPath());
            }
            new C14000c0(new C14000c0.a() { // from class: am.b0
                @Override // p814yl.C14000c0.a
                /* renamed from: a */
                public final CloudBackupV3Request mo1697a(CloudBackupV3Server cloudBackupV3Server) {
                    return this.f891a.m1812A0(fileDelete, str, cloudBackupV3Server);
                }
            }).m84143f(cloudBackupV3BatchRequest, new a(atomicBoolean, sb2));
        }
        cloudBackupV3BatchRequest.execute("Backup.device.file.delete", this.f1014f);
        return atomicBoolean.get();
    }

    /* renamed from: I */
    public final int m1817I(int i10, String str, List<FileDelete> list, int i11, int i12, int i13) throws C9721b {
        if (list.isEmpty()) {
            return i12;
        }
        if (list.size() < i10 && i13 < i11) {
            return i12;
        }
        StringBuilder sb2 = new StringBuilder();
        if (!m1816H(list, str, sb2)) {
            int size = i12 + list.size();
            list.clear();
            return size;
        }
        throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "deleteV3File batch delete fail: " + ((Object) sb2));
    }

    /* renamed from: L */
    public final void m1818L(String str, App app, String str2) throws C9721b, SQLException {
        Map<String, String> properties = app.getProperties();
        if (properties.isEmpty()) {
            C11839m.m70688i("DeleteRecordsV3Task", "current successApp not contains notStand app: " + str2);
            return;
        }
        String str3 = properties.get("apkServerPath");
        String str4 = properties.get("iconServerPath");
        if (!TextUtils.isEmpty(str3)) {
            C11839m.m70686d("DeleteRecordsV3Task", "compare same not stand apk by v3 apkServerPath");
            this.f1022n.updateV2SameNotStandApkNodesByV3(str, str2, str3.substring(str3.lastIndexOf("/") + 1));
        }
        if (TextUtils.isEmpty(str4)) {
            return;
        }
        C11839m.m70686d("DeleteRecordsV3Task", "compare same not stand icon by v3 iconServerPath");
        this.f1022n.updateV2SameNotStandApkNodesByV3(str, str2, str4.substring(str4.lastIndexOf("/") + 1));
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Bak$App$List] */
    /* renamed from: L0 */
    public final /* synthetic */ CloudBackupV3Request m1819L0(String str, String str2, String str3, String str4, CloudBackupV3Server cloudBackupV3Server) throws IOException {
        Bak.App.List list = cloudBackupV3Server.backup().device().bak().app().list();
        list.setFields(str).setHeader("x-hw-masking-apps-version", (Object) "V1").setHeader("x-hw-appduplicator", (Object) "1").setBackupAction(this.f1016h).setBackupDeviceId(this.f1010b).setBakId(str2).setLockId(str3).setIncludeDeleted(1).setCursor(str4).setXHwBackupid(str2).setPageSize(100).setUsage(SnapshotDBManager.PREFIX_DATABASE_NAME);
        return list;
    }

    /* renamed from: M */
    public final void m1820M(String str, List<String> list, Map<String, List<App>> map) throws C9721b, SQLException {
        List<SnapshotBackupMeta> list2;
        Iterator<String> it;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (list.isEmpty()) {
            m1848a0(str);
        } else {
            List<SnapshotBackupMeta> rootsSafety = this.f1022n.getRootsSafety(str);
            if (!AbstractC14026a.m84159a(rootsSafety)) {
                Iterator<String> it2 = list.iterator();
                while (it2.hasNext()) {
                    String next = it2.next();
                    if (!str.equalsIgnoreCase(next)) {
                        CBSBackupRecord cBSBackupRecord = this.f1031w.get(next);
                        if (cBSBackupRecord == null) {
                            C11839m.m70689w("DeleteRecordsV3Task", "successRecord is null");
                        } else {
                            C11839m.m70688i("DeleteRecordsV3Task", "compare to success record Id = " + next + ", version = " + cBSBackupRecord.getVersion());
                            if (m1883u0(cBSBackupRecord)) {
                                this.f1022n.updateSameLeafNodes(str, next);
                            } else {
                                List<App> list3 = map.get(next);
                                if (!AbstractC14026a.m84159a(list3)) {
                                    for (SnapshotBackupMeta snapshotBackupMeta : rootsSafety) {
                                        Set<App> set = this.f1008K.get(next);
                                        Iterator<App> it3 = list3.iterator();
                                        while (true) {
                                            if (!it3.hasNext()) {
                                                list2 = rootsSafety;
                                                it = it2;
                                                break;
                                            }
                                            App next2 = it3.next();
                                            if (set == null || !set.contains(next2)) {
                                                list2 = rootsSafety;
                                                int iM1685c = C0241z.m1685c(next2.getProperties().get("splitappuid"));
                                                it = it2;
                                                if (TextUtils.equals(snapshotBackupMeta.getAppId(), next2.getBackupAppName())) {
                                                    C11839m.m70688i("DeleteRecordsV3Task", "successAppList contains invalidAppId: " + snapshotBackupMeta.getAppId());
                                                    if (m1801q0(next2) != null) {
                                                        C11839m.m70686d("DeleteRecordsV3Task", "compare same files by snapshot");
                                                        this.f1022n.updateV2SameFileNodesByV3(str, next, snapshotBackupMeta.getAppId(), iM1685c);
                                                    }
                                                    m1818L(str, next2, snapshotBackupMeta.getAppId());
                                                } else {
                                                    it2 = it;
                                                    rootsSafety = list2;
                                                }
                                            } else {
                                                C11839m.m70689w("DeleteRecordsV3Task", "success skip:" + snapshotBackupMeta.getAppId());
                                                this.f1022n.updateSkipThisApp(str, snapshotBackupMeta.getAppId());
                                            }
                                        }
                                        it2 = it;
                                        rootsSafety = list2;
                                    }
                                }
                            }
                            it2 = it2;
                            rootsSafety = rootsSafety;
                        }
                    }
                }
                this.f1022n.updateDeletedLeafNodes(str);
            }
        }
        C11839m.m70688i("DeleteRecordsV3Task", "after pick up, update metas data3 spend seconds = " + getSecondsTime(jCurrentTimeMillis));
        deleteFilesFromVFSServer(str);
        String str2 = this.f1023o + this.f1022n.getDBName(str);
        ArrayList arrayList = new ArrayList();
        arrayList.add(str2);
        m1858f0(arrayList);
        this.f1000C.m1896j(str, this.f1022n.querySizeExcludeStandApk(str));
        this.f1022n.deleteSnapshotDB(str);
    }

    /* renamed from: M0 */
    public final /* synthetic */ void m1821M0(String str, App app, b bVar) {
        if (bVar.mo1769a(str, app)) {
            m1859f1(str, app, false);
        }
    }

    /* renamed from: N */
    public final void m1822N(String str, List<App> list) throws C9721b, SQLException {
        Set<App> set = this.f1008K.get(str);
        for (String str2 : this.f1033y) {
            if (!str.equalsIgnoreCase(str2)) {
                C11839m.m70688i("DeleteRecordsV3Task", "compare with success backup record, id = " + str2);
                for (App app : list) {
                    String backupAppName = app.getBackupAppName();
                    if (set == null || !set.contains(app)) {
                        CBSBackupRecord cBSBackupRecord = this.f1031w.get(str2);
                        if (cBSBackupRecord == null) {
                            C11839m.m70688i("DeleteRecordsV3Task", "compareV3FilesWithSuccessRecord warning:successRecord is null,successBackupId is:" + str2);
                        } else if (m1883u0(cBSBackupRecord)) {
                            m1824O(str, str2, app);
                        } else {
                            m1826P(str, str2, app);
                        }
                    } else {
                        C11839m.m70688i("DeleteRecordsV3Task", "compare with success backup record do invalidAppId skip :" + backupAppName);
                    }
                }
            }
        }
    }

    /* renamed from: N0 */
    public final /* synthetic */ void m1823N0(b bVar, final String str, final App app) {
        Optional.ofNullable(bVar).ifPresent(new Consumer() { // from class: am.n0
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f969a.m1821M0(str, app, (C0306w0.b) obj);
            }
        });
    }

    /* renamed from: O */
    public final void m1824O(String str, String str2, App app) throws C9721b, SQLException {
        CBSBackupRecord cBSBackupRecord = this.f1031w.get(str2);
        if (cBSBackupRecord == null || !m1883u0(cBSBackupRecord) || app == null) {
            C11839m.m70688i("DeleteRecordsV3Task", "compareV3FilesWithSuccessRecordV2 warn:bad input,successRecord or invalidApp is null");
            return;
        }
        C11839m.m70688i("DeleteRecordsV3Task", "compareV3FilesWithSuccessRecordV2 enter:app is" + app.getBackupAppName() + ",toBeDeleted backupId:" + str + ",compared successBackupId:" + str2);
        this.f1022n.updateV3SameNodesByOldRecord(str2, str, app.getBackupAppName(), C0241z.m1685c(app.getProperties().get("splitappuid")));
    }

    /* renamed from: O0 */
    public final /* synthetic */ void m1825O0(final b bVar, final String str, List list) {
        list.forEach(new Consumer() { // from class: am.k0
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f957a.m1823N0(bVar, str, (App) obj);
            }
        });
    }

    /* renamed from: P */
    public final void m1826P(String str, String str2, App app) throws C9721b, SQLException {
        List<App> list = this.f1032x.get(str2);
        if (AbstractC14026a.m84159a(list)) {
            C11839m.m70688i("DeleteRecordsV3Task", "compareV3FilesWithSuccessRecordV3:v3SuccessAppList is empty.");
            return;
        }
        int iM1685c = C0241z.m1685c(app.getProperties().get("splitappuid"));
        String backupAppName = app.getBackupAppName();
        Set<App> set = this.f1008K.get(str2);
        for (App app2 : list) {
            if (TextUtils.equals(backupAppName, app2.getBackupAppName())) {
                if (set == null || !set.contains(app2)) {
                    if (m1801q0(app) == null || m1801q0(app2) == null) {
                        return;
                    }
                    C11839m.m70688i("DeleteRecordsV3Task", "v3SuccessAppList contains invalidAppId: " + backupAppName + ", invalidAppUid = " + iM1685c);
                    if (new C12164f(str2, backupAppName, 0, iM1685c).m73026B() > 0) {
                        this.f1022n.updateV3SameNodesByV3(str2, str, backupAppName, iM1685c);
                        return;
                    }
                    throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "snapshot empty, backupId" + str2 + ", appId: " + backupAppName + ", uid: " + iM1685c);
                }
                C11839m.m70688i("DeleteRecordsV3Task", "compare with success backup record do successRecordSkipApp skip :" + backupAppName);
                this.f1022n.updateSkipThisAppV3(str, backupAppName, iM1685c);
            }
        }
    }

    /* renamed from: P0 */
    public final /* synthetic */ void m1827P0(String str, final String str2) {
        C11839m.m70688i("DeleteRecordsV3Task", "snapshotHealthCheck success check: " + str2);
        CBSBackupRecord cBSBackupRecord = this.f1031w.get(str2);
        if (cBSBackupRecord == null) {
            return;
        }
        final b bVar = f997N.get(str);
        if (m1883u0(cBSBackupRecord)) {
            Optional.ofNullable(bVar).ifPresent(new Consumer() { // from class: am.g0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.f940a.m1843X0(str2, (C0306w0.b) obj);
                }
            });
        } else {
            Optional.ofNullable(this.f1032x.get(str2)).ifPresent(new Consumer() { // from class: am.h0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.f944a.m1825O0(bVar, str2, (List) obj);
                }
            });
        }
    }

    /* renamed from: Q */
    public final boolean m1828Q(App app, App app2) {
        Map<String, String> properties = app.getProperties();
        Map<String, String> properties2 = app2.getProperties();
        if (properties2.isEmpty() || properties.isEmpty()) {
            C11839m.m70686d("DeleteRecordsV3Task", "invalid app or success app properties is empty");
            return false;
        }
        String str = properties2.get("apkServerPath");
        if (TextUtils.isEmpty(str)) {
            C11839m.m70686d("DeleteRecordsV3Task", "invalidApkServerPath is empty");
            return false;
        }
        if (TextUtils.equals(str, properties.get("apkServerPath"))) {
            return true;
        }
        C11839m.m70686d("DeleteRecordsV3Task", "invalidApkServerPath not equals successApkServerPath");
        return false;
    }

    /* renamed from: Q0 */
    public final /* synthetic */ void m1829Q0(List list, final String str) {
        if (m1882t0(str)) {
            list.forEach(new Consumer() { // from class: am.x
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.f1045a.m1827P0(str, (String) obj);
                }
            });
        }
    }

    /* renamed from: R */
    public final boolean m1830R(App app, App app2) {
        Map<String, String> properties = app.getProperties();
        Map<String, String> properties2 = app2.getProperties();
        if (properties2.isEmpty() || properties.isEmpty()) {
            C11839m.m70686d("DeleteRecordsV3Task", "invalid app or success app properties is empty");
            return false;
        }
        String str = properties2.get("iconServerPath");
        if (TextUtils.isEmpty(str)) {
            C11839m.m70686d("DeleteRecordsV3Task", "invalidIconServerPath is empty");
            return false;
        }
        if (TextUtils.equals(str, properties.get("iconServerPath"))) {
            return true;
        }
        C11839m.m70686d("DeleteRecordsV3Task", "invalidIconServerPath not equals successIconServerPath");
        return false;
    }

    /* renamed from: R0 */
    public final /* synthetic */ void m1831R0(String str, b bVar) {
        if (bVar.mo1769a(str, null)) {
            m1855d1(str, null, true);
        }
    }

    /* renamed from: S */
    public final Map<String, List<FileDelete>> m1832S(List<App> list) {
        HashMap map = new HashMap();
        if (AbstractC14026a.m84159a(list)) {
            C11839m.m70687e("DeleteRecordsV3Task", "compareV3NotStandWithSuccessRecord invalidAppList is empty ");
            return map;
        }
        for (App app : list) {
            String backupAppName = app.getBackupAppName();
            boolean[] zArr = {false, false};
            for (String str : this.f1033y) {
                CBSBackupRecord cBSBackupRecord = this.f1031w.get(str);
                if (cBSBackupRecord == null || !m1883u0(cBSBackupRecord)) {
                    m1876o0(app, zArr, backupAppName, str);
                } else {
                    m1874n0(app, zArr, backupAppName, str);
                }
            }
            boolean z10 = zArr[0];
            boolean z11 = zArr[1];
            if (!z10 || !z11) {
                C11839m.m70688i("DeleteRecordsV3Task", "do not has same apk or icon, need delete not stand metas, hasSameNotStandApk: " + z10 + ", hasSameNotStandIcon: " + z11);
                List<FileDelete> listM1872m0 = m1872m0(app, z10, z11);
                if (listM1872m0 != null && !listM1872m0.isEmpty()) {
                    map.put(backupAppName, listM1872m0);
                }
            }
        }
        return map;
    }

    /* renamed from: S0 */
    public final /* synthetic */ void m1833S0(String str, App app, b bVar) {
        if (bVar.mo1769a(str, app)) {
            m1855d1(str, app, false);
        }
    }

    /* renamed from: T */
    public final void m1834T(List<CBSBackupRecord> list) throws InterruptedException, C9721b, SQLException {
        new C12607y(list, C13452e.m80781L().m80950o(), this.f1015g, this.f1014f, this.f1023o, C0213f.m1377a()).m76076b();
    }

    /* renamed from: T0 */
    public final /* synthetic */ void m1835T0(b bVar, final String str, final App app) {
        Optional.ofNullable(bVar).ifPresent(new Consumer() { // from class: am.m0
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f966a.m1833S0(str, app, (C0306w0.b) obj);
            }
        });
    }

    /* renamed from: U */
    public final void m1836U() {
        C13466f.m81073d().m81082j("deleteErrorCode", this.f1021m.m60659c());
        C13466f.m81073d().m81084l("deleteErrorMessage", this.f1021m.getMessage());
    }

    /* renamed from: U0 */
    public final /* synthetic */ void m1837U0(final b bVar, final String str, List list) {
        list.forEach(new Consumer() { // from class: am.i0
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f952a.m1835T0(bVar, str, (App) obj);
            }
        });
    }

    /* renamed from: V */
    public final void m1838V(CBSBackupRecord cBSBackupRecord) throws Throwable {
        if (cBSBackupRecord == null) {
            C11839m.m70689w("DeleteRecordsV3Task", "prepareDeleteRecord toBeDeletedRecord is null");
        } else if (m1883u0(cBSBackupRecord)) {
            this.f1012d.m68015V(cBSBackupRecord.getBackupId(), cBSBackupRecord.getDevice().getDeviceId(), cBSBackupRecord.getDevice().getDeviceType(), this.f1017i, 7, cBSBackupRecord.getSnapshot());
        } else {
            m1871l1(cBSBackupRecord.getBackupId(), 7, new ArrayList());
        }
    }

    /* renamed from: V0 */
    public final /* synthetic */ void m1839V0(String str, final String str2) {
        C11839m.m70688i("DeleteRecordsV3Task", "snapshotHealthCheck invalid check: " + str2);
        CBSBackupRecord cBSBackupRecord = this.f1031w.get(str2);
        if (cBSBackupRecord == null) {
            return;
        }
        final b bVar = f997N.get(str);
        if (m1883u0(cBSBackupRecord)) {
            Optional.ofNullable(bVar).ifPresent(new Consumer() { // from class: am.d0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.f929a.m1831R0(str2, (C0306w0.b) obj);
                }
            });
        } else {
            Optional.ofNullable(this.f1032x.get(str2)).ifPresent(new Consumer() { // from class: am.f0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.f937a.m1837U0(bVar, str2, (List) obj);
                }
            });
        }
    }

    /* renamed from: W */
    public final void m1840W() throws SQLException {
        StringBuilder sb2 = new StringBuilder();
        for (String str : this.f1034z) {
            CBSBackupRecord cBSBackupRecord = this.f1031w.get(str);
            if (cBSBackupRecord != null) {
                try {
                    if (m1883u0(cBSBackupRecord)) {
                        m1846Z(cBSBackupRecord);
                    } else {
                        m1852c0(cBSBackupRecord);
                    }
                    this.f1031w.remove(str);
                    m1873m1(cBSBackupRecord, false, null, false);
                } catch (C9721b e10) {
                    m1873m1(cBSBackupRecord, false, e10, false);
                    m1870l0(sb2, cBSBackupRecord, e10);
                    C11839m.m70687e("DeleteRecordsV3Task", "delete invalid record error: " + e10.getMessage());
                }
            }
        }
        if (C4633d0.m28404a(sb2.toString())) {
            return;
        }
        this.f1021m = new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, sb2.toString());
    }

    /* renamed from: W0 */
    public final /* synthetic */ void m1841W0(List list, final String str) {
        if (m1882t0(str)) {
            list.forEach(new Consumer() { // from class: am.z
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.f1058a.m1839V0(str, (String) obj);
                }
            });
        }
    }

    /* renamed from: X */
    public final void m1842X(String str, CBSBackupRecord cBSBackupRecord) {
        try {
            this.f1012d.m68032p(this.f1011c, this.f1015g, str);
            m1873m1(cBSBackupRecord, false, null, true);
        } catch (C9721b e10) {
            C11839m.m70687e("DeleteRecordsV3Task", "processDirectlyDelRecordsIds exception:" + e10.getMessage());
            m1873m1(cBSBackupRecord, false, e10, true);
        }
    }

    /* renamed from: X0 */
    public final /* synthetic */ void m1843X0(String str, b bVar) {
        if (bVar.mo1769a(str, null)) {
            m1859f1(str, null, true);
        }
    }

    /* renamed from: Y */
    public final void m1844Y() {
        C13466f.m81073d().m81081i("isStartDeleteTask", false);
    }

    /* renamed from: Y0 */
    public BakList m1845Y0(String str, final String str2, final String str3) throws C9721b {
        final String str4 = "baks(id,backupVersion,backupStatus,startTime,updateTime,endTime,device,isRefurbishment,gradeCode,bmDataType)";
        return (BakList) new C14000c0(new C14000c0.a() { // from class: am.u0
            @Override // p814yl.C14000c0.a
            /* renamed from: a */
            public final CloudBackupV3Request mo1697a(CloudBackupV3Server cloudBackupV3Server) {
                return C0306w0.m1778F0(str4, str2, str3, cloudBackupV3Server);
            }
        }).m84139b("Backup.device.baks.list", str);
    }

    /* renamed from: Z */
    public final void m1846Z(CBSBackupRecord cBSBackupRecord) throws C9721b, SQLException {
        if (cBSBackupRecord == null) {
            return;
        }
        C11839m.m70688i("DeleteRecordsV3Task", "delete v1, v2 backup record, id = " + cBSBackupRecord.getBackupId() + ", version = " + cBSBackupRecord.getVersion());
        String backupId = cBSBackupRecord.getBackupId();
        if (this.f1022n.existSnapshotDataBase(backupId)) {
            m1820M(backupId, this.f1033y, this.f1032x);
        }
        this.f1012d.m68032p(this.f1011c, this.f1015g, backupId);
    }

    /* renamed from: Z0 */
    public final void m1847Z0() throws C9721b {
        C1457c c1457c = new C1457c(this.f1013e, this.f1010b, this.f1024p, this.f1002E, this.f1027s, this.f1026r, false, false, this.f1004G, this.f1005H);
        this.f1020l = c1457c;
        c1457c.m8337j(null);
        this.f1025q = this.f1020l.mo8329d().getLockId();
        List<String> cloudControlAction = this.f1020l.mo8329d().getCloudControlAction();
        if (cloudControlAction != null && !cloudControlAction.isEmpty() && cloudControlAction.contains("2")) {
            this.f1030v = "2";
        }
        this.f1020l.m8328c();
    }

    /* renamed from: a0 */
    public final void m1848a0(String str) throws C9721b, SQLException {
        if (!this.f1022n.existSnapshotDataBase(str)) {
            C11839m.m70689w("DeleteRecordsV3Task", "existSnapshotDataBase");
            return;
        }
        this.f1022n.updateDeletedLeafNodesByStatus(str, 4);
        this.f1022n.updateDeletedLeafNodesByStatus(str, -4);
        this.f1022n.updateDeletedLeafNodesByStatus(str, 5);
        this.f1022n.updateDeletedLeafNodesByStatus(str, 6);
        this.f1022n.updateDeletedLeafNodesByStatus(str, -6);
    }

    /* renamed from: a1 */
    public final void m1849a1() throws Throwable {
        ArrayList arrayList = new ArrayList(this.f1031w.values());
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        for (CBSBackupRecord cBSBackupRecord : arrayList) {
            if (cBSBackupRecord.getStatus() == 0) {
                C11839m.m70688i("DeleteRecordsV3Task", "success record: " + cBSBackupRecord.getBackupId() + ",bmDataType:" + cBSBackupRecord.getBmDataType() + ",endTime:" + C11667a.m69659a(cBSBackupRecord.getEndTime()));
                this.f1033y.add(cBSBackupRecord.getBackupId());
            } else if (cBSBackupRecord.getStatus() == 7) {
                C11839m.m70688i("DeleteRecordsV3Task", "invalid record: " + cBSBackupRecord.getBackupId());
                this.f1034z.add(cBSBackupRecord.getBackupId());
            } else if (cBSBackupRecord.getStatus() == 1) {
                C11839m.m70688i("DeleteRecordsV3Task", "inbackuping record: " + cBSBackupRecord.getBackupId());
                if (!C12590s0.m75869k1(this.f1002E) || C12590s0.m75869k1(cBSBackupRecord.getGradeCode())) {
                    this.f998A.add(cBSBackupRecord.getBackupId());
                } else {
                    this.f1034z.add(cBSBackupRecord.getBackupId());
                    C11839m.m70688i("DeleteRecordsV3Task", "delete invalid inBacking recoed: " + cBSBackupRecord.getBackupId());
                    m1871l1(cBSBackupRecord.getBackupId(), 7, new ArrayList());
                }
            }
            if (cBSBackupRecord.getVersion() == null || cBSBackupRecord.getVersion().equals("V1")) {
                arrayList2.add(cBSBackupRecord);
            } else if (cBSBackupRecord.getVersion().equals("V2")) {
                arrayList3.add(cBSBackupRecord);
            } else if (cBSBackupRecord.getVersion().equals(CBSBaseReq.CURRENT_API_VERSION)) {
                arrayList4.add(cBSBackupRecord);
            }
        }
        m1834T(arrayList2);
        m1879q1(arrayList, this.f1033y, this.f1034z);
        if (!AbstractC14026a.m84159a(this.f1034z)) {
            m1860g0(arrayList3, arrayList4);
        }
        if (this.f998A.isEmpty()) {
            return;
        }
        this.f1033y.addAll(this.f998A);
    }

    /* renamed from: b0 */
    public final void m1850b0(List<App> list, String str) throws C9721b {
        if (list == null) {
            C11839m.m70687e("DeleteRecordsV3Task", "deleteV3AppBySnapshotFlag invalidAppList is null !");
            return;
        }
        for (App app : list) {
            String id2 = app.getId();
            C11839m.m70686d("DeleteRecordsV3Task", "deleteV3AppBySnapshotFlag backupId: " + str + " appId: " + app.getBackupAppName());
            this.f1013e.m63549L(this.f1020l, this.f1010b, str, id2, app.getBackupAppName(), app.getSplitApkType(), 0, m1880r0(), new C11732m("10", "from client,DeleteRecordsV3Task_delete_app"));
        }
    }

    /* renamed from: b1 */
    public final void m1851b1() throws C9721b {
        C11839m.m70688i("DeleteRecordsV3Task", "processDirectlyDelAllRecords");
        for (String str : this.f1034z) {
            CBSBackupRecord cBSBackupRecord = this.f1031w.get(str);
            if (cBSBackupRecord == null) {
                C11839m.m70687e("DeleteRecordsV3Task", "processDirectlyDelAllRecords invalidRecord is null");
                return;
            } else {
                if (!m1883u0(cBSBackupRecord)) {
                    throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "processDirectlyDelAllRecords has v3");
                }
                m1842X(str, cBSBackupRecord);
            }
        }
    }

    /* renamed from: c0 */
    public final void m1852c0(CBSBackupRecord cBSBackupRecord) throws C9721b, SQLException {
        if (cBSBackupRecord == null) {
            return;
        }
        String backupId = cBSBackupRecord.getBackupId();
        C11839m.m70688i("DeleteRecordsV3Task", "delete v3 backup record, id = " + backupId + ", version = " + cBSBackupRecord.getVersion());
        List<App> list = this.f1032x.get(backupId);
        m1822N(backupId, list);
        Map<String, List<FileDelete>> mapM1832S = m1832S(list);
        Set<App> orDefault = this.f1008K.getOrDefault(backupId, new HashSet());
        final ArrayList arrayList = new ArrayList();
        Optional.ofNullable(list).ifPresent(new Consumer() { // from class: am.q0
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                arrayList.addAll((List) obj);
            }
        });
        Optional.ofNullable(orDefault).ifPresent(new Consumer() { // from class: am.r0
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                arrayList.removeAll((Set) obj);
            }
        });
        m1854d0(arrayList, backupId);
        m1856e0(mapM1832S);
        m1850b0(list, backupId);
        this.f1013e.m63548K(this.f1020l, this.f1010b, backupId, 0, m1880r0(), new C11732m("10", "from client,DeleteRecordsV3Task_delete_bak"));
        C13617a.m81936r(backupId);
    }

    /* renamed from: c1 */
    public final void m1853c1() {
        this.f1007J.forEach(new Consumer() { // from class: am.t0
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f987a.m1815G0((String) obj);
            }
        });
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws C9721b {
        C13998b0 c13998b0;
        C11839m.m70688i("DeleteRecordsV3Task", "delete record v3 task begin.");
        this.f1000C = new c();
        C13466f.m81073d().m81081i("isDeleteTaskSuccess", false);
        if (TextUtils.isEmpty(this.f1010b)) {
            this.f1021m = new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "v3 deviceId is null");
            reportDeleteRecordTime();
            throw this.f1021m;
        }
        this.f1028t = new SettingOperator().queryBakSourceStrategy();
        C11839m.m70688i("DeleteRecordsV3Task", "bakSourceStrategy: " + this.f1028t);
        try {
            this.f1031w = getAllRecordsFromServer();
        } catch (C9721b unused) {
            this.f1031w = new HashMap();
        }
        try {
            if (this.f1031w.isEmpty()) {
                C11839m.m70688i("DeleteRecordsV3Task", "backupRecords is null or empty");
                C13466f.m81073d().m81081i("isDeleteTaskSuccess", true);
                reportDeleteRecordTime();
                m1844Y();
                return;
            }
            try {
                this.f1000C.m1893g(this.f1001D);
                lock();
                m1849a1();
                C11839m.m70688i("DeleteRecordsV3Task", "successRecordsIds: " + this.f1033y);
                C11839m.m70688i("DeleteRecordsV3Task", "invalidRecordsIds: " + this.f1034z);
                if (!AbstractC14026a.m84159a(this.f1034z)) {
                    m1877o1(this.f1033y, this.f1034z);
                    m1853c1();
                }
                if (this.f1009L && m1881s0()) {
                    if (this.f1034z.size() > 0) {
                        this.f1000C.m1895i(System.currentTimeMillis());
                        m1851b1();
                        this.f1000C.m1894h(System.currentTimeMillis());
                    }
                } else if (this.f1034z.size() > 0) {
                    this.f1000C.m1895i(System.currentTimeMillis());
                    m1840W();
                    this.f1000C.m1894h(System.currentTimeMillis());
                }
                m1799p1();
                if (this.f1021m == null) {
                    m1844Y();
                } else {
                    m1836U();
                }
                reportDeleteRecordTime();
                C13216j.m79423h();
            } catch (C9721b e10) {
                if (this.f1021m == null) {
                    this.f1021m = e10;
                }
                C11839m.m70687e("DeleteRecordsV3Task", "delete backup record error: " + this.f1021m.getMessage());
                m1799p1();
                if (this.f1021m == null) {
                    m1844Y();
                } else {
                    m1836U();
                }
                reportDeleteRecordTime();
                C13216j.m79423h();
                if (C9733f.m60705z().m60763v("cloudBackupDisableDirtyClear") != 0 || this.f1008K.isEmpty()) {
                    return;
                } else {
                    c13998b0 = new C13998b0();
                }
            } catch (Exception e11) {
                if (this.f1021m == null) {
                    this.f1021m = new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "delete error, " + e11 + ", reason: " + C12590s0.m75731C0(e11));
                }
                C11839m.m70687e("DeleteRecordsV3Task", "delete backup record error: " + this.f1021m.getMessage());
                m1799p1();
                if (this.f1021m == null) {
                    m1844Y();
                } else {
                    m1836U();
                }
                reportDeleteRecordTime();
                C13216j.m79423h();
                if (C9733f.m60705z().m60763v("cloudBackupDisableDirtyClear") != 0 || this.f1008K.isEmpty()) {
                    return;
                } else {
                    c13998b0 = new C13998b0();
                }
            }
            if (C9733f.m60705z().m60763v("cloudBackupDisableDirtyClear") != 0 || this.f1008K.isEmpty()) {
                return;
            }
            c13998b0 = new C13998b0();
            c13998b0.m84119P0(this.f1018j, this.f1010b, "dirtyClear");
        } catch (Throwable th2) {
            m1799p1();
            if (this.f1021m == null) {
                m1844Y();
            } else {
                m1836U();
            }
            reportDeleteRecordTime();
            C13216j.m79423h();
            if (C9733f.m60705z().m60763v("cloudBackupDisableDirtyClear") == 0 && !this.f1008K.isEmpty()) {
                new C13998b0().m84119P0(this.f1018j, this.f1010b, "dirtyClear");
            }
            throw th2;
        }
    }

    /* renamed from: d0 */
    public final void m1854d0(List<App> list, final String str) throws C9721b {
        String str2 = "DeleteRecordsV3Task";
        if (AbstractC14026a.m84159a(list)) {
            C11839m.m70687e("DeleteRecordsV3Task", "deleteV3AppBySnapshotFlag invalidAppList is empty !");
            return;
        }
        final int iQueryMaxBatchNumber = new SettingOperator().queryMaxBatchNumber();
        C13029h c13029hM75886o2 = C12590s0.m75886o2();
        C12815f c12815f = (c13029hM75886o2 == null || TextUtils.isEmpty(c13029hM75886o2.m78465h()) || "empty_default_id".equals(c13029hM75886o2.m78465h()) || c13029hM75886o2.m78441G() == 4) ? null : new C12815f("Origin");
        long j10 = 0;
        for (App app : list) {
            if (m1801q0(app) == null) {
                C11839m.m70688i(str2, "invalid app do not has snapshot, return, " + app.getBackupAppName());
            } else {
                final String backupAppName = app.getBackupAppName();
                m1784K(c12815f, backupAppName, this.f1014f, str);
                long jLongValue = j10 + app.getAppTotalSize().longValue();
                final int iM1685c = C0241z.m1685c(app.getProperties().get("splitappuid"));
                C12164f c12164f = new C12164f(str, backupAppName, 0, iM1685c);
                c12164f.m73041I0();
                C11489k c11489k = new C11489k(backupAppName, c12164f);
                final ArrayList arrayList = new ArrayList();
                c11489k.execute(new InterfaceC11495q() { // from class: am.a0
                    @Override // mm.InterfaceC11495q
                    /* renamed from: a */
                    public final void mo1695a(AbstractC11494p abstractC11494p, int i10) throws C9721b {
                        this.f878a.m1813B0(backupAppName, iM1685c, arrayList, iQueryMaxBatchNumber, str, abstractC11494p, i10);
                    }
                });
                j10 = jLongValue;
                str2 = str2;
            }
        }
        this.f1000C.m1896j(str, j10);
    }

    /* renamed from: d1 */
    public final void m1855d1(String str, App app, boolean z10) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("processInvalidRecords : ");
        sb2.append(str);
        sb2.append(" app: ");
        sb2.append(app == null ? "null" : app.getBackupAppName());
        C11839m.m70688i("DeleteRecordsV3Task", sb2.toString());
        if (z10) {
            this.f1007J.add(str);
        } else {
            this.f1008K.computeIfAbsent(str, new Function() { // from class: am.j0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return C0306w0.m1780H0((String) obj);
                }
            }).add(app);
        }
    }

    public final void deleteFilesFromVFSServer(String str) throws C9721b {
        if (str == null) {
            return;
        }
        Map<String, List<String>> mapQueryDeletedLeafNodes = this.f1022n.queryDeletedLeafNodes(str);
        if (mapQueryDeletedLeafNodes == null || mapQueryDeletedLeafNodes.size() <= 0) {
            C11839m.m70688i("DeleteRecordsV3Task", "delete file list is null or empty");
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        C11839m.m70688i("DeleteRecordsV3Task", "delete file size = " + mapQueryDeletedLeafNodes.size());
        HashSet<String> hashSet = new HashSet();
        for (Map.Entry<String, List<String>> entry : mapQueryDeletedLeafNodes.entrySet()) {
            String key = entry.getKey();
            for (String str2 : entry.getValue()) {
                String str3 = this.f1023o + key + "/" + str2;
                if (!hashSet.contains(str3)) {
                    C11839m.m70688i("DeleteRecordsV3Task", "delete appId: " + key + ", path = " + str2);
                    hashSet.add(str3);
                }
            }
        }
        if (hashSet.size() <= 0) {
            C11839m.m70688i("DeleteRecordsV3Task", "no need to delete files.");
            return;
        }
        ArrayList arrayList = new ArrayList();
        int iM75423v = new C12526j().m75423v();
        int size = 0;
        int i10 = 0;
        for (String str4 : hashSet) {
            if (!TextUtils.isEmpty(str4)) {
                arrayList.add(str4);
            }
            i10++;
            if (arrayList.size() >= iM75423v) {
                m1858f0(arrayList);
                size += arrayList.size();
                arrayList.clear();
            }
            if (i10 >= hashSet.size() && !arrayList.isEmpty()) {
                m1858f0(arrayList);
                size += arrayList.size();
            }
        }
        C11839m.m70688i("DeleteRecordsV3Task", "delete files end,, spend seconds = " + getSecondsTime(jCurrentTimeMillis) + ", delete size = " + size);
    }

    public void deleteLock() {
        this.f1029u = null;
        this.f1029u = new CBLockTimer(this.f1011c, this.f1014f, this.f1015g, 1, BackupPowerKitKeepTimer.getInstance().getApplyType(this.f1017i == 1));
        C12515a.m75110o().m75172d(this.f1029u);
    }

    public void deleteUnLock() {
        CBLockTimer cBLockTimer = this.f1029u;
        if (cBLockTimer != null) {
            cBLockTimer.cancel();
            this.f1029u = null;
        }
    }

    /* renamed from: e0 */
    public final void m1856e0(Map<String, List<FileDelete>> map) throws C9721b {
        for (Map.Entry<String, List<FileDelete>> entry : map.entrySet()) {
            String key = entry.getKey();
            List<FileDelete> value = entry.getValue();
            StringBuilder sb2 = new StringBuilder();
            if (m1816H(value, key, sb2)) {
                throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "deleteV3File batch fail:" + ((Object) sb2));
            }
        }
    }

    /* renamed from: e1 */
    public final void m1857e1(List<String> list, List<String> list2, Map<String, List<App>> map) throws Throwable {
        if (this.f999B.isEmpty()) {
            C11839m.m70688i("DeleteRecordsV3Task", "snapshot not exist record is empty");
            return;
        }
        C11839m.m70688i("DeleteRecordsV3Task", "process snapshot not exist");
        this.f999B.sort(new Comparator() { // from class: am.s0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return C0306w0.m1781I0((CBSBackupRecord) obj, (CBSBackupRecord) obj2);
            }
        });
        for (int i10 = 0; i10 < this.f999B.size() - 1; i10++) {
            if (m1883u0(this.f999B.get(i10))) {
                m1861g1(this.f999B.get(i10), list, false);
            } else {
                m1863h1(this.f999B.get(i10), list2, map, false);
            }
        }
        List<CBSBackupRecord> list3 = this.f999B;
        CBSBackupRecord cBSBackupRecord = list3.get(list3.size() - 1);
        if (m1883u0(cBSBackupRecord)) {
            m1861g1(cBSBackupRecord, list, true);
        } else {
            m1863h1(cBSBackupRecord, list2, map, true);
        }
    }

    /* renamed from: f0 */
    public final void m1858f0(List<String> list) throws C9721b {
        Result resultM78736f0 = new C13049a(EnumC12999a.CLOUD_BACKUP, this.f1014f).m78736f0((String[]) list.toArray(new String[list.size()]), false);
        if (resultM78736f0.getFailList().isEmpty()) {
            return;
        }
        Iterator<Result.ErrMsg> it = resultM78736f0.getFailList().iterator();
        while (it.hasNext()) {
            int errCode = it.next().getErrCode();
            if (errCode != 102 && errCode != 401) {
                throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "delete error");
            }
        }
    }

    /* renamed from: f1 */
    public final void m1859f1(String str, App app, boolean z10) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("processSuccessRecords : ");
        sb2.append(str);
        sb2.append(" app: ");
        sb2.append(app == null ? "null" : app.getBackupAppName());
        C11839m.m70688i("DeleteRecordsV3Task", sb2.toString());
        if (z10) {
            this.f1009L = true;
        } else {
            this.f1008K.computeIfAbsent(str, new Function() { // from class: am.l0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return C0306w0.m1783J0((String) obj);
                }
            }).add(app);
        }
    }

    /* renamed from: g0 */
    public final void m1860g0(List<CBSBackupRecord> list, List<CBSBackupRecord> list2) throws Throwable {
        List<String> listM1862h0 = m1862h0(list);
        Map<String, List<App>> mapM1866j0 = m1866j0(list2);
        ArrayList arrayList = new ArrayList();
        m1857e1(listM1862h0, arrayList, mapM1866j0);
        if (!listM1862h0.isEmpty()) {
            C11839m.m70688i("DeleteRecordsV3Task", "notProcessV2Record : " + listM1862h0);
            this.f1033y.removeAll(listM1862h0);
            this.f1034z.removeAll(listM1862h0);
        }
        if (arrayList.isEmpty()) {
            return;
        }
        C11839m.m70688i("DeleteRecordsV3Task", "processedV3Record: " + arrayList);
        this.f1033y.removeAll(arrayList);
        this.f1034z.removeAll(arrayList);
        this.f1034z.addAll(arrayList);
    }

    /* renamed from: g1 */
    public final void m1861g1(CBSBackupRecord cBSBackupRecord, List<String> list, boolean z10) throws Throwable {
        if (cBSBackupRecord.getStatus() == 7) {
            C11839m.m70688i("DeleteRecordsV3Task", "invalid backup record snapshot not exist, backupId: " + cBSBackupRecord.getBackupId());
            this.f1012d.m68032p(this.f1011c, this.f1015g, cBSBackupRecord.getBackupId());
            list.add(cBSBackupRecord.getBackupId());
            m1873m1(cBSBackupRecord, true, null, false);
            return;
        }
        C11839m.m70688i("DeleteRecordsV3Task", "success or inbackuping backup record snapshot not exist, backupId: " + cBSBackupRecord.getBackupId());
        if (z10) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.f1030v);
            this.f1012d.m68014U(cBSBackupRecord.getBackupId(), cBSBackupRecord.getDevice().getDeviceId(), cBSBackupRecord.getDevice().getDeviceType(), this.f1017i, arrayList, 7, cBSBackupRecord.getSnapshot());
        } else {
            this.f1012d.m68015V(cBSBackupRecord.getBackupId(), cBSBackupRecord.getDevice().getDeviceId(), cBSBackupRecord.getDevice().getDeviceType(), this.f1017i, 7, cBSBackupRecord.getSnapshot());
        }
        this.f1012d.m68032p(this.f1011c, this.f1015g, cBSBackupRecord.getBackupId());
        list.add(cBSBackupRecord.getBackupId());
        m1873m1(cBSBackupRecord, true, null, false);
    }

    public final Map<String, CBSBackupRecord> getAllRecordsFromServer() throws C9721b {
        HashMap map = new HashMap();
        if ("2".equals(this.f1028t)) {
            m1869k1(map);
        } else {
            for (CBSBackupRecord cBSBackupRecord : this.f1012d.m67998E(false, false, false)) {
                String deviceId = cBSBackupRecord.getDevice().getDeviceId();
                if (deviceId != null && !deviceId.isEmpty()) {
                    if (C12590s0.m75728B1(cBSBackupRecord.getVersion())) {
                        C11839m.m70688i("DeleteRecordsV3Task", "skip V4 record id:" + cBSBackupRecord.getBackupId());
                    } else if (cBSBackupRecord.isRefurbishment()) {
                        C11839m.m70686d("DeleteRecordsV3Task", "skip v2 refurbishment record id: " + cBSBackupRecord.getBackupId());
                    } else if (this.f1011c.equals(deviceId)) {
                        map.put(cBSBackupRecord.getBackupId(), cBSBackupRecord);
                    }
                }
            }
        }
        return map;
    }

    public boolean getDeleteLockTimerResult() throws C9721b {
        C11839m.m70688i("DeleteRecordsV3Task", "start getDeleteLockTimerResult ");
        CBLockTimer cBLockTimer = this.f1029u;
        if (cBLockTimer == null) {
            return false;
        }
        List<String> clientActionList = cBLockTimer.getClientActionList();
        if (clientActionList != null && !clientActionList.isEmpty() && clientActionList.contains("2")) {
            this.f1030v = "2";
        }
        if (this.f1029u.getLockId() == null) {
            return true;
        }
        this.f1025q = this.f1029u.getLockId();
        return true;
    }

    public String getLocation() {
        return C10279b.m63452a(C10278a.m63442h(C0213f.m1377a().getFilesDir() + "/cloudbackup"));
    }

    public final CBSBackupRecord getOldestBackupRecord(List<CBSBackupRecord> list) {
        String deviceId;
        CBSBackupRecord cBSBackupRecord = null;
        for (CBSBackupRecord cBSBackupRecord2 : list) {
            if (cBSBackupRecord2.getStatus() == 0 && (deviceId = cBSBackupRecord2.getDevice().getDeviceId()) != null && !deviceId.isEmpty() && this.f1011c.equals(deviceId) && (cBSBackupRecord == null || cBSBackupRecord.getEndTime() > cBSBackupRecord2.getEndTime())) {
                cBSBackupRecord = cBSBackupRecord2;
            }
        }
        return cBSBackupRecord;
    }

    public long getSecondsTime(long j10) {
        return (System.currentTimeMillis() - j10) / 1000;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public String getTag() {
        return "DeleteRecordsV3Task";
    }

    /* renamed from: h0 */
    public final List<String> m1862h0(List<CBSBackupRecord> list) throws C9721b {
        C11839m.m70688i("DeleteRecordsV3Task", "download v2 records.");
        ArrayList arrayList = new ArrayList();
        for (CBSBackupRecord cBSBackupRecord : list) {
            if (!TextUtils.isEmpty(cBSBackupRecord.getSnapshot())) {
                String backupId = cBSBackupRecord.getBackupId();
                boolean zExistSnapshotDataBase = this.f1022n.existSnapshotDataBase(backupId);
                boolean z10 = false;
                if (zExistSnapshotDataBase && this.f1022n.queryAllMetasNum(backupId) > 0) {
                    z10 = true;
                }
                if (!zExistSnapshotDataBase || !z10) {
                    C11839m.m70688i("DeleteRecordsV3Task", "download v2 snapshot db, backupId = " + backupId + ", status = " + cBSBackupRecord.getStatus());
                    this.f1022n.deleteSnapshotDB(backupId);
                    String snapshot = (cBSBackupRecord.getStatus() == 7 || cBSBackupRecord.getStatus() == 1) ? this.f1023o + this.f1022n.getDBName(backupId) : cBSBackupRecord.getStatus() == 0 ? cBSBackupRecord.getSnapshot() : "";
                    if (!TextUtils.isEmpty(snapshot)) {
                        try {
                            m1864i0(snapshot, this.f1022n.getDBName(backupId));
                        } catch (C9721b e10) {
                            processDownloadException(e10, cBSBackupRecord, arrayList, this.f999B);
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    /* renamed from: h1 */
    public final void m1863h1(CBSBackupRecord cBSBackupRecord, List<String> list, Map<String, List<App>> map, boolean z10) throws C9721b {
        String backupId = cBSBackupRecord.getBackupId();
        final List<App> list2 = map.get(backupId);
        C11839m.m70688i("DeleteRecordsV3Task", "process v3 snapshot not exist, backupId: " + backupId);
        ArrayList arrayList = new ArrayList();
        if (z10) {
            arrayList.add(this.f1030v);
        }
        m1871l1(backupId, 7, arrayList);
        m1850b0(list2, backupId);
        if (list2 != null) {
            Optional.ofNullable(this.f1032x.get(backupId)).ifPresent(new Consumer() { // from class: am.y
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    ((List) obj).removeAll(list2);
                }
            });
        }
        list.add(backupId);
    }

    /* renamed from: i0 */
    public void m1864i0(String str, String str2) throws C9721b {
        C12478a c12478a = new C12478a(EnumC12999a.CLOUD_BACKUP, this.f1014f);
        String parent = C0213f.m1378b().getDatabasePath(str2).getParent();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getLocation());
        String str3 = java.io.File.separator;
        sb2.append(str3);
        sb2.append(str2);
        String string = sb2.toString();
        java.io.File fileM63442h = C10278a.m63442h(string);
        if (fileM63442h.exists() && !fileM63442h.delete()) {
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "downloadSnapshotDb tempFile delete file error");
        }
        c12478a.m74913i(str, string, this.f1019k);
        java.io.File fileM63442h2 = C10278a.m63442h(parent + str3 + str2);
        if (fileM63442h2.exists() && !fileM63442h2.delete()) {
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "downloadSnapshot delete file error");
        }
        if (!C11835i.m70654r(fileM63442h, fileM63442h2)) {
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "downloadSnapshot snapFile rename error");
        }
    }

    /* renamed from: i1 */
    public final List<App> m1865i1(String str) throws C9721b {
        AppList appListM1867j1 = m1867j1(str, null, this.f1025q);
        ArrayList arrayList = new ArrayList(appListM1867j1.getApps());
        String nextCursor = appListM1867j1.getNextCursor();
        while (nextCursor != null && !nextCursor.isEmpty()) {
            AppList appListM1867j12 = m1867j1(str, nextCursor, this.f1025q);
            arrayList.addAll(appListM1867j12.getApps());
            nextCursor = appListM1867j12.getNextCursor();
        }
        return arrayList;
    }

    /* renamed from: j0 */
    public final Map<String, List<App>> m1866j0(List<CBSBackupRecord> list) throws C9721b {
        C11839m.m70688i("DeleteRecordsV3Task", "download v3 records.");
        HashMap map = new HashMap();
        for (CBSBackupRecord cBSBackupRecord : list) {
            String backupId = cBSBackupRecord.getBackupId();
            List<App> listM1865i1 = m1865i1(backupId);
            ArrayList arrayList = new ArrayList();
            for (App app : listM1865i1) {
                try {
                    m1868k0(backupId, app);
                } catch (C9721b e10) {
                    C11839m.m70687e("DeleteRecordsV3Task", "download v3 snapshot error: " + e10.getMessage());
                    if (m1885z0(e10) && "2".equals(this.f1030v)) {
                        arrayList.add(app);
                    } else {
                        if (!this.f1034z.contains(backupId)) {
                            throw e10;
                        }
                        this.f1034z.remove(backupId);
                    }
                }
            }
            this.f1032x.put(backupId, listM1865i1);
            if (!arrayList.isEmpty()) {
                C11839m.m70688i("DeleteRecordsV3Task", "snapshot not exist list is not empty, need process record");
                this.f999B.add(cBSBackupRecord);
                map.put(backupId, arrayList);
            }
        }
        return map;
    }

    /* renamed from: j1 */
    public final AppList m1867j1(final String str, final String str2, final String str3) throws C9721b {
        final String str4 = "nextCursor,apps(id,backupAppName,apkType,runtimeType,backupAppStatus,appTotalSize,fileCount,packageVersion,createTime,updateTime,endTime,properties,attachments(assetId,versionId,usage,state,type,hash,objects,downloadUrl),splitApkType)";
        return (AppList) new C14000c0(new C14000c0.a() { // from class: am.w
            @Override // p814yl.C14000c0.a
            /* renamed from: a */
            public final CloudBackupV3Request mo1697a(CloudBackupV3Server cloudBackupV3Server) {
                return this.f991a.m1819L0(str4, str, str3, str2, cloudBackupV3Server);
            }
        }).m84139b("Backup.device.bak.apps.list", this.f1014f);
    }

    /* renamed from: k0 */
    public final void m1868k0(final String str, App app) throws C9721b {
        String str2;
        C11839m.m70686d("DeleteRecordsV3Task", "downloadV3Snapshot backupId:" + str + " ,app: " + app.getBackupAppName());
        Attachment attachmentM1801q0 = m1801q0(app);
        if (attachmentM1801q0 == null) {
            C11839m.m70688i("DeleteRecordsV3Task", "app snapshot is null");
            if (!m1875n1(str) && (str2 = app.getProperties().get("appwithdata")) != null && String.valueOf(1).equals(str2)) {
                throw new C9721b(3911, "the snapshot of app with data is null.");
            }
            return;
        }
        String backupAppName = app.getBackupAppName();
        if (m1884y0(str, backupAppName, C0241z.m1685c(app.getProperties().get("splitappuid")), app.getProperties().getOrDefault("hashSha256", ""))) {
            return;
        }
        C11839m.m70688i("DeleteRecordsV3Task", "download v3 snapshot db, backupId = " + str + ", appId = " + backupAppName);
        String strM81939u = C13617a.m81939u(str);
        final String str3 = strM81939u + "/" + backupAppName + FeedbackWebConstants.SUFFIX;
        java.io.File fileM63442h = C10278a.m63442h(str3);
        final String assetId = attachmentM1801q0.getAssetId();
        final String id2 = app.getId();
        final String versionId = attachmentM1801q0.getVersionId();
        C10546a.m64704a(new C10546a.a() { // from class: am.t
            @Override // im.C10546a.a
            /* renamed from: a */
            public final InterfaceC10551c0 mo1696a() {
                return this.f981a.m1814C0(str, str3, assetId, id2, versionId);
            }
        }).m64705b();
        if (!C12590s0.m75805U2(str3, strM81939u)) {
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "unzip file: " + fileM63442h.getName());
        }
        if (!fileM63442h.delete()) {
            C11839m.m70689w("DeleteRecordsV3Task", "download snapshot tar file: " + fileM63442h.getName() + ", delete error.");
        }
        C11839m.m70688i("DeleteRecordsV3Task", "download v3 snapshot db success");
    }

    /* renamed from: k1 */
    public final void m1869k1(Map<String, CBSBackupRecord> map) throws C9721b {
        List<com.huawei.hicloud.cloudbackup.p104v3.server.model.Bak> baks = m1845Y0(this.f1014f, this.f1016h, this.f1010b).getBaks();
        if (baks.size() > 0) {
            for (com.huawei.hicloud.cloudbackup.p104v3.server.model.Bak bak : baks) {
                if (bak.isRefurbishment()) {
                    C11839m.m70686d("DeleteRecordsV3Task", "skip refurbishment record id: " + bak.getId());
                } else if (C12590s0.m75728B1(bak.getBackupVersion())) {
                    C11839m.m70688i("DeleteRecordsV3Task", "skip V4 record id:" + bak.getId());
                } else {
                    CBSBackupRecord cBSBackupRecord = new CBSBackupRecord();
                    cBSBackupRecord.setBackupId(bak.getId());
                    cBSBackupRecord.setBackupDeviceId(bak.getBackupDeviceId());
                    cBSBackupRecord.setVersion(bak.getBackupVersion());
                    cBSBackupRecord.setStatus(bak.getBackupStatus().intValue());
                    cBSBackupRecord.setRefurbishment(bak.isRefurbishment());
                    cBSBackupRecord.setGradeCode(bak.getGradeCode());
                    cBSBackupRecord.setBmDataType(bak.getBmDataType().intValue());
                    C4644l endTime = bak.getEndTime();
                    C4644l startTime = bak.getStartTime();
                    if (endTime != null) {
                        cBSBackupRecord.setEndTime(endTime.m28458c());
                    }
                    if (startTime != null) {
                        cBSBackupRecord.setStartTime(startTime.m28458c());
                    }
                    CBSDevice cBSDevice = new CBSDevice();
                    cBSDevice.setDeviceId(ICBUtil.parseDeviceId(bak));
                    cBSBackupRecord.setDevice(cBSDevice);
                    map.put(cBSBackupRecord.getBackupId(), cBSBackupRecord);
                }
            }
        }
    }

    public final void keepDeleteLock() throws C9721b {
        boolean deleteLockTimerResult;
        deleteLock();
        try {
            deleteLockTimerResult = getDeleteLockTimerResult();
            e = null;
        } catch (C9721b e10) {
            e = e10;
            C11839m.m70689w("DeleteRecordsV3Task", "delete oldest backup record, lock requeset exception");
            deleteLockTimerResult = false;
        }
        if (deleteLockTimerResult) {
            return;
        }
        C11839m.m70689w("DeleteRecordsV3Task", "delete oldest backup record, lock requeset error.");
        deleteUnLock();
        if (e != null) {
            throw e;
        }
    }

    /* renamed from: l0 */
    public final void m1870l0(StringBuilder sb2, CBSBackupRecord cBSBackupRecord, C9721b c9721b) {
        sb2.append("[");
        sb2.append(cBSBackupRecord.getBackupId());
        sb2.append('|');
        sb2.append(c9721b.getMessage());
        sb2.append("]");
    }

    /* renamed from: l1 */
    public com.huawei.hicloud.cloudbackup.p104v3.server.model.Bak m1871l1(String str, int i10, List<String> list) throws C9721b {
        BakRefresh bakRefresh = new BakRefresh();
        bakRefresh.setUpdateTime(new C4644l(System.currentTimeMillis())).setBackupStatus(Integer.valueOf(i10));
        if (!list.isEmpty()) {
            bakRefresh.setCloudControlAction(list);
        }
        return this.f1013e.m63535A0(this.f1020l, this.f1010b, str, bakRefresh, 0, m1880r0());
    }

    /* renamed from: m0 */
    public final List<FileDelete> m1872m0(App app, boolean z10, boolean z11) {
        Map<String, String> properties = app.getProperties();
        if (properties.isEmpty()) {
            C11839m.m70686d("DeleteRecordsV3Task", "invalid app not contains notStand app");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        String str = properties.get("apkServerPath");
        if (!z10 && !TextUtils.isEmpty(str)) {
            C11839m.m70688i("DeleteRecordsV3Task", "need delete not stand apk: " + str);
            FileDelete fileDelete = new FileDelete();
            fileDelete.setLogs(FileDeleteLogs.getFileDeleteLogs(C0241z.m1688f(properties.get("apksize")), 0, null, false, ".apk").toString());
            fileDelete.setCloudPath(str.substring(str.lastIndexOf("/") + 1));
            arrayList.add(fileDelete);
        }
        String str2 = properties.get("iconServerPath");
        if (!z11 && !TextUtils.isEmpty(str2)) {
            C11839m.m70688i("DeleteRecordsV3Task", "need delete not stand icon: " + str2);
            FileDelete fileDelete2 = new FileDelete();
            fileDelete2.setLogs(FileDeleteLogs.getFileDeleteLogs(C0241z.m1688f(properties.get("iconsize")), 0, null, false, ".icon").toString());
            fileDelete2.setCloudPath(str2.substring(str2.lastIndexOf("/") + 1));
            arrayList.add(fileDelete2);
        }
        return arrayList;
    }

    /* renamed from: m1 */
    public final void m1873m1(CBSBackupRecord cBSBackupRecord, boolean z10, C9721b c9721b, boolean z11) {
        if (cBSBackupRecord == null) {
            C11839m.m70688i("DeleteRecordsV3Task", "reportDeleteSingleRecord error,backupRecord is null.");
            return;
        }
        String str = "delete single record success, backupid: " + cBSBackupRecord.getBackupId() + ",bmDataType:" + cBSBackupRecord.getBmDataType();
        C11060c c11060cM66626a = C11058a.m66626a(this.f1014f, "deleteSingleRecord", C13452e.m80781L().m80971t0());
        c11060cM66626a.m66635A(str);
        c11060cM66626a.m66665u("0");
        c11060cM66626a.m66668x("1");
        c11060cM66626a.m66664t(c9721b == null ? "success" : "fail");
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("backupTraceID", this.f1018j);
        linkedHashMap.put("isSnapshotNotExist", String.valueOf(z10));
        linkedHashMap.put(JsbMapKeyNames.H5_USER_ID, C13452e.m80781L().m80971t0());
        linkedHashMap.put("traceID", this.f1014f);
        linkedHashMap.put("errorReason", str);
        if (c9721b != null) {
            linkedHashMap.put(TrackConstants$Events.EXCEPTION, c9721b.getMessage());
        }
        linkedHashMap.put("isDirect", String.valueOf(z11));
        linkedHashMap.put("code", "0");
        C13225d.m79490f1().m79603z0("delete_single_record", linkedHashMap);
    }

    /* renamed from: n0 */
    public final void m1874n0(App app, boolean[] zArr, String str, String str2) {
        Map<String, String> properties = app.getProperties();
        if (properties == null || properties.isEmpty()) {
            return;
        }
        String str3 = properties.get("apkServerPath");
        if (!TextUtils.isEmpty(str3)) {
            C11839m.m70686d("DeleteRecordsV3Task", "compare v2 same not stand apk by v3 apkServerPath");
            zArr[0] = this.f1022n.querySameAppFile(str2, str, str3.substring(str3.lastIndexOf("/") + 1));
        }
        String str4 = properties.get("iconServerPath");
        if (TextUtils.isEmpty(str4)) {
            return;
        }
        C11839m.m70686d("DeleteRecordsV3Task", "compare v2 same not stand icon by v3 iconServerPath");
        zArr[1] = this.f1022n.querySameAppFile(str2, str, str4.substring(str4.lastIndexOf("/") + 1));
    }

    /* renamed from: n1 */
    public final boolean m1875n1(String str) {
        return (this.f1034z.contains(str) && m1882t0("cloudBackupInvalidRecordNoAttach")) || (this.f1033y.contains(str) && m1882t0("cloudBackupSuccessRecordNoAttach")) || (this.f998A.contains(str) && m1882t0("cloudBackupingRecordSnapEmpty"));
    }

    /* renamed from: o0 */
    public final void m1876o0(App app, boolean[] zArr, String str, String str2) {
        List<App> list = this.f1032x.get(str2);
        if (list != null) {
            for (App app2 : list) {
                if (TextUtils.equals(str, app2.getBackupAppName())) {
                    if (m1828Q(app2, app)) {
                        zArr[0] = true;
                    }
                    if (m1830R(app2, app)) {
                        zArr[1] = true;
                        return;
                    }
                    return;
                }
            }
        }
    }

    /* renamed from: o1 */
    public final void m1877o1(final List<String> list, final List<String> list2) {
        C11839m.m70688i("DeleteRecordsV3Task", "snapshotHealthCheck flags : " + this.f1006I);
        Arrays.stream(new String[]{"cloudBackupInvalidRecordCorruption", "cloudBackupInvalidRecordSnapEmpty", "cloudBackupInvalidRecordNoAttach"}).forEach(new Consumer() { // from class: am.o0
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f973a.m1841W0(list2, (String) obj);
            }
        });
        Arrays.stream(new String[]{"cloudBackupSuccessRecordCorruption", "cloudBackupSuccessRecordSnapEmpty", "cloudBackupSuccessRecordNoAttach"}).forEach(new Consumer() { // from class: am.p0
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f976a.m1829Q0(list, (String) obj);
            }
        });
    }

    /* renamed from: p0 */
    public final String m1878p0(Map<String, Set<App>> map) {
        final StringBuilder sb2 = new StringBuilder();
        map.forEach(new BiConsumer() { // from class: am.e0
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                C0306w0.m1776E0(sb2, (String) obj, (Set) obj2);
            }
        });
        return sb2.toString();
    }

    public final void parseRecordSize(LinkedHashMap<String, String> linkedHashMap) {
        c cVar = this.f1000C;
        if (cVar == null || cVar.m1890d() == null) {
            C11839m.m70687e("DeleteRecordsV3Task", "parseRecordSize:  reportDeleteInfo is null ,or getRecordsMap is null");
            return;
        }
        for (Map.Entry<String, Long> entry : this.f1000C.m1890d().entrySet()) {
            linkedHashMap.put(entry.getKey(), String.valueOf(entry.getValue().longValue()));
        }
    }

    public final void processDownloadException(C9721b c9721b, CBSBackupRecord cBSBackupRecord, List<String> list, List<CBSBackupRecord> list2) throws C9721b {
        if (ICBUtil.isSnapshotNotExist(c9721b) && "2".equals(this.f1030v)) {
            list2.add(cBSBackupRecord);
            return;
        }
        if (cBSBackupRecord.getStatus() == 0 || cBSBackupRecord.getStatus() == 1) {
            throw c9721b;
        }
        if (cBSBackupRecord.getStatus() == 7) {
            C11839m.m70688i("DeleteRecordsV3Task", "download invalid record error, delete invalid record in next task");
            list.add(cBSBackupRecord.getBackupId());
        }
    }

    /* renamed from: q1 */
    public final void m1879q1(List<CBSBackupRecord> list, List<String> list2, List<String> list3) throws Throwable {
        ArrayList arrayList = new ArrayList(list);
        CBSBackupRecord cBSBackupRecordM76069c = C12605x0.m76069c(arrayList, this.f1011c);
        if (cBSBackupRecordM76069c != null) {
            C11839m.m70688i("DeleteRecordsV3Task", "latestBackupRecord is:" + cBSBackupRecordM76069c.getBackupId() + ",bmDataType is:" + cBSBackupRecordM76069c.getBmDataType());
        }
        if (cBSBackupRecordM76069c != null && cBSBackupRecordM76069c.getBmDataType() == 1) {
            C11839m.m70688i("DeleteRecordsV3Task", "latest record is baseData,begin to get toBeDeletedBaseRecordList.");
            for (CBSBackupRecord cBSBackupRecord : C12605x0.m76071e(arrayList, this.f1011c, C12590s0.m75798T())) {
                String backupId = cBSBackupRecord.getBackupId();
                C11839m.m70688i("DeleteRecordsV3Task", "latest record is baseData,toBeDeletedBaseRecord is:" + backupId);
                try {
                    m1838V(cBSBackupRecord);
                    list3.add(backupId);
                    list2.remove(backupId);
                } catch (C9721b e10) {
                    C11839m.m70687e("DeleteRecordsV3Task", "deleteInvalidRecordByServer error,no need to delete record:" + backupId + ",errorReason:" + e10.getMessage());
                }
            }
            return;
        }
        C11839m.m70688i("DeleteRecordsV3Task", "latest record is not baseData,execute formal delete records rules");
        int size = list2.size();
        int iM75751H0 = C12590s0.m75751H0();
        if (iM75751H0 <= 0) {
            C11839m.m70689w("DeleteRecordsV3Task", "invalid maxRecordNum:" + iM75751H0);
            return;
        }
        while (size > iM75751H0) {
            CBSBackupRecord oldestBackupRecord = getOldestBackupRecord(arrayList);
            arrayList.remove(oldestBackupRecord);
            try {
                m1838V(oldestBackupRecord);
                size--;
                list2.remove(oldestBackupRecord.getBackupId());
                list3.add(oldestBackupRecord.getBackupId());
                C11839m.m70688i("DeleteRecordsV3Task", "success record over maxRecordNum = " + iM75751H0 + " , count = " + size + ", update oldest record invalid: " + oldestBackupRecord.getBackupId() + ",invalid record endTime:" + C11667a.m69659a(oldestBackupRecord.getEndTime()));
            } catch (C9721b e11) {
                C11839m.m70687e("DeleteRecordsV3Task", "deleteInvalidRecordByServer error,no need to delete record:" + oldestBackupRecord.getBackupId() + ",errorReason:" + e11.getMessage());
            }
        }
    }

    /* renamed from: r0 */
    public final Lock m1880r0() {
        if (this.f1020l != null) {
            return null;
        }
        Lock lock = new Lock();
        lock.setLockId(this.f1025q);
        return lock;
    }

    public final void reportDeleteRecordTime() {
        if (this.f1000C != null) {
            LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
            linkedHashMap.put("taskStartTime", String.valueOf(this.f1000C.m1891e()));
            linkedHashMap.put("taskEndTime", String.valueOf(System.currentTimeMillis()));
            linkedHashMap.put("deleteStartTime", String.valueOf(this.f1000C.m1888b()));
            linkedHashMap.put("deleteEndTime", String.valueOf(this.f1000C.m1887a()));
            linkedHashMap.put("deleteCount", String.valueOf(this.f1000C.m1890d().size()));
            linkedHashMap.put("backupRecordsNum", String.valueOf(this.f1031w.size()));
            c cVar = this.f1000C;
            cVar.m1897k(cVar.m1887a() - this.f1000C.m1888b());
            linkedHashMap.put("time", String.valueOf(this.f1000C.m1892f()));
            linkedHashMap.put("isAfterBackup", String.valueOf(this.f1001D ? 1 : 0));
            C9721b c9721b = this.f1021m;
            linkedHashMap.put(AddressConstants.Extras.EXTRA_NAME_ERR_CODE, c9721b == null ? "0" : String.valueOf(c9721b.m60659c()));
            C9721b c9721b2 = this.f1021m;
            linkedHashMap.put("errorMessage", c9721b2 == null ? "success" : c9721b2.getMessage());
            linkedHashMap.put("backupTraceID", this.f1018j);
            parseRecordSize(linkedHashMap);
            linkedHashMap.put("backupId", this.f1024p);
            linkedHashMap.put("referenceFileIdsNum", String.valueOf(this.f1003F));
            linkedHashMap.put("directlyDelRecordsIds", this.f1007J.toString());
            linkedHashMap.put(ParamConstants.Param.FLAGS, this.f1006I.toString());
            linkedHashMap.put("skipApp", m1878p0(this.f1008K));
            linkedHashMap.put("hasV1V2SuccessRecordException", String.valueOf(this.f1009L));
            linkedHashMap.put("snapshotEmptyDetail", f996M.toString());
            if (!AbstractC14026a.m84159a(this.f1000C.m1889c())) {
                linkedHashMap.put("doNotDeleteV3BakIds", this.f1000C.m1889c().toString());
            }
            C11060c c11060cM66626a = C11058a.m66626a(this.f1014f, "deleteRecordTime", C13452e.m80781L().m80971t0());
            c11060cM66626a.m66665u("010_200");
            C13622a.m81971q(c11060cM66626a, linkedHashMap, false, true);
            C13225d.m79490f1().m79549A0("delete_records_task_end", linkedHashMap);
            C11839m.m70688i("DeleteRecordsV3Task", "reportDeleteRecordTime: " + this.f1000C.m1892f());
        }
    }

    /* renamed from: s0 */
    public final boolean m1881s0() {
        Iterator<String> it = this.f1034z.iterator();
        while (it.hasNext()) {
            CBSBackupRecord cBSBackupRecord = this.f1031w.get(it.next());
            if (cBSBackupRecord == null) {
                C11839m.m70687e("DeleteRecordsV3Task", "isAllInvalidRecordIsOld invalidRecord is null");
                return false;
            }
            if (!m1883u0(cBSBackupRecord)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: t0 */
    public final boolean m1882t0(String str) {
        return Boolean.TRUE.equals(this.f1006I.get(str));
    }

    /* renamed from: u0 */
    public final boolean m1883u0(CBSBackupRecord cBSBackupRecord) {
        if (cBSBackupRecord == null) {
            C11839m.m70687e("DeleteRecordsV3Task", "isOldRecord record is null");
            return true;
        }
        String version = cBSBackupRecord.getVersion();
        return version == null || "V1".equalsIgnoreCase(version) || "V2".equalsIgnoreCase(version);
    }

    /* renamed from: y0 */
    public final boolean m1884y0(String str, String str2, int i10, String str3) {
        if (C13617a.m81938t(str, str2, 0, i10)) {
            try {
                String strM81942x = C13617a.m81942x(str, str2, 0, i10);
                Md5AndHash md5AndHashM68622d = C11476b.m68622d(C10278a.m63442h(strM81942x));
                if (!TextUtils.isEmpty(str3) && !str3.equals(md5AndHashM68622d.getHash())) {
                    C11839m.m70688i("DeleteRecordsV3Task", str + " snapshot is invalid hash: " + strM81942x);
                    return false;
                }
                if (new C12164f(str, str2, 0, i10).m73026B() > 0) {
                    C11839m.m70688i("DeleteRecordsV3Task", str + " snapshot is valid: " + strM81942x);
                    return true;
                }
            } catch (C9721b unused) {
                C11839m.m70688i("DeleteRecordsV3Task", str + " query snapshot metas error");
            }
        }
        C11839m.m70688i("DeleteRecordsV3Task", str + " snapshot is invalid, appId: " + str2);
        return false;
    }

    /* renamed from: z0 */
    public final boolean m1885z0(C9721b c9721b) {
        if (String.valueOf(c9721b.m60663g()).endsWith(String.valueOf(4041))) {
            return true;
        }
        if (c9721b.m60659c() == 3911 && c9721b.m60663g() == 404) {
            return true;
        }
        C11839m.m70688i("DeleteRecordsV3Task", "code : " + c9721b.m60659c() + ", errorCode: " + c9721b.m60663g() + ", message: " + c9721b.getMessage());
        return false;
    }
}
