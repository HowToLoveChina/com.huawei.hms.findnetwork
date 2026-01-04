package com.huawei.openalliance.p169ad;

import android.content.Context;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;

/* renamed from: com.huawei.openalliance.ad.ti */
/* loaded from: classes8.dex */
public abstract class AbstractC7687ti {

    /* renamed from: a */
    protected Context f35700a;

    /* renamed from: b */
    protected ContentRecord f35701b;

    /* renamed from: c */
    private String f35702c = null;

    /* renamed from: d */
    private AbstractC7687ti f35703d;

    public AbstractC7687ti() {
    }

    /* renamed from: a */
    public void m47247a(AbstractC7687ti abstractC7687ti) {
        this.f35703d = abstractC7687ti;
    }

    /* renamed from: a */
    public abstract boolean mo47233a();

    /* renamed from: b */
    public void m47248b(String str) {
        this.f35702c = str;
    }

    /* renamed from: c */
    public String m47250c() {
        AbstractC7687ti abstractC7687ti;
        String str = this.f35702c;
        return (str != null || (abstractC7687ti = this.f35703d) == null) ? str : abstractC7687ti.m47250c();
    }

    public AbstractC7687ti(Context context, ContentRecord contentRecord) {
        this.f35700a = context;
        this.f35701b = contentRecord;
    }

    /* renamed from: b */
    public boolean m47249b() {
        AbstractC7687ti abstractC7687ti = this.f35703d;
        if (abstractC7687ti != null) {
            return abstractC7687ti.mo47233a();
        }
        return false;
    }
}
