package com.huawei.android.hicloud.common.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.text.TextUtils;
import com.huawei.android.hicloud.sync.protocol.SyncProtocol;
import com.huawei.hicloud.bean.DriveConfigService;
import com.huawei.hicloud.notification.util.NotifyUtil;
import gp.C10028c;
import java.util.ArrayList;
import java.util.Iterator;
import p372ip.C10584b;
import p514o9.C11839m;
import p616rk.C12515a;
import p742wj.C13612b;

/* loaded from: classes3.dex */
public class DriveProvider extends ContentProvider {

    /* renamed from: a */
    public static final UriMatcher f11945a;

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        f11945a = uriMatcher;
        uriMatcher.addURI("com.huawei.android.drive.driveProvider", "switchState", 1);
        uriMatcher.addURI("com.huawei.android.drive.driveProvider", "login_status", 2);
        uriMatcher.addURI("com.huawei.android.drive.driveProvider", "restore_setting_status", 3);
    }

    /* renamed from: a */
    public final void m15617a(Context context, String[] strArr) {
        if (m15618b(strArr)) {
            C11839m.m70687e("DriveProvider", "selectionArgs is null");
            throw new IllegalArgumentException("selection args is error.");
        }
        ArrayList<DriveConfigService> shownDriveServiceItems = NotifyUtil.getShownDriveServiceItems(context);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        Iterator<DriveConfigService> it = shownDriveServiceItems.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            DriveConfigService next = it.next();
            if (next != null) {
                if (!TextUtils.isEmpty(next.getId())) {
                    arrayList.add(next.getId());
                }
                if (next.getPkgNames() != null) {
                    for (String str : next.getPkgNames()) {
                        if (!TextUtils.isEmpty(str)) {
                            arrayList2.add(str);
                        }
                    }
                }
                if (next.getSignHash() != null) {
                    for (String str2 : next.getSignHash()) {
                        if (!TextUtils.isEmpty(str2)) {
                            arrayList3.add(str2);
                        }
                    }
                }
            }
        }
        String str3 = strArr[0];
        String callingPackage = getCallingPackage();
        String signForPkgName = NotifyUtil.getSignForPkgName(context, callingPackage);
        if (!arrayList.contains(str3)) {
            C11839m.m70687e("DriveProvider", "syncType is unSupport");
            throw new IllegalArgumentException("syncType is unSupport");
        }
        if (arrayList2.contains(callingPackage) && arrayList3.contains(signForPkgName)) {
            return;
        }
        C11839m.m70687e("DriveProvider", "no contains packageName or sign");
        throw new IllegalArgumentException("no contains packageName or sign");
    }

    /* renamed from: b */
    public final boolean m15618b(String[] strArr) {
        return strArr == null || strArr.length < 1;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Context context = getContext();
        if (context == null) {
            C11839m.m70687e("DriveProvider", "query: context is null");
            return null;
        }
        if (strArr2 == null || strArr2.length == 0) {
            C11839m.m70687e("DriveProvider", "query: selectionArgs is null");
            return null;
        }
        m15617a(context, strArr2);
        int iMatch = f11945a.match(uri);
        MatrixCursor matrixCursor = new MatrixCursor(new String[]{"switchState", "login_status"});
        boolean zIsLogin = C13612b.m81829B().isLogin();
        C10028c c10028cM62183d0 = C10028c.m62183d0(context);
        if (iMatch == -1) {
            matrixCursor.close();
        } else if (iMatch == 1) {
            C11839m.m70686d("DriveProvider", "switch_status");
            if (zIsLogin) {
                boolean zM62388s = c10028cM62183d0.m62388s(strArr2[0]);
                C11839m.m70688i("DriveProvider", "Module name: " + strArr2[0] + ", isSwitchOn = " + zM62388s);
                if (zM62388s) {
                    matrixCursor.addRow(new Object[]{1, ""});
                } else {
                    matrixCursor.addRow(new Object[]{0, ""});
                }
            } else {
                matrixCursor.addRow(new Object[]{-1, ""});
                C11839m.m70688i("DriveProvider", "Module name: " + strArr2[0] + "isAccountLogin is failed");
            }
        } else {
            if (iMatch != 2) {
                throw new IllegalArgumentException("Unknown URI " + uri);
            }
            C11839m.m70686d("DriveProvider", "login_status");
            matrixCursor.addRow(new Object[]{"", String.valueOf(zIsLogin)});
        }
        return matrixCursor;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        C11839m.m70688i("DriveProvider", SyncProtocol.Constant.UPDATE);
        Context context = getContext();
        if (context == null) {
            C11839m.m70687e("DriveProvider", "update: context is null");
            return -1;
        }
        if (strArr == null || strArr.length == 0) {
            C11839m.m70687e("DriveProvider", "update: selectionArgs is null");
            return -1;
        }
        m15617a(context, strArr);
        if (f11945a.match(uri) == 3) {
            C11839m.m70688i("DriveProvider", "clear setting status");
            C12515a.m75110o().m75175e(new C10584b(context, strArr[0], C10028c.m62183d0(context).m62388s(strArr[0])), false);
            return -1;
        }
        throw new IllegalArgumentException("Unknown URI " + uri);
    }
}
