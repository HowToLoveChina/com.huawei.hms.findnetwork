package p523oi;

import com.huawei.cloud.base.util.C4636f;
import com.huawei.hms.drive.C5194b;
import com.huawei.hms.drive.C5250d;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;
import java.nio.charset.Charset;
import ni.AbstractC11708c;
import ni.AbstractC11709d;
import ni.AbstractC11710e;

/* renamed from: oi.a */
/* loaded from: classes.dex */
public class C11903a extends AbstractC11708c {

    /* renamed from: oi.a$a */
    public static class a {

        /* renamed from: a */
        public static final C11903a f55136a = new C11903a();
    }

    /* renamed from: l */
    public static C11903a m71435l() {
        return a.f55136a;
    }

    @Override // ni.AbstractC11708c
    /* renamed from: a */
    public AbstractC11709d mo69828a(OutputStream outputStream, Charset charset) {
        return m71436j(new OutputStreamWriter(outputStream, charset));
    }

    @Override // ni.AbstractC11708c
    /* renamed from: c */
    public AbstractC11710e mo69830c(InputStream inputStream, Charset charset) {
        return charset == null ? m71437k(inputStream) : mo69831d(new InputStreamReader(inputStream, charset));
    }

    @Override // ni.AbstractC11708c
    /* renamed from: d */
    public AbstractC11710e mo69831d(Reader reader) {
        return new C11905c(this, new C5194b(reader));
    }

    @Override // ni.AbstractC11708c
    /* renamed from: e */
    public AbstractC11710e mo69832e(String str) {
        return mo69831d(new StringReader(str));
    }

    /* renamed from: j */
    public AbstractC11709d m71436j(Writer writer) {
        return new C11904b(this, new C5250d(writer));
    }

    /* renamed from: k */
    public AbstractC11710e m71437k(InputStream inputStream) {
        return mo69831d(new InputStreamReader(inputStream, C4636f.f21271a));
    }
}
