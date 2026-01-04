package com.huawei.hicloud.cloudbackup.p104v3.server.request;

import android.text.TextUtils;
import com.huawei.android.hicloud.drive.clouddisk.expand.RequestMethod;
import com.huawei.cloud.base.util.InterfaceC4648p;
import com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request;
import com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Server;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.FileCreate;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.FileDelete;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.FileFinish;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.FileList;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.FileReuse;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.IdTransferRequest;
import com.huawei.hicloud.notification.util.GeneralRedirectUtil;
import java.io.IOException;

/* loaded from: classes6.dex */
public class File {
    private CloudBackupV3Server client;

    public static class Create extends CloudBackupV3Request<com.huawei.hicloud.cloudbackup.p104v3.server.model.File> {
        private static final String REST_PATH = "backup/{backupAction}/device/{backupDeviceId}/file";

        @InterfaceC4648p
        private boolean antiMdr;

        @InterfaceC4648p
        private String backupAction;

        @InterfaceC4648p
        private String backupDeviceId;

        @InterfaceC4648p
        private String backupVersion;

        public Create(CloudBackupV3Server cloudBackupV3Server, FileCreate fileCreate) throws IOException {
            super(cloudBackupV3Server, "POST", REST_PATH, fileCreate, com.huawei.hicloud.cloudbackup.p104v3.server.model.File.class);
        }

        public boolean getAntiMdr() {
            return this.antiMdr;
        }

        public String getBackupAction() {
            return this.backupAction;
        }

        public String getBackupDeviceId() {
            return this.backupDeviceId;
        }

        public Create setAntiMdr(boolean z10) {
            this.antiMdr = z10;
            return this;
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.File$Create] */
        public Create setBackId(String str) {
            return setHeader(GeneralRedirectUtil.BAK_ID, (Object) str);
        }

        public Create setBackupAction(String str) {
            this.backupAction = str;
            return this;
        }

        public Create setBackupDeviceId(String str) {
            this.backupDeviceId = str;
            return this;
        }

        public Create setBackupVersion(String str) {
            this.backupVersion = str;
            return this;
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.File$Create] */
        public Create setBakCategory(String str) {
            return TextUtils.isEmpty(str) ? this : setHeader("bakCategory", (Object) str);
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.File$Create] */
        public Create setGradeCode(String str) {
            return setHeader("x-hw-gradeCode", (Object) str);
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.File$Create] */
        public Create setInterimChannel(Integer num) {
            return num == null ? this : setHeader("x-hw-channel", (Object) num);
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.File$Create] */
        public Create setLockId(String str) {
            return setHeader("lockId", (Object) str);
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.File$Create] */
        public Create setLockInterval(Integer num) {
            return setHeader("lockInterval", (Object) num);
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.File$Create] */
        public Create setOccupySpaceType(Integer num) {
            return num == null ? this : setHeader("occupySpaceType", (Object) num);
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.File$Create] */
        public Create setXHwBackupPackageName(String str) {
            return setHeader("x-hw-backup-packageName", (Object) str);
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.File$Create] */
        public Create setXHwBackupid(String str) {
            return setHeader("x-hw-backupId", (Object) str);
        }

        @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
        public CloudBackupV3Request<com.huawei.hicloud.cloudbackup.p104v3.server.model.File> setFields(String str) {
            return (Create) super.setFields(str);
        }

        @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
        public CloudBackupV3Request<com.huawei.hicloud.cloudbackup.p104v3.server.model.File> setForm(String str) {
            return (Create) super.setForm(str);
        }

        @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
        public CloudBackupV3Request<com.huawei.hicloud.cloudbackup.p104v3.server.model.File> setHeader(String str, Object obj) {
            return (Create) super.setHeader(str, obj);
        }

        @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
        public CloudBackupV3Request<com.huawei.hicloud.cloudbackup.p104v3.server.model.File> setTraceId(String str) {
            return (Create) super.setTraceId(str);
        }

        @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request, p614ri.AbstractC12513b, p579qi.AbstractC12361b, com.huawei.cloud.base.util.C4646n
        public Create set(String str, Object obj) {
            return (Create) super.set(str, obj);
        }
    }

    public static class Delete extends CloudBackupV3Request<Void> {
        private static final String REST_PATH = "backup/{backupAction}/device/{backupDeviceId}/file";

        @InterfaceC4648p
        private String backupAction;

        @InterfaceC4648p
        private String backupDeviceId;

