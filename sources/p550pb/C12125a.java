package p550pb;

import android.content.Context;
import android.os.Bundle;
import com.huawei.android.hicloud.icloudpay.ICloudPayProtocol;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import p450le.C11272a;

/* renamed from: pb.a */
/* loaded from: classes3.dex */
public final class C12125a implements ICloudPayProtocol {

    /* renamed from: b */
    public static C12125a f56238b = new C12125a();

    /* renamed from: a */
    public Context f56239a;

    /* renamed from: c */
    public static C12125a m72704c() {
        return f56238b;
    }

    @Override // com.huawei.android.hicloud.icloudpay.ICloudPayProtocol
    /* renamed from: a */
    public void mo16405a(Context context, String str, Bundle bundle, boolean z10, int i10) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString("channel_refer", str);
        if (context == null) {
            C11272a.m67644d(this.f56239a, HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK, bundle, z10, i10);
        } else {
            C11272a.m67644d(context, HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK, bundle, z10, i10);
        }
    }

    @Override // com.huawei.android.hicloud.icloudpay.ICloudPayProtocol
    /* renamed from: b */
    public void mo16406b(Context context) {
        this.f56239a = context;
    }
}
