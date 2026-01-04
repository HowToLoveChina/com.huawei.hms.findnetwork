package com.huawei.openalliance.p169ad.utils;

import android.content.Context;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: com.huawei.openalliance.ad.utils.bk */
/* loaded from: classes2.dex */
public class C7764bk {

    /* renamed from: a */
    private static Class<?> f35946a;

    /* renamed from: b */
    private static Method f35947b;

    /* renamed from: c */
    private static Method f35948c;

    /* renamed from: d */
    private static Method f35949d;

    /* renamed from: e */
    private static Method f35950e;

    /* renamed from: f */
    private static Object f35951f;

    static {
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            f35946a = cls;
            f35951f = cls.newInstance();
            f35949d = f35946a.getMethod("getUDID", Context.class);
            f35948c = f35946a.getMethod("getOAID", Context.class);
            f35950e = f35946a.getMethod("getVAID", Context.class);
            f35947b = f35946a.getMethod("getAAID", Context.class);
        } catch (Exception e10) {
            AbstractC7185ho.m43827d("MIdentifierManager", "reflect exception, %s", e10.getClass().getSimpleName());
        }
    }

    /* renamed from: a */
    public static String m47800a(Context context) {
        return m47801a(context, f35948c);
    }

    /* renamed from: a */
    private static String m47801a(Context context, Method method) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Object obj = f35951f;
        if (obj == null || method == null) {
            return null;
        }
        try {
            Object objInvoke = method.invoke(obj, context);
            if (objInvoke != null) {
                return (String) objInvoke;
            }
            return null;
        } catch (Exception e10) {
            AbstractC7185ho.m43827d("MIdentifierManager", "invoke exception, %s", e10.getClass().getSimpleName());
            return null;
        }
    }
}
