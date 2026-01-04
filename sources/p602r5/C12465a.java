package p602r5;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.Handler;
import com.huawei.android.backup.filelogic.utils.C2108a;
import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.android.backup.service.logic.BackupObject;
import com.huawei.android.backup.service.logic.C2154m;
import com.huawei.android.backup.service.logic.InterfaceC2155n;
import com.huawei.android.backup.service.logic.PMSbackupRestoreUtil;
import com.huawei.android.backup.service.utils.C2157a;
import com.huawei.android.hicloud.cloudbackup.process.CloneService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import p006a5.AbstractC0048c;
import p007a6.AbstractC0053b;
import p007a6.C0052a;
import p229di.C9142g;
import p386j6.C10713c;
import p602r5.C12466b;
import p699v4.C13334c;
import p699v4.C13347p;
import p699v4.C13348q;
import p699v4.C13349r;

/* renamed from: r5.a */
/* loaded from: classes.dex */
public class C12465a extends AbstractC0053b {

    /* renamed from: b */
    public static final String f57392b;

    /* renamed from: c */
    public static final String f57393c;

    /* renamed from: d */
    public static final String f57394d;

    /* renamed from: r5.a$a */
    public static class a extends AbstractC0053b.c {
        public a(InterfaceC2155n interfaceC2155n, Context context, AbstractC0048c abstractC0048c, C0052a c0052a, AbstractC0053b.b bVar) {
            super(interfaceC2155n, context, abstractC0048c, c0052a, bVar.m315b(), bVar.m314a());
        }

        @Override // p007a6.AbstractC0053b.c
        /* renamed from: a0 */
        public String mo343a0(String str) {
            if (str == null || this.f177t == null) {
                return null;
            }
            String strM80078a = C13347p.m80078a(str);
            if (strM80078a != null) {
                strM80078a = strM80078a + "_tb";
            }
            if (strM80078a == null) {
                return null;
            }
            return this.f177t + strM80078a;
        }

        @Override // p007a6.AbstractC0053b.c
        /* renamed from: c */
        public int mo346c(String str) {
            boolean z10 = str == null || this.f163f == null;
            if (this.f160c == null || this.f161d == null || z10) {
                return 0;
            }
            boolean zContains = this.f163f.contains(str);
            String strMo343a0 = mo343a0(str);
            if (strMo343a0 == null) {
                return 0;
            }
            return m74728s0(str, strMo343a0, zContains);
        }

        @Override // p007a6.AbstractC0053b.c
        /* renamed from: k */
        public boolean mo362k() {
            if (this.f160c != null && this.f161d != null && this.f175r != null) {
                try {
                    m74726q0(m74730u0());
                    return true;
                } catch (IllegalArgumentException unused) {
                    C2111d.m12648d("BackupLauncher", "doBeforeRestore IllegalArgumentException error.");
                    this.f172o = false;
                } catch (Exception unused2) {
                    C2111d.m12648d("BackupLauncher", "doBeforeRestore error.");
                    this.f172o = false;
                    return false;
                }
            }
            return false;
        }

        @Override // p007a6.AbstractC0053b.c
        /* renamed from: o */
        public int mo370o() {
            if (C13348q.m80082b(this.f162e) || C13348q.m80082b(this.f163f)) {
                return -1;
            }
            Iterator<String> it = this.f162e.iterator();
            Cursor cursorM12618d = null;
            int count = 0;
            while (it.hasNext()) {
                String next = it.next();
                if (this.f163f.contains(next)) {
                    try {
                        try {
                            cursorM12618d = C2108a.m12618d(this.f160c, C13347p.m80079b(next), null, null, null, null);
                            if (cursorM12618d != null) {
                                count += cursorM12618d.getCount();
                            }
                        } catch (SQLiteException unused) {
                            C2111d.m12648d("BackupLauncher", "Get backup numbers SQLiteException.");
                            if (cursorM12618d != null) {
                            }
                        }
                        if (cursorM12618d != null) {
                            cursorM12618d.close();
                        }
                    } catch (Throwable th2) {
                        if (cursorM12618d != null) {
                            cursorM12618d.close();
                        }
                        throw th2;
                    }
                }
            }
            return count;
        }

