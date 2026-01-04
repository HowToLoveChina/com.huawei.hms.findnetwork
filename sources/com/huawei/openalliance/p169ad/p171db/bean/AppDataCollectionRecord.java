package com.huawei.openalliance.p169ad.p171db.bean;

import com.huawei.openalliance.p169ad.annotations.DataKeep;
import com.huawei.openalliance.p169ad.annotations.InterfaceC6933e;
import com.huawei.openalliance.p169ad.annotations.InterfaceC6934f;
import com.huawei.openalliance.p169ad.beans.metadata.AppCollectInfo;
import com.huawei.openalliance.p169ad.beans.metadata.BluetoothInfo;
import com.huawei.openalliance.p169ad.beans.metadata.WifiInfo;
import java.io.Serializable;
import java.util.List;

@DataKeep
/* loaded from: classes2.dex */
public class AppDataCollectionRecord extends C7013a implements Serializable {
    public static final String REPORT_TIME = "reportTimestamp";
    private static final long serialVersionUID = 30469300;

    @InterfaceC6933e
    private String _id;
    private String acceler;
    private String adIntentScore;
    private String adMergedScore;
    private String adScore;
    private String adType;
    private String adid;

    @InterfaceC6934f
    private EncryptionField<List<AppCollectInfo>> appInfos;
    private String appUsageCollect;
    private String bagId;
    private String baro;
    private String battery;

    @InterfaceC6934f
    private EncryptionField<List<BluetoothInfo>> blueToothList;
    private String brand;
    private String btListRetcode;
    private String buildVer;
    private String charging;
    private String cost7d;
    private String cpuCoreCnt;
    private String cpuModel;
    private String cpuSpeed;
    private String dataTime;
    private String dayIntentId1st;
    private String dayIntentId2nd;
    private String dspId;

    @InterfaceC6934f
    private EncryptionField<String> ecpm;
    private String emuiVer;
    private String eventType;
    private String extra1;
    private String extra2;
    private String extra3;
    private String extra4;
    private String extra5;
    private String freeSto;
    private String gpuModel;
    private String gyro;
    private String hmsVersion;
    private String industryId1st;
    private String industryId2nd;
    private String interactionType;
    private String internetAccess;
    private int isOaidTrackingEnabled;
    private String kitVersion;
    private String lang;
    private String magicUIVer;
    private String magnet;
    private String maker;
    private String mcc;
    private String mediaType;
    private String mnc;
    private String model;
    private String oaid;
    private String odid;
    private String pdtName;
    private long reportTimestamp;
    private String reqIntentId1st;
    private String reqIntentId2nd;
    private String routerCountry;
    private long scrOnT;
    private String timeZone;
    private String totalMem;
    private String totalSto;
    private String udid;
    private String uuid;
    private String vendCountry;
    private String vendor;
    private String wifi;

    @InterfaceC6934f
    private EncryptionField<List<WifiInfo>> wifiList;
    private String wifiListRetcode;

    /* renamed from: A */
    public String m41248A() {
        return this.lang;
    }

    /* renamed from: B */
    public String m41250B() {
        return this.pdtName;
    }

    /* renamed from: C */
    public String m41252C() {
        return this.cpuModel;
    }

    /* renamed from: D */
    public String m41254D() {
        return this.cpuCoreCnt;
    }

    /* renamed from: E */
    public String m41256E() {
        return this.cpuSpeed;
    }

    /* renamed from: F */
    public String m41258F() {
        return this.gpuModel;
    }

    /* renamed from: G */
    public String m41260G() {
        return this.totalMem;
    }

    /* renamed from: H */
    public String m41262H() {
        return this.totalSto;
    }

    /* renamed from: I */
    public String m41264I() {
        return this.freeSto;
    }

    /* renamed from: J */
    public String m41266J() {
        return this.vendor;
    }

    /* renamed from: K */
    public String m41268K() {
        return this.vendCountry;
    }

    /* renamed from: L */
    public String m41270L() {
        return this.routerCountry;
    }

    /* renamed from: M */
    public String m41272M() {
        return this.gyro;
    }

    /* renamed from: N */
    public String m41274N() {
        return this.acceler;
    }

