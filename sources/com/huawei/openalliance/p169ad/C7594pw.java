package com.huawei.openalliance.p169ad;

import android.content.Context;
import com.huawei.openalliance.p169ad.C7692tn;
import com.huawei.openalliance.p169ad.beans.metadata.ApkInfo;
import com.huawei.openalliance.p169ad.beans.metadata.Content;
import com.huawei.openalliance.p169ad.beans.metadata.MetaData;
import com.huawei.openalliance.p169ad.utils.C7792cl;
import com.huawei.openalliance.p169ad.utils.C7830i;

/* renamed from: com.huawei.openalliance.ad.pw */
/* loaded from: classes8.dex */
public class C7594pw extends AbstractC7595px {
    public C7594pw(Context context) {
        super(context);
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7595px
    /* renamed from: a */
    public String mo46964a() {
        return "AppPropagandaFilter";
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7597pz
    /* renamed from: b */
    public int mo46966b() {
        return 4;
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7595px
    /* renamed from: a */
    public boolean mo46965a(Content content, int i10) {
        String strMo46964a;
        String str;
        MetaData metaDataM39944c = content.m39944c();
        if (metaDataM39944c == null) {
            strMo46964a = mo46964a();
            str = "isNeedDiscard metaData is null";
        } else {
            ApkInfo apkInfoM40339s = metaDataM39944c.m40339s();
            if (apkInfoM40339s != null) {
                if (C7830i.m48419a(this.f35445a, apkInfoM40339s.m39626a())) {
                    String strM40332o = metaDataM39944c.m40332o();
                    C7692tn.a aVar = new C7692tn.a();
                    aVar.m47276a(content.m39962g()).m47278b(content.m39966h()).m47271a(i10);
                    if (C7830i.m48426b(this.f35445a, strM40332o, apkInfoM40339s.m39626a(), aVar.m47277a()) == null) {
                        C7792cl.m48071a(this.f35445a, content, 4, i10);
                        AbstractC7185ho.m43823c(mo46964a(), "isNeedDiscard intent check fail");
                        return true;
                    }
                }
                return false;
            }
            strMo46964a = mo46964a();
            str = "isNeedDiscard apkInfo is null";
        }
        AbstractC7185ho.m43823c(strMo46964a, str);
        return false;
    }
}
