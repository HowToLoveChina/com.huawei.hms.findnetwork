package com.huawei.hms.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.text.TextUtils;
import android.util.AndroidException;
import android.util.Base64;
import com.google.flatbuffers.reflection.BaseType;
import com.huawei.hms.support.log.HMSLog;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* loaded from: classes8.dex */
public class ReadApkFileUtil {
    public static final String EMUI10_PK = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAx4nUogUyMCmzHhaEb420yvpw9zBs+ETzE9Qm77bGxl1Iml9JEkBkNTsUWOstLgUBajNhV+BAMVBHKMEdzoQbL5kIHkTgUVM65yewd+5+BhrcB9OQ3LHp+0BN6aLKZh71T4WvsvHFhfhQpShuGWkRkSaVGLFTHxX70kpWLzeZ3RtqiEUNIufPR2SFCH6EmecJ+HdkmBOh603IblCpGxwSWse0fDI98wZBEmV88RFaiYEgyiezLlWvXzqIj6I/xuyd5nGAegjH2y3cmoDE6CubecoB1jf4KdgACXgdiQ4Oc63MfLGTor3l6RCqeUk4APAMtyhK83jc72W1sdXMd/sj2wIDAQAB";
    public static final String EMUI11_PK = "MIIBojANBgkqhkiG9w0BAQEFAAOCAY8AMIIBigKCAYEAqq2eRTMYr2JHLtvuZzfgPrgU8oatD4Rar9fOD7E00es2VhtB3vTyaT2BvYPUPA/nbkHRPak3EZX77CfWj9tzLgSHJE8XLk9C+2ESkdrxCDA6z7I8X+cBDnA05OlCJeZFjnUbjYB8SP8M3BttdrvqtVPxTkEJhchC7UXnMLaJ3kQ3ZPjN7ubjYzO4rv7EtEpqr2bX+qjnSLIZZuUXraxqfdBuhGDIYq62dNsqiyrhX1mfvA3+43N4ZIs3BdfSYII8BNFmFxf+gyf1aoq386R2kAjHcrfOOhjAbZh+R1OAGLWPCqi3E9nB8EsZkeoTW/oIP6pJvgL3bnxq+1viT2dmZyipMgcx/3N6FJqkd67j/sPMtPlHJuq8/s0silzs13jAw1WBV6tWHFkLGpkWGs8jp50wQtndtY8cCPl2XPGmdPN72agH+zsHuKqr/HOB2TuzzaO8rKlGIDQlzZcCSHB28nnvOyBVN9xzLkbYiLnHfd6bTwzNPeqjWrTnPwKyH3BPAgMBAAE=";
    public static final String KEY_SIGNATURE = "Signature:";
    public static final String KEY_SIGNATURE2 = "Signature2:";
    public static final String KEY_SIGNATURE3 = "Signature3:";

    /* renamed from: a */
    private static final String f30202a = "ReadApkFileUtil";

    /* renamed from: c */
    private static String f30204c;

    /* renamed from: d */
    private static String f30205d;

    /* renamed from: e */
    private static String f30206e;

    /* renamed from: b */
    private static final Pattern f30203b = Pattern.compile("\\s*|\t|\r|\n");

    /* renamed from: f */
    private static String f30207f = null;

    /* renamed from: g */
    private static String f30208g = null;

