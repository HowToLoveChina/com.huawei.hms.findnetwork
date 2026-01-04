package com.huawei.android.remotecontrol.p093ui.activation;

import android.accounts.OperationCanceledException;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import bf.C1175a;
import com.huawei.android.hicloud.commonlib.util.HwAnimationReflection;
import com.huawei.android.remotecontrol.http.C4349g;
import com.huawei.android.remotecontrol.registration.QueryActiveInfo;
import com.huawei.android.remotecontrol.sdk.R$color;
import com.huawei.android.remotecontrol.sdk.R$drawable;
import com.huawei.android.remotecontrol.sdk.R$id;
import com.huawei.android.remotecontrol.sdk.R$layout;
import com.huawei.android.remotecontrol.sdk.R$string;
import com.huawei.android.remotecontrol.util.account.bean.AccountInfo;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hms.framework.network.restclient.hwhttp.HttpClientGlobalInstance;
import com.huawei.hms.identity.AddressConstants;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.support.api.entity.sns.SNSCode;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.huawei.hms.support.hwid.HuaweiIdAdvancedManager;
import com.huawei.hms.support.hwid.bean.CheckPasswordByUserIdReq;
import com.huawei.hms.support.hwid.common.cloudservice.CloudRequestHandler;
import com.huawei.hwid.core.helper.handler.ErrorStatus;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import com.huawei.uikit.phone.hwcheckbox.widget.HwCheckBox;
import com.huawei.uikit.phone.hwedittext.widget.HwEditText;
import com.huawei.uikit.phone.hwedittext.widget.HwErrorTipTextLayout;
import com.huawei.uikit.phone.hwtextview.widget.HwTextView;
import eg.AbstractC9478g;
import eg.C9477f;
import hu.C10343b;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.function.Consumer;
import ng.C11702i;
import ng.C11703j;
import org.json.JSONArray;
import p015ak.C0209d;
import p015ak.C0226l0;
import p015ak.C0241z;
import p367ig.ActionModeCallbackC10499d;
import p367ig.C10500e;
import p514o9.C11829c;
import p514o9.C11842p;
import p520of.C11853c;
import p520of.C11860j;
import p520of.C11866p;
import p521og.C11871d;
import p521og.C11875h;
import p521og.C11877j;
import p521og.C11880m;
import p575qe.C12347f;
import p616rk.C12515a;
import p664u0.C13108a;
import p681uj.C13195l;
import p709vj.InterfaceC13449b;
import p709vj.InterfaceC13451d;
import p809yg.C13981a;
import pg.AbstractC12139d;
import sg.C12796a;
import sk.C12808e;
import sk.C12809f;

/* loaded from: classes4.dex */
public class CheckPwdActivity extends Activity {

    /* renamed from: y */
    public static long f20678y;

    /* renamed from: e */
    public HwErrorTipTextLayout f20683e;

    /* renamed from: f */
    public HwEditText f20684f;

    /* renamed from: g */
    public HwCheckBox f20685g;

    /* renamed from: h */
    public Button f20686h;

    /* renamed from: i */
    public Button f20687i;

    /* renamed from: j */
    public ProgressDialog f20688j;

    /* renamed from: k */
    public AlertDialog f20689k;

    /* renamed from: l */
    public ProgressDialog f20690l;

    /* renamed from: m */
    public ProgressDialog f20691m;

    /* renamed from: n */
    public Timer f20692n;

    /* renamed from: o */
    public Timer f20693o;

    /* renamed from: p */
    public AlertDialog f20694p;

    /* renamed from: q */
    public AlertDialog f20695q;

    /* renamed from: r */
    public C4510e f20696r;

    /* renamed from: s */
    public long f20697s;

    /* renamed from: a */
    public final C4512g f20679a = new C4512g();

    /* renamed from: b */
    public Context f20680b = null;

    /* renamed from: c */
    public HandlerC4514i f20681c = null;

    /* renamed from: d */
    public HiSyncReceiver f20682d = null;

    /* renamed from: t */
    public boolean f20698t = true;

    /* renamed from: u */
    public boolean f20699u = true;

    /* renamed from: v */
    public String f20700v = "";

    /* renamed from: w */
    public String f20701w = "";

    /* renamed from: x */
    public QueryActiveInfo f20702x = new QueryActiveInfo();

