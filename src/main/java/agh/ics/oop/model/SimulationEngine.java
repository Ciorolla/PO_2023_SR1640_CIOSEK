package agh.ics.oop.model;

import agh.ics.oop.Simulation;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SimulationEngine {
    private List<Simulation> simulationsList;
    private ExecutorService executorService = Executors.newFixedThreadPool(4);
    private List<Thread> simulationsThreadList = new ArrayList<>();

    public SimulationEngine(List<Simulation> simulationsList){
        this.simulationsList=simulationsList;
    }

    public void runSync(){
        simulationsList.forEach((singleSim) -> singleSim.run());
    }

    public void runAsync(){
//        simulationsList.forEach((singleSim) -> executorService.submit(singleSim));
//        executorService.shutdown();
        simulationsList.forEach((singleSim) -> simulationsThreadList.add(new Thread(singleSim)));
        simulationsThreadList.forEach((simThread) -> simThread.start());


    }

//    public void awaitSimulationsEnd(){
//        simulationsThreadList.forEach((simThread) -> {
//            try {
//                simThread.join();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//    }
//

    public void awaitSimulationsEnd() throws InterruptedException {
        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.SECONDS);
    }
    public void runAsyncInThreadPool(){
        simulationsList.forEach((singleSim) -> executorService.submit(singleSim));

    }


}
