package com.pkukielka.quartzon;

public class ProcessingDirectives {
    protected Boolean overwriteExistingData;
    protected Boolean ignoreDuplicates;

    public Boolean getOverwriteExistingData() {
        return overwriteExistingData;
    }

    public void setOverwriteExistingData(Boolean overwriteExistingData) {
        this.overwriteExistingData = overwriteExistingData;
    }

    public Boolean getIgnoreDuplicates() {
        return ignoreDuplicates;
    }

    public void setIgnoreDuplicates(Boolean ignoreDuplicates) {
        this.ignoreDuplicates = ignoreDuplicates;
    }
}
