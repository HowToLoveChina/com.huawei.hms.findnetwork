package com.huawei.openalliance.p169ad.views.feedback;

import android.content.Context;
import android.content.Intent;
import android.util.Pair;
import android.webkit.JavascriptInterface;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C7335ji;
import com.huawei.openalliance.p169ad.beans.feedback.AdditionalContext;
import com.huawei.openalliance.p169ad.beans.feedback.ComplainAddInfo;
import com.huawei.openalliance.p169ad.beans.metadata.MetaData;
import com.huawei.openalliance.p169ad.constant.NotifyMessageNames;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7758be;
import com.huawei.openalliance.p169ad.utils.AbstractC7760bg;
import com.huawei.openalliance.p169ad.utils.AbstractC7801cu;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.AbstractC7807d;
import java.lang.ref.WeakReference;

/* renamed from: com.huawei.openalliance.ad.views.feedback.a */
/* loaded from: classes2.dex */
public class C8091a implements InterfaceC8096f {

    /* renamed from: a */
    private ComplainAddInfo f37648a = new ComplainAddInfo();

    /* renamed from: b */
    private WeakReference<InterfaceC8098h> f37649b;

    public C8091a(Context context, ContentRecord contentRecord, InterfaceC8098h interfaceC8098h) {
        m50140a(interfaceC8098h);
        m50138a(context, contentRecord);
    }

    @Override // com.huawei.openalliance.p169ad.views.feedback.InterfaceC8096f
    /* renamed from: a */
    public ComplainAddInfo mo50141a() {
        return this.f37648a;
    }

    @Override // com.huawei.openalliance.p169ad.views.feedback.InterfaceC8096f
    @JavascriptInterface
    public void afterSubmit(String str) {
        InterfaceC8098h interfaceC8098h;
        AbstractC7185ho.m43820b("ComplainJS", "submit success");
        WeakReference<InterfaceC8098h> weakReference = this.f37649b;
        if (weakReference == null || (interfaceC8098h = weakReference.get()) == null) {
            return;
        }
        interfaceC8098h.mo46265a();
        C7335ji.m45308a().m45309a(NotifyMessageNames.AD_COMPLAIN_MESSAGE_NAME, new Intent(NotifyMessageNames.AD_COMPLAIN_ACTION));
    }

    @Override // com.huawei.openalliance.p169ad.views.feedback.InterfaceC8096f
    /* renamed from: b */
    public void mo50142b() {
        InterfaceC8098h interfaceC8098h;
        AbstractC7185ho.m43820b("ComplainJS", "no submit");
        WeakReference<InterfaceC8098h> weakReference = this.f37649b;
        if (weakReference == null || (interfaceC8098h = weakReference.get()) == null) {
            return;
        }
        interfaceC8098h.mo46266b();
    }

    @Override // com.huawei.openalliance.p169ad.views.feedback.InterfaceC8096f
    @JavascriptInterface
    public String complainAddInfo() {
        String strM47742b = AbstractC7758be.m47742b(this.f37648a);
        return AbstractC7806cz.m48165b(strM47742b) ? "" : strM47742b;
    }

    /* renamed from: a */
    private void m50138a(Context context, ContentRecord contentRecord) {
        try {
            AbstractC7185ho.m43820b("ComplainJS", "config add info");
            AdditionalContext additionalContext = new AdditionalContext();
            Pair<String, Boolean> pairM48217b = AbstractC7807d.m48217b(context, true);
            if (pairM48217b != null) {
                this.f37648a.m39270a((String) pairM48217b.first);
            } else {
                this.f37648a.m39270a(AbstractC7741ao.m47539a());
            }
            m50139a(contentRecord, additionalContext);
            additionalContext.m39267e(AbstractC7801cu.m48126a(AbstractC7758be.m47742b(additionalContext)));
            if (contentRecord != null) {
                additionalContext.m39265c(contentRecord.m41585m());
            }
            this.f37648a.m39269a(additionalContext);
        } catch (Throwable th2) {
            AbstractC7185ho.m43821b("ComplainJS", "config add info err: %s", th2.getClass().getSimpleName());
        }
    }

    /* renamed from: a */
    private void m50139a(ContentRecord contentRecord, AdditionalContext additionalContext) {
        if (contentRecord != null) {
            MetaData metaDataM41568i = contentRecord.m41568i();
            if (metaDataM41568i != null && 3 != contentRecord.m41464aP()) {
                if (!AbstractC7806cz.m48165b(metaDataM41568i.m40309e())) {
                    additionalContext.m39261a(AbstractC7806cz.m48168c(metaDataM41568i.m40309e()));
                }
                if (!AbstractC7760bg.m47767a(metaDataM41568i.m40277N())) {
                    additionalContext.m39262a(metaDataM41568i.m40277N());
                }
                if (!AbstractC7760bg.m47767a(metaDataM41568i.m40276M())) {
                    additionalContext.m39264b(metaDataM41568i.m40276M());
                }
            }
            if (3 != contentRecord.m41464aP() && !AbstractC7806cz.m48165b(metaDataM41568i.m40318h())) {
                additionalContext.m39266d(metaDataM41568i.m40318h());
            }
            additionalContext.m39263b(contentRecord.m41588n());
        }
    }

    /* renamed from: a */
    private void m50140a(InterfaceC8098h interfaceC8098h) {
        if (interfaceC8098h != null) {
            this.f37649b = new WeakReference<>(interfaceC8098h);
        }
    }
}
