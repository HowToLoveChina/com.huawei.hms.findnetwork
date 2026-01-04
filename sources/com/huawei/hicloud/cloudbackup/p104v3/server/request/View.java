package com.huawei.hicloud.cloudbackup.p104v3.server.request;

import android.text.TextUtils;
import com.huawei.android.hicloud.drive.clouddisk.expand.RequestMethod;
import com.huawei.cloud.base.util.C4627a0;
import com.huawei.cloud.base.util.InterfaceC4648p;
import com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request;
import com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Server;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.AnalysisReport;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.AppList;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.AppSizeInfoList;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.AppSwitchStatusInfoList;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.AppsSwitchPost;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.BakRefreshRequestNoLock;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.DeviceList;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.GeneralPost;
import java.io.IOException;

/* loaded from: classes6.dex */
public class View {
    private CloudBackupV3Server client;

    public static class Device {
        private CloudBackupV3Server client;

        public static class App {
            private CloudBackupV3Server client;

            public static class PreAnalysis {
                private CloudBackupV3Server client;

                public static class Get extends CloudBackupV3Request<AnalysisReport> {
                    private static final String REST_PATH = "view/device/{backupDeviceId}/app/preanalysis";

                    @InterfaceC4648p
                    private String backupDeviceId;

                    @InterfaceC4648p
                    private String cursor;

                    @InterfaceC4648p
                    private Integer pageSize;

                    public Get(CloudBackupV3Server cloudBackupV3Server, String str) throws IOException {
                        super(cloudBackupV3Server, "GET", REST_PATH, null, AnalysisReport.class);
                        this.backupDeviceId = (String) C4627a0.m28392e(str, "Required parameter fileId must be specified.");
                    }

                    public String getBackupDeviceId() {
                        return this.backupDeviceId;
                    }

                    public String getCursor() {
                        return this.cursor;
                    }

                    public Integer getPageSize() {
                        return this.pageSize;
                    }

                    public Get setBackupDeviceId(String str) {
                        this.backupDeviceId = str;
                        return this;
                    }

                    public Get setCursor(String str) {
                        this.cursor = str;
                        return this;
                    }

                    public Get setPageSize(Integer num) {
                        this.pageSize = num;
                        return this;
                    }

                    @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
                    public CloudBackupV3Request<AnalysisReport> setFields(String str) {
                        return (Get) super.setFields(str);
                    }

                    @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
                    public CloudBackupV3Request<AnalysisReport> setHeader(String str, Object obj) {
                        return (Get) super.setHeader(str, obj);
                    }

                    @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
                    public CloudBackupV3Request<AnalysisReport> setTraceId(String str) {
                        return (Get) super.setTraceId(str);
                    }

                    @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request, p614ri.AbstractC12513b, p579qi.AbstractC12361b, com.huawei.cloud.base.util.C4646n
                    public Get set(String str, Object obj) {
                        return (Get) super.set(str, obj);
                    }
                }

                public static class Post extends CloudBackupV3Request<Void> {
                    private static final String REST_PATH = "view/device/{backupDeviceId}/app/preanalysis";

                    @InterfaceC4648p
                    private String backupDeviceId;

                    public Post(CloudBackupV3Server cloudBackupV3Server, String str, GeneralPost generalPost) throws IOException {
                        super(cloudBackupV3Server, "POST", REST_PATH, generalPost, Void.class);
                        this.backupDeviceId = (String) C4627a0.m28392e(str, "Required parameter fileId must be specified.");
                    }

                    public String getBackupDeviceId() {
                        return this.backupDeviceId;
                    }

                    public Post setBackupDeviceId(String str) {
                        this.backupDeviceId = str;
                        return this;
                    }

                    @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
                    public CloudBackupV3Request<Void> setFields(String str) {
                        return (Post) super.setFields(str);
                    }

                    @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
                    public CloudBackupV3Request<Void> setHeader(String str, Object obj) {
                        return (Post) super.setHeader(str, obj);
                    }

                    @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
                    public CloudBackupV3Request<Void> setTraceId(String str) {
                        return (Post) super.setTraceId(str);
                    }

                    @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request, p614ri.AbstractC12513b, p579qi.AbstractC12361b, com.huawei.cloud.base.util.C4646n
                    public Post set(String str, Object obj) {
                        return (Post) super.set(str, obj);
                    }
                }

                public PreAnalysis(CloudBackupV3Server cloudBackupV3Server) {
                    this.client = cloudBackupV3Server;
                }

