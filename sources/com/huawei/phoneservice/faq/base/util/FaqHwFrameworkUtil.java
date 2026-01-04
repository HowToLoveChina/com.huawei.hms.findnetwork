package com.huawei.phoneservice.faq.base.util;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.WindowInsets;
import androidx.annotation.Keep;

/* loaded from: classes4.dex */
public class FaqHwFrameworkUtil {

    @Keep
    public static final int LAYOUT_IN_DISPLAY_SIDE_MODE_ALWAYS = 1;

    /* renamed from: com.huawei.phoneservice.faq.base.util.FaqHwFrameworkUtil$a */
    public class ViewOnApplyWindowInsetsListenerC8309a implements View.OnApplyWindowInsetsListener {

        /* renamed from: a */
        public final /* synthetic */ Activity f38696a;

        /* renamed from: b */
        public final /* synthetic */ InterfaceC8310b f38697b;

        public ViewOnApplyWindowInsetsListenerC8309a(Activity activity, InterfaceC8310b interfaceC8310b) {
            this.f38696a = activity;
            this.f38697b = interfaceC8310b;
        }

        @Override // android.view.View.OnApplyWindowInsetsListener
        public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) throws Throwable {
            try {
                Class<?> cls = Class.forName("com.huawei.android.view.WindowManagerEx$LayoutParamsEx");
                Class<?> cls2 = Class.forName("com.huawei.android.view.DisplaySideRegionEx");
                Object objM51857a = FaqRefectUtils.m51857a(cls, this.f38696a.getWindow().getAttributes());
                if (objM51857a != null) {
                    Object objInvoke = cls.getMethod("getDisplaySideRegion", WindowInsets.class).invoke(objM51857a, windowInsets);
                    if (objInvoke == null) {
                        this.f38697b.mo51826a(1);
                    } else {
                        Rect rect = (Rect) cls2.getMethod("getSafeInsets", new Class[0]).invoke(objInvoke, new Object[0]);
                        if (rect.left > 0 && rect.right > 0) {
                            this.f38697b.mo51826a(3);
                        } else if (rect.top > 0) {
                            this.f38697b.mo51826a(2);
                        }
                    }
                }
            } catch (Throwable unused) {
                this.f38697b.mo51826a(1);
                FaqLogger.m51840e("setForRing", "Exception");
            }
            return view.onApplyWindowInsets(windowInsets);
        }
    }

    /* renamed from: com.huawei.phoneservice.faq.base.util.FaqHwFrameworkUtil$b */
    public interface InterfaceC8310b {
        /* renamed from: a */
        void mo51826a(int i10);
    }

    @Keep
    public static void initScreenType(Activity activity, InterfaceC8310b interfaceC8310b) {
        activity.getWindow().getDecorView().setOnApplyWindowInsetsListener(new ViewOnApplyWindowInsetsListenerC8309a(activity, interfaceC8310b));
    }

    @Keep
    public static void setDisplaySideMode(Activity activity, int i10) throws Throwable {
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            FaqRefectUtils.m51859c("com.huawei.android.view.WindowManagerEx$LayoutParamsEx", "setDisplaySideMode", activity.getWindow().getAttributes(), new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(i10)});
            FaqLogger.m51837d("FaqHwFrameworkUtil", "setDisplaySideMode,time:%s", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
        } catch (Throwable th2) {
            FaqLogger.m51849k("FaqHwFrameworkUtil", th2, "setDisplaySideMode error", new Object[0]);
        }
    }
}
