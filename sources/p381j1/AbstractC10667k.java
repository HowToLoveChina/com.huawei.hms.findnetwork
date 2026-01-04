package p381j1;

/* renamed from: j1.k */
/* loaded from: classes.dex */
public abstract class AbstractC10667k implements InterfaceC10644b1 {

    /* renamed from: a */
    public static final ThreadLocal<C10664i0> f51276a = new ThreadLocal<>();

    /* renamed from: b */
    public static final ThreadLocal<Character> f51277b = new ThreadLocal<>();

    /* renamed from: c */
    public static final Character f51278c = ',';

    /* renamed from: f */
    public final char m65298f(C10664i0 c10664i0, Object obj, char c10) {
        ThreadLocal<C10664i0> threadLocal = f51276a;
        C10664i0 c10664i02 = threadLocal.get();
        threadLocal.set(c10664i0);
        ThreadLocal<Character> threadLocal2 = f51277b;
        threadLocal2.set(Character.valueOf(c10));
        m65299g(obj);
        threadLocal.set(c10664i02);
        return threadLocal2.get().charValue();
    }

    /* renamed from: g */
    public abstract void m65299g(Object obj);
}
