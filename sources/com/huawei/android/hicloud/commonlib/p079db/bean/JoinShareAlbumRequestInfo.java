package com.huawei.android.hicloud.commonlib.p079db.bean;

import java.util.List;

/* loaded from: classes3.dex */
public class JoinShareAlbumRequestInfo {
    private String jionDenyAlbumName;
    private long jionDenyTime;
    private List<String> joinRequesetUserIdList;
    private int joinRequestNum;
    private long joinRequestTime;
    private String latestJoinAlbumName;
    private Integer messageType;

    public String getJionDenyAlbumName() {
        return this.jionDenyAlbumName;
    }

    public long getJionDenyTime() {
        return this.jionDenyTime;
    }

    public List<String> getJoinRequesetUserIdList() {
        return this.joinRequesetUserIdList;
    }

    public int getJoinRequestNum() {
        return this.joinRequestNum;
    }

    public long getJoinRequestTime() {
        return this.joinRequestTime;
    }

    public String getLatestJoinAlbumName() {
        return this.latestJoinAlbumName;
    }

    public Integer getMessageType() {
        return this.messageType;
    }

    public void setJionDenyAlbumName(String str) {
        this.jionDenyAlbumName = str;
    }

    public void setJionDenyTime(long j10) {
        this.jionDenyTime = j10;
    }

    public void setJoinRequesetUserIdList(List<String> list) {
        this.joinRequesetUserIdList = list;
    }

    public void setJoinRequestNum(int i10) {
        this.joinRequestNum = i10;
    }

    public void setJoinRequestTime(long j10) {
        this.joinRequestTime = j10;
    }

    public void setLatestJoinAlbumName(String str) {
        this.latestJoinAlbumName = str;
    }

    public void setMessageType(Integer num) {
        this.messageType = num;
    }
}
