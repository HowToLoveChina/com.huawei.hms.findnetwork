package am;

import com.huawei.android.hicloud.cloudbackup.util.ICBUtil;
import java.util.List;
import p495nm.C11725f;
import p572qb.C12299b;
import p618rm.C12590s0;
import p711vl.C13465e;
import p848zl.C14333b;
import tl.C13026e;

/* renamed from: am.k1 */
/* loaded from: classes6.dex */
public class C0281k1 implements InterfaceC0260d1 {
    @Override // am.InterfaceC0260d1
    /* renamed from: a */
    public Boolean mo1756a(String str) {
        return Boolean.valueOf(ICBUtil.getSwitchFromOptionSpV3(str, mo1759d()));
    }

    @Override // am.InterfaceC0260d1
    /* renamed from: b */
    public C11725f mo1757b() {
        return C12590s0.m75894q2();
    }

    @Override // am.InterfaceC0260d1
    /* renamed from: c */
    public void mo1758c() {
        C12299b.m73927i();
    }

    @Override // am.InterfaceC0260d1
    /* renamed from: d */
    public C13026e mo1759d() {
        return new C13026e(true);
    }

    @Override // am.InterfaceC0260d1
    /* renamed from: e */
    public void mo1760e(String str) {
    }

    @Override // am.InterfaceC0260d1
    /* renamed from: g */
    public long mo1761g() {
        return C13465e.m81052f().m81057e(true);
    }

    @Override // am.InterfaceC0260d1
    /* renamed from: h */
    public void mo1762h() {
    }

    @Override // am.InterfaceC0260d1
    /* renamed from: i */
    public void mo1763i(List<String> list) {
        list.removeAll(C14333b.m85449E());
    }

    @Override // am.InterfaceC0260d1
    /* renamed from: j */
    public void mo1764j() {
        mo1759d().clear();
    }
}
