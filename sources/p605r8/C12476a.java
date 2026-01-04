package p605r8;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import com.huawei.hicloud.base.bean.CloudDiskModuleRst;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import p015ak.AbstractC0218h0;
import p015ak.C0209d;
import p015ak.C0221j;
import p514o9.C11839m;
import p605r8.C12477b;

/* renamed from: r8.a */
/* loaded from: classes2.dex */
public class C12476a {

    /* renamed from: a */
    public a f57439a;

    /* renamed from: r8.a$a */
    public static class a {

        /* renamed from: a */
        public int f57440a;

        /* renamed from: b */
        public long f57441b;

        public a() {
        }

        /* renamed from: b */
        public long m74879b() {
            return this.f57441b;
        }

        /* renamed from: c */
        public int m74880c() {
            return this.f57440a;
        }

        /* renamed from: d */
        public void m74881d(long j10) {
            this.f57441b = j10;
        }

        /* renamed from: e */
        public void m74882e(int i10) {
            this.f57440a = i10;
        }

        public a(String str) {
            this.f57440a = 0;
            this.f57441b = 0L;
        }
    }

    public C12476a() {
        this.f57439a = null;
        this.f57439a = new a();
    }

    /* renamed from: a */
    public final ContentValues m74873a(Context context, AbstractC0218h0 abstractC0218h0, String str) {
        C12477b.c cVarM74887e;
        for (ContentValues contentValues : abstractC0218h0.mo1459h("module_uri_table", null, null, null, null)) {
            String asString = contentValues.getAsString("uri_coloum");
            if (str.equals(asString) || (C0209d.m1277l1() && "content://com.huawei.systemmanager.HarassmentInterceptionDBProvider".equals(asString) && "content://com.hihonor.systemmanager.HarassmentInterceptionDBProvider".equals(str))) {
                Integer asInteger = contentValues.getAsInteger("version_coloum");
                if (asInteger == null || (cVarM74887e = C12477b.m74887e(Uri.parse(str), context, asInteger.intValue())) == null || !cVarM74887e.m74901b()) {
                    return null;
                }
                return contentValues;
            }
        }
        return null;
    }

