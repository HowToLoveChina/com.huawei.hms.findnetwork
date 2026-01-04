package p309g5;

import android.content.ContentProviderClient;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteException;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import com.huawei.android.backup.filelogic.utils.C2108a;
import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.android.backup.service.logic.BackupObject;
import com.huawei.android.backup.service.utils.C2157a;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import p006a5.AbstractC0048c;
import p699v4.C13333b;
import p699v4.C13339h;
import p699v4.C13347p;

/* renamed from: g5.c */
/* loaded from: classes.dex */
public class C9886c extends AbstractC9885b {

    /* renamed from: a */
    public final a[] f48517a = {new a("deskclock_alarm_tb", "content://com.android.deskclock/alarm", null), new a("alarmclock_alarm_tb", "content://com.android.alarmclock/alarm", null)};

    /* renamed from: b */
    public String[] f48518b = null;

    /* renamed from: c */
    public int f48519c = 0;

    /* renamed from: d */
    public int f48520d = 0;

    /* renamed from: e */
    public int f48521e = 0;

    /* renamed from: g5.c$a */
    public static class a {

        /* renamed from: a */
        public String f48522a;

        /* renamed from: b */
        public String f48523b;

        /* renamed from: c */
        public ContentValues[] f48524c;

        public a(String str, String str2, ContentValues[] contentValuesArr) {
            this.f48522a = str;
            this.f48523b = str2;
            this.f48524c = contentValuesArr;
        }
    }

    /* renamed from: a */
    public final void m61337a(Context context, Uri uri) {
        if (uri != null) {
            try {
                context.getContentResolver().delete(uri, null, null);
            } catch (SQLiteException unused) {
                C2111d.m12648d("BackupAlarmImp", "Alarm delete record ERROR!");
            } catch (Exception unused2) {
                C2111d.m12648d("BackupAlarmImp", "Alarm delete failed.");
            }
        }
    }

    /* renamed from: b */
    public int m61338b(Context context) throws IOException {
        Cursor cursorM12618d = null;
        int iM61344h = 0;
        for (a aVar : this.f48517a) {
            try {
                try {
                    Uri uriM80079b = C13347p.m80079b(aVar.f48523b);
                    if (C2157a.m13184S(context, uriM80079b)) {
                        cursorM12618d = C2108a.m12618d(context, uriM80079b, null, "_id = 0", null, null);
                        iM61344h = m61344h(cursorM12618d, aVar);
                    }
                } catch (SQLiteException unused) {
                    C2111d.m12648d("BackupAlarmImp", "Alarm query record RuntimeException ERROR!");
                } catch (Exception unused2) {
                    C2111d.m12648d("BackupAlarmImp", "Alarm query failed.");
                }
            } finally {
                C13339h.m80014a(cursorM12618d);
            }
        }
        return iM61344h;
    }

    /* renamed from: c */
    public final ContentValues[] m61339c(Context context, a aVar) {
        if (aVar == null) {
            return new ContentValues[0];
        }
        Uri uriM80079b = C13347p.m80079b(aVar.f48523b);
        if (!C2157a.m13184S(context, uriM80079b)) {
            return new ContentValues[0];
        }
        Cursor cursor = null;
        try {
            try {
                try {
                    Cursor cursorM12618d = C2108a.m12618d(context, uriM80079b, this.f48518b, null, null, null);
                    if (cursorM12618d != null && cursorM12618d.getCount() > 0) {
                        int count = cursorM12618d.getCount();
                        ContentValues[] contentValuesArr = new ContentValues[count];
                        cursorM12618d.moveToFirst();
                        int i10 = 0;
                        while (!BackupObject.isAbort()) {
                            int i11 = i10 + 1;
                            contentValuesArr[i10] = C2157a.m13213u(cursorM12618d, C9884a.m61336a());
                            if (!cursorM12618d.moveToNext()) {
                                break;
                            }
                            i10 = i11;
                        }
                        this.f48519c += count;
                        cursorM12618d.close();
                        return contentValuesArr;
                    }
                    ContentValues[] contentValuesArr2 = new ContentValues[0];
                    if (cursorM12618d != null) {
                        cursorM12618d.close();
                    }
                    return contentValuesArr2;
                } catch (Exception unused) {
                    C2111d.m12648d("BackupAlarmImp", "Get alarm records failed.");
                    ContentValues[] contentValuesArr3 = new ContentValues[0];
                    if (0 != 0) {
                        cursor.close();
                    }
                    return contentValuesArr3;
                }
            } catch (SQLiteException unused2) {
                C2111d.m12648d("BackupAlarmImp", "Get alarm records ERROR!");
                ContentValues[] contentValuesArr4 = new ContentValues[0];
                if (0 != 0) {
                    cursor.close();
                }
                return contentValuesArr4;
            }
        } catch (Throwable th2) {
            if (0 != 0) {
                cursor.close();
            }
            throw th2;
        }
    }

