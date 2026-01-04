package com.huawei.android.hicloud.p088ui.uiadapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.android.hicloud.cloudbackup.bean.CloudBackupState;
import com.huawei.android.hicloud.cloudbackup.manager.DeviceIconManager;
import com.huawei.android.hicloud.cloudbackup.p076db.operator.SettingOperator;
import com.huawei.android.hicloud.cloudbackup.process.RestoreUtil;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.hicloud.p088ui.extend.TextBannerView;
import com.huawei.android.p073ds.R$color;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$plurals;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.cloudbackup.model.CloudRestoreItem;
import com.huawei.hicloud.router.data.ExtraDeviceInfo;
import com.huawei.hicloud.router.data.UserBackupInfo;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import ne.C11667a;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0223k;
import p292fn.C9733f;
import p514o9.C11839m;
import p514o9.C11842p;
import p618rm.C12590s0;
import p709vj.C13452e;
import p711vl.C13467g;
import p783xp.C13843a;
import p848zl.C14339h;
import p848zl.C14342k;
import sk.C12809f;

/* loaded from: classes3.dex */
public class BackupDeviceAdapter extends RecyclerView.AbstractC0838h<RecyclerView.AbstractC0833c0> {

    /* renamed from: d */
    public Context f18472d;

    /* renamed from: e */
    public List<Object> f18473e;

    /* renamed from: f */
    public boolean f18474f = false;

    /* renamed from: g */
    public IRecyclerViewOnListener f18475g;

    /* renamed from: h */
    public int f18476h;

    /* renamed from: i */
    public boolean f18477i;

    public interface IRecyclerViewOnListener {
        void onItemClick(int i10, Object obj);
    }

    /* renamed from: com.huawei.android.hicloud.ui.uiadapter.BackupDeviceAdapter$a */
    public class ViewOnClickListenerC4016a implements View.OnClickListener {

        /* renamed from: a */
        public final /* synthetic */ int f18478a;

        /* renamed from: b */
        public final /* synthetic */ UserBackupInfo.UserDeviceInfo f18479b;

