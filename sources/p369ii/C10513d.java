package p369ii;

import com.huawei.cloud.base.http.AbstractC4594a;
import com.huawei.cloud.base.http.C4609l;
import com.huawei.cloud.base.http.C4612o;
import com.huawei.cloud.base.http.InterfaceC4605h;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/* renamed from: ii.d */
/* loaded from: classes.dex */
public class C10513d extends AbstractC4594a {

    /* renamed from: c */
    public final C4612o f50700c;

    public C10513d(C4612o c4612o) {
        super("application/http");
        this.f50700c = c4612o;
    }

    @Override // com.huawei.cloud.base.http.InterfaceC4605h, com.huawei.cloud.base.util.InterfaceC4631c0
    /* renamed from: a */
    public void mo28157a(OutputStream outputStream) throws IOException {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, m28155e());
        outputStreamWriter.write(this.f50700c.m28282n());
        outputStreamWriter.write(" ");
        outputStreamWriter.write(this.f50700c.m28288t().m28198p());
        outputStreamWriter.write(" ");
        outputStreamWriter.write("HTTP/1.1");
        outputStreamWriter.write("\r\n");
        C4609l c4609l = new C4609l();
        c4609l.m28230k(this.f50700c.m28277i());
        c4609l.m28215F(null).m28228T(null).m28218J(null).m28221M(null).m28219K(null);
        InterfaceC4605h interfaceC4605hM28274f = this.f50700c.m28274f();
        if (interfaceC4605hM28274f != null) {
            c4609l.m28221M(interfaceC4605hM28274f.getType());
            long length = interfaceC4605hM28274f.getLength();
            if (length != -1) {
                c4609l.m28219K(Long.valueOf(length));
            }
        }
        C4609l.m28211D(c4609l, null, null, outputStreamWriter);
        outputStreamWriter.write("\r\n");
        outputStreamWriter.flush();
        if (interfaceC4605hM28274f != null) {
            interfaceC4605hM28274f.mo28157a(outputStream);
        }
    }
}
