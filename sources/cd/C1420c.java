package cd;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.huawei.android.hicloud.complexutil.CloudSyncUtil;
import com.huawei.android.hicloud.security.bean.SliceDecryptReq;
import com.huawei.android.hicloud.sync.contact.SyncProcessBase;
import com.huawei.android.hicloud.sync.protocol.C2934m;
import com.huawei.android.hicloud.syncdrive.cloudsync.model.Asset;
import com.huawei.android.hicloud.syncdrive.cloudsync.model.Resource;
import com.huawei.android.hicloud.syncdrive.cloudsync.model.SliceObject;
import com.huawei.android.hicloud.syncdrive.util.DriveSyncUtil;
import com.huawei.cloud.base.http.C4602e;
import com.huawei.cloud.base.util.C4627a0;
import com.huawei.hicloud.base.drive.model.EndpointUrl;
import com.huawei.hicloud.base.slice.SliceEnumeration;
import com.huawei.hicloud.base.slice.SliceItem;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hms.network.embedded.C5927g2;
import com.huawei.hms.network.embedded.C6148x2;
import com.huawei.hms.network.file.api.Progress;
import com.huawei.hms.network.file.api.Request;
import com.huawei.hms.network.file.api.Response;
import com.huawei.hms.network.file.api.exception.NetworkException;
import com.huawei.hms.network.file.download.api.DownloadManager;
import com.huawei.hms.network.file.download.api.FileRequestCallback;
import com.huawei.hms.network.file.download.api.GetRequest;
import fk.C9721b;
import fk.C9722c;
import hk.C10278a;
import java.io.Closeable;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0213f;
import p225dd.C9065a;
import p225dd.C9072h;
import p225dd.EnumC9073i;
import p365ic.C10466a;
import p429kk.C11060c;
import p514o9.C11839m;
import p549p9.C12122a;
import p616rk.AbstractRunnableC12516b;
import p616rk.C12515a;
import p652t9.EnumC12999a;
import p767x9.C13735d;
import p783xp.C13843a;
import tc.C13007b;
import za.C14164a;
import za.C14165b;

/* renamed from: cd.c */
/* loaded from: classes3.dex */
public class C1420c {

    /* renamed from: x */
    public static final Object f6130x = new Object();

    /* renamed from: y */
    public static final Object f6131y = new Object();

    /* renamed from: a */
    public C9072h.b f6132a;

    /* renamed from: d */
    public C4602e f6135d;

    /* renamed from: e */
    public List<SliceItem<SliceObject>> f6136e;

    /* renamed from: f */
    public String f6137f;

    /* renamed from: g */
    public String f6138g;

    /* renamed from: h */
    public String f6139h;

    /* renamed from: i */
    public String f6140i;

    /* renamed from: j */
    public EnumC12999a f6141j;

    /* renamed from: k */
    public C9721b f6142k;

    /* renamed from: n */
    public Asset f6145n;

    /* renamed from: o */
    public String f6146o;

    /* renamed from: p */
    public String f6147p;

    /* renamed from: s */
    public String f6150s;

    /* renamed from: v */
    public String f6153v;

    /* renamed from: w */
    public Map<String, String> f6154w;

    /* renamed from: b */
    public List<C9072h.b> f6133b = new ArrayList();

    /* renamed from: l */
    public File f6143l = DriveSyncUtil.m18013w();

    /* renamed from: m */
    public int f6144m = 0;

    /* renamed from: q */
    public List<Long> f6148q = new ArrayList();

    /* renamed from: r */
    public long f6149r = 0;

    /* renamed from: t */
    public long f6151t = 0;

    /* renamed from: u */
    public long f6152u = 0;

    /* renamed from: c */
    public SQLiteDatabase f6134c = C9065a.m57166a();

    /* renamed from: cd.c$a */
    public class a extends AbstractRunnableC12516b {

        /* renamed from: a */
        public C9072h.b f6155a;

