package p803y9;

import android.content.Context;
import android.database.SQLException;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.connect.progress.ICallback;
import com.huawei.android.hicloud.connect.progress.IPreCallback;
import com.huawei.android.hicloud.p081cs.bean.AppSlice;
import com.huawei.android.hicloud.p081cs.bean.DownloadReq;
import com.huawei.android.hicloud.p081cs.bean.PropResult;
import com.huawei.android.hicloud.p081cs.bean.Properties;
import com.huawei.android.hicloud.p081cs.bean.Thumbnail;
import com.huawei.android.hicloud.security.bean.SliceDecryptReq;
import com.huawei.android.hicloud.security.bean.SliceEncryptReq;
import com.huawei.android.hicloud.security.bean.Unique;
import com.huawei.android.hicloud.security.bean.UniqueReq;
import com.huawei.hicloud.base.bean.Md5AndHash;
import com.huawei.hicloud.base.slice.FileLengthGetter;
import com.huawei.hicloud.base.slice.Slice;
import com.huawei.hicloud.base.slice.SliceEnumeration;
import com.huawei.hicloud.base.slice.SliceItem;
import com.huawei.hicloud.base.slice.Slices;
import com.huawei.hicloud.base.slice.StrLengthGetter;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.request.cbs.bean.CBSAppBaseReq;
import com.huawei.hicloud.request.cbs.bean.CBSAppMkFileReq;
import com.huawei.hicloud.request.cbs.bean.CBSAppResp;
import com.huawei.hicloud.request.opengw.bean.Address;
import com.huawei.hicloud.request.opengw.bean.AddressParams;
import com.huawei.hicloud.request.opengw.bean.DownloadAddress;
import com.huawei.hicloud.request.opengw.bean.ObjectAttribute;
import com.huawei.hicloud.request.opengw.bean.Objects;
import com.huawei.hicloud.request.opengw.bean.Result;
import com.huawei.hms.network.file.api.Progress;
import com.huawei.hms.network.file.api.Request;
import com.huawei.hms.network.file.api.Response;
import com.huawei.hms.network.file.api.exception.NetworkException;
import com.huawei.hms.network.file.download.api.DownloadManager;
import com.huawei.hms.network.file.download.api.FileRequestCallback;
import com.huawei.hms.network.file.download.api.GetRequest;
import com.huawei.hms.network.file.upload.api.BodyRequest;
import com.huawei.hms.network.file.upload.api.FileEntity;
import com.huawei.hms.network.file.upload.api.FileUploadCallback;
import com.huawei.hms.network.file.upload.api.PutRequest;
import com.huawei.hms.support.api.entity.pay.HwPayConstant;
import com.huawei.hms.videokit.player.common.PlayerConstants;
import fk.C9720a;
import fk.C9721b;
import hk.C10278a;
import hk.C10279b;
import java.io.Closeable;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import mk.C11476b;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0241z;
import p365ic.C10466a;
import p429kk.C11058a;
import p429kk.C11060c;
import p458lo.C11322a;
import p514o9.C11835i;
import p514o9.C11839m;
import p549p9.C12122a;
import p616rk.AbstractRunnableC12516b;
import p616rk.C12515a;
import p652t9.EnumC12999a;
import p673u9.C13139d;
import p673u9.C13140e;
import p673u9.C13141f;
import p704v9.C13386b;
import p704v9.C13387c;
import p704v9.C13388d;
import p709vj.C13452e;
import p712vm.C13468a;
import p733w9.C13576a;
import p767x9.AbstractC13734c;
import p767x9.C13733b;
import p767x9.C13735d;
import to.C13049a;

/* renamed from: y9.a */
/* loaded from: classes3.dex */
public class C13922a {

    /* renamed from: g */
    public static final Gson f62316g = new Gson();

    /* renamed from: h */
    public static final Object f62317h = new Object();

    /* renamed from: b */
    public String f62319b;

    /* renamed from: c */
    public EnumC12999a f62320c;

    /* renamed from: d */
    public C9721b f62321d;

    /* renamed from: e */
    public String f62322e;

    /* renamed from: a */
    public final Object f62318a = new Object();

    /* renamed from: f */
    public File f62323f = C11835i.m70645i(m83489M());

    /* renamed from: y9.a$a */
    public class a extends AbstractC13734c {

        /* renamed from: g */
        public final /* synthetic */ String f62324g;

        /* renamed from: h */
        public final /* synthetic */ C13388d f62325h;

        /* renamed from: i */
        public final /* synthetic */ C12122a f62326i;

        /* renamed from: j */
        public final /* synthetic */ GetRequest.Builder f62327j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(CountDownLatch countDownLatch, String str, C13388d c13388d, C12122a c12122a, GetRequest.Builder builder) {
            super(countDownLatch);
            this.f62324g = str;
            this.f62325h = c13388d;
            this.f62326i = c12122a;
            this.f62327j = builder;
        }

        @Override // p767x9.AbstractC13734c
        /* renamed from: f */
        public void mo61468f(CountDownLatch countDownLatch) throws InterruptedException, SQLException {
            GetRequest getRequestM82541k = null;
            try {
                C11839m.m70686d("CoreService2", this.f62324g + " SemaphoreDownloadTask begin:" + this.f62325h.m80461k());
                C13922a.this.m83495T(this.f62326i);
                getRequestM82541k = C13735d.m82531s().m82541k(C13922a.this.f62320c, this.f62327j, this.f62325h.m80469w(), C13922a.this.new g(this.f62325h, this.f62326i, countDownLatch));
                this.f62325h.m80453L(getRequestM82541k.getId());
                new C13139d().m79032k(this.f62325h);
                C13922a.this.m83500Y(countDownLatch, this.f62326i);
            } catch (C9721b e10) {
                C11839m.m70687e("CoreService2", "SemaphoreDownloadTask call: " + e10.toString());
                C13735d.m82531s().m82551y(C13922a.this.f62320c, getRequestM82541k);
            }
        }
    }

    /* renamed from: y9.a$b */
    public class b extends AbstractC13734c {

        /* renamed from: g */
        public final /* synthetic */ C13388d f62329g;

        /* renamed from: h */
        public final /* synthetic */ C12122a f62330h;

        /* renamed from: i */
        public final /* synthetic */ GetRequest.Builder f62331i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(CountDownLatch countDownLatch, C13388d c13388d, C12122a c12122a, GetRequest.Builder builder) {
            super(countDownLatch);
            this.f62329g = c13388d;
            this.f62330h = c12122a;
            this.f62331i = builder;
        }

        @Override // p767x9.AbstractC13734c
        /* renamed from: f */
        public void mo61468f(CountDownLatch countDownLatch) throws InterruptedException {
            GetRequest getRequestM82541k = null;
            try {
                C11839m.m70686d("CoreService2", " SemaphoreDownloadTask begin:" + this.f62329g.m80461k());
                C13922a.this.m83495T(this.f62330h);
                getRequestM82541k = C13735d.m82531s().m82541k(C13922a.this.f62320c, this.f62331i, -1L, C13922a.this.new g(this.f62329g, this.f62330h, countDownLatch));
                C13922a.this.m83500Y(countDownLatch, this.f62330h);
            } catch (C9721b e10) {
                C11839m.m70687e("CoreService2", "submitTaskToCloudTaskManager call back: " + e10.toString());
                if (getRequestM82541k != null) {
                    C13735d.m82531s().m82549w(C13922a.this.f62320c, getRequestM82541k.getId());
                }
            }
        }
    }

    /* renamed from: y9.a$c */
    public class c extends AbstractC13734c {

        /* renamed from: g */
        public final /* synthetic */ String f62333g;

        /* renamed from: h */
        public final /* synthetic */ C12122a f62334h;

        /* renamed from: i */
        public final /* synthetic */ GetRequest.Builder f62335i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(CountDownLatch countDownLatch, String str, C12122a c12122a, GetRequest.Builder builder) {
            super(countDownLatch);
            this.f62333g = str;
            this.f62334h = c12122a;
            this.f62335i = builder;
        }

        @Override // p767x9.AbstractC13734c
        /* renamed from: f */
        public void mo61468f(CountDownLatch countDownLatch) throws InterruptedException {
            GetRequest getRequestM82541k = null;
            try {
                C11839m.m70686d("CoreService2", " SemaphoreDownloadTask begin:" + this.f62333g);
                C13922a.this.m83495T(this.f62334h);
                getRequestM82541k = C13735d.m82531s().m82541k(C13922a.this.f62320c, this.f62335i, -1L, C13922a.this.new i(this.f62333g, this.f62334h, countDownLatch));
                C13922a.this.m83500Y(countDownLatch, this.f62334h);
            } catch (C9721b e10) {
                C11839m.m70687e("CoreService2", "submitTaskToCloudTaskManager call back: " + e10.toString());
                if (getRequestM82541k != null) {
                    C13735d.m82531s().m82549w(C13922a.this.f62320c, getRequestM82541k.getId());
                }
            }
        }
    }

    /* renamed from: y9.a$d */
    public class d extends AbstractC13734c {

        /* renamed from: g */
        public final /* synthetic */ C13388d f62337g;

        /* renamed from: h */
        public final /* synthetic */ C12122a f62338h;

        /* renamed from: i */
        public final /* synthetic */ GetRequest.Builder f62339i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(CountDownLatch countDownLatch, C13388d c13388d, C12122a c12122a, GetRequest.Builder builder) {
            super(countDownLatch);
            this.f62337g = c13388d;
            this.f62338h = c12122a;
            this.f62339i = builder;
        }

        @Override // p767x9.AbstractC13734c
        /* renamed from: f */
        public void mo61468f(CountDownLatch countDownLatch) throws InterruptedException, SQLException {
            GetRequest getRequestM82541k = null;
            try {
                C11839m.m70686d("CoreService2", " SemaphoreDownloadTask begin:" + this.f62337g.m80461k());
                C13922a.this.m83495T(this.f62338h);
                getRequestM82541k = C13735d.m82531s().m82541k(C13922a.this.f62320c, this.f62339i, -1L, C13922a.this.new f(this.f62337g, this.f62338h, countDownLatch));
                this.f62337g.m80453L(getRequestM82541k.getId());
                new C13139d().m79032k(this.f62337g);
                C13922a.this.m83500Y(countDownLatch, this.f62338h);
            } catch (C9721b e10) {
                C11839m.m70687e("CoreService2", "submitTaskToCloudTaskManager call back: " + e10.toString());
                if (getRequestM82541k != null) {
                    C13735d.m82531s().m82549w(C13922a.this.f62320c, getRequestM82541k.getId());
                }
            }
        }
    }

    /* renamed from: y9.a$e */
    public class e extends AbstractRunnableC12516b {

        /* renamed from: a */
        public C13388d f62341a;

        /* renamed from: b */
        public String f62342b;

        /* renamed from: c */
        public String f62343c;

        /* renamed from: d */
        public int f62344d;

        /* renamed from: e */
        public CountDownLatch f62345e;

