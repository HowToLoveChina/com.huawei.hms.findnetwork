package com.huawei.hicloud.notification.bean;

import com.google.gson.annotations.SerializedName;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.List;

/* loaded from: classes6.dex */
public class NotifyBar {

    @SerializedName("btnOneGoto")
    private MsgJump btnOneGoto;

    @SerializedName("btnOneText")
    private String btnOneText;

    @SerializedName("btnTwoGoto")
    private MsgJump btnTwoGoto;

    @SerializedName("btnTwoText")
    private String btnTwoText;

    @SerializedName("notifyGoto")
    private MsgJump msgJump;

    @SerializedName("notifyText")
    private String notifyText;

    @SerializedName(RemoteMessageConst.Notification.NOTIFY_TITLE)
    private String notifyTitle;

    @SerializedName("params")
    private List<String> params;

    @SerializedName("realtimeParams")
    private List<String> realtimeParams;

    public MsgJump getBtnOneGoto() {
        return this.btnOneGoto;
    }

    public String getBtnOneText() {
        return this.btnOneText;
    }

    public MsgJump getBtnTwoGoto() {
        return this.btnTwoGoto;
    }

    public String getBtnTwoText() {
        return this.btnTwoText;
    }

    public MsgJump getMsgJump() {
        return this.msgJump;
    }

    public String getNotifyText() {
        return this.notifyText;
    }

    public String getNotifyTitle() {
        return this.notifyTitle;
    }

    public List<String> getParams() {
        return this.params;
    }

    public List<String> getRealtimeParams() {
        return this.realtimeParams;
    }

    public void setBtnOneGoto(MsgJump msgJump) {
        this.btnOneGoto = msgJump;
    }

    public void setBtnOneText(String str) {
        this.btnOneText = str;
    }

    public void setBtnTwoGoto(MsgJump msgJump) {
        this.btnTwoGoto = msgJump;
    }

    public void setBtnTwoText(String str) {
        this.btnTwoText = str;
    }

    public void setMsgJump(MsgJump msgJump) {
        this.msgJump = msgJump;
    }

    public void setNotifyText(String str) {
        this.notifyText = str;
    }

    public void setNotifyTitle(String str) {
        this.notifyTitle = str;
    }

    public void setParams(List<String> list) {
        this.params = list;
    }

    public void setRealtimeParams(List<String> list) {
        this.realtimeParams = list;
    }
}
