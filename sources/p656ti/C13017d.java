package p656ti;

/* renamed from: ti.d */
/* loaded from: classes.dex */
public final class C13017d {

    /* renamed from: a */
    public static final ThreadLocal<char[]> f59275a = new a();

    /* renamed from: ti.d$a */
    public class a extends ThreadLocal<char[]> {
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public char[] initialValue() {
            return new char[1024];
        }
    }

    /* renamed from: a */
    public static char[] m78333a() {
        return f59275a.get();
    }
}
