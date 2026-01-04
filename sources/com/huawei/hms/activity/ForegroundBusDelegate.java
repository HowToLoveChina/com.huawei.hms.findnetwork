package com.huawei.hms.activity;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.huawei.hms.activity.internal.BusResponseCallback;
import com.huawei.hms.activity.internal.BusResponseResult;
import com.huawei.hms.activity.internal.ForegroundBusResponseMgr;
import com.huawei.hms.activity.internal.ForegroundInnerHeader;
import com.huawei.hms.adapter.AvailableAdapter;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.internal.RequestHeader;
import com.huawei.hms.common.internal.ResponseHeader;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.hms.support.hianalytics.HiAnalyticsUtil;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.IntentUtil;
import com.huawei.hms.utils.JsonUtil;
import com.huawei.hms.utils.UIUtil;
import com.huawei.hms.utils.Util;
import java.lang.ref.WeakReference;
import java.util.Map;

/* loaded from: classes8.dex */
public class ForegroundBusDelegate implements IBridgeActivityDelegate {
    public static final String HMS_FOREGROUND_REQ_BODY = "HMS_FOREGROUND_REQ_BODY";
    public static final String HMS_FOREGROUND_REQ_HEADER = "HMS_FOREGROUND_REQ_HEADER";
    public static final String HMS_FOREGROUND_REQ_INNER = "HMS_FOREGROUND_REQ_INNER";
    public static final String HMS_FOREGROUND_RESP_HEADER = "HMS_FOREGROUND_RESP_HEADER";
    public static final String INNER_PKG_NAME = "INNER_PACKAGE_NAME";

    /* renamed from: a */
    private RequestHeader f23055a;

    /* renamed from: b */
    private String f23056b;

    /* renamed from: c */
    private ForegroundInnerHeader f23057c = new ForegroundInnerHeader();

    /* renamed from: d */
    private ResponseHeader f23058d;

    /* renamed from: e */
    private WeakReference<Activity> f23059e;

    /* renamed from: f */
    private boolean f23060f;

    /* renamed from: com.huawei.hms.activity.ForegroundBusDelegate$b */
    public class C5050b implements AvailableAdapter.AvailableCallBack {
        private C5050b() {
        }

        @Override // com.huawei.hms.adapter.AvailableAdapter.AvailableCallBack
        public void onComplete(int i10) {
            if (i10 == 0) {
                ForegroundBusDelegate.this.m30143h();
            } else {
                HMSLog.m36988i("ForegroundBusDelegate", "version check failed");
                ForegroundBusDelegate.this.m30131a(0, "apk version is invalid");
            }
        }
    }

    /* renamed from: b */
    private BusResponseCallback m30136b(String str) {
        return ForegroundBusResponseMgr.getInstance().get(str);
    }

    /* renamed from: c */
    private void m30138c() {
        if (this.f23055a != null) {
            m30135a(HiAnalyticsConstant.HMS_SDK_BASE_ACTIVITY_STARTED);
        }
    }

    /* renamed from: d */
    private void m30139d() {
        m30135a(HiAnalyticsConstant.HMS_SDK_BASE_START_CORE_ACTIVITY);
    }

    /* renamed from: e */
    private void m30140e() {
        if (m30142g() == null) {
            HMSLog.m36986e("ForegroundBusDelegate", "checkMinVersion failed, activity must not be null.");
            m30131a(0, "checkMinVersion failed, activity must not be null.");
            return;
        }
        if (this.f23060f) {
            m30143h();
            return;
        }
        if (!Util.isAvailableLibExist(m30142g().getApplicationContext())) {
            if (HuaweiApiAvailability.getInstance().isHuaweiMobileServicesAvailable(m30142g().getApplicationContext(), this.f23057c.getApkVersion()) == 0) {
                m30143h();
                return;
            } else {
                HMSLog.m36986e("ForegroundBusDelegate", "checkMinVersion failed, and no available lib exists.");
                m30131a(0, "apk version is invalid");
                return;
            }
        }
        C5050b c5050b = new C5050b();
        AvailableAdapter availableAdapter = new AvailableAdapter(this.f23057c.getApkVersion());
        int iIsHuaweiMobileServicesAvailable = availableAdapter.isHuaweiMobileServicesAvailable(m30142g());
        if (iIsHuaweiMobileServicesAvailable == 0) {
            c5050b.onComplete(iIsHuaweiMobileServicesAvailable);
        } else if (availableAdapter.isUserResolvableError(iIsHuaweiMobileServicesAvailable)) {
            m30132a(m30142g(), availableAdapter, c5050b);
        } else {
            c5050b.onComplete(iIsHuaweiMobileServicesAvailable);
        }
    }

