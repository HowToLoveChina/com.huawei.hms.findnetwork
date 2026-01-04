package p031b7;

import android.content.Context;
import android.os.Environment;
import android.os.storage.StorageManager;
import android.os.storage.StorageVolume;
import android.text.TextUtils;
import com.huawei.android.hicloud.drive.cloudphoto.model.Album;
import com.huawei.android.hicloud.drive.cloudphoto.model.Media;
import com.huawei.android.p069cg.p072vo.FileInfo;
import hk.C10278a;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import p031b7.C1136q;
import p035bk.C1249b;
import p603r6.C12467a;
import p649t6.C12941a;

/* renamed from: b7.e */
/* loaded from: classes2.dex */
public class C1124e {

    /* renamed from: a */
    public static String f5378a;

    /* renamed from: b */
    public static List<String> f5379b;

    /* renamed from: c */
    public static String f5380c;

    /* renamed from: a */
    public static List<String> m6857a(Context context) {
        if (context == null) {
            return null;
        }
        new ArrayList();
        List<String> listM6873q = m6873q(context);
        if (listM6873q == null || listM6873q.size() < 1) {
            return null;
        }
        return listM6873q;
    }

    /* renamed from: b */
    public static String m6858b(Context context) {
        if (context == null) {
            return null;
        }
        return m6872p();
    }

    /* renamed from: c */
    public static String m6859c(Context context) {
        StorageManager storageManager;
        StorageVolume[] storageVolumeArrM7483f;
        if (context == null || (storageVolumeArrM7483f = C1249b.m7483f((storageManager = (StorageManager) context.getSystemService("storage")))) == null) {
            return null;
        }
        for (StorageVolume storageVolume : storageVolumeArrM7483f) {
            if (storageVolume == null) {
                C1120a.m6676e("FileHelper", "storageVolume is null");
            } else if (storageVolume.getUuid() == null) {
                C1120a.m6676e("FileHelper", "uuid is null");
            } else {
                File fileM7482e = C1249b.m7482e(storageVolume);
                Object objM7478a = C1249b.m7478a(storageManager, storageVolume.getUuid());
                Object objM7479b = C1249b.m7479b(objM7478a);
                if (fileM7482e == null || fileM7482e.getPath() == null || fileM7482e.getPath().isEmpty() || objM7478a == null || objM7479b == null) {
                    C1120a.m6678w("FileHelper", "pathFile invalid, ignore");
                } else {
                    C1120a.m6675d("FileHelper", "calcUdiskStoragePath exterPath: " + fileM7482e.getPath() + ", isPrimary: " + storageVolume.isPrimary() + ", isRemovable: " + storageVolume.isRemovable() + ", Uuid: " + storageVolume.getUuid());
                    if (!storageVolume.isPrimary() && C1249b.m7486i(objM7479b) && m6878v(context, fileM7482e.getPath())) {
                        return fileM7482e.getPath();
                    }
                }
            }
        }
        return null;
    }

    /* renamed from: d */
    public static boolean m6860d() {
        List<String> list = f5379b;
        return list == null || list.size() == 0;
    }

    /* renamed from: e */
    public static boolean m6861e(String str) {
        return str == null || str.isEmpty();
    }

    /* renamed from: f */
    public static String m6862f(Context context, String str, long j10) {
        String str2 = f5378a;
        if (str == null) {
            C1120a.m6678w("FileHelper", "getDownloadRootPath albumId is null");
            return str2;
        }
        if (!str.startsWith("default-album-")) {
            return str2;
        }
        List<String> list = f5379b;
        String externalRootPath = (list == null || list.size() == 0) ? C1136q.c.m7118a(context).getExternalRootPath() : f5379b.get(0);
        if (externalRootPath == null || externalRootPath.isEmpty()) {
            return str2;
        }
        try {
            return C1122c.m6698G0(externalRootPath) >= j10 + 52428800 ? externalRootPath : str2;
        } catch (Exception unused) {
            C1120a.m6675d("FileHelper", "getAvailSize exception");
            return f5378a;
        }
    }

    /* renamed from: g */
    public static String m6863g() {
        List<String> list = f5379b;
        return (list == null || list.size() <= 0) ? "" : f5379b.get(0);
    }

