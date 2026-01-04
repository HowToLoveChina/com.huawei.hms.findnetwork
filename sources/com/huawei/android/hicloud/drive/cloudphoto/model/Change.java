package com.huawei.android.hicloud.drive.cloudphoto.model;

import com.huawei.cloud.base.util.C4644l;
import com.huawei.cloud.base.util.InterfaceC4648p;
import ni.C11707b;

/* loaded from: classes3.dex */
public final class Change extends C11707b {

    @InterfaceC4648p
    private Album album;

    @InterfaceC4648p
    private String albumId;

    @InterfaceC4648p
    private String albumOwnerId;

    @InterfaceC4648p
    private String category;

    @InterfaceC4648p
    private String changeType;

    @InterfaceC4648p
    private Boolean deleted;

    @InterfaceC4648p
    private String device;

    @InterfaceC4648p
    private Media media;

    @InterfaceC4648p
    private String mediaHashId;

    @InterfaceC4648p
    private String mediaId;

    @InterfaceC4648p
    private String mediaOwnerId;

    @InterfaceC4648p
    private C4644l time;

    public Album getAlbum() {
        return this.album;
    }

    public String getAlbumId() {
        return this.albumId;
    }

    public String getAlbumOwnerId() {
        return this.albumOwnerId;
    }

    public String getCategory() {
        return this.category;
    }

    public String getChangeType() {
        return this.changeType;
    }

    public Boolean getDeleted() {
        return this.deleted;
    }

    public String getDevice() {
        return this.device;
    }

    public Media getMedia() {
        return this.media;
    }

    public String getMediaHashId() {
        return this.mediaHashId;
    }

    public String getMediaId() {
        return this.mediaId;
    }

    public String getMediaOwnerId() {
        return this.mediaOwnerId;
    }

    public C4644l getTime() {
        return this.time;
    }

    public Change setAlbum(Album album) {
        this.album = album;
        return this;
    }

    public Change setAlbumId(String str) {
        this.albumId = str;
        return this;
    }

    public Change setAlbumOwnerId(String str) {
        this.albumOwnerId = str;
        return this;
    }

    public Change setCategory(String str) {
        this.category = str;
        return this;
    }

    public Change setChangeType(String str) {
        this.changeType = str;
        return this;
    }

    public Change setDeleted(Boolean bool) {
        this.deleted = bool;
        return this;
    }

    public Change setDevice(String str) {
        this.device = str;
        return this;
    }

    public Change setMedia(Media media) {
        this.media = media;
        return this;
    }

    public Change setMediaHashId(String str) {
        this.mediaHashId = str;
        return this;
    }

    public Change setMediaId(String str) {
        this.mediaId = str;
        return this;
    }

    public Change setMediaOwnerId(String str) {
        this.mediaOwnerId = str;
        return this;
    }

    public Change setTime(C4644l c4644l) {
        this.time = c4644l;
        return this;
    }

    @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n
    public Change set(String str, Object obj) {
        return (Change) super.set(str, obj);
    }
}
