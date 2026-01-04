package com.huawei.openalliance.p169ad.beans.metadata;

import android.text.TextUtils;
import com.huawei.openalliance.p169ad.annotations.DataKeep;
import com.huawei.openalliance.p169ad.annotations.InterfaceC6929a;
import com.huawei.openalliance.p169ad.annotations.InterfaceC6932d;
import com.huawei.openalliance.p169ad.annotations.InterfaceC6934f;
import com.huawei.openalliance.p169ad.beans.base.RspBean;
import com.huawei.openalliance.p169ad.beans.metadata.p170v3.Asset;
import com.huawei.openalliance.p169ad.beans.metadata.p170v3.TemplateV3;
import com.huawei.openalliance.p169ad.constant.LabelPosition;
import com.huawei.openalliance.p169ad.inter.data.AdvertiserInfo;
import com.huawei.openalliance.p169ad.inter.data.DeviceAiParam;
import com.huawei.openalliance.p169ad.inter.data.RewardItem;
import com.huawei.openalliance.p169ad.utils.AbstractC7758be;
import com.huawei.openalliance.p169ad.utils.AbstractC7760bg;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@DataKeep
/* loaded from: classes8.dex */
public class Content extends RspBean implements Comparable {
    private String adChoiceIcon;
    private String adChoiceUrl;
    private Integer apiVer;
    private String assets;
    private List<Asset> assetsObj;
    private String bubbleInfo;
    private List<Integer> clickActionList;
    private String compliance;
    private List<ContentExt> contentExts;
    private String contentid;

    @InterfaceC6932d(m39225a = "taskinfo")
    private String contenttaskinfo;
    private int creativetype;
    private String cshareUrl;
    private String ctrlExt;

    @InterfaceC6934f
    private CtrlExt ctrlExtObj;
    private String ctrlSwitchs;
    private String cur;
    private DefaultTemplate defaultTemplate;

    @InterfaceC6929a
    private DeviceAiParam deviceAiParam;
    private String dspid;
    private long endtime;
    private List<ImpEX> ext;
    private List<Integer> filterList;
    private String harmonyDetailInfo;
    private String harmonyHwChannelId;
    private InteractCfg interactCfg;
    private int interactiontype;

    @InterfaceC6929a
    private String jssdkAllowList;
    private List<String> keyWords;
    private List<String> keyWordsType;

    @InterfaceC6929a
    private String landPageWhiteList;
    private int landingTitle;
    private String landpgDlInteractionCfg;
    private String logo2Pos;
    private String logo2Text;
    private String lurl;

    @InterfaceC6929a
    private String metaData;

    @InterfaceC6934f
    private MetaData metaDataObj;

    @InterfaceC6929a
    private List<Monitor> monitor;
    private List<NegativeFb> negativeFbs;

    @InterfaceC6934f
    private List<String> noReportEventList;
    private String nurl;

    /* renamed from: om */
    @InterfaceC6929a
    private List<C6957Om> f32009om;

    @InterfaceC6929a
    private String paramfromserver;

    @InterfaceC6929a
    private Float price;

    @InterfaceC6932d(m39225a = "prio")
    private Integer priority;
    private String proDesc;
    private int recallSource;

    @InterfaceC6934f
    private int requestType;
    private RewardItem rewardItem;
    private Integer sdkMonitor;
    private int sequence;
    private int showAppLogoFlag;
    private String showid;
    private Skip skip;
    private String skipText;
    private String skipTextPos;
    int spare;
    private Integer splashShowTime;
    private Integer splashSkipBtnDelayTime;
    private long starttime;
    private String taskid;
    private TemplateV3 template;
    private boolean transparencySwitch;
    private String transparencyTplUrl;
    private int useGaussianBlur;
    private String webConfig;
    private String whyThisAd;

