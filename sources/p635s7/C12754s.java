package p635s7;

import android.content.Context;
import android.database.SQLException;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.android.hicloud.album.service.hihttp.request.response.LockAndVersionResponse;
import com.huawei.android.hicloud.album.service.p075vo.CloudAlbumVersion;
import com.huawei.android.hicloud.album.service.p075vo.Version;
import com.huawei.android.hicloud.drive.cloudphoto.model.About;
import com.huawei.android.hicloud.sync.protocol.SyncProtocol;
import com.huawei.android.p069cg.configure.CloudAlbumSettings;
import com.huawei.android.p069cg.logic.manager.CloudAlbumManager;
import com.huawei.cloud.base.http.C4616s;
import com.huawei.hms.api.ConnectionResult;
import java.io.IOException;
import org.json.JSONObject;
import p009a8.C0073k;
import p015ak.C0213f;
import p020ap.C1007b;
import p031b7.C1120a;
import p031b7.C1122c;
import p031b7.C1136q;
import p283fa.C9678a;
import p616rk.C12515a;
import p650t7.C12985s;
import p764x6.AbstractC13709a;
import p765x7.C13720b;
import p765x7.C13721c;
import p804ya.C13924a;

/* renamed from: s7.s */
/* loaded from: classes2.dex */
public class C12754s extends AbstractC12758w {
    public C12754s(Context context, String str) {
        this.f60186b = context;
        this.f60189e = str;
        this.f60187c = m80109h(C13720b.m82484e());
        this.f58397k = "cloudphoto.version.query";
    }

    @Override // p701v6.AbstractC13354a
    /* renamed from: a */
    public void mo14589a() throws Exception {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("cmd", this.f58397k);
        jSONObject.put("versionType", "0");
        if (!TextUtils.isEmpty(C1136q.b.m7035X(this.f60186b))) {
            jSONObject.put(SyncProtocol.Constant.SYNC_TOKEN, C1136q.b.m7035X(this.f60186b));
        }
        this.f60188d = jSONObject.toString();
    }

    @Override // p701v6.AbstractC13354a
    /* renamed from: n */
    public AbstractC13709a mo14591n() {
        this.f58397k = "General.Changes.getStartCursor";
        return new C12985s(this.f60189e);
    }

    @Override // p701v6.AbstractC13354a
    /* renamed from: p */
    public String mo76565p() throws Exception {
        String string;
        String str;
        if (CloudAlbumSettings.m14363h().m14376l()) {
            return super.mo76565p();
        }
        C13924a c13924aM60445d = C9678a.m60442e().m60445d();
        if (c13924aM60445d == null) {
            C1120a.m6676e("GetVersionRequest", "cloudPhoto build return null");
            C1122c.m6747W1(this.f60186b, "101_1012:1", "about error!", "04001", "About.get", this.f60189e);
            return null;
        }
        int iM6802l0 = 0;
        try {
            try {
                About aboutExecute = c13924aM60445d.m83544a().get().setFields2("dataVersion,status").execute();
                C1120a.m6675d("GetVersionRequest", "About: " + aboutExecute.toString());
                String dataVersion = aboutExecute.getDataVersion();
                int iIntValue = aboutExecute.getStatus().getV2cut().intValue();
                if (iIntValue == 0) {
                    C1120a.m6678w("GetVersionRequest", "data migrating");
                } else if ("V2.0".equalsIgnoreCase(dataVersion) && 1 == iIntValue) {
                    C1122c.m6813o();
                    C1136q.d.m7124A(dataVersion);
                    C1136q.d.m7135L(iIntValue);
                    C1120a.m6677i("GetVersionRequest", "dataVersion: " + dataVersion + ", v2cut: " + iIntValue);
                    C1122c.m6747W1(this.f60186b, "101_0:1", "OK", "04001", "About.get", this.f60189e);
                    return null;
                }
                C1136q.d.m7124A(dataVersion);
                C1136q.d.m7135L(iIntValue);
                C1120a.m6677i("GetVersionRequest", "dataVersion: " + dataVersion + ", v2cut: " + iIntValue);
                String strMo76565p = super.mo76565p();
                C1122c.m6747W1(this.f60186b, "101_0:1", "OK", "04001", "About.get", this.f60189e);
                return strMo76565p;
            } catch (IOException e10) {
                C1120a.m6676e("GetVersionRequest", "GetVersionRequest runTask IOException: " + e10.toString());
                if (e10 instanceof C4616s) {
                    iM6802l0 = C1122c.m6802l0((C4616s) e10);
                    string = e10.toString();
                } else {
                    iM6802l0 = C1122c.m6845x0(e10);
                    string = e10.toString();
                }
                str = string;
                try {
                    C1120a.m6677i("GetVersionRequest", "about io exception code :" + iM6802l0);
                    m76581w(iM6802l0, e10);
                    C1122c.m6747W1(this.f60186b, "101_" + iM6802l0 + ":1", str, "04001", "About.get", this.f60189e);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    C1122c.m6747W1(this.f60186b, "101_" + iM6802l0 + ":1", str, "04001", "About.get", this.f60189e);
                    throw th;
                }
            } catch (Exception e11) {
                C1120a.m6676e("GetVersionRequest", "GetVersionRequest runTask Exception: " + e11.toString());
                String string2 = e11.toString();
                C1122c.m6747W1(this.f60186b, "101_" + ConnectionResult.NETWORK_ERROR + ":1", string2, "04001", "About.get", this.f60189e);
                return null;
            }
        } catch (Throwable th3) {
            th = th3;
            str = "OK";
            C1122c.m6747W1(this.f60186b, "101_" + iM6802l0 + ":1", str, "04001", "About.get", this.f60189e);
            throw th;
        }
    }

