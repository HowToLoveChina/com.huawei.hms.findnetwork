package p025b1;

import android.os.Parcelable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import p438l.C11207a;

/* renamed from: b1.a */
/* loaded from: classes.dex */
public abstract class AbstractC1096a {

    /* renamed from: a */
    public final C11207a<String, Method> f5213a;

    /* renamed from: b */
    public final C11207a<String, Method> f5214b;

    /* renamed from: c */
    public final C11207a<String, Class> f5215c;

    public AbstractC1096a(C11207a<String, Method> c11207a, C11207a<String, Method> c11207a2, C11207a<String, Class> c11207a3) {
        this.f5213a = c11207a;
        this.f5214b = c11207a2;
        this.f5215c = c11207a3;
    }

    /* renamed from: A */
    public abstract void mo6496A(byte[] bArr);

    /* renamed from: B */
    public void m6497B(byte[] bArr, int i10) {
        mo6532w(i10);
        mo6496A(bArr);
    }

    /* renamed from: C */
    public abstract void mo6498C(CharSequence charSequence);

    /* renamed from: D */
    public void m6499D(CharSequence charSequence, int i10) {
        mo6532w(i10);
        mo6498C(charSequence);
    }

    /* renamed from: E */
    public abstract void mo6500E(int i10);

    /* renamed from: F */
    public void m6501F(int i10, int i11) {
        mo6532w(i11);
        mo6500E(i10);
    }

    /* renamed from: G */
    public abstract void mo6502G(Parcelable parcelable);

    /* renamed from: H */
    public void m6503H(Parcelable parcelable, int i10) {
        mo6532w(i10);
        mo6502G(parcelable);
    }

    /* renamed from: I */
    public abstract void mo6504I(String str);

    /* renamed from: J */
    public void m6505J(String str, int i10) {
        mo6532w(i10);
        mo6504I(str);
    }

