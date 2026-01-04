package im;

import cm.C1460f;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.Asset;
import fk.C9721b;
import hm.C10309n0;
import java.util.List;
import java.util.function.BiConsumer;

/* renamed from: im.a0 */
/* loaded from: classes6.dex */
public class C10547a0 extends AbstractC10571u {
    public C10547a0(String str, String str2, C1460f c1460f, String str3, String str4, String str5, String str6, int i10) {
        super(str, str2, c1460f, str3, "", "File", str4, str5, str6, i10);
    }

    @Override // im.AbstractC10571u
    /* renamed from: P */
    public Asset mo64708P(String str, List<String> list, String str2, boolean z10) throws C9721b {
        return new C10309n0(this.f50866j).m63494J(this.f50862f, this.f50869m, this.f50874r, this.f50867k, str, list, str2, z10, this.f50870n, this.f50871o, this.f50872p, this.f50873q, new Runnable() { // from class: im.y
            @Override // java.lang.Runnable
            public final void run() {
                this.f50912a.mo64709d();
            }
        }, new BiConsumer() { // from class: im.z
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                this.f50913a.m64873g0((String) obj, (String) obj2);
            }
        });
    }

    public C10547a0(String str, String str2, C1460f c1460f, String str3, String str4, int i10) {
        super(str, str2, c1460f, str3, "", str4, i10);
    }
}
