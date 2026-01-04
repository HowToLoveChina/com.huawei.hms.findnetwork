package p635s7;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.android.hicloud.album.service.hihttp.request.response.FileCopyResponse;
import com.huawei.android.hicloud.album.service.hihttp.request.response.FileCopyRet;
import com.huawei.android.hicloud.album.service.hihttp.request.response.FileFailRet;
import com.huawei.android.hicloud.album.service.logic.manager.SyncSessionManager;
import com.huawei.android.hicloud.album.service.p075vo.FileData;
import com.huawei.android.hicloud.album.service.p075vo.FileUpdatedResult;
import com.huawei.android.hicloud.album.service.p075vo.Version;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
import p031b7.C1120a;
import p031b7.C1122c;
import p650t7.C12959d;
import p764x6.AbstractC13709a;
import p765x7.C13720b;

/* renamed from: s7.f */
/* loaded from: classes2.dex */
public class C12730f extends AbstractC12758w {

    /* renamed from: l */
    public List<FileData> f58313l;

    /* renamed from: m */
    public List<FileUpdatedResult> f58314m;

    public C12730f(Context context, String str, List<FileData> list, String str2, List<FileUpdatedResult> list2) {
        this.f60186b = context;
        this.f60189e = str;
        this.f60187c = m80109h(C13720b.m82484e());
        this.f58397k = "cloudphoto.file.batchcopy";
        this.f58313l = list;
        this.f58314m = list2;
        m76585v(str2);
    }

