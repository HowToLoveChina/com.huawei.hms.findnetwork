package com.huawei.android.hicloud.drive.cloudphoto.model;

import com.huawei.cloud.base.util.InterfaceC4648p;
import java.util.Map;
import ni.C11707b;

/* loaded from: classes3.dex */
public class ApplicantCreateRequest extends C11707b {

    @InterfaceC4648p
    private String accountType;

    @InterfaceC4648p
    private String inviteId;

    @InterfaceC4648p
    private String kinship;

    @InterfaceC4648p
    private String privilege;

    @InterfaceC4648p
    private Map<String, String> properties;

    @InterfaceC4648p
    private String remark;

    @InterfaceC4648p
    private String type;

    @InterfaceC4648p
    private String userAccount;

    public interface Type {
        public static final String USER = "user";
    }

    public String getAccountType() {
        return this.accountType;
    }

    public String getInviteId() {
        return this.inviteId;
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

    public String getType() {
        return this.type;
    }

    public String getUserAccount() {
        return this.userAccount;
    }

    public void setAccountType(String str) {
        this.accountType = str;
    }

    public void setInviteId(String str) {
        this.inviteId = str;
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

    public void setType(String str) {
        this.type = str;
    }

    public void setUserAccount(String str) {
        this.userAccount = str;
    }
}
