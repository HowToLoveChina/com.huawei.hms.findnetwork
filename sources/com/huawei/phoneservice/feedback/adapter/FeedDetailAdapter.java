package com.huawei.phoneservice.feedback.adapter;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.huawei.phoneservice.faq.base.util.FaqCommonUtils;
import com.huawei.phoneservice.faq.base.util.FaqTimeStringUtil;
import com.huawei.phoneservice.faq.base.util.ModuleConfigUtils;
import com.huawei.phoneservice.faq.base.util.NoDoubleClickUtil;
import com.huawei.phoneservice.feedback.R$drawable;
import com.huawei.phoneservice.feedback.R$layout;
import com.huawei.phoneservice.feedback.R$string;
import com.huawei.phoneservice.feedback.entity.C8472c;
import com.huawei.phoneservice.feedback.photolibrary.internal.utils.C8509a;
import com.huawei.phoneservice.feedback.widget.AbstractC8598a;
import com.huawei.phoneservice.feedback.widget.ViewOnClickListenerC8600c;
import com.huawei.phoneservice.feedbackcommon.entity.FeedBackResponse;
import com.huawei.phoneservice.feedbackcommon.entity.FeedMedia;
import com.huawei.phoneservice.feedbackcommon.entity.MediaEntity;
import com.huawei.phoneservice.feedbackcommon.p176db.FeedbackMediaData;
import com.huawei.phoneservice.feedbackcommon.photolibrary.MimeType;
import com.huawei.phoneservice.feedbackcommon.photolibrary.internal.entity.MediaItem;
import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public class FeedDetailAdapter extends AbstractC8598a<FeedBackResponse.ProblemEnity> {

    /* renamed from: e */
    public Context f39467e;

    /* renamed from: f */
    public InterfaceC8458f f39468f;

    /* renamed from: g */
    public boolean f39469g;

    public static class UriDeserializer implements JsonDeserializer<Uri> {
        @Override // com.google.gson.JsonDeserializer
        /* renamed from: a */
        public Uri deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            return Uri.parse(jsonElement.getAsString());
        }
    }

    /* renamed from: com.huawei.phoneservice.feedback.adapter.FeedDetailAdapter$a */
    public class ViewOnClickListenerC8453a implements View.OnClickListener {

        /* renamed from: a */
        public final /* synthetic */ C8465d f39470a;

        /* renamed from: b */
        public final /* synthetic */ FeedBackResponse.ProblemEnity f39471b;

        /* renamed from: c */
        public final /* synthetic */ int f39472c;

        public ViewOnClickListenerC8453a(C8465d c8465d, FeedBackResponse.ProblemEnity problemEnity, int i10) {
            this.f39470a = c8465d;
            this.f39471b = problemEnity;
            this.f39472c = i10;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (NoDoubleClickUtil.isDoubleClick(view) || FeedDetailAdapter.this.f39468f == null) {
                return;
            }
            C8472c c8472c = new C8472c();
            FeedDetailAdapter.this.m52593X(c8472c, this.f39470a, this.f39471b, this.f39472c, "1");
            FeedDetailAdapter.this.f39468f.mo52604y(c8472c);
        }
    }

    /* renamed from: com.huawei.phoneservice.feedback.adapter.FeedDetailAdapter$b */
    public class ViewOnClickListenerC8454b implements View.OnClickListener {

        /* renamed from: a */
        public final /* synthetic */ C8465d f39474a;

        /* renamed from: b */
        public final /* synthetic */ FeedBackResponse.ProblemEnity f39475b;

        /* renamed from: c */
        public final /* synthetic */ int f39476c;

        public ViewOnClickListenerC8454b(C8465d c8465d, FeedBackResponse.ProblemEnity problemEnity, int i10) {
            this.f39474a = c8465d;
            this.f39475b = problemEnity;
            this.f39476c = i10;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (NoDoubleClickUtil.isDoubleClick(view) || FeedDetailAdapter.this.f39468f == null) {
                return;
            }
            C8472c c8472c = new C8472c();
            FeedDetailAdapter.this.m52593X(c8472c, this.f39474a, this.f39475b, this.f39476c, "0");
            FeedDetailAdapter.this.f39468f.mo52603q(c8472c);
        }
    }

    /* renamed from: com.huawei.phoneservice.feedback.adapter.FeedDetailAdapter$c */
    public class C8455c implements AbstractC8598a.a {

        /* renamed from: a */
        public final /* synthetic */ List f39478a;

        public C8455c(List list) {
            this.f39478a = list;
        }

        @Override // com.huawei.phoneservice.feedback.widget.AbstractC8598a.a
        /* renamed from: a */
        public void mo52600a(int i10, ImageView imageView, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, ImageView imageView2, String str, String str2, long j10, boolean z10) throws NumberFormatException {
            if (FeedDetailAdapter.this.f39468f != null) {
                if (z10) {
                    FeedDetailAdapter.this.f39468f.mo52602p(str, str2, imageView, relativeLayout, relativeLayout2, imageView2, j10);
                    return;
                }
                List<MediaItem> listM52595Z = FeedDetailAdapter.this.m52595Z(this.f39478a);
                int iM52588P = FeedDetailAdapter.this.m52588P(listM52595Z, str2);
                if (iM52588P != -1) {
                    FeedDetailAdapter.this.f39468f.mo52601a(listM52595Z, iM52588P);
                }
            }
        }
    }

    /* renamed from: com.huawei.phoneservice.feedback.adapter.FeedDetailAdapter$d */
    public class C8456d implements AbstractC8598a.a {

        /* renamed from: a */
        public final /* synthetic */ List f39480a;

        public C8456d(List list) {
            this.f39480a = list;
        }

        @Override // com.huawei.phoneservice.feedback.widget.AbstractC8598a.a
        /* renamed from: a */
        public void mo52600a(int i10, ImageView imageView, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, ImageView imageView2, String str, String str2, long j10, boolean z10) throws NumberFormatException {
            if (FeedDetailAdapter.this.f39468f != null) {
                if (z10) {
                    FeedDetailAdapter.this.f39468f.mo52602p(str, str2, imageView, relativeLayout, relativeLayout2, imageView2, j10);
                    return;
                }
                List<MediaItem> listM52595Z = FeedDetailAdapter.this.m52595Z(this.f39480a);
                int iM52588P = FeedDetailAdapter.this.m52588P(listM52595Z, str2);
                if (iM52588P != -1) {
                    FeedDetailAdapter.this.f39468f.mo52601a(listM52595Z, iM52588P);
                }
            }
        }
    }

    /* renamed from: com.huawei.phoneservice.feedback.adapter.FeedDetailAdapter$e */
    public static class ViewTreeObserverOnPreDrawListenerC8457e implements ViewTreeObserver.OnPreDrawListener {

        /* renamed from: a */
        public final C8465d f39482a;

        public ViewTreeObserverOnPreDrawListenerC8457e(C8465d c8465d) {
            this.f39482a = c8465d;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            this.f39482a.f39512x.getViewTreeObserver().removeOnPreDrawListener(this);
            int lineCount = this.f39482a.f39512x.getLineCount();
            LinearLayout linearLayout = this.f39482a.f39509G;
            if (lineCount >= 3) {
                linearLayout.setOrientation(1);
            } else {
                linearLayout.setOrientation(0);
            }
            return false;
        }
    }

    /* renamed from: com.huawei.phoneservice.feedback.adapter.FeedDetailAdapter$f */
    public interface InterfaceC8458f {
        /* renamed from: a */
        void mo52601a(List<MediaItem> list, int i10);

        /* renamed from: p */
        void mo52602p(String str, String str2, ImageView imageView, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, ImageView imageView2, long j10);

        /* renamed from: q */
        void mo52603q(C8472c c8472c);

        /* renamed from: y */
        void mo52604y(C8472c c8472c);
    }

    public FeedDetailAdapter(Context context, boolean z10) {
        this.f39467e = context;
        this.f39469g = z10;
    }

    /* renamed from: P */
    public final int m52588P(List<MediaItem> list, String str) {
        if (list == null) {
            return -1;
        }
        for (int i10 = 0; i10 < list.size(); i10++) {
            if (str.equals(list.get(i10).getAttachId())) {
                return i10;
            }
        }
        return -1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: R */
    public ViewOnClickListenerC8600c mo724u(ViewGroup viewGroup, int i10) {
        return new C8465d(LayoutInflater.from(this.f39467e).inflate(R$layout.feedback_sdk_item_imgfrom_questionlist, viewGroup, false));
    }

    /* renamed from: T */
    public void m52590T(InterfaceC8458f interfaceC8458f) {
        this.f39468f = interfaceC8458f;
    }

    /* renamed from: V */
    public final void m52591V(C8465d c8465d, FeedBackResponse.ProblemEnity problemEnity) {
        if (problemEnity.getPicURL() == null) {
            c8465d.f39504B.setVisibility(8);
            return;
        }
        c8465d.f39504B.setVisibility(0);
        ArrayList arrayList = new ArrayList();
        arrayList.add(problemEnity.getPicURL());
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(problemEnity.getPicURL());
        c8465d.f39504B.setLayoutManager(new LinearLayoutManager(this.f39467e));
        C8464c c8464c = new C8464c(this.f39467e, new C8455c(arrayList2));
        c8465d.f39504B.setAdapter(c8464c);
        c8464c.m53163K(arrayList);
    }

    /* renamed from: W */
    public final void m52592W(C8465d c8465d, FeedBackResponse.ProblemEnity problemEnity, int i10) throws Throwable {
        TextView textView;
        String strReplace;
        if (i10 != 0 || this.f39467e == null) {
            c8465d.f39513y.setText(problemEnity.getProblemDesc());
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(this.f39467e.getResources().getString(R$string.feedback_sdk_desc, problemEnity.getProblemDesc()));
            stringBuffer.append("\n");
            stringBuffer.append(this.f39467e.getResources().getString(R$string.feedback_sdk_desc_numb));
            stringBuffer.append("\n");
            stringBuffer.append(problemEnity.getProblemId());
            c8465d.f39513y.setText(stringBuffer);
        }
        if (C8509a.m52862c(problemEnity.getCreateTime(), this.f39467e)) {
            textView = c8465d.f39510v;
            strReplace = C8509a.m52861a(problemEnity.getCreateTime(), "HH:mm", this.f39467e);
        } else {
            String strM52861a = C8509a.m52861a(problemEnity.getCreateTime(), "yyyy-MM-dd HH:mm", this.f39467e);
            textView = c8465d.f39510v;
            strReplace = FaqTimeStringUtil.formatDateString(strM52861a, this.f39467e).replace("-", "/");
        }
        textView.setText(strReplace);
    }

    /* renamed from: X */
    public final void m52593X(C8472c c8472c, C8465d c8465d, FeedBackResponse.ProblemEnity problemEnity, int i10, String str) {
        c8472c.m52642j(c8465d.f39505C);
        c8472c.m52638e(c8465d.f39506D);
        c8472c.m52639f(c8465d.f39514z);
        c8472c.m52637d(c8465d.f39507E);
        c8472c.m52640g(problemEnity.getProblemId());
        c8472c.m52636c(i10);
        c8472c.m52643k(str);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: Y */
    public void mo723s(ViewOnClickListenerC8600c viewOnClickListenerC8600c, int i10) throws Throwable {
        m52597b0((C8465d) viewOnClickListenerC8600c, m53157E(i10), i10);
    }

    /* renamed from: Z */
    public final List<MediaItem> m52595Z(List<FeedMedia> list) throws NumberFormatException {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < list.size(); i10++) {
            FeedMedia feedMedia = list.get(i10);
            MediaEntity mediaEntityByAttach = FeedbackMediaData.getInstance(this.f39467e).getMediaEntityByAttach(feedMedia.getAttachId());
            if (mediaEntityByAttach != null) {
                String str = new File(mediaEntityByAttach.path).exists() ? mediaEntityByAttach.path : new File(mediaEntityByAttach.cache).exists() ? mediaEntityByAttach.cache : null;
                if (!TextUtils.isEmpty(str)) {
                    String suffixFromUrl = MimeType.getSuffixFromUrl(mediaEntityByAttach.url);
                    long j10 = Long.parseLong(feedMedia.getSize());
                    Long l10 = mediaEntityByAttach.duration;
                    arrayList.add(new MediaItem(suffixFromUrl, str, j10, l10 == null ? 0L : l10.longValue(), feedMedia.getAttachId(), mediaEntityByAttach.strUri));
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a0 */
    public final void m52596a0(C8465d c8465d, FeedBackResponse.ProblemEnity problemEnity) {
        if (FaqCommonUtils.isEmpty(problemEnity.getMediaItemList())) {
            c8465d.f39503A.setVisibility(8);
            return;
        }
        c8465d.f39503A.setVisibility(0);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.f39467e);
        C8463b c8463b = new C8463b(this.f39467e, new C8456d(new ArrayList(problemEnity.getMediaItemList())));
        c8465d.f39503A.setLayoutManager(linearLayoutManager);
        c8465d.f39503A.setAdapter(c8463b);
        c8463b.m53163K(problemEnity.getMediaItemList());
    }

    /* renamed from: b0 */
    public final void m52597b0(C8465d c8465d, FeedBackResponse.ProblemEnity problemEnity, int i10) throws Throwable {
        m52592W(c8465d, problemEnity, i10);
        m52596a0(c8465d, problemEnity);
        m52591V(c8465d, problemEnity);
        if (TextUtils.isEmpty(problemEnity.getAnswer())) {
            c8465d.f39511w.setVisibility(8);
            c8465d.f39507E.setVisibility(8);
            c8465d.f39508F.setVisibility(8);
        } else {
            if (C8509a.m52862c(problemEnity.getAnswerTime(), this.f39467e)) {
                c8465d.f39511w.setText(C8509a.m52861a(problemEnity.getAnswerTime(), "HH:mm", this.f39467e));
            } else {
                c8465d.f39511w.setText(FaqTimeStringUtil.formatDateString(C8509a.m52861a(problemEnity.getAnswerTime(), "yyyy-MM-dd HH:mm", this.f39467e), this.f39467e).replace("-", "/"));
            }
            c8465d.f39512x.setText(problemEnity.getAnswer());
        }
        m52598c0(c8465d, problemEnity, i10);
        if (TextUtils.isEmpty(problemEnity.getAnswer()) || TextUtils.isEmpty(problemEnity.getScore()) || !ModuleConfigUtils.feedbackAssessmentEnabled(this.f39469g)) {
            return;
        }
        c8465d.f39507E.setVisibility(0);
        if ("1".equals(problemEnity.getScore())) {
            c8465d.f39505C.setImageResource(R$drawable.feedback_sdk_ic_comment_useful_gray);
            c8465d.f39505C.setVisibility(0);
            c8465d.f39505C.setEnabled(false);
            c8465d.f39506D.setVisibility(8);
            c8465d.f39514z.setText(this.f39467e.getResources().getString(R$string.feedback_sdk_question_details_evalua_yes));
        }
        if ("0".equals(problemEnity.getScore())) {
            c8465d.f39506D.setImageResource(R$drawable.feedback_sdk_ic_comment_useless_gray);
            c8465d.f39506D.setVisibility(0);
            c8465d.f39506D.setEnabled(false);
            c8465d.f39505C.setVisibility(8);
            c8465d.f39514z.setText(this.f39467e.getResources().getString(R$string.feedback_sdk_question_details_evalua_no));
        }
    }

    /* renamed from: c0 */
    public final void m52598c0(C8465d c8465d, FeedBackResponse.ProblemEnity problemEnity, int i10) {
        if (TextUtils.isEmpty(problemEnity.getAnswer()) || !TextUtils.isEmpty(problemEnity.getScore()) || !ModuleConfigUtils.feedbackAssessmentEnabled(this.f39469g)) {
            c8465d.f39505C.setVisibility(4);
            return;
        }
        c8465d.f39512x.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserverOnPreDrawListenerC8457e(c8465d));
        c8465d.f39505C.setImageResource(R$drawable.feedback_sdk_ic_comment_useful);
        c8465d.f39506D.setImageResource(R$drawable.feedback_sdk_ic_comment_useless);
        c8465d.f39506D.setVisibility(0);
        c8465d.f39505C.setVisibility(0);
        c8465d.f39505C.setOnClickListener(new ViewOnClickListenerC8453a(c8465d, problemEnity, i10));
        c8465d.f39506D.setOnClickListener(new ViewOnClickListenerC8454b(c8465d, problemEnity, i10));
    }
}
