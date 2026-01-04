package com.huawei.hicloud.notification.p106db.bean;

import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public class H5Resource {
    private String activityId;
    private String activityType;
    private String enablePopup;
    private List<FrontApp> frontAppList;
    private int frontAppNumber;
    private NotifyTypeAndUriGoto gotoUrl;
    private CommonPicture[] homePagePicture;
    private CommonPicture[] homePagePictureSecond;
    private Map<String, String> noticeText;
    private String resourceId;
    private ShowTaskCon showTaskCon;
    private H5ConfigPicture taskCenter;
    private CommonPicture updatePictureFirst;
    private CommonPicture updatePictureSecond;

    public String getActivityId() {
        return this.activityId;
    }

    public String getActivityType() {
        return this.activityType;
    }

    public String getEnablePopup() {
        return this.enablePopup;
    }

    public List<FrontApp> getFrontAppList() {
        return this.frontAppList;
    }

    public int getFrontAppNumber() {
        return this.frontAppNumber;
    }

    public NotifyTypeAndUriGoto getGotoUrl() {
        return this.gotoUrl;
    }

    public CommonPicture[] getHomePagePicture() {
        return this.homePagePicture;
    }

    public CommonPicture[] getHomePagePictureSecond() {
        return this.homePagePictureSecond;
    }

    public Map<String, String> getNoticeText() {
        return this.noticeText;
    }

    public String getResourceId() {
        return this.resourceId;
    }

    public ShowTaskCon getShowTaskCon() {
        return this.showTaskCon;
    }

    public H5ConfigPicture getTaskCenter() {
        return this.taskCenter;
    }

    public CommonPicture getUpdatePictureFirst() {
        return this.updatePictureFirst;
    }

    public CommonPicture getUpdatePictureSecond() {
        return this.updatePictureSecond;
    }

    public void setActivityId(String str) {
        this.activityId = str;
    }

    public void setActivityType(String str) {
        this.activityType = str;
    }

    public void setEnablePopup(String str) {
        this.enablePopup = str;
    }

    public void setFrontAppList(List<FrontApp> list) {
        this.frontAppList = list;
    }

    public void setFrontAppNumber(int i10) {
        this.frontAppNumber = i10;
    }

    public void setGotoUrl(NotifyTypeAndUriGoto notifyTypeAndUriGoto) {
        this.gotoUrl = notifyTypeAndUriGoto;
    }

    public void setHomePagePicture(CommonPicture[] commonPictureArr) {
        this.homePagePicture = commonPictureArr;
    }

    public void setHomePagePictureSecond(CommonPicture[] commonPictureArr) {
        this.homePagePictureSecond = commonPictureArr;
    }

    public void setNoticeText(Map<String, String> map) {
        this.noticeText = map;
    }

    public void setResourceId(String str) {
        this.resourceId = str;
    }

    public void setShowTaskCon(ShowTaskCon showTaskCon) {
        this.showTaskCon = showTaskCon;
    }

    public void setTaskCenter(H5ConfigPicture h5ConfigPicture) {
        this.taskCenter = h5ConfigPicture;
    }

    public void setUpdatePictureFirst(CommonPicture commonPicture) {
        this.updatePictureFirst = commonPicture;
    }

    public void setUpdatePictureSecond(CommonPicture commonPicture) {
        this.updatePictureSecond = commonPicture;
    }
}
