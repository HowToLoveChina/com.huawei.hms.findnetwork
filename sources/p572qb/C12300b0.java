package p572qb;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import p015ak.C0213f;
import p020ap.C1010e;
import p335hd.AbstractC10143f;
import p514o9.C11839m;
import p616rk.AbstractRunnableC12516b;
import p616rk.C12515a;
import p684un.C13223b;
import p709vj.C13452e;

/* renamed from: qb.b0 */
/* loaded from: classes3.dex */
public class C12300b0 {

    /* renamed from: d */
    public static final C12300b0 f56991d = new C12300b0();

    /* renamed from: a */
    public final Object f56992a = new Object();

    /* renamed from: b */
    public boolean f56993b = false;

    /* renamed from: c */
    public Handler f56994c;

    /* renamed from: qb.b0$a */
    public class a extends AbstractC10143f {

        /* renamed from: a */
        public final /* synthetic */ int f56995a;

        public a(int i10) {
            this.f56995a = i10;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            if (TextUtils.isEmpty(C13452e.m80781L().m80905e())) {
                C11839m.m70687e("PhoneFinderOpenManager", "openPhoneFinder accountType null");
                C12300b0.m73940b().m73942d();
                return;
            }
            C11839m.m70688i("PhoneFinderOpenManager", "open phonefinder");
            C1010e.m6125b().m6151q(C0213f.m1377a(), this.f56995a);
            C1010e.m6125b().m6155u(C12300b0.this.f56994c);
            C13223b.m79473a(C0213f.m1377a(), "CLOUDBACKUP_OPEN_PHONEFINDER", C0213f.m1377a().getPackageName() + "|1");
            UBAAnalyze.m29957R("PVP", "CLOUDBACKUP_OPEN_PHONEFINDER", "1", "19", "value", C0213f.m1377a().getPackageName() + "|1");
        }
    }

    /* renamed from: qb.b0$b */
    public static class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 9001 || i10 == 9002) {
                C12300b0.m73940b().m73942d();
            }
        }
    }

    /* renamed from: b */
    public static C12300b0 m73940b() {
        return f56991d;
    }

    /* renamed from: c */
    public boolean m73941c() {
        boolean z10;
        synchronized (this.f56992a) {
            z10 = this.f56993b;
        }
        return z10;
    }

    /* renamed from: d */
    public void m73942d() {
        C11839m.m70688i("PhoneFinderOpenManager", "open finish");
        synchronized (this.f56992a) {
            this.f56993b = false;
            this.f56994c = null;
        }
    }

    /* renamed from: e */
    public void m73943e(int i10) {
        if (this.f56994c == null) {
            this.f56994c = new b(C0213f.m1377a().getMainLooper());
        }
        if (C1010e.m6125b().m6145k() && (i10 == 5 || i10 == 10 || i10 == 14)) {
            C11839m.m70688i("PhoneFinderOpenManager", "PhoneFinder is opening");
            return;
        }
        C1010e.m6125b().m6160z();
        a aVar = new a(i10);
        if (m73941c()) {
            C11839m.m70689w("PhoneFinderOpenManager", "isOpening");
        } else {
            m73944f(aVar);
        }
    }

    /* renamed from: f */
    public void m73944f(AbstractRunnableC12516b abstractRunnableC12516b) {
        C11839m.m70688i("PhoneFinderOpenManager", "openning");
        synchronized (this.f56992a) {
            this.f56993b = true;
            C11839m.m70688i("PhoneFinderOpenManager", "execute task");
            C12515a.m75110o().m75172d(abstractRunnableC12516b);
        }
    }
}
