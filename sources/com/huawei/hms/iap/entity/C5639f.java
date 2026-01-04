package com.huawei.hms.iap.entity;

import com.huawei.hms.core.aidl.AbstractMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.huawei.hms.iap.entity.f */
/* loaded from: classes8.dex */
public class C5639f extends AbstractMessageEntity {

    @Packed
    private String errMsg;

    @Packed
    private int returnCode;

    @Packed
    private List<C5638e> skuList;

    public String getErrMsg() {
        return this.errMsg;
    }

    public List<ProductInfo> getProductInfoList() {
        ArrayList arrayList = new ArrayList();
        List<C5638e> list = this.skuList;
        if (list == null) {
            return arrayList;
        }
        Iterator<C5638e> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().toProductInfo());
        }
        return arrayList;
    }

    public int getReturnCode() {
        return this.returnCode;
    }
}
