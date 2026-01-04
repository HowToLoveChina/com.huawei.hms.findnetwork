package com.huawei.hms.push;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.encrypt.PushEncrypter;
import com.huawei.hms.aaid.init.AutoInitHelper;
import com.huawei.hms.aaid.plugin.ProxyCenter;
import com.huawei.hms.aaid.task.PushClientBuilder;
import com.huawei.hms.aaid.utils.BaseUtils;
import com.huawei.hms.aaid.utils.PushPreferences;
import com.huawei.hms.android.HwBuildEx;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.push.task.BaseVoidTask;
import com.huawei.hms.push.task.IntentCallable;
import com.huawei.hms.push.task.SendUpStreamTask;
import com.huawei.hms.push.task.SubscribeTask;
import com.huawei.hms.push.utils.PushBiUtil;
import com.huawei.hms.support.api.entity.push.EnableNotifyReq;
import com.huawei.hms.support.api.entity.push.PushNaming;
import com.huawei.hms.support.api.entity.push.SubscribeReq;
import com.huawei.hms.support.api.entity.push.UpSendMsgReq;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
import com.huawei.hms.utils.NetWorkUtil;
import com.huawei.openalliance.p169ad.constant.OsType;
import com.huawei.openalliance.p169ad.p171db.bean.SdkCfgSha256Record;
import java.util.regex.Pattern;
import p208cq.C8941i;
import p208cq.C8943k;

/* loaded from: classes8.dex */
public class HmsMessaging {
    public static final String DEFAULT_TOKEN_SCOPE = "HCM";

    /* renamed from: c */
    private static final Pattern f29611c = Pattern.compile("[\\u4e00-\\u9fa5\\w-_.~%]{1,900}");

    /* renamed from: a */
    private Context f29612a;

    /* renamed from: b */
    private HuaweiApi<Api.ApiOptions.NoOptions> f29613b;

    private HmsMessaging(Context context) {
        Preconditions.checkNotNull(context);
        this.f29612a = context;
        Api api = new Api(HuaweiApiAvailability.HMS_API_NAME_PUSH);
        if (context instanceof Activity) {
            this.f29613b = new HuaweiApi<>((Activity) context, (Api<Api.ApiOptions>) api, (Api.ApiOptions) null, (AbstractClientBuilder) new PushClientBuilder());
        } else {
            this.f29613b = new HuaweiApi<>(context, (Api<Api.ApiOptions>) api, (Api.ApiOptions) null, new PushClientBuilder());
        }
        this.f29613b.setKitSdkVersion(61300300);
    }

    /* renamed from: a */
    private Task<Void> m36483a(String str, String str2) throws ApiException {
        String strReportEntry = PushBiUtil.reportEntry(this.f29612a, PushNaming.SUBSCRIBE);
        if (str == null || !f29611c.matcher(str).matches()) {
            PushBiUtil.reportExit(this.f29612a, PushNaming.SUBSCRIBE, strReportEntry, ErrorEnum.ERROR_ARGUMENTS_INVALID);
            HMSLog.m36986e("HmsMessaging", "Invalid topic: topic should match the format:[\\u4e00-\\u9fa5\\w-_.~%]{1,900}");
            throw new IllegalArgumentException("Invalid topic: topic should match the format:[\\u4e00-\\u9fa5\\w-_.~%]{1,900}");
        }
        if (ProxyCenter.getProxy() != null) {
            HMSLog.m36988i("HmsMessaging", "use proxy subscribe.");
            return TextUtils.equals(str2, "Sub") ? ProxyCenter.getProxy().subscribe(this.f29612a, str, strReportEntry) : ProxyCenter.getProxy().unsubscribe(this.f29612a, str, strReportEntry);
        }
        try {
            ErrorEnum errorEnumM36619a = C6306v.m36619a(this.f29612a);
            if (errorEnumM36619a != ErrorEnum.SUCCESS) {
                throw errorEnumM36619a.toApiException();
            }
            if (NetWorkUtil.getNetworkType(this.f29612a) == 0) {
                HMSLog.m36986e("HmsMessaging", "no network");
                throw ErrorEnum.ERROR_NO_NETWORK.toApiException();
            }
            SubscribeReq subscribeReq = new SubscribeReq(this.f29612a, str2, str);
            subscribeReq.setToken(BaseUtils.getLocalToken(this.f29612a, null));
            return AbstractC6285d.m36512b() ? this.f29613b.doWrite(new BaseVoidTask(PushNaming.SUBSCRIBE, JsonUtil.createJsonString(subscribeReq), strReportEntry)) : this.f29613b.doWrite(new SubscribeTask(PushNaming.SUBSCRIBE, JsonUtil.createJsonString(subscribeReq), strReportEntry));
        } catch (ApiException e10) {
            C8941i c8941i = new C8941i();
            c8941i.m56657c(e10);
            PushBiUtil.reportExit(this.f29612a, PushNaming.SUBSCRIBE, strReportEntry, e10.getStatusCode());
            return c8941i.m56656b();
        } catch (Exception unused) {
            C8941i c8941i2 = new C8941i();
            ErrorEnum errorEnum = ErrorEnum.ERROR_INTERNAL_ERROR;
            c8941i2.m56657c(errorEnum.toApiException());
            PushBiUtil.reportExit(this.f29612a, PushNaming.SUBSCRIBE, strReportEntry, errorEnum);
            return c8941i2.m56656b();
        }
    }

