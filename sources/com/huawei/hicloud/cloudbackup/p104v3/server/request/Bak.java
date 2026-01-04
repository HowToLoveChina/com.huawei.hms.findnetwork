package com.huawei.hicloud.cloudbackup.p104v3.server.request;

import android.text.TextUtils;
import com.huawei.android.hicloud.drive.clouddisk.expand.RequestMethod;
import com.huawei.cloud.base.util.InterfaceC4648p;
import com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request;
import com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Server;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.AppCreate;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.AppFinish;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.AppList;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.AppRefresh;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.BakCreate;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.BakFinish;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.BakList;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.BakRefresh;
import java.io.IOException;

/* loaded from: classes6.dex */
public class Bak {
    private CloudBackupV3Server client;

    public static class App {
        private CloudBackupV3Server client;

        public static class Copy extends CloudBackupV3Request<com.huawei.hicloud.cloudbackup.p104v3.server.model.App> {
            private static final String REST_PATH = "backup/{backupAction}/device/{backupDeviceId}/bak/{bakId}/app/copy";

            @InterfaceC4648p
            private String backupAction;

            @InterfaceC4648p
            private String backupDeviceId;

            @InterfaceC4648p
            private String bakId;

            public Copy(CloudBackupV3Server cloudBackupV3Server, AppCreate appCreate) throws IOException {
                super(cloudBackupV3Server, "POST", REST_PATH, appCreate, com.huawei.hicloud.cloudbackup.p104v3.server.model.App.class);
            }

            public String getBackupAction() {
                return this.backupAction;
            }

            public String getBackupDeviceId() {
                return this.backupDeviceId;
            }

            public String getBakId() {
                return this.bakId;
            }

            public Copy setBackupAction(String str) {
                this.backupAction = str;
                return this;
            }

            public Copy setBackupDeviceId(String str) {
                this.backupDeviceId = str;
                return this;
            }

            public Copy setBakId(String str) {
                this.bakId = str;
                return this;
            }

            /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Bak$App$Copy] */
            public Copy setLockId(String str) {
                return setHeader("lockId", (Object) str);
            }

            /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Bak$App$Copy] */
            public Copy setLockInterval(Integer num) {
                return setHeader("lockInterval", (Object) num);
            }

