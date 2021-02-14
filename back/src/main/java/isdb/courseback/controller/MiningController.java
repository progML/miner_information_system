package isdb.courseback.controller;

import isdb.courseback.dto.MessageMinerDto;
import isdb.courseback.model.Mining;
import isdb.courseback.service.MiningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/mining/")
public class MiningController {

    private MiningService miningService;

    @Autowired
    public MiningController(MiningService miningService) {
        this.miningService = miningService;
    }

    @GetMapping("all/{id}")
    public ResponseEntity<List<Mining>> findAllMinings(@PathVariable @RequestBody int id) {
        return new ResponseEntity<>(this.miningService.findAllMinings(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addMining(@RequestBody Mining mining) {
        miningService.addMining(mining);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
