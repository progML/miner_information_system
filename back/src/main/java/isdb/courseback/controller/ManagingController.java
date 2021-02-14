package isdb.courseback.controller;


import isdb.courseback.dto.MinerPartResponse;
import isdb.courseback.model.BrigadeRecord;
import isdb.courseback.service.ManagingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/managing") //нужна методам вашего контроллера, по которым они будут доступны на клиенте.
public class ManagingController  {

    private ManagingService managingService;

    @Autowired
    public  ManagingController(ManagingService managingService){
        this.managingService = managingService;
    }

    @GetMapping("/miners")
    public ResponseEntity showMiners(){
        return new ResponseEntity<>(managingService.showMiners(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<BrigadeRecord> addMagazine(@RequestBody BrigadeRecord brigadeRecord) {
        return new ResponseEntity<>(managingService.addBrigadeRecord(brigadeRecord), HttpStatus.OK);
    }


    @GetMapping("/mg/{id}")
    public ResponseEntity<List<MinerPartResponse>> showManagingByBrigadeId(@PathVariable @RequestBody int id){
        return new ResponseEntity<>(managingService.showManagingByBrigadeId(id), HttpStatus.OK);
    }

    @GetMapping("/delete/{minerId}")
    public ResponseEntity<String> DeleteByMinerId(@PathVariable(value = "minerId") int minerId){
        managingService.deleteBrigadeRecord(minerId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
