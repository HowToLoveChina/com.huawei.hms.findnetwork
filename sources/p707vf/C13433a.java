package p707vf;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.net.Uri;
import android.os.Parcelable;
import android.provider.CallLog;
import android.provider.ContactsContract;
import android.text.TextUtils;
import com.huawei.android.remotecontrol.sharing.bean.Contact;
import java.util.ArrayList;
import java.util.List;
import p809yg.C13981a;

/* renamed from: vf.a */
/* loaded from: classes4.dex */
public class C13433a {

    /* renamed from: a */
    public static final Uri f60532a = ContactsContract.Data.CONTENT_URI;

    /* renamed from: b */
    public static final Uri f60533b = CallLog.Calls.CONTENT_URI;

    /* renamed from: c */
    public static final String[] f60534c = {"_id", "data1", "display_name"};

    /* renamed from: d */
    public static final String[] f60535d = {"_id", "number", "name"};

    /* renamed from: a */
    public static List<Contact> m80731a(Context context, Parcelable[] parcelableArr) {
        if (parcelableArr == null || parcelableArr.length == 0) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder(16);
        StringBuilder sb3 = new StringBuilder(16);
        boolean z10 = false;
        boolean z11 = false;
        for (Parcelable parcelable : parcelableArr) {
            Uri uri = (Uri) parcelable;
            if (uri != null && "content".equals(uri.getScheme())) {
                if (uri.toString().startsWith("content://com.android.contacts/data/")) {
                    if (z10) {
                        sb2.append(',');
                        sb2.append(uri.getLastPathSegment());
                    } else {
                        sb2.append(uri.getLastPathSegment());
                        z10 = true;
                    }
                } else if (!uri.toString().startsWith("content://call_log/calls/")) {
                    C13981a.m83990w("ContactHelper", "go to else branch");
                } else if (z11) {
                    sb3.append(',');
                    sb3.append(uri.getLastPathSegment());
                } else {
                    sb3.append(uri.getLastPathSegment());
                    z11 = true;
                }
            }
        }
        return m80732b(context, sb2, z10, sb3, z11);
    }

    /* renamed from: b */
    public static List<Contact> m80732b(Context context, StringBuilder sb2, boolean z10, StringBuilder sb3, boolean z11) {
        List<Contact> listM80733c;
        List<Contact> listM80734d;
        if (!z10 && !z11) {
            return null;
        }
        ArrayList arrayList = new ArrayList(10);
        if (z10 && (listM80734d = m80734d(context, sb2.toString())) != null && listM80734d.size() > 0) {
            arrayList.addAll(listM80734d);
        }
        if (z11 && (listM80733c = m80733c(context, sb3.toString())) != null && listM80733c.size() > 0) {
            arrayList.addAll(listM80733c);
        }
        return arrayList;
    }

    /* renamed from: c */
    public static List<Contact> m80733c(Context context, String str) {
        Cursor cursorQuery;
        if (str.length() > 0) {
            try {
                cursorQuery = context.getContentResolver().query(f60533b, f60535d, "_id IN (" + str + ")", null, null);
            } catch (SQLException unused) {
                C13981a.m83988e("ContactHelper", "query contact call log failed");
            } catch (Exception unused2) {
                C13981a.m83988e("ContactHelper", "getContactsFromCallLogDB occur exception when query contact!");
            }
        } else {
            cursorQuery = null;
        }
        if (cursorQuery == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(10);
        while (cursorQuery.moveToNext()) {
            try {
                arrayList.add(new Contact(cursorQuery.getString(0), cursorQuery.getString(2), cursorQuery.getString(1)));
            } finally {
                cursorQuery.close();
            }
        }
        return arrayList;
    }

    /* renamed from: d */
    public static List<Contact> m80734d(Context context, String str) {
        Cursor cursorQuery;
        if (str.length() > 0) {
            try {
                cursorQuery = context.getContentResolver().query(f60532a, f60534c, "_id IN (" + str + ")", null, null);
            } catch (SQLException unused) {
                C13981a.m83988e("ContactHelper", "query contact data failed");
            } catch (Exception unused2) {
                C13981a.m83988e("ContactHelper", "getContactsFromDataDB occur exception when query contact!");
            }
        } else {
            cursorQuery = null;
        }
        if (cursorQuery == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(10);
        while (cursorQuery.moveToNext()) {
            try {
                String string = cursorQuery.getString(0);
                String strM80735e = m80735e(cursorQuery.getString(1));
                if (TextUtils.isEmpty(strM80735e)) {
                    strM80735e = cursorQuery.getString(1);
                }
                arrayList.add(new Contact(string, cursorQuery.getString(2), strM80735e));
            } catch (Throwable th2) {
                cursorQuery.close();
                throw th2;
            }
        }
        cursorQuery.close();
        return arrayList;
    }

    /* renamed from: e */
    public static String m80735e(String str) {
        String strM80736f = m80736f(str);
        if (TextUtils.isEmpty(strM80736f)) {
            return null;
        }
        return strM80736f;
    }

    /* renamed from: f */
    public static String m80736f(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder(16);
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            char cCharAt = str.charAt(i10);
            if (cCharAt == '+' && sb2.length() == 0) {
                sb2.append(cCharAt);
            } else if (Character.isDigit(cCharAt)) {
                sb2.append(cCharAt);
            }
        }
        return sb2.toString();
    }
}
