package ae;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.hicloud.p088ui.extend.HiCloudRoundRectImageView;
import com.huawei.android.hicloud.sync.service.aidl.SyncType;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.constants.RecommendCardConstants;
import com.huawei.hicloud.notification.manager.RecommendCardManager;
import com.huawei.hicloud.notification.p106db.bean.NotifyTypeAndUriGoto;
import com.huawei.hicloud.notification.p106db.bean.RecommendCard;
import com.huawei.openalliance.p169ad.constant.MimeType;
import com.huawei.openalliance.p169ad.inter.data.INativeAd;
import com.huawei.openalliance.p169ad.views.PPSNativeView;
import java.util.ArrayList;
import java.util.List;
import p015ak.C0209d;
import p514o9.C11839m;
import p514o9.C11842p;
import p778xk.C13823d;
import sk.C12808e;
import sk.C12809f;

/* renamed from: ae.x1 */
/* loaded from: classes3.dex */
public class C0181x1 extends BaseAdapter {

    /* renamed from: a */
    public Context f708a;

    /* renamed from: b */
    public ArrayList<RecommendCard> f709b;

    /* renamed from: c */
    public View.OnClickListener f710c;

    /* renamed from: ae.x1$b */
    public static class b {

        /* renamed from: a */
        public TextView f711a;

        /* renamed from: b */
        public TextView f712b;

        /* renamed from: c */
        public ImageView f713c;

        /* renamed from: d */
        public TextView f714d;

        /* renamed from: e */
        public TextView f715e;

        /* renamed from: f */
        public RelativeLayout f716f;

        /* renamed from: g */
        public RelativeLayout f717g;

        /* renamed from: h */
        public RelativeLayout f718h;

        /* renamed from: i */
        public RelativeLayout f719i;

        /* renamed from: j */
        public ImageView f720j;

        /* renamed from: k */
        public PPSNativeView f721k;

        /* renamed from: l */
        public ImageView f722l;

        /* renamed from: m */
        public TextView f723m;

        /* renamed from: n */
        public RelativeLayout f724n;

        public b() {
        }
    }

    public C0181x1(Context context, ArrayList<RecommendCard> arrayList) {
        this.f708a = context;
        this.f709b = new ArrayList<>(arrayList);
    }

    /* renamed from: a */
    public final void m1010a(RecommendCard recommendCard, b bVar) {
        if (bVar.f721k != null) {
            bVar.f721k.setVisibility(8);
        }
        bVar.f716f.setVisibility(0);
        m1015f(recommendCard, bVar.f713c, 1);
        if (TextUtils.isEmpty(recommendCard.getRemark())) {
            bVar.f711a.setVisibility(8);
        } else {
            bVar.f711a.setText(recommendCard.getRemark());
            bVar.f711a.setVisibility(0);
        }
        if (TextUtils.isEmpty(recommendCard.getDescription())) {
            bVar.f712b.setVisibility(8);
        } else {
            bVar.f712b.setText(recommendCard.getDescription());
            bVar.f712b.setVisibility(0);
        }
        if (TextUtils.isEmpty(recommendCard.getButton())) {
            bVar.f715e.setVisibility(8);
        } else {
            bVar.f715e.setText(recommendCard.getButton());
            bVar.f715e.setVisibility(0);
        }
        m1011b(recommendCard, bVar);
    }

    /* renamed from: b */
    public final void m1011b(RecommendCard recommendCard, b bVar) {
        int iM1013d = m1013d();
        if (TextUtils.isEmpty(recommendCard.getTitle())) {
            bVar.f714d.setVisibility(8);
            bVar.f718h.setVisibility(8);
            if (iM1013d > 0) {
                float f10 = iM1013d;
                m1017h(bVar.f719i, f10);
                m1017h(bVar.f716f, f10);
            } else {
                m1017h(bVar.f719i, C11842p.m70840n(this.f708a, 114));
                m1017h(bVar.f716f, C11842p.m70840n(this.f708a, 114));
            }
            m1015f(recommendCard, bVar.f720j, 0);
            bVar.f717g.setVisibility(0);
            bVar.f713c.setVisibility(8);
            return;
        }
        C11839m.m70686d("RecommendDetailAdapter", "has title: ");
        bVar.f714d.setText(recommendCard.getTitle());
        bVar.f714d.setVisibility(0);
        bVar.f717g.setVisibility(8);
        bVar.f713c.setVisibility(0);
        bVar.f718h.setVisibility(0);
        if (iM1013d > 0) {
            m1017h(bVar.f719i, iM1013d);
            m1017h(bVar.f716f, iM1013d + C11842p.m70840n(this.f708a, 52));
        } else {
            m1017h(bVar.f719i, C11842p.m70840n(this.f708a, 96));
            m1017h(bVar.f716f, C11842p.m70840n(this.f708a, 148));
        }
    }

