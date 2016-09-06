package org.sora.fx.beans;

import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: Serger
 * Date: 25.08.2016
 * Time: 15:01
 */
@Component("test")
public class TestBean implements Test {
    public String test() {
        return "Test";
    }
}
