package p307g3;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import p356i3.C10427h;
import p356i3.C10432m;
import p356i3.InterfaceC10435p;

/* renamed from: g3.a */
/* loaded from: classes.dex */
public class C9875a extends Drawable implements InterfaceC10435p {

    /* renamed from: a */
    public b f48496a;

    @Override // android.graphics.drawable.Drawable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C9875a mutate() {
        this.f48496a = new b(this.f48496a);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        b bVar = this.f48496a;
        if (bVar.f48498b) {
            bVar.f48497a.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f48496a;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f48496a.f48497a.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f48496a.f48497a.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        boolean zOnStateChange = super.onStateChange(iArr);
        if (this.f48496a.f48497a.setState(iArr)) {
            zOnStateChange = true;
        }
        boolean zM61326e = C9876b.m61326e(iArr);
        b bVar = this.f48496a;
        if (bVar.f48498b == zM61326e) {
            return zOnStateChange;
        }
        bVar.f48498b = zM61326e;
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        this.f48496a.f48497a.setAlpha(i10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f48496a.f48497a.setColorFilter(colorFilter);
    }

    @Override // p356i3.InterfaceC10435p
    public void setShapeAppearanceModel(C10432m c10432m) {
        this.f48496a.f48497a.setShapeAppearanceModel(c10432m);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i10) {
        this.f48496a.f48497a.setTint(i10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f48496a.f48497a.setTintList(colorStateList);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        this.f48496a.f48497a.setTintMode(mode);
    }

    public C9875a(C10432m c10432m) {
        this(new b(new C10427h(c10432m)));
    }

    /* renamed from: g3.a$b */
    public static final class b extends Drawable.ConstantState {

        /* renamed from: a */
        public C10427h f48497a;

        /* renamed from: b */
        public boolean f48498b;

        public b(C10427h c10427h) {
            this.f48497a = c10427h;
            this.f48498b = false;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public C9875a newDrawable() {
            return new C9875a(new b(this));
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        public b(b bVar) {
            this.f48497a = (C10427h) bVar.f48497a.getConstantState().newDrawable();
            this.f48498b = bVar.f48498b;
        }
    }

    public C9875a(b bVar) {
        this.f48496a = bVar;
    }
}
