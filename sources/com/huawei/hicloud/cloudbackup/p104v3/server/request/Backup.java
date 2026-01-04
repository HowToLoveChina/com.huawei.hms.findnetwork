package com.huawei.hicloud.cloudbackup.p104v3.server.request;

import android.text.TextUtils;
import com.huawei.android.hicloud.drive.clouddisk.expand.RequestMethod;
import com.huawei.cloud.base.util.C4627a0;
import com.huawei.cloud.base.util.C4644l;
import com.huawei.cloud.base.util.InterfaceC4648p;
import com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request;
import com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Server;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.DeviceConditionReport;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.DeviceCreate;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.LockCreate;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.LockKeepResult;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.RevisionCreate;
import java.io.IOException;
import p015ak.C0241z;
import p495nm.C11722c;

/* loaded from: classes6.dex */
public class Backup {
    private CloudBackupV3Server client;

    public static class Asset {
        public CloudBackupV3Server client;

        public static class Create extends CloudBackupV3Request<com.huawei.hicloud.cloudbackup.p104v3.server.model.Asset> {
            private static final String REST_PATH = "backup/{backupAction}/kind/{kindId}/record/{recordId}/asset";

            @InterfaceC4648p
            private Boolean antiMdr;

            @InterfaceC4648p
            private String backupAction;

            @InterfaceC4648p
            private String kindId;

            @InterfaceC4648p
            private String recordId;

            @InterfaceC4648p
            private String usage;

            public Create(CloudBackupV3Server cloudBackupV3Server, RevisionCreate revisionCreate) throws IOException {
                super(cloudBackupV3Server, "POST", REST_PATH, revisionCreate, com.huawei.hicloud.cloudbackup.p104v3.server.model.Asset.class);
            }

            public Boolean getAntiMdr() {
                return this.antiMdr;
            }

            public String getBackupAction() {
                return this.backupAction;
            }

            public String getKindId() {
                return this.kindId;
            }

            public String getRecordId() {
                return this.recordId;
            }

            public String getUsage() {
                return this.usage;
            }

            /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Backup$Asset$Create] */
            public Create setAndroidVer(String str) {
                return setHeader("androidVer", (Object) str);
            }

            public Create setAntiMdr(Boolean bool) {
                this.antiMdr = bool;
                return this;
            }

            public Create setBackupAction(String str) {
                this.backupAction = str;
                return this;
            }

            /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Backup$Asset$Create] */
            public Create setBakCategory(String str) {
                return TextUtils.isEmpty(str) ? this : setHeader("bakCategory", (Object) str);
            }

