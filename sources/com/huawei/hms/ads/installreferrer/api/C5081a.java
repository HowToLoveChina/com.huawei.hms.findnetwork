package com.huawei.hms.ads.installreferrer.api;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import com.huawei.hms.ads.installreferrer.C5078a;
import com.huawei.hms.ads.installreferrer.aidl.IPPSChannelInfoService;
import com.huawei.hms.ads.installreferrer.commons.LogUtil;
import com.huawei.openalliance.p169ad.constant.OuterChannelInfo;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import java.io.IOException;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.ads.installreferrer.api.a */
/* loaded from: classes8.dex */
class C5081a extends InstallReferrerClient {

    /* renamed from: a */
    private int f23217a = 0;

    /* renamed from: b */
    private final Context f23218b;

    /* renamed from: c */
    private IPPSChannelInfoService f23219c;

    /* renamed from: d */
    private ServiceConnection f23220d;

    /* renamed from: com.huawei.hms.ads.installreferrer.api.a$a */
    public final class a implements ServiceConnection {

        /* renamed from: b */
        private final InstallReferrerStateListener f23222b;

        private a(InstallReferrerStateListener installReferrerStateListener) throws C5078a {
            if (installReferrerStateListener == null) {
                throw new C5078a(" InstallReferrerServiceConnection listener is null");
            }
            this.f23222b = installReferrerStateListener;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                LogUtil.logInfo("ReferrerClientImpl", "onServiceConnected");
                C5081a.this.f23219c = IPPSChannelInfoService.Stub.asInterface(iBinder);
                C5081a.this.f23217a = 2;
                this.f23222b.onInstallReferrerSetupFinished(0);
            } catch (Throwable unused) {
                LogUtil.logWarn("ReferrerClientImpl", "service err");
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            LogUtil.logWarn("ReferrerClientImpl", "onServiceDisconnected");
            C5081a.this.f23219c = null;
            C5081a.this.f23217a = 0;
            this.f23222b.onInstallReferrerServiceDisconnected();
        }
    }

    public C5081a(Context context) {
        this.f23218b = context.getApplicationContext();
    }

    @Override // com.huawei.hms.ads.installreferrer.api.InstallReferrerClient
    public void endConnection() {
        String str;
        this.f23217a = 3;
        if (this.f23220d != null) {
            LogUtil.logInfo("ReferrerClientImpl", "endConnection unbinding from service");
            try {
                this.f23218b.unbindService(this.f23220d);
            } catch (IllegalArgumentException unused) {
                str = "endConnection service not binding";
                LogUtil.logWarn("ReferrerClientImpl", str);
                this.f23220d = null;
                this.f23219c = null;
            } catch (Exception unused2) {
                str = "endConnection Exception";
                LogUtil.logWarn("ReferrerClientImpl", str);
                this.f23220d = null;
                this.f23219c = null;
            }
            this.f23220d = null;
        }
        this.f23219c = null;
    }

    @Override // com.huawei.hms.ads.installreferrer.api.InstallReferrerClient
    public ReferrerDetails getInstallReferrer() throws IOException, RemoteException {
        if (!isReady()) {
            throw new IOException("getInstallReferrer service not connected");
        }
        try {
            String channelInfo = this.f23219c.getChannelInfo();
            if (TextUtils.isEmpty(channelInfo)) {
                throw new IOException("getInstallReferrer not found installreferrer");
            }
            return m30325a(channelInfo);
        } catch (RemoteException e10) {
            LogUtil.logWarn("ReferrerClientImpl", "getInstallReferrer RemoteException");
            this.f23217a = 0;
            throw e10;
        } catch (JSONException unused) {
            LogUtil.logWarn("ReferrerClientImpl", "getInstallReferrer JSONException");
            this.f23217a = 0;
            throw new IOException("getInstallReferrer JSONException");
        }
    }

    @Override // com.huawei.hms.ads.installreferrer.api.InstallReferrerClient
    public boolean isReady() {
        return (this.f23217a != 2 || this.f23219c == null || this.f23220d == null) ? false : true;
    }

