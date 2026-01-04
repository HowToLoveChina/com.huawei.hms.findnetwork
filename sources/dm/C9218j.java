package dm;

import android.text.TextUtils;
import cm.C1457c;
import com.huawei.android.hicloud.cloudbackup.manager.CloudBackupBaseTask;
import com.huawei.android.hicloud.cloudbackup.process.task.CloudBackupCreateManager;
import com.huawei.cloud.base.http.C4609l;
import com.huawei.cloud.base.util.C4644l;
import com.huawei.hicloud.base.drive.model.ErrorResp;
import com.huawei.hicloud.cloudbackup.p104v3.core.C4879a;
import com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request;
import com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Server;
import com.huawei.hicloud.cloudbackup.p104v3.server.batch.CloudBackupV3BatchCallback;
import com.huawei.hicloud.cloudbackup.p104v3.server.batch.CloudBackupV3BatchRequest;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.File;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.FileFinish;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.Lock;
import com.huawei.hicloud.cloudbackup.p104v3.server.request.File;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hms.identity.AddressConstants;
import com.huawei.hms.support.api.entity.sns.SNSCode;
import fk.C9721b;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Vector;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import ni.C11707b;
import p015ak.C0226l0;
import p015ak.C0241z;
import p514o9.C11839m;
import p618rm.C12540b1;
import p618rm.C12590s0;
import p618rm.C12594t1;
import p814yl.C14000c0;
import p815ym.AbstractC14026a;
import pl.C12159a;
import pl.C12160b;
import pl.C12161c;
import pl.C12164f;
import tl.C13029h;

/* renamed from: dm.j */
/* loaded from: classes6.dex */
public class C9218j extends CloudBackupBaseTask {

    /* renamed from: a */
    public final String f46283a;

    /* renamed from: b */
    public final C13029h f46284b;

    /* renamed from: c */
    public final String f46285c;

    /* renamed from: d */
    public final C1457c f46286d;

    /* renamed from: e */
    public final Integer f46287e;

    /* renamed from: f */
    public final String f46288f;

    /* renamed from: g */
    public final List<C12161c> f46289g;

    /* renamed from: k */
    public final int f46293k;

    /* renamed from: l */
    public final int f46294l;

    /* renamed from: m */
    public final float f46295m;

    /* renamed from: n */
    public final String f46296n;

    /* renamed from: o */
    public final boolean f46297o;

    /* renamed from: p */
    public final b f46298p;

    /* renamed from: w */
    public final int f46305w;

    /* renamed from: x */
    public final String f46306x;

    /* renamed from: h */
    public final List<C12161c> f46290h = new ArrayList();

    /* renamed from: i */
    public final List<C12161c> f46291i = new ArrayList();

    /* renamed from: j */
    public final List<String> f46292j = new ArrayList();

    /* renamed from: r */
    public final Vector<C9721b> f46300r = new Vector<>();

    /* renamed from: s */
    public final Vector<C9721b> f46301s = new Vector<>();

    /* renamed from: t */
    public final Vector<String> f46302t = new Vector<>();

    /* renamed from: u */
    public final Vector<String> f46303u = new Vector<>();

    /* renamed from: v */
    public final Vector<String> f46304v = new Vector<>();

    /* renamed from: y */
    public final Map<String, String> f46307y = new HashMap();

    /* renamed from: z */
    public int f46308z = 0;

    /* renamed from: q */
    public final C12594t1 f46299q = C12594t1.m75990o();

    /* renamed from: dm.j$b */
    public interface b {
        void onError(C9721b c9721b);
    }

    /* renamed from: dm.j$c */
    public class c extends d {
        public /* synthetic */ c(C9218j c9218j, Vector vector, List list, a aVar) {
            this(vector, list);
        }

