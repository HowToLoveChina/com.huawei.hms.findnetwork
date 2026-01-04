package com.huawei.openalliance.p169ad.inter.data;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.huawei.hms.ads.AdFeedbackListener;
import com.huawei.hms.ads.VideoConfiguration;
import com.huawei.openalliance.p169ad.AbstractC7014dc;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.AbstractC7558os;
import com.huawei.openalliance.p169ad.AbstractC7687ti;
import com.huawei.openalliance.p169ad.C7543ok;
import com.huawei.openalliance.p169ad.C7560ou;
import com.huawei.openalliance.p169ad.C7570pd;
import com.huawei.openalliance.p169ad.C7662sk;
import com.huawei.openalliance.p169ad.C7686th;
import com.huawei.openalliance.p169ad.C8190vl;
import com.huawei.openalliance.p169ad.activity.FeedbackActivity;
import com.huawei.openalliance.p169ad.annotations.InterfaceC6934f;
import com.huawei.openalliance.p169ad.beans.metadata.ContentExt;
import com.huawei.openalliance.p169ad.beans.metadata.DefaultTemplate;
import com.huawei.openalliance.p169ad.beans.metadata.ImpEX;
import com.huawei.openalliance.p169ad.beans.metadata.MetaData;
import com.huawei.openalliance.p169ad.beans.metadata.Monitor;
import com.huawei.openalliance.p169ad.beans.metadata.p170v3.Asset;
import com.huawei.openalliance.p169ad.beans.metadata.p170v3.TemplateData;
import com.huawei.openalliance.p169ad.constant.ClickDestination;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import com.huawei.openalliance.p169ad.inter.HiAd;
import com.huawei.openalliance.p169ad.inter.data.MaterialClickInfo;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.processor.eventbeans.C7586a;
import com.huawei.openalliance.p169ad.processor.eventbeans.C7587b;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7758be;
import com.huawei.openalliance.p169ad.utils.AbstractC7760bg;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.AbstractC7810dc;
import com.huawei.openalliance.p169ad.utils.C7753b;
import com.huawei.openalliance.p169ad.utils.C7780c;
import com.huawei.openalliance.p169ad.views.feedback.C8093c;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* renamed from: com.huawei.openalliance.ad.inter.data.e */
/* loaded from: classes2.dex */
public class C7302e extends AbstractC7298a implements INativeAd {

    /* renamed from: A */
    private String f33790A;

    /* renamed from: B */
    private AudioInfo f33791B;

    /* renamed from: C */
    private int f33792C;

    /* renamed from: D */
    private List<Integer> f33793D;

    /* renamed from: F */
    private String f33795F;

    /* renamed from: G */
    private String f33796G;

    /* renamed from: H */
    private List<String> f33797H;

    /* renamed from: I */
    private String f33798I;

    /* renamed from: K */
    private String f33800K;

    /* renamed from: L */
    private String f33801L;

    /* renamed from: M */
    private String f33802M;

    /* renamed from: O */
    private String f33804O;

    /* renamed from: P */
    private List<String> f33805P;

    /* renamed from: Q */
    private transient IAdEvent f33806Q;

    /* renamed from: S */
    private String f33808S;

    /* renamed from: T */
    @InterfaceC6934f
    private long f33809T;

    /* renamed from: U */
    private String f33810U;

    /* renamed from: V */
    private int f33811V;

    /* renamed from: W */
    private List<ImpEX> f33812W;

    /* renamed from: X */
    private List<ContentExt> f33813X;

    /* renamed from: Y */
    private List<FeedbackInfo> f33814Y;

    /* renamed from: Z */
    private String f33815Z;

    /* renamed from: aa */
    private List<Asset> f33816aa;

    /* renamed from: ab */
    private String f33817ab;

    /* renamed from: ac */
    private TemplateData f33818ac;

    /* renamed from: ad */
    private String f33819ad;

    /* renamed from: ae */
    private String f33820ae;

    /* renamed from: af */
    private String f33821af;

    /* renamed from: ag */
    private Integer f33822ag;

    /* renamed from: ah */
    private DefaultTemplate f33823ah;

    /* renamed from: aj */
    private byte[] f33825aj;

