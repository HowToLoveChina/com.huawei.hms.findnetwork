package com.huawei.openalliance.p169ad;

import android.text.TextUtils;
import com.huawei.openalliance.p169ad.C7632rh;
import com.huawei.openalliance.p169ad.beans.vast.ClickThrough;
import com.huawei.openalliance.p169ad.beans.vast.LinearCreative;
import com.huawei.openalliance.p169ad.beans.vast.Tracking;
import com.huawei.openalliance.p169ad.beans.vast.VastContent;
import com.huawei.openalliance.p169ad.beans.vast.VastMediaFile;
import com.huawei.openalliance.p169ad.beans.vast.VideoClicks;
import com.huawei.openalliance.p169ad.constant.VastAttribute;
import com.huawei.openalliance.p169ad.constant.VastTag;
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

/* renamed from: com.huawei.openalliance.ad.ra */
/* loaded from: classes8.dex */
public abstract class AbstractC7625ra {

    /* renamed from: com.huawei.openalliance.ad.ra$a */
    public static class a implements C7632rh.a {

        /* renamed from: a */
        private final LinearCreative f35513a;

        /* renamed from: b */
        private final XmlPullParser f35514b;

        public a(LinearCreative linearCreative, XmlPullParser xmlPullParser) {
            this.f35513a = linearCreative;
            this.f35514b = xmlPullParser;
        }

