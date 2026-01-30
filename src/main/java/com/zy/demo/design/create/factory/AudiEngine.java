package com.zy.demo.design.create.factory;

/**
 * AudiEngine
 *
 * @author zy
 */
public class AudiEngine implements Engine {
    @Override
    public void install() {
        System.out.println("AudiEngine install");
    }
}
