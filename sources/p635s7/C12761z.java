package p635s7;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.android.hicloud.album.service.hihttp.request.response.LockAndVersionResponse;
import com.huawei.android.hicloud.album.service.logic.manager.SyncSessionManager;
import com.huawei.android.hicloud.album.service.p075vo.CloudAlbumVersion;
import org.json.JSONObject;
import p031b7.C1120a;
import p031b7.C1136q;
import p650t7.C12991y;
import p764x6.AbstractC13709a;
import p765x7.C13720b;
import p765x7.C13721c;

/* renamed from: s7.z */
/* loaded from: classes2.dex */
public class C12761z extends AbstractC12758w<LockAndVersionResponse> {
    public C12761z(Context context, String str) {
        this.f60186b = context;
        this.f60189e = str;
        this.f60187c = m80109h(C13720b.m82484e());
        this.f58397k = "cloudphoto.lock";
    }

    @Override // p701v6.AbstractC13354a
    /* renamed from: a */
    public void mo14589a() throws Exception {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("cmd", this.f58397k);
        jSONObject.put("force", true);
        this.f60188d = jSONObject.toString();
    }

    @Override // p701v6.AbstractC13354a
    /* renamed from: n */
    public AbstractC13709a mo14591n() {
        this.f58397k = "General.Locks.get";
        C12991y c12991y = new C12991y();
        c12991y.m82456i(this.f60189e);
        return c12991y;
    }

    @Override // p635s7.AbstractC12758w
    /* renamed from: u */
    public Bundle mo15143u(String str) {
        if (TextUtils.isEmpty(str)) {
            C1120a.m6676e("LockRequest", "getCommonResponseBundle body is empty!");
            SyncSessionManager.m15153t().m15187k();
            return C13721c.m82487c(101, "body is empty!");
        }
        try {
            LockAndVersionResponse lockAndVersionResponse = (LockAndVersionResponse) new Gson().fromJson(str, LockAndVersionResponse.class);
            if (lockAndVersionResponse == null) {
                C1120a.m6676e("LockRequest", "getBaseResponseBundle response is null!");
                SyncSessionManager.m15153t().m15187k();
                return C13721c.m82487c(130, "json syntax error!");
            }
            CloudAlbumVersion cloudAlbumVersion = new CloudAlbumVersion(lockAndVersionResponse.getAlbumVersion(), lockAndVersionResponse.getAlbumListVersion(), lockAndVersionResponse.getLatestVersion(), lockAndVersionResponse.getClearVersion());
            Bundle bundle = new Bundle();
            bundle.putInt("code", lockAndVersionResponse.getCode());
            bundle.putString("info", lockAndVersionResponse.getInfo());
            String syncLockToken = lockAndVersionResponse.getSyncLockToken();
            bundle.putString("LockToken", syncLockToken);
            bundle.putInt("Expire", lockAndVersionResponse.getExpire());
            bundle.putInt("albumLimit", lockAndVersionResponse.getAlbumLimit());
            bundle.putInt("fileLimit", lockAndVersionResponse.getFileLimit());
            bundle.putParcelable("CloudAlbumVersion", cloudAlbumVersion);
            bundle.putInt("keeplockStrategy", 1);
            bundle.putInt("Interval", lockAndVersionResponse.getInterval());
            bundle.putLong("keeplockCycle", 120000L);
            SyncSessionManager.m15153t().m15170Q(syncLockToken, true);
            SyncSessionManager.m15153t().m15176W();
            C1136q.b.m7010K0(this.f60186b, lockAndVersionResponse.getInterval());
            if (!TextUtils.isEmpty(lockAndVersionResponse.getSyncToken())) {
                C1136q.b.m7067i1(this.f60186b, lockAndVersionResponse.getSyncToken());
            }
            return bundle;
        } catch (JsonSyntaxException e10) {
            SyncSessionManager.m15153t().m15187k();
            C1120a.m6676e("LockRequest", "getResponseBundle jsonsyntax exception: " + e10.toString());
            return null;
        }
    }
}
