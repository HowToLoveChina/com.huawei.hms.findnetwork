package com.huawei.hicloud.cloudbackup.p104v3.server.model;

import com.huawei.cloud.base.util.C4644l;
import com.huawei.cloud.base.util.InterfaceC4648p;
import java.util.List;
import java.util.Map;
import ni.C11707b;

/* loaded from: classes6.dex */
public class Resource extends C11707b {

    @InterfaceC4648p
    private C11707b attributes;

    @InterfaceC4648p
    private Long compressedSize;

    @InterfaceC4648p
    private C4644l createdTime;

    @InterfaceC4648p
    private EndpointURL downloadUrl;

    @InterfaceC4648p
    private String hash;

    /* renamed from: id */
    @InterfaceC4648p
    private String f22596id;

    @InterfaceC4648p
    private Long length;

    @InterfaceC4648p
    private C4644l modifiedTime;

    @InterfaceC4648p
    private List<SliceObject> objects;

    @InterfaceC4648p
    private String owner;

    @InterfaceC4648p
    private Map<String, String> properties;

    @InterfaceC4648p
    private String sha256;

    @InterfaceC4648p
    private Long sliceSize;

    @InterfaceC4648p
    private Integer state;

    @InterfaceC4648p
    private Integer type;

    public C11707b getAttributes() {
        return this.attributes;
    }

    public Long getCompressedSize() {
        Long l10 = this.compressedSize;
        if (l10 == null) {
            return -1L;
        }
        return l10;
    }

    public C4644l getCreatedTime() {
        return this.createdTime;
    }

    public EndpointURL getDownloadUrl() {
        return this.downloadUrl;
    }

    public String getHash() {
        return this.hash;
    }

    public String getId() {
        return this.f22596id;
    }

    public Long getLength() {
        return this.length;
    }

    public C4644l getModifiedTime() {
        return this.modifiedTime;
    }

    public List<SliceObject> getObjects() {
        return this.objects;
    }

    public String getOwner() {
        return this.owner;
    }

    public Map<String, String> getProperties() {
        return this.properties;
    }

    public String getSha256() {
        return this.sha256;
    }

    public Long getSliceSize() {
        return this.sliceSize;
    }

    public Integer getState() {
        return this.state;
    }

    public Integer getType() {
        return this.type;
    }

    public Resource setAttributes(C11707b c11707b) {
        this.attributes = c11707b;
        return this;
    }

    public Resource setCreatedTime(C4644l c4644l) {
        this.createdTime = c4644l;
        return this;
    }

    public Resource setDownloadUrl(EndpointURL endpointURL) {
        this.downloadUrl = endpointURL;
        return this;
    }

    public Resource setHash(String str) {
        this.hash = str;
        return this;
    }

    public Resource setId(String str) {
        this.f22596id = str;
        return this;
    }

    public Resource setLength(Long l10) {
        this.length = l10;
        return this;
    }

    public Resource setModifiedTime(C4644l c4644l) {
        this.modifiedTime = c4644l;
        return this;
    }

    public Resource setObjects(List<SliceObject> list) {
        this.objects = list;
        return this;
    }

    public Resource setOwner(String str) {
        this.owner = str;
        return this;
    }

    public Resource setProperties(Map<String, String> map) {
        this.properties = map;
        return this;
    }

    public Resource setSha256(String str) {
        this.sha256 = str;
        return this;
    }

    public Resource setSliceSize(Long l10) {
        this.sliceSize = l10;
        return this;
    }

    public Resource setState(Integer num) {
        this.state = num;
        return this;
    }

    public Resource setType(Integer num) {
        this.type = num;
        return this;
    }

    public static class EndpointURL extends C11707b {

        @InterfaceC4648p
        private Map<String, String> headers;

        @InterfaceC4648p
        private String method;

        @InterfaceC4648p
        private String url;

        public Map<String, String> getHeaders() {
            return this.headers;
        }

        public String getMethod() {
            return this.method;
        }

        public String getUrl() {
            return this.url;
        }

        public EndpointURL setHeaders(Map<String, String> map) {
            this.headers = map;
            return this;
        }

