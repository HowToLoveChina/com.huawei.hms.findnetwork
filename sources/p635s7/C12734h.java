package p635s7;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.android.hicloud.album.service.hihttp.request.response.AlbumFailList;
import com.huawei.android.hicloud.album.service.hihttp.request.response.AlbumUpdateResponse;
import com.huawei.android.hicloud.album.service.p075vo.AlbumUpdatedResult;
import com.huawei.android.hicloud.album.service.p075vo.GeneralAlbumData;
import com.huawei.android.hicloud.album.service.p075vo.Version;
import com.huawei.hms.network.embedded.C6010m7;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import p031b7.C1120a;
import p650t7.C12963f;
import p764x6.AbstractC13709a;
import p765x7.C13720b;

/* renamed from: s7.h */
/* loaded from: classes2.dex */
public class C12734h extends AbstractC12758w {

    /* renamed from: l */
    public List<String> f58328l;

    public C12734h(Context context, String str, List<String> list, String str2) {
        this.f60186b = context;
        this.f60189e = str;
        this.f60187c = m80109h(C13720b.m82484e());
        this.f58397k = "cloudphoto.album.batchdelete";
        this.f58328l = list;
        m76585v(str2);
    }

    /* renamed from: A */
    public static void m76557A(ArrayList<AlbumUpdatedResult> arrayList, List<GeneralAlbumData> list) {
        if (!Version.isSupportTimeStamp() || arrayList == null || arrayList.size() == 0 || list == null || list.size() == 0) {
            return;
        }
        Iterator<AlbumUpdatedResult> it = arrayList.iterator();
        while (it.hasNext()) {
            AlbumUpdatedResult next = it.next();
            Iterator<GeneralAlbumData> it2 = list.iterator();
            while (true) {
                if (it2.hasNext()) {
                    GeneralAlbumData next2 = it2.next();
                    if (!TextUtils.isEmpty(next2.getAlbumId()) && next2.getAlbumId().equals(next.getAlbumId())) {
                        next.setTimestamp(next2.getTimestamp());
                        break;
                    }
                }
            }
        }
    }

    /* renamed from: w */
    public static String m76558w(AlbumFailList[] albumFailListArr, List<GeneralAlbumData> list) {
        if (list == null) {
            return Arrays.toString(albumFailListArr);
        }
        int length = albumFailListArr.length - 1;
        if (length == -1) {
            return C6010m7.f27500n;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append('[');
        int i10 = 0;
        while (true) {
            sb2.append(String.valueOf(albumFailListArr[i10]));
            Iterator<GeneralAlbumData> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                GeneralAlbumData next = it.next();
                if (!TextUtils.isEmpty(albumFailListArr[i10].getAlbumId())) {
                    if (albumFailListArr[i10].getAlbumId().equals(next.getAlbumId())) {
                        sb2.append(" ");
                        sb2.append(next.getAlbumName());
                        sb2.append(" ");
                        sb2.append(next.getLpath());
                    }
                }
            }
            if (i10 == length) {
                sb2.append(']');
                return sb2.toString();
            }
            sb2.append(", ");
            i10++;
        }
    }

    /* renamed from: x */
    public static Bundle m76559x(String str, List<GeneralAlbumData> list, String str2) {
        return m76560y(str, list, null, str2);
    }

    /* renamed from: y */
    public static Bundle m76560y(String str, List<GeneralAlbumData> list, List<String> list2, String str2) {
        if (TextUtils.isEmpty(str2)) {
            C1120a.m6676e(str, "response body is null!");
            return m76561z(list, list2, 101, "body is empty!");
        }
        try {
            AlbumUpdateResponse albumUpdateResponse = (AlbumUpdateResponse) new Gson().fromJson(str2, AlbumUpdateResponse.class);
            if (albumUpdateResponse == null) {
                C1120a.m6676e(str, "response is null!");
                return m76561z(list, list2, 130, "json syntax error!");
            }
            if (albumUpdateResponse.getCode() != 0 && albumUpdateResponse.getCode() != 1 && albumUpdateResponse.getCode() != 31) {
                C1120a.m6676e(str, "other server error: " + albumUpdateResponse.getCode());
                return m76561z(list, list2, albumUpdateResponse.getCode(), albumUpdateResponse.getInfo());
            }
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            String[] successList = albumUpdateResponse.getSuccessList();
            if (successList != null && successList.length > 0) {
                for (String str3 : successList) {
                    arrayList.add(new AlbumUpdatedResult(null, str3, 0, null));
                }
            }
            Bundle bundle = new Bundle();
            AlbumFailList[] failList = albumUpdateResponse.getFailList();
            if (failList != null && failList.length > 0) {
                for (AlbumFailList albumFailList : failList) {
                    AlbumUpdatedResult albumUpdatedResult = new AlbumUpdatedResult(albumFailList.getAlbumName(), albumFailList.getAlbumId(), albumFailList.getErrCode(), albumFailList.getErrMsg());
                    albumUpdatedResult.setExistAlbumId(albumFailList.getExistAlbumId());
                    arrayList.add(albumUpdatedResult);
                }
                String strM76558w = m76558w(failList, list);
                bundle.putString("errMsg", strM76558w);
                C1120a.m6678w(str, strM76558w);
            }
            m76557A(arrayList, list);
            bundle.putParcelableArrayList("AlbumUpdatedResultList", arrayList);
            bundle.putInt("code", albumUpdateResponse.getCode());
            bundle.putString("info", albumUpdateResponse.getInfo());
            return bundle;
        } catch (JsonSyntaxException e10) {
            C1120a.m6676e(str, "getResponseBundle json syntax exception: " + e10.toString());
            return m76561z(list, list2, 130, "json syntax error!");
        }
    }

    /* renamed from: z */
    private static Bundle m76561z(List<GeneralAlbumData> list, List<String> list2, int i10, String str) {
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        if (list != null) {
            for (GeneralAlbumData generalAlbumData : list) {
                arrayList.add(new AlbumUpdatedResult(generalAlbumData.getAlbumName(), generalAlbumData.getAlbumId(), i10, str));
            }
        } else if (list2 != null) {
            Iterator<String> it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(new AlbumUpdatedResult(null, it.next(), i10, str));
            }
        }
        m76557A(arrayList, list);
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("AlbumUpdatedResultList", arrayList);
        bundle.putInt("code", i10);
        bundle.putString("info", str);
        return bundle;
    }

    @Override // p701v6.AbstractC13354a
    /* renamed from: a */
    public void mo14589a() throws Exception {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("cmd", this.f58397k);
        List<String> list = this.f58328l;
        if (list != null && !list.isEmpty()) {
            jSONObject.put("albumIds", new JSONArray((Collection) this.f58328l));
        }
        this.f60188d = jSONObject.toString();
        C1120a.m6675d("DeleteAlbumsRequest", this.f58397k);
    }

    @Override // p701v6.AbstractC13354a
    /* renamed from: n */
    public AbstractC13709a mo14591n() {
        this.f58397k = "General.Albums.delete";
        C12963f c12963f = new C12963f(this.f58328l);
        c12963f.m82456i(this.f60189e);
        return c12963f;
    }

    @Override // p635s7.AbstractC12758w
    /* renamed from: u */
    public Bundle mo15143u(String str) {
        return m76560y("DeleteAlbumsRequest", null, this.f58328l, str);
    }
}
