package p829z1;

import android.util.Log;
import com.bumptech.glide.load.data.InterfaceC1564e;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import p243e0.InterfaceC9370e;
import p441l2.InterfaceC11225d;
import p630s2.C12676k;
import p759x1.C13684i;
import p759x1.InterfaceC13686k;

/* renamed from: z1.i */
/* loaded from: classes.dex */
public class C14070i<DataType, ResourceType, Transcode> {

    /* renamed from: a */
    public final Class<DataType> f62949a;

    /* renamed from: b */
    public final List<? extends InterfaceC13686k<DataType, ResourceType>> f62950b;

    /* renamed from: c */
    public final InterfaceC11225d<ResourceType, Transcode> f62951c;

    /* renamed from: d */
    public final InterfaceC9370e<List<Throwable>> f62952d;

    /* renamed from: e */
    public final String f62953e;

    /* renamed from: z1.i$a */
    public interface a<ResourceType> {
        /* renamed from: a */
        InterfaceC14083v<ResourceType> mo84338a(InterfaceC14083v<ResourceType> interfaceC14083v);
    }

    public C14070i(Class<DataType> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<? extends InterfaceC13686k<DataType, ResourceType>> list, InterfaceC11225d<ResourceType, Transcode> interfaceC11225d, InterfaceC9370e<List<Throwable>> interfaceC9370e) {
        this.f62949a = cls;
        this.f62950b = list;
        this.f62951c = interfaceC11225d;
        this.f62952d = interfaceC9370e;
        this.f62953e = "Failed DecodePath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    /* renamed from: a */
    public InterfaceC14083v<Transcode> m84349a(InterfaceC1564e<DataType> interfaceC1564e, int i10, int i11, C13684i c13684i, a<ResourceType> aVar) throws C14078q {
        return this.f62951c.mo9169a(aVar.mo84338a(m84350b(interfaceC1564e, i10, i11, c13684i)), c13684i);
    }

    /* renamed from: b */
    public final InterfaceC14083v<ResourceType> m84350b(InterfaceC1564e<DataType> interfaceC1564e, int i10, int i11, C13684i c13684i) throws C14078q {
        List<Throwable> list = (List) C12676k.m76276d(this.f62952d.mo58738b());
        try {
            return m84351c(interfaceC1564e, i10, i11, c13684i, list);
        } finally {
            this.f62952d.mo58737a(list);
        }
    }

    /* renamed from: c */
    public final InterfaceC14083v<ResourceType> m84351c(InterfaceC1564e<DataType> interfaceC1564e, int i10, int i11, C13684i c13684i, List<Throwable> list) throws C14078q {
        int size = this.f62950b.size();
        InterfaceC14083v<ResourceType> interfaceC14083vMo9147b = null;
        for (int i12 = 0; i12 < size; i12++) {
            InterfaceC13686k<DataType, ResourceType> interfaceC13686k = this.f62950b.get(i12);
            try {
                if (interfaceC13686k.mo9146a(interfaceC1564e.mo9011a(), c13684i)) {
                    interfaceC14083vMo9147b = interfaceC13686k.mo9147b(interfaceC1564e.mo9011a(), i10, i11, c13684i);
                }
            } catch (IOException | OutOfMemoryError | RuntimeException e10) {
                if (Log.isLoggable("DecodePath", 2)) {
                    Log.v("DecodePath", "Failed to decode data for " + interfaceC13686k, e10);
                }
                list.add(e10);
            }
            if (interfaceC14083vMo9147b != null) {
                break;
            }
        }
        if (interfaceC14083vMo9147b != null) {
            return interfaceC14083vMo9147b;
        }
        throw new C14078q(this.f62953e, new ArrayList(list));
    }

    public String toString() {
        return "DecodePath{ dataClass=" + this.f62949a + ", decoders=" + this.f62950b + ", transcoder=" + this.f62951c + '}';
    }
}
