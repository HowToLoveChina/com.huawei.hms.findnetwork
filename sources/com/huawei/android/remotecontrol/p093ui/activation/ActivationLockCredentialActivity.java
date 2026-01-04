package com.huawei.android.remotecontrol.p093ui.activation;

import android.R;
import android.app.ActionBar;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.huawei.android.hicloud.p088ui.activity.UIActivity;
import com.huawei.android.remotecontrol.sdk.R$color;
import com.huawei.android.remotecontrol.sdk.R$dimen;
import com.huawei.android.remotecontrol.sdk.R$drawable;
import com.huawei.android.remotecontrol.sdk.R$id;
import com.huawei.android.remotecontrol.sdk.R$layout;
import com.huawei.android.remotecontrol.sdk.R$string;
import com.huawei.android.remotecontrol.util.account.bean.AccountInfo;
import com.huawei.hms.support.api.entity.pay.HwPayConstant;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.huawei.hms.support.hwid.HuaweiIdAdvancedManager;
import com.huawei.hms.support.hwid.bean.CheckPasswordByUserIdReq;
import com.huawei.hms.support.hwid.common.cloudservice.CloudRequestHandler;
import com.huawei.hwid.core.helper.handler.ErrorStatus;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import com.huawei.secure.android.common.intent.SafeIntent;
import com.huawei.uikit.hwedittext.widget.HwErrorTipTextLayout;
import com.huawei.uikit.phone.hwbutton.widget.HwButton;
import com.huawei.uikit.phone.hwcheckbox.widget.HwCheckBox;
import hu.C10343b;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.util.function.Consumer;
import ng.C11703j;
import org.json.JSONException;
import p015ak.C0209d;
import p015ak.C0219i;
import p015ak.C0241z;
import p367ig.C10500e;
import p514o9.C11829c;
import p514o9.C11842p;
import p521og.C11871d;
import p521og.C11880m;
import p521og.C11881n;
import p577qg.C12354d;
import p809yg.C13981a;
import pg.AbstractC12139d;
import sk.C12809f;

/* loaded from: classes4.dex */
public class ActivationLockCredentialActivity extends UIActivity implements View.OnClickListener {

    /* renamed from: A */
    public TextView f20548A;

    /* renamed from: E */
    public String f20552E;

    /* renamed from: F */
    public String f20553F;

    /* renamed from: G */
    public String f20554G;

    /* renamed from: H */
    public String f20555H;

    /* renamed from: I */
    public String f20556I;

    /* renamed from: J */
    public String f20557J;

    /* renamed from: K */
    public String f20558K;

    /* renamed from: L */
    public ProgressDialog f20559L;

    /* renamed from: M */
    public ViewTreeObserverOnGlobalLayoutListenerC4482d f20560M;

    /* renamed from: N */
    public HandlerC4483e f20561N;

    /* renamed from: p */
    public View f20562p;

    /* renamed from: q */
    public View f20563q;

    /* renamed from: r */
    public View f20564r;

    /* renamed from: s */
    public View f20565s;

    /* renamed from: t */
    public View f20566t;

    /* renamed from: u */
    public HwErrorTipTextLayout f20567u;

    /* renamed from: v */
    public EditText f20568v;

    /* renamed from: w */
    public HwCheckBox f20569w;

    /* renamed from: x */
    public HwButton f20570x;

    /* renamed from: y */
    public NetWorkChangeReceiver f20571y;

    /* renamed from: z */
    public String f20572z = "";

    /* renamed from: B */
    public boolean f20549B = false;

    /* renamed from: C */
    public boolean f20550C = false;

    /* renamed from: D */
    public boolean f20551D = false;

    public class NetWorkChangeReceiver extends BroadcastReceiver {
        public NetWorkChangeReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null && "android.net.conn.CONNECTIVITY_CHANGE".equals(new SafeIntent(intent).getAction())) {
                C13981a.m83989i("ActivationLockCredentialActivity", "network connected");
                ActivationLockCredentialActivity.this.m27300m2();
            }
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.ui.activation.ActivationLockCredentialActivity$b */
    public static class C4480b implements CloudRequestHandler {

