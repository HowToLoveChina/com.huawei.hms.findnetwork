package com.huawei.cloud.services.drive.model;

import com.huawei.cloud.base.util.C4630c;
import com.huawei.cloud.base.util.C4644l;
import com.huawei.cloud.base.util.InterfaceC4648p;
import java.util.List;
import java.util.Map;
import ni.C11707b;

/* loaded from: classes5.dex */
public class File extends C11707b {

    @InterfaceC4648p
    private Map<String, String> appSettings;

    @InterfaceC4648p
    private Capabilities capabilities;

    @InterfaceC4648p
    private String category;

    @InterfaceC4648p
    private List<String> containers;

    @InterfaceC4648p
    private String contentDownloadLink;

    @InterfaceC4648p
    private ContentExtras contentExtras;

    @InterfaceC4648p
    private String contentVersion;

    @InterfaceC4648p
    private C4644l createdTime;

    @InterfaceC4648p
    private String description;

    @InterfaceC4648p
    private Boolean directlyRecycled;

    @InterfaceC4648p
    private Boolean editedByMe;

    @InterfaceC4648p
    private C4644l editedByMeTime;

    @InterfaceC4648p
    private C4644l editedTime;

    @InterfaceC4648p
    private Boolean existThumbnail;

    @InterfaceC4648p
    private Boolean favorite;

    @InterfaceC4648p
    private String fileName;

    @InterfaceC4648p
    private String fileSuffix;

    @InterfaceC4648p
    private String fullFileSuffix;

    @InterfaceC4648p
    private Boolean hasShared;

    @InterfaceC4648p
    private String iconDownloadLink;

    /* renamed from: id */
    @InterfaceC4648p
    private String f21490id;

    @InterfaceC4648p
    private Boolean isAppAuthorized;

    @InterfaceC4648p
    private User lastEditor;

    @InterfaceC4648p
    private String lastHistoryVersionId;

    @InterfaceC4648p
    private String mimeType;

    @InterfaceC4648p
    private Long occupiedSpace;

    @InterfaceC4648p
    private String onLineViewLink;

    @InterfaceC4648p
    private String originalFilename;

    @InterfaceC4648p
    private Boolean ownedByMe;

    @InterfaceC4648p
    private List<User> owners;

    @InterfaceC4648p
    private List<String> parentFolder;

    @InterfaceC4648p
    private List<String> permissionIds;

    @InterfaceC4648p
    private List<Permission> permissions;

    @InterfaceC4648p
    private PictureMetadata pictureMetadata;

    @InterfaceC4648p
    private Map<String, String> properties;

    @InterfaceC4648p
    private Boolean recycled;

    @InterfaceC4648p
    private C4644l recycledTime;

    @InterfaceC4648p
    private User recyclingUser;

    @InterfaceC4648p
    private String sha256;

    @InterfaceC4648p
    private C4644l sharedWithMeTime;

    @InterfaceC4648p
    private User sharer;

    @InterfaceC4648p
    private String shortLink;

    @InterfaceC4648p
    private String signedDownloadLink;

    @InterfaceC4648p
    private Long size;

    @InterfaceC4648p
    private String smallThumbnailDownloadLink;

    @InterfaceC4648p
    private String thumbnailDownloadLink;

    @InterfaceC4648p
    private Long thumbnailVersion;

    @InterfaceC4648p
    private Long version;

    @InterfaceC4648p
    private VideoMetadata videoMetadata;

    @InterfaceC4648p
    private Boolean writerHasCopyPermission;

    @InterfaceC4648p
    private Boolean writersHasSharePermission;

    public static final class ContentExtras extends C11707b {

        @InterfaceC4648p
        private Thumbnail thumbnail;

        public Thumbnail getThumbnail() {
            return this.thumbnail;
        }

        public ContentExtras setThumbnail(Thumbnail thumbnail) {
            this.thumbnail = thumbnail;
            return this;
        }

        public static final class Thumbnail extends C11707b {

            @InterfaceC4648p
            private String content;

            @InterfaceC4648p
            private String mimeType;

            @InterfaceC4648p
            private Boolean thumbnailPublic;

            public byte[] decodeContent() {
                return C4630c.m28402a(this.content);
            }

