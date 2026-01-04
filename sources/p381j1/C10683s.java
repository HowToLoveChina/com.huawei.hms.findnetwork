package p381j1;

import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.sql.Clob;
import java.sql.SQLException;
import p244e1.C9380d;

/* renamed from: j1.s */
/* loaded from: classes.dex */
public class C10683s implements InterfaceC10686t0 {

    /* renamed from: a */
    public static final C10683s f51322a = new C10683s();

    @Override // p381j1.InterfaceC10686t0
    /* renamed from: e */
    public void mo63933e(C10664i0 c10664i0, Object obj, Object obj2, Type type, int i10) throws SQLException, IOException {
        try {
            if (obj == null) {
                c10664i0.m65264I();
                return;
            }
            Reader characterStream = ((Clob) obj).getCharacterStream();
            StringBuilder sb2 = new StringBuilder();
            try {
                char[] cArr = new char[2048];
                while (true) {
                    int i11 = characterStream.read(cArr, 0, 2048);
                    if (i11 < 0) {
                        String string = sb2.toString();
                        characterStream.close();
                        c10664i0.m65263H(string);
                        return;
                    }
                    sb2.append(cArr, 0, i11);
                }
            } catch (Exception e10) {
                throw new C9380d("read string from reader error", e10);
            }
        } catch (SQLException e11) {
            throw new IOException("write clob error", e11);
        }
    }
}
