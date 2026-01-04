package com.huawei.phoneservice.feedback.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.huawei.phoneservice.feedback.R$id;
import com.huawei.phoneservice.feedback.mvp.base.FeedbackCITListView;
import com.huawei.phoneservice.feedback.widget.ViewOnClickListenerC8600c;

/* renamed from: com.huawei.phoneservice.feedback.adapter.d */
/* loaded from: classes5.dex */
public class C8465d extends ViewOnClickListenerC8600c {

    /* renamed from: A */
    public FeedbackCITListView f39503A;

    /* renamed from: B */
    public FeedbackCITListView f39504B;

    /* renamed from: C */
    public ImageView f39505C;

    /* renamed from: D */
    public ImageView f39506D;

    /* renamed from: E */
    public View f39507E;

    /* renamed from: F */
    public View f39508F;

    /* renamed from: G */
    public LinearLayout f39509G;

    /* renamed from: v */
    public TextView f39510v;

    /* renamed from: w */
    public TextView f39511w;

    /* renamed from: x */
    public TextView f39512x;

    /* renamed from: y */
    public TextView f39513y;

    /* renamed from: z */
    public TextView f39514z;

    public C8465d(View view) {
        super(view);
        m52622Q();
    }

    /* renamed from: Q */
    public final void m52622Q() {
        this.f39512x = (TextView) this.f4327a.findViewById(R$id.tv_evaluad_content);
        this.f39510v = (TextView) this.f4327a.findViewById(R$id.imgfrom_chat_time);
        this.f39511w = (TextView) this.f4327a.findViewById(R$id.from_chat_time);
        this.f39513y = (TextView) this.f4327a.findViewById(R$id.mycontent);
        this.f39503A = (FeedbackCITListView) this.f4327a.findViewById(R$id.question_img_list);
        this.f39504B = (FeedbackCITListView) this.f4327a.findViewById(R$id.replay_img_lsit);
        this.f39505C = (ImageView) this.f4327a.findViewById(R$id.img_resolved);
        this.f39506D = (ImageView) this.f4327a.findViewById(R$id.img_no_resolved);
        this.f39507E = this.f4327a.findViewById(R$id.feedback_layout_evaluat);
        this.f39508F = this.f4327a.findViewById(R$id.feedback_sdk_item_msgfrom);
        this.f39514z = (TextView) this.f4327a.findViewById(R$id.from_content);
        this.f39509G = (LinearLayout) this.f4327a.findViewById(R$id.ll_evaluat);
    }
}
