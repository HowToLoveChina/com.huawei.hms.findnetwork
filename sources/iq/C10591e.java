package iq;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.webkit.CookieManager;
import iq.C10590d;
import org.json.JSONException;
import org.json.JSONObject;
import p432kq.C11133e;
import p432kq.C11139k;
import p432kq.InterfaceC11137i;
import p530oq.C11990c;
import p640sq.C12824c;
import p640sq.C12836o;
import p658tq.C13056a;

/* renamed from: iq.e */
/* loaded from: classes8.dex */
public class C10591e {

    /* renamed from: iq.e$a */
    public class a implements InterfaceC11137i {

        /* renamed from: a */
        public final /* synthetic */ InterfaceC10596j f50962a;

        /* renamed from: b */
        public final /* synthetic */ Context f50963b;

        /* renamed from: c */
        public final /* synthetic */ String f50964c;

        public a(InterfaceC10596j interfaceC10596j, Context context, String str) {
            this.f50962a = interfaceC10596j;
            this.f50963b = context;
            this.f50964c = str;
        }

        @Override // p432kq.InterfaceC11137i
        public void onFailure(int i10, String str) {
            C12836o.m77097b("HuaweiIdOAuthService", "revoke fail", true);
            int iOptInt = 0;
            C12836o.m77097b("HuaweiIdOAuthService", "revoke fail response： " + str, false);
            try {
                iOptInt = new JSONObject(str).optInt("sub_error");
                C12836o.m77097b("HuaweiIdOAuthService", "revoke fail:server errorCode=" + iOptInt, true);
            } catch (JSONException unused) {
                C12836o.m77099d("HuaweiIdOAuthService", "revoke parse json exception", true);
            }
            this.f50962a.onResult(new C10597k(C10591e.m64986d(iOptInt, str, 0)));
            C13056a.m78783c(this.f50963b, 907115009, 0, "revoke fail", this.f50964c, "accountPickerH5.revoke", "api_ret");
        }

        @Override // p432kq.InterfaceC11137i
        public void onSuccess(String str) {
            C12836o.m77097b("HuaweiIdOAuthService", "revoke onSuccess", true);
            C12836o.m77097b("HuaweiIdOAuthService", "revoke onSuccess response： " + str, false);
            this.f50962a.onResult(new C10597k(new C10600n(200, "success")));
            C13056a.m78783c(this.f50963b, 907115009, 200, "revoke success", this.f50964c, "accountPickerH5.revoke", "api_ret");
        }
    }

    /* renamed from: b */
    public static void m64984b(Context context, InterfaceC10596j<C10588b> interfaceC10596j, String str) {
        try {
            CookieManager cookieManager = CookieManager.getInstance();
            cookieManager.setAcceptCookie(true);
            cookieManager.removeSessionCookie();
            cookieManager.removeAllCookie();
            C11990c.m72144k(context).m72137d("siteID");
            C12836o.m77097b("HuaweiIdOAuthService", "signOut success.", true);
            m64987e(context, interfaceC10596j, "");
        } catch (RuntimeException e10) {
            C12836o.m77099d("HuaweiIdOAuthService", "RuntimeException", true);
            m64985c(interfaceC10596j);
            C13056a.m78783c(context, 907115002, 404, "RuntimeException:" + e10.getMessage(), str, "accountPickerH5.signOut_v2", "api_ret");
        } catch (Exception e11) {
            C12836o.m77099d("HuaweiIdOAuthService", "Exception", true);
            m64985c(interfaceC10596j);
            C13056a.m78783c(context, 907115002, 404, "Exception:" + e11.getMessage(), str, "accountPickerH5.signOut_v2", "api_ret");
        }
    }

    /* renamed from: c */
    public static void m64985c(InterfaceC10596j<C10588b> interfaceC10596j) {
        C12836o.m77097b("HuaweiIdOAuthService", "setErrorResultCallBack start.", true);
        C10600n c10600n = new C10600n(404, "Sign Out Fail");
        c10600n.m64999e(false);
        interfaceC10596j.onResult(new C10588b(c10600n));
    }

    /* renamed from: d */
    public static C10600n m64986d(int i10, String str, int i11) {
        int i12;
        String str2;
        if (i10 == 31218 || i10 == 31202 || i10 == 11205 || i10 == 31204) {
            i12 = 2008;
            str2 = "AccessToken is invalid.";
        } else if (i10 == 60005) {
            i12 = 404;
            str2 = "Server handle error";
        } else {
            i12 = 2015;
            str2 = "oauth server inner error";
        }
        C12836o.m77097b("HuaweiIdOAuthService", "revoke fail  sdkErrorCode=" + i12 + " sdkErrCodeDes=" + str2, true);
        return new C10600n(i12, str2);
    }

