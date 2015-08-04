package org.othla.maven.plugin.swagger.codegen;

import org.apache.maven.plugin.logging.Log;
import org.zalando.stups.swagger.codegen.CodegeneratorLogger;

public class MojoCodegeneratorLogger implements CodegeneratorLogger
{
   private final Log delegate;

   public MojoCodegeneratorLogger(final Log delegate) {
      this.delegate = delegate;
   }

   public void info(String message) {
      this.delegate.info(message);
   }

}
