package mv;

import android.util.Log;
import java.lang.reflect.InvocationTargetException;

/* renamed from: mv.d */
/* loaded from: classes9.dex */
public class C11531d {

    /* renamed from: a */
    public static final String f53484a = "d";

    /* renamed from: a */
    public static String m68820a(String str, String str2) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            Object objInvoke = cls.getDeclaredMethod("get", String.class, String.class).invoke(cls, str, str2);
            if (objInvoke instanceof String) {
                return (String) objInvoke;
            }
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException unused) {
            Log.e(f53484a, "An exception occurred while reading string system properties: " + str);
        }
        return str2;
    }
}
