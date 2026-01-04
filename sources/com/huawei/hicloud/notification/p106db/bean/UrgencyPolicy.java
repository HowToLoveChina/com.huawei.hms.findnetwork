package com.huawei.hicloud.notification.p106db.bean;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.util.List;

/* loaded from: classes6.dex */
public class UrgencyPolicy {
    private static final String TAG = "UrgencyPolicy";

    @SerializedName(Constants.CONTENT_SERVER_REALM)
    private List<String> action;
    private String actionStr;

    @SerializedName("detail")
    private UrgencyDetail detail;
    private String detailStr;

    /* renamed from: id */
    @SerializedName("id")
    private String f22663id;

    @SerializedName("notice")
    private UrgencyNotification notice;
    private String noticeStr;

    @SerializedName("noticeType")
    private List<String> noticeType;
    private String noticeTypeStr;
    private String onTopStr;

    @SerializedName("ontop")
    private UrgencyTop ontop;

    @SerializedName("scenario")
    private UrgencyScenario scenario;
    private String scenarioStr;

    public List<String> getAction() {
        return this.action;
    }

    public String getActionJsonStr() {
        try {
            return this.action != null ? new Gson().toJson(this.action) : "";
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "getActionJsonStr exception:" + e10.toString());
            return "";
        }
    }

    public String getActionStr() {
        return this.actionStr;
    }

    public UrgencyDetail getDetail() {
        return this.detail;
    }

    public String getDetailJsonStr() {
        try {
            return this.detail != null ? new Gson().toJson(this.detail) : "";
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "getDetailJsonStr exception:" + e10.toString());
            return "";
        }
    }

    public String getDetailStr() {
        return this.detailStr;
    }

    public String getId() {
        return this.f22663id;
    }

    public UrgencyNotification getNotice() {
        return this.notice;
    }

    public String getNoticeJsonStr() {
        try {
            return this.notice != null ? new Gson().toJson(this.notice) : "";
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "getNoticeJsonStr exception:" + e10.toString());
            return "";
        }
    }

    public String getNoticeStr() {
        return this.noticeStr;
    }

    public List<String> getNoticeType() {
        return this.noticeType;
    }

    public String getNoticeTypeJsonStr() {
        try {
            return this.noticeType != null ? new Gson().toJson(this.noticeType) : "";
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "getNoticeTypeJsonStr exception:" + e10.toString());
            return "";
        }
    }

    public String getNoticeTypeStr() {
        return this.noticeTypeStr;
    }

    public String getOnTopStr() {
        return this.onTopStr;
    }

    public UrgencyTop getOntop() {
        return this.ontop;
    }

    public UrgencyScenario getScenario() {
        return this.scenario;
    }

    public String getScenarioJsonStr() {
        try {
            return this.scenario != null ? new Gson().toJson(this.scenario) : "";
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "getScenarioJsonStr exception:" + e10.toString());
            return "";
        }
    }

    public String getScenarioStr() {
        return this.scenarioStr;
    }

    public String getTopJsonStr() {
        try {
            return this.ontop != null ? new Gson().toJson(this.ontop) : "";
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "getTopJsonStr exception:" + e10.toString());
            return "";
        }
    }

    public void setAction(List<String> list) {
        this.action = list;
    }

    public void setActionStr(String str) {
        this.actionStr = str;
    }

    public void setDetail(UrgencyDetail urgencyDetail) {
        this.detail = urgencyDetail;
    }

    public void setDetailStr(String str) {
        this.detailStr = str;
    }

    public void setId(String str) {
        this.f22663id = str;
    }

    public void setNotice(UrgencyNotification urgencyNotification) {
        this.notice = urgencyNotification;
    }

    public void setNoticeStr(String str) {
        this.noticeStr = str;
    }

    public void setNoticeType(List<String> list) {
        this.noticeType = list;
    }

    public void setNoticeTypeStr(String str) {
        this.noticeTypeStr = str;
    }

    public void setOnTopStr(String str) {
        this.onTopStr = str;
    }

    public void setOntop(UrgencyTop urgencyTop) {
        this.ontop = urgencyTop;
    }

    public void setScenario(UrgencyScenario urgencyScenario) {
        this.scenario = urgencyScenario;
    }

    public void setScenarioStr(String str) {
        this.scenarioStr = str;
    }
}
