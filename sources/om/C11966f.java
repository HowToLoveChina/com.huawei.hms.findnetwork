package om;

import com.huawei.hicloud.cloudbackup.p104v3.model.BackupItem;
import com.huawei.hicloud.notification.constants.HNConstants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p514o9.C11839m;

/* renamed from: om.f */
/* loaded from: classes6.dex */
public class C11966f implements InterfaceC11974n {

    /* renamed from: a */
    public Map<String, Integer> f55705a = new HashMap();

    @Override // om.InterfaceC11974n
    /* renamed from: a */
    public float mo71989a(BackupItem backupItem) {
        String str;
        Integer num;
        int iM29861N = backupItem.m29861N();
        int iM29876j = backupItem.m29876j();
        int iM29869c = backupItem.m29869c();
        long jM29875i = backupItem.m29875i();
        long jM29868a = backupItem.m29868a();
        long jM29873g = backupItem.m29873g();
        String strM29870d = backupItem.m29870d();
        if (iM29861N == 0) {
            str = strM29870d;
        } else {
            str = strM29870d + iM29861N;
        }
        int iM71992d = 0;
        switch (backupItem.m29860M()) {
            case 0:
            case 1:
            case 2:
            case 3:
                this.f55705a.remove(str);
                break;
            case 4:
                int iMin = Math.min((HNConstants.DataType.MEDIA.equals(strM29870d) || "music".equals(strM29870d) || "doc".equals(strM29870d) || backupItem.m29865S()) ? m71992d(iM29869c, iM29876j) : m71992d(jM29868a, jM29875i), 99);
                if (this.f55705a.containsKey(str) && (num = this.f55705a.get(str)) != null && num.intValue() > iMin) {
                    C11839m.m70686d("BackupV2Progress", "module progress has changed: " + str + ", lastProgress: " + num + ", progress: " + iMin);
                    iMin = num.intValue();
                }
                iM71992d = iMin;
                this.f55705a.put(str, Integer.valueOf(iM71992d));
                break;
            case 5:
                boolean zM29862O = backupItem.m29862O();
                iM71992d = m71992d(jM29868a, jM29873g);
                if (zM29862O) {
                    iM71992d = (int) ((iM71992d * 0.5d) + (m71992d(iM29869c, iM29876j) * 0.5d));
                    break;
                }
                break;
            case 6:
            case 7:
                this.f55705a.remove(str);
                iM71992d = 100;
                break;
        }
        return iM71992d;
    }

    @Override // om.InterfaceC11974n
    /* renamed from: b */
    public int mo71990b(List<BackupItem> list) {
        Iterator<BackupItem> it = list.iterator();
        int iMo71990b = 0;
        while (it.hasNext()) {
            List<BackupItem> listM29824I0 = it.next().m29824I0();
            iMo71990b = (listM29824I0 == null || listM29824I0.isEmpty()) ? iMo71990b + 1 : iMo71990b + mo71990b(listM29824I0);
        }
        return iMo71990b;
    }

    @Override // om.InterfaceC11974n
    /* renamed from: c */
    public float mo71991c(List<BackupItem> list, int i10) {
        return (int) Math.floor(m71994f(list) / i10);
    }

    /* renamed from: d */
    public final int m71992d(long j10, long j11) {
        if (j11 <= 0 || j10 <= 0) {
            return 0;
        }
        return Math.min((int) Math.floor((j10 / j11) * 100.0d), 100);
    }

    /* renamed from: e */
    public float m71993e(BackupItem backupItem) {
        int iM29860M = backupItem.m29860M();
        int iMo71989a = 0;
        if (iM29860M != 0) {
            switch (iM29860M) {
                case 2:
                    iMo71989a = 10;
                    break;
                case 3:
                    iMo71989a = 15;
                    break;
                case 4:
                    iMo71989a = ((int) (mo71989a(backupItem) * 0.7d)) + 20;
                    break;
                case 5:
                    iMo71989a = ((int) (mo71989a(backupItem) * 0.1d)) + 90;
                    break;
                case 6:
                case 7:
                    iMo71989a = 100;
                    break;
            }
        }
        return iMo71989a;
    }

    /* renamed from: f */
    public float m71994f(List<BackupItem> list) {
        float f10;
        float fM71993e;
        int i10 = 0;
        for (BackupItem backupItem : list) {
            List<BackupItem> listM29824I0 = backupItem.m29824I0();
            if (listM29824I0 == null || listM29824I0.isEmpty()) {
                f10 = i10;
                fM71993e = m71993e(backupItem);
            } else {
                f10 = i10;
                fM71993e = m71994f(listM29824I0);
            }
            i10 = (int) (f10 + fM71993e);
        }
        return i10;
    }
}
