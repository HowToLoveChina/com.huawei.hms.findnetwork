package p024b0;

import android.content.Context;
import android.os.UserManager;

/* renamed from: b0.k */
/* loaded from: classes.dex */
public class C1095k {

    /* renamed from: b0.k$a */
    public static class a {
        /* renamed from: a */
        public static boolean m6495a(Context context) {
            return ((UserManager) context.getSystemService(UserManager.class)).isUserUnlocked();
        }
    }

    /* renamed from: a */
    public static boolean m6494a(Context context) {
        return a.m6495a(context);
    }
}
