package p570q8;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import com.huawei.hicloud.base.bean.CloudDiskModuleRst;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import p015ak.AbstractC0218h0;
import p015ak.C0209d;
import p015ak.C0221j;
import p514o9.C11839m;

/* renamed from: q8.c */
/* loaded from: classes2.dex */
public class C12293c {

    /* renamed from: a */
    public String[] f56942a = null;

    /* renamed from: b */
    public Uri f56943b = null;

    /* renamed from: q8.c$a */
    public static class a {

        /* renamed from: a */
        public Uri f56944a;

        public a(String str, Uri uri) {
            this.f56944a = uri;
        }
    }

    /* renamed from: a */
    public final ContentValues[] m73854a(AbstractC0218h0 abstractC0218h0, int i10, String str) {
        return i10 > 0 ? abstractC0218h0.mo1459h(str, null, null, null, null) : abstractC0218h0.mo1459h("notes_tb", null, null, null, null);
    }

    /* renamed from: b */
    public final CloudDiskModuleRst m73855b(int i10, int i11, int i12) {
        CloudDiskModuleRst cloudDiskModuleRst = new CloudDiskModuleRst();
        cloudDiskModuleRst.setRetCode(i10);
        cloudDiskModuleRst.setSuccessNum(i11);
        cloudDiskModuleRst.setFailNum(i12);
        return cloudDiskModuleRst;
    }

    /* renamed from: c */
    public final int m73856c(ContentValues contentValues, int i10) {
        if (contentValues == null) {
            return i10;
        }
        Integer asInteger = contentValues.getAsInteger("version_coloum");
        return asInteger == null ? -1 : asInteger.intValue();
    }

    /* renamed from: d */
    public final boolean m73857d(Context context, AbstractC0218h0 abstractC0218h0) throws Throwable {
        a[] aVarArr = {new a("notepad_2.2", C12291a.f56937a), new a("notepad_2.3", C12291a.f56938b)};
        for (int i10 = 0; i10 < 2; i10++) {
            a aVar = aVarArr[i10];
            if (C0209d.m1227Y1(context, aVar.f56944a)) {
                String[] strArrM73849d = C12292b.m73849d(context, aVar.f56944a);
                if (strArrM73849d != null && strArrM73849d.length >= 1) {
                    String[] strArrM73853h = C12292b.m73853h(strArrM73849d, abstractC0218h0);
                    this.f56942a = strArrM73853h;
                    if (strArrM73853h.length > 0) {
                        this.f56943b = aVar.f56944a;
                        return true;
                    }
                }
            } else {
                C11839m.m70687e("RestoreNotepadImp", "init, TargetApp is not SystemApp");
            }
        }
        return false;
    }

    /* renamed from: e */
    public final boolean m73858e(List list) {
        return list == null || list.size() == 0;
    }

    /* renamed from: f */
    public CloudDiskModuleRst m73859f(Context context, AbstractC0218h0 abstractC0218h0, Handler.Callback callback, Object obj) {
        C11839m.m70686d("RestoreNotepadImp", "beging onRestore");
        try {
            return m73862i(context, abstractC0218h0);
        } catch (Exception e10) {
            C11839m.m70687e("RestoreNotepadImp", "restoreNotepadE30 exception" + e10.toString());
            return !this.m73857d(context, abstractC0218h0) ? this.m73855b(-1, 0, 0) : this.m73861h(context, abstractC0218h0, callback, obj);
        }
    }

