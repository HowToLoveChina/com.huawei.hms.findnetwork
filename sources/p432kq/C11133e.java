package p432kq;

import android.content.Context;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.ParamConstants;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import p640sq.C12824c;
import p640sq.C12836o;

/* renamed from: kq.e */
/* loaded from: classes8.dex */
public class C11133e extends AbstractC11138j {

    /* renamed from: e */
    public String f52431e = "/oauth2/v3/revoke?";

    /* renamed from: f */
    public String f52432f;

    /* renamed from: g */
    public Context f52433g;

    public C11133e(Context context, String str) {
        this.f52432f = str;
        this.f52433g = context;
    }

    @Override // p432kq.AbstractC11138j
    /* renamed from: a */
    public String mo37999a() throws IllegalStateException, IOException, IllegalArgumentException {
        return "";
    }

    @Override // p432kq.AbstractC11138j
    /* renamed from: b */
    public String mo38000b() throws UnsupportedEncodingException {
        StringBuilder sb2 = new StringBuilder();
        try {
            String strEncode = URLEncoder.encode(this.f52432f, Constants.UTF_8);
            sb2.append("token");
            sb2.append("=");
            sb2.append(strEncode);
        } catch (UnsupportedEncodingException unused) {
            C12836o.m77097b("revokeRequest", "UnsupportedEncodingException", true);
        }
        return sb2.toString();
    }

    @Override // p432kq.AbstractC11138j
    /* renamed from: c */
    public String mo38001c() {
        return this.f52431e + "hms_version=" + C12824c.m77019v(this.f52433g) + "&" + ParamConstants.Param.SDK_VERSION + "=6.12.0.302";
    }

    @Override // p432kq.AbstractC11138j
    /* renamed from: d */
    public String mo38002d() {
        return "";
    }
}