        /* renamed from: a */
        public final WeakReference<ActivationLockCredentialActivity> f20574a;

        public C4480b(ActivationLockCredentialActivity activationLockCredentialActivity) {
            this.f20574a = new WeakReference<>(activationLockCredentialActivity);
        }

        @Override // com.huawei.hms.support.hwid.common.cloudservice.CloudRequestHandler
        public void onError(ErrorStatus errorStatus) throws JSONException {
            String str;
            C13981a.m83988e("ActivationLockCredentialActivity", "onError");
            ActivationLockCredentialActivity activationLockCredentialActivity = this.f20574a.get();
            if (activationLockCredentialActivity == null) {
                C13981a.m83988e("ActivationLockCredentialActivity", "onError activity null, return");
                return;
            }
            if (errorStatus != null) {
                str = errorStatus.getErrorCode() + ",reason:" + errorStatus.getErrorReason();
            } else {
                str = "";
            }
            C13981a.m83988e("ActivationLockCredentialActivity", "doCheckPassword onError: " + str);
            if (activationLockCredentialActivity.f20561N != null) {
                activationLockCredentialActivity.f20561N.removeMessages(3);
                Message.obtain(activationLockCredentialActivity.f20561N, 2, errorStatus).sendToTarget();
            }
            C12354d.m74356v("checkCredentialPageClick", "fail", str);
        }

