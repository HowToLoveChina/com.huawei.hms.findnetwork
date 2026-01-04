package com.huawei.hms.network.embedded;

import com.huawei.hms.framework.common.Logger;
import java.util.concurrent.ExecutorService;

/* renamed from: com.huawei.hms.network.embedded.v5 */
/* loaded from: classes8.dex */
public abstract class AbstractC6125v5 {

    /* renamed from: d */
    public static final String f28642d = "IQuery";

    /* renamed from: b */
    public ExecutorService f28644b;

    /* renamed from: a */
    public C6138w5 f28643a = new C6138w5();

    /* renamed from: c */
    public AbstractC5956i5 f28645c = AbstractC5956i5.f27011e;

    /* renamed from: a */
    public final AbstractC6125v5 m35558a() {
        this.f28645c.mo34381b(this.f28643a);
        C6138w5 c6138w5Mo35507b = mo35507b(this.f28645c);
        this.f28643a = c6138w5Mo35507b;
        if (c6138w5Mo35507b == null) {
            this.f28643a = new C6138w5();
        }
        this.f28645c.mo34378a(this.f28643a);
        return this;
    }

    /* renamed from: b */
    public abstract C6138w5 mo35507b(AbstractC5956i5 abstractC5956i5);

    /* renamed from: a */
    public final AbstractC6125v5 m35559a(AbstractC5956i5 abstractC5956i5) {
        this.f28645c = abstractC5956i5;
        return this;
    }

    /* renamed from: a */
    public final AbstractC6125v5 m35560a(AbstractC6125v5 abstractC6125v5) {
        if (this.f28643a.m35725c()) {
            this.f28643a.m35724b(false);
            abstractC6125v5.f28643a = this.f28643a;
            abstractC6125v5.m35558a();
        } else {
            Logger.m32141i(f28642d, "the next quary will not execute!");
        }
        return this;
    }
}