    /* renamed from: g */
    public final int m73860g(Context context) throws Exception {
        AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor;
        FileOutputStream fileOutputStream;
        File file = new File(C0221j.m1515y() + File.separator + "notepadRes.zip");
        if (file.exists()) {
            byte[] bArr = new byte[1024];
            Uri uri = C12291a.f56940d;
            if (!C0209d.m1227Y1(context, uri)) {
                C11839m.m70687e("RestoreNotepadImp", "TargetApp is not SystemApp");
                return -1;
            }
            FileInputStream fileInputStream = null;
            try {
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    assetFileDescriptorOpenAssetFileDescriptor = context.getContentResolver().openAssetFileDescriptor(uri, "rwxrwxrwx");
                    if (assetFileDescriptorOpenAssetFileDescriptor == null) {
                        C12292b.m73847b(fileInputStream2);
                        C12292b.m73847b(null);
                        C12292b.m73847b(assetFileDescriptorOpenAssetFileDescriptor);
                        return -1;
                    }
                    try {
                        fileOutputStream = new FileOutputStream(assetFileDescriptorOpenAssetFileDescriptor.getFileDescriptor());
                        while (true) {
                            try {
                                int i10 = fileInputStream2.read(bArr);
                                if (i10 == -1) {
                                    break;
                                }
                                fileOutputStream.write(bArr, 0, i10);
                            } catch (Throwable th2) {
                                th = th2;
                                fileInputStream = fileInputStream2;
                                C12292b.m73847b(fileInputStream);
                                C12292b.m73847b(fileOutputStream);
                                C12292b.m73847b(assetFileDescriptorOpenAssetFileDescriptor);
                                throw th;
                            }
                        }
                        C12292b.m73847b(fileInputStream2);
                        C12292b.m73847b(fileOutputStream);
                        C12292b.m73847b(assetFileDescriptorOpenAssetFileDescriptor);
                        try {
                            Uri uri2 = C12291a.f56940d;
                            if (!C0209d.m1227Y1(context, uri2)) {
                                C11839m.m70687e("RestoreNotepadImp", "restoreFile, TargetApp is not SystemApp");
                                return -1;
                            }
                            context.getContentResolver().update(uri2, new ContentValues(), null, null);
                        } catch (Exception e10) {
                            C11839m.m70687e("RestoreNotepadImp", "restoreFile e :" + e10.toString());
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        fileOutputStream = null;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    assetFileDescriptorOpenAssetFileDescriptor = null;
                    fileOutputStream = null;
                }
            } catch (Throwable th5) {
                th = th5;
                assetFileDescriptorOpenAssetFileDescriptor = null;
                fileOutputStream = null;
            }
        }
        return 0;
    }

    /* renamed from: h */
    public final CloudDiskModuleRst m73861h(Context context, AbstractC0218h0 abstractC0218h0, Handler.Callback callback, Object obj) throws IOException {
        ContentResolver contentResolver = context.getContentResolver();
        ContentValues[] contentValuesArrMo1459h = abstractC0218h0.mo1459h("notes_tb", this.f56942a, null, null, null);
        if (contentValuesArrMo1459h == null || contentValuesArrMo1459h.length < 1) {
            return m73855b(-1, 0, 0);
        }
        String[] strArr = {"title", "note", "modified"};
        HashSet<Object> hashSetM73846a = C12292b.m73846a(context, this.f56943b, C12291a.m73845a(), null, strArr);
        CloudDiskModuleRst cloudDiskModuleRst = new CloudDiskModuleRst();
        int i10 = 0;
        int i11 = 0;
        for (int i12 = 0; i12 < contentValuesArrMo1459h.length; i12++) {
            try {
                if (!C12292b.m73848c(contentValuesArrMo1459h[i12], strArr, hashSetM73846a) && contentResolver.insert(this.f56943b, contentValuesArrMo1459h[i12]) == null) {
                    i11++;
                } else {
                    i10++;
                }
            } catch (Exception e10) {
                C11839m.m70687e("RestoreNotepadImp", "Restore notepad Failed at:" + e10.toString());
                cloudDiskModuleRst.setRetCode(-1);
                cloudDiskModuleRst.setFailReason("Restore notepad Failed at:" + e10.getMessage());
                return cloudDiskModuleRst;
            }
        }
        cloudDiskModuleRst.setRetCode(2);
        cloudDiskModuleRst.setSuccessNum(i10);
        cloudDiskModuleRst.setFailNum(i11);
        return cloudDiskModuleRst;
    }

    /* renamed from: i */
    public final CloudDiskModuleRst m73862i(Context context, AbstractC0218h0 abstractC0218h0) throws Exception {
        int iM73856c;
        int i10;
        int i11;
        Bundle bundle;
        Uri uri;
        char c10;
        ContentValues[] contentValuesArrMo1459h = abstractC0218h0.mo1459h("module_uri_table", null, null, null, null);
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<String> arrayList2 = new ArrayList<>();
        int i12 = 1;
        if (contentValuesArrMo1459h.length < 1) {
            arrayList = null;
            iM73856c = -1;
        } else {
            iM73856c = m73856c(contentValuesArrMo1459h[0], -1);
            m73863j(contentValuesArrMo1459h, arrayList, arrayList2);
        }
        try {
            bundle = new Bundle();
            bundle.putInt("version", iM73856c);
            bundle.putStringArrayList("uri_list", arrayList);
            bundle.putString("package", "com.huawei.android.ds");
            uri = C12291a.f56940d;
            try {
            } catch (Exception e10) {
                e = e10;
                i10 = 0;
                i11 = 0;
            }
        } catch (Exception e11) {
            e = e11;
            i10 = 0;
            i11 = 0;
        }
        if (!C0209d.m1227Y1(context, uri)) {
            C11839m.m70687e("RestoreNotepadImp", "TargetApp is not SystemApp");
            return m73855b(-1, 0, 0);
        }
        Bundle bundleCall = context.getContentResolver().call(uri, "backup_recover_start", (String) null, bundle);
        if (bundleCall == null) {
            C11839m.m70688i("RestoreNotepadImp", "restore fail because mainBundle is null");
            return m73855b(-1, 0, 0);
        }
        if (!bundleCall.getBoolean("permit", false)) {
            CloudDiskModuleRst cloudDiskModuleRstM73855b = m73855b(-1, 0, 0);
            cloudDiskModuleRstM73855b.setFailReason("version_not_cpt");
            return cloudDiskModuleRstM73855b;
        }
        ArrayList<String> stringArrayList = bundleCall.getStringArrayList("uri_list");
        if (m73858e(stringArrayList)) {
            CloudDiskModuleRst cloudDiskModuleRstM73855b2 = m73855b(-1, 0, 0);
            cloudDiskModuleRstM73855b2.setFailReason("wait to restore list is null or empty");
            return cloudDiskModuleRstM73855b2;
        }
        if (-1 == m73860g(context)) {
            return m73855b(-1, 0, 0);
        }
        Iterator<String> it = stringArrayList.iterator();
        i10 = 0;
        i11 = 0;
        while (it.hasNext()) {
            try {
                String next = it.next();
                Uri uri2 = Uri.parse(next);
                String lastPathSegment = uri2.getLastPathSegment();
                boolean zContains = arrayList2.contains(next);
                ContentValues[] contentValuesArrM73854a = m73854a(abstractC0218h0, iM73856c, lastPathSegment);
                if (contentValuesArrM73854a.length >= i12) {
                    if (C0209d.m1227Y1(context, uri2)) {
                        for (ContentValues contentValues : contentValuesArrM73854a) {
                            if (context.getContentResolver().insert(uri2, contentValues) == null) {
                                i11++;
                                c10 = 65535;
                            } else {
                                c10 = 65535;
                                if (zContains || iM73856c == -1) {
                                    i10++;
                                }
                            }
                        }
                        i12 = 1;
                    } else {
                        C11839m.m70687e("RestoreNotepadImp", "restoreNotepadE30, TargetApp is not SystemApp");
                    }
                }
            } catch (Exception e12) {
                e = e12;
                C11839m.m70687e("RestoreNotepadImp", "restore notepad exception: " + e.toString());
                return m73855b(0, i10, i11);
            }
        }
        context.getContentResolver().call(C12291a.f56940d, "backup_recover_complete", (String) null, (Bundle) null);
        return m73855b(0, i10, i11);
    }

    /* renamed from: j */
    public final void m73863j(ContentValues[] contentValuesArr, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        for (ContentValues contentValues : contentValuesArr) {
            arrayList.add(contentValues.getAsString("uri_coloum"));
            if (contentValues.getAsBoolean("countable_coloum").booleanValue()) {
                arrayList2.add(contentValues.getAsString("uri_coloum"));
            }
        }
    }
}
