package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.view.View;
import com.huawei.openalliance.p169ad.analysis.C6922c;
import com.huawei.openalliance.p169ad.inter.data.MaterialClickInfo;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.processor.eventbeans.C7586a;
import com.huawei.openalliance.p169ad.processor.eventbeans.C7587b;
import com.huawei.openalliance.p169ad.utils.AbstractC7811dd;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* renamed from: com.huawei.openalliance.ad.nt */
/* loaded from: classes8.dex */
public class C7525nt {

    /* renamed from: a */
    private Context f34958a;

    /* renamed from: b */
    private ContentRecord f34959b;

    /* renamed from: c */
    private String f34960c;

    /* renamed from: d */
    private InterfaceC7615qq f34961d;

    /* renamed from: e */
    private InterfaceC7002cs f34962e;

    /* renamed from: f */
    private WeakReference<View> f34963f;

    public C7525nt(Context context, ContentRecord contentRecord, String str) {
        Context applicationContext = context.getApplicationContext();
        this.f34958a = applicationContext;
        this.f34959b = contentRecord;
        this.f34960c = str;
        this.f34961d = new C7560ou(applicationContext, new C7668sq(applicationContext, 1), contentRecord);
        this.f34962e = new C6922c(this.f34958a);
    }

    /* renamed from: a */
    public void m46208a() {
        this.f34962e.mo39122d(this.f34959b);
    }

    /* renamed from: a */
    public void m46209a(int i10) {
        this.f34962e.mo39113b(this.f34959b, i10);
    }

    /* renamed from: a */
    public void m46210a(View view) {
        this.f34963f = new WeakReference<>(view);
    }

    /* renamed from: a */
    public boolean m46211a(Context context, MaterialClickInfo materialClickInfo) {
        AbstractC7185ho.m43820b("SplashIconViewPresenter", "onClick");
        AbstractC7687ti abstractC7687tiM47245a = C7686th.m47245a(this.f34958a, this.f34959b, new HashMap(0));
        if (!abstractC7687tiM47245a.mo47233a()) {
            return false;
        }
        C7587b.a aVar = new C7587b.a();
        aVar.m46920b(abstractC7687tiM47245a.m47250c()).m46915a((Integer) 23).m46914a(materialClickInfo).m46923d(this.f34960c);
        this.f34961d.mo46594a(aVar.m46918a());
        return true;
    }

    /* renamed from: a */
    public boolean m46212a(Long l10, Integer num, Integer num2) {
        View view = this.f34963f.get();
        if (view == null) {
            return false;
        }
        String strM48325e = AbstractC7811dd.m48325e(view);
        C7586a.a aVar = new C7586a.a();
        aVar.m46874a(l10).m46873a(num).m46878b(num2).m46875a(this.f34960c).m46885e(C8190vl.m50727b(view)).m46884d(strM48325e);
        this.f34961d.mo46593a(aVar.m46877a());
        return true;
    }
}
