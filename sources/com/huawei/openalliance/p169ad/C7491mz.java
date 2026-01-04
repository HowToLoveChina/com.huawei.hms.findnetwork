package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.huawei.openalliance.p169ad.beans.parameter.RequestOptions;
import com.huawei.openalliance.p169ad.constant.ErrorCode;
import com.huawei.openalliance.p169ad.inter.INativeAdLoader;
import com.huawei.openalliance.p169ad.inter.NativeAdLoader;
import com.huawei.openalliance.p169ad.inter.data.BannerSize;
import com.huawei.openalliance.p169ad.inter.data.C7302e;
import com.huawei.openalliance.p169ad.inter.data.INativeAd;
import com.huawei.openalliance.p169ad.inter.data.ImageInfo;
import com.huawei.openalliance.p169ad.inter.listeners.ContentIdListener;
import com.huawei.openalliance.p169ad.inter.listeners.NativeAdListener;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7760bg;
import com.huawei.openalliance.p169ad.utils.AbstractC7807d;
import com.huawei.openalliance.p169ad.utils.AbstractC7817dj;
import com.huawei.openalliance.p169ad.utils.AbstractC7834m;
import com.huawei.openalliance.p169ad.utils.C7752az;
import com.huawei.openalliance.p169ad.utils.C7845x;
import com.huawei.openalliance.p169ad.views.PPSBannerView;
import com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8115h;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.huawei.openalliance.ad.mz */
/* loaded from: classes8.dex */
public class C7491mz extends C7336jj<InterfaceC8115h> implements InterfaceC7528nw<InterfaceC8115h> {

    /* renamed from: d */
    private INativeAdLoader f34732d;

    /* renamed from: e */
    private Context f34733e;

    /* renamed from: f */
    private InterfaceC7615qq f34734f;

    /* renamed from: g */
    private ContentRecord f34735g;

    /* renamed from: h */
    private INativeAd f34736h;

    /* renamed from: i */
    private RequestOptions f34737i;

    /* renamed from: j */
    private String f34738j;

    /* renamed from: k */
    private Location f34739k;

    /* renamed from: l */
    private Integer f34740l;

    /* renamed from: m */
    private Integer f34741m;

    /* renamed from: n */
    private int f34742n;

    /* renamed from: com.huawei.openalliance.ad.mz$1 */
    public class AnonymousClass1 implements Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C7491mz.this.mo45320d().mo49020a(702);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.mz$2 */
    public class AnonymousClass2 implements NativeAdListener {

        /* renamed from: com.huawei.openalliance.ad.mz$2$1 */
        public class AnonymousClass1 implements Runnable {
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                C7491mz.this.m45903c();
            }
        }

        /* renamed from: com.huawei.openalliance.ad.mz$2$2 */
        public class RunnableC144682 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ int f34746a;

            public RunnableC144682(int i10) {
                i = i10;
            }

