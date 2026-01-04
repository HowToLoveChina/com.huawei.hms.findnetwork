package com.huawei.hms.drive;

import android.content.Context;
import android.net.Uri;
import com.huawei.hms.common.PackageConstants;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/* renamed from: com.huawei.hms.drive.y */
/* loaded from: classes8.dex */
public class C5303y {

    /* renamed from: a */
    private static final Uri f24586a = Uri.parse("content://com.huawei.hwid");

    /* renamed from: b */
    private static final String[] f24587b = {"B92825C2BD5D6D6D1E7F39EECD17843B7D9016F611136B75441BC6F4D3F00F05", PackageConstants.SERVICES_SIGNATURE_V3};

    /* renamed from: a */
    public static InputStream m31835a(Context context) {
        if (!m31837c(context)) {
            return null;
        }
        C5170ac.m30795b("BksUtil", "getFilesBksIS ");
        try {
            return new FileInputStream(m31838d(context));
        } catch (FileNotFoundException unused) {
            C5170ac.m30796c("BksUtil", "FileNotFoundExceptio: ");
            return null;
        }
    }

    /* renamed from: b */
    private static String m31836b(Context context) {
        return context.createDeviceProtectedStorageContext().getFilesDir() + File.separator + "aegis";
    }

    /* renamed from: c */
    private static boolean m31837c(Context context) {
        return new File(m31836b(context) + File.separator + "hmsrootcas.bks").exists();
    }

    /* renamed from: d */
    private static String m31838d(Context context) {
        return m31836b(context) + File.separator + "hmsrootcas.bks";
    }
}
