package com.huawei.hms.support.api.entity.tss;

import com.huawei.hms.support.api.entity.tss.base.BaseResp;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class KeyDerivationResp extends BaseResp {
    private String[] newKeyEnc;
    private String[] newPubKey;

    public KeyDerivationResp() {
    }

    public String[] getNewKeyEnc() {
        String[] strArr = this.newKeyEnc;
        return strArr != null ? (String[]) strArr.clone() : new String[0];
    }

    public String[] getNewPubKey() {
        String[] strArr = this.newPubKey;
        return strArr != null ? (String[]) strArr.clone() : new String[0];
    }

    public void setNewKeyEnc(String[] strArr) {
        if (strArr != null) {
            this.newKeyEnc = (String[]) strArr.clone();
        } else {
            this.newKeyEnc = new String[0];
        }
    }

    public void setNewPubKey(String[] strArr) {
        if (strArr != null) {
            this.newPubKey = (String[]) strArr.clone();
        } else {
            this.newPubKey = new String[0];
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("[");
        if (this.newKeyEnc != null) {
            for (int i10 = 0; i10 < this.newKeyEnc.length; i10++) {
                if (i10 != 0) {
                    sb2.append(",");
                }
                sb2.append(this.newKeyEnc[i10]);
            }
        }
        sb2.append("]");
        StringBuilder sb3 = new StringBuilder("[");
        if (this.newPubKey != null) {
            for (int i11 = 0; i11 < this.newPubKey.length; i11++) {
                if (i11 != 0) {
                    sb3.append(",");
                }
                sb3.append(this.newPubKey[i11]);
            }
        }
        sb3.append("]");
        return "KeyDerivationResp{newKeyEnc: " + ((Object) sb2) + ", newPubKey: " + ((Object) sb3) + 125;
    }

    public KeyDerivationResp(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("newKeyEnc");
        if (jSONArrayOptJSONArray != null) {
            this.newKeyEnc = new String[jSONArrayOptJSONArray.length()];
            for (int i10 = 0; i10 < jSONArrayOptJSONArray.length(); i10++) {
                this.newKeyEnc[i10] = jSONArrayOptJSONArray.optString(i10);
            }
        }
        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("newPubKey");
        if (jSONArrayOptJSONArray2 != null) {
            this.newPubKey = new String[jSONArrayOptJSONArray2.length()];
            for (int i11 = 0; i11 < jSONArrayOptJSONArray2.length(); i11++) {
                this.newPubKey[i11] = jSONArrayOptJSONArray2.optString(i11);
            }
        }
    }
}
