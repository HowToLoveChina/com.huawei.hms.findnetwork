package com.huawei.android.hicloud.drive.asset;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import bb.C1160a;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.huawei.android.hicloud.album.service.logic.manager.SyncSessionManager;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.drive.asset.AssetMetadataTransport;
import com.huawei.android.hicloud.drive.asset.C2798b;
import com.huawei.android.hicloud.drive.cloudphoto.model.Asset;
import com.huawei.android.hicloud.drive.cloudphoto.model.Cipher;
import com.huawei.android.hicloud.drive.cloudphoto.model.EndpointUrl;
import com.huawei.android.hicloud.drive.cloudphoto.model.MediaAssetAttribute;
import com.huawei.android.hicloud.drive.cloudphoto.model.Resource;
import com.huawei.android.hicloud.drive.cloudphoto.model.SliceObject;
import com.huawei.android.hicloud.p081cs.bean.Thumbnail;
import com.huawei.android.hicloud.security.bean.UserKeyObject;
import com.huawei.cloud.base.http.C4616s;
import com.huawei.cloud.base.util.C4627a0;
import com.huawei.hicloud.base.drive.model.KeyChain;
import com.huawei.hicloud.base.slice.FileLengthGetter;
import com.huawei.hicloud.base.slice.Slice;
import com.huawei.hicloud.base.slice.SliceEnumeration;
import com.huawei.hicloud.base.slice.SliceItem;
import com.huawei.hicloud.base.slice.Slices;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.request.userk.bean.UserKeyBaseReq;
import com.huawei.hms.network.embedded.C6148x2;
import com.huawei.hms.network.file.api.Progress;
import com.huawei.hms.network.file.api.Response;
import com.huawei.hms.network.file.api.Result;
import com.huawei.hms.network.file.api.exception.NetworkException;
import com.huawei.hms.network.file.upload.api.BodyRequest;
import com.huawei.hms.network.file.upload.api.FileEntity;
import com.huawei.hms.network.file.upload.api.FileUploadCallback;
import com.huawei.hms.network.file.upload.api.PutRequest;
import com.huawei.hms.support.api.entity.auth.AuthCode;
import fk.C9720a;
import fk.C9721b;
import ga.AbstractC9898a;
import ga.C9900c;
import hk.C10279b;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;
import p009a8.C0068f;
import p012ab.C0087b;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0241z;
import p031b7.C1120a;
import p031b7.C1122c;
import p283fa.C9679b;
import p292fn.C9733f;
import p332ha.C10130a;
import p332ha.C10134e;
import p429kk.C11058a;
import p429kk.C11060c;
import p616rk.AbstractRunnableC12516b;
import p616rk.C12515a;
import p652t9.EnumC12999a;
import p709vj.C13452e;
import p746wn.C13622a;
import p767x9.C13735d;
import p783xp.C13843a;

/* renamed from: com.huawei.android.hicloud.drive.asset.a */
/* loaded from: classes3.dex */
public class C2797a extends AbstractC9898a {

    /* renamed from: D */
    public static final Gson f12152D = new GsonBuilder().create();

    /* renamed from: E */
    public static final Object f12153E = new Object();

    /* renamed from: F */
    public static final Object f12154F = new Object();

    /* renamed from: A */
    public C11060c f12155A;

    /* renamed from: C */
    public boolean f12157C;

    /* renamed from: a */
    public AssetMetadataTransport f12158a;

    /* renamed from: b */
    public Asset f12159b;

    /* renamed from: c */
    public File f12160c;

    /* renamed from: d */
    public Thumbnail[] f12161d;

    /* renamed from: g */
    public String f12164g;

    /* renamed from: h */
    public byte[] f12165h;

    /* renamed from: i */
    public byte[] f12166i;

    /* renamed from: j */
    public String f12167j;

    /* renamed from: k */
    public String f12168k;

    /* renamed from: l */
    public String f12169l;

    /* renamed from: m */
    public UserKeyObject f12170m;

    /* renamed from: n */
    public UserKeyObject f12171n;

    /* renamed from: q */
    public CountDownLatch f12174q;

    /* renamed from: s */
    public AssetUploaderProgressListener f12176s;

    /* renamed from: t */
    public long f12177t;

    /* renamed from: x */
    public long f12181x;

    /* renamed from: z */
    public String f12183z;

    /* renamed from: f */
    public boolean f12163f = false;

    /* renamed from: o */
    public List<Long> f12172o = new ArrayList();

    /* renamed from: p */
    public List<String> f12173p = new ArrayList();

    /* renamed from: r */
    public C9721b f12175r = null;

    /* renamed from: u */
    public long f12178u = 0;

    /* renamed from: v */
    public Map<String, Long> f12179v = new HashMap();

    /* renamed from: w */
    public File f12180w = m61410a();

