package com.huawei.hms.locationSdk;

import com.huawei.hms.common.internal.AnyClient;
import com.huawei.hms.common.internal.TaskApiCall;
import p208cq.C8941i;

/* renamed from: com.huawei.hms.locationSdk.b */
/* loaded from: classes8.dex */
public abstract class AbstractC5696b<ClientT extends AnyClient, ResultT> extends TaskApiCall<ClientT, ResultT> {

    /* renamed from: a */
    public final String f25484a;

    /* renamed from: b */
    protected boolean f25485b;

    /* renamed from: c */
    protected C8941i f25486c;

    public AbstractC5696b(String str, String str2, String str3) {
        super(str, str2);
        this.f25484a = str3;
    }

    /* renamed from: a */
    public boolean m33040a(int i10) {
        return i10 >= 8 && ((i10 >> 3) & 1) == 1;
    }

    public AbstractC5696b(String str, String str2, String str3, String str4) {
        super(str, str2, str4);
        this.f25484a = str3;
    }

    /* renamed from: a */
    public void mo33039a(boolean z10) {
        this.f25485b = z10;
    }

    /* renamed from: a */
    public void m33038a(C8941i c8941i) {
        this.f25486c = c8941i;
    }
}
