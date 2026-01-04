package com.huawei.openalliance.p169ad.beans.server;

import com.huawei.openalliance.p169ad.annotations.DataKeep;
import com.huawei.openalliance.p169ad.annotations.InterfaceC6929a;
import com.huawei.openalliance.p169ad.annotations.InterfaceC6932d;
import com.huawei.openalliance.p169ad.annotations.InterfaceC6934f;
import com.huawei.openalliance.p169ad.beans.base.RspBean;
import com.huawei.openalliance.p169ad.beans.metadata.Ad30;
import com.huawei.openalliance.p169ad.beans.metadata.AdTypeEvent;
import com.huawei.openalliance.p169ad.beans.metadata.Precontent;
import com.huawei.openalliance.p169ad.beans.metadata.Template;
import com.huawei.openalliance.p169ad.beans.parameter.AdSlotParam;
import com.huawei.openalliance.p169ad.beans.parameter.RequestOptions;
import java.util.List;
import java.util.Map;

@DataKeep
/* loaded from: classes8.dex */
public class AdContentRsp extends RspBean {

    @InterfaceC6934f
    private long adFilterDuration;

    @InterfaceC6934f
    private String appCountry;

    @InterfaceC6934f
    private String appLanguage;
    private String cost;

    @Deprecated
    private int dsp1cost;

    @Deprecated
    private int dspcost;

    @InterfaceC6934f
    private Map<String, Integer> filterResultMap;
    private List<String> invalidSloganId;
    private List<String> invalidcontentid;
    private List<Ad30> multiad;
    private List<AdTypeEvent> noReportAdTypeEventList;

    @InterfaceC6929a
    private String ppsStore;
    private List<Precontent> premulticontent;

    @InterfaceC6934f
    private String realAppPkgName;
    private String reason;

    @InterfaceC6932d(m39225a = "clientAdRequestId")
    private String requestId;
    private List<Template> templates;
    private List<String> todayNoShowContentid;
    private String trackVersion;
    private int retcode = -1;
    private int totalCacheSize = 800;
    private int adPreloadInterval = 0;

    @InterfaceC6934f
    private int requestType = 0;

    /* renamed from: a */
    public int m40819a() {
        return this.retcode;
    }

    /* renamed from: b */
    public String m40826b() {
        return this.reason;
    }

    /* renamed from: c */
    public List<Ad30> m40830c() {
        return this.multiad;
    }

    /* renamed from: d */
    public List<String> m40834d() {
        return this.invalidcontentid;
    }

    /* renamed from: e */
    public List<String> m40838e() {
        return this.todayNoShowContentid;
    }

    /* renamed from: f */
    public List<Precontent> m40842f() {
        return this.premulticontent;
    }

    /* renamed from: g */
    public String m40845g() {
        return this.ppsStore;
    }

    /* renamed from: h */
    public List<AdTypeEvent> m40847h() {
        return this.noReportAdTypeEventList;
    }

    /* renamed from: i */
    public List<Template> m40849i() {
        return this.templates;
    }

    /* renamed from: j */
    public int m40850j() {
        return this.adPreloadInterval;
    }

    /* renamed from: k */
    public String m40851k() {
        return this.requestId;
    }

    /* renamed from: l */
    public String m40852l() {
        return this.trackVersion;
    }

    /* renamed from: m */
    public int m40853m() {
        int i10 = this.dspcost;
        if (i10 > 0) {
            return i10;
        }
        return 0;
    }

    /* renamed from: n */
    public int m40854n() {
        int i10 = this.dsp1cost;
        if (i10 > 0) {
            return i10;
        }
        return 0;
    }

    /* renamed from: o */
    public int m40855o() {
        return this.requestType;
    }

