package com.huawei.uikit.hwcolumnsystem.widget;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

/* loaded from: classes7.dex */
public class HwColumnSplitManager {

    /* renamed from: b */
    private static final String f41783b = "HwColumnSplitManager";

    /* renamed from: c */
    private static final String f41784c = "com.huawei.android.app.IHwActivitySplitterImplEx";

    /* renamed from: d */
    private static final String f41785d = "android.app.IHwActivitySplitterImpl$SplitChangeListener";

    /* renamed from: e */
    private static final String f41786e = "isSplitMode";

    /* renamed from: f */
    private static final String f41787f = "addSplitChangeListener";

    /* renamed from: g */
    private static HwColumnSplitManager f41788g = new HwColumnSplitManager();

    /* renamed from: a */
    private SplitModeConfigListener f41789a;

    public interface SplitModeConfigListener {
        boolean isSplitMode(Context context);
    }

    private HwColumnSplitManager() {
    }

    public static HwColumnSplitManager getInstance() {
        return f41788g;
    }

    public void addSplitChangeListener(Context context) throws IllegalAccessException, InstantiationException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        Activity wrapperActivity = getWrapperActivity(context);
        if (wrapperActivity == null) {
            return;
        }
        try {
            Class<?> cls = Class.forName(f41784c);
            Object objNewInstance = cls.getDeclaredConstructor(Activity.class, Boolean.TYPE).newInstance(wrapperActivity, Boolean.TRUE);
            Class<?> cls2 = Class.forName(f41785d);
            cls.getMethod(f41787f, cls2).invoke(objNewInstance, Proxy.newProxyInstance(HwColumnSplitManager.class.getClassLoader(), new Class[]{cls2}, new HwColumnSplitHandler()));
        } catch (ClassNotFoundException unused) {
            Log.w(f41783b, "addSplitChangeListener: class not found");
        } catch (IllegalAccessException unused2) {
            Log.w(f41783b, "addSplitChangeListener: illegal access exception");
        } catch (InstantiationException unused3) {
            Log.w(f41783b, "addSplitChangeListener: instantiation exception");
        } catch (NoSuchMethodException unused4) {
            Log.w(f41783b, "addSplitChangeListener: method not found");
        } catch (InvocationTargetException unused5) {
            Log.w(f41783b, "addSplitChangeListener: invocation target exception");
        }
    }

    public Activity getWrapperActivity(Context context) {
        if (context == null) {
            return null;
        }
        Activity activity = null;
        while (activity == null && context != null) {
            if (context instanceof Activity) {
                activity = (Activity) context;
            } else {
                context = context instanceof ContextWrapper ? ((ContextWrapper) context).getBaseContext() : null;
            }
        }
        return activity;
    }

    public boolean isActivityAttributeValid(Activity activity) {
        return (activity == null || activity.getWindow() == null || activity.getWindow().getAttributes() == null) ? false : true;
    }

    public boolean isActivityDecorViewValid(Activity activity) {
        return (activity == null || activity.getWindow() == null || activity.getWindow().getDecorView() == null) ? false : true;
    }

    public boolean isSplitMode(Context context) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        Object objInvoke;
        SplitModeConfigListener splitModeConfigListener = this.f41789a;
        if (splitModeConfigListener != null) {
            boolean zIsSplitMode = splitModeConfigListener.isSplitMode(context);
            Log.d(f41783b, "isConfigSplitMode: " + zIsSplitMode);
            return zIsSplitMode;
        }
        Activity wrapperActivity = getWrapperActivity(context);
        if (wrapperActivity == null) {
            return false;
        }
        try {
            Class<?> cls = Class.forName(f41784c);
            objInvoke = cls.getMethod(f41786e, new Class[0]).invoke(cls.getDeclaredConstructor(Activity.class, Boolean.TYPE).newInstance(wrapperActivity, Boolean.TRUE), new Object[0]);
        } catch (ClassNotFoundException unused) {
            Log.w(f41783b, "isSplitMode: class not found");
        } catch (IllegalAccessException unused2) {
            Log.w(f41783b, "isSplitMode: illegal access exception");
        } catch (InstantiationException unused3) {
            Log.w(f41783b, "isSplitMode: instantiation exception");
        } catch (NoSuchMethodException unused4) {
            Log.w(f41783b, "isSplitMode: method not found");
        } catch (InvocationTargetException unused5) {
            Log.w(f41783b, "isSplitMode: invocation target exception");
        }
        if (!(objInvoke instanceof Boolean)) {
            Log.w(f41783b, "isSplitMode: object is not Boolean");
            return false;
        }
        boolean zBooleanValue = ((Boolean) objInvoke).booleanValue();
        Log.d(f41783b, "isReflectSplitMode: " + zBooleanValue);
        return zBooleanValue;
    }

    public void setSplitModeConfigListener(SplitModeConfigListener splitModeConfigListener) {
        this.f41789a = splitModeConfigListener;
    }
}
