package ga;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import bb.C1160a;
import com.huawei.android.hicloud.album.service.logic.manager.SyncSessionManager;
import com.huawei.android.hicloud.drive.asset.AssetDownloaderProgressListener;
import com.huawei.android.hicloud.drive.asset.AssetMetadataTransport;
import com.huawei.android.hicloud.drive.asset.C2798b;
import com.huawei.android.hicloud.drive.cloudphoto.model.Asset;
import com.huawei.android.hicloud.drive.cloudphoto.model.EndpointUrl;
import com.huawei.android.hicloud.drive.cloudphoto.model.MediaAssetAttribute;
import com.huawei.android.hicloud.drive.cloudphoto.model.Resource;
import com.huawei.android.hicloud.drive.cloudphoto.model.SliceObject;
import com.huawei.android.hicloud.security.bean.UserKeyObject;
import com.huawei.cloud.base.http.C4602e;
import com.huawei.cloud.base.http.C4616s;
import com.huawei.cloud.base.util.C4627a0;
import com.huawei.hicloud.base.drive.model.KeyChain;
import com.huawei.hicloud.base.slice.Slice;
import com.huawei.hicloud.base.slice.SliceEnumeration;
import com.huawei.hicloud.base.slice.SliceItem;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.request.userk.bean.UserKeyBaseReq;
import com.huawei.hms.network.embedded.C5927g2;
import com.huawei.hms.network.embedded.C6148x2;
import com.huawei.hms.network.file.api.Progress;
import com.huawei.hms.network.file.api.Request;
import com.huawei.hms.network.file.api.Response;
import com.huawei.hms.network.file.api.exception.NetWorkErrorException;
import com.huawei.hms.network.file.api.exception.NetworkException;
import com.huawei.hms.network.file.core.Constants;
import com.huawei.hms.network.file.download.api.DownloadManager;
import com.huawei.hms.network.file.download.api.FileRequestCallback;
import com.huawei.hms.network.file.download.api.GetRequest;
import com.huawei.hms.support.api.entity.auth.AuthCode;
import com.huawei.openalliance.p169ad.constant.ParamConstants;
import fk.C9721b;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
import p009a8.C0065c;
import p009a8.C0068f;
import p012ab.C0087b;
import p015ak.C0209d;
import p015ak.C0213f;
import p031b7.C1120a;
import p031b7.C1122c;
import p283fa.C9679b;
import p332ha.C10130a;
import p332ha.C10133d;
import p332ha.EnumC10135f;
import p429kk.C11058a;
import p429kk.C11060c;
import p616rk.AbstractRunnableC12516b;
import p616rk.C12515a;
import p652t9.EnumC12999a;
import p709vj.C13452e;
import p746wn.C13622a;
import p767x9.AbstractC13734c;
import p767x9.C13733b;
import p767x9.C13735d;
import p783xp.C13843a;

/* renamed from: ga.b */
/* loaded from: classes3.dex */
public class C9899b extends AbstractC9898a {

    /* renamed from: A */
    public static final Object f48544A = new Object();

    /* renamed from: B */
    public static final Object f48545B = new Object();

    /* renamed from: a */
    public C4602e f48546a;

    /* renamed from: c */
    public Asset f48548c;

    /* renamed from: e */
    public String f48550e;

    /* renamed from: g */
    public byte[] f48552g;

    /* renamed from: h */
    public byte[] f48553h;

    /* renamed from: i */
    public CountDownLatch f48554i;

    /* renamed from: j */
    public C10133d.b f48555j;

    /* renamed from: l */
    public List<SliceItem<SliceObject>> f48557l;

    /* renamed from: m */
    public long f48558m;

    /* renamed from: q */
    public int f48562q;

    /* renamed from: r */
    public File f48563r;

    /* renamed from: s */
    public AssetDownloaderProgressListener f48564s;

    /* renamed from: t */
    public AssetMetadataTransport f48565t;

    /* renamed from: v */
    public C11060c f48567v;

    /* renamed from: w */
    public Map<String, String> f48568w;

    /* renamed from: x */
    public long f48569x;

    /* renamed from: y */
    public boolean f48570y;

    /* renamed from: z */
    public boolean f48571z;

    /* renamed from: d */
    public int f48549d = 0;

    /* renamed from: f */
    public boolean f48551f = false;

    /* renamed from: k */
    public List<C10133d.b> f48556k = new ArrayList();

    /* renamed from: n */
    public Map<String, Long> f48559n = new HashMap();

    /* renamed from: o */
    public long f48560o = 0;

    /* renamed from: p */
    public C9721b f48561p = null;

    /* renamed from: u */
    public b f48566u = b.NOT_STARTED;

    /* renamed from: b */
    public SQLiteDatabase f48547b = C10130a.m63054c();

    /* renamed from: ga.b$a */
    public class a extends AbstractC13734c {

        /* renamed from: g */
        public final /* synthetic */ C10133d.b f48572g;

        /* renamed from: h */
        public final /* synthetic */ int f48573h;

        /* renamed from: i */
        public final /* synthetic */ EndpointUrl f48574i;

        /* renamed from: j */
        public final /* synthetic */ EnumC12999a f48575j;

        /* renamed from: k */
        public final /* synthetic */ GetRequest.Builder f48576k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(CountDownLatch countDownLatch, C10133d.b bVar, int i10, EndpointUrl endpointUrl, EnumC12999a enumC12999a, GetRequest.Builder builder) {
            super(countDownLatch);
            this.f48572g = bVar;
            this.f48573h = i10;
            this.f48574i = endpointUrl;
            this.f48575j = enumC12999a;
            this.f48576k = builder;
        }

