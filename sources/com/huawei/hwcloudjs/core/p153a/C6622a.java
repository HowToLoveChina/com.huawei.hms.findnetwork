package com.huawei.hwcloudjs.core.p153a;

import com.huawei.hwcloudjs.core.JSRequest;
import com.huawei.hwcloudjs.core.JsCallback;
import com.huawei.hwcloudjs.p164f.C6659d;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: com.huawei.hwcloudjs.core.a.a */
/* loaded from: classes8.dex */
public final class C6622a {

    /* renamed from: a */
    private Method f30802a;

    /* renamed from: b */
    private Class<?> f30803b;

    public C6622a(Method method) {
        Class<?> cls;
        this.f30803b = null;
        this.f30802a = method;
        Class<?>[] parameterTypes = method.getParameterTypes();
        if (parameterTypes.length <= 0 || JsCallback.class == (cls = parameterTypes[0])) {
            return;
        }
        this.f30803b = cls;
    }

    /* renamed from: a */
    public Method m37762a() {
        return this.f30802a;
    }

    /* renamed from: b */
    public Class<?> m37764b() {
        return this.f30803b;
    }

    /* renamed from: a */
    public void m37763a(Object obj, JsCallback jsCallback) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
        String str;
        try {
            Object objNewInstance = this.f30802a.getDeclaringClass().newInstance();
            if (objNewInstance instanceof JSRequest) {
                ((JSRequest) objNewInstance).execute(this.f30802a, obj, jsCallback);
            } else {
                C6659d.m37881b("CallObject", "clazz.newInstance() is not JSRequest type", true);
            }
        } catch (IllegalAccessException unused) {
            str = "call IllegalAccessException";
            C6659d.m37881b("CallObject", str, true);
        } catch (InstantiationException unused2) {
            str = "call InstantiationException";
            C6659d.m37881b("CallObject", str, true);
        }
    }
}
