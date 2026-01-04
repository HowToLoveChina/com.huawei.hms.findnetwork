package com.huawei.openalliance.p169ad.inter.data;

import android.content.Context;
import com.huawei.openalliance.p169ad.C7575pi;
import com.huawei.openalliance.p169ad.constant.MimeType;
import com.huawei.openalliance.p169ad.utils.AbstractC7760bg;
import com.huawei.openalliance.p169ad.utils.C7780c;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.huawei.openalliance.ad.inter.data.g */
/* loaded from: classes2.dex */
public class C7304g extends AbstractC7298a implements IPlacementAd, Comparable {

    /* renamed from: B */
    private List<String> f33861B;

    /* renamed from: C */
    private String f33862C;

    /* renamed from: D */
    private String f33863D;

    /* renamed from: E */
    private String f33864E;

    /* renamed from: h */
    private String f33866h;

    /* renamed from: i */
    private int f33867i;

    /* renamed from: j */
    private String f33868j;

    /* renamed from: k */
    private String f33869k;

    /* renamed from: l */
    private List<Integer> f33870l;

    /* renamed from: m */
    private String f33871m;

    /* renamed from: n */
    private String f33872n;

    /* renamed from: o */
    private int f33873o;

    /* renamed from: p */
    private String f33874p;

    /* renamed from: q */
    private long f33875q;

    /* renamed from: r */
    private int f33876r;

    /* renamed from: s */
    private String f33877s;

    /* renamed from: t */
    private String f33878t;

    /* renamed from: u */
    private AppInfo f33879u;

    /* renamed from: v */
    private PlacementMediaFile f33880v;

    /* renamed from: x */
    private int f33882x;

    /* renamed from: z */
    private String f33884z;

    /* renamed from: g */
    private boolean f33865g = false;

    /* renamed from: w */
    private List<PlacementMediaFile> f33881w = new ArrayList(4);

    /* renamed from: y */
    private boolean f33883y = false;

    /* renamed from: A */
    private boolean f33860A = false;

    /* renamed from: A */
    public void m44868A(String str) {
        this.f33878t = str;
    }

    /* renamed from: B */
    public void m44869B(String str) {
        this.f33869k = str;
    }

    /* renamed from: C */
    public void m44870C(String str) {
        this.f33871m = str;
    }

    /* renamed from: D */
    public List<PlacementMediaFile> m44871D() {
        return this.f33881w;
    }

    /* renamed from: E */
    public String m44873E() {
        return this.f33884z;
    }

    /* renamed from: F */
    public void m44875F(String str) {
        this.f33866h = str;
    }

    /* renamed from: G */
    public List<String> m44877G() {
        return this.f33861B;
    }

    /* renamed from: H */
    public String m44879H() {
        return this.f33866h;
    }

    /* renamed from: I */
    public String m44881I() {
        return this.f33862C;
    }

    /* renamed from: J */
    public String m44883J() {
        return this.f33863D;
    }

    /* renamed from: K */
    public String m44884K() {
        return this.f33864E;
    }

    /* renamed from: a */
    public void m44885a(AppInfo appInfo) {
        this.f33879u = appInfo;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        return ((obj instanceof C7304g) && ((C7304g) obj).getSequence() <= getSequence()) ? 1 : -1;
    }

    /* renamed from: d */
    public void m44887d(long j10) {
        this.f33875q = j10;
    }

    /* renamed from: e */
    public void m44889e(List<PlacementMediaFile> list) {
        this.f33881w = list;
    }

    /* renamed from: f */
    public void m44891f(List<String> list) {
        this.f33861B = list;
    }

