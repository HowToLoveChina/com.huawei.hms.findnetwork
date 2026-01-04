package p341hj;

import android.os.Handler;
import com.huawei.cloud.pay.model.EstimateResp;
import fk.C9721b;
import java.math.BigDecimal;
import java.util.Map;
import p054cj.C1442a;
import p315gj.C9948a;
import p429kk.C11060c;

/* renamed from: hj.l */
/* loaded from: classes5.dex */
public class C10243l extends AbstractC10222e {

    /* renamed from: b */
    public Handler f49640b;

    /* renamed from: c */
    public String f49641c;

    /* renamed from: d */
    public int f49642d;

    /* renamed from: e */
    public C11060c f49643e;

    /* renamed from: f */
    public BigDecimal f49644f;

    /* renamed from: g */
    public Integer f49645g;

    /* renamed from: h */
    public String f49646h;

    /* renamed from: i */
    public boolean f49647i;

    /* renamed from: j */
    public Map<String, String> f49648j;

    public C10243l(Handler handler, String str, int i10, C11060c c11060c, BigDecimal bigDecimal) {
        this.f49640b = handler;
        this.f49641c = str;
        this.f49642d = i10;
        this.f49643e = c11060c;
        this.f49644f = bigDecimal;
    }

    @Override // com.huawei.android.hicloud.logic.threadpool.TaskObject
    /* renamed from: a */
    public void mo16407a() {
        try {
            if (this.f49647i) {
                EstimateResp estimateRespM61680l = C9948a.m61631C().m61680l(this.f49643e, this.f49648j);
                this.f49643e.m66665u(String.valueOf(0));
                this.f49643e.m66635A("success");
                m63380f(this.f49640b, 2134, estimateRespM61680l);
            } else {
                EstimateResp estimateRespM61678k = C9948a.m61631C().m61678k(this.f49641c, this.f49642d, this.f49643e, this.f49644f, this.f49645g, this.f49646h);
                this.f49643e.m66665u(String.valueOf(0));
                this.f49643e.m66635A("success");
                BigDecimal bigDecimal = this.f49644f;
                if (bigDecimal == null || BigDecimal.ZERO.compareTo(bigDecimal) == 0) {
                    m63380f(this.f49640b, 2004, estimateRespM61678k);
                } else {
                    m63380f(this.f49640b, 7040, estimateRespM61678k);
                }
            }
        } catch (C9721b e10) {
            C1442a.m8291w("EstimateTask", "estimate package err. " + e10.m60659c() + " " + e10.getMessage());
            C11060c c11060c = this.f49643e;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("114_");
            sb2.append(e10.m60659c());
            c11060c.m66665u(sb2.toString());
            this.f49643e.m66635A(e10.getMessage());
            if (this.f49647i) {
                m63379e(this.f49640b, 2135, e10);
                return;
            }
            BigDecimal bigDecimal2 = this.f49644f;
            if (bigDecimal2 == null || BigDecimal.ZERO.compareTo(bigDecimal2) == 0) {
                m63379e(this.f49640b, 2104, e10);
            } else {
                m63379e(this.f49640b, 7041, e10);
            }
        }
    }

    public C10243l(Handler handler, String str, int i10, C11060c c11060c, BigDecimal bigDecimal, Integer num, String str2) {
        this.f49640b = handler;
        this.f49641c = str;
        this.f49642d = i10;
        this.f49643e = c11060c;
        this.f49644f = bigDecimal;
        this.f49645g = num;
        this.f49646h = str2;
    }

    public C10243l(Handler handler, C11060c c11060c, boolean z10, Map<String, String> map) {
        this.f49640b = handler;
        this.f49643e = c11060c;
        this.f49647i = z10;
        this.f49648j = map;
    }
}
