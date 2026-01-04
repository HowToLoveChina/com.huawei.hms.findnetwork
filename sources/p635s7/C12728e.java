package p635s7;

import android.content.Context;
import android.os.Bundle;
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

/* renamed from: s7.e */
/* loaded from: classes2.dex */
public class C12728e extends AbstractC12758w {

    /* renamed from: l */
    public SmartTagData f58305l;

    /* renamed from: m */
    public String f58306m;

    /* renamed from: n */
    public int f58307n = HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA;

    /* renamed from: o */
    public int f58308o = HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA;

    /* renamed from: p */
    public int f58309p = 200;

    /* renamed from: q */
    public boolean f58310q = false;

    public C12728e(Context context, String str, SmartTagData smartTagData, String str2) {
        this.f60186b = context;
        this.f60189e = str;
        this.f58305l = smartTagData;
        this.f58306m = str2;
        this.f60187c = m80109h("/JPJX/CloudPhoto4Atlas");
        this.f58397k = "atlas.query.fileInc";
    }

    @Override // p701v6.AbstractC13354a
    /* renamed from: a */
    public void mo14589a() throws Exception {
        JSONObject jSONObject = new JSONObject();
        SmartTagData smartTagData = this.f58305l;
        if (smartTagData != null) {
            jSONObject.put("tagId", smartTagData.getTagId());
            jSONObject.put("categoryId", this.f58305l.getCategoryId());
            jSONObject.put("version", this.f58305l.getVersion());
        }
        jSONObject.put("thumbHeight", this.f58307n);
        jSONObject.put("thumbWidth", this.f58308o);
        jSONObject.put("queryNum", this.f58309p);
        jSONObject.put("quality", 85);
        jSONObject.put("needUrl", this.f58310q);
        String str = this.f58306m;
        if (str != null) {
            jSONObject.put(SyncProtocol.Constant.CURSOR, str);
        }
        jSONObject.put("cmd", this.f58397k);
        C1120a.m6675d("ChangeTagFileRequest", this.f58397k);
        this.f60188d = jSONObject.toString();
    }

    @Override // p635s7.AbstractC12758w
    /* renamed from: u */
    public Bundle mo15143u(String str) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("TagInfo", this.f58305l);
        try {
            TagFileInfoResult tagFileInfoResult = (TagFileInfoResult) new Gson().fromJson(str, TagFileInfoResult.class);
            if (tagFileInfoResult != null) {
                ArrayList<SmartFileData> arrayListTransToTagFileInfo = tagFileInfoResult.transToTagFileInfo(tagFileInfoResult.getTagFileList());
                if (arrayListTransToTagFileInfo != null) {
                    C1120a.m6677i("ChangeTagFileRequest", "tagFileInfo size: " + arrayListTransToTagFileInfo.size());
                    bundle.putString("Cursor", tagFileInfoResult.getCursor());
                    bundle.putParcelableArrayList("TagFileList", arrayListTransToTagFileInfo);
                }
                bundle.putInt("code", tagFileInfoResult.getCode());
                bundle.putString("info", tagFileInfoResult.getInfo());
            }
            return bundle;
        } catch (JsonSyntaxException e10) {
            C1120a.m6676e("ChangeTagFileRequest", "getResponseBundle json syntax exception: " + e10.toString());
            return bundle;
        }
    }
}
