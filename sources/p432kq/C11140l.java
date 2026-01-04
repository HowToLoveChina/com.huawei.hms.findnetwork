package p432kq;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.network.embedded.C6148x2;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.huawei.hms.support.api.entity.pay.HwPayConstant;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import com.huawei.openalliance.p169ad.constant.ParamConstants;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import p640sq.C12824c;
import p640sq.C12836o;

/* renamed from: kq.l */
/* loaded from: classes8.dex */
public class C11140l extends AbstractC11138j {

    /* renamed from: g */
    public static String f52466g = "/oauth2/v3/silent_token?";

    /* renamed from: e */
    public C11141m f52467e;

    /* renamed from: f */
    public Context f52468f;

    public C11140l(Context context, C11141m c11141m) {
        this.f52467e = c11141m;
        this.f52468f = context;
    }

    @Override // p432kq.AbstractC11138j
    /* renamed from: a */
    public String mo37999a() throws IllegalStateException, IOException, IllegalArgumentException {
        return "";
    }

    @Override // p432kq.AbstractC11138j
    /* renamed from: b */
    public String mo38000b() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(CommonConstant.ReqAccessTokenParam.CLIENT_ID);
        sb2.append("=");
        sb2.append(this.f52467e.m67025n());
        sb2.append("&");
        sb2.append("grant_type");
        sb2.append("=");
        sb2.append(this.f52467e.m67027q());
        sb2.append("&");
        sb2.append("device_type");
        sb2.append("=");
        sb2.append(this.f52467e.m67033z());
        sb2.append("&");
        sb2.append(MapKeyNames.PACKAGE_NAME);
        sb2.append("=");
        sb2.append(this.f52467e.m67010C());
        sb2.append("&");
        sb2.append(C6148x2.DEVICE_ID);
        sb2.append("=");
        sb2.append(this.f52467e.m67013G());
        sb2.append("&");
        sb2.append("need_code");
        sb2.append("=");
        sb2.append(this.f52467e.m67014H());
        sb2.append("&");
        sb2.append("token_type");
        sb2.append("=");
        sb2.append(this.f52467e.m67016J());
        sb2.append("&");
        sb2.append("supportAlg");
        sb2.append("=");
        sb2.append(this.f52467e.m67017a());
        if ("service_token".equals(this.f52467e.m67027q())) {
            sb2.append("&");
            sb2.append("service_token");
            sb2.append("=");
            sb2.append(this.f52467e.m67031w());
            sb2.append("&");
            sb2.append(HwPayConstant.KEY_SITE_ID);
            sb2.append("=");
            sb2.append(this.f52467e.m67012F());
        } else if ("access_token".equals(this.f52467e.m67027q())) {
            sb2.append("&");
            sb2.append("uuid");
            sb2.append("=");
            sb2.append(this.f52467e.m67023k());
            try {
                sb2.append("&");
                sb2.append("access_token");
                sb2.append("=");
                sb2.append(URLEncoder.encode(this.f52467e.m67021h(), Constants.UTF_8));
            } catch (UnsupportedEncodingException unused) {
                C12836o.m77097b("SilentTokenRequest", "urlencode: UnsupportedEncodingException", true);
            }
        }
        if (!TextUtils.isEmpty(this.f52467e.m67029t())) {
            sb2.append("&");
            sb2.append("scope");
            sb2.append("=");
            sb2.append(this.f52467e.m67029t());
        }
        if (!TextUtils.isEmpty(this.f52467e.m67015I())) {
            sb2.append("&");
            sb2.append("carrier_id");
            sb2.append("=");
            sb2.append(this.f52467e.m67015I());
        }
        String string = sb2.toString();
        C12836o.m77097b("SilentTokenRequest", "urlencode: url = " + string, false);
        return string;
    }

    @Override // p432kq.AbstractC11138j
    /* renamed from: c */
    public String mo38001c() {
        return f52466g + CommonConstant.ReqAccessTokenParam.CLIENT_ID + "=" + this.f52467e.m67025n() + "&cVersion=HwID_6.12.0.302&hms_version=" + C12824c.m77019v(this.f52468f) + "&" + ParamConstants.Param.SDK_VERSION + "6.12.0.302";
    }

    @Override // p432kq.AbstractC11138j
    /* renamed from: d */
    public String mo38002d() {
        return "";
    }
}
