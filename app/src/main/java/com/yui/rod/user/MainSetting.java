package com.yui.rod.user;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * @description SharedPreferences轻量级存储类，适合于保存软件配置参数
 * @author shao
 * @date 2019-12-18下午3:19:12
 */
public class MainSetting {

    protected static final String TAG = MainSetting.class.getSimpleName();

    /** 保存数据的xml文件名 */
    private static final String SETTING_FINE_NAME = "MainSetting";

    /** 应用第一次启动 */
    private static final String APP_OPEN_FIRST = "AppOpenFirst";
    /** 应用第一次启动 */
    private static final String GUIDE_OPEN_FIRST = "GuideViewOpenFirst";
    /** 主页第一次启动 */
    private static final String HOME_OPEN_FIRST = "HomeOpenFirst";
    /** 最近一次启动应用的时间 */
    private static final String APP_OPEN_RECENT = "AppOpenRecent";
    /** 用户标识 */
    private static final String OPEN_ID = "OpenId";
    /** 邀请码 */
    private static final String INVITE_CODE = "InviteCode";
    /** 应用版本名 */
    private static final String APP_VERSION = "AppVersion";


    /**
     * @description 构造函数
     * @author hua.xu
     * @date 2015-6-19下午3:37:26
     */
    public MainSetting() {
    }

    /** 应用是否为第一次启动 */
    public static boolean getAppOpenFirst(Context context) {
        return getBoolean(context, APP_OPEN_FIRST, true);
    }

    /** 应用是否为第一次启动 */
    public static void setAppOpenFirst(Context context, boolean isOpenFirst) {
        setBoolean(context, APP_OPEN_FIRST, isOpenFirst);
    }

    /** 引导页蒙版是否为第一次启动 */
    public static boolean getGuideViewOpenFirst(Context context) {
        return getBoolean(context, GUIDE_OPEN_FIRST, true);
    }

    /** 引导页蒙版是否为第一次启动 */
    public static void setGuideViewOpenFirst(Context context, boolean isOpenFirst) {
        setBoolean(context, GUIDE_OPEN_FIRST, isOpenFirst);
    }
    /** 主页是否为第一次启动 */
    public static boolean getHomeOpenFirst(Context context) {
        return getBoolean(context, HOME_OPEN_FIRST, true);
    }
    /** 主页蒙版是否为第一次启动 */
    public static void setHomeOpenFirst(Context context, boolean isHomeOpenFirst) {
        setBoolean(context, HOME_OPEN_FIRST, isHomeOpenFirst);
    }
    /** 最近一次启动应用的时间 */
    public static long getAppOpenRecent(Context context) {
        return getLong(context, APP_OPEN_RECENT, 0);
    }

    /** 最近一次启动应用的时间 */
    public static void setAppOpenRecent(Context context, long time) {
        setLong(context, APP_OPEN_RECENT, time);
    }

    /** 用户标识 */
    public static String getOpenId(Context context) {
        return getString(context, OPEN_ID, "");
    }

    /** 用户标识 */
    public static void setOpenId(Context context, String openId) {
        setString(context, OPEN_ID, openId);
    }

    /** 邀请码 */
    public static String getInviteCode(Context context) {
        return getString(context, INVITE_CODE, "");
    }

    /** 邀请码 */
    public static void setInviteCode(Context context, String inviteCode) {
        setString(context, INVITE_CODE, inviteCode);
    }

    /** 应用版本名 */
    public static String getAppVersion(Context context) {
        return getString(context, APP_VERSION, "");
    }

    /** 应用版本名 */
    public static void setAppVersion(Context context, String version) {
        setString(context, APP_VERSION, version);
    }

    public static void setValue(Context context, String key , String v )
    {
        setString(context, key, v);
    }
    public static String getValue(Context context, String key)
    {
        return getString(context,key,"");
    }

    public static String getValue(Context context, String key, String def)
    {
        return getString(context,key,def);
    }


    public static void removeKey(Context conext , String key)
    {
        remove(conext,key);
    }
    /**
     * @description 清空SharedPreferences文件
     * @author hua.xu
     * @date 2015-6-19下午3:37:52
     * @param context
     */
    public static void clear(Context context) {
        SharedPreferences.Editor editor = getSP(context).edit();

        String v = getAppVersion(context);
        editor.clear();
        editor.commit();

        setAppVersion(context,v);
        //PalLog.d(TAG, "Clear SharedPreferences!");
    }

    // --------------------------------------------内部公用方法-------------------------------------------------//

    /**
     * @description 获取SharedPreferences接口
     * @author hua.xu
     * @date 2015-6-19下午3:37:55
     * @param context
     * @return SharedPreferences
     */
    private static SharedPreferences getSP(Context context) {
        SharedPreferences sp = context.getSharedPreferences(SETTING_FINE_NAME, Context.MODE_PRIVATE);
        return sp;
    }

    private static String getString(Context context, String key, String defValue) {
        return getSP(context).getString(key, defValue);
    }


    private static boolean getBoolean(Context context, String key, boolean defValue) {
        return getSP(context).getBoolean(key, defValue);
    }

    private static int getInt(Context context, String key, int defValue) {
        return getSP(context).getInt(key, defValue);
    }

    private static float getFloat(Context context, String key, float defValue) {
        return getSP(context).getFloat(key, defValue);
    }

    private static long getLong(Context context, String key, long defValue) {
        return getSP(context).getLong(key, defValue);
    }


    private static void remove(Context context, String key)
    {
        SharedPreferences.Editor editor = getSP(context).edit();
        editor.remove(key);
        editor.commit();
    }
    private static void setString(Context context, String key, String value) {
        SharedPreferences.Editor editor = getSP(context).edit();
        editor.putString(key, value);
        editor.commit();
    }

    private static void setBoolean(Context context, String key, boolean value) {
        SharedPreferences.Editor editor = getSP(context).edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

    private static void setInt(Context context, String key, int value) {
        SharedPreferences.Editor editor = getSP(context).edit();
        editor.putInt(key, value);
        editor.commit();
    }

    private static void setFloat(Context context, String key, float value) {
        SharedPreferences.Editor editor = getSP(context).edit();
        editor.putFloat(key, value);
        editor.commit();
    }

    private static void setLong(Context context, String key, long value) {
        SharedPreferences.Editor editor = getSP(context).edit();
        editor.putLong(key, value);
        editor.commit();
    }

}
