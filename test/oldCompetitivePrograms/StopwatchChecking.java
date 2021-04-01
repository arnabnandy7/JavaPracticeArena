package test.oldCompetitivePrograms;

import java.util.logging.Logger;

import com.google.common.base.Stopwatch;

public class StopwatchChecking {

	public static void main(String[] args) {
		Logger logger = Logger
				.getLogger("StopwatchCheckingForPerformanceCheck");
		// TODO Auto-generated method stub
		Stopwatch stopwatch = Stopwatch.createStarted();
		// Here goes your DAO Call
		stopwatch.stop();
		logger.info("Total Time elapsed::" + stopwatch);
		
		
	}

}