    public static synchronized HmsMessaging getInstance(Context context) {
        return new HmsMessaging(context);
    }

    public boolean isAutoInitEnabled() {
        return AutoInitHelper.isAutoInitEnabled(this.f29612a);
    }

    public void send(RemoteMessage remoteMessage) {
        if (ProxyCenter.getProxy() != null) {
            HMSLog.m36986e("HmsMessaging", "Operation(send) unsupported");
            throw new UnsupportedOperationException("Operation(send) unsupported");
        }
        HMSLog.m36988i("HmsMessaging", "send upstream message");
        m36485a(remoteMessage);
    }

    public void setAutoInitEnabled(boolean z10) {
        AutoInitHelper.setAutoInitEnabled(this.f29612a, z10);
    }

    public Task<Void> subscribe(String str) {
        HMSLog.m36988i("HmsMessaging", "invoke subscribe");
        return m36483a(str, "Sub");
    }

    public Task<Void> turnOffPush() {
        if (ProxyCenter.getProxy() != null) {
            HMSLog.m36988i("HmsMessaging", "turn off for proxy");
            return ProxyCenter.getProxy().turnOff(this.f29612a, null);
        }
        HMSLog.m36988i("HmsMessaging", "invoke turnOffPush");
        return m36484a(false);
    }

    public Task<Void> turnOnPush() {
        if (ProxyCenter.getProxy() != null) {
            HMSLog.m36988i("HmsMessaging", "turn on for proxy");
            return ProxyCenter.getProxy().turnOn(this.f29612a, null);
        }
        HMSLog.m36988i("HmsMessaging", "invoke turnOnPush");
        return m36484a(true);
    }

    public Task<Void> unsubscribe(String str) {
        HMSLog.m36988i("HmsMessaging", "invoke unsubscribe");
        return m36483a(str, "UnSub");
    }

    /* renamed from: a */
    private void m36485a(RemoteMessage remoteMessage) {
        String strReportEntry = PushBiUtil.reportEntry(this.f29612a, PushNaming.UPSEND_MSG);
        ErrorEnum errorEnumM36619a = C6306v.m36619a(this.f29612a);
        if (errorEnumM36619a == ErrorEnum.SUCCESS) {
            if (!TextUtils.isEmpty(remoteMessage.getTo())) {
                if (!TextUtils.isEmpty(remoteMessage.getMessageId())) {
                    if (!TextUtils.isEmpty(remoteMessage.getData())) {
                        UpSendMsgReq upSendMsgReq = new UpSendMsgReq();
                        upSendMsgReq.setPackageName(this.f29612a.getPackageName());
                        upSendMsgReq.setMessageId(remoteMessage.getMessageId());
                        upSendMsgReq.setTo(remoteMessage.getTo());
                        upSendMsgReq.setData(remoteMessage.getData());
                        upSendMsgReq.setMessageType(remoteMessage.getMessageType());
                        upSendMsgReq.setTtl(remoteMessage.getTtl());
                        upSendMsgReq.setCollapseKey(remoteMessage.getCollapseKey());
                        upSendMsgReq.setSendMode(remoteMessage.getSendMode());
                        upSendMsgReq.setReceiptMode(remoteMessage.getReceiptMode());
                        if (AbstractC6285d.m36512b()) {
                            this.f29613b.doWrite(new BaseVoidTask(PushNaming.UPSEND_MSG, JsonUtil.createJsonString(upSendMsgReq), strReportEntry));
                            return;
                        } else {
                            m36486a(upSendMsgReq, strReportEntry);
                            return;
                        }
                    }
                    HMSLog.m36986e("HmsMessaging", "Mandatory parameter 'data' missing");
                    PushBiUtil.reportExit(this.f29612a, PushNaming.UPSEND_MSG, strReportEntry, ErrorEnum.ERROR_ARGUMENTS_INVALID);
                    throw new IllegalArgumentException("Mandatory parameter 'data' missing");
                }
                HMSLog.m36986e("HmsMessaging", "Mandatory parameter 'message_id' missing");
                PushBiUtil.reportExit(this.f29612a, PushNaming.UPSEND_MSG, strReportEntry, ErrorEnum.ERROR_ARGUMENTS_INVALID);
                throw new IllegalArgumentException("Mandatory parameter 'message_id' missing");
            }
            HMSLog.m36986e("HmsMessaging", "Mandatory parameter 'to' missing");
            PushBiUtil.reportExit(this.f29612a, PushNaming.UPSEND_MSG, strReportEntry, ErrorEnum.ERROR_ARGUMENTS_INVALID);
            throw new IllegalArgumentException("Mandatory parameter 'to' missing");
        }
        HMSLog.m36986e("HmsMessaging", "Message sent failed:" + errorEnumM36619a.getExternalCode() + ':' + errorEnumM36619a.getMessage());
        PushBiUtil.reportExit(this.f29612a, PushNaming.UPSEND_MSG, strReportEntry, errorEnumM36619a);
        throw new UnsupportedOperationException(errorEnumM36619a.getMessage());
    }