        @Override // dm.C9218j.d
        /* renamed from: c */
        public C9721b mo57960c(ErrorResp.Error error, String str) {
            C11707b c11707b;
            String str2 = "mkfile error, appid: " + C9218j.this.f46283a + ", msg: " + error.toString();
            List<ErrorResp.ErrorMsg> errorDetail = error.getErrorDetail();
            if (errorDetail == null || errorDetail.isEmpty()) {
                return new C9721b(3911, str2, str);
            }
            ErrorResp.ErrorMsg errorMsg = errorDetail.get(0);
            String errorCode = errorMsg.getErrorCode();
            if (errorMsg.get("retryParams") != null) {
                String str3 = (String) errorMsg.get("retryParams");
                if (!TextUtils.isEmpty(str3) && (c11707b = (C11707b) C12540b1.m75483a(str3, C11707b.class)) != null) {
                    String str4 = (String) c11707b.get("fileId");
                    if (!TextUtils.isEmpty(str4)) {
                        C9218j.this.f46304v.add(str4);
                        C11839m.m70688i("CloudBackupV3FileMkfile", "get retry fileId = " + str4 + ", retryFileIds size = " + C9218j.this.f46304v.size());
                    }
                }
            }
            if (errorCode.endsWith(String.valueOf(4039))) {
                C9218j.this.f46307y.put("dBDiffErrorReason", "SPACE_FULL, errMsg : " + str2);
                C9218j.this.f46307y.put(AddressConstants.Extras.EXTRA_NAME_ERR_CODE, String.valueOf(4039));
                return new C9721b("2", SNSCode.Status.HWID_UNLOGIN, str2, str);
            }
            if (C9218j.this.m57955H(error.getCode(), errorCode, error.getDescription())) {
                C9218j.this.f46307y.put("dBDiffErrorReason", "LOCK_NOT_FOUND, errMsg : " + str2);
                C9218j.this.f46307y.put(AddressConstants.Extras.EXTRA_NAME_ERR_CODE, String.valueOf(102));
                C9218j c9218j = C9218j.this;
                c9218j.m57959N(c9218j.f46289g, C9218j.this.f46304v);
                return new C9721b(3923, 4004, "lock not found");
            }
            if (m57961a(error.getCode().intValue(), errorCode)) {
                C9218j.this.f46307y.put("dBDiffErrorReason", "FILE_NOT_FOUND, errMsg : " + str2);
                C9218j.this.f46307y.put(AddressConstants.Extras.EXTRA_NAME_ERR_CODE, String.valueOf(102));
                return new C9721b(FamilyShareConstants.StatusCode.SHARE_SPACE_NOT_ENOUGH, str2, str);
            }
            if (!errorCode.endsWith(String.valueOf(51004915))) {
                C9721b c9721b = new C9721b(3911, C0241z.m1685c(errorCode), str2, str);
                C9218j.this.f46307y.put("dBDiffErrorReason", " FileDiffFinishCallback , errMsg : " + str2);
                C9218j.this.f46307y.put(AddressConstants.Extras.EXTRA_NAME_ERR_CODE, errorCode);
                return c9721b;
            }
            String fileId = error.getErrorData() != null ? error.getErrorData().getFileId() : null;
            C9218j.this.f46307y.put("dBDiffErrorReason", " checkFailedFileId : " + fileId + " errMsg : " + str2);
            C9218j.this.f46307y.put(AddressConstants.Extras.EXTRA_NAME_ERR_CODE, String.valueOf(51004915));
            C9218j.this.m57958M(fileId);
            return new C9721b(3931, C0241z.m1685c(errorCode), str2, str);
        }

        public c(Vector<C9721b> vector, List<C12161c> list) {
            super(vector, list);
        }
    }

    /* renamed from: dm.j$d */
    public class d extends CloudBackupV3BatchCallback<File> {

        /* renamed from: a */
        public Vector<C9721b> f46310a;

        /* renamed from: b */
        public List<C12161c> f46311b;

        public /* synthetic */ d(C9218j c9218j, Vector vector, List list, a aVar) {
            this(vector, list);
        }

        /* renamed from: a */
        public boolean m57961a(int i10, String str) {
            return (i10 == 404 && str.endsWith(String.valueOf(4041))) || (i10 == 400 && str.endsWith(String.valueOf(4002))) || (i10 == 400 && str.endsWith(String.valueOf(4004)));
        }