            public Thumbnail encodeContent(byte[] bArr) {
                this.content = C4630c.m28403b(bArr);
                return this;
            }

            public String getContent() {
                return this.content;
            }

            public String getMimeType() {
                return this.mimeType;
            }

            public Boolean getThumbnailPublic() {
                return this.thumbnailPublic;
            }

            public Thumbnail setContent(String str) {
                this.content = str;
                return this;
            }

            public Thumbnail setMimeType(String str) {
                this.mimeType = str;
                return this;
            }

            public Thumbnail setThumbnailPublic(Boolean bool) {
                this.thumbnailPublic = bool;
                return this;
            }

            @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n
            public Thumbnail set(String str, Object obj) {
                return (Thumbnail) super.set(str, obj);
            }

            @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n, java.util.AbstractMap
            public Thumbnail clone() {
                return (Thumbnail) super.clone();
            }
        }

        @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n
        public ContentExtras set(String str, Object obj) {
            return (ContentExtras) super.set(str, obj);
        }

        @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n, java.util.AbstractMap
        public ContentExtras clone() {
            return (ContentExtras) super.clone();
        }
    }

    public static final class PictureMetadata extends C11707b {

        @InterfaceC4648p
        private Float aperture;

        @InterfaceC4648p
        private String cameraMake;

        @InterfaceC4648p
        private String cameraModel;

        @InterfaceC4648p
        private String colorSpace;

        @InterfaceC4648p
        private String exifTime;

        @InterfaceC4648p
        private Float exposureBias;

        @InterfaceC4648p
        private String exposureMode;

        @InterfaceC4648p
        private Float exposureTime;

        @InterfaceC4648p
        private Boolean flashUsed;

        @InterfaceC4648p
        private Float focalLength;

        @InterfaceC4648p
        private Integer height;

        @InterfaceC4648p
        private Integer isoSpeed;

        @InterfaceC4648p
        private String lens;

        @InterfaceC4648p
        private Location location;

        @InterfaceC4648p
        private Float maxApertureValue;

        @InterfaceC4648p
        private String meteringMode;

        @InterfaceC4648p
        private Integer rotation;

        @InterfaceC4648p
        private String sensor;

        @InterfaceC4648p
        private Integer subjectDistance;

        @InterfaceC4648p
        private String whiteBalance;

        @InterfaceC4648p
        private Integer width;

        public Float getAperture() {
            return this.aperture;
        }

        public String getCameraMake() {
            return this.cameraMake;
        }

        public String getCameraModel() {
            return this.cameraModel;
        }

        public String getColorSpace() {
            return this.colorSpace;
        }

        public String getExifTime() {
            return this.exifTime;
        }

        public Float getExposureBias() {
            return this.exposureBias;
        }

        public String getExposureMode() {
            return this.exposureMode;
        }

        public Float getExposureTime() {
            return this.exposureTime;
        }

        public Boolean getFlashUsed() {
            return this.flashUsed;
        }

        public Float getFocalLength() {
            return this.focalLength;
        }

        public Integer getHeight() {
            return this.height;
        }

        public Integer getIsoSpeed() {
            return this.isoSpeed;
        }

        public String getLens() {
            return this.lens;
        }

        public Location getLocation() {
            return this.location;
        }

        public Float getMaxApertureValue() {
            return this.maxApertureValue;
        }

        public String getMeteringMode() {
            return this.meteringMode;
        }

        public Integer getRotation() {
            return this.rotation;
        }

        public String getSensor() {
            return this.sensor;
        }

        public Integer getSubjectDistance() {
            return this.subjectDistance;
        }

        public String getWhiteBalance() {
            return this.whiteBalance;
        }

        public Integer getWidth() {
            return this.width;
        }

        public PictureMetadata setAperture(Float f10) {
            this.aperture = f10;
            return this;
        }

        public PictureMetadata setCameraMake(String str) {
            this.cameraMake = str;
            return this;
        }

        public PictureMetadata setCameraModel(String str) {
            this.cameraModel = str;
            return this;
        }

        public PictureMetadata setColorSpace(String str) {
            this.colorSpace = str;
            return this;
        }

        public PictureMetadata setExifTime(String str) {
            this.exifTime = str;
            return this;
        }

