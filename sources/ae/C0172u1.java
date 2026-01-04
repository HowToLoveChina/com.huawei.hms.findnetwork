package ae;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.android.hicloud.cloudbackup.process.CBAccess;
import com.huawei.android.hicloud.cloudbackup.process.RestoreUtil;
import com.huawei.android.hicloud.cloudbackup.process.util.RestoreAggregatedAppUtil;
import com.huawei.android.hicloud.cloudbackup.process.util.SplitAppUtil;
import com.huawei.android.hicloud.cloudbackup.progress.RestoreProgress;
import com.huawei.android.hicloud.cloudbackup.util.ModuleRestoreResultUtil;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.hicloud.p088ui.activity.RestoreMainActivity;
import com.huawei.android.hicloud.p088ui.uilistener.OnRestoreItemClickListener;
import com.huawei.android.hicloud.p088ui.views.CheckMarkView;
import com.huawei.android.hicloud.p088ui.views.CircleProgressView;
import com.huawei.android.p073ds.R$color;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$plurals;
import com.huawei.android.p073ds.R$string;
import com.huawei.fastengine.fastview.NavigationUtils;
import com.huawei.hicloud.cloudbackup.model.C4868b;
import com.huawei.hicloud.cloudbackup.model.CloudRestoreItem;
import com.huawei.hicloud.cloudbackup.p104v3.core.module.nextrestore.nextmodule.NextRestoreConstants;
import com.huawei.uikit.phone.hwprogressbar.widget.HwProgressBar;
import java.util.ArrayList;
import java.util.List;
import p015ak.C0234s;
import p514o9.C11839m;
import p514o9.C11842p;
import p709vj.C13452e;
import p783xp.C13843a;
import p848zl.C14333b;
import sk.C12809f;

/* renamed from: ae.u1 */
/* loaded from: classes3.dex */
public class C0172u1 extends RecyclerView.AbstractC0838h<RecyclerView.AbstractC0833c0> {

    /* renamed from: d */
    public List<C4868b> f654d;

    /* renamed from: e */
    public Context f655e;

    /* renamed from: f */
    public Resources f656f;

    /* renamed from: g */
    public OnRestoreItemClickListener f657g;

    /* renamed from: ae.u1$a */
    public static class a extends RecyclerView.AbstractC0833c0 {

        /* renamed from: u */
        public TextView f658u;

        public a(View view) {
            super(view);
            this.f658u = (TextView) view.findViewById(R$id.restore_header_tv);
        }
    }

    /* renamed from: ae.u1$b */
    public static class b extends RecyclerView.AbstractC0833c0 {

        /* renamed from: A */
        public CheckMarkView f659A;

        /* renamed from: B */
        public TextView f660B;

        /* renamed from: C */
        public TextView f661C;

        /* renamed from: D */
        public HwProgressBar f662D;

        /* renamed from: E */
        public RelativeLayout f663E;

        /* renamed from: F */
        public ImageView f664F;

        /* renamed from: G */
        public TextView f665G;

        /* renamed from: H */
        public TextView f666H;

        /* renamed from: I */
        public View f667I;

        /* renamed from: u */
        public RelativeLayout f668u;

        /* renamed from: v */
        public ImageView f669v;

        /* renamed from: w */
        public ImageView f670w;

        /* renamed from: x */
        public ImageView f671x;

        /* renamed from: y */
        public RelativeLayout f672y;

        /* renamed from: z */
        public CircleProgressView f673z;

        public b(View view) {
            super(view);
            this.f668u = (RelativeLayout) C12809f.m76831d(view, R$id.backup_content_item);
            this.f672y = (RelativeLayout) C12809f.m76831d(view, R$id.rl_success);
            this.f673z = (CircleProgressView) C12809f.m76831d(view, R$id.bc_circle_progress_view);
            this.f659A = (CheckMarkView) C12809f.m76831d(view, R$id.check_mark_view);
            this.f662D = (HwProgressBar) C12809f.m76831d(view, R$id.item_progress);
            this.f663E = (RelativeLayout) C12809f.m76831d(view, R$id.restore_right_layout);
            this.f664F = (ImageView) C12809f.m76831d(view, R$id.expandable_iv);
            this.f666H = (TextView) C12809f.m76831d(view, R$id.appid_tv);
            this.f665G = (TextView) C12809f.m76831d(view, R$id.app_size_tv);
            this.f660B = (TextView) C12809f.m76831d(view, R$id.count_tv);
            this.f661C = (TextView) C12809f.m76831d(view, R$id.child_desc_tv);
            this.f669v = (ImageView) C12809f.m76831d(view, R$id.manage_item_icon);
            this.f670w = (ImageView) C12809f.m76831d(view, R$id.manage_item_icon_badge);
            this.f671x = (ImageView) C12809f.m76831d(view, R$id.fail_image);
            this.f667I = C12809f.m76831d(view, R$id.list_item_divider);
        }
    }

    /* renamed from: ae.u1$c */
    public static class c extends RecyclerView.AbstractC0833c0 {
        public c(View view) {
            super(view);
        }
    }

