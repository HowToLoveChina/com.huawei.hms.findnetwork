package com.huawei.hicloud.request.userk.bean;

/* loaded from: classes6.dex */
public class UserKeyBaseReq extends EncryptBaseReq {
    public static final int BUSINESS_TYPE_BACKUP = 1;
    public static final int BUSINESS_TYPE_SYNC = 0;
    public static final String KEY_TYPE_AES_128 = "AES_128";
    public static final String KEY_TYPE_AES_128_FULL = "AES_128_CBC_PKCS5Padding";
    public static final String KEY_TYPE_AES_192 = "AES_192";
    public static final String KEY_TYPE_AES_256 = "AES_256";
    public static final String KEY_TYPE_AES_256_FULL = "AES_256_CBC_PKCS5Padding";
    protected int businessType;
    protected String keyType;

    public UserKeyBaseReq(int i10, String str, String str2) {
        super(i10, str, str2);
        this.keyType = KEY_TYPE_AES_128;
    }

    public int getBusinessType() {
        return this.businessType;
    }

    public String getKeyType() {
        return this.keyType;
    }

    public void setBusinessType(int i10) {
        this.businessType = i10;
    }

    public void setKeyType(String str) {
        this.keyType = str;
    }

    public UserKeyBaseReq(int i10, String str) {
        super(i10, str);
        this.keyType = KEY_TYPE_AES_128;
    }
}
