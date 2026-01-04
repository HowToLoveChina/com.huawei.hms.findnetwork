package com.huawei.android.hicloud.p088ui.activity;

import ae.C0178w1;
import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.TypefaceSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.android.hicloud.cloudbackup.service.CloudBackupService;
import com.huawei.android.hicloud.cloudspace.bean.BackupStorageInfo;
import com.huawei.android.hicloud.cloudspace.bean.CBSpaceDetail;
import com.huawei.android.hicloud.commonlib.view.SpanClickText;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.hicloud.hisync.model.BackupDetailItem;
import com.huawei.android.hicloud.p088ui.activity.CloudSpaceBackupActivity;
import com.huawei.android.hicloud.p088ui.common.HiCloudExceptionView;
import com.huawei.android.hicloud.p088ui.common.UnionSwitch;
import com.huawei.android.hicloud.p088ui.extend.AutoSizeButton;
import com.huawei.android.hicloud.p088ui.extend.NotchFitLinearLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchFitRelativeLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchTopFitRelativeLayout;
import com.huawei.android.hicloud.p088ui.fragment.TempBackupRecordsCBSpaceDetailFragment;
import com.huawei.android.hicloud.p088ui.uiextend.TipPopupLayout;
import com.huawei.android.p073ds.R$color;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$plurals;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.base.p103ui.uiextend.ScrollDisabledListView;
import com.huawei.hicloud.notification.constants.BackUpOverMonthRecordConstants;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.notification.p106db.bean.RecommendCardReport;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hicloud.request.appmashup.bean.C4987f;
import com.huawei.hms.network.embedded.C6148x2;
import com.huawei.secure.android.common.intent.SafeIntent;
import fk.C9721b;
import gl.C9964e;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import mk.C11476b;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0223k;
import p015ak.C0241z;
import p252e9.C9426c;
import p292fn.C9733f;
import p514o9.C11829c;
import p514o9.C11839m;
import p514o9.C11842p;
import p572qb.C12312h0;
import p581qk.AbstractC12367d;
import p616rk.C12515a;
import p618rm.C12590s0;
import p681uj.C13195l;
import p684un.C13225d;
import p684un.C13230i;
import p709vj.C13452e;
import p783xp.C13843a;
import p815ym.AbstractC14026a;
import p836z8.C14157f;
import p847zk.C14329v;
import pm.C12178e;
import sk.C12809f;

/* loaded from: classes3.dex */
public class CloudSpaceBackupActivity extends UIManagerActivity {

    /* renamed from: N0 */
    public LinearLayout f14391N0;

    /* renamed from: O0 */
    public TextView f14392O0;

    /* renamed from: P0 */
    public TextView f14393P0;

    /* renamed from: Q0 */
    public ScrollDisabledListView f14394Q0;

    /* renamed from: R0 */
    public NotchFitRelativeLayout f14395R0;

    /* renamed from: S0 */
    public TempBackupRecordsCBSpaceDetailFragment f14396S0;

    /* renamed from: T0 */
    public NotchFitRelativeLayout f14397T0;

    /* renamed from: U0 */
    public NotchFitRelativeLayout f14398U0;

    /* renamed from: V0 */
    public AutoSizeButton f14399V0;

    /* renamed from: W0 */
    public TextView f14400W0;

    /* renamed from: X0 */
    public NotchFitRelativeLayout f14401X0;

    /* renamed from: Y0 */
    public RelativeLayout f14402Y0;

    /* renamed from: Z0 */
    public RelativeLayout f14403Z0;

    /* renamed from: a1 */
    public TextView f14404a1;

    /* renamed from: b1 */
    public NotchFitLinearLayout f14405b1;

    /* renamed from: c1 */
    public TipPopupLayout f14406c1;

    /* renamed from: d1 */
    public NotchTopFitRelativeLayout f14407d1;

    /* renamed from: e1 */
    public NotchFitLinearLayout f14408e1;

    /* renamed from: f1 */
    public NotchFitRelativeLayout f14409f1;

    /* renamed from: g1 */
    public TextView f14410g1;

    /* renamed from: h1 */
    public NotchFitRelativeLayout f14411h1;

    /* renamed from: i1 */
    public ImageView f14412i1;

    /* renamed from: j1 */
    public C0178w1 f14413j1;

    /* renamed from: k1 */
    public UnionSwitch f14414k1;

    /* renamed from: m1 */
    public int f14416m1;

    /* renamed from: n1 */
    public View f14417n1;

    /* renamed from: o1 */
    public LinearLayout f14418o1;

    /* renamed from: p1 */
    public boolean f14419p1;

    /* renamed from: q1 */
    public boolean f14420q1;

    /* renamed from: l1 */
    public RecommendCardReport f14415l1 = new RecommendCardReport();

    /* renamed from: r1 */
    public boolean f14421r1 = false;

    /* renamed from: s1 */
    public long f14422s1 = 0;

    /* renamed from: t1 */
    public final Handler f14423t1 = new HandlerC3232a();

    /* renamed from: u1 */
    public Handler.Callback f14424u1 = new C3233b();

    public static class OtherClickableSpan extends C3237f {
        public OtherClickableSpan(Context context) {
            super(context, new View.OnClickListener() { // from class: com.huawei.android.hicloud.ui.activity.g4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CloudSpaceBackupActivity.OtherClickableSpan.m19997c(view);
                }
            });
        }