    public C0172u1(Context context, List<C4868b> list) {
        this.f654d = new ArrayList();
        if (context != null) {
            this.f656f = context.getResources();
        }
        this.f654d = list;
        this.f655e = context;
    }

    /* renamed from: F */
    public static long m935F(CloudRestoreItem cloudRestoreItem, long j10) {
        long jMin = Math.min(cloudRestoreItem.getBytesDownloaded(), j10);
        if (cloudRestoreItem.m29202r() == null || cloudRestoreItem.m29202r().size() == 0) {
            return jMin;
        }
        String appId = cloudRestoreItem.getAppId();
        return (NavigationUtils.SMS_SCHEMA_PREF.equals(appId) || "chatSms".equals(appId) || "soundrecorder".equals(appId) || "callRecorder".equals(appId) || cloudRestoreItem.m29190O()) ? Math.min(cloudRestoreItem.m29202r().stream().filter(new C0166s1()).mapToLong(new C0169t1()).sum(), j10) : jMin;
    }

    /* renamed from: I */
    private String m936I(CloudRestoreItem cloudRestoreItem) {
        return RestoreUtil.getRestoreItemName(cloudRestoreItem);
    }

    /* renamed from: J */
    public static long m937J(CloudRestoreItem cloudRestoreItem) {
        long size;
        long asize;
        if (cloudRestoreItem.isHarmonyNext()) {
            return cloudRestoreItem.getSize();
        }
        if (cloudRestoreItem.getBmAppDataType() == 2) {
            size = cloudRestoreItem.getSize();
            asize = cloudRestoreItem.getAsize();
        } else {
            if (1 == cloudRestoreItem.getAction() || TextUtils.equals(cloudRestoreItem.m29203s(), "thirdApp")) {
                return cloudRestoreItem.getAsize();
            }
            if (TextUtils.equals(cloudRestoreItem.m29203s(), "thirdAppData")) {
                return cloudRestoreItem.getSize();
            }
            size = cloudRestoreItem.getSize();
            asize = cloudRestoreItem.getAsize();
        }
        return size + asize;
    }

    /* renamed from: M */
    private void m938M(Context context, TextView textView) {
        if (C0234s.m1643u()) {
            textView.setPadding(0, 0, 0, (int) C11842p.m70844o(context, 6));
        }
    }

    /* renamed from: E */
    public final boolean m939E(CloudRestoreItem cloudRestoreItem) {
        return (cloudRestoreItem == null || cloudRestoreItem.m29202r() == null || (cloudRestoreItem.m29202r().size() <= 1 && !"thirdApp".equals(cloudRestoreItem.getAppId()))) ? false : true;
    }

    /* renamed from: G */
    public final long m940G(long j10, boolean z10, CloudRestoreItem cloudRestoreItem) {
        if (cloudRestoreItem.getBmAppDataType() == 2) {
            return Math.min(j10, cloudRestoreItem.getBytesDownloadedFiles() + cloudRestoreItem.getBytesDownloadedApp());
        }
        return Math.min(j10, z10 ? cloudRestoreItem.getBytesDownloadedFiles() : cloudRestoreItem.getBytesDownloadedApp());
    }

    /* renamed from: H */
    public final String m941H(CloudRestoreItem cloudRestoreItem) {
        return cloudRestoreItem.getAppId().equals(NextRestoreConstants.BUNDLE_NAME_GALLERY) ? "com.huawei.hmos.photos" : cloudRestoreItem.getAppId().equals("com.huawei.hmos.meetimeservice") ? "com.huawei.hmos.meetime" : cloudRestoreItem.getAppId().equals("com.huawei.hmos.callrecorder") ? "com.huawei.hmos.soundrecorder" : cloudRestoreItem.getAppId().equals("com.huawei.hmos.calendardata") ? "com.huawei.hmos.calendar" : cloudRestoreItem.getAppId().equals("com.ohos.telephonydataability") ? "com.ohos.mms" : cloudRestoreItem.getAppId();
    }

    /* renamed from: K */
    public final String m942K(int i10, int i11) {
        return this.f656f.getString(R$string.restore_new_completed_part, this.f656f.getQuantityString(R$plurals.backup_backed_total, i10, Integer.valueOf(i10), Integer.valueOf(i11)).replace(String.valueOf(i10), C13843a.m83104z(Integer.valueOf(i10))).replace(String.valueOf(i11), C13843a.m83104z(Integer.valueOf(i11))));
    }

    /* renamed from: L */
    public final long m943L(boolean z10, CloudRestoreItem cloudRestoreItem) {
        return cloudRestoreItem.isHarmonyNext() ? cloudRestoreItem.getSize() : cloudRestoreItem.getBmAppDataType() == 2 ? cloudRestoreItem.getSize() + cloudRestoreItem.getAsize() : z10 ? cloudRestoreItem.getSize() : cloudRestoreItem.getAsize();
    }

    /* renamed from: N */
    public final boolean m944N(CloudRestoreItem cloudRestoreItem) {
        return (cloudRestoreItem == null || "thirdApp".equals(cloudRestoreItem.getAppId()) || cloudRestoreItem.m29202r() == null || cloudRestoreItem.m29202r().size() != 1) ? false : true;
    }