        @Override // com.huawei.hms.support.hwid.common.cloudservice.CloudRequestHandler
        public void onFinish(Bundle bundle) throws JSONException {
            C13981a.m83989i("ActivationLockCredentialActivity", "onFinish");
            ActivationLockCredentialActivity activationLockCredentialActivity = this.f20574a.get();
            if (activationLockCredentialActivity == null) {
                C13981a.m83988e("ActivationLockCredentialActivity", "onFinish activity null, return");
                return;
            }
            if (bundle == null) {
                C13981a.m83988e("ActivationLockCredentialActivity", "onFinish bundle null, return");
                return;
            }
            C13981a.m83989i("ActivationLockCredentialActivity", "doCheckPassword finish");
            if (activationLockCredentialActivity.f20561N != null) {
                activationLockCredentialActivity.f20561N.removeMessages(3);
                Message messageObtainMessage = activationLockCredentialActivity.f20561N.obtainMessage(1);
                messageObtainMessage.setData(bundle);
                activationLockCredentialActivity.f20561N.sendMessage(messageObtainMessage);
            }
            C12354d.m74356v("checkCredentialPageClick", "success", "check password success");
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.ui.activation.ActivationLockCredentialActivity$c */
    public class C4481c implements TextWatcher {
        public C4481c() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            if (ActivationLockCredentialActivity.this.f20567u != null && !TextUtils.isEmpty(ActivationLockCredentialActivity.this.f20567u.getError())) {
                ActivationLockCredentialActivity.this.f20567u.setError(null);
            }
            if (ActivationLockCredentialActivity.this.f20568v == null || ActivationLockCredentialActivity.this.f20570x == null) {
                return;
            }
            Editable text = ActivationLockCredentialActivity.this.f20568v.getText();
            if (text == null || TextUtils.isEmpty(text.toString())) {
                ActivationLockCredentialActivity.this.f20570x.setEnabled(false);
            } else {
                ActivationLockCredentialActivity.this.f20570x.setEnabled(true);
            }
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.ui.activation.ActivationLockCredentialActivity$d */
    public static class ViewTreeObserverOnGlobalLayoutListenerC4482d implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a */
        public int f20576a;

        /* renamed from: b */
        public WeakReference<ActivationLockCredentialActivity> f20577b;

        /* renamed from: c */
        public ViewGroup.LayoutParams f20578c;

        public ViewTreeObserverOnGlobalLayoutListenerC4482d(ActivationLockCredentialActivity activationLockCredentialActivity) {
            this.f20577b = new WeakReference<>(activationLockCredentialActivity);
        }

        /* renamed from: a */
        public final int m27301a(View view) {
            Rect rect = new Rect();
            view.getWindowVisibleDisplayFrame(rect);
            return (rect.bottom - rect.top) + C11842p.m70789a0(this.f20577b.get());
        }

        /* renamed from: b */
        public final View m27302b() {
            FrameLayout frameLayout;
            ActivationLockCredentialActivity activationLockCredentialActivity = this.f20577b.get();
            if (activationLockCredentialActivity == null || (frameLayout = (FrameLayout) C12809f.m76829b(activationLockCredentialActivity, R.id.content)) == null) {
                return null;
            }
            View childAt = frameLayout.getChildAt(0);
            this.f20578c = childAt.getLayoutParams();
            return childAt;
        }

        /* renamed from: c */
        public final void m27303c() {
            View viewM27302b = m27302b();
            if (viewM27302b == null) {
                return;
            }
            int iM27301a = m27301a(viewM27302b);
            C13981a.m83989i("SoftKeyBoardWatch", "usableHeightNow=" + iM27301a);
            C13981a.m83989i("SoftKeyBoardWatch", "usableHeightPrevious=" + this.f20576a);
            if (iM27301a != this.f20576a) {
                int height = viewM27302b.getRootView().getHeight();
                int i10 = height - iM27301a;
                ActivationLockCredentialActivity activationLockCredentialActivity = this.f20577b.get();
                if (activationLockCredentialActivity == null) {
                    return;
                }
                C13981a.m83989i("SoftKeyBoardWatch", "usableHeightSansKeyboard=" + height);
                C13981a.m83989i("SoftKeyBoardWatch", "heightDifference=" + i10);
                if (i10 > height / 4) {
                    if (C0219i.m1463a() >= 21) {
                        this.f20578c.height = height - i10;
                        C13981a.m83989i("SoftKeyBoardWatch", "1 frameLayoutParams.height=" + this.f20578c.height);
                    }
                    activationLockCredentialActivity.m27298i2(true);
                } else {
                    if (C0219i.m1463a() >= 21) {
                        this.f20578c.height = height;
                        C13981a.m83989i("SoftKeyBoardWatch", "2 frameLayoutParams.height=" + this.f20578c.height);
                    }
                    activationLockCredentialActivity.m27298i2(false);
                }
                viewM27302b.requestLayout();
                this.f20576a = iM27301a;
            }
        }

        /* renamed from: d */
        public void m27304d() {
            ViewTreeObserver viewTreeObserver;
            View viewM27302b = m27302b();
            if (viewM27302b == null || (viewTreeObserver = viewM27302b.getViewTreeObserver()) == null) {
                return;
            }
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }

        /* renamed from: e */
        public void m27305e() {
            ViewTreeObserver viewTreeObserver;
            View viewM27302b = m27302b();
            if (viewM27302b == null || (viewTreeObserver = viewM27302b.getViewTreeObserver()) == null) {
                return;
            }
            viewTreeObserver.removeOnGlobalLayoutListener(this);
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            m27303c();
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.ui.activation.ActivationLockCredentialActivity$e */
    public static class HandlerC4483e extends Handler {

        /* renamed from: a */
        public final WeakReference<ActivationLockCredentialActivity> f20579a;

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            ActivationLockCredentialActivity activationLockCredentialActivity = this.f20579a.get();
            if (activationLockCredentialActivity == null || activationLockCredentialActivity.isFinishing()) {
                C13981a.m83990w("ActivationLockCredentialActivity", "activity null or isFinishing!");
                return;
            }
            C13981a.m83989i("ActivationLockCredentialActivity", "handleMessage: " + message.what);
            int i10 = message.what;
            if (1 == i10) {
                String strM63694p = new C10343b(message.getData()).m63694p(CommonConstant.KEY_ID_TOKEN);
                activationLockCredentialActivity.f20572z = strM63694p;
                activationLockCredentialActivity.m27296g2(strM63694p);
            } else if (2 == i10) {
                activationLockCredentialActivity.m27295f2(message.obj);
            } else if (3 == i10) {
                activationLockCredentialActivity.m27295f2(new ErrorStatus(401, ""));
            }
        }

        public HandlerC4483e(ActivationLockCredentialActivity activationLockCredentialActivity) {
            super(Looper.getMainLooper());
            this.f20579a = new WeakReference<>(activationLockCredentialActivity);
        }
    }

    /* renamed from: B1 */
    private void m27269B1() throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setTitle("");
            int i10 = R$color.hicloud_hmos_bg;
            C11842p.m70842n1(actionBar, new ColorDrawable(getColor(i10)));
            actionBar.setBackgroundDrawable(new ColorDrawable(getColor(i10)));
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        getWindow().setStatusBarColor(getColor(R$color.hicloud_hmos_bg));
    }

    /* renamed from: b2 */
    private void m27280b2() {
        C13981a.m83989i("ActivationLockCredentialActivity", "initData");
        SafeIntent safeIntent = new SafeIntent(getIntent());
        this.f20549B = safeIntent.getBooleanExtra("showErrorPage", false);
        this.f20550C = safeIntent.getBooleanExtra("showTaErrorPage", false);
        this.f20552E = safeIntent.getStringExtra(JsbMapKeyNames.H5_USER_ID);
        this.f20553F = safeIntent.getStringExtra("parentUid");
        this.f20557J = safeIntent.getStringExtra("deviceId");
        this.f20556I = safeIntent.getStringExtra(JsbMapKeyNames.H5_DEVICE_TYPE);
        this.f20558K = safeIntent.getStringExtra(HwPayConstant.KEY_SITE_ID);
        this.f20554G = safeIntent.getStringExtra("accountName");
        this.f20555H = safeIntent.getStringExtra("parentAccountName");
    }

    /* renamed from: c2 */
    private void m27281c2() {
        C13981a.m83989i("ActivationLockCredentialActivity", "initView");
        this.f20562p = C12809f.m76829b(this, R$id.avtivation_main_ll);
        this.f20563q = C12809f.m76829b(this, R$id.activation_net_error);
        this.f20564r = C12809f.m76829b(this, R$id.activation_credential_error);
        this.f20565s = C12809f.m76829b(this, R$id.avtivation_top_layout);
        this.f20566t = C12809f.m76829b(this, R$id.activate_btn_layout);
        this.f20548A = (TextView) C12809f.m76829b(this, R$id.activation_credential_tv);
        TextView textView = (TextView) C12809f.m76829b(this, R$id.activation_tip);
        String strM27287V1 = m27287V1(this.f20554G);
        if (TextUtils.isEmpty(this.f20553F)) {
            C12809f.m76841n(textView, getString(R$string.findmyphone_activation_info_90_new, strM27287V1));
        } else {
            C12809f.m76841n(textView, getString(R$string.findmyphone_activation_info_90_new_parent, strM27287V1, m27287V1(this.f20555H)));
        }
        this.f20567u = (HwErrorTipTextLayout) C12809f.m76829b(this, R$id.activation_password_layout);
        EditText editText = (EditText) C12809f.m76829b(this, R$id.activation_password);
        this.f20568v = editText;
        if (editText != null) {
            editText.addTextChangedListener(new C4481c());
            this.f20568v.setLongClickable(false);
        }
        HwCheckBox hwCheckBox = (HwCheckBox) C12809f.m76829b(this, R$id.activation_password_eye);
        this.f20569w = hwCheckBox;
        if (hwCheckBox != null) {
            hwCheckBox.setOnClickListener(this);
        }
        m27286p2(false);
        HwButton hwButton = (HwButton) C12809f.m76829b(this, R$id.activate_btn);
        this.f20570x = hwButton;
        if (hwButton != null) {
            hwButton.setEnabled(false);
            this.f20570x.setOnClickListener(this);
        }
        HwButton hwButton2 = (HwButton) C12809f.m76829b(this, R$id.activation_set_network);
        if (hwButton2 != null) {
            hwButton2.setOnClickListener(this);
        }
        C13981a.m83989i("ActivationLockCredentialActivity", "initView, isShowErrorPage: " + this.f20549B + ", isShowTaErrorPage: " + this.f20550C);
        if (this.f20549B) {
            m27299l2();
            C12354d.m74353s("showErrorPage");
        }
        if (this.f20550C) {
            C12809f.m76840m(this.f20548A, R$string.pf_activation_tip_assistance_dialog);
            m27299l2();
            C12354d.m74353s("showTaErrorPage");
        }
    }

    /* renamed from: j2 */
    private void m27282j2() {
        this.f20571y = new NetWorkChangeReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        registerReceiver(this.f20571y, intentFilter, "com.huawei.cg.permission.SERVICE", null);
    }

    /* renamed from: k2 */
    private void m27283k2() {
        ProgressDialog progressDialogShow = ProgressDialog.show(this, "", getString(R$string.activate_progress), true, false);
        this.f20559L = progressDialogShow;
        progressDialogShow.show();
    }

    /* renamed from: n2 */
    private void m27284n2() {
        C13981a.m83989i("ActivationLockCredentialActivity", "showNetErrorView");
        C12809f.m76842o(this.f20563q, this.f20562p, this.f20564r);
    }

    /* renamed from: o2 */
    private void m27285o2() {
        NetWorkChangeReceiver netWorkChangeReceiver = this.f20571y;
        if (netWorkChangeReceiver != null) {
            unregisterReceiver(netWorkChangeReceiver);
            this.f20571y = null;
        }
    }

    /* renamed from: p2 */
    private void m27286p2(boolean z10) {
        EditText editText = this.f20568v;
        if (editText != null) {
            if (z10) {
                editText.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            } else {
                editText.setTransformationMethod(new C10500e());
            }
            try {
                EditText editText2 = this.f20568v;
                editText2.setSelection(editText2.getText().toString().length());
            } catch (Exception e10) {
                C13981a.m83988e("ActivationLockCredentialActivity", "updatePasswordState" + e10.getMessage());
            }
        }
        if (this.f20569w != null) {
            if (C0209d.m1281m1()) {
                this.f20569w.setButtonDrawable(R$drawable.pf_box_pwd_eye_honor);
            } else {
                this.f20569w.setButtonDrawable(R$drawable.pf_box_pwd_eye);
            }
            this.f20569w.setTag(Boolean.valueOf(z10));
        }
    }

    /* renamed from: V1 */
    public final String m27287V1(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        } else if (!str.contains("*")) {
            C13981a.m83988e("ActivationLockCredentialActivity", "accountName is not mask");
            str = C11871d.m71159b(str);
        }
        if (C11881n.m71341D()) {
            return str;
        }
        return "\u202d" + str + "\u202c";
    }

