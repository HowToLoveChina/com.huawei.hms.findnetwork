package com.huawei.hms.common.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Parcelable;
import android.text.TextUtils;
import com.huawei.hms.adapter.BaseAdapter;
import com.huawei.hms.common.internal.AnyClient;
import com.huawei.hms.common.internal.BaseHmsClient;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.huawei.hms.support.log.HMSLog;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public abstract class HmsClient extends BaseHmsClient implements AnyClient {
    public HmsClient(Context context, ClientSettings clientSettings, BaseHmsClient.OnConnectionFailedListener onConnectionFailedListener, BaseHmsClient.ConnectionCallbacks connectionCallbacks) {
        super(context, clientSettings, onConnectionFailedListener, connectionCallbacks);
    }

    @Override // com.huawei.hms.common.internal.AnyClient
    public void post(IMessageEntity iMessageEntity, String str, AnyClient.CallBack callBack) {
        if (callBack == null) {
            HMSLog.m36986e("HmsClient", "callback is invalid, discard.");
            return;
        }
        if (!(iMessageEntity instanceof RequestHeader) || str == null) {
            HMSLog.m36986e("HmsClient", "arguments is invalid.");
            callBack.onCallback(new ResponseHeader(1, CommonCode.ErrorCode.ARGUMENTS_INVALID, "Args is invalid"), new JSONObject().toString());
            return;
        }
        if (!isConnected()) {
            HMSLog.m36988i("HmsClient", "No connection now, the connection status:" + getConnectionStatus());
            if (getConnectionStatus() != 6) {
                HMSLog.m36986e("HmsClient", "post failed for not connected.");
                callBack.onCallback(new ResponseHeader(1, CommonCode.ErrorCode.INTERNAL_ERROR, "Not Connected"), new JSONObject().toString());
                return;
            } else {
                HMSLog.m36988i("HmsClient", "in timeout-disconnect status, need to bind again.");
                m30686a();
            }
        }
        RequestHeader requestHeader = (RequestHeader) iMessageEntity;
        HMSLog.m36988i("HmsClient", "post msg " + requestHeader);
        Activity cpActivity = getClientSettings().getCpActivity();
        boolean z10 = cpActivity == null;
        if (z10) {
            HMSLog.m36988i("HmsClient", "Activity is null for " + getClientSettings().getAppID());
        }
        (z10 ? new BaseAdapter(this) : new BaseAdapter(this, cpActivity)).baseRequest(requestHeader.toJson(), str, requestHeader.getParcelable(), new C5150a(this, callBack));
    }

    public void updateSessionId(String str) {
        if (TextUtils.isEmpty(this.sessionId)) {
            this.sessionId = str;
        }
    }

    /* renamed from: com.huawei.hms.common.internal.HmsClient$a */
    public static class C5150a implements BaseAdapter.BaseCallBack {

        /* renamed from: a */
        private final AnyClient.CallBack f23495a;

        /* renamed from: b */
        private final WeakReference<HmsClient> f23496b;

        public C5150a(HmsClient hmsClient, AnyClient.CallBack callBack) {
            this.f23495a = callBack;
            this.f23496b = new WeakReference<>(hmsClient);
        }

        /* renamed from: a */
        private void m30690a(String str) {
            HmsClient hmsClient = this.f23496b.get();
            if (hmsClient != null) {
                hmsClient.updateSessionId(str);
            }
        }

        @Override // com.huawei.hms.adapter.BaseAdapter.BaseCallBack
        public void onComplete(String str, String str2, Parcelable parcelable) {
            if (parcelable == null) {
                m30691a(str, str2);
            } else {
                m30692a(str, str2, parcelable);
            }
        }

        @Override // com.huawei.hms.adapter.BaseAdapter.BaseCallBack
        public void onError(String str) {
            if (this.f23495a == null) {
                return;
            }
            ResponseWrap responseWrap = new ResponseWrap(new ResponseHeader());
            if (!responseWrap.fromJson(str)) {
                this.f23495a.onCallback(new ResponseHeader(1, CommonCode.ErrorCode.ARGUMENTS_INVALID, "response header json error"), new JSONObject().toString());
                return;
            }
            HMSLog.m36988i("HmsClient", "receive msg " + responseWrap);
            ResponseHeader responseHeader = responseWrap.getResponseHeader();
            m30690a(responseHeader.getSessionId());
            this.f23495a.onCallback(responseHeader, responseWrap.getBody());
        }

        /* renamed from: a */
        private void m30691a(String str, String str2) {
            if (this.f23495a == null) {
                return;
            }
            ResponseHeader responseHeader = new ResponseHeader();
            if (responseHeader.fromJson(str)) {
                HMSLog.m36988i("HmsClient", "receive msg " + responseHeader);
                m30690a(responseHeader.getSessionId());
                this.f23495a.onCallback(responseHeader, str2);
                return;
            }
            this.f23495a.onCallback(new ResponseHeader(1, CommonCode.ErrorCode.ARGUMENTS_INVALID, "response header json error"), new JSONObject().toString());
        }

        /* renamed from: a */
        private void m30692a(String str, String str2, Parcelable parcelable) {
            if (this.f23495a == null) {
                return;
            }
            ResponseHeader responseHeader = new ResponseHeader();
            if (responseHeader.fromJson(str)) {
                responseHeader.setParcelable(parcelable);
                HMSLog.m36988i("HmsClient", "receive msg " + responseHeader);
                m30690a(responseHeader.getSessionId());
                this.f23495a.onCallback(responseHeader, str2);
                return;
            }
            this.f23495a.onCallback(new ResponseHeader(1, CommonCode.ErrorCode.ARGUMENTS_INVALID, "response header json error"), new JSONObject().toString());
        }
    }
}