        @Override // p767x9.AbstractC13734c
        /* renamed from: f */
        public void mo61468f(CountDownLatch countDownLatch) {
            GetRequest getRequestM82542l = null;
            try {
                C1120a.m6677i("AssetDownloader", C9899b.this.f48548c.getId() + " SemaphoreDownloadTask begin:" + this.f48572g.m63144x());
                C9899b.this.m61459X();
                getRequestM82542l = C13735d.m82531s().m82542l(this.f48575j, this.f48576k, this.f48572g.m63133B(), C9899b.this.new d(this.f48572g, countDownLatch, true, this.f48573h, this.f48574i), C9899b.this.m61449N(this.f48573h));
                this.f48572g.m63141J(getRequestM82542l.getId()).m63143w().m63109c(C9899b.this.f48547b);
                C9899b.this.m61465d0(countDownLatch, "SemaphoreDownloadTask");
            } catch (C9721b e10) {
                if (this.f48573h == 0 && e10.m60663g() == 404) {
                    C0065c.m432a().m434c(e10.m60663g() + "", C9899b.this.f48550e, C9899b.this.f48569x);
                }
                if (e10.m60663g() == 404 && !C9899b.this.f48570y) {
                    C0065c.m432a().m435d(C9899b.this.f48567v.m66661q(), C9899b.this.f48550e, C9899b.this.f48548c);
                }
                C1120a.m6676e("AssetDownloader", "submitTaskToCloudTaskManager call back: " + e10.toString() + " isShare:" + C9899b.this.f48570y);
                C13735d.m82531s().m82552z(this.f48575j, getRequestM82542l, C9899b.this.m61449N(this.f48573h));
            } catch (Exception e11) {
                C1120a.m6676e("AssetDownloader", "submitTaskToCloudTaskManager Exception: " + e11 + " isShare:" + C9899b.this.f48570y);
                C13735d.m82531s().m82552z(this.f48575j, getRequestM82542l, C9899b.this.m61449N(this.f48573h));
            }
        }
    }

    /* renamed from: ga.b$b */
    public enum b {
        NOT_STARTED,
        OBJECTS_DOWNLOAD_START,
        INIT_USER_KEY,
        OBJECTS_DOWNLOAD_DECRYPT,
        DOWNLOAD_COMPLETED
    }

    /* renamed from: ga.b$c */
    public class c extends AbstractRunnableC12516b {

        /* renamed from: a */
        public C10133d.b f48584a;

        /* renamed from: b */
        public CountDownLatch f48585b;

        public c(C10133d.b bVar, CountDownLatch countDownLatch) {
            this.f48584a = bVar;
            this.f48585b = countDownLatch;
        }

        /* renamed from: c */
        public final void m61469c(File file) throws Throwable {
            try {
                C1120a.m6677i("AssetDownloader", "hmac retryDecrypt start.");
                if (C9899b.this.f48548c.getResource() != null && C9899b.this.f48548c.getResource().getHash() != null && !TextUtils.isEmpty(C9899b.this.f48548c.getResource().getHash())) {
                    String hash = C9899b.this.f48548c.getResource().getHash();
                    C9899b.this.f48552g = C9900c.m61477e(C2798b.m16325f(hash));
                    C9899b.this.f48553h = C9900c.m61477e(C2798b.m16326g(hash));
                    C2798b.m16321b(C9899b.this.f48546a.m28187f(), file, this.f48584a.m63145y(), C9899b.this.f48552g, C9899b.this.f48553h);
                    C1120a.m6677i("AssetDownloader", "hmac retryDecrypt success.");
                    return;
                }
                C9899b.this.m61444I(new C9721b(4309, AuthCode.StatusCode.PERMISSION_NOT_EXIST, "retryDecrypt but asset hash no hash info"));
            } catch (C9721b e10) {
                C1120a.m6676e("AssetDownloader", "hmac retry decrypt file error: " + e10.toString());
                m61470d(file);
                C9899b.this.m61444I(e10);
            } catch (Exception e11) {
                C1120a.m6676e("AssetDownloader", "hmac retry decrypt file exception error: " + e11.toString());
                m61470d(file);
                C9899b.this.m61444I(new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "retry decrypt file exception error:" + e11.toString()));
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r8v3, types: [java.util.concurrent.CountDownLatch] */
        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            C1120a.m6677i("AssetDownloader", "decrypt begin: " + this.f48584a.m63134C());
            C1120a.m6675d("AssetDownloader", "baseDirectory:" + C9899b.this.f48563r);
            File file = new File(C9899b.this.f48563r, this.f48584a.m63134C());
            try {
                try {
                    C2798b.m16321b(C9899b.this.f48546a.m28187f(), file, this.f48584a.m63145y(), C9899b.this.f48552g, C9899b.this.f48553h);
                } catch (C9721b e10) {
                    C1120a.m6676e("AssetDownloader", "decrypt file error: " + e10.toString());
                    if (e10.m60659c() == 4005) {
                        m61469c(file);
                    } else {
                        m61470d(file);
                        C9899b.this.m61444I(e10);
                    }
                } catch (Exception e11) {
                    C1120a.m6676e("AssetDownloader", "decrypt file exception error: " + e11.toString());
                    m61470d(file);
                }
            } finally {
                this.f48585b.countDown();
            }
        }

        /* renamed from: d */
        public final void m61470d(File file) {
            if (file.exists()) {
                C1120a.m6675d("AssetDownloader", "decrypt file exits, delete = " + file.delete());
            }
        }