    /* renamed from: p */
    public AdContentRsp m40856p() {
        AdContentRsp adContentRsp = new AdContentRsp();
        adContentRsp.retcode = this.retcode;
        adContentRsp.reason = this.reason;
        adContentRsp.multiad = this.multiad;
        adContentRsp.invalidcontentid = this.invalidcontentid;
        adContentRsp.invalidSloganId = this.invalidSloganId;
        adContentRsp.todayNoShowContentid = this.todayNoShowContentid;
        adContentRsp.premulticontent = this.premulticontent;
        adContentRsp.ppsStore = this.ppsStore;
        adContentRsp.templates = this.templates;
        adContentRsp.totalCacheSize = this.totalCacheSize;
        adContentRsp.noReportAdTypeEventList = this.noReportAdTypeEventList;
        adContentRsp.adPreloadInterval = this.adPreloadInterval;
        adContentRsp.requestId = this.requestId;
        adContentRsp.dspcost = this.dspcost;
        adContentRsp.dsp1cost = this.dsp1cost;
        adContentRsp.requestType = this.requestType;
        adContentRsp.cost = this.cost;
        adContentRsp.trackVersion = this.trackVersion;
        return adContentRsp;
    }

    /* renamed from: q */
    public String m40857q() {
        return this.appLanguage;
    }

    /* renamed from: r */
    public String m40858r() {
        return this.appCountry;
    }

    /* renamed from: s */
    public String m40859s() {
        return this.cost;
    }

    /* renamed from: t */
    public Map<String, Integer> m40860t() {
        return this.filterResultMap;
    }

    /* renamed from: u */
    public long m40861u() {
        return this.adFilterDuration;
    }

    /* renamed from: v */
    public String m40862v() {
        return this.realAppPkgName;
    }

    /* renamed from: a */
    public void m40820a(int i10) {
        this.retcode = i10;
    }

    /* renamed from: b */
    public void m40827b(int i10) {
        this.totalCacheSize = i10;
    }

    /* renamed from: c */
    public void m40831c(int i10) {
        this.adPreloadInterval = i10;
    }

    /* renamed from: d */
    public void m40835d(int i10) {
        this.dspcost = i10;
    }

    /* renamed from: e */
    public void m40839e(int i10) {
        this.dsp1cost = i10;
    }

    /* renamed from: f */
    public void m40843f(int i10) {
        this.requestType = i10;
    }

    /* renamed from: g */
    public void m40846g(String str) {
        this.cost = str;
    }

    /* renamed from: h */
    public void m40848h(String str) {
        this.realAppPkgName = str;
    }

    /* renamed from: a */
    public void m40821a(long j10) {
        this.adFilterDuration = j10;
    }

    /* renamed from: b */
    public void m40828b(String str) {
        this.ppsStore = str;
    }

    /* renamed from: c */
    public void m40832c(String str) {
        this.requestId = str;
    }

    /* renamed from: d */
    public void m40836d(String str) {
        this.trackVersion = str;
    }

    /* renamed from: e */
    public void m40840e(String str) {
        this.appLanguage = str;
    }

    /* renamed from: f */
    public void m40844f(String str) {
        this.appCountry = str;
    }

    /* renamed from: a */
    public void m40822a(AdSlotParam adSlotParam) {
        RequestOptions requestOptionsM40659l;
        if (adSlotParam == null || (requestOptionsM40659l = adSlotParam.m40659l()) == null) {
            return;
        }
        m40840e(requestOptionsM40659l.getAppLang());
        m40844f(requestOptionsM40659l.getAppCountry());
    }

    /* renamed from: b */
    public void m40829b(List<String> list) {
        this.invalidcontentid = list;
    }

    /* renamed from: c */
    public void m40833c(List<String> list) {
        this.todayNoShowContentid = list;
    }

    /* renamed from: d */
    public void m40837d(List<Precontent> list) {
        this.premulticontent = list;
    }

    /* renamed from: e */
    public void m40841e(List<AdTypeEvent> list) {
        this.noReportAdTypeEventList = list;
    }

    /* renamed from: a */
    public void m40823a(String str) {
        this.reason = str;
    }

    /* renamed from: a */
    public void m40824a(List<Ad30> list) {
        this.multiad = list;
    }

    /* renamed from: a */
    public void m40825a(Map<String, Integer> map) {
        this.filterResultMap = map;
    }
}
