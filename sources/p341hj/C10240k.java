package p341hj;

import android.text.TextUtils;
import com.huawei.hicloud.bean.DispatchCampaignActivityResp;
import com.huawei.hms.identity.AddressConstants;
import com.huawei.openalliance.p169ad.constant.VastAttribute;
import fk.C9721b;
import org.json.JSONArray;
import org.json.JSONObject;
import p015ak.C0213f;
import p054cj.C1442a;
import p315gj.C9949b;
import p429kk.C11058a;
import p429kk.C11060c;
import p709vj.C13452e;
import p746wn.C13622a;

/* renamed from: hj.k */
/* loaded from: classes5.dex */
public class C10240k extends AbstractC10222e {

    /* renamed from: b */
    public final String f49632b;

    /* renamed from: c */
    public final String f49633c;

    /* renamed from: d */
    public final String f49634d;

    /* renamed from: e */
    public final a f49635e;

    /* renamed from: hj.k$a */
    public interface a {
        /* renamed from: a */
        void mo63400a(DispatchCampaignActivityResp dispatchCampaignActivityResp);

        void onError(String str);
    }

    public C10240k(String str, String str2, String str3, String str4, a aVar) {
        this.f49634d = str3;
        this.f49632b = str4;
        this.f49633c = "/activities/" + str + "/sessions/" + str2 + "/dispatch";
        this.f49635e = aVar;
    }

    /* renamed from: h */
    public static String m63399h(String str) {
        if (TextUtils.isEmpty(str)) {
            C1442a.m8290i("DispatchCampaignActivityTask", "errorMsg is null");
            return null;
        }
        if (!str.contains(VastAttribute.ERROR)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has(VastAttribute.ERROR)) {
                return null;
            }
            JSONObject jSONObject2 = jSONObject.getJSONObject(VastAttribute.ERROR);
            if (jSONObject2.has("errorDetail")) {
                return new JSONArray(jSONObject2.getString("errorDetail")).optJSONObject(0).getString(AddressConstants.Extras.EXTRA_NAME_ERR_CODE);
            }
            return null;
        } catch (Exception e10) {
            C1442a.m8289e("DispatchCampaignActivityTask", "parseErrorByRsp error: " + e10.getMessage());
            return null;
        }
    }

    @Override // com.huawei.android.hicloud.logic.threadpool.TaskObject
    /* renamed from: a */
    public void mo16407a() {
        C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("06017"), this.f49633c, C13452e.m80781L().m80971t0());
        try {
            try {
                c11060cM66626a.m66665u(String.valueOf(0));
                c11060cM66626a.m66635A("success");
                this.f49635e.mo63400a(C9949b.m61704j().m61711g(c11060cM66626a, this.f49632b, this.f49633c, "quest=" + this.f49634d));
            } catch (C9721b e10) {
                C1442a.m8289e("DispatchCampaignActivityTask", "DispatchCampaignActivityTask error:" + e10.getMessage());
                c11060cM66626a.m66665u("114_" + e10.m60659c());
                c11060cM66626a.m66635A(e10.getMessage());
                this.f49635e.onError(e10.getMessage());
            }
        } finally {
            C13622a.m81968n(C0213f.m1377a(), c11060cM66626a);
        }
    }
}
