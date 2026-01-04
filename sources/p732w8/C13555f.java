package p732w8;

import java.io.File;
import java.util.concurrent.CountDownLatch;
import no.C11739b;
import p052cb.C1414k;
import p514o9.C11829c;
import p514o9.C11839m;
import p581qk.AbstractC12367d;

/* renamed from: w8.f */
/* loaded from: classes2.dex */
public class C13555f extends AbstractC12367d {

    /* renamed from: a */
    public String f60963a;

    /* renamed from: b */
    public String f60964b;

    /* renamed from: c */
    public CountDownLatch f60965c;

    public C13555f(String str, String str2) {
        this.f60963a = str;
        this.f60964b = str2;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() {
        CountDownLatch countDownLatch;
        try {
            try {
                C11739b c11739b = new C11739b(this.f60964b, this.f60963a, 0L);
                C11829c.m70598n(this.f60963a, c11739b.m70044b(), c11739b);
            } catch (Exception e10) {
                C11839m.m70687e("FamilyShareImageTask", e10.toString());
                countDownLatch = this.f60965c;
                if (countDownLatch == null) {
                    return;
                }
            }
            if (!new File(this.f60963a).exists()) {
                throw new C1414k("download picture to local failed. picUrl = " + this.f60964b + " destPath = " + this.f60963a);
            }
            if (C11829c.m70501B(this.f60963a) == null) {
                throw new C1414k("decode file failed. file: " + this.f60963a);
            }
            countDownLatch = this.f60965c;
            if (countDownLatch == null) {
                return;
            }
            countDownLatch.countDown();
        } catch (Throwable th2) {
            CountDownLatch countDownLatch2 = this.f60965c;
            if (countDownLatch2 != null) {
                countDownLatch2.countDown();
            }
            throw th2;
        }
    }

    public void setCount(CountDownLatch countDownLatch) {
        this.f60965c = countDownLatch;
    }
}
