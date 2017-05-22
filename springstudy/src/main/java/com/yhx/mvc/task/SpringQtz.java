package com.yhx.mvc.task;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017-05-22.
 */
public class SpringQtz {
    private static int counter = 0;
    protected void execute()  {
       // long ms = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("\t\t" + sdf.format(new Date()));
        System.out.println("(" + counter++ + ")");
    }
}