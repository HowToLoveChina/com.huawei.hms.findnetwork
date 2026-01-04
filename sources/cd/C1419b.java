package cd;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.huawei.android.hicloud.complexutil.C2785f;
import com.huawei.android.hicloud.sync.contact.SyncProcessBase;
import com.huawei.android.hicloud.sync.protocol.C2934m;
import com.huawei.android.hicloud.syncdrive.cloudsync.model.Asset;
import com.huawei.android.hicloud.syncdrive.cloudsync.model.Resource;
import com.huawei.android.hicloud.syncdrive.util.DriveSyncUtil;
import com.huawei.cloud.base.http.C4602e;
import com.huawei.hicloud.base.drive.model.EndpointUrl;
import com.huawei.hms.network.file.api.Progress;
import com.huawei.hms.network.file.api.Request;
import com.huawei.hms.network.file.api.Response;
import com.huawei.hms.network.file.api.exception.NetworkException;
import com.huawei.hms.network.file.api.exception.UnKnownErrorException;
import com.huawei.hms.network.file.download.api.DownloadManager;
import com.huawei.hms.network.file.download.api.FileRequestCallback;
import com.huawei.hms.network.file.download.api.GetRequest;
import com.huawei.secure.android.common.util.SafeString;
import fk.C9721b;
import fk.C9722c;
import gd.C9905a;
import hk.C10278a;
import java.io.Closeable;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import je.C10812z;
import mu.C11526c;
import p015ak.C0209d;
import p015ak.C0213f;
import p225dd.C9065a;
import p225dd.C9072h;
import p225dd.EnumC9073i;
import p429kk.C11060c;
import p514o9.C11839m;
import p572qb.C12313i;
import p652t9.EnumC12999a;
import p733w9.C13576a;
import p767x9.C13735d;
import p783xp.C13843a;
import vc.C13404h;

/* renamed from: cd.b */
/* loaded from: classes3.dex */
public class C1419b {

    /* renamed from: v */
    public static final Object f6099v = new Object();

    /* renamed from: w */
    public static final Object f6100w = new Object();

    /* renamed from: a */
    public C9072h.b f6101a;

    /* renamed from: f */
    public C9721b f6106f;

    /* renamed from: g */
    public Asset f6107g;

    /* renamed from: j */
    public C4602e f6110j;

    /* renamed from: k */
    public String f6111k;

    /* renamed from: l */
    public String f6112l;

    /* renamed from: m */
    public String f6113m;

    /* renamed from: n */
    public String f6114n;

    /* renamed from: o */
    public String f6115o;

    /* renamed from: p */
    public EnumC12999a f6116p;

    /* renamed from: q */
    public String f6117q;

    /* renamed from: r */
    public String f6118r;

    /* renamed from: t */
    public String f6120t;

    /* renamed from: u */
    public Map<String, String> f6121u;

    /* renamed from: b */
    public List<C9072h.b> f6102b = new ArrayList();

    /* renamed from: c */
    public List<Long> f6103c = new ArrayList();

    /* renamed from: e */
    public File f6105e = DriveSyncUtil.m18013w();

    /* renamed from: h */
    public int f6108h = 0;

    /* renamed from: i */
    public long f6109i = 0;

    /* renamed from: s */
    public long f6119s = 0;

    /* renamed from: d */
    public SQLiteDatabase f6104d = C9065a.m57166a();

    /* renamed from: cd.b$a */
    public class a extends FileRequestCallback {

        /* renamed from: a */
        public C9072h.b f6122a;

        /* renamed from: b */
        public CountDownLatch f6123b;

        /* renamed from: c */
        public boolean f6124c;

        /* renamed from: d */
        public int f6125d = 0;

        /* renamed from: e */
        public EndpointUrl f6126e;

        /* renamed from: f */
        public final C2934m f6127f;

        /* renamed from: g */
        public C11060c f6128g;

        public a(C11060c c11060c, C9072h.b bVar, CountDownLatch countDownLatch, C2934m c2934m, boolean z10) {
            this.f6128g = c11060c;
            this.f6122a = bVar;
            this.f6123b = countDownLatch;
            this.f6124c = z10;
            this.f6127f = c2934m;
        }

