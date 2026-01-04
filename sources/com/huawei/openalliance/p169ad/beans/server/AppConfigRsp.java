package com.huawei.openalliance.p169ad.beans.server;

import com.huawei.openalliance.p169ad.annotations.DataKeep;
import com.huawei.openalliance.p169ad.annotations.InterfaceC6929a;
import com.huawei.openalliance.p169ad.annotations.InterfaceC6932d;
import com.huawei.openalliance.p169ad.beans.base.RspBean;
import com.huawei.openalliance.p169ad.beans.metadata.ReduceDisturbRule;
import com.huawei.openalliance.p169ad.beans.metadata.Rule;
import com.huawei.openalliance.p169ad.beans.metadata.p170v3.SlotTemplateRsp;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.SpKeys;
import com.huawei.openalliance.p169ad.utils.AbstractC7758be;
import java.util.List;

@DataKeep
/* loaded from: classes8.dex */
public class AppConfigRsp extends RspBean {
    private Integer allowAdSkipTime;

    @InterfaceC6929a
    private String apiWhiteList;
    private String appList;
    private Integer bdinterval;
    private String configMap;
    private Integer configRefreshInterval;
    private List<String> defBrowerPkgList;
    private Long diskCacheValidTime;
    private Integer fcSwitch;
    private String globalSwitch;
    private Integer imeiEncodeMode;
    private Integer iteAdCA;
    private Integer iteAdCloseTm;
    private Integer iteAdExp;
    private Integer iteAdFs;
    private List<SlotTemplateRsp> jsSlotTemplateRsp;
    private Integer landingMenu;
    private Integer landpageAppPrompt;

    @InterfaceC6929a
    private String landpageAppWhiteList;

    @InterfaceC6929a
    private String landpageWebBlackList;
    private double limitOfContainerAspectRatio;
    private Long maxBannerInterval;
    private Long minBannerInterval;
    private Integer notifyKitWhenRequest;
    private Integer oaidReportOnNpa;
    private String reason;
    private ReduceDisturbRule reduceDisturbRule;
    private Integer rwdCloseShowTm;
    private Integer rwdGnTm;
    private List<String> schemeInfo;
    private Integer sdkCacheDelStrategy;
    private Integer sdkCacheTotalMaxNum;
    private Integer sdkCacheTotalMaxSize;

    @InterfaceC6929a
    private String serverStore;
    private String sha256;
    private List<String> singleInstanceLSModelList;
    private Integer sloganShowTime;
    private List<SlotTemplateRsp> slotTemplateRsp;
    private String splashFeedbackBtnText;
    private Integer splashInteractCloseEffectiveTime;
    private Integer splashmode;
    private Integer supSdkServerGzip;
    private Integer supportGzip;
    private String testCountryCode;
    private String trustAppList;
    private Integer validityOfClickSkip;
    private Integer validityOfLockEvent;
    private Integer validityOfNativeEvent;
    private Integer validityOfSplashEvent;
    private Integer videoCacheSize;
    private int retcode = -1;

    @InterfaceC6932d(m39225a = "splashcachenum")
    private int splashCacheNum = 10;
    private int splashshow = 3000;
    private int splashSkipArea = 0;

    @InterfaceC6932d(m39225a = "gif_show_time_upper_limit")
    private int gifShowTimeUpperLimit = 8000;

    @InterfaceC6932d(m39225a = "gif_show_time_lower_limit_each_frame")
    private int gifShowTimeLowerLimitEachFrame = 100;

    @InterfaceC6932d(m39225a = SpKeys.GIF_SIZE_UPPER_LIMIT)
    private int gifSizeUpperLimit = Constants.GIF_SIZE_UPPER_LIMIT_KB;

    @InterfaceC6932d(m39225a = SpKeys.IMG_SIZE_UPPER_LIMIT)
    private int imgSizeUpperLimit = Constants.IMG_SIZE_UPPER_LIMIT_KB;
    private long splashShowTimeInterval = 0;
    private long sloganShowMinTimeRealMode = 300;
    private int splashUserAppDayImpFc = 0;
    private String supportHmsSdkVerCode = Constants.NEW_KIT_HMS_VERSION;
    private long preloadSplashReqTimeInterval = 600000;
    private Long locationExpireTime = 1800000L;
    private Long locationRefreshInterval = 1800000L;
    private int locationSwitch = 0;

