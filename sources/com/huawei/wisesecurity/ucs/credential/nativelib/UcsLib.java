package com.huawei.wisesecurity.ucs.credential.nativelib;

import android.content.Context;
import android.text.TextUtils;
import aw.C1029b;
import com.huawei.wisesecurity.ucs.credential.entity.EcKeyPair;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import p239dw.C9320b;
import p239dw.C9344n;
import p857zv.Exception_C14389c;

/* loaded from: classes9.dex */
public class UcsLib {
    private static final String LIB_NAME = "ucs-credential";
    private static final long NATIVE_VERIFY_SIGNATURE_FAIL = 60000;
    private static final String TAG = "UcsLib";
    private static volatile boolean flag = false;
    private static volatile boolean updateRootKeyFlag = false;
    private static final Charset UTF_8 = StandardCharsets.UTF_8;
    private static final Object CA_LOCK = new Object();

    public static class OutputParam {
        public byte[] bytes = null;
        public byte[] secondBytes = null;
        public byte[] thirdBytes = null;
    }

    public static void checkNativeLibrary() throws Exception_C14389c {
        if (flag) {
            return;
        }
        String strLoadLibrary = loadLibrary();
        if (flag) {
            return;
        }
        throw new Exception_C14389c(1004L, "UCS load library error : " + strLoadLibrary);
    }

    public static boolean checkPkgNameCertFP(Context context, String str, String str2, StringBuilder sb2) {
        String str3;
        if (TextUtils.isEmpty(str)) {
            str3 = "appPkgName is null.";
        } else {
            if (!TextUtils.isEmpty(str2)) {
                OutputParam outputParamNewOutputParam = newOutputParam();
                Charset charset = StandardCharsets.UTF_8;
                long jNativeCheckPkgNameCertFP = nativeCheckPkgNameCertFP(context, str.getBytes(charset), str2.getBytes(charset), outputParamNewOutputParam);
                if (jNativeCheckPkgNameCertFP != 0) {
                    sb2.append(getErrorMessage(outputParamNewOutputParam, ""));
                }
                return jNativeCheckPkgNameCertFP == 0;
            }
            str3 = "appCertFP is null.";
        }
        sb2.append(str3);
        return false;
    }

    public static byte[] decryptKek(byte[] bArr, int i10) throws Exception_C14389c {
        OutputParam outputParamNewOutputParam = newOutputParam();
        long jNativeDecryptKek = nativeDecryptKek(bArr, i10, outputParamNewOutputParam);
        if (jNativeDecryptKek == 0) {
            return outputParamNewOutputParam.bytes;
        }
        String errorMessage = getErrorMessage(outputParamNewOutputParam, "Fail to decryptKek");
        throw C9344n.m58700a(TAG, errorMessage, new Object[0], jNativeDecryptKek, errorMessage);
    }

    public static byte[] decryptKekWithEc(byte[] bArr, int i10, byte[] bArr2, byte[] bArr3, byte[] bArr4) throws Exception_C14389c {
        OutputParam outputParamNewOutputParam = newOutputParam();
        long jNativeDecryptKekWithEc = nativeDecryptKekWithEc(bArr, i10, bArr2, bArr3, bArr4, outputParamNewOutputParam);
        if (jNativeDecryptKekWithEc == 0) {
            return outputParamNewOutputParam.bytes;
        }
        String errorMessage = getErrorMessage(outputParamNewOutputParam, "Fail to decryptKekWithEc");
        throw C9344n.m58700a(TAG, errorMessage, new Object[0], jNativeDecryptKekWithEc, errorMessage);
    }

    public static byte[] genReqJws(Context context, String str, String str2, int i10, int i11) throws Exception_C14389c {
        String str3 = str == null ? "" : str;
        if (context == null) {
            throw new Exception_C14389c(1001L, "context cannot empty..");
        }
        if (TextUtils.isEmpty(str2)) {
            throw new Exception_C14389c(1001L, "packageName cannot empty..");
        }
        String strValueOf = String.valueOf(i11);
        OutputParam outputParamNewOutputParam = newOutputParam();
        Charset charset = StandardCharsets.UTF_8;
        long jNativeGenReqJws = nativeGenReqJws(context, str3.getBytes(charset), str2.getBytes(charset), i10, strValueOf.getBytes(charset), outputParamNewOutputParam);
        if (jNativeGenReqJws == 0) {
            return outputParamNewOutputParam.bytes;
        }
        String errorMessage = getErrorMessage(outputParamNewOutputParam, "Fail to genReqJws");
        throw C9344n.m58700a(TAG, errorMessage, new Object[0], jNativeGenReqJws, errorMessage);
    }

