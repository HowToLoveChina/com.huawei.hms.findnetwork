package p531or;

import android.content.Context;

/* renamed from: or.a */
/* loaded from: classes8.dex */
public class C11991a {

    /* renamed from: a */
    public static Context f55783a;

    /* renamed from: b */
    public static Context f55784b;

    /* renamed from: a */
    public static Context m72145a() {
        Context context = f55783a;
        if (context != null) {
            return context;
        }
        throw new NullPointerException("Context is null , must init first!");
    }

    /* renamed from: b */
    public static Context m72146b() {
        Context context = f55784b;
        return context == null ? f55783a : context;
    }

    /* renamed from: c */
    public static void m72147c(Context context) {
        if (f55783a == null) {
            f55783a = context.getApplicationContext();
        }
    }
}