        @Override // com.huawei.hicloud.cloudbackup.p104v3.server.batch.CloudBackupV3BatchCallback, p369ii.InterfaceC10510a
        /* renamed from: b */
        public void onSuccess(File file, C4609l c4609l) throws IOException {
            C11839m.m70688i("CloudBackupV3FileMkfile", "make file success, fileId: " + file.getId());
            try {
                C9218j.this.f46299q.m75994D(5, file.getId(), C9218j.this.f46283a, C9218j.this.f46284b.m78465h(), C9218j.this.f46305w);
                C9218j.this.f46302t.add(file.getId());
            } catch (C9721b e10) {
                C11839m.m70687e("CloudBackupV3FileMkfile", "update mkfile status error, appid: " + C9218j.this.f46283a + ", fileId: " + file.getId() + ", error: " + e10.getMessage());
                if (this.f46310a.isEmpty()) {
                    this.f46310a.add(e10);
                }
            }
        }

        /* renamed from: c */
        public C9721b mo57960c(ErrorResp.Error error, String str) {
            C11707b c11707b;
            String str2 = "mkfile error, appid: " + C9218j.this.f46283a + ", msg: " + error.toString();
            List<ErrorResp.ErrorMsg> errorDetail = error.getErrorDetail();
            if (errorDetail == null || errorDetail.isEmpty()) {
                return new C9721b(3911, str2, str);
            }
            ErrorResp.ErrorMsg errorMsg = errorDetail.get(0);
            String errorCode = errorMsg.getErrorCode();
            if (errorMsg.get("retryParams") != null) {
                String str3 = (String) errorMsg.get("retryParams");
                if (!TextUtils.isEmpty(str3) && (c11707b = (C11707b) C12540b1.m75483a(str3, C11707b.class)) != null) {
                    String str4 = (String) c11707b.get("fileId");
                    if (!TextUtils.isEmpty(str4)) {
                        C9218j.this.f46303u.add(str4);
                        C11839m.m70688i("CloudBackupV3FileMkfile", "get retry fileId = " + str4 + ", retryFileIds size = " + C9218j.this.f46303u.size());
                    }
                }
            }
            if (errorCode.endsWith(String.valueOf(4039))) {
                return new C9721b("2", SNSCode.Status.HWID_UNLOGIN, str2, str);
            }
            if (!C9218j.this.m57955H(error.getCode(), errorCode, error.getDescription())) {
                return m57961a(error.getCode().intValue(), errorCode) ? new C9721b(FamilyShareConstants.StatusCode.SHARE_SPACE_NOT_ENOUGH, str2, str) : new C9721b(3911, C0241z.m1685c(errorCode), str2, str);
            }
            C9218j c9218j = C9218j.this;
            c9218j.m57959N(this.f46311b, c9218j.f46303u);
            return new C9721b(3923, 4004, "lock not found");
        }

        @Override // com.huawei.hicloud.cloudbackup.p104v3.server.batch.CloudBackupV3BatchCallback
        public void onFailure(ErrorResp.Error error, C4609l c4609l) throws IOException {
            C9721b c9721b;
            if (error != null) {
                c9721b = mo57960c(error, "Backup.device.file.finish");
            } else {
                c9721b = new C9721b(3912, "mkfile error, appid: " + C9218j.this.f46283a + ", server return error is null");
            }
            C11839m.m70687e("CloudBackupV3FileMkfile", "mkfile error, appid: " + C9218j.this.f46283a + ", code: " + c9721b.m60659c() + ", msg: " + c9721b.getMessage());
            if (this.f46310a.isEmpty()) {
                this.f46310a.add(c9721b);
            }
        }

        public d(Vector<C9721b> vector, List<C12161c> list) {
            this.f46310a = vector;
            this.f46311b = list;
        }
    }

