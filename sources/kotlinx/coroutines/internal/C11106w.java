package kotlinx.coroutines.internal;

/* renamed from: kotlinx.coroutines.internal.w */
/* loaded from: classes9.dex */
public final /* synthetic */ class C11106w {

    /* renamed from: a */
    public static final int f52333a = Runtime.getRuntime().availableProcessors();

    /* renamed from: a */
    public static final int m66810a() {
        return f52333a;
    }

    /* renamed from: b */
    public static final String m66811b(String str) {
        try {
            return System.getProperty(str);
        } catch (SecurityException unused) {
            return null;
        }
    }
}
