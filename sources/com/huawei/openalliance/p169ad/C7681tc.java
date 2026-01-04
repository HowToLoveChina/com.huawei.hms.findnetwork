package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.ads.VideoConfiguration;
import com.huawei.openalliance.p169ad.analysis.C6922c;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import com.huawei.openalliance.p169ad.inter.HiAd;
import com.huawei.openalliance.p169ad.inter.data.AdLandingPageData;
import com.huawei.openalliance.p169ad.inter.listeners.LandingPageAction;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.C7775bv;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import java.util.Map;

/* renamed from: com.huawei.openalliance.ad.tc */
/* loaded from: classes8.dex */
public class C7681tc extends AbstractC7687ti {

    /* renamed from: c */
    private final boolean f35692c;

    /* renamed from: d */
    private C7169gz f35693d;

    public C7681tc(Context context, ContentRecord contentRecord, boolean z10, Map<String, String> map) {
        super(context, contentRecord);
        this.f35693d = new C7169gz();
        this.f35692c = z10;
        m47237a(map);
    }

    /* renamed from: a */
    private void m47237a(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        this.f35693d.m43655a(this.f35701b.m41419S());
        this.f35693d.m43654a(this.f35701b.m41417R());
        this.f35693d.m43656a(this.f35701b.m41484af());
        String orDefault = map.getOrDefault(MapKeyNames.LINKED_CUSTOM_SHOW_ID, String.valueOf(0));
        String orDefault2 = map.getOrDefault(MapKeyNames.LINKED_CUSTOM_RETURN_VIDEO_DIRECT, "false");
        String orDefault3 = map.getOrDefault(MapKeyNames.LINKED_CUSTOM_VIDEO_PROGRESS, null);
        String orDefault4 = map.getOrDefault(MapKeyNames.LINKED_CUSTOM_VIDEO_SOUND_SWITCH, "n");
        String orDefault5 = map.getOrDefault(MapKeyNames.LINKED_SPLASH_MEDIA_PATH, null);
        String orDefault6 = map.getOrDefault(MapKeyNames.USE_TEMPLATE, "false");
        this.f35693d.m43663c(orDefault);
        Integer numM48178h = AbstractC7806cz.m48178h(orDefault3);
        if (numM48178h != null) {
            this.f35693d.m43652a(numM48178h.intValue());
            AbstractC7185ho.m43820b("InnerWebAction", "set progress from native view " + numM48178h);
        } else {
            this.f35693d.m43652a(0);
        }
        if (!TextUtils.isEmpty(orDefault6)) {
            this.f35693d.m43665d(orDefault6);
        }
        this.f35693d.m43657a(orDefault4);
        C7169gz c7169gz = this.f35693d;
        String str = FaqConstants.DISABLE_HA_REPORT;
        c7169gz.m43658a(FaqConstants.DISABLE_HA_REPORT.equals(orDefault2));
        this.f35693d.m43660b(orDefault5);
        String str2 = map.containsKey(MapKeyNames.AUTO_PLAY_VIDEO_NETWORK) ? map.get(MapKeyNames.AUTO_PLAY_VIDEO_NETWORK) : null;
        if (map.containsKey(MapKeyNames.PLAY_VIDEO_IS_MUTE)) {
            str = map.get(MapKeyNames.PLAY_VIDEO_IS_MUTE);
        }
        if (str2 != null) {
            this.f35693d.m43653a(new VideoConfiguration.Builder().setAutoPlayNetwork(AbstractC7806cz.m48145a(str2, 0)).setMute(Boolean.getBoolean(str)).build());
        }
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7687ti
    /* renamed from: a */
    public boolean mo47233a() {
        if (this.f35701b == null) {
            return m47249b();
        }
        AbstractC7185ho.m43820b("InnerWebAction", "handle inner web action");
        AdLandingPageData adLandingPageData = new AdLandingPageData(this.f35701b, this.f35700a, this.f35692c);
        return TextUtils.isEmpty(adLandingPageData.getLandingUrl()) ? m47249b() : m47238a(adLandingPageData);
    }

    /* renamed from: a */
    public boolean m47238a(AdLandingPageData adLandingPageData) {
        boolean zOpenLandingPage;
        LandingPageAction landingPageActionMo44047b = HiAd.m44014a(this.f35700a).mo44047b();
        if (landingPageActionMo44047b == null || AbstractC7558os.m46465d(this.f35701b.m41427W())) {
            if (!AbstractC7558os.m46463b(this.f35701b.m41427W()) && !C7775bv.m47831e(this.f35700a)) {
                return m47249b();
            }
            m47248b("web");
            C6980bx.m41135a(this.f35700a, adLandingPageData, this.f35693d, this.f35701b);
            return true;
        }
        try {
            zOpenLandingPage = landingPageActionMo44047b.openLandingPage(this.f35700a, adLandingPageData);
        } catch (Throwable th2) {
            th = th2;
            zOpenLandingPage = false;
        }
        try {
            m47248b("web");
        } catch (Throwable th3) {
            th = th3;
            AbstractC7185ho.m43823c("InnerWebAction", "openLandingPage Exception");
            AbstractC7185ho.m43815a(5, th);
            new C6922c(this.f35700a).mo39110a(th);
            return zOpenLandingPage ? true : true;
        }
        if (zOpenLandingPage && !m47249b()) {
            return false;
        }
    }
}
