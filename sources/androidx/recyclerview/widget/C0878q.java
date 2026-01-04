package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: androidx.recyclerview.widget.q */
/* loaded from: classes.dex */
public class C0878q {
    /* renamed from: a */
    public static int m5579a(RecyclerView.C0856z c0856z, AbstractC0875n abstractC0875n, View view, View view2, RecyclerView.AbstractC0846p abstractC0846p, boolean z10) {
        if (abstractC0846p.getChildCount() == 0 || c0856z.m5305b() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z10) {
            return Math.abs(abstractC0846p.getPosition(view) - abstractC0846p.getPosition(view2)) + 1;
        }
        return Math.min(abstractC0875n.mo5562o(), abstractC0875n.mo5551d(view2) - abstractC0875n.mo5554g(view));
    }

    /* renamed from: b */
    public static int m5580b(RecyclerView.C0856z c0856z, AbstractC0875n abstractC0875n, View view, View view2, RecyclerView.AbstractC0846p abstractC0846p, boolean z10, boolean z11) {
        if (abstractC0846p.getChildCount() == 0 || c0856z.m5305b() == 0 || view == null || view2 == null) {
            return 0;
        }
        int iMax = z11 ? Math.max(0, (c0856z.m5305b() - Math.max(abstractC0846p.getPosition(view), abstractC0846p.getPosition(view2))) - 1) : Math.max(0, Math.min(abstractC0846p.getPosition(view), abstractC0846p.getPosition(view2)));
        if (z10) {
            return Math.round((iMax * (Math.abs(abstractC0875n.mo5551d(view2) - abstractC0875n.mo5554g(view)) / (Math.abs(abstractC0846p.getPosition(view) - abstractC0846p.getPosition(view2)) + 1))) + (abstractC0875n.mo5561n() - abstractC0875n.mo5554g(view)));
        }
        return iMax;
    }

    /* renamed from: c */
    public static int m5581c(RecyclerView.C0856z c0856z, AbstractC0875n abstractC0875n, View view, View view2, RecyclerView.AbstractC0846p abstractC0846p, boolean z10) {
        if (abstractC0846p.getChildCount() == 0 || c0856z.m5305b() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z10) {
            return c0856z.m5305b();
        }
        return (int) (((abstractC0875n.mo5551d(view2) - abstractC0875n.mo5554g(view)) / (Math.abs(abstractC0846p.getPosition(view) - abstractC0846p.getPosition(view2)) + 1)) * c0856z.m5305b());
    }
}
