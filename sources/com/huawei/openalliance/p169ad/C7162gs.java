package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.ads.VideoConfiguration;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.inter.data.AdLandingPageData;
import com.huawei.openalliance.p169ad.inter.data.ImageInfo;
import com.huawei.openalliance.p169ad.inter.data.VideoInfo;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7731ae;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.C7752az;
import java.io.File;
import java.util.ArrayList;
import java.util.UUID;

/* renamed from: com.huawei.openalliance.ad.gs */
/* loaded from: classes8.dex */
public class C7162gs implements InterfaceC7163gt {

    /* renamed from: c */
    private static ArrayList<Integer> f32963c = new ArrayList<Integer>() { // from class: com.huawei.openalliance.ad.gs.1
        {
            add(3);
            add(1);
        }
    };

    /* renamed from: d */
    private static ArrayList<Integer> f32964d = new ArrayList<Integer>() { // from class: com.huawei.openalliance.ad.gs.2
        {
            add(12);
        }
    };

    /* renamed from: a */
    protected AdLandingPageData f32965a;

    /* renamed from: b */
    protected ContentRecord f32966b;

    /* renamed from: e */
    private final String f32967e;

    /* renamed from: f */
    private final String f32968f;

    /* renamed from: g */
    private C7169gz f32969g;

    /* renamed from: h */
    private boolean f32970h;

    /* renamed from: i */
    private boolean f32971i;

    /* renamed from: j */
    private boolean f32972j;

    /* renamed from: k */
    private VideoInfo f32973k;

    /* renamed from: l */
    private ImageInfo f32974l;

    /* renamed from: m */
    private long f32975m;

    /* renamed from: n */
    private boolean f32976n;

    /* renamed from: o */
    private boolean f32977o;

    /* renamed from: p */
    private int f32978p;

    /* renamed from: q */
    private String f32979q;

    /* renamed from: r */
    private C7022dk f32980r;

    /* renamed from: s */
    private Context f32981s;

    /* renamed from: t */
    private VideoConfiguration f32982t;

    public C7162gs(Context context, AdLandingPageData adLandingPageData, C7169gz c7169gz) {
        String string = UUID.randomUUID().toString();
        this.f32967e = string;
        this.f32970h = false;
        this.f32971i = false;
        this.f32972j = false;
        this.f32975m = -1L;
        this.f32976n = false;
        this.f32977o = false;
        this.f32978p = -1;
        this.f32965a = adLandingPageData;
        this.f32969g = c7169gz;
        this.f32980r = C7019dh.m41937a(context, Constants.NORMAL_CACHE);
        AdLandingPageData adLandingPageData2 = this.f32965a;
        if (adLandingPageData2 != null) {
            this.f32978p = adLandingPageData2.getAdType();
            this.f32965a.m44300j(string);
        }
        if (c7169gz != null) {
            this.f32979q = c7169gz.m43667f();
            this.f32982t = c7169gz.m43670i();
        }
        this.f32981s = context;
        this.f32968f = null;
    }

    /* renamed from: a */
    public ContentRecord m43619a() {
        return this.f32966b;
    }

    /* renamed from: b */
    public String m43620b() {
        AdLandingPageData adLandingPageData = this.f32965a;
        if (adLandingPageData != null) {
            return adLandingPageData.getContentId();
        }
        return null;
    }

    /* renamed from: c */
    public AdLandingPageData m43621c() {
        return this.f32965a;
    }

