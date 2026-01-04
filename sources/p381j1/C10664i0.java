package p381j1;

import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.TimeZone;
import java.util.zip.GZIPOutputStream;
import p244e1.AbstractC9377a;
import p244e1.C9380d;
import p481n1.C11595g;

/* renamed from: j1.i0 */
/* loaded from: classes.dex */
public class C10664i0 extends AbstractC10647c1 {

    /* renamed from: j */
    public final C10641a1 f51257j;

    /* renamed from: k */
    public final C10650d1 f51258k;

    /* renamed from: l */
    public int f51259l;

    /* renamed from: m */
    public String f51260m;

    /* renamed from: n */
    public String f51261n;

    /* renamed from: o */
    public DateFormat f51262o;

    /* renamed from: p */
    public String f51263p;

    /* renamed from: q */
    public IdentityHashMap<Object, C10696y0> f51264q;

    /* renamed from: r */
    public C10696y0 f51265r;

    /* renamed from: s */
    public TimeZone f51266s;

    /* renamed from: t */
    public Locale f51267t;

    public C10664i0() {
        this(new C10650d1(), C10641a1.m65181g());
    }

    /* renamed from: A */
    public boolean m65256A(EnumC10653e1 enumC10653e1) {
        return this.f51258k.m65237w(enumC10653e1);
    }

    /* renamed from: B */
    public final boolean m65257B(Type type, Object obj) {
        C10696y0 c10696y0;
        return this.f51258k.m65237w(EnumC10653e1.WriteClassName) && !(type == null && this.f51258k.m65237w(EnumC10653e1.NotWriteRootClassName) && ((c10696y0 = this.f51265r) == null || c10696y0.f51332a == null));
    }

    /* renamed from: C */
    public void m65258C() {
        this.f51258k.write(10);
        for (int i10 = 0; i10 < this.f51259l; i10++) {
            this.f51258k.write(this.f51260m);
        }
    }

    /* renamed from: D */
    public void m65259D(C10696y0 c10696y0, Object obj, Object obj2, int i10) {
        m65260E(c10696y0, obj, obj2, i10, 0);
    }

    /* renamed from: E */
    public void m65260E(C10696y0 c10696y0, Object obj, Object obj2, int i10, int i11) {
        if (this.f51258k.f51202h) {
            return;
        }
        this.f51265r = new C10696y0(c10696y0, obj, obj2, i10, i11);
        if (this.f51264q == null) {
            this.f51264q = new IdentityHashMap<>();
        }
        this.f51264q.put(obj, this.f51265r);
    }

    /* renamed from: F */
    public void m65261F(String str) {
        this.f51261n = str;
        if (this.f51262o != null) {
            this.f51262o = null;
        }
    }

    /* renamed from: G */
    public final void m65262G(Object obj) {
        if (obj == null) {
            this.f51258k.m65222a0();
            return;
        }
        try {
            m65276x(obj.getClass()).mo63933e(this, obj, null, null, 0);
        } catch (IOException e10) {
            throw new C9380d(e10.getMessage(), e10);
        }
    }

    /* renamed from: H */
    public final void m65263H(String str) {
        C10656f1.f51252a.m65246g(this, str);
    }

    /* renamed from: I */
    public void m65264I() {
        this.f51258k.m65222a0();
    }

    /* renamed from: J */
    public void m65265J(Object obj) {
        C10696y0 c10696y0 = this.f51265r;
        if (obj == c10696y0.f51333b) {
            this.f51258k.write("{\"$ref\":\"@\"}");
            return;
        }
        C10696y0 c10696y02 = c10696y0.f51332a;
        if (c10696y02 != null && obj == c10696y02.f51333b) {
            this.f51258k.write("{\"$ref\":\"..\"}");
            return;
        }
        while (true) {
            C10696y0 c10696y03 = c10696y0.f51332a;
            if (c10696y03 == null) {
                break;
            } else {
                c10696y0 = c10696y03;
            }
        }
        if (obj == c10696y0.f51333b) {
            this.f51258k.write("{\"$ref\":\"$\"}");
            return;
        }
        this.f51258k.write("{\"$ref\":\"");
        this.f51258k.write(this.f51264q.get(obj).toString());
        this.f51258k.write("\"}");
    }

    /* renamed from: K */
    public final void m65266K(Object obj, Object obj2) {
        m65267L(obj, obj2, null, 0);
    }

    /* renamed from: L */
    public final void m65267L(Object obj, Object obj2, Type type, int i10) {
        try {
            if (obj == null) {
                this.f51258k.m65222a0();
            } else {
                m65276x(obj.getClass()).mo63933e(this, obj, obj2, type, i10);
            }
        } catch (IOException e10) {
            throw new C9380d(e10.getMessage(), e10);
        }
    }

