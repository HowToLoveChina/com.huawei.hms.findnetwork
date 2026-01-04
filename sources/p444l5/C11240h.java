package p444l5;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.android.hicloud.cloudbackup.bean.RuleConfig;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import ly.C11376j;
import p006a5.AbstractC0048c;
import p699v4.C13347p;

/* renamed from: l5.h */
/* loaded from: classes.dex */
public class C11240h {
    /* renamed from: a */
    public static boolean m67542a(Context context, AbstractC0048c abstractC0048c, long j10, String str, String str2) throws IOException {
        int i10;
        if (abstractC0048c == null) {
            return false;
        }
        if (str == null || context == null) {
            C2111d.m12657m("ContactBigPhoto", "photoUri is invalid.");
            return false;
        }
        try {
            try {
                try {
                    try {
                        InputStream inputStreamOpenInputStream = context.getContentResolver().openInputStream(C13347p.m80079b(str));
                        if (inputStreamOpenInputStream == null) {
                            C11376j.m68227a(inputStreamOpenInputStream);
                            return false;
                        }
                        byte[] bArr = new byte[RuleConfig.DEFAULT_DB_DIFF_MAX_FILE_SIZE];
                        ContentValues contentValues = new ContentValues();
                        int i11 = 0;
                        do {
                            i10 = inputStreamOpenInputStream.read(bArr);
                            if (i10 > 0) {
                                byte[] bArr2 = new byte[i10];
                                System.arraycopy(bArr, 0, bArr2, 0, i10);
                                int i12 = i11 + 1;
                                contentValues.put("data_index", Integer.valueOf(i11));
                                contentValues.put("raw_contactid", Long.valueOf(j10));
                                contentValues.put("photo_url", str);
                                contentValues.put("file_length", Integer.valueOf(i10));
                                contentValues.put("file_data", bArr2);
                                abstractC0048c.m185A(str2, contentValues);
                                contentValues.clear();
                                i11 = i12;
                            }
                        } while (i10 > 0);
                        C11376j.m68227a(inputStreamOpenInputStream);
                        return true;
                    } catch (NumberFormatException unused) {
                        C2111d.m12648d("ContactBigPhoto", "backupBigPhoto NumberFormatException");
                        C11376j.m68227a(null);
                        return false;
                    }
                } catch (FileNotFoundException unused2) {
                    C2111d.m12648d("ContactBigPhoto", "backupBigPhoto FileNotFoundException");
                    C11376j.m68227a(null);
                    return false;
                }
            } catch (Exception unused3) {
                C2111d.m12648d("ContactBigPhoto", "backupBigPhoto Exception");
                C11376j.m68227a(null);
                return false;
            }
        } catch (Throwable th2) {
            C11376j.m68227a(null);
            throw th2;
        }
    }

    /* renamed from: b */
    public static void m67543b(AssetFileDescriptor assetFileDescriptor) throws IOException {
        if (assetFileDescriptor != null) {
            try {
                assetFileDescriptor.close();
            } catch (IOException unused) {
                C2111d.m12648d("ContactBigPhoto", "close AssetFileDescriptor error");
            }
        }
    }

    /* renamed from: c */
    public static void m67544c(Context context, String str, long j10) throws Throwable {
        String str2;
        if ("ContactBigPhoto".equals(str)) {
            str2 = "vnd.android.cursor.item/photo";
        } else {
            if (!"ContactBigPhoto_camcard".equals(str)) {
                C2111d.m12654j("ContactBigPhoto", "tableName is not support, tableName = ", str);
                return;
            }
            str2 = C11241i.f52778c;
        }
        String str3 = str2;
        C2111d.m12654j("ContactBigPhoto", "begin to delete photo data, mimeType=", str3, " tableName=", str, " rawId=", Long.valueOf(j10));
        Cursor cursor = null;
        try {
            try {
                ContentResolver contentResolver = context.getContentResolver();
                Uri uri = ContactsContract.Data.CONTENT_URI;
                Cursor cursorQuery = contentResolver.query(uri, new String[]{"_id"}, "raw_contact_id=? and mimetype=?", new String[]{String.valueOf(j10), str3}, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.moveToFirst()) {
                            int iDelete = context.getContentResolver().delete(ContentUris.withAppendedId(uri, cursorQuery.getLong(cursorQuery.getColumnIndex("_id"))), null, null);
                            Object[] objArr = new Object[2];
                            objArr[0] = "photo is deleted successfully:";
                            objArr[1] = Boolean.valueOf(iDelete > 0);
                            C2111d.m12654j("ContactBigPhoto", objArr);
                            cursorQuery.close();
                            return;
                        }
                    } catch (IllegalStateException unused) {
                        cursor = cursorQuery;
                        C2111d.m12653i("ContactBigPhoto", "deletePhotoData IllegalStateException");
                        if (cursor != null) {
                            cursor.close();
                            return;
                        }
                        return;
                    } catch (Exception unused2) {
                        cursor = cursorQuery;
                        C2111d.m12653i("ContactBigPhoto", "deletePhotoData Exception");
                        if (cursor != null) {
                            cursor.close();
                            return;
                        }
                        return;
                    } catch (Throwable th2) {
                        th = th2;
                        cursor = cursorQuery;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
                C2111d.m12653i("ContactBigPhoto", "deletePhotoData fail, can not find data id by specified rawId.");
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } catch (IllegalStateException unused3) {
            } catch (Exception unused4) {
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* renamed from: d */
    public static String[] m67545d(long j10) {
        return new String[]{String.valueOf(j10)};
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c8  */
    /* JADX WARN: Type inference failed for: r4v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v21 */
    /* JADX WARN: Type inference failed for: r4v22 */
    /* JADX WARN: Type inference failed for: r4v23 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v9, types: [java.io.Closeable] */
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m67546e(android.content.Context r16, p006a5.AbstractC0048c r17, long r18, long r20, java.lang.String r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 289
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p444l5.C11240h.m67546e(android.content.Context, a5.c, long, long, java.lang.String):boolean");
    }
}
