package com.huawei.openalliance.p169ad.analysis;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.location.Address;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C6982bz;
import com.huawei.openalliance.p169ad.C7124fh;
import com.huawei.openalliance.p169ad.InterfaceC7146gc;
import com.huawei.openalliance.p169ad.beans.metadata.DelayInfo;
import com.huawei.openalliance.p169ad.beans.metadata.GeoLocation;
import com.huawei.openalliance.p169ad.constant.ApiNames;
import com.huawei.openalliance.p169ad.constant.Config;
import com.huawei.openalliance.p169ad.constant.OsType;
import com.huawei.openalliance.p169ad.inter.data.AdLandingPageData;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7758be;
import com.huawei.openalliance.p169ad.utils.AbstractC7760bg;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.AbstractC7807d;
import com.huawei.openalliance.p169ad.utils.C7733ag;
import com.huawei.openalliance.p169ad.utils.C7734ah;
import com.huawei.openalliance.p169ad.utils.C7775bv;
import com.huawei.openalliance.p169ad.utils.C7787cg;
import com.huawei.openalliance.p169ad.utils.C7830i;
import com.huawei.openalliance.p169ad.utils.C7845x;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* renamed from: com.huawei.openalliance.ad.analysis.f */
/* loaded from: classes8.dex */
public abstract class AbstractC6925f {

    /* renamed from: a */
    protected Context f31973a;

    public AbstractC6925f(Context context) {
        this.f31973a = context.getApplicationContext();
    }

    /* renamed from: b */
    private long m39150b(String str) {
        return Math.max(AbstractC7806cz.m48146a(str, 0L), 0L);
    }

    /* renamed from: a */
    public C6921b m39152a() {
        return m39157a("");
    }

    /* renamed from: f */
    public C6921b m39167f(ContentRecord contentRecord) {
        return m39156a(contentRecord, true);
    }

    /* renamed from: b */
    public static void m39151b(Context context, C6921b c6921b) {
        C7733ag.a aVarM47474a;
        if (c6921b == null || !C7733ag.m47475b(context) || (aVarM47474a = C7733ag.m47474a(context)) == null) {
            return;
        }
        c6921b.m38928W(aVarM47474a.m47479a());
        c6921b.m38930X(aVarM47474a.m47480b() ? "0" : "1");
    }

    /* renamed from: a */
    public C6921b m39153a(int i10) {
        C6921b c6921bM39152a = m39152a();
        if (c6921bM39152a != null) {
            c6921bM39152a.m39003d(i10);
        }
        return c6921bM39152a;
    }

    /* renamed from: a */
    public C6921b m39154a(C6921b c6921b, ContentRecord contentRecord) {
        if (contentRecord != null && c6921b != null) {
            c6921b.m39031o(contentRecord.m41585m());
            c6921b.m39033p(contentRecord.m41588n());
            c6921b.m38936a(contentRecord.m41552f());
            c6921b.m38898H(contentRecord.m41591o());
            c6921b.m38939a(Integer.valueOf(contentRecord.m41392E()));
            c6921b.m38994b(Integer.valueOf(contentRecord.m41573j()));
            c6921b.m39039s(contentRecord.m41486ah());
            c6921b.m38973aj(contentRecord.m41529bp() == null ? C7787cg.m47900a(this.f31973a).m47959ab() : contentRecord.m41529bp());
            c6921b.m39003d(contentRecord.m41492an());
        }
        return c6921b;
    }

    /* renamed from: b */
    public void m39166b(C6921b c6921b) {
        InterfaceC7146gc interfaceC7146gcM43316b = C7124fh.m43316b(this.f31973a);
        if (!interfaceC7146gcM43316b.mo43025C()) {
            AbstractC7185ho.m43820b("AnalysisReport", "clctStatData is off");
            return;
        }
        AbstractC7185ho.m43817a("AnalysisReport", "clctStatData is on");
        int iMo43026D = interfaceC7146gcM43316b.mo43026D();
        AbstractC7185ho.m43818a("AnalysisReport", "StatData interval is %d", Integer.valueOf(iMo43026D));
        c6921b.m38900I(AbstractC7806cz.m48185n(C7845x.m48533a(this.f31973a, iMo43026D)));
        c6921b.m38902J(C7845x.m48540b(this.f31973a, iMo43026D));
        c6921b.m38999c(C7845x.m48543c(this.f31973a, iMo43026D));
        c6921b.m38904K(C7845x.m48549d(this.f31973a, iMo43026D));
        c6921b.m38906L(String.valueOf(C7845x.m48553e(this.f31973a, iMo43026D)));
        c6921b.m38908M(String.valueOf(C7845x.m48558f(this.f31973a, iMo43026D)));
        c6921b.m38912O(C7845x.m48572i(this.f31973a, iMo43026D));
        c6921b.m38914P(C7845x.m48574j(this.f31973a, iMo43026D));
    }