        @Override // p616rk.AbstractRunnableC12516b
        public AbstractRunnableC12516b.a getEnum() {
            return AbstractRunnableC12516b.a.CLOUD_PHOTO_DRIVE;
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

    /* renamed from: ga.b$d */
    public class d extends FileRequestCallback {

        /* renamed from: a */
        public C10133d.b f48587a;

        /* renamed from: b */
        public CountDownLatch f48588b;

        /* renamed from: c */
        public boolean f48589c;

        /* renamed from: d */
        public int f48590d = 0;

        /* renamed from: e */
        public EndpointUrl f48591e;

        /* renamed from: f */
        public long f48592f;

        /* renamed from: g */
        public int f48593g;

        public d(C10133d.b bVar, CountDownLatch countDownLatch, boolean z10, int i10, EndpointUrl endpointUrl) {
            this.f48587a = bVar;
            this.f48588b = countDownLatch;
            this.f48589c = z10;
            this.f48593g = i10;
            this.f48591e = endpointUrl;
        }

        private void release() {
            CountDownLatch countDownLatch = this.f48588b;
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
        }

        /* renamed from: a */
        public final boolean m61471a(int i10, NetworkException networkException) {
            return this.f48591e.isAccelerated() ? (400 <= i10 && i10 <= 599) || (networkException instanceof NetWorkErrorException) : i10 == 403;
        }

        /* renamed from: b */
        public final void m61472b(String str, String str2, long j10) {
            try {
                C1120a.m6675d("AssetDownloader", "reportObjectInfo " + str + ", " + str2);
                C11060c c11060cM66626a = C11058a.m66626a(C9899b.this.f48567v.m66661q(), "reportObjectInfo", C13452e.m80781L().m80971t0());
                c11060cM66626a.m66665u("0:1");
                c11060cM66626a.m66635A(str);
                c11060cM66626a.m66667w(str2);
                c11060cM66626a.m66638D(String.valueOf(j10));
                C13622a.m81968n(C0213f.m1377a(), c11060cM66626a);
            } catch (Exception e10) {
                C1120a.m6676e("AssetDownloader", "reportObjectInfo Exception " + e10);
            }
        }

        public void onException(GetRequest getRequest, NetworkException networkException, Response<GetRequest, File, Closeable> response) throws C9721b {
            EndpointUrl endpointUrlM61453R;
            C1120a.m6676e("AssetDownloader", "taskId [" + getRequest.getId() + "]slice object [" + this.f48587a.m63144x() + "] cache [" + this.f48587a.m63134C() + "] download error. " + networkException.toString());
            if (this.f48587a.m63132A() == EnumC10135f.SUCCESS.m63179b()) {
                release();
                return;
            }
            int iM1331z = C0209d.m1331z(networkException.getMessage());
            if (!this.f48589c || this.f48590d > 1 || this.f48591e == null || !m61471a(iM1331z, networkException)) {
                String str = networkException + ", " + C9899b.this.m61456U(response) + ", " + C9899b.this.m61455T(response);
                C1120a.m6675d("AssetDownloader", "baseDirectory:" + C9899b.this.f48563r);
                if (iM1331z == Constants.ErrorCode.CREATE_DOWNLOAD_FILE_FAILED.getErrorCode()) {
                    if (!C9899b.this.f48563r.exists() || C9899b.this.f48563r.isFile()) {
                        str = str + ", " + C9899b.this.f48563r + " not exist or is file";
                    }
                    str = str + ", " + C1122c.m6758a0();
                } else if (iM1331z == 404) {
                    m61472b(this.f48587a.m63144x(), this.f48591e.getBucket(), getRequest.getId());
                }
                C9899b.this.m61444I(new C9721b(4307, iM1331z, str, "Download"));
                release();
                return;
            }
            C1120a.m6677i("AssetDownloader", "taskId [" + getRequest.getId() + "]slice object [" + this.f48587a.m63144x() + "] cache [" + this.f48587a.m63134C() + " retry again");
            try {
                Object obj = this.f48591e.get("client_endpointVersion");
                int iIntValue = obj != null ? ((Integer) obj).intValue() : 0;
                if (!this.f48591e.isAccelerated() || iM1331z == 403) {
                    C9899b.this.m61450O(iIntValue);
                    endpointUrlM61453R = C9899b.this.m61453R(this.f48587a.m63144x(), C9899b.this.f48548c);
                } else {
                    endpointUrlM61453R = C9899b.this.m61453R(this.f48587a.m63144x(), C9899b.this.f48548c);
                }
                EndpointUrl endpointUrl = endpointUrlM61453R;
                if (endpointUrl == null) {
                    throw new C9721b(4309, AuthCode.StatusCode.CERT_FINGERPRINT_ERROR, this.f48587a.m63144x() + " has no endpointUrl");
                }
                HashMap map = new HashMap();
                map.put("trace_id", C9899b.this.f48567v.m66661q());
                map.put(C6148x2.DEVICE_ID, C9899b.this.f48550e);
                C1120a.m6677i("AssetDownloader", "report trace_id " + C9899b.this.f48567v.m66661q());
                C1120a.m6675d("AssetDownloader", "baseDirectory:" + C9899b.this.f48563r);
                C13735d.m82531s().m82542l(C9899b.this.m61451P(this.f48593g), DownloadManager.newGetRequestBuilder().filePath(C9899b.this.f48563r + "/" + this.f48587a.m63134C()).offset(getRequest.getOffset()).fileSize(getRequest.getFileSize()).name(this.f48587a.m63134C()).url(endpointUrl.getUrl()).reportInfos(map).headers(endpointUrl.getHeaders()), -1L, C9899b.this.new d(this.f48587a, this.f48588b, false, this.f48593g, endpointUrl), C9899b.this.m61449N(this.f48593g));
                this.f48590d = this.f48590d + 1;
            } catch (C9721b e10) {
                C9899b.this.m61444I(e10);
                release();
            } catch (Exception unused) {
                C9899b.this.m61444I(new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, networkException + ", " + C9899b.this.m61456U(response) + ", " + C9899b.this.m61455T(response), "retryDownload"));
                release();
            }
        }

        @Override // com.huawei.hms.network.file.api.Callback
        public void onSuccess(Response<GetRequest, File, Closeable> response) {
            C1120a.m6677i("AssetDownloader", "taskId [" + ((GetRequest) response.getRequest()).getId() + "]slice object [" + this.f48587a.m63144x() + "] cache [" + this.f48587a.m63134C() + "] download end. cost:" + (System.currentTimeMillis() - this.f48592f));
            C9899b.m61423j(C9899b.this, response.getContent().length());
            Map<String, Object> extraInfo = response.getExtraInfo();
            if (C9899b.this.f48568w != null && extraInfo != null) {
                C9899b.this.f48568w.put("protocol", String.valueOf(extraInfo.get("protocol")));
            }
            try {
                try {
                    C9899b.this.m61459X();
                    int iM63132A = this.f48587a.m63132A();
                    EnumC10135f enumC10135f = EnumC10135f.SUCCESS;
                    if (iM63132A != enumC10135f.m63179b()) {
                        this.f48587a.m63140I(enumC10135f.m63179b()).m63143w().m63109c(C9899b.this.f48547b);
                        C1120a.m6677i("AssetDownloader", "taskId [" + ((GetRequest) response.getRequest()).getId() + "]slice object [" + this.f48587a.m63144x() + "] cache [" + this.f48587a.m63134C() + "] download success");
                    }
                } catch (C9721b e10) {
                    C1120a.m6676e("AssetDownloader", "taskId [" + ((GetRequest) response.getRequest()).getId() + "]slice object [" + this.f48587a.m63144x() + "] cache [" + this.f48587a.m63134C() + "] download error." + e10);
                    C9899b.this.m61444I(e10);
                }
            } finally {
                release();
            }
        }

        @Override // com.huawei.hms.network.file.api.Callback
        public void onProgress(GetRequest getRequest, Progress progress) {
            C1120a.m6675d("AssetDownloader", "slice object [" + this.f48587a.m63144x() + "] download progress = " + progress.getProgress() + "size = " + progress.getFinishedSize());
            if (C9899b.this.f48564s != null) {
                C9899b.this.f48559n.put(this.f48587a.m63144x(), Long.valueOf(progress.getFinishedSize()));
                C9899b.this.f48564s.progressChanged(C9899b.this);
            }
        }

        @Override // com.huawei.hms.network.file.api.Callback
        public GetRequest onStart(GetRequest getRequest) {
            C1120a.m6677i("AssetDownloader", "taskId [" + getRequest.getId() + "]slice object [" + this.f48587a.m63144x() + "] cache [" + this.f48587a.m63134C() + "] get download address.");
            this.f48592f = System.currentTimeMillis();
            try {
                EndpointUrl endpointUrl = this.f48591e;
                if (endpointUrl != null && endpointUrl.getHeaders() != null && this.f48591e.getUrl() != null) {
                    C1120a.m6675d("AssetDownloader", "endpointUrl: " + this.f48591e.getUrl());
                    C9899b.this.f48567v.m66667w(C13843a.m83101w(this.f48591e.getUrl()));
                    return getRequest.newBuilder().url(this.f48591e.getUrl()).headers(this.f48591e.getHeaders()).build();
                }
                C1120a.m6676e("AssetDownloader", "endpointUrl is invalid.");
                C9899b.this.m61444I(new C9721b(4309, AuthCode.StatusCode.CERT_FINGERPRINT_ERROR, "endpointUrl is null"));
                return getRequest;
            } catch (Exception e10) {
                C1120a.m6676e("AssetDownloader", "taskId [" + getRequest.getId() + "]slice object [" + this.f48587a.m63144x() + "] cache [" + this.f48587a.m63134C() + "] get download address error." + e10);
                C9899b.this.m61444I(new C9721b(4309, e10.toString()));
                return getRequest;
            }
        }

        @Override // com.huawei.hms.network.file.api.Callback
        public /* bridge */ /* synthetic */ void onException(Request request, NetworkException networkException, Response response) throws C9721b {
            onException((GetRequest) request, networkException, (Response<GetRequest, File, Closeable>) response);
        }
    }

