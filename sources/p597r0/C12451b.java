package p597r0;

import androidx.lifecycle.AbstractC0780b0;
import androidx.lifecycle.C0782c0;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import p692uw.C13267j;

/* renamed from: r0.b */
/* loaded from: classes.dex */
public final class C12451b implements C0782c0.b {

    /* renamed from: b */
    public final C12454e<?>[] f57375b;

    public C12451b(C12454e<?>... c12454eArr) {
        C13267j.m79677e(c12454eArr, "initializers");
        this.f57375b = c12454eArr;
    }

    @Override // androidx.lifecycle.C0782c0.b
    /* renamed from: b */
    public <T extends AbstractC0780b0> T mo4933b(Class<T> cls, AbstractC12450a abstractC12450a) {
        C13267j.m79677e(cls, "modelClass");
        C13267j.m79677e(abstractC12450a, JsbMapKeyNames.H5_EXTRAS);
        T t10 = null;
        for (C12454e<?> c12454e : this.f57375b) {
            if (C13267j.m79673a(c12454e.m74709a(), cls)) {
                T tMo5000c = c12454e.m74710b().mo5000c(abstractC12450a);
                t10 = tMo5000c instanceof AbstractC0780b0 ? tMo5000c : null;
            }
        }
        if (t10 != null) {
            return t10;
        }
        throw new IllegalArgumentException("No initializer set for given class " + cls.getName());
    }
}