    /* renamed from: a */
    private Task<Void> m36484a(boolean z10) {
        String strReportEntry = PushBiUtil.reportEntry(this.f29612a, PushNaming.SET_NOTIFY_FLAG);
        if (AbstractC6285d.m36515d(this.f29612a) && !AbstractC6285d.m36512b()) {
            if (HwBuildEx.VERSION.EMUI_SDK_INT < 12) {
                HMSLog.m36986e("HmsMessaging", "operation not available on Huawei device with EMUI lower than 5.1");
                C8941i c8941i = new C8941i();
                ErrorEnum errorEnum = ErrorEnum.ERROR_OPERATION_NOT_SUPPORTED;
                c8941i.m56657c(errorEnum.toApiException());
                PushBiUtil.reportExit(this.f29612a, PushNaming.SET_NOTIFY_FLAG, strReportEntry, errorEnum);
                return c8941i.m56656b();
            }
            if (AbstractC6285d.m36511b(this.f29612a) < 90101310) {
                HMSLog.m36988i("HmsMessaging", "turn on/off with broadcast v1");
                Intent intentPutExtra = new Intent("com.huawei.intent.action.SELF_SHOW_FLAG").putExtra("enalbeFlag", PushEncrypter.encrypterOld(this.f29612a, this.f29612a.getPackageName() + "#" + z10));
                intentPutExtra.setPackage(OsType.ANDROID);
                return C8943k.m56662b(new IntentCallable(this.f29612a, intentPutExtra, strReportEntry));
            }
            if (AbstractC6285d.m36511b(this.f29612a) < 110118300) {
                HMSLog.m36988i("HmsMessaging", "turn on/off with broadcast v2");
                new PushPreferences(this.f29612a, "push_notify_flag").saveBoolean("notify_msg_enable", !z10);
                Uri uri = Uri.parse("content://" + this.f29612a.getPackageName() + ".huawei.push.provider/push_notify_flag.xml");
                Intent intent = new Intent("com.huawei.android.push.intent.SDK_COMMAND");
                intent.putExtra("type", "enalbeFlag");
                intent.putExtra(SdkCfgSha256Record.PKGNAME, this.f29612a.getPackageName());
                intent.putExtra("url", uri);
                intent.setPackage(OsType.ANDROID);
                return C8943k.m56662b(new IntentCallable(this.f29612a, intent, strReportEntry));
            }
            HMSLog.m36988i("HmsMessaging", "turn on/off with broadcast v3");
            if (TextUtils.isEmpty(BaseUtils.getLocalToken(this.f29612a, null))) {
                C8941i c8941i2 = new C8941i();
                c8941i2.m56657c(ErrorEnum.ERROR_NO_TOKEN.toApiException());
                return c8941i2.m56656b();
            }
            new PushPreferences(this.f29612a, "push_notify_flag").saveBoolean("notify_msg_enable", !z10);
            Intent intent2 = new Intent("com.huawei.intent.action.SELF_SHOW_FLAG");
            intent2.putExtra("enalbeFlag", z10);
            intent2.putExtra(RemoteMessageConst.DEVICE_TOKEN, BaseUtils.getLocalToken(this.f29612a, null));
            intent2.putExtra(SdkCfgSha256Record.PKGNAME, this.f29612a.getPackageName());
            intent2.putExtra("uid", this.f29612a.getApplicationInfo().uid);
            intent2.setPackage(OsType.ANDROID);
            return C8943k.m56662b(new IntentCallable(this.f29612a, intent2, strReportEntry));
        }
        HMSLog.m36988i("HmsMessaging", "turn on/off with AIDL");
        EnableNotifyReq enableNotifyReq = new EnableNotifyReq();
        enableNotifyReq.setPackageName(this.f29612a.getPackageName());
        enableNotifyReq.setEnable(z10);
        return this.f29613b.doWrite(new BaseVoidTask(PushNaming.SET_NOTIFY_FLAG, JsonUtil.createJsonString(enableNotifyReq), strReportEntry));
    }

    /* renamed from: a */
    private void m36486a(UpSendMsgReq upSendMsgReq, String str) {
        upSendMsgReq.setToken(BaseUtils.getLocalToken(this.f29612a, null));
        try {
            this.f29613b.doWrite(new SendUpStreamTask(PushNaming.UPSEND_MSG, JsonUtil.createJsonString(upSendMsgReq), str, upSendMsgReq.getPackageName(), upSendMsgReq.getMessageId()));
        } catch (Exception e10) {
            if (e10.getCause() instanceof ApiException) {
                PushBiUtil.reportExit(this.f29612a, PushNaming.UPSEND_MSG, str, ((ApiException) e10.getCause()).getStatusCode());
            } else {
                PushBiUtil.reportExit(this.f29612a, PushNaming.UPSEND_MSG, str, ErrorEnum.ERROR_INTERNAL_ERROR);
            }
        }
    }
}