    /* renamed from: a */
    public C6921b m39155a(C6921b c6921b, AdLandingPageData adLandingPageData) {
        if (adLandingPageData != null && c6921b != null) {
            c6921b.m39031o(adLandingPageData.getSlotId());
            c6921b.m39033p(adLandingPageData.getContentId());
            c6921b.m38936a(adLandingPageData.getAdType());
            c6921b.m39003d(adLandingPageData.m44321u());
        }
        return c6921b;
    }

    /* renamed from: a */
    public C6921b m39156a(ContentRecord contentRecord, boolean z10) {
        return m39154a(m39159a(z10), contentRecord);
    }

    /* renamed from: a */
    public C6921b m39157a(String str) {
        StringBuilder sb2;
        String str2;
        Pair pair;
        PackageInfo packageInfoM48408a;
        try {
            PackageManager packageManager = this.f31973a.getPackageManager();
            String strMo41176e = C6982bz.m41148a(this.f31973a).mo41176e();
            if (packageManager == null) {
                return null;
            }
            C6921b c6921b = new C6921b();
            c6921b.m38941a(AbstractC7741ao.m47545a("yyyy-MM-dd HH:mm:ss.SSSZ").format(new Date()));
            String strM47959ab = C7787cg.m47900a(this.f31973a).m47959ab();
            if (strM47959ab != null) {
                c6921b.m38973aj(strM47959ab);
            }
            c6921b.m38995b(Config.SDK_VERSION);
            if (TextUtils.isEmpty(str)) {
                str = this.f31973a.getPackageName();
            }
            c6921b.m39023k(str);
            if (C7830i.m48419a(this.f31973a, str) && (packageInfoM48408a = C7830i.m48408a(packageManager, str, 16384)) != null) {
                c6921b.m39021j(packageInfoM48408a.versionName);
                c6921b.m39019i(C7830i.m48430c(this.f31973a, str));
            }
            c6921b.m39000c(OsType.ANDROID);
            c6921b.m39015g(AbstractC7807d.m48204a());
            c6921b.m39005d(Build.VERSION.RELEASE);
            c6921b.m39017h(C6982bz.m41148a(this.f31973a).mo41174c());
            String str3 = Build.MANUFACTURER;
            Locale locale = Locale.ENGLISH;
            c6921b.m39010e(str3.toUpperCase(locale));
            if (TextUtils.isEmpty(strMo41176e)) {
                strMo41176e = C6982bz.m41148a(this.f31973a).mo41180i();
            }
            c6921b.m38892E(strMo41176e);
            c6921b.m38969ah(C7845x.m48531a());
            String strMo41173b = C6982bz.m41148a(this.f31973a).mo41173b();
            if (strMo41173b != null) {
                strMo41173b = strMo41173b.toUpperCase(locale);
            }
            c6921b.m39013f(strMo41173b);
            c6921b.m39025l(String.valueOf(C7775bv.m47830d(this.f31973a)));
            Pair<Integer, Pair<String, String>> pairM47832f = C7775bv.m47832f(this.f31973a);
            if (pairM47832f != null && (pair = (Pair) pairM47832f.second) != null) {
                c6921b.m39027m((String) pair.first);
                c6921b.m39029n((String) pair.second);
            }
            return c6921b;
        } catch (RuntimeException e10) {
            e = e10;
            sb2 = new StringBuilder();
            str2 = "createAnalysisInfo RuntimeException:";
            sb2.append(str2);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43823c("AnalysisReport", sb2.toString());
            return null;
        } catch (Exception e11) {
            e = e11;
            sb2 = new StringBuilder();
            str2 = "createAnalysisInfo Exception:";
            sb2.append(str2);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43823c("AnalysisReport", sb2.toString());
            return null;
        }
    }

    /* renamed from: a */
    public C6921b m39158a(String str, boolean z10) {
        C6921b c6921bM39157a = m39157a(str);
        if (c6921bM39157a != null && z10) {
            m39149a(this.f31973a, c6921bM39157a);
        }
        m39151b(this.f31973a, c6921bM39157a);
        return c6921bM39157a;
    }

