package com.huawei.android.hicloud.drive.cloudphoto.model;

import android.text.TextUtils;
import com.huawei.cloud.base.util.C4644l;
import com.huawei.cloud.base.util.InterfaceC4648p;
import com.huawei.hicloud.notification.constants.HNConstants;
import java.util.Map;
import ni.C11707b;

/* loaded from: classes3.dex */
public class Applicant extends C11707b {

    @InterfaceC4648p
    private String albumId;

    @InterfaceC4648p
    private String applicantId;

    @InterfaceC4648p
    private String auditStatus;

    @InterfaceC4648p
    private C4644l createdTime;

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
    private String source;

    @InterfaceC4648p
    private String userAccount;

    @InterfaceC4648p
    private String userId;

    @InterfaceC4648p
    private Boolean verify;

    public boolean canDownload() {
        if (TextUtils.isEmpty(this.privilege) || this.privilege.equals(HNConstants.DataType.f22634NA)) {
            return false;
        }
        return this.privilege.contains("download");
    }

    public boolean canUpload() {
        if (TextUtils.isEmpty(this.privilege) || this.privilege.equals(HNConstants.DataType.f22634NA)) {
            return false;
        }
        return this.privilege.contains("upload");
    }

    public String getAlbumId() {
        return this.albumId;
    }

    public String getApplicantId() {
        return this.applicantId;
    }

    public C4644l getCreatedTime() {
        return this.createdTime;
    }

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

    public String getSource() {
        return this.source;
    }

    public String getStatus() {
        return this.auditStatus;
    }

    public String getUserAccount() {
        return this.userAccount;
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

    public void setApplicantId(String str) {
        this.applicantId = str;
    }

    public void setCreatedTime(C4644l c4644l) {
        this.createdTime = c4644l;
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

    public void setSource(String str) {
        this.source = str;
    }

    public void setStatus(String str) {
        this.auditStatus = str;
    }

    public void setUserAccount(String str) {
        this.userAccount = str;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public void setVerify(Boolean bool) {
        this.verify = bool;
    }
}
