package p341hj;

import android.text.TextUtils;
import com.huawei.hicloud.bean.GetCampaignActivityEntryResp;
import com.huawei.hicloud.notification.manager.HiCloudAllOMConfigManager;
import com.huawei.hms.identity.AddressConstants;
import com.huawei.openalliance.p169ad.constant.VastAttribute;
import fj.C9718g;
import fk.C9721b;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0212e0;
import p015ak.C0213f;
import p054cj.C1442a;
import p260ek.C9499a;
import p315gj.C9949b;
import p429kk.C11058a;
import p429kk.C11060c;
import p709vj.C13452e;
import p746wn.C13622a;

/* renamed from: hj.o */
/* loaded from: classes5.dex */
public class C10252o {

    /* renamed from: a */
    public int f49670a;

    public C10252o(int i10) {
        this.f49670a = i10;
    }

    /* renamed from: a */
    public GetCampaignActivityEntryResp m63414a() {
        GetCampaignActivityEntryResp getCampaignActivityEntryResp;
        C1442a.m8290i("GetActivityEntry", "GetActivityEntry start");
        C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("06016"), "/activity/entry", C13452e.m80781L().m80971t0());
        HiCloudAllOMConfigManager.getInstance().queryConfigSync("HiCloudCampaignQuests");
        try {
            try {
                c11060cM66626a.m66665u(String.valueOf(0));
                c11060cM66626a.m66635A("success");
                getCampaignActivityEntryResp = C9949b.m61704j().m61712h(c11060cM66626a, this.f49670a);
                C9718g.m60602t().m60620V(C0213f.m1377a(), getCampaignActivityEntryResp);
            } catch (C9721b e10) {
                C1442a.m8289e("GetActivityEntry", "GetActivityEntry error:" + e10.getMessage());
                c11060cM66626a.m66665u("114_" + e10.m60659c());
                c11060cM66626a.m66635A(e10.getMessage());
                GetCampaignActivityEntryResp getCampaignActivityEntryResp2 = new GetCampaignActivityEntryResp();
                getCampaignActivityEntryResp2.setResultCode(e10.m60659c());
                String strM63415b = m63415b(e10.getMessage());
                C1442a.m8289e("GetActivityEntry", "GetCampaignActivityEntryTask errorCode:" + strM63415b);
                getCampaignActivityEntryResp2.setErrorCode(strM63415b);
                if ("31015040".equals(strM63415b)) {
                    getCampaignActivityEntryResp2.setExceedRedemptionLimit(true);
                    C0212e0.m1365o(C0213f.m1377a(), "hicloud_campaign_activity_entry_sp", "exceedRedemptionLimit", true);
                }
                if ("31014003".equals(strM63415b)) {
                    getCampaignActivityEntryResp2.setNoActivitiesAvailable(true);
                }
                C13622a.m81968n(C0213f.m1377a(), c11060cM66626a);
                return getCampaignActivityEntryResp2;
            } catch (Exception e11) {
                C1442a.m8289e("GetActivityEntry", "GetCampaignActivityEntryTask e:" + e11.getMessage());
                getCampaignActivityEntryResp = new GetCampaignActivityEntryResp();
            }
            C13622a.m81968n(C0213f.m1377a(), c11060cM66626a);
            return getCampaignActivityEntryResp;
        } catch (Throwable th2) {
            C13622a.m81968n(C0213f.m1377a(), c11060cM66626a);
            throw th2;
        }
    }

    /* renamed from: b */
    public final String m63415b(String str) throws JSONException {
        JSONArray jSONArrayM59433a;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String strM59436d = C9499a.m59436d(str, VastAttribute.ERROR);
        if (TextUtils.isEmpty(strM59436d) || (jSONArrayM59433a = C9499a.m59433a(strM59436d, "errorDetail")) == null || jSONArrayM59433a.length() == 0) {
            return "";
        }
        try {
            JSONObject jSONObject = jSONArrayM59433a.getJSONObject(0);
            return jSONObject == null ? "" : C9499a.m59436d(jSONObject.toString(), AddressConstants.Extras.EXTRA_NAME_ERR_CODE);
        } catch (JSONException unused) {
            C1442a.m8289e("GetActivityEntry", "JsonUtil parseString error");
            return "";
        }
    }
}
