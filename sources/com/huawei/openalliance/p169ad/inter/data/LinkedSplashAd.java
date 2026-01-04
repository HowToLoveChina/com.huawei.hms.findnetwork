package com.huawei.openalliance.p169ad.inter.data;

import android.content.Context;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C7543ok;
import com.huawei.openalliance.p169ad.annotations.OuterVisible;
import com.huawei.openalliance.p169ad.inter.listeners.LinkedAdListener;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import java.util.List;

@OuterVisible
/* loaded from: classes2.dex */
public class LinkedSplashAd extends C7302e implements ILinkedSplashAd {

    /* renamed from: g */
    private ContentRecord f33628g;

    /* renamed from: h */
    private transient LinkedAdListener f33629h;

    /* renamed from: i */
    private transient IAdEvent f33630i;

    /* renamed from: j */
    private int f33631j;

    /* renamed from: k */
    private String f33632k;

    /* renamed from: l */
    private String f33633l;

    /* renamed from: m */
    private String f33634m;

    /* renamed from: n */
    private int f33635n;

    /* renamed from: o */
    private int f33636o;

    /* renamed from: p */
    private String f33637p;

    /* renamed from: q */
    private boolean f33638q = false;

    /* renamed from: A */
    public void m44482A(String str) {
        this.f33634m = str;
    }

    /* renamed from: D */
    public int m44483D() {
        return this.f33631j;
    }

    /* renamed from: E */
    public String m44484E() {
        return this.f33632k;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.C7302e
    /* renamed from: F */
    public String mo44485F() {
        return this.f33637p;
    }

    /* renamed from: G */
    public String m44486G() {
        return this.f33633l;
    }

    /* renamed from: H */
    public String m44487H() {
        return this.f33634m;
    }

    /* renamed from: I */
    public int m44488I() {
        return this.f33635n;
    }

    /* renamed from: J */
    public int m44489J() {
        return this.f33636o;
    }

    /* renamed from: K */
    public ContentRecord m44490K() {
        return this.f33628g;
    }

    /* renamed from: L */
    public List<AdvertiserInfo> m44491L() {
        ContentRecord contentRecord = this.f33628g;
        if (contentRecord == null) {
            return null;
        }
        return contentRecord.m41468aT();
    }

    /* renamed from: a */
    public void m44492a(ContentRecord contentRecord) {
        this.f33628g = contentRecord;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.C7302e
    /* renamed from: b */
    public IAdEvent mo44493b(Context context) {
        if (this.f33630i == null) {
            if (context != null) {
                this.f33630i = new C7543ok(context.getApplicationContext(), this);
            } else {
                AbstractC7185ho.m43820b("LinkedSplashAd", " context is null, ");
            }
        }
        return this.f33630i;
    }

    /* renamed from: e */
    public void m44494e(boolean z10) {
        this.f33638q = z10;
    }

    /* renamed from: g */
    public void m44495g(int i10) {
        this.f33631j = i10;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.C7302e, com.huawei.openalliance.p169ad.inter.data.INativeAd
    public List<FeedbackInfo> getFeedbackInfoList() {
        return null;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.ILinkedSplashAd
    public LinkedAdListener getListener() {
        return this.f33629h;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.ILinkedSplashAd
    public String getSoundSwitch() {
        return getVideoInfo() != null ? getVideoInfo().getSoundSwitch() : "n";
    }

    /* renamed from: h */
    public void m44496h(int i10) {
        this.f33635n = i10;
    }

    /* renamed from: i */
    public void m44497i(int i10) {
        this.f33636o = i10;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.ILinkedSplashAd
    public boolean isFromExsplash() {
        return this.f33638q;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.ILinkedSplashAd
    public void setListener(LinkedAdListener linkedAdListener) {
        this.f33629h = linkedAdListener;
    }

    /* renamed from: x */
    public void m44498x(String str) {
        this.f33632k = str;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.C7302e
    /* renamed from: y */
    public void mo44499y(String str) {
        this.f33637p = str;
    }

    /* renamed from: z */
    public void m44500z(String str) {
        this.f33633l = str;
    }
}
