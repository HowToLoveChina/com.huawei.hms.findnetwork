package p514o9;

import android.R;
import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.hardware.display.DisplayManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.hihonor.android.view.WindowManagerEx;
import com.huawei.android.fsm.HwFoldScreenManagerEx;
import com.huawei.android.hicloud.commonlib.view.SpanClickText;
import com.huawei.android.hicloud.p088ui.extend.NotchTopFitLinearLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchTopFitRelativeLayout;
import com.huawei.android.view.WindowManagerEx;
import com.huawei.feedback.log.BaseLogger;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.constants.RecommendCardConstants;
import com.huawei.hicloud.sync.R$color;
import com.huawei.hicloud.sync.R$dimen;
import com.huawei.hicloud.sync.R$drawable;
import com.huawei.hicloud.sync.R$string;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.ErrorCode;
import com.huawei.openalliance.p169ad.constant.OsType;
import com.huawei.openalliance.p169ad.inter.data.ImageInfo;
import com.huawei.uikit.hwcolumnsystem.widget.HwColumnSystem;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0219i;
import p015ak.C0224k0;
import p015ak.C0234s;
import p212d0.C8974f;
import p273f0.C9603h0;
import p399jk.AbstractC10896a;
import p459lp.C11330h;
import p472m7.C11426a;
import p472m7.C11430e;
import p709vj.C13452e;
import sk.C12806c;
import sk.C12808e;

/* renamed from: o9.p */
/* loaded from: classes3.dex */
public class C11842p {

    /* renamed from: A */
    public static int f54793A = -1;

    /* renamed from: B */
    public static int f54794B = -1;

    /* renamed from: C */
    public static int f54795C = -1;

    /* renamed from: D */
    public static int f54796D = -1;

    /* renamed from: E */
    public static int f54797E = -1;

    /* renamed from: F */
    public static int f54798F = -1;

    /* renamed from: G */
    public static int f54799G = -1;

    /* renamed from: H */
    public static int f54800H = -1;

    /* renamed from: a */
    public static int f54801a = -1;

    /* renamed from: b */
    public static int f54802b = -1;

    /* renamed from: c */
    public static int f54803c = -1;

    /* renamed from: d */
    public static int f54804d = -1;

    /* renamed from: e */
    public static int f54805e = -1;

    /* renamed from: f */
    public static int f54806f = -1;

    /* renamed from: g */
    public static int f54807g = -1;

    /* renamed from: h */
    public static int f54808h = -1;

    /* renamed from: i */
    public static int f54809i = -1;

    /* renamed from: j */
    public static int f54810j = -1;

    /* renamed from: k */
    public static int f54811k = -1;

    /* renamed from: l */
    public static int f54812l = -1;

    /* renamed from: m */
    public static int f54813m = -1;

    /* renamed from: n */
    public static int f54814n = -1;

    /* renamed from: o */
    public static int f54815o = -1;

    /* renamed from: p */
    public static int f54816p = -1;

    /* renamed from: q */
    public static int f54817q = -1;

    /* renamed from: r */
    public static int f54818r = -1;

    /* renamed from: s */
    public static int f54819s = -1;

    /* renamed from: t */
    public static int f54820t = -1;

    /* renamed from: u */
    public static int f54821u = -1;

    /* renamed from: v */
    public static int f54822v = -1;

    /* renamed from: w */
    public static int f54823w = -1;

    /* renamed from: x */
    public static int f54824x = -1;

    /* renamed from: y */
    public static int f54825y = -1;

    /* renamed from: z */
    public static int f54826z = -1;

    /* renamed from: o9.p$a */
    public class a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ View f54827a;

        /* renamed from: b */
        public final /* synthetic */ int f54828b;

        /* renamed from: c */
        public final /* synthetic */ Activity f54829c;

        /* renamed from: d */
        public final /* synthetic */ int f54830d;

