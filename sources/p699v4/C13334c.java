package p699v4;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.os.Handler;
import android.text.TextUtils;
import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import p217d5.C9040a;

/* renamed from: v4.c */
/* loaded from: classes.dex */
public class C13334c {

    /* renamed from: a */
    public static final FileFilter f60150a = new a();

    /* renamed from: b */
    public static String f60151b = null;

    /* renamed from: c */
    public static String f60152c = null;

    /* renamed from: d */
    public static String[] f60153d = new String[3];

    /* renamed from: v4.c$a */
    public class a implements FileFilter {
        @Override // java.io.FileFilter
        public boolean accept(File file) {
            if (file == null) {
                return false;
            }
            return file.isDirectory();
        }
    }

    /* renamed from: A */
    public static long m79957A(Context context) {
        long jM79988u = m79988u(new File(C13345n.m80070i(context)));
        String strM80065d = C13345n.m80065d(context);
        return jM79988u + (strM80065d != null ? m79988u(new File(strM80065d)) : 0L);
    }

    /* renamed from: B */
    public static boolean m79958B(Context context) {
        C2111d.m12653i("FileHelper", "Init sdcard location.");
        if (context == null) {
            return false;
        }
        String[] strArrM80071j = C13345n.m80071j(context);
        f60153d = strArrM80071j;
        if (strArrM80071j[0] == null) {
            return false;
        }
        f60151b = context.getApplicationContext().getCacheDir().getPath() + "/__backupFiles1_temp__";
        f60152c = context.getApplicationContext().getCacheDir().getPath() + "/__tar_temp__";
        return true;
    }

    /* renamed from: C */
    public static boolean m79959C(String str) {
        return new File(str).exists();
    }

