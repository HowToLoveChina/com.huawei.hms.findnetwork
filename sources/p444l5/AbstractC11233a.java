package p444l5;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.SyncAdapterType;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.ContactsContract;
import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.android.backup.service.logic.BackupObject;
import com.huawei.android.backup.service.logic.contact.dao.DefaultContactConditionBuilder;
import com.huawei.android.backup.service.utils.C2157a;
import com.huawei.hicloud.notification.constants.HNConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import p386j6.C10711a;
import p386j6.C10713c;
import p444l5.C11241i;
import p470m5.C11414a;
import p699v4.C13347p;

/* renamed from: l5.a */
/* loaded from: classes.dex */
public abstract class AbstractC11233a extends BackupObject {

    /* renamed from: c */
    public HashSet<String> f52743c;

    /* renamed from: d */
    public HashSet<String> f52744d;

    /* renamed from: e */
    public HashMap<String, C11239g> f52745e;

    /* renamed from: a */
    public boolean f52741a = false;

    /* renamed from: b */
    public boolean f52742b = false;

    /* renamed from: f */
    public String[] f52746f = null;

    /* renamed from: f */
    public static ArrayList<C11239g> m67440f(Context context) {
        ArrayList<C11239g> arrayList = new ArrayList<>();
        for (String str : C11241i.f52788m) {
            arrayList.add(new C11239g("", str, 2));
        }
        AccountManager accountManager = AccountManager.get(context);
        if (accountManager == null) {
            return arrayList;
        }
        SyncAdapterType[] syncAdapterTypes = ContentResolver.getSyncAdapterTypes();
        HashSet hashSet = new HashSet(syncAdapterTypes.length);
        for (SyncAdapterType syncAdapterType : syncAdapterTypes) {
            if ("com.android.contacts".equals(syncAdapterType.authority) && syncAdapterType.isUserVisible() && !C11241i.f52776a.equals(syncAdapterType.accountType)) {
                hashSet.add(syncAdapterType.accountType);
            }
        }
        for (Account account : accountManager.getAccounts()) {
            if (account != null && hashSet.contains(account.type) && !"com.xiaomi".equals(account.type)) {
                arrayList.add(new C11239g(account.name, account.type, 2));
            }
        }
        return arrayList;
    }

