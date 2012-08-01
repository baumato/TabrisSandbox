package org.tobbaumann.tabris.sandbox;

import org.eclipse.rwt.lifecycle.IEntryPoint;
import org.eclipse.swt.widgets.Display;

public class EntryPoint implements IEntryPoint {

	@Override
	public int createUI() {
		Display display = new Display();
		Application shell = new Application(display);
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		return 0;
	}
}