        @Override // com.huawei.openalliance.p169ad.C7632rh.a
        /* renamed from: a */
        public void mo47067a() {
            LinearCreative linearCreative = this.f35513a;
            if (linearCreative != null) {
                linearCreative.m40979a(AbstractC7806cz.m48145a(C7632rh.m47086a(C7632rh.m47087a(this.f35514b)), 0));
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.ra$b */
    public static class b implements C7632rh.a {

        /* renamed from: a */
        private final List<VastMediaFile> f35515a;

        /* renamed from: b */
        private final XmlPullParser f35516b;

        public b(List<VastMediaFile> list, XmlPullParser xmlPullParser) {
            this.f35515a = list;
            this.f35516b = xmlPullParser;
        }

        /* renamed from: a */
        private VastMediaFile m47068a(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
            if (xmlPullParser == null) {
                return null;
            }
            AbstractC7185ho.m43817a("BaseLinearParser", "start read media file");
            String str = VastTag.NAMESPACE;
            xmlPullParser.require(2, str, VastTag.MEDIA_FILE);
            VastMediaFile vastMediaFile = new VastMediaFile();
            vastMediaFile.m41039b(xmlPullParser.getAttributeValue(str, VastAttribute.DELIVERY));
            String attributeValue = xmlPullParser.getAttributeValue(str, "height");
            String attributeValue2 = xmlPullParser.getAttributeValue(str, "width");
            if (TextUtils.isEmpty(attributeValue) || TextUtils.isEmpty(attributeValue2)) {
                AbstractC7185ho.m43820b("BaseLinearParser", "media file missing required attribute");
                return null;
            }
            int iM48145a = AbstractC7806cz.m48145a(attributeValue, 0);
            int iM48145a2 = AbstractC7806cz.m48145a(attributeValue2, 0);
            if (iM48145a == 0 || iM48145a2 == 0) {
                AbstractC7185ho.m43817a("BaseLinearParser", "media file height or width is invalid.");
                return null;
            }
            vastMediaFile.m41038b(iM48145a);
            vastMediaFile.m41035a(iM48145a2);
            vastMediaFile.m41036a(xmlPullParser.getAttributeValue(str, "id"));
            vastMediaFile.m41041c(C7632rh.m47088a(xmlPullParser, "type"));
            String strM47087a = C7632rh.m47087a(xmlPullParser);
            if (TextUtils.isEmpty(strM47087a) || strM47087a.trim().isEmpty()) {
                AbstractC7185ho.m43826d("BaseLinearParser", "media file url not be empty");
                return null;
            }
            vastMediaFile.m41043d(strM47087a);
            return vastMediaFile;
        }

        @Override // com.huawei.openalliance.p169ad.C7632rh.a
        /* renamed from: a */
        public void mo47067a() {
            List<VastMediaFile> list = this.f35515a;
            if (list != null) {
                list.add(m47068a(this.f35516b));
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.ra$c */
    public static class c implements C7632rh.a {

        /* renamed from: a */
        private final LinearCreative f35517a;

        /* renamed from: b */
        private final XmlPullParser f35518b;

        /* renamed from: com.huawei.openalliance.ad.ra$c$a */
        public static class a implements C7632rh.a {

            /* renamed from: a */
            private final XmlPullParser f35519a;

            /* renamed from: b */
            private final Map<String, List<Tracking>> f35520b;

            public a(XmlPullParser xmlPullParser, Map<String, List<Tracking>> map) {
                this.f35519a = xmlPullParser;
                this.f35520b = map;
            }

            @Override // com.huawei.openalliance.p169ad.C7632rh.a
            /* renamed from: a */
            public void mo47067a() throws XmlPullParserException, IOException {
                XmlPullParser xmlPullParser = this.f35519a;
                if (xmlPullParser == null || this.f35520b == null) {
                    return;
                }
                String attributeValue = xmlPullParser.getAttributeValue(VastTag.NAMESPACE, "event");
                String strM47087a = C7632rh.m47087a(this.f35519a);
                if (C7633ri.m47101c().mo47064a().contains(attributeValue)) {
                    if (this.f35520b.get(attributeValue) == null) {
                        this.f35520b.put(attributeValue, new ArrayList());
                    }
                    this.f35520b.get(attributeValue).add(new Tracking(strM47087a, attributeValue));
                }
            }
        }

        public c(LinearCreative linearCreative, XmlPullParser xmlPullParser) {
            this.f35517a = linearCreative;
            this.f35518b = xmlPullParser;
        }

        /* renamed from: a */
        private Map<String, List<Tracking>> m47069a(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
            if (xmlPullParser == null) {
                return null;
            }
            AbstractC7185ho.m43817a("BaseLinearParser", "start read tracking events");
            xmlPullParser.require(2, VastTag.NAMESPACE, VastTag.TRACKING_EVENTS);
            HashMap map = new HashMap();
            HashMap map2 = new HashMap();
            map2.put(VastTag.TRACKING, new a(xmlPullParser, map));
            C7632rh.m47093a(xmlPullParser, map2, (List<String>) Collections.emptyList());
            AbstractC7185ho.m43818a("BaseLinearParser", "read tracking events finish, tracking events: %s", map);
            return map;
        }

        @Override // com.huawei.openalliance.p169ad.C7632rh.a
        /* renamed from: a */
        public void mo47067a() {
            LinearCreative linearCreative = this.f35517a;
            if (linearCreative != null) {
                linearCreative.m40982a(m47069a(this.f35518b));
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.ra$d */
    public static class d implements C7632rh.a {

        /* renamed from: a */
        private final XmlPullParser f35521a;

        /* renamed from: b */
        private final LinearCreative f35522b;

        public d(LinearCreative linearCreative, XmlPullParser xmlPullParser) {
            this.f35521a = xmlPullParser;
            this.f35522b = linearCreative;
        }

        @Override // com.huawei.openalliance.p169ad.C7632rh.a
        /* renamed from: a */
        public void mo47067a() throws XmlPullParserException, IOException {
            XmlPullParser xmlPullParser = this.f35521a;
            if (xmlPullParser == null || this.f35522b == null) {
                return;
            }
            xmlPullParser.require(2, VastTag.NAMESPACE, VastTag.MEDIA_FILES);
            ArrayList arrayList = new ArrayList();
            HashMap map = new HashMap();
            map.put(VastTag.MEDIA_FILE, new b(arrayList, this.f35521a));
            C7632rh.m47093a(this.f35521a, map, (List<String>) Collections.singletonList(VastTag.MEDIA_FILE));
            this.f35522b.m40981a(arrayList);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.ra$e */
    public static class e implements C7632rh.a {

        /* renamed from: a */
        private final VideoClicks f35523a;

        /* renamed from: b */
        private final XmlPullParser f35524b;

        public e(VideoClicks videoClicks, XmlPullParser xmlPullParser) {
            this.f35523a = videoClicks;
            this.f35524b = xmlPullParser;
        }

        /* renamed from: a */
        private ClickThrough m47070a(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
            if (xmlPullParser == null) {
                return null;
            }
            AbstractC7185ho.m43817a("BaseLinearParser", "start read click through");
            String str = VastTag.NAMESPACE;
            xmlPullParser.require(2, str, VastTag.CLICK_THROUGH);
            ClickThrough clickThrough = new ClickThrough();
            clickThrough.m40971a(xmlPullParser.getAttributeValue(str, "id"));
            clickThrough.m40972b(C7632rh.m47087a(xmlPullParser));
            AbstractC7185ho.m43818a("BaseLinearParser", "finish read click trough: %s", clickThrough);
            return clickThrough;
        }

        @Override // com.huawei.openalliance.p169ad.C7632rh.a
        /* renamed from: a */
        public void mo47067a() {
            VideoClicks videoClicks = this.f35523a;
            if (videoClicks != null) {
                videoClicks.m41045a(m47070a(this.f35524b));
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.ra$f */
    public static class f implements C7632rh.a {

        /* renamed from: a */
        private final LinearCreative f35525a;

        /* renamed from: b */
        private final XmlPullParser f35526b;

        /* renamed from: com.huawei.openalliance.ad.ra$f$a */
        public static class a implements C7632rh.a {

            /* renamed from: a */
            private final XmlPullParser f35527a;

            /* renamed from: b */
            private final List<Tracking> f35528b;

            public a(XmlPullParser xmlPullParser, List<Tracking> list) {
                this.f35527a = xmlPullParser;
                this.f35528b = list;
            }

            @Override // com.huawei.openalliance.p169ad.C7632rh.a
            /* renamed from: a */
            public void mo47067a() throws XmlPullParserException, IOException {
                XmlPullParser xmlPullParser = this.f35527a;
                if (xmlPullParser == null || this.f35528b == null) {
                    return;
                }
                String attributeValue = xmlPullParser.getAttributeValue(VastTag.NAMESPACE, "id");
                this.f35528b.add(new Tracking(C7632rh.m47087a(this.f35527a), attributeValue));
            }
        }

        public f(LinearCreative linearCreative, XmlPullParser xmlPullParser) {
            this.f35525a = linearCreative;
            this.f35526b = xmlPullParser;
        }

        /* renamed from: a */
        private VideoClicks m47071a(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
            if (xmlPullParser == null) {
                return null;
            }
            AbstractC7185ho.m43817a("BaseLinearParser", "start read video clicks");
            xmlPullParser.require(2, VastTag.NAMESPACE, VastTag.VIDEO_CLICKS);
            VideoClicks videoClicks = new VideoClicks();
            ArrayList arrayList = new ArrayList();
            HashMap map = new HashMap();
            map.put(VastTag.CLICK_THROUGH, new e(videoClicks, xmlPullParser));
            map.put("ClickTracking", new a(xmlPullParser, arrayList));
            C7632rh.m47093a(xmlPullParser, map, (List<String>) Collections.emptyList());
            videoClicks.m41046a(arrayList);
            AbstractC7185ho.m43818a("BaseLinearParser", "finish read video clicks, video clicks: %s", videoClicks);
            return videoClicks;
        }

        @Override // com.huawei.openalliance.p169ad.C7632rh.a
        /* renamed from: a */
        public void mo47067a() {
            LinearCreative linearCreative = this.f35525a;
            if (linearCreative != null) {
                linearCreative.m40980a(m47071a(this.f35526b));
            }
        }
    }

    /* renamed from: b */
    private void m47063b(LinearCreative linearCreative, XmlPullParser xmlPullParser, Map<String, C7632rh.a> map) {
        if (map == null) {
            return;
        }
        map.put(VastTag.DURATION, new a(linearCreative, xmlPullParser));
        map.put(VastTag.MEDIA_FILES, new d(linearCreative, xmlPullParser));
        map.put(VastTag.VIDEO_CLICKS, new f(linearCreative, xmlPullParser));
        map.put(VastTag.TRACKING_EVENTS, new c(linearCreative, xmlPullParser));
        mo47066a(linearCreative, xmlPullParser, map);
    }

    /* renamed from: a */
    public abstract Set<String> mo47064a();

    /* renamed from: a */
    public void m47065a(LinearCreative linearCreative, XmlPullParser xmlPullParser, VastContent vastContent) throws XmlPullParserException, IOException {
        if (linearCreative == null || xmlPullParser == null || vastContent == null) {
            return;
        }
        AbstractC7185ho.m43817a("BaseLinearParser", "start read linear creative");
        xmlPullParser.require(2, VastTag.NAMESPACE, VastTag.LINEAR);
        HashMap map = new HashMap();
        m47063b(linearCreative, xmlPullParser, map);
        C7632rh.m47093a(xmlPullParser, map, (List<String>) (vastContent.m41022g().booleanValue() ? Collections.emptyList() : Arrays.asList(VastTag.DURATION, VastTag.MEDIA_FILES)));
        AbstractC7185ho.m43817a("BaseLinearParser", "read linear creative finish");
    }

    /* renamed from: a */
    public abstract void mo47066a(LinearCreative linearCreative, XmlPullParser xmlPullParser, Map<String, C7632rh.a> map);
}
