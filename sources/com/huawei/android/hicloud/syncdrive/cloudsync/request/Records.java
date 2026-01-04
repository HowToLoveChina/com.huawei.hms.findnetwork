package com.huawei.android.hicloud.syncdrive.cloudsync.request;

import com.huawei.android.hicloud.drive.clouddisk.expand.RequestMethod;
import com.huawei.android.hicloud.syncdrive.cloudsync.model.BatchDeleteResponse;
import com.huawei.android.hicloud.syncdrive.cloudsync.model.BatchRecordsRequest;
import com.huawei.android.hicloud.syncdrive.cloudsync.model.BatchRecordsResponse;
import com.huawei.android.hicloud.syncdrive.cloudsync.model.IdList;
import com.huawei.android.hicloud.syncdrive.cloudsync.model.Record;
import com.huawei.android.hicloud.syncdrive.cloudsync.model.RecordsList;
import com.huawei.cloud.base.util.C4627a0;
import com.huawei.cloud.base.util.InterfaceC4648p;
import com.huawei.cloud.services.drive.Drive;
import java.io.IOException;
import p255ed.AbstractC9455k;

/* loaded from: classes3.dex */
public class Records {
    private Drive drive;

    public static class BatchCreate extends AbstractC9455k<BatchRecordsResponse> {
        private static final String REST_PATH = "dataSync/v1/service/{database}/kinds/{kind}/record/batchCreate";

        @InterfaceC4648p
        private String database;

        @InterfaceC4648p
        private String kind;

        @InterfaceC4648p
        private String mode;

        public BatchCreate(Drive drive, String str, String str2, BatchRecordsRequest batchRecordsRequest) throws IOException {
            super(drive, str, str2, "POST", REST_PATH, batchRecordsRequest, BatchRecordsResponse.class);
            this.database = (String) C4627a0.m28392e(str, "Required parameter database must be specified.");
            this.kind = (String) C4627a0.m28392e(str2, "Required parameter kind must be specified.");
            getHeaders().set("x-hw-client-cipher-cap", 3);
        }

        public String getDatabase() {
            return this.database;
        }

        public String getKind() {
            return this.kind;
        }

        public String getMode() {
            return this.mode;
        }

        public BatchCreate setMode(String str) {
            this.mode = str;
            return this;
        }

        @Override // p255ed.AbstractC9455k
        public BatchCreate addHeader(String str, Object obj) {
            getHeaders().set(str, obj);
            return this;
        }

        @Override // com.huawei.cloud.services.drive.DriveRequest
        /* renamed from: setFields */
        public BatchCreate setFields2(String str) {
            return (BatchCreate) super.setFields2(str);
        }
    }

    public static class BatchDelete extends AbstractC9455k<BatchDeleteResponse> {
        private static final String REST_PATH = "dataSync/v1/service/{database}/kinds/{kind}/record/batchDelete";

        @InterfaceC4648p
        private String database;

        @InterfaceC4648p
        private String kind;

        public BatchDelete(Drive drive, String str, String str2, IdList idList) throws IOException {
            super(drive, str, str2, "POST", REST_PATH, idList, BatchDeleteResponse.class);
            this.database = (String) C4627a0.m28392e(str, "Required parameter database must be specified.");
            this.kind = (String) C4627a0.m28392e(str2, "Required parameter kind must be specified.");
        }

        public String getDatabase() {
            return this.database;
        }

        public String getKind() {
            return this.kind;
        }

        @Override // p255ed.AbstractC9455k
        public BatchDelete addHeader(String str, Object obj) {
            getHeaders().set(str, obj);
            return this;
        }
    }

    public static class BatchGet extends AbstractC9455k<BatchRecordsResponse> {
        private static final String REST_PATH = "dataSync/v1/service/{database}/kinds/{kind}/record/batchGet";

        @InterfaceC4648p
        private String database;

        @InterfaceC4648p
        private String kind;

