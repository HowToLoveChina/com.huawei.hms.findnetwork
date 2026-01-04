package p572qb;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.huawei.android.hicloud.manager.IPowerKitListener;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import p514o9.C11839m;
import p608rb.C12485a;

/* renamed from: qb.d */
/* loaded from: classes3.dex */
public class C12303d implements IPowerKitListener {

    /* renamed from: f */
    public static Map<String, Integer> f56999f = new HashMap();

    /* renamed from: g */
    public static int f57000g = 10;

    /* renamed from: h */
    public static Map<String, C12485a> f57001h = new HashMap();

    /* renamed from: a */
    public C12315j f57002a;

    /* renamed from: b */
    public AtomicBoolean f57003b;

    /* renamed from: c */
    public long f57004c;

    /* renamed from: d */
    public c f57005d;

    /* renamed from: e */
    public HandlerThread f57006e;

    /* renamed from: qb.d$b */
    public static class b {

        /* renamed from: a */
        public static C12303d f57007a = new C12303d();
    }

    /* renamed from: qb.d$c */
    public static class c extends Handler {
        public c(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            C11839m.m70686d("CloudSyncPowerKitManager", " time out applyType " + message.what + "- " + message.obj);
            Object obj = message.obj;
            if (obj instanceof String) {
                String str = (String) obj;
                C12303d.m73958f().m73962h(str);
                if (C12303d.f57001h.containsKey(str)) {
                    C12303d.m73958f().m73959d(str, (C12485a) C12303d.f57001h.get(str));
                }
            }
        }
    }

    public /* synthetic */ C12303d(a aVar) {
        this();
    }

    /* renamed from: f */
    public static C12303d m73958f() {
        return b.f57007a;
    }

    @Override // com.huawei.android.hicloud.manager.IPowerKitListener
    /* renamed from: a */
    public void mo16419a() {
        C11839m.m70688i("CloudSyncPowerKitManager", "onPowerKitConnected");
        this.f57003b.set(true);
        m73960e();
    }

    @Override // com.huawei.android.hicloud.manager.IPowerKitListener
    /* renamed from: b */
    public void mo16420b() {
        C11839m.m70688i("CloudSyncPowerKitManager", "onPowerKitDisconnected ");
        this.f57003b.set(false);
    }

    /* renamed from: d */
    public void m73959d(String str, C12485a c12485a) {
        C11839m.m70686d("CloudSyncPowerKitManager", "applyPowerKit powKit applyType " + str);
        if (TextUtils.isEmpty(str)) {
            C11839m.m70689w("CloudSyncPowerKitManager", "applyType is null ");
            return;
        }
        if (f57001h.containsKey(str)) {
            f57001h.put(str, c12485a);
            return;
        }
        f57001h.put(str, c12485a);
        if (!this.f57003b.get()) {
            this.f57002a.m74063g();
            return;
        }
        boolean zM74060c = this.f57002a.m74060c("com.huawei.hidisk", 1800000L, str);
        C11839m.m70688i("CloudSyncPowerKitManager", "apply powKit applyResult " + zM74060c);
        if (zM74060c) {
            this.f57004c = System.currentTimeMillis();
            if (this.f57005d == null || this.f57006e == null) {
                HandlerThread handlerThread = new HandlerThread("CloudSyncPowerKit");
                this.f57006e = handlerThread;
                handlerThread.start();
                this.f57005d = new c(this.f57006e.getLooper());
            }
            int i10 = f57000g + 1;
            f57000g = i10;
            f56999f.put(str, Integer.valueOf(i10));
            Message messageObtain = Message.obtain();
            messageObtain.what = i10;
            messageObtain.obj = str;
            this.f57005d.sendMessageDelayed(messageObtain, 1680000L);
        }
    }

    /* renamed from: e */
    public final void m73960e() {
        if (!f57001h.isEmpty() && this.f57003b.get()) {
            for (Map.Entry<String, C12485a> entry : f57001h.entrySet()) {
                m73959d(entry.getKey(), entry.getValue());
            }
        }
    }

    /* renamed from: g */
    public boolean m73961g(String str) {
        return System.currentTimeMillis() - this.f57004c > 1680000;
    }

    /* renamed from: h */
    public void m73962h(String str) {
        C11839m.m70686d("CloudSyncPowerKitManager", "unApplyPowerKit powKit applyType " + str);
        if (TextUtils.isEmpty(str)) {
            C11839m.m70689w("CloudSyncPowerKitManager", "applyType is null ");
            return;
        }
        if (this.f57003b.get()) {
            C11839m.m70688i("CloudSyncPowerKitManager", "unApply powKit applyResult " + this.f57002a.m74071o("com.huawei.hidisk", str));
        }
        c cVar = this.f57005d;
        if (cVar != null) {
            cVar.removeMessages(f56999f.getOrDefault(str, 0).intValue());
        }
        f57001h.remove(str);
        f56999f.remove(str);
        if (f57001h.isEmpty()) {
            f57000g = 10;
            c cVar2 = this.f57005d;
            if (cVar2 != null) {
                cVar2.removeMessages(0);
                this.f57005d = null;
            }
            HandlerThread handlerThread = this.f57006e;
            if (handlerThread != null) {
                handlerThread.quitSafely();
                this.f57006e = null;
            }
        }
    }

    @Override // com.huawei.android.hicloud.manager.IPowerKitListener
    public void onPowerBaseLineUsing(String str, String str2, long j10, int i10, String str3) {
    }

    @Override // com.huawei.android.hicloud.manager.IPowerKitListener
    public void onPowerOverUsing(String str, int i10, long j10, long j11, String str2) {
    }

    @Override // com.huawei.android.hicloud.manager.IPowerKitListener
    public void onStateChanged(int i10, int i11, int i12, String str, int i13) {
    }

    public C12303d() {
        this.f57003b = new AtomicBoolean(false);
        this.f57004c = System.currentTimeMillis();
        this.f57005d = null;
        this.f57006e = null;
        C12315j c12315jM74059f = C12315j.m74059f();
        this.f57002a = c12315jM74059f;
        c12315jM74059f.m74069m(this);
        this.f57003b.set(this.f57002a.m74066j());
    }
}
