package org.tobbaumann.tabris.sandbox;

import static com.google.common.base.Objects.equal;
import static com.google.common.base.Objects.toStringHelper;

import java.util.List;

import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;

class Task {
	
	private final String start;
	private final String end;
	private final String subject;

	Task(String start, String end, String subject) {
		this.start = start;
		this.end = end;
		this.subject = subject;
	}

	List<String> asList() {
		return ImmutableList.of(start, end, subject);
	}
	
	String getStart() {
		return start;
	}

	String getEnd() {
		return end;
	}

	String getSubject() {
		return subject;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Task) {
			Task that = (Task) o;
			return equal(this.start, that.start) && equal(this.end, that.end)
					&& equal(this.subject, that.subject);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(start, end, subject);
	}
	
	@Override
	public String toString() {
		return toStringHelper(this)
				.add("start", start)
				.add("end", end)
				.add("subject", subject)
				.toString();
	}
}