        public BatchGet(Drive drive, String str, String str2, IdList idList) throws IOException {
            super(drive, str, str2, "POST", REST_PATH, idList, BatchRecordsResponse.class);
            this.database = (String) C4627a0.m28392e(str, "Required parameter database must be specified.");
            this.kind = (String) C4627a0.m28392e(str2, "Required parameter kind must be specified.");
            getHeaders().set("x-hw-client-cipher-cap", 3);
        }

        public String getDatabase() {
            return this.database;
        }

        public String getKind() {
            return this.kind;
        }

        @Override // p255ed.AbstractC9455k
        public BatchGet addHeader(String str, Object obj) {
            getHeaders().set(str, obj);
            return this;
        }

        @Override // com.huawei.cloud.services.drive.DriveRequest
        /* renamed from: setFields */
        public BatchGet setFields2(String str) {
            return (BatchGet) super.setFields2(str);
        }
    }

    public static class BatchReplace extends AbstractC9455k<BatchRecordsResponse> {
        private static final String REST_PATH = "dataSync/v1/service/{database}/kinds/{kind}/record/batchReplace";

        @InterfaceC4648p
        private String database;

        @InterfaceC4648p
        private String kind;

        @InterfaceC4648p
        private String mode;

        public BatchReplace(Drive drive, String str, String str2, BatchRecordsRequest batchRecordsRequest) throws IOException {
            super(drive, str, str2, "POST", REST_PATH, batchRecordsRequest, BatchRecordsResponse.class);
            this.database = (String) C4627a0.m28392e(str, "Required parameter database must be specified.");
            this.kind = (String) C4627a0.m28392e(str2, "Required parameter kind must be specified.");
            getHeaders().set("x-hw-client-cipher-cap", 3);
        }

        public String getDatabase() {
            return this.database;
        }

        public String getKind() {
            return this.kind;
        }

        public String getMode() {
            return this.mode;
        }

        public BatchReplace setMode(String str) {
            this.mode = str;
            return this;
        }

        @Override // p255ed.AbstractC9455k
        public BatchReplace addHeader(String str, Object obj) {
            getHeaders().set(str, obj);
            return this;
        }

        @Override // com.huawei.cloud.services.drive.DriveRequest
        /* renamed from: setFields */
        public BatchReplace setFields2(String str) {
            return (BatchReplace) super.setFields2(str);
        }
    }

    public static class BatchUpdate extends AbstractC9455k<BatchRecordsResponse> {
        private static final String REST_PATH = "dataSync/v1/service/{database}/kinds/{kind}/record/batchUpdate";

        @InterfaceC4648p
        private String database;

        @InterfaceC4648p
        private String kind;

        @InterfaceC4648p
        private String mode;

        public BatchUpdate(Drive drive, String str, String str2, BatchRecordsRequest batchRecordsRequest) throws IOException {
            super(drive, str, str2, "POST", REST_PATH, batchRecordsRequest, BatchRecordsResponse.class);
            this.database = (String) C4627a0.m28392e(str, "Required parameter database must be specified.");
            this.kind = (String) C4627a0.m28392e(str2, "Required parameter kind must be specified.");
            getHeaders().set("x-hw-client-cipher-cap", 3);
        }

        public String getDatabase() {
            return this.database;
        }

        public String getKind() {
            return this.kind;
        }

        public String getMode() {
            return this.mode;
        }

        public BatchUpdate setMode(String str) {
            this.mode = str;
            return this;
        }

        @Override // p255ed.AbstractC9455k
        public BatchUpdate addHeader(String str, Object obj) {
            getHeaders().set(str, obj);
            return this;
        }

        @Override // com.huawei.cloud.services.drive.DriveRequest
        /* renamed from: setFields */
        public BatchUpdate setFields2(String str) {
            return (BatchUpdate) super.setFields2(str);
        }
    }

    public static class Create extends AbstractC9455k<Record> {
        private static final String REST_PATH = "dataSync/v1/service/{database}/kinds/{kind}/record";

