package com.jbehavepoc.runners;

import com.jbehavepoc.selenium.steps.Registration;
import org.jbehave.core.Embeddable;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.StoryPathResolver;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;

/**
 * Created by Lina on 19/02/2017.
 */
public class RegistrationStory {

    @Override
    public Configuration configuration(){
        return new MostUsefulConfiguration()
                .useStoryReporterBuilder(
                        new StoryReporterBuilder()
                                .withDefaultFormats()
                                .withFormats(Format.CONSOLE, Format.HTML))
                .useStoryPathResolver(new StoryPathResolver() {
                    @Override
                    public String resolve(Class<? extends Embeddable> embeddableClass) {
                        return "selenium/stories/Registration.story";
                    }
                });
    }

    @Override
    public InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory(configuration()
                , new Registration());
    }


}