    /* renamed from: h */
    public static String m6864h(Context context, FileInfo fileInfo, int i10) {
        String albumName;
        String albumId = fileInfo.getAlbumId();
        boolean z10 = false;
        Album albumM77726A = new C12941a().m77726A(albumId, false);
        if (albumM77726A == null) {
            C1120a.m6676e("FileHelper", "getGalleryCachePath album is null");
            return "";
        }
        if (albumId.startsWith("default-album-")) {
            albumName = albumM77726A.getLocalPath();
        } else {
            if (TextUtils.isEmpty(fileInfo.getFileName())) {
                C1120a.m6676e("FileHelper", "Not a default album, album name is null, which file is: " + C1122c.m6818p0(fileInfo.getFileName()));
                return "";
            }
            albumName = albumM77726A.getAlbumName();
            z10 = true;
        }
        String str = albumName;
        if (TextUtils.isEmpty(str)) {
            C1120a.m6676e("FileHelper", "Default album, lpath or albumName is null, which file is: " + C1122c.m6818p0(fileInfo.getFileName()));
            return "";
        }
        C1120a.m6675d("FileHelper", "appendParam:" + str + ", which file is: " + C1122c.m6818p0(fileInfo.getFileName()));
        String strM6895p = (i10 == 0 || z10) ? C1125f.m6895p(fileInfo, i10) : C1125f.m6890k(fileInfo, i10);
        return i10 == 0 ? m6875s(context, albumId, strM6895p, fileInfo.getSize(), str) : C12467a.m74744b(context, i10, albumId, strM6895p);
    }

    /* renamed from: i */
    public static String m6865i(Context context, Media media, Album album, int i10, boolean z10) {
        if (album == null) {
            C1120a.m6676e("FileHelper", "getGalleryCachePath album is null");
            return "";
        }
        String id2 = album.getId();
        String localPath = id2.startsWith("default-album-") ? album.getLocalPath() : "";
        if (TextUtils.isEmpty(localPath)) {
            C1120a.m6676e("FileHelper", "Default album, lpath or albumName is null ");
            return "";
        }
        C1120a.m6675d("FileHelper", "appendParam:" + localPath);
        String strM6891l = i10 != 0 ? C1125f.m6891l(media, i10) : C1125f.m6896q(media, i10);
        return i10 == 0 ? m6876t(context, id2, strM6891l, localPath, z10) : C12467a.m74744b(context, i10, id2, strM6891l);
    }

    /* renamed from: j */
    public static String m6866j() {
        return m6872p();
    }

    /* renamed from: k */
    public static String m6867k(Context context) {
        if (f5378a == null) {
            return null;
        }
        return f5378a + "/.photoShare/thumb/lcd/";
    }

    /* renamed from: l */
    public static String m6868l() {
        if (f5378a == null) {
            return null;
        }
        return f5378a + "/.photoShare/thumb/thumbFix/";
    }

    /* renamed from: m */
    public static String m6869m(Context context) {
        if (f5378a == null) {
            return null;
        }
        return f5378a + "/Pictures/hiddenAlbum/.tmp/";
    }

    /* renamed from: n */
    public static String m6870n(Context context) {
        if (f5378a == null) {
            return null;
        }
        return f5378a + "/.photoShare/thumb/thumb/";
    }

    /* renamed from: o */
    public static String m6871o(Context context) {
        return f5378a;
    }

    /* renamed from: p */
    public static String m6872p() {
        try {
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            if (externalStorageDirectory != null && externalStorageDirectory.getPath() != null && !externalStorageDirectory.getPath().isEmpty()) {
                String path = externalStorageDirectory.getPath();
                return C10278a.m63442h(path).isDirectory() ? path : "/storage/emulated/0";
            }
            return null;
        } catch (Exception e10) {
            C1120a.m6676e("FileHelper", "get storage path error: " + e10.toString());
            return "/storage/emulated/0";
        }
    }

