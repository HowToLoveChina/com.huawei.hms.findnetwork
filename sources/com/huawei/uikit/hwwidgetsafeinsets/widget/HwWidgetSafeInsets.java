package com.huawei.uikit.hwwidgetsafeinsets.widget;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.provider.Settings;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowManager;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.uikit.hwwidgetsafeinsets.C8750R;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes9.dex */
public class HwWidgetSafeInsets {

    /* renamed from: A */
    private static final int f44882A = 2;

    /* renamed from: B */
    private static final Method f44883B;

    /* renamed from: C */
    private static final Method f44884C;

    /* renamed from: D */
    private static final Method f44885D;

    /* renamed from: n */
    private static final String f44886n = "HwWidgetSafeInsets";

    /* renamed from: o */
    private static final String f44887o = "navigationbar_is_min";

    /* renamed from: p */
    private static final String f44888p = "huawei.android.widget.RadiusSizeUtils";

    /* renamed from: q */
    private static final String f44889q = "com.huawei.android.view.WindowManagerEx$LayoutParamsEx";

    /* renamed from: r */
    private static final String f44890r = "com.huawei.android.app.WindowManagerEx";

    /* renamed from: s */
    private static final int f44891s = 102;

    /* renamed from: t */
    private static final int f44892t = 1;

    /* renamed from: u */
    private static final int f44893u = 2;

    /* renamed from: v */
    private static final int f44894v = 2;

    /* renamed from: w */
    private static final int f44895w = 0;

    /* renamed from: x */
    private static final int f44896x = 1;

    /* renamed from: y */
    private static final int f44897y = 2;

    /* renamed from: z */
    private static final int f44898z = 0;

    /* renamed from: b */
    private final View f44900b;

    /* renamed from: l */
    private Context f44910l;

    /* renamed from: a */
    private int f44899a = 0;

    /* renamed from: c */
    private final Rect f44901c = new Rect();

    /* renamed from: d */
    private final Rect f44902d = new Rect();

    /* renamed from: e */
    private int f44903e = 0;

    /* renamed from: f */
    private boolean f44904f = false;

    /* renamed from: g */
    private boolean f44905g = false;

    /* renamed from: h */
    private boolean f44906h = false;

    /* renamed from: i */
    private boolean f44907i = false;

    /* renamed from: j */
    private boolean f44908j = false;

    /* renamed from: k */
    private boolean f44909k = true;

    /* renamed from: m */
    private final Runnable f44911m = new bzrwd();

    public class bzrwd implements Runnable {
        public bzrwd() {
        }

        @Override // java.lang.Runnable
        public void run() {
            HwWidgetSafeInsets.this.f44900b.requestLayout();
        }
    }

    static {
        try {
            try {
                f44883B = Class.forName(f44888p).getDeclaredMethod("getRadiusSize", Context.class);
            } catch (ClassNotFoundException unused) {
                Log.w(f44886n, "getRadiusSize ClassNotFoundException");
                try {
                    f44884C = Class.forName(f44889q).getDeclaredMethod("getDisplaySafeInsets", WindowInsets.class);
                } catch (ClassNotFoundException unused2) {
                    Log.w(f44886n, "getDisplaySafeInsets ClassNotFoundException");
                    f44885D = Class.forName(f44890r).getDeclaredMethod("getDisplaySideSafeInsets", new Class[0]);
                } catch (NoSuchMethodException unused3) {
                    Log.w(f44886n, "getDisplaySafeInsets NoSuchMethodException");
                    f44885D = Class.forName(f44890r).getDeclaredMethod("getDisplaySideSafeInsets", new Class[0]);
                }
                try {
                    f44885D = Class.forName(f44890r).getDeclaredMethod("getDisplaySideSafeInsets", new Class[0]);
                } catch (ClassNotFoundException unused4) {
                    Log.w(f44886n, "getDisplaySideSafeInsets ClassNotFoundException");
                    return;
                } catch (NoSuchMethodException unused5) {
                    Log.w(f44886n, "getDisplaySideSafeInsets NoSuchMethodException");
                    return;
                }
            } catch (NoSuchMethodException unused6) {
                Log.w(f44886n, "getRadiusSize NoSuchMethodException");
                f44884C = Class.forName(f44889q).getDeclaredMethod("getDisplaySafeInsets", WindowInsets.class);
                f44885D = Class.forName(f44890r).getDeclaredMethod("getDisplaySideSafeInsets", new Class[0]);
            }
            try {
                f44884C = Class.forName(f44889q).getDeclaredMethod("getDisplaySafeInsets", WindowInsets.class);
                try {
                    f44885D = Class.forName(f44890r).getDeclaredMethod("getDisplaySideSafeInsets", new Class[0]);
                } finally {
                    f44885D = null;
                }
            } finally {
                f44884C = null;
            }
        } finally {
            f44883B = null;
        }
    }

