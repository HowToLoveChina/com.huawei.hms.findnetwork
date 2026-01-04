package be;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.android.p073ds.R$id;
import sk.C12809f;

/* renamed from: be.e */
/* loaded from: classes3.dex */
public class C1169e extends RecyclerView.AbstractC0833c0 {

    /* renamed from: u */
    public LinearLayout f5526u;

    /* renamed from: v */
    public ImageView f5527v;

    /* renamed from: w */
    public TextView f5528w;

    public C1169e(View view) {
        super(view);
        this.f5526u = (LinearLayout) C12809f.m76831d(view, R$id.privilege_container);
        this.f5527v = (ImageView) C12809f.m76831d(view, R$id.pay_success_privilege_img);
        this.f5528w = (TextView) C12809f.m76831d(view, R$id.pay_success_privilege_text);
    }
}
