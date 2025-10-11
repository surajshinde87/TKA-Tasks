package com.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@ComponentScan("com.entity")
@ComponentScan("com.aspect")
@EnableAspectJAutoProxy
public class ConfigClass {

}
