package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.openalliance.p169ad.analysis.BaseAnalysisInfo;
import com.huawei.openalliance.p169ad.analysis.C6921b;
import com.huawei.openalliance.p169ad.analysis.C6922c;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7758be;

/* renamed from: com.huawei.openalliance.ad.bo */
/* loaded from: classes8.dex */
public class C6971bo extends C6922c {
    public C6971bo(Context context) {
        super(context);
    }

    /* renamed from: a */
    public C6921b m41052a(BaseAnalysisInfo baseAnalysisInfo) {
        if (baseAnalysisInfo == null) {
            return null;
        }
        C6921b c6921bM39159a = m39159a(true);
        m39162a(c6921bM39159a, baseAnalysisInfo);
        return c6921bM39159a;
    }

    /* renamed from: b */
    public void m41056b(ContentRecord contentRecord, BaseAnalysisInfo baseAnalysisInfo) {
        if (contentRecord == null || baseAnalysisInfo == null) {
            return;
        }
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a("EngineAnalysisUtil", "onCheatingAnalysis: %s", AbstractC7758be.m47742b(baseAnalysisInfo));
        }
        Context context = this.f31973a;
        m41051a(contentRecord, (InterfaceC7615qq) new C7560ou(context, C7662sk.m47225a(context, contentRecord.m41552f())), baseAnalysisInfo, false, false);
    }

    /* renamed from: a */
    public C6921b m41053a(ContentRecord contentRecord, BaseAnalysisInfo baseAnalysisInfo) {
        if (baseAnalysisInfo == null || contentRecord == null) {
            return null;
        }
        C6921b c6921bM39167f = m39167f(contentRecord);
        m39162a(c6921bM39167f, baseAnalysisInfo);
        return c6921bM39167f;
    }

    /* renamed from: a */
    public void m41054a(Bundle bundle, ContentRecord contentRecord, InterfaceC7615qq interfaceC7615qq) {
        if (bundle == null || contentRecord == null) {
            AbstractC7185ho.m43820b("EngineAnalysisUtil", "param or ad is null");
        } else {
            m41055a(new C7154gk(bundle).m43588d("analysisType"), bundle, contentRecord, interfaceC7615qq);
        }
    }

    /* renamed from: a */
    private void m41051a(ContentRecord contentRecord, InterfaceC7615qq interfaceC7615qq, BaseAnalysisInfo baseAnalysisInfo, boolean z10, boolean z11) {
        C6921b c6921bM41053a = m41053a(contentRecord, baseAnalysisInfo);
        if (c6921bM41053a == null) {
            AbstractC7185ho.m43823c("EngineAnalysisUtil", "onAnalysis, info is null.");
            return;
        }
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a("EngineAnalysisUtil", "onAnalysis, info: %s", AbstractC7758be.m47742b(c6921bM41053a));
        }
        interfaceC7615qq.mo46609b(c6921bM41053a, z10, z11);
    }

    /* renamed from: a */
    public void m41055a(String str, Bundle bundle, ContentRecord contentRecord, InterfaceC7615qq interfaceC7615qq) {
        if (TextUtils.isEmpty(str) || bundle == null || contentRecord == null || interfaceC7615qq == null) {
            AbstractC7185ho.m43820b("EngineAnalysisUtil", "param or ad or analysisType is null");
            return;
        }
        C7154gk c7154gk = new C7154gk(bundle);
        String strM43588d = c7154gk.m43588d("analysis_info");
        boolean zM43581a = c7154gk.m43581a("is_report_now", false);
        boolean zM43581a2 = c7154gk.m43581a("is_check_discard", false);
        BaseAnalysisInfo baseAnalysisInfo = (BaseAnalysisInfo) AbstractC7758be.m47739b(strM43588d, BaseAnalysisInfo.class, new Class[0]);
        if (baseAnalysisInfo == null) {
            AbstractC7185ho.m43820b("EngineAnalysisUtil", "engineInfo is null");
            return;
        }
        baseAnalysisInfo.m38827ak(str);
        AbstractC7185ho.m43821b("EngineAnalysisUtil", "start report analysis, analysisType: %s", str);
        m41051a(contentRecord, interfaceC7615qq, baseAnalysisInfo, zM43581a, zM43581a2);
    }
}
