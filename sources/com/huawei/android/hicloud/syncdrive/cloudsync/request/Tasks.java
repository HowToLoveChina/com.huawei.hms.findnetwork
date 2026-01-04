package com.huawei.android.hicloud.syncdrive.cloudsync.request;

import com.huawei.cloud.base.util.C4627a0;
import com.huawei.cloud.base.util.InterfaceC4648p;
import com.huawei.cloud.services.drive.Drive;
import java.io.IOException;
import p255ed.AbstractC9455k;

/* loaded from: classes3.dex */
public class Tasks {
    private Drive drive;

    public static class Create extends AbstractC9455k<Void> {
        private static final String REST_PATH = "/dataSync/v1/service/{database}/tasks";

        @InterfaceC4648p
        private String database;

        public Create(Drive drive, String str, TasksCreateRequest tasksCreateRequest) throws IOException {
            super(drive, "POST", REST_PATH, tasksCreateRequest, Void.class);
            this.database = (String) C4627a0.m28392e(str, "Required parameter database must be specified.");
        }

        public String getDatabase() {
            return this.database;
        }

        public void setDatabase(String str) {
            this.database = str;
        }
    }

    public Tasks(Drive drive) {
        this.drive = drive;
    }

    public Create create(String str, TasksCreateRequest tasksCreateRequest) throws IOException {
        return new Create(this.drive, str, tasksCreateRequest);
    }
}
