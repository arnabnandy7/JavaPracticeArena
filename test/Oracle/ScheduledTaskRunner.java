//package test.Oracle;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//
///**
// * @author arnab
// *
// */
//@Component
//public class ScheduledTaskRunner {
//
//    @Autowired
//    @Qualifier("TempFilesCleanerExecution")
//    private ScheduledTask tempDataCleanerExecution;
//
//    @Scheduled(fixedDelay = TempFilesCleanerExecution.INTERVAL_TO_RUN_TMP_CLEAN_MS /* 1000 */)
//    public void performCleanTempData() {
//        tempDataCleanerExecution.execute();
//    }
//
//}
