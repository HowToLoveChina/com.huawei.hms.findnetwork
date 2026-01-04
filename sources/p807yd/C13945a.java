package p807yd;

import android.app.Activity;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.android.hicloud.p088ui.uiadapter.BaseDataItemRecyclerAdapter;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.base.bean.SyncItemInfo;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import gp.C10028c;
import java.util.LinkedHashMap;
import p514o9.C11839m;
import sk.C12809f;

/* renamed from: yd.a */
/* loaded from: classes3.dex */
public class C13945a extends C13950f {

    /* renamed from: o */
    public Activity f62532o;

    public C13945a(Activity activity, LinkedHashMap<String, SyncItemInfo> linkedHashMap) {
        super(activity, linkedHashMap);
        this.f62532o = activity;
    }

    @Override // p807yd.C13950f
    /* renamed from: t */
    public void mo83728t() {
        C11839m.m70688i("BaseDataItemStatusController", "initView");
        Activity activity = this.f62532o;
        if (activity == null) {
            C11839m.m70687e("BaseDataItemStatusController", "mActivity null");
            return;
        }
        HwRecyclerView hwRecyclerView = (HwRecyclerView) C12809f.m76829b(activity, R$id.sync_normal_recycler_view);
        this.f62569e = hwRecyclerView;
        RecyclerView.AbstractC0838h adapter = hwRecyclerView.getAdapter();
        if (adapter instanceof BaseDataItemRecyclerAdapter) {
            this.f62570f = (BaseDataItemRecyclerAdapter) adapter;
        }
        C10028c c10028cM62182c0 = C10028c.m62182c0();
        int i10 = R$string.cloud_backup_explain_main;
        c10028cM62182c0.m62264Q1(1, i10);
        this.f62572h = new C13949e(this.f62570f, this.f62569e, this.f62571g);
        C10028c.m62182c0().m62264Q1(1, i10);
    }
}
