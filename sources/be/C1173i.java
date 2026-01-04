package be;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity;
import com.huawei.android.hicloud.p088ui.activity.cloudpay.MemberRightActivity;
import com.huawei.android.p073ds.R$color;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.cloud.pay.model.GradePicture;
import com.huawei.cloud.pay.model.MemGradeRightDetail;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import p015ak.C0209d;
import p054cj.C1442a;
import p514o9.C11828b;
import p684un.C13230i;
import p709vj.C13452e;
import sk.C12809f;

/* renamed from: be.i */
/* loaded from: classes3.dex */
public class C1173i extends BaseAdapter {

    /* renamed from: a */
    public List<MemGradeRightDetail> f5549a;

    /* renamed from: b */
    public LayoutInflater f5550b;

    /* renamed from: c */
    public Activity f5551c;

    /* renamed from: d */
    public C11828b f5552d;

    /* renamed from: e */
    public String f5553e;

    /* renamed from: be.i$a */
    public class a implements View.OnClickListener {

        /* renamed from: a */
        public MemGradeRightDetail f5554a;

        /* renamed from: b */
        public String f5555b;

        /* renamed from: c */
        public Activity f5556c;

        public a(MemGradeRightDetail memGradeRightDetail, String str, Activity activity) {
            this.f5554a = memGradeRightDetail;
            this.f5555b = str;
            this.f5556c = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (C0209d.m1226Y0()) {
                C1442a.m8291w("DiamondVipRightListAdapter", "DiamondRightItemClickListener click too fast");
                return;
            }
            if (this.f5554a == null || TextUtils.isEmpty(this.f5555b) || this.f5556c == null) {
                return;
            }
            String rightCode = this.f5554a.getRightCode();
            Intent intent = new Intent(this.f5556c, (Class<?>) MemberRightActivity.class);
            intent.putExtra("rightGradeCode", this.f5555b);
            intent.putExtra("rightRightCode", rightCode);
            intent.putExtra("isavailable", true);
            intent.putExtra("fromActivity", this.f5556c.getClass().getSimpleName());
            intent.putExtra("clickSourceType", "3");
            Activity activity = this.f5556c;
            if (activity instanceof BuyPackageBaseActivity) {
                ((BuyPackageBaseActivity) activity).m22840j2(intent);
                C1173i.m7372h(rightCode, this.f5555b, (BuyPackageBaseActivity) this.f5556c, this.f5556c.getClass().getSimpleName());
            }
            this.f5556c.startActivityForResult(intent, 10010);
        }
    }

    /* renamed from: be.i$b */
    public static class b {

        /* renamed from: a */
        public ImageView f5558a;

        /* renamed from: b */
        public TextView f5559b;

        /* renamed from: c */
        public TextView f5560c;

        /* renamed from: d */
        public TextView f5561d;

        /* renamed from: e */
        public ImageView f5562e;
    }

    public C1173i(List<MemGradeRightDetail> list, LayoutInflater layoutInflater, Activity activity, C11828b c11828b, String str) {
        this.f5549a = list;
        this.f5550b = layoutInflater;
        this.f5551c = activity;
        this.f5552d = c11828b;
        this.f5553e = str;
    }

    /* renamed from: h */
    public static void m7372h(String str, String str2, BuyPackageBaseActivity buyPackageBaseActivity, String str3) {
        if (buyPackageBaseActivity == null) {
            return;
        }
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put("right_code", str);
        linkedHashMapM79497A.put("grade_code", str2);
        linkedHashMapM79497A.put("clickSourceActivity", str3);
        linkedHashMapM79497A.put("click_source_type", "3");
        buyPackageBaseActivity.m22884v4(linkedHashMapM79497A);
    }

    /* renamed from: b */
    public final boolean m7373b(String str) {
        return (str.indexOf("#[#") == -1 || str.indexOf("#]#") == -1) ? false : true;
    }

    /* renamed from: c */
    public final void m7374c(MemGradeRightDetail memGradeRightDetail, Map map, b bVar) {
        if ("FRW".equals(memGradeRightDetail.getRightCode())) {
            m7375d((String) map.get("diamondDesc2"), bVar.f5560c);
            return;
        }
        String str = (String) map.get("diamondDesc");
        if (str != null) {
            bVar.f5560c.setText(str);
        }
    }

