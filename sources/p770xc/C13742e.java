package p770xc;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.huawei.android.hicloud.sync.protocol.SyncProtocol;
import com.huawei.android.hicloud.syncdrive.cloudsync.model.Lock;
import com.huawei.android.hicloud.syncdrive.cloudsync.request.Locks;
import com.huawei.android.hicloud.syncdrive.util.DriveSyncUtil;
import java.io.IOException;
import java.util.LinkedHashMap;
import je.C10812z;
import p255ed.C9453i;
import p514o9.C11839m;
import tc.C13007b;

/* renamed from: xc.e */
/* loaded from: classes3.dex */
public class C13742e {

    /* renamed from: a */
    public Context f61770a;

    /* renamed from: b */
    public String f61771b;

    /* renamed from: c */
    public C9453i f61772c;

    /* renamed from: d */
    public SyncProtocol f61773d;

    /* renamed from: e */
    public String f61774e;

    /* renamed from: f */
    public String f61775f;

    /* renamed from: g */
    public int f61776g;

    /* renamed from: h */
    public String f61777h;

    /* renamed from: i */
    public boolean f61778i;

    /* renamed from: j */
    public Handler f61779j;

    /* renamed from: k */
    public HandlerThread f61780k;

    /* renamed from: xc.e$a */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        /* renamed from: a */
        public final long m82593a(int i10) throws Throwable {
            if (i10 == 41094041) {
                C11839m.m70688i("KeepLockTask", "keepLockV2 lock is not found");
                return 0L;
            }
            if (!C13742e.this.f61778i) {
                String str = C13742e.this.f61775f;
                C13742e c13742e = C13742e.this;
                return DriveSyncUtil.m18009s(str, c13742e.f61777h, c13742e.f61771b, C13742e.this.f61774e);
            }
            C11839m.m70688i("KeepLockTask", "keepLockV2 retry");
            C13742e.this.f61778i = false;
            m82594b();
            return 0L;
        }

