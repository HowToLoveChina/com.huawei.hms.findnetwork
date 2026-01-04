package com.huawei.android.hicloud.drive.cloudphoto.request;

import com.huawei.android.hicloud.drive.clouddisk.expand.RequestMethod;
import com.huawei.android.hicloud.drive.cloudphoto.model.Applicant;
import com.huawei.android.hicloud.drive.cloudphoto.model.ApplicantCreateRequest;
import com.huawei.android.hicloud.drive.cloudphoto.model.ApplicantList;
import com.huawei.android.hicloud.drive.cloudphoto.model.ApplicantUpdateRequest;
import com.huawei.cloud.base.util.C4627a0;
import com.huawei.cloud.base.util.InterfaceC4648p;
import com.huawei.cloud.services.drive.Drive;
import java.io.IOException;
import p804ya.AbstractC13930g;

/* loaded from: classes3.dex */
public class Applicants {
    private Drive drive;

    public static class Create extends AbstractC13930g<Applicant> {
        private static final String REST_PATH = "cloudPhoto/v1/applicant";

        public Create(Drive drive, ApplicantCreateRequest applicantCreateRequest) throws IOException {
            super(drive, "POST", REST_PATH, applicantCreateRequest, Applicant.class);
        }

        @Override // com.huawei.cloud.services.drive.DriveRequest
        /* renamed from: setFields */
        public Create setFields2(String str) {
            return (Create) super.setFields2(str);
        }
    }

    public static class Get extends AbstractC13930g<Applicant> {
        private static final String REST_PATH = "cloudPhoto/v1/applicant/{applicantId}";

        @InterfaceC4648p
        private String applicantId;

        public Get(Drive drive, String str) throws IOException {
            super(drive, "GET", REST_PATH, null, Applicant.class);
            this.applicantId = (String) C4627a0.m28392e(str, "Required parameter applicantId must be specified.");
        }

        public String getApplicantId() {
            return this.applicantId;
        }

        public void setApplicantId(String str) {
            this.applicantId = str;
        }

        @Override // com.huawei.cloud.services.drive.DriveRequest
        /* renamed from: setFields */
        public Get setFields2(String str) {
            return (Get) super.setFields2(str);
        }
    }

    public static class List extends AbstractC13930g<ApplicantList> {
        private static final String REST_PATH = "cloudPhoto/v1/applicant";

        @InterfaceC4648p
        private String cursor;

        @InterfaceC4648p
        private Integer pageSize;

        public List(Drive drive) throws IOException {
            super(drive, "GET", REST_PATH, null, ApplicantList.class);
        }

        public String getCursor() {
            return this.cursor;
        }

        public Integer getPageSize() {
            return this.pageSize;
        }

        public List setCursor(String str) {
            this.cursor = str;
            return this;
        }

        public void setPageSize(Integer num) {
            this.pageSize = num;
        }

        @Override // p804ya.AbstractC13930g
        public List addHeader(String str, Object obj) {
            getHeaders().set(str, obj);
            return this;
        }

        @Override // com.huawei.cloud.services.drive.DriveRequest
        /* renamed from: setFields */
        public List setFields2(String str) {
            return (List) super.setFields2(str);
        }
    }

    public static class Update extends AbstractC13930g<Void> {
        private static final String REST_PATH = "cloudPhoto/v1/applicant/{applicantId}";

        @InterfaceC4648p
        private String applicantId;

        public Update(Drive drive, ApplicantUpdateRequest applicantUpdateRequest) throws IOException {
            super(drive, RequestMethod.PATCH, REST_PATH, applicantUpdateRequest, Void.class);
        }

        public String getApplicantId() {
            return this.applicantId;
        }

        public void setApplicantId(String str) {
            this.applicantId = str;
        }

        @Override // com.huawei.cloud.services.drive.DriveRequest
        /* renamed from: setFields */
        public Update setFields2(String str) {
            return (Update) super.setFields2(str);
        }
    }

    public Applicants(Drive drive) {
        this.drive = drive;
    }

    public Create create(ApplicantCreateRequest applicantCreateRequest) throws IOException {
        return new Create(this.drive, applicantCreateRequest);
    }

    public Get get(String str) throws IOException {
        return new Get(this.drive, str);
    }

    public List list() throws IOException {
        return new List(this.drive);
    }

    public Update update(ApplicantUpdateRequest applicantUpdateRequest) throws IOException {
        return new Update(this.drive, applicantUpdateRequest);
    }
}
