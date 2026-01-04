package pk;

import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import fk.C9721b;
import java.net.URLDecoder;

/* renamed from: pk.a */
/* loaded from: classes6.dex */
public class C12158a {
    /* renamed from: a */
    public static String m72864a(String str, String str2) throws C9721b {
        try {
            return URLDecoder.decode(str, str2);
        } catch (Exception unused) {
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "url decode exception");
        }
    }
}
