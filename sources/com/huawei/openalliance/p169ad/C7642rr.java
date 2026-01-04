package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.view.View;
import com.huawei.openalliance.p169ad.analysis.BaseAnalysisInfo;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7760bg;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.huawei.openalliance.ad.rr */
/* loaded from: classes8.dex */
public class C7642rr extends AbstractC7644rt {

    /* renamed from: e */
    private String f35589e;

    /* renamed from: f */
    private View f35590f;

    /* renamed from: g */
    private List<StackTraceElement> f35591g;

    /* renamed from: h */
    private int f35592h;

    public C7642rr(Context context, ContentRecord contentRecord, StackTraceElement[] stackTraceElementArr, View view) {
        super(context, contentRecord);
        this.f35589e = "ClickDetector";
        this.f35591g = new ArrayList();
        this.f35590f = view;
        if (AbstractC7760bg.m47769a(stackTraceElementArr)) {
            return;
        }
        this.f35592h = stackTraceElementArr.length;
        this.f35591g = Arrays.asList(stackTraceElementArr);
    }

    /* renamed from: a */
    private void m47113a(String str, String str2) {
        BaseAnalysisInfo baseAnalysisInfo = new BaseAnalysisInfo();
        baseAnalysisInfo.m38827ak("2100039");
        baseAnalysisInfo.m38829am(this.f35590f.getClass().getSimpleName() + "_" + str2);
        baseAnalysisInfo.m38830an(str);
        this.f35596c.m41056b(this.f35595b, baseAnalysisInfo);
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7644rt
    /* renamed from: a */
    public boolean mo47112a() {
        if (this.f35590f != null && this.f35591g != null) {
            for (int i10 = 0; i10 < this.f35592h; i10++) {
                if (!AbstractC7644rt.m47115a(this.f35591g.get(i10))) {
                    m47113a(this.f35591g.get(i10).toString(), "1");
                    return true;
                }
            }
            AbstractC7644rt abstractC7644rt = this.f35597d;
            if (abstractC7644rt != null) {
                return abstractC7644rt.mo47112a();
            }
        }
        return false;
    }
}
