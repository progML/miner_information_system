package isdb.courseback.controller;

import isdb.courseback.model.Counter;
import isdb.courseback.service.CounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/counter/")
public class CounterController {

    private CounterService counterService;

    @Autowired
    public CounterController(CounterService counterService) {
        this.counterService = counterService;
    }

    @GetMapping("all")
    public ResponseEntity<List<Counter>> findAllCounters() {
        return new ResponseEntity<>(this.counterService.findAllCounter(), HttpStatus.OK);
    }
}
