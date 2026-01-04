package p700v5;

import android.content.ContentProviderClient;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.huawei.android.backup.filelogic.utils.C2108a;
import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.android.backup.service.logic.BackupObject;
import com.huawei.android.backup.service.logic.C2126b;
import com.huawei.android.backup.service.utils.C2157a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import p006a5.AbstractC0048c;
import p229di.C9142g;
import p648t5.C12939b;
import p699v4.C13333b;
import p699v4.C13347p;
import p699v4.C13348q;

/* renamed from: v5.b */
/* loaded from: classes.dex */
public class C13352b extends AbstractC13351a {

    /* renamed from: d */
    public static final String f60177d;

    /* renamed from: a */
    public a[] f60178a = {new a(C13353c.f60182a), new a(C13353c.f60183b)};

    /* renamed from: b */
    public String[] f60179b = null;

    /* renamed from: c */
    public Uri f60180c = null;

    /* renamed from: v5.b$a */
    public static class a {

        /* renamed from: a */
        public Uri f60181a;

        public a(Uri uri) {
            this.f60181a = uri;
        }
    }

    static {
        f60177d = C9142g.m57463b() ? "content://com.hihonor.provider.NotePad.backup" : "content://com.huawei.provider.NotePad.backup";
    }

    /* renamed from: a */
    private String[] m80091a(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            if (C13353c.m80101a(str)) {
                arrayList.add(str);
            }
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    /* renamed from: e */
    private int m80092e(Context context) {
        a[] aVarArr = this.f60178a;
        int length = aVarArr.length;
        int count = 0;
        int i10 = 0;
        int i11 = 0;
        while (true) {
            if (i10 >= length) {
                break;
            }
            Cursor cursorM12618d = null;
            try {
                try {
                    try {
                        Uri uri = aVarArr[i10].f60181a;
                        String[] strArr = new String[1];
                        strArr[count] = "_id";
                        cursorM12618d = C2108a.m12618d(context, uri, strArr, null, null, null);
                    } catch (Exception unused) {
                        C2111d.m12648d("BackupNotepad", "Get backup numbers failed");
                        i11++;
                        if (cursorM12618d != null) {
                        }
                    }
                } catch (SQLException unused2) {
                    C2111d.m12648d("BackupNotepad", "Get backup numbers exception");
                    i11++;
                    if (cursorM12618d != null) {
                    }
                }
                if (cursorM12618d != null) {
                    count = cursorM12618d.getCount();
                    cursorM12618d.close();
                    break;
                }
                i11++;
                if (cursorM12618d != null) {
                    cursorM12618d.close();
                }
                i10++;
            } catch (Throwable th2) {
                if (cursorM12618d != null) {
                    cursorM12618d.close();
                }
                throw th2;
            }
        }
        if (i11 < this.f60178a.length) {
            return count;
        }
        C2111d.m12653i("BackupNotepad", "Notepad isn't exist");
        return -1;
    }

    private boolean init(Context context, int i10, AbstractC0048c abstractC0048c) {
        for (a aVar : this.f60178a) {
            String[] strArrM13202j = C2157a.m13202j(context, aVar.f60181a);
            if (strArrM13202j.length > 0) {
                if (i10 == 1) {
                    this.f60179b = m80091a(strArrM13202j);
                } else if (i10 != 2 || abstractC0048c == null) {
                    this.f60179b = null;
                } else {
                    this.f60179b = m80093j(strArrM13202j, abstractC0048c);
                }
            }
            String[] strArr = this.f60179b;
            if (strArr != null && strArr.length > 0) {
                this.f60180c = aVar.f60181a;
                return true;
            }
        }
        return false;
    }

    /* renamed from: j */
    private String[] m80093j(String[] strArr, AbstractC0048c abstractC0048c) {
        ArrayList arrayList = new ArrayList();
        Set<String> setMo202u = abstractC0048c.mo202u("notes_tb");
        if (C13348q.m80082b(setMo202u)) {
            return (String[]) arrayList.toArray(new String[0]);
        }
        for (String str : strArr) {
            if (C13353c.m80101a(str) && setMo202u.contains(str)) {
                arrayList.add(str);
            }
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    /* renamed from: b */
    public final void m80094b(int i10, C2126b.a aVar, AbstractC0048c abstractC0048c) {
        if (i10 == 1) {
            this.backupFileModuleInfo.updateModuleInfo(aVar.m12766e(), 8, "notes");
        }
        if (this.backupFileModuleInfo.hasRecord()) {
            return;
        }
        abstractC0048c.m190h();
    }

    /* renamed from: c */
    public final int m80095c(Context context, AbstractC0048c abstractC0048c, Handler.Callback callback, Object obj) {
        if (init(context, 2, abstractC0048c)) {
            return m80099h(context, abstractC0048c, callback, obj);
        }
        return 5;
    }

    /* renamed from: d */
    public final int m80096d(Context context, AbstractC0048c abstractC0048c, Handler.Callback callback, Object obj) throws Throwable {
        C12939b c12939b = new C12939b(C13347p.m80079b(f60177d));
        C12939b.a aVar = new C12939b.a();
        aVar.m77712c(-1);
        C12939b.b bVarM77709h = c12939b.m77709h(context, aVar);
        if (bVarM77709h == null || bVarM77709h.m77713a()) {
            return 5;
        }
        this.f60179b = null;
        String strM77714b = bVarM77709h.m77714b();
        if (strM77714b != null) {
            this.f60180c = C13347p.m80079b(strM77714b);
        }
        int iM80100i = m80100i(context, abstractC0048c, callback, obj);
        c12939b.m224e(context);
        return iM80100i;
    }

    /* renamed from: f */
    public final void m80097f(ContentProviderClient contentProviderClient, ContentValues[] contentValuesArr, int i10, Handler.Callback callback, Object obj) {
        if (i10 < 0 || i10 >= contentValuesArr.length) {
            return;
        }
        if (C13333b.m79953a(contentProviderClient, this.f60180c, contentValuesArr[i10])) {
            sendMsg(3, i10 + 1, contentValuesArr.length, callback, obj);
        } else {
            sendMsg(5, i10 + 1, contentValuesArr.length, callback, obj);
        }
    }

    /* renamed from: g */
    public final boolean m80098g(Context context) {
        return (context == null || new C12939b(C13347p.m80079b(f60177d)).mo221b(context, null) == null) ? false : true;
    }

    /* renamed from: h */
    public final int m80099h(Context context, AbstractC0048c abstractC0048c, Handler.Callback callback, Object obj) {
        ContentValues[] contentValuesArrM200s;
        if (abstractC0048c == null || (contentValuesArrM200s = abstractC0048c.m200s("notes_tb", this.f60179b, null, null, null)) == null || contentValuesArrM200s.length <= 0) {
            return 5;
        }
        String[] strArr = {"title", "note", "modified"};
        HashSet<Integer> hashSetBuildCurrHashSet = BackupObject.buildCurrHashSet(context, this.f60180c, C13353c.m80102b(), null, strArr);
        ContentProviderClient contentProviderClientM12617c = C2108a.m12617c(context, this.f60180c);
        for (int i10 = 0; i10 < contentValuesArrM200s.length && !BackupObject.isAbort(); i10++) {
            try {
                if (BackupObject.containsKeys(contentValuesArrM200s[i10], strArr, hashSetBuildCurrHashSet)) {
                    sendMsg(3, i10 + 1, contentValuesArrM200s.length, callback, obj);
                } else {
                    m80097f(contentProviderClientM12617c, contentValuesArrM200s, i10, callback, obj);
                }
            } finally {
                if (contentProviderClientM12617c != null) {
                    contentProviderClientM12617c.close();
                }
            }
        }
    }

    /* renamed from: i */
    public final int m80100i(Context context, AbstractC0048c abstractC0048c, Handler.Callback callback, Object obj) {
        ContentValues[] contentValuesArrM200s;
        if (abstractC0048c == null || (contentValuesArrM200s = abstractC0048c.m200s("notes_tb", this.f60179b, null, null, null)) == null || contentValuesArrM200s.length <= 0) {
            return 5;
        }
        ContentProviderClient contentProviderClientM12617c = C2108a.m12617c(context, this.f60180c);
        for (int i10 = 0; i10 < contentValuesArrM200s.length && !BackupObject.isAbort(); i10++) {
            try {
                m80097f(contentProviderClientM12617c, contentValuesArrM200s, i10, callback, obj);
            } finally {
                if (contentProviderClientM12617c != null) {
                    contentProviderClientM12617c.close();
                }
            }
        }
    }

    @Override // com.huawei.android.backup.service.logic.BackupObject
    public boolean isSupported(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        return m80098g(context) || init(context, 1, null);
    }

    @Override // com.huawei.android.backup.service.logic.BackupObject
    public int onBackup(Context context, AbstractC0048c abstractC0048c, Handler.Callback callback, Object obj, String str) {
        C2111d.m12653i("BackupNotepad", "Backup notepad.");
        if (context == null || abstractC0048c == null || obj == null) {
            return 2;
        }
        Cursor cursorM12618d = null;
        if (!init(context, 1, null)) {
            return 2;
        }
        C2126b.a aVar = new C2126b.a(callback, obj);
        try {
            try {
                try {
                    cursorM12618d = C2108a.m12618d(context, this.f60180c, this.f60179b, null, null, null);
                    if (cursorM12618d != null && cursorM12618d.moveToFirst()) {
                        int count = cursorM12618d.getCount();
                        ContentValues[] contentValuesArr = new ContentValues[count];
                        int i10 = 0;
                        while (cursorM12618d.getPosition() != count && !BackupObject.isAbort() && i10 < count) {
                            contentValuesArr[i10] = C2157a.m13213u(cursorM12618d, C13353c.m80102b());
                            i10++;
                            cursorM12618d.moveToNext();
                        }
                        int iMo186B = abstractC0048c.mo186B("notes_tb", contentValuesArr, this.backupObjectCallback, aVar);
                        cursorM12618d.close();
                        m80094b(iMo186B, aVar, abstractC0048c);
                        return storeHandlerMsgToObjectMsg(iMo186B);
                    }
                    return 1;
                } catch (SQLException unused) {
                    C2111d.m12648d("BackupNotepad", "Backup exception");
                    if (cursorM12618d != null) {
                        cursorM12618d.close();
                    }
                    return 2;
                }
            } catch (Exception unused2) {
                C2111d.m12648d("BackupNotepad", "Backup failed");
                if (cursorM12618d != null) {
                    cursorM12618d.close();
                }
                return 2;
            }
        } finally {
            if (cursorM12618d != null) {
                cursorM12618d.close();
            }
        }
    }

    @Override // com.huawei.android.backup.service.logic.BackupObject
    public Bundle onBackupModulesDataItemTotal(Context context, Long l10, int i10, String str) {
        if (context == null || m80098g(context)) {
            return null;
        }
        int iM80092e = m80092e(context);
        C2111d.m12654j("BackupNotepad", "onBackupModulesDataItemTotal begin,moduleName: ", str, ",totalNumber: ", Integer.valueOf(iM80092e), ",packageSize: ", l10);
        if (iM80092e < 0) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("ModuleCount", iM80092e);
        bundle.putLong("ModuleSize", l10.longValue());
        return bundle;
    }

    @Override // com.huawei.android.backup.service.logic.BackupObject
    public int onRestore(Context context, AbstractC0048c abstractC0048c, Handler.Callback callback, Object obj, String str) {
        C2111d.m12653i("BackupNotepad", "Restore notepad.");
        if (context == null) {
            return 5;
        }
        return m80098g(context) ? m80096d(context, abstractC0048c, callback, obj) : m80095c(context, abstractC0048c, callback, obj);
    }
}
