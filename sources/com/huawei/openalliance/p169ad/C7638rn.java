package com.huawei.openalliance.p169ad;

import android.text.TextUtils;
import com.huawei.openalliance.p169ad.C7632rh;
import com.huawei.openalliance.p169ad.beans.vast.NonLinear;
import org.xmlpull.v1.XmlPullParser;

/* renamed from: com.huawei.openalliance.ad.rn */
/* loaded from: classes8.dex */
public class C7638rn implements C7632rh.a {

    /* renamed from: a */
    private String f35576a;

    /* renamed from: b */
    private XmlPullParser f35577b;

    /* renamed from: c */
    private NonLinear f35578c;

    public C7638rn(String str, NonLinear nonLinear, XmlPullParser xmlPullParser) {
        this.f35576a = str;
        this.f35578c = nonLinear;
        this.f35577b = xmlPullParser;
    }

    @Override // com.huawei.openalliance.p169ad.C7632rh.a
    /* renamed from: a */
    public void mo47067a() {
        if (this.f35578c == null || this.f35577b == null || TextUtils.isEmpty(this.f35576a)) {
            return;
        }
        AbstractC7185ho.m43821b("NonLinearTagHandle", "handle: %s", this.f35576a);
        String str = this.f35576a;
        str.hashCode();
        switch (str) {
            case "IFrameResource":
                this.f35578c.m40995b(C7632rh.m47087a(this.f35577b));
                break;
            case "NonLinearClickThrough":
                this.f35578c.m40997d(C7632rh.m47087a(this.f35577b));
                break;
            case "StaticResource":
                this.f35578c.m40990a(C7632rh.m47094b(this.f35577b));
                break;
            case "HTMLResource":
                this.f35578c.m40996c(C7632rh.m47087a(this.f35577b));
                break;
            default:
                AbstractC7185ho.m43821b("NonLinearTagHandle", "unsupported tag: %s", this.f35576a);
                break;
        }
    }
}
