package com.huawei.openalliance.p169ad.p171db.bean;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.openalliance.p169ad.annotations.DataKeep;
import com.huawei.openalliance.p169ad.annotations.InterfaceC6931c;
import com.huawei.openalliance.p169ad.annotations.InterfaceC6933e;
import com.huawei.openalliance.p169ad.annotations.InterfaceC6934f;
import com.huawei.openalliance.p169ad.beans.metadata.ApkInfo;
import com.huawei.openalliance.p169ad.beans.metadata.C6957Om;
import com.huawei.openalliance.p169ad.beans.metadata.ContentExt;
import com.huawei.openalliance.p169ad.beans.metadata.CtrlExt;
import com.huawei.openalliance.p169ad.beans.metadata.DefaultTemplate;
import com.huawei.openalliance.p169ad.beans.metadata.ImageInfo;
import com.huawei.openalliance.p169ad.beans.metadata.ImpEX;
import com.huawei.openalliance.p169ad.beans.metadata.InteractCfg;
import com.huawei.openalliance.p169ad.beans.metadata.MediaFile;
import com.huawei.openalliance.p169ad.beans.metadata.MetaData;
import com.huawei.openalliance.p169ad.beans.metadata.Monitor;
import com.huawei.openalliance.p169ad.beans.metadata.PromoteInfo;
import com.huawei.openalliance.p169ad.beans.metadata.TextState;
import com.huawei.openalliance.p169ad.beans.metadata.VideoInfo;
import com.huawei.openalliance.p169ad.beans.metadata.p170v3.Asset;
import com.huawei.openalliance.p169ad.beans.metadata.p170v3.TemplateData;
import com.huawei.openalliance.p169ad.beans.vast.Tracking;
import com.huawei.openalliance.p169ad.inter.data.AdvertiserInfo;
import com.huawei.openalliance.p169ad.inter.data.AppInfo;
import com.huawei.openalliance.p169ad.inter.data.FeedbackInfo;
import com.huawei.openalliance.p169ad.inter.data.RewardItem;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7758be;
import com.huawei.openalliance.p169ad.utils.AbstractC7760bg;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

@DataKeep
/* loaded from: classes2.dex */
public class ContentRecord extends C7013a implements Serializable {
    public static final String AD_TYPE = "adType";
    public static final String API_VER = "apiVer";
    public static final String CONTENT_ID = "contentId";

    @InterfaceC6933e
    public static final String CREATIVE_TYPE = "creativeType";
    public static final String DISPLAY_COUNT = "displayCount";
    public static final String DISPLAY_DATE = "displayDate";
    public static final String END_TIME = "endTime";
    public static final String FC_CTRL_DATE = "fcCtrlDate";
    public static final String HEIGHT = "height";
    public static final String LAST_SHOW_TIME = "lastShowTime";
    public static final String PRIORITY = "priority";
    public static final String SLOT_ID = "slotId";
    public static final String SPLASH_MEDIA_PATH = "splashMediaPath";
    public static final String SPLASH_PRE_CONTENT_FLAG = "splashPreContentFlag";
    public static final String START_TIME = "startTime";
    public static final String TASK_ID = "taskId";
    public static final String TEMPLATE_ID = "templateId";
    public static final String UNIQUE_ID = "uniqueId";
    public static final String UPDATE_TIME = "updateTime";
    public static final String WIDTH = "width";
    private static final long serialVersionUID = 30414300;
    private String abilityDetailInfo;
    private String adChoiceIcon;
    private String adChoiceUrl;

    @InterfaceC6933e
    private long addTime;
    private int apiVer;
    private String appCountry;
    private String appLanguage;

    @InterfaceC6931c
    private List<Asset> assets;
    private String bubbleInfo;
    private String cid;
    private List<Integer> clickActionList;
    private List<AdvertiserInfo> compliance;
    private String configMap;
    private String contentDownMethod;
    private List<ContentExt> contentExts;
    private String contentId_;

    @InterfaceC6934f
    @InterfaceC6933e
    private String cshareUrl;
    private String ctrlExt;

    @InterfaceC6933e
    private CtrlExt ctrlExtObj;
    private String ctrlSwitchs;
    private String cur;
    private String customData;
    private DefaultTemplate defaultTemplate;
    private String detailUrl_;
    private int displayCount_;
    private String displayDate_;
    private long endTime_;
    private int exposure;
    private List<ImpEX> ext;
    private List<FeedbackInfo> feedbackInfoList;
    private String fileCachePriority;
    private boolean hasSetShowId;
    private int height_;
    private String hwChannelId;
    private String intentUri_;
    private InteractCfg interactCfg;
    private int interactiontype_;

