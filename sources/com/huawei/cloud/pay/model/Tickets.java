package com.huawei.cloud.pay.model;

/* loaded from: classes5.dex */
public class Tickets extends Voucher {
    private static final long serialVersionUID = 1;
    private String activityCode;
    private String exchangeCode;

    /* renamed from: id */
    private String f21418id;
    private String name;
    private String ticketType;

    @Override // com.huawei.cloud.pay.model.Voucher
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public String getActivityCode() {
        return this.activityCode;
    }

    public String getExchangeCode() {
        return this.exchangeCode;
    }

    public String getId() {
        return this.f21418id;
    }

    public String getName() {
        return this.name;
    }

    public String getTicketType() {
        return this.ticketType;
    }

    @Override // com.huawei.cloud.pay.model.Voucher
    public int hashCode() {
        return super.hashCode();
    }

    public void setActivityCode(String str) {
        this.activityCode = str;
    }

    public void setExchangeCode(String str) {
        this.exchangeCode = str;
    }

    public void setId(String str) {
        this.f21418id = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setTicketType(String str) {
        this.ticketType = str;
    }
}
