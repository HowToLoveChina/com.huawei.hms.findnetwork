package com.huawei.hicloud.notification.p106db.bean.backupspaceinsufficientconfig;

import com.google.gson.annotations.SerializedName;
import com.huawei.hicloud.notification.p106db.bean.BaseNotifyBean;
import com.huawei.hicloud.notification.p106db.bean.CommonLanguage;
import com.huawei.hicloud.notification.p106db.bean.PopUpWithActivityGoto;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import java.util.List;

/* loaded from: classes6.dex */
public class BackupSpaceInsuffNoticeV5Configuration extends BaseNotifyBean {

    @SerializedName("activeWindow")
    private List<PopUpWithActivityGoto> activeWindow;

    @SerializedName("dataItems")
    private List<DataItems> dataItems;

    @SerializedName("enableDataItem")
    private int enableDataItem;

    @SerializedName("enableFrontApp")
    private int enableFrontApp;

    @SerializedName("enableRecomPackages")
    private int enableRecomPackages;

    @SerializedName("frontAppStyle")
    private String frontAppStyle;

    @SerializedName(FaqConstants.FAQ_EMUI_LANGUAGE)
    private CommonLanguage language;

    @SerializedName("notice_content")
    private NoticeContent noticeContent;

    @SerializedName("goto")
    private ModelGoto notifyGoto;

    @SerializedName("centerWindow")
    private TaskCenterWindow taskCenterWindow;

    @SerializedName("triggerDefine")
    private TriggerDefine triggerDefine;

    public List<PopUpWithActivityGoto> getActiveWindow() {
        return this.activeWindow;
    }

    public List<DataItems> getDataItems() {
        return this.dataItems;
    }

    public int getEnableDataItem() {
        return this.enableDataItem;
    }

    public int getEnableFrontApp() {
        return this.enableFrontApp;
    }

    public int getEnableRecomPackages() {
        return this.enableRecomPackages;
    }

    public String getFrontAppStyle() {
        return this.frontAppStyle;
    }

    public CommonLanguage getLanguage() {
        return this.language;
    }

    public NoticeContent getNoticeContent() {
        return this.noticeContent;
    }

    public ModelGoto getNotifyGoto() {
        return this.notifyGoto;
    }

    public TaskCenterWindow getTaskCenterWindow() {
        return this.taskCenterWindow;
    }

    public TriggerDefine getTriggerDefine() {
        return this.triggerDefine;
    }

    public void setActiveWindow(List<PopUpWithActivityGoto> list) {
        this.activeWindow = list;
    }

    public void setDataItems(List<DataItems> list) {
        this.dataItems = list;
    }

    public void setEnableDataItem(int i10) {
        this.enableDataItem = i10;
    }

    public void setEnableFrontApp(int i10) {
        this.enableFrontApp = i10;
    }

    public void setEnableRecomPackages(int i10) {
        this.enableRecomPackages = i10;
    }

    public void setFrontAppStyle(String str) {
        this.frontAppStyle = str;
    }

    public void setLanguage(CommonLanguage commonLanguage) {
        this.language = commonLanguage;
    }

    public void setNoticeContent(NoticeContent noticeContent) {
        this.noticeContent = noticeContent;
    }

    public void setNotifyGoto(ModelGoto modelGoto) {
        this.notifyGoto = modelGoto;
    }

    public void setTaskCenterWindow(TaskCenterWindow taskCenterWindow) {
        this.taskCenterWindow = taskCenterWindow;
    }

    public void setTriggerDefine(TriggerDefine triggerDefine) {
        this.triggerDefine = triggerDefine;
    }
}
