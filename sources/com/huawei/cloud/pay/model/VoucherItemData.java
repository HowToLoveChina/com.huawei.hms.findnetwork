package com.huawei.cloud.pay.model;

/* loaded from: classes5.dex */
public class VoucherItemData {
    private boolean isSelected = false;
    private int itemType;
    private String title;
    private Voucher voucher;

    public int getItemType() {
        return this.itemType;
    }

    public String getTitle() {
        return this.title;
    }

    public Voucher getVoucher() {
        return this.voucher;
    }

    public boolean isSelected() {
        return this.isSelected;
    }

    public void setItemType(int i10) {
        this.itemType = i10;
    }

    public void setSelected(boolean z10) {
        this.isSelected = z10;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setVoucher(Voucher voucher) {
        this.voucher = voucher;
    }
}
