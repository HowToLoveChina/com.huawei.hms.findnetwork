package com.huawei.openalliance.p169ad.download.p172ag;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.download.DownloadTask;
import com.huawei.openalliance.p169ad.download.InterfaceC7069l;
import com.huawei.openalliance.p169ad.download.app.AppDownloadTask;
import com.huawei.openalliance.p169ad.download.app.interfaces.AutoOpenListener;
import com.huawei.openalliance.p169ad.inter.data.AppInfo;
import com.huawei.openalliance.p169ad.inter.listeners.AppDownloadListener;
import com.huawei.openalliance.p169ad.inter.listeners.AppDownloadListenerV1;
import com.huawei.openalliance.p169ad.ipc.CallResult;
import com.huawei.openalliance.p169ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.p169ad.views.AppDownloadButton;
import org.json.JSONException;

/* renamed from: com.huawei.openalliance.ad.download.ag.d */
/* loaded from: classes2.dex */
public class C7036d extends C7033a<AppDownloadTask> {

    /* renamed from: e */
    private static final byte[] f32308e = new byte[0];

    /* renamed from: f */
    private static C7036d f32309f;

    /* renamed from: d */
    C7035c f32310d;

    private C7036d(Context context) {
        super(context);
        super.m42106a();
        C7035c c7035c = new C7035c(context);
        this.f32310d = c7035c;
        m42109a(c7035c);
    }

    /* renamed from: b */
    public AppDownloadTask m42179b(AppInfo appInfo) {
        RemoteAppDownloadTask remoteAppDownloadTask;
        if (m42170c(appInfo)) {
            return null;
        }
        AppDownloadTask appDownloadTask = (AppDownloadTask) super.mo42105a(appInfo.getPackageName());
        if (appDownloadTask != null || (remoteAppDownloadTask = (RemoteAppDownloadTask) C7038f.m42201a(this.f32268a, appInfo, RemoteAppDownloadTask.class)) == null) {
            return appDownloadTask;
        }
        AbstractC7185ho.m43820b("AgLocalDownloadMgr", " remote task is exist, create proxy task");
        AppDownloadTask appDownloadTaskM42104a = remoteAppDownloadTask.m42104a(appInfo);
        super.mo42107a((C7036d) appDownloadTaskM42104a);
        return appDownloadTaskM42104a;
    }

    /* renamed from: c */
    public void m42184c() {
        C7035c c7035c = this.f32310d;
        if (c7035c != null) {
            c7035c.m42150a();
        }
    }

    /* renamed from: d */
    public void m42186d() {
        C7035c c7035c = this.f32310d;
        if (c7035c != null) {
            c7035c.m42159b();
        }
    }

