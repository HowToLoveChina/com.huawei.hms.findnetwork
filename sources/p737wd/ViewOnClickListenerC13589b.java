package p737wd;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.huawei.android.hicloud.p088ui.extend.AutoSizeButton;
import com.huawei.android.p073ds.R$color;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import p015ak.C0209d;
import p514o9.C11839m;
import p709vj.C13452e;
import sk.AlertDialogC12804a;
import sk.C12809f;

/* renamed from: wd.b */
/* loaded from: classes3.dex */
public class ViewOnClickListenerC13589b extends AlertDialogC12804a implements View.OnClickListener {

    /* renamed from: a */
    public int f61135a;

    /* renamed from: b */
    public Activity f61136b;

    /* renamed from: c */
    public TextView f61137c;

    /* renamed from: d */
    public TextView f61138d;

    /* renamed from: e */
    public AutoSizeButton f61139e;

    /* renamed from: f */
    public AutoSizeButton f61140f;

    /* renamed from: g */
    public AutoSizeButton f61141g;

    /* renamed from: h */
    public Boolean f61142h;

    /* renamed from: i */
    public String f61143i;

    /* renamed from: j */
    public String f61144j;

    /* renamed from: k */
    public String f61145k;

    /* renamed from: l */
    public Handler f61146l;

    public ViewOnClickListenerC13589b(Activity activity, Handler handler, int i10) {
        super(activity);
        if (activity == null) {
            C11839m.m70687e("FamilyShareNoSpaceDialog", "context is null");
            dismiss();
            return;
        }
        this.f61136b = activity;
        this.f61146l = handler;
        initView();
        this.f61135a = i10;
        if (i10 == 2016) {
            m81743b();
        } else {
            m81742a();
        }
    }

