package p354i1;

import com.huawei.openalliance.p169ad.constant.Constants;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import p244e1.C9380d;
import p274f1.InterfaceC9641b;
import p323h1.C10077a;
import p323h1.C10084h;
import p323h1.C10085i;
import p481n1.C11592d;

/* renamed from: i1.f */
/* loaded from: classes.dex */
public class C10394f extends AbstractC10400l {

    /* renamed from: c */
    public InterfaceC10408t f50190c;

    /* renamed from: d */
    public boolean f50191d;

    public C10394f(C10085i c10085i, Class<?> cls, C11592d c11592d) {
        super(cls, c11592d);
        boolean z10 = false;
        this.f50191d = false;
        InterfaceC9641b interfaceC9641bM69199f = c11592d.m69199f();
        if (interfaceC9641bM69199f != null) {
            Class<?> clsDeserializeUsing = interfaceC9641bM69199f.deserializeUsing();
            if (clsDeserializeUsing != null && clsDeserializeUsing != Void.class) {
                z10 = true;
            }
            this.f50191d = z10;
        }
    }

    @Override // p354i1.AbstractC10400l
    /* renamed from: b */
    public int mo63896b() {
        InterfaceC10408t interfaceC10408t = this.f50190c;
        if (interfaceC10408t != null) {
            return interfaceC10408t.mo63892c();
        }
        return 2;
    }

    @Override // p354i1.AbstractC10400l
    /* renamed from: d */
    public void mo63897d(C10077a c10077a, Object obj, Type type, Map<String, Object> map) throws IOException {
        Object objMo63893f;
        C11592d c11592d;
        int i10;
        if (this.f50190c == null) {
            m63900k(c10077a.m62737s());
        }
        InterfaceC10408t interfaceC10408tM62867p = this.f50190c;
        Type typeM69193p = this.f50198a.f53773f;
        if (type instanceof ParameterizedType) {
            C10084h c10084hM62739t = c10077a.m62739t();
            if (c10084hM62739t != null) {
                c10084hM62739t.f49226e = type;
            }
            if (typeM69193p != type) {
                typeM69193p = C11592d.m69193p(this.f50199b, type, typeM69193p);
                if (interfaceC10408tM62867p instanceof C10404p) {
                    interfaceC10408tM62867p = c10077a.m62737s().m62867p(typeM69193p);
                }
            }
        }
        Type type2 = typeM69193p;
        if (!(interfaceC10408tM62867p instanceof C10403o) || (i10 = (c11592d = this.f50198a).f53777j) == 0) {
            C11592d c11592d2 = this.f50198a;
            String str = c11592d2.f53787t;
            objMo63893f = (!(str == null && c11592d2.f53777j == 0) && (interfaceC10408tM62867p instanceof AbstractC10393e)) ? ((AbstractC10393e) interfaceC10408tM62867p).mo63893f(c10077a, type2, c11592d2.f53768a, str, c11592d2.f53777j) : interfaceC10408tM62867p.mo63891b(c10077a, type2, c11592d2.f53768a);
        } else {
            objMo63893f = ((C10403o) interfaceC10408tM62867p).m63921h(c10077a, type2, c11592d.f53768a, i10);
        }
        if ((objMo63893f instanceof byte[]) && (Constants.GZIP.equals(this.f50198a.f53787t) || "gzip,base64".equals(this.f50198a.f53787t))) {
            try {
                GZIPInputStream gZIPInputStream = new GZIPInputStream(new ByteArrayInputStream((byte[]) objMo63893f));
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                while (true) {
                    byte[] bArr = new byte[1024];
                    int i11 = gZIPInputStream.read(bArr);
                    if (i11 == -1) {
                        break;
                    } else if (i11 > 0) {
                        byteArrayOutputStream.write(bArr, 0, i11);
                    }
                }
                objMo63893f = byteArrayOutputStream.toByteArray();
            } catch (IOException e10) {
                throw new C9380d("unzip bytes error.", e10);
            }
        }
        if (c10077a.m62708C() == 1) {
            C10077a.a aVarM62748z = c10077a.m62748z();
            aVarM62748z.f49166c = this;
            aVarM62748z.f49167d = c10077a.m62739t();
            c10077a.m62746x0(0);
            return;
        }
        if (obj == null) {
            map.put(this.f50198a.f53768a, objMo63893f);
        } else {
            mo63911h(obj, objMo63893f);
        }
    }

    /* renamed from: k */
    public InterfaceC10408t m63900k(C10085i c10085i) {
        if (this.f50190c == null) {
            InterfaceC9641b interfaceC9641bM69199f = this.f50198a.m69199f();
            if (interfaceC9641bM69199f == null || interfaceC9641bM69199f.deserializeUsing() == Void.class) {
                C11592d c11592d = this.f50198a;
                this.f50190c = c10085i.m62866o(c11592d.f53772e, c11592d.f53773f);
            } else {
                try {
                    this.f50190c = (InterfaceC10408t) interfaceC9641bM69199f.deserializeUsing().newInstance();
                } catch (Exception e10) {
                    throw new C9380d("create deserializeUsing ObjectDeserializer error", e10);
                }
            }
        }
        return this.f50190c;
    }
}
