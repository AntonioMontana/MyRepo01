package org.othla.maven.plugin.swagger.codegen;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.plugins.annotations.ResolutionScope;
import org.othla.maven.plugin.swagger.codegen.model.ResourceEntry;
import org.zalando.stups.swagger.codegen.CodegenerationException;
import org.zalando.stups.swagger.codegen.StandaloneCodegenerator;
import org.zalando.stups.swagger.codegen.StandaloneCodegenerator.CodegeneratorBuilder;

@Mojo(name = "codegen", defaultPhase = LifecyclePhase.GENERATE_SOURCES, requiresProject = true, threadSafe = true, requiresDependencyResolution = ResolutionScope.COMPILE)
public class CodeGenMojo extends AbstractCodeGenMojo
{

   @Parameter(required = true, defaultValue = "${project.build.directory}/generated-sources/swagger")
   private File generateDirectory;

   @Parameter(required = true)
   private ResourceEntry inputSpec;

   @Parameter(required = true)
   private String language;

   @Parameter(defaultValue = "io.swagger.api")
   private String apiPackage;

   @Parameter(defaultValue = "io.swagger.model")
   private String modelPackage;

   @Parameter(defaultValue = "true")
   private boolean addCompileSourceRoot;

   @Parameter(defaultValue = "false")
   private boolean skipModelgeneration;

   @Parameter(defaultValue = "false")
   private boolean skipApigeneration;

   @Parameter
   private ArrayList<String> excludedModels = new ArrayList<String>();

   public File getGenerateDirectory() {
      return generateDirectory;
   }

   public void setGenerateDirectory(File generateDirectory) {
      this.generateDirectory = generateDirectory;
   }

   public ResourceEntry getInputSpec() {
      return inputSpec;
   }

   public void setInputSpec(ResourceEntry inputSpec) {
      this.inputSpec = inputSpec;
   }

   public String getLanguage() {
      return language;
   }

   public void setLanguage(String language) {
      this.language = language;
   }

   public String getApiPackage() {
      return apiPackage;
   }

   public void setApiPackage(String apiPackage) {
      this.apiPackage = apiPackage;
   }

   public String getModelPackage() {
      return modelPackage;
   }

   public void setModelPackage(String modelPackage) {
      this.modelPackage = modelPackage;
   }

   public boolean isAddCompileSourceRoot() {
      return addCompileSourceRoot;
   }

   public void setAddCompileSourceRoot(boolean addCompileSourceRoot) {
      this.addCompileSourceRoot = addCompileSourceRoot;
   }

   public boolean isSkipModelgeneration() {
      return skipModelgeneration;
   }

   public void setSkipModelgeneration(boolean skipModelgeneration) {
      this.skipModelgeneration = skipModelgeneration;
   }

   public boolean isSkipApigeneration() {
      return skipApigeneration;
   }

   public void setSkipApigeneration(boolean skipApigeneration) {
      this.skipApigeneration = skipApigeneration;
   }

   public ArrayList<String> getExcludedModels() {
      return excludedModels;
   }

   public void setExcludedModels(ArrayList<String> excludedModels) {
      this.excludedModels = excludedModels;
   }

   public void execute() throws MojoExecutionException, MojoFailureException {
      cleanPackageDirectory(this.generateDirectory);

      CodegeneratorBuilder builder = StandaloneCodegenerator.builder()
            .forLanguage(this.language)
            .writeResultsTo(this.generateDirectory)
            .withApiPackage(this.apiPackage)
            .withModelPackage(this.modelPackage)
            .withLogger(new MojoCodegeneratorLogger(getLog()))
            .skipModelgeneration(this.skipModelgeneration)
            .skipApigeneration(this.skipApigeneration)
            .withModelsExcluded(this.excludedModels);
      
        for (File apiFile : generateApiFilePaths(this.inputSpec)) {
            StandaloneCodegenerator generator = builder.withApiFile(apiFile).build();

            try {
                generator.generate();
            } catch (CodegenerationException e) {
                getLog().error("Code generation error!!!", e);
            }
        }
   }

   public Set<File> generateApiFilePaths(ResourceEntry resouceEntry) {
      Set<File> apiFileSet = new LinkedHashSet<File>();
      
      return apiFileSet;
   }
}
