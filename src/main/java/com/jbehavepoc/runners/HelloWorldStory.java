package com.jbehavepoc.runners;

import com.jbehavepoc.helloworld.steps.HelloWorldSteps;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;

import java.util.List;

import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;

public class HelloWorldStory extends JUnitStories {

    private static final String STORY_PATH = "**/helloworld/stories/*.story";
    private static final String EXCLUDED_PATH = "**/helloworld/stories/excluded/*.story";

    @Override
    public Configuration configuration(){
        return new MostUsefulConfiguration()
                .useStoryReporterBuilder(
                        new StoryReporterBuilder()
                                .withDefaultFormats()
                                .withFormats(Format.CONSOLE, Format.TXT)
                );
    }

    @Override
    public InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory(configuration(),
                new HelloWorldSteps());
    }

    @Override
    protected List<String> storyPaths() {
        return new StoryFinder()
                .findPaths(codeLocationFromClass(this.getClass()), STORY_PATH, EXCLUDED_PATH);
    }
}