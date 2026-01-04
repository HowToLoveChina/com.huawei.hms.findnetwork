package p432kq;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.network.embedded.C6148x2;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import com.huawei.openalliance.p169ad.constant.ParamConstants;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import p640sq.C12824c;
import p640sq.C12836o;

/* renamed from: kq.g */
/* loaded from: classes8.dex */
public class C11135g extends AbstractC11138j {

    /* renamed from: g */
    public static String f52441g = "/oauth2/v3/token?";

    /* renamed from: e */
    public C11136h f52442e;

    /* renamed from: f */
    public Context f52443f;

    public C11135g(Context context, C11136h c11136h) {
        this.f52442e = c11136h;
        this.f52443f = context;
    }

    @Override // p432kq.AbstractC11138j
    /* renamed from: a */
    public String mo37999a() throws IllegalStateException, IOException, IllegalArgumentException {
        return "";
    }

    @Override // p432kq.AbstractC11138j
    /* renamed from: b */
    public String mo38000b() {
        C12836o.m77097b("GwTokenRequest", "urlencode: enter", true);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(CommonConstant.ReqAccessTokenParam.CLIENT_ID);
        sb2.append("=");
        sb2.append(this.f52442e.m66974p());
        sb2.append("&");
        sb2.append("grant_type");
        sb2.append("=");
        sb2.append(this.f52442e.m66969h());
        sb2.append("&");
        sb2.append(CommonConstant.ReqAccessTokenParam.REDIRECT_URI);
        sb2.append("=");
        sb2.append(this.f52442e.m66964M());
        sb2.append("&");
        sb2.append("need_code");
        sb2.append("=");
        sb2.append(this.f52442e.m66954A());
        sb2.append("&");
        sb2.append("need_open_uid");
        sb2.append("=");
        sb2.append(this.f52442e.m66956D());
        sb2.append("&");
        sb2.append("supportAlg");
        sb2.append("=");
        sb2.append(this.f52442e.m66965a());
        try {
            sb2.append("&");
            sb2.append("code");
            sb2.append("=");
            sb2.append(URLEncoder.encode(this.f52442e.m66972m(), Constants.UTF_8));
        } catch (UnsupportedEncodingException e10) {
            C12836o.m77097b("GwTokenRequest", "urlencode: " + e10.getClass().getSimpleName(), true);
        }
        if (!TextUtils.isEmpty(this.f52442e.m66957E())) {
            sb2.append("&");
            sb2.append("carrier_id");
            sb2.append("=");
            sb2.append(this.f52442e.m66957E());
        }
        if (this.f52442e.m66959H() != null) {
            sb2.append("&");
            sb2.append("code_type");
            sb2.append("=");
            sb2.append(this.f52442e.m66959H());
            if (this.f52442e.m66959H().intValue() == 1) {
                sb2.append("&");
                sb2.append("uuid");
                sb2.append("=");
                sb2.append(this.f52442e.m66960I());
                sb2.append("&");
                sb2.append(C6148x2.DEVICE_ID);
                sb2.append("=");
                sb2.append(this.f52442e.m66961J());
                sb2.append("&");
                sb2.append("device_type");
                sb2.append("=");
                sb2.append(this.f52442e.m66962K());
                sb2.append("&");
                sb2.append(MapKeyNames.PACKAGE_NAME);
                sb2.append("=");
                sb2.append(this.f52442e.m66963L());
            }
        }
        if (!TextUtils.isEmpty(this.f52442e.m66978v())) {
            sb2.append("&");
            sb2.append("code_verifier");
            sb2.append("=");
            sb2.append(this.f52442e.m66978v());
        }
        if (!TextUtils.isEmpty(this.f52442e.m66976s())) {
            sb2.append("&");
            sb2.append("client_secret");
            sb2.append("=");
            sb2.append(this.f52442e.m66976s());
        }
        String string = sb2.toString();
        C12836o.m77097b("GwTokenRequest", "urlencode: url = " + string, false);
        return string;
    }

    @Override // p432kq.AbstractC11138j
    /* renamed from: c */
    public String mo38001c() {
        return f52441g + CommonConstant.ReqAccessTokenParam.CLIENT_ID + "=" + this.f52442e.m66974p() + "&cVersion=HwID_6.12.0.302&hms_version=" + C12824c.m77019v(this.f52443f) + "&" + ParamConstants.Param.SDK_VERSION + "6.12.0.302";
    }

    @Override // p432kq.AbstractC11138j
    /* renamed from: d */
    public String mo38002d() {
        return "";
    }
}
