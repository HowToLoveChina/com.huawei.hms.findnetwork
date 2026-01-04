package p258ei;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import com.huawei.hicloud.notification.bean.BannerConfig;
import com.huawei.hicloud.notification.bean.BannerConfigObject;
import com.huawei.hicloud.notification.constants.RecommendCardConstants;
import com.huawei.hicloud.notification.manager.HiCloudBrandBannerManager;
import fi.AsyncTaskC9709a;
import java.io.File;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import p015ak.C0212e0;
import p015ak.C0213f;
import p459lp.C11327e;
import p514o9.C11839m;
import p514o9.C11842p;
import p783xp.C13843a;

/* renamed from: ei.a */
/* loaded from: classes.dex */
public class C9492a {

    /* renamed from: e */
    public static final C9492a f47267e = new C9492a();

    /* renamed from: f */
    public static HashMap<String, SoftReference<Bitmap>> f47268f = new HashMap<>();

    /* renamed from: g */
    public static final Object f47269g = new Object();

    /* renamed from: a */
    public b f47270a = new b();

    /* renamed from: b */
    public ExecutorService f47271b = Executors.newSingleThreadExecutor();

    /* renamed from: c */
    public float f47272c = 0.33307928f;

    /* renamed from: d */
    public String f47273d = "";

    /* renamed from: ei.a$a */
    public class a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ Message f47274a;

        public a(Message message) {
            this.f47274a = message;
        }

        @Override // java.lang.Runnable
        public void run() {
            C9492a.this.f47270a.handleMessage(this.f47274a);
        }
    }

    /* renamed from: ei.a$b */
    public static class b implements Handler.Callback {

        /* renamed from: a */
        public Context f47276a = C0213f.m1377a();

        /* renamed from: b */
        public Handler f47277b;

        /* renamed from: b */
        public final void m59369b() {
            C11839m.m70688i("BannerManager", "no need to doClear");
        }

        /* renamed from: c */
        public final void m59370c() {
            m59372e();
        }

        /* renamed from: d */
        public final void m59371d() {
            C11839m.m70688i("BannerManager", "no need to forceClear");
        }

        /* renamed from: e */
        public void m59372e() {
            C11839m.m70688i("BannerManager", "parseInitConfig");
            Message messageObtain = Message.obtain();
            messageObtain.what = 3;
            messageObtain.obj = C9492a.m59358j();
            this.f47277b.sendMessage(messageObtain);
        }

        /* renamed from: f */
        public void m59373f(Handler handler) {
            this.f47277b = handler;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 2) {
                m59369b();
                return false;
            }
            if (i10 == 3) {
                m59370c();
                return false;
            }
            if (i10 == 4) {
                m59371d();
                return false;
            }
            if (i10 != 5) {
                return false;
            }
            HiCloudBrandBannerManager.getInstance().getConfigFromOM(RecommendCardConstants.Entrance.BUY);
            return false;
        }
    }

    /* renamed from: d */
    public static void m59356d() {
        synchronized (f47269g) {
            f47268f.clear();
        }
    }

    /* renamed from: h */
    public static C9492a m59357h() {
        return f47267e;
    }

    /* renamed from: j */
    public static BannerConfig m59358j() {
        BannerConfig bannerConfig = new BannerConfig();
        bannerConfig.setConfigurations(new BannerConfigObject[1]);
        bannerConfig.deleteInvalidConfig();
        return bannerConfig;
    }

    /* renamed from: b */
    public void m59359b() {
        m59366l(2);
    }

    /* renamed from: c */
    public void m59360c(Context context) {
        if (context == null) {
            C11839m.m70687e("BannerManager", "clearBannerExit context null");
            return;
        }
        File file = new File(context.getFilesDir() + "/UpgradeHiCloudBannerConfig.json");
        if (!file.exists()) {
            C11839m.m70687e("BannerManager", "banner file not exist");
        } else if (!file.delete()) {
            C11839m.m70687e("BannerManager", "banner file del fail");
        }
        C13843a.m83085g(C0213f.m1377a().getFilesDir() + "/bannerpictures");
        C0212e0.m1352b(C0213f.m1377a(), "banner_path_url_pair");
        C0212e0.m1352b(C0213f.m1377a(), "banner_common_sp");
        m59356d();
        C11327e.m68059b("HiCloudSpaceBannerConfigV2");
    }

    /* renamed from: e */
    public void m59361e() {
        this.f47270a.m59372e();
    }

    /* renamed from: f */
    public void m59362f(Message message) {
        C11839m.m70688i("BannerManager", "doTask");
        if (message.what != 3) {
            if (this.f47271b.submit(new a(message)).isDone()) {
                return;
            }
            C11839m.m70687e("BannerManager", "do task not done");
        } else {
            C11839m.m70688i("BannerManager", "doTask CMD_INIT_BANNER");
            AsyncTaskC9709a asyncTaskC9709aM60560b = AsyncTaskC9709a.m60560b();
            if (AsyncTask.Status.RUNNING.equals(asyncTaskC9709aM60560b.getStatus())) {
                return;
            }
            asyncTaskC9709aM60560b.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    /* renamed from: g */
    public void m59363g() {
        m59366l(4);
    }

    /* renamed from: i */
    public float m59364i() {
        return this.f47272c;
    }

    /* renamed from: k */
    public void m59365k() {
        C11839m.m70688i("BannerManager", "refreshPropertion");
        if (!C11842p.m70759Q0() || C11842p.m70753O0(this.f47270a.f47276a)) {
            this.f47272c = 0.1587936f;
        } else {
            this.f47272c = 0.33307928f;
        }
    }

    /* renamed from: l */
    public void m59366l(int i10) {
        Message messageObtain = Message.obtain();
        messageObtain.what = i10;
        m59362f(messageObtain);
        C11839m.m70688i("BannerManager", "send cmd: " + i10);
    }

    /* renamed from: m */
    public void m59367m(Handler handler) {
        this.f47270a.m59373f(handler);
    }
}