    /* renamed from: y */
    public c f12182y = c.NOT_STARTED;

    /* renamed from: B */
    public boolean f12156B = false;

    /* renamed from: e */
    public SQLiteDatabase f12162e = C10130a.m63054c();

    /* renamed from: com.huawei.android.hicloud.drive.asset.a$a */
    public class a extends TypeToken<Map<String, String>> {
        public a() {
        }
    }

    /* renamed from: com.huawei.android.hicloud.drive.asset.a$b */
    public class b extends FileUploadCallback {

        /* renamed from: a */
        public Slice<File> f12185a;

        /* renamed from: b */
        public C10134e.b f12186b;

        /* renamed from: c */
        public CountDownLatch f12187c;

        /* renamed from: d */
        public long f12188d = -1;

        public b(Slice<File> slice, C10134e.b bVar, CountDownLatch countDownLatch) {
            this.f12185a = slice;
            this.f12186b = bVar;
            this.f12187c = countDownLatch;
        }

        /* renamed from: d */
        private void m16315d() {
            CountDownLatch countDownLatch = this.f12187c;
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
            Slice<File> slice = this.f12185a;
            if (slice != null) {
                Iterator<SliceItem<File>> it = slice.getSliceItems().iterator();
                while (it.hasNext()) {
                    File object = it.next().getObject();
                    if (object.exists()) {
                        C1120a.m6675d("AssetUploader", "encrypt file exits, delete = " + object.delete());
                    }
                }
            }
        }

        @Override // com.huawei.hms.network.file.api.Callback
        /* renamed from: a */
        public void onException(BodyRequest bodyRequest, NetworkException networkException, Response<BodyRequest, String, Closeable> response) {
            C1120a.m6676e("AssetUploader", "taskId [" + bodyRequest.getId() + "]slice object [" + this.f12186b.m63173u() + "] upload error." + networkException.toString());
            int iM1331z = C0209d.m1331z(networkException.getMessage());
            C2797a.this.m16260L(new C9721b(4307, iM1331z, networkException + ", " + C2797a.this.m16262O(response) + ", " + C2797a.this.m16261N(response), "Upload"));
            m16315d();
        }

