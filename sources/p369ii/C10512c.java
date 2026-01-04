package p369ii;

import com.huawei.cloud.base.http.AbstractC4619v;
import com.huawei.cloud.base.http.AbstractC4622y;
import com.huawei.cloud.base.http.AbstractC4623z;
import com.huawei.cloud.base.http.C4609l;
import com.huawei.cloud.base.http.C4612o;
import com.huawei.cloud.base.http.C4615r;
import com.huawei.cloud.base.http.C4618u;
import com.huawei.cloud.base.http.InterfaceC4605h;
import com.huawei.cloud.base.http.InterfaceC4620w;
import com.huawei.cloud.base.util.C4634e;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import p369ii.C10511b;

/* renamed from: ii.c */
/* loaded from: classes.dex */
public final class C10512c {

    /* renamed from: a */
    public final String f50679a;

    /* renamed from: b */
    public final List<C10511b.b<?, ?>> f50680b;

    /* renamed from: c */
    public final InputStream f50681c;

    /* renamed from: d */
    public final boolean f50682d;

    /* renamed from: e */
    public int f50683e = 0;

    /* renamed from: f */
    public boolean f50684f = true;

    /* renamed from: g */
    public List<C10511b.b<?, ?>> f50685g = new ArrayList();

    /* renamed from: h */
    public boolean f50686h;

    /* renamed from: ii.c$a */
    public class a extends FilterInputStream {
        public a(InputStream inputStream) {
            super(inputStream);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }
    }

    /* renamed from: ii.c$b */
    public static class b extends AbstractC4622y {

        /* renamed from: g */
        public InputStream f50688g;

        /* renamed from: h */
        public int f50689h;

        /* renamed from: i */
        public List<String> f50690i;

        /* renamed from: j */
        public List<String> f50691j;

        public b(InputStream inputStream, int i10, List<String> list, List<String> list2) {
            this.f50688g = inputStream;
            this.f50689h = i10;
            this.f50690i = list;
            this.f50691j = list2;
        }

        @Override // com.huawei.cloud.base.http.AbstractC4622y
        /* renamed from: a */
        public void mo28242a(String str, String str2) {
        }

        @Override // com.huawei.cloud.base.http.AbstractC4622y
        /* renamed from: c */
        public AbstractC4623z mo28243c() {
            return new c(this.f50688g, this.f50689h, this.f50690i, this.f50691j);
        }
    }

    /* renamed from: ii.c$c */
    public static class c extends AbstractC4623z {

        /* renamed from: a */
        public InputStream f50692a;

        /* renamed from: b */
        public int f50693b;

        /* renamed from: c */
        public List<String> f50694c;

        /* renamed from: d */
        public List<String> f50695d;

        public c(InputStream inputStream, int i10, List<String> list, List<String> list2) {
            this.f50694c = new ArrayList();
            new ArrayList();
            this.f50692a = inputStream;
            this.f50693b = i10;
            this.f50694c = list;
            this.f50695d = list2;
        }

        @Override // com.huawei.cloud.base.http.AbstractC4623z
        /* renamed from: b */
        public InputStream mo28353b() {
            return this.f50692a;
        }

        @Override // com.huawei.cloud.base.http.AbstractC4623z
        /* renamed from: c */
        public String mo28354c() {
            return null;
        }

        @Override // com.huawei.cloud.base.http.AbstractC4623z
        /* renamed from: d */
        public String mo28355d() {
            return null;
        }

        @Override // com.huawei.cloud.base.http.AbstractC4623z
        /* renamed from: e */
        public int mo28356e() {
            return this.f50694c.size();
        }

        @Override // com.huawei.cloud.base.http.AbstractC4623z
        /* renamed from: f */
        public String mo28357f(int i10) {
            return this.f50694c.get(i10);
        }

        @Override // com.huawei.cloud.base.http.AbstractC4623z
        /* renamed from: g */
        public String mo28358g(int i10) {
            return this.f50695d.get(i10);
        }

        @Override // com.huawei.cloud.base.http.AbstractC4623z
        /* renamed from: h */
        public String mo28359h() {
            return null;
        }

        @Override // com.huawei.cloud.base.http.AbstractC4623z
        /* renamed from: i */
        public int mo28360i() {
            return this.f50693b;
        }

        @Override // com.huawei.cloud.base.http.AbstractC4623z
        /* renamed from: j */
        public String mo28361j() {
            return null;
        }
    }

    /* renamed from: ii.c$d */
    public static class d extends AbstractC4619v {

        /* renamed from: d */
        public int f50696d;

        /* renamed from: e */
        public InputStream f50697e;

        /* renamed from: f */
        public List<String> f50698f;

        /* renamed from: g */
        public List<String> f50699g;

        public d(int i10, InputStream inputStream, List<String> list, List<String> list2) {
            this.f50696d = i10;
            this.f50697e = inputStream;
            this.f50698f = list;
            this.f50699g = list2;
        }

        @Override // com.huawei.cloud.base.http.AbstractC4619v
        public AbstractC4622y buildRequest(String str, String str2) {
            return new b(this.f50697e, this.f50696d, this.f50698f, this.f50699g);
        }
    }

    public C10512c(InputStream inputStream, String str, List<C10511b.b<?, ?>> list, boolean z10) throws IOException {
        this.f50679a = str;
        this.f50680b = list;
        this.f50682d = z10;
        this.f50681c = inputStream;
        m64603a(m64608f());
    }

