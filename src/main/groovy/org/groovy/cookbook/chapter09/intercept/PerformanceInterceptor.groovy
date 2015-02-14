package org.groovy.cookbook.chapter09.intercept

import groovy.util.logging.Slf4j

@Slf4j
class PerformanceInterceptor implements Interceptor {
    private Long start = 0

    @Override
    Object beforeInvoke(Object object, String methodName, Object[] arguments) {
        start = System.currentTimeMillis()
        null
    }

    @Override
    Object afterInvoke(Object object, String methodName, Object[] arguments, Object result) {
        long spentTime = System.currentTimeMillis() - start
        log.debug("Execution time for method ${methodName}: ${spentTime}ms.")
        result
    }

    @Override
    boolean doInvoke() {
        true
    }
}
