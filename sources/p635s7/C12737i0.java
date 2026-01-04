package p635s7;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.android.hicloud.album.service.hihttp.request.response.ShareVersionResponse;
import com.huawei.android.hicloud.drive.cloudphoto.model.About;
import com.huawei.android.p069cg.configure.CloudAlbumSettings;
import com.huawei.cloud.base.http.C4616s;
import com.huawei.hms.api.ConnectionResult;
import java.io.IOException;
import org.json.JSONObject;
import p031b7.C1120a;
import p031b7.C1122c;
import p031b7.C1136q;
import p283fa.C9678a;
import p650t7.C12970i0;
import p764x6.AbstractC13709a;
import p765x7.C13720b;
import p765x7.C13721c;
import p804ya.C13924a;

/* renamed from: s7.i0 */
/* loaded from: classes2.dex */
public class C12737i0 extends AbstractC12758w {

    /* renamed from: l */
    public String f58334l;

    public C12737i0(Context context, String str, String str2) {
        this.f60186b = context;
        this.f60189e = str;
        this.f58334l = str2;
        this.f60187c = m80109h(C13720b.m82484e());
        this.f58397k = "cloudphoto.fversion.query";
    }

    @Override // p701v6.AbstractC13354a
    /* renamed from: a */
    public void mo14589a() throws Exception {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("cmd", this.f58397k);
        jSONObject.put("versionType", this.f58334l);
        C1120a.m6675d("ShareFversionRequest", "cmd: " + C13720b.m82484e());
        this.f60188d = jSONObject.toString();
    }

    @Override // p701v6.AbstractC13354a
    /* renamed from: n */
    public AbstractC13709a mo14591n() {
        this.f58397k = "Share.Changes.getStartCursor";
        C12970i0 c12970i0 = new C12970i0();
        c12970i0.m82456i(this.f60189e);
        return c12970i0;
    }

    @Override // p701v6.AbstractC13354a
    /* renamed from: p */
    public String mo76565p() throws Exception {
        int iM6802l0;
        String string;
        if (CloudAlbumSettings.m14363h().m14376l()) {
            return super.mo76565p();
        }
        C13924a c13924aM60445d = C9678a.m60442e().m60445d();
        if (c13924aM60445d == null) {
            C1120a.m6676e("ShareFversionRequest", "cloudPhoto build return null");
            C1122c.m6747W1(this.f60186b, "101_1012:1", "about error!", "04007", "About.get", this.f60189e);
            return null;
        }
        try {
            try {
                try {
                    About aboutExecute = c13924aM60445d.m83544a().get().setFields2("dataVersion,status").execute();
                    C1120a.m6675d("ShareFversionRequest", "About: " + aboutExecute.toString());
                    String dataVersion = aboutExecute.getDataVersion();
                    int iIntValue = aboutExecute.getStatus().getV2cut().intValue();
                    if (iIntValue == 0) {
                        C1120a.m6678w("ShareFversionRequest", "data migrating");
                    } else if ("V2.0".equalsIgnoreCase(dataVersion) && 1 == iIntValue) {
                        C1122c.m6813o();
                        C1136q.d.m7124A(dataVersion);
                        C1136q.d.m7135L(iIntValue);
                        C1120a.m6677i("ShareFversionRequest", "dataVersion: " + dataVersion + ", v2cut: " + iIntValue);
                        C1122c.m6747W1(this.f60186b, "101_0:1", "OK", "04007", "About.get", this.f60189e);
                        return null;
                    }
                    C1136q.d.m7124A(dataVersion);
                    C1136q.d.m7135L(iIntValue);
                    C1120a.m6677i("ShareFversionRequest", "dataVersion: " + dataVersion + ", v2cut: " + iIntValue);
                    String strMo76565p = super.mo76565p();
                    C1122c.m6747W1(this.f60186b, "101_0:1", "OK", "04007", "About.get", this.f60189e);
                    return strMo76565p;
                } catch (Exception e10) {
                    C1120a.m6676e("ShareFversionRequest", "GetVersionRequest runTask Exception: " + e10.toString());
                    String string2 = e10.toString();
                    C1122c.m6747W1(this.f60186b, "101_" + ConnectionResult.NETWORK_ERROR + ":1", string2, "04007", "About.get", this.f60189e);
                    return null;
                }
            } catch (IOException e11) {
                C1120a.m6676e("ShareFversionRequest", "GetVersionRequest runTask IOException: " + e11.toString());
                if (e11 instanceof C4616s) {
                    iM6802l0 = C1122c.m6802l0((C4616s) e11);
                    string = e11.toString();
                } else {
                    iM6802l0 = C1122c.m6845x0(e11);
                    string = e11.toString();
                }
                String str = string;
                C1122c.m6747W1(this.f60186b, "101_" + iM6802l0 + ":1", str, "04007", "About.get", this.f60189e);
                return null;
            }
        } catch (Throwable th2) {
            C1122c.m6747W1(this.f60186b, "101_0:1", "OK", "04007", "About.get", this.f60189e);
            throw th2;
        }
    }

    @Override // p635s7.AbstractC12758w
    /* renamed from: u */
    public Bundle mo15143u(String str) {
        if (TextUtils.isEmpty(str)) {
            C1120a.m6676e("ShareFversionRequest", "getResponseBundle body is empty!");
            return C13721c.m82487c(101, "body is empty!");
        }
        Bundle bundle = new Bundle();
        try {
            ShareVersionResponse shareVersionResponse = (ShareVersionResponse) new Gson().fromJson(str, ShareVersionResponse.class);
            if (shareVersionResponse != null) {
                String shareVersion = shareVersionResponse.getShareVersion();
                C1120a.m6677i("ShareFversionRequest", "cloudphoto.fversion.query: " + shareVersion);
                bundle.putString("shareVersion", shareVersion);
                bundle.putInt("code", shareVersionResponse.getCode());
                bundle.putString("info", shareVersionResponse.getInfo());
            }
            return bundle;
        } catch (JsonSyntaxException e10) {
            C1120a.m6676e("ShareFversionRequest", "getResponseBundle json syntax exception: " + e10.toString());
            return bundle;
        }
    }
}
