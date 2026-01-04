package p372ip;

import cn.C1461a;
import com.huawei.hicloud.service.C5008e;
import p581qk.AbstractC12367d;

/* renamed from: ip.c */
/* loaded from: classes7.dex */
public class C10585c extends AbstractC12367d {

    /* renamed from: a */
    public boolean f50937a;

    public C10585c(boolean z10) {
        this.f50937a = z10;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() {
        if (new C5008e(null).m30043e(this.f50937a)) {
            C1461a.m8359i("FeatureSwitchConfigTask", "feature config query success");
        }
    }
}
