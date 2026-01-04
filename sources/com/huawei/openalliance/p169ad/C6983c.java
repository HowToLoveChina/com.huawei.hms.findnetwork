package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.hms.ads.C5063a;
import java.util.List;

/* renamed from: com.huawei.openalliance.ad.c */
/* loaded from: classes8.dex */
public class C6983c {

    /* renamed from: a */
    LinearLayout f32098a;

    /* renamed from: b */
    private C5063a f32099b;

    /* renamed from: c */
    private Context f32100c;

    public C6983c(Context context, C5063a c5063a, LinearLayout linearLayout) {
        this.f32100c = context;
        this.f32099b = c5063a;
        this.f32098a = linearLayout;
    }

    /* renamed from: a */
    public void m41164a(List<C7010d> list, boolean z10) {
        int i10;
        int i11;
        this.f32098a.removeAllViews();
        Resources resources = this.f32100c.getResources();
        for (int i12 = 0; i12 < list.size(); i12++) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.f32100c).inflate(C6849R.layout.hiad_choices_item, (ViewGroup) null);
            TextView textView = (TextView) relativeLayout.findViewById(C6849R.id.scroll_view_text_view);
            if (!z10) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(13);
                textView.setLayoutParams(layoutParams);
            }
            textView.setText(list.get(i12).m41240a());
            textView.setTag(list.get(i12).m41241b());
            if (list.get(i12).m41241b() == EnumC6949b.HIDE_AD) {
                textView.setBackgroundResource(C6849R.drawable.hiad_choices_feedback_focus);
                i11 = C6849R.color.hiad_whythisad_btn_hide_text_color;
            } else if (list.get(i12).m41241b() == EnumC6949b.WHY_THIS_AD) {
                textView.setBackgroundResource(C6849R.drawable.hiad_choices_feedback_normal);
                i11 = C6849R.color.hiad_whythisad_btn_why_text_color;
            } else {
                if (list.get(i12).m41241b() == EnumC6949b.CLOSE_AD) {
                    i10 = C6849R.drawable.hiad_choices_feedback_normal;
                } else if (list.get(i12).m41241b() == EnumC6949b.NOT_INTEREST) {
                    i10 = C6849R.drawable.hiad_choices_feedback_special;
                } else {
                    textView.setTextColor(resources.getColor(C6849R.color.hiad_whythisad_btn_fb_text_color));
                    AbstractC7185ho.m43817a("ScrollAdapter", "sdk do-nothing settings.");
                    textView.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.openalliance.ad.c.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            C5063a c5063a;
                            String string;
                            if (view.getTag() == EnumC6949b.HIDE_AD) {
                                AbstractC7185ho.m43817a("ScrollAdapter", "sdk tag is HIDE_AD");
                                C6983c.this.f32099b.m30239e();
                                return;
                            }
                            if (view.getTag() == EnumC6949b.WHY_THIS_AD) {
                                C6983c.this.f32099b.m30237c();
                                return;
                            }
                            if (view.getTag() == EnumC6949b.CLOSE_AD) {
                                string = ((TextView) view).getText().toString();
                                c5063a = C6983c.this.f32099b;
                            } else if (view.getTag() != EnumC6949b.NOT_INTEREST) {
                                AbstractC7185ho.m43817a("ScrollAdapter", "sdk onclick do-nothing");
                                return;
                            } else {
                                c5063a = C6983c.this.f32099b;
                                string = "";
                            }
                            c5063a.m30235a(string);
                        }
                    });
                    this.f32098a.addView(relativeLayout);
                }
                textView.setBackgroundResource(i10);
                i11 = C6849R.color.hiad_whythisad_btn_fb_text_color;
            }
            textView.setTextColor(resources.getColor(i11));
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.openalliance.ad.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    C5063a c5063a;
                    String string;
                    if (view.getTag() == EnumC6949b.HIDE_AD) {
                        AbstractC7185ho.m43817a("ScrollAdapter", "sdk tag is HIDE_AD");
                        C6983c.this.f32099b.m30239e();
                        return;
                    }
                    if (view.getTag() == EnumC6949b.WHY_THIS_AD) {
                        C6983c.this.f32099b.m30237c();
                        return;
                    }
                    if (view.getTag() == EnumC6949b.CLOSE_AD) {
                        string = ((TextView) view).getText().toString();
                        c5063a = C6983c.this.f32099b;
                    } else if (view.getTag() != EnumC6949b.NOT_INTEREST) {
                        AbstractC7185ho.m43817a("ScrollAdapter", "sdk onclick do-nothing");
                        return;
                    } else {
                        c5063a = C6983c.this.f32099b;
                        string = "";
                    }
                    c5063a.m30235a(string);
                }
            });
            this.f32098a.addView(relativeLayout);
        }
    }
}
