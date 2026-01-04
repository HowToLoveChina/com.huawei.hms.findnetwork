package mg;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import java.util.Timer;
import java.util.TimerTask;
import ng.C11702i;
import ng.C11703j;
import p655te.C13009a;
import p709vj.C13452e;
import p809yg.C13981a;
import sg.C12797b;

/* renamed from: mg.b */
/* loaded from: classes4.dex */
public class C11466b implements InterfaceC11467c {

    /* renamed from: a */
    public C11465a f53347a;

    /* renamed from: b */
    public C11465a f53348b;

    /* renamed from: c */
    public C11465a f53349c;

    /* renamed from: d */
    public Context f53350d;

    /* renamed from: e */
    public Handler f53351e;

    /* renamed from: f */
    public Timer f53352f;

    /* renamed from: g */
    public boolean f53353g;

    /* renamed from: h */
    public boolean f53354h;

    /* renamed from: mg.b$a */
    public class a extends TimerTask {

        /* renamed from: a */
        public final /* synthetic */ String f53355a;

        public a(String str) {
            this.f53355a = str;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            C13981a.m83990w("LoadProcessRecorder", "load url network is slow, url is: " + C11703j.m69807c(this.f53355a));
            C11466b.this.f53351e.obtainMessage(1003, Boolean.TRUE).sendToTarget();
        }
    }

    /* renamed from: mg.b$b */
    public class b extends TimerTask {

        /* renamed from: a */
        public final /* synthetic */ String f53357a;

        public b(String str) {
            this.f53357a = str;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            C13981a.m83990w("LoadProcessRecorder", "load url timeout, url is: " + C11703j.m69807c(this.f53357a));
            C11466b.this.f53351e.obtainMessage(1001, Boolean.TRUE).sendToTarget();
            C11466b.this.m68589m("001_3002", "load wapPage timeout");
            C11466b.this.m68587k();
        }
    }

    /* renamed from: mg.b$c */
    public enum c {
        LOAD_START,
        LOAD_FINISH
    }

    public C11466b(C11465a c11465a, Context context, Handler handler) {
        this.f53347a = c11465a;
        this.f53350d = context;
        this.f53351e = handler;
    }

    @Override // mg.InterfaceC11467c
    /* renamed from: a */
    public void mo68580a(C11465a c11465a) {
        if (c11465a == null) {
            C13981a.m83988e("LoadProcessRecorder", "LoadProcessData in error is null");
            return;
        }
        this.f53351e.obtainMessage(1001).sendToTarget();
        this.f53349c = c11465a;
        m68587k();
        m68589m("001_" + c11465a.m68570a(), "load url error,url is: " + this.f53349c.m68572c());
    }

    @Override // mg.InterfaceC11467c
    /* renamed from: b */
    public void mo68581b(C11465a c11465a) {
        if (c11465a == null || this.f53347a == null) {
            C13981a.m83988e("LoadProcessRecorder", "LoadProcessData in start is null");
            return;
        }
        String strM68572c = c11465a.m68572c();
        if (TextUtils.isEmpty(strM68572c)) {
            return;
        }
        if (C11702i.m69797m(strM68572c)) {
            this.f53347a.m68575f(c11465a.m68571b());
            this.f53347a.m68576g(c11465a.m68572c());
            C13981a.m83989i("LoadProcessRecorder", "login startData update");
            m68586j(c11465a.m68572c());
            this.f53354h = false;
        }
        if (m68584h(strM68572c)) {
            m68587k();
            Handler handler = this.f53351e;
            if (handler != null) {
                handler.obtainMessage(1006, Boolean.TRUE).sendToTarget();
            }
        }
    }

    @Override // mg.InterfaceC11467c
    /* renamed from: c */
    public void mo68582c(C11465a c11465a) {
        if (c11465a == null || this.f53347a == null) {
            C13981a.m83988e("LoadProcessRecorder", "LoadProcessData in finish is null");
            return;
        }
        String strM68572c = c11465a.m68572c();
        if (strM68572c == null) {
            return;
        }
        if (m68585i(C11702i.m69797m(strM68572c), strM68572c)) {
            C13981a.m83989i("LoadProcessRecorder", "login endData update");
            this.f53348b = new C11465a(c.LOAD_FINISH, strM68572c, c11465a.m68573d(), null, c11465a.m68571b());
            m68587k();
        } else if (m68584h(strM68572c)) {
            C13981a.m83989i("LoadProcessRecorder", "login endData update");
            this.f53348b = new C11465a(c.LOAD_FINISH, strM68572c, c11465a.m68573d(), null, c11465a.m68571b());
            m68587k();
            Handler handler = this.f53351e;
            if (handler != null) {
                handler.obtainMessage(1006, Boolean.TRUE).sendToTarget();
            }
        }
    }

    /* renamed from: g */
    public void m68583g() {
        m68587k();
        this.f53347a = null;
        this.f53348b = null;
        this.f53349c = null;
    }

    /* renamed from: h */
    public final boolean m68584h(String str) {
        String strM69811g = C11703j.m69811g(str);
        return "/CAS/mobile/standard/login.html".equals(strM69811g) || "/CAS/mobile/standard/wapLogin.html".equals(strM69811g) || "/CAS/portal/crossSiteID/crossSiteID.html".equals(strM69811g);
    }

    /* renamed from: i */
    public final boolean m68585i(boolean z10, String str) {
        if (z10) {
            return str.endsWith("#/home") || str.endsWith("#/eu");
        }
        return false;
    }

    /* renamed from: j */
    public final synchronized void m68586j(String str) {
        if (this.f53353g) {
            C13981a.m83989i("LoadProcessRecorder", "hasRegisterHook");
            return;
        }
        this.f53353g = true;
        C13981a.m83989i("LoadProcessRecorder", "registerTimeOutHook");
        if (this.f53352f == null) {
            this.f53352f = new Timer();
        }
        try {
            this.f53352f.schedule(new a(str), 5000L);
            this.f53352f.schedule(new b(str), 60000L);
        } catch (Exception unused) {
            C13981a.m83988e("LoadProcessRecorder", "registerTimeOutHook error");
        }
    }

    /* renamed from: k */
    public final synchronized void m68587k() {
        try {
            this.f53353g = false;
            Handler handler = this.f53351e;
            if (handler != null) {
                handler.obtainMessage(1002, Boolean.TRUE).sendToTarget();
            }
            if (this.f53352f != null) {
                C13981a.m83989i("LoadProcessRecorder", "releaseScheduleTask");
                this.f53352f.cancel();
                this.f53352f.purge();
                this.f53352f = null;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: l */
    public void m68588l(String str) {
        C11465a c11465a;
        if (this.f53354h || (c11465a = this.f53348b) == null || this.f53347a == null) {
            return;
        }
        C12797b.m76777l(this.f53350d, "load_wap_page", null, "01017", 1, "0", "login to wap cost: " + (c11465a.m68571b() - this.f53347a.m68571b()) + "ms", str, C13009a.m78313h(this.f53347a.m68573d()));
        this.f53354h = true;
    }

    /* renamed from: m */
    public final void m68589m(String str, String str2) {
        C11465a c11465a = this.f53347a;
        if (c11465a == null) {
            C13981a.m83990w("LoadProcessRecorder", "reportLoadError startData is null");
        } else {
            C12797b.m76777l(this.f53350d, "load_wap_page", null, "01017", 1, str, str2, C13452e.m80781L().m80971t0(), C13009a.m78313h(c11465a.m68573d()));
        }
    }
}
