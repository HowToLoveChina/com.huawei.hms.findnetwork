package be;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import ca.C1400c;
import com.huawei.android.hicloud.cloudspace.bean.SpaceNoticeEntrance;
import com.huawei.android.hicloud.p088ui.activity.NewHiSyncSettingActivity;
import com.huawei.android.hicloud.p088ui.uiextend.HotTitleTextView;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.cloud.pay.model.ChannelInfo;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.util.NotifyUtil;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hms.network.embedded.C6148x2;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import p015ak.C0209d;
import p054cj.C1442a;
import p684un.C13227f;
import p684un.C13230i;
import p709vj.C13452e;
import sk.C12809f;

/* renamed from: be.h */
/* loaded from: classes3.dex */
public class C1172h extends RecyclerView.AbstractC0838h<a> {

    /* renamed from: d */
    public Context f5542d;

    /* renamed from: e */
    public List<SpaceNoticeEntrance> f5543e;

    /* renamed from: f */
    public ChannelInfo f5544f;

    /* renamed from: g */
    public String f5545g;

    /* renamed from: h */
    public boolean f5546h = true;

    /* renamed from: be.h$a */
    public class a extends RecyclerView.AbstractC0833c0 {

        /* renamed from: u */
        public HotTitleTextView f5547u;

        public a(View view) {
            super(view);
            this.f5547u = (HotTitleTextView) C12809f.m76831d(view, R$id.tv_page_entrance);
        }
    }

    public C1172h(Context context, String str, List<SpaceNoticeEntrance> list) {
        this.f5542d = context;
        this.f5545g = str;
        this.f5543e = list;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* renamed from: E */
    public final Intent m7362E(String str, String str2) {
        Intent intent;
        intent = new Intent();
        str.hashCode();
        switch (str) {
            case "web":
                intent.setAction("android.intent.action.VIEW");
                intent.setData(Uri.parse(str2));
                return intent;
            case "deeplink":
                C0209d.m1302r2(intent, "com.huawei.hidisk");
                intent.setAction("android.intent.action.VIEW");
                intent.setData(Uri.parse(str2));
                return intent;
            case "application":
                if ("hicloud_entrance".equals(str2)) {
                    intent.setClass(this.f5542d, NewHiSyncSettingActivity.class);
                    C13230i.m79525e1(intent, "4", "36");
                } else {
                    Class<?> cls = NotifyConstants.getGotoAppMapping().get(str2);
                    if (cls != null) {
                        intent.setClass(this.f5542d, cls);
                    }
                    if (NotifyConstants.BUY_MORE.equals(str2)) {
                        intent.putExtra(NotifyConstants.BackupNotificationType.FIELD, 8);
                    }
                }
                return intent;
            default:
                return intent;
        }
    }

    /* renamed from: F */
    public void m7363F() {
        this.f5546h = false;
        m5213j();
    }

    /* renamed from: G */
    public final boolean m7364G(a aVar) {
        if (this.f5542d == null || aVar == null) {
            C1442a.m8291w("RecommendCardAdapter", "onBindViewHolder context is null");
            return false;
        }
        List<SpaceNoticeEntrance> list = this.f5543e;
        if (list != null && !list.isEmpty()) {
            return true;
        }
        C1442a.m8291w("RecommendCardAdapter", "recommendPagesList is null or empty.");
        return false;
    }

    /* renamed from: H */
    public final /* synthetic */ void m7365H(SpaceNoticeEntrance spaceNoticeEntrance, View view) {
        if (C0209d.m1226Y0()) {
            C1442a.m8291w("RecommendCardAdapter", "pageEntranceTv click too fast");
            return;
        }
        String uri = spaceNoticeEntrance.getUri();
        String type = spaceNoticeEntrance.getType();
        m7369L(uri.toUpperCase(Locale.ENGLISH) + "_CLICK", this.f5545g, this.f5544f);
        if (!NotifyConstants.HICLOUD_DLAPP.equals(uri) || !(this.f5542d instanceof Activity)) {
            try {
                this.f5542d.startActivity(m7362E(type, uri));
                return;
            } catch (Exception e10) {
                C1442a.m8289e("RecommendCardAdapter", "start goto activity exception:" + e10.toString());
                return;
            }
        }
        C1400c.m8060g("RECOMMONED_PAGE_BANNER_CLICK", null);
        try {
            ((Activity) this.f5542d).startActivityForResult(NotifyUtil.getDlAppWebViewIntent(this.f5542d, spaceNoticeEntrance.getH5JumpUrl()), NotifyConstants.RequestCode.REQUESTCODE_CAMPAIGN);
        } catch (Exception e11) {
            C1442a.m8289e("RecommendCardAdapter", "start goto activity exception:" + e11.toString());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: I */
    public void mo723s(a aVar, int i10) {
        if (m7364G(aVar)) {
            final SpaceNoticeEntrance spaceNoticeEntrance = this.f5543e.get(i10);
            if (spaceNoticeEntrance == null) {
                C1442a.m8291w("RecommendCardAdapter", "entrance is null");
                return;
            }
            String linkConent = spaceNoticeEntrance.getLinkConent();
            if (TextUtils.isEmpty(linkConent)) {
                C1442a.m8291w("RecommendCardAdapter", "entrance is null");
                return;
            }
            aVar.f5547u.setText(linkConent);
            if (NotifyConstants.HICLOUD_DLAPP.equals(spaceNoticeEntrance.getUri()) && this.f5546h) {
                aVar.f5547u.setRedDotVisibility(0);
            } else {
                aVar.f5547u.setRedDotVisibility(8);
            }
            aVar.f5547u.setOnClickListener(new View.OnClickListener() { // from class: be.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f5540a.m7365H(spaceNoticeEntrance, view);
                }
            });
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: J */
    public a mo724u(ViewGroup viewGroup, int i10) {
        C1442a.m8291w("RecommendCardAdapter", "onCreateViewHolder");
        Context context = this.f5542d;
        if (context != null) {
            return new a(C0209d.m1195O(context) >= 1.75f ? LayoutInflater.from(this.f5542d).inflate(R$layout.recommend_page_entrance_item_1dot75, viewGroup, false) : LayoutInflater.from(this.f5542d).inflate(R$layout.recommend_page_entrance_item, viewGroup, false));
        }
        C1442a.m8291w("RecommendCardAdapter", "onCreateViewHolder context is null");
        return null;
    }

    /* renamed from: K */
    public void m7368K(List<SpaceNoticeEntrance> list) {
        this.f5543e = list;
        m5213j();
    }

    /* renamed from: L */
    public final void m7369L(String str, String str2, ChannelInfo channelInfo) {
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put(C6148x2.DEVICE_ID, C13452e.m80781L().m80954p());
        linkedHashMapM79497A.put("recommend_type", str2);
        if (channelInfo != null) {
            linkedHashMapM79497A.put("recommend_channelInfo", channelInfo.toString());
        }
        C13227f.m79492i1().m79567R(str, linkedHashMapM79497A);
        UBAAnalyze.m29947H("CKC", str, linkedHashMapM79497A);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: e */
    public int mo721e() {
        List<SpaceNoticeEntrance> list = this.f5543e;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public C1172h(Context context, String str, List<SpaceNoticeEntrance> list, ChannelInfo channelInfo) {
        this.f5542d = context;
        this.f5545g = str;
        this.f5543e = list;
        this.f5544f = channelInfo;
    }
}