    /* renamed from: g */
    public void m44893g(int i10) {
        this.f33867i = i10;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IPlacementAd
    public int getAdinteractiontype() {
        return this.f33867i;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IPlacementAd
    public List<AdvertiserInfo> getAdvertiserInfo() {
        if (hasAdvertiserInfo()) {
            return getCompliance();
        }
        return null;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IAd
    public AppInfo getAppInfo() {
        return this.f33879u;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IPlacementAd
    public String getAppMarketAppId() {
        return this.f33878t;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IPlacementAd
    public List<Integer> getClickActionList() {
        return this.f33870l;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IAd
    public String getCtrlSwitchs() {
        return this.f33872n;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IPlacementAd
    public String getEncodedParamFromServer() {
        return this.f33868j;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IPlacementAd
    public String getEncodedeMonitors() {
        return this.f33869k;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IPlacementAd
    public int getInterActionType() {
        return this.f33867i;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IPlacementAd
    public String getJumpText(Context context) {
        return C7780c.m47859a(C7575pi.m46766a(this), context, true);
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IPlacementAd
    public String getLandWebUrl() {
        return this.f33874p;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IAd
    public long getMaxEffectiveShowTime() {
        return 0L;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IPlacementAd
    public PlacementMediaFile getMediaFile() {
        return this.f33880v;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IAd
    public int getMinEffectiveShowRatio() {
        return this.f33876r;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IAd
    public long getMinEffectiveShowTime() {
        return this.f33875q;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IPlacementAd
    public String getPromotionChannel() {
        return this.f33877s;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IPlacementAd
    public int getSequence() {
        return this.f33873o;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IPlacementAd
    public int getShowLandingPageTitleFlag() {
        return this.f33882x;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IPlacementAd
    public String getWebConfig() {
        return this.f33871m;
    }

    /* renamed from: h */
    public void m44895h(int i10) {
        this.f33876r = i10;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IPlacementAd
    public boolean hasAdvertiserInfo() {
        return !AbstractC7760bg.m47767a(getCompliance());
    }

    /* renamed from: i */
    public void m44896i(int i10) {
        this.f33882x = i10;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IPlacementAd
    public boolean isClicked() {
        return this.f33865g;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IPlacementAd
    public boolean isImageAd() {
        PlacementMediaFile placementMediaFile = this.f33880v;
        return placementMediaFile != null && (MimeType.JPEG.equals(placementMediaFile.getMime()) || MimeType.GIF.equals(this.f33880v.getMime()) || MimeType.JPG.equals(this.f33880v.getMime()) || MimeType.PNG.equals(this.f33880v.getMime()));
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IPlacementAd
    public boolean isShown() {
        return this.f33883y;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IPlacementAd
    public boolean isVideoAd() {
        PlacementMediaFile placementMediaFile = this.f33880v;
        return placementMediaFile != null && MimeType.MP4.equals(placementMediaFile.getMime());
    }

    /* renamed from: j */
    public void m44897j(int i10) {
        this.f33873o = i10;
    }

    /* renamed from: x */
    public void m44898x(String str) {
        this.f33868j = str;
    }

    /* renamed from: y */
    public void m44899y(String str) {
        this.f33874p = str;
    }

    /* renamed from: z */
    public void m44900z(String str) {
        this.f33877s = str;
    }

    /* renamed from: D */
    public void m44872D(String str) {
        this.f33872n = str;
    }

    /* renamed from: E */
    public void m44874E(String str) {
        this.f33884z = str;
    }

    /* renamed from: F */
    public boolean m44876F() {
        return this.f33860A;
    }

    /* renamed from: G */
    public void m44878G(String str) {
        this.f33862C = str;
    }

    /* renamed from: H */
    public void m44880H(String str) {
        this.f33863D = str;
    }

    /* renamed from: I */
    public void m44882I(String str) {
        this.f33864E = str;
    }

    /* renamed from: a */
    public void m44886a(PlacementMediaFile placementMediaFile) {
        this.f33880v = placementMediaFile;
    }

    /* renamed from: d */
    public void m44888d(List<Integer> list) {
        this.f33870l = list;
    }

    /* renamed from: e */
    public void m44890e(boolean z10) {
        this.f33865g = z10;
    }

    /* renamed from: f */
    public void m44892f(boolean z10) {
        this.f33883y = z10;
    }

    /* renamed from: g */
    public void m44894g(boolean z10) {
        this.f33860A = z10;
    }
}
