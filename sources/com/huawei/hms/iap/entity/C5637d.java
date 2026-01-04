package com.huawei.hms.iap.entity;

import com.huawei.hms.core.aidl.AbstractMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;
import java.util.List;

/* renamed from: com.huawei.hms.iap.entity.d */
/* loaded from: classes8.dex */
public class C5637d extends AbstractMessageEntity {

    @Packed
    private String continuationToken;

    @Packed
    private String errMsg;

    @Packed
    private List<String> inAppPurchaseDataList;

    @Packed
    private List<String> inAppSignatureList;

    @Packed
    private List<String> itemList;

    @Packed
    private List<String> placedInappPurchaseDataList;

    @Packed
    private List<String> placedInappSignatureList;

    @Packed
    private int returnCode;

    @Packed
    private String signatureAlgorithm;

    public String getContinuationToken() {
        return this.continuationToken;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

    public List<String> getInAppPurchaseDataList() {
        return this.inAppPurchaseDataList;
    }

    public List<String> getInAppSignatureList() {
        return this.inAppSignatureList;
    }

    public List<String> getItemList() {
        return this.itemList;
    }

    public List<String> getPlacedInappPurchaseDataList() {
        return this.placedInappPurchaseDataList;
    }

    public List<String> getPlacedInappSignatureList() {
        return this.placedInappSignatureList;
    }

    public int getReturnCode() {
        return this.returnCode;
    }

    public String getSignatureAlgorithm() {
        return this.signatureAlgorithm;
    }
}