        private void release() {
            CountDownLatch countDownLatch = this.f6123b;
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
        }

        @Override // com.huawei.hms.network.file.api.Callback
        public /* bridge */ /* synthetic */ void onException(Request request, NetworkException networkException, Response response) throws C9721b {
            onException((GetRequest) request, networkException, (Response<GetRequest, File, Closeable>) response);
        }

        @Override // com.huawei.hms.network.file.api.Callback
        public void onSuccess(Response<GetRequest, File, Closeable> response) {
            try {
                try {
                    C11839m.m70688i("SyncAssetDownloadFile", "syncV2 onSuccess taskId [" + ((GetRequest) response.getRequest()).getId() + "]file object [" + this.f6122a.m57284z() + "] download end.");
                    C1419b.this.m8225z(this.f6127f);
                    int iM57270A = this.f6122a.m57270A();
                    EnumC9073i enumC9073i = EnumC9073i.SUCCESS;
                    if (iM57270A != enumC9073i.m57285b()) {
                        this.f6122a.m57278I(enumC9073i.m57285b()).m57281w().m57247c(C1419b.this.f6104d);
                        C11839m.m70688i("SyncAssetDownloadFile", "syncV2 taskId [" + ((GetRequest) response.getRequest()).getId() + "]file object [" + this.f6122a.m57284z() + "] cache [" + this.f6122a.m57272C() + "] download success");
                    }
                    C1419b c1419b = C1419b.this;
                    c1419b.f6109i = c1419b.f6119s;
                    this.f6127f.mo17784f(C1419b.this.f6109i);
                    this.f6127f.mo17783e(false);
                } catch (C9721b e10) {
                    C11839m.m70687e("SyncAssetDownloadFile", "syncV2 taskId [" + ((GetRequest) response.getRequest()).getId() + "] file object [" + this.f6122a.m57284z() + "] download decrypt error: " + e10);
                    C1419b.this.m8222w(e10);
                }
                release();
            } catch (Throwable th2) {
                release();
                throw th2;
            }
        }

        public void onException(GetRequest getRequest, NetworkException networkException, Response<GetRequest, File, Closeable> response) throws C9721b {
            Object obj;
            C11839m.m70687e("SyncAssetDownloadFile", "syncV2 onException taskId [" + getRequest.getId() + "]file object [" + this.f6122a.m57284z() + "] download error. ");
            int iM1331z = C0209d.m1331z(networkException.getMessage());
            if (this.f6124c && this.f6125d <= 1 && (iM1331z == 403 || (networkException instanceof UnKnownErrorException))) {
                C11839m.m70688i("SyncAssetDownloadFile", "syncV2 taskId [" + getRequest.getId() + "]file object [" + this.f6122a.m57284z() + "] cache [" + this.f6122a.m57272C() + "retry again");
                try {
                    C1419b.this.m8225z(this.f6127f);
                    EndpointUrl endpointUrl = this.f6126e;
                    C1419b.this.m8224y((endpointUrl == null || (obj = endpointUrl.get("client_endpointVersion")) == null) ? 0 : ((Integer) obj).intValue());
                    a aVar = C1419b.this.new a(this.f6128g, this.f6122a, this.f6123b, this.f6127f, false);
                    EndpointUrl downloadUrl = C1419b.this.f6107g.getResource().getDownloadUrl();
                    if (downloadUrl == null) {
                        throw new C9721b(2214, this.f6122a.m57284z() + " has no endpointUrl", C1419b.this.f6120t);
                    }
                    C11839m.m70686d("SyncAssetDownloadFile", "syncV2  onException downloadRequestBuilder filePath :" + this.f6122a.m57283y());
                    C1419b.this.f6103c.add(Long.valueOf(C13735d.m82531s().m82541k(C1419b.this.f6116p, DownloadManager.newGetRequestBuilder().filePath(this.f6122a.m57283y()).offset(getRequest.getOffset()).fileSize(getRequest.getFileSize()).name(this.f6122a.m57272C()).enableSlice(false).url(downloadUrl.getUrl()), -1L, aVar).getId()));
                    this.f6125d = this.f6125d + 1;
                    return;
                } catch (C9721b e10) {
                    C1419b.this.m8222w(e10);
                    release();
                    return;
                } catch (Exception unused) {
                    C1419b.this.m8222w(new C9721b(4309, networkException.toString(), C1419b.this.f6120t));
                    release();
                    return;
                }
            }
            try {
                try {
                    try {
                        C1419b.this.m8225z(this.f6127f);
                        C11839m.m70687e("SyncAssetDownloadFile", "syncV2 download onException errorCode :" + iM1331z);
                        if (iM1331z == 404) {
                            if (C2785f.m16209e(C1419b.this.f6114n, C1419b.this.f6111k, C1419b.this.f6118r)) {
                                C11839m.m70689w("SyncAssetDownloadFile", "syncV2 download file not first not find, usageName = " + C1419b.this.f6118r);
                                iM1331z = 4041;
                            } else {
                                C11839m.m70689w("SyncAssetDownloadFile", "syncV2 download file first not find, usageName = " + C1419b.this.f6118r);
                                C2785f.m16205a(C1419b.this.f6114n, C1419b.this.f6111k, C1419b.this.f6118r);
                            }
                            C12313i.m74031a().m74033c(C1419b.this.m8223x(), C1419b.this.f6113m, C1419b.this.f6114n);
                            DriveSyncUtil.m17979X(C1419b.this.f6117q, C1419b.this.f6114n, C1419b.this.f6111k, C1419b.this.f6118r, C1419b.this.f6112l, C1419b.this.f6115o, C1419b.this.f6107g);
                        } else {
                            iM1331z = 2263;
                        }
                        C1419b.this.m8222w(new C9721b(iM1331z, "syncV2 download onException taskId [" + getRequest.getId() + "]slice object [" + this.f6122a.m57284z() + "] sliceObject = " + this.f6122a.m57284z() + ", cache = " + this.f6122a.m57272C() + " download error. " + networkException.toString()));
                    } catch (Exception unused2) {
                        C1419b.this.m8222w(new C9721b(2263, networkException.toString()));
                    }
                } catch (C9721b e11) {
                    C1419b.this.m8222w(e11);
                }
                release();
            } catch (Throwable th2) {
                release();
                throw th2;
            }
        }

