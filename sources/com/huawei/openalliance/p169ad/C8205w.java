package com.huawei.openalliance.p169ad;

import android.content.Context;
import com.huawei.hms.ads.jsb.inner.data.H5Ad;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import com.huawei.openalliance.p169ad.inter.PlacementAdLoader;
import com.huawei.openalliance.p169ad.inter.data.C7304g;
import com.huawei.openalliance.p169ad.inter.data.IPlacementAd;
import com.huawei.openalliance.p169ad.inter.listeners.PlacementAdListener;
import com.huawei.openalliance.p169ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7758be;
import com.huawei.openalliance.p169ad.utils.AbstractC7796cp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.huawei.openalliance.ad.w */
/* loaded from: classes8.dex */
public class C8205w extends AbstractC7206i {

    /* renamed from: com.huawei.openalliance.ad.w$a */
    public static class a implements PlacementAdListener {

        /* renamed from: a */
        private String f38431a;

        /* renamed from: b */
        private Context f38432b;

        /* renamed from: c */
        private String f38433c;

        /* renamed from: d */
        private InterfaceC7135fs f38434d;

        /* renamed from: e */
        private RemoteCallResultCallback<String> f38435e;

        public a(Context context, String str, RemoteCallResultCallback<String> remoteCallResultCallback, String str2) {
            this.f38431a = str;
            this.f38432b = context;
            this.f38435e = remoteCallResultCallback;
            this.f38433c = str2;
            this.f38434d = C7103es.m43094a(context);
        }

        /* renamed from: a */
        private List<H5Ad> m50980a(List<IPlacementAd> list, byte[] bArr) {
            ArrayList arrayList = new ArrayList(4);
            if (list != null && list.size() > 0) {
                for (IPlacementAd iPlacementAd : list) {
                    if (iPlacementAd != null) {
                        C7304g c7304g = (C7304g) iPlacementAd;
                        arrayList.add(new H5Ad(c7304g));
                        ContentRecord contentRecordM46766a = C7575pi.m46766a(c7304g);
                        contentRecordM46766a.m41857a(bArr);
                        this.f38434d.mo43107a(contentRecordM46766a);
                    }
                }
            }
            return arrayList;
        }

        @Override // com.huawei.openalliance.p169ad.inter.listeners.PlacementAdListener
        public void onAdFailed(int i10) {
            AbstractC7326j.m45216a(this.f38435e, this.f38433c, AbstractC6970bn.m41050a(i10), null, true);
        }

        @Override // com.huawei.openalliance.p169ad.inter.listeners.PlacementAdListener
        public void onAdsLoaded(Map<String, List<IPlacementAd>> map) {
            if (map != null && map.size() > 0) {
                List<H5Ad> listM50980a = m50980a(map.get(this.f38431a), AbstractC7796cp.m48089b(this.f38432b));
                if (listM50980a.size() > 0) {
                    AbstractC7326j.m45216a(this.f38435e, this.f38433c, 1000, AbstractC7758be.m47742b(listM50980a), true);
                    return;
                }
            }
            AbstractC7185ho.m43820b("JsbReqPlacementAd", " ads map is empty.");
            AbstractC7326j.m45216a(this.f38435e, this.f38433c, 1005, null, true);
        }
    }

    public C8205w() {
        super("pps.placement.request");
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7206i
    /* renamed from: b */
    public void mo43898b(Context context, String str, RemoteCallResultCallback<String> remoteCallResultCallback) {
        JSONObject jSONObject = new JSONObject(str);
        String strOptString = jSONObject.optString("slotId");
        int iOptInt = jSONObject.optInt(JsbMapKeyNames.H5_DEVICE_TYPE, 4);
        int iOptInt2 = jSONObject.optInt("maxCount", 1);
        int iOptInt3 = jSONObject.optInt(JsbMapKeyNames.H5_PLACEMENT_REQUEST_MAX_DURATION, 300);
        PlacementAdLoader placementAdLoaderBuild = new PlacementAdLoader.Builder(context).setTest(false).setAdIds(new String[]{strOptString}).setRequestOptions(m45226c(context, str)).setDeviceType(iOptInt).m44179a((Integer) 3).setLocation(m45230g(str)).build();
        if (iOptInt3 > 0) {
            placementAdLoaderBuild.loadAds(new a(context, strOptString, remoteCallResultCallback, this.f34112a));
            return;
        }
        String str2 = this.f34112a;
        if (iOptInt2 > 0) {
            placementAdLoaderBuild.loadAds(new a(context, strOptString, remoteCallResultCallback, str2), iOptInt3);
        } else {
            placementAdLoaderBuild.loadAds(new a(context, strOptString, remoteCallResultCallback, str2), iOptInt3, iOptInt2);
        }
    }
}
