package p548p8;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Environment;
import android.os.storage.StorageManager;
import android.os.storage.StorageVolume;
import com.huawei.android.hicloud.clouddisk.logic.media.model.RemoteFile;
import com.huawei.android.hicloud.complexutil.CloudSyncUtil;
import hk.C10278a;
import hk.C10279b;
import java.io.File;
import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import p035bk.C1249b;
import p514o9.C11839m;

/* renamed from: p8.a */
/* loaded from: classes2.dex */
public final class C12120a {

    /* renamed from: p8.a$b */
    public static class b implements Comparator<RemoteFile>, Serializable {
        private static final long serialVersionUID = 1;

        public b() {
        }

        @Override // java.util.Comparator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public int compare(RemoteFile remoteFile, RemoteFile remoteFile2) {
            if (remoteFile.m15462g() > remoteFile2.m15462g()) {
                return 1;
            }
            return remoteFile.m15462g() == remoteFile2.m15462g() ? 0 : -1;
        }
    }

    /* renamed from: a */
    public static boolean m72669a(String str) {
        if (str == null) {
            return false;
        }
        try {
            return C10278a.m63442h(str).exists();
        } catch (Exception unused) {
            C11839m.m70687e("FileManager", "checkFileIsExists is error.");
            return false;
        }
    }

    /* renamed from: d */
    public static boolean m72670d(String str) {
        if (str == null) {
            return false;
        }
        try {
            File fileM63442h = C10278a.m63442h(str);
            return !fileM63442h.exists() ? fileM63442h.mkdir() : true;
        } catch (Exception unused) {
            C11839m.m70689w("FileManager", "createFile error.");
            return false;
        }
    }

    /* renamed from: b */
    public boolean m72671b(String str, String... strArr) {
        String str2 = "" + File.separatorChar;
        for (String str3 : strArr) {
            if (!m72669a(str3)) {
                String[] strArrSplit = str3.substring(str.length() + 1).split(str2);
                StringBuffer stringBuffer = new StringBuffer(str);
                for (String str4 : strArrSplit) {
                    stringBuffer.append(File.separator + str4);
                    if (!m72669a(stringBuffer.toString()) && !m72670d(stringBuffer.toString())) {
                        C11839m.m70687e("FileManager", "Exit download method. create folder Failed.");
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /* renamed from: c */
    public boolean m72672c(String str) {
        File fileM63442h = C10278a.m63442h(str);
        boolean zDelete = true;
        if (!fileM63442h.exists()) {
            return true;
        }
        File[] fileArrM63440f = C10278a.m63440f(fileM63442h);
        if (fileArrM63440f != null) {
            for (File file : fileArrM63440f) {
                if (file.getName().endsWith(".tmp")) {
                    zDelete = file.delete();
                }
            }
        }
        return zDelete;
    }

    /* renamed from: e */
    public String m72673e(int i10, String str) {
        if (i10 < 1) {
            StringBuffer stringBuffer = new StringBuffer("Copy ");
            stringBuffer.append(str);
            return stringBuffer.toString();
        }
        StringBuffer stringBuffer2 = new StringBuffer("Copy(");
        stringBuffer2.append(i10);
        stringBuffer2.append(") ");
        stringBuffer2.append(str);
        return stringBuffer2.toString();
    }

    @SuppressLint({"NewApi"})
    /* renamed from: f */
    public Map<String, String> m72674f(Context context) {
        Object objM7479b;
        HashMap map = new HashMap(2);
        if (context == null) {
            return map;
        }
        StorageManager storageManager = (StorageManager) context.getSystemService("storage");
        StorageVolume[] storageVolumeArrM7483f = C1249b.m7483f(storageManager);
        int length = storageVolumeArrM7483f.length;
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                break;
            }
            StorageVolume storageVolume = storageVolumeArrM7483f[i10];
            if (storageVolume.getUuid() != null) {
                File fileM7482e = C1249b.m7482e(storageVolume);
                Object objM7478a = C1249b.m7478a(storageManager, storageVolume.getUuid());
                if (objM7478a != null && (objM7479b = C1249b.m7479b(objM7478a)) != null && !storageVolume.isPrimary() && C1249b.m7485h(objM7479b) && "mounted".equals(Environment.getExternalStorageState(fileM7482e))) {
                    map.put("out", C1249b.m7481d(storageVolume));
                    break;
                }
            }
            i10++;
        }
        map.put("in", CloudSyncUtil.m15953H(context));
        return map;
    }

    /* renamed from: g */
    public boolean m72675g(String str, List<String>... listArr) {
        for (List<String> list : listArr) {
            if (list.contains(str.toLowerCase(Locale.getDefault()))) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: h */
    public File m72676h(File file, String str) {
        if (file.exists()) {
            String strM63452a = C10279b.m63452a(file);
            File fileM63442h = C10278a.m63442h(strM63452a.substring(0, strM63452a.indexOf(file.getName())) + str);
            if (file.renameTo(fileM63442h)) {
                return fileM63442h;
            }
        }
        return file;
    }

    /* renamed from: i */
    public void m72677i(List<RemoteFile> list) {
        Collections.sort(list, new b());
    }
}
