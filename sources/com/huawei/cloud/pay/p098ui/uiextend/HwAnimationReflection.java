package com.huawei.cloud.pay.p098ui.uiextend;

import android.content.Context;
import dalvik.system.PathClassLoader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import p054cj.C1442a;

/* loaded from: classes5.dex */
public class HwAnimationReflection {

    /* renamed from: a */
    public Method f21470a = null;

    /* renamed from: b */
    public Object f21471b = null;

    public HwAnimationReflection(Context context) throws NoSuchMethodException, ClassNotFoundException, SecurityException {
        m28597a(context);
    }

    /* renamed from: a */
    public final void m28597a(Context context) throws NoSuchMethodException, ClassNotFoundException, SecurityException {
        Class<?> clsLoadClass;
        Constructor<?> constructor = null;
        try {
            clsLoadClass = new PathClassLoader("/system/framework/", context.getClassLoader()).loadClass("com.huawei.hwanimation.AnimUtil");
        } catch (ClassNotFoundException e10) {
            C1442a.m8289e("HwAnimationReflection", "initAnimUtilObjectAndMethods : " + e10.toString());
            clsLoadClass = null;
        }
        if (clsLoadClass == null) {
            C1442a.m8289e("HwAnimationReflection", "initAnimUtilObjectAndMethods : cann't construct of AniUtil class object");
            return;
        }
        try {
            this.f21470a = clsLoadClass.getDeclaredMethod("overrideTransition", Integer.TYPE);
        } catch (NoSuchMethodException e11) {
            C1442a.m8289e("HwAnimationReflection", "initAnimUtilObjectAndMethods : " + e11.toString());
        }
        if (this.f21470a == null) {
            C1442a.m8289e("HwAnimationReflection", "initAnimUtilObjectAndMethods : cann't get the method of overrideTransiton defined in AnimUtil");
            return;
        }
        try {
            constructor = clsLoadClass.getConstructor(Context.class);
        } catch (NoSuchMethodException e12) {
            C1442a.m8289e("HwAnimationReflection", "initAnimUtilObjectAndMethods : " + e12.toString());
        }
        if (constructor == null) {
            C1442a.m8289e("HwAnimationReflection", "initAnimUtilObjectAndMethods : cann't get constructor method of AnimUtil");
            return;
        }
        try {
            this.f21471b = constructor.newInstance(context);
        } catch (IllegalArgumentException unused) {
            C1442a.m8289e("HwAnimationReflection", "initAnimUtilObjectAndMethods : cann't construct object of AnimUtil");
        } catch (ReflectiveOperationException unused2) {
            C1442a.m8289e("HwAnimationReflection", "initAnimUtilObjectAndMethods : cann't get constructor method of AnimUtil");
        }
        if (this.f21471b == null) {
            C1442a.m8289e("HwAnimationReflection", "initAnimUtilObjectAndMethods : cann't construct object of AnimUtil");
        }
    }

    /* renamed from: b */
    public void m28598b(int i10) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Object obj;
        Method method = this.f21470a;
        if (method == null || (obj = this.f21471b) == null) {
            return;
        }
        try {
            method.invoke(obj, Integer.valueOf(i10));
        } catch (IllegalArgumentException e10) {
            C1442a.m8289e("HwAnimationReflection", "IllegalArgumentException " + e10.toString());
        } catch (ReflectiveOperationException e11) {
            C1442a.m8289e("HwAnimationReflection", "ReflectiveOperationException " + e11.toString());
        }
    }
}
