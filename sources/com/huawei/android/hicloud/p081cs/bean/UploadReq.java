package com.huawei.android.hicloud.p081cs.bean;

import com.huawei.android.hicloud.connect.progress.ICallback;
import com.huawei.hicloud.base.bean.Md5AndHash;
import java.io.File;
import java.util.Map;
import p704v9.C13387c;

/* loaded from: classes3.dex */
public class UploadReq {
    private Map<String, Object> attribute;
    private C13387c backupStatus;
    private ICallback callback;
    Map<String, String> extraStatKeyValues;
    private File file;
    private int keyType;
    Md5AndHash md5AndHash;
    private String result;
    private String server;
    private String syncPackageName;
    private Thumbnail[] thumbnails;

    public Map<String, Object> getAttribute() {
        return this.attribute;
    }

    public C13387c getBackupStatus() {
        return this.backupStatus;
    }

    public ICallback getCallback() {
        return this.callback;
    }

    public Map<String, String> getExtraStatKeyValues() {
        return this.extraStatKeyValues;
    }

    public File getFile() {
        return this.file;
    }

    public int getKeyType() {
        return this.keyType;
    }

    public Md5AndHash getMd5AndHash() {
        return this.md5AndHash;
    }

    public String getResult() {
        return this.result;
    }

    public String getServer() {
        return this.server;
    }

    public String getSyncPackageName() {
        return this.syncPackageName;
    }

    public Thumbnail[] getThumbnails() {
        Thumbnail[] thumbnailArr = this.thumbnails;
        return thumbnailArr != null ? (Thumbnail[]) thumbnailArr.clone() : new Thumbnail[0];
    }

    public void setAttribute(Map<String, Object> map) {
        this.attribute = map;
    }

    public void setBackupStatus(C13387c c13387c) {
        this.backupStatus = c13387c;
    }

    public void setCallback(ICallback iCallback) {
        this.callback = iCallback;
    }

    public void setExtraStatKeyValues(Map<String, String> map) {
        this.extraStatKeyValues = map;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public void setKeyType(int i10) {
        this.keyType = i10;
    }

    public void setMd5AndHash(Md5AndHash md5AndHash) {
        this.md5AndHash = md5AndHash;
    }

    public void setResult(String str) {
        this.result = str;
    }

    public void setServer(String str) {
        this.server = str;
    }

    public void setSyncPackageName(String str) {
        this.syncPackageName = str;
    }

    public void setThumbnails(Thumbnail[] thumbnailArr) {
        if (thumbnailArr != null) {
            this.thumbnails = (Thumbnail[]) thumbnailArr.clone();
        } else {
            this.thumbnails = null;
        }
    }
}