                public Get get(String str) throws IOException {
                    return new Get(this.client, str);
                }

                public Post post(String str, GeneralPost generalPost) throws IOException {
                    return new Post(this.client, str, generalPost);
                }
            }

            public static class Transfer extends CloudBackupV3Request<Void> {
                private static final String REST_PATH = "view/device/{backupDeviceId}/app/transfer";

                @InterfaceC4648p
                private String backupDeviceId;

                public Transfer(CloudBackupV3Server cloudBackupV3Server, String str, GeneralPost generalPost) throws IOException {
                    super(cloudBackupV3Server, "POST", REST_PATH, generalPost, Void.class);
                    this.backupDeviceId = (String) C4627a0.m28392e(str, "Required parameter fileId must be specified.");
                }

                public String getBackupDeviceId() {
                    return this.backupDeviceId;
                }

                /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.View$Device$App$Transfer] */
                public Transfer setAppNameList(String str) {
                    return setHeader("x-hw-appnamelist", (Object) str);
                }

                public Transfer setBackupDeviceId(String str) {
                    this.backupDeviceId = str;
                    return this;
                }

                @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
                public CloudBackupV3Request<Void> setFields(String str) {
                    return (Transfer) super.setFields(str);
                }

                @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
                public CloudBackupV3Request<Void> setHeader(String str, Object obj) {
                    return (Transfer) super.setHeader(str, obj);
                }

                @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
                public CloudBackupV3Request<Void> setTraceId(String str) {
                    return (Transfer) super.setTraceId(str);
                }

                @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request, p614ri.AbstractC12513b, p579qi.AbstractC12361b, com.huawei.cloud.base.util.C4646n
                public Transfer set(String str, Object obj) {
                    return (Transfer) super.set(str, obj);
                }
            }

            public App(CloudBackupV3Server cloudBackupV3Server) {
                this.client = cloudBackupV3Server;
            }

            public PreAnalysis preAnalysis() {
                return new PreAnalysis(this.client);
            }

            public Transfer transfer(String str, GeneralPost generalPost) throws IOException {
                return new Transfer(this.client, str, generalPost);
            }
        }

        public static class Apps {
            private CloudBackupV3Server client;

            public static class List extends CloudBackupV3Request<AppSizeInfoList> {
                private static final String REST_PATH = "view/device/{backupDeviceId}/apps";

                @InterfaceC4648p
                private String backupDeviceId;

                @InterfaceC4648p
                private String cursor;

                @InterfaceC4648p
                private Integer pageSize;

                public List(CloudBackupV3Server cloudBackupV3Server, String str) throws IOException {
                    super(cloudBackupV3Server, "GET", REST_PATH, null, AppSizeInfoList.class);
                    this.backupDeviceId = (String) C4627a0.m28392e(str, "Required parameter fileId must be specified.");
                }

                public String getBackupDeviceId() {
                    return this.backupDeviceId;
                }

                public String getCursor() {
                    return this.cursor;
                }

                public Integer getPageSize() {
                    return this.pageSize;
                }

                public List setAppNameList(String str) {
                    return (List) super.setHeader("x-hw-appnamelist", str);
                }

                public List setBackupDeviceId(String str) {
                    this.backupDeviceId = str;
                    return this;
                }

                public List setCursor(String str) {
                    this.cursor = str;
                    return this;
                }

                public List setPageSize(Integer num) {
                    this.pageSize = num;
                    return this;
                }

                @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
                public CloudBackupV3Request<AppSizeInfoList> setFields(String str) {
                    return (List) super.setFields(str);
                }

                @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
                public CloudBackupV3Request<AppSizeInfoList> setForm(String str) {
                    return (List) super.setForm(str);
                }

                @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
                public CloudBackupV3Request<AppSizeInfoList> setTraceId(String str) {
                    return (List) super.setTraceId(str);
                }

                @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request, p614ri.AbstractC12513b, p579qi.AbstractC12361b, com.huawei.cloud.base.util.C4646n
                public List set(String str, Object obj) {
                    return (List) super.set(str, obj);
                }
            }

            public static class SwitchStatus {
                private CloudBackupV3Server client;

                public static class Delete extends CloudBackupV3Request<Void> {
                    private static final String REST_PATH = "view/device/{backupDeviceId}/apps/switchStatus";

                    @InterfaceC4648p
                    private String backupDeviceId;

