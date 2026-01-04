package com.huawei.openalliance.p169ad.download;

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
import com.huawei.hms.network.embedded.C5929g4;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.utils.AbstractC7834m;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class DownloadFileProvider extends ContentProvider {

    /* renamed from: a */
    private static final String[] f32238a = {"_display_name", "_size"};

    /* renamed from: b */
    private static final HashMap<String, InterfaceC7070m> f32239b = new HashMap<>();

    /* renamed from: c */
    private InterfaceC7070m f32240c;

    /* renamed from: com.huawei.openalliance.ad.download.DownloadFileProvider$a */
    public static class C7028a implements InterfaceC7070m {

        /* renamed from: a */
        private final String f32244a;

        /* renamed from: b */
        private final HashMap<String, File> f32245b = new HashMap<>();

        public C7028a(String str) {
            this.f32244a = str;
        }

        @Override // com.huawei.openalliance.p169ad.download.InterfaceC7070m
        /* renamed from: a */
        public Uri mo42040a(File file) throws IOException {
            try {
                String canonicalPath = file.getCanonicalPath();
                Map.Entry<String, File> entry = null;
                for (Map.Entry<String, File> entry2 : this.f32245b.entrySet()) {
                    String path = entry2.getValue().getPath();
                    if (canonicalPath.startsWith(path) && (entry == null || path.length() > entry.getValue().getPath().length())) {
                        entry = entry2;
                    }
                }
                if (entry == null) {
                    throw new IllegalArgumentException("Failed to find configured root that contains " + canonicalPath);
                }
                String path2 = entry.getValue().getPath();
                boolean zEndsWith = path2.endsWith("/");
                int length = path2.length();
                if (!zEndsWith) {
                    length++;
                }
                return new Uri.Builder().scheme("content").authority(this.f32244a).encodedPath(Uri.encode(entry.getKey()) + C5929g4.f26852n + Uri.encode(canonicalPath.substring(length), "/")).build();
            } catch (IOException unused) {
                throw new IllegalArgumentException("Failed to resolve canonical path for " + file);
            }
        }

        @Override // com.huawei.openalliance.p169ad.download.InterfaceC7070m
        /* renamed from: a */
        public File mo42041a(Uri uri) throws IOException {
            if (uri == null) {
                throw new IllegalArgumentException("Get file fail, empty uri");
            }
            String encodedPath = uri.getEncodedPath();
            if (encodedPath == null) {
                throw new IllegalArgumentException("Get file fail, failed to getEncodedPath");
            }
            int iIndexOf = encodedPath.indexOf(47, 1);
            File file = this.f32245b.get(Uri.decode(encodedPath.substring(1, iIndexOf)));
            if (file == null) {
                throw new IllegalArgumentException("Get file fail, unable to find configured root");
            }
            try {
                File canonicalFile = new File(file, Uri.decode(encodedPath.substring(iIndexOf + 1))).getCanonicalFile();
                if (canonicalFile.getPath().startsWith(file.getPath())) {
                    return canonicalFile;
                }
                throw new SecurityException("Get file fail, resolved path jumped beyond configured root");
            } catch (IOException unused) {
                throw new IllegalArgumentException("Get file fail, failed to resolve canonical path");
            }
        }

        /* renamed from: a */
        public void m42042a(String str, File file) throws IOException {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("Name must not be empty");
            }
            try {
                this.f32245b.put(str, file.getCanonicalFile());
            } catch (IOException unused) {
                throw new IllegalArgumentException("Failed to resolve canonical path for " + file);
            }
        }
    }

    /* renamed from: a */
    private static int m42031a() {
        return HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static InterfaceC7070m m42038b(Context context, String str) {
        InterfaceC7070m interfaceC7070mM42039c;
        HashMap<String, InterfaceC7070m> map = f32239b;
        synchronized (map) {
            interfaceC7070mM42039c = map.get(str);
            if (interfaceC7070mM42039c == null) {
                try {
                    interfaceC7070mM42039c = m42039c(context, str);
                } catch (IllegalArgumentException unused) {
                    AbstractC7185ho.m43823c("DownloadFileProvider", "getPathStrategy IllegalArgumentException");
                } catch (Exception e10) {
                    AbstractC7185ho.m43823c("DownloadFileProvider", "getPathStrategy " + e10.getClass().getSimpleName());
                }
                f32239b.put(str, interfaceC7070mM42039c);
            }
        }
        return interfaceC7070mM42039c;
    }

    /* renamed from: c */
    private static InterfaceC7070m m42039c(Context context, String str) throws IOException {
        C7028a c7028a = new C7028a(str);
        String[] strArr = {"cache-path", "external-cache-path"};
        String[] strArr2 = {"file_cache_download", "file_download"};
        for (int i10 = 0; i10 < 2; i10++) {
            String str2 = strArr[i10];
            String str3 = strArr2[i10];
            File cacheDir = "cache-path".equals(str2) ? context.getCacheDir() : "external-cache-path".equals(str2) ? context.getExternalCacheDir() : null;
            if (cacheDir != null) {
                c7028a.m42042a(str3, m42035a(cacheDir, Constants.PPS_ROOT_PATH));
            }
        }
        return c7028a;
    }

    @Override // android.content.ContentProvider
    public void attachInfo(final Context context, final ProviderInfo providerInfo) {
        super.attachInfo(context, providerInfo);
        if (providerInfo.exported) {
            throw new SecurityException("Provider must not be exported");
        }
        if (!providerInfo.grantUriPermissions) {
            throw new SecurityException("Provider must grant uri permissions");
        }
        AbstractC7834m.m48479a(new Runnable() { // from class: com.huawei.openalliance.ad.download.DownloadFileProvider.1
            @Override // java.lang.Runnable
            public void run() {
                DownloadFileProvider.this.f32240c = DownloadFileProvider.m42038b(context, providerInfo.authority);
            }
        });
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        InterfaceC7070m interfaceC7070m = this.f32240c;
        if (interfaceC7070m == null) {
            return 0;
        }
        return interfaceC7070m.mo42041a(uri).delete() ? 1 : 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        InterfaceC7070m interfaceC7070m = this.f32240c;
        if (interfaceC7070m == null) {
            return FileBinary.HEAD_VALUE_CONTENT_TYPE_OCTET_STREAM;
        }
        File fileMo42041a = interfaceC7070m.mo42041a(uri);
        int iLastIndexOf = fileMo42041a.getName().lastIndexOf(46);
        if (iLastIndexOf >= 0) {
            String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileMo42041a.getName().substring(iLastIndexOf + 1));
            if (mimeTypeFromExtension != null) {
                return mimeTypeFromExtension;
            }
        }
        return FileBinary.HEAD_VALUE_CONTENT_TYPE_OCTET_STREAM;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        throw new UnsupportedOperationException("DownloadFile No external inserts");
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public ParcelFileDescriptor openFile(Uri uri, String str) {
        InterfaceC7070m interfaceC7070m = this.f32240c;
        if (interfaceC7070m == null) {
            return null;
        }
        return ParcelFileDescriptor.open(interfaceC7070m.mo42041a(uri), m42031a());
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        int i10;
        InterfaceC7070m interfaceC7070m = this.f32240c;
        if (interfaceC7070m == null) {
            return null;
        }
        File fileMo42041a = interfaceC7070m.mo42041a(uri);
        if (strArr == null) {
            strArr = f32238a;
        }
        String[] strArr3 = new String[strArr.length];
        Object[] objArr = new Object[strArr.length];
        int i11 = 0;
        for (String str3 : strArr) {
            if ("_display_name".equals(str3)) {
                strArr3[i11] = "_display_name";
                i10 = i11 + 1;
                objArr[i11] = fileMo42041a.getName();
            } else if ("_size".equals(str3)) {
                strArr3[i11] = "_size";
                i10 = i11 + 1;
                objArr[i11] = Long.valueOf(fileMo42041a.length());
            }
            i11 = i10;
        }
        String[] strArrM42037a = m42037a(strArr3, i11);
        Object[] objArrM42036a = m42036a(objArr, i11);
        MatrixCursor matrixCursor = new MatrixCursor(strArrM42037a, 1);
        matrixCursor.addRow(objArrM42036a);
        return matrixCursor;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new UnsupportedOperationException("DownloadFile No external updates");
    }

    /* renamed from: a */
    public static Uri m42032a(Context context, String str, File file) {
        return m42038b(context, str).mo42040a(file);
    }

    /* renamed from: a */
    private static File m42035a(File file, String... strArr) {
        for (String str : strArr) {
            if (str != null) {
                file = new File(file, str);
            }
        }
        return file;
    }

    /* renamed from: a */
    private static Object[] m42036a(Object[] objArr, int i10) {
        Object[] objArr2 = new Object[i10];
        System.arraycopy(objArr, 0, objArr2, 0, i10);
        return objArr2;
    }

    /* renamed from: a */
    private static String[] m42037a(String[] strArr, int i10) {
        String[] strArr2 = new String[i10];
        System.arraycopy(strArr, 0, strArr2, 0, i10);
        return strArr2;
    }
}
