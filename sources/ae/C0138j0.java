package ae;

import android.content.Context;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.android.p073ds.R$id;
import p514o9.C11839m;
import sk.C12809f;

/* renamed from: ae.j0 */
/* loaded from: classes3.dex */
public class C0138j0 extends RecyclerView.AbstractC0833c0 {

    /* renamed from: u */
    public TextView f497u;

    /* renamed from: v */
    public TextView f498v;

    /* renamed from: w */
    public TextView f499w;

    /* renamed from: x */
    public TextView f500x;

    /* renamed from: y */
    public CheckBox f501y;

    public C0138j0(View view, Context context) {
        super(view);
        if (context == null) {
            C11839m.m70688i("CloudBackupDetailViewHolder", "context is null");
            return;
        }
        this.f497u = (TextView) C12809f.m76831d(view, R$id.record_device);
        this.f498v = (TextView) C12809f.m76831d(view, R$id.backup_last_time);
        this.f499w = (TextView) C12809f.m76831d(view, R$id.overdue_time);
        this.f500x = (TextView) C12809f.m76831d(view, R$id.backup_size);
        this.f501y = (CheckBox) C12809f.m76831d(view, R$id.backup_delete_check);
    }
}