    @InterfaceC6933e
    private String isAdContainerSizeMatched;

    @InterfaceC6934f
    private EncryptionField<String> jssdkAllowListStr;
    private List<String> keyWords;
    private List<String> keyWordsType;

    @InterfaceC6934f
    private EncryptionField<String> landPageWhiteListStr;
    private int landingTitleFlag;
    private String landingType;
    private String landpgDlInteractionCfg;
    private long lastShowTime_;
    private String logo2Pos;
    private String logo2Text;
    private String lurl;

    @InterfaceC6933e
    private Map<String, String> mapConfigMap;
    private long maxEffectiveShowTime;

    @InterfaceC6933e
    private MetaData metaDataInner;
    private String metaData_;
    private int minEffectiveShowRatio;
    private long minEffectiveShowTime;
    private int minEffectiveVideoPlayProgress;

    @InterfaceC6934f
    private EncryptionField<List<Monitor>> monitors;
    private List<String> noReportEventList;
    private String nurl;

    /* renamed from: om */
    @InterfaceC6934f
    private EncryptionField<List<C6957Om>> f32160om;

    @InterfaceC6934f
    private EncryptionField<String> paramFromServer;

    @InterfaceC6934f
    private EncryptionField<String> price;
    private int priority_;
    private String proDesc;
    private String realAppPkgName;
    private int recallSource;
    private String recordtaskinfo;

    @InterfaceC6933e
    private String requestId;
    private int rewardAmount;
    private RewardItem rewardItem;
    private String rewardType;
    private int sdkMonitor;
    private int skipTextHeight;
    private String skipTextPos;
    private int skipTextSize;
    private String skipText_;
    private String slotId_;
    private String splashMediaPath;
    private int splashPreContentFlag_;
    private long startShowTime;
    private long startTime_;
    private String strAssets;
    private String style;
    private String styleExt;
    private String taskId_;

    @InterfaceC6933e
    private TemplateData templateData;
    private String templateId;

    @InterfaceC6933e
    private String templateStyle;
    private String templateUrl;
    private List<TextState> textStateList;
    private String trackVersion;
    private Map<String, List<Tracking>> trackingEvents;
    private int transparencySwitch;
    private String transparencyTplUrl;
    private String uniqueId;
    private String uniqueIdForUnifyDownload;
    private long updateTime_;
    private int useGaussianBlur;
    private String userId;

    @InterfaceC6933e
    private long videoTime;
    private String webConfig;
    private String whyThisAd;
    private int width_;

    @InterfaceC6933e
    private String showId = String.valueOf(AbstractC7741ao.m47566c());
    private int showAppLogoFlag_ = 1;
    private String fcCtrlDate_ = "";
    private int creativeType_ = 2;
    private int adType_ = -1;

    @InterfaceC6933e
    private boolean autoDownloadApp = false;
    private int requestType = 0;

    @InterfaceC6933e
    private boolean isFromExSplash = false;

    @InterfaceC6933e
    private boolean isSpare = false;
    private int splashSkipBtnDelayTime = -111111;
    private int splashShowTime = -111111;
    private int isVastAd = 0;

    @InterfaceC6933e
    private boolean isPreload = false;

    /* renamed from: A */
    public String m41384A() {
        MetaData metaDataM41568i = m41568i();
        if (metaDataM41568i != null) {
            return metaDataM41568i.m40267D();
        }
        return null;
    }

    /* renamed from: B */
    public String m41386B() {
        return this.detailUrl_;
    }

    /* renamed from: C */
    public int m41388C() {
        return this.interactiontype_;
    }

    /* renamed from: D */
    public int m41390D() {
        return this.priority_;
    }

    /* renamed from: E */
    public int m41392E() {
        return this.creativeType_;
    }

    /* renamed from: F */
    public void m41394F(String str) {
        this.proDesc = str;
    }

    /* renamed from: G */
    public EncryptionField<String> m41395G() {
        return this.paramFromServer;
    }

    /* renamed from: H */
    public String m41397H() {
        return this.intentUri_;
    }

    /* renamed from: I */
    public void m41399I() {
        this.displayCount_++;
        this.priority_ = 1;
        this.lastShowTime_ = AbstractC7741ao.m47566c();
    }

    /* renamed from: J */
    public List<String> m41401J() {
        return this.keyWords;
    }

    /* renamed from: K */
    public List<String> m41403K() {
        return this.keyWordsType;
    }

    /* renamed from: L */
    public EncryptionField<List<Monitor>> m41405L() {
        return this.monitors;
    }

    /* renamed from: M */
    public String m41407M() {
        return this.skipTextPos;
    }

