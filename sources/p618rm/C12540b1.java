package p618rm;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import java.lang.reflect.Type;
import p399jk.AbstractC10896a;

/* renamed from: rm.b1 */
/* loaded from: classes6.dex */
public class C12540b1 {
    /* renamed from: a */
    public static <T> T m75483a(String str, Class<T> cls) {
        try {
            return (T) new Gson().fromJson(str, (Class) cls);
        } catch (JsonSyntaxException unused) {
            AbstractC10896a.m65886e("GsonUtil", "json err = " + str);
            return null;
        }
    }

    /* renamed from: b */
    public static <T> T m75484b(String str, Type type) {
        try {
            return (T) new Gson().fromJson(str, type);
        } catch (JsonSyntaxException unused) {
            AbstractC10896a.m65886e("GsonUtil", "json err = " + str);
            return null;
        }
    }

    /* renamed from: c */
    public static String m75485c(Object obj) {
        return new Gson().toJson(obj);
    }
}
