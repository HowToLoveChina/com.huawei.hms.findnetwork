package ae;

import android.content.Context;
import android.content.Intent;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.p088ui.activity.BackupCleanRecordsDetailActivity;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.cloudbackup.model.CloudRecoveryItem;
import java.util.List;
import p015ak.C0209d;
import p015ak.C0213f;
import p514o9.C11839m;
import p514o9.C11842p;
import sk.C12809f;

/* renamed from: ae.f */
/* loaded from: classes3.dex */
public class C0121f extends RecyclerView.AbstractC0838h<a> {

    /* renamed from: f */
    public static final String f442f = "f";

    /* renamed from: d */
    public Context f443d;

    /* renamed from: e */
    public List<CloudRecoveryItem> f444e;

    /* renamed from: ae.f$a */
    public static class a extends RecyclerView.AbstractC0833c0 {

        /* renamed from: u */
        public LinearLayout f445u;

        /* renamed from: v */
        public TextView f446v;

        /* renamed from: w */
        public TextView f447w;

        /* renamed from: x */
        public TextView f448x;

        /* renamed from: y */
        public View f449y;

        public a(View view) {
            super(view);
            this.f445u = (LinearLayout) C12809f.m76831d(view, R$id.ll_backup_record);
            this.f446v = (TextView) C12809f.m76831d(view, R$id.tv_record_title);
            this.f447w = (TextView) C12809f.m76831d(view, R$id.tv_record_remind);
            this.f448x = (TextView) C12809f.m76831d(view, R$id.tv_record_time);
            this.f449y = C12809f.m76831d(view, R$id.divider);
        }
    }

    public C0121f(Context context, List<CloudRecoveryItem> list) {
        this.f443d = context;
        this.f444e = list;
    }

    /* renamed from: E */
    public final /* synthetic */ void m781E(int i10, CloudRecoveryItem cloudRecoveryItem, View view) {
        m784H(i10 == 0, cloudRecoveryItem);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public void mo723s(a aVar, final int i10) {
        final CloudRecoveryItem cloudRecoveryItem = this.f444e.get(i10);
        if (cloudRecoveryItem == null) {
            C11839m.m70687e(f442f, "deviceInfo is null");
            return;
        }
        if (i10 == mo721e() - 1) {
            aVar.f449y.setVisibility(8);
        }
        if (i10 == 0) {
            aVar.f447w.setVisibility(8);
            aVar.f446v.setText(R$string.latest_backup_record);
        } else {
            aVar.f447w.setVisibility(0);
            aVar.f446v.setText(R$string.old_backup_record);
        }
        aVar.f448x.setText(DateUtils.formatDateTime(this.f443d, cloudRecoveryItem.getBackupEndTime(), C11842p.m70824j()));
        aVar.f445u.setOnClickListener(new View.OnClickListener() { // from class: ae.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f426a.m781E(i10, cloudRecoveryItem, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: G, reason: merged with bridge method [inline-methods] */
    public a mo724u(ViewGroup viewGroup, int i10) {
        if (this.f443d == null) {
            C11839m.m70687e(f442f, "context is null");
            this.f443d = C0213f.m1377a();
        }
        return new a(LayoutInflater.from(this.f443d).inflate(R$layout.item_backup_clean_record_layout, viewGroup, false));
    }

    /* renamed from: H */
    public final void m784H(boolean z10, CloudRecoveryItem cloudRecoveryItem) {
        if (C0209d.m1226Y0()) {
            C11839m.m70689w(f442f, "click too fast");
            return;
        }
        if (this.f443d != null) {
            Intent intent = new Intent(this.f443d, (Class<?>) BackupCleanRecordsDetailActivity.class);
            intent.putExtra("isLatest", z10);
            intent.putExtra("recordItem", cloudRecoveryItem);
            intent.putExtra("recordDeviceId", cloudRecoveryItem.getRecordDeviceId());
            intent.putExtra(CloudBackupConstant.BACKUP_DEVICE_ID, cloudRecoveryItem.getBackupDeviceId());
            intent.putExtra("version", cloudRecoveryItem.getVersion());
            this.f443d.startActivity(intent);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: e */
    public int mo721e() {
        List<CloudRecoveryItem> list = this.f444e;
        if (list == null) {
            return 0;
        }
        return list.size();
    }
}
