package p381j1;

import java.io.IOException;
import java.lang.reflect.Type;
import java.text.DecimalFormat;

/* renamed from: j1.x */
/* loaded from: classes.dex */
public class C10693x implements InterfaceC10686t0 {

    /* renamed from: b */
    public static final C10693x f51327b = new C10693x();

    /* renamed from: a */
    public DecimalFormat f51328a;

    public C10693x() {
        this.f51328a = null;
    }

    @Override // p381j1.InterfaceC10686t0
    /* renamed from: e */
    public void mo63933e(C10664i0 c10664i0, Object obj, Object obj2, Type type, int i10) throws IOException {
        C10650d1 c10650d1 = c10664i0.f51258k;
        if (obj == null) {
            c10650d1.m65226c0(EnumC10653e1.WriteNullNumberAsZero);
            return;
        }
        double dDoubleValue = ((Double) obj).doubleValue();
        if (Double.isNaN(dDoubleValue) || Double.isInfinite(dDoubleValue)) {
            c10650d1.m65222a0();
            return;
        }
        DecimalFormat decimalFormat = this.f51328a;
        if (decimalFormat == null) {
            c10650d1.m65240z(dDoubleValue, true);
        } else {
            c10650d1.write(decimalFormat.format(dDoubleValue));
        }
    }

    public C10693x(DecimalFormat decimalFormat) {
        this.f51328a = decimalFormat;
    }

    public C10693x(String str) {
        this(new DecimalFormat(str));
    }
}
