package p618rm;

import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.bean.SnapshotBackupMeta;
import com.huawei.hicloud.cloudbackup.model.CloudRestoreItem;
import com.huawei.hicloud.cloudbackup.model.RestoreStatus;
import com.huawei.hicloud.cloudbackup.p104v3.model.BackupStatus;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.AppDetailsInfo;
import com.huawei.hicloud.cloudbackup.store.database.tags.BackupOptionItem;
import com.huawei.uikit.hwalphaindexerlistview.utils.HwTextPinyinUtil;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import p514o9.C11839m;
import p783xp.C13843a;
import p848zl.C14333b;

/* renamed from: rm.p */
/* loaded from: classes6.dex */
public class C12580p {

    /* renamed from: a */
    public static final Collator f57941a = Collator.getInstance();

    /* renamed from: rm.p$a */
    public static class a implements Comparator<CloudRestoreItem> {
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(CloudRestoreItem cloudRestoreItem, CloudRestoreItem cloudRestoreItem2) {
            return Boolean.compare(cloudRestoreItem2.isCompatible(), cloudRestoreItem.isCompatible());
        }
    }

    /* renamed from: rm.p$b */
    public static class b implements Comparator<CloudRestoreItem> {
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(CloudRestoreItem cloudRestoreItem, CloudRestoreItem cloudRestoreItem2) {
            if (TextUtils.equals(cloudRestoreItem.getAppId(), "thirdApp")) {
                return 1;
            }
            if (TextUtils.equals(cloudRestoreItem2.getAppId(), "thirdApp")) {
                return -1;
            }
            String appName = cloudRestoreItem.getAppName();
            String appName2 = cloudRestoreItem2.getAppName();
            String strM83056H = C13843a.m83056H(appName);
            String strM83056H2 = C13843a.m83056H(appName2);
            if ("".equals(strM83056H) && "".equals(strM83056H2)) {
                return C12580p.f57941a.compare(appName, appName2);
            }
            if ("".equals(strM83056H)) {
                return 1;
            }
            if ("".equals(strM83056H2)) {
                return -1;
            }
            return C12580p.f57941a.compare(strM83056H, strM83056H2);
        }
    }

    /* renamed from: A */
    public static int m75563A(AppDetailsInfo appDetailsInfo, AppDetailsInfo appDetailsInfo2) {
        if ("baseData".equals(appDetailsInfo.getBackupAppName()) || "baseData".equals(appDetailsInfo2.getBackupAppName())) {
            return 1;
        }
        int iM75588v = m75588v(appDetailsInfo.getTotalSize(), appDetailsInfo2.getTotalSize());
        return iM75588v == 0 ? m75586t(appDetailsInfo.getBackupAppName(), appDetailsInfo2.getBackupAppName()) : iM75588v;
    }

    /* renamed from: B */
    public static int m75564B(BackupOptionItem backupOptionItem, BackupOptionItem backupOptionItem2) {
        int iM75588v = m75588v(backupOptionItem.getDataBytes(), backupOptionItem2.getDataBytes());
        return iM75588v == 0 ? m75586t(backupOptionItem.getAppName(), backupOptionItem2.getAppName()) : iM75588v;
    }

    /* renamed from: C */
    public static int m75565C(BackupOptionItem backupOptionItem, BackupOptionItem backupOptionItem2) {
        int iM75584r = m75584r(backupOptionItem.getAppId(), backupOptionItem2.getAppId());
        return iM75584r == 0 ? m75586t(backupOptionItem.getAppName(), backupOptionItem2.getAppName()) : iM75584r;
    }

    /* renamed from: D */
    public static int m75566D(BackupOptionItem backupOptionItem, BackupOptionItem backupOptionItem2) {
        int iM75588v = m75588v(backupOptionItem.getDataBytes() + backupOptionItem.getCodeBytes(), backupOptionItem2.getDataBytes() + backupOptionItem2.getCodeBytes());
        return iM75588v == 0 ? m75586t(backupOptionItem.getAppName(), backupOptionItem2.getAppName()) : iM75588v;
    }

    /* renamed from: b */
    public static int m75568b(BackupStatus backupStatus, BackupStatus backupStatus2) {
        if (backupStatus.m29862O() && backupStatus2.m29862O()) {
            return m75569c(backupStatus, backupStatus2);
        }
        if (backupStatus.m29862O()) {
            return -1;
        }
        if (backupStatus2.m29862O()) {
            return 1;
        }
        return m75569c(backupStatus, backupStatus2);
    }

    /* renamed from: c */
    public static int m75569c(BackupStatus backupStatus, BackupStatus backupStatus2) {
        C11839m.m70686d("CloudBackupModuleUtil", "backupFinalSort status1: " + backupStatus.mo29421n() + ",status2," + backupStatus2.mo29421n());
        int iM75584r = m75584r(backupStatus.mo29421n(), backupStatus2.mo29421n());
        if (iM75584r != 0) {
            return iM75584r;
        }
        int iM75586t = m75586t(backupStatus.m29871e(), backupStatus2.m29871e());
        if (iM75586t != 0) {
            return iM75586t;
        }
        if (backupStatus.m29861N() == backupStatus2.m29861N()) {
            return 0;
        }
        return backupStatus.m29861N() == 0 ? -1 : 1;
    }

