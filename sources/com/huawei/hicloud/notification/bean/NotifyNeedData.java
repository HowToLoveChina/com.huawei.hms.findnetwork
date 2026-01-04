package com.huawei.hicloud.notification.bean;

import android.app.PendingIntent;
import android.os.Bundle;
import com.huawei.hicloud.notification.p106db.bean.MemberShareDetail;
import com.huawei.hicloud.notification.p106db.bean.RecommendNeedData;

/* loaded from: classes6.dex */
public class NotifyNeedData {
    private boolean autoCancel;
    private PendingIntent cancelIntent;
    private PendingIntent contentIntent;
    private String deleteStr;
    private Bundle extraBundle;
    private String groupKey;
    private int iconId;

    /* renamed from: id */
    private int f22627id;
    private boolean isDelete;
    private boolean isSilent;
    private String mainText;
    private MemberShareDetail memberShareDetail;
    private NotifyMessageButtonData messageButtonData;
    private String noticeType;
    private RecommendNeedData recommendNeedData;
    private String resourceInfo;
    private String titleText;
    private int activityType = -1;
    private boolean needGroup = true;

    public int getActivityType() {
        return this.activityType;
    }

    public PendingIntent getCancelIntent() {
        return this.cancelIntent;
    }

    public PendingIntent getContentIntent() {
        return this.contentIntent;
    }

    public String getDeleteStr() {
        return this.deleteStr;
    }

    public Bundle getExtraBundle() {
        return this.extraBundle;
    }

    public String getGroupKey() {
        return this.groupKey;
    }

    public int getIconId() {
        return this.iconId;
    }

    public int getId() {
        return this.f22627id;
    }

    public String getMainText() {
        return this.mainText;
    }

    public MemberShareDetail getMemberShareDetail() {
        return this.memberShareDetail;
    }

    public NotifyMessageButtonData getMessageButtonData() {
        return this.messageButtonData;
    }

    public String getNoticeType() {
        return this.noticeType;
    }

    public RecommendNeedData getRecommendNeedData() {
        return this.recommendNeedData;
    }

    public String getResourceInfo() {
        return this.resourceInfo;
    }

    public String getTitleText() {
        return this.titleText;
    }

    public boolean isAutoCancel() {
        return this.autoCancel;
    }

    public boolean isDelete() {
        return this.isDelete;
    }

    public boolean isNeedGroup() {
        return this.needGroup;
    }

    public boolean isSilent() {
        return this.isSilent;
    }

    public void setActivityType(int i10) {
        this.activityType = i10;
    }

    public void setAutoCancel(boolean z10) {
        this.autoCancel = z10;
    }

    public void setCancelIntent(PendingIntent pendingIntent) {
        this.cancelIntent = pendingIntent;
    }

    public void setContentIntent(PendingIntent pendingIntent) {
        this.contentIntent = pendingIntent;
    }

    public void setDelete(boolean z10) {
        this.isDelete = z10;
    }

    public void setDeleteStr(String str) {
        this.deleteStr = str;
    }

    public void setExtraBundle(Bundle bundle) {
        this.extraBundle = bundle;
    }

    public void setGroupKey(String str) {
        this.groupKey = str;
    }

    public void setIconId(int i10) {
        this.iconId = i10;
    }

    public void setId(int i10) {
        this.f22627id = i10;
    }

    public void setMainText(String str) {
        this.mainText = str;
    }

    public void setMemberShareDetail(MemberShareDetail memberShareDetail) {
        this.memberShareDetail = memberShareDetail;
    }

    public void setMessageButtonData(NotifyMessageButtonData notifyMessageButtonData) {
        this.messageButtonData = notifyMessageButtonData;
    }

    public void setNeedGroup(boolean z10) {
        this.needGroup = z10;
    }

    public void setNoticeType(String str) {
        this.noticeType = str;
    }

    public void setRecommendNeedData(RecommendNeedData recommendNeedData) {
        this.recommendNeedData = recommendNeedData;
    }

    public void setResourceInfo(String str) {
        this.resourceInfo = str;
    }

    public void setSilent(boolean z10) {
        this.isSilent = z10;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }
}
