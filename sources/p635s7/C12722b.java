package p635s7;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.android.hicloud.album.service.hihttp.request.response.TagFileInfoResult;
import com.huawei.android.hicloud.album.service.p075vo.SmartFileData;
import com.huawei.android.hicloud.album.service.p075vo.SmartTagData;
import com.huawei.android.hicloud.sync.protocol.SyncProtocol;
import com.huawei.uikit.hwadvancednumberpicker.utils.HwConstants;
import java.util.ArrayList;
import org.json.JSONObject;
import p031b7.C1120a;

/* renamed from: s7.b */
/* loaded from: classes2.dex */
public class C12722b extends AbstractC12758w {

    /* renamed from: l */
    public SmartTagData f58291l;

    /* renamed from: m */
    public String f58292m;

    /* renamed from: n */
    public int f58293n = HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA;

    /* renamed from: o */
    public int f58294o = HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA;

    /* renamed from: p */
    public int f58295p = 200;

    /* renamed from: q */
    public boolean f58296q = false;

    public C12722b(Context context, String str, SmartTagData smartTagData, String str2) {
        this.f60186b = context;
        this.f60189e = str;
        this.f58291l = smartTagData;
        this.f58292m = str2;
        this.f60187c = m80109h("/JPJX/CloudPhoto4Atlas");
        this.f58397k = "atlas.query.file";
    }

    @Override // p701v6.AbstractC13354a
    /* renamed from: a */
    public void mo14589a() throws Exception {
        JSONObject jSONObject = new JSONObject();
        SmartTagData smartTagData = this.f58291l;
        if (smartTagData != null) {
            jSONObject.put("tagId", smartTagData.getTagId());
            jSONObject.put("categoryId", this.f58291l.getCategoryId());
        }
        jSONObject.put("thumbHeight", this.f58293n);
        jSONObject.put("thumbWidth", this.f58294o);
        jSONObject.put("queryNum", this.f58295p);
        jSONObject.put("quality", 85);
        jSONObject.put("needUrl", this.f58296q);
        if (!TextUtils.isEmpty(this.f58292m)) {
            jSONObject.put(SyncProtocol.Constant.CURSOR, this.f58292m);
        }
        jSONObject.put("cmd", this.f58397k);
        C1120a.m6675d("AllTagFileRequest", "atlas.query.file");
        this.f60188d = jSONObject.toString();
    }

    @Override // p635s7.AbstractC12758w
    /* renamed from: u */
    public Bundle mo15143u(String str) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("TagInfo", this.f58291l);
        try {
            TagFileInfoResult tagFileInfoResult = (TagFileInfoResult) new Gson().fromJson(str, TagFileInfoResult.class);
            if (tagFileInfoResult != null) {
                ArrayList<SmartFileData> arrayListTransToTagFileInfo = tagFileInfoResult.transToTagFileInfo(tagFileInfoResult.getTagFileList());
                if (arrayListTransToTagFileInfo != null) {
                    C1120a.m6677i("AllTagFileRequest", "tagFileInfo size: " + arrayListTransToTagFileInfo.size());
                    bundle.putParcelableArrayList("TagFileList", arrayListTransToTagFileInfo);
                }
                bundle.putString("Cursor", tagFileInfoResult.getCursor());
                bundle.putInt("code", tagFileInfoResult.getCode());
                bundle.putString("info", tagFileInfoResult.getInfo());
            }
            return bundle;
        } catch (JsonSyntaxException unused) {
            C1120a.m6676e("AllTagFileRequest", "getResponseBundle json syntax exception");
            return bundle;
        }
    }
}
