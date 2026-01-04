package com.huawei.hicloud.notification.p106db.bean.backupspaceinsufficientconfig;

import com.google.gson.annotations.SerializedName;
import com.huawei.android.backup.service.logic.C2126b;
import com.huawei.hicloud.notification.p106db.bean.PopUpWithActivityGoto;
import java.util.List;

/* loaded from: classes6.dex */
public class ModelGoto {

    @SerializedName("button_link")
    private List<PopUpWithActivityGoto> buttonLink = null;

    @SerializedName("noti_deeplink")
    private String notiDeeplink;

    @SerializedName("noti_type")
    private String notiType;

    @SerializedName("close_backup_remind_type")
    private String remindType;

    @SerializedName(C2126b.MODULE_INFO_URI)
    private String uri;

    public List<PopUpWithActivityGoto> getButtonLink() {
        return this.buttonLink;
    }

    public String getNotiDeeplink() {
        return this.notiDeeplink;
    }

    public String getNotiType() {
        return this.notiType;
    }

    public String getRemindType() {
        return this.remindType;
    }

    public String getUri() {
        return this.uri;
    }

    public void setButtonLink(List<PopUpWithActivityGoto> list) {
        this.buttonLink = list;
    }

    public void setNotiDeeplink(String str) {
        this.notiDeeplink = str;
    }

    public void setNotiType(String str) {
        this.notiType = str;
    }

    public void setRemindType(String str) {
        this.remindType = str;
    }

    public void setUri(String str) {
        this.uri = str;
    }
}
