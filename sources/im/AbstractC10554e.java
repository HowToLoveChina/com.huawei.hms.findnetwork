package im;

import cm.C1457c;
import com.huawei.android.hicloud.cloudbackup.report.MobileTrafficReport;
import com.huawei.cloud.base.util.C4644l;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.Asset;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.Cipher;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.Resource;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.RevisionRefresh;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hms.network.embedded.C5927g2;
import com.huawei.hms.network.file.api.Progress;
import com.huawei.hms.network.file.api.Response;
import com.huawei.hms.network.file.api.exception.NetworkException;
import com.huawei.hms.network.file.upload.api.BodyRequest;
import com.huawei.hms.network.file.upload.api.FileUploadCallback;
import fk.C9721b;
import hk.C10278a;
import hk.C10279b;
import hm.C10321z;
import im.AbstractC10554e;
import java.io.Closeable;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BiConsumer;
import java.util.function.ToLongFunction;
import p015ak.C0213f;
import p292fn.C9733f;
import p429kk.C11058a;
import p429kk.C11060c;
import p455ll.C11308a;
import p455ll.C11310c;
import p514o9.C11835i;
import p514o9.C11839m;
import p618rm.C12590s0;
import p618rm.C12604x;
import p652t9.EnumC12999a;
import p684un.C13230i;
import p709vj.C13452e;
import p712vm.C13468a;
import p746wn.C13622a;
import p767x9.C13735d;
import p815ym.AbstractC14026a;

/* renamed from: im.e */
/* loaded from: classes6.dex */
public abstract class AbstractC10554e extends AbstractC10548b {

    /* renamed from: H */
    public static final Object f50731H = new Object();

    /* renamed from: B */
    public InterfaceC10570t f50733B;

    /* renamed from: G */
    public long f50738G;

    /* renamed from: f */
    public C10321z f50739f;

    /* renamed from: g */
    public C1457c f50740g;

    /* renamed from: h */
    public String f50741h;

    /* renamed from: i */
    public int f50742i;

    /* renamed from: j */
    public String f50743j;

    /* renamed from: k */
    public String f50744k;

    /* renamed from: l */
    public C11308a f50745l;

    /* renamed from: m */
    public String f50746m;

    /* renamed from: n */
    public String f50747n;

    /* renamed from: o */
    public String f50748o;

    /* renamed from: q */
    public long f50750q;

    /* renamed from: r */
    public long f50751r;

    /* renamed from: v */
    public Cipher f50755v;

    /* renamed from: s */
    public boolean f50752s = false;

    /* renamed from: t */
    public Map<String, Long> f50753t = new HashMap();

    /* renamed from: u */
    public List<C11310c> f50754u = new ArrayList();

    /* renamed from: w */
    public boolean f50756w = false;

    /* renamed from: x */
    public boolean f50757x = false;

    /* renamed from: y */
    public boolean f50758y = false;

    /* renamed from: z */
    public int f50759z = 0;

    /* renamed from: A */
    public boolean f50732A = false;

    /* renamed from: C */
    public c f50734C = c.NOT_STARTED;

    /* renamed from: D */
    public AtomicBoolean f50735D = new AtomicBoolean(false);

    /* renamed from: E */
    public AtomicBoolean f50736E = new AtomicBoolean(false);

    /* renamed from: F */
    public AtomicReference<String> f50737F = new AtomicReference<>("");

    /* renamed from: p */
    public File f50749p = C11835i.m70646j(C0213f.m1377a());

    /* renamed from: im.e$a */
    public static /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f50760a;