    /* renamed from: O */
    public String m41276O() {
        return this.magnet;
    }

    /* renamed from: P */
    public String m41278P() {
        return this.baro;
    }

    /* renamed from: Q */
    public String m41280Q() {
        return this.battery;
    }

    /* renamed from: R */
    public String m41282R() {
        return this.charging;
    }

    /* renamed from: S */
    public String m41284S() {
        return this.uuid;
    }

    /* renamed from: T */
    public String m41286T() {
        return this.wifiListRetcode;
    }

    /* renamed from: U */
    public String m41288U() {
        return this.btListRetcode;
    }

    /* renamed from: V */
    public EncryptionField<List<BluetoothInfo>> m41290V() {
        return this.blueToothList;
    }

    /* renamed from: W */
    public EncryptionField<List<WifiInfo>> m41292W() {
        return this.wifiList;
    }

    /* renamed from: X */
    public EncryptionField<List<AppCollectInfo>> m41294X() {
        return this.appInfos;
    }

    /* renamed from: Y */
    public String m41296Y() {
        return this.maker;
    }

    /* renamed from: Z */
    public String m41298Z() {
        return this.brand;
    }

    /* renamed from: a */
    public long m41300a() {
        return this.scrOnT;
    }

    /* renamed from: aa */
    public EncryptionField<String> m41305aa() {
        return this.ecpm;
    }

    /* renamed from: ab */
    public String m41307ab() {
        return this.adScore;
    }

    /* renamed from: ac */
    public String m41309ac() {
        return this.adIntentScore;
    }

    /* renamed from: ad */
    public String m41311ad() {
        return this.adMergedScore;
    }

    /* renamed from: ae */
    public String m41313ae() {
        return this.interactionType;
    }

    /* renamed from: af */
    public String m41315af() {
        return this.industryId1st;
    }

    /* renamed from: ag */
    public String m41317ag() {
        return this.industryId2nd;
    }

    /* renamed from: ah */
    public String m41319ah() {
        return this.mediaType;
    }

    /* renamed from: ai */
    public String m41321ai() {
        return this.adType;
    }

    /* renamed from: aj */
    public String m41323aj() {
        return this.dspId;
    }

    /* renamed from: ak */
    public String m41324ak() {
        return this.cost7d;
    }

    /* renamed from: al */
    public String m41325al() {
        return this.reqIntentId1st;
    }

    /* renamed from: am */
    public String m41326am() {
        return this.reqIntentId2nd;
    }

    /* renamed from: an */
    public String m41327an() {
        return this.dayIntentId1st;
    }

    /* renamed from: ao */
    public String m41328ao() {
        return this.dayIntentId2nd;
    }

    /* renamed from: ap */
    public String m41329ap() {
        return this.bagId;
    }

    /* renamed from: aq */
    public String m41330aq() {
        return this.adid;
    }

    /* renamed from: b */
    public String m41331b() {
        return this._id;
    }

    /* renamed from: c */
    public String m41335c() {
        return this.dataTime;
    }

    /* renamed from: d */
    public String m41338d() {
        return this.appUsageCollect;
    }

    /* renamed from: e */
    public String m41340e() {
        return this.timeZone;
    }

    /* renamed from: f */
    public String m41342f() {
        return this.oaid;
    }

    /* renamed from: g */
    public int m41344g() {
        return this.isOaidTrackingEnabled;
    }

    /* renamed from: h */
    public String m41346h() {
        return this.udid;
    }

    /* renamed from: i */
    public String m41348i() {
        return this.eventType;
    }

    /* renamed from: j */
    public String m41350j() {
        return this.extra1;
    }

    /* renamed from: k */
    public String m41352k() {
        return this.extra2;
    }

    /* renamed from: l */
    public String m41354l() {
        return this.extra3;
    }

    /* renamed from: m */
    public String m41356m() {
        return this.extra4;
    }

    /* renamed from: n */
    public String m41358n() {
        return this.extra5;
    }

    /* renamed from: o */
    public long m41360o() {
        return this.reportTimestamp;
    }

    /* renamed from: p */
    public String m41362p() {
        return this.model;
    }

