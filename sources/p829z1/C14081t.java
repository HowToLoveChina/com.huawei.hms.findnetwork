package p829z1;

import com.bumptech.glide.load.data.InterfaceC1564e;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import p243e0.InterfaceC9370e;
import p630s2.C12676k;
import p759x1.C13684i;
import p829z1.C14070i;

/* renamed from: z1.t */
/* loaded from: classes.dex */
public class C14081t<Data, ResourceType, Transcode> {

    /* renamed from: a */
    public final Class<Data> f63045a;

    /* renamed from: b */
    public final InterfaceC9370e<List<Throwable>> f63046b;

    /* renamed from: c */
    public final List<? extends C14070i<Data, ResourceType, Transcode>> f63047c;

    /* renamed from: d */
    public final String f63048d;

    public C14081t(Class<Data> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<C14070i<Data, ResourceType, Transcode>> list, InterfaceC9370e<List<Throwable>> interfaceC9370e) {
        this.f63045a = cls;
        this.f63046b = interfaceC9370e;
        this.f63047c = (List) C12676k.m76275c(list);
        this.f63048d = "Failed LoadPath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    /* renamed from: a */
    public InterfaceC14083v<Transcode> m84414a(InterfaceC1564e<Data> interfaceC1564e, C13684i c13684i, int i10, int i11, C14070i.a<ResourceType> aVar) throws C14078q {
        List<Throwable> list = (List) C12676k.m76276d(this.f63046b.mo58738b());
        try {
            return m84415b(interfaceC1564e, c13684i, i10, i11, aVar, list);
        } finally {
            this.f63046b.mo58737a(list);
        }
    }

    /* renamed from: b */
    public final InterfaceC14083v<Transcode> m84415b(InterfaceC1564e<Data> interfaceC1564e, C13684i c13684i, int i10, int i11, C14070i.a<ResourceType> aVar, List<Throwable> list) throws C14078q {
        int size = this.f63047c.size();
        InterfaceC14083v<Transcode> interfaceC14083vM84349a = null;
        for (int i12 = 0; i12 < size; i12++) {
            try {
                interfaceC14083vM84349a = this.f63047c.get(i12).m84349a(interfaceC1564e, i10, i11, c13684i, aVar);
            } catch (C14078q e10) {
                list.add(e10);
            }
            if (interfaceC14083vM84349a != null) {
                break;
            }
        }
        if (interfaceC14083vM84349a != null) {
            return interfaceC14083vM84349a;
        }
        throw new C14078q(this.f63048d, new ArrayList(list));
    }

    public String toString() {
        return "LoadPath{decodePaths=" + Arrays.toString(this.f63047c.toArray()) + '}';
    }
}
