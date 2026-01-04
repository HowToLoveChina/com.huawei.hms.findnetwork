package com.huawei.hms.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.huawei.hms.activity.internal.BusResponseCallback;
import com.huawei.hms.activity.internal.ForegroundBusResponseMgr;
import com.huawei.hms.activity.internal.ForegroundInnerHeader;
import com.huawei.hms.common.internal.RequestHeader;
import com.huawei.hms.common.internal.TransactionIdCreater;
import com.huawei.hms.support.api.entity.core.CoreNaming;
import com.huawei.hms.utils.Util;

/* loaded from: classes8.dex */
public class ForegroundIntentBuilder {

    /* renamed from: a */
    private Activity f23062a;

    /* renamed from: b */
    private RequestHeader f23063b;

    /* renamed from: c */
    private String f23064c;

    /* renamed from: d */
    private ForegroundInnerHeader f23065d;

    /* renamed from: e */
    private String f23066e;

    /* renamed from: f */
    private Context f23067f;

    public ForegroundIntentBuilder(Activity activity) throws IllegalArgumentException {
        if (activity == null) {
            throw new IllegalArgumentException("listener must not be null.");
        }
        this.f23062a = activity;
        RequestHeader requestHeader = new RequestHeader();
        this.f23063b = requestHeader;
        requestHeader.setSdkVersion(61300303);
        this.f23064c = "";
        ForegroundInnerHeader foregroundInnerHeader = new ForegroundInnerHeader();
        this.f23065d = foregroundInnerHeader;
        foregroundInnerHeader.setApkVersion(30000000);
    }

    public static void registerResponseCallback(String str, BusResponseCallback busResponseCallback) {
        ForegroundBusResponseMgr.getInstance().registerObserver(str, busResponseCallback);
    }

    public static void unregisterResponseCallback(String str) {
        ForegroundBusResponseMgr.getInstance().unRegisterObserver(str);
    }

    public Intent build() {
        String packageName;
        String appId;
        Intent intentStartBridgeActivity = BridgeActivity.getIntentStartBridgeActivity(this.f23062a, ForegroundBusDelegate.class.getName());
        Context context = this.f23067f;
        if (context != null) {
            packageName = context.getPackageName();
            appId = Util.getAppId(this.f23067f);
        } else {
            packageName = this.f23062a.getPackageName();
            appId = Util.getAppId(this.f23062a);
        }
        if (this.f23063b.getAppID() == null) {
            this.f23063b.setAppID(appId + "|");
        } else {
            this.f23063b.setAppID(appId + "|" + this.f23063b.getAppID());
        }
        if (TextUtils.isEmpty(this.f23063b.getTransactionId())) {
            RequestHeader requestHeader = this.f23063b;
            requestHeader.setTransactionId(TransactionIdCreater.getId(requestHeader.getAppID(), CoreNaming.HUBREQUEST));
        }
        this.f23063b.setPkgName(packageName);
        intentStartBridgeActivity.putExtra(ForegroundBusDelegate.HMS_FOREGROUND_REQ_HEADER, this.f23063b.toJson());
        intentStartBridgeActivity.putExtra(ForegroundBusDelegate.HMS_FOREGROUND_REQ_BODY, this.f23064c);
        intentStartBridgeActivity.putExtra(ForegroundBusDelegate.HMS_FOREGROUND_REQ_INNER, this.f23065d.toJson());
        if (!TextUtils.isEmpty(this.f23066e)) {
            intentStartBridgeActivity.putExtra(ForegroundBusDelegate.INNER_PKG_NAME, this.f23066e);
        }
        return intentStartBridgeActivity;
    }

    public ForegroundIntentBuilder setAction(String str) {
        this.f23063b.setApiName(str);
        return this;
    }

    public ForegroundIntentBuilder setApiLevel(int i10) {
        this.f23063b.setApiLevel(i10);
        return this;
    }

    public ForegroundIntentBuilder setApplicationContext(Context context) {
        this.f23067f = context;
        return this;
    }

    public ForegroundIntentBuilder setInnerHms() {
        this.f23066e = this.f23062a.getPackageName();
        return this;
    }

    public ForegroundIntentBuilder setKitSdkVersion(int i10) {
        this.f23063b.setKitSdkVersion(i10);
        return this;
    }

    public ForegroundIntentBuilder setMinApkVersion(int i10) {
        this.f23065d.setApkVersion(i10);
        return this;
    }

    public ForegroundIntentBuilder setRequestBody(String str) {
        this.f23064c = str;
        return this;
    }

    public ForegroundIntentBuilder setResponseCallback(String str, BusResponseCallback busResponseCallback) {
        this.f23065d.setResponseCallbackKey(str);
        ForegroundBusResponseMgr.getInstance().registerObserver(str, busResponseCallback);
        return this;
    }

    public ForegroundIntentBuilder setServiceName(String str) {
        this.f23063b.setSrvName(str);
        return this;
    }

    public ForegroundIntentBuilder setSubAppId(String str) {
        this.f23063b.setAppID(str);
        return this;
    }

    public ForegroundIntentBuilder setTransactionId(String str) {
        this.f23063b.setTransactionId(str);
        return this;
    }

    public ForegroundIntentBuilder setResponseCallback(String str) {
        this.f23065d.setResponseCallbackKey(str);
        return this;
    }
}
