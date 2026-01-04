package com.huawei.hms.opendevice;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.aaid.HmsInstanceId;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.entity.TokenReq;
import com.huawei.hms.aaid.entity.TokenResp;
import com.huawei.hms.aaid.entity.TokenResult;
import com.huawei.hms.aaid.task.PushClient;
import com.huawei.hms.aaid.threads.AsyncExec;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
import p208cq.C8941i;

/* renamed from: com.huawei.hms.opendevice.g */
/* loaded from: classes8.dex */
public class C6269g extends TaskApiCall<PushClient, TokenResult> {

    /* renamed from: a */
    private Context f29580a;

    /* renamed from: b */
    private TokenReq f29581b;

    /* renamed from: com.huawei.hms.opendevice.g$a */
    public class a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f29582a;

        /* renamed from: b */
        final /* synthetic */ String f29583b;

        public a(String str, String str2) {
            this.f29582a = str;
            this.f29583b = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (C6271i.m36434a(C6269g.this.f29580a).m36438b(this.f29582a).equals(this.f29583b)) {
                return;
            }
            HMSLog.m36988i(HmsInstanceId.TAG, "receive a new token, refresh the local token");
            C6271i.m36434a(C6269g.this.f29580a).m36439b(this.f29582a, this.f29583b);
        }
    }

    public C6269g(String str, TokenReq tokenReq, Context context, String str2) {
        super(str, JsonUtil.createJsonString(tokenReq), str2);
        this.f29580a = context;
        this.f29581b = tokenReq;
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getMinApkVersion() {
        return this.f29581b.isMultiSender() ? 50004300 : 30000000;
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void doExecute(PushClient pushClient, ResponseErrorCode responseErrorCode, String str, C8941i<TokenResult> c8941i) {
        if (responseErrorCode.getErrorCode() != 0) {
            HMSLog.m36986e(HmsInstanceId.TAG, "TokenTask failed, ErrorCode:" + responseErrorCode.getErrorCode());
            m36427a(responseErrorCode, c8941i);
        } else {
            TokenResp tokenResp = (TokenResp) JsonUtil.jsonToEntity(str, new TokenResp());
            ErrorEnum errorEnumFromCode = ErrorEnum.fromCode(tokenResp.getRetCode());
            if (errorEnumFromCode != ErrorEnum.SUCCESS) {
                c8941i.m56657c(errorEnumFromCode.toApiException());
                HMSLog.m36986e(HmsInstanceId.TAG, "TokenTask failed, StatusCode:" + errorEnumFromCode.getExternalCode());
            } else {
                TokenResult tokenResult = new TokenResult();
                tokenResult.setToken(tokenResp.getToken());
                tokenResult.setBelongId(tokenResp.getBelongId());
                tokenResult.setRetCode(ErrorEnum.fromCode(tokenResp.getRetCode()).getExternalCode());
                c8941i.m56658d(tokenResult);
                String token = tokenResp.getToken();
                if (TextUtils.isEmpty(token)) {
                    HMSLog.m36988i(HmsInstanceId.TAG, "GetTokenTask receive an empty token, please check onNewToken callback method.");
                    C6270h.m36431a(pushClient.getContext(), getUri(), responseErrorCode);
                    return;
                }
                m36428a(token, this.f29581b.getSubjectId());
            }
        }
        C6270h.m36431a(pushClient.getContext(), getUri(), responseErrorCode);
    }

    /* renamed from: a */
    private void m36427a(ResponseErrorCode responseErrorCode, C8941i<TokenResult> c8941i) {
        ErrorEnum errorEnumFromCode = ErrorEnum.fromCode(responseErrorCode.getErrorCode());
        if (errorEnumFromCode != ErrorEnum.ERROR_UNKNOWN) {
            c8941i.m56657c(errorEnumFromCode.toApiException());
        } else {
            c8941i.m56657c(new ApiException(new Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason())));
        }
    }

    /* renamed from: a */
    private void m36428a(String str, String str2) {
        AsyncExec.submitSeqIO(new a(str2, str));
    }
}
