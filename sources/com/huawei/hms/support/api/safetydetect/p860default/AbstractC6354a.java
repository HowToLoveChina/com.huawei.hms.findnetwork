package com.huawei.hms.support.api.safetydetect.p860default;

import android.content.Context;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.hianalytics.HiAnalyticsClient;
import com.huawei.hms.support.log.HMSLog;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.support.api.safetydetect.default.a */
/* loaded from: classes8.dex */
public abstract class AbstractC6354a<T> extends TaskApiCall<C6379t, T> {

    /* renamed from: a */
    private Context f29883a;

    /* renamed from: b */
    private boolean f29884b;

    public AbstractC6354a(Context context, String str, String str2, boolean z10) {
        super(str, str2, z10 ? HiAnalyticsClient.reportEntry(context, str, 60700305) : null);
        this.f29883a = context;
        this.f29884b = z10;
    }

    /* renamed from: a */
    private int m36721a(String str, int i10) {
        try {
            return new JSONObject(str).optInt("statusCode", 1);
        } catch (JSONException e10) {
            HMSLog.m36986e("AbstractTaskApiCall", getUri() + "Get Status Code Error : " + e10.getMessage());
            return i10;
        }
    }

    /* renamed from: a */
    public abstract T mo36723a(String str, int i10, String str2);

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getApiLevel() {
        return 60100004;
    }

