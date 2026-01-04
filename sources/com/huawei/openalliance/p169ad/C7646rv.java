package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.huawei.openalliance.p169ad.analysis.BaseAnalysisInfo;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;

/* renamed from: com.huawei.openalliance.ad.rv */
/* loaded from: classes8.dex */
public class C7646rv extends AbstractC7644rt {

    /* renamed from: e */
    private static final String[] f35601e = {"com.huawei.openalliance.ad.views.ScanningRelativeLayout", "com.huawei.openalliance.ad.views.ParticleRelativeLayout"};

    /* renamed from: f */
    private View f35602f;

    /* renamed from: g */
    private double f35603g;

    /* renamed from: h */
    private double f35604h;

    /* renamed from: i */
    private int f35605i;

    /* renamed from: j */
    private int f35606j;

    /* renamed from: k */
    private int f35607k;

    /* renamed from: l */
    private int f35608l;

    /* renamed from: m */
    private double f35609m;

    /* renamed from: n */
    private String f35610n;

    public C7646rv(Context context, ContentRecord contentRecord, View view) {
        super(context, contentRecord);
        this.f35603g = 0.0d;
        this.f35604h = 0.0d;
        this.f35605i = 0;
        this.f35606j = 0;
        this.f35607k = 0;
        this.f35608l = 0;
        this.f35609m = 0.0d;
        this.f35602f = view;
    }

    /* renamed from: a */
    private int m47119a(Rect rect, int i10) {
        int i11 = rect.right;
        int i12 = this.f35606j;
        if (i11 <= i12) {
            return (this.f35606j - this.f35605i) - (Math.max(rect.left - this.f35605i, 0) + Math.min(this.f35606j - rect.right, i10));
        }
        int i13 = rect.left;
        int i14 = this.f35605i;
        if (i13 >= i14) {
            int iMin = Math.min(i13 - i14, i10);
            int i15 = rect.right;
            int i16 = this.f35606j;
            return (i16 - this.f35605i) - (iMin + (i15 - i16 <= 0 ? i16 - i15 : 0));
        }
        if (i13 >= i14 || i11 <= i12) {
            return 0;
        }
        return i12 - i14;
    }

    /* renamed from: b */
    private double m47122b(View view) {
        if (view == null) {
            return this.f35609m;
        }
        ViewParent parent = view.getParent();
        if (!(parent instanceof ViewGroup)) {
            return this.f35609m;
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        int iIndexOfChild = viewGroup.indexOfChild(view);
        while (true) {
            iIndexOfChild++;
            if (iIndexOfChild >= viewGroup.getChildCount()) {
                double d10 = this.f35609m;
                return d10 < 0.5d ? m47122b(viewGroup) : d10;
            }
            View childAt = viewGroup.getChildAt(iIndexOfChild);
            if (childAt.getVisibility() == 0) {
                Rect rect = new Rect();
                childAt.getGlobalVisibleRect(rect);
                m47120a(rect);
                if (this.f35609m >= 0.5d && !m47123c(childAt)) {
                    this.f35610n = childAt.getClass().getName();
                    return this.f35609m;
                }
            }
        }
    }

    /* renamed from: c */
    private boolean m47123c(View view) {
        if (view == null) {
            return false;
        }
        for (String str : f35601e) {
            if (str.equals(view.getClass().getName())) {
                AbstractC7185ho.m43817a("ShadeDetector", "shaded by animator view.");
                this.f35609m = 0.0d;
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private void m47120a(Rect rect) {
        int iM47119a = this.f35606j - this.f35605i;
        int i10 = this.f35608l;
        int i11 = this.f35607k;
        int iMin = i10 - i11;
        int i12 = rect.bottom;
        int i13 = rect.top;
        if (i12 <= i10) {
            iMin -= (i11 - i13 <= 0 ? i13 - i11 : 0) + Math.min(i10 - i12, iMin);
        } else if (i13 < i11) {
            if (i13 < i11 && i12 > i10) {
            }
            this.f35609m = (iM47119a * iMin) / this.f35603g;
        } else {
            int iMin2 = Math.min(i13 - i11, iMin);
            int i14 = rect.bottom;
            int i15 = this.f35608l;
            iMin -= iMin2 + (i14 - i15 <= 0 ? i15 - i14 : 0);
        }
        iM47119a = m47119a(rect, iM47119a);
        this.f35609m = (iM47119a * iMin) / this.f35603g;
    }

    /* renamed from: a */
    private void m47121a(Rect rect, String str) {
        BaseAnalysisInfo baseAnalysisInfo = new BaseAnalysisInfo();
        baseAnalysisInfo.m38827ak("2100040");
        baseAnalysisInfo.m38829am(this.f35602f.getClass().getSimpleName() + "_" + str);
        baseAnalysisInfo.m38830an(String.valueOf(this.f35602f.getAlpha()));
        baseAnalysisInfo.m38831ao(String.valueOf(rect.width()));
        baseAnalysisInfo.m38832ap(String.valueOf(rect.height()));
        baseAnalysisInfo.m38833aq(this.f35610n);
        this.f35596c.m41056b(this.f35595b, baseAnalysisInfo);
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7644rt
    /* renamed from: a */
    public boolean mo47112a() {
        View view = this.f35602f;
        if (view == null || !AbstractC7644rt.m47114a(view)) {
            return false;
        }
        this.f35603g = this.f35602f.getWidth() * this.f35602f.getHeight();
        Rect rect = new Rect();
        this.f35602f.getGlobalVisibleRect(rect);
        this.f35605i = rect.left;
        this.f35606j = rect.right;
        this.f35607k = rect.top;
        this.f35608l = rect.bottom;
        if (m47122b(this.f35602f) >= 0.5d) {
            m47121a(rect, "4");
            return true;
        }
        AbstractC7644rt abstractC7644rt = this.f35597d;
        if (abstractC7644rt != null) {
            return abstractC7644rt.mo47112a();
        }
        return false;
    }
}
