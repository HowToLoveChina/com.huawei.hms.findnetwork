package com.huawei.cloud.pay.model;

import java.util.List;

/* loaded from: classes5.dex */
public class GetAllTicketsResp extends Response {
    private List<Tickets> tickets;
    private int totalCount;

    public List<Tickets> getTicketsList() {
        return this.tickets;
    }

    public int getTotalCount() {
        return this.totalCount;
    }

    public void setTicketsList(List<Tickets> list) {
        this.tickets = list;
    }

    public void setTotalCount(int i10) {
        this.totalCount = i10;
    }
}