        @Override // com.huawei.hms.network.file.api.Callback
        public void onProgress(GetRequest getRequest, Progress progress) {
            C11839m.m70686d("SyncAssetDownloadFile", "syncV2 onProgress taskId [" + getRequest.getId() + "]file object [" + this.f6122a.m57284z() + "] download progress = " + progress.getProgress() + "size = " + progress.getFinishedSize());
            try {
                C1419b.this.m8225z(this.f6127f);
                C1419b.this.f6119s = progress.getTotalSize();
                this.f6127f.mo17785g(progress.getTotalSize());
                C1419b.m8213p(C1419b.this, progress.getFinishedSize());
                this.f6127f.mo17784f(C1419b.this.f6109i);
                this.f6127f.mo17783e(false);
            } catch (C9721b e10) {
                C11839m.m70687e("SyncAssetDownloadFile", "syncV2 onProgress taskId [" + getRequest.getId() + "]file object [" + this.f6122a.m57284z() + "] cache [" + this.f6122a.m57272C() + "] get download progress error." + e10);
                C1419b.this.m8222w(new C9721b(e10.m60659c(), e10.toString(), C1419b.this.f6120t));
            }
        }

        @Override // com.huawei.hms.network.file.api.Callback
        public GetRequest onStart(GetRequest getRequest) {
            EndpointUrl downloadUrl;
            C11839m.m70688i("SyncAssetDownloadFile", "syncV2 onStart taskId [" + getRequest.getId() + "]app file object [" + this.f6122a.m57284z() + "] get download address.");
            try {
                C1419b.this.m8225z(this.f6127f);
                downloadUrl = C1419b.this.f6107g.getResource().getDownloadUrl();
                this.f6126e = downloadUrl;
            } catch (C9721b e10) {
                C11839m.m70687e("SyncAssetDownloadFile", "syncV2 taskId [" + getRequest.getId() + "]file object [" + this.f6122a.m57284z() + "] cache [" + this.f6122a.m57272C() + "] get download address error." + e10);
                C1419b.this.m8222w(new C9721b(e10.m60659c(), e10.toString(), C1419b.this.f6120t));
            } catch (Exception e11) {
                C11839m.m70687e("SyncAssetDownloadFile", "syncV2 taskId [" + getRequest.getId() + "]file object [" + this.f6122a.m57284z() + "] cache [" + this.f6122a.m57272C() + "] get download address error." + e11);
                C1419b.this.m8222w(new C9721b(4309, e11.toString(), C1419b.this.f6120t));
            }
            if (downloadUrl != null && downloadUrl.getUrl() != null) {
                String url = this.f6126e.getUrl();
                Object obj = C1419b.this.f6107g.get("client_hw_cdn_url");
                String str = obj != null ? (String) obj : "";
                Map<String, String> headers = this.f6126e.getHeaders();
                if (TextUtils.isEmpty(str)) {
                    C11839m.m70686d("SyncAssetDownloadFile", "syncV2 endpointUrl: " + this.f6126e.getUrl());
                    getRequest = getRequest.newBuilder().url(this.f6126e.getUrl()).build();
                } else {
                    String strM68805b = C11526c.m68805b(url);
                    String strReplace = SafeString.replace(url, strM68805b, str);
                    C11839m.m70686d("SyncAssetDownloadFile", "syncV2 updateTask cdnUrl: " + str);
                    headers.put("x-hw-original-url", strM68805b);
                    getRequest = getRequest.newBuilder().url(strReplace).headers(headers).build();
                }
                this.f6128g.m66667w(C13843a.m83101w(getRequest.getUrl()));
                return getRequest;
            }
            C11839m.m70687e("SyncAssetDownloadFile", "syncV2 endpointUrl is invalid.");
            C1419b.this.m8222w(new C9721b(2214, "endpointUrl is null", C1419b.this.f6120t));
            return getRequest;
        }
    }

