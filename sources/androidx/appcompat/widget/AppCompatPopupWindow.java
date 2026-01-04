package androidx.appcompat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;
import androidx.appcompat.R$styleable;
import androidx.core.widget.C0668i;

/* loaded from: classes.dex */
class AppCompatPopupWindow extends PopupWindow {

    /* renamed from: b */
    public static final boolean f1909b = false;

    /* renamed from: a */
    public boolean f1910a;

    public AppCompatPopupWindow(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        m2631a(context, attributeSet, i10, 0);
    }

    /* renamed from: a */
    public final void m2631a(Context context, AttributeSet attributeSet, int i10, int i11) {
        C0523e0 c0523e0M2946v = C0523e0.m2946v(context, attributeSet, R$styleable.PopupWindow, i10, i11);
        int i12 = R$styleable.PopupWindow_overlapAnchor;
        if (c0523e0M2946v.m2965s(i12)) {
            m2632b(c0523e0M2946v.m2947a(i12, false));
        }
        setBackgroundDrawable(c0523e0M2946v.m2953g(R$styleable.PopupWindow_android_popupBackground));
        c0523e0M2946v.m2966w();
    }

    /* renamed from: b */
    public final void m2632b(boolean z10) {
        if (f1909b) {
            this.f1910a = z10;
        } else {
            C0668i.m4059a(this, z10);
        }
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i10, int i11) {
        if (f1909b && this.f1910a) {
            i11 -= view.getHeight();
        }
        super.showAsDropDown(view, i10, i11);
    }

    @Override // android.widget.PopupWindow
    public void update(View view, int i10, int i11, int i12, int i13) {
        if (f1909b && this.f1910a) {
            i11 -= view.getHeight();
        }
        super.update(view, i10, i11, i12, i13);
    }

    public AppCompatPopupWindow(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        m2631a(context, attributeSet, i10, i11);
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i10, int i11, int i12) {
        if (f1909b && this.f1910a) {
            i11 -= view.getHeight();
        }
        super.showAsDropDown(view, i10, i11, i12);
    }
}
