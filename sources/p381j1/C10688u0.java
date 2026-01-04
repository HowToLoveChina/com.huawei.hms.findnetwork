package p381j1;

import java.io.IOException;
import java.lang.reflect.Type;

/* renamed from: j1.u0 */
/* loaded from: classes.dex */
public class C10688u0 implements InterfaceC10686t0 {

    /* renamed from: a */
    public static C10688u0 f51325a = new C10688u0();

    @Override // p381j1.InterfaceC10686t0
    /* renamed from: e */
    public final void mo63933e(C10664i0 c10664i0, Object obj, Object obj2, Type type, int i10) throws IOException {
        C10650d1 c10650d1 = c10664i0.f51258k;
        if (obj == null) {
            c10650d1.m65226c0(EnumC10653e1.WriteNullListAsEmpty);
            return;
        }
        int i11 = 0;
        if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            c10650d1.write(91);
            while (i11 < iArr.length) {
                if (i11 != 0) {
                    c10650d1.write(44);
                }
                c10650d1.m65219X(iArr[i11]);
                i11++;
            }
            c10650d1.write(93);
            return;
        }
        if (obj instanceof short[]) {
            short[] sArr = (short[]) obj;
            c10650d1.write(91);
            while (i11 < sArr.length) {
                if (i11 != 0) {
                    c10650d1.write(44);
                }
                c10650d1.m65219X(sArr[i11]);
                i11++;
            }
            c10650d1.write(93);
            return;
        }
        if (obj instanceof long[]) {
            long[] jArr = (long[]) obj;
            c10650d1.write(91);
            while (i11 < jArr.length) {
                if (i11 != 0) {
                    c10650d1.write(44);
                }
                c10650d1.m65221Z(jArr[i11]);
                i11++;
            }
            c10650d1.write(93);
            return;
        }
        if (obj instanceof boolean[]) {
            boolean[] zArr = (boolean[]) obj;
            c10650d1.write(91);
            while (i11 < zArr.length) {
                if (i11 != 0) {
                    c10650d1.write(44);
                }
                c10650d1.m65238x(zArr[i11]);
                i11++;
            }
            c10650d1.write(93);
            return;
        }
        if (obj instanceof float[]) {
            float[] fArr = (float[]) obj;
            c10650d1.write(91);
            while (i11 < fArr.length) {
                if (i11 != 0) {
                    c10650d1.write(44);
                }
                float f10 = fArr[i11];
                if (Float.isNaN(f10)) {
                    c10650d1.m65222a0();
                } else {
                    c10650d1.append(Float.toString(f10));
                }
                i11++;
            }
            c10650d1.write(93);
            return;
        }
        if (!(obj instanceof double[])) {
            if (obj instanceof byte[]) {
                c10650d1.m65239y((byte[]) obj);
                return;
            } else {
                c10650d1.m65229i0((char[]) obj);
                return;
            }
        }
        double[] dArr = (double[]) obj;
        c10650d1.write(91);
        while (i11 < dArr.length) {
            if (i11 != 0) {
                c10650d1.write(44);
            }
            double d10 = dArr[i11];
            if (Double.isNaN(d10)) {
                c10650d1.m65222a0();
            } else {
                c10650d1.append(Double.toString(d10));
            }
            i11++;
        }
        c10650d1.write(93);
    }
}
