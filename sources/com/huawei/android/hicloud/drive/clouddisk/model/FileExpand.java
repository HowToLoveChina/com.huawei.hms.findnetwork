package com.huawei.android.hicloud.drive.clouddisk.model;

import com.huawei.cloud.base.util.InterfaceC4648p;
import com.huawei.cloud.services.drive.model.File;
import java.util.List;
import ni.C11707b;

/* loaded from: classes3.dex */
public final class FileExpand extends File {

    @InterfaceC4648p
    private List<Attachment> attachments;

    @InterfaceC4648p
    private String downloadURL;

    @InterfaceC4648p
    private List<EncFekDetailInfo> encFekList;

    @InterfaceC4648p
    private String hash;

    @InterfaceC4648p
    private List<String> ids;

    @InterfaceC4648p
    private boolean isRiskFile;

    @InterfaceC4648p
    private List<ObjectDetailInfo> objectInfoList;
    private String preFileId;

    @InterfaceC4648p
    private String recordCursor;

    @InterfaceC4648p
    private Integer resourceType;

    @InterfaceC4648p
    private String smallThumbnailDownloadLink;

    @InterfaceC4648p
    private String thumbnailDownloadLink;

    @InterfaceC4648p
    private String uploadType;

    public static final class Attribute extends C11707b {

        @InterfaceC4648p
        private Long length;

        @InterfaceC4648p
        private String name;

        public Long getLength() {
            return this.length;
        }

        public String getName() {
            return this.name;
        }

        public Attribute setLength(Long l10) {
            this.length = l10;
            return this;
        }

        public Attribute setName(String str) {
            this.name = str;
            return this;
        }
    }

    public static final class EncFekDetailInfo extends C11707b {

        /* renamed from: IV */
        @InterfaceC4648p
        private String f12208IV;

        @InterfaceC4648p
        private String encFek;

        @InterfaceC4648p
        private String fekEncType;

        @InterfaceC4648p
        private String keyType;

        @InterfaceC4648p
        private String keyUuid;

        public String getEncFek() {
            return this.encFek;
        }

        public String getFekEncType() {
            return this.fekEncType;
        }

        public String getIV() {
            return this.f12208IV;
        }

        public String getKeyType() {
            return this.keyType;
        }

        public String getKeyUuid() {
            return this.keyUuid;
        }

        public EncFekDetailInfo setEncFek(String str) {
            this.encFek = str;
            return this;
        }

        public EncFekDetailInfo setFekEncType(String str) {
            this.fekEncType = str;
            return this;
        }

        public EncFekDetailInfo setIV(String str) {
            this.f12208IV = str;
            return this;
        }

        public EncFekDetailInfo setKeyType(String str) {
            this.keyType = str;
            return this;
        }

        public EncFekDetailInfo setKeyUuid(String str) {
            this.keyUuid = str;
            return this;
        }
    }

    public static final class ObjectDetailInfo extends C11707b {

        @InterfaceC4648p
        private List<Attribute> attributes;

        @InterfaceC4648p
        private String objectBucketId;

        @InterfaceC4648p
        private List<String> objectKeys;

        @InterfaceC4648p
        private Long sliceSize;

        @InterfaceC4648p("synckeys")
        private List<String> syncKeys;

        @InterfaceC4648p
        private String timeStamp;

        public List<Attribute> getAttributes() {
            return this.attributes;
        }

        public String getObjectBucketId() {
            return this.objectBucketId;
        }

        public List<String> getObjectKeys() {
            return this.objectKeys;
        }

        public Long getSliceSize() {
            return this.sliceSize;
        }

        public List<String> getSyncKeys() {
            return this.syncKeys;
        }

        public String getTimeStamp() {
            return this.timeStamp;
        }

        public ObjectDetailInfo setAttributes(List<Attribute> list) {
            this.attributes = list;
            return this;
        }

        public ObjectDetailInfo setObjectBucketId(String str) {
            this.objectBucketId = str;
            return this;
        }

        public ObjectDetailInfo setObjectKeys(List<String> list) {
            this.objectKeys = list;
            return this;
        }

        public ObjectDetailInfo setSliceSize(Long l10) {
            this.sliceSize = l10;
            return this;
        }

        public ObjectDetailInfo setSyncKeys(List<String> list) {
            this.syncKeys = list;
            return this;
        }

        public ObjectDetailInfo setTimeStamp(String str) {
            this.timeStamp = str;
            return this;
        }
    }

    public List<Attachment> getAttachments() {
        return this.attachments;
    }

    public String getDownloadURL() {
        return this.downloadURL;
    }

    public List<EncFekDetailInfo> getEncFekList() {
        return this.encFekList;
    }

    public String getHash() {
        return this.hash;
    }

    public List<String> getIds() {
        return this.ids;
    }

    public String getLCDThumbnailDownloadLink() {
        return this.thumbnailDownloadLink;
    }

    public List<ObjectDetailInfo> getObjectInfoList() {
        return this.objectInfoList;
    }

    public String getPreFileId() {
        return this.preFileId;
    }

    public String getRecordCursor() {
        return this.recordCursor;
    }

    public Integer getResourceType() {
        return this.resourceType;
    }

    @Override // com.huawei.cloud.services.drive.model.File
    public String getSmallThumbnailDownloadLink() {
        return this.smallThumbnailDownloadLink;
    }

    public String getUploadType() {
        return this.uploadType;
    }

    public boolean isRiskFile() {
        return this.isRiskFile;
    }

    public void setAttachments(List<Attachment> list) {
        this.attachments = list;
    }

    public FileExpand setDownloadURL(String str) {
        this.downloadURL = str;
        return this;
    }

    public FileExpand setEncFekList(List<EncFekDetailInfo> list) {
        this.encFekList = list;
        return this;
    }

    public FileExpand setHash(String str) {
        this.hash = str;
        return this;
    }

    public void setIds(List<String> list) {
        this.ids = list;
    }

    public FileExpand setLCDThumbnailDownloadLink(String str) {
        this.thumbnailDownloadLink = str;
        return this;
    }

    public FileExpand setObjectInfoList(List<ObjectDetailInfo> list) {
        this.objectInfoList = list;
        return this;
    }

    public void setPreFileId(String str) {
        this.preFileId = str;
    }

    public FileExpand setRecordCursor(String str) {
        this.recordCursor = str;
        return this;
    }

    public void setResourceType(Integer num) {
        this.resourceType = num;
    }

    public void setRiskFile(boolean z10) {
        this.isRiskFile = z10;
    }

    public void setUploadType(String str) {
        this.uploadType = str;
    }

    @Override // com.huawei.cloud.services.drive.model.File
    public FileExpand setSmallThumbnailDownloadLink(String str) {
        this.smallThumbnailDownloadLink = str;
        return this;
    }
}
