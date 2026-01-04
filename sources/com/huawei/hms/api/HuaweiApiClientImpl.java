package com.huawei.hms.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import com.huawei.android.remotecontrol.tag.p092ui.view.RippleView;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.HuaweiApiClient;
import com.huawei.hms.common.api.ConnectionPostProcessor;
import com.huawei.hms.common.internal.AutoLifecycleFragment;
import com.huawei.hms.core.aidl.CodecLookup;
import com.huawei.hms.core.aidl.DataBuffer;
import com.huawei.hms.core.aidl.IAIDLCallback;
import com.huawei.hms.core.aidl.IAIDLInvoke;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.MessageCodec;
import com.huawei.hms.core.aidl.RequestHeader;
import com.huawei.hms.core.aidl.ResponseHeader;
import com.huawei.hms.support.api.PendingResultImpl;
import com.huawei.hms.support.api.ResolveResult;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.client.BundleResult;
import com.huawei.hms.support.api.client.InnerApiClient;
import com.huawei.hms.support.api.client.PendingResult;
import com.huawei.hms.support.api.client.ResultCallback;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.client.SubAppInfo;
import com.huawei.hms.support.api.core.ConnectService;
import com.huawei.hms.support.api.entity.auth.PermissionInfo;
import com.huawei.hms.support.api.entity.auth.Scope;
import com.huawei.hms.support.api.entity.core.CheckConnectInfo;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.huawei.hms.support.api.entity.core.ConnectInfo;
import com.huawei.hms.support.api.entity.core.ConnectResp;
import com.huawei.hms.support.api.entity.core.DisconnectInfo;
import com.huawei.hms.support.api.entity.core.DisconnectResp;
import com.huawei.hms.support.api.entity.core.JosGetNoticeResp;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Checker;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.PackageManagerHelper;
import com.huawei.hms.utils.UIUtil;
import com.huawei.hms.utils.Util;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

@Deprecated
/* loaded from: classes8.dex */
public class HuaweiApiClientImpl extends HuaweiApiClient implements InnerApiClient, ServiceConnection {

    /* renamed from: A */
    private static final Object f23342A = new Object();

    /* renamed from: B */
    private static final Object f23343B = new Object();
    public static final String DEFAULT_ACCOUNT = "<<default account>>";
    public static final int SIGN_IN_MODE_OPTIONAL = 2;
    public static final int SIGN_IN_MODE_REQUIRED = 1;

    /* renamed from: b */
    private final Context f23345b;

    /* renamed from: c */
    private final String f23346c;

    /* renamed from: d */
    private String f23347d;

    /* renamed from: e */
    private String f23348e;

    /* renamed from: f */
    private volatile IAIDLInvoke f23349f;

    /* renamed from: g */
    private String f23350g;

    /* renamed from: h */
    private WeakReference<Activity> f23351h;

    /* renamed from: i */
    private WeakReference<Activity> f23352i;

    /* renamed from: l */
    private List<Scope> f23355l;

    /* renamed from: m */
    private List<PermissionInfo> f23356m;

    /* renamed from: n */
    private Map<Api<?>, Api.ApiOptions> f23357n;

    /* renamed from: o */
    private SubAppInfo f23358o;

    /* renamed from: s */
    private final ReentrantLock f23362s;

    /* renamed from: t */
    private final Condition f23363t;

    /* renamed from: u */
    private ConnectionResult f23364u;

    /* renamed from: v */
    private HuaweiApiClient.ConnectionCallbacks f23365v;

    /* renamed from: w */
    private HuaweiApiClient.OnConnectionFailedListener f23366w;

    /* renamed from: x */
    private Handler f23367x;

    /* renamed from: y */
    private Handler f23368y;

    /* renamed from: z */
    private CheckUpdatelistener f23369z;

    /* renamed from: a */
    private int f23344a = -1;

    /* renamed from: j */
    private boolean f23353j = false;

    /* renamed from: k */
    private AtomicInteger f23354k = new AtomicInteger(1);

    /* renamed from: p */
    private long f23359p = 0;

    /* renamed from: q */
    private int f23360q = 0;

    /* renamed from: r */
    private final Object f23361r = new Object();

