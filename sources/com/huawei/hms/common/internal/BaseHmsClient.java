package com.huawei.hms.common.internal;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import com.huawei.hms.adapter.AvailableAdapter;
import com.huawei.hms.adapter.BinderAdapter;
import com.huawei.hms.adapter.InnerBinderAdapter;
import com.huawei.hms.adapter.OuterBinderAdapter;
import com.huawei.hms.api.ConnectionResult;
import com.huawei.hms.api.FailedBinderCallBack;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.api.IPCTransport;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.core.aidl.IAIDLInvoke;
import com.huawei.hms.support.api.client.AidlApiClient;
import com.huawei.hms.support.api.client.SubAppInfo;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.PackageManagerHelper;
import com.huawei.hms.utils.Util;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import java.sql.Timestamp;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes8.dex */
public abstract class BaseHmsClient implements AidlApiClient {
    protected static final int TIMEOUT_DISCONNECTED = 6;

    /* renamed from: i */
    private static final Object f23459i = new Object();

    /* renamed from: j */
    private static final AtomicInteger f23460j = new AtomicInteger(1);

    /* renamed from: k */
    private static final AtomicInteger f23461k = new AtomicInteger(1);

    /* renamed from: l */
    private static BinderAdapter f23462l;

    /* renamed from: m */
    private static BinderAdapter f23463m;

    /* renamed from: a */
    private final Context f23464a;

    /* renamed from: b */
    private String f23465b;

    /* renamed from: c */
    private final ClientSettings f23466c;

    /* renamed from: d */
    private volatile IAIDLInvoke f23467d;

    /* renamed from: e */
    private final ConnectionCallbacks f23468e;

    /* renamed from: f */
    private final OnConnectionFailedListener f23469f;

    /* renamed from: g */
    private Handler f23470g = null;

    /* renamed from: h */
    private HuaweiApi.RequestHandler f23471h;
    protected String sessionId;

    /* renamed from: com.huawei.hms.common.internal.BaseHmsClient$1 */
    public class C51451 implements BinderAdapter.BinderCallBack {

        /* renamed from: com.huawei.hms.common.internal.BaseHmsClient$1$1 */
        public class AnonymousClass1 implements FailedBinderCallBack.BinderCallBack {
            public AnonymousClass1() {
            }

            @Override // com.huawei.hms.api.FailedBinderCallBack.BinderCallBack
            public void binderCallBack(int i10) {
                if (i10 != 0) {
                    BaseHmsClient.this.m30674a(new ConnectionResult(10, (PendingIntent) null));
                    BaseHmsClient.this.f23467d = null;
                }
            }
        }

        public C51451() {
        }

        @Override // com.huawei.hms.adapter.BinderAdapter.BinderCallBack
        public void onBinderFailed(int i10) {
            onBinderFailed(i10, null);
        }

        @Override // com.huawei.hms.adapter.BinderAdapter.BinderCallBack
        public void onNullBinding(ComponentName componentName) {
            BaseHmsClient.this.m30687b(1);
            BaseHmsClient.this.m30671a(10);
        }

        @Override // com.huawei.hms.adapter.BinderAdapter.BinderCallBack
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            HMSLog.m36988i("BaseHmsClient", "Enter onServiceConnected.");
            BaseHmsClient.this.connectedInternal(iBinder);
        }

        @Override // com.huawei.hms.adapter.BinderAdapter.BinderCallBack
        public void onServiceDisconnected(ComponentName componentName) {
            HMSLog.m36988i("BaseHmsClient", "Enter onServiceDisconnected.");
            BaseHmsClient.this.m30687b(1);
            RequestManager.getHandler().sendEmptyMessage(RequestManager.NOTIFY_CONNECT_SUSPENDED);
            if (BaseHmsClient.this.f23468e == null || (BaseHmsClient.this.f23468e instanceof HuaweiApi.RequestHandler)) {
                return;
            }
            BaseHmsClient.this.f23468e.onConnectionSuspended(1);
        }

        @Override // com.huawei.hms.adapter.BinderAdapter.BinderCallBack
        public void onTimedDisconnected() {
            BaseHmsClient.this.m30687b(6);
            if (BaseHmsClient.this.f23468e == null || (BaseHmsClient.this.f23468e instanceof HuaweiApi.RequestHandler)) {
                return;
            }
            BaseHmsClient.this.f23468e.onConnectionSuspended(1);
        }

