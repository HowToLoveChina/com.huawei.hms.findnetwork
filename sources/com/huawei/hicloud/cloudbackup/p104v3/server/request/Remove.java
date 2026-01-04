package com.huawei.hicloud.cloudbackup.p104v3.server.request;

import com.huawei.android.hicloud.drive.clouddisk.expand.RequestMethod;
import com.huawei.cloud.base.util.InterfaceC4648p;
import com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request;
import com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Server;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.Remove;
import java.io.IOException;
import ni.C11707b;

/* loaded from: classes6.dex */
public class Remove {
    private CloudBackupV3Server client;

    public static class DeleteSwitch {
        private CloudBackupV3Server client;

        public static class Get extends CloudBackupV3Request<Remove.QuerySwitch> {
            private static final String REST_PATH = "remove/switch";

            public Get(CloudBackupV3Server cloudBackupV3Server) throws IOException {
                super(cloudBackupV3Server, "GET", REST_PATH, null, Remove.QuerySwitch.class);
            }
        }

        public static class Update extends CloudBackupV3Request<Void> {
            private static final String REST_PATH = "remove/switch";

            public Update(CloudBackupV3Server cloudBackupV3Server, C11707b c11707b) throws IOException {
                super(cloudBackupV3Server, RequestMethod.PATCH, REST_PATH, c11707b, Void.class);
            }
        }

        public DeleteSwitch(CloudBackupV3Server cloudBackupV3Server) {
            this.client = cloudBackupV3Server;
        }

        public Get get() throws IOException {
            return new Get(this.client);
        }

        public Update update(C11707b c11707b) throws IOException {
            return new Update(this.client, c11707b);
        }
    }

    public static class Device {
        private CloudBackupV3Server client;

        public static class Apps {
            private CloudBackupV3Server client;

            public static class Delete extends CloudBackupV3Request<Void> {
                private static final String REST_PATH = "remove/device/{backupDeviceId}/apps";

                @InterfaceC4648p
                private String backupDeviceId;

                public Delete(CloudBackupV3Server cloudBackupV3Server) throws IOException {
                    super(cloudBackupV3Server, "DELETE", REST_PATH, null, Void.class);
                }

                public String getBackupDeviceId() {
                    return this.backupDeviceId;
                }

                /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Remove$Device$Apps$Delete] */
                public Delete setAppNameList(String str) {
                    return setHeader("x-hw-appnamelist", (Object) str);
                }

                public Delete setBackupDeviceId(String str) {
                    this.backupDeviceId = str;
                    return this;
                }

                @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
                public CloudBackupV3Request<Void> setFields(String str) {
                    return (Delete) super.setFields(str);
                }

                @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
                public CloudBackupV3Request<Void> setHeader(String str, Object obj) {
                    return (Delete) super.setHeader(str, obj);
                }

                @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
                public CloudBackupV3Request<Void> setTraceId(String str) {
                    return (Delete) super.setTraceId(str);
                }

                @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request, p614ri.AbstractC12513b, p579qi.AbstractC12361b, com.huawei.cloud.base.util.C4646n
                public Delete set(String str, Object obj) {
                    return (Delete) super.set(str, obj);
                }
            }

            public Apps(CloudBackupV3Server cloudBackupV3Server) {
                this.client = cloudBackupV3Server;
            }

            public Delete delete() throws IOException {
                return new Delete(this.client);
            }
        }

        public static class Bak {
            private CloudBackupV3Server client;

            public static class Delete extends CloudBackupV3Request<Void> {
                private static final String REST_PATH = "remove/device/{backupDeviceId}/bak/{bakId}";

                @InterfaceC4648p
                private String backupDeviceId;

                @InterfaceC4648p
                private String bakId;

                public Delete(CloudBackupV3Server cloudBackupV3Server) throws IOException {
                    super(cloudBackupV3Server, "DELETE", REST_PATH, null, Void.class);
                }

                public String getBackupDeviceId() {
                    return this.backupDeviceId;
                }

                public String getBakId() {
                    return this.bakId;
                }

                public Delete setBackupDeviceId(String str) {
                    this.backupDeviceId = str;
                    return this;
                }

                public Delete setBakId(String str) {
                    this.bakId = str;
                    return this;
                }

                /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Remove$Device$Bak$Delete] */
                public Delete setBakVersion(String str) {
                    return setHeader("bakVersion", (Object) str);
                }

                @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
                public CloudBackupV3Request<Void> setFields(String str) {
                    return (Delete) super.setFields(str);
                }

                @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
                public CloudBackupV3Request<Void> setForm(String str) {
                    return (Delete) super.setForm(str);
                }

                @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
                public CloudBackupV3Request<Void> setHeader(String str, Object obj) {
                    return (Delete) super.setHeader(str, obj);
                }

                @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
                public CloudBackupV3Request<Void> setTraceId(String str) {
                    return (Delete) super.setTraceId(str);
                }

                @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request, p614ri.AbstractC12513b, p579qi.AbstractC12361b, com.huawei.cloud.base.util.C4646n
                public Delete set(String str, Object obj) {
                    return (Delete) super.set(str, obj);
                }
            }

            public Bak(CloudBackupV3Server cloudBackupV3Server) {
                this.client = cloudBackupV3Server;
            }

