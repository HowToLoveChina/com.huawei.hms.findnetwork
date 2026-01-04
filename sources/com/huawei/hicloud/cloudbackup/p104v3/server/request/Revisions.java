package com.huawei.hicloud.cloudbackup.p104v3.server.request;

import android.text.TextUtils;
import com.huawei.android.hicloud.drive.clouddisk.expand.RequestMethod;
import com.huawei.cloud.base.util.InterfaceC4648p;
import com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request;
import com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Server;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.Asset;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.RevisionCreate;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.RevisionFinish;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.RevisionRefresh;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import java.io.IOException;
import java.util.List;
import p709vj.C13452e;

/* loaded from: classes6.dex */
public class Revisions {
    public CloudBackupV3Server client;

    public static class Create extends CloudBackupV3Request<Asset> {
        private static final String REST_PATH = "backup/{backupAction}/kind/{kindId}/record/{recordId}/asset/{assetId}";

        @InterfaceC4648p
        private Boolean antiMdr;

        @InterfaceC4648p
        private String assetId;

        @InterfaceC4648p
        private String backupAction;

        @InterfaceC4648p
        private String kindId;

        @InterfaceC4648p
        private String recordId;

        public Create(CloudBackupV3Server cloudBackupV3Server, RevisionCreate revisionCreate) throws IOException {
            super(cloudBackupV3Server, "POST", REST_PATH, revisionCreate, Asset.class);
        }

        public Boolean getAntiMdr() {
            return this.antiMdr;
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

        /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Revisions$Create] */
        public Create setAndroidVer(String str) {
            return setHeader("androidVer", (Object) str);
        }

        public Create setAntiMdr(Boolean bool) {
            this.antiMdr = bool;
            return this;
        }

        public Create setAssetId(String str) {
            this.assetId = str;
            return this;
        }

        public Create setBackupAction(String str) {
            this.backupAction = str;
            return this;
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Revisions$Create] */
        public Create setBakCategory(String str) {
            return TextUtils.isEmpty(str) ? this : setHeader("bakCategory", (Object) str);
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Revisions$Create] */
        public Create setEmuiVer(String str) {
            return setHeader("emuiVer", (Object) str);
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Revisions$Create] */
        public Create setInterimChannel(Integer num) {
            return num == null ? this : setHeader("x-hw-channel", (Object) num);
        }

        public Create setKindId(String str) {
            this.kindId = str;
            return this;
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Revisions$Create] */
        public Create setLockId(String str) {
            return setHeader("lockId", (Object) str);
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Revisions$Create] */
        public Create setLockInterval(Integer num) {
            return setHeader("lockInterval", (Object) num);
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Revisions$Create] */
        public Create setOccupySpaceType(Integer num) {
            return num == null ? this : setHeader("occupySpaceType", (Object) num);
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Revisions$Create] */
        public Create setPackageName(String str) {
            return setHeader("packageName", (Object) str);
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Revisions$Create] */
        public Create setPackageOriginHash(String str) {
            return setHeader("packageOriginHash", (Object) str);
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Revisions$Create] */
        public Create setPackageOriginHashType(String str) {
            return setHeader("packageOriginHashType", (Object) str);
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Revisions$Create] */
        public Create setPackageOriginLength(String str) {
            return setHeader("packageOriginLength", (Object) str);
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Revisions$Create] */
        public Create setPackageSsha2(String str) {
            return !TextUtils.isEmpty(str) ? setHeader("x-hw-package-ssha2", (Object) str) : this;
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Revisions$Create] */
        public Create setPackageVersion(String str) {
            return setHeader("packageVersion", (Object) str);
        }

        public Create setRecordId(String str) {
            this.recordId = str;
            return this;
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Revisions$Create] */
        public Create setXHwBackupPackageName(String str) {
            return setHeader("x-hw-backup-packageName", (Object) str);
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Revisions$Create] */
        public Create setXHwBackupid(String str) {
            return setHeader("x-hw-backupId", (Object) str);
        }

        @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
        public CloudBackupV3Request<Asset> setFields(String str) {
            return (Create) super.setFields(str);
        }

        @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
        public CloudBackupV3Request<Asset> setForm(String str) {
            return (Create) super.setForm(str);
        }

        @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
        public CloudBackupV3Request<Asset> setHeader(String str, Object obj) {
            return (Create) super.setHeader(str, obj);
        }

        @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
        public CloudBackupV3Request<Asset> setTraceId(String str) {
            return (Create) super.setTraceId(str);
        }

        @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request, p614ri.AbstractC12513b, p579qi.AbstractC12361b, com.huawei.cloud.base.util.C4646n
        public Create set(String str, Object obj) {
            return (Create) super.set(str, obj);
        }
    }

