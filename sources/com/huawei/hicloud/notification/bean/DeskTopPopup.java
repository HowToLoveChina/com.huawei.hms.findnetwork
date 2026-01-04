package com.huawei.hicloud.notification.bean;

import com.google.gson.annotations.SerializedName;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import java.util.List;

/* loaded from: classes6.dex */
public class DeskTopPopup {

    @SerializedName("desktopGoto")
    private List<DeskPopupJump> desktopGotos;

    @SerializedName("desktopText")
    private String desktopText;

    @SerializedName("desktopTitle")
    private String desktopTitle;

    @SerializedName(JsbMapKeyNames.H5_EXTRAS)
    private String extras;

    @SerializedName("secondWindows")
    private List<SecondWindows> secondWindows;

    public List<DeskPopupJump> getDesktopGotos() {
        return this.desktopGotos;
    }

    public String getDesktopText() {
        return this.desktopText;
    }

    public String getDesktopTitle() {
        return this.desktopTitle;
    }

    public String getExtras() {
        return this.extras;
    }

    public List<SecondWindows> getSecondWindows() {
        return this.secondWindows;
    }

    public void setDesktopGotos(List<DeskPopupJump> list) {
        this.desktopGotos = list;
    }

    public void setDesktopText(String str) {
        this.desktopText = str;
    }

    public void setDesktopTitle(String str) {
        this.desktopTitle = str;
    }

    public void setExtras(String str) {
        this.extras = str;
    }

    public void setSecondWindows(List<SecondWindows> list) {
        this.secondWindows = list;
    }
}