    public Content() {
        this.showAppLogoFlag = 1;
        this.starttime = -1L;
        this.interactiontype = 0;
        this.creativetype = 1;
        this.showid = "";
        this.skipTextPos = "tr";
        this.recallSource = 0;
        this.logo2Text = "";
        this.logo2Pos = LabelPosition.LOWER_LEFT;
        this.requestType = 0;
        this.transparencySwitch = false;
        this.sdkMonitor = 0;
    }

    /* renamed from: A */
    public String m39884A() {
        return this.contenttaskinfo;
    }

    /* renamed from: B */
    public String m39886B() {
        return this.landPageWhiteList;
    }

    /* renamed from: C */
    public RewardItem m39888C() {
        return this.rewardItem;
    }

    /* renamed from: D */
    public String m39889D() {
        return this.whyThisAd;
    }

    /* renamed from: E */
    public String m39890E() {
        return this.adChoiceUrl;
    }

    /* renamed from: F */
    public String m39891F() {
        return this.adChoiceIcon;
    }

    /* renamed from: G */
    public Skip m39892G() {
        return this.skip;
    }

    /* renamed from: H */
    public int m39893H() {
        return this.requestType;
    }

    /* renamed from: I */
    public Integer m39894I() {
        return this.priority;
    }

    /* renamed from: J */
    public int m39895J() {
        return this.spare;
    }

    /* renamed from: K */
    public Integer m39896K() {
        return this.splashSkipBtnDelayTime;
    }

    /* renamed from: L */
    public Integer m39897L() {
        return this.splashShowTime;
    }

    /* renamed from: M */
    public String m39898M() {
        return this.proDesc;
    }

    /* renamed from: N */
    public int m39899N() {
        return this.useGaussianBlur;
    }

    /* renamed from: O */
    public String m39900O() {
        return this.jssdkAllowList;
    }

    /* renamed from: P */
    public List<ImpEX> m39901P() {
        return this.ext;
    }

    /* renamed from: Q */
    public List<ContentExt> m39902Q() {
        return this.contentExts;
    }

    /* renamed from: R */
    public String m39903R() {
        return this.landpgDlInteractionCfg;
    }

    /* renamed from: S */
    public InteractCfg m39904S() {
        return this.interactCfg;
    }

    /* renamed from: T */
    public List<NegativeFb> m39905T() {
        return this.negativeFbs;
    }

    /* renamed from: U */
    public Integer m39906U() {
        return this.apiVer;
    }

    /* renamed from: V */
    public List<Asset> m39907V() {
        if (this.assetsObj == null) {
            this.assetsObj = (List) AbstractC7758be.m47739b(this.assets, List.class, Asset.class);
        }
        return this.assetsObj;
    }

    /* renamed from: W */
    public TemplateV3 m39908W() {
        return this.template;
    }

    /* renamed from: X */
    public String m39909X() {
        return this.harmonyDetailInfo;
    }

    /* renamed from: Y */
    public String m39910Y() {
        return this.harmonyHwChannelId;
    }

    /* renamed from: Z */
    public List<AdvertiserInfo> m39911Z() {
        if (TextUtils.isEmpty(this.compliance)) {
            return null;
        }
        List<AdvertiserInfo> list = (List) AbstractC7758be.m47739b(AbstractC7806cz.m48168c(this.compliance), List.class, AdvertiserInfo.class);
        if (!AbstractC7760bg.m47767a(list)) {
            Collections.sort(list);
        }
        return list;
    }

    /* renamed from: a */
    public Integer m39912a() {
        return this.sdkMonitor;
    }

    /* renamed from: aa */
    public DefaultTemplate m39926aa() {
        return this.defaultTemplate;
    }

    /* renamed from: ab */
    public int m39927ab() {
        return this.recallSource;
    }

    /* renamed from: ac */
    public String m39928ac() {
        return this.ctrlExt;
    }

    /* renamed from: ad */
    public String m39929ad() {
        return this.transparencyTplUrl;
    }

