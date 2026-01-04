package com.huawei.openalliance.p169ad.utils;

import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.beans.metadata.Ad30;
import com.huawei.openalliance.p169ad.beans.metadata.Precontent;
import com.huawei.openalliance.p169ad.beans.server.AdContentRsp;
import com.huawei.openalliance.p169ad.constant.AdConfigMapKey;
import com.huawei.openalliance.p169ad.constant.SplashPreloadMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.huawei.openalliance.ad.utils.cf */
/* loaded from: classes2.dex */
public class C7786cf {
    /* renamed from: a */
    public static Map<String, String> m47897a(AdContentRsp adContentRsp) {
        String str;
        HashMap map = new HashMap();
        if (adContentRsp == null) {
            return map;
        }
        List<Ad30> listM40830c = adContentRsp.m40830c();
        if (!AbstractC7760bg.m47767a(listM40830c)) {
            for (Ad30 ad30 : listM40830c) {
                if (ad30 != null) {
                    String strM39419a = ad30.m39419a();
                    if (AbstractC7806cz.m48165b(strM39419a)) {
                        str = "empty slot id";
                    } else {
                        String strM39434g = ad30.m39434g();
                        if (AbstractC7806cz.m48165b(strM39434g)) {
                            str = "empty config map";
                        } else {
                            Map map2 = (Map) AbstractC7758be.m47739b(strM39434g, Map.class, new Class[0]);
                            if (!C7765bl.m47802a(map2)) {
                                String str2 = (String) map2.get(AdConfigMapKey.SPLASH_PRELOAD_MODE);
                                if (AbstractC7806cz.m48165b(str2) || !SplashPreloadMode.OPTIONAL_VALUE.contains(str2)) {
                                    str2 = "1";
                                }
                                map.put(strM39419a, str2);
                            }
                        }
                    }
                    AbstractC7185ho.m43817a("PreloadUtil", str);
                }
            }
        }
        return map;
    }

    /* renamed from: b */
    public static Map<String, String> m47898b(AdContentRsp adContentRsp) {
        HashMap map = new HashMap();
        if (adContentRsp == null) {
            return map;
        }
        List<Precontent> listM40842f = adContentRsp.m40842f();
        if (!AbstractC7760bg.m47767a(listM40842f)) {
            for (Precontent precontent : listM40842f) {
                if (precontent != null) {
                    String strM40407a = precontent.m40407a();
                    if (AbstractC7806cz.m48165b(strM40407a)) {
                        AbstractC7185ho.m43817a("PreloadUtil", "empty preload slot id");
                    } else {
                        Integer numM40434n = precontent.m40434n();
                        if (numM40434n != null) {
                            String strM48153a = AbstractC7806cz.m48153a(numM40434n);
                            if (SplashPreloadMode.OPTIONAL_VALUE.contains(strM48153a)) {
                                map.put(strM40407a, strM48153a);
                            }
                        }
                        map.put(strM40407a, "1");
                    }
                }
            }
        }
        return map;
    }
}
