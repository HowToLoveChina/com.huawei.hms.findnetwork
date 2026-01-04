package om;

import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import com.huawei.android.hicloud.cloudbackup.process.BackupPowerKitKeepTimer;
import com.huawei.android.hicloud.cloudbackup.process.CBAccess;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.hicloud.cloudbackup.p104v3.model.BackupItem;
import com.huawei.hicloud.cloudbackup.p104v3.model.BackupStatus;
import com.huawei.hicloud.cloudbackup.store.database.status.CloudBackupStatus;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.function.Supplier;
import p514o9.C11839m;
import p581qk.AbstractC12369f;
import p616rk.C12515a;
import p847zk.C14317j;
import tl.C13026e;

/* renamed from: om.e */
/* loaded from: classes6.dex */
public class C11965e {

    /* renamed from: h */
    public static final C11965e f55693h = new C11965e();

    /* renamed from: i */
    public static final Object f55694i = new Object();

    /* renamed from: a */
    public float f55695a;

    /* renamed from: b */
    public String f55696b;

    /* renamed from: c */
    public AbstractC12369f f55697c;

    /* renamed from: d */
    public volatile long f55698d;

    /* renamed from: e */
    public List<BackupStatus> f55699e = new ArrayList();

    /* renamed from: f */
    public int f55700f;

    /* renamed from: g */
    public InterfaceC11974n f55701g;

    /* renamed from: om.e$a */
    public class a extends AbstractC12369f {

        /* renamed from: a */
        public final /* synthetic */ String f55702a;

        /* renamed from: b */
        public final /* synthetic */ boolean f55703b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(long j10, long j11, String str, boolean z10) {
            super(j10, j11);
            this.f55702a = str;
            this.f55703b = z10;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            if (!CBAccess.inBackup()) {
                C11839m.m70689w("BackupProgressManager", "not in backup, release timer");
                cancel();
                return;
            }
            BackupPowerKitKeepTimer.getInstance().keepAlive(this.f55702a);
            if (this.f55703b) {
                CBAccess.keepLock();
            }
            if (System.currentTimeMillis() - C11965e.this.f55698d < 1000) {
                return;
            }
            C11965e.this.m71988q(null);
        }
    }

    /* renamed from: f */
    public static C11965e m71974f() {
        return f55693h;
    }

    /* renamed from: c */
    public final String m71975c() {
        BackupStatus backupStatus;
        return (this.f55699e.isEmpty() || (backupStatus = this.f55699e.get(0)) == null || TextUtils.isEmpty(backupStatus.m29870d())) ? "" : backupStatus.m29870d();
    }

    /* renamed from: d */
    public final int m71976d() {
        BackupStatus backupStatus;
        if (this.f55699e.isEmpty() || (backupStatus = this.f55699e.get(0)) == null) {
            return 0;
        }
        return backupStatus.m29861N();
    }

    /* renamed from: e */
    public String m71977e(float f10) {
        return this.f55701g instanceof C11966f ? C2783d.m16075C((int) f10) : C2783d.m16141g(f10);
    }

    /* renamed from: g */
    public float m71978g(BackupItem backupItem) {
        InterfaceC11974n interfaceC11974n = this.f55701g;
        if (interfaceC11974n != null) {
            return interfaceC11974n.mo71989a(backupItem);
        }
        return 0.0f;
    }

    /* renamed from: h */
    public int m71979h() {
        return (int) this.f55695a;
    }

    /* renamed from: i */
    public SpannableString m71980i(float f10, int i10) {
        String strM16141g;
        int i11 = 1;
        if (this.f55701g instanceof C11966f) {
            strM16141g = C2783d.m16144h((int) f10);
        } else {
            strM16141g = C2783d.m16141g(f10);
            i11 = 1 + ((C2783d.m16113V(f10, 100.0f) || C2783d.m16113V(f10, 0.0f)) ? 0 : 2);
        }
        SpannableString spannableString = new SpannableString(strM16141g);
        spannableString.setSpan(new AbsoluteSizeSpan(i10, false), spannableString.length() - i11, spannableString.length(), 33);
        return spannableString;
    }

    /* renamed from: j */
    public void m71981j(boolean z10, String str, Deque<CloudBackupStatus> deque, String str2, C13026e c13026e) {
        this.f55696b = str2;
        if (z10) {
            this.f55701g = new C11969i(str2, deque, c13026e);
        } else {
            this.f55701g = new C11966f();
        }
        this.f55698d = 0L;
        this.f55700f = 0;
        this.f55697c = new a(0L, 2L, str, z10);
        C12515a.m75110o().m75172d(this.f55697c);
    }

    /* renamed from: k */
    public void m71982k(List<BackupItem> list) {
        InterfaceC11974n interfaceC11974n = this.f55701g;
        if (interfaceC11974n != null) {
            this.f55700f = interfaceC11974n.mo71990b(list);
        }
    }

    /* renamed from: l */
    public void m71983l(List<BackupItem> list) {
        InterfaceC11974n interfaceC11974n = this.f55701g;
        if (interfaceC11974n != null) {
            this.f55695a = interfaceC11974n.mo71991c(list, this.f55700f);
        }
    }

    /* renamed from: m */
    public final /* synthetic */ Float m71984m(List list) {
        m71982k(list);
        m71983l(list);
        return Float.valueOf(this.f55695a);
    }

    /* renamed from: n */
    public void m71985n(String str, int i10) {
        synchronized (f55694i) {
            try {
                BackupStatus backupStatus = new BackupStatus();
                backupStatus.mo29313Y(str);
                backupStatus.mo29340B0(i10);
                if (this.f55699e.contains(backupStatus)) {
                    this.f55699e.remove(backupStatus);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: o */
    public void m71986o(String str, int i10) {
        synchronized (f55694i) {
            try {
                BackupStatus backupStatus = new BackupStatus();
                backupStatus.mo29313Y(str);
                backupStatus.mo29340B0(i10);
                if (this.f55699e.contains(backupStatus)) {
                    return;
                }
                this.f55699e.add(backupStatus);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: p */
    public void m71987p() {
        AbstractC12369f abstractC12369f = this.f55697c;
        if (abstractC12369f != null) {
            abstractC12369f.cancel();
            this.f55697c = null;
        }
        this.f55699e.clear();
        this.f55698d = 0L;
        this.f55700f = 0;
    }

    /* renamed from: q */
    public void m71988q(BackupItem backupItem) {
        synchronized (f55694i) {
            try {
                if (TextUtils.isEmpty(this.f55696b)) {
                    C11839m.m70688i("BackupProgressManager", "sendProgress backupAction is empty");
                    return;
                }
                C11961a c11961aM71960o = C11963c.m71960o(this.f55696b);
                final List<BackupItem> listM71940a = c11961aM71960o.m71940a();
                if (listM71940a.isEmpty()) {
                    C11839m.m70689w("BackupProgressManager", "sendProgress itemList is empty");
                    return;
                }
                this.f55698d = System.currentTimeMillis();
                m71982k(listM71940a);
                m71983l(listM71940a);
                String strM71975c = m71975c();
                BackupItem backupItemM71958m = C11963c.m71958m(strM71975c, m71976d(), listM71940a);
                C11839m.m70686d("BackupProgressManager", "sendProgress :" + strM71975c + " ,progress" + this.f55695a + " ,count " + this.f55700f);
                C14317j.m85301e(this.f55696b).m85314o(backupItemM71958m, backupItem, c11961aM71960o.m71941b(), new Supplier() { // from class: om.d
                    @Override // java.util.function.Supplier
                    public final Object get() {
                        return this.f55691a.m71984m(listM71940a);
                    }
                });
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
