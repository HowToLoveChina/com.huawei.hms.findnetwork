package androidx.webkit;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import java.io.FileNotFoundException;
import org.chromium.support_lib_boundary.DropDataContentProviderBoundaryInterface;
import p213d1.C8983i;

/* loaded from: classes.dex */
public final class DropDataContentProvider extends ContentProvider {

    /* renamed from: a */
    public DropDataContentProviderBoundaryInterface f5031a;

    /* renamed from: a */
    public final DropDataContentProviderBoundaryInterface m5931a() {
        if (this.f5031a == null) {
            DropDataContentProviderBoundaryInterface dropDataProvider = C8983i.m56812d().getDropDataProvider();
            this.f5031a = dropDataProvider;
            dropDataProvider.onCreate();
        }
        return this.f5031a;
    }

    @Override // android.content.ContentProvider
    public Bundle call(String str, String str2, Bundle bundle) {
        return m5931a().call(str, str2, bundle);
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        throw new UnsupportedOperationException("delete method is not supported.");
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return m5931a().getType(uri);
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        throw new UnsupportedOperationException("Insert method is not supported.");
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public ParcelFileDescriptor openFile(Uri uri, String str) throws FileNotFoundException {
        return m5931a().openFile(this, uri);
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return m5931a().query(uri, strArr, str, strArr2, str2);
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new UnsupportedOperationException("update method is not supported.");
    }
}
