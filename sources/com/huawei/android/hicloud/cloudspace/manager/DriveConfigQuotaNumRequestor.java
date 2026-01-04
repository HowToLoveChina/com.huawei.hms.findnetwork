package com.huawei.android.hicloud.cloudspace.manager;

import android.content.Context;
import com.huawei.android.hicloud.cloudspace.bean.HDSpaceDetail;
import com.huawei.hicloud.bean.DriveConfigQuotaCountData;
import com.huawei.hicloud.bean.DriveConfigService;
import com.huawei.hicloud.bean.SyncConfigService;
import com.huawei.hicloud.notification.syncconfig.IQueryNumFinished;
import com.huawei.hicloud.notification.util.NotifyUtil;
import fk.C9722c;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import je.C10812z;
import p015ak.C0213f;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;
import p616rk.C12515a;
import p703v8.C13374k;

/* loaded from: classes2.dex */
public class DriveConfigQuotaNumRequestor implements IQueryNumFinished {

    /* renamed from: a */
    public Context f11833a;

    /* renamed from: b */
    public CountDownLatch f11834b;

    /* renamed from: com.huawei.android.hicloud.cloudspace.manager.DriveConfigQuotaNumRequestor$a */
    public static class C2740a extends AbstractC12367d {

        /* renamed from: a */
        public DriveConfigService f11835a;

        /* renamed from: b */
        public IQueryNumFinished f11836b;

        /* renamed from: c */
        public CountDownLatch f11837c;

        /* renamed from: d */
        public Context f11838d;

        public C2740a(DriveConfigService driveConfigService, IQueryNumFinished iQueryNumFinished, CountDownLatch countDownLatch, Context context) {
            this.f11835a = driveConfigService;
            this.f11836b = iQueryNumFinished;
            this.f11837c = countDownLatch;
            this.f11838d = context;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws Throwable {
            C11839m.m70688i("DriveConfigQueryQutoNumTask", "driveConfig queryQuotaNum start service = " + this.f11835a.getId());
            HDSpaceDetail hDSpaceDetailM80298a = new C13374k(this.f11838d, C10812z.m65832a("03007"), this.f11835a).m80298a();
            if (hDSpaceDetailM80298a != null) {
                long fsize = hDSpaceDetailM80298a.getFsize();
                if (fsize > 0) {
                    C11839m.m70688i("DriveConfigQueryQutoNumTask", "driveConfig queryQuotaNum serviceId added");
                    DriveConfigQuotaCountData driveConfigQuotaCountData = new DriveConfigQuotaCountData();
                    driveConfigQuotaCountData.setFsize(fsize);
                    driveConfigQuotaCountData.setDcount(hDSpaceDetailM80298a.getDcount());
                    driveConfigQuotaCountData.setQuota(fsize);
                    driveConfigQuotaCountData.setModuleName("driveConfig");
                    driveConfigQuotaCountData.setServiceId(hDSpaceDetailM80298a.getServiceId());
                    this.f11835a.setQuotaCounts(driveConfigQuotaCountData);
                }
            }
            this.f11836b.onNumQueryFinished(this.f11835a);
            this.f11837c.countDown();
        }

        @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
        public AbstractRunnableC12516b.a getEnum() {
            return AbstractRunnableC12516b.a.DRIVE_CONFIG;
        }

        @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
        public boolean syncLock() {
            return false;
        }
    }

    public DriveConfigQuotaNumRequestor(Context context) {
        this.f11833a = context;
    }

    /* renamed from: a */
    public final void m15486a(DriveConfigService driveConfigService) throws C9722c, IOException {
        C12515a.m75110o().m75172d(new C2740a(driveConfigService, this, this.f11834b, this.f11833a));
    }

    /* renamed from: b */
    public List<DriveConfigService> m15487b() {
        try {
            C11839m.m70686d("DriveConfigQuotaNumRequestor", "driveConfig request");
            ArrayList<DriveConfigService> shownDriveServiceItems = NotifyUtil.getShownDriveServiceItems(C0213f.m1377a());
            if (shownDriveServiceItems.size() <= 0) {
                return null;
            }
            this.f11834b = new CountDownLatch(shownDriveServiceItems.size());
            Iterator<DriveConfigService> it = shownDriveServiceItems.iterator();
            while (it.hasNext()) {
                m15486a(it.next());
            }
            if (this.f11834b.await(30000L, TimeUnit.MILLISECONDS)) {
                C11839m.m70688i("DriveConfigQuotaNumRequestor", "driveConfig all task finished");
            }
            return shownDriveServiceItems;
        } catch (Exception e10) {
            C11839m.m70687e("DriveConfigQuotaNumRequestor", "DriveConfigQuotaNumRequestor request exception:" + e10.toString());
            return null;
        }
    }

    @Override // com.huawei.hicloud.notification.syncconfig.IQueryNumFinished
    public void onNumQueryFinished(DriveConfigService driveConfigService) {
    }

    @Override // com.huawei.hicloud.notification.syncconfig.IQueryNumFinished
    public void onNumQueryFinished(SyncConfigService syncConfigService) {
    }
}
