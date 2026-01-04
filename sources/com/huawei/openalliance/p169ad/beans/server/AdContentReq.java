package com.huawei.openalliance.p169ad.beans.server;

import android.content.Context;
import com.huawei.hms.ads.data.SearchInfo;
import com.huawei.openalliance.p169ad.C7095ek;
import com.huawei.openalliance.p169ad.C7489mx;
import com.huawei.openalliance.p169ad.annotations.DataKeep;
import com.huawei.openalliance.p169ad.annotations.InterfaceC6929a;
import com.huawei.openalliance.p169ad.annotations.InterfaceC6932d;
import com.huawei.openalliance.p169ad.annotations.InterfaceC6934f;
import com.huawei.openalliance.p169ad.beans.base.ReqBean;
import com.huawei.openalliance.p169ad.beans.metadata.AdSlot30;
import com.huawei.openalliance.p169ad.beans.metadata.App;
import com.huawei.openalliance.p169ad.beans.metadata.Device;
import com.huawei.openalliance.p169ad.beans.metadata.Location;
import com.huawei.openalliance.p169ad.beans.metadata.Network;
import com.huawei.openalliance.p169ad.beans.metadata.Options;
import com.huawei.openalliance.p169ad.beans.parameter.AdSlotParam;
import com.huawei.openalliance.p169ad.constant.Config;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.inter.data.SearchTerm;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.AbstractC7807d;
import com.huawei.openalliance.p169ad.utils.AbstractC7811dd;
import com.huawei.openalliance.p169ad.utils.AbstractC7834m;
import java.util.List;
import java.util.Map;

@DataKeep
/* loaded from: classes8.dex */
public class AdContentReq extends ReqBean {

    @InterfaceC6932d(m39225a = "gACString")
    @InterfaceC6929a
    private String acString;
    private App app;

    @InterfaceC6929a
    private List<String> audIds;
    private List<String> blkTptIds;
    private List<String> cacheSloganId;
    private List<String> cachecontentid;
    private List<String> cachedTemplates;
    private String clientAdRequestId;

    @InterfaceC6929a
    private String consent;
    private List<String> cur;
    private Device device;

    @InterfaceC6929a
    private String hwACString;
    private Integer hwDspNpa;
    private Integer isQueryUseEnabled;

    @InterfaceC6932d(m39225a = "geo")
    private Location loc;
    private List<AdSlot30> multislot;
    private Network network;
    private Integer nonPersonalizedAd;

    @InterfaceC6932d(m39225a = "regs")
    private Options opts;
    private int parentCtrlUser;
    private int pdToOther;

    @InterfaceC6929a
    private String ppsStore;

    @InterfaceC6932d(m39225a = "pltm")
    private Integer preloadTriggerMode;
    private List<String> removedContentId;
    private Integer requestType;
    private int scrnReadStat;
    private int[] sdkMonitors;

    @InterfaceC6932d(m39225a = "search")
    private SearchInfo searchInfo;

    @InterfaceC6932d(m39225a = "srch")
    private SearchTerm searchTerm;
    private Integer tMax;

    @InterfaceC6929a
    private Map<String, String> tag;
    private Integer thirdDspNpa;
    private String tptEngineVer;
    private Map<String, Integer> unsptTptTags;
    private String version = Constants.INTER_VERSION;
    private String sdkversion = Config.SDK_VERSION;
    private int reqPurpose = 1;

    @InterfaceC6932d(m39225a = "rtenv")
    private Integer appRunningStatus = 1;
    private Integer suptRelateRank = 0;

    @InterfaceC6934f
    private String acdReqUri = Constants.ACD_REQ_URI;

    @InterfaceC6934f
    private String acdRealm = Constants.ACD_REALM;

    public AdContentReq() {
    }

    /* renamed from: A */
    public Integer m40750A() {
        return this.appRunningStatus;
    }

    /* renamed from: B */
    public String m40751B() {
        return this.consent;
    }

    /* renamed from: C */
    public String m40752C() {
        return this.acString;
    }

    /* renamed from: D */
    public String m40753D() {
        return this.hwACString;
    }

    /* renamed from: E */
    public Map<String, String> m40754E() {
        return this.tag;
    }

