package p312g8;

import android.os.Bundle;
import com.huawei.android.hicloud.album.service.p075vo.FileData;
import com.huawei.android.hicloud.album.service.p075vo.GeneralAlbumData;
import com.huawei.android.hicloud.album.service.p075vo.HttpResult;
import com.huawei.android.hicloud.album.service.p075vo.SettingParams;
import com.huawei.android.hicloud.album.service.p075vo.ShareAlbumData;
import com.huawei.android.hicloud.album.service.p075vo.SmartAlbumData;
import com.huawei.android.hicloud.album.service.p075vo.SmartTagData;
import com.huawei.android.hicloud.album.service.p075vo.SyncPrompt;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import p031b7.C1120a;

/* renamed from: g8.b */
/* loaded from: classes2.dex */
public final class C9891b {

    /* renamed from: a */
    public static final Map<String, Class<?>> f48538a = Collections.unmodifiableMap(new a(16));

    /* renamed from: g8.b$a */
    public class a extends HashMap<String, Class<?>> {
        public a(int i10) {
            super(i10);
            Class[] clsArr = {Void.TYPE, Boolean.TYPE, Character.TYPE, Byte.TYPE, Short.TYPE, Integer.TYPE, Long.TYPE, Float.TYPE, Double.TYPE, String.class, FileData.class, GeneralAlbumData.class, ShareAlbumData.class, HttpResult.class, SmartAlbumData.class, SettingParams.class, SyncPrompt.class, SmartTagData.class, List.class};
            for (int i11 = 0; i11 < 19; i11++) {
                Class cls = clsArr[i11];
                String name = cls.getName();
                int iLastIndexOf = name.lastIndexOf(".");
                if (iLastIndexOf > 0) {
                    name = name.substring(iLastIndexOf + 1);
                }
                put(name, cls);
            }
        }
    }

    /* renamed from: a */
    public static boolean m61368a(Object obj, String str) {
        return obj == null || str == null;
    }

    /* renamed from: b */
    public static boolean m61369b(String[] strArr) {
        return strArr == null || strArr.length == 0;
    }

    /* renamed from: c */
    public static Class<?> m61370c(String str) throws ClassNotFoundException {
        Class<?> cls = f48538a.get(str);
        return cls != null ? cls : Class.forName(str);
    }

    /* renamed from: d */
    public static void m61371d(Object obj, Class<?> cls, int i10, Bundle bundle) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (obj == null) {
            C1120a.m6676e("ClassHelper", "Invoke input params invalid!");
        } else {
            m61372e(obj, cls, C9892c.m61373a().get(Integer.valueOf(i10)), bundle);
        }
    }

    /* renamed from: e */
    public static void m61372e(Object obj, Class<?> cls, String str, Bundle bundle) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Object[] objArr;
        String strSubstring;
        if (m61368a(obj, str)) {
            C1120a.m6676e("ClassHelper", "Invoke input params invalid!");
            return;
        }
        String[] strArrSplit = null;
        if (bundle != null) {
            Set<String> setKeySet = bundle.keySet();
            objArr = new Object[setKeySet.size()];
            Iterator<String> it = setKeySet.iterator();
            int i10 = 0;
            while (it.hasNext()) {
                objArr[i10] = bundle.get(it.next());
                i10++;
            }
        } else {
            objArr = null;
        }
        int iIndexOf = str.indexOf("(");
        if (iIndexOf > 0) {
            strSubstring = str.substring(0, iIndexOf);
            String strSubstring2 = str.substring(iIndexOf + 1, str.length() - 1);
            if (!strSubstring2.isEmpty()) {
                strArrSplit = strSubstring2.split(",");
            }
        } else {
            strSubstring = str;
        }
        try {
            if (m61369b(strArrSplit)) {
                cls.getMethod(strSubstring, new Class[0]).invoke(obj, new Object[0]);
                return;
            }
            int length = strArrSplit.length;
            Class<?>[] clsArr = new Class[length];
            for (int i11 = 0; i11 < length; i11++) {
                clsArr[i11] = m61370c(strArrSplit[i11]);
            }
            cls.getMethod(strSubstring, clsArr).invoke(obj, objArr);
        } catch (InvocationTargetException e10) {
            C1120a.m6676e("ClassHelper", e10.toString() + " Method: " + cls.getName() + "." + str);
        } catch (Exception e11) {
            C1120a.m6676e("ClassHelper", e11.toString() + " ClassName: " + cls.getName() + ", FullMethodName: " + str + ",MethodName: " + strSubstring);
        }
    }
}
