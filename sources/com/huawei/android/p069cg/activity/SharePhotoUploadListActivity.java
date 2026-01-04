package com.huawei.android.p069cg.activity;

import android.app.ActionBar;
import android.content.Intent;
import android.database.SQLException;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.AbstractC0879r;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.android.hicloud.p088ui.activity.UIActivity;
import com.huawei.android.hicloud.p088ui.extend.AutoSizeButton;
import com.huawei.android.hicloud.p088ui.extend.NotchTopFitRelativeLayout;
import com.huawei.android.p069cg.R$color;
import com.huawei.android.p069cg.R$drawable;
import com.huawei.android.p069cg.R$id;
import com.huawei.android.p069cg.R$layout;
import com.huawei.android.p069cg.R$string;
import com.huawei.android.p069cg.bean.MediaFileBean;
import com.huawei.android.p069cg.p071ui.RecyclerMediaAdapter;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hms.videokit.player.common.PlayerConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p009a8.C0069g;
import p015ak.C0209d;
import p015ak.C0223k;
import p031b7.C1120a;
import p050c8.C1395a;
import p486n6.ViewOnClickListenerC11636a;
import p514o9.C11839m;
import p514o9.C11841o;
import p546p6.C12091d;
import p664u0.C13108a;
import sk.C12809f;

/* loaded from: classes2.dex */
public class SharePhotoUploadListActivity extends UIActivity implements View.OnClickListener {

    /* renamed from: A */
    public int f10625A;

    /* renamed from: E */
    public String f10629E;

    /* renamed from: F */
    public long f10630F;

    /* renamed from: G */
    public ViewOnClickListenerC11636a f10631G;

    /* renamed from: p */
    public RecyclerMediaAdapter f10634p;

    /* renamed from: q */
    public RecyclerView f10635q;

    /* renamed from: r */
    public NotchTopFitRelativeLayout f10636r;

    /* renamed from: s */
    public TextView f10637s;

    /* renamed from: t */
    public TextView f10638t;

    /* renamed from: u */
    public TextView f10639u;

    /* renamed from: v */
    public TextView f10640v;

    /* renamed from: w */
    public RelativeLayout f10641w;

    /* renamed from: x */
    public RelativeLayout f10642x;

    /* renamed from: z */
    public AutoSizeButton f10644z;

    /* renamed from: y */
    public int f10643y = 0;

    /* renamed from: B */
    public List<MediaFileBean> f10626B = new ArrayList();

    /* renamed from: C */
    public Map<String, MediaFileBean> f10627C = new HashMap();

    /* renamed from: D */
    public Map<String, Integer> f10628D = new HashMap();

    /* renamed from: H */
    public C0069g.c f10632H = new HandlerC2245a();

    /* renamed from: I */
    public RecyclerMediaAdapter.InterfaceC2353e f10633I = new C2246b();

