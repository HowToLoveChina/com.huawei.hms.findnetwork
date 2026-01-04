package com.huawei.openalliance.p169ad;

import com.huawei.openalliance.p169ad.utils.AbstractC7817dj;

/* renamed from: com.huawei.openalliance.ad.ns */
/* loaded from: classes8.dex */
public abstract class AbstractC7524ns {

    /* renamed from: a */
    protected InterfaceC7146gc f34952a;

    /* renamed from: b */
    private InterfaceC7182hl f34953b;

    /* renamed from: c */
    private final String f34954c = "min_show_time_task" + hashCode();

    /* renamed from: d */
    private final String f34955d = "max_show_time_task" + hashCode();

    public AbstractC7524ns(InterfaceC7146gc interfaceC7146gc, InterfaceC7182hl interfaceC7182hl) {
        this.f34952a = interfaceC7146gc;
        this.f34953b = interfaceC7182hl;
    }

    /* renamed from: a */
    public void mo45920a() {
    }

    /* renamed from: b */
    public void m46204b() {
        InterfaceC7182hl interfaceC7182hl = this.f34953b;
        if (interfaceC7182hl != null) {
            interfaceC7182hl.mo43801a();
        }
    }

    /* renamed from: c */
    public void m46206c() {
        InterfaceC7182hl interfaceC7182hl = this.f34953b;
        if (interfaceC7182hl != null) {
            interfaceC7182hl.mo43802b();
        }
    }

    /* renamed from: d */
    public void m46207d() {
        AbstractC7817dj.m48366a(this.f34954c);
    }

    /* renamed from: a */
    public void m46203a(long j10) {
        AbstractC7185ho.m43821b(getClass().getSimpleName(), "start max show time task duration: %d", Long.valueOf(j10));
        AbstractC7817dj.m48365a(new Runnable() { // from class: com.huawei.openalliance.ad.ns.1
            @Override // java.lang.Runnable
            public void run() {
                AbstractC7185ho.m43817a(getClass().getSimpleName(), "cancelMinShowTimeCountTask and cancelMinShowTimeCountTask");
                AbstractC7524ns.this.m46207d();
                AbstractC7524ns.this.m46206c();
            }
        }, this.f34955d, j10);
    }

    /* renamed from: b */
    public void m46205b(long j10) {
        AbstractC7185ho.m43821b(getClass().getSimpleName(), "start min show time task duration: %d", Long.valueOf(j10));
        AbstractC7817dj.m48365a(new Runnable() { // from class: com.huawei.openalliance.ad.ns.2
            @Override // java.lang.Runnable
            public void run() {
                AbstractC7524ns.this.m46204b();
            }
        }, this.f34954c, j10);
    }
}
