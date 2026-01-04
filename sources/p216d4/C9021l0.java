package p216d4;

import android.content.Context;
import com.huawei.ads.adsrec.C2093e;
import com.huawei.ads.adsrec.C2098u0;
import p357i4.C10438c;
import p405jt.AbstractC10915a;

/* renamed from: d4.l0 */
/* loaded from: classes.dex */
public final class C9021l0 {
    /* renamed from: a */
    public static C9031r m56948a(Context context, String str, String str2, int i10) {
        AbstractC10915a.m65973e("SingleSlotLR", "recall %s slot: %s adType: %d", str, str2, Integer.valueOf(i10));
        C2093e c2093e = new C2093e(context);
        C9031r c9031rMo12527a = c2093e.mo12527a(str, str2);
        C10438c c10438cM12557a = new C2098u0(context).m12557a(str, str2);
        if (c10438cM12557a != null) {
            c9031rMo12527a.m56969j(c2093e.mo12538e(c10438cM12557a));
        }
        c9031rMo12527a.m56967g(c9031rMo12527a.m56978s() ? 204 : 200);
        return c9031rMo12527a;
    }
}
