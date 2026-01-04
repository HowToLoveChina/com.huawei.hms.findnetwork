package com.huawei.android.hicloud.drive.cloudphoto.request;

import com.huawei.android.hicloud.drive.cloudphoto.model.TasksCreateRequest;
import com.huawei.cloud.services.drive.Drive;
import java.io.IOException;
import p804ya.AbstractC13930g;

/* loaded from: classes3.dex */
public class Tasks {
    private Drive drive;

    public static class Create extends AbstractC13930g<Void> {
        private static final String REST_PATH = "cloudPhoto/v1/tasks";

        public Create(Drive drive, TasksCreateRequest tasksCreateRequest) throws IOException {
            super(drive, "POST", REST_PATH, tasksCreateRequest, Void.class);
        }
    }

    public Tasks(Drive drive) {
        this.drive = drive;
    }

    public Create create(TasksCreateRequest tasksCreateRequest) throws IOException {
        return new Create(this.drive, tasksCreateRequest);
    }
}
