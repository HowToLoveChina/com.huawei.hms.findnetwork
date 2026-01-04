package iq;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcelable;
import android.text.TextUtils;
import com.huawei.hms.common.internal.constant.AuthInternalPickerConstant;
import com.huawei.hwidauth.datatype.DeviceInfo;
import com.huawei.hwidauth.p167ui.WebViewActivity;
import com.huawei.openalliance.p169ad.constant.VastAttribute;
import org.json.JSONException;
import org.json.JSONObject;
import p432kq.C11134f;
import p432kq.C11139k;
import p432kq.InterfaceC11137i;
import p640sq.C12824c;
import p640sq.C12836o;
import p658tq.C13056a;

/* renamed from: iq.d */
/* loaded from: classes8.dex */
public class C10590d {

    /* renamed from: a */
    public Activity f50942a;

    /* renamed from: b */
    public String f50943b;

    /* renamed from: c */
    public String f50944c;

    /* renamed from: d */
    public String f50945d;

    /* renamed from: e */
    public String f50946e;

    /* renamed from: f */
    public String f50947f;

    /* renamed from: g */
    public InterfaceC10596j<C10598l> f50948g;

    /* renamed from: h */
    public C11139k f50949h;

    /* renamed from: iq.d$a */
    public class a implements InterfaceC11137i {

        /* renamed from: a */
        public final /* synthetic */ String f50950a;

        /* renamed from: b */
        public final /* synthetic */ String f50951b;

        /* renamed from: c */
        public final /* synthetic */ String f50952c;

        /* renamed from: d */
        public final /* synthetic */ boolean f50953d;

        public a(String str, String str2, String str3, boolean z10) {
            this.f50950a = str;
            this.f50951b = str2;
            this.f50952c = str3;
            this.f50953d = z10;
        }

        @Override // p432kq.InterfaceC11137i
        public void onFailure(int i10, String str) throws JSONException {
            C12836o.m77097b("HuaWeiIdSignInClient", "onFailure, errorCode is " + i10, true);
            C10590d.this.m64972f(this.f50951b, i10, str, this.f50952c, this.f50953d, this.f50950a);
        }

