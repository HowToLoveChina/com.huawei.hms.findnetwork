package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import com.huawei.openalliance.p169ad.analysis.BaseAnalysisInfo;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;

/* renamed from: com.huawei.openalliance.ad.rq */
/* loaded from: classes8.dex */
public class C7641rq extends AbstractC7644rt {

    /* renamed from: e */
    private boolean f35587e;

    /* renamed from: f */
    private View f35588f;

    public C7641rq(Context context, ContentRecord contentRecord, View view) {
        super(context, contentRecord);
        this.f35587e = false;
        this.f35588f = view;
        if (view == null || view.getAlpha() >= 1.0f) {
            return;
        }
        this.f35587e = true;
    }

    /* renamed from: a */
    private void m47111a(Rect rect, String str) {
        BaseAnalysisInfo baseAnalysisInfo = new BaseAnalysisInfo();
        baseAnalysisInfo.m38827ak("2100040");
        baseAnalysisInfo.m38829am(this.f35588f.getClass().getSimpleName() + "_" + str);
        baseAnalysisInfo.m38830an(String.valueOf(this.f35588f.getAlpha()));
        baseAnalysisInfo.m38831ao(String.valueOf(rect.width()));
        baseAnalysisInfo.m38832ap(String.valueOf(rect.height()));
        this.f35596c.m41056b(this.f35595b, baseAnalysisInfo);
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7644rt
    /* renamed from: a */
    public boolean mo47112a() {
        if (this.f35588f == null) {
            return false;
        }
        if (this.f35587e) {
            Rect rect = new Rect();
            this.f35588f.getGlobalVisibleRect(rect);
            m47111a(rect, "1");
            return true;
        }
        AbstractC7644rt abstractC7644rt = this.f35597d;
        if (abstractC7644rt != null) {
            return abstractC7644rt.mo47112a();
        }
        return false;
    }
}
