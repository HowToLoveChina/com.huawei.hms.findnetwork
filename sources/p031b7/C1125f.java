package p031b7;

import android.annotation.SuppressLint;
import android.media.ExifInterface;
import android.text.TextUtils;
import com.huawei.android.hicloud.album.service.logic.callable.CloudAlbumDownloadBabyHeadPicCallable;
import com.huawei.android.hicloud.drive.cloudphoto.model.Media;
import com.huawei.android.p069cg.p072vo.FileInfo;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.MimeType;
import com.huawei.uikit.hwadvancednumberpicker.utils.HwConstants;
import hk.C10278a;
import hk.C10279b;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;
import p015ak.C0224k0;

/* renamed from: b7.f */
/* loaded from: classes2.dex */
public class C1125f {

    /* renamed from: a */
    public static HashMap<String, Integer> f5381a = new HashMap<>();

    /* renamed from: b */
    public static final String[] f5382b;

    /* renamed from: c */
    public static final byte[] f5383c;

    /* renamed from: d */
    public static final int f5384d;

    static {
        m6880a("MP4", 4);
        m6880a("M4V", 4);
        m6880a("MPG", 4);
        m6880a("3GPP", 4);
        m6880a("3G2", 4);
        m6880a("MKV", 4);
        m6880a("WEBM", 4);
        m6880a("TS", 4);
        m6880a("AVI", 4);
        m6880a("FLV", 4);
        m6880a("F4V", 4);
        m6880a("JPG", 1);
        m6880a("JPEG", 1);
        m6880a("BMP", 1);
        m6880a("PNG", 5);
        m6880a("ICO", 1);
        m6880a("MPO", 1);
        f5382b = new String[]{"JPG", "JPEG", "PNG", "GIF", "BMP", "WBMP", "MP4", "3GP", "MOV", "WEBP", "M4V", "MPG", "3GPP", "FLV", "3G2", "MKV", "WEBM", "TS", "AVI", "F4V"};
        byte[] bytes = "#FYUSE".getBytes(Charset.forName(Constants.UTF_8));
        f5383c = bytes;
        f5384d = bytes.length;
    }

    /* renamed from: a */
    public static void m6880a(String str, int i10) {
        f5381a.put(str, Integer.valueOf(i10));
    }