        public a(View view, int i10, Activity activity, int i11) {
            this.f54827a = view;
            this.f54828b = i10;
            this.f54829c = activity;
            this.f54830d = i11;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f54827a.getMeasuredWidth() > this.f54828b) {
                ViewGroup.LayoutParams layoutParams = this.f54827a.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new ViewGroup.LayoutParams(-2, -2);
                }
                Resources resources = this.f54829c.getResources();
                if (resources != null) {
                    layoutParams.width = (this.f54830d - (resources.getDimensionPixelSize(R$dimen.margin_xl) * 2)) - (C12808e.m76823b() * 2);
                }
                this.f54827a.setLayoutParams(layoutParams);
            }
        }
    }

    /* renamed from: o9.p$b */
    public class b implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ View f54831a;

        /* renamed from: b */
        public final /* synthetic */ int f54832b;

        /* renamed from: c */
        public final /* synthetic */ Activity f54833c;

        /* renamed from: d */
        public final /* synthetic */ int f54834d;

        public b(View view, int i10, Activity activity, int i11) {
            this.f54831a = view;
            this.f54832b = i10;
            this.f54833c = activity;
            this.f54834d = i11;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f54831a.getMeasuredWidth() > this.f54832b) {
                ViewGroup.LayoutParams layoutParams = this.f54831a.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new ViewGroup.LayoutParams(-2, -2);
                }
                Resources resources = this.f54833c.getResources();
                if (resources != null) {
                    if (C11842p.m70753O0(this.f54833c)) {
                        layoutParams.width = (this.f54834d - (resources.getDimensionPixelSize(R$dimen.margin_xl) * 2)) - (C11842p.m70737J(this.f54833c) * 2);
                    } else {
                        layoutParams.width = (this.f54834d - (resources.getDimensionPixelSize(R$dimen.margin_xl) * 2)) - (C11842p.m70740K(this.f54833c) * 2);
                    }
                }
                this.f54831a.setLayoutParams(layoutParams);
            }
        }
    }

    /* renamed from: o9.p$c */
    public class c implements View.OnSystemUiVisibilityChangeListener {

        /* renamed from: a */
        public final /* synthetic */ Window f54835a;

        /* renamed from: b */
        public final /* synthetic */ Context f54836b;

        public c(Window window, Context context) {
            this.f54835a = window;
            this.f54836b = context;
        }

        @Override // android.view.View.OnSystemUiVisibilityChangeListener
        public void onSystemUiVisibilityChange(int i10) {
            C11829c.m70585i1(this.f54835a);
            C11829c.m70633y1(this.f54836b, this.f54835a);
        }
    }

    /* renamed from: o9.p$d */
    public class d implements View.OnSystemUiVisibilityChangeListener {

        /* renamed from: a */
        public final /* synthetic */ Window f54837a;

        public d(Window window) {
            this.f54837a = window;
        }

        @Override // android.view.View.OnSystemUiVisibilityChangeListener
        public void onSystemUiVisibilityChange(int i10) {
            C11829c.m70588j1(this.f54837a);
        }
    }

    /* renamed from: o9.p$e */
    public class e extends View.AccessibilityDelegate {
        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(Button.class.getName());
        }
    }

    /* renamed from: o9.p$f */
    public enum f {
        PERCENT_0(0),
        PERCENT_20(20),
        PERCENT_50(50),
        PERCENT_80(80),
        PERCENT_100(100);


        /* renamed from: a */
        public final int f54844a;

        f(int i10) {
            this.f54844a = i10;
        }

        /* renamed from: b */
        public boolean m70892b(View view) {
            return C11842p.m70777W0(view, this.f54844a);
        }
    }

    /* renamed from: A */
    public static int m70709A() {
        return f54808h;
    }

    /* renamed from: A0 */
    public static void m70710A0(Activity activity, boolean z10) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        View decorView;
        if (activity != null) {
            Window window = activity.getWindow();
            ActionBar actionBar = activity.getActionBar();
            if (window == null || actionBar == null || (decorView = window.getDecorView()) == null) {
                return;
            }
            if (C0224k0.a.m1574c("ro.config.hw_tint", false) || C0219i.m1463a() > 17) {
                C11839m.m70688i("UIUtil", "deepDarkTheme: " + z10);
                if (z10) {
                    decorView.setSystemUiVisibility(1280);
                } else {
                    decorView.setSystemUiVisibility(9472);
                }
            } else {
                decorView.setSystemUiVisibility(1280);
            }
            Resources resources = activity.getResources();
            if (resources != null) {
                window.setStatusBarColor(resources.getColor(R$color.mc_trans_white, null));
            }
            m70842n1(actionBar, new ColorDrawable(0));
            actionBar.setBackgroundDrawable(new ColorDrawable(0));
        }
    }

    /* renamed from: A1 */
    public static void m70711A1(Context context, View view) {
        if (view == null || context == null) {
            return;
        }
        if (m70747M0(context) || m70771U0() || m70753O0(context)) {
            int i10 = m70876w(context).widthPixels;
            m70875v2(view);
            view.setMinimumWidth(i10 / 2);
            return;
        }
        m70867t2(view);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.leftMargin = (int) m70844o(context, 14);
            marginLayoutParams.rightMargin = (int) m70844o(context, 14);
            view.setLayoutParams(marginLayoutParams);
        }
    }

    /* renamed from: A2 */
    public static void m70712A2(View view, boolean z10) {
        if (view == null) {
            return;
        }
        view.setVisibility(z10 ? 0 : 8);
    }

    /* renamed from: B */
    public static int m70713B(Context context) {
        return f54801a;
    }

    /* renamed from: B0 */
    public static void m70714B0(Activity activity) {
        Window window;
        View decorView;
        if (activity == null || (window = activity.getWindow()) == null || (decorView = window.getDecorView()) == null) {
            return;
        }
        decorView.setSystemUiVisibility(9472);
        Resources resources = activity.getResources();
        if (resources != null) {
            window.setStatusBarColor(resources.getColor(R$color.mc_trans_white, null));
        }
    }

    /* renamed from: B1 */
    public static void m70715B1(Context context, View view) {
        if (view == null || context == null || C0219i.m1463a() < 27 || !C0209d.m1269j1()) {
            return;
        }
        m70736I1(view, (int) m70844o(context, 40));
    }

    /* renamed from: C */
    public static int m70716C() {
        return f54802b;
    }

    /* renamed from: C0 */
    public static void m70717C0(Activity activity) {
        Window window;
        View decorView;
        if (activity == null || (window = activity.getWindow()) == null || (decorView = window.getDecorView()) == null) {
            return;
        }
        decorView.setSystemUiVisibility(1280);
        if (activity.getResources() != null) {
            window.setStatusBarColor(0);
        }
    }

    /* renamed from: C1 */
    public static void m70718C1(Context context, SpanClickText spanClickText, boolean z10, boolean z11, boolean z12) {
        SpanClickText spanClickText2;
        String str;
        String str2;
        String str3;
        String str4;
        if (context == null || spanClickText == null) {
            return;
        }
        String strTrim = C0234s.m1624b(context, R$string.privacy_internet).trim();
        String strTrim2 = C0234s.m1624b(context, R$string.hicloud_permission_storage).trim();
        String strTrim3 = C0234s.m1624b(context, R$string.hicloud_permission_phone).trim();
        String strTrim4 = C0234s.m1624b(context, R$string.hicloud_permission_location).trim();
        String strTrim5 = C0234s.m1624b(context, R$string.hicloud_permission_record).trim();
        String strTrim6 = C0234s.m1624b(context, R$string.hicloud_permission_contacts).trim();
        String strTrim7 = C0234s.m1624b(context, R$string.hicloud_permission_sms).trim();
        String strTrim8 = C0234s.m1624b(context, R$string.hicloud_permission_call_log).trim();
        String strTrim9 = C0234s.m1624b(context, R$string.hicloud_permission_application).trim();
        String strTrim10 = C0234s.m1624b(context, R$string.hicloud_permission_calendar).trim();
        String strTrim11 = C0234s.m1624b(context, R$string.hicloud_permission_camera).trim();
        int i10 = R$string.privacy_welcome_content_adults_20251020;
        String string = context.getString(i10, strTrim, strTrim2, strTrim3, strTrim7, strTrim6, strTrim4, strTrim11, strTrim5, strTrim8, strTrim9, strTrim10);
        if (!z10) {
            spanClickText2 = spanClickText;
            if (!z12) {
                if (z11) {
                    str3 = strTrim3;
                    str2 = strTrim2;
                    str = strTrim;
                    string = context.getString(i10, strTrim, strTrim2, strTrim3, strTrim7, strTrim6, strTrim4, strTrim11, strTrim5, strTrim8, strTrim9, strTrim10);
                    spanClickText2.m15930b(strTrim4);
                    spanClickText2.m15930b(strTrim5);
                } else {
                    str = strTrim;
                    str2 = strTrim2;
                    str3 = strTrim3;
                    spanClickText2.m15930b(strTrim4);
                    spanClickText2.m15930b(strTrim5);
                }
                str4 = str;
                spanClickText2.m15930b(str4);
                spanClickText2.m15930b(str2);
                spanClickText2.m15930b(str3);
                spanClickText2.m15930b(strTrim7);
                spanClickText2.m15930b(strTrim6);
                spanClickText2.m15930b(strTrim8);
                spanClickText2.m15930b(strTrim9);
                spanClickText2.m15930b(strTrim10);
                spanClickText2.m15930b(strTrim11);
                spanClickText2.m15934g(string, true);
                spanClickText2.setVisibility(0);
            }
            string = context.getString(R$string.privacy_welcome_honor_content_adults_20250306, strTrim, strTrim2, strTrim3, strTrim7, strTrim6, strTrim8, strTrim9, strTrim10);
        } else if (z12) {
            string = context.getString(R$string.privacy_welcome_honor_content_adults_20250306, strTrim, strTrim2, strTrim3, strTrim7, strTrim6, strTrim8, strTrim9, strTrim10);
            spanClickText2 = spanClickText;
        } else {
            string = context.getString(i10, strTrim, strTrim2, strTrim3, strTrim7, strTrim6, strTrim4, strTrim11, strTrim5, strTrim8, strTrim9, strTrim10);
            spanClickText2 = spanClickText;
            spanClickText2.m15930b(strTrim4);
            spanClickText2.m15930b(strTrim5);
        }
        str4 = strTrim;
        str2 = strTrim2;
        str3 = strTrim3;
        spanClickText2.m15930b(str4);
        spanClickText2.m15930b(str2);
        spanClickText2.m15930b(str3);
        spanClickText2.m15930b(strTrim7);
        spanClickText2.m15930b(strTrim6);
        spanClickText2.m15930b(strTrim8);
        spanClickText2.m15930b(strTrim9);
        spanClickText2.m15930b(strTrim10);
        spanClickText2.m15930b(strTrim11);
        spanClickText2.m15934g(string, true);
        spanClickText2.setVisibility(0);
    }

    /* renamed from: D */
    public static int m70719D() {
        return f54804d;
    }

    /* renamed from: D0 */
    public static void m70720D0(Activity activity) {
        Window window;
        View decorView;
        if (activity == null || (window = activity.getWindow()) == null || (decorView = window.getDecorView()) == null) {
            return;
        }
        if (C0219i.m1463a() >= 21) {
            if (m70756P0(activity)) {
                decorView.setSystemUiVisibility(1280);
            } else {
                decorView.setSystemUiVisibility(9472);
            }
        } else if ((C0224k0.a.m1574c("ro.config.hw_tint", false) || C0219i.m1463a() > 17) && !C11829c.m70605p0()) {
            decorView.setSystemUiVisibility(9472);
        } else {
            decorView.setSystemUiVisibility(1280);
        }
        Resources resources = activity.getResources();
        if (resources != null) {
            window.setStatusBarColor(resources.getColor(R$color.mc_trans_white, null));
        }
    }

    /* renamed from: D1 */
    public static void m70721D1(TextView textView, float f10) {
        if (textView == null) {
            C11839m.m70687e("UIUtil", "textView is null");
            return;
        }
        Resources resources = textView.getResources();
        if (resources == null) {
            C11839m.m70687e("UIUtil", "resources is null");
            return;
        }
        float f11 = resources.getConfiguration().fontScale;
        C11839m.m70688i("UIUtil", "fontScale: " + f11);
        if (f11 <= f10) {
            C11839m.m70688i("UIUtil", "not need reset");
        } else {
            textView.setTextSize(0, (textView.getTextSize() * f10) / f11);
        }
    }

    /* renamed from: E */
    public static int m70722E() {
        return f54805e;
    }

    /* renamed from: E0 */
    public static void m70723E0(Context context) {
        if (context == null) {
            return;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService(Constants.NATIVE_WINDOW_SUB_DIR)).getDefaultDisplay().getMetrics(displayMetrics);
        int i10 = displayMetrics.widthPixels;
        int i11 = (i10 * 6) / 10;
        f54806f = (i10 - (((int) m70844o(context, 23)) * 4)) / 3;
        f54811k = (i11 - (((int) m70844o(context, 16)) * 2)) / 3;
        f54808h = (int) m70844o(context, 30);
        f54809i = (i11 - (((int) m70844o(context, 16)) * 2)) / 3;
        f54801a = (i10 - ((int) m70844o(context, 106))) - f54806f;
        int i12 = i10 / 2;
        f54802b = (i12 - ((int) m70844o(context, 106))) - (f54806f / 2);
        f54807g = (i11 - ((int) m70844o(context, 106))) - f54811k;
        f54803c = (i10 - ((int) m70844o(context, 245))) - f54806f;
        m70881x0(context, i10);
        m70885y0(context, i10);
        f54810j = (i11 - ((int) m70844o(context, m70797c0()))) - ((int) m70844o(context, 48));
        f54812l = i10 / 3;
        f54813m = i11 / 3;
        f54814n = (i10 - ((int) m70844o(context, 48))) - f54812l;
        f54816p = (i10 - ((int) m70844o(context, 64))) - f54812l;
        f54815o = (i11 - ((int) m70844o(context, 48))) - f54813m;
        f54817q = (i11 - ((int) m70844o(context, 64))) - f54813m;
        f54818r = i10 - ((int) m70844o(context, 76));
        f54819s = i12 - ((int) m70844o(context, 76));
        f54820t = i11 - ((int) m70844o(context, 76));
        f54799G = i10 - ((int) m70844o(context, 94));
        f54800H = (i10 - ((int) m70844o(context, 148))) / 2;
        f54821u = (i10 - ((int) m70844o(context, 168))) - f54806f;
        f54822v = (i11 - ((int) m70844o(context, 168))) - f54811k;
        f54823w = (i10 - ((int) m70844o(context, 148))) - f54806f;
        f54794B = (i11 - ((int) m70844o(context, 148))) - f54811k;
        f54824x = ((i10 - (C12808e.m76823b() * 2)) - ((int) m70844o(context, 116))) - f54808h;
        f54825y = ((i11 - (C12808e.m76823b() * 2)) - ((int) m70844o(context, 116))) - f54809i;
        f54826z = i10 - ((int) m70844o(context, 128));
        f54793A = i11 - ((int) m70844o(context, 128));
        f54795C = (i10 - ((int) m70844o(context, 64))) - f54812l;
        f54796D = (i11 - ((int) m70844o(context, 64))) - f54813m;
        f54797E = i10 - ((int) m70844o(context, 64));
        f54798F = i11 - ((int) m70844o(context, 64));
    }

    /* renamed from: E1 */
    public static void m70724E1(View view, int i10) {
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                layoutParams2.setMargins(layoutParams2.leftMargin, layoutParams2.topMargin, layoutParams2.rightMargin, i10);
                view.setLayoutParams(layoutParams2);
            }
            if (layoutParams instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) layoutParams;
                layoutParams3.setMargins(layoutParams3.leftMargin, layoutParams3.topMargin, layoutParams3.rightMargin, i10);
                view.setLayoutParams(layoutParams3);
            }
        }
    }

    /* renamed from: F */
    public static int m70725F(DisplayMetrics displayMetrics, Context context) {
        if (displayMetrics == null) {
            return 0;
        }
        return ((displayMetrics.heightPixels - m70789a0(context)) - m70818h1(context, 48)) - m70852q(context);
    }

    /* renamed from: F0 */
    public static void m70726F0(View view, Context context) {
        if (view == null || context == null) {
            C11839m.m70687e("UIUtil", "initTopBlankHeight, view or context is null");
            return;
        }
        int iM70852q = m70852q(context);
        int iM70789a0 = m70789a0(context);
        if (!m70753O0(context) || m70771U0()) {
            m70736I1(view, iM70852q + iM70789a0);
        } else {
            m70736I1(view, iM70852q);
        }
    }

    /* renamed from: F1 */
    public static void m70727F1(View view, int i10) {
        ViewGroup.LayoutParams layoutParams;
        if (view == null || (layoutParams = view.getLayoutParams()) == null) {
            return;
        }
        layoutParams.height = i10;
        view.setLayoutParams(layoutParams);
    }

    /* renamed from: G */
    public static int m70728G() {
        if (m70771U0()) {
            return 240;
        }
        return RecommendCardConstants.Num.BANNER_HEIGHT_FONT_SCALE;
    }

    /* renamed from: G0 */
    public static void m70729G0(View view, Context context) {
        if (view == null || context == null) {
            C11839m.m70687e("UIUtil", "initTopBlankHeight, view or context is null");
        } else {
            m70736I1(view, m70852q(context));
        }
    }

    /* renamed from: G1 */
    public static void m70730G1(View view) {
        ViewGroup.LayoutParams layoutParams;
        if (view == null || (layoutParams = view.getLayoutParams()) == null) {
            return;
        }
        layoutParams.height = -2;
        view.setLayoutParams(layoutParams);
    }

    /* renamed from: H */
    public static int m70731H(Context context, int i10) {
        int iM70746M = m70746M(context);
        if (m70753O0(context)) {
            iM70746M = m70749N(context);
        }
        return (((iM70746M - m70789a0(context)) * 4) / 10) - i10;
    }

    /* renamed from: H0 */
    public static boolean m70732H0(Context context) {
        if (context == null) {
            return false;
        }
        return C0219i.m1463a() >= 21 ? m70756P0(context) : (C0224k0.a.m1574c("ro.config.hw_tint", false) || C0219i.m1463a() > 17) ? C11829c.m70605p0() : C11829c.m70608q0();
    }

    /* renamed from: H1 */
    public static void m70733H1(View view, float f10) {
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                int i10 = (int) f10;
                layoutParams2.setMargins(i10, layoutParams2.topMargin, i10, layoutParams2.bottomMargin);
                view.setLayoutParams(layoutParams2);
            }
            if (layoutParams instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) layoutParams;
                int i11 = (int) f10;
                layoutParams3.setMargins(i11, layoutParams3.topMargin, i11, layoutParams3.bottomMargin);
                view.setLayoutParams(layoutParams3);
            }
        }
    }

    /* renamed from: I */
    public static int m70734I(Context context) {
        return f54803c;
    }

    /* renamed from: I0 */
    public static boolean m70735I0() throws NoSuchMethodException, SecurityException {
        if (!m70744L0()) {
            return false;
        }
        int iM70880x = m70880x();
        C11839m.m70686d("UIUtil", "fold displayMode =" + iM70880x);
        if (2 == iM70880x) {
            return false;
        }
        return 1 == iM70880x || 7 == iM70880x;
    }

    /* renamed from: I1 */
    public static void m70736I1(View view, int i10) {
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                layoutParams2.setMargins(layoutParams2.leftMargin, i10, layoutParams2.rightMargin, layoutParams2.bottomMargin);
                view.setLayoutParams(layoutParams2);
            }
            if (layoutParams instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) layoutParams;
                layoutParams3.setMargins(layoutParams3.leftMargin, i10, layoutParams3.rightMargin, layoutParams3.bottomMargin);
                view.setLayoutParams(layoutParams3);
            }
        }
    }

    /* renamed from: J */
    public static int m70737J(Activity activity) {
        return ((m70746M(activity) - m70840n(activity, 24)) / 12) * 2;
    }

    /* renamed from: J0 */
    public static boolean m70738J0() {
        return !TextUtils.isEmpty(C0224k0.a.m1573b("ro.config.hw_fold_disp", ""));
    }

    /* renamed from: J1 */
    public static void m70739J1(View view, int i10) {
        ViewGroup.LayoutParams layoutParams;
        if (view == null || (layoutParams = view.getLayoutParams()) == null) {
            return;
        }
        layoutParams.width = i10;
        view.setLayoutParams(layoutParams);
    }

    /* renamed from: K */
    public static int m70740K(Activity activity) {
        return (m70749N(activity) - m70840n(activity, 24)) / 8;
    }

    /* renamed from: K0 */
    public static boolean m70741K0() {
        return C0209d.m1249e1();
    }

    /* renamed from: K1 */
    public static void m70742K1(View view) {
        ViewGroup.LayoutParams layoutParams;
        if (view == null || (layoutParams = view.getLayoutParams()) == null) {
            return;
        }
        layoutParams.width = -1;
        view.setLayoutParams(layoutParams);
    }

    /* renamed from: L */
    public static int m70743L() {
        return f54797E;
    }

    /* renamed from: L0 */
    public static boolean m70744L0() throws NoSuchMethodException, SecurityException {
        try {
            Method method = Class.forName("com.huawei.android.fsm.HwFoldScreenManagerEx").getMethod("isFoldable", new Class[0]);
            method.setAccessible(true);
            return ((Boolean) method.invoke(null, new Object[0])).booleanValue();
        } catch (Exception e10) {
            C11839m.m70687e("UIUtil", "isFoldable exception: " + e10.getMessage());
            return false;
        }
    }

    /* renamed from: L1 */
    public static void m70745L1(ViewGroup viewGroup, Context context) {
        int iM70789a0;
        if (viewGroup == null) {
            C11839m.m70687e("UIUtil", "viewGroup is null");
            return;
        }
        ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            if (!C12806c.m76815f(context) || C0219i.m1463a() <= 15) {
                iM70789a0 = m70789a0(context) + m70852q(context);
            } else {
                iM70789a0 = m70852q(context);
            }
            layoutParams2.setMargins(0, iM70789a0, 0, 0);
        }
    }

    /* renamed from: M */
    public static int m70746M(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService(Constants.NATIVE_WINDOW_SUB_DIR)).getDefaultDisplay().getRealMetrics(displayMetrics);
        int i10 = displayMetrics.widthPixels;
        int i11 = displayMetrics.heightPixels;
        return i10 > i11 ? i10 : i11;
    }

    /* renamed from: M0 */
    public static boolean m70747M0(Context context) {
        return C0209d.m1237b1(context);
    }

    /* renamed from: M1 */
    public static void m70748M1(Context context, TextView textView) {
        if (context == null || textView == null) {
            C11839m.m70687e("UIUtil", "context or layoutview is null");
            return;
        }
        Resources resources = context.getResources();
        if (resources == null) {
            C11839m.m70687e("UIUtil", "resources is null");
            return;
        }
        int i10 = m70876w(context).widthPixels;
        if ((context instanceof Activity) && m70771U0() && m70774V0((Activity) context)) {
            i10 = (i10 * 6) / 10;
        }
        textView.setMaxWidth(((int) ((i10 * 2.0f) / 3.0f)) - (resources.getDimensionPixelSize(R$dimen.padding_l) * 2));
    }

    /* renamed from: N */
    public static int m70749N(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService(Constants.NATIVE_WINDOW_SUB_DIR)).getDefaultDisplay().getRealMetrics(displayMetrics);
        int i10 = displayMetrics.widthPixels;
        int i11 = displayMetrics.heightPixels;
        return i10 > i11 ? i11 : i10;
    }

    /* renamed from: N0 */
    public static boolean m70750N0() {
        try {
            int foldableState = HwFoldScreenManagerEx.getFoldableState();
            C11839m.m70687e("UIUtil", "=========== isFoldedScreenExpand Foldable state = " + foldableState);
            return foldableState == 1 || foldableState == 3;
        } catch (Throwable th2) {
            C11839m.m70688i("UIUtil", "isFoldedScreenExpand exception:" + th2.getMessage());
            return false;
        }
    }

    /* renamed from: N1 */
    public static void m70751N1(Context context, Window window) {
        if (C0219i.m1463a() >= 17) {
            m70757P1(window);
        } else {
            m70754O1(context, window);
        }
    }

    /* renamed from: O */
    public static int m70752O(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService(Constants.NATIVE_WINDOW_SUB_DIR)).getDefaultDisplay().getMetrics(displayMetrics);
        int i10 = displayMetrics.widthPixels;
        int i11 = displayMetrics.heightPixels;
        return i10 > i11 ? i10 : i11;
    }

    /* renamed from: O0 */
    public static boolean m70753O0(Context context) {
        Resources resources;
        return (context == null || (resources = context.getResources()) == null || resources.getConfiguration().orientation != 2) ? false : true;
    }

    /* renamed from: O1 */
    public static void m70754O1(Context context, Window window) {
        C11829c.m70585i1(window);
        window.getDecorView().setOnSystemUiVisibilityChangeListener(new c(window, context));
        C11829c.m70633y1(context, window);
    }

    /* renamed from: P */
    public static int m70755P(Context context) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        WindowManager windowManager;
        Display defaultDisplay;
        if (context == null || (windowManager = (WindowManager) context.getSystemService(Constants.NATIVE_WINDOW_SUB_DIR)) == null || (defaultDisplay = windowManager.getDefaultDisplay()) == null) {
            return 0;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        int i10 = displayMetrics.heightPixels;
        try {
            Point point = new Point();
            Display.class.getMethod("getRealSize", Point.class).invoke(defaultDisplay, point);
            return point.y;
        } catch (RuntimeException e10) {
            BaseLogger.m28732e("UIUtil", "getScreenRealHeigt RuntimeException: getRealSize", e10.toString());
            return i10;
        } catch (Exception e11) {
            BaseLogger.m28732e("UIUtil", "getScreenRealHeigt Exception: getRealSize", e11.toString());
            return i10;
        }
    }

    /* renamed from: P0 */
    public static boolean m70756P0(Context context) {
        Resources resources;
        Configuration configuration;
        return (context == null || (resources = context.getResources()) == null || (configuration = resources.getConfiguration()) == null || (configuration.uiMode & 48) != 32) ? false : true;
    }

    /* renamed from: P1 */
    public static void m70757P1(Window window) {
        C11829c.m70588j1(window);
        window.getDecorView().setOnSystemUiVisibilityChangeListener(new d(window));
    }

    /* renamed from: Q */
    public static int m70758Q(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (context == null) {
            return 0;
        }
        ((WindowManager) context.getSystemService(Constants.NATIVE_WINDOW_SUB_DIR)).getDefaultDisplay().getMetrics(displayMetrics);
        int i10 = displayMetrics.widthPixels;
        int i11 = displayMetrics.heightPixels;
        return i10 > i11 ? i11 : i10;
    }

    /* renamed from: Q0 */
    public static boolean m70759Q0() {
        return (m70735I0() || m70771U0()) ? false : true;
    }

    /* renamed from: Q1 */
    public static void m70760Q1(Context context, View view) {
        if (context == null) {
            C11839m.m70687e("UIUtil", "setNodataLayout context is null");
        } else {
            m70763R1(context, view, (int) m70844o(context, m70728G()));
        }
    }

    /* renamed from: R */
    public static int m70761R() {
        return f54799G;
    }

    /* renamed from: R0 */
    public static boolean m70762R0() {
        return C0209d.m1170F1();
    }

    /* renamed from: R1 */
    public static void m70763R1(Context context, View view, int i10) {
        if (context == null) {
            C11839m.m70687e("UIUtil", "setNodataLayout context is null");
            return;
        }
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                if ((!m70753O0(context) || m70747M0(context)) && !C11829c.m70502B0((Activity) context)) {
                    layoutParams2.setMargins(layoutParams2.leftMargin, i10, layoutParams2.rightMargin, layoutParams2.bottomMargin);
                    layoutParams2.removeRule(15);
                } else {
                    layoutParams2.addRule(15);
                    layoutParams2.setMargins(layoutParams2.leftMargin, 0, layoutParams2.rightMargin, layoutParams2.bottomMargin);
                }
                view.setLayoutParams(layoutParams);
                return;
            }
            if (layoutParams instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) layoutParams;
                if ((!m70753O0(context) || m70747M0(context)) && !C11829c.m70502B0((Activity) context)) {
                    layoutParams3.setMargins(layoutParams3.leftMargin, i10, layoutParams3.rightMargin, layoutParams3.bottomMargin);
                    layoutParams3.gravity = -1;
                } else {
                    layoutParams3.gravity = 16;
                    layoutParams3.setMargins(layoutParams3.leftMargin, 0, layoutParams3.rightMargin, layoutParams3.bottomMargin);
                }
                view.setLayoutParams(layoutParams);
            }
        }
    }

    /* renamed from: S */
    public static int m70764S() {
        return f54811k;
    }

    /* renamed from: S0 */
    public static boolean m70765S0() {
        return C8974f.m56783a(Locale.getDefault()) == 1;
    }

    /* renamed from: S1 */
    public static void m70766S1(Activity activity, View view) {
        if (m70771U0()) {
            m70784Y1(activity, view);
        } else {
            m70803d2(activity, view);
        }
    }

    /* renamed from: T */
    public static int m70767T() {
        return f54809i;
    }

    /* renamed from: T0 */
    public static boolean m70768T0(Context context) {
        if (context == null) {
            return false;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService(Constants.NATIVE_WINDOW_SUB_DIR)).getDefaultDisplay().getRealMetrics(displayMetrics);
        int i10 = displayMetrics.widthPixels;
        int i11 = displayMetrics.heightPixels;
        if (i10 == 0 || i11 == 0) {
            return false;
        }
        float f10 = i11 / i10;
        if (f10 < 1.0f && f10 != 0.0f) {
            f10 = 1.0f / f10;
        }
        return f10 >= 1.0f && f10 <= 1.7f;
    }

    /* renamed from: T1 */
    public static void m70769T1(Context context, SpanClickText spanClickText, boolean z10, boolean z11, boolean z12, boolean z13) {
        if (context == null || spanClickText == null) {
            return;
        }
        String strTrim = C0234s.m1624b(context, R$string.permission_instruction).trim();
        String strTrim2 = C0234s.m1624b(context, R$string.privacy_value_added_services).trim();
        String strM1624b = C0234s.m1624b(context, R$string.user_agreement);
        String strM1624b2 = C0234s.m1624b(context, R$string.privacy_statement);
        String upperCase = C0234s.m1624b(context, R$string.cloud_oobe_agree_and_proceed_text).toUpperCase(Locale.getDefault());
        if (!z13) {
            upperCase = C0234s.m1624b(context, R$string.next_step).toUpperCase(Locale.getDefault());
        }
        if (z12) {
            upperCase = C0234s.m1624b(context, R$string.agree_ok).toUpperCase(Locale.getDefault());
        }
        String str = upperCase;
        String string = context.getString(R$string.privacy_oobe_content_agree_continue_adult_20230721, str, strM1624b, strTrim2, strTrim, strM1624b, strM1624b2);
        boolean z14 = true;
        if (z10) {
            string = context.getString(R$string.privacy_child_content_agree_continue_adult_20230721, str, strM1624b, strTrim, strM1624b, strM1624b2);
        } else {
            spanClickText.m15931c(strTrim2, new C11426a(context, "added_services", z13 || z12));
        }
        if (!z13 && !z12) {
            z14 = false;
        }
        spanClickText.m15931c(strTrim, new C11426a(context, "permission_description", z14));
        spanClickText.m15934g(string, false);
        spanClickText.setVisibility(0);
    }

    /* renamed from: U */
    public static int m70770U(Context context) {
        return f54807g;
    }

    /* renamed from: U0 */
    public static boolean m70771U0() {
        return C0209d.m1170F1() || m70741K0();
    }

    /* renamed from: U1 */
    public static void m70772U1(Activity activity, int i10) {
        if (activity == null) {
            return;
        }
        activity.setRequestedOrientation(i10);
    }

    /* renamed from: V */
    public static int m70773V() {
        return f54810j;
    }

    /* renamed from: V0 */
    public static boolean m70774V0(Activity activity) {
        return C0224k0.m1531A(activity);
    }

    /* renamed from: V1 */
    public static void m70775V1(Context context, View view) {
        m70733H1(view, m70876w(context).widthPixels / 12);
    }

    /* renamed from: W */
    public static int m70776W() {
        return f54798F;
    }

    /* renamed from: W0 */
    public static boolean m70777W0(View view, int i10) {
        int width;
        if (view == null) {
            return false;
        }
        f fVar = f.PERCENT_0;
        if (i10 <= fVar.f54844a) {
            return true;
        }
        Rect rect = new Rect();
        return C9603h0.m59863S(view) && view.getLocalVisibleRect(rect) && (width = view.getWidth() * view.getHeight()) > fVar.f54844a && ((rect.width() * rect.height()) * f.PERCENT_100.f54844a) / width >= i10;
    }

    /* renamed from: W1 */
    public static void m70778W1(Context context, View view) {
        m70733H1(view, m70876w(context).widthPixels / 8);
    }

    /* renamed from: X */
    public static int m70779X() {
        return f54813m;
    }

    /* renamed from: X0 */
    public static void m70780X0(Button button, Context context) {
        if (button == null) {
            return;
        }
        DisplayMetrics displayMetricsM70876w = m70876w(context);
        int i10 = displayMetricsM70876w.widthPixels;
        int i11 = displayMetricsM70876w.heightPixels;
        if (i10 > i11) {
            i10 = i11;
        }
        int iM70844o = (int) m70844o(context, 32);
        ViewGroup.LayoutParams layoutParams = button.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = i10 - iM70844o;
            button.setLayoutParams(layoutParams);
        }
    }

    /* renamed from: X1 */
    public static void m70781X1(Context context, View view) {
        if (context == null || view == null) {
            return;
        }
        int dimensionPixelSize = ((m70876w(context).heightPixels * 3) / 4) - context.getResources().getDimensionPixelSize(R$dimen.cloud_storage_detail_margin_48);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            layoutParams2.width = dimensionPixelSize;
            view.setLayoutParams(layoutParams2);
        }
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) layoutParams;
            layoutParams3.width = dimensionPixelSize;
            view.setLayoutParams(layoutParams3);
        }
    }

    /* renamed from: Y */
    public static int m70782Y() {
        return f54820t;
    }

    /* renamed from: Y0 */
    public static void m70783Y0(Activity activity) {
        if (activity == null) {
            C11839m.m70687e("UIUtil", "layoutNoLeftAndRightPadding activity is null");
            return;
        }
        View decorView = activity.getWindow().getDecorView();
        if (decorView == null) {
            C11839m.m70687e("UIUtil", "layoutNoLeftAndRightPadding view is null");
        } else {
            decorView.setPadding(0, decorView.getPaddingTop(), 0, decorView.getPaddingBottom());
        }
    }

    /* renamed from: Y1 */
    public static void m70784Y1(Activity activity, View view) {
        DisplayMetrics displayMetricsM70876w;
        if (!m70771U0() || view == null || activity == null || (displayMetricsM70876w = m70876w(activity)) == null) {
            return;
        }
        int i10 = displayMetricsM70876w.widthPixels;
        m70875v2(view);
        int i11 = m70753O0(activity) ? i10 / 3 : i10 / 2;
        view.setMinimumWidth(i11);
        view.post(new b(view, i11, activity, i10));
    }

    /* renamed from: Z */
    public static int m70785Z() {
        return f54815o;
    }

    /* renamed from: Z0 */
    public static void m70786Z0(Activity activity) {
        if (activity == null) {
            C11839m.m70687e("UIUtil", "layoutOneTwelfthPadding activity is null");
            return;
        }
        View decorView = activity.getWindow().getDecorView();
        if (decorView == null) {
            C11839m.m70687e("UIUtil", "layoutOneTwelfthPadding view is null");
            return;
        }
        int iM70737J = m70737J(activity);
        decorView.setPadding(iM70737J, decorView.getPaddingTop(), iM70737J, decorView.getPaddingBottom());
        Resources resources = activity.getResources();
        if (resources != null) {
            decorView.setBackgroundColor(resources.getColor(R$color.hicloud_activity_bg));
        }
    }

    /* renamed from: Z1 */
    public static void m70787Z1(Context context, View view) {
        if (context == null || view == null) {
            return;
        }
        int dimensionPixelSize = ((m70876w(context).widthPixels * 3) / 4) - context.getResources().getDimensionPixelSize(R$dimen.cloud_storage_detail_margin_48);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            layoutParams2.width = dimensionPixelSize;
            view.setLayoutParams(layoutParams2);
        }
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) layoutParams;
            layoutParams3.width = dimensionPixelSize;
            view.setLayoutParams(layoutParams3);
        }
    }

    /* renamed from: a0 */
    public static int m70789a0(Context context) {
        int identifier;
        if (context != null && (identifier = context.getResources().getIdentifier("status_bar_height", "dimen", OsType.ANDROID)) > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    /* renamed from: a1 */
    public static void m70790a1(Activity activity) {
        if (activity == null) {
            C11839m.m70687e("UIUtil", "layoutPadMultiModePadding activity is null");
            return;
        }
        View decorView = activity.getWindow().getDecorView();
        if (decorView == null) {
            C11839m.m70687e("UIUtil", "layoutPadMultiModePadding view is null");
            return;
        }
        decorView.setPadding(0, decorView.getPaddingTop(), 0, decorView.getPaddingBottom());
        Resources resources = activity.getResources();
        if (resources != null) {
            decorView.setBackgroundColor(resources.getColor(R$color.hicloud_activity_bg));
        }
    }

    /* renamed from: a2 */
    public static void m70791a2(View view) {
        m70811f2(view, 0);
    }

    /* renamed from: b0 */
    public static Drawable m70793b0(Context context, int i10) {
        if (context == null) {
            return null;
        }
        Drawable drawable = context.getDrawable(m70765S0() ? R$drawable.ic_text_mini_arrow_left : R$drawable.ic_arrow_text_mini);
        drawable.setColorFilter(new PorterDuffColorFilter(i10, PorterDuff.Mode.SRC_IN));
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        return drawable;
    }

    /* renamed from: b1 */
    public static void m70794b1(Activity activity) {
        if (activity == null) {
            C11839m.m70687e("UIUtil", "layoutOneEighthPadding activity is null");
            return;
        }
        View decorView = activity.getWindow().getDecorView();
        if (decorView == null) {
            C11839m.m70687e("UIUtil", "layoutOneEighthPadding view is null");
            return;
        }
        int iM70740K = m70740K(activity);
        decorView.setPadding(iM70740K, decorView.getPaddingTop(), iM70740K, decorView.getPaddingBottom());
        Resources resources = activity.getResources();
        if (resources != null) {
            decorView.setBackgroundColor(resources.getColor(R$color.hicloud_activity_bg));
        }
    }

    /* renamed from: b2 */
    public static void m70795b2(Context context, View view) {
        Resources resources;
        if (context == null || view == null || (resources = context.getResources()) == null) {
            return;
        }
        view.setPadding(resources.getDimensionPixelSize(R$dimen.emui_dimens_max_start), view.getPaddingTop(), resources.getDimensionPixelSize(R$dimen.emui_dimens_max_end), view.getPaddingBottom());
    }

    /* renamed from: c */
    public static void m70796c(Context context, View view) {
        Drawable drawable;
        if (!C0209d.m1293p1() || (drawable = context.getDrawable(R$drawable.card_view_item_bg_ink)) == null || view == null) {
            return;
        }
        view.setBackground(drawable);
    }

    /* renamed from: c0 */
    public static int m70797c0() {
        return C12808e.m76823b() + 120;
    }

    /* renamed from: c1 */
    public static void m70798c1(Activity activity) {
        if (activity == null) {
            C11839m.m70687e("UIUtil", "layoutOneEighthPadding activity is null");
            return;
        }
        WindowManager windowManager = activity.getWindowManager();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
        int i10 = displayMetrics.widthPixels;
        View decorView = activity.getWindow().getDecorView();
        if (decorView == null) {
            C11839m.m70687e("UIUtil", "layoutOneEighthPadding view is null");
            return;
        }
        int i11 = i10 / 8;
        decorView.setPadding(i11, decorView.getPaddingTop(), i11, decorView.getPaddingBottom());
        Resources resources = activity.getResources();
        if (resources != null) {
            decorView.setBackgroundColor(resources.getColor(R$color.hicloud_activity_bg));
        }
    }

    /* renamed from: c2 */
    public static void m70799c2(Context context, View view) throws Resources.NotFoundException {
        Resources resources;
        if (context == null || view == null || (resources = context.getResources()) == null) {
            return;
        }
        int dimensionPixelSize = resources.getDimensionPixelSize(R$dimen.emui_dimens_max_start);
        int i10 = R$dimen.cs_8_dp;
        view.setPadding(dimensionPixelSize - resources.getDimensionPixelSize(i10), view.getPaddingTop(), resources.getDimensionPixelSize(R$dimen.emui_dimens_max_end) - resources.getDimensionPixelSize(i10), view.getPaddingBottom());
    }

    /* renamed from: d */
    public static void m70800d(Intent intent, int i10) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            Class.forName("android.content.Intent").getMethod("addHwFlags", Integer.TYPE).invoke(intent, Integer.valueOf(i10));
        } catch (ClassNotFoundException unused) {
            C11839m.m70687e("UIUtil", "addHwFlags ClassNotFoundException->");
        } catch (IllegalAccessException unused2) {
            C11839m.m70687e("UIUtil", "addHwFlags IllegalAccessException->");
        } catch (IllegalArgumentException unused3) {
            C11839m.m70687e("UIUtil", "addHwFlags IllegalArgumentException->");
        } catch (NoSuchMethodException unused4) {
            C11839m.m70687e("UIUtil", "addHwFlags NoSuchMethodException->");
        } catch (InvocationTargetException unused5) {
            C11839m.m70687e("UIUtil", "addHwFlags InvocationTargetException->");
        } catch (Exception unused6) {
            C11839m.m70687e("UIUtil", "addHwFlags Exception->");
        }
    }

    /* renamed from: d0 */
    public static int m70801d0() {
        return f54812l;
    }

    /* renamed from: d1 */
    public static void m70802d1(Activity activity) {
        if (activity == null) {
            C11839m.m70687e("UIUtil", "layoutOneTwelfthPadding activity is null");
            return;
        }
        WindowManager windowManager = activity.getWindowManager();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
        int i10 = displayMetrics.widthPixels;
        View decorView = activity.getWindow().getDecorView();
        if (decorView == null) {
            C11839m.m70687e("UIUtil", "layoutOneTwelfthPadding view is null");
            return;
        }
        int i11 = i10 / 12;
        decorView.setPadding(i11, decorView.getPaddingTop(), i11, decorView.getPaddingBottom());
        Resources resources = activity.getResources();
        if (resources != null) {
            decorView.setBackgroundColor(resources.getColor(R$color.hicloud_activity_bg));
        }
    }

    /* renamed from: d2 */
    public static void m70803d2(Activity activity, View view) {
        DisplayMetrics displayMetricsM70876w;
        if (view == null || activity == null || (displayMetricsM70876w = m70876w(activity)) == null) {
            return;
        }
        int i10 = displayMetricsM70876w.widthPixels;
        if (m70771U0()) {
            return;
        }
        m70875v2(view);
        int i11 = i10 / 2;
        view.setMinimumWidth(i11);
        view.post(new a(view, i11, activity, i10));
    }

    /* renamed from: e */
    public static View.AccessibilityDelegate m70804e() {
        return new e();
    }

    /* renamed from: e0 */
    public static int m70805e0() {
        return f54818r;
    }

    /* renamed from: e1 */
    public static boolean m70806e1(Activity activity) {
        if (m70738J0() && !m70747M0(activity) && !m70753O0(activity)) {
            return false;
        }
        if ((C0224k0.m1531A(activity) && !m70753O0(activity)) || C11829c.m70499A0(activity)) {
            return false;
        }
        if (!m70750N0() && !m70771U0()) {
            return !C11829c.m70502B0(activity) && m70753O0(activity);
        }
        int iM70856r = m70856r(activity);
        int iM70872v = m70872v();
        C11839m.m70686d("UIUtil", "width:" + iM70856r + "ScreenWidth:" + iM70872v);
        return iM70856r > iM70872v / 2;
    }

    /* renamed from: e2 */
    public static void m70807e2(Context context, SpanClickText spanClickText, boolean z10) {
        if (context == null || spanClickText == null) {
            return;
        }
        String strTrim = C0234s.m1624b(context, R$string.permission_instruction).trim();
        String strTrim2 = C0234s.m1624b(context, R$string.privacy_value_added_services).trim();
        String strM1624b = C0234s.m1624b(context, R$string.user_agreement);
        String strM1624b2 = C0234s.m1624b(context, R$string.privacy_statement);
        String upperCase = C0234s.m1624b(context, R$string.agree_ok).toUpperCase(Locale.getDefault());
        String string = context.getString(R$string.privacy_content_agree_continue_adult_20230721, upperCase, strM1624b, strTrim2, strM1624b2, strTrim);
        if (z10) {
            string = context.getString(R$string.privacy_oobe_child_content_agree_continue_adult_20230721, upperCase, strM1624b, strM1624b2, strTrim);
        } else {
            spanClickText.m15931c(strTrim2, new C11426a(context, "added_services"));
        }
        spanClickText.m15931c(strM1624b, new C11430e(context, "user_agreement_cn"));
        spanClickText.m15931c(strM1624b2, new C11430e(context, "privacy_statement_cn"));
        spanClickText.m15931c(strTrim, new C11426a(context, "permission_description"));
        spanClickText.m15934g(string, false);
        spanClickText.setVisibility(0);
    }

    /* renamed from: f */
    public static void m70808f(Context context, String str, String str2, int i10) {
        if (context != null && "application".equals(str) && NotifyConstants.FM_CLEAR.equals(str2)) {
            Toast.makeText(context, i10, 1).show();
        }
    }

    /* renamed from: f0 */
    public static int m70809f0() {
        return f54819s;
    }

    /* renamed from: f1 */
    public static int m70810f1(Context context, float f10) {
        Resources resources;
        if (context == null || (resources = context.getResources()) == null) {
            return 0;
        }
        return (int) ((f10 / resources.getDisplayMetrics().density) + 0.5f);
    }

    /* renamed from: f2 */
    public static void m70811f2(View view, int i10) {
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                layoutParams2.setMargins(i10, layoutParams2.topMargin, i10, layoutParams2.bottomMargin);
                view.setLayoutParams(layoutParams);
            }
            if (layoutParams instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) layoutParams;
                layoutParams3.setMargins(i10, layoutParams3.topMargin, i10, layoutParams3.bottomMargin);
                view.setLayoutParams(layoutParams3);
            }
        }
    }

    /* renamed from: g */
    public static String m70812g(Context context, List<ImageInfo> list) {
        float f10 = m70753O0(context) ? 0.1587936f : 0.33307928f;
        int i10 = 0;
        ImageInfo imageInfo = list.get(0);
        float height = (imageInfo.getHeight() / imageInfo.getWidth()) - f10;
        float f11 = height;
        int i11 = 0;
        for (ImageInfo imageInfo2 : list) {
            float height2 = (imageInfo2.getHeight() / imageInfo2.getWidth()) - f10;
            if (Math.abs(height2) < Math.abs(f11)) {
                i10 = i11;
                f11 = height2;
            }
            i11++;
        }
        return list.get(i10).getUrl();
    }

    /* renamed from: g0 */
    public static int m70813g0() {
        return f54814n;
    }

    /* renamed from: g1 */
    public static int m70814g1(Context context, float f10) {
        Resources resources;
        if (context == null || (resources = context.getResources()) == null) {
            return 0;
        }
        return (int) ((f10 / resources.getDisplayMetrics().scaledDensity) + 0.5f);
    }

    /* renamed from: g2 */
    public static void m70815g2(View view, float f10) {
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                layoutParams2.setMargins(layoutParams2.leftMargin, layoutParams2.topMargin, layoutParams2.rightMargin, (int) f10);
                view.setLayoutParams(layoutParams);
            } else if (layoutParams instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) layoutParams;
                layoutParams3.setMargins(layoutParams3.leftMargin, layoutParams3.topMargin, layoutParams3.rightMargin, (int) f10);
                view.setLayoutParams(layoutParams);
            }
        }
    }

    /* renamed from: h */
    public static void m70816h(Window window) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (window == null) {
            return;
        }
        try {
            WindowManager.LayoutParams attributes = window.getAttributes();
            WindowManager.LayoutParams attributes2 = window.getAttributes();
            if (C0209d.m1277l1()) {
                WindowManagerEx.LayoutParamsEx layoutParamsEx = new WindowManagerEx.LayoutParamsEx(attributes);
                layoutParamsEx.getClass().getMethod("clearHwFlags", Integer.TYPE).invoke(layoutParamsEx, 33554432);
            } else {
                WindowManagerEx.LayoutParamsEx layoutParamsEx2 = new WindowManagerEx.LayoutParamsEx(attributes);
                layoutParamsEx2.getClass().getMethod("clearHwFlags", Integer.TYPE).invoke(layoutParamsEx2, 33554432);
            }
            window.setAttributes(attributes2);
        } catch (Exception e10) {
            AbstractC10896a.m65886e("UIUtil", "closeBackgroundBlurexception:" + e10.toString());
        }
    }

    /* renamed from: h0 */
    public static int m70817h0() {
        return f54821u;
    }

    /* renamed from: h1 */
    public static int m70818h1(Context context, float f10) {
        if (context == null) {
            return 0;
        }
        return (int) (f10 * context.getResources().getDisplayMetrics().density);
    }

    /* renamed from: h2 */
    public static void m70819h2(View view, int i10) {
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams).setMarginEnd(i10);
                view.setLayoutParams(layoutParams);
            }
            if (layoutParams instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
                layoutParams2.setMarginEnd(i10);
                view.setLayoutParams(layoutParams2);
            }
        }
    }

    /* renamed from: i */
    public static Bitmap m70820i(Bitmap bitmap, int i10, int i11, int i12, int i13) {
        try {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, i10, i11, i12, i13, (Matrix) null, false);
            if (bitmap != null && !bitmap.equals(bitmapCreateBitmap) && !bitmap.isRecycled()) {
                bitmap.recycle();
            }
            return bitmapCreateBitmap;
        } catch (Exception e10) {
            C11839m.m70687e("UIUtil", "cutImg err : " + e10.getMessage());
            return null;
        }
    }

    /* renamed from: i0 */
    public static int m70821i0(int i10, Context context) {
        if (context == null) {
            return 0;
        }
        if (i10 == 0) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService(Constants.NATIVE_WINDOW_SUB_DIR)).getDefaultDisplay().getMetrics(displayMetrics);
            i10 = displayMetrics.widthPixels;
        }
        int i11 = (i10 * 6) / 10;
        return (m70771U0() && (context instanceof Activity) && m70774V0((Activity) context)) ? (i11 - ((int) m70844o(context, 64))) - (i11 / 3) : (i10 - ((int) m70844o(context, 64))) - (i10 / 3);
    }

    /* renamed from: i1 */
    public static void m70822i1(Activity activity) {
        View viewM1152B;
        if (activity == null) {
            C11839m.m70687e("UIUtil", "activity is null");
        } else {
            if (!m70753O0(activity) || (viewM1152B = C0209d.m1152B(activity.getWindow())) == null) {
                return;
            }
            viewM1152B.setSystemUiVisibility(viewM1152B.getSystemUiVisibility() & (-5));
        }
    }

    /* renamed from: i2 */
    public static void m70823i2(View view, float f10) {
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                int i10 = (int) f10;
                layoutParams2.setMargins(i10, layoutParams2.topMargin, i10, layoutParams2.bottomMargin);
                view.setLayoutParams(layoutParams);
                return;
            }
            if (layoutParams instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) layoutParams;
                int i11 = (int) f10;
                layoutParams3.setMargins(i11, layoutParams3.topMargin, i11, layoutParams3.bottomMargin);
                view.setLayoutParams(layoutParams);
            }
        }
    }

    /* renamed from: j */
    public static int m70824j() {
        return 68117;
    }

    /* renamed from: j0 */
    public static int m70825j0(Context context) {
        if (context == null) {
            C11839m.m70687e("UIUtil", "context is null");
            return 0;
        }
        Resources resources = context.getResources();
        if (resources != null) {
            return m70755P(context) - (m70771U0() ? resources.getDimensionPixelSize(R$dimen.cloud_space_120_dp) : m70747M0(context) ? resources.getDimensionPixelSize(R$dimen.cloud_space_240_dp) : resources.getConfiguration().orientation == 2 ? resources.getDimensionPixelSize(R$dimen.cloud_space_64_dp) : resources.getDimensionPixelSize(R$dimen.cloud_space_260_dp));
        }
        C11839m.m70687e("UIUtil", "resources is null");
        return 0;
    }

    /* renamed from: j1 */
    public static void m70826j1(Context context, View view) {
        DisplayMetrics displayMetricsM70876w = m70876w(context);
        int i10 = displayMetricsM70876w.widthPixels;
        int i11 = displayMetricsM70876w.heightPixels;
        if (i10 > i11) {
            i10 = i11;
        }
        m70843n2(view, (int) ((i10 * 9.0f) / 16.0f));
    }

    /* renamed from: j2 */
    public static void m70827j2(View view, int i10) {
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                layoutParams2.setMargins(layoutParams2.leftMargin, i10, layoutParams2.rightMargin, layoutParams2.bottomMargin);
                view.setLayoutParams(layoutParams);
            } else if (layoutParams instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) layoutParams;
                layoutParams3.setMargins(layoutParams3.leftMargin, i10, layoutParams3.rightMargin, layoutParams3.bottomMargin);
                view.setLayoutParams(layoutParams);
            }
        }
    }

    /* renamed from: k */
    public static int m70828k() {
        return 65556;
    }

    /* renamed from: k0 */
    public static int m70829k0(Context context) {
        int iM70789a0;
        boolean z10;
        if (context == null) {
            return 0;
        }
        if (C0219i.m1463a() < 17 || !C11829c.m70563b0(context)) {
            iM70789a0 = 0;
            z10 = false;
        } else {
            iM70789a0 = m70789a0(context);
            z10 = true;
        }
        if (m70771U0()) {
            if (context.getResources().getConfiguration().orientation == 1) {
                return 466;
            }
            return z10 ? m70810f1(context, iM70789a0) + ErrorCode.ERROR_SIGTOOL_FAIL : ErrorCode.ERROR_SIGTOOL_FAIL;
        }
        if (m70747M0(context)) {
            return context.getResources().getConfiguration().orientation == 1 ? 472 : 540;
        }
        if (context.getResources().getConfiguration().orientation != 2) {
            return 0;
        }
        if (z10) {
            return m70810f1(context, iM70789a0) + 472;
        }
        return 472;
    }

    /* renamed from: k1 */
    public static void m70830k1(Context context, View view, View view2, ViewGroup viewGroup) {
        DisplayMetrics displayMetricsM70876w = m70876w(context);
        int i10 = displayMetricsM70876w.widthPixels;
        int i11 = displayMetricsM70876w.heightPixels;
        if (i10 > i11) {
            i10 = i11;
        }
        m70843n2(view, (int) (((i10 * 9.0f) / 21.0f) + 0.5f));
    }

    /* renamed from: k2 */
    public static void m70831k2(Context context, View view) {
        view.setPadding(0, m70789a0(context), 0, 0);
    }

    /* renamed from: l */
    public static int m70832l() {
        return 65557;
    }

    /* renamed from: l0 */
    public static int m70833l0(Context context) {
        return (context == null || m70771U0() || m70747M0(context) || context.getResources().getConfiguration().orientation != 2) ? 0 : 472;
    }

    /* renamed from: l1 */
    public static void m70834l1(Context context, View view, View view2, ViewGroup viewGroup) {
        m70827j2(view2, (int) (m70725F(m70876w(context), context) * 0.1f));
    }

    /* renamed from: l2 */
    public static void m70835l2(Context context, int i10, TextView textView) {
        if (context == null || textView == null) {
            return;
        }
        Drawable drawableM70793b0 = m70793b0(context, i10);
        if (m70765S0()) {
            textView.setCompoundDrawablesWithIntrinsicBounds(drawableM70793b0, (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawableM70793b0, (Drawable) null);
        }
    }

    /* renamed from: m */
    public static void m70836m(Activity activity) {
        C0224k0.m1549d(activity);
    }

    /* renamed from: m0 */
    public static int m70837m0() {
        return f54795C;
    }

    /* renamed from: m1 */
    public static void m70838m1(Context context, View view, View view2, ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        int iM70789a0 = m70789a0(context);
        DisplayMetrics displayMetricsM70876w = m70876w(context);
        int i10 = displayMetricsM70876w.widthPixels;
        int i11 = displayMetricsM70876w.heightPixels;
        if (i10 > i11) {
            i10 = i11;
        }
        m70827j2(view2, (int) (i10 * 0.8f * 0.16f));
        viewGroup.setPadding(0, iM70789a0, 0, 0);
    }

    /* renamed from: m2 */
    public static void m70839m2(TextView textView, int i10) {
        if (textView == null) {
            C11839m.m70687e("UIUtil", "textView is null");
        } else {
            textView.setTextSize(2, i10);
        }
    }

    /* renamed from: n */
    public static int m70840n(Context context, int i10) {
        if (context == null) {
            return 0;
        }
        return (int) ((i10 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    /* renamed from: n0 */
    public static int m70841n0() {
        return f54796D;
    }

    /* renamed from: n1 */
    public static void m70842n1(ActionBar actionBar, Drawable drawable) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        try {
            Class<?> cls = Class.forName("com.huawei.android.app.ActionBarEx");
            cls.getDeclaredMethod("setAppbarBackground", ActionBar.class, Drawable.class).invoke(cls, actionBar, drawable);
        } catch (ClassNotFoundException e10) {
            C11839m.m70687e("UIUtil", "ClassNotFoundException" + e10.toString());
        } catch (IllegalAccessException e11) {
            C11839m.m70687e("UIUtil", "IllegalAccessException" + e11.toString());
        } catch (NoSuchMethodException e12) {
            C11839m.m70687e("UIUtil", "NoSuchMethodException" + e12.toString());
        } catch (InvocationTargetException e13) {
            C11839m.m70687e("UIUtil", "InvocationTargetException" + e13.toString());
        }
    }

    /* renamed from: n2 */
    public static void m70843n2(View view, float f10) {
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.height = (int) f10;
            view.setLayoutParams(layoutParams);
        }
    }

    /* renamed from: o */
    public static float m70844o(Context context, int i10) {
        if (context == null) {
            return 0.0f;
        }
        return TypedValue.applyDimension(1, i10, context.getResources().getDisplayMetrics());
    }

    /* renamed from: o0 */
    public static int m70845o0() {
        return f54825y;
    }

    /* renamed from: o1 */
    public static void m70846o1(Context context, SpanClickText spanClickText, SpanClickText spanClickText2, SpanClickText spanClickText3, SpanClickText spanClickText4, boolean z10, boolean z11) {
        m70850p1(context, spanClickText, spanClickText2, spanClickText3, spanClickText4, z10, z11, false);
    }

    /* renamed from: o2 */
    public static void m70847o2(Context context, View view, DisplayMetrics displayMetrics) {
        if (view == null || context == null) {
            C11839m.m70688i("UIUtil", "view or context is null");
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            layoutParams2.width = displayMetrics.widthPixels;
            layoutParams2.height = m70755P(context) / 2;
            view.setLayoutParams(layoutParams2);
            return;
        }
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) layoutParams;
            layoutParams3.width = displayMetrics.widthPixels;
            layoutParams3.height = m70755P(context) / 2;
            view.setLayoutParams(layoutParams3);
        }
    }

    /* renamed from: p */
    public static ViewStub m70848p(View view, int i10) {
        if (view == null) {
            return null;
        }
        View viewFindViewById = view.findViewById(i10);
        if (viewFindViewById instanceof ViewStub) {
            return (ViewStub) viewFindViewById;
        }
        return null;
    }

    /* renamed from: p0 */
    public static int m70849p0() {
        return f54793A;
    }

    /* renamed from: p1 */
    public static void m70850p1(Context context, SpanClickText spanClickText, SpanClickText spanClickText2, SpanClickText spanClickText3, SpanClickText spanClickText4, boolean z10, boolean z11, boolean z12) {
        try {
            boolean zM1293p1 = C0209d.m1293p1();
            boolean z13 = !C11330h.m68077a();
            C11839m.m70688i("UIUtil", "isInk: " + zM1293p1 + ", isPfDisable: " + z13);
            if (C13452e.m80781L().m80850R0()) {
                if (C13452e.m80781L().m80795D0()) {
                    m70858r1(context, spanClickText, spanClickText2, spanClickText3, spanClickText4, zM1293p1, z13, z10, z11, z12);
                } else {
                    m70854q1(context, spanClickText, spanClickText2, spanClickText3, zM1293p1, z13, z10, z11, z12);
                }
            } else if (C0209d.m1199P0()) {
                m70858r1(context, spanClickText, spanClickText2, spanClickText3, spanClickText4, zM1293p1, z13, z10, z11, z12);
            } else {
                m70854q1(context, spanClickText, spanClickText2, spanClickText3, zM1293p1, z13, z10, z11, z12);
            }
        } catch (Exception e10) {
            C11839m.m70687e("UIUtil", "setAgreeTextContent exception: " + e10.toString());
        }
    }

    /* renamed from: p2 */
    public static void m70851p2(Context context, View view, DisplayMetrics displayMetrics) {
        if (view == null || context == null) {
            C11839m.m70688i("UIUtil", "view or context is null");
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        int iM70789a0 = displayMetrics.widthPixels;
        if (C11829c.m70563b0(context.getApplicationContext())) {
            iM70789a0 += m70789a0(context.getApplicationContext());
        }
        layoutParams.width = iM70789a0 / 2;
        view.setLayoutParams(layoutParams);
    }

    /* renamed from: q */
    public static int m70852q(Context context) {
        if (context == null) {
            return 0;
        }
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(R.attr.actionBarSize, typedValue, true)) {
            return TypedValue.complexToDimensionPixelSize(typedValue.data, context.getResources().getDisplayMetrics());
        }
        return 0;
    }

    /* renamed from: q0 */
    public static int m70853q0() {
        return f54794B;
    }

    /* renamed from: q1 */
    public static void m70854q1(Context context, SpanClickText spanClickText, SpanClickText spanClickText2, SpanClickText spanClickText3, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14) {
        m70718C1(context, spanClickText, false, z10, z11);
        if (z12) {
            m70769T1(context, spanClickText2, false, z10, z13, z14);
        } else {
            m70807e2(context, spanClickText2, false);
        }
    }

    /* renamed from: q2 */
    public static void m70855q2(Context context, View view, DisplayMetrics displayMetrics, boolean z10) {
        if (view == null || context == null) {
            C11839m.m70688i("UIUtil", "view or context is null");
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        int iM70789a0 = displayMetrics.widthPixels;
        if (C11829c.m70563b0(context.getApplicationContext())) {
            iM70789a0 += m70789a0(context.getApplicationContext());
        }
        layoutParams.width = iM70789a0 / 2;
        layoutParams.height = displayMetrics.heightPixels;
        C11839m.m70686d("UIUtil", "flp.width=" + layoutParams.width + ",flp.height=" + layoutParams.height);
        int i10 = layoutParams.width;
        int i11 = layoutParams.height;
        if (i10 >= i11) {
            i10 = i11;
        }
        if (z10) {
            i10 = (int) (i10 * 0.8d);
        }
        layoutParams.height = i10;
        layoutParams.width = i10;
        view.setLayoutParams(layoutParams);
    }

    /* renamed from: r */
    public static int m70856r(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (context == null) {
            return 0;
        }
        ((WindowManager) context.getSystemService(Constants.NATIVE_WINDOW_SUB_DIR)).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    /* renamed from: r0 */
    public static int m70857r0() {
        return f54817q;
    }

    /* renamed from: r1 */
    public static void m70858r1(Context context, SpanClickText spanClickText, SpanClickText spanClickText2, SpanClickText spanClickText3, SpanClickText spanClickText4, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14) {
        m70886y1(context, spanClickText);
        m70718C1(context, spanClickText2, true, z10, z11);
        if (z12) {
            m70769T1(context, spanClickText3, true, z10, z13, z14);
        } else {
            m70807e2(context, spanClickText3, true);
        }
    }

    /* renamed from: r2 */
    public static void m70859r2(Context context, View view, DisplayMetrics displayMetrics) {
        m70855q2(context, view, displayMetrics, true);
    }

    /* renamed from: s */
    public static Bitmap m70860s(Bitmap bitmap) {
        int iMin = Math.min(bitmap.getWidth(), bitmap.getHeight());
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iMin, iMin, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        float f10 = iMin / 2.0f;
        canvas.drawCircle(f10, f10, f10, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        return bitmapCreateBitmap;
    }

    /* renamed from: s0 */
    public static int m70861s0() {
        return f54822v;
    }

    /* renamed from: s1 */
    public static void m70862s1(Context context, View view) {
        if (view == null || context == null) {
            return;
        }
        m70875v2(view);
        int i10 = m70876w(context).widthPixels;
        if (m70771U0()) {
            i10 /= 3;
        } else if (m70747M0(context)) {
            i10 = m70753O0(context) ? i10 / 3 : i10 / 2;
        } else if (m70753O0(context)) {
            i10 /= 2;
        }
        view.setMinimumWidth(i10);
    }

    /* renamed from: s2 */
    public static void m70863s2(View... viewArr) {
        for (View view : viewArr) {
            if (view != null) {
                m70742K1(view);
            } else {
                C11839m.m70687e("UIUtil", "View is null");
            }
        }
    }

    /* renamed from: t */
    public static int m70864t(Activity activity) throws Resources.NotFoundException {
        int dimensionPixelSize;
        int iM70752O = m70753O0(activity) ? m70752O(activity) : m70758Q(activity);
        try {
            HwColumnSystem hwColumnSystem = new HwColumnSystem(activity);
            hwColumnSystem.setColumnType(0);
            dimensionPixelSize = (iM70752O - hwColumnSystem.getSuggestWidth()) / 2;
        } catch (Throwable th2) {
            C11839m.m70688i("UIUtil", "getSuggestWidth exception: " + th2.toString());
            dimensionPixelSize = activity.getResources().getDimensionPixelSize(R$dimen.cs_24_dp);
        }
        return dimensionPixelSize - activity.getResources().getDimensionPixelSize(R$dimen.cs_12_dp);
    }

    /* renamed from: t0 */
    public static int m70865t0() {
        return f54824x;
    }

    /* renamed from: t1 */
    public static void m70866t1(Context context, View view) {
        if (view == null || context == null) {
            return;
        }
        m70875v2(view);
        int i10 = m70876w(context).widthPixels;
        view.setMinimumWidth(m70771U0() ? i10 / 3 : m70747M0(context) ? m70753O0(context) ? i10 / 3 : i10 / 2 : m70753O0(context) ? i10 / 2 : i10 - ((int) (m70844o(context, 24) * 2.0f)));
    }

    /* renamed from: t2 */
    public static void m70867t2(View view) {
        if (view == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = -1;
        view.setLayoutParams(layoutParams);
    }

    /* renamed from: u */
    public static int m70868u(Context context) {
        return ((context instanceof Activity) && m70806e1((Activity) context)) ? 2 : 1;
    }

    /* renamed from: u0 */
    public static int m70869u0() {
        return f54826z;
    }

    /* renamed from: u1 */
    public static void m70870u1(Context context, View view) {
        if (view == null || context == null) {
            return;
        }
        m70875v2(view);
        int iM70833l0 = m70833l0(context);
        int iM70844o = iM70833l0 == 0 ? m70876w(context).widthPixels : (int) m70844o(context, iM70833l0);
        if (m70771U0()) {
            iM70844o /= 3;
        } else if (m70747M0(context)) {
            iM70844o = m70753O0(context) ? iM70844o / 3 : iM70844o / 2;
        } else if (m70753O0(context)) {
            iM70844o /= 2;
        }
        view.setMinimumWidth(iM70844o);
    }

    /* renamed from: u2 */
    public static void m70871u2(Activity activity, View view, DisplayMetrics displayMetrics) {
        if (view == null || activity == null) {
            C11839m.m70688i("UIUtil", "view or activity is null");
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            if (m70771U0() && m70774V0(activity)) {
                layoutParams2.height = layoutParams2.width;
            } else {
                layoutParams2.width = displayMetrics.widthPixels;
                int iM70755P = m70755P(activity) / 2;
                layoutParams2.height = iM70755P;
                int i10 = layoutParams2.width;
                if (i10 < iM70755P) {
                    iM70755P = i10;
                }
                int i11 = (int) (iM70755P * 0.8d);
                layoutParams2.height = i11;
                layoutParams2.width = i11;
            }
            view.setLayoutParams(layoutParams2);
        }
    }

    /* renamed from: v */
    public static int m70872v() {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            contextM1377a = contextM1377a.getApplicationContext();
        }
        if (contextM1377a == null) {
            return 0;
        }
        Display[] displays = ((DisplayManager) contextM1377a.getSystemService("display")).getDisplays();
        Point point = new Point();
        if (displays != null && displays.length > 0) {
            displays[0].getRealSize(point);
        }
        C11839m.m70686d("UIUtil", "ScreenWidth:" + point.x + "ScreenHeight:" + point.y);
        return point.x;
    }

    /* renamed from: v0 */
    public static int m70873v0() {
        return f54823w;
    }

    /* renamed from: v1 */
    public static void m70874v1(Activity activity, View view) {
        if (view == null || activity == null) {
            return;
        }
        m70875v2(view);
        int i10 = m70876w(activity).widthPixels;
        view.setMinimumWidth(m70771U0() ? !m70774V0(activity) ? m70753O0(activity) ? i10 / 3 : i10 / 2 : 0 : i10 / 2);
    }

    /* renamed from: v2 */
    public static void m70875v2(View view) {
        if (view == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = -2;
        view.setLayoutParams(layoutParams);
    }

    /* renamed from: w */
    public static DisplayMetrics m70876w(Context context) {
        if (context == null) {
            return null;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService(Constants.NATIVE_WINDOW_SUB_DIR)).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    /* renamed from: w0 */
    public static int m70877w0() {
        return f54816p;
    }

    /* renamed from: w1 */
    public static void m70878w1(Activity activity, View view) {
        if (view == null || activity == null) {
            return;
        }
        m70875v2(view);
        view.setMinimumWidth((m70876w(activity).widthPixels / 2) / 2);
    }

    /* renamed from: w2 */
    public static void m70879w2(Context context, int i10, View... viewArr) {
        for (View view : viewArr) {
            if (view != null) {
                m70739J1(view, m70840n(context, i10));
            } else {
                C11839m.m70687e("UIUtil", "View is null");
            }
        }
    }

    /* renamed from: x */
    public static int m70880x() throws NoSuchMethodException, SecurityException {
        try {
            Method method = Class.forName("com.huawei.android.fsm.HwFoldScreenManagerEx").getMethod("getDisplayMode", new Class[0]);
            method.setAccessible(true);
            return ((Integer) method.invoke(null, new Object[0])).intValue();
        } catch (Exception e10) {
            C11839m.m70687e("UIUtil", "getDisplayMode exception: " + e10.getMessage());
            return 0;
        }
    }

    /* renamed from: x0 */
    public static void m70881x0(Context context, int i10) {
        f54804d = (i10 - ((int) m70844o(context, m70797c0()))) - ((int) m70844o(context, 48));
    }

    /* renamed from: x1 */
    public static void m70882x1(Context context, View view) {
        Resources resources;
        if (context == null || view == null || (resources = context.getResources()) == null) {
            return;
        }
        m70811f2(view, resources.getDimensionPixelSize(R$dimen.emui_dimens_max_start) - resources.getDimensionPixelSize(R$dimen.cs_12_dp));
    }

    /* renamed from: x2 */
    public static void m70883x2(Dialog dialog) {
        if (dialog == null) {
            C11839m.m70687e("UIUtil", "showDialogSecurity dialog is null!");
            return;
        }
        try {
            dialog.show();
        } catch (Exception e10) {
            C11839m.m70687e("UIUtil", "showDialogSecurity show exception：" + e10.getMessage());
        }
    }

    /* renamed from: y */
    public static int m70884y() {
        return f54800H;
    }

    /* renamed from: y0 */
    public static void m70885y0(Context context, int i10) {
        f54805e = (((i10 / 2) - ((int) m70844o(context, m70797c0()))) - ((int) m70844o(context, 48))) - (m70753O0(context) ? ((int) m70844o(context, 16)) + ((int) m70844o(context, 24)) : 0);
    }

    /* renamed from: y1 */
    public static void m70886y1(Context context, SpanClickText spanClickText) {
        if (context == null || spanClickText == null) {
            return;
        }
        String string = context.getString(R$string.privacy_content_children_first);
        spanClickText.m15930b(string);
        spanClickText.m15934g(string, true);
        spanClickText.setVisibility(0);
    }

    /* renamed from: y2 */
    public static List<List<View>> m70887y2(List<View> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (View view : list) {
            if ((view instanceof NotchTopFitRelativeLayout) || (view instanceof NotchTopFitLinearLayout)) {
                arrayList2.add(view);
            } else {
                arrayList3.add(view);
            }
        }
        arrayList.add(arrayList2);
        arrayList.add(arrayList3);
        return arrayList;
    }

    /* renamed from: z */
    public static int m70888z() {
        return f54806f;
    }

    /* renamed from: z0 */
    public static void m70889z0(Activity activity) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        View decorView;
        if (activity != null) {
            Window window = activity.getWindow();
            ActionBar actionBar = activity.getActionBar();
            if (window == null || actionBar == null || (decorView = window.getDecorView()) == null) {
                return;
            }
            if (C0219i.m1463a() >= 21) {
                boolean zM70756P0 = m70756P0(activity);
                C11839m.m70688i("UIUtil", "isNightMode: " + zM70756P0);
                if (zM70756P0) {
                    decorView.setSystemUiVisibility(1280);
                } else {
                    decorView.setSystemUiVisibility(9472);
                }
            } else if (C0224k0.a.m1574c("ro.config.hw_tint", false) || C0219i.m1463a() > 17) {
                boolean zM70605p0 = C11829c.m70605p0();
                C11839m.m70688i("UIUtil", "deepDarkTheme: " + zM70605p0);
                if (zM70605p0) {
                    decorView.setSystemUiVisibility(1280);
                } else {
                    decorView.setSystemUiVisibility(9472);
                }
            } else {
                decorView.setSystemUiVisibility(1280);
            }
            Resources resources = activity.getResources();
            if (resources != null) {
                window.setStatusBarColor(resources.getColor(R$color.mc_trans_white, null));
            }
            m70842n1(actionBar, new ColorDrawable(0));
            actionBar.setBackgroundDrawable(new ColorDrawable(0));
        }
    }

    /* renamed from: z1 */
    public static void m70890z1(Context context, Dialog dialog) {
        if (context == null || dialog == null) {
            C11839m.m70687e("UIUtil", "setFullScreen context or dialog is null!");
            return;
        }
        Window window = dialog.getWindow();
        if (window == null) {
            C11839m.m70687e("UIUtil", "setFullScreen window is null!");
        } else {
            if (!m70753O0(context) || m70771U0()) {
                return;
            }
            C11839m.m70686d("UIUtil", "setFullScreen dialog");
            window.addFlags(1024);
        }
    }

    /* renamed from: z2 */
    public static void m70891z2(Context context, View view) {
        if (context == null || view == null) {
            C11839m.m70688i("UIUtil", "view or context is null");
        } else if (m70753O0(context)) {
            m70827j2(view, m70852q(context));
        } else {
            m70827j2(view, m70852q(context) + m70789a0(context));
        }
    }
}