    public C9899b(AssetMetadataTransport assetMetadataTransport, String str, Asset asset, long j10, boolean z10, boolean z11, int i10) {
        this.f48571z = false;
        this.f48565t = assetMetadataTransport;
        this.f48548c = asset;
        this.f48550e = str;
        this.f48569x = j10;
        this.f48570y = z10;
        this.f48571z = z11;
        this.f48562q = i10;
        this.f48563r = m61411b(i10);
    }

    /* renamed from: j */
    public static /* synthetic */ long m61423j(C9899b c9899b, long j10) {
        long j11 = c9899b.f48560o + j10;
        c9899b.f48560o = j11;
        return j11;
    }

    /* renamed from: E */
    public void m61440E(long j10, int i10, String str) {
        try {
            Map<String, Long> map = SyncSessionManager.m15153t().m15189m().get(str);
            if (map == null) {
                C1120a.m6676e("AssetDownloader", "download rate,calBatchDownloadInfo error.");
                return;
            }
            map.put("downloadBatchSize", Long.valueOf((map.get("downloadBatchSize") != null ? map.get("downloadBatchSize").longValue() : 0L) + j10));
            map.put("downloadEndTime", Long.valueOf(System.currentTimeMillis()));
            C1120a.m6677i("AssetDownloader", "calBatchDownloadInfo, traceId:" + str + ",fileSize:" + j10 + ",thumbType:" + i10);
        } catch (Exception unused) {
            C1120a.m6676e("AssetDownloader", "download rate,calBatchDownloadInfo exception.");
        }
    }

