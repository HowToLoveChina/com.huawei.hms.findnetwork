package p736wc;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.Bundle;
import com.huawei.android.hicloud.sync.service.aidl.GenSyncLogicServiceUtil;
import com.huawei.hicloud.notification.util.NotifyUtil;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import p514o9.C11839m;

/* renamed from: wc.b */
/* loaded from: classes3.dex */
public class C13582b {

    /* renamed from: a */
    public Context f61088a;

    /* renamed from: b */
    public String f61089b;

    public C13582b(Context context, String str) {
        this.f61088a = context;
        this.f61089b = str;
    }

    /* renamed from: a */
    public static boolean m81588a(File file) {
        if (!file.exists()) {
            return true;
        }
        if (file.isDirectory()) {
            String[] list = file.list();
            if (list == null) {
                return true;
            }
            for (String str : list) {
                if (!m81588a(new File(file, str))) {
                    C11839m.m70686d("GenFileProcess", "delete file fail");
                    return false;
                }
            }
        }
        return file.delete();
    }

    /* renamed from: b */
    public void m81589b(String str, String str2, ArrayList<String> arrayList, String str3) throws Exception {
        FileOutputStream fileOutputStream;
        File file = new File(str);
        if (!m81588a(file)) {
            C11839m.m70688i("GenFileProcess", "delete file path fail");
            return;
        }
        if (!file.exists() && !file.mkdirs()) {
            C11839m.m70688i("GenFileProcess", "create file path fail");
            return;
        }
        Uri providerUri = GenSyncLogicServiceUtil.getProviderUri(1, str2, this.f61089b, arrayList, str3);
        if (providerUri == null) {
            C11839m.m70688i("GenFileProcess", "destUri is null");
            return;
        }
        if (!NotifyUtil.isTargetAppInWhitelist(this.f61088a, providerUri, str2)) {
            C11839m.m70687e("GenFileProcess", "TargetApp is not in om config.");
            return;
        }
        C11839m.m70688i("GenFileProcess", "Enter getFile : destUri = " + providerUri.toString());
        AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor = this.f61088a.getContentResolver().openAssetFileDescriptor(providerUri, "rwxrwxrwx");
        if (assetFileDescriptorOpenAssetFileDescriptor == null) {
            C11839m.m70688i("GenFileProcess", "read data is null");
            return;
        }
        FileDescriptor fileDescriptor = assetFileDescriptorOpenAssetFileDescriptor.getFileDescriptor();
        byte[] bArr = new byte[1024];
        FileInputStream fileInputStream = null;
        try {
            File file2 = new File(str + "/sync_upload.zip");
            if (file2.exists()) {
                C11839m.m70688i("GenFileProcess", "delete exists zip , result = " + file2.delete());
            }
            C11839m.m70688i("GenFileProcess", "create new zip , result = " + file2.createNewFile());
            FileInputStream fileInputStream2 = new FileInputStream(fileDescriptor);
            try {
                fileOutputStream = new FileOutputStream(file2);
                while (true) {
                    try {
                        int i10 = fileInputStream2.read(bArr);
                        if (i10 != -1) {
                            fileOutputStream.write(bArr, 0, i10);
                        } else {
                            try {
                                break;
                            } catch (Exception unused) {
                                C11839m.m70687e("GenFileProcess", "close stream exception");
                            }
                        }
                    } catch (Throwable th2) {
                        fileInputStream = fileInputStream2;
                        th = th2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception unused2) {
                                C11839m.m70687e("GenFileProcess", "close stream exception");
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Exception unused3) {
                                C11839m.m70687e("GenFileProcess", "close stream exception");
                            }
                        }
                        try {
                            assetFileDescriptorOpenAssetFileDescriptor.close();
                            throw th;
                        } catch (Exception unused4) {
                            C11839m.m70687e("GenFileProcess", "close stream exception");
                            throw th;
                        }
                    }
                }
                fileInputStream2.close();
                try {
                    fileOutputStream.close();
                } catch (Exception unused5) {
                    C11839m.m70687e("GenFileProcess", "close stream exception");
                }
                try {
                    assetFileDescriptorOpenAssetFileDescriptor.close();
                } catch (Exception unused6) {
                    C11839m.m70687e("GenFileProcess", "close stream exception");
                }
            } catch (Throwable th3) {
                fileInputStream = fileInputStream2;
                th = th3;
                fileOutputStream = null;
            }
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
        }
    }

    /* renamed from: c */
    public void m81590c(String str, String str2, ArrayList<String> arrayList, String str3, int i10) throws Exception {
        FileOutputStream fileOutputStream;
        File file = new File(str);
        if (!m81588a(file)) {
            C11839m.m70688i("GenFileProcess", "delete file path fail");
            return;
        }
        if (!file.exists() && !file.mkdirs()) {
            C11839m.m70688i("GenFileProcess", "create file path fail");
            return;
        }
        Uri uriOperationtTypeTaskTd = GenSyncLogicServiceUtil.operationtTypeTaskTd(str2, this.f61089b, arrayList, str3, i10);
        if (uriOperationtTypeTaskTd == null) {
            C11839m.m70688i("GenFileProcess", "destUri is null");
            return;
        }
        if (!NotifyUtil.isTargetAppInWhitelist(this.f61088a, uriOperationtTypeTaskTd, str2)) {
            C11839m.m70687e("GenFileProcess", "TargetApp is not in om config.");
            return;
        }
        C11839m.m70688i("GenFileProcess", "Enter getFile : destUri = " + uriOperationtTypeTaskTd.toString());
        AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor = this.f61088a.getContentResolver().openAssetFileDescriptor(uriOperationtTypeTaskTd, "rwxrwxrwx");
        if (assetFileDescriptorOpenAssetFileDescriptor == null) {
            C11839m.m70688i("GenFileProcess", "read data is null");
            return;
        }
        FileDescriptor fileDescriptor = assetFileDescriptorOpenAssetFileDescriptor.getFileDescriptor();
        byte[] bArr = new byte[1024];
        FileInputStream fileInputStream = null;
        try {
            File file2 = new File(str + "/sync_upload.zip");
            if (file2.exists()) {
                C11839m.m70688i("GenFileProcess", "delete exists zip , result = " + file2.delete());
            }
            C11839m.m70688i("GenFileProcess", "create new zip , result = " + file2.createNewFile());
            FileInputStream fileInputStream2 = new FileInputStream(fileDescriptor);
            try {
                fileOutputStream = new FileOutputStream(file2);
                while (true) {
                    try {
                        int i11 = fileInputStream2.read(bArr);
                        if (i11 != -1) {
                            fileOutputStream.write(bArr, 0, i11);
                        } else {
                            try {
                                break;
                            } catch (Exception unused) {
                                C11839m.m70687e("GenFileProcess", "close stream exception");
                            }
                        }
                    } catch (Throwable th2) {
                        fileInputStream = fileInputStream2;
                        th = th2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception unused2) {
                                C11839m.m70687e("GenFileProcess", "close stream exception");
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Exception unused3) {
                                C11839m.m70687e("GenFileProcess", "close stream exception");
                            }
                        }
                        try {
                            assetFileDescriptorOpenAssetFileDescriptor.close();
                            throw th;
                        } catch (Exception unused4) {
                            C11839m.m70687e("GenFileProcess", "close stream exception");
                            throw th;
                        }
                    }
                }
                fileInputStream2.close();
                try {
                    fileOutputStream.close();
                } catch (Exception unused5) {
                    C11839m.m70687e("GenFileProcess", "close stream exception");
                }
                try {
                    assetFileDescriptorOpenAssetFileDescriptor.close();
                } catch (Exception unused6) {
                    C11839m.m70687e("GenFileProcess", "close stream exception");
                }
            } catch (Throwable th3) {
                fileInputStream = fileInputStream2;
                th = th3;
                fileOutputStream = null;
            }
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
        }
    }

    /* renamed from: d */
    public Bundle m81591d(String str, ArrayList<String> arrayList, String str2) {
        Uri providerUri = GenSyncLogicServiceUtil.getProviderUri(3, str, this.f61089b, null, str2);
        if (providerUri == null) {
            C11839m.m70688i("GenFileProcess", "destUri is null");
            return null;
        }
        if (!NotifyUtil.isTargetAppInWhitelist(this.f61088a, providerUri, str)) {
            C11839m.m70687e("GenFileProcess", "TargetApp is not in om config.");
            return null;
        }
        C11839m.m70688i("GenFileProcess", "Enter getValidIds : destUri = " + providerUri.toString());
        Bundle bundle = new Bundle();
        bundle.putString("data_type", this.f61089b);
        bundle.putStringArrayList("ids", arrayList);
        return this.f61088a.getContentResolver().call(providerUri, "sync_call_valid_ids", (String) null, bundle);
    }
}