    /* renamed from: d */
    public int m43622d() {
        AdLandingPageData adLandingPageData = this.f32965a;
        if (adLandingPageData != null) {
            return adLandingPageData.m44317s();
        }
        return 0;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7163gt
    /* renamed from: e */
    public String mo43623e() {
        C7169gz c7169gz = this.f32969g;
        return c7169gz != null ? c7169gz.m43668g() : String.valueOf(AbstractC7741ao.m47566c());
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C7162gs)) {
            return false;
        }
        if (obj.hashCode() == hashCode()) {
            return true;
        }
        String strM43620b = m43620b();
        if (strM43620b != null) {
            return TextUtils.equals(strM43620b, ((C7162gs) obj).m43620b());
        }
        return false;
    }

    /* renamed from: f */
    public VideoInfo m43624f() {
        if (this.f32973k == null) {
            C7169gz c7169gz = this.f32969g;
            if (c7169gz != null && c7169gz.m43651a() != null) {
                VideoInfo videoInfo = new VideoInfo(this.f32969g.m43651a());
                this.f32973k = videoInfo;
                videoInfo.m44580e("y");
                int iM43662c = this.f32969g.m43662c();
                AbstractC7185ho.m43821b("LinkedNativeAd", "obtain progress from native view %s %s", Integer.valueOf(iM43662c), this.f32969g.m43669h());
                this.f32973k.m44581e(this.f32969g.m43666e());
                this.f32973k.m44579e(iM43662c);
                this.f32973k.m44588g(this.f32969g.m43669h());
                this.f32973k.m44568b("y");
            }
            this.f32966b = AbstractC7572pf.m46743a(this.f32965a);
        }
        return this.f32973k;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7163gt
    /* renamed from: g */
    public String mo43625g() {
        AdLandingPageData adLandingPageData = this.f32965a;
        if (adLandingPageData != null) {
            return adLandingPageData.m44290f();
        }
        return null;
    }

    /* renamed from: h */
    public String m43626h() {
        C7169gz c7169gz = this.f32969g;
        if (c7169gz != null) {
            return c7169gz.m43667f();
        }
        return null;
    }

    public int hashCode() {
        String strM43620b = m43620b();
        return super.hashCode() & (strM43620b != null ? strM43620b.hashCode() : -1);
    }

    /* renamed from: i */
    public ImageInfo m43627i() {
        String strM41968c;
        C7022dk c7022dkM41937a;
        if (this.f32974l == null) {
            C7169gz c7169gz = this.f32969g;
            if (c7169gz != null) {
                this.f32974l = m43618a(c7169gz.m43659b());
            }
            ImageInfo imageInfo = this.f32974l;
            if (imageInfo != null && imageInfo.getUrl() != null) {
                String url = this.f32974l.getUrl();
                if (url.startsWith("http")) {
                    String strM47696b = C7752az.m47696b(this.f32981s, url);
                    C7022dk c7022dk = this.f32980r;
                    strM41968c = c7022dk.m41968c(c7022dk.m41970e(strM47696b));
                    if (AbstractC7806cz.m48165b(strM41968c)) {
                        c7022dkM41937a = C7019dh.m41937a(this.f32981s, Constants.TPLATE_CACHE);
                        this.f32980r = c7022dkM41937a;
                        url = c7022dkM41937a.m41970e(strM47696b);
                        strM41968c = c7022dkM41937a.m41968c(url);
                    }
                    this.f32974l.m44479c(strM41968c);
                } else {
                    if (C7022dk.m41954i(url)) {
                        strM41968c = this.f32980r.m41968c(url);
                        if (!AbstractC7731ae.m47464d(new File(strM41968c))) {
                            c7022dkM41937a = C7019dh.m41937a(this.f32981s, Constants.TPLATE_CACHE);
                            this.f32980r = c7022dkM41937a;
                            strM41968c = c7022dkM41937a.m41968c(url);
                        }
                    } else {
                        strM41968c = null;
                    }
                    this.f32974l.m44479c(strM41968c);
                }
            }
        }
        return this.f32974l;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7163gt
    /* renamed from: j */
    public int mo43628j() {
        return this.f32978p;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7163gt
    /* renamed from: k */
    public boolean mo43629k() {
        int iMo43628j = mo43628j();
        if (!f32963c.contains(Integer.valueOf(iMo43628j)) || m43624f() == null) {
            return false;
        }
        if (iMo43628j != 1) {
            return true;
        }
        return f32964d.contains(Integer.valueOf(m43622d()));
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7163gt
    /* renamed from: l */
    public boolean mo43630l() {
        return (mo43628j() == 3 && "1".equals(this.f32966b.m41483ae()) && "4".equals(this.f32966b.m41568i().m40273J())) ? false : true;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7163gt
    /* renamed from: m */
    public VideoConfiguration mo43631m() {
        return this.f32982t;
    }

    /* renamed from: a */
    public static ImageInfo m43618a(com.huawei.openalliance.p169ad.beans.metadata.ImageInfo imageInfo) {
        if (imageInfo != null) {
            return new ImageInfo(imageInfo);
        }
        return null;
    }
}
