package eu.programit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eu.programit.domain.Category;
import eu.programit.domain.Question;
import eu.programit.repository.TestResultRepository;
import junit.framework.TestResult;
@Service
public class TestResultService implements ITestResultService {
    @Autowired
    TestResultRepository testResultRepository;

    @Override
    public TestResult saveTestResult(TestResult testResult) {
        return testResultRepository.save(testResult);
    }
    @Override
	public TestResult findById(int examID) {
		// TODO Auto-generated method stub
		return testResultRepository.findOne(examID);
	}
	@Override
	public Iterable<TestResult> findAll() {
		Iterable<TestResult> result = this.testResultRepository.findAll();
		
		return result;
	}


//    @Override
//    public Iterable<Answer> findAllByQuestion(Question question) {
//        Iterable<Answer> itr = answerRepository.findAllByQuestion(question);
//
//        return itr ;
//    }
}
