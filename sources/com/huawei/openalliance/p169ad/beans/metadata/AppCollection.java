package com.huawei.openalliance.p169ad.beans.metadata;

import com.huawei.openalliance.p169ad.annotations.DataKeep;
import com.huawei.openalliance.p169ad.annotations.InterfaceC6929a;
import java.util.List;

@DataKeep
/* loaded from: classes8.dex */
public class AppCollection {
    private String acceler;
    private String adIntentScore;
    private String adMergedScore;
    private String adScore;
    private String adType;

    @InterfaceC6929a
    private String adid;

    @InterfaceC6929a
    private List<AppCollectInfo> appInfos;
    private Integer appUsageCollect;
    private String bagId;
    private String baro;
    private String battery;

    @InterfaceC6929a
    private List<BluetoothInfo> blueToothList;
    private Long bootTime;
    private String brand;
    private Integer btListRetcode;
    private String buildVer;
    private String charging;
    private String cost7d;
    private String cpuCoreCnt;
    private String cpuModel;
    private String cpuSpeed;
    private Long dataTime;
    private String dayIntentId1st;
    private String dayIntentId2nd;
    private String dspId;

    @InterfaceC6929a
    private String ecpm;
    private String emuiVer;
    private String eventType;

    @InterfaceC6929a
    private String extra1;
    private String extra2;
    private String extra3;
    private String extra4;
    private String extra5;
    private String freeSto;

    @InterfaceC6929a
    private String gaid;

    @InterfaceC6929a
    private String gaidTrackingEnabled;
    private String gpuModel;
    private String gyro;
    private String hmsVersion;
    private String industryId1st;
    private String industryId2nd;
    private String interactionType;
    private String internetAccess;

    @InterfaceC6929a
    private Integer isOaidTrackingEnabled;
    private String kitVersion;
    private String lang;
    private String magicUIVer;
    private String magnet;
    private String maker;
    private String mcc;
    private String mediaType;
    private String mnc;
    private String model;

    @InterfaceC6929a
    private String oaid;

    @InterfaceC6929a
    private String odid;
    private String pdtName;
    private Long reportTimestamp;
    private String reqIntentId1st;
    private String reqIntentId2nd;
    private String routerCountry;
    private long scrOnT;
    private String seqId;
    private String timeZone;
    private String totalMem;
    private String totalSto;

    @InterfaceC6929a
    private String udid;

    @InterfaceC6929a
    private String uuid;
    private String vendCountry;
    private String vendor;
    private String wifi;

    @InterfaceC6929a
    private List<WifiInfo> wifiList;
    private Integer wifiListRetcode;

    /* renamed from: A */
    public String m39720A() {
        return this.cpuModel;
    }

    /* renamed from: B */
    public String m39722B() {
        return this.cpuCoreCnt;
    }

    /* renamed from: C */
    public String m39724C() {
        return this.cpuSpeed;
    }

    /* renamed from: D */
    public String m39726D() {
        return this.gpuModel;
    }

    /* renamed from: E */
    public String m39728E() {
        return this.totalMem;
    }

    /* renamed from: F */
    public String m39730F() {
        return this.totalSto;
    }

    /* renamed from: G */
    public String m39732G() {
        return this.freeSto;
    }

    /* renamed from: H */
    public String m39734H() {
        return this.vendor;
    }

    /* renamed from: I */
    public String m39736I() {
        return this.vendCountry;
    }

    /* renamed from: J */
    public String m39738J() {
        return this.routerCountry;
    }

    /* renamed from: K */
    public String m39740K() {
        return this.gyro;
    }

    /* renamed from: L */
    public String m39742L() {
        return this.acceler;
    }

    /* renamed from: M */
    public String m39744M() {
        return this.magnet;
    }

    /* renamed from: N */
    public String m39746N() {
        return this.baro;
    }

    /* renamed from: O */
    public String m39748O() {
        return this.battery;
    }

    /* renamed from: P */
    public String m39750P() {
        return this.charging;
    }

    /* renamed from: Q */
    public String m39752Q() {
        return this.uuid;
    }

    /* renamed from: R */
    public Integer m39754R() {
        return this.wifiListRetcode;
    }

    /* renamed from: S */
    public Integer m39756S() {
        return this.btListRetcode;
    }

    /* renamed from: T */
    public List<BluetoothInfo> m39758T() {
        return this.blueToothList;
    }

    /* renamed from: U */
    public String m39760U() {
        return this.maker;
    }

    /* renamed from: V */
    public String m39762V() {
        return this.brand;
    }

    /* renamed from: W */
    public List<WifiInfo> m39764W() {
        return this.wifiList;
    }

    /* renamed from: X */
    public String m39766X() {
        return this.ecpm;
    }

    /* renamed from: Y */
    public String m39768Y() {
        return this.adScore;
    }

    /* renamed from: Z */
    public String m39770Z() {
        return this.adIntentScore;
    }

    /* renamed from: a */
    public long m39772a() {
        return this.scrOnT;
    }

    /* renamed from: aa */
    public String m39778aa() {
        return this.adMergedScore;
    }

