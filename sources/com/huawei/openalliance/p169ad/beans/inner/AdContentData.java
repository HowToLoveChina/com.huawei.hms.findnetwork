package com.huawei.openalliance.p169ad.beans.inner;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.ads.VideoConfiguration;
import com.huawei.openalliance.p169ad.C7019dh;
import com.huawei.openalliance.p169ad.annotations.DataKeep;
import com.huawei.openalliance.p169ad.annotations.InterfaceC6929a;
import com.huawei.openalliance.p169ad.annotations.InterfaceC6934f;
import com.huawei.openalliance.p169ad.beans.metadata.C6957Om;
import com.huawei.openalliance.p169ad.beans.metadata.ContentExt;
import com.huawei.openalliance.p169ad.beans.metadata.CtrlExt;
import com.huawei.openalliance.p169ad.beans.metadata.DefaultTemplate;
import com.huawei.openalliance.p169ad.beans.metadata.ImpEX;
import com.huawei.openalliance.p169ad.beans.metadata.InteractCfg;
import com.huawei.openalliance.p169ad.beans.metadata.MetaData;
import com.huawei.openalliance.p169ad.beans.metadata.TextState;
import com.huawei.openalliance.p169ad.beans.metadata.p170v3.Asset;
import com.huawei.openalliance.p169ad.beans.metadata.p170v3.TemplateData;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.Scheme;
import com.huawei.openalliance.p169ad.inter.data.AdvertiserInfo;
import com.huawei.openalliance.p169ad.inter.data.C7302e;
import com.huawei.openalliance.p169ad.inter.data.FeedbackInfo;
import com.huawei.openalliance.p169ad.inter.data.JSFeedbackInfo;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7731ae;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7760bg;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@DataKeep
/* loaded from: classes8.dex */
public class AdContentData {
    private String abilityDetailInfo;
    private String abilityDetailInfoEncode;
    private String adChoiceIcon;
    private String adChoiceUrl;
    private int apiVer;
    private List<Asset> assets;
    private String bannerRefSetting;
    private String bubbleInfo;
    private List<Integer> clickActionList;
    private List<AdvertiserInfo> compliance;
    private String configMap;
    private String contentDownMethod;
    private List<ContentExt> contentExts;
    private String contentId;
    private int creativeType;
    private String cshareUrl;
    private String ctrlExt;
    private CtrlExt ctrlExtObj;
    private String ctrlSwitchs;
    private Integer customExposureType;
    private DefaultTemplate defaultTemplate;
    private String detailUrl;
    private int displayCount;
    private String displayDate;
    private long endTime;
    private List<ImpEX> ext;
    private List<FeedbackInfo> feedbackInfoList;
    private Integer fileCachePriority;
    private int height;
    private String intentUri;
    private InteractCfg interactCfg;
    private int interactiontype;
    private boolean isDownloaded;
    private boolean isJssdkInWhiteList;
    private boolean isVastAd;
    private List<JSFeedbackInfo> jsFeedbackInfos;
    private List<String> keyWords;
    private List<String> keyWordsType;
    private String landPageWhiteListStr;
    private int landingTitleFlag;
    private String landingType;
    private long lastShowTime;
    private String logo2Pos;
    private String logo2Text;

    @InterfaceC6929a
    private String metaData;

    @InterfaceC6934f
    private MetaData metaDataObj;
    private int minEffectiveShowRatio;
    private long minEffectiveShowTime;
    private Integer minEffectiveVideoPlayProgress;
    private boolean needAppDownload;
    private List<String> noReportEventList;
    private List<C6957Om> omArgs;
    private int originCreativeType;
    private int priority;
    private String proDesc;
    private String recordtaskinfo;
    private String requestId;
    private Integer requestType;
    private int rewardAmount;
    private String rewardType;
    private int sequence;
    private String skipText;
    private int skipTextHeight;
    private String skipTextPos;
    private int skipTextSize;
    private String slotId;
    private String splashMediaPath;
    private int splashPreContentFlag;
    private long startTime;
    private String strAssets;
    private String style;
    private String styleExt;
    private String taskId;
    private String templateContent;
    private TemplateData templateData;
    private int templateId;
    private String templateIdV3;
    private String templateStyle;
    private String templateUrl;
    private List<TextState> textStateList;
    private boolean transparencyOpen;
    private boolean transparencySwitch;
    private String transparencyTplUrl;
    private String uniqueId;
    private long updateTime;
    private int useGaussianBlur;
    private VideoConfiguration videoConfiguration;
    private String webConfig;
    private String whyThisAd;
    private int width;
    private String showId = String.valueOf(AbstractC7741ao.m47566c());
    private int sdkVer = 30476300;
    private int showAppLogoFlag = 1;
    private String fcCtrlDate = "";
    private int adType = -1;
    private boolean autoDownloadApp = false;
    private boolean directReturnVideoAd = false;
    private int linkedVideoMode = 10;
    private boolean isLast = false;
    private boolean isSpare = false;
    private int splashSkipBtnDelayTime = -111111;
    private int splashShowTime = -111111;
    private boolean rewarded = false;

