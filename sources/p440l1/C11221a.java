package p440l1;

import com.huawei.hms.support.api.entity.pay.HwPayConstant;
import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.money.Monetary;
import org.javamoney.moneta.Money;
import p244e1.C9381e;
import p323h1.C10077a;
import p354i1.InterfaceC10408t;
import p381j1.C10650d1;
import p381j1.C10664i0;
import p381j1.InterfaceC10686t0;

/* renamed from: l1.a */
/* loaded from: classes.dex */
public class C11221a implements InterfaceC10686t0, InterfaceC10408t {

    /* renamed from: a */
    public static final C11221a f52708a = new C11221a();

    @Override // p354i1.InterfaceC10408t
    /* renamed from: b */
    public <T> T mo63891b(C10077a c10077a, Type type, Object obj) {
        C9381e c9381eM62720a0 = c10077a.m62720a0();
        Object obj2 = c9381eM62720a0.get(HwPayConstant.KEY_CURRENCY);
        String strM58794N = obj2 instanceof C9381e ? ((C9381e) obj2).m58794N("currencyCode") : obj2 instanceof String ? (String) obj2 : null;
        Object obj3 = c9381eM62720a0.get("numberStripped");
        if ((obj3 instanceof BigDecimal) || (obj3 instanceof Integer) || (obj3 instanceof BigInteger)) {
            return (T) Money.of((Number) obj3, Monetary.getCurrency(strM58794N, new String[0]));
        }
        throw new UnsupportedOperationException();
    }

    @Override // p354i1.InterfaceC10408t
    /* renamed from: c */
    public int mo63892c() {
        return 0;
    }

    @Override // p381j1.InterfaceC10686t0
    /* renamed from: e */
    public void mo63933e(C10664i0 c10664i0, Object obj, Object obj2, Type type, int i10) throws IOException {
        Money money = (Money) obj;
        if (money == null) {
            c10664i0.m65264I();
            return;
        }
        C10650d1 c10650d1 = c10664i0.f51258k;
        c10650d1.m65215H('{', "numberStripped", money.getNumberStripped());
        c10650d1.m65214G(',', HwPayConstant.KEY_CURRENCY, money.getCurrency().getCurrencyCode());
        c10650d1.write(125);
    }
}