    /* renamed from: d */
    public final void m7375d(String str, TextView textView) {
        if (str == null) {
            C1442a.m8290i("DiamondVipRightListAdapter", "diamondName is null");
            return;
        }
        if (!m7373b(str)) {
            textView.setText(str);
            return;
        }
        String[] strArrSplit = str.replaceAll("\\#\\[\\#", "%").replaceAll("\\#\\]\\#", "%").split("%");
        if (strArrSplit.length < 2) {
            textView.setText(str);
            return;
        }
        if (strArrSplit[1].charAt(0) != '#' || strArrSplit[1].length() <= 6) {
            C1442a.m8290i("DiamondVipRightListAdapter", "OM color is null or string is short");
            m7376e(strArrSplit[0], strArrSplit[1], null, textView);
        } else {
            String strSubstring = strArrSplit[1].substring(0, 7);
            m7376e(strArrSplit[0], strArrSplit[1].substring(7), strSubstring, textView);
        }
    }

    /* renamed from: e */
    public final void m7376e(String str, String str2, String str3, TextView textView) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append(str2);
        String string = stringBuffer.toString();
        int iIndexOf = string.indexOf(str2);
        int length = str2.length() + iIndexOf;
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(new ForegroundColorSpan(TextUtils.isEmpty(str3) ? this.f5551c.getResources().getColor(R$color.diamond_right_detail_color) : Color.parseColor(str3)), iIndexOf, length, 33);
        textView.setText(spannableString);
    }

    @Override // android.widget.Adapter
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public MemGradeRightDetail getItem(int i10) {
        return this.f5549a.get(i10);
    }

    /* renamed from: g */
    public void m7378g(List<GradePicture> list, b bVar) {
        if (list == null || list.size() <= 0) {
            return;
        }
        for (GradePicture gradePicture : list) {
            if (gradePicture != null && gradePicture.getPictureType().equals("2")) {
                String url = gradePicture.getUrl();
                String hash = gradePicture.getHash();
                C11828b c11828b = this.f5552d;
                if (c11828b != null) {
                    c11828b.m70491g(url, hash, bVar.f5558a);
                    return;
                }
                return;
            }
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<MemGradeRightDetail> list = this.f5549a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return i10;
    }

    @Override // android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        b bVar;
        MemGradeRightDetail item;
        if (view == null) {
            b bVar2 = new b();
            View viewInflate = this.f5550b.inflate(R$layout.vip_right_list_item, (ViewGroup) null);
            bVar2.f5558a = (ImageView) C12809f.m76831d(viewInflate, R$id.right_icon);
            bVar2.f5559b = (TextView) C12809f.m76831d(viewInflate, R$id.right_title);
            bVar2.f5560c = (TextView) C12809f.m76831d(viewInflate, R$id.right_introduction);
            bVar2.f5561d = (TextView) C12809f.m76831d(viewInflate, R$id.desc_text);
            bVar2.f5562e = (ImageView) C12809f.m76831d(viewInflate, R$id.arrow_icon);
            if (C13452e.m80781L().m80887a1()) {
                bVar2.f5562e.setVisibility(8);
            } else {
                bVar2.f5562e.setVisibility(0);
            }
            viewInflate.setTag(bVar2);
            bVar = bVar2;
            view = viewInflate;
        } else {
            bVar = (b) view.getTag();
        }
        if (i10 >= getCount() || (item = getItem(i10)) == null) {
            return view;
        }
        m7378g(item.getPictures(), bVar);
        Map i18ResourceMap = item.getI18ResourceMap();
        if (i18ResourceMap == null) {
            C1442a.m8289e("DiamondVipRightListAdapter", "right getPropInsts is null");
            return view;
        }
        m7375d((String) i18ResourceMap.get("diamondName"), bVar.f5559b);
        m7374c(item, i18ResourceMap, bVar);
        if (C13452e.m80781L().m80887a1()) {
            view.setClickable(false);
            view.setBackgroundResource(R$drawable.diamond_vip_bg_without_press);
        } else {
            view.setClickable(true);
            view.setOnClickListener(new a(item, this.f5553e, this.f5551c));
            view.setBackgroundResource(R$drawable.diamond_vip_bg);
        }
        return view;
    }
}
