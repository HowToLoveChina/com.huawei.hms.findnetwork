package com.huawei.hms.support.picker.activity;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.p109a.p110a.p113c.C5040a;
import com.huawei.hms.support.api.entity.common.CommonPickerConstant;
import com.huawei.hms.support.picker.activity.AccountPickerSignInHubContract;
import com.huawei.hms.support.picker.common.AccountPickerUtil;
import com.huawei.hms.support.picker.result.AccountPickerResult;
import org.json.JSONException;
import org.json.JSONObject;
import p640sq.C12829h;
import p640sq.C12836o;
import p640sq.C12844w;

/* loaded from: classes8.dex */
public class AccountPickerSignInHubActivity extends Activity implements AccountPickerSignInHubContract.View {
    public static final int IDENTIFIER = 16587;
    public static final int IDENTIFIER_H5 = 16588;
    private static final String TAG = "AccountPickerSignInHubActivity";
    private AccountPickerSignInHubPresenter mPresenter;
    private boolean signInNotFoundActivity;
    private AccountPickerResult signInResult = null;

    private void addAccountAttr(String str, Intent intent, int i10, String str2) throws JSONException {
        C12836o.m77097b(TAG, "addAccountAttr start.", true);
        JSONObject jSONObject = new JSONObject(str);
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(CommonPickerConstant.RequestParams.KEY_SIGN_IN_HUAWEI_ID);
        if (jSONObjectOptJSONObject != null) {
            jSONObjectOptJSONObject.put("accountAttr", str2);
            C12836o.m77097b(TAG, "addAccountAttr: accountPickerJson = " + jSONObjectOptJSONObject.toString(), false);
            String strOptString = jSONObjectOptJSONObject.optString("serverAuthCode");
            C12836o.m77097b(TAG, "addAccountAttr: jsonObject = " + jSONObject.toString(), false);
            boolean zIsNeedRequestToken = this.mPresenter.isNeedRequestToken(str2);
            if (!TextUtils.isEmpty(strOptString) && zIsNeedRequestToken) {
                this.mPresenter.doTokenRequest(strOptString);
            }
            if (zIsNeedRequestToken) {
                return;
            }
        }
        intent.putExtra("HUAWEIID_SIGNIN_RESULT", jSONObject.toString());
        setResult(i10, intent);
        finish();
    }

    private void dealApkSignInResult(String str, Intent intent, int i10, int i11) {
        C12836o.m77097b(TAG, "dealApkSignInResult", true);
        int iSaveDataByApkOrH5 = saveDataByApkOrH5(i10, str);
        C12836o.m77097b(TAG, "statusCode is " + iSaveDataByApkOrH5, true);
        if (iSaveDataByApkOrH5 != 0) {
            if (20051 == iSaveDataByApkOrH5) {
                C12836o.m77097b(TAG, "logIn By H5", true);
                this.mPresenter.startWebViewActivity();
                return;
            } else {
                C12836o.m77097b(TAG, "logIn By APK failed", true);
                this.mPresenter.onSignInFailed(iSaveDataByApkOrH5);
                return;
            }
        }
        if (this.signInResult.getAuthAccountPicker() != null) {
            C12836o.m77097b(TAG, "onActivityResultFromApk SUCCESS", true);
            try {
                addAccountAttr(str, intent, i11, getAccountAttr(str));
            } catch (JSONException unused) {
                C12836o.m77099d(TAG, "onActivityResultFromApk: JsonException", true);
                this.mPresenter.onSignInFailed(i10);
            }
        }
    }

    private String getAccountAttr(String str) {
        C12836o.m77097b(TAG, "getAccountAttr start.", true);
        try {
            if (!AccountPickerUtil.isPcSimulator(str)) {
                return "0";
            }
            JSONObject jSONObjectOptJSONObject = new JSONObject(str).optJSONObject(CommonPickerConstant.RequestParams.KEY_SIGN_IN_HUAWEI_ID);
            return jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optString("accountAttr", "-1") : "-1";
        } catch (Exception e10) {
            C12836o.m77099d(TAG, "getAccountAttr: Exception = " + e10.getClass().getSimpleName(), true);
            return "-1";
        }
    }