    /* renamed from: b */
    public final int m74874b(Context context, AbstractC0218h0 abstractC0218h0, Object obj) {
        C12477b.a aVarM74885c;
        C11839m.m70686d("BackupPhoneManager", "begin onBackup");
        String strM74884b = C12477b.m74884b(context);
        if (strM74884b != null && (aVarM74885c = C12477b.m74885c(Uri.parse(strM74884b), context)) != null && aVarM74885c.m74892e() != null && aVarM74885c.m74893f() != null) {
            StringBuffer stringBuffer = new StringBuffer();
            Iterator<String> it = aVarM74885c.m74892e().iterator();
            int i10 = 0;
            while (it.hasNext()) {
                String next = it.next();
                String lastPathSegment = Uri.parse(next).getLastPathSegment();
                List<ContentValues> listM74883a = C12477b.m74883a(Uri.parse(next), context);
                if (!listM74883a.isEmpty()) {
                    int size = listM74883a.size();
                    if (abstractC0218h0.mo1462k(lastPathSegment, (ContentValues[]) listM74883a.toArray(new ContentValues[size])) == 1) {
                        i10 += size;
                        stringBuffer.append(lastPathSegment);
                        stringBuffer.append(",");
                    }
                }
            }
            if (stringBuffer.length() != 0 && i10 != 0) {
                String strSubstring = stringBuffer.substring(0, stringBuffer.length() - 1);
                if (strSubstring.isEmpty()) {
                    return -1;
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("uri_coloum", strM74884b);
                contentValues.put("table_coloum", strSubstring);
                contentValues.put("version_coloum", Integer.valueOf(aVarM74885c.m74891d()));
                if (abstractC0218h0.mo1461j("module_uri_table", contentValues) == 2) {
                    return -1;
                }
                this.f57439a.m74881d(C0221j.m1506p(new File(abstractC0218h0.m1456e())));
                this.f57439a.m74882e(i10);
                C11839m.m70686d("BackupPhoneManager", "end onBackup");
                return 2;
            }
        }
        return -1;
    }

    /* renamed from: c */
    public a m74875c(Context context, AbstractC0218h0 abstractC0218h0, Object obj, String str) {
        if (this.f57439a == null) {
            this.f57439a = new a(str);
        }
        m74874b(context, abstractC0218h0, obj);
        return this.f57439a;
    }

    /* renamed from: d */
    public final CloudDiskModuleRst m74876d(Context context, AbstractC0218h0 abstractC0218h0, Handler.Callback callback, Object obj) {
        C11839m.m70686d("BackupPhoneManager", "begin onRestore");
        CloudDiskModuleRst cloudDiskModuleRst = new CloudDiskModuleRst();
        cloudDiskModuleRst.setRetCode(-1);
        cloudDiskModuleRst.setModuleName("phonemanager");
        String strM74884b = C12477b.m74884b(context);
        if (strM74884b == null) {
            C11839m.m70688i("BackupPhoneManager", "restore phone manager fail, uri is null");
            cloudDiskModuleRst.setFailReason("module provider uri is null");
            cloudDiskModuleRst.setRetCode(-1);
            return cloudDiskModuleRst;
        }
        ContentValues contentValuesM74873a = m74873a(context, abstractC0218h0, strM74884b);
        if (contentValuesM74873a == null) {
            C11839m.m70688i("BackupPhoneManager", "restore phone manager fail, moduleUris is null");
            cloudDiskModuleRst.setFailReason("moduleUris is null");
            cloudDiskModuleRst.setRetCode(-1);
            return cloudDiskModuleRst;
        }
        String asString = contentValuesM74873a.getAsString("table_coloum");
        if (asString == null) {
            C11839m.m70688i("BackupPhoneManager", "restore phone manager fail, tableNameStr is null");
            cloudDiskModuleRst.setFailReason("tableNameStr is null");
            cloudDiskModuleRst.setRetCode(-1);
            return cloudDiskModuleRst;
        }
        try {
            for (String str : asString.split(",")) {
                for (ContentValues contentValues : abstractC0218h0.mo1458g(str)) {
                    String str2 = strM74884b + File.separator + str;
                    if (C0209d.m1227Y1(context, Uri.parse(str2))) {
                        context.getContentResolver().insert(Uri.parse(str2), contentValues);
                    } else {
                        C11839m.m70687e("BackupPhoneManager", "TargetApp is not SystemApp");
                    }
                }
            }
        } catch (Exception e10) {
            C11839m.m70687e("BackupPhoneManager", "restore phone manager fail, Exception :" + e10.toString());
        }
        C12477b.b bVarM74886d = C12477b.m74886d(Uri.parse(strM74884b), context);
        if (bVarM74886d == null) {
            C11839m.m70688i("BackupPhoneManager", "restore phone manager fail, restoreCompleteInfo is null");
            cloudDiskModuleRst.setFailReason("restoreCompleteInfo is null");
            cloudDiskModuleRst.setRetCode(-1);
            return cloudDiskModuleRst;
        }
        cloudDiskModuleRst.setSuccessNum(bVarM74886d.m74899f());
        cloudDiskModuleRst.setFailNum(bVarM74886d.m74898e());
        cloudDiskModuleRst.setRetCode(0);
        C11839m.m70686d("BackupPhoneManager", "end onRestore");
        return cloudDiskModuleRst;
    }

    /* renamed from: e */
    public CloudDiskModuleRst m74877e(Context context, AbstractC0218h0 abstractC0218h0, AbstractC0218h0 abstractC0218h02, Handler.Callback callback, long j10, Object obj, boolean z10) {
        this.f57439a.f57440a = (int) j10;
        return m74876d(context, abstractC0218h0, callback, obj);
    }
}