        /* renamed from: b */
        public CountDownLatch f6156b;

        /* renamed from: c */
        public String f6157c;

        /* renamed from: d */
        public String f6158d;

        /* renamed from: e */
        public int f6159e;

        /* renamed from: f */
        public Asset f6160f;

        public a(C9072h.b bVar, String str, String str2, int i10, Asset asset, CountDownLatch countDownLatch) {
            this.f6155a = bVar;
            this.f6156b = countDownLatch;
            this.f6157c = str;
            this.f6158d = str2;
            this.f6159e = i10;
            this.f6160f = asset;
        }

        /* renamed from: c */
        public void m8264c(String str) throws Throwable {
            SliceDecryptReq sliceDecryptReq = new SliceDecryptReq();
            sliceDecryptReq.setTraceID(C1420c.this.f6137f);
            sliceDecryptReq.setDesFile(this.f6155a.m57283y());
            sliceDecryptReq.setSrcFile(str);
            sliceDecryptReq.setOffset(this.f6155a.m57282x());
            sliceDecryptReq.setEfek(this.f6157c);
            sliceDecryptReq.setIv(this.f6158d);
            sliceDecryptReq.setType(this.f6159e);
            C10466a.m64314e(sliceDecryptReq);
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            File fileM63442h;
            StringBuilder sb2;
            String str = C1420c.this.f6143l + "/" + this.f6155a.m57272C();
            try {
                try {
                    C11839m.m70686d("SyncAssetDownloadFileEncrypt", "DecryptTask start, destPath: " + this.f6155a.m57283y() + " , srcPath: " + str);
                    m8264c(str);
                    C11839m.m70686d("SyncAssetDownloadFileEncrypt", "DecryptTask end, destPath: " + this.f6155a.m57283y() + " , srcPath: " + str);
                    fileM63442h = C10278a.m63442h(str);
                } catch (C9721b e10) {
                    C11839m.m70687e("SyncAssetDownloadFileEncrypt", "decrypt slice errorCode: " + e10.m60659c() + ", errorMsg: " + e10.getMessage());
                    if (e10.m60659c() == 4005) {
                        m8265d(str);
                    } else {
                        C1420c.this.m8253C(e10);
                    }
                    fileM63442h = C10278a.m63442h(str);
                    if (fileM63442h.exists()) {
                        sb2 = new StringBuilder();
                    }
                } catch (Exception e11) {
                    C1420c.this.m8253C(new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "DecryptTask error." + e11.toString(), C1420c.this.f6153v));
                    fileM63442h = C10278a.m63442h(str);
                    if (fileM63442h.exists()) {
                        sb2 = new StringBuilder();
                    }
                }
                if (fileM63442h.exists()) {
                    sb2 = new StringBuilder();
                    sb2.append("syncV2 decrypt file exits, delete = ");
                    sb2.append(fileM63442h.delete());
                    C11839m.m70686d("SyncAssetDownloadFileEncrypt", sb2.toString());
                }
                this.f6156b.countDown();
            } catch (Throwable th2) {
                File fileM63442h2 = C10278a.m63442h(str);
                if (fileM63442h2.exists()) {
                    C11839m.m70686d("SyncAssetDownloadFileEncrypt", "syncV2 decrypt file exits, delete = " + fileM63442h2.delete());
                }
                this.f6156b.countDown();
                throw th2;
            }
        }

