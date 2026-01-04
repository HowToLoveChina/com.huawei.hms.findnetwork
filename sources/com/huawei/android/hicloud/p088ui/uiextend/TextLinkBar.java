package com.huawei.android.hicloud.p088ui.uiextend;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.huawei.cloud.base.util.C4633d0;
import com.huawei.hicloud.base.R$id;
import com.huawei.hicloud.base.R$layout;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.task.TextLinkPictureCacheTask;
import com.huawei.hicloud.notification.util.GeneralRedirectUtil;
import com.huawei.uikit.phone.hwtextview.widget.HwTextView;
import je.C10779b0;
import jp.C10906b;
import jp.C10907c;
import kp.C11128d;
import p514o9.C11839m;
import p616rk.C12515a;
import p778xk.C13823d;
import sk.C12809f;

/* loaded from: classes3.dex */
public class TextLinkBar extends LinearLayout implements View.OnClickListener {
    private static final String TAG = "TextLinkBar";
    private String entrance;
    private C10906b textLink;
    private ImageView textLinkClose;
    private ImageView textLinkLogo;
    private HwTextView textLinkTitle;

    public TextLinkBar(Context context) {
        super(context);
        initView();
    }

    private void goTextLinkIntent() {
        C11839m.m70688i(TAG, "goTextLinkIntent");
        C10907c c10907cM65939k = this.textLink.m65939k();
        String str = "";
        if (!NotifyConstants.ACTIVITIE_CENTER.equals(c10907cM65939k.m65946b())) {
            Intent commonGotoIntent = GeneralRedirectUtil.getCommonGotoIntent(c10907cM65939k.m65945a(), c10907cM65939k.m65946b(), false);
            if (commonGotoIntent == null) {
                str = "goTextLinkIntent intent is null!";
            } else {
                try {
                    getContext().startActivity(commonGotoIntent);
                } catch (Exception unused) {
                    str = "startActivity failed!";
                }
            }
        } else if (!C13823d.m82904y().m82913I(getContext(), 10)) {
            str = "activitie center startActivity failed!";
        }
        if (C4633d0.m28404a(str)) {
            return;
        }
        C11839m.m70689w(TAG, str);
        C11128d.m66924g(this.entrance, this.textLink.m65935g(), str, c10907cM65939k.m65945a());
    }

    private void initView() {
        View.inflate(getContext(), R$layout.bar_text_link, this);
        this.textLinkTitle = (HwTextView) findViewById(R$id.text_link_title);
        this.textLinkClose = (ImageView) findViewById(R$id.text_link_close);
        this.textLinkLogo = (ImageView) findViewById(R$id.text_link_logo);
        setOnClickListener(this);
        this.textLinkClose.setOnClickListener(this);
        this.textLinkTitle.setSelected(true);
        C12809f.m76843p(this, false);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        C10907c c10907cM65939k = this.textLink.m65939k();
        if (view.getId() != R$id.text_link_close) {
            goTextLinkIntent();
            C11128d.m66922e(this.entrance, this.textLink.m65935g(), c10907cM65939k.m65945a());
        } else {
            C12809f.m76843p(this, false);
            new C10779b0().m65625d(this.textLink);
            C11128d.m66923f(this.entrance, this.textLink.m65935g(), c10907cM65939k.m65945a());
        }
    }

    public void setEntrance(String str) {
        this.entrance = str;
    }

    public void showContent(C10906b c10906b) {
        if (c10906b == null) {
            C11839m.m70689w(TAG, "showContent textLink is null!");
            return;
        }
        if (c10906b.m65939k() == null) {
            C11839m.m70689w(TAG, "showContent textLinkGoTo is null!");
            return;
        }
        if (C4633d0.m28404a(c10906b.m65932d())) {
            C11839m.m70689w(TAG, "showContent textLink's title is null!");
            return;
        }
        this.textLink = c10906b;
        C11839m.m70688i(TAG, "showContent NotifyType:" + c10906b.m65939k().m65945a());
        C12809f.m76843p(this, true);
        C12809f.m76841n(this.textLinkTitle, c10906b.m65932d());
        Drawable drawableM65931c = c10906b.m65931c();
        if (drawableM65931c != null) {
            this.textLinkLogo.setImageDrawable(drawableM65931c);
        } else {
            C11839m.m70688i(TAG, "drawable is null, retry download pictures");
            C12515a.m75110o().m75175e(new TextLinkPictureCacheTask(), true);
        }
        C11128d.m66925h(this.entrance, c10906b.m65935g(), c10906b.m65939k().m65945a());
    }

    public TextLinkBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }
}
