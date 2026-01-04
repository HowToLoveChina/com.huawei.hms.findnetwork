package pm;

import fk.C9721b;
import java.io.IOException;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import ni.C11707b;
import org.json.JSONArray;
import org.json.JSONException;
import p514o9.C11839m;
import p523oi.C11903a;
import p581qk.AbstractC12367d;
import p617rl.C12526j;
import p617rl.C12527k;
import p848zl.C14333b;

/* renamed from: pm.a0 */
/* loaded from: classes6.dex */
public class C12173a0 extends AbstractC12367d {
    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws C9721b {
        C11839m.m70688i("ParseSystemPackageNameTask", "parse system package name task begin.");
        C12527k c12527kM75407n = new C12526j().m75407n("systemPackageNameList");
        if (c12527kM75407n == null) {
            C11839m.m70689w("ParseSystemPackageNameTask", "parse system package name map is null.");
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(c12527kM75407n.m75434b());
            if (jSONArray.length() <= 0) {
                C11839m.m70689w("ParseSystemPackageNameTask", "parse system package name json array return null.");
                return;
            }
            C11707b c11707b = (C11707b) C11903a.m71435l().mo69832e(jSONArray.getString(0)).m69886u(C11707b.class);
            if (c11707b != null && c11707b.size() > 0) {
                Iterator<String> it = c11707b.keySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    String next = it.next();
                    if (c11707b.get(next) == null) {
                        C11839m.m70689w("ParseSystemPackageNameTask", "parse system package name parse value return null.");
                        C14333b.f63650b.clear();
                        break;
                    } else {
                        ConcurrentHashMap<String, Object> concurrentHashMap = C14333b.f63650b;
                        Object obj = c11707b.get(next);
                        Objects.requireNonNull(obj);
                        concurrentHashMap.put(next, obj);
                    }
                }
                C11839m.m70688i("ParseSystemPackageNameTask", "parse system package name task end, genericJson array: " + C14333b.f63650b.toString());
                return;
            }
            C11839m.m70689w("ParseSystemPackageNameTask", "parse system package name genericJson array return null.");
        } catch (IOException e10) {
            C11839m.m70687e("ParseSystemPackageNameTask", "parse system package name generic parse error: " + e10.toString());
        } catch (JSONException e11) {
            C11839m.m70687e("ParseSystemPackageNameTask", "parse system package name json array parse error: " + e11.toString());
        } catch (Exception e12) {
            C11839m.m70687e("ParseSystemPackageNameTask", "parse system package name error: " + e12.toString());
        }
    }
}
