package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.FrameLayout;
import p273f0.C9603h0;

/* loaded from: classes.dex */
public class ContentFrameLayout extends FrameLayout {

    /* renamed from: a */
    public TypedValue f1961a;

    /* renamed from: b */
    public TypedValue f1962b;

    /* renamed from: c */
    public TypedValue f1963c;

    /* renamed from: d */
    public TypedValue f1964d;

    /* renamed from: e */
    public TypedValue f1965e;

    /* renamed from: f */
    public TypedValue f1966f;

    /* renamed from: g */
    public final Rect f1967g;

    /* renamed from: h */
    public InterfaceC0460a f1968h;

    /* renamed from: androidx.appcompat.widget.ContentFrameLayout$a */
    public interface InterfaceC0460a {
        /* renamed from: a */
        void mo2155a();

        void onDetachedFromWindow();
    }

    public ContentFrameLayout(Context context) {
        this(context, null);
    }

    /* renamed from: a */
    public void m2678a(int i10, int i11, int i12, int i13) {
        this.f1967g.set(i10, i11, i12, i13);
        if (C9603h0.m59864T(this)) {
            requestLayout();
        }
    }

    public TypedValue getFixedHeightMajor() {
        if (this.f1965e == null) {
            this.f1965e = new TypedValue();
        }
        return this.f1965e;
    }

    public TypedValue getFixedHeightMinor() {
        if (this.f1966f == null) {
            this.f1966f = new TypedValue();
        }
        return this.f1966f;
    }

    public TypedValue getFixedWidthMajor() {
        if (this.f1963c == null) {
            this.f1963c = new TypedValue();
        }
        return this.f1963c;
    }

    public TypedValue getFixedWidthMinor() {
        if (this.f1964d == null) {
            this.f1964d = new TypedValue();
        }
        return this.f1964d;
    }

    public TypedValue getMinWidthMajor() {
        if (this.f1961a == null) {
            this.f1961a = new TypedValue();
        }
        return this.f1961a;
    }

    public TypedValue getMinWidthMinor() {
        if (this.f1962b == null) {
            this.f1962b = new TypedValue();
        }
        return this.f1962b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        InterfaceC0460a interfaceC0460a = this.f1968h;
        if (interfaceC0460a != null) {
            interfaceC0460a.mo2155a();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        InterfaceC0460a interfaceC0460a = this.f1968h;
        if (interfaceC0460a != null) {
            interfaceC0460a.onDetachedFromWindow();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00db  */
    @Override // android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onMeasure(int r14, int r15) {
        /*
            Method dump skipped, instructions count: 226
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ContentFrameLayout.onMeasure(int, int):void");
    }

    public void setAttachListener(InterfaceC0460a interfaceC0460a) {
        this.f1968h = interfaceC0460a;
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f1967g = new Rect();
    }
}
