package androidx.transition;

import android.graphics.Rect;
import android.view.ViewGroup;

/* renamed from: androidx.transition.c */
/* loaded from: classes.dex */
public class C0933c extends AbstractC0946i0 {

    /* renamed from: b */
    public float f4840b = 3.0f;

    /* renamed from: h */
    public static float m5799h(float f10, float f11, float f12, float f13) {
        float f14 = f12 - f10;
        float f15 = f13 - f11;
        return (float) Math.sqrt((f14 * f14) + (f15 * f15));
    }

    @Override // androidx.transition.AbstractC0957r
    /* renamed from: c */
    public long mo5800c(ViewGroup viewGroup, Transition transition, C0959t c0959t, C0959t c0959t2) {
        int i10;
        int iRound;
        int iCenterX;
        if (c0959t == null && c0959t2 == null) {
            return 0L;
        }
        if (c0959t2 == null || m5820e(c0959t) == 0) {
            i10 = -1;
        } else {
            c0959t = c0959t2;
            i10 = 1;
        }
        int iM5821f = m5821f(c0959t);
        int iM5822g = m5822g(c0959t);
        Rect rectM5747t = transition.m5747t();
        if (rectM5747t != null) {
            iCenterX = rectM5747t.centerX();
            iRound = rectM5747t.centerY();
        } else {
            viewGroup.getLocationOnScreen(new int[2]);
            int iRound2 = Math.round(r5[0] + (viewGroup.getWidth() / 2) + viewGroup.getTranslationX());
            iRound = Math.round(r5[1] + (viewGroup.getHeight() / 2) + viewGroup.getTranslationY());
            iCenterX = iRound2;
        }
        float fM5799h = m5799h(iM5821f, iM5822g, iCenterX, iRound) / m5799h(0.0f, 0.0f, viewGroup.getWidth(), viewGroup.getHeight());
        long jM5746s = transition.m5746s();
        if (jM5746s < 0) {
            jM5746s = 300;
        }
        return Math.round(((jM5746s * i10) / this.f4840b) * fM5799h);
    }
}
