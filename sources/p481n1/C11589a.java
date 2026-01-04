package p481n1;

import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.ProtectionDomain;
import java.util.HashMap;
import java.util.Map;
import p244e1.AbstractC9377a;
import p244e1.C9378b;
import p244e1.C9380d;
import p244e1.C9381e;
import p244e1.C9383g;
import p244e1.C9384h;
import p244e1.C9385i;
import p244e1.C9388l;
import p244e1.C9390n;
import p244e1.InterfaceC9379c;
import p244e1.InterfaceC9386j;
import p323h1.AbstractC10080d;
import p323h1.C10077a;
import p323h1.C10081e;
import p323h1.C10082f;
import p323h1.C10083g;
import p323h1.C10084h;
import p323h1.C10085i;
import p323h1.C10086j;
import p323h1.EnumC10078b;
import p323h1.InterfaceC10079c;
import p354i1.AbstractC10400l;
import p354i1.C10394f;
import p354i1.C10403o;
import p354i1.InterfaceC10392d;
import p354i1.InterfaceC10397i;
import p354i1.InterfaceC10398j;
import p354i1.InterfaceC10399k;
import p354i1.InterfaceC10408t;
import p381j1.AbstractC10645c;
import p381j1.AbstractC10647c1;
import p381j1.AbstractC10667k;
import p381j1.C10641a1;
import p381j1.C10650d1;
import p381j1.C10664i0;
import p381j1.C10665j;
import p381j1.C10666j0;
import p381j1.C10672m0;
import p381j1.C10696y0;
import p381j1.C10698z0;
import p381j1.EnumC10653e1;
import p381j1.InterfaceC10644b1;
import p381j1.InterfaceC10662h1;
import p381j1.InterfaceC10670l0;
import p381j1.InterfaceC10682r0;
import p381j1.InterfaceC10686t0;
import p381j1.InterfaceC10687u;
import p381j1.InterfaceC10689v;
import p381j1.InterfaceC10690v0;
import p381j1.InterfaceC10692w0;

/* renamed from: n1.a */
/* loaded from: classes.dex */
public class C11589a extends ClassLoader {

    /* renamed from: b */
    public static Map<String, Class<?>> f53765b = new HashMap();

    /* renamed from: a */
    public static ProtectionDomain f53764a = (ProtectionDomain) AccessController.doPrivileged(new a());

    /* renamed from: n1.a$a */
    public static class a implements PrivilegedAction<Object> {
        @Override // java.security.PrivilegedAction
        public Object run() {
            return C11589a.class.getProtectionDomain();
        }
    }

    static {
        Class<?>[] clsArr = {AbstractC9377a.class, C9381e.class, C9378b.class, C9383g.class, InterfaceC9379c.class, C9380d.class, C9384h.class, C9385i.class, InterfaceC9386j.class, C9388l.class, C9390n.class, C11592d.class, C11603o.class, C11595g.class, C11596h.class, C11599k.class, C11597i.class, InterfaceC10686t0.class, C10666j0.class, AbstractC10647c1.class, C10698z0.class, C10664i0.class, C10650d1.class, InterfaceC10644b1.class, C10672m0.class, InterfaceC10670l0.class, InterfaceC10689v.class, AbstractC10645c.class, AbstractC10667k.class, InterfaceC10682r0.class, InterfaceC10690v0.class, InterfaceC10692w0.class, InterfaceC10662h1.class, EnumC10653e1.class, InterfaceC10687u.class, C10696y0.class, C10641a1.class, C10403o.class, C10085i.class, C10077a.class, InterfaceC10079c.class, AbstractC10080d.class, C10084h.class, C10083g.class, C10086j.class, EnumC10078b.class, C10082f.class, C10081e.class, InterfaceC10392d.class, InterfaceC10408t.class, InterfaceC10398j.class, InterfaceC10397i.class, InterfaceC10399k.class, C10665j.class, AbstractC10400l.class, C10394f.class};
        for (int i10 = 0; i10 < 56; i10++) {
            Class<?> cls = clsArr[i10];
            f53765b.put(cls.getName(), cls);
        }
    }

    public C11589a() {
        super(m69181b());
    }

    /* renamed from: b */
    public static ClassLoader m69181b() throws ClassNotFoundException {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        if (contextClassLoader != null) {
            try {
                contextClassLoader.loadClass(AbstractC9377a.class.getName());
                return contextClassLoader;
            } catch (ClassNotFoundException unused) {
            }
        }
        return AbstractC9377a.class.getClassLoader();
    }

    /* renamed from: a */
    public Class<?> m69182a(String str, byte[] bArr, int i10, int i11) throws ClassFormatError {
        return defineClass(str, bArr, i10, i11, f53764a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.ClassLoader] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* renamed from: c */
    public boolean m69183c(Class<?> cls) {
        ClassLoader classLoader = cls.getClassLoader();
        if (classLoader == null) {
            return false;
        }
        for (?? parent = this; parent != 0; parent = parent.getParent()) {
            if (parent == classLoader) {
                return false;
            }
        }
        return true;
    }

    @Override // java.lang.ClassLoader
    public Class<?> loadClass(String str, boolean z10) throws ClassNotFoundException {
        Class<?> cls = f53765b.get(str);
        return cls != null ? cls : super.loadClass(str, z10);
    }

    public C11589a(ClassLoader classLoader) {
        super(classLoader);
    }
}
