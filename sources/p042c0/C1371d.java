package p042c0;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.CancellationSignal;
import androidx.core.content.res.FontResourcesParserCompat;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import p042c0.C1374g;

/* renamed from: c0.d */
/* loaded from: classes.dex */
public class C1371d {

    /* renamed from: a */
    public static final Comparator<byte[]> f5882a = new Comparator() { // from class: c0.c
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return C1371d.m7876g((byte[]) obj, (byte[]) obj2);
        }
    };

    /* renamed from: c0.d$a */
    public static class a {
        /* renamed from: a */
        public static Cursor m7878a(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2, Object obj) {
            return contentResolver.query(uri, strArr, str, strArr2, str2, (CancellationSignal) obj);
        }
    }

    /* renamed from: b */
    public static List<byte[]> m7871b(Signature[] signatureArr) {
        ArrayList arrayList = new ArrayList();
        for (Signature signature : signatureArr) {
            arrayList.add(signature.toByteArray());
        }
        return arrayList;
    }

    /* renamed from: c */
    public static boolean m7872c(List<byte[]> list, List<byte[]> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i10 = 0; i10 < list.size(); i10++) {
            if (!Arrays.equals(list.get(i10), list2.get(i10))) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: d */
    public static List<List<byte[]>> m7873d(C1372e c1372e, Resources resources) {
        return c1372e.m7880b() != null ? c1372e.m7880b() : FontResourcesParserCompat.readCerts(resources, c1372e.m7881c());
    }

    /* renamed from: e */
    public static C1374g.a m7874e(Context context, C1372e c1372e, CancellationSignal cancellationSignal) throws PackageManager.NameNotFoundException {
        ProviderInfo providerInfoM7875f = m7875f(context.getPackageManager(), c1372e, context.getResources());
        return providerInfoM7875f == null ? C1374g.a.m7899a(1, null) : C1374g.a.m7899a(0, m7877h(context, c1372e, providerInfoM7875f.authority, cancellationSignal));
    }

    /* renamed from: f */
    public static ProviderInfo m7875f(PackageManager packageManager, C1372e c1372e, Resources resources) throws PackageManager.NameNotFoundException {
        String strM7883e = c1372e.m7883e();
        ProviderInfo providerInfoResolveContentProvider = packageManager.resolveContentProvider(strM7883e, 0);
        if (providerInfoResolveContentProvider == null) {
            throw new PackageManager.NameNotFoundException("No package found for authority: " + strM7883e);
        }
        if (!providerInfoResolveContentProvider.packageName.equals(c1372e.m7884f())) {
            throw new PackageManager.NameNotFoundException("Found content provider " + strM7883e + ", but package was not " + c1372e.m7884f());
        }
        List<byte[]> listM7871b = m7871b(packageManager.getPackageInfo(providerInfoResolveContentProvider.packageName, 64).signatures);
        Collections.sort(listM7871b, f5882a);
        List<List<byte[]>> listM7873d = m7873d(c1372e, resources);
        for (int i10 = 0; i10 < listM7873d.size(); i10++) {
            ArrayList arrayList = new ArrayList(listM7873d.get(i10));
            Collections.sort(arrayList, f5882a);
            if (m7872c(listM7871b, arrayList)) {
                return providerInfoResolveContentProvider;
            }
        }
        return null;
    }

    /* renamed from: g */
    public static /* synthetic */ int m7876g(byte[] bArr, byte[] bArr2) {
        if (bArr.length != bArr2.length) {
            return bArr.length - bArr2.length;
        }
        for (int i10 = 0; i10 < bArr.length; i10++) {
            byte b10 = bArr[i10];
            byte b11 = bArr2[i10];
            if (b10 != b11) {
                return b10 - b11;
            }
        }
        return 0;
    }

    /* renamed from: h */
    public static C1374g.b[] m7877h(Context context, C1372e c1372e, String str, CancellationSignal cancellationSignal) throws Throwable {
        ArrayList arrayList = new ArrayList();
        Uri uriBuild = new Uri.Builder().scheme("content").authority(str).build();
        Uri uriBuild2 = new Uri.Builder().scheme("content").authority(str).appendPath(CloudBackupConstant.Command.PMS_OPTION_ONE_FILE).build();
        Cursor cursor = null;
        try {
            Cursor cursorM7878a = a.m7878a(context.getContentResolver(), uriBuild, new String[]{"_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", FamilyShareConstants.OpenCloudShareResultInfo.RESULT_CODE_KEY}, "query = ?", new String[]{c1372e.m7885g()}, null, cancellationSignal);
            if (cursorM7878a != null) {
                try {
                    if (cursorM7878a.getCount() > 0) {
                        int columnIndex = cursorM7878a.getColumnIndex(FamilyShareConstants.OpenCloudShareResultInfo.RESULT_CODE_KEY);
                        arrayList = new ArrayList();
                        int columnIndex2 = cursorM7878a.getColumnIndex("_id");
                        int columnIndex3 = cursorM7878a.getColumnIndex("file_id");
                        int columnIndex4 = cursorM7878a.getColumnIndex("font_ttc_index");
                        int columnIndex5 = cursorM7878a.getColumnIndex("font_weight");
                        int columnIndex6 = cursorM7878a.getColumnIndex("font_italic");
                        while (cursorM7878a.moveToNext()) {
                            int i10 = columnIndex != -1 ? cursorM7878a.getInt(columnIndex) : 0;
                            arrayList.add(C1374g.b.m7902a(columnIndex3 == -1 ? ContentUris.withAppendedId(uriBuild, cursorM7878a.getLong(columnIndex2)) : ContentUris.withAppendedId(uriBuild2, cursorM7878a.getLong(columnIndex3)), columnIndex4 != -1 ? cursorM7878a.getInt(columnIndex4) : 0, columnIndex5 != -1 ? cursorM7878a.getInt(columnIndex5) : 400, columnIndex6 != -1 && cursorM7878a.getInt(columnIndex6) == 1, i10));
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    cursor = cursorM7878a;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            if (cursorM7878a != null) {
                cursorM7878a.close();
            }
            return (C1374g.b[]) arrayList.toArray(new C1374g.b[0]);
        } catch (Throwable th3) {
            th = th3;
        }
    }
}
