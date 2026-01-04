package com.huawei.android.hicloud.task.simple;

import android.os.Handler;
import android.os.Message;
import com.huawei.android.hicloud.cloudbackup.clean.BackupCleanRecordsManager;
import com.huawei.hicloud.notification.manager.HiCloudSceneSpaceMgrManager;
import com.huawei.hicloud.request.cbs.bean.CBSDevice;
import com.huawei.hms.api.ConnectionResult;
import gl.C9964e;
import java.util.Iterator;
import java.util.List;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p709vj.C13452e;
import p711vl.C13466f;

/* renamed from: com.huawei.android.hicloud.task.simple.a2 */
/* loaded from: classes3.dex */
public class C3012a2 extends AbstractC12367d {

    /* renamed from: a */
    public Handler f13142a;

    /* renamed from: com.huawei.android.hicloud.task.simple.a2$a */
    public static class a {

        /* renamed from: a */
        public int f13143a;

        /* renamed from: b */
        public int f13144b;

        /* renamed from: c */
        public int f13145c;

        /* renamed from: d */
        public int f13146d;

        /* renamed from: a */
        public int m18188a() {
            return this.f13144b;
        }

        /* renamed from: b */
        public int m18189b() {
            return this.f13145c;
        }

        /* renamed from: c */
        public int m18190c() {
            return this.f13146d;
        }

        /* renamed from: d */
        public void m18191d(int i10) {
            this.f13143a = i10;
        }

        /* renamed from: e */
        public void m18192e(int i10) {
            this.f13144b = i10;
        }

        /* renamed from: f */
        public void m18193f(int i10) {
            this.f13145c = i10;
        }

        /* renamed from: g */
        public void m18194g(int i10) {
            this.f13146d = i10;
        }

        public String toString() {
            return "ClearData{deviceCode=" + this.f13143a + ", deviceSize=" + this.f13144b + ", recordCode=" + this.f13145c + ", recordSize=" + this.f13146d + '}';
        }
    }

    public C3012a2(Handler handler) {
        this.f13142a = handler;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() {
        Message messageObtain = Message.obtain(this.f13142a);
        a aVar = new a();
        try {
            boolean zM81075b = C13466f.m81073d().m81075b("backup_key", false);
            C11839m.m70688i("QueryClearActivityDataTask", "backupSwitch: " + zM81075b);
            int overMonths = HiCloudSceneSpaceMgrManager.getInstance().getOverMonths(zM81075b ? 1 : 0);
            List<CBSDevice> listM61826o = overMonths > 0 ? C9964e.m61814f().m61826o(false, overMonths) : null;
            if (listM61826o == null) {
                aVar.m18191d(0);
                aVar.m18192e(0);
            } else {
                Iterator<CBSDevice> it = listM61826o.iterator();
                int i10 = 0;
                while (it.hasNext()) {
                    if (!it.next().getDeviceId().equals(C13452e.m80781L().m80950o())) {
                        i10++;
                    }
                }
                C11839m.m70688i("QueryClearActivityDataTask", "queryDeviceDeleteListWithoutCache cbsDevices size: " + i10);
                aVar.m18192e(i10);
            }
        } catch (Exception e10) {
            C11839m.m70687e("QueryClearActivityDataTask", "queryDeviceDeleteListWithoutCache failed, " + e10.getMessage());
            aVar.m18191d(-1);
        }
        try {
            BackupCleanRecordsManager.getInstance().queryAllBackupRecords();
            aVar.m18193f(0);
            aVar.m18194g(BackupCleanRecordsManager.getInstance().getCleanRecordsNum());
        } catch (Exception e11) {
            C11839m.m70688i("QueryClearActivityDataTask", "queryAllBackupRecords failed, " + e11.getMessage());
            aVar.m18193f(-1);
        }
        messageObtain.what = ConnectionResult.NETWORK_ERROR;
        messageObtain.obj = aVar;
        this.f13142a.sendMessage(messageObtain);
    }
}