    /* renamed from: com.huawei.hms.api.HuaweiApiClientImpl$a */
    public class C5118a implements Handler.Callback {
        public C5118a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message == null || message.what != 2) {
                return false;
            }
            HMSLog.m36986e("HuaweiApiClientImpl", "In connect, bind core service time out");
            if (HuaweiApiClientImpl.this.f23354k.get() == 5) {
                HuaweiApiClientImpl.this.m30588c(1);
                HuaweiApiClientImpl.this.m30581b();
            }
            return true;
        }
    }

    /* renamed from: com.huawei.hms.api.HuaweiApiClientImpl$b */
    public class C5119b implements Handler.Callback {
        public C5119b() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message == null || message.what != 3) {
                return false;
            }
            HMSLog.m36986e("HuaweiApiClientImpl", "In connect, process time out");
            if (HuaweiApiClientImpl.this.f23354k.get() == 2) {
                HuaweiApiClientImpl.this.m30588c(1);
                HuaweiApiClientImpl.this.m30581b();
            }
            return true;
        }
    }

    /* renamed from: com.huawei.hms.api.HuaweiApiClientImpl$c */
    public class BinderC5120c extends IAIDLCallback.Stub {

        /* renamed from: a */
        final /* synthetic */ ResultCallback f23372a;

        public BinderC5120c(ResultCallback resultCallback) {
            this.f23372a = resultCallback;
        }

        @Override // com.huawei.hms.core.aidl.IAIDLCallback
        public void call(DataBuffer dataBuffer) {
            if (dataBuffer == null) {
                HMSLog.m36988i("HuaweiApiClientImpl", "Exit asyncRequest onResult -1");
                this.f23372a.onResult(new BundleResult(-1, null));
                return;
            }
            MessageCodec messageCodecFind = CodecLookup.find(dataBuffer.getProtocol());
            ResponseHeader responseHeader = new ResponseHeader();
            messageCodecFind.decode(dataBuffer.header, responseHeader);
            BundleResult bundleResult = new BundleResult(responseHeader.getStatusCode(), dataBuffer.getBody());
            HMSLog.m36988i("HuaweiApiClientImpl", "Exit asyncRequest onResult");
            this.f23372a.onResult(bundleResult);
        }
    }

    /* renamed from: com.huawei.hms.api.HuaweiApiClientImpl$d */
    public static class C5121d extends PendingResultImpl<Status, IMessageEntity> {
        public C5121d(ApiClient apiClient, String str, IMessageEntity iMessageEntity) {
            super(apiClient, str, iMessageEntity);
        }

        @Override // com.huawei.hms.support.api.PendingResultImpl
        /* renamed from: a */
        public Status onComplete(IMessageEntity iMessageEntity) {
            return new Status(0);
        }
    }

    /* renamed from: com.huawei.hms.api.HuaweiApiClientImpl$e */
    public class C5122e implements ResultCallback<ResolveResult<ConnectResp>> {

        /* renamed from: com.huawei.hms.api.HuaweiApiClientImpl$e$a */
        public class a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ ResolveResult f23375a;

            public a(ResolveResult resolveResult) {
                this.f23375a = resolveResult;
            }

            @Override // java.lang.Runnable
            public void run() {
                HuaweiApiClientImpl.this.m30579a((ResolveResult<ConnectResp>) this.f23375a);
            }
        }

        private C5122e() {
        }

        @Override // com.huawei.hms.support.api.client.ResultCallback
        /* renamed from: a */
        public void onResult(ResolveResult<ConnectResp> resolveResult) {
            new Handler(Looper.getMainLooper()).post(new a(resolveResult));
        }

        public /* synthetic */ C5122e(HuaweiApiClientImpl huaweiApiClientImpl, C5118a c5118a) {
            this();
        }
    }

    /* renamed from: com.huawei.hms.api.HuaweiApiClientImpl$f */
    public class C5123f implements ResultCallback<ResolveResult<DisconnectResp>> {

        /* renamed from: com.huawei.hms.api.HuaweiApiClientImpl$f$a */
        public class a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ ResolveResult f23378a;

            public a(ResolveResult resolveResult) {
                this.f23378a = resolveResult;
            }

            @Override // java.lang.Runnable
            public void run() {
                HuaweiApiClientImpl.this.m30585b((ResolveResult<DisconnectResp>) this.f23378a);
            }
        }

        private C5123f() {
        }

        @Override // com.huawei.hms.support.api.client.ResultCallback
        /* renamed from: a */
        public void onResult(ResolveResult<DisconnectResp> resolveResult) {
            new Handler(Looper.getMainLooper()).post(new a(resolveResult));
        }

        public /* synthetic */ C5123f(HuaweiApiClientImpl huaweiApiClientImpl, C5118a c5118a) {
            this();
        }
    }

    /* renamed from: com.huawei.hms.api.HuaweiApiClientImpl$g */
    public class C5124g implements ResultCallback<ResolveResult<JosGetNoticeResp>> {
        private C5124g() {
        }

        @Override // com.huawei.hms.support.api.client.ResultCallback
        /* renamed from: a */
        public void onResult(ResolveResult<JosGetNoticeResp> resolveResult) {
            JosGetNoticeResp value;
            Intent noticeIntent;
            if (resolveResult == null || !resolveResult.getStatus().isSuccess() || (noticeIntent = (value = resolveResult.getValue()).getNoticeIntent()) == null || value.getStatusCode() != 0) {
                return;
            }
            HMSLog.m36988i("HuaweiApiClientImpl", "get notice has intent.");
            Activity validActivity = Util.getValidActivity((Activity) HuaweiApiClientImpl.this.f23351h.get(), HuaweiApiClientImpl.this.getTopActivity());
            if (validActivity == null) {
                HMSLog.m36986e("HuaweiApiClientImpl", "showNotice no valid activity!");
            } else {
                HuaweiApiClientImpl.this.f23353j = true;
                validActivity.startActivity(noticeIntent);
            }
        }

        public /* synthetic */ C5124g(HuaweiApiClientImpl huaweiApiClientImpl, C5118a c5118a) {
            this();
        }
    }

    public HuaweiApiClientImpl(Context context) {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.f23362s = reentrantLock;
        this.f23363t = reentrantLock.newCondition();
        this.f23367x = null;
        this.f23368y = null;
        this.f23369z = null;
        this.f23345b = context;
        String appId = Util.getAppId(context);
        this.f23346c = appId;
        this.f23347d = appId;
        this.f23348e = Util.getCpId(context);
    }

    /* renamed from: d */
    private DisconnectInfo m30590d() {
        ArrayList arrayList = new ArrayList();
        Map<Api<?>, Api.ApiOptions> map = this.f23357n;
        if (map != null) {
            Iterator<Api<?>> it = map.keySet().iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getApiName());
            }
        }
        return new DisconnectInfo(this.f23355l, arrayList);
    }

    /* renamed from: e */
    private int m30591e() {
        int hmsVersion = Util.getHmsVersion(this.f23345b);
        if (hmsVersion != 0 && hmsVersion >= 20503000) {
            return hmsVersion;
        }
        int iM30592f = m30592f();
        if (m30593g()) {
            if (iM30592f < 20503000) {
                return 20503000;
            }
            return iM30592f;
        }
        if (iM30592f < 20600000) {
            return 20600000;
        }
        return iM30592f;
    }

    /* renamed from: f */
    private int m30592f() {
        Integer num;
        int iIntValue;
        Map<Api<?>, Api.ApiOptions> apiMap = getApiMap();
        int i10 = 0;
        if (apiMap == null) {
            return 0;
        }
        Iterator<Api<?>> it = apiMap.keySet().iterator();
        while (it.hasNext()) {
            String apiName = it.next().getApiName();
            if (!TextUtils.isEmpty(apiName) && (num = HuaweiApiAvailability.getApiMap().get(apiName)) != null && (iIntValue = num.intValue()) > i10) {
                i10 = iIntValue;
            }
        }
        return i10;
    }

    /* renamed from: g */
    private boolean m30593g() {
        Map<Api<?>, Api.ApiOptions> map = this.f23357n;
        if (map == null) {
            return false;
        }
        Iterator<Api<?>> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (HuaweiApiAvailability.HMS_API_NAME_GAME.equals(it.next().getApiName())) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: h */
    private void m30594h() {
        Handler handler = this.f23367x;
        if (handler != null) {
            handler.removeMessages(2);
        } else {
            this.f23367x = new Handler(Looper.getMainLooper(), new C5118a());
        }
        this.f23367x.sendEmptyMessageDelayed(2, 5000L);
    }

    /* renamed from: i */
    private void m30595i() {
        synchronized (f23343B) {
            try {
                Handler handler = this.f23368y;
                if (handler != null) {
                    handler.removeMessages(3);
                } else {
                    this.f23368y = new Handler(Looper.getMainLooper(), new C5119b());
                }
                HMSLog.m36983d("HuaweiApiClientImpl", "sendEmptyMessageDelayed for onConnectionResult 3 seconds. the result is : " + this.f23368y.sendEmptyMessageDelayed(3, 3000L));
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: j */
    private void m30596j() {
        HMSLog.m36988i("HuaweiApiClientImpl", "Enter sendConnectApiServceRequest.");
        ConnectService.connect(this, m30586c()).setResultCallback(new C5122e(this, null));
    }

    /* renamed from: k */
    private void m30597k() {
        ConnectService.disconnect(this, m30590d()).setResultCallback(new C5123f(this, null));
    }

    /* renamed from: l */
    private void m30598l() {
        HMSLog.m36988i("HuaweiApiClientImpl", "Enter sendForceConnectApiServceRequest.");
        ConnectService.forceConnect(this, m30586c()).setResultCallback(new C5122e(this, null));
    }

    /* renamed from: m */
    private void m30599m() {
        if (this.f23353j) {
            HMSLog.m36988i("HuaweiApiClientImpl", "Connect notice has been shown.");
        } else if (HuaweiApiAvailability.getInstance().isHuaweiMobileNoticeAvailable(this.f23345b) == 0) {
            ConnectService.getNotice(this, 0, "6.13.0.303").setResultCallback(new C5124g(this, null));
        }
    }

    /* renamed from: n */
    private void m30600n() {
        Util.unBindServiceCatchException(this.f23345b, this);
        this.f23349f = null;
    }

    public int asyncRequest(Bundle bundle, String str, int i10, ResultCallback<BundleResult> resultCallback) {
        HMSLog.m36988i("HuaweiApiClientImpl", "Enter asyncRequest.");
        if (resultCallback == null || str == null || bundle == null) {
            HMSLog.m36986e("HuaweiApiClientImpl", "arguments is invalid.");
            return CommonCode.ErrorCode.ARGUMENTS_INVALID;
        }
        if (!innerIsConnected()) {
            HMSLog.m36986e("HuaweiApiClientImpl", "client is unConnect.");
            return CommonCode.ErrorCode.CLIENT_API_INVALID;
        }
        DataBuffer dataBuffer = new DataBuffer(str, i10);
        MessageCodec messageCodecFind = CodecLookup.find(dataBuffer.getProtocol());
        dataBuffer.addBody(bundle);
        RequestHeader requestHeader = new RequestHeader(getAppID(), getPackageName(), 61300303, getSessionId());
        requestHeader.setApiNameList(getApiNameList());
        dataBuffer.header = messageCodecFind.encode(requestHeader, new Bundle());
        try {
            getService().asyncCall(dataBuffer, new BinderC5120c(resultCallback));
            return 0;
        } catch (RemoteException e10) {
            HMSLog.m36986e("HuaweiApiClientImpl", "remote exception:" + e10.getMessage());
            return CommonCode.ErrorCode.INTERNAL_ERROR;
        }
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void checkUpdate(Activity activity, CheckUpdatelistener checkUpdatelistener) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        if (checkUpdatelistener == null) {
            HMSLog.m36986e("HuaweiApiClientImpl", "listener is null!");
            return;
        }
        if (activity == null || activity.isFinishing()) {
            HMSLog.m36986e("HuaweiApiClientImpl", "checkUpdate, activity is illegal: " + activity);
            checkUpdatelistener.onResult(-1);
            return;
        }
        this.f23369z = checkUpdatelistener;
        try {
            Class<?> cls = Class.forName("com.huawei.hms.update.manager.CheckUpdateLegacy");
            cls.getMethod("initCheckUpdateCallBack", Object.class, Activity.class).invoke(cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]), this, activity);
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchMethodException | InvocationTargetException e10) {
            HMSLog.m36986e("HuaweiApiClientImpl", "invoke CheckUpdateLegacy.initCheckUpdateCallBack fail. " + e10.getMessage());
            checkUpdatelistener.onResult(-1);
        }
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void connect(Activity activity) {
        HMSLog.m36988i("HuaweiApiClientImpl", "====== HMSSDK version: 61300303 ======");
        int i10 = this.f23354k.get();
        HMSLog.m36988i("HuaweiApiClientImpl", "Enter connect, Connection Status: " + i10);
        if (i10 == 3 || i10 == 5 || i10 == 2 || i10 == 4) {
            return;
        }
        if (activity != null) {
            this.f23351h = new WeakReference<>(activity);
            this.f23352i = new WeakReference<>(activity);
        }
        this.f23347d = TextUtils.isEmpty(this.f23346c) ? Util.getAppId(this.f23345b) : this.f23346c;
        int iM30591e = m30591e();
        HMSLog.m36988i("HuaweiApiClientImpl", "connect minVersion:" + iM30591e);
        HuaweiApiAvailability.setServicesVersionCode(iM30591e);
        int iIsHuaweiMobileServicesAvailable = HuaweiMobileServicesUtil.isHuaweiMobileServicesAvailable(this.f23345b, iM30591e);
        HMSLog.m36988i("HuaweiApiClientImpl", "In connect, isHuaweiMobileServicesAvailable result: " + iIsHuaweiMobileServicesAvailable);
        this.f23360q = HMSPackageManager.getInstance(this.f23345b).getHmsMultiServiceVersion();
        if (iIsHuaweiMobileServicesAvailable != 0) {
            if (this.f23366w != null) {
                m30582b(iIsHuaweiMobileServicesAvailable);
                return;
            }
            return;
        }
        m30588c(5);
        if (this.f23349f == null) {
            m30575a();
            return;
        }
        m30588c(2);
        m30596j();
        m30595i();
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void connectForeground() {
        HMSLog.m36988i("HuaweiApiClientImpl", "====== HMSSDK version: 61300303 ======");
        int i10 = this.f23354k.get();
        HMSLog.m36988i("HuaweiApiClientImpl", "Enter forceConnect, Connection Status: " + i10);
        if (i10 == 3 || i10 == 5 || i10 == 2 || i10 == 4) {
            return;
        }
        this.f23347d = TextUtils.isEmpty(this.f23346c) ? Util.getAppId(this.f23345b) : this.f23346c;
        m30598l();
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void disableLifeCycleManagement(Activity activity) {
        if (this.f23344a < 0) {
            throw new IllegalStateException("disableLifeCycleManagement failed");
        }
        AutoLifecycleFragment.getInstance(activity).stopAutoManage(this.f23344a);
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public PendingResult<Status> discardAndReconnect() {
        return new C5121d(this, null, null);
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void disconnect() {
        int i10 = this.f23354k.get();
        HMSLog.m36988i("HuaweiApiClientImpl", "Enter disconnect, Connection Status: " + i10);
        if (i10 == 2) {
            m30588c(4);
            return;
        }
        if (i10 == 3) {
            m30588c(4);
            m30597k();
        } else {
            if (i10 != 5) {
                return;
            }
            m30576a(2);
            m30588c(4);
        }
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public Map<Api<?>, Api.ApiOptions> getApiMap() {
        return this.f23357n;
    }

    @Override // com.huawei.hms.support.api.client.AidlApiClient
    public List<String> getApiNameList() {
        ArrayList arrayList = new ArrayList();
        Map<Api<?>, Api.ApiOptions> map = this.f23357n;
        if (map != null) {
            Iterator<Api<?>> it = map.keySet().iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getApiName());
            }
        }
        return arrayList;
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public String getAppID() {
        return this.f23347d;
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public ConnectionResult getConnectionResult(Api<?> api) {
        if (isConnected()) {
            this.f23364u = null;
            return new ConnectionResult(0, (PendingIntent) null);
        }
        ConnectionResult connectionResult = this.f23364u;
        return connectionResult != null ? connectionResult : new ConnectionResult(13, (PendingIntent) null);
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public Context getContext() {
        return this.f23345b;
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public String getCpID() {
        return this.f23348e;
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public String getPackageName() {
        return this.f23345b.getPackageName();
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public List<PermissionInfo> getPermissionInfos() {
        return this.f23356m;
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public List<Scope> getScopes() {
        return this.f23355l;
    }

    @Override // com.huawei.hms.support.api.client.AidlApiClient
    public IAIDLInvoke getService() {
        return this.f23349f;
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public String getSessionId() {
        return this.f23350g;
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public final SubAppInfo getSubAppInfo() {
        return this.f23358o;
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public Activity getTopActivity() {
        WeakReference<Activity> weakReference = this.f23352i;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public String getTransportName() {
        return IPCTransport.class.getName();
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public boolean hasConnectedApi(Api<?> api) {
        return isConnected();
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public boolean hasConnectionFailureListener(HuaweiApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        Checker.checkNonNull(onConnectionFailedListener, "onConnectionFailedListener should not be null");
        synchronized (this.f23361r) {
            try {
                return this.f23366w == onConnectionFailedListener;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public boolean hasConnectionSuccessListener(HuaweiApiClient.ConnectionCallbacks connectionCallbacks) {
        Checker.checkNonNull(connectionCallbacks, "connectionCallbacksListener should not be null");
        synchronized (this.f23361r) {
            try {
                return this.f23365v == connectionCallbacks;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public ConnectionResult holdUpConnect() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("blockingConnect must not be called on the UI thread");
        }
        this.f23362s.lock();
        try {
            connect((Activity) null);
            while (isConnecting()) {
                this.f23363t.await();
            }
            if (isConnected()) {
                this.f23364u = null;
                return new ConnectionResult(0, (PendingIntent) null);
            }
            ConnectionResult connectionResult = this.f23364u;
            return connectionResult != null ? connectionResult : new ConnectionResult(13, (PendingIntent) null);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            return new ConnectionResult(15, (PendingIntent) null);
        } finally {
            this.f23362s.unlock();
        }
    }

    @Override // com.huawei.hms.support.api.client.InnerApiClient
    public boolean innerIsConnected() {
        return this.f23354k.get() == 3 || this.f23354k.get() == 4;
    }

    @Override // com.huawei.hms.api.HuaweiApiClient, com.huawei.hms.support.api.client.ApiClient
    public boolean isConnected() {
        if (this.f23360q == 0) {
            this.f23360q = HMSPackageManager.getInstance(this.f23345b).getHmsMultiServiceVersion();
        }
        if (this.f23360q >= 20504000) {
            return innerIsConnected();
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - this.f23359p;
        if (jCurrentTimeMillis > 0 && jCurrentTimeMillis < 300000) {
            return innerIsConnected();
        }
        if (!innerIsConnected()) {
            return false;
        }
        Status status = ((ResolveResult) ConnectService.checkconnect(this, new CheckConnectInfo()).awaitOnAnyThread(RippleView.SINGLE_RIPPLE_TIME, TimeUnit.MILLISECONDS)).getStatus();
        if (status.isSuccess()) {
            this.f23359p = System.currentTimeMillis();
            return true;
        }
        int statusCode = status.getStatusCode();
        HMSLog.m36988i("HuaweiApiClientImpl", "isConnected is false, statuscode:" + statusCode);
        if (statusCode == 907135004) {
            return false;
        }
        m30600n();
        m30588c(1);
        this.f23359p = System.currentTimeMillis();
        return false;
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public boolean isConnecting() {
        int i10 = this.f23354k.get();
        return i10 == 2 || i10 == 5;
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void onPause(Activity activity) {
        HMSLog.m36988i("HuaweiApiClientImpl", "onPause");
    }

    public void onResult(int i10) {
        this.f23369z.onResult(i10);
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void onResume(Activity activity) {
        if (activity != null) {
            HMSLog.m36988i("HuaweiApiClientImpl", "onResume");
            this.f23352i = new WeakReference<>(activity);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        HMSLog.m36988i("HuaweiApiClientImpl", "HuaweiApiClientImpl Enter onServiceConnected.");
        m30576a(2);
        this.f23349f = IAIDLInvoke.Stub.asInterface(iBinder);
        if (this.f23349f != null) {
            if (this.f23354k.get() == 5) {
                m30588c(2);
                m30596j();
                m30595i();
                return;
            } else {
                if (this.f23354k.get() != 3) {
                    m30600n();
                    return;
                }
                return;
            }
        }
        HMSLog.m36986e("HuaweiApiClientImpl", "In onServiceConnected, mCoreService must not be null.");
        m30600n();
        m30588c(1);
        if (this.f23366w != null) {
            WeakReference<Activity> weakReference = this.f23351h;
            ConnectionResult connectionResult = new ConnectionResult(10, (weakReference == null || weakReference.get() == null) ? null : HuaweiApiAvailability.getInstance().getResolveErrorPendingIntent(this.f23351h.get(), 10));
            this.f23366w.onConnectionFailed(connectionResult);
            this.f23364u = connectionResult;
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        HMSLog.m36988i("HuaweiApiClientImpl", "Enter onServiceDisconnected.");
        this.f23349f = null;
        m30588c(1);
        HuaweiApiClient.ConnectionCallbacks connectionCallbacks = this.f23365v;
        if (connectionCallbacks != null) {
            connectionCallbacks.onConnectionSuspended(1);
        }
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void print(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void reconnect() {
        disconnect();
        connect((Activity) null);
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void removeConnectionFailureListener(HuaweiApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        Checker.checkNonNull(onConnectionFailedListener, "onConnectionFailedListener should not be null");
        synchronized (this.f23361r) {
            try {
                if (this.f23366w != onConnectionFailedListener) {
                    HMSLog.m36989w("HuaweiApiClientImpl", "unregisterConnectionFailedListener: this onConnectionFailedListener has not been registered");
                } else {
                    this.f23366w = null;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void removeConnectionSuccessListener(HuaweiApiClient.ConnectionCallbacks connectionCallbacks) {
        Checker.checkNonNull(connectionCallbacks, "connectionCallbacksListener should not be null");
        synchronized (this.f23361r) {
            try {
                if (this.f23365v != connectionCallbacks) {
                    HMSLog.m36989w("HuaweiApiClientImpl", "unregisterConnectionCallback: this connectionCallbacksListener has not been registered");
                } else {
                    this.f23365v = null;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void resetListener() {
        this.f23369z = null;
    }

    public void setApiMap(Map<Api<?>, Api.ApiOptions> map) {
        this.f23357n = map;
    }

    public void setAutoLifecycleClientId(int i10) {
        this.f23344a = i10;
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void setConnectionCallbacks(HuaweiApiClient.ConnectionCallbacks connectionCallbacks) {
        this.f23365v = connectionCallbacks;
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void setConnectionFailedListener(HuaweiApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.f23366w = onConnectionFailedListener;
    }

    public void setHasShowNotice(boolean z10) {
        this.f23353j = z10;
    }

    public void setPermissionInfos(List<PermissionInfo> list) {
        this.f23356m = list;
    }

    public void setScopes(List<Scope> list) {
        this.f23355l = list;
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public boolean setSubAppInfo(SubAppInfo subAppInfo) {
        HMSLog.m36988i("HuaweiApiClientImpl", "Enter setSubAppInfo");
        if (subAppInfo == null) {
            HMSLog.m36986e("HuaweiApiClientImpl", "subAppInfo is null");
            return false;
        }
        String subAppID = subAppInfo.getSubAppID();
        if (TextUtils.isEmpty(subAppID)) {
            HMSLog.m36986e("HuaweiApiClientImpl", "subAppId is empty");
            return false;
        }
        if (subAppID.equals(TextUtils.isEmpty(this.f23346c) ? Util.getAppId(this.f23345b) : this.f23346c)) {
            HMSLog.m36986e("HuaweiApiClientImpl", "subAppId is host appid");
            return false;
        }
        this.f23358o = new SubAppInfo(subAppInfo);
        return true;
    }

    /* renamed from: c */
    public void m30588c(int i10) {
        this.f23354k.set(i10);
        if (i10 == 1 || i10 == 3 || i10 == 2) {
            this.f23362s.lock();
            try {
                this.f23363t.signalAll();
            } finally {
                this.f23362s.unlock();
            }
        }
    }

    /* renamed from: b */
    private void m30582b(int i10) {
        PendingIntent resolveErrorPendingIntent;
        WeakReference<Activity> weakReference = this.f23351h;
        if (weakReference == null || weakReference.get() == null) {
            resolveErrorPendingIntent = null;
        } else {
            resolveErrorPendingIntent = HuaweiApiAvailability.getInstance().getResolveErrorPendingIntent(this.f23351h.get(), i10);
            HMSLog.m36988i("HuaweiApiClientImpl", "connect 2.0 fail: " + i10);
        }
        ConnectionResult connectionResult = new ConnectionResult(i10, resolveErrorPendingIntent);
        this.f23366w.onConnectionFailed(connectionResult);
        this.f23364u = connectionResult;
    }

    /* renamed from: a */
    private void m30575a() {
        Intent intent = new Intent(HMSPackageManager.getInstance(this.f23345b).getServiceAction());
        HMSPackageManager.getInstance(this.f23345b).refreshForMultiService();
        try {
            String hMSPackageNameForMultiService = HMSPackageManager.getInstance(this.f23345b).getHMSPackageNameForMultiService();
            if (TextUtils.isEmpty(hMSPackageNameForMultiService)) {
                HMSLog.m36986e("HuaweiApiClientImpl", "servicePackageName is empty, Service is invalid, bind core service fail.");
                m30588c(1);
                m30581b();
                return;
            }
            intent.setPackage(hMSPackageNameForMultiService);
            synchronized (f23342A) {
                try {
                    if (this.f23345b.bindService(intent, this, 1)) {
                        m30594h();
                        return;
                    }
                    m30588c(1);
                    HMSLog.m36986e("HuaweiApiClientImpl", "In connect, bind core service fail");
                    m30581b();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        } catch (IllegalArgumentException unused) {
            HMSLog.m36986e("HuaweiApiClientImpl", "IllegalArgumentException when bindCoreService intent.setPackage");
            m30588c(1);
            HMSLog.m36986e("HuaweiApiClientImpl", "In connect, bind core service fail");
            m30581b();
        }
    }

    /* renamed from: c */
    private ConnectInfo m30586c() {
        String packageSignature = new PackageManagerHelper(this.f23345b).getPackageSignature(this.f23345b.getPackageName());
        if (packageSignature == null) {
            packageSignature = "";
        }
        SubAppInfo subAppInfo = this.f23358o;
        return new ConnectInfo(getApiNameList(), this.f23355l, packageSignature, subAppInfo == null ? null : subAppInfo.getSubAppID());
    }

    /* renamed from: b */
    public void m30581b() {
        m30600n();
        if (this.f23366w != null) {
            int i10 = UIUtil.isBackground(this.f23345b) ? 7 : 6;
            WeakReference<Activity> weakReference = this.f23351h;
            ConnectionResult connectionResult = new ConnectionResult(i10, (weakReference == null || weakReference.get() == null) ? null : HuaweiApiAvailability.getInstance().getResolveErrorPendingIntent(this.f23351h.get(), i10));
            this.f23366w.onConnectionFailed(connectionResult);
            this.f23364u = connectionResult;
        }
    }

    /* renamed from: c */
    private void m30589c(ResolveResult<ConnectResp> resolveResult) {
        if (resolveResult.getValue() != null) {
            ProtocolNegotiate.getInstance().negotiate(resolveResult.getValue().protocolVersion);
        }
        m30588c(3);
        this.f23364u = null;
        HuaweiApiClient.ConnectionCallbacks connectionCallbacks = this.f23365v;
        if (connectionCallbacks != null) {
            connectionCallbacks.onConnected();
        }
        if (this.f23351h != null) {
            m30599m();
        }
        for (Map.Entry<Api<?>, Api.ApiOptions> entry : getApiMap().entrySet()) {
            if (entry.getKey().getmConnetctPostList() != null && !entry.getKey().getmConnetctPostList().isEmpty()) {
                HMSLog.m36988i("HuaweiApiClientImpl", "Enter onConnectionResult, get the ConnetctPostList ");
                for (ConnectionPostProcessor connectionPostProcessor : entry.getKey().getmConnetctPostList()) {
                    HMSLog.m36988i("HuaweiApiClientImpl", "Enter onConnectionResult, processor.run");
                    connectionPostProcessor.run(this, this.f23351h);
                }
            }
        }
    }

    /* renamed from: b */
    public void m30585b(ResolveResult<DisconnectResp> resolveResult) {
        HMSLog.m36988i("HuaweiApiClientImpl", "Enter onDisconnectionResult, disconnect from server result: " + resolveResult.getStatus().getStatusCode());
        m30600n();
        m30588c(1);
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public ConnectionResult holdUpConnect(long j10, TimeUnit timeUnit) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            this.f23362s.lock();
            try {
                connect((Activity) null);
                long nanos = timeUnit.toNanos(j10);
                while (isConnecting()) {
                    if (nanos <= 0) {
                        disconnect();
                        return new ConnectionResult(14, (PendingIntent) null);
                    }
                    nanos = this.f23363t.awaitNanos(nanos);
                }
                if (isConnected()) {
                    this.f23364u = null;
                    return new ConnectionResult(0, (PendingIntent) null);
                }
                ConnectionResult connectionResult = this.f23364u;
                return connectionResult != null ? connectionResult : new ConnectionResult(13, (PendingIntent) null);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                return new ConnectionResult(15, (PendingIntent) null);
            } finally {
                this.f23362s.unlock();
            }
        }
        throw new IllegalStateException("blockingConnect must not be called on the UI thread");
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void connect(int i10) {
        connect((Activity) null);
    }

    /* renamed from: a */
    private void m30576a(int i10) {
        if (i10 == 2) {
            synchronized (f23342A) {
                try {
                    Handler handler = this.f23367x;
                    if (handler != null) {
                        handler.removeMessages(i10);
                        this.f23367x = null;
                    }
                } finally {
                }
            }
        }
        if (i10 == 3) {
            synchronized (f23343B) {
                try {
                    Handler handler2 = this.f23368y;
                    if (handler2 != null) {
                        handler2.removeMessages(i10);
                        this.f23368y = null;
                    }
                } finally {
                }
            }
        }
        synchronized (f23342A) {
            try {
                Handler handler3 = this.f23367x;
                if (handler3 != null) {
                    handler3.removeMessages(2);
                    this.f23367x = null;
                }
            } finally {
            }
        }
    }

    /* renamed from: a */
    public void m30579a(ResolveResult<ConnectResp> resolveResult) {
        HMSLog.m36988i("HuaweiApiClientImpl", "Enter onConnectionResult");
        if (this.f23349f != null && this.f23354k.get() == 2) {
            m30576a(3);
            ConnectResp value = resolveResult.getValue();
            if (value != null) {
                this.f23350g = value.sessionId;
            }
            SubAppInfo subAppInfo = this.f23358o;
            PendingIntent resolveErrorPendingIntent = null;
            String subAppID = subAppInfo == null ? null : subAppInfo.getSubAppID();
            if (!TextUtils.isEmpty(subAppID)) {
                this.f23347d = subAppID;
            }
            int statusCode = resolveResult.getStatus().getStatusCode();
            HMSLog.m36988i("HuaweiApiClientImpl", "Enter onConnectionResult, connect to server result: " + statusCode);
            if (Status.SUCCESS.equals(resolveResult.getStatus())) {
                m30589c(resolveResult);
                return;
            }
            if (resolveResult.getStatus() != null && resolveResult.getStatus().getStatusCode() == 1001) {
                m30600n();
                m30588c(1);
                HuaweiApiClient.ConnectionCallbacks connectionCallbacks = this.f23365v;
                if (connectionCallbacks != null) {
                    connectionCallbacks.onConnectionSuspended(3);
                    return;
                }
                return;
            }
            m30600n();
            m30588c(1);
            if (this.f23366w != null) {
                WeakReference<Activity> weakReference = this.f23351h;
                if (weakReference != null && weakReference.get() != null) {
                    resolveErrorPendingIntent = HuaweiApiAvailability.getInstance().getResolveErrorPendingIntent(this.f23351h.get(), statusCode);
                }
                ConnectionResult connectionResult = new ConnectionResult(statusCode, resolveErrorPendingIntent);
                this.f23366w.onConnectionFailed(connectionResult);
                this.f23364u = connectionResult;
                return;
            }
            return;
        }
        HMSLog.m36986e("HuaweiApiClientImpl", "Invalid onConnectionResult");
    }
}
