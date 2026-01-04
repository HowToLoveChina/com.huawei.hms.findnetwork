package com.huawei.android.hicloud.syncdrive.cloudsync.request;

import android.text.TextUtils;
import com.huawei.android.hicloud.drive.clouddisk.model.DataBaseListResponse;
import com.huawei.cloud.services.drive.Drive;
import java.io.IOException;
import p255ed.AbstractC9455k;
import p709vj.C13452e;

/* loaded from: classes3.dex */
public class DataBaseListRequest {
    private final Drive drive;

    public static class Get extends AbstractC9455k<DataBaseListResponse> {
        private static final String REST_PATH = "dataSync/v1/service/database/list";

        public Get(Drive drive) throws IOException {
            super(drive, "GET", REST_PATH, null, DataBaseListResponse.class);
            String strM80790C = C13452e.m80781L().m80790C();
            if (TextUtils.isEmpty(strM80790C)) {
                return;
            }
            getHeaders().set("x-hw-grade", strM80790C);
        }

        @Override // p255ed.AbstractC9455k
        public Get addHeader(String str, Object obj) {
            getHeaders().set(str, obj);
            return this;
        }
    }

    public DataBaseListRequest(Drive drive) {
        this.drive = drive;
    }

    public Get get() throws IOException {
        return new Get(this.drive);
    }
}
