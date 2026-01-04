package hk;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.android.os.BuildEx;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.libcore.io.ExternalStorageFile;
import com.huawei.libcore.io.ExternalStorageFileInputStream;
import com.huawei.libcore.io.ExternalStorageFileOutputStream;
import com.huawei.libcore.io.ExternalStorageRandomAccessFile;
import fk.C9721b;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import p015ak.C0209d;
import p015ak.C0221j;
import p399jk.AbstractC10896a;

/* renamed from: hk.a */
/* loaded from: classes6.dex */
public class C10278a {

    /* renamed from: a */
    public static boolean f49757a = false;

    /* renamed from: a */
    public static boolean m63435a(Context context, String str) {
        try {
            m63451q(context, str);
            return true;
        } catch (Exception unused) {
            AbstractC10896a.m65886e("CreateFileUtil", str + "ClassNotFoundException");
            return false;
        }
    }

    /* renamed from: b */
    public static void m63436b(String str, String str2) throws C9721b, IOException {
        File file = new File(str);
        File file2 = new File(str2);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        File file3 = new File(file2, file.getName());
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            FileOutputStream fileOutputStream = new FileOutputStream(file3);
            byte[] bArr = new byte[1024];
            while (true) {
                int i10 = fileInputStream.read(bArr);
                if (i10 <= 0) {
                    fileInputStream.close();
                    fileOutputStream.close();
                    C0221j.m1498h(file);
                    return;
                }
                fileOutputStream.write(bArr, 0, i10);
            }
        } catch (IOException e10) {
            AbstractC10896a.m65886e("CreateFileUtil", "cutFile " + e10.getMessage());
            throw new C9721b(FamilyShareConstants.StatusCode.SHARE_SPACE_NOT_ENOUGH, "cutFile fail:" + e10.getMessage());
        }
    }

    /* renamed from: c */
    public static File m63437c(File file) {
        if (file != null && file.getParent() != null) {
            return m63442h(file.getParent());
        }
        AbstractC10896a.m65887i("CreateFileUtil", "getParentFile File = null");
        return null;
    }

    /* renamed from: d */
    public static boolean m63438d() {
        return C0209d.m1277l1() || BuildEx.VERSION.EMUI_SDK_INT >= 17;
    }

    /* renamed from: e */
    public static boolean m63439e() {
        return m63438d() && f49757a;
    }

    /* renamed from: f */
    public static File[] m63440f(File file) {
        if (file == null) {
            return null;
        }
        if (!m63439e()) {
            return file.listFiles();
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return null;
        }
        File[] fileArr = new File[fileArrListFiles.length];
        for (int i10 = 0; i10 < fileArrListFiles.length; i10++) {
            fileArr[i10] = new ExternalStorageFile(fileArrListFiles[i10].getPath());
        }
        return fileArr;
    }

    /* renamed from: g */
    public static File m63441g(File file, String str) {
        if (file == null || TextUtils.isEmpty(str)) {
            AbstractC10896a.m65887i("CreateFileUtil", "newFile Parameters error");
        }
        return m63439e() ? new ExternalStorageFile(file, str) : new File(file, str);
    }

    /* renamed from: h */
    public static File m63442h(String str) {
        if (TextUtils.isEmpty(str)) {
            AbstractC10896a.m65887i("CreateFileUtil", "newFile Parameters error");
        }
        return m63439e() ? new ExternalStorageFile(str) : new File(str);
    }

    /* renamed from: i */
    public static File m63443i(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            AbstractC10896a.m65887i("CreateFileUtil", "newFile Parameters error");
        }
        return m63439e() ? new ExternalStorageFile(str, str2) : new File(str, str2);
    }

    /* renamed from: j */
    public static FileInputStream m63444j(File file) throws FileNotFoundException {
        if (file != null) {
            return m63439e() ? new ExternalStorageFileInputStream(file) : new FileInputStream(file);
        }
        AbstractC10896a.m65886e("CreateFileUtil", "newFileInputStream  file is null");
        throw new FileNotFoundException("file is null");
    }

    /* renamed from: k */
    public static FileOutputStream m63445k(File file) throws FileNotFoundException {
        if (file != null) {
            return m63439e() ? new ExternalStorageFileOutputStream(file) : new FileOutputStream(file);
        }
        AbstractC10896a.m65886e("CreateFileUtil", "newFileOutputStream  file is null");
        throw new FileNotFoundException("file is null");
    }

    /* renamed from: l */
    public static FileOutputStream m63446l(String str) throws FileNotFoundException {
        if (str != null) {
            return m63439e() ? new ExternalStorageFileOutputStream(str) : new FileOutputStream(str);
        }
        AbstractC10896a.m65886e("CreateFileUtil", "newFileOutputStream  filePath is null");
        throw new FileNotFoundException("file is null");
    }

    /* renamed from: m */
    public static FileOutputStream m63447m(String str, boolean z10) throws FileNotFoundException {
        if (str != null) {
            return m63439e() ? new ExternalStorageFileOutputStream(str, z10) : new FileOutputStream(str, z10);
        }
        AbstractC10896a.m65886e("CreateFileUtil", "newFileOutputStream  file is null");
        throw new FileNotFoundException("file is null");
    }

    /* renamed from: n */
    public static RandomAccessFile m63448n(File file, String str) throws IOException {
        if (file != null) {
            return m63439e() ? new ExternalStorageRandomAccessFile(file, str) : new RandomAccessFile(file, str);
        }
        AbstractC10896a.m65886e("CreateFileUtil", "newFileOutputStream  file is null");
        throw new IOException("file is null");
    }

    /* renamed from: o */
    public static RandomAccessFile m63449o(String str, String str2) throws IOException {
        if (str != null) {
            return m63439e() ? new ExternalStorageRandomAccessFile(str, str2) : new RandomAccessFile(str, str2);
        }
        AbstractC10896a.m65886e("CreateFileUtil", "newFileOutputStream  file is null");
        throw new IOException("file is null");
    }

    /* renamed from: p */
    public static void m63450p(boolean z10) {
        f49757a = z10;
    }

    /* renamed from: q */
    public static void m63451q(Context context, String str) throws ClassNotFoundException {
        ClassLoader classLoader;
        if (context == null || (classLoader = context.getClass().getClassLoader()) == null) {
            return;
        }
        classLoader.loadClass(str);
    }
}
