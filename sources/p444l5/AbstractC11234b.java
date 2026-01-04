package p444l5;

import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentValues;
import android.content.Context;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.provider.ContactsContract;
import android.text.TextUtils;
import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.android.backup.service.logic.BackupObject;
import com.huawei.android.backup.service.logic.contact.dao.DefaultContactConditionBuilder;
import com.huawei.android.backup.service.utils.C2157a;
import com.huawei.android.hicloud.cloudbackup.process.CloneService;
import com.huawei.hicloud.notification.constants.HNConstants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import p006a5.AbstractC0048c;
import p279f6.C9660c;
import p279f6.C9662e;
import p386j6.C10711a;
import p386j6.C10713c;
import p444l5.C11241i;
import p470m5.C11414a;
import p699v4.C13333b;
import p699v4.C13342k;
import p699v4.C13348q;

/* renamed from: l5.b */
/* loaded from: classes.dex */
public abstract class AbstractC11234b extends AbstractC11233a {

    /* renamed from: n */
    public int f52754n;

    /* renamed from: g */
    public int f52747g = 0;

    /* renamed from: h */
    public HashSet<Integer> f52748h = null;

    /* renamed from: i */
    public HashMap<Integer, Long> f52749i = null;

    /* renamed from: j */
    public String[] f52750j = null;

    /* renamed from: k */
    public HashSet<Long> f52751k = new HashSet<>(16);

    /* renamed from: l */
    public String[] f52752l = null;

    /* renamed from: m */
    public String[] f52753m = null;

    /* renamed from: o */
    public int f52755o = 0;

    /* renamed from: l5.b$a */
    public class a implements b {
        public a() {
        }

        @Override // p444l5.AbstractC11234b.b
        /* renamed from: a */
        public void mo67502a(C11244l c11244l) {
            if (c11244l == null || !c11244l.m67576a()) {
                return;
            }
            C2111d.m12646b("BackupContactHap", "removeBackupDuplicateData hashCallBackInfo");
            c11244l.m67579d();
            c11244l.m67580e();
            AbstractC11234b abstractC11234b = AbstractC11234b.this;
            abstractC11234b.sendMsg(3, AbstractC11234b.m67463w(abstractC11234b), AbstractC11234b.this.f52747g, c11244l.m67577b(), c11244l.m67578c());
        }
    }

    /* renamed from: l5.b$b */
    public interface b {
        /* renamed from: a */
        void mo67502a(C11244l c11244l);
    }

    /* renamed from: R */
    public static boolean m67462R(Context context) {
        if (context != null) {
            return context.getSharedPreferences("config_info", 4).getBoolean("new_device_support_me", false);
        }
        C2111d.m12653i("BackupContactHap", "getNewPhoneSupportMeClone context is null");
        return false;
    }

    /* renamed from: w */
    public static /* synthetic */ int m67463w(AbstractC11234b abstractC11234b) {
        int i10 = abstractC11234b.f52755o;
        abstractC11234b.f52755o = i10 + 1;
        return i10;
    }

    /* renamed from: A */
    public int m67464A(Context context, String str, AbstractC0048c abstractC0048c) throws Throwable {
        C2111d.m12653i("BackupContactHap", "Backup contact me data info.");
        HashMap<Long, ContentValues> mapM67481S = m67481S(context, ContactsContract.Profile.CONTENT_RAW_CONTACTS_URI, str, null);
        if (C13348q.m80083c(mapM67481S) || abstractC0048c == null) {
            C2111d.m12653i("BackupContactHap", "backupContactMeDataInfo no me data to backup.");
            return 0;
        }
        C2111d.m12654j("BackupContactHap", "backupContactMeDataInfo meRawContactsMap size = ", Integer.valueOf(mapM67481S.size()));
        int iMo186B = abstractC0048c.mo186B("raw_contacts_me_tb", (ContentValues[]) mapM67481S.values().toArray(new ContentValues[0]), null, null);
        if (iMo186B != 1) {
            C2111d.m12648d("BackupContactHap", "backup me raw contacts fail");
            return storeHandlerMsgToObjectMsg(iMo186B);
        }
        ArrayList arrayList = new ArrayList(500);
        int i10 = 0;
        for (Long l10 : mapM67481S.keySet()) {
            if (i10 < 500) {
                arrayList.add(l10);
                i10++;
            } else {
                m67489a0(context, arrayList, abstractC0048c);
                arrayList.clear();
                arrayList.add(l10);
                i10 = 1;
            }
        }
        m67489a0(context, arrayList, abstractC0048c);
        return 0;
    }

    /* renamed from: B */
    public final int m67465B(Context context, AbstractC0048c abstractC0048c) {
        C2111d.m12653i("BackupContactHap", "Backup contacts agg raw.");
        if (context != null) {
            try {
                if (this.f52752l != null) {
                    return m67498j0(abstractC0048c, context.getContentResolver().query(ContactsContract.AggregationExceptions.CONTENT_URI, this.f52752l, null, null, null));
                }
            } catch (IllegalArgumentException unused) {
                C2111d.m12648d("BackupContactHap", "IllegalArgumentException: query agg_exceptions failed.");
            } catch (Exception unused2) {
                C2111d.m12648d("BackupContactHap", "Exception: query agg_exceptions failed.");
                return 1;
            }
        }
        return 1;
    }

    /* renamed from: C */
    public int m67466C(Context context, AbstractC0048c abstractC0048c, Handler.Callback callback, Object obj) throws C10711a {
        Bundle bundleM65393c = C10713c.m65393c(BackupObject.getExecuteParameter(), HNConstants.DataType.CONTACT);
        if (bundleM65393c == null) {
            C2111d.m12648d("BackupContactHap", "backupContactsDataRaw fail:contactBundle is null");
            return 2;
        }
        this.f52745e = m67443b(bundleM65393c);
        this.f52744d = new HashSet<>(16);
        this.f52743c = new HashSet<>(16);
        m67484V();
        DefaultContactConditionBuilder defaultContactConditionBuilder = new DefaultContactConditionBuilder(context);
        defaultContactConditionBuilder.addBuilder(new C11414a(context, false));
        String strBuild = defaultContactConditionBuilder.build();
        if (m67501z(new C11243k(context, null, abstractC0048c, callback, obj), strBuild, null) == 2) {
            C2111d.m12648d("BackupContactHap", "backup table contact_raw failed.");
        }
        if (m67465B(context, abstractC0048c) == 2) {
            C2111d.m12648d("BackupContactHap", "backup table agg_exceptions failed.");
        }
        if (m67467D(context, abstractC0048c, strBuild, null) == 2) {
            C2111d.m12648d("BackupContactHap", "backup table groups failed.");
        }
        int iM65395e = C10713c.m65395e(BackupObject.getExecuteParameter(), CloneService.KEY_ACTION_FLAG, -1);
        if (iM65395e == 10 || m67462R(context)) {
            C2111d.m12653i("BackupContactHap", "backup contact me,actionFlag:" + iM65395e);
            if (m67464A(context, strBuild, abstractC0048c) == 2) {
                C2111d.m12648d("BackupContactHap", "backup contact me failed");
            }
        }
        if (abstractC0048c != null) {
            abstractC0048c.mo171c();
            if (this.f52754n < 1) {
                abstractC0048c.m190h();
                this.backupFileModuleInfo.resetRecordTotal();
            } else {
                m67499x(context, abstractC0048c.m198p());
                this.backupFileModuleInfo.updateModuleInfo(this.f52754n, 14, "raw_contacts;data");
            }
        }
        return 1;
    }