    /* renamed from: N */
    public List<Integer> m41409N() {
        return this.clickActionList;
    }

    /* renamed from: O */
    public String m41411O() {
        return this.logo2Text;
    }

    /* renamed from: P */
    public int m41413P() {
        return this.landingTitleFlag;
    }

    /* renamed from: Q */
    public String m41415Q() {
        return this.logo2Pos;
    }

    /* renamed from: R */
    public ImageInfo m41417R() {
        List<ImageInfo> listM40334p;
        MetaData metaData = (MetaData) AbstractC7758be.m47739b(this.metaData_, MetaData.class, new Class[0]);
        if (metaData == null || (listM40334p = metaData.m40334p()) == null || listM40334p.size() <= 0) {
            return null;
        }
        return listM40334p.get(0);
    }

    /* renamed from: S */
    public VideoInfo m41419S() {
        MetaData metaData = (MetaData) AbstractC7758be.m47739b(this.metaData_, MetaData.class, new Class[0]);
        if (metaData != null) {
            return metaData.m40305d();
        }
        return null;
    }

    /* renamed from: T */
    public MediaFile m41421T() {
        MetaData metaDataM41568i = m41568i();
        if (metaDataM41568i != null) {
            return metaDataM41568i.m40342v();
        }
        return null;
    }

    /* renamed from: U */
    public String m41423U() {
        return this.contentDownMethod;
    }

    /* renamed from: V */
    public String m41425V() {
        return this.webConfig;
    }

    /* renamed from: W */
    public String m41427W() {
        return this.ctrlSwitchs;
    }

    /* renamed from: X */
    public List<TextState> m41429X() {
        return this.textStateList;
    }

    /* renamed from: Y */
    public List<String> m41431Y() {
        return this.noReportEventList;
    }

    /* renamed from: Z */
    public String m41433Z() {
        return this.recordtaskinfo;
    }

    /* renamed from: a */
    public List<Monitor> m41435a(Context context) {
        EncryptionField<List<Monitor>> encryptionField = this.monitors;
        if (encryptionField != null) {
            return encryptionField.m41652a(context);
        }
        return null;
    }

    /* renamed from: aA */
    public int m41449aA() {
        if (m41421T() != null) {
            return m41421T().m40260i();
        }
        if (m41419S() != null) {
            return m41419S().m40495h();
        }
        return -1;
    }

    /* renamed from: aB */
    public String m41450aB() {
        return this.customData;
    }

    /* renamed from: aC */
    public String m41451aC() {
        return this.userId;
    }

    /* renamed from: aD */
    public int m41452aD() {
        return this.useGaussianBlur;
    }

    /* renamed from: aE */
    public EncryptionField<String> m41453aE() {
        return this.jssdkAllowListStr;
    }

    /* renamed from: aF */
    public List<ImpEX> m41454aF() {
        return this.ext;
    }

    /* renamed from: aG */
    public List<ContentExt> m41455aG() {
        return this.contentExts;
    }

    /* renamed from: aH */
    public String m41456aH() {
        return this.landpgDlInteractionCfg;
    }

    /* renamed from: aI */
    public String m41457aI() {
        return this.configMap;
    }

    /* renamed from: aJ */
    public Map<String, String> m41458aJ() {
        if (this.mapConfigMap == null) {
            this.mapConfigMap = (Map) AbstractC7758be.m47739b(this.configMap, Map.class, new Class[0]);
        }
        return this.mapConfigMap;
    }

    /* renamed from: aK */
    public InteractCfg m41459aK() {
        return this.interactCfg;
    }

    /* renamed from: aL */
    public long m41460aL() {
        return this.startShowTime;
    }

    /* renamed from: aM */
    public List<FeedbackInfo> m41461aM() {
        return this.feedbackInfoList;
    }

    /* renamed from: aN */
    public boolean m41462aN() {
        return 1 == this.isVastAd;
    }

    /* renamed from: aO */
    public String m41463aO() {
        return this.templateId;
    }

    /* renamed from: aP */
    public int m41464aP() {
        return this.apiVer;
    }

    /* renamed from: aQ */
    public String m41465aQ() {
        return this.templateStyle;
    }

    /* renamed from: aR */
    public String m41466aR() {
        return this.abilityDetailInfo;
    }

    /* renamed from: aS */
    public String m41467aS() {
        return this.hwChannelId;
    }

    /* renamed from: aT */
    public List<AdvertiserInfo> m41468aT() {
        return this.compliance;
    }

    /* renamed from: aU */
    public TemplateData m41469aU() {
        return this.templateData;
    }

    /* renamed from: aV */
    public DefaultTemplate m41470aV() {
        return this.defaultTemplate;
    }

