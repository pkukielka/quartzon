package com.pkukielka.quartzon.job;

import java.util.ArrayList;
import java.util.List;

public class JobDataMap {
    protected List<Entry> entry;

    public List<Entry> getEntry() {
        if (entry == null) {
            entry = new ArrayList<Entry>();
        }

        return this.entry;
    }

    public void setEntry(List<Entry> entry) {
        this.entry = entry;
    }
}
