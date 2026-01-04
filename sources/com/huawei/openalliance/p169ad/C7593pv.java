package com.huawei.openalliance.p169ad;

import android.content.Context;
import com.huawei.openalliance.p169ad.C7692tn;
import com.huawei.openalliance.p169ad.beans.metadata.ApkInfo;
import com.huawei.openalliance.p169ad.beans.metadata.Content;
import com.huawei.openalliance.p169ad.beans.metadata.MetaData;
import com.huawei.openalliance.p169ad.utils.C7792cl;
import com.huawei.openalliance.p169ad.utils.C7830i;

/* renamed from: com.huawei.openalliance.ad.pv */
/* loaded from: classes8.dex */
public class C7593pv extends AbstractC7595px {
    public C7593pv(Context context) {
        super(context);
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7595px
    /* renamed from: a */
    public String mo46964a() {
        return "AppPromoteAdFilter";
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7597pz
    /* renamed from: b */
    public int mo46966b() {
        return 2;
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7595px
    /* renamed from: a */
    public boolean mo46965a(Content content, int i10) {
        MetaData metaDataM39944c = content.m39944c();
        if (metaDataM39944c == null) {
            AbstractC7185ho.m43823c(mo46964a(), "metaData is null");
            return false;
        }
        String strM40332o = metaDataM39944c.m40332o();
        ApkInfo apkInfoM40339s = metaDataM39944c.m40339s();
        String strM39626a = apkInfoM40339s == null ? null : apkInfoM40339s.m39626a();
        C7692tn.a aVar = new C7692tn.a();
        aVar.m47278b(content.m39966h());
        aVar.m47276a(content.m39962g());
        aVar.m47271a(i10);
        boolean z10 = C7830i.m48426b(this.f35445a, strM40332o, strM39626a, aVar.m47277a()) == null;
        if (z10) {
            C7792cl.m48071a(this.f35445a, content, 2, i10);
        }
        return z10;
    }
}
