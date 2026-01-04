package com.huawei.uikit.hwrecyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.AbstractC0875n;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.uikit.hwrecyclerview.widget.HwLinearLayoutManagerEx;

/* loaded from: classes4.dex */
class akxao {
    private akxao() {
    }

    /* renamed from: a */
    public static int m55348a(RecyclerView.C0856z c0856z, AbstractC0875n abstractC0875n, HwLinearLayoutManagerEx.aauaf aauafVar, RecyclerView.AbstractC0846p abstractC0846p, boolean z10) {
        View view;
        if (c0856z == null || c0856z.m5305b() == 0 || abstractC0846p == null || abstractC0846p.getChildCount() == 0 || abstractC0875n == null || aauafVar == null || (view = aauafVar.f43674a) == null || aauafVar.f43675b == null) {
            return 0;
        }
        int iMax = z10 ? Math.max(0, (c0856z.m5305b() - Math.max(abstractC0846p.getPosition(aauafVar.f43674a), abstractC0846p.getPosition(aauafVar.f43675b))) - 1) : Math.max(0, Math.min(abstractC0846p.getPosition(view), abstractC0846p.getPosition(aauafVar.f43675b)));
        return !aauafVar.f43676c ? iMax : Math.round((iMax * (Math.abs(abstractC0875n.mo5551d(aauafVar.f43675b) - abstractC0875n.mo5554g(aauafVar.f43674a)) / (Math.abs(abstractC0846p.getPosition(aauafVar.f43674a) - abstractC0846p.getPosition(aauafVar.f43675b)) + 1))) + (abstractC0875n.mo5561n() - abstractC0875n.mo5554g(aauafVar.f43674a)));
    }

    /* renamed from: b */
    public static int m55349b(RecyclerView.C0856z c0856z, AbstractC0875n abstractC0875n, HwLinearLayoutManagerEx.aauaf aauafVar, RecyclerView.AbstractC0846p abstractC0846p) {
        View view;
        if (c0856z == null || c0856z.m5305b() == 0 || abstractC0846p == null || abstractC0846p.getChildCount() == 0 || abstractC0875n == null || aauafVar == null || aauafVar.f43674a == null || (view = aauafVar.f43675b) == null) {
            return 0;
        }
        return !aauafVar.f43676c ? c0856z.m5305b() : (int) (((abstractC0875n.mo5551d(view) - abstractC0875n.mo5554g(aauafVar.f43674a)) / (Math.abs(abstractC0846p.getPosition(aauafVar.f43674a) - abstractC0846p.getPosition(aauafVar.f43675b)) + 1)) * c0856z.m5305b());
    }

    /* renamed from: a */
    public static int m55347a(RecyclerView.C0856z c0856z, AbstractC0875n abstractC0875n, HwLinearLayoutManagerEx.aauaf aauafVar, RecyclerView.AbstractC0846p abstractC0846p) {
        if (c0856z == null || c0856z.m5305b() == 0 || abstractC0846p == null || abstractC0846p.getChildCount() == 0 || abstractC0875n == null || aauafVar == null) {
            return 0;
        }
        if (!aauafVar.f43676c) {
            return Math.abs(abstractC0846p.getPosition(aauafVar.f43674a) - abstractC0846p.getPosition(aauafVar.f43675b)) + 1;
        }
        return Math.min(abstractC0875n.mo5562o(), abstractC0875n.mo5551d(aauafVar.f43675b) - abstractC0875n.mo5554g(aauafVar.f43674a));
    }
}