    /* renamed from: aW */
    public List<Asset> m41471aW() {
        return this.assets;
    }

    /* renamed from: aX */
    public int m41472aX() {
        return this.recallSource;
    }

    /* renamed from: aY */
    public String m41473aY() {
        return this.templateUrl;
    }

    /* renamed from: aZ */
    public String m41474aZ() {
        return this.ctrlExt;
    }

    @Override // com.huawei.openalliance.p169ad.p171db.bean.C7013a
    /* renamed from: a_ */
    public String mo41475a_() {
        return "materialId";
    }

    /* renamed from: aa */
    public String m41476aa() {
        return this.whyThisAd;
    }

    /* renamed from: ab */
    public String m41478ab() {
        return this.uniqueId;
    }

    /* renamed from: ac */
    public EncryptionField<String> m41480ac() {
        return this.landPageWhiteListStr;
    }

    /* renamed from: ad */
    public boolean m41482ad() {
        return this.autoDownloadApp;
    }

    /* renamed from: ae */
    public String m41483ae() {
        return this.landingType;
    }

    /* renamed from: af */
    public AppInfo m41484af() {
        ApkInfo apkInfoM40339s;
        MetaData metaDataM41568i = m41568i();
        if (metaDataM41568i == null || (apkInfoM40339s = metaDataM41568i.m40339s()) == null) {
            return null;
        }
        AppInfo appInfo = new AppInfo(apkInfoM40339s);
        appInfo.m44415m(metaDataM41568i.m40332o());
        appInfo.m44433v(this.uniqueId);
        appInfo.m44402h(metaDataM41568i.m40266C());
        return appInfo;
    }

    /* renamed from: ag */
    public PromoteInfo m41485ag() {
        MetaData metaDataM41568i = m41568i();
        if (metaDataM41568i == null) {
            return null;
        }
        return metaDataM41568i.m40340t();
    }

    /* renamed from: ah */
    public String m41486ah() {
        return this.requestId;
    }

    /* renamed from: ai */
    public RewardItem m41487ai() {
        return this.rewardItem;
    }

    /* renamed from: aj */
    public int m41488aj() {
        return this.skipTextSize;
    }

    /* renamed from: ak */
    public int m41489ak() {
        return this.skipTextHeight;
    }

    /* renamed from: al */
    public String m41490al() {
        return this.adChoiceUrl;
    }

    /* renamed from: am */
    public String m41491am() {
        return this.adChoiceIcon;
    }

    /* renamed from: an */
    public int m41492an() {
        return this.requestType;
    }

    /* renamed from: ao */
    public String m41493ao() {
        return this.fileCachePriority;
    }

    /* renamed from: ap */
    public String m41494ap() {
        return this.isAdContainerSizeMatched;
    }

    /* renamed from: aq */
    public boolean m41495aq() {
        return this.isFromExSplash;
    }

    /* renamed from: ar */
    public String m41496ar() {
        return this.appLanguage;
    }

    /* renamed from: as */
    public String m41497as() {
        return this.appCountry;
    }

    /* renamed from: at */
    public boolean m41498at() {
        return this.isSpare;
    }

    /* renamed from: au */
    public int m41499au() {
        return this.splashSkipBtnDelayTime;
    }

    /* renamed from: av */
    public int m41500av() {
        return this.splashShowTime;
    }

    /* renamed from: aw */
    public String m41501aw() {
        return this.rewardType;
    }

    /* renamed from: ax */
    public int m41502ax() {
        return this.rewardAmount;
    }

    /* renamed from: ay */
    public String m41503ay() {
        return AbstractC7806cz.m48168c(this.proDesc);
    }

    /* renamed from: az */
    public String m41504az() {
        MetaData metaDataM41568i = m41568i();
        if (metaDataM41568i == null) {
            return null;
        }
        VideoInfo videoInfoM40305d = metaDataM41568i.m40305d();
        if (videoInfoM40305d != null) {
            return String.valueOf(videoInfoM40305d.m40481c());
        }
        MediaFile mediaFileM40342v = metaDataM41568i.m40342v();
        if (mediaFileM40342v != null) {
            return String.valueOf(mediaFileM40342v.m40253d());
        }
        List<ImageInfo> listM40334p = metaDataM41568i.m40334p();
        if (!AbstractC7760bg.m47767a(listM40334p)) {
            for (ImageInfo imageInfo : listM40334p) {
                if (imageInfo != null) {
                    return String.valueOf(imageInfo.m40186f());
                }
            }
        }
        List<ImageInfo> listM40315g = metaDataM41568i.m40315g();
        if (!AbstractC7760bg.m47767a(listM40315g)) {
            for (ImageInfo imageInfo2 : listM40315g) {
                if (imageInfo2 != null) {
                    return String.valueOf(imageInfo2.m40186f());
                }
            }
        }
        return null;
    }

