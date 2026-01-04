package p386j6;

import android.content.Context;
import com.huawei.android.backup.filelogic.utils.C2111d;
import java.util.ArrayList;
import p699v4.C13345n;

/* renamed from: j6.b */
/* loaded from: classes.dex */
public class C10712b {

    /* renamed from: a */
    public static final ArrayList<String> f51359a;

    static {
        ArrayList<String> arrayList = new ArrayList<>(3);
        f51359a = arrayList;
        arrayList.add("soundrecorder");
        arrayList.add("sns");
        arrayList.add("callRecorder");
        arrayList.add("galleryData");
    }

    /* renamed from: a */
    public static String m65388a(Context context, String str) {
        if (str == null || str.isEmpty()) {
            C2111d.m12648d("BackupSdCardUtil", "parentPath is empty");
            str = C13345n.m80072k(context, 2);
        }
        return str + "/Huawei/CloudClone/SDCardClone";
    }

    /* renamed from: b */
    public static String m65389b(String str) {
        if (str == null || str.isEmpty()) {
            C2111d.m12646b("BackupSdCardUtil", "parentPath is empty");
            return "/SDCardClone";
        }
        return str + "/SDCardClone";
    }

    /* renamed from: c */
    public static boolean m65390c(String str) {
        return f51359a.contains(str);
    }
}
