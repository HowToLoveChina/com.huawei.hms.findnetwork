package im;

import cm.C1457c;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import hm.C10321z;
import java.util.Map;
import p818yp.C14034a;

/* renamed from: im.o */
/* loaded from: classes6.dex */
public class C10565o extends AbstractC10569s {

    /* renamed from: T */
    public String f50818T;

    public C10565o(String str, int i10, String str2, C10321z c10321z, String str3, String str4, C1457c c1457c, Map<String, String> map, boolean z10, String str5, String str6, long j10, long j11, String str7) {
        super(str, str2, c10321z, c1457c, "File", CloudBackupConstant.Command.PMS_OPTION_ONE_FILE, i10, str3, str4, map, z10, str7);
        this.f50818T = str5;
        this.f50825J = str6;
        this.f50824I = j10;
        this.f50826K = j11;
    }

    @Override // im.AbstractC10569s
    /* renamed from: S */
    public String mo64804S() {
        return this.f50818T;
    }

    @Override // im.AbstractC10569s
    /* renamed from: U */
    public InterfaceC10549b0 mo64805U() {
        return new C10555e0(this.f50818T);
    }

    @Override // im.AbstractC10569s
    /* renamed from: X */
    public String mo64806X() {
        return C14034a.m84166c(mo64804S(), false).m73356b();
    }

    @Override // im.AbstractC10569s
    /* renamed from: Y */
    public String mo64807Y(String str) {
        return this.f50818T;
    }

    @Override // im.AbstractC10548b
    /* renamed from: f */
    public void mo64711f() {
        super.mo64711f();
    }
}
