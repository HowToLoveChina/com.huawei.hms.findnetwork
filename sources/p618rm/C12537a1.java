package p618rm;

import com.huawei.hicloud.cloudbackup.p104v3.core.C4879a;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hms.identity.AddressConstants;
import com.tencent.p204mm.opensdk.constants.ConstantsAPI;
import dm.InterfaceC9213h2;
import fk.C9721b;
import hk.C10278a;
import hk.C10279b;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import p495nm.C11730k;
import p514o9.C11835i;
import p514o9.C11839m;

/* renamed from: rm.a1 */
/* loaded from: classes6.dex */
public class C12537a1 {

    /* renamed from: a */
    public C4879a f57870a;

    /* renamed from: b */
    public String f57871b;

    /* renamed from: c */
    public int f57872c;

    /* renamed from: d */
    public File f57873d;

    /* renamed from: e */
    public File f57874e;

    /* renamed from: f */
    public File f57875f;

    /* renamed from: g */
    public InterfaceC9213h2 f57876g;

    /* renamed from: j */
    public C11730k f57879j;

    /* renamed from: h */
    public boolean f57877h = false;

    /* renamed from: i */
    public boolean f57878i = false;

    /* renamed from: k */
    public Map<String, String> f57880k = new HashMap();

    /* renamed from: l */
    public boolean f57881l = false;

    public C12537a1(C4879a c4879a, String str, InterfaceC9213h2 interfaceC9213h2, File file, int i10) {
        this.f57870a = c4879a;
        this.f57871b = str;
        this.f57876g = interfaceC9213h2;
        this.f57873d = file;
        this.f57872c = i10;
        this.f57879j = c4879a.m29746t0();
    }

    /* renamed from: a */
    public final void m75467a(InterfaceC9213h2 interfaceC9213h2, double d10, long j10) throws Throwable {
        this.f57874e = m75469c(interfaceC9213h2.mo57844e0() + ".dbhashfile");
        File fileM75472f = m75472f(interfaceC9213h2);
        this.f57875f = fileM75472f;
        m75476j(interfaceC9213h2, this.f57874e, fileM75472f, this.f57873d, j10, d10);
    }

    /* renamed from: b */
    public boolean m75468b() throws Throwable {
        long jM69998i;
        long jM69991b;
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            jM69998i = this.f57879j.m69998i() * ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS;
            jM69991b = this.f57879j.m69991b() * 1048576;
        } catch (C9721b e10) {
            C11839m.m70689w("FileDifferenceImpl", "create difference file error, " + e10.toString());
            if (!C11835i.m70642f(this.f57874e) || !C11835i.m70642f(this.f57875f)) {
                C11839m.m70687e("FileDifferenceImpl", "createDiffIncFile delete curHashFile or curPacketFile fail");
            }
            this.f57880k.put("dBDiffErrorReason", e10.getMessage());
            this.f57880k.put(AddressConstants.Extras.EXTRA_NAME_ERR_CODE, String.valueOf(e10.m60659c()));
        }
        if (jM69991b <= jM69998i) {
            String str = "no differernce, tarThreshold >= bigDbConfigSize, tarThreshold: " + jM69998i + ", bigDbConfigSize: " + jM69991b;
            C11839m.m70688i("FileDifferenceImpl", str);
            this.f57880k.put("dBDiffErrorReason", str);
            this.f57880k.put(AddressConstants.Extras.EXTRA_NAME_ERR_CODE, String.valueOf(100));
            return this.f57877h;
        }
        long jM69993d = this.f57879j.m69993d() * ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS;
        double dM69992c = this.f57879j.m69992c();
        m75473g();
        m75467a(this.f57876g, dM69992c, jM69993d);
        C11839m.m70688i("FileDifferenceImpl", "create diff file success, appId: " + this.f57871b + ",dbSplitBlock：" + jM69993d + ",dbSimilarity:" + dM69992c + ", curHashFile: " + C10279b.m63452a(this.f57874e));
        this.f57880k.put("isOverMaxDifferent", String.valueOf(this.f57881l));
        this.f57880k.put("createFileDiffTime", String.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
        return this.f57877h;
    }

    /* renamed from: c */
    public final File m75469c(String str) throws C9721b {
        File fileM63442h = C10278a.m63442h(str);
        try {
            if (fileM63442h.exists() && (!fileM63442h.delete() || !fileM63442h.createNewFile())) {
                throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "createEmptyHashFile reCreateRes fail, path = " + str);
            }
            return fileM63442h;
        } catch (Exception e10) {
            C11839m.m70687e("FileDifferenceImpl", "createEmptyHashFile exception:" + e10.getMessage());
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, e10.getMessage() + " stack: " + C12590s0.m75731C0(e10));
        }
    }

    /* renamed from: d */
    public File m75470d() {
        return this.f57874e;
    }

    /* renamed from: e */
    public File m75471e() {
        return this.f57875f;
    }

    /* renamed from: f */
    public File m75472f(InterfaceC9213h2 interfaceC9213h2) {
        String str = interfaceC9213h2.mo57844e0() + "_diff_packet_index_" + this.f57872c + ".differencepacket";
        File fileM63442h = C10278a.m63442h(str);
        if (!fileM63442h.exists()) {
            return fileM63442h;
        }
        if (!fileM63442h.delete()) {
            C11839m.m70688i("FileDifferenceImpl", "delete packet file error, file = " + fileM63442h.getName());
        }
        return C10278a.m63442h(str);
    }

    /* renamed from: g */
    public final void m75473g() throws InterruptedException, C9721b {
        C4879a c4879a = this.f57870a;
        if (c4879a != null) {
            c4879a.isDiffCancel();
        }
    }

    /* renamed from: h */
    public boolean m75474h() {
        return this.f57878i;
    }

    /* renamed from: i */
    public final void m75475i(File file, boolean z10, boolean z11, boolean z12) {
        if (z10) {
            this.f57877h = false;
            C11835i.m70642f(file);
        } else if (z11) {
            this.f57877h = false;
            C11835i.m70642f(file);
        } else if (z12) {
            this.f57877h = true;
        } else {
            this.f57877h = false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0259 A[Catch: all -> 0x021e, IOException -> 0x022b, TRY_LEAVE, TryCatch #33 {IOException -> 0x022b, all -> 0x021e, blocks: (B:89:0x020a, B:91:0x0217, B:101:0x0242, B:105:0x0259), top: B:203:0x020a }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0110  */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    /* renamed from: j */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m75476j(dm.InterfaceC9213h2 r38, java.io.File r39, java.io.File r40, java.io.File r41, long r42, double r44) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1184
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p618rm.C12537a1.m75476j(dm.h2, java.io.File, java.io.File, java.io.File, long, double):void");
    }

    /* renamed from: k */
    public void m75477k(Map<String, String> map) {
        this.f57880k = map;
    }
}