    /* renamed from: D */
    public final int m67467D(Context context, AbstractC0048c abstractC0048c, String str, String[] strArr) {
        C2111d.m12653i("BackupContactHap", "Backup contacts groups.");
        C9662e c9662e = new C9662e(ContactsContract.Groups.CONTENT_URI, this.f52753m, str, strArr, null);
        c9662e.m60337g(C11241i.c.m67550a());
        ContentValues[] backupValues = BackupObject.getBackupValues(context, c9662e);
        if (backupValues.length == 0) {
            return 2;
        }
        try {
            abstractC0048c.mo186B("groups_tb", backupValues, null, null);
            return 0;
        } catch (SQLiteException unused) {
            C2111d.m12648d("BackupContactHap", "SQLiteException: backup group record failed.");
            return 2;
        } catch (Exception unused2) {
            C2111d.m12648d("BackupContactHap", "Exception: backup group record failed.");
            return 2;
        }
    }

    /* renamed from: E */
    public final void m67468E(Context context, ContentValues[] contentValuesArr, AbstractC0048c abstractC0048c) throws IOException {
        if (abstractC0048c.mo186B("data_me_tb", contentValuesArr, null, null) != 1) {
            C2111d.m12653i("BackupContactHap", "backup me data fail.");
            return;
        }
        HashMap map = new HashMap();
        for (ContentValues contentValues : contentValuesArr) {
            if (BackupObject.isAbort()) {
                break;
            }
            C11237e.m67526f(contentValues, map);
        }
        for (Map.Entry entry : map.entrySet()) {
            C11240h.m67542a(context, abstractC0048c, ((Long) entry.getKey()).longValue(), (String) entry.getValue(), "ContactBigPhoto_me");
        }
    }

    /* renamed from: F */
    public final void m67469F(AbstractC0048c abstractC0048c, ContentValues contentValues, int i10, Handler.Callback callback, Object obj) {
        if (abstractC0048c == null) {
            C2111d.m12648d("BackupContactHap", "backupRaw : storeHandler is null");
            return;
        }
        m67442a(contentValues);
        int i11 = 2;
        if (abstractC0048c.m185A("raw_contacts_tb", contentValues) == 2) {
            C2111d.m12648d("BackupContactHap", "contact isn't exist or write to raw_contacts failed.");
        } else {
            m67479P(contentValues);
            i11 = 0;
        }
        int i12 = i11;
        int i13 = this.f52755o + 1;
        this.f52755o = i13;
        sendMsg(i12, i13, i10, callback, obj);
    }

