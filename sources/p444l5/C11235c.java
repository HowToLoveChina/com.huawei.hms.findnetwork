package p444l5;

import android.content.ContentValues;
import android.content.Context;
import android.os.Handler;
import android.provider.ContactsContract;
import com.huawei.android.backup.filelogic.utils.C2111d;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import p006a5.AbstractC0048c;

/* renamed from: l5.c */
/* loaded from: classes.dex */
public class C11235c extends C11236d {
    /* renamed from: A0 */
    public final int m67503A0(Context context, AbstractC0048c abstractC0048c, Handler.Callback callback, Object obj) throws Throwable {
        C2111d.m12653i("BackupContactHapCloneImp", "Restore clone contacts.");
        this.f52745e = m67505z0(abstractC0048c);
        this.f52747g = m67510o0(abstractC0048c, null, null);
        m67504B0(context, abstractC0048c, callback, obj);
        ContentValues[] contentValuesArrM200s = abstractC0048c.m200s("raw_contacts_me_tb", null, null, null, null);
        if (contentValuesArrM200s != null) {
            C2111d.m12653i("BackupContactHapCloneImp", "restore contact me data begin");
            if (!m67450j(context, C11241i.f52787l).isEmpty()) {
                C2111d.m12653i("BackupContactHapCloneImp", "local Contacts has Me data");
                return 0;
            }
            HashMap<Long, ContentValues> map = new HashMap<>(contentValuesArrM200s.length);
            int length = contentValuesArrM200s.length;
            long[] jArr = new long[length];
            int i10 = 0;
            for (ContentValues contentValues : contentValuesArrM200s) {
                if (i10 >= 0 && i10 < length) {
                    long jLongValue = contentValues.getAsLong("_id").longValue();
                    jArr[i10] = jLongValue;
                    map.put(Long.valueOf(jLongValue), contentValues);
                }
                i10++;
            }
            HashMap<Long, LinkedHashSet<ContentValues>> mapM67472I = m67472I(abstractC0048c, null, null, "data_me_tb");
            if (mapM67472I == null) {
                C2111d.m12653i("BackupContactHapCloneImp", "restore contact me data fail");
                return 0;
            }
            HashMap<Long, Long> map2 = new HashMap<>();
            m67493e0(new C11243k(context, callback, obj), map, mapM67472I, map2, ContactsContract.Profile.CONTENT_RAW_CONTACTS_URI);
            m67514s0(context, abstractC0048c, jArr, map2);
        }
        return 0;
    }

    /* renamed from: B0 */
    public final void m67504B0(Context context, AbstractC0048c abstractC0048c, Handler.Callback callback, Object obj) throws InterruptedException {
        Iterator<Map.Entry<String, C11239g>> it = this.f52745e.entrySet().iterator();
        while (it.hasNext()) {
            C11239g value = it.next().getValue();
            this.f52748h = null;
            C11243k c11243k = new C11243k(context, null, abstractC0048c, callback, obj);
            C2111d.m12654j("BackupContactHapCloneImp", "contact type is:", Integer.valueOf(value.m67539d()));
            if (value.m67539d() == 0) {
                this.f52748h = m67449i(context, null);
                this.f52749i = m67451k(context, "mimetype in ('vnd.android.cursor.item/organization', 'vnd.android.cursor.item/email_v2', 'vnd.android.cursor.item/phone_v2', 'vnd.android.cursor.item/website','vnd.android.cursor.item/name', 'vnd.android.cursor.item/nickname', 'vnd.android.cursor.item/group_membership') AND raw_contact_id in (select _id from raw_contacts where deleted=0 AND account_id in (select _id from accounts where account_type='com.android.huawei.phone'))", null);
                m67518w0(c11243k, "(ext_contact_type=0)", null);
            } else {
                m67517v0(c11243k, "(ext_account_type=? AND ext_account_name=?)", value.m67538c(), value.m67537b());
            }
        }
    }

    @Override // p444l5.C11236d, com.huawei.android.backup.service.logic.BackupObject
    public int onRestore(Context context, AbstractC0048c abstractC0048c, Handler.Callback callback, Object obj, String str) throws Throwable {
        int iM67503A0 = 5;
        if (abstractC0048c == null || !init(context, 2, abstractC0048c)) {
            C2111d.m12648d("BackupContactHapCloneImp", "init failed!");
            return 5;
        }
        try {
            iM67503A0 = m67503A0(context, abstractC0048c, callback, obj);
        } catch (IllegalArgumentException unused) {
            C2111d.m12648d("BackupContactHapCloneImp", "IllegalArgumentException: restoreCloneContacts faild");
            sendMsg(5, 0, 0, callback, obj);
        } catch (Exception unused2) {
            C2111d.m12648d("BackupContactHapCloneImp", "Exception: restoreCloneContacts faild");
            sendMsg(5, 0, 0, callback, obj);
        }
        m67458s(context);
        return iM67503A0;
    }

    /* renamed from: z0 */
    public final HashMap<String, C11239g> m67505z0(AbstractC0048c abstractC0048c) {
        HashMap<String, C11239g> map = new HashMap<>();
        ContentValues[] contentValuesArrM200s = abstractC0048c.m200s("raw_contacts_tb", new String[]{"ext_account_name", "ext_account_type", "ext_contact_type"}, null, null, null);
        if (contentValuesArrM200s == null) {
            return map;
        }
        for (ContentValues contentValues : contentValuesArrM200s) {
            String str = contentValues.getAsString("ext_account_name") + contentValues.getAsString("ext_account_type");
            if (!map.containsKey(str)) {
                map.put(str, new C11239g(contentValues.getAsString("ext_account_name"), contentValues.getAsString("ext_account_type"), contentValues.getAsInteger("ext_contact_type").intValue()));
            }
        }
        return map;
    }
}
