package p703v8;

import com.huawei.android.hicloud.cloudspace.bean.BackupStorageInfo;
import com.huawei.android.hicloud.cloudspace.bean.CBSpaceDetail;
import com.huawei.hicloud.router.data.UserBackupInfo;
import fk.C9721b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import p015ak.C0209d;
import p020ap.C1007b;
import p292fn.C9733f;
import p514o9.C11839m;
import p709vj.C13452e;

/* renamed from: v8.c */
/* loaded from: classes2.dex */
public class C13366c {

    /* renamed from: a */
    public long f60247a = -1;

    /* renamed from: b */
    public BackupStorageInfo f60248b;

    /* renamed from: c */
    public int f60249c;

    /* renamed from: a */
    public final void m80170a() {
        this.f60247a = -1L;
    }

    /* renamed from: b */
    public int m80171b() {
        return this.f60249c;
    }

    /* renamed from: c */
    public final List<CBSpaceDetail> m80172c(List<UserBackupInfo.UserDeviceInfo> list, boolean z10) {
        ArrayList arrayList = new ArrayList();
        UserBackupInfo.UserDeviceInfo userDeviceInfo = null;
        for (UserBackupInfo.UserDeviceInfo userDeviceInfo2 : list) {
            if (userDeviceInfo2 != null) {
                if (userDeviceInfo2.isCurrent() && !userDeviceInfo2.isTempBackUp() && (userDeviceInfo == null || userDeviceInfo.getLastbackupTime() < userDeviceInfo2.getLastbackupTime())) {
                    userDeviceInfo = userDeviceInfo2;
                }
                CBSpaceDetail cBSpaceDetail = new CBSpaceDetail();
                cBSpaceDetail.setDeviceType(userDeviceInfo2.getDeviceType());
                cBSpaceDetail.setBackupDeviceId(userDeviceInfo2.getBackupDeviceId());
                cBSpaceDetail.setDeviceID(userDeviceInfo2.getDeviceID());
                long size = userDeviceInfo2.getSize();
                if (userDeviceInfo2.isTempBackUp() && userDeviceInfo2.getOccupySpaceType() != null && userDeviceInfo2.getOccupySpaceType().intValue() == 0) {
                    C11839m.m70688i("BackupStorageRequestor", "do not need sum size");
                } else {
                    this.f60247a += size;
                }
                cBSpaceDetail.setSize(size);
                cBSpaceDetail.setCurrent(userDeviceInfo2.isCurrent());
                cBSpaceDetail.setLastbackupTime(userDeviceInfo2.getLastbackupTime());
                cBSpaceDetail.setDevDisplayName(userDeviceInfo2.getDevDisplayName());
                cBSpaceDetail.setDeviceName(userDeviceInfo2.getDeviceName());
                cBSpaceDetail.setDeviceCategory(userDeviceInfo2.getDeviceCategory());
                cBSpaceDetail.setOnlyRefurbish(userDeviceInfo2.isOnlyRefurbish());
                cBSpaceDetail.setOnlyHarmonyNext(userDeviceInfo2.isOnlyHarmonyNext());
                cBSpaceDetail.setHasRefurbish(userDeviceInfo2.isHasRefurbish());
                cBSpaceDetail.setTempBackup(userDeviceInfo2.isTempBackUp());
                cBSpaceDetail.setBakId(userDeviceInfo2.getBakId());
                cBSpaceDetail.setExtraDeviceInfos(userDeviceInfo2.getExtraDeviceInfos());
                cBSpaceDetail.setTerminalType(userDeviceInfo2.getTerminalType());
                arrayList.add(cBSpaceDetail);
            }
        }
        if (!z10) {
            C1007b.m5980s().m6010b0(list);
        } else if (userDeviceInfo != null) {
            C1007b.m5980s().m6008a0(userDeviceInfo);
        }
        return arrayList;
    }

    /* renamed from: d */
    public BackupStorageInfo m80173d() {
        return m80174e(false, true, false, 0);
    }

