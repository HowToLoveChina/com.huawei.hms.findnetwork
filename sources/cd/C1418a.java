package cd;

import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import bd.C1164a;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.complexutil.CloudSyncUtil;
import com.huawei.android.hicloud.security.bean.SliceEncryptReq;
import com.huawei.android.hicloud.syncdrive.cloudsync.model.Asset;
import com.huawei.android.hicloud.syncdrive.cloudsync.model.Resource;
import com.huawei.android.hicloud.syncdrive.cloudsync.model.SliceObject;
import com.huawei.android.hicloud.syncdrive.cloudsync.request.Assets;
import com.huawei.android.hicloud.syncdrive.util.DriveSyncUtil;
import com.huawei.cloud.base.http.C4609l;
import com.huawei.cloud.base.http.C4616s;
import com.huawei.hicloud.base.drive.model.Cipher;
import com.huawei.hicloud.base.drive.model.EndpointUrl;
import com.huawei.hicloud.base.slice.FileLengthGetter;
import com.huawei.hicloud.base.slice.Slice;
import com.huawei.hicloud.base.slice.SliceEnumeration;
import com.huawei.hicloud.base.slice.SliceItem;
import com.huawei.hicloud.base.slice.Slices;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hms.network.embedded.C5927g2;
import com.huawei.hms.network.file.api.Progress;
import com.huawei.hms.network.file.api.Response;
import com.huawei.hms.network.file.api.Result;
import com.huawei.hms.network.file.api.exception.NetworkException;
import com.huawei.hms.network.file.upload.api.BodyRequest;
import com.huawei.hms.network.file.upload.api.FileEntity;
import com.huawei.hms.network.file.upload.api.FileUploadCallback;
import com.huawei.hms.network.file.upload.api.PutRequest;
import com.huawei.secure.android.common.util.SafeString;
import fk.C9720a;
import fk.C9721b;
import fk.C9722c;
import hk.C10278a;
import hk.C10279b;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import mu.C11526c;
import org.json.JSONObject;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0241z;
import p225dd.C9065a;
import p225dd.C9066b;
import p225dd.C9067c;
import p225dd.C9068d;
import p225dd.C9071g;
import p255ed.C9453i;
import p292fn.C9733f;
import p365ic.C10466a;
import p514o9.C11835i;
import p514o9.C11839m;
import p616rk.AbstractRunnableC12516b;
import p616rk.C12515a;
import p652t9.EnumC12999a;
import p712vm.C13468a;
import p767x9.C13735d;
import tc.C13007b;
import za.C14165b;

/* renamed from: cd.a */
/* loaded from: classes3.dex */
public class C1418a {

    /* renamed from: a */
    public EnumC12999a f6062a;

    /* renamed from: b */
    public String f6063b;

    /* renamed from: c */
    public String f6064c;

    /* renamed from: d */
    public String f6065d;

    /* renamed from: e */
    public String f6066e;

    /* renamed from: f */
    public Asset f6067f;

    /* renamed from: l */
    public SQLiteDatabase f6073l;

    /* renamed from: m */
    public String f6074m;

    /* renamed from: n */
    public File f6075n;

    /* renamed from: o */
    public C9067c f6076o;

    /* renamed from: p */
    public Cipher f6077p;

    /* renamed from: q */
    public File f6078q;

    /* renamed from: r */
    public long f6079r;

    /* renamed from: v */
    public C9068d f6083v;

    /* renamed from: w */
    public C9071g f6084w;

    /* renamed from: x */
    public String f6085x;

    /* renamed from: y */
    public Map<String, String> f6086y;

    /* renamed from: z */
    public static final Object f6061z = new Object();

    /* renamed from: A */
    public static final Object f6060A = new Object();

    /* renamed from: g */
    public boolean f6068g = false;

    /* renamed from: h */
    public List<String> f6069h = new ArrayList();

    /* renamed from: i */
    public C9721b f6070i = null;

    /* renamed from: j */
    public long f6071j = 0;

    /* renamed from: k */
    public Map<String, Long> f6072k = new HashMap();

    /* renamed from: s */
    public boolean f6080s = false;

    /* renamed from: t */
    public boolean f6081t = false;

    /* renamed from: u */
    public List<C9066b> f6082u = new ArrayList();

    /* renamed from: cd.a$a */
    public class a extends TypeToken<Map<String, String>> {
        public a() {
        }
    }

    /* renamed from: cd.a$b */
    public static class b {

        /* renamed from: a */
        public C4609l f6088a;

        /* renamed from: a */
        public C4609l m8191a() {
            return this.f6088a;
        }
    }

    /* renamed from: cd.a$c */
    public class c extends AbstractRunnableC12516b {

        /* renamed from: a */
        public Slice<File> f6089a;

        /* renamed from: b */
        public C9066b f6090b;

        /* renamed from: c */
        public CountDownLatch f6091c;

        /* renamed from: d */
        public List<Long> f6092d;

        /* renamed from: e */
        public Cipher f6093e;

