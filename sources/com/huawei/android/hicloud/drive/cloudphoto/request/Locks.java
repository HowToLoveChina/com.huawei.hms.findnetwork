package com.huawei.android.hicloud.drive.cloudphoto.request;

import com.huawei.android.hicloud.drive.cloudphoto.model.Lock;
import com.huawei.cloud.services.drive.Drive;
import java.io.IOException;
import p015ak.C0209d;
import p709vj.C13452e;
import p804ya.AbstractC13930g;

/* loaded from: classes3.dex */
public class Locks {
    private static final String REST_PATH = "cloudPhoto/v1/lock";
    private Drive client;

    public static class Delete extends AbstractC13930g<Void> {
        private static final String INTERFACE = "Lock.delete";

        public Delete(Drive drive) throws IOException {
            super(drive, "DELETE", Locks.REST_PATH, null, Void.class);
            getHeaders().set("x-hw-interface", INTERFACE);
        }

        @Override // p804ya.AbstractC13930g
        public Delete addHeader(String str, Object obj) {
            getHeaders().set(str, obj);
            return this;
        }
    }

    public static class Get extends AbstractC13930g<Lock> {
        private static final String INTERFACE = "Lock.get";

        public Get(Drive drive) throws IOException {
            super(drive, "GET", Locks.REST_PATH, null, Lock.class);
            getHeaders().set("x-hw-interface", INTERFACE);
        }

        @Override // p804ya.AbstractC13930g
        public Get addHeader(String str, Object obj) {
            getHeaders().set(str, obj);
            return this;
        }
    }

    public static class VFC {
        private final Drive client;

        public static class Get extends AbstractC13930g<Void> {
            private static final String INTERFACE = "Lock.vfc.get";
            private static final String REST_PATH = "/cloudPhoto/v1/lock/vfc";

            public Get(Drive drive, String str, String str2, String str3) throws IOException {
                super(drive, "GET", REST_PATH, null, Void.class);
                getHeaders().set("x-hw-interface", INTERFACE);
                getHeaders().set("lockAction", str);
                getHeaders().set("x-hw-user-grade", C13452e.m80781L().m80790C());
                getHeaders().set("x-hw-sync-device-id", C0209d.m1209S1(C13452e.m80781L().m80954p()));
                getHeaders().set("x-hw-sync-times", str2);
                getHeaders().set("x-hw-sync-seconds", str3);
            }
        }

        public VFC(Drive drive) {
            this.client = drive;
        }

        public Get get(String str, String str2, String str3) throws IOException {
            return new Get(this.client, str, str2, str3);
        }
    }

    public Locks(Drive drive) {
        this.client = drive;
    }

    public Delete delete() throws IOException {
        return new Delete(this.client);
    }

    public Get get() throws IOException {
        return new Get(this.client);
    }

    public VFC vfc() {
        return new VFC(this.client);
    }
}