    /* renamed from: O */
    public final boolean m945O(CloudRestoreItem cloudRestoreItem) {
        if (cloudRestoreItem == null) {
            return false;
        }
        return new ArrayList(C14333b.m85452H()).contains(cloudRestoreItem.getAppId());
    }

    /* renamed from: P */
    public final /* synthetic */ void m946P(CloudRestoreItem cloudRestoreItem, View view) {
        OnRestoreItemClickListener onRestoreItemClickListener = this.f657g;
        if (onRestoreItemClickListener != null) {
            onRestoreItemClickListener.mo22111a(cloudRestoreItem);
        }
    }

    /* renamed from: Q */
    public final boolean m947Q(CloudRestoreItem cloudRestoreItem) {
        return ("doc".equals(cloudRestoreItem.getAppId()) || "doc1".equals(cloudRestoreItem.getAppId())) ? false : true;
    }

    /* renamed from: R */
    public void m948R(List<C4868b> list) {
        List<C4868b> list2 = this.f654d;
        if (list2 != null) {
            list2.clear();
        }
        if (list != null) {
            this.f654d = list;
            m5213j();
        }
    }

    /* renamed from: S */
    public final void m949S(b bVar) {
        bVar.f663E.setVisibility(8);
        bVar.f662D.setVisibility(8);
        bVar.f665G.setVisibility(8);
        bVar.f661C.setVisibility(8);
        bVar.f660B.setText(this.f655e.getString(R$string.cloudbackup_restore_cancel));
        bVar.f660B.setTextColor(this.f656f.getColor(R$color.emui_color_gray_7));
    }

    /* renamed from: T */
    public final void m950T(b bVar, CloudRestoreItem cloudRestoreItem) {
        bVar.f663E.setVisibility(8);
        bVar.f662D.setVisibility(8);
        bVar.f665G.setVisibility(8);
        bVar.f661C.setVisibility(8);
        bVar.f660B.setTextColor(this.f656f.getColor(R$color.emui_color_gray_7));
        int count = cloudRestoreItem.getCount();
        int current = cloudRestoreItem.getCurrent();
        C11839m.m70686d("NewBmRestoreModuleAdapter", "restoreDefault appId" + cloudRestoreItem.getAppId() + " isSystemShowModule =" + cloudRestoreItem.isSystemShowModule() + " restoreItem.isVirtual() =" + cloudRestoreItem.isVirtual());
        if (cloudRestoreItem.isSystemShowModule()) {
            if (count > 0) {
                bVar.f660B.setText(ModuleRestoreResultUtil.getWaitingTips(this.f655e, cloudRestoreItem, count, this.f655e.getString(R$string.cloudbackup_backupmedia_tip, C13843a.m83104z(Integer.valueOf(current)), C13843a.m83104z(Integer.valueOf(count)))));
            } else {
                bVar.f660B.setText(this.f655e.getString(R$string.restore_new_wait_2));
            }
        } else if (cloudRestoreItem.isVirtual() || cloudRestoreItem.is3rdAppType() || count == 0) {
            bVar.f660B.setText(this.f655e.getString(R$string.restore_new_wait_2));
        } else {
            bVar.f660B.setText(ModuleRestoreResultUtil.getWaitingTips(this.f655e, cloudRestoreItem, count, this.f655e.getString(R$string.cloudbackup_backupmedia_tip, C13843a.m83104z(Integer.valueOf(current)), C13843a.m83104z(Integer.valueOf(count)))));
        }
        if (cloudRestoreItem.isShowChildList() || !RestoreAggregatedAppUtil.isShowAggregatedDialog(cloudRestoreItem)) {
            return;
        }
        bVar.f672y.setVisibility(8);
        m960d0(bVar, cloudRestoreItem, false);
    }

    /* renamed from: U */
    public final void m951U(b bVar, String str, CloudRestoreItem cloudRestoreItem) throws Resources.NotFoundException {
        bVar.f671x.setVisibility(8);
        bVar.f661C.setVisibility(8);
        String appId = cloudRestoreItem.getAppId();
        int current = cloudRestoreItem.getCurrent();
        int count = cloudRestoreItem.getCount();
        if ("thirdApp".equals(appId)) {
            bVar.f663E.setVisibility(8);
            int i10 = count - current;
            if (i10 < 0) {
                current = 0;
            } else {
                count = i10;
            }
            if (current > 0) {
                bVar.f660B.setText(this.f655e.getString(R$string.restore_item_restore_part_completed));
            } else {
                bVar.f660B.setText(this.f655e.getString(R$string.restore_failed));
            }
            bVar.f665G.setText(this.f656f.getQuantityString(R$plurals.restore_item_restoration_failed, count, Integer.valueOf(count)).replace(String.valueOf(count), C13843a.m83104z(Integer.valueOf(count))));
            bVar.f665G.setVisibility(0);
        } else if ("sysdata".equals(appId)) {
            bVar.f663E.setVisibility(8);
            int count2 = cloudRestoreItem.getCount() - current;
            if (count2 < 0) {
                count2 = cloudRestoreItem.getCount();
                current = 0;
            }
            bVar.f660B.setText(this.f656f.getString(R$string.restore_new_completed_part, this.f656f.getQuantityString(R$plurals.backup_backed_total, current, Integer.valueOf(current), Integer.valueOf(count)).replace(String.valueOf(current), C13843a.m83104z(Integer.valueOf(current))).replace(String.valueOf(count), C13843a.m83104z(Integer.valueOf(count)))));
            bVar.f665G.setText(this.f656f.getQuantityString(R$plurals.restore_new_failure_part_data, count2, Integer.valueOf(count2)).replace(String.valueOf(count2), C13843a.m83104z(Integer.valueOf(count2))));
            bVar.f665G.setVisibility(0);
        } else {
            m960d0(bVar, cloudRestoreItem, true);
            bVar.f665G.setVisibility(8);
            if (cloudRestoreItem.m29202r() == null || cloudRestoreItem.m29202r().size() <= 1) {
                bVar.f660B.setText(str);
            } else {
                bVar.f660B.setText(this.f655e.getString(R$string.restore_completed_not_succeed));
            }
        }
        bVar.f662D.setVisibility(8);
        bVar.f672y.setVisibility(8);
        bVar.f660B.setTextColor(this.f656f.getColor(R$color.emui_color_gray_7));
    }

