package nekogochan.functional;

import java.lang.invoke.CallSite;
import java.lang.invoke.LambdaMetafactory;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.util.concurrent.Callable;
import java.util.function.Consumer;

public class Unchecked {
  @FunctionalInterface
  private interface SilentInvokerCallable {
    MethodType SIGNATURE = MethodType.methodType(Object.class, Callable.class);//сигнатура метода INVOKE
    <V> V invoke(final Callable<V> callable);
  }

  private static final SilentInvokerCallable SILENT_INVOKER_CALLABLE;

  static {
    SilentInvokerCallable si = null;
    final MethodHandles.Lookup lookup = MethodHandles.lookup();
    try {
      final CallSite site = LambdaMetafactory.metafactory(lookup,
                                                          "invoke",
                                                          MethodType.methodType(SilentInvokerCallable.class),
                                                          SilentInvokerCallable.SIGNATURE,
                                                          lookup.findVirtual(Callable.class, "call", MethodType.methodType(Object.class)),
                                                          SilentInvokerCallable.SIGNATURE);
      si = (SilentInvokerCallable) site.getTarget().invokeExact();
    } catch (Throwable e) {
      throw new Error();
    }
    SILENT_INVOKER_CALLABLE = si;
  }

  public static <T> T call(Callable<T> callable) {
    return SILENT_INVOKER_CALLABLE.invoke(callable);
  }

  @FunctionalInterface
  public interface ThrowableConsumer<T> {
    void accept(T t) throws Exception;
  }
  @FunctionalInterface
  private interface SilentInvokerConsumer {
    MethodType SIGNATURE = MethodType.methodType(void.class, ThrowableConsumer.class, Object.class);
    <T> void invoke(final ThrowableConsumer<T> consumer, T arg);
  }

  private static final SilentInvokerConsumer SILENT_INVOKER_CONSUMER;

  static {
    SilentInvokerConsumer si = null;
    final MethodHandles.Lookup lookup = MethodHandles.lookup();
    try {
      final CallSite site = LambdaMetafactory.metafactory(lookup,
                                                          "invoke",
                                                          MethodType.methodType(SilentInvokerConsumer.class),
                                                          SilentInvokerConsumer.SIGNATURE,
                                                          lookup.findVirtual(ThrowableConsumer.class, "accept", MethodType.methodType(void.class, Object.class)),
                                                          SilentInvokerConsumer.SIGNATURE);
      si = (SilentInvokerConsumer) site.getTarget().invokeExact();
    } catch (Throwable e) {
      e.printStackTrace();
      throw new Error();
    }
    SILENT_INVOKER_CONSUMER = si;
  }

  public static <T> Consumer<T> call(ThrowableConsumer<T> consumer) {
    return arg -> SILENT_INVOKER_CONSUMER.invoke(consumer, arg);
  }
}