    public static EcKeyPair generateEcKeyPair(Context context) throws Exception_C14389c {
        OutputParam outputParamNewOutputParam = newOutputParam();
        long jNativeGenerateEcKeyPair = nativeGenerateEcKeyPair(context, outputParamNewOutputParam);
        if (jNativeGenerateEcKeyPair == 0) {
            return EcKeyPair.newBuilder().publicKey(outputParamNewOutputParam.bytes).privateKey(outputParamNewOutputParam.secondBytes).build();
        }
        String errorMessage = getErrorMessage(outputParamNewOutputParam, "Fail to nativeGenerateEcKeyPair");
        throw C9344n.m58700a(TAG, errorMessage, new Object[0], jNativeGenerateEcKeyPair, errorMessage);
    }

    private static String getErrorMessage(OutputParam outputParam, String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(", ");
        byte[] bArr = outputParam.thirdBytes;
        sb2.append(bArr != null ? new String(bArr, StandardCharsets.UTF_8) : "errorLog is null.");
        return sb2.toString();
    }

    public static List<String> getPkgNameCertFP(Context context) throws Exception_C14389c {
        ArrayList arrayList = new ArrayList();
        OutputParam outputParamNewOutputParam = newOutputParam();
        long jNativeGetPkgNameCertFP = nativeGetPkgNameCertFP(context, outputParamNewOutputParam);
        if (jNativeGetPkgNameCertFP != 0) {
            String errorMessage = getErrorMessage(outputParamNewOutputParam, "Fail to getPkgNameCertFP");
            throw C9344n.m58700a(TAG, errorMessage, new Object[0], jNativeGetPkgNameCertFP, errorMessage);
        }
        byte[] bArr = outputParamNewOutputParam.bytes;
        Charset charset = StandardCharsets.UTF_8;
        arrayList.add(new String(bArr, charset));
        arrayList.add(new String(outputParamNewOutputParam.secondBytes, charset));
        return arrayList;
    }

    private static native long getSoVersion();

    public static boolean isRootKeyUpdated() {
        return updateRootKeyFlag;
    }

    public static synchronized String loadLibrary() {
        String string;
        string = "";
        if (!flag) {
            try {
                System.loadLibrary(LIB_NAME);
                C1029b.m6234e(TAG, "load lib {0} success", LIB_NAME);
                flag = true;
            } catch (Throwable th2) {
                StringBuilder sbM58651a = C9320b.m58651a("load lib ucs-credential error : ");
                sbM58651a.append(th2.getMessage());
                string = sbM58651a.toString();
                C1029b.m6231b(TAG, string, new Object[0]);
            }
        }
        return string;
    }

    private static native long nativeCheckPkgNameCertFP(Context context, byte[] bArr, byte[] bArr2, OutputParam outputParam);

    private static native long nativeDecryptKek(byte[] bArr, int i10, OutputParam outputParam);

    private static native long nativeDecryptKekWithEc(byte[] bArr, int i10, byte[] bArr2, byte[] bArr3, byte[] bArr4, OutputParam outputParam);

    private static native long nativeGenReqJws(Context context, byte[] bArr, byte[] bArr2, long j10, byte[] bArr3, OutputParam outputParam);

    private static native long nativeGenerateEcKeyPair(Context context, OutputParam outputParam);

    private static native long nativeGetPkgNameCertFP(Context context, OutputParam outputParam);

    public static OutputParam newOutputParam() {
        return new OutputParam();
    }

    public static long ucsGetSoVersion() {
        return getSoVersion();
    }

    public static void ucsUpdateRootKey(byte[] bArr, int i10) throws Exception_C14389c {
        synchronized (CA_LOCK) {
            try {
                OutputParam outputParamNewOutputParam = newOutputParam();
                long jUpdateRootKey = updateRootKey(bArr, i10, outputParamNewOutputParam);
                updateRootKeyFlag = jUpdateRootKey == 0;
                if (jUpdateRootKey != 0) {
                    String errorMessage = getErrorMessage(outputParamNewOutputParam, "Fail to updateRootKey");
                    C1029b.m6231b(TAG, errorMessage, new Object[0]);
                    throw new Exception_C14389c(1009L, errorMessage);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private static native long updateRootKey(byte[] bArr, int i10, OutputParam outputParam);
}
