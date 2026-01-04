package lu;

import android.util.Log;
import java.io.File;

/* renamed from: lu.c */
/* loaded from: classes5.dex */
public class C11344c {
    /* renamed from: a */
    public static void m68148a(File file) {
        if (file == null || !file.exists() || file.delete()) {
            return;
        }
        Log.e("IOUtil", "deleteSecure exception");
    }
}
