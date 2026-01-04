package com.huawei.phoneservice.feedback.widget;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bumptech.glide.ComponentCallbacks2C1546b;
import com.huawei.phoneservice.faq.base.util.FaqStringUtil;
import com.huawei.phoneservice.faq.base.util.NoDoubleClickUtil;
import com.huawei.phoneservice.feedbackcommon.entity.FeedMedia;
import com.huawei.phoneservice.feedbackcommon.entity.MediaEntity;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.huawei.phoneservice.feedback.widget.a */
/* loaded from: classes5.dex */
public abstract class AbstractC8598a<T> extends AbstractC8599b {

    /* renamed from: d */
    public List<T> f40015d = new ArrayList();

    /* renamed from: com.huawei.phoneservice.feedback.widget.a$a */
    public interface a {
        /* renamed from: a */
        void mo52600a(int i10, ImageView imageView, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, ImageView imageView2, String str, String str2, long j10, boolean z10);
    }

    /* renamed from: com.huawei.phoneservice.feedback.widget.a$b */
    public static class b implements View.OnClickListener {

        /* renamed from: a */
        public a f40016a;

        /* renamed from: b */
        public FeedMedia f40017b;

        /* renamed from: c */
        public ImageView f40018c;

        /* renamed from: d */
        public ImageView f40019d;

        /* renamed from: e */
        public RelativeLayout f40020e;

        /* renamed from: f */
        public RelativeLayout f40021f;

        /* renamed from: g */
        public int f40022g;

        /* renamed from: h */
        public boolean f40023h;

        /* renamed from: i */
        public boolean f40024i;

        public b(ImageView imageView, ImageView imageView2, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, FeedMedia feedMedia, int i10, boolean z10, boolean z11, a aVar) {
            this.f40018c = imageView;
            this.f40019d = imageView2;
            this.f40020e = relativeLayout;
            this.f40021f = relativeLayout2;
            this.f40017b = feedMedia;
            this.f40023h = z10;
            this.f40022g = i10;
            this.f40024i = z11;
            this.f40016a = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ImageView imageView;
            if (NoDoubleClickUtil.isDoubleClick(view) || this.f40016a == null) {
                return;
            }
            if (this.f40023h && (imageView = this.f40019d) != null) {
                imageView.setVisibility(8);
            }
            FeedMedia feedMedia = this.f40017b;
            if (feedMedia == null) {
                return;
            }
            this.f40016a.mo52600a(this.f40022g, this.f40018c, this.f40020e, this.f40021f, this.f40019d, feedMedia.getDownloadURL(), this.f40017b.getAttachId(), Long.parseLong(this.f40017b.getSize()), this.f40024i);
        }
    }

    /* renamed from: D */
    public final File m53156D(String str) {
        return new File(str);
    }

    /* renamed from: E */
    public T m53157E(int i10) {
        return this.f40015d.get(i10);
    }

    /* renamed from: F */
    public final void m53158F(Context context, Uri uri, ImageView imageView) {
        if (context == null || uri == null || imageView == null) {
            return;
        }
        ComponentCallbacks2C1546b.m8904t(context).m8983q(uri).m8965n(imageView);
        imageView.setVisibility(0);
    }

    /* renamed from: G */
    public void m53159G(Context context, ImageView imageView, ImageView imageView2, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, FeedMedia feedMedia, MediaEntity mediaEntity, int i10, a aVar) {
        if (mediaEntity != null) {
            m53166N(context, mediaEntity, imageView, imageView2, relativeLayout);
        } else {
            imageView2.setVisibility(0);
            relativeLayout.setVisibility(0);
        }
        b bVar = new b(imageView, imageView2, relativeLayout, relativeLayout2, feedMedia, i10, true, true, aVar);
        imageView2.setOnClickListener(bVar);
        relativeLayout.setOnClickListener(bVar);
        imageView.setOnClickListener(new b(imageView, imageView2, relativeLayout, relativeLayout2, feedMedia, i10, false, false, aVar));
    }

