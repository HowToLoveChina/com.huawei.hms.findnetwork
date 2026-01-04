package p701v6;

import android.content.Context;
import com.huawei.hicloud.notification.manager.HicloudH5ConfigManager;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import org.json.JSONObject;
import p031b7.C1120a;
import p765x7.C13720b;

/* renamed from: v6.d */
/* loaded from: classes2.dex */
public class C13357d extends AbstractC13354a {

    /* renamed from: k */
    public String f60220k;

    /* renamed from: l */
    public String f60221l;

    /* renamed from: m */
    public String f60222m;

    /* renamed from: n */
    public String f60223n;

    /* renamed from: o */
    public String f60224o;

    public C13357d(Context context, String str, String str2, String str3, String str4) {
        this.f60186b = context;
        this.f60220k = str;
        this.f60221l = str2;
        this.f60224o = str3;
        this.f60222m = str4;
        this.f60187c = m80109h(C13720b.m82484e());
    }

    @Override // p701v6.AbstractC13354a
    /* renamed from: a */
    public void mo14589a() throws Exception {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("ownerId", this.f60220k);
        jSONObject.put("albumId", this.f60221l);
        jSONObject.put("resource", this.f60224o);
        jSONObject.put(HicloudH5ConfigManager.KEY_HASH, this.f60222m);
        jSONObject.put(ContentRecord.UNIQUE_ID, this.f60223n);
        jSONObject.put("cmd", "cloudphoto.file.getattach");
        C1120a.m6675d("FileQueryAttachRequest", "cloudphoto.file.getattach");
        this.f60188d = jSONObject.toString();
    }

    public C13357d(Context context, String str, String str2, String str3, String str4, String str5) {
        this(context, str, str2, str3, str4);
        this.f60223n = str5;
    }
}