    /* renamed from: ag */
    private int m40876ag() {
        Integer num = this.sloganShowTime;
        if (num != null && num.intValue() >= 500 && this.sloganShowTime.intValue() <= 5000) {
            return this.sloganShowTime.intValue();
        }
        return 2000;
    }

    /* renamed from: ah */
    private int m40877ah() {
        Integer num = this.sloganShowTime;
        if (num == null) {
            return 2000;
        }
        if (num.intValue() < 0 || this.sloganShowTime.intValue() > 5000) {
            return 0;
        }
        return this.sloganShowTime.intValue();
    }

    /* renamed from: A */
    public List<String> m40878A() {
        return this.schemeInfo;
    }

    /* renamed from: B */
    public Long m40879B() {
        return Long.valueOf(this.locationExpireTime.longValue() > 0 ? this.locationExpireTime.longValue() : 1800000L);
    }

    /* renamed from: C */
    public int m40880C() {
        return this.locationSwitch;
    }

    /* renamed from: D */
    public String m40881D() {
        return this.apiWhiteList;
    }

    /* renamed from: E */
    public Long m40882E() {
        return Long.valueOf(this.locationRefreshInterval.longValue() > 0 ? this.locationRefreshInterval.longValue() : 1800000L);
    }

    /* renamed from: F */
    public Integer m40883F() {
        return this.splashInteractCloseEffectiveTime;
    }

    /* renamed from: G */
    public String m40884G() {
        return this.splashFeedbackBtnText;
    }

    /* renamed from: H */
    public double m40885H() {
        double d10 = this.limitOfContainerAspectRatio;
        if (d10 <= 0.0d) {
            return 0.05000000074505806d;
        }
        return d10;
    }

    /* renamed from: I */
    public Long m40886I() {
        return this.diskCacheValidTime;
    }

    /* renamed from: J */
    public Integer m40887J() {
        return this.sdkCacheDelStrategy;
    }

    /* renamed from: K */
    public Integer m40888K() {
        return this.sdkCacheTotalMaxNum;
    }

    /* renamed from: L */
    public Integer m40889L() {
        return this.sdkCacheTotalMaxSize;
    }

    /* renamed from: M */
    public String m40890M() {
        return this.configMap;
    }

    /* renamed from: N */
    public String m40891N() {
        return this.appList;
    }

    /* renamed from: O */
    public Integer m40892O() {
        return this.bdinterval;
    }

    /* renamed from: P */
    public String m40893P() {
        return this.testCountryCode;
    }

    /* renamed from: Q */
    public Integer m40894Q() {
        return this.supportGzip;
    }

    /* renamed from: R */
    public Integer m40895R() {
        return this.rwdGnTm;
    }

    /* renamed from: S */
    public Integer m40896S() {
        return this.iteAdCloseTm;
    }

    /* renamed from: T */
    public Integer m40897T() {
        return this.iteAdFs;
    }

    /* renamed from: U */
    public Integer m40898U() {
        return this.iteAdExp;
    }

    /* renamed from: V */
    public Integer m40899V() {
        return this.iteAdCA;
    }

    /* renamed from: W */
    public Integer m40900W() {
        return this.rwdCloseShowTm;
    }

    /* renamed from: X */
    public Integer m40901X() {
        return this.oaidReportOnNpa;
    }

    /* renamed from: Y */
    public String m40902Y() {
        return this.sha256;
    }

    /* renamed from: Z */
    public Integer m40903Z() {
        return this.allowAdSkipTime;
    }

    /* renamed from: a */
    public int m40904a(int i10) {
        int i11 = this.gifShowTimeUpperLimit;
        return i11 >= 2000 ? i11 : i10;
    }

    /* renamed from: aa */
    public Integer m40907aa() {
        return this.supSdkServerGzip;
    }

    /* renamed from: ab */
    public Integer m40908ab() {
        return this.videoCacheSize;
    }

    /* renamed from: ac */
    public List<String> m40909ac() {
        return this.singleInstanceLSModelList;
    }

    /* renamed from: ad */
    public List<SlotTemplateRsp> m40910ad() {
        return this.slotTemplateRsp;
    }

    /* renamed from: ae */
    public Integer m40911ae() {
        return this.fcSwitch;
    }

    /* renamed from: af */
    public List<SlotTemplateRsp> m40912af() {
        return this.jsSlotTemplateRsp;
    }

    /* renamed from: b */
    public int m40913b(int i10) {
        int i11 = this.gifShowTimeLowerLimitEachFrame;
        return i11 > 0 ? i11 : i10;
    }

