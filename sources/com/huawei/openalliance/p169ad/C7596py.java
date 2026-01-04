package com.huawei.openalliance.p169ad;

import android.content.Context;
import com.huawei.openalliance.p169ad.beans.metadata.Content;
import com.huawei.openalliance.p169ad.utils.C7792cl;

/* renamed from: com.huawei.openalliance.ad.py */
/* loaded from: classes8.dex */
public class C7596py extends AbstractC7595px {
    public C7596py(Context context) {
        super(context);
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7595px
    /* renamed from: a */
    public String mo46964a() {
        return "ForceFilter";
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7597pz
    /* renamed from: b */
    public int mo46966b() {
        return 99;
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7595px
    /* renamed from: a */
    public boolean mo46965a(Content content, int i10) {
        C7792cl.m48071a(this.f35445a, content, 99, i10);
        return true;
    }
}
