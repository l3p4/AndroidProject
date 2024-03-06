package com.ixuea.courses.mymusic.Util;

import java.util.Calendar;

public class SuperDateUtil {
    /**
     *
     * @return
     */
    public static int currentYear(){
        return Calendar.getInstance().get(Calendar.YEAR);
    }
}