        /* renamed from: d */
        public final void m8265d(String str) throws Throwable {
            try {
                C11839m.m70688i("SyncAssetDownloadFileEncrypt", "hmac retryDecrypt start.");
                if (this.f6160f.getResource() != null && this.f6160f.getResource().getHash() != null && !TextUtils.isEmpty(this.f6160f.getResource().getHash())) {
                    String hash = this.f6160f.getResource().getHash();
                    C10466a.m64315f(C10278a.m63442h(str), C10278a.m63442h(this.f6155a.m57283y()), this.f6155a.m57282x(), C14164a.m85026e(C14165b.m85031d(hash)), C14164a.m85026e(C14165b.m85033f(hash)));
                    C11839m.m70688i("SyncAssetDownloadFileEncrypt", "hmac retryDecrypt success.");
                    return;
                }
                C1420c.this.m8253C(new C9721b(2215, "retryDecrypt but asset hash no hash info", C1420c.this.f6153v));
            } catch (C9721b e10) {
                C11839m.m70687e("SyncAssetDownloadFileEncrypt", "hmac retry decrypt file error: " + e10.toString());
                C1420c.this.m8253C(e10);
            } catch (Exception e11) {
                C11839m.m70687e("SyncAssetDownloadFileEncrypt", "hmac retry decrypt file exception error: " + e11.toString());
                C1420c.this.m8253C(new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "retry decrypt file exception error:" + e11.toString(), C1420c.this.f6153v));
            }
        }

        @Override // p616rk.AbstractRunnableC12516b
        public AbstractRunnableC12516b.a getEnum() {
            return AbstractRunnableC12516b.a.DRIVE;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void release() {
            C12515a.m75110o().m75165a1(this);
        }

        @Override // p616rk.AbstractRunnableC12516b
        public boolean syncLock() {
            return false;
        }
    }

    /* renamed from: cd.c$b */
    public class b extends FileRequestCallback {

        /* renamed from: a */
        public C9072h.b f6162a;

        /* renamed from: b */
        public CountDownLatch f6163b;

        /* renamed from: c */
        public boolean f6164c;

        /* renamed from: e */
        public EndpointUrl f6166e;

        /* renamed from: f */
        public final C2934m f6167f;

        /* renamed from: i */
        public C11060c f6170i;

        /* renamed from: d */
        public int f6165d = 0;

        /* renamed from: g */
        public long f6168g = 0;

        /* renamed from: h */
        public long f6169h = 0;

        public b(C11060c c11060c, C9072h.b bVar, CountDownLatch countDownLatch, C2934m c2934m, boolean z10) {
            this.f6170i = c11060c;
            this.f6162a = bVar;
            this.f6163b = countDownLatch;
            this.f6164c = z10;
            this.f6167f = c2934m;
        }

        /* renamed from: a */
        public final void m8266a() {
            CountDownLatch countDownLatch = this.f6163b;
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x007b, code lost:
        
            if ((r23 instanceof com.huawei.hms.network.file.api.exception.UnKnownErrorException) == false) goto L56;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onException(com.huawei.hms.network.file.download.api.GetRequest r22, com.huawei.hms.network.file.api.exception.NetworkException r23, com.huawei.hms.network.file.api.Response<com.huawei.hms.network.file.download.api.GetRequest, java.io.File, java.io.Closeable> r24) throws fk.C9721b {
            /*
                Method dump skipped, instructions count: 1149
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: cd.C1420c.b.onException(com.huawei.hms.network.file.download.api.GetRequest, com.huawei.hms.network.file.api.exception.NetworkException, com.huawei.hms.network.file.api.Response):void");
        }

        @Override // com.huawei.hms.network.file.api.Callback
        public void onSuccess(Response<GetRequest, File, Closeable> response) {
            try {
                try {
                    C11839m.m70688i("SyncAssetDownloadFileEncrypt", "syncV2 onSuccess taskId [" + ((GetRequest) response.getRequest()).getId() + "]app slice object [" + this.f6162a.m57284z() + "] download end.");
                    Map<String, Object> extraInfo = response.getExtraInfo();
                    if (extraInfo != null) {
                        String str = extraInfo.get("protocol_impl") + "-" + extraInfo.get("protocol");
                        C11839m.m70686d("SyncAssetDownloadFileEncrypt", "downProtocol = " + str);
                        C1420c.this.f6154w.put("protocolType", str);
                    }
                    int iM57270A = this.f6162a.m57270A();
                    EnumC9073i enumC9073i = EnumC9073i.SUCCESS;
                    if (iM57270A != enumC9073i.m57285b()) {
                        this.f6162a.m57278I(enumC9073i.m57285b()).m57281w().m57247c(C1420c.this.f6134c);
                        C11839m.m70688i("SyncAssetDownloadFileEncrypt", "syncV2 taskId [" + ((GetRequest) response.getRequest()).getId() + "]slice object [" + this.f6162a.m57284z() + "] cache [" + this.f6162a.m57272C() + "] download success");
                    }
                    C1420c.this.m8257I(this.f6167f);
                    C1420c.m8248u(C1420c.this, this.f6169h);
                    this.f6167f.mo17784f(C1420c.this.f6149r);
                    this.f6167f.mo17783e(false);
                } catch (C9721b e10) {
                    C11839m.m70687e("SyncAssetDownloadFileEncrypt", "syncV2 taskId [" + ((GetRequest) response.getRequest()).getId() + "]slice object [" + this.f6162a.m57284z() + "] download decrypt error." + e10);
                    C1420c.this.m8253C(e10);
                }
                m8266a();
            } catch (Throwable th2) {
                m8266a();
                throw th2;
            }
        }

        @Override // com.huawei.hms.network.file.api.Callback
        public void onProgress(GetRequest getRequest, Progress progress) {
            C11839m.m70686d("SyncAssetDownloadFileEncrypt", "syncV2 onProgress taskId [" + getRequest.getId() + "]app slice object [" + this.f6162a.m57284z() + "] download progress = " + progress.getProgress() + "size = " + progress.getFinishedSize());
            try {
                C1420c.this.m8257I(this.f6167f);
                this.f6168g = progress.getFinishedSize();
                long j10 = C1420c.this.f6149r + this.f6168g;
                this.f6169h = progress.getTotalSize();
                this.f6167f.mo17784f(j10);
                this.f6167f.mo17783e(false);
            } catch (C9721b e10) {
                C11839m.m70687e("SyncAssetDownloadFileEncrypt", "syncV2 onProgress taskId [" + getRequest.getId() + "]file object [" + this.f6162a.m57284z() + "] cache [" + this.f6162a.m57272C() + "] get download progress error." + e10);
                C1420c.this.m8253C(e10);
            }
        }

        @Override // com.huawei.hms.network.file.api.Callback
        public GetRequest onStart(GetRequest getRequest) {
            C11839m.m70688i("SyncAssetDownloadFileEncrypt", "syncV2 onStart taskId [" + getRequest.getId() + "]app slice object [" + this.f6162a.m57284z() + "] get download address.");
            try {
                C1420c.this.m8257I(this.f6167f);
                EndpointUrl endpointUrlM8254E = C1420c.this.m8254E(this.f6162a.m57284z(), C1420c.this.f6145n);
                this.f6166e = endpointUrlM8254E;
                if (endpointUrlM8254E != null && endpointUrlM8254E.getHeaders() != null && this.f6166e.getUrl() != null) {
                    C11839m.m70686d("SyncAssetDownloadFileEncrypt", "endpointUrl: " + this.f6166e.getUrl());
                    GetRequest getRequestBuild = getRequest.newBuilder().url(this.f6166e.getUrl()).build();
                    this.f6170i.m66667w(C13843a.m83101w(getRequestBuild.getUrl()));
                    return getRequestBuild;
                }
                C11839m.m70687e("SyncAssetDownloadFileEncrypt", "syncV2 endpointUrl is invalid.");
                C1420c.this.m8253C(new C9721b(2214, "endpointUrl is null, sliceObjectId = " + this.f6162a.m57284z() + ", cache = " + this.f6162a.m57272C()));
                return getRequest;
            } catch (C9721b e10) {
                C11839m.m70687e("SyncAssetDownloadFileEncrypt", "syncV2 onStart taskId [" + getRequest.getId() + "]file object [" + this.f6162a.m57284z() + "] cache [" + this.f6162a.m57272C() + "] get download address err code " + e10.m60659c() + e10.getMessage());
                C1420c.this.m8253C(e10);
                return getRequest;
            } catch (Exception e11) {
                String str = "syncV2 onStart taskId [" + getRequest.getId() + "]slice object [" + this.f6162a.m57284z() + "] cache [" + this.f6162a.m57272C() + "] get download address err " + e11.getMessage();
                C11839m.m70687e("SyncAssetDownloadFileEncrypt", str);
                C1420c.this.m8253C(new C9721b(2263, str));
                return getRequest;
            }
        }

        @Override // com.huawei.hms.network.file.api.Callback
        public /* bridge */ /* synthetic */ void onException(Request request, NetworkException networkException, Response response) throws C9721b {
            onException((GetRequest) request, networkException, (Response<GetRequest, File, Closeable>) response);
        }
    }

    public C1420c(EnumC12999a enumC12999a, String str, String str2, String str3, String str4, Asset asset, String str5, String str6, String str7, String str8, Map<String, String> map) {
        this.f6154w = new LinkedHashMap();
        this.f6141j = enumC12999a;
        this.f6137f = str;
        this.f6138g = str3;
        this.f6139h = str4;
        this.f6140i = str2;
        this.f6145n = asset;
        this.f6146o = str5;
        this.f6147p = str6;
        this.f6150s = str7;
        this.f6153v = str8;
        this.f6154w = map;
    }

    /* renamed from: D */
    public static Context m8226D() {
        return C0213f.m1377a();
    }

    /* renamed from: H */
    public static SliceEnumeration<SliceObject> m8227H(Asset asset, List<SliceObject> list) throws C9721b {
        C11839m.m70686d("SyncAssetDownloadFileEncrypt", "syncV2 get slice enumeration by objects.");
        long jLongValue = asset.getResource().getLength().longValue();
        Integer sliceSize = asset.getResource().getSliceSize();
        if (sliceSize == null) {
            sliceSize = Integer.MAX_VALUE;
        }
        long jIntValue = ((jLongValue - 1) / sliceSize.intValue()) + 1;
        C4627a0.m28395h(((long) list.size()) >= jIntValue, "objects is not valid.");
        return new SliceEnumeration<>(list, new C1422e(jIntValue, sliceSize.intValue(), jLongValue % ((long) sliceSize.intValue()) == 0 ? sliceSize.intValue() : jLongValue % sliceSize.intValue()));
    }

    /* renamed from: u */
    public static /* synthetic */ long m8248u(C1420c c1420c, long j10) {
        long j11 = c1420c.f6149r + j10;
        c1420c.f6149r = j11;
        return j11;
    }

    /* renamed from: A */
    public final void m8251A(C11060c c11060c, C2934m c2934m) throws C9721b, SQLException {
        int i10;
        int size = this.f6136e.size();
        List<C9072h.b> listM57246b = this.f6132a.m57281w().m57246b(this.f6134c);
        CountDownLatch countDownLatch = new CountDownLatch(size);
        long j10 = 0;
        int i11 = 0;
        while (i11 < size) {
            m8257I(c2934m);
            SliceItem<SliceObject> sliceItem = this.f6136e.get(i11);
            SliceObject object = sliceItem.getObject();
            C11839m.m70686d("SyncAssetDownloadFileEncrypt", "doDownload  downloadBuilder setPath [" + this.f6132a.m57283y() + "] ");
            C9072h.b bVarM57277H = new C9072h.b(this.f6145n.getId()).m57276G(this.f6132a.m57283y()).m57274E(i11).m57275F(j10).m57280K(UUID.randomUUID().toString()).m57277H(object.getId());
            long jIntValue = (long) this.f6145n.getResource().getSliceSize().intValue();
            long j11 = j10 + jIntValue;
            Iterator<C9072h.b> it = listM57246b.iterator();
            while (it.hasNext() && !bVarM57277H.equals(it.next())) {
            }
            this.f6133b.add(bVarM57277H);
            if (bVarM57277H.m57270A() == EnumC9073i.SUCCESS.m57285b()) {
                File file = new File(this.f6143l + "/" + bVarM57277H.m57272C());
                if (file.exists()) {
                    i10 = i11;
                    this.f6149r += jIntValue;
                    countDownLatch.countDown();
                    C11839m.m70686d("SyncAssetDownloadFileEncrypt", "syncV2 slice object [" + bVarM57277H.m57284z() + "] already download.file path :" + file.getPath());
                    i11 = i10 + 1;
                    j10 = j11;
                } else {
                    i10 = i11;
                    C11839m.m70686d("SyncAssetDownloadFileEncrypt", "syncV2 slice object [" + bVarM57277H.m57284z() + "] download cache has been deleted, redownload.");
                    bVarM57277H.m57273D();
                }
            } else {
                i10 = i11;
            }
            m8257I(c2934m);
            b bVar = new b(c11060c, bVarM57277H, countDownLatch, c2934m, true);
            EndpointUrl endpointUrlM8254E = m8254E(bVarM57277H.m57284z(), this.f6145n);
            if (endpointUrlM8254E == null) {
                countDownLatch.countDown();
                throw new C9721b(2214, "endpointUrl is null, sliceObjectId = " + bVarM57277H.m57284z());
            }
            C11839m.m70686d("SyncAssetDownloadFileEncrypt", "syncV2  doDownload downloadRequestBuilder filePath :" + this.f6143l + "/" + bVarM57277H.m57272C());
            GetRequest getRequestM82541k = C13735d.m82531s().m82541k(this.f6141j, DownloadManager.newGetRequestBuilder().filePath(this.f6143l + "/" + bVarM57277H.m57272C()).offset(sliceItem.getOffset()).fileSize(sliceItem.getLength()).name(bVarM57277H.m57272C()).config(C13735d.m82529f(m8261x())).url(endpointUrlM8254E.getUrl()).headers(endpointUrlM8254E.getHeaders()).reportInfos(m8262y(bVarM57277H.m57284z())).enableSlice(false), bVarM57277H.m57271B(), bVar);
            this.f6148q.add(Long.valueOf(getRequestM82541k.getId()));
            bVarM57277H.m57279J(getRequestM82541k.getId()).m57281w().m57247c(this.f6134c);
            i11 = i10 + 1;
            j10 = j11;
        }
        try {
            m8260L(countDownLatch, c2934m);
            c2934m.mo17783e(true);
        } catch (C9721b e10) {
            C13735d.m82531s().m82534A(this.f6141j, this.f6148q);
            C11839m.m70687e("SyncAssetDownloadFileEncrypt", "syncV2 wait error " + e10.toString());
            throw e10;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(3:(4:57|6|4|54)|3|56) */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0179, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* renamed from: B */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m8252B(java.lang.String r21, vc.C13404h r22, p429kk.C11060c r23, java.lang.String r24) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 603
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cd.C1420c.m8252B(java.lang.String, vc.h, kk.c, java.lang.String):void");
    }

    /* renamed from: C */
    public final void m8253C(C9721b c9721b) {
        synchronized (f6130x) {
            try {
                if (this.f6142k == null) {
                    this.f6142k = c9721b;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: E */
    public final EndpointUrl m8254E(String str, Asset asset) throws C9721b {
        synchronized (f6131y) {
            try {
                for (SliceObject sliceObject : asset.getResource().getObjects()) {
                    if (sliceObject.getId().equals(str)) {
                        EndpointUrl endpointUrlM8256G = m8256G(sliceObject);
                        endpointUrlM8256G.set("client_endpointVersion", (Object) Integer.valueOf(this.f6144m));
                        return endpointUrlM8256G;
                    }
                }
                return null;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: F */
    public final void m8255F(int i10) throws C9721b {
        C11839m.m70688i("SyncAssetDownloadFileEncrypt", "syncV2 getDownloadUrl");
        try {
            synchronized (f6131y) {
                try {
                    if (i10 != this.f6144m) {
                        C11839m.m70688i("SyncAssetDownloadFileEncrypt", "syncV2 downloadUrlVersion is " + i10 + " is not equal to resourceVersion " + this.f6144m);
                        return;
                    }
                    Resource resourceOnRefreshDownloadUrl = SyncProcessBase.onRefreshDownloadUrl(this.f6140i, this.f6138g, this.f6139h, this.f6145n.getId(), this.f6145n.getVersionId(), this.f6146o, this.f6147p, this.f6137f, this.f6153v);
                    if (resourceOnRefreshDownloadUrl != null) {
                        this.f6145n.setResource(resourceOnRefreshDownloadUrl);
                        this.f6144m++;
                    } else {
                        throw new C9721b(2215, "assets.revisions.get Resource is null, versionId = " + this.f6145n.getVersionId(), this.f6153v);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        } catch (C9722c e10) {
            this.f6145n.getId();
            e10.getMessage();
            throw new C9721b(e10.m60666c(), e10.getMessage());
        }
    }

    /* renamed from: G */
    public final EndpointUrl m8256G(SliceObject sliceObject) throws C9721b {
        if (sliceObject == null) {
            throw new C9721b(2213, "syncv2 getDownloadEndpointUrl slice object null", this.f6153v);
        }
        if (sliceObject.getAccelerateDownloadUrl() != null) {
            CloudSyncUtil.m16000d(this.f6154w, "accelerate", String.valueOf(1));
            CloudSyncUtil.m16000d(this.f6154w, C5927g2.QUIC, String.valueOf(C13007b.m78205Y(m8226D()).m78249a0() ? 1 : 0));
            return sliceObject.getAccelerateDownloadUrl();
        }
        CloudSyncUtil.m16000d(this.f6154w, "accelerate", String.valueOf(0));
        CloudSyncUtil.m16000d(this.f6154w, C5927g2.QUIC, String.valueOf(C13007b.m78205Y(m8226D()).m78249a0() ? 1 : 0));
        return sliceObject.getDownloadUrl();
    }

    /* renamed from: I */
    public final void m8257I(C2934m c2934m) throws C9721b {
        if (c2934m.mo17782d() || !c2934m.m17787j()) {
            if (c2934m.mo17781a() != null) {
                throw new C9721b(c2934m.mo17781a().m80589b(), "net disable or canceled by user", this.f6153v);
            }
            throw new C9721b(1002, "net disable or canceled by user", this.f6153v);
        }
        C9721b c9721b = this.f6142k;
        if (c9721b != null) {
            throw c9721b;
        }
    }

    /* renamed from: J */
    public final void m8258J(C12122a c12122a) throws C9721b {
        C11839m.m70688i("SyncAssetDownloadFileEncrypt", "syncV2 prepare");
        this.f6132a = new C9072h.b(this.f6145n.getId()).m57276G(this.f6135d.m28187f().getPath());
        Resource resource = this.f6145n.getResource();
        if (resource == null || resource.size() == 0) {
            throw new C9721b(2215, "file content resource is null");
        }
        List<SliceObject> objects = resource.getObjects();
        if (objects == null || objects.size() == 0) {
            throw new C9721b(2213, "file content has no objectInfoList, resouceId = " + resource.getId());
        }
        this.f6152u = this.f6145n.getResource().getLength().longValue();
        Asset asset = this.f6145n;
        SliceEnumeration<SliceObject> sliceEnumerationM8227H = m8227H(asset, asset.getResource().getObjects());
        if (!sliceEnumerationM8227H.hasMoreSlices()) {
            throw new C9721b(4001, "amount of files does not match with dbank_s3_file, resouceId = " + resource.getId());
        }
        this.f6136e = sliceEnumerationM8227H.nextSlice(this.f6152u).getSliceItems();
        for (SliceObject sliceObject : objects) {
            if (sliceObject != null) {
                this.f6151t += sliceObject.getLength().longValue();
            }
        }
        c12122a.mo17785g(this.f6151t);
    }

    /* renamed from: K */
    public final void m8259K() throws SQLException {
        C9072h.b bVar = this.f6132a;
        if (bVar != null) {
            bVar.m57281w().m57245a(this.f6134c);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0012, code lost:
    
        r2 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:3:0x000d, code lost:
    
        if (r9.f6142k != null) goto L4;
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x000f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:5:0x0011 A[LOOP:0: B:6:0x0012->B:5:0x0011, LOOP_END] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x004b -> B:4:0x000f). Please report as a decompilation issue!!! */
    /* renamed from: L */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m8260L(java.util.concurrent.CountDownLatch r10, com.huawei.android.hicloud.sync.protocol.C2934m r11) throws fk.C9721b {
        /*
            r9 = this;
            java.lang.String r0 = "SyncAssetDownloadFileEncrypt"
            r9.m8257I(r11)
            boolean r1 = r11.mo17782d()
            fk.b r2 = r9.f6142k
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
            fk.b r2 = r9.f6142k
            if (r2 == 0) goto L11
            goto Lf
        L4e:
            fk.b r10 = r9.f6142k
            if (r10 != 0) goto L56
            r9.m8257I(r11)
            return
        L56:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: cd.C1420c.m8260L(java.util.concurrent.CountDownLatch, com.huawei.android.hicloud.sync.protocol.m):void");
    }

    /* renamed from: x */
    public final String m8261x() throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("complete_file_size", String.valueOf(this.f6152u));
            return jSONObject.toString();
        } catch (Exception e10) {
            C11839m.m70687e("SyncAssetDownloadFileEncrypt", "buildOption err " + e10.getMessage());
            return "";
        }
    }

    /* renamed from: y */
    public final Map<String, String> m8262y(String str) {
        HashMap map = new HashMap();
        map.put("trace_id", this.f6137f);
        map.put(C6148x2.DEVICE_ID, str);
        C11839m.m70688i("SyncAssetDownloadFileEncrypt", "down buildReport trace = " + this.f6137f);
        return map;
    }

    /* renamed from: z */
    public final void m8263z(Asset asset, List<C9072h.b> list, C2934m c2934m, C11060c c11060c, List<Long> list2) throws C9721b {
        C11839m.m70688i("SyncAssetDownloadFileEncrypt", "syncV2 decryptSlices");
        String ekey = asset.getCipher().getKeyChains().get(0).getEkey();
        String iv2 = asset.getCipher().getIv();
        Integer dataType = asset.getCipher().getDataType();
        ArrayList arrayList = new ArrayList();
        try {
            CountDownLatch countDownLatch = new CountDownLatch(list.size());
            Iterator<C9072h.b> it = list.iterator();
            while (it.hasNext()) {
                a aVar = new a(it.next(), ekey, iv2, dataType.intValue(), asset, countDownLatch);
                arrayList.add(aVar);
                C12515a.m75110o().m75172d(aVar);
                ekey = ekey;
            }
            m8260L(countDownLatch, c2934m);
        } catch (C9721b e10) {
            C13735d.m82531s().m82534A(this.f6141j, list2);
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                ((a) it2.next()).cancel();
            }
            C11839m.m70687e("SyncAssetDownloadFileEncrypt", "syncV2 decryptSlices CException:" + e10.getMessage());
            c11060c.m66665u(String.valueOf(e10.m60659c()));
            c11060c.m66664t(e10.m60658b());
            c11060c.m66635A(e10.getMessage());
            c11060c.m66640F(String.valueOf(this.f6149r));
            throw e10;
        }
    }
}
