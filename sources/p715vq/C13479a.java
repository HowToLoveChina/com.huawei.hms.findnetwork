package p715vq;

import android.content.Context;
import com.huawei.fastengine.fastview.NavigationUtils;
import com.huawei.hwidauth.utils.globalcfg.CountryInfoForCFG;
import com.huawei.hwidauth.utils.globalcfg.SiteInfoForCFG;
import java.io.IOException;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import p640sq.C12835n;
import p640sq.C12836o;

/* renamed from: vq.a */
/* loaded from: classes8.dex */
public class C13479a {

    /* renamed from: a */
    public final String f60699a;

    /* renamed from: b */
    public final String f60700b;

    /* renamed from: c */
    public final String f60701c;

    /* renamed from: d */
    public final String f60702d;

    /* renamed from: e */
    public final String f60703e;

    /* renamed from: f */
    public final String f60704f;

    /* renamed from: g */
    public final String f60705g;

    /* renamed from: h */
    public final String f60706h;

    /* renamed from: i */
    public final String f60707i;

    /* renamed from: j */
    public final String f60708j;

    /* renamed from: k */
    public final String f60709k;

    /* renamed from: l */
    public final String f60710l;

    /* renamed from: m */
    public final String f60711m;

    /* renamed from: n */
    public final String f60712n;

    /* renamed from: o */
    public final String f60713o;

    /* renamed from: p */
    public final String f60714p;

    /* renamed from: vq.a$b */
    public static class b {

        /* renamed from: a */
        public static C13479a f60715a = new C13479a();
    }

    /* renamed from: b */
    public static C13479a m81158b() {
        return b.f60715a;
    }

    /* renamed from: a */
    public List<CountryInfoForCFG> m81159a(Context context, List<CountryInfoForCFG> list, List<CountryInfoForCFG> list2, List<SiteInfoForCFG> list3) throws XmlPullParserException, IOException {
        if (context == null) {
            C12836o.m77098c(this.f60699a, "parseSiteCountryXML mContext == null", true);
            return list;
        }
        try {
            XmlPullParser xmlPullParserM77090c = C12835n.m77090c(context, C12835n.m77094g(context), C12835n.m77089b(context));
            for (int eventType = xmlPullParserM77090c.getEventType(); 1 != eventType; eventType = xmlPullParserM77090c.next()) {
                String name = xmlPullParserM77090c.getName();
                if (eventType == 2) {
                    m81162e(xmlPullParserM77090c, list, list2, list3, name);
                }
            }
        } catch (IOException unused) {
            C12836o.m77099d(this.f60699a, "parseXMLGetCountryList IOException", true);
        } catch (XmlPullParserException unused2) {
            C12836o.m77099d(this.f60699a, "parseXMLGetCountryList XmlPullParserException", true);
        }
        return list;
    }

    /* renamed from: c */
    public final void m81160c(XmlPullParser xmlPullParser, List<SiteInfoForCFG> list) {
        SiteInfoForCFG siteInfoForCFG = new SiteInfoForCFG();
        for (int i10 = 0; i10 < xmlPullParser.getAttributeCount(); i10++) {
            String attributeName = xmlPullParser.getAttributeName(i10);
            String attributeValue = xmlPullParser.getAttributeValue(i10) == null ? "" : xmlPullParser.getAttributeValue(i10);
            if ("id".equals(attributeName)) {
                siteInfoForCFG.m38270c(attributeValue);
            } else if ("name-zh".equals(attributeName)) {
                siteInfoForCFG.m38272e(attributeValue);
            } else if ("name-en".equals(attributeName)) {
                siteInfoForCFG.m38273f(attributeValue);
            } else if ("register".equals(attributeName)) {
                siteInfoForCFG.m38274g(attributeValue);
            }
        }
        list.add(siteInfoForCFG);
    }

    /* renamed from: d */
    public final void m81161d(XmlPullParser xmlPullParser, List<CountryInfoForCFG> list, List<CountryInfoForCFG> list2, String str) {
        CountryInfoForCFG countryInfoForCFG = new CountryInfoForCFG();
        for (int i10 = 0; i10 < xmlPullParser.getAttributeCount(); i10++) {
            String attributeName = xmlPullParser.getAttributeName(i10);
            String attributeValue = xmlPullParser.getAttributeValue(i10) == null ? "" : xmlPullParser.getAttributeValue(i10);
            if ("site-id".equals(attributeName)) {
                countryInfoForCFG.m38256c(attributeValue);
            } else if ("name-zh".equals(attributeName)) {
                countryInfoForCFG.m38258e(attributeValue);
            } else if ("name-en".equals(attributeName)) {
                countryInfoForCFG.m38260g(attributeValue);
            } else if ("iso-2code".equals(attributeName)) {
                countryInfoForCFG.m38262i(attributeValue);
            } else if ("tel-code".equals(attributeName)) {
                countryInfoForCFG.m38263j(attributeValue);
            } else if ("mcc".equals(attributeName)) {
                countryInfoForCFG.m38264l(attributeValue);
            } else if (NavigationUtils.SMS_SCHEMA_PREF.equals(attributeName)) {
                countryInfoForCFG.m38265m(attributeValue);
            } else if ("register".equals(attributeName)) {
                countryInfoForCFG.m38266n(attributeValue);
            }
        }
        if ("country".equals(str)) {
            list.add(countryInfoForCFG);
        } else {
            list2.add(countryInfoForCFG);
        }
    }

    /* renamed from: e */
    public final void m81162e(XmlPullParser xmlPullParser, List<CountryInfoForCFG> list, List<CountryInfoForCFG> list2, List<SiteInfoForCFG> list3, String str) {
        if ("country".equals(str) || "country-plus".equals(str)) {
            m81161d(xmlPullParser, list, list2, str);
        } else if ("site".equals(str)) {
            m81160c(xmlPullParser, list3);
        }
    }

    public C13479a() {
        this.f60699a = C13479a.class.getSimpleName();
        this.f60700b = "country";
        this.f60701c = "country-plus";
        this.f60702d = "site-id";
        this.f60703e = "name-zh";
        this.f60704f = "name-en";
        this.f60705g = "iso-2code";
        this.f60706h = "tel-code";
        this.f60707i = "mcc";
        this.f60708j = NavigationUtils.SMS_SCHEMA_PREF;
        this.f60709k = "register";
        this.f60710l = "site";
        this.f60711m = "id";
        this.f60712n = "name-zh";
        this.f60713o = "name-en";
        this.f60714p = "register";
    }
}
