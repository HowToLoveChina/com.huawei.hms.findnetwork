package com.huawei.android.hicloud.drive.cloudphoto.model;

import com.huawei.cloud.base.util.C4644l;
import com.huawei.cloud.base.util.InterfaceC4648p;
import java.util.Map;
import ni.C11707b;

/* loaded from: classes3.dex */
public class PermissionUpdateRequest extends C11707b {
    public static final int STARTUS_ACCET = 0;
    public static final int STARTUS_REJECT = 1;

    @InterfaceC4648p
    private C4644l expirationTime;

    @InterfaceC4648p
    private String kinship;

    @InterfaceC4648p
    private String privilege;

    @InterfaceC4648p
    private Map<String, String> properties;

    @InterfaceC4648p
    private String remark;

    @InterfaceC4648p
    private String role;

    @InterfaceC4648p
    private Integer status;

    public C4644l getExpirationTime() {
        return this.expirationTime;
    }

    public String getKinship() {
        return this.kinship;
    }

    public String getPrivilege() {
        return this.privilege;
    }

    public Map<String, String> getProperties() {
        return this.properties;
    }

    public String getRemark() {
        return this.remark;
    }

    public String getRole() {
        return this.role;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setExpirationTime(C4644l c4644l) {
        this.expirationTime = c4644l;
    }

    public void setKinship(String str) {
        this.kinship = str;
    }

    public void setPrivilege(String str) {
        this.privilege = str;
    }

    public void setProperties(Map<String, String> map) {
        this.properties = map;
    }

    public void setRemark(String str) {
        this.remark = str;
    }

    public void setRole(String str) {
        this.role = str;
    }

    public PermissionUpdateRequest setStatus(Integer num) {
        this.status = num;
        return this;
    }
}
