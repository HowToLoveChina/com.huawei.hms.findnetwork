package com.huawei.android.hicloud.drive.cloudphoto.model;

import com.huawei.cloud.base.util.C4644l;
import com.huawei.cloud.base.util.InterfaceC4648p;
import com.huawei.hicloud.base.drive.user.model.User;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import ni.C11707b;

/* loaded from: classes3.dex */
public class Album extends C11707b {
    private static final String KEY_HIDE = "hide";
    public static final Integer PRIVILEGE_READER = 6;
    public static final Integer PRIVILEGE_WRITER = 4;
    private static final String VALUE_HIDE = "1";
    private static final String VALUE_NOT_HIDE = "0";

    @InterfaceC4648p
    private String accountType;

    @InterfaceC4648p
    private String albumName;

    @InterfaceC4648p
    private String albumOwnerId;

    @InterfaceC4648p
    private String albumVersion;

    @InterfaceC4648p
    private Map<String, String> appSettings;

    @InterfaceC4648p
    private List<Attachment> attachments;

    @InterfaceC4648p
    private BabyInfo babyInfo;

    @InterfaceC4648p
    private String backgroundImage;

    @InterfaceC4648p
    private String category;

    @InterfaceC4648p
    private String coverImage;

    @InterfaceC4648p
    private C4644l createdTime;

    @InterfaceC4648p
    private String description;

    @InterfaceC4648p
    private Boolean editedByMe;

    @InterfaceC4648p
    private C4644l editedByMeTime;

    @InterfaceC4648p
    private C4644l editedTime;

    @InterfaceC4648p
    private Boolean favorite;

    @InterfaceC4648p
    private Boolean hasShared;

    /* renamed from: id */
    @InterfaceC4648p
    private String f12216id;

    @InterfaceC4648p
    private String kinship;

    @InterfaceC4648p
    private User lastEditor;

    @InterfaceC4648p
    private String localPath;

    @InterfaceC4648p
    private Integer mediaCount;

    @InterfaceC4648p
    private Long mediaUsedSpace;

    @InterfaceC4648p
    private Boolean onlyFrdCanBeShared;

    @InterfaceC4648p
    private Boolean ownedByMe;

    @InterfaceC4648p
    private User owner;

    @InterfaceC4648p
    private List<Permission> permissions;

    @InterfaceC4648p
    private Integer privilege;

    @InterfaceC4648p
    private Map<String, String> properties;

    @InterfaceC4648p
    private Boolean recycled;

    @InterfaceC4648p
    private User recyclingUser;

    @InterfaceC4648p
    private String resource;

    @InterfaceC4648p
    private Integer shareType;

    @InterfaceC4648p
    private C4644l sharedWithMeTime;

    @InterfaceC4648p
    private User sharer;

    @InterfaceC4648p
    private String shortLink;

    @InterfaceC4648p
    private String source;

    @InterfaceC4648p
    private Integer type;

    @InterfaceC4648p
    private String userAccount;

    @InterfaceC4648p
    private Integer version;
    private int opType = 0;
    private boolean defaultAlbum = false;
    private boolean topAlbum = false;
    private String nextCursor = "";
    private String albumOwnerName = "";
    private int picCount = 0;
    private int videoCount = 0;
    private long flversion = 0;
    private File headPic = null;
    private long fileUpdateTime = 0;

    public String getAccountType() {
        return this.accountType;
    }

    public String getAlbumName() {
        return this.albumName;
    }

    public String getAlbumOwnerId() {
        return this.albumOwnerId;
    }

