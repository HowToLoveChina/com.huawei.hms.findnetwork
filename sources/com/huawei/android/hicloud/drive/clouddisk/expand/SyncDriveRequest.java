package com.huawei.android.hicloud.drive.clouddisk.expand;

import bb.C1160a;
import com.huawei.cloud.services.drive.DriveRequest;
import com.huawei.hicloud.dnskpr.DnsKprUtil;
import fk.C9721b;
import java.io.IOException;
import p283fa.C9679b;
import p336he.C10156g;
import p709vj.C13452e;
import tm.C13040c;
import vi.C13446a;

/* loaded from: classes3.dex */
public class SyncDriveRequest<T> {
    private static final String TAG = "SyncDriveRequest";
    private DriveRequest<T> request;

    public SyncDriveRequest(DriveRequest<T> driveRequest) {
        this.request = driveRequest;
    }

    public T execute() throws C9721b, IOException {
        try {
            C10156g.m63309f(this.request);
            C1160a.m7250a(this.request.getHeaders());
            T tExecute = this.request.execute();
            C10156g.m63310g(this.request.getLastResponseHeaders());
            return tExecute;
        } catch (IOException e10) {
            if ((e10 instanceof C13446a) && !DnsKprUtil.m29898g()) {
                C13040c.m78609F().m78651i();
                C9679b.m60452d().m60458h();
                C13452e.m80781L().m80988x1("from_sysConfRefresh");
            }
            throw e10;
        }
    }
}
