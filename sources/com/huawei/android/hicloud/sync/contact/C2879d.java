package com.huawei.android.hicloud.sync.contact;

import android.content.ContentProviderOperation;
import android.content.Context;
import android.net.Uri;
import android.provider.ContactsContract;
import android.text.TextUtils;
import com.huawei.android.hicloud.sync.syncutil.C2983l;
import com.huawei.uikit.hwrecyclerview.widget.HwItemTouchHelperEx;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import p015ak.C0208c0;
import p514o9.C11839m;

/* renamed from: com.huawei.android.hicloud.sync.contact.d */
/* loaded from: classes3.dex */
public class C2879d {

    /* renamed from: a */
    public static final Uri f12833a = ContactsContract.Data.CONTENT_URI.buildUpon().appendQueryParameter("caller_is_syncadapter", "1").build();

    /* renamed from: b */
    public static final Uri f12834b = ContactsContract.RawContacts.CONTENT_URI.buildUpon().appendQueryParameter("caller_is_syncadapter", "1").build();

    /* renamed from: c */
    public static final String[] f12835c = {"raw_contact_id", "_id", "mimetype", "data1", "data2", "data3", "data4", "data5", "data6", "data7", "data8", "data9", "data10", "data11", "data12", "data13", "data14", "data15", "data_sync1"};

    /* renamed from: d */
    public static String f12836d = "sync4";

    /* renamed from: a */
    public static void m17344a(StringBuffer stringBuffer, String str, String str2) {
        if (C2983l.m17910g(str2)) {
            return;
        }
        stringBuffer.append(str);
        stringBuffer.append(str2);
        stringBuffer.append("\r\n");
    }

    /* renamed from: b */
    public static void m17345b(C2882g c2882g, StringBuffer stringBuffer) {
        m17344a(stringBuffer, "BDAY:", c2882g.m17519t());
        m17344a(stringBuffer, "X-BDAY-LUNAR:", c2882g.m17451W0());
        ArrayList<String> arrayListM17503p = c2882g.m17503p();
        if (arrayListM17503p != null && arrayListM17503p.size() > 0) {
            Collections.sort(arrayListM17503p);
            Iterator<String> it = arrayListM17503p.iterator();
            while (it.hasNext()) {
                m17344a(stringBuffer, "X-CUSTOM-EVENT-1:", it.next());
            }
        }
        ArrayList<String> arrayListM17520t0 = c2882g.m17520t0();
        if (arrayListM17520t0 != null && arrayListM17520t0.size() > 0) {
            Collections.sort(arrayListM17520t0);
            Iterator<String> it2 = arrayListM17520t0.iterator();
            while (it2.hasNext()) {
                m17344a(stringBuffer, "X-CUSTOM-EVENT-2:", it2.next());
            }
        }
        ArrayList<String[]> arrayListM17384A = c2882g.m17384A();
        if (arrayListM17384A == null || arrayListM17384A.size() <= 0) {
            return;
        }
        Iterator<String[]> it3 = arrayListM17384A.iterator();
        while (it3.hasNext()) {
            String[] next = it3.next();
            if (!TextUtils.isEmpty(next[0])) {
                m17344a(stringBuffer, "X-CUSTOM-EVENT-0;X1-" + C2983l.m17909f(next[0]) + ":", next[1]);
            }
        }
    }

    /* renamed from: c */
    public static void m17346c(C2882g c2882g, StringBuffer stringBuffer) {
        ArrayList<String> arrayListM17424N0 = c2882g.m17424N0();
        if (arrayListM17424N0 != null && arrayListM17424N0.size() > 0) {
            Collections.sort(arrayListM17424N0);
            Iterator<String> it = arrayListM17424N0.iterator();
            while (it.hasNext()) {
                m17344a(stringBuffer, "URL;ENCODING=QUOTED-PRINTABLE;CHARSET=UTF-8:", C0208c0.m1143e(C2983l.m17912i(it.next())));
            }
        }
        ArrayList<String> arrayListM17441T = c2882g.m17441T();
        if (arrayListM17441T != null && arrayListM17441T.size() > 0) {
            Collections.sort(arrayListM17441T);
            Iterator<String> it2 = arrayListM17441T.iterator();
            while (it2.hasNext()) {
                m17344a(stringBuffer, "URL;HOME;ENCODING=QUOTED-PRINTABLE;CHARSET=UTF-8:", C0208c0.m1143e(C2983l.m17912i(it2.next())));
            }
        }
        ArrayList<String> arrayListM17445U0 = c2882g.m17445U0();
        if (arrayListM17445U0 == null || arrayListM17445U0.size() <= 0) {
            return;
        }
        Collections.sort(arrayListM17445U0);
        Iterator<String> it3 = arrayListM17445U0.iterator();
        while (it3.hasNext()) {
            m17344a(stringBuffer, "URL;WORK;ENCODING=QUOTED-PRINTABLE;CHARSET=UTF-8:", C0208c0.m1143e(C2983l.m17912i(it3.next())));
        }
    }

    /* renamed from: d */
    public static String m17347d() {
        return f12836d;
    }

    /* renamed from: e */
    public static String m17348e() {
        String string = UUID.randomUUID().toString();
        return string.substring(0, 8) + string.substring(9, 13) + string.substring(14, 18) + string.substring(19, 23) + string.substring(24);
    }

    /* renamed from: f */
    public static boolean m17349f(String[] strArr) {
        for (String str : strArr) {
            if (!C2983l.m17910g(str)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: g */
    public static void m17350g(String str) {
        f12836d = str;
    }

    /* renamed from: h */
    public static void m17351h(HashMap<String, String> map, Context context) throws Exception {
        int i10;
        if (map == null || map.size() == 0) {
            C11839m.m70688i("Contact", "[updateSync1] map is null or map size is 0");
            return;
        }
        ArrayList<ContentProviderOperation> arrayList = new ArrayList<>(HwItemTouchHelperEx.Callback.DEFAULT_SWIPE_ANIMATION_DURATION);
        loop0: while (true) {
            i10 = 0;
            for (Map.Entry<String, String> entry : map.entrySet()) {
                arrayList.add(ContentProviderOperation.newUpdate(f12834b).withSelection("_id=?", new String[]{entry.getKey()}).withValue("sync1", entry.getValue()).build());
                i10++;
                if (i10 == 400) {
                    break;
                }
            }
            context.getContentResolver().applyBatch("com.android.contacts", arrayList);
            arrayList.clear();
        }
        if (i10 > 0) {
            context.getContentResolver().applyBatch("com.android.contacts", arrayList);
            arrayList.clear();
        }
    }
}
