package com.huawei.hicloud.notification.p106db.bean;

import com.google.gson.annotations.SerializedName;
import com.huawei.android.backup.service.logic.C2126b;
import com.huawei.hicloud.notification.manager.HicloudH5ConfigManager;

/* loaded from: classes6.dex */
public class NotifyActivityEntry {

    @SerializedName("goto")
    private EntryGoto entryGoto;

    @SerializedName("picture")
    private EntryPicture picture;

    @SerializedName("picturePad")
    private EntryPicture picturePad;

    public static class EntryGoto {

        @SerializedName("type")
        private String type;

        @SerializedName(C2126b.MODULE_INFO_URI)
        private String uri;

        public String getType() {
            return this.type;
        }

        public String getUri() {
            return this.uri;
        }

        public void setType(String str) {
            this.type = str;
        }

        public void setUri(String str) {
            this.uri = str;
        }
    }

    public static class EntryPicture {

        @SerializedName(HicloudH5ConfigManager.KEY_HASH)
        private String hash;

        @SerializedName("resolution")
        private String resolution;

        @SerializedName("url")
        private String url;

        public String getHash() {
            return this.hash;
        }

        public String getResolution() {
            return this.resolution;
        }

        public String getUrl() {
            return this.url;
        }

        public void setHash(String str) {
            this.hash = str;
        }

        public void setResolution(String str) {
            this.resolution = str;
        }

        public void setUrl(String str) {
            this.url = str;
        }
    }

    public EntryGoto getEntryGoto() {
        return this.entryGoto;
    }

    public EntryPicture getPicture() {
        return this.picture;
    }

    public EntryPicture getPicturePad() {
        return this.picturePad;
    }

    public void setEntryGoto(EntryGoto entryGoto) {
        this.entryGoto = entryGoto;
    }

    public void setPicture(EntryPicture entryPicture) {
        this.picture = entryPicture;
    }

    public void setPicturePad(EntryPicture entryPicture) {
        this.picturePad = entryPicture;
    }
}
