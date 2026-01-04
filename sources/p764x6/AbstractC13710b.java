package p764x6;

import com.huawei.android.p069cg.request.response.BaseResponse;
import com.huawei.cloud.base.http.C4616s;
import com.huawei.cloud.base.util.C4627a0;
import fk.C9721b;
import p031b7.C1120a;

/* renamed from: x6.b */
/* loaded from: classes2.dex */
public abstract class AbstractC13710b<E> extends AbstractC13712d<E> {

    /* renamed from: f */
    public E f61705f;

    /* renamed from: g */
    public boolean f61706g;

    public AbstractC13710b(String str) {
        super(str);
        this.f61705f = null;
        this.f61706g = true;
    }

    @Override // p764x6.AbstractC13712d, p764x6.AbstractC13709a
    /* renamed from: d */
    public E mo77941d(Class<E> cls) throws Exception {
        try {
            C1120a.m6677i("CgDriveExecutor", "execute " + getClass() + " begin");
            if (mo82453g() && (this.f61708b == null || this.f61709c == null)) {
                C1120a.m6678w("CgDriveExecutor", "Drive has not been initialized");
                throw new C9721b(4001, "drive has not been initialized");
            }
            C1120a.m6675d("CgDriveExecutor", "execute res:" + mo82455k());
            C4627a0.m28391d(this.f61705f);
            E e10 = this.f61705f;
            if (e10 instanceof BaseResponse) {
                BaseResponse baseResponse = (BaseResponse) e10;
                baseResponse.setCode(0);
                baseResponse.setInfo("success");
            }
        } catch (C4616s e11) {
            int iM28322f = e11.m28322f();
            C1120a.m6676e("CgDriveExecutor", "HttpResponseException statusCode: " + iM28322f + "errorResp" + e11.m28319c());
            E e12 = this.f61705f;
            if (e12 instanceof BaseResponse) {
                BaseResponse baseResponse2 = (BaseResponse) e12;
                baseResponse2.setCode(iM28322f);
                baseResponse2.setInfo(e11.m28323g());
            }
        }
        return this.f61705f;
    }

    @Override // p764x6.AbstractC13712d
    /* renamed from: g */
    public boolean mo82453g() {
        return this.f61706g;
    }

    @Override // p764x6.AbstractC13712d
    /* renamed from: j */
    public void mo82454j(boolean z10) {
        this.f61706g = z10;
    }

    /* renamed from: k */
    public abstract int mo82455k() throws Exception;
}