    /* renamed from: c */
    public final void m1012c(RecommendCard recommendCard, b bVar) throws Resources.NotFoundException {
        bVar.f721k.setVisibility(0);
        bVar.f716f.setVisibility(8);
        INativeAd ad2 = recommendCard.getAd();
        bVar.f721k.register(ad2);
        String strM70812g = C11842p.m70812g(this.f708a, ad2.getImageInfos());
        C11839m.m70688i("RecommendDetailAdapter", " bindPpsItemView url :" + strM70812g);
        String ppsPicturePathFromSp = RecommendCardManager.getInstance().getPpsPicturePathFromSp(strM70812g, RecommendCardConstants.Entrance.HOMEPAGE);
        C11839m.m70688i("RecommendDetailAdapter", " bindPpsItemView path :" + ppsPicturePathFromSp);
        if (TextUtils.isEmpty(ppsPicturePathFromSp)) {
            return;
        }
        bVar.f722l.setImageBitmap(RecommendCardManager.getInstance().getPictureBitmapUserCache(ppsPicturePathFromSp));
        bVar.f723m.setText(ad2.getTitle());
        bVar.f723m.setVisibility(0);
        int iM1013d = m1013d();
        if (iM1013d > 0) {
            m1017h(bVar.f724n, iM1013d);
            m1017h(bVar.f721k, iM1013d + C11842p.m70840n(this.f708a, 52));
        } else {
            m1017h(bVar.f724n, C11842p.m70840n(this.f708a, 96));
            m1017h(bVar.f721k, C11842p.m70840n(this.f708a, 148));
        }
    }

    /* renamed from: d */
    public final int m1013d() {
        int iM70758Q;
        int iM76823b;
        if (C0209d.m1297q1(this.f708a)) {
            iM70758Q = C11842p.m70752O(this.f708a) - (((int) C11842p.m70844o(this.f708a, 12)) * 2);
            iM76823b = C11842p.m70789a0(this.f708a);
        } else {
            iM70758Q = C11842p.m70758Q(this.f708a) - (((int) C11842p.m70844o(this.f708a, 12)) * 2);
            iM76823b = C12808e.m76823b() * 2;
        }
        return Math.round((iM70758Q - iM76823b) * RecommendCardManager.getInstance().getCurrentProportion());
    }

    /* renamed from: e */
    public final int m1014e(RecommendCard recommendCard) {
        return (C11842p.m70753O0(this.f708a) ? C11842p.m70752O(this.f708a) : C11842p.m70758Q(this.f708a) - (C12808e.m76823b() * 2)) - (C11842p.m70771U0() ? TextUtils.isEmpty(recommendCard.getButton()) ? C11842p.m70840n(this.f708a, 52) : C11842p.m70840n(this.f708a, 172) : TextUtils.isEmpty(recommendCard.getButton()) ? C11842p.m70840n(this.f708a, 52) : C11842p.m70840n(this.f708a, SyncType.OPEN_SWITCH_FROM_GUIDE));
    }

    /* renamed from: f */
    public final void m1015f(RecommendCard recommendCard, ImageView imageView, int i10) {
        Bitmap pictureBitmapUserCache;
        String suitablePicturePath = RecommendCardManager.getInstance().getSuitablePicturePath(recommendCard.getLandscapePicturePath(), recommendCard.getPortraitPicturePath());
        if (!TextUtils.isEmpty(suitablePicturePath) && (pictureBitmapUserCache = RecommendCardManager.getInstance().getPictureBitmapUserCache(suitablePicturePath)) != null) {
            imageView.setImageBitmap(pictureBitmapUserCache);
        }
        if (RecommendCardConstants.ActivityType.CAMPAIGN_ACTIVITY_CENTER.equals(recommendCard.getActivityType())) {
            m1019j(imageView, recommendCard, i10);
        }
    }