            /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Backup$Asset$Create] */
            public Create setEmuiVer(String str) {
                return setHeader("emuiVer", (Object) str);
            }

            /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Backup$Asset$Create] */
            public Create setInterimChannel(Integer num) {
                return num == null ? this : setHeader("x-hw-channel", (Object) num);
            }

            public Create setKindId(String str) {
                this.kindId = str;
                return this;
            }

            /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Backup$Asset$Create] */
            public Create setLockId(String str) {
                return setHeader("lockId", (Object) str);
            }

            /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Backup$Asset$Create] */
            public Create setLockInterval(Integer num) {
                return setHeader("lockInterval", (Object) num);
            }

            /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Backup$Asset$Create] */
            public Create setOccupySpaceType(Integer num) {
                return num == null ? this : setHeader("occupySpaceType", (Object) num);
            }

            /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Backup$Asset$Create] */
            public Create setPackageName(String str) {
                return setHeader("packageName", (Object) str);
            }

            /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Backup$Asset$Create] */
            public Create setPackageOriginHash(String str) {
                return setHeader("packageOriginHash", (Object) str);
            }

            /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Backup$Asset$Create] */
            public Create setPackageOriginHashType(String str) {
                return setHeader("packageOriginHashType", (Object) str);
            }

            /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Backup$Asset$Create] */
            public Create setPackageOriginLength(String str) {
                return setHeader("packageOriginLength", (Object) str);
            }

            /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Backup$Asset$Create] */
            public Create setPackageSsha2(String str) {
                return !TextUtils.isEmpty(str) ? setHeader("x-hw-package-ssha2", (Object) str) : this;
            }

            /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Backup$Asset$Create] */
            public Create setPackageVersion(String str) {
                return setHeader("packageVersion", (Object) str);
            }

            public Create setRecordId(String str) {
                this.recordId = str;
                return this;
            }

            public Create setUsage(String str) {
                this.usage = str;
                return this;
            }

            /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Backup$Asset$Create] */
            public Create setXHwBackupPackageName(String str) {
                return setHeader("x-hw-backup-packageName", (Object) str);
            }

            /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Backup$Asset$Create] */
            public Create setXHwBackupid(String str) {
                return setHeader("x-hw-backupId", (Object) str);
            }

            @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
            public CloudBackupV3Request<com.huawei.hicloud.cloudbackup.p104v3.server.model.Asset> setFields(String str) {
                return (Create) super.setFields(str);
            }

            @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
            public CloudBackupV3Request<com.huawei.hicloud.cloudbackup.p104v3.server.model.Asset> setForm(String str) {
                return (Create) super.setForm(str);
            }

            @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
            public CloudBackupV3Request<com.huawei.hicloud.cloudbackup.p104v3.server.model.Asset> setHeader(String str, Object obj) {
                return (Create) super.setHeader(str, obj);
            }

            @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
            public CloudBackupV3Request<com.huawei.hicloud.cloudbackup.p104v3.server.model.Asset> setTraceId(String str) {
                return (Create) super.setTraceId(str);
            }

            @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request, p614ri.AbstractC12513b, p579qi.AbstractC12361b, com.huawei.cloud.base.util.C4646n
            public Create set(String str, Object obj) {
                return (Create) super.set(str, obj);
            }
        }

        public static class Delete extends CloudBackupV3Request<Void> {
            private static final String REST_PATH = "backup/{backupAction}/kind/{kindId}/record/{recordId}/asset/{assetId}";

            @InterfaceC4648p
            private String assetId;

            @InterfaceC4648p
            private String backupAction;

            @InterfaceC4648p
            private String kindId;

            @InterfaceC4648p
            private String recordId;

            public Delete(CloudBackupV3Server cloudBackupV3Server) throws IOException {
                super(cloudBackupV3Server, "DELETE", REST_PATH, null, Void.class);
            }

            public String getAssetId() {
                return this.assetId;
            }

            public String getBackupAction() {
                return this.backupAction;
            }

            public String getKindId() {
                return this.kindId;
            }

            public String getRecordId() {
                return this.recordId;
            }

            public Delete setAssetId(String str) {
                this.assetId = str;
                return this;
            }

            public Delete setBackupAction(String str) {
                this.backupAction = str;
                return this;
            }

            /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Backup$Asset$Delete] */
            public Delete setBakId(String str) {
                return setHeader("x-hw-backupId", (Object) str);
            }

            public Delete setKindId(String str) {
                this.kindId = str;
                return this;
            }

            /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Backup$Asset$Delete] */
            public Delete setLockId(String str) {
                return setHeader("lockId", (Object) str);
            }

            /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Backup$Asset$Delete] */
            public Delete setLockInterval(Integer num) {
                return setHeader("lockInterval", (Object) num);
            }

            public Delete setRecordId(String str) {
                this.recordId = str;
                return this;
            }

            /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Backup$Asset$Delete] */
            public Delete setXHwBackupPackageName(String str) {
                return setHeader("x-hw-backup-packageName", (Object) str);
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

        public Asset(CloudBackupV3Server cloudBackupV3Server) {
            this.client = cloudBackupV3Server;
        }

        public Create create(RevisionCreate revisionCreate) throws IOException {
            return new Create(this.client, revisionCreate);
        }

        public Delete delete() throws IOException {
            return new Delete(this.client);
        }

        public Revisions revisions() {
            return new Revisions(this.client);
        }
    }

    public static class Device {
        private CloudBackupV3Server client;

        public static class ConditionReport extends CloudBackupV3Request<Void> {
            private static final String REST_PATH = "device/{backupDeviceId}/backupConditionReport";

            @InterfaceC4648p
            private String backupDeviceId;

            public ConditionReport(CloudBackupV3Server cloudBackupV3Server, DeviceConditionReport deviceConditionReport) throws IOException {
                super(cloudBackupV3Server, "POST", REST_PATH, deviceConditionReport, Void.class);
            }

            public String getBackupDeviceId() {
                return this.backupDeviceId;
            }

            public ConditionReport setBackupDeviceId(String str) {
                this.backupDeviceId = str;
                return this;
            }

            @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
            public CloudBackupV3Request<Void> setForm(String str) {
                return (ConditionReport) super.setForm(str);
            }

            @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
            public CloudBackupV3Request<Void> setHeader(String str, Object obj) {
                return (ConditionReport) super.setHeader(str, obj);
            }

            @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
            public CloudBackupV3Request<Void> setTraceId(String str) {
                return (ConditionReport) super.setTraceId(str);
            }

            @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request, p614ri.AbstractC12513b, p579qi.AbstractC12361b, com.huawei.cloud.base.util.C4646n
            public ConditionReport set(String str, Object obj) {
                return (ConditionReport) super.set(str, obj);
            }
        }

        public static class Create extends CloudBackupV3Request<com.huawei.hicloud.cloudbackup.p104v3.server.model.Device> {
            private static final String REST_PATH = "backup/{backupAction}/device";

            @InterfaceC4648p
            private String backupAction;

            public Create(CloudBackupV3Server cloudBackupV3Server, DeviceCreate deviceCreate) throws IOException {
                super(cloudBackupV3Server, "POST", REST_PATH, deviceCreate, com.huawei.hicloud.cloudbackup.p104v3.server.model.Device.class);
            }

            public String getBackupAction() {
                return this.backupAction;
            }

            public Create setBackupAction(String str) {
                this.backupAction = str;
                return this;
            }

            /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Backup$Device$Create] */
            public Create setBakCategory(String str) {
                return TextUtils.isEmpty(str) ? this : setHeader("bakCategory", (Object) str);
            }

            /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Backup$Device$Create] */
            public Create setOccupySpaceType(Integer num) {
                return num == null ? this : setHeader("occupySpaceType", (Object) num);
            }

            @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
            public CloudBackupV3Request<com.huawei.hicloud.cloudbackup.p104v3.server.model.Device> setFields(String str) {
                return (Create) super.setFields(str);
            }

            @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
            public CloudBackupV3Request<com.huawei.hicloud.cloudbackup.p104v3.server.model.Device> setForm(String str) {
                return (Create) super.setForm(str);
            }

            @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
            public CloudBackupV3Request<com.huawei.hicloud.cloudbackup.p104v3.server.model.Device> setHeader(String str, Object obj) {
                return (Create) super.setHeader(str, obj);
            }

            @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
            public CloudBackupV3Request<com.huawei.hicloud.cloudbackup.p104v3.server.model.Device> setTraceId(String str) {
                return (Create) super.setTraceId(str);
            }

            @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request, p614ri.AbstractC12513b, p579qi.AbstractC12361b, com.huawei.cloud.base.util.C4646n
            public Create set(String str, Object obj) {
                return (Create) super.set(str, obj);
            }
        }

        public Device(CloudBackupV3Server cloudBackupV3Server) {
            this.client = cloudBackupV3Server;
        }

        public Bak bak() {
            return new Bak(this.client);
        }

        public ConditionReport conditionReport(DeviceConditionReport deviceConditionReport) throws IOException {
            return new ConditionReport(this.client, deviceConditionReport);
        }

        public Create create(DeviceCreate deviceCreate) throws IOException {
            return new Create(this.client, deviceCreate);
        }

        public File file() {
            return new File(this.client);
        }
    }

    public static class Lock {
        private CloudBackupV3Server client;

        public static class Delete extends CloudBackupV3Request<Void> {
            private static final String REST_PATH = "backup/{backupAction}/device/{backupDeviceId}/lock";

            @InterfaceC4648p
            private String backupAction;

            @InterfaceC4648p
            private String backupDeviceId;

            public Delete(CloudBackupV3Server cloudBackupV3Server, String str) throws IOException {
                super(cloudBackupV3Server, "DELETE", REST_PATH, null, Void.class);
                setHeader("lockId", C4627a0.m28391d(str));
            }

            public String getBackupAction() {
                return this.backupAction;
            }

            public String getBackupDeviceId() {
                return this.backupDeviceId;
            }

            public Delete setBackupAction(String str) {
                this.backupAction = str;
                return this;
            }

            public Delete setBackupDeviceId(String str) {
                this.backupDeviceId = str;
                return this;
            }

            /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Backup$Lock$Delete] */
            public Delete setBakCategory(String str) {
                return TextUtils.isEmpty(str) ? this : setHeader("bakCategory", (Object) str);
            }

            /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Backup$Lock$Delete] */
            public Delete setOccupySpaceType(Integer num) {
                return num == null ? this : setHeader("occupySpaceType", (Object) num);
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

        public static class Get extends CloudBackupV3Request<com.huawei.hicloud.cloudbackup.p104v3.server.model.Lock> {
            private static final String REST_PATH = "backup/{backupAction}/device/{backupDeviceId}/lock";

            @InterfaceC4648p
            private String backupAction;

            @InterfaceC4648p
            private String backupDeviceId;

            public Get(CloudBackupV3Server cloudBackupV3Server, String str, int i10, long j10, String str2, String str3, String str4) throws IOException {
                super(cloudBackupV3Server, "GET", REST_PATH, null, com.huawei.hicloud.cloudbackup.p104v3.server.model.Lock.class);
                setHeader("x-hw-gradeCode", (Object) str);
                setHeader("x-hw-backupkTimes", (Object) Integer.valueOf(i10));
                setHeader("x-hw-bkStartDays", (Object) Long.valueOf(j10));
                setHeader("x-hw-backupId", (Object) str2);
                long jM1688f = C0241z.m1688f(str3);
                if (jM1688f > 0) {
                    setHeader("x-hw-lastbkCompleteDays", (Object) Long.valueOf(jM1688f));
                }
                if (TextUtils.isEmpty(str4)) {
                    return;
                }
                setHeader("x-hw-flowControlCnt", (Object) str4);
            }

            public String getBackupAction() {
                return this.backupAction;
            }

            public String getBackupDeviceId() {
                return this.backupDeviceId;
            }

            /* JADX WARN: Type inference failed for: r0v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Backup$Lock$Get] */
            public Get setAvailableSpaceSize(long j10) {
                return setHeader("x-hw-availableSpaceSize", (Object) Long.valueOf(j10));
            }

            public Get setBackupAction(String str) {
                this.backupAction = str;
                return this;
            }

            public Get setBackupDeviceId(String str) {
                this.backupDeviceId = str;
                return this;
            }

            /* JADX WARN: Type inference failed for: r0v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Backup$Lock$Get] */
            public Get setBackupSize(long j10) {
                return setHeader("x-hw-backupSize", (Object) Long.valueOf(j10));
            }

            /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Backup$Lock$Get] */
            public Get setBakCategory(String str) {
                return TextUtils.isEmpty(str) ? this : setHeader("bakCategory", (Object) str);
            }

            /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Backup$Lock$Get] */
            public Get setBkByte(String str) {
                return setHeader("x-hw-bkByte", (Object) str);
            }

            /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Backup$Lock$Get] */
            public Get setBkNeedSpace(String str) {
                return setHeader("x-hw-bkNeedSpace", (Object) str);
            }

            /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Backup$Lock$Get] */
            public Get setChargeMode(String str) {
                return setHeader("x-hw-chargeMode", (Object) str);
            }

            /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Backup$Lock$Get] */
            public Get setDirtyClear(Boolean bool) {
                return setHeader("isDirtyClear", (Object) bool);
            }

            /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Backup$Lock$Get] */
            public Get setFlowControlCnt(Integer num) {
                return setHeader("x-hw-flowControlCnt", (Object) num);
            }

            /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Backup$Lock$Get] */
            public Get setFullBK(Boolean bool) {
                return setHeader("x-hw-fullBK", (Object) bool);
            }

            /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Backup$Lock$Get] */
            public Get setLastbkCompleteDays(C4644l c4644l) {
                return setHeader("x-hw-lastbkCompleteDays", (Object) c4644l);
            }

            /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Backup$Lock$Get] */
            public Get setLockAction(String str) {
                return setHeader("lockAction", (Object) str);
            }

            /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Backup$Lock$Get] */
            public Get setLockByDelDevice(int i10) {
                return setHeader("x-hw-lockByDelDevice", (Object) Integer.valueOf(i10));
            }

            /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Backup$Lock$Get] */
            public Get setLockByDelDeviceFlag(int i10) {
                return setHeader("x-hw-lockByDelDeviceFlag", (Object) Integer.valueOf(i10));
            }

            /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Backup$Lock$Get] */
            public Get setNoRefVfsFile(boolean z10) {
                return setHeader("x-hw-noRefVfsFile", (Object) Boolean.valueOf(z10));
            }

            /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Backup$Lock$Get] */
            public Get setOccupySpaceType(Integer num) {
                return num == null ? this : setHeader("occupySpaceType", (Object) num);
            }

            /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Backup$Lock$Get] */
            public Get setPackageByte(String str) {
                return setHeader("x-hw-packageByte", (Object) str);
            }

            /* JADX WARN: Type inference failed for: r0v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Backup$Lock$Get] */
            public Get setVfsRefSize(long j10) {
                return setHeader("x-hw-vfsRefSize", (Object) Long.valueOf(j10));
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
            public CloudBackupV3Request<com.huawei.hicloud.cloudbackup.p104v3.server.model.Lock> setHeader(String str, Object obj) {
                return (Get) super.setHeader(str, obj);
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

        public static class KeepLock extends CloudBackupV3Request<LockKeepResult> {
            private static final String REST_PATH = "backup/{backupAction}/device/{backupDeviceId}/lock";

            @InterfaceC4648p
            private String backupAction;

            @InterfaceC4648p
            private String backupDeviceId;

            public KeepLock(CloudBackupV3Server cloudBackupV3Server, LockCreate lockCreate) throws IOException {
                super(cloudBackupV3Server, RequestMethod.PATCH, REST_PATH, lockCreate, LockKeepResult.class);
            }

            public String getBackupAction() {
                return this.backupAction;
            }

            public String getBackupDeviceId() {
                return this.backupDeviceId;
            }

            public KeepLock setBackupAction(String str) {
                this.backupAction = str;
                return this;
            }

            public KeepLock setBackupDeviceId(String str) {
                this.backupDeviceId = str;
                return this;
            }

            /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Backup$Lock$KeepLock] */
            public KeepLock setBakCategory(String str) {
                return TextUtils.isEmpty(str) ? this : setHeader("bakCategory", (Object) str);
            }

            /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Backup$Lock$KeepLock] */
            public KeepLock setLockId(String str) {
                return setHeader("lockId", (Object) str);
            }

            /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Backup$Lock$KeepLock] */
            public KeepLock setLockInterval(Integer num) {
                return setHeader("lockInterval", (Object) num);
            }

            /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Backup$Lock$KeepLock] */
            public KeepLock setOccupySpaceType(Integer num) {
                return num == null ? this : setHeader("occupySpaceType", (Object) num);
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

        public static class VBackup {
            private CloudBackupV3Server client;

            public static class Get extends CloudBackupV3Request<Void> {
                private static final String REST_PATH = "backup/{backupAction}/device/{backupDeviceId}/vbackuplock";

                @InterfaceC4648p
                private String backupAction;

                @InterfaceC4648p
                private String backupDeviceId;

                public Get(CloudBackupV3Server cloudBackupV3Server, C11722c c11722c) throws IOException {
                    super(cloudBackupV3Server, "GET", REST_PATH, null, Void.class);
                    setHeader("x-hw-fc-dataVolume", (Object) c11722c.m69928e());
                    setHeader("x-hw-fc-power", (Object) c11722c.m69932i());
                    setHeader("x-hw-fc-power-level", (Object) c11722c.m69933j());
                    setHeader("x-hw-fc-ssid", (Object) c11722c.m69934k());
                    setHeader("x-hw-gradeCode", (Object) c11722c.m69930g());
                    setHeader("x-hw-backupkTimes", (Object) Integer.valueOf(c11722c.m69925b()));
                    setHeader("x-hw-bkStartDays", (Object) Long.valueOf(c11722c.m69927d()));
                    setHeader("x-hw-backupId", (Object) c11722c.m69926c());
                    long jM1688f = C0241z.m1688f(c11722c.m69931h());
                    if (jM1688f > 0) {
                        setHeader("x-hw-lastbkCompleteDays", (Object) Long.valueOf(jM1688f));
                    }
                    if (TextUtils.isEmpty(c11722c.m69929f())) {
                        return;
                    }
                    setHeader("x-hw-flowControlCnt", (Object) c11722c.m69929f());
                }

                public String getBackupAction() {
                    return this.backupAction;
                }

                public String getBackupDeviceId() {
                    return this.backupDeviceId;
                }

                public Get setBackupAction(String str) {
                    this.backupAction = str;
                    return this;
                }

                public Get setBackupDeviceId(String str) {
                    this.backupDeviceId = str;
                    return this;
                }

                /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Backup$Lock$VBackup$Get] */
                public Get setBakCategory(String str) {
                    return TextUtils.isEmpty(str) ? this : setHeader("bakCategory", (Object) str);
                }

                /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Backup$Lock$VBackup$Get] */
                public Get setBkByte(String str) {
                    return setHeader("x-hw-bkByte", (Object) str);
                }

                /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Backup$Lock$VBackup$Get] */
                public Get setBkNeedSpace(String str) {
                    return setHeader("x-hw-bkNeedSpace", (Object) str);
                }

                /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Backup$Lock$VBackup$Get] */
                public Get setChargeMode(String str) {
                    return setHeader("x-hw-chargeMode", (Object) str);
                }

                /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Backup$Lock$VBackup$Get] */
                public Get setDirtyClear(Boolean bool) {
                    return setHeader("isDirtyClear", (Object) bool);
                }

                /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Backup$Lock$VBackup$Get] */
                public Get setFlowControlCnt(Integer num) {
                    return setHeader("x-hw-flowControlCnt", (Object) num);
                }

                /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Backup$Lock$VBackup$Get] */
                public Get setFullBK(Boolean bool) {
                    return setHeader("x-hw-fullBK", (Object) bool);
                }

                /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Backup$Lock$VBackup$Get] */
                public Get setLastbkCompleteDays(C4644l c4644l) {
                    return setHeader("x-hw-lastbkCompleteDays", (Object) c4644l);
                }

                /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Backup$Lock$VBackup$Get] */
                public Get setLockAction(String str) {
                    return setHeader("lockAction", (Object) str);
                }

                /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Backup$Lock$VBackup$Get] */
                public Get setOccupySpaceType(Integer num) {
                    return num == null ? this : setHeader("occupySpaceType", (Object) num);
                }

                /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Backup$Lock$VBackup$Get] */
                public Get setPackageByte(String str) {
                    return setHeader("x-hw-packageByte", (Object) str);
                }

                @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
                public CloudBackupV3Request<Void> setFields(String str) {
                    return (Get) super.setFields(str);
                }

                @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
                public CloudBackupV3Request<Void> setForm(String str) {
                    return (Get) super.setForm(str);
                }

                @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
                public CloudBackupV3Request<Void> setHeader(String str, Object obj) {
                    return (Get) super.setHeader(str, obj);
                }

                @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
                public CloudBackupV3Request<Void> setTraceId(String str) {
                    return (Get) super.setTraceId(str);
                }

                @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request, p614ri.AbstractC12513b, p579qi.AbstractC12361b, com.huawei.cloud.base.util.C4646n
                public Get set(String str, Object obj) {
                    return (Get) super.set(str, obj);
                }
            }

            public VBackup(CloudBackupV3Server cloudBackupV3Server) {
                this.client = cloudBackupV3Server;
            }

            public Get get(C11722c c11722c) throws IOException {
                return new Get(this.client, c11722c);
            }
        }

        public Lock(CloudBackupV3Server cloudBackupV3Server) {
            this.client = cloudBackupV3Server;
        }

        public Delete delete(String str) throws IOException {
            return new Delete(this.client, str);
        }

        public Get get(String str, int i10, long j10, String str2, String str3, String str4) throws IOException {
            return new Get(this.client, str, i10, j10, str2, str3, str4);
        }

        public KeepLock keepLock(LockCreate lockCreate) throws IOException {
            return new KeepLock(this.client, lockCreate);
        }

        public VBackup vBackup() {
            return new VBackup(this.client);
        }
    }

    public Backup(CloudBackupV3Server cloudBackupV3Server) {
        this.client = cloudBackupV3Server;
    }

    public Asset asset() {
        return new Asset(this.client);
    }

    public Device device() {
        return new Device(this.client);
    }

    public Lock lock() {
        return new Lock(this.client);
    }
}
