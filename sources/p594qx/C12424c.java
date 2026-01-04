package p594qx;

import com.huawei.phoneservice.feedbackcommon.network.FeedbackWebConstants;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.DosFileAttributeView;
import java.nio.file.attribute.DosFileAttributes;
import java.nio.file.attribute.PosixFileAttributeView;
import java.nio.file.attribute.PosixFilePermission;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import mx.C11557q;
import p376ix.C10631a;
import p537ox.C12056a;

/* renamed from: qx.c */
/* loaded from: classes9.dex */
public class C12424c {

    /* renamed from: a */
    public static final byte[] f57261a = {0, 0, -92, -127};

    /* renamed from: b */
    public static final byte[] f57262b = {0, 0, -19, 65};

    /* renamed from: qx.c$a */
    public class a implements FilenameFilter {

        /* renamed from: a */
        public final /* synthetic */ String f57263a;

        public a(String str) {
            this.f57263a = str;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.startsWith(this.f57263a + ".");
        }
    }

    /* renamed from: a */
    public static void m74573a(File file) throws C10631a {
        if (file.exists()) {
            return;
        }
        throw new C10631a("File does not exist: " + file);
    }

    /* renamed from: b */
    public static void m74574b(List<File> list, C11557q.a aVar) throws C10631a {
        for (File file : list) {
            if (!m74590r(file)) {
                m74573a(file);
            } else if (aVar.equals(C11557q.a.INCLUDE_LINK_AND_LINKED_FILE) || aVar.equals(C11557q.a.INCLUDE_LINKED_FILE_ONLY)) {
                m74575c(file);
            }
        }
    }

    /* renamed from: c */
    public static void m74575c(File file) throws C10631a {
        if (file.exists()) {
            return;
        }
        throw new C10631a("Symlink target '" + m74594v(file) + "' does not exist for link '" + file + "'");
    }

    /* renamed from: d */
    public static void m74576d(RandomAccessFile randomAccessFile, OutputStream outputStream, long j10, long j11, C12056a c12056a, int i10) throws InterruptedException, IOException {
        long j12 = 0;
        if (j10 < 0 || j11 < 0 || j10 > j11) {
            throw new C10631a("invalid offsets");
        }
        if (j10 == j11) {
            return;
        }
        try {
            randomAccessFile.seek(j10);
            long j13 = j11 - j10;
            byte[] bArr = j13 < ((long) i10) ? new byte[(int) j13] : new byte[i10];
            while (true) {
                int i11 = randomAccessFile.read(bArr);
                if (i11 == -1) {
                    return;
                }
                outputStream.write(bArr, 0, i11);
                long j14 = i11;
                c12056a.m72204l(j14);
                if (c12056a.m72197e()) {
                    c12056a.m72201i(C12056a.a.CANCELLED);
                    return;
                }
                j12 += j14;
                if (j12 == j13) {
                    return;
                }
                if (bArr.length + j12 > j13) {
                    bArr = new byte[(int) (j13 - j12)];
                }
            }
        } catch (IOException e10) {
            throw new C10631a(e10);
        }
    }

    /* renamed from: e */
    public static File[] m74577e(File file) {
        File[] fileArrListFiles = file.getParentFile().listFiles(new a(m74581i(file.getName())));
        if (fileArrListFiles == null) {
            return new File[0];
        }
        Arrays.sort(fileArrListFiles);
        return fileArrListFiles;
    }

    /* renamed from: f */
    public static byte[] m74578f(boolean z10) {
        byte[] bArr = new byte[4];
        if (m74591s() || m74588p()) {
            if (z10) {
                System.arraycopy(f57262b, 0, bArr, 0, 4);
            } else {
                System.arraycopy(f57261a, 0, bArr, 0, 4);
            }
        } else if (m74592t() && z10) {
            bArr[0] = C12422a.m74570b(bArr[0], 4);
        }
        return bArr;
    }

    /* renamed from: g */
    public static byte[] m74579g(File file) {
        if (file != null) {
            try {
                if (Files.isSymbolicLink(file.toPath()) || file.exists()) {
                    Path path = file.toPath();
                    if (m74592t()) {
                        return m74586n(path);
                    }
                    if (!m74588p() && !m74591s()) {
                        return new byte[4];
                    }
                    return m74584l(path);
                }
            } catch (NoSuchMethodError unused) {
                return new byte[4];
            }
        }
        return new byte[4];
    }

    /* renamed from: h */
    public static String m74580h(File file) {
        String name = file.getName();
        return !name.contains(".") ? "" : name.substring(name.lastIndexOf(".") + 1);
    }

