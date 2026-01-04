package p618rm;

import com.huawei.android.hicloud.cloudbackup.service.C2695b;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.Bak;
import com.huawei.hicloud.request.cbs.bean.CBSBackupRecord;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import p514o9.C11839m;
import p815ym.AbstractC14026a;

/* renamed from: rm.x0 */
/* loaded from: classes6.dex */
public class C12605x0 {
    /* renamed from: c */
    public static CBSBackupRecord m76069c(List<CBSBackupRecord> list, final String str) {
        if (AbstractC14026a.m84159a(list)) {
            C11839m.m70688i("DeleteRecordsUtil", "getLatestBackupRecord input list is empty.");
            return null;
        }
        CBSBackupRecord cBSBackupRecord = (CBSBackupRecord) ((List) list.stream().filter(new Predicate() { // from class: rm.u0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return C12605x0.m76073g(str, (CBSBackupRecord) obj);
            }
        }).collect(Collectors.toCollection(new C2695b()))).stream().max(Comparator.comparingLong(new C12599v0())).orElse(null);
        if (cBSBackupRecord == null) {
            C11839m.m70688i("DeleteRecordsUtil", "getLatestBackupRecord end,backup record is null");
        } else {
            C11839m.m70688i("DeleteRecordsUtil", "getLatestBackupRecord end,backupId is:" + cBSBackupRecord.getBackupId() + ",endTime is:" + cBSBackupRecord.getEndTime());
        }
        return cBSBackupRecord;
    }

    /* renamed from: d */
    public static List<CBSBackupRecord> m76070d(List<CBSBackupRecord> list, final int i10, final String str) {
        List<CBSBackupRecord> arrayList = new ArrayList<>();
        if (AbstractC14026a.m84159a(list) || str == null) {
            C11839m.m70688i("DeleteRecordsUtil", "getSortedBackupRecordListByBmDataType input list is empty or deviceId is null.");
            return arrayList;
        }
        List list2 = (List) list.stream().filter(new Predicate() { // from class: rm.w0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return C12605x0.m76074h(str, i10, (CBSBackupRecord) obj);
            }
        }).collect(Collectors.toCollection(new C2695b()));
        if (!AbstractC14026a.m84159a(list2)) {
            arrayList = (List) list2.stream().sorted(Comparator.comparingLong(new C12599v0()).reversed()).collect(Collectors.toCollection(new C2695b()));
        }
        C11839m.m70688i("DeleteRecordsUtil", "getSortedBackupRecordListByBmDataType result size:" + arrayList.size());
        return arrayList;
    }

    /* renamed from: e */
    public static List<CBSBackupRecord> m76071e(List<CBSBackupRecord> list, String str, int i10) {
        ArrayList arrayList = new ArrayList();
        if (!AbstractC14026a.m84159a(list) && i10 > 0) {
            return (List) m76070d(list, 1, str).stream().skip(i10).collect(Collectors.toCollection(new C2695b()));
        }
        C11839m.m70688i("DeleteRecordsUtil", "getToBeDeletedBaseRecords input list is empty or skipNum <=0");
        return arrayList;
    }

    /* renamed from: f */
    public static boolean m76072f(List<Bak> list) {
        if (AbstractC14026a.m84159a(list)) {
            C11839m.m70688i("DeleteRecordsUtil", "isLatestBakBaseDataRecord input list is empty.");
            return false;
        }
        Bak bak = null;
        for (Bak bak2 : list) {
            if (bak == null || bak.getEndTime().m28458c() < bak2.getEndTime().m28458c()) {
                bak = bak2;
            }
        }
        C11839m.m70688i("DeleteRecordsUtil", "latestBak is:" + bak.getId() + ",endTime:" + bak.getEndTime());
        return bak.getBmDataType().intValue() == 1;
    }

    /* renamed from: g */
    public static /* synthetic */ boolean m76073g(String str, CBSBackupRecord cBSBackupRecord) {
        return cBSBackupRecord.getStatus() == 0 && str.equals(cBSBackupRecord.getDevice().getDeviceId());
    }

    /* renamed from: h */
    public static /* synthetic */ boolean m76074h(String str, int i10, CBSBackupRecord cBSBackupRecord) {
        return cBSBackupRecord.getStatus() == 0 && str.equals(cBSBackupRecord.getDevice().getDeviceId()) && cBSBackupRecord.getBmDataType() == i10;
    }
}
