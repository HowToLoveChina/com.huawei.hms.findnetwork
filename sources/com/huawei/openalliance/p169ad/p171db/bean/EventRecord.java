package com.huawei.openalliance.p169ad.p171db.bean;

import com.huawei.openalliance.p169ad.annotations.DataKeep;
import com.huawei.openalliance.p169ad.annotations.InterfaceC6933e;
import java.util.List;

@DataKeep
/* loaded from: classes2.dex */
public class EventRecord extends C7013a {
    public static final String AD_TYPE = "adType";
    public static final String LAST_FAIL_REASON = "lastFailReason";
    public static final String LAST_REPORT_TIME = "lastReportTime";
    public static final String REPEATED_COUNT = "repeatedCount";
    public static final String TIME = "time";

    @InterfaceC6933e
    private String _id;
    private int adType_;
    private String agVerifyCode;
    private String appDownloadRelatedActionSource;
    private String appVersionCode;
    private String clickSuccessDestination_;
    private String contentDownMethod;
    private String contentId;
    private String creativeSize;
    private String customData;
    private String downloadDuration;
    private String downloadMode;
    private String downloadReason;
    private String downloadSize;
    private int exposure;
    private EncryptionField<String> ext;
    private String fullDownload;
    private String impSource;
    private String installRelatedActionSource;
    private String installType;
    private String intentDest;
    private String intentFailReason;
    private String isAdContainerSizeMatched;
    private List<String> keyWords;
    private List<String> keyWordsType;
    private String lastFailReason;
    private String lastReportTime;
    private int opTimesInLandingPage_;
    private EncryptionField<String> paramFromServer_;
    private String playedProgress;
    private String preCheckResult;
    private List<String> preContentSuccessList;
    private int rawX_;
    private int rawY_;

    @InterfaceC6933e
    private String realAppPkgName;
    private String realFailedReason;
    private long repeatedCount;
    private String requestId;
    private String shakeAngle;
    private String showid_;
    private String slotPosition;
    private long time_;
    private String type_;
    private String userId;
    private String venusExt;

    @InterfaceC6933e
    private long videoTime;
    private long showTimeDuration_ = -111111;
    private int maxShowRatio_ = -111111;
    private long videoPlayStartTime_ = -111111;
    private long videoPlayEndTime_ = -111111;
    private int videoPlayStartProgress_ = -111111;
    private int videoPlayEndProgress_ = -111111;
    private int requestType = 0;
    private int encodingMode = -111111;
    private int clickX = -111111;
    private int clickY = -111111;
    private int magLockPosition = -111111;
    private int sld = -111111;

    @InterfaceC6933e
    private float density = -111111.0f;
    private int upX = -111111;
    private int upY = -111111;
    private long clickDTime = -111111;
    private long clickUTime = -111111;
    private long startShowTime = -111111;
    private int playedTime = -111111;
    private int adReqSource = -111111;

    /* renamed from: A */
    public String m41664A() {
        return this.intentFailReason;
    }

    /* renamed from: B */
    public String m41666B() {
        return this.appDownloadRelatedActionSource;
    }

    /* renamed from: C */
    public String m41668C() {
        return this.installRelatedActionSource;
    }

    /* renamed from: D */
    public String m41670D() {
        return this.preCheckResult;
    }

    /* renamed from: E */
    public String m41672E() {
        return this.impSource;
    }

    /* renamed from: F */
    public void m41674F(String str) {
        this.realAppPkgName = str;
    }

    /* renamed from: G */
    public String m41675G() {
        return this.appVersionCode;
    }

    /* renamed from: H */
    public String m41677H() {
        return this.downloadReason;
    }

    /* renamed from: I */
    public String m41678I() {
        return this.downloadSize;
    }

    /* renamed from: J */
    public String m41679J() {
        return this.downloadDuration;
    }

    /* renamed from: K */
    public String m41680K() {
        return this.downloadMode;
    }

    /* renamed from: L */
    public String m41681L() {
        return this.fullDownload;
    }

    /* renamed from: M */
    public int m41682M() {
        return this.exposure;
    }

    /* renamed from: N */
    public String m41683N() {
        return this.customData;
    }

    /* renamed from: O */
    public String m41684O() {
        return this.userId;
    }

