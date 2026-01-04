package p041c;

import android.content.Intent;
import java.util.ArrayList;
import java.util.Map;
import kw.C11172e0;
import kw.C11177h;
import kw.C11194u;
import p692uw.C13264g;

/* renamed from: c.b */
/* loaded from: classes.dex */
public final class C1366b extends AbstractC1365a<String[], Map<String, Boolean>> {

    /* renamed from: a */
    public static final a f5872a = new a(null);

    /* renamed from: c.b$a */
    public static final class a {
        public /* synthetic */ a(C13264g c13264g) {
            this();
        }

        public a() {
        }
    }

    @Override // p041c.AbstractC1365a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Map<String, Boolean> mo4627a(int i10, Intent intent) {
        if (i10 == -1 && intent != null) {
            String[] stringArrayExtra = intent.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
            int[] intArrayExtra = intent.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
            if (intArrayExtra == null || stringArrayExtra == null) {
                return C11172e0.m67135d();
            }
            ArrayList arrayList = new ArrayList(intArrayExtra.length);
            for (int i11 : intArrayExtra) {
                arrayList.add(Boolean.valueOf(i11 == 0));
            }
            return C11172e0.m67138g(C11194u.m67191u(C11177h.m67149i(stringArrayExtra), arrayList));
        }
        return C11172e0.m67135d();
    }
}
