package com.huawei.openalliance.p169ad.beans.metadata;

import com.huawei.openalliance.p169ad.annotations.DataKeep;
import com.huawei.openalliance.p169ad.annotations.InterfaceC6929a;
import com.huawei.openalliance.p169ad.annotations.InterfaceC6932d;
import com.huawei.openalliance.p169ad.beans.metadata.p170v3.CachedContent;
import java.util.List;

@DataKeep
/* loaded from: classes8.dex */
public class AdSlot30 {

    @InterfaceC6932d(m39225a = "h")
    private Integer adHeight;

    @InterfaceC6932d(m39225a = "w")
    private Integer adWidth;
    private int adtype;
    private Integer amttpv;

    @InterfaceC6929a
    private Float bidFloor;
    private String bidFloorCur;
    private List<String> bpkgName;
    private Integer bsrSet;
    private List<CachedContent> cachedContents;
    private List<String> detailedCreativeTypeList;
    private int fcFlag;
    private int height;

    @InterfaceC6929a
    private List<ImpEX> impEXs;
    private Integer isSmart;
    private Integer linkedMode;
    private Integer maxCount;
    private Integer orientation;
    private String slotid;
    private Integer splashStartMode;
    private Integer splashType;
    private String templateEnginVer;
    private List<String> templateIds;
    private int test;
    private Integer totalDuration;
    private int width;

    public AdSlot30() {
        this.test = 0;
        this.adtype = 1;
        this.fcFlag = 0;
    }

    /* renamed from: a */
    public String m39502a() {
        return this.slotid;
    }

    /* renamed from: b */
    public int m39508b() {
        return this.width;
    }

    /* renamed from: c */
    public int m39512c() {
        return this.height;
    }

    /* renamed from: d */
    public int m39515d() {
        return this.adtype;
    }

    /* renamed from: e */
    public int m39518e() {
        return this.test;
    }

    /* renamed from: f */
    public Integer m39521f() {
        return this.maxCount;
    }

    /* renamed from: g */
    public Integer m39523g() {
        return this.amttpv;
    }

    /* renamed from: h */
    public Integer m39525h() {
        return this.linkedMode;
    }

    /* renamed from: i */
    public List<ImpEX> m39527i() {
        return this.impEXs;
    }

    /* renamed from: j */
    public Integer m39529j() {
        return this.totalDuration;
    }

    /* renamed from: k */
    public Integer m39531k() {
        return this.splashType;
    }

    /* renamed from: l */
    public Integer m39533l() {
        return this.splashStartMode;
    }

    /* renamed from: m */
    public Integer m39534m() {
        return this.orientation;
    }

    /* renamed from: n */
    public Integer m39535n() {
        return this.bsrSet;
    }

    /* renamed from: o */
    public List<String> m39536o() {
        return this.detailedCreativeTypeList;
    }

    /* renamed from: p */
    public Integer m39537p() {
        return this.isSmart;
    }

    /* renamed from: q */
    public Integer m39538q() {
        return this.adWidth;
    }

    /* renamed from: r */
    public Integer m39539r() {
        return this.adHeight;
    }

    /* renamed from: s */
    public String m39540s() {
        return this.templateEnginVer;
    }

    /* renamed from: t */
    public List<String> m39541t() {
        return this.templateIds;
    }

    /* renamed from: u */
    public List<CachedContent> m39542u() {
        return this.cachedContents;
    }

    /* renamed from: v */
    public int m39543v() {
        return this.fcFlag;
    }

    /* renamed from: w */
    public Float m39544w() {
        return this.bidFloor;
    }

    /* renamed from: x */
    public String m39545x() {
        return this.bidFloorCur;
    }

    /* renamed from: y */
    public List<String> m39546y() {
        return this.bpkgName;
    }

    public AdSlot30(String str, int i10, int i11, int i12, boolean z10) {
        this.fcFlag = 0;
        this.slotid = str;
        this.width = i10;
        this.height = i11;
        this.test = z10 ? 1 : 0;
        this.adtype = i12;
    }

    /* renamed from: a */
    public void m39503a(float f10) {
        this.bidFloor = Float.valueOf(f10);
    }

    /* renamed from: b */
    public void m39509b(Integer num) {
        this.amttpv = num;
    }

    /* renamed from: c */
    public void m39513c(Integer num) {
        this.linkedMode = num;
    }

    /* renamed from: d */
    public void m39516d(Integer num) {
        this.totalDuration = num;
    }

    /* renamed from: e */
    public void m39519e(Integer num) {
        this.splashType = num;
    }

    /* renamed from: f */
    public void m39522f(Integer num) {
        this.splashStartMode = num;
    }

    /* renamed from: g */
    public void m39524g(Integer num) {
        this.orientation = num;
    }

    /* renamed from: h */
    public void m39526h(Integer num) {
        this.bsrSet = num;
    }

    /* renamed from: i */
    public void m39528i(Integer num) {
        this.isSmart = num;
    }

    /* renamed from: j */
    public void m39530j(Integer num) {
        this.adWidth = num;
    }

    /* renamed from: k */
    public void m39532k(Integer num) {
        this.adHeight = num;
    }

    /* renamed from: a */
    public void m39504a(int i10) {
        this.fcFlag = i10;
    }

    /* renamed from: b */
    public void m39510b(String str) {
        this.bidFloorCur = str;
    }

    /* renamed from: c */
    public void m39514c(List<String> list) {
        this.templateIds = list;
    }

    /* renamed from: d */
    public void m39517d(List<CachedContent> list) {
        this.cachedContents = list;
    }

    /* renamed from: e */
    public void m39520e(List<String> list) {
        this.bpkgName = list;
    }

    /* renamed from: a */
    public void m39505a(Integer num) {
        this.maxCount = num;
    }

    /* renamed from: b */
    public void m39511b(List<String> list) {
        this.detailedCreativeTypeList = list;
    }

    /* renamed from: a */
    public void m39506a(String str) {
        this.templateEnginVer = str;
    }

    /* renamed from: a */
    public void m39507a(List<ImpEX> list) {
        this.impEXs = list;
    }
}