    /* renamed from: a */
    public C6921b m39159a(boolean z10) {
        C6921b c6921bM39152a = m39152a();
        if (c6921bM39152a != null && z10) {
            m39149a(this.f31973a, c6921bM39152a);
        }
        m39151b(this.f31973a, c6921bM39152a);
        return c6921bM39152a;
    }

    /* renamed from: a */
    public C6921b m39160a(boolean z10, int i10) {
        C6921b c6921bM39159a = m39159a(z10);
        if (c6921bM39159a != null) {
            c6921bM39159a.m39003d(i10);
        }
        return c6921bM39159a;
    }

    /* renamed from: a */
    public static void m39149a(Context context, C6921b c6921b) {
        Pair<String, Boolean> pairM48217b;
        if (c6921b == null || (pairM48217b = AbstractC7807d.m48217b(context, true)) == null) {
            return;
        }
        c6921b.m38888C(((Boolean) pairM48217b.second).booleanValue() ? "0" : "1");
        c6921b.m39049x((String) pairM48217b.first);
    }

    /* renamed from: a */
    public void m39161a(C6921b c6921b) {
        String str;
        InterfaceC7146gc interfaceC7146gcM43316b = C7124fh.m43316b(this.f31973a);
        if (interfaceC7146gcM43316b.mo43024B()) {
            int iMo43026D = interfaceC7146gcM43316b.mo43026D();
            AbstractC7185ho.m43818a("AnalysisReport", "DyncData interval is %d", Integer.valueOf(iMo43026D));
            c6921b.m38910N(String.valueOf(C7845x.m48564g(this.f31973a, iMo43026D)));
            c6921b.m38918R(C7845x.m48578k(this.f31973a, iMo43026D));
            c6921b.m38920S(C7845x.m48580l(this.f31973a, iMo43026D));
            c6921b.m38922T(C7845x.m48584m(this.f31973a, iMo43026D));
            c6921b.m38924U(C7845x.m48586n(this.f31973a, iMo43026D));
            c6921b.m39004d(C7845x.m48589o(this.f31973a, iMo43026D));
            c6921b.m39009e(C7845x.m48592p(this.f31973a, iMo43026D));
            c6921b.m38942a(C7845x.m48596q(this.f31973a, iMo43026D));
            c6921b.m38996b(C7845x.m48600r(this.f31973a, iMo43026D));
            c6921b.m39001c(C7845x.m48603s(this.f31973a, iMo43026D));
            c6921b.m39006d(C7845x.m48606t(this.f31973a, iMo43026D));
            str = "clctStatData is off" + C7845x.m48603s(this.f31973a, iMo43026D);
        } else {
            str = "clctDyncData is off";
        }
        AbstractC7185ho.m43820b("AnalysisReport", str);
    }

    /* renamed from: a */
    public void m39162a(C6921b c6921b, BaseAnalysisInfo baseAnalysisInfo) {
        if (c6921b == null || baseAnalysisInfo == null) {
            return;
        }
        c6921b.m38827ak(baseAnalysisInfo.m38812aL());
        c6921b.m38850c(baseAnalysisInfo.m38813aM());
        c6921b.m38828al(baseAnalysisInfo.m38814aN());
        c6921b.m38829am(baseAnalysisInfo.m38815aO());
        c6921b.m38830an(baseAnalysisInfo.m38816aP());
        c6921b.m38831ao(baseAnalysisInfo.m38817aQ());
        c6921b.m38832ap(baseAnalysisInfo.m38818aR());
        c6921b.m38833aq(baseAnalysisInfo.m38819aS());
        c6921b.m38834ar(baseAnalysisInfo.m38820aT());
        c6921b.m38835as(baseAnalysisInfo.m38821aU());
        c6921b.m38836at(baseAnalysisInfo.m38822aV());
        c6921b.m38837au(baseAnalysisInfo.m38823aW());
        c6921b.m38851d(baseAnalysisInfo.m38824aX());
        c6921b.m38852e(baseAnalysisInfo.m38825aY());
        c6921b.m38853f(baseAnalysisInfo.m38826aZ());
        c6921b.m38854g(baseAnalysisInfo.m38838ba());
        c6921b.m38855h(baseAnalysisInfo.m38839bb());
        c6921b.m38856i(baseAnalysisInfo.m38840bc());
        c6921b.m38857j(baseAnalysisInfo.m38841bd());
        c6921b.m38858k(baseAnalysisInfo.m38842be());
        c6921b.m38859l(baseAnalysisInfo.m38843bf());
        c6921b.m38860m(baseAnalysisInfo.m38844bg());
        c6921b.m38861n(baseAnalysisInfo.m38845bh());
        c6921b.m38862o(baseAnalysisInfo.m38846bi());
        c6921b.m38863p(baseAnalysisInfo.m38847bj());
        c6921b.m38864q(baseAnalysisInfo.m38848bk());
        c6921b.m38865r(baseAnalysisInfo.m38849bl());
        AbstractC7185ho.m43820b("AnalysisReport", "baseToAnalysisInfo completed");
    }