    /* renamed from: b */
    public static int m6881b(String str) throws IOException {
        StringBuilder sb2;
        long length;
        RandomAccessFile randomAccessFileM63449o = null;
        try {
            try {
                randomAccessFileM63449o = C10278a.m63449o(str, "r");
                length = randomAccessFileM63449o.length();
            } catch (IOException e10) {
                C1120a.m6676e("FileUtil", "checkAllFocusImage error:" + e10.toString());
                if (randomAccessFileM63449o != null) {
                    try {
                        randomAccessFileM63449o.close();
                    } catch (IOException e11) {
                        e = e11;
                        sb2 = new StringBuilder();
                        sb2.append("checkAllFocusImage error:");
                        sb2.append(e.toString());
                        C1120a.m6676e("FileUtil", sb2.toString());
                        return 0;
                    }
                }
            }
            if (length < 7) {
                try {
                    randomAccessFileM63449o.close();
                } catch (IOException e12) {
                    C1120a.m6676e("FileUtil", "checkAllFocusImage error:" + e12.toString());
                }
                return -1;
            }
            randomAccessFileM63449o.seek(length - 7);
            byte[] bArr = new byte[7];
            if (randomAccessFileM63449o.read(bArr) != 7) {
                try {
                    randomAccessFileM63449o.close();
                } catch (IOException e13) {
                    C1120a.m6676e("FileUtil", "checkAllFocusImage error:" + e13.toString());
                }
                return -1;
            }
            if (Arrays.equals(bArr, "Refocus".getBytes(Charset.forName(Constants.UTF_8)))) {
                try {
                    randomAccessFileM63449o.close();
                    return 1;
                } catch (IOException e14) {
                    C1120a.m6676e("FileUtil", "checkAllFocusImage error:" + e14.toString());
                    return 1;
                }
            }
            if (length < 8) {
                try {
                    randomAccessFileM63449o.close();
                } catch (IOException e15) {
                    C1120a.m6676e("FileUtil", "checkAllFocusImage error:" + e15.toString());
                }
                return -1;
            }
            randomAccessFileM63449o.seek(length - 8);
            byte[] bArr2 = new byte[8];
            if (randomAccessFileM63449o.read(bArr2) != 8) {
                try {
                    randomAccessFileM63449o.close();
                } catch (IOException e16) {
                    C1120a.m6676e("FileUtil", "checkAllFocusImage error:" + e16.toString());
                }
                return -1;
            }
            if (Arrays.equals(bArr2, "DepthEn\u0000".getBytes(Charset.forName(Constants.UTF_8)))) {
                try {
                    randomAccessFileM63449o.close();
                    return 2;
                } catch (IOException e17) {
                    C1120a.m6676e("FileUtil", "checkAllFocusImage error:" + e17.toString());
                    return 2;
                }
            }
            try {
                randomAccessFileM63449o.close();
                return 0;
            } catch (IOException e18) {
                e = e18;
                sb2 = new StringBuilder();
                sb2.append("checkAllFocusImage error:");
                sb2.append(e.toString());
                C1120a.m6676e("FileUtil", sb2.toString());
                return 0;
            }
        } catch (Throwable th2) {
            if (randomAccessFileM63449o != null) {
                try {
                    randomAccessFileM63449o.close();
                } catch (IOException e19) {
                    C1120a.m6676e("FileUtil", "checkAllFocusImage error:" + e19.toString());
                }
            }
            throw th2;
        }
    }

