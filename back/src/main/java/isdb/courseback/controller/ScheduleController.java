package isdb.courseback.controller;

import isdb.courseback.model.Schedule;
import isdb.courseback.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/schedule")
public class ScheduleController {

    private ScheduleService scheduleService;

    @Autowired
    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @GetMapping("/all/{id}")
    public ResponseEntity<List<Schedule>> showSchedule(@PathVariable @RequestBody int id) {
        return new ResponseEntity<>(scheduleService.showAllSchedule(id), HttpStatus.OK);
    }
}
