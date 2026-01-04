package p329h7;

import android.app.Activity;
import android.content.IntentSender;
import android.os.RemoteException;
import com.google.gson.Gson;
import com.huawei.android.hicloud.agd.ads.AppDownloadInfo;
import com.huawei.android.hicloud.agd.ads.DownLoadState;
import com.huawei.android.hicloud.agd.ads.DownloadParam;
import com.huawei.android.remotecontrol.tag.p092ui.view.RippleView;
import com.huawei.appgallery.agd.api.AgdApi;
import com.huawei.appgallery.agd.api.AgdApiClient;
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
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hms.network.embedded.C6148x2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import p514o9.C11839m;
import p684un.C13230i;
import p709vj.C13452e;

/* renamed from: h7.h */
/* loaded from: classes2.dex */
public class C10120h {

    /* renamed from: a */
    public final Activity f49356a;

    /* renamed from: b */
    public final AgdApiClient f49357b;

    /* renamed from: c */
    public final List<String> f49358c = new ArrayList();

    /* renamed from: d */
    public final List<b> f49359d = new ArrayList();

    /* renamed from: e */
    public Consumer<DownLoadState> f49360e;

    /* renamed from: f */
    public volatile long f49361f;

    /* renamed from: h7.h$a */
    public class a implements AgdApiClient.ConnectionCallbacks {
        public a() {
        }

        @Override // com.huawei.appgallery.agd.api.AgdApiClient.ConnectionCallbacks
        public void onConnected() {
            C11839m.m70688i("AgdApiClientDelegator", "onConnected");
        }

        @Override // com.huawei.appgallery.agd.api.AgdApiClient.ConnectionCallbacks
        public void onConnectionFailed(ConnectionResult connectionResult) {
            int statusCode = connectionResult.getStatusCode();
            C11839m.m70688i("AgdApiClientDelegator", "onConnectionFailed:" + statusCode);
            if ((statusCode == 4 || statusCode == 7) && connectionResult.hasResolution() && C10120h.this.f49356a != null && C10120h.this.m63020E()) {
                try {
                    connectionResult.startResolutionForResult(C10120h.this.f49356a, 1000);
                } catch (IntentSender.SendIntentException unused) {
                    C11839m.m70687e("AgdApiClientDelegator", "start resolution failed");
                }
            }
        }

        @Override // com.huawei.appgallery.agd.api.AgdApiClient.ConnectionCallbacks
        public void onConnectionSuspended(int i10) {
            C11839m.m70688i("AgdApiClientDelegator", "onConnectionSuspended:" + i10);
        }
    }

    /* renamed from: h7.h$b */
    public class b extends IDownloadCallback.Stub {

        /* renamed from: a */
        public final AppDownloadInfo f49363a;

        public b(AppDownloadInfo appDownloadInfo) {
            this.f49363a = appDownloadInfo;
        }

        /* renamed from: g */
        public String m63034g() {
            return this.f49363a.getPackageName();
        }

        @Override // com.huawei.appmarket.service.externalservice.distribution.download.IDownloadCallback
        public String getDownloadRegisterKey() throws RemoteException {
            return "";
        }

        @Override // com.huawei.appmarket.service.externalservice.distribution.download.IDownloadCallback
        public void refreshAppStatus(String str, int i10, int i11, int i12) throws RemoteException {
            C11839m.m70688i("AgdApiClientDelegator", "packageName:" + str + ",appType:" + i10 + ",status:" + i11 + ",progress:" + i12);
            if (C10120h.this.f49360e != null) {
                this.f49363a.setPackageName(str);
                C10120h.this.f49360e.accept(new DownLoadState(this.f49363a, i11, i12, i10));
            }
        }
    }

    public C10120h(Activity activity) {
        this.f49356a = activity;
        this.f49357b = new AgdApiClient.Builder(activity.getApplicationContext()).addConnectionCallbacks(new a()).build();
    }

    /* renamed from: p */
    public static /* synthetic */ void m63011p(Status status) {
        C11839m.m70688i("AgdApiClientDelegator", "cancelDownloadTask onResult:" + status.getStatusCode());
    }

    /* renamed from: q */
    public static /* synthetic */ void m63012q(Status status) {
        C11839m.m70688i("AgdApiClientDelegator", "pauseDownloadTask onResult:" + status.getStatusCode());
    }

