package io.sam;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhuweimu
 * @Classname MainTest01
 * @Description
 * @Date 2020/8/7 11:28
 */
public class MainTest01 {

    @Test
    public void test01(){
        //创建java对象

        Hotel hotel=new Hotel();
        hotel.setId(1);
        hotel.setName("name1");

        RoomTypeVO t1=new RoomTypeVO();
        t1.setPrice("20");
        t1.setTypeid(1);
        t1.setTypename("typename1");

        RoomTypeVO t2=new RoomTypeVO();
        t2.setPrice("30");
        t2.setTypeid(2);
        t2.setTypename("typename2");


        List<RoomTypeVO> RoomTypeVOs=new ArrayList<RoomTypeVO>();
        RoomTypeVOs.add(t1);
        RoomTypeVOs.add(t2);
        hotel.setRoomTypeVOs(RoomTypeVOs);


        //将java对象转换为XML字符串
        JaxbUtil requestBinder = new JaxbUtil(Hotel.class,
                JaxbUtil.CollectionWrapper.class);
        String retXml = requestBinder.toXml(hotel, "utf-8");
        System.out.println("xml:"+retXml);
    }
}