    @Override // p635s7.AbstractC12758w
    /* renamed from: u */
    public Bundle mo15143u(String str) {
        if (TextUtils.isEmpty(str)) {
            C1120a.m6676e("GetVersionRequest", "getResponseBundle body is empty!");
            return C13721c.m82487c(101, "body is empty!");
        }
        try {
            LockAndVersionResponse lockAndVersionResponse = (LockAndVersionResponse) new Gson().fromJson(str, LockAndVersionResponse.class);
            if (lockAndVersionResponse == null) {
                C1120a.m6676e("GetVersionRequest", "getResponseBundle response is null!");
                return C13721c.m82487c(130, "json syntax error!");
            }
            Bundle bundle = new Bundle();
            int code = lockAndVersionResponse.getCode();
            C1120a.m6677i("GetVersionRequest", "version.query general code: " + code);
            if (code == 0 && !TextUtils.isEmpty(lockAndVersionResponse.getSyncToken())) {
                C1136q.b.m7067i1(this.f60186b, lockAndVersionResponse.getSyncToken());
                if (lockAndVersionResponse.getSynctokenExpired() && Version.isSupportClearCloudVersion()) {
                    C1122c.m6825r(this.f60186b, this.f60189e);
                }
            }
            CloudAlbumVersion cloudAlbumVersion = new CloudAlbumVersion();
            cloudAlbumVersion.setLatestVersion(lockAndVersionResponse.getLatestVersion());
            cloudAlbumVersion.setAlbumListVersion(lockAndVersionResponse.getAlbumListVersion());
            cloudAlbumVersion.setAlbumVersion(lockAndVersionResponse.getAlbumVersion());
            cloudAlbumVersion.setClearVersion(lockAndVersionResponse.getClearVersion());
            bundle.putParcelable("CloudAlbumVersion", cloudAlbumVersion);
            bundle.putInt("code", code);
            bundle.putString("info", lockAndVersionResponse.getInfo());
            return bundle;
        } catch (JsonSyntaxException e10) {
            C1120a.m6676e("GetVersionRequest", "getResponseBundle json syntax exception: " + e10.toString());
            return null;
        }
    }

    /* renamed from: w */
    public final void m76581w(int i10, IOException iOException) throws InterruptedException, SQLException {
        if (i10 == 4933) {
            C1007b.m5980s().m5993M("from_album_activate");
            return;
        }
        if (i10 == 4977) {
            CloudAlbumManager.m14456v().m14480Z(C0213f.m1377a(), this.f60189e);
            String str = "service:client,action:dataInit,bus:CloudPhoto,scene:" + C1122c.m6762b0(iOException) + ",result:ok";
            C1120a.m6677i("GetVersionRequest", str);
            C12515a.m75110o().m75175e(new C0073k.b(this.f60189e, str), false);
        }
    }
}