    /* renamed from: com.huawei.android.cg.activity.SharePhotoUploadListActivity$a */
    public class HandlerC2245a extends C0069g.c {
        public HandlerC2245a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i10 = message.what;
            if (i10 == 1024) {
                SharePhotoUploadListActivity.this.f10626B.clear();
                SharePhotoUploadListActivity.this.f10626B.addAll((List) message.obj);
                C1395a c1395aM484E = C0069g.m479y().m484E(SharePhotoUploadListActivity.this.f10629E);
                if (c1395aM484E != null) {
                    SharePhotoUploadListActivity.this.f10630F = c1395aM484E.m7977j();
                    SharePhotoUploadListActivity.this.f10625A = c1395aM484E.m7978k();
                    SharePhotoUploadListActivity.this.m13976e2(c1395aM484E.m7976i(), c1395aM484E.m7975h());
                } else {
                    SharePhotoUploadListActivity sharePhotoUploadListActivity = SharePhotoUploadListActivity.this;
                    sharePhotoUploadListActivity.m13976e2(sharePhotoUploadListActivity.f10626B.size(), 0);
                }
                SharePhotoUploadListActivity.this.m13975d2();
                SharePhotoUploadListActivity.this.m13973X1();
                return;
            }
            if (i10 == 1025) {
                SharePhotoUploadListActivity.this.m13971b2();
                return;
            }
            if (i10 != 100) {
                if (i10 == 101) {
                    C1395a c1395a = (C1395a) message.obj;
                    SharePhotoUploadListActivity.this.f10630F = c1395a.m7977j();
                    SharePhotoUploadListActivity.this.f10625A = c1395a.m7978k();
                    SharePhotoUploadListActivity.this.m13975d2();
                    C1120a.m6677i("SharePhotoUploadListActivity", "MSG_ALBUM_UPLOAD_TASK_CHANGED totalNum=" + c1395a.m7976i() + ", succeedNum=" + c1395a.m7975h() + ", failedNum=" + c1395a.m7973f() + ", pausedNum=" + c1395a.m7974g());
                    SharePhotoUploadListActivity.this.m13976e2(c1395a.m7976i(), c1395a.m7975h());
                    return;
                }
                return;
            }
            MediaFileBean mediaFileBean = (MediaFileBean) message.obj;
            int i11 = message.arg2;
            C1120a.m6675d("SharePhotoUploadListActivity", "spaceStatus " + i11);
            if (i11 == 1007) {
                SharePhotoUploadListActivity sharePhotoUploadListActivity2 = SharePhotoUploadListActivity.this;
                C11841o.m70706b(sharePhotoUploadListActivity2, sharePhotoUploadListActivity2.getString(R$string.album_no_upload_permission), 0);
            }
            if (i11 == 4946) {
                if (SharePhotoUploadListActivity.this.f10631G == null) {
                    SharePhotoUploadListActivity.this.f10631G = new ViewOnClickListenerC11636a(SharePhotoUploadListActivity.this);
                }
                if (!SharePhotoUploadListActivity.this.f10631G.isShowing()) {
                    SharePhotoUploadListActivity.this.f10631G.show();
                }
            }
            if (mediaFileBean == null) {
                return;
            }
            C1120a.m6677i("SharePhotoUploadListActivity", "MSG_UPLOAD_TASK_CHANGED");
            MediaFileBean mediaFileBean2 = (MediaFileBean) SharePhotoUploadListActivity.this.f10627C.get(mediaFileBean.m14306A());
            if (mediaFileBean2 == null) {
                return;
            }
            mediaFileBean2.m14357w0(mediaFileBean.m14308K());
            C12091d.m72280a0().m72376p1(mediaFileBean2, mediaFileBean);
            int iIndexOf = SharePhotoUploadListActivity.this.f10626B.indexOf(mediaFileBean2);
            if (iIndexOf != -1) {
                SharePhotoUploadListActivity.this.f10634p.m5214k(iIndexOf);
            } else {
                SharePhotoUploadListActivity.this.f10634p.m5213j();
            }
        }
    }

    /* renamed from: com.huawei.android.cg.activity.SharePhotoUploadListActivity$b */
    public class C2246b implements RecyclerMediaAdapter.InterfaceC2353e {
        public C2246b() {
        }

        @Override // com.huawei.android.p069cg.p071ui.RecyclerMediaAdapter.InterfaceC2353e
        /* renamed from: a */
        public void mo13635a(View view, int i10) throws SQLException {
            if (C0209d.m1226Y0()) {
                return;
            }
            Object objM14761R = SharePhotoUploadListActivity.this.f10634p.m14761R(i10);
            if (objM14761R instanceof RecyclerMediaAdapter.C2356h) {
                MediaFileBean mediaFileBean = (MediaFileBean) SharePhotoUploadListActivity.this.f10627C.get(((RecyclerMediaAdapter.C2356h) objM14761R).m14792a().m14306A());
                int iM14308K = mediaFileBean.m14308K();
                if (iM14308K == 3) {
                    C0069g.m479y().m498S(mediaFileBean);
                } else if (iM14308K == 2) {
                    C0069g.m479y().m495P(mediaFileBean);
                }
            }
        }

        @Override // com.huawei.android.p069cg.p071ui.RecyclerMediaAdapter.InterfaceC2353e
        /* renamed from: b */
        public void mo13636b(View view, int i10) {
            if (C0209d.m1226Y0()) {
                return;
            }
            Object objM14761R = SharePhotoUploadListActivity.this.f10634p.m14761R(i10);
            SharePhotoUploadListActivity.this.f10634p.m14758K(objM14761R);
            RecyclerMediaAdapter.C2356h c2356h = (RecyclerMediaAdapter.C2356h) objM14761R;
            SharePhotoUploadListActivity.this.f10627C.remove(c2356h.m14792a().m14306A());
            SharePhotoUploadListActivity.this.f10626B.remove(c2356h.m14792a());
            C0069g.m479y().m507n(c2356h.m14792a());
        }
    }

    /* renamed from: Z1 */
    private void m13969Z1(HiCloudSafeIntent hiCloudSafeIntent) {
        this.f10629E = hiCloudSafeIntent.getStringExtra("param_album_id");
        C12091d.m72280a0().m72297B0(this.f10629E, this.f10632H);
        C0069g.m479y().m503j(this.f10632H);
    }

    /* renamed from: a2 */
    private void m13970a2() {
        this.f10635q = (RecyclerView) C12809f.m76829b(this, R$id.photos_album_recyclerview);
        this.f10636r = (NotchTopFitRelativeLayout) C12809f.m76829b(this, R$id.main_notch_fit_layout);
        this.f10637s = (TextView) C12809f.m76829b(this, R$id.upload_progress_num_value);
        AutoSizeButton autoSizeButton = (AutoSizeButton) C12809f.m76829b(this, R$id.upload_progress_op_btn);
        this.f10644z = autoSizeButton;
        autoSizeButton.setOnClickListener(this);
        RelativeLayout relativeLayout = (RelativeLayout) C12809f.m76829b(this, R$id.ic_back_hot_space);
        this.f10642x = relativeLayout;
        relativeLayout.setOnClickListener(this);
        TextView textView = (TextView) C12809f.m76829b(this, R$id.action_bar_title);
        this.f10638t = textView;
        textView.setText(getString(R$string.album_uploading_list));
        this.f10640v = (TextView) C12809f.m76829b(this, R$id.upload_progress_speed_value);
        this.f10639u = (TextView) C12809f.m76829b(this, R$id.upload_progress_speed_title);
        RelativeLayout relativeLayout2 = (RelativeLayout) C12809f.m76829b(this, R$id.action_bar_end_task_frm);
        this.f10641w = relativeLayout2;
        relativeLayout2.setOnClickListener(this);
        this.f10635q.setLayoutManager(new GridLayoutManager(this, 4));
        m13974Y1();
        RecyclerMediaAdapter recyclerMediaAdapter = new RecyclerMediaAdapter(this);
        this.f10634p = recyclerMediaAdapter;
        recyclerMediaAdapter.m14775l0(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b2 */
    public void m13971b2() {
        RecyclerMediaAdapter recyclerMediaAdapter = this.f10634p;
        if (recyclerMediaAdapter != null) {
            recyclerMediaAdapter.m14772i0(this.f10633I);
            this.f10635q.setAdapter(this.f10634p);
            this.f10634p.m14765Z(this.f10626B, 2);
        }
    }

    /* renamed from: c2 */
    private void m13972c2(HiCloudSafeIntent hiCloudSafeIntent) {
        this.f10643y = hiCloudSafeIntent.getIntExtra("album_type", 0);
        ActionBar actionBar = getActionBar();
        if (actionBar == null) {
            C11839m.m70687e("SharePhotoUploadListActivity", "onCreate actionBar is null.");
            return;
        }
        int i10 = this.f10643y;
        if (i10 == 1) {
            actionBar.setTitle(R$string.cloud_album_camera);
            return;
        }
        if (i10 == 2) {
            actionBar.setTitle(R$string.cloud_album_video);
            return;
        }
        if (i10 == 3) {
            actionBar.setTitle(R$string.cloud_album_capture_record);
            return;
        }
        if (i10 == 4) {
            actionBar.setTitle(R$string.cloud_album_my_favorites);
            return;
        }
        C11839m.m70687e("SharePhotoUploadListActivity", "invalid albumType = " + this.f10643y);
    }

    /* renamed from: X1 */
    public final void m13973X1() {
        this.f10627C.clear();
        for (int i10 = 0; i10 < this.f10626B.size(); i10++) {
            MediaFileBean mediaFileBean = this.f10626B.get(i10);
            String strM14306A = mediaFileBean.m14306A();
            this.f10627C.put(strM14306A, mediaFileBean);
            this.f10628D.put(strM14306A, Integer.valueOf(i10));
        }
        Message messageObtain = Message.obtain();
        messageObtain.what = PlayerConstants.ErrorCode.SWITCH_AUDIO_FAILED;
        this.f10632H.sendMessage(messageObtain);
    }

    /* renamed from: Y1 */
    public void m13974Y1() {
        RecyclerView.AbstractC0843m itemAnimator = this.f10635q.getItemAnimator();
        if (itemAnimator != null) {
            itemAnimator.setAddDuration(0L);
            itemAnimator.setChangeDuration(0L);
            itemAnimator.setMoveDuration(0L);
            itemAnimator.setRemoveDuration(0L);
            ((AbstractC0879r) itemAnimator).setSupportsChangeAnimations(false);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: d1 */
    public List<View> mo13289d1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f10636r);
        return arrayList;
    }

    /* renamed from: d2 */
    public final void m13975d2() {
        int i10 = this.f10625A;
        if (i10 == 3) {
            this.f10644z.setText(getString(R$string.album_resume_uploading));
            this.f10644z.setTextColor(getColor(R$color.white));
            this.f10644z.setBackground(getDrawable(R$drawable.album_button_bg));
            this.f10639u.setText(getString(R$string.album_uploading_status));
            this.f10640v.setTextColor(getColor(R$color.color_F29B22));
            this.f10640v.setText(getString(R$string.album_pause_status));
            this.f10641w.setVisibility(0);
            return;
        }
        if (i10 == 2) {
            this.f10644z.setText(getString(R$string.album_pause_uploading));
            this.f10644z.setTextColor(getColor(R$color.emui_color_text_primary));
            this.f10644z.setBackground(getDrawable(R$drawable.hwbutton_default_emui));
            this.f10639u.setText(getString(R$string.album_uploading_speed));
            this.f10640v.setTextColor(getColor(R$color.color_189FFC));
            this.f10640v.setText(getString(R$string.album_upload_speed, C0223k.m1520c(this, this.f10630F)));
            this.f10641w.setVisibility(8);
            return;
        }
        if (i10 == 4) {
            this.f10644z.setText(getString(R$string.album_retry_uploading));
            this.f10644z.setTextColor(getColor(R$color.white));
            this.f10644z.setBackground(getDrawable(R$drawable.album_button_bg));
            this.f10639u.setText(getString(R$string.album_uploading_status));
            this.f10640v.setTextColor(getColor(R$color.invate_code_dialog_error_msg));
            this.f10640v.setText(getString(R$string.album_fail_status));
            this.f10641w.setVisibility(0);
            return;
        }
        if (i10 == 6) {
            this.f10644z.setText(getString(R$string.album_upload_complete_back));
            this.f10644z.setTextColor(getColor(R$color.emui_color_text_primary));
            this.f10644z.setBackground(getDrawable(R$drawable.hwbutton_default_emui));
            this.f10639u.setText(getString(R$string.album_uploading_status));
            this.f10640v.setTextColor(getColor(R$color.color_189FFC));
            this.f10640v.setText(getString(R$string.album_upload_complete));
            this.f10641w.setVisibility(8);
        }
    }

    /* renamed from: e2 */
    public final void m13976e2(int i10, int i11) {
        this.f10637s.setText(getString(R$string.cloudbackup_backupmedia_tip, String.valueOf(i11), String.valueOf(i10)));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws SQLException {
        if (C0209d.m1226Y0()) {
            return;
        }
        int id2 = view.getId();
        if (id2 != R$id.upload_progress_op_btn) {
            if (id2 == R$id.action_bar_end_task_frm) {
                C0069g.m479y().m505l(this.f10629E);
                setResult(305);
                finish();
                return;
            } else {
                if (id2 == R$id.ic_back_hot_space) {
                    finish();
                    return;
                }
                return;
            }
        }
        int i10 = this.f10625A;
        if (i10 == 2) {
            C0069g.m479y().m494O(this.f10629E);
        } else if (i10 == 3 || i10 == 4) {
            C0069g.m479y().m497R(this.f10629E);
        } else if (i10 == 6) {
            finish();
        }
        this.f10625A = C0069g.m479y().m485F(this.f10629E);
        m13975d2();
        C13108a.m78878b(this).m78881d(new Intent("album_status_change_action"));
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_upload_list);
        HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(getIntent());
        m13972c2(hiCloudSafeIntent);
        m22368H1();
        m13970a2();
        mo19005p1();
        m13969Z1(hiCloudSafeIntent);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        C0069g.m479y().m496Q(this.f10632H);
        ViewOnClickListenerC11636a viewOnClickListenerC11636a = this.f10631G;
        if (viewOnClickListenerC11636a == null || !viewOnClickListenerC11636a.isShowing()) {
            return;
        }
        this.f10631G.dismiss();
    }
}