        public c(Cipher cipher, Slice<File> slice, C9066b c9066b, List<Long> list, CountDownLatch countDownLatch) {
            this.f6093e = cipher;
            this.f6089a = slice;
            this.f6090b = c9066b;
            this.f6092d = list;
            this.f6091c = countDownLatch;
        }

        /* renamed from: c */
        public final Slice<File> m8192c() throws Throwable {
            C11839m.m70686d("SyncSliceFileTask", "encrypt file slice start. objectId = " + this.f6090b.m57179q() + ", fileName = " + C1418a.this.f6078q.getName() + ", recordId = " + C1418a.this.f6066e);
            ArrayList arrayList = new ArrayList();
            long length = 0;
            for (SliceItem<File> sliceItem : this.f6089a.getSliceItems()) {
                SliceEncryptReq sliceEncryptReq = new SliceEncryptReq();
                sliceEncryptReq.setTraceID(C1418a.this.f6074m);
                sliceEncryptReq.setType(this.f6093e.getDataType().intValue());
                sliceEncryptReq.setEfek(this.f6093e.getKeyChains().get(0).getEkey());
                sliceEncryptReq.setIv(this.f6093e.getIv());
                sliceEncryptReq.setStart(sliceItem.getOffset());
                sliceEncryptReq.setLength(sliceItem.getLength());
                sliceEncryptReq.setDesFile(C1418a.this.f6075n + "/" + this.f6090b.m57179q());
                sliceEncryptReq.setSrcFile(C10279b.m63452a(sliceItem.getObject()));
                C10466a.m64320k(sliceEncryptReq);
                File fileM63442h = C10278a.m63442h(sliceEncryptReq.getDesFile());
                SliceItem sliceItem2 = new SliceItem(fileM63442h, sliceItem.getIndex(), 0L, fileM63442h.length());
                length += sliceItem2.getLength();
                arrayList.add(sliceItem2);
            }
            C11839m.m70686d("SyncSliceFileTask", "encrypt file slice end. objectId = " + this.f6090b.m57179q() + ", fileName = " + C1418a.this.f6078q.getName() + ", recordId = " + C1418a.this.f6066e);
            return new Slice<>(arrayList, length);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            try {
                try {
                    this.f6089a = this.f6093e == null ? this.f6089a : m8192c();
                    ArrayList arrayList = new ArrayList();
                    try {
                        for (SliceItem<File> sliceItem : this.f6089a.getSliceItems()) {
                            String name = sliceItem.getObject().getName();
                            arrayList.add(new FileEntity(CloudBackupConstant.Command.PMS_OPTION_ONE_FILE, name, new File(C10279b.m63452a(sliceItem.getObject())), sliceItem.getOffset(), sliceItem.getLength()));
                            C1418a.this.f6069h.add(name);
                        }
                        CountDownLatch countDownLatch = new CountDownLatch(1);
                        C13735d.m82531s().m82543m(C1418a.this.f6062a, ((PutRequest.Builder) C13735d.m82533v().fileParams((List<FileEntity>) arrayList).config(C13735d.m82528e())).build(), this.f6092d, C1418a.this.new d(this.f6089a, this.f6090b, countDownLatch));
                        C11839m.m70688i("SyncSliceFileTask", "SyncSliceFileTask createTask await");
                        while (countDownLatch.getCount() > 0 && !C1418a.this.f6068g && C1418a.this.f6070i == null) {
                            try {
                                if (countDownLatch.await(400L, TimeUnit.MILLISECONDS)) {
                                    C11839m.m70688i("SyncSliceFileTask", "SyncSliceFileTask createTask await success");
                                }
                            } catch (InterruptedException e10) {
                                C11839m.m70689w("SyncSliceFileTask", "SyncSliceFileTask lock wait error." + e10);
                            }
                        }
                        C11839m.m70688i("SyncSliceFileTask", "SyncSliceFileTask await end. objectId = " + this.f6090b.m57179q() + ", fileName = " + C1418a.this.f6078q.getName() + ", recordId = " + C1418a.this.f6066e);
                    } catch (IllegalArgumentException e11) {
                        throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "create FileEntity trigger illegalArgumentException sliceId = " + this.f6090b + ", msg = " + e11.getMessage());
                    }
                } catch (C9721b e12) {
                    C1418a.this.m8185u(new C9721b(e12.m60659c(), "SyncSliceFileTask error. objectId = " + this.f6090b.m57179q() + ", msg = " + e12.getMessage()));
                }
                this.f6091c.countDown();
            } catch (Throwable th2) {
                this.f6091c.countDown();
                throw th2;
            }
        }

