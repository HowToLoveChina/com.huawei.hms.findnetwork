package p508o3;

import java.io.Serializable;
import java.nio.charset.Charset;
import p468m3.C11397c;

/* renamed from: o3.g */
/* loaded from: classes.dex */
public final class C11802g {

    /* renamed from: o3.g$a */
    public static class a implements InterfaceC11801f<CharSequence>, Serializable {

        /* renamed from: a */
        public final Charset f54684a;

        /* renamed from: o3.g$a$a, reason: collision with other inner class name */
        public static class C14510a implements Serializable {
            private static final long serialVersionUID = 0;

            /* renamed from: a */
            public final String f54685a;

            public C14510a(Charset charset) {
                this.f54685a = charset.name();
            }

            private Object readResolve() {
                return C11802g.m70342a(Charset.forName(this.f54685a));
            }
        }

        public a(Charset charset) {
            this.f54684a = (Charset) C11397c.m68310g(charset);
        }

        @Override // p508o3.InterfaceC11801f
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void mo70341i(CharSequence charSequence, InterfaceC11812q interfaceC11812q) {
            interfaceC11812q.mo70311b(charSequence, this.f54684a);
        }

        public boolean equals(Object obj) {
            if (obj instanceof a) {
                return this.f54684a.equals(((a) obj).f54684a);
            }
            return false;
        }

        public int hashCode() {
            return this.f54684a.hashCode() ^ a.class.hashCode();
        }

        public String toString() {
            String strName = this.f54684a.name();
            StringBuilder sb2 = new StringBuilder(String.valueOf(strName).length() + 22);
            sb2.append("Funnels.stringFunnel(");
            sb2.append(strName);
            sb2.append(")");
            return sb2.toString();
        }

        public Object writeReplace() {
            return new C14510a(this.f54684a);
        }
    }

    /* renamed from: a */
    public static InterfaceC11801f<CharSequence> m70342a(Charset charset) {
        return new a(charset);
    }
}