    /* renamed from: A */
    private static void m76551A(ArrayList<FileUpdatedResult> arrayList, List<FileData> list) {
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
                    if (!TextUtils.isEmpty(next2.getLocalId()) && next2.getLocalId().equals(next.getLocalId())) {
                        next.setTimestamp(next2.getTimestamp());
                        break;
                    }
                }
            }
        }
    }

    /* renamed from: x */
    public static Bundle m76552x(List<FileData> list, List<FileUpdatedResult> list2, int i10, String str) {
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        for (FileData fileData : list) {
            arrayList.add(new FileUpdatedResult(fileData.getLocalId(), fileData.getUniqueId(), i10, str));
        }
        if (list2 != null && list2.size() > 0) {
            arrayList.addAll(list2);
        }
        m76551A(arrayList, list);
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("FileUpdatedResultList", arrayList);
        bundle.putInt("code", i10);
        bundle.putString("info", str);
        return bundle;
    }

    @Override // p701v6.AbstractC13354a
    /* renamed from: a */
    public void mo14589a() throws Exception {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("cmd", this.f58397k);
        if (Version.isSupportCheckHash()) {
            jSONObject.put("checkhash", true);
        }
        Gson gson = new Gson();
        JSONObject jSONObject2 = new JSONObject();
        for (FileData fileData : this.f58313l) {
            JSONObject jSONObjectM76546y = C12721a0.m76546y(this.f60186b, gson.toJson(fileData), fileData);
            if (jSONObjectM76546y == null || TextUtils.isEmpty(fileData.getLocalId())) {
                C1120a.m6676e("CopyFilesRequest", "localId is empty!");
            } else {
                jSONObject2.put(fileData.getLocalId(), jSONObjectM76546y);
            }
        }
        jSONObject.put("galleryVer", C1122c.m6833t0(this.f60186b));
        jSONObject.put("fileInfoMap", jSONObject2);
        this.f60188d = jSONObject.toString();
    }

    @Override // p701v6.AbstractC13354a
    /* renamed from: n */
    public AbstractC13709a mo14591n() {
        this.f58397k = "General.Media.copy";
        C12959d c12959d = new C12959d(this.f58313l, this.f58314m);
        c12959d.m82456i(this.f60189e);
        return c12959d;
    }

    @Override // p635s7.AbstractC12758w
    /* renamed from: u */
    public Bundle mo15143u(String str) {
        m76553w();
        if (TextUtils.isEmpty(str)) {
            C1120a.m6676e("CopyFilesRequest", "body is empty!");
            return m76552x(this.f58313l, this.f58314m, 101, "body is empty!");
        }
        try {
            FileCopyResponse fileCopyResponse = (FileCopyResponse) new Gson().fromJson(str, FileCopyResponse.class);
            if (fileCopyResponse == null) {
                C1120a.m6676e("CopyFilesRequest", "getUpdateFilesBundle response is null!");
                return m76552x(this.f58313l, this.f58314m, 130, "json syntax error!");
            }
            if (fileCopyResponse.getCode() != 0 && fileCopyResponse.getCode() != 1 && fileCopyResponse.getCode() != 31) {
                C1120a.m6676e("CopyFilesRequest", "other server error: " + fileCopyResponse.getCode());
                return m76552x(this.f58313l, this.f58314m, fileCopyResponse.getCode(), fileCopyResponse.getInfo());
            }
            Bundle bundle = new Bundle();
            ArrayList<FileUpdatedResult> arrayList = new ArrayList<>();
            m76555z(fileCopyResponse, arrayList);
            m76554y(fileCopyResponse, arrayList);
            List<FileUpdatedResult> list = this.f58314m;
            if (list != null && list.size() > 0) {
                arrayList.addAll(this.f58314m);
            }
            m76551A(arrayList, this.f58313l);
            bundle.putParcelableArrayList("FileUpdatedResultList", arrayList);
            bundle.putInt("code", fileCopyResponse.getCode());
            bundle.putString("info", fileCopyResponse.getInfo());
            return bundle;
        } catch (JsonSyntaxException e10) {
            C1120a.m6676e("CopyFilesRequest", "getResponseBundle json syntax exception: " + e10.toString());
            return m76552x(this.f58313l, this.f58314m, 130, "json syntax error!");
        }
    }

    /* renamed from: w */
    public final void m76553w() {
        Iterator<FileData> it = this.f58313l.iterator();
        while (it.hasNext()) {
            String strM6841w = C1122c.m6841w(it.next());
            Integer numM15193q = SyncSessionManager.m15153t().m15193q(strM6841w, 2);
            int iIntValue = 1;
            if (numM15193q != null) {
                iIntValue = 1 + numM15193q.intValue();
            }
            SyncSessionManager.m15153t().m15166M(strM6841w, Integer.valueOf(iIntValue), 2);
        }
    }

    /* renamed from: y */
    public final void m76554y(FileCopyResponse fileCopyResponse, ArrayList<FileUpdatedResult> arrayList) {
        Map<String, FileFailRet> failList = fileCopyResponse.getFailList();
        if (failList == null || failList.size() == 0) {
            return;
        }
        StringBuilder sb2 = new StringBuilder("File fail lists");
        Iterator<FileData> it = this.f58313l.iterator();
        while (it.hasNext()) {
            String localId = it.next().getLocalId();
            if (!TextUtils.isEmpty(localId) && failList.containsKey(localId)) {
                FileFailRet fileFailRet = failList.get(localId);
                if (fileFailRet == null) {
                    sb2.append(", fileFailRet is null!");
                    sb2.append(System.lineSeparator());
                } else {
                    arrayList.add(new FileUpdatedResult(localId, fileFailRet.getUniqueId(), fileFailRet.getErrCode(), fileFailRet.getErrMsg()));
                    sb2.append(", uniqueId: ");
                    sb2.append(fileFailRet.getUniqueId());
                    sb2.append(", errCode: ");
                    sb2.append(fileFailRet.getErrCode());
                    sb2.append(", errMsg: ");
                    sb2.append(fileFailRet.getErrMsg());
                    sb2.append(System.lineSeparator());
                }
            }
        }
        C1120a.m6676e("CopyFilesRequest", sb2.toString());
    }

    /* renamed from: z */
    public final void m76555z(FileCopyResponse fileCopyResponse, ArrayList<FileUpdatedResult> arrayList) {
        FileCopyRet[] successList = fileCopyResponse.getSuccessList();
        if (successList == null || successList.length <= 0) {
            return;
        }
        for (FileCopyRet fileCopyRet : successList) {
            arrayList.add(new FileUpdatedResult(fileCopyRet.getFileName(), fileCopyRet.getUniqueId(), fileCopyRet.getLocalId(), fileCopyRet.getRecycletime(), fileCopyRet.getSdsmtime(), true));
        }
    }
}
