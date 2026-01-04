package com.huawei.openalliance.p169ad;

import com.huawei.openalliance.p169ad.magazine.inter.MagLockAdContent;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;

/* renamed from: com.huawei.openalliance.ad.hw */
/* loaded from: classes8.dex */
public class C7202hw implements MagLockAdContent {

    /* renamed from: a */
    private String f33135a;

    /* renamed from: b */
    private long f33136b;

    /* renamed from: c */
    private String f33137c;

    /* renamed from: d */
    private String f33138d;

    /* renamed from: e */
    private String f33139e;

    /* renamed from: f */
    private String f33140f;

    /* renamed from: g */
    private long f33141g;

    /* renamed from: h */
    private String f33142h;

    /* renamed from: i */
    private String f33143i;

    /* renamed from: j */
    private String f33144j;

    /* renamed from: k */
    private String f33145k;

    /* renamed from: l */
    private String f33146l;

    /* renamed from: m */
    private String f33147m;

    /* renamed from: n */
    private String f33148n;

    /* renamed from: o */
    private String f33149o;

    /* renamed from: p */
    private String f33150p;

    /* renamed from: q */
    private String f33151q;

    /* renamed from: r */
    private String f33152r;

    /* renamed from: s */
    private String f33153s;

    /* renamed from: t */
    private String f33154t;

    /* renamed from: u */
    private int f33155u;

    /* renamed from: v */
    private int f33156v = 0;

    /* renamed from: a */
    public void m43883a(int i10) {
        this.f33156v = i10;
    }

    /* renamed from: b */
    public void m43885b(int i10) {
        this.f33155u = i10;
    }

    /* renamed from: c */
    public void m43887c(String str) {
        this.f33149o = str;
    }

    /* renamed from: d */
    public void m43888d(String str) {
        this.f33150p = str;
    }

    /* renamed from: e */
    public void m43889e(String str) {
        this.f33151q = str;
    }

    /* renamed from: f */
    public void m43890f(String str) {
        this.f33152r = str;
    }

    /* renamed from: g */
    public void m43891g(String str) {
        this.f33153s = str;
    }

    @Override // com.huawei.openalliance.p169ad.magazine.inter.MagLockAdContent
    public String getAdLabelStr() {
        return this.f33154t;
    }

    @Override // com.huawei.openalliance.p169ad.magazine.inter.MagLockAdContent
    public String getAdSign() {
        return this.f33153s;
    }

    @Override // com.huawei.openalliance.p169ad.magazine.inter.MagLockAdContent
    public int getAppType() {
        return this.f33156v;
    }

    @Override // com.huawei.openalliance.p169ad.magazine.inter.MagLockAdContent
    public String getContentId() {
        return this.f33135a;
    }

    @Override // com.huawei.openalliance.p169ad.magazine.inter.MagLockAdContent
    public String getContentUrl() {
        return this.f33149o;
    }

    @Override // com.huawei.openalliance.p169ad.magazine.inter.MagLockAdContent
    public String getDeeplinkUrl() {
        return this.f33150p;
    }

    @Override // com.huawei.openalliance.p169ad.magazine.inter.MagLockAdContent
    public String getDescription() {
        return this.f33147m;
    }

    @Override // com.huawei.openalliance.p169ad.magazine.inter.MagLockAdContent
    public long getEndTime() {
        return this.f33136b;
    }

    @Override // com.huawei.openalliance.p169ad.magazine.inter.MagLockAdContent
    public long getFileSize() {
        return this.f33141g;
    }

    @Override // com.huawei.openalliance.p169ad.magazine.inter.MagLockAdContent
    public String getImagePath() {
        return this.f33145k;
    }

    @Override // com.huawei.openalliance.p169ad.magazine.inter.MagLockAdContent
    public int getInteractionType() {
        return this.f33155u;
    }

    @Override // com.huawei.openalliance.p169ad.magazine.inter.MagLockAdContent
    public String getLabel() {
        return this.f33148n;
    }

    @Override // com.huawei.openalliance.p169ad.magazine.inter.MagLockAdContent
    public String getMetaData() {
        return this.f33138d;
    }

