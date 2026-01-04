package p431ko;

import fk.C9721b;
import java.util.concurrent.CountDownLatch;
import p015ak.C0209d;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;
import p616rk.C12515a;

/* renamed from: ko.b */
/* loaded from: classes6.dex */
public class C11076b extends AbstractC12367d {

    /* renamed from: a */
    public a f52273a;

    /* renamed from: b */
    public CountDownLatch f52274b;

    /* renamed from: ko.b$a */
    public interface a {
        /* renamed from: a */
        void mo18400a() throws C9721b;
    }

    public C11076b(CountDownLatch countDownLatch, a aVar) {
        this.f52273a = aVar;
        this.f52274b = countDownLatch;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() {
        try {
            try {
                a aVar = this.f52273a;
                if (aVar != null) {
                    aVar.mo18400a();
                    C11839m.m70688i("CommonRequestTask", "onFinish");
                }
            } catch (Exception e10) {
                C11839m.m70687e("CommonRequestTask", "CommonRequestTask exception:" + e10.getMessage());
            }
        } finally {
            C0209d.m1275l(this.f52274b);
        }
    }

    public void execute() {
        C12515a.m75110o().m75175e(this, false);
    }

    @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
    public AbstractRunnableC12516b.a getEnum() {
        return AbstractRunnableC12516b.a.EXECUTE_NOW_TASK;
    }
}