    public class HiSyncReceiver extends BroadcastReceiver {
        public HiSyncReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            if (intent == null) {
                return;
            }
            HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(intent);
            String action = hiCloudSafeIntent.getAction();
            C13981a.m83989i(NotifyConstants.ActivityName.CHECK_PWD_ACTIVITY, "receive action: " + hiCloudSafeIntent.getAction());
            if ("com.huawei.android.hicloud.intent.PHONEFINDER_OPEN_AUTH_FAILE".equals(action)) {
                C13981a.m83989i(NotifyConstants.ActivityName.CHECK_PWD_ACTIVITY, "close find my phone is failed");
                C11877j.m71263f(context);
                CheckPwdActivity.this.m27509G0(false, 1);
                CheckPwdActivity.this.m27521P0();
                CheckPwdActivity.this.m27533V0(401);
                return;
            }
            if ("com.huawei.android.hicloud.intent.PHONEFINDER_LOGOFF_DEREGISTRATION_COMPLETED".equals(action)) {
                C13981a.m83989i(NotifyConstants.ActivityName.CHECK_PWD_ACTIVITY, "close find my phone is success");
                C1175a.m7398t(false, context);
                C11875h.m71193d(context);
                CheckPwdActivity.this.m27521P0();
                CheckPwdActivity.this.m27509G0(true, 0);
                CheckPwdActivity.this.finish();
                return;
            }
            if ("com.huawei.android.hicloud.intent.PHONEFINDER_LOGOFF_DEREGISTRATION_FAIL".equals(action)) {
                C13981a.m83989i(NotifyConstants.ActivityName.CHECK_PWD_ACTIVITY, "close find my phone is failed");
                CheckPwdActivity.this.m27521P0();
                CheckPwdActivity.this.m27509G0(false, 1);
                CheckPwdActivity.this.m27533V0(hiCloudSafeIntent.getIntExtra(AddressConstants.Extras.EXTRA_NAME_ERR_CODE, -1));
                return;
            }
            if ("com.huawei.android.hicloud.intent.PHONEFINDER_CLOSE_AUTH_FAILE".equals(action)) {
                C13981a.m83989i(NotifyConstants.ActivityName.CHECK_PWD_ACTIVITY, "close find my phone is AUTH failed");
                CheckPwdActivity.this.m27521P0();
                CheckPwdActivity.this.m27509G0(false, 1);
                CheckPwdActivity.this.m27533V0(401);
            }
        }
    }

    public static class ResetConfirmDialog extends DialogFragment implements DialogInterface.OnClickListener {
        @Override // android.app.DialogFragment, android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            super.onCancel(dialogInterface);
            Activity activity = getActivity();
            if (activity != null) {
                CheckPwdActivity checkPwdActivity = (CheckPwdActivity) activity;
                checkPwdActivity.m27509G0(false, 2);
                checkPwdActivity.finish();
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            if (i10 == -2) {
                dialogInterface.cancel();
                return;
            }
            if (i10 != -1) {
                return;
            }
            dialogInterface.dismiss();
            Activity activity = getActivity();
            if (activity != null) {
                if (CheckPwdActivity.m27487k0()) {
                    C13981a.m83989i(NotifyConstants.ActivityName.CHECK_PWD_ACTIVITY, "fast click!! ");
                    return;
                }
                CheckPwdActivity checkPwdActivity = (CheckPwdActivity) activity;
                if (C0209d.m1333z1(checkPwdActivity)) {
                    checkPwdActivity.m27516N();
                    return;
                }
                C13981a.m83989i(NotifyConstants.ActivityName.CHECK_PWD_ACTIVITY, "network disconnected");
                C11829c.m70612r1(activity);
                checkPwdActivity.finish();
            }
        }

        @Override // android.app.DialogFragment
        public Dialog onCreateDialog(Bundle bundle) throws IllegalAccessException, IllegalArgumentException {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setTitle(R$string.cloudbackup_alert).setMessage(getActivity().getResources().getString(C11842p.m70762R0() ? R$string.pf_reset_vertify_tips_pad : R$string.pf_reset_vertify_tips)).setNegativeButton(R$string.cloudbackup_Cancel, this).setPositiveButton(R$string.continuebutton, this);
            AlertDialog alertDialogCreate = builder.create();
            C11829c.m70594l1(getActivity(), alertDialogCreate);
            return alertDialogCreate;
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.ui.activation.CheckPwdActivity$a */
    public class C4506a extends TimerTask {
        public C4506a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            C13981a.m83990w(NotifyConstants.ActivityName.CHECK_PWD_ACTIVITY, "timerTask run");
            if (CheckPwdActivity.this.f20699u) {
                CheckPwdActivity.this.setResult(0);
            } else {
                CheckPwdActivity.this.m27509G0(false, 3);
            }
            CheckPwdActivity.this.m27521P0();
            CheckPwdActivity.this.finish();
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.ui.activation.CheckPwdActivity$b */
    public class C4507b extends TimerTask {
        public C4507b() {
        }

        /* renamed from: c */
        public final /* synthetic */ void m27569c() {
            CheckPwdActivity checkPwdActivity = CheckPwdActivity.this;
            C11880m.m71337d(checkPwdActivity, checkPwdActivity.getString(R$string.invite_family_member_failed_net_disable));
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            C13981a.m83990w(NotifyConstants.ActivityName.CHECK_PWD_ACTIVITY, "queryCloudInfoTimer timerTask run");
            C0226l0.m1584d(new Runnable() { // from class: hg.i0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f49489a.m27569c();
                }
            });
            CheckPwdActivity.this.m27509G0(false, 3);
            CheckPwdActivity.this.m27521P0();
            CheckPwdActivity.this.finish();
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.ui.activation.CheckPwdActivity$c */
    public class C4508c implements InterfaceC13449b {

        /* renamed from: a */
        public final /* synthetic */ Consumer f20706a;

        public C4508c(Consumer consumer) {
            this.f20706a = consumer;
        }

        @Override // p709vj.InterfaceC13449b
        /* renamed from: L */
        public void mo13808L(Exception exc) {
            C13981a.m83989i(NotifyConstants.ActivityName.CHECK_PWD_ACTIVITY, "authFailed");
            this.f20706a.accept(Boolean.FALSE);
        }

        @Override // p709vj.InterfaceC13449b
        /* renamed from: Q */
        public boolean mo13814Q(Bundle bundle) {
            C13981a.m83989i(NotifyConstants.ActivityName.CHECK_PWD_ACTIVITY, "activatePhoneFinder");
            this.f20706a.accept(Boolean.FALSE);
            return false;
        }

        @Override // p709vj.InterfaceC13449b
        /* renamed from: W */
        public void mo13820W(Bundle bundle) {
            C13981a.m83989i(NotifyConstants.ActivityName.CHECK_PWD_ACTIVITY, "onLogin");
            if (bundle == null) {
                this.f20706a.accept(Boolean.FALSE);
                C13981a.m83988e(NotifyConstants.ActivityName.CHECK_PWD_ACTIVITY, "have the invalid account params");
                return;
            }
            String string = bundle.getString(JsbMapKeyNames.H5_USER_ID);
            if (TextUtils.isEmpty(string)) {
                C13981a.m83988e(NotifyConstants.ActivityName.CHECK_PWD_ACTIVITY, "have the account uid is empty");
                this.f20706a.accept(Boolean.FALSE);
                return;
            }
            String userId = CheckPwdActivity.this.f20702x.getUserId();
            if (!TextUtils.isEmpty(userId)) {
                this.f20706a.accept(Boolean.valueOf(string.equals(userId)));
            } else {
                C13981a.m83988e(NotifyConstants.ActivityName.CHECK_PWD_ACTIVITY, "phoneFinderUid is empty");
                this.f20706a.accept(Boolean.FALSE);
            }
        }

        @Override // p709vj.InterfaceC13449b
        /* renamed from: e */
        public void mo13829e(OperationCanceledException operationCanceledException) {
            C13981a.m83989i(NotifyConstants.ActivityName.CHECK_PWD_ACTIVITY, "authCanceled:" + operationCanceledException.getMessage());
            this.f20706a.accept(Boolean.FALSE);
        }

        @Override // p709vj.InterfaceC13449b
        /* renamed from: m0 */
        public void mo13838m0(Bundle bundle) {
            C13981a.m83989i(NotifyConstants.ActivityName.CHECK_PWD_ACTIVITY, "getUserInfoSuccess");
            this.f20706a.accept(Boolean.FALSE);
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.ui.activation.CheckPwdActivity$d */
    public class C4509d extends AbstractC9478g {
        public C4509d() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            String strM69788d = C11702i.m69788d();
            if (!TextUtils.isEmpty(strM69788d)) {
                strM69788d = strM69788d + "/CAS/mobile/standard/resetPwd/forgetbyid.html";
            }
            if (CheckPwdActivity.this.f20681c != null) {
                Message.obtain(CheckPwdActivity.this.f20681c, 5, strM69788d).sendToTarget();
            }
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.ui.activation.CheckPwdActivity$e */
    public static class C4510e extends BroadcastReceiver {

        /* renamed from: a */
        public final Handler f20709a;

        /* renamed from: b */
        public boolean f20710b = false;

        public C4510e(Handler handler) {
            this.f20709a = handler;
        }

        /* renamed from: a */
        public void m27570a(Context context) {
            if (this.f20710b) {
                return;
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.huawei.android.hicloud.intent.PHONEFINDER_DEVICE_DEL");
            intentFilter.addAction("com.huawei.android.hicloud.intent.PHONEFINDER_QUERY_ACTIVE_ERROR");
            C13108a.m78878b(context.getApplicationContext()).m78880c(this, intentFilter);
            this.f20710b = true;
        }

        /* renamed from: b */
        public void m27571b(Context context) {
            if (this.f20710b) {
                C13108a.m78878b(context.getApplicationContext()).m78883f(this);
                this.f20710b = false;
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(intent);
            String action = hiCloudSafeIntent.getAction();
            C13981a.m83987d(NotifyConstants.ActivityName.CHECK_PWD_ACTIVITY, "ActivationStatusReceiver action=" + action);
            if ("com.huawei.android.hicloud.intent.PHONEFINDER_DEVICE_DEL".equals(action)) {
                Handler handler = this.f20709a;
                if (handler != null) {
                    if (handler.hasMessages(4)) {
                        this.f20709a.removeMessages(4);
                    }
                    this.f20709a.sendEmptyMessage(4);
                    return;
                }
                return;
            }
            if ("com.huawei.android.hicloud.intent.PHONEFINDER_QUERY_ACTIVE_ERROR".equals(action)) {
                C13981a.m83989i(NotifyConstants.ActivityName.CHECK_PWD_ACTIVITY, "query failed");
                Handler handler2 = this.f20709a;
                if (handler2 != null) {
                    Message messageObtainMessage = handler2.obtainMessage(6);
                    messageObtainMessage.arg1 = hiCloudSafeIntent.getIntExtra(AddressConstants.Extras.EXTRA_NAME_ERR_CODE, -1);
                    this.f20709a.sendMessage(messageObtainMessage);
                }
            }
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.ui.activation.CheckPwdActivity$f */
    public static class C4511f implements CloudRequestHandler {

        /* renamed from: a */
        public final WeakReference<CheckPwdActivity> f20711a;

        public C4511f(CheckPwdActivity checkPwdActivity) {
            this.f20711a = new WeakReference<>(checkPwdActivity);
        }

        @Override // com.huawei.hms.support.hwid.common.cloudservice.CloudRequestHandler
        public void onError(ErrorStatus errorStatus) {
            String str;
            C13981a.m83988e(NotifyConstants.ActivityName.CHECK_PWD_ACTIVITY, "onError");
            CheckPwdActivity checkPwdActivity = this.f20711a.get();
            if (checkPwdActivity == null) {
                C13981a.m83988e(NotifyConstants.ActivityName.CHECK_PWD_ACTIVITY, "onError activity null, return");
                return;
            }
            if (errorStatus != null) {
                str = errorStatus.getErrorCode() + ",reason:" + errorStatus.getErrorReason();
            } else {
                str = "";
            }
            C13981a.m83988e(NotifyConstants.ActivityName.CHECK_PWD_ACTIVITY, "doCheckPassword onError: " + str);
            if (checkPwdActivity.f20681c != null) {
                checkPwdActivity.f20681c.removeMessages(3);
                Message.obtain(checkPwdActivity.f20681c, 2, errorStatus).sendToTarget();
            }
            new C12796a().m76771d(checkPwdActivity.getApplicationContext(), NotifyConstants.ActivityName.CHECK_PWD_ACTIVITY, null, "checkPasswordByUserId onError: " + str, null, "01012", null, "factoryCheckPassword", null);
        }

        @Override // com.huawei.hms.support.hwid.common.cloudservice.CloudRequestHandler
        public void onFinish(Bundle bundle) {
            C13981a.m83989i(NotifyConstants.ActivityName.CHECK_PWD_ACTIVITY, "onFinish");
            CheckPwdActivity checkPwdActivity = this.f20711a.get();
            if (checkPwdActivity == null) {
                C13981a.m83988e(NotifyConstants.ActivityName.CHECK_PWD_ACTIVITY, "onFinish activity null, return");
                return;
            }
            if (bundle == null) {
                C13981a.m83988e(NotifyConstants.ActivityName.CHECK_PWD_ACTIVITY, "onFinish bundle null, return");
                checkPwdActivity.m27548f0();
                checkPwdActivity.m27547e0();
                return;
            }
            C13981a.m83989i(NotifyConstants.ActivityName.CHECK_PWD_ACTIVITY, "doCheckPassword finish");
            if (checkPwdActivity.f20681c != null) {
                checkPwdActivity.f20681c.removeMessages(3);
                Message messageObtainMessage = checkPwdActivity.f20681c.obtainMessage(1);
                messageObtainMessage.setData(bundle);
                checkPwdActivity.f20681c.sendMessage(messageObtainMessage);
            }
            new C12796a().m76771d(checkPwdActivity.getApplicationContext(), NotifyConstants.ActivityName.CHECK_PWD_ACTIVITY, null, "checkPasswordByUserId onFinish", null, "01012", null, "factoryCheckPassword", null);
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.ui.activation.CheckPwdActivity$g */
    public class C4512g implements InterfaceC13451d {
        public C4512g() {
        }

        @Override // p709vj.InterfaceC13451d
        /* renamed from: a */
        public void mo17021a(ErrorStatus errorStatus) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            C13981a.m83988e(NotifyConstants.ActivityName.CHECK_PWD_ACTIVITY, "CloudAccount on error callback");
            if (errorStatus != null && !errorStatus.getErrorReason().isEmpty() && errorStatus.getErrorCode() != 3002) {
                C13981a.m83988e(NotifyConstants.ActivityName.CHECK_PWD_ACTIVITY, "CloudAccount on error reason: " + errorStatus.getErrorReason());
                C0226l0.m1584d(new Runnable() { // from class: hg.j0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f49491a.m27573d();
                    }
                });
            }
            CheckPwdActivity.this.m27509G0(false, 1);
            CheckPwdActivity.this.m27521P0();
            CheckPwdActivity.this.finish();
        }

        @Override // p709vj.InterfaceC13451d
        /* renamed from: b */
        public void mo17022b(String str) {
            C13981a.m83989i(NotifyConstants.ActivityName.CHECK_PWD_ACTIVITY, "CloudAccount on finish callback");
            CheckPwdActivity.this.m27534W(str);
        }

        /* renamed from: d */
        public final /* synthetic */ void m27573d() {
            C11880m.m71336c(CheckPwdActivity.this, R$string.phonefinder_remand_download_hms);
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.ui.activation.CheckPwdActivity$h */
    public class C4513h implements TextWatcher {
        public C4513h() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            if (CheckPwdActivity.this.f20683e != null && !TextUtils.isEmpty(CheckPwdActivity.this.f20683e.getError())) {
                CheckPwdActivity.this.f20683e.setError(null);
            }
            if (CheckPwdActivity.this.f20684f == null || CheckPwdActivity.this.f20686h == null) {
                return;
            }
            Editable text = CheckPwdActivity.this.f20684f.getText();
            if (text == null || TextUtils.isEmpty(text.toString())) {
                CheckPwdActivity.this.f20686h.setEnabled(false);
                CheckPwdActivity.this.f20686h.setTextColor(CheckPwdActivity.this.getColor(R$color.color_0A59F7_disable));
            } else {
                CheckPwdActivity.this.f20686h.setEnabled(true);
                CheckPwdActivity.this.f20686h.setTextColor(CheckPwdActivity.this.getColor(R$color.color_0A59F7));
            }
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.ui.activation.CheckPwdActivity$i */
    public static class HandlerC4514i extends Handler {

        /* renamed from: a */
        public final WeakReference<CheckPwdActivity> f20714a;

        public /* synthetic */ HandlerC4514i(CheckPwdActivity checkPwdActivity, C4506a c4506a) {
            this(checkPwdActivity);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            CheckPwdActivity checkPwdActivity = this.f20714a.get();
            if (checkPwdActivity == null || checkPwdActivity.isFinishing()) {
                C13981a.m83990w(NotifyConstants.ActivityName.CHECK_PWD_ACTIVITY, "activity null or isFinishing!");
                return;
            }
            C13981a.m83989i(NotifyConstants.ActivityName.CHECK_PWD_ACTIVITY, "handleMessage: " + message.what);
            int i10 = message.what;
            if (3105 == i10) {
                Object obj = message.obj;
                if (obj instanceof Boolean) {
                    checkPwdActivity.m27520P(((Boolean) obj).booleanValue());
                    return;
                }
                return;
            }
            if (1 == i10) {
                checkPwdActivity.m27511I0(new C10343b(message.getData()).m63694p(CommonConstant.KEY_ID_TOKEN));
                return;
            }
            if (2 == i10) {
                checkPwdActivity.m27510H0(message.obj);
                return;
            }
            if (3 == i10) {
                checkPwdActivity.m27510H0(new ErrorStatus(401, ""));
                return;
            }
            if (4 == i10) {
                checkPwdActivity.m27515M0();
                return;
            }
            if (5 == i10) {
                Object obj2 = message.obj;
                if (obj2 instanceof String) {
                    checkPwdActivity.m27546d0((String) obj2);
                    return;
                }
                return;
            }
            if (6 == i10) {
                C13981a.m83989i(NotifyConstants.ActivityName.CHECK_PWD_ACTIVITY, "query failed");
                checkPwdActivity.m27521P0();
                checkPwdActivity.m27509G0(false, 1);
                checkPwdActivity.m27533V0(message.arg1);
            }
        }

        public HandlerC4514i(CheckPwdActivity checkPwdActivity) {
            super(Looper.getMainLooper());
            this.f20714a = new WeakReference<>(checkPwdActivity);
        }
    }

    /* renamed from: k0 */
    public static boolean m27487k0() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean z10 = jCurrentTimeMillis - f20678y <= 600;
        f20678y = jCurrentTimeMillis;
        return z10;
    }

    /* renamed from: A0 */
    public final /* synthetic */ void m27503A0(DialogInterface dialogInterface, int i10) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        m27553l0();
        finish();
    }

    /* renamed from: B0 */
    public final /* synthetic */ void m27504B0(DialogInterface dialogInterface, int i10) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        finish();
    }

    /* renamed from: C0 */
    public final /* synthetic */ void m27505C0() {
        AlertDialog alertDialogCreate = new AlertDialog.Builder(this).setTitle(R$string.check_vt_fail).setMessage(R$string.close_finder_fail_dialog_content).setPositiveButton(R$string.close_finder_fail_dialog_remove_device, new DialogInterface.OnClickListener() { // from class: hg.g0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                this.f49486a.m27503A0(dialogInterface, i10);
            }
        }).setNegativeButton(R$string.dialog_cancel, new DialogInterface.OnClickListener() { // from class: hg.h0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                this.f49487a.m27504B0(dialogInterface, i10);
            }
        }).create();
        this.f20695q = alertDialogCreate;
        alertDialogCreate.show();
    }

    /* renamed from: D0 */
    public final /* synthetic */ void m27506D0(String str) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        C11880m.m71337d(this, str);
        finish();
    }

    /* renamed from: E0 */
    public final /* synthetic */ void m27507E0(String str) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        C11880m.m71337d(this, str);
        finish();
    }

    /* renamed from: F0 */
    public final /* synthetic */ void m27508F0(DialogInterface dialogInterface, int i10) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        C13981a.m83989i(NotifyConstants.ActivityName.CHECK_PWD_ACTIVITY, "send broadcast to setting");
        m27509G0(true, 0);
        finish();
    }

    /* renamed from: G0 */
    public final void m27509G0(boolean z10, int i10) {
        if (this.f20699u) {
            C13981a.m83989i(NotifyConstants.ActivityName.CHECK_PWD_ACTIVITY, "notify hms result:" + z10);
            setResult(z10 ? -1 : 0);
            return;
        }
        C13981a.m83989i(NotifyConstants.ActivityName.CHECK_PWD_ACTIVITY, "notify setting result:" + i10);
        m27525R0(i10);
    }

    /* renamed from: H0 */
    public final void m27510H0(Object obj) {
        C13981a.m83988e(NotifyConstants.ActivityName.CHECK_PWD_ACTIVITY, "onCheckPwdError");
        ErrorStatus errorStatus = obj instanceof ErrorStatus ? (ErrorStatus) obj : null;
        int errorCode = errorStatus == null ? -1 : errorStatus.getErrorCode();
        if (2016 == errorCode) {
            errorCode = errorStatus.getSubErrCode();
        }
        C13981a.m83989i(NotifyConstants.ActivityName.CHECK_PWD_ACTIVITY, "onCheckPwdError, errorCode:" + errorCode);
        String strM27542a0 = m27542a0(errorCode);
        if (!TextUtils.isEmpty(strM27542a0)) {
            C13981a.m83988e(NotifyConstants.ActivityName.CHECK_PWD_ACTIVITY, "onCheckPwdError: " + strM27542a0);
            HwErrorTipTextLayout hwErrorTipTextLayout = this.f20683e;
            if (hwErrorTipTextLayout != null) {
                hwErrorTipTextLayout.setError(strM27542a0);
            }
        }
        m27547e0();
    }

    /* renamed from: I0 */
    public final void m27511I0(String str) {
        C13981a.m83989i(NotifyConstants.ActivityName.CHECK_PWD_ACTIVITY, "onCheckPwdSuccess");
        m27548f0();
        m27547e0();
        m27534W(str);
    }

    /* renamed from: J0 */
    public final void m27512J0(DialogInterface dialogInterface) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (dialogInterface != null) {
            dialogInterface.dismiss();
        }
        finish();
    }

    /* renamed from: K0 */
    public final void m27513K0() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        HwEditText hwEditText = this.f20684f;
        if (hwEditText == null) {
            C13981a.m83988e(NotifyConstants.ActivityName.CHECK_PWD_ACTIVITY, "mEdtPassword null");
            return;
        }
        Editable text = hwEditText.getText();
        if (text == null) {
            C13981a.m83988e(NotifyConstants.ActivityName.CHECK_PWD_ACTIVITY, "editable is null");
            return;
        }
        String string = text.toString();
        if (TextUtils.isEmpty(string)) {
            C13981a.m83988e(NotifyConstants.ActivityName.CHECK_PWD_ACTIVITY, "password is empty");
        } else if (!C0209d.m1333z1(this)) {
            C0226l0.m1584d(new Runnable() { // from class: hg.y
                @Override // java.lang.Runnable
                public final void run() {
                    this.f49518a.m27557p0();
                }
            });
        } else {
            m27529T0();
            m27532V(string);
        }
    }

    /* renamed from: L0 */
    public final void m27514L0() {
        boolean zBooleanValue;
        HwCheckBox hwCheckBox = this.f20685g;
        if (hwCheckBox == null) {
            return;
        }
        try {
            zBooleanValue = ((Boolean) hwCheckBox.getTag()).booleanValue();
        } catch (Exception e10) {
            C13981a.m83990w(NotifyConstants.ActivityName.CHECK_PWD_ACTIVITY, "updatePasswordState" + e10.getMessage());
            zBooleanValue = false;
        }
        m27543a1(!zBooleanValue);
    }

    /* renamed from: M0 */
    public final void m27515M0() {
        C13981a.m83989i(NotifyConstants.ActivityName.CHECK_PWD_ACTIVITY, "onPhoneFinderDeviceDelete");
        m27548f0();
        m27547e0();
        m27521P0();
        m27535W0();
    }

    /* renamed from: N */
    public final void m27516N() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        C13981a.m83989i(NotifyConstants.ActivityName.CHECK_PWD_ACTIVITY, "checkClientLockVersion");
        m27539Y0();
        if (!C1175a.m7385g(false)) {
            JSONArray jSONArrayM7393o = C1175a.m7393o();
            if (jSONArrayM7393o == null) {
                if (!C1175a.m7389k(this)) {
                    m27509G0(true, 0);
                    finish();
                    return;
                }
            } else if (jSONArrayM7393o.length() == 0 || TextUtils.isEmpty(jSONArrayM7393o.toString())) {
                m27509G0(false, 1);
                m27533V0(SNSCode.Status.GET_USER_DATA_FAIL);
                return;
            }
        } else if (!C1175a.m7389k(this)) {
            m27509G0(true, 0);
            finish();
            return;
        } else if (!AbstractC12139d.m72768g(this)) {
            C13981a.m83990w(NotifyConstants.ActivityName.CHECK_PWD_ACTIVITY, "accountInfo not exist");
            m27523Q0("has authFlag, find is open, accountInfo not exist");
            C1175a.m7398t(false, this);
            m27509G0(true, 0);
            finish();
            return;
        }
        m27518O();
    }

    /* renamed from: N0 */
    public final void m27517N0(boolean z10) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        C13981a.m83989i(NotifyConstants.ActivityName.CHECK_PWD_ACTIVITY, "processNext");
        if (AbstractC12139d.m72766e(this) == null) {
            C13981a.m83988e(NotifyConstants.ActivityName.CHECK_PWD_ACTIVITY, "accountInfo null");
            m27523Q0("accountInfo null");
            finish();
        } else if (z10) {
            m27526S();
        } else {
            m27528T();
        }
    }

    /* renamed from: O */
    public final void m27518O() {
        C13981a.m83989i(NotifyConstants.ActivityName.CHECK_PWD_ACTIVITY, "checkClientTaKey");
        if (C11853c.m70968g().m70972h(this)) {
            m27522Q();
        } else {
            C12515a.m75110o().m75172d(new C9477f(this.f20681c));
        }
    }

    /* renamed from: O0 */
    public final void m27519O0() {
        C13981a.m83989i(NotifyConstants.ActivityName.CHECK_PWD_ACTIVITY, "registerQueryStatusReceiver");
        if (this.f20696r == null) {
            C4510e c4510e = new C4510e(this.f20681c);
            this.f20696r = c4510e;
            c4510e.m27570a(this);
        }
    }

    /* renamed from: P */
    public final void m27520P(boolean z10) {
        C13981a.m83989i(NotifyConstants.ActivityName.CHECK_PWD_ACTIVITY, "checkClientTaKeyResult: " + z10);
        if (z10) {
            AbstractC12139d.m72767f(C12347f.m74285n().m74301m(), true);
        }
        m27522Q();
    }

    /* renamed from: P0 */
    public final void m27521P0() {
        ProgressDialog progressDialog = this.f20691m;
        if (progressDialog != null) {
            progressDialog.dismiss();
            this.f20691m = null;
        }
        Timer timer = this.f20692n;
        if (timer != null) {
            timer.cancel();
            this.f20692n = null;
        }
        Timer timer2 = this.f20693o;
        if (timer2 != null) {
            timer2.cancel();
            this.f20693o = null;
        }
        if (this.f20682d != null) {
            C13108a.m78878b(this).m78883f(this.f20682d);
        }
        m27551i0();
    }

    /* renamed from: Q */
    public final void m27522Q() {
        C11860j.m70994F0(true, AbstractC12139d.m72766e(this));
        m27519O0();
        this.f20693o = new Timer();
        this.f20693o.schedule(new C4507b(), 15000L);
        C11866p.m71108g(new C4349g(this, 3108, new Consumer() { // from class: hg.o
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f49503a.m27555n0((QueryActiveInfo) obj);
            }
        }));
    }

    /* renamed from: Q0 */
    public final void m27523Q0(String str) {
        C12796a c12796a = new C12796a();
        String str2 = this.f20699u ? "hwIdCheckPassword" : "factoryCheckPassword";
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("create_time", String.valueOf(this.f20697s));
        c12796a.m76771d(this.f20680b, NotifyConstants.ActivityName.CHECK_PWD_ACTIVITY, "0", str, null, "01012", null, str2, linkedHashMap);
    }

    /* renamed from: R */
    public final void m27524R(Activity activity) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (!C0209d.m1166E1()) {
            C13981a.m83989i(NotifyConstants.ActivityName.CHECK_PWD_ACTIVITY, "not user owner");
            m27523Q0("not user owner");
            setResult(-1);
            activity.finish();
            return;
        }
        if (C0209d.m1333z1(activity)) {
            m27516N();
            return;
        }
        C13981a.m83989i(NotifyConstants.ActivityName.CHECK_PWD_ACTIVITY, "checkHwId network disconnected");
        C11829c.m70612r1(activity);
        setResult(0);
        activity.finish();
    }

    /* renamed from: R0 */
    public final void m27525R0(int i10) {
        C13981a.m83989i(NotifyConstants.ActivityName.CHECK_PWD_ACTIVITY, "send BroadcastToSetting result is " + i10);
        Intent intent = new Intent("com.huawei.remotecontrol.intent.action.CLOSE_PHONEFINDERRESULT");
        intent.putExtra("result", i10);
        this.f20680b.sendBroadcast(intent, "com.huawei.remotocontrol.permission.REMOTECALL");
    }

    /* renamed from: S */
    public final void m27526S() {
        C13981a.m83989i(NotifyConstants.ActivityName.CHECK_PWD_ACTIVITY, "checkHwIdPassword");
        m27552j0();
        if (this.f20699u && !TextUtils.isEmpty(this.f20700v)) {
            C13981a.m83989i(NotifyConstants.ActivityName.CHECK_PWD_ACTIVITY, "vt not empty");
            m27534W(this.f20700v);
            return;
        }
        boolean z10 = !TextUtils.isEmpty(this.f20702x.getParentUid());
        C13195l.m79272J().m79326p(this, 8908, z10, this.f20701w, this.f20679a);
        m27523Q0("checkPasswordBySys,isChild:" + z10);
    }

    /* renamed from: S0 */
    public final void m27527S0(boolean z10) {
        AlertDialog alertDialog = this.f20689k;
        if (alertDialog != null) {
            C11703j.m69826v(alertDialog.getWindow(), z10);
        }
    }

    /* renamed from: T */
    public final void m27528T() {
        C13981a.m83989i(NotifyConstants.ActivityName.CHECK_PWD_ACTIVITY, "checkPasswordByUserId");
        m27552j0();
        m27531U0();
    }

    /* renamed from: T0 */
    public final void m27529T0() {
        ProgressDialog progressDialog = new ProgressDialog(this);
        this.f20690l = progressDialog;
        progressDialog.setMessage(getString(R$string.hwid_check_password_loading));
        this.f20690l.show();
    }

    /* renamed from: U */
    public final void m27530U(Consumer<Boolean> consumer) {
        C13195l.m79272J().m79337u0(new C4508c(consumer), false);
    }

    /* renamed from: U0 */
    public final void m27531U0() {
        View viewInflate = LayoutInflater.from(this).inflate(R$layout.dialog_check_pwd_reset_device, (ViewGroup) null, false);
        HwTextView hwTextView = (HwTextView) C12809f.m76831d(viewInflate, R$id.tv_account_info);
        this.f20683e = (HwErrorTipTextLayout) C12809f.m76831d(viewInflate, R$id.password_layout);
        this.f20684f = (HwEditText) C12809f.m76831d(viewInflate, R$id.edt_activation_password);
        this.f20685g = (HwCheckBox) C12809f.m76831d(viewInflate, R$id.iv_activation_password_eye);
        HwTextView hwTextView2 = (HwTextView) C12809f.m76831d(viewInflate, R$id.tv_forgot_password);
        boolean z10 = !TextUtils.isEmpty(this.f20702x.getParentAccountName());
        if (hwTextView != null) {
            QueryActiveInfo queryActiveInfo = this.f20702x;
            hwTextView.setText(getString(z10 ? R$string.child_hwid_input_password_to_logout : R$string.hwid_input_password_to_logout, m27536X(z10 ? queryActiveInfo.getParentAccountName() : queryActiveInfo.getAccountName())));
        }
        HwErrorTipTextLayout hwErrorTipTextLayout = this.f20683e;
        if (hwErrorTipTextLayout != null) {
            hwErrorTipTextLayout.setError(null);
        }
        HwEditText hwEditText = this.f20684f;
        if (hwEditText != null) {
            hwEditText.addTextChangedListener(new C4513h());
            this.f20684f.setCustomSelectionActionModeCallback(new ActionModeCallbackC10499d());
        }
        m27543a1(false);
        HwCheckBox hwCheckBox = this.f20685g;
        if (hwCheckBox != null) {
            hwCheckBox.setOnClickListener(new View.OnClickListener() { // from class: hg.s
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f49511a.m27558q0(view);
                }
            });
        }
        if (hwTextView2 != null) {
            hwTextView2.setOnClickListener(new View.OnClickListener() { // from class: hg.t
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f49512a.m27559r0(view);
                }
            });
        }
        AlertDialog alertDialogCreate = new AlertDialog.Builder(this).setTitle(z10 ? R$string.child_hwid_input_password : R$string.hwid_input_password).setView(viewInflate).setPositiveButton(R$string.conform, (DialogInterface.OnClickListener) null).setNegativeButton(R$string.cs_cancel, (DialogInterface.OnClickListener) null).setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: hg.u
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
                return this.f49513a.m27560s0(dialogInterface, i10, keyEvent);
            }
        }).create();
        this.f20689k = alertDialogCreate;
        alertDialogCreate.setOnShowListener(new DialogInterface.OnShowListener() { // from class: hg.v
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                this.f49514a.m27563v0(dialogInterface);
            }
        });
        this.f20689k.setCanceledOnTouchOutside(false);
        this.f20689k.show();
        m27527S0(true);
    }

    /* renamed from: V */
    public final void m27532V(String str) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        C13981a.m83989i(NotifyConstants.ActivityName.CHECK_PWD_ACTIVITY, "doCheckPassword by hms sdk");
        AccountInfo accountInfoM72766e = AbstractC12139d.m72766e(this);
        if (accountInfoM72766e == null && this.f20702x == null) {
            C13981a.m83988e(NotifyConstants.ActivityName.CHECK_PWD_ACTIVITY, "accountInfo null");
            new C12796a().m76771d(this.f20680b, NotifyConstants.ActivityName.CHECK_PWD_ACTIVITY, null, "accountInfo null", null, "01012", null, "factoryCheckPassword", null);
            m27548f0();
            m27547e0();
            finish();
            return;
        }
        HttpClientGlobalInstance.getInstance().init(this);
        String packageName = getPackageName();
        String userId = this.f20702x.getUserId();
        String deviceId = this.f20702x.getDeviceId();
        String deviceType = this.f20702x.getDeviceType();
        String parentUid = this.f20702x.getParentUid();
        String siteId = this.f20702x.getSiteId();
        HuaweiIdAdvancedManager.getService(this).checkPasswordByUserId(this, new CheckPasswordByUserIdReq(packageName, userId, str, "", (TextUtils.isEmpty(siteId) || "-1".equals(siteId)) ? accountInfoM72766e != null ? C0241z.m1685c(accountInfoM72766e.getSiteID()) : 0 : C0241z.m1685c(siteId), "10055832", parentUid, deviceId, "", deviceType), new C4511f(this));
        HandlerC4514i handlerC4514i = this.f20681c;
        if (handlerC4514i != null) {
            handlerC4514i.sendEmptyMessageDelayed(3, 38000L);
        }
        m27523Q0("checkPasswordByUserId");
    }

    /* renamed from: V0 */
    public final void m27533V0(int i10) {
        if (i10 == -100) {
            final String string = getString(R$string.activate_error_cannot_conn_server);
            C0226l0.m1584d(new Runnable() { // from class: hg.e0
                @Override // java.lang.Runnable
                public final void run() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                    this.f49480a.m27506D0(string);
                }
            });
        }
        if (i10 == 3005) {
            C0226l0.m1584d(new Runnable() { // from class: hg.a0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f49471a.m27565x0();
                }
            });
            return;
        }
        switch (i10) {
            case 3202:
                C0226l0.m1584d(new Runnable() { // from class: hg.b0
                    @Override // java.lang.Runnable
                    public final void run() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                        this.f49473a.m27566y0();
                    }
                });
                break;
            case 3203:
                C0226l0.m1584d(new Runnable() { // from class: hg.c0
                    @Override // java.lang.Runnable
                    public final void run() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                        this.f49475a.m27567z0();
                    }
                });
                break;
            case 3204:
                C0226l0.m1584d(new Runnable() { // from class: hg.d0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f49477a.m27505C0();
                    }
                });
                break;
            default:
                final String str = getString(R$string.account_logout_fail) + " (" + i10 + ")";
                C0226l0.m1584d(new Runnable() { // from class: hg.f0
                    @Override // java.lang.Runnable
                    public final void run() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                        this.f49483a.m27507E0(str);
                    }
                });
                break;
        }
    }

    /* renamed from: W */
    public final void m27534W(String str) {
        ProgressDialog progressDialog = new ProgressDialog(this.f20680b);
        this.f20691m = progressDialog;
        progressDialog.setMessage(this.f20680b.getResources().getString(R$string.phonefinder_off_tips));
        this.f20691m.setCancelable(false);
        this.f20691m.show();
        C11860j.m71037a1(this.f20699u ? 3 : 5);
        C11860j.m71030X0(this.f20699u ? 3 : 5);
        C11860j.m71018R0(this.f20680b, true, str);
        this.f20692n = new Timer();
        this.f20692n.schedule(new C4506a(), 38000L);
    }

    /* renamed from: W0 */
    public final void m27535W0() {
        AlertDialog alertDialogCreate = new AlertDialog.Builder(this).setCancelable(false).setMessage(R$string.findmyphone_phonefinder_device_deleted_tips).setPositiveButton(R$string.beta_ok, new DialogInterface.OnClickListener() { // from class: hg.z
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                this.f49519a.m27508F0(dialogInterface, i10);
            }
        }).create();
        this.f20694p = alertDialogCreate;
        alertDialogCreate.show();
    }

    /* renamed from: X */
    public final String m27536X(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.contains("*")) {
            return str;
        }
        C13981a.m83989i(NotifyConstants.ActivityName.CHECK_PWD_ACTIVITY, "accountName is not mask");
        return C11871d.m71159b(str);
    }

    /* renamed from: X0 */
    public final void m27537X0() {
        ResetConfirmDialog resetConfirmDialog;
        try {
            resetConfirmDialog = (ResetConfirmDialog) getFragmentManager().findFragmentByTag("confirm");
        } catch (ClassCastException e10) {
            C13981a.m83989i(NotifyConstants.ActivityName.CHECK_PWD_ACTIVITY, "showDialog error:" + e10.getMessage());
            resetConfirmDialog = null;
        }
        if (resetConfirmDialog == null) {
            new ResetConfirmDialog().show(getFragmentManager(), "confirm");
        }
    }

    /* renamed from: Y */
    public final String m27538Y(int i10) {
        int iM27248S0 = ActivationBaseActivity.m27248S0(i10);
        if (iM27248S0 > 0) {
            return getString(iM27248S0);
        }
        return null;
    }

    /* renamed from: Y0 */
    public final void m27539Y0() {
        ProgressDialog progressDialog = new ProgressDialog(this);
        this.f20688j = progressDialog;
        progressDialog.setMessage(getString(R$string.getting_file));
        this.f20688j.setCancelable(false);
        this.f20688j.show();
    }

    /* renamed from: Z */
    public final String m27540Z(int i10, int i11) {
        int iM27248S0 = ActivationBaseActivity.m27248S0(i10);
        if (iM27248S0 <= 0) {
            return null;
        }
        return getResources().getString(iM27248S0) + "(" + i11 + ")";
    }

    /* renamed from: Z0 */
    public final void m27541Z0() {
        C13981a.m83989i(NotifyConstants.ActivityName.CHECK_PWD_ACTIVITY, "unregisterQueryStatusReceiver");
        C4510e c4510e = this.f20696r;
        if (c4510e != null) {
            c4510e.m27571b(this);
            this.f20696r = null;
        }
    }

    /* renamed from: a0 */
    public final String m27542a0(int i10) {
        if (i10 != 1 && i10 != 2 && i10 != 3 && i10 != 37 && i10 != 401) {
            if (i10 == 2003) {
                return m27538Y(2);
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
                            return m27538Y(1);
                        default:
                            return m27540Z(3, i10);
                    }
                }
            }
        }
        return m27540Z(402, i10);
    }

    /* renamed from: a1 */
    public final void m27543a1(boolean z10) {
        HwEditText hwEditText = this.f20684f;
        if (hwEditText != null) {
            if (z10) {
                hwEditText.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            } else {
                hwEditText.setTransformationMethod(new C10500e());
            }
            try {
                HwEditText hwEditText2 = this.f20684f;
                hwEditText2.setSelection(hwEditText2.getText().toString().length());
            } catch (Exception e10) {
                C13981a.m83988e(NotifyConstants.ActivityName.CHECK_PWD_ACTIVITY, "updatePasswordState" + e10.getMessage());
            }
        }
        if (this.f20685g != null) {
            if (C0209d.m1281m1()) {
                this.f20685g.setButtonDrawable(R$drawable.pf_box_pwd_eye_honor);
            } else {
                this.f20685g.setButtonDrawable(R$drawable.pf_box_pwd_eye);
            }
            this.f20685g.setTag(Boolean.valueOf(z10));
        }
    }

    /* renamed from: b0 */
    public final void m27544b0() {
        C12515a.m75110o().m75172d(new C4509d());
    }

    /* renamed from: c0 */
    public final void m27545c0() {
        C13195l.m79272J().m79342x(this, 1000005, false, 0, "", 1);
        new C12796a().m76771d(this.f20680b, NotifyConstants.ActivityName.CHECK_PWD_ACTIVITY, null, "click ForgotPassword", null, "01012", null, "factoryCheckPassword", null);
    }

    /* renamed from: d0 */
    public final void m27546d0(String str) {
        try {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
            intent.setData(Uri.parse(str));
            startActivity(intent);
            new C12796a().m76771d(this.f20680b, NotifyConstants.ActivityName.CHECK_PWD_ACTIVITY, null, "jumpBrowser ForgotPassword", null, "01012", null, "factoryCheckPassword", null);
        } catch (Exception e10) {
            C13981a.m83988e(NotifyConstants.ActivityName.CHECK_PWD_ACTIVITY, "jumpBrowser exception" + e10.toString());
            new C12796a().m76771d(this.f20680b, NotifyConstants.ActivityName.CHECK_PWD_ACTIVITY, null, "jumpBrowser ForgotPassword exception", null, "01012", null, "factoryCheckPassword", null);
        }
    }

    /* renamed from: e0 */
    public final void m27547e0() {
        ProgressDialog progressDialog = this.f20690l;
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }

    /* renamed from: f0 */
    public final void m27548f0() {
        AlertDialog alertDialog = this.f20689k;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    @Override // android.app.Activity
    public void finish() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        super.finish();
        new HwAnimationReflection(this.f20680b).m15927c(0);
    }

    /* renamed from: g0 */
    public final void m27549g0() {
        AlertDialog alertDialog = this.f20695q;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    /* renamed from: h0 */
    public final void m27550h0() {
        AlertDialog alertDialog = this.f20694p;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    /* renamed from: i0 */
    public final void m27551i0() {
        ProgressDialog progressDialog = this.f20688j;
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }

    /* renamed from: j0 */
    public final void m27552j0() {
        if (this.f20682d == null) {
            this.f20682d = new HiSyncReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.huawei.android.hicloud.intent.PHONEFINDER_OPEN_AUTH_FAILE");
            intentFilter.addAction("com.huawei.android.hicloud.intent.PHONEFINDER_CLOSE_AUTH_FAILE");
            intentFilter.addAction("com.huawei.android.hicloud.intent.PHONEFINDER_LOGOFF_DEREGISTRATION_COMPLETED");
            intentFilter.addAction("com.huawei.android.hicloud.intent.PHONEFINDER_LOGOFF_DEREGISTRATION_FAIL");
            C13108a.m78878b(this).m78880c(this.f20682d, intentFilter);
        }
    }

    /* renamed from: l0 */
    public final void m27553l0() {
        HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(new Intent());
        C0209d.m1302r2(hiCloudSafeIntent, "com.huawei.android.findmyphone");
        hiCloudSafeIntent.setAction("android.intent.action.MAIN");
        hiCloudSafeIntent.setFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
        if (hiCloudSafeIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(hiCloudSafeIntent);
        } else {
            C13981a.m83988e(NotifyConstants.ActivityName.CHECK_PWD_ACTIVITY, "phoneFinder not installed");
            C0226l0.m1584d(new Runnable() { // from class: hg.r
                @Override // java.lang.Runnable
                public final void run() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                    this.f49509a.m27556o0();
                }
            });
        }
    }

    /* renamed from: m0 */
    public final /* synthetic */ void m27554m0(Boolean bool) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        C13981a.m83989i(NotifyConstants.ActivityName.CHECK_PWD_ACTIVITY, "checkSystemAccountInfo: " + bool);
        this.f20698t = bool.booleanValue();
        m27551i0();
        m27517N0(bool.booleanValue());
    }

    /* renamed from: n0 */
    public final /* synthetic */ void m27555n0(QueryActiveInfo queryActiveInfo) {
        this.f20693o.cancel();
        this.f20702x = queryActiveInfo;
        if (!TextUtils.isEmpty(queryActiveInfo.getUserId())) {
            m27530U(new Consumer() { // from class: hg.q
                @Override // java.util.function.Consumer
                public final void accept(Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                    this.f49507a.m27554m0((Boolean) obj);
                }
            });
            return;
        }
        C13981a.m83988e(NotifyConstants.ActivityName.CHECK_PWD_ACTIVITY, "queryActiveInfo uid is empty");
        m27509G0(false, 1);
        m27533V0(41);
        m27523Q0("activeInfo UserId is empty");
    }

    /* renamed from: o0 */
    public final /* synthetic */ void m27556o0() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        C11880m.m71336c(this, R$string.remand_download_slave);
        finish();
    }

    @Override // android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (i10 == 8908) {
            C13195l.m79272J().m79298N(this, this.f20679a, i11, intent);
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        super.onCreate(bundle);
        this.f20680b = this;
        this.f20681c = new HandlerC4514i(this, null);
        f20678y = 0L;
        this.f20697s = System.currentTimeMillis();
        HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(getIntent());
        String strM29113i = hiCloudSafeIntent.m29113i(RemoteMessageConst.FROM, "");
        if ("com.huawei.hwid".equals(strM29113i)) {
            C13981a.m83989i(NotifyConstants.ActivityName.CHECK_PWD_ACTIVITY, "callFrom hwId");
            this.f20700v = hiCloudSafeIntent.m29113i("verifyToken", "");
            this.f20701w = hiCloudSafeIntent.m29113i("VERIFY_SCENE", "");
            m27524R(this);
        } else {
            this.f20699u = false;
            C13981a.m83989i(NotifyConstants.ActivityName.CHECK_PWD_ACTIVITY, "callFrom:" + strM29113i);
            m27537X0();
        }
        m27523Q0("start CheckPwdActivity, callFrom:" + strM29113i);
        C12808e.m76824c(this);
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        C13981a.m83987d(NotifyConstants.ActivityName.CHECK_PWD_ACTIVITY, "onDestroy");
        m27541Z0();
        m27550h0();
        m27549g0();
        m27551i0();
        m27548f0();
        m27547e0();
        m27521P0();
        C11860j.m70994F0(false, AbstractC12139d.m72766e(this));
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        C13981a.m83987d(NotifyConstants.ActivityName.CHECK_PWD_ACTIVITY, "onStart");
        m27527S0(true);
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        C13981a.m83987d(NotifyConstants.ActivityName.CHECK_PWD_ACTIVITY, "onStop");
        m27527S0(false);
    }

    /* renamed from: p0 */
    public final /* synthetic */ void m27557p0() {
        C11880m.m71337d(this, getString(R$string.net_err_tip_no_net));
    }

    /* renamed from: q0 */
    public final /* synthetic */ void m27558q0(View view) {
        C13981a.m83989i(NotifyConstants.ActivityName.CHECK_PWD_ACTIVITY, "onPasswordSEyeClick");
        m27514L0();
    }

    /* renamed from: r0 */
    public final /* synthetic */ void m27559r0(View view) {
        C13981a.m83989i(NotifyConstants.ActivityName.CHECK_PWD_ACTIVITY, "goToForgotPassword");
        if (this.f20698t) {
            m27545c0();
        } else {
            m27544b0();
        }
    }

    /* renamed from: s0 */
    public final /* synthetic */ boolean m27560s0(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        AlertDialog alertDialog;
        if (i10 != 4 || (alertDialog = this.f20689k) == null) {
            return false;
        }
        alertDialog.dismiss();
        finish();
        return false;
    }

    /* renamed from: t0 */
    public final /* synthetic */ void m27561t0(View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        C13981a.m83989i(NotifyConstants.ActivityName.CHECK_PWD_ACTIVITY, "click check password");
        m27513K0();
    }

    /* renamed from: u0 */
    public final /* synthetic */ void m27562u0(DialogInterface dialogInterface, View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        C13981a.m83989i(NotifyConstants.ActivityName.CHECK_PWD_ACTIVITY, "click cancel check password");
        m27512J0(dialogInterface);
    }

    /* renamed from: v0 */
    public final /* synthetic */ void m27563v0(final DialogInterface dialogInterface) {
        Button button = this.f20689k.getButton(-1);
        this.f20686h = button;
        if (button != null) {
            button.setEnabled(false);
            this.f20686h.setTextColor(getColor(R$color.color_0A59F7_disable));
            this.f20686h.setOnClickListener(new View.OnClickListener() { // from class: hg.w
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                    this.f49515a.m27561t0(view);
                }
            });
        }
        Button button2 = this.f20689k.getButton(-2);
        this.f20687i = button2;
        if (button2 != null) {
            button2.setTextColor(getColor(R$color.color_0A59F7));
            this.f20687i.setOnClickListener(new View.OnClickListener() { // from class: hg.x
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                    this.f49516a.m27562u0(dialogInterface, view);
                }
            });
        }
    }

    /* renamed from: w0 */
    public final /* synthetic */ void m27564w0(DialogInterface dialogInterface, int i10) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        finish();
    }

    /* renamed from: x0 */
    public final /* synthetic */ void m27565x0() {
        AlertDialog alertDialogCreate = new AlertDialog.Builder(this).setTitle(R$string.check_vt_fail).setMessage(R$string.pf_activation_tip_assistance_dialog).setPositiveButton(R$string.beta_ok, new DialogInterface.OnClickListener() { // from class: hg.p
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                this.f49505a.m27564w0(dialogInterface, i10);
            }
        }).create();
        this.f20695q = alertDialogCreate;
        alertDialogCreate.show();
    }

    /* renamed from: y0 */
    public final /* synthetic */ void m27566y0() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        C11880m.m71337d(this, getResources().getString(R$string.activate_error_too_many_times_please_24_retry, 10, 24));
        finish();
    }

    /* renamed from: z0 */
    public final /* synthetic */ void m27567z0() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        C11880m.m71336c(this, R$string.check_account_vt_fail);
        finish();
    }
}
