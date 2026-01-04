package com.huawei.android.hicloud.syncdrive.cloudsync.request;

import com.huawei.android.hicloud.syncdrive.cloudsync.model.Lock;
import com.huawei.cloud.base.util.C4627a0;
import com.huawei.cloud.base.util.InterfaceC4648p;
import com.huawei.cloud.services.drive.Drive;
import java.io.IOException;
import p255ed.AbstractC9455k;

/* loaded from: classes3.dex */
public class Locks {
    private static final String REST_PATH = "dataSync/v1/service/{database}/lock";
    private Drive drive;

    public static class Delete extends AbstractC9455k<Void> {

        @InterfaceC4648p
        private String database;

        public Delete(Drive drive, String str) throws IOException {
            super(drive, "DELETE", Locks.REST_PATH, null, Void.class);
            this.database = (String) C4627a0.m28392e(str, "Required parameter database must be specified.");
        }

        public String getDatabase() {
            return this.database;
        }

        @Override // p255ed.AbstractC9455k
        public Delete addHeader(String str, Object obj) {
            getHeaders().set(str, obj);
            return this;
        }
    }

    public static class Get extends AbstractC9455k<Lock> {

        @InterfaceC4648p
        private String database;

        public Get(Drive drive, String str) throws IOException {
            super(drive, "GET", Locks.REST_PATH, null, Lock.class);
            this.database = (String) C4627a0.m28392e(str, "Required parameter database must be specified.");
        }

        public String getDatabase() {
            return this.database;
        }

        public Get setDatabase(String str) {
            this.database = str;
            return this;
        }

        @Override // p255ed.AbstractC9455k
        public Get addHeader(String str, Object obj) {
            getHeaders().set(str, obj);
            return this;
        }
    }

    public Locks(Drive drive) {
        this.drive = drive;
    }

    public Delete delete(String str) throws IOException {
        return new Delete(this.drive, str);
    }

    public Get get(String str) throws IOException {
        return new Get(this.drive, str);
    }
}
