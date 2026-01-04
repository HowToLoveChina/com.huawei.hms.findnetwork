package com.huawei.android.hicloud.cloudbackup.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import com.huawei.hicloud.cloudbackup.store.database.status.CloudRestoreStatusV3;
import com.huawei.hicloud.cloudbackup.store.database.tags.CloudRestoreStatus;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import fk.C9721b;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import p514o9.C11839m;
import p744wl.C13619c;
import sl.C12816g;
import tl.C13029h;
import tl.C13030i;
import tl.C13035n;

/* loaded from: classes2.dex */
public class AppRestoreProvider extends ContentProvider {
    private static final int APPLIST_CODE = 1;
    private static final String APPLIST_PATH = "applist";
    private static final String APPNAME = "appName";
    private static final String AUTHORITY = "com.huawei.hidisk.cloudbackup.apprestore";
    private static final String ICONURL = "iconUrl";
    private static final String INVALID_STR = "../";
    private static final UriMatcher MATCHER;
    private static final String PACKAGENAME = "packageName";
    private static final String STATUS = "status";
    private static final String TAG = "AppRestoreProvider";

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        MATCHER = uriMatcher;
        uriMatcher.addURI(AUTHORITY, APPLIST_PATH, 1);
    }

    private boolean checkFile(File file) {
        return (file == null || !file.exists() || file.isDirectory()) ? false : true;
    }

    private int modeToMode(String str) {
        if ("r".equals(str)) {
            return HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK;
        }
        if ("w".equals(str) || "wt".equals(str)) {
            return 738197504;
        }
        if ("wa".equals(str)) {
            return 704643072;
        }
        if ("rw".equals(str)) {
            return 939524096;
        }
        if ("rwt".equals(str)) {
            return 1006632960;
        }
        throw new IllegalArgumentException("Invalid mode: " + str);
    }

    private void prepareV2Cursor(MatrixCursor matrixCursor, List<CloudRestoreStatus> list) {
        for (CloudRestoreStatus cloudRestoreStatus : list) {
            if (cloudRestoreStatus.is3rdAppType() && cloudRestoreStatus.getVersion() <= 0) {
                matrixCursor.addRow(new Object[]{cloudRestoreStatus.getAppId(), cloudRestoreStatus.getAppName(), cloudRestoreStatus.m29520K(), Integer.valueOf(cloudRestoreStatus.getStatus())});
                C11839m.m70686d(TAG, " restoreApp: " + cloudRestoreStatus.getAppId());
            }
        }
    }

    private void prepareV3Cursor(MatrixCursor matrixCursor, List<CloudRestoreStatusV3> list) {
        for (CloudRestoreStatusV3 cloudRestoreStatusV3 : list) {
            if (cloudRestoreStatusV3.is3rdAppType() && cloudRestoreStatusV3.m29466K() <= 0) {
                matrixCursor.addRow(new Object[]{cloudRestoreStatusV3.getAppId(), cloudRestoreStatusV3.getAppName(), cloudRestoreStatusV3.m29500t(), Integer.valueOf(cloudRestoreStatusV3.getStatus())});
                C11839m.m70686d(TAG, " restoreApp: " + cloudRestoreStatusV3.getAppId());
            }
        }
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
    public ParcelFileDescriptor openFile(Uri uri, String str) throws FileNotFoundException {
        int iModeToMode = modeToMode(str);
        String path = uri.getPath();
        if (TextUtils.isEmpty(path)) {
            C11839m.m70689w(TAG, "path is null");
            return null;
        }
        if (path.contains("../")) {
            C11839m.m70689w(TAG, "path contains invalid str");
            return null;
        }
        C11839m.m70686d(TAG, "openFile :" + uri + "uri.path:" + path + "  mode:" + str);
        File file = new File(path);
        if (checkFile(file)) {
            return ParcelFileDescriptor.open(file, iModeToMode);
        }
        C11839m.m70689w(TAG, "openFile error");
        return null;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        C13029h c13029hM78495f;
        C11839m.m70686d(TAG, "query uri：" + uri);
        MatrixCursor matrixCursor = new MatrixCursor(new String[]{"packageName", APPNAME, ICONURL, "status"});
        int iMatch = MATCHER.match(uri);
        C11839m.m70688i(TAG, "match :" + iMatch);
        if (iMatch == -1) {
            matrixCursor.close();
        } else {
            if (iMatch != 1) {
                throw new IllegalStateException("Unknow uri :" + uri);
            }
            try {
                c13029hM78495f = new C13030i().m78495f(3);
            } catch (C9721b unused) {
                C11839m.m70687e(TAG, "query tag error.");
                c13029hM78495f = null;
            }
            if (c13029hM78495f == null) {
                C11839m.m70689w(TAG, "restore tag is null");
                return matrixCursor;
            }
            if (C13619c.m81952h(c13029hM78495f.m78480t())) {
                List<CloudRestoreStatusV3> listM76950n = new C12816g().m76950n(0);
                if (listM76950n.isEmpty()) {
                    C11839m.m70689w(TAG, "query result is null");
                    return matrixCursor;
                }
                prepareV3Cursor(matrixCursor, listM76950n);
            } else {
                List<CloudRestoreStatus> listM78555g = new C13035n().m78555g(0);
                if (listM78555g.isEmpty()) {
                    C11839m.m70689w(TAG, "query result is null");
                    return matrixCursor;
                }
                prepareV2Cursor(matrixCursor, listM78555g);
            }
        }
        return matrixCursor;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
