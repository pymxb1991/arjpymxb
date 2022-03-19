package handle;

import strategy.DataProcess;

public class Community implements DataProcess {

    public void pushData() {
        System.out.println("智慧村庄处理逻辑");
    }

    public void afterPropertiesSet() throws Exception {

    }
}
