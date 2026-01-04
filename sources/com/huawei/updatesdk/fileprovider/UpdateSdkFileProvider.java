package com.huawei.updatesdk.fileprovider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.huawei.hms.network.base.common.trans.FileBinary;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import com.huawei.updatesdk.p177a.p178a.p180c.p181a.p182a.C8777a;
import java.io.File;

/* loaded from: classes9.dex */
public class UpdateSdkFileProvider extends ContentProvider {
    public static final String AUTHORITIES_SUFFIX = ".updateSdk.fileProvider";
    private static final String[] COLUMNS = {"_display_name", "_size"};
    private static final String TAG = "UpdateSdkFileProvider";
    private static InterfaceC8839a mWStrategy;
    private String authority;

    private static File buildPath(File file, String... strArr) {
        for (String str : strArr) {
            if (str != null) {
                file = new File(file, str);
            }
        }
        return file;
    }

    private static Object[] copy(Object[] objArr, int i10) {
        Object[] objArr2 = new Object[i10];
        System.arraycopy(objArr, 0, objArr2, 0, i10);
        return objArr2;
    }

    private static synchronized InterfaceC8839a createWiseDistPathStrategy(Context context, String str) {
        try {
            if (mWStrategy == null) {
                mWStrategy = new C8840b(str);
                if (context.getFilesDir() != null) {
                    mWStrategy.mo56366a("updatesdkapk", buildPath(context.getFilesDir(), "/"));
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return mWStrategy;
    }

    public static Uri getUriForFile(Context context, String str, File file) {
        createWiseDistPathStrategy(context, str);
        return mWStrategy.mo56364a(file);
    }

    @Override // android.content.ContentProvider
    public void attachInfo(Context context, ProviderInfo providerInfo) {
        super.attachInfo(context, providerInfo);
        if (providerInfo.exported) {
            throw new SecurityException("WiseDist Provider must not be exported");
        }
        if (!providerInfo.grantUriPermissions) {
            throw new SecurityException("WiseDist Provider must grant uri permissions");
        }
        String str = providerInfo.authority;
        this.authority = str;
        createWiseDistPathStrategy(context, str);
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        throw new UnsupportedOperationException("No external updates");
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        String mimeTypeFromExtension;
        return (uri == null || TextUtils.isEmpty(uri.toString()) || !uri.toString().endsWith("apk") || (mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension("apk")) == null) ? FileBinary.HEAD_VALUE_CONTENT_TYPE_OCTET_STREAM : mimeTypeFromExtension;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        throw new UnsupportedOperationException("No external inserts!");
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public ParcelFileDescriptor openFile(Uri uri, String str) {
        if (uri == null || uri.getAuthority() == null || !uri.getAuthority().equals(this.authority)) {
            return null;
        }
        File fileMo56365a = mWStrategy.mo56365a(uri);
        if (fileMo56365a.getName().endsWith("apk")) {
            return ParcelFileDescriptor.open(fileMo56365a, HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
        }
        C8777a.m56028b(TAG, "can not open this file.");
        return null;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        int i10;
        File fileMo56365a = mWStrategy.mo56365a(uri);
        if (strArr == null) {
            strArr = COLUMNS;
        }
        String[] strArr3 = new String[strArr.length];
        Object[] objArr = new Object[strArr.length];
        int i11 = 0;
        for (String str3 : strArr) {
            if ("_display_name".equals(str3)) {
                strArr3[i11] = "_display_name";
                i10 = i11 + 1;
                objArr[i11] = fileMo56365a.getName();
            } else if ("_size".equals(str3)) {
                strArr3[i11] = "_size";
                i10 = i11 + 1;
                objArr[i11] = Long.valueOf(fileMo56365a.length());
            }
            i11 = i10;
        }
        String[] strArrCopy = copy(strArr3, i11);
        Object[] objArrCopy = copy(objArr, i11);
        MatrixCursor matrixCursor = new MatrixCursor(strArrCopy, 1);
        matrixCursor.addRow(objArrCopy);
        return matrixCursor;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new UnsupportedOperationException("No external updates!");
    }

    private static String[] copy(String[] strArr, int i10) {
        String[] strArr2 = new String[i10];
        System.arraycopy(strArr, 0, strArr2, 0, i10);
        return strArr2;
    }
}
