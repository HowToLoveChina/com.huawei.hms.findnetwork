package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.huawei.hms.ads.jsb.inner.data.H5Ad;
import com.huawei.hms.ads.jsb.inner.data.JsbCallBackData;
import com.huawei.openalliance.p169ad.beans.inner.AdContentData;
import com.huawei.openalliance.p169ad.beans.parameter.RequestOptions;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import com.huawei.openalliance.p169ad.inter.NativeAdLoader;
import com.huawei.openalliance.p169ad.inter.data.C7302e;
import com.huawei.openalliance.p169ad.inter.data.INativeAd;
import com.huawei.openalliance.p169ad.inter.listeners.ContentIdListener;
import com.huawei.openalliance.p169ad.inter.listeners.NativeAdListener;
import com.huawei.openalliance.p169ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7758be;
import com.huawei.openalliance.p169ad.utils.AbstractC7760bg;
import com.huawei.openalliance.p169ad.utils.AbstractC7796cp;
import com.huawei.openalliance.p169ad.utils.C7765bl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.huawei.openalliance.ad.v */
/* loaded from: classes8.dex */
public class C7854v extends AbstractC7206i {

    /* renamed from: com.huawei.openalliance.ad.v$a */
    public static class a implements NativeAdListener {

        /* renamed from: a */
        private String f36225a;

        /* renamed from: b */
        private Context f36226b;

        /* renamed from: c */
        private String f36227c;

        /* renamed from: d */
        private InterfaceC7135fs f36228d;

        /* renamed from: e */
        private InterfaceC7135fs f36229e;

        /* renamed from: f */
        private RemoteCallResultCallback<String> f36230f;

        /* renamed from: g */
        private boolean f36231g;

        /* renamed from: h */
        private int f36232h;

        /* renamed from: i */
        private int f36233i;

        public a(Context context, RemoteCallResultCallback<String> remoteCallResultCallback, String str, int i10, int i11) {
            this.f36231g = false;
            this.f36232h = 3;
            this.f36233i = 2;
            this.f36226b = context;
            this.f36227c = str;
            this.f36230f = remoteCallResultCallback;
            this.f36228d = C7103es.m43094a(context);
            this.f36229e = C7104et.m43127b(context);
            this.f36231g = true;
            this.f36232h = i10;
            this.f36233i = i11;
        }

        /* renamed from: a */
        private List<INativeAd> m48629a(Map<String, List<INativeAd>> map, String str) {
            if (C7765bl.m47802a(map)) {
                return null;
            }
            if (!TextUtils.isEmpty(str)) {
                return map.get(str);
            }
            ArrayList arrayList = new ArrayList();
            Iterator<Map.Entry<String, List<INativeAd>>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                arrayList.addAll(it.next().getValue());
            }
            return arrayList;
        }

        /* renamed from: b */
        private void m48634b(Map<String, List<INativeAd>> map) {
            Object pair;
            List<INativeAd> listM48629a = m48629a(map, this.f36225a);
            ArrayList arrayList = new ArrayList();
            m48631a(listM48629a, AbstractC7796cp.m48089b(this.f36226b), arrayList);
            if (this.f36231g) {
                HashMap map2 = new HashMap();
                m48633a(map, map2);
                pair = new Pair(Integer.valueOf(this.f36232h), map2);
            } else {
                pair = arrayList;
            }
            if (arrayList.size() > 0) {
                AbstractC7326j.m45215a(this.f36230f, this.f36227c, 1000, new JsbCallBackData(pair, true, null));
            } else {
                AbstractC7185ho.m43820b("JsbReqNativeAd", " ads map is empty.");
                AbstractC7326j.m45216a(this.f36230f, this.f36227c, 1005, null, true);
            }
        }

        @Override // com.huawei.openalliance.p169ad.inter.listeners.NativeAdListener
        public void onAdFailed(int i10) {
            AbstractC7326j.m45216a(this.f36230f, this.f36227c, AbstractC6970bn.m41050a(i10), null, true);
        }

        @Override // com.huawei.openalliance.p169ad.inter.listeners.NativeAdListener
        public void onAdsLoaded(Map<String, List<INativeAd>> map) {
            if (C7765bl.m47802a(map)) {
                AbstractC7185ho.m43820b("JsbReqNativeAd", " ads map is empty.");
                AbstractC7326j.m45216a(this.f36230f, this.f36227c, 1005, null, true);
                return;
            }
            AbstractC7185ho.m43821b("JsbReqNativeAd", "onAdsLoaded, is multi slot id: %s", Boolean.valueOf(this.f36231g));
            int i10 = this.f36233i;
            if (i10 == 2) {
                m48632a(map);
            } else {
                if (i10 != 3) {
                    return;
                }
                m48634b(map);
            }
        }

