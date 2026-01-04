package p006a5;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import p229di.C9142g;
import p669u5.C13126d;
import p699v4.C13334c;
import p699v4.C13339h;
import p699v4.C13345n;
import p699v4.C13348q;

/* renamed from: a5.b */
/* loaded from: classes.dex */
public class C0047b {

    /* renamed from: a */
    public static final String f109a;

    /* renamed from: b */
    public static final Map<String, String> f110b;

    /* renamed from: c */
    public static final Map<String, String> f111c;

    /* renamed from: d */
    public static final Map<String, String> f112d;

    /* renamed from: e */
    public static final Set<String> f113e;

    static {
        f109a = C9142g.m57463b() ? "content://com.hihonor.gallery.fullclone.provider.FullCloneDataProvider/rename_files" : "content://com.huawei.gallery.fullclone.provider.FullCloneDataProvider/rename_files";
        f110b = new HashMap();
        f111c = new HashMap();
        f112d = new HashMap();
        f113e = new HashSet(Arrays.asList("photo", "photo_sd", Constants.VIDEO_SUB_DIR, "video_sd", "galleryData"));
    }

    /* renamed from: a */
    public static void m173a(String str, String str2, int i10) {
        C2111d.m12647c("PhotoFileListText", "addFile oldPath = ", str, ";newPath = ", str2, ";fileType = ", Integer.valueOf(i10));
        if (i10 == 0) {
            f110b.put(str, str2);
            return;
        }
        if (i10 == 1) {
            f111c.put(str2, str2);
        } else if (i10 != 2) {
            C2111d.m12648d("PhotoFileListText", "unkonw fileType");
        } else {
            f112d.put(str, str2);
        }
    }

    /* renamed from: b */
    public static void m174b(String str) {
        if (f113e.contains(str)) {
            C2111d.m12653i("PhotoFileListText", "clearMap.");
            f111c.clear();
            f110b.clear();
            f112d.clear();
        }
    }

    /* renamed from: c */
    public static void m175c(Context context, int i10) {
        String strM176d = m176d(context, i10);
        if (TextUtils.isEmpty(strM176d)) {
            C2111d.m12648d("PhotoFileListText", "deleteRecordFile: filePath is empty.");
        } else {
            C13334c.m79980m(strM176d);
        }
    }

    /* renamed from: d */
    public static String m176d(Context context, int i10) {
        String strM80072k = C13345n.m80072k(context, 2);
        if (i10 == 0) {
            return strM80072k + "/Huawei/CloudClone/pic_favorite.txt";
        }
        if (i10 == 1) {
            return strM80072k + "/Huawei/CloudClone/pic_favorite_sd.txt";
        }
        if (i10 != 2) {
            C2111d.m12648d("PhotoFileListText", "unkonw fileType");
            return null;
        }
        return context.getApplicationContext().getFilesDir() + "/FtpTemp/copyfile/renameFile/rename_files_gallery.txt";
    }

    /* renamed from: e */
    public static boolean m177e(String str) {
        return "galleryData".equals(str) || "photo".equals(str) || Constants.VIDEO_SUB_DIR.equals(str) || "photo_sd".equals(str) || "video_sd".equals(str);
    }

    /* renamed from: f */
    public static void m178f(String str, String str2, String str3, String str4) {
        if (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            C2111d.m12648d("PhotoFileListText", "oldFilePath or renameFilePath is empty.");
            return;
        }
        if (!m177e(str)) {
            C2111d.m12648d("PhotoFileListText", "no need to record rename file.");
            return;
        }
        if (str3.contains(str2)) {
            str3 = str3.replace(str2, "");
            if (str3.startsWith("/SDCardClone")) {
                str3 = str3.replace("/SDCardClone", "");
            }
        }
        m173a(str3, str4, 2);
    }

