package p650t7;

import android.os.Bundle;
import com.huawei.android.hicloud.drive.cloudphoto.model.About;
import com.huawei.cloud.base.http.C4616s;
import com.huawei.hms.api.ConnectionResult;
import java.io.IOException;
import p031b7.C1120a;
import p031b7.C1122c;

/* renamed from: t7.q */
/* loaded from: classes2.dex */
public class C12983q extends AbstractC12988v {
    @Override // p650t7.AbstractC12988v
    /* renamed from: l */
    public String mo77876l() {
        int iM6802l0;
        String string;
        this.f59133f = new Bundle();
        try {
            try {
                C1122c.m6809n();
                About aboutExecute = this.f61708b.m83544a().get().setFields2("serverTime").execute();
                C1120a.m6675d("GetServerTimeExecutor", "About: " + aboutExecute.toString());
                Long serverTime = aboutExecute.getServerTime();
                if (serverTime.longValue() > 0) {
                    this.f59133f.putLong("ServerTime", serverTime.longValue());
                }
                return "";
            } catch (IOException e10) {
                C1120a.m6676e("GetServerTimeExecutor", "GetServerTimeExecutor runTask IOException: " + e10.toString());
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
                C1120a.m6676e("GetServerTimeExecutor", "GetServerTimeExecutor runTask Exception: " + e11.toString());
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
