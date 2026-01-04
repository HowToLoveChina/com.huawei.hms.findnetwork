package com.huawei.android.hicloud.syncdrive.cloudsync.model;

import com.huawei.cloud.base.util.C4644l;
import com.huawei.cloud.base.util.InterfaceC4648p;
import com.huawei.hicloud.base.drive.model.EndpointUrl;
import java.util.Map;
import ni.C11707b;

/* loaded from: classes3.dex */
public class SliceObject extends C11707b {

    @InterfaceC4648p
    private EndpointUrl accelerateDownloadUrl;

    @InterfaceC4648p
    private EndpointUrl accelerateUploadUrl;

    @InterfaceC4648p
    private Map<String, Object> attributes;

    @InterfaceC4648p
    private String bucket;

    @InterfaceC4648p
    private C4644l createdTime;

    @InterfaceC4648p
    private EndpointUrl downloadUrl;

    /* renamed from: id */
    @InterfaceC4648p
    private String f13038id;

    @InterfaceC4648p
    private Long length;

    @InterfaceC4648p
    private String md5;

    @InterfaceC4648p
    private C4644l modifiedTime;

    @InterfaceC4648p
    private Integer number;

    @InterfaceC4648p
    private String objectId;

    @InterfaceC4648p
    private Map<String, String> properties;

    @InterfaceC4648p
    private String sha256;

    @InterfaceC4648p
    private Long start;

    @InterfaceC4648p
    private UploadStatus uploadStatus;

    @InterfaceC4648p
    private EndpointUrl uploadUrl;

    public static class UploadStatus extends C11707b {

        @InterfaceC4648p
        private String body;

        @InterfaceC4648p
        private Map<String, String> headers;

        @InterfaceC4648p
        private Integer status;

        public String getBody() {
            return this.body;
        }

        public Map<String, String> getHeaders() {
            return this.headers;
        }

        public Integer getStatus() {
            return this.status;
        }

        public void setBody(String str) {
            this.body = str;
        }

        public void setHeaders(Map<String, String> map) {
            this.headers = map;
        }

        public void setStatus(Integer num) {
            this.status = num;
        }
    }

    public EndpointUrl getAccelerateDownloadUrl() {
        return this.accelerateDownloadUrl;
    }

    public EndpointUrl getAccelerateUploadUrl() {
        return this.accelerateUploadUrl;
    }

    public Map<String, Object> getAttributes() {
        return this.attributes;
    }

    public String getBucket() {
        return this.bucket;
    }

    public C4644l getCreatedTime() {
        return this.createdTime;
    }

    public EndpointUrl getDownloadUrl() {
        return this.downloadUrl;
    }

    public String getId() {
        return this.f13038id;
    }

    public Long getLength() {
        return this.length;
    }

    public String getMD5() {
        return this.md5;
    }

    public C4644l getModifiedTime() {
        return this.modifiedTime;
    }

    public Integer getNumber() {
        return this.number;
    }

    public String getObjectId() {
        return this.objectId;
    }

    public Map<String, String> getProperties() {
        return this.properties;
    }

    public String getSha256() {
        return this.sha256;
    }

    public Long getStart() {
        return this.start;
    }

    public UploadStatus getUploadStatus() {
        return this.uploadStatus;
    }

    public EndpointUrl getUploadUrl() {
        return this.uploadUrl;
    }

    public void setAccelerateDownloadUrl(EndpointUrl endpointUrl) {
        this.accelerateDownloadUrl = endpointUrl;
    }

    public void setAccelerateUploadUrl(EndpointUrl endpointUrl) {
        this.accelerateUploadUrl = endpointUrl;
    }

    public void setAttributes(Map<String, Object> map) {
        this.attributes = map;
    }

    public void setBucket(String str) {
        this.bucket = str;
    }

    public void setCreatedTime(C4644l c4644l) {
        this.createdTime = c4644l;
    }

    public void setDownloadUrl(EndpointUrl endpointUrl) {
        this.downloadUrl = endpointUrl;
    }

    public void setId(String str) {
        this.f13038id = str;
    }

    public void setLength(Long l10) {
        this.length = l10;
    }

    public void setMD5(String str) {
        this.md5 = str;
    }

    public void setModifiedTime(C4644l c4644l) {
        this.modifiedTime = c4644l;
    }

    public void setNumber(Integer num) {
        this.number = num;
    }

    public void setObjectId(String str) {
        this.objectId = str;
    }

    public void setProperties(Map<String, String> map) {
        this.properties = map;
    }

    public void setSha256(String str) {
        this.sha256 = str;
    }

    public void setStart(Long l10) {
        this.start = l10;
    }

    public void setUploadStatus(UploadStatus uploadStatus) {
        this.uploadStatus = uploadStatus;
    }

    public void setUploadUrl(EndpointUrl endpointUrl) {
        this.uploadUrl = endpointUrl;
    }
}