    /* renamed from: g */
    public static void m179g(Context context, int i10, Map<String, String> map) throws Throwable {
        OutputStreamWriter outputStreamWriter;
        BufferedWriter bufferedWriter;
        if (C13348q.m80083c(map)) {
            C2111d.m12653i("PhotoFileListText", "map is empty");
            return;
        }
        String strM176d = m176d(context, i10);
        if (TextUtils.isEmpty(strM176d)) {
            C2111d.m12648d("PhotoFileListText", "filePath is empty.");
            return;
        }
        File file = new File(strM176d);
        if (!file.getParentFile().exists() && !file.getParentFile().mkdirs()) {
            C2111d.m12648d("PhotoFileListText", "create dir fail.");
            return;
        }
        FileOutputStream fileOutputStream = null;
        try {
        } catch (IOException unused) {
            outputStreamWriter = null;
            bufferedWriter = null;
        } catch (Throwable th2) {
            th = th2;
            outputStreamWriter = null;
            bufferedWriter = null;
        }
        if (!file.exists() && !file.createNewFile()) {
            C2111d.m12648d("PhotoFileListText", "createNewFile fail");
            C13339h.m80014a(null);
            C13339h.m80014a(null);
            C13339h.m80014a(null);
            return;
        }
        FileOutputStream fileOutputStream2 = new FileOutputStream(file, true);
        try {
            outputStreamWriter = new OutputStreamWriter(fileOutputStream2, "utf-8");
            try {
                bufferedWriter = new BufferedWriter(outputStreamWriter);
            } catch (IOException unused2) {
                bufferedWriter = null;
            } catch (Throwable th3) {
                th = th3;
                bufferedWriter = null;
            }
            try {
                C2111d.m12653i("PhotoFileListText", "start writeContentToFiles.");
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    if (i10 == 1) {
                        bufferedWriter.write(value);
                    } else {
                        bufferedWriter.write(key + "," + value);
                    }
                    bufferedWriter.newLine();
                }
                bufferedWriter.flush();
                C13339h.m80014a(fileOutputStream2);
            } catch (IOException unused3) {
                fileOutputStream = fileOutputStream2;
                try {
                    C2111d.m12648d("PhotoFileListText", "getOutPutStream IOException");
                    C13339h.m80014a(fileOutputStream);
                    C13339h.m80014a(outputStreamWriter);
                    C13339h.m80014a(bufferedWriter);
                } catch (Throwable th4) {
                    th = th4;
                    C13339h.m80014a(fileOutputStream);
                    C13339h.m80014a(outputStreamWriter);
                    C13339h.m80014a(bufferedWriter);
                    throw th;
                }
            } catch (Throwable th5) {
                th = th5;
                fileOutputStream = fileOutputStream2;
                C13339h.m80014a(fileOutputStream);
                C13339h.m80014a(outputStreamWriter);
                C13339h.m80014a(bufferedWriter);
                throw th;
            }
        } catch (IOException unused4) {
            outputStreamWriter = null;
            bufferedWriter = null;
        } catch (Throwable th6) {
            th = th6;
            outputStreamWriter = null;
            bufferedWriter = null;
        }
        C13339h.m80014a(outputStreamWriter);
        C13339h.m80014a(bufferedWriter);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* renamed from: h */
    public static void m180h(Context context) {
        String strM176d = m176d(context, 2);
        if (TextUtils.isEmpty(strM176d)) {
            C2111d.m12648d("PhotoFileListText", "renameFilePath is empty.");
            return;
        }
        File file = new File(strM176d);
        if (!file.exists()) {
            C2111d.m12648d("PhotoFileListText", "renameFile isn't exist.");
            return;
        }
        ?? r42 = 0;
        BufferedInputStream bufferedInputStream = null;
        OutputStream outputStreamM78958b = C13126d.m78958b(context, f109a, null);
        try {
            if (outputStreamM78958b == null) {
                C2111d.m12648d("PhotoFileListText", "get OutputStream faild.");
                return;
            }
            try {
                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int i10 = bufferedInputStream2.read(bArr, 0, 1024);
                        if (i10 == -1) {
                            break;
                        } else {
                            outputStreamM78958b.write(bArr, 0, i10);
                        }
                    }
                    C13339h.m80014a(outputStreamM78958b);
                    C13339h.m80014a(bufferedInputStream2);
                    r42 = bArr;
                } catch (IOException unused) {
                    bufferedInputStream = bufferedInputStream2;
                    C2111d.m12648d("PhotoFileListText", "writeRenameFilePathToGallery IOException");
                    C13339h.m80014a(outputStreamM78958b);
                    C13339h.m80014a(bufferedInputStream);
                    r42 = bufferedInputStream;
                    m175c(context, 2);
                } catch (Throwable th2) {
                    th = th2;
                    r42 = bufferedInputStream2;
                    C13339h.m80014a(outputStreamM78958b);
                    C13339h.m80014a(r42);
                    throw th;
                }
            } catch (IOException unused2) {
            }
            m175c(context, 2);
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* renamed from: i */
    public static void m181i(Context context, int i10, String str) throws Throwable {
        if (f113e.contains(str)) {
            C2111d.m12654j("PhotoFileListText", "writeToFile fileType: ", Integer.valueOf(i10));
            if (i10 == 0) {
                Map<String, String> map = f110b;
                m179g(context, 0, map);
                map.clear();
            } else if (i10 == 1) {
                Map<String, String> map2 = f111c;
                m179g(context, 1, map2);
                map2.clear();
            } else {
                if (i10 != 2) {
                    C2111d.m12648d("PhotoFileListText", "unkonw fileType");
                    return;
                }
                Map<String, String> map3 = f112d;
                m179g(context, 2, map3);
                map3.clear();
            }
        }
    }
}
