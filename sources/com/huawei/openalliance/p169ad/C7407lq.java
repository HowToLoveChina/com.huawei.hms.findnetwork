package com.huawei.openalliance.p169ad;

import android.content.Context;
import com.huawei.openalliance.p169ad.beans.metadata.C6957Om;
import com.huawei.openalliance.p169ad.constant.MimeType;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import java.util.List;

/* renamed from: com.huawei.openalliance.ad.lq */
/* loaded from: classes8.dex */
public class C7407lq {
    /* renamed from: a */
    public static InterfaceC7474mi m45634a(Context context, ContentRecord contentRecord, InterfaceC7403lm interfaceC7403lm, boolean z10) throws Throwable {
        C7423me c7423meM45679a;
        if (contentRecord == null || context == null) {
            return new C7410lt();
        }
        if (z10 && (interfaceC7403lm == null || interfaceC7403lm.getOpenMeasureView() == null)) {
            AbstractC7185ho.m43820b("AdSessionAgentFactory", "MeasureView is null");
            return new C7410lt();
        }
        if (!C7406lp.m45629a()) {
            return new C7410lt();
        }
        AbstractC7185ho.m43817a("AdSessionAgentFactory", "AdSessionAgent is avalible");
        C7406lp c7406lp = new C7406lp();
        List<C6957Om> listM41506b = contentRecord.m41506b(context);
        if (listM41506b == null) {
            AbstractC7185ho.m43820b("AdSessionAgentFactory", "Oms is null");
            return c7406lp;
        }
        if (contentRecord.m41419S() != null || (contentRecord.m41421T() != null && MimeType.MP4.equals(contentRecord.m41421T().m40243a()))) {
            AbstractC7185ho.m43820b("AdSessionAgentFactory", "Video adsession");
            EnumC7472mg enumC7472mg = EnumC7472mg.VIDEO;
            EnumC7475mj enumC7475mj = EnumC7475mj.VIEWABLE;
            EnumC7476mk enumC7476mk = EnumC7476mk.NATIVE;
            c7423meM45679a = C7423me.m45679a(enumC7472mg, enumC7475mj, enumC7476mk, enumC7476mk, false);
        } else {
            c7423meM45679a = C7423me.m45679a(EnumC7472mg.NATIVE_DISPLAY, EnumC7475mj.VIEWABLE, EnumC7476mk.NATIVE, EnumC7476mk.NONE, false);
        }
        if (c7423meM45679a == null) {
            return c7406lp;
        }
        AbstractC7185ho.m43820b("AdSessionAgentFactory", "init adSessionAgent");
        c7406lp.m45631a(context, listM41506b, c7423meM45679a);
        if (z10) {
            c7406lp.mo45608a(interfaceC7403lm.getOpenMeasureView());
        }
        return c7406lp;
    }
}
