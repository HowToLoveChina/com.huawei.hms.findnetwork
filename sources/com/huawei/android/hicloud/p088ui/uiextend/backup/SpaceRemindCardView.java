package com.huawei.android.hicloud.p088ui.uiextend.backup;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.C0782c0;
import androidx.lifecycle.C0786e0;
import androidx.lifecycle.InterfaceC0788f0;
import androidx.lifecycle.InterfaceC0796l;
import androidx.lifecycle.InterfaceC0802r;
import com.huawei.android.hicloud.p088ui.extend.HiCloudRoundRectImageView;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.util.GeneralRedirectUtil;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import java.util.LinkedHashMap;
import p015ak.C0209d;
import p514o9.C11839m;
import p514o9.C11842p;
import p519oe.C11850a;
import p684un.C13227f;
import p684un.C13230i;
import p709vj.C13452e;

/* loaded from: classes3.dex */
public class SpaceRemindCardView extends LinearLayout implements View.OnClickListener {
    private static final String TAG = "SpaceRemindCardView";
    private String jumpUrl;
    private final Context mContext;
    private TextView spaceRemindButton;
    private LinearLayout spaceRemindCardLayout;
    private TextView spaceRemindDescription;
    private HiCloudRoundRectImageView spaceRemindIcon;
    private TextView spaceRemindTitle;
    C11850a spaceRemindViewModel;
    private String userSpaceState;
    private int visible;

