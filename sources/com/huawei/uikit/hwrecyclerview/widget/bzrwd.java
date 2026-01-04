package com.huawei.uikit.hwrecyclerview.widget;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.util.Log;

/* loaded from: classes4.dex */
class bzrwd extends BitmapDrawable {

    /* renamed from: g */
    private static final String f43975g = "AnimDrawable";

    /* renamed from: h */
    private static final float f43976h = 0.85f;

    /* renamed from: a */
    private int f43977a;

    /* renamed from: b */
    private int f43978b;

    /* renamed from: c */
    private int f43979c;

    /* renamed from: d */
    private int f43980d;

    /* renamed from: e */
    private float f43981e;

    /* renamed from: f */
    private float f43982f;

    public bzrwd(Resources resources, Bitmap bitmap, int i10) {
        super(resources, bitmap);
        this.f43977a = 0;
        this.f43978b = 0;
        this.f43981e = 1.0f;
        this.f43982f = 1.0f;
        if (i10 != 0) {
            this.f43981e = f43976h;
            this.f43982f = f43976h;
        }
    }

    /* renamed from: a */
    public void m55419a(int i10, int i11) {
        this.f43979c = i10;
        this.f43980d = i11;
    }

    /* renamed from: b */
    public void m55420b(int i10, int i11) {
        this.f43977a = i10;
        this.f43978b = i11;
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (canvas == null) {
            Log.e(f43975g, "draw: canvas is null");
            return;
        }
        canvas.save();
        canvas.clipRect(this.f43979c, this.f43980d, canvas.getWidth(), canvas.getHeight());
        canvas.translate(this.f43977a + this.f43979c, this.f43978b + this.f43980d);
        canvas.scale(this.f43981e, this.f43982f);
        super.draw(canvas);
        canvas.restore();
    }

    /* renamed from: a */
    public void m55418a(float f10, float f11) {
        this.f43981e = f10;
        this.f43982f = f11;
    }
}
