package com.huawei.hms.common.util;

import com.huawei.hms.common.Preconditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes8.dex */
public final class Objects {

    public static final class ToStringHelper {

        /* renamed from: a */
        public final List<String> f23554a;

        /* renamed from: b */
        public final Object f23555b;

        public ToStringHelper(Object obj) {
            this.f23555b = Preconditions.checkNotNull(obj);
            this.f23554a = new ArrayList();
        }

        public ToStringHelper add(String str, Object obj) {
            String str2 = (String) Preconditions.checkNotNull(str);
            String strValueOf = String.valueOf(obj);
            this.f23554a.add(str2 + "=" + strValueOf);
            return this;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder(100);
            sb2.append(this.f23555b.getClass().getSimpleName());
            sb2.append('{');
            int size = this.f23554a.size();
            for (int i10 = 0; i10 < size; i10++) {
                sb2.append(this.f23554a.get(i10));
                if (i10 < size - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append('}');
            return sb2.toString();
        }
    }

    public Objects() {
        throw new AssertionError("illegal argument");
    }

    public static boolean equal(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static int hashCode(Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static ToStringHelper toStringHelper(Object obj) {
        return new ToStringHelper(obj);
    }
}
