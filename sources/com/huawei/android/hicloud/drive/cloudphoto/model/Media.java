package com.huawei.android.hicloud.drive.cloudphoto.model;

import com.huawei.android.p069cg.configure.CloudAlbumSettings;
import com.huawei.cloud.base.util.C4644l;
import com.huawei.cloud.base.util.InterfaceC4648p;
import com.huawei.hicloud.base.drive.user.model.User;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import ni.C11707b;

/* loaded from: classes3.dex */
public class Media extends C11707b {

    @InterfaceC4648p
    private String albumId;

    @InterfaceC4648p
    private Map<String, String> appSettings;

    @InterfaceC4648p
    private List<Attachment> attachments;

    @InterfaceC4648p
    private String batchId;

    @InterfaceC4648p
    private String category;

    @InterfaceC4648p
    private Cipher cipher;

    @InterfaceC4648p
    private String contentDownloadLink;

    @InterfaceC4648p
    private C4644l createdTime;

    @InterfaceC4648p
    private User creator;

    @InterfaceC4648p
    private String description;

    @InterfaceC4648p
    private String deviceId;

    @InterfaceC4648p
    private Boolean editedByMe;

    @InterfaceC4648p
    private C4644l editedByMeTime;

    @InterfaceC4648p
    private C4644l editedTime;

    @InterfaceC4648p
    private Boolean favorite;

    @InterfaceC4648p
    private String fileName;

    @InterfaceC4648p
    private String fileSuffix;

    @InterfaceC4648p
    private Integer fileType;

    @InterfaceC4648p
    private String fullFileSuffix;

    @InterfaceC4648p
    private String hash;

    @InterfaceC4648p
    private String hashId;

    /* renamed from: id */
    @InterfaceC4648p
    private String f12221id;

    @InterfaceC4648p
    private User lastEditor;

    @InterfaceC4648p
    private String mediaOwnerId;

    @InterfaceC4648p
    private String mimeType;

    @InterfaceC4648p
    private String originalFilename;

    @InterfaceC4648p
    private Boolean ownedByMe;

    @InterfaceC4648p
    private User owner;

    @InterfaceC4648p
    private PictureMetaData pictureMetadata;

    @InterfaceC4648p
    private Map<String, String> properties;

    @InterfaceC4648p
    private Boolean recycled;

    @InterfaceC4648p
    private C4644l recycledTime;

    @InterfaceC4648p
    private User recyclingUser;

    @InterfaceC4648p
    private List<ScaDetail> scaDetail;

    @InterfaceC4648p
    private String sha256;

    @InterfaceC4648p
    private String signedDownloadLink;

    @InterfaceC4648p
    private Long size;

    @InterfaceC4648p
    private String smallThumbnailDownloadLink;

    @InterfaceC4648p
    private String source;

    @InterfaceC4648p
    private Integer status;

    @InterfaceC4648p
    private String thumbnailDownloadLink;

    @InterfaceC4648p
    private String uploadType;

    @InterfaceC4648p
    private Integer version;

    @InterfaceC4648p
    private VideoMetaData videoMetadata;
    private long localId = -1;
    private int opType = 0;
    private String localThumbPath = "";
    private String localBigThumbPath = "";
    private String localRealPath = "";
    private String albumVersion = "";
    private int albumType = 0;
    private String videoThumbId = "";
    private String thumbFileId = "";
    private String lcdFileId = "";
    private long batchV1Id = 0;
    private long batchV1Time = 0;
    private long localBatchId = 0;
    private int uploadState = 0;
    private int videoTimeDuration = -1;
    private int hwBurstType = 0;
    private int rotation = 1;

    public String getAlbumId() {
        return this.albumId;
    }

    public int getAlbumType() {
        return this.albumType;
    }

    public String getAlbumVersion() {
        return this.albumVersion;
    }

    public Map<String, String> getAppSettings() {
        return this.appSettings;
    }

    public List<Attachment> getAttachments() {
        return this.attachments;
    }

    public String getBatchId() {
        return this.batchId;
    }

    public long getBatchV1Id() {
        return this.batchV1Id;
    }

    public long getBatchV1Time() {
        return this.batchV1Time;
    }

    public String getCategory() {
        return this.category;
    }

    public Cipher getCipher() {
        return this.cipher;
    }

    public String getContentDownloadLink() {
        return this.contentDownloadLink;
    }

    public C4644l getCreatedTime() {
        return this.createdTime;
    }

    public User getCreator() {
        return this.creator;
    }

