package com.huawei.hms.support.api.tss.callback;

import android.content.Context;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.support.api.tss.C6403c;
import com.huawei.hms.support.hianalytics.HiAnalyticsClient;
import org.json.JSONException;

/* renamed from: com.huawei.hms.support.api.tss.callback.a */
/* loaded from: classes8.dex */
public abstract class AbstractC6404a<T> extends TaskApiCall<C6403c, T> {

    /* renamed from: a */
    public Context f29960a;

    /* renamed from: b */
    public boolean f29961b;

    public AbstractC6404a(Context context, String str, String str2, boolean z10) {
        super(str, str2, z10 ? HiAnalyticsClient.reportEntry(context, str, 607000305) : null);
        this.f29960a = context;
        this.f29961b = z10;
    }

    /* renamed from: a */
    public abstract T mo36802a(String str) throws JSONException;

    /* renamed from: a */
    public boolean mo36803a(ResponseErrorCode responseErrorCode) {
        return responseErrorCode.getStatusCode() == 0 && responseErrorCode.getErrorCode() == 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:77:0x00be  */
    @Override // com.huawei.hms.common.internal.TaskApiCall
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void doExecute(com.huawei.hms.common.internal.AnyClient r9, com.huawei.hms.common.internal.ResponseErrorCode r10, java.lang.String r11, p208cq.C8941i r12) throws java.lang.Throwable {
        /*
            r8 = this;
            com.huawei.hms.support.api.tss.c r9 = (com.huawei.hms.support.api.tss.C6403c) r9
            r9 = 1
            r0 = 0
            if (r10 == 0) goto L50
            boolean r1 = r8.mo36803a(r10)     // Catch: java.lang.Throwable -> L44 java.lang.Throwable -> L4a
            if (r1 == 0) goto L1d
            java.lang.Object r9 = r8.mo36802a(r11)     // Catch: java.lang.Throwable -> L15 java.lang.Throwable -> L1a
            r12.m56658d(r9)     // Catch: java.lang.Throwable -> L15 java.lang.Throwable -> L1a
            r9 = r0
            goto L3d
        L15:
            r9 = move-exception
            r3 = r0
            r4 = r3
            goto Lba
        L1a:
            r9 = move-exception
            r10 = r0
            goto L6b
        L1d:
            int r0 = r10.getErrorCode()     // Catch: java.lang.Throwable -> L44 java.lang.Throwable -> L4a java.lang.Throwable -> L4a
            int r9 = r10.getStatusCode()     // Catch: java.lang.Throwable -> L44 java.lang.Throwable -> L4a java.lang.Throwable -> L4a
            com.huawei.hms.common.ApiException r11 = new com.huawei.hms.common.ApiException     // Catch: java.lang.Throwable -> L44 java.lang.Throwable -> L4a java.lang.Throwable -> L4a
            com.huawei.hms.support.api.client.Status r1 = new com.huawei.hms.support.api.client.Status     // Catch: java.lang.Throwable -> L44 java.lang.Throwable -> L4a java.lang.Throwable -> L4a
            int r2 = r10.getErrorCode()     // Catch: java.lang.Throwable -> L44 java.lang.Throwable -> L4a java.lang.Throwable -> L4a
            java.lang.String r10 = r10.getErrorReason()     // Catch: java.lang.Throwable -> L44 java.lang.Throwable -> L4a java.lang.Throwable -> L4a
            r1.<init>(r2, r10)     // Catch: java.lang.Throwable -> L44 java.lang.Throwable -> L4a java.lang.Throwable -> L4a
            r11.<init>(r1)     // Catch: java.lang.Throwable -> L44 java.lang.Throwable -> L4a java.lang.Throwable -> L4a
            r12.m56657c(r11)     // Catch: java.lang.Throwable -> L44 java.lang.Throwable -> L4a java.lang.Throwable -> L4a
            r7 = r0
            r0 = r9
            r9 = r7
        L3d:
            boolean r10 = r8.f29961b
            if (r10 == 0) goto Lb6
            r5 = r9
        L42:
            r4 = r0
            goto La6
        L44:
            r10 = move-exception
            r3 = r9
            r9 = r10
            r4 = r0
            goto Lba
        L4a:
            r10 = move-exception
            r7 = r0
            r0 = r9
            r9 = r10
            r10 = r7
            goto L6b
        L50:
            com.huawei.hms.support.api.tss.exception.a r10 = new com.huawei.hms.support.api.tss.exception.a     // Catch: java.lang.Throwable -> L44 java.lang.Throwable -> L4a java.lang.Throwable -> L4a
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L44 java.lang.Throwable -> L4a java.lang.Throwable -> L4a
            r11.<init>()     // Catch: java.lang.Throwable -> L44 java.lang.Throwable -> L4a java.lang.Throwable -> L4a
            java.lang.String r1 = r8.getUri()     // Catch: java.lang.Throwable -> L44 java.lang.Throwable -> L4a java.lang.Throwable -> L4a
            r11.append(r1)     // Catch: java.lang.Throwable -> L44 java.lang.Throwable -> L4a java.lang.Throwable -> L4a
            java.lang.String r1 = "response is null"
            r11.append(r1)     // Catch: java.lang.Throwable -> L44 java.lang.Throwable -> L4a java.lang.Throwable -> L4a
            java.lang.String r11 = r11.toString()     // Catch: java.lang.Throwable -> L44 java.lang.Throwable -> L4a java.lang.Throwable -> L4a
            r10.<init>(r11)     // Catch: java.lang.Throwable -> L44 java.lang.Throwable -> L4a java.lang.Throwable -> L4a
            throw r10     // Catch: java.lang.Throwable -> L44 java.lang.Throwable -> L4a java.lang.Throwable -> L4a
        L6b:
            java.lang.String r11 = "AbstractTaskApiCall"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lb7
            r1.<init>()     // Catch: java.lang.Throwable -> Lb7
            java.lang.String r2 = r8.getUri()     // Catch: java.lang.Throwable -> Lb7
            r1.append(r2)     // Catch: java.lang.Throwable -> Lb7
            java.lang.String r2 = " doExecute exception:"
            r1.append(r2)     // Catch: java.lang.Throwable -> Lb7
            java.lang.String r2 = r9.getMessage()     // Catch: java.lang.Throwable -> Lb7
            r1.append(r2)     // Catch: java.lang.Throwable -> Lb7
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> Lb7
            com.huawei.hms.support.log.HMSLog.m36986e(r11, r1)     // Catch: java.lang.Throwable -> Lb7
            com.huawei.hms.common.ApiException r11 = new com.huawei.hms.common.ApiException     // Catch: java.lang.Throwable -> Lb7
            com.huawei.hms.support.api.client.Status r1 = new com.huawei.hms.support.api.client.Status     // Catch: java.lang.Throwable -> Lb7
            java.lang.String r9 = r9.getMessage()     // Catch: java.lang.Throwable -> Lb7
            r2 = 201001(0x31129, float:2.81662E-40)
            r1.<init>(r2, r9)     // Catch: java.lang.Throwable -> Lb7
            r11.<init>(r1)     // Catch: java.lang.Throwable -> Lb7
            r12.m56657c(r11)     // Catch: java.lang.Throwable -> Lb7
            boolean r9 = r8.f29961b
            if (r9 == 0) goto Lb6
            r5 = r10
            goto L42
        La6:
            android.content.Context r1 = r8.f29960a
            java.lang.String r2 = r8.getUri()
            java.lang.String r3 = r8.getTransactionId()
            r6 = 607000305(0x242e16f1, float:3.7749668E-17)
            com.huawei.hms.support.hianalytics.HiAnalyticsClient.reportExit(r1, r2, r3, r4, r5, r6)
        Lb6:
            return
        Lb7:
            r9 = move-exception
            r4 = r10
            r3 = r0
        Lba:
            boolean r10 = r8.f29961b
            if (r10 == 0) goto Lce
            android.content.Context r0 = r8.f29960a
            java.lang.String r1 = r8.getUri()
            java.lang.String r2 = r8.getTransactionId()
            r5 = 607000305(0x242e16f1, float:3.7749668E-17)
            com.huawei.hms.support.hianalytics.HiAnalyticsClient.reportExit(r0, r1, r2, r3, r4, r5)
        Lce:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.support.api.tss.callback.AbstractC6404a.doExecute(com.huawei.hms.common.internal.AnyClient, com.huawei.hms.common.internal.ResponseErrorCode, java.lang.String, cq.i):void");
    }
}