    /* renamed from: ae */
    public Boolean m39930ae() {
        return Boolean.valueOf(this.transparencySwitch);
    }

    /* renamed from: af */
    public String m39931af() {
        return this.cshareUrl;
    }

    /* renamed from: ag */
    public String m39932ag() {
        return this.cur;
    }

    /* renamed from: ah */
    public Float m39933ah() {
        return this.price;
    }

    /* renamed from: ai */
    public String m39934ai() {
        return this.nurl;
    }

    /* renamed from: aj */
    public String m39935aj() {
        return this.lurl;
    }

    /* renamed from: ak */
    public String m39936ak() {
        return this.assets;
    }

    /* renamed from: al */
    public String m39937al() {
        return this.bubbleInfo;
    }

    /* renamed from: b */
    public String m39938b() {
        return this.skipText;
    }

    /* renamed from: c */
    public MetaData m39944c() {
        if (this.metaDataObj == null) {
            this.metaDataObj = (MetaData) AbstractC7758be.m47739b(this.metaData, MetaData.class, new Class[0]);
        }
        return this.metaDataObj;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        if (!(obj instanceof Content)) {
            return -1;
        }
        Content content = (Content) obj;
        if (content.m40003x() <= 0 || content.m40003x() > m40003x()) {
            return -1;
        }
        return content.m40003x() == m40003x() ? 0 : 1;
    }

    /* renamed from: d */
    public String m39949d() {
        return this.metaData;
    }

