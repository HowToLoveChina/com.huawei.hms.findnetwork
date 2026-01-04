package p635s7;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.android.hicloud.album.service.hihttp.request.response.FileFailRet;
import com.huawei.android.hicloud.album.service.hihttp.request.response.FileSuccessRet;
import com.huawei.android.hicloud.album.service.hihttp.request.response.FileUpdateResponse;
import com.huawei.android.hicloud.album.service.logic.manager.SyncSessionManager;
import com.huawei.android.hicloud.album.service.p075vo.FileData;
import com.huawei.android.hicloud.album.service.p075vo.FileUpdatedResult;
import com.huawei.android.hicloud.album.service.p075vo.Version;
import com.huawei.android.hicloud.sync.protocol.SyncProtocol;
import com.huawei.hicloud.notification.manager.HicloudH5ConfigManager;
import hu.C10343b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p031b7.C1120a;
import p031b7.C1122c;
import p031b7.C1125f;
import p312g8.C9894e;
import p650t7.C12954a0;
import p709vj.C13452e;
import p764x6.AbstractC13709a;
import p765x7.C13720b;

/* renamed from: s7.a0 */
/* loaded from: classes2.dex */
public class C12721a0 extends AbstractC12758w {

    /* renamed from: l */
    public List<FileData> f58290l;

    public C12721a0(Context context, String str, List<FileData> list, String str2) {
        this.f60186b = context;
        this.f60189e = str;
        this.f60187c = m80109h(C13720b.m82484e());
        this.f58397k = "cloudphoto.file.batchupdate";
        this.f58290l = list;
        m76585v(str2);
    }

