package p431ko;

import fk.C9721b;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;
import p616rk.C12515a;

/* renamed from: ko.a */
/* loaded from: classes6.dex */
public class C11075a extends AbstractC12367d {

    /* renamed from: a */
    public a f52272a;

    /* renamed from: ko.a$a */
    public interface a<T> {
        /* renamed from: a */
        T mo19189a() throws C9721b;

        /* renamed from: b */
        void mo19190b();

        void onResult(T t10);
    }

    public C11075a(a aVar) {
        this.f52272a = aVar;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() {
        try {
            a aVar = this.f52272a;
            if (aVar != null) {
                Object objMo19189a = aVar.mo19189a();
                if (objMo19189a == null) {
                    C11839m.m70688i("CommonRequestTask", "onError data is null");
                    this.f52272a.mo19190b();
                } else {
                    C11839m.m70688i("CommonRequestTask", "onFinish: " + objMo19189a.getClass().getSimpleName());
                    this.f52272a.onResult(objMo19189a);
                }
            }
        } catch (Exception e10) {
            C11839m.m70687e("CommonRequestTask", "CommonRequestTask exception:" + e10.getMessage());
            this.f52272a.mo19190b();
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
