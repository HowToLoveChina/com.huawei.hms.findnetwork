package p650t7;

import android.os.Bundle;
import com.huawei.android.hicloud.album.service.hihttp.request.response.BaseResponse;
import com.huawei.cloud.base.http.C4616s;
import fk.C9721b;
import java.io.IOException;
import p031b7.C1120a;
import p031b7.C1122c;
import p764x6.AbstractC13712d;

/* renamed from: t7.v */
/* loaded from: classes2.dex */
public abstract class AbstractC12988v<T extends BaseResponse> extends AbstractC13712d<BaseResponse> {

    /* renamed from: f */
    public Bundle f59133f;

    public AbstractC12988v() {
    }

    @Override // p764x6.AbstractC13712d
    /* renamed from: h */
    public String mo77942h() throws Exception {
        try {
            mo77876l();
        } catch (C4616s e10) {
            C1120a.m6676e("HiHttpCloudPhotoDriveExecutor", "runTask httpResponseException:" + e10.toString());
            this.f59133f.putInt("code", C1122c.m6802l0(e10));
        } catch (C9721b e11) {
            C1120a.m6676e("HiHttpCloudPhotoDriveExecutor", "runTask CException:" + e11.toString());
            this.f59133f.putInt("code", e11.m60659c());
        } catch (IOException e12) {
            C1120a.m6676e("HiHttpCloudPhotoDriveExecutor", "runTask IOException:" + e12.toString());
            this.f59133f.putInt("code", C1122c.m6845x0(e12));
        }
        C1120a.m6677i("HiHttpCloudPhotoDriveExecutor", "runTask execute " + getClass().getSimpleName() + " code:" + this.f59133f.getInt("code", 0));
        return "";
    }

    /* renamed from: k */
    public T mo77904k(Class<BaseResponse> cls) throws Exception {
        return null;
    }

    /* renamed from: l */
    public String mo77876l() throws Exception {
        this.f59133f = new Bundle();
        return "";
    }

    /* renamed from: m */
    public Bundle mo77877m() {
        return this.f59133f;
    }

    /* renamed from: n */
    public boolean m77943n(int i10, C4616s c4616s) {
        return (c4616s.m28322f() == 410 && i10 == 4100) || (c4616s.m28322f() == 400 && i10 == 4002);
    }

    /* renamed from: o */
    public boolean m77944o(int i10, String str) {
        return (i10 == 410 && str.endsWith(String.valueOf(4100))) || (i10 == 400 && str.endsWith(String.valueOf(4002)));
    }

    @Override // p764x6.AbstractC13712d, p764x6.AbstractC13709a
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public T mo77941d(Class<BaseResponse> cls) throws Exception {
        if (mo82453g() && (this.f61708b == null || this.f61709c == null)) {
            C1120a.m6678w("HiHttpCloudPhotoDriveExecutor", "Drive has not been initialized");
            throw new C9721b(4001, "drive has not been initialized");
        }
        T t10 = (T) mo77904k(cls);
        if (t10 != null) {
            C1120a.m6677i("HiHttpCloudPhotoDriveExecutor", "run execute " + getClass().getSimpleName() + " code:" + t10.getCode());
        }
        return t10;
    }

    public AbstractC12988v(String str) {
        super(str);
    }
}
