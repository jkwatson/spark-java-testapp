package com.newrelic.telemetry.sample;

import static spark.Spark.get;

import io.opentelemetry.OpenTelemetry;
import io.opentelemetry.context.Scope;
import io.opentelemetry.trace.Span;
import io.opentelemetry.trace.Tracer;
import java.util.Random;

public class Main {
  public static void main(String[] args) {

    get("/hello", (request, response) -> {
      Tracer tracer = OpenTelemetry.getTracerProvider().get("spark-sample-app");
      Span innerSpan = tracer.spanBuilder("innerSpan").startSpan();
      try (Scope ignored = tracer.withSpan(innerSpan)) {
        Thread.sleep(new Random().nextInt(100));
        return "Hello, World";
      } finally {
        innerSpan.end();
      }
    });

  }
}
