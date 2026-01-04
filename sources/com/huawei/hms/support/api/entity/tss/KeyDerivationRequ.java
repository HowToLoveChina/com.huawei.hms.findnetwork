package com.huawei.hms.support.api.entity.tss;

import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.support.api.entity.tss.base.BaseRequ;
import com.huawei.hms.support.api.entity.tss.kms.KeyProperty;
import com.huawei.hms.support.log.HMSLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class KeyDerivationRequ extends BaseRequ {
    private static final String TAG = "KeyDerivationRequ";

    @Packed
    private String alias;

    @Packed
    private int derivationType;

    @Packed
    private int keyAlgorithm;

    @Packed
    private KeyProperty keyProperty;

    @Packed
    private String[] newAlias;

    @Packed
    private String tmpECPrivKey;

    @Packed
    private String tmpECPubKey;

    @Packed
    private String[] tmpKey;

    public String getAlias() {
        return this.alias;
    }

    public int getDerivationType() {
        return this.derivationType;
    }

    public int getKeyAlgorithm() {
        return this.keyAlgorithm;
    }

    public KeyProperty getKeyProperty() {
        return this.keyProperty;
    }

    public String[] getNewAlias() {
        String[] strArr = this.newAlias;
        return strArr != null ? (String[]) strArr.clone() : new String[0];
    }

    public String getTmpECPrivKey() {
        return this.tmpECPrivKey;
    }

    public String getTmpECPubKey() {
        return this.tmpECPubKey;
    }

    public String[] getTmpKey() {
        String[] strArr = this.tmpKey;
        return strArr != null ? (String[]) strArr.clone() : new String[0];
    }

    public void setAlias(String str) {
        this.alias = str;
    }

    public void setDerivationType(int i10) {
        this.derivationType = i10;
    }

    public void setKeyAlgorithm(int i10) {
        this.keyAlgorithm = i10;
    }

    public void setKeyProperty(KeyProperty keyProperty) {
        this.keyProperty = keyProperty;
    }

    public void setNewAlias(String[] strArr) {
        if (strArr != null) {
            this.newAlias = (String[]) strArr.clone();
        } else {
            this.newAlias = new String[0];
        }
    }

    public void setTmpECPrivKey(String str) {
        this.tmpECPrivKey = str;
    }

    public void setTmpECPubKey(String str) {
        this.tmpECPubKey = str;
    }

    public void setTmpKey(String[] strArr) {
        if (strArr != null) {
            this.tmpKey = (String[]) strArr.clone();
        } else {
            this.tmpKey = new String[0];
        }
    }

    public String toJson(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("caller", str);
            jSONObject.put("alias", this.alias);
            jSONObject.put("derivationType", this.derivationType);
            jSONObject.put("tmpECPubKey", this.tmpECPubKey);
            jSONObject.put("tmpECPrivKey", this.tmpECPrivKey);
            JSONArray jSONArray = new JSONArray();
            if (this.tmpKey != null) {
                int i10 = 0;
                while (true) {
                    String[] strArr = this.tmpKey;
                    if (i10 >= strArr.length) {
                        break;
                    }
                    jSONArray.put(strArr[i10]);
                    i10++;
                }
            }
            jSONObject.put("tmpKey", jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            if (this.newAlias != null) {
                int i11 = 0;
                while (true) {
                    String[] strArr2 = this.newAlias;
                    if (i11 >= strArr2.length) {
                        break;
                    }
                    jSONArray2.put(strArr2[i11]);
                    i11++;
                }
            }
            jSONObject.put("newAlias", jSONArray2);
            jSONObject.put("keyAlgorithm", this.keyAlgorithm);
            if (this.keyProperty == null) {
                KeyProperty keyProperty = new KeyProperty();
                this.keyProperty = keyProperty;
                keyProperty.setDeviceSyned(false);
            }
            jSONObject.put("keyProperty", this.keyProperty.toJson());
        } catch (JSONException unused) {
            HMSLog.m36986e(TAG, "KeyDerivationRequ toJson failed.");
        }
        return jSONObject.toString();
    }
}
