package com.huawei.hicloud.cloudbackup.p104v3.server.model;

import com.huawei.cloud.base.util.InterfaceC4648p;
import java.util.List;
import java.util.Map;
import ni.C11707b;

/* loaded from: classes6.dex */
public class RevisionRefresh extends C11707b {

    @InterfaceC4648p
    private C11707b attributes;

    @InterfaceC4648p
    private Cipher cipher;

    @InterfaceC4648p
    private Map<String, String> properties;

    @InterfaceC4648p
    private ResourceUpdate resource;

    public C11707b getAttributes() {
        return this.attributes;
    }

    public Cipher getCipher() {
        return this.cipher;
    }

    public Map<String, String> getProperties() {
        return this.properties;
    }

    public ResourceUpdate getResource() {
        return this.resource;
    }

    public RevisionRefresh setAttributes(C11707b c11707b) {
        this.attributes = c11707b;
        return this;
    }

    public RevisionRefresh setCipher(Cipher cipher) {
        this.cipher = cipher;
        return this;
    }

    public RevisionRefresh setProperties(Map<String, String> map) {
        this.properties = map;
        return this;
    }

    public RevisionRefresh setResource(ResourceUpdate resourceUpdate) {
        this.resource = resourceUpdate;
        return this;
    }

    public static class ObjectUpdate extends C11707b {

        @InterfaceC4648p
        private C11707b attributes;

        @InterfaceC4648p
        private String objectId;

        @InterfaceC4648p
        private Map<String, String> properties;

        @InterfaceC4648p
        private String sha256;

        @InterfaceC4648p
        private SpeedInfo speed;

        @InterfaceC4648p
        private UploadStatus uploadStatus;

        public C11707b getAttributes() {
            return this.attributes;
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

        public SpeedInfo getSpeed() {
            return this.speed;
        }

        public UploadStatus getUploadStatus() {
            return this.uploadStatus;
        }

        public ObjectUpdate setAttributes(C11707b c11707b) {
            this.attributes = c11707b;
            return this;
        }

        public ObjectUpdate setObjectId(String str) {
            this.objectId = str;
            return this;
        }

        public ObjectUpdate setProperties(Map<String, String> map) {
            this.properties = map;
            return this;
        }

        public ObjectUpdate setSha256(String str) {
            this.sha256 = str;
            return this;
        }

        public ObjectUpdate setSpeed(SpeedInfo speedInfo) {
            this.speed = speedInfo;
            return this;
        }

        public ObjectUpdate setUploadStatus(UploadStatus uploadStatus) {
            this.uploadStatus = uploadStatus;
            return this;
        }

        @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n
        public ObjectUpdate set(String str, Object obj) {
            return (ObjectUpdate) super.set(str, obj);
        }
    }

    public static class ResourceUpdate extends C11707b {

        @InterfaceC4648p
        private C11707b attributes;

        @InterfaceC4648p
        private String hash;

        @InterfaceC4648p
        private List<ObjectUpdate> objects;

        @InterfaceC4648p
        private Map<String, String> properties;

        @InterfaceC4648p
        private String sha256;

        public C11707b getAttributes() {
            return this.attributes;
        }

        public String getHash() {
            return this.hash;
        }

        public List<ObjectUpdate> getObjects() {
            return this.objects;
        }

        public Map<String, String> getProperties() {
            return this.properties;
        }

        public String getSha256() {
            return this.sha256;
        }

        public ResourceUpdate setAttributes(C11707b c11707b) {
            this.attributes = c11707b;
            return this;
        }

        public ResourceUpdate setHash(String str) {
            this.hash = str;
            return this;
        }

        public ResourceUpdate setObjects(List<ObjectUpdate> list) {
            this.objects = list;
            return this;
        }

        public ResourceUpdate setProperties(Map<String, String> map) {
            this.properties = map;
            return this;
        }

        public ResourceUpdate setSha256(String str) {
            this.sha256 = str;
            return this;
        }

        @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n
        public ResourceUpdate set(String str, Object obj) {
            return (ResourceUpdate) super.set(str, obj);
        }
    }

    public static class SpeedInfo extends C11707b {

        @InterfaceC4648p
        private Double timeAppConnect;

        @InterfaceC4648p
        private Double timeConnect;

        @InterfaceC4648p
        private Double timeNameLookup;

        @InterfaceC4648p
        private Double timePreTransfer;

        @InterfaceC4648p
        private Double timeRedirect;

        @InterfaceC4648p
        private Double timeStartTransfer;

        @InterfaceC4648p
        private Double timeTotal;

        public Double getTimeAppConnect() {
            return this.timeAppConnect;
        }

        public Double getTimeConnect() {
            return this.timeConnect;
        }

        public Double getTimeNameLookup() {
            return this.timeNameLookup;
        }

        public Double getTimePreTransfer() {
            return this.timePreTransfer;
        }

        public Double getTimeRedirect() {
            return this.timeRedirect;
        }

        public Double getTimeStartTransfer() {
            return this.timeStartTransfer;
        }

        public Double getTimeTotal() {
            return this.timeTotal;
        }

        public SpeedInfo setTimeAppConnect(Double d10) {
            this.timeAppConnect = d10;
            return this;
        }

        public SpeedInfo setTimeConnect(Double d10) {
            this.timeConnect = d10;
            return this;
        }

        public SpeedInfo setTimeNameLookup(Double d10) {
            this.timeNameLookup = d10;
            return this;
        }

        public SpeedInfo setTimePreTransfer(Double d10) {
            this.timePreTransfer = d10;
            return this;
        }

        public SpeedInfo setTimeRedirect(Double d10) {
            this.timeRedirect = d10;
            return this;
        }

        public SpeedInfo setTimeStartTransfer(Double d10) {
            this.timeStartTransfer = d10;
            return this;
        }

        public SpeedInfo setTimeTotal(Double d10) {
            this.timeTotal = d10;
            return this;
        }

        @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n
        public SpeedInfo set(String str, Object obj) {
            return (SpeedInfo) super.set(str, obj);
        }
    }

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

        public UploadStatus setBody(String str) {
            this.body = str;
            return this;
        }

        public UploadStatus setHeaders(Map<String, String> map) {
            this.headers = map;
            return this;
        }

        public UploadStatus setStatus(Integer num) {
            this.status = num;
            return this;
        }

        @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n
        public UploadStatus set(String str, Object obj) {
            return (UploadStatus) super.set(str, obj);
        }
    }

    @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n
    public RevisionRefresh set(String str, Object obj) {
        return (RevisionRefresh) super.set(str, obj);
    }
}
