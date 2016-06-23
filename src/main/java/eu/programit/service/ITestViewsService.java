package eu.programit.service;

import eu.programit.domain.TestViews;

/**
 * Created by udr013 on 23-6-2016.
 */
public interface ITestViewsService {
    TestViews findById(int testviewId);

    Iterable<TestViews> findAll();

    TestViews saveTestViews(TestViews testViews);
}
