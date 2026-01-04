package com.huawei.hianalytics.framework;

import android.text.TextUtils;
import com.huawei.hianalytics.core.log.HiLog;
import com.huawei.hianalytics.core.storage.Event;
import com.huawei.hianalytics.core.storage.IStorageHandler;
import com.huawei.hianalytics.framework.config.CipherType;
import com.huawei.hianalytics.framework.config.ICallback;
import com.huawei.hianalytics.framework.config.ICollectorConfig;
import com.huawei.hianalytics.framework.config.IMandatoryParameters;
import com.huawei.hianalytics.framework.policy.IStoragePolicy;
import com.huawei.secure.android.common.encrypt.aes.AesGcm;
import cu.C8952a;
import gu.C10049c;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.zip.Deflater;

/* renamed from: com.huawei.hianalytics.framework.b */
/* loaded from: classes5.dex */
public class C4755b {
    /* renamed from: a */
    public static Class m28834a(Field field) {
        int i10;
        if (Map.class.isAssignableFrom(field.getType())) {
            i10 = 1;
        } else {
            if (!List.class.isAssignableFrom(field.getType())) {
                return null;
            }
            i10 = 0;
        }
        return m28835a(field, i10);
    }

    /* renamed from: b */
    public static ICollectorConfig m28843b(String str) {
        return C4757d.f21744e.f21746b.get(str);
    }

    /* renamed from: c */
    public static IStorageHandler m28844c(String str) {
        C4758e c4758eM28833a = m28833a(str);
        if (c4758eM28833a != null) {
            return c4758eM28833a.f21761a;
        }
        return null;
    }

    /* renamed from: d */
    public static IStoragePolicy m28845d(String str) {
        return C4757d.f21744e.f21748d.get(str);
    }

    /* renamed from: a */
    public static Class m28835a(Field field, int i10) throws ClassNotFoundException {
        Class<?> cls;
        Type genericType = field.getGenericType();
        if (!(genericType instanceof ParameterizedType)) {
            return null;
        }
        Type[] actualTypeArguments = ((ParameterizedType) genericType).getActualTypeArguments();
        if (actualTypeArguments.length <= i10) {
            return null;
        }
        try {
            Type type = actualTypeArguments[i10];
            if (type instanceof Class) {
                cls = (Class) type;
            } else {
                String string = type.toString();
                int iIndexOf = string.indexOf("class ");
                if (iIndexOf < 0) {
                    iIndexOf = 0;
                }
                int iIndexOf2 = string.indexOf("<");
                if (iIndexOf2 < 0) {
                    iIndexOf2 = string.length();
                }
                cls = Class.forName(string.substring(iIndexOf, iIndexOf2));
            }
            return cls;
        } catch (Exception unused) {
            HiLog.m28812w("ReflectAPI", "getType Exception");
            return null;
        }
    }

    /* renamed from: a */
    public static void m28838a(ICallback iCallback, IStorageHandler iStorageHandler, Event event) {
        try {
            iStorageHandler.insert(event);
        } catch (Exception e10) {
            if (iCallback == null) {
                return;
            }
            iCallback.onResult(event.getEvtid(), 401, "storage fail. Cause: " + e10.getMessage());
        }
    }

