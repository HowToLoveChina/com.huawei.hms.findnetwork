package p610rd;

import com.huawei.android.backup.service.logic.C2126b;
import com.huawei.hicloud.request.cbs.bean.CBSDevice;
import fk.C9721b;
import gl.C9961b;
import gp.C10028c;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import je.C10810x;
import p252e9.C9428e;
import p429kk.C11058a;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;

/* renamed from: rd.d */
/* loaded from: classes3.dex */
public class C12491d extends AbstractC12367d {

    /* renamed from: a */
    public CountDownLatch f57509a;

    /* renamed from: b */
    public long f57510b;

    /* renamed from: c */
    public boolean f57511c = false;

    /* renamed from: d */
    public volatile boolean f57512d = false;

    public C12491d(long j10) {
        this.f57510b = 0L;
        this.f57510b = j10;
    }

    /* renamed from: e */
    private void m74977e(String str, String str2) {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(C2126b.ERROR_MESSAGE_INFO, str2);
        C9428e.m59118h().m59135r("query_unusual_device", str, linkedHashMap);
    }

    /* renamed from: c */
    public boolean m74978c() {
        return this.f57511c;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws C9721b {
        CountDownLatch countDownLatch;
        String strM66627b = C11058a.m66627b("07039");
        try {
            try {
                C11839m.m70688i("QueryUnusualEquipmentTask", "begin");
            } catch (Exception e10) {
                this.f57511c = false;
                C11839m.m70687e("QueryUnusualEquipmentTask", "exception: " + e10.toString());
                m74977e(strM66627b, "queryUnusualDevice error: " + e10.getMessage());
                C11839m.m70688i("QueryUnusualEquipmentTask", "end");
                countDownLatch = this.f57509a;
                if (countDownLatch != null) {
                }
            }
            if (!C10810x.m65810f(this.f57510b)) {
                C11839m.m70688i("QueryUnusualEquipmentTask", "current time is not allow request");
                return;
            }
            List<CBSDevice> listM61802p = C9961b.m61788i().m61802p();
            if (listM61802p != null) {
                m74980f(strM66627b, listM61802p.size());
            }
            this.f57511c = true;
            C10028c.m62182c0().m62255O2(System.currentTimeMillis());
            C11839m.m70688i("QueryUnusualEquipmentTask", "end");
            countDownLatch = this.f57509a;
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
            this.f57512d = true;
        } finally {
            C11839m.m70688i("QueryUnusualEquipmentTask", "end");
            CountDownLatch countDownLatch2 = this.f57509a;
            if (countDownLatch2 != null) {
                countDownLatch2.countDown();
            }
            this.f57512d = true;
        }
    }

    @Override // p616rk.AbstractRunnableC12516b
    public boolean cancel() {
        C11839m.m70688i("QueryUnusualEquipmentTask", "task cancel.");
        this.f57512d = true;
        return super.cancel();
    }

    /* renamed from: d */
    public boolean m74979d() {
        return this.f57512d;
    }

    /* renamed from: f */
    public final void m74980f(String str, int i10) {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("list_size", String.valueOf(i10));
        C9428e.m59118h().m59135r("query_unusual_device", str, linkedHashMap);
    }

    @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
    public AbstractRunnableC12516b.a getEnum() {
        return AbstractRunnableC12516b.a.QUERY_UNUSUAL_DEVICE;
    }

    public void setCount(CountDownLatch countDownLatch) {
        this.f57509a = countDownLatch;
    }
}
