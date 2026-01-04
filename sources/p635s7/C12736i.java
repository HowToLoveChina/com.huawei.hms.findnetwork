package p635s7;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.android.hicloud.album.service.hihttp.request.response.FileDeleteResponse;
import com.huawei.android.hicloud.album.service.hihttp.request.response.FileFailRet;
import com.huawei.android.hicloud.album.service.logic.manager.SyncSessionManager;
import com.huawei.android.hicloud.album.service.p075vo.FileData;
import com.huawei.android.hicloud.album.service.p075vo.FileUpdatedResult;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import p031b7.C1120a;
import p031b7.C1122c;
import p650t7.C12965g;
import p764x6.AbstractC13709a;
import p765x7.C13720b;

/* renamed from: s7.i */
/* loaded from: classes2.dex */
public class C12736i extends AbstractC12758w {

    /* renamed from: l */
    public List<FileData> f58333l;

    public C12736i(Context context, String str, List<FileData> list, String str2) {
        this.f60186b = context;
        this.f60189e = str;
        this.f60187c = m80109h(C13720b.m82484e());
        this.f58397k = "cloudphoto.file.batchdelete";
        this.f58333l = list;
        m76585v(str2);
    }

    /* renamed from: x */
    public static Bundle m76562x(List<FileData> list, int i10, String str) {
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        Iterator<FileData> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new FileUpdatedResult(it.next().getUniqueId(), i10, str));
        }
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("FileUpdatedResultList", arrayList);
        bundle.putInt("code", i10);
        bundle.putString("info", str);
        return bundle;
    }

    /* renamed from: y */
    public static Bundle m76563y(String str, List<FileData> list, String str2, String str3) {
        if (TextUtils.isEmpty(str2)) {
            C1120a.m6676e(str, "body is empty!");
            return m76562x(list, 101, "body is empty!");
        }
        try {
            FileDeleteResponse fileDeleteResponse = (FileDeleteResponse) new Gson().fromJson(str2, FileDeleteResponse.class);
            if (fileDeleteResponse == null) {
                C1120a.m6676e(str, "getUpdateFilesBundle response is null!");
                return m76562x(list, 130, "json syntax error!");
            }
            if (fileDeleteResponse.getCode() != 0 && fileDeleteResponse.getCode() != 1 && fileDeleteResponse.getCode() != 31) {
                C1120a.m6676e(str, "other server error: " + fileDeleteResponse.getCode());
                return m76562x(list, fileDeleteResponse.getCode(), fileDeleteResponse.getInfo());
            }
            Bundle bundle = new Bundle();
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            String[] successList = fileDeleteResponse.getSuccessList();
            if (successList != null && successList.length > 0) {
                for (String str4 : successList) {
                    arrayList.add(new FileUpdatedResult(str4));
                }
            }
            FileFailRet[] failList = fileDeleteResponse.getFailList();
            if (failList != null && failList.length > 0) {
                StringBuilder sb2 = new StringBuilder("File fail lists");
                for (FileFailRet fileFailRet : failList) {
                    FileUpdatedResult fileUpdatedResult = new FileUpdatedResult(fileFailRet.getUniqueId(), fileFailRet.getErrCode(), fileFailRet.getErrMsg());
                    arrayList.add(fileUpdatedResult);
                    sb2.append(", uniqueId: ");
                    sb2.append(fileFailRet.getUniqueId());
                    sb2.append(", errCode: ");
                    sb2.append(fileFailRet.getErrCode());
                    sb2.append(", errMsg: ");
                    sb2.append(fileFailRet.getErrMsg());
                    sb2.append(System.lineSeparator());
                    SyncSessionManager.m15153t().m15177a("cloudphoto.file.batchdelete", str3, fileFailRet.getUniqueId());
                    if (SyncSessionManager.m15153t().m15155B("cloudphoto.file.batchdelete", str3, fileFailRet.getUniqueId())) {
                        fileUpdatedResult.setErrCode(140);
                        fileUpdatedResult.setErrMsg("delete the same files.");
                    }
                }
                bundle.putString("errMsg", Arrays.toString(failList));
                C1120a.m6676e(str, sb2.toString());
            }
            bundle.putParcelableArrayList("FileUpdatedResultList", arrayList);
            bundle.putInt("code", fileDeleteResponse.getCode());
            bundle.putString("info", fileDeleteResponse.getInfo());
            return bundle;
        } catch (JsonSyntaxException e10) {
            C1120a.m6676e(str, "getResponseBundle json syntax exception: " + e10.toString());
            return m76562x(list, 130, "json syntax error!");
        }
    }

    @Override // p701v6.AbstractC13354a
    /* renamed from: a */
    public void mo14589a() throws Exception {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("cmd", this.f58397k);
        JSONArray jSONArray = new JSONArray();
        for (FileData fileData : this.f58333l) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(ContentRecord.UNIQUE_ID, fileData.getUniqueId());
            jSONObject2.put("albumId", fileData.getAlbumId());
            jSONArray.put(jSONObject2);
        }
        jSONObject.put("deleteFileList", jSONArray);
        this.f60188d = jSONObject.toString();
    }

    @Override // p701v6.AbstractC13354a
    /* renamed from: n */
    public AbstractC13709a mo14591n() {
        this.f58397k = "General.Media.delete";
        C12965g c12965g = new C12965g(this.f58333l, this.f60189e);
        c12965g.m82456i(this.f60189e);
        return c12965g;
    }

    @Override // p635s7.AbstractC12758w
    /* renamed from: u */
    public Bundle mo15143u(String str) {
        m76564w();
        return m76563y("DeleteFilesRequest", this.f58333l, str, this.f60189e);
    }

    /* renamed from: w */
    public final void m76564w() {
        Iterator<FileData> it = this.f58333l.iterator();
        while (it.hasNext()) {
            String strM6841w = C1122c.m6841w(it.next());
            Integer numM15193q = SyncSessionManager.m15153t().m15193q(strM6841w, 3);
            int iIntValue = 1;
            if (numM15193q != null) {
                iIntValue = 1 + numM15193q.intValue();
            }
            SyncSessionManager.m15153t().m15166M(strM6841w, Integer.valueOf(iIntValue), 3);
        }
    }
}
