package com.huawei.openalliance.p169ad;

import android.content.Context;
import com.huawei.openalliance.p169ad.C7692tn;
import com.huawei.openalliance.p169ad.beans.metadata.ApkInfo;
import com.huawei.openalliance.p169ad.beans.metadata.MetaData;
import com.huawei.openalliance.p169ad.download.app.C7055l;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7758be;
import com.huawei.openalliance.p169ad.utils.C7830i;

/* renamed from: com.huawei.openalliance.ad.sw */
/* loaded from: classes8.dex */
public class C7674sw extends AbstractC7687ti {

    /* renamed from: c */
    private InterfaceC7615qq f35685c;

    public C7674sw(Context context, ContentRecord contentRecord) {
        super(context, contentRecord);
        C7560ou c7560ou = new C7560ou(context, C7662sk.m47225a(context, contentRecord.m41552f()));
        this.f35685c = c7560ou;
        c7560ou.mo46590a(contentRecord);
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7687ti
    /* renamed from: a */
    public boolean mo47233a() {
        ApkInfo apkInfoM40339s;
        AbstractC7185ho.m43820b("AppEnterAction", "handle app enter action");
        MetaData metaData = (MetaData) AbstractC7758be.m47739b(this.f35701b.m41563h(), MetaData.class, new Class[0]);
        if (metaData != null && (apkInfoM40339s = metaData.m40339s()) != null) {
            String strM39626a = apkInfoM40339s.m39626a();
            C7692tn.a aVar = new C7692tn.a();
            aVar.m47273a(apkInfoM40339s).m47274a(this.f35701b);
            if (C7830i.m48420a(this.f35700a, strM39626a, aVar.m47277a())) {
                m47248b("app");
                C7055l.m42499a(this.f35700a, this.f35701b.m41484af());
                this.f35685c.mo46595a((Integer) 1);
                return true;
            }
        }
        return m47249b();
    }
}
