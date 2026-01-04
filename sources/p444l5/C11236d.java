package p444l5;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.os.Handler;
import android.provider.ContactsContract;
import android.text.TextUtils;
import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.android.backup.service.logic.BackupObject;
import com.huawei.android.backup.service.logic.C2126b;
import com.huawei.android.backup.service.utils.C2157a;
import com.huawei.android.remotecontrol.tag.p092ui.view.RippleView;
import com.huawei.hicloud.notification.constants.HNConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import p006a5.AbstractC0048c;
import p386j6.C10711a;
import p386j6.C10713c;

/* renamed from: l5.d */
/* loaded from: classes.dex */
public class C11236d extends AbstractC11234b {

    /* renamed from: q */
    public AbstractC0048c f52758q;

    /* renamed from: p */
    public boolean f52757p = false;

    /* renamed from: r */
    public boolean f52759r = false;

    /* renamed from: s */
    public boolean f52760s = false;

    /* renamed from: k0 */
    public final void m67506k0(ContentValues[] contentValuesArr, String str, String str2) {
        for (ContentValues contentValues : contentValuesArr) {
            contentValues.put("account_name", str);
            contentValues.put("account_type", str2);
        }
    }

    /* renamed from: l0 */
    public final int m67507l0(AbstractC0048c abstractC0048c) {
        int iM67510o0 = this.f52742b ? m67510o0(abstractC0048c, C11241i.f52785j, null) : -1;
        if (!this.f52757p) {
            return iM67510o0;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        String strM67511p0 = m67511p0(true, arrayList, "(account_type=? AND account_name=?)");
        return !TextUtils.isEmpty(strM67511p0) ? iM67510o0 + m67510o0(this.f52758q, strM67511p0, (String[]) arrayList.toArray(new String[arrayList.size()])) : iM67510o0;
    }

    /* renamed from: m0 */
    public final int m67508m0(AbstractC0048c abstractC0048c) {
        ArrayList<String> arrayList = new ArrayList<>();
        return m67510o0(abstractC0048c, m67511p0(false, arrayList, "(ext_account_type=? AND ext_account_name=?)"), (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    /* renamed from: n0 */
    public final void m67509n0(C11243k c11243k, ContentValues[] contentValuesArr, HashMap<Long, Long> map) throws InterruptedException {
        Context contextM67570c = c11243k.m67570c();
        if (contextM67570c == null) {
            return;
        }
        AbstractC0048c abstractC0048cM67574g = c11243k.m67574g();
        Handler.Callback callbackM67568a = c11243k.m67568a();
        Object objM67569b = c11243k.m67569b();
        this.f52759r = m67512q0(abstractC0048cM67574g, "ContactBigPhoto");
        this.f52760s = m67512q0(abstractC0048cM67574g, "ContactBigPhoto_camcard");
        C2111d.m12653i("BackupContactHapImp", "isNeedRestoreBigPhoto: " + this.f52759r + ", isNeedRestoreBigPhotoCamcard: " + this.f52760s);
        HashMap<Long, ContentValues> map2 = new HashMap<>(contentValuesArr.length);
        long[] jArr = new long[contentValuesArr.length];
        for (int i10 = 0; i10 < contentValuesArr.length; i10++) {
            long jLongValue = contentValuesArr[i10].getAsLong("_id").longValue();
            jArr[i10] = jLongValue;
            map2.put(Long.valueOf(jLongValue), contentValuesArr[i10]);
        }
        C2111d.m12654j("BackupContactHapImp", "doDataRestore, contact num valuesRaw.length = ", Integer.valueOf(contentValuesArr.length));
        ArrayList<String> arrayListM67477N = m67477N(jArr, 100);
        int i11 = 0;
        while (i11 < arrayListM67477N.size() && !BackupObject.isAbort()) {
            if (contentValuesArr.length > 20000) {
                try {
                    Thread.sleep(RippleView.SINGLE_RIPPLE_TIME);
                } catch (InterruptedException unused) {
                    C2111d.m12648d("BackupContactHapImp", "doDataRestore InterruptedException");
                }
            }
            HashMap<Long, Long> map3 = new HashMap<>();
            HashMap<Long, LinkedHashSet<ContentValues>> mapM67472I = m67472I(abstractC0048cM67574g, arrayListM67477N.get(i11), map, "data_tb");
            if (mapM67472I == null) {
                return;
            }
            m67490b0(new C11243k(callbackM67568a, objM67569b, this.f52748h, this.f52749i), map2, mapM67472I, map3);
            int i12 = i11;
            m67493e0(new C11243k(contextM67570c, callbackM67568a, objM67569b), map2, mapM67472I, map3, null);
            m67515t0(contextM67570c, abstractC0048cM67574g, jArr, map3, i12);
            map3.clear();
            i11 = i12 + 1;
        }
    }

    /* renamed from: o0 */
    public int m67510o0(AbstractC0048c abstractC0048c, String str, String[] strArr) {
        String[] strArr2 = {"_id"};
        Cursor cursorMo194l = null;
        try {
            if (abstractC0048c != null) {
                try {
                    cursorMo194l = abstractC0048c.mo194l("raw_contacts_tb", strArr2, str, strArr, null);
                } catch (SQLiteException unused) {
                    C2111d.m12648d("BackupContactHapImp", "getCount SQLiteException");
                    if (cursorMo194l != null) {
                    }
                } catch (Exception unused2) {
                    C2111d.m12648d("BackupContactHapImp", "getCount Exception");
                    if (cursorMo194l != null) {
                    }
                }
            }
            count = cursorMo194l != null ? cursorMo194l.getCount() : 0;
            if (cursorMo194l != null) {
                cursorMo194l.close();
            }
            return count;
        } catch (Throwable th2) {
            if (cursorMo194l != null) {
                cursorMo194l.close();
            }
            throw th2;
        }
    }

    @Override // com.huawei.android.backup.service.logic.BackupObject
    public int onBackup(Context context, AbstractC0048c abstractC0048c, Handler.Callback callback, Object obj, String str) {
        C2111d.m12653i("BackupContactHapImp", "Backup contact.");
        if (!m67444c(callback, obj)) {
            sendMsg(100, C2111d.m12652h("BackupContactHapImp", HNConstants.DataType.CONTACT, "onBackup", "ExecuteParameter does contains contact key"), callback, obj);
            return 2;
        }
        if (!init(context, 1, null) || abstractC0048c == null) {
            C2111d.m12648d("BackupContactHapImp", "init failed!");
            sendMsg(100, C2111d.m12652h("BackupContactHapImp", HNConstants.DataType.CONTACT, "onBackup", "init failed"), callback, obj);
            sendMsg(2, 0, 0, callback, obj);
            return 2;
        }
        String strValueOf = String.valueOf(ContactsContract.RawContacts.CONTENT_URI);
        addModuleUriInfo(strValueOf, true, true, m67456p(context));
        try {
            m67466C(context, abstractC0048c, callback, obj);
        } catch (C10711a unused) {
            C2111d.m12648d("BackupContactHapImp", "BackupException: backup contact");
            String strM12652h = C2111d.m12652h("BackupContactHapImp", HNConstants.DataType.CONTACT, "onBackup", "onBackup BackupException");
            sendMsg(100, strM12652h, callback, obj);
            attachUriInfo(strValueOf, C2126b.MODULE_INFO_ERROR_INFO, strM12652h);
            sendMsg(2, 0, 0, callback, obj);
            abstractC0048c.m190h();
        } catch (Exception unused2) {
            C2111d.m12648d("BackupContactHapImp", "Exception: backup contact err");
            String strM12652h2 = C2111d.m12652h("BackupContactHapImp", HNConstants.DataType.CONTACT, "onBackup", "onBackup Exception");
            sendMsg(100, strM12652h2, callback, obj);
            attachUriInfo(strValueOf, C2126b.MODULE_INFO_ERROR_INFO, strM12652h2);
            sendMsg(2, 0, 0, callback, obj);
            abstractC0048c.m190h();
        }
        attachUriInfo(strValueOf, "count", String.valueOf(this.f52754n));
        reportModuleBackupFinish(str, callback, obj);
        return 1;
    }

    @Override // com.huawei.android.backup.service.logic.BackupObject
    public int onRestore(Context context, AbstractC0048c abstractC0048c, Handler.Callback callback, Object obj, String str) throws Throwable {
        C2111d.m12653i("BackupContactHapImp", "Restore contact.");
        int iM67516u0 = 5;
        if (abstractC0048c == null || !init(context, 2, abstractC0048c)) {
            C2111d.m12648d("BackupContactHapImp", "init failed!");
            return 5;
        }
        if (!m67444c(callback, obj)) {
            return 2;
        }
        String strValueOf = String.valueOf(ContactsContract.Profile.CONTENT_RAW_CONTACTS_URI);
        addModuleUriInfo(strValueOf, true, true, m67456p(context));
        try {
            iM67516u0 = m67516u0(context, abstractC0048c, callback, obj);
        } catch (C10711a e10) {
            String str2 = "restoreContacts BackupException. error: " + e10.getMessage();
            C2111d.m12648d("BackupContactHapImp", str2);
            attachUriInfo(strValueOf, C2126b.MODULE_INFO_ERROR_INFO, str2);
            sendMsg(5, 0, 0, callback, obj);
        } catch (Exception e11) {
            String str3 = "restoreContacts Exception. error: " + e11.getMessage();
            C2111d.m12648d("BackupContactHapImp", str3);
            attachUriInfo(strValueOf, C2126b.MODULE_INFO_ERROR_INFO, str3);
            sendMsg(5, 0, 0, callback, obj);
        }
        attachUriInfo(strValueOf, "count", String.valueOf(this.f52754n));
        reportModuleRestoreFinish(str);
        m67458s(context);
        return iM67516u0;
    }

    /* renamed from: p0 */
    public final String m67511p0(boolean z10, ArrayList<String> arrayList, String str) {
        StringBuilder sbM67453m = m67453m(z10, arrayList, str);
        if (this.f52742b && !z10) {
            sbM67453m.append("(ext_contact_type=0)");
        }
        return sbM67453m.toString();
    }

    /* renamed from: q0 */
    public final boolean m67512q0(AbstractC0048c abstractC0048c, String str) {
        boolean z10 = false;
        if (abstractC0048c == null || str == null) {
            return false;
        }
        Cursor cursorMo194l = null;
        try {
            try {
                cursorMo194l = abstractC0048c.mo194l(str, null, null, null, null);
                if (cursorMo194l != null) {
                    if (cursorMo194l.moveToFirst()) {
                        z10 = true;
                    }
                }
            } catch (SQLiteException unused) {
                C2111d.m12648d("BackupContactHapImp", "hasRecords SQLiteException");
                if (cursorMo194l != null) {
                }
            } catch (Exception unused2) {
                C2111d.m12648d("BackupContactHapImp", "hasRecords Exception");
                if (cursorMo194l != null) {
                }
            }
            return z10;
        } finally {
            if (cursorMo194l != null) {
                cursorMo194l.close();
            }
        }
    }

    /* renamed from: r0 */
    public final void m67513r0(Context context, AbstractC0048c abstractC0048c, Handler.Callback callback, Object obj) throws InterruptedException {
        String str;
        C2111d.m12653i("BackupContactHapImp", "restoreAccountContact begin.");
        if (this.f52757p) {
            str = C11241i.f52785j;
            this.f52747g = m67507l0(abstractC0048c);
        } else {
            this.f52747g = m67508m0(abstractC0048c);
            str = "(ext_contact_type=0)";
        }
        String str2 = str;
        Iterator<Map.Entry<String, C11239g>> it = this.f52745e.entrySet().iterator();
        while (it.hasNext()) {
            C11239g value = it.next().getValue();
            this.f52748h = null;
            C11243k c11243k = new C11243k(context, null, abstractC0048c, callback, obj);
            if (value.m67539d() == 0) {
                C2111d.m12653i("BackupContactHapImp", "ContactType is VALUE_CONTACT_TYPE_PHONE");
                this.f52749i = m67451k(context, "mimetype in ('vnd.android.cursor.item/organization', 'vnd.android.cursor.item/email_v2', 'vnd.android.cursor.item/phone_v2', 'vnd.android.cursor.item/website','vnd.android.cursor.item/name', 'vnd.android.cursor.item/nickname', 'vnd.android.cursor.item/group_membership') AND raw_contact_id in (select _id from raw_contacts where deleted=0 AND account_id in (select _id from accounts where account_type='com.android.huawei.phone'))", null);
                this.f52748h = new HashSet<>(this.f52749i.keySet());
                m67518w0(c11243k, str2, null);
            } else {
                C2111d.m12653i("BackupContactHapImp", "ContactType is not VALUE_CONTACT_TYPE_PHONE");
                if (this.f52757p) {
                    m67517v0(new C11243k(context, null, this.f52758q, callback, obj), "(account_type=? AND account_name=?)", value.m67538c(), value.m67537b());
                } else {
                    m67517v0(c11243k, "(ext_account_type=? AND ext_account_name=?)", value.m67538c(), value.m67537b());
                }
            }
        }
    }

    /* renamed from: s0 */
    public void m67514s0(Context context, AbstractC0048c abstractC0048c, long[] jArr, HashMap<Long, Long> map) throws Throwable {
        if (map == null) {
            C2111d.m12653i("BackupContactHapImp", "restoreBigPhoto rawContactIdMap is null");
            return;
        }
        int size = map.size();
        for (int i10 = 0; i10 < size; i10++) {
            C2111d.m12654j("BackupContactHapImp", "restore contact me photo,size:", Integer.valueOf(size));
            if (i10 >= jArr.length) {
                return;
            }
            long j10 = jArr[i10];
            C11240h.m67546e(context, abstractC0048c, j10, map.get(Long.valueOf(j10)).longValue(), "ContactBigPhoto_me");
        }
    }

    /* renamed from: t0 */
    public final void m67515t0(Context context, AbstractC0048c abstractC0048c, long[] jArr, HashMap<Long, Long> map, int i10) throws InterruptedException {
        int length = jArr.length;
        int i11 = i10 * 100;
        int i12 = i11 + 100;
        C2111d.m12653i("BackupContactHapImp", "restoreBigPhoto start, start:" + i11 + ",totalSize:" + length + ",batchEndSize:" + i12);
        int i13 = 0;
        while (i11 < length && i11 < i12) {
            if (i13 == 49) {
                C2111d.m12653i("BackupContactHapImp", "restore bigPhoto num,j=" + i11 + ",breakPoint:" + i13);
                try {
                    Thread.sleep(300L);
                    i13 = 0;
                } catch (InterruptedException unused) {
                    C2111d.m12648d("BackupContactHapImp", "restore bigPhoto InterruptedException");
                }
            }
            Long l10 = map.get(Long.valueOf(jArr[i11]));
            if (l10 == null) {
                C2111d.m12648d("BackupContactHapImp", "Can not find raw_contact_id in rawContactIdMap");
            } else {
                if (this.f52759r) {
                    C2111d.m12646b("BackupContactHapImp", "isNeedRestoreBigPhoto is true, begin restore ContactBigPhoto");
                    if (C11240h.m67546e(context, abstractC0048c, jArr[i11], l10.longValue(), "ContactBigPhoto")) {
                        i13++;
                    }
                }
                if (this.f52760s) {
                    C2111d.m12646b("BackupContactHapImp", "isNeedRestoreBigPhotoCamcard is true, begin restore ContactBigPhoto_camcard");
                    if (C11240h.m67546e(context, abstractC0048c, jArr[i11], l10.longValue(), "ContactBigPhoto_camcard")) {
                        i13++;
                    }
                }
            }
            i11++;
        }
    }

    /* renamed from: u0 */
    public final int m67516u0(Context context, AbstractC0048c abstractC0048c, Handler.Callback callback, Object obj) throws Throwable {
        Bundle bundleM65393c = C10713c.m65393c(BackupObject.getExecuteParameter(), HNConstants.DataType.CONTACT);
        this.f52744d = new HashSet<>();
        this.f52743c = new HashSet<>();
        this.f52745e = m67443b(bundleM65393c);
        m67513r0(context, abstractC0048c, callback, obj);
        ContentValues[] contentValuesArrM200s = abstractC0048c.m200s("raw_contacts_me_tb", null, null, null, null);
        if (contentValuesArrM200s == null) {
            return 4;
        }
        C2111d.m12653i("BackupContactHapImp", "restore contact me data begin");
        HashMap<Long, ContentValues> map = new HashMap<>(contentValuesArrM200s.length);
        if (!m67450j(context, C11241i.f52787l).isEmpty()) {
            C2111d.m12653i("BackupContactHapImp", "local Contacts has Me data");
            return 0;
        }
        long[] jArr = new long[contentValuesArrM200s.length];
        for (int i10 = 0; i10 < contentValuesArrM200s.length; i10++) {
            long jLongValue = contentValuesArrM200s[i10].getAsLong("_id").longValue();
            jArr[i10] = jLongValue;
            map.put(Long.valueOf(jLongValue), contentValuesArrM200s[i10]);
        }
        HashMap<Long, LinkedHashSet<ContentValues>> mapM67472I = m67472I(abstractC0048c, null, null, "data_me_tb");
        if (mapM67472I == null) {
            C2111d.m12653i("BackupContactHapImp", "restore contact me data fail");
            return 0;
        }
        HashMap<Long, Long> map2 = new HashMap<>();
        m67493e0(new C11243k(context, callback, obj), map, mapM67472I, map2, ContactsContract.Profile.CONTENT_RAW_CONTACTS_URI);
        m67514s0(context, abstractC0048c, jArr, map2);
        return 4;
    }

    /* renamed from: v0 */
    public void m67517v0(C11243k c11243k, String str, String str2, String str3) throws InterruptedException {
        if (c11243k == null || c11243k.m67570c() == null) {
            C2111d.m12653i("BackupContactHapImp", "restoreNetAccountContact contactParameter is null");
            return;
        }
        Context contextM67570c = c11243k.m67570c();
        ContentValues[] contentValuesArrM200s = c11243k.m67574g().m200s("raw_contacts_tb", this.f52750j, str, new String[]{str2, str3}, null);
        if (contentValuesArrM200s == null || contentValuesArrM200s.length < 1) {
            C2111d.m12648d("BackupContactHapImp", "values_raw is null");
            return;
        }
        if (C2157a.m13167B(contextM67570c, str3, str2)) {
            C2111d.m12653i("BackupContactHapImp", "account is login");
            m67506k0(contentValuesArrM200s, str3, str2);
            this.f52748h = m67448h(contextM67570c, str3, str2);
        } else {
            C11237e.m67522b(contentValuesArrM200s);
            this.f52748h = m67449i(contextM67570c, null);
        }
        m67509n0(c11243k, contentValuesArrM200s, null);
    }

    /* renamed from: w0 */
    public int m67518w0(C11243k c11243k, String str, String[] strArr) throws InterruptedException {
        if (c11243k == null || c11243k.m67570c() == null) {
            C2111d.m12648d("BackupContactHapImp", "restorePhoneAccount contactParameter is null");
            return 5;
        }
        Context contextM67570c = c11243k.m67570c();
        AbstractC0048c abstractC0048cM67574g = c11243k.m67574g();
        ContentValues[] contentValuesArrM200s = abstractC0048cM67574g.m200s("raw_contacts_tb", this.f52750j, str, strArr, null);
        if (contentValuesArrM200s == null) {
            C2111d.m12648d("BackupContactHapImp", "values_raw is null");
            return 5;
        }
        C11237e.m67522b(contentValuesArrM200s);
        HashMap<Long, Long> mapM67495g0 = m67495g0(contextM67570c, abstractC0048cM67574g);
        HashMap<Long, Long> map = new HashMap<>();
        m67509n0(c11243k, contentValuesArrM200s, mapM67495g0);
        if (m67491c0(contextM67570c, abstractC0048cM67574g, map) != 2) {
            return 4;
        }
        C2111d.m12648d("BackupContactHapImp", "restore table agg_exceptions failed.");
        return 4;
    }

    @Override // com.huawei.android.backup.service.logic.BackupObject
    public int writeModuleInfo(AbstractC0048c abstractC0048c) {
        writeNetContactModuleInfo(abstractC0048c);
        return super.writeModuleInfo(abstractC0048c);
    }

    /* renamed from: x0 */
    public void m67519x0(boolean z10) {
        this.f52757p = z10;
    }

    /* renamed from: y0 */
    public void m67520y0(AbstractC0048c abstractC0048c) {
        this.f52758q = abstractC0048c;
    }
}
