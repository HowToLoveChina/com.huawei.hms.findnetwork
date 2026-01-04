package com.huawei.openalliance.p169ad;

import com.huawei.openalliance.p169ad.C7632rh;
import com.huawei.openalliance.p169ad.beans.vast.Vast;
import com.huawei.openalliance.p169ad.beans.vast.VastContent;
import com.huawei.openalliance.p169ad.constant.VastTag;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: com.huawei.openalliance.ad.rc */
/* loaded from: classes8.dex */
public abstract class AbstractC7627rc {

    /* renamed from: com.huawei.openalliance.ad.rc$a */
    public static class a implements C7632rh.a {

        /* renamed from: a */
        private XmlPullParser f35541a;

        /* renamed from: b */
        private VastContent f35542b;

        public a(XmlPullParser xmlPullParser, VastContent vastContent) {
            this.f35541a = xmlPullParser;
            this.f35542b = vastContent;
        }

        @Override // com.huawei.openalliance.p169ad.C7632rh.a
        /* renamed from: a */
        public void mo47067a() throws XmlPullParserException, IOException {
            VastContent vastContent = this.f35542b;
            if (vastContent == null || this.f35541a == null) {
                return;
            }
            AbstractC7185ho.m43821b("BaseVastParser", "read inline, %s.", vastContent.m41008a());
            C7632rh.m47095b(this.f35541a, this.f35542b);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.rc$b */
    public static class b implements C7632rh.a {

        /* renamed from: a */
        private final XmlPullParser f35543a;

        /* renamed from: b */
        private final VastContent f35544b;

        public b(XmlPullParser xmlPullParser, VastContent vastContent) {
            this.f35543a = xmlPullParser;
            this.f35544b = vastContent;
        }

        @Override // com.huawei.openalliance.p169ad.C7632rh.a
        /* renamed from: a */
        public void mo47067a() throws XmlPullParserException, IOException {
            VastContent vastContent = this.f35544b;
            if (vastContent == null || this.f35543a == null) {
                return;
            }
            AbstractC7185ho.m43821b("BaseVastParser", "read warpper, %s.", vastContent.m41008a());
            C7632rh.m47091a(this.f35543a, this.f35544b);
        }
    }

    /* renamed from: b */
    public static Vast m47080b(final XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        HashMap map = new HashMap();
        final ArrayList arrayList = new ArrayList();
        map.put(VastTag.f32148AD, new C7632rh.a() { // from class: com.huawei.openalliance.ad.rc.1
            @Override // com.huawei.openalliance.p169ad.C7632rh.a
            /* renamed from: a */
            public void mo47067a() {
                arrayList.add(AbstractC7627rc.m47081c(xmlPullParser));
            }
        });
        C7632rh.m47093a(xmlPullParser, map, (List<String>) Collections.emptyList());
        return new Vast(arrayList);
    }

    /* renamed from: c */
    public static VastContent m47081c(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        String str = VastTag.NAMESPACE;
        xmlPullParser.require(2, str, VastTag.f32148AD);
        VastContent vastContent = new VastContent();
        vastContent.m41010a(xmlPullParser.getAttributeValue(str, "id"));
        C7633ri.m47098a().mo47083a(xmlPullParser, vastContent);
        HashMap map = new HashMap();
        map.put(VastTag.INLINE, new a(xmlPullParser, vastContent));
        map.put(VastTag.WRAPPER, new b(xmlPullParser, vastContent));
        try {
            C7632rh.m47093a(xmlPullParser, map, (List<String>) Collections.emptyList());
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("BaseVastParser", "attribute format error: %s", th2.getClass().getSimpleName());
        }
        return vastContent;
    }

    /* renamed from: a */
    public abstract List<VastContent> mo47082a(XmlPullParser xmlPullParser);

    /* renamed from: a */
    public abstract void mo47083a(XmlPullParser xmlPullParser, VastContent vastContent);
}
