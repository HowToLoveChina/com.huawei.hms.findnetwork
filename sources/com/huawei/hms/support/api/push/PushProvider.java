package com.huawei.hms.support.api.push;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;

/* loaded from: classes8.dex */
public class PushProvider extends ContentProvider {
    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        if (uri == null || !uri.toString().endsWith(".xml")) {
            return null;
        }
        return "xml";
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return false;
    }

    @Override // android.content.ContentProvider
    public ParcelFileDescriptor openFile(Uri uri, String str) throws FileNotFoundException {
        HMSLog.m36988i("PushProvider", "use sdk PushProvider openFile");
        if (!"xml".equals(getType(uri))) {
            HMSLog.m36989w("PushProvider", "Incorrect file uri");
            throw new FileNotFoundException(uri.getPath());
        }
        StringBuilder sb2 = new StringBuilder();
        Context context = getContext();
        Objects.requireNonNull(context);
        sb2.append(context.createDeviceProtectedStorageContext().getDataDir());
        sb2.append("/shared_prefs/push_notify_flag.xml");
        File file = new File(sb2.toString());
        if (file.exists()) {
            return ParcelFileDescriptor.open(file, HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
        }
        File file2 = new File(getContext().getDataDir() + "/shared_prefs/push_notify_flag.xml");
        if (file2.exists()) {
            return ParcelFileDescriptor.open(file2, HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
        }
        throw new FileNotFoundException(uri.getPath());
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
