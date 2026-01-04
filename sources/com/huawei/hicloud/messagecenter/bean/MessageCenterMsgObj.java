package com.huawei.hicloud.messagecenter.bean;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* loaded from: classes6.dex */
public class MessageCenterMsgObj extends BaseMsgObj {
    private String category;
    private int checkFamilyMember;
    private String context;

    @SerializedName("gotoDeeplinkUri")
    private String gotoDeeplinkUri;
    private String introductionH5Url;
    private String mainText;
    private String memberShareDetail;
    private String msgType;
    private int needShowBadge;
    private int notifyId;
    private String notifyType;
    private List<String> param;
    private String pictureUrl;
    private List<String> realTimeParam;
    private String recommendNeedData;
    private String richMsgContent;
    private int supportTrigger;
    private String titleText;
    private long totalNeedSpace;
    private String trigger;

    public String getCategory() {
        return this.category;
    }

    public int getCheckFamilyMember() {
        return this.checkFamilyMember;
    }

    public String getContext() {
        return this.context;
    }

    public String getGotoDeeplinkUri() {
        return this.gotoDeeplinkUri;
    }

    public String getIntroductionH5Url() {
        return this.introductionH5Url;
    }

    public String getMainText() {
        return this.mainText;
    }

    public String getMemberShareDetail() {
        return this.memberShareDetail;
    }

    public String getMsgType() {
        return this.msgType;
    }

    public int getNeedShowBadge() {
        return this.needShowBadge;
    }

    public int getNotifyId() {
        return this.notifyId;
    }

    public String getNotifyType() {
        return this.notifyType;
    }

    public List<String> getParam() {
        return this.param;
    }

    public String getPictureUrl() {
        return this.pictureUrl;
    }

    public List<String> getRealTimeParam() {
        return this.realTimeParam;
    }

    public String getRecommendNeedData() {
        return this.recommendNeedData;
    }

    public String getRichMsgContent() {
        return this.richMsgContent;
    }

    public int getSupportTrigger() {
        return this.supportTrigger;
    }

    public String getTitleText() {
        return this.titleText;
    }

    public long getTotalNeedSpace() {
        return this.totalNeedSpace;
    }

    public String getTrigger() {
        return this.trigger;
    }

    public void setCategory(String str) {
        this.category = str;
    }

    public void setCheckFamilyMember(int i10) {
        this.checkFamilyMember = i10;
    }

    public void setContext(String str) {
        this.context = str;
    }

    public void setGotoDeeplinkUri(String str) {
        this.gotoDeeplinkUri = str;
    }

    public void setIntroductionH5Url(String str) {
        this.introductionH5Url = str;
    }

    public void setMainText(String str) {
        this.mainText = str;
    }

    public void setMemberShareDetail(String str) {
        this.memberShareDetail = str;
    }

    public void setMsgType(String str) {
        this.msgType = str;
    }

    public void setNeedShowBadge(int i10) {
        this.needShowBadge = i10;
    }

    public void setNotifyId(int i10) {
        this.notifyId = i10;
    }

    public void setNotifyType(String str) {
        this.notifyType = str;
    }

    public void setParam(List<String> list) {
        this.param = list;
    }

    public void setPictureUrl(String str) {
        this.pictureUrl = str;
    }

    public void setRealTimeParam(List<String> list) {
        this.realTimeParam = list;
    }

    public void setRecommendNeedData(String str) {
        this.recommendNeedData = str;
    }

    public void setRichMsgContent(String str) {
        this.richMsgContent = str;
    }

    public void setSupportTrigger(int i10) {
        this.supportTrigger = i10;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public void setTotalNeedSpace(long j10) {
        this.totalNeedSpace = j10;
    }

    public void setTrigger(String str) {
        this.trigger = str;
    }
}