    /* renamed from: r */
    public static boolean m67441r(Context context) {
        Uri uriM80079b = C13347p.m80079b("content://com.android.contacts/feature");
        Cursor cursorQuery = null;
        try {
            if (context != null) {
                try {
                    cursorQuery = context.getContentResolver().query(uriM80079b, null, null, null, null);
                } catch (IllegalArgumentException unused) {
                    C2111d.m12648d("BackupContact", "isSupportLunarBirthday IllegalArgumentException");
                    if (cursorQuery != null) {
                    }
                } catch (Exception unused2) {
                    C2111d.m12648d("BackupContact", "isSupportLunarBirthday Exception");
                    if (cursorQuery != null) {
                    }
                }
            }
            if (cursorQuery != null) {
                cursorQuery.moveToFirst();
                if ("1".equals(cursorQuery.getString(cursorQuery.getColumnIndex("is_support_lunar_birthday")))) {
                    cursorQuery.close();
                    return true;
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            if (!C2111d.m12655k()) {
                return false;
            }
            C2111d.m12653i("BackupContact", "do not support lunar birthday.");
            return false;
        } catch (Throwable th2) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th2;
        }
    }

    /* renamed from: a */
    public void m67442a(ContentValues contentValues) {
        if (contentValues != null) {
            String asString = contentValues.getAsString("account_name");
            String asString2 = contentValues.getAsString("account_type");
            contentValues.put("account_type", C11241i.f52776a);
            contentValues.put("account_name", "Phone");
            contentValues.put("ext_account_type", asString2);
            contentValues.put("ext_account_name", asString);
            contentValues.put("ext_contact_type", Integer.valueOf(this.f52743c.contains(asString2) ? 2 : this.f52744d.contains(asString2) ? 1 : 0));
        }
    }

    /* renamed from: b */
    public HashMap<String, C11239g> m67443b(Bundle bundle) throws C10711a {
        if (bundle == null) {
            throw new C10711a("contactBundle is null ");
        }
        HashMap<String, C11239g> map = new HashMap<>(bundle.keySet().size());
        Iterator<String> it = bundle.keySet().iterator();
        while (it.hasNext()) {
            Bundle bundleM65393c = C10713c.m65393c(bundle, it.next());
            if (bundleM65393c == null || !bundleM65393c.containsKey("AccountType")) {
                throw new C10711a("contact bundle parameter does not contained AccountType");
            }
            String strM65400j = C10713c.m65400j(bundleM65393c, "AccountType");
            String strM65400j2 = C10713c.m65400j(bundleM65393c, "AccountName");
            int iM65394d = C10713c.m65394d(bundleM65393c, "ContactType");
            map.put(strM65400j + strM65400j2, new C11239g(strM65400j2, strM65400j, iM65394d));
            if (iM65394d == 0) {
                this.f52742b = true;
            }
        }
        return map;
    }

    /* renamed from: c */
    public boolean m67444c(Handler.Callback callback, Object obj) {
        if (BackupObject.getExecuteParameter().containsKey(HNConstants.DataType.CONTACT)) {
            return true;
        }
        C2111d.m12648d("BackupContact", "ExecuteParameter does contains contact key!");
        sendMsg(2, 0, 0, callback, obj);
        return false;
    }

    /* renamed from: d */
    public final HashMap<String, C11239g> m67445d(Context context) {
        HashMap<String, C11239g> map = new HashMap<>();
        if (context == null) {
            C2111d.m12648d("BackupContact", "getAllAccountContactCount : context is null");
            return map;
        }
        DefaultContactConditionBuilder defaultContactConditionBuilder = new DefaultContactConditionBuilder(context);
        defaultContactConditionBuilder.addBuilder(new C11414a(context, true));
        String strBuild = defaultContactConditionBuilder.build();
        Cursor cursorQuery = null;
        try {
            try {
                try {
                    cursorQuery = context.getContentResolver().query(ContactsContract.RawContacts.CONTENT_URI, new String[]{"account_name", "account_type"}, strBuild, null, null);
                } catch (Exception unused) {
                    C2111d.m12648d("BackupContact", "getAllAccountContactCount Exception");
                    if (0 != 0) {
                    }
                }
            } catch (IllegalArgumentException unused2) {
                C2111d.m12648d("BackupContact", "getAllAccountContactCount IllegalArgumentException");
                if (0 != 0) {
                }
            }
            if (cursorQuery != null && cursorQuery.moveToFirst()) {
                int columnIndex = cursorQuery.getColumnIndex("account_name");
                int columnIndex2 = cursorQuery.getColumnIndex("account_type");
                StringBuilder sb2 = new StringBuilder();
                if (columnIndex != -1 && columnIndex2 != -1) {
                    do {
                        String string = cursorQuery.getString(columnIndex2);
                        String string2 = cursorQuery.getString(columnIndex);
                        sb2.delete(0, sb2.length());
                        sb2.append(string2);
                        sb2.append("-");
                        sb2.append(string);
                        String string3 = sb2.toString();
                        if (!map.containsKey(string3)) {
                            map.put(string3, new C11239g(string2, string));
                        }
                        map.get(string3).m67536a();
                    } while (cursorQuery.moveToNext());
                }
                cursorQuery.close();
                return map;
            }
            C2111d.m12648d("BackupContact", "getAllAccountContactCount cursor is null or empty");
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return map;
        } catch (Throwable th2) {
            if (0 != 0) {
                cursorQuery.close();
            }
            throw th2;
        }
    }

    /* renamed from: e */
    public int m67446e(Context context, String str, String[] strArr) {
        Cursor cursorQuery = null;
        int count = -1;
        try {
            if (context != null) {
                try {
                    cursorQuery = context.getContentResolver().query(C11241i.d.f52797a, new String[]{"_id"}, str, strArr, null);
                } catch (IllegalArgumentException unused) {
                    C2111d.m12648d("BackupContact", "getBackupItemCount IllegalArgumentException");
                    if (cursorQuery != null) {
                    }
                } catch (Exception unused2) {
                    C2111d.m12648d("BackupContact", "Contact isn't exist");
                    if (cursorQuery != null) {
                    }
                }
            }
            if (cursorQuery != null && cursorQuery.moveToFirst()) {
                count = cursorQuery.getCount();
                C2111d.m12653i("BackupContact", "get contact count number, result:" + count);
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return count;
        } catch (Throwable th2) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th2;
        }
    }

    /* renamed from: g */
    public final Bundle m67447g(Context context, int i10, long j10, HashMap<String, C11239g> map) {
        m67460u(context, map);
        Bundle bundle = new Bundle();
        Bundle bundleM67455o = m67455o();
        int iM67540e = 0;
        for (Map.Entry<String, C11239g> entry : map.entrySet()) {
            C11239g value = entry.getValue();
            if (value.m67539d() == 0) {
                iM67540e += value.m67540e();
            } else if (i10 != 0) {
                C2111d.m12653i("BackupContact", "getContactCountBundle 1 totalCount = " + i10);
                long jM67540e = (((long) value.m67540e()) * j10) / ((long) i10);
                Bundle bundle2 = new Bundle();
                m67459t(value, jM67540e, bundle2);
                bundle.putBundle(entry.getKey(), bundle2);
            }
        }
        if (iM67540e > 0 && i10 != 0) {
            C2111d.m12653i("BackupContact", "getContactCountBundle 2 totalCount = " + i10);
            m67461v(bundleM67455o, iM67540e, (j10 * ((long) iM67540e)) / ((long) i10));
            bundle.putBundle("Phone", bundleM67455o);
        }
        return bundle;
    }

    /* renamed from: h */
    public HashSet<Integer> m67448h(Context context, String str, String str2) {
        return m67452l(context, "mimetype in ('vnd.android.cursor.item/organization', 'vnd.android.cursor.item/email_v2', 'vnd.android.cursor.item/phone_v2', 'vnd.android.cursor.item/website') AND raw_contact_id in (select _id from raw_contacts where deleted=0 AND account_id in (select _id from accounts where account_type=? AND account_name=?))", new String[]{str2, str}, null);
    }

    /* renamed from: i */
    public HashSet<Integer> m67449i(Context context, Uri uri) {
        return m67452l(context, "mimetype in ('vnd.android.cursor.item/organization', 'vnd.android.cursor.item/email_v2', 'vnd.android.cursor.item/phone_v2', 'vnd.android.cursor.item/website','vnd.android.cursor.item/name', 'vnd.android.cursor.item/nickname', 'vnd.android.cursor.item/group_membership') AND raw_contact_id in (select _id from raw_contacts where deleted=0 AND account_id in (select _id from accounts where account_type='com.android.huawei.phone'))", null, uri);
    }

    @Override // com.huawei.android.backup.service.logic.BackupObject
    public boolean isSupported(Context context, String str) {
        return true;
    }

    /* renamed from: j */
    public HashSet<Integer> m67450j(Context context, Uri uri) {
        return m67452l(context, "mimetype in ('vnd.android.cursor.item/organization', 'vnd.android.cursor.item/email_v2','vnd.android.cursor.item/phone_v2', 'vnd.android.cursor.item/website','vnd.android.cursor.item/name', 'vnd.android.cursor.item/nickname','vnd.android.cursor.item/group_membership') AND raw_contact_id in (select _id from raw_contacts where deleted=0)", null, uri);
    }

    /* renamed from: k */
    public HashMap<Integer, Long> m67451k(Context context, String str, String[] strArr) {
        HashMap<Integer, Long> map = new HashMap<>();
        Cursor cursorQuery = null;
        try {
            if (context != null) {
                try {
                    cursorQuery = context.getContentResolver().query(ContactsContract.Data.CONTENT_URI, this.f52746f, str, strArr, "raw_contact_id");
                } catch (IllegalArgumentException unused) {
                    C2111d.m12648d("BackupContact", "getLocalDataHashMap IllegalArgumentException.");
                    if (cursorQuery != null) {
                    }
                } catch (Exception unused2) {
                    C2111d.m12648d("BackupContact", "getLocalDataHashMap Exception.");
                    if (cursorQuery != null) {
                    }
                }
            }
            if (cursorQuery != null && cursorQuery.moveToFirst()) {
                ArrayList arrayList = new ArrayList();
                ContentValues contentValuesM13213u = C2157a.m13213u(cursorQuery, C11241i.b.m67548a());
                arrayList.add(contentValuesM13213u);
                long jLongValue = contentValuesM13213u.getAsLong("raw_contact_id").longValue();
                while (cursorQuery.moveToNext()) {
                    ContentValues contentValuesM13213u2 = C2157a.m13213u(cursorQuery, C11241i.b.m67548a());
                    long jLongValue2 = contentValuesM13213u2.getAsLong("raw_contact_id").longValue();
                    if (jLongValue == jLongValue2) {
                        arrayList.add(contentValuesM13213u2);
                    } else {
                        map.put(Integer.valueOf(m67457q(arrayList)), Long.valueOf(jLongValue));
                        arrayList.clear();
                        arrayList.add(contentValuesM13213u2);
                        jLongValue = jLongValue2;
                    }
                }
                map.put(Integer.valueOf(m67457q(arrayList)), Long.valueOf(jLongValue));
                cursorQuery.close();
                return map;
            }
            return map;
        } finally {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        }
    }

    /* renamed from: l */
    public final HashSet<Integer> m67452l(Context context, String str, String[] strArr, Uri uri) {
        HashSet<Integer> hashSet = new HashSet<>();
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = uri == null ? context.getContentResolver().query(ContactsContract.Data.CONTENT_URI, this.f52746f, str, strArr, "raw_contact_id") : context.getContentResolver().query(uri, this.f52746f, str, strArr, "raw_contact_id");
            } catch (IllegalArgumentException unused) {
                C2111d.m12648d("BackupContact", "getLocalDataHashSet IllegalArgumentException.");
                if (cursorQuery != null) {
                }
            } catch (Exception unused2) {
                C2111d.m12648d("BackupContact", "getLocalDataHashSet Exception.");
                if (cursorQuery != null) {
                }
            }
            if (cursorQuery != null && cursorQuery.moveToFirst()) {
                ArrayList arrayList = new ArrayList();
                ContentValues contentValuesM13213u = C2157a.m13213u(cursorQuery, C11241i.b.m67548a());
                arrayList.add(contentValuesM13213u);
                long jLongValue = contentValuesM13213u.getAsLong("raw_contact_id").longValue();
                while (cursorQuery.moveToNext()) {
                    ContentValues contentValuesM13213u2 = C2157a.m13213u(cursorQuery, C11241i.b.m67548a());
                    if (jLongValue == contentValuesM13213u2.getAsLong("raw_contact_id").longValue()) {
                        arrayList.add(contentValuesM13213u2);
                    } else {
                        hashSet.add(Integer.valueOf(m67457q(arrayList)));
                        arrayList.clear();
                        arrayList.add(contentValuesM13213u2);
                        jLongValue = contentValuesM13213u2.getAsLong("raw_contact_id").longValue();
                    }
                }
                hashSet.add(Integer.valueOf(m67457q(arrayList)));
                cursorQuery.close();
                return hashSet;
            }
            return hashSet;
        } finally {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        }
    }

    /* renamed from: m */
    public StringBuilder m67453m(boolean z10, ArrayList<String> arrayList, String str) {
        StringBuilder sb2 = new StringBuilder();
        Iterator<String> it = this.f52745e.keySet().iterator();
        boolean z11 = false;
        while (it.hasNext()) {
            C11239g c11239g = this.f52745e.get(it.next());
            if (c11239g != null && c11239g.m67539d() != 0) {
                sb2.append(str);
                if (arrayList != null) {
                    arrayList.add(c11239g.m67538c());
                    arrayList.add(c11239g.m67537b());
                }
                if (c11239g.m67539d() == 1) {
                    this.f52744d.add(c11239g.m67538c());
                } else {
                    this.f52743c.add(c11239g.m67538c());
                }
                sb2.append(" or ");
                z11 = true;
            }
        }
        if (z11 && (!this.f52742b || z10)) {
            sb2.delete(sb2.length() - 4, sb2.length());
        }
        return sb2;
    }

    /* renamed from: n */
    public final ArrayList<String> m67454n(Context context) {
        ArrayList<C11239g> arrayListM67440f = m67440f(context);
        ArrayList<String> arrayList = new ArrayList<>(arrayListM67440f.size());
        for (C11239g c11239g : arrayListM67440f) {
            if (!arrayList.contains(c11239g.m67538c())) {
                arrayList.add(c11239g.m67538c());
            }
        }
        return arrayList;
    }

    /* renamed from: o */
    public final Bundle m67455o() {
        Bundle bundle = new Bundle();
        bundle.putString("AccountName", "Phone");
        bundle.putString("AccountType", C11241i.f52776a);
        bundle.putInt("ContactType", 0);
        return bundle;
    }

    @Override // com.huawei.android.backup.service.logic.BackupObject
    public Bundle onBackupModulesDataItemTotal(Context context, Long l10, int i10, String str) {
        int iM67456p = m67456p(context);
        C2111d.m12654j("BackupContact", "onBackupModulesDataItemTotal begin,moduleName: ", str, ",totalNumber: ", Integer.valueOf(iM67456p), ",packageSize: ", l10);
        if (iM67456p > 0) {
            return m67447g(context, iM67456p, getAppInfoSize(context, l10.longValue(), iM67456p), m67445d(context));
        }
        return null;
    }

    /* renamed from: p */
    public int m67456p(Context context) {
        C2111d.m12653i("BackupContact", "Get total contact count.");
        return m67446e(context, null, null);
    }

    /* renamed from: q */
    public final int m67457q(List<ContentValues> list) {
        C11242j c11242j = new C11242j();
        for (ContentValues contentValues : list) {
            if (contentValues != null) {
                c11242j.m67560h(contentValues);
            }
        }
        return C2157a.m13214v(C11242j.m67555c(c11242j));
    }

    /* renamed from: s */
    public void m67458s(Context context) {
        C2111d.m12653i("BackupContact", "Send broadcast to refresh after restoring.");
        if (BackupObject.getFollowingRestoreModules().contains("calllog")) {
            C2111d.m12657m("BackupContact", "wait CallLog restore done");
        } else {
            BackupObject.sendBroadcastToContactAfterRestore(context);
        }
    }

    /* renamed from: t */
    public final void m67459t(C11239g c11239g, long j10, Bundle bundle) {
        bundle.putString("AccountName", c11239g.m67537b());
        bundle.putString("AccountType", c11239g.m67538c());
        bundle.putInt("ModuleCount", c11239g.m67540e());
        bundle.putInt("ContactType", c11239g.m67539d());
        bundle.putLong("ModuleSize", j10);
    }

    /* renamed from: u */
    public final void m67460u(Context context, HashMap<String, C11239g> map) {
        ArrayList<String> arrayListM67454n = m67454n(context);
        Iterator<Map.Entry<String, C11239g>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            C11239g value = it.next().getValue();
            if (arrayListM67454n.contains(value.m67538c())) {
                value.m67541f(2);
            } else if (value.m67538c() == null || !value.m67538c().toLowerCase(Locale.ENGLISH).contains("sim")) {
                value.m67541f(0);
            } else {
                value.m67541f(1);
            }
        }
    }

    /* renamed from: v */
    public final void m67461v(Bundle bundle, int i10, long j10) {
        bundle.putInt("ModuleCount", i10);
        bundle.putInt("ContactType", 0);
        bundle.putLong("ModuleSize", j10);
    }
}