    public SpaceRemindCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.visible = 8;
        this.mContext = context;
        init(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void init(Context context) {
        LayoutInflater.from(context).inflate(R$layout.space_remind_card, (ViewGroup) this, true);
        this.spaceRemindCardLayout = (LinearLayout) findViewById(R$id.ll_space_remind_card_layout);
        this.spaceRemindIcon = (HiCloudRoundRectImageView) findViewById(R$id.space_remind_icon);
        this.spaceRemindTitle = (TextView) findViewById(R$id.space_remind_title);
        this.spaceRemindDescription = (TextView) findViewById(R$id.space_remind_description);
        this.spaceRemindButton = (TextView) findViewById(R$id.space_deal_link);
        setMaxFontScale();
        C11850a c11850a = (C11850a) new C0782c0(new InterfaceC0788f0() { // from class: com.huawei.android.hicloud.ui.uiextend.backup.SpaceRemindCardView.1
            @Override // androidx.lifecycle.InterfaceC0788f0
            public C0786e0 getViewModelStore() {
                return new C0786e0();
            }
        }).m4929a(C11850a.class);
        this.spaceRemindViewModel = c11850a;
        InterfaceC0796l interfaceC0796l = (InterfaceC0796l) context;
        c11850a.m70951k().m4890h(interfaceC0796l, new InterfaceC0802r() { // from class: com.huawei.android.hicloud.ui.uiextend.backup.a
            @Override // androidx.lifecycle.InterfaceC0802r
            /* renamed from: a */
            public final void mo4709a(Object obj) {
                this.f19184a.lambda$init$0((String) obj);
            }
        });
        this.spaceRemindViewModel.m70947g().m4890h(interfaceC0796l, new InterfaceC0802r() { // from class: com.huawei.android.hicloud.ui.uiextend.backup.b
            @Override // androidx.lifecycle.InterfaceC0802r
            /* renamed from: a */
            public final void mo4709a(Object obj) {
                this.f19185a.lambda$init$1((String) obj);
            }
        });
        this.spaceRemindViewModel.m70950j().m4890h(interfaceC0796l, new InterfaceC0802r() { // from class: com.huawei.android.hicloud.ui.uiextend.backup.c
            @Override // androidx.lifecycle.InterfaceC0802r
            /* renamed from: a */
            public final void mo4709a(Object obj) {
                this.f19186a.lambda$init$2((String) obj);
            }
        });
        this.spaceRemindViewModel.m70946f().m4890h(interfaceC0796l, new InterfaceC0802r() { // from class: com.huawei.android.hicloud.ui.uiextend.backup.d
            @Override // androidx.lifecycle.InterfaceC0802r
            /* renamed from: a */
            public final void mo4709a(Object obj) {
                this.f19187a.lambda$init$3((Integer) obj);
            }
        });
        this.spaceRemindViewModel.m70949i().m4890h(interfaceC0796l, new InterfaceC0802r() { // from class: com.huawei.android.hicloud.ui.uiextend.backup.e
            @Override // androidx.lifecycle.InterfaceC0802r
            /* renamed from: a */
            public final void mo4709a(Object obj) {
                this.f19188a.lambda$init$4((Integer) obj);
            }
        });
        this.spaceRemindViewModel.m70948h().m4890h(interfaceC0796l, new InterfaceC0802r() { // from class: com.huawei.android.hicloud.ui.uiextend.backup.f
            @Override // androidx.lifecycle.InterfaceC0802r
            /* renamed from: a */
            public final void mo4709a(Object obj) {
                this.f19189a.lambda$init$5((String) obj);
            }
        });
        this.spaceRemindViewModel.m70952l().m4890h(interfaceC0796l, new InterfaceC0802r() { // from class: com.huawei.android.hicloud.ui.uiextend.backup.g
            @Override // androidx.lifecycle.InterfaceC0802r
            /* renamed from: a */
            public final void mo4709a(Object obj) {
                this.f19190a.lambda$init$6((String) obj);
            }
        });
        this.spaceRemindButton.setOnClickListener(this);
        this.spaceRemindViewModel.m70953m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$0(String str) {
        this.spaceRemindTitle.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$1(String str) {
        this.spaceRemindDescription.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$2(String str) {
        this.spaceRemindButton.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$3(Integer num) {
        C11839m.m70688i(TAG, "spaceRemindCardLayout visible:" + num);
        this.visible = num.intValue();
        this.spaceRemindCardLayout.setVisibility(num.intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$4(Integer num) {
        this.spaceRemindIcon.setImageResource(num.intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$5(String str) {
        this.jumpUrl = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$6(String str) {
        this.userSpaceState = str;
    }

    private void reportCardClick() {
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put("userSpaceState", this.userSpaceState);
        C13227f.m79492i1().m79567R("space_remind_card_click", linkedHashMapM79497A);
        UBAAnalyze.m29947H("PVC", "space_remind_card_click", linkedHashMapM79497A);
    }

    private void setMaxFontScale() {
        C11842p.m70721D1(this.spaceRemindTitle, 2.0f);
        C11842p.m70721D1(this.spaceRemindDescription, 2.0f);
        C11842p.m70721D1(this.spaceRemindButton, 2.0f);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!C0209d.m1226Y0() && view.getId() == R$id.space_deal_link) {
            if (TextUtils.isEmpty(this.jumpUrl)) {
                C11839m.m70687e(TAG, "jumpUrl is empty.");
                return;
            }
            Intent commonGotoIntent = GeneralRedirectUtil.getCommonGotoIntent(NotifyConstants.TYPE_DEEPLINK, this.jumpUrl, false);
            if (commonGotoIntent == null) {
                C11839m.m70687e(TAG, "jumpIntent is null");
                return;
            }
            commonGotoIntent.putExtra("isFromBackupMainActivityCard", true);
            if (this.mContext instanceof Activity) {
                try {
                    reportCardClick();
                    ((Activity) this.mContext).startActivity(commonGotoIntent);
                } catch (Exception e10) {
                    C11839m.m70687e(TAG, "startActivity error:" + e10.getMessage());
                }
            }
        }
    }

    public void refreshCardView(String str) {
        C11839m.m70688i(TAG, "refreshCardView start:" + str);
        C11850a c11850a = this.spaceRemindViewModel;
        if (c11850a == null) {
            C11839m.m70688i(TAG, "spaceViewModel is null");
            return;
        }
        c11850a.m70953m();
        C11839m.m70688i(TAG, "refreshCardView end:" + str);
    }
}