            @Override // java.lang.Runnable
            public void run() {
                C7491mz.this.mo45320d().mo49020a(i);
            }
        }

        public AnonymousClass2() {
        }

        @Override // com.huawei.openalliance.p169ad.inter.listeners.NativeAdListener
        public void onAdFailed(int i10) {
            AbstractC7185ho.m43817a("BannerPresenter", "loadAd onAdFailed");
            AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.mz.2.2

                /* renamed from: a */
                final /* synthetic */ int f34746a;

                public RunnableC144682(int i102) {
                    i = i102;
                }

                @Override // java.lang.Runnable
                public void run() {
                    C7491mz.this.mo45320d().mo49020a(i);
                }
            });
        }

        @Override // com.huawei.openalliance.p169ad.inter.listeners.NativeAdListener
        public void onAdsLoaded(Map<String, List<INativeAd>> map) throws NumberFormatException {
            AbstractC7185ho.m43817a("BannerPresenter", "loadAd onAdsLoaded");
            C7491mz c7491mz = C7491mz.this;
            c7491mz.f34736h = c7491mz.m45895a(map);
            AbstractC7834m.m48481b(new Runnable() { // from class: com.huawei.openalliance.ad.mz.2.1
                public AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    C7491mz.this.m45903c();
                }
            });
            C7491mz.this.m45900b();
        }
    }

    /* renamed from: com.huawei.openalliance.ad.mz$3 */
    public class AnonymousClass3 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ long f34748a;

        public AnonymousClass3(long j10) {
            j = j10;
        }

        @Override // java.lang.Runnable
        public void run() {
            C7491mz.this.mo45320d().mo49021a(j);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.mz$4 */
    public class AnonymousClass4 implements C7752az.a {

        /* renamed from: com.huawei.openalliance.ad.mz$4$1 */
        public class AnonymousClass1 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ Drawable f34751a;

            public AnonymousClass1(Drawable drawable) {
                drawable = drawable;
            }

            @Override // java.lang.Runnable
            public void run() {
                C7491mz.this.mo45320d().mo49022a(drawable, C7491mz.this.f34736h);
            }
        }

        public AnonymousClass4() {
        }

        @Override // com.huawei.openalliance.p169ad.utils.C7752az.a
        /* renamed from: a */
        public void mo30231a() {
            AbstractC7185ho.m43823c("BannerPresenter", "loadImage onFail");
            C7491mz.this.m45897a(ErrorCode.ERROR_CODE_OTHER);
        }

        @Override // com.huawei.openalliance.p169ad.utils.C7752az.a
        /* renamed from: a */
        public void mo30232a(Drawable drawable) {
            AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.mz.4.1

                /* renamed from: a */
                final /* synthetic */ Drawable f34751a;

                public AnonymousClass1(Drawable drawable2) {
                    drawable = drawable2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    C7491mz.this.mo45320d().mo49022a(drawable, C7491mz.this.f34736h);
                }
            });
        }
    }

    /* renamed from: com.huawei.openalliance.ad.mz$5 */
    public class AnonymousClass5 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ int f34753a;

        public AnonymousClass5(int i10) {
            i = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            C7491mz.this.mo45320d().mo49020a(i);
            if (i == 499) {
                C7491mz.this.mo45320d().mo49019a();
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.mz$a */
    public static class a implements ContentIdListener {

        /* renamed from: a */
        private final WeakReference<C7491mz> f34755a;

        /* renamed from: com.huawei.openalliance.ad.mz$a$1 */
        public class AnonymousClass1 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ List f34756a;

            public AnonymousClass1(List list) {
                list = list;
            }

            @Override // java.lang.Runnable
            public void run() {
                C7491mz c7491mz = (C7491mz) a.this.f34755a.get();
                if (c7491mz == null) {
                    AbstractC7185ho.m43823c("BannerPresenter", "onInValidContentIdsGot presenter is null");
                } else {
                    c7491mz.mo45320d().mo49023a(list);
                }
            }
        }

        public a(C7491mz c7491mz) {
            this.f34755a = new WeakReference<>(c7491mz);
        }

        @Override // com.huawei.openalliance.p169ad.inter.listeners.ContentIdListener
        /* renamed from: a */
        public void mo45026a(List<String> list) {
            AbstractC7185ho.m43820b("BannerPresenter", "loadAd onInValidContentIdsGot");
            AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.mz.a.1

                /* renamed from: a */
                final /* synthetic */ List f34756a;

                public AnonymousClass1(List list2) {
                    list = list2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    C7491mz c7491mz = (C7491mz) a.this.f34755a.get();
                    if (c7491mz == null) {
                        AbstractC7185ho.m43823c("BannerPresenter", "onInValidContentIdsGot presenter is null");
                    } else {
                        c7491mz.mo45320d().mo49023a(list);
                    }
                }
            });
        }
    }

    public C7491mz(Context context, InterfaceC8115h interfaceC8115h) {
        mo45316a((C7491mz) interfaceC8115h);
        this.f34733e = context != null ? context.getApplicationContext() : context;
    }

    /* renamed from: b */
    public void m45900b() throws NumberFormatException {
        INativeAd iNativeAd;
        long jMo43416bq;
        if (this.f34742n == 1 || (iNativeAd = this.f34736h) == null) {
            return;
        }
        String strM44816al = iNativeAd instanceof C7302e ? ((C7302e) iNativeAd).m44816al() : null;
        AbstractC7185ho.m43821b("BannerPresenter", "setBannerRefresh: %s", strM44816al);
        if (TextUtils.isEmpty(strM44816al)) {
            return;
        }
        if ("N".equalsIgnoreCase(strM44816al)) {
            jMo43416bq = 0;
        } else if ("Y".equalsIgnoreCase(strM44816al)) {
            jMo43416bq = C7124fh.m43316b(this.f34733e).mo43416bq();
        } else {
            try {
                jMo43416bq = Long.parseLong(strM44816al);
            } catch (NumberFormatException e10) {
                AbstractC7185ho.m43823c("BannerPresenter", "parseIntOrDefault exception: " + e10.getClass().getSimpleName());
                return;
            }
        }
        AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.mz.3

            /* renamed from: a */
            final /* synthetic */ long f34748a;

            public AnonymousClass3(long jMo43416bq2) {
                j = jMo43416bq2;
            }

            @Override // java.lang.Runnable
            public void run() {
                C7491mz.this.mo45320d().mo49021a(j);
            }
        });
    }

    /* renamed from: c */
    public void m45903c() {
        INativeAd iNativeAd = this.f34736h;
        if (iNativeAd == null) {
            AbstractC7185ho.m43823c("BannerPresenter", "downLoadBitmap nativeAd is null");
            m45897a(ErrorCode.ERROR_CODE_OTHER);
            return;
        }
        List<ImageInfo> imageInfos = iNativeAd.getImageInfos();
        if (AbstractC7760bg.m47767a(imageInfos)) {
            AbstractC7185ho.m43823c("BannerPresenter", "downLoadBitmap imageInfo is null");
            m45897a(ErrorCode.ERROR_CODE_OTHER);
            return;
        }
        String strM45896a = m45896a(imageInfos.get(0), System.currentTimeMillis());
        if (strM45896a != null) {
            C7752az.m47691a(this.f34733e, strM45896a, new C7752az.a() { // from class: com.huawei.openalliance.ad.mz.4

                /* renamed from: com.huawei.openalliance.ad.mz$4$1 */
                public class AnonymousClass1 implements Runnable {

                    /* renamed from: a */
                    final /* synthetic */ Drawable f34751a;

                    public AnonymousClass1(Drawable drawable2) {
                        drawable = drawable2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        C7491mz.this.mo45320d().mo49022a(drawable, C7491mz.this.f34736h);
                    }
                }

                public AnonymousClass4() {
                }

                @Override // com.huawei.openalliance.p169ad.utils.C7752az.a
                /* renamed from: a */
                public void mo30231a() {
                    AbstractC7185ho.m43823c("BannerPresenter", "loadImage onFail");
                    C7491mz.this.m45897a(ErrorCode.ERROR_CODE_OTHER);
                }

                @Override // com.huawei.openalliance.p169ad.utils.C7752az.a
                /* renamed from: a */
                public void mo30232a(Drawable drawable2) {
                    AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.mz.4.1

                        /* renamed from: a */
                        final /* synthetic */ Drawable f34751a;

                        public AnonymousClass1(Drawable drawable22) {
                            drawable = drawable22;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            C7491mz.this.mo45320d().mo49022a(drawable, C7491mz.this.f34736h);
                        }
                    });
                }
            }, this.f34735g);
        } else {
            AbstractC7185ho.m43823c("BannerPresenter", "downLoadBitmap filePath is null");
            m45897a(ErrorCode.ERROR_CODE_OTHER);
        }
    }

    /* renamed from: a */
    public INativeAd m45895a(Map<String, List<INativeAd>> map) {
        if (map == null) {
            return null;
        }
        Iterator<Map.Entry<String, List<INativeAd>>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Iterator<INativeAd> it2 = it.next().getValue().iterator();
            if (it2.hasNext()) {
                return it2.next();
            }
        }
        return null;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7528nw
    /* renamed from: b */
    public void mo45911b(Integer num) {
        this.f34741m = num;
    }

    /* renamed from: a */
    private String m45896a(ImageInfo imageInfo, long j10) {
        return new C7547oo(this.f34733e, this.f34736h).mo46365a(imageInfo, j10);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7528nw
    /* renamed from: b */
    public void mo45912b(String str) {
        this.f34738j = str;
    }

    /* renamed from: a */
    public void m45897a(int i10) {
        AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.mz.5

            /* renamed from: a */
            final /* synthetic */ int f34753a;

            public AnonymousClass5(int i102) {
                i = i102;
            }

            @Override // java.lang.Runnable
            public void run() {
                C7491mz.this.mo45320d().mo49020a(i);
                if (i == 499) {
                    C7491mz.this.mo45320d().mo49019a();
                }
            }
        });
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7528nw
    /* renamed from: a */
    public void mo45904a(Location location) {
        this.f34739k = location;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7528nw
    /* renamed from: a */
    public void mo45905a(RequestOptions requestOptions) {
        this.f34737i = requestOptions;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7528nw
    /* renamed from: a */
    public void mo45906a(C7302e c7302e) {
        this.f34736h = c7302e;
        this.f34735g = C7570pd.m46698a(c7302e);
        Context context = this.f34733e;
        this.f34734f = new C7560ou(context, new C7658sg(context, c7302e == null ? 8 : c7302e.m44632e()), this.f34735g);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7528nw
    /* renamed from: a */
    public void mo45907a(Integer num) {
        this.f34740l = num;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7528nw
    /* renamed from: a */
    public void mo45908a(String str, int i10, List<String> list, int i11) {
        if (str == null || str.isEmpty()) {
            AbstractC7185ho.m43823c("BannerPresenter", "adId is null or empty when load ad");
            AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.mz.1
                public AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    C7491mz.this.mo45320d().mo49020a(702);
                }
            });
            return;
        }
        AbstractC7185ho.m43818a("BannerPresenter", "loadAd ,adId:%s", str);
        this.f34742n = i11;
        NativeAdLoader nativeAdLoader = new NativeAdLoader(this.f34733e, new String[]{str}, i10, list);
        this.f34732d = nativeAdLoader;
        if (nativeAdLoader instanceof NativeAdLoader) {
            nativeAdLoader.setLocation(this.f34739k);
            ((NativeAdLoader) this.f34732d).m44136a(Integer.valueOf(this.f34742n));
            ((NativeAdLoader) this.f34732d).setContentBundle(this.f34738j);
        }
        this.f34732d.setAdWidth(this.f34740l);
        this.f34732d.setAdHeight(this.f34741m);
        this.f34732d.setRequestOptions(this.f34737i);
        this.f34732d.setListener(new NativeAdListener() { // from class: com.huawei.openalliance.ad.mz.2

            /* renamed from: com.huawei.openalliance.ad.mz$2$1 */
            public class AnonymousClass1 implements Runnable {
                public AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    C7491mz.this.m45903c();
                }
            }

            /* renamed from: com.huawei.openalliance.ad.mz$2$2 */
            public class RunnableC144682 implements Runnable {

                /* renamed from: a */
                final /* synthetic */ int f34746a;

                public RunnableC144682(int i102) {
                    i = i102;
                }

                @Override // java.lang.Runnable
                public void run() {
                    C7491mz.this.mo45320d().mo49020a(i);
                }
            }

            public AnonymousClass2() {
            }

            @Override // com.huawei.openalliance.p169ad.inter.listeners.NativeAdListener
            public void onAdFailed(int i102) {
                AbstractC7185ho.m43817a("BannerPresenter", "loadAd onAdFailed");
                AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.mz.2.2

                    /* renamed from: a */
                    final /* synthetic */ int f34746a;

                    public RunnableC144682(int i1022) {
                        i = i1022;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        C7491mz.this.mo45320d().mo49020a(i);
                    }
                });
            }

            @Override // com.huawei.openalliance.p169ad.inter.listeners.NativeAdListener
            public void onAdsLoaded(Map<String, List<INativeAd>> map) throws NumberFormatException {
                AbstractC7185ho.m43817a("BannerPresenter", "loadAd onAdsLoaded");
                C7491mz c7491mz = C7491mz.this;
                c7491mz.f34736h = c7491mz.m45895a(map);
                AbstractC7834m.m48481b(new Runnable() { // from class: com.huawei.openalliance.ad.mz.2.1
                    public AnonymousClass1() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        C7491mz.this.m45903c();
                    }
                });
                C7491mz.this.m45900b();
            }
        });
        this.f34732d.setContentIdListener(new a(this));
        this.f34732d.loadAds(C7845x.m48577k(this.f34733e), null, false);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7528nw
    /* renamed from: a */
    public boolean mo45909a() {
        return AbstractC7741ao.m47562b(this.f34733e);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7528nw
    /* renamed from: a */
    public boolean mo45910a(BannerSize bannerSize, float f10) {
        boolean z10 = false;
        if (!(mo45320d() instanceof PPSBannerView)) {
            return false;
        }
        PPSBannerView pPSBannerView = (PPSBannerView) mo45320d();
        Context applicationContext = pPSBannerView.getContext().getApplicationContext();
        int width = pPSBannerView.getWidth();
        int height = pPSBannerView.getHeight();
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a("BannerPresenter", "banner view width: %s, height: %s", Integer.valueOf(width), Integer.valueOf(height));
        }
        DisplayMetrics displayMetricsM48237f = AbstractC7807d.m48237f(this.f34733e);
        if (width > displayMetricsM48237f.widthPixels || height > displayMetricsM48237f.heightPixels) {
            AbstractC7185ho.m43823c("BannerPresenter", "Ad view is off screen");
            return false;
        }
        int iM44447a = bannerSize.m44447a();
        int iM44448b = bannerSize.m44448b();
        float f11 = iM44447a - width;
        float f12 = iM44447a;
        float f13 = iM44448b - height;
        float f14 = iM44448b;
        float f15 = f13 / f14;
        if (f11 / f12 < f10 && f15 < f10) {
            z10 = true;
        }
        if (!z10) {
            float fM48245j = AbstractC7807d.m48245j(applicationContext);
            if (fM48245j > 0.0f) {
                AbstractC7185ho.m43824c("BannerPresenter", "Not enough space to show ad. Needs %s×%s dp, but only has %s×%s dp", Integer.valueOf(Math.round(f12 / fM48245j)), Integer.valueOf(Math.round(f14 / fM48245j)), Integer.valueOf(Math.round(width / fM48245j)), Integer.valueOf(Math.round(height / fM48245j)));
            }
        }
        return z10;
    }
}