    @Override // com.huawei.openalliance.p169ad.magazine.inter.MagLockAdContent
    public String getMonitor() {
        return this.f33144j;
    }

    @Override // com.huawei.openalliance.p169ad.magazine.inter.MagLockAdContent
    public String getParamFromServer() {
        return this.f33137c;
    }

    @Override // com.huawei.openalliance.p169ad.magazine.inter.MagLockAdContent
    public String getPreviewSha256() {
        return this.f33143i;
    }

    @Override // com.huawei.openalliance.p169ad.magazine.inter.MagLockAdContent
    public String getPreviewUrl() {
        return this.f33142h;
    }

    @Override // com.huawei.openalliance.p169ad.magazine.inter.MagLockAdContent
    public String getSha256() {
        return this.f33140f;
    }

    @Override // com.huawei.openalliance.p169ad.magazine.inter.MagLockAdContent
    public String getTargetAppName() {
        return this.f33152r;
    }

    @Override // com.huawei.openalliance.p169ad.magazine.inter.MagLockAdContent
    public String getTargetPkgName() {
        return this.f33151q;
    }

    @Override // com.huawei.openalliance.p169ad.magazine.inter.MagLockAdContent
    public String getTitle() {
        return this.f33146l;
    }

    @Override // com.huawei.openalliance.p169ad.magazine.inter.MagLockAdContent
    public String getUrl() {
        return this.f33139e;
    }

    /* renamed from: h */
    public void m43892h(String str) {
        this.f33154t = str;
    }

    @Override // com.huawei.openalliance.p169ad.magazine.inter.MagLockAdContent
    public void setContentId(String str) {
        this.f33135a = str;
    }

    @Override // com.huawei.openalliance.p169ad.magazine.inter.MagLockAdContent
    public void setDescription(String str) {
        this.f33147m = str;
    }

    @Override // com.huawei.openalliance.p169ad.magazine.inter.MagLockAdContent
    public void setEndTime(long j10) {
        this.f33136b = j10;
    }

    @Override // com.huawei.openalliance.p169ad.magazine.inter.MagLockAdContent
    public void setFileSize(long j10) {
        this.f33141g = j10;
    }

    @Override // com.huawei.openalliance.p169ad.magazine.inter.MagLockAdContent
    public void setMetaData(String str) {
        this.f33138d = str;
    }

    @Override // com.huawei.openalliance.p169ad.magazine.inter.MagLockAdContent
    public void setMonitor(String str) {
        this.f33144j = str;
    }

    @Override // com.huawei.openalliance.p169ad.magazine.inter.MagLockAdContent
    public void setParamFromServer(String str) {
        this.f33137c = str;
    }

    @Override // com.huawei.openalliance.p169ad.magazine.inter.MagLockAdContent
    public void setPreviewSha256(String str) {
        this.f33143i = str;
    }

    @Override // com.huawei.openalliance.p169ad.magazine.inter.MagLockAdContent
    public void setPreviewUrl(String str) {
        this.f33142h = str;
    }

    @Override // com.huawei.openalliance.p169ad.magazine.inter.MagLockAdContent
    public void setSha256(String str) {
        this.f33140f = str;
    }

    @Override // com.huawei.openalliance.p169ad.magazine.inter.MagLockAdContent
    public void setTitle(String str) {
        this.f33146l = str;
    }

    @Override // com.huawei.openalliance.p169ad.magazine.inter.MagLockAdContent
    public void setUrl(String str) {
        this.f33139e = str;
    }

    public String toString() {
        return "MagLockAdContentImpl [contentId=" + this.f33135a + ", endTime=" + this.f33136b + ", url=" + AbstractC7806cz.m48174f(this.f33139e) + ", sha256=" + AbstractC7806cz.m48176g(this.f33140f) + ", previewSha256=" + AbstractC7806cz.m48176g(this.f33143i) + ", fileSize=" + this.f33141g + ", previewUrl=" + AbstractC7806cz.m48176g(this.f33142h) + ", appType=" + this.f33156v + ", interactionType=" + this.f33155u + "]";
    }

    /* renamed from: a */
    public void m43884a(String str) {
        this.f33145k = str;
    }

    /* renamed from: b */
    public void m43886b(String str) {
        this.f33148n = str;
    }
}
