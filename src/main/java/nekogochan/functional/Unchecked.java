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


  @FunctionalInterface
  public interface ThrowableConsumer<T> {
    void accept() throws Exception;
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

  @FunctionalInterface
  public interface ThrowableRunnable {
    MethodType SIGNATURE = MethodType.methodType(void.class);
    void call() throws Exception;
  }
  @FunctionalInterface
  private interface SilentInvokerRunnable {
    MethodType SIGNATURE = MethodType.methodType(void.class, ThrowableRunnable.class);
    void invoke(ThrowableRunnable fn);
  }

  private static final SilentInvokerRunnable SILENT_INVOKER_RUNNABLE;

  static {
    SilentInvokerRunnable si = null;
    final MethodHandles.Lookup lookup = MethodHandles.lookup();
    try {
      final CallSite site = LambdaMetafactory.metafactory(lookup,
                                                          "call",
                                                          MethodType.methodType(SilentInvokerRunnable.class),
                                                          SilentInvokerRunnable.SIGNATURE,
                                                          lookup.findVirtual(ThrowableRunnable.class, "call", ThrowableRunnable.SIGNATURE),
                                                          SilentInvokerRunnable.SIGNATURE);
      si = (SilentInvokerRunnable) site.getTarget().invokeExact();
    } catch (Throwable e) {
      e.printStackTrace();
      throw new Error();
    }
    SILENT_INVOKER_RUNNABLE = si;
  }

  public static void call(ThrowableRunnable fn) {
    SILENT_INVOKER_RUNNABLE.invoke(fn);
  }
}