    /* JADX WARN: Removed duplicated region for block: B:129:0x0102 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:130:? A[LOOP:0: B:69:0x0016->B:130:?, LOOP_END, SYNTHETIC] */
    /* renamed from: G */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m67470G(p444l5.C11243k r14, java.util.Set<java.lang.Long> r15, java.util.HashMap<java.lang.Long, android.content.ContentValues> r16, java.util.HashMap<java.lang.Long, java.lang.String> r17, java.util.HashMap<java.lang.Long, java.lang.String> r18) throws java.lang.Exception {
        /*
            r13 = this;
            r0 = r15
            java.lang.String r1 = "Backup selected contacts."
            java.lang.String r2 = "BackupContactHap"
            com.huawei.android.backup.filelogic.utils.C2111d.m12653i(r2, r1)
            android.database.Cursor r1 = r14.m67571d()
            java.lang.String r3 = "raw_contact_id"
            int r1 = r1.getColumnIndexOrThrow(r3)
            int r9 = r16.size()
        L16:
            boolean r3 = com.huawei.android.backup.service.logic.BackupObject.isAbort()
            if (r3 == 0) goto L1e
            goto L102
        L1e:
            android.database.Cursor r3 = r14.m67571d()     // Catch: java.lang.Exception -> L6a android.database.sqlite.SQLiteException -> L6d
            long r10 = r3.getLong(r1)     // Catch: java.lang.Exception -> L6a android.database.sqlite.SQLiteException -> L6d
            java.lang.Long r3 = java.lang.Long.valueOf(r10)     // Catch: java.lang.Exception -> L6a android.database.sqlite.SQLiteException -> L6d
            boolean r3 = r15.contains(r3)     // Catch: java.lang.Exception -> L6a android.database.sqlite.SQLiteException -> L6d
            if (r3 != 0) goto L70
            java.lang.Long r3 = java.lang.Long.valueOf(r10)     // Catch: java.lang.Exception -> L6a android.database.sqlite.SQLiteException -> L6d
            r15.add(r3)     // Catch: java.lang.Exception -> L6a android.database.sqlite.SQLiteException -> L6d
            java.lang.Long r3 = java.lang.Long.valueOf(r10)     // Catch: java.lang.Exception -> L6a android.database.sqlite.SQLiteException -> L6d
            r12 = r16
            java.lang.Object r3 = r12.get(r3)     // Catch: java.lang.Exception -> L5e android.database.sqlite.SQLiteException -> L64
            r5 = r3
            android.content.ContentValues r5 = (android.content.ContentValues) r5     // Catch: java.lang.Exception -> L5e android.database.sqlite.SQLiteException -> L64
            if (r5 != 0) goto L4c
            r6 = r17
        L48:
            r5 = r18
            goto Lf8
        L4c:
            a5.c r4 = r14.m67574g()     // Catch: java.lang.Exception -> L5e android.database.sqlite.SQLiteException -> L64
            android.os.Handler$Callback r7 = r14.m67568a()     // Catch: java.lang.Exception -> L5e android.database.sqlite.SQLiteException -> L64
            java.lang.Object r8 = r14.m67569b()     // Catch: java.lang.Exception -> L5e android.database.sqlite.SQLiteException -> L64
            r3 = r13
            r6 = r9
            r3.m67469F(r4, r5, r6, r7, r8)     // Catch: java.lang.Exception -> L5e android.database.sqlite.SQLiteException -> L64
            goto L72
        L5e:
            r6 = r17
        L60:
            r5 = r18
            goto Led
        L64:
            r6 = r17
        L66:
            r5 = r18
            goto Lf3
        L6a:
            r12 = r16
            goto L5e
        L6d:
            r12 = r16
            goto L64
        L70:
            r12 = r16
        L72:
            android.database.Cursor r3 = r14.m67571d()     // Catch: java.lang.Exception -> L5e android.database.sqlite.SQLiteException -> L64
            java.util.HashMap r4 = p444l5.C11241i.b.m67548a()     // Catch: java.lang.Exception -> L5e android.database.sqlite.SQLiteException -> L64
            android.content.ContentValues r3 = com.huawei.android.backup.service.utils.C2157a.m13213u(r3, r4)     // Catch: java.lang.Exception -> L5e android.database.sqlite.SQLiteException -> L64
            a5.c r4 = r14.m67574g()     // Catch: java.lang.Exception -> L5e android.database.sqlite.SQLiteException -> L64
            java.lang.String r5 = "data_tb"
            int r4 = r4.m185A(r5, r3)     // Catch: java.lang.Exception -> L5e android.database.sqlite.SQLiteException -> L64
            r5 = 2
            if (r4 == r5) goto Lde
            java.lang.String r4 = p444l5.C11237e.m67527g(r3)     // Catch: java.lang.Exception -> L5e android.database.sqlite.SQLiteException -> L64
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Exception -> L5e android.database.sqlite.SQLiteException -> L64
            if (r5 != 0) goto L9f
            java.lang.Long r5 = java.lang.Long.valueOf(r10)     // Catch: java.lang.Exception -> L5e android.database.sqlite.SQLiteException -> L64
            r6 = r17
            r6.put(r5, r4)     // Catch: java.lang.Exception -> L60 android.database.sqlite.SQLiteException -> L66
            goto La1
        L9f:
            r6 = r17
        La1:
            if (r3 == 0) goto L48
            java.lang.String r4 = p444l5.C11241i.f52778c     // Catch: java.lang.Exception -> L60 android.database.sqlite.SQLiteException -> L66
            java.lang.String r5 = "mimetype"
            java.lang.String r5 = r3.getAsString(r5)     // Catch: java.lang.Exception -> L60 android.database.sqlite.SQLiteException -> L66
            boolean r4 = r4.equals(r5)     // Catch: java.lang.Exception -> L60 android.database.sqlite.SQLiteException -> L66
            if (r4 == 0) goto L48
            java.lang.String r4 = "data14"
            java.lang.Long r3 = r3.getAsLong(r4)     // Catch: java.lang.Exception -> L60 android.database.sqlite.SQLiteException -> L66
            if (r3 == 0) goto L48
            long r4 = r3.longValue()     // Catch: java.lang.Exception -> L60 android.database.sqlite.SQLiteException -> L66
            r7 = 0
            int r4 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r4 <= 0) goto L48
            java.lang.Long r4 = java.lang.Long.valueOf(r10)     // Catch: java.lang.Exception -> L60 android.database.sqlite.SQLiteException -> L66
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L60 android.database.sqlite.SQLiteException -> L66
            r5.<init>()     // Catch: java.lang.Exception -> L60 android.database.sqlite.SQLiteException -> L66
            java.lang.String r7 = "content://com.android.contacts/display_photo/"
            r5.append(r7)     // Catch: java.lang.Exception -> L60 android.database.sqlite.SQLiteException -> L66
            r5.append(r3)     // Catch: java.lang.Exception -> L60 android.database.sqlite.SQLiteException -> L66
            java.lang.String r3 = r5.toString()     // Catch: java.lang.Exception -> L60 android.database.sqlite.SQLiteException -> L66
            r5 = r18
            r5.put(r4, r3)     // Catch: java.lang.Exception -> Led android.database.sqlite.SQLiteException -> Lf3
            goto Lf8
        Lde:
            r6 = r17
            r5 = r18
            java.lang.String r3 = "write to data failed."
            com.huawei.android.backup.filelogic.utils.C2111d.m12648d(r2, r3)     // Catch: java.lang.Exception -> Led android.database.sqlite.SQLiteException -> Lf3
            java.lang.Exception r3 = new java.lang.Exception     // Catch: java.lang.Exception -> Led android.database.sqlite.SQLiteException -> Lf3
            r3.<init>()     // Catch: java.lang.Exception -> Led android.database.sqlite.SQLiteException -> Lf3
            throw r3     // Catch: java.lang.Exception -> Led android.database.sqlite.SQLiteException -> Lf3
        Led:
            java.lang.String r3 = "Exception: Failed to backup data of raw_contact."
            com.huawei.android.backup.filelogic.utils.C2111d.m12648d(r2, r3)
            goto Lf8
        Lf3:
            java.lang.String r3 = "SQLiteException: Failed to backup data of raw_contact."
            com.huawei.android.backup.filelogic.utils.C2111d.m12648d(r2, r3)
        Lf8:
            android.database.Cursor r3 = r14.m67571d()
            boolean r3 = r3.moveToNext()
            if (r3 != 0) goto L16
        L102:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p444l5.AbstractC11234b.m67470G(l5.k, java.util.Set, java.util.HashMap, java.util.HashMap, java.util.HashMap):void");
    }

    /* renamed from: H */
    public final void m67471H(Cursor cursor, int i10, String str, ArrayList<String> arrayList) {
        if (i10 > 0 && cursor.getCount() > 0) {
            StringBuffer stringBuffer = new StringBuffer(16);
            int i11 = 0;
            do {
                stringBuffer.append(",");
                stringBuffer.append(cursor.getLong(0));
                i11++;
                if (i11 == i10) {
                    m67478O(arrayList, stringBuffer, str);
                    stringBuffer.setLength(0);
                    i11 = 0;
                }
            } while (cursor.moveToNext());
            if (i11 > 0) {
                m67478O(arrayList, stringBuffer, str);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:69:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0083 A[SYNTHETIC] */
    /* renamed from: I */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.HashMap<java.lang.Long, java.util.LinkedHashSet<android.content.ContentValues>> m67472I(p006a5.AbstractC0048c r8, java.lang.String r9, java.util.HashMap<java.lang.Long, java.lang.Long> r10, java.lang.String r11) {
        /*
            r7 = this;
            r0 = 0
            if (r8 == 0) goto L10
            java.lang.String[] r3 = r7.f52746f
            r5 = 0
            java.lang.String r6 = "raw_contact_id"
            r1 = r8
            r2 = r11
            r4 = r9
            android.content.ContentValues[] r7 = r1.m200s(r2, r3, r4, r5, r6)
            goto L11
        L10:
            r7 = r0
        L11:
            if (r7 == 0) goto L87
            int r8 = r7.length
            r9 = 1
            if (r8 >= r9) goto L19
            goto L87
        L19:
            java.util.HashMap r8 = new java.util.HashMap
            r9 = 16
            r8.<init>(r9)
            int r11 = r7.length
            r0 = 0
        L22:
            if (r0 >= r11) goto L86
            r1 = r7[r0]
            if (r1 != 0) goto L29
            goto L83
        L29:
            java.lang.String r2 = "mimetype"
            boolean r3 = r1.containsKey(r2)
            if (r3 == 0) goto L58
            java.lang.String r3 = "vnd.android.cursor.item/group_membership"
            java.lang.Object r2 = r1.get(r2)
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L58
            java.lang.String r2 = "data1"
            java.lang.Long r3 = r1.getAsLong(r2)
            if (r10 == 0) goto L83
            java.util.Set r4 = r10.keySet()
            boolean r4 = r4.contains(r3)
            if (r4 == 0) goto L83
            java.lang.Object r3 = r10.get(r3)
            java.lang.Long r3 = (java.lang.Long) r3
            r1.put(r2, r3)
        L58:
            java.lang.String r2 = "raw_contact_id"
            boolean r3 = r1.containsKey(r2)
            if (r3 != 0) goto L61
            goto L83
        L61:
            java.lang.Long r2 = r1.getAsLong(r2)
            r2.longValue()
            boolean r3 = r8.containsKey(r2)
            if (r3 != 0) goto L7a
            java.util.LinkedHashSet r3 = new java.util.LinkedHashSet
            r3.<init>(r9)
            r3.add(r1)
            r8.put(r2, r3)
            goto L83
        L7a:
            java.lang.Object r2 = r8.get(r2)
            java.util.LinkedHashSet r2 = (java.util.LinkedHashSet) r2
            r2.add(r1)
        L83:
            int r0 = r0 + 1
            goto L22
        L86:
            return r8
        L87:
            java.lang.String r7 = "BackupContactHap"
            java.lang.String r8 = "Failed to query."
            com.huawei.android.backup.filelogic.utils.C2111d.m12648d(r7, r8)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p444l5.AbstractC11234b.m67472I(a5.c, java.lang.String, java.util.HashMap, java.lang.String):java.util.HashMap");
    }

    /* renamed from: J */
    public final String m67473J(List<Long> list) {
        StringBuilder sb2 = new StringBuilder();
        for (Long l10 : list) {
            sb2.append(",");
            sb2.append(l10);
        }
        if (sb2.length() > 0) {
            sb2.deleteCharAt(0);
            sb2.insert(0, "raw_contact_id in (");
            sb2.append(")");
        }
        return sb2.toString();
    }

    /* renamed from: K */
    public final ArrayList<ContentProviderOperation> m67474K(ArrayList<C9660c> arrayList, HashMap<Integer, Integer> map, Uri uri) {
        if (arrayList == null || map == null) {
            return null;
        }
        ArrayList<ContentProviderOperation> arrayList2 = new ArrayList<>(arrayList.size());
        int iM67475L = 0;
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            iM67475L += m67475L(arrayList2, arrayList.get(i10).m60328e(), arrayList.get(i10).m60325b(), iM67475L, uri);
            map.put(Integer.valueOf(iM67475L), Integer.valueOf(i10));
        }
        return arrayList2;
    }

    /* renamed from: L */
    public final int m67475L(ArrayList<ContentProviderOperation> arrayList, ContentValues contentValues, Set<ContentValues> set, int i10, Uri uri) {
        if (arrayList == null || contentValues == null || set == null) {
            return 0;
        }
        Uri uri2 = ContactsContract.Profile.CONTENT_RAW_CONTACTS_URI;
        ContentProviderOperation.Builder builderNewInsert = uri2.equals(uri) ? ContentProviderOperation.newInsert(uri2) : ContentProviderOperation.newInsert(ContactsContract.RawContacts.CONTENT_URI);
        for (String str : this.f52750j) {
            if ("aggregation_mode".equals(str)) {
                builderNewInsert.withValue("aggregation_mode", 0);
            } else if ("_id".equals(str)) {
                C2111d.m12646b("BackupContactHap", "contactProjection not need");
            } else {
                builderNewInsert.withValue(str, contentValues.get(str));
            }
        }
        arrayList.add(builderNewInsert.build());
        int i11 = 1;
        for (ContentValues contentValues2 : set) {
            if (contentValues2 != null) {
                ContentProviderOperation.Builder builderNewInsert2 = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI);
                for (String str2 : this.f52746f) {
                    if ("raw_contact_id".equals(str2)) {
                        builderNewInsert2.withValueBackReference("raw_contact_id", i10);
                    } else {
                        builderNewInsert2.withValue(str2, contentValues2.get(str2));
                    }
                }
                arrayList.add(builderNewInsert2.build());
                i11++;
            }
        }
        return i11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0043 A[PHI: r10
  0x0043: PHI (r10v5 android.database.Cursor) = (r10v3 android.database.Cursor), (r10v4 android.database.Cursor), (r10v7 android.database.Cursor) binds: [B:64:0x004e, B:66:0x0054, B:60:0x0041] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x005a  */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* renamed from: M */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.ArrayList<java.lang.String> m67476M(android.content.Context r10, android.net.Uri r11, java.lang.String[] r12, java.lang.String r13, java.lang.String r14) throws java.lang.Throwable {
        /*
            r9 = this;
            java.lang.String r0 = "BackupContactHap"
            r1 = 0
            java.lang.String r2 = "begin to prepare cotact cursor"
            com.huawei.android.backup.filelogic.utils.C2111d.m12653i(r0, r2)     // Catch: java.lang.Throwable -> L18 java.lang.Exception -> L1a java.lang.IllegalArgumentException -> L1c
            if (r10 == 0) goto L1e
            android.content.ContentResolver r3 = r10.getContentResolver()     // Catch: java.lang.Throwable -> L18 java.lang.Exception -> L1a java.lang.IllegalArgumentException -> L1c
            r7 = 0
            r4 = r11
            r5 = r12
            r6 = r13
            r8 = r14
            android.database.Cursor r10 = r3.query(r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L18 java.lang.Exception -> L1a java.lang.IllegalArgumentException -> L1c
            goto L1f
        L18:
            r9 = move-exception
            goto L58
        L1a:
            r10 = r1
            goto L47
        L1c:
            r10 = r1
            goto L4f
        L1e:
            r10 = r1
        L1f:
            java.lang.String r11 = "prepare cotact cursor finish"
            com.huawei.android.backup.filelogic.utils.C2111d.m12653i(r0, r11)     // Catch: java.lang.Throwable -> L3e java.lang.Exception -> L47 java.lang.IllegalArgumentException -> L4f
            java.util.ArrayList r11 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L3e java.lang.Exception -> L47 java.lang.IllegalArgumentException -> L4f
            r12 = 16
            r11.<init>(r12)     // Catch: java.lang.Throwable -> L3e java.lang.Exception -> L47 java.lang.IllegalArgumentException -> L4f
            if (r10 == 0) goto L41
            boolean r12 = r10.moveToFirst()     // Catch: java.lang.Throwable -> L3e java.lang.Exception -> L47 java.lang.IllegalArgumentException -> L4f
            if (r12 == 0) goto L41
            java.lang.String r12 = "_id"
            r13 = 1000(0x3e8, float:1.401E-42)
            r9.m67471H(r10, r13, r12, r11)     // Catch: java.lang.Throwable -> L3e java.lang.Exception -> L47 java.lang.IllegalArgumentException -> L4f
            r10.close()
            return r11
        L3e:
            r9 = move-exception
            r1 = r10
            goto L58
        L41:
            if (r10 == 0) goto L57
        L43:
            r10.close()
            goto L57
        L47:
            java.lang.String r9 = "buildSelectionArgsIn Exception."
            com.huawei.android.backup.filelogic.utils.C2111d.m12648d(r0, r9)     // Catch: java.lang.Throwable -> L3e
            if (r10 == 0) goto L57
            goto L43
        L4f:
            java.lang.String r9 = "buildSelectionArgsIn IllegalArgumentException"
            com.huawei.android.backup.filelogic.utils.C2111d.m12648d(r0, r9)     // Catch: java.lang.Throwable -> L3e
            if (r10 == 0) goto L57
            goto L43
        L57:
            return r1
        L58:
            if (r1 == 0) goto L5d
            r1.close()
        L5d:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: p444l5.AbstractC11234b.m67476M(android.content.Context, android.net.Uri, java.lang.String[], java.lang.String, java.lang.String):java.util.ArrayList");
    }

    /* renamed from: N */
    public ArrayList<String> m67477N(long[] jArr, int i10) {
        C2111d.m12653i("BackupContactHap", "buildSelectionArgsIn.");
        ArrayList<String> arrayList = new ArrayList<>(16);
        if (jArr != null && jArr.length > 0 && i10 > 0) {
            StringBuffer stringBuffer = new StringBuffer(16);
            int i11 = 0;
            while (i11 < jArr.length) {
                stringBuffer.append(",");
                stringBuffer.append(jArr[i11]);
                int i12 = i11 + 1;
                if (i12 % i10 == 0 || i11 >= jArr.length - 1) {
                    m67478O(arrayList, stringBuffer, "raw_contact_id");
                    stringBuffer = new StringBuffer(16);
                }
                i11 = i12;
            }
        }
        return arrayList;
    }

    /* renamed from: O */
    public final void m67478O(ArrayList<String> arrayList, StringBuffer stringBuffer, String str) {
        String strM67480Q = m67480Q(stringBuffer, str);
        if (strM67480Q == null || strM67480Q.length() < 1) {
            return;
        }
        arrayList.add(strM67480Q);
    }

    /* renamed from: P */
    public final void m67479P(ContentValues contentValues) {
        this.f52754n++;
        String asString = contentValues.getAsString("ext_account_name");
        String str = contentValues.getAsString("ext_account_type") + asString;
        (this.f52745e.containsKey(str) ? this.f52745e.get(str) : this.f52745e.get(C11241i.f52781f)).m67536a();
    }

    /* renamed from: Q */
    public final String m67480Q(StringBuffer stringBuffer, String str) {
        if (stringBuffer == null || str == null) {
            return null;
        }
        if (stringBuffer.length() > 0) {
            stringBuffer.deleteCharAt(0);
            stringBuffer.insert(0, str + " in (").append(")");
            stringBuffer.append(" and mimetype != 'vnd.android.huawei.cursor.item/ringtone'");
            if (!this.f52741a) {
                stringBuffer.append(" and not (mimetype =='vnd.android.cursor.item/contact_event' and data2==4)");
            }
        }
        return stringBuffer.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00a0  */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* renamed from: S */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.HashMap<java.lang.Long, android.content.ContentValues> m67481S(android.content.Context r11, android.net.Uri r12, java.lang.String r13, java.lang.String[] r14) throws java.lang.Throwable {
        /*
            r10 = this;
            java.lang.String r0 = "BackupContactHap"
            java.util.HashMap r1 = new java.util.HashMap
            r2 = 16
            r1.<init>(r2)
            if (r13 != 0) goto Lc
            return r1
        Lc:
            r2 = 0
            java.lang.String r3 = "begin getRawValues query"
            com.huawei.android.backup.filelogic.utils.C2111d.m12653i(r0, r3)     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L26 java.lang.IllegalArgumentException -> L28
            if (r11 == 0) goto L2a
            android.content.ContentResolver r4 = r11.getContentResolver()     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L26 java.lang.IllegalArgumentException -> L28
            java.lang.String[] r6 = r10.f52750j     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L26 java.lang.IllegalArgumentException -> L28
            r9 = 0
            r5 = r12
            r7 = r13
            r8 = r14
            android.database.Cursor r11 = r4.query(r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L26 java.lang.IllegalArgumentException -> L28
            goto L2b
        L23:
            r10 = move-exception
            goto L9e
        L26:
            r11 = r2
            goto L88
        L28:
            r11 = r2
            goto L93
        L2a:
            r11 = r2
        L2b:
            if (r11 == 0) goto L82
            boolean r12 = r11.moveToFirst()     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L88 java.lang.IllegalArgumentException -> L93
            if (r12 != 0) goto L34
            goto L82
        L34:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L88 java.lang.IllegalArgumentException -> L93
            r12.<init>()     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L88 java.lang.IllegalArgumentException -> L93
            java.lang.String r13 = "end getRawValues query, get cursor success, count is:"
            r12.append(r13)     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L88 java.lang.IllegalArgumentException -> L93
            int r13 = r11.getCount()     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L88 java.lang.IllegalArgumentException -> L93
            r12.append(r13)     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L88 java.lang.IllegalArgumentException -> L93
            java.lang.String r12 = r12.toString()     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L88 java.lang.IllegalArgumentException -> L93
            com.huawei.android.backup.filelogic.utils.C2111d.m12653i(r0, r12)     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L88 java.lang.IllegalArgumentException -> L93
            java.lang.String r12 = "_id"
            int r12 = r11.getColumnIndexOrThrow(r12)     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L88 java.lang.IllegalArgumentException -> L93
        L52:
            boolean r13 = com.huawei.android.backup.service.logic.BackupObject.isAbort()     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L88 java.lang.IllegalArgumentException -> L93
            if (r13 == 0) goto L59
            goto L7b
        L59:
            java.util.HashMap r13 = p444l5.C11241i.d.m67552a()     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L88 java.lang.IllegalArgumentException -> L93
            android.content.ContentValues r13 = com.huawei.android.backup.service.utils.C2157a.m13213u(r11, r13)     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L88 java.lang.IllegalArgumentException -> L93
            long r3 = r11.getLong(r12)     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L88 java.lang.IllegalArgumentException -> L93
            java.util.HashSet<java.lang.Long> r14 = r10.f52751k     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L88 java.lang.IllegalArgumentException -> L93
            java.lang.Long r5 = java.lang.Long.valueOf(r3)     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L88 java.lang.IllegalArgumentException -> L93
            r14.add(r5)     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L88 java.lang.IllegalArgumentException -> L93
            java.lang.Long r14 = java.lang.Long.valueOf(r3)     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L88 java.lang.IllegalArgumentException -> L93
            r1.put(r14, r13)     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L88 java.lang.IllegalArgumentException -> L93
            boolean r13 = r11.moveToNext()     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L88 java.lang.IllegalArgumentException -> L93
            if (r13 != 0) goto L52
        L7b:
            r11.close()
            return r1
        L7f:
            r10 = move-exception
            r2 = r11
            goto L9e
        L82:
            if (r11 == 0) goto L87
            r11.close()
        L87:
            return r1
        L88:
            java.lang.String r10 = "Exception: Get all raw_contacts failed."
            com.huawei.android.backup.filelogic.utils.C2111d.m12648d(r0, r10)     // Catch: java.lang.Throwable -> L7f
            if (r11 == 0) goto L92
            r11.close()
        L92:
            return r2
        L93:
            java.lang.String r10 = "IllegalArgumentException: Get all raw_contacts failed."
            com.huawei.android.backup.filelogic.utils.C2111d.m12648d(r0, r10)     // Catch: java.lang.Throwable -> L7f
            if (r11 == 0) goto L9d
            r11.close()
        L9d:
            return r2
        L9e:
            if (r2 == 0) goto La3
            r2.close()
        La3:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: p444l5.AbstractC11234b.m67481S(android.content.Context, android.net.Uri, java.lang.String, java.lang.String[]):java.util.HashMap");
    }

    /* renamed from: T */
    public final ArrayList<C9660c> m67482T(C11243k c11243k, List<C9660c> list, ContentProviderResult[] contentProviderResultArr, HashMap<Integer, Integer> map, HashMap<Long, Long> map2) throws RemoteException, OperationApplicationException {
        int i10;
        String lastPathSegment;
        if (list == null || map == null || map2 == null) {
            return null;
        }
        if (C2157a.m13169D(contentProviderResultArr)) {
            Iterator<C9660c> it = list.iterator();
            while (it.hasNext()) {
                m67494f0(c11243k.m67570c(), it.next(), map2, c11243k.m67568a(), c11243k.m67569b());
            }
            return null;
        }
        ArrayList<C9660c> arrayList = new ArrayList<>(map.entrySet().size());
        int i11 = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer key = entry.getKey();
            int iIntValue = key.intValue();
            int i12 = i11;
            while (true) {
                if (i12 >= iIntValue) {
                    i10 = iIntValue;
                    break;
                }
                if (contentProviderResultArr[i12].uri == null) {
                    i10 = iIntValue;
                    m67487Y(c11243k.m67570c(), list.get(entry.getValue().intValue()), map2, c11243k.m67568a(), c11243k.m67569b());
                    break;
                }
                i12++;
            }
            Uri uri = (i11 < 0 || i11 >= contentProviderResultArr.length) ? null : contentProviderResultArr[i11].uri;
            if (uri == null) {
                return arrayList;
            }
            try {
                lastPathSegment = uri.getLastPathSegment();
            } catch (NumberFormatException unused) {
                C2111d.m12648d("BackupContactHap", "handleInsertBacth NumberFormatException");
            }
            if (lastPathSegment == null) {
                C2111d.m12657m("BackupContactHap", "the segmengt is null.");
            } else {
                map2.put(list.get(map.get(key).intValue()).m60328e().getAsLong("_id"), Long.valueOf(lastPathSegment));
                Integer asInteger = list.get(map.get(key).intValue()).m60328e().getAsInteger("aggregation_mode");
                asInteger.intValue();
                ContentValues contentValues = new ContentValues();
                contentValues.put("aggregation_mode", asInteger);
                arrayList.add(new C9660c(uri, contentValues));
                i11 = i10;
            }
        }
        return arrayList;
    }

    /* renamed from: U */
    public final void m67483U(Context context, ContentProviderResult[] contentProviderResultArr, List<C9660c> list, Handler.Callback callback, Object obj) {
        if (context == null || list == null) {
            return;
        }
        if (C2157a.m13169D(contentProviderResultArr)) {
            for (C9660c c9660c : list) {
                if (C13333b.m79956d(context, c9660c.m60324a(), c9660c.m60329f(), null, null)) {
                    int i10 = this.f52755o;
                    this.f52755o = i10 + 1;
                    sendMsg(3, i10, this.f52747g, callback, obj);
                } else {
                    int i11 = this.f52755o;
                    this.f52755o = i11 + 1;
                    sendMsg(5, i11, this.f52747g, callback, obj);
                }
            }
            return;
        }
        int i12 = 0;
        for (ContentProviderResult contentProviderResult : contentProviderResultArr) {
            if (contentProviderResult.count.intValue() >= 1 || C13333b.m79956d(context, list.get(i12).m60324a(), list.get(i12).m60329f(), null, null)) {
                int i13 = this.f52755o;
                this.f52755o = i13 + 1;
                sendMsg(3, i13, this.f52747g, callback, obj);
            } else {
                int i14 = this.f52755o;
                this.f52755o = i14 + 1;
                sendMsg(5, i14, this.f52747g, callback, obj);
            }
            i12++;
        }
    }

    /* renamed from: V */
    public final void m67484V() {
        Iterator<Map.Entry<String, C11239g>> it = this.f52745e.entrySet().iterator();
        while (it.hasNext()) {
            C11239g value = it.next().getValue();
            if (value.m67539d() != 0) {
                if (value.m67539d() == 1) {
                    this.f52744d.add(value.m67538c());
                } else {
                    this.f52743c.add(value.m67538c());
                }
            }
        }
    }

    /* renamed from: W */
    public final ContentProviderResult[] m67485W(Context context, ArrayList<C9660c> arrayList, HashMap<Integer, Integer> map, Uri uri) {
        if (context == null || arrayList == null || map == null) {
            return null;
        }
        ArrayList<ContentProviderOperation> arrayListM67474K = m67474K(arrayList, map, uri);
        if (arrayListM67474K != null && arrayListM67474K.size() > 0) {
            try {
                return context.getContentResolver().applyBatch("com.android.contacts", arrayListM67474K);
            } catch (OperationApplicationException unused) {
                C2111d.m12648d("BackupContactHap", "OperationApplicationException: insertBatch error.");
            } catch (RemoteException unused2) {
                C2111d.m12648d("BackupContactHap", "RemoteException: insertBatch error.");
            } catch (IllegalArgumentException unused3) {
                C2111d.m12648d("BackupContactHap", "IllegalArgumentException: insertBatch error.");
            } catch (Exception unused4) {
                C2111d.m12648d("BackupContactHap", "Exception: insertBatch error.");
            }
        }
        return new ContentProviderResult[0];
    }

    /* renamed from: X */
    public final ArrayList<C9660c> m67486X(C11243k c11243k, ArrayList<C9660c> arrayList, HashMap<Integer, Integer> map, HashMap<Long, Long> map2, Uri uri) {
        if (arrayList == null || map == null || map2 == null) {
            return null;
        }
        return m67482T(c11243k, arrayList, m67485W(c11243k.m67570c(), arrayList, map, uri), map, map2);
    }

    /* renamed from: Y */
    public final ContentProviderResult[] m67487Y(Context context, C9660c c9660c, HashMap<Long, Long> map, Handler.Callback callback, Object obj) throws RemoteException, OperationApplicationException {
        String lastPathSegment;
        if (context != null && c9660c != null && map != null) {
            ArrayList<ContentProviderOperation> arrayList = new ArrayList<>(16);
            m67475L(arrayList, c9660c.m60328e(), c9660c.m60325b(), 0, null);
            try {
                ContentProviderResult[] contentProviderResultArrApplyBatch = context.getContentResolver().applyBatch("com.android.contacts", arrayList);
                if (C2157a.m13169D(contentProviderResultArrApplyBatch)) {
                    int i10 = this.f52755o;
                    this.f52755o = i10 + 1;
                    sendMsg(5, i10, this.f52747g, callback, obj);
                    return null;
                }
                for (ContentProviderResult contentProviderResult : contentProviderResultArrApplyBatch) {
                    if (contentProviderResult.uri == null) {
                        int i11 = this.f52755o;
                        this.f52755o = i11 + 1;
                        sendMsg(5, i11, this.f52747g, callback, obj);
                        return null;
                    }
                }
                try {
                    lastPathSegment = contentProviderResultArrApplyBatch[0].uri.getLastPathSegment();
                } catch (NumberFormatException unused) {
                    C2111d.m12648d("BackupContactHap", "insertContactNoBatch NumberFormatException");
                }
                if (lastPathSegment == null) {
                    return contentProviderResultArrApplyBatch;
                }
                map.put(c9660c.m60327d(), Long.valueOf(lastPathSegment));
                return contentProviderResultArrApplyBatch;
            } catch (OperationApplicationException | RemoteException | IllegalArgumentException unused2) {
                C2111d.m12648d("BackupContactHap", "insertContactNoBatch error.");
                int i12 = this.f52755o;
                this.f52755o = i12 + 1;
                sendMsg(5, i12, this.f52747g, callback, obj);
            } catch (Exception unused3) {
                C2111d.m12648d("BackupContactHap", "Exception: insertContactNoBatch error.");
                int i13 = this.f52755o;
                this.f52755o = i13 + 1;
                sendMsg(5, i13, this.f52747g, callback, obj);
                return null;
            }
        }
        return null;
    }

    /* renamed from: Z */
    public final boolean m67488Z() {
        String[] strArr = this.f52750j;
        boolean z10 = strArr != null && strArr.length > 0;
        String[] strArr2 = this.f52746f;
        return z10 || (strArr2 != null && strArr2.length > 0);
    }

    /* renamed from: a0 */
    public final void m67489a0(Context context, List<Long> list, AbstractC0048c abstractC0048c) throws IOException {
        if (C13348q.m80082b(list)) {
            return;
        }
        C9662e c9662e = new C9662e(C11241i.f52787l, this.f52746f, m67473J(list), null, null);
        c9662e.m60337g(C11241i.b.m67548a());
        ContentValues[] backupValues = BackupObject.getBackupValues(context, c9662e);
        if (backupValues.length > 0) {
            m67468E(context, backupValues, abstractC0048c);
        }
    }

    /* renamed from: b0 */
    public void m67490b0(C11243k c11243k, HashMap<Long, ContentValues> map, HashMap<Long, LinkedHashSet<ContentValues>> map2, HashMap<Long, Long> map3) {
        if (c11243k == null) {
            C2111d.m12653i("BackupContactHap", "removeBackupDuplicateData, contactParameter is null");
            return;
        }
        HashSet<Integer> hashSetM67573f = c11243k.m67573f();
        if (hashSetM67573f == null || hashSetM67573f.isEmpty()) {
            C2111d.m12653i("BackupContactHap", "removeBackupDuplicateData, local contact Data is null");
            return;
        }
        C2111d.m12653i("BackupContactHap", "removeBackupDuplicateData localDataHash size:" + hashSetM67573f.size());
        C11237e.m67523c(map2, new C11244l(hashSetM67573f, map, c11243k.m67568a(), c11243k.m67569b(), c11243k.m67572e(), map3), new a());
    }

    /* renamed from: c0 */
    public int m67491c0(Context context, AbstractC0048c abstractC0048c, HashMap<Long, Long> map) {
        String[] strArr;
        if (map == null || (strArr = this.f52752l) == null || context == null) {
            return 4;
        }
        ContentValues[] contentValuesArrM200s = abstractC0048c != null ? abstractC0048c.m200s("agg_exceptions_tb", strArr, null, null, null) : null;
        if (contentValuesArrM200s == null) {
            C2111d.m12648d("BackupContactHap", "aggValues is null");
            return 4;
        }
        try {
            for (ContentValues contentValues : contentValuesArrM200s) {
                if (contentValues.containsKey("raw_contact_id1") && contentValues.containsKey("raw_contact_id2")) {
                    Long l10 = (Long) contentValues.get("raw_contact_id1");
                    l10.longValue();
                    Long l11 = (Long) contentValues.get("raw_contact_id2");
                    l11.longValue();
                    if (map.containsKey(l10) && map.containsKey(l11)) {
                        contentValues.put("raw_contact_id1", map.get(l10));
                        contentValues.put("raw_contact_id2", map.get(l11));
                        context.getContentResolver().update(ContactsContract.AggregationExceptions.CONTENT_URI, contentValues, null, null);
                    }
                }
                C2111d.m12648d("BackupContactHap", "agg_exceptions does't contain raw_contact_id1 or raw_contact_id2");
                return 5;
            }
            return 3;
        } catch (IllegalArgumentException unused) {
            C2111d.m12648d("BackupContactHap", "IllegalArgumentException: restoreAgg failed.");
            return 5;
        } catch (Exception unused2) {
            C2111d.m12648d("BackupContactHap", "Exception: restoreAgg failed.");
            return 5;
        }
    }

    /* renamed from: d0 */
    public final void m67492d0(C11243k c11243k, ArrayList<C9660c> arrayList, HashMap<Integer, Integer> map, HashMap<Long, Long> map2, Uri uri) {
        if (arrayList == null || map == null || map2 == null) {
            return;
        }
        ArrayList<C9660c> arrayListM67486X = m67486X(c11243k, arrayList, map, map2, uri);
        if (uri == null) {
            m67496h0(c11243k.m67570c(), arrayList, arrayListM67486X, c11243k.m67568a(), c11243k.m67569b());
        }
    }

    /* renamed from: e0 */
    public void m67493e0(C11243k c11243k, HashMap<Long, ContentValues> map, HashMap<Long, LinkedHashSet<ContentValues>> map2, HashMap<Long, Long> map3, Uri uri) {
        LinkedHashSet<ContentValues> linkedHashSet;
        if (map == null || map2 == null || map3 == null || c11243k == null) {
            return;
        }
        C2111d.m12653i("BackupContactHap", "Restore contacts batch.");
        LinkedHashMap linkedHashMap = new LinkedHashMap(16);
        ArrayList<C9660c> arrayList = new ArrayList<>(16);
        int size = 0;
        for (Map.Entry<Long, LinkedHashSet<ContentValues>> entry : map2.entrySet()) {
            Long key = entry.getKey();
            long jLongValue = key.longValue();
            ContentValues contentValues = map.get(key);
            LinkedHashSet<ContentValues> value = entry.getValue();
            if (contentValues == null || value == null) {
                C2111d.m12653i("BackupContactHap", "restoreContactsBatch contact content is null,raw_id:" + jLongValue);
                int i10 = this.f52755o;
                this.f52755o = i10 + 1;
                sendMsg(5, i10, this.f52747g, c11243k.m67568a(), c11243k.m67569b());
            } else {
                size += value.size() + 1;
                if (size >= 499) {
                    m67492d0(c11243k, arrayList, linkedHashMap, map3, uri);
                    int size2 = value.size() + 1;
                    arrayList.clear();
                    linkedHashMap.clear();
                    size = size2;
                    linkedHashSet = value;
                } else {
                    linkedHashSet = value;
                }
                arrayList.add(new C9660c(contentValues, linkedHashSet));
                C2111d.m12646b("BackupContactHap", "restoreContactsBatch size:" + size + ";raw contact id:" + jLongValue);
            }
        }
        m67492d0(c11243k, arrayList, linkedHashMap, map3, uri);
    }

    /* renamed from: f0 */
    public final void m67494f0(Context context, C9660c c9660c, HashMap<Long, Long> map, Handler.Callback callback, Object obj) {
        if (context != null && c9660c != null && map != null) {
            m67497i0(context, c9660c, m67487Y(context, c9660c, map, callback, obj), callback, obj);
            return;
        }
        int i10 = this.f52755o;
        this.f52755o = i10 + 1;
        sendMsg(5, i10, this.f52747g, callback, obj);
    }

    /* renamed from: g0 */
    public HashMap<Long, Long> m67495g0(Context context, AbstractC0048c abstractC0048c) {
        String[] strArr = this.f52753m;
        if (strArr == null) {
            return null;
        }
        ContentValues[] contentValuesArrM200s = abstractC0048c != null ? abstractC0048c.m200s("groups_tb", strArr, "group_is_read_only=0", null, null) : null;
        if (contentValuesArrM200s == null) {
            C2111d.m12648d("BackupContactHap", "groupsValues is null");
            return null;
        }
        HashMap<Long, Long> map = new HashMap<>(16);
        C9662e c9662e = new C9662e(ContactsContract.Groups.CONTENT_URI, this.f52753m, "deleted=0 and group_is_read_only=0", null, null);
        c9662e.m60337g(C11241i.c.m67550a());
        ContentValues[] backupValues = BackupObject.getBackupValues(context, c9662e);
        HashSet hashSet = new HashSet(16);
        HashMap map2 = new HashMap(16);
        for (ContentValues contentValues : backupValues) {
            String asString = contentValues.getAsString("sync1");
            Long asLong = contentValues.getAsLong("_id");
            asLong.longValue();
            if (C11241i.c.m67551b().contains(asString)) {
                hashSet.add(asString);
                map2.put(asString, asLong);
            } else {
                String asString2 = contentValues.getAsString("title");
                hashSet.add(asString2);
                map2.put(asString2, asLong);
            }
        }
        for (ContentValues contentValues2 : contentValuesArrM200s) {
            Long asLong2 = contentValues2.getAsLong("_id");
            String asString3 = contentValues2.getAsString("title");
            String asString4 = contentValues2.getAsString("sync1");
            if (hashSet.contains(asString3)) {
                map.put(asLong2, (Long) map2.get(asString3));
            } else if (hashSet.contains(asString4)) {
                map.put(asLong2, (Long) map2.get(asString4));
            } else {
                contentValues2.remove("_id");
                Uri uriM79955c = C13333b.m79955c(context, ContactsContract.Groups.CONTENT_URI, contentValues2);
                if (uriM79955c == null || uriM79955c.getLastPathSegment() == null) {
                    C2111d.m12648d("BackupContactHap", "Get group uri err");
                } else {
                    try {
                        map.put(asLong2, Long.valueOf(C13342k.m80057f(uriM79955c.getLastPathSegment())));
                    } catch (NumberFormatException unused) {
                        C2111d.m12648d("BackupContactHap", "restoreGroups NumberFormatException");
                    }
                }
            }
        }
        return map;
    }

    /* renamed from: h0 */
    public final void m67496h0(Context context, ArrayList<C9660c> arrayList, ArrayList<C9660c> arrayList2, Handler.Callback callback, Object obj) {
        if (arrayList == null || arrayList2 == null) {
            return;
        }
        m67483U(context, C11237e.m67532l(context, arrayList2), arrayList2, callback, obj);
    }

    /* renamed from: i0 */
    public final void m67497i0(Context context, C9660c c9660c, ContentProviderResult[] contentProviderResultArr, Handler.Callback callback, Object obj) {
        if (context == null || c9660c == null || contentProviderResultArr == null) {
            int i10 = this.f52755o;
            this.f52755o = i10 + 1;
            sendMsg(5, i10, this.f52747g, callback, obj);
            return;
        }
        Integer numM60326c = c9660c.m60326c();
        numM60326c.intValue();
        ContentValues contentValues = new ContentValues();
        contentValues.put("aggregation_mode", numM60326c);
        if (!C13333b.m79956d(context, contentProviderResultArr[0].uri, contentValues, null, null)) {
            int i11 = this.f52755o;
            this.f52755o = i11 + 1;
            sendMsg(5, i11, this.f52747g, callback, obj);
        }
        int i12 = this.f52755o;
        this.f52755o = i12 + 1;
        sendMsg(3, i12, this.f52747g, callback, obj);
    }

    public boolean init(Context context, int i10, AbstractC0048c abstractC0048c) {
        String[] strArrM13202j = C2157a.m13202j(context, ContactsContract.RawContacts.CONTENT_URI);
        String[] strArrM13202j2 = C2157a.m13202j(context, ContactsContract.AggregationExceptions.CONTENT_URI);
        String[] strArrM13202j3 = C2157a.m13202j(context, ContactsContract.Data.CONTENT_URI);
        String[] strArrM13202j4 = C2157a.m13202j(context, ContactsContract.Groups.CONTENT_URI);
        this.f52741a = AbstractC11233a.m67441r(context);
        if (i10 == 1) {
            this.f52750j = C11237e.m67525e(strArrM13202j, C11241i.d.m67552a());
            this.f52752l = C11237e.m67525e(strArrM13202j2, C11241i.a.m67547a());
            this.f52746f = C11237e.m67525e(strArrM13202j3, C11241i.b.m67548a());
            this.f52753m = C11237e.m67525e(strArrM13202j4, C11241i.c.m67550a());
        } else if (i10 != 2 || abstractC0048c == null) {
            C2111d.m12646b("BackupContactHap", "flags not need.");
        } else {
            Set<String> setMo202u = abstractC0048c.mo202u("raw_contacts_tb");
            if (setMo202u != null && !setMo202u.isEmpty()) {
                this.f52750j = C11237e.m67528h(strArrM13202j, setMo202u, C11241i.d.m67552a());
            }
            Set<String> setMo202u2 = abstractC0048c.mo202u("agg_exceptions_tb");
            if (setMo202u2 != null && !setMo202u2.isEmpty()) {
                this.f52752l = C11237e.m67528h(strArrM13202j2, setMo202u2, C11241i.a.m67547a());
            }
            Set<String> setMo202u3 = abstractC0048c.mo202u("data_tb");
            if (setMo202u3 != null && setMo202u3.size() > 0) {
                this.f52746f = C11237e.m67528h(strArrM13202j3, setMo202u3, C11241i.b.m67548a());
            }
            Set<String> setMo202u4 = abstractC0048c.mo202u("groups_tb");
            if (setMo202u4 != null && !setMo202u4.isEmpty()) {
                this.f52753m = C11237e.m67528h(strArrM13202j4, setMo202u4, C11241i.c.m67550a());
            }
        }
        return m67488Z();
    }

    /* renamed from: j0 */
    public final int m67498j0(AbstractC0048c abstractC0048c, Cursor cursor) {
        if (cursor == null || !cursor.moveToFirst()) {
            if (cursor == null) {
                return 1;
            }
            cursor.close();
            return 1;
        }
        try {
            try {
                ContentValues contentValues = new ContentValues();
                do {
                    long j10 = cursor.getLong(cursor.getColumnIndexOrThrow("raw_contact_id1"));
                    long j11 = cursor.getLong(cursor.getColumnIndexOrThrow("raw_contact_id2"));
                    if (this.f52751k.contains(Long.valueOf(j10)) && this.f52751k.contains(Long.valueOf(j11))) {
                        contentValues.clear();
                        contentValues = C2157a.m13213u(cursor, C11241i.a.m67547a());
                        if (contentValues == null) {
                            cursor.close();
                            return 2;
                        }
                        abstractC0048c.m185A("agg_exceptions_tb", contentValues);
                    }
                } while (cursor.moveToNext());
            } catch (SQLiteException unused) {
                C2111d.m12648d("BackupContactHap", "SQLiteException: backup agg_exceptions record failed.");
            } catch (Exception unused2) {
                C2111d.m12648d("BackupContactHap", "Exception: backup agg_exceptions record failed.");
                cursor.close();
                return 2;
            }
            cursor.close();
            return 0;
        } catch (Throwable th2) {
            cursor.close();
            throw th2;
        }
    }

    /* renamed from: x */
    public final void m67499x(Context context, String str) throws C10711a {
        this.contactModuleInfoList = new ArrayList<>(this.f52745e.entrySet().size());
        try {
            Iterator<Map.Entry<String, C11239g>> it = this.f52745e.entrySet().iterator();
            while (it.hasNext()) {
                C11239g value = it.next().getValue();
                C11238f c11238f = new C11238f();
                c11238f.m67534b(context, str, value);
                this.contactModuleInfoList.add(c11238f);
            }
        } catch (IOException unused) {
            throw new C10711a("addContactInfoToList IOException happen.");
        } catch (Exception unused2) {
            throw new C10711a("addContactInfoToList failed.");
        }
    }

    /* renamed from: y */
    public final void m67500y(Context context, AbstractC0048c abstractC0048c, HashMap<Long, String> map, HashMap<Long, String> map2) throws IOException {
        for (Map.Entry<Long, String> entry : map.entrySet()) {
            C11240h.m67542a(context, abstractC0048c, entry.getKey().longValue(), entry.getValue(), "ContactBigPhoto");
        }
        for (Map.Entry<Long, String> entry2 : map2.entrySet()) {
            C11240h.m67542a(context, abstractC0048c, entry2.getKey().longValue(), entry2.getValue(), "ContactBigPhoto_camcard");
        }
    }

    /* renamed from: z */
    public final int m67501z(C11243k c11243k, String str, String[] strArr) throws Throwable {
        Cursor cursorQuery;
        C2111d.m12653i("BackupContactHap", "Backup contact data.");
        HashMap<Long, ContentValues> mapM67481S = m67481S(c11243k.m67570c(), ContactsContract.RawContacts.CONTENT_URI, str, strArr);
        if (mapM67481S == null || mapM67481S.size() == 0) {
            C2111d.m12648d("BackupContactHap", "rawNormalMap isEmpty!");
            return 2;
        }
        HashSet hashSet = new HashSet(mapM67481S.keySet());
        C2111d.m12654j("BackupContactHap", "buildIdSelectionString. mapSet size = ", Integer.valueOf(hashSet.size()));
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            StringBuffer stringBuffer = new StringBuffer();
            for (int i10 = 1; it.hasNext() && i10 <= 500; i10++) {
                stringBuffer.append(",");
                stringBuffer.append(it.next());
            }
            if (stringBuffer.length() > 0) {
                stringBuffer.deleteCharAt(0);
                stringBuffer.insert(0, "raw_contact_id in (");
                stringBuffer.append(")");
            }
            String string = stringBuffer.toString();
            if (TextUtils.isEmpty(string) || BackupObject.isAbort()) {
                C2111d.m12649e("BackupContactHap", "idWhere isEmpty:", Boolean.valueOf(TextUtils.isEmpty(string)));
                return 2;
            }
            ArrayList<String> arrayListM67476M = m67476M(c11243k.m67570c(), ContactsContract.Data.CONTENT_URI, new String[]{"_id"}, string, "_id ASC");
            if (arrayListM67476M == null) {
                C2111d.m12648d("BackupContactHap", "where == null");
                return 2;
            }
            c11243k.m67574g().mo169a();
            HashSet hashSet2 = new HashSet(500);
            HashMap<Long, String> map = new HashMap<>();
            HashMap<Long, String> map2 = new HashMap<>(16);
            for (String str2 : arrayListM67476M) {
                if (BackupObject.isAbort()) {
                    c11243k.m67574g().mo171c();
                    return 2;
                }
                Cursor cursor = null;
                try {
                    try {
                        cursorQuery = c11243k.m67570c().getContentResolver().query(ContactsContract.Data.CONTENT_URI, this.f52746f, str2, null, null);
                    } catch (IllegalArgumentException unused) {
                    } catch (Exception unused2) {
                    }
                    if (cursorQuery != null) {
                        try {
                        } catch (IllegalArgumentException unused3) {
                            cursor = cursorQuery;
                            C2111d.m12648d("BackupContactHap", "IllegalArgumentException: backupContactData error.");
                            if (cursor != null) {
                                cursor.close();
                            }
                        } catch (Exception unused4) {
                            cursor = cursorQuery;
                            C2111d.m12648d("BackupContactHap", "Exception: backupContactData error.");
                            if (cursor != null) {
                                cursor.close();
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            cursor = cursorQuery;
                            if (cursor != null) {
                                cursor.close();
                            }
                            throw th;
                        }
                        if (cursorQuery.moveToFirst()) {
                            c11243k.m67575h(cursorQuery);
                            m67470G(c11243k, hashSet2, mapM67481S, map, map2);
                            cursorQuery.close();
                        }
                    }
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            }
            m67500y(c11243k.m67570c(), c11243k.m67574g(), map, map2);
        }
        return 0;
    }
}