    /* renamed from: a */
    public static void m28839a(OutputStream outputStream) throws IOException {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException unused) {
                HiLog.m28811sw("StreamUtil", "close OutputStream error");
            }
        }
    }

    /* renamed from: a */
    public static void m28840a(Boolean bool, ICallback iCallback, IStorageHandler iStorageHandler, Event event, int i10) {
        String evtid;
        StringBuilder sb2;
        String str;
        try {
            iStorageHandler.insert(event);
        } catch (Exception e10) {
            if (iCallback == null) {
                return;
            }
            if (bool.booleanValue()) {
                evtid = event.getEvtid();
                sb2 = new StringBuilder();
                str = "storage fail. Cause: ";
            } else {
                evtid = event.getEvtid();
                sb2 = new StringBuilder();
                sb2.append("resultCode is ");
                sb2.append(i10);
                str = " and storage fail. Cause: ";
            }
            sb2.append(str);
            sb2.append(e10.getMessage());
            iCallback.onResult(evtid, 402, sb2.toString());
        }
    }

    /* renamed from: a */
    public static byte[] m28841a(byte[] bArr) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        byte[] byteArray = new byte[0];
        Deflater deflater = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                try {
                    Deflater deflater2 = new Deflater();
                    try {
                        deflater2.setInput(bArr);
                        deflater2.finish();
                        byte[] bArr2 = new byte[1024];
                        while (!deflater2.finished()) {
                            byteArrayOutputStream.write(bArr2, 0, deflater2.deflate(bArr2));
                        }
                        byteArray = byteArrayOutputStream.toByteArray();
                        deflater2.end();
                    } catch (Exception unused) {
                        deflater = deflater2;
                        HiLog.m28808e("StreamUtil", "getBitZip exception");
                        if (deflater != null) {
                            deflater.end();
                        }
                        m28839a(byteArrayOutputStream);
                        return byteArray;
                    } catch (Throwable th2) {
                        th = th2;
                        deflater = deflater2;
                        if (deflater != null) {
                            deflater.end();
                        }
                        m28839a(byteArrayOutputStream);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (Exception unused2) {
            }
        } catch (Exception unused3) {
            byteArrayOutputStream = null;
        } catch (Throwable th4) {
            th = th4;
            byteArrayOutputStream = null;
        }
        m28839a(byteArrayOutputStream);
        return byteArray;
    }

    /* renamed from: a */
    public static Field[] m28842a(Class cls) {
        Field[] fieldArrM28842a = cls.getSuperclass() != null ? m28842a(cls.getSuperclass()) : null;
        Field[] declaredFields = cls.getDeclaredFields();
        if (fieldArrM28842a == null || fieldArrM28842a.length <= 0) {
            return declaredFields;
        }
        Field[] fieldArr = new Field[declaredFields.length + fieldArrM28842a.length];
        System.arraycopy(fieldArrM28842a, 0, fieldArr, 0, fieldArrM28842a.length);
        System.arraycopy(declaredFields, 0, fieldArr, fieldArrM28842a.length, declaredFields.length);
        return fieldArr;
    }

    /* renamed from: a */
    public static String m28836a(String str, IMandatoryParameters iMandatoryParameters) {
        if (iMandatoryParameters == null) {
            return "";
        }
        byte[] loadWorkKey = iMandatoryParameters.getLoadWorkKey();
        String cipherType = iMandatoryParameters.getCipherType();
        cipherType.hashCode();
        if (!cipherType.equals(CipherType.AES_GCM)) {
            return !cipherType.equals(CipherType.AES_CBC) ? "" : C8952a.m56691m(str, loadWorkKey);
        }
        UUID uuidRandomUUID = UUID.randomUUID();
        long mostSignificantBits = uuidRandomUUID.getMostSignificantBits();
        long leastSignificantBits = uuidRandomUUID.getLeastSignificantBits();
        byte[] bArr = new byte[12];
        for (int i10 = 0; i10 < 8; i10++) {
            int i11 = (7 - i10) * 8;
            bArr[i10] = (byte) ((mostSignificantBits >>> i11) & 255);
            int i12 = i10 + 8;
            if (i12 < 12) {
                bArr[i12] = (byte) ((leastSignificantBits >>> i11) & 255);
            }
        }
        return C10049c.m62476a(bArr) + AesGcm.encrypt(str, loadWorkKey, bArr);
    }

    /* renamed from: a */
    public static String m28837a(String str, String str2) {
        String collectUrl = C4757d.f21744e.f21746b.get(str).getCollectUrl(str2);
        if (TextUtils.isEmpty(collectUrl)) {
            return "";
        }
        return ("maint".equals(str2) ? "{url}/common/hmshimaintqrt" : "{url}/common/hmshioperqrt").replace("{url}", collectUrl);
    }

    /* renamed from: a */
    public static C4758e m28833a(String str) {
        return C4757d.f21744e.f21747c.get(str);
    }
}