    /* renamed from: h */
    public static InputStream m64601h(byte[] bArr) {
        int length = bArr.length;
        if (length > 0 && bArr[length - 1] == 10) {
            length--;
        }
        if (length > 0 && bArr[length - 1] == 13) {
            length--;
        }
        return new ByteArrayInputStream(bArr, 0, length);
    }

    /* renamed from: i */
    public static String m64602i(String str) {
        if (str == null) {
            return null;
        }
        return str.endsWith("\r\n") ? str.substring(0, str.length() - 2) : str.endsWith("\n") ? str.substring(0, str.length() - 1) : str;
    }

    /* renamed from: a */
    public final void m64603a(String str) throws IOException {
        if (str.equals(this.f50679a + "--")) {
            this.f50684f = false;
            this.f50681c.close();
        }
    }

    /* renamed from: b */
    public final C4615r m64604b(int i10, InputStream inputStream, List<String> list, List<String> list2) throws IOException {
        C4612o c4612oM28298b = new d(i10, inputStream, list, list2).createRequestFactory().m28298b(C10511b.m64596b(), null);
        c4612oM28298b.m28266G(false);
        return c4612oM28298b.m28272d();
    }

    /* renamed from: c */
    public final <A, T, E> A m64605c(Class<A> cls, C4615r c4615r, C10511b.b<T, E> bVar) throws IOException {
        if (cls == Void.class) {
            return null;
        }
        return (A) bVar.f50678d.m28281m().mo28364a(c4615r.m28306c(), c4615r.m28307d(), cls);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: d */
    public final <T, E> void m64606d(C10511b.b<T, E> bVar, int i10, C4615r c4615r) throws IOException {
        InterfaceC10510a<T, E> interfaceC10510a = bVar.f50675a;
        C4609l c4609lM28308e = c4615r.m28308e();
        InterfaceC4620w interfaceC4620wM28287s = bVar.f50678d.m28287s();
        boolean z10 = false;
        this.f50686h = false;
        if (C4618u.m28333b(i10)) {
            if (interfaceC10510a == 0) {
                return;
            }
            interfaceC10510a.onSuccess(m64605c(bVar.f50676b, c4615r, bVar), c4609lM28308e);
            return;
        }
        InterfaceC4605h interfaceC4605hM28274f = bVar.f50678d.m28274f();
        boolean z11 = this.f50682d && (interfaceC4605hM28274f == null || interfaceC4605hM28274f.mo28153b());
        boolean zMo28334b = interfaceC4620wM28287s != null ? interfaceC4620wM28287s.mo28334b(bVar.f50678d, c4615r, z11) : false;
        if (!zMo28334b && bVar.f50678d.m28289u(c4615r.m28311h(), c4615r.m28308e())) {
            z10 = true;
        }
        if (z11 && (zMo28334b || this.f50686h || z10)) {
            this.f50685g.add(bVar);
        } else {
            if (interfaceC10510a == 0) {
                return;
            }
            interfaceC10510a.onFailure(m64605c(bVar.f50677c, c4615r, bVar), c4609lM28308e);
        }
    }

    /* renamed from: e */
    public void m64607e() throws IOException, NumberFormatException {
        String strM64608f;
        String strM64608f2;
        InputStream aVar;
        String strM64609g;
        this.f50683e++;
        do {
            strM64608f = m64608f();
            if (strM64608f == null) {
                break;
            }
        } while (!strM64608f.equals(""));
        int i10 = Integer.parseInt(m64608f().split(" ")[1]);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        String strM64608f3 = m64608f();
        boolean z10 = (strM64608f3 == null || strM64608f3.equals("")) ? false : true;
        long j10 = -1;
        while (z10) {
            String[] strArrSplit = strM64608f3.split(": ", 2);
            String str = strArrSplit[0];
            String str2 = strArrSplit[1];
            arrayList.add(str);
            arrayList2.add(str2);
            if ("Content-Length".equalsIgnoreCase(str.trim())) {
                j10 = Long.parseLong(str2);
            }
            strM64608f3 = m64608f();
            z10 = (strM64608f3 == null || strM64608f3.equals("")) ? false : true;
        }
        if (j10 == -1) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                strM64609g = m64609g();
                if (strM64609g == null || strM64609g.startsWith(this.f50679a)) {
                    break;
                } else {
                    byteArrayOutputStream.write(strM64609g.getBytes("ISO-8859-1"));
                }
            }
            aVar = m64601h(byteArrayOutputStream.toByteArray());
            strM64608f2 = m64602i(strM64609g);
        } else {
            strM64608f2 = strM64608f3;
            aVar = new a(C4634e.m28407b(this.f50681c, j10));
        }
        m64606d(this.f50680b.get(this.f50683e - 1), i10, m64604b(i10, aVar, arrayList, arrayList2));
        while (true) {
            if (aVar.skip(j10) <= 0 && aVar.read() == -1) {
                break;
            }
        }
        if (j10 != -1) {
            strM64608f2 = m64608f();
        }
        while (strM64608f2 != null && strM64608f2.length() == 0) {
            strM64608f2 = m64608f();
        }
        m64603a(strM64608f2);
    }

    /* renamed from: f */
    public final String m64608f() throws IOException {
        return m64602i(m64609g());
    }

    /* renamed from: g */
    public final String m64609g() throws IOException {
        int i10 = this.f50681c.read();
        if (i10 == -1) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        while (i10 != -1) {
            sb2.append((char) i10);
            if (i10 == 10) {
                break;
            }
            i10 = this.f50681c.read();
        }
        return sb2.toString();
    }
}
