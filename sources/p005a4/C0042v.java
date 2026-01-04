package p005a4;

/* renamed from: a4.v */
/* loaded from: classes.dex */
public class C0042v {
    /* renamed from: a */
    public static int m163a() {
        try {
            return Class.forName("android.os.Build$VERSION").getDeclaredField("SDK_INT").getInt(null);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException unused) {
            return -1;
        }
    }

    /* renamed from: b */
    public static boolean m164b() throws ClassNotFoundException {
        try {
            Class.forName("android.app.Application", false, null);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
