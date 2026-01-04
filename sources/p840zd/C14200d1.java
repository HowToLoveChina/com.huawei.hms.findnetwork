package p840zd;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.android.hicloud.p088ui.uiextend.UnionCheckBox;
import com.huawei.android.p073ds.R$id;
import com.huawei.uikit.hwprogressbar.widget.HwProgressBar;
import huawei.android.widget.ImageView;
import sk.C12809f;

/* renamed from: zd.d1 */
/* loaded from: classes3.dex */
public class C14200d1 extends RecyclerView.AbstractC0833c0 {

    /* renamed from: A */
    public final ImageView f63374A;

    /* renamed from: B */
    public final TextView f63375B;

    /* renamed from: C */
    public final TextView f63376C;

    /* renamed from: D */
    public final HwProgressBar f63377D;

    /* renamed from: E */
    public final View f63378E;

    /* renamed from: u */
    public final RelativeLayout f63379u;

    /* renamed from: v */
    public final ImageView f63380v;

    /* renamed from: w */
    public final ImageView f63381w;

    /* renamed from: x */
    public final TextView f63382x;

    /* renamed from: y */
    public final TextView f63383y;

    /* renamed from: z */
    public final UnionCheckBox f63384z;

    public C14200d1(View view) {
        super(view);
        this.f63379u = (RelativeLayout) C12809f.m76831d(view, R$id.item_view);
        this.f63380v = C12809f.m76831d(view, R$id.img_module_icon);
        this.f63381w = C12809f.m76831d(view, R$id.img_module_icon_badge);
        this.f63382x = (TextView) C12809f.m76831d(view, R$id.img_module_name);
        this.f63383y = (TextView) C12809f.m76831d(view, R$id.tv_recommend);
        this.f63384z = (UnionCheckBox) C12809f.m76831d(view, R$id.cb_backup_item);
        this.f63374A = C12809f.m76831d(view, R$id.detail_iv);
        this.f63375B = (TextView) C12809f.m76831d(view, R$id.img_module_size);
        this.f63376C = (TextView) C12809f.m76831d(view, R$id.temp_option_list_item_tip);
        this.f63377D = (HwProgressBar) C12809f.m76831d(view, R$id.progress_item);
        this.f63378E = C12809f.m76831d(view, R$id.view_line);
    }
}
