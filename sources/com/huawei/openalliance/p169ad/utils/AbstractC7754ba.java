package com.huawei.openalliance.p169ad.utils;

import android.content.Context;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C7114ey;
import com.huawei.openalliance.p169ad.InterfaceC7139fw;
import com.huawei.openalliance.p169ad.constant.InsAppKey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.huawei.openalliance.ad.utils.ba */
/* loaded from: classes2.dex */
public abstract class AbstractC7754ba {
    /* renamed from: a */
    public static int m47702a(String str) {
        if (AbstractC7806cz.m48165b(str)) {
            return 180;
        }
        int iM48145a = AbstractC7806cz.m48145a(str, 180);
        if (iM48145a == -1) {
            return -1;
        }
        if (iM48145a < 0) {
            return 180;
        }
        return iM48145a;
    }

    /* renamed from: a */
    private static String m47703a(String str, String str2) {
        List<String> listM48157a = AbstractC7806cz.m48157a(str2, ",");
        List<String> listM48157a2 = AbstractC7806cz.m48157a(str, ",");
        HashSet hashSet = new HashSet();
        if (!AbstractC7760bg.m47767a(listM48157a)) {
            hashSet.addAll(listM48157a);
        }
        if (!AbstractC7760bg.m47767a(listM48157a2)) {
            hashSet.addAll(listM48157a2);
        }
        return AbstractC7806cz.m48155a((Collection<String>) hashSet, ",");
    }

    /* renamed from: a */
    public static void m47704a(Context context, String str) {
        C7787cg c7787cgM47900a;
        List<String> arrayList;
        InterfaceC7139fw interfaceC7139fwM43174a = C7114ey.m43174a(context);
        try {
            JSONObject jSONObject = new JSONObject(str);
            String strOptString = jSONObject.optString(InsAppKey.ENCODING_MODE);
            String strOptString2 = jSONObject.optString(InsAppKey.INS_APP_TYPES);
            String strOptString3 = jSONObject.optString(InsAppKey.INS_APP);
            long jOptLong = jSONObject.optLong(InsAppKey.LABEL_GEN_TIME);
            long jMo43184d = interfaceC7139fwM43174a.mo43184d();
            if (jSONObject.has(InsAppKey.LABEL_GEN_TIME) && jOptLong <= jMo43184d) {
                AbstractC7185ho.m43820b("InsAppsUtil", "ins app label not update");
                return;
            }
            if (strOptString.equals(interfaceC7139fwM43174a.mo43180b())) {
                strOptString3 = m47703a(interfaceC7139fwM43174a.mo43176a(), strOptString3);
                AbstractC7185ho.m43818a("InsAppsUtil", "merged ins app: %s", strOptString3);
            } else {
                AbstractC7185ho.m43817a("InsAppsUtil", "override ins app");
            }
            interfaceC7139fwM43174a.mo43179a(strOptString3);
            if (!AbstractC7806cz.m48165b(strOptString)) {
                interfaceC7139fwM43174a.mo43181b(strOptString);
            }
            if (AbstractC7806cz.m48165b(strOptString2)) {
                c7787cgM47900a = C7787cg.m47900a(context);
                arrayList = new ArrayList<>();
            } else {
                c7787cgM47900a = C7787cg.m47900a(context);
                arrayList = Arrays.asList(strOptString2.split(","));
            }
            c7787cgM47900a.m47971b(arrayList);
            if (jSONObject.has(InsAppKey.LABEL_GEN_TIME)) {
                interfaceC7139fwM43174a.mo43178a(jOptLong);
            }
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("InsAppsUtil", "parse ins app result fail: %s", th2.getClass().getSimpleName());
        }
    }
}