    /* renamed from: q */
    public static List<String> m6873q(Context context) {
        StorageManager storageManager = (StorageManager) context.getSystemService("storage");
        ArrayList arrayList = new ArrayList();
        StorageVolume[] storageVolumeArrM7483f = C1249b.m7483f(storageManager);
        if (storageVolumeArrM7483f == null) {
            return null;
        }
        for (StorageVolume storageVolume : storageVolumeArrM7483f) {
            if (storageVolume == null) {
                C1120a.m6676e("FileHelper", "storageVolume is null");
            } else if (storageVolume.getUuid() == null) {
                C1120a.m6676e("FileHelper", "uuid is null");
            } else {
                File fileM7482e = C1249b.m7482e(storageVolume);
                Object objM7478a = C1249b.m7478a(storageManager, storageVolume.getUuid());
                Object objM7479b = C1249b.m7479b(objM7478a);
                if (fileM7482e == null || fileM7482e.getPath() == null || fileM7482e.getPath().isEmpty() || objM7478a == null || objM7479b == null) {
                    C1120a.m6678w("FileHelper", "pathFile invalid, ignore");
                } else {
                    C1120a.m6675d("FileHelper", "getMversionExterRootPath exterPath: " + fileM7482e.getPath() + ", isPrimary: " + storageVolume.isPrimary() + ", isRemovable: " + storageVolume.isRemovable() + ", Uuid: " + storageVolume.getUuid());
                    if (!storageVolume.isPrimary() && C1249b.m7485h(objM7479b) && m6878v(context, fileM7482e.getPath())) {
                        arrayList.add(fileM7482e.getPath());
                    }
                }
            }
        }
        if (arrayList.size() < 1) {
            return null;
        }
        return arrayList;
    }

    /* renamed from: r */
    public static String m6874r(Context context, String str, long j10) {
        String strM74743a = C12467a.m74743a(context);
        String externalRootPath = m6860d() ? C1136q.c.m7118a(context).getExternalRootPath() : f5379b.get(0);
        String path = Environment.getExternalStorageDirectory().getPath();
        if (str == null) {
            C1120a.m6678w("FileHelper", "getDownloadRootPath albumId is null");
            return strM74743a;
        }
        if (m6861e(path)) {
            return strM74743a;
        }
        try {
            if (C1122c.m6698G0(path) >= j10 + 52428800) {
                return path;
            }
            if (path.equals(strM74743a)) {
                if (TextUtils.isEmpty(externalRootPath)) {
                    return strM74743a;
                }
                C1120a.m6678w("FileHelper", "return extPath");
                return externalRootPath;
            }
            if (!path.equals(externalRootPath)) {
                return path;
            }
            C1120a.m6678w("FileHelper", "return filePath");
            return strM74743a;
        } catch (Exception unused) {
            C1120a.m6675d("FileHelper", "getAvailSize exception");
            return f5378a;
        }
    }

    /* renamed from: s */
    public static String m6875s(Context context, String str, String str2, long j10, String str3) {
        String strM6871o = m6871o(context);
        if (TextUtils.isEmpty(strM6871o)) {
            C1120a.m6676e("FileHelper", "FileHelper getInternalStoragePath is null");
            return null;
        }
        if (!str.startsWith("default-album-")) {
            return strM6871o + "/PhotoShareDownload/" + str3 + "/" + str2;
        }
        String strM6862f = m6862f(context, str, j10);
        if (strM6862f == null) {
            C1120a.m6676e("FileHelper", "getOrgSavePath rootPath is null");
            return null;
        }
        return strM6862f + str3 + "/" + str2;
    }

    /* renamed from: t */
    public static String m6876t(Context context, String str, String str2, String str3, boolean z10) {
        String strM6871o = z10 ? m6871o(context) : m6863g();
        if (TextUtils.isEmpty(strM6871o)) {
            C1120a.m6676e("FileHelper", "FileHelper getInternalStoragePath is null");
            return null;
        }
        if (!str.startsWith("default-album-")) {
            return strM6871o + "/PhotoShareDownload/" + str3 + "/" + str2;
        }
        String strM6863g = z10 ? f5378a : m6863g();
        if (TextUtils.isEmpty(strM6863g)) {
            C1120a.m6676e("FileHelper", "getOrgSavePath rootPath is null");
            return null;
        }
        return strM6863g + str3 + "/" + str2;
    }

    /* renamed from: u */
    public static void m6877u(Context context) {
        m6879w(context);
    }

    /* renamed from: v */
    public static boolean m6878v(Context context, String str) {
        if (str == null || "".equals(str)) {
            return false;
        }
        return "mounted".equals(C1249b.m7484g((StorageManager) context.getSystemService("storage"), str));
    }

    /* renamed from: w */
    public static void m6879w(Context context) {
        f5378a = m6858b(context);
        f5379b = m6857a(context);
        f5380c = m6859c(context);
    }
}
