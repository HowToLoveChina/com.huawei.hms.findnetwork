package com.huawei.location.base.activity;

import android.content.Context;
import android.os.SystemClock;
import as.C1016d;
import com.huawei.hms.location.entity.activity.ActivityTransition;
import com.huawei.hms.location.entity.activity.ActivityTransitionEvent;
import com.huawei.hms.location.entity.activity.ActivityTransitionResult;
import com.huawei.location.base.activity.callback.ATCallback;
import com.huawei.location.base.activity.entity.ClientInfo;
import com.huawei.location.base.activity.entity.MovementEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes8.dex */
public class ActivityTransitionMappingManager {
    private static final String TAG = "ActivityTransitionMappingManager";
    private List<ActivityTransitionMappingInfo> infos = new CopyOnWriteArrayList();
    private Map<String, Integer> returnEventsCache = new ConcurrentHashMap();

    private void callBackWithReport(ActivityTransitionMappingInfo activityTransitionMappingInfo, List<ActivityTransitionEvent> list) {
        try {
            activityTransitionMappingInfo.getCallback().onActivityTransition(new ActivityTransitionResult(list));
        } catch (Exception unused) {
            C1016d.m6185e(TAG, "Failed to get activity transition callback", true);
        }
    }

    private List<ActivityTransitionEvent> getActivityTransitionEvents(List<ActivityTransition> list, Iterable<MovementEvent> iterable) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty() && iterable != null) {
            for (ActivityTransition activityTransition : list) {
                for (MovementEvent movementEvent : iterable) {
                    String movement = movementEvent.getMovement();
                    int eventType = movementEvent.getEventType();
                    int iIntValue = ActivityRecognitionConstantsMapping.getActivityTypeOpposite(movement).intValue();
                    int iIntValue2 = ActivityRecognitionConstantsMapping.getTransitionTypeOpposite(Integer.valueOf(eventType)).intValue();
                    if (activityTransition.getActivityType() == iIntValue && activityTransition.getTransitionType() == iIntValue2) {
                        arrayList.add(new ActivityTransitionEvent(iIntValue, iIntValue2, SystemClock.elapsedRealtimeNanos()));
                    }
                }
            }
        }
        return arrayList;
    }

    private boolean isUpdate(ActivityTransitionMappingInfo activityTransitionMappingInfo) {
        for (int i10 = 0; i10 < this.infos.size(); i10++) {
            if (this.infos.get(i10).equals(activityTransitionMappingInfo)) {
                ActivityTransitionMappingInfo activityTransitionMappingInfo2 = this.infos.get(i10);
                C1016d.m6186f(TAG, "need update atMappingInfo:atRequestSize:" + activityTransitionMappingInfo2.getActivityTransitions().size() + "->" + activityTransitionMappingInfo.getActivityTransitions().size());
                activityTransitionMappingInfo2.setActivityTransitions(activityTransitionMappingInfo.getActivityTransitions());
                activityTransitionMappingInfo2.setClientInfo(activityTransitionMappingInfo.getClientInfo());
                return true;
            }
        }
        return false;
    }

    public void addActivityTransitionMappingInfo(List<ActivityTransition> list, ATCallback aTCallback, ClientInfo clientInfo) {
        String str;
        C1016d.m6186f(TAG, "addActivityTransitionMappingInfo callback:");
        if (list == null || list.isEmpty() || aTCallback == null) {
            str = "null == transitions || transitions.size() < 1 || null == pendingIntent";
        } else {
            ActivityTransitionMappingInfo activityTransitionMappingInfo = new ActivityTransitionMappingInfo();
            activityTransitionMappingInfo.setActivityTransitions(list);
            activityTransitionMappingInfo.setCallback(aTCallback);
            activityTransitionMappingInfo.setClientInfo(clientInfo);
            if (this.infos.isEmpty() || !isUpdate(activityTransitionMappingInfo)) {
                this.infos.add(activityTransitionMappingInfo);
            }
            str = "addActivityTransitionMappingInfo end size is " + this.infos.size();
        }
        C1016d.m6186f(TAG, str);
    }

    public Iterable<MovementEvent> compareReturnEventCache(Iterable<MovementEvent> iterable) {
        C1016d.m6186f(TAG, "compareReturnEventCache");
        ArrayList arrayList = new ArrayList();
        Iterator<MovementEvent> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            MovementEvent movementEvent = (MovementEvent) it2.next();
            String movement = movementEvent.getMovement();
            int eventType = movementEvent.getEventType();
            C1016d.m6186f(TAG, "movement " + movement + "eventType " + eventType);
            if (this.returnEventsCache.isEmpty()) {
                this.returnEventsCache.put(movement, Integer.valueOf(eventType));
            } else {
                Integer num = this.returnEventsCache.get(movement);
                this.returnEventsCache.put(movement, Integer.valueOf(eventType));
                if (num != null && num.intValue() == eventType) {
                    C1016d.m6186f(TAG, "already report , remove it");
                    it2.remove();
                }
            }
        }
        return arrayList;
    }

    public List<ActivityTransitionMappingInfo> getInfos() {
        return this.infos;
    }

    public boolean isEmptyRequest() {
        List<ActivityTransitionMappingInfo> list = this.infos;
        return list == null || list.isEmpty();
    }

    public List<ActivityTransition> removeActivityTransitionMappingInfo(ATCallback aTCallback) {
        C1016d.m6187g(TAG, "removeActivityTransitionMappingInfo callback: " + aTCallback + " ,size is " + this.infos.size(), true);
        HashMap map = new HashMap(this.infos.size());
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (ActivityTransitionMappingInfo activityTransitionMappingInfo : this.infos) {
            List<ActivityTransition> activityTransitions = activityTransitionMappingInfo.getActivityTransitions();
            if (activityTransitionMappingInfo.getCallback().equals(aTCallback)) {
                arrayList2.add(activityTransitionMappingInfo);
                arrayList.addAll(activityTransitions);
            } else if (activityTransitions != null && activityTransitions.size() > 0) {
                for (ActivityTransition activityTransition : activityTransitions) {
                    map.put(activityTransition.getActivityType() + "-" + activityTransition.getTransitionType(), Boolean.TRUE);
                }
            }
        }
        if (arrayList.size() > 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ActivityTransition activityTransition2 = (ActivityTransition) it.next();
                if (!map.isEmpty()) {
                    if (map.containsKey(activityTransition2.getActivityType() + "-" + activityTransition2.getTransitionType())) {
                        it.remove();
                        C1016d.m6186f(TAG, "other request contain:" + activityTransition2.getActivityType() + "-" + activityTransition2.getTransitionType() + ", not disable");
                    }
                }
            }
        }
        this.infos.removeAll(arrayList2);
        C1016d.m6186f(TAG, "removeActivityTransitionMappingInfo end size is " + this.infos.size());
        return arrayList;
    }

    public List<ActivityTransitionMappingInfo> removeActivityTransitionMappingInfoByPackageName(String str) {
        C1016d.m6186f(TAG, "removeActivityTransitionMappingInfoByPackageName:enter:" + str);
        ArrayList arrayList = new ArrayList();
        for (ActivityTransitionMappingInfo activityTransitionMappingInfo : this.infos) {
            if (activityTransitionMappingInfo.getClientInfo().getPackageName().equals(str)) {
                arrayList.add(activityTransitionMappingInfo);
            }
        }
        this.infos.removeAll(arrayList);
        C1016d.m6186f(TAG, "removeActivityTransitionMappingInfoByPackageName:exit:" + str);
        return arrayList;
    }

    public void sendActivityTransitionMappingInfo(Iterable<MovementEvent> iterable, Context context) {
        C1016d.m6187g(TAG, "sendActivityTransitionMappingInfo:requestList size:" + this.infos.size(), true);
        for (ActivityTransitionMappingInfo activityTransitionMappingInfo : this.infos) {
            List<ActivityTransitionEvent> activityTransitionEvents = getActivityTransitionEvents(activityTransitionMappingInfo.getActivityTransitions(), iterable);
            C1016d.m6186f(TAG, "sendActivityTransitionMappingInfo,events size is " + activityTransitionEvents.size());
            if (activityTransitionEvents.size() > 0) {
                callBackWithReport(activityTransitionMappingInfo, activityTransitionEvents);
            }
        }
    }
}