    /* renamed from: ab */
    public String m39780ab() {
        return this.interactionType;
    }

    /* renamed from: ac */
    public String m39782ac() {
        return this.industryId1st;
    }

    /* renamed from: ad */
    public String m39784ad() {
        return this.industryId2nd;
    }

    /* renamed from: ae */
    public String m39786ae() {
        return this.mediaType;
    }

    /* renamed from: af */
    public String m39788af() {
        return this.adType;
    }

    /* renamed from: ag */
    public String m39790ag() {
        return this.dspId;
    }

    /* renamed from: ah */
    public String m39792ah() {
        return this.cost7d;
    }

    /* renamed from: ai */
    public String m39793ai() {
        return this.reqIntentId1st;
    }

    /* renamed from: aj */
    public String m39794aj() {
        return this.reqIntentId2nd;
    }

    /* renamed from: ak */
    public String m39795ak() {
        return this.dayIntentId1st;
    }

    /* renamed from: al */
    public String m39796al() {
        return this.dayIntentId2nd;
    }

    /* renamed from: am */
    public String m39797am() {
        return this.bagId;
    }

    /* renamed from: an */
    public String m39798an() {
        return this.adid;
    }

    /* renamed from: b */
    public Long m39799b() {
        return this.reportTimestamp;
    }

    /* renamed from: c */
    public String m39804c() {
        return this.seqId;
    }

    /* renamed from: d */
    public String m39809d() {
        return this.model;
    }

    /* renamed from: e */
    public String m39812e() {
        return this.buildVer;
    }

    /* renamed from: f */
    public String m39814f() {
        return this.emuiVer;
    }

    /* renamed from: g */
    public String m39816g() {
        return this.magicUIVer;
    }

    /* renamed from: h */
    public Long m39818h() {
        return this.dataTime;
    }

    /* renamed from: i */
    public Integer m39820i() {
        return this.appUsageCollect;
    }

    /* renamed from: j */
    public String m39822j() {
        return this.timeZone;
    }

    /* renamed from: k */
    public String m39824k() {
        return this.oaid;
    }

    /* renamed from: l */
    public Integer m39826l() {
        return this.isOaidTrackingEnabled;
    }

    /* renamed from: m */
    public String m39828m() {
        return this.udid;
    }

    /* renamed from: n */
    public String m39830n() {
        return this.eventType;
    }

    /* renamed from: o */
    public String m39832o() {
        return this.extra1;
    }

    /* renamed from: p */
    public String m39834p() {
        return this.extra2;
    }

    /* renamed from: q */
    public String m39836q() {
        return this.extra3;
    }

    /* renamed from: r */
    public String m39838r() {
        return this.extra4;
    }

    /* renamed from: s */
    public List<AppCollectInfo> m39840s() {
        return this.appInfos;
    }

    /* renamed from: t */
    public String m39842t() {
        return this.hmsVersion;
    }

    /* renamed from: u */
    public String m39844u() {
        return this.kitVersion;
    }

    /* renamed from: v */
    public String m39846v() {
        return this.internetAccess;
    }

    /* renamed from: w */
    public String m39848w() {
        return this.mnc;
    }

    /* renamed from: x */
    public String m39850x() {
        return this.wifi;
    }

    /* renamed from: y */
    public String m39852y() {
        return this.lang;
    }

    /* renamed from: z */
    public String m39854z() {
        return this.pdtName;
    }

    /* renamed from: A */
    public void m39721A(String str) {
        this.gpuModel = str;
    }

    /* renamed from: B */
    public void m39723B(String str) {
        this.totalMem = str;
    }

    /* renamed from: C */
    public void m39725C(String str) {
        this.totalSto = str;
    }

    /* renamed from: D */
    public void m39727D(String str) {
        this.freeSto = str;
    }

    /* renamed from: E */
    public void m39729E(String str) {
        this.vendor = str;
    }

    /* renamed from: F */
    public void m39731F(String str) {
        this.vendCountry = str;
    }

    /* renamed from: G */
    public void m39733G(String str) {
        this.routerCountry = str;
    }

    /* renamed from: H */
    public void m39735H(String str) {
        this.gyro = str;
    }

    /* renamed from: I */
    public void m39737I(String str) {
        this.acceler = str;
    }

    /* renamed from: J */
    public void m39739J(String str) {
        this.magnet = str;
    }

    /* renamed from: K */
    public void m39741K(String str) {
        this.baro = str;
    }

    /* renamed from: L */
    public void m39743L(String str) {
        this.battery = str;
    }

    /* renamed from: M */
    public void m39745M(String str) {
        this.charging = str;
    }

    /* renamed from: N */
    public void m39747N(String str) {
        this.uuid = str;
    }

    /* renamed from: O */
    public void m39749O(String str) {
        this.maker = str;
    }

    /* renamed from: P */
    public void m39751P(String str) {
        this.brand = str;
    }

    /* renamed from: Q */
    public void m39753Q(String str) {
        this.ecpm = str;
    }

    /* renamed from: R */
    public void m39755R(String str) {
        this.adScore = str;
    }

    /* renamed from: S */
    public void m39757S(String str) {
        this.adIntentScore = str;
    }

