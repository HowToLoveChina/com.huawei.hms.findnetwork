package p521og;

import android.content.Context;
import java.lang.reflect.Field;
import p015ak.C0241z;
import p809yg.C13981a;

/* renamed from: og.g */
/* loaded from: classes4.dex */
public final class C11874g {
    /* renamed from: a */
    public static int m71188a(Context context, String str) {
        return m71189b(context, "raw", str);
    }

    /* renamed from: b */
    public static int m71189b(Context context, String str, String str2) throws NoSuchFieldException {
        try {
            int identifier = context.getResources().getIdentifier(str2, str, context.getPackageName());
            if (identifier != 0) {
                return identifier;
            }
            Field field = Class.forName(context.getPackageName() + ".R$" + str).getField(str2);
            return C0241z.m1685c(field.get(field.getName()).toString());
        } catch (ClassNotFoundException unused) {
            C13981a.m83988e("ResourceLoader", "!!!! ResourceLoader: reflect resource error-resourceType=" + str + "--resourceName=" + str2);
            return 0;
        } catch (IllegalAccessException e10) {
            C13981a.m83988e("ResourceLoader", "!!!! ResourceLoader: reflect resource error-resourceType=" + str + "--resourceName=" + str2 + e10.getMessage());
            return 0;
        } catch (NoSuchFieldException e11) {
            C13981a.m83988e("ResourceLoader", "!!!! ResourceLoader: reflect resource error-resourceType=" + str + "--resourceName=" + str2 + e11.getMessage());
            return 0;
        }
    }
}
