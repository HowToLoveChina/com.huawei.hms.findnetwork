package com.huawei.hms.support.account.request;

import com.huawei.hms.hwid.C5599ap;
import com.huawei.hms.hwid.C5602as;
import com.huawei.hms.support.api.entity.auth.PermissionInfo;
import com.huawei.hms.support.api.entity.auth.Scope;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.huawei.hms.support.feature.request.AbstractAuthParams;
import com.huawei.hms.support.feature.request.AbstractAuthParamsHelper;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class AccountAuthParamsHelper extends AbstractAuthParamsHelper {

    /* renamed from: a */
    private String f29748a = "";

    /* renamed from: b */
    private int f29749b = 2;

    /* renamed from: c */
    private boolean f29750c = false;

    /* renamed from: d */
    private boolean f29751d = false;

    public AccountAuthParamsHelper() {
    }

    public AccountAuthParams createParams() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sessionId", this.f29748a);
            jSONObject.put("idTokenSignAlg", this.f29749b);
            jSONObject.put("needForceRefresh", this.f29750c);
            jSONObject.put(CommonConstant.RequestParams.KEY_ID_NEED_CONSENT, this.f29751d);
            return new AccountAuthParams(this.signInScopes, this.permissionSet, jSONObject.toString());
        } catch (JSONException e10) {
            C5602as.m32912d("AccountAuthParamsHelper", "JSONException：" + e10.getClass().getSimpleName(), true);
            return new AccountAuthParams(this.signInScopes, this.permissionSet);
        }
    }

    @Deprecated
    public AccountAuthParamsHelper setAccessToken() {
        PermissionInfo permissionInfo = new PermissionInfo();
        permissionInfo.setPermissionUri("https://www.huawei.com/auth/account/base.profile/accesstoken");
        this.permissionSet.add(permissionInfo);
        return this;
    }

    public AccountAuthParamsHelper setAssistToken() {
        PermissionInfo permissionInfo = new PermissionInfo();
        permissionInfo.setPermissionUri(CommonConstant.PERMISSION.ASSIST_TOKEN);
        this.permissionSet.add(permissionInfo);
        this.signInScopes.add(new Scope(CommonConstant.SCOPE.SCOPE_ASSIST_TOKEN));
        return this;
    }

    public AccountAuthParamsHelper setAuthorizationCode() {
        PermissionInfo permissionInfo = new PermissionInfo();
        permissionInfo.setPermissionUri("https://www.huawei.com/auth/account/base.profile/serviceauthcode");
        this.permissionSet.add(permissionInfo);
        return this;
    }

    public AccountAuthParamsHelper setCarrierId() {
        PermissionInfo permissionInfo = new PermissionInfo();
        permissionInfo.setPermissionUri(CommonConstant.LocalPermission.CARRIER_ID);
        this.permissionSet.add(permissionInfo);
        return this;
    }

    @Deprecated
    public AccountAuthParamsHelper setDialogAuth() {
        return this;
    }

    public AccountAuthParamsHelper setEmail() {
        return setScope(AbstractAuthParams.EMAIL);
    }

    public AccountAuthParamsHelper setForceLogout() {
        PermissionInfo permissionInfo = new PermissionInfo();
        permissionInfo.setPermissionUri(CommonConstant.LocalPermission.SETFORCELOGOUT);
        this.permissionSet.add(permissionInfo);
        return this;
    }

    public AccountAuthParamsHelper setForceRefresh() {
        this.f29750c = true;
        return this;
    }

    public AccountAuthParamsHelper setId() {
        return setScope(AbstractAuthParams.OPENID);
    }

    public AccountAuthParamsHelper setIdToken() {
        this.permissionSet.add(new PermissionInfo().setPermissionUri("idtoken"));
        return this;
    }

    public AccountAuthParamsHelper setIdTokenSignAlg(int i10) {
        this.f29749b = i10;
        return this;
    }

    public AccountAuthParamsHelper setMobileNumber() {
        setAccessToken();
        setId();
        return setScope(new Scope("https://www.huawei.com/auth/account/mobile.number"));
    }

    public AccountAuthParamsHelper setNeedConsent() {
        this.f29751d = true;
        return this;
    }

    public AccountAuthParamsHelper setProfile() {
        return setScope(AbstractAuthParams.PROFILE);
    }

    public AccountAuthParamsHelper setScope(Scope scope) {
        this.signInScopes.add(scope);
        return this;
    }

    public AccountAuthParamsHelper setScopeList(List<Scope> list) {
        if (C5599ap.m32901b(list).booleanValue()) {
            for (Scope scope : list) {
                if (scope != null && scope.getScopeUri() != null) {
                    this.signInScopes.add(scope);
                }
            }
        }
        return this;
    }

    public AccountAuthParamsHelper setSessionId(String str) {
        this.f29748a = str;
        return this;
    }

    public AccountAuthParamsHelper setUid() {
        this.permissionSet.add(AbstractAuthParams.UID_DYNAMIC_PERMISSION);
        return this;
    }

    public AccountAuthParamsHelper(AccountAuthParams accountAuthParams) {
        this.signInScopes.addAll(accountAuthParams.getRequestScopeList());
        this.permissionSet.addAll(accountAuthParams.getPermissionInfos());
    }
}