        @Override // p432kq.InterfaceC11137i
        public void onSuccess(String str) throws JSONException {
            C12836o.m77097b("HuaWeiIdSignInClient", "onSuccess response = " + str, false);
            if (TextUtils.isEmpty(str)) {
                C12836o.m77097b("HuaWeiIdSignInClient", "onSuccess response empty", true);
                C10590d c10590d = C10590d.this;
                c10590d.m64971b(-1, "User cancel", "", c10590d.f50948g, this.f50950a);
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("code")) {
                    String string = jSONObject.getString("code");
                    C10590d c10590d2 = C10590d.this;
                    c10590d2.m64971b(200, "success", string, c10590d2.f50948g, this.f50950a);
                } else if (jSONObject.has(VastAttribute.ERROR) && "1301".equals(jSONObject.getString(VastAttribute.ERROR))) {
                    C12836o.m77097b("HuaWeiIdSignInClient", "unauthorized_code startWebViewActivity", true);
                    C10590d.this.m64973g(this.f50951b, this.f50952c, this.f50950a);
                }
            } catch (JSONException unused) {
                C12836o.m77099d("HuaWeiIdSignInClient", "JSONException", true);
                C10590d c10590d3 = C10590d.this;
                c10590d3.m64971b(-1, "User cancel", "", c10590d3.f50948g, this.f50950a);
            }
        }
    }

    /* renamed from: iq.d$b */
    public static class b {

        /* renamed from: a */
        public Activity f50955a;

        /* renamed from: b */
        public String f50956b;

        /* renamed from: c */
        public String f50957c;

        /* renamed from: d */
        public String f50958d;

        /* renamed from: e */
        public String f50959e;

        /* renamed from: f */
        public String f50960f;

        /* renamed from: g */
        public InterfaceC10596j<C10598l> f50961g;

        public b(Activity activity) {
            this.f50955a = activity;
        }

        /* renamed from: a */
        public C10590d m64977a() {
            return new C10590d(this.f50955a, this.f50956b, this.f50957c, this.f50958d, this.f50959e, this.f50960f, this.f50961g, null);
        }

        /* renamed from: b */
        public b m64978b(InterfaceC10596j<C10598l> interfaceC10596j) {
            this.f50961g = interfaceC10596j;
            return this;
        }

        /* renamed from: c */
        public b m64979c(String str) {
            this.f50956b = str;
            return this;
        }

        /* renamed from: d */
        public b m64980d(String str) {
            this.f50959e = str;
            return this;
        }

        /* renamed from: e */
        public b m64981e(String str) {
            this.f50958d = str;
            return this;
        }

        /* renamed from: f */
        public b m64982f(String[] strArr) {
            if (strArr == null || strArr.length == 0) {
                this.f50957c = "";
            } else {
                StringBuilder sb2 = new StringBuilder();
                C12836o.m77097b("HuaWeiIdSignInClient", "scopes length " + strArr.length, true);
                for (String str : strArr) {
                    sb2.append(str);
                    sb2.append(" ");
                }
                this.f50957c = sb2.toString();
            }
            return this;
        }
    }

    public /* synthetic */ C10590d(Activity activity, String str, String str2, String str3, String str4, String str5, InterfaceC10596j interfaceC10596j, a aVar) {
        this(activity, str, str2, str3, str4, str5, interfaceC10596j);
    }

    /* renamed from: b */
    public final void m64971b(int i10, String str, String str2, InterfaceC10596j<C10598l> interfaceC10596j, String str3) {
        if (interfaceC10596j != null) {
            C10600n c10600n = new C10600n(i10, str);
            if (200 == i10) {
                c10600n.m64999e(true);
                C13056a.m78783c(this.f50942a, 907115001, 200, "signOAuth ok", str3, "accountPickerH5.signIn_v2", "api_ret");
            } else {
                c10600n.m64999e(false);
                C13056a.m78783c(this.f50942a, 907115001, 404, "signOAuth fail", str3, "accountPickerH5.signIn_v2", "api_ret");
            }
            interfaceC10596j.onResult(new C10598l(str2, c10600n));
        }
    }

    /* renamed from: f */
    public final void m64972f(String str, int i10, String str2, String str3, boolean z10, String str4) throws JSONException {
        C12836o.m77097b("HuaWeiIdSignInClient", "dealFailRequestResult errorCode = " + i10, true);
        C12836o.m77097b("HuaWeiIdSignInClient", "dealFailRequestResult errorContent = " + str2, false);
        try {
            if (!TextUtils.isEmpty(str2)) {
                String string = new JSONObject(str2).getString(VastAttribute.ERROR);
                if ("1301".equals(string)) {
                    C12836o.m77097b("HuaWeiIdSignInClient", "unauthorized_code startWebViewActivity", true);
                    m64973g(str, str3, str4);
                } else if ("1203".equals(string)) {
                    C12836o.m77097b("HuaWeiIdSignInClient", "token revoked startWebViewActivity", true);
                    if (z10) {
                        m64973g(str, "", str4);
                    } else {
                        C13056a.m78783c(this.f50942a, 907115001, 404, "Access Token is Invalid", str4, "accountPickerH5.signIn_v2", "api_ret");
                        this.f50948g.onResult(new C10598l("", new C10600n(2008, "Access Token is Invalid")));
                    }
                } else {
                    C12836o.m77097b("HuaWeiIdSignInClient", "dealFailRequestResult other error", true);
                    C13056a.m78783c(this.f50942a, 907115001, 404, "signOAuth fail", str4, "accountPickerH5.signIn_v2", "api_ret");
                    this.f50948g.onResult(new C10598l("", new C10600n(2003, AuthInternalPickerConstant.PARAM_ERROR)));
                }
            }
        } catch (JSONException unused) {
            C12836o.m77099d("HuaWeiIdSignInClient", "JSONException ", true);
            m64971b(i10, "User cancel", "", this.f50948g, str4);
        }
    }

    /* renamed from: g */
    public final void m64973g(String str, String str2, String str3) {
        try {
            Intent intent = new Intent(this.f50942a, (Class<?>) WebViewActivity.class);
            intent.putExtra("key_redirecturi", this.f50945d);
            intent.putExtra("key_app_id", this.f50943b);
            intent.putExtra("key_scopes", this.f50944c);
            intent.putExtra("key_transId", str3);
            intent.putExtra("key_oper", "from_signin");
            intent.putExtra("key_device_info", (Parcelable) DeviceInfo.m38003c(this.f50942a, this.f50946e));
            intent.putExtra("key_extends_param", this.f50947f);
            intent.putExtra("grs_app_name", str);
            if (!TextUtils.isEmpty(str2)) {
                C12836o.m77097b("HuaWeiIdSignInClient", "accessToken not empty", true);
                intent.putExtra("key_access_token", str2);
            }
            this.f50942a.startActivity(intent);
        } catch (IllegalArgumentException e10) {
            C12836o.m77099d("HuaWeiIdSignInClient", "IllegalArgumentException", true);
            C13056a.m78783c(this.f50942a, 907115001, 404, "IllegalArgumentException:" + e10.getMessage(), str3, "accountPickerH5.signIn_v2", "api_ret");
        } catch (RuntimeException e11) {
            C12836o.m77099d("HuaWeiIdSignInClient", "RuntimeException", true);
            C13056a.m78783c(this.f50942a, 907115001, 404, "RuntimeException:" + e11.getMessage(), str3, "accountPickerH5.signIn_v2", "api_ret");
        } catch (Exception e12) {
            C12836o.m77099d("HuaWeiIdSignInClient", "Exception", true);
            C13056a.m78783c(this.f50942a, 907115001, 404, "Exception:" + e12.getMessage(), str3, "accountPickerH5.signIn_v2", "api_ret");
        }
    }

    /* renamed from: h */
    public final void m64974h(String str, String str2, boolean z10, String str3) {
        C12836o.m77097b("HuaWeiIdSignInClient", "doRequest init.", true);
        this.f50949h.m66997b(this.f50942a.getApplicationContext(), str, new C11134f(this.f50942a.getApplicationContext(), this.f50943b, str2, this.f50944c, this.f50945d), new a(str3, str, str2, z10));
    }

    /* renamed from: i */
    public void m64975i(String str) throws C10593g {
        Activity activity = this.f50942a;
        if (activity == null || activity.isFinishing()) {
            throw new C10593g("Actvity status invalid");
        }
        if (TextUtils.isEmpty(str)) {
            throw new C10593g("grsAppName is empty");
        }
        if (TextUtils.isEmpty(this.f50943b)) {
            throw new C10593g("Appid is null");
        }
        if (TextUtils.isEmpty(this.f50945d)) {
            throw new C10593g("RedirectUri is null");
        }
        if (this.f50948g == null) {
            throw new C10593g("ResultResultCallBack is null");
        }
        if (TextUtils.isEmpty(this.f50946e)) {
            throw new C10593g("deviceInfo is null");
        }
        C12836o.m77097b("HuaWeiIdSignInClient", "signIn", true);
        C13056a.m78783c(this.f50942a, 907115001, 0, "signOAuth start", C13056a.m78781a(), "accountPickerH5.signIn_v2", "api_entry");
        m64973g(str, null, "");
    }

    /* renamed from: j */
    public void m64976j(String str, String str2, boolean z10) throws C10593g {
        Activity activity = this.f50942a;
        if (activity == null || activity.isFinishing()) {
            throw new C10593g("Actvity status invalid");
        }
        if (TextUtils.isEmpty(str)) {
            throw new C10593g("grsAppName is empty");
        }
        if (TextUtils.isEmpty(this.f50943b)) {
            throw new C10593g("Appid is null");
        }
        if (TextUtils.isEmpty(this.f50945d)) {
            throw new C10593g("RedirectUri is null");
        }
        if (this.f50948g == null) {
            throw new C10593g("ResultResultCallBack is null");
        }
        if (TextUtils.isEmpty(this.f50946e)) {
            throw new C10593g("deviceInfo is null");
        }
        C12836o.m77097b("HuaWeiIdSignInClient", "signIn", true);
        C13056a.m78783c(this.f50942a, 907115001, 0, "signOAuth start", C13056a.m78781a(), "accountPickerH5.signIn_v2", "api_entry");
        if (TextUtils.isEmpty(str2)) {
            m64973g(str, null, "");
        } else {
            this.f50949h = C11139k.m66996a();
            m64974h(str, str2, z10, "");
        }
    }

    public C10590d(Activity activity, String str, String str2, String str3, String str4, String str5, InterfaceC10596j<C10598l> interfaceC10596j) {
        this.f50942a = activity;
        this.f50943b = str;
        this.f50944c = str2;
        this.f50946e = str4;
        this.f50945d = str3;
        this.f50947f = str5;
        this.f50948g = interfaceC10596j;
        C12824c.m77010m(interfaceC10596j);
    }
}
