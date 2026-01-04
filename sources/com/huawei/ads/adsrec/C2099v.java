package com.huawei.ads.adsrec;

import android.content.Context;
import android.text.TextUtils;
import java.util.Set;
import p216d4.C9013h0;
import p216d4.C9015i0;
import p216d4.C9020l;
import p216d4.InterfaceC9028p;
import p405jt.AbstractC10915a;

/* renamed from: com.huawei.ads.adsrec.v */
/* loaded from: classes.dex */
public class C2099v implements InterfaceC9028p {

    /* renamed from: a */
    public final Context f9505a;

    /* renamed from: b */
    public final C9015i0 f9506b = C9015i0.m56922d();

    public C2099v(Context context) {
        this.f9505a = context;
    }

    @Override // p216d4.InterfaceC9028p
    /* renamed from: a */
    public void mo12558a() {
        this.f9506b.m56924b();
    }

    @Override // p216d4.InterfaceC9028p
    /* renamed from: b */
    public void mo12560b(String str, Set<String> set) {
        if (TextUtils.isEmpty(str) || set == null) {
            return;
        }
        C9013h0 c9013h0M56923a = this.f9506b.m56923a(this.f9505a, str);
        c9013h0M56923a.m56902u(set);
        this.f9506b.m56925c(c9013h0M56923a);
    }

    @Override // p216d4.InterfaceC9028p
    /* renamed from: a */
    public void mo12559a(C9020l c9020l) {
        AbstractC10915a.m65972d("DeduplicateTask", "start to distinct");
        if (c9020l == null || TextUtils.isEmpty(c9020l.m56945p())) {
            return;
        }
        C9013h0 c9013h0M56923a = this.f9506b.m56923a(this.f9505a, c9020l.m56945p());
        c9013h0M56923a.m56899r(c9020l.m56946q());
        this.f9506b.m56925c(c9013h0M56923a);
        AbstractC10915a.m65972d("DeduplicateTask", "end to distinct");
    }
}
