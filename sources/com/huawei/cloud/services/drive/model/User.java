package com.huawei.cloud.services.drive.model;

import com.huawei.cloud.base.util.InterfaceC4648p;
import ni.C11707b;

/* loaded from: classes5.dex */
public class User extends C11707b {

    @InterfaceC4648p
    private String category;

    @InterfaceC4648p
    private String displayName;

    /* renamed from: me */
    @InterfaceC4648p
    private Boolean f21494me;

    @InterfaceC4648p
    private String permissionId;

    @InterfaceC4648p
    private String profilePhotoLink;

    @InterfaceC4648p
    private String userAccount;

    public String getCategory() {
        return this.category;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public Boolean getMe() {
        return this.f21494me;
    }

    public String getPermissionId() {
        return this.permissionId;
    }

    public String getProfilePhotoLink() {
        return this.profilePhotoLink;
    }

    public String getUserAccount() {
        return this.userAccount;
    }

    public User setCategory(String str) {
        this.category = str;
        return this;
    }

    public User setDisplayName(String str) {
        this.displayName = str;
        return this;
    }

    public User setMe(Boolean bool) {
        this.f21494me = bool;
        return this;
    }

    public User setPermissionId(String str) {
        this.permissionId = str;
        return this;
    }

    public User setProfilePhotoLink(String str) {
        this.profilePhotoLink = str;
        return this;
    }

    public User setUserAccount(String str) {
        this.userAccount = str;
        return this;
    }

    @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n
    public User set(String str, Object obj) {
        return (User) super.set(str, obj);
    }

    @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n, java.util.AbstractMap
    public User clone() {
        return (User) super.clone();
    }
}
