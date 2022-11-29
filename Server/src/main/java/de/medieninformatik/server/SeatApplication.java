package de.medieninformatik.server;

import jakarta.ws.rs.core.Application;

import java.util.HashSet;
import java.util.Set;

public class SeatApplication extends Application {
    private Set<Object> singletons = new HashSet<>();
    private Set<Class<?>> classes = new HashSet<>();

    public SeatApplication(){
        singletons.add(new SeatRest());
        classes.add(SeatRest.class);
    }

    @Override
    public Set<Class<?>> getClasses(){ return classes; }

    @Override
    public Set<Object> getSingletons() { return singletons; }}
