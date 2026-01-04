package gl;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.google.gson.Gson;
import com.huawei.android.hicloud.agd.ads.DownloadParam;
import com.huawei.android.hicloud.cloudbackup.process.task.CloudRestoreAgdApiInterface;
import com.huawei.appgallery.agd.api.AgdApi;
import com.huawei.appgallery.agd.api.AgdApiClient;
import com.huawei.appgallery.agd.api.AgdConstant;
import com.huawei.appgallery.agd.api.ConnectionResult;
import com.huawei.appgallery.agd.api.ResultCallback;
import com.huawei.appmarket.framework.coreservice.Status;
import com.huawei.appmarket.service.externalservice.distribution.download.IDownloadCallback;
import com.huawei.appmarket.service.externalservice.distribution.download.request.CancelTaskIPCRequest;
import com.huawei.appmarket.service.externalservice.distribution.download.request.PauseTaskIPCRequest;
import com.huawei.appmarket.service.externalservice.distribution.download.request.QueryTaskIPCRequest;
import com.huawei.appmarket.service.externalservice.distribution.download.request.RegisterDownloadCallbackIPCRequest;
import com.huawei.appmarket.service.externalservice.distribution.download.request.ResumeTaskIPCRequest;
import com.huawei.appmarket.service.externalservice.distribution.download.request.StartDownloadV2IPCRequest;
import com.huawei.appmarket.service.externalservice.distribution.download.request.UnregisterDownloadCallbackIPCRequest;
import com.huawei.appmarket.service.externalservice.distribution.download.response.QueryTaskResponse;
import com.huawei.appmarket.service.externalservice.distribution.download.response.TaskInfo;
import com.huawei.hicloud.cloudbackup.server.model.RestoreApkAgdDownloadState;
import com.huawei.hms.framework.common.StringUtils;
import fk.C9721b;
import gl.C9968i;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;
import p015ak.C0204a0;
import p015ak.C0213f;
import p015ak.C0217h;
import p261el.C9500a;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p616rk.C12515a;
import p780xm.C13834f;
import p780xm.C13836h;
import p780xm.InterfaceC13829a;

/* renamed from: gl.i */
/* loaded from: classes6.dex */
public class C9968i {

    /* renamed from: f */
    public static final Object f48790f = new Object();

    /* renamed from: g */
    public static final C13836h f48791g = new C13836h(1, 1, 200, "ag_connect_executor");

    /* renamed from: h */
    @SuppressLint({"StaticFieldLeak"})
    public static final C9968i f48792h = new C9968i();

    /* renamed from: a */
    public volatile AgdApiClient f48793a;

    /* renamed from: c */
    public volatile HandlerThread f48795c;

    /* renamed from: d */
    public volatile Handler f48796d;

    /* renamed from: b */
    public final Map<String, c> f48794b = new ConcurrentHashMap();

    /* renamed from: e */
    public final int f48797e = C9500a.m59437a("agdConnectTimeout", 10);

    /* renamed from: gl.i$b */
    public static class b implements AgdApiClient.ConnectionCallbacks {
        public b() {
        }

        @Override // com.huawei.appgallery.agd.api.AgdApiClient.ConnectionCallbacks
        public void onConnected() {
            synchronized (C9968i.f48790f) {
                C9968i.f48790f.notifyAll();
            }
            C11839m.m70688i("CloudRestoreAgdApiClient", "onConnected");
        }

        @Override // com.huawei.appgallery.agd.api.AgdApiClient.ConnectionCallbacks
        public void onConnectionFailed(ConnectionResult connectionResult) {
            C11839m.m70688i("CloudRestoreAgdApiClient", "onConnectionFailed:" + connectionResult.getStatusCode());
            synchronized (C9968i.f48790f) {
                C9968i.f48790f.notifyAll();
            }
        }

