package p587qq;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.network.restclient.Response;
import com.huawei.hms.framework.network.restclient.hwhttp.ResponseBody;
import com.huawei.openalliance.p169ad.constant.Constants;
import hu.C10343b;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p432kq.C11131c;
import p587qq.AbstractC12388f;
import p640sq.C12836o;

/* renamed from: qq.e */
/* loaded from: classes8.dex */
public class C12387e extends AbstractC12388f<C11131c> {
    public C12387e(C11131c c11131c, Context context, String str, AbstractC12388f.d dVar) {
        this.f57208a = c11131c;
        this.f57209b = context;
        this.f57210c = str;
        this.f57211d = dVar;
    }

    @Override // p587qq.AbstractC12388f
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public void mo74447d(C11131c c11131c, Response<ResponseBody> response) throws JSONException {
        int code = response.getCode();
        C12836o.m77097b("GetResourceCase", "code:" + code, true);
        if (code != 200) {
            m74453b(2005, "Request Error:code is " + code);
            return;
        }
        try {
            String str = new String(response.getBody().bytes(), Constants.UTF_8);
            C12836o.m77097b("GetResourceCase", "handleRequestNet data:" + str, false);
            c11131c.m66935i(str);
            if (c11131c.m66995h() != 0) {
                m74453b(6, "Request Error:casLoginJson is empty.");
                return;
            }
            String strM66994g = c11131c.m66994g();
            C10343b c10343b = new C10343b();
            ArrayList<String> arrayList = new ArrayList<>();
            if (TextUtils.isEmpty(strM66994g)) {
                C12836o.m77097b("GetResourceCase", "getErrorCode ==" + c11131c.mo66928e(), true);
                C12836o.m77097b("GetResourceCase", "getErrorDesc ==" + c11131c.mo66929f(), false);
                m74453b(c11131c.mo66928e(), c11131c.mo66929f());
                return;
            }
            JSONObject jSONObject = new JSONObject(strM66994g);
            c10343b.m63701w("publicKey", jSONObject.getString("public-key"));
            JSONArray jSONArray = jSONObject.getJSONArray("domain-whitelist");
            int length = jSONArray.length();
            for (int i10 = 0; i10 < length; i10++) {
                arrayList.add((String) jSONArray.get(i10));
            }
            c10343b.m63702x("domainAllowList", arrayList);
            C12836o.m77097b("GetResourceCase", "allow list" + arrayList.toString(), false);
            C12836o.m77097b("GetResourceCase", "allow-length---" + length, true);
            m74454c(c10343b);
        } catch (Exception e10) {
            C12836o.m77097b("GetResourceCase", "Exception:" + e10.getClass().getSimpleName(), true);
            m74453b(2015, "Request Error:" + e10.getClass().getSimpleName());
        }
    }
}
