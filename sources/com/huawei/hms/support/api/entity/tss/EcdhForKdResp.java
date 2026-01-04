package com.huawei.hms.support.api.entity.tss;

import com.huawei.hms.support.api.entity.tss.base.BaseResp;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class EcdhForKdResp extends BaseResp {
    private String[] ecdhKey;

    public EcdhForKdResp() {
    }

    public String[] getEcdhKey() {
        String[] strArr = this.ecdhKey;
        return strArr != null ? (String[]) strArr.clone() : new String[0];
    }

    public void setEcdhKey(String[] strArr) {
        if (strArr != null) {
            this.ecdhKey = (String[]) strArr.clone();
        } else {
            this.ecdhKey = new String[0];
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("[");
        if (this.ecdhKey != null) {
            for (int i10 = 0; i10 < this.ecdhKey.length; i10++) {
                if (i10 != 0) {
                    sb2.append(",");
                }
                sb2.append(this.ecdhKey[i10]);
            }
        }
        sb2.append("]");
        return "EcdhForKdResp{ecdhKey=" + ((Object) sb2) + '}';
    }

    public EcdhForKdResp(String str) throws JSONException {
        JSONArray jSONArrayOptJSONArray = new JSONObject(str).optJSONArray("ecdhKey");
        if (jSONArrayOptJSONArray != null) {
            this.ecdhKey = new String[jSONArrayOptJSONArray.length()];
            for (int i10 = 0; i10 < jSONArrayOptJSONArray.length(); i10++) {
                this.ecdhKey[i10] = jSONArrayOptJSONArray.optString(i10);
            }
        }
    }
}