    /* renamed from: A */
    public static Bundle m76542A(List<FileData> list, int i10, String str) {
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        Iterator<FileData> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new FileUpdatedResult(it.next().getUniqueId(), i10, str));
        }
        m76544C(arrayList, list);
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("FileUpdatedResultList", arrayList);
        bundle.putString("info", str);
        bundle.putInt("code", i10);
        return bundle;
    }

    /* renamed from: B */
    public static Bundle m76543B(String str, List<FileData> list, String str2) {
        if (TextUtils.isEmpty(str2)) {
            C1120a.m6676e(str, "body is empty!");
            return m76542A(list, 101, "body is empty!");
        }
        try {
            FileUpdateResponse fileUpdateResponse = (FileUpdateResponse) new Gson().fromJson(str2, FileUpdateResponse.class);
            if (fileUpdateResponse == null) {
                C1120a.m6676e(str, "getUpdateFilesBundle response is null!");
                return m76542A(list, 130, "json syntax error!");
            }
            if (fileUpdateResponse.getCode() != 0 && fileUpdateResponse.getCode() != 1 && fileUpdateResponse.getCode() != 31) {
                C1120a.m6676e(str, "other server error: " + fileUpdateResponse.getCode());
                return m76542A(list, fileUpdateResponse.getCode(), fileUpdateResponse.getInfo());
            }
            Bundle bundle = new Bundle();
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            FileSuccessRet[] successList = fileUpdateResponse.getSuccessList();
            if (successList != null && successList.length > 0) {
                for (FileSuccessRet fileSuccessRet : successList) {
                    arrayList.add(new FileUpdatedResult(fileSuccessRet.getFileName(), fileSuccessRet.getUniqueId(), fileSuccessRet.getAlbumId(), fileSuccessRet.getAlbumName(), fileSuccessRet.getLpath()));
                }
            }
            FileFailRet[] failList = fileUpdateResponse.getFailList();
            if (failList != null && failList.length > 0) {
                StringBuilder sb2 = new StringBuilder("File fail lists");
                for (FileFailRet fileFailRet : failList) {
                    arrayList.add(new FileUpdatedResult(fileFailRet.getUniqueId(), fileFailRet.getErrCode(), fileFailRet.getErrMsg()));
                    sb2.append(", uniqueId: ");
                    sb2.append(fileFailRet.getUniqueId());
                    sb2.append(", errCode: ");
                    sb2.append(fileFailRet.getErrCode());
                    sb2.append(", errMsg: ");
                    sb2.append(fileFailRet.getErrMsg());
                    sb2.append(System.lineSeparator());
                }
                bundle.putString("errMsg", failList.length + " " + failList[0].getErrCode() + " " + failList[0].getErrMsg());
                C1120a.m6676e(str, sb2.toString());
            }
            m76544C(arrayList, list);
            bundle.putParcelableArrayList("FileUpdatedResultList", arrayList);
            bundle.putInt("code", fileUpdateResponse.getCode());
            bundle.putString("info", fileUpdateResponse.getInfo());
            return bundle;
        } catch (JsonSyntaxException e10) {
            C1120a.m6676e(str, "getResponseBundle json syntax exception: " + e10.toString());
            return m76542A(list, 130, "json syntax error!");
        }
    }

    /* renamed from: C */
    public static void m76544C(ArrayList<FileUpdatedResult> arrayList, List<FileData> list) {
        if (!Version.isSupportTimeStamp() || arrayList == null || arrayList.size() == 0 || list == null || list.size() == 0) {
            return;
        }
        Iterator<FileUpdatedResult> it = arrayList.iterator();
        while (it.hasNext()) {
            FileUpdatedResult next = it.next();
            Iterator<FileData> it2 = list.iterator();
            while (true) {
                if (it2.hasNext()) {
                    FileData next2 = it2.next();
                    if (!TextUtils.isEmpty(next2.getUniqueId()) && next2.getUniqueId().equals(next.getUniqueId())) {
                        next.setTimestamp(next2.getTimestamp());
                        next.setLocalId(next2.getLocalId());
                        next.setLocalRealPath(next2.getLocalRealPath());
                        if (TextUtils.isEmpty(next.getAlbumId()) && !TextUtils.isEmpty(next2.getAlbumId())) {
                            next.setAlbumId(next2.getAlbumId());
                        }
                    }
                }
            }
        }
    }

    /* renamed from: x */
    public static boolean m76545x(Context context, FileData fileData, JSONObject jSONObject) throws Throwable {
        if (fileData == null || jSONObject == null) {
            return false;
        }
        if (!jSONObject.has(HicloudH5ConfigManager.KEY_HASH)) {
            C1120a.m6677i("ModifyFilesRequest", "cloudphoto.file.batchupdate has no hash in expand, so drop it");
            return false;
        }
        if (!jSONObject.has(SyncProtocol.Constant.DEK)) {
            C1120a.m6677i("ModifyFilesRequest", "cloudphoto.file.batchupdate has no dek in expand, so drop it");
            return false;
        }
        if (!jSONObject.has("createrAccount")) {
            C1120a.m6677i("ModifyFilesRequest", "cloudphoto.file.batchupdate has no createrAccount in expand, so drop it");
            return false;
        }
        if (!jSONObject.has("position")) {
            C1120a.m6677i("ModifyFilesRequest", "cloudphoto.file.batchupdate has no position in expand, so drop it");
            return false;
        }
        if (!jSONObject.has("createrId")) {
            jSONObject.put("createrId", String.valueOf(C13452e.m80781L().m80971t0()));
        }
        if (!TextUtils.isEmpty(fileData.getLocalRealPath())) {
            if (!jSONObject.has("fileCreateTime")) {
                long jM6888i = C1125f.m6888i(fileData.getLocalRealPath());
                if (jM6888i != 0) {
                    jSONObject.put("fileCreateTime", String.valueOf(jM6888i));
                }
            }
            if (!jSONObject.has("rotate")) {
                String strM6889j = C1125f.m6889j(fileData.getLocalRealPath());
                if (!TextUtils.isEmpty(strM6889j)) {
                    jSONObject.put("rotate", strM6889j);
                }
            }
        }
        return true;
    }

    /* renamed from: y */
    public static JSONObject m76546y(Context context, String str, FileData fileData) throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            C9894e.m61408k(context, fileData);
            if (!TextUtils.isEmpty(fileData.getExpandString())) {
                JSONObject jSONObject2 = new JSONObject(fileData.getExpandString());
                if (TextUtils.isEmpty(fileData.getFileId()) || !fileData.getFileId().equals("NMD")) {
                    jSONObject.remove("expandString");
                    jSONObject.put("expand", jSONObject2);
                } else {
                    if (m76545x(context, fileData, jSONObject2)) {
                        jSONObject.put("expand", jSONObject2);
                    }
                    jSONObject.remove("expandString");
                }
            }
            return jSONObject;
        } catch (JSONException unused) {
            C1120a.m6676e("ModifyFilesRequest", "dealExpandString error");
            return null;
        }
    }

    @Override // p701v6.AbstractC13354a
    /* renamed from: a */
    public void mo14589a() throws Exception {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("cmd", this.f58397k);
        jSONObject.put("newClient", true);
        jSONObject.put("checkhash", true);
        Gson gson = new Gson();
        JSONArray jSONArray = new JSONArray();
        for (FileData fileData : this.f58290l) {
            JSONObject jSONObjectM76546y = m76546y(this.f60186b, gson.toJson(fileData), fileData);
            if (jSONObjectM76546y != null) {
                jSONArray.put(jSONObjectM76546y);
            }
        }
        jSONObject.put("galleryVer", C1122c.m6833t0(this.f60186b));
        jSONObject.put("fileInfoList", jSONArray);
        this.f60188d = jSONObject.toString();
    }

    @Override // p701v6.AbstractC13354a
    /* renamed from: n */
    public AbstractC13709a mo14591n() {
        this.f58397k = "General.Media.update.patchmetadata";
        C12954a0 c12954a0 = new C12954a0(this.f58290l, this.f60189e);
        c12954a0.m82456i(this.f60189e);
        return c12954a0;
    }

    @Override // p635s7.AbstractC12758w
    /* renamed from: u */
    public Bundle mo15143u(String str) {
        m76547w();
        Bundle bundleM76543B = m76543B("ModifyFilesRequest", this.f58290l, str);
        ArrayList arrayListM63692n = new C10343b(bundleM76543B).m63692n("FileUpdatedResultList");
        if (arrayListM63692n != null) {
            Iterator it = arrayListM63692n.iterator();
            while (it.hasNext()) {
                FileUpdatedResult fileUpdatedResult = (FileUpdatedResult) it.next();
                if (fileUpdatedResult.getErrCode() == 302) {
                    SyncSessionManager.m15153t().m15177a("cloudphoto.file.batchupdate", this.f60189e, m76548z(fileUpdatedResult.getUniqueId()));
                }
            }
        }
        return bundleM76543B;
    }

    /* renamed from: w */
    public final void m76547w() {
        Iterator<FileData> it = this.f58290l.iterator();
        while (it.hasNext()) {
            String strM6841w = C1122c.m6841w(it.next());
            Integer numM15193q = SyncSessionManager.m15153t().m15193q(strM6841w, 1);
            SyncSessionManager.m15153t().m15166M(strM6841w, Integer.valueOf(numM15193q == null ? 1 : numM15193q.intValue() + 1), 1);
        }
    }

    /* renamed from: z */
    public final String m76548z(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (FileData fileData : this.f58290l) {
            if (str.equals(fileData.getUniqueId())) {
                return fileData.getAlbumId();
            }
        }
        return null;
    }
}
