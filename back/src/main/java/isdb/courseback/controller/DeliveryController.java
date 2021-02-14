package isdb.courseback.controller;

import isdb.courseback.model.Equipment;
import isdb.courseback.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/delivery")
public class DeliveryController {

    private DeliveryService deliveryService;

    @Autowired
    public DeliveryController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @GetMapping("/do/{minerId}")
    public ResponseEntity<String> addDelivering(@PathVariable @RequestBody int minerId) {
        String message = this.deliveryService.doDelivery(minerId);
        if (message.contains("[")) {
            return ResponseEntity.status(HttpStatus.OK).body(message);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
    }

    @GetMapping("/all/equipment/{brigadeId}")
    public ResponseEntity<Equipment> findAllDeliveryEquipments(@PathVariable @RequestBody int brigadeId) {
        return null;
    }
}