    /* renamed from: a */
    public int m39276a() {
        return this.adType;
    }

    /* renamed from: b */
    public String m39283b() {
        return this.showId;
    }

    /* renamed from: c */
    public String m39287c() {
        return this.slotId;
    }

    /* renamed from: d */
    public String m39290d() {
        return this.contentId;
    }

    /* renamed from: e */
    public long m39293e() {
        return this.lastShowTime;
    }

    /* renamed from: f */
    public String m39295f() {
        return this.uniqueId;
    }

    /* renamed from: g */
    public String m39297g() {
        return this.requestId;
    }

    /* renamed from: h */
    public boolean m39299h() {
        return this.isSpare;
    }

    /* renamed from: i */
    public String m39300i() {
        return this.templateIdV3;
    }

    /* renamed from: a */
    public static AdContentData m39271a(Context context, ContentRecord contentRecord) {
        if (contentRecord == null) {
            return null;
        }
        AdContentData adContentData = new AdContentData();
        adContentData.showId = contentRecord.m41577k();
        adContentData.slotId = contentRecord.m41585m();
        adContentData.contentId = contentRecord.m41588n();
        adContentData.taskId = contentRecord.m41591o();
        adContentData.showAppLogoFlag = contentRecord.m41594p();
        adContentData.lastShowTime = contentRecord.m41597q();
        adContentData.endTime = contentRecord.m41600r();
        adContentData.startTime = contentRecord.m41603s();
        adContentData.priority = contentRecord.m41390D();
        adContentData.width = contentRecord.m41606t();
        adContentData.height = contentRecord.m41609u();
        adContentData.updateTime = contentRecord.m41611v();
        adContentData.fcCtrlDate = contentRecord.m41613w();
        adContentData.displayCount = contentRecord.m41615x();
        adContentData.displayDate = contentRecord.m41617y();
        adContentData.detailUrl = contentRecord.m41386B();
        adContentData.interactiontype = contentRecord.m41388C();
        adContentData.intentUri = contentRecord.m41397H();
        adContentData.splashPreContentFlag = contentRecord.m41573j();
        adContentData.adType = contentRecord.m41552f();
        adContentData.skipText = contentRecord.m41558g();
        adContentData.skipTextPos = contentRecord.m41407M();
        adContentData.m39280a(contentRecord.m41563h());
        adContentData.keyWords = contentRecord.m41401J();
        adContentData.keyWordsType = contentRecord.m41403K();
        adContentData.logo2Text = contentRecord.m41411O();
        adContentData.logo2Pos = contentRecord.m41415Q();
        adContentData.landingTitleFlag = contentRecord.m41413P();
        adContentData.clickActionList = contentRecord.m41409N();
        adContentData.contentDownMethod = contentRecord.m41423U();
        adContentData.ctrlSwitchs = contentRecord.m41427W();
        adContentData.textStateList = contentRecord.m41429X();
        adContentData.uniqueId = contentRecord.m41478ab();
        adContentData.landingType = contentRecord.m41483ae();
        adContentData.requestId = contentRecord.m41486ah();
        adContentData.rewardType = contentRecord.m41501aw();
        adContentData.rewardAmount = contentRecord.m41502ax();
        adContentData.whyThisAd = AbstractC7806cz.m48168c(contentRecord.m41476aa());
        adContentData.adChoiceUrl = AbstractC7806cz.m48168c(contentRecord.m41490al());
        adContentData.adChoiceIcon = AbstractC7806cz.m48168c(contentRecord.m41491am());
        adContentData.skipTextHeight = contentRecord.m41489ak();
        adContentData.skipTextSize = contentRecord.m41488aj();
        adContentData.omArgs = contentRecord.m41506b(context);
        adContentData.fileCachePriority = AbstractC7806cz.m48178h(contentRecord.m41493ao());
        adContentData.useGaussianBlur = contentRecord.m41452aD();
        adContentData.splashShowTime = contentRecord.m41500av();
        adContentData.splashSkipBtnDelayTime = contentRecord.m41499au();
        adContentData.proDesc = contentRecord.m41503ay();
        adContentData.requestType = Integer.valueOf(contentRecord.m41492an());
        adContentData.ext = contentRecord.m41454aF();
        adContentData.contentExts = contentRecord.m41455aG();
        adContentData.configMap = contentRecord.m41457aI();
        adContentData.feedbackInfoList = contentRecord.m41461aM();
        adContentData.isVastAd = contentRecord.m41462aN();
        adContentData.apiVer = contentRecord.m41464aP();
        adContentData.assets = contentRecord.m41471aW();
        adContentData.templateIdV3 = contentRecord.m41463aO();
        adContentData.templateData = contentRecord.m41469aU();
        adContentData.templateStyle = contentRecord.m41465aQ();
        adContentData.style = contentRecord.m41526bm();
        adContentData.styleExt = contentRecord.m41527bn();
        adContentData.splashMediaPath = m39274b(context, contentRecord);
        adContentData.interactCfg = contentRecord.m41459aK();
        adContentData.defaultTemplate = contentRecord.m41470aV();
        adContentData.ctrlExt = contentRecord.m41474aZ();
        adContentData.transparencySwitch = contentRecord.m41517bd();
        adContentData.transparencyTplUrl = contentRecord.m41516bc();
        adContentData.transparencyOpen = contentRecord.m41517bd() && !TextUtils.isEmpty(contentRecord.m41516bc());
        adContentData.abilityDetailInfoEncode = AbstractC7806cz.m48168c(contentRecord.m41466aR());
        adContentData.bubbleInfo = contentRecord.m41530bq();
        return adContentData;
    }

