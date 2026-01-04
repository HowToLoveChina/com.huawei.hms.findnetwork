package androidx.core.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.icu.text.DecimalFormatSymbols;
import android.text.Editable;
import android.text.PrecomputedText;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.huawei.hms.framework.network.restclient.dnkeeper.InterfaceC5483d;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import p212d0.C8971c;
import p243e0.C9373h;

/* renamed from: androidx.core.widget.j */
/* loaded from: classes.dex */
public final class C0669j {

    /* renamed from: androidx.core.widget.j$a */
    public static class a {
        /* renamed from: a */
        public static boolean m4084a(TextView textView) {
            return textView.getIncludeFontPadding();
        }

        /* renamed from: b */
        public static int m4085b(TextView textView) {
            return textView.getMaxLines();
        }

        /* renamed from: c */
        public static int m4086c(TextView textView) {
            return textView.getMinLines();
        }
    }

    /* renamed from: androidx.core.widget.j$b */
    public static class b {
        /* renamed from: a */
        public static Drawable[] m4087a(TextView textView) {
            return textView.getCompoundDrawablesRelative();
        }

        /* renamed from: b */
        public static int m4088b(View view) {
            return view.getLayoutDirection();
        }

        /* renamed from: c */
        public static int m4089c(View view) {
            return view.getTextDirection();
        }

        /* renamed from: d */
        public static Locale m4090d(TextView textView) {
            return textView.getTextLocale();
        }

        /* renamed from: e */
        public static void m4091e(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
            textView.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        }

        /* renamed from: f */
        public static void m4092f(TextView textView, int i10, int i11, int i12, int i13) {
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(i10, i11, i12, i13);
        }

        /* renamed from: g */
        public static void m4093g(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        }

        /* renamed from: h */
        public static void m4094h(View view, int i10) {
            view.setTextDirection(i10);
        }
    }

    /* renamed from: androidx.core.widget.j$c */
    public static class c {
        /* renamed from: a */
        public static int m4095a(TextView textView) {
            return textView.getBreakStrategy();
        }

        /* renamed from: b */
        public static ColorStateList m4096b(TextView textView) {
            return textView.getCompoundDrawableTintList();
        }

        /* renamed from: c */
        public static PorterDuff.Mode m4097c(TextView textView) {
            return textView.getCompoundDrawableTintMode();
        }

        /* renamed from: d */
        public static int m4098d(TextView textView) {
            return textView.getHyphenationFrequency();
        }

        /* renamed from: e */
        public static void m4099e(TextView textView, int i10) {
            textView.setBreakStrategy(i10);
        }

        /* renamed from: f */
        public static void m4100f(TextView textView, ColorStateList colorStateList) {
            textView.setCompoundDrawableTintList(colorStateList);
        }

        /* renamed from: g */
        public static void m4101g(TextView textView, PorterDuff.Mode mode) {
            textView.setCompoundDrawableTintMode(mode);
        }

        /* renamed from: h */
        public static void m4102h(TextView textView, int i10) {
            textView.setHyphenationFrequency(i10);
        }
    }

    /* renamed from: androidx.core.widget.j$d */
    public static class d {
        /* renamed from: a */
        public static String[] m4103a(DecimalFormatSymbols decimalFormatSymbols) {
            return decimalFormatSymbols.getDigitStrings();
        }

        /* renamed from: b */
        public static PrecomputedText.Params m4104b(TextView textView) {
            return textView.getTextMetricsParams();
        }

        /* renamed from: c */
        public static void m4105c(TextView textView, int i10) {
            textView.setFirstBaselineToTopHeight(i10);
        }
    }

    /* renamed from: androidx.core.widget.j$e */
    public static class e implements ActionMode.Callback {

        /* renamed from: a */
        public final ActionMode.Callback f3518a;

        /* renamed from: b */
        public final TextView f3519b;

        /* renamed from: c */
        public Class<?> f3520c;

        /* renamed from: d */
        public Method f3521d;

        /* renamed from: e */
        public boolean f3522e;

        /* renamed from: f */
        public boolean f3523f;

        /* renamed from: a */
        public final Intent m4106a() {
            return new Intent().setAction("android.intent.action.PROCESS_TEXT").setType(InterfaceC5483d.f25083i);
        }

        /* renamed from: b */
        public final Intent m4107b(ResolveInfo resolveInfo, TextView textView) {
            Intent intentPutExtra = m4106a().putExtra("android.intent.extra.PROCESS_TEXT_READONLY", !m4110e(textView));
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            return intentPutExtra.setClassName(activityInfo.packageName, activityInfo.name);
        }

        /* renamed from: c */
        public final List<ResolveInfo> m4108c(Context context, PackageManager packageManager) {
            ArrayList arrayList = new ArrayList();
            if (!(context instanceof Activity)) {
                return arrayList;
            }
            for (ResolveInfo resolveInfo : packageManager.queryIntentActivities(m4106a(), 0)) {
                if (m4111f(resolveInfo, context)) {
                    arrayList.add(resolveInfo);
                }
            }
            return arrayList;
        }

        /* renamed from: d */
        public ActionMode.Callback m4109d() {
            return this.f3518a;
        }

        /* renamed from: e */
        public final boolean m4110e(TextView textView) {
            return (textView instanceof Editable) && textView.onCheckIsTextEditor() && textView.isEnabled();
        }

        /* renamed from: f */
        public final boolean m4111f(ResolveInfo resolveInfo, Context context) {
            if (context.getPackageName().equals(resolveInfo.activityInfo.packageName)) {
                return true;
            }
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            if (!activityInfo.exported) {
                return false;
            }
            String str = activityInfo.permission;
            return str == null || context.checkSelfPermission(str) == 0;
        }