        @InterfaceC4648p
        private String database;

        @InterfaceC4648p
        private String kind;

        @InterfaceC4648p
        private String mode;

        public Create(Drive drive, String str, String str2, Record record) throws IOException {
            super(drive, str, str2, "POST", REST_PATH, record, Record.class);
            this.database = (String) C4627a0.m28392e(str, "Required parameter database must be specified.");
            this.kind = (String) C4627a0.m28392e(str2, "Required parameter kind must be specified.");
            getHeaders().set("x-hw-client-cipher-cap", 3);
        }

        public String getDatabase() {
            return this.database;
        }

        public String getKind() {
            return this.kind;
        }

        public String getMode() {
            return this.mode;
        }

        public Create setMode(String str) {
            this.mode = str;
            return this;
        }

        @Override // p255ed.AbstractC9455k
        public Create addHeader(String str, Object obj) {
            getHeaders().set(str, obj);
            return this;
        }

        @Override // com.huawei.cloud.services.drive.DriveRequest
        /* renamed from: setFields */
        public Create setFields2(String str) {
            return (Create) super.setFields2(str);
        }
    }

    public static class Delete extends AbstractC9455k<Void> {
        private static final String REST_PATH = "dataSync/v1/service/{database}/kinds/{kind}/record/{recordId}";

        @InterfaceC4648p
        private String database;

        @InterfaceC4648p
        private String kind;

        @InterfaceC4648p
        private String recordId;

        public Delete(Drive drive, String str, String str2, String str3) throws IOException {
            super(drive, str, str2, "DELETE", REST_PATH, null, Void.class);
            this.database = (String) C4627a0.m28392e(str, "Required parameter database must be specified.");
            this.kind = (String) C4627a0.m28392e(str2, "Required parameter kind must be specified.");
            this.recordId = (String) C4627a0.m28392e(str3, "Required parameter recordId must be specified.");
        }

        public String getDatabase() {
            return this.database;
        }

        public String getKind() {
            return this.kind;
        }

        public String getRecordId() {
            return this.recordId;
        }
    }

    public static class GenerateIds extends AbstractC9455k<IdList> {
        private static final String REST_PATH = "dataSync/v1/service/{database}/records/generateIds";

        @InterfaceC4648p
        private Integer count;

        @InterfaceC4648p
        private String database;

        public GenerateIds(Drive drive, String str, String str2, Integer num) throws IOException {
            super(drive, str, str2, "GET", REST_PATH, null, IdList.class);
            this.database = (String) C4627a0.m28392e(str, "Required parameter database must be specified.");
            this.count = (Integer) C4627a0.m28392e(num, "Required parameter count must be specified.");
        }

        public Integer getCount() {
            return this.count;
        }

        public String getDatabase() {
            return this.database;
        }
    }

    public static class Get extends AbstractC9455k<Record> {
        private static final String REST_PATH = "dataSync/v1/service/{database}/kinds/{kind}/record/{recordId}";

        @InterfaceC4648p
        private String database;

        @InterfaceC4648p
        private String kind;

        @InterfaceC4648p
        private String recordId;

        public Get(Drive drive, String str, String str2, String str3) throws IOException {
            super(drive, str, str2, "GET", REST_PATH, null, Record.class);
            this.database = (String) C4627a0.m28392e(str, "Required parameter database must be specified.");
            this.kind = (String) C4627a0.m28392e(str2, "Required parameter kind must be specified.");
            this.recordId = (String) C4627a0.m28392e(str3, "Required parameter recordId must be specified.");
            getHeaders().set("x-hw-client-cipher-cap", 3);
        }

        public String getDatabase() {
            return this.database;
        }

        public String getKind() {
            return this.kind;
        }

        public String getRecordId() {
            return this.recordId;
        }

        @Override // p255ed.AbstractC9455k
        public Get addHeader(String str, Object obj) {
            getHeaders().set(str, obj);
            return this;
        }

