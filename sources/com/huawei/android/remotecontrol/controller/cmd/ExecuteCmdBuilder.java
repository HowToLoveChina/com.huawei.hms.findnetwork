package com.huawei.android.remotecontrol.controller.cmd;

import android.content.Context;
import bf.AbstractC1177c;
import p809yg.C13981a;

/* loaded from: classes4.dex */
public class ExecuteCmdBuilder {
    private static final String TAG = "ExecuteCmdBuilder";
    private static IBuilder sBuilder;

    public interface IBuilder {
        AbstractC1177c executeCmd(Context context, PushCmdParser pushCmdParser);
    }

    private ExecuteCmdBuilder() {
    }

    public static void excuteV8Cmd(Context context, PushCmdParser pushCmdParser) {
        if (pushCmdParser == null || context == null) {
            C13981a.m83988e(TAG, "executeV8Cmd but param error");
            return;
        }
        AbstractC1177c abstractC1177cExecuteCmd = executeCmd(context, pushCmdParser);
        if (abstractC1177cExecuteCmd == null) {
            C13981a.m83988e(TAG, "executeV8Cmd,ControlObject report obj is null");
            AbstractC1177c.m7405O(pushCmdParser, context);
            return;
        }
        abstractC1177cExecuteCmd.m7419G();
        if (abstractC1177cExecuteCmd.mo7422J()) {
            C13981a.m83989i(TAG, "executeV8Cmd has start after querying push info succeed!");
            abstractC1177cExecuteCmd.mo7440z();
        } else {
            C13981a.m83988e(TAG, "executeV8Cmd,ControlObject report obj Param Invalid");
            AbstractC1177c.m7406R(pushCmdParser, context);
        }
    }

    public static AbstractC1177c executeCmd(Context context, PushCmdParser pushCmdParser) {
        if (getBuilder() != null) {
            return getBuilder().executeCmd(context, pushCmdParser);
        }
        C13981a.m83988e(TAG, "command executor was null, break...");
        return null;
    }

    private static IBuilder getBuilder() throws ClassNotFoundException {
        if (sBuilder == null) {
            C13981a.m83990w(TAG, "class CMCmdBuilder was not loaded,reload classdex by reflect...");
            isClassSupport("com.huawei.android.remotecontrol.CMCmdBuilder");
        }
        return sBuilder;
    }

    public static boolean isClassSupport(String str) throws ClassNotFoundException {
        Class<?> cls;
        try {
            cls = Class.forName(str);
        } catch (Exception e10) {
            C13981a.m83988e(TAG, "ExecuteCmdBuilder isClassSupport Exception" + e10.toString());
            cls = null;
        }
        return cls != null;
    }

    public static void registerBuilder(IBuilder iBuilder) {
        sBuilder = iBuilder;
    }
}
