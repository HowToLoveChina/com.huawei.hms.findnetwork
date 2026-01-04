package p731w7;

import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.android.hicloud.album.service.p075vo.HttpResult;
import p031b7.C1120a;

/* renamed from: w7.c */
/* loaded from: classes2.dex */
public class C13536c extends AbstractC13544k<Bundle> {
    @Override // p731w7.AbstractC13539f
    /* renamed from: H, reason: merged with bridge method [inline-methods] */
    public Bundle mo81440A(int i10, String str, String str2) {
        Bundle bundleM81460y = m81460y(str);
        if (bundleM81460y == null) {
            C1120a.m6678w("HttpResultBundleRequest", "getResponseBundle is null!");
            bundleM81460y = new Bundle();
            if (!TextUtils.isEmpty(this.f60923k)) {
                bundleM81460y.putString("sessionId", this.f60923k);
            }
        }
        this.f60918f = bundleM81460y.getInt("code", 101);
        int i11 = bundleM81460y.getInt("opsreportcode", 101);
        this.f60919g = i11;
        if (i11 != 4312) {
            this.f60919g = this.f60918f;
        }
        if (i10 == 200) {
            this.f60920h = bundleM81460y.getString("info");
        } else {
            this.f60920h = bundleM81460y.getString(str2);
        }
        String string = bundleM81460y.getString("errMsg");
        if (!TextUtils.isEmpty(string)) {
            this.f60920h += ":" + string;
        }
        bundleM81460y.putParcelable("HttpResult", new HttpResult(i10, this.f60918f, this.f60920h));
        return bundleM81460y;
    }
}
