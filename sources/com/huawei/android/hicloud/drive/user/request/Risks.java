package com.huawei.android.hicloud.drive.user.request;

import com.huawei.cloud.services.drive.Drive;
import com.huawei.hicloud.base.drive.user.model.RisksRecordList;
import com.huawei.hicloud.base.drive.user.model.RisksRequst;
import java.io.IOException;
import p012ab.AbstractC0088c;

/* loaded from: classes3.dex */
public class Risks {
    private Drive drive;

    public static class Appeal extends AbstractC0088c<Void> {
        private static final String REST_PATH = "HiCloudUserInformationService/v1/risks/service/appeal";

        public Appeal(Drive drive, RisksRequst risksRequst) throws IOException {
            super(drive, "POST", REST_PATH, risksRequst, Void.class);
        }

        public Appeal setHeader(String str, Object obj) {
            getHeaders().set(str, obj);
            return this;
        }
    }

    public static class AppealRecord extends AbstractC0088c<RisksRecordList> {
        private static final String REST_PATH = "HiCloudUserInformationService/v1/risks/service/appeal";

        public AppealRecord(Drive drive) throws IOException {
            super(drive, "GET", REST_PATH, null, RisksRecordList.class);
        }

        public AppealRecord setHeader(String str, Object obj) {
            getHeaders().set(str, obj);
            return this;
        }
    }

    public Risks(Drive drive) {
        this.drive = drive;
    }

    public AppealRecord getAppealRecord() throws IOException {
        return new AppealRecord(this.drive);
    }

    public Appeal submitAccountAppeal(RisksRequst risksRequst) throws IOException {
        return new Appeal(this.drive, risksRequst);
    }
}
