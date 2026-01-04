package p635s7;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.huawei.android.hicloud.album.service.hihttp.request.response.FileQueryResponse;
import com.huawei.android.hicloud.album.service.p075vo.FileData;
import com.huawei.uikit.hwadvancednumberpicker.utils.HwConstants;
import java.util.ArrayList;
import org.json.JSONObject;
import p031b7.C1120a;
import p650t7.C12968h0;
import p764x6.AbstractC13709a;

/* renamed from: s7.h0 */
/* loaded from: classes2.dex */
public class C12735h0 extends AbstractC12758w<FileQueryResponse> {

    /* renamed from: l */
    public String f58329l;

    /* renamed from: m */
    public String f58330m;

    /* renamed from: n */
    public String f58331n;

    /* renamed from: o */
    public int f58332o;

    public C12735h0(Context context, String str, String str2, String str3, String str4, int i10) throws Throwable {
        this.f60186b = context;
        this.f60189e = str;
        this.f58329l = str2;
        this.f58330m = str3;
        this.f58331n = str4;
        this.f58332o = i10;
        this.f60187c = m80109h("/JPJX/CloudPhoto");
        this.f58397k = "cloudphoto.file.queryPage";
        m80104c(str3);
    }

    @Override // p701v6.AbstractC13354a
    /* renamed from: a */
    public void mo14589a() throws Exception {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("ownerId", this.f58329l);
        jSONObject.put("albumId", this.f58330m);
        jSONObject.put("resource", this.f58331n);
        jSONObject.put("thumbHeight", HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA);
        jSONObject.put("thumbWidth", HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA);
        jSONObject.put("quality", 85);
        jSONObject.put("needUrl", false);
        jSONObject.put("start", this.f58332o);
        jSONObject.put("limit", 50);
        jSONObject.put("sort", "DESC");
        jSONObject.put("cmd", this.f58397k);
        this.f60188d = jSONObject.toString();
    }

    @Override // p701v6.AbstractC13354a
    /* renamed from: n */
    public AbstractC13709a mo14591n() {
        this.f58397k = "Share.Media.list";
        C12968h0 c12968h0 = new C12968h0(this.f58329l, this.f58330m, this.f58332o, 50, this.f60189e);
        c12968h0.m82456i(this.f60189e);
        return c12968h0;
    }

    @Override // p635s7.AbstractC12758w
    /* renamed from: u */
    public Bundle mo15143u(String str) {
        Bundle bundle = new Bundle();
        try {
            FileQueryResponse fileQueryResponse = (FileQueryResponse) new Gson().fromJson(str, FileQueryResponse.class);
            if (fileQueryResponse != null) {
                FileData[] fileList = fileQueryResponse.getFileList();
                ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
                if (fileList != null) {
                    C1120a.m6677i("ShareFilePageRequest", "cloudphoto.file.queryPage file size: " + fileList.length);
                    for (FileData fileData : fileList) {
                        if (fileData != null) {
                            JsonObject expand = fileData.getExpand();
                            if (expand != null) {
                                fileData.setExpandString(expand.toString());
                            }
                            arrayList.add(new FileData(fileData));
                        }
                    }
                }
                bundle.putParcelableArrayList("FileInfoList", arrayList);
                bundle.putInt("code", fileQueryResponse.getCode());
                bundle.putString("info", fileQueryResponse.getInfo());
                if (fileQueryResponse.isHasMore()) {
                    this.f58332o += 50;
                }
                bundle.putBoolean("HasMore", fileQueryResponse.isHasMore());
                bundle.putInt("Start", this.f58332o);
            }
            return bundle;
        } catch (JsonSyntaxException e10) {
            C1120a.m6676e("ShareFilePageRequest", "getResponseBundle jsonsyntax exception: " + e10.toString());
            return bundle;
        }
    }
}
