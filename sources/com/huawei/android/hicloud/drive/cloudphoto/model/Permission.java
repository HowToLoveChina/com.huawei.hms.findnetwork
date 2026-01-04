package com.huawei.android.hicloud.drive.cloudphoto.model;

import android.text.TextUtils;
import com.huawei.cloud.base.util.C4644l;
import com.huawei.cloud.base.util.InterfaceC4648p;
import com.huawei.hicloud.notification.constants.HNConstants;
import java.util.Map;
import ni.C11707b;

/* loaded from: classes3.dex */
public class Permission extends C11707b {

    @InterfaceC4648p
    private String accountType;

    @InterfaceC4648p
    private String category;

    @InterfaceC4648p
    private C4644l createdTime;

    @InterfaceC4648p
    private String displayName;

    @InterfaceC4648p
    private C4644l expirationTime;

    /* renamed from: id */
    @InterfaceC4648p
    private String f12222id;

    @InterfaceC4648p
    private String kinship;

    @InterfaceC4648p
    private C4644l modifiedTime;

    @InterfaceC4648p
    private String privilege;

    @InterfaceC4648p
    private Map<String, String> properties;

    @InterfaceC4648p
    private String remark;

    @InterfaceC4648p
    private String role;

    @InterfaceC4648p
    private String source;

    @InterfaceC4648p
    private Integer status;

    @InterfaceC4648p
    private String type;

    @InterfaceC4648p
    private String userAccount;

    @InterfaceC4648p
    private String userId;

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

    public String getAccountType() {
        return this.accountType;
    }

    public String getCategory() {
        return this.category;
    }

    public C4644l getCreatedTime() {
        return this.createdTime;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public C4644l getExpirationTime() {
        return this.expirationTime;
    }

    public String getId() {
        return this.f12222id;
    }

    public String getKinship() {
        return this.kinship;
    }

    public C4644l getModifiedTime() {
        return this.modifiedTime;
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

    public String getSource() {
        return this.source;
    }

    public Integer getStatus() {
        return this.status;
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

    public Permission setAccountType(String str) {
        this.accountType = str;
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

    public Permission setDisplayName(String str) {
        this.displayName = str;
        return this;
    }

    public Permission setExpirationTime(C4644l c4644l) {
        this.expirationTime = c4644l;
        return this;
    }

    public Permission setId(String str) {
        this.f12222id = str;
        return this;
    }

    public Permission setKinship(String str) {
        this.kinship = str;
        return this;
    }

    public Permission setModifiedTime(C4644l c4644l) {
        this.modifiedTime = c4644l;
        return this;
    }

    public void setPrivilege(String str) {
        this.privilege = str;
    }

    public Permission setProperties(Map<String, String> map) {
        this.properties = map;
        return this;
    }

    public Permission setRemark(String str) {
        this.remark = str;
        return this;
    }

    public Permission setRole(String str) {
        this.role = str;
        return this;
    }

    public Permission setSource(String str) {
        this.source = str;
        return this;
    }

    public Permission setStatus(Integer num) {
        this.status = num;
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

    public Permission setUserId(String str) {
        this.userId = str;
        return this;
    }

    @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n
    public Permission set(String str, Object obj) {
        return (Permission) super.set(str, obj);
    }
}
