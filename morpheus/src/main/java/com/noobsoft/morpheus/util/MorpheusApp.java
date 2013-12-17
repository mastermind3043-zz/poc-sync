package com.noobsoft.morpheus.util;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.noobsoft.morpheus.rest.UserRestService;

@ApplicationPath("/rest/*")
public class MorpheusApp extends Application
{
    private Set<Object> singletons = new HashSet();
    private Set<Class<?>> empty = new HashSet();

    public MorpheusApp() {
        // ADD YOUR RESTFUL RESOURCES HERE
        this.singletons.add(new UserRestService());
    }

    public Set<Class<?>> getClasses()
    {
        return this.empty;
    }

    public Set<Object> getSingletons()
    {
        return this.singletons;
    }
}
