package com.huawei.hicloud.cloudbackup.p104v3.server.model;

import com.huawei.cloud.base.util.InterfaceC4648p;
import ni.C11707b;

/* loaded from: classes6.dex */
public class PushCmd extends C11707b {

    @InterfaceC4648p
    private String body;

    @InterfaceC4648p
    private String command;

    @InterfaceC4648p
    private String source;

    @InterfaceC4648p
    private String userId;

    public static class Delete extends C11707b {

        @InterfaceC4648p
        private Long delSpaceSize;

        @InterfaceC4648p
        private String deviceIdSha256;

        @InterfaceC4648p
        private String originDeviceIdSha256;

        @InterfaceC4648p
        private Integer sceneId;

        @InterfaceC4648p
        private long serverExeTime;

        public Long getDelSpaceSize() {
            return this.delSpaceSize;
        }

        public String getDeviceIdSha256() {
            return this.deviceIdSha256;
        }

        public String getOriginDeviceIdSha256() {
            return this.originDeviceIdSha256;
        }

        public Integer getSceneId() {
            return this.sceneId;
        }

        public long getServerExeTime() {
            return this.serverExeTime;
        }

        public Delete setDelSpaceSize(Long l10) {
            this.delSpaceSize = l10;
            return this;
        }

        public Delete setDeviceIdSha256(String str) {
            this.deviceIdSha256 = str;
            return this;
        }

        public void setOriginDeviceIdSha256(String str) {
            this.originDeviceIdSha256 = str;
        }

        public Delete setSceneId(Integer num) {
            this.sceneId = num;
            return this;
        }

        public void setServerExeTime(long j10) {
            this.serverExeTime = j10;
        }
    }

    public static class Grade extends C11707b {

        @InterfaceC4648p
        private String grade;

        public String getGrade() {
            return this.grade;
        }

        public void setGrade(String str) {
            this.grade = str;
        }
    }

    public static class SwitchChange extends C11707b {

        @InterfaceC4648p
        private String disableDeviceIdSha256;

        public String getDisableDeviceIdSha256() {
            return this.disableDeviceIdSha256;
        }

        public SwitchChange setDisableDeviceIdSha256(String str) {
            this.disableDeviceIdSha256 = str;
            return this;
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

    public PushCmd setBody(String str) {
        this.body = str;
        return this;
    }

    public PushCmd setCommand(String str) {
        this.command = str;
        return this;
    }

    public PushCmd setSource(String str) {
        this.source = str;
        return this;
    }

    public PushCmd setUserId(String str) {
        this.userId = str;
        return this;
    }
}
