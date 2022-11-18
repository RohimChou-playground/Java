package com.rohim.mvnplugin;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Mojo;

@Mojo(name = "sayhitorukis")
public class GreetingRukisMojo extends AbstractMojo {
    public void execute() throws MojoExecutionException {
        getLog().info("============ Hello Rukis ============");
    }
}