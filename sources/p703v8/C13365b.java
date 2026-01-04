package p703v8;

import com.huawei.android.hicloud.cloudspace.bean.BackupStorageInfo;
import com.huawei.android.hicloud.cloudspace.bean.CBSpaceDetail;
import com.huawei.phoneservice.faq.base.constants.TrackConstants$Opers;
import java.util.Iterator;
import java.util.List;
import mk.C11477c;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;
import p616rk.C12515a;
import sn.C12818a;

/* renamed from: v8.b */
/* loaded from: classes2.dex */
public class C13365b extends C12818a<BackupStorageInfo> {

    /* renamed from: a */
    public C13366c f60244a = new C13366c();

    /* renamed from: v8.b$a */
    public class a extends AbstractC12367d {

        /* renamed from: a */
        public BackupStorageInfo f60245a;

        public a(BackupStorageInfo backupStorageInfo) {
            this.f60245a = backupStorageInfo;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            BackupStorageInfo backupStorageInfo = this.f60245a;
            if (backupStorageInfo == null) {
                return;
            }
            C13365b.this.m80167l(backupStorageInfo.getBackupDetails());
            C13365b.this.m80167l(this.f60245a.getOtherDeviceBackupDetails());
            C13365b.this.m80166k(this.f60245a.getCurrentDeviceBackupDetails());
            C13365b.this.m76963d(this.f60245a);
        }

        @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
        public AbstractRunnableC12516b.a getEnum() {
            return AbstractRunnableC12516b.a.ENCRYPT_DATA_SINGLE;
        }
    }

    @Override // sn.C12818a
    /* renamed from: a */
    public String mo76960a() {
        return "BackupStorageRequestor";
    }

    /* renamed from: h */
    public final void m80163h(CBSpaceDetail cBSpaceDetail) {
        if (cBSpaceDetail != null) {
            String strM68631a = C11477c.m68631a(cBSpaceDetail.getDeviceID());
            String strM68631a2 = C11477c.m68631a(cBSpaceDetail.getDeviceName());
            String strM68631a3 = C11477c.m68631a(cBSpaceDetail.getDevDisplayName());
            String strM68631a4 = C11477c.m68631a(cBSpaceDetail.getBackupDeviceId());
            cBSpaceDetail.setDeviceID(strM68631a);
            cBSpaceDetail.setDeviceName(strM68631a2);
            cBSpaceDetail.setDevDisplayName(strM68631a3);
            cBSpaceDetail.setBackupDeviceId(strM68631a4);
        }
    }

    /* renamed from: i */
    public final void m80164i(List<CBSpaceDetail> list) {
        if (list != null) {
            Iterator<CBSpaceDetail> it = list.iterator();
            while (it.hasNext()) {
                m80163h(it.next());
            }
        }
    }

    /* renamed from: j */
    public void m80165j(BackupStorageInfo backupStorageInfo) {
        if (backupStorageInfo == null) {
            return;
        }
        m80164i(backupStorageInfo.getBackupDetails());
        m80164i(backupStorageInfo.getOtherDeviceBackupDetails());
        m80163h(backupStorageInfo.getCurrentDeviceBackupDetails());
    }

    /* renamed from: k */
    public final void m80166k(CBSpaceDetail cBSpaceDetail) {
        if (cBSpaceDetail != null) {
            String strM68634d = C11477c.m68634d(cBSpaceDetail.getDeviceID());
            String strM68634d2 = C11477c.m68634d(cBSpaceDetail.getDeviceName());
            String strM68634d3 = C11477c.m68634d(cBSpaceDetail.getDevDisplayName());
            String strM68634d4 = C11477c.m68634d(cBSpaceDetail.getBackupDeviceId());
            cBSpaceDetail.setDeviceID(strM68634d);
            cBSpaceDetail.setDeviceName(strM68634d2);
            cBSpaceDetail.setDevDisplayName(strM68634d3);
            cBSpaceDetail.setBackupDeviceId(strM68634d4);
        }
    }

    /* renamed from: l */
    public final void m80167l(List<CBSpaceDetail> list) {
        if (list != null) {
            Iterator<CBSpaceDetail> it = list.iterator();
            while (it.hasNext()) {
                m80166k(it.next());
            }
        }
    }

    /* renamed from: m */
    public void m80168m(BackupStorageInfo backupStorageInfo) {
        if (backupStorageInfo == null) {
            return;
        }
        C12515a.m75110o().m75175e(new a(backupStorageInfo), false);
    }

    /* renamed from: n */
    public BackupStorageInfo m80169n() {
        C11839m.m70688i("BackupStorageReliableRequestor", TrackConstants$Opers.REQUEST);
        BackupStorageInfo backupStorageInfoM80173d = this.f60244a.m80173d();
        if (backupStorageInfoM80173d == null) {
            backupStorageInfoM80173d = m76961b();
            m80165j(backupStorageInfoM80173d);
        } else {
            C13379p.m80310f().m80311a(backupStorageInfoM80173d);
            m80168m(backupStorageInfoM80173d);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("request finish, storageInfo is null: ");
        sb2.append(backupStorageInfoM80173d == null);
        C11839m.m70688i("BackupStorageReliableRequestor", sb2.toString());
        return backupStorageInfoM80173d;
    }
}
