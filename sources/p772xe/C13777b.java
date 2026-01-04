package p772xe;

import android.content.Context;
import android.util.SparseIntArray;
import com.huawei.android.remotecontrol.config.ParamConfig;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import p015ak.C0241z;
import p366if.AbstractC10482g;
import p774xg.C13811a;
import p809yg.C13981a;

/* renamed from: xe.b */
/* loaded from: classes4.dex */
public class C13777b {

    /* renamed from: a */
    public static HashMap<String, Long> f61893a = new HashMap<>();

    /* renamed from: b */
    public static HashMap<String, SparseIntArray> f61894b = new HashMap<>();

    /* renamed from: c */
    public static ArrayList<AbstractC10482g> f61895c = new ArrayList<>();

    /* renamed from: a */
    public static void m82700a(AbstractC10482g abstractC10482g) {
        if (abstractC10482g == null) {
            C13981a.m83988e("AlsLocateUtils", "task is null");
        } else {
            f61895c.add(abstractC10482g);
        }
    }

    /* renamed from: b */
    public static void m82701b() {
        ArrayList<AbstractC10482g> arrayList = f61895c;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        Iterator<AbstractC10482g> it = f61895c.iterator();
        while (it.hasNext()) {
            it.next().m64477x0();
        }
        f61895c.clear();
    }

    /* renamed from: c */
    public static String m82702c(boolean z10, SparseIntArray sparseIntArray, SparseIntArray sparseIntArray2, boolean z11) {
        if (sparseIntArray2 == null || sparseIntArray == null) {
            C13981a.m83988e("AlsLocateUtils", "connect state array or battery Array is empty");
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        int i10 = 0;
        int i11 = -1;
        if (z10) {
            while (true) {
                if (i10 >= sparseIntArray2.size()) {
                    break;
                }
                int iKeyAt = sparseIntArray2.keyAt(i10);
                if (-1 != sparseIntArray2.get(iKeyAt)) {
                    i11 = sparseIntArray2.get(iKeyAt);
                    break;
                }
                i10++;
            }
            return String.valueOf(i11);
        }
        while (true) {
            if (i10 >= sparseIntArray.size()) {
                break;
            }
            if (i10 >= sparseIntArray2.size()) {
                C13981a.m83988e("AlsLocateUtils", "battery state array size less than connect array");
                break;
            }
            int iKeyAt2 = sparseIntArray.keyAt(i10);
            String strValueOf = String.valueOf(sparseIntArray.get(iKeyAt2));
            if (z11) {
                if (!"0".equals(strValueOf)) {
                    sb2.append(",");
                    sb2.append(sparseIntArray2.get(iKeyAt2));
                }
            } else if ("1".equals(strValueOf)) {
                sb2.append(",");
                sb2.append(sparseIntArray2.get(iKeyAt2));
            }
            i10++;
        }
        return sb2.toString().length() < 2 ? String.valueOf(-1) : sb2.substring(1);
    }

    /* renamed from: d */
    public static SparseIntArray m82703d(String str) {
        return f61894b.get(str);
    }

    /* renamed from: e */
    public static String m82704e(SparseIntArray sparseIntArray, boolean z10) {
        if (sparseIntArray == null) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < sparseIntArray.size(); i10++) {
            int iKeyAt = sparseIntArray.keyAt(i10);
            String strValueOf = String.valueOf(sparseIntArray.get(iKeyAt));
            if (z10) {
                if (!"0".equals(strValueOf)) {
                    sb2.append(",");
                    sb2.append(iKeyAt + 1);
                }
            } else if ("1".equals(strValueOf)) {
                sb2.append(",");
                sb2.append(iKeyAt + 1);
            }
        }
        if (sb2.toString().length() < 2) {
            return null;
        }
        return sb2.substring(1);
    }

    /* renamed from: f */
    public static boolean m82705f(String str) {
        SparseIntArray sparseIntArray = f61894b.get(str);
        if (sparseIntArray == null) {
            return false;
        }
        for (int i10 = 0; i10 < sparseIntArray.size(); i10++) {
            if (!"0".equals(String.valueOf(sparseIntArray.get(sparseIntArray.keyAt(i10))))) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: g */
    public static boolean m82706g(String str) {
        Long l10 = f61893a.get(str);
        if (l10 == null) {
            f61893a.put(str, Long.valueOf(System.currentTimeMillis()));
            return false;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - l10.longValue();
        if (ParamConfig.getInstance().getDisconnectRequestDuring() <= jCurrentTimeMillis) {
            f61893a.put(str, Long.valueOf(System.currentTimeMillis()));
            return false;
        }
        C13981a.m83990w("AlsLocateUtils", "receive many times disconnect in time offset:" + jCurrentTimeMillis);
        return true;
    }

    /* renamed from: h */
    public static boolean m82707h() {
        return f61895c.size() != 0;
    }

    /* renamed from: i */
    public static void m82708i(Context context, boolean z10) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        C13811a.m82785C(context, z10, "als_locate");
    }

    /* renamed from: j */
    public static void m82709j(Context context, AbstractC10482g abstractC10482g) {
        if (abstractC10482g == null || f61895c.size() <= 0) {
            return;
        }
        f61895c.remove(abstractC10482g);
        if (f61895c.size() == 0) {
            C13981a.m83989i("AlsLocateUtils", "taskList is empty");
            C13811a.m82793K(context);
            C13811a.m82795M(context);
            C13811a.m82790H();
            C13811a.m82809f(context, false, abstractC10482g.mo64471r0());
            C13811a.m82798P(context, false);
        }
    }

    /* renamed from: k */
    public static void m82710k(String str, SparseIntArray sparseIntArray, boolean z10) {
        SparseIntArray sparseIntArrayClone = sparseIntArray.clone();
        if (!z10) {
            for (int i10 = 0; i10 < sparseIntArray.size(); i10++) {
                int iKeyAt = sparseIntArray.keyAt(i10);
                if ("1".equals(String.valueOf(sparseIntArray.get(iKeyAt)))) {
                    sparseIntArrayClone.put(iKeyAt, C0241z.m1685c("0"));
                } else {
                    sparseIntArrayClone.put(iKeyAt, C0241z.m1685c("2"));
                }
            }
        }
        f61894b.put(str, sparseIntArrayClone);
    }
}