        @Override // p616rk.AbstractRunnableC12516b
        public AbstractRunnableC12516b.a getEnum() {
            return AbstractRunnableC12516b.a.CLOUD_SYNC_DRIVE;
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

    /* renamed from: cd.a$d */
    public class d extends FileUploadCallback {

        /* renamed from: a */
        public Slice<File> f6095a;

        /* renamed from: b */
        public C9066b f6096b;

        /* renamed from: c */
        public CountDownLatch f6097c;

        public d(Slice<File> slice, C9066b c9066b, CountDownLatch countDownLatch) {
            this.f6095a = slice;
            this.f6096b = c9066b;
            this.f6097c = countDownLatch;
        }

        /* renamed from: e */
        private void m8193e() {
            CountDownLatch countDownLatch = this.f6097c;
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
            Slice<File> slice = this.f6095a;
            if (slice != null) {
                Iterator<SliceItem<File>> it = slice.getSliceItems().iterator();
                while (it.hasNext()) {
                    File object = it.next().getObject();
                    if (object.exists()) {
                        C11839m.m70686d("CloudSyncAssetUploader", "cloudsync uploadFileTask release encrypt file exits, delete = " + object.delete());
                    }
                }
            }
        }

        /* renamed from: a */
        public final void m8194a(Map<String, List<String>> map, Map<String, String> map2) {
            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                String key = entry.getKey();
                List<String> value = entry.getValue();
                if (value != null && !value.isEmpty()) {
                    map2.put(key, value.get(0));
                }
            }
        }

        @Override // com.huawei.hms.network.file.api.Callback
        /* renamed from: b */
        public void onException(BodyRequest bodyRequest, NetworkException networkException, Response<BodyRequest, String, Closeable> response) {
            int iM1331z = C0209d.m1331z(networkException.getMessage());
            String message = networkException.getMessage();
            if (response != null) {
                iM1331z = response.getCode();
                message = message + " " + response.getMessage();
                ((BodyRequest) response.getRequest()).getId();
            }
            if (!C0209d.m1208S0(C0213f.m1377a()) || !C13468a.m81100c().m81101b()) {
                iM1331z = 2028;
            }
            C1418a.this.m8185u(new C9721b(iM1331z, "cloudsync uploadFileTask onException taskId [" + bodyRequest.getId() + "]slice object [" + this.f6096b.m57179q() + "] upload error code = " + iM1331z + ", msg = " + message));
            C11839m.m70687e("CloudSyncAssetUploader", "cloudsync uploadFileTask onException taskId [" + bodyRequest.getId() + "]slice object [" + this.f6096b.m57179q() + "] assetId [" + C1418a.this.f6067f.getId() + "] recordId [" + C1418a.this.f6066e + "]] fileName [" + C1418a.this.f6078q.getName() + "] upload error code = " + iM1331z + message);
            m8193e();
        }

        @Override // com.huawei.hms.network.file.api.Callback
        /* renamed from: c */
        public void onProgress(BodyRequest bodyRequest, Progress progress) {
            C11839m.m70688i("CloudSyncAssetUploader", "cloudsync uploadFileTask taskId [" + bodyRequest.getId() + "]slice object [" + this.f6096b.m57179q() + "] upload progress = " + progress.getProgress() + "size = " + progress.getFinishedSize());
            synchronized (C1418a.f6061z) {
                C1418a.m8162f(C1418a.this, progress.getFinishedSize());
                C1418a.this.f6072k.put(this.f6096b.m57179q(), Long.valueOf(progress.getFinishedSize()));
            }
        }

        @Override // com.huawei.hms.network.file.api.Callback
        /* renamed from: d */
        public BodyRequest onStart(BodyRequest bodyRequest) throws Throwable {
            BodyRequest bodyRequest2;
            C11839m.m70688i("CloudSyncAssetUploader", "cloudsync uploadFileTask taskId [" + bodyRequest.getId() + "]slice object [" + this.f6096b.m57179q() + "] get upload address.");
            try {
                C1418a.this.m8190z();
                b bVar = new b();
                C1418a.this.m8183s(this.f6096b.m57179q(), this.f6095a, bVar);
                SliceObject sliceObjectM8186v = C1418a.this.m8186v(this.f6096b.m57179q(), C1418a.this.f6067f.getResource().getObjects());
                if (sliceObjectM8186v == null) {
                    C11839m.m70688i("CloudSyncAssetUploader", "cloudsync uploadFileTask taskId [" + bodyRequest.getId() + "]slice object [" + this.f6096b.m57179q() + "] get upload url error.");
                    C1418a c1418a = C1418a.this;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("sliceObject is null, sliceObject = ");
                    sb2.append(this.f6096b.m57179q());
                    c1418a.m8185u(new C9721b(2219, sb2.toString()));
                    return bodyRequest;
                }
                if (TextUtils.isEmpty(sliceObjectM8186v.getMD5()) && TextUtils.isEmpty(sliceObjectM8186v.getSha256()) && C1418a.this.m8188x(sliceObjectM8186v) == null) {
                    C11839m.m70688i("CloudSyncAssetUploader", "cloudsync uploadFileTask taskId [" + bodyRequest.getId() + "]slice object [" + this.f6096b.m57179q() + "] get upload url error.");
                    C1418a c1418a2 = C1418a.this;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("sliceObject has no upload url, sliceObject = ");
                    sb3.append(this.f6096b.m57179q());
                    c1418a2.m8185u(new C9721b(2266, sb3.toString()));
                    return bodyRequest;
                }
                String url = C1418a.this.m8188x(sliceObjectM8186v).getUrl();
                C11839m.m70686d("CloudSyncAssetUploader", "originalUrl = " + url);
                Map<String, String> headers = C1418a.this.m8188x(sliceObjectM8186v).getHeaders();
                String strM18014x = DriveSyncUtil.m18014x(bVar.m8191a());
                if (TextUtils.isEmpty(strM18014x)) {
                    bodyRequest2 = (BodyRequest) bodyRequest.newBuilder().url(url).build();
                } else {
                    String strM68805b = C11526c.m68805b(url);
                    String strReplace = SafeString.replace(url, strM68805b, strM18014x);
                    C11839m.m70686d("CloudSyncAssetUploader", "cloudsync uploadFileTask cdnUrl: " + strM18014x);
                    headers.put("x-hw-original-url", strM68805b);
                    bodyRequest2 = (BodyRequest) bodyRequest.newBuilder().url(strReplace).headers(headers).build();
                }
                BodyRequest bodyRequest3 = bodyRequest2;
                C1418a.this.f6076o.m57230x(sliceObjectM8186v.getBucket());
                return (BodyRequest) bodyRequest3.newBuilder().headers(headers).build();
            } catch (C9721b e10) {
                C11839m.m70687e("CloudSyncAssetUploader", "cloudsync uploadFileTask taskId [" + bodyRequest.getId() + "]slice object [" + this.f6096b.m57179q() + "] assetId [" + C1418a.this.f6067f.getId() + "] recordId [" + C1418a.this.f6066e + "]] fileName [" + C1418a.this.f6078q.getName() + "] get upload address error code = " + e10.m60659c() + e10.toString());
                C1418a.this.m8185u(e10);
                return bodyRequest;
            } catch (Exception e11) {
                C11839m.m70687e("CloudSyncAssetUploader", "cloudsync uploadFileTask taskId [" + bodyRequest.getId() + "]slice object [" + this.f6096b.m57179q() + "] assetId [" + C1418a.this.f6067f.getId() + "] recordId [" + C1418a.this.f6066e + "]] fileName [" + C1418a.this.f6078q.getName() + "] get upload address error." + e11.getMessage());
                C1418a c1418a3 = C1418a.this;
                StringBuilder sb4 = new StringBuilder();
                sb4.append("cloudsync uploadFileTask taskId [");
                sb4.append(bodyRequest.getId());
                sb4.append("]slice object [");
                sb4.append(this.f6096b.m57179q());
                sb4.append("] get upload address error.");
                sb4.append(e11.getMessage());
                c1418a3.m8185u(new C9721b(2221, sb4.toString()));
                return bodyRequest;
            }
        }

        @Override // com.huawei.hms.network.file.api.Callback
        public void onSuccess(Response<BodyRequest, String, Closeable> response) {
            C11839m.m70688i("CloudSyncAssetUploader", "cloudsync uploadFileTask taskId [" + ((BodyRequest) response.getRequest()).getId() + "]slice object [" + this.f6096b.m57179q() + "] upload end.");
            int code = response.getCode();
            C11839m.m70686d("CloudSyncAssetUploader", "cloudsync uploadFileTask onSuccess: " + code + ", message: " + response.getContent() + ", message: " + response.getMessage());
            if (code == Result.SUCCESS) {
                code = 200;
            }
            try {
                try {
                    C1418a.this.m8190z();
                } catch (C9721b e10) {
                    C11839m.m70687e("CloudSyncAssetUploader", "cloudsync uploadFileTask taskId [" + ((BodyRequest) response.getRequest()).getId() + "]slice object [" + this.f6096b.m57179q() + "] upload error code = " + e10.m60659c() + e10.toString());
                    C1418a.this.m8185u(e10);
                }
                if (response.getResponseHeader() != null && !response.getResponseHeader().isEmpty()) {
                    SliceObject sliceObjectM8186v = C1418a.this.m8186v(this.f6096b.m57179q(), C1418a.this.f6067f.getResource().getObjects());
                    HashMap map = new HashMap();
                    if (sliceObjectM8186v != null) {
                        SliceObject.UploadStatus uploadStatus = new SliceObject.UploadStatus();
                        uploadStatus.setBody(response.getContent());
                        m8194a(response.getResponseHeader(), map);
                        uploadStatus.setHeaders(map);
                        uploadStatus.setStatus(Integer.valueOf(code));
                        sliceObjectM8186v.setUploadStatus(uploadStatus);
                    }
                    C1418a.this.m8190z();
                    Map<String, Object> extraInfo = response.getExtraInfo();
                    if (extraInfo != null) {
                        String str = extraInfo.get("protocol_impl") + "-" + extraInfo.get("protocol");
                        C11839m.m70686d("CloudSyncAssetUploader", "uploadProtocol = " + str);
                        C1418a.this.f6086y.put("protocolType", str);
                    }
                    this.f6096b.m57168B(code);
                    this.f6096b.m57184v(new JSONObject(map).toString());
                    C1418a.this.f6084w.m57244i(this.f6096b);
                    C11839m.m70688i("CloudSyncAssetUploader", "cloudsync uploadFileTask taskId [" + ((BodyRequest) response.getRequest()).getId() + "]slice object [" + this.f6096b.m57179q() + "] upload success.");
                    m8193e();
                    return;
                }
                C11839m.m70687e("CloudSyncAssetUploader", "cloudsync uploadFileTask taskId [" + ((BodyRequest) response.getRequest()).getId() + "]slice object [" + this.f6096b.m57179q() + "] response is null.");
                m8193e();
            } catch (Throwable th2) {
                m8193e();
                throw th2;
            }
        }
    }