    /* renamed from: H */
    public final void m53160H(Context context, MediaEntity mediaEntity, ImageView imageView, ImageView imageView2, RelativeLayout relativeLayout) {
        String str;
        File fileM53156D = m53156D(mediaEntity.path);
        if (!FaqStringUtil.isEmpty(mediaEntity.path) && fileM53156D.exists()) {
            if (fileM53156D.canRead()) {
                str = mediaEntity.path;
                m53161I(context, m53156D(str), imageView);
            } else {
                if (FaqStringUtil.isEmpty(mediaEntity.strUri)) {
                    return;
                }
                m53164L(context, Uri.parse(mediaEntity.strUri), imageView);
            }
        }
        File fileM53156D2 = m53156D(mediaEntity.cache);
        if (FaqStringUtil.isEmpty(mediaEntity.cache) || !fileM53156D2.exists()) {
            relativeLayout.setVisibility(0);
            imageView2.setVisibility(0);
        } else if (fileM53156D2.canRead()) {
            str = mediaEntity.cache;
            m53161I(context, m53156D(str), imageView);
        } else {
            if (FaqStringUtil.isEmpty(mediaEntity.strUri)) {
                return;
            }
            m53164L(context, Uri.parse(mediaEntity.strUri), imageView);
        }
    }

    /* renamed from: I */
    public final void m53161I(Context context, File file, ImageView imageView) {
        if (context == null || file == null || imageView == null) {
            return;
        }
        ComponentCallbacks2C1546b.m8904t(context).m8984r(file).m8965n(imageView);
        imageView.setVisibility(0);
    }

    /* renamed from: J */
    public final void m53162J(Context context, String str, ImageView imageView) {
        if (context == null || str == null || imageView == null) {
            return;
        }
        ComponentCallbacks2C1546b.m8904t(context).m8984r(new File(str)).m8965n(imageView);
        imageView.setVisibility(0);
    }

    /* renamed from: K */
    public void m53163K(List<T> list) {
        this.f40015d.clear();
        this.f40015d.addAll(list);
        m5213j();
    }

    /* renamed from: L */
    public final void m53164L(Context context, Uri uri, ImageView imageView) {
        if (context == null || uri == null || imageView == null) {
            return;
        }
        ComponentCallbacks2C1546b.m8904t(context).m8983q(uri).m8965n(imageView);
        imageView.setVisibility(0);
    }

    /* renamed from: M */
    public void m53165M(Context context, ImageView imageView, ImageView imageView2, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, FeedMedia feedMedia, MediaEntity mediaEntity, int i10, a aVar) {
        if (mediaEntity != null) {
            m53160H(context, mediaEntity, imageView, imageView2, relativeLayout);
        } else {
            imageView2.setVisibility(0);
            relativeLayout.setVisibility(0);
        }
        b bVar = new b(imageView, imageView2, relativeLayout, relativeLayout2, feedMedia, i10, true, true, aVar);
        imageView2.setOnClickListener(bVar);
        relativeLayout.setOnClickListener(bVar);
        imageView.setOnClickListener(new b(imageView, imageView2, relativeLayout, relativeLayout2, feedMedia, i10, false, false, aVar));
    }

    /* renamed from: N */
    public final void m53166N(Context context, MediaEntity mediaEntity, ImageView imageView, ImageView imageView2, RelativeLayout relativeLayout) {
        String str;
        File fileM53156D = m53156D(mediaEntity.path);
        if (!FaqStringUtil.isEmpty(mediaEntity.path) && fileM53156D.exists()) {
            if (fileM53156D.canRead()) {
                str = mediaEntity.path;
                m53162J(context, str, imageView);
            } else {
                if (FaqStringUtil.isEmpty(mediaEntity.strUri)) {
                    return;
                }
                m53158F(context, Uri.parse(mediaEntity.strUri), imageView);
            }
        }
        File fileM53156D2 = m53156D(mediaEntity.cache);
        if (FaqStringUtil.isEmpty(mediaEntity.cache) || !fileM53156D2.exists()) {
            relativeLayout.setVisibility(0);
            imageView2.setVisibility(0);
        } else if (fileM53156D2.canRead()) {
            str = mediaEntity.cache;
            m53162J(context, str, imageView);
        } else {
            if (FaqStringUtil.isEmpty(mediaEntity.strUri)) {
                return;
            }
            m53158F(context, Uri.parse(mediaEntity.strUri), imageView);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: e */
    public int mo721e() {
        return this.f40015d.size();
    }
}
