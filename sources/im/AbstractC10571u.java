package im;

import android.os.SystemClock;
import android.text.TextUtils;
import cm.AbstractC1455a;
import com.huawei.android.hicloud.cloudbackup.process.util.SplitFileUtil;
import com.huawei.android.hicloud.security.service.UserKeyUtils;
import com.huawei.android.hicloud.utils.hole.HoleUtil;
import com.huawei.android.remotecontrol.tag.p092ui.view.RippleView;
import com.huawei.cloud.base.util.C4633d0;
import com.huawei.cloud.base.util.C4658z;
import com.huawei.hicloud.base.bean.Md5AndHash;
import com.huawei.hicloud.base.drive.model.ErrorResp;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.Asset;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.Cipher;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.Resource;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.request.userk.bean.UserKeyBaseReq;
import com.huawei.hms.network.embedded.C5927g2;
import com.huawei.hms.network.file.api.Progress;
import com.huawei.hms.network.file.api.Request;
import com.huawei.hms.network.file.api.RequestConfig;
import com.huawei.hms.network.file.api.Response;
import com.huawei.hms.network.file.api.Result;
import com.huawei.hms.network.file.api.exception.NetworkException;
import com.huawei.hms.network.file.download.api.DownloadManager;
import com.huawei.hms.network.file.download.api.FileRequestCallback;
import com.huawei.hms.network.file.download.api.GetRequest;
import fk.C9721b;
import gp.C10028c;
import hk.C10278a;
import hk.C10279b;
import hk.C10280c;
import hm.C10321z;
import java.io.Closeable;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import mk.C11476b;
import org.json.JSONException;
import org.json.JSONObject;
import p012ab.C0087b;
import p015ak.C0213f;
import p283fa.C9679b;
import p292fn.C9731d;
import p292fn.C9733f;
import p365ic.C10466a;
import p429kk.C11058a;
import p429kk.C11060c;
import p455ll.C11312e;
import p455ll.C11313f;
import p456lm.AbstractC11314a;
import p456lm.C11315b;
import p514o9.C11835i;
import p514o9.C11839m;
import p618rm.C12590s0;
import p618rm.C12604x;
import p652t9.EnumC12999a;
import p709vj.C13452e;
import p712vm.C13468a;
import p733w9.C13576a;
import p746wn.C13622a;
import p767x9.C13735d;
import p814yl.C13998b0;
import p814yl.C14000c0;

/* renamed from: im.u */
/* loaded from: classes6.dex */
public abstract class AbstractC10571u extends AbstractC10548b implements InterfaceC10551c0 {

    /* renamed from: S */
    public static final Object f50842S = new Object();

    /* renamed from: T */
    public static String f50843T = "";

    /* renamed from: A */
    public boolean f50844A;

    /* renamed from: C */
    public long f50846C;

    /* renamed from: D */
    public long f50847D;

    /* renamed from: E */
    public int f50848E;

    /* renamed from: F */
    public String f50849F;

    /* renamed from: K */
    public C11312e f50854K;

    /* renamed from: L */
    public long f50855L;

    /* renamed from: M */
    public long f50856M;

    /* renamed from: N */
    public double f50857N;

    /* renamed from: O */
    public int f50858O;

    /* renamed from: P */
    public String f50859P;

    /* renamed from: Q */
    public boolean f50860Q;

    /* renamed from: R */
    public String f50861R;

    /* renamed from: f */
    public String f50862f;

    /* renamed from: g */
    public File f50863g;

    /* renamed from: h */
    public File f50864h;

    /* renamed from: i */
    public String f50865i;

    /* renamed from: j */
    public String f50866j;

    /* renamed from: k */
    public AbstractC1455a f50867k;

    /* renamed from: l */
    public String f50868l;

    /* renamed from: m */
    public String f50869m;

    /* renamed from: n */
    public String f50870n;

    /* renamed from: o */
    public String f50871o;

    /* renamed from: p */
    public String f50872p;

    /* renamed from: q */
    public String f50873q;

    /* renamed from: r */
    public boolean f50874r;

    /* renamed from: t */
    public boolean f50876t;

    /* renamed from: u */
    public long f50877u;

    /* renamed from: v */
    public long f50878v;

    /* renamed from: s */
    public boolean f50875s = false;

    /* renamed from: w */
    public Map<String, Long> f50879w = new HashMap();

    /* renamed from: x */
    public c f50880x = c.NOT_STARTED;

    /* renamed from: y */
    public InterfaceC10562l f50881y = null;

    /* renamed from: z */
    public C11313f f50882z = new C11313f();

    /* renamed from: B */
    public boolean f50845B = false;

    /* renamed from: G */
    public boolean f50850G = false;

    /* renamed from: H */
    public AtomicBoolean f50851H = new AtomicBoolean(false);

    /* renamed from: I */
    public AtomicBoolean f50852I = new AtomicBoolean(false);

    /* renamed from: J */
    public AtomicReference<String> f50853J = new AtomicReference<>("");

    /* renamed from: im.u$a */
    public class a extends d {

        /* renamed from: d */
        public byte[] f50883d;

        /* renamed from: e */
        public byte[] f50884e;

        /* renamed from: f */
        public String f50885f;

        public a(C11312e c11312e, byte[] bArr, byte[] bArr2, String str, CountDownLatch countDownLatch) {
            super(c11312e, countDownLatch);
            this.f50883d = bArr;
            this.f50884e = bArr2;
            this.f50885f = str;
        }

        @Override // im.AbstractC10571u.d
        /* renamed from: a */
        public void mo64882a(String str) throws Throwable {
            File fileM63442h = C10278a.m63442h(str);
            File fileM63442h2 = C10278a.m63442h(this.f50900a.m67965s());
            long jLongValue = this.f50900a.m67966t().longValue();
            try {
                C10466a.m64315f(fileM63442h, fileM63442h2, jLongValue, this.f50883d, this.f50884e);
            } catch (C9721b unused) {
                C11839m.m70688i("CloudRestoreV3AssetDownloader", "retry decrypt file, use hmac.");
                String str2 = this.f50885f;
                this.f50883d = C11476b.m68628j(str2.substring(0, str2.length() / 2));
                String str3 = this.f50885f;
                byte[] bArrM68628j = C11476b.m68628j(str3.substring(str3.length() / 2));
                this.f50884e = bArrM68628j;
                C10466a.m64315f(fileM63442h, fileM63442h2, jLongValue, this.f50883d, bArrM68628j);
            }
        }
    }

    /* renamed from: im.u$b */
    public class b extends FileRequestCallback {

        /* renamed from: a */
        public final Object f50887a = new Object();

        /* renamed from: b */
        public final int f50888b;

        /* renamed from: c */
        public final C11312e f50889c;

        /* renamed from: d */
        public final CountDownLatch f50890d;

        /* renamed from: e */
        public final long f50891e;

        /* renamed from: f */
        public final String f50892f;

        public b(C11312e c11312e, int i10, CountDownLatch countDownLatch, String str, long j10) {
            this.f50888b = i10;
            this.f50889c = c11312e;
            this.f50890d = countDownLatch;
            this.f50891e = j10;
            this.f50892f = str;
        }

        private void release() {
            CountDownLatch countDownLatch = this.f50890d;
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
        }

