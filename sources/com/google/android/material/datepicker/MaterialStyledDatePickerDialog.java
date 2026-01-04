package com.google.android.material.datepicker;

import android.R;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import p276f3.C9648b;
import p356i3.C10427h;
import p796y2.C13907b;
import p796y2.ViewOnTouchListenerC13906a;

/* loaded from: classes.dex */
public class MaterialStyledDatePickerDialog extends DatePickerDialog {

    /* renamed from: c */
    public static final int f7894c = R$style.MaterialAlertDialog_MaterialComponents_Picker_Date_Spinner;

    /* renamed from: a */
    public final Drawable f7895a;

    /* renamed from: b */
    public final Rect f7896b;

    public MaterialStyledDatePickerDialog(Context context) {
        this(context, 0);
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setBackgroundDrawable(this.f7895a);
        getWindow().getDecorView().setOnTouchListener(new ViewOnTouchListenerC13906a(this, this.f7896b));
    }

    public MaterialStyledDatePickerDialog(Context context, int i10) {
        this(context, i10, null, -1, -1, -1);
    }

    public MaterialStyledDatePickerDialog(Context context, int i10, DatePickerDialog.OnDateSetListener onDateSetListener, int i11, int i12, int i13) {
        super(context, i10, onDateSetListener, i11, i12, i13);
        Context context2 = getContext();
        int iM60263d = C9648b.m60263d(getContext(), R$attr.colorSurface, getClass().getCanonicalName());
        int i14 = f7894c;
        C10427h c10427h = new C10427h(context2, null, R.attr.datePickerStyle, i14);
        c10427h.m64002b0(ColorStateList.valueOf(iM60263d));
        Rect rectM83327a = C13907b.m83327a(context2, R.attr.datePickerStyle, i14);
        this.f7896b = rectM83327a;
        this.f7895a = C13907b.m83328b(c10427h, rectM83327a);
    }
}
