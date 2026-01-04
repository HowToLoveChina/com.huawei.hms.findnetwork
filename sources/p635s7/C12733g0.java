package p635s7;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.huawei.android.hicloud.album.service.hihttp.request.response.FileQueryResponse;
import com.huawei.android.hicloud.album.service.p075vo.FileData;
import com.huawei.android.hicloud.album.service.p075vo.ShareAlbumData;
import com.huawei.android.hicloud.sync.protocol.SyncProtocol;
import com.huawei.hicloud.notification.util.PowerKitApplyUtil;
import com.huawei.uikit.hwadvancednumberpicker.utils.HwConstants;
import java.util.ArrayList;
import org.json.JSONObject;
import p031b7.C1120a;
import p650t7.C12966g0;
import p764x6.AbstractC13709a;
import p765x7.C13720b;

/* renamed from: s7.g0 */
/* loaded from: classes2.dex */
public class C12733g0 extends AbstractC12758w<FileQueryResponse> {

    /* renamed from: l */
    public String f58319l;

    /* renamed from: m */
    public String f58320m;

    /* renamed from: n */
    public String f58321n;

    /* renamed from: q */
    public String f58324q;

    /* renamed from: r */
    public long f58325r;

    /* renamed from: s */
    public ShareAlbumData f58326s;

    /* renamed from: o */
    public int f58322o = HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA;

    /* renamed from: p */
    public int f58323p = HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA;

    /* renamed from: t */
    public int f58327t = 50;

    public C12733g0(Context context, String str, ShareAlbumData shareAlbumData, String str2) throws Throwable {
        this.f58321n = PowerKitApplyUtil.GROUP_ALBUM;
        this.f60186b = context;
        this.f60189e = str;
        this.f58326s = shareAlbumData;
        if (shareAlbumData != null) {
            this.f58319l = shareAlbumData.getOwnerId();
            this.f58320m = shareAlbumData.getShareId();
            this.f58325r = shareAlbumData.getFlversion();
            this.f58321n = shareAlbumData.getResource();
        }
        this.f58324q = str2;
        this.f60187c = m80109h(C13720b.m82484e());
        this.f58397k = "cloudphoto.file.queryInc";
        m80104c(this.f58320m);
    }

    @Override // p701v6.AbstractC13354a
    /* renamed from: a */
    public void mo14589a() throws Exception {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("ownerId", this.f58319l);
        jSONObject.put("albumId", this.f58320m);
        jSONObject.put("resource", this.f58321n);
        jSONObject.put("flversion", this.f58325r);
        jSONObject.put("thumbHeight", this.f58322o);
        jSONObject.put("thumbWidth", this.f58323p);
        jSONObject.put("queryNum", this.f58327t);
        jSONObject.put("quality", 85);
        if (!TextUtils.isEmpty(this.f58324q)) {
            jSONObject.put(SyncProtocol.Constant.CURSOR, this.f58324q);
        }
        jSONObject.put("cmd", this.f58397k);
        this.f60188d = jSONObject.toString();
    }

    @Override // p701v6.AbstractC13354a
    /* renamed from: n */
    public AbstractC13709a mo14591n() {
        this.f58397k = "Share.Changes.list";
        C12966g0 c12966g0 = new C12966g0(this.f58320m, this.f58319l, this.f58325r, this.f58327t, this.f58324q);
        c12966g0.m82456i(this.f60189e);
        return c12966g0;
    }

    @Override // p635s7.AbstractC12758w
    /* renamed from: u */
    public Bundle mo15143u(String str) {
        Bundle bundle = new Bundle();
        try {
            FileQueryResponse fileQueryResponse = (FileQueryResponse) new Gson().fromJson(str, FileQueryResponse.class);
            if (fileQueryResponse != null) {
                ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
                FileData[] fileList = fileQueryResponse.getFileList();
                if (fileList != null) {
                    C1120a.m6677i("ShareFileIncRequest", "cloudphoto.file.queryInc file size: " + fileList.length);
                    for (FileData fileData : fileList) {
                        JsonObject expand = fileData.getExpand();
                        if (expand != null) {
                            fileData.setExpandString(expand.toString());
                        }
                        arrayList.add(new FileData(fileData));
                    }
                }
                bundle.putParcelable("ShareInfo", this.f58326s);
                bundle.putParcelableArrayList("FileInfoList", arrayList);
                bundle.putInt("code", fileQueryResponse.getCode());
                bundle.putString("info", fileQueryResponse.getInfo());
                bundle.putString("Cursor", fileQueryResponse.getIncCursor());
            }
            return bundle;
        } catch (JsonSyntaxException e10) {
            C1120a.m6676e("ShareFileIncRequest", "getResponseBundle jsonsyntax exception: " + e10.toString());
            return bundle;
        }
    }
}
