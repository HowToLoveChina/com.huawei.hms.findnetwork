package p587qq;

import android.content.Context;
import com.huawei.hms.framework.network.restclient.Response;
import com.huawei.hms.framework.network.restclient.hwhttp.ResponseBody;
import com.huawei.openalliance.p169ad.constant.Constants;
import hu.C10343b;
import p432kq.C11130b;
import p587qq.AbstractC12388f;
import p640sq.C12836o;

/* renamed from: qq.d */
/* loaded from: classes8.dex */
public class C12386d extends AbstractC12388f<C11130b> {
    public C12386d(C11130b c11130b, Context context, String str, AbstractC12388f.d dVar) {
        this.f57208a = c11130b;
        this.f57209b = context;
        this.f57210c = str;
        this.f57211d = dVar;
    }

    @Override // p587qq.AbstractC12388f
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public void mo74447d(C11130b c11130b, Response<ResponseBody> response) {
        C12836o.m77097b("GetDevAuthCodeCase", "handleRequestGetDevAuthCode ==", true);
        int code = response.getCode();
        C12836o.m77097b("GetDevAuthCodeCase", "code:" + code, true);
        if (code != 200) {
            m74453b(2005, "Request Error:code is " + code);
            return;
        }
        try {
            c11130b.m66931j(new String(response.getBody().bytes(), Constants.UTF_8));
            if (c11130b.m66995h() == 0) {
                C10343b c10343b = new C10343b();
                c10343b.m63701w("devAuthCode", c11130b.m66932k());
                c10343b.m63701w("devSecretKey", c11130b.m66933l());
                c10343b.m63701w("randomID", c11130b.m66934m());
                m74454c(c10343b);
            } else {
                C12836o.m77097b("GetDevAuthCodeCase", "getErrorCode ==" + c11130b.mo66928e(), true);
                C12836o.m77097b("GetDevAuthCodeCase", "getErrorDesc ==" + c11130b.mo66929f(), false);
                m74453b(c11130b.mo66928e(), c11130b.mo66929f());
            }
        } catch (Exception e10) {
            C12836o.m77097b("GetDevAuthCodeCase", "Exception:" + e10.getClass().getSimpleName(), true);
            m74453b(2015, "Request Error:" + e10.getClass().getSimpleName());
        }
    }
}