        @Override // com.huawei.hms.network.file.api.Callback
        /* renamed from: b */
        public void onProgress(BodyRequest bodyRequest, Progress progress) {
            C1120a.m6677i("AssetUploader", "taskId [" + bodyRequest.getId() + "]slice object [" + this.f12186b.m63173u() + "] upload progress = " + progress.getProgress() + ", finishedSize = " + progress.getFinishedSize() + ", totalSize = " + progress.getTotalSize() + ", speed = " + progress.getSpeed());
            synchronized (C2797a.f12153E) {
                try {
                    if (C2797a.this.f12176s != null) {
                        if (this.f12188d > 0) {
                            C2797a.this.f12181x = (progress.getFinishedSize() * 1000) / (System.currentTimeMillis() - this.f12188d);
                            this.f12188d = -1L;
                            C1120a.m6677i("AssetUploader", "taskId [" + bodyRequest.getId() + "]slice object [" + this.f12186b.m63173u() + "] upload first speed = " + C2797a.this.f12181x);
                        } else {
                            C2797a.this.f12181x = progress.getSpeed();
                        }
                        C2797a.this.f12179v.put(this.f12186b.m63173u(), Long.valueOf(progress.getFinishedSize()));
                        C2797a.this.f12176s.mo16255a(C2797a.this);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // com.huawei.hms.network.file.api.Callback
        /* renamed from: c */
        public BodyRequest onStart(BodyRequest bodyRequest) {
            C1120a.m6677i("AssetUploader", "taskId [" + bodyRequest.getId() + "]slice object [" + this.f12186b.m63173u() + "] get upload address.");
            try {
                this.f12188d = System.currentTimeMillis();
                C2797a.this.m16263W();
                C2797a.this.m16289H(this.f12186b.m63173u(), this.f12185a, new AssetMetadataTransport.C2796a());
                EndpointUrl endpointUrlM16296R = C2797a.this.m16296R(C2797a.this.m16294P(this.f12186b.m63173u(), C2797a.this.f12159b.getResource().getObjects()));
                if (endpointUrlM16296R == null) {
                    C1120a.m6677i("AssetUploader", "taskId [" + bodyRequest.getId() + "]slice object [" + this.f12186b.m63173u() + "] get upload url error.");
                    C2797a.this.m16260L(new C9721b(4309, "sliceObject has no upload url"));
                    return bodyRequest;
                }
                String url = endpointUrlM16296R.getUrl();
                BodyRequest bodyRequest2 = (BodyRequest) bodyRequest.newBuilder().url(url).headers(endpointUrlM16296R.getHeaders()).build();
                try {
                    C1120a.m6675d("AssetUploader", "taskId [" + bodyRequest2.getId() + "]originalUrl: " + url);
                    C2797a.this.f12155A.m66667w(C13843a.m83101w(bodyRequest2.getUrl()));
                    return bodyRequest2;
                } catch (C9721b e10) {
                    e = e10;
                    bodyRequest = bodyRequest2;
                    C1120a.m6676e("AssetUploader", "taskId [" + bodyRequest.getId() + "]slice object [" + this.f12186b.m63173u() + "] get upload address error." + e.toString());
                    C2797a.this.m16260L(e);
                    return bodyRequest;
                } catch (Exception e11) {
                    e = e11;
                    bodyRequest = bodyRequest2;
                    C1120a.m6676e("AssetUploader", "taskId [" + bodyRequest.getId() + "]slice object [" + this.f12186b.m63173u() + "] get upload address error." + e.toString());
                    C2797a.this.m16260L(new C9721b(4309, e.getMessage()));
                    return bodyRequest;
                }
            } catch (C9721b e12) {
                e = e12;
            } catch (Exception e13) {
                e = e13;
            }
        }

        /* renamed from: e */
        public final void m16319e(String str, String str2) {
            try {
                C1120a.m6675d("AssetUploader", "reportUploadProgress " + str + ", " + str2);
                HashMap map = new HashMap();
                map.put("fileUnique", C2797a.this.f12183z + "_" + C2797a.this.f12159b.getId() + "_" + C2797a.this.f12159b.getVersionId());
                C11060c c11060cM66626a = C11058a.m66626a(C2797a.this.f12155A.m66661q(), "reportUploadProgress", C13452e.m80781L().m80971t0());
                c11060cM66626a.m66665u("0:1");
                c11060cM66626a.m66635A(str);
                c11060cM66626a.m66638D(str2);
                C13622a.m81969o(C0213f.m1377a(), c11060cM66626a, map);
            } catch (Exception e10) {
                C1120a.m6676e("AssetUploader", "reportUploadProgress Exception " + e10);
            }
        }

        @Override // com.huawei.hms.network.file.api.Callback
        public void onSuccess(Response<BodyRequest, String, Closeable> response) {
            C1120a.m6677i("AssetUploader", "taskId [" + ((BodyRequest) response.getRequest()).getId() + "]slice object [" + this.f12186b.m63173u() + "] upload end.");
            int code = response.getCode();
            C1120a.m6675d("AssetUploader", "onSuccess: " + code + ", message: " + response.getContent() + ", message: " + response.getMessage());
            m16319e("onSuccess", this.f12186b.m63173u() + ", " + ((BodyRequest) response.getRequest()).getId() + ", " + code + ", " + C2797a.this.m16262O(response));
            if (code == Result.SUCCESS) {
                code = 200;
            }
            C2797a.m16280u(C2797a.this, this.f12185a.getLength());
            try {
                try {
                    C2797a.this.m16263W();
                } catch (C9721b e10) {
                    C1120a.m6676e("AssetUploader", "taskId [" + ((BodyRequest) response.getRequest()).getId() + "]slice object [" + this.f12186b.m63173u() + "] upload error." + e10.toString());
                    C2797a.this.m16260L(e10);
                }
                if (response.getResponseHeader() != null && !response.getResponseHeader().isEmpty()) {
                    HashMap map = new HashMap();
                    SliceObject sliceObjectM16294P = C2797a.this.m16294P(this.f12186b.m63173u(), C2797a.this.f12159b.getResource().getObjects());
                    if (sliceObjectM16294P != null) {
                        SliceObject.UploadStatus uploadStatus = new SliceObject.UploadStatus();
                        uploadStatus.setBody(response.getContent());
                        for (Map.Entry<String, List<String>> entry : response.getResponseHeader().entrySet()) {
                            String key = entry.getKey();
                            List<String> value = entry.getValue();
                            if (value != null && !value.isEmpty()) {
                                map.put(key, value.get(0));
                            }
                        }
                        uploadStatus.setHeaders(map);
                        uploadStatus.setStatus(Integer.valueOf(code));
                        sliceObjectM16294P.setUploadStatus(uploadStatus);
                    }
                    C2797a.this.m16263W();
                    this.f12186b.m63169A(code).m63176x(new JSONObject(map).toString()).m63171s().m63149c(C2797a.this.f12162e);
                    C1120a.m6677i("AssetUploader", "taskId [" + ((BodyRequest) response.getRequest()).getId() + "]slice object [" + this.f12186b.m63173u() + "] upload success.");
                    m16315d();
                    return;
                }
                C1120a.m6676e("AssetUploader", "taskId [" + ((BodyRequest) response.getRequest()).getId() + "]slice object [" + this.f12186b.m63173u() + "] response is null.");
                C2797a.this.m16260L(new C9721b(4307, "getResponseHeader is null"));
                m16315d();
            } catch (Throwable th2) {
                m16315d();
                throw th2;
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.drive.asset.a$c */
    public enum c {
        NOT_STARTED,
        INIT_USER_KEY,
        OBJECTS_UPDATE_FOR_URL,
        OBJECTS_IN_PROGRESS,
        OBJECTS_COMPLETE
    }

    /* renamed from: com.huawei.android.hicloud.drive.asset.a$d */
    public class d extends AbstractRunnableC12516b {

        /* renamed from: a */
        public Slice<File> f12196a;

        /* renamed from: b */
        public C10134e.b f12197b;

        /* renamed from: c */
        public CountDownLatch f12198c;

        /* renamed from: d */
        public boolean f12199d;

        public d(Slice<File> slice, C10134e.b bVar, CountDownLatch countDownLatch, boolean z10) {
            this.f12196a = slice;
            this.f12197b = bVar;
            this.f12198c = countDownLatch;
            this.f12199d = z10;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            Slice<File> sliceM16322c;
            CountDownLatch countDownLatch;
            b bVar;
            ArrayList arrayList;
            try {
                try {
                    C1120a.m6677i("AssetUploader", "UploadTask begin: " + this.f12197b.m63173u());
                    C2797a.this.m16288G();
                    C2797a.this.m16263W();
                    sliceM16322c = C2798b.m16322c(this.f12196a, C2797a.this.f12165h, C2797a.this.f12166i, C2797a.this.f12180w, C2797a.this.f12159b.getId() + "_" + this.f12197b.m63173u());
                    countDownLatch = new CountDownLatch(1);
                    bVar = C2797a.this.new b(sliceM16322c, this.f12197b, countDownLatch);
                    arrayList = new ArrayList();
                } catch (C9721b e10) {
                    C1120a.m6676e("AssetUploader", "create upload task error: " + e10.getMessage());
                    C2797a.this.m16260L(e10);
                }
                try {
                    for (SliceItem<File> sliceItem : sliceM16322c.getSliceItems()) {
                        String name = sliceItem.getObject().getName();
                        arrayList.add(new FileEntity(CloudBackupConstant.Command.PMS_OPTION_ONE_FILE, name, new File(C2797a.this.f12180w + "/" + name), sliceItem.getOffset(), sliceItem.getLength()));
                        C2797a.this.f12173p.add(name);
                    }
                    HashMap map = new HashMap();
                    map.put("trace_id", C2797a.this.f12155A.m66661q());
                    map.put(C6148x2.DEVICE_ID, C2797a.this.f12183z);
                    C1120a.m6677i("AssetUploader", "report trace_id " + C2797a.this.f12155A.m66661q());
                    C1120a.m6677i("AssetUploader", "upload use quic:" + this.f12199d);
                    C13735d.m82531s().m82543m(this.f12199d ? EnumC12999a.CLOUD_ALBUM_QUIC : EnumC12999a.CLOUD_DRIVE, ((PutRequest.Builder) ((PutRequest.Builder) C13735d.m82533v().fileParams((List<FileEntity>) arrayList).config(C13735d.m82528e())).reportInfos(map)).build(), C2797a.this.f12172o, bVar);
                    C1120a.m6677i("AssetUploader", "createTask await");
                    int i10 = 0;
                    while (countDownLatch.getCount() > 0 && !C2797a.this.f12163f && C2797a.this.f12175r == null) {
                        try {
                            if (countDownLatch.await(400L, TimeUnit.MILLISECONDS)) {
                                C1120a.m6677i("AssetUploader", "createTask await success");
                            } else if (i10 % 5 == 0) {
                                C1120a.m6677i("AssetUploader", "createTask await");
                            }
                            i10++;
                        } catch (InterruptedException e11) {
                            C1120a.m6678w("AssetUploader", "lock wait error." + e11);
                        }
                    }
                    C1120a.m6677i("AssetUploader", "createTask await end");
                } catch (IllegalArgumentException unused) {
                    throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "create FileEntity trigger illegalArgumentException");
                }
            } finally {
                this.f12198c.countDown();
            }
        }

        @Override // p616rk.AbstractRunnableC12516b
        public AbstractRunnableC12516b.a getEnum() {
            return AbstractRunnableC12516b.a.CLOUD_PHOTO_DRIVE_UPLOAD;
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

    public C2797a(AssetMetadataTransport assetMetadataTransport) {
        this.f12158a = assetMetadataTransport;
    }

    /* renamed from: L */
    public void m16260L(C9721b c9721b) {
        synchronized (f12154F) {
            try {
                if (this.f12175r == null) {
                    this.f12175r = c9721b;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: N */
    public String m16261N(Response<BodyRequest, String, Closeable> response) {
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

    /* renamed from: O */
    public String m16262O(Response<BodyRequest, String, Closeable> response) {
        return (response == null || response.getResponseHeader() == null) ? "" : response.getResponseHeader().toString();
    }

    /* renamed from: W */
    public void m16263W() throws C9721b {
        if (this.f12163f) {
            throw new C9721b(1001, "user cancel.");
        }
        C9721b c9721b = this.f12175r;
        if (c9721b != null) {
            throw c9721b;
        }
        C0068f.m459d().m468l();
    }

    /* renamed from: j0 */
    private void m16269j0() {
        Iterator it = new CopyOnWriteArrayList(this.f12173p).iterator();
        while (it.hasNext()) {
            File file = new File(m61410a(), (String) it.next());
            if (file.exists()) {
                C1120a.m6675d("AssetUploader", "finally cache file exits, delete = " + file.delete());
            }
        }
    }

    /* renamed from: u */
    public static /* synthetic */ long m16280u(C2797a c2797a, long j10) {
        long j11 = c2797a.f12178u + j10;
        c2797a.f12178u = j11;
        return j11;
    }

    /* renamed from: E */
    public final void m16286E(List<File> list) throws C9721b {
        Slices slices = new Slices();
        SliceEnumeration sliceEnumeration = new SliceEnumeration(list, new FileLengthGetter());
        while (true) {
            if (!sliceEnumeration.hasMoreSlices()) {
                break;
            } else {
                slices.increase(sliceEnumeration.nextSlice(this.f12159b.getResource().getSliceSize().longValue(), false));
            }
        }
        LinkedList linkedList = new LinkedList(slices.getSlices());
        List<C10134e.b> listM63148b = new C10134e.b(this.f12164g).m63171s().m63148b(this.f12162e);
        C4627a0.m28395h(listM63148b.size() == linkedList.size(), "slices do not match server.");
        this.f12177t = slices.getTotal();
        this.f12174q = new CountDownLatch(listM63148b.size());
        ArrayList arrayList = new ArrayList();
        try {
            for (C10134e.b bVar : listM63148b) {
                Slice slice = (Slice) linkedList.poll();
                if (bVar.m63175w()) {
                    SliceObject sliceObjectM16294P = m16294P(bVar.m63173u(), this.f12159b.getResource().getObjects());
                    if (sliceObjectM16294P != null) {
                        SliceObject.UploadStatus uploadStatus = new SliceObject.UploadStatus();
                        uploadStatus.setStatus(Integer.valueOf(bVar.m63174v()));
                        uploadStatus.setBody("");
                        if (m16301X()) {
                            uploadStatus.setHeaders(m16302Y(bVar.m63172t()));
                        }
                        sliceObjectM16294P.setUploadStatus(uploadStatus);
                    }
                    this.f12174q.countDown();
                    if (this.f12176s != null) {
                        this.f12179v.put(bVar.m63173u(), Long.valueOf(slice.getLength()));
                        this.f12176s.mo16255a(this);
                    }
                } else {
                    d dVar = new d(slice, bVar, this.f12174q, this.f12157C);
                    arrayList.add(dVar);
                    C12515a.m75110o().m75172d(dVar);
                }
            }
            C1120a.m6677i("AssetUploader", "buildTasks uploadTasks " + arrayList.size());
            m16312i0();
            AssetUploaderProgressListener assetUploaderProgressListener = this.f12176s;
            if (assetUploaderProgressListener != null) {
                assetUploaderProgressListener.mo16255a(this);
            }
        } catch (C9721b e10) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((d) it.next()).cancel();
            }
            throw e10;
        }
    }

    /* renamed from: F */
    public void m16287F() {
        C1120a.m6677i("AssetUploader", "file upload cancel: ");
        this.f12163f = true;
    }

    /* renamed from: G */
    public final void m16288G() throws C9721b {
        File file = this.f12160c;
        if (file == null || file.exists()) {
            return;
        }
        C1120a.m6678w("AssetUploader", "file has been deleted");
        throw new C9721b(FamilyShareConstants.StatusCode.SHARE_SPACE_NOT_ENOUGH, "file is not exits:" + C1122c.m6818p0(this.f12160c.getName()));
    }

    /* renamed from: H */
    public final void m16289H(String str, Slice<File> slice, AssetMetadataTransport.C2796a c2796a) throws C9721b {
        C1120a.m6677i("AssetUploader", "dealAssetExpired");
        try {
            Asset asset = new Asset();
            C2798b.a aVarM16333n = C2798b.m16333n(slice.getSliceItems());
            Resource resource = new Resource();
            ArrayList arrayList = new ArrayList();
            SliceObject sliceObject = new SliceObject();
            sliceObject.setSha256(aVarM16333n.m16340a());
            sliceObject.setLength(Long.valueOf(slice.getLength()));
            sliceObject.setObjectId(str);
            arrayList.add(sliceObject);
            resource.setHash(this.f12159b.getResource().getHash());
            resource.setSha256(this.f12159b.getResource().getSha256());
            resource.setObjects(arrayList);
            asset.setId(this.f12159b.getId());
            asset.setResource(resource);
            Asset assetOnCreateUploadUrl = this.f12158a.onCreateUploadUrl(this.f12183z, this.f12159b.getId(), this.f12159b.getVersionId(), asset, c2796a);
            if (assetOnCreateUploadUrl.getResource() == null) {
                throw new C9721b(4309, "onCreateUploadUrl resource is null ");
            }
            if (assetOnCreateUploadUrl.getResource().getObjects() == null) {
                throw new C9721b(4309, "onCreateUploadUrl resource object is null ");
            }
            if (assetOnCreateUploadUrl.getResource().getObjects().size() == 0) {
                throw new C9721b(4309, "onCreateUploadUrl resource object is empty ");
            }
            SliceObject sliceObjectM16294P = m16294P(str, this.f12159b.getResource().getObjects());
            SliceObject sliceObjectM16294P2 = m16294P(str, assetOnCreateUploadUrl.getResource().getObjects());
            if (sliceObjectM16294P != null) {
                sliceObjectM16294P.setUploadUrl(m16296R(sliceObjectM16294P2));
            }
        } catch (C4616s e10) {
            C1120a.m6676e("AssetUploader", "dealAssetExpired HttpResponseException result : " + e10.toString());
            throw new C9721b(4312, e10.m28322f(), e10.m28319c(), "assets.revisions.update", C1160a.m7253d(e10));
        } catch (IOException e11) {
            throw new C9721b(4313, "get upload address error: " + e11.getMessage());
        }
    }

    /* renamed from: I */
    public final void m16290I(List<File> list) throws C9721b {
        C1120a.m6677i("AssetUploader", "dealAttachment");
        if (this.f12159b.getAttributes() == null) {
            this.f12159b.setAttributes(new MediaAssetAttribute());
        }
        MediaAssetAttribute attributes = this.f12159b.getAttributes();
        if (this.f12161d != null) {
            MediaAssetAttribute.SmallLargePair smallLargePair = new MediaAssetAttribute.SmallLargePair();
            attributes.setLength(smallLargePair);
            for (Thumbnail thumbnail : this.f12161d) {
                C9720a.m60657f(thumbnail, "thumbnail is invalid.");
                C9720a.m60653b(thumbnail.getName(), "thumbnail name is null.");
                File file = thumbnail.getFile();
                C9720a.m60657f(file, "thumbnail file is null");
                C9720a.m60652a(file.exists(), "file is not exits." + C10279b.m63452a(file));
                if (thumbnail.getName().equals("small")) {
                    smallLargePair.setSmall(Long.valueOf(file.length()));
                }
                if (thumbnail.getName().equals("large")) {
                    smallLargePair.setLarge(Long.valueOf(file.length()));
                }
                list.add(file);
            }
        }
    }

    /* renamed from: J */
    public final void m16291J(boolean z10) throws C9721b {
        C1120a.m6677i("AssetUploader", "dealObjectCompleted");
        Asset asset = new Asset();
        if (!z10) {
            Resource resource = new Resource();
            ArrayList arrayList = new ArrayList();
            boolean zM16301X = m16301X();
            for (SliceObject sliceObject : this.f12159b.getResource().getObjects()) {
                SliceObject sliceObject2 = new SliceObject();
                sliceObject2.setObjectId(sliceObject.getId());
                SliceObject.UploadStatus uploadStatus = new SliceObject.UploadStatus();
                if (sliceObject.getUploadStatus() == null) {
                    C1120a.m6676e("AssetUploader", sliceObject.getId() + " has no upload status");
                    throw new C9721b(AuthCode.StatusCode.PERMISSION_NOT_AUTHORIZED, "has no upload status");
                }
                uploadStatus.setBody(sliceObject.getUploadStatus().getBody());
                uploadStatus.setStatus(sliceObject.getUploadStatus().getStatus());
                if (zM16301X) {
                    uploadStatus.setHeaders(sliceObject.getUploadStatus().getHeaders());
                }
                sliceObject2.setUploadStatus(uploadStatus);
                arrayList.add(sliceObject2);
            }
            resource.setObjects(arrayList);
            resource.setHash(this.f12159b.getResource().getHash());
            resource.setSha256(this.f12159b.getResource().getSha256());
            asset.setResource(resource);
        }
        asset.setState(0);
        try {
            this.f12158a.onUploadCompleted(this.f12183z, this.f12159b.getId(), this.f12159b.getVersionId(), asset, this.f12156B);
        } catch (C4616s e10) {
            C1120a.m6676e("AssetUploader", "httpResponseException result" + e10.toString());
            throw new C9721b(4312, e10.m28322f(), e10.m28319c(), "asset", C1160a.m7253d(e10));
        } catch (IOException e11) {
            C1120a.m6676e("AssetUploader", "upload IOException result" + e11.toString());
            throw new C9721b(4313, e11.toString());
        }
    }

    /* renamed from: K */
    public final void m16292K(List<File> list) throws C9721b {
        C1120a.m6677i("AssetUploader", "doUpload");
        try {
            try {
                m16286E(list);
            } catch (C9721b e10) {
                C13735d.m82531s().m82538h(EnumC12999a.CLOUD_DRIVE, this.f12172o);
                C1120a.m6676e("AssetUploader", "doUpload CException" + e10.toString());
                throw e10;
            }
        } finally {
            m16269j0();
        }
    }

    /* renamed from: M */
    public long m16293M() {
        Iterator<Long> it = this.f12179v.values().iterator();
        long jLongValue = 0;
        while (it.hasNext()) {
            jLongValue += it.next().longValue();
        }
        return (int) Math.floor((jLongValue / this.f12177t) * 100.0d);
    }

    /* renamed from: P */
    public final SliceObject m16294P(String str, List<SliceObject> list) {
        for (SliceObject sliceObject : list) {
            if (sliceObject.getId().equals(str)) {
                return sliceObject;
            }
        }
        return null;
    }

    /* renamed from: Q */
    public long m16295Q() {
        return this.f12177t;
    }

    /* renamed from: R */
    public final EndpointUrl m16296R(SliceObject sliceObject) {
        if (sliceObject != null) {
            return sliceObject.getAccelerateUploadUrl() != null ? sliceObject.getAccelerateUploadUrl() : sliceObject.getUploadUrl();
        }
        return null;
    }

    /* renamed from: S */
    public long m16297S() {
        return this.f12181x;
    }

    /* renamed from: T */
    public long m16298T() {
        Iterator<Long> it = this.f12179v.values().iterator();
        long jLongValue = 0;
        while (it.hasNext()) {
            jLongValue += it.next().longValue();
        }
        return jLongValue;
    }

    /* renamed from: U */
    public Cipher m16299U(String str, boolean z10) throws C9721b {
        C1120a.m6677i("AssetUploader", "initUserKey");
        C0087b c0087b = new C0087b(C9679b.m60452d().m60455e(), C1122c.m6833t0(C0213f.m1377a()));
        this.f12170m = c0087b.m680c("", 12, UserKeyBaseReq.KEY_TYPE_AES_128);
        this.f12171n = c0087b.m681d("", 12, UserKeyBaseReq.KEY_TYPE_AES_256);
        this.f12169l = C2798b.m16326g(str);
        String strM16325f = C2798b.m16325f(str);
        this.f12167j = C2798b.m16324e(strM16325f, this.f12170m.getUserKey());
        this.f12168k = C2798b.m16324e(strM16325f, this.f12171n.getUserKey());
        try {
            this.f12165h = C9900c.m61477e(C9900c.m61474b(this.f12167j, this.f12170m.getUserKey()));
            this.f12166i = C9900c.m61477e(this.f12169l);
            Cipher cipher = new Cipher();
            ArrayList arrayList = new ArrayList();
            cipher.setIv(this.f12169l);
            cipher.setDataType(12);
            cipher.setAlgorithm(UserKeyBaseReq.KEY_TYPE_AES_128_FULL);
            KeyChain keyChain = new KeyChain();
            if (z10) {
                keyChain.setAlgorithm(UserKeyBaseReq.KEY_TYPE_AES_128_FULL);
                keyChain.setType(1);
                keyChain.setEkey(this.f12167j);
                keyChain.setId(this.f12170m.getUserKeyGuid());
                arrayList.add(keyChain);
            }
            KeyChain keyChain2 = new KeyChain();
            keyChain2.setAlgorithm(UserKeyBaseReq.KEY_TYPE_AES_256_FULL);
            keyChain2.setType(3);
            keyChain2.setEkey(this.f12168k);
            keyChain2.setId(this.f12171n.getUserKeyGuid());
            arrayList.add(keyChain2);
            cipher.setKeyChains(arrayList);
            return cipher;
        } catch (Exception e10) {
            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_OPENED, "compute file key and iv error: " + e10.getMessage());
        }
    }

    /* renamed from: V */
    public final Asset m16300V() throws C9721b, SQLException {
        ArrayList arrayList = new ArrayList();
        File file = this.f12160c;
        if (file != null) {
            arrayList.add(file);
        }
        m16288G();
        m16290I(arrayList);
        C10134e.b bVar = new C10134e.b(this.f12164g);
        m16313k0(c.OBJECTS_IN_PROGRESS);
        bVar.m63171s().m63150d(this.f12159b.getResource().getObjects(), false, this.f12162e);
        m16292K(arrayList);
        m16291J(false);
        bVar.m63171s().m63147a(this.f12162e);
        C11060c c11060c = this.f12155A;
        if (c11060c != null) {
            long jM1688f = C0241z.m1688f(c11060c.m66658n());
            this.f12155A.m66641G(String.valueOf(this.f12178u + jM1688f));
            try {
                Map<String, Long> mapM15190n = SyncSessionManager.m15153t().m15190n();
                mapM15190n.put("uploadBatchSize", Long.valueOf((mapM15190n.get("uploadBatchSize") != null ? mapM15190n.get("uploadBatchSize").longValue() : 0L) + jM1688f + this.f12178u));
                mapM15190n.put("uploadEndTime", Long.valueOf(System.currentTimeMillis()));
            } catch (Exception unused) {
                C1120a.m6676e("AssetUploader", "upload rate,calBatchUploadInfo exception.");
            }
        }
        return this.f12159b;
    }

    /* renamed from: X */
    public final boolean m16301X() {
        return C9733f.m60705z().m60763v("uploadStatusHeader") == 1 && C9733f.m60705z().m60730Y(1);
    }

    /* renamed from: Y */
    public final Map<String, String> m16302Y(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return (Map) f12152D.fromJson(str, new a().getType());
        } catch (Exception unused) {
            C1120a.m6676e("AssetUploader", "packageHeader error");
            return null;
        }
    }

    /* renamed from: Z */
    public void m16303Z(Asset asset) {
        this.f12159b = asset;
    }

    /* renamed from: a0 */
    public void m16304a0(String str) {
        this.f12164g = str;
    }

    /* renamed from: b0 */
    public void m16305b0(String str) {
        this.f12183z = str;
    }

    /* renamed from: c0 */
    public void m16306c0(boolean z10) {
        this.f12156B = z10;
    }

    /* renamed from: d0 */
    public void m16307d0(File file) {
        this.f12160c = file;
    }

    /* renamed from: e0 */
    public C2797a m16308e0(AssetUploaderProgressListener assetUploaderProgressListener) {
        this.f12176s = assetUploaderProgressListener;
        return this;
    }

    /* renamed from: f0 */
    public void m16309f0(C11060c c11060c) {
        this.f12155A = c11060c;
    }

    /* renamed from: g0 */
    public void m16310g0(Thumbnail[] thumbnailArr) {
        this.f12161d = thumbnailArr;
    }

    /* renamed from: h0 */
    public void m16311h0(boolean z10) {
        this.f12157C = z10;
    }

    /* renamed from: i0 */
    public final void m16312i0() throws C9721b {
        C1120a.m6677i("AssetUploader", "syncLock await begin");
        m16263W();
        int i10 = 0;
        while (this.f12174q.getCount() > 0 && !this.f12163f && this.f12175r == null) {
            try {
                if (this.f12174q.await(400L, TimeUnit.MILLISECONDS)) {
                    C1120a.m6677i("AssetUploader", "syncLock await success");
                } else if (i10 % 5 == 0) {
                    C1120a.m6677i("AssetUploader", "syncLock await");
                }
                i10++;
            } catch (InterruptedException e10) {
                C1120a.m6678w("AssetUploader", "lock wait error." + e10);
                this.f12175r = new C9721b(1001, "thread has been interrupted");
            }
        }
        C1120a.m6677i("AssetUploader", "syncLock await end");
        C9721b c9721b = this.f12175r;
        if (c9721b != null) {
            throw c9721b;
        }
        m16263W();
    }

    /* renamed from: k0 */
    public final void m16313k0(c cVar) {
        this.f12182y = cVar;
        AssetUploaderProgressListener assetUploaderProgressListener = this.f12176s;
        if (assetUploaderProgressListener != null) {
            assetUploaderProgressListener.mo16255a(this);
        }
    }

    /* renamed from: l0 */
    public Asset m16314l0(boolean z10) throws C9721b, SQLException {
        C1120a.m6677i("AssetUploader", "asset upload start");
        try {
            if (this.f12159b.getState() != null && this.f12159b.getState().intValue() == 0) {
                C1120a.m6677i("AssetUploader", "file state has already uploaded");
                return this.f12159b;
            }
            if (!z10 && this.f12159b.getResource().getState().intValue() != 0) {
                Asset assetM16300V = m16300V();
                m16313k0(c.OBJECTS_COMPLETE);
                C1120a.m6677i("AssetUploader", "file upload end.");
                return assetM16300V;
            }
            m16291J(true);
            return this.f12159b;
        } catch (C9721b e10) {
            C1120a.m6676e("AssetUploader", "file upload CException:" + e10.getMessage());
            throw e10;
        }
    }
}
