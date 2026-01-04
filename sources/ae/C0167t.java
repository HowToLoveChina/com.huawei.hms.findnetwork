package ae;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.android.hicloud.cloudbackup.bean.BackupOptionFooterDataBean;
import com.huawei.android.hicloud.cloudbackup.service.CloudBackupService;
import com.huawei.android.hicloud.commonlib.view.SpanClickText;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$string;
import p015ak.C0209d;
import p514o9.C11839m;
import sk.C12809f;

/* renamed from: ae.t */
/* loaded from: classes3.dex */
public class C0167t extends RecyclerView.AbstractC0833c0 {

    /* renamed from: u */
    public Context f624u;

    /* renamed from: v */
    public SpanClickText f625v;

    /* renamed from: w */
    public SpanClickText f626w;

    public C0167t(Context context, View view) {
        super(view);
        this.f624u = context;
        SpanClickText spanClickText = (SpanClickText) C12809f.m76831d(view, R$id.tv_cloudbackup_sync_exclusive_tip);
        this.f625v = spanClickText;
        spanClickText.setVisibility(8);
        SpanClickText spanClickText2 = (SpanClickText) C12809f.m76831d(view, R$id.tv_cloudbackup_include_tip);
        this.f626w = spanClickText2;
        spanClickText2.setVisibility(8);
    }

    /* renamed from: Q */
    public static /* synthetic */ void m897Q(SpanClickText spanClickText) {
        if (C0209d.m1226Y0() || spanClickText == null) {
            return;
        }
        C11839m.m70688i("BackupOptionDataFooterHolder", "set BackupSyncExclusiveTip on click");
        CloudBackupService.getInstance().getBackupLinkAddress(3214);
    }

    /* renamed from: R */
    public final void m898R() {
        Context context = this.f624u;
        if (context == null) {
            return;
        }
        String string = context.getString(R$string.cloudbackup_sync_exclusive_tip_learn_more);
        m900T(this.f626w, this.f624u.getString(R$string.cloud_backup_include_tip_new, string), string);
        this.f626w.setVisibility(0);
        this.f625v.setVisibility(8);
    }

    /* renamed from: S */
    public final void m899S() {
        Context context = this.f624u;
        if (context == null) {
            return;
        }
        String string = context.getString(R$string.cloudbackup_sync_exclusive_tip_learn_more);
        m900T(this.f625v, this.f624u.getString(R$string.cloudbackup_sync_app_exclusive_tip, string), string);
        this.f625v.setVisibility(0);
        this.f626w.setVisibility(8);
    }

    /* renamed from: T */
    public final void m900T(final SpanClickText spanClickText, String str, String str2) {
        spanClickText.m15931c(str2, new SpanClickText.ISpanClickListener() { // from class: ae.s
            @Override // com.huawei.android.hicloud.commonlib.view.SpanClickText.ISpanClickListener
            public final void onClick() {
                C0167t.m897Q(spanClickText);
            }
        });
        spanClickText.m15934g(str, false);
    }

    /* renamed from: U */
    public void m901U(BackupOptionFooterDataBean backupOptionFooterDataBean) {
        if (backupOptionFooterDataBean == null) {
            C11839m.m70689w("BackupOptionDataFooterHolder", "updateView, item is null");
            return;
        }
        if (this.f624u == null) {
            C11839m.m70689w("BackupOptionDataFooterHolder", "updateView, context is null");
            return;
        }
        if (backupOptionFooterDataBean.getShowTipsType() == BackupOptionFooterDataBean.FooterType.EXCLUDE_TIP) {
            m898R();
        } else if (backupOptionFooterDataBean.getShowTipsType() == BackupOptionFooterDataBean.FooterType.SYNC_EXCLUSIVE_TIP) {
            m899S();
        } else {
            this.f625v.setVisibility(8);
        }
    }
}
