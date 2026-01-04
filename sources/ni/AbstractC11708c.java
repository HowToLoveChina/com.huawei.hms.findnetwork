package ni;

import com.huawei.cloud.base.json.C4625a;
import com.huawei.cloud.base.util.C4636f;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.nio.charset.Charset;

/* renamed from: ni.c */
/* loaded from: classes.dex */
public abstract class AbstractC11708c {
    /* renamed from: a */
    public abstract AbstractC11709d mo69828a(OutputStream outputStream, Charset charset) throws IOException;

    /* renamed from: b */
    public final C4625a m69829b() {
        return new C4625a(this);
    }

    /* renamed from: c */
    public abstract AbstractC11710e mo69830c(InputStream inputStream, Charset charset) throws IOException;

    /* renamed from: d */
    public abstract AbstractC11710e mo69831d(Reader reader) throws IOException;

    /* renamed from: e */
    public abstract AbstractC11710e mo69832e(String str) throws IOException;

    /* renamed from: f */
    public final ByteArrayOutputStream m69833f(Object obj, boolean z10) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        AbstractC11709d abstractC11709dMo69828a = mo69828a(byteArrayOutputStream, C4636f.f21271a);
        if (z10) {
            abstractC11709dMo69828a.mo69837a();
        }
        abstractC11709dMo69828a.m69839c(obj);
        abstractC11709dMo69828a.mo69838b();
        return byteArrayOutputStream;
    }

    /* renamed from: g */
    public final String m69834g(Object obj) throws IOException {
        return m69836i(obj, true);
    }

    /* renamed from: h */
    public final String m69835h(Object obj) throws IOException {
        return m69836i(obj, false);
    }

    /* renamed from: i */
    public final String m69836i(Object obj, boolean z10) throws IOException {
        return m69833f(obj, z10).toString(Constants.UTF_8);
    }
}
