package com.huawei.hicloud.base.drive.user.model;

import com.huawei.cloud.base.util.InterfaceC4648p;
import ni.C11707b;

/* loaded from: classes6.dex */
public class RisksRecord extends C11707b {

    @InterfaceC4648p
    private String createdTime;

    @InterfaceC4648p
    private String doneTime;

    @InterfaceC4648p
    private String editedTime;

    @InterfaceC4648p
    private String fileName;

    /* renamed from: id */
    @InterfaceC4648p
    private String f22148id;

    @InterfaceC4648p
    private String reason;

    @InterfaceC4648p
    private int state;

    @InterfaceC4648p
    private String type;

    @InterfaceC4648p
    private String userId;

    public String getCreatedTime() {
        return this.createdTime;
    }

    public String getDoneTime() {
        return this.doneTime;
    }

    public String getEditedTime() {
        return this.editedTime;
    }

    public String getFileName() {
        return this.fileName;
    }

    public String getId() {
        return this.f22148id;
    }

    public String getReason() {
        return this.reason;
    }

    public int getState() {
        return this.state;
    }

    public String getType() {
        return this.type;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setCreatedTime(String str) {
        this.createdTime = str;
    }

    public void setDoneTime(String str) {
        this.doneTime = str;
    }

    public void setEditedTime(String str) {
        this.editedTime = str;
    }

    public void setFileName(String str) {
        this.fileName = str;
    }

    public void setId(String str) {
        this.f22148id = str;
    }

    public void setReason(String str) {
        this.reason = str;
    }

    public void setState(int i10) {
        this.state = i10;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setUserId(String str) {
        this.userId = str;
    }
}
