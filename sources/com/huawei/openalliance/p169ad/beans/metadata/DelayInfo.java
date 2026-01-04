package com.huawei.openalliance.p169ad.beans.metadata;

import com.huawei.openalliance.p169ad.annotations.DataKeep;
import java.util.List;

@DataKeep
/* loaded from: classes8.dex */
public class DelayInfo {
    private static final int AD_LOAD_TIMEOUT_AFTER_RESPONSE = 20;
    private static final int AD_LOAD_TIMEOUT_BEFORE_RESPONSE = 10;
    private int adAmount;
    private long adFilterDuration;
    private List<String> adIds;
    private String adSign;
    private String contentDownMethod;
    private List<String> contentIds;
    private String costFromServer;
    private Integer creativeType;
    private Integer detailedRetCode;
    private int exSplashFlag;
    private long hmsRecEngineCostTime;
    private String preloadMode;
    private long recEngineCostTime;
    private Integer requestType;
    private long resDownloadDuration;
    private int resultCode;
    private int serverRetCode;
    private String spareContentId;
    private long splashContentLoadedCost;
    private String splashShowMode;
    private long threadSwitchCost;
    private long uiThreadSwithCostTime;
    private boolean isSpare = false;
    private AdTimeStatistics timeStatistics = new AdTimeStatistics();
    private boolean spareExist = false;

    /* renamed from: A */
    public boolean m40020A() {
        return this.spareExist;
    }

    /* renamed from: B */
    public long m40021B() {
        return this.uiThreadSwithCostTime;
    }

    /* renamed from: C */
    public String m40022C() {
        return this.preloadMode;
    }

    /* renamed from: D */
    public long m40023D() {
        return this.recEngineCostTime;
    }

    /* renamed from: E */
    public long m40024E() {
        return this.hmsRecEngineCostTime;
    }

    /* renamed from: F */
    public Integer m40025F() {
        return this.requestType;
    }

    /* renamed from: a */
    public long m40026a() {
        return m40019a(this.timeStatistics.m39557a(), this.timeStatistics.m39559b());
    }

    /* renamed from: b */
    public long m40033b() {
        return m40019a(this.timeStatistics.m39563d(), this.timeStatistics.m39565e());
    }

    /* renamed from: c */
    public long m40040c() {
        return this.adFilterDuration;
    }

    /* renamed from: d */
    public long m40044d() {
        return this.threadSwitchCost;
    }

    /* renamed from: e */
    public long m40047e() {
        return m40019a(this.timeStatistics.m39557a(), this.timeStatistics.m39563d());
    }

    /* renamed from: f */
    public long m40050f() {
        return m40019a(this.timeStatistics.m39567f(), this.timeStatistics.m39569g());
    }

    /* renamed from: g */
    public List<String> m40053g() {
        return this.adIds;
    }

    /* renamed from: h */
    public List<String> m40055h() {
        return this.contentIds;
    }

    /* renamed from: i */
    public int m40057i() {
        return this.adAmount;
    }

    /* renamed from: j */
    public long m40059j() {
        return m40019a(this.timeStatistics.m39557a(), this.timeStatistics.m39571h());
    }

    /* renamed from: k */
    public String m40060k() {
        return this.splashShowMode;
    }

    /* renamed from: l */
    public String m40061l() {
        return this.contentDownMethod;
    }

    /* renamed from: m */
    public long m40062m() {
        return this.resDownloadDuration;
    }

    /* renamed from: n */
    public long m40063n() {
        return m40019a(this.timeStatistics.m39557a(), this.timeStatistics.m39573i());
    }

    /* renamed from: o */
    public long m40064o() {
        return this.splashContentLoadedCost;
    }

    /* renamed from: p */
    public int m40065p() {
        return this.exSplashFlag;
    }

    /* renamed from: q */
    public int m40066q() {
        return this.resultCode;
    }

    /* renamed from: r */
    public int m40067r() {
        return this.serverRetCode;
    }

    /* renamed from: s */
    public int m40068s() {
        long jM39559b = this.timeStatistics.m39559b();
        long jM39565e = this.timeStatistics.m39565e();
        if (jM39559b == 0 || jM39565e == 0) {
            return 0;
        }
        return jM39559b <= jM39565e ? 10 : 20;
    }

    /* renamed from: t */
    public boolean m40069t() {
        return this.isSpare;
    }

    /* renamed from: u */
    public AdTimeStatistics m40070u() {
        return this.timeStatistics;
    }

    /* renamed from: v */
    public Integer m40071v() {
        return this.creativeType;
    }

    /* renamed from: w */
    public Integer m40072w() {
        return this.detailedRetCode;
    }

    /* renamed from: x */
    public String m40073x() {
        return this.costFromServer;
    }

    /* renamed from: y */
    public String m40074y() {
        return this.adSign;
    }

    /* renamed from: z */
    public String m40075z() {
        return this.spareContentId;
    }

    /* renamed from: a */
    private long m40019a(long j10, long j11) {
        if (j10 <= 0 || j10 >= j11) {
            return 0L;
        }
        return j11 - j10;
    }

    /* renamed from: b */
    public void m40034b(int i10) {
        this.serverRetCode = i10;
    }

    /* renamed from: c */
    public void m40041c(long j10) {
        this.adFilterDuration = j10;
    }

    /* renamed from: d */
    public void m40045d(long j10) {
        this.threadSwitchCost = j10;
    }

    /* renamed from: e */
    public void m40048e(long j10) {
        this.resDownloadDuration = j10;
    }

    /* renamed from: f */
    public void m40051f(long j10) {
        this.splashContentLoadedCost = m40019a(this.timeStatistics.m39557a(), j10);
    }

    /* renamed from: g */
    public void m40054g(long j10) {
        this.uiThreadSwithCostTime = j10;
    }

    /* renamed from: h */
    public void m40056h(long j10) {
        this.recEngineCostTime = j10;
    }

    /* renamed from: i */
    public void m40058i(long j10) {
        this.hmsRecEngineCostTime = j10;
    }

    /* renamed from: a */
    public void m40027a(int i10) {
        this.resultCode = i10;
    }

    /* renamed from: b */
    public void m40035b(long j10) {
        this.timeStatistics.m39560b(j10);
    }

    /* renamed from: c */
    public void m40042c(Integer num) {
        this.requestType = num;
    }

    /* renamed from: d */
    public void m40046d(String str) {
        this.adSign = str;
    }

    /* renamed from: e */
    public void m40049e(String str) {
        this.spareContentId = str;
    }

    /* renamed from: f */
    public void m40052f(String str) {
        this.preloadMode = str;
    }

    /* renamed from: a */
    public void m40028a(long j10) {
        this.timeStatistics.m39558a(j10);
    }

    /* renamed from: b */
    public void m40036b(Integer num) {
        this.detailedRetCode = num;
    }

    /* renamed from: c */
    public void m40043c(String str) {
        this.costFromServer = str;
    }

    /* renamed from: a */
    public void m40029a(Integer num) {
        this.creativeType = num;
    }

    /* renamed from: b */
    public void m40037b(String str) {
        this.contentDownMethod = str;
    }

    /* renamed from: a */
    public void m40030a(String str) {
        this.splashShowMode = str;
    }

    /* renamed from: b */
    public void m40038b(List<String> list) {
        this.contentIds = list;
    }

    /* renamed from: a */
    public void m40031a(List<String> list) {
        this.adIds = list;
    }

    /* renamed from: b */
    public void m40039b(boolean z10) {
        this.spareExist = z10;
    }

    /* renamed from: a */
    public void m40032a(boolean z10) {
        this.isSpare = z10;
    }
}