    /* renamed from: b */
    public int m41505b() {
        return this.sdkMonitor;
    }

    /* renamed from: ba */
    public CtrlExt m41514ba() {
        if (this.ctrlExtObj == null) {
            this.ctrlExtObj = (CtrlExt) AbstractC7758be.m47739b(this.ctrlExt, CtrlExt.class, new Class[0]);
        }
        return this.ctrlExtObj;
    }

    /* renamed from: bb */
    public String m41515bb() {
        return this.uniqueIdForUnifyDownload;
    }

    /* renamed from: bc */
    public String m41516bc() {
        return this.transparencyTplUrl;
    }

    /* renamed from: bd */
    public boolean m41517bd() {
        return this.transparencySwitch == 1;
    }

    /* renamed from: be */
    public long m41518be() {
        return this.addTime;
    }

    /* renamed from: bf */
    public long m41519bf() {
        return this.videoTime;
    }

    /* renamed from: bg */
    public String m41520bg() {
        return this.realAppPkgName;
    }

    /* renamed from: bh */
    public boolean m41521bh() {
        return this.isPreload;
    }

    /* renamed from: bi */
    public String m41522bi() {
        return this.cur;
    }

    /* renamed from: bj */
    public EncryptionField<String> m41523bj() {
        EncryptionField<String> encryptionField = this.price;
        if (encryptionField == null) {
            return null;
        }
        return encryptionField;
    }

    /* renamed from: bk */
    public String m41524bk() {
        return this.nurl;
    }

    /* renamed from: bl */
    public String m41525bl() {
        return this.lurl;
    }

    /* renamed from: bm */
    public String m41526bm() {
        return this.style;
    }

    /* renamed from: bn */
    public String m41527bn() {
        return this.styleExt;
    }

    /* renamed from: bo */
    public String m41528bo() {
        return this.strAssets;
    }

    /* renamed from: bp */
    public String m41529bp() {
        return this.trackVersion;
    }

    /* renamed from: bq */
    public String m41530bq() {
        return this.bubbleInfo;
    }

    /* renamed from: c */
    public long m41531c() {
        return this.minEffectiveShowTime;
    }

    /* renamed from: d */
    public int m41539d() {
        return this.minEffectiveShowRatio;
    }

    /* renamed from: e */
    public int m41546e() {
        return this.minEffectiveVideoPlayProgress;
    }

    /* renamed from: f */
    public int m41552f() {
        return this.adType_;
    }

    /* renamed from: g */
    public String m41558g() {
        return this.skipText_;
    }

    /* renamed from: h */
    public String m41563h() {
        return this.metaData_;
    }

    /* renamed from: i */
    public MetaData m41568i() {
        String str = this.metaData_;
        if (str == null) {
            return null;
        }
        return (MetaData) AbstractC7758be.m47739b(str, MetaData.class, new Class[0]);
    }

    /* renamed from: j */
    public int m41573j() {
        return this.splashPreContentFlag_;
    }

    /* renamed from: k */
    public String m41577k() {
        return this.showId;
    }

    /* renamed from: l */
    public int m41581l() {
        return this.exposure;
    }

    /* renamed from: m */
    public String m41585m() {
        return this.slotId_;
    }

    /* renamed from: n */
    public String m41588n() {
        return this.contentId_;
    }

    /* renamed from: o */
    public String m41591o() {
        return this.taskId_;
    }

    /* renamed from: p */
    public int m41594p() {
        return this.showAppLogoFlag_;
    }

    /* renamed from: q */
    public long m41597q() {
        return this.lastShowTime_;
    }

    /* renamed from: r */
    public long m41600r() {
        return this.endTime_;
    }

    /* renamed from: s */
    public long m41603s() {
        return this.startTime_;
    }

    /* renamed from: t */
    public int m41606t() {
        return this.width_;
    }

    /* renamed from: u */
    public int m41609u() {
        return this.height_;
    }

    /* renamed from: v */
    public long m41611v() {
        return this.updateTime_;
    }

    /* renamed from: w */
    public String m41613w() {
        return this.fcCtrlDate_;
    }

    /* renamed from: x */
    public int m41615x() {
        return this.displayCount_;
    }

    /* renamed from: y */
    public String m41617y() {
        return this.displayDate_;
    }

    /* renamed from: z */
    public String m41619z() {
        return this.splashMediaPath;
    }

    /* renamed from: A */
    public void m41385A(String str) {
        this.adChoiceIcon = str;
    }

