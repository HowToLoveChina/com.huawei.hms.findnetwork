package com.huawei.hms.common;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.adapter.AvailableUtil;
import com.huawei.hms.adapter.BinderAdapter;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.Api.ApiOptions;
import com.huawei.hms.api.ConnectionResult;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.AnyClient;
import com.huawei.hms.common.internal.BaseHmsClient;
import com.huawei.hms.common.internal.BindResolveClients;
import com.huawei.hms.common.internal.ClientSettings;
import com.huawei.hms.common.internal.HmsClient;
import com.huawei.hms.common.internal.RequestHeader;
import com.huawei.hms.common.internal.RequestManager;
import com.huawei.hms.common.internal.ResolveClientBean;
import com.huawei.hms.common.internal.ResponseHeader;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.common.internal.TaskApiCallWrapper;
import com.huawei.hms.common.internal.TransactionIdCreater;
import com.huawei.hms.core.aidl.IAIDLInvoke;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.client.SubAppInfo;
import com.huawei.hms.support.api.entity.auth.Scope;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.huawei.hms.support.hianalytics.HiAnalyticsInnerClient;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Checker;
import com.huawei.hms.utils.HMSBIInitializer;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.Util;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import p208cq.C8941i;

/* loaded from: classes8.dex */
public class HuaweiApi<TOption extends Api.ApiOptions> {

    /* renamed from: a */
    private Context f23412a;

    /* renamed from: b */
    private TOption f23413b;

    /* renamed from: c */
    private Context f23414c;

    /* renamed from: d */
    private AbstractClientBuilder<?, TOption> f23415d;

    /* renamed from: e */
    private String f23416e;

    /* renamed from: f */
    private String f23417f;

    /* renamed from: g */
    private SubAppInfo f23418g;

    /* renamed from: h */
    private WeakReference<Activity> f23419h;

    /* renamed from: i */
    private int f23420i;

    /* renamed from: j */
    private int f23421j = 1;

    /* renamed from: k */
    private boolean f23422k = false;

    /* renamed from: l */
    private String f23423l;

    /* renamed from: m */
    private boolean f23424m;

    /* renamed from: n */
    private RequestManager f23425n;

    /* renamed from: com.huawei.hms.common.HuaweiApi$1 */
    public class RunnableC51361 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ HuaweiApi f23426a;

        /* renamed from: b */
        final /* synthetic */ C8941i f23427b;

        public RunnableC51361(HuaweiApi huaweiApi, C8941i c8941i) {
            huaweiApi = huaweiApi;
            c8941i = c8941i;
        }

