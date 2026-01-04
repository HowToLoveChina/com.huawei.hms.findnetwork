package ae;

import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.android.hicloud.p088ui.views.BackupDetailItemView;
import com.huawei.android.p073ds.R$id;
import sk.C12809f;

/* renamed from: ae.l0 */
/* loaded from: classes3.dex */
public class C0144l0 extends RecyclerView.AbstractC0833c0 {

    /* renamed from: u */
    public BackupDetailItemView f521u;

    /* renamed from: v */
    public final View f522v;

    public C0144l0(View view, int i10) {
        super(view);
        this.f522v = view;
        if (i10 == 2) {
            this.f521u = (BackupDetailItemView) C12809f.m76831d(view, R$id.backup_subitem_view);
        } else if (i10 != 3) {
            this.f521u = (BackupDetailItemView) C12809f.m76831d(view, R$id.backup_item_view);
        } else {
            this.f521u = (BackupDetailItemView) C12809f.m76831d(view, R$id.backup_subitem_third_view);
        }
    }

    /* renamed from: P */
    public void m822P(Drawable drawable) {
        this.f522v.setBackground(drawable);
    }

    /* renamed from: Q */
    public void m823Q(int i10) {
        this.f522v.setBackgroundColor(i10);
    }
}