    /* renamed from: B */
    public void m41387B(String str) {
        this.fileCachePriority = str;
    }

    /* renamed from: C */
    public void m41389C(String str) {
        this.isAdContainerSizeMatched = str;
    }

    /* renamed from: D */
    public void m41391D(String str) {
        this.appLanguage = str;
    }

    /* renamed from: E */
    public void m41393E(String str) {
        this.appCountry = str;
    }

    /* renamed from: G */
    public void m41396G(String str) {
        this.customData = str;
    }

    /* renamed from: H */
    public void m41398H(String str) {
        this.userId = str;
    }

    /* renamed from: I */
    public void m41400I(String str) {
        if (this.jssdkAllowListStr == null) {
            this.jssdkAllowListStr = new EncryptionField<>(String.class);
        }
        this.jssdkAllowListStr.m41655a((EncryptionField<String>) str);
    }

    /* renamed from: J */
    public void m41402J(String str) {
        this.landpgDlInteractionCfg = str;
    }

    /* renamed from: K */
    public void m41404K(String str) {
        this.configMap = str;
    }

    /* renamed from: L */
    public void m41406L(String str) {
        this.templateId = str;
    }

    /* renamed from: M */
    public void m41408M(String str) {
        this.templateStyle = str;
    }

    /* renamed from: N */
    public void m41410N(String str) {
        this.abilityDetailInfo = str;
    }

    /* renamed from: O */
    public void m41412O(String str) {
        this.hwChannelId = str;
    }

    /* renamed from: P */
    public void m41414P(String str) {
        this.templateUrl = str;
    }

    /* renamed from: Q */
    public void m41416Q(String str) {
        this.ctrlExt = str;
    }

    /* renamed from: R */
    public void m41418R(String str) {
        this.uniqueIdForUnifyDownload = str;
    }

    /* renamed from: S */
    public void m41420S(String str) {
        this.transparencyTplUrl = str;
    }

    /* renamed from: T */
    public void m41422T(String str) {
        this.realAppPkgName = str;
    }

    /* renamed from: U */
    public void m41424U(String str) {
        this.cshareUrl = str;
    }

    /* renamed from: V */
    public void m41426V(String str) {
        this.cur = str;
    }

    /* renamed from: W */
    public void m41428W(String str) {
        this.nurl = str;
    }

    /* renamed from: X */
    public void m41430X(String str) {
        this.lurl = str;
    }

    /* renamed from: Y */
    public void m41432Y(String str) {
        this.style = str;
    }

    /* renamed from: Z */
    public void m41434Z(String str) {
        this.styleExt = str;
    }

    /* renamed from: a */
    public void m41436a(int i10) {
        this.minEffectiveShowRatio = i10;
    }

    /* renamed from: aa */
    public void m41477aa(String str) {
        this.strAssets = str;
    }

    /* renamed from: ab */
    public void m41479ab(String str) {
        this.trackVersion = str;
    }

    /* renamed from: ac */
    public void m41481ac(String str) {
        this.bubbleInfo = str;
    }

    /* renamed from: b */
    public List<C6957Om> m41506b(Context context) {
        EncryptionField<List<C6957Om>> encryptionField = this.f32160om;
        if (encryptionField != null) {
            return encryptionField.m41652a(context);
        }
        return null;
    }

    /* renamed from: c */
    public String m41532c(Context context) {
        EncryptionField<String> encryptionField = this.paramFromServer;
        if (encryptionField != null) {
            return encryptionField.m41652a(context);
        }
        return null;
    }

    /* renamed from: d */
    public void m41540d(int i10) {
        this.exposure = i10;
    }

    /* renamed from: e */
    public void m41547e(int i10) {
        this.showAppLogoFlag_ = i10;
    }

    /* renamed from: f */
    public void m41553f(int i10) {
        this.width_ = i10;
    }

    /* renamed from: g */
    public void m41559g(int i10) {
        this.height_ = i10;
    }

    /* renamed from: h */
    public void m41564h(int i10) {
        this.displayCount_ = i10;
    }

    /* renamed from: i */
    public void m41569i(int i10) {
        this.interactiontype_ = i10;
    }

    /* renamed from: j */
    public void m41574j(int i10) {
        this.priority_ = i10;
    }

    /* renamed from: k */
    public void m41578k(int i10) {
        this.creativeType_ = i10;
    }

    /* renamed from: l */
    public void m41582l(int i10) {
        this.landingTitleFlag = i10;
    }

    /* renamed from: m */
    public void m41586m(int i10) {
        this.skipTextSize = i10;
    }

    /* renamed from: n */
    public void m41589n(int i10) {
        this.skipTextHeight = i10;
    }

