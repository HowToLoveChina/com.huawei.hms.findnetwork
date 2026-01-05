package com.huawei.hms.common.internal;

import android.os.Parcelable;
import com.huawei.hms.common.internal.AnyClient;
import com.huawei.hms.support.log.HMSLog;
import p208cq.AbstractC8933a;
import p208cq.C8941i;

/* loaded from: classes8.dex */
public abstract class TaskApiCall<ClientT extends AnyClient, ResultT> {

    /* renamed from: a */
    private final String m_uri;

    /* renamed from: b */
    private final String f23513b;

    /* renamed from: c */
    private Parcelable f23514c;

    /* renamed from: d */
    private String f23515d;

    /* renamed from: e */
    private AbstractC8933a f23516e;

    /* renamed from: f */
    private int f23517f;

    @Deprecated
    public TaskApiCall(String str, String str2) {
        this.f23517f = 1;
        this.m_uri = str;
        this.f23513b = str2;
        this.f23514c = null;
        this.f23515d = null;
    }

    public abstract void doExecute(ClientT clientt, ResponseErrorCode responseErrorCode, String str, C8941i<ResultT> c8941i);

    public int getApiLevel() {
        return this.f23517f;
    }

    @Deprecated
    public int getMinApkVersion() {
        return 30000000;
    }

    public Parcelable getParcelable() {
        return this.f23514c;
    }

    public String getRequestJson() {
        return this.f23513b;
    }

    public AbstractC8933a getToken() {
        return this.f23516e;
    }

    public String getTransactionId() {
        return this.f23515d;
    }

    public String getUri() {
        return this.m_uri;
    }

    public final void onResponse(ClientT clientt, ResponseErrorCode responseErrorCode, String str, C8941i<ResultT> c8941i) {
        AbstractC8933a abstractC8933a = this.f23516e;
        if (abstractC8933a != null && abstractC8933a.isCancellationRequested()) {
            HMSLog.m36988i("TaskApiCall", "This Task has been canceled, uri:" + this.m_uri + ", transactionId:" + this.f23515d);
            return;
        }
        HMSLog.m36988i("TaskApiCall", "doExecute, uri:" + this.m_uri + ", errorCode:" + responseErrorCode.getErrorCode() + ", transactionId:" + this.f23515d);
        doExecute(clientt, responseErrorCode, str, c8941i);
    }

    public void setApiLevel(int i10) {
        this.f23517f = i10;
    }

    public void setParcelable(Parcelable parcelable) {
        this.f23514c = parcelable;
    }

    public void setToken(AbstractC8933a abstractC8933a) {
        this.f23516e = abstractC8933a;
    }

    public void setTransactionId(String str) {
        this.f23515d = str;
    }

    public TaskApiCall(String str, String str2, String str3) {
        this.f23517f = 1;
        this.m_uri = str;
        this.f23513b = str2;
        this.f23514c = null;
        this.f23515d = str3;
    }

    public TaskApiCall(String str, String str2, String str3, int i10) {
        this.m_uri = str;
        this.f23513b = str2;
        this.f23514c = null;
        this.f23515d = str3;
        this.f23517f = i10;
    }
}