    /* renamed from: F */
    public Integer m40755F() {
        return this.preloadTriggerMode;
    }

    /* renamed from: G */
    public String m40756G() {
        return this.tptEngineVer;
    }

    /* renamed from: H */
    public Map<String, Integer> m40757H() {
        return this.unsptTptTags;
    }

    /* renamed from: I */
    public List<String> m40758I() {
        return this.blkTptIds;
    }

    /* renamed from: J */
    public List<String> m40759J() {
        return this.audIds;
    }

    /* renamed from: K */
    public Integer m40760K() {
        return this.requestType;
    }

    /* renamed from: L */
    public Integer m40761L() {
        return this.suptRelateRank;
    }

    /* renamed from: M */
    public Integer m40762M() {
        return this.tMax;
    }

    /* renamed from: N */
    public int[] m40763N() {
        return this.sdkMonitors;
    }

    /* renamed from: O */
    public List<String> m40764O() {
        return this.cur;
    }

    @Override // com.huawei.openalliance.p169ad.beans.base.ReqBean
    /* renamed from: b */
    public String mo39256b() {
        return this.acdReqUri;
    }

    /* renamed from: c */
    public void m40781c(Integer num) {
        this.hwDspNpa = num;
    }

    /* renamed from: d */
    public int m40784d() {
        return this.parentCtrlUser;
    }

    /* renamed from: e */
    public int m40788e() {
        return this.scrnReadStat;
    }

    /* renamed from: f */
    public String m40792f() {
        return this.version;
    }

    /* renamed from: g */
    public String m40795g() {
        return this.sdkversion;
    }

    /* renamed from: h */
    public App m40798h() {
        return this.app;
    }

    /* renamed from: i */
    public Device m40801i() {
        return this.device;
    }

    /* renamed from: j */
    public Network m40802j() {
        return this.network;
    }

    /* renamed from: k */
    public List<AdSlot30> m40803k() {
        return this.multislot;
    }

    /* renamed from: l */
    public List<String> m40804l() {
        return this.cachecontentid;
    }

    /* renamed from: m */
    public List<String> m40805m() {
        return this.removedContentId;
    }

    /* renamed from: n */
    public String m40806n() {
        return this.ppsStore;
    }

    /* renamed from: o */
    public int m40807o() {
        return this.reqPurpose;
    }

    /* renamed from: p */
    public int m40808p() {
        return this.pdToOther;
    }

    /* renamed from: q */
    public List<String> m40809q() {
        return this.cachedTemplates;
    }

    /* renamed from: r */
    public String m40810r() {
        return this.clientAdRequestId;
    }

    /* renamed from: s */
    public Integer m40811s() {
        return this.nonPersonalizedAd;
    }

    /* renamed from: t */
    public Integer m40812t() {
        return this.isQueryUseEnabled;
    }

    /* renamed from: u */
    public Integer m40813u() {
        return this.hwDspNpa;
    }

    /* renamed from: v */
    public Integer m40814v() {
        return this.thirdDspNpa;
    }

    /* renamed from: w */
    public Options m40815w() {
        return this.opts;
    }

    /* renamed from: x */
    public Location m40816x() {
        return this.loc;
    }

    /* renamed from: y */
    public SearchTerm m40817y() {
        return this.searchTerm;
    }

    /* renamed from: z */
    public SearchInfo m40818z() {
        return this.searchInfo;
    }