    /* renamed from: r */
    public static /* synthetic */ void m63013r(String str, AppDownloadInfo appDownloadInfo, Consumer consumer, Status status) {
        C11839m.m70688i("AgdApiClientDelegator", "callQueryTask,onResult:" + status.getStatusCode());
        if (status.getResponse() != null && ((QueryTaskResponse) status.getResponse()).getTaskList() != null) {
            HashMap<String, TaskInfo> taskList = ((QueryTaskResponse) status.getResponse()).getTaskList();
            if (taskList.size() > 0) {
                for (Map.Entry<String, TaskInfo> entry : taskList.entrySet()) {
                    if (entry.getKey().equals(str)) {
                        C11839m.m70688i("AgdApiClientDelegator", "queryDownloadTasks,packageName = " + entry.getKey() + ", statusType = " + entry.getValue().getAppStatusType() + ", status = " + entry.getValue().getStatus() + ", progress = " + entry.getValue().getProgress());
                        consumer.accept(new DownLoadState(appDownloadInfo, entry.getValue().getStatus(), entry.getValue().getProgress(), entry.getValue().getAppStatusType()));
                        return;
                    }
                }
            }
        }
        C11839m.m70688i("AgdApiClientDelegator", "there are no download or install task:" + str);
        consumer.accept(new DownLoadState(appDownloadInfo, 5, 0, 2));
    }

    /* renamed from: s */
    public static /* synthetic */ void m63014s(Status status) {
        C11839m.m70688i("AgdApiClientDelegator", "registerDownloadCallback onResult:" + status.getStatusCode());
    }

    /* renamed from: t */
    public static /* synthetic */ void m63015t(Status status) {
        C11839m.m70688i("AgdApiClientDelegator", "unregisterDownloadCallback onResult:" + status.getStatusCode());
    }

    /* renamed from: A */
    public final void m63016A(AppDownloadInfo appDownloadInfo) {
        String packageName = appDownloadInfo.getPackageName();
        b bVar = new b(appDownloadInfo);
        if (!m63023k(bVar)) {
            C11839m.m70688i("AgdApiClientDelegator", "downloadCallback already exist");
            return;
        }
        RegisterDownloadCallbackIPCRequest registerDownloadCallbackIPCRequest = new RegisterDownloadCallbackIPCRequest();
        registerDownloadCallbackIPCRequest.setPackageName(packageName);
        registerDownloadCallbackIPCRequest.setCallback(bVar);
        AgdApi.registerDownloadCallback(this.f49357b, registerDownloadCallbackIPCRequest).setResultCallback(new ResultCallback() { // from class: h7.f
            @Override // com.huawei.appgallery.agd.api.ResultCallback
            public final void onResult(Status status) {
                C10120h.m63014s(status);
            }
        });
    }

    /* renamed from: B */
    public void m63017B() {
        C11839m.m70688i("AgdApiClientDelegator", "removeAllListener");
        for (String str : this.f49358c) {
            UnregisterDownloadCallbackIPCRequest unregisterDownloadCallbackIPCRequest = new UnregisterDownloadCallbackIPCRequest();
            unregisterDownloadCallbackIPCRequest.setPackageName(str);
            AgdApi.unregisterDownloadCallback(this.f49357b, unregisterDownloadCallbackIPCRequest).setResultCallback(new ResultCallback() { // from class: h7.e
                @Override // com.huawei.appgallery.agd.api.ResultCallback
                public final void onResult(Status status) {
                    C10120h.m63015t(status);
                }
            });
        }
        this.f49359d.clear();
    }

    /* renamed from: C */
    public int m63018C(final AppDownloadInfo appDownloadInfo) throws InterruptedException {
        boolean zAwait;
        final String packageName = appDownloadInfo.getPackageName();
        if (m63022G()) {
            C11839m.m70689w("AgdApiClientDelegator", "resumeDownloadTask:agd client not connect");
            return -1;
        }
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final AtomicInteger atomicInteger = new AtomicInteger(-1);
        ResumeTaskIPCRequest resumeTaskIPCRequest = new ResumeTaskIPCRequest();
        resumeTaskIPCRequest.setPackageName(packageName);
        resumeTaskIPCRequest.setSupportFunction(1);
        AgdApi.resumeTask(this.f49357b, resumeTaskIPCRequest).setResultCallback(new ResultCallback() { // from class: h7.c
            @Override // com.huawei.appgallery.agd.api.ResultCallback
            public final void onResult(Status status) {
                this.f49348a.m63028u(packageName, appDownloadInfo, countDownLatch, atomicInteger, status);
            }
        });
        try {
            zAwait = countDownLatch.await(15000L, TimeUnit.MILLISECONDS);
        } catch (Exception e10) {
            C11839m.m70687e("AgdApiClientDelegator", "resumeDownloadTask exception:" + e10.toString());
            zAwait = false;
        }
        C11839m.m70688i("AgdApiClientDelegator", "resumeDownloadTask result:" + zAwait);
        return 0;
    }