    public C1418a(EnumC12999a enumC12999a, String str, String str2, String str3, String str4, String str5, Asset asset, File file, String str6, Map<String, String> map) {
        this.f6086y = new LinkedHashMap();
        this.f6062a = enumC12999a;
        this.f6074m = str;
        this.f6063b = str2;
        this.f6065d = str3;
        this.f6066e = str4;
        this.f6067f = asset;
        this.f6078q = file;
        SQLiteDatabase sQLiteDatabaseM57166a = C9065a.m57166a();
        this.f6073l = sQLiteDatabaseM57166a;
        this.f6083v = new C9068d(sQLiteDatabaseM57166a);
        this.f6084w = new C9071g(this.f6073l);
        this.f6075n = C11835i.m70645i(C0213f.m1377a());
        this.f6085x = str6;
        this.f6086y = map;
    }

    /* renamed from: f */
    public static /* synthetic */ long m8162f(C1418a c1418a, long j10) {
        long j11 = c1418a.f6071j + j10;
        c1418a.f6071j = j11;
        return j11;
    }

    /* renamed from: A */
    public final boolean m8174A() {
        return C9733f.m60705z().m60763v("uploadStatusHeader") == 1 && C9733f.m60705z().m60730Y(4);
    }

    /* renamed from: B */
    public final Asset m8175B(String str, String str2, String str3, String str4, String str5, Asset asset, b bVar) throws C9721b {
        try {
            C9453i c9453iM7268d = C1164a.m7265f().m7268d(this.f6063b);
            DriveSyncUtil.m18002l(this.f6063b, "local_upload");
            if (asset != null) {
                Assets.Revisions.Update update = c9453iM7268d.m59242a().revisions().update(str, str2, str3, str4, str5, "attributes,cipher,createdTime,id,keepPolicy,mimeType,modifiedTime,properties,resource,state,version,versionId", asset);
                DriveSyncUtil.m17994g(update.getHeaders(), this.f6074m, this.f6063b, this.f6085x);
                Asset assetExecute = update.execute();
                DriveSyncUtil.m17985b0(1, update.getLastResponseHeaders());
                return assetExecute;
            }
            String str6 = "onCreateUploadUrl asset is null, assetID = " + str4 + ", versionID = " + str5;
            C11839m.m70689w("CloudSyncAssetUploader", str6);
            throw new C9721b(2265, str6);
        } catch (C9722c e10) {
            throw new C9721b(e10.m60666c(), "onCreateUploadUrl err, assetID = " + str4 + ", versionId = " + str5 + ", msg = " + e10.getMessage());
        } catch (IOException e11) {
            String str7 = "onCreateUploadUrl err, assetID = " + str4 + ", versionID = " + str5 + ", msg = " + e11.getMessage();
            if (e11 instanceof C4616s) {
                throw new C9721b(C0241z.m1685c(DriveSyncUtil.m17980Y((C4616s) e11)), str7);
            }
            if (!C0209d.m1208S0(C0213f.m1377a()) || !C13468a.m81100c().m81101b()) {
                throw new C9721b(2028, str7);
            }
            if (CloudSyncUtil.m16054v0(e11)) {
                throw new C9721b(2102, str7);
            }
            throw new C9721b(2221, str7);
        }
    }

