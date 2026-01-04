package bw;

import android.content.Context;
import android.text.TextUtils;
import aw.C1029b;
import lv.InterfaceC11350a;
import p374iv.C10627f;
import p407jv.C10933b;

/* renamed from: bw.a */
/* loaded from: classes9.dex */
public abstract class AbstractC1291a {

    /* renamed from: a */
    public EnumC1292b f5765a;

    /* renamed from: b */
    public String f5766b;

    /* renamed from: bw.a$a */
    public static class a implements InterfaceC11350a {

        /* renamed from: a */
        public final String f5767a;

        public a(String str) {
            this.f5767a = str;
        }

        /* renamed from: a */
        public String m7651a(String str) {
            if (TextUtils.isEmpty(str)) {
                return this.f5767a;
            }
            return this.f5767a + "-" + str;
        }

        @Override // lv.InterfaceC11350a
        /* renamed from: i */
        public void mo7652i(String str, String str2) {
            C1029b.m6234e(m7651a(str), str2, new Object[0]);
        }

        @Override // lv.InterfaceC11350a
        /* renamed from: w */
        public void mo7653w(String str, String str2) {
            C1029b.m6236g(m7651a(str), str2, new Object[0]);
        }
    }

    public AbstractC1291a(String str, EnumC1292b enumC1292b) {
        this.f5765a = enumC1292b;
        this.f5766b = str;
    }

    /* renamed from: a */
    public C10933b m7649a(Context context, String str, String str2) {
        try {
            return new C10933b(context, str, this.f5766b, new a(str2));
        } catch (C10627f e10) {
            C1029b.m6231b("BaseReporter", "HaReporter instance exception: {0}", e10.getMessage());
            return null;
        }
    }

    /* renamed from: b */
    public void m7650b(C10933b c10933b) {
        if (EnumC1292b.REPORT_ALWAYS != this.f5765a || c10933b == null) {
            return;
        }
        C1029b.m6234e("BaseReporter", "set OobeCheckOff.", new Object[0]);
        c10933b.m66060d();
    }
}