    /* renamed from: c */
    public static String m6882c(String str) throws Throwable {
        String str2;
        String strM6732R1 = C1122c.m6732R1(str);
        RandomAccessFile randomAccessFile = null;
        str = null;
        str = null;
        str = null;
        str = null;
        str = null;
        String str3 = null;
        randomAccessFile = null;
        randomAccessFile = null;
        RandomAccessFile randomAccessFile2 = null;
        try {
            if (TextUtils.isEmpty(strM6732R1)) {
                return null;
            }
            try {
                RandomAccessFile randomAccessFileM63449o = C10278a.m63449o(strM6732R1, "r");
                try {
                    long length = randomAccessFileM63449o.length();
                    int i10 = f5384d;
                    randomAccessFileM63449o.seek((length - i10) - 4);
                    byte[] bArr = new byte[i10];
                    int iM6900u = m6900u(new byte[4], 0, 4);
                    if (randomAccessFileM63449o.read(bArr) == i10 && Arrays.equals(bArr, f5383c)) {
                        C1120a.m6675d("FileUtil", "checkFuseFileData tagID length:" + iM6900u);
                        if (iM6900u > 0) {
                            byte[] bArr2 = new byte[iM6900u];
                            randomAccessFileM63449o.seek(((length - i10) - 4) - iM6900u);
                            C1120a.m6675d("FileUtil", "size: " + randomAccessFileM63449o.read(bArr2));
                            str3 = new String(bArr2, Constants.UTF_8);
                        }
                        C1120a.m6675d("FileUtil", "checkFuseFileData tagId: " + str3 + ", length: " + iM6900u);
                    }
                    m6884e(randomAccessFileM63449o);
                    return str3;
                } catch (FileNotFoundException unused) {
                    String str4 = str3;
                    randomAccessFile2 = randomAccessFileM63449o;
                    str2 = str4;
                    C1120a.m6676e("FileUtil", "checkFuseFileData FileNotFoundException error");
                    m6884e(randomAccessFile2);
                    return str2;
                } catch (IOException e10) {
                    e = e10;
                    String str5 = str3;
                    randomAccessFile2 = randomAccessFileM63449o;
                    str2 = str5;
                    C1120a.m6676e("FileUtil", "checkFuseFileData IOException,error message:" + e.getMessage());
                    m6884e(randomAccessFile2);
                    return str2;
                } catch (Exception e11) {
                    e = e11;
                    String str6 = str3;
                    randomAccessFile2 = randomAccessFileM63449o;
                    str2 = str6;
                    C1120a.m6676e("FileUtil", "checkFuseFileData Exception,error message:" + e.getMessage());
                    m6884e(randomAccessFile2);
                    return str2;
                } catch (Throwable th2) {
                    th = th2;
                    randomAccessFile = randomAccessFileM63449o;
                    m6884e(randomAccessFile);
                    throw th;
                }
            } catch (FileNotFoundException unused2) {
                str2 = null;
            } catch (IOException e12) {
                e = e12;
                str2 = null;
            } catch (Exception e13) {
                e = e13;
                str2 = null;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* renamed from: d */
    public static int m6883d(File file) throws Throwable {
        StringBuilder sb2;
        int iM6894o = 1;
        RandomAccessFile randomAccessFile = null;
        String str = null;
        randomAccessFile = null;
        try {
            try {
                RandomAccessFile randomAccessFileM63448n = C10278a.m63448n(file, "r");
                try {
                    if (randomAccessFileM63448n.length() >= 20) {
                        randomAccessFileM63448n.seek(randomAccessFileM63448n.length() - 20);
                        byte[] bArr = new byte[20];
                        if (randomAccessFileM63448n.read(bArr) < 0) {
                            try {
                                randomAccessFileM63448n.close();
                            } catch (IOException e10) {
                                C1120a.m6676e("FileUtil", "close exception: " + e10.toString());
                            }
                            return 1;
                        }
                        str = new String(bArr, Charset.forName(Constants.UTF_8));
                    }
                    iM6894o = (str == null || !str.startsWith("HWVOICE_")) ? (str == null || !str.startsWith("RECTIFY_")) ? (str == null || !str.startsWith("LIVE_")) ? (str == null || !str.endsWith("H W 3 D ")) ? m6894o(m6881b(C10279b.m63452a(file))) : 11 : 9 : 8 : 2;
                } catch (IOException e11) {
                    e = e11;
                    randomAccessFile = randomAccessFileM63448n;
                    C1120a.m6676e("FileUtil", "checkType IOException:" + e.toString());
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (IOException e12) {
                            e = e12;
                            sb2 = new StringBuilder();
                            sb2.append("close exception: ");
                            sb2.append(e.toString());
                            C1120a.m6676e("FileUtil", sb2.toString());
                            return iM6894o;
                        }
                    }
                    return iM6894o;
                } catch (Throwable th2) {
                    th = th2;
                    randomAccessFile = randomAccessFileM63448n;
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (IOException e13) {
                            C1120a.m6676e("FileUtil", "close exception: " + e13.toString());
                        }
                    }
                    throw th;
                }
                try {
                    randomAccessFileM63448n.close();
                } catch (IOException e14) {
                    e = e14;
                    sb2 = new StringBuilder();
                    sb2.append("close exception: ");
                    sb2.append(e.toString());
                    C1120a.m6676e("FileUtil", sb2.toString());
                    return iM6894o;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (IOException e15) {
            e = e15;
        }
        return iM6894o;
    }

    /* renamed from: e */
    public static void m6884e(RandomAccessFile randomAccessFile) throws IOException {
        if (randomAccessFile == null) {
            return;
        }
        try {
            randomAccessFile.close();
        } catch (IOException e10) {
            C1120a.m6676e("FileUtil", "closeRandomAccessFile IOException,error message:" + e10.getMessage());
        }
    }

    /* renamed from: f */
    public static boolean m6885f(String str, String str2, boolean z10) throws Throwable {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2;
        FileOutputStream fileOutputStream3;
        File fileM63442h = C10278a.m63442h(str);
        if (!fileM63442h.exists()) {
            C1120a.m6676e("FileUtil", "srcFile not exist");
            return false;
        }
        if (!fileM63442h.isFile()) {
            C1120a.m6676e("FileUtil", "srcFile not file");
            return false;
        }
        File fileM63442h2 = C10278a.m63442h(str2);
        if (fileM63442h2.exists()) {
            if (z10) {
                C1120a.m6678w("FileUtil", "deleteResult is:" + C10278a.m63442h(str2).delete());
            }
        } else if (!fileM63442h2.getParentFile().exists() && !C10278a.m63437c(fileM63442h2).mkdirs()) {
            return false;
        }
        FileInputStream fileInputStream = null;
        fileOutputStreamM63445k = null;
        fileOutputStreamM63445k = null;
        FileOutputStream fileOutputStreamM63445k = null;
        FileInputStream fileInputStream2 = null;
        FileInputStream fileInputStream3 = null;
        try {
            FileInputStream fileInputStreamM63444j = C10278a.m63444j(fileM63442h);
            try {
                fileOutputStreamM63445k = C10278a.m63445k(fileM63442h2);
                byte[] bArr = new byte[1024];
                while (true) {
                    int i10 = fileInputStreamM63444j.read(bArr);
                    if (i10 != -1) {
                        fileOutputStreamM63445k.write(bArr, 0, i10);
                    } else {
                        try {
                            break;
                        } catch (IOException unused) {
                            C1120a.m6676e("FileUtil", "close stream exception");
                        }
                    }
                }
                fileInputStreamM63444j.close();
                if (fileOutputStreamM63445k == null) {
                    return true;
                }
                try {
                    fileOutputStreamM63445k.close();
                    return true;
                } catch (IOException unused2) {
                    C1120a.m6676e("FileUtil", "close stream exception");
                    return true;
                }
            } catch (FileNotFoundException unused3) {
                FileOutputStream fileOutputStream4 = fileOutputStreamM63445k;
                fileInputStream2 = fileInputStreamM63444j;
                fileOutputStream3 = fileOutputStream4;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException unused4) {
                        C1120a.m6676e("FileUtil", "close stream exception");
                    }
                }
                if (fileOutputStream3 != null) {
                    try {
                        fileOutputStream3.close();
                    } catch (IOException unused5) {
                        C1120a.m6676e("FileUtil", "close stream exception");
                    }
                }
                return false;
            } catch (IOException unused6) {
                FileOutputStream fileOutputStream5 = fileOutputStreamM63445k;
                fileInputStream3 = fileInputStreamM63444j;
                fileOutputStream2 = fileOutputStream5;
                if (fileInputStream3 != null) {
                    try {
                        fileInputStream3.close();
                    } catch (IOException unused7) {
                        C1120a.m6676e("FileUtil", "close stream exception");
                    }
                }
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException unused8) {
                        C1120a.m6676e("FileUtil", "close stream exception");
                    }
                }
                return false;
            } catch (Throwable th2) {
                th = th2;
                FileOutputStream fileOutputStream6 = fileOutputStreamM63445k;
                fileInputStream = fileInputStreamM63444j;
                fileOutputStream = fileOutputStream6;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException unused9) {
                        C1120a.m6676e("FileUtil", "close stream exception");
                    }
                }
                if (fileOutputStream == null) {
                    throw th;
                }
                try {
                    fileOutputStream.close();
                    throw th;
                } catch (IOException unused10) {
                    C1120a.m6676e("FileUtil", "close stream exception");
                    throw th;
                }
            }
        } catch (FileNotFoundException unused11) {
            fileOutputStream3 = null;
        } catch (IOException unused12) {
            fileOutputStream2 = null;
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
        }
    }

    /* renamed from: g */
    public static float[] m6886g(String str) {
        ExifInterface exifInterface;
        float[] fArr;
        float[] fArr2 = null;
        if (!C10278a.m63442h(str).exists()) {
            return null;
        }
        try {
            exifInterface = new ExifInterface(str);
            fArr = new float[2];
            try {
            } catch (IOException e10) {
                e = e10;
                fArr2 = fArr;
                C1120a.m6676e("FileUtil", "getCoordinateFloat IOException:" + e.toString());
            }
        } catch (IOException e11) {
            e = e11;
        }
        return exifInterface.getLatLong(fArr) ? fArr : fArr2;
    }

    /* renamed from: h */
    public static long m6887h(ExifInterface exifInterface) {
        String attribute;
        if (exifInterface == null || (attribute = exifInterface.getAttribute("DateTime")) == null) {
            return -1L;
        }
        try {
            ParsePosition parsePosition = new ParsePosition(0);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
            simpleDateFormat.setTimeZone(TimeZone.getDefault());
            Date date = simpleDateFormat.parse(attribute, parsePosition);
            if (date == null) {
                return -1L;
            }
            return date.getTime();
        } catch (IllegalArgumentException unused) {
            return -1L;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0063  */
    /* JADX WARN: Type inference failed for: r9v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* renamed from: i */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static long m6888i(java.lang.String r10) throws java.lang.Throwable {
        /*
            java.lang.String r3 = "_data = ?"
            java.lang.String[] r4 = new java.lang.String[]{r10}
            android.content.Context r0 = p015ak.C0213f.m1377a()
            java.lang.String r6 = "FileUtil"
            r7 = 0
            r9 = 0
            if (r0 == 0) goto L5e
            android.content.ContentResolver r0 = r0.getContentResolver()
            android.net.Uri r1 = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3c
            r2 = 0
            r5 = 0
            android.database.Cursor r0 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3c
            if (r0 == 0) goto L35
            boolean r1 = r0.moveToNext()     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L33
            if (r1 == 0) goto L35
            java.lang.String r1 = "datetaken"
            int r1 = r0.getColumnIndex(r1)     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L33
            long r1 = r0.getLong(r1)     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L33
            goto L36
        L30:
            r10 = move-exception
            r9 = r0
            goto L5a
        L33:
            r1 = move-exception
            goto L3e
        L35:
            r1 = r7
        L36:
            p031b7.C1122c.m6832t(r0)
            goto L5f
        L3a:
            r10 = move-exception
            goto L5a
        L3c:
            r1 = move-exception
            r0 = r9
        L3e:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L30
            r2.<init>()     // Catch: java.lang.Throwable -> L30
            java.lang.String r3 = "queryMedia Exception:"
            r2.append(r3)     // Catch: java.lang.Throwable -> L30
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L30
            r2.append(r1)     // Catch: java.lang.Throwable -> L30
            java.lang.String r1 = r2.toString()     // Catch: java.lang.Throwable -> L30
            p031b7.C1120a.m6676e(r6, r1)     // Catch: java.lang.Throwable -> L30
            p031b7.C1122c.m6832t(r0)
            goto L5e
        L5a:
            p031b7.C1122c.m6832t(r9)
            throw r10
        L5e:
            r1 = r7
        L5f:
            int r0 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r0 != 0) goto Le5
            java.lang.String r0 = p015ak.C0224k0.m1559n(r10)
            java.lang.String r3 = "image/jpeg"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto Lbf
            android.media.ExifInterface r0 = new android.media.ExifInterface     // Catch: java.io.IOException -> L76
            r0.<init>(r10)     // Catch: java.io.IOException -> L76
            r9 = r0
            goto L8f
        L76:
            r0 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "getFileCreateTime error:"
            r3.append(r4)
            java.lang.String r0 = r0.toString()
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            p031b7.C1120a.m6676e(r6, r0)
        L8f:
            if (r9 == 0) goto L95
            long r1 = p015ak.C0224k0.m1557l(r9)
        L95:
            r3 = -1
            int r0 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r0 == 0) goto L9f
            int r0 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r0 != 0) goto Ld1
        L9f:
            long r0 = m6887h(r9)
            java.io.File r2 = hk.C10278a.m63442h(r10)
            boolean r2 = r2.exists()
            if (r2 == 0) goto Lb5
            java.io.File r10 = hk.C10278a.m63442h(r10)
            long r3 = r10.lastModified()
        Lb5:
            boolean r10 = m6899t(r0, r3)
            if (r10 == 0) goto Lbd
            r1 = r3
            goto Ld1
        Lbd:
            r1 = r0
            goto Ld1
        Lbf:
            java.io.File r0 = hk.C10278a.m63442h(r10)
            boolean r0 = r0.exists()
            if (r0 == 0) goto Ld1
            java.io.File r10 = hk.C10278a.m63442h(r10)
            long r1 = r10.lastModified()
        Ld1:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r0 = "getFileCreateTime from exif: "
            r10.append(r0)
            r10.append(r1)
            java.lang.String r10 = r10.toString()
            p031b7.C1120a.m6677i(r6, r10)
        Le5:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p031b7.C1125f.m6888i(java.lang.String):long");
    }

    /* renamed from: j */
    public static String m6889j(String str) {
        ExifInterface exifInterface;
        int attributeInt;
        if (!MimeType.JPEG.equals(C0224k0.m1559n(str))) {
            return null;
        }
        try {
            exifInterface = new ExifInterface(str);
        } catch (IOException e10) {
            C1120a.m6676e("FileUtil", "getFileCreateTime error:" + e10.toString());
            exifInterface = null;
        }
        if (exifInterface == null || (attributeInt = exifInterface.getAttributeInt("Orientation", 0)) == 0) {
            return null;
        }
        return String.valueOf(attributeInt);
    }

    /* renamed from: k */
    public static String m6890k(FileInfo fileInfo, int i10) {
        if (fileInfo == null) {
            C1120a.m6676e("FileUtil", "getFileSaveName error, fileInfo is null");
            return null;
        }
        C1120a.m6675d("FileUtil", "getThumSaveName fileInfo: " + fileInfo.printInfo());
        String uniqueId = fileInfo.getUniqueId();
        if (TextUtils.isEmpty(uniqueId)) {
            C1120a.m6676e("FileUtil", "getFileSaveName error, uniqueId is null");
            return null;
        }
        String fileName = fileInfo.getFileName();
        if (i10 == 0) {
            return fileName;
        }
        if (fileInfo.getFileType() == 4) {
            return uniqueId + CloudAlbumDownloadBabyHeadPicCallable.DEFAULT_HEAD_EXT;
        }
        int iLastIndexOf = fileName.lastIndexOf(".");
        if (iLastIndexOf <= 0) {
            return fileName;
        }
        return uniqueId + fileName.substring(iLastIndexOf);
    }

    /* renamed from: l */
    public static String m6891l(Media media, int i10) {
        if (media == null) {
            C1120a.m6676e("FileUtil", "getFileSaveName error, fileInfo is null");
            return null;
        }
        String id2 = media.getId();
        if (TextUtils.isEmpty(id2)) {
            C1120a.m6676e("FileUtil", "getFileSaveName error, uniqueId is null");
            return null;
        }
        String fileName = media.getFileName();
        if (i10 == 0) {
            return fileName;
        }
        return id2 + CloudAlbumDownloadBabyHeadPicCallable.DEFAULT_HEAD_EXT;
    }

    /* renamed from: m */
    public static int m6892m(String str) {
        if (str == null) {
            C1120a.m6676e("FileUtil", "getFileType sourcePath is null");
            return -1;
        }
        if (C10278a.m63442h(str).exists()) {
            return m6893n(str);
        }
        return -1;
    }

    @SuppressLint({"DefaultLocale"})
    /* renamed from: n */
    public static int m6893n(String str) throws Throwable {
        int iLastIndexOf = str.lastIndexOf(".");
        if (iLastIndexOf < 0) {
            return -1;
        }
        Integer numValueOf = f5381a.get(str.substring(iLastIndexOf + 1).toUpperCase(Locale.US));
        String strM1559n = C0224k0.m1559n(str);
        int iM1554i = C0224k0.m1554i(strM1559n);
        if (!C0224k0.m1569x(iM1554i)) {
            if (C0224k0.m1533C(iM1554i)) {
                return 4;
            }
            if (numValueOf == null) {
                return -1;
            }
            return numValueOf.intValue();
        }
        if (C0224k0.f837e == iM1554i) {
            return 5;
        }
        if (!MimeType.JPEG.equals(strM1559n)) {
            return 1;
        }
        File fileM63442h = C10278a.m63442h(str);
        if (fileM63442h.exists()) {
            String strM6882c = m6882c(str);
            if (strM6882c != null && strM6882c.length() > 0) {
                return 7;
            }
            numValueOf = Integer.valueOf(m6883d(fileM63442h));
        }
        return numValueOf.intValue();
    }

    /* renamed from: o */
    public static int m6894o(int i10) {
        if (i10 == 1) {
            return 3;
        }
        if (i10 == 2) {
            return 6;
        }
        return i10 == -1 ? -1 : 1;
    }

    /* renamed from: p */
    public static String m6895p(FileInfo fileInfo, int i10) {
        if (fileInfo == null) {
            return null;
        }
        String fileName = fileInfo.getFileName();
        return (i10 == 0 || -1 == fileInfo.getFileType() || fileInfo.getFileType() == 0 || 4 != fileInfo.getFileType()) ? fileName : m6897r(fileInfo);
    }

    /* renamed from: q */
    public static String m6896q(Media media, int i10) {
        if (media == null) {
            return null;
        }
        String fileName = media.getFileName();
        return (i10 == 0 || -1 == media.getFileType().intValue() || media.getFileType().intValue() == 0 || 4 != media.getFileType().intValue()) ? fileName : m6898s(media);
    }

    /* renamed from: r */
    public static String m6897r(FileInfo fileInfo) {
        if (fileInfo == null) {
            return null;
        }
        String fileName = fileInfo.getFileName();
        if (TextUtils.isEmpty(fileName)) {
            return null;
        }
        int iLastIndexOf = fileName.lastIndexOf(".");
        if (TextUtils.isEmpty(fileInfo.getShareId())) {
            return m6890k(fileInfo, 2);
        }
        if (iLastIndexOf > 0) {
            return fileName.substring(0, iLastIndexOf) + "_thumb.jpg";
        }
        return fileName + "_thumb.jpg";
    }

    /* renamed from: s */
    public static String m6898s(Media media) {
        if (media == null) {
            return null;
        }
        String fileName = media.getFileName();
        if (TextUtils.isEmpty(fileName)) {
            return null;
        }
        int iLastIndexOf = fileName.lastIndexOf(".");
        if (TextUtils.isEmpty(media.getAlbumId())) {
            return m6891l(media, 2);
        }
        if (iLastIndexOf > 0) {
            return fileName.substring(0, iLastIndexOf) + "_thumb.jpg";
        }
        return fileName + "_thumb.jpg";
    }

    /* renamed from: t */
    public static boolean m6899t(long j10, long j11) {
        return j10 == -1 || Math.abs((j11 * 1000) - j10) < 86400000;
    }

    /* renamed from: u */
    public static int m6900u(byte[] bArr, int i10, int i11) {
        int i12 = 0;
        for (int i13 = 0; i13 < i11; i13++) {
            int i14 = (i11 - 1) - i13;
            i12 += (bArr[i14 + i10] & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA) << (i14 * 8);
        }
        return i12;
    }
}
