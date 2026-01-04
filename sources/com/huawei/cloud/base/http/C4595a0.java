package com.huawei.cloud.base.http;

import com.huawei.cloud.base.util.C4627a0;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.UUID;

/* renamed from: com.huawei.cloud.base.http.a0 */
/* loaded from: classes.dex */
public class C4595a0 extends AbstractC4594a {

    /* renamed from: c */
    public ArrayList<a> f21127c;

    /* renamed from: com.huawei.cloud.base.http.a0$a */
    public static final class a {

        /* renamed from: a */
        public InterfaceC4605h f21128a;

        /* renamed from: b */
        public C4609l f21129b;

        /* renamed from: c */
        public InterfaceC4606i f21130c;

        public a() {
            this(null);
        }

        /* renamed from: a */
        public a m28161a(InterfaceC4605h interfaceC4605h) {
            this.f21128a = interfaceC4605h;
            return this;
        }

        /* renamed from: b */
        public a m28162b(C4609l c4609l) {
            this.f21129b = c4609l;
            return this;
        }

        public a(InterfaceC4605h interfaceC4605h) {
            this(null, interfaceC4605h);
        }

        public a(C4609l c4609l, InterfaceC4605h interfaceC4605h) {
            m28162b(c4609l);
            m28161a(interfaceC4605h);
        }
    }

    public C4595a0() {
        super(new C4611n("multipart/related").m28257l("boundary", "__END_OF_PART_" + UUID.randomUUID() + "__"));
        this.f21127c = new ArrayList<>();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v3, types: [com.huawei.cloud.base.http.j] */
    @Override // com.huawei.cloud.base.http.InterfaceC4605h, com.huawei.cloud.base.util.InterfaceC4631c0
    /* renamed from: a */
    public void mo28157a(OutputStream outputStream) throws IOException {
        long length;
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, m28155e());
        String strM28159h = m28159h();
        Iterator<a> it = this.f21127c.iterator();
        while (it.hasNext()) {
            a next = it.next();
            C4609l c4609lM28215F = new C4609l().m28215F(null);
            C4609l c4609l = next.f21129b;
            if (c4609l != null) {
                c4609lM28215F.m28230k(c4609l);
            }
            c4609lM28215F.m28218J(null).m28228T(null).m28221M(null).m28219K(null).set("Content-Transfer-Encoding", null);
            InterfaceC4605h interfaceC4605h = next.f21128a;
            if (interfaceC4605h != null) {
                c4609lM28215F.set("Content-Transfer-Encoding", Arrays.asList("binary"));
                c4609lM28215F.m28221M(interfaceC4605h.getType());
                InterfaceC4606i interfaceC4606i = next.f21130c;
                if (interfaceC4606i == null) {
                    length = interfaceC4605h.getLength();
                } else {
                    c4609lM28215F.m28218J(interfaceC4606i.getName());
                    ?? c4607j = new C4607j(interfaceC4605h, interfaceC4606i);
                    long jM28152d = AbstractC4594a.m28152d(interfaceC4605h);
                    interfaceC4605h = c4607j;
                    length = jM28152d;
                }
                if (length != -1) {
                    c4609lM28215F.m28219K(Long.valueOf(length));
                }
            } else {
                interfaceC4605h = null;
            }
            outputStreamWriter.write("--");
            outputStreamWriter.write(strM28159h);
            outputStreamWriter.write("\r\n");
            C4609l.m28211D(c4609lM28215F, null, null, outputStreamWriter);
            if (interfaceC4605h != null) {
                outputStreamWriter.write("\r\n");
                outputStreamWriter.flush();
                interfaceC4605h.mo28157a(outputStream);
            }
            outputStreamWriter.write("\r\n");
        }
        outputStreamWriter.write("--");
        outputStreamWriter.write(strM28159h);
        outputStreamWriter.write("--");
        outputStreamWriter.write("\r\n");
        outputStreamWriter.flush();
    }

    @Override // com.huawei.cloud.base.http.AbstractC4594a, com.huawei.cloud.base.http.InterfaceC4605h
    /* renamed from: b */
    public boolean mo28153b() {
        Iterator<a> it = this.f21127c.iterator();
        while (it.hasNext()) {
            if (!it.next().f21128a.mo28153b()) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: g */
    public C4595a0 m28158g(a aVar) {
        this.f21127c.add((a) C4627a0.m28391d(aVar));
        return this;
    }

    /* renamed from: h */
    public final String m28159h() {
        return m28156f().m28252e("boundary");
    }

    /* renamed from: i */
    public C4595a0 m28160i(Collection<? extends InterfaceC4605h> collection) {
        this.f21127c = new ArrayList<>(collection.size());
        Iterator<? extends InterfaceC4605h> it = collection.iterator();
        while (it.hasNext()) {
            m28158g(new a(it.next()));
        }
        return this;
    }
}
