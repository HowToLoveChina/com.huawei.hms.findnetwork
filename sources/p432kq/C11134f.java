package p432kq;

import android.content.Context;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.ParamConstants;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import p640sq.C12824c;
import p640sq.C12836o;
import p640sq.C12842u;
import p640sq.C12843v;

/* renamed from: kq.f */
/* loaded from: classes8.dex */
public class C11134f extends AbstractC11138j {

    /* renamed from: f */
    public String f52435f;

    /* renamed from: h */
    public String f52437h;

    /* renamed from: i */
    public String f52438i;

    /* renamed from: j */
    public String f52439j;

    /* renamed from: k */
    public Context f52440k;

    /* renamed from: e */
    public String f52434e = "/oauth2/v3/silent_code?";

    /* renamed from: g */
    public String f52436g = "access_token";

    public C11134f(Context context, String str, String str2, String str3, String str4) {
        this.f52440k = context;
        this.f52435f = str;
        this.f52437h = str2;
        this.f52438i = str3;
        this.f52439j = str4;
    }

    /* renamed from: i */
    private String m66941i() {
        try {
            return URLEncoder.encode(C12842u.m77123b(), Constants.UTF_8);
        } catch (UnsupportedEncodingException unused) {
            C12836o.m77099d("GwSilentCodeHttpRequest", "UnsupportedEncodingException", true);
            return "";
        }
    }

    @Override // p432kq.AbstractC11138j
    /* renamed from: a */
    public String mo37999a() throws IllegalStateException, IOException, IllegalArgumentException {
        return null;
    }

    @Override // p432kq.AbstractC11138j
    /* renamed from: b */
    public String mo38000b() throws UnsupportedEncodingException {
        StringBuilder sb2 = new StringBuilder();
        try {
            String strEncode = URLEncoder.encode(this.f52438i, Constants.UTF_8);
            if (!strEncode.contains("openid")) {
                strEncode = "openid " + strEncode;
            }
            String strEncode2 = URLEncoder.encode(this.f52439j, Constants.UTF_8);
            String strEncode3 = URLEncoder.encode(this.f52437h, Constants.UTF_8);
            sb2.append("grant_type");
            sb2.append("=");
            sb2.append(this.f52436g);
            sb2.append("&");
            sb2.append("access_token");
            sb2.append("=");
            sb2.append(strEncode3);
            sb2.append("&");
            sb2.append("scope");
            sb2.append("=");
            sb2.append(strEncode);
            sb2.append("&");
            sb2.append(CommonConstant.ReqAccessTokenParam.REDIRECT_URI);
            sb2.append("=");
            sb2.append(strEncode2);
            sb2.append("&");
            sb2.append("need_show_page");
            sb2.append("=");
            sb2.append(FaqConstants.DISABLE_HA_REPORT);
            sb2.append("&");
            sb2.append("nonce");
            sb2.append("=");
            sb2.append(m66941i());
            sb2.append("&");
            sb2.append("include_granted_scopes");
            sb2.append("=");
            sb2.append(FaqConstants.DISABLE_HA_REPORT);
            sb2.append("&");
            sb2.append("access_type");
            sb2.append("=");
            sb2.append("offline");
            sb2.append("&");
            sb2.append(CommonConstant.ReqAccessTokenParam.STATE_LABEL);
            sb2.append("=");
            sb2.append(m66941i());
            sb2.append("&");
            sb2.append("uuid");
            sb2.append(C12843v.m77127d(this.f52440k));
        } catch (UnsupportedEncodingException unused) {
            C12836o.m77097b("GwSilentCodeHttpRequest", "UnsupportedEncodingException", true);
        }
        return sb2.toString();
    }

    @Override // p432kq.AbstractC11138j
    /* renamed from: c */
    public String mo38001c() {
        return this.f52434e + CommonConstant.ReqAccessTokenParam.CLIENT_ID + "=" + this.f52435f + "&hms_version=" + C12824c.m77019v(this.f52440k) + "&" + ParamConstants.Param.SDK_VERSION + "=6.12.0.302";
    }

    @Override // p432kq.AbstractC11138j
    /* renamed from: d */
    public String mo38002d() {
        return "";
    }
}
