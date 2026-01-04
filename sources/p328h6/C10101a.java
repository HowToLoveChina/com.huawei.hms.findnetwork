package p328h6;

import android.os.Process;
import com.huawei.android.backup.filelogic.utils.C2111d;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

/* renamed from: h6.a */
/* loaded from: classes.dex */
public class C10101a {

    /* renamed from: e */
    public static final Object f49291e = new Object();

    /* renamed from: a */
    public List<Object> f49292a;

    /* renamed from: b */
    public int f49293b;

    /* renamed from: c */
    public boolean f49294c;

    /* renamed from: d */
    public Timer f49295d;

    /* renamed from: h6.a$b */
    public static class b {

        /* renamed from: a */
        public static final C10101a f49296a = new C10101a();
    }

    /* renamed from: b */
    public static final C10101a m62912b() {
        return b.f49296a;
    }

    /* renamed from: a */
    public void m62913a(int i10, int i11) throws SecurityException, IllegalArgumentException {
        try {
            int threadPriority = Process.getThreadPriority(i10);
            int i12 = i11 + threadPriority;
            int i13 = this.f49293b;
            if (i12 < i13) {
                i12 = i13;
            }
            if (i12 > 15) {
                i12 = 15;
            }
            C2111d.m12646b("AdjustThreadPriority", "adjust tid is " + i10 + " :before curPriority is " + threadPriority + " :adjustPriority is " + i12 + " :maxThreadPriorityTCE is " + this.f49293b);
            if (i12 != threadPriority) {
                Process.setThreadPriority(i10, i12);
                C2111d.m12646b("AdjustThreadPriority", "warter mark adjust after curPriority is " + Process.getThreadPriority(i10));
            }
        } catch (IllegalArgumentException unused) {
            C2111d.m12648d("AdjustThreadPriority", "adjustThreadPriority IllegalArgumentException ");
        } catch (Exception unused2) {
            C2111d.m12648d("AdjustThreadPriority", "adjustThreadPriority Exception ");
        }
    }

    /* renamed from: c */
    public void m62914c(int i10, int i11) throws SecurityException, IllegalArgumentException {
        this.f49293b = ((100 - i11) / 5) - 5;
        m62913a(i10, 0);
    }

    public C10101a() {
        this.f49292a = new ArrayList(100);
        this.f49294c = true;
        this.f49295d = new Timer();
    }
}
