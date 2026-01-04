package p855zt;

/* renamed from: zt.a */
/* loaded from: classes5.dex */
public class C14378a {
    /* renamed from: a */
    public static String m85597a(String str, int i10, int i11) {
        int length;
        if (str == null || str.length() <= 0) {
            return "";
        }
        if (i10 < 0) {
            i10 = 0;
        }
        if (i11 < 0) {
            i11 = 0;
        }
        if (str.length() <= i10 + i11) {
            length = str.length() - 1;
            i10 = 1;
        } else {
            length = str.length() - i11;
        }
        String[] strArrM85602e = C14379b.m85602e(str, i10, length);
        return C14379b.m85599b("", C14379b.m85600c(strArrM85602e, 0), C14379b.m85598a(C14379b.m85600c(strArrM85602e, 1), '*'), C14379b.m85600c(strArrM85602e, 2));
    }
}
