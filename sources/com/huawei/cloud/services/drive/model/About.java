package com.huawei.cloud.services.drive.model;

import com.huawei.cloud.base.util.InterfaceC4648p;
import ni.C11707b;
import ni.InterfaceC11712g;

/* loaded from: classes5.dex */
public final class About extends C11707b {

    @InterfaceC4648p
    private String category;

    @InterfaceC4648p
    @InterfaceC11712g
    private Long maxFileUploadSize;

    @InterfaceC4648p
    private Long maxThumbnailSize;

    @InterfaceC4648p
    private Boolean needUpdate;

    @InterfaceC4648p
    private Long serverTime;

    @InterfaceC4648p
    private StorageQuota storageQuota;

    @InterfaceC4648p
    private String updateUrl;

    @InterfaceC4648p
    private User user;

    public String getCategory() {
        return this.category;
    }

    public Long getMaxFileUploadSize() {
        return this.maxFileUploadSize;
    }

    public Long getMaxThumbnailSize() {
        return this.maxThumbnailSize;
    }

    public Long getServerTime() {
        return this.serverTime;
    }

    public StorageQuota getStorageQuota() {
        return this.storageQuota;
    }

    public String getUpdateUrl() {
        return this.updateUrl;
    }

    public User getUser() {
        return this.user;
    }

    public boolean isNeedUpdate() {
        return this.needUpdate.booleanValue();
    }

    public About setCategory(String str) {
        this.category = str;
        return this;
    }

    public About setMaxFileUploadSize(Long l10) {
        this.maxFileUploadSize = l10;
        return this;
    }

    public About setMaxThumbnailSize(Long l10) {
        this.maxThumbnailSize = l10;
        return this;
    }

    public About setNeedUpdate(boolean z10) {
        this.needUpdate = Boolean.valueOf(z10);
        return this;
    }

    public About setServerTime(Long l10) {
        this.serverTime = l10;
        return this;
    }

    public About setStorageQuota(StorageQuota storageQuota) {
        this.storageQuota = storageQuota;
        return this;
    }

    public About setUpdateUrl(String str) {
        this.updateUrl = str;
        return this;
    }

    public About setUser(User user) {
        this.user = user;
        return this;
    }

    public static final class StorageQuota extends C11707b {

        @InterfaceC4648p
        @InterfaceC11712g
        private Long usedSpace;

        @InterfaceC4648p
        @InterfaceC11712g
        private Long userCapacity;

        public Long getUsedSpace() {
            return this.usedSpace;
        }

        public Long getUserCapacity() {
            return this.userCapacity;
        }

        public StorageQuota setUsedSpace(Long l10) {
            this.usedSpace = l10;
            return this;
        }

        public StorageQuota setUserCapacity(Long l10) {
            this.userCapacity = l10;
            return this;
        }

        @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n
        public StorageQuota set(String str, Object obj) {
            return (StorageQuota) super.set(str, obj);
        }

        @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n, java.util.AbstractMap
        public StorageQuota clone() {
            return (StorageQuota) super.clone();
        }
    }

    @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n
    public About set(String str, Object obj) {
        return (About) super.set(str, obj);
    }

    @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n, java.util.AbstractMap
    public About clone() {
        return (About) super.clone();
    }
}
