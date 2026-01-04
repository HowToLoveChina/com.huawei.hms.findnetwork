package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.huawei.hms.ads.jsb.inner.data.H5Ad;
import com.huawei.openalliance.p169ad.beans.parameter.RequestOptions;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import com.huawei.openalliance.p169ad.inter.RewardAdLoader;
import com.huawei.openalliance.p169ad.inter.data.C7305h;
import com.huawei.openalliance.p169ad.inter.data.IRewardAd;
import com.huawei.openalliance.p169ad.inter.listeners.RewardAdListener;
import com.huawei.openalliance.p169ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.p171db.bean.ContentTemplateRecord;
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
import org.json.JSONObject;

/* renamed from: com.huawei.openalliance.ad.x */
/* loaded from: classes8.dex */
public class C8232x extends AbstractC7206i {

    /* renamed from: com.huawei.openalliance.ad.x$a */
    public static class a extends C7116f implements RewardAdListener {
        public a(Context context, RemoteCallResultCallback<String> remoteCallResultCallback, String str) {
            super(context, remoteCallResultCallback, str);
        }

        /* renamed from: a */
        private List<H5Ad> m51336a(List<ContentRecord> list, List<IRewardAd> list2, byte[] bArr) {
            ArrayList arrayList = new ArrayList(4);
            if (list2 != null && list2.size() > 0) {
                for (IRewardAd iRewardAd : list2) {
                    if (iRewardAd != null) {
                        C7305h c7305h = (C7305h) iRewardAd;
                        arrayList.add(new H5Ad(c7305h));
                        ContentRecord contentRecordM46793a = C7580pn.m46793a(c7305h);
                        contentRecordM46793a.m41857a(bArr);
                        list.add(contentRecordM46793a);
                    }
                }
            }
            return arrayList;
        }

        @Override // com.huawei.openalliance.p169ad.inter.listeners.RewardAdListener
        public void onAdFailed(int i10) {
            AbstractC7326j.m45216a(this.f32770g, this.f32766c, AbstractC6970bn.m41050a(i10), null, true);
        }

        @Override // com.huawei.openalliance.p169ad.inter.listeners.RewardAdListener
        public void onAdsLoaded(Map<String, List<IRewardAd>> map) {
            if (map == null || map.size() == 0) {
                AbstractC7185ho.m43820b("JsbReqRewardAd", " ads map is empty.");
                AbstractC7326j.m45216a(this.f32770g, this.f32766c, 1005, null, true);
                return;
            }
            AbstractC7185ho.m43821b("JsbReqRewardAd", "onAdsLoaded, is multi slot id: %s", Boolean.valueOf(this.f32771h));
            List<IRewardAd> listM51337a = m51337a(map, this.f32764a);
            ArrayList arrayList = new ArrayList();
            List<H5Ad> listM51336a = m51336a(arrayList, listM51337a, AbstractC7796cp.m48089b(this.f32765b));
            m51339a(arrayList);
            String strM47742b = this.f32771h ? AbstractC7758be.m47742b(new Pair(7, m51338a(map))) : AbstractC7758be.m47742b(listM51336a);
            if (listM51336a.size() > 0) {
                AbstractC7326j.m45216a(this.f32770g, this.f32766c, 1000, strM47742b, true);
            } else {
                AbstractC7185ho.m43820b("JsbReqRewardAd", " ads map is empty.");
                AbstractC7326j.m45216a(this.f32770g, this.f32766c, 1005, null, true);
            }
        }

        public a(Context context, String str, RemoteCallResultCallback<String> remoteCallResultCallback, String str2) {
            super(context, str, remoteCallResultCallback, str2);
        }

