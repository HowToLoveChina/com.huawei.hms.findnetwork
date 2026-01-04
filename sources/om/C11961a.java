package om;

import com.huawei.hicloud.cloudbackup.p104v3.model.BackupItem;
import java.util.ArrayList;
import java.util.List;

/* renamed from: om.a */
/* loaded from: classes6.dex */
public class C11961a {

    /* renamed from: b */
    public final int f55686b;

    /* renamed from: a */
    public List<BackupItem> f55685a = new ArrayList();

    /* renamed from: c */
    public boolean f55687c = true;

    /* renamed from: d */
    public ArrayList<String> f55688d = new ArrayList<>();

    public C11961a(int i10) {
        this.f55686b = i10;
    }

    /* renamed from: a */
    public List<BackupItem> m71940a() {
        if (this.f55685a == null) {
            this.f55685a = new ArrayList();
        }
        return this.f55685a;
    }

    /* renamed from: b */
    public int m71941b() {
        return this.f55686b;
    }

    /* renamed from: c */
    public ArrayList<String> m71942c() {
        return this.f55688d;
    }

    /* renamed from: d */
    public boolean m71943d() {
        return this.f55687c;
    }

    /* renamed from: e */
    public void m71944e(List<BackupItem> list) {
        this.f55685a = list;
    }

    /* renamed from: f */
    public void m71945f(boolean z10) {
        this.f55687c = z10;
    }
}
