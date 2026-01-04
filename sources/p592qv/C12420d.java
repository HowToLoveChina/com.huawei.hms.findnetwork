package p592qv;

import java.util.Arrays;
import java.util.List;
import mv.C11533f;
import p535ov.InterfaceC12035b;
import p559pv.InterfaceC12231a;

/* renamed from: qv.d */
/* loaded from: classes9.dex */
public class C12420d implements InterfaceC12231a<InterfaceC12035b, String> {

    /* renamed from: a */
    public String f57257a;

    /* renamed from: b */
    public List<String> f57258b;

    @Override // p559pv.InterfaceC12231a
    /* renamed from: a */
    public String mo73423a() {
        return this.f57257a;
    }

    @Override // p559pv.InterfaceC12231a
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void mo73425c(String str, InterfaceC12035b interfaceC12035b) {
        this.f57258b = Arrays.asList(interfaceC12035b.strArr());
        this.f57257a = C11533f.m68823a(interfaceC12035b.message(), str + " must in strArr:" + Arrays.toString(interfaceC12035b.strArr()));
    }

    @Override // p559pv.InterfaceC12231a
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public boolean mo73424b(String str) {
        if (str == null) {
            return true;
        }
        return this.f57258b.contains(str);
    }
}
