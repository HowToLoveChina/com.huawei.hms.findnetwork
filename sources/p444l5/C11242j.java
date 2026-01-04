package p444l5;

import android.content.ContentValues;
import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.android.backup.service.utils.C2157a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import p444l5.C11241i;
import p699v4.C13342k;

/* renamed from: l5.j */
/* loaded from: classes.dex */
public class C11242j {

    /* renamed from: i */
    public static final String[] f52799i = {"TEL;X-", "TEL;HOME:", "TEL;CELL:", "TEL;WORK:", "TEL;WORK;FAX:", "TEL;HOME;FAX:", "TEL;PAGER:", "TEL;OTHER:", "TEL;CALLBACK:", "TEL;CAR:", "TEL;COMPANY-MAIN:", "TEL;ISDN:", "TEL;PREF:", "TEL;OTHER-FAX:", "TEL;RADIO:", "TEL;TLX:", "TEL;TTY-TDD:", "TEL;WORK;CELL:", "TEL;WORK;PAGER:", "TEL;ASSISTANT:", "TEL;MSG:"};

    /* renamed from: j */
    public static final String[] f52800j = {"EMAIL;X-", "EMAIL;HOME:", "EMAIL;WORK:", "EMAIL:", "EMAIL;CELL:"};

    /* renamed from: a */
    public String f52801a = "";

    /* renamed from: b */
    public String f52802b = "";

    /* renamed from: c */
    public String f52803c = "";

    /* renamed from: d */
    public String f52804d = "";

    /* renamed from: e */
    public String f52805e = "";

    /* renamed from: f */
    public List<String> f52806f = new ArrayList();

    /* renamed from: g */
    public List<String> f52807g = new ArrayList();

    /* renamed from: h */
    public List<String> f52808h = new ArrayList();

    /* renamed from: a */
    public static void m67553a(StringBuffer stringBuffer, String str, String str2) {
        if (C2157a.m13170E(str2)) {
            return;
        }
        stringBuffer.append(str);
        stringBuffer.append(str2);
        stringBuffer.append("\r\n");
    }

    /* renamed from: b */
    public static String m67554b(List<String> list) {
        Collections.sort(list);
        StringBuilder sb2 = new StringBuilder();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            sb2.append(it.next());
        }
        return sb2.toString();
    }

    /* renamed from: c */
    public static String m67555c(C11242j c11242j) {
        StringBuffer stringBuffer = new StringBuffer();
        if (c11242j == null) {
            C2111d.m12648d("ContactInfoForVCard", "formatVCard : vcardInfo is null");
            return stringBuffer.toString();
        }
        m67553a(stringBuffer, "ORG:", c11242j.f52801a);
        m67553a(stringBuffer, "TITLE:", c11242j.f52802b);
        m67553a(stringBuffer, "NAME:", c11242j.f52803c);
        m67553a(stringBuffer, "NICK:", c11242j.f52804d);
        m67553a(stringBuffer, "GROUP:", c11242j.f52805e);
        stringBuffer.append(m67554b(c11242j.f52806f));
        stringBuffer.append(m67554b(c11242j.f52807g));
        stringBuffer.append(m67554b(c11242j.f52808h));
        return stringBuffer.toString();
    }

    /* renamed from: d */
    public static String m67556d(String str) {
        return str.replace(" ", "").replace("-", "");
    }

    /* renamed from: e */
    public final boolean m67557e(ContentValues contentValues) {
        return (contentValues.get("mimetype") == null || C11241i.b.m67549b().get(contentValues.get("mimetype")) == null) ? false : true;
    }

    /* renamed from: f */
    public final void m67558f(String str, int i10, String str2) {
        String str3;
        String[] strArr = f52800j;
        if (i10 >= strArr.length || i10 < 0) {
            return;
        }
        if (i10 == 0) {
            str3 = strArr[i10] + str2 + ":" + str + "\r\n";
        } else if (i10 <= 4) {
            str3 = strArr[i10] + str + "\r\n";
        } else {
            C2111d.m12657m("ContactInfoForVCard", "setEmailValues type is invalid.");
            str3 = null;
        }
        this.f52807g.add(str3);
    }

    /* renamed from: g */
    public final void m67559g(String str, int i10, String str2) {
        String str3;
        String[] strArr = f52799i;
        if (i10 >= strArr.length || i10 < 0) {
            return;
        }
        String strM67556d = m67556d(str);
        if (i10 == 0) {
            str3 = strArr[0] + str2 + ":" + strM67556d + "\r\n";
        } else if (i10 <= 20) {
            str3 = strArr[i10] + strM67556d + "\r\n";
        } else {
            C2111d.m12657m("ContactInfoForVCard", "setPhoneValues type is invalid.");
            str3 = null;
        }
        this.f52806f.add(str3);
    }

    /* renamed from: h */
    public void m67560h(ContentValues contentValues) {
        if (contentValues == null) {
            C2111d.m12648d("ContactInfoForVCard", "setVCard : dataContent is null");
            return;
        }
        if (m67557e(contentValues)) {
            int iIntValue = C11241i.b.m67549b().get(contentValues.get("mimetype")).intValue();
            if (iIntValue == 1) {
                m67561i(contentValues);
                return;
            }
            if (iIntValue == 2) {
                m67566n(contentValues);
                return;
            }
            if (iIntValue == 3) {
                m67562j(contentValues);
                return;
            }
            if (iIntValue == 5) {
                m67565m(contentValues);
                return;
            }
            if (iIntValue == 7) {
                m67564l(contentValues);
            } else if (iIntValue == 10) {
                m67563k(contentValues);
            } else {
                if (iIntValue != 11) {
                    return;
                }
                m67567o(contentValues);
            }
        }
    }

    /* renamed from: i */
    public final void m67561i(ContentValues contentValues) {
        this.f52803c = contentValues.get("data1") == null ? "" : contentValues.get("data1").toString();
    }

    /* renamed from: j */
    public final void m67562j(ContentValues contentValues) {
        try {
            if (contentValues.get("data2") == null || contentValues.get("data1") == null) {
                return;
            }
            m67558f(contentValues.get("data1").toString(), C13342k.m80055d(contentValues.get("data2").toString()), contentValues.get("data3") != null ? contentValues.get("data3").toString() : null);
        } catch (NumberFormatException unused) {
            C2111d.m12648d("ContactInfoForVCard", "setVCardEmail NumberFormatException");
        }
    }

    /* renamed from: k */
    public final void m67563k(ContentValues contentValues) {
        this.f52805e = contentValues.get("data1") == null ? "" : contentValues.get("data1").toString();
    }

    /* renamed from: l */
    public final void m67564l(ContentValues contentValues) {
        this.f52804d = contentValues.get("data1") == null ? "" : contentValues.get("data1").toString();
    }

    /* renamed from: m */
    public final void m67565m(ContentValues contentValues) {
        this.f52801a = contentValues.get("data1") == null ? "" : contentValues.get("data1").toString();
        this.f52802b = contentValues.get("data4") != null ? contentValues.get("data4").toString() : "";
    }

    /* renamed from: n */
    public final void m67566n(ContentValues contentValues) {
        if (contentValues.get("data2") == null || contentValues.get("data1") == null) {
            return;
        }
        m67559g(contentValues.get("data1").toString(), C13342k.m80055d(contentValues.get("data2").toString()), contentValues.get("data3") != null ? contentValues.get("data3").toString() : null);
    }

    /* renamed from: o */
    public final void m67567o(ContentValues contentValues) {
        if (contentValues.get("data1") != null) {
            this.f52808h.add("URL:" + contentValues.get("data1").toString() + "\r\n");
        }
    }
}