    /* renamed from: b */
    private static String m39274b(Context context, ContentRecord contentRecord) {
        if (contentRecord.m41619z() == null) {
            return null;
        }
        if (contentRecord.m41619z().startsWith(Scheme.CONTENT.toString())) {
            return contentRecord.m41619z();
        }
        String strM41968c = C7019dh.m41937a(context, Constants.NORMAL_CACHE).m41968c(contentRecord.m41619z());
        if (!AbstractC7806cz.m48165b(strM41968c) && AbstractC7731ae.m47464d(new File(strM41968c))) {
            return strM41968c;
        }
        String strM41968c2 = C7019dh.m41937a(context, Constants.TPLATE_CACHE).m41968c(contentRecord.m41619z());
        if (AbstractC7806cz.m48165b(strM41968c2) || !AbstractC7731ae.m47464d(new File(strM41968c2))) {
            return null;
        }
        return strM41968c2;
    }

    /* renamed from: c */
    public void m39288c(int i10) {
        this.creativeType = i10;
    }

    /* renamed from: d */
    public void m39291d(int i10) {
        this.originCreativeType = i10;
    }

    /* renamed from: e */
    public void m39294e(String str) {
        this.bubbleInfo = str;
    }

    /* renamed from: f */
    public void m39296f(String str) {
        this.style = str;
    }

    /* renamed from: g */
    public void m39298g(String str) {
        this.styleExt = str;
    }

