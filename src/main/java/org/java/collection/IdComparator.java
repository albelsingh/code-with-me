package org.java.collection;

import java.util.Comparator;

public class IdComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        if(s1.getId()<s2.getId())
            return -1;
        else if (s1.getId()>s2.getId()) {
            return 1;
        }
        return s1.getName().compareTo(s2.getName());
    }
}