    @Override // com.huawei.hms.ads.installreferrer.api.InstallReferrerClient
    public int setInstallReferrer(String str, String str2, long j10, long j11) throws JSONException, RemoteException, IOException {
        String str3;
        if (TextUtils.isEmpty(str)) {
            str3 = "setInstallReferrer pkgName is empty";
        } else {
            if (!TextUtils.isEmpty(str2)) {
                if (!isReady()) {
                    LogUtil.logWarn("ReferrerClientImpl", "setInstallReferrer Service not connected");
                    throw new IOException("setInstallReferrer Service not connected");
                }
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("channelId", str2);
                    jSONObject.put("clickTimestamp", j10);
                    jSONObject.put("installTimestamp", j11);
                    this.f23219c.setChannelInfo(str, jSONObject.toString(), 0);
                    return 0;
                } catch (RemoteException e10) {
                    LogUtil.logWarn("ReferrerClientImpl", "setInstallReferrer RemoteException");
                    this.f23217a = 0;
                    throw e10;
                } catch (JSONException unused) {
                    LogUtil.logWarn("ReferrerClientImpl", "setInstallReferrer JSONException");
                    throw new IOException("Parse json exception");
                }
            }
            str3 = "setInstallReferrer referrer  is empty";
        }
        LogUtil.logWarn("ReferrerClientImpl", str3);
        return -1;
    }

    @Override // com.huawei.hms.ads.installreferrer.api.InstallReferrerClient
    public void startConnection(InstallReferrerStateListener installReferrerStateListener) {
        ServiceInfo serviceInfo;
        if (isReady()) {
            LogUtil.logInfo("ReferrerClientImpl", "startConnection service connection is conneted");
            installReferrerStateListener.onInstallReferrerSetupFinished(0);
            return;
        }
        int i10 = this.f23217a;
        if (i10 == 1) {
            LogUtil.logWarn("ReferrerClientImpl", "startConnection is connecting");
            installReferrerStateListener.onInstallReferrerSetupFinished(3);
            return;
        }
        if (i10 == 3) {
            LogUtil.logWarn("ReferrerClientImpl", "startConnection is closed");
            installReferrerStateListener.onInstallReferrerSetupFinished(3);
            return;
        }
        String str = this.isTest ? "com.huawei.pps.hms.test" : "com.huawei.hwid";
        LogUtil.logInfo("ReferrerClientImpl", "startConnection starting service setup");
        try {
            this.f23220d = new a(installReferrerStateListener);
        } catch (C5078a unused) {
            LogUtil.logInfo("ReferrerClientImpl", "create service connection error");
        }
        Intent intent = new Intent("com.huawei.android.hms.CHANNEL_SERVICE");
        intent.setPackage(str);
        List<ResolveInfo> listQueryIntentServices = this.f23218b.getPackageManager().queryIntentServices(intent, 0);
        if (listQueryIntentServices == null || listQueryIntentServices.isEmpty() || (serviceInfo = listQueryIntentServices.get(0).serviceInfo) == null) {
            this.f23217a = 0;
            LogUtil.logWarn("ReferrerClientImpl", "query service not found");
            installReferrerStateListener.onInstallReferrerSetupFinished(2);
            return;
        }
        String str2 = serviceInfo.packageName;
        String str3 = serviceInfo.name;
        if (!str.equals(str2) || str3 == null) {
            LogUtil.logWarn("ReferrerClientImpl", "bind service invalid, service not found");
            this.f23217a = 0;
            installReferrerStateListener.onInstallReferrerSetupFinished(2);
        } else {
            if (this.f23218b.bindService(new Intent(intent), this.f23220d, 1)) {
                LogUtil.logInfo("ReferrerClientImpl", "bind service success");
                return;
            }
            LogUtil.logWarn("ReferrerClientImpl", "bind service fail");
            this.f23217a = 0;
            installReferrerStateListener.onInstallReferrerSetupFinished(1);
        }
    }

    /* renamed from: a */
    private ReferrerDetails m30325a(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        String strOptString = jSONObject.optString(OuterChannelInfo.CHANNEL_INFO);
        long jOptLong = jSONObject.optLong("installTimestamp", 0L);
        long jOptLong2 = jSONObject.optLong("clickTimestamp", 0L);
        String strOptString2 = jSONObject.optString("grsCountryCode");
        String strOptString3 = jSONObject.optString(FaqConstants.FAQ_CHANNEL);
        ReferrerDetails referrerDetails = new ReferrerDetails(strOptString, jOptLong2, jOptLong);
        referrerDetails.setGrsCountryCode(strOptString2);
        referrerDetails.setInstallChannel(strOptString3);
        return referrerDetails;
    }
}