        /* renamed from: b */
        public final void m82594b() throws Throwable {
            int i10;
            String message;
            LinkedHashMap linkedHashMap;
            Context context;
            String str;
            String str2;
            boolean z10;
            String str3;
            String str4;
            C11839m.m70688i("KeepLockTask", "keepLockV2");
            String str5 = "";
            try {
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                try {
                    if (!TextUtils.isEmpty(C13742e.this.f61775f)) {
                        try {
                            DriveSyncUtil.m17991e0(C13742e.this.f61770a, C13742e.this.f61775f, C13742e.this.f61771b, C13742e.this.f61774e);
                            String strM17959D = DriveSyncUtil.m17959D(C13742e.this.f61775f);
                            if (TextUtils.isEmpty(C13742e.this.f61777h)) {
                                C13742e c13742e = C13742e.this;
                                c13742e.f61777h = C13007b.m78205Y(c13742e.f61770a).m78224J(C13742e.this.f61775f, C13742e.this.f61771b);
                            }
                            C13742e c13742e2 = C13742e.this;
                            str5 = c13742e2.f61777h;
                            Locks.Get getAddHeader = c13742e2.f61772c.m59246e().get(strM17959D).addHeader("x-hw-lock", (Object) C13742e.this.f61777h);
                            DriveSyncUtil.m17994g(getAddHeader.getHeaders(), C13742e.this.f61774e, C13742e.this.f61775f, C13742e.this.f61771b);
                            Lock lockExecute = getAddHeader.setFields2("sessionId,lockInterval").execute();
                            C11839m.m70686d("KeepLockTask", "lock run: " + lockExecute.toString());
                            C13742e.this.f61776g = lockExecute.getLockInterval().intValue();
                            C13742e.this.f61777h = lockExecute.getSessionId();
                            C11839m.m70688i("KeepLockTask", "keepLock response: interval = " + C13742e.this.f61776g);
                            C13742e.this.m82591m();
                        } catch (Throwable th3) {
                            th = th3;
                            message = "";
                            i10 = 0;
                            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                            linkedHashMap2.put("locksInterval", String.valueOf(C13742e.this.f61776g));
                            linkedHashMap2.put("originLockToken", str5);
                            linkedHashMap2.put("lockToken", C13742e.this.f61777h);
                            linkedHashMap2.put("timestamp", String.valueOf(0L));
                            C10812z.m65846o(C13742e.this.f61770a, C13742e.this.f61775f, i10, message, "03001", "locks_keep", C13742e.this.f61774e, linkedHashMap2, false);
                            throw th;
                        }
                    }
                    LinkedHashMap linkedHashMap3 = new LinkedHashMap();
                    linkedHashMap3.put("locksInterval", String.valueOf(C13742e.this.f61776g));
                    linkedHashMap3.put("originLockToken", str5);
                    linkedHashMap3.put("lockToken", C13742e.this.f61777h);
                    linkedHashMap3.put("timestamp", String.valueOf(0L));
                    C10812z.m65846o(C13742e.this.f61770a, C13742e.this.f61775f, 0, "", "03001", "locks_keep", C13742e.this.f61774e, linkedHashMap3, false);
                } catch (IOException e10) {
                    C11839m.m70687e("KeepLockTask", "keepLockV2 exception: " + e10.toString());
                    int iM17961F = DriveSyncUtil.m17961F(e10);
                    try {
                        message = e10.getMessage();
                    } catch (Throwable th4) {
                        th = th4;
                        i10 = iM17961F;
                        message = "";
                        LinkedHashMap linkedHashMap22 = new LinkedHashMap();
                        linkedHashMap22.put("locksInterval", String.valueOf(C13742e.this.f61776g));
                        linkedHashMap22.put("originLockToken", str5);
                        linkedHashMap22.put("lockToken", C13742e.this.f61777h);
                        linkedHashMap22.put("timestamp", String.valueOf(0L));
                        C10812z.m65846o(C13742e.this.f61770a, C13742e.this.f61775f, i10, message, "03001", "locks_keep", C13742e.this.f61774e, linkedHashMap22, false);
                        throw th;
                    }
                    try {
                        long jM82593a = m82593a(iM17961F);
                        linkedHashMap = new LinkedHashMap();
                        linkedHashMap.put("locksInterval", String.valueOf(C13742e.this.f61776g));
                        linkedHashMap.put("originLockToken", str5);
                        linkedHashMap.put("lockToken", C13742e.this.f61777h);
                        linkedHashMap.put("timestamp", String.valueOf(jM82593a));
                        context = C13742e.this.f61770a;
                        str = C13742e.this.f61775f;
                        str2 = C13742e.this.f61774e;
                        z10 = false;
                        str3 = "03001";
                        str4 = "locks_keep";
                        i10 = iM17961F;
                        C10812z.m65846o(context, str, i10, message, str3, str4, str2, linkedHashMap, z10);
                    } catch (Throwable th5) {
                        th = th5;
                        i10 = iM17961F;
                        LinkedHashMap linkedHashMap222 = new LinkedHashMap();
                        linkedHashMap222.put("locksInterval", String.valueOf(C13742e.this.f61776g));
                        linkedHashMap222.put("originLockToken", str5);
                        linkedHashMap222.put("lockToken", C13742e.this.f61777h);
                        linkedHashMap222.put("timestamp", String.valueOf(0L));
                        C10812z.m65846o(C13742e.this.f61770a, C13742e.this.f61775f, i10, message, "03001", "locks_keep", C13742e.this.f61774e, linkedHashMap222, false);
                        throw th;
                    }
                } catch (Exception e11) {
                    C11839m.m70687e("KeepLockTask", "keepLockV2 exception: " + e11.toString());
                    i10 = 5;
                    try {
                        message = e11.getMessage();
                    } catch (Throwable th6) {
                        th = th6;
                        message = "";
                        LinkedHashMap linkedHashMap2222 = new LinkedHashMap();
                        linkedHashMap2222.put("locksInterval", String.valueOf(C13742e.this.f61776g));
                        linkedHashMap2222.put("originLockToken", str5);
                        linkedHashMap2222.put("lockToken", C13742e.this.f61777h);
                        linkedHashMap2222.put("timestamp", String.valueOf(0L));
                        C10812z.m65846o(C13742e.this.f61770a, C13742e.this.f61775f, i10, message, "03001", "locks_keep", C13742e.this.f61774e, linkedHashMap2222, false);
                        throw th;
                    }
                    try {
                        String str6 = C13742e.this.f61775f;
                        C13742e c13742e3 = C13742e.this;
                        long jM18009s = DriveSyncUtil.m18009s(str6, c13742e3.f61777h, c13742e3.f61771b, C13742e.this.f61774e);
                        linkedHashMap = new LinkedHashMap();
                        linkedHashMap.put("locksInterval", String.valueOf(C13742e.this.f61776g));
                        linkedHashMap.put("originLockToken", str5);
                        linkedHashMap.put("lockToken", C13742e.this.f61777h);
                        linkedHashMap.put("timestamp", String.valueOf(jM18009s));
                        context = C13742e.this.f61770a;
                        str = C13742e.this.f61775f;
                        str2 = C13742e.this.f61774e;
                        z10 = false;
                        str3 = "03001";
                        str4 = "locks_keep";
                        C10812z.m65846o(context, str, i10, message, str3, str4, str2, linkedHashMap, z10);
                    } catch (Throwable th7) {
                        th = th7;
                        LinkedHashMap linkedHashMap22222 = new LinkedHashMap();
                        linkedHashMap22222.put("locksInterval", String.valueOf(C13742e.this.f61776g));
                        linkedHashMap22222.put("originLockToken", str5);
                        linkedHashMap22222.put("lockToken", C13742e.this.f61777h);
                        linkedHashMap22222.put("timestamp", String.valueOf(0L));
                        C10812z.m65846o(C13742e.this.f61770a, C13742e.this.f61775f, i10, message, "03001", "locks_keep", C13742e.this.f61774e, linkedHashMap22222, false);
                        throw th;
                    }
                }
            } catch (Throwable th8) {
                th = th8;
                i10 = 0;
                message = "";
                LinkedHashMap linkedHashMap222222 = new LinkedHashMap();
                linkedHashMap222222.put("locksInterval", String.valueOf(C13742e.this.f61776g));
                linkedHashMap222222.put("originLockToken", str5);
                linkedHashMap222222.put("lockToken", C13742e.this.f61777h);
                linkedHashMap222222.put("timestamp", String.valueOf(0L));
                C10812z.m65846o(C13742e.this.f61770a, C13742e.this.f61775f, i10, message, "03001", "locks_keep", C13742e.this.f61774e, linkedHashMap222222, false);
                throw th;
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) throws Throwable {
            if (message == null || message.what != 0) {
                return;
            }
            m82594b();
        }
    }