        @Override // com.huawei.appgallery.agd.api.AgdApiClient.ConnectionCallbacks
        public void onConnectionSuspended(int i10) {
            C11839m.m70688i("CloudRestoreAgdApiClient", "onConnectionSuspended:" + i10);
            synchronized (C9968i.f48790f) {
                C9968i.f48790f.notifyAll();
            }
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    /* renamed from: gl.i$c */
    public static class c extends IDownloadCallback.Stub {

        /* renamed from: a */
        public final String f48798a;

        /* renamed from: b */
        public final CloudRestoreAgdApiInterface.CloudRestoreAgdApiClientCallback f48799b;

        /* renamed from: c */
        public boolean f48800c = true;

        /* renamed from: d */
        public Handler f48801d;

        public c(String str, CloudRestoreAgdApiInterface.CloudRestoreAgdApiClientCallback cloudRestoreAgdApiClientCallback) {
            this.f48798a = str;
            this.f48799b = cloudRestoreAgdApiClientCallback;
        }

        /* renamed from: g */
        public void m61843g() {
            C11839m.m70688i("CloudRestoreAgdApiClient", "cancelCallback: " + this.f48798a);
            this.f48800c = false;
            CloudRestoreAgdApiInterface.CloudRestoreAgdApiClientCallback cloudRestoreAgdApiClientCallback = this.f48799b;
            if (cloudRestoreAgdApiClientCallback != null) {
                cloudRestoreAgdApiClientCallback.downloadFail(3);
            }
        }

        @Override // com.huawei.appmarket.service.externalservice.distribution.download.IDownloadCallback
        public String getDownloadRegisterKey() {
            return "";
        }

        /* renamed from: h */
        public final /* synthetic */ void m61844h(String str, int i10, int i11, int i12) {
            try {
                this.f48799b.progressChanged(new RestoreApkAgdDownloadState(str, i10, i11, i12));
            } catch (Exception e10) {
                C11839m.m70687e("CloudRestoreAgdApiClient", "progressChanged appId: " + str + " Exception:" + e10.getClass().getName());
            }
        }

        /* renamed from: i */
        public void m61845i(Handler handler) {
            this.f48801d = handler;
        }

        @Override // com.huawei.appmarket.service.externalservice.distribution.download.IDownloadCallback
        public void refreshAppStatus(final String str, final int i10, final int i11, final int i12) {
            Handler handler;
            C11839m.m70688i("CloudRestoreAgdApiClient", "packageName:" + str + ",appType:" + i10 + ",status:" + i11 + ",progress:" + i12);
            if (this.f48799b == null || !this.f48800c || (handler = this.f48801d) == null) {
                return;
            }
            handler.post(new Runnable() { // from class: gl.j
                @Override // java.lang.Runnable
                public final void run() {
                    this.f48805a.m61844h(str, i11, i12, i10);
                }
            });
        }
    }

    /* renamed from: gl.i$d */
    public static class d extends AbstractC12367d {

        /* renamed from: a */
        public final CloudRestoreAgdApiInterface.CloudRestoreAgdApiClientCallback f48802a;

        /* renamed from: b */
        public final int f48803b;

        public d(CloudRestoreAgdApiInterface.CloudRestoreAgdApiClientCallback cloudRestoreAgdApiClientCallback, int i10) {
            this.f48802a = cloudRestoreAgdApiClientCallback;
            this.f48803b = i10;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            this.f48802a.startFail(this.f48803b);
        }
    }

    /* renamed from: gl.i$e */
    public static class e implements CloudRestoreAgdApiInterface {

        /* renamed from: a */
        public static String f48804a;

        /* renamed from: A */
        public static e m61846A() {
            return new e();
        }

        /* renamed from: C */
        public static void m61847C(String str) {
            f48804a = str;
        }

        /* renamed from: n */
        public static /* synthetic */ void m61861n(Status status) {
            C11839m.m70688i("CloudRestoreAgdApiClient", "onResult:" + status.getStatusCode());
        }

        /* renamed from: o */
        public static /* synthetic */ void m61862o(String str, C13834f.b bVar) {
            if (!C0204a0.m1125a(bVar)) {
                C11839m.m70687e("CloudRestoreAgdApiClient", "Connect fail");
                return;
            }
            AgdApiClient agdApiClient = (AgdApiClient) bVar.m82984b();
            C11839m.m70688i("CloudRestoreAgdApiClient", "cancelTask:" + str);
            if (agdApiClient == null) {
                C11839m.m70687e("CloudRestoreAgdApiClient", "client is null");
                return;
            }
            C11839m.m70688i("CloudRestoreAgdApiClient", "cancelTask:" + str);
            CancelTaskIPCRequest cancelTaskIPCRequest = new CancelTaskIPCRequest();
            cancelTaskIPCRequest.setPackageName(str);
            AgdApi.cancelTask(agdApiClient, cancelTaskIPCRequest).setResultCallback(new ResultCallback() { // from class: gl.l
                @Override // com.huawei.appgallery.agd.api.ResultCallback
                public final void onResult(Status status) {
                    C9968i.e.m61861n(status);
                }
            });
        }

        /* renamed from: p */
        public static /* synthetic */ void m61863p(Status status) {
            C11839m.m70688i("CloudRestoreAgdApiClient", "onResult:" + status.getStatusCode());
        }

        /* renamed from: q */
        public static /* synthetic */ void m61864q(String str, C13834f.b bVar) {
            if (!C0204a0.m1125a(bVar)) {
                C11839m.m70687e("CloudRestoreAgdApiClient", "Connect fail");
                return;
            }
            AgdApiClient agdApiClient = (AgdApiClient) bVar.m82984b();
            C11839m.m70688i("CloudRestoreAgdApiClient", "pauseTask:" + str);
            if (agdApiClient == null) {
                C11839m.m70687e("CloudRestoreAgdApiClient", "client is null");
                return;
            }
            C11839m.m70688i("CloudRestoreAgdApiClient", "pauseTask:" + str);
            PauseTaskIPCRequest pauseTaskIPCRequest = new PauseTaskIPCRequest();
            pauseTaskIPCRequest.setPackageName(str);
            AgdApi.pauseTask(agdApiClient, pauseTaskIPCRequest).setResultCallback(new ResultCallback() { // from class: gl.v
                @Override // com.huawei.appgallery.agd.api.ResultCallback
                public final void onResult(Status status) {
                    C9968i.e.m61863p(status);
                }
            });
        }

        /* renamed from: r */
        public static /* synthetic */ void m61865r(String str, Consumer consumer, Status status) {
            C11839m.m70688i("CloudRestoreAgdApiClient", "callQueryTask, onResult:" + status.getStatusCode());
            if (status.getResponse() != null && ((QueryTaskResponse) status.getResponse()).getTaskList() != null) {
                HashMap<String, TaskInfo> taskList = ((QueryTaskResponse) status.getResponse()).getTaskList();
                if (taskList.size() > 0) {
                    for (Map.Entry<String, TaskInfo> entry : taskList.entrySet()) {
                        if (entry.getKey().equals(str)) {
                            C11839m.m70688i("CloudRestoreAgdApiClient", "queryDownloadTasks,packageName = " + entry.getKey() + ", statusType = " + entry.getValue().getAppStatusType() + ", status = " + entry.getValue().getStatus() + ", progress = " + entry.getValue().getProgress());
                            consumer.accept(Boolean.valueOf(entry.getValue().getStatus() == 6));
                            return;
                        }
                    }
                }
            }
            C11839m.m70688i("CloudRestoreAgdApiClient", "there are no download or install task:" + str);
            consumer.accept(Boolean.FALSE);
        }

        /* renamed from: s */
        public static /* synthetic */ void m61866s(C0217h c0217h, final String str, final Consumer consumer, C13834f.b bVar) {
            if (!C0204a0.m1125a(bVar)) {
                C11839m.m70687e("CloudRestoreAgdApiClient", "Connect fail");
                c0217h.m1450a(Boolean.FALSE);
                return;
            }
            AgdApiClient agdApiClient = (AgdApiClient) bVar.m82984b();
            C11839m.m70688i("CloudRestoreAgdApiClient", "queryTask:" + str);
            if (agdApiClient == null) {
                C11839m.m70687e("CloudRestoreAgdApiClient", "client is null");
                c0217h.m1450a(Boolean.FALSE);
                return;
            }
            C11839m.m70688i("CloudRestoreAgdApiClient", "queryTask:" + str);
            AgdApi.queryTasks(agdApiClient, new QueryTaskIPCRequest()).setResultCallback(new ResultCallback() { // from class: gl.m
                @Override // com.huawei.appgallery.agd.api.ResultCallback
                public final void onResult(Status status) {
                    C9968i.e.m61865r(str, consumer, status);
                }
            });
        }

        /* renamed from: t */
        public static /* synthetic */ void m61867t(Status status) {
            C11839m.m70688i("CloudRestoreAgdApiClient", "registerDownloadCallback onResult:" + status.getStatusCode());
        }

        /* renamed from: y */
        public static /* synthetic */ void m61868y(Status status) {
            C11839m.m70688i("CloudRestoreAgdApiClient", "unregisterDownloadCallback onResult:" + status.getStatusCode());
        }

        /* renamed from: z */
        public static /* synthetic */ void m61869z(String str, c cVar, C13834f.b bVar) {
            if (!C0204a0.m1125a(bVar)) {
                C11839m.m70687e("CloudRestoreAgdApiClient", "Connect fail");
                return;
            }
            AgdApiClient agdApiClient = (AgdApiClient) bVar.m82984b();
            C11839m.m70688i("CloudRestoreAgdApiClient", "unregisterAgdDownloadListener:" + str);
            if (agdApiClient == null) {
                C11839m.m70687e("CloudRestoreAgdApiClient", "client is null");
                return;
            }
            C11839m.m70688i("CloudRestoreAgdApiClient", "removeAgdDownloadListener:" + str);
            UnregisterDownloadCallbackIPCRequest unregisterDownloadCallbackIPCRequest = new UnregisterDownloadCallbackIPCRequest();
            unregisterDownloadCallbackIPCRequest.setCallback(cVar);
            unregisterDownloadCallbackIPCRequest.setPackageName(str);
            AgdApi.unregisterDownloadCallback(agdApiClient, unregisterDownloadCallbackIPCRequest).setResultCallback(new ResultCallback() { // from class: gl.w
                @Override // com.huawei.appgallery.agd.api.ResultCallback
                public final void onResult(Status status) {
                    C9968i.e.m61868y(status);
                }
            });
        }

        /* renamed from: B */
        public final void m61870B(AgdApiClient agdApiClient, String str, CloudRestoreAgdApiInterface.CloudRestoreAgdApiClientCallback cloudRestoreAgdApiClientCallback) {
            C11839m.m70688i("CloudRestoreAgdApiClient", "registerAgdDownloadListener:" + str);
            c cVar = new c(str, cloudRestoreAgdApiClientCallback);
            RegisterDownloadCallbackIPCRequest registerDownloadCallbackIPCRequest = new RegisterDownloadCallbackIPCRequest();
            registerDownloadCallbackIPCRequest.setCallback(cVar);
            registerDownloadCallbackIPCRequest.setPackageName(str);
            AgdApi.registerDownloadCallback(agdApiClient, registerDownloadCallbackIPCRequest).setResultCallback(new ResultCallback() { // from class: gl.n
                @Override // com.huawei.appgallery.agd.api.ResultCallback
                public final void onResult(Status status) {
                    C9968i.e.m61867t(status);
                }
            });
            C9968i.m61832h().m61833d(str, cVar);
            cloudRestoreAgdApiClientCallback.onAddTaskSuccess();
        }

        /* renamed from: D */
        public void m61871D(final String str) {
            final c cVarM61841m = C9968i.m61832h().m61841m(str);
            if (cVarM61841m == null) {
                return;
            }
            C9968i.m61832h().m61836g().m82981m(new InterfaceC13829a() { // from class: gl.p
                @Override // p780xm.InterfaceC13829a
                public final void accept(Object obj) {
                    C9968i.e.m61869z(str, cVarM61841m, (C13834f.b) obj);
                }
            });
        }

        @Override // com.huawei.android.hicloud.cloudbackup.process.task.CloudRestoreAgdApiInterface
        public void cancelTask(final String str) {
            C9968i.m61832h().m61836g().m82981m(new InterfaceC13829a() { // from class: gl.o
                @Override // p780xm.InterfaceC13829a
                public final void accept(Object obj) {
                    C9968i.e.m61862o(str, (C13834f.b) obj);
                }
            });
        }

        @Override // com.huawei.android.hicloud.cloudbackup.process.task.CloudRestoreAgdApiInterface
        public void pauseTask(final String str) {
            C9968i.m61832h().m61836g().m82981m(new InterfaceC13829a() { // from class: gl.k
                @Override // p780xm.InterfaceC13829a
                public final void accept(Object obj) {
                    C9968i.e.m61864q(str, (C13834f.b) obj);
                }
            });
        }

        @Override // com.huawei.android.hicloud.cloudbackup.process.task.CloudRestoreAgdApiInterface
        public void queryTask(final String str, final C0217h<Boolean> c0217h, final Consumer<Boolean> consumer) {
            C9968i.m61832h().m61836g().m82981m(new InterfaceC13829a() { // from class: gl.s
                @Override // p780xm.InterfaceC13829a
                public final void accept(Object obj) {
                    C9968i.e.m61866s(c0217h, str, consumer, (C13834f.b) obj);
                }
            });
        }

        @Override // com.huawei.android.hicloud.cloudbackup.process.task.CloudRestoreAgdApiInterface
        public void resumeTask(final String str, final C0217h<Boolean> c0217h, final CloudRestoreAgdApiInterface.CloudRestoreAgdApiClientCallback cloudRestoreAgdApiClientCallback, final boolean z10) {
            C9968i.m61832h().m61836g().m82981m(new InterfaceC13829a() { // from class: gl.r
                @Override // p780xm.InterfaceC13829a
                public final void accept(Object obj) {
                    this.f48822a.m61873v(c0217h, str, z10, cloudRestoreAgdApiClientCallback, (C13834f.b) obj);
                }
            });
        }

        @Override // com.huawei.android.hicloud.cloudbackup.process.task.CloudRestoreAgdApiInterface
        public void startTask(final String str, final DownloadParam downloadParam, final C0217h<Boolean> c0217h, final CloudRestoreAgdApiInterface.CloudRestoreAgdApiClientCallback cloudRestoreAgdApiClientCallback, final boolean z10) {
            C9968i.m61832h().m61836g().m82981m(new InterfaceC13829a() { // from class: gl.q
                @Override // p780xm.InterfaceC13829a
                public final void accept(Object obj) {
                    this.f48816a.m61875x(c0217h, str, downloadParam, z10, cloudRestoreAgdApiClientCallback, (C13834f.b) obj);
                }
            });
        }

        /* renamed from: u */
        public final /* synthetic */ void m61872u(AgdApiClient agdApiClient, String str, CloudRestoreAgdApiInterface.CloudRestoreAgdApiClientCallback cloudRestoreAgdApiClientCallback, Status status) {
            C11839m.m70688i("CloudRestoreAgdApiClient", "resumeTask result:" + status.getStatusCode());
            if (status.getStatusCode() == 0) {
                m61870B(agdApiClient, str, cloudRestoreAgdApiClientCallback);
            } else {
                C12515a.m75110o().m75172d(new d(cloudRestoreAgdApiClientCallback, status.getStatusCode()));
            }
        }

        /* renamed from: v */
        public final /* synthetic */ void m61873v(C0217h c0217h, final String str, boolean z10, final CloudRestoreAgdApiInterface.CloudRestoreAgdApiClientCallback cloudRestoreAgdApiClientCallback, C13834f.b bVar) {
            if (!C0204a0.m1125a(bVar)) {
                C11839m.m70687e("CloudRestoreAgdApiClient", "Connect fail");
                c0217h.m1450a(Boolean.FALSE);
                return;
            }
            final AgdApiClient agdApiClient = (AgdApiClient) bVar.m82984b();
            C11839m.m70688i("CloudRestoreAgdApiClient", "resumeTask:" + str);
            if (agdApiClient == null) {
                C11839m.m70687e("CloudRestoreAgdApiClient", "client is null");
                c0217h.m1450a(Boolean.FALSE);
                return;
            }
            C11839m.m70688i("CloudRestoreAgdApiClient", "resumeTask:" + str);
            ResumeTaskIPCRequest resumeTaskIPCRequest = new ResumeTaskIPCRequest();
            resumeTaskIPCRequest.setPackageName(str);
            resumeTaskIPCRequest.setSupportFunction(z10 ? 2 : 0);
            AgdApi.resumeTask(agdApiClient, resumeTaskIPCRequest).setResultCallback(new ResultCallback() { // from class: gl.u
                @Override // com.huawei.appgallery.agd.api.ResultCallback
                public final void onResult(Status status) {
                    this.f48834a.m61872u(agdApiClient, str, cloudRestoreAgdApiClientCallback, status);
                }
            });
        }

        /* renamed from: w */
        public final /* synthetic */ void m61874w(String str, AgdApiClient agdApiClient, CloudRestoreAgdApiInterface.CloudRestoreAgdApiClientCallback cloudRestoreAgdApiClientCallback, Status status) {
            C11839m.m70688i("CloudRestoreAgdApiClient", "startDownloadTaskV2 result:" + status.getStatusCode() + "pkg:" + str);
            if (status.getStatusCode() == 0) {
                m61870B(agdApiClient, str, cloudRestoreAgdApiClientCallback);
            } else {
                C12515a.m75110o().m75172d(new d(cloudRestoreAgdApiClientCallback, status.getStatusCode()));
            }
        }

        /* renamed from: x */
        public final /* synthetic */ void m61875x(C0217h c0217h, final String str, DownloadParam downloadParam, boolean z10, final CloudRestoreAgdApiInterface.CloudRestoreAgdApiClientCallback cloudRestoreAgdApiClientCallback, C13834f.b bVar) {
            if (!C0204a0.m1125a(bVar)) {
                C11839m.m70687e("CloudRestoreAgdApiClient", "Connect fail");
                c0217h.m1450a(Boolean.FALSE);
                return;
            }
            final AgdApiClient agdApiClient = (AgdApiClient) bVar.m82984b();
            C11839m.m70688i("CloudRestoreAgdApiClient", "startDownloadTask:" + str);
            if (agdApiClient == null) {
                C11839m.m70687e("CloudRestoreAgdApiClient", "client is null");
                c0217h.m1450a(Boolean.FALSE);
                return;
            }
            StartDownloadV2IPCRequest startDownloadV2IPCRequest = new StartDownloadV2IPCRequest();
            startDownloadV2IPCRequest.setReferrer(f48804a);
            startDownloadV2IPCRequest.setDownloadParams(new Gson().toJson(downloadParam));
            startDownloadV2IPCRequest.setPackageName(str);
            startDownloadV2IPCRequest.setInstallType(AgdConstant.INSTALL_TYPE_AUTO);
            startDownloadV2IPCRequest.setSupportFunction(z10 ? 2 : 0);
            AgdApi.startDownloadTaskV2(agdApiClient, startDownloadV2IPCRequest).setResultCallback(new ResultCallback() { // from class: gl.t
                @Override // com.huawei.appgallery.agd.api.ResultCallback
                public final void onResult(Status status) {
                    this.f48830a.m61874w(str, agdApiClient, cloudRestoreAgdApiClientCallback, status);
                }
            });
        }
    }

    /* renamed from: h */
    public static C9968i m61832h() {
        return f48792h;
    }

    /* renamed from: d */
    public void m61833d(String str, c cVar) {
        cVar.m61845i(this.f48796d);
        this.f48794b.put(str, cVar);
    }

    /* renamed from: e */
    public final AgdApiClient m61834e() {
        return new AgdApiClient.Builder(C0213f.m1377a()).addConnectionCallbacks(new b()).build();
    }

    /* renamed from: f */
    public void m61835f() {
        f48791g.execute(new Runnable() { // from class: gl.f
            @Override // java.lang.Runnable
            public final void run() {
                this.f48788a.m61839k();
            }
        });
    }

    /* renamed from: g */
    public C13834f<AgdApiClient> m61836g() {
        C11839m.m70686d("CloudRestoreAgdApiClient", "getConnectedAgdClient");
        return C13834f.m82974k(new Callable() { // from class: gl.h
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f48789a.m61840l();
            }
        }, f48791g);
    }

