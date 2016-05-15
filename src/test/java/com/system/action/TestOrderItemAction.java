package com.system.action;

import com.system.GenericTest;
import com.system.entity.OrderItem;
import com.system.entity.Schedule;
import com.system.service.OrderItemService;
import com.system.service.ScheduleService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Created by king on 2016/5/10.
 */
public class TestOrderItemAction extends GenericTest{

    private static final Logger LOGGER = Logger.getLogger(TestOrderItemAction.class);

    @Autowired
    private OrderItemService orderItemService;

    @Autowired
    private ScheduleService scheduleService;

    @Test
    public void testDate(){
        Date date = new Date(System.currentTimeMillis());
        LOGGER.info("date:"+date+" ;"+date.getTime());
        Time time = new Time(System.currentTimeMillis());
        LOGGER.info("time:"+time+" ;"+time.getTime());
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        LOGGER.info("timestamp:"+timestamp+" ;"+timestamp.getTime());
        LOGGER.info("System.currentTimeMillis():"+System.currentTimeMillis());
    }

    @Test
    public void test(){
        OrderItem orderItem = orderItemService.get("orderitem1462797744041");
        Schedule schedule = scheduleService.get(1);

        Date date = schedule.getDate();
        Time time = orderItem.getTiming();

        LOGGER.info("date:"+date+" ;"+date.getTime());
        LOGGER.info(new Timestamp(date.getTime()));
        LOGGER.info("time:"+time+" ;"+time.getTime());
        LOGGER.info(new Timestamp(time.getTime()));
        LOGGER.info(new Timestamp(date.getTime() + time.getTime()));

        LOGGER.info(date.getTime() + time.getTime());

        String dateStr = date.toString()+" "+time.toString();
        LOGGER.info("dataStr:" + dateStr);

//        String dateStr = "2016-04-21 12:00:00";
        java.util.Date d = new java.util.Date();
        //注意format的格式要与日期String的格式相匹配
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            d = sdf.parse(dateStr);
            LOGGER.info("d:"+d+" ;"+d.getTime());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCheckTime(){
        long dayMillis = 86400000;

        Date date = new Date(System.currentTimeMillis() + dayMillis);
        LOGGER.info("date:"+date+" ;"+date.getTime());
        Time time = new Time(System.currentTimeMillis() + dayMillis + 500);
        LOGGER.info("time:"+time+" ;"+time.getTime());

        String dateStr = date.toString()+" "+time.toString();
        LOGGER.info("dateStr:"+dateStr);

        java.util.Date d = new java.util.Date();
        //注意format的格式要与日期String的格式相匹配
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            d = sdf.parse(dateStr);
//            LOGGER.info(d.getTime());
            if(d.getTime() >= (System.currentTimeMillis() + dayMillis)){
                LOGGER.info("true");
                return ;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        LOGGER.info("false");
        return ;
    }

}
