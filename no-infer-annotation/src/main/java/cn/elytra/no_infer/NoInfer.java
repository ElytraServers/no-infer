package cn.elytra.no_infer;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/// Lambdas annotated with [NoInfer] expects their generic argument types to be explicitly marked.
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.SOURCE)
public @interface NoInfer {
}