        @Override // com.huawei.cloud.services.drive.DriveRequest
        /* renamed from: setFields */
        public Get setFields2(String str) {
            super.setFields2(str);
            return this;
        }

        @Override // com.huawei.cloud.services.drive.DriveRequest, p614ri.AbstractC12513b, p579qi.AbstractC12361b, com.huawei.cloud.base.util.C4646n
        public Get set(String str, Object obj) {
            return (Get) super.set(str, obj);
        }
    }

    public static class List extends AbstractC9455k<RecordsList> {
        private static final String REST_PATH = "dataSync/v1/service/{database}/kinds/{kind}/record";

        @InterfaceC4648p
        private String cursor;

        @InterfaceC4648p
        private String database;

        @InterfaceC4648p
        private String kind;

        @InterfaceC4648p
        private Integer pageSize;

        public List(Drive drive, String str, String str2) throws IOException {
            super(drive, str, str2, "GET", REST_PATH, null, RecordsList.class);
            this.database = (String) C4627a0.m28392e(str, "Required parameter database must be specified.");
            this.kind = (String) C4627a0.m28392e(str2, "Required parameter kind must be specified.");
        }

        public String getCursor() {
            return this.cursor;
        }

        public String getDatabase() {
            return this.database;
        }

        public String getKind() {
            return this.kind;
        }

        public Integer getPageSize() {
            return this.pageSize;
        }

        public List setCursor(String str) {
            this.cursor = str;
            return this;
        }

        public List setPageSize(Integer num) {
            this.pageSize = num;
            return this;
        }

        @Override // p255ed.AbstractC9455k
        public List addHeader(String str, Object obj) {
            getHeaders().set(str, obj);
            return this;
        }

        @Override // com.huawei.cloud.services.drive.DriveRequest
        /* renamed from: setFields */
        public List setFields2(String str) {
            super.setFields2(str);
            return this;
        }

        @Override // com.huawei.cloud.services.drive.DriveRequest, p614ri.AbstractC12513b, p579qi.AbstractC12361b, com.huawei.cloud.base.util.C4646n
        public List set(String str, Object obj) {
            return (List) super.set(str, obj);
        }
    }

    public static class UpdatePatch extends AbstractC9455k<Record> {
        private static final String REST_PATH = "dataSync/v1/service/{database}/kinds/{kind}/record/{recordId}";

        @InterfaceC4648p
        private String database;

        @InterfaceC4648p
        private String kind;

        @InterfaceC4648p
        private String mode;

        @InterfaceC4648p
        private String recordId;

        public UpdatePatch(Drive drive, String str, String str2, String str3, Record record) throws IOException {
            super(drive, str, str2, RequestMethod.PATCH, REST_PATH, record, Record.class);
            this.database = (String) C4627a0.m28392e(str, "Required parameter database must be specified.");
            this.kind = (String) C4627a0.m28392e(str2, "Required parameter kind must be specified.");
            this.recordId = (String) C4627a0.m28392e(str3, "Required parameter recordId must be specified.");
            getHeaders().set("x-hw-client-cipher-cap", 3);
        }

        public String getDatabase() {
            return this.database;
        }

        public String getKind() {
            return this.kind;
        }

        public String getMode() {
            return this.mode;
        }

        public String getRecordId() {
            return this.recordId;
        }

        public UpdatePatch setMode(String str) {
            this.mode = str;
            return this;
        }

        @Override // p255ed.AbstractC9455k
        public UpdatePatch addHeader(String str, Object obj) {
            getHeaders().set(str, obj);
            return this;
        }

        @Override // com.huawei.cloud.services.drive.DriveRequest
        /* renamed from: setFields */
        public UpdatePatch setFields2(String str) {
            super.setFields2(str);
            return this;
        }

        @Override // com.huawei.cloud.services.drive.DriveRequest, p614ri.AbstractC12513b, p579qi.AbstractC12361b, com.huawei.cloud.base.util.C4646n
        public UpdatePatch set(String str, Object obj) {
            return (UpdatePatch) super.set(str, obj);
        }
    }

