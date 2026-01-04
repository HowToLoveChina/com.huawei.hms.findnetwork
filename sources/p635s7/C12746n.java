package p635s7;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.android.hicloud.album.service.hihttp.request.response.GetDetailedInfoResponse;
import com.huawei.android.hicloud.album.service.p075vo.FailRet;
import com.huawei.android.hicloud.album.service.p075vo.FileData;
import com.huawei.android.hicloud.album.service.p075vo.SimplifyInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p031b7.C1120a;
import p312g8.C9894e;
import p650t7.C12979n;
import p764x6.AbstractC13709a;
import p765x7.C13720b;
import p765x7.C13721c;

/* renamed from: s7.n */
/* loaded from: classes2.dex */
public class C12746n extends AbstractC12758w {

    /* renamed from: l */
    public List<SimplifyInfo> f58367l;

    /* renamed from: m */
    public boolean f58368m;

    public C12746n(Context context, String str, List<SimplifyInfo> list, boolean z10) {
        this.f60186b = context;
        this.f60189e = str;
        this.f58367l = list;
        this.f58368m = z10;
        this.f60187c = m80109h(C13720b.m82484e());
        this.f58397k = "cloudphoto.file.queryspecified";
    }

    @Override // p701v6.AbstractC13354a
    /* renamed from: a */
    public void mo14589a() throws Exception {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        Gson gson = new Gson();
        for (SimplifyInfo simplifyInfo : this.f58367l) {
            if (simplifyInfo != null) {
                JSONObject jSONObject2 = new JSONObject(gson.toJson(simplifyInfo));
                jSONArray.put(jSONObject2);
                C1120a.m6675d("GetDetailedInfoRequest", "appendMainBody: " + jSONObject2);
            }
        }
        jSONObject.put("cmd", this.f58397k);
        jSONObject.put("fileList", jSONArray);
        this.f60188d = jSONObject.toString();
    }

    @Override // p701v6.AbstractC13354a
    /* renamed from: n */
    public AbstractC13709a mo14591n() {
        this.f58397k = "Specified.Media.get";
        C12979n c12979n = new C12979n(this.f58367l, this.f58368m);
        c12979n.m82456i(this.f60189e);
        return c12979n;
    }

    @Override // p635s7.AbstractC12758w
    /* renamed from: u */
    public Bundle mo15143u(String str) throws JSONException {
        if (str == null) {
            C1120a.m6676e("GetDetailedInfoRequest", "responseBody is empty!");
            return C13721c.m82487c(101, "body is empty!");
        }
        try {
            GetDetailedInfoResponse getDetailedInfoResponse = (GetDetailedInfoResponse) new Gson().fromJson(str, GetDetailedInfoResponse.class);
            int code = getDetailedInfoResponse.getCode();
            String info = getDetailedInfoResponse.getInfo();
            ArrayList<FileData> successList = getDetailedInfoResponse.getSuccessList();
            ArrayList<FailRet> failList = getDetailedInfoResponse.getFailList();
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            if (successList != null) {
                Iterator<FileData> it = successList.iterator();
                while (it.hasNext()) {
                    FileData next = it.next();
                    if (next.getExpand() != null) {
                        C9894e.m61407j(next);
                        next.setExpandString(next.getExpand().toString());
                    }
                    if (TextUtils.isEmpty(next.getAlbumId()) || TextUtils.isEmpty(next.getHash())) {
                        C1120a.m6678w("GetDetailedInfoRequest", "getSpecifiedBundle: AlbumId of Hash is empty");
                    }
                    arrayList.add(new FileData(next));
                }
            }
            StringBuilder sb2 = new StringBuilder("file.queryspecified: ");
            sb2.append(code);
            sb2.append(", info");
            sb2.append(info);
            sb2.append(", successList: ");
            sb2.append(successList == null ? null : Integer.valueOf(successList.size()));
            sb2.append(", failList: ");
            sb2.append(failList != null ? Integer.valueOf(failList.size()) : null);
            sb2.append(", isRecycleFile: ");
            sb2.append(this.f58368m);
            String string = sb2.toString();
            C1120a.m6677i("GetDetailedInfoRequest", string);
            Bundle bundle = new Bundle();
            bundle.putInt("code", code);
            bundle.putString("info", info);
            bundle.putString("errMsg", string);
            bundle.putParcelableArrayList("FileInfoList", arrayList);
            bundle.putParcelableArrayList("FailRetList", failList);
            bundle.putBoolean("IsRecycleAlbum", this.f58368m);
            return bundle;
        } catch (JsonSyntaxException e10) {
            C1120a.m6676e("GetDetailedInfoRequest", "GetDetailedInfoResponse json syntax exception: " + e10.toString());
            return null;
        }
    }
}
