package com.taobao.luaview.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Documented
@TypeQualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface Nonnull {
    When when() default When.ALWAYS;

    public static class Checker implements TypeQualifierValidator<Nonnull> {
        public Checker() {
        }

        public When forConstantValue(Nonnull qualifierqualifierArgument, Object value) {
            return value == null?When.NEVER:When.ALWAYS;
        }
    }
}
