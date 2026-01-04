package com.huawei.cloud.base.http;

import com.huawei.cloud.base.util.C4627a0;
import com.huawei.cloud.base.util.C4637f0;
import com.huawei.cloud.base.util.C4642j;
import com.huawei.cloud.base.util.C4645m;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Iterator;
import java.util.Map;
import p656ti.C13014a;

/* renamed from: com.huawei.cloud.base.http.c0 */
/* loaded from: classes.dex */
public class C4599c0 extends AbstractC4594a {

    /* renamed from: c */
    public Object f21151c;

    public C4599c0(Object obj) {
        super(C4601d0.f21152a);
        m28181h(obj);
    }

    /* renamed from: g */
    public static boolean m28180g(boolean z10, Writer writer, String str, Object obj) throws IOException {
        if (obj != null && !C4642j.m28441d(obj)) {
            if (z10) {
                z10 = false;
            } else {
                writer.write("&");
            }
            writer.write(str);
            String strM78324b = C13014a.m78324b(obj instanceof Enum ? C4645m.m28461j((Enum) obj).m28467e() : obj.toString());
            if (strM78324b.length() != 0) {
                writer.write("=");
                writer.write(strM78324b);
            }
        }
        return z10;
    }

    @Override // com.huawei.cloud.base.http.InterfaceC4605h, com.huawei.cloud.base.util.InterfaceC4631c0
    /* renamed from: a */
    public void mo28157a(OutputStream outputStream) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, m28155e()));
        boolean zM28180g = true;
        for (Map.Entry<String, Object> entry : C4642j.m28444g(this.f21151c).entrySet()) {
            Object value = entry.getValue();
            if (value != null) {
                String strM78324b = C13014a.m78324b(entry.getKey());
                Class<?> cls = value.getClass();
                if ((value instanceof Iterable) || cls.isArray()) {
                    Iterator it = C4637f0.m28423l(value).iterator();
                    while (it.hasNext()) {
                        zM28180g = m28180g(zM28180g, bufferedWriter, strM78324b, it.next());
                    }
                } else {
                    zM28180g = m28180g(zM28180g, bufferedWriter, strM78324b, value);
                }
            }
        }
        bufferedWriter.flush();
    }

    /* renamed from: h */
    public C4599c0 m28181h(Object obj) {
        this.f21151c = C4627a0.m28391d(obj);
        return this;
    }
}
