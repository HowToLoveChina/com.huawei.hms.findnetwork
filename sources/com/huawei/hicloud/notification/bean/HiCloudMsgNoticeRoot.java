package com.huawei.hicloud.notification.bean;

import com.google.gson.annotations.SerializedName;
import com.huawei.android.hicloud.clouddisk.logic.calllogs.CallLogCons;
import com.huawei.hicloud.notification.p106db.bean.CommonLanguage;
import com.huawei.hicloud.notification.p106db.bean.CommonPicture;
import com.huawei.hms.network.inner.api.NetworkService;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import java.util.Map;

/* loaded from: classes6.dex */
public class HiCloudMsgNoticeRoot {

    @SerializedName(FaqConstants.FAQ_EMUI_LANGUAGE)
    private CommonLanguage commonLanguage;

    @SerializedName(NetworkService.Constants.CONFIG_SERVICE)
    private HiCloudMsgNoticeBean[] configBean;

    @SerializedName(CallLogCons.DATE)
    private String date;

    /* renamed from: id */
    @SerializedName("id")
    private String f22626id;

    @SerializedName("resourceMap")
    private Map<String, CommonPicture> resourceMap;

    @SerializedName("version")
    private String version;

    public CommonLanguage getCommonLanguage() {
        return this.commonLanguage;
    }

    public HiCloudMsgNoticeBean[] getConfigBean() {
        return this.configBean;
    }

    public String getDate() {
        return this.date;
    }

    public String getId() {
        return this.f22626id;
    }

    public Map<String, CommonPicture> getResourceMap() {
        return this.resourceMap;
    }

    public String getVersion() {
        return this.version;
    }

    public void setCommonLanguage(CommonLanguage commonLanguage) {
        this.commonLanguage = commonLanguage;
    }

    public void setConfigBean(HiCloudMsgNoticeBean[] hiCloudMsgNoticeBeanArr) {
        this.configBean = hiCloudMsgNoticeBeanArr;
    }

    public void setDate(String str) {
        this.date = str;
    }

    public void setId(String str) {
        this.f22626id = str;
    }

    public void setResourceMap(Map<String, CommonPicture> map) {
        this.resourceMap = map;
    }

    public void setVersion(String str) {
        this.version = str;
    }
}
