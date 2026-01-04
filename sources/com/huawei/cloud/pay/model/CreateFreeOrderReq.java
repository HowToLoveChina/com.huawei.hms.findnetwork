package com.huawei.cloud.pay.model;

import java.math.BigDecimal;
import java.util.Map;

/* loaded from: classes5.dex */
public class CreateFreeOrderReq extends Request {
    private Map<String, String> campaignExt;
    private ChannelInfo channelInfo;
    private BigDecimal deductAmount;

    /* renamed from: id */
    private String f21404id;
    private OrderPrefission prefission;

    public CreateFreeOrderReq(String str, ChannelInfo channelInfo, Map<String, String> map, BigDecimal bigDecimal) {
        super("createFreeOrder");
        this.f21404id = str;
        this.channelInfo = channelInfo;
        this.campaignExt = map;
        this.deductAmount = bigDecimal;
    }

    public Map<String, String> getCampaignExt() {
        return this.campaignExt;
    }

    public ChannelInfo getChannelInfo() {
        return this.channelInfo;
    }

    public BigDecimal getDeductAmount() {
        return this.deductAmount;
    }

    public String getId() {
        return this.f21404id;
    }

    public OrderPrefission getPrefission() {
        return this.prefission;
    }

    public void setCampaignExt(Map<String, String> map) {
        this.campaignExt = map;
    }

    public void setChannelInfo(ChannelInfo channelInfo) {
        this.channelInfo = channelInfo;
    }

    public void setDeductAmount(BigDecimal bigDecimal) {
        this.deductAmount = bigDecimal;
    }

    public void setId(String str) {
        this.f21404id = str;
    }

    public void setPrefission(OrderPrefission orderPrefission) {
        this.prefission = orderPrefission;
    }
}