    public C1419b(EnumC12999a enumC12999a, String str, String str2, String str3, String str4, Asset asset, String str5, String str6, String str7, String str8, Map<String, String> map) {
        this.f6121u = new LinkedHashMap();
        this.f6116p = enumC12999a;
        this.f6107g = asset;
        this.f6111k = str3;
        this.f6112l = str4;
        this.f6113m = str2;
        this.f6114n = str5;
        this.f6115o = str6;
        this.f6117q = str;
        this.f6118r = str7;
        this.f6120t = str8;
        this.f6121u = map;
    }

    /* renamed from: p */
    public static /* synthetic */ long m8213p(C1419b c1419b, long j10) {
        long j11 = c1419b.f6109i + j10;
        c1419b.f6109i = j11;
        return j11;
    }

    /* renamed from: A */
    public final void m8218A() throws SQLException {
        C9072h.b bVar = this.f6101a;
        if (bVar != null) {
            bVar.m57281w().m57245a(this.f6104d);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0012, code lost:
    
        r2 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:3:0x000d, code lost:
    
        if (r9.f6106f != null) goto L4;
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x000f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:5:0x0011 A[LOOP:0: B:6:0x0012->B:5:0x0011, LOOP_END] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x004b -> B:4:0x000f). Please report as a decompilation issue!!! */
    /* renamed from: B */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m8219B(java.util.concurrent.CountDownLatch r10, com.huawei.android.hicloud.sync.protocol.C2934m r11) throws fk.C9721b {
        /*
            r9 = this;
            java.lang.String r0 = "SyncAssetDownloadFile"
            r9.m8225z(r11)
            boolean r1 = r11.mo17782d()
            fk.b r2 = r9.f6106f
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L11
        Lf:
            r2 = r4
            goto L12
        L11:
            r2 = r3
        L12:
            long r5 = r10.getCount()
            r7 = 0
            int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r5 <= 0) goto L4e
            if (r1 != 0) goto L4e
            if (r2 != 0) goto L4e
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch: java.lang.InterruptedException -> L30
            r5 = 400(0x190, double:1.976E-321)
            boolean r1 = r10.await(r5, r1)     // Catch: java.lang.InterruptedException -> L30
            if (r1 != 0) goto L45
            java.lang.String r1 = "syncV2 wait not finish"
            p514o9.C11839m.m70686d(r0, r1)     // Catch: java.lang.InterruptedException -> L30
            goto L45
        L30:
            r1 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r5 = "syncV2 lock wait error."
            r2.append(r5)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            p514o9.C11839m.m70689w(r0, r1)
        L45:
            boolean r1 = r11.mo17782d()
            fk.b r2 = r9.f6106f
            if (r2 == 0) goto L11
            goto Lf
        L4e:
            fk.b r10 = r9.f6106f
            if (r10 != 0) goto L56
            r9.m8225z(r11)
            return
        L56:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: cd.C1419b.m8219B(java.util.concurrent.CountDownLatch, com.huawei.android.hicloud.sync.protocol.m):void");
    }

    /* renamed from: u */
    public final void m8220u(C11060c c11060c, Resource resource, C2934m c2934m) throws C9721b, SQLException {
        m8225z(c2934m);
        String hash = resource.getHash();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        this.f6101a = new C9072h.b(this.f6107g.getId()).m57276G(this.f6110j.m28187f().getPath());
        C11839m.m70686d("SyncAssetDownloadFile", "doDownload  downloadBuilder setPath [" + this.f6101a.m57283y() + "] ");
        C9072h.b bVarM57277H = new C9072h.b(this.f6107g.getId()).m57276G(this.f6101a.m57283y()).m57274E(0).m57275F(0L).m57280K(UUID.randomUUID().toString()).m57277H(hash);
        this.f6102b.add(bVarM57277H);
        if (bVarM57277H.m57270A() == EnumC9073i.SUCCESS.m57285b()) {
            File file = new File(this.f6105e + "/" + bVarM57277H.m57272C());
            if (file.exists()) {
                countDownLatch.countDown();
                C11839m.m70686d("SyncAssetDownloadFile", "syncV2 file object [" + bVarM57277H.m57284z() + "] already download. file.exists Path :" + file.getPath());
                return;
            }
            C11839m.m70686d("SyncAssetDownloadFile", "syncV2 file object [" + bVarM57277H.m57284z() + "] download cache has been deleted.");
            bVarM57277H.m57273D();
        }
        m8225z(c2934m);
        a aVar = new a(c11060c, bVarM57277H, countDownLatch, c2934m, true);
        EndpointUrl downloadUrl = resource.getDownloadUrl();
        if (downloadUrl == null) {
            countDownLatch.countDown();
            throw new C9721b(2214, bVarM57277H.m57284z() + " has no endpointUrl", this.f6120t);
        }
        GetRequest.Builder builder = new GetRequest.Builder();
        C11839m.m70686d("SyncAssetDownloadFile", "syncV2 downloadRequestBuilder filePath [" + bVarM57277H.m57283y() + "]");
        builder.filePath(bVarM57277H.m57283y()).fileSize(resource.getLength().longValue()).enableSlice(false).config(C13735d.m82528e()).name(hash).url(downloadUrl.getUrl());
        GetRequest getRequestM82541k = C13735d.m82531s().m82541k(this.f6116p, builder, bVarM57277H.m57271B(), aVar);
        this.f6103c.add(Long.valueOf(getRequestM82541k.getId()));
        bVarM57277H.m57279J(getRequestM82541k.getId()).m57281w().m57247c(this.f6104d);
        try {
            m8219B(countDownLatch, c2934m);
            c2934m.mo17783e(true);
        } catch (C9721b e10) {
            C13735d.m82531s().m82534A(this.f6116p, this.f6103c);
            C11839m.m70687e("SyncAssetDownloadFile", "syncV2 " + e10.toString());
            throw e10;
        }
    }

    /* renamed from: v */
    public void m8221v(String str, C13404h c13404h, C11060c c11060c, String str2) throws C9721b {
        C11839m.m70688i("SyncAssetDownloadFile", "syncV2  Enter SyncAssetDownloaFile download encrypt file [" + str + "] download start");
        String str3 = this.f6116p + "&" + str2 + "&" + this.f6107g.getId() + "&" + str;
        C13576a c13576aM81565a = C13576a.m81565a();
        Resource resource = this.f6107g.getResource();
        if (resource == null) {
            C11839m.m70687e("SyncAssetDownloadFile", "syncV2 getResource is null");
            throw new C9721b(2215, "encrypt file [" + str + "] download getResource is null.", this.f6120t);
        }
        C2934m c2934m = new C2934m(c13404h);
        m8225z(c2934m);
        while (!c13576aM81565a.m81566b(str3)) {
            try {
                try {
                    c13576aM81565a.m81570f(str3);
                } catch (C9721b e10) {
                    C11839m.m70687e("SyncAssetDownloadFile", "syncV2 download file end CException:" + e10.toString());
                    c11060c.m66665u(String.valueOf(e10.m60659c()));
                    c11060c.m66635A(e10.getMessage());
                    c11060c.m66640F(String.valueOf(this.f6109i));
                    throw e10;
                }
            } catch (Throwable th2) {
                c2934m.mo17783e(true);
                c13576aM81565a.m81568d(str3);
                throw th2;
            }
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.f6110j = new C4602e("", C10278a.m63442h(str));
        C10812z.m65850s(this.f6121u, this.f6107g);
        if (this.f6107g.getResource() == null) {
            m8225z(c2934m);
            m8224y(this.f6108h);
        }
        m8225z(c2934m);
        m8220u(c11060c, resource, c2934m);
        Asset asset = this.f6107g;
        if (!C9905a.m61496a(str, asset, this.f6114n, asset.getId(), this.f6117q)) {
            throw new C9721b(2263, "download file [" + str + "] is invalid", this.f6120t);
        }
        m8218A();
        c11060c.m66638D(this.f6107g.getId());
        c11060c.m66665u("0");
        c11060c.m66635A(str2 + "_success");
        c11060c.m66640F(String.valueOf(this.f6109i));
        c11060c.m66642H(String.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
        C11839m.m70688i("SyncAssetDownloadFile", "syncV2 encrypt file [" + str + "] download end.");
        c2934m.mo17783e(true);
        c13576aM81565a.m81568d(str3);
    }

    /* renamed from: w */
    public final void m8222w(C9721b c9721b) {
        synchronized (f6099v) {
            try {
                if (this.f6106f == null) {
                    this.f6106f = c9721b;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: x */
    public Context m8223x() {
        return C0213f.m1377a();
    }

    /* renamed from: y */
    public final void m8224y(int i10) throws C9721b {
        C11839m.m70688i("SyncAssetDownloadFile", "syncV2 getDownloadUrl");
        Asset asset = new Asset();
        Resource resource = new Resource();
        resource.setId(this.f6107g.getId());
        asset.setResource(resource);
        try {
            synchronized (f6100w) {
                try {
                    if (i10 != this.f6108h) {
                        C11839m.m70688i("SyncAssetDownloadFile", "syncV2 downloadUrlVersion is " + i10 + " is not equal to resourceVersion " + this.f6108h);
                        return;
                    }
                    Resource resourceOnRefreshDownloadUrl = SyncProcessBase.onRefreshDownloadUrl(this.f6113m, this.f6111k, this.f6112l, this.f6107g.getId(), this.f6107g.getVersionId(), this.f6114n, this.f6115o, this.f6117q, this.f6120t);
                    if (resourceOnRefreshDownloadUrl != null) {
                        this.f6107g.setResource(resourceOnRefreshDownloadUrl);
                        this.f6108h++;
                        return;
                    }
                    throw new C9721b(2215, "assets.revisions.get Resource is null, assetId = " + this.f6107g.getId() + ", recordId = " + this.f6112l);
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        } catch (C9722c e10) {
            throw new C9721b(e10.m60666c(), "onCreateUploadUrl err, assetId = " + this.f6107g.getId() + ", recordId = " + this.f6112l + ", errMsg = " + e10.getMessage(), this.f6120t);
        }
    }

    /* renamed from: z */
    public final void m8225z(C2934m c2934m) throws C9721b {
        if (c2934m.mo17782d()) {
            if (c2934m.mo17781a() != null) {
                throw new C9721b(c2934m.mo17781a().m80589b(), "net disable or canceled by user", this.f6120t);
            }
            throw new C9721b(1002, "net disable or canceled by user", this.f6120t);
        }
        C9721b c9721b = this.f6106f;
        if (c9721b != null) {
            throw c9721b;
        }
    }
}