        public PictureMetadata setExposureBias(Float f10) {
            this.exposureBias = f10;
            return this;
        }

        public PictureMetadata setExposureMode(String str) {
            this.exposureMode = str;
            return this;
        }

        public PictureMetadata setExposureTime(Float f10) {
            this.exposureTime = f10;
            return this;
        }

        public PictureMetadata setFlashUsed(Boolean bool) {
            this.flashUsed = bool;
            return this;
        }

        public PictureMetadata setFocalLength(Float f10) {
            this.focalLength = f10;
            return this;
        }

        public PictureMetadata setHeight(Integer num) {
            this.height = num;
            return this;
        }

        public PictureMetadata setIsoSpeed(Integer num) {
            this.isoSpeed = num;
            return this;
        }

        public PictureMetadata setLens(String str) {
            this.lens = str;
            return this;
        }

        public PictureMetadata setLocation(Location location) {
            this.location = location;
            return this;
        }

        public PictureMetadata setMaxApertureValue(Float f10) {
            this.maxApertureValue = f10;
            return this;
        }

        public PictureMetadata setMeteringMode(String str) {
            this.meteringMode = str;
            return this;
        }

        public PictureMetadata setRotation(Integer num) {
            this.rotation = num;
            return this;
        }

        public PictureMetadata setSensor(String str) {
            this.sensor = str;
            return this;
        }

        public PictureMetadata setSubjectDistance(Integer num) {
            this.subjectDistance = num;
            return this;
        }

        public PictureMetadata setWhiteBalance(String str) {
            this.whiteBalance = str;
            return this;
        }

        public PictureMetadata setWidth(Integer num) {
            this.width = num;
            return this;
        }

        public static final class Location extends C11707b {

            @InterfaceC4648p
            private Double altitude;

            @InterfaceC4648p
            private Double latitude;

            @InterfaceC4648p
            private Double longitude;

            public Double getAltitude() {
                return this.altitude;
            }

            public Double getLatitude() {
                return this.latitude;
            }

            public Double getLongitude() {
                return this.longitude;
            }

            public Location setAltitude(Double d10) {
                this.altitude = d10;
                return this;
            }

            public Location setLatitude(Double d10) {
                this.latitude = d10;
                return this;
            }

            public Location setLongitude(Double d10) {
                this.longitude = d10;
                return this;
            }

            @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n
            public Location set(String str, Object obj) {
                return (Location) super.set(str, obj);
            }

            @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n, java.util.AbstractMap
            public Location clone() {
                return (Location) super.clone();
            }
        }

        @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n
        public PictureMetadata set(String str, Object obj) {
            return (PictureMetadata) super.set(str, obj);
        }

        @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n, java.util.AbstractMap
        public PictureMetadata clone() {
            return (PictureMetadata) super.clone();
        }
    }

    public Map<String, String> getAppSettings() {
        return this.appSettings;
    }

    public Capabilities getCapabilities() {
        return this.capabilities;
    }

    public String getCategory() {
        return this.category;
    }

    public List<String> getContainers() {
        return this.containers;
    }

    public String getContentDownloadLink() {
        return this.contentDownloadLink;
    }

    public ContentExtras getContentExtras() {
        return this.contentExtras;
    }

    public String getContentVersion() {
        return this.contentVersion;
    }

    public C4644l getCreatedTime() {
        return this.createdTime;
    }

    public String getDescription() {
        return this.description;
    }

