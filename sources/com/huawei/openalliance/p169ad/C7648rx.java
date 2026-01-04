package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.view.View;
import com.huawei.openalliance.p169ad.analysis.BaseAnalysisInfo;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7760bg;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.huawei.openalliance.ad.rx */
/* loaded from: classes8.dex */
public class C7648rx extends AbstractC7644rt {

    /* renamed from: e */
    private String f35616e;

    /* renamed from: f */
    private View f35617f;

    /* renamed from: g */
    private List<StackTraceElement> f35618g;

    /* renamed from: h */
    private int f35619h;

    public C7648rx(Context context, ContentRecord contentRecord, StackTraceElement[] stackTraceElementArr, View view) {
        super(context, contentRecord);
        this.f35616e = "TouchDetector";
        this.f35618g = new ArrayList();
        this.f35617f = view;
        if (AbstractC7760bg.m47769a(stackTraceElementArr)) {
            return;
        }
        this.f35619h = stackTraceElementArr.length;
        this.f35618g = Arrays.asList(stackTraceElementArr);
    }

    /* renamed from: a */
    private void m47131a(String str, String str2) {
        BaseAnalysisInfo baseAnalysisInfo = new BaseAnalysisInfo();
        baseAnalysisInfo.m38827ak("2100039");
        baseAnalysisInfo.m38829am(this.f35617f.getClass().getSimpleName() + "_" + str2);
        baseAnalysisInfo.m38830an(str);
        this.f35596c.m41056b(this.f35595b, baseAnalysisInfo);
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7644rt
    /* renamed from: a */
    public boolean mo47112a() {
        if (this.f35617f != null && this.f35618g != null) {
            for (int i10 = 0; i10 < this.f35619h; i10++) {
                if (!AbstractC7644rt.m47115a(this.f35618g.get(i10))) {
                    m47131a(this.f35618g.get(i10).toString(), "2");
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