    /* renamed from: d */
    public final int m61340d(Context context) {
        Cursor cursorM12618d = null;
        int i10 = 0;
        int count = 0;
        for (a aVar : this.f48517a) {
            Uri uriM80079b = C13347p.m80079b(aVar.f48523b);
            if (C2157a.m13184S(context, uriM80079b)) {
                try {
                    try {
                        try {
                            cursorM12618d = C2108a.m12618d(context, uriM80079b, new String[]{"_id"}, null, null, null);
                            if (cursorM12618d != null) {
                                count += cursorM12618d.getCount();
                            } else {
                                i10++;
                            }
                        } catch (Exception unused) {
                            C2111d.m12648d("BackupAlarmImp", "Get alarm record failed");
                            i10++;
                            if (cursorM12618d != null) {
                            }
                        }
                    } catch (SQLException unused2) {
                        C2111d.m12648d("BackupAlarmImp", "Get alarm record record SQLException ERROR!");
                        i10++;
                        if (cursorM12618d != null) {
                        }
                    }
                    if (cursorM12618d != null) {
                        cursorM12618d.close();
                        cursorM12618d = null;
                    }
                } catch (Throwable th2) {
                    if (cursorM12618d != null) {
                        cursorM12618d.close();
                    }
                    throw th2;
                }
            }
        }
        if (i10 < 2) {
            return count;
        }
        C2111d.m12646b("BackupAlarmImp", "Alarm isn't exist.");
        return -1;
    }

    /* renamed from: e */
    public final void m61341e() {
        a[] aVarArr = this.f48517a;
        ContentValues[] contentValuesArr = aVarArr[0].f48524c;
        if (contentValuesArr != null && contentValuesArr.length != 0) {
            this.f48519c = contentValuesArr.length;
        }
        ContentValues[] contentValuesArr2 = aVarArr[1].f48524c;
        if (contentValuesArr2 == null || contentValuesArr2.length == 0) {
            return;
        }
        this.f48519c += contentValuesArr2.length;
    }

