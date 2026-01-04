package com.huawei.hicloud.notification.p106db.bean;

import com.google.gson.annotations.SerializedName;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.util.NotifyUtil;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class NoticeDetail {
    private static final String TAG = "NoticeDetail";

    @SerializedName(NotifyConstants.POP_GOTO_BUTTON_FIRST)
    private String buttonFirst;

    @SerializedName(NotifyConstants.POP_GOTO_BUTTON_SECOND)
    private String buttonSecond;

    @SerializedName("detail_link")
    private LinkedHashMap<String, String> detailLink;
    private String language;

    @SerializedName(NotifyUtil.MAIN_TEXT_TYPE_DEFAULT)
    private String mainText;

    @SerializedName("main_text_second")
    private String mainTextSecond;

    @SerializedName("mark")
    private String mark;

    @SerializedName("sub_title")
    private String sbuTitle;

    @SerializedName("tip")
    private String tip;
    private String title;

    public String getButtonFirst() {
        return this.buttonFirst;
    }

    public String getButtonSecond() {
        return this.buttonSecond;
    }

    public LinkedHashMap<String, String> getDetailLink() {
        return this.detailLink;
    }

    public String getDetailLinkStr() throws JSONException {
        if (this.detailLink == null) {
            return "";
        }
        try {
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry<String, String> entry : this.detailLink.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            return jSONObject.toString();
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "getDetailLinkStr exception:" + e10.toString());
            return "";
        }
    }

    public String getLanguage() {
        return this.language;
    }

    public String getMainText() {
        return this.mainText;
    }

    public String getMainTextSecond() {
        return this.mainTextSecond;
    }

    public String getMark() {
        return this.mark;
    }

    public String getSbuTitle() {
        return this.sbuTitle;
    }

    public String getTip() {
        return this.tip;
    }

    public String getTitle() {
        return this.title;
    }

    public void setButtonFirst(String str) {
        this.buttonFirst = str;
    }

    public void setButtonSecond(String str) {
        this.buttonSecond = str;
    }

    public void setDetailLink(LinkedHashMap<String, String> linkedHashMap) {
        this.detailLink = linkedHashMap;
    }

    public void setLanguage(String str) {
        this.language = str;
    }

    public void setMainText(String str) {
        this.mainText = str;
    }

    public void setMainTextSecond(String str) {
        this.mainTextSecond = str;
    }

    public void setMark(String str) {
        this.mark = str;
    }

    public void setSbuTitle(String str) {
        this.sbuTitle = str;
    }

    public void setTip(String str) {
        this.tip = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