                    public Delete(CloudBackupV3Server cloudBackupV3Server, String str) throws IOException {
                        super(cloudBackupV3Server, "DELETE", REST_PATH, null, Void.class);
                        this.backupDeviceId = TextUtils.isEmpty(str) ? "backupDeviceIdV1V2" : str;
                    }

                    public String getBackupDeviceId() {
                        return this.backupDeviceId;
                    }

                    /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.View$Device$Apps$SwitchStatus$Delete] */
                    public Delete setAppNameList(String str) {
                        return setHeader("x-hw-appnamelist", (Object) str);
                    }

                    public void setBackupDeviceId(String str) {
                        this.backupDeviceId = str;
                    }

                    /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.View$Device$Apps$SwitchStatus$Delete] */
                    public Delete setTargetDeviceId(String str) {
                        return setHeader("x-hw-target-deviceId", (Object) str);
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

                public static class List extends CloudBackupV3Request<AppSwitchStatusInfoList> {
                    private static final String REST_PATH = "view/device/{backupDeviceId}/apps/switchStatus";

                    @InterfaceC4648p
                    private String backupDeviceId;

                    @InterfaceC4648p
                    private String cursor;

                    @InterfaceC4648p
                    private Integer pageSize;

                    public List(CloudBackupV3Server cloudBackupV3Server, String str) throws IOException {
                        super(cloudBackupV3Server, "GET", REST_PATH, null, AppSwitchStatusInfoList.class);
                        this.backupDeviceId = TextUtils.isEmpty(str) ? "backupDeviceIdV1V2" : str;
                    }

                    public String getBackupDeviceId() {
                        return this.backupDeviceId;
                    }

                    public String getCursor() {
                        return this.cursor;
                    }

                    public Integer getPageSize() {
                        return this.pageSize;
                    }

                    /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.View$Device$Apps$SwitchStatus$List] */
                    public List setAppNameList(String str) {
                        return setHeader("x-hw-appnamelist", (Object) str);
                    }

                    public List setBackupDeviceId(String str) {
                        this.backupDeviceId = str;
                        return this;
                    }

                    public List setCursor(String str) {
                        this.cursor = str;
                        return this;
                    }

                    public List setPageSize(Integer num) {
                        this.pageSize = num;
                        return this;
                    }

                    /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.View$Device$Apps$SwitchStatus$List] */
                    public List setTargetDeviceId(String str) {
                        return setHeader("x-hw-target-deviceId", (Object) str);
                    }

                    @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
                    public CloudBackupV3Request<AppSwitchStatusInfoList> setFields(String str) {
                        return (List) super.setFields(str);
                    }

                    @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
                    public CloudBackupV3Request<AppSwitchStatusInfoList> setForm(String str) {
                        return (List) super.setForm(str);
                    }

                    @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
                    public CloudBackupV3Request<AppSwitchStatusInfoList> setHeader(String str, Object obj) {
                        return (List) super.setHeader(str, obj);
                    }

                    @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
                    public CloudBackupV3Request<AppSwitchStatusInfoList> setTraceId(String str) {
                        return (List) super.setTraceId(str);
                    }

                    @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request, p614ri.AbstractC12513b, p579qi.AbstractC12361b, com.huawei.cloud.base.util.C4646n
                    public List set(String str, Object obj) {
                        return (List) super.set(str, obj);
                    }
                }

                public static class Post extends CloudBackupV3Request<Void> {
                    private static final String REST_PATH = "view/device/{backupDeviceId}/apps/switchStatus";

                    @InterfaceC4648p
                    private String backupDeviceId;

                    public Post(CloudBackupV3Server cloudBackupV3Server, String str, AppsSwitchPost appsSwitchPost) throws IOException {
                        super(cloudBackupV3Server, "POST", REST_PATH, appsSwitchPost, Void.class);
                        this.backupDeviceId = TextUtils.isEmpty(str) ? "backupDeviceIdV1V2" : str;
                    }

                    public String getBackupDeviceId() {
                        return this.backupDeviceId;
                    }

                    /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.View$Device$Apps$SwitchStatus$Post] */
                    public Post setAppNameList(String str) {
                        return setHeader("x-hw-appnamelist", (Object) str);
                    }

                    public Post setBackupDeviceId(String str) {
                        this.backupDeviceId = str;
                        return this;
                    }

                    @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
                    public CloudBackupV3Request<Void> setFields(String str) {
                        return (Post) super.setFields(str);
                    }

                    @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
                    public CloudBackupV3Request<Void> setForm(String str) {
                        return (Post) super.setForm(str);
                    }