        public ViewOnClickListenerC4016a(int i10, UserBackupInfo.UserDeviceInfo userDeviceInfo) {
            this.f18478a = i10;
            this.f18479b = userDeviceInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IRecyclerViewOnListener iRecyclerViewOnListener = BackupDeviceAdapter.this.f18475g;
            if (iRecyclerViewOnListener != null) {
                iRecyclerViewOnListener.onItemClick(this.f18478a, this.f18479b);
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.uiadapter.BackupDeviceAdapter$b */
    public static class C4017b extends RecyclerView.AbstractC0833c0 {

        /* renamed from: A */
        public View f18481A;

        /* renamed from: B */
        public Context f18482B;

        /* renamed from: C */
        public RelativeLayout f18483C;

        /* renamed from: u */
        public ImageView f18484u;

        /* renamed from: v */
        public TextView f18485v;

        /* renamed from: w */
        public TextView f18486w;

        /* renamed from: x */
        public TextView f18487x;

        /* renamed from: y */
        public TextBannerView f18488y;

        /* renamed from: z */
        public RelativeLayout f18489z;

        public C4017b(View view) {
            super(view);
            this.f18482B = C0213f.m1377a();
            this.f18484u = (ImageView) C12809f.m76831d(view, R$id.current_device_item_icon);
            this.f18485v = (TextView) C12809f.m76831d(view, R$id.current_device_name);
            this.f18486w = (TextView) C12809f.m76831d(view, R$id.current_device_text);
            this.f18488y = (TextBannerView) C12809f.m76831d(view, R$id.current_device_bannerView);
            this.f18487x = (TextView) C12809f.m76831d(view, R$id.current_device_title);
            this.f18489z = (RelativeLayout) C12809f.m76831d(view, R$id.current_backup_item);
            this.f18481A = C12809f.m76831d(view, R$id.current_device_line_view);
            this.f18483C = (RelativeLayout) C12809f.m76831d(view, R$id.item_layout);
            if (C0209d.m1195O(this.f18482B) >= 1.75f) {
                this.f18485v.setMaxLines(1);
                this.f18486w.setMaxLines(1);
                this.f18487x.setMaxLines(1);
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.uiadapter.BackupDeviceAdapter$c */
    public static class C4018c extends RecyclerView.AbstractC0833c0 {

        /* renamed from: A */
        public View f18490A;

        /* renamed from: B */
        public Context f18491B;

        /* renamed from: C */
        public LinearLayout f18492C;

        /* renamed from: u */
        public ImageView f18493u;

        /* renamed from: v */
        public TextView f18494v;

        /* renamed from: w */
        public TextView f18495w;

        /* renamed from: x */
        public TextView f18496x;

        /* renamed from: y */
        public ImageView f18497y;

        /* renamed from: z */
        public RelativeLayout f18498z;

        public C4018c(View view) {
            super(view);
            this.f18491B = C0213f.m1377a();
            this.f18493u = (ImageView) C12809f.m76831d(view, R$id.other_device_item_icon);
            this.f18494v = (TextView) C12809f.m76831d(view, R$id.other_device_name);
            this.f18495w = (TextView) C12809f.m76831d(view, R$id.other_device_text);
            this.f18496x = (TextView) C12809f.m76831d(view, R$id.other_device_expiratory_days);
            this.f18497y = (ImageView) C12809f.m76831d(view, R$id.right_arrow);
            this.f18498z = (RelativeLayout) C12809f.m76831d(view, R$id.other_device_list_item);
            this.f18490A = C12809f.m76831d(view, R$id.other_device_line_view);
            this.f18492C = (LinearLayout) C12809f.m76831d(view, R$id.item_layout);
            if (C0209d.m1195O(this.f18491B) >= 1.75f) {
                this.f18494v.setMaxLines(1);
                this.f18495w.setMaxLines(1);
                this.f18496x.setMaxLines(1);
            }
        }
    }

    public BackupDeviceAdapter(Context context) {
        this.f18472d = context;
    }

    /* renamed from: E */
    public final void m24700E(C4017b c4017b, CloudBackupState cloudBackupState, int i10) {
        if (i10 == 5) {
            m24713R(c4017b, cloudBackupState);
        } else if (i10 == 3) {
            m24712Q(c4017b);
        } else {
            m24716U(c4017b, cloudBackupState);
        }
    }

    /* renamed from: F */
    public final String m24701F(CloudBackupState cloudBackupState) {
        return !C9733f.m60705z().m60720O("cloudBackupDeviceNameManagement") ? C0209d.m1174H() : TextUtils.isEmpty(cloudBackupState.getDeviceName()) ? C0209d.m1171G() : cloudBackupState.getDeviceName();
    }

    /* renamed from: G */
    public final String m24702G(long j10) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j10);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(System.currentTimeMillis());
        int i10 = calendar.get(1);
        int i11 = calendar2.get(1);
        int i12 = calendar.get(6);
        int i13 = calendar2.get(6);
        if (i10 != i11) {
            return C11667a.m69661c(this.f18472d, j10, C11842p.m70824j());
        }
        if (i12 == i13) {
            Date date = new Date(j10);
            Context context = this.f18472d;
            return context.getString(R$string.temp_backup_today, C13843a.m83065Q(context, date));
        }
        if (i13 - i12 != 1) {
            return C11667a.m69661c(this.f18472d, j10, C11842p.m70824j());
        }
        Date date2 = new Date(j10);
        Context context2 = this.f18472d;
        return context2.getString(R$string.temp_backup_yesterday, C13843a.m83065Q(context2, date2));
    }

    /* renamed from: H */
    public final long m24703H(int i10, long j10) {
        long j11 = (i10 * 86400000) + j10;
        return (j10 == 0 || j11 < System.currentTimeMillis()) ? System.currentTimeMillis() : j11;
    }

    /* renamed from: I */
    public final String m24704I(CloudBackupState cloudBackupState) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(cloudBackupState.getNextStartTime());
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(System.currentTimeMillis());
        int i10 = calendar.get(6);
        int i11 = calendar2.get(6);
        return i10 == i11 ? this.f18472d.getString(R$string.main_today) : i10 - i11 == 1 ? this.f18472d.getString(R$string.tomorrow) : C11667a.m69661c(this.f18472d, cloudBackupState.getNextStartTime(), 65556);
    }

    /* renamed from: J */
    public final void m24705J(C4017b c4017b, CloudBackupState cloudBackupState) {
        int iIntValue = cloudBackupState.getState().intValue();
        c4017b.f18485v.setText(this.f18472d.getString(R$string.about_recover_tip, m24701F(cloudBackupState), this.f18472d.getString(R$string.current_device_new), ""));
        if (C14342k.m85520a(iIntValue)) {
            m24706K(c4017b, cloudBackupState);
            return;
        }
        if (iIntValue == 2) {
            m24711P(c4017b, cloudBackupState);
        } else if (iIntValue == 3) {
            m24708M(c4017b, cloudBackupState);
        } else if (iIntValue == 4) {
            m24710O(c4017b, cloudBackupState);
        }
    }

    /* renamed from: K */
    public final void m24706K(C4017b c4017b, CloudBackupState cloudBackupState) {
        if (cloudBackupState.getState().intValue() == 1 || cloudBackupState.getState().intValue() == 5 || cloudBackupState.getState().intValue() == 6) {
            c4017b.f18486w.setText(this.f18472d.getString(R$string.cloudbackup_prepare_data));
        } else if (cloudBackupState.getState().intValue() == 9) {
            c4017b.f18486w.setText(this.f18472d.getString(R$string.creating_backup_record));
        } else {
            String displayModule = cloudBackupState.getDisplayModule();
            if (TextUtils.isEmpty(displayModule)) {
                c4017b.f18487x.setText(this.f18472d.getString(R$string.backing_up));
                c4017b.f18487x.setTextColor(this.f18472d.getColor(R$color.backup_complete_text));
                c4017b.f18486w.setText(this.f18472d.getString(R$string.cloudbackup_prepare_data));
                C11839m.m70688i("BackupDeviceAdapter", "moudleName is null");
                return;
            }
            c4017b.f18486w.setText(this.f18472d.getString(R$string.module_progress_tips_no_num_new, C2783d.m16142g0(displayModule) ? C2783d.m16153k(this.f18472d, displayModule) : C2783d.m16079E(this.f18472d, displayModule)));
        }
        c4017b.f18487x.setText(this.f18472d.getString(R$string.backing_up));
        c4017b.f18487x.setTextColor(this.f18472d.getColor(R$color.backup_complete_text));
    }

    /* renamed from: L */
    public final void m24707L(C4017b c4017b, CloudBackupState cloudBackupState) {
        c4017b.f18486w.setText(this.f18472d.getString(R$string.next_backup_time, m24704I(cloudBackupState)));
        c4017b.f18487x.setVisibility(8);
    }

    /* renamed from: M */
    public final void m24708M(C4017b c4017b, CloudBackupState cloudBackupState) {
        c4017b.f18487x.setText(this.f18472d.getString(R$string.backup_complete));
        String strM24704I = m24704I(cloudBackupState);
        String strM24702G = m24702G(cloudBackupState.getLastSuccessTime());
        if (cloudBackupState.getLastSuccessTime() == 0) {
            c4017b.f18486w.setText(this.f18472d.getString(R$string.next_backup_time, strM24704I));
            c4017b.f18488y.setVisibility(8);
            c4017b.f18486w.setVisibility(0);
            c4017b.f18487x.setVisibility(8);
        } else {
            c4017b.f18488y.setVisibility(0);
            c4017b.f18486w.setVisibility(8);
            c4017b.f18487x.setVisibility(0);
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.f18472d.getString(R$string.next_backup_time, strM24704I));
            arrayList.add(strM24702G);
            c4017b.f18488y.setDatas(arrayList);
        }
        c4017b.f18487x.setTextColor(this.f18472d.getColor(R$color.backup_complete_text));
    }

    /* renamed from: N */
    public final void m24709N(C4017b c4017b) {
        if (RestoreUtil.getPauseCount(0, RestoreUtil.getItemList()) == 0) {
            c4017b.f18486w.setVisibility(8);
        } else {
            c4017b.f18486w.setText(this.f18472d.getString(R$string.restore_pause_resume_subtitle_new));
            c4017b.f18486w.setVisibility(0);
        }
        c4017b.f18487x.setText(this.f18472d.getString(R$string.restore_new_pause));
        c4017b.f18487x.setTextColor(this.f18472d.getColor(R$color.backup_pause_text));
    }

    /* renamed from: O */
    public final void m24710O(C4017b c4017b, CloudBackupState cloudBackupState) {
        c4017b.f18488y.setVisibility(8);
        c4017b.f18486w.setVisibility(0);
        c4017b.f18487x.setVisibility(0);
        if (C12590s0.m75881n1(cloudBackupState.getLastSuccessTime())) {
            c4017b.f18487x.setText(this.f18472d.getString(R$string.not_backup_morethan_six_months, 6));
        } else {
            int iM75836c0 = C12590s0.m75836c0(cloudBackupState.getLastSuccessTime());
            C11839m.m70688i("BackupDeviceAdapter", "initOverDays() get days:" + iM75836c0);
            c4017b.f18487x.setText(this.f18472d.getResources().getQuantityString(R$plurals.no_backup_for_time, iM75836c0, Integer.valueOf(iM75836c0)));
        }
        if (cloudBackupState.isOverDayErrTipDismiss() || (cloudBackupState.getReturnCode() == 3001 && cloudBackupState.isCloudSpaceNotEnoughDismiss())) {
            C11839m.m70688i("BackupDeviceAdapter", "initOverDays() set backupSize");
            TextView textView = c4017b.f18486w;
            Context context = this.f18472d;
            textView.setText(context.getString(R$string.backup_size, C0223k.m1524g(context, cloudBackupState.getWaitBackupSize())));
        } else {
            C11839m.m70688i("BackupDeviceAdapter", "initOverDays() setOverDaysText");
            m24722a0(c4017b.f18486w, cloudBackupState);
        }
        c4017b.f18487x.setTextColor(this.f18472d.getColor(R$color.backup_pause_text));
    }

    /* renamed from: P */
    public final void m24711P(C4017b c4017b, CloudBackupState cloudBackupState) {
        int returnCode = cloudBackupState.getReturnCode();
        if (returnCode == 3001 && cloudBackupState.isCloudSpaceNotEnoughDismiss()) {
            m24708M(c4017b, cloudBackupState);
            C11839m.m70688i("BackupDeviceAdapter", "initPauseState errorCode is 3001 ,show spacialstatus");
            return;
        }
        if (returnCode == 3113) {
            m24707L(c4017b, cloudBackupState);
            return;
        }
        c4017b.f18486w.setVisibility(0);
        String strM75802U = C12590s0.m75802U(this.f18472d, cloudBackupState.getReturnCode());
        if (strM75802U == null) {
            c4017b.f18486w.setVisibility(8);
        } else {
            c4017b.f18486w.setText(strM75802U);
        }
        c4017b.f18487x.setVisibility(0);
        c4017b.f18487x.setText(this.f18472d.getString(R$string.backup_paused));
        c4017b.f18487x.setTextColor(this.f18472d.getColor(R$color.backup_pause_text));
    }

    /* renamed from: Q */
    public void m24712Q(C4017b c4017b) {
        List<CloudRestoreItem> itemList = RestoreUtil.getItemList();
        int failCount = RestoreUtil.getFailCount(0, itemList);
        C11839m.m70688i("BackupDeviceAdapter", "restoreSuccess failedCount = " + failCount);
        int succeedCount = RestoreUtil.getSucceedCount(0, itemList);
        C11839m.m70688i("BackupDeviceAdapter", "restoreSuccess succeedCount = " + succeedCount);
        if (failCount > 0 && succeedCount > 0) {
            c4017b.f18487x.setText(this.f18472d.getString(R$string.restore_partial_completed));
            c4017b.f18487x.setTextColor(this.f18472d.getColor(R$color.backup_pause_text));
        } else if (failCount > 0) {
            c4017b.f18487x.setText(this.f18472d.getString(R$string.restore_failed));
            c4017b.f18487x.setTextColor(this.f18472d.getColor(R$color.emui_functional_red));
        }
        c4017b.f18488y.setVisibility(8);
        c4017b.f18486w.setVisibility(8);
    }

    /* renamed from: R */
    public final void m24713R(C4017b c4017b, CloudBackupState cloudBackupState) {
        if (C14339h.m85506e().contains(Integer.valueOf(cloudBackupState.getReturnCode()))) {
            c4017b.f18487x.setText(this.f18472d.getString(R$string.restore_new_pause));
            c4017b.f18487x.setTextColor(this.f18472d.getColor(R$color.backup_pause_text));
            c4017b.f18486w.setText(this.f18472d.getString(R$string.restore_low_power, RestoreUtil.getPauseBattery()));
            c4017b.f18486w.setVisibility(0);
            return;
        }
        c4017b.f18487x.setText(this.f18472d.getString(R$string.restore_failed));
        c4017b.f18487x.setTextColor(this.f18472d.getColor(R$color.emui_functional_red));
        c4017b.f18488y.setVisibility(8);
        c4017b.f18486w.setVisibility(8);
    }

    /* renamed from: S */
    public final void m24714S(C4017b c4017b, CloudBackupState cloudBackupState) {
        c4017b.f18487x.setText(this.f18472d.getString(R$string.restore_new_pause));
        c4017b.f18487x.setTextColor(this.f18472d.getColor(R$color.backup_pause_text));
        c4017b.f18486w.setVisibility(0);
        if (C14339h.m85514m().contains(Integer.valueOf(cloudBackupState.getReturnCode()))) {
            c4017b.f18486w.setText(this.f18472d.getString(R$string.home_restore_net_disconnet));
        } else {
            c4017b.f18486w.setVisibility(8);
        }
    }

    /* renamed from: T */
    public final void m24715T(C4017b c4017b, CloudBackupState cloudBackupState) {
        c4017b.f18485v.setText(this.f18472d.getString(R$string.about_recover_tip, m24701F(cloudBackupState), this.f18472d.getString(R$string.current_device_new), ""));
        int iM80916g0 = C13452e.m80781L().m80916g0();
        C11839m.m70688i("BackupDeviceAdapter", "restoreStatus = " + iM80916g0 + "; backupState.getState(): " + cloudBackupState.getState());
        if (cloudBackupState.getState().intValue() == 1 || cloudBackupState.getState().intValue() == 5) {
            m24700E(c4017b, cloudBackupState, iM80916g0);
            return;
        }
        if (iM80916g0 == 2 || iM80916g0 == 3) {
            m24712Q(c4017b);
            return;
        }
        if (iM80916g0 == 4 || iM80916g0 == 5) {
            m24713R(c4017b, cloudBackupState);
        } else if (iM80916g0 == 7) {
            m24709N(c4017b);
        } else if (cloudBackupState.getState().intValue() == 2) {
            m24714S(c4017b, cloudBackupState);
        }
    }

    /* renamed from: U */
    public final void m24716U(C4017b c4017b, CloudBackupState cloudBackupState) {
        c4017b.f18487x.setText(this.f18472d.getString(R$string.main_cloudrestoring));
        c4017b.f18487x.setTextColor(this.f18472d.getColor(R$color.backup_complete_text));
        c4017b.f18486w.setText(this.f18472d.getString(R$string.see_details));
        c4017b.f18486w.setVisibility(0);
        c4017b.f18488y.setVisibility(8);
    }

    /* renamed from: V */
    public final /* synthetic */ void m24717V(int i10, CloudBackupState cloudBackupState, View view) {
        IRecyclerViewOnListener iRecyclerViewOnListener = this.f18475g;
        if (iRecyclerViewOnListener != null) {
            iRecyclerViewOnListener.onItemClick(i10, cloudBackupState);
        }
    }

    /* renamed from: W */
    public void m24718W(int i10) {
        this.f18476h = i10;
    }

    /* renamed from: X */
    public void m24719X(List<Object> list) {
        this.f18473e = list;
    }

    /* renamed from: Y */
    public void m24720Y(boolean z10) {
        this.f18477i = z10;
    }

    /* renamed from: Z */
    public void m24721Z(IRecyclerViewOnListener iRecyclerViewOnListener) {
        this.f18475g = iRecyclerViewOnListener;
    }

    /* renamed from: a0 */
    public final void m24722a0(TextView textView, CloudBackupState cloudBackupState) {
        textView.setText(C12590s0.m75888p0(cloudBackupState.getWaitBackupSize(), this.f18472d, cloudBackupState.getReturnCode()));
    }

    /* renamed from: b0 */
    public void m24723b0(boolean z10) {
        this.f18474f = z10;
    }

    /* renamed from: c0 */
    public final void m24724c0(C4017b c4017b, final int i10) {
        List<Object> list = this.f18473e;
        if (list == null) {
            C11839m.m70688i("BackupDeviceAdapter", "backupItemList is null");
            return;
        }
        Object obj = list.get(i10);
        if (obj instanceof CloudBackupState) {
            final CloudBackupState cloudBackupState = (CloudBackupState) obj;
            if (C11842p.m70762R0()) {
                c4017b.f18484u.setImageResource(R$drawable.ic_public_pad);
            } else {
                c4017b.f18484u.setImageResource(R$drawable.ic_agr_phone);
            }
            C11839m.m70688i("BackupDeviceAdapter", "backupState.getId:" + cloudBackupState.getId() + ",isRefurbishing:" + this.f18474f);
            if (this.f18474f) {
                long jM24703H = m24703H(C13467g.m81086c().m81091f(), new SettingOperator().querylastsuccesstime());
                cloudBackupState.setLastSuccessTime(0L);
                cloudBackupState.setNextStartTime(jM24703H);
                c4017b.f18485v.setText(this.f18472d.getString(R$string.about_recover_tip, m24701F(cloudBackupState), this.f18472d.getString(R$string.current_device_new), ""));
                m24708M(c4017b, cloudBackupState);
            } else if (cloudBackupState.getId() == 1) {
                m24705J(c4017b, cloudBackupState);
            } else if (cloudBackupState.getId() == 2) {
                m24715T(c4017b, cloudBackupState);
            }
            if (mo721e() < 2 || this.f18476h > 1) {
                c4017b.f18481A.setVisibility(8);
            } else {
                c4017b.f18481A.setVisibility(0);
            }
            if (C0209d.m1166E1()) {
                c4017b.f18489z.setOnClickListener(new View.OnClickListener() { // from class: ae.g
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f463a.m24717V(i10, cloudBackupState, view);
                    }
                });
            } else {
                c4017b.f18489z.setEnabled(false);
                c4017b.f18489z.setAlpha(0.62f);
            }
        }
        if (this.f18476h > 1) {
            int iM70840n = C11842p.m70840n(this.f18472d, 4);
            c4017b.f18483C.setPadding(iM70840n, iM70840n, iM70840n, iM70840n);
            c4017b.f18483C.setBackground(this.f18472d.getDrawable(R$drawable.storage_manage_cardview_list_shape_white));
        } else {
            int iM70840n2 = C11842p.m70840n(this.f18472d, 0);
            c4017b.f18483C.setPadding(iM70840n2, iM70840n2, iM70840n2, iM70840n2);
            c4017b.f18483C.setBackground(null);
        }
    }

