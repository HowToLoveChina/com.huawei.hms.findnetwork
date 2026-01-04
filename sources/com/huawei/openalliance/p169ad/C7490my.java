package com.huawei.openalliance.p169ad;

import android.content.Context;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.inter.data.MaterialClickInfo;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.processor.eventbeans.C7586a;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.C7753b;

/* renamed from: com.huawei.openalliance.ad.my */
/* loaded from: classes8.dex */
public class C7490my {

    /* renamed from: a */
    private Context f34729a;

    /* renamed from: b */
    private ContentRecord f34730b;

    /* renamed from: c */
    private MaterialClickInfo f34731c;

    public C7490my(Context context, ContentRecord contentRecord, MaterialClickInfo materialClickInfo) {
        this.f34729a = context;
        this.f34730b = contentRecord;
        this.f34731c = materialClickInfo;
    }

    /* renamed from: a */
    public void m45892a() {
        long jM40320i;
        int iM40324k;
        if (this.f34730b == null) {
            return;
        }
        AbstractC7185ho.m43820b("AppDownBtnPresenter", "rpt imp for app detail activity.");
        Context context = this.f34729a;
        C7560ou c7560ou = new C7560ou(context, C7662sk.m47225a(context, this.f34730b.m41552f()));
        c7560ou.mo46590a(this.f34730b);
        if (this.f34730b.m41568i() != null) {
            jM40320i = this.f34730b.m41568i().m40320i();
            iM40324k = this.f34730b.m41568i().m40324k();
        } else {
            jM40320i = 500;
            iM40324k = 50;
        }
        C7586a.a aVarM46879b = new C7586a.a().m46874a(Long.valueOf(jM40320i)).m46873a(Integer.valueOf(iM40324k)).m46878b((Integer) 2).m46875a(C7753b.m47700a((Object) this.f34729a)).m46884d(Constants.DEF_SLOT_POSITION).m46879b(this.f34730b.m41450aB());
        MaterialClickInfo materialClickInfo = this.f34731c;
        if (materialClickInfo != null && AbstractC7806cz.m48187p(materialClickInfo.m44508c())) {
            aVarM46879b.m46885e(this.f34731c.m44508c());
        }
        c7560ou.mo46593a(aVarM46879b.m46877a());
    }
}
