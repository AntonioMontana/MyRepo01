package org.othla.maven.plugin.swagger.model;

import java.net.URL;

import org.apache.maven.model.FileSet;

public class ResourceEntry
{
   private FileSet fileset;
   private URL url;
   private DependencyResource dependencyResource;

   public FileSet getFileset() {
      return fileset;
   }

   public void setFileset(FileSet fileset) {
      this.fileset = fileset;
   }

   public URL getUrl() {
      return url;
   }

   public void setUrl(URL url) {
      this.url = url;
   }

   public DependencyResource getDependencyResource() {
      return dependencyResource;
   }

   public void setDependencyResource(DependencyResource dependencyResource) {
      this.dependencyResource = dependencyResource;
   }

   @Override
   public String toString() {
      if (getFileset() != null) {
         return getFileset().toString();
      } else if (getUrl() != null) {
         return "URL { " + getUrl().toString() + "}";
      } else if (getDependencyResource() != null) {
         return getDependencyResource().toString();
      } else {
         return "Empty resource entry {}";
      }
   }
}
