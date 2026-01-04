package com.huawei.hms.findnetwork.util;

import android.content.Context;
import java.lang.ref.WeakReference;

/* loaded from: classes8.dex */
public class ApplicationContext {
    private static final String TAG = "ApplicationContext";
    private static WeakReference<Context> sHmsContextWeakRef;
    private static WeakReference<Context> sKitContextWeakRef;

    public static Context getContext() {
        WeakReference<Context> weakReference = sKitContextWeakRef;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public static Context getHmsContext() {
        WeakReference<Context> weakReference = sHmsContextWeakRef;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public static void init(Context context, Context context2) {
        setKitContext(context);
        setHmsContext(context2);
    }

    private static void setHmsContext(Context context) {
        sHmsContextWeakRef = new WeakReference<>(context);
        HmsFindSDKLog.m32125d(TAG, "set hms context success.");
    }

    private static void setKitContext(Context context) {
        sKitContextWeakRef = new WeakReference<>(context);
        HmsFindSDKLog.m32125d(TAG, "set kit context success.");
    }
}
