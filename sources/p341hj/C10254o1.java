package p341hj;

import android.os.Handler;
import android.text.TextUtils;
import com.huawei.cloud.pay.model.ChannelInfo;
import com.huawei.cloud.pay.model.SignPurchaseResp;
import com.huawei.cloud.pay.model.VoucherInfo;
import fk.C9721b;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import p054cj.C1442a;
import p315gj.C9948a;
import p429kk.C11060c;

/* renamed from: hj.o1 */
/* loaded from: classes5.dex */
public class C10254o1 extends AbstractC10222e {

    /* renamed from: b */
    public Handler f49673b;

    /* renamed from: c */
    public C11060c f49674c;

    /* renamed from: d */
    public String f49675d;

    /* renamed from: e */
    public ChannelInfo f49676e;

    /* renamed from: f */
    public Map<String, String> f49677f;

    /* renamed from: g */
    public List<VoucherInfo> f49678g;

    /* renamed from: h */
    public String f49679h;

    /* renamed from: i */
    public int f49680i;

    /* renamed from: j */
    public BigDecimal f49681j;

    public C10254o1(Handler handler, C11060c c11060c, String str, ChannelInfo channelInfo, Map<String, String> map, List<VoucherInfo> list, String str2, int i10, BigDecimal bigDecimal) {
        this.f49673b = handler;
        this.f49674c = c11060c;
        this.f49675d = str;
        this.f49676e = channelInfo;
        this.f49677f = map;
        this.f49678g = list;
        this.f49679h = str2;
        this.f49680i = i10;
        this.f49681j = bigDecimal;
    }

    @Override // com.huawei.android.hicloud.logic.threadpool.TaskObject
    /* renamed from: a */
    public void mo16407a() {
        try {
            SignPurchaseResp signPurchaseRespM61692r0 = C9948a.m61631C().m61692r0(this.f49674c, this.f49675d, this.f49676e, this.f49677f, this.f49678g, this.f49679h, this.f49680i, this.f49681j);
            this.f49674c.m66665u(String.valueOf(0));
            this.f49674c.m66635A("success");
            if (TextUtils.isEmpty(this.f49679h)) {
                m63380f(this.f49673b, 7034, signPurchaseRespM61692r0);
            } else {
                m63380f(this.f49673b, 7036, signPurchaseRespM61692r0);
            }
        } catch (C9721b e10) {
            C1442a.m8291w("SignPurchaseTask", "SignPurchaseTask err. " + e10.m60659c() + " " + e10.getMessage());
            C11060c c11060c = this.f49674c;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("114_");
            sb2.append(e10.m60659c());
            c11060c.m66665u(sb2.toString());
            this.f49674c.m66635A(e10.getMessage());
            if (TextUtils.isEmpty(this.f49679h)) {
                m63379e(this.f49673b, 7035, e10);
            } else {
                m63379e(this.f49673b, 7037, e10);
            }
        }
    }
}