    public C9218j(C4879a c4879a, C13029h c13029h, String str, String str2, List<C12161c> list, b bVar, int i10) {
        this.f46283a = str;
        this.f46284b = c13029h;
        this.f46285c = str2;
        this.f46286d = c4879a.m29728n0();
        this.f46287e = c4879a.m29636F0();
        this.f46288f = c4879a.m29587j();
        this.f46289g = list;
        this.f46298p = bVar;
        this.f46306x = c4879a.m29654O0();
        this.f46305w = i10;
        this.f46294l = c4879a.m29746t0().m69995f();
        this.f46295m = c4879a.m29746t0().m69996g();
        this.f46293k = c4879a.m29746t0().m69997h();
        this.f46296n = c13029h.m78465h();
        this.f46297o = c4879a.m29753v1();
        m57954G();
    }

    /* renamed from: K */
    public static /* synthetic */ void m57933K(C12164f c12164f, C12159a c12159a) {
        try {
            if (0 == c12159a.m72872H()) {
                c12164f.m73035F0(c12159a.m72925v(), 0);
            } else {
                c12164f.m73087k(c12159a.m72907j(), c12159a.m72927x(), c12159a.m72928y());
            }
        } catch (C9721b e10) {
            C11839m.m70687e("CloudBackupV3FileMkfile", "processDiffFilesCheckFailed fail, " + e10.getMessage());
        }
    }

