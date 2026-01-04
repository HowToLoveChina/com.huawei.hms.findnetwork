package com.huawei.openalliance.p169ad.beans.metadata;

import com.huawei.openalliance.p169ad.annotations.DataKeep;
import com.huawei.openalliance.p169ad.annotations.InterfaceC6929a;
import com.huawei.openalliance.p169ad.beans.base.RspBean;
import com.huawei.openalliance.p169ad.utils.AbstractC7760bg;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@DataKeep
/* loaded from: classes8.dex */
public class MetaData extends RspBean {
    private String adSign;
    private List<AdSource> adSources;
    private ApkInfo apkInfo;
    private String appPromotionChannel;
    private AudioInfo audioInfo;

    @InterfaceC6929a
    private String clickUrl;
    private String cta;
    private Integer customExposureType;
    private String description;
    private String dwnParameter;
    private List<ImageInfo> icon;
    private Integer iconDispDu;
    private List<ImageInfo> imageInfo;
    private int insreTemplate;

    @InterfaceC6929a
    private String intent;
    private int isPreload;
    private String label;
    private String landingPageStyle;
    private String landingPageType;
    private String marketAppId;
    private String mediaCachePath;
    private MediaFile mediaFile;
    private List<MediaFile> mediaFiles;
    private Integer minEffectiveVideoPlayProgress;
    private String privacyUrl;
    private PromoteInfo promoteInfo;
    private String rewardCriterion;
    private List<String> schemeInfo;
    private String screenOrientation;
    private ShareInfo shareInfo;
    private Integer showAppElement;
    private List<String> subDescriptions;
    private String templateId;
    private List<TextState> textStateList;
    private ImageInfo thumbNail;
    private String title;

    @InterfaceC6929a
    private String vastInfo;
    private VideoInfo videoInfo;
    private long minEffectiveShowTime = 500;
    private long maxEffectiveShowTime = 0;
    private int minEffectiveShowRatio = 50;
    private long duration = 0;

    /* renamed from: A */
    public String m40264A() {
        return this.screenOrientation;
    }

    /* renamed from: B */
    public String m40265B() {
        return this.landingPageType;
    }

    /* renamed from: C */
    public String m40266C() {
        return this.privacyUrl;
    }

    /* renamed from: D */
    public String m40267D() {
        return this.mediaCachePath;
    }

    /* renamed from: E */
    public List<String> m40268E() {
        return this.schemeInfo;
    }

    /* renamed from: F */
    public AudioInfo m40269F() {
        return this.audioInfo;
    }

    /* renamed from: G */
    public Integer m40270G() {
        return this.iconDispDu;
    }

    /* renamed from: H */
    public int m40271H() {
        return this.isPreload;
    }

    /* renamed from: I */
    public int m40272I() {
        return this.insreTemplate;
    }

    /* renamed from: J */
    public String m40273J() {
        return this.landingPageStyle;
    }

    /* renamed from: K */
    public String m40274K() {
        return this.vastInfo;
    }

    /* renamed from: L */
    public List<AdSource> m40275L() {
        return this.adSources;
    }

    /* renamed from: M */
    public List<String> m40276M() {
        ArrayList arrayList = new ArrayList();
        VideoInfo videoInfo = this.videoInfo;
        if (videoInfo != null) {
            arrayList.add(videoInfo.m40471a());
        }
        return arrayList;
    }