    /* renamed from: D */
    public void m63019D(Consumer<DownLoadState> consumer) {
        this.f49360e = consumer;
    }

    /* renamed from: E */
    public final boolean m63020E() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean z10 = jCurrentTimeMillis - this.f49361f > RippleView.SINGLE_RIPPLE_TIME;
        this.f49361f = jCurrentTimeMillis;
        return z10;
    }

    /* renamed from: F */
    public void m63021F(final AppDownloadInfo appDownloadInfo, DownloadParam downloadParam, final EnumC10122j enumC10122j) {
        String adId = appDownloadInfo.getAdId();
        final String packageName = appDownloadInfo.getPackageName();
        if (m63022G()) {
            C11839m.m70689w("AgdApiClientDelegator", "startDownloadTask:agd client not connect");
            this.f49360e.accept(new DownLoadState(appDownloadInfo, 5, 0, 2));
            return;
        }
        C11839m.m70688i("AgdApiClientDelegator", "startDownloadTask:" + packageName);
        StartDownloadV2IPCRequest startDownloadV2IPCRequest = new StartDownloadV2IPCRequest();
        startDownloadV2IPCRequest.setReferrer(adId);
        startDownloadV2IPCRequest.setPackageName(packageName);
        startDownloadV2IPCRequest.setDownloadParams(new Gson().toJson(downloadParam));
        startDownloadV2IPCRequest.setSupportFunction(1);
        startDownloadV2IPCRequest.setInstallType(enumC10122j.toString());
        AgdApi.startDownloadTaskV2(this.f49357b, startDownloadV2IPCRequest).setResultCallback(new ResultCallback() { // from class: h7.a
            @Override // com.huawei.appgallery.agd.api.ResultCallback
            public final void onResult(Status status) {
                this.f49344a.m63029v(packageName, enumC10122j, appDownloadInfo, status);
            }
        });
    }

    /* renamed from: G */
    public boolean m63022G() {
        C11839m.m70688i("AgdApiClientDelegator", "tryConnect");
        AgdApiClient agdApiClient = this.f49357b;
        if (agdApiClient == null || agdApiClient.isConnected()) {
            return false;
        }
        this.f49357b.connect();
        C11839m.m70688i("AgdApiClientDelegator", "connecting");
        return true;
    }

    /* renamed from: k */
    public final boolean m63023k(b bVar) {
        Iterator<b> it = this.f49359d.iterator();
        while (it.hasNext()) {
            if (it.next().m63034g().equals(bVar.m63034g())) {
                return false;
            }
        }
        this.f49359d.add(bVar);
        return true;
    }

    /* renamed from: l */
    public void m63024l(String str) {
        if (m63022G()) {
            C11839m.m70689w("AgdApiClientDelegator", "cancelDownloadTask:agd client not connect");
            return;
        }
        CancelTaskIPCRequest cancelTaskIPCRequest = new CancelTaskIPCRequest();
        cancelTaskIPCRequest.setPackageName(str);
        AgdApi.cancelTask(this.f49357b, cancelTaskIPCRequest).setResultCallback(new ResultCallback() { // from class: h7.b
            @Override // com.huawei.appgallery.agd.api.ResultCallback
            public final void onResult(Status status) {
                C10120h.m63011p(status);
            }
        });
    }

    /* renamed from: m */
    public void m63025m() {
        AgdApiClient agdApiClient = this.f49357b;
        if (agdApiClient != null) {
            agdApiClient.connect();
        }
    }

    /* renamed from: n */
    public void m63026n() {
        AgdApiClient agdApiClient = this.f49357b;
        if (agdApiClient != null) {
            agdApiClient.disconnect();
        }
    }

    /* renamed from: o */
    public final void m63027o(Status status, AppDownloadInfo appDownloadInfo, boolean z10) {
        String packageName = appDownloadInfo.getPackageName();
        if (15 == status.getStatusCode() || 2 == status.getStatusCode()) {
            try {
                status.startResolutionForResult(this.f49356a, 15);
                return;
            } catch (Exception unused) {
                C11839m.m70688i("AgdApiClientDelegator", "startResolutionForResult failed");
                return;
            }
        }
        if (6 == status.getStatusCode()) {
            try {
                status.startResolutionForResult(this.f49356a, 15);
                if (z10) {
                    this.f49358c.add(packageName);
                }
                m63016A(appDownloadInfo);
                return;
            } catch (Exception unused2) {
                C11839m.m70688i("AgdApiClientDelegator", "startResolutionForResult failed");
                return;
            }
        }
        if (status.getStatusCode() != 0) {
            this.f49360e.accept(new DownLoadState(appDownloadInfo, 5, 0, 2));
            return;
        }
        C11839m.m70688i("AgdApiClientDelegator", "registerDownloadCallback");
        if (z10) {
            this.f49358c.add(packageName);
        }
        m63016A(appDownloadInfo);
    }

    /* renamed from: u */
    public final /* synthetic */ void m63028u(String str, AppDownloadInfo appDownloadInfo, CountDownLatch countDownLatch, AtomicInteger atomicInteger, Status status) {
        m63033z(str, "", status.getStatusCode());
        C11839m.m70688i("AgdApiClientDelegator", "resumeDownloadTask onResult:" + status.getStatusCode());
        m63027o(status, appDownloadInfo, false);
        countDownLatch.countDown();
        atomicInteger.set(status.getStatusCode());
    }

    /* renamed from: v */
    public final /* synthetic */ void m63029v(String str, EnumC10122j enumC10122j, AppDownloadInfo appDownloadInfo, Status status) {
        C11839m.m70688i("AgdApiClientDelegator", "startDownloadTaskV2 result:" + status.getStatusCode());
        m63033z(str, enumC10122j.toString(), status.getStatusCode());
        m63027o(status, appDownloadInfo, true);
    }

    /* renamed from: w */
    public boolean m63030w(String str) {
        C11839m.m70688i("AgdApiClientDelegator", "openAgdAppByPackageName:" + str);
        try {
            this.f49356a.startActivityForResult(this.f49356a.getPackageManager().getLaunchIntentForPackage(str), 1002);
            return true;
        } catch (Exception unused) {
            C11839m.m70688i("AgdApiClientDelegator", "openAgdAppByPackageName:" + str);
            return false;
        }
    }

    /* renamed from: x */
    public void m63031x(String str) {
        if (m63022G()) {
            C11839m.m70689w("AgdApiClientDelegator", "pauseDownloadTask:agd client not connect");
            return;
        }
        PauseTaskIPCRequest pauseTaskIPCRequest = new PauseTaskIPCRequest();
        pauseTaskIPCRequest.setPackageName(str);
        AgdApi.pauseTask(this.f49357b, pauseTaskIPCRequest).setResultCallback(new ResultCallback() { // from class: h7.d
            @Override // com.huawei.appgallery.agd.api.ResultCallback
            public final void onResult(Status status) {
                C10120h.m63012q(status);
            }
        });
    }

    /* renamed from: y */
    public void m63032y(final AppDownloadInfo appDownloadInfo, final Consumer<DownLoadState> consumer) {
        final String packageName = appDownloadInfo.getPackageName();
        if (m63022G()) {
            C11839m.m70689w("AgdApiClientDelegator", "queryDownloadTasks:agd client not connect");
            consumer.accept(new DownLoadState(appDownloadInfo, 5, 0, 2));
        } else {
            AgdApi.queryTasks(this.f49357b, new QueryTaskIPCRequest()).setResultCallback(new ResultCallback() { // from class: h7.g
                @Override // com.huawei.appgallery.agd.api.ResultCallback
                public final void onResult(Status status) {
                    C10120h.m63013r(packageName, appDownloadInfo, consumer, status);
                }
            });
        }
    }

    /* renamed from: z */
    public final void m63033z(String str, String str2, int i10) {
        if (i10 == 0) {
            return;
        }
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put(C6148x2.DEVICE_ID, C13452e.m80781L().m80954p());
        linkedHashMapM79497A.put("download_agd_ads_package_key", str);
        linkedHashMapM79497A.put("terminal_agd_ads_reason_key", String.valueOf(i10));
        linkedHashMapM79497A.put("download_agd_ads_install_type_key", str2);
        C13230i.m79504I().m79567R("terminal_agd_ads_event", linkedHashMapM79497A);
        UBAAnalyze.m29947H("CKC", "terminal_agd_ads_event", linkedHashMapM79497A);
    }
}
