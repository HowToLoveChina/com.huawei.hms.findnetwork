package com.huawei.android.hicloud.drive.cloudphoto.model;

import com.huawei.cloud.base.util.C4644l;
import com.huawei.cloud.base.util.InterfaceC4648p;
import com.huawei.hicloud.base.drive.user.model.User;
import ni.C11707b;

/* loaded from: classes3.dex */
public class Batch extends C11707b {

    @InterfaceC4648p
    private String albumId;

    @InterfaceC4648p
    private String albumOwnerId;

    @InterfaceC4648p
    private long batchV1Id;

    @InterfaceC4648p
    private C4644l batchV1Time;

    @InterfaceC4648p
    private String category;

    @InterfaceC4648p
    private C4644l createdTime;

    @InterfaceC4648p
    private User creator;

    /* renamed from: id */
    @InterfaceC4648p
    private String f12219id;

    @InterfaceC4648p
    private Integer status;

    public String getAlbumId() {
        return this.albumId;
    }

    public String getAlbumOwnerId() {
        return this.albumOwnerId;
    }

    public long getBatchV1Id() {
        return this.batchV1Id;
    }

    public C4644l getBatchV1Time() {
        return this.batchV1Time;
    }

    public String getCategory() {
        return this.category;
    }

    public C4644l getCreatedTime() {
        return this.createdTime;
    }

    public User getCreator() {
        return this.creator;
    }

    public String getId() {
        return this.f12219id;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setAlbumId(String str) {
        this.albumId = str;
    }

    public void setAlbumOwnerId(String str) {
        this.albumOwnerId = str;
    }

    public void setBatchV1Id(long j10) {
        this.batchV1Id = j10;
    }

    public void setBatchV1Time(C4644l c4644l) {
        this.batchV1Time = c4644l;
    }

    public void setCategory(String str) {
        this.category = str;
    }

    public void setCreatedTime(C4644l c4644l) {
        this.createdTime = c4644l;
    }

    public void setCreator(User user) {
        this.creator = user;
    }

    public void setId(String str) {
        this.f12219id = str;
    }

    public void setStatus(Integer num) {
        this.status = num;
    }
}