    /* renamed from: c */
    public int m40915c(int i10) {
        int i11 = this.gifSizeUpperLimit;
        return i11 > 0 ? i11 : i10;
    }

    /* renamed from: d */
    public int m40917d() {
        int i10 = this.splashUserAppDayImpFc;
        if (i10 > 0) {
            return i10;
        }
        return 0;
    }

    /* renamed from: e */
    public long m40919e() {
        long j10 = this.splashShowTimeInterval;
        if (j10 > 0) {
            return j10;
        }
        return 0L;
    }

    /* renamed from: f */
    public long m40920f() {
        long j10 = this.sloganShowMinTimeRealMode;
        if (j10 < 0 || j10 > 5000) {
            return 300L;
        }
        return j10;
    }

    /* renamed from: g */
    public Integer m40921g() {
        if (this.sloganShowTime == null) {
            return null;
        }
        Integer numM40923i = m40923i();
        return Integer.valueOf((numM40923i == null || 1 == numM40923i.intValue()) ? m40877ah() : (2 == numM40923i.intValue() || 3 == numM40923i.intValue()) ? m40876ag() : 0);
    }

    /* renamed from: h */
    public int m40922h() {
        int i10 = this.splashshow;
        if (i10 >= 2000) {
            return i10;
        }
        return 3000;
    }

    /* renamed from: i */
    public Integer m40923i() {
        Integer num = this.splashmode;
        if (num == null) {
            return null;
        }
        return Integer.valueOf((1 == num.intValue() || 2 == this.splashmode.intValue() || 3 == this.splashmode.intValue()) ? this.splashmode.intValue() : 1);
    }

    /* renamed from: j */
    public int m40924j() {
        int i10 = this.splashSkipArea;
        if (i10 < 0 || i10 > 200) {
            return 0;
        }
        return i10;
    }

    /* renamed from: k */
    public int m40925k() {
        return this.retcode;
    }

    /* renamed from: l */
    public String m40926l() {
        return this.serverStore;
    }

    /* renamed from: m */
    public Integer m40927m() {
        return this.landingMenu;
    }

    /* renamed from: n */
    public String m40928n() {
        return this.landpageAppWhiteList;
    }

    /* renamed from: o */
    public Integer m40929o() {
        return this.landpageAppPrompt;
    }

    /* renamed from: p */
    public Integer m40930p() {
        return this.configRefreshInterval;
    }

    /* renamed from: q */
    public Integer m40931q() {
        return this.validityOfSplashEvent;
    }

    /* renamed from: r */
    public Integer m40932r() {
        return this.validityOfClickSkip;
    }

    /* renamed from: s */
    public Integer m40933s() {
        return this.validityOfLockEvent;
    }

    /* renamed from: t */
    public Integer m40934t() {
        return this.validityOfNativeEvent;
    }

    /* renamed from: u */
    public String m40935u() {
        return this.globalSwitch;
    }

    /* renamed from: v */
    public List<String> m40936v() {
        return this.defBrowerPkgList;
    }

    /* renamed from: w */
    public String m40937w() {
        return this.supportHmsSdkVerCode;
    }

    /* renamed from: x */
    public long m40938x() {
        return this.preloadSplashReqTimeInterval;
    }

    /* renamed from: y */
    public String m40939y() {
        return this.landpageWebBlackList;
    }

    /* renamed from: z */
    public Integer m40940z() {
        return this.notifyKitWhenRequest;
    }

    /* renamed from: a */
    public String m40905a() {
        return this.trustAppList;
    }

    /* renamed from: b */
    public Long m40914b() {
        return this.minBannerInterval;
    }

    /* renamed from: c */
    public Long m40916c() {
        return this.maxBannerInterval;
    }

    /* renamed from: d */
    public int m40918d(int i10) {
        int i11 = this.imgSizeUpperLimit;
        return i11 > 0 ? i11 : i10;
    }

    /* renamed from: a */
    public String m40906a(String str) {
        ReduceDisturbRule reduceDisturbRule = this.reduceDisturbRule;
        if (reduceDisturbRule != null) {
            return m40875a(reduceDisturbRule.m40437a(), str);
        }
        return null;
    }

    /* renamed from: a */
    private String m40875a(List<Rule> list, String str) {
        return (list == null || list.size() > 30) ? str : AbstractC7758be.m47742b(this.reduceDisturbRule);
    }
}
