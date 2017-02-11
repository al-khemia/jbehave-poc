package com.jbehavepoc.stories;

import com.jbehavepoc.selenium.steps.RegistrationInDemoQASteps;
import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.condition.ConditionRunner;
import org.jbehave.core.Embeddable;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.i18n.LocalizedKeywords;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.model.ExamplesTableFactory;
import org.jbehave.core.parsers.RegexStoryParser;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.jbehave.core.steps.ParameterConverters;
import org.jbehave.core.steps.SilentStepMonitor;
import org.jbehave.web.selenium.*;

import java.text.SimpleDateFormat;
import java.util.List;

import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;
import static org.jbehave.core.reporters.StoryReporterBuilder.Format.CONSOLE;
import static org.jbehave.core.reporters.StoryReporterBuilder.Format.TXT;
import static org.jbehave.core.reporters.StoryReporterBuilder.Format.HTML;
import static org.jbehave.core.reporters.StoryReporterBuilder.Format.XML;

/**
 * Created by gvalencia on 2/10/2017.
 */
public class SeleniumStory extends JUnitStories {

    private static final String STORY_PATH = "**/selenium/stories/*.story";
    private static final String EXCLUDED_PATH = "**/selenium/stories/excluded/*.story";

    private Selenium selenium = SeleniumConfiguration.defaultSelenium();
    private ConditionRunner conditionRunner = SeleniumConfiguration.defaultConditionRunner(selenium);
    private SeleniumSteps lifecycleSteps = new PerStorySeleniumSteps(selenium);
    private SeleniumContext seleniumContext = new SeleniumContext();

    @Override
    public Configuration configuration() {
        Class<? extends Embeddable> embeddableClass = this.getClass();
        return new SeleniumConfiguration()
                .useSelenium(selenium)
                .useSeleniumContext(seleniumContext)
                .useStepMonitor(new SeleniumStepMonitor(selenium, seleniumContext, new SilentStepMonitor()))
                .useStoryLoader(new LoadFromClasspath(embeddableClass))
                .useStoryReporterBuilder(new StoryReporterBuilder()
                        .withCodeLocation(codeLocationFromClass(embeddableClass))
                        .withDefaultFormats()
                        .withFormats(CONSOLE, TXT, HTML, XML));
    }

    @Override
    public InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory(configuration(), new RegistrationInDemoQASteps());
    }

    @Override
    protected List<String> storyPaths() {
        return new StoryFinder()
                .findPaths(codeLocationFromClass(this.getClass()), STORY_PATH, EXCLUDED_PATH);
    }
}
