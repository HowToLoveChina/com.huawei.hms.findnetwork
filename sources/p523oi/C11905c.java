package p523oi;

import com.huawei.cloud.base.util.C4627a0;
import com.huawei.hms.drive.C5194b;
import com.huawei.hms.drive.EnumC5222c;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import java.io.EOFException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import ni.AbstractC11708c;
import ni.AbstractC11710e;
import ni.EnumC11713h;

/* renamed from: oi.c */
/* loaded from: classes.dex */
public class C11905c extends AbstractC11710e {

    /* renamed from: c */
    public final C5194b f55139c;

    /* renamed from: d */
    public final C11903a f55140d;

    /* renamed from: e */
    public List<String> f55141e = new ArrayList();

    /* renamed from: f */
    public EnumC11713h f55142f;

    /* renamed from: g */
    public String f55143g;

    /* renamed from: oi.c$a */
    public static /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f55144a;

        /* renamed from: b */
        public static final /* synthetic */ int[] f55145b;

        static {
            int[] iArr = new int[EnumC5222c.values().length];
            f55145b = iArr;
            try {
                iArr[EnumC5222c.BEGIN_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f55145b[EnumC5222c.END_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f55145b[EnumC5222c.BEGIN_OBJECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f55145b[EnumC5222c.END_OBJECT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f55145b[EnumC5222c.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f55145b[EnumC5222c.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f55145b[EnumC5222c.STRING.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f55145b[EnumC5222c.NUMBER.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f55145b[EnumC5222c.NAME.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            int[] iArr2 = new int[EnumC11713h.values().length];
            f55144a = iArr2;
            try {
                iArr2[EnumC11713h.START_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f55144a[EnumC11713h.START_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    public C11905c(C11903a c11903a, C5194b c5194b) {
        this.f55140d = c11903a;
        this.f55139c = c5194b;
        c5194b.m31017a(true);
    }

    @Override // ni.AbstractC11710e
    /* renamed from: F */
    public AbstractC11710e mo69863F() throws IOException {
        EnumC11713h enumC11713h = this.f55142f;
        if (enumC11713h != null) {
            int i10 = a.f55144a[enumC11713h.ordinal()];
            if (i10 == 1) {
                this.f55139c.m31027k();
                this.f55143g = "]";
                this.f55142f = EnumC11713h.END_ARRAY;
            } else if (i10 == 2) {
                this.f55139c.m31027k();
                this.f55143g = "}";
                this.f55142f = EnumC11713h.END_OBJECT;
            }
        }
        return this;
    }

    /* renamed from: J */
    public final void m71438J() {
        EnumC11713h enumC11713h = this.f55142f;
        C4627a0.m28388a(enumC11713h == EnumC11713h.VALUE_NUMBER_INT || enumC11713h == EnumC11713h.VALUE_NUMBER_FLOAT);
    }

    /* renamed from: K */
    public final void m71439K() throws IOException {
        EnumC11713h enumC11713h = this.f55142f;
        if (enumC11713h != null) {
            int i10 = a.f55144a[enumC11713h.ordinal()];
            if (i10 == 1) {
                this.f55139c.m31016a();
                this.f55141e.add(null);
            } else {
                if (i10 != 2) {
                    return;
                }
                this.f55139c.m31019c();
                this.f55141e.add(null);
            }
        }
    }

    @Override // ni.AbstractC11710e
    /* renamed from: a */
    public void mo69867a() throws IOException {
        this.f55139c.close();
    }

    @Override // ni.AbstractC11710e
    /* renamed from: b */
    public BigInteger mo69868b() {
        m71438J();
        return new BigInteger(this.f55143g);
    }

    @Override // ni.AbstractC11710e
    /* renamed from: c */
    public byte mo69869c() {
        m71438J();
        return Byte.parseByte(this.f55143g);
    }

    @Override // ni.AbstractC11710e
    /* renamed from: e */
    public String mo69870e() {
        if (this.f55141e.isEmpty()) {
            return null;
        }
        return this.f55141e.get(r1.size() - 1);
    }

    @Override // ni.AbstractC11710e
    /* renamed from: f */
    public EnumC11713h mo69871f() {
        return this.f55142f;
    }

    @Override // ni.AbstractC11710e
    /* renamed from: g */
    public BigDecimal mo69872g() {
        m71438J();
        return new BigDecimal(this.f55143g);
    }

    @Override // ni.AbstractC11710e
    /* renamed from: h */
    public double mo69873h() {
        m71438J();
        return Double.parseDouble(this.f55143g);
    }

    @Override // ni.AbstractC11710e
    /* renamed from: i */
    public AbstractC11708c mo69874i() {
        return this.f55140d;
    }

    @Override // ni.AbstractC11710e
    /* renamed from: j */
    public float mo69875j() {
        m71438J();
        return Float.parseFloat(this.f55143g);
    }

    @Override // ni.AbstractC11710e
    /* renamed from: k */
    public int mo69876k() {
        m71438J();
        return Integer.parseInt(this.f55143g);
    }

    @Override // ni.AbstractC11710e
    /* renamed from: l */
    public long mo69877l() {
        m71438J();
        return Long.parseLong(this.f55143g);
    }

    @Override // ni.AbstractC11710e
    /* renamed from: n */
    public short mo69879n() {
        m71438J();
        return Short.parseShort(this.f55143g);
    }

    @Override // ni.AbstractC11710e
    /* renamed from: o */
    public String mo69880o() {
        return this.f55143g;
    }

    @Override // ni.AbstractC11710e
    /* renamed from: p */
    public EnumC11713h mo69881p() throws IOException {
        EnumC5222c enumC5222cM31021e;
        m71439K();
        try {
            enumC5222cM31021e = this.f55139c.m31021e();
        } catch (EOFException unused) {
            enumC5222cM31021e = EnumC5222c.END_DOCUMENT;
        }
        switch (a.f55145b[enumC5222cM31021e.ordinal()]) {
            case 1:
                this.f55143g = "[";
                this.f55142f = EnumC11713h.START_ARRAY;
                break;
            case 2:
                this.f55143g = "]";
                this.f55142f = EnumC11713h.END_ARRAY;
                this.f55141e.remove(r0.size() - 1);
                this.f55139c.m31018b();
                break;
            case 3:
                this.f55143g = "{";
                this.f55142f = EnumC11713h.START_OBJECT;
                break;
            case 4:
                this.f55143g = "}";
                this.f55142f = EnumC11713h.END_OBJECT;
                this.f55141e.remove(r0.size() - 1);
                this.f55139c.m31020d();
                break;
            case 5:
                if (!this.f55139c.m31025i()) {
                    this.f55143g = "false";
                    this.f55142f = EnumC11713h.VALUE_FALSE;
                    break;
                } else {
                    this.f55143g = FaqConstants.DISABLE_HA_REPORT;
                    this.f55142f = EnumC11713h.VALUE_TRUE;
                    break;
                }
            case 6:
                this.f55143g = "null";
                this.f55142f = EnumC11713h.VALUE_NULL;
                this.f55139c.m31026j();
                break;
            case 7:
                this.f55143g = this.f55139c.m31024h();
                this.f55142f = EnumC11713h.VALUE_STRING;
                break;
            case 8:
                String strM31024h = this.f55139c.m31024h();
                this.f55143g = strM31024h;
                this.f55142f = strM31024h.indexOf(46) == -1 ? EnumC11713h.VALUE_NUMBER_INT : EnumC11713h.VALUE_NUMBER_FLOAT;
                break;
            case 9:
                this.f55143g = this.f55139c.m31023g();
                this.f55142f = EnumC11713h.FIELD_NAME;
                this.f55141e.set(r0.size() - 1, this.f55143g);
                break;
            default:
                this.f55143g = null;
                this.f55142f = null;
                break;
        }
        return this.f55142f;
    }
}
