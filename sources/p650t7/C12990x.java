package p650t7;

import android.os.Bundle;
import com.huawei.android.hicloud.drive.cloudphoto.model.Album;
import com.huawei.cloud.base.http.C4616s;
import com.huawei.hms.api.ConnectionResult;
import java.io.IOException;
import p031b7.C1120a;
import p031b7.C1122c;

/* renamed from: t7.x */
/* loaded from: classes2.dex */
public class C12990x extends AbstractC12988v {

    /* renamed from: g */
    public String f59134g;

    public C12990x(String str) {
        this.f59134g = str;
    }

    @Override // p650t7.AbstractC12988v
    /* renamed from: l */
    public String mo77876l() throws Exception {
        int iM6802l0;
        String string;
        this.f59133f = new Bundle();
        try {
            try {
                Album albumExecute = this.f61708b.m83547d().get(this.f59134g, "shortLink").execute();
                C1120a.m6675d("LinkCreateExecutor", "album:" + albumExecute.toString());
                this.f59133f.putString("shareId", this.f59134g);
                this.f59133f.putInt("code", 0);
                this.f59133f.putString("info", "success");
                this.f59133f.putString("ShortLink", albumExecute.getShortLink());
                return "";
            } catch (IOException e10) {
                C1120a.m6676e("LinkCreateExecutor", "LinkCreateExecutor runTask IOException: " + e10.toString());
                if (e10 instanceof C4616s) {
                    iM6802l0 = C1122c.m6802l0((C4616s) e10);
                    string = e10.toString();
                } else {
                    iM6802l0 = C1122c.m6845x0(e10);
                    string = e10.toString();
                }
                this.f59133f.putInt("code", iM6802l0);
                this.f59133f.putString("info", string);
                return "";
            } catch (Exception e11) {
                C1120a.m6676e("LinkCreateExecutor", "LinkCreateExecutor runTask Exception: " + e11.toString());
                iM6802l0 = ConnectionResult.NETWORK_ERROR;
                string = e11.toString();
                this.f59133f.putInt("code", iM6802l0);
                this.f59133f.putString("info", string);
                return "";
            }
        } finally {
            this.f59133f.putInt("code", 0);
            this.f59133f.putString("info", "OK");
        }
    }
}
