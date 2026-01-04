package p506o1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Vibrator;
import com.huawei.uikit.hwadvancednumberpicker.utils.HwConstants;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import p629s1.C12662a;
import p629s1.C12665d;
import p644t1.C12918f;
import p665u1.InterfaceC13109a;

/* renamed from: o1.b */
/* loaded from: classes.dex */
public class C11787b extends C12662a {

    /* renamed from: j */
    @SuppressLint({"StaticFieldLeak"})
    public static C11787b f54596j;

    /* renamed from: c */
    public Context f54597c;

    /* renamed from: d */
    public Vibrator f54598d;

    /* renamed from: f */
    public C11786a f54600f;

    /* renamed from: g */
    public C12918f f54601g;

    /* renamed from: e */
    public int f54599e = -1;

    /* renamed from: h */
    public int f54602h = -1;

    /* renamed from: i */
    public ExecutorService f54603i = Executors.newSingleThreadExecutor();

    /* renamed from: o1.b$a */
    public class a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ String f54604a;

        /* renamed from: b */
        public final /* synthetic */ int f54605b;

        /* renamed from: c */
        public final /* synthetic */ int f54606c;

        /* renamed from: d */
        public final /* synthetic */ int f54607d;

        /* renamed from: e */
        public final /* synthetic */ int f54608e;

        public a(String str, int i10, int i11, int i12, int i13, InterfaceC13109a interfaceC13109a) {
            this.f54604a = str;
            this.f54605b = i10;
            this.f54606c = i11;
            this.f54607d = i12;
            this.f54608e = i13;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (32 > C11787b.this.f54602h || 2 != C11787b.this.f54599e) {
                    C11787b.this.f54600f.reset();
                    C11787b.this.f54600f.mo70250b(this.f54604a, this.f54607d, this.f54608e, this.f54605b, this.f54606c, null);
                    C11787b.this.f54600f.mo70249a();
                    C11787b.this.f54600f.start();
                } else {
                    C11787b.this.f54601g.m77561a(this.f54604a, this.f54605b, this.f54606c, this.f54607d, this.f54608e, null);
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    @SuppressLint({"PrivateApi"})
    public C11787b() {
    }

    /* renamed from: e */
    public static C11787b m70255e() {
        if (f54596j == null) {
            synchronized (C11787b.class) {
                try {
                    if (f54596j == null) {
                        f54596j = new C11787b();
                    }
                } finally {
                }
            }
        }
        return f54596j;
    }

    @Deprecated
    /* renamed from: f */
    public int m70256f() {
        return C11786a.m70247e(this.f54597c);
    }

    /* renamed from: g */
    public C11787b m70257g(Context context) {
        int i10;
        if (context == null) {
            throw new IllegalArgumentException("context shouldn't be null");
        }
        try {
            C11786a c11786a = this.f54600f;
            if (c11786a != null) {
                c11786a.release();
                this.f54600f = null;
            }
            C12918f c12918f = this.f54601g;
            if (c12918f != null) {
                c12918f.m77562b();
            }
            Context applicationContext = context.getApplicationContext();
            this.f54597c = applicationContext;
            if (applicationContext == null) {
                C12665d.a.m76245d("RichTapUtils", "fail to get application context!");
                this.f54597c = context;
            }
            this.f54598d = (Vibrator) this.f54597c.getSystemService("vibrator");
            this.f54602h = m70256f();
            i10 = 2;
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        if (C11786a.m70248f(2)) {
            int i11 = this.f54602h;
            if (32 <= i11) {
                this.f54601g = new C12918f(this.f54597c, i11);
            } else {
                this.f54600f = C11786a.m70246d(this.f54597c, 2);
            }
        } else {
            i10 = 1;
            if (!C11786a.m70248f(1)) {
                this.f54600f = C11786a.m70246d(this.f54597c, 0);
                this.f54599e = 0;
                C12665d.a.m76244c("RichTapUtils", "init , sdk version:" + C12662a.f58156b + " versionCode:" + C12662a.f58155a + ", RichTap Core Major Version:" + this.f54602h);
                return f54596j;
            }
            this.f54600f = C11786a.m70246d(this.f54597c, 1);
        }
        this.f54599e = i10;
        C12665d.a.m76244c("RichTapUtils", "init , sdk version:" + C12662a.f58156b + " versionCode:" + C12662a.f58155a + ", RichTap Core Major Version:" + this.f54602h);
        return f54596j;
    }

    /* renamed from: h */
    public boolean m70258h() {
        return C11786a.m70248f(2) || C11786a.m70248f(1);
    }

    /* renamed from: i */
    public void m70259i(String str, int i10) {
        m70260j(str, i10, HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA);
    }

    /* renamed from: j */
    public void m70260j(String str, int i10, int i11) {
        m70261k(str, i10, 0, i11, 0);
    }

    /* renamed from: k */
    public void m70261k(String str, int i10, int i11, int i12, int i13) {
        m70262l(str, i10, i11, i12, i13, null);
    }

    /* renamed from: l */
    public void m70262l(String str, int i10, int i11, int i12, int i13, InterfaceC13109a interfaceC13109a) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Wrong parameter {string: " + str + "} is null!");
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("playHaptic: loop:");
        sb2.append(i10);
        sb2.append(",interval:");
        sb2.append(i11);
        sb2.append(",amplitude:");
        sb2.append(i12);
        sb2.append(",freq:");
        sb2.append(i13);
        sb2.append(",callback is null:");
        sb2.append(interfaceC13109a == null);
        C12665d.a.m76242a("RichTapUtils", sb2.toString());
        this.f54603i.execute(new a(str, i10, i11, i12, i13, interfaceC13109a));
    }

    /* renamed from: m */
    public void m70263m() {
        try {
            C12665d.a.m76242a("RichTapUtils", "quit()");
            ExecutorService executorService = this.f54603i;
            if (executorService != null) {
                executorService.shutdown();
            }
            Vibrator vibrator = this.f54598d;
            if (vibrator != null) {
                vibrator.cancel();
            }
            C11786a c11786a = this.f54600f;
            if (c11786a != null) {
                c11786a.stop();
                this.f54600f.release();
            }
            C12918f c12918f = this.f54601g;
            if (c12918f != null) {
                c12918f.m77562b();
            }
            f54596j = null;
            this.f54597c = null;
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }
}
