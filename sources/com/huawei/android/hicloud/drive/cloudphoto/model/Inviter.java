package com.huawei.android.hicloud.drive.cloudphoto.model;

import com.huawei.cloud.base.util.C4644l;
import com.huawei.cloud.base.util.InterfaceC4648p;
import java.io.Serializable;
import java.util.List;
import ni.C11707b;

/* loaded from: classes3.dex */
public class Inviter extends C11707b implements Serializable {
    public static final String INVITE_CODE = "inviteCode";
    public static final String WECHAT = "wechat";
    private static final long serialVersionUID = 8080518179846408023L;

    @InterfaceC4648p
    private String albumId;

    @InterfaceC4648p
    private String albumName;

    @InterfaceC4648p
    private String albumUserId;

    @InterfaceC4648p
    private String babyAvatar;

    @InterfaceC4648p
    private String babySex;

    @InterfaceC4648p
    private C4644l createdTime;

    @InterfaceC4648p
    private C4644l expirationTime;

    @InterfaceC4648p
    private String inviterId;

    @InterfaceC4648p
    private String inviterKinship;

    @InterfaceC4648p
    private Boolean joined;

    @InterfaceC4648p
    private String kinship;

    @InterfaceC4648p
    private Member members;

    @InterfaceC4648p
    private String privilege;

    @InterfaceC4648p
    private String remark;

    @InterfaceC4648p
    private String role;

    @InterfaceC4648p
    private Integer shareType;

    @InterfaceC4648p
    private List<String> showImages;

    @InterfaceC4648p
    private String source;

    @InterfaceC4648p
    private String userId;

    @InterfaceC4648p
    private Boolean verify;

    public String getAlbumId() {
        return this.albumId;
    }

    public String getAlbumName() {
        return this.albumName;
    }

    public String getAlbumUserId() {
        return this.albumUserId;
    }

    public String getBabyAvatar() {
        return this.babyAvatar;
    }

    public String getBabySex() {
        return this.babySex;
    }

    public C4644l getCreatedTime() {
        return this.createdTime;
    }

    public C4644l getExpirationTime() {
        return this.expirationTime;
    }

    public String getInviterId() {
        return this.inviterId;
    }

    public String getInviterKinship() {
        return this.inviterKinship;
    }

    public Boolean getJoined() {
        return this.joined;
    }

    public String getKinship() {
        return this.kinship;
    }

    public Member getMembers() {
        return this.members;
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

    public Integer getShareType() {
        return this.shareType;
    }

    public List<String> getShowImages() {
        return this.showImages;
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

    public void setAlbumName(String str) {
        this.albumName = str;
    }

    public void setAlbumUserId(String str) {
        this.albumUserId = str;
    }

    public void setBabyAvatar(String str) {
        this.babyAvatar = str;
    }

    public void setBabySex(String str) {
        this.babySex = str;
    }

    public void setCreatedTime(C4644l c4644l) {
        this.createdTime = c4644l;
    }

    public void setExpirationTime(C4644l c4644l) {
        this.expirationTime = c4644l;
    }

    public void setInviterId(String str) {
        this.inviterId = str;
    }

    public void setInviterKinship(String str) {
        this.inviterKinship = str;
    }

    public void setJoined(Boolean bool) {
        this.joined = bool;
    }

    public void setKinship(String str) {
        this.kinship = str;
    }

    public void setMembers(Member member) {
        this.members = member;
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

    public void setShareType(Integer num) {
        this.shareType = num;
    }

    public void setShowImages(List<String> list) {
        this.showImages = list;
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
