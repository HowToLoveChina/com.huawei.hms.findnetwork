package com.huawei.hms.hwid;

import android.R;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.WindowManager;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.support.api.client.Status;
import java.lang.reflect.InvocationTargetException;
import java.util.Calendar;

/* renamed from: com.huawei.hms.hwid.ao */
/* loaded from: classes8.dex */
public class C5598ao {
    /* renamed from: a */
    public static void m32896a(Activity activity) {
        if (C5600aq.m32902a()) {
            m32898b(activity);
        }
    }

    /* renamed from: b */
    public static void m32898b(Activity activity) {
        C5602as.m32910b("AccountSdkUtil", "enter initOnApplyWindowInsets", true);
        final ViewGroup viewGroup = (ViewGroup) activity.getWindow().findViewById(R.id.content);
        if (viewGroup == null) {
            C5602as.m32910b("AccountSdkUtil", "rootView is null", true);
        } else {
            m32899c(activity);
            activity.getWindow().getDecorView().setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: com.huawei.hms.hwid.ao.1
                @Override // android.view.View.OnApplyWindowInsetsListener
                public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                    try {
                        Object objInvoke = Class.forName("com.huawei.android.view.WindowManagerEx$LayoutParamsEx").getMethod("getDisplaySideRegion", WindowInsets.class).invoke(null, windowInsets);
                        if (objInvoke == null) {
                            C5602as.m32910b("AccountSdkUtil", "sideRegion is null", true);
                        } else {
                            Rect rect = (Rect) Class.forName("com.huawei.android.view.DisplaySideRegionEx").getMethod("getSafeInsets", new Class[0]).invoke(objInvoke, new Object[0]);
                            C5602as.m32910b("AccountSdkUtil", "safeInsets LR: " + rect.left + ":" + rect.right, true);
                            C5602as.m32910b("AccountSdkUtil", "safeInsets TB: " + rect.top + ":" + rect.bottom, true);
                            ViewGroup viewGroup2 = viewGroup;
                            if (viewGroup2 != null) {
                                viewGroup2.setPadding(rect.left, 0, rect.right, 0);
                            }
                        }
                    } catch (ClassNotFoundException unused) {
                        C5602as.m32912d("AccountSdkUtil", "ClassNotFoundException onApplyWindowInsets", true);
                    } catch (IllegalAccessException unused2) {
                        C5602as.m32912d("AccountSdkUtil", "IllegalAccessException onApplyWindowInsets", true);
                    } catch (NoSuchMethodException unused3) {
                        C5602as.m32912d("AccountSdkUtil", "NoSuchMethodException onApplyWindowInsets", true);
                    } catch (InvocationTargetException unused4) {
                        C5602as.m32912d("AccountSdkUtil", "InvocationTargetException onApplyWindowInsets", true);
                    } catch (Throwable th2) {
                        C5602as.m32912d("AccountSdkUtil", "onApplyWindowInsets--" + th2.getClass().getSimpleName(), true);
                    }
                    return view.onApplyWindowInsets(windowInsets);
                }
            });
        }
    }

    /* renamed from: c */
    public static void m32899c(Activity activity) {
        WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
        try {
            Class<?> cls = Class.forName("com.huawei.android.view.WindowManagerEx$LayoutParamsEx");
            cls.getMethod("setDisplaySideMode", Integer.TYPE).invoke(cls.getDeclaredConstructor(WindowManager.LayoutParams.class).newInstance(attributes), 1);
        } catch (ClassNotFoundException unused) {
            C5602as.m32912d("AccountSdkUtil", "ClassNotFoundException setDisplaySideMode", true);
        } catch (IllegalAccessException unused2) {
            C5602as.m32912d("AccountSdkUtil", "IllegalAccessException setDisplaySideMode", true);
        } catch (InstantiationException unused3) {
            C5602as.m32912d("AccountSdkUtil", "InstantiationException setDisplaySideMode", true);
        } catch (NoSuchMethodException unused4) {
            C5602as.m32912d("AccountSdkUtil", "NoSuchMethodException setDisplaySideMode", true);
        } catch (InvocationTargetException unused5) {
            C5602as.m32912d("AccountSdkUtil", "InvocationTargetException setDisplaySideMode", true);
        } catch (Throwable th2) {
            C5602as.m32912d("AccountSdkUtil", "setDisplaySideMode--" + th2.getClass().getSimpleName(), true);
        }
    }

    /* renamed from: a */
    public static long m32895a() {
        return Calendar.getInstance().getTimeInMillis();
    }

    /* renamed from: a */
    public static void m32897a(ResponseErrorCode responseErrorCode, Status status) {
        if (responseErrorCode == null || status == null) {
            C5602as.m32910b("AccountSdkUtil", "response or status is null", true);
            return;
        }
        if (responseErrorCode.getParcelable() == null) {
            C5602as.m32910b("AccountSdkUtil", "parcelable is null", true);
            return;
        }
        try {
            if (responseErrorCode.getParcelable() instanceof PendingIntent) {
                C5602as.m32910b("AccountSdkUtil", "doExecute is PendingIntent", true);
                status.setPendingIntent((PendingIntent) responseErrorCode.getParcelable());
            }
            if (responseErrorCode.getParcelable() instanceof Intent) {
                C5602as.m32910b("AccountSdkUtil", "doExecute is Intent", true);
                status.setIntent((Intent) responseErrorCode.getParcelable());
            }
        } catch (ClassCastException unused) {
            C5602as.m32912d("AccountSdkUtil", "doExecuteIntent ClassCastException", true);
        } catch (Throwable th2) {
            C5602as.m32912d("AccountSdkUtil", "doExecuteIntent--" + th2.getClass().getSimpleName(), true);
        }
    }
}