    /* renamed from: C */
    public final void m8176C(List<Slice<File>> list) throws C9721b {
        int size = this.f6082u.size();
        C11839m.m70688i("CloudSyncAssetUploader", "operatoUploadFile start, sliceList size = " + size);
        CountDownLatch countDownLatch = new CountDownLatch(size);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i10 = 0; i10 < size; i10++) {
            try {
                try {
                    C9066b c9066b = this.f6082u.get(i10);
                    if (c9066b.m57183u()) {
                        c9066b.m57179q();
                        SliceObject sliceObjectM8186v = m8186v(c9066b.m57179q(), this.f6067f.getResource().getObjects());
                        if (sliceObjectM8186v != null) {
                            SliceObject.UploadStatus uploadStatus = new SliceObject.UploadStatus();
                            uploadStatus.setStatus(Integer.valueOf(c9066b.m57181s()));
                            uploadStatus.setBody("");
                            if (m8174A()) {
                                uploadStatus.setHeaders(m8177D(c9066b.m57172b()));
                            }
                            sliceObjectM8186v.setUploadStatus(uploadStatus);
                        }
                        this.f6072k.put(c9066b.m57179q(), Long.valueOf(c9066b.m57178p()));
                        countDownLatch.countDown();
                    } else {
                        c9066b.m57179q();
                        c cVar = new c(this.f6077p, list.get(i10), c9066b, arrayList2, countDownLatch);
                        arrayList.add(cVar);
                        C12515a.m75110o().m75172d(cVar);
                    }
                } catch (C9721b e10) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        ((c) it.next()).cancel();
                    }
                    C13735d.m82531s().m82538h(this.f6062a, arrayList2);
                    C11839m.m70687e("CloudSyncAssetUploader", "operatoUploadFile CException" + e10.toString());
                    throw e10;
                }
            } catch (Throwable th2) {
                m8184t(this.f6082u);
                C11839m.m70688i("CloudSyncAssetUploader", "operatoUploadFile end");
                throw th2;
            }
        }
        C11839m.m70688i("CloudSyncAssetUploader", "operatoUploadFile syncLock await begin, file = " + this.f6078q.getName());
        while (countDownLatch.getCount() > 0 && !this.f6080s && this.f6070i == null) {
            try {
                if (countDownLatch.await(400L, TimeUnit.MILLISECONDS)) {
                    C11839m.m70688i("CloudSyncAssetUploader", "operatoUploadFile syncLock await success");
                }
            } catch (InterruptedException e11) {
                C11839m.m70689w("CloudSyncAssetUploader", "operatoUploadFile lock wait error." + e11);
            }
        }
        C11839m.m70688i("CloudSyncAssetUploader", "operatoUploadFile syncLock await end, file = " + this.f6078q.getName());
        C9721b c9721b = this.f6070i;
        if (c9721b != null) {
            throw c9721b;
        }
        m8184t(this.f6082u);
        C11839m.m70688i("CloudSyncAssetUploader", "operatoUploadFile end");
    }

    /* renamed from: D */
    public final Map<String, String> m8177D(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return (Map) new Gson().fromJson(str, new a().getType());
        } catch (Exception e10) {
            C11839m.m70687e("CloudSyncAssetUploader", "packageHeaderString error " + e10.getMessage());
            return null;
        }
    }

    /* renamed from: E */
    public final void m8178E(Resource resource) throws C9721b {
        if (resource == null) {
            throw new C9721b(2218, "resetObjectSlice resource is empty");
        }
        List<SliceObject> objects = resource.getObjects();
        if (objects == null || objects.isEmpty()) {
            throw new C9721b(2219, "resetObjectSlice sliceObjects is empty, resid = " + resource.getId());
        }
        for (SliceObject sliceObject : objects) {
            if (sliceObject == null) {
                C11839m.m70689w("CloudSyncAssetUploader", "resetObjectSlice slice object is null, continue");
            } else {
                C9066b c9066b = new C9066b();
                c9066b.m57185w(this.f6067f.getId()).m57188z(sliceObject.getId()).m57187y(sliceObject.getNumber().intValue()).m57167A(sliceObject.getStart().longValue()).m57186x(sliceObject.getLength().longValue()).m57169C(String.valueOf(System.currentTimeMillis()));
                this.f6082u.add(c9066b);
            }
        }
        try {
            this.f6084w.m57241f(this.f6082u);
        } catch (Exception e10) {
            C11839m.m70687e("CloudSyncAssetUploader", "resetObjectSlice batch slice list error " + e10.getMessage());
        }
    }

    /* renamed from: F */
    public final void m8179F(Resource resource) throws Throwable {
        if (resource == null) {
            return;
        }
        try {
            C14165b.a aVarM85035h = C14165b.m85035h(this.f6078q);
            C9067c c9067c = new C9067c();
            this.f6076o = c9067c;
            c9067c.m57196H(this.f6067f.getId()).m57190B(this.f6064c).m57198J(this.f6065d).m57200L(this.f6066e).m57199K(resource.getLength().longValue()).m57192D(resource.getHash()).m57201M(resource.getSha256()).m57202N(this.f6067f.size()).m57193E(aVarM85035h.m85045a()).m57194F(aVarM85035h.m85045a()).m57195G(resource.getHash()).m57191C("").m57197I("").m57203O(0L).m57205Q(0L).m57204P(this.f6067f.getState()).m57229w(this.f6067f.getId()).m57206R(this.f6067f.getVersionId()).m57203O(resource.getSliceSize().intValue()).m57230x("").m57231y("").m57232z("").m57189A("");
            this.f6083v.m57235g(this.f6076o);
        } catch (C9721b e10) {
            C11839m.m70687e("CloudSyncAssetUploader", "getRecordsAttachment get file hash exception " + e10.getMessage());
        }
    }

    /* renamed from: G */
    public final List<Slice<File>> m8180G() throws C9721b {
        ArrayList arrayList = new ArrayList(Collections.singleton(this.f6078q));
        Slices slices = new Slices();
        SliceEnumeration sliceEnumeration = new SliceEnumeration(arrayList, new FileLengthGetter());
        while (sliceEnumeration.hasMoreSlices()) {
            slices.increase(sliceEnumeration.nextSlice(this.f6076o.m57225s()));
        }
        List<Slice<File>> slices2 = slices.getSlices();
        C9720a.m60652a(this.f6082u.size() == slices2.size(), "slices do not match server, fileName = " + this.f6078q.getName() + ", recordId = " + this.f6066e);
        return slices2;
    }

    /* renamed from: H */
    public Asset m8181H() throws Throwable {
        C11839m.m70688i("CloudSyncAssetUploader", "asset filebody upload start, file = " + this.f6078q.getName());
        this.f6064c = DriveSyncUtil.m17959D(this.f6063b);
        Asset asset = this.f6067f;
        if (asset == null) {
            throw new C9722c(2265, "upload asset is null, fileName = " + this.f6078q.getName() + ", recordId = " + this.f6066e, this.f6063b, "sync_upload_file");
        }
        Resource resource = asset.getResource();
        if (resource == null) {
            throw new C9722c(2218, "asset upload resource is empty, fileName = " + this.f6078q.getName() + ", assetId = " + this.f6067f.getId() + ", recordId = " + this.f6066e, this.f6063b, "sync_upload_file");
        }
        try {
            int iIntValue = resource.getState().intValue();
            C11839m.m70688i("CloudSyncAssetUploader", "asset resouce state = " + iIntValue);
            if (iIntValue == 0) {
                C11839m.m70688i("CloudSyncAssetUploader", "file already upload.");
                this.f6081t = true;
            } else {
                m8189y(resource);
                C11839m.m70688i("CloudSyncAssetUploader", "file need upload.");
            }
            Asset assetM8182r = m8182r();
            C11839m.m70686d("CloudSyncAssetUploader", "asset filebody upload end success, file = " + this.f6078q.getName() + ", asset = " + assetM8182r.toString());
            return assetM8182r;
        } catch (C9721b e10) {
            C11839m.m70688i("CloudSyncAssetUploader", "asset upload end error, file = " + this.f6078q.getName() + ", assetId = " + this.f6067f.getId() + ", recordId = " + this.f6066e + ", errorCode = " + e10.m60659c() + ", errorMsg = " + e10.getMessage());
            throw new C9722c(e10.m60659c(), "asset upload end error " + e10.getMessage() + "fileName = " + this.f6078q.getName() + ", assetId = " + this.f6067f.getId() + ", recordId = " + this.f6066e, this.f6063b, "sync_upload_file");
        } catch (Exception e11) {
            C11839m.m70688i("CloudSyncAssetUploader", "asset upload end exception, file = " + this.f6078q.getName() + ", assetId = " + this.f6067f.getId() + ", recordId = " + this.f6066e + ", errorMsg = " + e11.getMessage());
            throw new C9722c(2221, "asset upload end exception " + e11.getMessage() + "fileName = " + this.f6078q.getName() + ", assetId = " + this.f6067f.getId() + ", recordId = " + this.f6066e, this.f6063b, "sync_upload_file");
        }
    }

    /* renamed from: r */
    public Asset m8182r() throws C9721b {
        C11839m.m70688i("CloudSyncAssetUploader", "dealObjectCompleted");
        Asset asset = new Asset();
        asset.setId(this.f6067f.getId());
        asset.setVersionId(this.f6067f.getVersionId());
        if (!this.f6081t) {
            Resource resource = new Resource();
            ArrayList arrayList = new ArrayList();
            for (SliceObject sliceObject : this.f6067f.getResource().getObjects()) {
                SliceObject sliceObject2 = new SliceObject();
                sliceObject2.setObjectId(sliceObject.getId());
                SliceObject.UploadStatus uploadStatus = new SliceObject.UploadStatus();
                if (sliceObject.getUploadStatus() == null) {
                    throw new C9721b(2226, "after upload, upload status is null, objectId = " + sliceObject.getObjectId() + ", fileName = " + this.f6078q.getName() + ", recordId = " + this.f6066e);
                }
                uploadStatus.setBody(sliceObject.getUploadStatus().getBody());
                uploadStatus.setStatus(sliceObject.getUploadStatus().getStatus());
                if (m8174A()) {
                    uploadStatus.setHeaders(sliceObject.getUploadStatus().getHeaders());
                }
                sliceObject2.setUploadStatus(uploadStatus);
                arrayList.add(sliceObject2);
            }
            resource.setObjects(arrayList);
            resource.setHash(this.f6067f.getResource().getHash());
            resource.setSha256(this.f6067f.getResource().getSha256());
            asset.setResource(resource);
        }
        asset.setState(0);
        return asset;
    }

    /* renamed from: s */
    public final Resource m8183s(String str, Slice<File> slice, b bVar) throws Throwable {
        C11839m.m70688i("CloudSyncAssetUploader", "cloudsync uploadFileTask dealAssetExpired");
        try {
            Asset asset = new Asset();
            C14165b.a aVarM85037j = C14165b.m85037j(slice.getSliceItems());
            Resource resource = new Resource();
            ArrayList arrayList = new ArrayList();
            SliceObject sliceObject = new SliceObject();
            sliceObject.setSha256(aVarM85037j.m85045a());
            sliceObject.setLength(Long.valueOf(slice.getLength()));
            sliceObject.setObjectId(str);
            arrayList.add(sliceObject);
            resource.setHash(this.f6067f.getResource().getHash());
            resource.setSha256(this.f6067f.getResource().getSha256());
            resource.setObjects(arrayList);
            asset.setId(this.f6067f.getId());
            asset.setResource(resource);
            Asset assetM8175B = m8175B(this.f6064c, this.f6065d, this.f6066e, this.f6067f.getId(), this.f6067f.getVersionId(), asset, bVar);
            if (assetM8175B == null) {
                throw new C9721b(2265, "onCreateUploadUrl asset is null, resObjectId = " + str);
            }
            Resource resource2 = assetM8175B.getResource();
            if (resource2 == null) {
                throw new C9721b(2218, "onCreateUploadUrl resource is null, resObjectId = " + str);
            }
            List<SliceObject> objects = resource2.getObjects();
            if (objects == null || objects.size() <= 0) {
                throw new C9721b(2219, "onCreateUploadUrl resource object is null or empty, resObjectId = " + str);
            }
            SliceObject sliceObjectM8186v = m8186v(str, this.f6067f.getResource().getObjects());
            SliceObject sliceObjectM8186v2 = m8186v(str, objects);
            if (sliceObjectM8186v != null && sliceObjectM8186v2 != null) {
                sliceObjectM8186v.setAccelerateUploadUrl(sliceObjectM8186v2.getAccelerateUploadUrl());
                sliceObjectM8186v.setUploadUrl(sliceObjectM8186v2.getUploadUrl());
                sliceObjectM8186v.setModifiedTime(sliceObjectM8186v2.getModifiedTime());
                sliceObjectM8186v.setSha256(sliceObjectM8186v2.getSha256());
                sliceObjectM8186v.setMD5(sliceObjectM8186v2.getMD5());
            }
            return resource2;
        } catch (C9721b e10) {
            C11839m.m70687e("CloudSyncAssetUploader", "uploadFileTask get upload address error code = " + e10.m60659c() + ", fileName = " + this.f6078q.getName() + ", recordId = " + this.f6066e + ", resObjectId = " + str + ", assetId = " + this.f6067f.getId() + e10.getMessage());
            throw e10;
        }
    }

    /* renamed from: t */
    public void m8184t(List<C9066b> list) {
        Iterator<C9066b> it = list.iterator();
        while (it.hasNext()) {
            File fileM63441g = C10278a.m63441g(this.f6075n, it.next().m57179q());
            if (fileM63441g.exists()) {
                C11839m.m70686d("CloudSyncAssetUploader", "delete cache file result = " + fileM63441g.delete());
            }
        }
    }

    /* renamed from: u */
    public final void m8185u(C9721b c9721b) {
        synchronized (f6060A) {
            try {
                if (this.f6070i == null) {
                    this.f6070i = c9721b;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: v */
    public final SliceObject m8186v(String str, List<SliceObject> list) {
        for (SliceObject sliceObject : list) {
            if (sliceObject.getId().equals(str)) {
                return sliceObject;
            }
        }
        return null;
    }

    /* renamed from: w */
    public final long m8187w(List<Slice<File>> list) {
        Iterator<Slice<File>> it = list.iterator();
        long length = 0;
        while (it.hasNext()) {
            length += it.next().getLength();
        }
        return length;
    }

    /* renamed from: x */
    public final EndpointUrl m8188x(SliceObject sliceObject) throws C9721b {
        if (sliceObject == null) {
            throw new C9721b(2219, "getUploadEndpointUrl slice object null");
        }
        CloudSyncUtil.m16000d(this.f6086y, C5927g2.QUIC, String.valueOf(C13007b.m78205Y(C0213f.m1377a()).m78255d0() ? 1 : 0));
        if (sliceObject.getAccelerateUploadUrl() != null) {
            CloudSyncUtil.m16000d(this.f6086y, "accelerate", String.valueOf(1));
            return sliceObject.getAccelerateUploadUrl();
        }
        CloudSyncUtil.m16000d(this.f6086y, "accelerate", String.valueOf(0));
        return sliceObject.getUploadUrl();
    }

    /* renamed from: y */
    public final void m8189y(Resource resource) throws Throwable {
        C11839m.m70688i("CloudSyncAssetUploader", "innerUpload start");
        this.f6077p = this.f6067f.getCipher();
        m8179F(resource);
        m8178E(resource);
        List<Slice<File>> listM8180G = m8180G();
        this.f6079r = m8187w(listM8180G);
        C11839m.m70688i("CloudSyncAssetUploader", "innerUpload slice total length = " + this.f6079r);
        m8176C(listM8180G);
        C11839m.m70688i("CloudSyncAssetUploader", "innerUpload end");
    }

    /* renamed from: z */
    public final void m8190z() throws C9721b {
        if (this.f6068g) {
            throw new C9721b(1001, "user cancel.");
        }
    }
}
