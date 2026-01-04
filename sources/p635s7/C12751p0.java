package p635s7;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.android.hicloud.album.service.hihttp.request.response.AvatarInfoResponse;
import com.huawei.android.hicloud.album.service.p075vo.AvatarInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import p031b7.C1120a;
import p650t7.C12980n0;
import p764x6.AbstractC13709a;

/* renamed from: s7.p0 */
/* loaded from: classes2.dex */
public class C12751p0 extends AbstractC12758w {

    /* renamed from: l */
    public List<String> f58384l;

    public C12751p0(Context context, List<String> list, String str) {
        this.f60186b = context;
        this.f58384l = list;
        this.f60187c = m80109h("/JPJX/BaseAPI");
        this.f58397k = "bapi.account.getuserinfo";
        this.f60189e = str;
        m80107f();
    }

    @Override // p701v6.AbstractC13354a
    /* renamed from: a */
    public void mo14589a() throws Exception {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        jSONObject.put("cmd", this.f58397k);
        List<String> list = this.f58384l;
        if (list != null) {
            for (String str : list) {
                if (!TextUtils.isEmpty(str)) {
                    jSONArray.put(str);
                }
            }
        }
        jSONObject.put("userIdList", jSONArray);
        this.f60188d = jSONObject.toString();
    }

    @Override // p701v6.AbstractC13354a
    /* renamed from: n */
    public AbstractC13709a mo14591n() {
        this.f58397k = "Userinfo.Users.list";
        return new C12980n0(this.f58384l);
    }

    @Override // p635s7.AbstractC12758w
    /* renamed from: u */
    public Bundle mo15143u(String str) {
        try {
            AvatarInfoResponse avatarInfoResponse = (AvatarInfoResponse) new Gson().fromJson(str, AvatarInfoResponse.class);
            if (avatarInfoResponse == null) {
                return m76579w();
            }
            Bundle bundle = new Bundle();
            int code = avatarInfoResponse.getCode();
            C1120a.m6677i("UserInfoQueryRequest", "bapi.account.getuserinfo code: " + code);
            bundle.putInt("code", code);
            bundle.putString("info", avatarInfoResponse.getInfo());
            List<String> list = this.f58384l;
            bundle.putString("errMsg", list == null ? "" : Arrays.deepToString(list.toArray()));
            bundle.putParcelableArrayList("avatarInfoList", avatarInfoResponse.getUserList());
            return bundle;
        } catch (JsonSyntaxException e10) {
            C1120a.m6676e("UserInfoQueryRequest", "getResponseBundle json syntax exception: " + e10.toString());
            return m76579w();
        }
    }

    /* renamed from: w */
    public final Bundle m76579w() {
        Bundle bundle = new Bundle();
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        List<String> list = this.f58384l;
        if (list != null) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new AvatarInfo(it.next()));
            }
        }
        bundle.putParcelableArrayList("avatarInfoList", arrayList);
        return bundle;
    }
}
