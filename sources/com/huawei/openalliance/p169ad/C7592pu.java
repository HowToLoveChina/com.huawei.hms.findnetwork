package com.huawei.openalliance.p169ad;

import android.content.Context;
import com.huawei.openalliance.p169ad.beans.metadata.ApkInfo;
import com.huawei.openalliance.p169ad.beans.metadata.Content;
import com.huawei.openalliance.p169ad.beans.metadata.MetaData;
import com.huawei.openalliance.p169ad.utils.C7792cl;
import com.huawei.openalliance.p169ad.utils.C7830i;

/* renamed from: com.huawei.openalliance.ad.pu */
/* loaded from: classes8.dex */
public class C7592pu extends AbstractC7595px {
    public C7592pu(Context context) {
        super(context);
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7595px
    /* renamed from: a */
    public String mo46964a() {
        return "AppInstallAdFilter";
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7597pz
    /* renamed from: b */
    public int mo46966b() {
        return 1;
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7595px
    /* renamed from: a */
    public boolean mo46965a(Content content, int i10) {
        String strMo46964a;
        String str;
        MetaData metaDataM39944c = content.m39944c();
        if (metaDataM39944c == null) {
            strMo46964a = mo46964a();
            str = "metaData is null";
        } else {
            ApkInfo apkInfoM40339s = metaDataM39944c.m40339s();
            if (apkInfoM40339s != null) {
                boolean zM48419a = C7830i.m48419a(this.f35445a, apkInfoM40339s.m39626a());
                if (zM48419a) {
                    C7792cl.m48071a(this.f35445a, content, 1, i10);
                }
                return zM48419a;
            }
            strMo46964a = mo46964a();
            str = "apkInfo is null";
        }
        AbstractC7185ho.m43823c(strMo46964a, str);
        return false;
    }
}