    public static class Finish extends CloudBackupV3Request<Asset> {
        private static final String REST_PATH = "backup/{backupAction}/kind/{kindId}/record/{recordId}/asset/{assetId}/version/{versionId}";

        @InterfaceC4648p
        private String assetId;

        @InterfaceC4648p
        private String backupAction;

        @InterfaceC4648p
        private String kindId;

        @InterfaceC4648p
        private String recordId;

        @InterfaceC4648p
        private String usage;

        @InterfaceC4648p
        private String versionId;

        public Finish(CloudBackupV3Server cloudBackupV3Server, RevisionFinish revisionFinish) throws IOException {
            super(cloudBackupV3Server, RequestMethod.PATCH, REST_PATH, revisionFinish, Asset.class);
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

        public String getUsage() {
            return this.usage;
        }

        public String getVersionId() {
            return this.versionId;
        }

        public Finish setAssetId(String str) {
            this.assetId = str;
            return this;
        }

        public Finish setBackupAction(String str) {
            this.backupAction = str;
            return this;
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Revisions$Finish] */
        public Finish setBakCategory(String str) {
            return TextUtils.isEmpty(str) ? this : setHeader("bakCategory", (Object) str);
        }

        public Finish setKindId(String str) {
            this.kindId = str;
            return this;
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Revisions$Finish] */
        public Finish setLockId(String str) {
            return setHeader("lockId", (Object) str);
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Revisions$Finish] */
        public Finish setLockInterval(Integer num) {
            return setHeader("lockInterval", (Object) num);
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Revisions$Finish] */
        public Finish setOccupySpaceType(Integer num) {
            return num == null ? this : setHeader("occupySpaceType", (Object) num);
        }

        public Finish setRecordId(String str) {
            this.recordId = str;
            return this;
        }

        public Finish setUsage(String str) {
            this.usage = str;
            return this;
        }

        public Finish setVersionId(String str) {
            this.versionId = str;
            return this;
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Revisions$Finish] */
        public Finish setXHwBackupPackageName(String str) {
            return setHeader("x-hw-backup-packageName", (Object) str);
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Revisions$Finish] */
        public Finish setXHwBackupid(String str) {
            return setHeader("x-hw-backupId", (Object) str);
        }

        @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
        public CloudBackupV3Request<Asset> setFields(String str) {
            return (Finish) super.setFields(str);
        }

        @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
        public CloudBackupV3Request<Asset> setForm(String str) {
            return (Finish) super.setForm(str);
        }

        @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
        public CloudBackupV3Request<Asset> setHeader(String str, Object obj) {
            return (Finish) super.setHeader(str, obj);
        }

        @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
        public CloudBackupV3Request<Asset> setTraceId(String str) {
            return (Finish) super.setTraceId(str);
        }

        @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request, p614ri.AbstractC12513b, p579qi.AbstractC12361b, com.huawei.cloud.base.util.C4646n
        public Finish set(String str, Object obj) {
            return (Finish) super.set(str, obj);
        }
    }

    public static class Get extends CloudBackupV3Request<Asset> {
        private static final String REST_PATH = "backup/{backupAction}/kind/{kindId}/record/{recordId}/asset/{assetId}/version/{versionId}";

        @InterfaceC4648p
        private String assetId;

        @InterfaceC4648p
        private Boolean autofix;

        @InterfaceC4648p
        private String backupAction;

        @InterfaceC4648p
        private String kindId;

        @InterfaceC4648p
        private String mode;

        @InterfaceC4648p
        private List<String> objectIds;

        @InterfaceC4648p
        private String recordId;

        @InterfaceC4648p
        private String versionId;

