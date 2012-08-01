package org.tobbaumann.tabris.sandbox;

import java.util.Map;

import org.eclipse.rwt.application.Application;
import org.eclipse.rwt.application.Application.OperationMode;
import org.eclipse.rwt.application.ApplicationConfiguration;
import org.eclipse.rwt.client.WebClient;

import com.google.common.collect.ImmutableMap;

public class Configuration implements ApplicationConfiguration {

	@Override
	public void configure(Application application) {
		//Bootstrapper.bootstrap(application);
		application.setOperationMode(OperationMode.SWT_COMPATIBILITY);
		application.addStyleSheet("SandboxTheme", "sandbox.css");
		application.addStyleSheet("SandboxTheme", "sandbox-table.css");
		Map<String, String> properties = ImmutableMap.of(WebClient.THEME_ID, "SandboxTheme");
		application.addEntryPoint("/sandbox", EntryPoint.class, properties);
	}

}