        static {
            int[] iArr = new int[c.values().length];
            f50760a = iArr;
            try {
                iArr[c.MEDIA_IN_PROGRESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f50760a[c.MEDIA_COMPLETE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* renamed from: im.e$b */
    public class b extends FileUploadCallback {

        /* renamed from: a */
        public C11310c f50761a;

        /* renamed from: b */
        public CountDownLatch f50762b;

        /* renamed from: c */
        public RevisionRefresh f50763c;

        /* renamed from: d */
        public long f50764d = 0;

        /* renamed from: e */
        public final long f50765e;

        public b(C11310c c11310c, RevisionRefresh revisionRefresh, CountDownLatch countDownLatch, long j10) {
            this.f50761a = c11310c;
            this.f50763c = revisionRefresh;
            this.f50762b = countDownLatch;
            this.f50765e = j10;
        }

        /* renamed from: b */
        public static /* synthetic */ void m64749b(Map map, String str, List list) {
            if (AbstractC14026a.m84159a(list)) {
                return;
            }
            map.put(str, (String) list.get(0));
        }

        /* renamed from: f */
        private void m64750f() {
            CountDownLatch countDownLatch = this.f50762b;
            if (countDownLatch == null) {
                C11839m.m70689w("CloudBackupV3AssetBaseUploader", "release downLatch is null");
                return;
            }
            countDownLatch.countDown();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("release: ");
            C11310c c11310c = this.f50761a;
            sb2.append(c11310c != null ? c11310c.m67928q() : "");
            C11839m.m70688i("CloudBackupV3AssetBaseUploader", sb2.toString());
        }

        @Override // com.huawei.hms.network.file.api.Callback
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onException(BodyRequest bodyRequest, NetworkException networkException, Response<BodyRequest, String, Closeable> response) {
            C9721b c9721b;
            AbstractC10554e.this.f50738G = bodyRequest.getId();
            C11839m.m70686d("CloudBackupV3AssetBaseUploader", "taskId  [" + AbstractC10554e.this.f50738G + "] onException.");
            C13468a c13468aM81100c = C13468a.m81100c();
            boolean zM81101b = c13468aM81100c.m81101b();
            AbstractC10554e.this.m64717l(bodyRequest.getUrl());
            if (zM81101b) {
                c9721b = AbstractC10554e.this.m64719n(networkException, response != null ? (com.huawei.hms.network.httpclient.Response) response.getRawResponse() : null, "Upload");
            } else {
                c9721b = new C9721b(3900, c13468aM81100c.toString(), "Upload");
            }
            C11839m.m70687e("CloudBackupV3AssetBaseUploader", "taskId [" + AbstractC10554e.this.f50738G + "]slice object [" + this.f50761a.m67928q() + "] upload error." + c9721b.toString());
            if (c9721b.toString().contains("SignatureDoesNotMatch")) {
                C11839m.m70688i("CloudBackupV3AssetBaseUploader", "SignatureDoesNotMatch,call abnormal()");
                try {
                    AbstractC10554e.this.mo64709d();
                } catch (C9721b unused) {
                    C11839m.m70687e("CloudBackupV3AssetBaseUploader", "call abnormal() error.");
                }
            }
            AbstractC10554e.this.m64712g(c9721b);
            m64750f();
        }

        @Override // com.huawei.hms.network.file.api.Callback
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void onProgress(BodyRequest bodyRequest, Progress progress) {
            synchronized (AbstractC10554e.f50731H) {
                C11839m.m70686d("CloudBackupV3AssetBaseUploader", "taskId [" + bodyRequest.getId() + "]slice object [" + this.f50761a.m67928q() + "] upload progress = " + progress.getProgress() + "size = " + progress.getFinishedSize());
                AbstractC10554e.this.f50753t.put(this.f50761a.m67928q(), Long.valueOf(progress.getFinishedSize()));
                AbstractC10554e.this.m64740J(c.MEDIA_IN_PROGRESS);
            }
        }

        @Override // com.huawei.hms.network.file.api.Callback
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public BodyRequest onStart(BodyRequest bodyRequest) throws C9721b {
            Resource.EndpointURL uploadUrl;
            C11839m.m70688i("CloudBackupV3AssetBaseUploader", "taskId [" + bodyRequest.getId() + "]slice object [" + this.f50761a.m67928q() + "] get upload address.");
            this.f50764d = System.currentTimeMillis();
            if (System.currentTimeMillis() - this.f50765e >= 900000) {
                try {
                    AbstractC10554e.this.m64715j();
                    AbstractC10554e abstractC10554e = AbstractC10554e.this;
                    Asset assetM64736F = abstractC10554e.m64736F("id,versionId,state,resource(id,state,objects(id,sha256,uploadUrl,accelerateUploadUrl))", abstractC10554e.f50747n, abstractC10554e.f50745l.m67895m(), AbstractC10554e.this.f50745l.m67883a(), AbstractC10554e.this.f50745l.m67898p(), Collections.singletonList(this.f50761a.m67928q()), this.f50763c);
                    AbstractC10554e.this.m64715j();
                    Iterator<Resource.SliceObject> it = assetM64736F.getResource().getObjects().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            uploadUrl = null;
                            break;
                        }
                        Resource.SliceObject next = it.next();
                        if (this.f50761a.m67928q().equals(next.getId())) {
                            uploadUrl = AbstractC10554e.this.f50757x ? next.getUploadUrl() : next.getAccelerateUploadUrl();
                            if (uploadUrl == null) {
                                uploadUrl = next.getUploadUrl();
                            }
                        }
                    }
                } catch (C9721b e10) {
                    C11839m.m70687e("CloudBackupV3AssetBaseUploader", "taskId [" + bodyRequest.getId() + "]slice object [" + this.f50761a.m67928q() + "] get upload address error.");
                    AbstractC10554e.this.m64712g(e10);
                }
                if (uploadUrl == null) {
                    throw new C9721b(3911, "refresh url error. objectId = " + this.f50761a.m67928q(), "Upload");
                }
                String url = uploadUrl.getUrl();
                AbstractC10554e.this.m64717l(url);
                bodyRequest = (BodyRequest) bodyRequest.newBuilder().url(url).backupUrls(Collections.singletonList(url)).headers(uploadUrl.getHeaders()).build();
                C11839m.m70686d("CloudBackupV3AssetBaseUploader", "taskId [" + bodyRequest.getId() + "] start end");
            }
            return bodyRequest;
        }

        /* renamed from: g */
        public final synchronized void m64754g(long j10) {
            AbstractC10554e.this.f50751r += j10;
        }

        @Override // com.huawei.hms.network.file.api.Callback
        public void onSuccess(Response<BodyRequest, String, Closeable> response) {
            try {
                try {
                    AbstractC10554e.this.m64715j();
                } catch (C9721b e10) {
                    if (response != null && response.getRequest() != null) {
                        C11839m.m70687e("CloudBackupV3AssetBaseUploader", "taskId [" + AbstractC10554e.this.f50738G + "]slice object [" + this.f50761a.m67928q() + "] upload end error.");
                    }
                    AbstractC10554e.this.m64712g(e10);
                }
                if (response == null || response.getRequest() == null || response.getRawResponse() == null) {
                    throw new C9721b(3911, "taskId [null]slice object [" + this.f50761a.m67928q() + "] response is null.", "Upload");
                }
                String str = response.getExtraInfo().get("protocol_impl") + "-" + response.getExtraInfo().get("protocol");
                C11839m.m70686d("CloudBackupV3AssetBaseUploader", "protocol: " + str);
                C10556f.m64761a(AbstractC10554e.this.f50737F, "", str);
                AbstractC10554e.this.f50738G = ((BodyRequest) response.getRequest()).getId();
                C11839m.m70688i("CloudBackupV3AssetBaseUploader", "taskId [" + AbstractC10554e.this.f50738G + "]slice object [" + this.f50761a.m67928q() + "] upload end.");
                com.huawei.hms.network.httpclient.Response response2 = (com.huawei.hms.network.httpclient.Response) response.getRawResponse();
                RevisionRefresh.UploadStatus uploadStatus = new RevisionRefresh.UploadStatus();
                uploadStatus.setStatus(Integer.valueOf(response2.getCode()));
                uploadStatus.setBody(response2.getMessage());
                if (C9733f.m60705z().m60730Y(2)) {
                    Map<String, List<String>> responseHeader = response.getResponseHeader();
                    final HashMap map = new HashMap(8);
                    responseHeader.forEach(new BiConsumer() { // from class: im.g
                        @Override // java.util.function.BiConsumer
                        public final void accept(Object obj, Object obj2) {
                            AbstractC10554e.b.m64749b(map, (String) obj, (List) obj2);
                        }
                    });
                    uploadStatus.setHeaders(map);
                }
                RevisionRefresh.SpeedInfo speedInfo = new RevisionRefresh.SpeedInfo();
                speedInfo.setTimeTotal(Double.valueOf(System.currentTimeMillis() - this.f50764d));
                this.f50763c.getResource().getObjects().get(0).setUploadStatus(uploadStatus).setSpeed(speedInfo);
                AbstractC10554e.this.m64715j();
                AbstractC10554e abstractC10554e = AbstractC10554e.this;
                abstractC10554e.m64736F("id,versionId,createdTime,modifiedTime,resource(id,state)", abstractC10554e.f50747n, abstractC10554e.f50745l.m67895m(), AbstractC10554e.this.f50745l.m67883a(), AbstractC10554e.this.f50745l.m67898p(), null, this.f50763c);
                AbstractC10554e.this.mo64739I(this.f50761a.m67926k(), this.f50761a.m67928q());
                m64754g(this.f50761a.m67927p());
                m64750f();
            } catch (Throwable th2) {
                m64750f();
                throw th2;
            }
        }
    }

    /* renamed from: im.e$c */
    public enum c {
        NOT_STARTED,
        INITIATION_STARTED,
        INITIATION_COMPLETE,
        MEDIA_IN_PROGRESS,
        MEDIA_COMPLETE
    }

    public AbstractC10554e(String str, String str2, C10321z c10321z, C1457c c1457c, String str3, String str4, String str5) {
        this.f50741h = str;
        this.f50746m = str2;
        this.f50740g = c1457c;
        this.f50747n = str3;
        this.f50739f = c10321z;
        this.f50748o = str4;
        this.f50743j = str5;
    }

    /* renamed from: A */
    public EnumC12999a m64733A(Asset asset, AtomicBoolean atomicBoolean) {
        boolean zEquals = "1".equals(asset.getQuicSwitch());
        atomicBoolean.compareAndSet(false, zEquals);
        return zEquals ? EnumC12999a.CLOUD_BACKUP_QUIC : EnumC12999a.CLOUD_BACKUP;
    }

    /* renamed from: B */
    public boolean m64734B(C11308a c11308a) {
        String strM67884b = c11308a.m67884b();
        if (strM67884b.isEmpty()) {
            return true;
        }
        return System.currentTimeMillis() - new C4644l(strM67884b).m28458c() < 597600000;
    }

    /* renamed from: E */
    public Asset m64735E(String str, String str2, String str3, String str4, String str5, String str6, RevisionRefresh revisionRefresh, int i10, boolean z10) throws C9721b {
        try {
            return this.f50739f.m63583y0(this.f50740g, str, str2, str3, str4, str5, str6, revisionRefresh, i10, this.f50741h, this.f50742i, this.f50744k, z10, 0);
        } catch (C9721b e10) {
            if (e10.m60659c() == 3922) {
                mo64709d();
            }
            throw e10;
        }
    }

    /* renamed from: F */
    public Asset m64736F(String str, String str2, String str3, String str4, String str5, List<String> list, RevisionRefresh revisionRefresh) throws C9721b {
        try {
            return this.f50739f.m63585z0(this.f50740g, str, this.f50748o, str2, str3, str4, str5, revisionRefresh, this.f50741h, this.f50742i, this.f50744k, list, 0);
        } catch (C9721b e10) {
            if (e10.m60659c() == 3922) {
                mo64709d();
            }
            throw e10;
        }
    }

    /* renamed from: G */
    public void m64737G(boolean z10, long j10, Resource resource, String str, long j11, int i10) {
        String str2;
        String str3;
        long j12;
        HashMap map;
        String strM64745x;
        try {
            if (this.f50729c == null) {
                C11839m.m70689w("CloudBackupV3AssetBaseUploader", "reportResult mStat is null");
                this.f50729c = C11058a.m66626a(this.f50746m, "upload", C13452e.m80781L().m80971t0());
            }
            C11308a c11308a = this.f50745l;
            String strM67889g = c11308a == null ? "" : c11308a.m67889g();
            str3 = "file = " + str + " fid = " + strM67889g + " length = " + j11;
            this.f50729c.m66663s(this.f50741h);
            LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
            try {
                if (m64716k()) {
                    this.f50729c.m66665u("113_1001");
                    this.f50729c.m66638D(str3);
                    this.f50729c.m66641G(String.valueOf(m64746y()));
                    String str4 = "upload abort,retryTime:" + i10 + ",NK_reqId:" + this.f50738G;
                    this.f50729c.m66635A(str4);
                    linkedHashMapM79497A.put("uploadResult", str4);
                    j12 = 0;
                } else if (!z10) {
                    C11060c c11060c = this.f50729c;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("113_");
                    C9721b c9721b = this.f50727a;
                    sb2.append(c9721b == null ? 4314 : m64720o(c9721b));
                    c11060c.m66665u(sb2.toString());
                    StringBuilder sb3 = new StringBuilder();
                    C11308a c11308a2 = this.f50745l;
                    if (c11308a2 != null) {
                        sb3.append(c11308a2.m67883a());
                        sb3.append("_");
                        sb3.append(this.f50745l.m67895m());
                        sb3.append("_");
                        sb3.append(this.f50745l.m67898p());
                    }
                    this.f50729c.m66638D(str3);
                    long jM64746y = m64746y();
                    this.f50729c.m66641G(String.valueOf(jM64746y));
                    C11060c c11060c2 = this.f50729c;
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("upload failed ");
                    sb4.append((Object) sb3);
                    sb4.append(" , ");
                    C9721b c9721b2 = this.f50727a;
                    sb4.append(c9721b2 == null ? "" : c9721b2.getMessage());
                    sb4.append(" retryTime:");
                    sb4.append(i10);
                    sb4.append(",NK_reqId:");
                    sb4.append(this.f50738G);
                    c11060c2.m66635A(sb4.toString());
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("upload failed,errorMsg:");
                    C9721b c9721b3 = this.f50727a;
                    sb5.append(c9721b3 == null ? "" : c9721b3.getMessage());
                    linkedHashMapM79497A.put("uploadResult", sb5.toString());
                    j12 = jM64746y;
                } else {
                    if (this.f50756w) {
                        return;
                    }
                    this.f50729c.m66665u("113_200");
                    String str5 = "upload success,retryTime:" + i10 + ",NK_reqId:" + this.f50738G;
                    this.f50729c.m66635A(str5);
                    String str6 = "file = " + str + " fid = " + strM67889g + " length = " + j11 + " recordId = " + this.f50745l.m67895m() + "assetId" + this.f50745l.m67883a() + " versionId = " + this.f50745l.m67898p();
                    if (resource != null && resource.getId() != null && resource.getType() != null) {
                        str6 = str6 + " resourceId = " + resource.getId() + " resourceType = " + resource.getType().toString();
                    }
                    str3 = str6;
                    if (this.f50732A) {
                        this.f50729c.m66638D(str3 + " hashInvalid = " + this.f50732A);
                    } else {
                        this.f50729c.m66638D(str3);
                    }
                    this.f50729c.m66641G(String.valueOf(j11));
                    this.f50729c.m66642H(String.valueOf(System.currentTimeMillis() - j10));
                    linkedHashMapM79497A.put("uploadResult", str5);
                    j12 = j11;
                }
                map = new HashMap();
                linkedHashMapM79497A.put("resourcePath", str3);
                linkedHashMapM79497A.put("bakCategory", String.valueOf(this.f50739f.m63559V()));
                if (this.f50739f.m63560W() != null) {
                    linkedHashMapM79497A.put("occupySpaceType", String.valueOf(this.f50739f.m63560W()));
                    map.put("occupySpaceType", String.valueOf(this.f50739f.m63560W()));
                }
                strM64745x = m64745x();
                linkedHashMapM79497A.put("fileCreateTime", strM64745x);
                linkedHashMapM79497A.put("retryTime", String.valueOf(i10));
                UBAAnalyze.m29947H("CKC", "action_file_uploader_result", linkedHashMapM79497A);
                if (this.f50745l != null) {
                    MobileTrafficReport.getInstance().addDownloadSize(j11);
                }
                C12604x.m76063b(this.f50746m, j12);
                map.put("accelerate", this.f50735D.get() ? "1" : "0");
                map.put(C5927g2.QUIC, this.f50736E.get() ? "1" : "0");
                map.put("bakCategory", String.valueOf(this.f50739f.m63559V()));
                map.put("protocol", this.f50737F.get());
                map.put("gradeCode", C12590s0.m75747G0());
                str2 = "CloudBackupV3AssetBaseUploader";
            } catch (Exception e10) {
                e = e10;
                str2 = "CloudBackupV3AssetBaseUploader";
            }
        } catch (Exception e11) {
            e = e11;
            str2 = "CloudBackupV3AssetBaseUploader";
        }
        try {
            C11839m.m70688i(str2, "begin to reportEvent,resourcePath:" + str3 + ",retryTime:" + i10 + ",fileCreateTime:" + strM64745x);
            C13622a.m81969o(C0213f.m1377a(), this.f50729c, map);
        } catch (Exception e12) {
            e = e12;
            C11839m.m70689w(str2, "reportResult error: " + e.getMessage());
        }
    }

    /* renamed from: H */
    public abstract void mo64738H(int i10) throws C9721b;

    /* renamed from: I */
    public abstract void mo64739I(String str, String str2) throws C9721b;

    /* renamed from: J */
    public void m64740J(c cVar) {
        this.f50734C = cVar;
        InterfaceC10570t interfaceC10570t = this.f50733B;
        if (interfaceC10570t != null) {
            interfaceC10570t.mo57738a(this);
        }
    }

    /* renamed from: K */
    public Resource m64741K() throws C9721b {
        Asset assetM64736F = m64736F("id,versionId,state,resource(id,state)", this.f50747n, this.f50745l.m67895m(), this.f50745l.m67883a(), this.f50745l.m67898p(), null, new RevisionRefresh());
        m64715j();
        Resource resource = assetM64736F.getResource();
        if (resource == null) {
            throw new C9721b(3911, "asset resource is empty", "Backup.asset.revisions.refresh");
        }
        if (resource.getState().intValue() == 0) {
            for (C11310c c11310c : this.f50754u) {
                mo64739I(c11310c.m67926k(), c11310c.m67928q());
                c11310c.m67918D(1);
            }
            mo64738H(1);
        }
        if (assetM64736F.getState().intValue() == 0) {
            mo64738H(2);
        }
        return resource;
    }

    /* renamed from: u */
    public void m64742u(EnumC12999a enumC12999a, List<Long> list) {
        if (AbstractC14026a.m84159a(list)) {
            return;
        }
        C13735d.m82531s().m82538h(enumC12999a, list);
    }

    /* renamed from: v */
    public void m64743v(List<C11310c> list) {
        Iterator<C11310c> it = list.iterator();
        while (it.hasNext()) {
            File fileM63441g = C10278a.m63441g(this.f50749p, it.next().m67928q());
            if (fileM63441g.exists()) {
                C11839m.m70686d("CloudBackupV3AssetBaseUploader", "delete cache file result = " + fileM63441g.delete() + " path: " + C10279b.m63452a(fileM63441g));
            }
        }
    }

    /* renamed from: w */
    public abstract void mo64744w() throws C9721b;

    /* renamed from: x */
    public String m64745x() {
        C11308a c11308a = this.f50745l;
        if (c11308a == null) {
            C11839m.m70687e("CloudBackupV3AssetBaseUploader", "status is null");
            return "status is null";
        }
        try {
            return c11308a.m67884b();
        } catch (Exception e10) {
            C11839m.m70687e("CloudBackupV3AssetBaseUploader", "getFileCreateTime error:" + e10.getMessage());
            return "getFileCreateTime error";
        }
    }

    /* renamed from: y */
    public long m64746y() {
        int i10 = a.f50760a[this.f50734C.ordinal()];
        if (i10 == 1) {
            return this.f50753t.values().stream().mapToLong(new ToLongFunction() { // from class: im.c
                @Override // java.util.function.ToLongFunction
                public final long applyAsLong(Object obj) {
                    return ((Long) obj).longValue();
                }
            }).sum();
        }
        if (i10 != 2) {
            return 0L;
        }
        return this.f50753t.isEmpty() ? this.f50750q : this.f50753t.values().stream().mapToLong(new ToLongFunction() { // from class: im.d
            @Override // java.util.function.ToLongFunction
            public final long applyAsLong(Object obj) {
                return ((Long) obj).longValue();
            }
        }).sum();
    }

    /* renamed from: z */
    public int m64747z() {
        int i10 = a.f50760a[this.f50734C.ordinal()];
        if (i10 != 1) {
            return i10 != 2 ? 0 : 100;
        }
        if (this.f50750q <= 0) {
            return 0;
        }
        return (int) Math.floor((m64746y() / this.f50750q) * 100.0d);
    }
}
