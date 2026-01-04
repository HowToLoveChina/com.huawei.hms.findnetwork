package com.huawei.openalliance.p169ad;

import android.text.TextUtils;
import com.huawei.openalliance.p169ad.C7632rh;
import com.huawei.openalliance.p169ad.beans.vast.NonLinear;
import com.huawei.openalliance.p169ad.beans.vast.NonLinearAds;
import com.huawei.openalliance.p169ad.beans.vast.Tracking;
import com.huawei.openalliance.p169ad.constant.VastTag;
import com.huawei.openalliance.p169ad.utils.AbstractC7758be;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: com.huawei.openalliance.ad.rb */
/* loaded from: classes8.dex */
public abstract class AbstractC7626rb {

    /* renamed from: a */
    private static final List<String> f35529a = Arrays.asList(VastTag.IFRAME_RESOURCE, VastTag.STATIC_RESOURCE, VastTag.HTML_RESOURCE, VastTag.NON_LINEAR_CLICK_THROUGH);

    /* renamed from: a */
    public abstract Set<String> mo47077a();

    /* renamed from: a */
    public abstract void mo47079a(XmlPullParser xmlPullParser, List<Tracking> list, Map<String, C7632rh.a> map);

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public NonLinear m47073a(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        if (xmlPullParser == null) {
            return null;
        }
        String str = VastTag.NAMESPACE;
        xmlPullParser.require(2, str, VastTag.NON_LINEAR);
        AbstractC7185ho.m43820b("BaseNonLinearParser", "readNonLinear");
        NonLinear nonLinear = new NonLinear();
        nonLinear.m40991a(xmlPullParser.getAttributeValue(str, "id"));
        String attributeValue = xmlPullParser.getAttributeValue(str, "height");
        String attributeValue2 = xmlPullParser.getAttributeValue(str, "width");
        if (TextUtils.isEmpty(attributeValue2) || TextUtils.isEmpty(attributeValue)) {
            AbstractC7185ho.m43823c("BaseNonLinearParser", "missing required attribute.");
            return null;
        }
        nonLinear.m40989a(AbstractC7806cz.m48178h(attributeValue).intValue());
        nonLinear.m40994b(AbstractC7806cz.m48178h(attributeValue2).intValue());
        HashMap map = new HashMap();
        m47074a(map, nonLinear, xmlPullParser);
        ArrayList arrayList = new ArrayList();
        mo47079a(xmlPullParser, arrayList, map);
        C7632rh.m47093a(xmlPullParser, map, (List<String>) Collections.emptyList());
        nonLinear.m40992a(arrayList);
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a("BaseNonLinearParser", "readNonlinear finish, nonLinear: %s", AbstractC7758be.m47742b(nonLinear));
        }
        return nonLinear;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public Map<String, List<Tracking>> m47076b(final XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        if (xmlPullParser == null) {
            return null;
        }
        AbstractC7185ho.m43820b("BaseNonLinearParser", "start read tracking events");
        xmlPullParser.require(2, VastTag.NAMESPACE, VastTag.TRACKING_EVENTS);
        final HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        map2.put(VastTag.TRACKING, new C7632rh.a() { // from class: com.huawei.openalliance.ad.rb.3
            @Override // com.huawei.openalliance.p169ad.C7632rh.a
            /* renamed from: a */
            public void mo47067a() throws XmlPullParserException, IOException {
                String attributeValue = xmlPullParser.getAttributeValue(VastTag.NAMESPACE, "event");
                String strM47087a = C7632rh.m47087a(xmlPullParser);
                if (AbstractC7626rb.this.mo47077a().contains(attributeValue)) {
                    if (map.get(attributeValue) == null) {
                        map.put(attributeValue, new ArrayList());
                    }
                    ((List) map.get(attributeValue)).add(new Tracking(strM47087a, attributeValue));
                }
            }
        });
        C7632rh.m47093a(xmlPullParser, map2, (List<String>) Collections.emptyList());
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a("BaseNonLinearParser", "read tracking events finish, trackingEvents: %s", map);
        }
        return map;
    }

    /* renamed from: a */
    public void m47078a(final NonLinearAds nonLinearAds, final XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        if (nonLinearAds == null || xmlPullParser == null) {
            return;
        }
        AbstractC7185ho.m43820b("BaseNonLinearParser", "read nonlinearAds start");
        final ArrayList arrayList = new ArrayList();
        HashMap map = new HashMap();
        map.put(VastTag.NON_LINEAR, new C7632rh.a() { // from class: com.huawei.openalliance.ad.rb.1
            @Override // com.huawei.openalliance.p169ad.C7632rh.a
            /* renamed from: a */
            public void mo47067a() {
                arrayList.add(AbstractC7626rb.this.m47073a(xmlPullParser));
            }
        });
        map.put(VastTag.TRACKING_EVENTS, new C7632rh.a() { // from class: com.huawei.openalliance.ad.rb.2
            @Override // com.huawei.openalliance.p169ad.C7632rh.a
            /* renamed from: a */
            public void mo47067a() {
                nonLinearAds.m41000a(AbstractC7626rb.this.m47076b(xmlPullParser));
            }
        });
        C7632rh.m47093a(xmlPullParser, map, (List<String>) Collections.singletonList(VastTag.NON_LINEAR));
        AbstractC7185ho.m43818a("BaseNonLinearParser", "nonLinearAds setNonLinears: %s", AbstractC7758be.m47742b(arrayList));
        nonLinearAds.m40999a(arrayList);
    }

    /* renamed from: a */
    private void m47074a(Map<String, C7632rh.a> map, NonLinear nonLinear, XmlPullParser xmlPullParser) {
        if (map == null) {
            return;
        }
        for (String str : f35529a) {
            map.put(str, new C7638rn(str, nonLinear, xmlPullParser));
        }
    }
}
