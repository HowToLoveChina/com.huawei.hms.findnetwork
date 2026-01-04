package com.huawei.uikit.hwcolumnsystem.widget;

import android.util.Log;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/* loaded from: classes7.dex */
public class HwColumnSplitHandler implements InvocationHandler {

    /* renamed from: a */
    private static final String f41782a = "HwColumnSplitHandler";

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        if (method != null && objArr != null && "onSplitChanged".equals(method.getName()) && objArr.length > 0) {
            Log.i(f41782a, "onSplitChanged: " + objArr[0]);
        }
        return null;
    }
}
