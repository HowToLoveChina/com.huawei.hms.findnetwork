package p357i4;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import p308g4.C9878b;
import p405jt.AbstractC10915a;

/* renamed from: i4.b */
/* loaded from: classes.dex */
public abstract class AbstractC10437b {

    /* renamed from: a */
    public final AbstractC10436a f50384a;

    /* renamed from: b */
    public final List<InterfaceC10441f> f50385b = new ArrayList(4);

    /* renamed from: c */
    public final List<InterfaceC10441f> f50386c = new ArrayList(4);

    public AbstractC10437b(AbstractC10436a abstractC10436a) {
        this.f50384a = abstractC10436a;
    }

    /* renamed from: a */
    public final String m64188a(String[] strArr, String[] strArr2) {
        StringBuilder sb2 = new StringBuilder();
        List arrayList = new ArrayList(4);
        if (strArr2 != null) {
            arrayList = Arrays.asList(strArr2);
        }
        if (strArr == null || strArr.length <= 0 || strArr2 == null) {
            return null;
        }
        for (int i10 = 0; i10 < strArr.length; i10++) {
            String str = strArr[i10];
            if (!arrayList.contains(str)) {
                str = "\"\"";
            }
            sb2.append(str);
            if (i10 != strArr.length - 1) {
                sb2.append(",");
            }
        }
        return sb2.toString();
    }

    /* renamed from: b */
    public void m64189b() {
        for (InterfaceC10441f interfaceC10441f : this.f50386c) {
            this.f50384a.m64169A(interfaceC10441f.mo64206d(), interfaceC10441f.mo12455i(), interfaceC10441f.mo64207g());
        }
    }

    /* renamed from: c */
    public final void m64190c(String str) throws C9878b {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(" INSERT INTO ");
        sb2.append(str);
        sb2.append(" SELECT ");
        try {
            try {
                String strM64188a = m64188a(this.f50384a.m64187z(str), this.f50384a.m64187z("_temp_" + str));
                if (strM64188a == null) {
                    throw new C9878b("insert data sql is null");
                }
                sb2.append(strM64188a);
                sb2.append(" FROM ");
                sb2.append("_temp_");
                sb2.append(str);
                try {
                    this.f50384a.m64172D(sb2.toString());
                } catch (C9878b unused) {
                    throw new C9878b(mo56986h() + " insertData mDbHelper.executeSQL error");
                }
            } catch (C9878b unused2) {
                throw new C9878b(String.format(Locale.ENGLISH, "get temp table %s column names failed", str.trim()));
            }
        } catch (C9878b unused3) {
            throw new C9878b(String.format(Locale.ENGLISH, "get table %s column names failed", str.trim()));
        }
    }

    /* renamed from: d */
    public void m64191d() {
        Iterator<InterfaceC10441f> it = this.f50385b.iterator();
        while (it.hasNext()) {
            String strMo64206d = it.next().mo64206d();
            try {
                if (this.f50384a.m64171C(strMo64206d)) {
                    this.f50384a.m64183v(strMo64206d);
                }
            } catch (C9878b unused) {
                AbstractC10915a.m65978j(mo56986h(), "delete table fail");
            }
        }
        for (InterfaceC10441f interfaceC10441f : this.f50386c) {
            try {
                this.f50384a.m64172D(interfaceC10441f.mo64205c());
            } catch (C9878b unused2) {
                AbstractC10915a.m65979k(mo56986h(), "create table %s failed", interfaceC10441f.mo64206d());
            }
        }
    }

    /* renamed from: e */
    public boolean m64192e(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String strReplaceAll = str.replaceAll("_temp_", "");
        Iterator<InterfaceC10441f> it = this.f50386c.iterator();
        while (it.hasNext()) {
            if (strReplaceAll.equals(it.next().mo64206d())) {
                return true;
            }
        }
        Iterator<InterfaceC10441f> it2 = this.f50385b.iterator();
        while (it2.hasNext()) {
            if (strReplaceAll.equals(it2.next().mo64206d())) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: f */
    public void m64193f() throws C9878b {
        for (InterfaceC10441f interfaceC10441f : this.f50386c) {
            String strMo64206d = interfaceC10441f.mo64206d();
            if (this.f50384a.m64171C(strMo64206d)) {
                this.f50384a.m64174F(strMo64206d);
                AbstractC10915a.m65973e(mo56986h(), "%s exist modify table successfully.", strMo64206d);
                try {
                    this.f50384a.m64172D(interfaceC10441f.mo64205c());
                    m64190c(strMo64206d);
                    AbstractC10915a.m65973e(mo56986h(), "insert data to %s successfully.", strMo64206d);
                    this.f50384a.m64185x(strMo64206d);
                    AbstractC10915a.m65972d(mo56986h(), "drop table temp table successfully.");
                } catch (C9878b unused) {
                    throw new C9878b(String.format(Locale.ENGLISH, "table exist, init table tableName: %s failed", strMo64206d.trim()));
                }
            } else {
                try {
                    this.f50384a.m64172D(interfaceC10441f.mo64205c());
                } catch (C9878b unused2) {
                    throw new C9878b(String.format(Locale.ENGLISH, "table is not exist, init table tableName: %s failed", strMo64206d.trim()));
                }
            }
        }
    }

    /* renamed from: g */
    public void m64194g() {
    }

    /* renamed from: h */
    public abstract String mo56986h();
}
