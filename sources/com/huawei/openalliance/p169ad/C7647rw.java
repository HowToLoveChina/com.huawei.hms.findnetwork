package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.huawei.openalliance.p169ad.analysis.BaseAnalysisInfo;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;

/* renamed from: com.huawei.openalliance.ad.rw */
/* loaded from: classes8.dex */
public class C7647rw extends AbstractC7644rt {

    /* renamed from: e */
    private View f35611e;

    /* renamed from: f */
    private int f35612f;

    /* renamed from: g */
    private int f35613g;

    /* renamed from: h */
    private int f35614h;

    /* renamed from: i */
    private int f35615i;

    public C7647rw(Context context, ContentRecord contentRecord, View view) {
        super(context, contentRecord);
        this.f35611e = view;
    }

    /* renamed from: a */
    private void m47124a(Rect rect, String str) {
        int width = rect.width() < 0 ? this.f35611e.getWidth() : rect.width();
        int height = rect.height() < 0 ? this.f35611e.getHeight() : rect.height();
        BaseAnalysisInfo baseAnalysisInfo = new BaseAnalysisInfo();
        baseAnalysisInfo.m38827ak("2100040");
        baseAnalysisInfo.m38829am(this.f35611e.getClass().getSimpleName() + "_" + str);
        baseAnalysisInfo.m38830an(String.valueOf(this.f35611e.getAlpha()));
        baseAnalysisInfo.m38831ao(String.valueOf(width));
        baseAnalysisInfo.m38832ap(String.valueOf(height));
        this.f35596c.m41056b(this.f35595b, baseAnalysisInfo);
    }

    /* renamed from: b */
    private boolean m47126b() {
        int iM47535a = AbstractC7741ao.m47535a(this.f35611e.getContext(), 9.0f);
        return this.f35611e.getWidth() < iM47535a || this.f35611e.getHeight() < iM47535a;
    }

    /* renamed from: c */
    private boolean m47128c() {
        this.f35612f = this.f35611e.getPaddingLeft();
        this.f35613g = this.f35611e.getPaddingTop();
        this.f35614h = this.f35611e.getPaddingRight();
        int paddingBottom = this.f35611e.getPaddingBottom();
        this.f35615i = paddingBottom;
        return this.f35612f < 0 || this.f35613g < 0 || this.f35614h < 0 || paddingBottom < 0;
    }

    /* renamed from: d */
    private boolean m47129d() {
        ViewGroup.LayoutParams layoutParams = this.f35611e.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return false;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        int i10 = marginLayoutParams.leftMargin;
        this.f35612f = i10;
        int i11 = marginLayoutParams.topMargin;
        this.f35613g = i11;
        int i12 = marginLayoutParams.rightMargin;
        this.f35614h = i12;
        int i13 = marginLayoutParams.bottomMargin;
        this.f35615i = i13;
        return i10 < 0 || i11 < 0 || i12 < 0 || i13 < 0;
    }

    /* renamed from: e */
    private boolean m47130e() {
        return m47125a((ViewGroup) this.f35611e) || m47127b(this.f35611e);
    }

    /* renamed from: b */
    private boolean m47127b(View view) {
        if (view == null || AbstractC7741ao.m47551a(this.f35595b)) {
            return false;
        }
        float scaleX = view.getScaleX() * view.getScaleY();
        if (scaleX < 0.5d || scaleX > 2.0f) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
            if (m47127b(viewGroup.getChildAt(i10))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7644rt
    /* renamed from: a */
    public boolean mo47112a() {
        String str;
        View view = this.f35611e;
        if (view == null || !AbstractC7644rt.m47114a(view)) {
            return false;
        }
        Rect rect = new Rect();
        this.f35611e.getGlobalVisibleRect(rect);
        if (m47128c() || m47129d() || m47130e()) {
            str = "2";
        } else {
            if (!m47126b()) {
                AbstractC7644rt abstractC7644rt = this.f35597d;
                if (abstractC7644rt != null) {
                    return abstractC7644rt.mo47112a();
                }
                return false;
            }
            str = "3";
        }
        m47124a(rect, str);
        return true;
    }

    /* renamed from: a */
    private boolean m47125a(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return false;
        }
        float scaleX = viewGroup.getScaleX() * viewGroup.getScaleY();
        if (scaleX < 0.5d || scaleX > 2.0f) {
            return true;
        }
        if (viewGroup.getParent() instanceof ViewGroup) {
            return m47125a((ViewGroup) viewGroup.getParent());
        }
        return false;
    }
}