        public e(C13388d c13388d, String str, String str2, int i10, CountDownLatch countDownLatch) {
            this.f62341a = c13388d;
            this.f62342b = str;
            this.f62343c = str2;
            this.f62344d = i10;
            this.f62345e = countDownLatch;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            String str = C13922a.this.f62323f + "/" + this.f62341a.m80457e();
            SliceDecryptReq sliceDecryptReq = new SliceDecryptReq();
            sliceDecryptReq.setTraceID(C13922a.this.f62319b);
            sliceDecryptReq.setDesFile(this.f62341a.m80464r());
            sliceDecryptReq.setSrcFile(str);
            sliceDecryptReq.setOffset(this.f62341a.m80462p());
            sliceDecryptReq.setEfek(this.f62342b);
            sliceDecryptReq.setIv(this.f62343c);
            sliceDecryptReq.setType(this.f62344d);
            try {
                try {
                    C10466a.m64314e(sliceDecryptReq);
                } catch (C9721b e10) {
                    C13922a.this.m83486J(e10);
                    File fileM63442h = C10278a.m63442h(str);
                    if (fileM63442h.exists()) {
                        C11839m.m70686d("CoreService2", "encrypt file exits, delete = " + fileM63442h.delete());
                    }
                }
            } finally {
                this.f62345e.countDown();
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

    /* renamed from: y9.a$f */
    public class f extends FileRequestCallback {

        /* renamed from: a */
        public C13388d f62347a;

        /* renamed from: b */
        public C12122a f62348b;

        /* renamed from: c */
        public CountDownLatch f62349c;

        /* renamed from: d */
        public long f62350d = 0;

        /* renamed from: e */
        public final Object f62351e = new Object();

        /* renamed from: f */
        public final Object f62352f = new Object();

        public f(C13388d c13388d, C12122a c12122a, CountDownLatch countDownLatch) {
            this.f62347a = c13388d;
            this.f62348b = c12122a;
            this.f62349c = countDownLatch;
        }

        @Override // com.huawei.hms.network.file.api.Callback
        public /* bridge */ /* synthetic */ void onException(Request request, NetworkException networkException, Response response) {
            onException((GetRequest) request, networkException, (Response<GetRequest, File, Closeable>) response);
        }

        @Override // com.huawei.hms.network.file.api.Callback
        public void onSuccess(Response<GetRequest, File, Closeable> response) {
            try {
                try {
                    C11839m.m70688i("CoreService2", "taskId [" + ((GetRequest) response.getRequest()).getId() + "]app slice object [" + this.f62347a.m80465s() + "] download end.");
                } catch (C9721b e10) {
                    C11839m.m70687e("CoreService2", "taskId [" + ((GetRequest) response.getRequest()).getId() + "]slice object [" + this.f62347a.m80465s() + "] download decrypt error." + e10);
                    C13922a.this.m83486J(e10);
                }
                if (this.f62348b.mo17782d()) {
                    return;
                }
                synchronized (this.f62352f) {
                    this.f62347a.m80451J(1);
                    new C13139d().m79032k(this.f62347a);
                }
                C11839m.m70688i("CoreService2", "taskId [" + ((GetRequest) response.getRequest()).getId() + "]slice object [" + this.f62347a.m80465s() + "] download success.");
            } finally {
                release();
            }
        }

        public final void release() {
            CountDownLatch countDownLatch = this.f62349c;
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
        }

        public void onException(GetRequest getRequest, NetworkException networkException, Response<GetRequest, File, Closeable> response) {
            C11839m.m70687e("CoreService2", "taskId [" + getRequest.getId() + "]slice object [" + this.f62347a.m80465s() + "] download error. " + networkException.toString());
            C13922a.this.m83486J(new C9721b(4307, networkException.toString(), "Download"));
            synchronized (this.f62352f) {
                try {
                    if (this.f62347a.m80467u() == 1) {
                        return;
                    }
                    release();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // com.huawei.hms.network.file.api.Callback
        public void onProgress(GetRequest getRequest, Progress progress) {
            C11839m.m70686d("CoreService2", "taskId [" + getRequest.getId() + "]app slice object [" + this.f62347a.m80465s() + "] download progress = " + progress.getProgress() + "size = " + progress.getFinishedSize());
            synchronized (this.f62351e) {
                try {
                    long totalSize = progress.getTotalSize();
                    long finishedSize = progress.getFinishedSize();
                    long j10 = this.f62350d;
                    if (j10 <= totalSize) {
                        this.f62348b.m72686c(finishedSize - j10);
                        this.f62350d = finishedSize;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // com.huawei.hms.network.file.api.Callback
        public GetRequest onStart(GetRequest getRequest) {
            C11839m.m70688i("CoreService2", "taskId [" + getRequest.getId() + "]app slice object [" + this.f62347a.m80465s() + "] get download address.");
            try {
                return getRequest.newBuilder().url(new C11322a(C13922a.this.f62319b).m68005L(this.f62347a.m80456b())).build();
            } catch (C9721b e10) {
                C11839m.m70687e("CoreService2", "taskId [" + getRequest.getId() + "]app slice object [" + this.f62347a.m80465s() + "] get download address error." + e10);
                C13922a.this.m83486J(e10);
                return getRequest;
            }
        }
    }

    /* renamed from: y9.a$g */
    public class g extends FileRequestCallback {

        /* renamed from: a */
        public C13388d f62354a;

        /* renamed from: b */
        public C12122a f62355b;

        /* renamed from: c */
        public CountDownLatch f62356c;

        /* renamed from: d */
        public long f62357d = 0;

        /* renamed from: e */
        public final Object f62358e = new Object();

        /* renamed from: f */
        public final Object f62359f = new Object();

        public g(C13388d c13388d, C12122a c12122a, CountDownLatch countDownLatch) {
            this.f62354a = c13388d;
            this.f62355b = c12122a;
            this.f62356c = countDownLatch;
        }

        private void release() {
            CountDownLatch countDownLatch = this.f62356c;
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
        }

        @Override // com.huawei.hms.network.file.api.Callback
        public /* bridge */ /* synthetic */ void onException(Request request, NetworkException networkException, Response response) {
            onException((GetRequest) request, networkException, (Response<GetRequest, File, Closeable>) response);
        }

        @Override // com.huawei.hms.network.file.api.Callback
        public void onSuccess(Response<GetRequest, File, Closeable> response) {
            try {
                try {
                    C11839m.m70688i("CoreService2", "taskId [" + ((GetRequest) response.getRequest()).getId() + "]slice object [" + this.f62354a.m80461k() + "] cache [" + this.f62354a.m80457e() + "] download end.");
                } catch (C9721b e10) {
                    C11839m.m70687e("CoreService2", "taskId [" + ((GetRequest) response.getRequest()).getId() + "]slice object [" + this.f62354a.m80461k() + "] cache [" + this.f62354a.m80457e() + "] download decrypt error." + e10);
                    C13922a.this.m83486J(e10);
                }
                if (this.f62354a.m80465s().isEmpty()) {
                    return;
                }
                if (this.f62355b.mo17782d()) {
                    return;
                }
                synchronized (this.f62359f) {
                    this.f62354a.m80451J(1);
                    new C13139d().m79032k(this.f62354a);
                }
                C11839m.m70688i("CoreService2", "taskId [" + ((GetRequest) response.getRequest()).getId() + "]slice object [" + this.f62354a.m80461k() + "] cache [" + this.f62354a.m80457e() + "] download success.");
            } finally {
                release();
            }
        }

        public void onException(GetRequest getRequest, NetworkException networkException, Response<GetRequest, File, Closeable> response) {
            synchronized (this.f62359f) {
                try {
                    if (this.f62354a.m80467u() == 1) {
                        return;
                    }
                    C11839m.m70687e("CoreService2", "taskId [" + getRequest.getId() + "]slice object [" + this.f62354a.m80461k() + "] cache [" + this.f62354a.m80457e() + "] download error. " + networkException.toString());
                    String strValueOf = String.valueOf(response.getCode());
                    C11839m.m70687e("CoreService2", "error code:" + strValueOf);
                    String str = response.getMessage() + "_OBS";
                    if (TextUtils.isEmpty(strValueOf)) {
                        C13922a.this.m83486J(new C9721b(4307, 4307, networkException.toString(), "Download"));
                    } else if (strValueOf.equals(String.valueOf(404))) {
                        C13922a.this.m83486J(new C9721b(404, C0241z.m1685c(strValueOf), str, "Download"));
                    } else {
                        C13922a.this.m83486J(new C9721b(4307, C0241z.m1685c(strValueOf), str, "Download"));
                    }
                    release();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // com.huawei.hms.network.file.api.Callback
        public void onProgress(GetRequest getRequest, Progress progress) {
            C11839m.m70686d("CoreService2", "slice object [" + this.f62354a.m80461k() + "] download progress = " + progress.getProgress() + "size = " + progress.getFinishedSize() + ", speed = " + progress.getSpeed());
            synchronized (this.f62358e) {
                try {
                    long finishedSize = progress.getFinishedSize();
                    long totalSize = progress.getTotalSize();
                    long j10 = this.f62357d;
                    if (j10 <= totalSize) {
                        this.f62355b.m72686c(finishedSize - j10);
                        this.f62357d = finishedSize;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // com.huawei.hms.network.file.api.Callback
        public GetRequest onStart(GetRequest getRequest) throws C9721b {
            C11839m.m70688i("CoreService2", "taskId [" + getRequest.getId() + "]slice object [" + this.f62354a.m80461k() + "] cache [" + this.f62354a.m80457e() + "] get download address.");
            if (this.f62354a.m80465s().isEmpty()) {
                C11839m.m70689w("CoreService2", "slice object [" + this.f62354a.m80461k() + "] is thumbnail, do not get download address.");
                return getRequest;
            }
            try {
                HashMap map = new HashMap();
                map.put("bucket", this.f62354a.m80456b());
                map.put("timestamp", this.f62354a.m80470x());
                map.put("objectId", this.f62354a.m80461k());
                map.put("synckey", this.f62354a.m80468v());
                HashMap map2 = new HashMap();
                map2.put("x-nsp-scheme", "https");
                map.put("headers", map2);
                Address address = new C13049a(C13922a.this.f62320c, C13922a.this.f62319b).m78748m(Collections.singletonList(map)).get(0);
                String state = address.getState();
                if ("0".equals(state)) {
                    return getRequest.newBuilder().url(address.getUrl()).headers(address.getHeaders()).build();
                }
                C11839m.m70687e("CoreService2", C13922a.this.m83487K("getDownloadAddress", "error state = " + state));
                throw new C9721b(4000, C0241z.m1685c(state), "get download address failed.", "getDownloadAddress");
            } catch (C9721b e10) {
                C11839m.m70687e("CoreService2", "taskId [" + getRequest.getId() + "]slice object [" + this.f62354a.m80461k() + "] cache [" + this.f62354a.m80457e() + "] get download address error." + e10);
                C13922a.this.m83486J(e10);
                return getRequest;
            }
        }
    }

    /* renamed from: y9.a$h */
    public static class h extends TypeToken<List<Map<String, String>>> {
    }

    /* renamed from: y9.a$i */
    public class i extends FileRequestCallback {

        /* renamed from: a */
        public String f62361a;

        /* renamed from: b */
        public C12122a f62362b;

        /* renamed from: c */
        public CountDownLatch f62363c;

        /* renamed from: d */
        public long f62364d = 0;

        /* renamed from: e */
        public final Object f62365e = new Object();

        public i(String str, C12122a c12122a, CountDownLatch countDownLatch) {
            this.f62361a = str;
            this.f62362b = c12122a;
            this.f62363c = countDownLatch;
        }

        @Override // com.huawei.hms.network.file.api.Callback
        public /* bridge */ /* synthetic */ void onException(Request request, NetworkException networkException, Response response) {
            onException((GetRequest) request, networkException, (Response<GetRequest, File, Closeable>) response);
        }

        @Override // com.huawei.hms.network.file.api.Callback
        public void onSuccess(Response<GetRequest, File, Closeable> response) {
            this.f62363c.countDown();
        }

        public void onException(GetRequest getRequest, NetworkException networkException, Response<GetRequest, File, Closeable> response) {
            C11839m.m70687e("CoreService2", "taskId [" + getRequest.getId() + "] download error. " + networkException.toString());
            C13922a.this.m83486J(new C9721b(4307, networkException.toString(), "Download"));
            this.f62363c.countDown();
        }

        @Override // com.huawei.hms.network.file.api.Callback
        public void onProgress(GetRequest getRequest, Progress progress) {
            C11839m.m70686d("CoreService2", "taskId [" + getRequest.getId() + "] download progress = " + progress.getProgress() + "size = " + progress.getFinishedSize() + ", speed: " + progress.getSpeed());
            synchronized (this.f62365e) {
                try {
                    long totalSize = progress.getTotalSize();
                    long finishedSize = progress.getFinishedSize();
                    long j10 = this.f62364d;
                    if (j10 <= totalSize) {
                        this.f62362b.m72686c(finishedSize - j10);
                        this.f62364d = finishedSize;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // com.huawei.hms.network.file.api.Callback
        public GetRequest onStart(GetRequest getRequest) {
            return getRequest.newBuilder().url(this.f62361a).build();
        }
    }

    /* renamed from: y9.a$j */
    public class j extends FileUploadCallback {

        /* renamed from: a */
        public CBSAppBaseReq f62367a;

        /* renamed from: b */
        public CountDownLatch f62368b;

        /* renamed from: c */
        public String f62369c;

        /* renamed from: d */
        public C11322a f62370d;

        public j(CBSAppBaseReq cBSAppBaseReq, CountDownLatch countDownLatch) {
            this.f62370d = new C11322a(C13922a.this.f62319b);
            this.f62367a = cBSAppBaseReq;
            this.f62368b = countDownLatch;
        }

        @Override // com.huawei.hms.network.file.api.Callback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onException(BodyRequest bodyRequest, NetworkException networkException, Response<BodyRequest, String, Closeable> response) {
            C11839m.m70687e("CoreService2", "taskId [" + bodyRequest.getId() + "]app slice object [" + this.f62367a.getPath() + "] upload error." + networkException.toString());
            C13922a.this.m83486J(new C9721b(4307, networkException.toString(), "Upload"));
            this.f62368b.countDown();
        }

        @Override // com.huawei.hms.network.file.api.Callback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onProgress(BodyRequest bodyRequest, Progress progress) {
        }

        @Override // com.huawei.hms.network.file.api.Callback
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public BodyRequest onStart(BodyRequest bodyRequest) throws C9721b {
            C11839m.m70688i("CoreService2", "taskId [" + bodyRequest.getId() + "]app slice object [" + this.f62367a.getPath() + "] get upload address.");
            try {
                CBSAppResp cBSAppRespM68006M = this.f62370d.m68006M(this.f62367a);
                String aPPBucketId = cBSAppRespM68006M.getAPPBucketId();
                this.f62369c = aPPBucketId;
                if (aPPBucketId == null || aPPBucketId.isEmpty()) {
                    throw new C9721b(3107, "upload app failed. queryUploadParams bucketId is null.");
                }
                return (BodyRequest) bodyRequest.newBuilder().url(cBSAppRespM68006M.getUrl()).headers(cBSAppRespM68006M.getHeaders()).build();
            } catch (C9721b e10) {
                C11839m.m70687e("CoreService2", "taskId [" + bodyRequest.getId() + "]app slice object [" + this.f62367a.getPath() + "] get upload address error." + e10);
                C13922a.this.m83486J(e10);
                return bodyRequest;
            }
        }

        @Override // com.huawei.hms.network.file.api.Callback
        public void onSuccess(Response<BodyRequest, String, Closeable> response) throws Throwable {
            C11839m.m70688i("CoreService2", "taskId [" + ((BodyRequest) response.getRequest()).getId() + "]app slice object [" + this.f62367a.getPath() + "] upload success.");
            try {
                this.f62370d.m68018b(new CBSAppMkFileReq(this.f62367a.getPath(), this.f62367a.getMD5(), this.f62367a.getSha256(), this.f62367a.getSize(), this.f62369c));
            } catch (C9721b e10) {
                C13922a.this.m83486J(e10);
            }
            this.f62368b.countDown();
            C11839m.m70688i("CoreService2", "taskId [" + ((BodyRequest) response.getRequest()).getId() + "]app slice object [" + this.f62367a.getPath() + "] mkfile success.");
        }
    }

    /* renamed from: y9.a$k */
    public class k extends AbstractRunnableC12516b {

        /* renamed from: a */
        public Slice<File> f62372a;

        /* renamed from: b */
        public CountDownLatch f62373b;

        /* renamed from: c */
        public C13386b f62374c;

        /* renamed from: d */
        public C13387c f62375d;

        /* renamed from: e */
        public C12122a f62376e;

        /* renamed from: f */
        public C11060c f62377f;

        /* renamed from: g */
        public List<Long> f62378g;

        public k(Slice<File> slice, C13386b c13386b, C13387c c13387c, C12122a c12122a, List<Long> list, C11060c c11060c, CountDownLatch countDownLatch) {
            this.f62372a = slice;
            this.f62374c = c13386b;
            this.f62375d = c13387c;
            this.f62376e = c12122a;
            this.f62377f = c11060c;
            this.f62378g = list;
            this.f62373b = countDownLatch;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            try {
                try {
                    Slice sliceM83485I = C13922a.this.m83485I(this.f62372a, this.f62375d);
                    PutRequest putRequestM83510x = C13922a.this.m83510x(sliceM83485I, this.f62374c.m80397q(), C13922a.this.m83507u(this.f62377f, null));
                    synchronized (C13922a.this.f62318a) {
                        try {
                            if (C13922a.this.f62322e == null || C13922a.this.f62322e.isEmpty()) {
                                Address addressM83493R = C13922a.this.m83493R(sliceM83485I, this.f62374c, this.f62377f);
                                putRequestM83510x = ((PutRequest.Builder) ((PutRequest.Builder) putRequestM83510x.newBuilder().url(addressM83493R.getUrl())).headers(addressM83493R.getHeaders())).build();
                                C13922a.this.f62322e = addressM83493R.getBucket();
                                new C13140e().m79038k(this.f62374c);
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                    this.f62374c.m80402v(C13922a.this.f62322e);
                    this.f62377f.m66667w(C13922a.this.f62322e);
                    CountDownLatch countDownLatch = new CountDownLatch(1);
                    C13735d.m82531s().m82543m(C13922a.this.f62320c, putRequestM83510x, this.f62378g, C13922a.this.new l(sliceM83485I, this.f62374c, this.f62376e, this.f62377f, countDownLatch));
                    C13922a.this.m83500Y(countDownLatch, this.f62376e);
                } catch (C9721b e10) {
                    C13922a.this.m83486J(e10);
                }
            } finally {
                this.f62373b.countDown();
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

    /* renamed from: y9.a$l */
    public class l extends FileUploadCallback {

        /* renamed from: a */
        public Slice<File> f62380a;

        /* renamed from: b */
        public C13386b f62381b;

        /* renamed from: c */
        public C12122a f62382c;

        /* renamed from: d */
        public CountDownLatch f62383d;

        /* renamed from: e */
        public long f62384e;

        /* renamed from: f */
        public final Object f62385f = new Object();

        /* renamed from: g */
        public C11060c f62386g;

        public l(Slice<File> slice, C13386b c13386b, C12122a c12122a, C11060c c11060c, CountDownLatch countDownLatch) {
            this.f62380a = slice;
            this.f62381b = c13386b;
            this.f62382c = c12122a;
            this.f62383d = countDownLatch;
            this.f62386g = c11060c;
        }

        /* renamed from: d */
        private void m83515d() {
            CountDownLatch countDownLatch = this.f62383d;
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
            Slice<File> slice = this.f62380a;
            if (slice != null) {
                Iterator<SliceItem<File>> it = slice.getSliceItems().iterator();
                while (it.hasNext()) {
                    File object = it.next().getObject();
                    if (object.exists()) {
                        C11839m.m70686d("CoreService2", "encrypt file exits, delete = " + object.delete());
                    }
                }
            }
        }

        @Override // com.huawei.hms.network.file.api.Callback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onException(BodyRequest bodyRequest, NetworkException networkException, Response<BodyRequest, String, Closeable> response) {
            C11839m.m70687e("CoreService2", "taskId [" + bodyRequest.getId() + "]slice object [" + this.f62381b.m80397q() + "] upload error." + networkException.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(C0209d.m1331z(networkException.getMessage()));
            sb2.append("&");
            sb2.append(networkException.getMessage());
            C13922a.this.m83486J(new C9721b(4307, response.getCode(), sb2.toString(), "Upload"));
            m83515d();
        }

        @Override // com.huawei.hms.network.file.api.Callback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onProgress(BodyRequest bodyRequest, Progress progress) {
            synchronized (this.f62385f) {
                C11839m.m70686d("CoreService2", "taskId [" + bodyRequest.getId() + "]slice object [" + this.f62381b.m80397q() + "] upload progress = " + progress.getProgress() + "size = " + progress.getFinishedSize());
                long finishedSize = progress.getFinishedSize();
                long j10 = finishedSize - this.f62384e;
                this.f62384e = finishedSize;
                this.f62382c.m72686c(j10);
            }
        }

        @Override // com.huawei.hms.network.file.api.Callback
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public BodyRequest onStart(BodyRequest bodyRequest) throws Throwable {
            C11839m.m70688i("CoreService2", "taskId [" + bodyRequest.getId() + "]slice object [" + this.f62381b.m80397q() + "] get upload address.");
            try {
                C13922a.this.m83495T(this.f62382c);
                Address addressM83493R = C13922a.this.m83493R(this.f62380a, this.f62381b, this.f62386g);
                C11839m.m70686d("CoreService2", "url: " + addressM83493R.getUrl());
                return (BodyRequest) bodyRequest.newBuilder().url(addressM83493R.getUrl()).headers(addressM83493R.getHeaders()).build();
            } catch (C9721b e10) {
                C11839m.m70687e("CoreService2", "taskId [" + bodyRequest.getId() + "]slice object [" + this.f62381b.m80397q() + "] get upload address error." + e10.toString());
                C13922a.this.m83486J(e10);
                return bodyRequest;
            }
        }

        @Override // com.huawei.hms.network.file.api.Callback
        public void onSuccess(Response<BodyRequest, String, Closeable> response) {
            C11839m.m70688i("CoreService2", "taskId [" + ((BodyRequest) response.getRequest()).getId() + "]slice object [" + this.f62381b.m80397q() + "] upload end.");
            try {
                try {
                    synchronized (this.f62385f) {
                        long length = this.f62380a.getLength();
                        C11839m.m70686d("CoreService2", "upload size = " + length);
                        long j10 = length - this.f62384e;
                        this.f62384e = length;
                        this.f62382c.m72686c(j10);
                    }
                    C13922a.this.m83495T(this.f62382c);
                } catch (C9721b e10) {
                    C13922a.this.m83486J(e10);
                }
                if (response.getResponseHeader() != null && !response.getResponseHeader().isEmpty()) {
                    HashMap map = new HashMap();
                    map.put("headers", C13922a.f62316g.toJson(response.getResponseHeader()));
                    map.put("responseCode", "200");
                    map.put("body", response.getContent());
                    map.put("bucket", this.f62381b.m80390b());
                    map.put("objectId", this.f62381b.m80397q());
                    map.put("objectSize", String.valueOf(this.f62380a.getLength()));
                    map.put("timestamp", this.f62381b.m80401u());
                    HashMap map2 = new HashMap();
                    map2.put("bucket", this.f62381b.m80390b());
                    map2.put("objectKey", this.f62381b.m80397q());
                    map2.put("size", String.valueOf(this.f62380a.getLength()));
                    map.put("attrs", C13922a.f62316g.toJson(map2));
                    new C13049a(C13922a.this.f62320c, C13922a.this.f62319b).m78747l0(map, this.f62386g);
                    this.f62381b.m80386D(1);
                    new C13140e().m79038k(this.f62381b);
                    C11839m.m70688i("CoreService2", "taskId [" + ((BodyRequest) response.getRequest()).getId() + "]slice object [" + this.f62381b.m80397q() + "] upload success.");
                    C13922a.this.m83495T(this.f62382c);
                    return;
                }
                C11839m.m70687e("CoreService2", "taskId [" + ((BodyRequest) response.getRequest()).getId() + "]slice object [" + this.f62381b.m80397q() + "] response is null.");
                int code = response.getCode();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("error code:");
                sb2.append(code);
                C11839m.m70687e("CoreService2", sb2.toString());
                C13922a.this.m83486J(new C9721b(4307, code, "taskId [" + ((BodyRequest) response.getRequest()).getId() + "]slice object [" + this.f62381b.m80397q() + "] response is null.", "upload"));
            } finally {
                m83515d();
            }
        }
    }

    public C13922a(EnumC12999a enumC12999a, String str) {
        this.f62320c = enumC12999a;
        this.f62319b = str;
    }

    /* renamed from: Q */
    public static SliceEnumeration<String> m83460Q(Objects objects, boolean z10) throws C9721b {
        List<String> listSubList;
        long j10;
        long j11;
        C11839m.m70686d("CoreService2", "get slice enumeration by objects.");
        List<ObjectAttribute> attributes = objects.getAttributes();
        long length = attributes.get(0).getLength();
        long sliceSize = objects.getSliceSize();
        long j12 = ((length - 1) / sliceSize) + 1;
        List<String> objectKeys = objects.getObjectKeys();
        C9720a.m60652a(((long) objectKeys.size()) >= j12, "objects is not valid.");
        if (z10) {
            listSubList = objectKeys.subList(0, (int) j12);
            long j13 = length % sliceSize;
            if (j13 == 0) {
                j13 = sliceSize;
            }
            j10 = j12;
            j11 = j13;
        } else {
            C9720a.m60652a(((long) objectKeys.size()) > j12, "no thumnails in cloud.");
            listSubList = objectKeys.subList((int) j12, objectKeys.size());
            int size = attributes.size();
            long length2 = 0;
            for (int i10 = 1; i10 < size; i10++) {
                length2 += attributes.get(i10).getLength();
            }
            long j14 = ((length2 - 1) / sliceSize) + 1;
            long j15 = length2 % sliceSize;
            if (j15 == 0) {
                j15 = sliceSize;
            }
            j10 = j14;
            j11 = j15;
        }
        return new SliceEnumeration<>(listSubList, new StrLengthGetter(j10, sliceSize, j11));
    }

    /* renamed from: z */
    public static boolean m83476z(Object[] objArr, Object obj) {
        for (Object obj2 : objArr) {
            if (obj2.equals(obj)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: A */
    public final void m83477A(List<C13388d> list, String str, String str2, int i10, C12122a c12122a) throws InterruptedException, C9721b {
        CountDownLatch countDownLatch = new CountDownLatch(list.size());
        ArrayList arrayList = new ArrayList();
        Iterator<C13388d> it = list.iterator();
        while (it.hasNext()) {
            e eVar = new e(it.next(), str, str2, i10, countDownLatch);
            arrayList.add(eVar);
            C12515a.m75110o().m75172d(eVar);
        }
        try {
            m83500Y(countDownLatch, c12122a);
        } catch (C9721b e10) {
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                ((e) it2.next()).cancel();
            }
            C11839m.m70687e("CoreService2", e10.toString());
            throw e10;
        }
    }

    /* renamed from: B */
    public final void m83478B(List<File> list, C13387c c13387c, C12122a c12122a, C11060c c11060c) throws Throwable {
        String str;
        String str2 = " length = ";
        String str3 = " fid = ";
        String str4 = "file = ";
        String str5 = "CoreService2";
        C11839m.m70688i("CoreService2", "file slices encrypt upload start.");
        Slices slices = new Slices();
        SliceEnumeration sliceEnumeration = new SliceEnumeration(list, new FileLengthGetter());
        while (sliceEnumeration.hasMoreSlices()) {
            slices.increase(sliceEnumeration.nextSlice(c13387c.m80429n()));
        }
        c12122a.mo17785g(slices.getTotal());
        List<C13386b> listM79037j = new C13140e().m79037j(this.f62320c.m78143b(), c13387c.m80421f());
        Collections.sort(listM79037j);
        C9720a.m60652a(listM79037j.size() == slices.getSlices().size(), "slices do not match server.");
        LinkedList linkedList = new LinkedList(slices.getSlices());
        CountDownLatch countDownLatch = new CountDownLatch(listM79037j.size());
        this.f62322e = listM79037j.get(0).m80390b();
        ArrayList arrayList = new ArrayList();
        boolean z10 = false;
        for (C13386b c13386b : listM79037j) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("slice object [");
            ArrayList arrayList2 = arrayList;
            sb2.append(c13386b.m80397q());
            sb2.append("] upload start.");
            C11839m.m70688i(str5, sb2.toString());
            m83495T(c12122a);
            Slice slice = (Slice) linkedList.poll();
            if (slice == null) {
                throw new C9721b(4001, "file is null", "doUpload");
            }
            String str6 = str4;
            if (c13386b.m80399s() == 1 && (str = this.f62322e) != null && str.equals(c13386b.m80390b())) {
                C11839m.m70686d(str5, "slice object [" + c13386b.m80397q() + "] already upload.");
                c12122a.m72687h(slice.getLength());
                countDownLatch.countDown();
                arrayList = arrayList2;
                str4 = str6;
            } else {
                CountDownLatch countDownLatch2 = countDownLatch;
                C12515a.m75110o().m75172d(new k(slice, c13386b, c13387c, c12122a, arrayList2, c11060c, countDownLatch2));
                str2 = str2;
                arrayList = arrayList2;
                countDownLatch = countDownLatch2;
                linkedList = linkedList;
                str5 = str5;
                str4 = str6;
                str3 = str3;
                z10 = true;
            }
        }
        ArrayList arrayList3 = arrayList;
        String str7 = str5;
        String str8 = str4;
        String str9 = str3;
        String str10 = str2;
        try {
            m83500Y(countDownLatch, c12122a);
            c12122a.mo17784f(slices.getTotal());
            c12122a.mo17783e(true);
            c13387c.m80412F(2);
            c13387c.m80414H(System.currentTimeMillis());
            new C13141f().m79044k(c13387c);
            if (z10) {
                c11060c.m66665u(EnumC12999a.CLOUD_ALBUM.equals(this.f62320c) ? "0:1" : "117_200");
                c11060c.m66635A("success");
                c11060c.m66638D(str8 + list.get(0).getName() + str9 + c13387c.m80423h() + str10 + c13387c.m80427l());
                c11060c.m66641G(String.valueOf(c12122a.m72685b()));
                c11060c.m66642H(String.valueOf(c13387c.m80432q() - c13387c.m80416a()));
            }
        } catch (C9721b e10) {
            C9721b c9721b = e10;
            C13735d.m82531s().m82538h(this.f62320c, arrayList3);
            C11839m.m70687e(str7, c9721b.toString());
            if (c9721b.m60659c() == 4307 || c9721b.m60659c() == 4207) {
                C13468a c13468aM81100c = C13468a.m81100c();
                boolean zM81101b = c13468aM81100c.m81101b();
                String str11 = c11060c.m66648d() + c13468aM81100c.toString() + c9721b.toString();
                if (!zM81101b) {
                    c9721b = new C9721b(PlayerConstants.ErrorCode.DEFAULT_ERROR, str11);
                }
            }
            c11060c.m66665u(EnumC12999a.CLOUD_ALBUM.equals(this.f62320c) ? "117_" + c9721b.m60659c() + "_" + c9721b.m60663g() + ":1" : "117_" + c9721b.m60659c());
            c11060c.m66635A(c9721b.getMessage());
            c11060c.m66638D(str8 + list.get(0).getName() + str9 + c13387c.m80423h() + str10 + c13387c.m80427l());
            c11060c.m66641G(String.valueOf(c12122a.m72685b()));
            throw c9721b;
        }
    }

    /* renamed from: C */
    public void m83479C(DownloadReq downloadReq, C11060c c11060c) throws Throwable {
        long length = downloadReq.getLength();
        String local = downloadReq.getLocal();
        File fileM63442h = C10278a.m63442h(local);
        if (fileM63442h.exists() && fileM63442h.length() >= length && length != 0) {
            C11839m.m70689w("CoreService2", "file alredy exits, size = " + fileM63442h.length() + " while download file size = " + length);
            return;
        }
        C12122a c12122a = new C12122a(downloadReq.getCallback());
        c12122a.mo17785g(length);
        m83495T(c12122a);
        try {
            m83481E(c11060c, length, local, c12122a, downloadReq.getUrl());
        } catch (C9721b e10) {
            C11839m.m70687e("CoreService2", m83487K(e10.m60658b(), e10, fileM63442h));
            String str = "117_" + e10.m60659c();
            if (EnumC12999a.CLOUD_ALBUM.equals(this.f62320c)) {
                str = str + ":1";
            }
            c11060c.m66665u(str);
            c11060c.m66635A(fileM63442h.getName() + ", " + e10.getMessage());
            c11060c.m66640F(String.valueOf(c12122a.m72685b()));
            throw e10;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v4, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r14v5 */
    /* JADX WARN: Type inference failed for: r14v7 */
    /* JADX WARN: Type inference failed for: r2v10, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [w9.a] */
    /* JADX WARN: Type inference failed for: r3v25 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* renamed from: D */
    public void m83480D(String str, String str2, ICallback iCallback, C11060c c11060c) throws Throwable {
        String str3;
        ?? r32;
        long jCurrentTimeMillis;
        C12122a c12122a;
        Properties properties;
        Objects objects;
        int i10;
        long length;
        int i11;
        SliceEnumeration<String> sliceEnumerationM83460Q;
        int i12;
        CountDownLatch countDownLatch;
        List<C13388d> list;
        String str4;
        long j10;
        C12122a c12122a2;
        String str5;
        int i13;
        a aVar;
        Slice<String> slice;
        ?? r14;
        int i14;
        String str6 = "CoreService2";
        C11839m.m70688i("CoreService2", "encrypt file [" + str2 + "] download start");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f62320c);
        String str7 = "&";
        sb2.append("&");
        sb2.append(str);
        sb2.append("&");
        sb2.append(str2);
        String string = sb2.toString();
        C13576a c13576aM81565a = C13576a.m81565a();
        if (!c13576aM81565a.m81566b(string)) {
            C11839m.m70687e("CoreService2", "encrypt file [" + str2 + "] download local path repeat.");
            throw new C9721b(4002, "encrypt file [" + str2 + "] download local path repeat.", "download");
        }
        try {
            jCurrentTimeMillis = System.currentTimeMillis();
            c12122a = new C12122a(iCallback);
            properties = m83503q(new String[]{str}, c11060c).get(0);
            objects = properties.getObjects();
            m83495T(c12122a);
            List<ObjectAttribute> attributes = objects.getAttributes();
            C9720a.m60654c(attributes, "attributes is empty, server = " + str);
            C9720a.m60654c(objects.getObjectKeys(), "objectkeys is empty, server = " + str);
            C9720a.m60654c(objects.getSynckeys(), "synckeys is empty, server = " + str);
            i10 = 0;
            i12 = 0;
            length = attributes.get(0).getLength();
            try {
                c12122a.mo17785g(m83498W(length, objects.getSliceSize()));
                m83495T(c12122a);
                i11 = 1;
                sliceEnumerationM83460Q = m83460Q(objects, true);
            } catch (Throwable th2) {
                th = th2;
                str3 = string;
                r32 = c13576aM81565a;
                r32.m81568d(str3);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            str3 = string;
            r32 = c13576aM81565a;
        }
        try {
            if (!sliceEnumerationM83460Q.hasMoreSlices()) {
                throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "amount of files does not match with dbank_s3_file", "download");
            }
            Slice<String> sliceNextSlice = sliceEnumerationM83460Q.nextSlice(length);
            String bucket = objects.getBucket();
            c11060c.m66667w(bucket);
            c11060c.m66638D(bucket + "&" + str2);
            int size = sliceNextSlice.getSliceItems().size();
            List<C13388d> listM83499X = m83499X(str, str2, objects, size);
            CountDownLatch countDownLatch2 = new CountDownLatch(size);
            String arrayList = new ArrayList();
            while (i12 < size) {
                SliceItem<String> sliceItem = sliceNextSlice.getSliceItems().get(i12);
                C13388d c13388d = listM83499X.get(i12);
                String str8 = arrayList;
                try {
                    if (c13388d.m80467u() == i11) {
                        if (C10278a.m63441g(this.f62323f, c13388d.m80457e()).exists()) {
                            c12122a.m72687h(sliceItem.getLength());
                            countDownLatch2.countDown();
                            C11839m.m70686d(str6, "slice object [" + c13388d.m80461k() + "] already download.");
                            i13 = i12;
                            countDownLatch = countDownLatch2;
                            str4 = str6;
                            slice = sliceNextSlice;
                            j10 = jCurrentTimeMillis;
                            r14 = str8;
                            list = listM83499X;
                            i14 = size;
                            c12122a2 = c12122a;
                            listM83499X = list;
                            countDownLatch2 = countDownLatch;
                            c12122a = c12122a2;
                            arrayList = r14;
                            size = i14;
                            sliceNextSlice = slice;
                            jCurrentTimeMillis = j10;
                            str6 = str4;
                            i11 = 1;
                            i12 = i13 + 1;
                        } else {
                            C11839m.m70686d(str6, "slice object [" + c13388d.m80461k() + "] download cache has been deleted.");
                            c13388d.m80471y();
                        }
                    }
                    r14.add(aVar);
                    C13733b.m82520a().m82523d(this.f62320c, aVar);
                    listM83499X = list;
                    countDownLatch2 = countDownLatch;
                    c12122a = c12122a2;
                    arrayList = r14;
                    size = i14;
                    sliceNextSlice = slice;
                    jCurrentTimeMillis = j10;
                    str6 = str4;
                    i11 = 1;
                    i12 = i13 + 1;
                } catch (InterruptedException unused) {
                    Iterator it = r14.iterator();
                    while (it.hasNext()) {
                        ((AbstractC13734c) it.next()).m82517c(true);
                    }
                    i10 = 1001;
                    m83486J(new C9721b(1001, "thread has been interrupted"));
                    str7 = "thread has been interrupted";
                }
                m83495T(c12122a);
                i13 = i12;
                slice = sliceNextSlice;
                r14 = str8;
                j10 = jCurrentTimeMillis;
                countDownLatch = countDownLatch2;
                list = listM83499X;
                i14 = size;
                str4 = str6;
                c12122a2 = c12122a;
                aVar = new a(countDownLatch2, str, c13388d, c12122a, m83508v(sliceItem, c13388d.m80457e(), m83507u(null, c11060c.m66659o())));
            }
            countDownLatch = countDownLatch2;
            list = listM83499X;
            str4 = str6;
            j10 = jCurrentTimeMillis;
            c12122a2 = c12122a;
            str7 = arrayList;
            i10 = i12;
            try {
                m83500Y(countDownLatch, c12122a2);
                String str9 = str4;
                C11839m.m70688i(str9, "encrypt file [" + str2 + "] all slices download success, begin to decrpyt slices.");
                m83477A(list, properties.getEFekFromProperties(), properties.getEIv(), properties.getEType(), c12122a2);
                m83496U(str, str2, list);
                m83495T(c12122a2);
                c11060c.m66665u(EnumC12999a.CLOUD_ALBUM.equals(this.f62320c) ? "0:1" : "117_200");
                c11060c.m66635A(C10278a.m63442h(str2).getName() + ", success");
                c11060c.m66640F(String.valueOf(c12122a2.m72685b()));
                c11060c.m66642H(String.valueOf(System.currentTimeMillis() - j10));
                C11839m.m70688i(str9, "encrypt file [" + str2 + "] download end.");
                c13576aM81565a.m81568d(string);
            } catch (C9721b e10) {
                C11839m.m70687e(str4, e10.toString());
                if (EnumC12999a.CLOUD_ALBUM.equals(this.f62320c)) {
                    str5 = "117_" + e10.m60662f() + ":1";
                } else {
                    str5 = "117_" + e10.m60659c();
                }
                c11060c.m66665u(str5);
                String strM60658b = e10.m60658b();
                if (EnumC12999a.CLOUD_ALBUM.equals(this.f62320c) && "getDownloadAddress".equals(strM60658b)) {
                    c11060c.m66664t(strM60658b);
                }
                c11060c.m66635A(C10278a.m63442h(str2).getName() + ", " + e10.getMessage());
                c11060c.m66640F(String.valueOf(c12122a2.m72685b()));
                throw e10;
            }
        } catch (Throwable th4) {
            th = th4;
            str3 = str7;
            r32 = i10;
            r32.m81568d(str3);
            throw th;
        }
    }

    /* renamed from: E */
    public final void m83481E(C11060c c11060c, long j10, String str, C12122a c12122a, String str2) throws Throwable {
        try {
            m83484H(new URL(str2).toString(), str, c12122a, c11060c);
        } catch (MalformedURLException e10) {
            C11839m.m70689w("CoreService2", "download: url is error = " + e10.toString());
            long jCurrentTimeMillis = System.currentTimeMillis();
            String[] strArrSplit = str2.replace("[", "").replace("]", "").split(",");
            C9720a.m60656e(strArrSplit, "server paths invalid.");
            m83482F(strArrSplit, str, j10, c12122a);
            c11060c.m66667w(strArrSplit[0]);
            c11060c.m66638D(str);
            c11060c.m66665u(EnumC12999a.CLOUD_ALBUM.equals(this.f62320c) ? "0:1" : "117_200");
            c11060c.m66635A(C10278a.m63442h(str).getName() + ", success");
            c11060c.m66640F(String.valueOf(c12122a.m72685b()));
            c11060c.m66642H(String.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
        }
    }

    /* renamed from: F */
    public final void m83482F(String[] strArr, String str, long j10, C12122a c12122a) throws Throwable {
        d dVar;
        C11839m.m70688i("CoreService2", "download app slice start.");
        int length = strArr.length;
        int i10 = 1;
        String str2 = strArr[0].split("/")[1];
        CountDownLatch countDownLatch = new CountDownLatch(length);
        List<C13388d> listM83504r = m83504r(strArr, str2, str, j10);
        ArrayList arrayList = new ArrayList();
        for (C13388d c13388d : listM83504r) {
            try {
                if (c13388d.m80467u() == i10) {
                    if (C10278a.m63441g(this.f62323f, c13388d.m80457e()).exists()) {
                        c12122a.m72687h(c13388d.m80466t());
                        countDownLatch.countDown();
                        C11839m.m70686d("CoreService2", "app slice object [" + c13388d.m80461k() + "] already download.");
                    } else {
                        C11839m.m70686d("CoreService2", "app slice object [" + c13388d.m80461k() + "] download cache has been deleted.");
                        c13388d.m80471y();
                    }
                }
                C13733b.m82520a().m82523d(this.f62320c, dVar);
                arrayList.add(dVar);
                i10 = 1;
            } catch (InterruptedException e10) {
                C11839m.m70687e("CoreService2", "submitTaskWithFlowControl error" + e10.toString());
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((AbstractC13734c) it.next()).m82517c(true);
                }
                m83486J(new C9721b(1001, "thread has been interrupted"));
            }
            m83495T(c12122a);
            dVar = new d(countDownLatch, c13388d, c12122a, m83505s(c13388d));
        }
        try {
            m83500Y(countDownLatch, c12122a);
            c12122a.mo17784f(j10);
            c12122a.mo17783e(true);
            try {
                File fileM63442h = C10278a.m63442h(str);
                for (C13388d c13388d2 : listM83504r) {
                    File fileM63441g = C10278a.m63441g(this.f62323f, c13388d2.m80457e());
                    if (!fileM63441g.exists()) {
                        throw new C9721b(4001, "download slice file is not exits." + c13388d2.m80457e(), "download");
                    }
                    if (!C11835i.m70655s(fileM63441g, fileM63442h, c13388d2.m80462p())) {
                        throw new C9721b(4001, "renameFile error file = " + c13388d2.m80457e());
                    }
                }
                m83496U(str2, str, listM83504r);
                C11839m.m70688i("CoreService2", "download app slice end.");
            } catch (Throwable th2) {
                m83496U(str2, str, listM83504r);
                throw th2;
            }
        } catch (C9721b e11) {
            C11839m.m70687e("CoreService2", e11.toString());
            throw e11;
        }
    }

    /* renamed from: G */
    public void m83483G(String str, ICallback iCallback, DownloadAddress downloadAddress, Map<String, String> map) throws C9721b {
        C11839m.m70688i("CoreService2", "download thumbnail [" + str + "] start.");
        C9720a.m60653b(str, "localPath is null.");
        C9720a.m60657f(downloadAddress, "download request invalid.");
        C9720a.m60654c(downloadAddress.getAddresses(), "localPath is null.");
        File fileM63442h = C10278a.m63442h(str);
        if (fileM63442h.exists()) {
            C11839m.m70689w("CoreService2", m83487K("dest file clear first = " + fileM63442h.delete(), new Object[0]));
        }
        C12122a c12122a = new C12122a(iCallback);
        c12122a.mo17785g(downloadAddress.getaLength());
        m83495T(c12122a);
        List<Address> addresses = downloadAddress.getAddresses();
        LinkedList<SliceItem<String>> sliceItems = downloadAddress.getSliceItems();
        CountDownLatch countDownLatch = new CountDownLatch(addresses.size());
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator<Address> it = addresses.iterator();
        long length = 0;
        while (it.hasNext()) {
            Address next = it.next();
            m83495T(c12122a);
            SliceItem<String> sliceItemPoll = sliceItems.poll();
            C13388d c13388d = new C13388d(this.f62320c.m78143b());
            c13388d.m80448G(str);
            c13388d.m80445D(sliceItemPoll.getObject());
            c13388d.m80446E(length);
            c13388d.m80442A(UUID.randomUUID().toString());
            arrayList.add(c13388d);
            long j10 = length;
            ArrayList arrayList3 = arrayList2;
            Iterator<Address> it2 = it;
            b bVar = new b(countDownLatch, c13388d, c12122a, m83509w(sliceItemPoll, c13388d.m80457e(), next.getHeaders(), next.getUrl(), m83507u(null, map)));
            try {
                C13733b.m82520a().m82523d(this.f62320c, bVar);
                arrayList3.add(bVar);
                length = j10 + sliceItemPoll.getLength();
                it = it2;
                arrayList2 = arrayList3;
            } catch (InterruptedException e10) {
                C11839m.m70687e("CoreService2", "submitTaskWithFlowControl error" + e10.toString());
                Iterator it3 = arrayList3.iterator();
                while (it3.hasNext()) {
                    ((AbstractC13734c) it3.next()).m82517c(true);
                }
                m83486J(new C9721b(1001, "thread has been interrupted"));
            }
        }
        try {
            m83500Y(countDownLatch, c12122a);
            C11839m.m70688i("CoreService2", "download thumbnail [" + str + "] all slices download success, begin to decrpyt slices.");
            m83477A(arrayList, downloadAddress.getFek(), downloadAddress.getIv(), downloadAddress.getType(), c12122a);
            C11839m.m70688i("CoreService2", "download thumbnail [" + str + "] end.");
        } catch (C9721b e11) {
            C11839m.m70687e("CoreService2", e11.toString());
            throw e11;
        }
    }

    /* renamed from: H */
    public final void m83484H(String str, String str2, C12122a c12122a, C11060c c11060c) throws InterruptedException, C9721b {
        C11839m.m70688i("CoreService2", "download file with url start.");
        long jCurrentTimeMillis = System.currentTimeMillis();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        String str3 = this.f62323f + "/" + UUID.randomUUID().toString();
        c cVar = new c(countDownLatch, str, c12122a, C13735d.m82532u().filePath(str3));
        try {
            C13733b.m82520a().m82523d(this.f62320c, cVar);
        } catch (InterruptedException e10) {
            C11839m.m70687e("CoreService2", "submitTaskWithFlowControl error" + e10.toString());
            cVar.m82517c(true);
            m83486J(new C9721b(1001, "thread has been interrupted"));
        }
        try {
            m83500Y(countDownLatch, c12122a);
            File fileM63442h = C10278a.m63442h(str2);
            if (!C11835i.m70654r(C10278a.m63442h(str3), fileM63442h)) {
                throw new C9721b(4001, "renameFile error file = " + str3);
            }
            c11060c.m66667w(str);
            c11060c.m66638D(str2);
            c11060c.m66665u(EnumC12999a.CLOUD_ALBUM.equals(this.f62320c) ? "0:1" : "117_200");
            c11060c.m66635A(fileM63442h.getName() + ", success");
            c11060c.m66640F(String.valueOf(c12122a.m72685b()));
            c11060c.m66642H(String.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
            C11839m.m70688i("CoreService2", "download file with url end.");
        } catch (C9721b e11) {
            C11839m.m70687e("CoreService2", e11.toString());
            throw e11;
        }
    }

    /* renamed from: I */
    public final Slice<File> m83485I(Slice<File> slice, C13387c c13387c) throws Throwable {
        C11839m.m70686d("CoreService2", "encrypt file slice start.");
        ArrayList arrayList = new ArrayList();
        long length = 0;
        for (SliceItem<File> sliceItem : slice.getSliceItems()) {
            File object = sliceItem.getObject();
            String str = this.f62323f + "/" + UUID.randomUUID().toString();
            SliceEncryptReq sliceEncryptReq = new SliceEncryptReq();
            sliceEncryptReq.setTraceID(this.f62319b);
            sliceEncryptReq.setType(c13387c.m80431p());
            sliceEncryptReq.setEfek(c13387c.m80420e());
            sliceEncryptReq.setIv(c13387c.m80425j());
            sliceEncryptReq.setStart(sliceItem.getOffset());
            sliceEncryptReq.setLength(sliceItem.getLength());
            sliceEncryptReq.setDesFile(str);
            sliceEncryptReq.setSrcFile(C10279b.m63452a(object));
            C10466a.m64320k(sliceEncryptReq);
            File fileM63442h = C10278a.m63442h(str);
            SliceItem sliceItem2 = new SliceItem(fileM63442h, sliceItem.getIndex(), 0L, fileM63442h.length());
            length += sliceItem2.getLength();
            arrayList.add(sliceItem2);
        }
        C9720a.m60652a(slice.getLength() == length, "encrypt length invalid.");
        C11839m.m70686d("CoreService2", "encrypt file slice end.");
        return new Slice<>(arrayList, length);
    }

    /* renamed from: J */
    public final void m83486J(C9721b c9721b) {
        synchronized (f62317h) {
            try {
                if (this.f62321d == null) {
                    this.f62321d = c9721b;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: K */
    public final String m83487K(String str, Object... objArr) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        if (objArr != null) {
            int length = objArr.length;
            for (int i10 = 0; i10 < length; i10++) {
                Object obj = objArr[i10];
                sb2.append(" ");
                sb2.append(obj == null ? "" : obj.toString());
            }
        }
        return sb2.toString();
    }

    /* renamed from: L */
    public final <T> T m83488L(String str, Class<T> cls) throws C9721b {
        try {
            return (T) f62316g.fromJson(str, (Class) cls);
        } catch (JsonSyntaxException unused) {
            throw new C9721b(4207, "json err " + str, "CSService_fromJson");
        }
    }

    /* renamed from: M */
    public Context m83489M() {
        return C0213f.m1377a();
    }

    /* renamed from: N */
    public Map<String, Map<String, DownloadAddress>> m83490N(Map<String, String[]> map) throws C9721b {
        C9720a.m60657f(map, "download request invalid.");
        Set<String> setKeySet = map.keySet();
        C9720a.m60654c(setKeySet, "accesstoken is invalid.");
        List<Properties> listM83503q = m83503q((String[]) setKeySet.toArray(new String[map.size()]), null);
        ArrayList arrayList = new ArrayList();
        ArrayList<AddressParams> arrayList2 = new ArrayList();
        for (Properties properties : listM83503q) {
            String[] strArr = map.get(properties.getName());
            C9720a.m60656e(strArr, "request name is invalid.");
            List<AddressParams> listM83492P = m83492P(properties.getName(), properties.getObjects(), strArr);
            arrayList2.addAll(listM83492P);
            for (AddressParams addressParams : listM83492P) {
                addressParams.setFek(properties.getEFekFromProperties());
                addressParams.setIv(properties.getEIv());
                addressParams.setType(properties.getEType());
                arrayList.addAll(addressParams.getParams());
            }
        }
        List<Address> listM78748m = new C13049a(this.f62320c, this.f62319b).m78748m(arrayList);
        HashMap map2 = new HashMap();
        int i10 = 0;
        for (AddressParams addressParams2 : arrayList2) {
            int count = addressParams2.getCount();
            DownloadAddress downloadAddress = new DownloadAddress();
            downloadAddress.setType(addressParams2.getType());
            downloadAddress.setFek(addressParams2.getFek());
            downloadAddress.setIv(addressParams2.getIv());
            downloadAddress.setaLength(addressParams2.getLength());
            LinkedList<SliceItem<String>> sliceItems = addressParams2.getSliceItems();
            int i11 = 0;
            while (true) {
                if (i11 >= count) {
                    break;
                }
                int i12 = i10 + 1;
                Address address = listM78748m.get(i10);
                String state = address.getState();
                downloadAddress.addSlices(sliceItems.poll());
                if (!"0".equals(state)) {
                    StringBuffer stringBuffer = new StringBuffer(addressParams2.getServer());
                    stringBuffer.append(" ");
                    stringBuffer.append(addressParams2.getName());
                    stringBuffer.append(" ");
                    stringBuffer.append("error state = ");
                    stringBuffer.append(state);
                    C11839m.m70687e("CoreService2", m83487K("getDownloadAddress", stringBuffer));
                    i10 = i12 + ((count - 1) - i11);
                    break;
                }
                downloadAddress.addAddresses(address);
                i11++;
                i10 = i12;
            }
            if (downloadAddress.getAddresses().size() == count) {
                Map map3 = (Map) map2.get(addressParams2.getServer());
                if (map3 == null) {
                    map3 = new HashMap();
                }
                map3.put(addressParams2.getName(), downloadAddress);
                map2.put(addressParams2.getServer(), map3);
            }
        }
        if (map2.isEmpty()) {
            throw new C9721b(4201, "get download address null.", "getDownloadAddress");
        }
        return map2;
    }

    /* renamed from: O */
    public final long m83491O(long j10) {
        if (j10 <= 0) {
            return 0L;
        }
        return ((j10 / 16) * 16) + 16;
    }

    /* renamed from: P */
    public final List<AddressParams> m83492P(String str, Objects objects, String[] strArr) throws C9721b {
        SliceEnumeration<String> sliceEnumeration;
        SliceEnumeration<String> sliceEnumerationM83460Q = m83460Q(objects, false);
        ArrayList arrayList = new ArrayList();
        List<String> objectKeys = objects.getObjectKeys();
        List<String> synckeys = objects.getSynckeys();
        List<ObjectAttribute> attributes = objects.getAttributes();
        int i10 = 1;
        while (i10 < attributes.size()) {
            ObjectAttribute objectAttribute = attributes.get(i10);
            if (sliceEnumerationM83460Q.hasMoreSlices()) {
                Slice<String> sliceNextSlice = sliceEnumerationM83460Q.nextSlice(objectAttribute.getLength());
                AddressParams addressParams = new AddressParams();
                addressParams.setServer(str);
                addressParams.setCount(sliceNextSlice.getSliceItems().size());
                for (SliceItem<String> sliceItem : sliceNextSlice.getSliceItems()) {
                    if (!m83476z(strArr, objectAttribute.getName())) {
                        break;
                    }
                    addressParams.setName(objectAttribute.getName());
                    addressParams.increase(sliceItem.getLength());
                    String object = sliceItem.getObject();
                    String str2 = synckeys.get(objectKeys.indexOf(object));
                    HashMap map = new HashMap();
                    SliceEnumeration<String> sliceEnumeration2 = sliceEnumerationM83460Q;
                    map.put("bucket", objects.getBucket());
                    map.put("timestamp", objects.getTime());
                    map.put("objectId", object);
                    map.put("synckey", str2);
                    HashMap map2 = new HashMap();
                    map2.put("x-nsp-scheme", "https");
                    map.put("headers", map2);
                    addressParams.addParams(map);
                    sliceItem.setObject(object + "-" + addressParams.getName());
                    addressParams.addSlices(sliceItem);
                    sliceEnumerationM83460Q = sliceEnumeration2;
                }
                sliceEnumeration = sliceEnumerationM83460Q;
                if (!addressParams.getParams().isEmpty()) {
                    arrayList.add(addressParams);
                }
            } else {
                sliceEnumeration = sliceEnumerationM83460Q;
            }
            i10++;
            sliceEnumerationM83460Q = sliceEnumeration;
        }
        return arrayList;
    }

    /* renamed from: R */
    public final Address m83493R(Slice<File> slice, C13386b c13386b, C11060c c11060c) throws Throwable {
        Md5AndHash md5AndHashM68625g = C11476b.m68625g(slice.getSliceItems());
        HashMap map = new HashMap();
        map.put("objectId", c13386b.m80397q());
        map.put("objectSize", String.valueOf(slice.getLength()));
        map.put("contentHash", f62316g.toJson(md5AndHashM68625g));
        map.put("synckey", c13386b.m80400t());
        map.put("timestamp", c13386b.m80401u());
        map.put("bucket", c13386b.m80390b());
        Address addressM78706E = new C13049a(this.f62320c, this.f62319b).m78706E(map, c11060c);
        c13386b.m80402v(addressM78706E.getBucket());
        return addressM78706E;
    }

    /* renamed from: S */
    public String m83494S(File file, C13387c c13387c, C12122a c12122a) throws C9721b {
        CBSAppBaseReq cBSAppBaseReq = new CBSAppBaseReq(c13387c.m80419d(), c13387c.m80421f(), c13387c.m80422g(), c13387c.m80427l());
        if (!new C11322a(this.f62319b).m68023g(cBSAppBaseReq)) {
            SliceItem<File> sliceItem = new SliceItem<>(file, 0, 0L, cBSAppBaseReq.getSize());
            CountDownLatch countDownLatch = new CountDownLatch(1);
            ArrayList arrayList = new ArrayList();
            j jVar = new j(cBSAppBaseReq, countDownLatch);
            C13735d.m82531s().m82543m(this.f62320c, m83506t(sliceItem), arrayList, jVar);
            try {
                m83500Y(countDownLatch, c12122a);
            } catch (C9721b e10) {
                C13735d.m82531s().m82538h(this.f62320c, arrayList);
                C11839m.m70687e("CoreService2", e10.toString());
                throw e10;
            }
        }
        return c13387c.m80419d();
    }

    /* renamed from: T */
    public final void m83495T(C12122a c12122a) throws C9721b {
        if (c12122a.mo17782d()) {
            throw new C9721b(1002, "net disable or canceled by user");
        }
        C9721b c9721b = this.f62321d;
        if (c9721b != null) {
            throw c9721b;
        }
    }

    /* renamed from: U */
    public final void m83496U(String str, String str2, List<C13388d> list) throws C9721b, SQLException {
        C11839m.m70686d("CoreService2", "release begin.");
        Iterator<C13388d> it = list.iterator();
        while (it.hasNext()) {
            File fileM63441g = C10278a.m63441g(this.f62323f, it.next().m80457e());
            if (fileM63441g.exists()) {
                C11839m.m70686d("CoreService2", "finally cache file exits, delete = " + fileM63441g.delete());
            }
        }
        new C13139d().m79029h(this.f62320c.m78143b(), str, str2);
    }

    /* renamed from: V */
    public final void m83497V(JsonObject jsonObject, C13387c c13387c, long j10) throws Throwable {
        List<Map> list;
        C13140e c13140e = new C13140e();
        if (j10 != c13387c.m80433r()) {
            c13140e.m79035h(this.f62320c.m78143b(), c13387c.m80421f());
        }
        List<C13386b> listM79037j = c13140e.m79037j(this.f62320c.m78143b(), c13387c.m80421f());
        Collections.sort(listM79037j);
        try {
            list = (List) f62316g.fromJson(jsonObject.get("items"), new h().getType());
        } catch (JsonSyntaxException e10) {
            C11839m.m70687e("CoreService2", "resetSlices json exception: " + e10.getMessage());
            list = null;
        }
        if (list == null) {
            throw new C9721b(4207, "resetSlices items is null, " + jsonObject.toString());
        }
        int i10 = 0;
        for (Map map : list) {
            C13386b c13386b = new C13386b(this.f62320c.m78143b());
            c13386b.m80383A(c13387c.m80421f());
            c13386b.m80385C(i10);
            c13386b.m80384B((String) map.get("objectName"));
            c13386b.m80387E((String) map.get("synckey"));
            c13386b.m80388F((String) map.get("time"));
            if (listM79037j.isEmpty()) {
                c13386b.m80386D(0);
                c13386b.m80403w(System.currentTimeMillis());
            } else {
                C13386b c13386b2 = listM79037j.get(i10);
                if (c13386b.m80397q().equals(c13386b2.m80397q())) {
                    c13386b.m80402v(c13386b2.m80390b());
                    c13386b.m80386D(c13386b2.m80399s());
                    c13386b.m80403w(c13386b2.m80391e());
                } else {
                    c13386b.m80386D(0);
                    c13386b.m80403w(System.currentTimeMillis());
                }
            }
            i10++;
            c13140e.m79038k(c13386b);
        }
    }

    /* renamed from: W */
    public final long m83498W(long j10, long j11) {
        return ((j10 / j11) * m83491O(j11)) + m83491O(j10 % j11);
    }

    /* renamed from: X */
    public final List<C13388d> m83499X(String str, String str2, Objects objects, int i10) throws Throwable {
        C13139d c13139d = new C13139d();
        List<C13388d> listM79031j = c13139d.m79031j(this.f62320c.m78143b(), str, str2);
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < i10; i11++) {
            C13388d c13388d = new C13388d(this.f62320c.m78143b());
            c13388d.m80447F(i11);
            c13388d.m80446E(i11 * objects.getSliceSize());
            c13388d.m80449H(str);
            c13388d.m80448G(str2);
            c13388d.m80445D(objects.getObjectKeys().get(i11));
            c13388d.m80452K(objects.getSynckeys().get(i11));
            c13388d.m80472z(objects.getBucket());
            c13388d.m80454M(objects.getTime());
            c13388d.m80450I(objects.getSliceSize());
            c13388d.m80442A(UUID.randomUUID().toString());
            Iterator<C13388d> it = listM79031j.iterator();
            while (it.hasNext() && !c13388d.equals(it.next())) {
            }
            arrayList.add(c13388d);
        }
        c13139d.m79027f(arrayList);
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0010, code lost:
    
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:3:0x000b, code lost:
    
        if (r8.f62321d != null) goto L4;
     */
    /* JADX WARN: Removed duplicated region for block: B:28:0x000d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:5:0x000f A[LOOP:0: B:6:0x0010->B:5:0x000f, LOOP_END] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0043 -> B:4:0x000d). Please report as a decompilation issue!!! */
    /* renamed from: Y */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m83500Y(java.util.concurrent.CountDownLatch r9, p549p9.C12122a r10) throws java.lang.InterruptedException, fk.C9721b {
        /*
            r8 = this;
            r8.m83495T(r10)
            boolean r0 = r10.mo17782d()
            fk.b r1 = r8.f62321d
            r2 = 0
            r3 = 1
            if (r1 == 0) goto Lf
        Ld:
            r1 = r3
            goto L10
        Lf:
            r1 = r2
        L10:
            long r4 = r9.getCount()
            r6 = 0
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 <= 0) goto L46
            if (r0 != 0) goto L46
            if (r1 != 0) goto L46
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch: java.lang.InterruptedException -> L26
            r4 = 400(0x190, double:1.976E-321)
            r9.await(r4, r0)     // Catch: java.lang.InterruptedException -> L26
            goto L3d
        L26:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r4 = "lock wait error."
            r1.append(r4)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            java.lang.String r1 = "CoreService2"
            p514o9.C11839m.m70689w(r1, r0)
        L3d:
            boolean r0 = r10.mo17782d()
            fk.b r1 = r8.f62321d
            if (r1 == 0) goto Lf
            goto Ld
        L46:
            fk.b r9 = r8.f62321d
            if (r9 != 0) goto L4e
            r8.m83495T(r10)
            return
        L4e:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: p803y9.C13922a.m83500Y(java.util.concurrent.CountDownLatch, p9.a):void");
    }

    /* renamed from: Z */
    public void m83501Z(File file, Thumbnail[] thumbnailArr, C12122a c12122a, C13387c c13387c, C11060c c11060c) throws Throwable {
        String str;
        String str2;
        String str3;
        long j10;
        String str4 = " preMkFile";
        String str5 = "json err ";
        String name = file.getName();
        String str6 = "CoreService2";
        C11839m.m70688i("CoreService2", "file encrypt upload start, fileName: " + name);
        C13141f c13141f = new C13141f();
        c13141f.m79044k(c13387c);
        ArrayList arrayList = new ArrayList();
        arrayList.add(file);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new ObjectAttribute(null, file.length()));
        ArrayList arrayList3 = new ArrayList();
        if (thumbnailArr != null) {
            int length = thumbnailArr.length;
            long length2 = 0;
            int i10 = 0;
            while (i10 < length) {
                Thumbnail thumbnail = thumbnailArr[i10];
                int i11 = length;
                C9720a.m60657f(thumbnail, "thumbnail is invalid.");
                String str7 = str4;
                C9720a.m60653b(thumbnail.getName(), "thumbnail name is null.");
                File file2 = thumbnail.getFile();
                C9720a.m60657f(file2, "thumbnail file is null");
                C9720a.m60652a(file2.exists(), "file is not exits." + C10279b.m63452a(file2));
                arrayList2.add(new ObjectAttribute(thumbnail.getName(), file2.length()));
                length2 += file2.length();
                arrayList3.add(Long.valueOf(file2.length()));
                arrayList.add(file2);
                i10++;
                length = i11;
                str4 = str7;
                str5 = str5;
                str6 = str6;
            }
            str = str4;
            str2 = str5;
            str3 = str6;
            if (thumbnailArr.length > 0) {
                C9720a.m60652a(length2 > 0, "attach size is 0.");
            }
            j10 = length2;
        } else {
            str = " preMkFile";
            str2 = "json err ";
            str3 = "CoreService2";
            j10 = 0;
        }
        c13387c.m80435t(f62316g.toJson(arrayList2));
        m83495T(c12122a);
        UniqueReq uniqueReq = new UniqueReq(file, c13387c.m80431p(), j10);
        uniqueReq.setTraceID(this.f62319b);
        Unique uniqueM64327r = C10466a.m64327r(uniqueReq);
        c13387c.m80441z(uniqueM64327r.getHmac());
        c13387c.m80438w(uniqueM64327r.getEfek());
        c13387c.m80407A(uniqueM64327r.getIv());
        c13387c.m80437v(uniqueM64327r.getKeyGuid());
        m83495T(c12122a);
        String strM78728b0 = new C13049a(this.f62320c, this.f62319b).m78728b0(c13387c.m80423h(), c13387c.m80427l(), arrayList3, c11060c);
        try {
            JsonElement jsonElement = new JsonParser().parse(strM78728b0);
            JsonObject asJsonObject = jsonElement != null ? jsonElement.getAsJsonObject() : null;
            ICallback iCallbackMo17781a = c12122a.mo17781a();
            if (iCallbackMo17781a instanceof IPreCallback) {
                ((IPreCallback) iCallbackMo17781a).m16231a();
            }
            m83495T(c12122a);
            if (asJsonObject == null || !asJsonObject.has("needUpload")) {
                throw new C9721b(4000, str2 + strM78728b0, str);
            }
            boolean asBoolean = asJsonObject.get("needUpload").getAsBoolean();
            long asLong = asJsonObject.get("version").getAsLong();
            long asLong2 = asJsonObject.get("sliceSize").getAsLong();
            if (asBoolean) {
                m83497V(asJsonObject, c13387c, asLong);
                c13387c.m80415I(asLong);
                c13387c.m80411E(asLong2);
                c13387c.m80412F(1);
                c13141f.m79044k(c13387c);
                m83478B(arrayList, c13387c, c12122a, c11060c);
            } else {
                c13387c.m80415I(asLong);
                c13387c.m80411E(asLong2);
                c13387c.m80412F(2);
                c13141f.m79044k(c13387c);
                new C13140e().m79035h(this.f62320c.m78143b(), c13387c.m80421f());
            }
            C11839m.m70688i(str3, "file encrypt upload end, fileName: " + name);
        } catch (Exception unused) {
            throw new C9721b(4000, str2 + strM78728b0, str);
        }
    }

    /* renamed from: p */
    public String m83502p(File file, C13387c c13387c, C12122a c12122a) throws C9721b {
        CountDownLatch countDownLatch;
        boolean z10;
        ArrayList arrayList;
        C11839m.m70688i("CoreService2", "slice app upload start.");
        long length = file.length();
        c12122a.mo17785g(length);
        List<AppSlice> listM83511y = m83511y(file, "/" + c13387c.m80417b() + "/" + c13387c.m80418c() + "/" + c13387c.m80417b() + ".apk");
        CBSAppBaseReq cBSAppBaseReq = new CBSAppBaseReq(c13387c.m80419d(), c13387c.m80421f(), c13387c.m80422g(), length);
        C11322a c11322a = new C11322a(this.f62319b);
        boolean zM68023g = c11322a.m68023g(cBSAppBaseReq);
        m83495T(c12122a);
        ArrayList arrayList2 = new ArrayList();
        if (zM68023g) {
            if (listM83511y.isEmpty()) {
                arrayList2.add(c13387c.m80419d());
            } else {
                Iterator<AppSlice> it = listM83511y.iterator();
                while (it.hasNext()) {
                    arrayList2.add(it.next().getRangePath());
                }
            }
            return arrayList2.toString();
        }
        ArrayList arrayList3 = new ArrayList();
        if (listM83511y.isEmpty()) {
            arrayList2.add(c13387c.m80419d());
            countDownLatch = new CountDownLatch(1);
            SliceItem<File> sliceItem = new SliceItem<>(file, 0, 0L, cBSAppBaseReq.getSize());
            C13735d.m82531s().m82543m(this.f62320c, m83506t(sliceItem), arrayList3, new j(cBSAppBaseReq, countDownLatch));
            z10 = false;
        } else {
            countDownLatch = new CountDownLatch(listM83511y.size());
            Iterator<AppSlice> it2 = listM83511y.iterator();
            boolean z11 = false;
            while (it2.hasNext()) {
                AppSlice next = it2.next();
                arrayList2.add(next.getRangePath());
                C11839m.m70688i("CoreService2", "one app slice upload start. ");
                m83495T(c12122a);
                CBSAppBaseReq cBSAppBaseReq2 = new CBSAppBaseReq(next.getRangePath(), next.getRangemd5(), next.getRangesha256(), next.getEnd() - next.getStart());
                if (c11322a.m68023g(cBSAppBaseReq2)) {
                    C11839m.m70686d("CoreService2", "apk file range exits, rangePath = " + next.getRangePath());
                    countDownLatch.countDown();
                } else {
                    cBSAppBaseReq2.setCompletePath(c13387c.m80419d());
                    SliceItem<File> sliceItem2 = new SliceItem<>(file, 0, next.getStart(), cBSAppBaseReq2.getSize());
                    C13735d.m82531s().m82543m(this.f62320c, m83506t(sliceItem2), arrayList3, new j(cBSAppBaseReq2, countDownLatch));
                    it2 = it2;
                    z11 = true;
                }
            }
            z10 = z11;
        }
        try {
            m83500Y(countDownLatch, c12122a);
            if (listM83511y.isEmpty()) {
                arrayList = arrayList2;
            } else {
                arrayList = arrayList2;
                CBSAppMkFileReq cBSAppMkFileReq = new CBSAppMkFileReq(c13387c.m80419d(), c13387c.m80421f(), c13387c.m80422g(), length, "apk");
                cBSAppMkFileReq.setCheckCompletePath(z10);
                c11322a.m68018b(cBSAppMkFileReq);
            }
            m83495T(c12122a);
            C11839m.m70688i("CoreService2", "apk file exits, upload success.");
            return arrayList.toString();
        } catch (C9721b e10) {
            C13735d.m82531s().m82538h(this.f62320c, arrayList3);
            C11839m.m70687e("CoreService2", e10.toString());
            throw e10;
        }
    }

    /* renamed from: q */
    public final List<Properties> m83503q(String[] strArr, C11060c c11060c) throws C9721b {
        try {
            PropResult propResult = (PropResult) m83488L(new C13049a(this.f62320c, this.f62319b).m78725a(strArr, new String[]{"e_type", "e_fek", "e_iv", "dbank_s3_file"}, c11060c), PropResult.class);
            if (propResult == null || propResult.getFailList() == null || propResult.getSuccessList() == null) {
                throw new C9721b(3201, "result is null");
            }
            if (!propResult.getSuccessList().isEmpty() || propResult.getFailList().isEmpty()) {
                return propResult.getSuccessList();
            }
            Result.ErrMsg errMsg = propResult.getFailList().get(0);
            C11839m.m70687e("CoreService2", m83487K("download getattr err. " + errMsg.toString(), new Object[0]));
            throw new C9721b(3207, errMsg.getErrCode(), errMsg.getErrMsg());
        } catch (JsonSyntaxException e10) {
            C11839m.m70687e("CoreService2", "attributes json exception is: " + e10.toString());
            throw new C9721b(4207, "json err ");
        }
    }

    /* renamed from: r */
    public final List<C13388d> m83504r(String[] strArr, String str, String str2, long j10) throws Throwable {
        C13139d c13139d = new C13139d();
        List<C13388d> listM79031j = c13139d.m79031j(this.f62320c.m78143b(), str, str2);
        int length = strArr.length;
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < length; i10++) {
            C13388d c13388d = new C13388d(this.f62320c.m78143b());
            c13388d.m80447F(i10);
            c13388d.m80446E(i10 * 33554432);
            c13388d.m80449H(str);
            c13388d.m80448G(str2);
            c13388d.m80445D(strArr[i10].trim());
            c13388d.m80472z(strArr[i10].trim());
            if (i10 == length - 1) {
                c13388d.m80450I(j10 % 33554432);
            } else {
                c13388d.m80450I(33554432L);
            }
            c13388d.m80445D(UUID.randomUUID().toString());
            c13388d.m80442A(UUID.randomUUID().toString());
            Iterator<C13388d> it = listM79031j.iterator();
            while (it.hasNext() && !c13388d.equals(it.next())) {
            }
            arrayList.add(c13388d);
        }
        c13139d.m79027f(arrayList);
        return arrayList;
    }

    /* renamed from: s */
    public final GetRequest.Builder m83505s(C13388d c13388d) {
        String strM80457e = c13388d.m80457e();
        return C13735d.m82532u().filePath(this.f62323f + "/" + strM80457e).fileSize(c13388d.m80466t()).name(strM80457e).reportInfos(m83507u(null, null));
    }

    /* renamed from: t */
    public final PutRequest m83506t(SliceItem<File> sliceItem) throws C9721b {
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new FileEntity(CloudBackupConstant.Command.PMS_OPTION_ONE_FILE, sliceItem.getObject().getName(), sliceItem.getObject(), sliceItem.getOffset(), sliceItem.getLength()));
            return C13735d.m82533v().fileParams((List<FileEntity>) arrayList).build();
        } catch (IllegalArgumentException unused) {
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "create FileEntity trigger illegalArgumentException");
        }
    }

    /* renamed from: u */
    public final Map<String, String> m83507u(C11060c c11060c, Map<String, String> map) {
        HashMap map2 = new HashMap();
        if (c11060c == null) {
            c11060c = C11058a.m66626a(this.f62319b, "Upload", C13452e.m80781L().m80971t0());
        }
        if (map != null) {
            map2.putAll(map);
        }
        map2.put("pn", c11060c.m66654j());
        map2.put("traceID", c11060c.m66661q());
        map2.put(HwPayConstant.KEY_USER_ID, c11060c.m66662r());
        map2.put("logVersion", c11060c.m66651g());
        map2.put("endTrace", c11060c.m66649e());
        return map2;
    }

    /* renamed from: v */
    public final GetRequest.Builder m83508v(SliceItem<String> sliceItem, String str, Map<String, String> map) {
        return C13735d.m82532u().filePath(this.f62323f + "/" + str).offset(sliceItem.getOffset()).fileSize(sliceItem.getLength()).name(str).reportInfos(map);
    }

    /* renamed from: w */
    public final GetRequest.Builder m83509w(SliceItem<String> sliceItem, String str, Map<String, String> map, String str2, Map<String, String> map2) {
        GetRequest.Builder builderReportInfos = DownloadManager.newGetRequestBuilder().filePath(this.f62323f + "/" + str).offset(sliceItem.getOffset()).fileSize(sliceItem.getLength()).name(str).config(C13735d.m82528e()).reportInfos(map2);
        if (!TextUtils.isEmpty(str2)) {
            builderReportInfos.url(str2);
        }
        if (map != null) {
            builderReportInfos.headers(map);
        }
        return builderReportInfos;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: x */
    public final PutRequest m83510x(Slice<File> slice, String str, Map<String, String> map) throws C9721b {
        ArrayList arrayList = new ArrayList();
        try {
            for (SliceItem<File> sliceItem : slice.getSliceItems()) {
                arrayList.add(new FileEntity(CloudBackupConstant.Command.PMS_OPTION_ONE_FILE, str, sliceItem.getObject(), sliceItem.getOffset(), sliceItem.getLength()));
            }
            return ((PutRequest.Builder) ((PutRequest.Builder) C13735d.m82533v().fileParams((List<FileEntity>) arrayList).reportInfos(map)).config(C13735d.m82528e())).build();
        } catch (IllegalArgumentException unused) {
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "create FileEntity trigger illegalArgumentException");
        }
    }

    /* renamed from: y */
    public final List<AppSlice> m83511y(File file, String str) throws Throwable {
        long length = file.length();
        long j10 = 33554432;
        long j11 = ((length - 1) / 33554432) + 1;
        long j12 = 80;
        if (j11 > j12) {
            j10 = length / j12;
            if (length % j10 != 0) {
                j10++;
            }
            j11 = j12;
        }
        ArrayList arrayList = new ArrayList();
        if (j11 == 1) {
            return arrayList;
        }
        int i10 = 0;
        while (true) {
            long j13 = i10;
            if (j13 >= j11) {
                return arrayList;
            }
            long j14 = j10 * j13;
            int i11 = i10 + 1;
            long j15 = i11 * j10;
            long j16 = j15 < length ? j15 : length;
            Md5AndHash md5AndHashM68623e = C11476b.m68623e(file, j14, (int) (j16 - j14));
            arrayList.add(new AppSlice(str + "_" + md5AndHashM68623e.getMD5() + "_" + md5AndHashM68623e.getHash() + "_" + i10, j14, j16, md5AndHashM68623e.getMD5(), md5AndHashM68623e.getHash()));
            i10 = i11;
            length = length;
        }
    }
}