        public Delete(CloudBackupV3Server cloudBackupV3Server, FileDelete fileDelete) throws IOException {
            super(cloudBackupV3Server, "DELETE", REST_PATH, fileDelete, Void.class);
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

        /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.File$Delete] */
        public Delete setBakCategory(String str) {
            return TextUtils.isEmpty(str) ? this : setHeader("bakCategory", (Object) str);
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.File$Delete] */
        public Delete setLockId(String str) {
            return setHeader("lockId", (Object) str);
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.File$Delete] */
        public Delete setLockInterval(Integer num) {
            return setHeader("lockInterval", (Object) num);
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.File$Delete] */
        public Delete setOccupySpaceType(Integer num) {
            return num == null ? this : setHeader("occupySpaceType", (Object) num);
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.File$Delete] */
        public Delete setXHwBackupPackageName(String str) {
            return setHeader("x-hw-backup-packageName", (Object) str);
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.File$Delete] */
        public Delete setXHwBackupid(String str) {
            return setHeader("x-hw-backupId", (Object) str);
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

    public static class Finish extends CloudBackupV3Request<com.huawei.hicloud.cloudbackup.p104v3.server.model.File> {
        private static final String REST_PATH = "backup/{backupAction}/device/{backupDeviceId}/file/{fileId}";

        @InterfaceC4648p
        private String backupAction;

        @InterfaceC4648p
        private String backupDeviceId;

        @InterfaceC4648p
        private String fileId;

        public Finish(CloudBackupV3Server cloudBackupV3Server, FileFinish fileFinish) throws IOException {
            super(cloudBackupV3Server, RequestMethod.PATCH, REST_PATH, fileFinish, com.huawei.hicloud.cloudbackup.p104v3.server.model.File.class);
        }

        public String getBackupAction() {
            return this.backupAction;
        }

        public String getBackupDeviceId() {
            return this.backupDeviceId;
        }

        public String getFileId() {
            return this.fileId;
        }

        public Finish setBackupAction(String str) {
            this.backupAction = str;
            return this;
        }

        public Finish setBackupDeviceId(String str) {
            this.backupDeviceId = str;
            return this;
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.File$Finish] */
        public Finish setBakCategory(String str) {
            return TextUtils.isEmpty(str) ? this : setHeader("bakCategory", (Object) str);
        }

        public Finish setFileId(String str) {
            this.fileId = str;
            return this;
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.File$Finish] */
        public Finish setLockId(String str) {
            return setHeader("lockId", (Object) str);
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.File$Finish] */
        public Finish setLockInterval(Integer num) {
            return setHeader("lockInterval", (Object) num);
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.File$Finish] */
        public Finish setOccupySpaceType(Integer num) {
            return num == null ? this : setHeader("occupySpaceType", (Object) num);
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.File$Finish] */
        public Finish setXHwBackupPackageName(String str) {
            return setHeader("x-hw-backup-packageName", (Object) str);
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.File$Finish] */
        public Finish setXHwBackupid(String str) {
            return setHeader("x-hw-backupId", (Object) str);
        }

        @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
        public CloudBackupV3Request<com.huawei.hicloud.cloudbackup.p104v3.server.model.File> setFields(String str) {
            return (Finish) super.setFields(str);
        }

        @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
        public CloudBackupV3Request<com.huawei.hicloud.cloudbackup.p104v3.server.model.File> setForm(String str) {
            return (Finish) super.setForm(str);
        }

        @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
        public CloudBackupV3Request<com.huawei.hicloud.cloudbackup.p104v3.server.model.File> setHeader(String str, Object obj) {
            return (Finish) super.setHeader(str, obj);
        }

        @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
        public CloudBackupV3Request<com.huawei.hicloud.cloudbackup.p104v3.server.model.File> setTraceId(String str) {
            return (Finish) super.setTraceId(str);
        }

        @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request, p614ri.AbstractC12513b, p579qi.AbstractC12361b, com.huawei.cloud.base.util.C4646n
        public Finish set(String str, Object obj) {
            return (Finish) super.set(str, obj);
        }
    }

    public static class Get extends CloudBackupV3Request<com.huawei.hicloud.cloudbackup.p104v3.server.model.File> {
        private static final String REST_PATH = "backup/{backupAction}/device/{backupDeviceId}/file/{fileId}";

        @InterfaceC4648p
        private String backupAction;

        @InterfaceC4648p
        private String backupDeviceId;

        @InterfaceC4648p
        private String fileId;

        public Get(CloudBackupV3Server cloudBackupV3Server) throws IOException {
            super(cloudBackupV3Server, "GET", REST_PATH, null, com.huawei.hicloud.cloudbackup.p104v3.server.model.File.class);
        }

        public String getBackupAction() {
            return this.backupAction;
        }

        public String getBackupDeviceId() {
            return this.backupDeviceId;
        }

        public String getFileId() {
            return this.fileId;
        }

        public Get setBackupAction(String str) {
            this.backupAction = str;
            return this;
        }

        public Get setBackupDeviceId(String str) {
            this.backupDeviceId = str;
            return this;
        }

        public Get setFileId(String str) {
            this.fileId = str;
            return this;
        }

        @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
        public CloudBackupV3Request<com.huawei.hicloud.cloudbackup.p104v3.server.model.File> setFields(String str) {
            return (Get) super.setFields(str);
        }

        @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
        public CloudBackupV3Request<com.huawei.hicloud.cloudbackup.p104v3.server.model.File> setForm(String str) {
            return (Get) super.setForm(str);
        }

        @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
        public CloudBackupV3Request<com.huawei.hicloud.cloudbackup.p104v3.server.model.File> setHeader(String str, Object obj) {
            return (Get) super.setHeader(str, obj);
        }

        @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
        public CloudBackupV3Request<com.huawei.hicloud.cloudbackup.p104v3.server.model.File> setTraceId(String str) {
            return (Get) super.setTraceId(str);
        }

        @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request, p614ri.AbstractC12513b, p579qi.AbstractC12361b, com.huawei.cloud.base.util.C4646n
        public Get set(String str, Object obj) {
            return (Get) super.set(str, obj);
        }
    }

    public static class IdTransfer extends CloudBackupV3Request<com.huawei.hicloud.cloudbackup.p104v3.server.model.IdTransfer> {
        private static final String REST_PATH = "backup/{backupAction}/device/{backupDeviceId}/files/idTransfer";

        @InterfaceC4648p
        private String backupAction;

        @InterfaceC4648p
        private String backupDeviceId;

        public IdTransfer(CloudBackupV3Server cloudBackupV3Server, IdTransferRequest idTransferRequest) throws IOException {
            super(cloudBackupV3Server, "POST", REST_PATH, idTransferRequest, com.huawei.hicloud.cloudbackup.p104v3.server.model.IdTransfer.class);
        }

        public String getBackupAction() {
            return this.backupAction;
        }

        public String getBackupDeviceId() {
            return this.backupDeviceId;
        }

        public IdTransfer setBackupAction(String str) {
            this.backupAction = str;
            return this;
        }

        public IdTransfer setBackupDeviceId(String str) {
            this.backupDeviceId = str;
            return this;
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.File$IdTransfer] */
        public IdTransfer setLockId(String str) {
            return setHeader("lockId", (Object) str);
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.File$IdTransfer] */
        public IdTransfer setLockInterval(Integer num) {
            return setHeader("lockInterval", (Object) num);
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.File$IdTransfer] */
        public IdTransfer setXHwBackupPackageName(String str) {
            return setHeader("x-hw-backup-packageName", (Object) str);
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.File$IdTransfer] */
        public IdTransfer setXHwBackupid(String str) {
            return setHeader("x-hw-backupId", (Object) str);
        }

        @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
        public CloudBackupV3Request<com.huawei.hicloud.cloudbackup.p104v3.server.model.IdTransfer> setFields(String str) {
            return (IdTransfer) super.setFields(str);
        }

        @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
        public CloudBackupV3Request<com.huawei.hicloud.cloudbackup.p104v3.server.model.IdTransfer> setForm(String str) {
            return (IdTransfer) super.setForm(str);
        }

        @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
        public CloudBackupV3Request<com.huawei.hicloud.cloudbackup.p104v3.server.model.IdTransfer> setHeader(String str, Object obj) {
            return (IdTransfer) super.setHeader(str, obj);
        }

        @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
        public CloudBackupV3Request<com.huawei.hicloud.cloudbackup.p104v3.server.model.IdTransfer> setTraceId(String str) {
            return (IdTransfer) super.setTraceId(str);
        }

        @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request, p614ri.AbstractC12513b, p579qi.AbstractC12361b, com.huawei.cloud.base.util.C4646n
        public IdTransfer set(String str, Object obj) {
            return (IdTransfer) super.set(str, obj);
        }
    }

    public static class List extends CloudBackupV3Request<FileList> {
        private static final String REST_PATH = "backup/{backupAction}/device/{backupDeviceId}/files";

        @InterfaceC4648p
        private String backupAction;

        @InterfaceC4648p
        private String backupDeviceId;

        @InterfaceC4648p
        private String cursor;

        @InterfaceC4648p
        private Integer pageSize;

        public List(CloudBackupV3Server cloudBackupV3Server, String str) throws IOException {
            super(cloudBackupV3Server, "GET", REST_PATH, null, FileList.class);
            setHeader("x-hw-query-lost", (Object) str);
        }

        public String getBackupAction() {
            return this.backupAction;
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

        public List setBackupAction(String str) {
            this.backupAction = str;
            return this;
        }

        public List setBackupDeviceId(String str) {
            this.backupDeviceId = str;
            return this;
        }

        public List setCursor(String str) {
            this.cursor = str;
            return this;
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.File$List] */
        public List setLockId(String str) {
            return setHeader("lockId", (Object) str);
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.File$List] */
        public List setLockInterval(Integer num) {
            return setHeader("lockInterval", (Object) num);
        }

        public List setPageSize(Integer num) {
            this.pageSize = num;
            return this;
        }

        @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
        public CloudBackupV3Request<FileList> setFields(String str) {
            return (List) super.setFields(str);
        }

        @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
        public CloudBackupV3Request<FileList> setForm(String str) {
            return (List) super.setForm(str);
        }

        @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
        public CloudBackupV3Request<FileList> setHeader(String str, Object obj) {
            return (List) super.setHeader(str, obj);
        }

        @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
        public CloudBackupV3Request<FileList> setTraceId(String str) {
            return (List) super.setTraceId(str);
        }

        @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request, p614ri.AbstractC12513b, p579qi.AbstractC12361b, com.huawei.cloud.base.util.C4646n
        public List set(String str, Object obj) {
            return (List) super.set(str, obj);
        }
    }

    public static class Reuse extends CloudBackupV3Request<Void> {
        private static final String REST_PATH = "backup/{backupAction}/device/{backupDeviceId}/reuse/files";

        @InterfaceC4648p
        private String backupAction;

        @InterfaceC4648p
        private String backupDeviceId;

        public Reuse(CloudBackupV3Server cloudBackupV3Server, FileReuse fileReuse) throws IOException {
            super(cloudBackupV3Server, "POST", REST_PATH, fileReuse, Void.class);
        }

        public Reuse setBackupAction(String str) {
            this.backupAction = str;
            return this;
        }

        public Reuse setBackupDeviceId(String str) {
            this.backupDeviceId = str;
            return this;
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.File$Reuse] */
        public Reuse setBakCategory(String str) {
            return TextUtils.isEmpty(str) ? this : setHeader("bakCategory", (Object) str);
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.File$Reuse] */
        public Reuse setLockId(String str) {
            return setHeader("lockId", (Object) str);
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.File$Reuse] */
        public Reuse setOccupySpaceType(Integer num) {
            return num == null ? this : setHeader("occupySpaceType", (Object) num);
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.File$Reuse] */
        public Reuse setXHwBackupPackageName(String str) {
            return setHeader("x-hw-backup-packageName", (Object) str);
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.File$Reuse] */
        public Reuse setXHwBackupid(String str) {
            return setHeader("x-hw-backupId", (Object) str);
        }

        @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
        public CloudBackupV3Request<Void> setHeader(String str, Object obj) {
            return (Reuse) super.setHeader(str, obj);
        }
    }

    public File(CloudBackupV3Server cloudBackupV3Server) {
        this.client = cloudBackupV3Server;
    }

    public Create create(FileCreate fileCreate) throws IOException {
        return new Create(this.client, fileCreate);
    }

    public Delete delete(FileDelete fileDelete) throws IOException {
        return new Delete(this.client, fileDelete);
    }

    public Finish finish(FileFinish fileFinish) throws IOException {
        return new Finish(this.client, fileFinish);
    }

    public Get get() throws IOException {
        return new Get(this.client);
    }

    public IdTransfer idTransfer(IdTransferRequest idTransferRequest) throws IOException {
        return new IdTransfer(this.client, idTransferRequest);
    }

    public List list(String str) throws IOException {
        return new List(this.client, str);
    }

    public Reuse reuse(FileReuse fileReuse) throws IOException {
        return new Reuse(this.client, fileReuse);
    }
}