    public String getAlbumOwnerName() {
        return this.albumOwnerName;
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

    public BabyInfo getBabyInfo() {
        return this.babyInfo;
    }

    public String getBackgroundImage() {
        return this.backgroundImage;
    }

    public String getCategory() {
        return this.category;
    }

    public String getCoverImage() {
        return this.coverImage;
    }

    public C4644l getCreatedTime() {
        return this.createdTime;
    }

    public String getDescription() {
        return this.description;
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

    public long getFileUpdateTime() {
        return this.fileUpdateTime;
    }

    public long getFlversion() {
        return this.flversion;
    }

    public Boolean getHasShared() {
        return this.hasShared;
    }

    public File getHeadPic() {
        return this.headPic;
    }

    public String getId() {
        return this.f12216id;
    }

    public String getKinship() {
        return this.kinship;
    }

    public User getLastEditor() {
        return this.lastEditor;
    }

    public String getLocalPath() {
        return this.localPath;
    }

    public Integer getMediaCount() {
        Integer num = this.mediaCount;
        if (num == null) {
            return 0;
        }
        return num;
    }

    public Long getMediaUsedSpace() {
        return this.mediaUsedSpace;
    }

    public String getNextCursor() {
        return this.nextCursor;
    }

    public Boolean getOnlyFrdCanBeShared() {
        return this.onlyFrdCanBeShared;
    }

    public int getOpType() {
        return this.opType;
    }

    public Boolean getOwnedByMe() {
        return this.ownedByMe;
    }

    public User getOwner() {
        return this.owner;
    }

    public List<Permission> getPermissions() {
        return this.permissions;
    }

    public int getPicCount() {
        return this.picCount;
    }

    public Integer getPrivilege() {
        Integer num = this.privilege;
        return (num != null && num.intValue() == PRIVILEGE_WRITER.intValue()) ? 0 : 1;
    }

    public Map<String, String> getProperties() {
        Map<String, String> map = this.properties;
        return map == null ? new HashMap() : map;
    }

    public Boolean getRecycled() {
        return this.recycled;
    }

    public User getRecyclingUser() {
        return this.recyclingUser;
    }

    public String getResource() {
        return this.resource;
    }

    public Integer getShareType() {
        return this.shareType;
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

    public String getSource() {
        return this.source;
    }

    public Integer getType() {
        return this.type;
    }

    public String getUserAccount() {
        return this.userAccount;
    }

    public Integer getVersion() {
        return this.version;
    }

    public int getVideoCount() {
        return this.videoCount;
    }

    public boolean isDefaultAlbum() {
        return this.defaultAlbum;
    }

    public boolean isHide() {
        Map<String, String> properties = getProperties();
        return !properties.isEmpty() && properties.containsKey(KEY_HIDE) && "1".equals(properties.get(KEY_HIDE));
    }

    public boolean isTopAlbum() {
        return this.topAlbum;
    }

    public Album setAccountType(String str) {
        this.accountType = str;
        return this;
    }

    public Album setAlbumName(String str) {
        this.albumName = str;
        return this;
    }

    public Album setAlbumOwnerId(String str) {
        this.albumOwnerId = str;
        return this;
    }

    public void setAlbumOwnerName(String str) {
        this.albumOwnerName = str;
    }

    public Album setAlbumVersion(String str) {
        this.albumVersion = str;
        return this;
    }

    public Album setAppSettings(Map<String, String> map) {
        this.appSettings = map;
        return this;
    }

    public Album setAttachments(List<Attachment> list) {
        this.attachments = list;
        return this;
    }

    public Album setBabyInfo(BabyInfo babyInfo) {
        this.babyInfo = babyInfo;
        return this;
    }

    public Album setBackgroundImage(String str) {
        this.backgroundImage = str;
        return this;
    }

    public Album setCategory(String str) {
        this.category = str;
        return this;
    }

    public Album setCoverImage(String str) {
        this.coverImage = str;
        return this;
    }

    public Album setCreatedTime(C4644l c4644l) {
        this.createdTime = c4644l;
        return this;
    }

    public void setDefaultAlbum(boolean z10) {
        this.defaultAlbum = z10;
    }

    public Album setDescription(String str) {
        this.description = str;
        return this;
    }

    public Album setEditedByMe(Boolean bool) {
        this.editedByMe = bool;
        return this;
    }

    public Album setEditedByMeTime(C4644l c4644l) {
        this.editedByMeTime = c4644l;
        return this;
    }

    public Album setEditedTime(C4644l c4644l) {
        this.editedTime = c4644l;
        return this;
    }

    public Album setFavorite(Boolean bool) {
        this.favorite = bool;
        return this;
    }

    public void setFileUpdateTime(long j10) {
        this.fileUpdateTime = j10;
    }

    public void setFlversion(long j10) {
        this.flversion = j10;
    }

    public Album setHasShared(Boolean bool) {
        this.hasShared = bool;
        return this;
    }

    public void setHeadPicPath(File file) {
        this.headPic = file;
    }

    public void setHide(boolean z10) {
        getProperties().put(KEY_HIDE, z10 ? "1" : "0");
    }

    public Album setId(String str) {
        this.f12216id = str;
        return this;
    }

    public Album setKinship(String str) {
        this.kinship = str;
        return this;
    }

    public Album setLastEditor(User user) {
        this.lastEditor = user;
        return this;
    }

    public Album setLocalPath(String str) {
        this.localPath = str;
        return this;
    }

    public Album setMediaCount(Integer num) {
        this.mediaCount = num;
        return this;
    }

    public Album setMediaUsedSpace(Long l10) {
        this.mediaUsedSpace = l10;
        return this;
    }

    public void setNextCursor(String str) {
        this.nextCursor = str;
    }

    public Album setOnlyFrdCanBeShared(Boolean bool) {
        this.onlyFrdCanBeShared = bool;
        return this;
    }

    public void setOpType(int i10) {
        this.opType = i10;
    }

    public Album setOwnedByMe(Boolean bool) {
        this.ownedByMe = bool;
        return this;
    }

    public Album setOwner(User user) {
        this.owner = user;
        return this;
    }

    public Album setPermissions(List<Permission> list) {
        this.permissions = list;
        return this;
    }

    public void setPicCount(int i10) {
        this.picCount = i10;
    }

    public Album setPrivilege(Integer num) {
        if (num.intValue() == 1) {
            this.privilege = PRIVILEGE_READER;
        } else {
            this.privilege = PRIVILEGE_WRITER;
        }
        return this;
    }

    public Album setProperties(Map<String, String> map) {
        this.properties = map;
        return this;
    }

    public Album setRecycled(Boolean bool) {
        this.recycled = bool;
        return this;
    }

    public Album setRecyclingUser(User user) {
        this.recyclingUser = user;
        return this;
    }

    public Album setResource(String str) {
        this.resource = str;
        return this;
    }

    public Album setShareType(Integer num) {
        this.shareType = num;
        return this;
    }

    public Album setSharedWithMeTime(C4644l c4644l) {
        this.sharedWithMeTime = c4644l;
        return this;
    }

    public Album setSharer(User user) {
        this.sharer = user;
        return this;
    }

    public Album setShortLink(String str) {
        this.shortLink = str;
        return this;
    }

    public Album setSource(String str) {
        this.source = str;
        return this;
    }

    public void setTopAlbum(boolean z10) {
        this.topAlbum = z10;
    }

    public Album setType(Integer num) {
        this.type = num;
        return this;
    }

    public Album setUserAccount(String str) {
        this.userAccount = str;
        return this;
    }

    public Album setVersion(Integer num) {
        this.version = num;
        return this;
    }

    public void setVideoCount(int i10) {
        this.videoCount = i10;
    }

    @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n
    public Album set(String str, Object obj) {
        return (Album) super.set(str, obj);
    }
}
