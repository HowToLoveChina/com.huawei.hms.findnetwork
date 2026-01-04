package com.huawei.phoneservice.feedback.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.huawei.phoneservice.feedback.R$id;
import com.huawei.phoneservice.feedback.R$layout;
import com.huawei.phoneservice.feedback.widget.AbstractC8598a;
import com.huawei.phoneservice.feedback.widget.ViewOnClickListenerC8600c;
import com.huawei.phoneservice.feedbackcommon.entity.FeedMedia;
import com.huawei.phoneservice.feedbackcommon.entity.MediaEntity;
import com.huawei.phoneservice.feedbackcommon.p176db.FeedbackMediaData;
import com.huawei.phoneservice.feedbackcommon.photolibrary.MimeType;

/* renamed from: com.huawei.phoneservice.feedback.adapter.c */
/* loaded from: classes5.dex */
public class C8464c extends AbstractC8598a<FeedMedia> {

    /* renamed from: e */
    public Context f39501e;

    /* renamed from: f */
    public AbstractC8598a.a f39502f;

    public C8464c(Context context, AbstractC8598a.a aVar) {
        this.f39501e = context;
        this.f39502f = aVar;
    }

    /* renamed from: Q */
    private void m52619Q(ViewOnClickListenerC8600c viewOnClickListenerC8600c, int i10, int i11, FeedMedia feedMedia, MediaEntity mediaEntity) {
        if (i11 == 0) {
            ImageView imageView = (ImageView) viewOnClickListenerC8600c.m53167P(R$id.replay_video_frame);
            RelativeLayout relativeLayout = (RelativeLayout) viewOnClickListenerC8600c.m53167P(R$id.rl_replay_video_frame);
            m53165M(this.f39501e, imageView, (ImageView) viewOnClickListenerC8600c.m53167P(R$id.replay_video_failed), relativeLayout, (RelativeLayout) viewOnClickListenerC8600c.m53167P(R$id.replay_video_progress), feedMedia, mediaEntity, i10, this.f39502f);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: O, reason: merged with bridge method [inline-methods] */
    public ViewOnClickListenerC8600c mo724u(ViewGroup viewGroup, int i10) {
        return i10 == 0 ? new C8468g(LayoutInflater.from(this.f39501e).inflate(R$layout.feedback_sdk_video_item_replay, viewGroup, false)) : new ViewOnClickListenerC8600c(LayoutInflater.from(this.f39501e).inflate(R$layout.feedback_sdk_item_replay, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: P, reason: merged with bridge method [inline-methods] */
    public void mo723s(ViewOnClickListenerC8600c viewOnClickListenerC8600c, int i10) {
        int iMo749g = mo749g(i10);
        FeedMedia feedMediaM53157E = m53157E(i10);
        MediaEntity mediaEntityByAttach = FeedbackMediaData.getInstance(this.f39501e).getMediaEntityByAttach(feedMediaM53157E.getAttachId());
        if (1 == iMo749g) {
            ImageView imageView = (ImageView) viewOnClickListenerC8600c.m53167P(R$id.replay_img_success);
            RelativeLayout relativeLayout = (RelativeLayout) viewOnClickListenerC8600c.m53167P(R$id.rl_replay_img_failed);
            m53159G(this.f39501e, imageView, (ImageView) viewOnClickListenerC8600c.m53167P(R$id.replay_img_failed), relativeLayout, (RelativeLayout) viewOnClickListenerC8600c.m53167P(R$id.replay_img_progress), feedMediaM53157E, mediaEntityByAttach, i10, this.f39502f);
        }
        m52619Q(viewOnClickListenerC8600c, i10, iMo749g, feedMediaM53157E, mediaEntityByAttach);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: g */
    public int mo749g(int i10) {
        return MimeType.isImageFromUrl(m53157E(i10).getDownloadURL()) ? 1 : 0;
    }
}
