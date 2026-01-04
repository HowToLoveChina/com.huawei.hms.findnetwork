package p587qq;

import android.content.Context;
import com.huawei.hms.framework.network.restclient.Response;
import com.huawei.hms.framework.network.restclient.hwhttp.ResponseBody;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.phoneservice.faq.base.constants.TrackConstants$Opers;
import hu.C10343b;
import p432kq.C11129a;
import p587qq.AbstractC12388f;
import p640sq.C12836o;

/* renamed from: qq.c */
/* loaded from: classes8.dex */
public class C12385c extends AbstractC12388f<C11129a> {
    public C12385c(C11129a c11129a, Context context, String str, AbstractC12388f.d dVar) {
        this.f57208a = c11129a;
        this.f57209b = context;
        this.f57210c = str;
        this.f57211d = dVar;
    }

    @Override // p587qq.AbstractC12388f
    /* renamed from: f */
    public void mo74447d(C11129a c11129a, Response<ResponseBody> response) {
        int code = response.getCode();
        C12836o.m77097b("GetConfigurationCase", "code:" + code, true);
        if (code != 200) {
            m74453b(2005, "Request Error:code is " + code);
            return;
        }
        try {
            String str = new String(response.getBody().bytes(), Constants.UTF_8);
            C12836o.m77097b("GetConfigurationCase", "handleRequestNet data:" + str, false);
            c11129a.m66926i(str);
            if (c11129a.m66995h() == 0) {
                C10343b c10343b = new C10343b();
                c10343b.m63701w(TrackConstants$Opers.RESPONSE, c11129a.m66927j());
                m74454c(c10343b);
            } else {
                C12836o.m77097b("GetConfigurationCase", "getErrorCode ==" + c11129a.mo66928e(), true);
                C12836o.m77097b("GetConfigurationCase", "getErrorDesc ==" + c11129a.mo66929f(), false);
                m74453b(c11129a.mo66928e(), c11129a.mo66929f());
            }
        } catch (Exception e10) {
            C12836o.m77097b("GetConfigurationCase", "Exception:" + e10.getClass().getSimpleName(), true);
            m74453b(2015, "Request Error:" + e10.getClass().getSimpleName());
        }
    }
}