    public AdContentReq(final Context context, List<AdSlot30> list, List<String> list2, List<String> list3, List<String> list4, AdSlotParam adSlotParam, boolean z10) {
        int iM40647d = adSlotParam.m40647d();
        int iM40653f = adSlotParam.m40653f();
        int iM40650e = adSlotParam.m40650e();
        AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.beans.server.AdContentReq.1
            @Override // java.lang.Runnable
            public void run() {
                AdContentReq.this.appRunningStatus = Integer.valueOf(!AbstractC7811dd.m48338n(context) ? 1 : 0);
            }
        });
        this.multislot = list;
        C7095ek c7095ekM42934a = C7095ek.m42934a(context);
        App appM42941b = c7095ekM42934a.m42941b();
        this.app = appM42941b == null ? new App(context) : appM42941b;
        Network networkM42936a = c7095ekM42934a.m42936a();
        if (networkM42936a != null) {
            this.network = networkM42936a;
            c7095ekM42934a.m42940a((Network) null);
        } else {
            this.network = new Network(context, z10);
        }
        Device deviceM42942c = c7095ekM42934a.m42942c();
        if (deviceM42942c != null) {
            this.device = deviceM42942c;
            deviceM42942c.m40107a(context, iM40650e, iM40653f, iM40647d);
        } else {
            this.device = new Device(context, iM40650e, iM40653f, iM40647d, z10);
        }
        this.device.m40124b(C7489mx.m45884a().m45891a(context));
        this.cachecontentid = list2;
        this.cacheSloganId = list3;
        this.cachedTemplates = list4;
        this.parentCtrlUser = AbstractC7807d.m48254q(context);
        this.scrnReadStat = AbstractC7807d.m48256s(context);
        AbstractC7807d.m48192C(context);
    }

    @Override // com.huawei.openalliance.p169ad.beans.base.ReqBean
    /* renamed from: a */
    public String mo39254a() {
        return this.acdRealm;
    }

    /* renamed from: b */
    public void m40776b(int i10) {
        this.pdToOther = i10;
    }

    /* renamed from: c */
    public void m40782c(String str) {
        this.consent = AbstractC7806cz.m48170d(str);
    }

    /* renamed from: d */
    public void m40785d(Integer num) {
        this.thirdDspNpa = num;
    }

    /* renamed from: e */
    public void m40789e(Integer num) {
        this.preloadTriggerMode = num;
    }

    /* renamed from: f */
    public void m40793f(Integer num) {
        this.requestType = num;
    }

    /* renamed from: g */
    public void m40796g(Integer num) {
        this.suptRelateRank = num;
    }

    /* renamed from: h */
    public void m40799h(Integer num) {
        this.tMax = num;
    }

    /* renamed from: a */
    public void m40765a(int i10) {
        this.reqPurpose = i10;
    }

    /* renamed from: b */
    public void m40777b(Integer num) {
        this.isQueryUseEnabled = num;
    }

    /* renamed from: c */
    public void m40783c(List<String> list) {
        this.blkTptIds = list;
    }

    /* renamed from: d */
    public void m40786d(String str) {
        this.acString = str;
    }

    /* renamed from: e */
    public void m40790e(String str) {
        this.hwACString = str;
    }

    /* renamed from: f */
    public void m40794f(String str) {
        this.tptEngineVer = str;
    }

    /* renamed from: g */
    public void m40797g(String str) {
        this.acdReqUri = str;
    }

    /* renamed from: h */
    public void m40800h(String str) {
        this.acdRealm = str;
    }

    /* renamed from: a */
    public void m40766a(SearchInfo searchInfo) {
        this.searchInfo = searchInfo;
    }

    /* renamed from: b */
    public void m40778b(String str) {
        this.clientAdRequestId = str;
    }

    /* renamed from: d */
    public void m40787d(List<String> list) {
        this.audIds = list;
    }

    /* renamed from: e */
    public void m40791e(List<String> list) {
        this.cur = list;
    }

    /* renamed from: a */
    public void m40767a(App app) {
        this.app = app;
    }

    /* renamed from: b */
    public void m40779b(List<String> list) {
        this.removedContentId = list;
    }

    /* renamed from: a */
    public void m40768a(Location location) {
        this.loc = location;
    }

    /* renamed from: b */
    public void m40780b(Map<String, Integer> map) {
        this.unsptTptTags = map;
    }

    /* renamed from: a */
    public void m40769a(Options options) {
        this.opts = options;
    }

    /* renamed from: a */
    public void m40770a(SearchTerm searchTerm) {
        this.searchTerm = searchTerm;
    }

    /* renamed from: a */
    public void m40771a(Integer num) {
        this.nonPersonalizedAd = num;
    }

    /* renamed from: a */
    public void m40772a(String str) {
        this.ppsStore = str;
    }

    /* renamed from: a */
    public void m40773a(List<AdSlot30> list) {
        this.multislot = list;
    }

    /* renamed from: a */
    public void m40774a(Map<String, String> map) {
        this.tag = map;
    }

    /* renamed from: a */
    public void m40775a(int[] iArr) {
        this.sdkMonitors = iArr;
    }
}
