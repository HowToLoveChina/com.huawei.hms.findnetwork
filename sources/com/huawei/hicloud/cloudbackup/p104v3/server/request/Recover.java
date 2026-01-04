package com.huawei.hicloud.cloudbackup.p104v3.server.request;

import com.huawei.android.hicloud.drive.clouddisk.expand.RequestMethod;
import com.huawei.cloud.base.util.InterfaceC4648p;
import com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request;
import com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Server;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.AppList;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.BakRefresh;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.LockCreate;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.LockKeepResult;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import ni.C11707b;
import p514o9.C11839m;
import p709vj.C13452e;

/* loaded from: classes6.dex */
public class Recover {
    private CloudBackupV3Server client;

    public class Apps {

        public class List extends CloudBackupV3Request<AppList> {
            private static final String REST_PATH = "recover/device/{backupDeviceId}/bak/{bakId}/apps";

            @InterfaceC4648p
            private String backupDeviceId;

            @InterfaceC4648p
            private String bakId;

            @InterfaceC4648p
            private String cursor;

            @InterfaceC4648p
            private Integer pageSize;

            public List() throws IOException {
                super(Recover.this.client, "GET", REST_PATH, null, AppList.class);
                setHeader("cdn", "cdn");
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

            public List setLockId(String str) {
                setHeader("lockId", (Object) str);
                return this;
            }

            public List setLockInterval(Integer num) {
                setHeader("lockInterval", (Object) num);
                return this;
            }

            public List setPageSize(Integer num) {
                this.pageSize = num;
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
            public CloudBackupV3Request<AppList> setHeader(String str, Object obj) {
                return (List) super.setHeader(str, obj);
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

        public Apps() {
        }

        public List list() throws IOException {
            return new List();
        }
    }

    public class Asset {

        public class Get extends CloudBackupV3Request<com.huawei.hicloud.cloudbackup.p104v3.server.model.Asset> {
            private static final String REST_PATH = "recover/kind/{kindId}/record/{recordId}/asset";

            @InterfaceC4648p
            private String androidVer;
            private String cdn;
            private String cloudPath;

            @InterfaceC4648p
            private String emuiVer;
            private String kindId;
            private String lockId;
            private String mode;
            private List<String> objectIds;
            private String recordId;

            @InterfaceC4648p("slice-range")
            private String sliceRange;
            private String usage;

            public Get() throws IOException {
                super(Recover.this.client, "GET", REST_PATH, null, com.huawei.hicloud.cloudbackup.p104v3.server.model.Asset.class);
            }

            public String getAndroidVer() {
                return this.androidVer;
            }

            public String getCdn() {
                return this.cdn;
            }

            public String getCloudPath() {
                return this.cloudPath;
            }

            public String getEmuiVer() {
                return this.emuiVer;
            }

            public String getKindId() {
                return this.kindId;
            }

            public String getLockId() {
                return this.lockId;
            }

            public String getMode() {
                return this.mode;
            }

            public List<String> getObjectIds() {
                return this.objectIds;
            }

            public String getRecordId() {
                return this.recordId;
            }

            public String getSliceRange() {
                return this.sliceRange;
            }

            public String getUsage() {
                return this.usage;
            }

            public Get setAndroidVer(String str) {
                this.androidVer = str;
                return this;
            }

            public Get setCdn(String str) {
                this.cdn = str;
                return this;
            }

            public Get setCloudPath(String str) {
                this.cloudPath = str;
                return this;
            }

            public Get setEmuiVer(String str) {
                this.emuiVer = str;
                return this;
            }

            public Get setKindId(String str) {
                this.kindId = str;
                return this;
            }

            public Get setLockId(String str) {
                this.lockId = str;
                return this;
            }

            public Get setMode(String str) {
                this.mode = str;
                return this;
            }

            public Get setObjectIds(List<String> list) {
                this.objectIds = list;
                return this;
            }

            public Get setRecordId(String str) {
                this.recordId = str;
                return this;
            }

            public Get setSliceRange(String str) {
                this.sliceRange = str;
                return this;
            }

            public Get setUsage(String str) {
                this.usage = str;
                return this;
            }

            @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
            public CloudBackupV3Request<com.huawei.hicloud.cloudbackup.p104v3.server.model.Asset> setFields(String str) {
                return (Get) super.setFields(str);
            }

            @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
            public CloudBackupV3Request<com.huawei.hicloud.cloudbackup.p104v3.server.model.Asset> setForm(String str) {
                return (Get) super.setForm(str);
            }

            @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
            public CloudBackupV3Request<com.huawei.hicloud.cloudbackup.p104v3.server.model.Asset> setTraceId(String str) {
                return (Get) super.setTraceId(str);
            }

            @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request, p614ri.AbstractC12513b, p579qi.AbstractC12361b, com.huawei.cloud.base.util.C4646n
            public Get set(String str, Object obj) {
                return (Get) super.set(str, obj);
            }
        }

        public Asset() {
        }

        public Get get() throws IOException {
            return new Get();
        }

        public Revisions revisions() {
            return new Revisions(Recover.this.client);
        }
    }

    public static class Device {

        public static class Bak {

            public static class Refresh extends CloudBackupV3Request<com.huawei.hicloud.cloudbackup.p104v3.server.model.Bak> {
                private static final String REST_PATH = "recover/device/{backupDeviceId}/bak/{bakId}/refresh";

                @InterfaceC4648p
                private String backupDeviceId;

                @InterfaceC4648p
                private String bakId;

                public Refresh(CloudBackupV3Server cloudBackupV3Server, C11707b c11707b) throws IOException {
                    super(cloudBackupV3Server, RequestMethod.PATCH, REST_PATH, c11707b, com.huawei.hicloud.cloudbackup.p104v3.server.model.Bak.class);
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

                public Refresh setLockId(String str) {
                    setHeader("lockId", (Object) str);
                    return this;
                }

                public Refresh setLockInterval(Integer num) {
                    setHeader("lockInterval", (Object) num);
                    return this;
                }

                @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
                public CloudBackupV3Request<com.huawei.hicloud.cloudbackup.p104v3.server.model.Bak> setFields(String str) {
                    return (Refresh) super.setFields(str);
                }

                @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
                public CloudBackupV3Request<com.huawei.hicloud.cloudbackup.p104v3.server.model.Bak> setForm(String str) {
                    return (Refresh) super.setForm(str);
                }

                @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
                public CloudBackupV3Request<com.huawei.hicloud.cloudbackup.p104v3.server.model.Bak> setHeader(String str, Object obj) {
                    return (Refresh) super.setHeader(str, obj);
                }

                @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
                public CloudBackupV3Request<com.huawei.hicloud.cloudbackup.p104v3.server.model.Bak> setTraceId(String str) {
                    return (Refresh) super.setTraceId(str);
                }
            }

            public Refresh refresh(CloudBackupV3Server cloudBackupV3Server, BakRefresh bakRefresh) throws IOException {
                return new Refresh(cloudBackupV3Server, bakRefresh);
            }
        }

        public Bak bak() {
            return new Bak();
        }
    }

    public class Lock {

        public class Delete extends CloudBackupV3Request<Void> {
            private static final String REST_PATH = "recover/device/{backupDeviceId}/bak/{bakId}/lock";

            @InterfaceC4648p
            private String backupDeviceId;

            @InterfaceC4648p
            private String bakId;

            public Delete() throws IOException {
                super(Recover.this.client, "DELETE", REST_PATH, null, Void.class);
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

            public Delete setLockId(String str) {
                setHeader("lockId", (Object) str);
                return this;
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

        public class Get extends CloudBackupV3Request<com.huawei.hicloud.cloudbackup.p104v3.server.model.Lock> {
            private static final String REST_PATH = "recover/device/{backupDeviceId}/bak/{bakId}/lock";

            @InterfaceC4648p
            private String backupDeviceId;

            @InterfaceC4648p
            private String bakId;

            public Get() throws IOException {
                super(Recover.this.client, "GET", REST_PATH, null, com.huawei.hicloud.cloudbackup.p104v3.server.model.Lock.class);
            }

            public String getBackupDeviceId() {
                return this.backupDeviceId;
            }

            public String getBakId() {
                return this.bakId;
            }

            public Get setBackupDeviceId(String str) {
                this.backupDeviceId = str;
                return this;
            }

            public Get setBakId(String str) {
                this.bakId = str;
                return this;
            }

            @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
            public CloudBackupV3Request<com.huawei.hicloud.cloudbackup.p104v3.server.model.Lock> setFields(String str) {
                return (Get) super.setFields(str);
            }

            @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
            public CloudBackupV3Request<com.huawei.hicloud.cloudbackup.p104v3.server.model.Lock> setForm(String str) {
                return (Get) super.setForm(str);
            }

            @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
            public CloudBackupV3Request<com.huawei.hicloud.cloudbackup.p104v3.server.model.Lock> setTraceId(String str) {
                return (Get) super.setTraceId(str);
            }

            @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request, p614ri.AbstractC12513b, p579qi.AbstractC12361b, com.huawei.cloud.base.util.C4646n
            public Get set(String str, Object obj) {
                return (Get) super.set(str, obj);
            }
        }

        public class KeepLock extends CloudBackupV3Request<LockKeepResult> {
            private static final String REST_PATH = "recover/device/{backupDeviceId}/bak/{bakId}/lock";

            @InterfaceC4648p
            private String backupDeviceId;

            @InterfaceC4648p
            private String bakId;

            public KeepLock(LockCreate lockCreate) throws IOException {
                super(Recover.this.client, RequestMethod.PATCH, REST_PATH, lockCreate, LockKeepResult.class);
            }

            public String getBackupDeviceId() {
                return this.backupDeviceId;
            }

            public String getBakId() {
                return this.bakId;
            }

            public KeepLock setBackupDeviceId(String str) {
                this.backupDeviceId = str;
                return this;
            }

            public KeepLock setBakId(String str) {
                this.bakId = str;
                return this;
            }

            public KeepLock setLockId(String str) {
                setHeader("lockId", (Object) str);
                return this;
            }

            public KeepLock setLockInterval(Integer num) {
                setHeader("lockInterval", (Object) num);
                return this;
            }

            @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
            public CloudBackupV3Request<LockKeepResult> setFields(String str) {
                return (KeepLock) super.setFields(str);
            }

            @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
            public CloudBackupV3Request<LockKeepResult> setForm(String str) {
                return (KeepLock) super.setForm(str);
            }

            @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
            public CloudBackupV3Request<LockKeepResult> setHeader(String str, Object obj) {
                return (KeepLock) super.setHeader(str, obj);
            }

            @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
            public CloudBackupV3Request<LockKeepResult> setTraceId(String str) {
                return (KeepLock) super.setTraceId(str);
            }

            @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request, p614ri.AbstractC12513b, p579qi.AbstractC12361b, com.huawei.cloud.base.util.C4646n
            public KeepLock set(String str, Object obj) {
                return (KeepLock) super.set(str, obj);
            }
        }

        public Lock() {
        }

        public Delete delete() throws IOException {
            return new Delete();
        }

        public Get get() throws IOException {
            return new Get();
        }

        public KeepLock keepLock(LockCreate lockCreate) throws IOException {
            return new KeepLock(lockCreate);
        }
    }

    public static class Revisions {
        private CloudBackupV3Server client;

        public static class Get extends CloudBackupV3Request<com.huawei.hicloud.cloudbackup.p104v3.server.model.Asset> {
            private static final String REST_PATH = "recover/asset";

            @InterfaceC4648p
            private Boolean autofix;

            @InterfaceC4648p
            private String mode;

            @InterfaceC4648p
            private List<String> objectIds;

            public Get(CloudBackupV3Server cloudBackupV3Server) throws IOException {
                super(cloudBackupV3Server, "GET", REST_PATH, null, com.huawei.hicloud.cloudbackup.p104v3.server.model.Asset.class);
                setHeader(JsbMapKeyNames.H5_USER_ID, (Object) C13452e.m80781L().m80971t0());
                setMode("download");
            }

            public boolean getAutoFix() {
                return this.autofix.booleanValue();
            }

            public String getMode() {
                return this.mode;
            }

            public List<String> getObjectIds() {
                return this.objectIds;
            }

            public Get setAssetId(String str) {
                setHeader("x-hw-assetId", (Object) str);
                return this;
            }

            public void setAutoFix(boolean z10) {
                this.autofix = Boolean.valueOf(z10);
            }

            public Get setCdnType(String str) {
                setHeader("cdn", (Object) str);
                return this;
            }

            public Get setCloudPath(String str) {
                try {
                    setHeader("cloudPath", (Object) URLEncoder.encode(str, Constants.UTF_8));
                } catch (UnsupportedEncodingException e10) {
                    C11839m.m70689w("Get", "encode error: " + e10.getMessage());
                }
                return this;
            }

            public Get setKindId(String str) {
                setHeader("x-hw-kindId", (Object) str);
                return this;
            }

            public Get setLockId(String str) {
                setHeader("lockId", (Object) str);
                return this;
            }

            public Get setLockInterval(Integer num) {
                setHeader("lockInterval", (Object) num);
                return this;
            }

            public Get setMode(String str) {
                this.mode = str;
                return this;
            }

            public Get setObjectIds(List<String> list) {
                this.objectIds = list;
                return this;
            }

            public Get setRecordId(String str) {
                setHeader("x-hw-recordId", (Object) str);
                return this;
            }

            public Get setVersionId(String str) {
                setHeader("x-hw-versionId", (Object) str);
                return this;
            }

            @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
            public CloudBackupV3Request<com.huawei.hicloud.cloudbackup.p104v3.server.model.Asset> setFields(String str) {
                return (Get) super.setFields(str);
            }

            @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
            public CloudBackupV3Request<com.huawei.hicloud.cloudbackup.p104v3.server.model.Asset> setHeader(String str, Object obj) {
                return (Get) super.setHeader(str, obj);
            }

            @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
            public CloudBackupV3Request<com.huawei.hicloud.cloudbackup.p104v3.server.model.Asset> setTraceId(String str) {
                return (Get) super.setTraceId(str);
            }
        }

        public Revisions(CloudBackupV3Server cloudBackupV3Server) {
            this.client = cloudBackupV3Server;
        }

        public Get get() throws IOException {
            return new Get(this.client);
        }
    }

    public Recover(CloudBackupV3Server cloudBackupV3Server) {
        this.client = cloudBackupV3Server;
    }

    public Apps apps() {
        return new Apps();
    }

    public Asset asset() {
        return new Asset();
    }

    public Device device() {
        return new Device();
    }

    public Lock lock() {
        return new Lock();
    }
}