        /* renamed from: p0 */
        public final void m74725p0(Cursor cursor, ContentValues contentValues) {
            if (cursor == null || contentValues == null) {
                return;
            }
            int columnCount = cursor.getColumnCount();
            for (int i10 = 0; i10 < columnCount; i10++) {
                int type = cursor.getType(i10);
                String columnName = cursor.getColumnName(i10);
                if (type == 0) {
                    contentValues.putNull(columnName);
                } else if (type == 1) {
                    contentValues.put(columnName, Long.valueOf(cursor.getLong(i10)));
                } else if (type == 2) {
                    contentValues.put(columnName, Float.valueOf(cursor.getFloat(i10)));
                } else if (type == 3) {
                    contentValues.put(columnName, cursor.getString(i10));
                } else if (type == 4) {
                    contentValues.put(columnName, cursor.getBlob(i10));
                }
            }
        }

        /* renamed from: q0 */
        public final void m74726q0(C12466b.a aVar) {
            C12466b.b bVarM74732g;
            C0052a c0052a = this.f175r;
            if ((c0052a instanceof C12466b) && (bVarM74732g = ((C12466b) c0052a).m74732g(this.f160c, aVar)) != null && bVarM74732g.m74740d()) {
                this.f172o = true;
                this.f162e = bVarM74732g.m74739c();
            }
        }

        /* renamed from: r0 */
        public final int m74727r0(boolean z10, int i10) {
            if (i10 == 1) {
                if (z10) {
                    m336U();
                    return 1;
                }
            } else if (z10) {
                m333R();
            }
            return 0;
        }

