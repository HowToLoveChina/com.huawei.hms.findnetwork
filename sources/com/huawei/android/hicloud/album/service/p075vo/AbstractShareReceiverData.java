package com.huawei.android.hicloud.album.service.p075vo;

import android.os.Parcelable;

/* loaded from: classes2.dex */
public abstract class AbstractShareReceiverData implements Parcelable {
    protected String headPictureLocalPath;
    protected String headPictureURL;
    protected long lastUpdatePicTime;
    protected int privilege;
    protected String receiverAcc;
    protected String receiverId;
    protected String receiverName;
    protected String shareId;
    protected int status;

    public String getHeadPictureLocalPath() {
        return this.headPictureLocalPath;
    }

    public String getHeadPictureURL() {
        return this.headPictureURL;
    }

    public long getLastUpdatePicTime() {
        return this.lastUpdatePicTime;
    }

    public int getPrivilege() {
        return this.privilege;
    }

    public String getReceiverAcc() {
        return this.receiverAcc;
    }

    public String getReceiverId() {
        return this.receiverId;
    }

    public String getReceiverName() {
        return this.receiverName;
    }

    public String getShareId() {
        return this.shareId;
    }

    public int getStatus() {
        return this.status;
    }

    public void setHeadPictureLocalPath(String str) {
        this.headPictureLocalPath = str;
    }

    public void setHeadPictureURL(String str) {
        this.headPictureURL = str;
    }

    public void setLastUpdatePicTime(long j10) {
        this.lastUpdatePicTime = j10;
    }

    public void setPrivilege(int i10) {
        this.privilege = i10;
    }

    public void setReceiverAcc(String str) {
        this.receiverAcc = str;
    }

    public void setReceiverId(String str) {
        this.receiverId = str;
    }

    public void setReceiverName(String str) {
        this.receiverName = str;
    }

    public void setShareId(String str) {
        this.shareId = str;
    }

    public void setStatus(int i10) {
        this.status = i10;
    }
}
