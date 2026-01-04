package p636s8;

import android.content.Context;
import android.os.Handler;
import com.huawei.android.hicloud.complexutil.CloudSyncUtil;
import hk.C10278a;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import p514o9.C11839m;
import p548p8.C12120a;
import p581qk.AbstractC12367d;
import p616rk.C12515a;

/* renamed from: s8.b */
/* loaded from: classes2.dex */
public class C12763b {

    /* renamed from: f */
    public static C12763b f58403f;

    /* renamed from: a */
    public Context f58404a;

    /* renamed from: b */
    public Handler f58405b;

    /* renamed from: c */
    public HashMap<String, FileObserverC12764c> f58406c = new HashMap<>();

    /* renamed from: d */
    public FileObserverC12764c f58407d = null;

    /* renamed from: e */
    public FileObserverC12764c f58408e = null;

    /* renamed from: s8.b$a */
    public class a extends AbstractC12367d {
        public a() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            if (C12763b.this.f58404a == null) {
                return;
            }
            C12763b.this.m76600j();
            if (C12763b.this.f58408e == null && C12763b.this.f58407d == null) {
                C11839m.m70688i("FileListenerMan", "Storage path is null");
                CloudSyncUtil.m16023k1(C12763b.this.f58404a, "autorecordingkey");
            } else {
                C11839m.m70688i("FileListenerMan", "registerFileObserver success");
                CloudSyncUtil.m16009g(C12763b.this.f58404a, "autorecordingkey");
            }
        }
    }

    /* renamed from: s8.b$b */
    public class b extends AbstractC12367d {
        public b() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            FileObserverC12764c fileObserverC12764c = (FileObserverC12764c) C12763b.this.f58406c.get("_inner");
            if (fileObserverC12764c != null) {
                fileObserverC12764c.stopWatching();
                C12763b.this.f58406c.remove("_inner");
            }
            FileObserverC12764c fileObserverC12764c2 = (FileObserverC12764c) C12763b.this.f58406c.get("_external");
            if (fileObserverC12764c2 != null) {
                fileObserverC12764c2.stopWatching();
                C12763b.this.f58406c.remove("_external");
            }
        }
    }

    /* renamed from: f */
    public static synchronized void m76595f() {
        if (f58403f == null) {
            f58403f = new C12763b();
        }
    }

    /* renamed from: g */
    public static C12763b m76596g() {
        if (f58403f == null) {
            m76595f();
        }
        return f58403f;
    }

    /* renamed from: h */
    public static String m76597h() {
        return "/Sounds";
    }

    /* renamed from: e */
    public void m76598e() {
        C11839m.m70688i("FileListenerMan", "createFileListener");
        C12515a.m75110o().m75172d(new a());
    }

    /* renamed from: i */
    public void m76599i(Context context, Handler handler) {
        if (context == null) {
            return;
        }
        this.f58404a = context;
        this.f58405b = handler;
    }

    /* renamed from: j */
    public void m76600j() {
        C11839m.m70688i("FileListenerMan", "registerFileObserver");
        Map<String, String> mapM72674f = new C12120a().m72674f(this.f58404a);
        String str = mapM72674f.get("in");
        String str2 = mapM72674f.get("out");
        C11839m.m70686d("FileListenerMan", "internalStoragePath= " + str + ", externalStoragePath= " + str2);
        FileObserverC12764c fileObserverC12764c = this.f58406c.get("_inner");
        this.f58407d = fileObserverC12764c;
        if (fileObserverC12764c == null && str != null) {
            String str3 = str + m76597h();
            File file = new File(str3);
            if (file.exists() && file.isDirectory()) {
                FileObserverC12764c fileObserverC12764c2 = new FileObserverC12764c(str3, this.f58405b, this.f58404a);
                this.f58407d = fileObserverC12764c2;
                this.f58406c.put("_inner", fileObserverC12764c2);
                this.f58407d.startWatching();
                C11839m.m70688i("FileListenerMan", "innerCardListener startWatching");
            }
        }
        FileObserverC12764c fileObserverC12764c3 = this.f58406c.get("_external");
        this.f58408e = fileObserverC12764c3;
        if (fileObserverC12764c3 != null || str2 == null) {
            return;
        }
        String str4 = str2 + m76597h();
        File fileM63442h = C10278a.m63442h(str4);
        if (fileM63442h.exists() && fileM63442h.isDirectory()) {
            FileObserverC12764c fileObserverC12764c4 = new FileObserverC12764c(str4, this.f58405b, this.f58404a);
            this.f58408e = fileObserverC12764c4;
            this.f58406c.put("_external", fileObserverC12764c4);
            this.f58408e.startWatching();
            C11839m.m70688i("FileListenerMan", "externalCardListener startWatching");
        }
    }

    /* renamed from: k */
    public void m76601k() {
        C11839m.m70688i("FileListenerMan", "stopFileListener");
        C12515a.m75110o().m75172d(new b());
    }
}