    /* renamed from: i */
    public final Looper m61837i() {
        if (this.f48795c == null) {
            this.f48795c = new HandlerThread("CloudRestoreAgdApiClient");
            this.f48795c.start();
        }
        return this.f48795c.getLooper();
    }

    /* renamed from: j */
    public final boolean m61838j() {
        return this.f48793a != null && this.f48793a.isConnected();
    }

    /* renamed from: k */
    public final /* synthetic */ void m61839k() {
        if (this.f48793a != null) {
            try {
                C11839m.m70688i("CloudRestoreAgdApiClient", "disConnect");
                this.f48793a.disconnect();
            } catch (Throwable th2) {
                C11839m.m70689w("CloudRestoreAgdApiClient", "Disconnect agc fail:" + StringUtils.anonymizeMessage(th2.getMessage()));
            }
            this.f48794b.values().forEach(new Consumer() { // from class: gl.g
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    ((C9968i.c) obj).m61843g();
                }
            });
        }
        this.f48793a = null;
    }

    /* renamed from: l */
    public final /* synthetic */ AgdApiClient m61840l() throws Exception {
        if (m61838j()) {
            C11839m.m70686d("CloudRestoreAgdApiClient", "already connect");
            return this.f48793a;
        }
        if (this.f48793a == null) {
            C11839m.m70686d("CloudRestoreAgdApiClient", "create client");
            this.f48793a = m61834e();
        }
        try {
            C11839m.m70688i("CloudRestoreAgdApiClient", "connect agd client");
            this.f48793a.connect();
            try {
                C11839m.m70688i("CloudRestoreAgdApiClient", "Waiting connect agc...");
                Object obj = f48790f;
                synchronized (obj) {
                    obj.wait(this.f48797e * 1000);
                }
            } catch (InterruptedException unused) {
                C11839m.m70689w("CloudRestoreAgdApiClient", "InterruptedException");
            }
            if (!m61838j()) {
                C11839m.m70689w("CloudRestoreAgdApiClient", "Connect agc timeout");
                return null;
            }
            C11839m.m70688i("CloudRestoreAgdApiClient", "Connect agc success");
            this.f48796d = new Handler(m61837i());
            return this.f48793a;
        } catch (Throwable th2) {
            C11839m.m70689w("CloudRestoreAgdApiClient", "Connect agc fail:" + StringUtils.anonymizeMessage(th2.getMessage()));
            this.f48793a = null;
            return null;
        }
    }

    /* renamed from: m */
    public c m61841m(String str) {
        C11839m.m70688i("CloudRestoreAgdApiClient", "removeCallback:" + str);
        c cVarRemove = this.f48794b.remove(str);
        if (cVarRemove != null) {
            return cVarRemove;
        }
        C11839m.m70688i("CloudRestoreAgdApiClient", "downloadCallback is null ," + str);
        return null;
    }
}
