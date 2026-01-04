package com.huawei.hicloud.base.drive.user.model;

import android.text.TextUtils;
import com.huawei.cloud.base.util.InterfaceC4648p;
import ni.C11707b;

/* loaded from: classes6.dex */
public class User extends C11707b {
    private static final char ALREADY_BOUND = '1';
    private static final int EMAIL_FLAG_INDEX = 1;
    private static final int VALID_FLAG_LENGTH = 2;

    @InterfaceC4648p
    private String accountFlag;

    @InterfaceC4648p
    private String category;

    @InterfaceC4648p
    private String displayName;

    /* renamed from: me */
    @InterfaceC4648p
    private Boolean f22149me;

    @InterfaceC4648p
    private String permissionId;

    @InterfaceC4648p
    private String profilePhotoLink;

    @InterfaceC4648p
    private String userId;

    public boolean alreadyBoundEmail() {
        return !TextUtils.isEmpty(this.accountFlag) && this.accountFlag.length() >= 2 && this.accountFlag.charAt(1) == '1';
    }

    public String getAccountFlag() {
        return this.accountFlag;
    }

    public String getCategory() {
        return this.category;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public Boolean getMe() {
        return this.f22149me;
    }

    public String getPermissionId() {
        return this.permissionId;
    }

    public String getProfilePhotoLink() {
        return this.profilePhotoLink;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setAccountFlag(String str) {
        this.accountFlag = str;
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
        this.f22149me = bool;
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

    public User setUserId(String str) {
        this.userId = str;
        return this;
    }

    @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n
    public User set(String str, Object obj) {
        return (User) super.set(str, obj);
    }
}
