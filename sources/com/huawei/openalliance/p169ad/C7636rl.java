package com.huawei.openalliance.p169ad;

import com.huawei.openalliance.p169ad.C7632rh;
import com.huawei.openalliance.p169ad.beans.vast.Creative;
import com.huawei.openalliance.p169ad.beans.vast.LinearCreative;
import com.huawei.openalliance.p169ad.beans.vast.NonLinearAds;
import com.huawei.openalliance.p169ad.beans.vast.VastContent;
import com.huawei.openalliance.p169ad.constant.VastAttribute;
import com.huawei.openalliance.p169ad.constant.VastTag;
import com.huawei.openalliance.p169ad.utils.C7789ci;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: com.huawei.openalliance.ad.rl */
/* loaded from: classes8.dex */
public class C7636rl implements C7632rh.a {

    /* renamed from: a */
    private VastContent f35565a;

    /* renamed from: b */
    private XmlPullParser f35566b;

    /* renamed from: c */
    private List<Creative> f35567c;

    /* renamed from: com.huawei.openalliance.ad.rl$a */
    public static class a implements C7632rh.a {

        /* renamed from: a */
        private final XmlPullParser f35568a;

        /* renamed from: b */
        private final Creative f35569b;

        /* renamed from: c */
        private final VastContent f35570c;

        public a(XmlPullParser xmlPullParser, VastContent vastContent, Creative creative) {
            this.f35568a = xmlPullParser;
            this.f35570c = vastContent;
            this.f35569b = creative;
        }

        @Override // com.huawei.openalliance.p169ad.C7632rh.a
        /* renamed from: a */
        public void mo47067a() throws XmlPullParserException, IOException {
            if (this.f35569b == null) {
                return;
            }
            LinearCreative linearCreative = new LinearCreative();
            C7633ri.m47101c().m47065a(linearCreative, this.f35568a, this.f35570c);
            this.f35569b.m40974a(linearCreative);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.rl$b */
    public static class b implements C7632rh.a {

        /* renamed from: a */
        private final XmlPullParser f35571a;

        /* renamed from: b */
        private final Creative f35572b;

        public b(XmlPullParser xmlPullParser, Creative creative) {
            this.f35571a = xmlPullParser;
            this.f35572b = creative;
        }

        @Override // com.huawei.openalliance.p169ad.C7632rh.a
        /* renamed from: a */
        public void mo47067a() throws XmlPullParserException, IOException {
            if (this.f35572b == null) {
                return;
            }
            NonLinearAds nonLinearAds = new NonLinearAds();
            C7633ri.m47100b().m47078a(nonLinearAds, this.f35571a);
            this.f35572b.m40975a(nonLinearAds);
        }
    }

    public C7636rl(VastContent vastContent, XmlPullParser xmlPullParser, List<Creative> list) {
        this.f35565a = vastContent;
        this.f35566b = xmlPullParser;
        this.f35567c = list;
    }

    /* renamed from: a */
    private Creative m47102a(XmlPullParser xmlPullParser, VastContent vastContent) throws XmlPullParserException, IOException {
        if (xmlPullParser == null || vastContent == null) {
            return null;
        }
        AbstractC7185ho.m43818a("CreativeTagHandle", "start read creative, ad id: %s", vastContent.m41008a());
        String str = VastTag.NAMESPACE;
        xmlPullParser.require(2, str, VastTag.CREATIVE);
        String attributeValue = xmlPullParser.getAttributeValue(str, VastAttribute.AD_ID);
        String attributeValue2 = xmlPullParser.getAttributeValue(str, "id");
        if (attributeValue2 == null) {
            attributeValue2 = C7789ci.m48041a(8);
        }
        String attributeValue3 = xmlPullParser.getAttributeValue(str, VastAttribute.SEQUENCE);
        Creative creative = new Creative(attributeValue2, attributeValue3 != null ? Integer.valueOf(attributeValue3) : null, attributeValue);
        HashMap map = new HashMap();
        map.put(VastTag.LINEAR, new a(xmlPullParser, vastContent, creative));
        map.put(VastTag.NON_LINEAR_ADS, new b(xmlPullParser, creative));
        C7632rh.m47093a(xmlPullParser, map, (List<String>) Arrays.asList(VastTag.LINEAR, VastTag.NON_LINEAR_ADS));
        return creative;
    }

    @Override // com.huawei.openalliance.p169ad.C7632rh.a
    /* renamed from: a */
    public void mo47067a() {
        List<Creative> list = this.f35567c;
        if (list != null) {
            list.add(m47102a(this.f35566b, this.f35565a));
        }
    }
}
