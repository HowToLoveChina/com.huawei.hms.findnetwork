package p354i1;

import java.lang.reflect.Type;
import p244e1.C9380d;
import p323h1.C10077a;

/* renamed from: i1.x */
/* loaded from: classes.dex */
public class C10412x implements InterfaceC10408t {

    /* renamed from: a */
    public final Class<InterfaceC10411w> f50236a;

    public C10412x(Class<InterfaceC10411w> cls) {
        this.f50236a = cls;
    }

    @Override // p354i1.InterfaceC10408t
    /* renamed from: b */
    public <T> T mo63891b(C10077a c10077a, Type type, Object obj) {
        try {
            return (T) c10077a.m62713H(this.f50236a.newInstance(), obj);
        } catch (Exception unused) {
            throw new C9380d("craete instance error");
        }
    }

    @Override // p354i1.InterfaceC10408t
    /* renamed from: c */
    public int mo63892c() {
        return 12;
    }
}