            public Delete deleteSingle() throws IOException {
                return new Delete(this.client);
            }
        }

        public static class BaseApps {
            private CloudBackupV3Server client;

            public static class Delete extends CloudBackupV3Request<Void> {
                private static final String REST_PATH = "remove/device/{backupDeviceId}/baseApps";

                @InterfaceC4648p
                private String backupDeviceId;

                public Delete(CloudBackupV3Server cloudBackupV3Server) throws IOException {
                    super(cloudBackupV3Server, "DELETE", REST_PATH, null, Void.class);
                }

                public String getBackupDeviceId() {
                    return this.backupDeviceId;
                }

                public void setBackupDeviceId(String str) {
                    this.backupDeviceId = str;
                }
            }

            public BaseApps(CloudBackupV3Server cloudBackupV3Server) {
                this.client = cloudBackupV3Server;
            }

            public Delete delete() throws IOException {
                return new Delete(this.client);
            }
        }

        public static class Delete extends CloudBackupV3Request<Void> {
            private static final String REST_PATH = "remove/device/{backupDeviceId}";

            @InterfaceC4648p
            private String backupDeviceId;

            public Delete(CloudBackupV3Server cloudBackupV3Server) throws IOException {
                super(cloudBackupV3Server, "DELETE", REST_PATH, null, Void.class);
            }

            public String getBackupDeviceId() {
                return this.backupDeviceId;
            }

            public Delete setBackupDeviceId(String str) {
                this.backupDeviceId = str;
                return this;
            }

            /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Remove$Device$Delete] */
            public Delete setBakCategories(String str) {
                return setHeader("bakCategories", (Object) str);
            }

            /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Remove$Device$Delete] */
            public Delete setClearRange(Integer num) {
                return setHeader("x-hw-clear-range", (Object) num);
            }

            /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Remove$Device$Delete] */
            public Delete setClearTime(Integer num) {
                return setHeader("clearTime", (Object) num);
            }

            /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Remove$Device$Delete] */
            public Delete setSendPush(Integer num) {
                return setHeader("x-hw-send-push", (Object) num);
            }

            @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
            public CloudBackupV3Request<Void> setHeader(String str, Object obj) {
                return (Delete) super.setHeader(str, obj);
            }

            @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
            public CloudBackupV3Request<Void> setTraceId(String str) {
                return (Delete) super.setTraceId(str);
            }
        }

        public static class List extends CloudBackupV3Request<com.huawei.hicloud.cloudbackup.p104v3.server.model.Remove> {
            private static final String REST_PATH = "remove/device";

            @InterfaceC4648p
            private String cursor;

            @InterfaceC4648p
            private Integer pageSize;

            @InterfaceC4648p
            private String type;

            public List(CloudBackupV3Server cloudBackupV3Server) throws IOException {
                super(cloudBackupV3Server, "GET", REST_PATH, null, com.huawei.hicloud.cloudbackup.p104v3.server.model.Remove.class);
            }

            public String getCursor() {
                return this.cursor;
            }

            public Integer getPageSize() {
                return this.pageSize;
            }

            public String getType() {
                return this.type;
            }

            /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Remove$Device$List] */
            public List setBackGround(Boolean bool) {
                return setHeader("isBackGround", (Object) bool);
            }

            /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Remove$Device$List] */
            public List setClearRange(Integer num) {
                return setHeader("x-hw-clear-range", (Object) num);
            }

            /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Remove$Device$List] */
            public List setClearTime(Integer num) {
                return setHeader("clearTime", (Object) num);
            }

            public List setCursor(String str) {
                this.cursor = str;
                return this;
            }

            public List setPageSize(Integer num) {
                this.pageSize = num;
                return this;
            }

            public List setType(String str) {
                this.type = str;
                return this;
            }

            @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
            public CloudBackupV3Request<com.huawei.hicloud.cloudbackup.p104v3.server.model.Remove> setFields(String str) {
                return (List) super.setFields(str);
            }

            @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
            public CloudBackupV3Request<com.huawei.hicloud.cloudbackup.p104v3.server.model.Remove> setHeader(String str, Object obj) {
                return (List) super.setHeader(str, obj);
            }

            @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
            public CloudBackupV3Request<com.huawei.hicloud.cloudbackup.p104v3.server.model.Remove> setTraceId(String str) {
                return (List) super.setTraceId(str);
            }

            @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request, p614ri.AbstractC12513b, p579qi.AbstractC12361b, com.huawei.cloud.base.util.C4646n
            public List set(String str, Object obj) {
                return (List) super.set(str, obj);
            }
        }

        public Device(CloudBackupV3Server cloudBackupV3Server) {
            this.client = cloudBackupV3Server;
        }

        public Apps apps() {
            return new Apps(this.client);
        }

        public Bak bak() {
            return new Bak(this.client);
        }

        public BaseApps baseApps() {
            return new BaseApps(this.client);
        }

        public Delete delete() throws IOException {
            return new Delete(this.client);
        }

        public List list() throws IOException {
            return new List(this.client);
        }
    }

    public Remove(CloudBackupV3Server cloudBackupV3Server) {
        this.client = cloudBackupV3Server;
    }

    public DeleteSwitch deleteSwitch() {
        return new DeleteSwitch(this.client);
    }

    public Device device() {
        return new Device(this.client);
    }
}
