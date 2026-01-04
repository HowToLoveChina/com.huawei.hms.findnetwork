package com.huawei.updatesdk.fileprovider;

import android.net.Uri;
import android.text.TextUtils;
import com.huawei.hms.network.embedded.C5929g4;
import com.huawei.updatesdk.p177a.p178a.p183d.AbstractC8782d;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.huawei.updatesdk.fileprovider.b */
/* loaded from: classes9.dex */
class C8840b implements InterfaceC8839a {

    /* renamed from: a */
    private final String f45198a;

    /* renamed from: b */
    private final HashMap<String, File> f45199b = new HashMap<>();

    public C8840b(String str) {
        this.f45198a = str;
    }

    @Override // com.huawei.updatesdk.fileprovider.InterfaceC8839a
    /* renamed from: a */
    public Uri mo56364a(File file) throws IOException {
        try {
            String canonicalPath = file.getCanonicalPath();
            Map.Entry<String, File> entry = null;
            for (Map.Entry<String, File> entry2 : this.f45199b.entrySet()) {
                String path = entry2.getValue().getPath();
                if (canonicalPath.startsWith(path) && (entry == null || path.length() > entry.getValue().getPath().length())) {
                    entry = entry2;
                }
            }
            if (entry == null) {
                throw new IllegalArgumentException("wisedist: Failed to find configured root that contains");
            }
            String path2 = entry.getValue().getPath();
            boolean zEndsWith = path2.endsWith("/");
            int length = path2.length();
            if (!zEndsWith) {
                length++;
            }
            return new Uri.Builder().scheme("content").authority(this.f45198a).encodedPath(Uri.encode(entry.getKey()) + C5929g4.f26852n + Uri.encode(canonicalPath.substring(length), "/")).build();
        } catch (Exception unused) {
            throw new IllegalArgumentException("Failed to resolve canonical path for wisedist");
        }
    }

    @Override // com.huawei.updatesdk.fileprovider.InterfaceC8839a
    /* renamed from: a */
    public File mo56365a(Uri uri) throws IOException {
        try {
            String encodedPath = uri.getEncodedPath();
            int iIndexOf = encodedPath.indexOf(47, 1);
            String strDecode = Uri.decode(encodedPath.substring(1, iIndexOf));
            String strDecode2 = Uri.decode(encodedPath.substring(iIndexOf + 1));
            File file = this.f45199b.get(strDecode);
            if (file == null) {
                throw new IllegalArgumentException("wisedist: Unable to find configured root for");
            }
            if (AbstractC8782d.m56044d(strDecode2)) {
                throw new IllegalArgumentException("wisedist: Not a standard path");
            }
            try {
                File canonicalFile = new File(file, strDecode2).getCanonicalFile();
                if (canonicalFile.getPath().startsWith(file.getPath())) {
                    return canonicalFile;
                }
                throw new SecurityException("wisedist: Resolved path jumped beyond configured root");
            } catch (IOException unused) {
                throw new IllegalArgumentException("wisedist: Failed to resolve canonical path for");
            }
        } catch (Exception e10) {
            throw new IllegalArgumentException("UpdateSDKFileProvider error: " + e10.getMessage());
        }
    }

    @Override // com.huawei.updatesdk.fileprovider.InterfaceC8839a
    /* renamed from: a */
    public void mo56366a(String str, File file) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("wisedist Name must not be empty");
        }
        try {
            this.f45199b.put(str, file.getCanonicalFile());
        } catch (Exception unused) {
            throw new IllegalArgumentException("Failed to resolve canonical path for root");
        }
    }
}
