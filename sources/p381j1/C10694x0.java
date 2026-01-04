package p381j1;

import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicReference;
import p323h1.C10077a;
import p354i1.InterfaceC10408t;

/* renamed from: j1.x0 */
/* loaded from: classes.dex */
public class C10694x0 implements InterfaceC10686t0, InterfaceC10408t {

    /* renamed from: a */
    public static final C10694x0 f51329a = new C10694x0();

    @Override // p354i1.InterfaceC10408t
    /* renamed from: b */
    public <T> T mo63891b(C10077a c10077a, Type type, Object obj) {
        ParameterizedType parameterizedType = (ParameterizedType) type;
        Object objM62722c0 = c10077a.m62722c0(parameterizedType.getActualTypeArguments()[0]);
        Type rawType = parameterizedType.getRawType();
        if (rawType == AtomicReference.class) {
            return (T) new AtomicReference(objM62722c0);
        }
        if (rawType == WeakReference.class) {
            return (T) new WeakReference(objM62722c0);
        }
        if (rawType == SoftReference.class) {
            return (T) new SoftReference(objM62722c0);
        }
        throw new UnsupportedOperationException(rawType.toString());
    }

    @Override // p354i1.InterfaceC10408t
    /* renamed from: c */
    public int mo63892c() {
        return 12;
    }

    @Override // p381j1.InterfaceC10686t0
    /* renamed from: e */
    public void mo63933e(C10664i0 c10664i0, Object obj, Object obj2, Type type, int i10) throws IOException {
        c10664i0.m65262G(obj instanceof AtomicReference ? ((AtomicReference) obj).get() : ((Reference) obj).get());
    }
}
