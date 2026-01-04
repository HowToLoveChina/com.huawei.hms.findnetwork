package p635s7;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.android.hicloud.album.service.hihttp.request.response.FileQueryResponse;
import com.huawei.android.hicloud.album.service.p075vo.FileData;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p031b7.C1120a;
import p312g8.C9894e;
import p650t7.C12973k;
import p764x6.AbstractC13709a;
import p765x7.C13720b;
import p765x7.C13721c;

/* renamed from: s7.k */
/* loaded from: classes2.dex */
public class C12740k extends AbstractC12758w {

    /* renamed from: l */
    public int f58343l;

    /* renamed from: m */
    public List<String> f58344m;

    /* renamed from: n */
    public int f58345n;

    /* renamed from: o */
    public boolean f58346o;

    public C12740k(Context context, String str, List<String> list, int i10, int i11) {
        this.f58345n = 500;
        this.f58346o = false;
        this.f60186b = context;
        this.f60189e = str;
        this.f60187c = m80109h(C13720b.m82484e());
        this.f58397k = "cloudphoto.file.batchquery";
        this.f58344m = list;
        this.f58345n = i10;
        this.f58343l = i11;
        this.f58346o = m76570y(list);
    }

    /* renamed from: w */
    public static Bundle m76568w(String str, boolean z10) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            C1120a.m6676e("GetAllFilesRequest", "getFileQueryBundle body is empty!");
            return C13721c.m82487c(101, "body is empty!");
        }
        try {
            FileQueryResponse fileQueryResponse = (FileQueryResponse) new Gson().fromJson(str, FileQueryResponse.class);
            if (fileQueryResponse == null) {
                C1120a.m6676e("GetAllFilesRequest", "getFileQueryBundle response is null!");
                return C13721c.m82487c(130, "json syntax error!");
            }
            StringBuffer stringBuffer = new StringBuffer("");
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            FileData[] fileList = fileQueryResponse.getFileList();
            if (fileList != null && fileList.length > 0) {
                for (FileData fileData : fileList) {
                    if (fileData.getExpand() != null) {
                        C9894e.m61407j(fileData);
                        fileData.setExpandString(fileData.getExpand().toString());
                    }
                    if (TextUtils.isEmpty(fileData.getAlbumId()) || TextUtils.isEmpty(fileData.getHash())) {
                        C1120a.m6678w("GetAllFilesRequest", "getFileQueryBundle: AlbumId of Hash is empty");
                    }
                    FileData fileData2 = new FileData(fileData);
                    arrayList.add(fileData2);
                    stringBuffer.append(m76569x(fileData2.getUniqueId(), 6));
                    stringBuffer.append(",");
                }
            }
            StringBuffer stringBuffer2 = new StringBuffer("code:");
            stringBuffer2.append(fileQueryResponse.getCode());
            stringBuffer2.append(" info :");
            stringBuffer2.append(fileQueryResponse.getInfo());
            stringBuffer2.append(" size:");
            stringBuffer2.append(arrayList.size());
            stringBuffer2.append(" total:");
            stringBuffer2.append(fileQueryResponse.getTotal());
            stringBuffer2.append(" latestVersion:");
            stringBuffer2.append(fileQueryResponse.getLatestVersion());
            stringBuffer2.append(" hasMore:");
            stringBuffer2.append(fileQueryResponse.isHasMore());
            stringBuffer2.append(" cursor:");
            stringBuffer2.append(fileQueryResponse.getCursor());
            stringBuffer2.append(" uniqueIds:");
            stringBuffer2.append(stringBuffer);
            C1120a.m6677i("GetAllFilesRequest", stringBuffer2.toString());
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("FileInfoList", arrayList);
            bundle.putInt("code", fileQueryResponse.getCode());
            bundle.putString("info", fileQueryResponse.getInfo());
            bundle.putString("Cursor", fileQueryResponse.getCursor());
            bundle.putInt("Total", fileQueryResponse.getTotal());
            bundle.putBoolean("HasMore", fileQueryResponse.isHasMore());
            bundle.putLong("LatestVersion", fileQueryResponse.getLatestVersion());
            String strM76569x = m76569x(fileQueryResponse.getCursor(), 6);
            StringBuffer stringBuffer3 = new StringBuffer("size:");
            stringBuffer3.append(arrayList.size());
            stringBuffer3.append(" total:");
            stringBuffer3.append(fileQueryResponse.getTotal());
            stringBuffer3.append(" hasMore:");
            stringBuffer3.append(fileQueryResponse.isHasMore());
            stringBuffer3.append(" cursor:");
            stringBuffer3.append(strM76569x);
            stringBuffer3.append(" latestVersion:");
            stringBuffer3.append(fileQueryResponse.getLatestVersion());
            bundle.putString("errMsg", stringBuffer3.toString());
            bundle.putBoolean("IsRecycleAlbum", z10);
            return bundle;
        } catch (JsonSyntaxException e10) {
            C1120a.m6676e("GetAllFilesRequest", "getFileQueryBundle json syntax exception: " + e10.toString());
            return null;
        }
    }

    /* renamed from: x */
    public static String m76569x(String str, int i10) {
        return TextUtils.isEmpty(str) ? "" : str.length() > i10 ? str.substring(str.length() - i10, str.length()) : str;
    }

    /* renamed from: y */
    public static boolean m76570y(List<String> list) {
        return list != null && list.size() > 0 && TextUtils.equals("default-album-3", list.get(0));
    }

    @Override // p701v6.AbstractC13354a
    /* renamed from: a */
    public void mo14589a() throws Exception {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("cmd", this.f58397k);
        List<String> list = this.f58344m;
        if (list != null && !list.isEmpty()) {
            jSONObject.put("albumIds", new JSONArray((Collection) this.f58344m));
        }
        jSONObject.put("needUrl", false);
        jSONObject.put("limit", this.f58345n);
        jSONObject.put("offset", this.f58343l);
        this.f60188d = jSONObject.toString();
    }

    @Override // p701v6.AbstractC13354a
    /* renamed from: n */
    public AbstractC13709a mo14591n() {
        this.f58397k = "General.Media.list";
        C12973k c12973k = new C12973k(this.f58343l, this.f58345n, this.f58346o);
        c12973k.m82456i(this.f60189e);
        return c12973k;
    }

    @Override // p635s7.AbstractC12758w
    /* renamed from: u */
    public Bundle mo15143u(String str) throws JSONException {
        Bundle bundleM76568w = m76568w(str, this.f58346o);
        if (bundleM76568w != null) {
            bundleM76568w.putString("errMsg", this.f58343l + "_" + bundleM76568w.getString("errMsg"));
        }
        return bundleM76568w;
    }
}