    /* renamed from: g */
    public void m1016g(List<RecommendCard> list) {
        this.f709b = new ArrayList<>(list);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f709b.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i10) {
        return this.f709b.get(i10);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) throws Resources.NotFoundException {
        b bVar;
        RecommendCard recommendCard = this.f709b.get(i10);
        C11839m.m70688i("RecommendDetailAdapter", " getView position :" + i10);
        if (view == null) {
            view = C11842p.m70771U0() ? LayoutInflater.from(this.f708a).inflate(R$layout.recommend_detail_item_pad, viewGroup, false) : LayoutInflater.from(this.f708a).inflate(R$layout.recommend_detail_item, viewGroup, false);
            bVar = new b();
            bVar.f711a = (TextView) C12809f.m76831d(view, R$id.recommend_title);
            bVar.f712b = (TextView) C12809f.m76831d(view, R$id.recommend_sub_title);
            bVar.f713c = (ImageView) C12809f.m76831d(view, R$id.recommend_top_bg);
            bVar.f714d = (TextView) C12809f.m76831d(view, R$id.card_operation_info);
            bVar.f715e = (TextView) C12809f.m76831d(view, R$id.operation_button);
            bVar.f716f = (RelativeLayout) C12809f.m76831d(view, R$id.recommend_detail_item);
            bVar.f717g = (RelativeLayout) C12809f.m76831d(view, R$id.recommend_no_info);
            bVar.f720j = (ImageView) C12809f.m76831d(view, R$id.recommend_whole_bg);
            bVar.f719i = (RelativeLayout) C12809f.m76831d(view, R$id.rl_recommend_top);
            bVar.f718h = (RelativeLayout) C12809f.m76831d(view, R$id.rl_recommend_info);
            bVar.f721k = (PPSNativeView) C12809f.m76831d(view, R$id.recommend_detail_pps_item);
            bVar.f722l = (ImageView) C12809f.m76831d(view, R$id.recommend_pps_top_bg);
            bVar.f723m = (TextView) C12809f.m76831d(view, R$id.pps_operation_info);
            bVar.f724n = (RelativeLayout) C12809f.m76831d(view, R$id.rl_recommend_pps_top);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        bVar.f716f.setTag(Integer.valueOf(i10));
        NotifyTypeAndUriGoto notifyTypeAndUriGoto = recommendCard.getNotifyTypeAndUriGoto();
        if (notifyTypeAndUriGoto == null) {
            C11839m.m70687e("RecommendDetailAdapter", "gotoObj is null");
            return view;
        }
        String notifyType = notifyTypeAndUriGoto.getNotifyType();
        C11839m.m70686d("RecommendDetailAdapter", "gotoType: " + notifyType + ", gotoUri: " + notifyTypeAndUriGoto.getNotifyUri());
        if (TextUtils.equals(notifyType, NotifyConstants.HICLOUD_KA)) {
            C2783d.m16088I0(recommendCard, i10, true);
        }
        if (!TextUtils.isEmpty(recommendCard.getAdvertId())) {
            m1012c(recommendCard, bVar);
            return view;
        }
        int iM1014e = m1014e(recommendCard);
        bVar.f711a.setMaxWidth(iM1014e);
        bVar.f712b.setMaxWidth(iM1014e);
        bVar.f716f.setOnClickListener(this.f710c);
        m1010a(recommendCard, bVar);
        return view;
    }

    /* renamed from: h */
    public final void m1017h(View view, float f10) {
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.height = (int) f10;
            view.setLayoutParams(layoutParams);
        }
    }

    /* renamed from: i */
    public void m1018i(View.OnClickListener onClickListener) {
        this.f710c = onClickListener;
    }

    /* renamed from: j */
    public final void m1019j(ImageView imageView, RecommendCard recommendCard, int i10) {
        String suitablePicturePath = RecommendCardManager.getInstance().getSuitablePicturePath(recommendCard.getLandscapePicturePath(), recommendCard.getPortraitPicturePath());
        Drawable drawableM82907C = C13823d.m82904y().m82907C(suitablePicturePath);
        if (drawableM82907C == null || imageView == null) {
            C11839m.m70687e("RecommendDetailAdapter", "setRecommendCardGif drawable or itemView is null ");
            return;
        }
        C11839m.m70686d("RecommendDetailAdapter", "setRecommendCardGif type " + C13823d.m82904y().m82933q(suitablePicturePath));
        if (MimeType.GIF.equals(C13823d.m82904y().m82933q(suitablePicturePath))) {
            if (drawableM82907C instanceof AnimatedImageDrawable) {
                ((AnimatedImageDrawable) drawableM82907C).start();
            }
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            if (imageView instanceof HiCloudRoundRectImageView) {
                ((HiCloudRoundRectImageView) imageView).setMode(i10);
            }
            imageView.setImageDrawable(drawableM82907C);
        }
    }
}
