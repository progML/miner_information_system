package isdb.courseback.service;

import isdb.courseback.model.Counter;
import isdb.courseback.repository.CounterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CounterService {

    private CounterRepository counterRepository;

    @Autowired
    public CounterService(CounterRepository counterRepository) {
        this.counterRepository = counterRepository;
    }

    public List<Counter> findAllCounter() {
        return (List<Counter>) this.counterRepository.findAll();
    }

}
