package org.openhab.binding.max.internal;

import java.net.URI;
import java.util.Collection;
import java.util.Collections;
import java.util.Locale;

import org.eclipse.smarthome.config.core.ConfigOptionProvider;
import org.eclipse.smarthome.config.core.ParameterOption;
import org.eclipse.smarthome.core.thing.ThingTypeUID;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(service = ConfigOptionProvider.class, immediate = true)
public class MaxConfigProvider implements ConfigOptionProvider {

    private static final Object PROPERTY_TYPE_NAME = "abc";
    private final static Logger logger = LoggerFactory.getLogger(MaxConfigProvider.class);

    @Override
    public Collection<ParameterOption> getParameterOptions(URI uri, String param, Locale locale) {
        // Collection<ParameterOption> col =super.getParameterOptions( uri, param, locale);

        logger.debug("MAX Collection URI {}", uri);
        logger.debug("MAX Collection param {}", param);
        logger.debug("MAX Collection locale {}", locale);

        if ("thing-type".equals(uri.getScheme())) {
            ThingTypeUID thingtypeUID = new ThingTypeUID(uri.getSchemeSpecificPart());
            if (thingtypeUID.equals(MaxBindingConstants.CUBEBRIDGE_THING_TYPE) && PROPERTY_TYPE_NAME.equals(param)) {
                // return myoptions();
            }
        }
        /*
         * try {
         * Collection<ParameterOption> col =super( uri, param, locale);
         * for (ParameterOption c :col) {
         * logger.debug(c); }
         *
         * } catch (Error e) {
         * Debug.println(arg0, arg1);
         *
         */
        return Collections.emptyList();
    }
}