    /* renamed from: ak */
    private String f33826ak;

    /* renamed from: al */
    private List<Monitor> f33827al;

    /* renamed from: am */
    private String f33828am;

    /* renamed from: an */
    private String f33829an;

    /* renamed from: ao */
    private String f33830ao;

    /* renamed from: ap */
    private String f33831ap;

    /* renamed from: aq */
    private transient VideoConfiguration f33832aq;

    /* renamed from: h */
    private int f33834h;

    /* renamed from: i */
    private String f33835i;

    /* renamed from: j */
    private String f33836j;

    /* renamed from: k */
    private String f33837k;

    /* renamed from: l */
    private List<String> f33838l;

    /* renamed from: m */
    private ImageInfo f33839m;

    /* renamed from: n */
    private List<ImageInfo> f33840n;

    /* renamed from: o */
    private List<ImageInfo> f33841o;

    /* renamed from: p */
    private String f33842p;

    /* renamed from: q */
    private long f33843q;

    /* renamed from: r */
    private long f33844r;

    /* renamed from: s */
    private int f33845s;

    /* renamed from: t */
    private String f33846t;

    /* renamed from: u */
    private String f33847u;

    /* renamed from: v */
    private VideoInfo f33848v;

    /* renamed from: w */
    private List<String> f33849w;

    /* renamed from: x */
    private List<String> f33850x;

    /* renamed from: y */
    private AppInfo f33851y;

    /* renamed from: z */
    private String f33852z;

    /* renamed from: g */
    private boolean f33833g = false;

    /* renamed from: E */
    private boolean f33794E = false;

    /* renamed from: J */
    private boolean f33799J = false;

    /* renamed from: N */
    private boolean f33803N = false;

    /* renamed from: R */
    private boolean f33807R = false;

    /* renamed from: ai */
    private boolean f33824ai = true;

    /* renamed from: com.huawei.openalliance.ad.inter.data.e$1 */
    public class AnonymousClass1 implements Callable<Boolean> {

        /* renamed from: a */
        final /* synthetic */ Context f33853a;

        public AnonymousClass1(Context context) {
            context = context;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Boolean call() {
            if (AbstractC7760bg.m47767a(C7302e.this.f33840n)) {
                return Boolean.FALSE;
            }
            boolean z10 = false;
            if (((ImageInfo) C7302e.this.f33840n.get(0)).m44474a(context) && C7302e.this.f33848v.m44565a(context)) {
                z10 = true;
            }
            return Boolean.valueOf(z10);
        }
    }

    /* renamed from: c */
    private C7560ou m44752c(Context context) {
        ContentRecord contentRecordM46698a = C7570pd.m46698a(this);
        if (contentRecordM46698a == null) {
            AbstractC7185ho.m43820b("INativeAd", "contentRecord is empty when convert from nativeAd");
            return null;
        }
        C7560ou c7560ou = new C7560ou(context, C7662sk.m47225a(context, contentRecordM46698a.m41552f()));
        c7560ou.mo46590a(contentRecordM46698a);
        return c7560ou;
    }

    /* renamed from: B */
    public void m44754B(String str) {
        this.f33835i = str;
    }

    /* renamed from: C */
    public void m44755C(String str) {
        this.f33836j = str;
    }

    /* renamed from: D */
    public void m44756D(String str) {
        this.f33837k = str;
    }

    /* renamed from: E */
    public void m44757E(String str) {
        this.f33842p = str;
    }

    /* renamed from: F */
    public String mo44485F() {
        return this.f33808S;
    }

    /* renamed from: G */
    public void m44759G(String str) {
        this.f33847u = str;
    }

    /* renamed from: H */
    public void m44760H(String str) {
        this.f33852z = str;
    }

    /* renamed from: I */
    public void m44761I(String str) {
        this.f33790A = str;
    }

    /* renamed from: J */
    public void m44762J(String str) {
        this.f33795F = str;
    }

    /* renamed from: K */
    public void m44763K(String str) {
        this.f33796G = str;
    }

    /* renamed from: L */
    public void m44764L(String str) {
        this.f33798I = str;
    }

    /* renamed from: M */
    public String m44765M() {
        return this.f33835i;
    }

