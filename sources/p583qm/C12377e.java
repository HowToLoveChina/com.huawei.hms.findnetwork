package p583qm;

import com.huawei.android.hicloud.drive.clouddisk.expand.RequestMethod;
import com.huawei.cloud.base.http.AbstractC4619v;
import com.huawei.cloud.base.util.C4627a0;
import java.io.IOException;
import java.util.Arrays;

/* renamed from: qm.e */
/* loaded from: classes6.dex */
public class C12377e extends AbstractC4619v {

    /* renamed from: e */
    public static final String[] f57199e;

    /* renamed from: d */
    public final C12373a f57200d = new C12373a();

    static {
        String[] strArr = {"DELETE", "GET", "HEAD", "POST", "PUT", RequestMethod.PATCH};
        f57199e = strArr;
        Arrays.sort(strArr);
    }

    @Override // com.huawei.cloud.base.http.AbstractC4619v
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C12375c buildRequest(String str, String str2) throws IOException {
        C4627a0.m28390c(supportsMethod(str), "HTTP method %s not supported", str);
        return new C12375c(this.f57200d.m74425b(0), str, str2);
    }

    @Override // com.huawei.cloud.base.http.AbstractC4619v
    public boolean supportsMethod(String str) {
        return Arrays.binarySearch(f57199e, str) >= 0;
    }
}
