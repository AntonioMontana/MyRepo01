package org.othla.maven.plugin.swagger.model;

import org.apache.maven.artifact.Artifact;
import org.apache.maven.model.Dependency;

public class DependencyResource extends Dependency
{
   private static final long serialVersionUID = -175911612892307121L;

   private String resource;

   public String getResource() {
      return resource;
   }

   public void setResource(String resource) {
      this.resource = resource;
   }

   public DependencyResource() {
      setScope(Artifact.SCOPE_RUNTIME);
   }

   public String toString() {
      return "Dependency {groupId=" + getGroupId() 
            + ", artifactId=" + getArtifactId() 
            + ", version=" + getVersion() 
            + ", type=" + getType() 
            + ", classifier="  + getClassifier() 
            + ", resource=" + getResource() + "}";
   }
}
