package com.google.crypto.tink.shaded.protobuf;

/* renamed from: com.google.crypto.tink.shaded.protobuf.m1 */
/* loaded from: classes.dex */
public final class C1934m1 {

    /* renamed from: com.google.crypto.tink.shaded.protobuf.m1$a */
    public class a implements b {

        /* renamed from: a */
        public final /* synthetic */ AbstractC1920i f9228a;

        public a(AbstractC1920i abstractC1920i) {
            this.f9228a = abstractC1920i;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.C1934m1.b
        /* renamed from: a */
        public byte mo12036a(int i10) {
            return this.f9228a.mo11689c(i10);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.C1934m1.b
        public int size() {
            return this.f9228a.size();
        }
    }

    /* renamed from: com.google.crypto.tink.shaded.protobuf.m1$b */
    public interface b {
        /* renamed from: a */
        byte mo12036a(int i10);

        int size();
    }

    /* renamed from: a */
    public static String m12033a(AbstractC1920i abstractC1920i) {
        return m12034b(new a(abstractC1920i));
    }

    /* renamed from: b */
    public static String m12034b(b bVar) {
        StringBuilder sb2 = new StringBuilder(bVar.size());
        for (int i10 = 0; i10 < bVar.size(); i10++) {
            byte bMo12036a = bVar.mo12036a(i10);
            if (bMo12036a == 34) {
                sb2.append("\\\"");
            } else if (bMo12036a == 39) {
                sb2.append("\\'");
            } else if (bMo12036a != 92) {
                switch (bMo12036a) {
                    case 7:
                        sb2.append("\\a");
                        break;
                    case 8:
                        sb2.append("\\b");
                        break;
                    case 9:
                        sb2.append("\\t");
                        break;
                    case 10:
                        sb2.append("\\n");
                        break;
                    case 11:
                        sb2.append("\\v");
                        break;
                    case 12:
                        sb2.append("\\f");
                        break;
                    case 13:
                        sb2.append("\\r");
                        break;
                    default:
                        if (bMo12036a < 32 || bMo12036a > 126) {
                            sb2.append('\\');
                            sb2.append((char) (((bMo12036a >>> 6) & 3) + 48));
                            sb2.append((char) (((bMo12036a >>> 3) & 7) + 48));
                            sb2.append((char) ((bMo12036a & 7) + 48));
                            break;
                        } else {
                            sb2.append((char) bMo12036a);
                            break;
                        }
                }
            } else {
                sb2.append("\\\\");
            }
        }
        return sb2.toString();
    }

    /* renamed from: c */
    public static String m12035c(String str) {
        return m12033a(AbstractC1920i.m11684h(str));
    }
}
