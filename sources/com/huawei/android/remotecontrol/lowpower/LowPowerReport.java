package com.huawei.android.remotecontrol.lowpower;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import bf.C1175a;
import com.huawei.android.remotecontrol.config.ParamConfig;
import com.huawei.android.remotecontrol.controller.cmd.PushCmdParser;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0209d;
import p366if.AbstractC10482g;
import p366if.C10481f;
import p521og.C11877j;
import p709vj.C13452e;
import p809yg.C13981a;
import sg.C12797b;

/* loaded from: classes4.dex */
public class LowPowerReport {

    /* renamed from: c */
    public static LowPowerReport f19853c = new LowPowerReport();

    /* renamed from: a */
    public BatteryChangeBroadcastReceiver f19854a;

    /* renamed from: b */
    public int f19855b = 0;

    public class BatteryChangeBroadcastReceiver extends BroadcastReceiver {
        public BatteryChangeBroadcastReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) throws JSONException {
            HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(intent);
            String action = hiCloudSafeIntent.getAction();
            if (action == null) {
                C13981a.m83988e("LowPowerReport", "LowPowerReport action is null");
                return;
            }
            C13981a.m83989i("LowPowerReport", "LowPowerReport action..." + action);
            if (action.equals("android.intent.action.BATTERY_CHANGED")) {
                if (!C11877j.m71202D(context)) {
                    C13981a.m83988e("LowPowerReport", "SharedPreferenceUtil isLastLocReportSwitchOpen false");
                    LowPowerReport.this.m26259f(context);
                    return;
                }
                if (!C1175a.m7389k(context)) {
                    C11877j.m71243X0(context, Boolean.FALSE);
                    return;
                }
                if (C1175a.m7395q(context, C13452e.m80781L().m80971t0())) {
                    C13981a.m83988e("LowPowerReport", "uid not match");
                    return;
                }
                if (!C0209d.m1333z1(context)) {
                    C13981a.m83988e("LowPowerReport", "isNetWorkConnected false");
                    return;
                }
                int intExtra = (hiCloudSafeIntent.getIntExtra(FaqConstants.FAQ_LEVEL, 0) * 100) / hiCloudSafeIntent.getIntExtra("scale", 0);
                C13981a.m83989i("LowPowerReport", "LowPowerReport perLevel:" + intExtra + "LowPowerReport LOW_BATTERY_WARNING_LEVEL:25");
                if (LowPowerReport.this.m26257d(intExtra)) {
                    C13981a.m83989i("LowPowerReport", "LowPowerReport perLevel..." + intExtra + ",has reported,break!");
                    return;
                }
                if (25 < intExtra) {
                    LowPowerReport.this.m26259f(context);
                } else if (ParamConfig.getInstance().needLowPowerReport(intExtra)) {
                    LowPowerReport.this.m26260g(context);
                } else if (intExtra < 5) {
                    LowPowerReport.this.m26259f(context);
                }
            }
        }
    }

    /* renamed from: c */
    public static LowPowerReport m26256c() {
        return f19853c;
    }

    /* renamed from: d */
    public final boolean m26257d(int i10) {
        if (this.f19855b == i10) {
            return true;
        }
        this.f19855b = i10;
        return false;
    }

    /* renamed from: e */
    public void m26258e(Context context) {
        if (this.f19854a == null) {
            this.f19854a = new BatteryChangeBroadcastReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
            context.getApplicationContext().registerReceiver(this.f19854a, intentFilter);
            C13981a.m83989i("LowPowerReport", "LowPowerReport init...");
        }
    }

    /* renamed from: f */
    public void m26259f(Context context) {
        if (this.f19854a == null) {
            C13981a.m83989i("LowPowerReport", "mBatteryChangeBroadcastReceiver is null");
            return;
        }
        context.getApplicationContext().unregisterReceiver(this.f19854a);
        this.f19854a = null;
        C13981a.m83989i("LowPowerReport", "LowPowerReport release...");
    }

    /* renamed from: g */
    public final void m26260g(Context context) throws JSONException {
        Intent intent = new Intent();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("cmd", "locate");
            jSONObject.put("x-hw-trace-id", C12797b.m76774a("01014"));
            intent.putExtra("msg_data", jSONObject.toString());
        } catch (JSONException e10) {
            C13981a.m83988e("LowPowerReport", "startLowBttLocateReport JSONException:" + e10.getMessage());
        }
        C13981a.m83989i("LowPowerReport", "LowPowerReport locate start...");
        AbstractC10482g abstractC10482gM64431g = C10481f.m64431g(context, new PushCmdParser(intent, context), false, "lowpower_locate");
        abstractC10482gM64431g.m7420H();
        abstractC10482gM64431g.mo7440z();
    }
}
