package com.huawei.hwcloudjs.core.p153a;

import android.text.TextUtils;
import com.huawei.hwcloudjs.annotation.JSMethod;
import com.huawei.hwcloudjs.core.JSRequest;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.huawei.hwcloudjs.core.a.b */
/* loaded from: classes8.dex */
public class C6623b {

    /* renamed from: a */
    private static C6623b f30804a = new C6623b();

    /* renamed from: b */
    private final Map<String, C6622a> f30805b = new HashMap();

    /* renamed from: a */
    public C6622a m37766a(String str) {
        return this.f30805b.get(str);
    }

    /* renamed from: b */
    public void m37768b(String str) {
        if (this.f30805b.containsKey(str)) {
            this.f30805b.remove(str);
        }
    }

    /* renamed from: a */
    public static C6623b m37765a() {
        return f30804a;
    }

    /* renamed from: a */
    public void m37767a(Class<? extends JSRequest> cls) throws SecurityException {
        for (Method method : cls.getMethods()) {
            if (method.isAnnotationPresent(JSMethod.class)) {
                String strName = ((JSMethod) method.getAnnotation(JSMethod.class)).name();
                if (TextUtils.isEmpty(strName)) {
                    strName = method.getName();
                }
                this.f30805b.put(strName, new C6622a(method));
            }
        }
    }
}
