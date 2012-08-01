package org.tobbaumann.tabris.sandbox;


import java.util.Arrays;
import java.util.List;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.rwt.lifecycle.WidgetUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

import com.google.common.collect.ImmutableList;

public class Application extends Shell {

	public Application(Display display) {
		super(display, SWT.SHELL_TRIM);
		createContents();
	}

	protected void createContents() {
		setText("Sandbox");
		setSize(450, 300);
		setLayout(new FillLayout());

		Table table = new Table(this, SWT.SINGLE | SWT.FULL_SELECTION | SWT.H_SCROLL | SWT.V_SCROLL);
		table.setData(WidgetUtil.CUSTOM_VARIANT, "sandbox");
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		TableViewer viewer = new TableViewer(table);
		List<String> cols = Arrays.asList("Start", "End", "Subject");
		for (String title : cols) {
			TableColumn col = new TableColumn(viewer.getTable(), SWT.NONE);
			col.setData(WidgetUtil.CUSTOM_VARIANT, "sandbox");
			col.setText(title);
		}
		viewer.setContentProvider(new ArrayContentProvider());
		viewer.setLabelProvider(new TasksLabelProvider());
		viewer.setInput(createModel());
		packTable(table);
	}

	private List<Task> createModel() {
		return ImmutableList.of(
			new Task("2012-07-15", "2012-08-05", "Write another prototype"),
			new Task("2012-08-01", "2012-08-05", "Evaluate written prototypes"),
			new Task("2012-08-01", "2012-08-05", "Prepare presentation."));
	}

	private void packTable(Table table) {
		for (TableColumn col : table.getColumns()) {
			col.pack();
		}
		
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
	
	
	
	private static class TasksLabelProvider extends LabelProvider implements ITableLabelProvider {

		@Override
		public Image getColumnImage(Object elem, int arg1) {
			return null;
		}

		@Override
		public String getColumnText(Object elem, int columnIndex) {
			return ((Task)elem).asList().get(columnIndex);
		}

	}

}
