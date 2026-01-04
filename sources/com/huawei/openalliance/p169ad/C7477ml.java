package com.huawei.openalliance.p169ad;

import com.huawei.openalliance.p169ad.beans.metadata.C6957Om;
import com.huawei.openalliance.p169ad.utils.AbstractC7819dl;
import com.iab.omid.library.huawei.adsession.VerificationScriptResource;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.huawei.openalliance.ad.ml */
/* loaded from: classes8.dex */
public class C7477ml {

    /* renamed from: a */
    private static boolean f34669a = C7418ma.m45655a("com.iab.omid.library.huawei.adsession.VerificationScriptResource");

    /* renamed from: b */
    private List<VerificationScriptResource> f34670b = new ArrayList();

    /* renamed from: a */
    private URL m45842a(String str) {
        if (str == null) {
            return null;
        }
        try {
            return new URL(str);
        } catch (MalformedURLException e10) {
            AbstractC7185ho.m43823c("VerficationScriptResourceWrapper", "parseURL: " + AbstractC7819dl.m48375a(e10.getMessage()));
            return null;
        }
    }

    /* renamed from: b */
    public List<VerificationScriptResource> m45845b() {
        return this.f34670b;
    }

    /* renamed from: a */
    public void m45844a(C6957Om c6957Om) {
        if (c6957Om == null || !f34669a) {
            AbstractC7185ho.m43820b("VerficationScriptResourceWrapper", "om is not avalible");
            return;
        }
        String strM40366a = c6957Om.m40366a();
        URL urlM45842a = m45842a(c6957Om.m40368b());
        String strM40370c = c6957Om.m40370c();
        if (strM40366a == null || urlM45842a == null || strM40370c == null) {
            AbstractC7185ho.m43820b("VerficationScriptResourceWrapper", "Parameters is null");
            return;
        }
        VerificationScriptResource verificationScriptResourceCreateVerificationScriptResourceWithParameters = VerificationScriptResource.createVerificationScriptResourceWithParameters(strM40366a, urlM45842a, strM40370c);
        if (verificationScriptResourceCreateVerificationScriptResourceWithParameters == null) {
            AbstractC7185ho.m43820b("VerficationScriptResourceWrapper", "Create verificationScriptResource failed");
        } else {
            this.f34670b.add(verificationScriptResourceCreateVerificationScriptResourceWithParameters);
        }
    }

    /* renamed from: a */
    public static boolean m45843a() {
        return f34669a;
    }
}
