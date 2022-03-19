package strategy;

import org.springframework.beans.factory.InitializingBean;

public interface DataProcess extends InitializingBean {
    void pushData();
}