    /* renamed from: T */
    public void m39759T(String str) {
        this.adMergedScore = str;
    }

    /* renamed from: U */
    public void m39761U(String str) {
        this.interactionType = str;
    }

    /* renamed from: V */
    public void m39763V(String str) {
        this.industryId1st = str;
    }

    /* renamed from: W */
    public void m39765W(String str) {
        this.industryId2nd = str;
    }

    /* renamed from: X */
    public void m39767X(String str) {
        this.mediaType = str;
    }

    /* renamed from: Y */
    public void m39769Y(String str) {
        this.adType = str;
    }

    /* renamed from: Z */
    public void m39771Z(String str) {
        this.dspId = str;
    }

    /* renamed from: a */
    public void m39773a(long j10) {
        this.scrOnT = j10;
    }

    /* renamed from: aa */
    public void m39779aa(String str) {
        this.cost7d = str;
    }

    /* renamed from: ab */
    public void m39781ab(String str) {
        this.reqIntentId1st = str;
    }

    /* renamed from: ac */
    public void m39783ac(String str) {
        this.reqIntentId2nd = str;
    }

    /* renamed from: ad */
    public void m39785ad(String str) {
        this.dayIntentId1st = str;
    }

    /* renamed from: ae */
    public void m39787ae(String str) {
        this.dayIntentId2nd = str;
    }

    /* renamed from: af */
    public void m39789af(String str) {
        this.bagId = str;
    }

    /* renamed from: ag */
    public void m39791ag(String str) {
        this.adid = str;
    }

    /* renamed from: b */
    public void m39800b(Integer num) {
        this.isOaidTrackingEnabled = num;
    }

    /* renamed from: c */
    public void m39805c(Integer num) {
        this.wifiListRetcode = num;
    }

    /* renamed from: d */
    public void m39810d(Integer num) {
        this.btListRetcode = num;
    }

    /* renamed from: e */
    public void m39813e(String str) {
        this.magicUIVer = str;
    }

    /* renamed from: f */
    public void m39815f(String str) {
        this.timeZone = str;
    }

    /* renamed from: g */
    public void m39817g(String str) {
        this.oaid = str;
    }

    /* renamed from: h */
    public void m39819h(String str) {
        this.udid = str;
    }

    /* renamed from: i */
    public void m39821i(String str) {
        this.extra1 = str;
    }

    /* renamed from: j */
    public void m39823j(String str) {
        this.extra2 = str;
    }

    /* renamed from: k */
    public void m39825k(String str) {
        this.extra3 = str;
    }

    /* renamed from: l */
    public void m39827l(String str) {
        this.extra4 = str;
    }

    /* renamed from: m */
    public void m39829m(String str) {
        this.extra5 = str;
    }

    /* renamed from: n */
    public void m39831n(String str) {
        this.eventType = str;
    }

    /* renamed from: o */
    public void m39833o(String str) {
        this.odid = str;
    }

    /* renamed from: p */
    public void m39835p(String str) {
        this.hmsVersion = str;
    }

    /* renamed from: q */
    public void m39837q(String str) {
        this.kitVersion = str;
    }

    /* renamed from: r */
    public void m39839r(String str) {
        this.internetAccess = str;
    }

    /* renamed from: s */
    public void m39841s(String str) {
        this.mnc = str;
    }

    /* renamed from: t */
    public void m39843t(String str) {
        this.mcc = str;
    }

    /* renamed from: u */
    public void m39845u(String str) {
        this.wifi = str;
    }

    /* renamed from: v */
    public void m39847v(String str) {
        this.lang = str;
    }

    /* renamed from: w */
    public void m39849w(String str) {
        this.pdtName = str;
    }

    /* renamed from: x */
    public void m39851x(String str) {
        this.cpuModel = str;
    }

    /* renamed from: y */
    public void m39853y(String str) {
        this.cpuCoreCnt = str;
    }

    /* renamed from: z */
    public void m39855z(String str) {
        this.cpuSpeed = str;
    }

    /* renamed from: a */
    public void m39774a(Integer num) {
        this.appUsageCollect = num;
    }

    /* renamed from: b */
    public void m39801b(Long l10) {
        this.dataTime = l10;
    }

    /* renamed from: c */
    public void m39806c(Long l10) {
        this.bootTime = l10;
    }

    /* renamed from: d */
    public void m39811d(String str) {
        this.emuiVer = str;
    }

    /* renamed from: a */
    public void m39775a(Long l10) {
        this.reportTimestamp = l10;
    }

    /* renamed from: b */
    public void m39802b(String str) {
        this.model = str;
    }

    /* renamed from: c */
    public void m39807c(String str) {
        this.buildVer = str;
    }

    /* renamed from: a */
    public void m39776a(String str) {
        this.seqId = str;
    }

    /* renamed from: b */
    public void m39803b(List<BluetoothInfo> list) {
        this.blueToothList = list;
    }

    /* renamed from: c */
    public void m39808c(List<WifiInfo> list) {
        this.wifiList = list;
    }

    /* renamed from: a */
    public void m39777a(List<AppCollectInfo> list) {
        this.appInfos = list;
    }
}
