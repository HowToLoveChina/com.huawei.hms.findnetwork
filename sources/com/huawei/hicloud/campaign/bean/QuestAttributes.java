package com.huawei.hicloud.campaign.bean;

import com.huawei.hicloud.campaign.bean.quest.AdsActivationAttr;
import com.huawei.hicloud.campaign.bean.quest.BusinessPayAttr;
import com.huawei.hicloud.campaign.bean.quest.CalendarNotifyAttr;
import com.huawei.hicloud.campaign.bean.quest.DownloadAppAttr;
import com.huawei.hicloud.campaign.bean.quest.FutureSwitchAttr;
import com.huawei.hicloud.campaign.bean.quest.KaActivationAttr;
import com.huawei.hicloud.campaign.bean.quest.UploadFileAttr;

/* loaded from: classes6.dex */
public class QuestAttributes {
    private AdsActivationAttr adsActivation;
    private BusinessPayAttr businessPay;
    private CalendarNotifyAttr calendarNotify;
    private DownloadAppAttr downloadApp;
    private FutureSwitchAttr futureSwitch;
    private KaActivationAttr kaActivation;
    private UploadFileAttr uploadFile;

    public AdsActivationAttr getAdsActivation() {
        return this.adsActivation;
    }

    public BusinessPayAttr getBusinessPay() {
        return this.businessPay;
    }

    public CalendarNotifyAttr getCalendarNotify() {
        return this.calendarNotify;
    }

    public DownloadAppAttr getDownloadApp() {
        return this.downloadApp;
    }

    public FutureSwitchAttr getFutureSwitch() {
        return this.futureSwitch;
    }

    public KaActivationAttr getKaActivation() {
        return this.kaActivation;
    }

    public UploadFileAttr getUploadFile() {
        return this.uploadFile;
    }

    public void setAdsActivation(AdsActivationAttr adsActivationAttr) {
        this.adsActivation = adsActivationAttr;
    }

    public void setBusinessPay(BusinessPayAttr businessPayAttr) {
        this.businessPay = businessPayAttr;
    }

    public void setCalendarNotify(CalendarNotifyAttr calendarNotifyAttr) {
        this.calendarNotify = calendarNotifyAttr;
    }

    public void setDownloadApp(DownloadAppAttr downloadAppAttr) {
        this.downloadApp = downloadAppAttr;
    }

    public void setFutureSwitch(FutureSwitchAttr futureSwitchAttr) {
        this.futureSwitch = futureSwitchAttr;
    }

    public void setKaActivation(KaActivationAttr kaActivationAttr) {
        this.kaActivation = kaActivationAttr;
    }

    public void setUploadFile(UploadFileAttr uploadFileAttr) {
        this.uploadFile = uploadFileAttr;
    }
}
