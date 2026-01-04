package com.huawei.hicloud.notification.bean;

import java.io.Serializable;
import java.util.List;

/* loaded from: classes6.dex */
public class SecondWindows implements Serializable {
    private static final long serialVersionUID = -64053874429187032L;
    private List<DeskPopupJump> buttons;
    private String mainText;
    private int source = -1;
    private String title;
    private String winType;

    public List<DeskPopupJump> getButtons() {
        return this.buttons;
    }

    public String getMainText() {
        return this.mainText;
    }

    public int getSource() {
        return this.source;
    }

    public String getTitle() {
        return this.title;
    }

    public String getWinType() {
        return this.winType;
    }

    public void setButtons(List<DeskPopupJump> list) {
        this.buttons = list;
    }

    public void setMainText(String str) {
        this.mainText = str;
    }

    public void setSource(int i10) {
        this.source = i10;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setWinType(String str) {
        this.winType = str;
    }
}