        public Get(CloudBackupV3Server cloudBackupV3Server) throws IOException {
            super(cloudBackupV3Server, "GET", REST_PATH, null, Asset.class);
            setHeader(JsbMapKeyNames.H5_USER_ID, (Object) C13452e.m80781L().m80971t0());
            setMode("download");
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

        public String getMode() {
            return this.mode;
        }

        public List<String> getObjectIds() {
            return this.objectIds;
        }

        public String getRecordId() {
            return this.recordId;
        }

        public String getVersionId() {
            return this.versionId;
        }

        public boolean isAutoFix() {
            return this.autofix.booleanValue();
        }

        public Get setAssetId(String str) {
            this.assetId = str;
            return this;
        }

        public void setAutoFix(boolean z10) {
            this.autofix = Boolean.valueOf(z10);
        }

        public Get setBackupAction(String str) {
            this.backupAction = str;
            return this;
        }

        public Get setKindId(String str) {
            this.kindId = str;
            return this;
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Revisions$Get] */
        public Get setLockId(String str) {
            return setHeader("lockId", (Object) str);
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Revisions$Get] */
        public Get setLockInterval(Integer num) {
            return setHeader("lockInterval", (Object) num);
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

        public Get setVersionId(String str) {
            this.versionId = str;
            return this;
        }

        @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
        public CloudBackupV3Request<Asset> setFields(String str) {
            return (Get) super.setFields(str);
        }

        @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
        public CloudBackupV3Request<Asset> setHeader(String str, Object obj) {
            return (Get) super.setHeader(str, obj);
        }

        @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
        public CloudBackupV3Request<Asset> setTraceId(String str) {
            return (Get) super.setTraceId(str);
        }

        @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request, p614ri.AbstractC12513b, p579qi.AbstractC12361b, com.huawei.cloud.base.util.C4646n
        public Get set(String str, Object obj) {
            return (Get) super.set(str, obj);
        }
    }

    public static class Refresh extends CloudBackupV3Request<Asset> {
        private static final String REST_PATH = "backup/{backupAction}/kind/{kindId}/record/{recordId}/asset/{assetId}/version/{versionId}/refresh";

        @InterfaceC4648p
        private String assetId;

        @InterfaceC4648p
        private String backupAction;

        @InterfaceC4648p
        private String kindId;

        @InterfaceC4648p
        private List<String> objectIds;

        @InterfaceC4648p
        private String recordId;

        @InterfaceC4648p
        private String usage;

        @InterfaceC4648p
        private String versionId;

        public Refresh(CloudBackupV3Server cloudBackupV3Server, RevisionRefresh revisionRefresh) throws IOException {
            super(cloudBackupV3Server, "POST", REST_PATH, revisionRefresh, Asset.class);
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

        public String getUsage() {
            return this.usage;
        }

        public String getVersionId() {
            return this.versionId;
        }

        public Refresh setAssetId(String str) {
            this.assetId = str;
            return this;
        }

        public Refresh setBackupAction(String str) {
            this.backupAction = str;
            return this;
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Revisions$Refresh] */
        public Refresh setBakCategory(String str) {
            return TextUtils.isEmpty(str) ? this : setHeader("bakCategory", (Object) str);
        }

        public Refresh setKindId(String str) {
            this.kindId = str;
            return this;
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Revisions$Refresh] */
        public Refresh setLockId(String str) {
            return setHeader("lockId", (Object) str);
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Revisions$Refresh] */
        public Refresh setLockInterval(Integer num) {
            return setHeader("lockInterval", (Object) num);
        }

        public Refresh setObjectIds(List<String> list) {
            this.objectIds = list;
            return this;
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Revisions$Refresh] */
        public Refresh setOccupySpaceType(Integer num) {
            return num == null ? this : setHeader("occupySpaceType", (Object) num);
        }

        public Refresh setRecordId(String str) {
            this.recordId = str;
            return this;
        }

        public Refresh setUsage(String str) {
            this.usage = str;
            return this;
        }

        public Refresh setVersionId(String str) {
            this.versionId = str;
            return this;
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Revisions$Refresh] */
        public Refresh setXHwBackupPackageName(String str) {
            return setHeader("x-hw-backup-packageName", (Object) str);
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Revisions$Refresh] */
        public Refresh setXHwBackupid(String str) {
            return setHeader("x-hw-backupId", (Object) str);
        }

        @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
        public CloudBackupV3Request<Asset> setFields(String str) {
            return (Refresh) super.setFields(str);
        }

        @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
        public CloudBackupV3Request<Asset> setForm(String str) {
            return (Refresh) super.setForm(str);
        }

        @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
        public CloudBackupV3Request<Asset> setHeader(String str, Object obj) {
            return (Refresh) super.setHeader(str, obj);
        }

        @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
        public CloudBackupV3Request<Asset> setTraceId(String str) {
            return (Refresh) super.setTraceId(str);
        }

        @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request, p614ri.AbstractC12513b, p579qi.AbstractC12361b, com.huawei.cloud.base.util.C4646n
        public Refresh set(String str, Object obj) {
            return (Refresh) super.set(str, obj);
        }
    }

    public Revisions(CloudBackupV3Server cloudBackupV3Server) {
        this.client = cloudBackupV3Server;
    }

    public Create create(RevisionCreate revisionCreate) throws IOException {
        return new Create(this.client, revisionCreate);
    }

    public Finish finish(RevisionFinish revisionFinish) throws IOException {
        return new Finish(this.client, revisionFinish);
    }

    public Get get() throws IOException {
        return new Get(this.client);
    }

    public Refresh refresh(RevisionRefresh revisionRefresh) throws IOException {
        return new Refresh(this.client, revisionRefresh);
    }
}
