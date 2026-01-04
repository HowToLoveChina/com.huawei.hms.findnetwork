package com.huawei.ads.adsrec;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p216d4.C9020l;
import p216d4.C9021l0;
import p216d4.C9031r;
import p216d4.InterfaceC9032s;
import p277f4.C9655a;
import p384j4.AbstractC10706e;
import p405jt.AbstractC10915a;

/* renamed from: com.huawei.ads.adsrec.k0 */
/* loaded from: classes.dex */
public class C2094k0 implements InterfaceC9032s {

    /* renamed from: a */
    public Context f9488a;

    public C2094k0(Context context) {
        this.f9488a = context.getApplicationContext();
    }

    @Override // p216d4.InterfaceC9032s
    /* renamed from: a */
    public <T> C9020l mo12549a(C9655a c9655a, C9020l c9020l) {
        return null;
    }

    @Override // p216d4.InterfaceC9032s
    /* renamed from: b */
    public <T> C9020l mo12550b(C9655a c9655a, T t10) {
        AbstractC10915a.m65972d("LocalRecallTask", "recall");
        if (c9655a == null) {
            AbstractC10915a.m65972d("LocalRecallTask", "adRecallParam is null");
            return null;
        }
        C9020l c9020l = new C9020l(c9655a.m60304j(), new C2093e(this.f9488a).mo12532b(c9655a.m60304j()));
        c9020l.m56938i(c9655a.m60305k());
        List<String> listM60296b = c9655a.m60296b();
        if (AbstractC10706e.m65374a(listM60296b)) {
            AbstractC10915a.m65972d("LocalRecallTask", "empty slotIds");
        } else {
            ArrayList arrayList = new ArrayList(listM60296b.size());
            Iterator<String> it = listM60296b.iterator();
            while (it.hasNext()) {
                C9031r c9031rM56948a = C9021l0.m56948a(this.f9488a, c9655a.m60304j(), it.next(), c9655a.m60307m());
                if (c9031rM56948a != null) {
                    c9031rM56948a.m56976q();
                    arrayList.add(c9031rM56948a);
                }
            }
            c9020l.m56939j(arrayList);
            c9020l.m56937g(200);
        }
        return c9020l;
    }
}
