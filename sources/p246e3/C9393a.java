package p246e3;

import android.content.ContentResolver;
import android.provider.Settings;

/* renamed from: e3.a */
/* loaded from: classes.dex */
public class C9393a {
    /* renamed from: a */
    public float m58855a(ContentResolver contentResolver) {
        return Settings.Global.getFloat(contentResolver, "animator_duration_scale", 1.0f);
    }
}
