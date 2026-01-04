package p341hj;

import android.text.TextUtils;
import com.huawei.hicloud.bean.GetCampaignActivityEntryResp;
import com.huawei.hicloud.notification.manager.HiCloudAllOMConfigManager;
import com.huawei.hms.identity.AddressConstants;
import com.huawei.openalliance.p169ad.constant.VastAttribute;
import fk.C9721b;
import java.util.function.Consumer;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0213f;
import p054cj.C1442a;
import p260ek.C9499a;
import p315gj.C9949b;
import p429kk.C11058a;
import p429kk.C11060c;
import p709vj.C13452e;
import p746wn.C13622a;

/* renamed from: hj.w */
/* loaded from: classes5.dex */
public class C10270w extends AbstractC10222e {

    /* renamed from: b */
    public Consumer<GetCampaignActivityEntryResp> f49737b;

    /* renamed from: c */
    public int f49738c;

    /* renamed from: d */
    public String f49739d;

    public C10270w(Consumer<GetCampaignActivityEntryResp> consumer, int i10) {
        this.f49737b = consumer;
        this.f49738c = i10;
    }

    @Override // com.huawei.android.hicloud.logic.threadpool.TaskObject
    /* renamed from: a */
    public void mo16407a() {
        C1442a.m8290i("GetCampaignActivityEntryTask", "GetCampaignActivityEntryTask start from=" + this.f49739d);
        C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("06016"), "/activity/entry", C13452e.m80781L().m80971t0());
        HiCloudAllOMConfigManager.getInstance().queryConfigSync("HiCloudCampaignQuests");
        try {
            try {
                c11060cM66626a.m66665u(String.valueOf(0));
                c11060cM66626a.m66635A("success");
                this.f49737b.accept(C9949b.m61704j().m61712h(c11060cM66626a, this.f49738c));
            } catch (C9721b e10) {
                C1442a.m8289e("GetCampaignActivityEntryTask", "GetCampaignActivityEntryTask error:" + e10.getMessage());
                c11060cM66626a.m66665u("114_" + e10.m60659c());
                c11060cM66626a.m66635A(e10.getMessage());
                GetCampaignActivityEntryResp getCampaignActivityEntryResp = new GetCampaignActivityEntryResp();
                getCampaignActivityEntryResp.setResultCode(e10.m60659c());
                String strM63433h = m63433h(e10.getMessage());
                C1442a.m8289e("GetCampaignActivityEntryTask", "GetCampaignActivityEntryTask errorCode:" + strM63433h);
                getCampaignActivityEntryResp.setErrorCode(strM63433h);
                if ("31015040".equals(strM63433h)) {
                    getCampaignActivityEntryResp.setExceedRedemptionLimit(true);
                }
                this.f49737b.accept(getCampaignActivityEntryResp);
            }
        } finally {
            C13622a.m81968n(C0213f.m1377a(), c11060cM66626a);
        }
    }

    /* renamed from: h */
    public final String m63433h(String str) throws JSONException {
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
            C1442a.m8289e("GetCampaignActivityEntryTask", "JsonUtil parseString error");
            return "";
        }
    }

    /* renamed from: i */
    public void m63434i(String str) {
        this.f49739d = str;
    }

    public C10270w(Consumer<GetCampaignActivityEntryResp> consumer) {
        this.f49737b = consumer;
    }
}
