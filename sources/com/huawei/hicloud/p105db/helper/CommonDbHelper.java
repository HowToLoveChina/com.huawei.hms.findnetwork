package com.huawei.hicloud.p105db.helper;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import cn.C1461a;
import com.huawei.hicloud.notification.p106db.script.HiCloudTextLinkLanguageScript;

/* loaded from: classes6.dex */
public class CommonDbHelper extends SQLiteOpenHelper {
    public CommonDbHelper(Context context) {
        super(context, "hicloudcommon_v2.db", (SQLiteDatabase.CursorFactory) null, 31);
    }

    /* renamed from: b */
    public final void m29890b(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS space_notify (time INTEGER NOT NULL,day INTEGER NOT NULL,month INTEGER NOT NULL,year INTEGER NOT NULL,week INTEGER NOT NULL);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS notify_rule(notifyType TEXT NOT NULL,dataType TEXT NOT NULL,times INTEGER NOT NULL,checkInit INTEGER NOT NULL,lastTimeStamp TEXT NOT NULL);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS space_notify_content_origin(notify_type INTEGER NOT NULL,id INTEGER NOT NULL,language TEXT NOT NULL,title TEXT,main_text TEXT,sub_title TEXT,remind_mode TEXT,button_first TEXT,buttonSecond TEXT,description TEXT,description_second TEXT,main_text_second TEXT,detail_link TEXT)");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS space_notify_detail(id INTEGER NOT NULL,notice_type TEXT NOT NULL,language TEXT NOT NULL,title TEXT,main_text TEXT,button_first TEXT,user_type TEXT,detail_link TEXT);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS family_share_language(language TEXT NOT NULL,name TEXT NOT NULL,value TEXT NOT NULL);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS cloud_space_usage_language(language TEXT NOT NULL,name TEXT NOT NULL,value TEXT NOT NULL)");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS h5_config(resourceId TEXT,key TEXT,value TEXT)");
    }

    /* renamed from: c */
    public final void m29891c(SQLiteDatabase sQLiteDatabase, String str) throws SQLException {
        try {
            sQLiteDatabase.execSQL(str);
        } catch (Exception e10) {
            C1461a.m8360w("CommonDbHelper", "upgradeTableNeedTryCatch exception: " + e10.toString());
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) throws SQLException {
        C1461a.m8357d("CommonDbHelper", "onCreate");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS sync_config_language(languageName TEXT NOT NULL,textName TEXT NOT NULL,textValue TEXT NOT NULL);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS sync_config(id TEXT NOT NULL,name TEXT NOT NULL,icon TEXT NOT NULL,iconPath TEXT NOT NULL,record TEXT NOT NULL,recordIndex INTEGER DEFAULT -1,supportServer INTEGER DEFAULT -1,unstructedPath TEXT,unstructedPathObs TEXT,minSyncVersion INTEGER DEFAULT 0,minSyncVersionObs INTEGER DEFAULT 0,subUser TEXT NOT NULL,applications TEXT NOT NULL,notifyType TEXT,forceDelete TEXT,databaseId TEXT,keyType TEXT,fingerPrints TEXT,iconHash TEXT)");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS sync_config_data_type(serviceId TEXT NOT NULL,typeId TEXT NOT NULL,typeName TEXT NOT NULL,showNum TEXT NOT NULL,rcycSync TEXT NOT NULL);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS upgrade_config_language(languageName TEXT NOT NULL,textName TEXT NOT NULL,textValue TEXT NOT NULL);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS hicloud_actives_language(languageName TEXT NOT NULL,textName TEXT NOT NULL,textValue TEXT NOT NULL);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS space_notify_content(notify_type INTEGER NOT NULL,id INTEGER NOT NULL,language TEXT NOT NULL,title TEXT,main_text TEXT,sub_title TEXT,remind_mode TEXT,button_first TEXT,buttonSecond TEXT,description TEXT,description_second TEXT,main_text_second TEXT,content_type TEXT)");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS hicloud_push_guide_language(languageName TEXT NOT NULL,textName TEXT NOT NULL,textValue TEXT NOT NULL);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS urgency_policy(id TEXT,scenario TEXT,action TEXT,notice_type,notice TEXT,ontop TEXT,detail TEXT)");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS urgency_notice_info(key TEXT,value TEXT)");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS urgency_language(version TEXT NOT NULL,languageName TEXT NOT NULL,textName TEXT NOT NULL,textValue TEXT NOT NULL);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS space_notify (time INTEGER NOT NULL,day INTEGER NOT NULL,month INTEGER NOT NULL,year INTEGER NOT NULL,week INTEGER NOT NULL);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS notify_rule(notifyType TEXT NOT NULL,dataType TEXT NOT NULL,times INTEGER NOT NULL,checkInit INTEGER NOT NULL,lastTimeStamp TEXT NOT NULL);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS space_notify_content_origin(notify_type INTEGER NOT NULL,id INTEGER NOT NULL,language TEXT NOT NULL,title TEXT,main_text TEXT,sub_title TEXT,remind_mode TEXT,button_first TEXT,buttonSecond TEXT,description TEXT,description_second TEXT,main_text_second TEXT,detail_link TEXT)");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS space_notify_detail(id INTEGER NOT NULL,notice_type TEXT NOT NULL,language TEXT NOT NULL,title TEXT,main_text TEXT,button_first TEXT,user_type TEXT,detail_link TEXT);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS family_share_language(language TEXT NOT NULL,name TEXT NOT NULL,value TEXT NOT NULL);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS cloud_space_usage_language(language TEXT NOT NULL,name TEXT NOT NULL,value TEXT NOT NULL)");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS space_mult_language(language TEXT NOT NULL,name TEXT NOT NULL,value TEXT NOT NULL);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS restore_notify(id TEXT NOT NULL,hoursafteroobe TEXT NOT NULL,timesinhours TEXT NOT NULL,firsttrigafter TEXT NOT NULL,starttime TEXT NOT NULL,endtime TEXT NOT NULL,loginstate TEXT NOT NULL,noticetype TEXT NOT NULL,priority TEXT NOT NULL);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS restore_notify_devices(id TEXT NOT NULL,loginstate TEXT NOT NULL,releasedevice TEXT NOT NULL);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS restore_notify_language(id TEXT NOT NULL,loginstate TEXT NOT NULL,language TEXT NOT NULL,title TEXT NOT NULL,sub_title TEXT NOT NULL);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS notice_content_language(languageName TEXT NOT NULL,textName TEXT NOT NULL,textValue TEXT NOT NULL);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS space_notify_frequency(notifyType TEXT NOT NULL,dataType TEXT NOT NULL,times INTEGER NOT NULL,lastTimeStamp TEXT NOT NULL);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS space_notify_v3_language(languageName TEXT NOT NULL,textName TEXT NOT NULL,textValue TEXT NOT NULL);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS space_notify_v3_language_local(languageName TEXT NOT NULL,textName TEXT NOT NULL,textValue TEXT NOT NULL);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS space_notify_v4_language(languageName TEXT NOT NULL,textName TEXT NOT NULL,textValue TEXT NOT NULL);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS space_notify_v4_language_local(languageName TEXT NOT NULL,textName TEXT NOT NULL,textValue TEXT NOT NULL);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS space_notify_v5_language(languageName TEXT NOT NULL,textName TEXT NOT NULL,textValue TEXT NOT NULL);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS stock_active_config_language(languageName TEXT NOT NULL,textName TEXT NOT NULL,textValue TEXT NOT NULL);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS h5_config(resourceId TEXT,key TEXT,value TEXT)");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS h5_language_config(language TEXT,name TEXT,value TEXT)");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS hicloud_brand_homepage_banner_language(languageName TEXT NOT NULL,textName TEXT NOT NULL,textValue TEXT NOT NULL);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS hicloud_brand_buy_banner_language(languageName TEXT NOT NULL,textName TEXT NOT NULL,textValue TEXT NOT NULL);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS hicloud_scene_homepage_banner_language(languageName TEXT NOT NULL,textName TEXT NOT NULL,textValue TEXT NOT NULL);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS hicloud_scene_buy_banner_language(languageName TEXT NOT NULL,textName TEXT NOT NULL,textValue TEXT NOT NULL);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS frequency_control_language(languageName TEXT NOT NULL,textName TEXT NOT NULL,textValue TEXT NOT NULL);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS freq_control_time(time INTEGER NOT NULL, remind_purpose, remind_method);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS drive_config_language(languageName TEXT NOT NULL,textName TEXT NOT NULL,textValue TEXT NOT NULL);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS drive_config(id TEXT NOT NULL,appId TEXT NOT NULL,pkgNames TEXT NOT NULL,signHash TEXT NOT NULL,icon TEXT NOT NULL,style TEXT NOT NULL,name TEXT NOT NULL,subPageIcon TEXT,subDesc TEXT,subSwitchDesc TEXT,minSyncVersion INTEGER DEFAULT -1,record TEXT NOT NULL,recordIndex INTEGER DEFAULT -1,version TEXT,iconPath TEXT,subPageIconPath TEXT, subUser TEXT);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS hicloud_msg_notice_language(languageName TEXT NOT NULL,textName TEXT NOT NULL,textValue TEXT NOT NULL);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS message_center(uniqueId TEXT,msgType TEXT NOT NULL,msgGotoType TEXT,msgGotoUri TEXT,mainText TEXT,titleText TEXT,richMsgContent TEXT,needShowBadge INTEGER DEFAULT 0,readValidityTime INTEGER DEFAULT 0,remainValidityTime INTEGER DEFAULT 0,notifyTime INTEGER DEFAULT 0,pictureUrl TEXT,alreadyRead INTEGER DEFAULT 0,category TEXT,resourceInfo TEXT,recommendNeedData TEXT,memberShareDetail TEXT,checkFamilyMember INTEGER DEFAULT 0,notifyId INTEGER DEFAULT 0,agdParameters TEXT,gotoDeeplinkUri TEXT,totalNeedSpace INTEGER DEFAULT 0,introductionH5Url TEXT,notifyType TEXT, context TEXT);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS message_h5_window(uniqueId TEXT,msgGotoType TEXT,msgGotoUri TEXT,h5DialogAction INTEGER DEFAULT 0,h5DialogUrl TEXT,readValidityTime INTEGER DEFAULT 0,remainValidityTime INTEGER DEFAULT 0,notifyTime INTEGER DEFAULT 0,alreadyRead INTEGER DEFAULT 0,resourceInfo TEXT,agdParameters TEXT,priority INTEGER DEFAULT 0,param TEXT,realtimeParam TEXT,trigger TEXT,supportTrigger INTEGER DEFAULT 0);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS feature_gray(functionId TEXT,parameters TEXT,status INTEGER DEFAULT 0);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS campaign_notice_language(languageName TEXT NOT NULL,textName TEXT NOT NULL,textValue TEXT NOT NULL);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS campaign_activity_language(languageName TEXT NOT NULL,textName TEXT NOT NULL,textValue TEXT NOT NULL);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS campaign_quest_language(languageName TEXT NOT NULL,textName TEXT NOT NULL,textValue TEXT NOT NULL);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS hicloud_nps_notify_language(languageName TEXT NOT NULL,textName TEXT NOT NULL,textValue TEXT NOT NULL);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS text_link_language(languageName TEXT NOT NULL,textName TEXT NOT NULL,textValue TEXT NOT NULL);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS hicloud_params_value(id INTEGER PRIMARY KEY AUTOINCREMENT,key TEXT NOT NULL UNIQUE,value TEXT NOT NULL,expireTime BIGINT);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS params_meta(name TEXT,type TEXT,provider TEXT, endpoint TEXT, authType TEXT);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS homepage_switch_notice_language(languageName TEXT NOT NULL,textName TEXT NOT NULL,textValue TEXT NOT NULL);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS data_upper_limit_language(languageName TEXT NOT NULL,textName TEXT NOT NULL,textValue TEXT NOT NULL);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS backup_before_notice_language(languageName TEXT NOT NULL,textName TEXT NOT NULL,textValue TEXT NOT NULL);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS history_application_distribute(appId TEXT NOT NULL PRIMARY KEY,status INTEGER DEFAULT 1,time LONG DEFAULT 0);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS hicloud_upgrade_language(languageName TEXT NOT NULL,textName TEXT NOT NULL,textValue TEXT NOT NULL);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS message_desk_popup(uniqueId TEXT,desktopTitle TEXT,desktopText TEXT,readValidityTime INTEGER DEFAULT 0,remainValidityTime INTEGER DEFAULT 0,notifyTime INTEGER DEFAULT 0,alreadyRead INTEGER DEFAULT 0,resourceInfo TEXT,priority INTEGER DEFAULT 0,trigger TEXT,supportTrigger INTEGER DEFAULT 0,messageId TEXT,desktopGoto TEXT,deskPopupAction INTEGER DEFAULT 0,cfgInstanceId TEXT,secondWindows TEXT,extras TEXT,context TEXT);");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) throws SQLException {
        C1461a.m8359i("CommonDbHelper", "onDowngrade oldVersion = " + i10 + " newVersion = " + i11);
        if (i10 > 2) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS upgrade_config_language;");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS upgrade_config_language(languageName TEXT NOT NULL,textName TEXT NOT NULL,textValue TEXT NOT NULL);");
        }
        if (i10 > 3) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS sync_config;");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS sync_config(id TEXT NOT NULL,name TEXT NOT NULL,icon TEXT NOT NULL,iconPath TEXT NOT NULL,record TEXT NOT NULL,recordIndex INTEGER DEFAULT -1,supportServer INTEGER DEFAULT -1,unstructedPath TEXT,unstructedPathObs TEXT,minSyncVersion INTEGER DEFAULT 0,minSyncVersionObs INTEGER DEFAULT 0,subUser TEXT NOT NULL,applications TEXT NOT NULL,notifyType TEXT,forceDelete TEXT,databaseId TEXT,keyType TEXT,fingerPrints TEXT,iconHash TEXT)");
        }
        if (i10 > 4) {
            sQLiteDatabase.execSQL("DROP TABLE if exists space_notify_content");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS space_notify_content(notify_type INTEGER NOT NULL,id INTEGER NOT NULL,language TEXT NOT NULL,title TEXT,main_text TEXT,sub_title TEXT,remind_mode TEXT,button_first TEXT,buttonSecond TEXT,description TEXT,description_second TEXT,main_text_second TEXT,content_type TEXT)");
            sQLiteDatabase.execSQL("DROP TABLE if exists urgency_policy");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS urgency_policy(id TEXT,scenario TEXT,action TEXT,notice_type,notice TEXT,ontop TEXT,detail TEXT)");
            sQLiteDatabase.execSQL("DROP TABLE if exists urgency_notice_info");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS urgency_notice_info(key TEXT,value TEXT)");
            sQLiteDatabase.execSQL("DROP TABLE if exists urgency_language");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS urgency_language(version TEXT NOT NULL,languageName TEXT NOT NULL,textName TEXT NOT NULL,textValue TEXT NOT NULL);");
        }
        if (i10 > 5) {
            sQLiteDatabase.execSQL("DROP TABLE if exists space_notify;");
            sQLiteDatabase.execSQL("DROP TABLE if exists notify_rule;");
            sQLiteDatabase.execSQL("DROP TABLE if exists space_notify_content_origin");
            sQLiteDatabase.execSQL("DROP TABLE if exists space_notify_detail");
            sQLiteDatabase.execSQL("DROP TABLE if exists family_share_language");
            sQLiteDatabase.execSQL("DROP TABLE if exists cloud_space_usage_language");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS space_notify (time INTEGER NOT NULL,day INTEGER NOT NULL,month INTEGER NOT NULL,year INTEGER NOT NULL,week INTEGER NOT NULL);");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS notify_rule(notifyType TEXT NOT NULL,dataType TEXT NOT NULL,times INTEGER NOT NULL,checkInit INTEGER NOT NULL,lastTimeStamp TEXT NOT NULL);");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS space_notify_content_origin(notify_type INTEGER NOT NULL,id INTEGER NOT NULL,language TEXT NOT NULL,title TEXT,main_text TEXT,sub_title TEXT,remind_mode TEXT,button_first TEXT,buttonSecond TEXT,description TEXT,description_second TEXT,main_text_second TEXT,detail_link TEXT)");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS space_notify_detail(id INTEGER NOT NULL,notice_type TEXT NOT NULL,language TEXT NOT NULL,title TEXT,main_text TEXT,button_first TEXT,user_type TEXT,detail_link TEXT);");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS family_share_language(language TEXT NOT NULL,name TEXT NOT NULL,value TEXT NOT NULL);");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS cloud_space_usage_language(language TEXT NOT NULL,name TEXT NOT NULL,value TEXT NOT NULL)");
        }
        if (i10 > 7) {
            sQLiteDatabase.execSQL("DROP TABLE if exists notice_content_language");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS notice_content_language(languageName TEXT NOT NULL,textName TEXT NOT NULL,textValue TEXT NOT NULL);");
        }
        if (i10 > 8) {
            sQLiteDatabase.execSQL("DROP TABLE if exists hicloud_push_guide_language");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS hicloud_push_guide_language(languageName TEXT NOT NULL,textName TEXT NOT NULL,textValue TEXT NOT NULL);");
        }
        if (i10 > 9) {
            sQLiteDatabase.execSQL("DROP TABLE if exists space_notify_frequency");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS space_notify_frequency(notifyType TEXT NOT NULL,dataType TEXT NOT NULL,times INTEGER NOT NULL,lastTimeStamp TEXT NOT NULL);");
            sQLiteDatabase.execSQL("DROP TABLE if exists space_notify_v3_language");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS space_notify_v3_language(languageName TEXT NOT NULL,textName TEXT NOT NULL,textValue TEXT NOT NULL);");
            sQLiteDatabase.execSQL("DROP TABLE if exists space_notify_v3_language_local");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS space_notify_v3_language_local(languageName TEXT NOT NULL,textName TEXT NOT NULL,textValue TEXT NOT NULL);");
            sQLiteDatabase.execSQL("DROP TABLE if exists stock_active_config_language");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS stock_active_config_language(languageName TEXT NOT NULL,textName TEXT NOT NULL,textValue TEXT NOT NULL);");
        }
        if (i10 > 10) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS sync_config;");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS sync_config(id TEXT NOT NULL,name TEXT NOT NULL,icon TEXT NOT NULL,iconPath TEXT NOT NULL,record TEXT NOT NULL,recordIndex INTEGER DEFAULT -1,supportServer INTEGER DEFAULT -1,unstructedPath TEXT,unstructedPathObs TEXT,minSyncVersion INTEGER DEFAULT 0,minSyncVersionObs INTEGER DEFAULT 0,subUser TEXT NOT NULL,applications TEXT NOT NULL,notifyType TEXT,forceDelete TEXT,databaseId TEXT,keyType TEXT,fingerPrints TEXT,iconHash TEXT)");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS h5_config;");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS h5_config(resourceId TEXT,key TEXT,value TEXT)");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS h5_language_config;");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS h5_language_config(language TEXT,name TEXT,value TEXT)");
        }
        if (i10 > 12) {
            sQLiteDatabase.execSQL("DROP TABLE if exists hicloud_brand_homepage_banner_language");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS hicloud_brand_homepage_banner_language(languageName TEXT NOT NULL,textName TEXT NOT NULL,textValue TEXT NOT NULL);");
            sQLiteDatabase.execSQL("DROP TABLE if exists hicloud_brand_buy_banner_language");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS hicloud_brand_buy_banner_language(languageName TEXT NOT NULL,textName TEXT NOT NULL,textValue TEXT NOT NULL);");
            sQLiteDatabase.execSQL("DROP TABLE if exists hicloud_scene_homepage_banner_language");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS hicloud_scene_homepage_banner_language(languageName TEXT NOT NULL,textName TEXT NOT NULL,textValue TEXT NOT NULL);");
            sQLiteDatabase.execSQL("DROP TABLE if exists hicloud_scene_buy_banner_language");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS hicloud_scene_buy_banner_language(languageName TEXT NOT NULL,textName TEXT NOT NULL,textValue TEXT NOT NULL);");
        }
        if (i10 > 13) {
            sQLiteDatabase.execSQL("DROP TABLE if exists frequency_control_language");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS frequency_control_language(languageName TEXT NOT NULL,textName TEXT NOT NULL,textValue TEXT NOT NULL);");
            sQLiteDatabase.execSQL("DROP TABLE if exists freq_control_time;");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS freq_control_time(time INTEGER NOT NULL, remind_purpose, remind_method);");
        }
        if (i10 > 16) {
            sQLiteDatabase.execSQL("DROP TABLE if exists hicloud_msg_notice_language");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS hicloud_msg_notice_language(languageName TEXT NOT NULL,textName TEXT NOT NULL,textValue TEXT NOT NULL);");
            sQLiteDatabase.execSQL("DROP TABLE if exists message_center");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS message_center(uniqueId TEXT,msgType TEXT NOT NULL,msgGotoType TEXT,msgGotoUri TEXT,mainText TEXT,titleText TEXT,richMsgContent TEXT,needShowBadge INTEGER DEFAULT 0,readValidityTime INTEGER DEFAULT 0,remainValidityTime INTEGER DEFAULT 0,notifyTime INTEGER DEFAULT 0,pictureUrl TEXT,alreadyRead INTEGER DEFAULT 0,category TEXT,resourceInfo TEXT,recommendNeedData TEXT,memberShareDetail TEXT,checkFamilyMember INTEGER DEFAULT 0,notifyId INTEGER DEFAULT 0,agdParameters TEXT,gotoDeeplinkUri TEXT,totalNeedSpace INTEGER DEFAULT 0,introductionH5Url TEXT,notifyType TEXT, context TEXT);");
            sQLiteDatabase.execSQL("DROP TABLE if exists message_h5_window");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS message_h5_window(uniqueId TEXT,msgGotoType TEXT,msgGotoUri TEXT,h5DialogAction INTEGER DEFAULT 0,h5DialogUrl TEXT,readValidityTime INTEGER DEFAULT 0,remainValidityTime INTEGER DEFAULT 0,notifyTime INTEGER DEFAULT 0,alreadyRead INTEGER DEFAULT 0,resourceInfo TEXT,agdParameters TEXT,priority INTEGER DEFAULT 0,param TEXT,realtimeParam TEXT,trigger TEXT,supportTrigger INTEGER DEFAULT 0);");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS drive_config;");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS drive_config(id TEXT NOT NULL,appId TEXT NOT NULL,pkgNames TEXT NOT NULL,signHash TEXT NOT NULL,icon TEXT NOT NULL,style TEXT NOT NULL,name TEXT NOT NULL,subPageIcon TEXT,subDesc TEXT,subSwitchDesc TEXT,minSyncVersion INTEGER DEFAULT -1,record TEXT NOT NULL,recordIndex INTEGER DEFAULT -1,version TEXT,iconPath TEXT,subPageIconPath TEXT, subUser TEXT);");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS drive_config_language;");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS drive_config_language(languageName TEXT NOT NULL,textName TEXT NOT NULL,textValue TEXT NOT NULL);");
        }
        if (i10 > 17) {
            sQLiteDatabase.execSQL("DROP TABLE if exists message_h5_window");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS message_h5_window(uniqueId TEXT,msgGotoType TEXT,msgGotoUri TEXT,h5DialogAction INTEGER DEFAULT 0,h5DialogUrl TEXT,readValidityTime INTEGER DEFAULT 0,remainValidityTime INTEGER DEFAULT 0,notifyTime INTEGER DEFAULT 0,alreadyRead INTEGER DEFAULT 0,resourceInfo TEXT,agdParameters TEXT,priority INTEGER DEFAULT 0,param TEXT,realtimeParam TEXT,trigger TEXT,supportTrigger INTEGER DEFAULT 0);");
            sQLiteDatabase.execSQL("DROP TABLE if exists hicloud_nps_notify_language");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS hicloud_nps_notify_language(languageName TEXT NOT NULL,textName TEXT NOT NULL,textValue TEXT NOT NULL);");
            sQLiteDatabase.execSQL("DROP TABLE if exists feature_gray");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS feature_gray(functionId TEXT,parameters TEXT,status INTEGER DEFAULT 0);");
        }
        if (i10 > 18) {
            sQLiteDatabase.execSQL("DROP TABLE if exists campaign_notice_language");
            sQLiteDatabase.execSQL("DROP TABLE if exists campaign_quest_language");
            sQLiteDatabase.execSQL("DROP TABLE if exists campaign_activity_language");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS campaign_notice_language(languageName TEXT NOT NULL,textName TEXT NOT NULL,textValue TEXT NOT NULL);");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS campaign_activity_language(languageName TEXT NOT NULL,textName TEXT NOT NULL,textValue TEXT NOT NULL);");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS campaign_quest_language(languageName TEXT NOT NULL,textName TEXT NOT NULL,textValue TEXT NOT NULL);");
        }
        if (i10 > 21) {
            sQLiteDatabase.execSQL(HiCloudTextLinkLanguageScript.DROP_TABLE_TEXT_LINK_CONFIG_LANGUAGE);
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS text_link_language(languageName TEXT NOT NULL,textName TEXT NOT NULL,textValue TEXT NOT NULL);");
        }
        if (i10 > 22) {
            sQLiteDatabase.execSQL("DROP TABLE if exists params_meta");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS params_meta(name TEXT,type TEXT,provider TEXT, endpoint TEXT, authType TEXT);");
            sQLiteDatabase.execSQL("DROP TABLE if exists hicloud_params_value");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS hicloud_params_value(id INTEGER PRIMARY KEY AUTOINCREMENT,key TEXT NOT NULL UNIQUE,value TEXT NOT NULL,expireTime BIGINT);");
        }
        if (i10 > 23) {
            sQLiteDatabase.execSQL("DROP TABLE if exists message_center");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS message_center(uniqueId TEXT,msgType TEXT NOT NULL,msgGotoType TEXT,msgGotoUri TEXT,mainText TEXT,titleText TEXT,richMsgContent TEXT,needShowBadge INTEGER DEFAULT 0,readValidityTime INTEGER DEFAULT 0,remainValidityTime INTEGER DEFAULT 0,notifyTime INTEGER DEFAULT 0,pictureUrl TEXT,alreadyRead INTEGER DEFAULT 0,category TEXT,resourceInfo TEXT,recommendNeedData TEXT,memberShareDetail TEXT,checkFamilyMember INTEGER DEFAULT 0,notifyId INTEGER DEFAULT 0,agdParameters TEXT,gotoDeeplinkUri TEXT,totalNeedSpace INTEGER DEFAULT 0,introductionH5Url TEXT,notifyType TEXT, context TEXT);");
        }
        if (i10 > 24) {
            sQLiteDatabase.execSQL("DROP TABLE if exists message_center");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS message_center(uniqueId TEXT,msgType TEXT NOT NULL,msgGotoType TEXT,msgGotoUri TEXT,mainText TEXT,titleText TEXT,richMsgContent TEXT,needShowBadge INTEGER DEFAULT 0,readValidityTime INTEGER DEFAULT 0,remainValidityTime INTEGER DEFAULT 0,notifyTime INTEGER DEFAULT 0,pictureUrl TEXT,alreadyRead INTEGER DEFAULT 0,category TEXT,resourceInfo TEXT,recommendNeedData TEXT,memberShareDetail TEXT,checkFamilyMember INTEGER DEFAULT 0,notifyId INTEGER DEFAULT 0,agdParameters TEXT,gotoDeeplinkUri TEXT,totalNeedSpace INTEGER DEFAULT 0,introductionH5Url TEXT,notifyType TEXT, context TEXT);");
        }
        if (i10 > 26) {
            sQLiteDatabase.execSQL("DROP TABLE if exists space_notify_v4_language");
            sQLiteDatabase.execSQL("DROP TABLE if exists space_notify_v4_language_local");
            sQLiteDatabase.execSQL("DROP TABLE if exists homepage_switch_notice_language");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS homepage_switch_notice_language(languageName TEXT NOT NULL,textName TEXT NOT NULL,textValue TEXT NOT NULL);");
            sQLiteDatabase.execSQL("DROP TABLE if exists data_upper_limit_language");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS data_upper_limit_language(languageName TEXT NOT NULL,textName TEXT NOT NULL,textValue TEXT NOT NULL);");
            sQLiteDatabase.execSQL("DROP TABLE if exists backup_before_notice_language");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS backup_before_notice_language(languageName TEXT NOT NULL,textName TEXT NOT NULL,textValue TEXT NOT NULL);");
        }
        if (i10 > 27) {
            sQLiteDatabase.execSQL("DROP TABLE if exists history_application_distribute");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS history_application_distribute(appId TEXT NOT NULL PRIMARY KEY,status INTEGER DEFAULT 1,time LONG DEFAULT 0);");
        }
        if (i10 > 28) {
            sQLiteDatabase.execSQL("DROP TABLE if exists space_notify_v5_language");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS space_notify_v5_language(languageName TEXT NOT NULL,textName TEXT NOT NULL,textValue TEXT NOT NULL);");
        }
        if (i10 > 29) {
            sQLiteDatabase.execSQL("DROP TABLE if exists hicloud_upgrade_language");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS hicloud_upgrade_language(languageName TEXT NOT NULL,textName TEXT NOT NULL,textValue TEXT NOT NULL);");
            sQLiteDatabase.execSQL("DROP TABLE if exists space_mult_language");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS space_mult_language(language TEXT NOT NULL,name TEXT NOT NULL,value TEXT NOT NULL);");
        }
        if (i10 > 30) {
            sQLiteDatabase.execSQL("DROP TABLE if exists message_desk_popup");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS message_desk_popup(uniqueId TEXT,desktopTitle TEXT,desktopText TEXT,readValidityTime INTEGER DEFAULT 0,remainValidityTime INTEGER DEFAULT 0,notifyTime INTEGER DEFAULT 0,alreadyRead INTEGER DEFAULT 0,resourceInfo TEXT,priority INTEGER DEFAULT 0,trigger TEXT,supportTrigger INTEGER DEFAULT 0,messageId TEXT,desktopGoto TEXT,deskPopupAction INTEGER DEFAULT 0,cfgInstanceId TEXT,secondWindows TEXT,extras TEXT,context TEXT);");
        }
        if (i10 > 31) {
            sQLiteDatabase.execSQL("DROP TABLE if exists message_center");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS message_center(uniqueId TEXT,msgType TEXT NOT NULL,msgGotoType TEXT,msgGotoUri TEXT,mainText TEXT,titleText TEXT,richMsgContent TEXT,needShowBadge INTEGER DEFAULT 0,readValidityTime INTEGER DEFAULT 0,remainValidityTime INTEGER DEFAULT 0,notifyTime INTEGER DEFAULT 0,pictureUrl TEXT,alreadyRead INTEGER DEFAULT 0,category TEXT,resourceInfo TEXT,recommendNeedData TEXT,memberShareDetail TEXT,checkFamilyMember INTEGER DEFAULT 0,notifyId INTEGER DEFAULT 0,agdParameters TEXT,gotoDeeplinkUri TEXT,totalNeedSpace INTEGER DEFAULT 0,introductionH5Url TEXT,notifyType TEXT, context TEXT);");
            sQLiteDatabase.execSQL("DROP TABLE if exists message_desk_popup");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS message_desk_popup(uniqueId TEXT,desktopTitle TEXT,desktopText TEXT,readValidityTime INTEGER DEFAULT 0,remainValidityTime INTEGER DEFAULT 0,notifyTime INTEGER DEFAULT 0,alreadyRead INTEGER DEFAULT 0,resourceInfo TEXT,priority INTEGER DEFAULT 0,trigger TEXT,supportTrigger INTEGER DEFAULT 0,messageId TEXT,desktopGoto TEXT,deskPopupAction INTEGER DEFAULT 0,cfgInstanceId TEXT,secondWindows TEXT,extras TEXT,context TEXT);");
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) throws SQLException {
        C1461a.m8359i("CommonDbHelper", "onUpgrade oldVersion = " + i10 + " newVersion = " + i11);
        if (i10 < 2) {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS upgrade_config_language(languageName TEXT NOT NULL,textName TEXT NOT NULL,textValue TEXT NOT NULL);");
        }
        if (i10 < 3) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS sync_config;");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS sync_config(id TEXT NOT NULL,name TEXT NOT NULL,icon TEXT NOT NULL,iconPath TEXT NOT NULL,record TEXT NOT NULL,recordIndex INTEGER DEFAULT -1,supportServer INTEGER DEFAULT -1,unstructedPath TEXT,unstructedPathObs TEXT,minSyncVersion INTEGER DEFAULT 0,minSyncVersionObs INTEGER DEFAULT 0,subUser TEXT NOT NULL,applications TEXT NOT NULL,notifyType TEXT,forceDelete TEXT,databaseId TEXT,keyType TEXT,fingerPrints TEXT,iconHash TEXT)");
        }
        if (i10 < 4) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS hicloud_actives_language;");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS hicloud_actives_language(languageName TEXT NOT NULL,textName TEXT NOT NULL,textValue TEXT NOT NULL);");
        }
        if (i10 < 5) {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS space_notify_content(notify_type INTEGER NOT NULL,id INTEGER NOT NULL,language TEXT NOT NULL,title TEXT,main_text TEXT,sub_title TEXT,remind_mode TEXT,button_first TEXT,buttonSecond TEXT,description TEXT,description_second TEXT,main_text_second TEXT,content_type TEXT)");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS urgency_policy(id TEXT,scenario TEXT,action TEXT,notice_type,notice TEXT,ontop TEXT,detail TEXT)");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS urgency_notice_info(key TEXT,value TEXT)");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS urgency_language(version TEXT NOT NULL,languageName TEXT NOT NULL,textName TEXT NOT NULL,textValue TEXT NOT NULL);");
        }
        if (i10 < 7) {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS space_notify (time INTEGER NOT NULL,day INTEGER NOT NULL,month INTEGER NOT NULL,year INTEGER NOT NULL,week INTEGER NOT NULL);");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS notify_rule(notifyType TEXT NOT NULL,dataType TEXT NOT NULL,times INTEGER NOT NULL,checkInit INTEGER NOT NULL,lastTimeStamp TEXT NOT NULL);");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS space_notify_content_origin(notify_type INTEGER NOT NULL,id INTEGER NOT NULL,language TEXT NOT NULL,title TEXT,main_text TEXT,sub_title TEXT,remind_mode TEXT,button_first TEXT,buttonSecond TEXT,description TEXT,description_second TEXT,main_text_second TEXT,detail_link TEXT)");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS space_notify_detail(id INTEGER NOT NULL,notice_type TEXT NOT NULL,language TEXT NOT NULL,title TEXT,main_text TEXT,button_first TEXT,user_type TEXT,detail_link TEXT);");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS family_share_language(language TEXT NOT NULL,name TEXT NOT NULL,value TEXT NOT NULL);");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS cloud_space_usage_language(language TEXT NOT NULL,name TEXT NOT NULL,value TEXT NOT NULL)");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS restore_notify(id TEXT NOT NULL,hoursafteroobe TEXT NOT NULL,timesinhours TEXT NOT NULL,firsttrigafter TEXT NOT NULL,starttime TEXT NOT NULL,endtime TEXT NOT NULL,loginstate TEXT NOT NULL,noticetype TEXT NOT NULL,priority TEXT NOT NULL);");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS restore_notify_devices(id TEXT NOT NULL,loginstate TEXT NOT NULL,releasedevice TEXT NOT NULL);");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS restore_notify_language(id TEXT NOT NULL,loginstate TEXT NOT NULL,language TEXT NOT NULL,title TEXT NOT NULL,sub_title TEXT NOT NULL);");
        }
        if (i10 < 8) {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS notice_content_language(languageName TEXT NOT NULL,textName TEXT NOT NULL,textValue TEXT NOT NULL);");
        }
        if (i10 < 9) {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS hicloud_push_guide_language(languageName TEXT NOT NULL,textName TEXT NOT NULL,textValue TEXT NOT NULL);");
        }
        if (i10 < 10) {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS space_notify_frequency(notifyType TEXT NOT NULL,dataType TEXT NOT NULL,times INTEGER NOT NULL,lastTimeStamp TEXT NOT NULL);");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS space_notify_v3_language(languageName TEXT NOT NULL,textName TEXT NOT NULL,textValue TEXT NOT NULL);");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS space_notify_v3_language_local(languageName TEXT NOT NULL,textName TEXT NOT NULL,textValue TEXT NOT NULL);");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS stock_active_config_language(languageName TEXT NOT NULL,textName TEXT NOT NULL,textValue TEXT NOT NULL);");
        }
        if (i10 < 11) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS sync_config;");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS sync_config(id TEXT NOT NULL,name TEXT NOT NULL,icon TEXT NOT NULL,iconPath TEXT NOT NULL,record TEXT NOT NULL,recordIndex INTEGER DEFAULT -1,supportServer INTEGER DEFAULT -1,unstructedPath TEXT,unstructedPathObs TEXT,minSyncVersion INTEGER DEFAULT 0,minSyncVersionObs INTEGER DEFAULT 0,subUser TEXT NOT NULL,applications TEXT NOT NULL,notifyType TEXT,forceDelete TEXT,databaseId TEXT,keyType TEXT,fingerPrints TEXT,iconHash TEXT)");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS h5_config(resourceId TEXT,key TEXT,value TEXT)");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS h5_language_config(language TEXT,name TEXT,value TEXT)");
        }
        if (i10 < 13) {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS hicloud_brand_homepage_banner_language(languageName TEXT NOT NULL,textName TEXT NOT NULL,textValue TEXT NOT NULL);");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS hicloud_brand_buy_banner_language(languageName TEXT NOT NULL,textName TEXT NOT NULL,textValue TEXT NOT NULL);");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS hicloud_scene_homepage_banner_language(languageName TEXT NOT NULL,textName TEXT NOT NULL,textValue TEXT NOT NULL);");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS hicloud_scene_buy_banner_language(languageName TEXT NOT NULL,textName TEXT NOT NULL,textValue TEXT NOT NULL);");
        }
        if (i10 < 14) {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS frequency_control_language(languageName TEXT NOT NULL,textName TEXT NOT NULL,textValue TEXT NOT NULL);");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS freq_control_time(time INTEGER NOT NULL, remind_purpose, remind_method);");
        }
        if (i10 < 15) {
            sQLiteDatabase.execSQL("DROP TABLE if exists freq_control_time;");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS freq_control_time(time INTEGER NOT NULL, remind_purpose, remind_method);");
        }
        if (i10 < 16) {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS hicloud_msg_notice_language(languageName TEXT NOT NULL,textName TEXT NOT NULL,textValue TEXT NOT NULL);");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS message_center(uniqueId TEXT,msgType TEXT NOT NULL,msgGotoType TEXT,msgGotoUri TEXT,mainText TEXT,titleText TEXT,richMsgContent TEXT,needShowBadge INTEGER DEFAULT 0,readValidityTime INTEGER DEFAULT 0,remainValidityTime INTEGER DEFAULT 0,notifyTime INTEGER DEFAULT 0,pictureUrl TEXT,alreadyRead INTEGER DEFAULT 0,category TEXT,resourceInfo TEXT,recommendNeedData TEXT,memberShareDetail TEXT,checkFamilyMember INTEGER DEFAULT 0,notifyId INTEGER DEFAULT 0,agdParameters TEXT,gotoDeeplinkUri TEXT,totalNeedSpace INTEGER DEFAULT 0,introductionH5Url TEXT,notifyType TEXT, context TEXT);");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS message_h5_window(uniqueId TEXT,msgGotoType TEXT,msgGotoUri TEXT,h5DialogAction INTEGER DEFAULT 0,h5DialogUrl TEXT,readValidityTime INTEGER DEFAULT 0,remainValidityTime INTEGER DEFAULT 0,notifyTime INTEGER DEFAULT 0,alreadyRead INTEGER DEFAULT 0,resourceInfo TEXT,agdParameters TEXT,priority INTEGER DEFAULT 0,param TEXT,realtimeParam TEXT,trigger TEXT,supportTrigger INTEGER DEFAULT 0);");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS drive_config;");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS drive_config(id TEXT NOT NULL,appId TEXT NOT NULL,pkgNames TEXT NOT NULL,signHash TEXT NOT NULL,icon TEXT NOT NULL,style TEXT NOT NULL,name TEXT NOT NULL,subPageIcon TEXT,subDesc TEXT,subSwitchDesc TEXT,minSyncVersion INTEGER DEFAULT -1,record TEXT NOT NULL,recordIndex INTEGER DEFAULT -1,version TEXT,iconPath TEXT,subPageIconPath TEXT, subUser TEXT);");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS drive_config_language;");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS drive_config_language(languageName TEXT NOT NULL,textName TEXT NOT NULL,textValue TEXT NOT NULL);");
        }
        if (i10 < 17) {
            m29891c(sQLiteDatabase, "ALTER TABLE message_h5_window ADD COLUMN agdParameters TEXT");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS hicloud_nps_notify_language(languageName TEXT NOT NULL,textName TEXT NOT NULL,textValue TEXT NOT NULL);");
        }
        if (i10 < 18) {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS campaign_notice_language(languageName TEXT NOT NULL,textName TEXT NOT NULL,textValue TEXT NOT NULL);");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS campaign_activity_language(languageName TEXT NOT NULL,textName TEXT NOT NULL,textValue TEXT NOT NULL);");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS campaign_quest_language(languageName TEXT NOT NULL,textName TEXT NOT NULL,textValue TEXT NOT NULL);");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS feature_gray(functionId TEXT,parameters TEXT,status INTEGER DEFAULT 0);");
        }
        if (i10 < 19) {
            m29891c(sQLiteDatabase, "ALTER TABLE sync_config ADD COLUMN fingerPrints TEXT");
        }
        if (i10 < 20) {
            m29891c(sQLiteDatabase, "ALTER TABLE message_h5_window ADD COLUMN priority INTEGER DEFAULT 0");
        }
        if (i10 < 21) {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS text_link_language(languageName TEXT NOT NULL,textName TEXT NOT NULL,textValue TEXT NOT NULL);");
        }
        if (i10 < 22) {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS params_meta(name TEXT,type TEXT,provider TEXT, endpoint TEXT, authType TEXT);");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS hicloud_params_value(id INTEGER PRIMARY KEY AUTOINCREMENT,key TEXT NOT NULL UNIQUE,value TEXT NOT NULL,expireTime BIGINT);");
            m29891c(sQLiteDatabase, "ALTER TABLE message_h5_window ADD COLUMN param TEXT");
            m29891c(sQLiteDatabase, "ALTER TABLE message_h5_window ADD COLUMN realtimeParam TEXT");
            m29891c(sQLiteDatabase, "ALTER TABLE message_h5_window ADD COLUMN trigger INTEGER TEXT");
            m29891c(sQLiteDatabase, "ALTER TABLE message_h5_window ADD COLUMN supportTrigger INTEGER DEFAULT 0");
        }
        if (i10 < 23) {
            m29890b(sQLiteDatabase);
        }
        if (i10 < 24) {
            m29891c(sQLiteDatabase, "ALTER TABLE message_center ADD COLUMN gotoDeeplinkUri TEXT");
            m29891c(sQLiteDatabase, "ALTER TABLE message_center ADD COLUMN totalNeedSpace INTEGER DEFAULT 0");
        }
        if (i10 < 25) {
            m29891c(sQLiteDatabase, "ALTER TABLE message_center ADD COLUMN introductionH5Url TEXT");
        }
        if (i10 < 26) {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS space_notify_v4_language(languageName TEXT NOT NULL,textName TEXT NOT NULL,textValue TEXT NOT NULL);");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS space_notify_v4_language_local(languageName TEXT NOT NULL,textName TEXT NOT NULL,textValue TEXT NOT NULL);");
            m29891c(sQLiteDatabase, "CREATE TABLE IF NOT EXISTS homepage_switch_notice_language(languageName TEXT NOT NULL,textName TEXT NOT NULL,textValue TEXT NOT NULL);");
            m29891c(sQLiteDatabase, "CREATE TABLE IF NOT EXISTS data_upper_limit_language(languageName TEXT NOT NULL,textName TEXT NOT NULL,textValue TEXT NOT NULL);");
            m29891c(sQLiteDatabase, "ALTER TABLE sync_config ADD COLUMN iconHash TEXT");
            m29891c(sQLiteDatabase, "CREATE TABLE IF NOT EXISTS backup_before_notice_language(languageName TEXT NOT NULL,textName TEXT NOT NULL,textValue TEXT NOT NULL);");
            m29891c(sQLiteDatabase, "ALTER TABLE message_center ADD COLUMN notifyType TEXT");
        }
        if (i10 < 27) {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS history_application_distribute(appId TEXT NOT NULL PRIMARY KEY,status INTEGER DEFAULT 1,time LONG DEFAULT 0);");
        }
        if (i10 < 28) {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS space_notify_v5_language(languageName TEXT NOT NULL,textName TEXT NOT NULL,textValue TEXT NOT NULL);");
        }
        if (i10 < 29) {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS hicloud_upgrade_language(languageName TEXT NOT NULL,textName TEXT NOT NULL,textValue TEXT NOT NULL);");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS space_mult_language(language TEXT NOT NULL,name TEXT NOT NULL,value TEXT NOT NULL);");
        }
        if (i10 < 30) {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS message_desk_popup(uniqueId TEXT,desktopTitle TEXT,desktopText TEXT,readValidityTime INTEGER DEFAULT 0,remainValidityTime INTEGER DEFAULT 0,notifyTime INTEGER DEFAULT 0,alreadyRead INTEGER DEFAULT 0,resourceInfo TEXT,priority INTEGER DEFAULT 0,trigger TEXT,supportTrigger INTEGER DEFAULT 0,messageId TEXT,desktopGoto TEXT,deskPopupAction INTEGER DEFAULT 0,cfgInstanceId TEXT,secondWindows TEXT,extras TEXT,context TEXT);");
        }
        if (i10 < 31) {
            m29891c(sQLiteDatabase, "ALTER TABLE message_desk_popup ADD COLUMN secondWindows TEXT");
            m29891c(sQLiteDatabase, "ALTER TABLE message_desk_popup ADD COLUMN extras TEXT");
        }
        if (i10 < 31) {
            m29891c(sQLiteDatabase, "ALTER TABLE message_center ADD COLUMN context TEXT");
            m29891c(sQLiteDatabase, "ALTER TABLE message_desk_popup ADD COLUMN context TEXT");
        }
    }
}
