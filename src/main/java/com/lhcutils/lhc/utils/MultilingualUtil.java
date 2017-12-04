package com.lhcutils.lhc.utils;

import android.content.Context;
import android.os.Build;

import java.util.Locale;

/**
 * Created by mengyunfeng on 17/12/4.
 */

public class MultilingualUtil {
    public static Locale getCurrentLocale(Context pContext) {
        Locale _Locale;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) { //7.0有多语言设置获取顶部的语言
            _Locale = pContext.getResources().getConfiguration().getLocales().get(0);
        } else {
            _Locale = pContext.getResources().getConfiguration().locale;
        }
        return _Locale;
    }
}
