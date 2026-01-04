package ca;

import android.content.Context;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hms.network.embedded.C6148x2;
import com.huawei.openalliance.p169ad.inter.HiAd;
import com.huawei.openalliance.p169ad.inter.data.INativeAd;
import com.huawei.openalliance.p169ad.inter.data.RewardVerifyConfig;
import com.huawei.secure.android.common.ssl.SecureX509TrustManager;
import gu.C10048b;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0209d;
import p015ak.C0213f;
import p373iu.C10618f;
import p514o9.C11829c;
import p514o9.C11839m;
import p514o9.C11842p;
import p684un.C13227f;
import p684un.C13230i;
import p709vj.C13452e;
import p783xp.C13843a;

/* renamed from: ca.c */
/* loaded from: classes3.dex */
public class C1400c {

    /* renamed from: a */
    public static C1400c f6003a = new C1400c();

    /* renamed from: a */
    public static void m8055a() {
        C13843a.m83085g(m8058d());
    }

    /* renamed from: b */
    public static int m8056b() {
        return C11842p.m70762R0() ? 5 : 4;
    }

    /* renamed from: c */
    public static C1400c m8057c() {
        return f6003a;
    }

    /* renamed from: d */
    public static String m8058d() {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            return "";
        }
        return contextM1377a.getFilesDir() + "/appiconpath/";
    }

    /* renamed from: f */
    public static void m8059f(Context context) {
        if (context == null) {
            C11839m.m70687e("PpsAdsManager", "init PPS SDK error, context is null");
            return;
        }
        Context applicationContext = context.getApplicationContext();
        if (C11829c.m70530L0() && C11829c.m70538P0()) {
            try {
                HiAd.getInstance(applicationContext).initLog(true, 4);
                HiAd.getInstance(applicationContext).setCustomSSLSocketFactory(C10618f.m65076c(applicationContext, C10048b.m62471c()), new SecureX509TrustManager(applicationContext));
                HiAd.getInstance(applicationContext).enableUserInfo(true);
                HiAd.getInstance(applicationContext).initGrs("hicloud");
                if (C0209d.m1269j1()) {
                    HiAd.getInstance(applicationContext).setBrand(2);
                } else {
                    HiAd.getInstance(applicationContext).setBrand(1);
                }
            } catch (Exception e10) {
                C11839m.m70687e("PpsAdsManager", "init PPS SDK error, e = " + e10.toString());
            }
        }
    }

    /* renamed from: g */
    public static void m8060g(String str, LinkedHashMap<String, String> linkedHashMap) {
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put(C6148x2.DEVICE_ID, C13452e.m80781L().m80954p());
        if (linkedHashMap != null) {
            linkedHashMapM79497A.putAll(linkedHashMap);
        }
        C13227f.m79492i1().m79567R(str, linkedHashMapM79497A);
        UBAAnalyze.m29947H("CKC", str, linkedHashMapM79497A);
    }

    /* renamed from: h */
    public static void m8061h(INativeAd iNativeAd, String str) throws JSONException {
        if (iNativeAd == null) {
            C11839m.m70687e("PpsAdsManager", "nativeAd null");
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(NotifyConstants.MarketingConstant.CID_KEY, str);
            jSONObject.put("packageName", iNativeAd.getAppInfo().getPackageName());
        } catch (Exception unused) {
            C11839m.m70687e("PpsAdsManager", "json exception");
        }
        try {
            iNativeAd.setRewardVerifyConfig(new RewardVerifyConfig.Builder().setData(jSONObject.toString()).setUserId(C13452e.m80781L().m80971t0()).build());
        } catch (Exception unused2) {
            C11839m.m70687e("PpsAdsManager", "setRewardVerifyConfig exception");
        }
    }

    /* renamed from: e */
    public List<INativeAd> m8062e(List<INativeAd> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            for (int i10 = 0; i10 < list.size(); i10++) {
                INativeAd iNativeAd = list.get(i10);
                if (iNativeAd != null && !iNativeAd.isExpired()) {
                    arrayList.add(iNativeAd);
                }
            }
        }
        return arrayList;
    }
}
