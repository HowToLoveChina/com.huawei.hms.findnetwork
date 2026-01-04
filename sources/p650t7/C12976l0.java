package p650t7;

import android.text.TextUtils;
import com.huawei.cloud.base.http.C4616s;
import com.huawei.hicloud.base.drive.model.ChannelSubscribeRequest;
import com.huawei.hms.api.ConnectionResult;
import java.io.IOException;
import p015ak.C0213f;
import p031b7.C1120a;
import p031b7.C1122c;
import p031b7.C1136q;
import p237du.C9310c;
import p709vj.C13452e;
import p764x6.AbstractC13712d;

/* renamed from: t7.l0 */
/* loaded from: classes2.dex */
public class C12976l0 extends AbstractC13712d {

    /* renamed from: f */
    public String f59102f;

    public C12976l0(String str, String str2) {
        this.f59102f = str;
        this.f61710d = str2;
    }

    /* renamed from: k */
    public void m77924k() {
        int iM6802l0;
        String string;
        if (TextUtils.isEmpty(this.f59102f)) {
            C1120a.m6676e("SubscribeExecutor", "cursor null");
            return;
        }
        if (System.currentTimeMillis() - C1136q.b.m7031V(C0213f.m1377a()) < 86400000) {
            C1120a.m6677i("SubscribeExecutor", "cursor has been subscribed within one day");
            return;
        }
        try {
            try {
                ChannelSubscribeRequest channelSubscribeRequest = new ChannelSubscribeRequest();
                channelSubscribeRequest.setExpirationTime(Long.valueOf(System.currentTimeMillis() + 604800000));
                channelSubscribeRequest.setId(C9310c.m58618b(C13452e.m80781L().m80954p() + "10055832"));
                channelSubscribeRequest.setPushToken(C1136q.d.m7152p());
                channelSubscribeRequest.setSignVersion(2);
                channelSubscribeRequest.setType("push");
                C1120a.m6675d("SubscribeExecutor", "channel: " + this.f61708b.m83546c().subscribe(this.f59102f, channelSubscribeRequest).execute().toString());
                C1136q.b.m7064h1(C0213f.m1377a(), System.currentTimeMillis());
            } catch (IOException e10) {
                C1120a.m6676e("SubscribeExecutor", "SubscribeExecutor runTask IOException: " + e10.toString());
                if (e10 instanceof C4616s) {
                    iM6802l0 = C1122c.m6802l0((C4616s) e10);
                    string = e10.toString();
                } else {
                    iM6802l0 = C1122c.m6845x0(e10);
                    string = e10.toString();
                }
                String str = string;
                C1122c.m6747W1(C0213f.m1377a(), "101_" + iM6802l0 + ":1", str, "04006", "Changes.subscribe", this.f61710d);
            } catch (Exception e11) {
                C1120a.m6676e("SubscribeExecutor", "SubscribeExecutor runTask Exception: " + e11.toString());
                String string2 = e11.toString();
                C1122c.m6747W1(C0213f.m1377a(), "101_" + ConnectionResult.NETWORK_ERROR + ":1", string2, "04006", "Changes.subscribe", this.f61710d);
            }
        } finally {
            C1122c.m6747W1(C0213f.m1377a(), "101_0:1", "OK", "04006", "Changes.subscribe", this.f61710d);
        }
    }
}
