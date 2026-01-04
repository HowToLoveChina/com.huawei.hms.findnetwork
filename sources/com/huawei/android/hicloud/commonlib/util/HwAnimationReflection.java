package com.huawei.android.hicloud.commonlib.util;

import android.content.Context;
import dalvik.system.PathClassLoader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import p514o9.C11839m;

/* loaded from: classes3.dex */
public class HwAnimationReflection {

    /* renamed from: a */
    public Object f12050a = null;

    /* renamed from: b */
    public Method f12051b = null;

    public HwAnimationReflection(Context context) throws NoSuchMethodException, ClassNotFoundException, SecurityException {
        m15926b(context);
    }

    /* renamed from: a */
    public final void m15925a(Context context, Constructor<?> constructor) {
        try {
            this.f12050a = constructor.newInstance(context);
        } catch (IllegalAccessException unused) {
            C11839m.m70687e("HwAnimationReflection", "initAnimUtilObjectAndMethods : cann't construct object of AnimUtil");
        } catch (IllegalArgumentException unused2) {
            C11839m.m70687e("HwAnimationReflection", "initAnimUtilObjectAndMethods : cann't construct object of AnimUtil");
        } catch (InstantiationException unused3) {
            C11839m.m70687e("HwAnimationReflection", "initAnimUtilObjectAndMethods : cann't get constructor method of AnimUtil");
        } catch (InvocationTargetException unused4) {
            C11839m.m70687e("HwAnimationReflection", "initAnimUtilObjectAndMethods : cann't construct object of AnimUtil");
        }
    }

    /* renamed from: b */
    public final void m15926b(Context context) throws NoSuchMethodException, ClassNotFoundException, SecurityException {
        Class<?> clsLoadClass;
        Constructor<?> constructor = null;
        try {
            clsLoadClass = new PathClassLoader("/system/framework/", context.getClassLoader()).loadClass("com.huawei.hwanimation.AnimUtil");
        } catch (ClassNotFoundException e10) {
            C11839m.m70687e("HwAnimationReflection", "initAnimUtilObjectAndMethods : " + e10.toString());
            clsLoadClass = null;
        }
        if (clsLoadClass == null) {
            C11839m.m70687e("HwAnimationReflection", "initAnimUtilObjectAndMethods : cann't construct of AniUtil class object");
            return;
        }
        try {
            this.f12051b = clsLoadClass.getDeclaredMethod("overrideTransition", Integer.TYPE);
        } catch (NoSuchMethodException e11) {
            C11839m.m70687e("HwAnimationReflection", "initAnimUtilObjectAndMethods : " + e11.toString());
        }
        if (this.f12051b == null) {
            C11839m.m70687e("HwAnimationReflection", "initAnimUtilObjectAndMethods : cann't get the method of overrideTransiton defined in AnimUtil");
            return;
        }
        try {
            constructor = clsLoadClass.getConstructor(Context.class);
        } catch (NoSuchMethodException e12) {
            C11839m.m70687e("HwAnimationReflection", "initAnimUtilObjectAndMethods : " + e12.toString());
        }
        if (constructor == null) {
            C11839m.m70687e("HwAnimationReflection", "initAnimUtilObjectAndMethods : cann't get constructor method of AnimUtil");
            return;
        }
        m15925a(context, constructor);
        if (this.f12050a == null) {
            C11839m.m70687e("HwAnimationReflection", "initAnimUtilObjectAndMethods : cann't construct object of AnimUtil");
        }
    }

    /* renamed from: c */
    public void m15927c(int i10) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Object obj;
        Method method = this.f12051b;
        if (method == null || (obj = this.f12050a) == null) {
            return;
        }
        try {
            method.invoke(obj, Integer.valueOf(i10));
        } catch (IllegalAccessException e10) {
            C11839m.m70687e("HwAnimationReflection", "overrideTransition " + e10.toString());
        } catch (IllegalArgumentException e11) {
            C11839m.m70687e("HwAnimationReflection", "overrideTransition " + e11.toString());
        } catch (InvocationTargetException e12) {
            C11839m.m70687e("HwAnimationReflection", "overrideTransition " + e12.toString());
        }
    }
}