    private void handleH5LoginResult(int i10, Intent intent, int i11) {
        C12836o.m77097b(TAG, "handleH5LoginResult start.", true);
        if (intent == null) {
            C12836o.m77099d(TAG, "data is null.", true);
            this.mPresenter.onSignInFailed(i11);
            return;
        }
        C12836o.m77097b(TAG, "data is not null", true);
        String stringExtra = intent.getStringExtra("HUAWEIID_SIGNIN_RESULT");
        C12836o.m77097b(TAG, "handleH5LoginResult: jsonSignInResult = " + stringExtra, false);
        if (stringExtra == null) {
            C12836o.m77097b(TAG, "handleH5LoginResult: jsonSignInResult is null", true);
            this.mPresenter.onSignInFailed(i11);
            return;
        }
        C12836o.m77097b(TAG, "jsonSignInResult is not null", true);
        int iSaveDataByApkOrH5 = saveDataByApkOrH5(i11, stringExtra);
        if (iSaveDataByApkOrH5 != 0 || this.signInResult.getAuthAccountPicker() == null) {
            C12836o.m77097b(TAG, "handleH5LoginResult: status code is invalid", true);
            this.mPresenter.onSignInFailed(iSaveDataByApkOrH5);
            return;
        }
        C12836o.m77097b(TAG, "onActivityResultFromH5 SUCCESS", true);
        try {
            addAccountAttr(stringExtra, intent, i10, "1");
        } catch (JSONException unused) {
            C12836o.m77099d(TAG, "onActivityResultFromH5: JsonException", true);
            this.mPresenter.onSignInFailed(i11);
        }
    }

    private void setStatusBar() {
        if (!C12829h.m77062g() || C12844w.m77138j(this)) {
            return;
        }
        getWindow().getDecorView().setSystemUiVisibility(9216);
    }

    @Override // com.huawei.hms.support.picker.activity.AccountPickerSignInHubContract.View
    public void exit(int i10, Intent intent) {
        setResult(i10, intent);
        finish();
    }

    @Override // android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        C12836o.m77097b(TAG, "onActivityResult: requestCode = " + i10 + "; resultCode = " + i11, true);
        if (!this.signInNotFoundActivity && i10 == 16587 && intent != null) {
            C12836o.m77097b(TAG, "data is not null", true);
            String stringExtra = intent.getStringExtra("HUAWEIID_SIGNIN_RESULT");
            if (stringExtra != null) {
                C12836o.m77097b(TAG, "jsonSignInResult is not null", true);
                dealApkSignInResult(stringExtra, intent, 2015, i11);
                return;
            }
        }
        if (i10 == 16588) {
            handleH5LoginResult(i11, intent, 2015);
            return;
        }
        if (i11 <= 0) {
            i11 = 2015;
        }
        this.mPresenter.onSignInFailed(i11);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        C12836o.m77097b(TAG, "onCreate", true);
        super.onCreate(bundle);
        setStatusBar();
        AccountPickerSignInHubPresenter accountPickerSignInHubPresenter = new AccountPickerSignInHubPresenter(this, this);
        this.mPresenter = accountPickerSignInHubPresenter;
        if (accountPickerSignInHubPresenter.initIntent(getIntent())) {
            if (this.mPresenter.mIsActivityFullScreen) {
                AccountPickerUtil.setFullScreenAdaptCutout(getWindow());
            } else {
                AccountPickerUtil.setStatusBarColor(this);
            }
            AccountPickerUtil.setEMUI10StatusBarColor(this);
            if (bundle != null) {
                this.mPresenter.restoreInstanceState(bundle);
            } else {
                this.mPresenter.checkMinVersion();
            }
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.mPresenter.onSaveInstanceState(bundle);
    }

    public int saveDataByApkOrH5(int i10, String str) {
        C12836o.m77097b(TAG, "saveDataByApkOrH5 start.", true);
        try {
            this.signInResult = new AccountPickerResult().fromJson(str);
            C5040a.m30081a().m30083a(this.signInResult.getAuthAccountPicker(), this.mPresenter.getSignInRequest().getAccountPickerParams());
            i10 = this.signInResult.getStatus().getStatusCode();
        } catch (JSONException unused) {
            this.signInResult = null;
            C12836o.m77099d(TAG, "saveDataByApkOrH5: JsonException", true);
        }
        this.mPresenter.report(i10);
        return i10;
    }

    @Override // com.huawei.hms.support.picker.activity.AccountPickerSignInHubContract.View
    public void startSignInActivity(Intent intent, int i10) {
        C12836o.m77097b(TAG, "startSignInActivity:requestCode = " + i10, true);
        if (intent == null) {
            C12836o.m77099d(TAG, "startSignInActivity:intent is null.", true);
            this.mPresenter.onSignInFailed(17);
            return;
        }
        try {
            startActivityForResult(intent, i10);
        } catch (ActivityNotFoundException e10) {
            this.signInNotFoundActivity = true;
            C12836o.m77099d(TAG, "Launch sign in Intent failed. hms is probably being updated：" + e10.getClass().getSimpleName(), true);
            this.mPresenter.onSignInFailed(17);
        }
    }
}
