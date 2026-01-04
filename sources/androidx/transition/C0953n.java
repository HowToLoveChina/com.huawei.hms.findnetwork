package androidx.transition;

import android.graphics.Rect;
import android.view.ViewGroup;

/* renamed from: androidx.transition.n */
/* loaded from: classes.dex */
public class C0953n extends AbstractC0946i0 {

    /* renamed from: b */
    public float f4862b = 3.0f;

    /* renamed from: c */
    public int f4863c = 80;

    @Override // androidx.transition.AbstractC0957r
    /* renamed from: c */
    public long mo5800c(ViewGroup viewGroup, Transition transition, C0959t c0959t, C0959t c0959t2) {
        int i10;
        int iCenterX;
        int iCenterY;
        C0959t c0959t3 = c0959t;
        if (c0959t3 == null && c0959t2 == null) {
            return 0L;
        }
        Rect rectM5747t = transition.m5747t();
        if (c0959t2 == null || m5820e(c0959t3) == 0) {
            i10 = -1;
        } else {
            c0959t3 = c0959t2;
            i10 = 1;
        }
        int iM5821f = m5821f(c0959t3);
        int iM5822g = m5822g(c0959t3);
        int[] iArr = new int[2];
        viewGroup.getLocationOnScreen(iArr);
        int iRound = iArr[0] + Math.round(viewGroup.getTranslationX());
        int iRound2 = iArr[1] + Math.round(viewGroup.getTranslationY());
        int width = iRound + viewGroup.getWidth();
        int height = iRound2 + viewGroup.getHeight();
        if (rectM5747t != null) {
            iCenterX = rectM5747t.centerX();
            iCenterY = rectM5747t.centerY();
        } else {
            iCenterX = (iRound + width) / 2;
            iCenterY = (iRound2 + height) / 2;
        }
        float fM5829h = m5829h(viewGroup, iM5821f, iM5822g, iCenterX, iCenterY, iRound, iRound2, width, height) / m5830i(viewGroup);
        long jM5746s = transition.m5746s();
        if (jM5746s < 0) {
            jM5746s = 300;
        }
        return Math.round(((jM5746s * i10) / this.f4862b) * fM5829h);
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0010  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0012  */
    /* renamed from: h */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int m5829h(android.view.View r5, int r6, int r7, int r8, int r9, int r10, int r11, int r12, int r13) {
        /*
            r4 = this;
            int r4 = r4.f4863c
            r0 = 8388611(0x800003, float:1.1754948E-38)
            r1 = 1
            r2 = 3
            r3 = 5
            if (r4 != r0) goto L14
            int r4 = p273f0.C9603h0.m59832A(r5)
            if (r4 != r1) goto L12
        L10:
            r4 = r3
            goto L20
        L12:
            r4 = r2
            goto L20
        L14:
            r0 = 8388613(0x800005, float:1.175495E-38)
            if (r4 != r0) goto L20
            int r4 = p273f0.C9603h0.m59832A(r5)
            if (r4 != r1) goto L10
            goto L12
        L20:
            if (r4 == r2) goto L46
            if (r4 == r3) goto L3e
            r5 = 48
            if (r4 == r5) goto L36
            r5 = 80
            if (r4 == r5) goto L2e
            r4 = 0
            goto L4d
        L2e:
            int r7 = r7 - r11
            int r8 = r8 - r6
            int r4 = java.lang.Math.abs(r8)
            int r4 = r4 + r7
            goto L4d
        L36:
            int r13 = r13 - r7
            int r8 = r8 - r6
            int r4 = java.lang.Math.abs(r8)
            int r4 = r4 + r13
            goto L4d
        L3e:
            int r6 = r6 - r10
            int r9 = r9 - r7
            int r4 = java.lang.Math.abs(r9)
            int r4 = r4 + r6
            goto L4d
        L46:
            int r12 = r12 - r6
            int r9 = r9 - r7
            int r4 = java.lang.Math.abs(r9)
            int r4 = r4 + r12
        L4d:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.C0953n.m5829h(android.view.View, int, int, int, int, int, int, int, int):int");
    }

    /* renamed from: i */
    public final int m5830i(ViewGroup viewGroup) {
        int i10 = this.f4863c;
        return (i10 == 3 || i10 == 5 || i10 == 8388611 || i10 == 8388613) ? viewGroup.getWidth() : viewGroup.getHeight();
    }

    /* renamed from: j */
    public void m5831j(int i10) {
        this.f4863c = i10;
    }
}
