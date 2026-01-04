package com.huawei.openalliance.p169ad;

/* renamed from: com.huawei.openalliance.ad.cz */
/* loaded from: classes8.dex */
public abstract class AbstractC7009cz {

    /* renamed from: a */
    private AbstractC7009cz f32152a = null;

    /* renamed from: a */
    public void m41238a(AbstractC7009cz abstractC7009cz) {
        this.f32152a = abstractC7009cz;
    }

    /* renamed from: a */
    public abstract boolean mo41237a();

    /* renamed from: b */
    public boolean m41239b() {
        AbstractC7009cz abstractC7009cz = this.f32152a;
        if (abstractC7009cz != null) {
            return abstractC7009cz.mo41237a();
        }
        return false;
    }
}
