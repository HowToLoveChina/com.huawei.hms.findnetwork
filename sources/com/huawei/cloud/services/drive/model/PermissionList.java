package com.huawei.cloud.services.drive.model;

import com.huawei.cloud.base.util.InterfaceC4648p;
import java.util.List;
import ni.C11707b;

/* loaded from: classes5.dex */
public final class PermissionList extends C11707b {

    @InterfaceC4648p
    private String category;

    @InterfaceC4648p
    private String nextCursor;

    @InterfaceC4648p
    private List<Permission> permissions;

    public String getCategory() {
        return this.category;
    }

    public String getNextCursor() {
        return this.nextCursor;
    }

    public List<Permission> getPermissions() {
        return this.permissions;
    }

    public PermissionList setCategory(String str) {
        this.category = str;
        return this;
    }

    public PermissionList setNextCursor(String str) {
        this.nextCursor = str;
        return this;
    }

    public PermissionList setPermissions(List<Permission> list) {
        this.permissions = list;
        return this;
    }

    @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n
    public PermissionList set(String str, Object obj) {
        return (PermissionList) super.set(str, obj);
    }

    @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n, java.util.AbstractMap
    public PermissionList clone() {
        return (PermissionList) super.clone();
    }
}