    /* renamed from: a */
    public static C7036d m42166a(Context context) {
        synchronized (f32308e) {
            try {
                if (f32309f == null) {
                    f32309f = new C7036d(context);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return f32309f;
    }

    @Override // com.huawei.openalliance.p169ad.download.p172ag.C7033a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public AppDownloadTask mo42105a(String str) {
        DownloadTask downloadTaskMo42105a = super.mo42105a(str);
        if (downloadTaskMo42105a instanceof AppDownloadTask) {
            return (AppDownloadTask) downloadTaskMo42105a;
        }
        if (downloadTaskMo42105a == null) {
            AppInfo appInfo = new AppInfo();
            appInfo.m44371a(str);
            appInfo.m44423q("5");
            RemoteAppDownloadTask remoteAppDownloadTask = (RemoteAppDownloadTask) C7038f.m42201a(this.f32268a, appInfo, RemoteAppDownloadTask.class);
            if (remoteAppDownloadTask != null) {
                AbstractC7185ho.m43820b("AgLocalDownloadMgr", " remote task is exist, create proxy task");
                AppDownloadTask appDownloadTaskM42104a = remoteAppDownloadTask.m42104a(appInfo);
                super.mo42107a((C7036d) appDownloadTaskM42104a);
                return appDownloadTaskM42104a;
            }
        }
        return null;
    }

    /* renamed from: c */
    public void m42185c(final AppDownloadTask appDownloadTask) throws JSONException {
        if (appDownloadTask == null) {
            return;
        }
        C7038f.m42203a(this.f32268a, appDownloadTask, new RemoteCallResultCallback<String>() { // from class: com.huawei.openalliance.ad.download.ag.d.3
            @Override // com.huawei.openalliance.p169ad.ipc.RemoteCallResultCallback
            public void onRemoteCallResult(String str, CallResult<String> callResult) {
                if (callResult.getCode() != -1) {
                    appDownloadTask.m42251e(true);
                    C7036d.super.mo42107a((C7036d) appDownloadTask);
                    AbstractC7185ho.m43820b("AgLocalDownloadMgr", " resume task is success:" + appDownloadTask.mo42082n());
                }
            }
        }, String.class);
    }

    /* renamed from: c */
    private static boolean m42170c(AppInfo appInfo) {
        return appInfo == null || TextUtils.isEmpty(appInfo.getPackageName());
    }

    /* renamed from: b */
    public void m42181b(final AppDownloadTask appDownloadTask) throws JSONException {
        if (appDownloadTask == null) {
            return;
        }
        C7038f.m42209b(this.f32268a, appDownloadTask, new RemoteCallResultCallback<String>() { // from class: com.huawei.openalliance.ad.download.ag.d.2
            @Override // com.huawei.openalliance.p169ad.ipc.RemoteCallResultCallback
            public void onRemoteCallResult(String str, CallResult<String> callResult) {
                if (callResult.getCode() != -1) {
                    AbstractC7185ho.m43820b("AgLocalDownloadMgr", " pause task is success:" + appDownloadTask.mo42082n());
                }
            }
        }, String.class);
    }

    @Override // com.huawei.openalliance.p169ad.download.p172ag.C7033a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void mo42107a(final AppDownloadTask appDownloadTask) throws JSONException {
        C7038f.m42203a(this.f32268a, appDownloadTask, new RemoteCallResultCallback<String>() { // from class: com.huawei.openalliance.ad.download.ag.d.1
            @Override // com.huawei.openalliance.p169ad.ipc.RemoteCallResultCallback
            public void onRemoteCallResult(String str, CallResult<String> callResult) {
                if (callResult.getCode() != -1) {
                    AppDownloadTask appDownloadTask2 = appDownloadTask;
                    if (appDownloadTask2 != null) {
                        appDownloadTask2.m42251e(true);
                    }
                    C7036d.super.mo42107a((C7036d) appDownloadTask);
                }
            }
        }, String.class);
    }

    /* renamed from: b */
    public void m42182b(String str, InterfaceC7069l interfaceC7069l) {
        C7035c c7035c = this.f32310d;
        if (c7035c != null) {
            c7035c.m42162b(str, interfaceC7069l);
        }
    }

    /* renamed from: a */
    public void m42172a(AutoOpenListener autoOpenListener) {
        C7035c c7035c = this.f32310d;
        if (c7035c != null) {
            c7035c.m42153a(autoOpenListener);
        }
    }

    /* renamed from: b */
    public void m42183b(String str, AppDownloadButton.OnResolutionRequiredListener onResolutionRequiredListener) {
        C7035c c7035c = this.f32310d;
        if (c7035c != null) {
            c7035c.m42163b(str, onResolutionRequiredListener);
        }
    }

    /* renamed from: a */
    public void m42173a(AppInfo appInfo) throws JSONException {
        if (m42170c(appInfo)) {
            return;
        }
        final AppDownloadTask appDownloadTaskM42179b = m42179b(appInfo);
        if (appDownloadTaskM42179b != null) {
            C7038f.m42211c(this.f32268a, appDownloadTaskM42179b, new RemoteCallResultCallback<String>() { // from class: com.huawei.openalliance.ad.download.ag.d.4
                @Override // com.huawei.openalliance.p169ad.ipc.RemoteCallResultCallback
                public void onRemoteCallResult(String str, CallResult<String> callResult) {
                    if (callResult.getCode() == 200 && String.valueOf(Boolean.TRUE).equals(callResult.getData())) {
                        C7036d.super.m42112c((C7036d) appDownloadTaskM42179b);
                        AbstractC7185ho.m43820b("AgLocalDownloadMgr", " removeTask task is success:" + appDownloadTaskM42179b.mo42082n());
                    }
                }
            }, String.class);
            return;
        }
        AbstractC7185ho.m43820b("AgLocalDownloadMgr", " removeTask failed:" + appInfo.getPackageName());
    }

    /* renamed from: a */
    public void m42174a(AppDownloadListener appDownloadListener) {
        C7035c c7035c = this.f32310d;
        if (c7035c != null) {
            c7035c.m42154a(appDownloadListener);
        }
    }

    /* renamed from: a */
    public void m42175a(AppDownloadListenerV1 appDownloadListenerV1) {
        C7035c c7035c = this.f32310d;
        if (c7035c != null) {
            c7035c.m42155a(appDownloadListenerV1);
        }
    }

    /* renamed from: a */
    public void m42176a(AppDownloadButton.OnResolutionRequiredListener onResolutionRequiredListener) {
        C7035c c7035c = this.f32310d;
        if (c7035c != null) {
            c7035c.m42156a(onResolutionRequiredListener);
        }
    }

    /* renamed from: a */
    public void m42177a(String str, InterfaceC7069l interfaceC7069l) {
        C7035c c7035c = this.f32310d;
        if (c7035c != null) {
            c7035c.m42157a(str, interfaceC7069l);
        }
    }

    /* renamed from: a */
    public void m42178a(String str, AppDownloadButton.OnResolutionRequiredListener onResolutionRequiredListener) {
        C7035c c7035c = this.f32310d;
        if (c7035c != null) {
            c7035c.m42158a(str, onResolutionRequiredListener);
        }
    }
}