        @Override // com.huawei.hms.adapter.BinderAdapter.BinderCallBack
        public void onBinderFailed(int i10, Intent intent) {
            if (intent == null) {
                HMSLog.m36988i("BaseHmsClient", "onBinderFailed: intent is null!");
                BaseHmsClient.this.m30674a(new ConnectionResult(10, (PendingIntent) null));
                BaseHmsClient.this.f23467d = null;
                return;
            }
            Activity activeActivity = Util.getActiveActivity(BaseHmsClient.this.getClientSettings().getCpActivity(), BaseHmsClient.this.getContext());
            if (activeActivity == null) {
                HMSLog.m36988i("BaseHmsClient", "onBinderFailed: return pendingIntent to kit and cp");
                BaseHmsClient.this.m30674a(new ConnectionResult(10, PendingIntent.getActivity(BaseHmsClient.this.f23464a, 11, intent, HwRecyclerView.ITEM_TYPE_NO_SCALE_CARD_MASK)));
                BaseHmsClient.this.f23467d = null;
                return;
            }
            HMSLog.m36988i("BaseHmsClient", "onBinderFailed: SDK try to resolve and reConnect!");
            long time = new Timestamp(System.currentTimeMillis()).getTime();
            FailedBinderCallBack.getInstance().setCallBack(Long.valueOf(time), new FailedBinderCallBack.BinderCallBack() { // from class: com.huawei.hms.common.internal.BaseHmsClient.1.1
                public AnonymousClass1() {
                }

                @Override // com.huawei.hms.api.FailedBinderCallBack.BinderCallBack
                public void binderCallBack(int i102) {
                    if (i102 != 0) {
                        BaseHmsClient.this.m30674a(new ConnectionResult(10, (PendingIntent) null));
                        BaseHmsClient.this.f23467d = null;
                    }
                }
            });
            intent.putExtra(FailedBinderCallBack.CALLER_ID, time);
            activeActivity.startActivity(intent);
        }
    }

    /* renamed from: com.huawei.hms.common.internal.BaseHmsClient$2 */
    public class C51462 implements AvailableAdapter.AvailableCallBack {
        public C51462() {
        }

        @Override // com.huawei.hms.adapter.AvailableAdapter.AvailableCallBack
        public void onComplete(int i10) {
            BaseHmsClient.this.m30671a(i10);
        }
    }

    /* renamed from: com.huawei.hms.common.internal.BaseHmsClient$3 */
    public class C51473 implements AvailableAdapter.AvailableCallBack {
        public C51473() {
        }

        @Override // com.huawei.hms.adapter.AvailableAdapter.AvailableCallBack
        public void onComplete(int i10) {
            if (i10 == 0 && BaseHmsClient.this.m30681c()) {
                BaseHmsClient.this.m30686a();
            } else {
                BaseHmsClient.this.m30671a(i10);
            }
        }
    }

    public interface ConnectionCallbacks {
        public static final int CAUSE_API_CLIENT_EXPIRED = 3;
        public static final int CAUSE_NETWORK_LOST = 2;
        public static final int CAUSE_SERVICE_DISCONNECTED = 1;

        void onConnected();

        void onConnectionSuspended(int i10);
    }

    public static final class ConnectionResultWrapper {

        /* renamed from: a */
        private HuaweiApi.RequestHandler f23476a;

        /* renamed from: b */
        private ConnectionResult f23477b;

        public ConnectionResultWrapper(HuaweiApi.RequestHandler requestHandler, ConnectionResult connectionResult) {
            this.f23476a = requestHandler;
            this.f23477b = connectionResult;
        }

        public ConnectionResult getConnectionResult() {
            return this.f23477b;
        }

        public HuaweiApi.RequestHandler getRequest() {
            return this.f23476a;
        }
    }

    public interface OnConnectionFailedListener {
        void onConnectionFailed(ConnectionResult connectionResult);
    }

    public BaseHmsClient(Context context, ClientSettings clientSettings, OnConnectionFailedListener onConnectionFailedListener, ConnectionCallbacks connectionCallbacks) {
        this.f23464a = context;
        this.f23466c = clientSettings;
        if (clientSettings != null) {
            this.f23465b = clientSettings.getAppID();
        }
        this.f23469f = onConnectionFailedListener;
        this.f23468e = connectionCallbacks;
    }

    /* renamed from: d */
    private BinderAdapter.BinderCallBack m30683d() {
        return new BinderAdapter.BinderCallBack() { // from class: com.huawei.hms.common.internal.BaseHmsClient.1

            /* renamed from: com.huawei.hms.common.internal.BaseHmsClient$1$1 */
            public class AnonymousClass1 implements FailedBinderCallBack.BinderCallBack {
                public AnonymousClass1() {
                }

                @Override // com.huawei.hms.api.FailedBinderCallBack.BinderCallBack
                public void binderCallBack(int i102) {
                    if (i102 != 0) {
                        BaseHmsClient.this.m30674a(new ConnectionResult(10, (PendingIntent) null));
                        BaseHmsClient.this.f23467d = null;
                    }
                }
            }

            public C51451() {
            }

            @Override // com.huawei.hms.adapter.BinderAdapter.BinderCallBack
            public void onBinderFailed(int i10) {
                onBinderFailed(i10, null);
            }

            @Override // com.huawei.hms.adapter.BinderAdapter.BinderCallBack
            public void onNullBinding(ComponentName componentName) {
                BaseHmsClient.this.m30687b(1);
                BaseHmsClient.this.m30671a(10);
            }

            @Override // com.huawei.hms.adapter.BinderAdapter.BinderCallBack
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                HMSLog.m36988i("BaseHmsClient", "Enter onServiceConnected.");
                BaseHmsClient.this.connectedInternal(iBinder);
            }

            @Override // com.huawei.hms.adapter.BinderAdapter.BinderCallBack
            public void onServiceDisconnected(ComponentName componentName) {
                HMSLog.m36988i("BaseHmsClient", "Enter onServiceDisconnected.");
                BaseHmsClient.this.m30687b(1);
                RequestManager.getHandler().sendEmptyMessage(RequestManager.NOTIFY_CONNECT_SUSPENDED);
                if (BaseHmsClient.this.f23468e == null || (BaseHmsClient.this.f23468e instanceof HuaweiApi.RequestHandler)) {
                    return;
                }
                BaseHmsClient.this.f23468e.onConnectionSuspended(1);
            }

            @Override // com.huawei.hms.adapter.BinderAdapter.BinderCallBack
            public void onTimedDisconnected() {
                BaseHmsClient.this.m30687b(6);
                if (BaseHmsClient.this.f23468e == null || (BaseHmsClient.this.f23468e instanceof HuaweiApi.RequestHandler)) {
                    return;
                }
                BaseHmsClient.this.f23468e.onConnectionSuspended(1);
            }

            @Override // com.huawei.hms.adapter.BinderAdapter.BinderCallBack
            public void onBinderFailed(int i10, Intent intent) {
                if (intent == null) {
                    HMSLog.m36988i("BaseHmsClient", "onBinderFailed: intent is null!");
                    BaseHmsClient.this.m30674a(new ConnectionResult(10, (PendingIntent) null));
                    BaseHmsClient.this.f23467d = null;
                    return;
                }
                Activity activeActivity = Util.getActiveActivity(BaseHmsClient.this.getClientSettings().getCpActivity(), BaseHmsClient.this.getContext());
                if (activeActivity == null) {
                    HMSLog.m36988i("BaseHmsClient", "onBinderFailed: return pendingIntent to kit and cp");
                    BaseHmsClient.this.m30674a(new ConnectionResult(10, PendingIntent.getActivity(BaseHmsClient.this.f23464a, 11, intent, HwRecyclerView.ITEM_TYPE_NO_SCALE_CARD_MASK)));
                    BaseHmsClient.this.f23467d = null;
                    return;
                }
                HMSLog.m36988i("BaseHmsClient", "onBinderFailed: SDK try to resolve and reConnect!");
                long time = new Timestamp(System.currentTimeMillis()).getTime();
                FailedBinderCallBack.getInstance().setCallBack(Long.valueOf(time), new FailedBinderCallBack.BinderCallBack() { // from class: com.huawei.hms.common.internal.BaseHmsClient.1.1
                    public AnonymousClass1() {
                    }

                    @Override // com.huawei.hms.api.FailedBinderCallBack.BinderCallBack
                    public void binderCallBack(int i102) {
                        if (i102 != 0) {
                            BaseHmsClient.this.m30674a(new ConnectionResult(10, (PendingIntent) null));
                            BaseHmsClient.this.f23467d = null;
                        }
                    }
                });
                intent.putExtra(FailedBinderCallBack.CALLER_ID, time);
                activeActivity.startActivity(intent);
            }
        };
    }

    /* renamed from: e */
    private void m30684e() {
        HMSLog.m36989w("BaseHmsClient", "Failed to get service as interface, trying to unbind.");
        if (this.f23466c.isUseInnerHms()) {
            BinderAdapter binderAdapter = f23463m;
            if (binderAdapter == null) {
                HMSLog.m36989w("BaseHmsClient", "mInnerBinderAdapter is null.");
                return;
            }
            binderAdapter.unBind();
        } else {
            BinderAdapter binderAdapter2 = f23462l;
            if (binderAdapter2 == null) {
                HMSLog.m36989w("BaseHmsClient", "mOuterBinderAdapter is null.");
                return;
            }
            binderAdapter2.unBind();
        }
        m30687b(1);
        m30671a(10);
    }

    /* renamed from: f */
    private void m30685f() {
        if (this.f23466c.isUseInnerHms()) {
            BinderAdapter binderAdapter = f23463m;
            if (binderAdapter != null) {
                binderAdapter.unBind();
                return;
            }
            return;
        }
        BinderAdapter binderAdapter2 = f23462l;
        if (binderAdapter2 != null) {
            binderAdapter2.unBind();
        }
    }

    public final void checkConnected() {
        if (!isConnected()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    public void connect(int i10) {
        m30672a(i10, false);
    }

    public void connectedInternal(IBinder iBinder) {
        this.f23467d = IAIDLInvoke.Stub.asInterface(iBinder);
        if (this.f23467d != null) {
            onConnecting();
        } else {
            HMSLog.m36986e("BaseHmsClient", "mService is null, try to unBind.");
            m30684e();
        }
    }

    public final void connectionConnected() {
        m30687b(3);
        RequestManager.getHandler().sendEmptyMessage(RequestManager.NOTIFY_CONNECT_SUCCESS);
        ConnectionCallbacks connectionCallbacks = this.f23468e;
        if (connectionCallbacks == null || (connectionCallbacks instanceof HuaweiApi.RequestHandler)) {
            return;
        }
        connectionCallbacks.onConnected();
    }

    public void disconnect() {
        int i10 = (this.f23466c.isUseInnerHms() ? f23461k : f23460j).get();
        HMSLog.m36988i("BaseHmsClient", "Enter disconnect, Connection Status: " + i10);
        if (i10 == 3) {
            m30685f();
            m30687b(1);
        } else {
            if (i10 != 5) {
                return;
            }
            m30679b();
            m30687b(1);
        }
    }

    public BinderAdapter getAdapter() {
        HMSLog.m36988i("BaseHmsClient", "getAdapter:isInner:" + this.f23466c.isUseInnerHms() + ", mInnerBinderAdapter:" + f23463m + ", mOuterBinderAdapter:" + f23462l);
        return this.f23466c.isUseInnerHms() ? f23463m : f23462l;
    }

    @Override // com.huawei.hms.support.api.client.AidlApiClient
    public List<String> getApiNameList() {
        return this.f23466c.getApiName();
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public String getAppID() {
        return this.f23465b;
    }

    public ClientSettings getClientSettings() {
        return this.f23466c;
    }

    public int getConnectionStatus() {
        return (this.f23466c.isUseInnerHms() ? f23461k : f23460j).get();
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public Context getContext() {
        return this.f23464a;
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public String getCpID() {
        return this.f23466c.getCpID();
    }

    @Deprecated
    public int getMinApkVersion() {
        return 30000000;
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public String getPackageName() {
        return this.f23466c.getClientPackageName();
    }

    public int getRequestHmsVersionCode() {
        return getMinApkVersion();
    }

    @Override // com.huawei.hms.support.api.client.AidlApiClient
    public IAIDLInvoke getService() {
        return this.f23467d;
    }

    public String getServiceAction() {
        HMSPackageManager hMSPackageManager = HMSPackageManager.getInstance(this.f23464a);
        return this.f23466c.isUseInnerHms() ? hMSPackageManager.getInnerServiceAction() : hMSPackageManager.getServiceAction();
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public String getSessionId() {
        return this.sessionId;
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public SubAppInfo getSubAppInfo() {
        return this.f23466c.getSubAppID();
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public String getTransportName() {
        return IPCTransport.class.getName();
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public boolean isConnected() {
        return !this.f23466c.isUseInnerHms() ? f23460j.get() != 3 : f23461k.get() != 3;
    }

    public boolean isConnecting() {
        return (this.f23466c.isUseInnerHms() ? f23461k : f23460j).get() == 5;
    }

    public void onConnecting() {
        connectionConnected();
    }

    public final void setInternalRequest(HuaweiApi.RequestHandler requestHandler) {
        this.f23471h = requestHandler;
    }

    public void setService(IAIDLInvoke iAIDLInvoke) {
        this.f23467d = iAIDLInvoke;
    }

    /* renamed from: c */
    public boolean m30681c() {
        return HMSPackageManager.getInstance(this.f23464a).getHMSPackageStatesForMultiService() == PackageManagerHelper.PackageStates.ENABLED;
    }

    /* renamed from: b */
    public void m30687b(int i10) {
        if (this.f23466c.isUseInnerHms()) {
            f23461k.set(i10);
        } else {
            f23460j.set(i10);
        }
    }

    public void connect(int i10, boolean z10) {
        m30672a(i10, z10);
    }

    /* renamed from: b */
    private void m30679b() {
        synchronized (f23459i) {
            try {
                Handler handler = this.f23470g;
                if (handler != null) {
                    handler.removeMessages(2);
                    this.f23470g = null;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: a */
    public void m30686a() {
        String innerHmsPkg = this.f23466c.getInnerHmsPkg();
        String serviceAction = getServiceAction();
        HMSLog.m36988i("BaseHmsClient", "enter bindCoreService, packageName is " + innerHmsPkg + ", serviceAction is " + serviceAction);
        m30677a(innerHmsPkg, serviceAction);
    }

    /* renamed from: a */
    private void m30677a(String str, String str2) {
        if (this.f23466c.isUseInnerHms()) {
            f23463m = InnerBinderAdapter.getInstance(this.f23464a, str2, str);
            if (isConnected()) {
                HMSLog.m36988i("BaseHmsClient", "The binder is already connected.");
                getAdapter().updateDelayTask();
                connectedInternal(getAdapter().getServiceBinder());
                return;
            } else {
                m30687b(5);
                f23463m.binder(m30683d());
                return;
            }
        }
        f23462l = OuterBinderAdapter.getInstance(this.f23464a, str2, str);
        if (isConnected()) {
            HMSLog.m36988i("BaseHmsClient", "The binder is already connected.");
            getAdapter().updateDelayTask();
            connectedInternal(getAdapter().getServiceBinder());
        } else {
            m30687b(5);
            f23462l.binder(m30683d());
        }
    }

    /* renamed from: b */
    private void m30680b(AvailableAdapter availableAdapter, int i10) {
        HMSLog.m36988i("BaseHmsClient", "enter HmsCore resolution");
        if (!getClientSettings().isHasActivity()) {
            m30674a(new ConnectionResult(26, HuaweiApiAvailability.getInstance().getErrPendingIntent(this.f23464a, i10, 0)));
            return;
        }
        Activity activeActivity = Util.getActiveActivity(getClientSettings().getCpActivity(), getContext());
        if (activeActivity != null) {
            availableAdapter.startResolution(activeActivity, new AvailableAdapter.AvailableCallBack() { // from class: com.huawei.hms.common.internal.BaseHmsClient.3
                public C51473() {
                }

                @Override // com.huawei.hms.adapter.AvailableAdapter.AvailableCallBack
                public void onComplete(int i102) {
                    if (i102 == 0 && BaseHmsClient.this.m30681c()) {
                        BaseHmsClient.this.m30686a();
                    } else {
                        BaseHmsClient.this.m30671a(i102);
                    }
                }
            });
        } else {
            m30671a(26);
        }
    }

    /* renamed from: a */
    private void m30672a(int i10, boolean z10) {
        HMSLog.m36988i("BaseHmsClient", "====== HMSSDK version: 61300303 ======");
        int i11 = (this.f23466c.isUseInnerHms() ? f23461k : f23460j).get();
        HMSLog.m36988i("BaseHmsClient", "Enter connect, Connection Status: " + i11);
        if (z10 || !(i11 == 3 || i11 == 5)) {
            if (getMinApkVersion() > i10) {
                i10 = getMinApkVersion();
            }
            HMSLog.m36988i("BaseHmsClient", "connect minVersion:" + i10 + " packageName:" + this.f23466c.getInnerHmsPkg());
            if (this.f23464a.getPackageName().equals(this.f23466c.getInnerHmsPkg())) {
                HMSLog.m36988i("BaseHmsClient", "service packageName is same, bind core service return");
                m30686a();
                return;
            }
            if (Util.isAvailableLibExist(this.f23464a)) {
                AvailableAdapter availableAdapter = new AvailableAdapter(i10);
                int iIsHuaweiMobileServicesAvailable = availableAdapter.isHuaweiMobileServicesAvailable(this.f23464a);
                HMSLog.m36988i("BaseHmsClient", "check available result: " + iIsHuaweiMobileServicesAvailable);
                if (iIsHuaweiMobileServicesAvailable == 0) {
                    m30686a();
                    return;
                }
                if (availableAdapter.isUserResolvableError(iIsHuaweiMobileServicesAvailable)) {
                    HMSLog.m36988i("BaseHmsClient", "bindCoreService3.0 fail, start resolution now.");
                    m30680b(availableAdapter, iIsHuaweiMobileServicesAvailable);
                    return;
                } else {
                    if (availableAdapter.isUserNoticeError(iIsHuaweiMobileServicesAvailable)) {
                        HMSLog.m36988i("BaseHmsClient", "bindCoreService3.0 fail, start notice now.");
                        m30673a(availableAdapter, iIsHuaweiMobileServicesAvailable);
                        return;
                    }
                    HMSLog.m36988i("BaseHmsClient", "bindCoreService3.0 fail: " + iIsHuaweiMobileServicesAvailable + " is not resolvable.");
                    m30671a(iIsHuaweiMobileServicesAvailable);
                    return;
                }
            }
            int iIsHuaweiMobileServicesAvailable2 = HuaweiApiAvailability.getInstance().isHuaweiMobileServicesAvailable(this.f23464a, i10);
            HMSLog.m36988i("BaseHmsClient", "HuaweiApiAvailability check available result: " + iIsHuaweiMobileServicesAvailable2);
            if (iIsHuaweiMobileServicesAvailable2 == 0) {
                m30686a();
            } else {
                m30671a(iIsHuaweiMobileServicesAvailable2);
            }
        }
    }

    /* renamed from: a */
    private void m30673a(AvailableAdapter availableAdapter, int i10) {
        HMSLog.m36988i("BaseHmsClient", "enter notice");
        if (!getClientSettings().isHasActivity()) {
            if (i10 == 29) {
                i10 = 9;
            }
            m30674a(new ConnectionResult(26, HuaweiApiAvailability.getInstance().getErrPendingIntent(this.f23464a, i10, 0)));
        } else {
            Activity activeActivity = Util.getActiveActivity(getClientSettings().getCpActivity(), getContext());
            if (activeActivity != null) {
                availableAdapter.startNotice(activeActivity, new AvailableAdapter.AvailableCallBack() { // from class: com.huawei.hms.common.internal.BaseHmsClient.2
                    public C51462() {
                    }

                    @Override // com.huawei.hms.adapter.AvailableAdapter.AvailableCallBack
                    public void onComplete(int i102) {
                        BaseHmsClient.this.m30671a(i102);
                    }
                });
            } else {
                m30671a(26);
            }
        }
    }

    /* renamed from: a */
    public void m30671a(int i10) {
        HMSLog.m36988i("BaseHmsClient", "notifyFailed result: " + i10);
        Message message = new Message();
        message.what = RequestManager.NOTIFY_CONNECT_FAILED;
        message.obj = new ConnectionResultWrapper(this.f23471h, new ConnectionResult(i10));
        RequestManager.getHandler().sendMessage(message);
        OnConnectionFailedListener onConnectionFailedListener = this.f23469f;
        if (onConnectionFailedListener == null || (onConnectionFailedListener instanceof HuaweiApi.RequestHandler)) {
            return;
        }
        onConnectionFailedListener.onConnectionFailed(new ConnectionResult(i10));
    }

    /* renamed from: a */
    public void m30674a(ConnectionResult connectionResult) {
        HMSLog.m36988i("BaseHmsClient", "notifyFailed result: " + connectionResult.getErrorCode());
        Message message = new Message();
        message.what = RequestManager.NOTIFY_CONNECT_FAILED;
        HuaweiApi.RequestHandler requestHandler = this.f23471h;
        this.f23471h = null;
        message.obj = new ConnectionResultWrapper(requestHandler, connectionResult);
        RequestManager.getHandler().sendMessage(message);
        OnConnectionFailedListener onConnectionFailedListener = this.f23469f;
        if (onConnectionFailedListener == null || (onConnectionFailedListener instanceof HuaweiApi.RequestHandler)) {
            return;
        }
        onConnectionFailedListener.onConnectionFailed(connectionResult);
    }
}
