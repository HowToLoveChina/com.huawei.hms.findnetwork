package p471m6;

import androidx.recyclerview.widget.C0867f;
import com.huawei.android.p069cg.bean.MediaFileBean;
import com.huawei.android.p069cg.p071ui.RecyclerMediaAdapter;
import java.util.List;
import p031b7.C1120a;

/* renamed from: m6.e */
/* loaded from: classes2.dex */
public class C11419e extends C0867f.b {

    /* renamed from: a */
    public List f53221a;

    /* renamed from: b */
    public List f53222b;

    public C11419e(List list, List list2) {
        this.f53221a = list;
        this.f53222b = list2;
    }

    @Override // androidx.recyclerview.widget.C0867f.b
    /* renamed from: a */
    public boolean mo5482a(int i10, int i11) {
        return true;
    }

    @Override // androidx.recyclerview.widget.C0867f.b
    /* renamed from: b */
    public boolean mo5483b(int i10, int i11) {
        Object obj = this.f53221a.get(i10);
        Object obj2 = this.f53222b.get(i11);
        if ((obj instanceof RecyclerMediaAdapter.C2358j) && (obj2 instanceof RecyclerMediaAdapter.C2358j)) {
            String strM14802b = ((RecyclerMediaAdapter.C2358j) obj).m14802b();
            String strM14802b2 = ((RecyclerMediaAdapter.C2358j) obj2).m14802b();
            if (strM14802b == null || strM14802b2 == null) {
                return false;
            }
            return strM14802b.equals(strM14802b2);
        }
        if ((obj instanceof RecyclerMediaAdapter.C2356h) && (obj2 instanceof RecyclerMediaAdapter.C2356h)) {
            try {
                MediaFileBean mediaFileBeanM14792a = ((RecyclerMediaAdapter.C2356h) obj).m14792a();
                MediaFileBean mediaFileBeanM14792a2 = ((RecyclerMediaAdapter.C2356h) obj2).m14792a();
                if (mediaFileBeanM14792a == null && mediaFileBeanM14792a2 == null) {
                    return true;
                }
                String strM14306A = mediaFileBeanM14792a.m14306A();
                String strM14306A2 = mediaFileBeanM14792a2.m14306A();
                if (strM14306A != null && strM14306A2 != null) {
                    return strM14306A.equals(strM14306A2);
                }
                return false;
            } catch (Exception e10) {
                C1120a.m6676e("DiffCallback", e10.getMessage());
            }
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.C0867f.b
    /* renamed from: d */
    public int mo5485d() {
        List list = this.f53222b;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.C0867f.b
    /* renamed from: e */
    public int mo5486e() {
        List list = this.f53221a;
        if (list != null) {
            return list.size();
        }
        return 0;
    }
}
