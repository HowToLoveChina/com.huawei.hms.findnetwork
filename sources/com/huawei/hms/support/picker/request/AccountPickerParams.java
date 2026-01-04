package com.huawei.hms.support.picker.request;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.huawei.hms.common.internal.constant.AuthInternalPickerConstant;
import com.huawei.hms.support.api.entity.auth.PermissionInfo;
import com.huawei.hms.support.api.entity.auth.Scope;
import com.huawei.hms.support.api.entity.common.CommonPickerConstant;
import com.huawei.hms.support.feature.request.AbstractAuthParams;
import java.util.ArrayList;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class AccountPickerParams extends AbstractAuthParams implements Cloneable {
    private String mDeviceId;
    private String mDeviceInfo;
    private String mDeviceType;
    private String mGrsAppName;
    private String mHostAccessToken;
    private int mIdTokenSignAlg;
    private boolean mIsGuideLogin;
    private String mLoginUrl;
    private boolean mOobeFlag;
    private String mQRPromptFirstLevelType;
    private String mQRPromptSecondLevel;
    private String mRedirectUrl;
    private String signInParams;
    public static final AccountPickerParams DEFAULT_AUTH_REQUEST_PARAM = new AccountPickerParamsHelper().setId().setProfile().createParams();
    public static final AccountPickerParams DEFAULT_AUTH_REQUEST_PARAM_GAME = new AccountPickerParamsHelper().setScope(AbstractAuthParams.SCOPE_GAMES).createParams();
    public static final Parcelable.Creator<AccountPickerParams> CREATOR = new Parcelable.Creator<AccountPickerParams>() { // from class: com.huawei.hms.support.picker.request.AccountPickerParams.1
        @Override // android.os.Parcelable.Creator
        public AccountPickerParams createFromParcel(Parcel parcel) {
            return new AccountPickerParams(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public AccountPickerParams[] newArray(int i10) {
            return new AccountPickerParams[i10];
        }
    };

    /* renamed from: com.huawei.hms.support.picker.request.AccountPickerParams$1 */
    public class C65071 implements Parcelable.Creator<AccountPickerParams> {
        @Override // android.os.Parcelable.Creator
        public AccountPickerParams createFromParcel(Parcel parcel) {
            return new AccountPickerParams(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public AccountPickerParams[] newArray(int i10) {
            return new AccountPickerParams[i10];
        }
    }

    public /* synthetic */ AccountPickerParams(Parcel parcel, C65071 c65071) {
        this(parcel);
    }

    public static AccountPickerParams fromJson(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return fromJsonObject(new JSONObject(str));
    }

    public static AccountPickerParams fromJsonObject(JSONObject jSONObject) throws JSONException {
        JSONArray jSONArray = jSONObject.getJSONArray(AuthInternalPickerConstant.SignInReqKey.SCOP_ARRAYLIST);
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                arrayList.add(AbstractAuthParams.jsonToScope(jSONArray.getJSONObject(i10)));
            }
        }
        JSONArray jSONArray2 = jSONObject.getJSONArray(AuthInternalPickerConstant.SignInReqKey.PERMISSION_ARRAYLIST);
        ArrayList arrayList2 = new ArrayList();
        if (jSONArray2 != null) {
            for (int i11 = 0; i11 < jSONArray2.length(); i11++) {
                arrayList2.add(AbstractAuthParams.jsonToPermission(jSONArray2.getJSONObject(i11)));
            }
        }
        String strOptString = jSONObject.optString("signInParams");
        JSONObject jSONObject2 = new JSONObject(strOptString);
        String strOptString2 = jSONObject2.optString(CommonPickerConstant.RequestParams.KEY_REDIRECT_URL);
        String strOptString3 = jSONObject2.optString(CommonPickerConstant.RequestParams.KEY_DEVICE_INFO);
        boolean zOptBoolean = jSONObject2.optBoolean(CommonPickerConstant.RequestParams.KEY_GUIDE_LOGIN);
        String strOptString4 = jSONObject2.optString(CommonPickerConstant.RequestParams.KEY_LOGNIN_URL);
        String strOptString5 = jSONObject2.optString(CommonPickerConstant.RequestParams.KEY_QR_PROMPT_FIRST_LEVEL_TYPE);
        String strOptString6 = jSONObject2.optString(CommonPickerConstant.RequestParams.KEY_QR_PROMPT_SECOND_LEVEL);
        boolean zOptBoolean2 = jSONObject2.optBoolean(CommonPickerConstant.RequestParams.KEY_OOBE_FLAG);
        int iOptInt = jSONObject2.optInt("idTokenSignAlg");
        String strOptString7 = jSONObject2.optString(CommonPickerConstant.RequestParams.KEY_HOST_ACCESS_TOKEN);
        String strOptString8 = jSONObject2.optString(CommonPickerConstant.RequestParams.KEY_GRS_APP_NAME);
        AccountPickerParams accountPickerParams = new AccountPickerParams((ArrayList<Scope>) arrayList, (ArrayList<PermissionInfo>) arrayList2);
        accountPickerParams.setSignInParams(strOptString);
        accountPickerParams.setRedirectUrl(strOptString2);
        accountPickerParams.setDeviceInfo(strOptString3);
        accountPickerParams.setGuideLogin(zOptBoolean);
        accountPickerParams.setQRPromptFirstLevelType(strOptString5);
        accountPickerParams.setQRPromptSecondLevel(strOptString6);
        accountPickerParams.setOobeFlag(zOptBoolean2);
        accountPickerParams.setLoginUrl(strOptString4);
        accountPickerParams.setIdTokenSignAlg(iOptInt);
        accountPickerParams.setHostAccessToken(strOptString7);
        accountPickerParams.setGrsAppName(strOptString8);
        return accountPickerParams;
    }

    private void setDeviceInfo(String str) {
        this.mDeviceInfo = str;
    }

    private void setGuideLogin(boolean z10) {
        this.mIsGuideLogin = z10;
    }

    private void setLoginUrl(String str) {
        this.mLoginUrl = str;
    }

    private void setOobeFlag(boolean z10) {
        this.mOobeFlag = z10;
    }

    private void setQRPromptFirstLevelType(String str) {
        this.mQRPromptFirstLevelType = str;
    }

    private void setQRPromptSecondLevel(String str) {
        this.mQRPromptSecondLevel = str;
    }

    private void setRedirectUrl(String str) {
        this.mRedirectUrl = str;
    }

    @Override // com.huawei.hms.support.feature.request.AbstractAuthParams
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AccountPickerParams)) {
            return false;
        }
        AccountPickerParams accountPickerParams = (AccountPickerParams) obj;
        return isListEquals(this.scopeArrayList, accountPickerParams.scopeArrayList) && isListEquals(this.permissionArrayList, accountPickerParams.permissionArrayList);
    }

    public String getDeviceId() {
        return this.mDeviceId;
    }

    public String getDeviceInfo() {
        return this.mDeviceInfo;
    }

    public String getDeviceType() {
        return this.mDeviceType;
    }

    public String getGrsAppName() {
        return this.mGrsAppName;
    }

    public String getHostAccessToken() {
        return this.mHostAccessToken;
    }

    public int getIdTokenSignAlg() {
        return this.mIdTokenSignAlg;
    }

    public String getLoginUrl() {
        return this.mLoginUrl;
    }

    public boolean getOobeFlag() {
        return this.mOobeFlag;
    }

    public ArrayList<PermissionInfo> getPermissionArray() {
        return this.permissionArrayList;
    }

    public String getQRPromptFirstLevelType() {
        return this.mQRPromptFirstLevelType;
    }

    public String getQRPromptSecondLevel() {
        return this.mQRPromptSecondLevel;
    }

    public String getRedirectUrl() {
        return this.mRedirectUrl;
    }

    public String getSignInParams() {
        return this.signInParams;
    }

    public String[] getStringArray() {
        int size = this.scopeArrayList.size();
        String[] strArr = new String[size];
        for (int i10 = 0; i10 < size; i10++) {
            strArr[i10] = this.scopeArrayList.get(i10).getScopeUri();
        }
        return strArr;
    }

    @Override // com.huawei.hms.support.feature.request.AbstractAuthParams
    public int hashCode() {
        ArrayList<Scope> arrayList = this.scopeArrayList;
        int iHashCode = ((arrayList == null ? 0 : arrayList.hashCode()) + 31) * 31;
        ArrayList<PermissionInfo> arrayList2 = this.permissionArrayList;
        return iHashCode + (arrayList2 != null ? arrayList2.hashCode() : 0);
    }

    public boolean isGuideLogin() {
        return this.mIsGuideLogin;
    }

    public void setGrsAppName(String str) {
        this.mGrsAppName = str;
    }

    public void setHostAccessToken(String str) {
        this.mHostAccessToken = str;
    }

    public void setIdTokenSignAlg(int i10) {
        this.mIdTokenSignAlg = i10;
    }

    public void setSignInParams(String str) {
        this.signInParams = str;
    }

    @Override // com.huawei.hms.support.feature.request.AbstractAuthParams
    public JSONObject toJsonObject() throws JSONException {
        JSONObject jsonObject = super.toJsonObject();
        jsonObject.put("signInParams", this.signInParams);
        return jsonObject;
    }

    public AccountPickerParams(Set<Scope> set, Set<PermissionInfo> set2) {
        this((ArrayList<Scope>) new ArrayList(set), (ArrayList<PermissionInfo>) new ArrayList(set2));
    }

    /* renamed from: clone */
    public AccountPickerParams m85661clone() throws CloneNotSupportedException {
        return (AccountPickerParams) super.clone();
    }

    public AccountPickerParams(Set<Scope> set, Set<PermissionInfo> set2, String str) {
        this((ArrayList<Scope>) new ArrayList(set), (ArrayList<PermissionInfo>) new ArrayList(set2));
        this.signInParams = str;
    }

    public AccountPickerParams(ArrayList<Scope> arrayList, ArrayList<PermissionInfo> arrayList2) {
        super(arrayList, arrayList2);
        this.signInParams = "";
        this.mDeviceType = "";
        this.mDeviceId = "";
        this.mRedirectUrl = "";
        this.mDeviceInfo = "";
        this.mQRPromptFirstLevelType = "";
        this.mQRPromptSecondLevel = "";
        this.mLoginUrl = "";
    }

    public AccountPickerParams(ArrayList<Scope> arrayList, ArrayList<PermissionInfo> arrayList2, String str) {
        super(arrayList, arrayList2);
        this.mDeviceType = "";
        this.mDeviceId = "";
        this.mRedirectUrl = "";
        this.mDeviceInfo = "";
        this.mQRPromptFirstLevelType = "";
        this.mQRPromptSecondLevel = "";
        this.mLoginUrl = "";
        this.signInParams = str;
    }

    private AccountPickerParams(Parcel parcel) {
        super((ArrayList<Scope>) parcel.createTypedArrayList(Scope.CREATOR), (ArrayList<PermissionInfo>) parcel.createTypedArrayList(PermissionInfo.CREATOR));
        this.signInParams = "";
        this.mDeviceType = "";
        this.mDeviceId = "";
        this.mRedirectUrl = "";
        this.mDeviceInfo = "";
        this.mQRPromptFirstLevelType = "";
        this.mQRPromptSecondLevel = "";
        this.mLoginUrl = "";
        this.signInParams = parcel.readString();
    }
}
