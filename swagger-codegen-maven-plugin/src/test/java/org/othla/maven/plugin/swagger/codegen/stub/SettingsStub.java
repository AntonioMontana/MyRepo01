package org.othla.maven.plugin.swagger.codegen.stub;

import java.util.Collections;
import java.util.List;

import org.apache.maven.settings.Settings;

public class SettingsStub extends Settings
{
    /** {@inheritDoc} */
    public List getProxies() {
        return Collections.EMPTY_LIST;
    }
}
