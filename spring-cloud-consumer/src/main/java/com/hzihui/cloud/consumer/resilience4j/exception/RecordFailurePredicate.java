package com.hzihui.cloud.consumer.resilience4j.exception;

import org.springframework.stereotype.Component;

import java.util.function.Predicate;

/**
 * @author HZI.HUI
 * @date 2019/9/11 16:30
 */
@Component
public class RecordFailurePredicate implements Predicate<Throwable> {
    @Override
    public boolean test(Throwable throwable) {
        String message = throwable.getMessage();
        System.out.println(message);
        return true;
    }
}