    /* renamed from: W1 */
    public final void m27288W1(String str) throws JSONException {
        C13981a.m83989i("ActivationLockCredentialActivity", "doCheckPassword by hms sdk");
        AccountInfo accountInfoM72766e = AbstractC12139d.m72766e(this);
        if (accountInfoM72766e == null) {
            C13981a.m83988e("ActivationLockCredentialActivity", "accountInfo null");
            C12354d.m74356v("checkCredentialPageClick", "fail", "accountInfo is null");
            return;
        }
        HuaweiIdAdvancedManager.getService(this).checkPasswordByUserId(this, new CheckPasswordByUserIdReq(getPackageName(), this.f20552E, str, "", (TextUtils.isEmpty(this.f20558K) || "-1".equals(this.f20558K)) ? C0241z.m1685c(accountInfoM72766e.getSiteID()) : C0241z.m1685c(this.f20558K), "10055832", this.f20553F, this.f20557J, "", this.f20556I), new C4480b(this));
        HandlerC4483e handlerC4483e = this.f20561N;
        if (handlerC4483e != null) {
            handlerC4483e.sendEmptyMessageDelayed(3, 38000L);
        }
    }

    /* renamed from: X1 */
    public void m27289X1() {
        ProgressDialog progressDialog = this.f20559L;
        if (progressDialog != null) {
            progressDialog.dismiss();
            this.f20559L = null;
        }
    }

