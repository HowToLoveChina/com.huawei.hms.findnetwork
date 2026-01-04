package com.huawei.cloud.services.drive.model;

import com.huawei.cloud.base.util.C4644l;
import com.huawei.cloud.base.util.InterfaceC4648p;
import java.util.List;
import java.util.Map;
import ni.C11707b;

/* loaded from: classes5.dex */
public class Permission extends C11707b {

    @InterfaceC4648p
    private String accountType;

    @InterfaceC4648p
    private Boolean canDiscoverFile;

    @InterfaceC4648p
    private String category;

    @InterfaceC4648p
    private C4644l createdTime;

    @InterfaceC4648p
    private Boolean deleted;

    @InterfaceC4648p
    private String displayName;

    @InterfaceC4648p
    private C4644l editedTime;

    @InterfaceC4648p
    private Integer expirationDays;

    @InterfaceC4648p
    private C4644l expirationTime;

    /* renamed from: id */
    @InterfaceC4648p
    private String f21492id;

    @InterfaceC4648p
    private List<PermissionDetails> permissionDetails;

    @InterfaceC4648p
    private String profilePhotoLink;

    @InterfaceC4648p
    private Map<String, String> properties;

    @InterfaceC4648p
    private Integer receiverCount;

    @InterfaceC4648p
    private Integer receiverLimit;

    @InterfaceC4648p
    private String role;

    @InterfaceC4648p
    private C4644l shareExpirationTime;

    @InterfaceC4648p
    private Integer shareStatus;

    @InterfaceC4648p
    private String shortLink;

    @InterfaceC4648p
    private String timeZone;

    @InterfaceC4648p
    private String type;

    @InterfaceC4648p
    private String userAccount;

    @InterfaceC4648p
    private Integer validDays;

    public String getAccountType() {
        return this.accountType;
    }

    public Boolean getCanDiscoverFile() {
        return this.canDiscoverFile;
    }

    public String getCategory() {
        return this.category;
    }

    public C4644l getCreatedTime() {
        return this.createdTime;
    }

    public Boolean getDeleted() {
        return this.deleted;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public C4644l getEditedTime() {
        return this.editedTime;
    }

    public Integer getExpirationDays() {
        return this.expirationDays;
    }

    public C4644l getExpirationTime() {
        return this.expirationTime;
    }

    public String getId() {
        return this.f21492id;
    }

    public List<PermissionDetails> getPermissionDetails() {
        return this.permissionDetails;
    }

    public String getProfilePhotoLink() {
        return this.profilePhotoLink;
    }

    public Map<String, String> getProperties() {
        return this.properties;
    }

    public Integer getReceiverCount() {
        return this.receiverCount;
    }

    public Integer getReceiverLimit() {
        return this.receiverLimit;
    }

    public String getRole() {
        return this.role;
    }

    public C4644l getShareExpirationTime() {
        return this.shareExpirationTime;
    }

    public Integer getShareStatus() {
        return this.shareStatus;
    }

    public String getShortLink() {
        return this.shortLink;
    }

    public String getTimeZone() {
        return this.timeZone;
    }

    public String getType() {
        return this.type;
    }

    public String getUserAccount() {
        return this.userAccount;
    }

    public Integer getValidDays() {
        return this.validDays;
    }

    public Permission setAccountType(String str) {
        this.accountType = str;
        return this;
    }

    public Permission setCanDiscoverFile(Boolean bool) {
        this.canDiscoverFile = bool;
        return this;
    }

    public Permission setCategory(String str) {
        this.category = str;
        return this;
    }

    public Permission setCreatedTime(C4644l c4644l) {
        this.createdTime = c4644l;
        return this;
    }

    public Permission setDeleted(Boolean bool) {
        this.deleted = bool;
        return this;
    }

    public Permission setDisplayName(String str) {
        this.displayName = str;
        return this;
    }

    public Permission setEditedTime(C4644l c4644l) {
        this.editedTime = c4644l;
        return this;
    }

    public Permission setExpirationDays(Integer num) {
        this.expirationDays = num;
        return this;
    }

    public Permission setExpirationTime(C4644l c4644l) {
        this.expirationTime = c4644l;
        return this;
    }

    public Permission setId(String str) {
        this.f21492id = str;
        return this;
    }

    public Permission setPermissionDetails(List<PermissionDetails> list) {
        this.permissionDetails = list;
        return this;
    }

    public Permission setProfilePhotoLink(String str) {
        this.profilePhotoLink = str;
        return this;
    }

    public Permission setProperties(Map<String, String> map) {
        this.properties = map;
        return this;
    }

    public Permission setReceiverCount(Integer num) {
        this.receiverCount = num;
        return this;
    }

    public Permission setReceiverLimit(Integer num) {
        this.receiverLimit = num;
        return this;
    }

    public Permission setRole(String str) {
        this.role = str;
        return this;
    }

    public Permission setShareExpirationTime(C4644l c4644l) {
        this.shareExpirationTime = c4644l;
        return this;
    }

    public Permission setShareStatus(Integer num) {
        this.shareStatus = num;
        return this;
    }

    public Permission setShortLink(String str) {
        this.shortLink = str;
        return this;
    }

    public Permission setTimeZone(String str) {
        this.timeZone = str;
        return this;
    }

    public Permission setType(String str) {
        this.type = str;
        return this;
    }

    public Permission setUserAccount(String str) {
        this.userAccount = str;
        return this;
    }

    public Permission setValidDays(Integer num) {
        this.validDays = num;
        return this;
    }

    public static final class PermissionDetails extends C11707b {

        @InterfaceC4648p
        private Boolean inherited;

        @InterfaceC4648p
        private String inheritedFrom;

        @InterfaceC4648p
        private String permissionType;

        @InterfaceC4648p
        private String role;

        public Boolean getInherited() {
            return this.inherited;
        }

        public String getInheritedFrom() {
            return this.inheritedFrom;
        }

        public String getPermissionType() {
            return this.permissionType;
        }

        public String getRole() {
            return this.role;
        }

        public PermissionDetails setInherited(Boolean bool) {
            this.inherited = bool;
            return this;
        }

        public PermissionDetails setInheritedFrom(String str) {
            this.inheritedFrom = str;
            return this;
        }

        public PermissionDetails setPermissionType(String str) {
            this.permissionType = str;
            return this;
        }

        public PermissionDetails setRole(String str) {
            this.role = str;
            return this;
        }

        @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n
        public PermissionDetails set(String str, Object obj) {
            return (PermissionDetails) super.set(str, obj);
        }

        @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n, java.util.AbstractMap
        public PermissionDetails clone() {
            return (PermissionDetails) super.clone();
        }
    }

    @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n
    public Permission set(String str, Object obj) {
        return (Permission) super.set(str, obj);
    }

    @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n, java.util.AbstractMap
    public Permission clone() {
        return (Permission) super.clone();
    }
}
