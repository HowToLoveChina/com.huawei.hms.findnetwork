package com.huawei.android.hicloud.drive.cloudphoto.model;

import com.huawei.cloud.base.util.InterfaceC4648p;
import ni.C11707b;

/* loaded from: classes3.dex */
public class PushMessage extends C11707b {

    @InterfaceC4648p
    private String body;

    @InterfaceC4648p
    private String command;

    @InterfaceC4648p
    private String source;

    @InterfaceC4648p
    private String userId;

    public static class ApplicantInfo extends C11707b {
        public static final int TYPE_APPLICANT = 1;

        @InterfaceC4648p
        private String albumName;

        @InterfaceC4648p
        private String applicantId;

        @InterfaceC4648p
        private String displayName;

        @InterfaceC4648p
        private String kinship;

        @InterfaceC4648p
        private int type;

        public String getAlbumName() {
            return this.albumName;
        }

        public String getApplicantId() {
            return this.applicantId;
        }

        public String getDisplayName() {
            return this.displayName;
        }

        public String getKinship() {
            return this.kinship;
        }

        public int getType() {
            return this.type;
        }

        public void setAlbumName(String str) {
            this.albumName = str;
        }

        public void setApplicantId(String str) {
            this.applicantId = str;
        }

        public void setDisplayName(String str) {
            this.displayName = str;
        }

        public void setKinship(String str) {
            this.kinship = str;
        }

        public void setType(int i10) {
            this.type = i10;
        }
    }

    public String getBody() {
        return this.body;
    }

    public String getCommand() {
        return this.command;
    }

    public String getSource() {
        return this.source;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setBody(String str) {
        this.body = str;
    }

    public void setCommand(String str) {
        this.command = str;
    }

    public void setSource(String str) {
        this.source = str;
    }

    public void setUserId(String str) {
        this.userId = str;
    }
}
