package com.google.android.material.dialog;

import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.widget.ListAdapter;
import androidx.appcompat.app.AlertDialog;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import p273f0.C9603h0;
import p276f3.C9648b;
import p303g.C9816d;
import p356i3.C10427h;
import p416k3.C10981a;
import p760x2.C13689a;
import p796y2.C13907b;
import p796y2.ViewOnTouchListenerC13906a;

/* loaded from: classes.dex */
public class MaterialAlertDialogBuilder extends AlertDialog.Builder {

    /* renamed from: e */
    public static final int f8045e = R$attr.alertDialogStyle;

    /* renamed from: f */
    public static final int f8046f = R$style.MaterialAlertDialog_MaterialComponents;

    /* renamed from: g */
    public static final int f8047g = R$attr.materialAlertDialogTheme;

    /* renamed from: c */
    public Drawable f8048c;

    /* renamed from: d */
    public final Rect f8049d;

    public MaterialAlertDialogBuilder(Context context) {
        this(context, 0);
    }

    /* renamed from: i */
    public static Context m10395i(Context context) {
        int iM10396j = m10396j(context);
        Context contextM66348c = C10981a.m66348c(context, null, f8045e, f8046f);
        return iM10396j == 0 ? contextM66348c : new C9816d(contextM66348c, iM10396j);
    }

    /* renamed from: j */
    public static int m10396j(Context context) {
        TypedValue typedValueM60260a = C9648b.m60260a(context, f8047g);
        if (typedValueM60260a == null) {
            return 0;
        }
        return typedValueM60260a.data;
    }

    /* renamed from: k */
    public static int m10397k(Context context, int i10) {
        return i10 == 0 ? m10396j(context) : i10;
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    /* renamed from: a */
    public AlertDialog mo2027a() {
        AlertDialog alertDialogMo2027a = super.mo2027a();
        Window window = alertDialogMo2027a.getWindow();
        View decorView = window.getDecorView();
        Drawable drawable = this.f8048c;
        if (drawable instanceof C10427h) {
            ((C10427h) drawable).m64001a0(C9603h0.m59913v(decorView));
        }
        window.setBackgroundDrawable(C13907b.m83328b(this.f8048c, this.f8049d));
        decorView.setOnTouchListener(new ViewOnTouchListenerC13906a(alertDialogMo2027a, this.f8049d));
        return alertDialogMo2027a;
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public MaterialAlertDialogBuilder mo2029c(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.mo2029c(listAdapter, onClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public MaterialAlertDialogBuilder mo2030d(View view) {
        return (MaterialAlertDialogBuilder) super.mo2030d(view);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public MaterialAlertDialogBuilder mo2031e(Drawable drawable) {
        return (MaterialAlertDialogBuilder) super.mo2031e(drawable);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public MaterialAlertDialogBuilder mo2032f(DialogInterface.OnKeyListener onKeyListener) {
        return (MaterialAlertDialogBuilder) super.mo2032f(onKeyListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public MaterialAlertDialogBuilder mo2033g(ListAdapter listAdapter, int i10, DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.mo2033g(listAdapter, i10, onClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public MaterialAlertDialogBuilder mo2034h(CharSequence charSequence) {
        return (MaterialAlertDialogBuilder) super.mo2034h(charSequence);
    }

    public MaterialAlertDialogBuilder(Context context, int i10) {
        super(m10395i(context), m10397k(context, i10));
        Context contextM2028b = m2028b();
        Resources.Theme theme = contextM2028b.getTheme();
        int i11 = f8045e;
        int i12 = f8046f;
        this.f8049d = C13907b.m83327a(contextM2028b, i11, i12);
        int iM82289c = C13689a.m82289c(contextM2028b, R$attr.colorSurface, getClass().getCanonicalName());
        C10427h c10427h = new C10427h(contextM2028b, null, i11, i12);
        c10427h.m63992Q(contextM2028b);
        c10427h.m64002b0(ColorStateList.valueOf(iM82289c));
        TypedValue typedValue = new TypedValue();
        theme.resolveAttribute(R.attr.dialogCornerRadius, typedValue, true);
        float dimension = typedValue.getDimension(m2028b().getResources().getDisplayMetrics());
        if (typedValue.type == 5 && dimension >= 0.0f) {
            c10427h.m63999Y(dimension);
        }
        this.f8048c = c10427h;
    }
}
