package p635s7;

import android.content.Context;
import android.os.Bundle;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.android.hicloud.album.service.hihttp.request.response.FileModifyInfoResponse;
import com.huawei.android.hicloud.sync.protocol.SyncProtocol;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import p031b7.C1120a;
import p650t7.C12975l;
import p764x6.AbstractC13709a;
import p765x7.C13720b;
import p765x7.C13721c;

/* renamed from: s7.l */
/* loaded from: classes2.dex */
public class C12742l extends AbstractC12758w {

    /* renamed from: l */
    public int f58350l;

    /* renamed from: m */
    public int f58351m;

    /* renamed from: n */
    public String f58352n;

    /* renamed from: o */
    public List<String> f58353o;

    /* renamed from: p */
    public boolean f58354p;

    public C12742l(Context context, String str, List<String> list, int i10, int i11, String str2) {
        this.f58354p = false;
        this.f60186b = context;
        this.f60189e = str;
        this.f58350l = i10;
        this.f58351m = i11;
        this.f58352n = str2;
        this.f58353o = list;
        this.f60187c = m80109h(C13720b.m82482c(i10));
        this.f58397k = "cloudphoto.file.querymodifyinfos";
        this.f58354p = C12740k.m76570y(list);
    }

    @Override // p701v6.AbstractC13354a
    /* renamed from: a */
    public void mo14589a() throws Exception {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("cmd", this.f58397k);
        jSONObject.put("usescenario", this.f58350l);
        jSONObject.put(SyncProtocol.Constant.CURSOR, this.f58352n);
        jSONObject.put("limit", this.f58351m);
        List<String> list = this.f58353o;
        if (list != null && !list.isEmpty()) {
            jSONObject.put("albumIds", new JSONArray((Collection) this.f58353o));
        }
        this.f60188d = jSONObject.toString();
    }

    @Override // p701v6.AbstractC13354a
    /* renamed from: n */
    public AbstractC13709a mo14591n() {
        this.f58397k = "Specified.General.Media.list";
        C12975l c12975l = new C12975l(this.f58352n, this.f58351m, this.f58354p, this.f58353o, this.f58350l);
        c12975l.m82456i(this.f60189e);
        return c12975l;
    }

    @Override // p635s7.AbstractC12758w
    /* renamed from: u */
    public Bundle mo15143u(String str) {
        if (str == null) {
            C1120a.m6676e("GetAllSimplifyInfoRequest", "responseBody is empty!");
            return C13721c.m82487c(101, "body is empty!");
        }
        try {
            FileModifyInfoResponse fileModifyInfoResponse = (FileModifyInfoResponse) new Gson().fromJson(str, FileModifyInfoResponse.class);
            if (fileModifyInfoResponse == null) {
                C1120a.m6676e("GetAllSimplifyInfoRequest", "fileModifyInfoResponse is null!");
                return C13721c.m82487c(130, "json syntax error!");
            }
            int code = fileModifyInfoResponse.getCode();
            String info = fileModifyInfoResponse.getInfo();
            String str2 = "file.querymodifyinfos: " + code + ", info: " + info + ", total: " + fileModifyInfoResponse.getTotal() + ", useScenario: " + this.f58350l;
            C1120a.m6677i("GetAllSimplifyInfoRequest", str2);
            Bundle bundle = new Bundle();
            bundle.putInt("code", code);
            bundle.putString("info", info);
            bundle.putString("errMsg", str2);
            bundle.putString("Cursor", fileModifyInfoResponse.getCursor());
            bundle.putBoolean("IsRecycleAlbum", this.f58354p);
            bundle.putParcelableArrayList("SimplifyInfoList", fileModifyInfoResponse.getFileList());
            bundle.putStringArrayList("AlbumIds", new ArrayList<>(this.f58353o));
            return bundle;
        } catch (JsonSyntaxException e10) {
            C1120a.m6676e("GetAllSimplifyInfoRequest", "FileModifyInfoResponse json syntax exception: " + e10.toString());
            return null;
        }
    }
}
