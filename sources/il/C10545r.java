package il;

import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.process.task.C2575c0;
import com.huawei.android.hicloud.cloudbackup.process.util.C2629f;
import com.huawei.android.hicloud.cloudbackup.report.CloudBackupReport;
import com.huawei.hicloud.cloudbackup.store.database.tags.BackupOptionItem;
import fk.C9721b;
import il.C10545r;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import p459lp.InterfaceC11331i;
import p514o9.C11839m;
import p572qb.C12299b;
import p581qk.AbstractC12367d;
import p616rk.C12515a;
import p815ym.AbstractC14026a;
import pm.C12176c;
import tl.C13026e;

/* renamed from: il.r */
/* loaded from: classes6.dex */
public class C10545r implements InterfaceC11331i {

    /* renamed from: il.r$a */
    public class a extends AbstractC12367d {
        public a() {
        }

        /* renamed from: e */
        public static /* synthetic */ boolean m64703e(BackupOptionItem backupOptionItem) {
            return !TextUtils.equals(backupOptionItem.getParent(), "thirdApp");
        }

        public static /* synthetic */ boolean lambda$call$0(List list, BackupOptionItem backupOptionItem) {
            return !list.contains(backupOptionItem.getAppId());
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            C11839m.m70688i("ConfigBackupProxy", "closeMemberBackupModule start");
            final List<String> listM73271n = C12176c.m73271n(null);
            C13026e c13026e = new C13026e();
            List<BackupOptionItem> listM78397u = c13026e.m78397u();
            if (AbstractC14026a.m84159a(listM78397u)) {
                C11839m.m70688i("ConfigBackupProxy", "backupItems is empty");
                return;
            }
            List<String> list = (List) listM78397u.stream().filter(new Predicate() { // from class: il.p
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return C10545r.a.lambda$call$0(listM73271n, (BackupOptionItem) obj);
                }
            }).filter(new Predicate() { // from class: il.q
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return C10545r.a.m64703e((BackupOptionItem) obj);
                }
            }).filter(new C2629f()).map(new C2575c0()).collect(Collectors.toList());
            c13026e.m78384e(list);
            CloudBackupReport.reportCloseAllFullModule(list);
            C11839m.m70688i("ConfigBackupProxy", "closeMemberBackupModule end");
        }
    }

    @Override // p459lp.InterfaceC11331i
    /* renamed from: a */
    public void mo64699a(String str, boolean z10) {
        C12299b.m73928j(str, Boolean.valueOf(z10));
    }

    @Override // p459lp.InterfaceC11331i
    /* renamed from: b */
    public void mo64700b() {
        C12515a.m75110o().m75172d(new a());
    }
}