    /* renamed from: V */
    public final void m952V(b bVar, CloudRestoreItem cloudRestoreItem) throws Resources.NotFoundException {
        bVar.f663E.setVisibility(8);
        bVar.f661C.setVisibility(8);
        bVar.f660B.setTextColor(this.f656f.getColor(R$color.emui_color_gray_7));
        int count = cloudRestoreItem.getCount();
        int current = cloudRestoreItem.getCurrent();
        if (cloudRestoreItem.is3rdAppType() && !cloudRestoreItem.isShowChildList()) {
            bVar.f665G.setVisibility(8);
            if (m944N(cloudRestoreItem)) {
                bVar.f660B.setText(ModuleRestoreResultUtil.getRestoreResultTips(this.f655e, cloudRestoreItem.m29202r().get(0)));
            } else {
                bVar.f660B.setText(this.f655e.getString(R$string.restore_completed_not_succeed));
            }
        } else if (cloudRestoreItem.isShowChildList()) {
            bVar.f660B.setText(this.f656f.getString(R$string.restore_new_completed_part, this.f656f.getQuantityString(R$plurals.backup_backed_total, current, Integer.valueOf(current), Integer.valueOf(count)).replace(String.valueOf(current), C13843a.m83104z(Integer.valueOf(current))).replace(String.valueOf(count), C13843a.m83104z(Integer.valueOf(count)))));
            int i10 = count - current;
            bVar.f665G.setText(this.f656f.getQuantityString(R$plurals.restore_new_failure_part_data, i10, Integer.valueOf(i10)).replace(String.valueOf(i10), C13843a.m83104z(Integer.valueOf(i10))));
            bVar.f665G.setVisibility(0);
        } else if (count < current || cloudRestoreItem.isVirtual()) {
            bVar.f665G.setVisibility(8);
            if (m944N(cloudRestoreItem)) {
                bVar.f660B.setText(ModuleRestoreResultUtil.getRestoreResultTips(this.f655e, cloudRestoreItem.m29202r().get(0)));
            } else {
                bVar.f660B.setText(this.f655e.getString(R$string.restore_completed_not_succeed));
            }
        } else {
            if (m944N(cloudRestoreItem)) {
                bVar.f660B.setText(ModuleRestoreResultUtil.getRestoreResultTips(this.f655e, cloudRestoreItem.m29202r().get(0)));
            } else if (current > 0) {
                bVar.f660B.setText(this.f655e.getString(R$string.restore_completed_not_succeed_part));
            } else {
                bVar.f660B.setText(this.f655e.getString(R$string.restore_completed_not_succeed));
            }
            bVar.f665G.setVisibility(8);
        }
        bVar.f672y.setVisibility(8);
        bVar.f662D.setVisibility(8);
        if (cloudRestoreItem.isShowChildList()) {
            m960d0(bVar, cloudRestoreItem, false);
        } else {
            m960d0(bVar, cloudRestoreItem, true);
        }
    }

    /* renamed from: W */
    public final void m953W(b bVar, CloudRestoreItem cloudRestoreItem) {
        bVar.f663E.setVisibility(8);
        bVar.f662D.setVisibility(8);
        bVar.f665G.setVisibility(8);
        bVar.f661C.setVisibility(8);
        bVar.f660B.setText(this.f655e.getString(R$string.restore_item_restore_paused));
        bVar.f660B.setTextColor(this.f656f.getColor(R$color.emui_color_gray_7));
        if (cloudRestoreItem.isShowChildList() || !RestoreAggregatedAppUtil.isShowAggregatedDialog(cloudRestoreItem)) {
            return;
        }
        bVar.f672y.setVisibility(8);
        m960d0(bVar, cloudRestoreItem, false);
    }