    /* renamed from: N */
    public String m44767N() {
        return this.f33846t;
    }

    /* renamed from: O */
    public String m44769O() {
        return this.f33847u;
    }

    /* renamed from: P */
    public void m44771P(String str) {
        this.f33801L = str;
    }

    /* renamed from: Q */
    public List<String> m44773Q() {
        return this.f33850x;
    }

    /* renamed from: R */
    public String m44775R() {
        return this.f33852z;
    }

    /* renamed from: S */
    public String m44777S() {
        return this.f33790A;
    }

    /* renamed from: T */
    public int m44779T() {
        return this.f33792C;
    }

    /* renamed from: U */
    public List<Integer> m44781U() {
        return this.f33793D;
    }

    /* renamed from: V */
    public void m44783V(String str) {
        this.f33829an = str;
    }

    /* renamed from: W */
    public String m44785W() {
        return this.f33795F;
    }

    /* renamed from: X */
    public List<String> m44787X() {
        return this.f33797H;
    }

    /* renamed from: Y */
    public void m44789Y(String str) {
        this.f33820ae = str;
    }

    /* renamed from: Z */
    public String m44791Z() {
        return this.f33815Z;
    }

    /* renamed from: a */
    public MaterialClickInfo m44793a(Bundle bundle) {
        JSONObject jSONObjectM48164b = AbstractC7806cz.m48164b(bundle);
        int iOptInt = jSONObjectM48164b.optInt(MapKeyNames.CLICK_X, -111111);
        Integer numValueOf = Integer.valueOf(iOptInt);
        int iOptInt2 = jSONObjectM48164b.optInt(MapKeyNames.CLICK_Y, -111111);
        Integer numValueOf2 = Integer.valueOf(iOptInt2);
        String strOptString = jSONObjectM48164b.optString(MapKeyNames.CREATIVE_SIZE, "");
        Float fM48147a = AbstractC7806cz.m48147a(jSONObjectM48164b.optString(MapKeyNames.DENSITY, "-111111"), Float.valueOf(-111111.0f));
        int iOptInt3 = jSONObjectM48164b.optInt(MapKeyNames.UP_X, -111111);
        Integer numValueOf3 = Integer.valueOf(iOptInt3);
        int iOptInt4 = jSONObjectM48164b.optInt(MapKeyNames.UP_Y, -111111);
        Integer numValueOf4 = Integer.valueOf(iOptInt4);
        int iOptInt5 = jSONObjectM48164b.optInt(MapKeyNames.SLD, -111111);
        Integer numValueOf5 = Integer.valueOf(iOptInt5);
        long jOptLong = jSONObjectM48164b.optLong(MapKeyNames.CLICK_DOWN_TIME);
        Long lValueOf = Long.valueOf(jOptLong);
        long jOptLong2 = jSONObjectM48164b.optLong(MapKeyNames.CLICK_UP_TIME);
        Long lValueOf2 = Long.valueOf(jOptLong2);
        String strOptString2 = jSONObjectM48164b.optString(MapKeyNames.SHAKE_ANGLE, "");
        if (iOptInt == -111111) {
            numValueOf = null;
        }
        if (iOptInt2 == -111111) {
            numValueOf2 = null;
        }
        if (!AbstractC7806cz.m48187p(strOptString)) {
            strOptString = null;
        }
        if (fM48147a.floatValue() == -111111.0f) {
            fM48147a = null;
        }
        if (iOptInt3 == -111111) {
            numValueOf3 = null;
        }
        if (iOptInt4 == -111111) {
            numValueOf4 = null;
        }
        if (iOptInt5 == -111111) {
            numValueOf5 = null;
        }
        if (jOptLong == 0) {
            lValueOf = null;
        }
        Long l10 = jOptLong2 == 0 ? null : lValueOf2;
        if (AbstractC7806cz.m48165b(strOptString2)) {
            strOptString2 = null;
        }
        return new MaterialClickInfo.C7296a().m44532a(numValueOf).m44536b(numValueOf2).m44538b(strOptString).m44539c(numValueOf5).m44531a(fM48147a).m44540d(numValueOf3).m44541e(numValueOf4).m44537b(lValueOf).m44533a(l10).m44534a(strOptString2).m44535a();
    }