    /* renamed from: e */
    public static void m64987e(Context context, InterfaceC10596j<C10588b> interfaceC10596j, String str) {
        C12836o.m77097b("HuaweiIdOAuthService", "setSuccessResultCallBack start.", true);
        C10600n c10600n = new C10600n(200, "Sign Out Success");
        c10600n.m64999e(true);
        interfaceC10596j.onResult(new C10588b(c10600n));
        C13056a.m78783c(context, 907115002, 200, "signOut success.", str, "accountPickerH5.signOut_v2", "api_ret");
    }

    /* renamed from: f */
    public static void m64988f(Context context, String str, String str2, InterfaceC10596j<C10597k> interfaceC10596j) throws C10593g {
        C12836o.m77097b("HuaweiIdOAuthService", "enter revoke", true);
        if (context == null) {
            C12836o.m77099d("HuaweiIdOAuthService", "mContext is null.", true);
            return;
        }
        String strM78781a = C13056a.m78781a();
        C13056a.m78783c(context, 907115009, 0, "enter revoke", strM78781a, "accountPickerH5.revoke", "api_entry");
        if (TextUtils.isEmpty(str2)) {
            C12836o.m77097b("HuaweiIdOAuthService", "revoke parameter error: AT invalid", true);
            C13056a.m78783c(context, 907115009, 404, "AT is empty", strM78781a, "accountPickerH5.revoke", "api_ret");
            throw new C10593g("AT is empty");
        }
        if (TextUtils.isEmpty(str)) {
            C12836o.m77097b("HuaweiIdOAuthService", "revoke parameter error: grsAppName invalid", true);
            C13056a.m78783c(context, 907115009, 404, "grsAppName is empty", strM78781a, "accountPickerH5.revoke", "api_ret");
            throw new C10593g("grsAppName is empty");
        }
        if (interfaceC10596j == null) {
            C12836o.m77097b("HuaweiIdOAuthService", "revoke parameter error: resultCallBack is null", true);
            C13056a.m78783c(context, 907115009, 404, "ResultResultCallBack is null", strM78781a, "accountPickerH5.revoke", "api_ret");
            throw new C10593g("ResultResultCallBack is null");
        }
        if (C12824c.m76979A(context)) {
            C11139k.m66996a().m66997b(context, str, new C11133e(context, str2), new a(interfaceC10596j, context, strM78781a));
            return;
        }
        C12836o.m77099d("HuaweiIdOAuthService", "network is unavailable.", true);
        C13056a.m78783c(context, 907115009, 2005, "Network is Unavailable", strM78781a, "accountPickerH5.revoke", "api_ret");
        C10600n c10600n = new C10600n(2005, "Network is Unavailable");
        c10600n.m64999e(false);
        interfaceC10596j.onResult(new C10597k(c10600n));
    }

    /* renamed from: g */
    public static void m64989g(Activity activity, String str, String str2, String[] strArr, String str3, String str4, String str5, boolean z10, InterfaceC10596j<C10598l> interfaceC10596j) throws C10593g {
        if (activity == null) {
            C12836o.m77099d("HuaweiIdOAuthService", "activity is null.", true);
            return;
        }
        C10590d c10590dM64977a = new C10590d.b(activity).m64979c(str2).m64982f(strArr).m64981e(str3).m64980d(str4).m64978b(interfaceC10596j).m64977a();
        if (TextUtils.isEmpty(str5)) {
            c10590dM64977a.m64975i(str);
        } else {
            c10590dM64977a.m64976j(str, str5, z10);
        }
    }

    /* renamed from: h */
    public static void m64990h(Context context, InterfaceC10596j<C10588b> interfaceC10596j) throws C10593g {
        C12836o.m77097b("HuaweiIdOAuthService", "signOut start.", true);
        if (context == null) {
            C12836o.m77099d("HuaweiIdOAuthService", "context is null.", true);
            return;
        }
        String strM78781a = C13056a.m78781a();
        C13056a.m78783c(context, 907115002, 0, "signOut start.", strM78781a, "accountPickerH5.signOut_v2", "api_entry");
        if (interfaceC10596j != null) {
            m64984b(context, interfaceC10596j, strM78781a);
        } else {
            C12836o.m77099d("HuaweiIdOAuthService", "resultResultCallBack is null.", true);
            C13056a.m78783c(context, 907115002, 404, "resultResultCallBack is null.", strM78781a, "accountPickerH5.signOut_v2", "api_ret");
            throw new C10593g("resultCallback is empty");
        }
    }
}
