package com.huawei.animation.physical2;

import com.huawei.animation.physical2.AbstractC4561j;

/* renamed from: com.huawei.animation.physical2.i */
/* loaded from: classes4.dex */
public abstract class AbstractC4560i<VH extends AbstractC4561j> {

    /* renamed from: a */
    public a f20950a;

    /* renamed from: com.huawei.animation.physical2.i$a */
    public interface a {
        /* renamed from: a */
        void mo27988a(AbstractC4561j abstractC4561j);
    }

    /* renamed from: a */
    public abstract VH mo27977a();

    /* renamed from: b */
    public abstract VH mo27978b(VH vh2);

    /* renamed from: c */
    public abstract VH mo27979c(int i10);

    /* renamed from: d */
    public abstract int mo27980d();

    /* renamed from: e */
    public void m28021e(AbstractC4561j abstractC4561j) {
        a aVar = this.f20950a;
        if (aVar != null) {
            aVar.mo27988a(abstractC4561j);
        }
    }

    /* renamed from: f */
    public void m28022f(a aVar) {
        this.f20950a = aVar;
    }
}