    /* renamed from: Y1 */
    public final String m27290Y1(int i10) {
        int iM27248S0 = ActivationBaseActivity.m27248S0(i10);
        if (iM27248S0 > 0) {
            return getString(iM27248S0);
        }
        return null;
    }

    /* renamed from: Z1 */
    public final String m27291Z1(int i10, int i11) {
        int iM27248S0 = ActivationBaseActivity.m27248S0(i10);
        if (iM27248S0 <= 0) {
            return null;
        }
        return getResources().getString(iM27248S0) + "(" + i11 + ")";
    }

    /* renamed from: a2 */
    public final String m27292a2(int i10) {
        if (i10 != 1 && i10 != 2 && i10 != 3 && i10 != 37 && i10 != 401) {
            if (i10 == 2003) {
                return m27290Y1(2);
            }
            if (i10 == 2005) {
                return getString(R$string.net_err_tip_no_net);
            }
            if (i10 != 3002 && i10 != 70001201) {
                if (i10 == 70002003) {
                    return getString(R$string.activation_password_error);
                }
                if (i10 == 70002076) {
                    return getString(R$string.activation_account_is_frozen_new);
                }
                if (i10 != 3005 && i10 != 3006) {
                    switch (i10) {
                        case 70002057:
                        case 70002058:
                            return m27290Y1(1);
                        default:
                            return m27291Z1(3, i10);
                    }
                }
            }
        }
        return m27291Z1(402, i10);
    }

