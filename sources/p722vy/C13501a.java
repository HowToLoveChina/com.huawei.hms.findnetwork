package p722vy;

import uy.EnumC13290d;
import uy.InterfaceC13289c;

/* renamed from: vy.a */
/* loaded from: classes9.dex */
public class C13501a implements InterfaceC13289c {

    /* renamed from: a */
    public final String f60764a;

    /* renamed from: b */
    public final int f60765b;

    /* renamed from: c */
    public final Object f60766c;

    /* renamed from: d */
    public final EnumC13290d f60767d;

    public C13501a(String str, int i10) {
        this(str, i10, null, EnumC13290d.ANY);
    }

    public C13501a(String str, int i10, Object obj, EnumC13290d enumC13290d) {
        this.f60764a = str;
        this.f60765b = i10;
        this.f60766c = obj;
        if (obj instanceof EnumC13290d) {
            throw new IllegalArgumentException("params should not be CryptoServicePurpose");
        }
        this.f60767d = enumC13290d;
    }
}
