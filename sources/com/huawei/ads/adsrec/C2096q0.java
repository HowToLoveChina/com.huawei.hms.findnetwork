package com.huawei.ads.adsrec;

import android.content.Context;
import java.util.Map;
import p216d4.C8998a;
import p216d4.C9020l;
import p216d4.InterfaceC9006e;
import p277f4.C9655a;
import p384j4.AbstractC10705d;
import p384j4.AbstractC10707f;

/* renamed from: com.huawei.ads.adsrec.q0 */
/* loaded from: classes.dex */
public class C2096q0 {

    /* renamed from: a */
    public final Context f9497a;

    /* renamed from: b */
    public Map<String, String> f9498b;

    /* renamed from: c */
    public boolean f9499c = false;

    /* renamed from: d */
    public InterfaceC9006e f9500d;

    public C2096q0(Context context) {
        this.f9497a = context.getApplicationContext();
        InterfaceC9006e interfaceC9006eM56860d = C8998a.m56860d();
        this.f9500d = interfaceC9006eM56860d;
        if (interfaceC9006eM56860d != null) {
            String config = interfaceC9006eM56860d.getConfig("tradeModeSupportRank");
            if (AbstractC10707f.m65379d(config)) {
                return;
            }
            this.f9498b = AbstractC10705d.m65336B(config);
        }
    }

    /* renamed from: a */
    public C9020l m12552a(C9020l c9020l, C9655a c9655a) {
        if (c9020l == null) {
            return null;
        }
        C8998a.m56857a();
        return c9020l;
    }
}
