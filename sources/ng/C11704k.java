package ng;

import android.os.Handler;
import android.text.TextUtils;
import eg.AbstractC9478g;
import fk.C9721b;
import p809yg.C13981a;

/* renamed from: ng.k */
/* loaded from: classes4.dex */
public class C11704k extends AbstractC9478g {

    /* renamed from: a */
    public final Handler f54188a;

    /* renamed from: b */
    public boolean f54189b;

    public C11704k(Handler handler, boolean z10) {
        this.f54188a = handler;
        this.f54189b = z10;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws C9721b {
        C13981a.m83989i("WapFindPhoneCheckTask", "check url");
        String strM69792h = this.f54189b ? C11702i.m69792h() : C11702i.m69791g();
        String strM69788d = C11702i.m69788d();
        if (TextUtils.isEmpty(strM69792h)) {
            C13981a.m83988e("WapFindPhoneCheckTask", "wapFindPhoneUrl is empty");
            Handler handler = this.f54188a;
            if (handler != null) {
                handler.sendEmptyMessage(1005);
                return;
            }
            return;
        }
        if (!TextUtils.isEmpty(strM69788d)) {
            if (this.f54188a != null) {
                C13981a.m83989i("WapFindPhoneCheckTask", "send success msg");
                this.f54188a.sendMessage(this.f54188a.obtainMessage(1004, strM69792h));
                return;
            }
            return;
        }
        C13981a.m83988e("WapFindPhoneCheckTask", "casDomainUrl is empty");
        Handler handler2 = this.f54188a;
        if (handler2 != null) {
            handler2.sendEmptyMessage(1005);
        }
    }
}
