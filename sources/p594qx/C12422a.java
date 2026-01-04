package p594qx;

/* renamed from: qx.a */
/* loaded from: classes9.dex */
public class C12422a {
    /* renamed from: a */
    public static boolean m74569a(byte b10, int i10) {
        return ((1 << i10) & ((long) b10)) != 0;
    }

    /* renamed from: b */
    public static byte m74570b(byte b10, int i10) {
        return (byte) (b10 | (1 << i10));
    }

    /* renamed from: c */
    public static byte m74571c(byte b10, int i10) {
        return (byte) (b10 & (~(1 << i10)));
    }
}
