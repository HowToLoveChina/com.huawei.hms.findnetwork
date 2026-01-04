package p829z1;

import com.bumptech.glide.load.engine.cache.InterfaceC1579a;
import java.io.File;
import p759x1.C13684i;
import p759x1.InterfaceC13679d;

/* renamed from: z1.e */
/* loaded from: classes.dex */
public class C14066e<DataType> implements InterfaceC1579a.b {

    /* renamed from: a */
    public final InterfaceC13679d<DataType> f62874a;

    /* renamed from: b */
    public final DataType f62875b;

    /* renamed from: c */
    public final C13684i f62876c;

    public C14066e(InterfaceC13679d<DataType> interfaceC13679d, DataType datatype, C13684i c13684i) {
        this.f62874a = interfaceC13679d;
        this.f62875b = datatype;
        this.f62876c = c13684i;
    }

    @Override // com.bumptech.glide.load.engine.cache.InterfaceC1579a.b
    /* renamed from: a */
    public boolean mo9067a(File file) {
        return this.f62874a.mo56815b(this.f62875b, file, this.f62876c);
    }
}