    /* renamed from: N */
    public List<String> m40277N() {
        ArrayList arrayList = new ArrayList();
        if (!AbstractC7760bg.m47767a(this.imageInfo)) {
            Iterator<ImageInfo> it = this.imageInfo.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().m40180c());
            }
        }
        return arrayList;
    }

    /* renamed from: O */
    public Integer m40278O() {
        return this.showAppElement;
    }

    /* renamed from: P */
    public List<String> m40279P() {
        return this.subDescriptions;
    }

    /* renamed from: a */
    public String m40280a() {
        return this.cta;
    }

    /* renamed from: b */
    public Integer m40293b() {
        return this.minEffectiveVideoPlayProgress;
    }

    /* renamed from: c */
    public Integer m40299c() {
        return this.customExposureType;
    }

    /* renamed from: d */
    public VideoInfo m40305d() {
        return this.videoInfo;
    }

    /* renamed from: e */
    public String m40309e() {
        return this.title;
    }

    /* renamed from: f */
    public String m40312f() {
        return this.description;
    }

    /* renamed from: g */
    public List<ImageInfo> m40315g() {
        return this.icon;
    }

    /* renamed from: h */
    public String m40318h() {
        return this.clickUrl;
    }

    /* renamed from: i */
    public long m40320i() {
        return this.minEffectiveShowTime;
    }

    /* renamed from: j */
    public long m40322j() {
        return this.maxEffectiveShowTime;
    }

    /* renamed from: k */
    public int m40324k() {
        return this.minEffectiveShowRatio;
    }

    /* renamed from: l */
    public String m40326l() {
        return this.label;
    }

    /* renamed from: m */
    public String m40328m() {
        return this.appPromotionChannel;
    }

    /* renamed from: n */
    public String m40330n() {
        return this.marketAppId;
    }

    /* renamed from: o */
    public String m40332o() {
        return this.intent;
    }

    /* renamed from: p */
    public List<ImageInfo> m40334p() {
        return this.imageInfo;
    }

    /* renamed from: q */
    public ImageInfo m40336q() {
        return this.thumbNail;
    }

    /* renamed from: r */
    public ShareInfo m40338r() {
        return this.shareInfo;
    }

    /* renamed from: s */
    public ApkInfo m40339s() {
        return this.apkInfo;
    }

    /* renamed from: t */
    public PromoteInfo m40340t() {
        return this.promoteInfo;
    }

    /* renamed from: u */
    public String m40341u() {
        return this.adSign;
    }

    /* renamed from: v */
    public MediaFile m40342v() {
        return this.mediaFile;
    }

    /* renamed from: w */
    public List<TextState> m40343w() {
        return this.textStateList;
    }

    /* renamed from: x */
    public List<MediaFile> m40344x() {
        return this.mediaFiles;
    }

    /* renamed from: y */
    public long m40345y() {
        return this.duration;
    }

    /* renamed from: z */
    public String m40346z() {
        return this.rewardCriterion;
    }

    /* renamed from: a */
    public void m40281a(int i10) {
        this.minEffectiveShowRatio = i10;
    }

    /* renamed from: b */
    public void m40294b(int i10) {
        this.isPreload = i10;
    }

    /* renamed from: c */
    public void m40300c(int i10) {
        this.insreTemplate = i10;
    }

    /* renamed from: d */
    public void m40306d(Integer num) {
        this.showAppElement = num;
    }

    /* renamed from: e */
    public void m40310e(String str) {
        this.label = str;
    }

    /* renamed from: f */
    public void m40313f(String str) {
        this.appPromotionChannel = str;
    }

    /* renamed from: g */
    public void m40316g(String str) {
        this.marketAppId = str;
    }

    /* renamed from: h */
    public void m40319h(String str) {
        this.intent = str;
    }

    /* renamed from: i */
    public void m40321i(String str) {
        this.adSign = str;
    }

    /* renamed from: j */
    public void m40323j(String str) {
        this.rewardCriterion = str;
    }

    /* renamed from: k */
    public void m40325k(String str) {
        this.screenOrientation = str;
    }

    /* renamed from: l */
    public void m40327l(String str) {
        this.landingPageType = str;
    }

    /* renamed from: m */
    public void m40329m(String str) {
        this.privacyUrl = str;
    }

    /* renamed from: n */
    public void m40331n(String str) {
        this.mediaCachePath = str;
    }

    /* renamed from: o */
    public void m40333o(String str) {
        this.landingPageStyle = str;
    }

    /* renamed from: p */
    public void m40335p(String str) {
        this.dwnParameter = str;
    }

    /* renamed from: q */
    public void m40337q(String str) {
        this.vastInfo = str;
    }

    /* renamed from: a */
    public void m40282a(long j10) {
        this.minEffectiveShowTime = j10;
    }

    /* renamed from: b */
    public void m40295b(long j10) {
        this.maxEffectiveShowTime = j10;
    }

    /* renamed from: c */
    public void m40301c(long j10) {
        this.duration = j10;
    }

    /* renamed from: d */
    public void m40307d(String str) {
        this.clickUrl = str;
    }

    /* renamed from: e */
    public void m40311e(List<String> list) {
        this.schemeInfo = list;
    }

    /* renamed from: f */
    public void m40314f(List<AdSource> list) {
        this.adSources = list;
    }

    /* renamed from: g */
    public void m40317g(List<String> list) {
        this.subDescriptions = list;
    }

    /* renamed from: a */
    public void m40283a(ApkInfo apkInfo) {
        this.apkInfo = apkInfo;
    }

    /* renamed from: b */
    public void m40296b(Integer num) {
        this.customExposureType = num;
    }

    /* renamed from: c */
    public void m40302c(Integer num) {
        this.iconDispDu = num;
    }

    /* renamed from: d */
    public void m40308d(List<MediaFile> list) {
        this.mediaFiles = list;
    }

    /* renamed from: a */
    public void m40284a(AudioInfo audioInfo) {
        this.audioInfo = audioInfo;
    }

    /* renamed from: b */
    public void m40297b(String str) {
        this.title = str;
    }

    /* renamed from: c */
    public void m40303c(String str) {
        this.description = str;
    }

    /* renamed from: a */
    public void m40285a(ImageInfo imageInfo) {
        this.thumbNail = imageInfo;
    }

    /* renamed from: b */
    public void m40298b(List<ImageInfo> list) {
        this.imageInfo = list;
    }

    /* renamed from: c */
    public void m40304c(List<TextState> list) {
        this.textStateList = list;
    }

    /* renamed from: a */
    public void m40286a(MediaFile mediaFile) {
        this.mediaFile = mediaFile;
    }

    /* renamed from: a */
    public void m40287a(PromoteInfo promoteInfo) {
        this.promoteInfo = promoteInfo;
    }

    /* renamed from: a */
    public void m40288a(ShareInfo shareInfo) {
        this.shareInfo = shareInfo;
    }

    /* renamed from: a */
    public void m40289a(VideoInfo videoInfo) {
        this.videoInfo = videoInfo;
    }

    /* renamed from: a */
    public void m40290a(Integer num) {
        this.minEffectiveVideoPlayProgress = num;
    }

    /* renamed from: a */
    public void m40291a(String str) {
        this.cta = str;
    }

    /* renamed from: a */
    public void m40292a(List<ImageInfo> list) {
        this.icon = list;
    }
}