    /* renamed from: f */
    private void m30141f() {
        Activity activityM30142g = m30142g();
        if (activityM30142g == null || activityM30142g.isFinishing()) {
            return;
        }
        activityM30142g.finish();
    }

    /* renamed from: g */
    private Activity m30142g() {
        WeakReference<Activity> weakReference = this.f23059e;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m30143h() {
        HMSLog.m36988i("ForegroundBusDelegate", "startApkHubActivity");
        Activity activityM30142g = m30142g();
        if (activityM30142g == null) {
            HMSLog.m36986e("ForegroundBusDelegate", "startApkHubActivity but activity is null");
            return;
        }
        String packageName = this.f23060f ? activityM30142g.getPackageName() : HMSPackageManager.getInstance(activityM30142g.getApplicationContext()).getHMSPackageNameForMultiService();
        if (TextUtils.isEmpty(packageName)) {
            HMSLog.m36986e("ForegroundBusDelegate", "hmsPackageName is null, Service is invalid.");
            m30131a(0, "hmsPackageName is null, Service is invalid.");
            return;
        }
        Intent intent = new Intent(this.f23057c.getAction());
        intent.putExtra(HMS_FOREGROUND_REQ_BODY, this.f23056b);
        try {
            intent.setPackage(packageName);
        } catch (IllegalArgumentException unused) {
            HMSLog.m36986e("ForegroundBusDelegate", "IllegalArgumentException when startApkHubActivity intent.setPackage");
        }
        intent.putExtra("intent.extra.isfullscreen", UIUtil.isActivityFullscreen(activityM30142g));
        intent.setClassName(packageName, "com.huawei.hms.core.activity.UiJumpActivity");
        intent.putExtra(HMS_FOREGROUND_REQ_HEADER, this.f23055a.toJson());
        intent.putExtra("intent.extra.hms.core.DELEGATE_NAME", "com.huawei.hms.core.activity.ForegroundBus");
        try {
            m30137b();
            activityM30142g.startActivityForResult(intent, 431057);
        } catch (ActivityNotFoundException e10) {
            HMSLog.m36987e("ForegroundBusDelegate", "Launch sign in Intent failed. hms is probably being updated：", e10);
            m30131a(0, "launch bus intent failed");
        }
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public int getRequestCode() {
        return 431057;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityCreate(Activity activity) {
        if (activity == null) {
            HMSLog.m36986e("ForegroundBusDelegate", "activity is null");
            m30131a(0, "activity is null");
            return;
        }
        if (activity.isFinishing()) {
            HMSLog.m36986e("ForegroundBusDelegate", "activity is finishing");
            m30131a(0, "activity is finishing");
            return;
        }
        this.f23059e = new WeakReference<>(activity);
        try {
            Intent intent = activity.getIntent();
            if (intent == null) {
                m30131a(0, "intent is invalid");
                return;
            }
            String stringExtra = intent.getStringExtra(HMS_FOREGROUND_REQ_HEADER);
            RequestHeader requestHeader = new RequestHeader();
            this.f23055a = requestHeader;
            if (!requestHeader.fromJson(stringExtra)) {
                m30131a(0, "header is invalid");
                return;
            }
            this.f23056b = intent.getStringExtra(HMS_FOREGROUND_REQ_BODY);
            ForegroundInnerHeader foregroundInnerHeader = this.f23057c;
            if (foregroundInnerHeader == null) {
                m30131a(0, "inner header is invalid");
                return;
            }
            foregroundInnerHeader.fromJson(intent.getStringExtra(HMS_FOREGROUND_REQ_INNER));
            if (TextUtils.isEmpty(this.f23055a.getApiName())) {
                m30131a(0, "action is invalid");
                return;
            }
            m30129a();
            if (!TextUtils.isEmpty(intent.getStringExtra(INNER_PKG_NAME))) {
                HMSLog.m36988i("ForegroundBusDelegate", "isUseInnerHms: true");
                this.f23060f = true;
            }
            m30140e();
        } catch (Throwable th2) {
            HMSLog.m36986e("ForegroundBusDelegate", "ForegroundBusDelegate getStringExtra error:" + th2.getMessage());
            m30131a(0, "ForegroundBusDelegate getStringExtra error:" + th2.getMessage());
        }
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityDestroy() {
        m30138c();
        this.f23059e = null;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public boolean onBridgeActivityResult(int i10, int i11, Intent intent) throws IllegalArgumentException {
        String stringExtra;
        if (i10 != 431057) {
            return false;
        }
        if (intent != null && intent.hasExtra(HMS_FOREGROUND_RESP_HEADER)) {
            try {
                stringExtra = intent.getStringExtra(HMS_FOREGROUND_RESP_HEADER);
            } catch (Throwable unused) {
                HMSLog.m36989w("ForegroundBusDelegate", "exception occur, HMS_FOREGROUND_RESP_HEADER get failed.");
                stringExtra = "";
            }
            ResponseHeader responseHeader = new ResponseHeader();
            this.f23058d = responseHeader;
            JsonUtil.jsonToEntity(stringExtra, responseHeader);
        }
        m30139d();
        BusResponseCallback busResponseCallbackM30136b = m30136b(this.f23057c.getResponseCallbackKey());
        if (busResponseCallbackM30136b == null) {
            m30130a(i11, intent);
            return true;
        }
        BusResponseResult busResponseResultSucceedReturn = busResponseCallbackM30136b.succeedReturn(this.f23059e.get(), i11, intent);
        if (busResponseResultSucceedReturn == null) {
            m30130a(i11, intent);
            return true;
        }
        m30130a(busResponseResultSucceedReturn.getCode(), busResponseResultSucceedReturn.getIntent());
        return true;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeConfigurationChanged() {
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onKeyUp(int i10, KeyEvent keyEvent) {
    }

    /* renamed from: b */
    private void m30137b() {
        Map<String, String> mapFromForegroundRequestHeader = HiAnalyticsUtil.getInstance().getMapFromForegroundRequestHeader(this.f23055a);
        mapFromForegroundRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, HiAnalyticsConstant.Direction.REQUEST);
        mapFromForegroundRequestHeader.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(this.f23055a.getKitSdkVersion())));
        if (m30142g() != null) {
            HiAnalyticsUtil.getInstance().onNewEvent(m30142g().getApplicationContext(), HiAnalyticsConstant.HMS_SDK_BASE_START_CORE_ACTIVITY, mapFromForegroundRequestHeader);
        }
    }

    /* renamed from: a */
    private void m30130a(int i10, Intent intent) {
        HMSLog.m36988i("ForegroundBusDelegate", "succeedReturn");
        Activity activityM30142g = m30142g();
        if (activityM30142g == null) {
            return;
        }
        activityM30142g.setResult(i10, IntentUtil.modifyIntentBehaviorsSafe(intent));
        m30141f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m30131a(int i10, String str) {
        BusResponseResult busResponseResultInnerError;
        HMSLog.m36986e("ForegroundBusDelegate", str);
        Activity activityM30142g = m30142g();
        if (activityM30142g == null) {
            return;
        }
        BusResponseCallback busResponseCallbackM30136b = m30136b(this.f23057c.getResponseCallbackKey());
        if (busResponseCallbackM30136b == null || (busResponseResultInnerError = busResponseCallbackM30136b.innerError(this.f23059e.get(), i10, str)) == null) {
            activityM30142g.setResult(0);
        } else {
            activityM30142g.setResult(busResponseResultInnerError.getCode(), IntentUtil.modifyIntentBehaviorsSafe(busResponseResultInnerError.getIntent()));
        }
        m30141f();
    }

    /* renamed from: a */
    private static void m30132a(Activity activity, AvailableAdapter availableAdapter, AvailableAdapter.AvailableCallBack availableCallBack) {
        if (activity == null) {
            HMSLog.m36988i("ForegroundBusDelegate", "null activity, could not start resolution intent");
        }
        availableAdapter.startResolution(activity, availableCallBack);
    }

    /* renamed from: a */
    private void m30129a() {
        Map<String, String> mapFromForegroundRequestHeader = HiAnalyticsUtil.getInstance().getMapFromForegroundRequestHeader(this.f23055a);
        mapFromForegroundRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, HiAnalyticsConstant.Direction.REQUEST);
        mapFromForegroundRequestHeader.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(this.f23055a.getKitSdkVersion())));
        if (m30142g() != null) {
            HiAnalyticsUtil.getInstance().onNewEvent(m30142g().getApplicationContext(), HiAnalyticsConstant.HMS_SDK_BASE_ACTIVITY_STARTED, mapFromForegroundRequestHeader);
        }
    }

    /* renamed from: a */
    private void m30135a(String str) {
        Map<String, String> mapFromForegroundRequestHeader = HiAnalyticsUtil.getInstance().getMapFromForegroundRequestHeader(this.f23055a);
        mapFromForegroundRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, HiAnalyticsConstant.Direction.RESPONSE);
        mapFromForegroundRequestHeader.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(this.f23055a.getKitSdkVersion())));
        ResponseHeader responseHeader = this.f23058d;
        if (responseHeader != null) {
            mapFromForegroundRequestHeader.put("statusCode", String.valueOf(responseHeader.getStatusCode()));
            mapFromForegroundRequestHeader.put("result", String.valueOf(this.f23058d.getErrorCode()));
        }
        if (m30142g() != null) {
            HiAnalyticsUtil.getInstance().onNewEvent(m30142g().getApplicationContext(), str, mapFromForegroundRequestHeader);
        }
    }
}