    /* renamed from: f */
    public final String[] m61342f(String[] strArr, int i10, AbstractC0048c abstractC0048c, a aVar) {
        if (strArr == null || strArr.length == 0) {
            return new String[0];
        }
        ArrayList<String> arrayList = new ArrayList<>();
        if (i10 == 1) {
            for (String str : strArr) {
                if (C9884a.m61336a().containsKey(str)) {
                    arrayList.add(str);
                }
            }
        }
        if (i10 == 2 && abstractC0048c != null) {
            m61343g(abstractC0048c.mo202u(aVar.f48522a), arrayList, strArr);
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    /* renamed from: g */
    public final void m61343g(Set<String> set, ArrayList<String> arrayList, String[] strArr) {
        if (set == null || set.size() <= 0) {
            return;
        }
        for (String str : strArr) {
            if (C9884a.m61336a().containsKey(str) && set.contains(str)) {
                arrayList.add(str);
            }
        }
    }

    /* renamed from: h */
    public final int m61344h(Cursor cursor, a aVar) {
        ContentValues[] contentValuesArr;
        if (cursor != null || (contentValuesArr = aVar.f48524c) == null) {
            return 0;
        }
        return contentValuesArr.length;
    }

    /* renamed from: i */
    public final int m61345i(Context context) {
        if (context == null) {
            C2111d.m12648d("BackupAlarmImp", "getVolumeMax : context is null");
            return 4;
        }
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        if (audioManager == null) {
            return 4;
        }
        return audioManager.getStreamMaxVolume(4);
    }

    public boolean init(Context context, int i10, AbstractC0048c abstractC0048c) {
        for (a aVar : this.f48517a) {
            Uri uriM80079b = C13347p.m80079b(aVar.f48523b);
            if (C2157a.m13184S(context, uriM80079b)) {
                String[] strArrM61342f = m61342f(C2157a.m13202j(context, uriM80079b), i10, abstractC0048c, aVar);
                this.f48518b = strArrM61342f;
                if (strArrM61342f.length > 0) {
                    break;
                }
            }
        }
        String[] strArr = this.f48518b;
        return strArr != null && strArr.length > 0;
    }

    @Override // com.huawei.android.backup.service.logic.BackupObject
    public boolean isSupported(Context context, String str) {
        return init(context, 1, null);
    }

    /* renamed from: j */
    public final boolean m61346j(a aVar, Handler.Callback callback, Object obj, int i10, boolean z10) {
        if (i10 == 1) {
            int iStoreHandlerMsgToObjectMsg = storeHandlerMsgToObjectMsg(0);
            int i11 = this.f48521e + 1;
            this.f48521e = i11;
            sendMsg(iStoreHandlerMsgToObjectMsg, i11, this.f48519c, callback, obj);
            this.f48520d++;
            return z10;
        }
        int iStoreHandlerMsgToObjectMsg2 = storeHandlerMsgToObjectMsg(i10);
        int i12 = this.f48521e + 1;
        this.f48521e = i12;
        sendMsg(iStoreHandlerMsgToObjectMsg2, i12, this.f48519c, callback, obj);
        if (z10) {
            return z10;
        }
        sendMsg(100, C2111d.m12652h("BackupAlarmImp", "alarm", "writeValue", "write storeHandler fail table =" + aVar.f48522a), callback, obj);
        return true;
    }

    /* renamed from: k */
    public final void m61347k(a aVar, Handler.Callback callback, Object obj, Exception exc) {
        sendMsg(100, C2111d.m12652h("BackupAlarmImp", "alarm", "writeValue", "operateExceptiontable =" + aVar.f48522a), callback, obj);
    }

    /* renamed from: l */
    public final boolean m61348l(a aVar, Handler.Callback callback, Object obj, boolean z10) {
        if (!z10) {
            sendMsg(101, C2111d.m12652h("BackupAlarmImp", "alarm", "processRestoreAlarm", "insert fail uri =" + aVar.f48523b), callback, obj);
        }
        int i10 = this.f48521e + 1;
        this.f48521e = i10;
        sendMsg(5, i10, this.f48519c, callback, obj);
        return true;
    }

    /* renamed from: m */
    public final void m61349m(Context context, a aVar, boolean z10, Handler.Callback callback, Object obj) throws Throwable {
        ContentProviderClient contentProviderClientM12617c;
        C2111d.m12653i("BackupAlarmImp", "Process restore alarm.");
        ContentValues[] contentValuesArr = aVar.f48524c;
        if (contentValuesArr == null) {
            return;
        }
        ContentProviderClient contentProviderClient = null;
        try {
            contentProviderClientM12617c = C2108a.m12617c(context, C13347p.m80079b(aVar.f48523b));
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            boolean zM61348l = false;
            for (ContentValues contentValues : contentValuesArr) {
                if (BackupObject.isAbort()) {
                    break;
                }
                if (z10 && !contentValues.containsKey("volume")) {
                    contentValues.put("volume", Integer.valueOf(Math.min(m61345i(context), 6)));
                }
                if (C13333b.m79953a(contentProviderClientM12617c, C13347p.m80079b(aVar.f48523b), contentValues)) {
                    int i10 = this.f48521e + 1;
                    this.f48521e = i10;
                    sendMsg(3, i10, this.f48519c, callback, obj);
                } else {
                    zM61348l = m61348l(aVar, callback, obj, zM61348l);
                }
            }
            if (contentProviderClientM12617c != null) {
                contentProviderClientM12617c.close();
            }
        } catch (Throwable th3) {
            th = th3;
            contentProviderClient = contentProviderClientM12617c;
            if (contentProviderClient != null) {
                contentProviderClient.close();
            }
            throw th;
        }
    }

    /* renamed from: n */
    public final int m61350n(Context context, AbstractC0048c abstractC0048c, Handler.Callback callback, Object obj) throws Throwable {
        if (abstractC0048c == null) {
            return 5;
        }
        a aVar = this.f48517a[0];
        aVar.f48524c = abstractC0048c.m200s(aVar.f48522a, this.f48518b, null, null, null);
        a aVar2 = this.f48517a[1];
        aVar2.f48524c = abstractC0048c.m200s(aVar2.f48522a, this.f48518b, null, null, null);
        m61341e();
        this.f48521e += m61338b(context);
        int i10 = 0;
        while (i10 < this.f48521e) {
            int i11 = i10 + 1;
            sendMsg(5, i11, this.f48519c, callback, obj);
            i10 = i11;
        }
        for (a aVar3 : this.f48517a) {
            if (BackupObject.isAbort()) {
                return 4;
            }
            Uri uriM80079b = C13347p.m80079b(aVar3.f48523b);
            if (C2157a.m13184S(context, uriM80079b)) {
                m61337a(context, uriM80079b);
                Cursor cursorM12618d = null;
                try {
                    try {
                        cursorM12618d = C2108a.m12618d(context, uriM80079b, null, "_id = 0", null, null);
                    } catch (SQLiteException unused) {
                        C2111d.m12648d("BackupAlarmImp", "Alarm query record ERROR!");
                    } catch (Exception unused2) {
                        C2111d.m12648d("BackupAlarmImp", "Alarm query failed.");
                    }
                    if (cursorM12618d == null) {
                        C2111d.m12648d("BackupAlarmImp", "Alarm uri is null.");
                    } else {
                        boolean z10 = cursorM12618d.getColumnIndex("volume") >= 0;
                        C13339h.m80014a(cursorM12618d);
                        m61349m(context, aVar3, z10, callback, obj);
                    }
                } finally {
                    C13339h.m80014a(cursorM12618d);
                }
            }
        }
        return 4;
    }

    /* renamed from: o */
    public final int m61351o(a aVar, AbstractC0048c abstractC0048c, Handler.Callback callback, Object obj) {
        ContentValues[] contentValuesArr;
        if (aVar != null && (contentValuesArr = aVar.f48524c) != null && contentValuesArr.length != 0) {
            try {
                if (abstractC0048c != null) {
                    try {
                        abstractC0048c.mo169a();
                        ContentValues[] contentValuesArr2 = aVar.f48524c;
                        int length = contentValuesArr2.length;
                        boolean zM61346j = false;
                        int i10 = 0;
                        int i11 = 2;
                        while (i10 < length) {
                            ContentValues contentValues = contentValuesArr2[i10];
                            if (BackupObject.isAbort()) {
                                break;
                            }
                            int iM185A = abstractC0048c.m185A(aVar.f48522a, contentValues);
                            zM61346j = m61346j(aVar, callback, obj, iM185A, zM61346j);
                            i10++;
                            i11 = iM185A;
                        }
                        abstractC0048c.mo171c();
                        if (this.f48520d > 0) {
                            return 1;
                        }
                        return i11;
                    } catch (SQLiteException e10) {
                        C2111d.m12648d("BackupAlarmImp", "Backup alarm data record ERROR!");
                        m61347k(aVar, callback, obj, e10);
                        abstractC0048c.mo171c();
                        return 2;
                    } catch (Exception e11) {
                        m61347k(aVar, callback, obj, e11);
                        C2111d.m12648d("BackupAlarmImp", "Backup alarm data failed.");
                        abstractC0048c.mo171c();
                        return 2;
                    }
                }
            } catch (Throwable th2) {
                abstractC0048c.mo171c();
                throw th2;
            }
        }
        return 2;
    }

    @Override // com.huawei.android.backup.service.logic.BackupObject
    public int onBackup(Context context, AbstractC0048c abstractC0048c, Handler.Callback callback, Object obj, String str) {
        C2111d.m12653i("BackupAlarmImp", "Backup alarm data to sd card.");
        int iM61351o = 2;
        if (abstractC0048c != null) {
            int i10 = 1;
            if (init(context, 1, null)) {
                a aVar = this.f48517a[0];
                aVar.f48524c = m61339c(context, aVar);
                a aVar2 = this.f48517a[1];
                aVar2.f48524c = m61339c(context, aVar2);
                C2111d.m12653i("BackupAlarmImp", "alarmParameter1 values: " + Arrays.toString(this.f48517a[0].f48524c));
                C2111d.m12653i("BackupAlarmImp", "alarmParameter2 values: " + Arrays.toString(this.f48517a[1].f48524c));
                int i11 = this.f48519c;
                if (i11 == 0) {
                    return 1;
                }
                if (i11 > 0) {
                    if (m61351o(this.f48517a[0], abstractC0048c, callback, obj) == 1) {
                        C2111d.m12653i("BackupAlarmImp", "MSG_WRITE_DONE");
                    }
                    iM61351o = m61351o(this.f48517a[1], abstractC0048c, callback, obj);
                }
                int i12 = this.f48520d;
                if (i12 > 0) {
                    this.backupFileModuleInfo.updateModuleInfo(i12, 8, "alarm");
                } else {
                    abstractC0048c.m190h();
                    i10 = iM61351o;
                }
                return storeHandlerMsgToObjectMsg(i10);
            }
        }
        C2111d.m12648d("BackupAlarmImp", "StoreHandler is null or init failed.");
        return 2;
    }

    @Override // com.huawei.android.backup.service.logic.BackupObject
    public Bundle onBackupModulesDataItemTotal(Context context, Long l10, int i10, String str) {
        C2111d.m12653i("BackupAlarmImp", "onBackupModulesDataItemTotal.");
        int iM61340d = m61340d(context);
        C2111d.m12654j("BackupAlarmImp", "onBackupModulesDataItemTotal begin,moduleName: ", str, ",totalNumber: ", Integer.valueOf(iM61340d), ",packageSize: ", l10);
        if (iM61340d < 0) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putLong("ModuleSize", l10.longValue());
        bundle.putInt("ModuleCount", iM61340d);
        return bundle;
    }

    @Override // com.huawei.android.backup.service.logic.BackupObject
    public int onRestore(Context context, AbstractC0048c abstractC0048c, Handler.Callback callback, Object obj, String str) {
        C2111d.m12653i("BackupAlarmImp", "Restore alarm data from sdcard.");
        if (init(context, 2, abstractC0048c)) {
            return m61350n(context, abstractC0048c, callback, obj);
        }
        sendMsg(101, C2111d.m12652h("BackupAlarmImp", "alarm", "onRestore", "init fail"), callback, obj);
        return 5;
    }
}
