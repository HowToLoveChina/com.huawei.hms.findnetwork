package p293fp;

import android.content.Intent;
import cn.C1462b;

/* renamed from: fp.a */
/* loaded from: classes.dex */
public class C9738a {
    /* renamed from: a */
    public static Intent m60790a(Intent intent, String str) {
        try {
            intent.setPackage(str);
        } catch (Exception e10) {
            C1462b.m8361b("SafeIntentUtils", "safeSetPackage exception: " + e10.getMessage());
        }
        return intent;
    }
}