    /* renamed from: e */
    public List<C6957Om> m39954e() {
        return this.f32009om;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Content) {
            return this == obj || m40003x() == ((Content) obj).m40003x();
        }
        return false;
    }

    /* renamed from: f */
    public int m39958f() {
        return this.creativetype;
    }

    /* renamed from: g */
    public String m39962g() {
        return this.contentid;
    }

    /* renamed from: h */
    public String m39966h() {
        return this.taskid;
    }

    public int hashCode() {
        return super.hashCode();
    }

    /* renamed from: i */
    public int m39970i() {
        return this.showAppLogoFlag;
    }

    /* renamed from: j */
    public long m39974j() {
        return this.endtime;
    }

    /* renamed from: k */
    public long m39977k() {
        return this.starttime;
    }

    /* renamed from: l */
    public int m39979l() {
        return this.interactiontype;
    }

    /* renamed from: m */
    public String m39981m() {
        return this.paramfromserver;
    }

    /* renamed from: n */
    public List<String> m39983n() {
        return this.keyWords;
    }

    /* renamed from: o */
    public List<String> m39985o() {
        return this.keyWordsType;
    }

    /* renamed from: p */
    public List<Monitor> m39987p() {
        return this.monitor;
    }

    /* renamed from: q */
    public String m39989q() {
        return this.logo2Text;
    }

    /* renamed from: r */
    public int m39991r() {
        return this.landingTitle;
    }

    /* renamed from: s */
    public String m39993s() {
        return this.skipTextPos;
    }

    /* renamed from: t */
    public String m39995t() {
        return this.logo2Pos;
    }

    /* renamed from: u */
    public List<Integer> m39997u() {
        return this.clickActionList;
    }

    /* renamed from: v */
    public String m39999v() {
        return this.webConfig;
    }

    /* renamed from: w */
    public String m40001w() {
        return this.ctrlSwitchs;
    }

    /* renamed from: x */
    public int m40003x() {
        return this.sequence;
    }

    /* renamed from: y */
    public List<Integer> m40005y() {
        return this.filterList;
    }

    /* renamed from: z */
    public List<String> m40007z() {
        return this.noReportEventList;
    }

    public Content(Precontent precontent) {
        this.showAppLogoFlag = 1;
        this.starttime = -1L;
        this.interactiontype = 0;
        this.creativetype = 1;
        this.showid = "";
        this.skipTextPos = "tr";
        this.recallSource = 0;
        this.logo2Text = "";
        this.logo2Pos = LabelPosition.LOWER_LEFT;
        this.requestType = 0;
        this.transparencySwitch = false;
        this.sdkMonitor = 0;
        if (precontent != null) {
            this.contentid = precontent.m40415b();
            this.creativetype = precontent.m40419c();
            this.ctrlSwitchs = precontent.m40426f();
            this.noReportEventList = precontent.m40427g();
            MetaData metaData = new MetaData();
            metaData.m40298b(precontent.m40423d());
            metaData.m40289a(precontent.m40425e());
            metaData.m40308d(precontent.m40428h());
            this.metaData = AbstractC7758be.m47742b(metaData);
            this.priority = precontent.m40429i();
            this.apiVer = precontent.m40430j();
            this.assets = precontent.m40431k();
            this.template = precontent.m40432l();
        }
    }

    /* renamed from: A */
    public void m39885A(String str) {
        this.lurl = str;
    }

    /* renamed from: B */
    public void m39887B(String str) {
        this.bubbleInfo = str;
    }

    /* renamed from: a */
    public void m39913a(int i10) {
        this.creativetype = i10;
    }

    /* renamed from: b */
    public void m39939b(int i10) {
        this.showAppLogoFlag = i10;
    }

    /* renamed from: c */
    public void m39945c(int i10) {
        this.interactiontype = i10;
    }

    /* renamed from: d */
    public void m39950d(int i10) {
        this.landingTitle = i10;
    }

    /* renamed from: e */
    public void m39955e(int i10) {
        this.sequence = i10;
    }

    /* renamed from: f */
    public void m39959f(int i10) {
        this.requestType = i10;
    }

    /* renamed from: g */
    public void m39963g(int i10) {
        this.spare = i10;
    }

    /* renamed from: h */
    public void m39967h(int i10) {
        this.useGaussianBlur = i10;
    }

    /* renamed from: i */
    public void m39971i(int i10) {
        this.recallSource = i10;
    }

    /* renamed from: j */
    public void m39975j(String str) {
        this.ctrlSwitchs = str;
    }

    /* renamed from: k */
    public void m39978k(String str) {
        this.contenttaskinfo = str;
    }

    /* renamed from: l */
    public void m39980l(String str) {
        this.landPageWhiteList = str;
    }

    /* renamed from: m */
    public void m39982m(String str) {
        this.whyThisAd = str;
    }

    /* renamed from: n */
    public void m39984n(String str) {
        this.adChoiceUrl = str;
    }

    /* renamed from: o */
    public void m39986o(String str) {
        this.proDesc = str;
    }

    /* renamed from: p */
    public void m39988p(String str) {
        this.jssdkAllowList = str;
    }

    /* renamed from: q */
    public void m39990q(String str) {
        this.landpgDlInteractionCfg = str;
    }

    /* renamed from: r */
    public void m39992r(String str) {
        this.harmonyDetailInfo = str;
    }

    /* renamed from: s */
    public void m39994s(String str) {
        this.harmonyHwChannelId = str;
    }

    /* renamed from: t */
    public void m39996t(String str) {
        this.compliance = str;
    }

    /* renamed from: u */
    public void m39998u(String str) {
        this.ctrlExt = str;
    }

    /* renamed from: v */
    public void m40000v(String str) {
        this.transparencyTplUrl = str;
    }

    /* renamed from: w */
    public void m40002w(String str) {
        this.cshareUrl = str;
    }

    /* renamed from: x */
    public void m40004x(String str) {
        this.dspid = str;
    }

    /* renamed from: y */
    public void m40006y(String str) {
        this.cur = str;
    }

    /* renamed from: z */
    public void m40008z(String str) {
        this.nurl = str;
    }

    /* renamed from: a */
    public void m39914a(long j10) {
        this.endtime = j10;
    }

    /* renamed from: b */
    public void m39940b(long j10) {
        this.starttime = j10;
    }

    /* renamed from: c */
    public void m39946c(Integer num) {
        this.splashShowTime = num;
    }

    /* renamed from: d */
    public void m39951d(Integer num) {
        this.apiVer = num;
    }

    /* renamed from: e */
    public void m39956e(String str) {
        this.paramfromserver = str;
    }

    /* renamed from: f */
    public void m39960f(String str) {
        this.logo2Text = str;
    }

    /* renamed from: g */
    public void m39964g(String str) {
        this.skipTextPos = str;
    }

    /* renamed from: h */
    public void m39968h(String str) {
        this.logo2Pos = str;
    }

    /* renamed from: i */
    public void m39972i(String str) {
        this.webConfig = str;
    }

    /* renamed from: j */
    public void m39976j(List<Asset> list) {
        this.assetsObj = list;
    }

    /* renamed from: a */
    public void m39915a(DefaultTemplate defaultTemplate) {
        this.defaultTemplate = defaultTemplate;
    }

    /* renamed from: b */
    public void m39941b(Integer num) {
        this.splashSkipBtnDelayTime = num;
    }

    /* renamed from: c */
    public void m39947c(String str) {
        this.contentid = str;
    }

    /* renamed from: d */
    public void m39952d(String str) {
        this.taskid = str;
    }

    /* renamed from: e */
    public void m39957e(List<Integer> list) {
        this.clickActionList = list;
    }

    /* renamed from: f */
    public void m39961f(List<Integer> list) {
        this.filterList = list;
    }

    /* renamed from: g */
    public void m39965g(List<ImpEX> list) {
        this.ext = list;
    }

    /* renamed from: h */
    public void m39969h(List<ContentExt> list) {
        this.contentExts = list;
    }

    /* renamed from: i */
    public void m39973i(List<NegativeFb> list) {
        this.negativeFbs = list;
    }

    /* renamed from: a */
    public void m39916a(InteractCfg interactCfg) {
        this.interactCfg = interactCfg;
    }

    /* renamed from: b */
    public void m39942b(String str) {
        this.metaData = str;
    }

    /* renamed from: c */
    public void m39948c(List<String> list) {
        this.keyWordsType = list;
    }

    /* renamed from: d */
    public void m39953d(List<Monitor> list) {
        this.monitor = list;
    }

    /* renamed from: a */
    public void m39917a(Skip skip) {
        this.skip = skip;
    }

    /* renamed from: b */
    public void m39943b(List<String> list) {
        this.keyWords = list;
    }

    /* renamed from: a */
    public void m39918a(TemplateV3 templateV3) {
        this.template = templateV3;
    }

    /* renamed from: a */
    public void m39919a(DeviceAiParam deviceAiParam) {
        this.deviceAiParam = deviceAiParam;
    }

    /* renamed from: a */
    public void m39920a(RewardItem rewardItem) {
        this.rewardItem = rewardItem;
    }

    /* renamed from: a */
    public void m39921a(Float f10) {
        this.price = f10;
    }

    /* renamed from: a */
    public void m39922a(Integer num) {
        this.sdkMonitor = num;
    }

    /* renamed from: a */
    public void m39923a(String str) {
        this.skipText = str;
    }

    /* renamed from: a */
    public void m39924a(List<C6957Om> list) {
        this.f32009om = list;
    }

    /* renamed from: a */
    public void m39925a(List<AdTypeEvent> list, int i10) {
        List<String> listM39580b;
        if (AbstractC7760bg.m47767a(list)) {
            return;
        }
        for (AdTypeEvent adTypeEvent : list) {
            if (adTypeEvent != null && adTypeEvent.m39577a() == i10 && (listM39580b = adTypeEvent.m39580b()) != null && listM39580b.size() > 0) {
                ArrayList arrayList = new ArrayList();
                this.noReportEventList = arrayList;
                arrayList.addAll(listM39580b);
            }
        }
    }
}