        /* renamed from: s0 */
        public final int m74728s0(String str, String str2, boolean z10) throws Throwable {
            Cursor cursorM12618d;
            this.f161d.mo169a();
            int iM74729t0 = 0;
            Cursor cursor = null;
            try {
                try {
                    cursorM12618d = C2108a.m12618d(this.f160c, C13347p.m80079b(str), null, null, null, null);
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (SQLiteException unused) {
            }
            if (cursorM12618d != null) {
                try {
                } catch (SQLiteException unused2) {
                    cursor = cursorM12618d;
                    C2111d.m12648d("BackupLauncher", "backupOneTable query SQLiteException.");
                    if (cursor != null) {
                        cursor.close();
                    }
                    this.f161d.mo171c();
                    return iM74729t0;
                } catch (Throwable th3) {
                    th = th3;
                    cursor = cursorM12618d;
                    if (cursor != null) {
                        cursor.close();
                    }
                    this.f161d.mo171c();
                    throw th;
                }
                if (cursorM12618d.moveToFirst()) {
                    ContentValues contentValues = new ContentValues();
                    while (!BackupObject.isAbort()) {
                        iM74729t0 = m74729t0(str2, z10, iM74729t0, cursorM12618d, contentValues);
                        if (!cursorM12618d.moveToNext()) {
                            break;
                        }
                    }
                    cursorM12618d.close();
                    this.f161d.mo171c();
                    return iM74729t0;
                }
            }
            if (cursorM12618d != null) {
                cursorM12618d.close();
            }
            this.f161d.mo171c();
            return 0;
        }

        /* renamed from: t0 */
        public final int m74729t0(String str, boolean z10, int i10, Cursor cursor, ContentValues contentValues) {
            try {
                contentValues.clear();
                m74725p0(cursor, contentValues);
                return m74727r0(z10, this.f161d.m185A(str, contentValues));
            } catch (IllegalArgumentException unused) {
                C2111d.m12648d("BackupLauncher", "backupOneTable IllegalArgumentException.");
                return i10;
            } catch (Exception unused2) {
                C2111d.m12648d("BackupLauncher", "backupOneTable error.");
                if (!z10) {
                    return i10;
                }
                m333R();
                return i10;
            }
        }

        /* renamed from: u0 */
        public final C12466b.a m74730u0() throws Exception {
            C12466b.a aVar = new C12466b.a();
            aVar.m74736d(m355g0(this.f161d).getAsInteger("version").intValue());
            m351e0();
            if (C13348q.m80082b(this.f162e)) {
                return aVar;
            }
            Iterator<String> it = this.f162e.iterator();
            while (it.hasNext()) {
                C12466b.c cVarM74731v0 = m74731v0(it.next());
                if (cVarM74731v0 != null) {
                    aVar.m74735c().add(cVarM74731v0);
                }
            }
            return aVar;
        }

        /* renamed from: v0 */
        public final C12466b.c m74731v0(String str) {
            if (str == null) {
                return null;
            }
            ContentValues[] contentValuesArrM200s = this.f161d.m200s(mo343a0(str), null, null, null, null);
            return new C12466b.c(str, contentValuesArrM200s != null ? contentValuesArrM200s.length : 0);
        }
    }

    static {
        f57392b = C9142g.m57463b() ? "com.hihonor.android.launcher.permission.WRITE_SETTINGS" : "com.huawei.android.launcher.permission.WRITE_SETTINGS";
        f57393c = C9142g.m57463b() ? "com.hihonor.android.launcher.permission.READ_SETTINGS" : "com.huawei.android.launcher.permission.READ_SETTINGS";
        f57394d = C9142g.m57463b() ? "content://com.hihonor.android.launcher.settings" : "content://com.huawei.android.launcher.settings";
    }

    /* renamed from: I */
    public static boolean m74721I(Context context) {
        return C2157a.m13192a(context, f57393c) && C2157a.m13192a(context, f57392b);
    }

    @Override // p007a6.AbstractC0053b
    /* renamed from: C */
    public ArrayList<String> mo296C(Context context, String str, String str2) {
        return new ArrayList<>(Collections.singletonList(f57394d));
    }

    /* renamed from: J */
    public final boolean m74722J(Handler.Callback callback, Object obj, List<AbstractC0053b.c> list, ArrayList<AbstractC0053b.c> arrayList) {
        for (AbstractC0053b.c cVar : list) {
            if (cVar != null && cVar.mo362k()) {
                if (!cVar.m326K()) {
                    C2111d.m12653i("BackupLauncher", "Launcher permit is false");
                    sendMsg(7, 0, 0, callback, obj);
                    return true;
                }
                arrayList.add(cVar);
            }
        }
        return false;
    }

    /* renamed from: K */
    public final void m74723K(List<AbstractC0053b.c> list) {
        for (AbstractC0053b.c cVar : list) {
            if (cVar != null) {
                this.subKeyTotalNum += cVar.m325J();
            }
        }
    }

    /* renamed from: L */
    public final void m74724L(List<AbstractC0053b.c> list, StringBuilder sb2) {
        String strM372p;
        for (AbstractC0053b.c cVar : list) {
            if (cVar != null && (strM372p = cVar.m372p()) != null) {
                sb2.append(strM372p);
                sb2.append(";");
            }
        }
    }

    @Override // p007a6.AbstractC0053b, com.huawei.android.backup.service.logic.BackupObject
    public boolean isSupported(Context context, String str) {
        try {
            int iM65395e = C10713c.m65395e(BackupObject.getExecuteParameter(), CloneService.KEY_ACTION_FLAG, 1);
            if (iM65395e == 3 || iM65395e == 2) {
                if (C2157a.m13211s() < 8) {
                    return false;
                }
            }
        } catch (BadParcelableException unused) {
            C2111d.m12648d("BackupLauncher", "bad data.");
        }
        if (m74721I(context)) {
            return !mo301w(context, null, null, str, null).isEmpty();
        }
        return false;
    }

    @Override // p007a6.AbstractC0053b, com.huawei.android.backup.service.logic.BackupObject
    public int onBackup(Context context, AbstractC0048c abstractC0048c, Handler.Callback callback, Object obj, String str) {
        C2111d.m12653i("BackupLauncher", "Backup launcher.");
        if (abstractC0048c == null) {
            return 2;
        }
        if (!C10713c.m65391a(BackupObject.getExecuteParameter(), "oldPhoneVersionHigher") && C10713c.m65391a(BackupObject.getExecuteParameter(), "isSupportShortcutBackup") && new PMSbackupRestoreUtil(context).m12729t("HWlanucher", 4, null, null) == 0) {
            this.backupFliedList.addAll(C13334c.m79985r(C2154m.m13104i("HWlanucher")));
            C2111d.m12653i("BackupLauncher", "backup shotcut success.");
        }
        List<AbstractC0053b.c> listMo301w = mo301w(context, abstractC0048c, new AbstractC0053b.a(callback, obj), str, null);
        if (listMo301w.isEmpty() || !m302x(listMo301w)) {
            return 2;
        }
        int iM298E = m298E(listMo301w);
        this.subKeyTotalNum = iM298E;
        if (iM298E == 0) {
            return 2;
        }
        int iM294A = m294A(listMo301w);
        if (iM294A == 0) {
            C2111d.m12648d("BackupLauncher", "No record backup success!");
            return 2;
        }
        for (AbstractC0053b.c cVar : listMo301w) {
            if (cVar != null) {
                cVar.m354g();
            }
        }
        StringBuilder sb2 = new StringBuilder();
        m74724L(listMo301w, sb2);
        this.backupFileModuleInfo.updateModuleInfo(iM294A, 8, sb2.toString());
        if (this.backupFileModuleInfo.hasRecord()) {
            return 1;
        }
        abstractC0048c.m190h();
        return 1;
    }

    @Override // p007a6.AbstractC0053b, com.huawei.android.backup.service.logic.BackupObject
    public Bundle onBackupModulesDataItemTotal(Context context, Long l10, int i10, String str) {
        int iMo303y = mo303y(context, str);
        C2111d.m12654j("BackupLauncher", "Backup modules data item is ", Integer.valueOf(iMo303y));
        Bundle bundle = new Bundle();
        if (iMo303y >= 0) {
            bundle.putInt("ModuleCount", iMo303y + 1);
            bundle.putLong("ModuleSize", 2048000L);
        }
        return bundle;
    }

    @Override // p007a6.AbstractC0053b, com.huawei.android.backup.service.logic.BackupObject
    public int onRestore(Context context, AbstractC0048c abstractC0048c, Handler.Callback callback, Object obj, String str) {
        if (context == null || abstractC0048c == null) {
            return 5;
        }
        C2111d.m12653i("BackupLauncher", "Restore launcher.");
        if (C13349r.m80088d() && C10713c.m65391a(BackupObject.getExecuteParameter(), "isSupportShortcutBackup") && new PMSbackupRestoreUtil(context).m12731v("HWlanucher", 4, abstractC0048c.m198p(), null) == 0) {
            C2111d.m12653i("BackupLauncher", "restore shotcut success.");
        }
        List<AbstractC0053b.c> listMo301w = mo301w(context, abstractC0048c, new AbstractC0053b.a(callback, obj), str, null);
        if (listMo301w.isEmpty()) {
            return 5;
        }
        ArrayList<AbstractC0053b.c> arrayList = new ArrayList<>();
        if (m74722J(callback, obj, listMo301w, arrayList)) {
            return 7;
        }
        m74723K(arrayList);
        if (this.subKeyTotalNum == 0) {
            C2111d.m12648d("BackupLauncher", "There is no value in back table!");
            return 5;
        }
        for (AbstractC0053b.c cVar : arrayList) {
            if (cVar != null) {
                cVar.m368n();
            }
        }
        for (AbstractC0053b.c cVar2 : arrayList) {
            if (cVar2 != null) {
                cVar2.m356h();
            }
        }
        return 4;
    }

    @Override // p007a6.AbstractC0053b
    /* renamed from: w */
    public List<AbstractC0053b.c> mo301w(Context context, AbstractC0048c abstractC0048c, InterfaceC2155n interfaceC2155n, String str, String str2) {
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = mo296C(context, str, str2).iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (next != null) {
                Uri uriM80079b = C13347p.m80079b(next);
                arrayList.add(new a(interfaceC2155n, context, abstractC0048c, new C12466b(uriM80079b), new AbstractC0053b.b(str, m297D(uriM80079b))));
            }
        }
        return arrayList;
    }

    @Override // p007a6.AbstractC0053b
    /* renamed from: y */
    public int mo303y(Context context, String str) {
        List<AbstractC0053b.c> listMo301w = mo301w(context, null, null, str, null);
        if (listMo301w.isEmpty()) {
            return -1;
        }
        int i10 = 0;
        int i11 = 0;
        for (AbstractC0053b.c cVar : listMo301w) {
            if (cVar != null) {
                int iM320E = cVar.m320E();
                if (iM320E < 0) {
                    i10++;
                } else {
                    i11 += iM320E;
                }
            }
        }
        if (i10 == listMo301w.size()) {
            return -1;
        }
        return i11;
    }
}