    /* renamed from: M */
    public final void m65268M(Object obj, String str) throws IOException {
        if (obj instanceof Date) {
            if ("unixtime".equals(str)) {
                this.f51258k.m65219X((int) (((Date) obj).getTime() / 1000));
                return;
            }
            if ("millis".equals(str)) {
                this.f51258k.m65221Z(((Date) obj).getTime());
                return;
            }
            DateFormat dateFormatM65273u = m65273u();
            if (dateFormatM65273u == null) {
                if (str != null) {
                    try {
                        dateFormatM65273u = m65272t(str);
                    } catch (IllegalArgumentException unused) {
                        dateFormatM65273u = m65272t(str.replaceAll(CloudBackupConstant.UserPackageInfo.TRIAL_MEMBER, "'T'"));
                    }
                } else {
                    String str2 = this.f51263p;
                    dateFormatM65273u = str2 != null ? m65272t(str2) : m65272t(AbstractC9377a.f46782e);
                }
            }
            this.f51258k.m65228g0(dateFormatM65273u.format((Date) obj));
            return;
        }
        if (!(obj instanceof byte[])) {
            if (!(obj instanceof Collection)) {
                m65262G(obj);
                return;
            }
            Collection collection = (Collection) obj;
            Iterator it = collection.iterator();
            this.f51258k.write(91);
            for (int i10 = 0; i10 < collection.size(); i10++) {
                Object next = it.next();
                if (i10 != 0) {
                    this.f51258k.write(44);
                }
                m65268M(next, str);
            }
            this.f51258k.write(93);
            return;
        }
        byte[] bArr = (byte[]) obj;
        if (!Constants.GZIP.equals(str) && !"gzip,base64".equals(str)) {
            if ("hex".equals(str)) {
                this.f51258k.m65218V(bArr);
                return;
            } else {
                this.f51258k.m65239y(bArr);
                return;
            }
        }
        GZIPOutputStream gZIPOutputStream = null;
        try {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                gZIPOutputStream = bArr.length < 512 ? new GZIPOutputStream(byteArrayOutputStream, bArr.length) : new GZIPOutputStream(byteArrayOutputStream);
                gZIPOutputStream.write(bArr);
                gZIPOutputStream.finish();
                this.f51258k.m65239y(byteArrayOutputStream.toByteArray());
                C11595g.m69206a(gZIPOutputStream);
            } catch (IOException e10) {
                throw new C9380d("write gzipBytes error", e10);
            }
        } catch (Throwable th2) {
            C11595g.m69206a(gZIPOutputStream);
            throw th2;
        }
    }

    /* renamed from: q */
    public void m65269q(EnumC10653e1 enumC10653e1, boolean z10) {
        this.f51258k.m65234t(enumC10653e1, z10);
    }

    /* renamed from: r */
    public boolean m65270r(Object obj) {
        C10696y0 c10696y0;
        IdentityHashMap<Object, C10696y0> identityHashMap = this.f51264q;
        if (identityHashMap == null || (c10696y0 = identityHashMap.get(obj)) == null || obj == Collections.emptyMap()) {
            return false;
        }
        Object obj2 = c10696y0.f51334c;
        return obj2 == null || (obj2 instanceof Integer) || (obj2 instanceof String);
    }

    /* renamed from: s */
    public void m65271s() {
        this.f51259l--;
    }

    /* renamed from: t */
    public final DateFormat m65272t(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, this.f51267t);
        simpleDateFormat.setTimeZone(this.f51266s);
        return simpleDateFormat;
    }

    public String toString() {
        return this.f51258k.toString();
    }

    /* renamed from: u */
    public DateFormat m65273u() {
        String str;
        if (this.f51262o == null && (str = this.f51261n) != null) {
            this.f51262o = m65272t(str);
        }
        return this.f51262o;
    }

    /* renamed from: v */
    public String m65274v() {
        DateFormat dateFormat = this.f51262o;
        return dateFormat instanceof SimpleDateFormat ? ((SimpleDateFormat) dateFormat).toPattern() : this.f51261n;
    }

    /* renamed from: w */
    public String m65275w() {
        return this.f51263p;
    }

    /* renamed from: x */
    public InterfaceC10686t0 m65276x(Class<?> cls) {
        return this.f51257j.m65187h(cls);
    }

    /* renamed from: y */
    public C10650d1 m65277y() {
        return this.f51258k;
    }

    /* renamed from: z */
    public void m65278z() {
        this.f51259l++;
    }

    public C10664i0(C10650d1 c10650d1) {
        this(c10650d1, C10641a1.m65181g());
    }

    public C10664i0(C10650d1 c10650d1, C10641a1 c10641a1) {
        this.f51259l = 0;
        this.f51260m = "\t";
        this.f51264q = null;
        this.f51266s = AbstractC9377a.f46778a;
        this.f51267t = AbstractC9377a.f46779b;
        this.f51258k = c10650d1;
        this.f51257j = c10641a1;
    }
}
