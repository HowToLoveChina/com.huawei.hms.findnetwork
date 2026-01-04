package com.huawei.hms.support.account.request;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.huawei.hms.common.internal.constant.AuthInternalPickerConstant;
import com.huawei.hms.support.api.entity.auth.PermissionInfo;
import com.huawei.hms.support.api.entity.auth.Scope;
import com.huawei.hms.support.feature.request.AbstractAuthParams;
import java.util.ArrayList;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class AccountAuthParams extends AbstractAuthParams {

    /* renamed from: a */
    private String f29746a;

    /* renamed from: b */
    private int f29747b;
    public static final AccountAuthParams DEFAULT_AUTH_REQUEST_PARAM = new AccountAuthParamsHelper().setId().setProfile().createParams();
    public static final AccountAuthParams DEFAULT_AUTH_REQUEST_PARAM_GAME = new AccountAuthParamsHelper().setScope(AbstractAuthParams.SCOPE_GAMES).createParams();
    public static final Parcelable.Creator<AccountAuthParams> CREATOR = new Parcelable.Creator<AccountAuthParams>() { // from class: com.huawei.hms.support.account.request.AccountAuthParams.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public AccountAuthParams createFromParcel(Parcel parcel) {
            return new AccountAuthParams(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public AccountAuthParams[] newArray(int i10) {
            return new AccountAuthParams[i10];
        }
    };

    /* renamed from: com.huawei.hms.support.account.request.AccountAuthParams$1 */
    public class C63111 implements Parcelable.Creator<AccountAuthParams> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public AccountAuthParams createFromParcel(Parcel parcel) {
            return new AccountAuthParams(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public AccountAuthParams[] newArray(int i10) {
            return new AccountAuthParams[i10];
        }
    }

    public /* synthetic */ AccountAuthParams(Parcel parcel, C63111 c63111) {
        this(parcel);
    }

    public static AccountAuthParams fromJson(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return fromJsonObject(new JSONObject(str));
    }

    public static AccountAuthParams fromJsonObject(JSONObject jSONObject) throws JSONException {
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
        AccountAuthParams accountAuthParams = new AccountAuthParams((ArrayList<Scope>) arrayList, (ArrayList<PermissionInfo>) arrayList2);
        accountAuthParams.setSignInParams(strOptString);
        return accountAuthParams;
    }

    @Override // com.huawei.hms.support.feature.request.AbstractAuthParams
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AccountAuthParams)) {
            return false;
        }
        AccountAuthParams accountAuthParams = (AccountAuthParams) obj;
        return isListEquals(this.scopeArrayList, accountAuthParams.scopeArrayList) && isListEquals(this.permissionArrayList, accountAuthParams.permissionArrayList);
    }

    public int getIdTokenSignAlg() {
        return this.f29747b;
    }

    public String getSignInParams() {
        return this.f29746a;
    }

    @Override // com.huawei.hms.support.feature.request.AbstractAuthParams
    public int hashCode() {
        ArrayList<Scope> arrayList = this.scopeArrayList;
        int iHashCode = ((arrayList == null ? 0 : arrayList.hashCode()) + 31) * 31;
        ArrayList<PermissionInfo> arrayList2 = this.permissionArrayList;
        return iHashCode + (arrayList2 != null ? arrayList2.hashCode() : 0);
    }

    public void setIdTokenSignAlg(int i10) {
        this.f29747b = i10;
    }

    public void setSignInParams(String str) {
        this.f29746a = str;
    }

    @Override // com.huawei.hms.support.feature.request.AbstractAuthParams
    public JSONObject toJsonObject() throws JSONException {
        JSONObject jsonObject = super.toJsonObject();
        jsonObject.put("signInParams", this.f29746a);
        return jsonObject;
    }

    public AccountAuthParams(Set<Scope> set, Set<PermissionInfo> set2) {
        this((ArrayList<Scope>) new ArrayList(set), (ArrayList<PermissionInfo>) new ArrayList(set2));
    }

    public AccountAuthParams(Set<Scope> set, Set<PermissionInfo> set2, String str) {
        this((ArrayList<Scope>) new ArrayList(set), (ArrayList<PermissionInfo>) new ArrayList(set2));
        this.f29746a = str;
    }

    public AccountAuthParams(ArrayList<Scope> arrayList, ArrayList<PermissionInfo> arrayList2) {
        super(arrayList, arrayList2);
        this.f29746a = "";
    }

    public AccountAuthParams(ArrayList<Scope> arrayList, ArrayList<PermissionInfo> arrayList2, String str) {
        super(arrayList, arrayList2);
        this.f29746a = str;
    }

    private AccountAuthParams(Parcel parcel) {
        super((ArrayList<Scope>) parcel.createTypedArrayList(Scope.CREATOR), (ArrayList<PermissionInfo>) parcel.createTypedArrayList(PermissionInfo.CREATOR));
        this.f29746a = "";
        this.f29746a = parcel.readString();
    }
}
