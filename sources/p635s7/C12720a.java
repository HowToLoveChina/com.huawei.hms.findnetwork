package p635s7;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.android.hicloud.album.service.hihttp.request.response.AccountCheckResponse;
import com.huawei.android.hicloud.album.service.p075vo.AccountCheckResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import p031b7.C1120a;
import p650t7.C12953a;
import p764x6.AbstractC13709a;

/* renamed from: s7.a */
/* loaded from: classes2.dex */
public class C12720a extends AbstractC12758w {

    /* renamed from: l */
    public List<String> f58289l;

    public C12720a(Context context, List<String> list) {
        this.f60186b = context;
        this.f58289l = list;
        this.f60187c = m80109h("/JPJX/BaseAPI");
        this.f58397k = "bapi.account.check";
        m80115r();
        m80107f();
    }

    @Override // p701v6.AbstractC13354a
    /* renamed from: a */
    public void mo14589a() throws Exception {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        jSONObject.put("cmd", this.f58397k);
        List<String> list = this.f58289l;
        if (list != null) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next());
            }
        }
        jSONObject.put("accList", jSONArray);
        C1120a.m6675d("AccountCheckRequest", "bapi.account.check");
        this.f60188d = jSONObject.toString();
    }

    @Override // p701v6.AbstractC13354a
    /* renamed from: n */
    public AbstractC13709a mo14591n() {
        this.f58397k = "Check.Users.list";
        return new C12953a(this.f58289l);
    }

    @Override // p635s7.AbstractC12758w
    /* renamed from: u */
    public Bundle mo15143u(String str) {
        Bundle bundle = new Bundle();
        if (this.f58289l != null) {
            bundle.putStringArrayList("AccountList", new ArrayList<>(this.f58289l));
        }
        try {
            AccountCheckResponse accountCheckResponse = (AccountCheckResponse) new Gson().fromJson(str, AccountCheckResponse.class);
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            if (accountCheckResponse != null) {
                int code = accountCheckResponse.getCode();
                C1120a.m6677i("AccountCheckRequest", "bapi.account.check code: " + code);
                bundle.putInt("code", code);
                bundle.putString("info", accountCheckResponse.getInfo());
                HashMap<String, String> accUidMap = accountCheckResponse.getAccUidMap();
                List<String> list = this.f58289l;
                if (list != null && accUidMap != null) {
                    for (String str2 : list) {
                        arrayList.add(new AccountCheckResult(str2, accUidMap.get(str2)));
                    }
                }
            }
            bundle.putParcelableArrayList("AccountUidList", arrayList);
            return bundle;
        } catch (JsonSyntaxException e10) {
            C1120a.m6676e("AccountCheckRequest", "getResponseBundle json syntax exception: " + e10.toString());
            return bundle;
        }
    }
}
