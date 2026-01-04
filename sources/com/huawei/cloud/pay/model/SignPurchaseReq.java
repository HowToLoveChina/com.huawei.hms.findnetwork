package com.huawei.cloud.pay.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/* loaded from: classes5.dex */
public class SignPurchaseReq extends Request {
    private Map<String, String> campaignExt;
    private ChannelInfo channel;
    private int checkRe;
    private BigDecimal deductAmount;
    private long hmsVer;

    /* renamed from: id */
    private String f21416id;
    private OrderPrefission prefission;
    private String receiverAccount;
    private List<VoucherInfo> vouchers;

    public SignPurchaseReq(String str, String str2, ChannelInfo channelInfo, Map<String, String> map, List<VoucherInfo> list, String str3, int i10, BigDecimal bigDecimal, long j10) {
        super(str);
        this.f21416id = str2;
        this.channel = channelInfo;
        this.campaignExt = map;
        this.vouchers = list;
        this.receiverAccount = str3;
        this.checkRe = i10;
        this.deductAmount = bigDecimal;
        this.hmsVer = j10;
    }

    public Map<String, String> getCampaignExt() {
        return this.campaignExt;
    }

    public ChannelInfo getChannel() {
        return this.channel;
    }

    public int getCheckRe() {
        return this.checkRe;
    }

    public BigDecimal getDeductAmount() {
        return this.deductAmount;
    }

    public long getHmsVer() {
        return this.hmsVer;
    }

    public String getId() {
        return this.f21416id;
    }

    public OrderPrefission getPrefission() {
        return this.prefission;
    }

    public String getReceiverAccount() {
        return this.receiverAccount;
    }

    public List<VoucherInfo> getVouchers() {
        return this.vouchers;
    }

    public void setCampaignExt(Map<String, String> map) {
        this.campaignExt = map;
    }

    public void setChannel(ChannelInfo channelInfo) {
        this.channel = channelInfo;
    }

    public void setCheckRe(int i10) {
        this.checkRe = i10;
    }

    public void setDeductAmount(BigDecimal bigDecimal) {
        this.deductAmount = bigDecimal;
    }

    public void setHmsVer(long j10) {
        this.hmsVer = j10;
    }

    public void setId(String str) {
        this.f21416id = str;
    }

    public void setPrefission(OrderPrefission orderPrefission) {
        this.prefission = orderPrefission;
    }

    public void setReceiverAccount(String str) {
        this.receiverAccount = str;
    }

    public void setVouchers(List<VoucherInfo> list) {
        this.vouchers = list;
    }
}
