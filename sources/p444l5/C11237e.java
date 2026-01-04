package p444l5;

import android.accounts.AccountManager;
import android.accounts.AuthenticatorDescription;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentValues;
import android.content.Context;
import android.content.OperationApplicationException;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.RemoteException;
import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.android.backup.service.utils.C2157a;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import p279f6.C9660c;
import p444l5.AbstractC11234b;
import p699v4.C13334c;
import p728w4.C13529c;

/* renamed from: l5.e */
/* loaded from: classes.dex */
public class C11237e {

    /* renamed from: a */
    public static final boolean f52761a = C13529c.m81424b("ro.product.custom", "NULL").contains("docomo");

    /* renamed from: b */
    public static final boolean f52762b;

    /* renamed from: c */
    public static final boolean f52763c;

    static {
        String str = Build.PRODUCT;
        f52762b = str != null && (str.contains("DUA-") || str.contains("DRA-"));
        f52763c = str != null ? str.contains("NTS-") : false;
    }

    /* renamed from: a */
    public static ArrayList<ContentProviderOperation> m67521a(List<C9660c> list) {
        if (list == null) {
            return new ArrayList<>(0);
        }
        ArrayList<ContentProviderOperation> arrayList = new ArrayList<>(list.size());
        for (C9660c c9660c : list) {
            ContentProviderOperation.Builder builderNewUpdate = ContentProviderOperation.newUpdate(c9660c.m60324a());
            builderNewUpdate.withValues(c9660c.m60329f());
            arrayList.add(builderNewUpdate.build());
        }
        return arrayList;
    }

    /* renamed from: b */
    public static void m67522b(ContentValues[] contentValuesArr) {
        for (ContentValues contentValues : contentValuesArr) {
            contentValues.putNull("account_name");
            contentValues.putNull("account_type");
        }
    }

    /* renamed from: c */
    public static void m67523c(HashMap<Long, LinkedHashSet<ContentValues>> map, C11244l c11244l, AbstractC11234b.b bVar) {
        if (c11244l == null || map == null || bVar == null) {
            return;
        }
        Iterator<Map.Entry<Long, LinkedHashSet<ContentValues>>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Long, LinkedHashSet<ContentValues>> next = it.next();
            c11244l.m67581f(m67529i(next.getValue()), next.getKey(), it);
            bVar.mo67502a(c11244l);
        }
    }

    /* renamed from: d */
    public static HashMap<String, AuthenticatorDescription> m67524d(Context context) {
        AccountManager accountManager = AccountManager.get(context);
        HashMap<String, AuthenticatorDescription> map = null;
        if (accountManager == null) {
            return null;
        }
        AuthenticatorDescription[] authenticatorTypes = accountManager.getAuthenticatorTypes();
        if (authenticatorTypes != null && authenticatorTypes.length > 0) {
            map = new HashMap<>(authenticatorTypes.length);
            for (AuthenticatorDescription authenticatorDescription : authenticatorTypes) {
                if (authenticatorDescription != null) {
                    map.put(authenticatorDescription.type, authenticatorDescription);
                }
            }
        }
        return map;
    }

    /* renamed from: e */
    public static String[] m67525e(String[] strArr, HashMap<String, Integer> map) {
        if (strArr == null || strArr.length == 0 || map == null) {
            return new String[0];
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            if (map.containsKey(str)) {
                arrayList.add(str);
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    /* renamed from: f */
    public static void m67526f(ContentValues contentValues, HashMap<Long, String> map) {
        if (contentValues == null) {
            C2111d.m12648d("BackupContactHapUtil", "getMePhotoUri null values");
            return;
        }
        String asString = contentValues.getAsString("photo_uri");
        if (asString == null) {
            return;
        }
        Long asLong = contentValues.getAsLong("raw_contact_id");
        if (asLong != null && !asString.isEmpty() && map != null) {
            map.put(asLong, asString);
            return;
        }
        C2111d.m12648d("BackupContactHapUtil", "backup contact me photo uri fail, raw_contact_id:" + asLong + ";uri:" + asString);
    }

    /* renamed from: g */
    public static String m67527g(ContentValues contentValues) {
        if (contentValues != null) {
            return contentValues.getAsString("photo_uri");
        }
        C2111d.m12648d("BackupContactHapUtil", "getPhotoUri null values");
        return "";
    }

    /* renamed from: h */
    public static String[] m67528h(String[] strArr, Set<String> set, HashMap<String, Integer> map) {
        if (strArr == null || set == null || map == null) {
            return new String[0];
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            if (map.containsKey(str) && set.contains(str) && !"photo_uri".equals(str)) {
                arrayList.add(str);
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    /* renamed from: i */
    public static int m67529i(LinkedHashSet<ContentValues> linkedHashSet) {
        C11242j c11242j = new C11242j();
        Iterator<ContentValues> it = linkedHashSet.iterator();
        while (it.hasNext()) {
            ContentValues next = it.next();
            if (next != null) {
                c11242j.m67560h(next);
            }
        }
        return C2157a.m13214v(C11242j.m67555c(c11242j));
    }

    /* renamed from: j */
    public static boolean m67530j(Context context) {
        return (!C2157a.m13166A(context) || f52761a || f52762b || f52763c) ? false : true;
    }

    /* renamed from: k */
    public static String m67531k(Context context, AuthenticatorDescription authenticatorDescription, String str) throws Throwable {
        if (context == null || authenticatorDescription == null) {
            C2111d.m12648d("BackupContactHapUtil", "makeIconFile : authContext or authenticatorDescription is null");
            return "";
        }
        File file = new File(str, authenticatorDescription.type + ".png");
        if (!file.exists()) {
            if (!file.createNewFile()) {
                C2111d.m12648d("BackupContactHapUtil", "iconFile create failed!");
                return null;
            }
            Drawable drawable = context.getResources().getDrawable(authenticatorDescription.iconId);
            if (drawable != null) {
                C13334c.m79982o(drawable, file);
            }
        }
        return file.getName();
    }

    /* renamed from: l */
    public static ContentProviderResult[] m67532l(Context context, ArrayList<C9660c> arrayList) {
        if (arrayList == null) {
            return new ContentProviderResult[0];
        }
        ArrayList<ContentProviderOperation> arrayListM67521a = m67521a(arrayList);
        if (context == null) {
            return null;
        }
        try {
            return context.getContentResolver().applyBatch("com.android.contacts", arrayListM67521a);
        } catch (OperationApplicationException unused) {
            C2111d.m12648d("BackupContactHapUtil", "updateBatch OperationApplicationException.");
            return new ContentProviderResult[0];
        } catch (RemoteException unused2) {
            C2111d.m12648d("BackupContactHapUtil", "updateBatch RemoteException.");
            return new ContentProviderResult[0];
        } catch (Exception unused3) {
            C2111d.m12648d("BackupContactHapUtil", "updateBatch Exception.");
            return new ContentProviderResult[0];
        }
    }
}