        public a(Context context, String str, RemoteCallResultCallback<String> remoteCallResultCallback, String str2, int i10) {
            this.f36231g = false;
            this.f36232h = 3;
            this.f36233i = 2;
            this.f36225a = str;
            this.f36226b = context;
            this.f36230f = remoteCallResultCallback;
            this.f36227c = str2;
            this.f36228d = C7103es.m43094a(context);
            this.f36229e = C7104et.m43127b(context);
            this.f36233i = i10;
        }

        /* renamed from: a */
        private void m48630a(ContentRecord contentRecord) {
            if (contentRecord == null || TextUtils.isEmpty(contentRecord.m41588n()) || TextUtils.isEmpty(contentRecord.m41585m())) {
                return;
            }
            if (contentRecord.m41464aP() != 3) {
                if (this.f36228d.mo43100a(contentRecord.m41588n(), contentRecord.m41585m()) == null) {
                    contentRecord.m41554f(AbstractC7741ao.m47566c());
                }
                this.f36228d.mo43116b(contentRecord);
            } else {
                if (TextUtils.isEmpty(contentRecord.m41463aO())) {
                    return;
                }
                if (this.f36229e.mo43102a(contentRecord.m41588n(), contentRecord.m41463aO(), contentRecord.m41585m()) == null) {
                    contentRecord.m41554f(AbstractC7741ao.m47566c());
                    AbstractC7185ho.m43817a("JsbReqNativeAd", "insertContent");
                }
                this.f36229e.mo43121c(contentRecord);
            }
        }

        /* renamed from: a */
        private <T> void m48631a(List<INativeAd> list, byte[] bArr, List<T> list2) {
            if (AbstractC7760bg.m47767a(list)) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (INativeAd iNativeAd : list) {
                if (iNativeAd != null) {
                    C7302e c7302e = (C7302e) iNativeAd;
                    ContentRecord contentRecordM46698a = C7570pd.m46698a(c7302e);
                    contentRecordM46698a.m41857a(bArr);
                    int i10 = this.f36233i;
                    if (i10 == 3) {
                        list2.add(AdContentData.m39273a(c7302e));
                        m48630a(contentRecordM46698a);
                    } else if (i10 == 2) {
                        list2.add(new H5Ad(c7302e));
                        arrayList.add(contentRecordM46698a);
                    }
                }
            }
            if (this.f36233i == 2) {
                this.f36228d.mo43112a(arrayList);
            }
        }

        /* renamed from: a */
        private void m48632a(Map<String, List<INativeAd>> map) {
            String strM47742b;
            List<INativeAd> listM48629a = m48629a(map, this.f36225a);
            ArrayList arrayList = new ArrayList();
            m48631a(listM48629a, AbstractC7796cp.m48089b(this.f36226b), arrayList);
            if (this.f36231g) {
                HashMap map2 = new HashMap();
                m48633a(map, map2);
                strM47742b = AbstractC7758be.m47742b(new Pair(Integer.valueOf(this.f36232h), map2));
            } else {
                strM47742b = AbstractC7758be.m47742b(arrayList);
            }
            if (arrayList.size() > 0) {
                AbstractC7326j.m45215a(this.f36230f, this.f36227c, 1000, new JsbCallBackData(strM47742b, true, null));
            } else {
                AbstractC7185ho.m43820b("JsbReqNativeAd", " ads map is empty.");
                AbstractC7326j.m45216a(this.f36230f, this.f36227c, 1005, null, true);
            }
        }

