package p051c9;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.huawei.hicloud.notification.constants.HNConstants;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import p020ap.C1008c;
import p037bp.C1270a;
import p232dp.InterfaceC9282a;
import p514o9.C11839m;
import p572qb.C12330v;
import p746wn.C13622a;

/* renamed from: c9.a */
/* loaded from: classes3.dex */
public class C1396a {

    /* renamed from: e */
    public static Thread.UncaughtExceptionHandler f5961e = new a();

    /* renamed from: a */
    public Handler f5962a;

    /* renamed from: b */
    public c f5963b;

    /* renamed from: c */
    public C12330v f5964c = new C12330v();

    /* renamed from: d */
    public ArrayList<String> f5965d = new ArrayList<>();

    /* renamed from: c9.a$a */
    public class a implements Thread.UncaughtExceptionHandler {
        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th2) {
            C11839m.m70687e("LocalSyncDataHelper", thread.getName() + ": " + th2.getMessage());
        }
    }

    /* renamed from: c9.a$b */
    public class b implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ Context f5966a;

        /* renamed from: b */
        public final /* synthetic */ CopyOnWriteArrayList f5967b;

        /* renamed from: c */
        public final /* synthetic */ int f5968c;

        public b(Context context, CopyOnWriteArrayList copyOnWriteArrayList, int i10) {
            this.f5966a = context;
            this.f5967b = copyOnWriteArrayList;
            this.f5968c = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            C1396a.this.m7990d(this.f5966a, this.f5967b, this.f5968c);
        }
    }

    /* renamed from: c9.a$c */
    public static class c extends Thread {

        /* renamed from: a */
        public d f5970a;

        /* renamed from: b */
        public Looper f5971b;

        /* renamed from: c */
        public CopyOnWriteArrayList<String> f5972c;

        /* renamed from: d */
        public C1396a f5973d;

        /* renamed from: e */
        public Context f5974e;

        /* renamed from: f */
        public int f5975f;

        public c(Context context, C1396a c1396a, ArrayList<String> arrayList, int i10) {
            this.f5973d = c1396a;
            this.f5972c = new CopyOnWriteArrayList<>(arrayList);
            this.f5974e = context;
            this.f5975f = i10;
        }

        /* renamed from: a */
        public d m7993a() {
            return this.f5970a;
        }

        /* renamed from: c */
        public void m7994c() {
            try {
                Looper looper = this.f5971b;
                if (looper != null) {
                    looper.quit();
                }
            } catch (Exception e10) {
                C11839m.m70687e("LocalSyncDataHelper.HelperWorkThread", "looper quit failed：" + e10.toString());
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Looper.prepare();
            this.f5971b = Looper.myLooper();
            if (this.f5970a == null) {
                this.f5970a = new d(this.f5971b);
            }
            C1396a c1396a = this.f5973d;
            if (c1396a != null) {
                this.f5970a.m7995a(c1396a);
                this.f5973d.m7992f(this.f5974e, this.f5972c, this.f5975f);
            }
            Looper.loop();
        }
    }

    /* renamed from: c9.a$d */
    public static class d extends Handler {

        /* renamed from: a */
        public C1396a f5976a;

        public d(Looper looper) {
            super(looper);
        }

        /* renamed from: a */
        public void m7995a(C1396a c1396a) {
            this.f5976a = c1396a;
        }

        /* renamed from: b */
        public final void m7996b(String str, boolean z10, int i10) {
            C1396a c1396a = this.f5976a;
            if (c1396a == null) {
                C11839m.m70687e("LocalSyncDataHelper", "helperRef == null");
                return;
            }
            C12330v c12330vM7991e = c1396a.m7991e();
            if (c12330vM7991e == null) {
                C11839m.m70687e("LocalSyncDataHelper", "taskChecker == null");
                return;
            }
            c12330vM7991e.m74150f(str, true);
            if (z10) {
                this.f5976a.m7987a(str);
            }
            this.f5976a.m7989c(i10);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1000007) {
                boolean zBooleanValue = ((Boolean) message.obj).booleanValue();
                Bundle data = message.getData();
                if (data == null) {
                    C11839m.m70687e("LocalSyncDataHelper", "SyncDataHandler, handleMessage, bundle data is null");
                    return;
                }
                String string = data.getString("sync_type_key", "");
                int i10 = data.getInt("sync_operation_type", 0);
                C11839m.m70688i("LocalSyncDataHelper", "SyncDataHandler handleMessage syncType=" + string + ", hasLocalData=" + zBooleanValue);
                m7996b(string, zBooleanValue, i10);
            }
        }
    }

    public C1396a(Handler handler) {
        this.f5962a = handler;
    }

    /* renamed from: a */
    public void m7987a(String str) {
        this.f5965d.add(str);
    }

    /* renamed from: b */
    public void m7988b(Context context, ArrayList<String> arrayList, int i10) {
        C11839m.m70688i("LocalSyncDataHelper", "checkAllLocalSyncData");
        if (this.f5963b == null) {
            this.f5963b = new c(context, this, arrayList, i10);
        }
        this.f5963b.setName("HelperWorkThread");
        this.f5963b.setUncaughtExceptionHandler(f5961e);
        this.f5963b.start();
    }

    /* renamed from: c */
    public void m7989c(int i10) {
        if (this.f5964c.m74146b()) {
            C11839m.m70688i("LocalSyncDataHelper", "all task finished");
            Message message = new Message();
            if (this.f5965d.size() > 0) {
                message.what = 1046;
                message.obj = this.f5965d;
                message.arg1 = i10;
            } else {
                message.what = 1047;
                message.arg1 = i10;
            }
            if (this.f5962a != null) {
                C11839m.m70688i("LocalSyncDataHelper", "send local data exitst msg");
                this.f5962a.sendMessage(message);
            }
            c cVar = this.f5963b;
            if (cVar != null) {
                cVar.m7994c();
            }
        }
    }

    /* renamed from: d */
    public void m7990d(Context context, CopyOnWriteArrayList<String> copyOnWriteArrayList, int i10) {
        boolean zMo58466y0;
        C11839m.m70688i("LocalSyncDataHelper", "doCheck");
        c cVar = this.f5963b;
        d dVarM7993a = cVar != null ? cVar.m7993a() : null;
        if (dVarM7993a == null) {
            C11839m.m70687e("LocalSyncDataHelper", "syncDataHandler is null");
            return;
        }
        if (copyOnWriteArrayList == null) {
            Message message = new Message();
            message.what = 1047;
            message.arg1 = i10;
            this.f5962a.sendMessage(message);
            return;
        }
        if (copyOnWriteArrayList.size() <= 0) {
            Message message2 = new Message();
            message2.what = 1047;
            message2.arg1 = i10;
            this.f5962a.sendMessage(message2);
        }
        Iterator<String> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            this.f5964c.m74145a(new C12330v.a(it.next()));
        }
        InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
        Iterator<String> it2 = copyOnWriteArrayList.iterator();
        while (it2.hasNext()) {
            String next = it2.next();
            String strM81958d = C13622a.m81958d("03003");
            C11839m.m70688i("LocalSyncDataHelper", "Query local data: " + next + ", traceId: " + strM81958d);
            if (HNConstants.DataType.MEDIA.equals(next)) {
                if (interfaceC9282a != null) {
                    zMo58466y0 = interfaceC9282a.mo58466y0(context);
                } else {
                    C11839m.m70688i("LocalSyncDataHelper", "cloudAlbumRouterImpl is null");
                    zMo58466y0 = false;
                }
                Message messageObtain = Message.obtain();
                messageObtain.what = 1000007;
                messageObtain.obj = Boolean.valueOf(zMo58466y0);
                Bundle bundle = new Bundle();
                bundle.putString("sync_type_key", HNConstants.DataType.MEDIA);
                bundle.putInt("sync_operation_type", i10);
                messageObtain.setData(bundle);
                dVarM7993a.sendMessage(messageObtain);
            } else {
                C1008c.m6035v().m6048M(context, dVarM7993a, next, strM81958d, i10);
            }
        }
    }

    /* renamed from: e */
    public C12330v m7991e() {
        return this.f5964c;
    }

    /* renamed from: f */
    public void m7992f(Context context, CopyOnWriteArrayList<String> copyOnWriteArrayList, int i10) {
        Thread thread = new Thread(new b(context, copyOnWriteArrayList, i10), "NotifyCheckThread");
        thread.setUncaughtExceptionHandler(f5961e);
        thread.start();
    }
}
