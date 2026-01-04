package com.huawei.openalliance.p169ad;

import android.text.TextUtils;
import com.huawei.openalliance.p169ad.C7632rh;
import com.huawei.openalliance.p169ad.beans.vast.Impression;
import com.huawei.openalliance.p169ad.beans.vast.VastContent;
import com.huawei.openalliance.p169ad.constant.VastTag;
import org.xmlpull.v1.XmlPullParser;

/* renamed from: com.huawei.openalliance.ad.rm */
/* loaded from: classes8.dex */
public class C7637rm implements C7632rh.a {

    /* renamed from: a */
    private String f35573a;

    /* renamed from: b */
    private VastContent f35574b;

    /* renamed from: c */
    private XmlPullParser f35575c;

    public C7637rm(String str, VastContent vastContent, XmlPullParser xmlPullParser) {
        this.f35573a = str;
        this.f35574b = vastContent;
        this.f35575c = xmlPullParser;
    }

    @Override // com.huawei.openalliance.p169ad.C7632rh.a
    /* renamed from: a */
    public void mo47067a() {
        if (this.f35575c == null || this.f35574b == null || TextUtils.isEmpty(this.f35573a)) {
            return;
        }
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a("InlineHandle", "handle: %s", this.f35573a);
        }
        String str = this.f35573a;
        str.hashCode();
        switch (str) {
            case "Creatives":
                VastContent vastContent = this.f35574b;
                vastContent.m41011a(C7632rh.m47096c(this.f35575c, vastContent));
                break;
            case "AdSystem":
                String attributeValue = this.f35575c.getAttributeValue(VastTag.NAMESPACE, "version");
                this.f35574b.m41013b(C7632rh.m47087a(this.f35575c));
                this.f35574b.m41015c(attributeValue);
                break;
            case "Description":
                this.f35574b.m41019e(C7632rh.m47087a(this.f35575c));
                break;
            case "AdTitle":
                this.f35574b.m41017d(C7632rh.m47087a(this.f35575c));
                break;
            case "Advertiser":
                this.f35574b.m41021f(C7632rh.m47087a(this.f35575c));
                break;
            case "Impression":
                this.f35574b.m41009a(new Impression(this.f35575c.getAttributeValue(VastTag.NAMESPACE, "id"), C7632rh.m47087a(this.f35575c)));
                break;
            default:
                AbstractC7185ho.m43821b("InlineHandle", "unsupported tag: %s", this.f35573a);
                break;
        }
    }
}