    /* renamed from: F */
    public final void m61441F(byte[] bArr) throws C9721b, SQLException {
        C1120a.m6677i("AssetDownloader", "decryptSlices");
        C1120a.m6677i("AssetDownloader", "encrypt file [" + C1122c.m6818p0(this.f48546a.m28187f().getName()) + "] all slices download success, begin to decrypt slices.");
        m61459X();
        try {
            this.f48552g = C9900c.m61477e(C9900c.m61474b(this.f48548c.getCipher().getKeyChains().get(0).getEkey(), bArr));
            this.f48553h = C9900c.m61477e(this.f48548c.getCipher().getIv());
            C1120a.m6677i("AssetDownloader", "slices size = " + this.f48556k.size());
            this.f48554i = new CountDownLatch(this.f48556k.size());
            ArrayList arrayList = new ArrayList();
            boolean z10 = this.f48556k.size() > 2;
            Iterator<C10133d.b> it = this.f48556k.iterator();
            while (it.hasNext()) {
                c cVar = new c(it.next(), this.f48554i);
                arrayList.add(cVar);
                if (z10) {
                    C12515a.m75110o().m75172d(cVar);
                } else {
                    cVar.run();
                }
            }
            if (z10) {
                try {
                    m61465d0(this.f48554i, "decryptSlices");
                } finally {
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        ((c) it2.next()).cancel();
                    }
                }
            }
            m61466e0();
            C1120a.m6675d("AssetDownloader", "decrypt file [" + C1122c.m6818p0(this.f48546a.m28187f().getName()) + "] end");
        } catch (Exception e10) {
            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_OPENED, "compute file key and iv error: " + e10.getMessage());
        }
    }

    /* renamed from: G */
    public final void m61442G(int i10) throws C9721b {
        int i11;
        C1120a.m6677i("AssetDownloader", "doDownload");
        int size = this.f48557l.size();
        List<C10133d.b> listM63108b = this.f48555j.m63143w().m63108b(this.f48547b);
        this.f48554i = new CountDownLatch(size);
        ArrayList arrayList = new ArrayList();
        long j10 = 0;
        int i12 = 0;
        while (i12 < size) {
            m61459X();
            SliceItem<SliceObject> sliceItem = this.f48557l.get(i12);
            C10133d.b bVarM63137F = new C10133d.b(this.f48548c.getId()).m63139H(this.f48555j.m63146z()).m63136E(i12).m63138G(j10).m63142K(UUID.randomUUID().toString()).m63137F(sliceItem.getObject().getId());
            long length = j10 + (!TextUtils.isEmpty(this.f48548c.getName()) ? sliceItem.getLength() : this.f48548c.getResource().getSliceSize().longValue());
            Iterator<C10133d.b> it = listM63108b.iterator();
            while (it.hasNext() && !bVarM63137F.equals(it.next())) {
            }
            this.f48556k.add(bVarM63137F);
            if (bVarM63137F.m63132A() == EnumC10135f.SUCCESS.m63179b()) {
                C1120a.m6675d("AssetDownloader", "baseDirectory:" + this.f48563r);
                if (new File(this.f48563r + "/" + bVarM63137F.m63134C()).exists()) {
                    this.f48554i.countDown();
                    if (this.f48564s != null) {
                        this.f48559n.put(sliceItem.getObject().getId(), Long.valueOf(sliceItem.getLength()));
                        this.f48564s.progressChanged(this);
                    }
                    C1120a.m6675d("AssetDownloader", "slice object [" + bVarM63137F.m63144x() + "] already download.");
                    i11 = i12;
                    i12 = i11 + 1;
                    j10 = length;
                } else {
                    C1120a.m6675d("AssetDownloader", "slice object [" + bVarM63137F.m63144x() + "] download cache has been deleted.");
                    bVarM63137F.m63135D();
                }
            }
            EndpointUrl endpointUrlM61446K = m61446K(bVarM63137F.m63144x(), this.f48548c);
            if (endpointUrlM61446K == null) {
                throw new C9721b(4309, AuthCode.StatusCode.CERT_FINGERPRINT_ERROR, bVarM63137F.m63144x() + " has no endpointUrl");
            }
            HashMap map = new HashMap();
            map.put("trace_id", this.f48567v.m66661q());
            map.put(C6148x2.DEVICE_ID, this.f48550e);
            C1120a.m6677i("AssetDownloader", "report trace_id " + this.f48567v.m66661q());
            C1120a.m6675d("AssetDownloader", "baseDirectory:" + this.f48563r);
            i11 = i12;
            GetRequest.Builder builderEnableSlice = DownloadManager.newGetRequestBuilder().filePath(this.f48563r + "/" + bVarM63137F.m63134C()).offset(sliceItem.getOffset()).fileSize(sliceItem.getLength()).name(bVarM63137F.m63134C()).config(C13735d.m82529f(m61448M(i10, sliceItem.getLength()))).url(endpointUrlM61446K.getUrl()).headers(endpointUrlM61446K.getHeaders()).reportInfos(map).enableSlice(false);
            EnumC12999a enumC12999aM61451P = m61451P(i10);
            a aVar = new a(this.f48554i, bVarM63137F, i10, endpointUrlM61446K, enumC12999aM61451P, builderEnableSlice);
            try {
                arrayList.add(aVar);
                C13733b.m82520a().m82523d(enumC12999aM61451P, aVar);
                i12 = i11 + 1;
                j10 = length;
            } catch (InterruptedException e10) {
                C1120a.m6676e("AssetDownloader", "semaphore execute error" + e10.toString());
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    ((AbstractC13734c) it2.next()).m82517c(true);
                }
                this.f48551f = true;
                m61444I(new C9721b(1001, "thread has been interrupted"));
            }
        }
        C1120a.m6677i("AssetDownloader", "doDownload end");
        try {
            m61465d0(this.f48554i, "doDownload");
        } catch (C9721b e11) {
            C1120a.m6676e("AssetDownloader", "syncLock: " + e11.toString());
            throw e11;
        }
    }

    /* renamed from: H */
    public void m61443H(File file, Asset asset, int i10) throws C9721b {
        C1120a.m6677i("AssetDownloader", "download file start " + asset.getId() + " name:" + asset.getName());
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            this.f48546a = new C4602e("", file);
            m61467f0(b.INIT_USER_KEY);
            if (asset.getResource() == null) {
                m61450O(this.f48549d);
            }
            m61462a0(asset);
            byte[] bArrM61452Q = m61452Q();
            m61460Y();
            m61459X();
            m61467f0(b.OBJECTS_DOWNLOAD_START);
            m61442G(i10);
            m61467f0(b.OBJECTS_DOWNLOAD_DECRYPT);
            m61441F(bArrM61452Q);
            m61467f0(b.DOWNLOAD_COMPLETED);
            this.f48567v.m66635A("success");
            this.f48567v.m66640F(String.valueOf(this.f48560o));
            this.f48567v.m66642H(String.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
            m61440E(this.f48560o, i10, this.f48567v.m66661q());
            C1120a.m6677i("AssetDownloader", "download file end.");
        } catch (C9721b e10) {
            C1120a.m6676e("AssetDownloader", "download file end CException:" + e10.toString());
            this.f48567v.m66640F(String.valueOf(this.f48560o));
            throw e10;
        } catch (RuntimeException e11) {
            C1120a.m6676e("AssetDownloader", "download file end RuntimeException:" + e11.toString());
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, e11.toString());
        }
    }

    /* renamed from: I */
    public final void m61444I(C9721b c9721b) {
        synchronized (f48544A) {
            try {
                if (this.f48561p == null) {
                    this.f48561p = c9721b;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: J */
    public final List<SliceItem<SliceObject>> m61445J(MediaAssetAttribute mediaAssetAttribute) throws C9721b {
        ArrayList arrayList = new ArrayList();
        SliceEnumeration<SliceObject> sliceEnumerationM61457V = m61457V(this.f48548c.getResource().getObjects(), mediaAssetAttribute, false);
        if (sliceEnumerationM61457V.hasMoreSlices()) {
            if (mediaAssetAttribute == null || mediaAssetAttribute.getLength() == null) {
                throw new C9721b(4310, "attribute length invalid");
            }
            for (SliceItem<SliceObject> sliceItem : sliceEnumerationM61457V.nextSlice(mediaAssetAttribute.getLength().getSmall().longValue()).getSliceItems()) {
                if (!this.f48548c.getName().equals("small")) {
                    break;
                }
                arrayList.add(sliceItem);
            }
        }
        if (sliceEnumerationM61457V.hasMoreSlices()) {
            if (mediaAssetAttribute == null || mediaAssetAttribute.getLength() == null) {
                throw new C9721b(4310, "attribute length invalid");
            }
            for (SliceItem<SliceObject> sliceItem2 : sliceEnumerationM61457V.nextSlice(mediaAssetAttribute.getLength().getLarge().longValue()).getSliceItems()) {
                if (!this.f48548c.getName().equals("large")) {
                    break;
                }
                arrayList.add(sliceItem2);
            }
        }
        return arrayList;
    }

    /* renamed from: K */
    public final EndpointUrl m61446K(String str, Asset asset) {
        synchronized (f48545B) {
            try {
                for (SliceObject sliceObject : asset.getResource().getObjects()) {
                    if (sliceObject.getId().equals(str)) {
                        EndpointUrl endpointUrlM61447L = m61447L(sliceObject);
                        endpointUrlM61447L.set("client_endpointVersion", (Object) Integer.valueOf(this.f48549d));
                        return endpointUrlM61447L;
                    }
                }
                return null;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: L */
    public final EndpointUrl m61447L(SliceObject sliceObject) {
        if (sliceObject.getAccelerateDownloadUrl() == null) {
            Map<String, String> map = this.f48568w;
            if (map != null) {
                map.put("accelerate", "0");
                this.f48568w.put(C5927g2.QUIC, this.f48571z ? "1" : "0");
            }
            EndpointUrl downloadUrl = sliceObject.getDownloadUrl();
            downloadUrl.setBucket(sliceObject.getBucket());
            return downloadUrl;
        }
        Map<String, String> map2 = this.f48568w;
        if (map2 != null) {
            map2.put("accelerate", "1");
            this.f48568w.put(C5927g2.QUIC, this.f48571z ? "1" : "0");
        }
        EndpointUrl accelerateDownloadUrl = sliceObject.getAccelerateDownloadUrl();
        accelerateDownloadUrl.setAccelerated(true);
        accelerateDownloadUrl.setBucket(sliceObject.getBucket());
        return accelerateDownloadUrl;
    }

    /* renamed from: M */
    public final String m61448M(int i10, long j10) throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            if (i10 == 0) {
                jSONObject.put("complete_file_size", this.f48569x);
            } else {
                jSONObject.put("complete_file_size", j10);
            }
            return jSONObject.toString();
        } catch (Exception unused) {
            C1120a.m6678w("AssetDownloader", "getDownloadFileSize");
            return null;
        }
    }

    /* renamed from: N */
    public final String m61449N(int i10) throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("scene", String.valueOf(i10));
            return jSONObject.toString();
        } catch (Exception unused) {
            C1120a.m6678w("AssetDownloader", "getDownloadScene");
            return null;
        }
    }

    /* renamed from: O */
    public final void m61450O(int i10) throws C9721b {
        C1120a.m6677i("AssetDownloader", "getDownloadUrl");
        Asset asset = new Asset();
        Resource resource = new Resource();
        resource.setId(this.f48548c.getId());
        asset.setResource(resource);
        try {
            synchronized (f48545B) {
                try {
                    if (i10 == this.f48549d) {
                        this.f48548c.setResource(this.f48565t.onRefreshDownloadUrl(this.f48550e, this.f48548c.getId(), this.f48548c.getVersionId(), asset));
                        this.f48549d++;
                    } else {
                        C1120a.m6677i("AssetDownloader", "downloadUrlVersion is " + i10 + " is not equal to resourceVersion " + this.f48549d);
                    }
                } finally {
                }
            }
        } catch (C4616s e10) {
            C1120a.m6676e("AssetDownloader", "getDownloadUrl HttpResponseException result : " + e10.toString());
            throw new C9721b(4312, e10.m28322f(), e10.m28319c(), "assets.revisions.get", C1160a.m7253d(e10));
        } catch (IOException e11) {
            throw new C9721b(4313, "getDownload Url error: " + e11.getMessage());
        }
    }

    /* renamed from: P */
    public final EnumC12999a m61451P(int i10) {
        C1120a.m6677i("AssetDownloader", "getHiCloudType isUseQuic = " + this.f48571z + ", thumbType = " + i10);
        return this.f48571z ? i10 == 0 ? EnumC12999a.CLOUD_ALBUM_DRIVE_QUIC : EnumC12999a.CLOUD_THUMNAIL_QUIC : i10 == 0 ? EnumC12999a.CLOUD_ALBUM_DRIVE : EnumC12999a.CLOUD_THUMNAIL;
    }

    /* renamed from: Q */
    public final byte[] m61452Q() throws C9721b {
        C1120a.m6677i("AssetDownloader", "getMatchUserKey");
        if (this.f48548c.getCipher() == null) {
            throw new C9721b(4309, AuthCode.StatusCode.AUTH_INFO_NOT_EXIST, "file content has no Cipher");
        }
        List<KeyChain> keyChains = this.f48548c.getCipher().getKeyChains();
        if (keyChains == null || keyChains.size() == 0) {
            throw new C9721b(4309, AuthCode.StatusCode.AUTH_INFO_NOT_EXIST, "file content has no keyChains in Cipher");
        }
        String id2 = keyChains.get(0).getId();
        C0087b c0087b = new C0087b(C9679b.m60452d().m60455e(), C1122c.m6833t0(C0213f.m1377a()));
        UserKeyObject userKeyObjectM680c = c0087b.m680c(this.f48567v.m66661q(), 12, UserKeyBaseReq.KEY_TYPE_AES_128);
        String userKeyGuid = userKeyObjectM680c.getUserKeyGuid();
        if (TextUtils.isEmpty(id2) || id2.equals(userKeyGuid)) {
            return userKeyObjectM680c.getUserKey();
        }
        UserKeyObject userKeyObjectM681d = c0087b.m681d(this.f48567v.m66661q(), 12, UserKeyBaseReq.KEY_TYPE_AES_256);
        String userKeyGuid2 = userKeyObjectM681d.getUserKeyGuid();
        if (id2.equals(userKeyGuid2)) {
            return userKeyObjectM681d.getUserKey();
        }
        C1122c.m6829s();
        throw new C9721b(4309, AuthCode.StatusCode.WAITING_CONNECT, "no match userKey." + id2 + "_" + userKeyGuid + "_" + userKeyGuid2);
    }

    /* renamed from: R */
    public final EndpointUrl m61453R(String str, Asset asset) {
        synchronized (f48545B) {
            try {
                for (SliceObject sliceObject : asset.getResource().getObjects()) {
                    if (sliceObject.getId().equals(str)) {
                        EndpointUrl downloadUrl = sliceObject.getDownloadUrl();
                        downloadUrl.set("client_endpointVersion", (Object) Integer.valueOf(this.f48549d));
                        return downloadUrl;
                    }
                }
                return null;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: S */
    public long m61454S() {
        Iterator<Long> it = this.f48559n.values().iterator();
        long jLongValue = 0;
        while (it.hasNext()) {
            jLongValue += it.next().longValue();
        }
        return jLongValue;
    }

    /* renamed from: T */
    public final String m61455T(Response<GetRequest, File, Closeable> response) {
        com.huawei.hms.network.httpclient.Response response2;
        if (response != null) {
            try {
                response2 = (com.huawei.hms.network.httpclient.Response) response.getRawResponse();
            } catch (Exception unused) {
                return "";
            }
        } else {
            response2 = null;
        }
        return response2 != null ? new String(response2.getErrorBody().bytes(), StandardCharsets.UTF_8) : "";
    }

    /* renamed from: U */
    public final String m61456U(Response<GetRequest, File, Closeable> response) {
        return (response == null || response.getResponseHeader() == null) ? "" : response.getResponseHeader().toString();
    }

    /* renamed from: V */
    public final SliceEnumeration<SliceObject> m61457V(List<SliceObject> list, MediaAssetAttribute mediaAssetAttribute, boolean z10) throws C9721b {
        long jLongValue;
        C1120a.m6675d("AssetDownloader", "get slice enumeration by objects.");
        Resource resource = this.f48548c.getResource();
        long jLongValue2 = (resource.getType().intValue() == 6 ? resource.getCompressedSize() : resource.getLength()).longValue();
        Long sliceSize = this.f48548c.getResource().getSliceSize();
        if (sliceSize == null) {
            sliceSize = Long.MAX_VALUE;
        }
        long jLongValue3 = ((jLongValue2 - 1) / sliceSize.longValue()) + 1;
        C4627a0.m28395h(((long) list.size()) >= jLongValue3, "objects is not valid.");
        if (z10) {
            jLongValue = jLongValue2 % sliceSize.longValue() == 0 ? sliceSize.longValue() : jLongValue2 % sliceSize.longValue();
        } else {
            if (mediaAssetAttribute == null || mediaAssetAttribute.getLength() == null) {
                throw new C9721b(4310, "attribute length invalid");
            }
            long jLongValue4 = mediaAssetAttribute.getLength().getLarge().longValue() + mediaAssetAttribute.getLength().getSmall().longValue();
            jLongValue3 = ((jLongValue4 - 1) / sliceSize.longValue()) + 1;
            jLongValue = jLongValue4 % sliceSize.longValue() == 0 ? sliceSize.longValue() : jLongValue4 % sliceSize.longValue();
        }
        return new SliceEnumeration<>(list, new C9901d(jLongValue3, sliceSize.longValue(), jLongValue));
    }

    /* renamed from: W */
    public long m61458W() {
        return this.f48558m;
    }

    /* renamed from: X */
    public final void m61459X() throws C9721b {
        if (this.f48551f) {
            throw new C9721b(1001, "user cancel.");
        }
        C9721b c9721b = this.f48561p;
        if (c9721b != null) {
            throw c9721b;
        }
        C0068f.m459d().m468l();
    }

    /* renamed from: Y */
    public final void m61460Y() throws C9721b {
        C1120a.m6677i("AssetDownloader", ParamConstants.CallbackMethod.ON_PREPARE);
        this.f48555j = new C10133d.b(this.f48548c.getId()).m63139H(this.f48546a.m28187f().getPath());
        List<SliceObject> objects = this.f48548c.getResource().getObjects();
        if (objects == null || objects.size() == 0) {
            throw new C9721b(4001, "file content has no objectInfoList");
        }
        MediaAssetAttribute attributes = this.f48548c.getResource().getAttributes();
        if (attributes == null || attributes.getLength() == null) {
            attributes = this.f48548c.getAttributes();
        }
        boolean zIsEmpty = TextUtils.isEmpty(this.f48548c.getName());
        Resource resource = this.f48548c.getResource();
        long jLongValue = (resource.getType().intValue() == 6 ? resource.getCompressedSize() : resource.getLength()).longValue();
        if (!zIsEmpty) {
            if (jLongValue == -1) {
                throw new C9721b(4310, "no attachment length");
            }
            this.f48557l = m61445J(attributes);
        } else {
            SliceEnumeration<SliceObject> sliceEnumerationM61457V = m61457V(this.f48548c.getResource().getObjects(), attributes, true);
            if (!sliceEnumerationM61457V.hasMoreSlices()) {
                throw new C9721b(4001, "amount of files does not match with dbank_s3_file");
            }
            Slice<SliceObject> sliceNextSlice = sliceEnumerationM61457V.nextSlice(jLongValue);
            this.f48558m = sliceNextSlice.getLength();
            this.f48557l = sliceNextSlice.getSliceItems();
        }
    }

    /* renamed from: Z */
    public void m61461Z(AssetDownloaderProgressListener assetDownloaderProgressListener) {
        this.f48564s = assetDownloaderProgressListener;
    }

    /* renamed from: a0 */
    public final void m61462a0(Asset asset) {
        String str;
        String strValueOf;
        String id2;
        str = "";
        if (asset != null) {
            String id3 = asset.getId();
            if (asset.getResource() != null) {
                id2 = asset.getResource().getId();
                strValueOf = asset.getResource().getType() != null ? String.valueOf(asset.getResource().getType()) : "";
            } else {
                strValueOf = "";
                id2 = strValueOf;
            }
            str = id3;
        } else {
            strValueOf = "";
            id2 = strValueOf;
        }
        this.f48567v.m66638D(str + "_" + this.f48550e + "_" + id2 + "_" + strValueOf);
    }

    /* renamed from: b0 */
    public void m61463b0(C11060c c11060c) {
        this.f48567v = c11060c;
    }

    /* renamed from: c0 */
    public void m61464c0(Map<String, String> map) {
        this.f48568w = map;
    }

    /* renamed from: d0 */
    public final void m61465d0(CountDownLatch countDownLatch, String str) throws C9721b {
        m61459X();
        int i10 = 0;
        while (countDownLatch.getCount() > 0 && !this.f48551f && this.f48561p == null) {
            try {
                if (countDownLatch.await(400L, TimeUnit.MILLISECONDS)) {
                    C1120a.m6677i("AssetDownloader", "syncLock await success, cmd " + str);
                } else if (i10 % 5 == 0) {
                    C1120a.m6677i("AssetDownloader", "syncLock await, cmd " + str);
                }
                i10++;
            } catch (InterruptedException e10) {
                C1120a.m6678w("AssetDownloader", "lock wait error." + e10);
                this.f48561p = new C9721b(1001, "thread has been interrupted");
            }
        }
        C9721b c9721b = this.f48561p;
        if (c9721b != null) {
            throw c9721b;
        }
        m61459X();
    }

    /* renamed from: e0 */
    public final void m61466e0() throws SQLException {
        C1120a.m6675d("AssetDownloader", "trash begin");
        Iterator<C10133d.b> it = this.f48556k.iterator();
        while (it.hasNext()) {
            String strM63134C = it.next().m63134C();
            if (strM63134C != null && !strM63134C.isEmpty()) {
                File file = new File(this.f48563r, strM63134C);
                if (file.exists()) {
                    C1120a.m6675d("AssetDownloader", "finally cache file exits, delete = " + file.delete());
                }
            }
        }
        C10133d.b bVar = this.f48555j;
        if (bVar != null) {
            bVar.m63143w().m63107a(this.f48547b);
        }
    }

    /* renamed from: f0 */
    public void m61467f0(b bVar) {
        this.f48566u = bVar;
        AssetDownloaderProgressListener assetDownloaderProgressListener = this.f48564s;
        if (assetDownloaderProgressListener != null) {
            assetDownloaderProgressListener.progressChanged(this);
        }
    }
}
