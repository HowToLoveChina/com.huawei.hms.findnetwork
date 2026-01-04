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

/* renamed from: com.huawei.phoneservice.feedback.adapter.b */
/* loaded from: classes5.dex */
public class C8463b extends AbstractC8598a<FeedMedia> {

    /* renamed from: e */
    public Context f39499e;

    /* renamed from: f */
    public AbstractC8598a.a f39500f;

    public C8463b(Context context, AbstractC8598a.a aVar) {
        this.f39499e = context;
        this.f39500f = aVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: O, reason: merged with bridge method [inline-methods] */
    public ViewOnClickListenerC8600c mo724u(ViewGroup viewGroup, int i10) {
        return i10 == 0 ? new C8468g(LayoutInflater.from(this.f39499e).inflate(R$layout.feedback_sdk_item_videofrom, viewGroup, false)) : new ViewOnClickListenerC8600c(LayoutInflater.from(this.f39499e).inflate(R$layout.feedback_sdk_item_imagefrom, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: P, reason: merged with bridge method [inline-methods] */
    public void mo723s(ViewOnClickListenerC8600c viewOnClickListenerC8600c, int i10) {
        int iMo749g = mo749g(i10);
        FeedMedia feedMediaM53157E = m53157E(i10);
        MediaEntity mediaEntityByAttach = FeedbackMediaData.getInstance(this.f39499e).getMediaEntityByAttach(feedMediaM53157E.getAttachId());
        if (1 == iMo749g) {
            ImageView imageView = (ImageView) viewOnClickListenerC8600c.m53167P(R$id.img_success);
            RelativeLayout relativeLayout = (RelativeLayout) viewOnClickListenerC8600c.m53167P(R$id.rl_img_failed);
            m53159G(this.f39499e, imageView, (ImageView) viewOnClickListenerC8600c.m53167P(R$id.img_img_failed), relativeLayout, (RelativeLayout) viewOnClickListenerC8600c.m53167P(R$id.rl_img_progress), feedMediaM53157E, mediaEntityByAttach, i10, this.f39500f);
        }
        m52618Q(viewOnClickListenerC8600c, i10, iMo749g, feedMediaM53157E, mediaEntityByAttach);
    }

    /* renamed from: Q */
    public final void m52618Q(ViewOnClickListenerC8600c viewOnClickListenerC8600c, int i10, int i11, FeedMedia feedMedia, MediaEntity mediaEntity) {
        if (i11 == 0) {
            ImageView imageView = (ImageView) viewOnClickListenerC8600c.m53167P(R$id.video_frame);
            RelativeLayout relativeLayout = (RelativeLayout) viewOnClickListenerC8600c.m53167P(R$id.rl_video_frame);
            m53165M(this.f39499e, imageView, (ImageView) viewOnClickListenerC8600c.m53167P(R$id.img_video_failed), relativeLayout, (RelativeLayout) viewOnClickListenerC8600c.m53167P(R$id.rl_video_progress), feedMedia, mediaEntity, i10, this.f39500f);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: g */
    public int mo749g(int i10) {
        return MimeType.isImageFromUrl(m53157E(i10).getDownloadURL()) ? 1 : 0;
    }
}