    /* renamed from: e */
    public BackupStorageInfo m80174e(boolean z10, boolean z11, boolean z12, int i10) {
        UserBackupInfo userBackupInfoM6026q;
        List<UserBackupInfo.UserDeviceInfo> userBackupInfos;
        m80170a();
        this.f60248b = new BackupStorageInfo();
        try {
            userBackupInfoM6026q = C1007b.m5980s().m6026q(true, z10, z12, i10);
            this.f60249c = userBackupInfoM6026q.getRetCode();
            userBackupInfos = userBackupInfoM6026q.getUserBackupInfos();
        } catch (C9721b e10) {
            this.f60249c = e10.m60659c();
            C11839m.m70689w("BackupStorageRequestor", "get user cloudbackup space failed." + e10.toString());
            this.f60248b = null;
        }
        if (userBackupInfos == null) {
            return this.f60248b;
        }
        List<CBSpaceDetail> listM80172c = m80172c(userBackupInfos, z10);
        Collections.sort(listM80172c);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (CBSpaceDetail cBSpaceDetail : listM80172c) {
            if (cBSpaceDetail != null) {
                boolean zM60720O = C9733f.m60705z().m60720O("cloudBackupDeviceNameManagement");
                if (cBSpaceDetail.isCurrent() && !zM60720O && !C13452e.m80781L().m80887a1()) {
                    String strM1171G = C0209d.m1171G();
                    cBSpaceDetail.setDevDisplayName(strM1171G);
                    cBSpaceDetail.setDeviceName(strM1171G);
                }
                if (!cBSpaceDetail.isCurrent() || cBSpaceDetail.isTempBackup()) {
                    if (arrayList2.contains(cBSpaceDetail) && arrayList2.get(0).isOnlyRefurbish() && !cBSpaceDetail.isOnlyRefurbish() && (cBSpaceDetail.getLastbackupTime() > 0 || cBSpaceDetail.getSize() > 0)) {
                        arrayList2.remove(0);
                    }
                    if (!arrayList2.contains(cBSpaceDetail)) {
                        arrayList2.add(cBSpaceDetail);
                    }
                } else {
                    if (arrayList.contains(cBSpaceDetail) && arrayList.get(0).isOnlyRefurbish() && !cBSpaceDetail.isOnlyRefurbish() && (cBSpaceDetail.getLastbackupTime() > 0 || cBSpaceDetail.getSize() > 0)) {
                        arrayList.remove(0);
                    }
                    if (!arrayList.contains(cBSpaceDetail)) {
                        arrayList.add(cBSpaceDetail);
                        BackupStorageInfo backupStorageInfo = this.f60248b;
                        if (backupStorageInfo != null) {
                            backupStorageInfo.setCurrentDeviceBackupDetails(cBSpaceDetail);
                        }
                    }
                }
            }
        }
        m80176g(arrayList2, arrayList);
        m80175f(userBackupInfoM6026q);
        this.f60248b.setBackupDetails(arrayList);
        C11839m.m70688i("BackupStorageRequestor", "backup detail size = " + arrayList.size());
        return this.f60248b;
    }

    /* renamed from: f */
    public final void m80175f(UserBackupInfo userBackupInfo) {
        if (this.f60248b == null) {
            return;
        }
        long size = userBackupInfo.getSize() >= 0 ? userBackupInfo.getSize() : 0L;
        this.f60248b.setBackupUsedSize(size);
        if (size != this.f60247a) {
            C11839m.m70688i("BackupStorageRequestor", "usedSize not equal to backupUsedSize: usedSize = " + size + " backupUsedSize = " + this.f60247a);
        }
    }

    /* renamed from: g */
    public final void m80176g(List<CBSpaceDetail> list, List<CBSpaceDetail> list2) {
        if (list.isEmpty()) {
            return;
        }
        Collections.sort(list);
        BackupStorageInfo backupStorageInfo = this.f60248b;
        if (backupStorageInfo != null) {
            backupStorageInfo.setOtherDeviceBackupDetails(list);
        }
        list2.addAll(list);
    }
}
