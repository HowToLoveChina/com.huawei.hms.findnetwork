package p485n5;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.net.Uri;
import android.os.Bundle;
import com.huawei.android.backup.filelogic.utils.C2108a;
import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.android.backup.service.logic.BackupObject;
import com.huawei.android.backup.service.logic.InterfaceC2155n;
import com.huawei.android.backup.service.utils.C2157a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import p006a5.AbstractC0048c;
import p007a6.AbstractC0053b;
import p007a6.C0052a;
import p229di.C9142g;
import p279f6.C9662e;
import p386j6.C10713c;
import p699v4.C13347p;

/* renamed from: n5.a */
/* loaded from: classes.dex */
public class C11634a extends AbstractC0053b {

    /* renamed from: b */
    public static final String f53967b;

    /* renamed from: c */
    public static final String f53968c;

    /* renamed from: d */
    public static final Uri f53969d;

    /* renamed from: n5.a$a */
    public static class a extends AbstractC0053b.c {
        public a(InterfaceC2155n interfaceC2155n, Context context, AbstractC0048c abstractC0048c, C0052a c0052a, AbstractC0053b.b bVar) {
            super(interfaceC2155n, context, abstractC0048c, c0052a, bVar.m315b(), bVar.m314a());
        }

        /* renamed from: p0 */
        public static int m69503p0(int i10, String str, String str2) {
            return ("pdu".equals(str) && C11634a.f53968c.equals(str2)) ? 4 : 1;
        }

        @Override // p007a6.AbstractC0053b.c
        /* renamed from: c */
        public int mo346c(String str) throws Throwable {
            if (this.f161d != null && str != null && this.f163f != null) {
                String strMo343a0 = mo343a0(str);
                boolean zContains = this.f163f.contains(str);
                HashMap<String, Integer> mapM69505r0 = m69505r0(str);
                C9662e c9662e = new C9662e(C13347p.m80079b(str), null, null, null, null);
                c9662e.m60337g(mapM69505r0);
                ContentValues[] backupValues = BackupObject.getBackupValues(this.f160c, c9662e);
                if (backupValues.length != 0 && strMo343a0 != null) {
                    return m69506s0(backupValues, strMo343a0, zContains);
                }
            }
            return 0;
        }

        /* renamed from: q0 */
        public final HashMap<String, Integer> m69504q0(String str, Cursor cursor) {
            if (cursor == null || !cursor.moveToFirst()) {
                C2111d.m12648d("BackupHarassment", "uri is null.");
                return null;
            }
            HashMap<String, Integer> map = new HashMap<>();
            String[] columnNames = cursor.getColumnNames();
            for (int i10 = 0; i10 < columnNames.length; i10++) {
                map.put(columnNames[i10], Integer.valueOf(m69503p0(cursor.getType(i10), columnNames[i10], str)));
            }
            return map;
        }

        /* renamed from: r0 */
        public final HashMap<String, Integer> m69505r0(String str) throws Throwable {
            Context context = this.f160c;
            HashMap<String, Integer> mapM69504q0 = null;
            if (context != null && str != null) {
                try {
                    Cursor cursorM12618d = C2108a.m12618d(context, C13347p.m80079b(str), null, null, null, null);
                    try {
                        mapM69504q0 = m69504q0(str, cursorM12618d);
                        if (cursorM12618d != null) {
                            cursorM12618d.close();
                        }
                    } finally {
                    }
                } catch (SQLException unused) {
                    C2111d.m12648d("BackupHarassment", "getFields SQLException");
                } catch (Exception unused2) {
                    C2111d.m12648d("BackupHarassment", "getFields Exception");
                }
            }
            return mapM69504q0;
        }

        /* renamed from: s0 */
        public final int m69506s0(ContentValues[] contentValuesArr, String str, boolean z10) {
            this.f161d.mo169a();
            int i10 = 0;
            for (ContentValues contentValues : contentValuesArr) {
                if (BackupObject.isAbort()) {
                    break;
                }
                if (this.f161d.m185A(str, contentValues) == 1) {
                    if (z10) {
                        m336U();
                        i10++;
                    }
                } else if (z10) {
                    m333R();
                }
            }
            this.f161d.mo171c();
            return i10;
        }
    }

    static {
        f53967b = C9142g.m57463b() ? "content://com.hihonor.systemmanager.HarassmentInterceptionDBProvider" : "content://com.huawei.systemmanager.HarassmentInterceptionDBProvider";
        f53968c = C9142g.m57463b() ? "content://com.hihonor.systemmanager.HarassmentInterceptionDBProvider/interception_messages_backup" : "content://com.huawei.systemmanager.HarassmentInterceptionDBProvider/interception_messages_backup";
        f53969d = C13347p.m80079b(C9142g.m57463b() ? "content://com.hihonor.systemmanager.BackupModuleProvider" : "content://com.huawei.systemmanager.BackupModuleProvider");
    }

    @Override // p007a6.AbstractC0053b
    /* renamed from: C */
    public ArrayList<String> mo296C(Context context, String str, String str2) {
        Bundle bundleM12615a;
        if (context == null || (bundleM12615a = C2108a.m12615a(context, f53969d, "all_module_provider_uri_query", null, reassembleExtra(null))) == null) {
            return null;
        }
        ArrayList<String> arrayListM65401k = bundleM12615a.containsKey("all_module_provider_uri_list") ? C10713c.m65401k(bundleM12615a, "all_module_provider_uri_list") : null;
        if (arrayListM65401k == null || arrayListM65401k.size() == 0) {
            return null;
        }
        Iterator<String> it = arrayListM65401k.iterator();
        while (it.hasNext()) {
            String next = it.next();
            String str3 = f53967b;
            if (str3.equals(next)) {
                return new ArrayList<>(Collections.singletonList(str3));
            }
        }
        return null;
    }

    @Override // p007a6.AbstractC0053b, com.huawei.android.backup.service.logic.BackupObject
    public boolean isSupported(Context context, String str) {
        if (context == null) {
            return false;
        }
        return C2157a.m13186U(context);
    }

    @Override // p007a6.AbstractC0053b
    /* renamed from: w */
    public List<AbstractC0053b.c> mo301w(Context context, AbstractC0048c abstractC0048c, InterfaceC2155n interfaceC2155n, String str, String str2) {
        ArrayList arrayList = new ArrayList();
        ArrayList<String> arrayListMo296C = mo296C(context, str, str2);
        if (arrayListMo296C == null) {
            return arrayList;
        }
        Iterator<String> it = arrayListMo296C.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (next != null) {
                Uri uriM80079b = C13347p.m80079b(next);
                arrayList.add(new a(interfaceC2155n, context, abstractC0048c, new C11635b(uriM80079b), new AbstractC0053b.b(str, m297D(uriM80079b))));
            }
        }
        return arrayList;
    }
}
