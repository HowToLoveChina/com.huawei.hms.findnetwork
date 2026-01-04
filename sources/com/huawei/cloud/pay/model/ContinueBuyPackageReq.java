package com.huawei.cloud.pay.model;

import java.util.List;
import java.util.Map;

/* loaded from: classes5.dex */
public class ContinueBuyPackageReq extends BuyPackageReq {
    private ChannelInfo channelInfo;
    private int checkRe;
    private OrderPrefission prefission;
    private String receiverAccount;
    private int supportVoucher;
    private List<VoucherInfo> voucherInfos;

    public ContinueBuyPackageReq(String str, int i10, String str2, int i11, List<VoucherInfo> list, ChannelInfo channelInfo, Map<String, String> map) {
        super(str, map);
        this.checkRe = i10;
        this.receiverAccount = str2;
        this.supportVoucher = i11;
        this.voucherInfos = list;
        this.channelInfo = channelInfo;
    }

    public ChannelInfo getChannelInfo() {
        return this.channelInfo;
    }

    public int getCheckRe() {
        return this.checkRe;
    }

    public OrderPrefission getPrefission() {
        return this.prefission;
    }

    public String getReceiverAccount() {
        return this.receiverAccount;
    }

    public int getSupportVoucher() {
        return this.supportVoucher;
    }

    public List<VoucherInfo> getVoucherInfos() {
        return this.voucherInfos;
    }

    public void setChannelInfo(ChannelInfo channelInfo) {
        this.channelInfo = channelInfo;
    }

    public void setCheckRe(int i10) {
        this.checkRe = i10;
    }

    public void setPrefission(OrderPrefission orderPrefission) {
        this.prefission = orderPrefission;
    }

    public void setReceiverAccount(String str) {
        this.receiverAccount = str;
    }

    public void setSupportVoucher(int i10) {
        this.supportVoucher = i10;
    }

    public void setVoucherInfos(List<VoucherInfo> list) {
        this.voucherInfos = list;
    }
}
