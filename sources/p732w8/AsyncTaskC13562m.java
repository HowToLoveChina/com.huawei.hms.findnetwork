package p732w8;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import com.huawei.android.hicloud.cloudspace.util.IFamilyShareInfoAndDetailFinish;
import com.huawei.hicloud.base.bean.FamilyDetailInfoResult;
import com.huawei.hicloud.base.bean.FamilyShareInfoAndDetailResult;
import com.huawei.hicloud.base.bean.FamilyShareInfoResult;
import com.huawei.hicloud.request.appmashup.bean.C4987f;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;
import p616rk.C12515a;
import p703v8.C13370g;
import p703v8.C13371h;
import p836z8.C14157f;

/* renamed from: w8.m */
/* loaded from: classes2.dex */
public class AsyncTaskC13562m extends AsyncTask<Void, Void, FamilyShareInfoAndDetailResult> implements IFamilyShareInfoAndDetailFinish {

    /* renamed from: e */
    public static AsyncTaskC13562m f60987e;

    /* renamed from: a */
    public Handler f60988a;

    /* renamed from: b */
    public CountDownLatch f60989b;

    /* renamed from: c */
    public FamilyShareInfoResult f60990c;

    /* renamed from: d */
    public FamilyDetailInfoResult f60991d;

    /* renamed from: w8.m$a */
    public static class a extends AbstractC12367d {

        /* renamed from: a */
        public IFamilyShareInfoAndDetailFinish f60992a;

        /* renamed from: b */
        public CountDownLatch f60993b;

        public a(IFamilyShareInfoAndDetailFinish iFamilyShareInfoAndDetailFinish, CountDownLatch countDownLatch) {
            this.f60992a = iFamilyShareInfoAndDetailFinish;
            this.f60993b = countDownLatch;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            this.f60992a.mo15522a(new C13370g().m80270a());
            this.f60993b.countDown();
        }

        @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
        public AbstractRunnableC12516b.a getEnum() {
            return AbstractRunnableC12516b.a.FAMILY_SHARE;
        }

        @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
        public boolean syncLock() {
            return false;
        }
    }

    /* renamed from: w8.m$b */
    public static class b extends AbstractC12367d {

        /* renamed from: a */
        public IFamilyShareInfoAndDetailFinish f60994a;

        /* renamed from: b */
        public CountDownLatch f60995b;

        public b(IFamilyShareInfoAndDetailFinish iFamilyShareInfoAndDetailFinish, CountDownLatch countDownLatch) {
            this.f60994a = iFamilyShareInfoAndDetailFinish;
            this.f60995b = countDownLatch;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            this.f60994a.mo15523b(new C13371h().m80271a());
            this.f60995b.countDown();
        }

        @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
        public AbstractRunnableC12516b.a getEnum() {
            return AbstractRunnableC12516b.a.FAMILY_SHARE;
        }

        @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
        public boolean syncLock() {
            return false;
        }
    }

    public AsyncTaskC13562m(Handler handler) {
        this.f60988a = handler;
    }

    /* renamed from: d */
    public static AsyncTaskC13562m m81514d(Handler handler) {
        if (f60987e == null || AsyncTask.Status.FINISHED.equals(f60987e.getStatus())) {
            f60987e = new AsyncTaskC13562m(handler);
        } else {
            AsyncTaskC13562m asyncTaskC13562m = f60987e;
            if (handler != asyncTaskC13562m.f60988a) {
                asyncTaskC13562m.f60988a = handler;
            }
        }
        return f60987e;
    }

    @Override // com.huawei.android.hicloud.cloudspace.util.IFamilyShareInfoAndDetailFinish
    /* renamed from: a */
    public void mo15522a(FamilyDetailInfoResult familyDetailInfoResult) {
        synchronized (this) {
            this.f60991d = familyDetailInfoResult;
        }
    }

    @Override // com.huawei.android.hicloud.cloudspace.util.IFamilyShareInfoAndDetailFinish
    /* renamed from: b */
    public void mo15523b(FamilyShareInfoResult familyShareInfoResult) {
        synchronized (this) {
            this.f60990c = familyShareInfoResult;
        }
    }

    @Override // android.os.AsyncTask
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public FamilyShareInfoAndDetailResult doInBackground(Void... voidArr) {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        this.f60989b = countDownLatch;
        this.f60990c = null;
        this.f60991d = null;
        b bVar = new b(this, countDownLatch);
        a aVar = new a(this, this.f60989b);
        C12515a.m75110o().m75172d(bVar);
        C12515a.m75110o().m75172d(aVar);
        try {
            if (this.f60989b.await(20000L, TimeUnit.MILLISECONDS)) {
                C11839m.m70688i("GetFamilyShareInfoAndDetailTask", "getfamilyshareinfo and detail request all task success");
            } else {
                C11839m.m70688i("GetFamilyShareInfoAndDetailTask", "getfamilyshareinfo and detail request timeout");
            }
        } catch (InterruptedException e10) {
            C11839m.m70687e("GetFamilyShareInfoAndDetailTask", "GetFamilyShareInfoAndDetailTask doInBackground exception:" + e10.toString());
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add("bs.dsu.cloud.total");
        arrayList.add("bs.grade");
        List<C4987f> listM84949i = C14157f.m84942g().m84949i(null, arrayList, "GetFamilyShare");
        FamilyShareInfoAndDetailResult familyShareInfoAndDetailResult = new FamilyShareInfoAndDetailResult();
        familyShareInfoAndDetailResult.setFamilyShareInfoResult(this.f60990c);
        familyShareInfoAndDetailResult.setFamilyDetailInfoResult(this.f60991d);
        if (listM84949i.size() > 0) {
            for (C4987f c4987f : listM84949i) {
                if (c4987f != null) {
                    if (c4987f.m30026b().equals("bs.dsu.cloud.total")) {
                        familyShareInfoAndDetailResult.setTotalSpace(Long.parseLong(c4987f.m30027c()));
                    }
                    if (c4987f.m30026b().equals("bs.grade")) {
                        familyShareInfoAndDetailResult.setGradeCode(c4987f.m30027c());
                    }
                }
            }
        }
        return familyShareInfoAndDetailResult;
    }

    @Override // android.os.AsyncTask
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(FamilyShareInfoAndDetailResult familyShareInfoAndDetailResult) {
        C11839m.m70688i("GetFamilyShareInfoAndDetailTask", "onPostExecute");
        Message messageObtain = Message.obtain(this.f60988a);
        messageObtain.what = 2013;
        messageObtain.obj = familyShareInfoAndDetailResult;
        this.f60988a.sendMessage(messageObtain);
    }

    @Override // android.os.AsyncTask
    public void onPreExecute() {
    }
}
