package com.huawei.hms.identity.entity;

import android.content.Intent;
import android.util.Log;
import com.huawei.hms.identity.AddressConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public final class UserAddress {

    /* renamed from: a */
    private static final String f25460a = "addressClient";

    /* renamed from: b */
    private String f25461b;

    /* renamed from: c */
    private String f25462c;

    /* renamed from: d */
    private String f25463d;

    /* renamed from: e */
    private String f25464e;

    /* renamed from: f */
    private String f25465f;

    /* renamed from: g */
    private String f25466g;

    /* renamed from: h */
    private String f25467h;

    /* renamed from: i */
    private String f25468i;

    /* renamed from: j */
    private String f25469j;

    /* renamed from: k */
    private String f25470k;

    /* renamed from: l */
    private String f25471l;

    /* renamed from: m */
    private String f25472m;

    /* renamed from: n */
    private String f25473n;

    /* renamed from: o */
    private String f25474o;

    private UserAddress() {
    }

    public static UserAddress parseIntent(Intent intent) {
        String str;
        if (intent == null) {
            str = "The intent data is null.";
        } else {
            String stringExtra = intent.getStringExtra(AddressConstants.Extras.EXTRA_NAME_ADDRESS);
            if (stringExtra != null) {
                UserAddress userAddress = new UserAddress();
                try {
                    JSONObject jSONObject = new JSONObject(stringExtra);
                    userAddress.f25461b = jSONObject.optString("addressLine1");
                    userAddress.f25462c = jSONObject.optString("addressLine2");
                    userAddress.f25463d = jSONObject.optString("addressLine3");
                    userAddress.f25464e = jSONObject.optString("addressLine4");
                    userAddress.f25465f = jSONObject.optString("addressLine5");
                    userAddress.f25466g = jSONObject.optString("administrativeArea");
                    userAddress.f25467h = jSONObject.optString("companyName");
                    userAddress.f25468i = jSONObject.optString("countryCode");
                    userAddress.f25469j = jSONObject.optString("countryISOCode");
                    userAddress.f25470k = jSONObject.optString("emailAddress");
                    userAddress.f25471l = jSONObject.optString("locality");
                    userAddress.f25472m = jSONObject.optString("name");
                    userAddress.f25473n = jSONObject.optString("phoneNumber");
                    userAddress.f25474o = jSONObject.optString("postalNumber");
                } catch (JSONException e10) {
                    Log.e(f25460a, "parse address exception", e10);
                }
                return userAddress;
            }
            str = "The address is null.";
        }
        Log.e(f25460a, str);
        return null;
    }

    public String getAddressLine1() {
        return this.f25461b;
    }

    public String getAddressLine2() {
        return this.f25462c;
    }

    public String getAddressLine3() {
        return this.f25463d;
    }

    public String getAddressLine4() {
        return this.f25464e;
    }

    public String getAddressLine5() {
        return this.f25465f;
    }

    public String getAdministrativeArea() {
        return this.f25466g;
    }

    public String getCompanyName() {
        return this.f25467h;
    }

    public String getCountryCode() {
        return this.f25468i;
    }

    public String getCountryISOCode() {
        return this.f25469j;
    }

    public String getEmailAddress() {
        return this.f25470k;
    }

    public String getLocality() {
        return this.f25471l;
    }

    public String getName() {
        return this.f25472m;
    }

    public String getPhoneNumber() {
        return this.f25473n;
    }

    public String getPostalNumber() {
        return this.f25474o;
    }
}
