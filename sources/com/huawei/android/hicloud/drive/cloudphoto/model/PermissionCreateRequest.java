package com.huawei.android.hicloud.drive.cloudphoto.model;

import com.huawei.cloud.base.util.C4644l;
import com.huawei.cloud.base.util.InterfaceC4648p;
import ni.C11707b;

/* loaded from: classes3.dex */
public class PermissionCreateRequest extends C11707b {

    @InterfaceC4648p
    private String accountType;

    @InterfaceC4648p
    private C4644l expirationTime;

    @InterfaceC4648p
    private String role;

    @InterfaceC4648p
    private String type;

    @InterfaceC4648p
    private String userAccount;

    @InterfaceC4648p
    private String userId;

    public interface Type {
        public static final String ANYONE = "anyone";
        public static final String USER = "user";
    }

    public String getAccountType() {
        return this.accountType;
    }

    public C4644l getExpirationTime() {
        return this.expirationTime;
    }

    public String getRole() {
        return this.role;
    }

    public String getType() {
        return this.type;
    }

    public String getUserAccount() {
        return this.userAccount;
    }

    public String getUserId() {
        return this.userId;
    }

    public PermissionCreateRequest setAccountType(String str) {
        this.accountType = str;
        return this;
    }

    public PermissionCreateRequest setExpirationTime(C4644l c4644l) {
        this.expirationTime = c4644l;
        return this;
    }

    public PermissionCreateRequest setRole(String str) {
        this.role = str;
        return this;
    }

    public PermissionCreateRequest setType(String str) {
        this.type = str;
        return this;
    }

    public PermissionCreateRequest setUserAccount(String str) {
        this.userAccount = str;
        return this;
    }

    public PermissionCreateRequest setUserId(String str) {
        this.userId = str;
        return this;
    }

    @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n
    public PermissionCreateRequest set(String str, Object obj) {
        return (PermissionCreateRequest) super.set(str, obj);
    }
}