    /* renamed from: a */
    public static AdContentData m39272a(Context context, C7302e c7302e) {
        if (c7302e == null) {
            return null;
        }
        AdContentData adContentData = new AdContentData();
        adContentData.showId = c7302e.getShowId();
        adContentData.slotId = c7302e.getSlotId();
        adContentData.contentId = c7302e.getContentId();
        adContentData.taskId = c7302e.getTaskId();
        adContentData.endTime = c7302e.getEndTime();
        adContentData.startTime = c7302e.getStartTime();
        adContentData.intentUri = c7302e.getIntentUri();
        adContentData.adType = c7302e.m44632e();
        adContentData.m39280a(c7302e.m44775R());
        adContentData.bubbleInfo = c7302e.m44600C();
        adContentData.logo2Text = c7302e.m44667u();
        adContentData.clickActionList = c7302e.m44781U();
        adContentData.ctrlSwitchs = c7302e.getCtrlSwitchs();
        adContentData.uniqueId = c7302e.getUniqueId();
        adContentData.requestId = c7302e.m44636f();
        adContentData.creativeType = c7302e.getCreativeType();
        adContentData.interactiontype = c7302e.getInterActionType();
        adContentData.whyThisAd = AbstractC7806cz.m48168c(c7302e.getWhyThisAd());
        adContentData.adChoiceUrl = AbstractC7806cz.m48168c(c7302e.getAdChoiceUrl());
        adContentData.adChoiceIcon = AbstractC7806cz.m48168c(c7302e.getAdChoiceIcon());
        adContentData.omArgs = c7302e.m44651m();
        adContentData.requestType = Integer.valueOf(c7302e.m44639g());
        adContentData.contentExts = c7302e.m44818an();
        adContentData.feedbackInfoList = c7302e.getFeedbackInfoList();
        adContentData.m39286b(c7302e.getFeedbackInfoList());
        if (!AbstractC7760bg.m47767a(m39275b(c7302e))) {
            adContentData.m39286b(m39275b(c7302e));
            adContentData.feedbackInfoList = m39275b(c7302e);
        }
        adContentData.isVastAd = c7302e.m44664s();
        adContentData.apiVer = c7302e.m44808ad() == null ? -1 : c7302e.m44808ad().intValue();
        adContentData.assets = c7302e.m44804aa();
        adContentData.templateIdV3 = c7302e.m44791Z();
        adContentData.templateData = c7302e.m44806ab();
        adContentData.templateStyle = c7302e.m44807ac();
        adContentData.style = c7302e.m44830az();
        adContentData.styleExt = c7302e.m44802aA();
        adContentData.templateUrl = c7302e.m44828ax();
        adContentData.customExposureType = c7302e.m44659q();
        adContentData.minEffectiveVideoPlayProgress = c7302e.m44661r();
        adContentData.minEffectiveShowTime = c7302e.getMinEffectiveShowTime();
        adContentData.minEffectiveShowRatio = c7302e.getMinEffectiveShowRatio();
        adContentData.defaultTemplate = c7302e.m44809ae();
        adContentData.originCreativeType = c7302e.m44671w();
        adContentData.compliance = c7302e.getCompliance();
        adContentData.bannerRefSetting = c7302e.m44816al();
        adContentData.ctrlExt = c7302e.m44620c();
        adContentData.transparencySwitch = c7302e.m44675z();
        adContentData.transparencyTplUrl = c7302e.getTransparencyTplUrl();
        adContentData.transparencyOpen = c7302e.isTransparencyOpen();
        adContentData.abilityDetailInfoEncode = AbstractC7806cz.m48168c(c7302e.getAbilityDetailInfo());
        adContentData.cshareUrl = AbstractC7806cz.m48168c(c7302e.m44829ay());
        adContentData.videoConfiguration = c7302e.getVideoConfiguration();
        adContentData.ext = c7302e.m44817am();
        return adContentData;
    }

    /* renamed from: b */
    private static ArrayList<FeedbackInfo> m39275b(C7302e c7302e) {
        if (!AbstractC7760bg.m47767a(c7302e.getFeedbackInfoList()) || AbstractC7760bg.m47767a(c7302e.getAdCloseKeyWords()) || AbstractC7760bg.m47767a(c7302e.m44773Q()) || c7302e.getAdCloseKeyWords().size() != c7302e.m44773Q().size()) {
            return null;
        }
        ArrayList<FeedbackInfo> arrayList = new ArrayList<>();
        for (int i10 = 0; i10 < c7302e.getAdCloseKeyWords().size(); i10++) {
            FeedbackInfo feedbackInfo = new FeedbackInfo();
            feedbackInfo.m44467a(c7302e.getAdCloseKeyWords().get(i10));
            feedbackInfo.m44466a(AbstractC7806cz.m48146a(c7302e.m44773Q().get(i10), -1L));
            feedbackInfo.m44465a(1);
            arrayList.add(feedbackInfo);
        }
        return arrayList;
    }

    /* renamed from: c */
    public void m39289c(String str) {
        this.templateUrl = str;
    }

    /* renamed from: d */
    public void m39292d(String str) {
        this.strAssets = str;
    }

    /* renamed from: a */
    public static AdContentData m39273a(C7302e c7302e) {
        return m39272a((Context) null, c7302e);
    }

    /* renamed from: b */
    public void m39284b(int i10) {
        this.apiVer = i10;
    }

    /* renamed from: a */
    public void m39277a(int i10) {
        this.adType = i10;
    }

    /* renamed from: b */
    public void m39285b(String str) {
        this.templateIdV3 = str;
    }

    /* renamed from: a */
    public void m39278a(DefaultTemplate defaultTemplate) {
        this.defaultTemplate = defaultTemplate;
    }

    /* renamed from: b */
    public void m39286b(List<FeedbackInfo> list) {
        if (AbstractC7760bg.m47767a(list)) {
            return;
        }
        this.jsFeedbackInfos = new ArrayList();
        for (FeedbackInfo feedbackInfo : list) {
            if (feedbackInfo != null) {
                this.jsFeedbackInfos.add(new JSFeedbackInfo(feedbackInfo));
            }
        }
    }

    /* renamed from: a */
    public void m39279a(TemplateData templateData) {
        this.templateData = templateData;
    }

    /* renamed from: a */
    public void m39280a(String str) {
        this.metaData = str;
        this.metaDataObj = null;
    }

    /* renamed from: a */
    public void m39281a(List<Asset> list) {
        this.assets = list;
    }

    /* renamed from: a */
    public void m39282a(boolean z10) {
        this.isDownloaded = z10;
    }
}
