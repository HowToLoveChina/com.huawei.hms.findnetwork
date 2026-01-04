package sn;

import android.content.Context;
import android.text.TextUtils;
import cn.C1461a;
import com.google.gson.Gson;
import java.lang.reflect.ParameterizedType;
import p015ak.C0212e0;
import p015ak.C0213f;

/* renamed from: sn.a */
/* loaded from: classes6.dex */
public class C12818a<T> {
    /* renamed from: a */
    public String mo76960a() {
        throw null;
    }

    /* renamed from: b */
    public T m76961b() {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            C1461a.m8358e("BaseReliableRequest", "context null");
            return null;
        }
        Class<T> clsM76962c = m76962c();
        if (clsM76962c == null) {
            return null;
        }
        try {
            String strM1364n = C0212e0.m1364n(contextM1377a, "reliability_info", mo76960a(), "");
            if (TextUtils.isEmpty(strM1364n)) {
                return null;
            }
            return (T) new Gson().fromJson(strM1364n, (Class) clsM76962c);
        } catch (Exception e10) {
            C1461a.m8358e("BaseReliableRequest", "getSavedRequest exception:" + e10.toString());
            return null;
        }
    }

    /* renamed from: c */
    public final Class<T> m76962c() {
        try {
            return (Class) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        } catch (Exception e10) {
            C1461a.m8358e("BaseReliableRequest", "getClass exception:" + e10.toString());
            return null;
        }
    }

    /* renamed from: d */
    public void m76963d(T t10) {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            C1461a.m8358e("BaseReliableRequest", "context null");
            return;
        }
        if (t10 != null) {
            try {
                C0212e0.m1373w(contextM1377a, "reliability_info", mo76960a(), new Gson().toJson(t10));
            } catch (Exception e10) {
                C1461a.m8358e("BaseReliableRequest", "saveReqeust exception:" + e10.toString());
            }
        }
    }
}
