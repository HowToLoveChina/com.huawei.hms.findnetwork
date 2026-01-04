package com.huawei.android.hicloud.drive.cloudphoto.model;

import com.huawei.cloud.base.util.InterfaceC4648p;
import ni.C11707b;

/* loaded from: classes3.dex */
public class InviterCreateRequest extends C11707b {

    @InterfaceC4648p
    private String albumId;

    @InterfaceC4648p
    private String kinship;

    @InterfaceC4648p
    private String privilege;

    @InterfaceC4648p
    private String remark;

    @InterfaceC4648p
    private String role;

    @InterfaceC4648p
    private String source;

    @InterfaceC4648p
    private String userId;

    @InterfaceC4648p
    private Boolean verify;

    public String getAlbumId() {
        return this.albumId;
    }

    public String getKinship() {
        return this.kinship;
    }

    public String getPrivilege() {
        return this.privilege;
    }

    public String getRemark() {
        return this.remark;
    }

    public String getRole() {
        return this.role;
    }

    public String getSource() {
        return this.source;
    }

    public String getUserId() {
        return this.userId;
    }

    public Boolean isVerify() {
        return this.verify;
    }

    public void setAlbumId(String str) {
        this.albumId = str;
    }

    public void setKinship(String str) {
        this.kinship = str;
    }

    public void setPrivilege(String str) {
        this.privilege = str;
    }

    public void setRemark(String str) {
        this.remark = str;
    }

    public void setRole(String str) {
        this.role = str;
    }

    public void setSource(String str) {
        this.source = str;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public void setVerify(Boolean bool) {
        this.verify = bool;
    }
}