        /* renamed from: a */
        public final Map<String, String> m64883a() {
            HashMap map = new HashMap();
            map.put("trace_id", AbstractC10571u.this.f50866j);
            map.put("assetId", AbstractC10571u.this.f50872p);
            map.put("objectId", this.f50889c.m67964r());
            return map;
        }

        /* renamed from: b */
        public final void m64884b() throws C9721b {
            synchronized (this.f50887a) {
                this.f50889c.m67952I(1);
                AbstractC10571u.this.f50882z.m67977e(this.f50889c);
            }
        }

        @Override // com.huawei.hms.network.file.api.Callback
        public /* bridge */ /* synthetic */ void onException(Request request, NetworkException networkException, Response response) {
            onException((GetRequest) request, networkException, (Response<GetRequest, File, Closeable>) response);
        }

        @Override // com.huawei.hms.network.file.api.Callback
        public void onSuccess(Response<GetRequest, File, Closeable> response) {
            StringBuilder sb2;
            try {
                try {
                    String str = response.getExtraInfo().get("protocol_impl") + "-" + response.getExtraInfo().get("protocol");
                    C11839m.m70686d("CloudRestoreV3AssetDownloader", "protocol: " + str);
                    C10556f.m64761a(AbstractC10571u.this.f50853J, "", str);
                    AbstractC10571u.this.f50856M = ((GetRequest) response.getRequest()).getId();
                    C11839m.m70688i("CloudRestoreV3AssetDownloader", "taskId [" + AbstractC10571u.this.f50856M + "]slice object [" + this.f50889c.m67964r() + "] download end.");
                    File fileM63442h = C10278a.m63442h(((GetRequest) response.getRequest()).getFilePath());
                    int i10 = this.f50888b;
                    String strM67961k = (i10 == 0 || i10 == 6) ? "" : this.f50889c.m67961k();
                    int i11 = this.f50888b;
                    String strM67961k2 = (i11 == 0 || i11 == 6) ? "" : this.f50889c.m67961k();
                    HashMap map = new HashMap();
                    if (AbstractC10571u.this.m64856N(fileM63442h, strM67961k, strM67961k2, this.f50889c.m67963q(), map)) {
                        m64884b();
                        AbstractC10571u.this.m64880n0(this.f50889c.m67964r(), fileM63442h.length());
                    } else {
                        String str2 = map.get("errMsg") != null ? (String) map.get("errMsg") : "";
                        C11839m.m70689w("CloudRestoreV3AssetDownloader", "hash not match, slice object [" + this.f50889c.m67964r() + "] hash: " + this.f50889c.m67961k() + "errMsg:" + str2);
                        if (!"apk".equals(this.f50892f) || fileM63442h.length() != this.f50889c.m67963q()) {
                            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_OPENED, "hash is not equal, need download again. delete file success = " + fileM63442h.delete() + ", " + fileM63442h.getName(), "download");
                        }
                        m64884b();
                        AbstractC10571u.this.m64880n0(this.f50889c.m67964r(), fileM63442h.length());
                        AbstractC10571u.this.m64873g0("102_1011", "download apk attach hash not match, " + str2);
                        C11839m.m70688i("CloudRestoreV3AssetDownloader", "download apk attach hash not match, but the file lengths are the same.");
                    }
                    sb2 = new StringBuilder();
                } catch (Exception e10) {
                    C11839m.m70687e("CloudRestoreV3AssetDownloader", "taskId [" + AbstractC10571u.this.f50856M + "]slice object [" + this.f50889c.m67964r() + "] download error." + e10);
                    if (e10 instanceof C9721b) {
                        AbstractC10571u.this.m64712g((C9721b) e10);
                    } else {
                        AbstractC10571u.this.m64712g(new C9721b(3911, e10.toString()));
                    }
                    sb2 = new StringBuilder();
                }
                sb2.append("taskId [");
                sb2.append(AbstractC10571u.this.f50856M);
                sb2.append("]slice object [");
                sb2.append(this.f50889c.m67964r());
                sb2.append("] download release.");
                C11839m.m70688i("CloudRestoreV3AssetDownloader", sb2.toString());
                release();
            } catch (Throwable th2) {
                C11839m.m70688i("CloudRestoreV3AssetDownloader", "taskId [" + AbstractC10571u.this.f50856M + "]slice object [" + this.f50889c.m67964r() + "] download release.");
                release();
                throw th2;
            }
        }

