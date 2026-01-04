package md;

import android.content.Context;
import android.content.SharedPreferences;
import com.huawei.android.hicloud.task.frame.ICBTask;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.util.concurrent.atomic.AtomicInteger;
import p335hd.C10138a;
import p426kd.AbstractC11027a;
import p426kd.AbstractC11040n;
import p514o9.C11839m;
import p770xc.AbstractC13752o;

/* renamed from: md.a */
/* loaded from: classes3.dex */
public abstract class AbstractC11438a<Result> implements ICBTask {

    /* renamed from: j */
    public static final AtomicInteger f53281j = new AtomicInteger(0);

    /* renamed from: a */
    public Context f53282a;

    /* renamed from: b */
    public Exception f53283b;

    /* renamed from: c */
    public C11442e f53284c;

    /* renamed from: d */
    public C11443f f53285d;

    /* renamed from: e */
    public SharedPreferences f53286e;

    /* renamed from: f */
    public volatile boolean f53287f = false;

    /* renamed from: g */
    public volatile int f53288g = 2010;

    /* renamed from: h */
    public volatile a f53289h = a.READY;

    /* renamed from: i */
    public final int f53290i;

    /* renamed from: md.a$a */
    public enum a {
        READY,
        RUN,
        DONE
    }

    public AbstractC11438a() {
        int iIncrementAndGet = f53281j.incrementAndGet();
        this.f53290i = iIncrementAndGet < 0 ? iIncrementAndGet - Integer.MIN_VALUE : iIncrementAndGet;
    }

    /* renamed from: a */
    public abstract void mo66488a(Result result);

    @Override // com.huawei.android.hicloud.task.frame.ICBTask
    /* renamed from: b */
    public void mo18030b(C11442e c11442e) {
        this.f53284c = c11442e;
    }

    /* renamed from: c */
    public void mo66489c() {
    }

    /* renamed from: d */
    public abstract Result mo66490d() throws Exception;

    /* renamed from: e */
    public int m68508e() {
        return this.f53290i;
    }

    /* renamed from: f */
    public int m68509f() {
        C11442e c11442e = this.f53284c;
        if (c11442e != null) {
            return c11442e.m68550b();
        }
        return 0;
    }

    /* renamed from: g */
    public final int m68510g() {
        return this.f53288g;
    }

    /* renamed from: h */
    public void mo66491h() {
    }

    /* renamed from: i */
    public final boolean m68511i() {
        return this.f53287f;
    }

    @Override // java.lang.Runnable
    public void run() {
        StringBuilder sb2;
        this.f53289h = a.RUN;
        try {
            try {
            } catch (Exception e10) {
                this.f53283b = e10;
                C11839m.m70689w("CBTask", "A task has failed. e = " + e10.getMessage());
                C11839m.m70688i("CBTask", "this == " + this);
                if ((this instanceof AbstractC11027a) || (this instanceof AbstractC11040n) || (this instanceof AbstractC13752o)) {
                    C11440c.m68540s((C11439b) this);
                }
                try {
                    mo66488a(null);
                } catch (Exception e11) {
                    e = e11;
                    sb2 = new StringBuilder();
                    sb2.append("A task has failed. e = ");
                    sb2.append(e.getMessage());
                    C11839m.m70689w("AbstractCBTask", sb2.toString());
                    this.f53289h = a.DONE;
                }
            }
            if (m68511i()) {
                throw new C10138a();
            }
            mo66489c();
            if (m68511i()) {
                throw new C10138a();
            }
            Result resultMo66490d = mo66490d();
            C11839m.m70688i("CBTask", "this == " + this);
            if ((this instanceof AbstractC11027a) || (this instanceof AbstractC11040n) || (this instanceof AbstractC13752o)) {
                C11440c.m68540s((C11439b) this);
            }
            try {
                mo66488a(resultMo66490d);
            } catch (Exception e12) {
                e = e12;
                sb2 = new StringBuilder();
                sb2.append("A task has failed. e = ");
                sb2.append(e.getMessage());
                C11839m.m70689w("AbstractCBTask", sb2.toString());
                this.f53289h = a.DONE;
            }
            this.f53289h = a.DONE;
        } catch (Throwable th2) {
            C11839m.m70688i("CBTask", "this == " + this);
            if ((this instanceof AbstractC11027a) || (this instanceof AbstractC11040n) || (this instanceof AbstractC13752o)) {
                C11440c.m68540s((C11439b) this);
            }
            try {
                mo66488a(null);
            } catch (Exception e13) {
                C11839m.m70689w("AbstractCBTask", "A task has failed. e = " + e13.getMessage());
            }
            this.f53289h = a.DONE;
            throw th2;
        }
    }

    @Override // com.huawei.android.hicloud.task.frame.ICBTask
    public void setContext(Context context) {
        this.f53282a = context;
        mo66491h();
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getClass().getSimpleName());
        sb2.append('@');
        sb2.append(m68508e());
        sb2.append("[");
        sb2.append(this.f53289h);
        sb2.append(", ");
        sb2.append(this.f53287f ? "aborted" : Constants.NORMAL_CACHE);
        sb2.append("]");
        return sb2.toString();
    }

    @Override // com.huawei.android.hicloud.task.frame.ICBTask
    /* renamed from: w */
    public void mo18031w() {
        this.f53287f = false;
    }

    @Override // com.huawei.android.hicloud.task.frame.ICBTask
    /* renamed from: x */
    public void mo18032x(C11443f c11443f) {
        this.f53285d = c11443f;
    }
}