    /* renamed from: d2 */
    public final /* synthetic */ void m27293d2(Boolean bool) {
        m27289X1();
        if (bool.booleanValue()) {
            C13981a.m83989i("ActivationLockCredentialActivity", "checkActiveCredential success");
            finish();
        } else {
            C13981a.m83989i("ActivationLockCredentialActivity", "checkActiveCredential fail");
            C11880m.m71336c(this, R$string.recovery_no_data_server_error);
        }
    }

    /* renamed from: e2 */
    public final void m27294e2() throws JSONException {
        C13981a.m83989i("ActivationLockCredentialActivity", "onActiveBtnClicked");
        if (!C0209d.m1333z1(this)) {
            m27284n2();
            return;
        }
        Editable text = this.f20568v.getText();
        if (text == null) {
            C13981a.m83988e("ActivationLockCredentialActivity", "mPasswordText is null");
            return;
        }
        String string = text.toString();
        if (TextUtils.isEmpty(string)) {
            C13981a.m83988e("ActivationLockCredentialActivity", "password is empty");
        } else {
            m27283k2();
            m27288W1(string);
        }
    }

    /* renamed from: f2 */
    public final void m27295f2(Object obj) {
        C13981a.m83988e("ActivationLockCredentialActivity", "onCheckPwdError");
        m27289X1();
        ErrorStatus errorStatus = obj instanceof ErrorStatus ? (ErrorStatus) obj : null;
        int errorCode = errorStatus == null ? -1 : errorStatus.getErrorCode();
        if (2016 == errorCode) {
            errorCode = errorStatus.getSubErrCode();
        }
        C13981a.m83989i("ActivationLockCredentialActivity", "onCheckPwdError, errorCode:" + errorCode);
        String strM27292a2 = m27292a2(errorCode);
        if (TextUtils.isEmpty(strM27292a2)) {
            return;
        }
        C13981a.m83988e("ActivationLockCredentialActivity", "onCheckPwdError: " + strM27292a2);
        HwErrorTipTextLayout hwErrorTipTextLayout = this.f20567u;
        if (hwErrorTipTextLayout != null) {
            hwErrorTipTextLayout.setError(strM27292a2);
        }
    }

