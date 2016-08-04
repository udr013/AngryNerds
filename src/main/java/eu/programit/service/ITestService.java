package eu.programit.service;

import eu.programit.domain.Test;

/**
 * Created by udr013 on 23-6-2016.
 */
public interface ITestService {
    Test findById(int testId);

    Iterable<Test> findAll();

    Test saveTestViews(Test test);
}
