package com.huawei.hms.iap.entity;

import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.security.SecureRandom;
import java.util.Locale;

/* loaded from: classes8.dex */
public class PurchaseIntentReq extends BaseReq {

    @Packed
    private String developerPayload;

    @Packed
    private int priceType;

    @Packed
    private String productId;

    @Packed
    private String signatureAlgorithm;

    @Packed
    private String transactionId = createTransactionId();

    private static String createTransactionId() {
        return (System.currentTimeMillis() + "") + String.format(Locale.ENGLISH, "%06d", Integer.valueOf(new SecureRandom().nextInt(Constants.MILLON)));
    }

    public String getDeveloperPayload() {
        return this.developerPayload;
    }

    public int getPriceType() {
        return this.priceType;
    }

    public String getProductId() {
        return this.productId;
    }

    public String getSignatureAlgorithm() {
        return this.signatureAlgorithm;
    }

    public void setDeveloperPayload(String str) {
        this.developerPayload = str;
    }

    public void setPriceType(int i10) {
        this.priceType = i10;
    }

    public void setProductId(String str) {
        this.productId = str;
    }

    public void setSignatureAlgorithm(String str) {
        this.signatureAlgorithm = str;
    }
}