        public void onException(GetRequest getRequest, NetworkException networkException, Response<GetRequest, File, Closeable> response) {
            C9721b c9721b;
            synchronized (this.f50887a) {
                try {
                    if (this.f50889c.m67967u() == 1) {
                        return;
                    }
                    AbstractC10571u.this.m64717l(getRequest.getUrl());
                    AbstractC10571u.this.f50856M = getRequest.getId();
                    C13468a c13468aM81100c = C13468a.m81100c();
                    if (c13468aM81100c.m81101b()) {
                        c9721b = AbstractC10571u.this.m64719n(networkException, response != null ? (com.huawei.hms.network.httpclient.Response) response.getRawResponse() : null, "Download");
                    } else {
                        c9721b = new C9721b(3900, c13468aM81100c.toString(), "Download");
                    }
                    C11839m.m70687e("CloudRestoreV3AssetDownloader", "taskId [" + getRequest.getId() + "]slice object [" + this.f50889c.m67964r() + "] download error." + c9721b.toString());
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("e.getMessage:");
                    sb2.append(networkException.getMessage());
                    C11839m.m70688i("CloudRestoreV3AssetDownloader", sb2.toString());
                    if (networkException.getMessage() != null && networkException.getMessage().contains("network error(10000502)")) {
                        C11839m.m70688i("CloudRestoreV3AssetDownloader", "errorMsg contains 10000502");
                        long jM67968v = this.f50889c.m67968v();
                        DownloadManager downloadManagerM82536d = C13735d.m82531s().m82536d(AbstractC10571u.this.m64858Q(), AbstractC10571u.this.m64860S());
                        C11839m.m70688i("CloudRestoreV3AssetDownloader", "cancelRequest:" + jM67968v + ",objectId:" + this.f50889c.m67964r());
                        Result resultCancelRequest = downloadManagerM82536d.cancelRequest(jM67968v);
                        C11839m.m70688i("CloudRestoreV3AssetDownloader", "cancel result:" + resultCancelRequest.getCode() + ",message:" + resultCancelRequest.getMessage() + ",taskId:" + jM67968v + ",objectId:" + this.f50889c.m67964r());
                    }
                    if (networkException.getMessage() != null && networkException.getMessage().contains("params check error(10043008)")) {
                        C11839m.m70689w("CloudRestoreV3AssetDownloader", "params check error(10043008),delete cache from db:" + AbstractC10571u.this.f50865i);
                        try {
                            AbstractC10571u.this.f50882z.m67973a(AbstractC10571u.this.f50865i);
                        } catch (C9721b e10) {
                            C11839m.m70687e("CloudRestoreV3AssetDownloader", "delete path error:" + e10.getMessage());
                        }
                    }
                    if (c9721b.m60659c() == 3911 && c9721b.m60663g() == 404) {
                        AbstractC10571u.this.mo64709d();
                        AbstractC10571u.this.m64873g0("113_404", this.f50889c.m67964r() + " download error. " + c9721b.toString());
                    }
                    AbstractC10571u.this.m64712g(c9721b);
                    release();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // com.huawei.hms.network.file.api.Callback
        public void onProgress(GetRequest getRequest, Progress progress) {
            C11839m.m70686d("CloudRestoreV3AssetDownloader", "taskId [" + getRequest.getId() + "]slice object [" + this.f50889c.m67964r() + "] download progress = " + progress.getProgress() + "size = " + progress.getFinishedSize());
            AbstractC10571u.this.m64880n0(this.f50889c.m67964r(), progress.getFinishedSize());
        }

        @Override // com.huawei.hms.network.file.api.Callback
        public GetRequest onStart(GetRequest getRequest) {
            try {
                int i10 = this.f50888b;
                if (i10 == 0 || i10 == 3 || i10 == 6) {
                    if (System.currentTimeMillis() - this.f50891e >= 840000) {
                        Resource.EndpointURL endpointURLM64852J = AbstractC10571u.this.m64852J(this.f50888b, this.f50889c.m67955a0(), this.f50889c.m67964r());
                        return getRequest.newBuilder().url(endpointURLM64852J.getUrl()).headers(endpointURLM64852J.getHeaders()).reportInfos(m64883a()).build();
                    }
                } else if (System.currentTimeMillis() - AbstractC10571u.this.f50847D >= 840000) {
                    Resource.EndpointURL endpointURLM64852J2 = AbstractC10571u.this.m64852J(this.f50888b, this.f50889c.m67955a0(), this.f50889c.m67964r());
                    return getRequest.newBuilder().url(endpointURLM64852J2.getUrl()).backupUrls(Collections.singletonList(endpointURLM64852J2.getUrl())).headers(endpointURLM64852J2.getHeaders()).reportInfos(m64883a()).build();
                }
            } catch (C9721b e10) {
                C11839m.m70687e("CloudRestoreV3AssetDownloader", "taskId [" + getRequest.getId() + "]slice object [" + this.f50889c.m67964r() + "] get download address error.");
                AbstractC10571u.this.m64712g(e10);
            }
            return getRequest;
        }
    }

    /* renamed from: im.u$c */
    public enum c {
        NOT_STARTED,
        INITIATION_STARTED,
        INITIATION_COMPLETE,
        MEDIA_IN_PROGRESS,
        MEDIA_COMPLETE
    }

    /* renamed from: im.u$d */
    public class d implements Runnable {

        /* renamed from: a */
        public C11312e f50900a;

        /* renamed from: b */
        public CountDownLatch f50901b;

        public d(C11312e c11312e, CountDownLatch countDownLatch) {
            this.f50900a = c11312e;
            this.f50901b = countDownLatch;
        }

        /* renamed from: a */
        public void mo64882a(String str) throws Throwable {
            SplitFileUtil.merge(C10278a.m63442h(str), C10278a.m63442h(this.f50900a.m67965s()), this.f50900a.m67966t().longValue());
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v10, types: [boolean] */
        /* JADX WARN: Type inference failed for: r3v12 */
        /* JADX WARN: Type inference failed for: r3v13 */
        /* JADX WARN: Type inference failed for: r3v14 */
        /* JADX WARN: Type inference failed for: r3v2, types: [boolean] */
        /* JADX WARN: Type inference failed for: r3v4, types: [boolean] */
        /* JADX WARN: Type inference failed for: r3v9, types: [java.lang.StringBuilder] */
        /* JADX WARN: Type inference failed for: r8v0, types: [im.u$d] */
        /* JADX WARN: Type inference failed for: r8v1, types: [im.u$d] */
        /* JADX WARN: Type inference failed for: r8v3, types: [java.util.concurrent.CountDownLatch] */
        @Override // java.lang.Runnable
        public void run() {
            File fileM63442h;
            ?? sb2;
            ?? Exists;
            String str = AbstractC10571u.this.f50863g + File.separator + this.f50900a.m67964r();
            try {
                try {
                    C11839m.m70686d("CloudRestoreV3AssetDownloader", "merge task start, destPath: " + this.f50900a.m67965s() + " , srcPath: " + str);
                    mo64882a(str);
                    C11839m.m70686d("CloudRestoreV3AssetDownloader", "merge task end, destPath: " + this.f50900a.m67965s() + " , srcPath: " + str);
                    fileM63442h = C10278a.m63442h(str);
                    Exists = fileM63442h.exists();
                    str = Exists;
                } catch (C9721b e10) {
                    AbstractC10571u.this.m64712g(e10);
                    fileM63442h = C10278a.m63442h(str);
                    ?? Exists2 = fileM63442h.exists();
                    str = Exists2;
                    if (Exists2 != 0) {
                        sb2 = new StringBuilder();
                    }
                } catch (Exception e11) {
                    AbstractC10571u.this.m64712g(new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "task error." + e11.getMessage() + " stack: " + C12590s0.m75731C0(e11)));
                    fileM63442h = C10278a.m63442h(str);
                    ?? Exists3 = fileM63442h.exists();
                    str = Exists3;
                    if (Exists3 != 0) {
                        sb2 = new StringBuilder();
                    }
                }
                if (Exists != 0) {
                    sb2 = new StringBuilder();
                    sb2.append("src file exits, delete = ");
                    sb2.append(fileM63442h.delete());
                    C11839m.m70686d("CloudRestoreV3AssetDownloader", sb2.toString());
                    str = sb2;
                }
                this = this.f50901b;
                this.countDown();
            } catch (Throwable th2) {
                File fileM63442h2 = C10278a.m63442h(str);
                if (fileM63442h2.exists()) {
                    C11839m.m70686d("CloudRestoreV3AssetDownloader", "src file exits, delete = " + fileM63442h2.delete());
                }
                this.f50901b.countDown();
                throw th2;
            }
        }
    }

    /* renamed from: im.u$e */
    public class e extends AbstractC11314a {

        /* renamed from: e */
        public final int f50903e;

        /* renamed from: f */
        public final C11312e f50904f;

        /* renamed from: g */
        public Resource.EndpointURL f50905g;

        /* renamed from: h */
        public final CountDownLatch f50906h;

        /* renamed from: i */
        public final List<Long> f50907i;

        /* renamed from: j */
        public final String f50908j;

        public e(C11312e c11312e, int i10, Resource.EndpointURL endpointURL, List<Long> list, CountDownLatch countDownLatch, String str) {
            super(c11312e.m67962p(), AbstractC10571u.this.f50848E);
            this.f50904f = c11312e;
            this.f50903e = i10;
            this.f50905g = endpointURL;
            this.f50907i = list;
            this.f50906h = countDownLatch;
            this.f50908j = str;
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x0161 A[PHI: r5
  0x0161: PHI (r5v8 com.huawei.hms.network.file.download.api.GetRequest) = 
  (r5v7 com.huawei.hms.network.file.download.api.GetRequest)
  (r5v7 com.huawei.hms.network.file.download.api.GetRequest)
  (r5v30 com.huawei.hms.network.file.download.api.GetRequest)
 binds: [B:16:0x00bd, B:18:0x00d9, B:22:0x013a] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:25:0x0164 A[Catch: all -> 0x004b, Exception -> 0x004e, b -> 0x0051, TryCatch #3 {b -> 0x0051, Exception -> 0x004e, blocks: (B:3:0x0004, B:5:0x0034, B:15:0x007c, B:17:0x00bf, B:19:0x00db, B:21:0x0125, B:25:0x0164, B:32:0x0213, B:27:0x016a, B:29:0x020a, B:37:0x027f, B:38:0x0288, B:36:0x027b, B:22:0x013a, B:12:0x0054, B:14:0x0066), top: B:45:0x0004, outer: #2 }] */
        /* JADX WARN: Removed duplicated region for block: B:27:0x016a A[Catch: all -> 0x004b, Exception -> 0x004e, b -> 0x0051, TryCatch #3 {b -> 0x0051, Exception -> 0x004e, blocks: (B:3:0x0004, B:5:0x0034, B:15:0x007c, B:17:0x00bf, B:19:0x00db, B:21:0x0125, B:25:0x0164, B:32:0x0213, B:27:0x016a, B:29:0x020a, B:37:0x027f, B:38:0x0288, B:36:0x027b, B:22:0x013a, B:12:0x0054, B:14:0x0066), top: B:45:0x0004, outer: #2 }] */
        /* JADX WARN: Removed duplicated region for block: B:29:0x020a A[Catch: all -> 0x004b, Exception -> 0x004e, b -> 0x0051, TryCatch #3 {b -> 0x0051, Exception -> 0x004e, blocks: (B:3:0x0004, B:5:0x0034, B:15:0x007c, B:17:0x00bf, B:19:0x00db, B:21:0x0125, B:25:0x0164, B:32:0x0213, B:27:0x016a, B:29:0x020a, B:37:0x027f, B:38:0x0288, B:36:0x027b, B:22:0x013a, B:12:0x0054, B:14:0x0066), top: B:45:0x0004, outer: #2 }] */
        /* JADX WARN: Removed duplicated region for block: B:35:0x0278  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x027b A[Catch: all -> 0x004b, Exception -> 0x004e, b -> 0x0051, TryCatch #3 {b -> 0x0051, Exception -> 0x004e, blocks: (B:3:0x0004, B:5:0x0034, B:15:0x007c, B:17:0x00bf, B:19:0x00db, B:21:0x0125, B:25:0x0164, B:32:0x0213, B:27:0x016a, B:29:0x020a, B:37:0x027f, B:38:0x0288, B:36:0x027b, B:22:0x013a, B:12:0x0054, B:14:0x0066), top: B:45:0x0004, outer: #2 }] */
        @Override // com.huawei.android.hicloud.cloudbackup.manager.CloudBackupBaseTask
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void call() {
            /*
                Method dump skipped, instructions count: 682
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: im.AbstractC10571u.e.call():void");
        }

        /* renamed from: e */
        public final Map<String, String> m64885e() {
            HashMap map = new HashMap();
            map.put("trace_id", AbstractC10571u.this.f50866j);
            map.put("assetId", AbstractC10571u.this.f50872p);
            map.put("objectId", this.f50904f.m67964r());
            return map;
        }

        /* renamed from: f */
        public final boolean m64886f(GetRequest getRequest) {
            if (getRequest == null) {
                return false;
            }
            boolean z10 = getRequest.getFileSize() != this.f50904f.m67963q();
            C11839m.m70686d("CloudRestoreV3AssetDownloader", "old FileSize:" + getRequest.getFileSize() + ",current object length:" + this.f50904f.m67963q());
            return z10;
        }
    }

    public AbstractC10571u(String str, String str2, AbstractC1455a abstractC1455a, String str3, String str4, String str5, int i10) {
        this.f50866j = str2;
        this.f50867k = abstractC1455a;
        if (C9733f.m60705z().m60719N()) {
            this.f50865i = m64833e0(str3);
        } else {
            this.f50865i = str3;
        }
        this.f50864h = C10278a.m63442h(this.f50865i);
        this.f50868l = str4;
        this.f50869m = str5;
        this.f50874r = true;
        this.f50863g = C11835i.m70646j(C0213f.m1377a());
        this.f50848E = i10;
        this.f50862f = str;
    }

    /* renamed from: e0 */
    public static String m64833e0(String str) {
        C11839m.m70686d("CloudRestoreV3AssetDownloader", "removeAllInvalidChar:" + str);
        if (str.startsWith("data/")) {
            return str;
        }
        File file = new File(str);
        String parent = file.getParent();
        String name = file.getName();
        if (C10280c.m63459g(name)) {
            C11839m.m70686d("CloudRestoreV3AssetDownloader", "removeAllInvalidChar isValidMatchFatFilename: true");
            return str;
        }
        String strM63456d = C10280c.m63456d(name);
        if (C4633d0.m28404a(strM63456d)) {
            return str;
        }
        return parent + File.separator + strM63456d;
    }

    /* renamed from: C */
    public final void m64845C(Resource resource) throws C9721b {
        HashMap map = new HashMap();
        if (m64856N(this.f50864h, resource.getHash(), resource.getSha256(), resource.getLength().longValue(), map)) {
            return;
        }
        String str = map.get("errMsg") != null ? map.get("errMsg") : "";
        if (this.f50864h.exists() && this.f50864h.length() == resource.getLength().longValue()) {
            m64873g0("102_1011", "decryptSlices hash is not equal, " + str);
            return;
        }
        this.f50859P = "102_1011";
        throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_OPENED, "decryptSlices hash is not equal, need download again. delete file success = " + this.f50864h.delete() + ", " + str, "download");
    }

    /* renamed from: D */
    public final void m64846D(List<C11312e> list, Cipher cipher, Resource resource) throws C9721b {
        m64848F(list, cipher, resource);
        m64845C(resource);
    }

    /* renamed from: E */
    public final void m64847E(List<C11312e> list, Cipher cipher, Resource resource) throws C9721b {
        C11839m.m70686d("CloudRestoreV3AssetDownloader", "decryptAndUnzipSlices start.");
        m64848F(list, cipher, resource);
        m64879m0();
        m64845C(resource);
        C11839m.m70686d("CloudRestoreV3AssetDownloader", "decryptAndUnzipSlices end.");
    }

    /* renamed from: F */
    public final void m64848F(List<C11312e> list, Cipher cipher, Resource resource) throws C9721b {
        C11839m.m70688i("CloudRestoreV3AssetDownloader", "decrypt and merge slices start, path = " + this.f50864h.getName());
        byte[] bArrM68628j = C11476b.m68628j(C10466a.m64311b(cipher.getKeyChains().get(0).getEkey(), (C10028c.m62182c0().m62329g0() ? new C0087b(C9679b.m60452d().m60455e()).m680c(this.f50866j, 19, UserKeyBaseReq.KEY_TYPE_AES_128) : UserKeyUtils.getInstance().getSyncUser(19, this.f50866j)).getUserKey()));
        byte[] bArrM68628j2 = C11476b.m68628j(cipher.getIv());
        ExecutorService executorServiceNewFixedThreadPool = Executors.newFixedThreadPool(16);
        ArrayList arrayList = new ArrayList();
        try {
            CountDownLatch countDownLatch = new CountDownLatch(list.size());
            for (C11312e c11312e : list) {
                m64715j();
                arrayList.add(executorServiceNewFixedThreadPool.submit(new a(c11312e, bArrM68628j, bArrM68628j2, resource.getHash(), countDownLatch)));
            }
            m64718m(countDownLatch);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((Future) it.next()).cancel(false);
            }
            executorServiceNewFixedThreadPool.shutdown();
            C11839m.m70688i("CloudRestoreV3AssetDownloader", "decrypt and merge slices end, path = " + this.f50864h.getName());
        } catch (Throwable th2) {
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                ((Future) it2.next()).cancel(false);
            }
            executorServiceNewFixedThreadPool.shutdown();
            throw th2;
        }
    }

    /* renamed from: G */
    public final Resource m64849G(Asset asset) throws C9721b {
        this.f50727a = null;
        this.f50879w.clear();
        boolean z10 = false;
        this.f50845B = false;
        m64881o0(c.INITIATION_STARTED);
        C12590s0.m75829a2(this.f50864h);
        m64877k0(this.f50858O > 0);
        if (asset == null) {
            asset = m64865X();
        }
        this.f50847D = System.currentTimeMillis();
        m64715j();
        Resource resource = asset.getResource();
        this.f50855L = resource.getCompressedSize().longValue();
        if (!this.f50874r || (resource.getType().intValue() != 0 && resource.getType().intValue() != 3)) {
            z10 = true;
        }
        this.f50876t = z10;
        if (m64855M(this.f50864h, resource.getHash(), resource.getSha256(), resource.getLength().longValue())) {
            this.f50845B = true;
            C11839m.m70688i("CloudRestoreV3AssetDownloader", "file already exits, file = " + this.f50864h.getName());
        } else {
            C13576a c13576aM81565a = C13576a.m81565a();
            String str = this.f50863g + File.separator + resource.getHash();
            while (!c13576aM81565a.m81566b(str)) {
                try {
                    c13576aM81565a.m81570f(str);
                } catch (Throwable th2) {
                    c13576aM81565a.m81568d(str);
                    throw th2;
                }
            }
            m64715j();
            ArrayList arrayList = new ArrayList();
            m64869b0(asset, arrayList);
            m64715j();
            m64857O(resource, asset.getCipher(), arrayList);
            c13576aM81565a.m81568d(str);
        }
        m64881o0(c.MEDIA_COMPLETE);
        return resource;
    }

    /* renamed from: H */
    public final void m64850H(String str, Resource resource, List<C11312e> list, List<Long> list2, String str2) throws C9721b {
        C11312e c11312e;
        C11839m.m70688i("CloudRestoreV3AssetDownloader", "download slice file start, file = " + this.f50864h.getName() + ",type:" + resource.getType());
        List<Resource.SliceObject> objects = resource.getObjects();
        CountDownLatch countDownLatch = new CountDownLatch(objects.size());
        for (Resource.SliceObject sliceObject : objects) {
            if (C4633d0.m28404a(sliceObject.getId()) || resource.getType().intValue() == 6) {
                c11312e = null;
            } else {
                C11839m.m70686d("CloudRestoreV3AssetDownloader", "objectId is not null,query from db,set length:" + sliceObject.getLength() + ",objectId:" + sliceObject.getId());
                c11312e = this.f50882z.m67976d(sliceObject.getId(), this.f50865i);
            }
            if (c11312e == null) {
                C11839m.m70686d("CloudRestoreV3AssetDownloader", "object is null,set length:" + sliceObject.getLength() + ",objectId:" + sliceObject.getId());
                c11312e = new C11312e();
                c11312e.m67946C(str).m67948E(sliceObject.getNumber().intValue()).m67949F(sliceObject.getId()).m67945B(sliceObject.getSha256()).m67951H(sliceObject.getStart()).m67947D(sliceObject.getLength().longValue()).m67969w(sliceObject.getBucket()).m67970x(String.valueOf(sliceObject.getCreatedTime())).m67950G(this.f50865i);
            }
            C11312e c11312e2 = c11312e;
            list.add(c11312e2);
            if (m64855M(C10278a.m63441g(this.f50863g, c11312e2.m67964r()), c11312e2.m67961k(), c11312e2.m67961k(), c11312e2.m67963q())) {
                this.f50879w.put(c11312e2.m67964r(), Long.valueOf(c11312e2.m67963q()));
                m64881o0(c.MEDIA_IN_PROGRESS);
                if (c11312e2.m67967u() != 1) {
                    c11312e2.m67952I(1);
                    this.f50882z.m67977e(c11312e2);
                }
                countDownLatch.countDown();
                C11839m.m70686d("CloudRestoreV3AssetDownloader", "slice object [" + c11312e2.m67964r() + "] already download.");
            } else {
                c11312e2.m67952I(0);
                C11839m.m70686d("CloudRestoreV3AssetDownloader", "object start download,set length:" + sliceObject.getLength() + ",objectId:" + sliceObject.getId());
                e eVar = new e(c11312e2, resource.getType().intValue(), m64861T(sliceObject, str2), list2, countDownLatch, this.f50868l);
                C11315b.m67979c().m67981b(this, false);
                C11315b.m67979c().m67980a(c11312e2.m67962p(), eVar);
            }
            this.f50854K = c11312e2;
        }
        m64718m(countDownLatch);
        C11839m.m70688i("CloudRestoreV3AssetDownloader", "download slice file end, file = " + this.f50864h.getName());
    }

    /* renamed from: I */
    public final void m64851I(String str, Resource resource, List<C11312e> list, List<Long> list2) throws C9721b {
        C11839m.m70688i("CloudRestoreV3AssetDownloader", "download one file start, file = " + this.f50864h.getName());
        CountDownLatch countDownLatch = new CountDownLatch(1);
        String hash = resource.getHash();
        C11312e c11312eM67976d = this.f50882z.m67976d(hash, this.f50865i);
        if (c11312eM67976d == null) {
            c11312eM67976d = new C11312e();
            c11312eM67976d.m67946C(str).m67948E(0).m67949F(hash).m67945B(resource.getHash()).m67951H(0L).m67947D(resource.getLength().longValue()).m67950G(this.f50865i);
        }
        C11312e c11312e = c11312eM67976d;
        list.add(c11312e);
        File fileM63441g = C10278a.m63441g(this.f50863g, c11312e.m67964r());
        if (m64855M(fileM63441g, c11312e.m67961k(), resource.getSha256(), c11312e.m67963q())) {
            this.f50879w.put(c11312e.m67962p(), Long.valueOf(c11312e.m67963q()));
            m64881o0(c.MEDIA_IN_PROGRESS);
            if (c11312e.m67967u() != 1) {
                c11312e.m67952I(1);
                this.f50882z.m67977e(c11312e);
            }
            countDownLatch.countDown();
            C11839m.m70686d("CloudRestoreV3AssetDownloader", "slice object [" + c11312e.m67964r() + "] already download.");
        } else {
            c11312e.m67952I(0);
            e eVar = new e(c11312e, resource.getType().intValue(), resource.getDownloadUrl(), list2, countDownLatch, this.f50868l);
            C11315b.m67979c().m67981b(this, false);
            C11315b.m67979c().m67980a(c11312e.m67962p(), eVar);
        }
        m64718m(countDownLatch);
        m64715j();
        if (!C11835i.m70654r(fileM63441g, this.f50864h)) {
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "move file error. file = " + this.f50864h.getName());
        }
        C11839m.m70688i("CloudRestoreV3AssetDownloader", "download one file end, file = " + this.f50864h.getName());
    }

    /* renamed from: J */
    public final Resource.EndpointURL m64852J(int i10, int i11, String str) throws C9721b {
        ArrayList arrayList;
        Resource.EndpointURL downloadUrl;
        Resource.EndpointURL endpointURLM64861T = null;
        if (i10 == 0 || i10 == 3 || i10 == 6) {
            arrayList = new ArrayList();
            arrayList.add(str);
        } else {
            arrayList = null;
        }
        Asset assetMo64708P = mo64708P((i10 == 0 || i10 == 3) ? "id,state,versionId,cipher,resource(hash,id,length,type,sha256,objects(downloadUrl,accelerateDownloadUrl,id,number,sha256,start,length))" : i10 == 6 ? "id,state,versionId,cipher,resource(encoding,compressedSize,hash,id,length,type,sha256,objects(downloadUrl,accelerateDownloadUrl,id,number,sha256,start,length))" : "id,state,versionId,cipher,resource(downloadUrl,hash,id,length,type,sha256)", arrayList, i10 == 4 ? "cdn" : "origin", false);
        Resource resource = assetMo64708P.getResource();
        if (i10 != resource.getType().intValue()) {
            throw new C9721b(3911, "resource type is invalid.");
        }
        if (i10 == 0 || i10 == 3 || i10 == 6) {
            for (Resource.SliceObject sliceObject : resource.getObjects()) {
                boolean zM28404a = C4633d0.m28404a(sliceObject.getId());
                boolean z10 = zM28404a && i11 == sliceObject.getNumber().intValue();
                boolean z11 = !zM28404a && sliceObject.getId().equals(str);
                if (z10 || z11) {
                    endpointURLM64861T = m64861T(sliceObject, assetMo64708P.getQuicSwitch());
                    break;
                }
            }
            downloadUrl = endpointURLM64861T;
        } else {
            downloadUrl = resource.getDownloadUrl();
        }
        if (downloadUrl != null) {
            return downloadUrl;
        }
        throw new C9721b(3911, "mEndpointUrl is null");
    }

    /* renamed from: K */
    public final void m64853K(Map<String, String> map, String str) {
        if (map != null) {
            map.put("errMsg", str);
        }
    }

    /* renamed from: L */
    public Asset m64854L(C14000c0<Asset> c14000c0, String str) throws C9721b {
        try {
            Asset assetM84139b = c14000c0.m84139b(str, this.f50866j);
            if (assetM84139b.getState().intValue() != 0) {
                throw new C9721b(3911, "state invalid", str);
            }
            if (assetM84139b.getResource() != null) {
                C10321z.m63502C0(assetM84139b, c14000c0);
                return assetM84139b;
            }
            mo64709d();
            throw new C9721b(3911, "resource invalid", str);
        } catch (C9721b e10) {
            C9721b c9721bM64878l0 = m64878l0(c14000c0.m84140c(), e10);
            if (c9721bM64878l0.m60659c() != 3922 || c9721bM64878l0.m60663g() != 4041) {
                throw c9721bM64878l0;
            }
            mo64709d();
            m64873g0("102_404", "download error. " + c9721bM64878l0.toString());
            throw c9721bM64878l0;
        }
    }

    /* renamed from: M */
    public final boolean m64855M(File file, String str, String str2, long j10) throws C9721b {
        return m64856N(file, str, str2, j10, null);
    }

    /* renamed from: N */
    public final boolean m64856N(File file, String str, String str2, long j10, Map<String, String> map) throws C9721b {
        String strM63452a = C10279b.m63452a(file);
        if (!file.exists()) {
            m64853K(map, "file not exist: " + strM63452a);
            return false;
        }
        if (this.f50876t) {
            if (!C4633d0.m28404a(str) || !C4633d0.m28404a(str2)) {
                Md5AndHash md5AndHashM68622d = C11476b.m68622d(file);
                if (C4658z.m28496a(str2, md5AndHashM68622d.getHash()) || C4658z.m28496a(str, md5AndHashM68622d.getMD5())) {
                    return true;
                }
                m64853K(map, "hash not match hash1: " + str + " ,sha2561: " + str2 + " ,size1: " + j10 + ",hash2: " + md5AndHashM68622d.getMD5() + " ,sha2562: " + md5AndHashM68622d.getHash() + " ,size2: " + file.length() + " ,file: " + strM63452a);
            } else {
                if (j10 > 0 && file.length() >= j10) {
                    return true;
                }
                m64853K(map, "hash sha256 is empty and length not match, size1: " + j10 + " ,siez2: " + file.length() + " ,file: " + strM63452a);
            }
        } else {
            if (j10 > 0 && file.length() >= j10) {
                return true;
            }
            m64853K(map, "old data length not match size1: " + j10 + " ,size2: " + file.length() + " ,file: " + strM63452a);
        }
        C11839m.m70689w("CloudRestoreV3AssetDownloader", "file already exits, but need download again. file = " + strM63452a);
        return false;
    }

    /* renamed from: O */
    public final void m64857O(Resource resource, Cipher cipher, List<C11312e> list) throws C9721b {
        int iIntValue = resource.getType().intValue();
        if (iIntValue == 0) {
            m64846D(list, cipher, resource);
        } else if (iIntValue == 3) {
            m64868a0(list, resource);
        } else if (iIntValue == 6) {
            m64847E(list, cipher, resource);
        }
        m64871d0(list, this.f50865i);
    }

    /* renamed from: P */
    public abstract Asset mo64708P(String str, List<String> list, String str2, boolean z10) throws C9721b;

    /* renamed from: Q */
    public final EnumC12999a m64858Q() {
        return this.f50852I.get() ? EnumC12999a.CLOUD_BACKUP_QUIC : EnumC12999a.CLOUD_BACKUP;
    }

    /* renamed from: R */
    public String m64859R() {
        return this.f50859P;
    }

    /* renamed from: S */
    public final String m64860S() throws JSONException {
        if (!C4633d0.m28404a(f50843T)) {
            return f50843T;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("scene", String.valueOf(10));
            String string = jSONObject.toString();
            f50843T = string;
            return string;
        } catch (Exception e10) {
            C11839m.m70689w("CloudRestoreV3AssetDownloader", "getDownloadScene error:" + e10.getMessage());
            return null;
        }
    }

    /* renamed from: T */
    public final Resource.EndpointURL m64861T(Resource.SliceObject sliceObject, String str) {
        Resource.EndpointURL accelerateDownloadUrl;
        if (!this.f50850G && (accelerateDownloadUrl = sliceObject.getAccelerateDownloadUrl()) != null) {
            this.f50851H.compareAndSet(false, true);
            this.f50852I.compareAndSet(false, "1".equals(str));
            return accelerateDownloadUrl;
        }
        return sliceObject.getDownloadUrl();
    }

    /* renamed from: U */
    public long m64862U() {
        Iterator<Long> it = this.f50879w.values().iterator();
        long jLongValue = 0;
        while (it.hasNext()) {
            jLongValue += it.next().longValue();
        }
        double d10 = this.f50857N;
        if (d10 <= 0.0d) {
            return jLongValue;
        }
        long j10 = (long) (jLongValue / d10);
        C11839m.m70686d("CloudRestoreV3AssetDownloader", "getNumBytesDownloaded origin: " + jLongValue + ",result: " + j10 + " ,rota: " + this.f50857N);
        return j10;
    }

    /* renamed from: V */
    public int m64863V() {
        return this.f50858O;
    }

    /* renamed from: W */
    public long m64864W() {
        return this.f50878v;
    }

    /* renamed from: X */
    public final Asset m64865X() throws C9721b {
        String str = "origin";
        if (this.f50858O == 0 && ("apk".equals(this.f50868l) || "icon".equals(this.f50868l))) {
            str = "cdn";
        }
        Asset assetMo64708P = mo64708P((this.f50858O <= 1 || this.f50874r || !this.f50875s) ? "id,state,versionId,cipher,properties,resource(encoding,compressedSize,downloadUrl,accelerateDownloadUrl,hash,id,length,type,sha256,objects(id,number,sha256,start,length,bucket,createdTime))" : "id,state,versionId,cipher,properties,resource(encoding,compressedSize,hash,id,length,type,sha256,objects(id,number,sha256,start,length,bucket,createdTime))", null, str, m64867Z());
        List<Resource.SliceObject> objects = assetMo64708P.getResource().getObjects();
        this.f50875s = (objects == null || objects.isEmpty()) ? false : true;
        Map<String, String> properties = assetMo64708P.getProperties();
        if (properties != null && !properties.isEmpty()) {
            this.f50849F = assetMo64708P.getProperties().get("migrate");
        }
        return assetMo64708P;
    }

    /* renamed from: Y */
    public final void m64866Y(Resource resource) {
        if (resource.getType().intValue() != 6) {
            return;
        }
        long jLongValue = resource.getLength() == null ? 0L : resource.getLength().longValue();
        this.f50878v = jLongValue;
        if (jLongValue > 0) {
            long j10 = this.f50855L;
            if (j10 <= 0 || j10 >= jLongValue) {
                return;
            }
            this.f50857N = j10 / jLongValue;
            C11839m.m70686d("CloudRestoreV3AssetDownloader", "initLengthRota: " + this.f50855L + " ,totalLength: " + this.f50878v + " ,sliceTotalLength: " + this.f50877u + ", " + this.f50864h.getName());
        }
    }

    /* renamed from: Z */
    public boolean m64867Z() {
        return this.f50860Q;
    }

    @Override // im.InterfaceC10551c0
    /* renamed from: a */
    public String mo64723a() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("file download error. file = ");
        File file = this.f50864h;
        sb2.append(file == null ? "" : file.getName());
        return sb2.toString();
    }

    /* renamed from: a0 */
    public final void m64868a0(List<C11312e> list, Resource resource) throws C9721b {
        C11839m.m70688i("CloudRestoreV3AssetDownloader", "merge slices start, path = " + this.f50864h.getName());
        if (this.f50864h.exists() && !this.f50864h.delete()) {
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "merge file error destFile exist and delete error");
        }
        ExecutorService executorServiceNewFixedThreadPool = Executors.newFixedThreadPool(16);
        ArrayList arrayList = new ArrayList();
        try {
            CountDownLatch countDownLatch = new CountDownLatch(list.size());
            Iterator<C11312e> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(executorServiceNewFixedThreadPool.submit(new d(it.next(), countDownLatch)));
            }
            m64718m(countDownLatch);
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                ((Future) it2.next()).cancel(false);
            }
            executorServiceNewFixedThreadPool.shutdown();
            C11839m.m70688i("CloudRestoreV3AssetDownloader", "merge slices end, path = " + this.f50864h.getName());
            HashMap map = new HashMap();
            if (m64856N(this.f50864h, resource.getHash(), resource.getSha256(), resource.getLength().longValue(), map)) {
                return;
            }
            String str = map.get("errMsg") != null ? map.get("errMsg") : "";
            this.f50859P = "102_1011";
            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_OPENED, "mergeFiles hash is not equal, need download again. delete file success = " + this.f50864h.delete() + " ," + str, "download");
        } catch (Throwable th2) {
            Iterator it3 = arrayList.iterator();
            while (it3.hasNext()) {
                ((Future) it3.next()).cancel(false);
            }
            executorServiceNewFixedThreadPool.shutdown();
            throw th2;
        }
    }

    @Override // im.InterfaceC10551c0
    /* renamed from: b */
    public boolean mo64724b() {
        return m64716k();
    }

    /* renamed from: b0 */
    public final void m64869b0(Asset asset, List<C11312e> list) throws C9721b {
        Resource resource = asset.getResource();
        Cipher cipher = asset.getCipher();
        int iIntValue = resource.getType().intValue();
        List<Long> listSynchronizedList = Collections.synchronizedList(new ArrayList());
        String hash = TextUtils.isEmpty(this.f50872p) ? resource.getHash() : this.f50872p;
        try {
            if (iIntValue == 0 || iIntValue == 3 || iIntValue == 6) {
                if (iIntValue == 0 && cipher == null) {
                    throw new C9721b(3911, "cipher is invalid.");
                }
                List<Resource.SliceObject> objects = resource.getObjects();
                if (objects == null || objects.isEmpty()) {
                    throw new C9721b(3911, "resource objects invalid");
                }
                Iterator<Resource.SliceObject> it = objects.iterator();
                long jLongValue = 0;
                while (it.hasNext()) {
                    jLongValue += it.next().getLength().longValue();
                }
                this.f50877u = jLongValue;
                this.f50878v = jLongValue;
                m64866Y(resource);
                m64881o0(c.INITIATION_COMPLETE);
                m64850H(hash, resource, list, listSynchronizedList, asset.getQuicSwitch());
            } else {
                long jLongValue2 = resource.getLength().longValue();
                this.f50877u = jLongValue2;
                this.f50878v = jLongValue2;
                m64881o0(c.INITIATION_COMPLETE);
                m64851I(hash, resource, list, listSynchronizedList);
            }
            C11315b.m67979c().m67984f(hash);
            C13735d.m82531s().m82535B(m64858Q(), listSynchronizedList, m64860S());
            m64870c0();
        } catch (Throwable th2) {
            C11315b.m67979c().m67984f(hash);
            C13735d.m82531s().m82535B(m64858Q(), listSynchronizedList, m64860S());
            m64870c0();
            throw th2;
        }
    }

    @Override // im.InterfaceC10551c0
    /* renamed from: c */
    public void mo64725c(int i10) {
        this.f50858O = i10;
    }

    /* renamed from: c0 */
    public final void m64870c0() {
        if (this.f50727a == null) {
            C11839m.m70686d("CloudRestoreV3AssetDownloader", "pause sleep no exception");
            return;
        }
        for (long j10 = 0; !m64716k() && j10 < RippleView.SINGLE_RIPPLE_TIME; j10 += 200) {
            try {
                C11839m.m70686d("CloudRestoreV3AssetDownloader", "pause sleep");
                SystemClock.sleep(200L);
            } catch (Exception e10) {
                C11839m.m70687e("CloudRestoreV3AssetDownloader", "pause sleep exception " + e10.getMessage());
                return;
            }
        }
    }

    @Override // im.AbstractC10548b
    /* renamed from: d */
    public void mo64709d() {
        if ("icon".equals(this.f50868l)) {
            return;
        }
        if (m64863V() > 1 || !C9731d.m60699d().m60703e("cloudBackupGlobalFileReuse")) {
            new C13998b0().m84119P0(this.f50866j, this.f50861R, "resourceScan");
        }
    }

    /* renamed from: d0 */
    public final void m64871d0(List<C11312e> list, String str) throws C9721b {
        Iterator<C11312e> it = list.iterator();
        while (it.hasNext()) {
            File fileM63441g = C10278a.m63441g(this.f50863g, it.next().m67964r());
            if (fileM63441g.exists()) {
                C11839m.m70686d("CloudRestoreV3AssetDownloader", "finally cache file exits, delete = " + fileM63441g.delete());
            }
        }
        this.f50882z.m67973a(str);
    }

    @Override // im.InterfaceC10551c0
    public void execute() throws C9721b {
        C11839m.m70688i("CloudRestoreV3AssetDownloader", "file download start. file = " + this.f50864h.getName() + " ,retrytime: " + this.f50858O);
        this.f50729c = C11058a.m66626a(this.f50866j, "download", C13452e.m80781L().m80971t0());
        this.f50846C = System.currentTimeMillis();
        Resource resourceM64849G = null;
        try {
            resourceM64849G = m64849G(null);
            this.f50844A = true;
            m64872f0(resourceM64849G);
            C11839m.m70688i("CloudRestoreV3AssetDownloader", "file download end. file = " + this.f50864h.getName());
        } catch (Throwable th2) {
            m64872f0(resourceM64849G);
            throw th2;
        }
    }

    /* renamed from: f0 */
    public void m64872f0(Resource resource) {
        String str;
        String str2;
        String str3;
        if (this.f50845B) {
            return;
        }
        if (this.f50874r) {
            str = this.f50869m;
        } else {
            str = this.f50871o + "_" + this.f50872p + "_" + this.f50873q;
        }
        if (!this.f50874r && resource != null) {
            str = str + "_" + resource.getId() + "_" + resource.getType();
        }
        if (this.f50844A) {
            str2 = str + " download success,NK_reqId:" + this.f50856M;
            str3 = "113_200";
        } else if (this.f50727a != null) {
            String str4 = "113_" + m64720o(this.f50727a);
            this.f50859P = str4;
            str3 = str4;
            str2 = str + " download failed. " + this.f50727a.getMessage() + ",NK_reqId:" + this.f50856M;
        } else {
            str2 = str + " download abort,NK_reqId:" + this.f50856M;
            str3 = "113_1001";
        }
        m64873g0(str3, str2);
    }

    /* renamed from: g0 */
    public void m64873g0(String str, String str2) {
        try {
            C11060c c11060cM66626a = C11058a.m66626a(this.f50866j, "download", C13452e.m80781L().m80971t0());
            c11060cM66626a.m66667w(this.f50729c.m66648d());
            c11060cM66626a.m66638D(this.f50865i);
            long jM64862U = m64862U();
            c11060cM66626a.m66640F(String.valueOf(jM64862U));
            c11060cM66626a.m66642H(String.valueOf(System.currentTimeMillis() - this.f50846C));
            c11060cM66626a.m66665u(str);
            c11060cM66626a.m66635A(str2);
            HashMap map = new HashMap();
            String str3 = this.f50849F;
            if (str3 != null && !str3.isEmpty()) {
                map.put("migrate", this.f50849F);
            }
            map.put("userType", C13452e.m80781L().m80987x0());
            map.put("gradeCode", C12590s0.m75747G0());
            map.put("isAutoFix", String.valueOf(m64867Z()));
            map.put("accelerate", this.f50851H.get() ? "1" : "0");
            map.put(C5927g2.QUIC, this.f50852I.get() ? "1" : "0");
            map.put("protocol", this.f50853J.get());
            C11312e c11312e = this.f50854K;
            if (c11312e != null) {
                map.put("objectId", c11312e.m67964r());
                map.put("bucket", this.f50854K.m67956b());
                map.put("createdTime", this.f50854K.m67957e());
            }
            C12604x.m76063b(this.f50866j, jM64862U);
            C13622a.m81969o(C0213f.m1377a(), c11060cM66626a, map);
        } catch (Exception e10) {
            C11839m.m70687e("CloudRestoreV3AssetDownloader", "reportResult error: " + e10.getMessage());
        }
    }

    /* renamed from: h0 */
    public void m64874h0(boolean z10) {
        this.f50860Q = z10;
    }

    @Override // im.AbstractC10548b
    /* renamed from: i */
    public RequestConfig.RequestConfBuilder mo64714i() throws JSONException {
        RequestConfig.RequestConfBuilder requestConfBuilderMo64714i = super.mo64714i();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("complete_file_size", this.f50877u);
            requestConfBuilderMo64714i.options(jSONObject.toString());
        } catch (Exception e10) {
            C11839m.m70687e("CloudRestoreV3AssetDownloader", "getRequestConfBuilder error " + e10.getMessage());
        }
        return requestConfBuilderMo64714i;
    }

    /* renamed from: i0 */
    public AbstractC10571u m64875i0(InterfaceC10562l interfaceC10562l) {
        this.f50881y = interfaceC10562l;
        return this;
    }

    /* renamed from: j0 */
    public AbstractC10571u m64876j0(String str) {
        this.f50861R = str;
        return this;
    }

    /* renamed from: k0 */
    public AbstractC10571u m64877k0(boolean z10) {
        this.f50850G = z10;
        return this;
    }

    /* renamed from: l0 */
    public final C9721b m64878l0(ErrorResp.Error error, C9721b c9721b) {
        List<ErrorResp.ErrorMsg> errorDetail;
        if (error == null || (errorDetail = error.getErrorDetail()) == null || errorDetail.isEmpty()) {
            return c9721b;
        }
        ErrorResp.ErrorMsg errorMsg = errorDetail.get(0);
        String errorCode = errorMsg.getErrorCode();
        if (error.getCode().intValue() != 404 || !errorCode.endsWith(String.valueOf(4041))) {
            return c9721b;
        }
        return new C9721b(3922, 4041, "server source not exist." + errorMsg.getDescription());
    }

    /* renamed from: m0 */
    public final void m64879m0() throws C9721b {
        C11839m.m70686d("CloudRestoreV3AssetDownloader", "unzipFile start:" + this.f50864h.getName());
        String strM63452a = C10279b.m63452a(this.f50864h);
        String str = this.f50864h.getParentFile() + File.separator + C11476b.m68626h(strM63452a);
        if (!C11835i.m70656t(strM63452a, str)) {
            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_OPENED, "rename file error:" + this.f50864h.getName(), "unzip");
        }
        int iM25925c = HoleUtil.m25925c(str, strM63452a);
        C11839m.m70686d("CloudRestoreV3AssetDownloader", "unzipFile end:" + this.f50864h.getName());
        if (iM25925c == 0) {
            C11835i.m70643g(str);
        }
    }

    /* renamed from: n0 */
    public final void m64880n0(String str, long j10) {
        synchronized (f50842S) {
            this.f50879w.put(str, Long.valueOf(j10));
            m64881o0(c.MEDIA_IN_PROGRESS);
        }
    }

    /* renamed from: o0 */
    public final void m64881o0(c cVar) {
        this.f50880x = cVar;
        InterfaceC10562l interfaceC10562l = this.f50881y;
        if (interfaceC10562l != null) {
            interfaceC10562l.mo57819a(this);
        }
    }

    public AbstractC10571u(String str, String str2, AbstractC1455a abstractC1455a, String str3, String str4, String str5, String str6, String str7, String str8, int i10) {
        this.f50866j = str2;
        this.f50867k = abstractC1455a;
        if (C9733f.m60705z().m60719N()) {
            this.f50865i = m64833e0(str3);
        } else {
            this.f50865i = str3;
        }
        this.f50864h = C10278a.m63442h(this.f50865i);
        this.f50868l = str4;
        this.f50870n = str5;
        this.f50871o = str6;
        this.f50872p = str7;
        this.f50873q = str8;
        this.f50874r = false;
        this.f50863g = C11835i.m70646j(C0213f.m1377a());
        this.f50848E = i10;
        this.f50862f = str;
    }
}
