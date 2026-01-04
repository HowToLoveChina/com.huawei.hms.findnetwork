package com.huawei.phoneservice.faq.base.util;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.C1554j;
import com.bumptech.glide.EnumC1551g;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.huawei.openalliance.p169ad.constant.VastAttribute;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes4.dex */
public class RequestOptionsInvoker {
    @SuppressLint({"CheckResult"})
    public static void invoke(C1554j c1554j, int i10, int i11) throws IllegalAccessException, NoSuchMethodException, InstantiationException, SecurityException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        if (!isHigher48()) {
            c1554j.apply(new RequestOptions().error(i11).placeholder(i10).centerCrop());
            return;
        }
        Object objNewInstance = RequestOptions.class.newInstance();
        Class cls = Integer.TYPE;
        Method method = RequestOptions.class.getMethod("placeholder", cls);
        Method method2 = RequestOptions.class.getMethod(VastAttribute.ERROR, cls);
        Method method3 = RequestOptions.class.getMethod("centerCrop", new Class[0]);
        method.invoke(objNewInstance, Integer.valueOf(i10));
        method2.invoke(objNewInstance, Integer.valueOf(i11));
        method3.invoke(objNewInstance, new Object[0]);
        c1554j.getClass().getMethod("apply", BaseRequestOptions.class).invoke(c1554j, objNewInstance);
    }

    public static boolean isHigher48() {
        return true;
    }

    @SuppressLint({"CheckResult"})
    public static void invoke(C1554j c1554j, int i10, int i11, int i12) throws IllegalAccessException, NoSuchMethodException, InstantiationException, SecurityException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        if (!isHigher48()) {
            c1554j.apply(new RequestOptions().override(i10, i11).placeholder(i12).centerCrop());
            return;
        }
        Object objNewInstance = RequestOptions.class.newInstance();
        Class cls = Integer.TYPE;
        Method method = RequestOptions.class.getMethod("override", cls, cls);
        Method method2 = RequestOptions.class.getMethod("placeholder", cls);
        Method method3 = RequestOptions.class.getMethod("centerCrop", new Class[0]);
        method.invoke(objNewInstance, Integer.valueOf(i10), Integer.valueOf(i11));
        method2.invoke(objNewInstance, Integer.valueOf(i12));
        method3.invoke(objNewInstance, new Object[0]);
        c1554j.getClass().getMethod("apply", BaseRequestOptions.class).invoke(c1554j, objNewInstance);
    }

    @SuppressLint({"CheckResult"})
    public static void invoke(C1554j c1554j, int i10, int i11, Drawable drawable) throws IllegalAccessException, NoSuchMethodException, InstantiationException, SecurityException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        if (!isHigher48()) {
            c1554j.apply(new RequestOptions().override(i10, i11).placeholder(drawable).centerCrop());
            return;
        }
        Object objNewInstance = RequestOptions.class.newInstance();
        Class cls = Integer.TYPE;
        Method method = RequestOptions.class.getMethod("override", cls, cls);
        Method method2 = RequestOptions.class.getMethod("placeholder", Drawable.class);
        Method method3 = RequestOptions.class.getMethod("centerCrop", new Class[0]);
        method.invoke(objNewInstance, Integer.valueOf(i10), Integer.valueOf(i11));
        method2.invoke(objNewInstance, drawable);
        method3.invoke(objNewInstance, new Object[0]);
        c1554j.getClass().getMethod("apply", BaseRequestOptions.class).invoke(c1554j, objNewInstance);
    }

    @SuppressLint({"CheckResult"})
    public static void invoke(C1554j c1554j, int i10, int i11, Drawable drawable, int i12) throws IllegalAccessException, NoSuchMethodException, InstantiationException, SecurityException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        if (!isHigher48()) {
            c1554j.apply(new RequestOptions().override(i10, i11).error(i12).placeholder(drawable).centerCrop());
            return;
        }
        Object objNewInstance = RequestOptions.class.newInstance();
        Class cls = Integer.TYPE;
        Method method = RequestOptions.class.getMethod("override", cls, cls);
        Method method2 = RequestOptions.class.getMethod("placeholder", Drawable.class);
        Method method3 = RequestOptions.class.getMethod(VastAttribute.ERROR, cls);
        method.invoke(objNewInstance, Integer.valueOf(i10), Integer.valueOf(i11));
        method2.invoke(objNewInstance, drawable);
        method3.invoke(objNewInstance, Integer.valueOf(i12));
        RequestOptions.class.getMethod("centerCrop", new Class[0]).invoke(objNewInstance, new Object[0]);
        c1554j.getClass().getMethod("apply", BaseRequestOptions.class).invoke(c1554j, objNewInstance);
    }

    @SuppressLint({"CheckResult"})
    public static void invoke(C1554j c1554j, int i10, int i11, EnumC1551g enumC1551g) throws IllegalAccessException, NoSuchMethodException, InstantiationException, SecurityException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        if (!isHigher48()) {
            c1554j.apply(new RequestOptions().override(i10, i11).priority(enumC1551g));
            return;
        }
        Object objNewInstance = RequestOptions.class.newInstance();
        Method method = c1554j.getClass().getMethod("apply", BaseRequestOptions.class);
        Class cls = Integer.TYPE;
        Method method2 = RequestOptions.class.getMethod("override", cls, cls);
        Method method3 = RequestOptions.class.getMethod("priority", EnumC1551g.class);
        method2.invoke(objNewInstance, Integer.valueOf(i10), Integer.valueOf(i11));
        method3.invoke(objNewInstance, enumC1551g);
        method.invoke(c1554j, objNewInstance);
    }

    @SuppressLint({"CheckResult"})
    public static void invoke(C1554j c1554j, int i10, int i11, EnumC1551g enumC1551g, int i12) throws IllegalAccessException, NoSuchMethodException, InstantiationException, SecurityException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        if (!isHigher48()) {
            c1554j.apply(new RequestOptions().override(i10, i11).priority(enumC1551g).error(i12).fitCenter());
            return;
        }
        Object objNewInstance = RequestOptions.class.newInstance();
        Class cls = Integer.TYPE;
        Method method = RequestOptions.class.getMethod("override", cls, cls);
        Method method2 = RequestOptions.class.getMethod("priority", EnumC1551g.class);
        Method method3 = RequestOptions.class.getMethod(VastAttribute.ERROR, cls);
        method.invoke(objNewInstance, Integer.valueOf(i10), Integer.valueOf(i11));
        method2.invoke(objNewInstance, enumC1551g);
        method3.invoke(objNewInstance, Integer.valueOf(i12));
        RequestOptions.class.getMethod("fitCenter", new Class[0]).invoke(objNewInstance, new Object[0]);
        c1554j.getClass().getMethod("apply", BaseRequestOptions.class).invoke(c1554j, objNewInstance);
    }
}
