package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.huawei.hms.ads.jsb.inner.data.H5Ad;
import com.huawei.openalliance.p169ad.C7564oy;
import com.huawei.openalliance.p169ad.beans.parameter.RequestOptions;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import com.huawei.openalliance.p169ad.inter.C7309g;
import com.huawei.openalliance.p169ad.inter.data.C7301d;
import com.huawei.openalliance.p169ad.inter.data.InterfaceC7299b;
import com.huawei.openalliance.p169ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7758be;
import com.huawei.openalliance.p169ad.utils.AbstractC7760bg;
import com.huawei.openalliance.p169ad.utils.AbstractC7796cp;
import com.huawei.openalliance.p169ad.utils.C7765bl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.huawei.openalliance.ad.u */
/* loaded from: classes8.dex */
public class C7705u extends AbstractC7206i {

    /* renamed from: com.huawei.openalliance.ad.u$a */
    public static class a extends C7116f implements C7564oy.a {
        public a(Context context, RemoteCallResultCallback<String> remoteCallResultCallback, String str) {
            super(context, remoteCallResultCallback, str);
        }

        /* renamed from: a */
        private List<H5Ad> m47338a(List<ContentRecord> list, List<InterfaceC7299b> list2, byte[] bArr) {
            ArrayList arrayList = new ArrayList(4);
            if (list2 != null && list2.size() > 0) {
                for (InterfaceC7299b interfaceC7299b : list2) {
                    if (interfaceC7299b != null && !interfaceC7299b.isExpired() && interfaceC7299b.mo44679c_()) {
                        C7301d c7301d = (C7301d) interfaceC7299b;
                        arrayList.add(new H5Ad(c7301d));
                        ContentRecord contentRecordM46653a = C7563ox.m46653a(c7301d);
                        contentRecordM46653a.m41857a(bArr);
                        list.add(contentRecordM46653a);
                    }
                }
            }
            return arrayList;
        }

        /* renamed from: b */
        private Map<String, List<H5Ad>> m47340b(Map<String, List<InterfaceC7299b>> map) {
            if (C7765bl.m47802a(map)) {
                return null;
            }
            HashMap map2 = new HashMap();
            for (Map.Entry<String, List<InterfaceC7299b>> entry : map.entrySet()) {
                if (!AbstractC7760bg.m47767a(entry.getValue())) {
                    ArrayList arrayList = new ArrayList();
                    Iterator<InterfaceC7299b> it = entry.getValue().iterator();
                    while (it.hasNext()) {
                        arrayList.add(new H5Ad((C7301d) it.next()));
                    }
                    map2.put(entry.getKey(), arrayList);
                }
            }
            return map2;
        }

        public a(Context context, String str, RemoteCallResultCallback<String> remoteCallResultCallback, String str2) {
            super(context, str, remoteCallResultCallback, str2);
        }

        /* renamed from: a */
        private List<InterfaceC7299b> m47339a(Map<String, List<InterfaceC7299b>> map, String str) {
            if (C7765bl.m47802a(map)) {
                return null;
            }
            if (!TextUtils.isEmpty(str)) {
                return map.get(str);
            }
            ArrayList arrayList = new ArrayList();
            Iterator<Map.Entry<String, List<InterfaceC7299b>>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                arrayList.addAll(it.next().getValue());
            }
            return arrayList;
        }

        @Override // com.huawei.openalliance.p169ad.C7564oy.a
        /* renamed from: a */
        public void mo45001a(int i10) {
            AbstractC7326j.m45216a(this.f32770g, this.f32766c, AbstractC6970bn.m41050a(i10), null, true);
        }

        @Override // com.huawei.openalliance.p169ad.C7564oy.a
        /* renamed from: a */
        public void mo45013a(Map<String, List<InterfaceC7299b>> map) {
            if (map == null || map.size() == 0) {
                AbstractC7185ho.m43820b("JsbReqInterstitialAd", " ads map is empty.");
                AbstractC7326j.m45216a(this.f32770g, this.f32766c, 1005, null, true);
                return;
            }
            List<InterfaceC7299b> listM47339a = m47339a(map, this.f32764a);
            ArrayList arrayList = new ArrayList();
            List<H5Ad> listM47338a = m47338a(arrayList, listM47339a, AbstractC7796cp.m48089b(this.f32765b));
            this.f32767d.mo43112a(arrayList);
            String strM47742b = this.f32771h ? AbstractC7758be.m47742b(new Pair(12, m47340b(map))) : AbstractC7758be.m47742b(listM47338a);
            if (listM47338a.size() > 0) {
                AbstractC7326j.m45216a(this.f32770g, this.f32766c, 1000, strM47742b, true);
            } else {
                AbstractC7185ho.m43820b("JsbReqInterstitialAd", " ads map is empty.");
                AbstractC7326j.m45216a(this.f32770g, this.f32766c, 1005, null, true);
            }
        }
    }

    public C7705u() {
        super("pps.interstitial.request");
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7206i
    /* renamed from: b */
    public void mo43898b(Context context, String str, RemoteCallResultCallback<String> remoteCallResultCallback) {
        JSONObject jSONObject = new JSONObject(str);
        String strOptString = jSONObject.optString("slotId");
        String strOptString2 = jSONObject.optString(JsbMapKeyNames.H5_MEDIA_CONTENT);
        RequestOptions requestOptionsM45226c = m45226c(context, str);
        C7309g c7309g = new C7309g(context);
        c7309g.m45011a(strOptString);
        c7309g.m45010a((Integer) 3);
        c7309g.m45015b(m43899c(strOptString2));
        c7309g.m45002a(m45230g(str));
        c7309g.m45009a(new a(context, strOptString, remoteCallResultCallback, this.f34112a));
        c7309g.m45004a(requestOptionsM45226c);
    }
}
