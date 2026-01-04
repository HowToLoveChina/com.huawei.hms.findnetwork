package p381j1;

import java.io.IOException;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import p323h1.C10077a;
import p323h1.InterfaceC10079c;
import p354i1.AbstractC10393e;
import p354i1.InterfaceC10408t;
import p481n1.C11595g;

/* renamed from: j1.p */
/* loaded from: classes.dex */
public class C10677p extends AbstractC10393e implements InterfaceC10686t0, InterfaceC10408t, InterfaceC10687u {

    /* renamed from: b */
    public static final C10677p f51313b = new C10677p();

    /* renamed from: a */
    public DatatypeFactory f51314a;

    @Override // p354i1.AbstractC10393e, p354i1.InterfaceC10408t
    /* renamed from: b */
    public <T> T mo63891b(C10077a c10077a, Type type, Object obj) {
        return (T) mo63893f(c10077a, type, obj, null, 0);
    }

    @Override // p354i1.InterfaceC10408t
    /* renamed from: c */
    public int mo63892c() {
        return 2;
    }

    @Override // p381j1.InterfaceC10687u
    /* renamed from: d */
    public void mo63932d(C10664i0 c10664i0, Object obj, C10665j c10665j) throws IOException {
        C10650d1 c10650d1 = c10664i0.f51258k;
        String strM65280b = c10665j.m65280b();
        Calendar calendar = (Calendar) obj;
        if (strM65280b.equals("unixtime")) {
            c10650d1.m65219X((int) (calendar.getTimeInMillis() / 1000));
            return;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(strM65280b);
        simpleDateFormat.setTimeZone(c10664i0.f51266s);
        c10650d1.m65228g0(simpleDateFormat.format(calendar.getTime()));
    }

    @Override // p381j1.InterfaceC10686t0
    /* renamed from: e */
    public void mo63933e(C10664i0 c10664i0, Object obj, Object obj2, Type type, int i10) throws IOException {
        char[] charArray;
        C10650d1 c10650d1 = c10664i0.f51258k;
        if (obj == null) {
            c10650d1.m65222a0();
            return;
        }
        Calendar gregorianCalendar = obj instanceof XMLGregorianCalendar ? ((XMLGregorianCalendar) obj).toGregorianCalendar() : (Calendar) obj;
        if (!c10650d1.m65237w(EnumC10653e1.UseISO8601DateFormat)) {
            c10664i0.m65262G(gregorianCalendar.getTime());
            return;
        }
        char c10 = c10650d1.m65237w(EnumC10653e1.UseSingleQuotes) ? '\'' : '\"';
        c10650d1.append(c10);
        int i11 = gregorianCalendar.get(1);
        int i12 = gregorianCalendar.get(2) + 1;
        int i13 = gregorianCalendar.get(5);
        int i14 = gregorianCalendar.get(11);
        int i15 = gregorianCalendar.get(12);
        int i16 = gregorianCalendar.get(13);
        int i17 = gregorianCalendar.get(14);
        if (i17 != 0) {
            charArray = "0000-00-00T00:00:00.000".toCharArray();
            C11595g.m69211f(i17, 23, charArray);
            C11595g.m69211f(i16, 19, charArray);
            C11595g.m69211f(i15, 16, charArray);
            C11595g.m69211f(i14, 13, charArray);
            C11595g.m69211f(i13, 10, charArray);
            C11595g.m69211f(i12, 7, charArray);
            C11595g.m69211f(i11, 4, charArray);
        } else if (i16 == 0 && i15 == 0 && i14 == 0) {
            charArray = "0000-00-00".toCharArray();
            C11595g.m69211f(i13, 10, charArray);
            C11595g.m69211f(i12, 7, charArray);
            C11595g.m69211f(i11, 4, charArray);
        } else {
            charArray = "0000-00-00T00:00:00".toCharArray();
            C11595g.m69211f(i16, 19, charArray);
            C11595g.m69211f(i15, 16, charArray);
            C11595g.m69211f(i14, 13, charArray);
            C11595g.m69211f(i13, 10, charArray);
            C11595g.m69211f(i12, 7, charArray);
            C11595g.m69211f(i11, 4, charArray);
        }
        c10650d1.write(charArray);
        float offset = gregorianCalendar.getTimeZone().getOffset(gregorianCalendar.getTimeInMillis()) / 3600000.0f;
        int i18 = (int) offset;
        if (i18 == 0.0d) {
            c10650d1.write(90);
        } else {
            if (i18 > 9) {
                c10650d1.write(43);
                c10650d1.m65219X(i18);
            } else if (i18 > 0) {
                c10650d1.write(43);
                c10650d1.write(48);
                c10650d1.m65219X(i18);
            } else if (i18 < -9) {
                c10650d1.write(45);
                c10650d1.m65219X(i18);
            } else if (i18 < 0) {
                c10650d1.write(45);
                c10650d1.write(48);
                c10650d1.m65219X(-i18);
            }
            c10650d1.write(58);
            c10650d1.append(String.format("%02d", Integer.valueOf((int) ((offset - i18) * 60.0f))));
        }
        c10650d1.append(c10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v3, types: [T, java.util.Calendar] */
    @Override // p354i1.AbstractC10393e
    /* renamed from: f */
    public <T> T mo63893f(C10077a c10077a, Type type, Object obj, String str, int i10) {
        T t10 = (T) C10691w.f51326a.mo63893f(c10077a, type, obj, str, i10);
        if (t10 instanceof Calendar) {
            return t10;
        }
        Date date = (Date) t10;
        if (date == null) {
            return null;
        }
        InterfaceC10079c interfaceC10079c = c10077a.f49153f;
        ?? r72 = (T) Calendar.getInstance(interfaceC10079c.mo62764V(), interfaceC10079c.mo62791z0());
        r72.setTime(date);
        return type == XMLGregorianCalendar.class ? (T) m65309g((GregorianCalendar) r72) : r72;
    }

    /* renamed from: g */
    public XMLGregorianCalendar m65309g(Calendar calendar) {
        if (this.f51314a == null) {
            try {
                this.f51314a = DatatypeFactory.newInstance();
            } catch (DatatypeConfigurationException e10) {
                throw new IllegalStateException("Could not obtain an instance of DatatypeFactory.", e10);
            }
        }
        return this.f51314a.newXMLGregorianCalendar((GregorianCalendar) calendar);
    }
}
