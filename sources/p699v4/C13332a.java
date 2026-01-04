package p699v4;

import android.annotation.TargetApi;
import android.text.TextUtils;
import com.huawei.android.backup.filelogic.utils.C2111d;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SyncFailedException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import p601r4.C12463c;
import p601r4.C12464d;

/* renamed from: v4.a */
/* loaded from: classes.dex */
public class C13332a {

    @TargetApi(21)
    /* renamed from: v4.a$a */
    public static class a extends RecursiveTask<Map<String, Long>> {
        private static final long serialVersionUID = -7361607931331252659L;

        /* renamed from: a */
        public File f60149a;

        public a(File file) {
            this.f60149a = file;
        }

        @Override // java.util.concurrent.RecursiveTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map<String, Long> compute() {
            HashMap map = new HashMap();
            if (this.f60149a.isFile()) {
                map.put(C13334c.m79991x(this.f60149a), Long.valueOf(this.f60149a.length()));
                return map;
            }
            File[] fileArrListFiles = this.f60149a.listFiles();
            if (fileArrListFiles != null) {
                ArrayList arrayList = new ArrayList();
                for (File file : fileArrListFiles) {
                    if (file.isFile()) {
                        map.put(C13334c.m79991x(file), Long.valueOf(file.length()));
                    } else {
                        a aVar = new a(file);
                        arrayList.add(aVar);
                        aVar.fork();
                    }
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    Map map2 = (Map) ((ForkJoinTask) it.next()).join();
                    if (map2 != null) {
                        map.putAll(map2);
                    }
                }
            }
            return map;
        }
    }

    /* renamed from: a */
    public static boolean m79947a(File file) {
        if (file == null) {
            return false;
        }
        if (file.exists() || file.getParentFile().exists() || file.getParentFile().mkdirs()) {
            return true;
        }
        C2111d.m12648d("CloneFileUtils", "buildFilePath fail");
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: b */
    public static boolean m79948b(File file, File file2) throws Throwable {
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStreamM74719a;
        if (file == null || file2 == null) {
            return false;
        }
        FileOutputStream fileOutputStreamM74720a = null;
        try {
            fileInputStreamM74719a = C12463c.m74719a(file);
        } catch (IOException unused) {
            fileOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
        }
        try {
            if (!file2.exists()) {
                m79947a(file2);
            } else if (!file2.delete()) {
                C2111d.m12657m("CloneFileUtils", "delete file fail");
            }
            fileOutputStreamM74720a = C12464d.m74720a(file2);
            byte[] bArr = new byte[4096];
            while (true) {
                int i10 = fileInputStreamM74719a.read(bArr);
                if (i10 < 0) {
                    fileOutputStreamM74720a.flush();
                    C13339h.m80014a(fileInputStreamM74719a);
                    m79951e(fileOutputStreamM74720a);
                    C13339h.m80014a(fileOutputStreamM74720a);
                    return true;
                }
                fileOutputStreamM74720a.write(bArr, 0, i10);
            }
        } catch (IOException unused2) {
            FileOutputStream fileOutputStream2 = fileOutputStreamM74720a;
            fileOutputStreamM74720a = fileInputStreamM74719a;
            fileOutputStream = fileOutputStream2;
            try {
                C2111d.m12648d("CloneFileUtils", "copyFile error happen");
                C13339h.m80014a(fileOutputStreamM74720a);
                m79951e(fileOutputStream);
                C13339h.m80014a(fileOutputStream);
                return false;
            } catch (Throwable th3) {
                th = th3;
                C13339h.m80014a(fileOutputStreamM74720a);
                m79951e(fileOutputStream);
                C13339h.m80014a(fileOutputStream);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            FileOutputStream fileOutputStream3 = fileOutputStreamM74720a;
            fileOutputStreamM74720a = fileInputStreamM74719a;
            fileOutputStream = fileOutputStream3;
            C13339h.m80014a(fileOutputStreamM74720a);
            m79951e(fileOutputStream);
            C13339h.m80014a(fileOutputStream);
            throw th;
        }
    }

    @TargetApi(21)
    /* renamed from: c */
    public static Map<String, Long> m79949c(String str) {
        C2111d.m12653i("CloneFileUtils", "getFileMapByForkJoinPool begin");
        long jCurrentTimeMillis = System.currentTimeMillis();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        Map<String, Long> map = (Map) forkJoinPool.invoke(new a(new File(str)));
        forkJoinPool.shutdownNow();
        if (map != null) {
            C2111d.m12654j("CloneFileUtils", "getFileMapByForkJoinPool end, size: ", Integer.valueOf(map.size()), ", time cost: ", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
            return map;
        }
        C2111d.m12653i("CloneFileUtils", "fileMap is null.");
        return new HashMap(0);
    }

    /* renamed from: d */
    public static Map<String, Long> m79950d(String str) {
        if (TextUtils.isEmpty(str)) {
            return Collections.emptyMap();
        }
        HashMap map = new HashMap();
        map.putAll(m79949c(str));
        return map;
    }

    /* renamed from: e */
    public static boolean m79951e(FileOutputStream fileOutputStream) throws SyncFailedException {
        if (fileOutputStream == null) {
            return true;
        }
        try {
            fileOutputStream.getFD().sync();
            return true;
        } catch (IOException unused) {
            C2111d.m12657m("CloneFileUtils", "FileOutputStream sync error");
            return false;
        }
    }
}