    public String getDescription() {
        return this.description;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public Boolean getEditedByMe() {
        return this.editedByMe;
    }

    public C4644l getEditedByMeTime() {
        return this.editedByMeTime;
    }

    public C4644l getEditedTime() {
        return this.editedTime;
    }

    public Boolean getFavorite() {
        return this.favorite;
    }

    public String getFileName() {
        return this.fileName;
    }

    public String getFileSuffix() {
        return this.fileSuffix;
    }

    public Integer getFileType() {
        Integer num = this.fileType;
        if (num == null) {
            return 1;
        }
        return num;
    }

    public String getFullFileSuffix() {
        return this.fullFileSuffix;
    }

    public String getHash() {
        return this.hash;
    }

    public String getHashId() {
        return this.hashId;
    }

    public int getHwBurstType() {
        return this.hwBurstType;
    }

    public String getId() {
        return this.f12221id;
    }

    public User getLastEditor() {
        return this.lastEditor;
    }

    public String getLcdFileId() {
        return this.lcdFileId;
    }

    public long getLocalBatchId() {
        return this.localBatchId;
    }

    public String getLocalBigThumbPath() {
        return this.localBigThumbPath;
    }

    public long getLocalId() {
        return this.localId;
    }

    public String getLocalRealPath() {
        return this.localRealPath;
    }

    public String getLocalThumbPath() {
        return this.localThumbPath;
    }

    public String getMediaOwnerId() {
        return this.mediaOwnerId;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public int getOpType() {
        return this.opType;
    }

    public String getOriginalFilename() {
        return this.originalFilename;
    }

    public Boolean getOwnedByMe() {
        return this.ownedByMe;
    }

    public User getOwner() {
        return this.owner;
    }

    public PictureMetaData getPictureMetaData() {
        return this.pictureMetadata;
    }

    public Map<String, String> getProperties() {
        Map<String, String> map = this.properties;
        return map == null ? new HashMap() : map;
    }

    public Boolean getRecycled() {
        return this.recycled;
    }

    public C4644l getRecycledTime() {
        return this.recycledTime;
    }

    public User getRecyclingUser() {
        return this.recyclingUser;
    }

    public int getRotation() {
        return this.rotation;
    }

    public List<ScaDetail> getScaDetail() {
        return this.scaDetail;
    }

    public int getScaRank() {
        if (CloudAlbumSettings.m14363h().m14374j()) {
            return getScaRank4DB();
        }
        return 0;
    }

    public int getScaRank4DB() {
        List<ScaDetail> list = this.scaDetail;
        if (list != null && !list.isEmpty()) {
            for (ScaDetail scaDetail : this.scaDetail) {
                if (scaDetail != null && scaDetail.getScaRank() != null && "content".equals(scaDetail.getUsage())) {
                    return scaDetail.getScaRank().intValue();
                }
            }
        }
        return 0;
    }

    public int getScaState() {
        if (CloudAlbumSettings.m14363h().m14374j()) {
            return getScaState4DB();
        }
        return 1;
    }

    public int getScaState4DB() {
        List<ScaDetail> list = this.scaDetail;
        if (list != null && !list.isEmpty()) {
            for (ScaDetail scaDetail : this.scaDetail) {
                if (scaDetail != null && scaDetail.getScaState() != null && "content".equals(scaDetail.getUsage())) {
                    return scaDetail.getScaState().intValue();
                }
            }
        }
        return 1;
    }

    public String getSha256() {
        return this.sha256;
    }

    public String getSignedDownloadLink() {
        return this.signedDownloadLink;
    }

    public Long getSize() {
        return this.size;
    }

    public String getSmallThumbnailDownloadLink() {
        return this.smallThumbnailDownloadLink;
    }

    public String getSource() {
        return this.source;
    }

    public Integer getStatus() {
        Integer num = this.status;
        if (num == null) {
            return 0;
        }
        return num;
    }

    public String getThumbFileId() {
        return this.thumbFileId;
    }

    public String getThumbnailDownloadLink() {
        return this.thumbnailDownloadLink;
    }

    public int getUploadState() {
        return this.uploadState;
    }

    public String getUploadType() {
        return this.uploadType;
    }

    public Integer getVersion() {
        return this.version;
    }

    public VideoMetaData getVideoMetaData() {
        return this.videoMetadata;
    }

    public String getVideoThumbId() {
        return this.videoThumbId;
    }

    public int getVideoTimeDuration() {
        return this.videoTimeDuration;
    }

    public void setAlbumId(String str) {
        this.albumId = str;
    }

    public void setAlbumType(int i10) {
        this.albumType = i10;
    }

    public void setAlbumVersion(String str) {
        this.albumVersion = str;
    }

    public void setAppSettings(Map<String, String> map) {
        this.appSettings = map;
    }

    public void setAttachments(List<Attachment> list) {
        this.attachments = list;
    }

    public void setBatchId(String str) {
        this.batchId = str;
    }

    public void setBatchV1Id(long j10) {
        this.batchV1Id = j10;
    }

    public void setBatchV1Time(long j10) {
        this.batchV1Time = j10;
    }

    public void setCategory(String str) {
        this.category = str;
    }

    public void setCipher(Cipher cipher) {
        this.cipher = cipher;
    }

    public void setContentDownloadLink(String str) {
        this.contentDownloadLink = str;
    }

    public void setCreatedTime(C4644l c4644l) {
        this.createdTime = c4644l;
    }

    public Media setCreator(User user) {
        this.creator = user;
        return this;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public void setEditedByMe(Boolean bool) {
        this.editedByMe = bool;
    }

    public void setEditedByMeTime(C4644l c4644l) {
        this.editedByMeTime = c4644l;
    }

    public void setEditedTime(C4644l c4644l) {
        this.editedTime = c4644l;
    }

    public void setFavorite(Boolean bool) {
        this.favorite = bool;
    }

    public void setFileName(String str) {
        this.fileName = str;
    }

    public void setFileSuffix(String str) {
        this.fileSuffix = str;
    }

    public void setFileType(Integer num) {
        this.fileType = num;
    }

    public void setFullFileSuffix(String str) {
        this.fullFileSuffix = str;
    }

    public void setHash(String str) {
        this.hash = str;
    }

    public void setHashId(String str) {
        this.hashId = str;
    }

    public void setHwBurstType(int i10) {
        this.hwBurstType = i10;
    }

    public void setId(String str) {
        this.f12221id = str;
    }

    public void setLastEditor(User user) {
        this.lastEditor = user;
    }

    public void setLcdFileId(String str) {
        this.lcdFileId = str;
    }

    public void setLocalBatchId(long j10) {
        this.localBatchId = j10;
    }

    public void setLocalBigThumbPath(String str) {
        this.localBigThumbPath = str;
    }

    public void setLocalId(long j10) {
        this.localId = j10;
    }

    public void setLocalRealPath(String str) {
        this.localRealPath = str;
    }

    public void setLocalThumbPath(String str) {
        this.localThumbPath = str;
    }

    public Media setMediaOwnerId(String str) {
        this.mediaOwnerId = str;
        return this;
    }

    public void setMimeType(String str) {
        this.mimeType = str;
    }

    public void setOpType(int i10) {
        this.opType = i10;
    }

    public void setOriginalFilename(String str) {
        this.originalFilename = str;
    }

    public void setOwnedByMe(Boolean bool) {
        this.ownedByMe = bool;
    }

    public void setOwner(User user) {
        this.owner = user;
    }

    public void setPictureMetaData(PictureMetaData pictureMetaData) {
        this.pictureMetadata = pictureMetaData;
    }

    public void setProperties(Map<String, String> map) {
        this.properties = map;
    }

    public void setRecycled(Boolean bool) {
        this.recycled = bool;
    }

    public void setRecycledTime(C4644l c4644l) {
        this.recycledTime = c4644l;
    }

    public void setRecyclingUser(User user) {
        this.recyclingUser = user;
    }

    public void setRotation(int i10) {
        this.rotation = i10;
    }

    public void setScaDetail(List<ScaDetail> list) {
        this.scaDetail = list;
    }

    public void setSha256(String str) {
        this.sha256 = str;
    }

    public void setSignedDownloadLink(String str) {
        this.signedDownloadLink = str;
    }

    public void setSize(Long l10) {
        this.size = l10;
    }

    public void setSmallThumbnailDownloadLink(String str) {
        this.smallThumbnailDownloadLink = str;
    }

    public void setSource(String str) {
        this.source = str;
    }

    public void setStatus(Integer num) {
        this.status = num;
    }

    public void setThumbFileId(String str) {
        this.thumbFileId = str;
    }

    public void setThumbnailDownloadLink(String str) {
        this.thumbnailDownloadLink = str;
    }

    public void setUploadState(int i10) {
        this.uploadState = i10;
    }

    public void setUploadType(String str) {
        this.uploadType = str;
    }

    public void setVersion(Integer num) {
        this.version = num;
    }

    public void setVideoMetaData(VideoMetaData videoMetaData) {
        this.videoMetadata = videoMetaData;
    }

    public void setVideoThumbId(String str) {
        this.videoThumbId = str;
    }

    public void setVideoTimeDuration(int i10) {
        this.videoTimeDuration = i10;
    }
}
