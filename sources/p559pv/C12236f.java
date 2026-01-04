package p559pv;

import android.text.TextUtils;
import mv.C11533f;
import p374iv.C10626e;
import p535ov.InterfaceC12044k;

/* renamed from: pv.f */
/* loaded from: classes9.dex */
public class C12236f implements InterfaceC12231a<InterfaceC12044k, String> {

    /* renamed from: a */
    public String f56619a;

    @Override // p559pv.InterfaceC12231a
    /* renamed from: a */
    public String mo73423a() {
        return this.f56619a;
    }

    @Override // p559pv.InterfaceC12231a
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void mo73425c(String str, InterfaceC12044k interfaceC12044k) throws C10626e {
        this.f56619a = C11533f.m68823a(interfaceC12044k.message(), str + " can't be empty");
    }

    @Override // p559pv.InterfaceC12231a
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public boolean mo73424b(String str) {
        return !TextUtils.isEmpty(str);
    }
}