    /* renamed from: a */
    public void m39163a(C6921b c6921b, DelayInfo delayInfo) {
        if (c6921b == null || delayInfo == null) {
            return;
        }
        c6921b.m38828al(delayInfo.m40061l());
        c6921b.m38829am(delayInfo.m40060k());
        c6921b.m38834ar(delayInfo.m40022C());
        c6921b.m38850c(delayInfo.m40026a());
        c6921b.m38851d(delayInfo.m40059j());
        c6921b.m38852e(delayInfo.m40047e());
        c6921b.m38853f(delayInfo.m40033b());
        c6921b.m38854g(delayInfo.m40040c());
        c6921b.m38855h(delayInfo.m40050f());
        c6921b.m38856i(delayInfo.m40044d());
        c6921b.m38857j(delayInfo.m40062m());
        c6921b.m38858k(delayInfo.m40063n());
        c6921b.m38859l(delayInfo.m40064o());
        c6921b.m38860m(delayInfo.m40021B());
        List<String> listM40053g = delayInfo.m40053g();
        if (!AbstractC7760bg.m47767a(listM40053g)) {
            c6921b.m39031o(listM40053g.toString());
            c6921b.m38830an(String.valueOf(listM40053g.size()));
        }
        List<String> listM40055h = delayInfo.m40055h();
        if (!AbstractC7760bg.m47767a(listM40055h)) {
            c6921b.m39033p(listM40055h.toString());
            c6921b.m38831ao(String.valueOf(listM40055h.size()));
        }
        c6921b.m38832ap(String.valueOf(delayInfo.m40057i()));
        c6921b.m38833aq(String.valueOf(delayInfo.m40065p()));
        c6921b.m38835as(String.valueOf(delayInfo.m40069t()));
        c6921b.m38836at(String.valueOf(delayInfo.m40067r()));
        Integer numM40072w = delayInfo.m40072w();
        if (numM40072w != null) {
            c6921b.m38837au(String.valueOf(numM40072w));
        }
        c6921b.m38932Y(AbstractC7758be.m47742b(delayInfo.m40070u()));
        c6921b.m38939a(delayInfo.m40071v());
        c6921b.m38934Z(delayInfo.m40073x());
        if (delayInfo.m40023D() > 0) {
            c6921b.m38862o(delayInfo.m40023D());
        }
        if (delayInfo.m40024E() > 0) {
            c6921b.m38863p(delayInfo.m40024E());
        }
        if (ApiNames.LOAD_AD.equalsIgnoreCase(c6921b.m38887C())) {
            String strM39036r = c6921b.m39036r();
            if (strM39036r == null) {
                strM39036r = "";
            }
            c6921b.m39037r(strM39036r + "#AdSign:" + delayInfo.m40074y() + "#SpareContentId:" + delayInfo.m40075z() + "#SpareExist:" + delayInfo.m40020A());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0121  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m39164a(com.huawei.openalliance.p169ad.analysis.C6921b r15, com.huawei.openalliance.p169ad.net.http.Response r16, long r17) {
        /*
            Method dump skipped, instructions count: 334
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.p169ad.analysis.AbstractC6925f.m39164a(com.huawei.openalliance.ad.analysis.b, com.huawei.openalliance.ad.net.http.Response, long):void");
    }

    /* renamed from: a */
    public void m39165a(C6921b c6921b, Double d10, Double d11, int i10) {
        Address addressM47484a;
        if (!C7734ah.m47486a(this.f31973a) || d10 == null || d11 == null || c6921b == null || (addressM47484a = C7734ah.m47484a(this.f31973a, d10, d11)) == null) {
            return;
        }
        GeoLocation geoLocation = new GeoLocation();
        geoLocation.m40171a(d10);
        geoLocation.m40173b(d11);
        geoLocation.m40172a(Long.valueOf(System.currentTimeMillis()));
        geoLocation.m40169a(i10);
        geoLocation.m40170a(C7734ah.m47485a(addressM47484a));
        c6921b.m38971ai(AbstractC7758be.m47742b(geoLocation));
    }
}
