package androidx.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

/* loaded from: classes.dex */
public class Explode extends Visibility {

    /* renamed from: N */
    public static final TimeInterpolator f4734N = new DecelerateInterpolator();

    /* renamed from: O */
    public static final TimeInterpolator f4735O = new AccelerateInterpolator();

    /* renamed from: M */
    public int[] f4736M;

    public Explode() {
        this.f4736M = new int[2];
        mo5734f0(new C0933c());
    }

    /* renamed from: j0 */
    private void m5671j0(C0959t c0959t) {
        View view = c0959t.f4889b;
        view.getLocationOnScreen(this.f4736M);
        int[] iArr = this.f4736M;
        int i10 = iArr[0];
        int i11 = iArr[1];
        c0959t.f4888a.put("android:explode:screenBounds", new Rect(i10, i11, view.getWidth() + i10, view.getHeight() + i11));
    }

    /* renamed from: r0 */
    public static float m5672r0(float f10, float f11) {
        return (float) Math.sqrt((f10 * f10) + (f11 * f11));
    }

    /* renamed from: s0 */
    public static float m5673s0(View view, int i10, int i11) {
        return m5672r0(Math.max(i10, view.getWidth() - i10), Math.max(i11, view.getHeight() - i11));
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    /* renamed from: i */
    public void mo5618i(C0959t c0959t) {
        super.mo5618i(c0959t);
        m5671j0(c0959t);
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    /* renamed from: l */
    public void mo5621l(C0959t c0959t) {
        super.mo5621l(c0959t);
        m5671j0(c0959t);
    }

    @Override // androidx.transition.Visibility
    /* renamed from: m0 */
    public Animator mo5674m0(ViewGroup viewGroup, View view, C0959t c0959t, C0959t c0959t2) {
        if (c0959t2 == null) {
            return null;
        }
        Rect rect = (Rect) c0959t2.f4888a.get("android:explode:screenBounds");
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        m5676t0(viewGroup, rect, this.f4736M);
        int[] iArr = this.f4736M;
        return C0961v.m5841a(view, c0959t2, rect.left, rect.top, translationX + iArr[0], translationY + iArr[1], translationX, translationY, f4734N, this);
    }

    @Override // androidx.transition.Visibility
    /* renamed from: o0 */
    public Animator mo5675o0(ViewGroup viewGroup, View view, C0959t c0959t, C0959t c0959t2) {
        float f10;
        float f11;
        if (c0959t == null) {
            return null;
        }
        Rect rect = (Rect) c0959t.f4888a.get("android:explode:screenBounds");
        int i10 = rect.left;
        int i11 = rect.top;
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        int[] iArr = (int[]) c0959t.f4889b.getTag(R$id.transition_position);
        if (iArr != null) {
            f10 = (r7 - rect.left) + translationX;
            f11 = (r0 - rect.top) + translationY;
            rect.offsetTo(iArr[0], iArr[1]);
        } else {
            f10 = translationX;
            f11 = translationY;
        }
        m5676t0(viewGroup, rect, this.f4736M);
        int[] iArr2 = this.f4736M;
        return C0961v.m5841a(view, c0959t, i10, i11, translationX, translationY, f10 + iArr2[0], f11 + iArr2[1], f4735O, this);
    }

    /* renamed from: t0 */
    public final void m5676t0(View view, Rect rect, int[] iArr) {
        int iCenterY;
        int width;
        view.getLocationOnScreen(this.f4736M);
        int[] iArr2 = this.f4736M;
        int i10 = iArr2[0];
        int i11 = iArr2[1];
        Rect rectM5747t = m5747t();
        if (rectM5747t == null) {
            width = (view.getWidth() / 2) + i10 + Math.round(view.getTranslationX());
            iCenterY = (view.getHeight() / 2) + i11 + Math.round(view.getTranslationY());
        } else {
            int iCenterX = rectM5747t.centerX();
            iCenterY = rectM5747t.centerY();
            width = iCenterX;
        }
        float fCenterX = rect.centerX() - width;
        float fCenterY = rect.centerY() - iCenterY;
        if (fCenterX == 0.0f && fCenterY == 0.0f) {
            fCenterX = ((float) (Math.random() * 2.0d)) - 1.0f;
            fCenterY = ((float) (Math.random() * 2.0d)) - 1.0f;
        }
        float fM5672r0 = m5672r0(fCenterX, fCenterY);
        float fM5673s0 = m5673s0(view, width - i10, iCenterY - i11);
        iArr[0] = Math.round((fCenterX / fM5672r0) * fM5673s0);
        iArr[1] = Math.round(fM5673s0 * (fCenterY / fM5672r0));
    }

    public Explode(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4736M = new int[2];
        mo5734f0(new C0933c());
    }
}
