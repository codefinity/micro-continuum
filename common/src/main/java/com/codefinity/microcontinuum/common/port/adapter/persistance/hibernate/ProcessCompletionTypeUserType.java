package com.codefinity.microcontinuum.common.port.adapter.persistance.hibernate;

import com.codefinity.microcontinuum.common.domain.model.process.Process.ProcessCompletionType;

public class ProcessCompletionTypeUserType extends EnumUserType<ProcessCompletionType> {
    public ProcessCompletionTypeUserType() {
        super(ProcessCompletionType.class);
    }
}
