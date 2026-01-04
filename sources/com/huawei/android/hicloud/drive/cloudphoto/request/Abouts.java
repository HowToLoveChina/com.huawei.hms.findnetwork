package com.huawei.android.hicloud.drive.cloudphoto.request;

import android.text.TextUtils;
import com.huawei.android.hicloud.drive.cloudphoto.model.About;
import com.huawei.cloud.services.drive.Drive;
import java.io.IOException;
import p709vj.C13452e;
import p804ya.AbstractC13930g;

/* loaded from: classes3.dex */
public class Abouts {
    private Drive drive;

    public static class Get extends AbstractC13930g<About> {
        private static final String REST_PATH = "cloudPhoto/v1/about";

        public Get(Drive drive) throws IOException {
            super(drive, "GET", REST_PATH, null, About.class);
            String strM80790C = C13452e.m80781L().m80790C();
            if (TextUtils.isEmpty(strM80790C)) {
                return;
            }
            getHeaders().set("x-hw-grade", strM80790C);
        }
    }

    public Abouts(Drive drive) {
        this.drive = drive;
    }

    public Get get() throws IOException {
        return new Get(this.drive);
    }
}
