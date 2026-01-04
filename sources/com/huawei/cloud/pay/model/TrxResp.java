package com.huawei.cloud.pay.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* loaded from: classes5.dex */
public class TrxResp extends Response {
    private String cursor;

    @SerializedName("transactions")
    private List<TransactionItem> trxItems;

    public String getCursor() {
        return this.cursor;
    }

    public List<TransactionItem> getTrxItems() {
        return this.trxItems;
    }

    public void setCursor(String str) {
        this.cursor = str;
    }

    public void setTrxItems(List<TransactionItem> list) {
        this.trxItems = list;
    }
}