    /* renamed from: o */
    public void m41592o(int i10) {
        this.requestType = i10;
    }

    /* renamed from: p */
    public void m41595p(int i10) {
        this.splashSkipBtnDelayTime = i10;
    }

    /* renamed from: q */
    public void m41598q(int i10) {
        this.splashShowTime = i10;
    }

    /* renamed from: r */
    public void m41601r(int i10) {
        this.useGaussianBlur = i10;
    }

    /* renamed from: s */
    public void m41604s(int i10) {
        this.apiVer = i10;
    }

    /* renamed from: t */
    public void m41607t(int i10) {
        this.recallSource = i10;
    }

    /* renamed from: u */
    public void m41610u(String str) {
        this.whyThisAd = str;
    }

    /* renamed from: v */
    public void m41612v(String str) {
        this.uniqueId = str;
    }

    /* renamed from: w */
    public void m41614w(String str) {
        if (this.landPageWhiteListStr == null) {
            this.landPageWhiteListStr = new EncryptionField<>(String.class);
        }
        this.landPageWhiteListStr.m41655a((EncryptionField<String>) str);
    }

    /* renamed from: x */
    public void m41616x(String str) {
        this.landingType = str;
    }

    /* renamed from: y */
    public void m41618y(String str) {
        this.requestId = str;
    }

    /* renamed from: z */
    public void m41620z(String str) {
        this.adChoiceUrl = str;
    }

    /* renamed from: a */
    public void m41437a(long j10) {
        this.minEffectiveShowTime = j10;
    }

    /* renamed from: b */
    public void m41507b(int i10) {
        this.adType_ = i10;
    }

    /* renamed from: c */
    public void m41533c(int i10) {
        this.splashPreContentFlag_ = i10;
    }

    /* renamed from: d */
    public void m41541d(long j10) {
        this.endTime_ = j10;
    }

    /* renamed from: e */
    public void m41548e(long j10) {
        this.startTime_ = j10;
    }

    /* renamed from: f */
    public void m41554f(long j10) {
        this.updateTime_ = j10;
    }

    /* renamed from: g */
    public void m41560g(long j10) {
        this.startShowTime = j10;
    }

    /* renamed from: h */
    public void m41565h(long j10) {
        this.addTime = j10;
    }

    /* renamed from: i */
    public void m41570i(long j10) {
        this.videoTime = j10;
    }

    /* renamed from: j */
    public void m41575j(String str) {
        MetaData metaDataM41568i;
        if (TextUtils.isEmpty(str) || (metaDataM41568i = m41568i()) == null) {
            return;
        }
        metaDataM41568i.m40331n(str);
        m41511b(AbstractC7758be.m47742b(metaDataM41568i));
    }

    /* renamed from: k */
    public void m41579k(String str) {
        this.detailUrl_ = str;
    }

    /* renamed from: l */
    public void m41583l(String str) {
        if (this.paramFromServer == null) {
            this.paramFromServer = new EncryptionField<>(String.class);
        }
        this.paramFromServer.m41655a((EncryptionField<String>) str);
    }

    /* renamed from: m */
    public void m41587m(String str) {
        this.intentUri_ = str;
    }

    /* renamed from: n */
    public void m41590n(String str) {
        this.skipTextPos = str;
    }

    /* renamed from: o */
    public void m41593o(String str) {
        this.logo2Text = str;
    }

    /* renamed from: p */
    public void m41596p(String str) {
        this.logo2Pos = str;
    }

    /* renamed from: q */
    public void m41599q(String str) {
        this.contentDownMethod = str;
    }

    /* renamed from: r */
    public void m41602r(String str) {
        this.webConfig = str;
    }

    /* renamed from: s */
    public void m41605s(String str) {
        this.ctrlSwitchs = str;
    }

    /* renamed from: t */
    public void m41608t(String str) {
        this.recordtaskinfo = str;
    }

    /* renamed from: a */
    public void m41438a(DefaultTemplate defaultTemplate) {
        this.defaultTemplate = defaultTemplate;
    }

    /* renamed from: b */
    public void m41508b(long j10) {
        this.maxEffectiveShowTime = j10;
    }

    /* renamed from: c */
    public void m41534c(long j10) {
        this.lastShowTime_ = j10;
    }

    /* renamed from: d */
    public void m41542d(EncryptionField<String> encryptionField) {
        this.jssdkAllowListStr = encryptionField;
    }

    /* renamed from: e */
    public void m41549e(String str) {
        this.contentId_ = str;
    }

    /* renamed from: f */
    public void m41555f(String str) {
        this.taskId_ = str;
    }

