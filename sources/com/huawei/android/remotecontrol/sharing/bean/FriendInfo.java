package com.huawei.android.remotecontrol.sharing.bean;

import com.google.gson.Gson;

/* loaded from: classes4.dex */
public class FriendInfo {
    public static final int TYPE_FAMILY = 1;
    public static final int TYPE_FRIEND = 2;
    private String friendAccountName;
    private String friendAliasName;
    private String friendUserId;
    private String iconUrl;
    private int relationType;

    public String getFriendAccountName() {
        return this.friendAccountName;
    }

    public String getFriendAliasName() {
        return this.friendAliasName;
    }

    public String getFriendUserId() {
        return this.friendUserId;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public int getRelationType() {
        return this.relationType;
    }

    public void setFriendAccountName(String str) {
        this.friendAccountName = str;
    }

    public void setFriendAliasName(String str) {
        this.friendAliasName = str;
    }

    public void setFriendUserId(String str) {
        this.friendUserId = str;
    }

    public void setIconUrl(String str) {
        this.iconUrl = str;
    }

    public void setRelationType(int i10) {
        this.relationType = i10;
    }

    public String toString() {
        return new Gson().toJson(this);
    }
}