    /* renamed from: d */
    public static int m75570d(BackupStatus backupStatus, BackupStatus backupStatus2) {
        int iM75590x = m75590x(backupStatus.m29870d(), backupStatus2.m29870d());
        if (iM75590x != 0) {
            return iM75590x;
        }
        int iM75591y = m75591y(backupStatus.m29870d(), backupStatus2.m29870d());
        if (iM75591y != 0) {
            return iM75591y;
        }
        int iM75583q = m75583q(backupStatus.m29872f(), backupStatus2.m29872f());
        return iM75583q == 0 ? backupStatus.m29863P() ? m75568b(backupStatus, backupStatus2) : m75569c(backupStatus, backupStatus2) : iM75583q;
    }

    /* renamed from: e */
    public static long m75571e(CloudRestoreItem cloudRestoreItem, boolean z10, boolean z11) {
        return (!cloudRestoreItem.m29187M() || (z10 && !z11)) ? cloudRestoreItem.getSize() + cloudRestoreItem.getAsize() : cloudRestoreItem.getSize();
    }

    /* renamed from: f */
    public static String m75572f(String str) {
        return TextUtils.isEmpty(str) ? "#" : HwTextPinyinUtil.isChinaString(str) ? C13843a.m83056H(str) : str;
    }

    /* renamed from: g */
    public static boolean m75573g(RestoreStatus restoreStatus) {
        return C14333b.m85486u().containsKey(restoreStatus.getAppId()) || (restoreStatus.isHarmonyNext() && C14333b.m85485t().contains(restoreStatus.getAppId()));
    }

    /* renamed from: h */
    public static int m75574h(CloudRestoreItem cloudRestoreItem, CloudRestoreItem cloudRestoreItem2, boolean z10, boolean z11) {
        int iM75588v = m75588v(m75571e(cloudRestoreItem, z10, z11), m75571e(cloudRestoreItem2, z10, z11));
        return iM75588v == 0 ? m75586t(cloudRestoreItem.getAppName(), cloudRestoreItem2.getAppName()) : iM75588v;
    }

    /* renamed from: i */
    public static int m75575i(BackupOptionItem backupOptionItem, BackupOptionItem backupOptionItem2) {
        if (TextUtils.isEmpty(backupOptionItem.getAppId()) || TextUtils.isEmpty(backupOptionItem2.getAppId()) || "baseData".equals(backupOptionItem.getAppId()) || "baseData".equals(backupOptionItem2.getAppId())) {
            return 1;
        }
        int iM75589w = m75589w(backupOptionItem.getBackupSwitch(), backupOptionItem2.getBackupSwitch());
        if (iM75589w != 0) {
            return iM75589w;
        }
        int iM75585s = m75585s(backupOptionItem.isDataEnable() == -1, backupOptionItem2.isDataEnable() == -1);
        if (iM75585s != 0) {
            return iM75585s;
        }
        int iM75588v = m75588v(backupOptionItem.getDataBytes(), backupOptionItem2.getDataBytes());
        return iM75588v == 0 ? m75586t(backupOptionItem.getAppName(), backupOptionItem2.getAppName()) : iM75588v;
    }

    /* renamed from: j */
    public static int m75576j(AppDetailsInfo appDetailsInfo, AppDetailsInfo appDetailsInfo2) {
        return m75586t(appDetailsInfo.getProperties().get(SnapshotBackupMeta.KEY_STRING_APP_NAME), appDetailsInfo2.getProperties().get(SnapshotBackupMeta.KEY_STRING_APP_NAME));
    }

    /* renamed from: k */
    public static int m75577k(RestoreStatus restoreStatus, RestoreStatus restoreStatus2, List<String> list) {
        if (list.contains(restoreStatus.getAppId()) && list.contains(restoreStatus2.getAppId())) {
            return m75578l(restoreStatus, restoreStatus2);
        }
        if (list.contains(restoreStatus.getAppId())) {
            return -1;
        }
        if (list.contains(restoreStatus2.getAppId())) {
            return 1;
        }
        return m75578l(restoreStatus, restoreStatus2);
    }

    /* renamed from: l */
    public static int m75578l(RestoreStatus restoreStatus, RestoreStatus restoreStatus2) {
        int iM75587u = m75587u(restoreStatus.getAppId(), restoreStatus2.getAppId());
        return iM75587u == 0 ? m75588v(restoreStatus.getSize(), restoreStatus2.getSize()) : iM75587u;
    }