    /* renamed from: P */
    public Integer m41685P() {
        try {
            return Integer.valueOf(Integer.parseInt(this.isAdContainerSizeMatched));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    /* renamed from: Q */
    public int m41686Q() {
        return this.requestType;
    }

    /* renamed from: R */
    public String m41687R() {
        return this.contentId;
    }

    /* renamed from: S */
    public String m41688S() {
        return this.requestId;
    }

    /* renamed from: T */
    public String m41689T() {
        return this.agVerifyCode;
    }

    /* renamed from: U */
    public String m41690U() {
        return this.installType;
    }

    /* renamed from: V */
    public int m41691V() {
        return this.clickX;
    }

    /* renamed from: W */
    public int m41692W() {
        return this.clickY;
    }

    /* renamed from: X */
    public String m41693X() {
        return this.creativeSize;
    }

    /* renamed from: Y */
    public String m41694Y() {
        return this.venusExt;
    }

    /* renamed from: Z */
    public long m41695Z() {
        return this.startShowTime;
    }

    /* renamed from: a */
    public String m41696a() {
        return this.realFailedReason;
    }

    /* renamed from: aa */
    public int m41704aa() {
        return this.playedTime;
    }

    /* renamed from: ab */
    public String m41705ab() {
        return this.playedProgress;
    }

    /* renamed from: ac */
    public int m41706ac() {
        return this.encodingMode;
    }

    /* renamed from: ad */
    public int m41707ad() {
        return this.sld;
    }

    /* renamed from: ae */
    public float m41708ae() {
        return this.density;
    }

    /* renamed from: af */
    public int m41709af() {
        return this.upX;
    }

    /* renamed from: ag */
    public int m41710ag() {
        return this.upY;
    }

    /* renamed from: ah */
    public String m41711ah() {
        return this.slotPosition;
    }

    /* renamed from: ai */
    public int m41712ai() {
        return this.adReqSource;
    }

    /* renamed from: aj */
    public long m41713aj() {
        return this.videoTime;
    }

    /* renamed from: ak */
    public String m41714ak() {
        return this.realAppPkgName;
    }

    /* renamed from: al */
    public long m41715al() {
        return this.clickDTime;
    }

    /* renamed from: am */
    public long m41716am() {
        return this.clickUTime;
    }

    /* renamed from: an */
    public String m41717an() {
        return this.shakeAngle;
    }

    /* renamed from: b */
    public long m41718b() {
        return this.showTimeDuration_;
    }

    /* renamed from: c */
    public String m41724c() {
        return this.clickSuccessDestination_;
    }

    /* renamed from: d */
    public long m41728d() {
        return this.videoPlayStartTime_;
    }

    /* renamed from: e */
    public long m41732e() {
        return this.videoPlayEndTime_;
    }

    /* renamed from: f */
    public int m41736f() {
        return this.videoPlayStartProgress_;
    }

    /* renamed from: g */
    public int m41740g() {
        return this.videoPlayEndProgress_;
    }

    /* renamed from: h */
    public int m41744h() {
        return this.maxShowRatio_;
    }

    /* renamed from: i */
    public String m41748i() {
        return this._id;
    }

    /* renamed from: j */
    public String m41752j() {
        return this.type_;
    }

    /* renamed from: k */
    public long m41755k() {
        return this.time_;
    }

    /* renamed from: l */
    public String m41758l() {
        return this.showid_;
    }

    /* renamed from: m */
    public int m41761m() {
        return this.adType_;
    }

    /* renamed from: n */
    public EncryptionField<String> m41764n() {
        return this.paramFromServer_;
    }

    /* renamed from: o */
    public int m41767o() {
        return this.rawX_;
    }

    /* renamed from: p */
    public int m41769p() {
        return this.rawY_;
    }

    /* renamed from: q */
    public int m41771q() {
        return this.opTimesInLandingPage_;
    }

    /* renamed from: r */
    public EncryptionField<String> m41773r() {
        return this.ext;
    }

    /* renamed from: s */
    public List<String> m41775s() {
        return this.keyWords;
    }

    /* renamed from: t */
    public List<String> m41777t() {
        return this.keyWordsType;
    }

    /* renamed from: u */
    public String m41779u() {
        return this.lastReportTime;
    }

    /* renamed from: v */
    public String m41781v() {
        return this.lastFailReason;
    }

    /* renamed from: w */
    public long m41783w() {
        return this.repeatedCount;
    }

    /* renamed from: x */
    public String m41785x() {
        return this.contentDownMethod;
    }

    /* renamed from: y */
    public List<String> m41787y() {
        return this.preContentSuccessList;
    }

    /* renamed from: z */
    public String m41789z() {
        return this.intentDest;
    }

    /* renamed from: A */
    public void m41665A(String str) {
        this.installType = str;
    }

    /* renamed from: B */
    public void m41667B(String str) {
        this.creativeSize = str;
    }

    /* renamed from: C */
    public void m41669C(String str) {
        this.venusExt = str;
    }

    /* renamed from: D */
    public void m41671D(String str) {
        this.playedProgress = str;
    }

    /* renamed from: E */
    public void m41673E(String str) {
        this.slotPosition = str;
    }

    /* renamed from: G */
    public void m41676G(String str) {
        this.shakeAngle = str;
    }

    /* renamed from: a */
    public void m41697a(float f10) {
        this.density = f10;
    }

    /* renamed from: b */
    public void m41719b(int i10) {
        this.videoPlayEndProgress_ = i10;
    }

    /* renamed from: c */
    public void m41725c(int i10) {
        this.maxShowRatio_ = i10;
    }

    /* renamed from: d */
    public void m41729d(int i10) {
        this.adType_ = i10;
    }

    /* renamed from: e */
    public void m41733e(int i10) {
        this.rawX_ = i10;
    }

    /* renamed from: f */
    public void m41737f(int i10) {
        this.rawY_ = i10;
    }

    /* renamed from: g */
    public void m41741g(int i10) {
        this.opTimesInLandingPage_ = i10;
    }

    /* renamed from: h */
    public void m41745h(int i10) {
        this.exposure = i10;
    }

    /* renamed from: i */
    public void m41749i(int i10) {
        this.requestType = i10;
    }

    /* renamed from: j */
    public void m41753j(int i10) {
        this.playedTime = i10;
    }

    /* renamed from: k */
    public void m41756k(int i10) {
        this.sld = i10;
    }

    /* renamed from: l */
    public void m41759l(int i10) {
        this.upX = i10;
    }

    /* renamed from: m */
    public void m41762m(int i10) {
        this.upY = i10;
    }

    /* renamed from: n */
    public void m41765n(int i10) {
        this.adReqSource = i10;
    }

    /* renamed from: o */
    public void m41768o(String str) {
        this.appVersionCode = str;
    }

    /* renamed from: p */
    public void m41770p(String str) {
        this.downloadReason = str;
    }

    /* renamed from: q */
    public void m41772q(String str) {
        this.downloadSize = str;
    }

    /* renamed from: r */
    public void m41774r(String str) {
        this.downloadDuration = str;
    }

    /* renamed from: s */
    public void m41776s(String str) {
        this.downloadMode = str;
    }

    /* renamed from: t */
    public void m41778t(String str) {
        this.fullDownload = str;
    }

    /* renamed from: u */
    public void m41780u(String str) {
        this.customData = str;
    }

    /* renamed from: v */
    public void m41782v(String str) {
        this.userId = str;
    }

    /* renamed from: w */
    public void m41784w(String str) {
        this.isAdContainerSizeMatched = str;
    }

    /* renamed from: x */
    public void m41786x(String str) {
        this.contentId = str;
    }

    /* renamed from: y */
    public void m41788y(String str) {
        this.requestId = str;
    }

    /* renamed from: z */
    public void m41790z(String str) {
        this.agVerifyCode = str;
    }

    /* renamed from: a */
    public void m41698a(int i10) {
        this.videoPlayStartProgress_ = i10;
    }

    /* renamed from: b */
    public void m41720b(long j10) {
        this.videoPlayStartTime_ = j10;
    }

    /* renamed from: c */
    public void m41726c(long j10) {
        this.videoPlayEndTime_ = j10;
    }

    /* renamed from: d */
    public void m41730d(long j10) {
        this.time_ = j10;
    }

    /* renamed from: e */
    public void m41734e(long j10) {
        this.repeatedCount = j10;
    }

    /* renamed from: f */
    public void m41738f(long j10) {
        this.startShowTime = j10;
    }

    /* renamed from: g */
    public void m41742g(long j10) {
        this.videoTime = j10;
    }

    /* renamed from: h */
    public void m41746h(long j10) {
        this.clickDTime = j10;
    }

    /* renamed from: i */
    public void m41750i(long j10) {
        this.clickUTime = j10;
    }

    /* renamed from: j */
    public void m41754j(String str) {
        this.intentFailReason = str;
    }

    /* renamed from: k */
    public void m41757k(String str) {
        this.appDownloadRelatedActionSource = str;
    }

    /* renamed from: l */
    public void m41760l(String str) {
        this.installRelatedActionSource = str;
    }

    /* renamed from: m */
    public void m41763m(String str) {
        this.preCheckResult = str;
    }

    /* renamed from: n */
    public void m41766n(String str) {
        this.impSource = str;
    }

    /* renamed from: a */
    public void m41699a(long j10) {
        this.showTimeDuration_ = j10;
    }

    /* renamed from: b */
    public void m41721b(Integer num) {
        this.clickY = num.intValue();
    }

    /* renamed from: c */
    public void m41727c(String str) {
        this.type_ = str;
    }

    /* renamed from: d */
    public void m41731d(String str) {
        this.showid_ = str;
    }

    /* renamed from: e */
    public void m41735e(String str) {
        if (this.ext == null) {
            this.ext = new EncryptionField<>(String.class);
        }
        this.ext.m41655a((EncryptionField<String>) str);
    }

    /* renamed from: f */
    public void m41739f(String str) {
        this.lastReportTime = str;
    }

    /* renamed from: g */
    public void m41743g(String str) {
        this.lastFailReason = str;
    }

    /* renamed from: h */
    public void m41747h(String str) {
        this.contentDownMethod = str;
    }

    /* renamed from: i */
    public void m41751i(String str) {
        this.intentDest = str;
    }

    /* renamed from: a */
    public void m41700a(EncryptionField<String> encryptionField) {
        this.paramFromServer_ = encryptionField;
    }

    /* renamed from: b */
    public void m41722b(String str) {
        this.clickSuccessDestination_ = str;
    }

    /* renamed from: a */
    public void m41701a(Integer num) {
        this.clickX = num.intValue();
    }

    /* renamed from: b */
    public void m41723b(List<String> list) {
        this.keyWordsType = list;
    }

    /* renamed from: a */
    public void m41702a(String str) {
        this.realFailedReason = str;
    }

    /* renamed from: a */
    public void m41703a(List<String> list) {
        this.keyWords = list;
    }
}