    /* renamed from: K */
    public <T extends InterfaceC1098c> void m6506K(T t10, AbstractC1096a abstractC1096a) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            m6514e(t10.getClass()).invoke(null, t10, abstractC1096a);
        } catch (ClassNotFoundException e10) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e10);
        } catch (IllegalAccessException e11) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e11);
        } catch (NoSuchMethodException e12) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e12);
        } catch (InvocationTargetException e13) {
            if (!(e13.getCause() instanceof RuntimeException)) {
                throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e13);
            }
            throw ((RuntimeException) e13.getCause());
        }
    }

    /* renamed from: L */
    public void m6507L(InterfaceC1098c interfaceC1098c) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (interfaceC1098c == null) {
            mo6504I(null);
            return;
        }
        m6509N(interfaceC1098c);
        AbstractC1096a abstractC1096aMo6511b = mo6511b();
        m6506K(interfaceC1098c, abstractC1096aMo6511b);
        abstractC1096aMo6511b.mo6510a();
    }

    /* renamed from: M */
    public void m6508M(InterfaceC1098c interfaceC1098c, int i10) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        mo6532w(i10);
        m6507L(interfaceC1098c);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: N */
    public final void m6509N(InterfaceC1098c interfaceC1098c) {
        try {
            mo6504I(m6512c(interfaceC1098c.getClass()).getName());
        } catch (ClassNotFoundException e10) {
            throw new RuntimeException(interfaceC1098c.getClass().getSimpleName() + " does not have a Parcelizer", e10);
        }
    }

    /* renamed from: a */
    public abstract void mo6510a();

    /* renamed from: b */
    public abstract AbstractC1096a mo6511b();

    /* renamed from: c */
    public final Class m6512c(Class<? extends InterfaceC1098c> cls) throws ClassNotFoundException {
        Class cls2 = this.f5215c.get(cls.getName());
        if (cls2 != null) {
            return cls2;
        }
        Class<?> cls3 = Class.forName(String.format("%s.%sParcelizer", cls.getPackage().getName(), cls.getSimpleName()), false, cls.getClassLoader());
        this.f5215c.put(cls.getName(), cls3);
        return cls3;
    }

    /* renamed from: d */
    public final Method m6513d(String str) throws IllegalAccessException, NoSuchMethodException, SecurityException, ClassNotFoundException {
        Method method = this.f5213a.get(str);
        if (method != null) {
            return method;
        }
        System.currentTimeMillis();
        Method declaredMethod = Class.forName(str, true, AbstractC1096a.class.getClassLoader()).getDeclaredMethod("read", AbstractC1096a.class);
        this.f5213a.put(str, declaredMethod);
        return declaredMethod;
    }

    /* renamed from: e */
    public final Method m6514e(Class cls) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, SecurityException {
        Method method = this.f5214b.get(cls.getName());
        if (method != null) {
            return method;
        }
        Class clsM6512c = m6512c(cls);
        System.currentTimeMillis();
        Method declaredMethod = clsM6512c.getDeclaredMethod("write", cls, AbstractC1096a.class);
        this.f5214b.put(cls.getName(), declaredMethod);
        return declaredMethod;
    }

    /* renamed from: f */
    public boolean m6515f() {
        return false;
    }

    /* renamed from: g */
    public abstract boolean mo6516g();

    /* renamed from: h */
    public boolean m6517h(boolean z10, int i10) {
        return !mo6522m(i10) ? z10 : mo6516g();
    }

    /* renamed from: i */
    public abstract byte[] mo6518i();

    /* renamed from: j */
    public byte[] m6519j(byte[] bArr, int i10) {
        return !mo6522m(i10) ? bArr : mo6518i();
    }

    /* renamed from: k */
    public abstract CharSequence mo6520k();

    /* renamed from: l */
    public CharSequence m6521l(CharSequence charSequence, int i10) {
        return !mo6522m(i10) ? charSequence : mo6520k();
    }

    /* renamed from: m */
    public abstract boolean mo6522m(int i10);

    /* renamed from: n */
    public <T extends InterfaceC1098c> T m6523n(String str, AbstractC1096a abstractC1096a) {
        try {
            return (T) m6513d(str).invoke(null, abstractC1096a);
        } catch (ClassNotFoundException e10) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e10);
        } catch (IllegalAccessException e11) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e11);
        } catch (NoSuchMethodException e12) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e12);
        } catch (InvocationTargetException e13) {
            if (e13.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e13.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e13);
        }
    }

    /* renamed from: o */
    public abstract int mo6524o();

    /* renamed from: p */
    public int m6525p(int i10, int i11) {
        return !mo6522m(i11) ? i10 : mo6524o();
    }

    /* renamed from: q */
    public abstract <T extends Parcelable> T mo6526q();

    /* renamed from: r */
    public <T extends Parcelable> T m6527r(T t10, int i10) {
        return !mo6522m(i10) ? t10 : (T) mo6526q();
    }

    /* renamed from: s */
    public abstract String mo6528s();

    /* renamed from: t */
    public String m6529t(String str, int i10) {
        return !mo6522m(i10) ? str : mo6528s();
    }

    /* renamed from: u */
    public <T extends InterfaceC1098c> T m6530u() {
        String strMo6528s = mo6528s();
        if (strMo6528s == null) {
            return null;
        }
        return (T) m6523n(strMo6528s, mo6511b());
    }

    /* renamed from: v */
    public <T extends InterfaceC1098c> T m6531v(T t10, int i10) {
        return !mo6522m(i10) ? t10 : (T) m6530u();
    }

    /* renamed from: w */
    public abstract void mo6532w(int i10);

    /* renamed from: x */
    public void m6533x(boolean z10, boolean z11) {
    }

    /* renamed from: y */
    public abstract void mo6534y(boolean z10);

    /* renamed from: z */
    public void m6535z(boolean z10, int i10) {
        mo6532w(i10);
        mo6534y(z10);
    }
}
