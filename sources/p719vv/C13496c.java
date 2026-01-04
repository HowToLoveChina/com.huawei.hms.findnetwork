package p719vv;

import java.util.Map;
import mv.C11533f;
import p374iv.C10626e;
import p535ov.InterfaceC12043j;
import p559pv.InterfaceC12231a;
import p789xv.C13868b;

/* renamed from: vv.c */
/* loaded from: classes9.dex */
public class C13496c implements InterfaceC12231a<InterfaceC12043j, Map> {

    /* renamed from: a */
    public String f60733a;

    /* renamed from: b */
    public int f60734b;

    /* renamed from: c */
    public int f60735c;

    @Override // p559pv.InterfaceC12231a
    /* renamed from: a */
    public String mo73423a() {
        return this.f60733a;
    }

    @Override // p559pv.InterfaceC12231a
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void mo73425c(String str, InterfaceC12043j interfaceC12043j) throws C10626e {
        C13868b.m83204a(interfaceC12043j);
        this.f60734b = interfaceC12043j.min();
        this.f60735c = interfaceC12043j.max();
        this.f60733a = C11533f.m68827e(interfaceC12043j, str);
    }

    @Override // p559pv.InterfaceC12231a
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public boolean mo73424b(Map map) {
        if (map == null) {
            return true;
        }
        int size = map.size();
        return size >= this.f60734b && size <= this.f60735c;
    }
}
