package com.huawei.android.hicloud.drive.cloudphoto.model;

import com.huawei.cloud.base.util.C4644l;
import com.huawei.cloud.base.util.InterfaceC4648p;
import java.util.HashMap;
import java.util.Map;
import ni.C11707b;

/* loaded from: classes3.dex */
public class Message extends C11707b {

    @InterfaceC4648p
    private String albumId;

    @InterfaceC4648p
    private String albumName;

    @InterfaceC4648p
    private String applicantId;

    @InterfaceC4648p
    private int auditStatus;

    @InterfaceC4648p
    private C4644l createdTime;

    @InterfaceC4648p
    private C4644l expirationTime;

    @InterfaceC4648p
    private String messageId;

    @InterfaceC4648p
    private Integer messageType;

    @InterfaceC4648p
    private Map<String, String> properties;
    private boolean read = false;

    @InterfaceC4648p
    private String receiverId;

    @InterfaceC4648p
    private String receiverName;

    @InterfaceC4648p
    private String senderId;

    @InterfaceC4648p
    private String senderName;

    public String getAlbumId() {
        return this.albumId;
    }

    public String getAlbumName() {
        return this.albumName;
    }

    public String getApplicantId() {
        return this.applicantId;
    }

    public int getAuditStatus() {
        return this.auditStatus;
    }

    public C4644l getCreatedTime() {
        return this.createdTime;
    }

    public C4644l getExpirationTime() {
        return this.expirationTime;
    }

    public String getMessageId() {
        return this.messageId;
    }

    public Integer getMessageType() {
        return this.messageType;
    }

    public Map<String, String> getProperties() {
        Map<String, String> map = this.properties;
        return map == null ? new HashMap() : map;
    }

    public String getReceiverId() {
        return this.receiverId;
    }

    public String getReceiverName() {
        return this.receiverName;
    }

    public String getSenderId() {
        return this.senderId;
    }

    public String getSenderName() {
        return this.senderName;
    }

    public boolean isRead() {
        return this.read;
    }

    public void setAlbumId(String str) {
        this.albumId = str;
    }

    public void setAlbumName(String str) {
        this.albumName = str;
    }

    public void setApplicantId(String str) {
        this.applicantId = str;
    }

    public void setAuditStatus(int i10) {
        this.auditStatus = i10;
    }

    public void setCreatedTime(C4644l c4644l) {
        this.createdTime = c4644l;
    }

    public void setExpirationTime(C4644l c4644l) {
        this.expirationTime = c4644l;
    }

    public void setMessageId(String str) {
        this.messageId = str;
    }

    public void setMessageType(Integer num) {
        this.messageType = num;
    }

    public void setProperties(Map<String, String> map) {
        this.properties = map;
    }

    public void setRead(boolean z10) {
        this.read = z10;
    }

    public void setReceiverId(String str) {
        this.receiverId = str;
    }

    public void setReceiverName(String str) {
        this.receiverName = str;
    }

    public void setSenderId(String str) {
        this.senderId = str;
    }

    public void setSenderName(String str) {
        this.senderName = str;
    }
}