                    @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
                    public CloudBackupV3Request<Void> setHeader(String str, Object obj) {
                        return (Post) super.setHeader(str, obj);
                    }

                    @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
                    public CloudBackupV3Request<Void> setTraceId(String str) {
                        return (Post) super.setTraceId(str);
                    }

                    @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request, p614ri.AbstractC12513b, p579qi.AbstractC12361b, com.huawei.cloud.base.util.C4646n
                    public Post set(String str, Object obj) {
                        return (Post) super.set(str, obj);
                    }
                }

                public SwitchStatus(CloudBackupV3Server cloudBackupV3Server) {
                    this.client = cloudBackupV3Server;
                }

                public Delete delete(String str) throws IOException {
                    return new Delete(this.client, str);
                }

                public List list(String str) throws IOException {
                    return new List(this.client, str);
                }

                public Post post(String str, AppsSwitchPost appsSwitchPost) throws IOException {
                    return new Post(this.client, str, appsSwitchPost);
                }
            }

            public Apps(CloudBackupV3Server cloudBackupV3Server) {
                this.client = cloudBackupV3Server;
            }

            public List list(String str) throws IOException {
                return new List(this.client, str);
            }

            public SwitchStatus switchStatus() {
                return new SwitchStatus(this.client);
            }
        }

        public static class Bak {
            private CloudBackupV3Server client;

            public static class Apps {
                private CloudBackupV3Server client;

                public static class List extends CloudBackupV3Request<AppList> {
                    private static final String REST_PATH = "view/device/{backupDeviceId}/bak/{bakId}/apps";

                    @InterfaceC4648p
                    private String backupDeviceId;

                    @InterfaceC4648p
                    private String bakId;

                    @InterfaceC4648p
                    private String cursor;

                    @InterfaceC4648p
                    private Integer pageSize;

                    @InterfaceC4648p
                    private String usage;

                    public List(CloudBackupV3Server cloudBackupV3Server, String str, String str2) throws IOException {
                        super(cloudBackupV3Server, "GET", REST_PATH, null, AppList.class);
                        this.backupDeviceId = (String) C4627a0.m28392e(str, "Required parameter fileId must be specified.");
                        this.bakId = (String) C4627a0.m28392e(str2, "Required parameter fileId must be specified.");
                    }

                    public String getBackupDeviceId() {
                        return this.backupDeviceId;
                    }

                    public String getBakId() {
                        return this.bakId;
                    }

                    public String getCursor() {
                        return this.cursor;
                    }

                    public Integer getPageSize() {
                        return this.pageSize;
                    }

                    public String getUsage() {
                        return this.usage;
                    }

                    public List setBackupDeviceId(String str) {
                        this.backupDeviceId = str;
                        return this;
                    }

                    public List setBakId(String str) {
                        this.bakId = str;
                        return this;
                    }

                    public List setCursor(String str) {
                        this.cursor = str;
                        return this;
                    }

                    public List setPageSize(Integer num) {
                        this.pageSize = num;
                        return this;
                    }

                    public List setUsage(String str) {
                        this.usage = str;
                        return this;
                    }

                    @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
                    public CloudBackupV3Request<AppList> setFields(String str) {
                        return (List) super.setFields(str);
                    }

                    @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
                    public CloudBackupV3Request<AppList> setForm(String str) {
                        return (List) super.setForm(str);
                    }

                    @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
                    public CloudBackupV3Request<AppList> setTraceId(String str) {
                        return (List) super.setTraceId(str);
                    }

                    @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request, p614ri.AbstractC12513b, p579qi.AbstractC12361b, com.huawei.cloud.base.util.C4646n
                    public List set(String str, Object obj) {
                        return (List) super.set(str, obj);
                    }
                }

                public Apps(CloudBackupV3Server cloudBackupV3Server) {
                    this.client = cloudBackupV3Server;
                }

                public List list(String str, String str2) throws IOException {
                    return new List(this.client, str, str2);
                }
            }

            public class Refresh extends CloudBackupV3Request<com.huawei.hicloud.cloudbackup.p104v3.server.model.Bak> {
                private static final String REST_PATH = "view/device/{backupDeviceId}/bak/{bakId}";

                @InterfaceC4648p
                private String backupDeviceId;

                @InterfaceC4648p
                private String bakId;

                public Refresh(CloudBackupV3Server cloudBackupV3Server, BakRefreshRequestNoLock bakRefreshRequestNoLock) throws IOException {
                    super(cloudBackupV3Server, RequestMethod.PATCH, REST_PATH, bakRefreshRequestNoLock, com.huawei.hicloud.cloudbackup.p104v3.server.model.Bak.class);
                }

                public String getBackupDeviceId() {
                    return this.backupDeviceId;
                }

                public String getBakId() {
                    return this.bakId;
                }

                public Refresh setBackupDeviceId(String str) {
                    this.backupDeviceId = str;
                    return this;
                }

                public Refresh setBakId(String str) {
                    this.bakId = str;
                    return this;
                }

                @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
                public CloudBackupV3Request<com.huawei.hicloud.cloudbackup.p104v3.server.model.Bak> setFields(String str) {
                    return (Refresh) super.setFields(str);
                }
            }

            public class Single extends CloudBackupV3Request<com.huawei.hicloud.cloudbackup.p104v3.server.model.Bak> {
                private static final String REST_PATH = "view/device/{backupDeviceId}/bak/{bakId}";

                @InterfaceC4648p
                private String backupDeviceId;

                @InterfaceC4648p
                private String bakId;

                public Single(CloudBackupV3Server cloudBackupV3Server) throws IOException {
                    super(cloudBackupV3Server, "GET", REST_PATH, null, com.huawei.hicloud.cloudbackup.p104v3.server.model.Bak.class);
                }

                public String getBackupDeviceId() {
                    return this.backupDeviceId;
                }

                public String getBakId() {
                    return this.bakId;
                }

                public Single setBackupDeviceId(String str) {
                    this.backupDeviceId = str;
                    return this;
                }

                public Single setBakId(String str) {
                    this.bakId = str;
                    return this;
                }

                @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
                public CloudBackupV3Request<com.huawei.hicloud.cloudbackup.p104v3.server.model.Bak> setFields(String str) {
                    return (Single) super.setFields(str);
                }
            }

            public Bak(CloudBackupV3Server cloudBackupV3Server) {
                this.client = cloudBackupV3Server;
            }

            public Apps apps() {
                return new Apps(this.client);
            }

            public Refresh refresh(BakRefreshRequestNoLock bakRefreshRequestNoLock) throws IOException {
                return new Refresh(this.client, bakRefreshRequestNoLock);
            }

            public Single single() throws IOException {
                return new Single(this.client);
            }
        }

        public static class Baks extends CloudBackupV3Request<DeviceList> {
            private static final String REST_PATH = "view/devices/baks";

            @InterfaceC4648p
            private String cursor;

            @InterfaceC4648p
            private Integer pageSize;

            @InterfaceC4648p
            private Integer queryType;

            public Baks(CloudBackupV3Server cloudBackupV3Server) throws IOException {
                super(cloudBackupV3Server, "GET", REST_PATH, null, DeviceList.class);
            }

            public String getCursor() {
                return this.cursor;
            }

            public Integer getPageSize() {
                return this.pageSize;
            }

            public Integer getQueryType() {
                return this.queryType;
            }

            public Baks setCursor(String str) {
                this.cursor = str;
                return this;
            }

            public Baks setPageSize(Integer num) {
                this.pageSize = num;
                return this;
            }

            public Baks setQueryType(Integer num) {
                this.queryType = num;
                return this;
            }

            @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
            public CloudBackupV3Request<DeviceList> setFields(String str) {
                return (Baks) super.setFields(str);
            }

            @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
            public CloudBackupV3Request<DeviceList> setForm(String str) {
                return (Baks) super.setForm(str);
            }

            @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
            public CloudBackupV3Request<DeviceList> setTraceId(String str) {
                return (Baks) super.setTraceId(str);
            }

            @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request, p614ri.AbstractC12513b, p579qi.AbstractC12361b, com.huawei.cloud.base.util.C4646n
            public Baks set(String str, Object obj) {
                return (Baks) super.set(str, obj);
            }
        }

        public Device(CloudBackupV3Server cloudBackupV3Server) {
            this.client = cloudBackupV3Server;
        }

        public App app() {
            return new App(this.client);
        }

        public Apps apps() {
            return new Apps(this.client);
        }

        public Bak bak() {
            return new Bak(this.client);
        }

        public Baks baks() throws IOException {
            return new Baks(this.client);
        }
    }

    public View(CloudBackupV3Server cloudBackupV3Server) {
        this.client = cloudBackupV3Server;
    }

    public Device device() {
        return new Device(this.client);
    }
}
