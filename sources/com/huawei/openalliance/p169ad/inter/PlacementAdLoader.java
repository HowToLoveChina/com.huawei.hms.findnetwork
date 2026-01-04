package com.huawei.openalliance.p169ad.inter;

import android.content.Context;
import android.location.Location;
import android.text.TextUtils;
import android.util.Pair;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.AbstractC7548op;
import com.huawei.openalliance.p169ad.AbstractC7573pg;
import com.huawei.openalliance.p169ad.C6982bz;
import com.huawei.openalliance.p169ad.C7076dt;
import com.huawei.openalliance.p169ad.C7095ek;
import com.huawei.openalliance.p169ad.C7124fh;
import com.huawei.openalliance.p169ad.C7544ol;
import com.huawei.openalliance.p169ad.C7560ou;
import com.huawei.openalliance.p169ad.C7662sk;
import com.huawei.openalliance.p169ad.InterfaceC7622qx;
import com.huawei.openalliance.p169ad.analysis.C6923d;
import com.huawei.openalliance.p169ad.annotations.OuterVisible;
import com.huawei.openalliance.p169ad.beans.metadata.DelayInfo;
import com.huawei.openalliance.p169ad.beans.metadata.Video;
import com.huawei.openalliance.p169ad.beans.parameter.AdSlotParam;
import com.huawei.openalliance.p169ad.beans.parameter.RequestOptions;
import com.huawei.openalliance.p169ad.beans.server.AdContentRsp;
import com.huawei.openalliance.p169ad.constant.ErrorCode;
import com.huawei.openalliance.p169ad.inter.data.IPlacementAd;
import com.huawei.openalliance.p169ad.inter.listeners.PlacementAdListener;
import com.huawei.openalliance.p169ad.opendeviceidentifier.OAIDServiceManager;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7760bg;
import com.huawei.openalliance.p169ad.utils.AbstractC7796cp;
import com.huawei.openalliance.p169ad.utils.AbstractC7807d;
import com.huawei.openalliance.p169ad.utils.AbstractC7817dj;
import com.huawei.openalliance.p169ad.utils.AbstractC7834m;
import com.huawei.openalliance.p169ad.utils.C7762bi;
import com.huawei.openalliance.p169ad.utils.C7785ce;
import com.huawei.openalliance.p169ad.utils.C7841t;
import com.huawei.openalliance.p169ad.utils.C7845x;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@OuterVisible
/* loaded from: classes2.dex */
public class PlacementAdLoader implements IPlacementAdLoader, InterfaceC7622qx {

    /* renamed from: a */
    private EnumC7280b f33436a;

    /* renamed from: b */
    private Context f33437b;

    /* renamed from: c */
    private final String[] f33438c;

    /* renamed from: d */
    private PlacementAdListener f33439d;

    /* renamed from: e */
    private AbstractC7548op f33440e;

    /* renamed from: f */
    private String f33441f;

    /* renamed from: g */
    private Boolean f33442g;

    /* renamed from: h */
    private int f33443h;

    /* renamed from: i */
    private String f33444i;

    /* renamed from: j */
    private int f33445j;

    /* renamed from: k */
    private boolean f33446k;

    /* renamed from: l */
    private boolean f33447l;

    /* renamed from: m */
    private C7076dt f33448m;

    /* renamed from: n */
    private Map<String, List<IPlacementAd>> f33449n;

    /* renamed from: o */
    private Map<String, List<IPlacementAd>> f33450o;

    /* renamed from: p */
    private boolean f33451p;

    /* renamed from: q */
    private boolean f33452q;

    /* renamed from: r */
    private RequestOptions f33453r;

    /* renamed from: s */
    private Location f33454s;

    /* renamed from: t */
    private DelayInfo f33455t;

    /* renamed from: u */
    private String f33456u;

    /* renamed from: v */
    private int f33457v;

    /* renamed from: w */
    private int f33458w;

    /* renamed from: x */
    private Integer f33459x;

    /* renamed from: y */
    private String f33460y;

    /* renamed from: com.huawei.openalliance.ad.inter.PlacementAdLoader$1 */
    public class RunnableC72741 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ long f33461a;

        /* renamed from: b */
        final /* synthetic */ int f33462b;

        /* renamed from: c */
        final /* synthetic */ int f33463c;

        /* renamed from: d */
        final /* synthetic */ boolean f33464d;

