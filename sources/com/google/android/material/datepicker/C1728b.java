package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Paint;
import com.google.android.material.R$attr;
import com.google.android.material.R$styleable;
import p276f3.C9648b;
import p276f3.C9649c;

/* renamed from: com.google.android.material.datepicker.b */
/* loaded from: classes.dex */
public final class C1728b {

    /* renamed from: a */
    public final C1727a f7927a;

    /* renamed from: b */
    public final C1727a f7928b;

    /* renamed from: c */
    public final C1727a f7929c;

    /* renamed from: d */
    public final C1727a f7930d;

    /* renamed from: e */
    public final C1727a f7931e;

    /* renamed from: f */
    public final C1727a f7932f;

    /* renamed from: g */
    public final C1727a f7933g;

    /* renamed from: h */
    public final Paint f7934h;

    public C1728b(Context context) throws Resources.NotFoundException {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(C9648b.m60263d(context, R$attr.materialCalendarStyle, C1732f.class.getCanonicalName()), R$styleable.MaterialCalendar);
        this.f7927a = C1727a.m10277a(context, typedArrayObtainStyledAttributes.getResourceId(R$styleable.MaterialCalendar_dayStyle, 0));
        this.f7933g = C1727a.m10277a(context, typedArrayObtainStyledAttributes.getResourceId(R$styleable.MaterialCalendar_dayInvalidStyle, 0));
        this.f7928b = C1727a.m10277a(context, typedArrayObtainStyledAttributes.getResourceId(R$styleable.MaterialCalendar_daySelectedStyle, 0));
        this.f7929c = C1727a.m10277a(context, typedArrayObtainStyledAttributes.getResourceId(R$styleable.MaterialCalendar_dayTodayStyle, 0));
        ColorStateList colorStateListM60265a = C9649c.m60265a(context, typedArrayObtainStyledAttributes, R$styleable.MaterialCalendar_rangeFillColor);
        this.f7930d = C1727a.m10277a(context, typedArrayObtainStyledAttributes.getResourceId(R$styleable.MaterialCalendar_yearStyle, 0));
        this.f7931e = C1727a.m10277a(context, typedArrayObtainStyledAttributes.getResourceId(R$styleable.MaterialCalendar_yearSelectedStyle, 0));
        this.f7932f = C1727a.m10277a(context, typedArrayObtainStyledAttributes.getResourceId(R$styleable.MaterialCalendar_yearTodayStyle, 0));
        Paint paint = new Paint();
        this.f7934h = paint;
        paint.setColor(colorStateListM60265a.getDefaultColor());
        typedArrayObtainStyledAttributes.recycle();
    }
}
