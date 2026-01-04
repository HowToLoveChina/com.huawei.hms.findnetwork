package p231dn;

import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import p263en.EnumC9527a;

/* renamed from: dn.a */
/* loaded from: classes6.dex */
public class C9279a implements InterfaceC9280b {

    /* renamed from: b */
    public static final Map<EnumC9527a, Integer> f46607b = new a();

    /* renamed from: a */
    public EnumC9527a f46608a;

    /* renamed from: dn.a$a */
    public static class a extends HashMap<EnumC9527a, Integer> {
        private static final long serialVersionUID = -4580553891604521798L;

        public a() {
            put(EnumC9527a.DEBUG, 3);
            put(EnumC9527a.INFO, 4);
            put(EnumC9527a.WARN, 5);
            put(EnumC9527a.ERROR, 6);
        }
    }

    @Override // p231dn.InterfaceC9280b
    /* renamed from: a */
    public void mo58343a(EnumC9527a enumC9527a, String str, String str2) {
        if (m58345c(this.f46608a, enumC9527a)) {
            Log.println(m58344b(enumC9527a), str, str2);
        }
    }

    /* renamed from: b */
    public final int m58344b(EnumC9527a enumC9527a) {
        Map<EnumC9527a, Integer> map = f46607b;
        if (map.containsKey(enumC9527a)) {
            return map.get(enumC9527a).intValue();
        }
        return 3;
    }

    /* renamed from: c */
    public final boolean m58345c(EnumC9527a enumC9527a, EnumC9527a enumC9527a2) {
        return enumC9527a == null || enumC9527a2.m59520b() >= enumC9527a.m59520b();
    }
}