    public Boolean getDirectlyRecycled() {
        return this.directlyRecycled;
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

    public Boolean getExistThumbnail() {
        return this.existThumbnail;
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

    public String getFullFileSuffix() {
        return this.fullFileSuffix;
    }

    public Boolean getHasShared() {
        return this.hasShared;
    }

    public String getIconDownloadLink() {
        return this.iconDownloadLink;
    }

    public String getId() {
        return this.f21490id;
    }

    public Boolean getIsAppAuthorized() {
        return this.isAppAuthorized;
    }

    public User getLastEditor() {
        return this.lastEditor;
    }

    public String getLastHistoryVersionId() {
        return this.lastHistoryVersionId;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public Long getOccupiedSpace() {
        return this.occupiedSpace;
    }

    public String getOnLineViewLink() {
        return this.onLineViewLink;
    }

    public String getOriginalFilename() {
        return this.originalFilename;
    }

    public Boolean getOwnedByMe() {
        return this.ownedByMe;
    }

    public List<User> getOwners() {
        return this.owners;
    }

    public List<String> getParentFolder() {
        return this.parentFolder;
    }

    public List<String> getPermissionIds() {
        return this.permissionIds;
    }

    public List<Permission> getPermissions() {
        return this.permissions;
    }

    public PictureMetadata getPictureMetadata() {
        return this.pictureMetadata;
    }

    public Map<String, String> getProperties() {
        return this.properties;
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

    public String getSha256() {
        return this.sha256;
    }

    public C4644l getSharedWithMeTime() {
        return this.sharedWithMeTime;
    }

    public User getSharer() {
        return this.sharer;
    }

    public String getShortLink() {
        return this.shortLink;
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

    public String getThumbnailDownloadLink() {
        return this.thumbnailDownloadLink;
    }

    public Long getThumbnailVersion() {
        return this.thumbnailVersion;
    }

    public Long getVersion() {
        return this.version;
    }

    public VideoMetadata getVideoMetadata() {
        return this.videoMetadata;
    }

    public Boolean getWriterHasCopyPermission() {
        return this.writerHasCopyPermission;
    }

    public Boolean getWritersHasSharePermission() {
        return this.writersHasSharePermission;
    }

    public File setAppSettings(Map<String, String> map) {
        this.appSettings = map;
        return this;
    }

    public File setCapabilities(Capabilities capabilities) {
        this.capabilities = capabilities;
        return this;
    }

    public File setCategory(String str) {
        this.category = str;
        return this;
    }

    public File setContainers(List<String> list) {
        this.containers = list;
        return this;
    }

    public File setContentDownloadLink(String str) {
        this.contentDownloadLink = str;
        return this;
    }

    public File setContentExtras(ContentExtras contentExtras) {
        this.contentExtras = contentExtras;
        return this;
    }

    public File setContentVersion(String str) {
        this.contentVersion = str;
        return this;
    }

    public File setCreatedTime(C4644l c4644l) {
        this.createdTime = c4644l;
        return this;
    }

    public File setDescription(String str) {
        this.description = str;
        return this;
    }

    public File setDirectlyRecycled(Boolean bool) {
        this.directlyRecycled = bool;
        return this;
    }

    public File setEditedByMe(Boolean bool) {
        this.editedByMe = bool;
        return this;
    }

    public File setEditedByMeTime(C4644l c4644l) {
        this.editedByMeTime = c4644l;
        return this;
    }

    public File setEditedTime(C4644l c4644l) {
        this.editedTime = c4644l;
        return this;
    }

    public File setExistThumbnail(Boolean bool) {
        this.existThumbnail = bool;
        return this;
    }

    public File setFavorite(Boolean bool) {
        this.favorite = bool;
        return this;
    }

    public File setFileName(String str) {
        this.fileName = str;
        return this;
    }

    public File setFileSuffix(String str) {
        this.fileSuffix = str;
        return this;
    }

    public File setFullFileSuffix(String str) {
        this.fullFileSuffix = str;
        return this;
    }

    public File setHasShared(Boolean bool) {
        this.hasShared = bool;
        return this;
    }

    public File setIconDownloadLink(String str) {
        this.iconDownloadLink = str;
        return this;
    }

    public File setId(String str) {
        this.f21490id = str;
        return this;
    }

    public File setIsAppAuthorized(Boolean bool) {
        this.isAppAuthorized = bool;
        return this;
    }

    public File setLastEditor(User user) {
        this.lastEditor = user;
        return this;
    }

    public File setLastHistoryVersionId(String str) {
        this.lastHistoryVersionId = str;
        return this;
    }

    public File setMimeType(String str) {
        this.mimeType = str;
        return this;
    }

    public File setOccupiedSpace(Long l10) {
        this.occupiedSpace = l10;
        return this;
    }

    public File setOnLineViewLink(String str) {
        this.onLineViewLink = str;
        return this;
    }

    public File setOriginalFilename(String str) {
        this.originalFilename = str;
        return this;
    }

    public File setOwnedByMe(Boolean bool) {
        this.ownedByMe = bool;
        return this;
    }

    public File setOwners(List<User> list) {
        this.owners = list;
        return this;
    }

    public File setParentFolder(List<String> list) {
        this.parentFolder = list;
        return this;
    }

    public File setPermissionIds(List<String> list) {
        this.permissionIds = list;
        return this;
    }

    public File setPermissions(List<Permission> list) {
        this.permissions = list;
        return this;
    }

    public File setPictureMetadata(PictureMetadata pictureMetadata) {
        this.pictureMetadata = pictureMetadata;
        return this;
    }

    public File setProperties(Map<String, String> map) {
        this.properties = map;
        return this;
    }

    public File setRecycled(Boolean bool) {
        this.recycled = bool;
        return this;
    }

    public File setRecycledTime(C4644l c4644l) {
        this.recycledTime = c4644l;
        return this;
    }

    public File setRecyclingUser(User user) {
        this.recyclingUser = user;
        return this;
    }

    public File setSha256(String str) {
        this.sha256 = str;
        return this;
    }

    public File setSharedWithMeTime(C4644l c4644l) {
        this.sharedWithMeTime = c4644l;
        return this;
    }

    public File setSharer(User user) {
        this.sharer = user;
        return this;
    }

    public File setShortLink(String str) {
        this.shortLink = str;
        return this;
    }

    public File setSignedDownloadLink(String str) {
        this.signedDownloadLink = str;
        return this;
    }

    public File setSize(Long l10) {
        this.size = l10;
        return this;
    }

    public File setSmallThumbnailDownloadLink(String str) {
        this.smallThumbnailDownloadLink = str;
        return this;
    }

    public File setThumbnailDownloadLink(String str) {
        this.thumbnailDownloadLink = str;
        return this;
    }

    public File setThumbnailVersion(Long l10) {
        this.thumbnailVersion = l10;
        return this;
    }

    public File setVersion(Long l10) {
        this.version = l10;
        return this;
    }

    public File setVideoMetadata(VideoMetadata videoMetadata) {
        this.videoMetadata = videoMetadata;
        return this;
    }

    public File setWriterHasCopyPermission(Boolean bool) {
        this.writerHasCopyPermission = bool;
        return this;
    }

    public File setWritersHasSharePermission(Boolean bool) {
        this.writersHasSharePermission = bool;
        return this;
    }

    public static final class Capabilities extends C11707b {

        @InterfaceC4648p
        private Boolean addChildNodePermission;

        @InterfaceC4648p
        private Boolean commentPermission;

        @InterfaceC4648p
        private Boolean copyPermission;

        @InterfaceC4648p
        private Boolean deleteChildNodePermission;

        @InterfaceC4648p
        private Boolean deletePermission;

        @InterfaceC4648p
        private Boolean downloadPermission;

        @InterfaceC4648p
        private Boolean editContentPermission;

        @InterfaceC4648p
        private Boolean editPermission;

        @InterfaceC4648p
        private Boolean listChildNodePermission;

        @InterfaceC4648p
        private Boolean readHistoryVersionPermission;

        @InterfaceC4648p
        private Boolean recycleChildNodePermission;

        @InterfaceC4648p
        private Boolean recyclePermission;

        @InterfaceC4648p
        private Boolean removeChildNodePermission;

        @InterfaceC4648p
        private Boolean renameFilePermission;

        @InterfaceC4648p
        private Boolean shareFilePermission;

        @InterfaceC4648p
        private Boolean unrecyclePermission;

        @InterfaceC4648p
        private Boolean writerHasCopyPermission;

        public Boolean getAddChildNodePermission() {
            return this.addChildNodePermission;
        }

        public Boolean getCommentPermission() {
            return this.commentPermission;
        }

        public Boolean getCopyPermission() {
            return this.copyPermission;
        }

        public Boolean getDeleteChildNodePermission() {
            return this.deleteChildNodePermission;
        }

        public Boolean getDeletePermission() {
            return this.deletePermission;
        }

        public Boolean getDownloadPermission() {
            return this.downloadPermission;
        }

        public Boolean getEditContentPermission() {
            return this.editContentPermission;
        }

        public Boolean getEditPermission() {
            return this.editPermission;
        }

        public Boolean getListChildNodePermission() {
            return this.listChildNodePermission;
        }

        public Boolean getReadHistoryVersionPermission() {
            return this.readHistoryVersionPermission;
        }

        public Boolean getRecycleChildNodePermission() {
            return this.recycleChildNodePermission;
        }

        public Boolean getRecyclePermission() {
            return this.recyclePermission;
        }

        public Boolean getRemoveChildNodePermission() {
            return this.removeChildNodePermission;
        }

        public Boolean getRenameFilePermission() {
            return this.renameFilePermission;
        }

        public Boolean getShareFilePermission() {
            return this.shareFilePermission;
        }

        public Boolean getUnrecyclePermission() {
            return this.unrecyclePermission;
        }

        public Boolean getWriterHasCopyPermission() {
            return this.writerHasCopyPermission;
        }

        public Capabilities setAddChildNodePermission(Boolean bool) {
            this.addChildNodePermission = bool;
            return this;
        }

        public Capabilities setCommentPermission(Boolean bool) {
            this.commentPermission = bool;
            return this;
        }

        public Capabilities setCopyPermission(Boolean bool) {
            this.copyPermission = bool;
            return this;
        }

        public Capabilities setDeleteChildNodePermission(Boolean bool) {
            this.deleteChildNodePermission = bool;
            return this;
        }

        public Capabilities setDeletePermission(Boolean bool) {
            this.deletePermission = bool;
            return this;
        }

        public Capabilities setDownloadPermission(Boolean bool) {
            this.downloadPermission = bool;
            return this;
        }

        public Capabilities setEditContentPermission(Boolean bool) {
            this.editContentPermission = bool;
            return this;
        }

        public Capabilities setEditPermission(Boolean bool) {
            this.editPermission = bool;
            return this;
        }

        public Capabilities setListChildNodePermission(Boolean bool) {
            this.listChildNodePermission = bool;
            return this;
        }

        public Capabilities setReadHistoryVersionPermission(Boolean bool) {
            this.readHistoryVersionPermission = bool;
            return this;
        }

        public Capabilities setRecycleChildNodePermission(Boolean bool) {
            this.recycleChildNodePermission = bool;
            return this;
        }

        public Capabilities setRecyclePermission(Boolean bool) {
            this.recyclePermission = bool;
            return this;
        }

        public Capabilities setRemoveChildNodePermission(Boolean bool) {
            this.removeChildNodePermission = bool;
            return this;
        }

        public Capabilities setRenameFilePermission(Boolean bool) {
            this.renameFilePermission = bool;
            return this;
        }

        public Capabilities setShareFilePermission(Boolean bool) {
            this.shareFilePermission = bool;
            return this;
        }

        public Capabilities setUnrecyclePermission(Boolean bool) {
            this.unrecyclePermission = bool;
            return this;
        }

        public Capabilities setWriterHasCopyPermission(Boolean bool) {
            this.writerHasCopyPermission = bool;
            return this;
        }

        @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n
        public Capabilities set(String str, Object obj) {
            return (Capabilities) super.set(str, obj);
        }

        @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n, java.util.AbstractMap
        public Capabilities clone() {
            return (Capabilities) super.clone();
        }
    }

    public static final class VideoMetadata extends C11707b {

        @InterfaceC4648p
        private Long durationTime;

        @InterfaceC4648p
        private Integer height;

        @InterfaceC4648p
        private Integer width;

        public Long getDurationTime() {
            return this.durationTime;
        }

        public Integer getHeight() {
            return this.height;
        }

        public Integer getWidth() {
            return this.width;
        }

        public VideoMetadata setDurationTime(Long l10) {
            this.durationTime = l10;
            return this;
        }

        public VideoMetadata setHeight(Integer num) {
            this.height = num;
            return this;
        }

        public VideoMetadata setWidth(Integer num) {
            this.width = num;
            return this;
        }

        @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n
        public VideoMetadata set(String str, Object obj) {
            return (VideoMetadata) super.set(str, obj);
        }

        @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n, java.util.AbstractMap
        public VideoMetadata clone() {
            return (VideoMetadata) super.clone();
        }
    }

    @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n
    public File set(String str, Object obj) {
        return (File) super.set(str, obj);
    }

    @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n, java.util.AbstractMap
    public File clone() {
        return (File) super.clone();
    }
}