            /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Bak$App$Copy] */
            public Copy setPackageSsha2(String str) {
                return !TextUtils.isEmpty(str) ? setHeader("x-hw-package-ssha2", (Object) str) : this;
            }

            /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Bak$App$Copy] */
            public Copy setSourceAppId(String str) {
                return setHeader("x-hw-sourceAppId", (Object) str);
            }

            /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Bak$App$Copy] */
            public Copy setSourceBakId(String str) {
                return setHeader("x-hw-sourceBakId", (Object) str);
            }

            /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Bak$App$Copy] */
            public Copy setXHwBackupId(String str) {
                return setHeader("x-hw-backupId", (Object) str);
            }

            /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Bak$App$Copy] */
            public Copy setXHwBackupPackageName(String str) {
                return setHeader("x-hw-backup-packageName", (Object) str);
            }

            @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
            public CloudBackupV3Request<com.huawei.hicloud.cloudbackup.p104v3.server.model.App> setFields(String str) {
                return (Copy) super.setFields(str);
            }

            @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
            public CloudBackupV3Request<com.huawei.hicloud.cloudbackup.p104v3.server.model.App> setForm(String str) {
                return (Copy) super.setForm(str);
            }

            @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
            public CloudBackupV3Request<com.huawei.hicloud.cloudbackup.p104v3.server.model.App> setHeader(String str, Object obj) {
                return (Copy) super.setHeader(str, obj);
            }

            @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
            public CloudBackupV3Request<com.huawei.hicloud.cloudbackup.p104v3.server.model.App> setTraceId(String str) {
                return (Copy) super.setTraceId(str);
            }

            @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request, p614ri.AbstractC12513b, p579qi.AbstractC12361b, com.huawei.cloud.base.util.C4646n
            public Copy set(String str, Object obj) {
                return (Copy) super.set(str, obj);
            }
        }

        public static class Create extends CloudBackupV3Request<com.huawei.hicloud.cloudbackup.p104v3.server.model.App> {
            private static final String REST_PATH = "backup/{backupAction}/device/{backupDeviceId}/bak/{bakId}/app";

            @InterfaceC4648p
            private String backupAction;

            @InterfaceC4648p
            private String backupDeviceId;

            @InterfaceC4648p
            private String bakId;

            public Create(CloudBackupV3Server cloudBackupV3Server, AppCreate appCreate) throws IOException {
                super(cloudBackupV3Server, "POST", REST_PATH, appCreate, com.huawei.hicloud.cloudbackup.p104v3.server.model.App.class);
            }

            public String getBackupAction() {
                return this.backupAction;
            }

            public String getBackupDeviceId() {
                return this.backupDeviceId;
            }

            public String getBakId() {
                return this.bakId;
            }

            public Create setBackupAction(String str) {
                this.backupAction = str;
                return this;
            }

            public Create setBackupDeviceId(String str) {
                this.backupDeviceId = str;
                return this;
            }

            /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Bak$App$Create] */
            public Create setBakCategory(String str) {
                return TextUtils.isEmpty(str) ? this : setHeader("bakCategory", (Object) str);
            }

            public Create setBakId(String str) {
                this.bakId = str;
                return this;
            }

            /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Bak$App$Create] */
            public Create setLockId(String str) {
                return setHeader("lockId", (Object) str);
            }

            /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Bak$App$Create] */
            public Create setLockInterval(Integer num) {
                return setHeader("lockInterval", (Object) num);
            }

            /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Bak$App$Create] */
            public Create setOccupySpaceType(Integer num) {
                return num == null ? this : setHeader("occupySpaceType", (Object) num);
            }

            /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Bak$App$Create] */
            public Create setXHwBackupPackageName(String str) {
                return setHeader("x-hw-backup-packageName", (Object) str);
            }

            /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Bak$App$Create] */
            public Create setXHwBackupid(String str) {
                return setHeader("x-hw-backupId", (Object) str);
            }

            @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
            public CloudBackupV3Request<com.huawei.hicloud.cloudbackup.p104v3.server.model.App> setFields(String str) {
                return (Create) super.setFields(str);
            }

            @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
            public CloudBackupV3Request<com.huawei.hicloud.cloudbackup.p104v3.server.model.App> setForm(String str) {
                return (Create) super.setForm(str);
            }

            @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
            public CloudBackupV3Request<com.huawei.hicloud.cloudbackup.p104v3.server.model.App> setHeader(String str, Object obj) {
                return (Create) super.setHeader(str, obj);
            }

            @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
            public CloudBackupV3Request<com.huawei.hicloud.cloudbackup.p104v3.server.model.App> setTraceId(String str) {
                return (Create) super.setTraceId(str);
            }

            @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request, p614ri.AbstractC12513b, p579qi.AbstractC12361b, com.huawei.cloud.base.util.C4646n
            public Create set(String str, Object obj) {
                return (Create) super.set(str, obj);
            }
        }

        public static class Delete extends CloudBackupV3Request<Void> {
            private static final String REST_PATH = "backup/{backupAction}/device/{backupDeviceId}/bak/{bakId}/app/{backupAppId}";

            @InterfaceC4648p
            private String backupAction;

            @InterfaceC4648p
            private String backupAppId;

            @InterfaceC4648p
            private String backupDeviceId;

            @InterfaceC4648p
            private String bakId;

            public Delete(CloudBackupV3Server cloudBackupV3Server) throws IOException {
                super(cloudBackupV3Server, "DELETE", REST_PATH, null, Void.class);
            }

            public String getBackupAction() {
                return this.backupAction;
            }

            public String getBackupAppId() {
                return this.backupAppId;
            }

            public String getBackupDeviceId() {
                return this.backupDeviceId;
            }

            public String getBakId() {
                return this.bakId;
            }

            public Delete setBackupAction(String str) {
                this.backupAction = str;
                return this;
            }

            public Delete setBackupAppId(String str) {
                this.backupAppId = str;
                return this;
            }

            public Delete setBackupDeviceId(String str) {
                this.backupDeviceId = str;
                return this;
            }

            /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Bak$App$Delete] */
            public Delete setBakCategory(String str) {
                return TextUtils.isEmpty(str) ? this : setHeader("bakCategory", (Object) str);
            }

            public Delete setBakId(String str) {
                this.bakId = str;
                return this;
            }

            /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Bak$App$Delete] */
            public Delete setLockId(String str) {
                return setHeader("lockId", (Object) str);
            }

            /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Bak$App$Delete] */
            public Delete setLockInterval(Integer num) {
                return setHeader("lockInterval", (Object) num);
            }

            /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Bak$App$Delete] */
            public Delete setOccupySpaceType(Integer num) {
                return num == null ? this : setHeader("occupySpaceType", (Object) num);
            }

            /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Bak$App$Delete] */
            public Delete setXHwBackupPackageName(String str) {
                return setHeader("x-hw-backup-packageName", (Object) str);
            }

            /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Bak$App$Delete] */
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

        public static class Finish extends CloudBackupV3Request<com.huawei.hicloud.cloudbackup.p104v3.server.model.App> {
            private static final String REST_PATH = "backup/{backupAction}/device/{backupDeviceId}/bak/{bakId}/app/{backupAppId}";

            @InterfaceC4648p
            private String backupAction;

            @InterfaceC4648p
            private String backupAppId;

            @InterfaceC4648p
            private String backupDeviceId;

            @InterfaceC4648p
            private String bakId;

            public Finish(CloudBackupV3Server cloudBackupV3Server, AppFinish appFinish) throws IOException {
                super(cloudBackupV3Server, RequestMethod.PATCH, REST_PATH, appFinish, com.huawei.hicloud.cloudbackup.p104v3.server.model.App.class);
            }

            public String getBackupAction() {
                return this.backupAction;
            }

            public String getBackupAppId() {
                return this.backupAppId;
            }

            public String getBackupDeviceId() {
                return this.backupDeviceId;
            }

            public String getBakId() {
                return this.bakId;
            }

            public Finish setBackupAction(String str) {
                this.backupAction = str;
                return this;
            }

            public Finish setBackupAppId(String str) {
                this.backupAppId = str;
                return this;
            }

            public Finish setBackupDeviceId(String str) {
                this.backupDeviceId = str;
                return this;
            }

            /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Bak$App$Finish] */
            public Finish setBakCategory(String str) {
                return TextUtils.isEmpty(str) ? this : setHeader("bakCategory", (Object) str);
            }

            public Finish setBakId(String str) {
                this.bakId = str;
                return this;
            }

            /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Bak$App$Finish] */
            public Finish setLockId(String str) {
                return setHeader("lockId", (Object) str);
            }

            /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Bak$App$Finish] */
            public Finish setLockInterval(Integer num) {
                return setHeader("lockInterval", (Object) num);
            }

            /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Bak$App$Finish] */
            public Finish setOccupySpaceType(Integer num) {
                return num == null ? this : setHeader("occupySpaceType", (Object) num);
            }

            /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Bak$App$Finish] */
            public Finish setXHwBackupPackageName(String str) {
                return setHeader("x-hw-backup-packageName", (Object) str);
            }

            /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Bak$App$Finish] */
            public Finish setXHwBackupid(String str) {
                return setHeader("x-hw-backupId", (Object) str);
            }

            @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
            public CloudBackupV3Request<com.huawei.hicloud.cloudbackup.p104v3.server.model.App> setFields(String str) {
                return (Finish) super.setFields(str);
            }

            @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
            public CloudBackupV3Request<com.huawei.hicloud.cloudbackup.p104v3.server.model.App> setForm(String str) {
                return (Finish) super.setForm(str);
            }

            @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
            public CloudBackupV3Request<com.huawei.hicloud.cloudbackup.p104v3.server.model.App> setHeader(String str, Object obj) {
                return (Finish) super.setHeader(str, obj);
            }

            @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
            public CloudBackupV3Request<com.huawei.hicloud.cloudbackup.p104v3.server.model.App> setTraceId(String str) {
                return (Finish) super.setTraceId(str);
            }

            @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request, p614ri.AbstractC12513b, p579qi.AbstractC12361b, com.huawei.cloud.base.util.C4646n
            public Finish set(String str, Object obj) {
                return (Finish) super.set(str, obj);
            }
        }

        public static class List extends CloudBackupV3Request<AppList> {
            private static final String REST_PATH = "backup/{backupAction}/device/{backupDeviceId}/bak/{bakId}/apps";

            @InterfaceC4648p
            private String backupAction;

            @InterfaceC4648p
            private String backupDeviceId;

            @InterfaceC4648p
            private String bakId;

            @InterfaceC4648p
            private String cursor;

            @InterfaceC4648p
            private Integer pageSize;

            public List(CloudBackupV3Server cloudBackupV3Server) throws IOException {
                super(cloudBackupV3Server, "GET", REST_PATH, null, AppList.class);
            }

            public String getBackupAction() {
                return this.backupAction;
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

            public List setBackupAction(String str) {
                this.backupAction = str;
                return this;
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

            /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Bak$App$List] */
            public List setIncludeDeleted(Integer num) {
                return setHeader("x-hw-includeDeleted", (Object) num);
            }

            /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Bak$App$List] */
            public List setLockId(String str) {
                return setHeader("lockId", (Object) str);
            }

            /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Bak$App$List] */
            public List setLockInterval(Integer num) {
                return setHeader("lockInterval", (Object) num);
            }

            public List setPageSize(Integer num) {
                this.pageSize = num;
                return this;
            }

            /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Bak$App$List] */
            public List setUsage(String str) {
                return setHeader("usage", (Object) str);
            }

            /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Bak$App$List] */
            public List setXHwBackupid(String str) {
                return setHeader("x-hw-backupId", (Object) str);
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

        public static class Refresh extends CloudBackupV3Request<com.huawei.hicloud.cloudbackup.p104v3.server.model.App> {
            private static final String REST_PATH = "backup/{backupAction}/device/{backupDeviceId}/bak/{bakId}/app/{backupAppId}/refresh";

            @InterfaceC4648p
            private String backupAction;

            @InterfaceC4648p
            private String backupAppId;

            @InterfaceC4648p
            private String backupDeviceId;

            @InterfaceC4648p
            private String bakId;

            public Refresh(CloudBackupV3Server cloudBackupV3Server, AppRefresh appRefresh) throws IOException {
                super(cloudBackupV3Server, RequestMethod.PATCH, REST_PATH, appRefresh, com.huawei.hicloud.cloudbackup.p104v3.server.model.App.class);
            }

            public String getBackupAction() {
                return this.backupAction;
            }

            public String getBackupAppId() {
                return this.backupAppId;
            }

            public String getBackupDeviceId() {
                return this.backupDeviceId;
            }

            public String getBakId() {
                return this.bakId;
            }

            public Refresh setBackupAction(String str) {
                this.backupAction = str;
                return this;
            }

            public Refresh setBackupAppId(String str) {
                this.backupAppId = str;
                return this;
            }

            public Refresh setBackupDeviceId(String str) {
                this.backupDeviceId = str;
                return this;
            }

            /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Bak$App$Refresh] */
            public Refresh setBakCategory(String str) {
                return TextUtils.isEmpty(str) ? this : setHeader("bakCategory", (Object) str);
            }

            public Refresh setBakId(String str) {
                this.bakId = str;
                return this;
            }

            /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Bak$App$Refresh] */
            public Refresh setLockId(String str) {
                return setHeader("lockId", (Object) str);
            }

            /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Bak$App$Refresh] */
            public Refresh setLockInterval(Integer num) {
                return setHeader("lockInterval", (Object) num);
            }

            /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Bak$App$Refresh] */
            public Refresh setOccupySpaceType(Integer num) {
                return num == null ? this : setHeader("occupySpaceType", (Object) num);
            }

            /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Bak$App$Refresh] */
            public Refresh setXHwBackupPackageName(String str) {
                return setHeader("x-hw-backup-packageName", (Object) str);
            }

            /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Bak$App$Refresh] */
            public Refresh setXHwBackupid(String str) {
                return setHeader("x-hw-backupId", (Object) str);
            }

            @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
            public CloudBackupV3Request<com.huawei.hicloud.cloudbackup.p104v3.server.model.App> setFields(String str) {
                return (Refresh) super.setFields(str);
            }

            @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
            public CloudBackupV3Request<com.huawei.hicloud.cloudbackup.p104v3.server.model.App> setForm(String str) {
                return (Refresh) super.setForm(str);
            }

            @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
            public CloudBackupV3Request<com.huawei.hicloud.cloudbackup.p104v3.server.model.App> setHeader(String str, Object obj) {
                return (Refresh) super.setHeader(str, obj);
            }

            @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
            public CloudBackupV3Request<com.huawei.hicloud.cloudbackup.p104v3.server.model.App> setTraceId(String str) {
                return (Refresh) super.setTraceId(str);
            }

            @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request, p614ri.AbstractC12513b, p579qi.AbstractC12361b, com.huawei.cloud.base.util.C4646n
            public Refresh set(String str, Object obj) {
                return (Refresh) super.set(str, obj);
            }
        }

        public App(CloudBackupV3Server cloudBackupV3Server) {
            this.client = cloudBackupV3Server;
        }

        public Copy copy(AppCreate appCreate) throws IOException {
            return new Copy(this.client, appCreate);
        }

        public Create create(AppCreate appCreate) throws IOException {
            return new Create(this.client, appCreate);
        }

        public Delete delete() throws IOException {
            return new Delete(this.client);
        }

        public Finish finish(AppFinish appFinish) throws IOException {
            return new Finish(this.client, appFinish);
        }

        public List list() throws IOException {
            return new List(this.client);
        }

        public Refresh refresh(AppRefresh appRefresh) throws IOException {
            return new Refresh(this.client, appRefresh);
        }
    }

    public static class Delete extends CloudBackupV3Request<Void> {
        private static final String REST_PATH = "backup/{backupAction}/device/{backupDeviceId}/bak/{bakId}";

        @InterfaceC4648p
        private String backupAction;

        @InterfaceC4648p
        private String backupDeviceId;

        @InterfaceC4648p
        private String bakId;

        public Delete(CloudBackupV3Server cloudBackupV3Server) throws IOException {
            super(cloudBackupV3Server, "DELETE", REST_PATH, null, Void.class);
        }

        public String getBakId() {
            return this.bakId;
        }

        public String getDeleteBackupAction() {
            return this.backupAction;
        }

        public String getDeleteBackupDeviceId() {
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

        public Delete setBakId(String str) {
            this.bakId = str;
            return this;
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Bak$Delete] */
        public Delete setLockId(String str) {
            return setHeader("lockId", (Object) str);
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Bak$Delete] */
        public Delete setLockInterval(Integer num) {
            return setHeader("lockInterval", (Object) num);
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

    public static class Finish extends CloudBackupV3Request<com.huawei.hicloud.cloudbackup.p104v3.server.model.Bak> {
        private static final String REST_PATH = "backup/{backupAction}/device/{backupDeviceId}/bak/{bakId}";

        @InterfaceC4648p
        private String backupAction;

        @InterfaceC4648p
        private String backupDeviceId;

        @InterfaceC4648p
        private String bakId;

        @InterfaceC4648p
        private String lockId;

        public Finish(CloudBackupV3Server cloudBackupV3Server, BakFinish bakFinish) throws IOException {
            super(cloudBackupV3Server, RequestMethod.PATCH, REST_PATH, bakFinish, com.huawei.hicloud.cloudbackup.p104v3.server.model.Bak.class);
        }

        public String getFinishBackupAction() {
            return this.backupAction;
        }

        public String getFinishBackupDeviceId() {
            return this.backupDeviceId;
        }

        public String getFinishBakId() {
            return this.bakId;
        }

        public Finish setBackupAction(String str) {
            this.backupAction = str;
            return this;
        }

        public Finish setBackupDeviceId(String str) {
            this.backupDeviceId = str;
            return this;
        }

        public Finish setBakCategory(String str) {
            return TextUtils.isEmpty(str) ? this : (Finish) setHeader("bakCategory", str);
        }

        public Finish setBakId(String str) {
            this.bakId = str;
            return this;
        }

        public Finish setGrayFlowStrategy(String str) {
            return !TextUtils.isEmpty(str) ? (Finish) setHeader("x-hw-grayFlowStrategy", str) : this;
        }

        public Finish setLockId(String str) {
            return (Finish) setHeader("lockId", str);
        }

        public Finish setLockInterval(Integer num) {
            return (Finish) setHeader("lockInterval", num);
        }

        public Finish setOccupySpaceType(Integer num) {
            return num == null ? this : (Finish) setHeader("occupySpaceType", num);
        }

        @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
        public CloudBackupV3Request<com.huawei.hicloud.cloudbackup.p104v3.server.model.Bak> setFields(String str) {
            return (Finish) super.setFields(str);
        }

        @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
        public CloudBackupV3Request<com.huawei.hicloud.cloudbackup.p104v3.server.model.Bak> setForm(String str) {
            return (Finish) super.setForm(str);
        }

        @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
        public CloudBackupV3Request<com.huawei.hicloud.cloudbackup.p104v3.server.model.Bak> setTraceId(String str) {
            return (Finish) super.setTraceId(str);
        }
    }

    public static class List extends CloudBackupV3Request<BakList> {
        private static final String REST_PATH = "backup/{backupAction}/device/{backupDeviceId}/baks";

        @InterfaceC4648p
        private String backupAction;

        @InterfaceC4648p
        private String backupDeviceId;

        public List(CloudBackupV3Server cloudBackupV3Server) throws IOException {
            super(cloudBackupV3Server, "GET", REST_PATH, null, BakList.class);
        }

        public String getBackupAction() {
            return this.backupAction;
        }

        public String getBackupDeviceId() {
            return this.backupDeviceId;
        }

        public List setBackupAction(String str) {
            this.backupAction = str;
            return this;
        }

        public List setBackupDeviceId(String str) {
            this.backupDeviceId = str;
            return this;
        }

        public List setBakCategory(String str) {
            return TextUtils.isEmpty(str) ? this : (List) setHeader("bakCategory", str);
        }

        public List setContainInterim(boolean z10) {
            return (List) setHeader("x-hw-contain-interim", Boolean.valueOf(z10));
        }

        public List setContainOH(int i10) {
            return (List) setHeader("x-hw-contain-oh", Integer.valueOf(i10));
        }

        public List setLockId(String str) {
            return (List) setHeader("lockId", str);
        }

        public List setLockInterval(Integer num) {
            return (List) setHeader("lockInterval", num);
        }

        public List setOccupySpaceType(Integer num) {
            return num == null ? this : (List) setHeader("occupySpaceType", num);
        }

        @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
        public CloudBackupV3Request<BakList> setFields(String str) {
            return (List) super.setFields(str);
        }

        @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
        public CloudBackupV3Request<BakList> setForm(String str) {
            return (List) super.setForm(str);
        }

        @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
        public CloudBackupV3Request<BakList> setTraceId(String str) {
            return (List) super.setTraceId(str);
        }

        @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request, p614ri.AbstractC12513b, p579qi.AbstractC12361b, com.huawei.cloud.base.util.C4646n
        public List set(String str, Object obj) {
            return (List) super.set(str, obj);
        }
    }

    public static class Refresh extends CloudBackupV3Request<com.huawei.hicloud.cloudbackup.p104v3.server.model.Bak> {
        private static final String REST_PATH = "backup/{backupAction}/device/{backupDeviceId}/bak/{bakId}/refresh";

        @InterfaceC4648p
        private String backupAction;

        @InterfaceC4648p
        private String backupDeviceId;

        @InterfaceC4648p
        private String bakId;

        public Refresh(CloudBackupV3Server cloudBackupV3Server, BakRefresh bakRefresh) throws IOException {
            super(cloudBackupV3Server, RequestMethod.PATCH, REST_PATH, bakRefresh, com.huawei.hicloud.cloudbackup.p104v3.server.model.Bak.class);
        }

        public String getRefreshBackupAction() {
            return this.backupAction;
        }

        public String getRefreshBackupDeviceId() {
            return this.backupDeviceId;
        }

        public String getRefreshBakId() {
            return this.bakId;
        }

        public Refresh setBackupAction(String str) {
            this.backupAction = str;
            return this;
        }

        public Refresh setBackupDeviceId(String str) {
            this.backupDeviceId = str;
            return this;
        }

        public Refresh setBakCategory(String str) {
            return TextUtils.isEmpty(str) ? this : (Refresh) setHeader("bakCategory", str);
        }

        public Refresh setBakId(String str) {
            this.bakId = str;
            return this;
        }

        public Refresh setLockId(String str) {
            return (Refresh) setHeader("lockId", str);
        }

        public Refresh setLockInterval(Integer num) {
            return (Refresh) setHeader("lockInterval", num);
        }

        public Refresh setOccupySpaceType(Integer num) {
            return num == null ? this : (Refresh) setHeader("occupySpaceType", num);
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
        public CloudBackupV3Request<com.huawei.hicloud.cloudbackup.p104v3.server.model.Bak> setTraceId(String str) {
            return (Refresh) super.setTraceId(str);
        }

        @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request, p614ri.AbstractC12513b, p579qi.AbstractC12361b, com.huawei.cloud.base.util.C4646n
        public Refresh set(String str, Object obj) {
            return (Refresh) super.set(str, obj);
        }
    }

    public static class Start extends CloudBackupV3Request<com.huawei.hicloud.cloudbackup.p104v3.server.model.Bak> {
        private static final String REST_PATH = "backup/{backupAction}/device/{backupDeviceId}/bak";

        @InterfaceC4648p
        private String backupAction;

        @InterfaceC4648p
        private String backupDeviceId;

        public Start(CloudBackupV3Server cloudBackupV3Server, BakCreate bakCreate) throws IOException {
            super(cloudBackupV3Server, "POST", REST_PATH, bakCreate, com.huawei.hicloud.cloudbackup.p104v3.server.model.Bak.class);
        }

        public String getBackupAction() {
            return this.backupAction;
        }

        public String getBackupDeviceId() {
            return this.backupDeviceId;
        }

        public Start setBackupAction(String str) {
            this.backupAction = str;
            return this;
        }

        public Start setBackupDeviceId(String str) {
            this.backupDeviceId = str;
            return this;
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Bak$Start] */
        public Start setBakCategory(String str) {
            return TextUtils.isEmpty(str) ? this : setHeader("bakCategory", (Object) str);
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Bak$Start] */
        public Start setGradeCode(String str) {
            return setHeader("x-hw-gradeCode", (Object) str);
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Bak$Start] */
        public Start setInterimChannel(Integer num) {
            return num == null ? this : setHeader("x-hw-channel", (Object) num);
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Bak$Start] */
        public Start setLockId(String str) {
            return setHeader("lockId", (Object) str);
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Bak$Start] */
        public Start setLockInterval(Integer num) {
            return setHeader("lockInterval", (Object) num);
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Bak$Start] */
        public Start setOccupySpaceType(Integer num) {
            return num == null ? this : setHeader("occupySpaceType", (Object) num);
        }

        @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
        public CloudBackupV3Request<com.huawei.hicloud.cloudbackup.p104v3.server.model.Bak> setFields(String str) {
            return (Start) super.setFields(str);
        }

        @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
        public CloudBackupV3Request<com.huawei.hicloud.cloudbackup.p104v3.server.model.Bak> setForm(String str) {
            return (Start) super.setForm(str);
        }

        @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
        public CloudBackupV3Request<com.huawei.hicloud.cloudbackup.p104v3.server.model.Bak> setHeader(String str, Object obj) {
            return (Start) super.setHeader(str, obj);
        }

        @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request
        public CloudBackupV3Request<com.huawei.hicloud.cloudbackup.p104v3.server.model.Bak> setTraceId(String str) {
            return (Start) super.setTraceId(str);
        }

        @Override // com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request, p614ri.AbstractC12513b, p579qi.AbstractC12361b, com.huawei.cloud.base.util.C4646n
        public Start set(String str, Object obj) {
            return (Start) super.set(str, obj);
        }
    }

    public Bak(CloudBackupV3Server cloudBackupV3Server) {
        this.client = cloudBackupV3Server;
    }

    public App app() {
        return new App(this.client);
    }

    public Delete delete() throws IOException {
        return new Delete(this.client);
    }

    public Finish finish(BakFinish bakFinish) throws IOException {
        return new Finish(this.client, bakFinish);
    }

    public List list() throws IOException {
        return new List(this.client);
    }

    public Refresh refresh(BakRefresh bakRefresh) throws IOException {
        return new Refresh(this.client, bakRefresh);
    }

    public Start start(BakCreate bakCreate) throws IOException {
        return new Start(this.client, bakCreate);
    }
}
