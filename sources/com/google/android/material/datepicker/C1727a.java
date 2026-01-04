package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.widget.TextView;
import com.google.android.material.R$styleable;
import p243e0.C9373h;
import p273f0.C9603h0;
import p276f3.C9649c;
import p356i3.C10427h;
import p356i3.C10432m;

/* renamed from: com.google.android.material.datepicker.a */
/* loaded from: classes.dex */
public final class C1727a {

    /* renamed from: a */
    public final Rect f7921a;

    /* renamed from: b */
    public final ColorStateList f7922b;

    /* renamed from: c */
    public final ColorStateList f7923c;

    /* renamed from: d */
    public final ColorStateList f7924d;

    /* renamed from: e */
    public final int f7925e;

    /* renamed from: f */
    public final C10432m f7926f;

    public C1727a(ColorStateList colorStateList, ColorStateList colorStateList2, ColorStateList colorStateList3, int i10, C10432m c10432m, Rect rect) {
        C9373h.m58742c(rect.left);
        C9373h.m58742c(rect.top);
        C9373h.m58742c(rect.right);
        C9373h.m58742c(rect.bottom);
        this.f7921a = rect;
        this.f7922b = colorStateList2;
        this.f7923c = colorStateList;
        this.f7924d = colorStateList3;
        this.f7925e = i10;
        this.f7926f = c10432m;
    }

    /* renamed from: a */
    public static C1727a m10277a(Context context, int i10) throws Resources.NotFoundException {
        C9373h.m58740a(i10 != 0, "Cannot create a CalendarItemStyle with a styleResId of 0");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i10, R$styleable.MaterialCalendarItem);
        Rect rect = new Rect(typedArrayObtainStyledAttributes.getDimensionPixelOffset(R$styleable.MaterialCalendarItem_android_insetLeft, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(R$styleable.MaterialCalendarItem_android_insetTop, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(R$styleable.MaterialCalendarItem_android_insetRight, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(R$styleable.MaterialCalendarItem_android_insetBottom, 0));
        ColorStateList colorStateListM60265a = C9649c.m60265a(context, typedArrayObtainStyledAttributes, R$styleable.MaterialCalendarItem_itemFillColor);
        ColorStateList colorStateListM60265a2 = C9649c.m60265a(context, typedArrayObtainStyledAttributes, R$styleable.MaterialCalendarItem_itemTextColor);
        ColorStateList colorStateListM60265a3 = C9649c.m60265a(context, typedArrayObtainStyledAttributes, R$styleable.MaterialCalendarItem_itemStrokeColor);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.MaterialCalendarItem_itemStrokeWidth, 0);
        C10432m c10432mM64093m = C10432m.m64046b(context, typedArrayObtainStyledAttributes.getResourceId(R$styleable.MaterialCalendarItem_itemShapeAppearance, 0), typedArrayObtainStyledAttributes.getResourceId(R$styleable.MaterialCalendarItem_itemShapeAppearanceOverlay, 0)).m64093m();
        typedArrayObtainStyledAttributes.recycle();
        return new C1727a(colorStateListM60265a, colorStateListM60265a2, colorStateListM60265a3, dimensionPixelSize, c10432mM64093m, rect);
    }

    /* renamed from: b */
    public int m10278b() {
        return this.f7921a.bottom;
    }

    /* renamed from: c */
    public int m10279c() {
        return this.f7921a.top;
    }

    /* renamed from: d */
    public void m10280d(TextView textView) {
        C10427h c10427h = new C10427h();
        C10427h c10427h2 = new C10427h();
        c10427h.setShapeAppearanceModel(this.f7926f);
        c10427h2.setShapeAppearanceModel(this.f7926f);
        c10427h.m64002b0(this.f7923c);
        c10427h.m64017k0(this.f7925e, this.f7924d);
        textView.setTextColor(this.f7922b);
        RippleDrawable rippleDrawable = new RippleDrawable(this.f7922b.withAlpha(30), c10427h, c10427h2);
        Rect rect = this.f7921a;
        C9603h0.m59910t0(textView, new InsetDrawable((Drawable) rippleDrawable, rect.left, rect.top, rect.right, rect.bottom));
    }
}
