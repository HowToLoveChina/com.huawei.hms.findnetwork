package bs;

import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import java.io.File;

/* renamed from: bs.h */
/* loaded from: classes8.dex */
public class C1281h {

    /* renamed from: a */
    public static final String f5731a;

    /* renamed from: b */
    public static final String f5732b;

    /* renamed from: c */
    public static final String f5733c;

    static {
        String str = File.separator;
        f5731a = str;
        f5732b = str + "debug" + str;
        StringBuilder sb2 = new StringBuilder(JsbMapKeyNames.H5_LOC);
        sb2.append(str);
        f5733c = sb2.toString();
    }
}
