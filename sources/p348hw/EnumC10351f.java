package p348hw;

import java.util.EnumSet;
import java.util.Iterator;

/* renamed from: hw.f */
/* loaded from: classes9.dex */
public enum EnumC10351f {
    HWTAG("RX12", 14000),
    PIANO("ZAAG", 18000),
    DOVE("ZAAI", 14000),
    PIANOP("ZAAM", 18000),
    HARPER("ZAAL", 16000);


    /* renamed from: a */
    public String f50059a;

    /* renamed from: b */
    public int f50060b;

    EnumC10351f(String str, int i10) {
        this.f50059a = str;
        this.f50060b = i10;
    }

    /* renamed from: f */
    public static boolean m63740f(String str) {
        Iterator it = EnumSet.of(PIANO, DOVE, PIANOP, HARPER).iterator();
        while (it.hasNext()) {
            if (((EnumC10351f) it.next()).m63742e().equals(str)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    public int m63741b() {
        return this.f50060b;
    }

    /* renamed from: e */
    public String m63742e() {
        return this.f50059a;
    }
}
