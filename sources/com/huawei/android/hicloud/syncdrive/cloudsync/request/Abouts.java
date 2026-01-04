package com.huawei.android.hicloud.syncdrive.cloudsync.request;

import android.text.TextUtils;
import com.huawei.android.hicloud.syncdrive.cloudsync.model.About;
import com.huawei.cloud.base.util.C4627a0;
import com.huawei.cloud.base.util.InterfaceC4648p;
import com.huawei.cloud.services.drive.Drive;
import java.io.IOException;
import p255ed.AbstractC9455k;
import p709vj.C13452e;

/* loaded from: classes3.dex */
public class Abouts {
    private Drive drive;

    public static class Get extends AbstractC9455k<About> {
        private static final String REST_PATH = "dataSync/v1/service/{database}/about";

        @InterfaceC4648p
        private String database;

        public Get(Drive drive, String str) throws IOException {
            super(drive, "GET", REST_PATH, null, About.class);
            String strM80790C = C13452e.m80781L().m80790C();
            if (!TextUtils.isEmpty(strM80790C)) {
                getHeaders().set("x-hw-grade", strM80790C);
            }
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

    public Abouts(Drive drive) {
        this.drive = drive;
    }

    public Get get(String str) throws IOException {
        return new Get(this.drive, str);
    }
}