    /* renamed from: X */
    public final void m954X(b bVar, CloudRestoreItem cloudRestoreItem) throws Resources.NotFoundException {
        bVar.f663E.setVisibility(8);
        bVar.f661C.setVisibility(8);
        bVar.f660B.setTextColor(this.f656f.getColor(R$color.emui_color_gray_7));
        int count = cloudRestoreItem.getCount();
        int current = cloudRestoreItem.getCurrent();
        if (cloudRestoreItem.isShowChildList()) {
            bVar.f660B.setText(this.f656f.getString(R$string.restore_new_completed_part, this.f656f.getQuantityString(R$plurals.backup_backed_total, current, Integer.valueOf(current), Integer.valueOf(count)).replace(String.valueOf(current), C13843a.m83104z(Integer.valueOf(current))).replace(String.valueOf(count), C13843a.m83104z(Integer.valueOf(count)))));
            int i10 = count - current;
            bVar.f665G.setText(this.f656f.getQuantityString(R$plurals.restore_new_failure_part_data, i10, Integer.valueOf(i10)).replace(String.valueOf(i10), C13843a.m83104z(Integer.valueOf(i10))));
            bVar.f665G.setVisibility(0);
        } else {
            if (m944N(cloudRestoreItem)) {
                bVar.f660B.setText(ModuleRestoreResultUtil.getRestoreResultTips(this.f655e, cloudRestoreItem.m29202r().get(0)));
            } else if (current <= 0 || count <= 0) {
                bVar.f660B.setText(this.f655e.getString(R$string.restore_failed));
            } else {
                bVar.f660B.setText(this.f655e.getString(R$string.restore_partial_fail));
            }
            bVar.f665G.setVisibility(8);
        }
        bVar.f672y.setVisibility(8);
        bVar.f662D.setVisibility(8);
        if (cloudRestoreItem.isShowChildList()) {
            m960d0(bVar, cloudRestoreItem, false);
        } else {
            m960d0(bVar, cloudRestoreItem, true);
        }
    }

    /* renamed from: Y */
    public final void m955Y(b bVar, CloudRestoreItem cloudRestoreItem) {
        String strReplace;
        if ("sysdata".equals(cloudRestoreItem.getAppId())) {
            bVar.f663E.setVisibility(8);
        } else {
            bVar.f663E.setVisibility(0);
        }
        m963g0(bVar);
        bVar.f665G.setVisibility(8);
        bVar.f662D.setVisibility(8);
        bVar.f661C.setVisibility(8);
        bVar.f660B.setTextColor(this.f656f.getColor(R$color.emui_color_gray_7));
        int current = cloudRestoreItem.getCurrent();
        int count = cloudRestoreItem.getCount();
        C11839m.m70688i("NewBmRestoreModuleAdapter", "restoreSuccess appid = " + cloudRestoreItem.getAppId() + " count = " + count + " appType" + cloudRestoreItem.getAppType() + " current = " + current);
        if ("thirdApp".equals(cloudRestoreItem.getAppId())) {
            bVar.f660B.setText(m942K(current, count));
            return;
        }
        if ((cloudRestoreItem.isSystemShowModule() && current == 0) || (cloudRestoreItem.isVirtual() && m947Q(cloudRestoreItem))) {
            bVar.f660B.setText(this.f655e.getString(R$string.restore_new_completed));
            return;
        }
        if (cloudRestoreItem.is3rdAppType()) {
            bVar.f660B.setText(this.f655e.getString(R$string.restore_new_completed));
            if (cloudRestoreItem.getAction() == 1) {
                bVar.f660B.setText(this.f655e.getString(R$string.cloudbackup_app_restore_failed_no_retry));
                return;
            }
            return;
        }
        if ("sysdata".equals(cloudRestoreItem.getAppId())) {
            strReplace = m942K(current, count);
        } else {
            if (current == 0 || !m945O(cloudRestoreItem)) {
                bVar.f660B.setText(this.f655e.getString(R$string.restore_new_completed));
                return;
            }
            strReplace = this.f656f.getQuantityString(R$plurals.restore_new_completed_part_2, current, Integer.valueOf(current)).replace(String.valueOf(current), C13843a.m83104z(Integer.valueOf(current)));
        }
        bVar.f660B.setText(strReplace);
    }

    /* renamed from: Z */
    public final void m956Z(b bVar, CloudRestoreItem cloudRestoreItem) throws Resources.NotFoundException {
        if (!CBAccess.inRestoreTask()) {
            C11839m.m70686d("NewBmRestoreModuleAdapter", "restoring not in restoreTask");
            m952V(bVar, cloudRestoreItem);
            return;
        }
        if ("sysdata".equals(cloudRestoreItem.getAppId()) || cloudRestoreItem.m29202r() == null || cloudRestoreItem.m29202r().size() <= 1 || "thirdApp".equals(cloudRestoreItem.getAppId())) {
            bVar.f661C.setVisibility(8);
        } else {
            bVar.f661C.setVisibility(0);
        }
        bVar.f663E.setVisibility(0);
        if (bVar.f662D.getVisibility() != 0) {
            bVar.f662D.setVisibility(0);
            bVar.f662D.setFlickerEnable(true);
        }
        bVar.f671x.setVisibility(8);
        bVar.f665G.setVisibility(8);
        bVar.f672y.setVisibility(8);
        if (!"sysdata".equals(cloudRestoreItem.getAppId()) && cloudRestoreItem.m29202r() != null && cloudRestoreItem.m29202r().size() > 1) {
            if ("thirdApp".equals(cloudRestoreItem.getAppId())) {
                m958b0(bVar.f660B, cloudRestoreItem, false);
                return;
            } else {
                m958b0(bVar.f660B, cloudRestoreItem.m29202r().get(0), true);
                m958b0(bVar.f661C, cloudRestoreItem.m29202r().get(1), true);
                return;
            }
        }
        if ("sysdata".equals(cloudRestoreItem.getAppId()) || !m944N(cloudRestoreItem)) {
            m958b0(bVar.f660B, cloudRestoreItem, false);
        } else if ("thirdApp".equals(cloudRestoreItem.getAppId())) {
            m958b0(bVar.f660B, cloudRestoreItem, false);
        } else {
            m958b0(bVar.f660B, cloudRestoreItem.m29202r().get(0), false);
        }
    }

