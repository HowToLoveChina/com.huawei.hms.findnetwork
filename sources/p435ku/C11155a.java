package p435ku;

import android.content.Context;
import android.net.Uri;
import com.huawei.hms.common.PackageConstants;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/* renamed from: ku.a */
/* loaded from: classes5.dex */
public class C11155a {

    /* renamed from: a */
    public static final Uri f52497a = Uri.parse("content://com.huawei.hwid");

    /* renamed from: b */
    public static final String[] f52498b = {"B92825C2BD5D6D6D1E7F39EECD17843B7D9016F611136B75441BC6F4D3F00F05", PackageConstants.SERVICES_SIGNATURE_V3};

    /* renamed from: a */
    public static String m67078a(Context context) {
        return context.createDeviceProtectedStorageContext().getFilesDir() + File.separator + "aegis";
    }

    /* renamed from: b */
    public static String m67079b(Context context) {
        return m67078a(context) + File.separator + "hmsrootcas.bks";
    }

    /* renamed from: c */
    public static boolean m67080c(Context context) {
        return new File(m67078a(context) + File.separator + "hmsrootcas.bks").exists();
    }

    /* renamed from: d */
    public static InputStream m67081d(Context context) {
        if (!m67080c(context)) {
            return null;
        }
        C11160f.m67096e("BksUtil", "getFilesBksIS ");
        try {
            return new FileInputStream(m67079b(context));
        } catch (FileNotFoundException unused) {
            C11160f.m67095d("BksUtil", "FileNotFoundExceptio: ");
            return null;
        }
    }
}
