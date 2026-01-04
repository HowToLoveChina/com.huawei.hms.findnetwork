package p216d4;

import android.content.Context;
import android.content.SharedPreferences;
import com.huawei.openalliance.p169ad.constant.AdConfigMapKey;
import org.json.JSONObject;
import p277f4.C9655a;
import p384j4.AbstractC10707f;
import p384j4.C10703b;

/* renamed from: d4.o0 */
/* loaded from: classes.dex */
public class C9027o0 {

    /* renamed from: b */
    public static C9027o0 f45678b;

    /* renamed from: c */
    public static final byte[] f45679c = new byte[0];

    /* renamed from: a */
    public Context f45680a;

    public C9027o0(Context context) {
        this.f45680a = C10703b.m65334b(context);
    }

    /* renamed from: b */
    public static C9027o0 m56955b(Context context) {
        return m56956d(context);
    }

    /* renamed from: d */
    public static C9027o0 m56956d(Context context) {
        C9027o0 c9027o0;
        synchronized (f45679c) {
            try {
                if (f45678b == null) {
                    f45678b = new C9027o0(context);
                }
                c9027o0 = f45678b;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return c9027o0;
    }

    /* renamed from: a */
    public int m56957a(String str) {
        return m56960f(str).getInt(AdConfigMapKey.IMP_MAX_COUNT, 2);
    }

    /* renamed from: c */
    public void m56958c(String str, JSONObject jSONObject, C9655a c9655a) {
        SharedPreferences.Editor editorEdit = m56960f(str).edit();
        Integer numM65384i = AbstractC10707f.m65384i(jSONObject.optString(AdConfigMapKey.RECALL_STRATEGY));
        editorEdit.putInt(AdConfigMapKey.RECALL_STRATEGY, numM65384i != null ? numM65384i.intValue() : 0);
        Integer numM65384i2 = AbstractC10707f.m65384i(jSONObject.optString(AdConfigMapKey.RECOMMEND_STRATEGY));
        editorEdit.putInt(AdConfigMapKey.RECOMMEND_STRATEGY, numM65384i2 != null ? numM65384i2.intValue() : 0);
        Integer numM65384i3 = AbstractC10707f.m65384i(jSONObject.optString(AdConfigMapKey.DUPLICATE_TIME));
        editorEdit.putInt(AdConfigMapKey.DUPLICATE_TIME, numM65384i3 != null ? numM65384i3.intValue() : 1);
        Integer numM65384i4 = AbstractC10707f.m65384i(jSONObject.optString(AdConfigMapKey.IMP_MAX_COUNT));
        editorEdit.putInt(AdConfigMapKey.IMP_MAX_COUNT, numM65384i4 != null ? numM65384i4.intValue() : 2);
        Integer numM65384i5 = AbstractC10707f.m65384i(jSONObject.optString(AdConfigMapKey.FEEDBACK_ENABLED));
        editorEdit.putInt(AdConfigMapKey.FEEDBACK_ENABLED, numM65384i5 != null ? numM65384i5.intValue() : 1);
        editorEdit.putString(AdConfigMapKey.RECOMMEND_TASK_LIST, jSONObject.optString(AdConfigMapKey.RECOMMEND_TASK_LIST, "2,3"));
        Integer numM65384i6 = AbstractC10707f.m65384i(jSONObject.optString(AdConfigMapKey.RECALL_RANK_ENABLED));
        editorEdit.putInt(AdConfigMapKey.RECALL_RANK_ENABLED, numM65384i6 != null ? numM65384i6.intValue() : 0);
        Integer numM65384i7 = AbstractC10707f.m65384i(jSONObject.optString("rankStrategy"));
        editorEdit.putInt("rankStrategy", numM65384i7 != null ? numM65384i7.intValue() : 4);
        Integer numM65384i8 = AbstractC10707f.m65384i(jSONObject.optString("reqMaxCount"));
        Integer numM65384i9 = AbstractC10707f.m65384i(jSONObject.optString("extraAdCount"));
        if (c9655a != null) {
            c9655a.m60302h(str, numM65384i8);
            c9655a.m60298d(str, numM65384i9);
        }
        editorEdit.apply();
    }

    /* renamed from: e */
    public int m56959e(String str) {
        return m56960f(str).getInt(AdConfigMapKey.FEEDBACK_ENABLED, 1);
    }

    /* renamed from: f */
    public final SharedPreferences m56960f(String str) {
        return this.f45680a.getSharedPreferences("hiad_rec_slot_cfg_" + str, 0);
    }

    /* renamed from: g */
    public int m56961g(String str) {
        return m56960f(str).getInt(AdConfigMapKey.RECALL_STRATEGY, 0);
    }

    /* renamed from: h */
    public int m56962h(String str) {
        return m56960f(str).getInt(AdConfigMapKey.RECOMMEND_STRATEGY, 0);
    }

    /* renamed from: i */
    public int m56963i(String str) {
        return m56960f(str).getInt(AdConfigMapKey.DUPLICATE_TIME, 1);
    }
}
