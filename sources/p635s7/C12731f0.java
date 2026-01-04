package p635s7;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.android.hicloud.album.service.hihttp.request.response.FileDeleteResponse;
import com.huawei.android.hicloud.album.service.hihttp.request.response.FileFailRet;
import com.huawei.android.hicloud.album.service.p075vo.FileData;
import com.huawei.android.hicloud.album.service.p075vo.ShareFileUpdatedResult;
import com.huawei.hicloud.notification.manager.HicloudH5ConfigManager;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import p031b7.C1120a;
import p650t7.C12964f0;
import p764x6.AbstractC13709a;
import p765x7.C13720b;

/* renamed from: s7.f0 */
/* loaded from: classes2.dex */
public class C12731f0 extends AbstractC12758w<FileDeleteResponse> {

    /* renamed from: l */
    public List<FileData> f58315l;

    /* renamed from: m */
    public String f58316m;

    /* renamed from: n */
    public String f58317n;

    public C12731f0(Context context, String str, String str2, String str3, List<FileData> list) throws Throwable {
        this.f60186b = context;
        this.f60189e = str;
        this.f58316m = str2;
        this.f58317n = str3;
        this.f58315l = list;
        this.f60187c = m80109h(C13720b.m82484e());
        this.f58397k = "cloudphoto.file.delete";
        m80104c(str2);
    }

    @Override // p701v6.AbstractC13354a
    /* renamed from: a */
    public void mo14589a() throws Exception {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        List<FileData> list = this.f58315l;
        if (list != null) {
            for (FileData fileData : list) {
                if (fileData != null) {
                    jSONArray.put(fileData.getHash());
                }
            }
        }
        jSONObject.put("albumId", this.f58316m);
        jSONObject.put("ownerId", this.f58317n);
        jSONObject.put(HicloudH5ConfigManager.KEY_HASH, jSONArray);
        jSONObject.put("recycle", "0");
        jSONObject.put("cmd", this.f58397k);
        this.f60188d = jSONObject.toString();
    }

    @Override // p701v6.AbstractC13354a
    /* renamed from: n */
    public AbstractC13709a mo14591n() {
        this.f58397k = "Share.Media.delete";
        C12964f0 c12964f0 = new C12964f0(this.f58315l, this.f58317n);
        c12964f0.m82456i(this.f60189e);
        return c12964f0;
    }

    @Override // p635s7.AbstractC12758w
    /* renamed from: u */
    public Bundle mo15143u(String str) {
        if (TextUtils.isEmpty(str)) {
            C1120a.m6676e("ShareFileDeleteRequest", "body is empty!");
            return m76556w(101, "body is empty!");
        }
        Bundle bundle = new Bundle();
        try {
            FileDeleteResponse fileDeleteResponse = (FileDeleteResponse) new Gson().fromJson(str, FileDeleteResponse.class);
            if (fileDeleteResponse == null) {
                return m76556w(130, "json syntax error!");
            }
            int code = fileDeleteResponse.getCode();
            String info = fileDeleteResponse.getInfo();
            if (code != 0) {
                return m76556w(code, info);
            }
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            String[] successList = fileDeleteResponse.getSuccessList();
            if (successList != null) {
                int length = successList.length;
                C1120a.m6677i("ShareFileDeleteRequest", "cloudphoto.file.delete success size: " + length);
                for (int i10 = 0; i10 < length; i10++) {
                    arrayList.add(new ShareFileUpdatedResult(successList[i10], this.f58316m, this.f58317n));
                }
            }
            FileFailRet[] failList = fileDeleteResponse.getFailList();
            if (failList != null) {
                C1120a.m6677i("ShareFileDeleteRequest", "cloudphoto.file.delete fail size: " + failList.length);
                for (FileFailRet fileFailRet : failList) {
                    if (fileFailRet != null) {
                        arrayList.add(new ShareFileUpdatedResult(fileFailRet.getHash(), this.f58316m, this.f58317n, fileFailRet.getErrCode(), fileFailRet.getErrMsg()));
                    }
                }
            }
            bundle.putParcelableArrayList("ShareFileUpdatedResult", arrayList);
            bundle.putInt("code", code);
            bundle.putString("info", info);
            return bundle;
        } catch (JsonSyntaxException e10) {
            C1120a.m6676e("ShareFileDeleteRequest", "getResponseBundle jsonsyntax exception: " + e10.toString());
            return m76556w(130, "json syntax error!");
        }
    }

    /* renamed from: w */
    public final Bundle m76556w(int i10, String str) {
        Bundle bundle = new Bundle();
        bundle.putInt("code", i10);
        bundle.putString("info", str);
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        List<FileData> list = this.f58315l;
        if (list != null) {
            for (FileData fileData : list) {
                arrayList.add(new ShareFileUpdatedResult(fileData.getHash(), fileData.getAlbumId(), this.f58317n, i10, str));
            }
        }
        bundle.putParcelableArrayList("ShareFileUpdatedResult", arrayList);
        return bundle;
    }
}