    public C13742e(Context context, String str, String str2, SyncProtocol syncProtocol, int i10, String str3) {
        this.f61777h = null;
        this.f61778i = true;
        this.f61770a = context;
        this.f61774e = str;
        this.f61771b = str2;
        this.f61773d = syncProtocol;
        this.f61776g = i10;
        this.f61775f = str3;
    }

    /* renamed from: j */
    public void m82588j() {
        C11839m.m70688i("KeepLockTask", "cancelKeepLock");
        Handler handler = this.f61779j;
        if (handler != null) {
            handler.removeMessages(0);
        }
        HandlerThread handlerThread = this.f61780k;
        if (handlerThread != null) {
            handlerThread.quit();
        }
        this.f61779j = null;
        this.f61780k = null;
    }

    /* renamed from: k */
    public void m82589k() {
        C11839m.m70688i("KeepLockTask", "syncV2 keepLockV2 cancelKeepLockV2");
        DriveSyncUtil.m17999i0();
    }

    /* renamed from: l */
    public final void m82590l() {
        HandlerThread handlerThread = new HandlerThread("KeepLockTask");
        this.f61780k = handlerThread;
        handlerThread.start();
        this.f61779j = new a(this.f61780k.getLooper());
    }

    /* renamed from: m */
    public void m82591m() {
        if (this.f61776g < 0) {
            C11839m.m70689w("KeepLockTask", "scheduleKeepLock error: mInterval < 0");
            return;
        }
        C11839m.m70688i("KeepLockTask", "scheduleKeepLock interval: " + this.f61776g);
        if (this.f61779j == null) {
            m82590l();
        }
        Message messageObtain = Message.obtain();
        messageObtain.what = 0;
        this.f61779j.sendMessageDelayed(messageObtain, this.f61776g * 1000);
    }

    /* renamed from: n */
    public void m82592n() {
        DriveSyncUtil.m17993f0(this.f61775f, this.f61776g, this.f61777h, this.f61771b, this.f61774e);
    }

    public C13742e(Context context, String str, String str2, C9453i c9453i, int i10, String str3, String str4) {
        this.f61773d = null;
        this.f61778i = true;
        this.f61770a = context;
        this.f61774e = str;
        this.f61771b = str2;
        this.f61772c = c9453i;
        this.f61777h = str3;
        this.f61776g = i10;
        this.f61775f = str4;
    }
}
