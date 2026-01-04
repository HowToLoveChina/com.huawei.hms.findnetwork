package com.huawei.android.hicloud.album.service.hihttp.request.response;

/* loaded from: classes2.dex */
public class LockAndVersionResponse extends BaseResponse {
    private String albumListVersion;
    private String albumVersion;
    private String clearVersion;
    private int expire;
    private long latestVersion;
    private String syncLockToken;
    private String synctoken;
    private boolean synctokenExpired;
    private int interval = -1;
    private int albumLimit = 10;
    private int fileLimit = 50;

    public int getAlbumLimit() {
        return this.albumLimit;
    }

    public String getAlbumListVersion() {
        return this.albumListVersion;
    }

    public String getAlbumVersion() {
        return this.albumVersion;
    }

    public String getClearVersion() {
        return this.clearVersion;
    }

    public int getExpire() {
        return this.expire;
    }

    public int getFileLimit() {
        return this.fileLimit;
    }

    public int getInterval() {
        return this.interval;
    }

    public long getLatestVersion() {
        return this.latestVersion;
    }

    public String getSyncLockToken() {
        return this.syncLockToken;
    }

    public String getSyncToken() {
        return this.synctoken;
    }

    public boolean getSynctokenExpired() {
        return this.synctokenExpired;
    }

    public void setAlbumLimit(int i10) {
        this.albumLimit = i10;
    }

    public void setAlbumListVersion(String str) {
        this.albumListVersion = str;
    }

    public void setAlbumVersion(String str) {
        this.albumVersion = str;
    }

    public void setClearVersion(String str) {
        this.clearVersion = str;
    }

    public void setExpire(int i10) {
        this.expire = i10;
    }

    public void setFileLimit(int i10) {
        this.fileLimit = i10;
    }

    public void setInterval(int i10) {
        this.interval = i10;
    }

    public void setLatestVersion(long j10) {
        this.latestVersion = j10;
    }

    public void setSyncLockToken(String str) {
        this.syncLockToken = str;
    }

    public void setSyncToken(String str) {
        this.synctoken = str;
    }

    public void setSynctokenExpired(boolean z10) {
        this.synctokenExpired = z10;
    }
}
