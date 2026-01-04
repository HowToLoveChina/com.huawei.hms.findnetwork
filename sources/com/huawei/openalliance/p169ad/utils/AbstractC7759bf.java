package com.huawei.openalliance.p169ad.utils;

import android.content.Context;
import com.huawei.openalliance.p169ad.AbstractC7014dc;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C7120fd;
import com.huawei.openalliance.p169ad.C7483mr;
import com.huawei.openalliance.p169ad.beans.metadata.p170v3.CachedContent;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import com.huawei.openalliance.p169ad.constant.RTCMethods;
import com.huawei.openalliance.p169ad.inter.C7310h;
import com.huawei.openalliance.p169ad.ipc.CallResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.huawei.openalliance.ad.utils.bf */
/* loaded from: classes2.dex */
public abstract class AbstractC7759bf {
    /* renamed from: a */
    public static void m47762a(final Context context) {
        AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.utils.bf.1
            @Override // java.lang.Runnable
            public void run() {
                if (AbstractC7807d.m48227c(context, 1)) {
                    AbstractC7185ho.m43817a("KitDataUtil", "prepare cached contentId");
                    List listM47764c = AbstractC7759bf.m47764c(context);
                    if (AbstractC7760bg.m47767a(listM47764c)) {
                        AbstractC7185ho.m43817a("KitDataUtil", "no need prepare cached contentId");
                        return;
                    }
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(MapKeyNames.AD_IDS, AbstractC7758be.m47742b(listM47764c));
                        jSONObject.put("adType", 1);
                        CallResult callResultM45853a = C7483mr.m45852a(context).m45853a(RTCMethods.QUERY_CACHED_CONTENT, jSONObject.toString(), String.class);
                        if (callResultM45853a != null && 200 == callResultM45853a.getCode()) {
                            JSONObject jSONObject2 = new JSONObject((String) callResultM45853a.getData());
                            String strOptString = jSONObject2.optString(MapKeyNames.CACHED_CONTENT_ID);
                            String strOptString2 = jSONObject2.optString(MapKeyNames.CACHED_TEMPLATE);
                            AbstractC7185ho.m43821b("KitDataUtil", "query kit cached content success: %s", Integer.valueOf(jSONObject2.optInt(MapKeyNames.RESULT_CODE)));
                            if (!AbstractC7806cz.m48165b(strOptString)) {
                                AbstractC7185ho.m43817a("KitDataUtil", "parse kit cached content id");
                                List list = (List) AbstractC7758be.m47739b(strOptString, List.class, String.class);
                                if (!AbstractC7760bg.m47767a(list)) {
                                    AbstractC7014dc.m41873a((List<String>) list);
                                }
                            }
                            if (!AbstractC7806cz.m48165b(strOptString2)) {
                                AbstractC7185ho.m43817a("KitDataUtil", "parse kit cached template");
                                Map map = (Map) AbstractC7758be.m47739b(strOptString2, Map.class, new Class[0]);
                                HashMap map2 = new HashMap();
                                if (!C7765bl.m47802a(map)) {
                                    for (Map.Entry entry : map.entrySet()) {
                                        map2.put(entry.getKey(), (List) AbstractC7758be.m47739b((String) entry.getValue(), List.class, CachedContent.class));
                                    }
                                }
                                if (!C7765bl.m47802a(map2)) {
                                    AbstractC7014dc.m41874a(map2);
                                }
                            }
                        }
                    } catch (Throwable th2) {
                        AbstractC7185ho.m43824c("KitDataUtil", "prepare cached contentId error: %s", th2.getClass().getSimpleName());
                    }
                    C7310h.m45025a(context);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public static List<String> m47764c(Context context) {
        Map map = (Map) AbstractC7758be.m47739b(C7120fd.m43288a(context).mo43291a(), Map.class, new Class[0]);
        if (C7765bl.m47802a(map)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            String str2 = (String) entry.getValue();
            if (!AbstractC7806cz.m48165b(str) && !AbstractC7806cz.m48165b(str2) && 1 != Integer.parseInt(str2) && Integer.parseInt(str2) != 0) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }
}
