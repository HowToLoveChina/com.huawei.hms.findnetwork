package p341hj;

import android.content.Context;
import android.os.Handler;
import com.huawei.cloud.pay.model.CardPackage;
import com.huawei.cloud.pay.model.CardPackageResp;
import fk.C9721b;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.NoSuchPaddingException;
import p054cj.C1442a;
import p315gj.C9948a;
import p429kk.C11060c;
import p454lj.C11282e;
import p454lj.C11292o;

/* renamed from: hj.x */
/* loaded from: classes5.dex */
public class C10272x extends AbstractC10222e {

    /* renamed from: b */
    public Handler f49742b;

    /* renamed from: c */
    public Context f49743c;

    /* renamed from: d */
    public String f49744d;

    /* renamed from: e */
    public C11060c f49745e;

    public C10272x(Handler handler, Context context, String str, C11060c c11060c) {
        this.f49742b = handler;
        this.f49743c = context;
        this.f49744d = str;
        this.f49745e = c11060c;
    }

    @Override // com.huawei.android.hicloud.logic.threadpool.TaskObject
    /* renamed from: a */
    public void mo16407a() throws InvalidKeySpecException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        try {
            C11282e c11282eM67709b = C11282e.m67709b(this.f49743c);
            String strM67712d = c11282eM67709b.m67712d("PUBLIC_KEY");
            long jM67713e = c11282eM67709b.m67713e("PUBLIC_KEY_TIMESTAMP");
            long jCurrentTimeMillis = System.currentTimeMillis();
            C1442a.m8288d("GetCardTask", "publicKey timestamp:" + jM67713e + ", currentTimeMillis:" + jCurrentTimeMillis);
            if ("".equals(strM67712d) || jCurrentTimeMillis - jM67713e > 14400000) {
                strM67712d = C9948a.m61631C().m61639H(this.f49745e);
                c11282eM67709b.m67717i("PUBLIC_KEY", strM67712d);
                c11282eM67709b.m67715g("PUBLIC_KEY_TIMESTAMP", jCurrentTimeMillis);
            }
            String strM67756a = C11292o.m67756a(strM67712d, this.f49744d);
            CardPackageResp cardPackageRespM61702y = C9948a.m61631C().m61702y(strM67756a, this.f49745e);
            CardPackage cardPackage = cardPackageRespM61702y.getCardPackage();
            if (cardPackage != null) {
                cardPackage.setEncCardNo(strM67756a);
            }
            this.f49745e.m66665u(String.valueOf(0));
            this.f49745e.m66635A("success");
            m63380f(this.f49742b, 2008, cardPackageRespM61702y);
        } catch (C9721b e10) {
            C1442a.m8291w("GetCardTask", "get card package err. " + e10.m60659c() + " " + e10.getMessage());
            C11060c c11060c = this.f49745e;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("114_");
            sb2.append(e10.m60659c());
            c11060c.m66665u(sb2.toString());
            this.f49745e.m66635A(e10.getMessage());
            m63379e(this.f49742b, 2108, e10);
        }
    }
}
