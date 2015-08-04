package org.othla.maven.plugin.swagger;

import java.util.List;

import org.apache.maven.artifact.factory.ArtifactFactory;
import org.apache.maven.artifact.metadata.ArtifactMetadataSource;
import org.apache.maven.artifact.repository.ArtifactRepository;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugins.annotations.Component;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;
import org.apache.maven.project.MavenProjectBuilder;
import org.eclipse.aether.impl.ArtifactResolver;
import org.sonatype.plexus.build.incremental.BuildContext;

@SuppressWarnings("deprecation")
public abstract class AbstractCodeGenMojo extends AbstractMojo
{
   @Component
   private MavenProject project;

   @Component
   private ArtifactResolver artifactResolver;

   @Component
   private ArtifactMetadataSource artifactMetadataSource;

   @Component
   private ArtifactFactory artifactFactory;

   @Parameter(defaultValue = "${localRepository}", required = true)
   private ArtifactRepository localRepository;

   /**
    * Artifact factory, needed to download source jars.
    */
   @Component(role = org.apache.maven.project.MavenProjectBuilder.class)
   private MavenProjectBuilder mavenProjectBuilder;

   @Component
   private BuildContext buildContext;

   @Parameter(defaultValue = "${plugin.artifacts}", required = true)
   private List<org.apache.maven.artifact.Artifact> pluginArtifacts;

   public MavenProject getProject() {
      return project;
   }

   public void setProject(MavenProject project) {
      this.project = project;
   }

   public ArtifactResolver getArtifactResolver() {
      return artifactResolver;
   }

   public void setArtifactResolver(ArtifactResolver artifactResolver) {
      this.artifactResolver = artifactResolver;
   }

   public ArtifactMetadataSource getArtifactMetadataSource() {
      return artifactMetadataSource;
   }

   public void setArtifactMetadataSource(ArtifactMetadataSource artifactMetadataSource) {
      this.artifactMetadataSource = artifactMetadataSource;
   }

   public ArtifactFactory getArtifactFactory() {
      return artifactFactory;
   }

   public void setArtifactFactory(ArtifactFactory artifactFactory) {
      this.artifactFactory = artifactFactory;
   }

   public ArtifactRepository getLocalRepository() {
      return localRepository;
   }

   public void setLocalRepository(ArtifactRepository localRepository) {
      this.localRepository = localRepository;
   }

   public MavenProjectBuilder getMavenProjectBuilder() {
      return mavenProjectBuilder;
   }

   public void setMavenProjectBuilder(MavenProjectBuilder mavenProjectBuilder) {
      this.mavenProjectBuilder = mavenProjectBuilder;
   }

   public BuildContext getBuildContext() {
      return buildContext;
   }

   public void setBuildContext(BuildContext buildContext) {
      this.buildContext = buildContext;
   }

   public List<org.apache.maven.artifact.Artifact> getPluginArtifacts() {
      return pluginArtifacts;
   }

   public void setPluginArtifacts(List<org.apache.maven.artifact.Artifact> pluginArtifacts) {
      this.pluginArtifacts = pluginArtifacts;
   }

}
