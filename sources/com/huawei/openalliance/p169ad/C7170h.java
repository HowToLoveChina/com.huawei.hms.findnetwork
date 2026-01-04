package com.huawei.openalliance.p169ad;

import android.content.Context;
import com.huawei.hms.support.api.entity.sns.SNSCode;
import com.huawei.openalliance.p169ad.beans.metadata.MetaData;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import com.huawei.openalliance.p169ad.inter.data.MaterialClickInfo;
import com.huawei.openalliance.p169ad.inter.data.VideoInfo;
import com.huawei.openalliance.p169ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.processor.eventbeans.C7587b;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.huawei.openalliance.ad.h */
/* loaded from: classes8.dex */
public class C7170h extends AbstractC7326j {
    public C7170h() {
        super("pps.action.click");
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7326j, com.huawei.openalliance.p169ad.InterfaceC7143g
    /* renamed from: a */
    public void mo38573a(Context context, String str, RemoteCallResultCallback<String> remoteCallResultCallback) {
        int i10;
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43817a("JsbAdClick", "start");
        }
        JSONObject jSONObject = new JSONObject(str);
        int iOptInt = jSONObject.optInt("adType", -1);
        ContentRecord contentRecordM45224b = m45224b(context, str);
        if (contentRecordM45224b != null) {
            MetaData metaDataM41568i = contentRecordM45224b.m41568i();
            i10 = 1000;
            if (metaDataM41568i != null) {
                HashMap map = new HashMap();
                map.put("appId", metaDataM41568i.m40330n());
                map.put("thirdId", metaDataM41568i.m40328m());
                if (iOptInt == 3 && contentRecordM45224b.m41419S() != null) {
                    VideoInfo videoInfo = new VideoInfo(contentRecordM45224b.m41419S());
                    map.put(MapKeyNames.LINKED_CUSTOM_SHOW_ID, contentRecordM45224b.m41577k());
                    map.put(MapKeyNames.LINKED_CUSTOM_RETURN_VIDEO_DIRECT, videoInfo.m44585f() ? FaqConstants.DISABLE_HA_REPORT : "false");
                    map.put(MapKeyNames.LINKED_CUSTOM_VIDEO_SOUND_SWITCH, videoInfo.getSoundSwitch());
                    map.put(MapKeyNames.LINKED_CUSTOM_VIDEO_PROGRESS, String.valueOf(videoInfo.m44566b()));
                    map.put(MapKeyNames.LINKED_SPLASH_MEDIA_PATH, contentRecordM45224b.m41384A());
                }
                AbstractC7687ti abstractC7687tiM47245a = C7686th.m47245a(m45221a(context), contentRecordM45224b, map);
                if (abstractC7687tiM47245a.mo47233a()) {
                    MaterialClickInfo materialClickInfoM45229f = m45229f(str);
                    Integer numM45227d = m45227d(str);
                    boolean z10 = materialClickInfoM45229f.m44517h() == null && materialClickInfoM45229f.m44518i() == null;
                    if (numM45227d != null && 13 == numM45227d.intValue() && z10) {
                        materialClickInfoM45229f.m44515f(1);
                    }
                    if (m45223a(context, contentRecordM45224b)) {
                        m43671a(abstractC7687tiM47245a, context, contentRecordM45224b, iOptInt, numM45227d, materialClickInfoM45229f, jSONObject);
                    } else {
                        AbstractC7185ho.m43820b("JsbAdClick", "ad is not in whitelist");
                        i10 = SNSCode.Status.GET_GROUP_MEM_LIST_FAIL;
                    }
                } else {
                    AbstractC7185ho.m43820b("JsbAdClick", "fail open land page");
                    i10 = SNSCode.Status.GET_GROUP_LIST_FAIL;
                }
            }
        } else {
            AbstractC7185ho.m43820b("JsbAdClick", "ad not exist");
            i10 = SNSCode.Status.GET_FRIEND_LIST_FAIL;
        }
        AbstractC7326j.m45216a(remoteCallResultCallback, this.f34112a, i10, null, true);
    }

    /* renamed from: a */
    private void m43671a(AbstractC7687ti abstractC7687ti, Context context, ContentRecord contentRecord, int i10, Integer num, MaterialClickInfo materialClickInfo, JSONObject jSONObject) {
        C7560ou c7560ou = new C7560ou(context, C7662sk.m47225a(context, i10), contentRecord);
        C7587b.a aVar = new C7587b.a();
        aVar.m46920b(abstractC7687ti.m47250c()).m46915a(num).m46917a(m45231h(jSONObject.optString("versionCode"))).m46916a(jSONObject.optString("versionCode")).m46914a(materialClickInfo);
        c7560ou.mo46594a(aVar.m46918a());
    }
}