        @Override // java.lang.Runnable
        public void run() {
            HuaweiApi.this.m30642a((HuaweiApi<?>) huaweiApi, (C8941i<Boolean>) c8941i);
        }
    }

    public static class RequestHandler<OptionsT extends Api.ApiOptions> implements BaseHmsClient.ConnectionCallbacks, BaseHmsClient.OnConnectionFailedListener {

        /* renamed from: b */
        private final AnyClient f23430b;

        /* renamed from: d */
        private final HuaweiApi<OptionsT> f23432d;

        /* renamed from: e */
        private ResolveClientBean f23433e;
        public final Queue<TaskApiCallbackWrapper> callbackWaitQueue = new LinkedList();

        /* renamed from: a */
        private final Queue<TaskApiCallbackWrapper> f23429a = new LinkedList();

        /* renamed from: c */
        private ConnectionResult f23431c = null;

        /* renamed from: com.huawei.hms.common.HuaweiApi$RequestHandler$1 */
        public class C51371 implements AnyClient.CallBack {

            /* renamed from: a */
            private AtomicBoolean f23434a = new AtomicBoolean(true);

            /* renamed from: b */
            final /* synthetic */ TaskApiCallWrapper f23435b;

            public C51371(TaskApiCallWrapper taskApiCallWrapper) {
                taskApiCallWrapper = taskApiCallWrapper;
            }

            @Override // com.huawei.hms.common.internal.AnyClient.CallBack
            public void onCallback(IMessageEntity iMessageEntity, String str) {
                if (!(iMessageEntity instanceof ResponseHeader)) {
                    HMSLog.m36986e("HuaweiApi", "header is not instance of ResponseHeader");
                    return;
                }
                ResponseHeader responseHeader = (ResponseHeader) iMessageEntity;
                if (responseHeader.getErrorCode() == 11) {
                    RequestHandler.this.m30659a();
                    HMSLog.m36988i("HuaweiApi", "unbind service");
                }
                if (!TextUtils.isEmpty(responseHeader.getResolution())) {
                    HMSLog.m36986e("HuaweiApi", "Response has resolution: " + responseHeader.getResolution());
                }
                if (this.f23434a.compareAndSet(true, false)) {
                    HiAnalyticsInnerClient.reportEntryExit(RequestHandler.this.f23432d.getContext(), responseHeader, String.valueOf(RequestHandler.this.f23432d.getKitSdkVersion()));
                }
                taskApiCallWrapper.getTaskApiCall().onResponse(RequestHandler.this.f23430b, responseHeader, str, taskApiCallWrapper.getTaskCompletionSource());
            }
        }

        /* renamed from: com.huawei.hms.common.HuaweiApi$RequestHandler$2 */
        public class C51382 implements AnyClient.CallBack {

            /* renamed from: a */
            final /* synthetic */ TaskApiCallbackWrapper f23437a;

            /* renamed from: b */
            final /* synthetic */ RequestHeader f23438b;

            /* renamed from: com.huawei.hms.common.HuaweiApi$RequestHandler$2$1 */
            public class AnonymousClass1 implements Runnable {
                public AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    RequestHandler.this.f23429a.remove(taskApiCallbackWrapper);
                }
            }

            public C51382(TaskApiCallbackWrapper taskApiCallbackWrapper, RequestHeader requestHeader) {
                taskApiCallbackWrapper = taskApiCallbackWrapper;
                requestHeader = requestHeader;
            }

            @Override // com.huawei.hms.common.internal.AnyClient.CallBack
            public void onCallback(IMessageEntity iMessageEntity, String str) {
                AnyClient.CallBack callBackM30663b = taskApiCallbackWrapper.m30663b();
                if (callBackM30663b != null) {
                    callBackM30663b.onCallback(iMessageEntity, str);
                }
                RequestManager.removeReqByTransId(requestHeader.getTransactionId());
                RequestManager.getHandler().post(new Runnable() { // from class: com.huawei.hms.common.HuaweiApi.RequestHandler.2.1
                    public AnonymousClass1() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        RequestHandler.this.f23429a.remove(taskApiCallbackWrapper);
                    }
                });
            }
        }

        /* renamed from: com.huawei.hms.common.HuaweiApi$RequestHandler$3 */
        public class RunnableC51393 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ ConnectionResult f23441a;

            public RunnableC51393(ConnectionResult connectionResult) {
                connectionResult = connectionResult;
            }

            @Override // java.lang.Runnable
            public void run() {
                RequestHandler.this.m30653b(connectionResult);
            }
        }

        /* renamed from: com.huawei.hms.common.HuaweiApi$RequestHandler$4 */
        public class RunnableC51404 implements Runnable {
            public RunnableC51404() {
            }

            @Override // java.lang.Runnable
            public void run() {
                RequestHandler.this.m30652b();
            }
        }

        /* renamed from: com.huawei.hms.common.HuaweiApi$RequestHandler$5 */
        public class RunnableC51415 implements Runnable {
            public RunnableC51415() {
            }

            @Override // java.lang.Runnable
            public void run() {
                RequestHandler.this.m30656c();
            }
        }

        public RequestHandler(HuaweiApi<OptionsT> huaweiApi) {
            this.f23432d = huaweiApi;
            this.f23430b = huaweiApi.getClient(RequestManager.getHandler().getLooper(), this);
        }

        public AnyClient getClient() {
            return this.f23430b;
        }

        @Override // com.huawei.hms.common.internal.BaseHmsClient.ConnectionCallbacks
        public void onConnected() {
            HMSLog.m36988i("HuaweiApi", "onConnected");
            BindResolveClients.getInstance().unRegister(this.f23433e);
            this.f23433e = null;
            RequestManager.getHandler().post(new Runnable() { // from class: com.huawei.hms.common.HuaweiApi.RequestHandler.4
                public RunnableC51404() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    RequestHandler.this.m30652b();
                }
            });
        }

        @Override // com.huawei.hms.common.internal.BaseHmsClient.OnConnectionFailedListener
        public void onConnectionFailed(ConnectionResult connectionResult) {
            HMSLog.m36988i("HuaweiApi", "onConnectionFailed");
            BindResolveClients.getInstance().unRegister(this.f23433e);
            this.f23433e = null;
            RequestManager.getHandler().post(new Runnable() { // from class: com.huawei.hms.common.HuaweiApi.RequestHandler.3

                /* renamed from: a */
                final /* synthetic */ ConnectionResult f23441a;

                public RunnableC51393(ConnectionResult connectionResult2) {
                    connectionResult = connectionResult2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    RequestHandler.this.m30653b(connectionResult);
                }
            });
        }

        @Override // com.huawei.hms.common.internal.BaseHmsClient.ConnectionCallbacks
        public void onConnectionSuspended(int i10) {
            HMSLog.m36988i("HuaweiApi", "onConnectionSuspended");
            BindResolveClients.getInstance().unRegister(this.f23433e);
            this.f23433e = null;
            RequestManager.getHandler().post(new Runnable() { // from class: com.huawei.hms.common.HuaweiApi.RequestHandler.5
                public RunnableC51415() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    RequestHandler.this.m30656c();
                }
            });
        }

        public void postMessage(TaskApiCallbackWrapper taskApiCallbackWrapper) {
            RequestManager.addToConnectedReqMap(taskApiCallbackWrapper.m30662a().getTaskApiCall().getTransactionId(), this);
            this.f23429a.add(taskApiCallbackWrapper);
            String uri = taskApiCallbackWrapper.m30662a().getTaskApiCall().getUri();
            String packageName = (((HuaweiApi) this.f23432d).f23414c == null ? this.f23432d.getContext() : ((HuaweiApi) this.f23432d).f23414c).getPackageName();
            if (((HuaweiApi) this.f23432d).f23414c != null) {
                HuaweiApi<OptionsT> huaweiApi = this.f23432d;
                huaweiApi.m30643b(((HuaweiApi) huaweiApi).f23414c);
            }
            RequestHeader requestHeader = new RequestHeader();
            requestHeader.setSrvName(uri.split("\\.")[0]);
            requestHeader.setApiName(uri);
            requestHeader.setAppID(this.f23432d.getAppID() + "|" + this.f23432d.getSubAppID());
            requestHeader.setPkgName(packageName);
            requestHeader.setSessionId(this.f23430b.getSessionId());
            TaskApiCall taskApiCall = taskApiCallbackWrapper.m30662a().getTaskApiCall();
            requestHeader.setTransactionId(m30648a(taskApiCall.getTransactionId(), uri));
            requestHeader.setParcelable(taskApiCall.getParcelable());
            requestHeader.setKitSdkVersion(this.f23432d.getKitSdkVersion());
            requestHeader.setApiLevel(Math.max(this.f23432d.getApiLevel(), taskApiCall.getApiLevel()));
            this.f23430b.post(requestHeader, taskApiCall.getRequestJson(), new AnyClient.CallBack() { // from class: com.huawei.hms.common.HuaweiApi.RequestHandler.2

                /* renamed from: a */
                final /* synthetic */ TaskApiCallbackWrapper f23437a;

                /* renamed from: b */
                final /* synthetic */ RequestHeader f23438b;

                /* renamed from: com.huawei.hms.common.HuaweiApi$RequestHandler$2$1 */
                public class AnonymousClass1 implements Runnable {
                    public AnonymousClass1() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        RequestHandler.this.f23429a.remove(taskApiCallbackWrapper);
                    }
                }

                public C51382(TaskApiCallbackWrapper taskApiCallbackWrapper2, RequestHeader requestHeader2) {
                    taskApiCallbackWrapper = taskApiCallbackWrapper2;
                    requestHeader = requestHeader2;
                }

                @Override // com.huawei.hms.common.internal.AnyClient.CallBack
                public void onCallback(IMessageEntity iMessageEntity, String str) {
                    AnyClient.CallBack callBackM30663b = taskApiCallbackWrapper.m30663b();
                    if (callBackM30663b != null) {
                        callBackM30663b.onCallback(iMessageEntity, str);
                    }
                    RequestManager.removeReqByTransId(requestHeader.getTransactionId());
                    RequestManager.getHandler().post(new Runnable() { // from class: com.huawei.hms.common.HuaweiApi.RequestHandler.2.1
                        public AnonymousClass1() {
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            RequestHandler.this.f23429a.remove(taskApiCallbackWrapper);
                        }
                    });
                }
            });
        }

        /* renamed from: b */
        private TaskApiCallbackWrapper m30651b(TaskApiCallWrapper taskApiCallWrapper) {
            return new TaskApiCallbackWrapper(taskApiCallWrapper, new AnyClient.CallBack() { // from class: com.huawei.hms.common.HuaweiApi.RequestHandler.1

                /* renamed from: a */
                private AtomicBoolean f23434a = new AtomicBoolean(true);

                /* renamed from: b */
                final /* synthetic */ TaskApiCallWrapper f23435b;

                public C51371(TaskApiCallWrapper taskApiCallWrapper2) {
                    taskApiCallWrapper = taskApiCallWrapper2;
                }

                @Override // com.huawei.hms.common.internal.AnyClient.CallBack
                public void onCallback(IMessageEntity iMessageEntity, String str) {
                    if (!(iMessageEntity instanceof ResponseHeader)) {
                        HMSLog.m36986e("HuaweiApi", "header is not instance of ResponseHeader");
                        return;
                    }
                    ResponseHeader responseHeader = (ResponseHeader) iMessageEntity;
                    if (responseHeader.getErrorCode() == 11) {
                        RequestHandler.this.m30659a();
                        HMSLog.m36988i("HuaweiApi", "unbind service");
                    }
                    if (!TextUtils.isEmpty(responseHeader.getResolution())) {
                        HMSLog.m36986e("HuaweiApi", "Response has resolution: " + responseHeader.getResolution());
                    }
                    if (this.f23434a.compareAndSet(true, false)) {
                        HiAnalyticsInnerClient.reportEntryExit(RequestHandler.this.f23432d.getContext(), responseHeader, String.valueOf(RequestHandler.this.f23432d.getKitSdkVersion()));
                    }
                    taskApiCallWrapper.getTaskApiCall().onResponse(RequestHandler.this.f23430b, responseHeader, str, taskApiCallWrapper.getTaskCompletionSource());
                }
            });
        }

        /* renamed from: c */
        public void m30656c() {
            HMSLog.m36988i("HuaweiApi", "wait queue size = " + this.callbackWaitQueue.size());
            HMSLog.m36988i("HuaweiApi", "run queue size = " + this.f23429a.size());
            Iterator<TaskApiCallbackWrapper> it = this.callbackWaitQueue.iterator();
            while (it.hasNext()) {
                m30650a(it.next());
            }
            Iterator<TaskApiCallbackWrapper> it2 = this.f23429a.iterator();
            while (it2.hasNext()) {
                m30650a(it2.next());
            }
            this.callbackWaitQueue.clear();
            this.f23429a.clear();
            this.f23431c = null;
            this.f23430b.disconnect();
        }

        /* renamed from: b */
        public void m30653b(ConnectionResult connectionResult) {
            this.f23431c = connectionResult;
            Iterator<TaskApiCallbackWrapper> it = this.callbackWaitQueue.iterator();
            boolean z10 = true;
            while (it.hasNext()) {
                TaskApiCallWrapper taskApiCallWrapperM30662a = it.next().m30662a();
                ResponseHeader responseHeader = new ResponseHeader(1, CommonCode.ErrorCode.CLIENT_API_INVALID, "Connection Failed:" + m30647a(connectionResult) + "(" + connectionResult.getErrorCode() + ")");
                responseHeader.setTransactionId(taskApiCallWrapperM30662a.getTaskApiCall().getTransactionId());
                HiAnalyticsInnerClient.reportEntryExit(this.f23432d.getContext(), responseHeader, String.valueOf(this.f23432d.getKitSdkVersion()));
                if (this.f23431c.getResolution() != null && z10) {
                    responseHeader.setParcelable(this.f23431c.getResolution());
                    if (Util.isAvailableLibExist(this.f23432d.getContext()) && this.f23431c.getErrorCode() == 26) {
                        responseHeader.setResolution(CommonCode.Resolution.HAS_RESOLUTION);
                    }
                    z10 = false;
                }
                int errorCode = this.f23431c.getErrorCode();
                if (errorCode == 30 || errorCode == 31) {
                    responseHeader.setErrorCode(errorCode);
                }
                taskApiCallWrapperM30662a.getTaskApiCall().onResponse(this.f23430b, responseHeader, null, taskApiCallWrapperM30662a.getTaskCompletionSource());
            }
            this.callbackWaitQueue.clear();
            this.f23429a.clear();
            this.f23431c = null;
            this.f23430b.disconnect();
        }

        /* renamed from: a */
        public void m30661a(TaskApiCallWrapper taskApiCallWrapper) {
            HMSLog.m36988i("HuaweiApi", "sendRequest");
            TaskApiCallbackWrapper taskApiCallbackWrapperM30651b = m30651b(taskApiCallWrapper);
            if (HMSPackageManager.getInstance(this.f23432d.getContext()).isUpdateHmsForThirdPartyDevice()) {
                this.f23430b.disconnect();
            }
            int hmsVersionCode = HMSPackageManager.getInstance(((HuaweiApi) this.f23432d).f23412a).getHmsVersionCode();
            if (hmsVersionCode < 40000000 && hmsVersionCode > 0 && this.f23430b.isConnected() && !((HuaweiApi) this.f23432d).f23424m && ((BaseHmsClient) this.f23430b).getAdapter().getServiceAction().equals("com.huawei.hms.core.aidlservice")) {
                int requestHmsVersionCode = this.f23430b.getRequestHmsVersionCode();
                if (requestHmsVersionCode <= taskApiCallWrapper.getTaskApiCall().getMinApkVersion()) {
                    requestHmsVersionCode = taskApiCallWrapper.getTaskApiCall().getMinApkVersion();
                }
                if (requestHmsVersionCode > hmsVersionCode) {
                    this.f23430b.disconnect();
                }
            }
            if (this.f23430b.isConnected()) {
                HMSLog.m36988i("HuaweiApi", "isConnected:true.");
                BinderAdapter adapter = ((BaseHmsClient) this.f23430b).getAdapter();
                adapter.updateDelayTask();
                ((HmsClient) this.f23430b).setService(IAIDLInvoke.Stub.asInterface(adapter.getServiceBinder()));
                postMessage(taskApiCallbackWrapperM30651b);
                return;
            }
            HMSLog.m36988i("HuaweiApi", "isConnected:false.");
            this.callbackWaitQueue.add(taskApiCallbackWrapperM30651b);
            ConnectionResult connectionResult = this.f23431c;
            if (connectionResult != null && connectionResult.getErrorCode() != 0) {
                HMSLog.m36988i("HuaweiApi", "onConnectionFailed, ErrorCode:" + this.f23431c.getErrorCode());
                onConnectionFailed(this.f23431c);
                return;
            }
            RequestManager.addRequestToQueue(this);
            Object obj = this.f23430b;
            if (obj instanceof BaseHmsClient) {
                ((BaseHmsClient) obj).setInternalRequest(this);
            }
            m30660a(taskApiCallWrapper.getTaskApiCall().getMinApkVersion(), taskApiCallbackWrapperM30651b);
        }

        /* renamed from: b */
        public void m30652b() {
            this.f23431c = null;
            this.f23429a.clear();
            Iterator<TaskApiCallbackWrapper> it = this.callbackWaitQueue.iterator();
            while (it.hasNext()) {
                postMessage(it.next());
            }
            this.callbackWaitQueue.clear();
        }

        /* renamed from: a */
        private String m30648a(String str, String str2) {
            return TextUtils.isEmpty(str) ? TransactionIdCreater.getId(this.f23432d.getAppID(), str2) : str;
        }

        /* renamed from: a */
        public synchronized void m30660a(int i10, TaskApiCallbackWrapper taskApiCallbackWrapper) {
            if (this.f23430b.isConnected()) {
                HMSLog.m36983d("HuaweiApi", "client is connected");
                return;
            }
            if (this.f23430b.isConnecting()) {
                HMSLog.m36983d("HuaweiApi", "client is isConnecting");
                return;
            }
            if (this.f23432d.getActivity() != null) {
                if (this.f23433e == null) {
                    this.f23433e = new ResolveClientBean(this.f23430b, i10);
                }
                if (BindResolveClients.getInstance().isClientRegistered(this.f23433e)) {
                    HMSLog.m36988i("HuaweiApi", "mResolveClientBean has already register, return!");
                    return;
                }
                BindResolveClients.getInstance().register(this.f23433e);
            }
            this.f23430b.connect(i10);
        }

        /* renamed from: a */
        public void m30659a() {
            this.f23430b.disconnect();
        }

        /* renamed from: a */
        private void m30650a(TaskApiCallbackWrapper taskApiCallbackWrapper) {
            TaskApiCallWrapper taskApiCallWrapperM30662a = taskApiCallbackWrapper.m30662a();
            ResponseHeader responseHeader = new ResponseHeader(1, CommonCode.ErrorCode.CLIENT_API_INVALID, "Connection Suspended");
            responseHeader.setTransactionId(taskApiCallWrapperM30662a.getTaskApiCall().getTransactionId());
            taskApiCallWrapperM30662a.getTaskApiCall().onResponse(this.f23430b, responseHeader, null, taskApiCallWrapperM30662a.getTaskCompletionSource());
        }

        /* JADX WARN: Code restructure failed: missing block: B:67:0x0051, code lost:
        
            if (r7 != 10) goto L55;
         */
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private java.lang.String m30647a(com.huawei.hms.api.ConnectionResult r8) {
            /*
                r7 = this;
                com.huawei.hms.common.HuaweiApi<OptionsT extends com.huawei.hms.api.Api$ApiOptions> r7 = r7.f23432d
                android.content.Context r7 = r7.getContext()
                boolean r7 = com.huawei.hms.utils.Util.isAvailableLibExist(r7)
                java.lang.String r0 = "get update result, but has other error codes"
                java.lang.String r1 = "internal error"
                java.lang.String r2 = "application configuration error, please developer check configuration"
                java.lang.String r3 = "unknown errorReason"
                r4 = 10
                r5 = 8
                r6 = -1
                if (r7 == 0) goto L49
                int r7 = r8.getErrorCode()
                if (r7 == r6) goto L54
                r8 = 3
                if (r7 == r8) goto L46
                if (r7 == r5) goto L44
                if (r7 == r4) goto L42
                r8 = 13
                if (r7 == r8) goto L3f
                r8 = 21
                if (r7 == r8) goto L3c
                switch(r7) {
                    case 25: goto L39;
                    case 26: goto L36;
                    case 27: goto L33;
                    default: goto L31;
                }
            L31:
                r0 = r3
                goto L54
            L33:
                java.lang.String r0 = "there is already an update popup at the front desk, but it hasn't been clicked or it is not effective for a while"
                goto L54
            L36:
                java.lang.String r0 = "update failed, because no activity incoming, can't pop update page"
                goto L54
            L39:
                java.lang.String r0 = "failed to get update result"
                goto L54
            L3c:
                java.lang.String r0 = "device is too old to be support"
                goto L54
            L3f:
                java.lang.String r0 = "update cancelled"
                goto L54
            L42:
                r0 = r2
                goto L54
            L44:
                r0 = r1
                goto L54
            L46:
                java.lang.String r0 = "HuaWei Mobile Service is disabled"
                goto L54
            L49:
                int r7 = r8.getErrorCode()
                if (r7 == r6) goto L54
                if (r7 == r5) goto L44
                if (r7 == r4) goto L42
                goto L31
            L54:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.common.HuaweiApi.RequestHandler.m30647a(com.huawei.hms.api.ConnectionResult):java.lang.String");
        }
    }

    public static class TaskApiCallbackWrapper {

        /* renamed from: a */
        private final TaskApiCallWrapper f23445a;

        /* renamed from: b */
        private final AnyClient.CallBack f23446b;

        public TaskApiCallbackWrapper(TaskApiCallWrapper taskApiCallWrapper, AnyClient.CallBack callBack) {
            this.f23445a = taskApiCallWrapper;
            this.f23446b = callBack;
        }

        /* renamed from: a */
        public TaskApiCallWrapper m30662a() {
            return this.f23445a;
        }

        /* renamed from: b */
        public AnyClient.CallBack m30663b() {
            return this.f23446b;
        }
    }

    /* renamed from: com.huawei.hms.common.HuaweiApi$a */
    public static class RunnableC5142a<OptionsT extends Api.ApiOptions> implements Runnable {

        /* renamed from: a */
        private final HuaweiApi<OptionsT> f23447a;

        /* renamed from: b */
        private final TaskApiCallWrapper f23448b;

        public RunnableC5142a(HuaweiApi<OptionsT> huaweiApi, TaskApiCallWrapper taskApiCallWrapper) {
            this.f23447a = huaweiApi;
            this.f23448b = taskApiCallWrapper;
        }

        /* JADX WARN: Removed duplicated region for block: B:62:0x0054 A[ADDED_TO_REGION] */
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private void m30664a(com.huawei.hms.common.HuaweiApi.RequestHandler r7, java.lang.Throwable r8) {
            /*
                r6 = this;
                java.lang.String r0 = "HuaweiApi"
                r1 = 0
                com.huawei.hms.common.internal.AnyClient r7 = r7.getClient()     // Catch: java.lang.Throwable -> L35
                com.huawei.hms.common.internal.ResponseHeader r2 = new com.huawei.hms.common.internal.ResponseHeader     // Catch: java.lang.Throwable -> L33
                java.lang.String r8 = r8.getMessage()     // Catch: java.lang.Throwable -> L33
                r3 = 1
                r4 = 907135001(0x3611c819, float:2.1723156E-6)
                r2.<init>(r3, r4, r8)     // Catch: java.lang.Throwable -> L33
                org.json.JSONObject r8 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L2f
                r8.<init>()     // Catch: java.lang.Throwable -> L2f
                java.lang.String r8 = r8.toString()     // Catch: java.lang.Throwable -> L2f
                com.huawei.hms.common.internal.TaskApiCallWrapper r3 = r6.f23448b     // Catch: java.lang.Throwable -> L2c
                cq.i r3 = r3.getTaskCompletionSource()     // Catch: java.lang.Throwable -> L2c
                com.huawei.hms.common.internal.TaskApiCallWrapper r6 = r6.f23448b     // Catch: java.lang.Throwable -> L2a
                com.huawei.hms.common.internal.TaskApiCall r1 = r6.getTaskApiCall()     // Catch: java.lang.Throwable -> L2a
                goto L52
            L2a:
                r6 = move-exception
                goto L3a
            L2c:
                r6 = move-exception
                r3 = r1
                goto L3a
            L2f:
                r6 = move-exception
                r8 = r1
                r3 = r8
                goto L3a
            L33:
                r6 = move-exception
                goto L37
            L35:
                r6 = move-exception
                r7 = r1
            L37:
                r8 = r1
                r2 = r8
                r3 = r2
            L3a:
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                java.lang.String r5 = "<notifyCpException> "
                r4.append(r5)
                java.lang.String r6 = r6.getMessage()
                r4.append(r6)
                java.lang.String r6 = r4.toString()
                com.huawei.hms.support.log.HMSLog.m36986e(r0, r6)
            L52:
                if (r7 == 0) goto L60
                if (r2 == 0) goto L60
                if (r8 == 0) goto L60
                if (r3 == 0) goto L60
                if (r1 == 0) goto L60
                r1.onResponse(r7, r2, r8, r3)
                goto L65
            L60:
                java.lang.String r6 = "<notifyCpException> isNotify is false, Can not notify CP."
                com.huawei.hms.support.log.HMSLog.m36986e(r0, r6)
            L65:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.common.HuaweiApi.RunnableC5142a.m30664a(com.huawei.hms.common.HuaweiApi$RequestHandler, java.lang.Throwable):void");
        }

        @Override // java.lang.Runnable
        public void run() {
            RequestHandler requestHandler = new RequestHandler(this.f23447a);
            try {
                requestHandler.m30661a(this.f23448b);
            } catch (Throwable th2) {
                HMSLog.m36987e("HuaweiApi", "sendRequest has exception", th2);
                m30664a(requestHandler, th2);
            }
        }
    }

    public HuaweiApi(Activity activity, Api<TOption> api, TOption toption, AbstractClientBuilder abstractClientBuilder, int i10) {
        Checker.checkNonNull(activity, "Null activity is not permitted.");
        this.f23419h = new WeakReference<>(activity);
        m30639a(activity, api, toption, abstractClientBuilder, i10, null);
    }

    @Deprecated
    public Task<Boolean> disconnectService() {
        C8941i c8941i = new C8941i();
        RequestManager.getInstance();
        RequestManager.getHandler().post(new Runnable() { // from class: com.huawei.hms.common.HuaweiApi.1

            /* renamed from: a */
            final /* synthetic */ HuaweiApi f23426a;

            /* renamed from: b */
            final /* synthetic */ C8941i f23427b;

            public RunnableC51361(HuaweiApi this, C8941i c8941i2) {
                huaweiApi = this;
                c8941i = c8941i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                HuaweiApi.this.m30642a((HuaweiApi<?>) huaweiApi, (C8941i<Boolean>) c8941i);
            }
        });
        return c8941i2.m56656b();
    }

    public <TResult, TClient extends AnyClient> Task<TResult> doWrite(TaskApiCall<TClient, TResult> taskApiCall) {
        this.f23422k = true;
        if (taskApiCall == null) {
            HMSLog.m36986e("HuaweiApi", "in doWrite:taskApiCall is null");
            C8941i c8941i = new C8941i();
            c8941i.m56657c(new ApiException(Status.FAILURE));
            return c8941i.m56656b();
        }
        HiAnalyticsInnerClient.reportEntryClient(this.f23412a, taskApiCall.getUri(), TextUtils.isEmpty(this.f23418g.getSubAppID()) ? this.f23417f : this.f23418g.getSubAppID(), taskApiCall.getTransactionId(), String.valueOf(getKitSdkVersion()));
        if (this.f23425n == null) {
            this.f23425n = RequestManager.getInstance();
        }
        return m30637a(taskApiCall);
    }

    public Activity getActivity() {
        WeakReference<Activity> weakReference = this.f23419h;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public int getApiLevel() {
        return this.f23421j;
    }

    public String getAppID() {
        return this.f23417f;
    }

    public AnyClient getClient(Looper looper, RequestHandler requestHandler) {
        return this.f23415d.buildClient(this.f23412a, getClientSetting(), requestHandler, requestHandler);
    }

    public ClientSettings getClientSetting() {
        ClientSettings clientSettings = new ClientSettings(this.f23412a.getPackageName(), this.f23412a.getClass().getName(), getScopes(), this.f23416e, null, this.f23418g);
        if (!this.f23424m) {
            String hMSPackageNameForMultiService = HMSPackageManager.getInstance(this.f23412a).getHMSPackageNameForMultiService();
            if (TextUtils.isEmpty(hMSPackageNameForMultiService)) {
                hMSPackageNameForMultiService = "com.huawei.hwid";
            }
            this.f23423l = hMSPackageNameForMultiService;
            HMSLog.m36988i("HuaweiApi", "No setInnerHms, hms pkg name is " + this.f23423l);
        }
        clientSettings.setInnerHmsPkg(this.f23423l);
        clientSettings.setUseInnerHms(this.f23424m);
        WeakReference<Activity> weakReference = this.f23419h;
        if (weakReference != null) {
            clientSettings.setCpActivity(weakReference.get());
        }
        return clientSettings;
    }

    public Context getContext() {
        return this.f23412a;
    }

    public int getKitSdkVersion() {
        return this.f23420i;
    }

    public TOption getOption() {
        return this.f23413b;
    }

    public List<Scope> getScopes() {
        return Collections.emptyList();
    }

    public String getSubAppID() {
        return this.f23418g.getSubAppID();
    }

    public void setApiLevel(int i10) {
        this.f23421j = i10;
    }

    public void setHostContext(Context context) {
        this.f23414c = context;
    }

    public void setInnerHms() {
        this.f23423l = this.f23412a.getPackageName();
        this.f23424m = true;
        HMSLog.m36988i("HuaweiApi", "<setInnerHms> init inner hms pkg info:" + this.f23423l);
    }

    public void setKitSdkVersion(int i10) {
        this.f23420i = i10;
    }

    public void setSubAppId(String str) throws ApiException {
        if (!setSubAppInfo(new SubAppInfo(str))) {
            throw new ApiException(Status.FAILURE);
        }
    }

    @Deprecated
    public boolean setSubAppInfo(SubAppInfo subAppInfo) {
        HMSLog.m36988i("HuaweiApi", "Enter setSubAppInfo");
        SubAppInfo subAppInfo2 = this.f23418g;
        if (subAppInfo2 != null && !TextUtils.isEmpty(subAppInfo2.getSubAppID())) {
            HMSLog.m36986e("HuaweiApi", "subAppInfo is already set");
            return false;
        }
        if (subAppInfo == null) {
            HMSLog.m36986e("HuaweiApi", "subAppInfo is null");
            return false;
        }
        String subAppID = subAppInfo.getSubAppID();
        if (TextUtils.isEmpty(subAppID)) {
            HMSLog.m36986e("HuaweiApi", "subAppId is empty");
            return false;
        }
        if (subAppID.equals(this.f23416e)) {
            HMSLog.m36986e("HuaweiApi", "subAppId is host appid");
            return false;
        }
        if (this.f23422k) {
            HMSLog.m36986e("HuaweiApi", "Client has sent request to Huawei Mobile Services, setting subAppId is not allowed");
            return false;
        }
        this.f23418g = new SubAppInfo(subAppInfo);
        return true;
    }

    /* renamed from: b */
    public void m30643b(Context context) {
        String appId = Util.getAppId(context);
        this.f23416e = appId;
        this.f23417f = appId;
    }

    /* renamed from: a */
    private void m30639a(Context context, Api<TOption> api, TOption toption, AbstractClientBuilder abstractClientBuilder, int i10, String str) {
        this.f23412a = context.getApplicationContext();
        this.f23413b = toption;
        this.f23415d = abstractClientBuilder;
        m30643b(context);
        this.f23418g = new SubAppInfo("");
        this.f23420i = i10;
        if (!TextUtils.isEmpty(str)) {
            if (str.equals(this.f23416e)) {
                HMSLog.m36986e("HuaweiApi", "subAppId is host appid");
            } else {
                HMSLog.m36988i("HuaweiApi", "subAppId is " + str);
                this.f23418g = new SubAppInfo(str);
            }
        }
        m30638a(context);
        if (Util.isAvailableLibExist(context)) {
            AvailableUtil.asyncCheckHmsUpdateInfo(context);
        }
    }

    public HuaweiApi(Activity activity, Api<TOption> api, TOption toption, AbstractClientBuilder abstractClientBuilder, int i10, String str) {
        Checker.checkNonNull(activity, "Null activity is not permitted.");
        this.f23419h = new WeakReference<>(activity);
        m30639a(activity, api, toption, abstractClientBuilder, i10, str);
    }

    public HuaweiApi(Activity activity, Api<TOption> api, TOption toption, AbstractClientBuilder abstractClientBuilder) {
        Checker.checkNonNull(activity, "Null activity is not permitted.");
        this.f23419h = new WeakReference<>(activity);
        m30639a(activity, api, toption, abstractClientBuilder, 0, null);
    }

    /* renamed from: a */
    private void m30638a(Context context) {
        HMSBIInitializer.getInstance(context).initBI();
    }

    public HuaweiApi(Context context, Api<TOption> api, TOption toption, AbstractClientBuilder abstractClientBuilder, int i10) {
        Checker.checkNonNull(context, "Null context is not permitted.");
        m30639a(context, api, toption, abstractClientBuilder, i10, null);
    }

    /* renamed from: a */
    public void m30642a(HuaweiApi<?> huaweiApi, C8941i<Boolean> c8941i) {
        HMSLog.m36988i("HuaweiApi", "innerDisconnect.");
        try {
            huaweiApi.getClient(RequestManager.getHandler().getLooper(), null).disconnect();
            c8941i.m56658d(Boolean.TRUE);
        } catch (Exception e10) {
            HMSLog.m36989w("HuaweiApi", "disconnect the binder failed for:" + e10.getMessage());
        }
    }

    public HuaweiApi(Context context, Api<TOption> api, TOption toption, AbstractClientBuilder abstractClientBuilder, int i10, String str) {
        Checker.checkNonNull(context, "Null context is not permitted.");
        m30639a(context, api, toption, abstractClientBuilder, i10, str);
    }

    /* renamed from: a */
    private <TResult, TClient extends AnyClient> Task<TResult> m30637a(TaskApiCall<TClient, TResult> taskApiCall) {
        C8941i c8941i;
        if (taskApiCall.getToken() == null) {
            c8941i = new C8941i();
        } else {
            c8941i = new C8941i(taskApiCall.getToken());
        }
        RequestManager.getHandler().post(new RunnableC5142a(this, new TaskApiCallWrapper(taskApiCall, c8941i)));
        return c8941i.m56656b();
    }

    public HuaweiApi(Context context, Api<TOption> api, TOption toption, AbstractClientBuilder abstractClientBuilder) {
        Checker.checkNonNull(context, "Null context is not permitted.");
        m30639a(context, api, toption, abstractClientBuilder, 0, null);
    }
}
