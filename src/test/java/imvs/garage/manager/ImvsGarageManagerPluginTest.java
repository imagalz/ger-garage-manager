/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package imvs.garage.manager;

import org.gradle.testfixtures.ProjectBuilder;
import org.gradle.api.Project;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * A simple unit test for the 'imvs.garage.manager.greeting' plugin.
 */
public class ImvsGarageManagerPluginTest {
    @Test public void pluginRegistersATask() {
        // Create a test project and apply the plugin
        Project project = ProjectBuilder.builder().build();
        project.getPlugins().apply("imvs.garage.manager.greeting");

        // Verify the result
        assertNotNull(project.getTasks().findByName("greeting"));
    }
}