    /* renamed from: a */
    private Status m36722a(int i10, String str, String str2) {
        if (str2 == null || str2.isEmpty()) {
            return new Status(i10, str);
        }
        try {
            JSONObject jSONObject = new JSONObject(str2);
            return new Status(jSONObject.getInt("statusCode"), jSONObject.getString("statusMsg"));
        } catch (JSONException unused) {
            return new Status(i10, str);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00ca  */
    @Override // com.huawei.hms.common.internal.TaskApiCall
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void doExecute(com.huawei.hms.support.api.safetydetect.p860default.C6379t r9, com.huawei.hms.common.internal.ResponseErrorCode r10, java.lang.String r11, p208cq.C8941i<T> r12) throws java.lang.Throwable {
        /*
            r8 = this;
            r9 = 1
            r0 = 0
            if (r10 == 0) goto L5d
            int r1 = r10.getErrorCode()     // Catch: java.lang.Throwable -> L29 com.huawei.hms.support.api.safetydetect.p860default.C6378s -> L2f
            if (r1 != 0) goto L35
            int r1 = r10.getStatusCode()     // Catch: java.lang.Throwable -> L29 com.huawei.hms.support.api.safetydetect.p860default.C6378s -> L2f
            if (r1 != 0) goto L35
            int r9 = r10.getErrorCode()     // Catch: java.lang.Throwable -> L21 com.huawei.hms.support.api.safetydetect.p860default.C6378s -> L26
            java.lang.String r10 = r10.getErrorReason()     // Catch: java.lang.Throwable -> L21 com.huawei.hms.support.api.safetydetect.p860default.C6378s -> L26
            java.lang.Object r9 = r8.mo36723a(r11, r9, r10)     // Catch: java.lang.Throwable -> L21 com.huawei.hms.support.api.safetydetect.p860default.C6378s -> L26
            r12.m56658d(r9)     // Catch: java.lang.Throwable -> L21 com.huawei.hms.support.api.safetydetect.p860default.C6378s -> L26
            r9 = r0
            goto L56
        L21:
            r9 = move-exception
            r3 = r0
            r4 = r3
            goto Lc6
        L26:
            r9 = move-exception
            r10 = r0
            goto L78
        L29:
            r10 = move-exception
            r3 = r9
            r9 = r10
            r4 = r0
            goto Lc6
        L2f:
            r10 = move-exception
            r7 = r0
            r0 = r9
            r9 = r10
            r10 = r7
            goto L78
        L35:
            int r0 = r10.getErrorCode()     // Catch: java.lang.Throwable -> L29 com.huawei.hms.support.api.safetydetect.p860default.C6378s -> L2f
            boolean r1 = android.text.TextUtils.isEmpty(r11)     // Catch: java.lang.Throwable -> L29 com.huawei.hms.support.api.safetydetect.p860default.C6378s -> L2f
            if (r1 != 0) goto L43
            int r9 = r8.m36721a(r11, r9)     // Catch: java.lang.Throwable -> L29 com.huawei.hms.support.api.safetydetect.p860default.C6378s -> L2f
        L43:
            com.huawei.hms.common.ApiException r1 = new com.huawei.hms.common.ApiException     // Catch: java.lang.Throwable -> L29 com.huawei.hms.support.api.safetydetect.p860default.C6378s -> L2f
            java.lang.String r10 = r10.getErrorReason()     // Catch: java.lang.Throwable -> L29 com.huawei.hms.support.api.safetydetect.p860default.C6378s -> L2f
            com.huawei.hms.support.api.client.Status r10 = r8.m36722a(r0, r10, r11)     // Catch: java.lang.Throwable -> L29 com.huawei.hms.support.api.safetydetect.p860default.C6378s -> L2f
            r1.<init>(r10)     // Catch: java.lang.Throwable -> L29 com.huawei.hms.support.api.safetydetect.p860default.C6378s -> L2f
            r12.m56657c(r1)     // Catch: java.lang.Throwable -> L29 com.huawei.hms.support.api.safetydetect.p860default.C6378s -> L2f
            r7 = r0
            r0 = r9
            r9 = r7
        L56:
            boolean r10 = r8.f29884b
            if (r10 == 0) goto Lc2
            r5 = r9
        L5b:
            r4 = r0
            goto Lb2
        L5d:
            com.huawei.hms.support.api.safetydetect.default.s r10 = new com.huawei.hms.support.api.safetydetect.default.s     // Catch: java.lang.Throwable -> L29 com.huawei.hms.support.api.safetydetect.p860default.C6378s -> L2f
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L29 com.huawei.hms.support.api.safetydetect.p860default.C6378s -> L2f
            r11.<init>()     // Catch: java.lang.Throwable -> L29 com.huawei.hms.support.api.safetydetect.p860default.C6378s -> L2f
            java.lang.String r1 = r8.getUri()     // Catch: java.lang.Throwable -> L29 com.huawei.hms.support.api.safetydetect.p860default.C6378s -> L2f
            r11.append(r1)     // Catch: java.lang.Throwable -> L29 com.huawei.hms.support.api.safetydetect.p860default.C6378s -> L2f
            java.lang.String r1 = "response is null"
            r11.append(r1)     // Catch: java.lang.Throwable -> L29 com.huawei.hms.support.api.safetydetect.p860default.C6378s -> L2f
            java.lang.String r11 = r11.toString()     // Catch: java.lang.Throwable -> L29 com.huawei.hms.support.api.safetydetect.p860default.C6378s -> L2f
            r10.<init>(r11)     // Catch: java.lang.Throwable -> L29 com.huawei.hms.support.api.safetydetect.p860default.C6378s -> L2f
            throw r10     // Catch: java.lang.Throwable -> L29 com.huawei.hms.support.api.safetydetect.p860default.C6378s -> L2f
        L78:
            java.lang.String r11 = "AbstractTaskApiCall"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lc3
            r1.<init>()     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r2 = r8.getUri()     // Catch: java.lang.Throwable -> Lc3
            r1.append(r2)     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r2 = "doExecute exception:"
            r1.append(r2)     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r9 = r9.getMessage()     // Catch: java.lang.Throwable -> Lc3
            r1.append(r9)     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r9 = r1.toString()     // Catch: java.lang.Throwable -> Lc3
            com.huawei.hms.support.log.HMSLog.m36986e(r11, r9)     // Catch: java.lang.Throwable -> Lc3
            com.huawei.hms.common.ApiException r9 = new com.huawei.hms.common.ApiException     // Catch: java.lang.Throwable -> Lc3
            com.huawei.hms.support.api.client.Status r11 = new com.huawei.hms.support.api.client.Status     // Catch: java.lang.Throwable -> Lc3
            r1 = 19001(0x4a39, float:2.6626E-41)
            java.lang.String r2 = com.huawei.hms.support.api.safetydetect.SafetyDetectStatusCodes.getStatusCodeString(r1)     // Catch: java.lang.Throwable -> Lc3
            r11.<init>(r1, r2)     // Catch: java.lang.Throwable -> Lc3
            r9.<init>(r11)     // Catch: java.lang.Throwable -> Lc3
            r12.m56657c(r9)     // Catch: java.lang.Throwable -> Lc3
            boolean r9 = r8.f29884b
            if (r9 == 0) goto Lc2
            r5 = r10
            goto L5b
        Lb2:
            android.content.Context r1 = r8.f29883a
            java.lang.String r2 = r8.getUri()
            java.lang.String r3 = r8.getTransactionId()
            r6 = 60700305(0x39e3691, float:9.298933E-37)
            com.huawei.hms.support.hianalytics.HiAnalyticsClient.reportExit(r1, r2, r3, r4, r5, r6)
        Lc2:
            return
        Lc3:
            r9 = move-exception
            r4 = r10
            r3 = r0
        Lc6:
            boolean r10 = r8.f29884b
            if (r10 == 0) goto Lda
            android.content.Context r0 = r8.f29883a
            java.lang.String r1 = r8.getUri()
            java.lang.String r2 = r8.getTransactionId()
            r5 = 60700305(0x39e3691, float:9.298933E-37)
            com.huawei.hms.support.hianalytics.HiAnalyticsClient.reportExit(r0, r1, r2, r3, r4, r5)
        Lda:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.support.api.safetydetect.p860default.AbstractC6354a.doExecute(com.huawei.hms.support.api.safetydetect.default.t, com.huawei.hms.common.internal.ResponseErrorCode, java.lang.String, cq.i):void");
    }
}