    public static class UpdatePut extends AbstractC9455k<Record> {
        private static final String REST_PATH = "dataSync/v1/service/{database}/kinds/{kind}/record/{recordId}";

        @InterfaceC4648p
        private String database;

        @InterfaceC4648p
        private String kind;

        @InterfaceC4648p
        private String mode;

        @InterfaceC4648p
        private String recordId;

        public UpdatePut(Drive drive, String str, String str2, String str3, Record record) throws IOException {
            super(drive, str, str2, "PUT", REST_PATH, record, Record.class);
            this.database = (String) C4627a0.m28392e(str, "Required parameter database must be specified.");
            this.kind = (String) C4627a0.m28392e(str2, "Required parameter kind must be specified.");
            this.recordId = (String) C4627a0.m28392e(str3, "Required parameter recordId must be specified.");
            getHeaders().set("x-hw-client-cipher-cap", 3);
        }

        public String getDatabase() {
            return this.database;
        }

        public String getKind() {
            return this.kind;
        }

        public String getMode() {
            return this.mode;
        }

        public String getRecordId() {
            return this.recordId;
        }

        public UpdatePut setMode(String str) {
            this.mode = str;
            return this;
        }

        @Override // p255ed.AbstractC9455k
        public UpdatePut addHeader(String str, Object obj) {
            getHeaders().set(str, obj);
            return this;
        }

        @Override // com.huawei.cloud.services.drive.DriveRequest
        /* renamed from: setFields */
        public UpdatePut setFields2(String str) {
            super.setFields2(str);
            return this;
        }

        @Override // com.huawei.cloud.services.drive.DriveRequest, p614ri.AbstractC12513b, p579qi.AbstractC12361b, com.huawei.cloud.base.util.C4646n
        public UpdatePut set(String str, Object obj) {
            return (UpdatePut) super.set(str, obj);
        }
    }

    public Records(Drive drive) {
        this.drive = drive;
    }

    public BatchCreate batchCreate(String str, String str2, BatchRecordsRequest batchRecordsRequest) throws IOException {
        return new BatchCreate(this.drive, str, str2, batchRecordsRequest);
    }

    public BatchDelete batchDelete(String str, String str2, IdList idList) throws IOException {
        return new BatchDelete(this.drive, str, str2, idList);
    }

    public BatchGet batchGet(String str, String str2, IdList idList) throws IOException {
        return new BatchGet(this.drive, str, str2, idList);
    }

    public BatchReplace batchReplace(String str, String str2, BatchRecordsRequest batchRecordsRequest) throws IOException {
        return new BatchReplace(this.drive, str, str2, batchRecordsRequest);
    }

    public BatchUpdate batchUpdate(String str, String str2, BatchRecordsRequest batchRecordsRequest) throws IOException {
        return new BatchUpdate(this.drive, str, str2, batchRecordsRequest);
    }

    public Create create(String str, String str2, Record record) throws IOException {
        return new Create(this.drive, str, str2, record);
    }

    public Delete delete(String str, String str2, String str3) throws IOException {
        return new Delete(this.drive, str, str2, str3);
    }

    public GenerateIds generateIds(String str, String str2, Integer num) throws IOException {
        return new GenerateIds(this.drive, str, str2, num);
    }

    public Get get(String str, String str2, String str3) throws IOException {
        return new Get(this.drive, str, str2, str3);
    }

    public List list(String str, String str2) throws IOException {
        return new List(this.drive, str, str2);
    }

    public UpdatePatch updatePatch(String str, String str2, String str3, Record record) throws IOException {
        return new UpdatePatch(this.drive, str, str2, str3, record);
    }

    public UpdatePut updatePut(String str, String str2, String str3, Record record) throws IOException {
        return new UpdatePut(this.drive, str, str2, str3, record);
    }
}
