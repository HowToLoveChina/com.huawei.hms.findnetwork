package com.huawei.hms.support.hwid.common.p146e;

import android.content.Context;
import java.lang.reflect.Field;

/* renamed from: com.huawei.hms.support.hwid.common.e.h */
/* loaded from: classes8.dex */
public class C6478h {
    /* renamed from: a */
    public static int m36909a(Context context, String str, String str2) throws NoSuchFieldException, NumberFormatException {
        try {
            int identifier = context.getResources().getIdentifier(str2, str, context.getPackageName());
            if (identifier == 0) {
                Field field = Class.forName(context.getPackageName() + ".R$" + str).getField(str2);
                identifier = Integer.parseInt(field.get(field.getName()).toString());
                if (identifier == 0) {
                    C6477g.m36903a("ResourceLoader", "resourceId == 0");
                }
            }
            return identifier;
        } catch (ClassNotFoundException unused) {
            C6477g.m36905b("ResourceLoader", "!!!! ResourceLoader: reflect resource ClassNotFoundException");
            return 0;
        } catch (IllegalAccessException unused2) {
            C6477g.m36905b("ResourceLoader", "!!!! ResourceLoader: reflect resource IllegalAccessException");
            return 0;
        } catch (NumberFormatException unused3) {
            C6477g.m36905b("ResourceLoader", "!!!! ResourceLoader: reflect resource NumberFormatException");
            return 0;
        } catch (IllegalArgumentException unused4) {
            C6477g.m36905b("ResourceLoader", "!!!! ResourceLoader: reflect resource IllegalArgumentException");
            return 0;
        } catch (LinkageError unused5) {
            C6477g.m36905b("ResourceLoader", "!!!! ResourceLoader: reflect resource LinkageError");
            return 0;
        } catch (RuntimeException unused6) {
            C6477g.m36905b("ResourceLoader", "!!!! ResourceLoader: reflect resource RuntimeException");
            return 0;
        } catch (Exception unused7) {
            C6477g.m36905b("ResourceLoader", "!!!! ResourceLoader: reflect resource Exception");
            return 0;
        }
    }

    /* renamed from: a */
    public static int m36908a(Context context, String str) {
        return m36909a(context, "xml", str);
    }
}
