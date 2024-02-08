package com.springcore.StandaloneCollections;

import java.util.*;

public class Person {
    private List<String> friends;
    private Map<String, Integer> feesStructure;
    private Properties properties;

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public Map<String, Integer> getFeesStructure() {
        return feesStructure;
    }

    public void setFeesStructure(Map<String, Integer> feesStructure) {
        this.feesStructure = feesStructure;
    }

    public List<String> getFriends() {
        return friends;
    }

    public void setFriends(List<String> friends) {
        this.friends = friends;
    }

    @Override
    public String toString() {
        return "Person [friends=" + friends + ", feesStructure=" + feesStructure + ", properties=" + properties + "]";
    }

    
    
}