    /* renamed from: i */
    public static String m74581i(String str) {
        int iLastIndexOf = str.lastIndexOf(".");
        return iLastIndexOf == -1 ? str : str.substring(0, iLastIndexOf);
    }

    /* renamed from: j */
    public static List<File> m74582j(File file, C11557q c11557q) throws C10631a {
        if (file == null) {
            throw new C10631a("input path is null, cannot read files in the directory");
        }
        ArrayList arrayList = new ArrayList();
        File[] fileArrListFiles = file.listFiles();
        if (file.isDirectory() && file.canRead() && fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                c11557q.m68998i();
                if (!file2.isHidden() || c11557q.m69007r()) {
                    arrayList.add(file2);
                    C11557q.a aVarM69003n = c11557q.m69003n();
                    boolean zM74590r = m74590r(file2);
                    if ((zM74590r && !C11557q.a.INCLUDE_LINK_ONLY.equals(aVarM69003n)) || (!zM74590r && file2.isDirectory())) {
                        arrayList.addAll(m74582j(file2, c11557q));
                    }
                }
            }
        }
        return arrayList;
    }

    /* renamed from: k */
    public static String m74583k(File file, String str) throws IOException {
        return C12427f.m74616f(str) ? str : m74590r(file) ? file.toPath().toRealPath(LinkOption.NOFOLLOW_LINKS).getFileName().toString() : file.getName();
    }

    /* renamed from: l */
    public static byte[] m74584l(Path path) {
        byte[] bArr = new byte[4];
        try {
            Set<PosixFilePermission> setPermissions = ((PosixFileAttributeView) Files.getFileAttributeView(path, PosixFileAttributeView.class, LinkOption.NOFOLLOW_LINKS)).readAttributes().permissions();
            boolean zIsSymbolicLink = Files.isSymbolicLink(path);
            if (zIsSymbolicLink) {
                byte bM74570b = C12422a.m74570b(bArr[3], 7);
                bArr[3] = bM74570b;
                bArr[3] = C12422a.m74571c(bM74570b, 6);
            } else {
                bArr[3] = m74595w(Files.isRegularFile(path, new LinkOption[0]), bArr[3], 7);
                bArr[3] = m74595w(Files.isDirectory(path, new LinkOption[0]), bArr[3], 6);
            }
            bArr[3] = m74595w(zIsSymbolicLink, bArr[3], 5);
            bArr[3] = m74595w(setPermissions.contains(PosixFilePermission.OWNER_READ), bArr[3], 0);
            bArr[2] = m74595w(setPermissions.contains(PosixFilePermission.OWNER_WRITE), bArr[2], 7);
            bArr[2] = m74595w(setPermissions.contains(PosixFilePermission.OWNER_EXECUTE), bArr[2], 6);
            bArr[2] = m74595w(setPermissions.contains(PosixFilePermission.GROUP_READ), bArr[2], 5);
            bArr[2] = m74595w(setPermissions.contains(PosixFilePermission.GROUP_WRITE), bArr[2], 4);
            bArr[2] = m74595w(setPermissions.contains(PosixFilePermission.GROUP_EXECUTE), bArr[2], 3);
            bArr[2] = m74595w(setPermissions.contains(PosixFilePermission.OTHERS_READ), bArr[2], 2);
            bArr[2] = m74595w(setPermissions.contains(PosixFilePermission.OTHERS_WRITE), bArr[2], 1);
            bArr[2] = m74595w(setPermissions.contains(PosixFilePermission.OTHERS_EXECUTE), bArr[2], 0);
        } catch (IOException unused) {
        }
        return bArr;
    }

    /* renamed from: m */
    public static String m74585m(File file, C11557q c11557q) throws IOException {
        String strM74583k;
        String strSubstring;
        try {
            String canonicalPath = file.getCanonicalPath();
            if (C12427f.m74616f(c11557q.m68994e())) {
                String canonicalPath2 = new File(c11557q.m68994e()).getCanonicalPath();
                String str = C12425d.f57264a;
                if (!canonicalPath2.endsWith(str)) {
                    canonicalPath2 = canonicalPath2 + str;
                }
                if (m74590r(file)) {
                    strSubstring = new File(file.getParentFile().getCanonicalFile().getPath() + File.separator + file.getCanonicalFile().getName()).getPath().substring(canonicalPath2.length());
                } else if (file.getCanonicalFile().getPath().startsWith(canonicalPath2)) {
                    strSubstring = canonicalPath.substring(canonicalPath2.length());
                } else {
                    strSubstring = file.getCanonicalFile().getParentFile().getName() + str + file.getCanonicalFile().getName();
                }
                if (strSubstring.startsWith(System.getProperty("file.separator"))) {
                    strSubstring = strSubstring.substring(1);
                }
                File file2 = new File(canonicalPath);
                if (file2.isDirectory()) {
                    strM74583k = strSubstring.replaceAll("\\\\", "/") + "/";
                } else {
                    strM74583k = strSubstring.substring(0, strSubstring.lastIndexOf(file2.getName())).replaceAll("\\\\", "/") + m74583k(file2, c11557q.m69000k());
                }
            } else {
                File file3 = new File(canonicalPath);
                strM74583k = m74583k(file3, c11557q.m69000k());
                if (file3.isDirectory()) {
                    strM74583k = strM74583k + "/";
                }
            }
            String strM69002m = c11557q.m69002m();
            if (C12427f.m74616f(strM69002m)) {
                if (!strM69002m.endsWith("\\") && !strM69002m.endsWith("/")) {
                    strM69002m = strM69002m + C12425d.f57264a;
                }
                strM69002m = strM69002m.replaceAll("\\\\", "/");
                strM74583k = strM69002m + strM74583k;
            }
            if (C12427f.m74616f(strM74583k)) {
                return strM74583k;
            }
            String str2 = "fileName to add to zip is empty or null. fileName: '" + strM74583k + "' DefaultFolderPath: '" + c11557q.m68994e() + "' FileNameInZip: " + c11557q.m69000k();
            if (m74590r(file)) {
                str2 = str2 + "isSymlink: true ";
            }
            if (C12427f.m74616f(strM69002m)) {
                str2 = "rootFolderNameInZip: '" + strM69002m + "' ";
            }
            throw new C10631a(str2);
        } catch (IOException e10) {
            throw new C10631a(e10);
        }
    }

    /* renamed from: n */
    public static byte[] m74586n(Path path) throws IOException {
        DosFileAttributeView dosFileAttributeView;
        byte[] bArr = new byte[4];
        try {
            dosFileAttributeView = (DosFileAttributeView) Files.getFileAttributeView(path, DosFileAttributeView.class, LinkOption.NOFOLLOW_LINKS);
        } catch (IOException unused) {
        }
        if (dosFileAttributeView == null) {
            return bArr;
        }
        DosFileAttributes attributes = dosFileAttributeView.readAttributes();
        bArr[0] = m74595w(attributes.isArchive(), m74595w(attributes.isDirectory(), m74595w(attributes.isSystem(), m74595w(attributes.isHidden(), m74595w(attributes.isReadOnly(), (byte) 0, 0), 1), 2), 4), 5);
        return bArr;
    }

    /* renamed from: o */
    public static String m74587o(String str) throws C10631a {
        if (!C12427f.m74616f(str)) {
            throw new C10631a("zip file name is empty or null, cannot determine zip file name");
        }
        if (str.contains(System.getProperty("file.separator"))) {
            str = str.substring(str.lastIndexOf(System.getProperty("file.separator")) + 1);
        }
        return str.endsWith(FeedbackWebConstants.SUFFIX) ? str.substring(0, str.lastIndexOf(".")) : str;
    }

    /* renamed from: p */
    public static boolean m74588p() {
        return System.getProperty("os.name").toLowerCase().contains("mac");
    }

    /* renamed from: q */
    public static boolean m74589q(File file) {
        return file.getName().endsWith(".zip.001");
    }

    /* renamed from: r */
    public static boolean m74590r(File file) {
        try {
            return Files.isSymbolicLink(file.toPath());
        } catch (Error | Exception unused) {
            return false;
        }
    }

    /* renamed from: s */
    public static boolean m74591s() {
        return System.getProperty("os.name").toLowerCase().contains("nux");
    }

    /* renamed from: t */
    public static boolean m74592t() {
        return System.getProperty("os.name").toLowerCase().contains("win");
    }

    /* renamed from: u */
    public static boolean m74593u(String str) {
        return str.endsWith("/") || str.endsWith("\\");
    }

    /* renamed from: v */
    public static String m74594v(File file) {
        try {
            return Files.readSymbolicLink(file.toPath()).toString();
        } catch (Error | Exception unused) {
            return "";
        }
    }

    /* renamed from: w */
    public static byte m74595w(boolean z10, byte b10, int i10) {
        return z10 ? C12422a.m74570b(b10, i10) : b10;
    }
}
