package p792xy;

import az.C1081e;
import com.huawei.android.hicloud.sync.service.aidl.SyncType;
import com.huawei.hicloud.notification.constants.RecommendCardConstants;
import com.huawei.riemann.location.common.utils.Constant;
import com.huawei.uikit.hwadvancednumberpicker.utils.HwConstants;
import p271ez.AbstractC9578d;
import p826yy.C14057a;
import p859zy.C14405a;
import uy.C13294h;
import uy.InterfaceC13287a;
import uy.InterfaceC13288b;

/* renamed from: xy.a */
/* loaded from: classes9.dex */
public class C13894a {

    /* renamed from: a */
    public byte[] f62232a;

    /* renamed from: b */
    public byte[] f62233b;

    /* renamed from: c */
    public byte[] f62234c;

    /* renamed from: d */
    public byte[] f62235d;

    /* renamed from: e */
    public int f62236e;

    /* renamed from: f */
    public InterfaceC13287a f62237f;

    /* renamed from: g */
    public int f62238g;

    /* renamed from: h */
    public byte[] f62239h;

    /* renamed from: i */
    public byte[] f62240i;

    public C13894a(InterfaceC13287a interfaceC13287a) {
        this(interfaceC13287a, interfaceC13287a.mo79738c() * 8);
    }

    /* renamed from: e */
    public static byte[] m83294e(int i10) {
        int i11 = i10 * 8;
        int i12 = SyncType.RISK_MANAGEMENT_MANUALLY;
        switch (i11) {
            case 64:
            case 320:
                i12 = 27;
                break;
            case 128:
            case 192:
                break;
            case RecommendCardConstants.Num.BANNER_HEIGHT_FONT_SCALE /* 160 */:
                i12 = 45;
                break;
            case Constant.ERROR_WSS_INVALID /* 224 */:
                i12 = 777;
                break;
            case 256:
                i12 = 1061;
                break;
            case 384:
                i12 = 4109;
                break;
            case 448:
                i12 = 2129;
                break;
            case 512:
                i12 = 293;
                break;
            case 768:
                i12 = 655377;
                break;
            case 1024:
                i12 = 524355;
                break;
            case 2048:
                i12 = 548865;
                break;
            default:
                throw new IllegalArgumentException("Unknown block size for CMAC: " + i11);
        }
        return AbstractC9578d.m59771c(i12);
    }

    /* renamed from: g */
    public static int m83295g(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        int i10 = 0;
        while (true) {
            length--;
            if (length < 0) {
                return i10;
            }
            int i11 = bArr[length] & 255;
            bArr2[length] = (byte) (i10 | (i11 << 1));
            i10 = (i11 >>> 7) & 1;
        }
    }

    /* renamed from: a */
    public int m83296a(byte[] bArr, int i10) throws IllegalStateException, C13294h {
        byte[] bArr2;
        if (this.f62236e == this.f62237f.mo79738c()) {
            bArr2 = this.f62239h;
        } else {
            new C14405a().m85638a(this.f62235d, this.f62236e);
            bArr2 = this.f62240i;
        }
        int i11 = 0;
        while (true) {
            byte[] bArr3 = this.f62234c;
            if (i11 >= bArr3.length) {
                this.f62237f.mo79737b(this.f62235d, 0, bArr3, 0);
                System.arraycopy(this.f62234c, 0, bArr, i10, this.f62238g);
                m83300f();
                return this.f62238g;
            }
            byte[] bArr4 = this.f62235d;
            bArr4[i11] = (byte) (bArr4[i11] ^ bArr2[i11]);
            i11++;
        }
    }

    /* renamed from: b */
    public final byte[] m83297b(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length];
        int i10 = (-m83295g(bArr, bArr2)) & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA;
        int length = bArr.length - 3;
        byte b10 = bArr2[length];
        byte[] bArr3 = this.f62232a;
        bArr2[length] = (byte) (b10 ^ (bArr3[1] & i10));
        int length2 = bArr.length - 2;
        bArr2[length2] = (byte) ((bArr3[2] & i10) ^ bArr2[length2]);
        int length3 = bArr.length - 1;
        bArr2[length3] = (byte) ((bArr3[3] & i10) ^ bArr2[length3]);
        return bArr2;
    }

    /* renamed from: c */
    public int m83298c() {
        return this.f62238g;
    }

    /* renamed from: d */
    public void m83299d(InterfaceC13288b interfaceC13288b) throws IllegalStateException, C13294h, IllegalArgumentException {
        m83302i(interfaceC13288b);
        this.f62237f.mo79739d(true, interfaceC13288b);
        byte[] bArr = this.f62233b;
        byte[] bArr2 = new byte[bArr.length];
        this.f62237f.mo79737b(bArr, 0, bArr2, 0);
        byte[] bArrM83297b = m83297b(bArr2);
        this.f62239h = bArrM83297b;
        this.f62240i = m83297b(bArrM83297b);
        m83300f();
    }

    /* renamed from: f */
    public void m83300f() {
        int i10 = 0;
        while (true) {
            byte[] bArr = this.f62235d;
            if (i10 >= bArr.length) {
                this.f62236e = 0;
                this.f62237f.reset();
                return;
            } else {
                bArr[i10] = 0;
                i10++;
            }
        }
    }

    /* renamed from: h */
    public void m83301h(byte[] bArr, int i10, int i11) throws IllegalStateException, C13294h {
        if (i11 < 0) {
            throw new IllegalArgumentException("Can't have a negative input length!");
        }
        int iMo79738c = this.f62237f.mo79738c();
        int i12 = this.f62236e;
        int i13 = iMo79738c - i12;
        if (i11 > i13) {
            System.arraycopy(bArr, i10, this.f62235d, i12, i13);
            this.f62237f.mo79737b(this.f62235d, 0, this.f62234c, 0);
            this.f62236e = 0;
            i11 -= i13;
            i10 += i13;
            while (i11 > iMo79738c) {
                this.f62237f.mo79737b(bArr, i10, this.f62234c, 0);
                i11 -= iMo79738c;
                i10 += iMo79738c;
            }
        }
        System.arraycopy(bArr, i10, this.f62235d, this.f62236e, i11);
        this.f62236e += i11;
    }

    /* renamed from: i */
    public void m83302i(InterfaceC13288b interfaceC13288b) {
        if (interfaceC13288b != null && !(interfaceC13288b instanceof C1081e)) {
            throw new IllegalArgumentException("CMac mode only permits key to be set.");
        }
    }

    public C13894a(InterfaceC13287a interfaceC13287a, int i10) {
        if (i10 % 8 != 0) {
            throw new IllegalArgumentException("MAC size must be multiple of 8");
        }
        if (i10 > interfaceC13287a.mo79738c() * 8) {
            throw new IllegalArgumentException("MAC size must be less or equal to " + (interfaceC13287a.mo79738c() * 8));
        }
        this.f62237f = C14057a.m84259g(interfaceC13287a);
        this.f62238g = i10 / 8;
        this.f62232a = m83294e(interfaceC13287a.mo79738c());
        this.f62234c = new byte[interfaceC13287a.mo79738c()];
        this.f62235d = new byte[interfaceC13287a.mo79738c()];
        this.f62233b = new byte[interfaceC13287a.mo79738c()];
        this.f62236e = 0;
    }
}