    /* renamed from: q */
    public String m41364q() {
        return this.buildVer;
    }

    /* renamed from: r */
    public String m41366r() {
        return this.emuiVer;
    }

    /* renamed from: s */
    public String m41368s() {
        return this.magicUIVer;
    }

    /* renamed from: t */
    public String m41370t() {
        return this.odid;
    }

    /* renamed from: u */
    public String m41372u() {
        return this.hmsVersion;
    }

    /* renamed from: v */
    public String m41374v() {
        return this.kitVersion;
    }

    /* renamed from: w */
    public String m41376w() {
        return this.internetAccess;
    }

    /* renamed from: x */
    public String m41378x() {
        return this.mnc;
    }

    /* renamed from: y */
    public String m41380y() {
        return this.mcc;
    }

    /* renamed from: z */
    public String m41382z() {
        return this.wifi;
    }

    /* renamed from: A */
    public void m41249A(String str) {
        this.gpuModel = str;
    }

    /* renamed from: B */
    public void m41251B(String str) {
        this.totalMem = str;
    }

    /* renamed from: C */
    public void m41253C(String str) {
        this.totalSto = str;
    }

    /* renamed from: D */
    public void m41255D(String str) {
        this.freeSto = str;
    }

    /* renamed from: E */
    public void m41257E(String str) {
        this.vendor = str;
    }

    /* renamed from: F */
    public void m41259F(String str) {
        this.vendCountry = str;
    }

    /* renamed from: G */
    public void m41261G(String str) {
        this.routerCountry = str;
    }

    /* renamed from: H */
    public void m41263H(String str) {
        this.gyro = str;
    }

    /* renamed from: I */
    public void m41265I(String str) {
        this.acceler = str;
    }

    /* renamed from: J */
    public void m41267J(String str) {
        this.magnet = str;
    }

    /* renamed from: K */
    public void m41269K(String str) {
        if (str != null) {
            this.baro = str;
        }
    }

    /* renamed from: L */
    public void m41271L(String str) {
        this.battery = str;
    }

    /* renamed from: M */
    public void m41273M(String str) {
        this.charging = str;
    }

    /* renamed from: N */
    public void m41275N(String str) {
        this.uuid = str;
    }

    /* renamed from: O */
    public void m41277O(String str) {
        this.wifiListRetcode = str;
    }

    /* renamed from: P */
    public void m41279P(String str) {
        this.btListRetcode = str;
    }

    /* renamed from: Q */
    public void m41281Q(String str) {
        this.maker = str;
    }

    /* renamed from: R */
    public void m41283R(String str) {
        this.brand = str;
    }

    /* renamed from: S */
    public void m41285S(String str) {
        EncryptionField<String> encryptionField = new EncryptionField<>(String.class);
        encryptionField.m41655a((EncryptionField<String>) str);
        this.ecpm = encryptionField;
    }

    /* renamed from: T */
    public void m41287T(String str) {
        this.adScore = str;
    }

    /* renamed from: U */
    public void m41289U(String str) {
        this.adIntentScore = str;
    }

    /* renamed from: V */
    public void m41291V(String str) {
        this.adMergedScore = str;
    }

    /* renamed from: W */
    public void m41293W(String str) {
        this.interactionType = str;
    }

    /* renamed from: X */
    public void m41295X(String str) {
        this.industryId1st = str;
    }

    /* renamed from: Y */
    public void m41297Y(String str) {
        this.industryId2nd = str;
    }

    /* renamed from: Z */
    public void m41299Z(String str) {
        this.mediaType = str;
    }

    /* renamed from: a */
    public void m41301a(int i10) {
        this.isOaidTrackingEnabled = i10;
    }

    /* renamed from: aa */
    public void m41306aa(String str) {
        this.adType = str;
    }

    /* renamed from: ab */
    public void m41308ab(String str) {
        this.dspId = str;
    }

    /* renamed from: ac */
    public void m41310ac(String str) {
        this.cost7d = str;
    }

    /* renamed from: ad */
    public void m41312ad(String str) {
        this.reqIntentId1st = str;
    }

    /* renamed from: ae */
    public void m41314ae(String str) {
        this.reqIntentId2nd = str;
    }

