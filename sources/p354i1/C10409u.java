package p354i1;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import p244e1.C9380d;
import p323h1.C10077a;
import p381j1.C10664i0;
import p381j1.InterfaceC10686t0;
import p481n1.C11603o;

/* renamed from: i1.u */
/* loaded from: classes.dex */
public class C10409u implements InterfaceC10686t0, InterfaceC10408t {

    /* renamed from: a */
    public static C10409u f50235a = new C10409u();

    @Override // p354i1.InterfaceC10408t
    /* renamed from: b */
    public <T> T mo63891b(C10077a c10077a, Type type, Object obj) {
        if (type == OptionalInt.class) {
            Integer numM69320t = C11603o.m69320t(c10077a.m62721b0(Integer.class));
            return numM69320t == null ? (T) OptionalInt.empty() : (T) OptionalInt.of(numM69320t.intValue());
        }
        if (type == OptionalLong.class) {
            Long lM69324v = C11603o.m69324v(c10077a.m62721b0(Long.class));
            return lM69324v == null ? (T) OptionalLong.empty() : (T) OptionalLong.of(lM69324v.longValue());
        }
        if (type == OptionalDouble.class) {
            Double dM69314q = C11603o.m69314q(c10077a.m62721b0(Double.class));
            return dM69314q == null ? (T) OptionalDouble.empty() : (T) OptionalDouble.of(dM69314q.doubleValue());
        }
        Object objM62722c0 = c10077a.m62722c0(C11603o.m69270O0(type));
        return objM62722c0 == null ? (T) Optional.empty() : (T) Optional.of(objM62722c0);
    }

    @Override // p354i1.InterfaceC10408t
    /* renamed from: c */
    public int mo63892c() {
        return 12;
    }

    @Override // p381j1.InterfaceC10686t0
    /* renamed from: e */
    public void mo63933e(C10664i0 c10664i0, Object obj, Object obj2, Type type, int i10) throws IOException {
        if (obj == null) {
            c10664i0.m65264I();
            return;
        }
        if (obj instanceof Optional) {
            Optional optional = (Optional) obj;
            c10664i0.m65262G(optional.isPresent() ? optional.get() : null);
            return;
        }
        if (obj instanceof OptionalDouble) {
            OptionalDouble optionalDouble = (OptionalDouble) obj;
            if (optionalDouble.isPresent()) {
                c10664i0.m65262G(Double.valueOf(optionalDouble.getAsDouble()));
                return;
            } else {
                c10664i0.m65264I();
                return;
            }
        }
        if (obj instanceof OptionalInt) {
            OptionalInt optionalInt = (OptionalInt) obj;
            if (optionalInt.isPresent()) {
                c10664i0.f51258k.m65219X(optionalInt.getAsInt());
                return;
            } else {
                c10664i0.m65264I();
                return;
            }
        }
        if (!(obj instanceof OptionalLong)) {
            throw new C9380d("not support optional : " + obj.getClass());
        }
        OptionalLong optionalLong = (OptionalLong) obj;
        if (optionalLong.isPresent()) {
            c10664i0.f51258k.m65221Z(optionalLong.getAsLong());
        } else {
            c10664i0.m65264I();
        }
    }
}
