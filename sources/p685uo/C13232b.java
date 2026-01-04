package p685uo;

import com.huawei.hidisk.common.util.javautil.StringUtil;
import com.huawei.hms.framework.network.restclient.dnkeeper.InterfaceC5483d;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.io.IOException;
import okhttp3.AbstractC11920f0;
import okhttp3.C11910a0;

/* renamed from: uo.b */
/* loaded from: classes6.dex */
public class C13232b extends C13231a {
    public C13232b(String str, String str2, String str3, String str4, String str5, boolean z10, String str6, String str7) {
        super(str, str2, str3, str4, str5, z10, str6, str7);
    }

    @Override // p685uo.C13231a, com.huawei.hicloud.request.okhttp.callback.AbstractC4993b
    public AbstractC11920f0 create() throws IOException {
        return AbstractC11920f0.create(C11910a0.m71445d(InterfaceC5483d.f25084j), StringUtil.emptyIfBlank(this.f59902b).getBytes(Constants.UTF_8));
    }
}