    /* renamed from: af */
    public void m41316af(String str) {
        this.dayIntentId1st = str;
    }

    /* renamed from: ag */
    public void m41318ag(String str) {
        this.dayIntentId2nd = str;
    }

    /* renamed from: ah */
    public void m41320ah(String str) {
        this.bagId = str;
    }

    /* renamed from: ai */
    public void m41322ai(String str) {
        this.adid = str;
    }

    /* renamed from: b */
    public void m41332b(long j10) {
        this.reportTimestamp = j10;
    }

    /* renamed from: c */
    public void m41336c(String str) {
        this.appUsageCollect = str;
    }

    /* renamed from: d */
    public void m41339d(String str) {
        this.timeZone = str;
    }

    /* renamed from: e */
    public void m41341e(String str) {
        this.oaid = str;
    }

    /* renamed from: f */
    public void m41343f(String str) {
        this.udid = str;
    }

    /* renamed from: g */
    public void m41345g(String str) {
        this.eventType = str;
    }

    /* renamed from: h */
    public void m41347h(String str) {
        this.extra1 = str;
    }

    /* renamed from: i */
    public void m41349i(String str) {
        this.extra2 = str;
    }

    /* renamed from: j */
    public void m41351j(String str) {
        this.extra3 = str;
    }

    /* renamed from: k */
    public void m41353k(String str) {
        this.extra4 = str;
    }

    /* renamed from: l */
    public void m41355l(String str) {
        this.extra5 = str;
    }

    /* renamed from: m */
    public void m41357m(String str) {
        this.model = str;
    }

    /* renamed from: n */
    public void m41359n(String str) {
        this.buildVer = str;
    }

    /* renamed from: o */
    public void m41361o(String str) {
        this.emuiVer = str;
    }

    /* renamed from: p */
    public void m41363p(String str) {
        this.magicUIVer = str;
    }

    /* renamed from: q */
    public void m41365q(String str) {
        this.hmsVersion = str;
    }

    /* renamed from: r */
    public void m41367r(String str) {
        this.kitVersion = str;
    }

    /* renamed from: s */
    public void m41369s(String str) {
        this.internetAccess = str;
    }

    /* renamed from: t */
    public void m41371t(String str) {
        this.mnc = str;
    }

    /* renamed from: u */
    public void m41373u(String str) {
        this.wifi = str;
    }

    /* renamed from: v */
    public void m41375v(String str) {
        this.lang = str;
    }

    /* renamed from: w */
    public void m41377w(String str) {
        this.pdtName = str;
    }

    /* renamed from: x */
    public void m41379x(String str) {
        this.cpuModel = str;
    }

    /* renamed from: y */
    public void m41381y(String str) {
        this.cpuCoreCnt = str;
    }

    /* renamed from: z */
    public void m41383z(String str) {
        this.cpuSpeed = str;
    }

    /* renamed from: a */
    public void m41302a(long j10) {
        this.scrOnT = j10;
    }

    /* renamed from: b */
    public void m41333b(String str) {
        this.dataTime = str;
    }

    /* renamed from: c */
    public void m41337c(List<AppCollectInfo> list) {
        EncryptionField<List<AppCollectInfo>> encryptionField = new EncryptionField<>(List.class, AppCollectInfo.class);
        encryptionField.m41655a((EncryptionField<List<AppCollectInfo>>) list);
        this.appInfos = encryptionField;
    }

    /* renamed from: a */
    public void m41303a(String str) {
        this._id = str;
    }

    /* renamed from: b */
    public void m41334b(List<WifiInfo> list) {
        EncryptionField<List<WifiInfo>> encryptionField = new EncryptionField<>(List.class, WifiInfo.class);
        encryptionField.m41655a((EncryptionField<List<WifiInfo>>) list);
        this.wifiList = encryptionField;
    }

    /* renamed from: a */
    public void m41304a(List<BluetoothInfo> list) {
        EncryptionField<List<BluetoothInfo>> encryptionField = new EncryptionField<>(List.class, BluetoothInfo.class);
        encryptionField.m41655a((EncryptionField<List<BluetoothInfo>>) list);
        this.blueToothList = encryptionField;
    }
}
