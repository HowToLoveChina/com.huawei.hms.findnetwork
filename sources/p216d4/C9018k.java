package p216d4;

import android.content.Context;
import com.huawei.ads.adsrec.C2093e;
import com.huawei.ads.adsrec.p066db.table.MaterialSummaryRecord;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import p247e4.C9406b;
import p277f4.C9655a;
import p384j4.AbstractC10706e;
import p405jt.AbstractC10915a;

/* renamed from: d4.k */
/* loaded from: classes.dex */
public class C9018k implements InterfaceC9016j {

    /* renamed from: a */
    public final Map<String, Set<String>> f45654a = new HashMap();

    @Override // p216d4.InterfaceC9016j
    /* renamed from: a */
    public void mo56926a(Context context, C9655a c9655a, C9020l c9020l) {
        if (context == null || c9655a == null || c9020l == null) {
            AbstractC10915a.m65978j("SplashAdFilter", "valid args");
            return;
        }
        List<C9031r> listM56946q = c9020l.m56946q();
        if (AbstractC10706e.m65374a(listM56946q)) {
            return;
        }
        m56929b(context, c9655a);
        for (C9031r c9031r : listM56946q) {
            List<C9406b> listM56974o = c9031r.m56974o();
            if (!AbstractC10706e.m65374a(listM56974o)) {
                ArrayList arrayList = new ArrayList();
                for (C9406b c9406b : listM56974o) {
                    if (c9406b != null && (c9406b.m58981n() == 0 || m56931d(c9031r.m56976q(), c9406b.m58977j()))) {
                        arrayList.add(c9406b);
                    }
                }
                c9031r.m56969j(arrayList);
            }
        }
    }

    /* renamed from: b */
    public final void m56929b(Context context, C9655a c9655a) {
        String str;
        Integer numM60311q = c9655a.m60311q();
        if (numM60311q == null) {
            str = "orientation empty";
        } else {
            List<MaterialSummaryRecord> listMo12534b = new C2093e(context).mo12534b(c9655a.m60304j(), String.valueOf(c9655a.m60307m()));
            if (!AbstractC10706e.m65374a(listMo12534b)) {
                for (MaterialSummaryRecord materialSummaryRecord : listMo12534b) {
                    if (m56930c(materialSummaryRecord, numM60311q.intValue())) {
                        String strM12514x = materialSummaryRecord.m12514x();
                        Set<String> hashSet = this.f45654a.get(strM12514x);
                        if (hashSet == null) {
                            hashSet = new HashSet<>();
                            this.f45654a.put(strM12514x, hashSet);
                        }
                        hashSet.add(materialSummaryRecord.m12511u());
                    }
                }
                return;
            }
            str = "materialSummaryRecords empty";
        }
        AbstractC10915a.m65978j("SplashAdFilter", str);
    }

    /* renamed from: c */
    public final boolean m56930c(MaterialSummaryRecord materialSummaryRecord, int i10) {
        materialSummaryRecord.m12516z();
        materialSummaryRecord.m12512v();
        if (materialSummaryRecord.m12516z() <= 0 || materialSummaryRecord.m12512v() <= 0) {
            return false;
        }
        return i10 == 1 ? materialSummaryRecord.m12516z() <= materialSummaryRecord.m12512v() : materialSummaryRecord.m12516z() > materialSummaryRecord.m12512v();
    }

    /* renamed from: d */
    public final boolean m56931d(String str, String str2) {
        Set<String> set = this.f45654a.get(str);
        if (set != null && !set.isEmpty()) {
            return set.contains(str2);
        }
        AbstractC10915a.m65979k("SplashAdFilter", "not such material with slot:%s", str);
        return false;
    }
}
