package com.huawei.android.hicloud.cbs.bean;

/* loaded from: classes2.dex */
public class CardTicketItemData {
    private String cardTicketName;
    private String cardTicketNameId;
    private int num;

    public CardTicketItemData(String str, int i10, String str2) {
        this.cardTicketName = str;
        this.num = i10;
        this.cardTicketNameId = str2;
    }

    public String getCardTicketName() {
        return this.cardTicketName;
    }

    public String getCardTicketNameId() {
        return this.cardTicketNameId;
    }

    public int getNum() {
        return this.num;
    }

    public void setCardTicketName(String str) {
        this.cardTicketName = str;
    }

    public void setCardTicketNameId(String str) {
        this.cardTicketNameId = str;
    }

    public void setNum(int i10) {
        this.num = i10;
    }
}