    /* renamed from: g */
    public void m41561g(String str) {
        this.fcCtrlDate_ = str;
    }

    /* renamed from: h */
    public void m41566h(String str) {
        this.displayDate_ = str;
    }

    /* renamed from: i */
    public void m41571i(String str) {
        this.splashMediaPath = str;
    }

    /* renamed from: j */
    public void m41576j(List<FeedbackInfo> list) {
        this.feedbackInfoList = list;
    }

    /* renamed from: k */
    public void m41580k(List<AdvertiserInfo> list) {
        this.compliance = list;
    }

    /* renamed from: l */
    public void m41584l(List<Asset> list) {
        this.assets = list;
    }

    /* renamed from: a */
    public void m41439a(InteractCfg interactCfg) {
        this.interactCfg = interactCfg;
    }

    /* renamed from: b */
    public void m41509b(EncryptionField<List<Monitor>> encryptionField) {
        this.monitors = encryptionField;
    }

    /* renamed from: c */
    public void m41535c(EncryptionField<String> encryptionField) {
        this.landPageWhiteListStr = encryptionField;
    }

    /* renamed from: d */
    public void m41543d(String str) {
        this.slotId_ = str;
    }

    /* renamed from: e */
    public void m41550e(List<Integer> list) {
        this.clickActionList = list;
    }

    /* renamed from: f */
    public void m41556f(List<TextState> list) {
        this.textStateList = list;
    }

    /* renamed from: g */
    public void m41562g(List<String> list) {
        this.noReportEventList = list;
    }

    /* renamed from: h */
    public void m41567h(List<ImpEX> list) {
        this.ext = list;
    }

    /* renamed from: i */
    public void m41572i(List<ContentExt> list) {
        this.contentExts = list;
    }

    /* renamed from: a */
    public void m41440a(TemplateData templateData) {
        this.templateData = templateData;
    }

    /* renamed from: b */
    public void m41510b(Integer num) {
        if (num != null) {
            this.minEffectiveVideoPlayProgress = num.intValue();
        }
    }

    /* renamed from: c */
    public void m41536c(String str) {
        this.showId = str;
        this.hasSetShowId = true;
    }

    /* renamed from: d */
    public void m41544d(List<C6957Om> list) {
        EncryptionField<List<C6957Om>> encryptionField = new EncryptionField<>(List.class, C6957Om.class);
        encryptionField.m41655a((EncryptionField<List<C6957Om>>) list);
        this.f32160om = encryptionField;
    }

    /* renamed from: e */
    public void m41551e(boolean z10) {
        this.transparencySwitch = z10 ? 1 : 0;
    }

    /* renamed from: f */
    public void m41557f(boolean z10) {
        this.isPreload = z10;
    }

    /* renamed from: a */
    public void m41441a(EncryptionField<String> encryptionField) {
        this.paramFromServer = encryptionField;
    }

    /* renamed from: b */
    public void m41511b(String str) {
        this.metaData_ = str;
    }

    /* renamed from: c */
    public void m41537c(List<Monitor> list) {
        EncryptionField<List<Monitor>> encryptionField = new EncryptionField<>(List.class, Monitor.class);
        encryptionField.m41655a((EncryptionField<List<Monitor>>) list);
        this.monitors = encryptionField;
    }

    /* renamed from: d */
    public void m41545d(boolean z10) {
        this.isVastAd = z10 ? 1 : 0;
    }

    /* renamed from: a */
    public void m41442a(RewardItem rewardItem) {
        this.rewardItem = rewardItem;
    }

    /* renamed from: b */
    public void m41512b(List<String> list) {
        this.keyWordsType = list;
    }

    /* renamed from: c */
    public void m41538c(boolean z10) {
        this.isSpare = z10;
    }

    /* renamed from: a */
    public void m41443a(Float f10) {
        if (f10 == null) {
            return;
        }
        if (this.price == null) {
            this.price = new EncryptionField<>(Float.class);
        }
        this.price.m41655a((EncryptionField<String>) f10.toString());
    }

    /* renamed from: b */
    public void m41513b(boolean z10) {
        this.isFromExSplash = z10;
    }

    /* renamed from: a */
    public void m41444a(Integer num) {
        if (num != null) {
            this.sdkMonitor = num.intValue();
        }
    }

    /* renamed from: a */
    public void m41445a(String str) {
        this.skipText_ = str;
    }

    /* renamed from: a */
    public void m41446a(List<String> list) {
        this.keyWords = list;
    }

    /* renamed from: a */
    public void m41447a(boolean z10) {
        this.autoDownloadApp = z10;
    }

    /* renamed from: a */
    public boolean m41448a() {
        return this.hasSetShowId;
    }
}
