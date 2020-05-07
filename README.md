# spark-java-testapp
A simple test application using SparkJava

To use the auto-instrumentation agent, you'll need to run the Main.java class with the following command line switch:

`-javaagent:opentelemetry-auto-0.2.2.jar`

Also, you'll need to provide the following env vars:
OTA_INTEGRATION_SPARKJAVA_ENABLED=true
OTA_INTEGRATION_JETTY_ENABLED=true
OTA_EXPORTER_NEWRELIC_API_KEY=<apikeygoeshere>
OTA_EXPORTER_JAR=opentelemetry-exporters-newrelic-auto-0.3.1-SNAPSHOT.jar
OTEL_RESOURCE_ATTRIBUTES=service.name\=spark-tester-auto

Note: If you actually want to report data, the API Key will need to be a valid Insights Insert Key, 
but you can get everything initialized as long as it's set to something non-blank.