    /* renamed from: a */
    private static byte[] m37075a(ZipFile zipFile) {
        return m37076a(zipFile, "META-INF/MANIFEST.MF");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.io.ByteArrayInputStream, java.io.InputStream] */
    @TargetApi(19)
    /* renamed from: b */
    private static void m37077b(byte[] bArr) throws Throwable {
        Throwable th2;
        BufferedReader bufferedReader;
        ?? byteArrayInputStream;
        ?? r22;
        BufferedReader bufferedReader2;
        InputStream inputStream;
        if (bArr == null) {
            HMSLog.m36986e(f30202a, "manifest is null！");
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        BufferedReader bufferedReader3 = null;
        f30204c = null;
        f30205d = null;
        f30206e = null;
        try {
            byteArrayInputStream = new ByteArrayInputStream(bArr);
        } catch (Exception unused) {
            byteArrayInputStream = 0;
        } catch (Throwable th3) {
            th2 = th3;
            bufferedReader = null;
            bufferedReader2 = bufferedReader3;
            bufferedReader3 = bufferedReader;
            r22 = bufferedReader2;
            IOUtils.closeQuietly((InputStream) r22);
            IOUtils.closeQuietly((Reader) bufferedReader3);
            throw th2;
        }
        try {
            bufferedReader = new BufferedReader(new InputStreamReader((InputStream) byteArrayInputStream, StandardCharsets.UTF_8));
            try {
                String strM37067a = m37067a(bufferedReader);
                while (strM37067a != null) {
                    if (strM37067a.length() != 0) {
                        if (strM37067a.startsWith("ApkHash:")) {
                            f30207f = m37068a(strM37067a.substring(strM37067a.indexOf(":") + 1));
                        }
                        if (strM37067a.startsWith(KEY_SIGNATURE)) {
                            f30204c = m37068a(strM37067a.substring(strM37067a.indexOf(":") + 1));
                            strM37067a = m37067a(bufferedReader);
                        } else if (strM37067a.startsWith(KEY_SIGNATURE2)) {
                            f30205d = m37068a(strM37067a.substring(strM37067a.indexOf(":") + 1));
                            strM37067a = m37067a(bufferedReader);
                        } else if (strM37067a.startsWith(KEY_SIGNATURE3)) {
                            f30206e = m37068a(strM37067a.substring(strM37067a.indexOf(":") + 1));
                            strM37067a = m37067a(bufferedReader);
                        } else {
                            stringBuffer.append(strM37067a);
                            stringBuffer.append("\r\n");
                        }
                    }
                    strM37067a = m37067a(bufferedReader);
                }
                f30208g = stringBuffer.toString();
                inputStream = byteArrayInputStream;
            } catch (Exception unused2) {
                bufferedReader3 = bufferedReader;
                try {
                    HMSLog.m36986e(f30202a, "loadApkCert Exception!");
                    bufferedReader = bufferedReader3;
                    inputStream = byteArrayInputStream;
                    IOUtils.closeQuietly(inputStream);
                    IOUtils.closeQuietly((Reader) bufferedReader);
                } catch (Throwable th4) {
                    th2 = th4;
                    bufferedReader = bufferedReader3;
                    bufferedReader3 = byteArrayInputStream;
                    bufferedReader2 = bufferedReader3;
                    bufferedReader3 = bufferedReader;
                    r22 = bufferedReader2;
                    IOUtils.closeQuietly((InputStream) r22);
                    IOUtils.closeQuietly((Reader) bufferedReader3);
                    throw th2;
                }
            } catch (Throwable th5) {
                th2 = th5;
                bufferedReader2 = byteArrayInputStream;
                bufferedReader3 = bufferedReader;
                r22 = bufferedReader2;
                IOUtils.closeQuietly((InputStream) r22);
                IOUtils.closeQuietly((Reader) bufferedReader3);
                throw th2;
            }
        } catch (Exception unused3) {
        } catch (Throwable th6) {
            th2 = th6;
            r22 = byteArrayInputStream;
            IOUtils.closeQuietly((InputStream) r22);
            IOUtils.closeQuietly((Reader) bufferedReader3);
            throw th2;
        }
        IOUtils.closeQuietly(inputStream);
        IOUtils.closeQuietly((Reader) bufferedReader);
    }

    public static String bytesToString(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        char[] cArr2 = new char[bArr.length * 2];
        for (int i10 = 0; i10 < bArr.length; i10++) {
            byte b10 = bArr[i10];
            int i11 = i10 * 2;
            cArr2[i11] = cArr[(b10 & 255) >>> 4];
            cArr2[i11 + 1] = cArr[b10 & BaseType.Obj];
        }
        return String.valueOf(cArr2);
    }

    /* renamed from: c */
    private static boolean m37080c() {
        try {
        } catch (Exception e10) {
            HMSLog.m36988i(f30202a, "verifyMDMSignatureV3 MDM verify Exception!:" + e10.getMessage());
        }
        if (m37072a(Base64.decode(EMUI11_PK, 0), m37073a(f30208g, "SHA-384"), m37079b(f30206e), "SHA384withRSA")) {
            HMSLog.m36988i(f30202a, "verifyMDMSignatureV3 verify successful!");
            return true;
        }
        HMSLog.m36988i(f30202a, "verifyMDMSignatureV3 verify failure!");
        return false;
    }

    public static boolean checkSignature() {
        if (f30206e != null) {
            return m37080c();
        }
        if (f30205d != null) {
            return m37078b();
        }
        if (f30204c != null) {
            return m37070a();
        }
        return false;
    }

    public static String getHmsPath(Context context) {
        try {
            return context.getPackageManager().getApplicationInfo("com.huawei.hwid", 128).sourceDir;
        } catch (AndroidException | RuntimeException unused) {
            HMSLog.m36986e(f30202a, "HMS is not found!");
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @TargetApi(19)
    public static boolean isCertFound(String str) throws Throwable {
        ZipFile zipFile;
        boolean z10 = false;
        ZipFile zipFile2 = null;
        ZipFile zipFile3 = null;
        ZipFile zipFile4 = null;
        try {
            try {
                zipFile = new ZipFile(str);
                try {
                    boolean z11 = zipFile.getEntry("META-INF/HUAWEI.CER") != null;
                    if (z11) {
                        m37077b(m37076a(zipFile, "META-INF/HUAWEI.CER"));
                    }
                    try {
                        zipFile.close();
                    } catch (IOException e10) {
                        String str2 = f30202a;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("zipFile.close Exception!");
                        sb2.append(e10.getMessage());
                        HMSLog.m36986e(str2, sb2.toString());
                        zipFile3 = sb2;
                    }
                    z10 = z11;
                    zipFile2 = zipFile3;
                } catch (Exception e11) {
                    e = e11;
                    zipFile4 = zipFile;
                    HMSLog.m36986e(f30202a, "isCertFound Exception!" + e.getMessage());
                    zipFile2 = zipFile4;
                    if (zipFile4 != null) {
                        try {
                            zipFile4.close();
                            zipFile2 = zipFile4;
                        } catch (IOException e12) {
                            String str3 = f30202a;
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("zipFile.close Exception!");
                            sb3.append(e12.getMessage());
                            HMSLog.m36986e(str3, sb3.toString());
                            zipFile2 = sb3;
                        }
                    }
                    return z10;
                } catch (Throwable th2) {
                    th = th2;
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                        } catch (IOException e13) {
                            HMSLog.m36986e(f30202a, "zipFile.close Exception!" + e13.getMessage());
                        }
                    }
                    throw th;
                }
            } catch (Exception e14) {
                e = e14;
            }
            return z10;
        } catch (Throwable th3) {
            th = th3;
            zipFile = zipFile2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.util.zip.ZipFile] */
    /* JADX WARN: Type inference failed for: r2v8 */
    public static boolean verifyApkHash(String str) throws Throwable {
        ?? r22;
        String str2 = null;
        ZipFile zipFile = null;
        try {
            try {
                ZipFile zipFile2 = new ZipFile(str);
                try {
                    byte[] bArrM37075a = m37075a(zipFile2);
                    ArrayList<String> arrayListM37069a = m37069a(bArrM37075a);
                    if (arrayListM37069a != null) {
                        bArrM37075a = m37074a(arrayListM37069a);
                    }
                    MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
                    messageDigest.update(bArrM37075a);
                    String strBytesToString = bytesToString(messageDigest.digest());
                    String str3 = f30207f;
                    if (str3 != null) {
                        if (str3.equals(strBytesToString)) {
                            try {
                                zipFile2.close();
                                return true;
                            } catch (Exception e10) {
                                HMSLog.m36988i(f30202a, "close stream Exception!" + e10.getMessage());
                                return true;
                            }
                        }
                    }
                    try {
                        zipFile2.close();
                        return false;
                    } catch (Exception e11) {
                        HMSLog.m36988i(f30202a, "close stream Exception!" + e11.getMessage());
                        return false;
                    }
                } catch (Exception e12) {
                    e = e12;
                    zipFile = zipFile2;
                    HMSLog.m36988i(f30202a, "verifyApkHash Exception!" + e.getMessage());
                    if (zipFile == null) {
                        return false;
                    }
                    try {
                        zipFile.close();
                        return false;
                    } catch (Exception e13) {
                        str2 = f30202a;
                        HMSLog.m36988i(str2, "close stream Exception!" + e13.getMessage());
                        return false;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    r22 = zipFile2;
                    if (r22 != null) {
                        try {
                            r22.close();
                        } catch (Exception e14) {
                            HMSLog.m36988i(f30202a, "close stream Exception!" + e14.getMessage());
                        }
                    }
                    throw th;
                }
            } catch (Exception e15) {
                e = e15;
            }
        } catch (Throwable th3) {
            th = th3;
            r22 = str2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    private static byte[] m37076a(ZipFile zipFile, String str) throws Throwable {
        Throwable th2;
        InputStream inputStream;
        Exception e10;
        Throwable th3;
        BufferedInputStream bufferedInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        ByteArrayOutputStream byteArrayOutputStream3;
        ByteArrayOutputStream byteArrayOutputStream4;
        byte[] bArr;
        BufferedOutputStream bufferedOutputStream;
        ZipEntry entry = zipFile.getEntry(str);
        OutputStream outputStream = null;
        if (entry == null) {
            return null;
        }
        try {
            inputStream = zipFile.getInputStream(entry);
            if (inputStream == null) {
                IOUtils.closeQuietly(inputStream);
                IOUtils.closeQuietly((InputStream) null);
                IOUtils.closeQuietly((OutputStream) null);
                IOUtils.closeQuietly((OutputStream) null);
                return null;
            }
            try {
                bufferedInputStream = new BufferedInputStream(inputStream);
                try {
                    bArr = new byte[4096];
                    byteArrayOutputStream = new ByteArrayOutputStream();
                } catch (Exception e11) {
                    e10 = e11;
                    byteArrayOutputStream = null;
                    byteArrayOutputStream2 = byteArrayOutputStream;
                    try {
                        HMSLog.m36988i(f30202a, "getManifestBytes Exception!" + e10.getMessage());
                        IOUtils.closeQuietly(inputStream);
                        IOUtils.closeQuietly((InputStream) bufferedInputStream);
                        IOUtils.closeQuietly((OutputStream) byteArrayOutputStream);
                        IOUtils.closeQuietly((OutputStream) byteArrayOutputStream2);
                        return null;
                    } catch (Throwable th4) {
                        th3 = th4;
                        byteArrayOutputStream4 = byteArrayOutputStream2;
                        bufferedInputStream = bufferedInputStream;
                        byteArrayOutputStream3 = byteArrayOutputStream4;
                        outputStream = byteArrayOutputStream3;
                        IOUtils.closeQuietly(inputStream);
                        IOUtils.closeQuietly((InputStream) bufferedInputStream);
                        IOUtils.closeQuietly((OutputStream) byteArrayOutputStream);
                        IOUtils.closeQuietly(outputStream);
                        throw th3;
                    }
                } catch (Throwable th5) {
                    th3 = th5;
                    byteArrayOutputStream = null;
                    byteArrayOutputStream4 = null;
                    bufferedInputStream = bufferedInputStream;
                    byteArrayOutputStream3 = byteArrayOutputStream4;
                    outputStream = byteArrayOutputStream3;
                    IOUtils.closeQuietly(inputStream);
                    IOUtils.closeQuietly((InputStream) bufferedInputStream);
                    IOUtils.closeQuietly((OutputStream) byteArrayOutputStream);
                    IOUtils.closeQuietly(outputStream);
                    throw th3;
                }
            } catch (Exception e12) {
                e10 = e12;
                bufferedInputStream = null;
                byteArrayOutputStream = null;
                byteArrayOutputStream2 = byteArrayOutputStream;
                HMSLog.m36988i(f30202a, "getManifestBytes Exception!" + e10.getMessage());
                IOUtils.closeQuietly(inputStream);
                IOUtils.closeQuietly((InputStream) bufferedInputStream);
                IOUtils.closeQuietly((OutputStream) byteArrayOutputStream);
                IOUtils.closeQuietly((OutputStream) byteArrayOutputStream2);
                return null;
            } catch (Throwable th6) {
                th2 = th6;
                th3 = th2;
                bufferedInputStream = null;
                byteArrayOutputStream = null;
                IOUtils.closeQuietly(inputStream);
                IOUtils.closeQuietly((InputStream) bufferedInputStream);
                IOUtils.closeQuietly((OutputStream) byteArrayOutputStream);
                IOUtils.closeQuietly(outputStream);
                throw th3;
            }
            try {
                bufferedOutputStream = new BufferedOutputStream(byteArrayOutputStream);
            } catch (Exception e13) {
                e10 = e13;
                byteArrayOutputStream2 = null;
            } catch (Throwable th7) {
                th3 = th7;
                IOUtils.closeQuietly(inputStream);
                IOUtils.closeQuietly((InputStream) bufferedInputStream);
                IOUtils.closeQuietly((OutputStream) byteArrayOutputStream);
                IOUtils.closeQuietly(outputStream);
                throw th3;
            }
            try {
                for (int i10 = bufferedInputStream.read(bArr, 0, 4096); i10 > 0; i10 = bufferedInputStream.read(bArr, 0, 4096)) {
                    bufferedOutputStream.write(bArr, 0, i10);
                }
                bufferedOutputStream.flush();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                IOUtils.closeQuietly(inputStream);
                IOUtils.closeQuietly((InputStream) bufferedInputStream);
                IOUtils.closeQuietly((OutputStream) byteArrayOutputStream);
                IOUtils.closeQuietly((OutputStream) bufferedOutputStream);
                return byteArray;
            } catch (Exception e14) {
                e10 = e14;
                byteArrayOutputStream2 = bufferedOutputStream;
                HMSLog.m36988i(f30202a, "getManifestBytes Exception!" + e10.getMessage());
                IOUtils.closeQuietly(inputStream);
                IOUtils.closeQuietly((InputStream) bufferedInputStream);
                IOUtils.closeQuietly((OutputStream) byteArrayOutputStream);
                IOUtils.closeQuietly((OutputStream) byteArrayOutputStream2);
                return null;
            } catch (Throwable th8) {
                th3 = th8;
                byteArrayOutputStream3 = bufferedOutputStream;
                outputStream = byteArrayOutputStream3;
                IOUtils.closeQuietly(inputStream);
                IOUtils.closeQuietly((InputStream) bufferedInputStream);
                IOUtils.closeQuietly((OutputStream) byteArrayOutputStream);
                IOUtils.closeQuietly(outputStream);
                throw th3;
            }
        } catch (Exception e15) {
            e10 = e15;
            inputStream = null;
        } catch (Throwable th9) {
            th2 = th9;
            inputStream = null;
        }
    }

    @TargetApi(19)
    /* renamed from: a */
    private static ArrayList<String> m37069a(byte[] bArr) throws IOException {
        if (bArr == null) {
            HMSLog.m36986e(f30202a, "manifest is null！");
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(byteArrayInputStream, StandardCharsets.UTF_8));
                try {
                    if (m37071a(bufferedReader, arrayList)) {
                        bufferedReader.close();
                        byteArrayInputStream.close();
                        return arrayList;
                    }
                    bufferedReader.close();
                    byteArrayInputStream.close();
                    return null;
                } finally {
                }
            } finally {
            }
        } catch (IOException unused) {
            HMSLog.m36986e(f30202a, "getManifestLinesArrary IOException!");
            return null;
        }
    }

    /* renamed from: b */
    private static boolean m37078b() {
        try {
        } catch (Exception e10) {
            HMSLog.m36988i(f30202a, "verifyMDMSignatureV2 MDM verify Exception!:" + e10.getMessage());
        }
        if (m37072a(Base64.decode(EMUI10_PK, 0), m37073a(f30208g, "SHA-256"), m37079b(f30205d), "SHA256withRSA")) {
            HMSLog.m36988i(f30202a, "verifyMDMSignatureV2 verify successful!");
            return true;
        }
        HMSLog.m36988i(f30202a, "verifyMDMSignatureV2 verify failure!");
        return false;
    }

    /* renamed from: b */
    private static byte[] m37079b(String str) {
        int i10;
        if (TextUtils.isEmpty(str)) {
            return new byte[0];
        }
        int length = str.length();
        if (length % 2 == 0) {
            i10 = length / 2;
        } else {
            i10 = (length / 2) + 1;
        }
        byte[] bArr = new byte[i10];
        for (int i11 = 0; i11 < length; i11 += 2) {
            int i12 = i11 + 1;
            if (i12 < length) {
                bArr[i11 / 2] = (byte) ((Character.digit(str.charAt(i11), 16) << 4) + Character.digit(str.charAt(i12), 16));
            } else {
                bArr[i11 / 2] = (byte) (Character.digit(str.charAt(i11), 16) << 4);
            }
        }
        return bArr;
    }

    @TargetApi(19)
    /* renamed from: a */
    private static byte[] m37074a(ArrayList<String> arrayList) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(byteArrayOutputStream, StandardCharsets.UTF_8));
        try {
            try {
                Collections.sort(arrayList);
                int size = arrayList.size();
                for (int i10 = 0; i10 < size; i10++) {
                    String str = arrayList.get(i10);
                    bufferedWriter.write(str, 0, str.length());
                    bufferedWriter.write("\r\n", 0, 2);
                }
                bufferedWriter.flush();
            } catch (Exception e10) {
                HMSLog.m36988i(f30202a, "getManifestBytesbySorted Exception!" + e10.getMessage());
            }
            IOUtils.closeQuietly((OutputStream) byteArrayOutputStream);
            IOUtils.closeQuietly((Writer) bufferedWriter);
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th2) {
            IOUtils.closeQuietly((OutputStream) byteArrayOutputStream);
            IOUtils.closeQuietly((Writer) bufferedWriter);
            throw th2;
        }
    }

    /* renamed from: a */
    private static boolean m37071a(BufferedReader bufferedReader, ArrayList<String> arrayList) throws IOException {
        String strM37067a = m37067a(bufferedReader);
        boolean z10 = false;
        while (strM37067a != null) {
            if (strM37067a.equals("Name: META-INF/HUAWEI.CER")) {
                String strM37067a2 = m37067a(bufferedReader);
                while (true) {
                    if (strM37067a2 == null) {
                        break;
                    }
                    if (strM37067a2.startsWith("Name:")) {
                        strM37067a = strM37067a2;
                        break;
                    }
                    strM37067a2 = m37067a(bufferedReader);
                }
                z10 = true;
            }
            if (strM37067a.length() != 0) {
                arrayList.add(strM37067a);
            }
            strM37067a = m37067a(bufferedReader);
        }
        return z10;
    }

    /* renamed from: a */
    private static String m37067a(BufferedReader bufferedReader) throws IOException {
        int i10;
        if (bufferedReader == null || (i10 = bufferedReader.read()) == -1) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder(10);
        while (i10 != -1) {
            char c10 = (char) i10;
            if (c10 == '\n') {
                break;
            }
            if (sb2.length() < 4096) {
                sb2.append(c10);
                i10 = bufferedReader.read();
            } else {
                throw new IOException("cert line is too long!");
            }
        }
        String string = sb2.toString();
        return (string.isEmpty() || !string.endsWith("\r")) ? string : string.substring(0, string.length() - 1);
    }

    /* renamed from: a */
    private static boolean m37070a() {
        try {
            if (m37072a(m37079b("30820122300d06092a864886f70d01010105000382010f003082010a0282010100a3d269348ac59923f65e8111c337605e29a1d1bc54fa96c1445050dd14d8d63b10f9f0230bb87ef348183660bedcabfdec045e235ed96935799fcdb4af5c97717ff3b0954eaf1b723225b3a00f81cbd67ce6dc5a4c07f7741ad3bf1913a480c6e267ab1740f409edd2dc33c8b718a8e30e56d9a93f321723c1d0c9ea62115f996812ceef186954595e39a19b74245542c407f7dddb1d12e6eedcfc0bd7cd945ef7255ad0fc9e796258e0fb5e52a23013d15033a32b4071b65f3f924ae5c5761e22327b4d2ae60f4158a5eb15565ba079de29b81540f5fbb3be101a95357f367fc661d797074ff3826950029c52223e4594673a24a334cae62d63b838ba3df9770203010001"), m37073a(f30208g, "SHA-256"), m37079b(f30204c), "SHA256withRSA")) {
                HMSLog.m36988i(f30202a, "verifyMDMSignatureV1 verify successful!");
                return true;
            }
            HMSLog.m36988i(f30202a, "verifyMDMSignatureV1 verify failure!");
            return false;
        } catch (Exception e10) {
            HMSLog.m36988i(f30202a, "verifyMDMSignatureV1 MDM verify Exception!:" + e10.getMessage());
            return false;
        }
    }

    /* renamed from: a */
    private static boolean m37072a(byte[] bArr, byte[] bArr2, byte[] bArr3, String str) throws Exception {
        Signature signature = Signature.getInstance(str);
        signature.initVerify(KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(bArr)));
        signature.update(bArr2);
        return signature.verify(bArr3);
    }

    @TargetApi(19)
    /* renamed from: a */
    private static byte[] m37073a(String str, String str2) throws Exception {
        MessageDigest messageDigest = MessageDigest.getInstance(str2);
        messageDigest.update(str.getBytes(StandardCharsets.UTF_8.name()));
        return messageDigest.digest();
    }

    /* renamed from: a */
    private static String m37068a(String str) {
        if (str == null) {
            return "";
        }
        return f30203b.matcher(str).replaceAll("");
    }
}
