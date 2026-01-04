package com.huawei.cloud.pay.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/* loaded from: classes5.dex */
public class QuerySignStatusReq extends Request {
    private Map<String, String> campaignExt;
    private ChannelInfo channelInfo;
    private int checkRe;
    private BigDecimal deductAmount;

    /* renamed from: id */
    private String f21413id;
    private OrderPrefission prefission;
    private int supportVoucher;
    private String version;
    private List<VoucherInfo> voucherInfos;

    public QuerySignStatusReq(String str, int i10, String str2, ChannelInfo channelInfo, Map<String, String> map, BigDecimal bigDecimal) {
        super("querySignStatus");
        this.f21413id = str;
        this.checkRe = i10;
        this.version = str2;
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

    public int getCheckRe() {
        return this.checkRe;
    }

    public BigDecimal getDeductAmount() {
        return this.deductAmount;
    }

    public String getId() {
        return this.f21413id;
    }

    public OrderPrefission getPrefission() {
        return this.prefission;
    }

    public int getSupportVoucher() {
        return this.supportVoucher;
    }

    public String getVersion() {
        return this.version;
    }

    public List<VoucherInfo> getVoucherInfos() {
        return this.voucherInfos;
    }

    public void setCampaignExt(Map<String, String> map) {
        this.campaignExt = map;
    }

    public void setChannelInfo(ChannelInfo channelInfo) {
        this.channelInfo = channelInfo;
    }

    public void setCheckRe(int i10) {
        this.checkRe = i10;
    }

    public void setDeductAmount(BigDecimal bigDecimal) {
        this.deductAmount = bigDecimal;
    }

    public void setId(String str) {
        this.f21413id = str;
    }

    public void setPrefission(OrderPrefission orderPrefission) {
        this.prefission = orderPrefission;
    }

    public void setSupportVoucher(int i10) {
        this.supportVoucher = i10;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public void setVoucherInfos(List<VoucherInfo> list) {
        this.voucherInfos = list;
    }
}
