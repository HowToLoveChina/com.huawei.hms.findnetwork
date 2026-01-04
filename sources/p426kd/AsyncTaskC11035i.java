package p426kd;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import com.huawei.hicloud.base.bean.ModuleItem;
import com.huawei.hicloud.base.bean.ModuleItemForAll;
import com.huawei.hms.videokit.player.common.PlayerConstants;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import p015ak.C0212e0;
import p015ak.C0213f;
import p336he.C10155f;
import p514o9.C11839m;
import p516ob.C11845a;
import p581qk.AbstractC12367d;
import p616rk.C12515a;

/* renamed from: kd.i */
/* loaded from: classes3.dex */
public class AsyncTaskC11035i extends AsyncTask<Void, Void, ModuleItemForAll> {

    /* renamed from: f */
    public static AsyncTaskC11035i f52138f;

    /* renamed from: a */
    public Handler f52139a;

    /* renamed from: b */
    public CountDownLatch f52140b;

    /* renamed from: c */
    public Context f52141c;

    /* renamed from: d */
    public Handler f52142d = new a();

    /* renamed from: e */
    public Messenger f52143e = new Messenger(this.f52142d);

    /* renamed from: kd.i$a */
    public class a extends Handler {
        public a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1020:
                case PlayerConstants.ErrorCode.MEDIA_SEEK_NO_AVAILABLE_SEGMENT /* 1021 */:
                case PlayerConstants.ErrorCode.SWITCH_PLAYMODE_NORMAL_FAILED /* 1023 */:
                case 1024:
                    AsyncTaskC11035i.this.f52140b.countDown();
                    break;
            }
        }
    }

    /* renamed from: kd.i$b */
    public class b extends AbstractC12367d {
        public b() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            AsyncTaskC11034h asyncTaskC11034hM66524c = AsyncTaskC11034h.m66524c(AsyncTaskC11035i.this.f52141c, AsyncTaskC11035i.this.f52143e);
            asyncTaskC11034hM66524c.m66530g(false);
            asyncTaskC11034hM66524c.m66529f(false);
            if (AsyncTask.Status.RUNNING.equals(asyncTaskC11034hM66524c.getStatus())) {
                return;
            }
            asyncTaskC11034hM66524c.execute(new Void[0]);
        }

        @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
        public boolean syncLock() {
            return false;
        }

        public /* synthetic */ b(AsyncTaskC11035i asyncTaskC11035i, a aVar) {
            this();
        }
    }

    /* renamed from: kd.i$c */
    public class c extends AbstractC12367d {
        public c() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            AsyncTaskC11036j asyncTaskC11036jM66538d = AsyncTaskC11036j.m66538d(AsyncTaskC11035i.this.f52141c, AsyncTaskC11035i.this.f52143e);
            if (AsyncTask.Status.RUNNING.equals(asyncTaskC11036jM66538d.getStatus())) {
                return;
            }
            asyncTaskC11036jM66538d.execute(new Void[0]);
        }

        @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
        public boolean syncLock() {
            return false;
        }

        public /* synthetic */ c(AsyncTaskC11035i asyncTaskC11035i, a aVar) {
            this();
        }
    }

    /* renamed from: kd.i$d */
    public class d extends AbstractC12367d {
        public d() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            AsyncTaskC11038l asyncTaskC11038lM66556b = AsyncTaskC11038l.m66556b(AsyncTaskC11035i.this.f52141c, AsyncTaskC11035i.this.f52143e);
            if (AsyncTask.Status.RUNNING.equals(asyncTaskC11038lM66556b.getStatus())) {
                return;
            }
            asyncTaskC11038lM66556b.execute(new Void[0]);
        }

        @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
        public boolean syncLock() {
            return false;
        }

        public /* synthetic */ d(AsyncTaskC11035i asyncTaskC11035i, a aVar) {
            this();
        }
    }

    /* renamed from: kd.i$e */
    public class e extends AbstractC12367d {
        public e() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            AsyncTaskC11039m asyncTaskC11039mM66560c = AsyncTaskC11039m.m66560c(AsyncTaskC11035i.this.f52141c, AsyncTaskC11035i.this.f52143e);
            asyncTaskC11039mM66560c.m66566g(false);
            asyncTaskC11039mM66560c.m66565f(false);
            if (AsyncTask.Status.RUNNING.equals(asyncTaskC11039mM66560c.getStatus())) {
                return;
            }
            asyncTaskC11039mM66560c.execute(new Void[0]);
        }

        @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
        public boolean syncLock() {
            return false;
        }

        public /* synthetic */ e(AsyncTaskC11035i asyncTaskC11035i, a aVar) {
            this();
        }
    }

    public AsyncTaskC11035i(Context context, Handler handler) {
        this.f52141c = context;
        this.f52139a = handler;
    }

    /* renamed from: e */
    public static AsyncTaskC11035i m66534e(Context context, Handler handler) {
        if (f52138f == null || AsyncTask.Status.FINISHED.equals(f52138f.getStatus())) {
            f52138f = new AsyncTaskC11035i(context, handler);
        } else {
            AsyncTaskC11035i asyncTaskC11035i = f52138f;
            if (handler != asyncTaskC11035i.f52139a) {
                asyncTaskC11035i.f52139a = handler;
            }
        }
        return f52138f;
    }

    @Override // android.os.AsyncTask
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public ModuleItemForAll doInBackground(Void... voidArr) {
        boolean zM63255H = C10155f.m63255H(this.f52141c);
        boolean zM63298v = C10155f.m63298v(this.f52141c);
        boolean zM63254G = C10155f.m63254G(this.f52141c);
        boolean zM63250C = C10155f.m63250C(this.f52141c);
        int i10 = zM63298v ? (zM63255H ? 1 : 0) + 1 : zM63255H ? 1 : 0;
        if (zM63254G) {
            i10++;
        }
        if (zM63250C) {
            i10++;
        }
        C11839m.m70686d("GetCloudDiskDataTask", "tasknum:" + i10);
        a aVar = null;
        if (i10 <= 0) {
            return null;
        }
        this.f52140b = new CountDownLatch(i10);
        if (zM63255H) {
            C12515a.m75110o().m75172d(new e(this, aVar));
        }
        if (zM63298v) {
            C12515a.m75110o().m75172d(new b(this, aVar));
        }
        if (zM63254G) {
            C12515a.m75110o().m75172d(new d(this, aVar));
        }
        if (zM63250C) {
            C12515a.m75110o().m75172d(new c(this, aVar));
        }
        try {
            if (this.f52140b.await(20000L, TimeUnit.MILLISECONDS)) {
                C11839m.m70688i("GetCloudDiskDataTask", "GetCloudDiskDataTask request all task success");
            } else {
                C11839m.m70688i("GetCloudDiskDataTask", "GetCloudDiskDataTask request timeout");
            }
        } catch (InterruptedException e10) {
            C11839m.m70687e("GetCloudDiskDataTask", "GetCloudDiskDataTask doInBackground exception:" + e10.toString());
        }
        List<ModuleItem> listM70932s = C11845a.m70932s();
        List<ModuleItem> listM70924k = C11845a.m70924k();
        List<ModuleItem> listM70931r = C11845a.m70931r();
        List<ModuleItem> listM70930q = C11845a.m70930q();
        ModuleItemForAll moduleItemForAll = new ModuleItemForAll();
        moduleItemForAll.setSmsItems(listM70932s);
        moduleItemForAll.setCallLogItems(listM70924k);
        moduleItemForAll.setRecordingItems(listM70931r);
        moduleItemForAll.setPhonemanagerItems(listM70930q);
        m66537g(moduleItemForAll);
        return moduleItemForAll;
    }

    @Override // android.os.AsyncTask
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(ModuleItemForAll moduleItemForAll) {
        C11839m.m70688i("GetCloudDiskDataTask", "onPostExecute");
        Message messageObtain = Message.obtain(this.f52139a);
        messageObtain.what = 10035;
        messageObtain.obj = moduleItemForAll;
        this.f52139a.sendMessage(messageObtain);
    }

    /* renamed from: g */
    public final void m66537g(ModuleItemForAll moduleItemForAll) {
        if (moduleItemForAll == null) {
            C11839m.m70687e("GetCloudDiskDataTask", "saveMoreAppinfo moduleItemForAll is null.");
            return;
        }
        C0212e0.m1365o(C0213f.m1377a(), "more_app_info_sp", "sms_items", moduleItemForAll.hasSmsData());
        C0212e0.m1365o(C0213f.m1377a(), "more_app_info_sp", "calllog_items", moduleItemForAll.hasCallLogData());
        C0212e0.m1365o(C0213f.m1377a(), "more_app_info_sp", "recording_items", moduleItemForAll.hasRecordingData());
        C0212e0.m1365o(C0213f.m1377a(), "more_app_info_sp", "phonemanager_items", moduleItemForAll.hasPhoneManagerData());
    }

    @Override // android.os.AsyncTask
    public void onPreExecute() {
    }
}
