package com.huawei.hicloud.messagecenter.bean;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.huawei.hicloud.notification.bean.DeskPopupJump;
import com.huawei.hicloud.notification.bean.SecondWindows;
import com.huawei.hicloud.notification.log.NotifyLogger;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import p815ym.AbstractC14026a;

/* loaded from: classes6.dex */
public class DeskPopupMsgObj extends BaseMsgObj implements Serializable {
    private static final long serialVersionUID = -64053874429187031L;
    private String cfgInstanceId;
    private String context;
    private int deskPopupAction;
    private List<DeskPopupJump> desktopGoto;
    private String desktopText;
    private String desktopTitle;
    private String extras;
    private String messageId;
    private List<String> param;
    private List<String> realTimeParam;
    private List<SecondWindows> secondWindows;
    private int supportTrigger;
    private String trigger;
    private String winType;

    public String getCfgInstanceId() {
        return this.cfgInstanceId;
    }

    public String getContext() {
        return this.context;
    }

    public int getDeskPopupAction() {
        return this.deskPopupAction;
    }

    public List<DeskPopupJump> getDesktopGoto() {
        return this.desktopGoto;
    }

    public String getDesktopGotoForJson() {
        List<DeskPopupJump> list = this.desktopGoto;
        return (list == null || list.isEmpty()) ? "" : new Gson().toJson(this.desktopGoto);
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

    public String getMessageId() {
        return this.messageId;
    }

    public List<String> getParam() {
        return this.param;
    }

    public List<String> getRealTimeParam() {
        return this.realTimeParam;
    }

    public List<SecondWindows> getSecondWindows() {
        return this.secondWindows;
    }

    public String getSecondWindowsForJson() {
        return AbstractC14026a.m84159a(this.secondWindows) ? "" : new Gson().toJson(this.secondWindows);
    }

    public int getSupportTrigger() {
        return this.supportTrigger;
    }

    public String getTrigger() {
        return this.trigger;
    }

    public String getWinType() {
        return this.winType;
    }

    public void setCfgInstanceId(String str) {
        this.cfgInstanceId = str;
    }

    public void setContext(String str) {
        this.context = str;
    }

    public void setDeskPopupAction(int i10) {
        this.deskPopupAction = i10;
    }

    public void setDesktopGoto(List<DeskPopupJump> list) {
        this.desktopGoto = list;
    }

    public void setDesktopGotoByJson(String str) {
        if (TextUtils.isEmpty(str)) {
            this.desktopGoto = new ArrayList();
            return;
        }
        try {
            this.desktopGoto = (List) new Gson().fromJson(str, new TypeToken<List<DeskPopupJump>>() { // from class: com.huawei.hicloud.messagecenter.bean.DeskPopupMsgObj.1
            }.getType());
        } catch (Exception e10) {
            NotifyLogger.m29915i("DeskPopupMsgObj", e10.toString());
        }
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

    public void setMessageId(String str) {
        this.messageId = str;
    }

    public void setParam(List<String> list) {
        this.param = list;
    }

    public void setRealTimeParam(List<String> list) {
        this.realTimeParam = list;
    }

    public void setSecondWindows(List<SecondWindows> list) {
        this.secondWindows = list;
    }

    public void setSecondWindowsByJson(String str) {
        if (TextUtils.isEmpty(str)) {
            this.secondWindows = new ArrayList();
            return;
        }
        try {
            this.secondWindows = (List) new Gson().fromJson(str, new TypeToken<List<SecondWindows>>() { // from class: com.huawei.hicloud.messagecenter.bean.DeskPopupMsgObj.2
            }.getType());
        } catch (Exception e10) {
            NotifyLogger.m29915i("SecondWindowsByJson", e10.toString());
        }
    }

    public void setSupportTrigger(int i10) {
        this.supportTrigger = i10;
    }

    public void setTrigger(String str) {
        this.trigger = str;
    }

    public void setWinType(String str) {
        this.winType = str;
    }
}