        /* renamed from: e */
        final /* synthetic */ boolean f33465e;

        /* renamed from: f */
        final /* synthetic */ String f33466f;

        public RunnableC72741(long j10, int i10, int i11, boolean z10, boolean z11, String str) {
            j = j10;
            i = i10;
            i = i11;
            z = z10;
            z = z11;
            str = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractC7185ho.m43820b("PlacementAdLoader", "doRequestAd " + System.currentTimeMillis());
            PlacementAdLoader.this.f33455t.m40045d(System.currentTimeMillis() - j);
            Video video = new Video(i);
            int iM48229d = AbstractC7807d.m48229d(PlacementAdLoader.this.f33437b);
            int iM48233e = AbstractC7807d.m48233e(PlacementAdLoader.this.f33437b);
            boolean zM48576j = C7845x.m48576j(PlacementAdLoader.this.f33437b);
            int i10 = zM48576j ? iM48233e : iM48229d;
            if (!zM48576j) {
                iM48229d = iM48233e;
            }
            AdSlotParam.Builder builder = new AdSlotParam.Builder();
            builder.setAdIds(Arrays.asList(PlacementAdLoader.this.f33438c)).setDeviceType(i).setIsPreload(Boolean.valueOf(z)).setOrientation(1).setWidth(i10).setHeight(iM48229d).setOaid(PlacementAdLoader.this.f33441f).setTrackLimited(PlacementAdLoader.this.f33442g).setTest(z).setRequestOptions(PlacementAdLoader.this.f33453r).setLocation(PlacementAdLoader.this.f33454s).setMaxCount(PlacementAdLoader.this.f33458w).setContentBundle(PlacementAdLoader.this.f33460y).setTotalDuration(PlacementAdLoader.this.f33457v).m40708a(video);
            if (PlacementAdLoader.this.f33459x != null) {
                builder.m40710c(PlacementAdLoader.this.f33459x);
            }
            C7544ol c7544ol = new C7544ol(PlacementAdLoader.this.f33437b);
            c7544ol.mo46335a(PlacementAdLoader.this.f33455t);
            AdContentRsp adContentRspM46332a = c7544ol.m46332a(builder.build(), str);
            if (adContentRspM46332a != null) {
                PlacementAdLoader.this.f33456u = adContentRspM46332a.m40851k();
            }
            PlacementAdLoader.this.f33455t.m40070u().m39572h(System.currentTimeMillis());
            PlacementAdLoader placementAdLoader = PlacementAdLoader.this;
            placementAdLoader.f33440e = AbstractC7548op.m46366a(placementAdLoader.f33437b, PlacementAdLoader.this, z);
            PlacementAdLoader.this.f33440e.m46370a(adContentRspM46332a);
            PlacementAdLoader.this.f33436a = EnumC7280b.IDLE;
        }
    }

    /* renamed from: com.huawei.openalliance.ad.inter.PlacementAdLoader$2 */
    public class RunnableC72752 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Map f33468a;

        /* renamed from: b */
        final /* synthetic */ Map f33469b;

        public RunnableC72752(Map map, Map map2) {
            map = map;
            map = map2;
        }

        @Override // java.lang.Runnable
        public void run() {
            PlacementAdListener placementAdListener = PlacementAdLoader.this.f33439d;
            PlacementAdLoader.this.f33455t.m40035b(System.currentTimeMillis());
            int i10 = 200;
            Map<String, List<IPlacementAd>> map = null;
            if (placementAdListener != null) {
                if (PlacementAdLoader.this.f33451p) {
                    map = map;
                } else {
                    Map map2 = map;
                    if (map2 == null || map2.isEmpty()) {
                        i10 = 800;
                        placementAdListener.onAdFailed(800);
                    } else {
                        map = map;
                    }
                }
                placementAdListener.onAdsLoaded(map);
            }
            C6923d.m39129a(PlacementAdLoader.this.f33437b, i10, PlacementAdLoader.this.f33456u, 60, map, PlacementAdLoader.this.f33455t);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.inter.PlacementAdLoader$3 */
    public class RunnableC72763 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ int f33471a;

        public RunnableC72763(int i10) {
            i = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            PlacementAdListener placementAdListener = PlacementAdLoader.this.f33439d;
            PlacementAdLoader.this.f33455t.m40035b(System.currentTimeMillis());
            if (placementAdListener != null) {
                placementAdListener.onAdFailed(i);
            }
            C6923d.m39129a(PlacementAdLoader.this.f33437b, i, PlacementAdLoader.this.f33456u, 60, (Map) null, PlacementAdLoader.this.f33455t);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.inter.PlacementAdLoader$4 */
    public class RunnableC72774 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Map f33473a;

        public RunnableC72774(Map map) {
            map = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            List<ContentRecord> listM46758a = AbstractC7573pg.m46758a(map);
            byte[] bArrM48089b = AbstractC7796cp.m48089b(PlacementAdLoader.this.f33437b);
            for (ContentRecord contentRecord : listM46758a) {
                if (contentRecord != null) {
                    contentRecord.m41857a(bArrM48089b);
                    C7560ou c7560ou = new C7560ou(PlacementAdLoader.this.f33437b, C7662sk.m47225a(PlacementAdLoader.this.f33437b, contentRecord.m41552f()));
                    c7560ou.mo46590a(contentRecord);
                    c7560ou.mo46632o();
                }
            }
        }
    }

    @OuterVisible
    public static final class Builder {

        /* renamed from: a */
        private Context f33475a;

        /* renamed from: b */
        private String[] f33476b;

        /* renamed from: c */
        private int f33477c = 4;

        /* renamed from: d */
        private String f33478d;

        /* renamed from: e */
        private String f33479e;

        /* renamed from: f */
        private int f33480f;

        /* renamed from: g */
        private boolean f33481g;

        /* renamed from: h */
        private boolean f33482h;

        /* renamed from: i */
        private RequestOptions f33483i;

        /* renamed from: j */
        private Location f33484j;

        /* renamed from: k */
        private Integer f33485k;

        /* renamed from: com.huawei.openalliance.ad.inter.PlacementAdLoader$Builder$1 */
        public class RunnableC72781 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ String[] f33486a;

            public RunnableC72781(String[] strArr) {
                strArr = strArr;
            }

            @Override // java.lang.Runnable
            public void run() {
                C7124fh.m43316b(Builder.this.f33475a).mo43484r(strArr[0]);
            }
        }

        @OuterVisible
        public Builder(Context context) {
            this.f33475a = context.getApplicationContext();
        }

        /* renamed from: b */
        public int m44181b() {
            return this.f33477c;
        }

        @OuterVisible
        public PlacementAdLoader build() {
            return new PlacementAdLoader(this);
        }

        /* renamed from: d */
        public int m44183d() {
            return this.f33480f;
        }

        /* renamed from: f */
        public boolean m44185f() {
            return this.f33482h;
        }

        /* renamed from: g */
        public Context m44186g() {
            return this.f33475a;
        }

        @OuterVisible
        public Builder setAdIds(String[] strArr) {
            if (strArr != null) {
                this.f33476b = (String[]) Arrays.copyOf(strArr, strArr.length);
                m44174a(strArr);
            } else {
                this.f33476b = null;
            }
            return this;
        }

        @OuterVisible
        public Builder setAutoCache(boolean z10) {
            this.f33482h = z10;
            return this;
        }

        @OuterVisible
        public Builder setContentBundle(String str) {
            this.f33479e = str;
            return this;
        }

        @OuterVisible
        public Builder setDeviceType(int i10) {
            this.f33477c = i10;
            return this;
        }

        @OuterVisible
        public Builder setExtraInfo(String str) {
            this.f33478d = str;
            return this;
        }

        @OuterVisible
        public Builder setLocation(Location location) {
            this.f33484j = location;
            return this;
        }

        @OuterVisible
        public Builder setMaxLength(int i10) {
            this.f33480f = i10;
            return this;
        }

        @OuterVisible
        public Builder setRequestOptions(RequestOptions requestOptions) {
            this.f33483i = requestOptions;
            return this;
        }

        @OuterVisible
        public Builder setTest(boolean z10) {
            this.f33481g = z10;
            return this;
        }

        /* renamed from: a */
        public Builder m44179a(Integer num) {
            this.f33485k = num;
            return this;
        }

        /* renamed from: c */
        public String m44182c() {
            return this.f33478d;
        }

        /* renamed from: e */
        public boolean m44184e() {
            return this.f33481g;
        }

        /* renamed from: a */
        private void m44174a(String[] strArr) {
            if (AbstractC7760bg.m47769a(strArr)) {
                return;
            }
            AbstractC7834m.m48479a(new Runnable() { // from class: com.huawei.openalliance.ad.inter.PlacementAdLoader.Builder.1

                /* renamed from: a */
                final /* synthetic */ String[] f33486a;

                public RunnableC72781(String[] strArr2) {
                    strArr = strArr2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    C7124fh.m43316b(Builder.this.f33475a).mo43484r(strArr[0]);
                }
            });
        }

        /* renamed from: a */
        public String[] m44180a() {
            String[] strArr = this.f33476b;
            return strArr != null ? (String[]) Arrays.copyOf(strArr, strArr.length) : new String[0];
        }
    }

    /* renamed from: com.huawei.openalliance.ad.inter.PlacementAdLoader$a */
    public class C7279a extends OAIDServiceManager.OaidResultCallback {

        /* renamed from: b */
        private final boolean f33489b;

        public C7279a(boolean z10) {
            this.f33489b = z10;
        }

        @Override // com.huawei.openalliance.ad.opendeviceidentifier.OAIDServiceManager.OaidResultCallback
        /* renamed from: a */
        public void mo44091a() {
            AbstractC7185ho.m43820b("PlacementAdLoader", "onOaidAcquireFailed " + System.currentTimeMillis());
            PlacementAdLoader placementAdLoader = PlacementAdLoader.this;
            placementAdLoader.m44144a(placementAdLoader.f33443h, this.f33489b, PlacementAdLoader.this.f33444i, PlacementAdLoader.this.f33445j, PlacementAdLoader.this.f33446k);
        }

        @Override // com.huawei.openalliance.ad.opendeviceidentifier.OAIDServiceManager.OaidResultCallback
        /* renamed from: b */
        public int mo44093b() {
            return 60;
        }

        @Override // com.huawei.openalliance.ad.opendeviceidentifier.OAIDServiceManager.OaidResultCallback
        /* renamed from: a */
        public void mo44092a(String str, boolean z10) {
            AbstractC7185ho.m43820b("PlacementAdLoader", "onOaidAcquired " + System.currentTimeMillis());
            PlacementAdLoader.this.m44153b(str);
            PlacementAdLoader.this.m44147a(Boolean.valueOf(z10));
            PlacementAdLoader placementAdLoader = PlacementAdLoader.this;
            placementAdLoader.m44144a(placementAdLoader.f33443h, this.f33489b, PlacementAdLoader.this.f33444i, PlacementAdLoader.this.f33445j, PlacementAdLoader.this.f33446k);
            AbstractC7807d.m48211a(PlacementAdLoader.this.f33437b, str, z10);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.inter.PlacementAdLoader$b */
    public enum EnumC7280b {
        IDLE,
        LOADING
    }

    private PlacementAdLoader(Builder builder) {
        this.f33436a = EnumC7280b.IDLE;
        this.f33449n = new HashMap(4);
        this.f33450o = new HashMap(4);
        this.f33451p = false;
        this.f33452q = false;
        this.f33455t = new DelayInfo();
        if (builder == null || builder.m44186g() == null || !AbstractC7741ao.m47562b(builder.m44186g())) {
            this.f33438c = new String[0];
            return;
        }
        this.f33437b = builder.m44186g();
        String[] strArrM44180a = builder.m44180a();
        if (AbstractC7760bg.m47769a(strArrM44180a)) {
            this.f33438c = new String[0];
        } else {
            String[] strArr = new String[strArrM44180a.length];
            this.f33438c = strArr;
            System.arraycopy(strArrM44180a, 0, strArr, 0, strArrM44180a.length);
        }
        this.f33443h = builder.m44181b();
        this.f33444i = builder.m44182c();
        this.f33445j = builder.m44183d();
        this.f33446k = builder.m44184e();
        this.f33447l = builder.m44185f();
        this.f33448m = C7076dt.m42678h();
        this.f33454s = builder.f33484j;
        this.f33453r = builder.f33483i;
        this.f33459x = builder.f33485k;
        this.f33460y = builder.f33479e;
    }

    @Override // com.huawei.openalliance.p169ad.inter.IPlacementAdLoader
    public void loadAds(PlacementAdListener placementAdListener) {
        loadAds(placementAdListener, 300, 1);
    }

    @Override // com.huawei.openalliance.p169ad.inter.IPlacementAdLoader
    public void preLoadAds() {
        m44143a(300, 1);
    }

    @Override // com.huawei.openalliance.p169ad.inter.IPlacementAdLoader
    public void startCache(int i10) {
        AbstractC7185ho.m43820b("PlacementAdLoader", "startCache:" + i10);
        C7076dt c7076dt = this.f33448m;
        if (c7076dt != null) {
            c7076dt.m42556a(Integer.valueOf(i10));
            this.f33448m.m42687j();
        }
        if (this.f33449n.isEmpty() && this.f33450o.isEmpty()) {
            this.f33452q = true;
            return;
        }
        C7841t.m48505a(this.f33449n, i10, false, 0);
        if (C7785ce.m47890a(this.f33437b).m47896c()) {
            C7841t.m48505a(this.f33450o, i10, true, 0);
        } else {
            AbstractC7185ho.m43823c("PlacementAdLoader", "in background, do not preload contents");
        }
    }

    @Override // com.huawei.openalliance.p169ad.inter.IPlacementAdLoader
    public void stopCache() {
        C7076dt c7076dt = this.f33448m;
        if (c7076dt != null) {
            c7076dt.m42686i();
        }
    }

    public /* synthetic */ PlacementAdLoader(Builder builder, RunnableC72741 runnableC72741) {
        this(builder);
    }

    @Override // com.huawei.openalliance.p169ad.inter.IPlacementAdLoader
    public void loadAds(PlacementAdListener placementAdListener, int i10) {
        loadAds(placementAdListener, i10, 0);
    }

    /* renamed from: b */
    public void m44153b(String str) {
        this.f33441f = str;
    }

    @Override // com.huawei.openalliance.p169ad.inter.IPlacementAdLoader
    public void loadAds(PlacementAdListener placementAdListener, int i10, int i11) {
        this.f33439d = placementAdListener;
        m44149a(false, i10, i11);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7622qx
    /* renamed from: a */
    public void mo44171a(int i10) {
        AbstractC7185ho.m43820b("PlacementAdLoader", "onAdFailed, errorCode:" + i10);
        this.f33455t.m40070u().m39574i(System.currentTimeMillis());
        if (this.f33439d != null) {
            AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.inter.PlacementAdLoader.3

                /* renamed from: a */
                final /* synthetic */ int f33471a;

                public RunnableC72763(int i102) {
                    i = i102;
                }

                @Override // java.lang.Runnable
                public void run() {
                    PlacementAdListener placementAdListener = PlacementAdLoader.this.f33439d;
                    PlacementAdLoader.this.f33455t.m40035b(System.currentTimeMillis());
                    if (placementAdListener != null) {
                        placementAdListener.onAdFailed(i);
                    }
                    C6923d.m39129a(PlacementAdLoader.this.f33437b, i, PlacementAdLoader.this.f33456u, 60, (Map) null, PlacementAdLoader.this.f33455t);
                }
            });
        }
    }

    /* renamed from: a */
    private void m44143a(int i10, int i11) {
        m44149a(true, i10, i11);
        C7785ce.m47890a(this.f33437b).m47892a(this.f33443h);
        C7785ce.m47890a(this.f33437b).m47894a(this.f33438c);
    }

    /* renamed from: a */
    public void m44144a(int i10, boolean z10, String str, int i11, boolean z11) {
        AbstractC7834m.m48480a(new Runnable() { // from class: com.huawei.openalliance.ad.inter.PlacementAdLoader.1

            /* renamed from: a */
            final /* synthetic */ long f33461a;

            /* renamed from: b */
            final /* synthetic */ int f33462b;

            /* renamed from: c */
            final /* synthetic */ int f33463c;

            /* renamed from: d */
            final /* synthetic */ boolean f33464d;

            /* renamed from: e */
            final /* synthetic */ boolean f33465e;

            /* renamed from: f */
            final /* synthetic */ String f33466f;

            public RunnableC72741(long j10, int i112, int i102, boolean z102, boolean z112, String str2) {
                j = j10;
                i = i112;
                i = i102;
                z = z102;
                z = z112;
                str = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                AbstractC7185ho.m43820b("PlacementAdLoader", "doRequestAd " + System.currentTimeMillis());
                PlacementAdLoader.this.f33455t.m40045d(System.currentTimeMillis() - j);
                Video video = new Video(i);
                int iM48229d = AbstractC7807d.m48229d(PlacementAdLoader.this.f33437b);
                int iM48233e = AbstractC7807d.m48233e(PlacementAdLoader.this.f33437b);
                boolean zM48576j = C7845x.m48576j(PlacementAdLoader.this.f33437b);
                int i102 = zM48576j ? iM48233e : iM48229d;
                if (!zM48576j) {
                    iM48229d = iM48233e;
                }
                AdSlotParam.Builder builder = new AdSlotParam.Builder();
                builder.setAdIds(Arrays.asList(PlacementAdLoader.this.f33438c)).setDeviceType(i).setIsPreload(Boolean.valueOf(z)).setOrientation(1).setWidth(i102).setHeight(iM48229d).setOaid(PlacementAdLoader.this.f33441f).setTrackLimited(PlacementAdLoader.this.f33442g).setTest(z).setRequestOptions(PlacementAdLoader.this.f33453r).setLocation(PlacementAdLoader.this.f33454s).setMaxCount(PlacementAdLoader.this.f33458w).setContentBundle(PlacementAdLoader.this.f33460y).setTotalDuration(PlacementAdLoader.this.f33457v).m40708a(video);
                if (PlacementAdLoader.this.f33459x != null) {
                    builder.m40710c(PlacementAdLoader.this.f33459x);
                }
                C7544ol c7544ol = new C7544ol(PlacementAdLoader.this.f33437b);
                c7544ol.mo46335a(PlacementAdLoader.this.f33455t);
                AdContentRsp adContentRspM46332a = c7544ol.m46332a(builder.build(), str);
                if (adContentRspM46332a != null) {
                    PlacementAdLoader.this.f33456u = adContentRspM46332a.m40851k();
                }
                PlacementAdLoader.this.f33455t.m40070u().m39572h(System.currentTimeMillis());
                PlacementAdLoader placementAdLoader = PlacementAdLoader.this;
                placementAdLoader.f33440e = AbstractC7548op.m46366a(placementAdLoader.f33437b, PlacementAdLoader.this, z);
                PlacementAdLoader.this.f33440e.m46370a(adContentRspM46332a);
                PlacementAdLoader.this.f33436a = EnumC7280b.IDLE;
            }
        }, AbstractC7834m.a.NETWORK, false);
    }

    /* renamed from: a */
    public void m44147a(Boolean bool) {
        this.f33442g = bool;
    }

    /* renamed from: a */
    private void m44148a(Map<String, List<IPlacementAd>> map) {
        AbstractC7834m.m48479a(new Runnable() { // from class: com.huawei.openalliance.ad.inter.PlacementAdLoader.4

            /* renamed from: a */
            final /* synthetic */ Map f33473a;

            public RunnableC72774(Map map2) {
                map = map2;
            }

            @Override // java.lang.Runnable
            public void run() {
                List<ContentRecord> listM46758a = AbstractC7573pg.m46758a(map);
                byte[] bArrM48089b = AbstractC7796cp.m48089b(PlacementAdLoader.this.f33437b);
                for (ContentRecord contentRecord : listM46758a) {
                    if (contentRecord != null) {
                        contentRecord.m41857a(bArrM48089b);
                        C7560ou c7560ou = new C7560ou(PlacementAdLoader.this.f33437b, C7662sk.m47225a(PlacementAdLoader.this.f33437b, contentRecord.m41552f()));
                        c7560ou.mo46590a(contentRecord);
                        c7560ou.mo46632o();
                    }
                }
            }
        });
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7622qx
    /* renamed from: a */
    public void mo44172a(Map<String, List<IPlacementAd>> map, Map<String, List<IPlacementAd>> map2) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onAdsLoaded, size:");
        sb2.append(map == null ? 0 : map.size());
        AbstractC7185ho.m43820b("PlacementAdLoader", sb2.toString());
        this.f33455t.m40070u().m39574i(System.currentTimeMillis());
        m44148a(map);
        this.f33449n.clear();
        if (map != null) {
            this.f33449n.putAll(map);
        }
        this.f33450o.clear();
        if (map2 != null) {
            this.f33450o.putAll(map2);
        }
        if (this.f33439d != null) {
            AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.inter.PlacementAdLoader.2

                /* renamed from: a */
                final /* synthetic */ Map f33468a;

                /* renamed from: b */
                final /* synthetic */ Map f33469b;

                public RunnableC72752(Map map22, Map map3) {
                    map = map22;
                    map = map3;
                }

                @Override // java.lang.Runnable
                public void run() {
                    PlacementAdListener placementAdListener = PlacementAdLoader.this.f33439d;
                    PlacementAdLoader.this.f33455t.m40035b(System.currentTimeMillis());
                    int i10 = 200;
                    Map<String, List<IPlacementAd>> map3 = null;
                    if (placementAdListener != null) {
                        if (PlacementAdLoader.this.f33451p) {
                            map3 = map;
                        } else {
                            Map map22 = map;
                            if (map22 == null || map22.isEmpty()) {
                                i10 = 800;
                                placementAdListener.onAdFailed(800);
                            } else {
                                map3 = map;
                            }
                        }
                        placementAdListener.onAdsLoaded(map3);
                    }
                    C6923d.m39129a(PlacementAdLoader.this.f33437b, i10, PlacementAdLoader.this.f33456u, 60, map3, PlacementAdLoader.this.f33455t);
                }
            });
        }
        if (this.f33447l || this.f33452q) {
            startCache(C7076dt.m42678h().m42570g());
            this.f33452q = false;
        }
    }

    /* renamed from: a */
    private void m44149a(boolean z10, int i10, int i11) {
        this.f33455t.m40028a(System.currentTimeMillis());
        AbstractC7185ho.m43820b("PlacementAdLoader", "loadAds");
        this.f33451p = z10;
        this.f33457v = i10;
        this.f33458w = i11;
        this.f33449n.clear();
        this.f33450o.clear();
        if (!AbstractC7741ao.m47562b(this.f33437b)) {
            AbstractC7185ho.m43823c("PlacementAdLoader", "api level too low");
            mo44171a(1001);
            return;
        }
        if (!m44150a(this.f33444i)) {
            AbstractC7185ho.m43823c("PlacementAdLoader", "extra info is invalid");
            mo44171a(ErrorCode.ERROR_PLACEMENT_INVALID_PARAM);
            return;
        }
        EnumC7280b enumC7280b = EnumC7280b.LOADING;
        if (enumC7280b == this.f33436a) {
            AbstractC7185ho.m43820b("PlacementAdLoader", "waiting for request finish");
            mo44171a(ErrorCode.ERROR_PLACEMENT_AD_LOADING);
            return;
        }
        String[] strArr = this.f33438c;
        if (strArr == null || strArr.length == 0) {
            AbstractC7185ho.m43823c("PlacementAdLoader", "empty ad ids");
            mo44171a(ErrorCode.ERROR_PLACEMENT_EMPTY_AD_IDS);
            return;
        }
        if (i10 <= 0) {
            AbstractC7185ho.m43823c("PlacementAdLoader", "invalid totalDuration.");
            mo44171a(ErrorCode.ERROR_PLACEMENT_INVALID_PARAM);
            return;
        }
        if (i11 < 0) {
            AbstractC7185ho.m43823c("PlacementAdLoader", "invalid maxCount");
            mo44171a(ErrorCode.ERROR_PLACEMENT_INVALID_PARAM);
            return;
        }
        C7762bi.m47788b(this.f33437b, this.f33453r);
        C7095ek.m42934a(this.f33437b).m42944e();
        this.f33436a = enumC7280b;
        Pair<String, Boolean> pairM48217b = AbstractC7807d.m48217b(this.f33437b, true);
        if (pairM48217b == null && C6982bz.m41158h(this.f33437b)) {
            AbstractC7185ho.m43820b("PlacementAdLoader", "start to request oaid " + System.currentTimeMillis());
            OAIDServiceManager.getInstance(this.f33437b).requireOaid(new C7279a(z10));
            return;
        }
        if (pairM48217b != null) {
            AbstractC7185ho.m43820b("PlacementAdLoader", "use cached oaid " + System.currentTimeMillis());
            m44153b((String) pairM48217b.first);
            m44147a((Boolean) pairM48217b.second);
        }
        m44144a(this.f33443h, z10, this.f33444i, this.f33445j, this.f33446k);
    }

    /* renamed from: a */
    private boolean m44150a(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        try {
            new JSONObject(str);
            return true;
        } catch (JSONException unused) {
            AbstractC7185ho.m43823c("PlacementAdLoader", "extra info is not json string");
            return false;
        }
    }
}
