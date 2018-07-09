package com.ioc.artwork;

import com.ioc.beanfactory.Oracle;
import org.springframework.stereotype.Service;

@Service("oracle")
public class Bookworm implements Oracle {
    @Override
    public String defineMeaningOfLife() {
        return "Encyclopedias is the waste of money - use the Internet!";
    }
}
