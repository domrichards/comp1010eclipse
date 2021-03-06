package samplePracExams.pracExam3;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@SuppressWarnings("unused")
public @interface Graded {
	String description();
	int marks();
}
