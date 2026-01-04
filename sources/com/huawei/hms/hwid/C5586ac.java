package com.huawei.hms.hwid;

import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.support.hwid.result.AuthHuaweiId;

/* renamed from: com.huawei.hms.hwid.ac */
/* loaded from: classes8.dex */
public class C5586ac extends TaskApiCall<C5623u, AuthHuaweiId> {
    public C5586ac(String str, String str2, String str3) {
        super(str, str2, str3);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00cb  */
    @Override // com.huawei.hms.common.internal.TaskApiCall
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void doExecute(com.huawei.hms.hwid.C5623u r17, com.huawei.hms.common.internal.ResponseErrorCode r18, java.lang.String r19, p208cq.C8941i<com.huawei.hms.support.hwid.result.AuthHuaweiId> r20) {
        /*
            r16 = this;
            r0 = r20
            r1 = 1
            java.lang.String r2 = "[HUAWEIIDSDK]SignInTaskApiCall"
            if (r18 != 0) goto L1c
            java.lang.String r3 = "response is null."
            com.huawei.hms.hwid.C5602as.m32910b(r2, r3, r1)
            com.huawei.hms.support.api.client.Status r1 = new com.huawei.hms.support.api.client.Status
            r2 = 2003(0x7d3, float:2.807E-42)
            r1.<init>(r2, r3)
            com.huawei.hms.common.ApiException r2 = new com.huawei.hms.common.ApiException
            r2.<init>(r1)
            r0.m56657c(r2)
            return
        L1c:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "ResponseErrorCode.status:"
            r3.append(r4)
            int r4 = r18.getErrorCode()
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            com.huawei.hms.hwid.C5602as.m32910b(r2, r3, r1)
            int r3 = r18.getErrorCode()
            boolean r4 = android.text.TextUtils.isEmpty(r19)
            r5 = 0
            if (r4 != 0) goto La6
            com.huawei.hms.support.hwid.result.HuaweiIdAuthResult r4 = new com.huawei.hms.support.hwid.result.HuaweiIdAuthResult     // Catch: org.json.JSONException -> L75
            r4.<init>()     // Catch: org.json.JSONException -> L75
            r6 = r19
            com.huawei.hms.support.hwid.result.HuaweiIdAuthResult r4 = r4.fromJson(r6)     // Catch: org.json.JSONException -> L75
            com.huawei.hms.support.api.client.Status r6 = r4.getStatus()     // Catch: org.json.JSONException -> L75
            int r3 = r6.getStatusCode()     // Catch: org.json.JSONException -> L75
            boolean r6 = r4.isSuccess()     // Catch: org.json.JSONException -> L75
            if (r6 == 0) goto L77
            java.lang.String r6 = "signIn success"
            com.huawei.hms.hwid.C5602as.m32910b(r2, r6, r1)     // Catch: org.json.JSONException -> L75
            com.huawei.hms.hwid.w r6 = new com.huawei.hms.hwid.w     // Catch: org.json.JSONException -> L75
            android.content.Context r7 = r17.getContext()     // Catch: org.json.JSONException -> L75
            r6.<init>(r7)     // Catch: org.json.JSONException -> L75
            r6.m32960a()     // Catch: org.json.JSONException -> L75
            com.huawei.hms.support.hwid.result.AuthHuaweiId r6 = r4.getHuaweiId()     // Catch: org.json.JSONException -> L75
            com.huawei.hms.support.hwid.result.AuthHuaweiId r4 = r4.getHuaweiId()     // Catch: org.json.JSONException -> L8b
            r0.m56658d(r4)     // Catch: org.json.JSONException -> L8b
            goto L89
        L75:
            r6 = r5
            goto L8b
        L77:
            java.lang.String r6 = "signIn failed"
            com.huawei.hms.hwid.C5602as.m32910b(r2, r6, r1)     // Catch: org.json.JSONException -> L75
            com.huawei.hms.common.ApiException r6 = new com.huawei.hms.common.ApiException     // Catch: org.json.JSONException -> L75
            com.huawei.hms.support.api.client.Status r4 = r4.getStatus()     // Catch: org.json.JSONException -> L75
            r6.<init>(r4)     // Catch: org.json.JSONException -> L75
            r0.m56657c(r6)     // Catch: org.json.JSONException -> L75
            r6 = r5
        L89:
            r14 = r3
            goto Lc2
        L8b:
            java.lang.String r4 = "signIn complete, but parser json exception"
            com.huawei.hms.hwid.C5602as.m32911c(r2, r4, r1)
            com.huawei.hms.common.ApiException r4 = new com.huawei.hms.common.ApiException
            com.huawei.hms.support.api.client.Status r7 = new com.huawei.hms.support.api.client.Status
            int r8 = r18.getErrorCode()
            java.lang.String r9 = r18.getErrorReason()
            r7.<init>(r8, r9)
            r4.<init>(r7)
            r0.m56657c(r4)
            goto L89
        La6:
            java.lang.String r4 = "signIn complete, response is null, failed"
            com.huawei.hms.hwid.C5602as.m32910b(r2, r4, r1)
            com.huawei.hms.common.ApiException r4 = new com.huawei.hms.common.ApiException
            com.huawei.hms.support.api.client.Status r6 = new com.huawei.hms.support.api.client.Status
            int r7 = r18.getErrorCode()
            java.lang.String r8 = r18.getErrorReason()
            r6.<init>(r7, r8)
            r4.<init>(r6)
            r0.m56657c(r4)
            r14 = r3
            r6 = r5
        Lc2:
            com.huawei.hms.hwid.y r0 = com.huawei.hms.hwid.C5627y.m32967a()
            r0.m32969a(r6, r5)
            if (r17 == 0) goto Le7
            android.content.Context r9 = r17.getContext()
            java.lang.String r11 = r16.getTransactionId()
            android.content.Context r0 = r17.getContext()
            java.lang.String r12 = com.huawei.hms.utils.Util.getAppId(r0)
            int r13 = com.huawei.hms.hwid.C5601ar.m32908a(r14)
            r15 = 61200300(0x3a5d7ac, float:9.747344E-37)
            java.lang.String r10 = "hwid.silentSignIn"
            com.huawei.hms.support.hianalytics.HiAnalyticsClient.reportExit(r9, r10, r11, r12, r13, r14, r15)
        Le7:
            java.lang.String r0 = "report: api=hwid.silentSignInversion=61200300"
            com.huawei.hms.hwid.C5602as.m32910b(r2, r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.hwid.C5586ac.doExecute(com.huawei.hms.hwid.u, com.huawei.hms.common.internal.ResponseErrorCode, java.lang.String, cq.i):void");
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getApiLevel() {
        return 1;
    }
}
