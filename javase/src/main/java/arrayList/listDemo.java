package arrayList;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class listDemo {


    public static void main(String[] args) {
        List<DeviceFocus> deviceFocusList = new ArrayList<>();
        DeviceFocus deviceFocu1 = new DeviceFocus("123","11111","1");
        DeviceFocus deviceFocu2 = new DeviceFocus("123","22222","2");
        DeviceFocus deviceFocu3 = new DeviceFocus("123","33333","3");
        DeviceFocus deviceFocu4 = new DeviceFocus("123","44444","4");
        DeviceFocus deviceFocu5 = new DeviceFocus("123","55555","5");
        deviceFocusList.add(deviceFocu1);
        deviceFocusList.add(deviceFocu2);
        deviceFocusList.add(deviceFocu3);
        deviceFocusList.add(deviceFocu4);
        deviceFocusList.add(deviceFocu5);
        List<DeviceVO> objectPageInfo = new ArrayList<>();
        DeviceVO deviceVO1 = new DeviceVO("dev1","192.168.1.1","11111");
        DeviceVO deviceVO2 = new DeviceVO("dev1","192.168.1.1","33333");
        DeviceVO deviceVO3 = new DeviceVO("dev1","192.168.1.1","22222");
        DeviceVO deviceVO4 = new DeviceVO("dev1","192.168.1.1","66666");
        DeviceVO deviceVO5 = new DeviceVO("dev1","192.168.1.1","77777");
        objectPageInfo.add(deviceVO1);
        objectPageInfo.add(deviceVO2);
        objectPageInfo.add(deviceVO3);


        List<DeviceVO> deviceVOList = objectPageInfo.stream().
                filter(deviceVO-> deviceFocusList.stream().
                                    map(deviceFocus -> deviceFocus.getDeviceId())
                                    .collect(Collectors.toList()).contains(deviceVO.getId())).
                collect(Collectors.toList());
 /*       for (DeviceVO deviceVO:deviceVOList){
            System.out.println(deviceVO);
        }*/
        List<DeviceVO> deviceVOList2 = objectPageInfo.stream()
                .filter(deviceVO-> deviceFocusList.stream()
                        .map(deviceFocus -> deviceFocus.getDeviceId())
                        .collect(Collectors.toList())
                        .contains(deviceVO.getId()))
                .collect(Collectors.toList());

        for (DeviceVO deviceVO:deviceVOList2){
            System.out.println(deviceVO);
        }
    }

}