        /* renamed from: g */
        public final void m4112g(Menu menu) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
            Context context = this.f3519b.getContext();
            PackageManager packageManager = context.getPackageManager();
            if (!this.f3523f) {
                this.f3523f = true;
                try {
                    Class<?> cls = Class.forName("com.android.internal.view.menu.MenuBuilder");
                    this.f3520c = cls;
                    this.f3521d = cls.getDeclaredMethod("removeItemAt", Integer.TYPE);
                    this.f3522e = true;
                } catch (ClassNotFoundException | NoSuchMethodException unused) {
                    this.f3520c = null;
                    this.f3521d = null;
                    this.f3522e = false;
                }
            }
            try {
                Method declaredMethod = (this.f3522e && this.f3520c.isInstance(menu)) ? this.f3521d : menu.getClass().getDeclaredMethod("removeItemAt", Integer.TYPE);
                for (int size = menu.size() - 1; size >= 0; size--) {
                    MenuItem item = menu.getItem(size);
                    if (item.getIntent() != null && "android.intent.action.PROCESS_TEXT".equals(item.getIntent().getAction())) {
                        declaredMethod.invoke(menu, Integer.valueOf(size));
                    }
                }
                List<ResolveInfo> listM4108c = m4108c(context, packageManager);
                for (int i10 = 0; i10 < listM4108c.size(); i10++) {
                    ResolveInfo resolveInfo = listM4108c.get(i10);
                    menu.add(0, 0, i10 + 100, resolveInfo.loadLabel(packageManager)).setIntent(m4107b(resolveInfo, this.f3519b)).setShowAsAction(1);
                }
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
            }
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return this.f3518a.onActionItemClicked(actionMode, menuItem);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            return this.f3518a.onCreateActionMode(actionMode, menu);
        }

        @Override // android.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode actionMode) {
            this.f3518a.onDestroyActionMode(actionMode);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
            m4112g(menu);
            return this.f3518a.onPrepareActionMode(actionMode, menu);
        }
    }

    /* renamed from: a */
    public static Drawable[] m4067a(TextView textView) {
        return b.m4087a(textView);
    }

    /* renamed from: b */
    public static int m4068b(TextView textView) {
        return textView.getPaddingTop() - textView.getPaint().getFontMetricsInt().top;
    }

    /* renamed from: c */
    public static int m4069c(TextView textView) {
        return textView.getPaddingBottom() + textView.getPaint().getFontMetricsInt().bottom;
    }

    /* renamed from: d */
    public static int m4070d(TextView textView) {
        return a.m4085b(textView);
    }

    /* renamed from: e */
    public static int m4071e(TextDirectionHeuristic textDirectionHeuristic) {
        TextDirectionHeuristic textDirectionHeuristic2;
        TextDirectionHeuristic textDirectionHeuristic3 = TextDirectionHeuristics.FIRSTSTRONG_RTL;
        if (textDirectionHeuristic == textDirectionHeuristic3 || textDirectionHeuristic == (textDirectionHeuristic2 = TextDirectionHeuristics.FIRSTSTRONG_LTR)) {
            return 1;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.ANYRTL_LTR) {
            return 2;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.LTR) {
            return 3;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.RTL) {
            return 4;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.LOCALE) {
            return 5;
        }
        if (textDirectionHeuristic == textDirectionHeuristic2) {
            return 6;
        }
        return textDirectionHeuristic == textDirectionHeuristic3 ? 7 : 1;
    }

    /* renamed from: f */
    public static C8971c.a m4072f(TextView textView) {
        return new C8971c.a(d.m4104b(textView));
    }

    /* renamed from: g */
    public static void m4073g(TextView textView, ColorStateList colorStateList) {
        C9373h.m58745f(textView);
        c.m4100f(textView, colorStateList);
    }

    /* renamed from: h */
    public static void m4074h(TextView textView, PorterDuff.Mode mode) {
        C9373h.m58745f(textView);
        c.m4101g(textView, mode);
    }

    /* renamed from: i */
    public static void m4075i(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        b.m4091e(textView, drawable, drawable2, drawable3, drawable4);
    }

    /* renamed from: j */
    public static void m4076j(TextView textView, int i10) {
        C9373h.m58742c(i10);
        d.m4105c(textView, i10);
    }

    /* renamed from: k */
    public static void m4077k(TextView textView, int i10) {
        C9373h.m58742c(i10);
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        int i11 = a.m4084a(textView) ? fontMetricsInt.bottom : fontMetricsInt.descent;
        if (i10 > Math.abs(i11)) {
            textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), textView.getPaddingRight(), i10 - i11);
        }
    }

    /* renamed from: l */
    public static void m4078l(TextView textView, int i10) {
        C9373h.m58742c(i10);
        if (i10 != textView.getPaint().getFontMetricsInt(null)) {
            textView.setLineSpacing(i10 - r0, 1.0f);
        }
    }

    /* renamed from: m */
    public static void m4079m(TextView textView, C8971c c8971c) {
        textView.setText(c8971c.m56771a());
    }

    /* renamed from: n */
    public static void m4080n(TextView textView, int i10) {
        textView.setTextAppearance(i10);
    }

    /* renamed from: o */
    public static void m4081o(TextView textView, C8971c.a aVar) {
        b.m4094h(textView, m4071e(aVar.m56775d()));
        textView.getPaint().set(aVar.m56776e());
        c.m4099e(textView, aVar.m56773b());
        c.m4102h(textView, aVar.m56774c());
    }

    /* renamed from: p */
    public static ActionMode.Callback m4082p(ActionMode.Callback callback) {
        return callback instanceof e ? ((e) callback).m4109d() : callback;
    }

    /* renamed from: q */
    public static ActionMode.Callback m4083q(TextView textView, ActionMode.Callback callback) {
        return callback;
    }
}
