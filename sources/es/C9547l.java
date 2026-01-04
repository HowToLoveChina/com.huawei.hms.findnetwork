package es;

import android.text.TextUtils;
import com.huawei.hms.support.api.location.common.exception.LocationStatusCode;
import p622rr.C12619b;
import p622rr.C12620c;

/* renamed from: es.l */
/* loaded from: classes8.dex */
public class C9547l {
    /* renamed from: a */
    public static void m59615a(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            throw new C12619b(LocationStatusCode.ARGUMENTS_EMPTY, C12620c.m76137a(LocationStatusCode.ARGUMENTS_EMPTY) + ":for String");
        }
    }

    /* renamed from: b */
    public static void m59616b(String str, Object obj, int i10, String str2) {
        if (obj == null) {
            throw new C12619b(i10, str2);
        }
    }

    /* renamed from: c */
    public static void m59617c(String str, Object obj, Class cls) {
        if (obj != null) {
            return;
        }
        throw new C12619b(LocationStatusCode.ARGUMENTS_EMPTY, C12620c.m76137a(LocationStatusCode.ARGUMENTS_EMPTY) + ":for object");
    }
}
