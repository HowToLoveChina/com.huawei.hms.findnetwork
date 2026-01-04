package com.huawei.openalliance.p169ad;

import com.huawei.openalliance.p169ad.C7632rh;
import com.huawei.openalliance.p169ad.beans.vast.LinearCreative;
import com.huawei.openalliance.p169ad.beans.vast.VastIcon;
import com.huawei.openalliance.p169ad.constant.VastAttribute;
import com.huawei.openalliance.p169ad.constant.VastTag;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: com.huawei.openalliance.ad.re */
/* loaded from: classes8.dex */
public class C7629re extends AbstractC7625ra {

    /* renamed from: a */
    private Set<String> f35546a = new HashSet(Arrays.asList(VastAttribute.CREATIVE_VIEW, "start", "firstQuartile", "midpoint", "thirdQuartile", "complete", "mute", "unmute", VastAttribute.PAUSE, "resume", VastAttribute.CLOSE_LINEAR, "skip", VastAttribute.PROGRESS));

    /* renamed from: com.huawei.openalliance.ad.re$a */
    public static class a implements C7632rh.a {

        /* renamed from: a */
        private final LinearCreative f35547a;

        /* renamed from: b */
        private final XmlPullParser f35548b;

        public a(LinearCreative linearCreative, XmlPullParser xmlPullParser) {
            this.f35547a = linearCreative;
            this.f35548b = xmlPullParser;
        }

        /* renamed from: a */
        private List<VastIcon> m47084a(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
            if (xmlPullParser == null) {
                return null;
            }
            AbstractC7185ho.m43817a("Linear30Parser", "start read icons");
            xmlPullParser.require(2, VastTag.NAMESPACE, VastTag.ICONS);
            ArrayList arrayList = new ArrayList();
            HashMap map = new HashMap();
            map.put(VastTag.ICON, new b(arrayList, xmlPullParser));
            C7632rh.m47093a(xmlPullParser, map, (List<String>) Collections.emptyList());
            AbstractC7185ho.m43817a("Linear30Parser", "read icons finish");
            return arrayList;
        }

        @Override // com.huawei.openalliance.p169ad.C7632rh.a
        /* renamed from: a */
        public void mo47067a() {
            LinearCreative linearCreative = this.f35547a;
            if (linearCreative != null) {
                linearCreative.m40984b(m47084a(this.f35548b));
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.re$b */
    public static class b implements C7632rh.a {

        /* renamed from: a */
        private final List<VastIcon> f35549a;

        /* renamed from: b */
        private final XmlPullParser f35550b;

        /* renamed from: com.huawei.openalliance.ad.re$b$a */
        public static class a implements C7632rh.a {

            /* renamed from: a */
            private final VastIcon f35551a;

            /* renamed from: b */
            private final XmlPullParser f35552b;

            public a(VastIcon vastIcon, XmlPullParser xmlPullParser) {
                this.f35551a = vastIcon;
                this.f35552b = xmlPullParser;
            }

            @Override // com.huawei.openalliance.p169ad.C7632rh.a
            /* renamed from: a */
            public void mo47067a() {
                VastIcon vastIcon = this.f35551a;
                if (vastIcon != null) {
                    vastIcon.m41033e(C7632rh.m47087a(this.f35552b));
                }
            }
        }

        /* renamed from: com.huawei.openalliance.ad.re$b$b, reason: collision with other inner class name */
        public static class C14474b implements C7632rh.a {

            /* renamed from: a */
            private final VastIcon f35553a;

            /* renamed from: b */
            private final XmlPullParser f35554b;

            public C14474b(VastIcon vastIcon, XmlPullParser xmlPullParser) {
                this.f35553a = vastIcon;
                this.f35554b = xmlPullParser;
            }

            @Override // com.huawei.openalliance.p169ad.C7632rh.a
            /* renamed from: a */
            public void mo47067a() {
                VastIcon vastIcon = this.f35553a;
                if (vastIcon != null) {
                    vastIcon.m41032d(C7632rh.m47087a(this.f35554b));
                }
            }
        }

        /* renamed from: com.huawei.openalliance.ad.re$b$c */
        public static class c implements C7632rh.a {

            /* renamed from: a */
            private final VastIcon f35555a;

            /* renamed from: b */
            private final XmlPullParser f35556b;

            public c(VastIcon vastIcon, XmlPullParser xmlPullParser) {
                this.f35555a = vastIcon;
                this.f35556b = xmlPullParser;
            }

            @Override // com.huawei.openalliance.p169ad.C7632rh.a
            /* renamed from: a */
            public void mo47067a() {
                VastIcon vastIcon = this.f35555a;
                if (vastIcon != null) {
                    vastIcon.m41025a(C7632rh.m47094b(this.f35556b));
                }
            }
        }

        public b(List<VastIcon> list, XmlPullParser xmlPullParser) {
            this.f35549a = list;
            this.f35550b = xmlPullParser;
        }

        /* renamed from: a */
        private VastIcon m47085a(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
            if (xmlPullParser == null) {
                return null;
            }
            AbstractC7185ho.m43817a("Linear30Parser", "start read icon");
            String str = VastTag.NAMESPACE;
            xmlPullParser.require(2, str, VastTag.ICON);
            VastIcon vastIcon = new VastIcon();
            String attributeValue = xmlPullParser.getAttributeValue(str, VastAttribute.PROGRAM);
            if (attributeValue != null) {
                vastIcon.m41026a(attributeValue);
            }
            String attributeValue2 = xmlPullParser.getAttributeValue(str, "width");
            String attributeValue3 = xmlPullParser.getAttributeValue(str, "height");
            if (attributeValue2 == null || attributeValue3 == null) {
                AbstractC7185ho.m43823c("Linear30Parser", "icon width or height is missing.");
                return null;
            }
            vastIcon.m41028b(Integer.parseInt(attributeValue2));
            vastIcon.m41024a(Integer.parseInt(attributeValue3));
            vastIcon.m41029b(C7632rh.m47088a(xmlPullParser, VastAttribute.XPOSITION));
            vastIcon.m41031c(C7632rh.m47088a(xmlPullParser, VastAttribute.YPOSITION));
            HashMap map = new HashMap();
            map.put(VastTag.STATIC_RESOURCE, new c(vastIcon, xmlPullParser));
            map.put(VastTag.IFRAME_RESOURCE, new C14474b(vastIcon, xmlPullParser));
            map.put(VastTag.HTML_RESOURCE, new a(vastIcon, xmlPullParser));
            C7632rh.m47093a(xmlPullParser, map, (List<String>) Collections.emptyList());
            AbstractC7185ho.m43818a("Linear30Parser", "read icon finish, icon: %s", vastIcon);
            return vastIcon;
        }

        @Override // com.huawei.openalliance.p169ad.C7632rh.a
        /* renamed from: a */
        public void mo47067a() {
            List<VastIcon> list = this.f35549a;
            if (list != null) {
                list.add(m47085a(this.f35550b));
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7625ra
    /* renamed from: a */
    public Set<String> mo47064a() {
        return this.f35546a;
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7625ra
    /* renamed from: a */
    public void mo47066a(LinearCreative linearCreative, XmlPullParser xmlPullParser, Map<String, C7632rh.a> map) {
        if (map != null) {
            map.put(VastTag.ICONS, new a(linearCreative, xmlPullParser));
        }
    }
}
