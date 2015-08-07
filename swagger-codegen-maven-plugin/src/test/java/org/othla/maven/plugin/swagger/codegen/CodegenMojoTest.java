package org.othla.maven.plugin.swagger.codegen;

import static org.junit.Assert.*;

import java.io.File;

import org.apache.maven.plugin.testing.MojoRule;
import org.apache.maven.plugin.testing.WithoutMojo;
import org.junit.Rule;
import org.junit.Test;
import org.othla.maven.plugin.swagger.codegen.CodeGenMojo;

public class CodegenMojoTest
{
	@Rule
	public MojoRule rule = new MojoRule()
	{
		@Override
		protected void before() throws Throwable
		{
		}

		@Override
		protected void after()
		{
		}
	};

	/**
	 * @throws Exception
	 *            if any
	 */
	@Test
	public void testSomething() throws Exception
	{
		File pom = new File("src/test/resources/pom.xml");
		assertNotNull(pom);
		assertTrue(pom.exists());

		CodeGenMojo myMojo = (CodeGenMojo) rule.lookupMojo("codegen", pom);
		assertNotNull(myMojo);
		myMojo.execute();

	}

	/** Do not need the MojoRule. */
	@WithoutMojo
	@Test
	public void testSomethingWhichDoesNotNeedTheMojoAndProbablyShouldBeExtractedIntoANewClassOfItsOwn()
	{
	}
}
