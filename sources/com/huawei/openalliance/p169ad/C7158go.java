package com.huawei.openalliance.p169ad;

import android.content.Context;
import com.huawei.openalliance.p169ad.analysis.C6923d;
import com.huawei.openalliance.p169ad.constant.ApiNames;
import com.huawei.openalliance.p169ad.inter.data.IPlacementAd;
import com.huawei.openalliance.p169ad.inter.listeners.PlacementAdListener;
import com.huawei.openalliance.p169ad.utils.AbstractC7817dj;
import com.huawei.openalliance.p169ad.utils.C7785ce;
import com.huawei.openalliance.p169ad.utils.C7841t;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.huawei.openalliance.ad.go */
/* loaded from: classes8.dex */
public class C7158go implements InterfaceC7155gl {

    /* renamed from: f */
    private boolean f32944f;

    /* renamed from: g */
    private Context f32945g;

    /* renamed from: h */
    private PlacementAdListener f32946h;

    /* renamed from: i */
    private String f32947i;

    /* renamed from: j */
    private long f32948j;

    /* renamed from: k */
    private long f32949k;

    /* renamed from: a */
    private boolean f32939a = false;

    /* renamed from: b */
    private boolean f32940b = false;

    /* renamed from: d */
    private Map<String, List<IPlacementAd>> f32942d = new HashMap(4);

    /* renamed from: e */
    private Map<String, List<IPlacementAd>> f32943e = new HashMap(4);

    /* renamed from: c */
    private C7076dt f32941c = C7076dt.m42678h();

    public C7158go(Context context, PlacementAdListener placementAdListener, boolean z10) {
        this.f32945g = context;
        this.f32946h = placementAdListener;
        this.f32944f = z10;
        this.f32942d.clear();
        this.f32943e.clear();
    }

    /* renamed from: a */
    public void m43601a() {
        C7076dt c7076dt = this.f32941c;
        if (c7076dt != null) {
            c7076dt.m42686i();
        }
    }

    /* renamed from: b */
    public void m43605b() {
        if (this.f32944f || this.f32940b) {
            m43606b(C7076dt.m42678h().m42570g());
            this.f32940b = false;
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7155gl
    /* renamed from: a */
    public void mo43590a(int i10) {
        AbstractC7185ho.m43820b("PlacementAd", "onAdFailed, errorCode:" + i10);
        PlacementAdListener placementAdListener = this.f32946h;
        if (placementAdListener != null) {
            placementAdListener.onAdFailed(i10);
        }
    }

    /* renamed from: b */
    public void m43606b(int i10) {
        AbstractC7185ho.m43820b("PlacementAd", "startCache:" + i10);
        C7076dt c7076dt = this.f32941c;
        if (c7076dt != null) {
            c7076dt.m42556a(Integer.valueOf(i10));
            this.f32941c.m42687j();
        }
        if (this.f32942d.isEmpty() && this.f32943e.isEmpty()) {
            this.f32940b = true;
            return;
        }
        C7841t.m48505a(this.f32942d, i10, false, 1);
        if (C7785ce.m47890a(this.f32945g).m47896c()) {
            C7841t.m48505a(this.f32943e, i10, true, 1);
        } else {
            AbstractC7185ho.m43823c("PlacementAd", "in background, do not preload contents");
        }
    }

    /* renamed from: a */
    public void m43602a(long j10) {
        this.f32948j = j10;
    }

    /* renamed from: a */
    public void m43603a(String str) {
        this.f32947i = str;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7155gl
    /* renamed from: a */
    public void mo43591a(Map map) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onAdsLoaded, size:");
        sb2.append(map != null ? Integer.valueOf(map.size()) : null);
        sb2.append(", listener:");
        sb2.append(this.f32946h);
        AbstractC7185ho.m43820b("PlacementAd", sb2.toString());
        PlacementAdListener placementAdListener = this.f32946h;
        if (placementAdListener != null) {
            placementAdListener.onAdsLoaded(map);
        }
    }

    /* renamed from: a */
    public void m43604a(final Map<String, List<IPlacementAd>> map, final Map<String, List<IPlacementAd>> map2) {
        this.f32942d.clear();
        if (map != null) {
            this.f32942d.putAll(map);
        }
        this.f32943e.clear();
        if (map2 != null) {
            this.f32943e.putAll(map2);
        }
        if (this.f32946h != null) {
            AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.go.1
                @Override // java.lang.Runnable
                public void run() {
                    int i10;
                    C7158go c7158go;
                    Map map3;
                    C7158go.this.f32949k = System.currentTimeMillis();
                    if (C7158go.this.f32939a) {
                        c7158go = C7158go.this;
                        map3 = map2;
                    } else {
                        Map map4 = map;
                        if (map4 == null || map4.isEmpty()) {
                            C7158go.this.mo43590a(800);
                            i10 = 800;
                            C6923d.m39134a(C7158go.this.f32945g, ApiNames.API_LOAD_AD, C7158go.this.f32947i, 1, 60, C7158go.this.f32948j, C7158go.this.f32949k, i10);
                        }
                        c7158go = C7158go.this;
                        map3 = map;
                    }
                    c7158go.mo43591a(map3);
                    i10 = 200;
                    C6923d.m39134a(C7158go.this.f32945g, ApiNames.API_LOAD_AD, C7158go.this.f32947i, 1, 60, C7158go.this.f32948j, C7158go.this.f32949k, i10);
                }
            });
        }
    }
}