        public EndpointURL setMethod(String str) {
            this.method = str;
            return this;
        }

        public EndpointURL setUrl(String str) {
            this.url = str;
            return this;
        }

        @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n
        public EndpointURL set(String str, Object obj) {
            return (EndpointURL) super.set(str, obj);
        }
    }

    public static class SliceObject extends C11707b {

        @InterfaceC4648p
        private EndpointURL accelerateDownloadUrl;

        @InterfaceC4648p
        private EndpointURL accelerateUploadUrl;

        @InterfaceC4648p
        private C11707b attributes;

        @InterfaceC4648p
        private String bucket;

        @InterfaceC4648p
        private C4644l createdTime;

        @InterfaceC4648p
        private EndpointURL downloadUrl;

        /* renamed from: id */
        @InterfaceC4648p
        private String f22597id;

        @InterfaceC4648p
        private Long length;

        @InterfaceC4648p
        private String md5;

        @InterfaceC4648p
        private C4644l modifiedTime;

        @InterfaceC4648p
        private Integer number;

        @InterfaceC4648p
        private Map<String, String> properties;

        @InterfaceC4648p
        private String sha256;

        @InterfaceC4648p
        private Long start;

        @InterfaceC4648p
        private Integer state;

        @InterfaceC4648p
        private EndpointURL uploadUrl;

        public EndpointURL getAccelerateDownloadUrl() {
            return this.accelerateDownloadUrl;
        }

        public EndpointURL getAccelerateUploadUrl() {
            return this.accelerateUploadUrl;
        }

        public C11707b getAttributes() {
            return this.attributes;
        }

        public String getBucket() {
            return this.bucket;
        }

        public C4644l getCreatedTime() {
            return this.createdTime;
        }

        public EndpointURL getDownloadUrl() {
            return this.downloadUrl;
        }

        public String getId() {
            return this.f22597id;
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

        public Map<String, String> getProperties() {
            return this.properties;
        }

        public String getSha256() {
            return this.sha256;
        }

        public Long getStart() {
            return this.start;
        }

        public Integer getState() {
            return this.state;
        }

        public EndpointURL getUploadUrl() {
            return this.uploadUrl;
        }

        public SliceObject setAccelerateDownloadUrl(EndpointURL endpointURL) {
            this.accelerateDownloadUrl = endpointURL;
            return this;
        }

        public SliceObject setAccelerateUploadUrl(EndpointURL endpointURL) {
            this.accelerateUploadUrl = endpointURL;
            return this;
        }

        public SliceObject setAttributes(C11707b c11707b) {
            this.attributes = c11707b;
            return this;
        }

        public SliceObject setBucket(String str) {
            this.bucket = str;
            return this;
        }

        public SliceObject setCreatedTime(C4644l c4644l) {
            this.createdTime = c4644l;
            return this;
        }

        public SliceObject setDownloadUrl(EndpointURL endpointURL) {
            this.downloadUrl = endpointURL;
            return this;
        }

        public SliceObject setId(String str) {
            this.f22597id = str;
            return this;
        }

        public SliceObject setLength(Long l10) {
            this.length = l10;
            return this;
        }

        public SliceObject setMD5(String str) {
            this.md5 = str;
            return this;
        }

        public SliceObject setModifiedTime(C4644l c4644l) {
            this.modifiedTime = c4644l;
            return this;
        }

        public SliceObject setNumber(Integer num) {
            this.number = num;
            return this;
        }

        public SliceObject setProperties(Map<String, String> map) {
            this.properties = map;
            return this;
        }

        public SliceObject setSha256(String str) {
            this.sha256 = str;
            return this;
        }

        public SliceObject setStart(Long l10) {
            this.start = l10;
            return this;
        }

        public SliceObject setState(Integer num) {
            this.state = num;
            return this;
        }

        public SliceObject setUploadUrl(EndpointURL endpointURL) {
            this.uploadUrl = endpointURL;
            return this;
        }

        @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n
        public SliceObject set(String str, Object obj) {
            return (SliceObject) super.set(str, obj);
        }
    }

    @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n
    public Resource set(String str, Object obj) {
        return (Resource) super.set(str, obj);
    }
}