    /* renamed from: aA */
    public String m44802aA() {
        return this.f33821af;
    }

    /* renamed from: aB */
    public String m44803aB() {
        return this.f33817ab;
    }

    /* renamed from: aa */
    public List<Asset> m44804aa() {
        return this.f33816aa;
    }

    /* renamed from: ab */
    public TemplateData m44806ab() {
        return this.f33818ac;
    }

    /* renamed from: ac */
    public String m44807ac() {
        return this.f33819ad;
    }

    /* renamed from: ad */
    public Integer m44808ad() {
        return this.f33822ag;
    }

    /* renamed from: ae */
    public DefaultTemplate m44809ae() {
        return this.f33823ah;
    }

    /* renamed from: af */
    public String m44810af() {
        return this.f33800K;
    }

    /* renamed from: ag */
    public String m44811ag() {
        return this.f33801L;
    }

    /* renamed from: ah */
    public String m44812ah() {
        return this.f33802M;
    }

    /* renamed from: ai */
    public String m44813ai() {
        return this.f33804O;
    }

    /* renamed from: aj */
    public boolean m44814aj() {
        return this.f33807R;
    }

    /* renamed from: ak */
    public Map<String, String> m44815ak() {
        HashMap map = new HashMap();
        map.put("appId", m44769O());
        map.put("thirdId", m44767N());
        if (getVideoInfo() == null) {
            return map;
        }
        map.put(MapKeyNames.LINKED_CUSTOM_SHOW_ID, getShowId());
        int iM44566b = getVideoInfo().m44566b();
        AbstractC7185ho.m43821b("INativeAd", "buildLinkedAdConfig, set progress from native view %s %s", Integer.valueOf(iM44566b), getVideoInfo().m44592i());
        String str = "false";
        if (m44808ad() == null || m44808ad().intValue() != 3 ? getVideoInfo().m44585f() : m44825au()) {
            str = FaqConstants.DISABLE_HA_REPORT;
        }
        map.put(MapKeyNames.LINKED_CUSTOM_RETURN_VIDEO_DIRECT, str);
        map.put(MapKeyNames.LINKED_CUSTOM_VIDEO_SOUND_SWITCH, getVideoInfo().getSoundSwitch());
        map.put(MapKeyNames.LINKED_CUSTOM_VIDEO_PROGRESS, String.valueOf(iM44566b));
        map.put(MapKeyNames.LINKED_SPLASH_MEDIA_PATH, this.f33808S);
        map.put(MapKeyNames.USE_TEMPLATE, getVideoInfo().m44592i());
        if (getVideoConfiguration() != null) {
            map.put(MapKeyNames.AUTO_PLAY_VIDEO_NETWORK, String.valueOf(getVideoConfiguration().getAutoPlayNetwork()));
            map.put(MapKeyNames.PLAY_VIDEO_IS_MUTE, Boolean.toString(getVideoConfiguration().isMute()));
        }
        return map;
    }

    /* renamed from: al */
    public String m44816al() {
        return this.f33810U;
    }

    /* renamed from: am */
    public List<ImpEX> m44817am() {
        return this.f33812W;
    }

    /* renamed from: an */
    public List<ContentExt> m44818an() {
        return this.f33813X;
    }

    /* renamed from: ao */
    public boolean m44819ao() {
        return this.f33824ai;
    }

    /* renamed from: ap */
    public byte[] m44820ap() {
        byte[] bArr = this.f33825aj;
        return bArr != null ? Arrays.copyOf(bArr, bArr.length) : new byte[0];
    }

    /* renamed from: aq */
    public String m44821aq() {
        return this.f33826ak;
    }

    /* renamed from: ar */
    public List<Monitor> m44822ar() {
        return this.f33827al;
    }

    /* renamed from: as */
    public String m44823as() {
        return this.f33828am;
    }

    /* renamed from: at */
    public String m44824at() {
        return this.f33829an;
    }

    /* renamed from: au */
    public boolean m44825au() {
        return this.f33803N;
    }