    public HwWidgetSafeInsets(View view) {
        this.f44910l = null;
        this.f44900b = view;
        this.f44910l = view.getContext();
    }

    /* renamed from: b */
    private boolean m55965b() {
        Activity activityM55968c = m55968c(this.f44910l);
        if (activityM55968c == null) {
            return false;
        }
        try {
            return ((Integer) Class.forName("com.huawei.android.app.ActivityManagerEx").getMethod("getActivityWindowMode", Activity.class).invoke(null, activityM55968c)).intValue() == 102;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException unused) {
            Log.e(f44886n, "Exception occurred in isInMultiWindowMode.");
            return false;
        }
    }

    /* renamed from: c */
    private Activity m55968c(Context context) {
        if (context == null) {
            return null;
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return m55968c(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    public void applyDisplaySafeInsets(View view, Rect rect, boolean z10) {
        if (view == null || rect == null || isCutoutModeNever()) {
            return;
        }
        int i10 = this.f44903e;
        if ((i10 & 2) == 0) {
            return;
        }
        this.f44903e = i10 | 1;
        view.setPadding(rect.left, rect.top, rect.right, rect.bottom);
        this.f44903e &= -2;
        if (z10) {
            postRequestLayout();
            this.f44903e &= -3;
        }
    }

    public Rect getDisplaySafeInsets(View view) {
        return getDisplaySafeInsets(view, this.f44902d);
    }

    public Rect getSafeInsets() {
        return this.f44901c;
    }

    public boolean isCutoutModeNever() {
        return this.f44899a == 2;
    }

    public boolean isShouldApply() {
        return (this.f44903e & 2) != 0;
    }

    public void parseHwDisplayCutout(Context context, AttributeSet attributeSet) {
        if (context == null || attributeSet == null) {
            Log.w(f44886n, "parse cutout mode error");
            return;
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C8750R.styleable.HwDisplayCutout);
        this.f44899a = typedArrayObtainStyledAttributes.getInt(C8750R.styleable.HwDisplayCutout_hwCutoutMode, 0);
        typedArrayObtainStyledAttributes.recycle();
    }

    public void postRequestLayout() {
        View view = this.f44900b;
        if (view != null) {
            view.removeCallbacks(this.f44911m);
            this.f44900b.post(this.f44911m);
        }
    }

    public void setDealRaduis(boolean z10) {
        this.f44906h = z10;
    }

    public void setDealTop(boolean z10) {
        this.f44905g = z10;
    }

    public void setIsNeedSafeInsets(boolean z10) {
        this.f44909k = z10;
    }

    public void updateOriginPadding(int i10, int i11, int i12, int i13) {
        updateOriginPadding(new Rect(i10, i11, i12, i13));
    }

    public void updateWindowInsets(WindowInsets windowInsets) {
        if (m55965b()) {
            return;
        }
        Rect rectM55964b = f44884C != null ? m55964b(windowInsets) : m55960a(windowInsets);
        if (rectM55964b == null) {
            rectM55964b = new Rect();
        }
        boolean zM55969c = m55969c(this.f44900b);
        this.f44900b.getLocationInWindow(new int[2]);
        if (this.f44909k) {
            if (this.f44901c.equals(rectM55964b) && this.f44904f == zM55969c) {
                return;
            }
            this.f44901c.set(rectM55964b);
            this.f44903e |= 2;
            this.f44904f = zM55969c;
            postRequestLayout();
        }
    }

    /* renamed from: a */
    private void m55962a(Rect rect, Rect rect2, Rect rect3, Rect rect4) {
        if (this.f44899a == 1) {
            Rect rect5 = this.f44901c;
            int i10 = rect5.left;
            if (i10 > 0) {
                rect2.left = rect.left + i10;
            }
            int i11 = rect5.right;
            if (i11 > 0) {
                rect2.right = rect.right + i11;
                return;
            }
            return;
        }
        Rect rect6 = this.f44901c;
        int i12 = rect6.left;
        if (i12 > 0 && rect3.left < i12) {
            rect2.left = rect.left + i12;
        }
        int i13 = rect6.right;
        if (i13 <= 0 || rect4.right - i13 >= rect3.right) {
            return;
        }
        rect2.right = rect.right + i13;
    }

    public Rect getDisplaySafeInsets(View view, Rect rect) {
        int iM55959a;
        int i10;
        int i11;
        Rect rect2 = new Rect();
        if (view != null && rect != null) {
            rect2.set(rect);
            boolean z10 = (this.f44906h || this.f44905g || m55963a()) ? false : true;
            if (!isCutoutModeNever() && !z10) {
                Rect rect3 = new Rect();
                Rect rect4 = new Rect();
                int[] iArr = new int[2];
                view.getLocationInWindow(iArr);
                int i12 = iArr[0];
                rect3.set(i12, iArr[1], view.getWidth() + i12, iArr[1] + view.getHeight());
                View rootView = view.getRootView();
                if (rootView != null) {
                    rootView.getLocationInWindow(iArr);
                    int i13 = iArr[0];
                    rect4.set(i13, iArr[1], rootView.getWidth() + i13, iArr[1] + rootView.getHeight());
                    m55962a(rect, rect2, rect3, rect4);
                    boolean zM55966b = m55966b(view.getContext());
                    if (this.f44905g) {
                        if (zM55966b && (i10 = this.f44901c.top) > 0 && (i11 = rect3.top) < i10) {
                            int paddingTop = i11 + view.getPaddingTop();
                            int paddingTop2 = this.f44901c.top;
                            if (paddingTop >= paddingTop2) {
                                paddingTop2 = view.getPaddingTop();
                            }
                            rect2.top = paddingTop2;
                        } else if (this.f44907i) {
                            rect2.top = view.getPaddingTop();
                        }
                    }
                    if (this.f44906h && zM55966b && (iM55959a = m55959a(view)) > 0) {
                        rect2.bottom = rect.bottom + iM55959a;
                    }
                }
            }
        }
        return rect2;
    }

    public void updateOriginPadding(Rect rect) {
        if (m55967b(this.f44900b) && (this.f44903e & 1) == 0) {
            if (this.f44908j) {
                this.f44907i = true;
                return;
            }
            this.f44902d.set(rect);
            this.f44908j = true;
            this.f44903e |= 2;
        }
    }

    /* renamed from: c */
    private boolean m55969c(View view) {
        return view != null && Settings.Global.getInt(view.getContext().getContentResolver(), "navigationbar_is_min", 0) == 0;
    }

    /* renamed from: b */
    private boolean m55966b(Context context) {
        WindowManager windowManager;
        int rotation = (context == null || (windowManager = (WindowManager) context.getSystemService(Constants.NATIVE_WINDOW_SUB_DIR)) == null) ? 0 : windowManager.getDefaultDisplay().getRotation();
        return rotation == 0 || rotation == 2;
    }

    /* renamed from: b */
    private static Rect m55964b(WindowInsets windowInsets) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        int i10;
        Rect rect = new Rect();
        if (windowInsets != null) {
            try {
                Method method = f44884C;
                if (method != null) {
                    Object objInvoke = method.invoke(null, windowInsets);
                    if (objInvoke instanceof Rect) {
                        rect = (Rect) objInvoke;
                    }
                }
                Method method2 = f44885D;
                if (method2 != null) {
                    Object objInvoke2 = method2.invoke(null, new Object[0]);
                    if (!(objInvoke2 instanceof Rect)) {
                        return rect;
                    }
                    Rect rect2 = (Rect) objInvoke2;
                    int i11 = rect2.left;
                    if (i11 != 0 && (i10 = rect2.right) != 0) {
                        rect.left = i11;
                        rect.right = i10;
                    }
                }
            } catch (IllegalAccessException unused) {
                Log.e(f44886n, "getWindowDisplaySafeInsets IllegalAccessException");
            } catch (InvocationTargetException unused2) {
                Log.e(f44886n, "getWindowDisplaySafeInsets InvocationTargetException");
            }
        }
        return rect;
    }

    public void applyDisplaySafeInsets(boolean z10) {
        if ((this.f44903e & 2) == 0) {
            return;
        }
        View view = this.f44900b;
        applyDisplaySafeInsets(view, getDisplaySafeInsets(view), z10);
    }

    /* renamed from: a */
    private int m55959a(View view) {
        Context context;
        int iM55958a;
        if (view == null || (context = view.getContext()) == null || (iM55958a = m55958a(context)) <= 0) {
            return 0;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        WindowManager windowManager = (WindowManager) context.getSystemService(Constants.NATIVE_WINDOW_SUB_DIR);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
        return ((iArr[1] + view.getMeasuredHeight()) + iM55958a) - displayMetrics.heightPixels;
    }

    /* renamed from: a */
    private static Rect m55960a(WindowInsets windowInsets) {
        return new Rect();
    }

    /* renamed from: a */
    private static int m55958a(Context context) {
        try {
            Method method = f44883B;
            if (method != null) {
                return ((Integer) method.invoke(null, context)).intValue();
            }
        } catch (IllegalAccessException unused) {
            Log.w(f44886n, "getRadiusSize IllegalAccessException");
        } catch (InvocationTargetException unused2) {
            Log.w(f44886n, "getRadiusSize InvocationTargetException");
        }
        return 0;
    }

    /* renamed from: b */
    private boolean m55967b(View view) {
        if (view == null) {
            return false;
        }
        return view.isAttachedToWindow();
    }

    /* renamed from: a */
    private boolean m55963a() {
        Rect rect = this.f44901c;
        if (rect == null) {
            return false;
        }
        return rect.left > 0 || rect.right > 0;
    }
}