    /* renamed from: d0 */
    public final void m24725d0(C4018c c4018c, int i10) {
        int iIntValue;
        String strM24702G;
        List<Object> list = this.f18473e;
        if (list == null) {
            C11839m.m70688i("BackupDeviceAdapter", "backupItemList is null");
            return;
        }
        if (list.get(i10) instanceof UserBackupInfo.UserDeviceInfo) {
            UserBackupInfo.UserDeviceInfo userDeviceInfo = (UserBackupInfo.UserDeviceInfo) this.f18473e.get(i10);
            c4018c.f18493u.setImageDrawable(DeviceIconManager.getInstance().getDeviceIconFromCache(userDeviceInfo.getTerminalType(), userDeviceInfo.getDeviceCategory()));
            c4018c.f18494v.setText(TextUtils.isEmpty(userDeviceInfo.getDevDisplayName()) ? userDeviceInfo.getDeviceName() : userDeviceInfo.getDevDisplayName());
            if (userDeviceInfo.isCurrent() && userDeviceInfo.isTempBackUp()) {
                TextView textView = c4018c.f18494v;
                Context context = this.f18472d;
                int i11 = R$string.about_recover_tip;
                Object[] objArr = new Object[3];
                objArr[0] = TextUtils.isEmpty(userDeviceInfo.getDevDisplayName()) ? userDeviceInfo.getDeviceName() : userDeviceInfo.getDevDisplayName();
                objArr[1] = this.f18472d.getString(R$string.current_device_new);
                objArr[2] = "";
                textView.setText(context.getString(i11, objArr));
            }
            if (this.f18477i || userDeviceInfo.isTempBackUp()) {
                Iterator it = ((ArrayList) Optional.ofNullable(userDeviceInfo.getExtraDeviceInfos()).orElse(new ArrayList())).iterator();
                int i12 = 1;
                while (true) {
                    if (!it.hasNext()) {
                        iIntValue = 0;
                        break;
                    }
                    ExtraDeviceInfo extraDeviceInfo = (ExtraDeviceInfo) it.next();
                    Integer occupySpaceType = extraDeviceInfo.getOccupySpaceType();
                    int expiratoryInDays = extraDeviceInfo.getExpiratoryInDays();
                    if (occupySpaceType != null && occupySpaceType.intValue() == 1) {
                        iIntValue = occupySpaceType.intValue();
                        break;
                    } else if (expiratoryInDays > 0) {
                        i12 = expiratoryInDays;
                    }
                }
                if (iIntValue == 1) {
                    long size = userDeviceInfo.getSize();
                    strM24702G = size > 0 ? C0209d.m1157C0(C0223k.m1524g(C0213f.m1377a(), size)) : "";
                    c4018c.f18496x.setVisibility(8);
                } else {
                    long lastbackupTime = userDeviceInfo.getLastbackupTime();
                    strM24702G = lastbackupTime != 0 ? m24702G(lastbackupTime) : "";
                    c4018c.f18496x.setText(this.f18472d.getResources().getQuantityString(R$plurals.temp_backup_will_delete, i12, Integer.valueOf(i12)));
                    c4018c.f18496x.setVisibility(0);
                }
                if (TextUtils.isEmpty(strM24702G)) {
                    c4018c.f18495w.setVisibility(8);
                } else {
                    c4018c.f18495w.setVisibility(0);
                    c4018c.f18495w.setText(strM24702G);
                }
            } else if (userDeviceInfo.getLastbackupTime() == 0) {
                c4018c.f18495w.setVisibility(8);
            } else {
                c4018c.f18495w.setVisibility(0);
                c4018c.f18495w.setText(m24702G(userDeviceInfo.getLastbackupTime()));
            }
            if (C0209d.m1166E1()) {
                c4018c.f18498z.setOnClickListener(new ViewOnClickListenerC4016a(i10, userDeviceInfo));
            } else {
                c4018c.f18498z.setEnabled(false);
                c4018c.f18498z.setAlpha(0.62f);
            }
            if (this.f18476h > 1) {
                int iM70840n = C11842p.m70840n(this.f18472d, 4);
                c4018c.f18492C.setPadding(iM70840n, iM70840n, iM70840n, iM70840n);
                c4018c.f18492C.setBackground(this.f18472d.getDrawable(R$drawable.storage_manage_cardview_list_shape_white));
                c4018c.f18490A.setVisibility(8);
                return;
            }
            int iM70840n2 = C11842p.m70840n(this.f18472d, 0);
            c4018c.f18492C.setPadding(iM70840n2, iM70840n2, iM70840n2, iM70840n2);
            c4018c.f18492C.setBackground(null);
            if (mo721e() - 1 == i10) {
                c4018c.f18490A.setVisibility(8);
            } else {
                c4018c.f18490A.setVisibility(0);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: e */
    public int mo721e() {
        List<Object> list = this.f18473e;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: g */
    public int mo749g(int i10) {
        List<Object> list = this.f18473e;
        return (list == null || list.get(i10) == null || (this.f18473e.get(i10) instanceof CloudBackupState)) ? 1 : 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: s */
    public void mo723s(RecyclerView.AbstractC0833c0 abstractC0833c0, int i10) {
        List<Object> list = this.f18473e;
        if (list == null || list.isEmpty()) {
            C11839m.m70687e("BackupDeviceAdapter", "backupItemList is null");
        } else if (abstractC0833c0 instanceof C4017b) {
            m24724c0((C4017b) abstractC0833c0, i10);
        } else if (abstractC0833c0 instanceof C4018c) {
            m24725d0((C4018c) abstractC0833c0, i10);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: u */
    public RecyclerView.AbstractC0833c0 mo724u(ViewGroup viewGroup, int i10) {
        float fM1195O = C0209d.m1195O(this.f18472d);
        if (i10 == 0) {
            C11839m.m70688i("BackupDeviceAdapter", "OTHERS_DEVICE");
            return new C4018c(fM1195O >= 1.75f ? LayoutInflater.from(this.f18472d).inflate(R$layout.backup_other_device_item_scale, viewGroup, false) : LayoutInflater.from(this.f18472d).inflate(R$layout.backup_other_device_item, viewGroup, false));
        }
        if (i10 == 1) {
            C11839m.m70688i("BackupDeviceAdapter", "CURRENT_DEVICE");
            return new C4017b(fM1195O >= 1.75f ? LayoutInflater.from(this.f18472d).inflate(R$layout.backup_current_device_item_scale, viewGroup, false) : LayoutInflater.from(this.f18472d).inflate(R$layout.backup_current_device_item, viewGroup, false));
        }
        C4017b c4017b = new C4017b(LayoutInflater.from(this.f18472d).inflate(R$layout.backup_current_device_item, viewGroup, false));
        C11839m.m70688i("BackupDeviceAdapter", "onCreateViewHolder default");
        return c4017b;
    }
}
