package p011aa;

import com.huawei.android.hicloud.datamigration.bean.CutBaseResp;
import fk.C9721b;
import p015ak.C0213f;
import p429kk.C11060c;
import p448l9.C11262a;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p837z9.C14160a;
import p837z9.C14162c;

/* renamed from: aa.a */
/* loaded from: classes3.dex */
public class C0081a extends AbstractC12367d {

    /* renamed from: a */
    public int f311a;

    /* renamed from: b */
    public C11060c f312b;

    /* renamed from: c */
    public int f313c;

    public C0081a(int i10, C11060c c11060c) {
        this.f313c = 0;
        this.f312b = c11060c;
        this.f311a = i10;
    }

    /* renamed from: c */
    public final void m658c() {
        int i10 = this.f313c + 1;
        this.f313c = i10;
        if (i10 >= 3) {
            C11839m.m70689w("AllowStatusReportTask", "retry time reach max!");
        } else {
            new C11262a().m67603g(C0213f.m1377a(), 4, new C14160a(), this.f313c);
        }
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() {
        try {
            CutBaseResp cutBaseRespM84985q = new C14162c(this.f312b).m84985q(this.f311a);
            if (cutBaseRespM84985q.getCode() != 0) {
                C11839m.m70689w("AllowStatusReportTask", "allow status report fail " + cutBaseRespM84985q.getCode() + "," + cutBaseRespM84985q.getInfo());
                m658c();
            }
        } catch (C9721b e10) {
            C11839m.m70687e("AllowStatusReportTask", "allow status report error, " + e10.toString());
            m658c();
        }
    }

    public C0081a(int i10, int i11) {
        this.f311a = i10;
        this.f313c = i11;
    }
}