        /* renamed from: a */
        private List<IRewardAd> m51337a(Map<String, List<IRewardAd>> map, String str) {
            if (C7765bl.m47802a(map)) {
                return null;
            }
            if (!TextUtils.isEmpty(str)) {
                return map.get(str);
            }
            ArrayList arrayList = new ArrayList();
            Iterator<Map.Entry<String, List<IRewardAd>>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                arrayList.addAll(it.next().getValue());
            }
            return arrayList;
        }

        /* renamed from: a */
        private Map<String, List<H5Ad>> m51338a(Map<String, List<IRewardAd>> map) {
            if (C7765bl.m47802a(map)) {
                return null;
            }
            HashMap map2 = new HashMap();
            for (Map.Entry<String, List<IRewardAd>> entry : map.entrySet()) {
                if (!AbstractC7760bg.m47767a(entry.getValue())) {
                    ArrayList arrayList = new ArrayList();
                    Iterator<IRewardAd> it = entry.getValue().iterator();
                    while (it.hasNext()) {
                        arrayList.add(new H5Ad((C7305h) it.next()));
                    }
                    map2.put(entry.getKey(), arrayList);
                }
            }
            return map2;
        }

        /* renamed from: a */
        private void m51339a(List<ContentRecord> list) {
            if (AbstractC7760bg.m47767a(list)) {
                return;
            }
            for (ContentRecord contentRecord : list) {
                if (contentRecord != null) {
                    if (contentRecord.m41464aP() == 3) {
                        if (this.f32768e.mo43102a(contentRecord.m41588n(), contentRecord.m41463aO(), contentRecord.m41585m()) == null) {
                            contentRecord.m41554f(AbstractC7741ao.m47566c());
                        }
                        AbstractC7185ho.m43820b("JsbReqRewardAd", "insertOrUpdateV3Content");
                        this.f32768e.mo43121c(contentRecord);
                        if (!TextUtils.isEmpty(contentRecord.m41463aO()) && !AbstractC7760bg.m47767a(contentRecord.m41471aW())) {
                            ContentTemplateRecord contentTemplateRecord = new ContentTemplateRecord(contentRecord.m41588n(), contentRecord.m41463aO(), contentRecord.m41471aW(), contentRecord.m41469aU(), contentRecord.m41528bo());
                            if (!TextUtils.isEmpty(contentRecord.m41473aY())) {
                                contentTemplateRecord.m41644a(contentRecord.m41473aY());
                            }
                            this.f32769f.mo43147a(contentTemplateRecord);
                        }
                    } else {
                        if (this.f32767d.mo43100a(contentRecord.m41588n(), contentRecord.m41585m()) == null) {
                            contentRecord.m41554f(AbstractC7741ao.m47566c());
                        }
                        AbstractC7185ho.m43820b("JsbReqRewardAd", "insertOrUpdateV2Content");
                        this.f32767d.mo43116b(contentRecord);
                    }
                }
            }
        }
    }

    public C8232x() {
        super("pps.reward.request");
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7206i
    /* renamed from: b */
    public void mo43898b(Context context, String str, RemoteCallResultCallback<String> remoteCallResultCallback) {
        JSONObject jSONObject = new JSONObject(str);
        String strOptString = jSONObject.optString("slotId");
        String strOptString2 = jSONObject.optString(JsbMapKeyNames.H5_MEDIA_CONTENT);
        int iOptInt = jSONObject.optInt(JsbMapKeyNames.H5_DEVICE_TYPE, 4);
        RequestOptions requestOptionsM45226c = m45226c(context, str);
        RewardAdLoader rewardAdLoader = new RewardAdLoader(context, new String[]{strOptString});
        rewardAdLoader.setRequestOptions(requestOptionsM45226c);
        rewardAdLoader.m44208a((Integer) 3);
        rewardAdLoader.setContentBundle(m43899c(strOptString2));
        rewardAdLoader.setLocation(m45230g(str));
        rewardAdLoader.setListener(new a(context, strOptString, remoteCallResultCallback, this.f34112a));
        rewardAdLoader.loadAds(iOptInt, false);
    }
}
