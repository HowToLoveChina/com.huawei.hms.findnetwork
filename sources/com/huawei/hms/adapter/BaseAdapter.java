package com.huawei.hms.adapter;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.huawei.hms.activity.BridgeActivity;
import com.huawei.hms.adapter.AvailableAdapter;
import com.huawei.hms.adapter.internal.CommonCode;
import com.huawei.hms.adapter.p116ui.BaseResolutionAdapter;
import com.huawei.hms.adapter.p116ui.UpdateAdapter;
import com.huawei.hms.adapter.sysobs.ApkResolutionFailedManager;
import com.huawei.hms.adapter.sysobs.SystemManager;
import com.huawei.hms.adapter.sysobs.SystemObserver;
import com.huawei.hms.availableupdate.UpdateAdapterMgr;
import com.huawei.hms.common.internal.RequestHeader;
import com.huawei.hms.common.internal.ResponseHeader;
import com.huawei.hms.common.internal.ResponseWrap;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.framework.common.ExceptionCode;
import com.huawei.hms.identity.AddressConstants;
import com.huawei.hms.support.api.PendingResultImpl;
import com.huawei.hms.support.api.ResolveResult;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.client.PendingResult;
import com.huawei.hms.support.api.client.ResultCallback;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.hms.support.hianalytics.HiAnalyticsUtil;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.update.kpms.KpmsConstant;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.IntentUtil;
import com.huawei.hms.utils.JsonUtil;
import com.huawei.hms.utils.PackageManagerHelper;
import com.huawei.hms.utils.ResolutionFlagUtil;
import com.huawei.hms.utils.Util;
import java.lang.ref.WeakReference;
import java.sql.Timestamp;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class BaseAdapter {

    /* renamed from: a */
    private WeakReference<ApiClient> f23084a;

    /* renamed from: b */
    private WeakReference<Activity> f23085b;

    /* renamed from: c */
    private BaseCallBack f23086c;

    /* renamed from: d */
    private String f23087d;

    /* renamed from: e */
    private String f23088e;

    /* renamed from: f */
    private Parcelable f23089f;

    /* renamed from: g */
    private BaseCallBack f23090g;

    /* renamed from: h */
    private String f23091h;

    /* renamed from: i */
    private Context f23092i;

    /* renamed from: j */
    private RequestHeader f23093j = new RequestHeader();

    /* renamed from: k */
    private ResponseHeader f23094k = new ResponseHeader();

    /* renamed from: l */
    private SystemObserver f23095l;

    /* renamed from: com.huawei.hms.adapter.BaseAdapter$1 */
    public class RunnableC50531 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ CoreBaseResponse f23096a;

        public RunnableC50531(CoreBaseResponse coreBaseResponse) {
            coreBaseResponse = coreBaseResponse;
        }

        @Override // java.lang.Runnable
        public void run() {
            HMSLog.m36988i("BaseAdapter", "postResolutionTimeoutHandle handle");
            SystemManager.getSystemNotifier().unRegisterObserver(BaseAdapter.this.f23095l);
            ApkResolutionFailedManager.getInstance().removeValueOnly(BaseAdapter.this.f23091h);
            BaseCallBack baseCallBackM30174b = BaseAdapter.this.m30174b();
            if (baseCallBackM30174b == null) {
                HMSLog.m36986e("BaseAdapter", "timeoutRunnable callBack is null");
            } else {
                BaseAdapter.this.m30163a(baseCallBackM30174b, coreBaseResponse);
            }
        }
    }

    /* renamed from: com.huawei.hms.adapter.BaseAdapter$2 */
    public class C50542 implements SystemObserver {
        public C50542() {
        }

        @Override // com.huawei.hms.adapter.sysobs.SystemObserver
        public boolean onNoticeResult(int i10) {
            return false;
        }

        @Override // com.huawei.hms.adapter.sysobs.SystemObserver
        public boolean onSolutionResult(Intent intent, String str) throws JSONException {
            if (TextUtils.isEmpty(str)) {
                HMSLog.m36986e("BaseAdapter", "onSolutionResult but id is null");
                BaseCallBack baseCallBackM30174b = BaseAdapter.this.m30174b();
                if (baseCallBackM30174b == null) {
                    HMSLog.m36986e("BaseAdapter", "onSolutionResult baseCallBack null");
                    return true;
                }
                baseCallBackM30174b.onError(BaseAdapter.this.m30176b(-6));
                return true;
            }
            if (!str.equals(BaseAdapter.this.f23091h)) {
                return false;
            }
            HMSLog.m36988i("BaseAdapter", "onSolutionResult + id is :" + str);
            BaseCallBack baseCallBackM30174b2 = BaseAdapter.this.m30174b();
            if (baseCallBackM30174b2 == null) {
                HMSLog.m36986e("BaseAdapter", "onResult baseCallBack null");
                return true;
            }
            if (intent == null) {
                HMSLog.m36986e("BaseAdapter", "onSolutionResult but data is null");
                String strM30176b = BaseAdapter.this.m30176b(-7);
                BaseAdapter baseAdapter = BaseAdapter.this;
                baseAdapter.m30160a(baseAdapter.f23092i, BaseAdapter.this.f23094k, 0L);
                baseCallBackM30174b2.onError(strM30176b);
                return true;
            }
            if (BaseAdapter.this.m30181b(intent, baseCallBackM30174b2) || BaseAdapter.this.m30172a(intent, baseCallBackM30174b2)) {
                return true;
            }
            HMSLog.m36986e("BaseAdapter", "onComplete for on activity result");
            BaseAdapter.this.m30186c(intent, baseCallBackM30174b2);
            return true;
        }

        @Override // com.huawei.hms.adapter.sysobs.SystemObserver
        public boolean onUpdateResult(int i10) {
            return false;
        }
    }

    public interface BaseCallBack {
        void onComplete(String str, String str2, Parcelable parcelable);

        void onError(String str);
    }

    public class BaseRequestResultCallback implements ResultCallback<ResolveResult<CoreBaseResponse>> {

        /* renamed from: a */
        private AtomicBoolean f23099a = new AtomicBoolean(true);

        /* renamed from: com.huawei.hms.adapter.BaseAdapter$BaseRequestResultCallback$1 */
        public class C50551 implements AvailableAdapter.AvailableCallBack {

            /* renamed from: a */
            final /* synthetic */ BaseCallBack f23101a;

            public C50551(BaseCallBack baseCallBack) {
                baseCallBack = baseCallBack;
            }

            @Override // com.huawei.hms.adapter.AvailableAdapter.AvailableCallBack
            public void onComplete(int i10) {
                HMSLog.m36988i("BaseAdapter", "complete handleSolutionForHMS, result: " + i10);
                if (i10 == 0) {
                    BaseAdapter.this.m30162a(baseCallBack);
                    return;
                }
                BaseAdapter baseAdapter = BaseAdapter.this;
                baseCallBack.onError(baseAdapter.m30152a(i10, baseAdapter.m30155a(i10)).toJson());
            }
        }

        public BaseRequestResultCallback() {
        }

        /* renamed from: a */
        private void m30200a(String str, BaseCallBack baseCallBack, CoreBaseResponse coreBaseResponse, int i10) {
            if (!CommonCode.Resolution.HAS_RESOLUTION_FROM_APK.equals(str)) {
                if (!"installHMS".equals(str)) {
                    BaseAdapter.this.m30163a(baseCallBack, coreBaseResponse);
                    return;
                } else {
                    HMSLog.m36988i("BaseAdapter", "has resolutin: installHMS");
                    m30199a(baseCallBack, coreBaseResponse);
                    return;
                }
            }
            Activity activityM30183c = BaseAdapter.this.m30183c();
            HMSLog.m36988i("BaseAdapter", "activity is: " + activityM30183c);
            if (activityM30183c == null || activityM30183c.isFinishing()) {
                HMSLog.m36986e("BaseAdapter", "activity null");
                BaseAdapter.this.m30163a(baseCallBack, coreBaseResponse);
                return;
            }
            PendingIntent pendingIntent = coreBaseResponse.getPendingIntent();
            if (pendingIntent != null) {
                if (Util.isAvailableLibExist(BaseAdapter.this.f23092i)) {
                    BaseAdapter.this.m30157a(activityM30183c, pendingIntent, coreBaseResponse);
                    return;
                } else {
                    baseCallBack.onError(BaseAdapter.this.m30176b(-9));
                    return;
                }
            }
            Intent intent = coreBaseResponse.getIntent();
            if (intent != null) {
                if (Util.isAvailableLibExist(BaseAdapter.this.f23092i)) {
                    BaseAdapter.this.m30157a(activityM30183c, intent, coreBaseResponse);
                    return;
                } else {
                    baseCallBack.onError(BaseAdapter.this.m30176b(-9));
                    return;
                }
            }
            if (i10 == 2) {
                BaseAdapter baseAdapter = BaseAdapter.this;
                baseCallBack.onError(baseAdapter.m30176b(baseAdapter.f23094k.getErrorCode()));
            } else {
                HMSLog.m36986e("BaseAdapter", "hasResolution is true but NO_SOLUTION");
                baseCallBack.onError(BaseAdapter.this.m30176b(-4));
            }
        }

        @Override // com.huawei.hms.support.api.client.ResultCallback
        public void onResult(ResolveResult<CoreBaseResponse> resolveResult) throws IllegalArgumentException {
            HMSLog.m36988i("BaseAdapter", "BaseRequestResultCallback onResult");
            BaseCallBack baseCallBackM30174b = BaseAdapter.this.m30174b();
            if (baseCallBackM30174b == null) {
                HMSLog.m36986e("BaseAdapter", "onResult baseCallBack null");
                return;
            }
            if (resolveResult == null) {
                HMSLog.m36986e("BaseAdapter", "result null");
                baseCallBackM30174b.onError(BaseAdapter.this.m30176b(-1));
                return;
            }
            CoreBaseResponse value = resolveResult.getValue();
            if (value == null) {
                HMSLog.m36986e("BaseAdapter", "response null");
                baseCallBackM30174b.onError(BaseAdapter.this.m30176b(-1));
                return;
            }
            if (TextUtils.isEmpty(value.getJsonHeader())) {
                HMSLog.m36986e("BaseAdapter", "jsonHeader null");
                baseCallBackM30174b.onError(BaseAdapter.this.m30176b(-1));
                return;
            }
            JsonUtil.jsonToEntity(value.getJsonHeader(), BaseAdapter.this.f23094k);
            if (this.f23099a.compareAndSet(true, false)) {
                BaseAdapter baseAdapter = BaseAdapter.this;
                baseAdapter.m30159a(baseAdapter.f23092i, BaseAdapter.this.f23094k);
            }
            String resolution = BaseAdapter.this.f23094k.getResolution();
            int statusCode = BaseAdapter.this.f23094k.getStatusCode();
            HMSLog.m36988i("BaseAdapter", "api is: " + BaseAdapter.this.f23094k.getApiName() + ", resolution: " + resolution + ", status_code: " + statusCode);
            m30200a(resolution, baseCallBackM30174b, value, statusCode);
        }

        /* renamed from: a */
        private void m30199a(BaseCallBack baseCallBack, CoreBaseResponse coreBaseResponse) {
            if (!BaseAdapter.this.m30196h()) {
                if (Util.isAvailableLibExist(BaseAdapter.this.f23092i)) {
                    Activity activityM30183c = BaseAdapter.this.m30183c();
                    if (activityM30183c != null && !activityM30183c.isFinishing()) {
                        HMSLog.m36988i("BaseAdapter", "start handleSolutionForHMS");
                        AvailableAdapter availableAdapter = new AvailableAdapter(ExceptionCode.CRASH_EXCEPTION);
                        availableAdapter.setCalledBySolutionInstallHms(true);
                        availableAdapter.startResolution(activityM30183c, new AvailableAdapter.AvailableCallBack() { // from class: com.huawei.hms.adapter.BaseAdapter.BaseRequestResultCallback.1

                            /* renamed from: a */
                            final /* synthetic */ BaseCallBack f23101a;

                            public C50551(BaseCallBack baseCallBack2) {
                                baseCallBack = baseCallBack2;
                            }

                            @Override // com.huawei.hms.adapter.AvailableAdapter.AvailableCallBack
                            public void onComplete(int i10) {
                                HMSLog.m36988i("BaseAdapter", "complete handleSolutionForHMS, result: " + i10);
                                if (i10 == 0) {
                                    BaseAdapter.this.m30162a(baseCallBack);
                                    return;
                                }
                                BaseAdapter baseAdapter = BaseAdapter.this;
                                baseCallBack.onError(baseAdapter.m30152a(i10, baseAdapter.m30155a(i10)).toJson());
                            }
                        });
                        return;
                    }
                    HMSLog.m36986e("BaseAdapter", "activity is null");
                    try {
                        if (BaseAdapter.this.f23092i != null && AvailableUtil.isInstallerLibExist(BaseAdapter.this.f23092i)) {
                            if (!UpdateAdapterMgr.INST.needStartUpdateActivity()) {
                                return;
                            }
                            HMSLog.m36988i("BaseAdapter", "pass installHMS intent");
                            Intent intentStartBridgeActivity = BridgeActivity.getIntentStartBridgeActivity(BaseAdapter.this.f23092i, UpdateAdapter.class.getName());
                            intentStartBridgeActivity.putExtra(CommonCode.MapKey.UPDATE_VERSION, ExceptionCode.CRASH_EXCEPTION);
                            intentStartBridgeActivity.putExtra("installHMS", "installHMS");
                            coreBaseResponse.setIntent(intentStartBridgeActivity);
                            BaseAdapter.this.m30163a(baseCallBack2, coreBaseResponse);
                        } else {
                            HMSLog.m36988i("BaseAdapter", "pass ACTIVITY_NULL error");
                            BaseAdapter baseAdapter = BaseAdapter.this;
                            baseCallBack2.onError(baseAdapter.m30152a(-3, baseAdapter.m30155a(-3)).toJson());
                        }
                        return;
                    } catch (RuntimeException unused) {
                        HMSLog.m36986e("BaseAdapter", "handleSolutionForHms pass result failed");
                        return;
                    }
                }
                HMSLog.m36988i("BaseAdapter", "handleSolutionForHms: no Available lib exist");
                baseCallBack2.onError(BaseAdapter.this.m30176b(-9));
                return;
            }
            HMSLog.m36988i("BaseAdapter", "HMS Core exists, need to refresh bind info");
            BaseAdapter.this.m30162a(baseCallBack2);
        }
    }

    /* renamed from: com.huawei.hms.adapter.BaseAdapter$a */
    public static class C5056a extends PendingResultImpl<ResolveResult<CoreBaseResponse>, CoreBaseResponse> {
        public C5056a(ApiClient apiClient, String str, IMessageEntity iMessageEntity) {
            super(apiClient, str, iMessageEntity);
        }

        @Override // com.huawei.hms.support.api.PendingResultImpl
        /* renamed from: a */
        public ResolveResult<CoreBaseResponse> onComplete(CoreBaseResponse coreBaseResponse) {
            ResolveResult<CoreBaseResponse> resolveResult = new ResolveResult<>(coreBaseResponse);
            resolveResult.setStatus(Status.SUCCESS);
            return resolveResult;
        }
    }

    public BaseAdapter(ApiClient apiClient) {
        this.f23084a = new WeakReference<>(apiClient);
        if (apiClient == null) {
            HMSLog.m36989w("BaseAdapter", "BaseAdapter constructor client is null");
            return;
        }
        this.f23092i = apiClient.getContext().getApplicationContext();
        HMSLog.m36988i("BaseAdapter", "In constructor, WeakReference is " + this.f23084a);
    }

    /* renamed from: h */
    public boolean m30196h() {
        return new PackageManagerHelper(this.f23092i).getPackageStates(HMSPackageManager.getInstance(this.f23092i).getHMSPackageName()) == PackageManagerHelper.PackageStates.ENABLED;
    }

    /* renamed from: i */
    private void m30197i() {
        if (this.f23087d == null || this.f23090g == null) {
            return;
        }
        this.f23094k = null;
        this.f23094k = new ResponseHeader();
        baseRequest(m30189d(), m30191e(), m30193f(), m30150a());
    }

    /* renamed from: j */
    private void m30198j() {
        if (this.f23092i == null) {
            HMSLog.m36986e("BaseAdapter", "sendBroadcastAfterResolutionHms, context is null");
            return;
        }
        Intent intent = new Intent("com.huawei.hms.core.action.SESSION_INVALID");
        try {
            intent.setPackage(this.f23092i.getPackageName());
            this.f23092i.sendBroadcast(intent);
        } catch (IllegalArgumentException unused) {
            HMSLog.m36986e("BaseAdapter", "IllegalArgumentException when sendBroadcastAfterResolutionHms intent.setPackage");
        }
    }

    public void baseRequest(String str, String str2, Parcelable parcelable, BaseCallBack baseCallBack) {
        m30171a(str, str2, parcelable, baseCallBack);
        if (this.f23084a == null) {
            HMSLog.m36986e("BaseAdapter", "client is null");
            baseCallBack.onError(m30176b(-2));
            return;
        }
        this.f23086c = baseCallBack;
        JsonUtil.jsonToEntity(str, this.f23093j);
        CoreBaseRequest coreBaseRequest = new CoreBaseRequest();
        coreBaseRequest.setJsonObject(str2);
        coreBaseRequest.setJsonHeader(str);
        coreBaseRequest.setParcelable(parcelable);
        String apiName = this.f23093j.getApiName();
        if (TextUtils.isEmpty(apiName)) {
            HMSLog.m36986e("BaseAdapter", "get uri null");
            baseCallBack.onError(m30176b(-5));
            return;
        }
        String transactionId = this.f23093j.getTransactionId();
        this.f23091h = transactionId;
        if (TextUtils.isEmpty(transactionId)) {
            HMSLog.m36986e("BaseAdapter", "get transactionId null");
            baseCallBack.onError(m30176b(-6));
            return;
        }
        HMSLog.m36988i("BaseAdapter", "in baseRequest + uri is :" + apiName + ", transactionId is : " + this.f23091h);
        m30158a(this.f23092i, this.f23093j);
        m30154a(this.f23084a.get(), apiName, coreBaseRequest).setResultCallback(new BaseRequestResultCallback());
    }

    /* renamed from: d */
    private String m30189d() {
        return this.f23087d;
    }

    /* renamed from: e */
    private String m30191e() {
        return this.f23088e;
    }

    /* renamed from: f */
    private Parcelable m30193f() {
        return this.f23089f;
    }

    /* renamed from: g */
    private void m30194g() {
        this.f23095l = new SystemObserver() { // from class: com.huawei.hms.adapter.BaseAdapter.2
            public C50542() {
            }

            @Override // com.huawei.hms.adapter.sysobs.SystemObserver
            public boolean onNoticeResult(int i10) {
                return false;
            }

            @Override // com.huawei.hms.adapter.sysobs.SystemObserver
            public boolean onSolutionResult(Intent intent, String str) throws JSONException {
                if (TextUtils.isEmpty(str)) {
                    HMSLog.m36986e("BaseAdapter", "onSolutionResult but id is null");
                    BaseCallBack baseCallBackM30174b = BaseAdapter.this.m30174b();
                    if (baseCallBackM30174b == null) {
                        HMSLog.m36986e("BaseAdapter", "onSolutionResult baseCallBack null");
                        return true;
                    }
                    baseCallBackM30174b.onError(BaseAdapter.this.m30176b(-6));
                    return true;
                }
                if (!str.equals(BaseAdapter.this.f23091h)) {
                    return false;
                }
                HMSLog.m36988i("BaseAdapter", "onSolutionResult + id is :" + str);
                BaseCallBack baseCallBackM30174b2 = BaseAdapter.this.m30174b();
                if (baseCallBackM30174b2 == null) {
                    HMSLog.m36986e("BaseAdapter", "onResult baseCallBack null");
                    return true;
                }
                if (intent == null) {
                    HMSLog.m36986e("BaseAdapter", "onSolutionResult but data is null");
                    String strM30176b = BaseAdapter.this.m30176b(-7);
                    BaseAdapter baseAdapter = BaseAdapter.this;
                    baseAdapter.m30160a(baseAdapter.f23092i, BaseAdapter.this.f23094k, 0L);
                    baseCallBackM30174b2.onError(strM30176b);
                    return true;
                }
                if (BaseAdapter.this.m30181b(intent, baseCallBackM30174b2) || BaseAdapter.this.m30172a(intent, baseCallBackM30174b2)) {
                    return true;
                }
                HMSLog.m36986e("BaseAdapter", "onComplete for on activity result");
                BaseAdapter.this.m30186c(intent, baseCallBackM30174b2);
                return true;
            }

            @Override // com.huawei.hms.adapter.sysobs.SystemObserver
            public boolean onUpdateResult(int i10) {
                return false;
            }
        };
    }

    /* renamed from: c */
    public Activity m30183c() {
        if (this.f23085b == null) {
            HMSLog.m36988i("BaseAdapter", "activityWeakReference is " + this.f23085b);
            return null;
        }
        ApiClient apiClient = this.f23084a.get();
        if (apiClient == null) {
            HMSLog.m36988i("BaseAdapter", "tmpApi is null");
            return null;
        }
        HMSLog.m36988i("BaseAdapter", "activityWeakReference has " + this.f23085b.get());
        return Util.getActiveActivity(this.f23085b.get(), apiClient.getContext());
    }

    /* renamed from: b */
    public BaseCallBack m30174b() {
        BaseCallBack baseCallBack = this.f23086c;
        if (baseCallBack != null) {
            return baseCallBack;
        }
        HMSLog.m36986e("BaseAdapter", "callback null");
        return null;
    }

    /* renamed from: b */
    private void m30178b(Context context, RequestHeader requestHeader) {
        Map<String, String> mapFromRequestHeader = HiAnalyticsUtil.getInstance().getMapFromRequestHeader(requestHeader);
        mapFromRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, HiAnalyticsConstant.Direction.REQUEST);
        mapFromRequestHeader.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(requestHeader.getKitSdkVersion())));
        mapFromRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_PHONETYPE, Util.getSystemProperties("ro.logsystem.usertype", ""));
        HiAnalyticsUtil.getInstance().onNewEvent(context, HiAnalyticsConstant.HMS_SDK_BASE_START_RESOLUTION, mapFromRequestHeader);
    }

    public BaseAdapter(ApiClient apiClient, Activity activity) {
        this.f23084a = new WeakReference<>(apiClient);
        this.f23085b = new WeakReference<>(activity);
        if (activity == null) {
            HMSLog.m36989w("BaseAdapter", "BaseAdapter constructor activity is null");
            return;
        }
        this.f23092i = activity.getApplicationContext();
        HMSLog.m36988i("BaseAdapter", "In constructor, activityWeakReference is " + this.f23085b + ", activity is " + this.f23085b.get());
    }

    /* renamed from: c */
    private void m30185c(int i10) {
        this.f23094k.setTransactionId(this.f23093j.getTransactionId());
        this.f23094k.setAppID(this.f23093j.getAppID());
        this.f23094k.setApiName(this.f23093j.getApiName());
        this.f23094k.setSrvName(this.f23093j.getSrvName());
        this.f23094k.setPkgName(this.f23093j.getPkgName());
        this.f23094k.setStatusCode(1);
        this.f23094k.setErrorCode(i10);
        this.f23094k.setErrorReason("Core error");
    }

    /* renamed from: a */
    private PendingResult<ResolveResult<CoreBaseResponse>> m30154a(ApiClient apiClient, String str, CoreBaseRequest coreBaseRequest) {
        return new C5056a(apiClient, str, coreBaseRequest);
    }

    /* renamed from: a */
    public void m30162a(BaseCallBack baseCallBack) {
        HMSPackageManager.getInstance(this.f23092i).resetMultiServiceState();
        baseCallBack.onError(m30152a(11, m30155a(11)).toJson());
        m30198j();
    }

    /* renamed from: b */
    public String m30176b(int i10) {
        m30185c(i10);
        return this.f23094k.toJson();
    }

    /* renamed from: b */
    private void m30180b(String str) {
        this.f23088e = str;
    }

    /* renamed from: b */
    private void m30179b(BaseCallBack baseCallBack) {
        this.f23090g = baseCallBack;
    }

    /* renamed from: a */
    public void m30163a(BaseCallBack baseCallBack, CoreBaseResponse coreBaseResponse) {
        HMSLog.m36988i("BaseAdapter", "baseCallBack.onComplete");
        PendingIntent pendingIntent = coreBaseResponse.getPendingIntent();
        if (pendingIntent != null) {
            baseCallBack.onComplete(coreBaseResponse.getJsonHeader(), coreBaseResponse.getJsonBody(), pendingIntent);
            return;
        }
        Intent intentModifyIntentBehaviorsSafe = IntentUtil.modifyIntentBehaviorsSafe(coreBaseResponse.getIntent());
        if (intentModifyIntentBehaviorsSafe != null) {
            baseCallBack.onComplete(coreBaseResponse.getJsonHeader(), coreBaseResponse.getJsonBody(), intentModifyIntentBehaviorsSafe);
        } else {
            baseCallBack.onComplete(coreBaseResponse.getJsonHeader(), coreBaseResponse.getJsonBody(), null);
        }
    }

    /* renamed from: b */
    public boolean m30181b(Intent intent, BaseCallBack baseCallBack) {
        if (!intent.hasExtra(KpmsConstant.KIT_UPDATE_RESULT)) {
            return false;
        }
        int intExtra = intent.getIntExtra(KpmsConstant.KIT_UPDATE_RESULT, 0);
        HMSLog.m36988i("BaseAdapter", "kit_update_result is " + intExtra);
        if (intExtra == 1) {
            HMSLog.m36986e("BaseAdapter", "kit update success,replay request");
            m30197i();
        } else {
            HMSLog.m36986e("BaseAdapter", "kit update failed");
            baseCallBack.onError(m30152a(-10, m30155a(intExtra)).toJson());
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0035  */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m30186c(android.content.Intent r7, com.huawei.hms.adapter.BaseAdapter.BaseCallBack r8) throws org.json.JSONException {
        /*
            r6 = this;
            java.lang.String r0 = "json_header"
            java.lang.String r0 = r7.getStringExtra(r0)
            java.lang.String r1 = "json_body"
            java.lang.String r1 = r7.getStringExtra(r1)
            java.lang.String r2 = "status_code"
            java.lang.Object r2 = com.huawei.hms.utils.JsonUtil.getInfoFromJsonobject(r0, r2)
            java.lang.String r3 = "error_code"
            java.lang.Object r3 = com.huawei.hms.utils.JsonUtil.getInfoFromJsonobject(r0, r3)
            java.lang.String r4 = "HMS_FOREGROUND_RES_UI"
            boolean r5 = r7.hasExtra(r4)
            if (r5 == 0) goto L35
            java.lang.String r7 = r7.getStringExtra(r4)
            java.lang.String r4 = "uiDuration"
            java.lang.Object r7 = com.huawei.hms.utils.JsonUtil.getInfoFromJsonobject(r7, r4)
            boolean r4 = r7 instanceof java.lang.Long
            if (r4 == 0) goto L35
            java.lang.Long r7 = (java.lang.Long) r7
            long r4 = r7.longValue()
            goto L37
        L35:
            r4 = 0
        L37:
            boolean r7 = r2 instanceof java.lang.Integer
            if (r7 == 0) goto L5b
            boolean r7 = r3 instanceof java.lang.Integer
            if (r7 == 0) goto L5b
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r7 = r2.intValue()
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r2 = r3.intValue()
            r6.m30176b(r2)
            com.huawei.hms.common.internal.ResponseHeader r2 = r6.f23094k
            r2.setStatusCode(r7)
            android.content.Context r7 = r6.f23092i
            com.huawei.hms.common.internal.ResponseHeader r2 = r6.f23094k
            r6.m30160a(r7, r2, r4)
            goto L66
        L5b:
            r7 = -8
            r6.m30176b(r7)
            android.content.Context r7 = r6.f23092i
            com.huawei.hms.common.internal.ResponseHeader r2 = r6.f23094k
            r6.m30160a(r7, r2, r4)
        L66:
            r6 = 0
            r8.onComplete(r0, r1, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.adapter.BaseAdapter.m30186c(android.content.Intent, com.huawei.hms.adapter.BaseAdapter$BaseCallBack):void");
    }

    /* renamed from: a */
    public void m30157a(Activity activity, Parcelable parcelable, CoreBaseResponse coreBaseResponse) {
        HMSLog.m36988i("BaseAdapter", "startResolution");
        RequestHeader requestHeader = this.f23093j;
        if (requestHeader != null) {
            m30178b(this.f23092i, requestHeader);
        }
        if (this.f23095l == null) {
            m30194g();
        }
        SystemManager.getSystemNotifier().registerObserver(this.f23095l);
        m30169a(coreBaseResponse);
        Intent intentStartBridgeActivity = BridgeActivity.getIntentStartBridgeActivity(activity, BaseResolutionAdapter.class.getName());
        Bundle bundle = new Bundle();
        bundle.putParcelable("resolution", parcelable);
        intentStartBridgeActivity.putExtras(bundle);
        intentStartBridgeActivity.putExtra("transaction_id", this.f23091h);
        long time = new Timestamp(System.currentTimeMillis()).getTime();
        intentStartBridgeActivity.putExtra(CommonCode.MapKey.RESOLUTION_FLAG, time);
        ResolutionFlagUtil.getInstance().saveResolutionFlag(this.f23091h, time);
        activity.startActivity(intentStartBridgeActivity);
    }

    /* renamed from: a */
    private void m30169a(CoreBaseResponse coreBaseResponse) {
        HMSLog.m36988i("BaseAdapter", "postResolutionTimeoutHandle");
        ApkResolutionFailedManager.getInstance().postTask(this.f23091h, new Runnable() { // from class: com.huawei.hms.adapter.BaseAdapter.1

            /* renamed from: a */
            final /* synthetic */ CoreBaseResponse f23096a;

            public RunnableC50531(CoreBaseResponse coreBaseResponse2) {
                coreBaseResponse = coreBaseResponse2;
            }

            @Override // java.lang.Runnable
            public void run() {
                HMSLog.m36988i("BaseAdapter", "postResolutionTimeoutHandle handle");
                SystemManager.getSystemNotifier().unRegisterObserver(BaseAdapter.this.f23095l);
                ApkResolutionFailedManager.getInstance().removeValueOnly(BaseAdapter.this.f23091h);
                BaseCallBack baseCallBackM30174b = BaseAdapter.this.m30174b();
                if (baseCallBackM30174b == null) {
                    HMSLog.m36986e("BaseAdapter", "timeoutRunnable callBack is null");
                } else {
                    BaseAdapter.this.m30163a(baseCallBackM30174b, coreBaseResponse);
                }
            }
        });
    }

    /* renamed from: a */
    private void m30158a(Context context, RequestHeader requestHeader) {
        Map<String, String> mapFromRequestHeader = HiAnalyticsUtil.getInstance().getMapFromRequestHeader(requestHeader);
        mapFromRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, HiAnalyticsConstant.Direction.REQUEST);
        mapFromRequestHeader.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(requestHeader.getKitSdkVersion())));
        mapFromRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_PHONETYPE, Util.getSystemProperties("ro.logsystem.usertype", ""));
        HiAnalyticsUtil.getInstance().onNewEvent(context, HiAnalyticsConstant.HMS_SDK_BASE_CALL_AIDL, mapFromRequestHeader);
    }

    /* renamed from: a */
    public void m30159a(Context context, ResponseHeader responseHeader) {
        HiAnalyticsUtil.getInstance();
        Map<String, String> mapFromRequestHeader = HiAnalyticsUtil.getMapFromRequestHeader(responseHeader);
        mapFromRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, HiAnalyticsConstant.Direction.RESPONSE);
        mapFromRequestHeader.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(this.f23093j.getKitSdkVersion())));
        mapFromRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_PHONETYPE, Util.getSystemProperties("ro.logsystem.usertype", ""));
        HiAnalyticsUtil.getInstance().onNewEvent(context, HiAnalyticsConstant.HMS_SDK_BASE_CALL_AIDL, mapFromRequestHeader);
    }

    /* renamed from: a */
    public void m30160a(Context context, ResponseHeader responseHeader, long j10) {
        HiAnalyticsUtil.getInstance();
        Map<String, String> mapFromRequestHeader = HiAnalyticsUtil.getMapFromRequestHeader(responseHeader);
        mapFromRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, HiAnalyticsConstant.Direction.RESPONSE);
        mapFromRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_WAITTIME, String.valueOf(j10));
        mapFromRequestHeader.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(this.f23093j.getKitSdkVersion())));
        mapFromRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_PHONETYPE, Util.getSystemProperties("ro.logsystem.usertype", ""));
        HiAnalyticsUtil.getInstance().onNewEvent(context, HiAnalyticsConstant.HMS_SDK_BASE_START_RESOLUTION, mapFromRequestHeader);
    }

    /* renamed from: a */
    public ResponseWrap m30152a(int i10, String str) {
        m30185c(i10);
        ResponseWrap responseWrap = new ResponseWrap(this.f23094k);
        responseWrap.setBody(str);
        return responseWrap;
    }

    /* renamed from: a */
    public String m30155a(int i10) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(AddressConstants.Extras.EXTRA_NAME_ERR_CODE, i10);
        } catch (JSONException e10) {
            HMSLog.m36986e("BaseAdapter", "buildBodyStr failed: " + e10.getMessage());
        }
        return jSONObject.toString();
    }

    /* renamed from: a */
    private void m30170a(String str) {
        this.f23087d = str;
    }

    /* renamed from: a */
    private void m30161a(Parcelable parcelable) {
        this.f23089f = parcelable;
    }

    /* renamed from: a */
    private BaseCallBack m30150a() {
        return this.f23090g;
    }

    /* renamed from: a */
    private void m30171a(String str, String str2, Parcelable parcelable, BaseCallBack baseCallBack) {
        m30170a(str);
        m30180b(str2);
        m30161a(parcelable);
        m30179b(baseCallBack);
    }

    /* renamed from: a */
    public boolean m30172a(Intent intent, BaseCallBack baseCallBack) {
        if (!intent.hasExtra(CommonCode.MapKey.PRIVACY_STATEMENT_CONFIRM_RESULT)) {
            return false;
        }
        int intExtra = intent.getIntExtra(CommonCode.MapKey.PRIVACY_STATEMENT_CONFIRM_RESULT, 1001);
        if (intExtra == 1001) {
            HMSLog.m36988i("BaseAdapter", "privacy_statement_confirm_result agreed: " + intExtra + ", replay request");
            m30197i();
            return true;
        }
        HMSLog.m36988i("BaseAdapter", "privacy_statement_confirm_result rejected: " + intExtra);
        baseCallBack.onError(m30152a(CommonCode.BusInterceptor.PRIVACY_CNCEL_ERROR_CODE, m30155a(CommonCode.BusInterceptor.PRIVACY_CNCEL_ERROR_CODE)).toJson());
        return true;
    }
}