    /* renamed from: a0 */
    public final String m957a0(CloudRestoreItem cloudRestoreItem) {
        if (RestoreProgress.isPrepare(cloudRestoreItem.getSubStatus())) {
            return this.f655e.getString(R$string.cloudbackup_prepare_data);
        }
        cloudRestoreItem.getCurrent();
        int status = cloudRestoreItem.getStatus();
        boolean zEquals = TextUtils.equals("thirdAppData", cloudRestoreItem.m29203s());
        long jM943L = m943L(zEquals, cloudRestoreItem);
        long jM940G = m940G(jM943L, zEquals, cloudRestoreItem);
        if (status == 3) {
            return this.f655e.getString(R$string.restore_new_wait_2);
        }
        if (status == 4) {
            Context context = this.f655e;
            return context.getString(R$string.cloudbackup_restore_downloading_data_size, RestoreProgress.formatData(context, jM940G), RestoreProgress.formatData(this.f655e, jM943L));
        }
        if (status == 5) {
            if (jM943L == jM940G) {
                return this.f655e.getString(R$string.restore_new_wait_for_installation);
            }
            Context context2 = this.f655e;
            return context2.getString(R$string.cloudbackup_restore_downloading_data_size, RestoreProgress.formatData(context2, jM940G), RestoreProgress.formatData(this.f655e, jM943L));
        }
        if (status == 6) {
            return this.f655e.getString(R$string.restore_new_installing);
        }
        if (status != 7) {
            return "";
        }
        if (cloudRestoreItem.getSize() == 0) {
            return this.f655e.getString(R$string.restoring_data);
        }
        long jMin = Math.min(cloudRestoreItem.getPmsAlreadyBytes(), cloudRestoreItem.getSize());
        Context context3 = this.f655e;
        return context3.getString(R$string.restore_import_data_size, RestoreProgress.formatData(context3, jMin), RestoreProgress.formatData(this.f655e, cloudRestoreItem.getSize()));
    }

    /* renamed from: b0 */
    public final void m958b0(TextView textView, CloudRestoreItem cloudRestoreItem, boolean z10) {
        String string;
        int count = cloudRestoreItem.getCount();
        int iMin = Math.min(cloudRestoreItem.getCurrent(), count);
        long jM937J = m937J(cloudRestoreItem);
        long jM935F = m935F(cloudRestoreItem, jM937J);
        if (!ModuleRestoreResultUtil.isModuleRestoring(cloudRestoreItem)) {
            string = ModuleRestoreResultUtil.getRestoreResultTips(this.f655e, cloudRestoreItem);
        } else if (C14333b.m85486u().containsKey(cloudRestoreItem.getAppId()) || cloudRestoreItem.isShowRestoreProgressTotal() || cloudRestoreItem.isHarmonyNext()) {
            String string2 = this.f655e.getString(R$string.cloudbackup_backupmedia_tip, C13843a.m83104z(Integer.valueOf(iMin)), C13843a.m83104z(Integer.valueOf(count)));
            if (count <= 0 && jM937J <= 0) {
                string = this.f655e.getString(R$string.main_cloudrestoring);
            } else if (RestoreProgress.isPrepare(cloudRestoreItem.getSubStatus())) {
                string = this.f655e.getString(R$string.cloudbackup_prepare_data);
            } else {
                int status = cloudRestoreItem.getStatus();
                if (status != 4 && status != 5) {
                    string = (!"sysdata".equals(cloudRestoreItem.getAppId()) && cloudRestoreItem.isHarmonyNext() && status == 7) ? this.f655e.getString(R$string.main_cloudrestoring) : this.f655e.getString(R$string.restore_import_data, string2);
                } else if (jM937J > 0) {
                    Context context = this.f655e;
                    string = context.getString(R$string.cloudbackup_restore_downloading_data_size, RestoreProgress.formatData(context, jM935F), RestoreProgress.formatData(this.f655e, jM937J));
                } else {
                    string = this.f655e.getString(R$string.cloudbackup_restore_downloading_2, C13843a.m83104z(Integer.valueOf(iMin)), C13843a.m83104z(Integer.valueOf(count)));
                }
            }
        } else if (cloudRestoreItem.m29187M() || cloudRestoreItem.getUid() != 0) {
            string = m957a0(cloudRestoreItem);
        } else if (jM937J > 0) {
            Context context2 = this.f655e;
            string = context2.getString(R$string.cloudbackup_restore_downloading_data_size, RestoreProgress.formatData(context2, jM935F), RestoreProgress.formatData(this.f655e, jM937J));
        } else {
            string = count > 0 ? this.f655e.getString(R$string.cloudbackup_downloading, C2783d.m16075C(iMin)) : this.f655e.getString(R$string.main_cloudrestoring);
        }
        if (z10) {
            Context context3 = this.f655e;
            textView.setText(context3.getString(R$string.connect_string_colon, RestoreAggregatedAppUtil.getAppName(context3, cloudRestoreItem), string));
        } else {
            textView.setText(string);
        }
        textView.setTextColor(this.f656f.getColor(R$color.emui_color_gray_7));
    }