        /* renamed from: a */
        private <T> void m48633a(Map<String, List<INativeAd>> map, Map<String, List<T>> map2) {
            if (C7765bl.m47802a(map)) {
                return;
            }
            for (Map.Entry<String, List<INativeAd>> entry : map.entrySet()) {
                if (!AbstractC7760bg.m47767a(entry.getValue())) {
                    List<T> arrayList = new ArrayList<>();
                    for (INativeAd iNativeAd : entry.getValue()) {
                        if (iNativeAd != null) {
                            int i10 = this.f36233i;
                            if (i10 == 3) {
                                arrayList.add(AdContentData.m39273a((C7302e) iNativeAd));
                            } else if (i10 == 2) {
                                arrayList.add(new H5Ad((C7302e) iNativeAd));
                            }
                        }
                    }
                    map2.put(entry.getKey(), arrayList);
                }
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.v$b */
    public static class b implements ContentIdListener {

        /* renamed from: a */
        private String f36234a;

        /* renamed from: b */
        private RemoteCallResultCallback<String> f36235b;

        public b(RemoteCallResultCallback<String> remoteCallResultCallback, String str) {
            this.f36235b = remoteCallResultCallback;
            this.f36234a = str;
        }

        @Override // com.huawei.openalliance.p169ad.inter.listeners.ContentIdListener
        /* renamed from: a */
        public void mo45026a(List<String> list) {
            if (list == null || list.size() <= 0) {
                return;
            }
            AbstractC7326j.m45215a(this.f36235b, this.f36234a, 1000, new JsbCallBackData(AbstractC7758be.m47742b(list), false, "native.cb.invalidcontentid"));
        }
    }

    public C7854v() {
        super("pps.native.request");
    }

    /* renamed from: a */
    private List<Integer> m48627a(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                int iOptInt = jSONArray.optInt(i10, -111111);
                if (iOptInt != -111111) {
                    arrayList.add(Integer.valueOf(iOptInt));
                }
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    private List<String> m48628b(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                String strOptString = jSONArray.optString(i10);
                if (!TextUtils.isEmpty(strOptString)) {
                    arrayList.add(strOptString);
                }
            }
        }
        return arrayList;
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7206i
    /* renamed from: b */
    public void mo43898b(Context context, String str, RemoteCallResultCallback<String> remoteCallResultCallback) {
        JSONObject jSONObject = new JSONObject(str);
        String strOptString = jSONObject.optString("slotId");
        String strOptString2 = jSONObject.optString(JsbMapKeyNames.H5_MEDIA_CONTENT);
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(JsbMapKeyNames.H5_CREATIVE_TYPES);
        int iOptInt = jSONObject.optInt(JsbMapKeyNames.JSSDK_VER, 2);
        String strOptString3 = jSONObject.optString(JsbMapKeyNames.JSSDK_VERSION);
        int iOptInt2 = jSONObject.optInt(JsbMapKeyNames.H5_SMART_BANNER, -111111);
        int iOptInt3 = jSONObject.optInt(JsbMapKeyNames.H5_PHY_WIDTH, -111111);
        int iOptInt4 = jSONObject.optInt(JsbMapKeyNames.H5_PHY_HEIGHT, -111111);
        int iOptInt5 = jSONObject.optInt(JsbMapKeyNames.H5_BANNER_REFRESH_FLAG, -111111);
        int iOptInt6 = jSONObject.optInt("adType", 3);
        int iOptInt7 = jSONObject.optInt(JsbMapKeyNames.H5_DEVICE_TYPE, 4);
        int iOptInt8 = jSONObject.optInt("maxCount", 0);
        boolean zOptBoolean = jSONObject.optBoolean(JsbMapKeyNames.H5_RETURN_VIDEOAD, true);
        boolean zOptBoolean2 = jSONObject.optBoolean("directCacheVideo", false);
        boolean zOptBoolean3 = jSONObject.optBoolean(JsbMapKeyNames.SUPPORT_TEMPLATE_AD, false);
        RequestOptions requestOptionsM45226c = m45226c(context, str);
        NativeAdLoader nativeAdLoader = new NativeAdLoader(context, new String[]{strOptString}, iOptInt6, m48628b(jSONObject.optJSONArray(JsbMapKeyNames.H5_AD_CACHEIDS)));
        nativeAdLoader.setRequestOptions(requestOptionsM45226c);
        nativeAdLoader.setContentBundle(m43899c(strOptString2));
        nativeAdLoader.setDetailedCreativeType(m48627a(jSONArrayOptJSONArray));
        nativeAdLoader.enableDirectReturnVideoAd(zOptBoolean);
        nativeAdLoader.enableDirectCacheVideo(zOptBoolean2);
        if (iOptInt5 != -111111) {
            nativeAdLoader.m44136a(Integer.valueOf(iOptInt5));
        }
        if (iOptInt3 != -111111) {
            nativeAdLoader.setAdWidth(Integer.valueOf(iOptInt3));
        }
        if (iOptInt4 != -111111) {
            nativeAdLoader.setAdHeight(Integer.valueOf(iOptInt4));
        }
        if (iOptInt2 != -111111) {
            nativeAdLoader.setIsSmart(Integer.valueOf(iOptInt2));
        }
        if (iOptInt8 > 0) {
            nativeAdLoader.setMaxAdNumbers(iOptInt8);
        }
        nativeAdLoader.setContentIdListener(new b(remoteCallResultCallback, this.f34112a));
        nativeAdLoader.setListener(new a(context, strOptString, remoteCallResultCallback, this.f34112a, iOptInt));
        nativeAdLoader.m44138b((Integer) 3);
        nativeAdLoader.setLocation(m45230g(str));
        nativeAdLoader.setSupportTptAd(zOptBoolean3);
        nativeAdLoader.setJssdkVersion(strOptString3);
        nativeAdLoader.loadAds(iOptInt7, false);
    }
}
