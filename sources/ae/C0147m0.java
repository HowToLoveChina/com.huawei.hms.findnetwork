package ae;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.android.hicloud.cloudbackup.bean.CloudBackupState;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.hicloud.p088ui.temporarybackup.TempBackupSelectSpaceView;
import com.huawei.android.hicloud.p088ui.views.status.CloudBackupDetailStateView;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.notification.spacelanguage.util.SpaceMultLanguageUtil;
import p015ak.C0223k;
import p514o9.C11839m;
import p847zk.C14317j;
import sk.C12809f;

/* renamed from: ae.m0 */
/* loaded from: classes3.dex */
public class C0147m0 extends RecyclerView.AbstractC0833c0 {

    /* renamed from: u */
    public final CloudBackupDetailStateView f531u;

    /* renamed from: v */
    public final Context f532v;

    /* renamed from: w */
    public int f533w;

    public C0147m0(View view, Context context, String str, boolean z10) {
        super(view);
        this.f533w = 0;
        CloudBackupDetailStateView cloudBackupDetailStateView = (CloudBackupDetailStateView) C12809f.m76831d(view, R$id.cloud_backup_state);
        this.f531u = cloudBackupDetailStateView;
        this.f532v = context;
        cloudBackupDetailStateView.mo25825q(str, z10);
    }

    /* renamed from: P */
    public final String m833P(String str, CloudBackupState cloudBackupState) {
        C11839m.m70688i("CloudBackupStateViewHolder", "getModuleName moduleName = " + str + " uid = " + cloudBackupState.getUid());
        return str;
    }

    /* renamed from: Q */
    public void m834Q() {
        TempBackupSelectSpaceView tempSelectSpaceView = this.f531u.getTempSelectSpaceView();
        if (tempSelectSpaceView != null) {
            tempSelectSpaceView.m24611p(tempSelectSpaceView.getType());
        }
    }

    /* renamed from: R */
    public final void m835R(CloudBackupState cloudBackupState) throws Resources.NotFoundException {
        if (this.f532v == null) {
            C11839m.m70687e("CloudBackupStateViewHolder", "showBackupProgress context null");
            return;
        }
        String displayModule = cloudBackupState.getDisplayModule();
        this.f531u.m25828x(cloudBackupState.getProgress(), this.f532v.getString(R$string.module_progress_tips_no_num_new, m833P(C2783d.m16142g0(displayModule) ? C2783d.m16153k(this.f532v, displayModule) : C2783d.m16079E(this.f532v, displayModule), cloudBackupState)), this.f533w);
    }

    /* renamed from: S */
    public void m836S(CloudBackupState cloudBackupState, int i10) throws Resources.NotFoundException {
        if (cloudBackupState == null) {
            return;
        }
        int iIntValue = cloudBackupState.getState().intValue();
        this.f533w = i10;
        C11839m.m70686d("CloudBackupStateViewHolder", "showBackupState state" + iIntValue + ",itemSize:" + i10);
        if (iIntValue == 1) {
            m840W(cloudBackupState);
            return;
        }
        if (iIntValue == 2) {
            m839V(cloudBackupState);
            return;
        }
        if (iIntValue == 3) {
            m837T();
            return;
        }
        if (iIntValue == 4) {
            m838U(cloudBackupState);
            return;
        }
        if (iIntValue == 5) {
            m840W(cloudBackupState);
            return;
        }
        if (iIntValue == 6) {
            m835R(cloudBackupState);
        } else if (iIntValue == 7) {
            m835R(cloudBackupState);
        } else if (iIntValue == 8) {
            m835R(cloudBackupState);
        }
    }

    /* renamed from: T */
    public final void m837T() {
        if (this.f532v == null) {
            C11839m.m70687e("CloudBackupStateViewHolder", "showDoneState context null");
            return;
        }
        this.f531u.m25829y(this.f532v.getString(R$string.backup_success_size, C0223k.m1524g(this.f532v, C14317j.m85301e(this.f531u.getBackupAction()).m85306g())), this.f533w);
    }

    /* renamed from: U */
    public final void m838U(CloudBackupState cloudBackupState) throws Resources.NotFoundException {
        int intProgress = cloudBackupState.getIntProgress();
        int returnCode = cloudBackupState.getReturnCode();
        C11839m.m70686d("CloudBackupStateViewHolder", "showOverDays progress: " + intProgress + " ,returnCode: " + returnCode);
        if (intProgress == 100 && returnCode == 0) {
            m837T();
        } else {
            m839V(cloudBackupState);
        }
    }

    /* renamed from: V */
    public final void m839V(CloudBackupState cloudBackupState) throws Resources.NotFoundException {
        if (this.f532v == null) {
            C11839m.m70687e("CloudBackupStateViewHolder", "showPauseState context null");
            return;
        }
        this.f531u.setPauseProgress(cloudBackupState.getProgress());
        this.f531u.m25830z(this.f532v.getString(R$string.backup_suspended), cloudBackupState, this.f533w);
    }

    /* renamed from: W */
    public final void m840W(CloudBackupState cloudBackupState) {
        Context context = this.f532v;
        if (context == null) {
            C11839m.m70687e("CloudBackupStateViewHolder", "showPrepareData context null");
            return;
        }
        String string = context.getString(R$string.cloudbackup_prepare_tip, 1, 2);
        if (TextUtils.equals(cloudBackupState.getStatusInPrepare(), "2")) {
            String spaceMultLanguage = SpaceMultLanguageUtil.getSpaceMultLanguage("backup_prepare_resume_data_tip");
            if (!TextUtils.isEmpty(spaceMultLanguage)) {
                string = spaceMultLanguage;
            }
        }
        this.f531u.m25819A(this.f533w, this.f532v.getString(R$string.cloudbackup_prepare_all_data_tip), string, this.f532v.getString(R$string.backup_keep_connect_tip), this.f532v.getString(R$string.backup_loading_tip_background_run));
    }
}