    /* renamed from: m */
    public static int m75579m(RestoreStatus restoreStatus, RestoreStatus restoreStatus2, List<String> list) {
        return TextUtils.equals(restoreStatus.getAppId(), restoreStatus2.getAppId()) ? m75592z(restoreStatus, restoreStatus2) : (m75573g(restoreStatus) || m75573g(restoreStatus2)) ? m75580n(restoreStatus, restoreStatus2) : (restoreStatus.isVirtual() || restoreStatus2.isVirtual()) ? m75582p(restoreStatus, restoreStatus2) : m75577k(restoreStatus, restoreStatus2, list);
    }

    /* renamed from: n */
    public static int m75580n(RestoreStatus restoreStatus, RestoreStatus restoreStatus2) {
        return (m75573g(restoreStatus) && m75573g(restoreStatus2)) ? Integer.compare(C14333b.m85446B().indexOf(restoreStatus.getAppId()), C14333b.m85446B().indexOf(restoreStatus2.getAppId())) : m75573g(restoreStatus) ? -1 : 1;
    }

    /* renamed from: o */
    public static int m75581o(RestoreStatus restoreStatus, RestoreStatus restoreStatus2) {
        return m75579m(restoreStatus, restoreStatus2, new ArrayList());
    }

    /* renamed from: p */
    public static int m75582p(RestoreStatus restoreStatus, RestoreStatus restoreStatus2) {
        return (restoreStatus.isVirtual() && restoreStatus2.isVirtual()) ? m75578l(restoreStatus, restoreStatus2) : restoreStatus.isVirtual() ? -1 : 1;
    }

    /* renamed from: q */
    public static int m75583q(int i10, int i11) {
        if (i10 < i11) {
            return 1;
        }
        return i10 > i11 ? -1 : 0;
    }

    /* renamed from: r */
    public static int m75584r(String str, String str2) {
        C11839m.m70686d("CloudBackupModuleUtil", "sortByBackupPriority appId1: " + str + ",appId2," + str2);
        int iIndexOf = C14333b.m85479n().indexOf(str);
        int iIndexOf2 = C14333b.m85479n().indexOf(str2);
        if (iIndexOf != -1 && iIndexOf2 != -1) {
            return Integer.compare(iIndexOf, iIndexOf2);
        }
        if (iIndexOf != -1) {
            return -1;
        }
        return iIndexOf2 != -1 ? 1 : 0;
    }

    /* renamed from: s */
    public static int m75585s(boolean z10, boolean z11) {
        if (!z10 || z11) {
            return (z10 || !z11) ? 0 : -1;
        }
        return 1;
    }

    /* renamed from: t */
    public static int m75586t(String str, String str2) {
        String strM75572f = m75572f(str);
        String strM75572f2 = m75572f(str2);
        if ("".equals(strM75572f) && "".equals(strM75572f2)) {
            return 0;
        }
        if ("".equals(strM75572f)) {
            return 1;
        }
        if ("".equals(strM75572f2)) {
            return -1;
        }
        return Collator.getInstance().compare(strM75572f, strM75572f2);
    }

    /* renamed from: u */
    public static int m75587u(String str, String str2) {
        int iIndexOf = C14333b.m85450F().indexOf(str);
        int iIndexOf2 = C14333b.m85450F().indexOf(str2);
        if (iIndexOf != -1 && iIndexOf2 != -1) {
            return Integer.compare(iIndexOf, iIndexOf2);
        }
        if (iIndexOf != -1) {
            return -1;
        }
        return iIndexOf2 != -1 ? 1 : 0;
    }

    /* renamed from: v */
    public static int m75588v(long j10, long j11) {
        long j12 = j10 - j11;
        if (j12 < 0) {
            return 1;
        }
        return j12 > 0 ? -1 : 0;
    }

    /* renamed from: w */
    public static int m75589w(boolean z10, boolean z11) {
        if (z10 && z11) {
            return 0;
        }
        if (z10 || z11) {
            return (!z10 || z11) ? 1 : -1;
        }
        return 0;
    }

    /* renamed from: x */
    public static int m75590x(String str, String str2) {
        int iIndexOf = C14333b.m85482q().indexOf(str);
        int iIndexOf2 = C14333b.m85482q().indexOf(str2);
        if (iIndexOf != -1 && iIndexOf2 != -1) {
            return Integer.compare(iIndexOf, iIndexOf2);
        }
        if (iIndexOf != -1) {
            return -1;
        }
        return iIndexOf2 != -1 ? 1 : 0;
    }

    /* renamed from: y */
    public static int m75591y(String str, String str2) {
        int iIndexOf = C14333b.m85453I().indexOf(str);
        int iIndexOf2 = C14333b.m85453I().indexOf(str2);
        if (iIndexOf != -1 && iIndexOf2 != -1) {
            return Integer.compare(iIndexOf, iIndexOf2);
        }
        if (iIndexOf != -1) {
            return -1;
        }
        return iIndexOf2 != -1 ? 1 : 0;
    }

    /* renamed from: z */
    public static int m75592z(RestoreStatus restoreStatus, RestoreStatus restoreStatus2) {
        if (restoreStatus.getUid() > restoreStatus2.getUid()) {
            return 1;
        }
        return restoreStatus.getUid() < restoreStatus2.getUid() ? -1 : 0;
    }
}
