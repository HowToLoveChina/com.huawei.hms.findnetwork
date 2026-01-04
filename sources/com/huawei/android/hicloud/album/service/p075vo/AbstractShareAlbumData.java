package com.huawei.android.hicloud.album.service.p075vo;

import android.os.Parcelable;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class AbstractShareAlbumData implements Parcelable {
    public static final int I_SHARE_ALL = 0;
    public static final int I_SHARE_ME = 1;
    public static final int I_SHARE_REC = 2;
    protected int countNum;
    protected long createTime;
    protected int deleteFlag;
    protected long flversion;
    protected boolean isShow;
    protected int iversion;
    protected List<String> localThumbPath;
    protected String ownerAcc;
    protected String ownerId;
    protected String privilege;
    protected String resource;
    protected String shareId;
    protected String shareName;
    protected String source;
    protected long totalSize;
    protected int type;

    public int getCountNum() {
        return this.countNum;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public int getDeleteFlag() {
        return this.deleteFlag;
    }

    public long getFlversion() {
        return this.flversion;
    }

    public int getIversion() {
        return this.iversion;
    }

    public List<String> getLocalThumbPath() {
        return this.localThumbPath;
    }

    public String getOwnerAcc() {
        return this.ownerAcc;
    }

    public String getOwnerId() {
        return this.ownerId;
    }

    public String getPrivilege() {
        return this.privilege;
    }

    public String getResource() {
        return this.resource;
    }

    public String getShareId() {
        return this.shareId;
    }

    public String getShareName() {
        return this.shareName;
    }

    public String getSource() {
        return this.source;
    }

    public long getTotalSize() {
        return this.totalSize;
    }

    public int getType() {
        return this.type;
    }

    public boolean isShow() {
        return this.isShow;
    }

    public void setCountNum(int i10) {
        this.countNum = i10;
    }

    public void setCreateTime(long j10) {
        this.createTime = j10;
    }

    public void setDeleteFlag(int i10) {
        this.deleteFlag = i10;
    }

    public void setFlversion(long j10) {
        this.flversion = j10;
    }

    public void setIversion(int i10) {
        this.iversion = i10;
    }

    public void setLocalThumbPath(List<String> list) {
        this.localThumbPath = list;
    }

    public void setOwnerAcc(String str) {
        this.ownerAcc = str;
    }

    public void setOwnerId(String str) {
        this.ownerId = str;
    }

    public void setPrivilege(String str) {
        this.privilege = str;
    }

    public void setResource(String str) {
        this.resource = str;
    }

    public void setShareId(String str) {
        this.shareId = str;
    }

    public void setShareName(String str) {
        this.shareName = str;
    }

    public void setShow(boolean z10) {
        this.isShow = z10;
    }

    public void setSource(String str) {
        this.source = str;
    }

    public void setTotalSize(long j10) {
        this.totalSize = j10;
    }

    public void setType(int i10) {
        this.type = i10;
    }
}
