package p737wd;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.huawei.android.hicloud.common.R$color;
import com.huawei.android.hicloud.common.R$drawable;
import com.huawei.android.hicloud.common.R$id;
import com.huawei.android.hicloud.common.R$layout;
import com.huawei.android.hicloud.p088ui.extend.AutoSizeButton;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.constants.StockActiveConstants;
import com.huawei.hicloud.notification.manager.HiCLoudStockActiveManager;
import com.huawei.hicloud.notification.manager.UserActiveRecommendManager;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0226l0;
import p035bk.C1248a;
import p422k9.C11019b;
import p514o9.C11839m;
import p572qb.C12314i0;
import sk.AlertDialogC12804a;
import sk.C12809f;

/* renamed from: wd.f */
/* loaded from: classes3.dex */
public class ViewOnClickListenerC13593f extends AlertDialogC12804a implements View.OnClickListener {

    /* renamed from: a */
    public Activity f61157a;

    /* renamed from: b */
    public ImageView f61158b;

    /* renamed from: c */
    public TextView f61159c;

    /* renamed from: d */
    public TextView f61160d;

    /* renamed from: e */
    public AutoSizeButton f61161e;

    /* renamed from: f */
    public AutoSizeButton f61162f;

    /* renamed from: g */
    public String f61163g;

    public ViewOnClickListenerC13593f(Activity activity) throws Resources.NotFoundException {
        super(activity);
        if (activity == null) {
            C11839m.m70687e("StockActivePopupGuideDialog", "context is null");
            dismiss();
            return;
        }
        this.f61157a = activity;
        initView();
        m81749c();
        C12314i0.m74036h().m74054t();
        UserActiveRecommendManager.getInstance().report(StockActiveConstants.Report.SHOW_POPUP_GUIDE);
    }

    /* renamed from: c */
    private void m81749c() throws Resources.NotFoundException {
        String[] stockPopup = HiCLoudStockActiveManager.getInstance().getStockPopup();
        if (stockPopup.length != 4) {
            C11839m.m70687e("StockActivePopupGuideDialog", "no language");
            dismiss();
            this.f61157a.finish();
            return;
        }
        String str = stockPopup[0];
        String str2 = stockPopup[1];
        this.f61163g = stockPopup[2];
        String str3 = stockPopup[3];
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(this.f61163g) || TextUtils.isEmpty(str3)) {
            C11839m.m70687e("StockActivePopupGuideDialog", "no language");
            dismiss();
            this.f61157a.finish();
            return;
        }
        Bitmap bitmapM81750b = m81750b();
        if (bitmapM81750b == null) {
            C11839m.m70687e("StockActivePopupGuideDialog", "no picture");
            dismiss();
            this.f61157a.finish();
            return;
        }
        this.f61159c.setText(str);
        String[] strArrSplit = str2.split("\\$\\$x0A");
        StringBuffer stringBuffer = new StringBuffer();
        for (int i10 = 0; i10 < strArrSplit.length - 1; i10++) {
            stringBuffer.append(strArrSplit[i10]);
            stringBuffer.append(System.lineSeparator());
        }
        stringBuffer.append(strArrSplit[strArrSplit.length - 1]);
        this.f61160d.setText(stringBuffer);
        this.f61161e.setText(this.f61163g);
        this.f61162f.setText(str3);
        this.f61158b.setImageBitmap(bitmapM81750b);
    }

    private void initView() {
        AutoSizeButton autoSizeButton;
        View viewInflate = LayoutInflater.from(this.f61157a).inflate(R$layout.stock_active_popup_guide, (ViewGroup) null);
        this.f61158b = (ImageView) C12809f.m76831d(viewInflate, R$id.iv_picture);
        this.f61159c = (TextView) C12809f.m76831d(viewInflate, R$id.tv_title);
        this.f61160d = (TextView) C12809f.m76831d(viewInflate, R$id.tv_content);
        this.f61161e = (AutoSizeButton) C12809f.m76831d(viewInflate, R$id.btn_open_now);
        AutoSizeButton autoSizeButton2 = (AutoSizeButton) C12809f.m76831d(viewInflate, R$id.btn_open_later);
        this.f61162f = autoSizeButton2;
        if (this.f61158b == null || this.f61159c == null || this.f61160d == null || (autoSizeButton = this.f61161e) == null || autoSizeButton2 == null) {
            C11839m.m70687e("StockActivePopupGuideDialog", "initView error");
            dismiss();
            this.f61157a.finish();
        } else {
            autoSizeButton.setOnClickListener(this);
            this.f61162f.setOnClickListener(this);
            setView(viewInflate);
        }
    }

    /* renamed from: b */
    public final Bitmap m81750b() {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            C11839m.m70687e("StockActivePopupGuideDialog", "context is null");
            return null;
        }
        Resources resources = contextM1377a.getResources();
        if (resources != null) {
            return C0209d.m1269j1() ? C1248a.m7477h(resources, R$drawable.stock_active_popup_picture) : C1248a.m7477h(resources, R$drawable.stock_active_popup_picture_hw);
        }
        C11839m.m70687e("StockActivePopupGuideDialog", "resources is null");
        return null;
    }

    /* renamed from: d */
    public final /* synthetic */ void m81751d() {
        this.f61157a.finish();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (C0209d.m1226Y0()) {
            C11839m.m70688i("StockActivePopupGuideDialog", "fast click");
            dismiss();
            this.f61157a.finish();
            return;
        }
        if (view == null) {
            C11839m.m70687e("StockActivePopupGuideDialog", "view is null");
            dismiss();
            this.f61157a.finish();
            return;
        }
        int id2 = view.getId();
        if (id2 == R$id.btn_open_now) {
            C11839m.m70688i("StockActivePopupGuideDialog", "click open now");
            AutoSizeButton autoSizeButton = this.f61161e;
            if (autoSizeButton != null) {
                autoSizeButton.setEnabled(false);
            }
            AutoSizeButton autoSizeButton2 = this.f61162f;
            if (autoSizeButton2 != null) {
                autoSizeButton2.setTextColor(this.f61157a.getColor(R$color.stock_active_open_later_color_66));
                this.f61162f.setClickable(false);
            }
            UserActiveRecommendManager.getInstance().report(StockActiveConstants.Report.CLICK_POPUP_GUIDE_OPEN_NOW);
            try {
                Intent intent = new Intent(this.f61157a, (Class<?>) C11019b.m66371t().m66441r(NotifyConstants.ActivityName.HISYNC_SETTING_ACTIVITY));
                intent.putExtra("is_from_stock_active", true);
                intent.setFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
                this.f61157a.startActivity(intent);
            } catch (Exception e10) {
                C11839m.m70687e("StockActivePopupGuideDialog", "start activity error: " + e10.toString());
            }
        } else if (id2 == R$id.btn_open_later) {
            C11839m.m70688i("StockActivePopupGuideDialog", "click open later");
            UserActiveRecommendManager.getInstance().report(StockActiveConstants.Report.CLICK_POPUP_GUIDE_OPEN_LATER);
            C12314i0.m74036h().m74055u();
        }
        dismiss();
        C0226l0.m1585e(new Runnable() { // from class: wd.e
            @Override // java.lang.Runnable
            public final void run() {
                this.f61156a.m81751d();
            }
        }, 300L);
    }
}