    /* renamed from: g2 */
    public final void m27296g2(String str) {
        C13981a.m83989i("ActivationLockCredentialActivity", "onCheckPwdSuccess");
        this.f20551D = true;
        C12354d.m74338d(str, new Consumer() { // from class: hg.b
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f49472a.m27293d2((Boolean) obj);
            }
        });
    }

    /* renamed from: h2 */
    public final void m27297h2() {
        boolean zBooleanValue;
        C13981a.m83989i("ActivationLockCredentialActivity", "onPwdEyeClicked");
        HwCheckBox hwCheckBox = this.f20569w;
        if (hwCheckBox == null) {
            return;
        }
        try {
            zBooleanValue = ((Boolean) hwCheckBox.getTag()).booleanValue();
        } catch (RuntimeException e10) {
            C13981a.m83990w("ActivationLockCredentialActivity", "updatePasswordState" + e10.getMessage());
            zBooleanValue = false;
        }
        m27286p2(!zBooleanValue);
    }

    /* renamed from: i2 */
    public final void m27298i2(boolean z10) {
        View view = this.f20565s;
        if (view == null) {
            return;
        }
        view.setVisibility(z10 ? 8 : 0);
        C11842p.m70724E1(this.f20566t, z10 ? getResources().getDimensionPixelSize(R$dimen.cloud_space_48_dp) : getResources().getDimensionPixelSize(R$dimen.cloud_space_96_dp));
    }

    /* renamed from: l2 */
    public final void m27299l2() {
        C13981a.m83989i("ActivationLockCredentialActivity", "showCredentialErrView");
        C12809f.m76842o(this.f20564r, this.f20562p, this.f20563q);
    }

    /* renamed from: m2 */
    public final void m27300m2() {
        C13981a.m83989i("ActivationLockCredentialActivity", "showMainView");
        C12809f.m76842o(this.f20562p, this.f20563q, this.f20564r);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws JSONException {
        int id2 = view.getId();
        if (id2 == R$id.activation_password_eye) {
            m27297h2();
        }
        if (id2 == R$id.activate_btn) {
            m27294e2();
        }
        if (id2 == R$id.activation_set_network) {
            C11829c.m70612r1(this);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        C13981a.m83989i("ActivationLockCredentialActivity", "onCreate");
        super.onCreate(bundle);
        m27269B1();
        setContentView(R$layout.activation_lock_credential);
        m27280b2();
        m27281c2();
        C11703j.m69826v(getWindow(), true);
        m27282j2();
        this.f20561N = new HandlerC4483e();
        if (this.f20560M == null) {
            ViewTreeObserverOnGlobalLayoutListenerC4482d viewTreeObserverOnGlobalLayoutListenerC4482d = new ViewTreeObserverOnGlobalLayoutListenerC4482d(this);
            this.f20560M = viewTreeObserverOnGlobalLayoutListenerC4482d;
            viewTreeObserverOnGlobalLayoutListenerC4482d.m27304d();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        C13981a.m83989i("ActivationLockCredentialActivity", "onDestroy");
        m27285o2();
        ProgressDialog progressDialog = this.f20559L;
        if (progressDialog != null) {
            progressDialog.dismiss();
            this.f20559L = null;
        }
        C11703j.m69826v(getWindow(), false);
        if (this.f20560M == null) {
            ViewTreeObserverOnGlobalLayoutListenerC4482d viewTreeObserverOnGlobalLayoutListenerC4482d = new ViewTreeObserverOnGlobalLayoutListenerC4482d(this);
            this.f20560M = viewTreeObserverOnGlobalLayoutListenerC4482d;
            viewTreeObserverOnGlobalLayoutListenerC4482d.m27305e();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, android.app.Activity
    public void onStop() {
        C13981a.m83989i("ActivationLockCredentialActivity", "onStop");
        if (!this.f20551D) {
            C12354d.m74329E(1004, "");
        }
        finish();
        super.onStop();
    }
}