    /* renamed from: av */
    public long m44826av() {
        return this.f33809T;
    }

    /* renamed from: aw */
    public int m44827aw() {
        return this.f33811V;
    }

    /* renamed from: ax */
    public String m44828ax() {
        return this.f33830ao;
    }

    /* renamed from: ay */
    public String m44829ay() {
        return this.f33831ap;
    }

    /* renamed from: az */
    public String m44830az() {
        return this.f33820ae;
    }

    /* renamed from: b */
    public IAdEvent mo44493b(Context context) {
        if (this.f33806Q == null) {
            if (context != null) {
                this.f33806Q = new C7543ok(context.getApplicationContext(), this);
            } else {
                AbstractC7185ho.m43820b("INativeAd", " context is null, ");
            }
        }
        return this.f33806Q;
    }

    /* renamed from: d */
    public void m44831d(long j10) {
        this.f33843q = j10;
    }

    /* renamed from: e */
    public void m44833e(long j10) {
        this.f33809T = j10;
    }

    /* renamed from: f */
    public void m44835f(long j10) {
        this.f33844r = j10;
    }

    /* renamed from: g */
    public void m44839g(List<String> list) {
        this.f33850x = list;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.INativeAd
    public List<String> getAdCloseKeyWords() {
        return this.f33849w;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.INativeAd
    public List<AdvertiserInfo> getAdvertiserInfo() {
        if (hasAdvertiserInfo()) {
            return getCompliance();
        }
        return null;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IAd
    public AppInfo getAppInfo() {
        return this.f33851y;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.INativeAd
    public AudioInfo getAudioInfo() {
        return this.f33791B;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IAd
    public String getCtrlSwitchs() {
        return this.f33796G;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.INativeAd
    public String getDescription() {
        return this.f33837k;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.INativeAd
    public Map<String, String> getExt() {
        HashMap map = new HashMap();
        if (!AbstractC7760bg.m47767a(this.f33813X)) {
            for (ContentExt contentExt : this.f33813X) {
                map.put(contentExt.m40009a(), AbstractC7806cz.m48168c(contentExt.m40011b()));
            }
        }
        if (!AbstractC7760bg.m47767a(this.f33812W)) {
            for (ImpEX impEX : this.f33812W) {
                map.put(impEX.m40188a(), AbstractC7806cz.m48168c(impEX.m40190b()));
            }
        }
        return map;
    }

    public List<FeedbackInfo> getFeedbackInfoList() {
        return this.f33814Y;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.INativeAd
    public ImageInfo getIcon() {
        return this.f33839m;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.INativeAd
    public List<ImageInfo> getImageInfos() {
        return this.f33840n;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.INativeAd
    public String getIntentUri() {
        return AbstractC7806cz.m48168c(this.f33726d);
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.INativeAd
    public int getInterActionType() {
        return this.f33834h;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.INativeAd
    public List<String> getInvalidContentIds() {
        return this.f33805P;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.INativeAd
    public String getJumpText(Context context) {
        return C7780c.m47859a(C7570pd.m46698a(this), context, true);
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.INativeAd
    public String getLandWebUrl() {
        return this.f33842p;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IAd
    public long getMaxEffectiveShowTime() {
        return this.f33844r;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IAd
    public int getMinEffectiveShowRatio() {
        return this.f33845s;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IAd
    public long getMinEffectiveShowTime() {
        return this.f33843q;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.INativeAd
    public String getPrivacyLink() {
        MetaData metaData = (MetaData) AbstractC7758be.m47739b(this.f33852z, MetaData.class, new Class[0]);
        if (metaData != null) {
            return metaData.m40266C();
        }
        return null;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.INativeAd
    public List<ImageInfo> getRawImageInfos() {
        return this.f33841o;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.INativeAd
    public String getSlotId() {
        return this.f33798I;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.INativeAd
    public List<String> getSubDescription() {
        return this.f33838l;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.INativeAd
    public String getTitle() {
        return this.f33836j;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.INativeAd
    public VideoConfiguration getVideoConfiguration() {
        return this.f33832aq;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.INativeAd
    public VideoInfo getVideoInfo() {
        return this.f33848v;
    }

    /* renamed from: h */
    public void m44841h(List<Integer> list) {
        this.f33793D = list;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.INativeAd
    public boolean hasAdvertiserInfo() {
        return !AbstractC7760bg.m47767a(getCompliance());
    }

    /* renamed from: i */
    public void m44843i(List<String> list) {
        this.f33797H = list;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.INativeAd
    public boolean isClicked() {
        return this.f33833g;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.INativeAd
    public boolean isUseGaussianBlur() {
        return this.f33811V == 1;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.INativeAd
    public boolean isValid(Context context) {
        if (this.f33848v == null || this.f33803N) {
            return true;
        }
        return ((Boolean) AbstractC7810dc.m48268a(new Callable<Boolean>() { // from class: com.huawei.openalliance.ad.inter.data.e.1

            /* renamed from: a */
            final /* synthetic */ Context f33853a;

            public AnonymousClass1(Context context2) {
                context = context2;
            }

            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Boolean call() {
                if (AbstractC7760bg.m47767a(C7302e.this.f33840n)) {
                    return Boolean.FALSE;
                }
                boolean z10 = false;
                if (((ImageInfo) C7302e.this.f33840n.get(0)).m44474a(context) && C7302e.this.f33848v.m44565a(context)) {
                    z10 = true;
                }
                return Boolean.valueOf(z10);
            }
        }, 100L, Boolean.FALSE)).booleanValue();
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.INativeAd
    public boolean isVideoAd() {
        return this.f33848v != null;
    }

    /* renamed from: j */
    public void m44845j(int i10) {
        this.f33834h = i10;
    }

    /* renamed from: k */
    public void m44848k(int i10) {
        this.f33845s = i10;
    }

    /* renamed from: l */
    public void m44851l(int i10) {
        this.f33792C = i10;
    }

    /* renamed from: m */
    public void m44853m(int i10) {
        this.f33811V = i10;
    }

    /* renamed from: n */
    public void m44855n(List<ContentExt> list) {
        this.f33813X = list;
    }

    /* renamed from: o */
    public void m44856o(List<FeedbackInfo> list) {
        this.f33814Y = list;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.INativeAd
    public void onAdClose(Context context, List<String> list) {
        if (context == null || !isAdIdInWhiteList()) {
            return;
        }
        AbstractC7185ho.m43820b("INativeAd", "onAdClose, in whitelist, report onAdCloseEvent.");
        mo44493b(context).onAdClosed(list);
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.INativeAd
    public boolean onFeedback(Context context, int i10, List<FeedbackInfo> list) {
        AbstractC7185ho.m43820b("INativeAd", "report feedback");
        C7560ou c7560ouM44752c = m44752c(context);
        if (c7560ouM44752c == null) {
            AbstractC7185ho.m43820b("INativeAd", "eventProcessor is null");
            return false;
        }
        if (1 == i10 || 3 == i10) {
            c7560ouM44752c.mo46614b(list);
        } else if (2 == i10) {
            c7560ouM44752c.mo46604a(list);
        }
        return true;
    }

    /* renamed from: p */
    public void m44857p(List<Monitor> list) {
        this.f33827al = list;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.INativeAd
    public boolean recordClickEvent(Context context, Bundle bundle) {
        if (context != null && isAdIdInWhiteList()) {
            return m44749a(context, bundle, ClickDestination.ADCONTENTINTERFACE);
        }
        AbstractC7185ho.m43820b("INativeAd", "record click event failed.");
        return false;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.INativeAd
    public boolean recordImpressionEvent(Context context, Bundle bundle) {
        if (context == null || !isAdIdInWhiteList()) {
            return false;
        }
        return m44753c(context, bundle);
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.INativeAd
    public boolean recordShowStartEvent(Context context, Bundle bundle) {
        if (context == null || !isAdIdInWhiteList()) {
            return false;
        }
        this.f33809T = System.currentTimeMillis();
        AbstractC7185ho.m43820b("INativeAd", "recordShowStartEvent.");
        m44622c(this.f33809T);
        m44642h(String.valueOf(AbstractC7741ao.m47566c()));
        return m44751b(context, bundle);
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.INativeAd
    public void setVideoConfiguration(VideoConfiguration videoConfiguration) {
        this.f33832aq = videoConfiguration;
        if (HiAd.m44013a() != null) {
            HiAd.m44013a().mo44044a(videoConfiguration, AbstractC7558os.m46459G(getCtrlSwitchs()), AbstractC7558os.m46460H(getCtrlSwitchs()), 3);
        }
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.INativeAd
    public boolean showFeedback(Context context, View view, AdFeedbackListener adFeedbackListener) {
        try {
            AbstractC7185ho.m43820b("INativeAd", "show feedback");
            C8093c c8093c = new C8093c();
            c8093c.m50145a(view);
            c8093c.m50148b(adFeedbackListener);
            AbstractC7014dc.m41871a(this);
            FeedbackActivity.m38613a(context, c8093c);
            return true;
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("INativeAd", "showFeedback err, %s", th2.getClass().getSimpleName());
            return false;
        }
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.INativeAd
    public boolean triggerClick(Context context, Bundle bundle) {
        if (context == null || !isAdIdInWhiteList()) {
            return false;
        }
        return m44801a(context, bundle);
    }

    /* renamed from: y */
    public void mo44499y(String str) {
        this.f33808S = str;
    }

    /* renamed from: c */
    private boolean m44753c(Context context, Bundle bundle) {
        C7560ou c7560ouM44752c = m44752c(context);
        if (c7560ouM44752c == null) {
            AbstractC7185ho.m43820b("INativeAd", "eventProcessor is null");
            return false;
        }
        AbstractC7185ho.m43820b("INativeAd", "api onAdShowed");
        long jMin = Math.min(System.currentTimeMillis() - this.f33809T, getMinEffectiveShowTime());
        C7586a.a aVar = new C7586a.a();
        aVar.m46874a(Long.valueOf(jMin)).m46873a(Integer.valueOf(this.f33845s)).m46878b((Integer) 7).m46875a(C7753b.m47699a(context)).m46885e(C8190vl.m50725a(bundle)).m46884d(C8190vl.m50726b(bundle)).m46879b(AbstractC7806cz.m48152a(bundle));
        c7560ouM44752c.mo46593a(aVar.m46877a());
        return true;
    }

    /* renamed from: F */
    public void m44758F(String str) {
        this.f33846t = str;
    }

    /* renamed from: M */
    public void m44766M(String str) {
        this.f33815Z = str;
    }

    /* renamed from: N */
    public void m44768N(String str) {
        this.f33819ad = str;
    }

    /* renamed from: O */
    public void m44770O(String str) {
        this.f33800K = str;
    }

    /* renamed from: P */
    public boolean m44772P() {
        List<Asset> list;
        Integer num = this.f33822ag;
        if (num == null || num.intValue() != 3 || (list = this.f33816aa) == null) {
            return false;
        }
        for (Asset asset : list) {
            if (asset != null && asset.m40517e() != null) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: Q */
    public void m44774Q(String str) {
        this.f33802M = str;
    }

    /* renamed from: R */
    public void m44776R(String str) {
        this.f33804O = str;
    }

    /* renamed from: S */
    public void m44778S(String str) {
        this.f33810U = str;
    }

    /* renamed from: T */
    public void m44780T(String str) {
        this.f33826ak = str;
    }

    /* renamed from: U */
    public void m44782U(String str) {
        this.f33828am = str;
    }

    /* renamed from: V */
    public boolean m44784V() {
        return this.f33794E;
    }

    /* renamed from: W */
    public void m44786W(String str) {
        this.f33830ao = str;
    }

    /* renamed from: X */
    public void m44788X(String str) {
        this.f33831ap = str;
    }

    /* renamed from: Y */
    public boolean m44790Y() {
        return this.f33799J;
    }

    /* renamed from: Z */
    public void m44792Z(String str) {
        this.f33821af = str;
    }

    /* renamed from: aa */
    public void m44805aa(String str) {
        this.f33817ab = str;
    }

    /* renamed from: d */
    public void m44832d(List<String> list) {
        this.f33838l = list;
    }

    /* renamed from: e */
    public void m44834e(List<ImageInfo> list) {
        this.f33840n = list;
    }

    /* renamed from: f */
    public void m44836f(Integer num) {
        this.f33822ag = num;
    }

    /* renamed from: g */
    public void m44840g(boolean z10) {
        this.f33794E = z10;
    }

    /* renamed from: h */
    public void m44842h(boolean z10) {
        this.f33799J = z10;
    }

    /* renamed from: i */
    public void m44844i(boolean z10) {
        this.f33803N = z10;
        VideoInfo videoInfo = this.f33848v;
        if (videoInfo != null) {
            videoInfo.m44581e(true);
        }
    }

    /* renamed from: j */
    public void m44846j(List<Asset> list) {
        this.f33816aa = list;
    }

    /* renamed from: k */
    public void m44849k(List<String> list) {
        this.f33805P = list;
    }

    /* renamed from: l */
    public void m44852l(List<ImageInfo> list) {
        this.f33841o = list;
    }

    /* renamed from: m */
    public void m44854m(List<ImpEX> list) {
        this.f33812W = list;
    }

    /* renamed from: b */
    private boolean m44751b(Context context, Bundle bundle) {
        C7560ou c7560ouM44752c = m44752c(context);
        if (c7560ouM44752c == null) {
            AbstractC7185ho.m43820b("INativeAd", "eventProcessor is null");
            return false;
        }
        c7560ouM44752c.m46600a(AbstractC7806cz.m48152a(bundle));
        return true;
    }

    /* renamed from: a */
    public void m44794a(DefaultTemplate defaultTemplate) {
        this.f33823ah = defaultTemplate;
    }

    /* renamed from: f */
    public void m44837f(List<String> list) {
        this.f33849w = list;
    }

    /* renamed from: j */
    public void m44847j(boolean z10) {
        this.f33807R = z10;
    }

    /* renamed from: k */
    public void m44850k(boolean z10) {
        this.f33824ai = z10;
    }

    /* renamed from: a */
    public void m44795a(TemplateData templateData) {
        this.f33818ac = templateData;
    }

    /* renamed from: f */
    public void m44838f(boolean z10) {
        this.f33833g = z10;
    }

    /* renamed from: a */
    public void m44796a(AppInfo appInfo) {
        this.f33851y = appInfo;
    }

    /* renamed from: a */
    public void m44797a(AudioInfo audioInfo) {
        this.f33791B = audioInfo;
    }

    /* renamed from: a */
    public void m44798a(ImageInfo imageInfo) {
        this.f33839m = imageInfo;
    }

    /* renamed from: a */
    public void m44799a(VideoInfo videoInfo) {
        this.f33848v = videoInfo;
    }

    /* renamed from: a */
    public void m44800a(byte[] bArr) {
        if (bArr != null) {
            this.f33825aj = Arrays.copyOf(bArr, bArr.length);
        }
    }

    /* renamed from: a */
    public boolean m44801a(Context context, Bundle bundle) {
        m44838f(true);
        AbstractC7687ti abstractC7687tiM47245a = C7686th.m47245a(context, C7570pd.m46698a(this), m44815ak());
        boolean zMo47233a = abstractC7687tiM47245a.mo47233a();
        if (zMo47233a) {
            m44749a(context, bundle, abstractC7687tiM47245a.m47250c());
        }
        return zMo47233a;
    }

    /* renamed from: a */
    private boolean m44749a(Context context, Bundle bundle, String str) {
        C7560ou c7560ouM44752c = m44752c(context);
        if (c7560ouM44752c == null) {
            AbstractC7185ho.m43820b("INativeAd", "eventProcessor is null");
            return false;
        }
        C7587b.a aVar = new C7587b.a();
        MaterialClickInfo materialClickInfoM44793a = m44793a(bundle);
        if (materialClickInfoM44793a.m44518i() == null && materialClickInfoM44793a.m44517h() == null) {
            materialClickInfoM44793a.m44515f(1);
        }
        aVar.m46920b(str).m46915a((Integer) 12).m46922c(AbstractC7806cz.m48152a(bundle)).m46914a(materialClickInfoM44793a).m46923d(C7753b.m47699a(context));
        c7560ouM44752c.mo46594a(aVar.m46918a());
        return true;
    }
}