    /* renamed from: D */
    public static boolean m79960D(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        if (!file.exists() && !file.isFile()) {
            return false;
        }
        String name = file.getName();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str2);
        sb2.append(".obb");
        return (name.startsWith("main") || name.startsWith("patch")) && name.endsWith(sb2.toString());
    }

    /* renamed from: E */
    public static boolean m79961E() {
        return !TextUtils.isEmpty(f60153d[1]);
    }

    /* renamed from: F */
    public static String m79962F(String str) {
        return TextUtils.isEmpty(str) ? "" : str.trim();
    }

    /* renamed from: G */
    public static int m79963G(String str, String str2, int i10) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return -1;
        }
        int iIndexOf = str.indexOf(str2, 0);
        while (true) {
            int i11 = i10 - 1;
            if (i10 <= 0 || iIndexOf == -1) {
                break;
            }
            iIndexOf = str.indexOf(str2, iIndexOf + 1);
            i10 = i11;
        }
        return iIndexOf;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12, types: [java.io.InputStreamReader, java.io.Reader] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* renamed from: H */
    public static ArrayList<String> m79964H(String str) throws Throwable {
        FileInputStream fileInputStream;
        Closeable closeable;
        Closeable closeable2;
        ArrayList<String> arrayList = new ArrayList<>();
        if (TextUtils.isEmpty(str)) {
            C2111d.m12648d("FileHelper", "readFileToList: filePath is empty.");
            return arrayList;
        }
        if (!new File((String) str).exists()) {
            C2111d.m12648d("FileHelper", "readFileToList: filePath is not exist.");
            return arrayList;
        }
        BufferedReader bufferedReader = null;
        try {
            try {
                fileInputStream = new FileInputStream((String) str);
                try {
                    str = new InputStreamReader(fileInputStream, Constants.UTF_8);
                    try {
                        BufferedReader bufferedReader2 = new BufferedReader(str);
                        try {
                            for (String line = bufferedReader2.readLine(); line != null; line = bufferedReader2.readLine()) {
                                arrayList.add(line);
                            }
                            C13339h.m80014a(bufferedReader2);
                            closeable2 = str;
                        } catch (IOException unused) {
                            bufferedReader = bufferedReader2;
                            C2111d.m12653i("FileHelper", "IOException:readFileToList");
                            closeable = str;
                            C13339h.m80014a(bufferedReader);
                            closeable2 = closeable;
                            C13339h.m80014a(closeable2);
                            C13339h.m80014a(fileInputStream);
                            return arrayList;
                        } catch (Exception unused2) {
                            bufferedReader = bufferedReader2;
                            C2111d.m12653i("FileHelper", "Exception:readFileToList");
                            closeable = str;
                            C13339h.m80014a(bufferedReader);
                            closeable2 = closeable;
                            C13339h.m80014a(closeable2);
                            C13339h.m80014a(fileInputStream);
                            return arrayList;
                        } catch (Throwable th2) {
                            th = th2;
                            bufferedReader = bufferedReader2;
                            C13339h.m80014a(bufferedReader);
                            C13339h.m80014a(str);
                            C13339h.m80014a(fileInputStream);
                            throw th;
                        }
                    } catch (IOException unused3) {
                    } catch (Exception unused4) {
                    }
                } catch (IOException unused5) {
                    str = 0;
                } catch (Exception unused6) {
                    str = 0;
                } catch (Throwable th3) {
                    th = th3;
                    str = 0;
                }
            } catch (IOException unused7) {
                str = 0;
                fileInputStream = null;
            } catch (Exception unused8) {
                str = 0;
                fileInputStream = null;
            } catch (Throwable th4) {
                th = th4;
                str = 0;
                fileInputStream = null;
            }
            C13339h.m80014a(closeable2);
            C13339h.m80014a(fileInputStream);
            return arrayList;
        } catch (Throwable th5) {
            th = th5;
        }
    }

    /* renamed from: I */
    public static String m79965I(String[] strArr) throws IOException {
        return m79966J(strArr, null);
    }

    /* renamed from: J */
    public static String m79966J(String[] strArr, String str) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        boolean z10 = false;
        for (String str2 : strArr) {
            if (str2 != null) {
                if (z10) {
                    stringBuffer.append(File.separator);
                }
                stringBuffer.append(m79962F(str2));
                File file = new File(stringBuffer.toString());
                if (!file.exists() && !file.mkdirs()) {
                    if (!file.exists()) {
                        C2111d.m12648d("FileHelper", "create fileDir: " + file.getPath() + " failed");
                        throw new IOException("create fileDir: " + file.getPath() + " failed");
                    }
                    C2111d.m12646b("FileHelper", "[structureDirsAndFile]:exist" + file.getPath());
                }
                z10 = true;
            }
        }
        if (str != null) {
            stringBuffer.append(File.separator + str);
        }
        if (stringBuffer.length() < 1) {
            C2111d.m12648d("FileHelper", "length < 1" + stringBuffer.toString());
            return null;
        }
        C2111d.m12646b("FileHelper", "[structureDirsAndFile]: nameBuffer" + stringBuffer.toString());
        return stringBuffer.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12, types: [java.io.Closeable, java.io.OutputStreamWriter, java.io.Writer] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* renamed from: K */
    public static boolean m79967K(List<String> list, String str) throws Throwable {
        FileOutputStream fileOutputStream;
        Closeable closeable;
        if (C13348q.m80082b(list)) {
            C2111d.m12648d("FileHelper", "writeListToFile: srcList is empty.");
            return false;
        }
        ?? file = new File(str);
        if (!m79978k(file)) {
            C2111d.m12648d("FileHelper", "writeListToFile: create file faild.");
            return false;
        }
        BufferedWriter bufferedWriter = null;
        try {
            try {
                fileOutputStream = new FileOutputStream((File) file, true);
                try {
                    file = new OutputStreamWriter(fileOutputStream, Constants.UTF_8);
                    try {
                        BufferedWriter bufferedWriter2 = new BufferedWriter(file);
                        try {
                            Iterator<String> it = list.iterator();
                            while (it.hasNext()) {
                                bufferedWriter2.write(it.next());
                                bufferedWriter2.newLine();
                            }
                            C13339h.m80014a(bufferedWriter2);
                            C13339h.m80014a(file);
                            C13339h.m80014a(fileOutputStream);
                            return true;
                        } catch (IOException unused) {
                            bufferedWriter = bufferedWriter2;
                            C2111d.m12653i("FileHelper", "IOException:writeListToFile");
                            closeable = file;
                            C13339h.m80014a(bufferedWriter);
                            C13339h.m80014a(closeable);
                            C13339h.m80014a(fileOutputStream);
                            return false;
                        } catch (Exception unused2) {
                            bufferedWriter = bufferedWriter2;
                            C2111d.m12653i("FileHelper", "Exception:writeListToFile");
                            closeable = file;
                            C13339h.m80014a(bufferedWriter);
                            C13339h.m80014a(closeable);
                            C13339h.m80014a(fileOutputStream);
                            return false;
                        } catch (Throwable th2) {
                            th = th2;
                            bufferedWriter = bufferedWriter2;
                            C13339h.m80014a(bufferedWriter);
                            C13339h.m80014a(file);
                            C13339h.m80014a(fileOutputStream);
                            throw th;
                        }
                    } catch (IOException unused3) {
                    } catch (Exception unused4) {
                    }
                } catch (IOException unused5) {
                    file = 0;
                } catch (Exception unused6) {
                    file = 0;
                } catch (Throwable th3) {
                    th = th3;
                    file = 0;
                }
            } catch (IOException unused7) {
                file = 0;
                fileOutputStream = null;
            } catch (Exception unused8) {
                file = 0;
                fileOutputStream = null;
            } catch (Throwable th4) {
                th = th4;
                file = 0;
                fileOutputStream = null;
            }
        } catch (Throwable th5) {
            th = th5;
        }
    }

    /* renamed from: a */
    public static boolean m79968a(String str, long j10) {
        if (str == null) {
            return false;
        }
        try {
            long jM80064c = C13345n.m80064c(str);
            C2111d.m12654j("FileHelper", "[Storage] checkAvailableSize three size = ", m79972e(jM80064c), ", limit = ", m79972e(j10), ", location = ", str);
            if (jM80064c >= j10) {
                return true;
            }
            C2111d.m12648d("FileHelper", "[Storage] available size is not enough");
            return false;
        } catch (IllegalArgumentException e10) {
            C2111d.m12648d("FileHelper", "getAvailableSize Exception" + e10.getMessage());
            return false;
        } catch (Exception unused) {
            C2111d.m12648d("FileHelper", "getAvailableSize Exception");
            return false;
        }
    }

    /* renamed from: b */
    public static boolean m79969b(String str, Handler.Callback callback, long j10) {
        if (str == null) {
            C2111d.m12648d("FileHelper", "checkAvailableSize Error : Default Storage has not been set up!");
            C9040a.m57002b(callback, 36, 0, 0, null);
            return false;
        }
        try {
            String strM79965I = m79965I(new String[]{str});
            try {
                long jM80064c = C13345n.m80064c(strM79965I);
                C2111d.m12654j("FileHelper", "[Storage] checkAvailableSize one size= ", m79972e(jM80064c), ", limit: ", m79972e(j10), ",location = ", strM79965I);
                if (jM80064c >= j10) {
                    return true;
                }
                int iM79993z = m79993z(strM79965I);
                C2111d.m12648d("FileHelper", "[Storage] SDcard available size is not enough");
                C9040a.m57002b(callback, 15, iM79993z, 0, null);
                return false;
            } catch (IllegalArgumentException e10) {
                C2111d.m12648d("FileHelper", "getAvailableSize IllegalArgumentException" + e10.getMessage());
                C9040a.m57001a(callback, 36);
                return false;
            } catch (Exception unused) {
                C2111d.m12648d("FileHelper", "getAvailableSize Exception error");
                C9040a.m57001a(callback, 36);
                return false;
            }
        } catch (IOException unused2) {
            C2111d.m12648d("FileHelper", "checkAvailableSize Error : Construct dirs failed!");
            C9040a.m57002b(callback, 11, 0, 0, str);
            return false;
        }
    }

    /* renamed from: c */
    public static boolean m79970c(File file) {
        if (file != null && file.exists() && file.isFile()) {
            if (file.length() > 0) {
                return true;
            }
            if (!file.delete()) {
                C2111d.m12648d("FileHelper", "delete file err:" + file.getPath());
            }
        }
        return false;
    }

    /* renamed from: d */
    public static void m79971d() {
        m79980m(f60151b);
    }

    /* renamed from: e */
    public static String m79972e(long j10) {
        return String.valueOf(j10 >> 20) + "M";
    }

    /* renamed from: f */
    public static boolean m79973f(Context context) {
        File file = new File(C13345n.m80072k(context, 2) + "/Huawei/CloudClone");
        if (!file.exists()) {
            if (!file.mkdirs()) {
                C2111d.m12648d("FileHelper", "create dir failed.");
                return false;
            }
            C2111d.m12653i("FileHelper", "create dir successfully.");
        }
        C2111d.m12653i("FileHelper", "dir is exist.");
        return true;
    }

    /* renamed from: g */
    public static boolean m79974g(String str) {
        File file = new File(str);
        if (file.exists()) {
            C2111d.m12653i("FileHelper", "dir is exist.");
            return true;
        }
        if (file.mkdirs()) {
            C2111d.m12653i("FileHelper", "create dir successfully.");
            return true;
        }
        C2111d.m12648d("FileHelper", "create dir failed.");
        return false;
    }

    /* renamed from: h */
    public static boolean m79975h(File file) {
        File parentFile;
        try {
            parentFile = file.getParentFile();
        } catch (IOException unused) {
            C2111d.m12648d("FileHelper", "createNewFile fail");
        }
        if (file.getParentFile().exists() || parentFile.mkdirs()) {
            return file.createNewFile();
        }
        C2111d.m12648d("FileHelper", "parentFolder mkdirs failed");
        return false;
    }

    /* renamed from: i */
    public static boolean m79976i(File file) {
        if (file == null || file.exists()) {
            return false;
        }
        return m79975h(file);
    }

    /* renamed from: j */
    public static boolean m79977j(File file) {
        if (file == null) {
            return false;
        }
        if (file.exists() && !m79979l(file)) {
            C2111d.m12648d("FileHelper", "file delete failed");
            return false;
        }
        if (file.mkdir()) {
            return true;
        }
        C2111d.m12648d("FileHelper", "New dir create failed");
        return false;
    }

    /* renamed from: k */
    public static boolean m79978k(File file) {
        if (file == null) {
            return false;
        }
        if (!file.exists() || file.delete()) {
            return m79975h(file);
        }
        C2111d.m12648d("FileHelper", "file delete failed");
        return false;
    }

    /* renamed from: l */
    public static boolean m79979l(File file) {
        File[] fileArrListFiles;
        if (file == null || !file.exists()) {
            return true;
        }
        if (file.isDirectory() && (fileArrListFiles = file.listFiles()) != null) {
            for (File file2 : fileArrListFiles) {
                m79979l(file2);
            }
        }
        return file.delete();
    }

    /* renamed from: m */
    public static boolean m79980m(String str) {
        if (str == null) {
            return false;
        }
        return m79979l(new File(str));
    }

    /* renamed from: n */
    public static Bitmap m79981n(Drawable drawable) {
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            return null;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        drawable.draw(canvas);
        return bitmapCreateBitmap;
    }

    /* renamed from: o */
    public static void m79982o(Drawable drawable, File file) throws Throwable {
        Bitmap bitmapM79981n = m79981n(drawable);
        if (bitmapM79981n == null) {
            return;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmapM79981n.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    fileOutputStream2.write(byteArray);
                    try {
                        fileOutputStream2.close();
                    } catch (IOException unused) {
                        C2111d.m12648d("FileHelper", "close FileOutputStream drawableToFile IOException");
                    }
                } catch (FileNotFoundException unused2) {
                    fileOutputStream = fileOutputStream2;
                    C2111d.m12648d("FileHelper", "drawableToFile FileNotFoundException");
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException unused3) {
                            C2111d.m12648d("FileHelper", "close FileOutputStream drawableToFile IOException");
                        }
                    }
                    byteArrayOutputStream.close();
                } catch (IOException unused4) {
                    fileOutputStream = fileOutputStream2;
                    C2111d.m12648d("FileHelper", "drawableToFile IOException");
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException unused5) {
                            C2111d.m12648d("FileHelper", "close FileOutputStream drawableToFile IOException");
                        }
                    }
                    byteArrayOutputStream.close();
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException unused6) {
                            C2111d.m12648d("FileHelper", "close FileOutputStream drawableToFile IOException");
                        }
                    }
                    try {
                        byteArrayOutputStream.close();
                        throw th;
                    } catch (IOException unused7) {
                        C2111d.m12648d("FileHelper", "close ByteArrayOutputStream drawableToFile IOException");
                        throw th;
                    }
                }
            } catch (FileNotFoundException unused8) {
            } catch (IOException unused9) {
            }
            try {
                byteArrayOutputStream.close();
            } catch (IOException unused10) {
                C2111d.m12648d("FileHelper", "close ByteArrayOutputStream drawableToFile IOException");
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* renamed from: p */
    public static List<String> m79983p(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return new ArrayList(0);
        }
        ArrayList arrayList = new ArrayList(2);
        ArrayList<String> arrayListM79985r = m79985r(str);
        int size = arrayListM79985r.size();
        for (int i10 = 0; i10 < size; i10++) {
            String str3 = arrayListM79985r.get(i10);
            if (m79960D(str3, str2)) {
                arrayList.add(str3);
            }
        }
        return arrayList;
    }

    /* renamed from: q */
    public static String m79984q() {
        return ".apk";
    }

    /* renamed from: r */
    public static ArrayList<String> m79985r(String str) {
        File[] fileArrListFiles;
        ArrayList<String> arrayList = new ArrayList<>();
        if (!TextUtils.isEmpty(str) && (fileArrListFiles = new File(str).listFiles()) != null && fileArrListFiles.length != 0) {
            try {
                for (File file : fileArrListFiles) {
                    if (file.isDirectory()) {
                        arrayList.addAll(m79985r(file.getCanonicalPath()));
                    } else {
                        arrayList.add(file.getCanonicalPath());
                    }
                }
            } catch (IOException unused) {
                C2111d.m12648d("FileHelper", "Get childFiles failed");
            } catch (SecurityException unused2) {
                C2111d.m12648d("FileHelper", "Get childFiles failed no permission");
            } catch (Exception unused3) {
                C2111d.m12648d("FileHelper", "Get childFiles failed Exception");
            }
        }
        return arrayList;
    }

    /* renamed from: s */
    public static String m79986s() {
        return "/" + new SimpleDateFormat("yyyyMMddHHmmss", Locale.getDefault()).format(Calendar.getInstance().getTime());
    }

    /* renamed from: t */
    public static String m79987t(String str) {
        if (str == null) {
            return null;
        }
        int iLastIndexOf = str.lastIndexOf(File.separator);
        int iLastIndexOf2 = str.lastIndexOf(".");
        if (iLastIndexOf != -1 && iLastIndexOf2 != -1) {
            return str.substring(iLastIndexOf + 1, iLastIndexOf2);
        }
        C2111d.m12648d("FileHelper", "getFileNameByPath fail");
        return null;
    }

    /* renamed from: u */
    public static long m79988u(File file) {
        long jM79988u = 0;
        if (file == null) {
            return 0L;
        }
        if (file.isFile()) {
            return file.length();
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return 0L;
        }
        for (File file2 : fileArrListFiles) {
            jM79988u += m79988u(file2);
        }
        return jM79988u;
    }

    /* renamed from: v */
    public static String m79989v(String str, String str2, String str3, String str4) throws IOException {
        if (str == null) {
            str = f60153d[0];
        }
        if (str2 == null) {
            str2 = m79986s();
        }
        if (str4 == null) {
            str4 = "info";
        }
        return m79966J(new String[]{str, str3, str2}, str4);
    }

    /* renamed from: w */
    public static String[] m79990w() {
        String[] strArr = f60153d;
        return strArr != null ? (String[]) strArr.clone() : new String[0];
    }

    /* renamed from: x */
    public static String m79991x(File file) throws IOException {
        String canonicalPath = "";
        if (file == null) {
            return "";
        }
        try {
            canonicalPath = file.getCanonicalPath();
        } catch (IOException unused) {
            C2111d.m12648d("FileFactory", "IOE");
        }
        if (!canonicalPath.startsWith("/data/data") || !file.getAbsolutePath().startsWith("/data/user/0")) {
            return canonicalPath;
        }
        return "/data/user/0" + canonicalPath.substring(10);
    }

    /* renamed from: y */
    public static String m79992y(String str, String str2) {
        if (str == null || str2 == null) {
            C2111d.m12648d("FileHelper", "getStorageRootPath fail : Path or subDir is null");
            return "";
        }
        int iIndexOf = str.indexOf(str2);
        return iIndexOf == -1 ? "" : str.substring(0, iIndexOf);
    }

    /* renamed from: z */
    public static int m79993z(String str) {
        C2111d.m12653i("FileHelper", "Get Storage type");
        if (str == null) {
            C2111d.m12648d("FileHelper", "Location is null");
            return 0;
        }
        if (str.contains("/HuaweiBackup")) {
            return m79993z(m79992y(str, "/HuaweiBackup"));
        }
        StringBuilder sb2 = new StringBuilder();
        String str2 = File.separator;
        sb2.append(str2);
        sb2.append(CloudBackupConstant.Command.PMS_CMD_BACKUP);
        if (str.contains(sb2.toString())) {
            return m79993z(m79992y(str, str2 + CloudBackupConstant.Command.PMS_CMD_BACKUP));
        }
        if (str.equals(Environment.getDataDirectory().getPath())) {
            return 1;
        }
        if (str.equals(f60153d[0])) {
            return 2;
        }
        if (str.equals(f60153d[1])) {
            return 3;
        }
        if (str.equals(f60153d[2])) {
            return 4;
        }
        C2111d.m12648d("FileHelper", "unknown storage type");
        return 0;
    }
}