    /* renamed from: L */
    public static /* synthetic */ void m57934L(List list, List list2) {
        list.addAll((Collection) list2.stream().map(new Function() { // from class: dm.i
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((C12161c) obj).m73009x();
            }
        }).collect(Collectors.toList()));
    }

    /* renamed from: C */
    public void m57950C(List<C12161c> list, int i10) throws InterruptedException, C9721b {
        if (i10 > this.f46293k) {
            C11839m.m70687e("CloudBackupV3FileMkfile", "make diff file exit, retry count is " + i10 + ", more than " + this.f46293k);
            return;
        }
        if (list == null || list.isEmpty()) {
            C11839m.m70688i("CloudBackupV3FileMkfile", "make diff file exit, metaList is empty");
            return;
        }
        this.f46307y.clear();
        CloudBackupV3BatchRequest cloudBackupV3BatchRequest = new CloudBackupV3BatchRequest();
        this.f46301s.clear();
        C11839m.m70688i("CloudBackupV3FileMkfile", "make diff file size = " + list.size() + ", successFileIds size = " + this.f46302t.size() + ", retryCount = " + i10);
        int iMax = this.f46294l;
        for (C12161c c12161c : list) {
            final String strM73009x = c12161c.m73009x();
            if (i10 > 0 && !this.f46304v.isEmpty() && !this.f46304v.contains(strM73009x)) {
                C11839m.m70688i("CloudBackupV3FileMkfile", "not retry fileId:  " + strM73009x);
            } else if (this.f46302t.contains(strM73009x)) {
                C11839m.m70688i("CloudBackupV3FileMkfile", "skip success fileId:  " + strM73009x);
            } else {
                final FileFinish fileFinish = new FileFinish();
                fileFinish.setAssetId(c12161c.m72978e()).setVersionId(c12161c.m72954J());
                fileFinish.setFinishTime(new C4644l(System.currentTimeMillis()));
                new C14000c0(new C14000c0.a() { // from class: dm.g
                    @Override // p814yl.C14000c0.a
                    /* renamed from: a */
                    public final CloudBackupV3Request mo1697a(CloudBackupV3Server cloudBackupV3Server) {
                        return this.f46205a.m57956I(fileFinish, strM73009x, cloudBackupV3Server);
                    }
                }).m84143f(cloudBackupV3BatchRequest, new c(this.f46301s, list));
                iMax = Math.max(iMax, this.f46294l + ((int) ((c12161c.m72987j() / 1048576) * this.f46295m)));
                this.f46307y.put("lastRealInterval", String.valueOf(iMax));
                C11839m.m70686d("CloudBackupV3FileMkfile", "make diff file:  " + c12161c.m72948D() + ", fileId: " + strM73009x);
            }
        }
        this.f46304v.clear();
        if (cloudBackupV3BatchRequest.size() == 0) {
            C11839m.m70687e("CloudBackupV3FileMkfile", "make diff file batchRequest size is 0");
            return;
        }
        if (i10 > 0) {
            C11839m.m70686d("CloudBackupV3FileMkfile", "make diff file retry delay  realInterval = " + iMax);
            C0226l0.m1581a(((long) iMax) * 1000);
        }
        cloudBackupV3BatchRequest.execute("Backup.device.file.finish", this.f46284b.m78444J());
    }

    /* renamed from: D */
    public void m57951D(List<C12161c> list, int i10) throws C9721b {
        if (i10 > 1) {
            C11839m.m70688i("CloudBackupV3FileMkfile", "make file exit, retry count is " + i10 + ", more than 1");
            return;
        }
        if (list == null || list.isEmpty()) {
            C11839m.m70688i("CloudBackupV3FileMkfile", "make file exit, metaList is empty");
            return;
        }
        CloudBackupV3BatchRequest cloudBackupV3BatchRequest = new CloudBackupV3BatchRequest();
        this.f46300r.clear();
        C11839m.m70688i("CloudBackupV3FileMkfile", "make file size = " + list.size() + ", successFileIds size = " + this.f46302t.size() + ", retryCount = " + i10);
        for (C12161c c12161c : list) {
            final String strM73009x = c12161c.m73009x();
            if (i10 > 0 && !this.f46303u.isEmpty() && !this.f46303u.contains(strM73009x)) {
                C11839m.m70688i("CloudBackupV3FileMkfile", "not retry fileId:  " + strM73009x);
            } else if (this.f46302t.contains(strM73009x)) {
                C11839m.m70688i("CloudBackupV3FileMkfile", "skip success fileId:  " + strM73009x);
            } else {
                final FileFinish fileFinish = new FileFinish();
                fileFinish.setAssetId(c12161c.m72978e()).setVersionId(c12161c.m72954J());
                fileFinish.setFinishTime(new C4644l(System.currentTimeMillis()));
                new C14000c0(new C14000c0.a() { // from class: dm.f
                    @Override // p814yl.C14000c0.a
                    /* renamed from: a */
                    public final CloudBackupV3Request mo1697a(CloudBackupV3Server cloudBackupV3Server) {
                        return this.f46168a.m57957J(fileFinish, strM73009x, cloudBackupV3Server);
                    }
                }).m84143f(cloudBackupV3BatchRequest, new d(this.f46300r, list));
                C11839m.m70686d("CloudBackupV3FileMkfile", "make file:  " + c12161c.m72948D() + ", fileId: " + strM73009x);
            }
        }
        this.f46303u.clear();
        if (cloudBackupV3BatchRequest.size() == 0) {
            C11839m.m70687e("CloudBackupV3FileMkfile", "make file batchRequest size is 0");
        } else {
            cloudBackupV3BatchRequest.execute("Backup.device.file.finish", this.f46284b.m78444J());
        }
    }

    /* renamed from: E */
    public final void m57952E(Vector<C9721b> vector) throws C9721b {
        if (AbstractC14026a.m84159a(vector)) {
            return;
        }
        C9721b c9721b = vector.get(0);
        if (c9721b.m60659c() == 3923) {
            this.f46286d.mo8332g(c9721b, m57953F());
        }
    }

    /* renamed from: F */
    public final String m57953F() {
        Lock lockMo8329d;
        C1457c c1457c = this.f46286d;
        return (c1457c == null || (lockMo8329d = c1457c.mo8329d()) == null) ? "" : lockMo8329d.getLockId();
    }

    /* renamed from: G */
    public final void m57954G() {
        this.f46291i.clear();
        this.f46290h.clear();
        for (C12161c c12161c : this.f46289g) {
            C11839m.m70686d("CloudBackupV3FileMkfile", "initMeatList file type = " + c12161c.m72953I() + " name = " + c12161c.m72948D());
            if (c12161c.m72953I() == 9 && c12161c.m72948D().endsWith(".differencepacket")) {
                this.f46291i.add(c12161c);
                this.f46292j.add(c12161c.m72948D());
            } else {
                this.f46290h.add(c12161c);
            }
        }
    }

    /* renamed from: H */
    public final boolean m57955H(Integer num, String str, String str2) {
        return Objects.equals(num, 400) && str.endsWith(String.valueOf(4004)) && str2 != null && str2.contains("lock not found");
    }

    /* JADX WARN: Type inference failed for: r4v5, types: [com.huawei.hicloud.cloudbackup.v3.server.request.File$Finish] */
    /* renamed from: I */
    public final /* synthetic */ CloudBackupV3Request m57956I(FileFinish fileFinish, String str, CloudBackupV3Server cloudBackupV3Server) throws IOException {
        File.Finish finish = cloudBackupV3Server.backup().device().file().finish(fileFinish);
        finish.setFields("id").setBackupAction(this.f46285c).setBackupDeviceId(C12590s0.m75786Q(this.f46284b)).setLockId(m57953F()).setFileId(str).setXHwBackupPackageName(this.f46283a).setXHwBackupid(this.f46296n).setHeader("x-hw-divide", (Object) "1");
        if (this.f46297o) {
            finish.setHeader("x-hw-divide-check", "1");
        }
        return finish;
    }

    /* JADX WARN: Type inference failed for: r4v5, types: [com.huawei.hicloud.cloudbackup.v3.server.request.File$Finish] */
    /* renamed from: J */
    public final /* synthetic */ CloudBackupV3Request m57957J(FileFinish fileFinish, String str, CloudBackupV3Server cloudBackupV3Server) throws IOException {
        File.Finish finish = cloudBackupV3Server.backup().device().file().finish(fileFinish);
        finish.setFields("id").setBackupAction(this.f46285c).setBackupDeviceId(C12590s0.m75786Q(this.f46284b)).setLockId(m57953F()).setXHwBackupPackageName(this.f46283a).setXHwBackupid(this.f46296n).setFileId(str).setBakCategory(this.f46288f).setOccupySpaceType(this.f46287e);
        return finish;
    }

    /* renamed from: M */
    public final void m57958M(String str) {
        if (TextUtils.isEmpty(str)) {
            C11839m.m70687e("CloudBackupV3FileMkfile", "processDiffFilesCheckFailed fileId is null");
            return;
        }
        try {
            C12160b c12160b = new C12160b(this.f46296n, this.f46283a, 0, this.f46305w);
            List<C12159a> listM72942m = c12160b.m72942m(str);
            if (listM72942m.size() > 0) {
                C12159a c12159a = listM72942m.get(0);
                List<C12159a> listM72940k = c12160b.m72940k(c12159a.m72869E(), c12159a.m72870F());
                final C12164f c12164f = new C12164f(this.f46296n, this.f46283a, 0, this.f46305w);
                listM72940k.forEach(new Consumer() { // from class: dm.e
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        C9218j.m57933K(c12164f, (C12159a) obj);
                    }
                });
            }
            c12160b.m72944o(str);
        } catch (C9721b e10) {
            C11839m.m70687e("CloudBackupV3FileMkfile", "processDiffFilesCheckFailed fail, " + e10.getMessage());
        }
    }

    /* renamed from: N */
    public final void m57959N(List<C12161c> list, final List<String> list2) {
        Optional.ofNullable(list).ifPresent(new Consumer() { // from class: dm.h
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                C9218j.m57934L(list2, (List) obj);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:141:0x01eb  */
    @Override // com.huawei.android.hicloud.cloudbackup.manager.CloudBackupBaseTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void call() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 753
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: dm.C9218j.call():void");
    }

    @Override // com.huawei.android.hicloud.cloudbackup.manager.CloudBackupBaseTask
    public void release() {
        CloudBackupCreateManager.getInstance().removeTask(this.f46283a, this);
    }
}
