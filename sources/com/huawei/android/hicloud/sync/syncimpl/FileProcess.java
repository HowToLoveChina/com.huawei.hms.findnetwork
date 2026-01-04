package com.huawei.android.hicloud.sync.syncimpl;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import com.huawei.android.hicloud.sync.service.aidl.SyncLogicServiceUtil;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import p015ak.C0209d;
import p514o9.C11839m;

/* loaded from: classes3.dex */
public class FileProcess {

    /* renamed from: a */
    public Context f12986a;

    public FileProcess(Context context) {
        this.f12986a = context;
    }

    /* renamed from: a */
    public static boolean m17794a(String str) {
        File file = new File(str);
        return file.exists() || file.mkdirs();
    }

    /* renamed from: b */
    public static boolean m17795b(File file) {
        if (!file.exists()) {
            return true;
        }
        if (file.isDirectory()) {
            String[] list = file.list();
            if (list == null) {
                return true;
            }
            for (String str : list) {
                if (!m17795b(new File(file, str))) {
                    C11839m.m70686d("FileProcess", "delete file fail");
                    return false;
                }
            }
        }
        return file.delete();
    }

    /* renamed from: c */
    public static boolean m17796c(String str) {
        File file = new File(str);
        if (file.exists()) {
            return file.delete();
        }
        return true;
    }

    /* renamed from: d */
    public final void m17797d(Uri uri, String str) throws Exception {
        FileOutputStream fileOutputStream;
        C11839m.m70688i("FileProcess", "Enter getFile : destUri = " + uri.toString());
        AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor = this.f12986a.getContentResolver().openAssetFileDescriptor(uri, "rwxrwxrwx");
        if (assetFileDescriptorOpenAssetFileDescriptor == null) {
            C11839m.m70688i("FileProcess", "read data is null");
            return;
        }
        FileDescriptor fileDescriptor = assetFileDescriptorOpenAssetFileDescriptor.getFileDescriptor();
        byte[] bArr = new byte[1024];
        FileInputStream fileInputStream = null;
        try {
            File file = new File(str);
            if (file.exists()) {
                C11839m.m70688i("FileProcess", "delete exists zip , result = " + file.delete());
            }
            C11839m.m70688i("FileProcess", "create new zip , result = " + file.createNewFile());
            FileInputStream fileInputStream2 = new FileInputStream(fileDescriptor);
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                while (true) {
                    try {
                        int i10 = fileInputStream2.read(bArr);
                        if (i10 == -1) {
                            C0209d.m1263i(fileInputStream2);
                            C0209d.m1263i(fileOutputStream2);
                            C0209d.m1263i(assetFileDescriptorOpenAssetFileDescriptor);
                            return;
                        }
                        fileOutputStream2.write(bArr, 0, i10);
                    } catch (Throwable th2) {
                        fileInputStream = fileInputStream2;
                        fileOutputStream = fileOutputStream2;
                        th = th2;
                        C0209d.m1263i(fileInputStream);
                        C0209d.m1263i(fileOutputStream);
                        C0209d.m1263i(assetFileDescriptorOpenAssetFileDescriptor);
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = fileInputStream2;
                fileOutputStream = null;
            }
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
        }
    }

    /* renamed from: e */
    public void m17798e(String str, String str2, String str3, String str4, List<String> list, String str5) throws Exception {
        File file = new File(str);
        if (!m17795b(file)) {
            C11839m.m70688i("FileProcess", "delete file path fail");
            return;
        }
        if (!file.exists() && !file.mkdirs()) {
            C11839m.m70688i("FileProcess", "create file path fail");
            return;
        }
        Uri normalUploadProviderUri = SyncLogicServiceUtil.getNormalUploadProviderUri(str3, str4, list, str5);
        if (normalUploadProviderUri == null) {
            C11839m.m70688i("FileProcess", "destUri is null");
        } else if (C0209d.m1227Y1(this.f12986a, normalUploadProviderUri)) {
            m17797d(normalUploadProviderUri, str2);
        } else {
            C11839m.m70687e("FileProcess", "TargetApp is not SystemApp");
        }
    }

    /* renamed from: f */
    public void m17799f(String str, String str2, String str3, String str4, ArrayList<String> arrayList, List<String> list, String str5) throws Exception {
        if (!m17796c(str2)) {
            C11839m.m70688i("FileProcess", "delete last zip fail");
            return;
        }
        if (!m17794a(str)) {
            C11839m.m70688i("FileProcess", "create file path fail");
            return;
        }
        Uri requireUploadProviderUri = SyncLogicServiceUtil.getRequireUploadProviderUri(str3, str4, arrayList, list, str5);
        if (requireUploadProviderUri == null) {
            C11839m.m70688i("FileProcess", "destUri is null");
        } else if (C0209d.m1227Y1(this.f12986a, requireUploadProviderUri)) {
            m17797d(requireUploadProviderUri, str2);
        } else {
            C11839m.m70687e("FileProcess", "TargetApp is not SystemApp");
        }
    }
}
