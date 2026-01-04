package com.huawei.hicloud.base.drive.user.model;

import com.huawei.cloud.base.util.InterfaceC4648p;
import ni.C11707b;

/* loaded from: classes6.dex */
public class KeyDetailInfo extends C11707b {

    @InterfaceC4648p
    private String encryptedKey;

    @InterfaceC4648p
    private String keySHA256;

    @InterfaceC4648p
    private Integer keyType;

    @InterfaceC4648p
    private String keyUuid;

    public String getEncryptedKey() {
        return this.encryptedKey;
    }

    public String getKeySHA256() {
        return this.keySHA256;
    }

    public Integer getKeyType() {
        return this.keyType;
    }

    public String getKeyUuid() {
        return this.keyUuid;
    }

    public void setEncryptedKey(String str) {
        this.encryptedKey = str;
    }

    public void setKeySHA256(String str) {
        this.keySHA256 = str;
    }

    public void setKeyType(Integer num) {
        this.keyType = num;
    }

    public void setKeyUuid(String str) {
        this.keyUuid = str;
    }
}