        /* renamed from: c */
        public static /* synthetic */ void m19997c(View view) {
            CloudBackupService.getInstance().getBackupLinkAddress(3209);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.CloudSpaceBackupActivity$a */
    public class HandlerC3232a extends Handler {
        public HandlerC3232a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) throws Resources.NotFoundException {
            int i10 = message.what;
            if (i10 == 1001) {
                CloudSpaceBackupActivity.this.m19991q3((BackupStorageInfo) message.obj);
                CloudSpaceBackupActivity.this.f14397T0.setVisibility(8);
                if (CloudSpaceBackupActivity.this.f14421r1) {
                    CloudSpaceBackupActivity.this.f14394Q0.setVisibility(0);
                    C12809f.m76843p(CloudSpaceBackupActivity.this.f14405b1, true);
                    C12809f.m76843p(CloudSpaceBackupActivity.this.f14411h1, false);
                    CloudSpaceBackupActivity.this.m19983C3();
                } else {
                    CloudSpaceBackupActivity.this.f14403Z0.setVisibility(0);
                    C12809f.m76843p(CloudSpaceBackupActivity.this.f14411h1, false);
                    CloudSpaceBackupActivity.this.f14391N0.setVisibility(8);
                }
                C11839m.m70688i("CloudSpaceBackupActivity", "query device records success");
                return;
            }
            if (i10 == 1002) {
                CloudSpaceBackupActivity.this.f14397T0.setVisibility(8);
                CloudSpaceBackupActivity.this.m19986H3(2);
                C12809f.m76843p(CloudSpaceBackupActivity.this.f14411h1, false);
                C11839m.m70688i("CloudSpaceBackupActivity", "net not in server ");
                return;
            }
            if (i10 == 10104) {
                CloudSpaceBackupActivity.this.f14397T0.setVisibility(8);
                if (C13452e.m80781L().m80887a1()) {
                    CloudSpaceBackupActivity.this.f14410g1.setVisibility(8);
                    return;
                }
                CloudSpaceBackupActivity.this.f14410g1.setVisibility(0);
                CloudSpaceBackupActivity.this.m19985G3(((Long) message.obj).longValue());
                return;
            }
            if (i10 == 1003) {
                C11839m.m70688i("CloudSpaceBackupActivity", "auto clear switch request fail");
                if (CloudSpaceBackupActivity.this.f14414k1 != null && (message.obj instanceof Boolean)) {
                    CloudSpaceBackupActivity.this.f14414k1.setCheckedProgrammatically(!((Boolean) message.obj).booleanValue());
                }
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.CloudSpaceBackupActivity$b */
    public class C3233b implements Handler.Callback {
        public C3233b() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i10 = message.what;
            if (32309 == i10) {
                if (C11829c.m70581h0(CloudSpaceBackupActivity.class, CloudSpaceBackupActivity.this)) {
                    C11839m.m70688i("CloudSpaceBackupActivity", "handleMessage queryBackupRecords");
                    CloudSpaceBackupActivity.this.m19979z3();
                    Intent intent = new Intent();
                    intent.putExtra("delete_all_backup", CloudSpaceBackupActivity.this.f14413j1.getCount() == 0);
                    CloudSpaceBackupActivity.this.setResult(102, intent);
                }
            } else if (33039 == i10) {
                if (C11829c.m70581h0(CloudSpaceBackupActivity.class, CloudSpaceBackupActivity.this)) {
                    C11839m.m70688i("CloudSpaceBackupActivity", "pushCallback queryBackupRecords");
                    CloudSpaceBackupActivity.this.m19979z3();
                }
            } else if (3209 == i10) {
                C12590s0.m75755I0(C0213f.m1377a(), message.obj.toString());
            } else if (33055 == i10 && CloudSpaceBackupActivity.this.f14413j1 != null) {
                CloudSpaceBackupActivity.this.f14413j1.notifyDataSetChanged();
            }
            return false;
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.CloudSpaceBackupActivity$c */
    public class C3234c extends AbstractC12367d {
        public C3234c() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            C4987f c4987f;
            Message messageObtain = Message.obtain();
            ArrayList arrayList = new ArrayList();
            arrayList.add("bs.userdata.expired.time");
            List<C4987f> listM84949i = C14157f.m84942g().m84949i(null, arrayList, "QueryExpire");
            long jM1688f = (listM84949i == null || listM84949i.isEmpty() || (c4987f = listM84949i.get(0)) == null) ? 0L : C0241z.m1688f(c4987f.m30027c());
            messageObtain.what = 10104;
            messageObtain.obj = Long.valueOf(jM1688f);
            CloudSpaceBackupActivity.this.f14423t1.sendMessage(messageObtain);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.CloudSpaceBackupActivity$d */
    public static class C3235d implements Comparator<CBSpaceDetail>, Serializable {
        private static final long serialVersionUID = 5699171561950138319L;

        @Override // java.util.Comparator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public int compare(CBSpaceDetail cBSpaceDetail, CBSpaceDetail cBSpaceDetail2) {
            if (cBSpaceDetail2.getSize() > cBSpaceDetail.getSize()) {
                return 1;
            }
            return cBSpaceDetail2.getSize() < cBSpaceDetail.getSize() ? -1 : 0;
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.CloudSpaceBackupActivity$e */
    public class C3236e<T extends C3237f> extends LinkMovementMethod {

        /* renamed from: a */
        public T f14428a;

        /* renamed from: b */
        public Class<T> f14429b;

        public C3236e(Class<T> cls) {
            this.f14429b = cls;
        }

        @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
        public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
            this.f14428a = (T) CloudSpaceBackupActivity.this.m19988m3(textView, spannable, motionEvent, this.f14429b);
            if (motionEvent.getAction() == 0) {
                C11839m.m70688i("CloudSpaceBackupActivity", "DeviceLinkMovementMethod email on click");
                if (this.f14428a != null) {
                    C11839m.m70688i("CloudSpaceBackupActivity", "mSpan is not null");
                    this.f14428a.m19999a(true);
                }
            } else if (2 == motionEvent.getAction()) {
                C3237f c3237fM19988m3 = CloudSpaceBackupActivity.this.m19988m3(textView, spannable, motionEvent, this.f14429b);
                T t10 = this.f14428a;
                if (t10 != null && c3237fM19988m3 != t10) {
                    t10.m19999a(false);
                    this.f14428a = null;
                    Selection.removeSelection(spannable);
                }
            } else {
                Selection.removeSelection(spannable);
                T t11 = this.f14428a;
                if (t11 == null) {
                    return true;
                }
                t11.m19999a(false);
                this.f14428a = null;
            }
            return super.onTouchEvent(textView, spannable, motionEvent);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.CloudSpaceBackupActivity$f */
    public static class C3237f extends ClickableSpan {

        /* renamed from: a */
        public boolean f14431a = false;

        /* renamed from: b */
        public Context f14432b;

        /* renamed from: c */
        public View.OnClickListener f14433c;

        public C3237f(Context context, View.OnClickListener onClickListener) {
            this.f14432b = context;
            this.f14433c = onClickListener;
        }

        /* renamed from: a */
        public void m19999a(boolean z10) {
            this.f14431a = z10;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            View.OnClickListener onClickListener = this.f14433c;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.bgColor = this.f14432b.getResources().getColor(this.f14431a ? R$color.emui9_list_seletor_color : R$color.transparent);
            textPaint.setUnderlineText(false);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.CloudSpaceBackupActivity$g */
    public static class C3238g extends AbstractC12367d {

        /* renamed from: a */
        public final boolean f14434a;

        /* renamed from: b */
        public final Handler f14435b;

        public C3238g(boolean z10, Handler handler) {
            this.f14434a = z10;
            this.f14435b = handler;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            boolean zM61828q = C9964e.m61814f().m61828q(this.f14434a);
            Handler handler = this.f14435b;
            if (handler == null || zM61828q) {
                return;
            }
            Message messageObtainMessage = handler.obtainMessage(1003);
            messageObtainMessage.obj = Boolean.valueOf(this.f14434a);
            this.f14435b.sendMessage(messageObtainMessage);
        }
    }

    /* renamed from: D3 */
    private void m19952D3(final SpanClickText spanClickText, String str, String str2) {
        spanClickText.m15931c(str2, new SpanClickText.ISpanClickListener() { // from class: com.huawei.android.hicloud.ui.activity.d4
            @Override // com.huawei.android.hicloud.commonlib.view.SpanClickText.ISpanClickListener
            public final void onClick() {
                this.f17585a.m19993v3(spanClickText);
            }
        });
        spanClickText.m15934g(str, false);
    }

    /* renamed from: E3 */
    private void m19953E3() {
        View viewM76829b = C12809f.m76829b(this, R$id.set_network_not_connect);
        View viewM76829b2 = C12809f.m76829b(this, R$id.rl_fit_loading);
        C11842p.m70760Q1(this, viewM76829b);
        C11842p.m70760Q1(this, viewM76829b2);
    }

    /* renamed from: g2 */
    private void m19968g2() {
        this.f14407d1 = (NotchTopFitRelativeLayout) C12809f.m76829b(this, R$id.main_layout);
        this.f14405b1 = (NotchFitLinearLayout) C12809f.m76829b(this, R$id.nflin_backup_detail);
        TipPopupLayout tipPopupLayout = (TipPopupLayout) C12809f.m76829b(this, R$id.hot_features_help);
        this.f14406c1 = tipPopupLayout;
        tipPopupLayout.setImageViewPic(R$drawable.ic_sync_help_new);
        this.f14406c1.setClickListener(new View.OnClickListener() { // from class: com.huawei.android.hicloud.ui.activity.e4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f17596a.m19977u3(view);
            }
        });
        this.f14406c1.setTipTxtStr(getString(R$string.device_backup_tips));
        this.f14408e1 = (NotchFitLinearLayout) C12809f.m76829b(this, R$id.other_device_category);
        this.f14409f1 = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.ll_backup_device_tips);
        this.f14410g1 = (TextView) C12809f.m76829b(this, R$id.backup_device_tips);
        this.f14391N0 = (LinearLayout) C12809f.m76829b(this, R$id.backups_detail_frame);
        this.f14392O0 = (TextView) C12809f.m76829b(this, R$id.tv_devices_num);
        this.f14393P0 = (TextView) C12809f.m76829b(this, R$id.data_size_used);
        this.f16199N = (RelativeLayout) C12809f.m76829b(this, R$id.data_size_frame);
        this.f14394Q0 = (ScrollDisabledListView) C12809f.m76829b(this, R$id.device_list);
        this.f14395R0 = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.rl_fragment_temp_backup_records);
        this.f14396S0 = (TempBackupRecordsCBSpaceDetailFragment) C12809f.m76828a(getFragmentManager(), R$id.fragment_temp_backup_records);
        this.f14397T0 = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.backups_loading);
        this.f14401X0 = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.backup_content);
        this.f14404a1 = (TextView) C12809f.m76829b(this, R$id.other_device_title);
        int i10 = R$id.set_query_server_info_nonet;
        this.f14398U0 = (NotchFitRelativeLayout) C12809f.m76829b(this, i10);
        this.f14399V0 = (AutoSizeButton) C12809f.m76829b(this, R$id.set_no_net_btn);
        this.f14400W0 = (TextView) C12809f.m76829b(this, R$id.set_no_network_text);
        this.f16192J0 = (HiCloudExceptionView) C12809f.m76829b(this, R$id.exception_view);
        this.f14402Y0 = (RelativeLayout) C12809f.m76829b(this, i10);
        this.f14403Z0 = (RelativeLayout) C12809f.m76829b(this, R$id.set_query_server_info_no_record);
        this.f14412i1 = (ImageView) C12809f.m76829b(this, R$id.general_detail_page_icon);
        View viewInflate = getLayoutInflater().inflate(R$layout.cloud_space_backup_activity_device_list_header, (ViewGroup) null);
        this.f14417n1 = viewInflate;
        this.f14418o1 = (LinearLayout) C12809f.m76831d(viewInflate, R$id.header_view);
        m19990o3();
        this.f14412i1.setImageDrawable(getDrawable(R$drawable.ic_base_backup_item));
        this.f14402Y0.setOnClickListener(this);
        this.f14399V0.setOnClickListener(this);
        C11842p.m70874v1(this, this.f14399V0);
        this.f14413j1 = new C0178w1(this, this, this.f14416m1 == 3);
        this.f14394Q0.addHeaderView(this.f14417n1);
        this.f14417n1.setVisibility(8);
        C12809f.m76843p(this.f14418o1, false);
        this.f14394Q0.setAdapter((ListAdapter) this.f14413j1);
        m19953E3();
    }

    /* renamed from: p3 */
    private void m19974p3() {
        View view = this.f14417n1;
        if (view == null) {
            C11839m.m70689w("CloudSpaceBackupActivity", "deviceListHeaderView is null");
            return;
        }
        if (this.f14416m1 == 3) {
            C11839m.m70688i("CloudSpaceBackupActivity", "Don't need to show duplicate device name for basic data user.");
            return;
        }
        SpanClickText spanClickText = (SpanClickText) C12809f.m76831d(view, R$id.device_name_duplicate_tip);
        String string = getString(R$string.login_devices_management_prompt);
        m19952D3(spanClickText, getString(R$string.backup_device_names_duplicate_prompt, string), string);
        spanClickText.setVisibility(0);
        this.f14417n1.setVisibility(0);
        C12809f.m76843p(this.f14418o1, true);
    }

    /* renamed from: r3 */
    private boolean m19975r3() {
        long j10 = this.f14422s1;
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.f14422s1 = jCurrentTimeMillis;
        return jCurrentTimeMillis - j10 <= 1000;
    }

    /* renamed from: s3 */
    private void m19976s3() {
        try {
            Intent intentM79271I = C13195l.m79271I(this, "hwid://com.huawei.hwid/DeviceManager");
            if (intentM79271I == null) {
                C11839m.m70687e("CloudSpaceBackupActivity", "hmsPackage is invalid!");
            } else {
                startActivityForResult(intentM79271I, 10055);
            }
        } catch (Exception e10) {
            C11839m.m70688i("CloudSpaceBackupActivity", "jumpToHmsDeviceManager exception: " + e10.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u3 */
    public /* synthetic */ void m19977u3(View view) {
        this.f14406c1.onClick(view);
    }

    /* renamed from: y3 */
    private void m19978y3(ScrollDisabledListView scrollDisabledListView, BaseAdapter baseAdapter) {
        baseAdapter.notifyDataSetChanged();
        C2783d.m16170p1(scrollDisabledListView, baseAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z3 */
    public void m19979z3() {
        this.f14397T0.setVisibility(0);
        C12809f.m76843p(this.f14411h1, false);
        C12809f.m76843p(this.f14408e1, false);
        C12809f.m76843p(this.f14409f1, false);
        C12809f.m76843p(this.f14394Q0, false);
        C12515a.m75110o().m75175e(new C12178e(this.f14423t1, this.f14420q1 ? 1 : 0), false);
    }

    /* renamed from: A3 */
    public final void m19980A3() {
        C12515a.m75110o().m75175e(new C3234c(), false);
    }

    /* renamed from: B3 */
    public final void m19981B3(List<CBSpaceDetail> list) {
        C11839m.m70688i("CloudSpaceBackupActivity", "refreshBackupList size=" + list.size());
        this.f14413j1.m974c();
        int i10 = this.f14416m1;
        boolean z10 = true;
        if (i10 == 1 || i10 == 3) {
            C11839m.m70688i("CloudSpaceBackupActivity", "refreshBackupList Sorting is not required");
        } else {
            Collections.sort(list, new C3235d());
        }
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        boolean z11 = false;
        for (CBSpaceDetail cBSpaceDetail : list) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("device name:");
            sb2.append(cBSpaceDetail.getDeviceName());
            sb2.append(",device backup size = ");
            sb2.append(cBSpaceDetail.getSize());
            sb2.append(" refurbish:");
            sb2.append(cBSpaceDetail.isOnlyRefurbish() || cBSpaceDetail.isHasRefurbish());
            sb2.append(",lastBackupTime:");
            sb2.append(cBSpaceDetail.getLastbackupTime());
            C11839m.m70688i("CloudSpaceBackupActivity", sb2.toString());
            if (cBSpaceDetail.getSize() > 0 || cBSpaceDetail.isOnlyRefurbish() || cBSpaceDetail.isHasRefurbish() || cBSpaceDetail.getLastbackupTime() > 0) {
                if (this.f14416m1 == 3 && cBSpaceDetail.getLastbackupTime() == 0) {
                    C11839m.m70688i("CloudSpaceBackupActivity", "from basic data user and backup record not finished.");
                } else {
                    if (!cBSpaceDetail.isTempBackup()) {
                        this.f14413j1.m973b(cBSpaceDetail);
                    } else if (cBSpaceDetail.isCurrent()) {
                        arrayList.add(0, cBSpaceDetail);
                    } else {
                        arrayList.add(cBSpaceDetail);
                    }
                    if (!cBSpaceDetail.isCurrent()) {
                        String str = cBSpaceDetail.getDeviceCategory() + "_" + cBSpaceDetail.getDeviceName().trim();
                        if (!hashSet.contains(str)) {
                            hashSet.add(str);
                        } else if (this.f14419p1) {
                            z11 = true;
                        }
                    }
                }
            }
        }
        if (this.f14413j1.getCount() == 0) {
            this.f14401X0.setVisibility(8);
            this.f14408e1.setVisibility(8);
            this.f14409f1.setVisibility(8);
        } else {
            this.f14401X0.setVisibility(0);
            this.f14408e1.setVisibility(0);
            m19980A3();
            if (z11) {
                m19974p3();
            } else {
                View view = this.f14417n1;
                if (view != null) {
                    view.setVisibility(8);
                }
                C12809f.m76843p(this.f14418o1, false);
            }
        }
        m19978y3(this.f14394Q0, this.f14413j1);
        this.f14396S0.m24321h(this.f14416m1);
        this.f14396S0.m24320g(arrayList);
        if (AbstractC14026a.m84159a(arrayList)) {
            this.f14396S0.m24322i(8);
        } else {
            this.f14396S0.m24322i(0);
        }
        if (this.f14413j1.getCount() <= 0 && AbstractC14026a.m84159a(arrayList)) {
            z10 = false;
        }
        this.f14421r1 = z10;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: C1 */
    public void mo19982C1() throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            int i10 = R$color.hicloud_hmos_bg;
            C11842p.m70842n1(actionBar, new ColorDrawable(getColor(i10)));
            actionBar.setBackgroundDrawable(new ColorDrawable(getColor(i10)));
            Window window = getWindow();
            if (window != null) {
                window.setStatusBarColor(getColor(i10));
            }
        }
    }

    /* renamed from: C3 */
    public final void m19983C3() {
        if (C13452e.m80781L().m80887a1()) {
            this.f14406c1.setVisibility(8);
        } else {
            this.f14406c1.setVisibility(0);
        }
        if (this.f14416m1 == 3) {
            this.f14405b1.setVisibility(8);
            this.f14404a1.setText(R$string.cloud_backup_all_device);
        } else {
            this.f14405b1.setVisibility(0);
            this.f14404a1.setText(R$string.all_devices_backup);
        }
    }

    /* renamed from: F3 */
    public final void m19984F3(BackupStorageInfo backupStorageInfo) throws Resources.NotFoundException {
        List<CBSpaceDetail> backupDetails = backupStorageInfo.getBackupDetails();
        if (backupDetails == null) {
            C11839m.m70687e("CloudSpaceBackupActivity", "setTotalDeviceNum otherList null");
            return;
        }
        if (getResources() == null) {
            C11839m.m70687e("CloudSpaceBackupActivity", "deviceNum resources is null");
            return;
        }
        if (this.f14392O0 == null) {
            C11839m.m70687e("CloudSpaceBackupActivity", "deviceNumView is null");
            return;
        }
        long backupUsedSize = backupStorageInfo.getBackupUsedSize();
        if (backupUsedSize <= 0) {
            this.f16199N.setVisibility(8);
        } else {
            this.f16199N.setVisibility(0);
            this.f14393P0.setText(C0223k.m1524g(this, backupUsedSize));
        }
        if (backupDetails.isEmpty()) {
            this.f14392O0.setVisibility(8);
            return;
        }
        HashMap map = new HashMap();
        for (CBSpaceDetail cBSpaceDetail : backupDetails) {
            if (cBSpaceDetail.getSize() > 0 || cBSpaceDetail.getLastbackupTime() > 0) {
                if (!map.containsKey(cBSpaceDetail.getBackupDeviceId())) {
                    map.put(cBSpaceDetail.getBackupDeviceId(), cBSpaceDetail);
                }
            }
        }
        int size = map.size();
        this.f14392O0.setText(C2783d.m16095M(getResources().getQuantityString(R$plurals.backups_device_num1, size, Integer.valueOf(size)), Integer.valueOf(size)));
    }

    /* renamed from: G3 */
    public final void m19985G3(long j10) throws Resources.NotFoundException {
        long jM74028c = C12312h0.m74027b().m74028c();
        int iM75822Z = C12590s0.m75822Z(jM74028c, j10);
        C11839m.m70688i("CloudSpaceBackupActivity", "showBottomTips serverTime: " + jM74028c + " ,expireTime: " + j10 + " ,days: " + iM75822Z);
        if (iM75822Z > 60 || iM75822Z <= 0) {
            return;
        }
        this.f14409f1.setVisibility(0);
        Resources resources = getResources();
        if (resources == null) {
            C11839m.m70689w("CloudSpaceBackupActivity", "showBottomTips resources is null");
            return;
        }
        String string = resources.getString(R$string.cloud_backup_basic_data);
        String string2 = resources.getString(R$string.cloud_backup_basic_service_fixing_tips, string, getResources().getQuantityString(R$plurals.backup_guide_tip_days, iM75822Z, Integer.valueOf(iM75822Z)));
        int iLastIndexOf = string2.lastIndexOf(string);
        int length = string.length() + iLastIndexOf;
        this.f14410g1.setMovementMethod(new C3236e(OtherClickableSpan.class));
        SpannableString spannableString = new SpannableString(string2);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R$color.stock_active_open_later_color_ff)), iLastIndexOf, length, 33);
        spannableString.setSpan(new TypefaceSpan("HwChinese-medium"), iLastIndexOf, length, 33);
        spannableString.setSpan(new OtherClickableSpan(this), iLastIndexOf, length, 33);
        this.f14410g1.setText(spannableString);
    }

    /* renamed from: H3 */
    public final void m19986H3(int i10) {
        this.f14391N0.setVisibility(8);
        this.f14402Y0.setVisibility(0);
        if (1 == i10) {
            this.f14400W0.setText(R$string.network_unavailable);
            this.f14399V0.setVisibility(0);
            this.f14402Y0.setClickable(true);
            this.f14402Y0.setEnabled(true);
            return;
        }
        if (2 == i10) {
            this.f14400W0.setText(R$string.recovery_no_data_server_error);
            this.f14399V0.setVisibility(8);
            this.f14402Y0.setClickable(true);
            this.f14402Y0.setEnabled(true);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: b1 */
    public C13230i mo18601b1() {
        return C13225d.m79490f1();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIManagerActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: d1 */
    public List<View> mo13289d1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f14407d1);
        arrayList.add(this.f16192J0);
        arrayList.add(this.f14405b1);
        arrayList.add(this.f14408e1);
        arrayList.add(this.f14409f1);
        arrayList.add(this.f14411h1);
        arrayList.add(this.f14401X0);
        arrayList.add(this.f14395R0);
        return arrayList;
    }

    /* renamed from: l3 */
    public final void m19987l3(boolean z10) {
        if (z10) {
            C12809f.m76843p(this.f14405b1, false);
        }
    }

    /* renamed from: m3 */
    public final <T extends C3237f> T m19988m3(TextView textView, Spannable spannable, MotionEvent motionEvent, Class<T> cls) {
        int x10 = (int) motionEvent.getX();
        int y10 = (int) motionEvent.getY();
        int totalPaddingLeft = x10 - textView.getTotalPaddingLeft();
        int totalPaddingTop = y10 - textView.getTotalPaddingTop();
        int scrollX = totalPaddingLeft + textView.getScrollX();
        int scrollY = totalPaddingTop + textView.getScrollY();
        Layout layout = textView.getLayout();
        int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(scrollY), scrollX);
        C3237f[] c3237fArr = (C3237f[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, cls);
        if (c3237fArr.length > 0) {
            return (T) c3237fArr[0];
        }
        return null;
    }

    /* renamed from: n3 */
    public final CBSpaceDetail m19989n3(View view) {
        C0178w1.a aVar = (C0178w1.a) view.getTag();
        if (aVar == null) {
            C11839m.m70688i("CloudSpaceBackupActivity", "View has not holder.");
            return null;
        }
        return (CBSpaceDetail) this.f14413j1.getItem(aVar.m984g());
    }

    /* renamed from: o3 */
    public final void m19990o3() {
        NotchFitRelativeLayout notchFitRelativeLayout = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.auto_delete_card);
        this.f14411h1 = notchFitRelativeLayout;
        notchFitRelativeLayout.setVisibility(8);
        TextView textView = (TextView) C12809f.m76829b(this, R$id.clear_backup_switch_sub_title);
        int iM59112e = C9426c.m59108d().m59112e();
        textView.setText(getResources().getQuantityString(R$plurals.auto_clear_backup_sub_title, iM59112e, Integer.valueOf(iM59112e)));
        UnionSwitch unionSwitch = (UnionSwitch) C12809f.m76829b(this, R$id.clear_backup_switch_btn);
        this.f14414k1 = unionSwitch;
        unionSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.huawei.android.hicloud.ui.activity.f4
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                this.f17608a.m19992t3(compoundButton, z10);
            }
        });
        this.f14414k1.setCheckedProgrammatically(C9426c.m59108d().m59111c());
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if ((10047 != i10 && 10024 != i10 && this.f14416m1 != 3) || 101 != i11) {
            if (i10 == 10055) {
                this.f14420q1 = true;
                C12515a.m75110o().m75175e(new C12178e(this.f14423t1, 1), false);
                return;
            }
            return;
        }
        if (intent == null) {
            return;
        }
        SafeIntent safeIntent = new SafeIntent(intent);
        String stringExtra = safeIntent.getStringExtra("bak_id");
        if (!TextUtils.isEmpty(stringExtra)) {
            this.f14394Q0.setVisibility(8);
            this.f14396S0.m24322i(8);
            this.f14396S0.m24319f(stringExtra);
            m19979z3();
            return;
        }
        Bundle extras = safeIntent.getExtras();
        if (extras == null) {
            return;
        }
        String string = extras.getString(C6148x2.DEVICE_ID);
        if (TextUtils.isEmpty(string)) {
            BackupDetailItem backupDetailItem = (BackupDetailItem) extras.getParcelable("backup_item_param");
            if (backupDetailItem == null) {
                C11839m.m70688i("CloudSpaceBackupActivity", "backupItem is empty");
                return;
            } else {
                if (TextUtils.isEmpty(backupDetailItem.m16379h())) {
                    C11839m.m70688i("CloudSpaceBackupActivity", "deviceId is empty");
                    return;
                }
                string = backupDetailItem.m16379h();
            }
        }
        C14329v.m85349e0().m85396N0(C11476b.m68626h(string));
        if (this.f14413j1 == null) {
            return;
        }
        this.f14394Q0.setVisibility(8);
        this.f14396S0.m24322i(8);
        this.f14413j1.m975d(string);
        this.f14413j1.notifyDataSetChanged();
        m19979z3();
        Intent intent2 = new Intent();
        intent2.putExtra("delete_all_backup", this.f14413j1.getCount() == 0);
        setResult(102, intent2);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIManagerActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (C0209d.m1226Y0()) {
            return;
        }
        int id2 = view.getId();
        if (R$id.backup_detail == id2) {
            if (this.f14416m1 == 3) {
                m19995x3(view);
                return;
            } else {
                m19994w3(view);
                return;
            }
        }
        if (R$id.set_no_net_btn == id2) {
            C11829c.m70612r1(this);
            return;
        }
        if (R$id.set_query_server_info_nonet == id2) {
            if (!C0209d.m1333z1(this)) {
                m19986H3(1);
                return;
            }
            this.f14402Y0.setVisibility(8);
            this.f16192J0.m23914a();
            this.f14391N0.setVisibility(0);
            m19979z3();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIManagerActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C11842p.m70874v1(this, this.f14399V0);
        m19953E3();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIManagerActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        m29138V0();
        super.onCreate(bundle);
        if (!C13843a.m83076a0(this)) {
            setRequestedOrientation(1);
        }
        if (C0209d.m1195O(this) >= 3.2f) {
            setContentView(R$layout.cloud_space_backup_activity_font_scale);
        } else {
            setContentView(R$layout.cloud_space_backup_activity);
        }
        SafeIntent safeIntent = new SafeIntent(getIntent());
        this.f14416m1 = safeIntent.getIntExtra(FamilyShareConstants.ENTRY_TYPE, -1);
        this.f14420q1 = safeIntent.getBooleanExtra("queryType", false);
        C11839m.m70688i("CloudSpaceBackupActivity", "onCreate entryType = " + this.f14416m1);
        CloudBackupService.getInstance().register(this.f14424u1);
        m19968g2();
        m19987l3(this.f14416m1 == 2);
        if (this.f14416m1 == 3) {
            m19983C3();
            m22365E1(R$string.backup_records);
        } else {
            m22365E1(R$string.cloud_backup_item_title);
        }
        mo19982C1();
        mo19005p1();
        if (C0209d.m1333z1(this)) {
            m19979z3();
        } else {
            m19986H3(1);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIManagerActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.f14424u1 != null) {
            CloudBackupService.getInstance().unregister(this.f14424u1);
        }
        TipPopupLayout tipPopupLayout = this.f14406c1;
        if (tipPopupLayout != null) {
            tipPopupLayout.dismiss();
        }
        C14329v.m85349e0().m85407T();
        C12515a.m75110o().m75166b(C12178e.class.getName());
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIManagerActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    /* renamed from: q3 */
    public final void m19991q3(BackupStorageInfo backupStorageInfo) throws Resources.NotFoundException {
        C11839m.m70688i("CloudSpaceBackupActivity", "initdata storageInfo");
        if (C9733f.m60705z().m60720O("cloudBackupDeviceNameManagement")) {
            this.f14419p1 = true;
        }
        this.f14402Y0.setVisibility(8);
        this.f14391N0.setVisibility(0);
        m19984F3(backupStorageInfo);
        m19981B3(backupStorageInfo.getBackupDetails());
        C2783d.m16191y0(this.f14415l1, getIntent());
    }

    /* renamed from: t3 */
    public final /* synthetic */ void m19992t3(CompoundButton compoundButton, boolean z10) {
        if (R$id.clear_backup_switch_btn == compoundButton.getId()) {
            if (C0209d.m1226Y0() || this.f16192J0 == null) {
                this.f14414k1.setCheckedProgrammatically(!z10);
                C11839m.m70689w("CloudSpaceBackupActivity", "click too fast");
            } else if (!C0209d.m1333z1(this)) {
                this.f16192J0.m23919i();
                this.f14414k1.setCheckedProgrammatically(!z10);
            } else {
                this.f16192J0.m23914a();
                C12515a.m75110o().m75172d(new C3238g(z10, this.f14423t1));
                C9426c.m59108d().m59115h(z10);
                C9426c.m59108d().m59114g("CKC", z10 ? BackUpOverMonthRecordConstants.Report.CLICK_OPEN_SWITCH : BackUpOverMonthRecordConstants.Report.CLICK_CLOSE_SWITCH);
            }
        }
    }

    /* renamed from: v3 */
    public final /* synthetic */ void m19993v3(SpanClickText spanClickText) {
        if (m19975r3() || spanClickText == null) {
            return;
        }
        C11839m.m70688i("CloudSpaceBackupActivity", "set click");
        m19976s3();
    }

    /* renamed from: w3 */
    public final void m19994w3(View view) {
        if (!C0209d.m1333z1(this)) {
            this.f16192J0.m23919i();
            return;
        }
        int iM984g = ((C0178w1.a) view.getTag()).m984g();
        if (iM984g < 0) {
            return;
        }
        BackupDetailItem backupDetailItem = new BackupDetailItem();
        CBSpaceDetail cBSpaceDetail = (CBSpaceDetail) this.f14413j1.getItem(iM984g);
        if (cBSpaceDetail == null) {
            return;
        }
        backupDetailItem.m16373a(cBSpaceDetail);
        backupDetailItem.m16368A(String.valueOf(cBSpaceDetail.getLastbackupTime()));
        LinkedHashMap linkedHashMapM79499C = C13230i.m79499C(C13452e.m80781L().m80971t0());
        linkedHashMapM79499C.put("isCurrent", String.valueOf(backupDetailItem.m16376e() == 1));
        C13225d.m79490f1().m79591l0("mecloud_cloudspace_click_backup_detail", linkedHashMapM79499C);
        UBAAnalyze.m29954O("PVC", "mecloud_cloudspace_click_backup_detail", "1", "43");
        C11839m.m70688i("CloudSpaceBackupActivity", "mecloud_cloudspace_click_backup_detail");
        backupDetailItem.m16372M(C0223k.m1524g(this, backupDetailItem.m16382l()));
        Intent intent = new Intent(this, (Class<?>) CloudSpaceBackupDetailActivity.class);
        intent.putExtra("backup_delete_report_entry", 2);
        intent.putExtra("recommend_card_activity_id", this.f14415l1.getActivityId());
        intent.putExtra("isOnlyRefurbish", cBSpaceDetail.isOnlyRefurbish());
        intent.putExtra("isOnlyHarmonyNext", cBSpaceDetail.isOnlyHarmonyNext());
        intent.putExtra("recommend_card_activity_type", this.f14415l1.getActivityType());
        intent.putExtra("recommend_card_entrance", this.f14415l1.getEntrance());
        intent.putExtra("backup_item_param", backupDetailItem);
        intent.putExtra("terminalType", cBSpaceDetail.getTerminalType());
        intent.putExtra("deviceCategory", cBSpaceDetail.getDeviceCategory());
        startActivityForResult(intent, 10024);
    }

    /* renamed from: x3 */
    public final void m19995x3(View view) {
        C11839m.m70688i("CloudSpaceBackupActivity", "navToBackupRecordPage");
        CBSpaceDetail cBSpaceDetailM19989n3 = m19989n3(view);
        if (cBSpaceDetailM19989n3 == null) {
            C11839m.m70689w("CloudSpaceBackupActivity", "Can not get detail for view, viewId: " + view.getId());
            return;
        }
        Intent intent = new Intent(this, (Class<?>) CloudBackupRecordsActivity.class);
        C13225d.m79490f1().m79585f0("mecloud_backupdetail_click_backup_restore", C13452e.m80781L().m80971t0());
        C13230i.m79525e1(intent, "1", "39");
        UBAAnalyze.m29954O("PVC", "mecloud_backupdetail_click_backup_restore", "1", "39");
        intent.putExtra("backup_device_id", cBSpaceDetailM19989n3.getBackupDeviceId());
        intent.putExtra(C6148x2.DEVICE_ID, cBSpaceDetailM19989n3.getDeviceID());
        intent.putExtra("is_current_device", cBSpaceDetailM19989n3.isCurrent());
        intent.putExtra("terminalType", cBSpaceDetailM19989n3.getTerminalType());
        intent.putExtra("deviceCategory", cBSpaceDetailM19989n3.getDeviceCategory());
        if (this.f14416m1 == 3) {
            intent.putExtra(FamilyShareConstants.ENTRY_TYPE, 3);
        } else {
            intent.putExtra(FamilyShareConstants.ENTRY_TYPE, 2);
        }
        intent.putExtra("backup_device_new", cBSpaceDetailM19989n3.getDeviceName());
        intent.putExtra("backup_data_size", cBSpaceDetailM19989n3.getSize());
        intent.putExtra("backup_device_category", cBSpaceDetailM19989n3.getDeviceCategory());
        startActivityForResult(intent, 10047);
    }
}
