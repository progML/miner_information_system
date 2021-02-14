package isdb.courseback.controller;

import isdb.courseback.dto.MessageMinerDto;
import isdb.courseback.model.MessageMiner;
import isdb.courseback.service.MessageMinerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/message/")
public class MessageMinerController {

    private MessageMinerService messageMinerService;

    @Autowired
    public MessageMinerController(MessageMinerService messageMinerService) {
        this.messageMinerService = messageMinerService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addMesage(@RequestBody MessageMinerDto messageMinerDto) {
        if (messageMinerService.addMessage(messageMinerDto)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("all/{minerId}")
    public ResponseEntity<List<MessageMiner>> showAllMinerMesages(@PathVariable int minerId) {
        return new ResponseEntity<>(messageMinerService.showAllMinerMessages(minerId), HttpStatus.OK);
    }


}
