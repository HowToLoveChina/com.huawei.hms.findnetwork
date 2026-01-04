package com.huawei.hms.support.hwid.request;

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
public class HuaweiIdAuthParams extends AbstractAuthParams implements Cloneable {

    /* renamed from: a */
    private String f30075a;
    public static final HuaweiIdAuthParams DEFAULT_AUTH_REQUEST_PARAM = new HuaweiIdAuthParamsHelper().setId().setProfile().createParams();
    public static final HuaweiIdAuthParams DEFAULT_AUTH_REQUEST_PARAM_GAME = new HuaweiIdAuthParamsHelper().setScope(AbstractAuthParams.SCOPE_GAMES).createParams();
    public static final Parcelable.Creator<HuaweiIdAuthParams> CREATOR = new Parcelable.Creator<HuaweiIdAuthParams>() { // from class: com.huawei.hms.support.hwid.request.HuaweiIdAuthParams.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public HuaweiIdAuthParams createFromParcel(Parcel parcel) {
            return new HuaweiIdAuthParams(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public HuaweiIdAuthParams[] newArray(int i10) {
            return new HuaweiIdAuthParams[i10];
        }
    };

    public static HuaweiIdAuthParams fromJson(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return fromJsonObject(new JSONObject(str));
    }

    public static HuaweiIdAuthParams fromJsonObject(JSONObject jSONObject) throws JSONException {
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
        HuaweiIdAuthParams huaweiIdAuthParams = new HuaweiIdAuthParams((ArrayList<Scope>) arrayList, (ArrayList<PermissionInfo>) arrayList2);
        huaweiIdAuthParams.setSignInParams(strOptString);
        return huaweiIdAuthParams;
    }

    @Override // com.huawei.hms.support.feature.request.AbstractAuthParams
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HuaweiIdAuthParams)) {
            return false;
        }
        HuaweiIdAuthParams huaweiIdAuthParams = (HuaweiIdAuthParams) obj;
        return isListEquals(this.scopeArrayList, huaweiIdAuthParams.scopeArrayList) && isListEquals(this.permissionArrayList, huaweiIdAuthParams.permissionArrayList);
    }

    @Override // com.huawei.hms.support.feature.request.AbstractAuthParams
    public int hashCode() {
        ArrayList<Scope> arrayList = this.scopeArrayList;
        int iHashCode = ((arrayList == null ? 0 : arrayList.hashCode()) + 31) * 31;
        ArrayList<PermissionInfo> arrayList2 = this.permissionArrayList;
        return iHashCode + (arrayList2 != null ? arrayList2.hashCode() : 0);
    }

    public void setSignInParams(String str) {
        this.f30075a = str;
    }

    @Override // com.huawei.hms.support.feature.request.AbstractAuthParams
    public JSONObject toJsonObject() throws JSONException {
        JSONObject jsonObject = super.toJsonObject();
        jsonObject.put("signInParams", this.f30075a);
        return jsonObject;
    }

    public HuaweiIdAuthParams(Set<Scope> set, Set<PermissionInfo> set2) {
        this((ArrayList<Scope>) new ArrayList(set), (ArrayList<PermissionInfo>) new ArrayList(set2));
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public HuaweiIdAuthParams m85660clone() throws CloneNotSupportedException {
        return (HuaweiIdAuthParams) super.clone();
    }

    public HuaweiIdAuthParams(Set<Scope> set, Set<PermissionInfo> set2, String str) {
        this((ArrayList<Scope>) new ArrayList(set), (ArrayList<PermissionInfo>) new ArrayList(set2));
        this.f30075a = str;
    }

    public HuaweiIdAuthParams(ArrayList<Scope> arrayList, ArrayList<PermissionInfo> arrayList2) {
        super(arrayList, arrayList2);
        this.f30075a = "";
    }

    public HuaweiIdAuthParams(ArrayList<Scope> arrayList, ArrayList<PermissionInfo> arrayList2, String str) {
        super(arrayList, arrayList2);
        this.f30075a = str;
    }

    private HuaweiIdAuthParams(Parcel parcel) {
        super((ArrayList<Scope>) parcel.createTypedArrayList(Scope.CREATOR), (ArrayList<PermissionInfo>) parcel.createTypedArrayList(PermissionInfo.CREATOR));
        this.f30075a = "";
        this.f30075a = parcel.readString();
    }
}
