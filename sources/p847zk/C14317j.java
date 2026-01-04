package p847zk;

import android.os.Handler;
import com.huawei.android.hicloud.cloudbackup.bean.CloudBackupState;
import com.huawei.hicloud.cloudbackup.p104v3.model.BackupItem;
import com.huawei.hicloud.request.cbs.bean.CBSbkFlowHead;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
import om.C11972l;
import om.C11975o;
import om.InterfaceC11973m;
import tl.C13029h;

/* renamed from: zk.j */
/* loaded from: classes6.dex */
public class C14317j {

    /* renamed from: d */
    public static final C14317j f63582d = new C14317j();

    /* renamed from: a */
    public final Map<String, InterfaceC11973m> f63583a;

    /* renamed from: b */
    public final ThreadLocal<String> f63584b;

    /* renamed from: c */
    public C11972l f63585c;

    public C14317j() {
        HashMap map = new HashMap();
        this.f63583a = map;
        this.f63584b = new ThreadLocal<>();
        C11972l c11972l = new C11972l();
        this.f63585c = c11972l;
        map.put("Refurbishment", c11972l);
        map.put("auto", this.f63585c);
        map.put(CBSbkFlowHead.BKMODE_MANUAL, this.f63585c);
        map.put("interim", new C11975o());
    }

    /* renamed from: d */
    public static C14317j m85300d() {
        C14317j c14317j = f63582d;
        c14317j.m85321v("auto");
        return c14317j;
    }

    /* renamed from: e */
    public static C14317j m85301e(String str) {
        C14317j c14317j = f63582d;
        c14317j.m85321v(str);
        return c14317j;
    }

    /* renamed from: a */
    public void m85302a(int i10, String str, boolean z10) {
        m85304c().mo72061l(i10, str, z10);
    }

    /* renamed from: b */
    public void m85303b(int i10) {
        m85304c().mo72062n(i10);
    }

    /* renamed from: c */
    public final InterfaceC11973m m85304c() {
        return this.f63583a.getOrDefault(this.f63584b.get(), this.f63585c);
    }

    /* renamed from: f */
    public CloudBackupState m85305f() {
        return m85304c().mo72075b();
    }

    /* renamed from: g */
    public long m85306g() {
        return m85304c().mo72050e();
    }

    /* renamed from: h */
    public void m85307h() {
        m85304c().init();
    }

    /* renamed from: i */
    public void m85308i(int i10) {
        m85304c().mo72058i(i10);
    }

    /* renamed from: j */
    public synchronized boolean m85309j() {
        return m85304c().mo72076c();
    }

    /* renamed from: k */
    public void m85310k(int i10, boolean z10) {
        m85304c().mo72044a(i10, z10);
    }

    /* renamed from: l */
    public void m85311l(Handler handler) {
        m85304c().mo72054g(handler);
    }

    /* renamed from: m */
    public void m85312m(C13029h c13029h) {
        m85313n(c13029h, null, false);
    }

    /* renamed from: n */
    public void m85313n(C13029h c13029h, Integer num, boolean z10) {
        m85304c().mo72056h(c13029h, num, z10);
    }

    /* renamed from: o */
    public void m85314o(BackupItem backupItem, BackupItem backupItem2, int i10, Supplier<Float> supplier) {
        m85304c().mo72063o(backupItem, backupItem2, i10, supplier);
    }

    /* renamed from: p */
    public void m85315p(float f10) {
        m85304c().mo72065q(f10);
    }

    /* renamed from: q */
    public void m85316q(boolean z10) {
        m85304c().mo72077k(z10);
    }

    /* renamed from: r */
    public void m85317r(long j10) {
        m85304c().mo72066r(j10);
    }

    /* renamed from: s */
    public void m85318s(int i10, String str) {
        m85304c().mo72060j(i10, str);
    }

    /* renamed from: t */
    public void m85319t() {
        m85320u(false, 0);
    }

    /* renamed from: u */
    public void m85320u(boolean z10, int i10) {
        m85304c().mo72064p(z10, i10);
    }

    /* renamed from: v */
    public final void m85321v(String str) {
        this.f63584b.set(str);
    }

    /* renamed from: w */
    public void m85322w(Handler handler) {
        m85304c().mo72048d(handler);
    }

    /* renamed from: x */
    public void m85323x() {
        m85304c().mo72052f();
    }

    /* renamed from: y */
    public void m85324y() {
        m85304c().mo72079m();
    }
}
