package p216d4;

import android.content.Context;
import com.huawei.ads.adsrec.C2097s;
import p277f4.C9655a;
import p405jt.AbstractC10915a;

/* renamed from: d4.f0 */
/* loaded from: classes.dex */
public class C9009f0 extends AbstractC9039z {
    public C9009f0(Context context, InterfaceC9028p interfaceC9028p) {
        super(context, interfaceC9028p);
    }

    @Override // p216d4.InterfaceC9011g0
    /* renamed from: a */
    public <T> C9020l mo56873a(C9655a c9655a, C9020l c9020l) {
        AbstractC10915a.m65972d("CROS", "recall via api");
        return new C2097s(this.f45699a).mo12549a(c9655a, c9020l);
    }

    @Override // p216d4.InterfaceC9011g0
    /* renamed from: b */
    public <T> C9020l mo56874b(C9655a c9655a, T t10) {
        AbstractC10915a.m65972d("CROS", "recall");
        return new C2097s(this.f45699a).mo12550b(c9655a, t10);
    }
}