    /* renamed from: a */
    public final void m81742a() {
        Activity activity;
        int i10;
        Activity activity2;
        int i11;
        String strM80790C = C13452e.m80781L().m80790C();
        this.f61142h = Boolean.valueOf(C13452e.m80781L().m80811H0());
        C11839m.m70688i("FamilyShareNoSpaceDialog", "gradeCode is:" + strM80790C + ", isTopGrade:" + this.f61142h);
        String string = this.f61136b.getString(R$string.space_share_no_space_title);
        Activity activity3 = this.f61136b;
        int i12 = R$string.space_share_no_space_message;
        Object[] objArr = new Object[1];
        if (this.f61142h.booleanValue()) {
            activity = this.f61136b;
            i10 = R$string.space_share_no_space_message_2;
        } else {
            activity = this.f61136b;
            i10 = R$string.space_share_no_space_message_1;
        }
        objArr[0] = activity.getString(i10);
        String string2 = activity3.getString(i12, objArr);
        if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2)) {
            C11839m.m70687e("FamilyShareNoSpaceDialog", "no language");
            dismiss();
            this.f61136b.finish();
            return;
        }
        this.f61137c.setText(string);
        this.f61138d.setText(string2);
        if (C13452e.m80781L().m80887a1()) {
            activity2 = this.f61136b;
            i11 = R$string.change_plan;
        } else {
            activity2 = this.f61136b;
            i11 = R$string.upgrading_cloud_space;
        }
        this.f61143i = activity2.getString(i11);
        if (this.f61142h.booleanValue()) {
            this.f61143i = this.f61136b.getString(R$string.manage_space_title_new);
            this.f61140f.setVisibility(8);
        }
        this.f61144j = this.f61136b.getString(R$string.manage_space_title_new);
        this.f61145k = this.f61136b.getString(R$string.not_enabled_temporarily);
        this.f61139e.setText(this.f61143i);
        this.f61140f.setText(this.f61144j);
        this.f61141g.setText(this.f61145k);
    }

    /* renamed from: b */
    public final void m81743b() {
        Activity activity;
        int i10;
        Activity activity2;
        int i11;
        String strM80790C = C13452e.m80781L().m80790C();
        this.f61142h = Boolean.valueOf(C13452e.m80781L().m80811H0());
        C11839m.m70688i("FamilyShareNoSpaceDialog", "gradeCode is:" + strM80790C + ", isTopGrade:" + this.f61142h);
        String string = this.f61136b.getString(R$string.invite_space_share_no_space_title);
        Activity activity3 = this.f61136b;
        int i12 = R$string.invite_space_share_no_space_message;
        Object[] objArr = new Object[1];
        if (this.f61142h.booleanValue()) {
            activity = this.f61136b;
            i10 = R$string.invite_space_share_no_space_message_2;
        } else {
            activity = this.f61136b;
            i10 = R$string.invite_space_share_no_space_message_1;
        }
        objArr[0] = activity.getString(i10);
        String string2 = activity3.getString(i12, objArr);
        if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2)) {
            C11839m.m70687e("FamilyShareNoSpaceDialog", "no language");
            dismiss();
            this.f61136b.finish();
            return;
        }
        this.f61137c.setText(string);
        this.f61138d.setText(string2);
        if (C13452e.m80781L().m80887a1()) {
            activity2 = this.f61136b;
            i11 = R$string.change_plan;
        } else {
            activity2 = this.f61136b;
            i11 = R$string.upgrading_cloud_space;
        }
        this.f61143i = activity2.getString(i11);
        if (this.f61142h.booleanValue()) {
            this.f61143i = this.f61136b.getString(R$string.manage_space_title_new);
            this.f61140f.setVisibility(8);
        }
        this.f61144j = this.f61136b.getString(R$string.manage_space_title_new);
        this.f61145k = this.f61136b.getString(R$string.cloud_drive_got_it);
        this.f61139e.setText(this.f61143i);
        this.f61140f.setText(this.f61144j);
        this.f61141g.setText(this.f61145k);
    }

    public final void initView() {
        AutoSizeButton autoSizeButton;
        View viewInflate = LayoutInflater.from(this.f61136b).inflate(R$layout.family_share_no_space, (ViewGroup) null);
        this.f61137c = (TextView) C12809f.m76831d(viewInflate, R$id.tv_title);
        this.f61138d = (TextView) C12809f.m76831d(viewInflate, R$id.tv_content);
        this.f61139e = (AutoSizeButton) C12809f.m76831d(viewInflate, R$id.btn_positive);
        this.f61140f = (AutoSizeButton) C12809f.m76831d(viewInflate, R$id.btn_positive_2);
        AutoSizeButton autoSizeButton2 = (AutoSizeButton) C12809f.m76831d(viewInflate, R$id.btn_negation);
        this.f61141g = autoSizeButton2;
        if (this.f61137c == null || this.f61138d == null || (autoSizeButton = this.f61139e) == null || autoSizeButton2 == null) {
            C11839m.m70687e("FamilyShareNoSpaceDialog", "initView error");
            dismiss();
            this.f61136b.finish();
        } else {
            autoSizeButton.setOnClickListener(this);
            this.f61140f.setOnClickListener(this);
            this.f61141g.setOnClickListener(this);
            setView(viewInflate);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (C0209d.m1226Y0()) {
            C11839m.m70688i("FamilyShareNoSpaceDialog", "fast click");
            dismiss();
            this.f61136b.finish();
            return;
        }
        if (view == null) {
            C11839m.m70687e("FamilyShareNoSpaceDialog", "view is null");
            dismiss();
            this.f61136b.finish();
            return;
        }
        int id2 = view.getId();
        if (id2 == R$id.btn_positive) {
            C11839m.m70688i("FamilyShareNoSpaceDialog", "click positive");
            AutoSizeButton autoSizeButton = this.f61139e;
            if (autoSizeButton != null) {
                autoSizeButton.setEnabled(false);
            }
            AutoSizeButton autoSizeButton2 = this.f61140f;
            if (autoSizeButton2 != null) {
                autoSizeButton2.setTextColor(this.f61136b.getColor(R$color.stock_active_open_later_color_66));
                this.f61140f.setClickable(false);
            }
            AutoSizeButton autoSizeButton3 = this.f61141g;
            if (autoSizeButton3 != null) {
                autoSizeButton3.setTextColor(this.f61136b.getColor(R$color.stock_active_open_later_color_66));
                this.f61141g.setClickable(false);
            }
            if (this.f61142h.booleanValue()) {
                Message messageObtain = Message.obtain(this.f61146l);
                messageObtain.what = FamilyShareConstants.MessageCode.GO_TO_STORAGE_MANAGE;
                this.f61146l.sendMessage(messageObtain);
            } else {
                this.f61146l.sendEmptyMessageDelayed(2012, 500L);
            }
        } else if (id2 == R$id.btn_positive_2) {
            C11839m.m70688i("FamilyShareNoSpaceDialog", "click positive second");
            Message messageObtain2 = Message.obtain(this.f61146l);
            messageObtain2.what = FamilyShareConstants.MessageCode.GO_TO_STORAGE_MANAGE;
            this.f61146l.sendMessage(messageObtain2);
        } else if (id2 == R$id.btn_negation) {
            C11839m.m70688i("FamilyShareNoSpaceDialog", "click negation");
            if (this.f61135a == 2010) {
                this.f61136b.finish();
            }
        }
        dismiss();
    }
}
