package im;

import android.text.TextUtils;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import fk.C9721b;
import p292fn.C9731d;
import p514o9.C11839m;
import p618rm.C12590s0;
import p848zl.C14337f;

/* renamed from: im.a */
/* loaded from: classes6.dex */
public class C10546a {

    /* renamed from: a */
    public a f50724a;

    /* renamed from: im.a$a */
    public interface a {
        /* renamed from: a */
        InterfaceC10551c0 mo1696a() throws C9721b;
    }

    public C10546a(a aVar) {
        this.f50724a = aVar;
    }

    /* renamed from: a */
    public static C10546a m64704a(a aVar) {
        return new C10546a(aVar);
    }

    /* renamed from: b */
    public void m64705b() throws C9721b {
        int i10 = 0;
        String strM64859R = null;
        InterfaceC10551c0 interfaceC10551c0 = null;
        InterfaceC10551c0 interfaceC10551c02 = null;
        byte b10 = 0;
        while (true) {
            try {
                a aVar = this.f50724a;
                if (aVar == null) {
                    throw new C9721b(1999, "upDownBuilder is empty");
                }
                InterfaceC10551c0 interfaceC10551c0Mo1696a = aVar.mo1696a();
                if (interfaceC10551c0Mo1696a == null) {
                    throw new C9721b(1999, "upDownBuilder.getExecute is empty");
                }
                interfaceC10551c0Mo1696a.mo64725c(i10);
                if (interfaceC10551c0Mo1696a instanceof AbstractC10571u) {
                    ((AbstractC10571u) interfaceC10551c0Mo1696a).m64874h0(m64707d(strM64859R, i10));
                }
                interfaceC10551c0Mo1696a.execute();
                return;
            } catch (C9721b e10) {
                if ((b10 == true ? 1 : 0) instanceof AbstractC10571u) {
                    strM64859R = ((AbstractC10571u) null).m64859R();
                }
                if (0 == 0) {
                    throw new C9721b(1999, "catch upDownBuilder.getExecute is empty");
                }
                C11839m.m70687e("CloudBackupFileUpDownBuilder", interfaceC10551c02.mo64723a() + " " + e10.toString());
                if (interfaceC10551c0.mo64724b()) {
                    throw e10;
                }
                if (i10 > 1 || C14337f.m85500c().contains(Integer.valueOf(e10.m60659c()))) {
                    throw e10;
                }
                i10++;
            } catch (Exception e11) {
                throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "execute error: " + e11.getMessage() + " stack: " + C12590s0.m75731C0(e11));
            }
        }
        throw e10;
    }

    /* renamed from: c */
    public final boolean m64706c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        C11839m.m70686d("CloudBackupFileUpDownBuilder", "downloadErrorCode = " + str);
        return "113_3929".equals(str) || "102_1011".equals(str);
    }

    /* renamed from: d */
    public final boolean m64707d(String str, int i10) {
        return C9731d.m60699d().m60703e("cloudBackupGlobalFileReuse") && i10 > 0 && m64706c(str);
    }
}