    /* renamed from: c0 */
    public final void m959c0(int i10, View view, int i11) {
        Object tag = view.getTag(i10);
        if (tag == null || ((Integer) tag).intValue() != i11) {
            C11839m.m70688i("NewBmRestoreModuleAdapter", "itemViewHolder setBackgroundPic");
            view.setBackgroundResource(i10);
            view.setTag(i10, Integer.valueOf(i11));
        }
    }

    /* renamed from: d0 */
    public final void m960d0(b bVar, CloudRestoreItem cloudRestoreItem, boolean z10) {
        if (!m939E(cloudRestoreItem)) {
            if (z10) {
                bVar.f663E.setVisibility(0);
                bVar.f671x.setVisibility(0);
                bVar.f664F.setVisibility(8);
                return;
            }
            return;
        }
        int iM80916g0 = C13452e.m80781L().m80916g0();
        if (iM80916g0 == 0 || iM80916g0 == 1) {
            return;
        }
        bVar.f663E.setVisibility(8);
        bVar.f671x.setVisibility(8);
        bVar.f664F.setVisibility(0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: e */
    public int mo721e() {
        return this.f654d.size();
    }

    /* renamed from: e0 */
    public void m961e0(OnRestoreItemClickListener onRestoreItemClickListener) {
        this.f657g = onRestoreItemClickListener;
    }

    /* renamed from: f0 */
    public final void m962f0(b bVar, CloudRestoreItem cloudRestoreItem) throws Resources.NotFoundException {
        int status = cloudRestoreItem.getStatus();
        String appId = cloudRestoreItem.getAppId();
        String strM22100u2 = ((RestoreMainActivity) this.f655e).m22100u2(appId);
        if (!strM22100u2.equals("")) {
            bVar.f663E.setVisibility(8);
            bVar.f665G.setVisibility(8);
            bVar.f660B.setText(this.f655e.getString(R$string.hicloud_restore_permission_disabled, strM22100u2));
            bVar.f660B.setTextColor(this.f656f.getColor(R$color.emui_functional_red));
        }
        C11839m.m70688i("NewBmRestoreModuleAdapter", "buildView appId " + appId + " statue " + cloudRestoreItem.getStatus() + " type = " + cloudRestoreItem.getType());
        switch (status) {
            case -8:
                m951U(bVar, this.f655e.getString(R$string.restoring_failed_by_module_deleted), cloudRestoreItem);
                break;
            case -7:
                m951U(bVar, this.f655e.getString(R$string.restore_safebox_unsupport_tip), cloudRestoreItem);
                break;
            case -6:
                m951U(bVar, this.f655e.getString(R$string.item_app_not_compatible), cloudRestoreItem);
                break;
            case -5:
                m951U(bVar, this.f655e.getString(R$string.item_app_no_exist), cloudRestoreItem);
                break;
            case -4:
                m951U(bVar, this.f655e.getString(R$string.item_hm_un_support_tip), cloudRestoreItem);
                break;
            case -3:
                if (!RestoreUtil.isHiCreatePromptNotSupportRestore(cloudRestoreItem)) {
                    m951U(bVar, this.f655e.getString(R$string.item_clone_un_support_tip), cloudRestoreItem);
                    break;
                } else {
                    m951U(bVar, this.f655e.getString(R$string.restore_new_recovery_not_supported), cloudRestoreItem);
                    break;
                }
            case -2:
                m951U(bVar, this.f655e.getString(R$string.item_app_foreground_tip), cloudRestoreItem);
                break;
            case -1:
                int i10 = R$string.restore_new_recovery_not_supported;
                if (cloudRestoreItem.is3rdAppType() && cloudRestoreItem.m29187M()) {
                    i10 = R$string.cloudbackup_app_restore_failed_no_retry;
                }
                m951U(bVar, this.f655e.getString(i10), cloudRestoreItem);
                break;
            case 0:
                m950T(bVar, cloudRestoreItem);
                break;
            case 1:
                m949S(bVar);
                break;
            case 2:
                m953W(bVar, cloudRestoreItem);
                break;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                m956Z(bVar, cloudRestoreItem);
                break;
            case 8:
                if (cloudRestoreItem.getType() != 1) {
                    int iM80916g0 = C13452e.m80781L().m80916g0();
                    C11839m.m70688i("NewBmRestoreModuleAdapter", "buildView appId :restoreStatus" + iM80916g0);
                    if (iM80916g0 != 5 && iM80916g0 != 8) {
                        m952V(bVar, cloudRestoreItem);
                        break;
                    } else {
                        m954X(bVar, cloudRestoreItem);
                        break;
                    }
                } else {
                    m955Y(bVar, cloudRestoreItem);
                    break;
                }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: g */
    public int mo749g(int i10) {
        List<C4868b> list = this.f654d;
        if (list == null || list.isEmpty() || i10 >= this.f654d.size()) {
            return 2;
        }
        return this.f654d.get(i10).m29224c();
    }

    /* renamed from: g0 */
    public final void m963g0(b bVar) {
        bVar.f671x.setVisibility(8);
        bVar.f672y.setVisibility(0);
        bVar.f659A.setVisibility(0);
        bVar.f659A.m25691f();
        bVar.f659A.m25692g();
        bVar.f673z.setVisibility(0);
        bVar.f673z.setProgress(100);
    }

    /* renamed from: h0 */
    public void m964h0(CloudRestoreItem cloudRestoreItem) {
        List<C4868b> list = this.f654d;
        if (list == null || list.isEmpty() || cloudRestoreItem == null) {
            return;
        }
        for (int i10 = 0; i10 < this.f654d.size(); i10++) {
            C4868b c4868b = this.f654d.get(i10);
            CloudRestoreItem cloudRestoreItemM29222a = c4868b.m29222a();
            if (cloudRestoreItemM29222a != null && TextUtils.equals(cloudRestoreItemM29222a.getAppId(), cloudRestoreItem.getAppId())) {
                this.f654d.set(i10, c4868b);
                m5214k(i10);
                return;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: s */
    public void mo723s(RecyclerView.AbstractC0833c0 abstractC0833c0, int i10) throws Resources.NotFoundException {
        if (i10 < 0 || i10 >= this.f654d.size()) {
            return;
        }
        C4868b c4868b = this.f654d.get(i10);
        if (this.f656f == null || c4868b == null) {
            return;
        }
        if (c4868b.m29224c() == 0) {
            a aVar = (a) abstractC0833c0;
            aVar.f658u.setText(this.f654d.get(i10).m29223b());
            aVar.f658u.setBackgroundResource(R$drawable.cardview_list_top_shape_white);
            return;
        }
        if (c4868b.m29224c() == 2) {
            return;
        }
        if (c4868b.m29224c() == 1 || c4868b.m29224c() == 3) {
            b bVar = (b) abstractC0833c0;
            final CloudRestoreItem cloudRestoreItemM29222a = c4868b.m29222a();
            if (cloudRestoreItemM29222a == null) {
                C11839m.m70688i("NewBmRestoreModuleAdapter", "onBindViewHolder, restoreItem is null, position = " + i10);
                return;
            }
            bVar.f668u.setOnClickListener(new View.OnClickListener() { // from class: ae.r1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f621a.m946P(cloudRestoreItemM29222a, view);
                }
            });
            String strM941H = m941H(cloudRestoreItemM29222a);
            if (SplitAppUtil.hasSplitAppSuffix(strM941H)) {
                bVar.f670w.setVisibility(0);
                strM941H = SplitAppUtil.getSplitOriAppId(strM941H);
            } else {
                bVar.f670w.setVisibility(8);
            }
            bVar.f669v.setImageDrawable(RestoreUtil.getRestoreItemDrawable(cloudRestoreItemM29222a, strM941H));
            bVar.f666H.setText(m936I(cloudRestoreItemM29222a));
            bVar.f664F.setVisibility(8);
            m962f0(bVar, cloudRestoreItemM29222a);
            m938M(this.f655e, bVar.f660B);
            if (!C11842p.m70753O0(this.f655e) && bVar.f665G.getVisibility() == 0) {
                int iM70758Q = ((int) (C11842p.m70758Q(this.f655e) - C11842p.m70844o(this.f655e, 116))) / 3;
                bVar.f665G.setMaxWidth(iM70758Q);
                int i11 = iM70758Q * 2;
                bVar.f660B.setMaxWidth(i11);
                bVar.f666H.setMaxWidth(i11);
                bVar.f661C.setMaxWidth(i11);
            }
            if (c4868b.m29224c() != 1) {
                bVar.f667I.setVisibility(8);
            } else if (bVar.f667I.getVisibility() != 0) {
                bVar.f667I.setVisibility(0);
            }
            if (c4868b.m29224c() == 3) {
                m959c0(R$drawable.cardview_list_bottom_shape_white, bVar.f4327a, c4868b.m29224c());
            } else {
                m959c0(R$color.storage_manager_card_bg, bVar.f4327a, c4868b.m29224c());
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: u */
    public RecyclerView.AbstractC0833c0 mo724u(ViewGroup viewGroup, int i10) {
        return i10 == 0 ? new a(LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.new_bm_restore_header_view, viewGroup, false)) : i10 == 2 ? new c(LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.new_bm_restore_divider, viewGroup, false)) : new b(LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.restore_main_content_detail_item, viewGroup, false));
    }
}
