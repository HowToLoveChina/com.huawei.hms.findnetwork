package p446l7;

import android.content.Context;
import com.huawei.hicloud.request.agreement.request.SignInfo;
import fk.C9721b;
import gp.C10028c;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import p015ak.C0234s;
import p514o9.C11829c;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p861do.C9281a;

/* renamed from: l7.e */
/* loaded from: classes2.dex */
public class C11257e extends AbstractC12367d {

    /* renamed from: h */
    public static final Object f52850h = new Object();

    /* renamed from: a */
    public boolean f52851a;

    /* renamed from: b */
    public Context f52852b;

    /* renamed from: c */
    public boolean f52853c = true;

    /* renamed from: d */
    public boolean f52854d;

    /* renamed from: e */
    public boolean f52855e;

    /* renamed from: f */
    public boolean f52856f;

    /* renamed from: g */
    public CountDownLatch f52857g;

    public C11257e(Context context, boolean z10, boolean z11, boolean z12, boolean z13) {
        this.f52856f = true;
        this.f52851a = z10;
        this.f52852b = context;
        this.f52854d = z11;
        this.f52855e = z12;
        this.f52856f = z13 && "CN".equalsIgnoreCase(C11829c.m70533N());
    }

    /* renamed from: c */
    public final void m67592c() {
        synchronized (f52850h) {
            try {
                C9281a c9281a = new C9281a();
                try {
                    String strM70533N = C11829c.m70533N();
                    String strM1635m = C0234s.m1635m();
                    SignInfo signInfo = new SignInfo((short) 125, strM70533N, strM1635m, this.f52851a);
                    SignInfo signInfo2 = new SignInfo((short) 10013, strM70533N, strM1635m, this.f52851a);
                    SignInfo signInfo3 = new SignInfo((short) 10000, strM70533N, strM1635m, this.f52851a);
                    ArrayList arrayList = new ArrayList(3);
                    if (this.f52854d) {
                        arrayList.add(signInfo);
                    }
                    if (this.f52855e) {
                        arrayList.add(signInfo2);
                    }
                    if (this.f52856f) {
                        arrayList.add(signInfo3);
                    }
                    C11839m.m70688i("SignAgreementServiceTask", "sign result code = " + c9281a.m58354i(arrayList));
                    if (this.f52851a) {
                        C10028c.m62182c0().m62377p3("agr_force_query", false);
                    }
                    CountDownLatch countDownLatch = this.f52857g;
                    if (countDownLatch != null) {
                        countDownLatch.countDown();
                    }
                } catch (C9721b e10) {
                    C11839m.m70687e("SignAgreementServiceTask", "SignAgreementServiceTask failed, " + e10.getMessage());
                    m67593d();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() {
        C11839m.m70686d("SignAgreementServiceTask", "begin SignAgreementServiceTask.");
        if (this.f52851a) {
            C10028c c10028cM62183d0 = C10028c.m62183d0(this.f52852b);
            c10028cM62183d0.m62197C2("agr_sign_time", System.currentTimeMillis());
            c10028cM62183d0.m62232J3("agr_sign_local_version", "hwclouddrive 16.0.0.300");
            c10028cM62183d0.m62377p3("is_hicloud_terms_confirm", true);
        }
        m67592c();
    }

    /* renamed from: d */
    public final void m67593d() {
        C11839m.m70689w("SignAgreementServiceTask", "SignAgreementServiceTask Failed.");
        if (this.f52853c) {
            C11839m.m70686d("SignAgreementServiceTask", "SignAgreementServiceTask Retry.");
            this.f52853c = false;
            m67592c();
        }
        CountDownLatch countDownLatch = this.f52857g;
        if (countDownLatch != null) {
            countDownLatch.countDown();
        }
    }

    public C11257e(Context context, boolean z10, boolean z11, boolean z12, boolean z13, CountDownLatch countDownLatch) {
        this.f52856f = true;
        this.f52851a = z10;
        this.f52852b = context;
        this.f52854d = z11;
        this.f52855e = z12;
        this.f52856f = z13 && "CN".equalsIgnoreCase(C11829c.m70533N());
        this.f52857g = countDownLatch;
    }
}
